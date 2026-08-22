package com.microsoft.clarity.d;

import androidx.collection.SieveCacheKt;
import java.io.EOFException;
import java.io.IOException;

/* JADX INFO: loaded from: classes9.dex */
public final class d extends f {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public byte[] f714a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public int f715b = 0;

    public d(byte[] bArr) {
        this.f714a = bArr;
    }

    @Override // com.microsoft.clarity.d.f
    public final long a() {
        return this.f715b;
    }

    @Override // com.microsoft.clarity.d.f
    public final void a(long j) throws IOException {
        if (j < 0 || j > SieveCacheKt.NodeLinkMask) {
            throw new IOException("Illegal seek position: " + j);
        }
        this.f715b = (int) j;
    }

    @Override // com.microsoft.clarity.d.f
    public final long b() {
        return this.f714a.length;
    }

    @Override // java.io.Closeable, java.lang.AutoCloseable
    public final void close() {
    }

    @Override // com.microsoft.clarity.d.f
    public final short d() throws EOFException {
        int i = read();
        int i2 = read();
        if ((i | i2) >= 0) {
            return (short) ((i << 8) + i2);
        }
        throw new EOFException();
    }

    @Override // com.microsoft.clarity.d.f
    public final int h() throws EOFException {
        int i = read();
        int i2 = read();
        if ((i | i2) >= 0) {
            return (i << 8) + i2;
        }
        throw new EOFException();
    }

    @Override // com.microsoft.clarity.d.f
    public final int read() {
        int i = this.f715b;
        byte[] bArr = this.f714a;
        if (i >= bArr.length) {
            return -1;
        }
        byte b2 = bArr[i];
        this.f715b = i + 1;
        return (b2 + 256) % 256;
    }

    @Override // com.microsoft.clarity.d.f
    public final int read(byte[] bArr, int i, int i2) {
        int i3 = this.f715b;
        byte[] bArr2 = this.f714a;
        if (i3 >= bArr2.length) {
            return -1;
        }
        int iMin = Math.min(i2, bArr2.length - i3);
        System.arraycopy(this.f714a, this.f715b, bArr, i, iMin);
        this.f715b += iMin;
        return iMin;
    }
}
