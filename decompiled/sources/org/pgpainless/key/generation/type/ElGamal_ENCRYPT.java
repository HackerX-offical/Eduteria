package org.pgpainless.key.generation.type;

import javax.annotation.Nonnull;
import org.pgpainless.algorithm.PublicKeyAlgorithm;
import org.pgpainless.key.generation.type.length.ElGamalLength;

/* JADX INFO: loaded from: classes10.dex */
public class ElGamal_ENCRYPT extends ElGamal_GENERAL {
    ElGamal_ENCRYPT(@Nonnull ElGamalLength elGamalLength) {
        super(elGamalLength);
    }

    @Override // org.pgpainless.key.generation.type.ElGamal_GENERAL, org.pgpainless.key.generation.type.KeyType
    public PublicKeyAlgorithm getAlgorithm() {
        return PublicKeyAlgorithm.ELGAMAL_ENCRYPT;
    }
}
