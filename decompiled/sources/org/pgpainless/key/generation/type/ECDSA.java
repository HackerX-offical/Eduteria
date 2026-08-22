package org.pgpainless.key.generation.type;

import javax.annotation.Nonnull;
import org.pgpainless.algorithm.PublicKeyAlgorithm;
import org.pgpainless.key.generation.type.curve.EllipticCurve;

/* JADX INFO: loaded from: classes10.dex */
public class ECDSA extends ECDH {
    ECDSA(@Nonnull EllipticCurve ellipticCurve) {
        super(ellipticCurve);
    }

    public static ECDSA fromCurve(@Nonnull EllipticCurve ellipticCurve) {
        return new ECDSA(ellipticCurve);
    }

    @Override // org.pgpainless.key.generation.type.ECDH, org.pgpainless.key.generation.type.KeyType
    public String getName() {
        return "ECDSA";
    }

    @Override // org.pgpainless.key.generation.type.ECDH, org.pgpainless.key.generation.type.KeyType
    public PublicKeyAlgorithm getAlgorithm() {
        return PublicKeyAlgorithm.ECDSA;
    }
}
