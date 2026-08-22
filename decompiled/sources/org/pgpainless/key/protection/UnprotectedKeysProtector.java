package org.pgpainless.key.protection;

import javax.annotation.Nullable;
import org.bouncycastle.openpgp.operator.PBESecretKeyDecryptor;
import org.bouncycastle.openpgp.operator.PBESecretKeyEncryptor;

/* JADX INFO: loaded from: classes10.dex */
public class UnprotectedKeysProtector implements SecretKeyRingProtector {
    @Override // org.pgpainless.key.protection.SecretKeyRingProtector
    @Nullable
    public PBESecretKeyDecryptor getDecryptor(Long l) {
        return null;
    }

    @Override // org.pgpainless.key.protection.SecretKeyRingProtector
    @Nullable
    public PBESecretKeyEncryptor getEncryptor(Long l) {
        return null;
    }
}
