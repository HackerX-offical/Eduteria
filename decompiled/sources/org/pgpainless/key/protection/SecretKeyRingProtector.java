package org.pgpainless.key.protection;

import javax.annotation.Nullable;
import org.bouncycastle.openpgp.PGPException;
import org.bouncycastle.openpgp.operator.PBESecretKeyDecryptor;
import org.bouncycastle.openpgp.operator.PBESecretKeyEncryptor;

/* JADX INFO: loaded from: classes10.dex */
public interface SecretKeyRingProtector {
    @Nullable
    PBESecretKeyDecryptor getDecryptor(Long l);

    @Nullable
    PBESecretKeyEncryptor getEncryptor(Long l) throws PGPException;
}
