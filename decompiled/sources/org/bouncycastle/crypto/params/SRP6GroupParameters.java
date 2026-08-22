package org.bouncycastle.crypto.params;

import java.math.BigInteger;

/* JADX INFO: loaded from: classes10.dex */
public class SRP6GroupParameters {
    private BigInteger N;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    private BigInteger f1414g;

    public SRP6GroupParameters(BigInteger bigInteger, BigInteger bigInteger2) {
        this.N = bigInteger;
        this.f1414g = bigInteger2;
    }

    public BigInteger getG() {
        return this.f1414g;
    }

    public BigInteger getN() {
        return this.N;
    }
}
