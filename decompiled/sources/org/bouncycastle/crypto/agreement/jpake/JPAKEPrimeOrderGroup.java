package org.bouncycastle.crypto.agreement.jpake;

import java.math.BigInteger;
import org.jivesoftware.smackx.xhtmlim.XHTMLText;

/* JADX INFO: loaded from: classes10.dex */
public class JPAKEPrimeOrderGroup {

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    private final BigInteger f1375g;
    private final BigInteger p;
    private final BigInteger q;

    public JPAKEPrimeOrderGroup(BigInteger bigInteger, BigInteger bigInteger2, BigInteger bigInteger3) {
        this(bigInteger, bigInteger2, bigInteger3, false);
    }

    JPAKEPrimeOrderGroup(BigInteger bigInteger, BigInteger bigInteger2, BigInteger bigInteger3, boolean z) {
        JPAKEUtil.validateNotNull(bigInteger, "p");
        JPAKEUtil.validateNotNull(bigInteger2, XHTMLText.Q);
        JPAKEUtil.validateNotNull(bigInteger3, "g");
        if (!z) {
            if (!bigInteger.subtract(JPAKEUtil.ONE).mod(bigInteger2).equals(JPAKEUtil.ZERO)) {
                throw new IllegalArgumentException("p-1 must be evenly divisible by q");
            }
            if (bigInteger3.compareTo(BigInteger.valueOf(2L)) == -1 || bigInteger3.compareTo(bigInteger.subtract(JPAKEUtil.ONE)) == 1) {
                throw new IllegalArgumentException("g must be in [2, p-1]");
            }
            if (!bigInteger3.modPow(bigInteger2, bigInteger).equals(JPAKEUtil.ONE)) {
                throw new IllegalArgumentException("g^q mod p must equal 1");
            }
            if (!bigInteger.isProbablePrime(20)) {
                throw new IllegalArgumentException("p must be prime");
            }
            if (!bigInteger2.isProbablePrime(20)) {
                throw new IllegalArgumentException("q must be prime");
            }
        }
        this.p = bigInteger;
        this.q = bigInteger2;
        this.f1375g = bigInteger3;
    }

    public BigInteger getG() {
        return this.f1375g;
    }

    public BigInteger getP() {
        return this.p;
    }

    public BigInteger getQ() {
        return this.q;
    }
}
