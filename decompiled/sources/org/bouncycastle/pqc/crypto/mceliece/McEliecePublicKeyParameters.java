package org.bouncycastle.pqc.crypto.mceliece;

import org.bouncycastle.pqc.math.linearalgebra.GF2Matrix;

/* JADX INFO: loaded from: classes10.dex */
public class McEliecePublicKeyParameters extends McElieceKeyParameters {

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    private GF2Matrix f1485g;
    private int n;
    private int t;

    public McEliecePublicKeyParameters(int i, int i2, GF2Matrix gF2Matrix) {
        super(false, null);
        this.n = i;
        this.t = i2;
        this.f1485g = new GF2Matrix(gF2Matrix);
    }

    public GF2Matrix getG() {
        return this.f1485g;
    }

    public int getK() {
        return this.f1485g.getNumRows();
    }

    public int getN() {
        return this.n;
    }

    public int getT() {
        return this.t;
    }
}
