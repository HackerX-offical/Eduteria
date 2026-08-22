package org.pgpainless.decryption_verification;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.concurrent.ConcurrentHashMap;
import org.bouncycastle.openpgp.PGPPublicKey;
import org.bouncycastle.openpgp.PGPPublicKeyRing;
import org.bouncycastle.openpgp.PGPSignature;
import org.pgpainless.algorithm.CompressionAlgorithm;
import org.pgpainless.algorithm.SymmetricKeyAlgorithm;
import org.pgpainless.key.OpenPgpV4Fingerprint;

/* JADX INFO: loaded from: classes10.dex */
public class OpenPgpMetadata {
    private final CompressionAlgorithm compressionAlgorithm;
    private final OpenPgpV4Fingerprint decryptionFingerprint;
    private final List<DetachedSignature> detachedSignatures;
    private final boolean integrityProtected;
    private final List<OnePassSignature> onePassSignatures;
    private final Set<Long> recipientKeyIds;
    private final SymmetricKeyAlgorithm symmetricKeyAlgorithm;

    public OpenPgpMetadata(Set<Long> set, OpenPgpV4Fingerprint openPgpV4Fingerprint, SymmetricKeyAlgorithm symmetricKeyAlgorithm, CompressionAlgorithm compressionAlgorithm, boolean z, List<OnePassSignature> list, List<DetachedSignature> list2) {
        this.recipientKeyIds = Collections.unmodifiableSet(set);
        this.decryptionFingerprint = openPgpV4Fingerprint;
        this.symmetricKeyAlgorithm = symmetricKeyAlgorithm;
        this.compressionAlgorithm = compressionAlgorithm;
        this.integrityProtected = z;
        this.detachedSignatures = Collections.unmodifiableList(list2);
        this.onePassSignatures = Collections.unmodifiableList(list);
    }

    public Set<Long> getRecipientKeyIds() {
        return this.recipientKeyIds;
    }

    public boolean isEncrypted() {
        return !getRecipientKeyIds().isEmpty();
    }

    public OpenPgpV4Fingerprint getDecryptionFingerprint() {
        return this.decryptionFingerprint;
    }

    public SymmetricKeyAlgorithm getSymmetricKeyAlgorithm() {
        return this.symmetricKeyAlgorithm;
    }

    public CompressionAlgorithm getCompressionAlgorithm() {
        return this.compressionAlgorithm;
    }

    public boolean isIntegrityProtected() {
        return this.integrityProtected;
    }

    public Set<PGPSignature> getSignatures() {
        HashSet hashSet = new HashSet();
        Iterator<DetachedSignature> it = this.detachedSignatures.iterator();
        while (it.hasNext()) {
            hashSet.add(it.next().getSignature());
        }
        Iterator<OnePassSignature> it2 = this.onePassSignatures.iterator();
        while (it2.hasNext()) {
            hashSet.add(it2.next().getSignature());
        }
        return hashSet;
    }

    public boolean isSigned() {
        return !getSignatures().isEmpty();
    }

    public Map<OpenPgpV4Fingerprint, PGPSignature> getVerifiedSignatures() {
        ConcurrentHashMap concurrentHashMap = new ConcurrentHashMap();
        for (DetachedSignature detachedSignature : this.detachedSignatures) {
            if (detachedSignature.isVerified()) {
                concurrentHashMap.put(detachedSignature.getFingerprint(), detachedSignature.getSignature());
            }
        }
        for (OnePassSignature onePassSignature : this.onePassSignatures) {
            if (onePassSignature.isVerified()) {
                concurrentHashMap.put(onePassSignature.getFingerprint(), onePassSignature.getSignature());
            }
        }
        return concurrentHashMap;
    }

    public Set<OpenPgpV4Fingerprint> getVerifiedSignatureKeyFingerprints() {
        return getVerifiedSignatures().keySet();
    }

    public boolean isVerified() {
        return !getVerifiedSignatures().isEmpty();
    }

    public boolean containsVerifiedSignatureFrom(PGPPublicKeyRing pGPPublicKeyRing) {
        Iterator<PGPPublicKey> it = pGPPublicKeyRing.iterator();
        while (it.hasNext()) {
            if (containsVerifiedSignatureFrom(new OpenPgpV4Fingerprint(it.next()))) {
                return true;
            }
        }
        return false;
    }

    public boolean containsVerifiedSignatureFrom(OpenPgpV4Fingerprint openPgpV4Fingerprint) {
        return getVerifiedSignatureKeyFingerprints().contains(openPgpV4Fingerprint);
    }

    public static class Signature {
        protected final OpenPgpV4Fingerprint fingerprint;
        protected final PGPSignature signature;

        public Signature(PGPSignature pGPSignature, OpenPgpV4Fingerprint openPgpV4Fingerprint) {
            this.signature = pGPSignature;
            this.fingerprint = openPgpV4Fingerprint;
        }
    }

    public static Builder getBuilder() {
        return new Builder();
    }

    public static class Builder {
        private OpenPgpV4Fingerprint decryptionFingerprint;
        private final Set<Long> recipientFingerprints = new HashSet();
        private final List<DetachedSignature> detachedSignatures = new ArrayList();
        private final List<OnePassSignature> onePassSignatures = new ArrayList();
        private SymmetricKeyAlgorithm symmetricKeyAlgorithm = SymmetricKeyAlgorithm.NULL;
        private CompressionAlgorithm compressionAlgorithm = CompressionAlgorithm.UNCOMPRESSED;
        private boolean integrityProtected = false;

        public Builder addRecipientKeyId(Long l) {
            this.recipientFingerprints.add(l);
            return this;
        }

        public Builder setDecryptionFingerprint(OpenPgpV4Fingerprint openPgpV4Fingerprint) {
            this.decryptionFingerprint = openPgpV4Fingerprint;
            return this;
        }

        public Builder setCompressionAlgorithm(CompressionAlgorithm compressionAlgorithm) {
            this.compressionAlgorithm = compressionAlgorithm;
            return this;
        }

        public List<DetachedSignature> getDetachedSignatures() {
            return this.detachedSignatures;
        }

        public Builder setSymmetricKeyAlgorithm(SymmetricKeyAlgorithm symmetricKeyAlgorithm) {
            this.symmetricKeyAlgorithm = symmetricKeyAlgorithm;
            return this;
        }

        public Builder setIntegrityProtected(boolean z) {
            this.integrityProtected = z;
            return this;
        }

        public void addDetachedSignature(DetachedSignature detachedSignature) {
            this.detachedSignatures.add(detachedSignature);
        }

        public void addOnePassSignature(OnePassSignature onePassSignature) {
            this.onePassSignatures.add(onePassSignature);
        }

        public OpenPgpMetadata build() {
            return new OpenPgpMetadata(this.recipientFingerprints, this.decryptionFingerprint, this.symmetricKeyAlgorithm, this.compressionAlgorithm, this.integrityProtected, this.onePassSignatures, this.detachedSignatures);
        }
    }
}
