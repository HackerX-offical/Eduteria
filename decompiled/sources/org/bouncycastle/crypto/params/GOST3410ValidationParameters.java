package org.bouncycastle.crypto.params;

/* JADX INFO: loaded from: classes10.dex */
public class GOST3410ValidationParameters {

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private int f1410c;
    private long cL;
    private int x0;
    private long x0L;

    public GOST3410ValidationParameters(int i, int i2) {
        this.x0 = i;
        this.f1410c = i2;
    }

    public GOST3410ValidationParameters(long j, long j2) {
        this.x0L = j;
        this.cL = j2;
    }

    public boolean equals(Object obj) {
        if (!(obj instanceof GOST3410ValidationParameters)) {
            return false;
        }
        GOST3410ValidationParameters gOST3410ValidationParameters = (GOST3410ValidationParameters) obj;
        return gOST3410ValidationParameters.f1410c == this.f1410c && gOST3410ValidationParameters.x0 == this.x0 && gOST3410ValidationParameters.cL == this.cL && gOST3410ValidationParameters.x0L == this.x0L;
    }

    public int getC() {
        return this.f1410c;
    }

    public long getCL() {
        return this.cL;
    }

    public int getX0() {
        return this.x0;
    }

    public long getX0L() {
        return this.x0L;
    }

    public int hashCode() {
        int i = this.x0 ^ this.f1410c;
        long j = this.x0L;
        int i2 = (i ^ ((int) j)) ^ ((int) (j >> 32));
        long j2 = this.cL;
        return (i2 ^ ((int) j2)) ^ ((int) (j2 >> 32));
    }
}
