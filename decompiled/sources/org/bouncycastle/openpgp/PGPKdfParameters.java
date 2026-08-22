package org.bouncycastle.openpgp;

/* JADX INFO: loaded from: classes10.dex */
public class PGPKdfParameters implements PGPAlgorithmParameters {
    private final int hashAlgorithm;
    private final int symmetricWrapAlgorithm;

    public PGPKdfParameters(int i, int i2) {
        this.hashAlgorithm = i;
        this.symmetricWrapAlgorithm = i2;
    }

    public int getHashAlgorithm() {
        return this.hashAlgorithm;
    }

    public int getSymmetricWrapAlgorithm() {
        return this.symmetricWrapAlgorithm;
    }
}
