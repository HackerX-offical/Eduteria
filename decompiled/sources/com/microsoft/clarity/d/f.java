package com.microsoft.clarity.d;

import java.io.Closeable;
import java.io.EOFException;
import java.io.IOException;
import java.nio.charset.Charset;
import java.nio.charset.StandardCharsets;

/* JADX INFO: loaded from: classes9.dex */
public abstract class f implements Closeable {
    public abstract long a();

    public abstract void a(long j);

    public abstract long b();

    public final float c() {
        return (h() / 65536.0f) + d();
    }

    public abstract short d();

    public final String e() throws IOException {
        Charset charset = StandardCharsets.ISO_8859_1;
        byte[] bArr = new byte[4];
        int i = 0;
        while (i < 4) {
            int i2 = read(bArr, i, 4 - i);
            if (i2 == -1) {
                break;
            }
            i += i2;
        }
        if (i == 4) {
            return new String(bArr, charset);
        }
        throw new IOException("Unexpected end of TTF stream reached");
    }

    public final String f() throws IOException {
        byte[] bArr = new byte[4];
        int i = 0;
        while (i < 4) {
            int i2 = read(bArr, i, 4 - i);
            if (i2 == -1) {
                break;
            }
            i += i2;
        }
        if (i == 4) {
            return new String(bArr, StandardCharsets.US_ASCII);
        }
        throw new IOException("Unexpected end of TTF stream reached");
    }

    public final long g() throws EOFException {
        long j = read();
        long j2 = read();
        long j3 = read();
        long j4 = read();
        if (j4 >= 0) {
            return (j << 24) + (j2 << 16) + (j3 << 8) + j4;
        }
        throw new EOFException();
    }

    public abstract int h();

    public abstract int read();

    public abstract int read(byte[] bArr, int i, int i2);
}
