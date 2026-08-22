package com.microsoft.clarity.i;

import com.microsoft.clarity.i.b;
import com.microsoft.clarity.models.display.DisplayFrame;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes9.dex */
public final class u implements b<DisplayFrame> {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final d f1042a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final long f1043b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final com.microsoft.clarity.h.d f1044c;

    public u(long j, com.microsoft.clarity.h.d dVar, d parserFactory) {
        Intrinsics.checkNotNullParameter(parserFactory, "parserFactory");
        this.f1042a = parserFactory;
        this.f1043b = j;
        this.f1044c = dVar;
    }

    @Override // com.microsoft.clarity.i.c
    public final com.microsoft.clarity.h.d a() {
        return this.f1044c;
    }

    /* JADX WARN: Code restructure failed: missing block: B:43:0x0187, code lost:
    
        r2 = "Unknown SkPicture tag " + r3;
        r3 = com.microsoft.clarity.i.u.class.getName();
        kotlin.jvm.internal.Intrinsics.checkNotNullExpressionValue(r3, "this.javaClass.name");
     */
    /* JADX WARN: Code restructure failed: missing block: B:44:0x01a8, code lost:
    
        throw new com.microsoft.clarity.c.e(r2, "Tag", r3);
     */
    /* JADX WARN: Failed to restore switch over string. Please report as a decompilation issue */
    /* JADX WARN: Removed duplicated region for block: B:42:0x0183 A[LOOP:0: B:3:0x0055->B:42:0x0183, LOOP_END] */
    /* JADX WARN: Removed duplicated region for block: B:56:0x016b A[SYNTHETIC] */
    @Override // com.microsoft.clarity.i.b
    /* JADX INFO: renamed from: b, reason: merged with bridge method [inline-methods] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final com.microsoft.clarity.models.display.DisplayFrame a(com.microsoft.clarity.i.g r23) throws com.microsoft.clarity.c.e {
        /*
            Method dump skipped, instruction units count: 468
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: com.microsoft.clarity.i.u.a(com.microsoft.clarity.i.g):com.microsoft.clarity.models.display.DisplayFrame");
    }

    public final Object c(g gVar) {
        return (DisplayFrame) b.a.a(this, gVar);
    }
}
