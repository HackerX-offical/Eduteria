package org.pgpainless.key.collection;

import javax.annotation.Nonnull;
import javax.annotation.Nullable;
import org.bouncycastle.openpgp.PGPPublicKey;
import org.bouncycastle.openpgp.PGPPublicKeyRing;
import org.bouncycastle.openpgp.PGPSecretKeyRing;
import org.pgpainless.key.OpenPgpV4Fingerprint;

/* JADX INFO: loaded from: classes10.dex */
public class PGPKeyRing {
    private PGPPublicKeyRing publicKeys;
    private PGPSecretKeyRing secretKeys;

    public PGPKeyRing(@Nonnull PGPPublicKeyRing pGPPublicKeyRing, @Nonnull PGPSecretKeyRing pGPSecretKeyRing) {
        if (pGPPublicKeyRing.getPublicKey().getKeyID() != pGPSecretKeyRing.getPublicKey().getKeyID()) {
            throw new IllegalArgumentException("publicKeys and secretKeys must have the same master key.");
        }
        this.publicKeys = pGPPublicKeyRing;
        this.secretKeys = pGPSecretKeyRing;
    }

    public PGPKeyRing(@Nonnull PGPPublicKeyRing pGPPublicKeyRing) {
        this.publicKeys = pGPPublicKeyRing;
    }

    public PGPKeyRing(@Nonnull PGPSecretKeyRing pGPSecretKeyRing) {
        this.secretKeys = pGPSecretKeyRing;
    }

    public long getKeyId() {
        return getMasterKey().getKeyID();
    }

    @Nonnull
    public PGPPublicKey getMasterKey() {
        PGPPublicKey publicKey = hasSecretKeys() ? this.secretKeys.getPublicKey() : this.publicKeys.getPublicKey();
        if (publicKey.isMasterKey()) {
            return publicKey;
        }
        throw new IllegalStateException("Expected master key is not a master key");
    }

    @Nonnull
    public OpenPgpV4Fingerprint getV4Fingerprint() {
        return new OpenPgpV4Fingerprint(getMasterKey());
    }

    public boolean hasSecretKeys() {
        return this.secretKeys != null;
    }

    @Nullable
    public PGPPublicKeyRing getPublicKeys() {
        return this.publicKeys;
    }

    @Nullable
    public PGPSecretKeyRing getSecretKeys() {
        return this.secretKeys;
    }
}
