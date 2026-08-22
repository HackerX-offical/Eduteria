package org.pgpainless.key.generation.type.length;

/* JADX INFO: loaded from: classes10.dex */
public enum DiffieHellmanLength implements KeyLength {
    _1024(1024),
    _2048(2048),
    _3072(3072);

    private final int length;

    DiffieHellmanLength(int i) {
        this.length = i;
    }

    @Override // org.pgpainless.key.generation.type.length.KeyLength
    public int getLength() {
        return this.length;
    }
}
