package org.bouncycastle.crypto.params;

import java.math.BigInteger;

/* JADX INFO: loaded from: classes10.dex */
public class CramerShoupPublicKeyParameters extends CramerShoupKeyParameters {

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private BigInteger f1401c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private BigInteger f1402d;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    private BigInteger f1403h;

    public CramerShoupPublicKeyParameters(CramerShoupParameters cramerShoupParameters, BigInteger bigInteger, BigInteger bigInteger2, BigInteger bigInteger3) {
        super(false, cramerShoupParameters);
        this.f1401c = bigInteger;
        this.f1402d = bigInteger2;
        this.f1403h = bigInteger3;
    }

    @Override // org.bouncycastle.crypto.params.CramerShoupKeyParameters
    public boolean equals(Object obj) {
        if (!(obj instanceof CramerShoupPublicKeyParameters)) {
            return false;
        }
        CramerShoupPublicKeyParameters cramerShoupPublicKeyParameters = (CramerShoupPublicKeyParameters) obj;
        return cramerShoupPublicKeyParameters.getC().equals(this.f1401c) && cramerShoupPublicKeyParameters.getD().equals(this.f1402d) && cramerShoupPublicKeyParameters.getH().equals(this.f1403h) && super.equals(obj);
    }

    public BigInteger getC() {
        return this.f1401c;
    }

    public BigInteger getD() {
        return this.f1402d;
    }

    public BigInteger getH() {
        return this.f1403h;
    }

    @Override // org.bouncycastle.crypto.params.CramerShoupKeyParameters
    public int hashCode() {
        return ((this.f1401c.hashCode() ^ this.f1402d.hashCode()) ^ this.f1403h.hashCode()) ^ super.hashCode();
    }
}
