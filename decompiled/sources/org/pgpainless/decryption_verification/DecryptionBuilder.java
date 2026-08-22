package org.pgpainless.decryption_verification;

import java.io.IOException;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Set;
import javax.annotation.Nonnull;
import org.bouncycastle.openpgp.PGPCompressedData;
import org.bouncycastle.openpgp.PGPException;
import org.bouncycastle.openpgp.PGPObjectFactory;
import org.bouncycastle.openpgp.PGPPublicKeyRing;
import org.bouncycastle.openpgp.PGPPublicKeyRingCollection;
import org.bouncycastle.openpgp.PGPSecretKeyRingCollection;
import org.bouncycastle.openpgp.PGPSignature;
import org.bouncycastle.openpgp.PGPSignatureList;
import org.bouncycastle.openpgp.PGPUtil;
import org.bouncycastle.openpgp.operator.KeyFingerPrintCalculator;
import org.bouncycastle.openpgp.operator.bc.BcKeyFingerprintCalculator;
import org.pgpainless.decryption_verification.DecryptionBuilderInterface;
import org.pgpainless.key.OpenPgpV4Fingerprint;
import org.pgpainless.key.protection.SecretKeyRingProtector;

/* JADX INFO: loaded from: classes10.dex */
public class DecryptionBuilder implements DecryptionBuilderInterface {
    private SecretKeyRingProtector decryptionKeyDecryptor;
    private PGPSecretKeyRingCollection decryptionKeys;
    private List<PGPSignature> detachedSignatures;
    private InputStream inputStream;
    private Set<PGPPublicKeyRing> verificationKeys = new HashSet();
    private MissingPublicKeyCallback missingPublicKeyCallback = null;
    private final KeyFingerPrintCalculator keyFingerPrintCalculator = new BcKeyFingerprintCalculator();

    @Override // org.pgpainless.decryption_verification.DecryptionBuilderInterface
    public DecryptionBuilderInterface.DecryptWith onInputStream(@Nonnull InputStream inputStream) {
        this.inputStream = inputStream;
        return new DecryptWithImpl();
    }

    class DecryptWithImpl implements DecryptionBuilderInterface.DecryptWith {
        DecryptWithImpl() {
        }

        @Override // org.pgpainless.decryption_verification.DecryptionBuilderInterface.DecryptWith
        public DecryptionBuilderInterface.Verify decryptWith(@Nonnull SecretKeyRingProtector secretKeyRingProtector, @Nonnull PGPSecretKeyRingCollection pGPSecretKeyRingCollection) {
            DecryptionBuilder.this.decryptionKeys = pGPSecretKeyRingCollection;
            DecryptionBuilder.this.decryptionKeyDecryptor = secretKeyRingProtector;
            return DecryptionBuilder.this.new VerifyImpl();
        }

        @Override // org.pgpainless.decryption_verification.DecryptionBuilderInterface.DecryptWith
        public DecryptionBuilderInterface.Verify doNotDecrypt() {
            DecryptionBuilder.this.decryptionKeys = null;
            DecryptionBuilder.this.decryptionKeyDecryptor = null;
            return DecryptionBuilder.this.new VerifyImpl();
        }
    }

    class VerifyImpl implements DecryptionBuilderInterface.Verify {
        VerifyImpl() {
        }

        @Override // org.pgpainless.decryption_verification.DecryptionBuilderInterface.Verify
        public DecryptionBuilderInterface.VerifyWith verifyDetachedSignature(@Nonnull InputStream inputStream) throws IOException, PGPException {
            ArrayList arrayList = new ArrayList();
            InputStream decoderStream = PGPUtil.getDecoderStream(inputStream);
            PGPObjectFactory pGPObjectFactory = new PGPObjectFactory(decoderStream, DecryptionBuilder.this.keyFingerPrintCalculator);
            Object objNextObject = pGPObjectFactory.nextObject();
            while (objNextObject != null) {
                if (objNextObject instanceof PGPCompressedData) {
                    pGPObjectFactory = new PGPObjectFactory(((PGPCompressedData) objNextObject).getDataStream(), DecryptionBuilder.this.keyFingerPrintCalculator);
                    objNextObject = pGPObjectFactory.nextObject();
                } else {
                    if (objNextObject instanceof PGPSignatureList) {
                        Iterator<PGPSignature> it = ((PGPSignatureList) objNextObject).iterator();
                        while (it.hasNext()) {
                            arrayList.add(it.next());
                        }
                    }
                    if (objNextObject instanceof PGPSignature) {
                        arrayList.add((PGPSignature) objNextObject);
                    }
                    objNextObject = pGPObjectFactory.nextObject();
                }
            }
            decoderStream.close();
            return verifyDetachedSignatures(arrayList);
        }

        @Override // org.pgpainless.decryption_verification.DecryptionBuilderInterface.Verify
        public DecryptionBuilderInterface.VerifyWith verifyDetachedSignatures(@Nonnull List<PGPSignature> list) {
            DecryptionBuilder.this.detachedSignatures = list;
            return DecryptionBuilder.this.new VerifyWithImpl();
        }

        @Override // org.pgpainless.decryption_verification.DecryptionBuilderInterface.Verify, org.pgpainless.decryption_verification.DecryptionBuilderInterface.VerifyWith
        public DecryptionBuilderInterface.HandleMissingPublicKeys verifyWith(@Nonnull PGPPublicKeyRingCollection pGPPublicKeyRingCollection) {
            return DecryptionBuilder.this.new VerifyWithImpl().verifyWith(pGPPublicKeyRingCollection);
        }

        @Override // org.pgpainless.decryption_verification.DecryptionBuilderInterface.Verify, org.pgpainless.decryption_verification.DecryptionBuilderInterface.VerifyWith
        public DecryptionBuilderInterface.HandleMissingPublicKeys verifyWith(@Nonnull Set<OpenPgpV4Fingerprint> set, @Nonnull PGPPublicKeyRingCollection pGPPublicKeyRingCollection) {
            return DecryptionBuilder.this.new VerifyWithImpl().verifyWith(set, pGPPublicKeyRingCollection);
        }

        @Override // org.pgpainless.decryption_verification.DecryptionBuilderInterface.Verify, org.pgpainless.decryption_verification.DecryptionBuilderInterface.VerifyWith
        public DecryptionBuilderInterface.HandleMissingPublicKeys verifyWith(@Nonnull Set<PGPPublicKeyRing> set) {
            return DecryptionBuilder.this.new VerifyWithImpl().verifyWith(set);
        }

        @Override // org.pgpainless.decryption_verification.DecryptionBuilderInterface.Verify
        public DecryptionBuilderInterface.Build doNotVerify() {
            DecryptionBuilder.this.verificationKeys = null;
            return DecryptionBuilder.this.new BuildImpl();
        }
    }

    class VerifyWithImpl implements DecryptionBuilderInterface.VerifyWith {
        VerifyWithImpl() {
        }

        @Override // org.pgpainless.decryption_verification.DecryptionBuilderInterface.VerifyWith
        public DecryptionBuilderInterface.HandleMissingPublicKeys verifyWith(@Nonnull PGPPublicKeyRingCollection pGPPublicKeyRingCollection) {
            HashSet hashSet = new HashSet();
            Iterator<PGPPublicKeyRing> keyRings = pGPPublicKeyRingCollection.getKeyRings();
            while (keyRings.hasNext()) {
                hashSet.add(keyRings.next());
            }
            return verifyWith(hashSet);
        }

        @Override // org.pgpainless.decryption_verification.DecryptionBuilderInterface.VerifyWith
        public DecryptionBuilderInterface.HandleMissingPublicKeys verifyWith(@Nonnull Set<OpenPgpV4Fingerprint> set, @Nonnull PGPPublicKeyRingCollection pGPPublicKeyRingCollection) {
            Set<PGPPublicKeyRing> setKeyRingCollectionToSet = keyRingCollectionToSet(pGPPublicKeyRingCollection);
            removeUntrustedPublicKeys(setKeyRingCollectionToSet, set);
            return verifyWith(setKeyRingCollectionToSet);
        }

        private void removeUntrustedPublicKeys(Set<PGPPublicKeyRing> set, Set<OpenPgpV4Fingerprint> set2) {
            for (PGPPublicKeyRing pGPPublicKeyRing : new HashSet(set)) {
                if (!set2.contains(new OpenPgpV4Fingerprint(pGPPublicKeyRing))) {
                    set.remove(pGPPublicKeyRing);
                }
            }
        }

        private Set<PGPPublicKeyRing> keyRingCollectionToSet(PGPPublicKeyRingCollection pGPPublicKeyRingCollection) {
            HashSet hashSet = new HashSet();
            Iterator<PGPPublicKeyRing> keyRings = pGPPublicKeyRingCollection.getKeyRings();
            while (keyRings.hasNext()) {
                hashSet.add(keyRings.next());
            }
            return hashSet;
        }

        @Override // org.pgpainless.decryption_verification.DecryptionBuilderInterface.VerifyWith
        public DecryptionBuilderInterface.HandleMissingPublicKeys verifyWith(@Nonnull Set<PGPPublicKeyRing> set) {
            DecryptionBuilder.this.verificationKeys = set;
            return DecryptionBuilder.this.new HandleMissingPublicKeysImpl();
        }
    }

    class HandleMissingPublicKeysImpl implements DecryptionBuilderInterface.HandleMissingPublicKeys {
        HandleMissingPublicKeysImpl() {
        }

        @Override // org.pgpainless.decryption_verification.DecryptionBuilderInterface.HandleMissingPublicKeys
        public DecryptionBuilderInterface.Build handleMissingPublicKeysWith(@Nonnull MissingPublicKeyCallback missingPublicKeyCallback) {
            DecryptionBuilder.this.missingPublicKeyCallback = missingPublicKeyCallback;
            return DecryptionBuilder.this.new BuildImpl();
        }

        @Override // org.pgpainless.decryption_verification.DecryptionBuilderInterface.HandleMissingPublicKeys
        public DecryptionBuilderInterface.Build ignoreMissingPublicKeys() {
            DecryptionBuilder.this.missingPublicKeyCallback = null;
            return DecryptionBuilder.this.new BuildImpl();
        }
    }

    class BuildImpl implements DecryptionBuilderInterface.Build {
        BuildImpl() {
        }

        @Override // org.pgpainless.decryption_verification.DecryptionBuilderInterface.Build
        public DecryptionStream build() throws IOException, PGPException {
            return DecryptionStreamFactory.create(DecryptionBuilder.this.inputStream, DecryptionBuilder.this.decryptionKeys, DecryptionBuilder.this.decryptionKeyDecryptor, DecryptionBuilder.this.detachedSignatures, DecryptionBuilder.this.verificationKeys, DecryptionBuilder.this.missingPublicKeyCallback);
        }
    }
}
