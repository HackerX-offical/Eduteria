package com.microsoft.clarity.d;

import java.io.Closeable;
import java.io.IOException;
import java.util.Set;

/* JADX INFO: loaded from: classes9.dex */
public final class i implements Closeable {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final f f722a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final int f723b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final long[] f724c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final Set<Integer> f725d;

    public interface a {
        void a(j jVar);
    }

    public i(d dVar, Set set) throws IOException {
        this.f722a = dVar;
        this.f725d = set;
        if (!dVar.f().equals("ttcf")) {
            throw new IOException("Missing TTC header");
        }
        float fC = dVar.c();
        int iG = (int) dVar.g();
        this.f723b = iG;
        if (iG <= 0 || iG > 1024) {
            throw new IOException("Invalid number of fonts " + iG);
        }
        this.f724c = new long[iG];
        for (int i = 0; i < this.f723b; i++) {
            this.f724c[i] = dVar.g();
        }
        if (fC >= 2.0f) {
            dVar.h();
            dVar.h();
            dVar.h();
        }
    }

    public i(byte[] bArr, Set<Integer> set) {
        this(new d(bArr), set);
    }

    public final void a(a aVar) {
        for (int i = 0; i < this.f723b; i++) {
            this.f722a.a(this.f724c[i]);
            aVar.a(g.a(new e(this.f722a), this.f725d));
        }
    }

    @Override // java.io.Closeable, java.lang.AutoCloseable
    public final void close() throws IOException {
        this.f722a.close();
    }
}
