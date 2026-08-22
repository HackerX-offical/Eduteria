package org.pgpainless.decryption_verification;

import java.io.IOException;
import java.io.InputStream;
import java.util.Collections;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.annotation.Nonnull;
import javax.annotation.Nullable;
import org.bouncycastle.openpgp.PGPCompressedData;
import org.bouncycastle.openpgp.PGPEncryptedData;
import org.bouncycastle.openpgp.PGPEncryptedDataList;
import org.bouncycastle.openpgp.PGPException;
import org.bouncycastle.openpgp.PGPLiteralData;
import org.bouncycastle.openpgp.PGPObjectFactory;
import org.bouncycastle.openpgp.PGPOnePassSignature;
import org.bouncycastle.openpgp.PGPOnePassSignatureList;
import org.bouncycastle.openpgp.PGPPrivateKey;
import org.bouncycastle.openpgp.PGPPublicKey;
import org.bouncycastle.openpgp.PGPPublicKeyEncryptedData;
import org.bouncycastle.openpgp.PGPPublicKeyRing;
import org.bouncycastle.openpgp.PGPSecretKey;
import org.bouncycastle.openpgp.PGPSecretKeyRingCollection;
import org.bouncycastle.openpgp.PGPSignature;
import org.bouncycastle.openpgp.PGPUtil;
import org.bouncycastle.openpgp.operator.KeyFingerPrintCalculator;
import org.bouncycastle.openpgp.operator.PGPContentVerifierBuilderProvider;
import org.bouncycastle.openpgp.operator.bc.BcKeyFingerprintCalculator;
import org.bouncycastle.openpgp.operator.bc.BcPGPContentVerifierBuilderProvider;
import org.bouncycastle.openpgp.operator.bc.BcPublicKeyDataDecryptorFactory;
import org.pgpainless.algorithm.CompressionAlgorithm;
import org.pgpainless.algorithm.SymmetricKeyAlgorithm;
import org.pgpainless.decryption_verification.OpenPgpMetadata;
import org.pgpainless.key.OpenPgpV4Fingerprint;
import org.pgpainless.key.protection.SecretKeyRingProtector;

/* JADX INFO: loaded from: classes10.dex */
public final class DecryptionStreamFactory {
    private final SecretKeyRingProtector decryptionKeyDecryptor;
    private final PGPSecretKeyRingCollection decryptionKeys;
    private final KeyFingerPrintCalculator keyFingerprintCalculator;
    private final MissingPublicKeyCallback missingPublicKeyCallback;
    private final OpenPgpMetadata.Builder resultBuilder;
    private final Map<OpenPgpV4Fingerprint, OnePassSignature> verifiableOnePassSignatures;
    private final Set<PGPPublicKeyRing> verificationKeys;
    private final PGPContentVerifierBuilderProvider verifierBuilderProvider;
    private static final Logger LOGGER = Logger.getLogger(DecryptionStreamFactory.class.getName());
    private static final Level LEVEL = Level.FINE;

    private DecryptionStreamFactory(@Nullable PGPSecretKeyRingCollection pGPSecretKeyRingCollection, @Nullable SecretKeyRingProtector secretKeyRingProtector, @Nullable Set<PGPPublicKeyRing> set, @Nullable MissingPublicKeyCallback missingPublicKeyCallback) {
        HashSet hashSet = new HashSet();
        this.verificationKeys = hashSet;
        this.resultBuilder = OpenPgpMetadata.getBuilder();
        this.verifierBuilderProvider = new BcPGPContentVerifierBuilderProvider();
        this.keyFingerprintCalculator = new BcKeyFingerprintCalculator();
        this.verifiableOnePassSignatures = new HashMap();
        this.decryptionKeys = pGPSecretKeyRingCollection;
        this.decryptionKeyDecryptor = secretKeyRingProtector;
        hashSet.addAll(set == null ? Collections.emptyList() : set);
        this.missingPublicKeyCallback = missingPublicKeyCallback;
    }

    public static DecryptionStream create(@Nonnull InputStream inputStream, @Nullable PGPSecretKeyRingCollection pGPSecretKeyRingCollection, @Nullable SecretKeyRingProtector secretKeyRingProtector, @Nullable List<PGPSignature> list, @Nullable Set<PGPPublicKeyRing> set, @Nullable MissingPublicKeyCallback missingPublicKeyCallback) throws IOException, PGPException {
        DecryptionStreamFactory decryptionStreamFactory = new DecryptionStreamFactory(pGPSecretKeyRingCollection, secretKeyRingProtector, set, missingPublicKeyCallback);
        if (list != null) {
            for (PGPSignature pGPSignature : list) {
                PGPPublicKey pGPPublicKeyFindSignatureVerificationKey = decryptionStreamFactory.findSignatureVerificationKey(pGPSignature.getKeyID());
                pGPSignature.init(new BcPGPContentVerifierBuilderProvider(), pGPPublicKeyFindSignatureVerificationKey);
                decryptionStreamFactory.resultBuilder.addDetachedSignature(new DetachedSignature(pGPSignature, new OpenPgpV4Fingerprint(pGPPublicKeyFindSignatureVerificationKey)));
            }
        } else {
            inputStream = decryptionStreamFactory.processPGPPackets(new PGPObjectFactory(PGPUtil.getDecoderStream(inputStream), new BcKeyFingerprintCalculator()));
        }
        return new DecryptionStream(inputStream, decryptionStreamFactory.resultBuilder);
    }

    private InputStream processPGPPackets(@Nonnull PGPObjectFactory pGPObjectFactory) throws IOException, PGPException {
        Object objNextObject;
        do {
            objNextObject = pGPObjectFactory.nextObject();
            if (objNextObject != null) {
                if (objNextObject instanceof PGPEncryptedDataList) {
                    return processPGPEncryptedDataList((PGPEncryptedDataList) objNextObject);
                }
                if (objNextObject instanceof PGPCompressedData) {
                    return processPGPCompressedData((PGPCompressedData) objNextObject);
                }
                if (objNextObject instanceof PGPOnePassSignatureList) {
                    return processOnePassSignatureList(pGPObjectFactory, (PGPOnePassSignatureList) objNextObject);
                }
            } else {
                throw new PGPException("No Literal Data Packet found");
            }
        } while (!(objNextObject instanceof PGPLiteralData));
        return processPGPLiteralData(pGPObjectFactory, (PGPLiteralData) objNextObject);
    }

    private InputStream processPGPEncryptedDataList(PGPEncryptedDataList pGPEncryptedDataList) throws IOException, PGPException {
        LOGGER.log(LEVEL, "Encountered PGPEncryptedDataList");
        return processPGPPackets(new PGPObjectFactory(PGPUtil.getDecoderStream(decrypt(pGPEncryptedDataList)), this.keyFingerprintCalculator));
    }

    private InputStream processPGPCompressedData(PGPCompressedData pGPCompressedData) throws IOException, PGPException {
        CompressionAlgorithm compressionAlgorithmFromId = CompressionAlgorithm.fromId(pGPCompressedData.getAlgorithm());
        LOGGER.log(LEVEL, "Encountered PGPCompressedData: " + compressionAlgorithmFromId);
        this.resultBuilder.setCompressionAlgorithm(compressionAlgorithmFromId);
        return processPGPPackets(new PGPObjectFactory(PGPUtil.getDecoderStream(pGPCompressedData.getDataStream()), this.keyFingerprintCalculator));
    }

    private InputStream processOnePassSignatureList(@Nonnull PGPObjectFactory pGPObjectFactory, PGPOnePassSignatureList pGPOnePassSignatureList) throws IOException, PGPException {
        LOGGER.log(LEVEL, "Encountered PGPOnePassSignatureList of size " + pGPOnePassSignatureList.size());
        initOnePassSignatures(pGPOnePassSignatureList);
        return processPGPPackets(pGPObjectFactory);
    }

    private InputStream processPGPLiteralData(@Nonnull PGPObjectFactory pGPObjectFactory, PGPLiteralData pGPLiteralData) {
        Logger logger = LOGGER;
        Level level = LEVEL;
        logger.log(level, "Found PGPLiteralData");
        InputStream inputStream = pGPLiteralData.getInputStream();
        if (this.verifiableOnePassSignatures.isEmpty()) {
            logger.log(level, "No OnePassSignatures found -> We are done");
            return inputStream;
        }
        return new SignatureVerifyingInputStream(inputStream, pGPObjectFactory, this.verifiableOnePassSignatures, this.resultBuilder);
    }

    private InputStream decrypt(@Nonnull PGPEncryptedDataList pGPEncryptedDataList) throws PGPException {
        Iterator<PGPEncryptedData> encryptedDataObjects = pGPEncryptedDataList.getEncryptedDataObjects();
        if (!encryptedDataObjects.hasNext()) {
            throw new PGPException("Decryption failed - EncryptedDataList has no items");
        }
        PGPPrivateKey pGPPrivateKeyExtractPrivateKey = null;
        PGPPublicKeyEncryptedData pGPPublicKeyEncryptedData = null;
        while (encryptedDataObjects.hasNext()) {
            PGPPublicKeyEncryptedData pGPPublicKeyEncryptedData2 = (PGPPublicKeyEncryptedData) encryptedDataObjects.next();
            long keyID = pGPPublicKeyEncryptedData2.getKeyID();
            this.resultBuilder.addRecipientKeyId(Long.valueOf(keyID));
            Logger logger = LOGGER;
            Level level = LEVEL;
            logger.log(level, "PGPEncryptedData is encrypted for key " + Long.toHexString(keyID));
            PGPSecretKey secretKey = this.decryptionKeys.getSecretKey(keyID);
            if (secretKey != null) {
                logger.log(level, "Found respective secret key " + Long.toHexString(keyID));
                pGPPrivateKeyExtractPrivateKey = secretKey.extractPrivateKey(this.decryptionKeyDecryptor.getDecryptor(Long.valueOf(keyID)));
                this.resultBuilder.setDecryptionFingerprint(new OpenPgpV4Fingerprint(secretKey));
                pGPPublicKeyEncryptedData = pGPPublicKeyEncryptedData2;
            }
        }
        if (pGPPrivateKeyExtractPrivateKey == null) {
            throw new PGPException("Decryption failed - No suitable decryption key found");
        }
        BcPublicKeyDataDecryptorFactory bcPublicKeyDataDecryptorFactory = new BcPublicKeyDataDecryptorFactory(pGPPrivateKeyExtractPrivateKey);
        SymmetricKeyAlgorithm symmetricKeyAlgorithmFromId = SymmetricKeyAlgorithm.fromId(pGPPublicKeyEncryptedData.getSymmetricAlgorithm(bcPublicKeyDataDecryptorFactory));
        LOGGER.log(LEVEL, "Message is encrypted using " + symmetricKeyAlgorithmFromId);
        this.resultBuilder.setSymmetricKeyAlgorithm(symmetricKeyAlgorithmFromId);
        this.resultBuilder.setIntegrityProtected(pGPPublicKeyEncryptedData.isIntegrityProtected());
        return pGPPublicKeyEncryptedData.getDataStream(bcPublicKeyDataDecryptorFactory);
    }

    private void initOnePassSignatures(@Nonnull PGPOnePassSignatureList pGPOnePassSignatureList) throws PGPException {
        Iterator<PGPOnePassSignature> it = pGPOnePassSignatureList.iterator();
        if (!it.hasNext()) {
            throw new PGPException("Verification failed - No OnePassSignatures found");
        }
        processOnePassSignatures(it);
    }

    private void processOnePassSignatures(Iterator<PGPOnePassSignature> it) throws PGPException {
        while (it.hasNext()) {
            processOnePassSignature(it.next());
        }
    }

    private void processOnePassSignature(PGPOnePassSignature pGPOnePassSignature) throws PGPException {
        long keyID = pGPOnePassSignature.getKeyID();
        Logger logger = LOGGER;
        Level level = LEVEL;
        logger.log(level, "Message contains OnePassSignature from " + Long.toHexString(keyID));
        PGPPublicKey pGPPublicKeyFindSignatureVerificationKey = findSignatureVerificationKey(keyID);
        if (pGPPublicKeyFindSignatureVerificationKey == null) {
            logger.log(level, "Missing verification key from " + Long.toHexString(keyID));
            return;
        }
        pGPOnePassSignature.init(this.verifierBuilderProvider, pGPPublicKeyFindSignatureVerificationKey);
        OnePassSignature onePassSignature = new OnePassSignature(pGPOnePassSignature, new OpenPgpV4Fingerprint(pGPPublicKeyFindSignatureVerificationKey));
        this.resultBuilder.addOnePassSignature(onePassSignature);
        this.verifiableOnePassSignatures.put(new OpenPgpV4Fingerprint(pGPPublicKeyFindSignatureVerificationKey), onePassSignature);
    }

    private PGPPublicKey findSignatureVerificationKey(long j) {
        Iterator<PGPPublicKeyRing> it = this.verificationKeys.iterator();
        PGPPublicKey publicKey = null;
        while (true) {
            if (!it.hasNext()) {
                break;
            }
            publicKey = it.next().getPublicKey(j);
            if (publicKey != null) {
                LOGGER.log(LEVEL, "Found public key " + Long.toHexString(j) + " for signature verification");
                break;
            }
        }
        return publicKey == null ? handleMissingVerificationKey(j) : publicKey;
    }

    private PGPPublicKey handleMissingVerificationKey(long j) {
        Logger logger = LOGGER;
        logger.log(Level.FINER, "No public key found for signature of " + Long.toHexString(j));
        MissingPublicKeyCallback missingPublicKeyCallback = this.missingPublicKeyCallback;
        if (missingPublicKeyCallback == null) {
            logger.log(Level.FINER, "No MissingPublicKeyCallback registered. Skip signature of " + Long.toHexString(j));
            return null;
        }
        PGPPublicKey pGPPublicKeyOnMissingPublicKeyEncountered = missingPublicKeyCallback.onMissingPublicKeyEncountered(Long.valueOf(j));
        if (pGPPublicKeyOnMissingPublicKeyEncountered == null) {
            logger.log(Level.FINER, "MissingPublicKeyCallback did not provider key. Skip signature of " + Long.toHexString(j));
            return null;
        }
        if (pGPPublicKeyOnMissingPublicKeyEncountered.getKeyID() == j) {
            return pGPPublicKeyOnMissingPublicKeyEncountered;
        }
        throw new IllegalArgumentException("KeyID of the provided public key differs from the signatures keyId. The signature was created from " + Long.toHexString(j) + " while the provided key has ID " + Long.toHexString(pGPPublicKeyOnMissingPublicKeyEncountered.getKeyID()));
    }
}
