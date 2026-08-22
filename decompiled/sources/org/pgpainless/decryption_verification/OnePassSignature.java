package org.pgpainless.decryption_verification;

import org.bouncycastle.openpgp.PGPException;
import org.bouncycastle.openpgp.PGPOnePassSignature;
import org.bouncycastle.openpgp.PGPSignature;
import org.pgpainless.key.OpenPgpV4Fingerprint;

/* JADX INFO: loaded from: classes10.dex */
public class OnePassSignature {
    private final OpenPgpV4Fingerprint fingerprint;
    private final PGPOnePassSignature onePassSignature;
    private PGPSignature signature;
    private boolean verified;

    public OnePassSignature(PGPOnePassSignature pGPOnePassSignature, OpenPgpV4Fingerprint openPgpV4Fingerprint) {
        this.onePassSignature = pGPOnePassSignature;
        this.fingerprint = openPgpV4Fingerprint;
    }

    public boolean isVerified() {
        return this.verified;
    }

    public PGPOnePassSignature getOnePassSignature() {
        return this.onePassSignature;
    }

    public OpenPgpV4Fingerprint getFingerprint() {
        return this.fingerprint;
    }

    public boolean verify(PGPSignature pGPSignature) throws PGPException {
        boolean zVerify = getOnePassSignature().verify(pGPSignature);
        this.verified = zVerify;
        if (zVerify) {
            this.signature = pGPSignature;
        }
        return zVerify;
    }

    public PGPSignature getSignature() {
        return this.signature;
    }
}
