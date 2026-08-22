package org.pgpainless.key.protection;

import javax.annotation.Nonnull;
import org.pgpainless.algorithm.HashAlgorithm;
import org.pgpainless.algorithm.SymmetricKeyAlgorithm;

/* JADX INFO: loaded from: classes10.dex */
public class KeyRingProtectionSettings {
    private final SymmetricKeyAlgorithm encryptionAlgorithm;
    private final HashAlgorithm hashAlgorithm;
    private final int s2kCount;

    public KeyRingProtectionSettings(@Nonnull SymmetricKeyAlgorithm symmetricKeyAlgorithm) {
        this(symmetricKeyAlgorithm, HashAlgorithm.SHA1, 96);
    }

    public KeyRingProtectionSettings(@Nonnull SymmetricKeyAlgorithm symmetricKeyAlgorithm, @Nonnull HashAlgorithm hashAlgorithm, int i) {
        this.encryptionAlgorithm = symmetricKeyAlgorithm;
        this.hashAlgorithm = hashAlgorithm;
        if (i < 1) {
            throw new IllegalArgumentException("s2kCount cannot be less than 1.");
        }
        this.s2kCount = i;
    }

    @Nonnull
    public SymmetricKeyAlgorithm getEncryptionAlgorithm() {
        return this.encryptionAlgorithm;
    }

    @Nonnull
    public HashAlgorithm getHashAlgorithm() {
        return this.hashAlgorithm;
    }

    public int getS2kCount() {
        return this.s2kCount;
    }
}
