package com.microsoft.clarity.i;

import com.microsoft.clarity.models.display.commands.DrawVertices;
import java.util.ArrayList;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes9.dex */
public final class n extends l {

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final com.microsoft.clarity.h.d f1034d;

    public n(com.microsoft.clarity.h.d dVar) {
        this.f1034d = dVar;
    }

    @Override // com.microsoft.clarity.i.c
    public final com.microsoft.clarity.h.d a() {
        return this.f1034d;
    }

    @Override // com.microsoft.clarity.i.l
    public final DrawVertices e(g buffer) {
        Intrinsics.checkNotNullParameter(buffer, "buffer");
        int iG = buffer.g() - 1;
        int iG2 = buffer.g() - 1;
        int iG3 = buffer.g();
        ArrayList arrayList = new ArrayList();
        for (int i = 0; i < iG3; i++) {
            arrayList.add(l.d(buffer));
        }
        return new DrawVertices(iG2, ((long) buffer.i()) & 4294967295L, iG, arrayList);
    }
}
