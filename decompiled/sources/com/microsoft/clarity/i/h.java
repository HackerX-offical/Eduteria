package com.microsoft.clarity.i;

import com.microsoft.clarity.i.b;
import java.util.ArrayList;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes9.dex */
public final class h implements b<String> {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final com.microsoft.clarity.h.d f1027a;

    public h(com.microsoft.clarity.h.d dVar) {
        this.f1027a = dVar;
    }

    @Override // com.microsoft.clarity.i.b
    public final String a(g buffer) {
        Intrinsics.checkNotNullParameter(buffer, "buffer");
        return buffer.b(buffer.o());
    }

    public final ArrayList b(g buffer) {
        Intrinsics.checkNotNullParameter(buffer, "buffer");
        buffer.i();
        int iG = buffer.g();
        ArrayList arrayList = new ArrayList();
        for (int i = 0; i < iG; i++) {
            arrayList.add((String) b.a.a(this, buffer));
        }
        return arrayList;
    }
}
