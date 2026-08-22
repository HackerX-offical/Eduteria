package org.pgpainless.key.generation.type;

import java.security.spec.AlgorithmParameterSpec;
import javax.annotation.Nonnull;
import org.bouncycastle.jce.spec.ECNamedCurveGenParameterSpec;
import org.pgpainless.algorithm.PublicKeyAlgorithm;
import org.pgpainless.key.generation.type.curve.EllipticCurve;

/* JADX INFO: loaded from: classes10.dex */
public class ECDH implements KeyType {
    private final EllipticCurve curve;

    ECDH(EllipticCurve ellipticCurve) {
        this.curve = ellipticCurve;
    }

    public static ECDH fromCurve(@Nonnull EllipticCurve ellipticCurve) {
        return new ECDH(ellipticCurve);
    }

    @Override // org.pgpainless.key.generation.type.KeyType
    public String getName() {
        return "ECDH";
    }

    @Override // org.pgpainless.key.generation.type.KeyType
    public PublicKeyAlgorithm getAlgorithm() {
        return PublicKeyAlgorithm.ECDH;
    }

    @Override // org.pgpainless.key.generation.type.KeyType
    public AlgorithmParameterSpec getAlgorithmSpec() {
        return new ECNamedCurveGenParameterSpec(this.curve.getName());
    }
}
