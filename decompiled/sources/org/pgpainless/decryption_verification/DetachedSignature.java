package org.pgpainless.decryption_verification;

import org.bouncycastle.openpgp.PGPSignature;
import org.pgpainless.key.OpenPgpV4Fingerprint;

/* JADX INFO: loaded from: classes10.dex */
public class DetachedSignature {
    private final OpenPgpV4Fingerprint fingerprint;
    private final PGPSignature signature;
    private boolean verified;

    public DetachedSignature(PGPSignature pGPSignature, OpenPgpV4Fingerprint openPgpV4Fingerprint) {
        this.signature = pGPSignature;
        this.fingerprint = openPgpV4Fingerprint;
    }

    public void setVerified(boolean z) {
        this.verified = z;
    }

    public boolean isVerified() {
        return this.verified;
    }

    public PGPSignature getSignature() {
        return this.signature;
    }

    public OpenPgpV4Fingerprint getFingerprint() {
        return this.fingerprint;
    }
}
