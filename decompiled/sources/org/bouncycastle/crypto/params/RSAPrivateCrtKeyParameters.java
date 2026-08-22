package org.bouncycastle.crypto.params;

import java.math.BigInteger;

/* JADX INFO: loaded from: classes10.dex */
public class RSAPrivateCrtKeyParameters extends RSAKeyParameters {
    private BigInteger dP;
    private BigInteger dQ;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    private BigInteger f1413e;
    private BigInteger p;
    private BigInteger q;
    private BigInteger qInv;

    public RSAPrivateCrtKeyParameters(BigInteger bigInteger, BigInteger bigInteger2, BigInteger bigInteger3, BigInteger bigInteger4, BigInteger bigInteger5, BigInteger bigInteger6, BigInteger bigInteger7, BigInteger bigInteger8) {
        super(true, bigInteger, bigInteger3);
        this.f1413e = bigInteger2;
        this.p = bigInteger4;
        this.q = bigInteger5;
        this.dP = bigInteger6;
        this.dQ = bigInteger7;
        this.qInv = bigInteger8;
    }

    public BigInteger getDP() {
        return this.dP;
    }

    public BigInteger getDQ() {
        return this.dQ;
    }

    public BigInteger getP() {
        return this.p;
    }

    public BigInteger getPublicExponent() {
        return this.f1413e;
    }

    public BigInteger getQ() {
        return this.q;
    }

    public BigInteger getQInv() {
        return this.qInv;
    }
}
