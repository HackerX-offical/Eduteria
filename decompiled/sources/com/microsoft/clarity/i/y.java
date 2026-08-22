package com.microsoft.clarity.i;

import com.microsoft.clarity.models.display.common.Vertices;
import java.util.ArrayList;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes9.dex */
public abstract class y implements b<Vertices> {
    public final ArrayList b(g buffer) {
        Intrinsics.checkNotNullParameter(buffer, "buffer");
        int i = buffer.i();
        ArrayList arrayList = new ArrayList();
        for (int i2 = 0; i2 < i; i2++) {
            arrayList.add(a(buffer));
        }
        return arrayList;
    }

    @Override // com.microsoft.clarity.i.b
    /* JADX INFO: renamed from: c, reason: merged with bridge method [inline-methods] */
    public abstract Vertices a(g gVar);
}
