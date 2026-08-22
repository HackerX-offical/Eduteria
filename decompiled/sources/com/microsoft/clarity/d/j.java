package com.microsoft.clarity.d;

import java.io.Closeable;
import java.io.IOException;
import java.util.HashMap;
import java.util.Set;

/* JADX INFO: loaded from: classes9.dex */
public final class j implements Closeable {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public int f726a = -1;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public HashMap f727b = new HashMap();

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final f f728c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public Set<Integer> f729d;

    public j(f fVar) {
        this.f728c = fVar;
    }

    public final b a() {
        return (b) a("cmap");
    }

    public final synchronized h a(String str) {
        h hVar;
        hVar = (h) this.f727b.get(str);
        if (hVar != null && !hVar.f720d) {
            synchronized (this.f728c) {
                long jA = this.f728c.a();
                this.f728c.a(hVar.f718b);
                hVar.a(this, this.f728c);
                this.f728c.a(jA);
            }
        }
        return hVar;
    }

    @Override // java.io.Closeable, java.lang.AutoCloseable
    public final void close() throws IOException {
        this.f728c.close();
    }

    public final void finalize() throws Throwable {
        super.finalize();
        this.f728c.close();
    }
}
