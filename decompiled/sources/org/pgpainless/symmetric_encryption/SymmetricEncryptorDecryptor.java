package org.pgpainless.symmetric_encryption;

import java.io.BufferedInputStream;
import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.security.SecureRandom;
import java.util.Date;
import javax.annotation.Nonnull;
import org.bouncycastle.openpgp.PGPCompressedData;
import org.bouncycastle.openpgp.PGPCompressedDataGenerator;
import org.bouncycastle.openpgp.PGPEncryptedDataGenerator;
import org.bouncycastle.openpgp.PGPEncryptedDataList;
import org.bouncycastle.openpgp.PGPException;
import org.bouncycastle.openpgp.PGPLiteralData;
import org.bouncycastle.openpgp.PGPLiteralDataGenerator;
import org.bouncycastle.openpgp.PGPPBEEncryptedData;
import org.bouncycastle.openpgp.PGPUtil;
import org.bouncycastle.openpgp.bc.BcPGPObjectFactory;
import org.bouncycastle.openpgp.operator.bc.BcPBEDataDecryptorFactory;
import org.bouncycastle.openpgp.operator.bc.BcPGPDigestCalculatorProvider;
import org.bouncycastle.openpgp.operator.jcajce.JcePBEKeyEncryptionMethodGenerator;
import org.bouncycastle.openpgp.operator.jcajce.JcePGPDataEncryptorBuilder;
import org.bouncycastle.util.io.Streams;
import org.pgpainless.algorithm.CompressionAlgorithm;
import org.pgpainless.algorithm.SymmetricKeyAlgorithm;
import org.pgpainless.provider.ProviderFactory;
import org.pgpainless.util.Passphrase;

/* JADX INFO: loaded from: classes10.dex */
public class SymmetricEncryptorDecryptor {
    public static byte[] symmetricallyEncrypt(@Nonnull byte[] bArr, @Nonnull Passphrase passphrase, @Nonnull SymmetricKeyAlgorithm symmetricKeyAlgorithm, @Nonnull CompressionAlgorithm compressionAlgorithm) throws IOException, PGPException {
        byte[] bArrCompress = compress(bArr, compressionAlgorithm.getAlgorithmId());
        ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
        PGPEncryptedDataGenerator pGPEncryptedDataGenerator = new PGPEncryptedDataGenerator(new JcePGPDataEncryptorBuilder(symmetricKeyAlgorithm.getAlgorithmId()).setWithIntegrityPacket(true).setSecureRandom(new SecureRandom()).setProvider(ProviderFactory.getProvider()));
        pGPEncryptedDataGenerator.addMethod(new JcePBEKeyEncryptionMethodGenerator(passphrase.getChars()).setProvider(ProviderFactory.getProvider()));
        OutputStream outputStreamOpen = pGPEncryptedDataGenerator.open(byteArrayOutputStream, bArrCompress.length);
        outputStreamOpen.write(bArrCompress);
        outputStreamOpen.close();
        return byteArrayOutputStream.toByteArray();
    }

    public static byte[] symmetricallyDecrypt(@Nonnull byte[] bArr, @Nonnull Passphrase passphrase) throws IOException, PGPException {
        PGPEncryptedDataList pGPEncryptedDataList;
        InputStream decoderStream = PGPUtil.getDecoderStream(new BufferedInputStream(new ByteArrayInputStream(bArr)));
        try {
            BcPGPObjectFactory bcPGPObjectFactory = new BcPGPObjectFactory(decoderStream);
            Object objNextObject = bcPGPObjectFactory.nextObject();
            if (objNextObject instanceof PGPEncryptedDataList) {
                pGPEncryptedDataList = (PGPEncryptedDataList) objNextObject;
            } else {
                pGPEncryptedDataList = (PGPEncryptedDataList) bcPGPObjectFactory.nextObject();
            }
            PGPPBEEncryptedData pGPPBEEncryptedData = (PGPPBEEncryptedData) pGPEncryptedDataList.get(0);
            Object objNextObject2 = new BcPGPObjectFactory(pGPPBEEncryptedData.getDataStream(new BcPBEDataDecryptorFactory(passphrase.getChars(), new BcPGPDigestCalculatorProvider()))).nextObject();
            if (objNextObject2 instanceof PGPCompressedData) {
                objNextObject2 = new BcPGPObjectFactory(((PGPCompressedData) objNextObject2).getDataStream()).nextObject();
            }
            InputStream inputStream = ((PGPLiteralData) objNextObject2).getInputStream();
            ByteArrayOutputStream byteArrayOutputStream = null;
            try {
                ByteArrayOutputStream byteArrayOutputStream2 = new ByteArrayOutputStream();
                try {
                    Streams.pipeAll(inputStream, byteArrayOutputStream2);
                    byteArrayOutputStream2.close();
                    decoderStream.close();
                    if (pGPPBEEncryptedData.isIntegrityProtected()) {
                        if (!pGPPBEEncryptedData.verify()) {
                            throw new PGPException("Integrity check failed.");
                        }
                        return byteArrayOutputStream2.toByteArray();
                    }
                    throw new PGPException("Symmetrically encrypted data is not integrity protected.");
                } catch (Throwable th) {
                    th = th;
                    byteArrayOutputStream = byteArrayOutputStream2;
                    if (byteArrayOutputStream != null) {
                        byteArrayOutputStream.close();
                    }
                    throw th;
                }
            } catch (Throwable th2) {
                th = th2;
            }
        } catch (Throwable th3) {
            decoderStream.close();
            throw th3;
        }
    }

    private static byte[] compress(@Nonnull byte[] bArr, int i) throws IOException {
        ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
        PGPCompressedDataGenerator pGPCompressedDataGenerator = new PGPCompressedDataGenerator(i);
        OutputStream outputStreamOpen = new PGPLiteralDataGenerator().open(pGPCompressedDataGenerator.open(byteArrayOutputStream), 'b', "_CONSOLE", bArr.length, new Date());
        outputStreamOpen.write(bArr);
        outputStreamOpen.close();
        pGPCompressedDataGenerator.close();
        return byteArrayOutputStream.toByteArray();
    }
}
