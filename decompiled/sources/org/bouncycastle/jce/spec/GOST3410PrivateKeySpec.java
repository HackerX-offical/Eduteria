package org.bouncycastle.jce.spec;

import java.math.BigInteger;
import java.security.spec.KeySpec;

/* JADX INFO: loaded from: classes10.dex */
public class GOST3410PrivateKeySpec implements KeySpec {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private BigInteger f1457a;
    private BigInteger p;
    private BigInteger q;
    private BigInteger x;

    public GOST3410PrivateKeySpec(BigInteger bigInteger, BigInteger bigInteger2, BigInteger bigInteger3, BigInteger bigInteger4) {
        this.x = bigInteger;
        this.p = bigInteger2;
        this.q = bigInteger3;
        this.f1457a = bigInteger4;
    }

    public BigInteger getA() {
        return this.f1457a;
    }

    public BigInteger getP() {
        return this.p;
    }

    public BigInteger getQ() {
        return this.q;
    }

    public BigInteger getX() {
        return this.x;
    }
}
