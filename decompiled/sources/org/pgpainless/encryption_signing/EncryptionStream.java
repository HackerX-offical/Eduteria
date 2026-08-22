package org.pgpainless.encryption_signing;

import java.io.IOException;
import java.io.OutputStream;
import java.util.Collections;
import java.util.Date;
import java.util.Iterator;
import java.util.Map;
import java.util.Set;
import java.util.concurrent.ConcurrentHashMap;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.annotation.Nonnull;
import org.bouncycastle.bcpg.ArmoredOutputStream;
import org.bouncycastle.bcpg.BCPGOutputStream;
import org.bouncycastle.openpgp.PGPCompressedDataGenerator;
import org.bouncycastle.openpgp.PGPEncryptedDataGenerator;
import org.bouncycastle.openpgp.PGPException;
import org.bouncycastle.openpgp.PGPLiteralDataGenerator;
import org.bouncycastle.openpgp.PGPPrivateKey;
import org.bouncycastle.openpgp.PGPPublicKey;
import org.bouncycastle.openpgp.PGPSignature;
import org.bouncycastle.openpgp.PGPSignatureGenerator;
import org.bouncycastle.openpgp.operator.bc.BcPGPContentSignerBuilder;
import org.bouncycastle.openpgp.operator.bc.BcPGPDataEncryptorBuilder;
import org.bouncycastle.openpgp.operator.bc.BcPublicKeyKeyEncryptionMethodGenerator;
import org.pgpainless.algorithm.CompressionAlgorithm;
import org.pgpainless.algorithm.HashAlgorithm;
import org.pgpainless.algorithm.SymmetricKeyAlgorithm;
import org.pgpainless.decryption_verification.DetachedSignature;
import org.pgpainless.decryption_verification.OpenPgpMetadata;
import org.pgpainless.key.OpenPgpV4Fingerprint;

/* JADX INFO: loaded from: classes10.dex */
public final class EncryptionStream extends OutputStream {
    private static final int BUFFER_SIZE = 256;
    private final boolean asciiArmor;
    private BCPGOutputStream basicCompressionStream;
    private PGPCompressedDataGenerator compressedDataGenerator;
    private final CompressionAlgorithm compressionAlgorithm;
    private final boolean detachedSignature;
    private final Set<PGPPublicKey> encryptionKeys;
    private final HashAlgorithm hashAlgorithm;
    private PGPLiteralDataGenerator literalDataGenerator;
    private OutputStream literalDataStream;
    OutputStream outermostStream;
    private final Map<OpenPgpV4Fingerprint, PGPPrivateKey> signingKeys;
    private final SymmetricKeyAlgorithm symmetricKeyAlgorithm;
    private static final Logger LOGGER = Logger.getLogger(EncryptionStream.class.getName());
    private static final Level LEVEL = Level.FINE;
    private final OpenPgpMetadata.Builder resultBuilder = OpenPgpMetadata.getBuilder();
    private Map<OpenPgpV4Fingerprint, PGPSignatureGenerator> signatureGenerators = new ConcurrentHashMap();
    private boolean closed = false;
    private ArmoredOutputStream armorOutputStream = null;
    private OutputStream publicKeyEncryptedStream = null;

    EncryptionStream(@Nonnull OutputStream outputStream, @Nonnull Set<PGPPublicKey> set, boolean z, @Nonnull Map<OpenPgpV4Fingerprint, PGPPrivateKey> map, @Nonnull SymmetricKeyAlgorithm symmetricKeyAlgorithm, @Nonnull HashAlgorithm hashAlgorithm, @Nonnull CompressionAlgorithm compressionAlgorithm, boolean z2) throws IOException, PGPException {
        this.outermostStream = null;
        this.symmetricKeyAlgorithm = symmetricKeyAlgorithm;
        this.hashAlgorithm = hashAlgorithm;
        this.compressionAlgorithm = compressionAlgorithm;
        this.encryptionKeys = Collections.unmodifiableSet(set);
        this.detachedSignature = z;
        this.signingKeys = Collections.unmodifiableMap(map);
        this.asciiArmor = z2;
        this.outermostStream = outputStream;
        prepareArmor();
        prepareEncryption();
        prepareSigning();
        prepareCompression();
        prepareOnePassSignatures();
        prepareLiteralDataProcessing();
        prepareResultBuilder();
    }

    private void prepareArmor() {
        if (!this.asciiArmor) {
            LOGGER.log(LEVEL, "Encryption output will be binary");
            return;
        }
        LOGGER.log(LEVEL, "Wrap encryption output in ASCII armor");
        ArmoredOutputStream armoredOutputStream = new ArmoredOutputStream(this.outermostStream);
        this.armorOutputStream = armoredOutputStream;
        this.outermostStream = armoredOutputStream;
    }

    private void prepareEncryption() throws IOException, PGPException {
        if (this.encryptionKeys.isEmpty()) {
            return;
        }
        LOGGER.log(LEVEL, "At least one encryption key is available -> encrypt using " + this.symmetricKeyAlgorithm);
        BcPGPDataEncryptorBuilder bcPGPDataEncryptorBuilder = new BcPGPDataEncryptorBuilder(this.symmetricKeyAlgorithm.getAlgorithmId());
        bcPGPDataEncryptorBuilder.setWithIntegrityPacket(true);
        PGPEncryptedDataGenerator pGPEncryptedDataGenerator = new PGPEncryptedDataGenerator(bcPGPDataEncryptorBuilder);
        for (PGPPublicKey pGPPublicKey : this.encryptionKeys) {
            LOGGER.log(LEVEL, "Encrypt for key " + Long.toHexString(pGPPublicKey.getKeyID()));
            pGPEncryptedDataGenerator.addMethod(new BcPublicKeyKeyEncryptionMethodGenerator(pGPPublicKey));
        }
        OutputStream outputStreamOpen = pGPEncryptedDataGenerator.open(this.outermostStream, new byte[256]);
        this.publicKeyEncryptedStream = outputStreamOpen;
        this.outermostStream = outputStreamOpen;
    }

    private void prepareSigning() throws PGPException {
        if (this.signingKeys.isEmpty()) {
            return;
        }
        LOGGER.log(LEVEL, "At least one signing key is available -> sign " + this.hashAlgorithm + " hash of message");
        for (OpenPgpV4Fingerprint openPgpV4Fingerprint : this.signingKeys.keySet()) {
            PGPPrivateKey pGPPrivateKey = this.signingKeys.get(openPgpV4Fingerprint);
            LOGGER.log(LEVEL, "Sign using key " + ((Object) openPgpV4Fingerprint));
            PGPSignatureGenerator pGPSignatureGenerator = new PGPSignatureGenerator(new BcPGPContentSignerBuilder(pGPPrivateKey.getPublicKeyPacket().getAlgorithm(), this.hashAlgorithm.getAlgorithmId()));
            pGPSignatureGenerator.init(0, pGPPrivateKey);
            this.signatureGenerators.put(openPgpV4Fingerprint, pGPSignatureGenerator);
        }
    }

    private void prepareCompression() throws IOException {
        LOGGER.log(LEVEL, "Compress using " + this.compressionAlgorithm);
        this.compressedDataGenerator = new PGPCompressedDataGenerator(this.compressionAlgorithm.getAlgorithmId());
        this.basicCompressionStream = new BCPGOutputStream(this.compressedDataGenerator.open(this.outermostStream));
    }

    private void prepareOnePassSignatures() throws IOException, PGPException {
        Iterator<PGPSignatureGenerator> it = this.signatureGenerators.values().iterator();
        while (it.hasNext()) {
            it.next().generateOnePassVersion(false).encode(this.basicCompressionStream);
        }
    }

    private void prepareLiteralDataProcessing() throws IOException {
        PGPLiteralDataGenerator pGPLiteralDataGenerator = new PGPLiteralDataGenerator();
        this.literalDataGenerator = pGPLiteralDataGenerator;
        this.literalDataStream = pGPLiteralDataGenerator.open((OutputStream) this.basicCompressionStream, 'b', "_CONSOLE", new Date(), new byte[256]);
    }

    private void prepareResultBuilder() {
        Iterator<PGPPublicKey> it = this.encryptionKeys.iterator();
        while (it.hasNext()) {
            this.resultBuilder.addRecipientKeyId(Long.valueOf(it.next().getKeyID()));
        }
        this.resultBuilder.setSymmetricKeyAlgorithm(this.symmetricKeyAlgorithm);
        this.resultBuilder.setCompressionAlgorithm(this.compressionAlgorithm);
    }

    @Override // java.io.OutputStream
    public void write(int i) throws IOException {
        this.literalDataStream.write(i);
        Iterator<PGPSignatureGenerator> it = this.signatureGenerators.values().iterator();
        while (it.hasNext()) {
            it.next().update((byte) (i & 255));
        }
    }

    @Override // java.io.OutputStream
    public void write(byte[] bArr) throws IOException {
        write(bArr, 0, bArr.length);
    }

    @Override // java.io.OutputStream
    public void write(byte[] bArr, int i, int i2) throws IOException {
        this.literalDataStream.write(bArr, 0, i2);
        Iterator<PGPSignatureGenerator> it = this.signatureGenerators.values().iterator();
        while (it.hasNext()) {
            it.next().update(bArr, 0, i2);
        }
    }

    @Override // java.io.OutputStream, java.io.Flushable
    public void flush() throws IOException {
        this.literalDataStream.flush();
    }

    @Override // java.io.OutputStream, java.io.Closeable, java.lang.AutoCloseable
    public void close() throws IOException {
        if (this.closed) {
            return;
        }
        this.literalDataStream.flush();
        this.literalDataStream.close();
        this.literalDataGenerator.close();
        writeSignatures();
        this.compressedDataGenerator.close();
        OutputStream outputStream = this.publicKeyEncryptedStream;
        if (outputStream != null) {
            outputStream.flush();
            this.publicKeyEncryptedStream.close();
        }
        ArmoredOutputStream armoredOutputStream = this.armorOutputStream;
        if (armoredOutputStream != null) {
            armoredOutputStream.flush();
            this.armorOutputStream.close();
        }
        this.closed = true;
    }

    private void writeSignatures() throws IOException {
        for (OpenPgpV4Fingerprint openPgpV4Fingerprint : this.signatureGenerators.keySet()) {
            try {
                PGPSignature pGPSignatureGenerate = this.signatureGenerators.get(openPgpV4Fingerprint).generate();
                if (!this.detachedSignature) {
                    pGPSignatureGenerate.encode(this.basicCompressionStream);
                }
                this.resultBuilder.addDetachedSignature(new DetachedSignature(pGPSignatureGenerate, openPgpV4Fingerprint));
            } catch (PGPException e2) {
                throw new IOException(e2);
            }
        }
    }

    public OpenPgpMetadata getResult() {
        if (!this.closed) {
            throw new IllegalStateException("EncryptionStream must be closed before accessing the Result.");
        }
        return this.resultBuilder.build();
    }
}
