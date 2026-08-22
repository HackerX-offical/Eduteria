package org.pgpainless.key.generation.type;

import java.security.spec.AlgorithmParameterSpec;
import java.security.spec.RSAKeyGenParameterSpec;
import javax.annotation.Nonnull;
import org.pgpainless.algorithm.PublicKeyAlgorithm;
import org.pgpainless.key.generation.type.length.RsaLength;

/* JADX INFO: loaded from: classes10.dex */
public class RSA_GENERAL implements KeyType {
    private final RsaLength length;

    RSA_GENERAL(@Nonnull RsaLength rsaLength) {
        this.length = rsaLength;
    }

    public static RSA_GENERAL withLength(@Nonnull RsaLength rsaLength) {
        return new RSA_GENERAL(rsaLength);
    }

    @Override // org.pgpainless.key.generation.type.KeyType
    public String getName() {
        return "RSA";
    }

    @Override // org.pgpainless.key.generation.type.KeyType
    public PublicKeyAlgorithm getAlgorithm() {
        return PublicKeyAlgorithm.RSA_GENERAL;
    }

    @Override // org.pgpainless.key.generation.type.KeyType
    public AlgorithmParameterSpec getAlgorithmSpec() {
        return new RSAKeyGenParameterSpec(this.length.getLength(), RSAKeyGenParameterSpec.F4);
    }
}
