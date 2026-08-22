package org.bouncycastle.jce.spec;

import java.math.BigInteger;
import java.security.spec.AlgorithmParameterSpec;

/* JADX INFO: loaded from: classes10.dex */
public class ElGamalParameterSpec implements AlgorithmParameterSpec {

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    private BigInteger f1456g;
    private BigInteger p;

    public ElGamalParameterSpec(BigInteger bigInteger, BigInteger bigInteger2) {
        this.p = bigInteger;
        this.f1456g = bigInteger2;
    }

    public BigInteger getG() {
        return this.f1456g;
    }

    public BigInteger getP() {
        return this.p;
    }
}
