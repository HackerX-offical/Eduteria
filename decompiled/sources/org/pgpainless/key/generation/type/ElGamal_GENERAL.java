package org.pgpainless.key.generation.type;

import java.security.spec.AlgorithmParameterSpec;
import javax.annotation.Nonnull;
import org.bouncycastle.jce.spec.ElGamalParameterSpec;
import org.pgpainless.algorithm.PublicKeyAlgorithm;
import org.pgpainless.key.generation.type.length.ElGamalLength;

/* JADX INFO: loaded from: classes10.dex */
public class ElGamal_GENERAL implements KeyType {
    private final ElGamalLength length;

    ElGamal_GENERAL(@Nonnull ElGamalLength elGamalLength) {
        this.length = elGamalLength;
    }

    public static ElGamal_GENERAL withLength(@Nonnull ElGamalLength elGamalLength) {
        return new ElGamal_GENERAL(elGamalLength);
    }

    @Override // org.pgpainless.key.generation.type.KeyType
    public String getName() {
        return "ElGamal";
    }

    @Override // org.pgpainless.key.generation.type.KeyType
    public PublicKeyAlgorithm getAlgorithm() {
        return PublicKeyAlgorithm.ELGAMAL_GENERAL;
    }

    @Override // org.pgpainless.key.generation.type.KeyType
    public AlgorithmParameterSpec getAlgorithmSpec() {
        return new ElGamalParameterSpec(this.length.getP(), this.length.getG());
    }
}
