package org.pgpainless.key.generation.type;

import javax.annotation.Nonnull;
import org.pgpainless.algorithm.PublicKeyAlgorithm;
import org.pgpainless.key.generation.type.length.RsaLength;

/* JADX INFO: loaded from: classes10.dex */
public class RSA_SIGN extends RSA_GENERAL {
    RSA_SIGN(@Nonnull RsaLength rsaLength) {
        super(rsaLength);
    }

    @Override // org.pgpainless.key.generation.type.RSA_GENERAL, org.pgpainless.key.generation.type.KeyType
    public PublicKeyAlgorithm getAlgorithm() {
        return PublicKeyAlgorithm.RSA_SIGN;
    }
}
