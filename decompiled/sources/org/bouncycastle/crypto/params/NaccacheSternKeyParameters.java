package org.bouncycastle.crypto.params;

import java.math.BigInteger;

/* JADX INFO: loaded from: classes10.dex */
public class NaccacheSternKeyParameters extends AsymmetricKeyParameter {

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    private BigInteger f1412g;
    int lowerSigmaBound;
    private BigInteger n;

    public NaccacheSternKeyParameters(boolean z, BigInteger bigInteger, BigInteger bigInteger2, int i) {
        super(z);
        this.f1412g = bigInteger;
        this.n = bigInteger2;
        this.lowerSigmaBound = i;
    }

    public BigInteger getG() {
        return this.f1412g;
    }

    public int getLowerSigmaBound() {
        return this.lowerSigmaBound;
    }

    public BigInteger getModulus() {
        return this.n;
    }
}
