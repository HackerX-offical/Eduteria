package org.bouncycastle.crypto.params;

import java.math.BigInteger;
import org.bouncycastle.crypto.CipherParameters;

/* JADX INFO: loaded from: classes10.dex */
public class ElGamalParameters implements CipherParameters {

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    private BigInteger f1408g;
    private int l;
    private BigInteger p;

    public ElGamalParameters(BigInteger bigInteger, BigInteger bigInteger2) {
        this(bigInteger, bigInteger2, 0);
    }

    public ElGamalParameters(BigInteger bigInteger, BigInteger bigInteger2, int i) {
        this.f1408g = bigInteger2;
        this.p = bigInteger;
        this.l = i;
    }

    public boolean equals(Object obj) {
        if (!(obj instanceof ElGamalParameters)) {
            return false;
        }
        ElGamalParameters elGamalParameters = (ElGamalParameters) obj;
        return elGamalParameters.getP().equals(this.p) && elGamalParameters.getG().equals(this.f1408g) && elGamalParameters.getL() == this.l;
    }

    public BigInteger getG() {
        return this.f1408g;
    }

    public int getL() {
        return this.l;
    }

    public BigInteger getP() {
        return this.p;
    }

    public int hashCode() {
        return (getP().hashCode() ^ getG().hashCode()) + this.l;
    }
}
