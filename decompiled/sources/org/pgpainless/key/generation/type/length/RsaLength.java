package org.pgpainless.key.generation.type.length;

/* JADX INFO: loaded from: classes10.dex */
public enum RsaLength implements KeyLength {
    _1024(1024),
    _2048(2048),
    _3072(3072),
    _4096(4096),
    _8192(8192);

    private final int length;

    RsaLength(int i) {
        this.length = i;
    }

    @Override // org.pgpainless.key.generation.type.length.KeyLength
    public int getLength() {
        return this.length;
    }
}
