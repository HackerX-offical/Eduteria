package com.microsoft.clarity.i;

import com.microsoft.clarity.models.display.common.Vertices;
import java.util.ArrayList;
import java.util.Iterator;
import kotlin.UInt;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes9.dex */
public final class z extends y {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final com.microsoft.clarity.h.d f1049a;

    public z(com.microsoft.clarity.h.d dVar) {
        this.f1049a = dVar;
    }

    @Override // com.microsoft.clarity.i.y
    /* JADX INFO: renamed from: c */
    public final Vertices a(g buffer) {
        ArrayList arrayList;
        ArrayList arrayList2;
        Intrinsics.checkNotNullParameter(buffer, "buffer");
        int i = buffer.i();
        int iG = buffer.g();
        int iG2 = buffer.g();
        boolean z = UInt.m12488constructorimpl(i & 256) != 0;
        boolean z2 = UInt.m12488constructorimpl(i & 512) != 0;
        int iM12488constructorimpl = UInt.m12488constructorimpl(i & 255);
        ArrayList arrayList3 = new ArrayList();
        ArrayList arrayList4 = new ArrayList();
        buffer.i();
        for (int i2 = 0; i2 < iG; i2++) {
            arrayList3.add(buffer.p());
        }
        ArrayList arrayList5 = null;
        if (buffer.i() != 0) {
            ArrayList arrayList6 = new ArrayList();
            for (int i3 = 0; i3 < iG; i3++) {
                arrayList6.add(buffer.p());
            }
            arrayList = arrayList6;
        } else {
            arrayList = null;
        }
        if (buffer.i() != 0) {
            arrayList2 = new ArrayList();
            for (int i4 = 0; i4 < iG; i4++) {
                arrayList2.add(UInt.m12482boximpl(buffer.i()));
            }
        } else {
            arrayList2 = null;
        }
        buffer.i();
        for (int i5 = 0; i5 < iG2; i5++) {
            arrayList4.add(UInt.m12482boximpl(buffer.h()));
        }
        int i6 = iG * 8;
        int i7 = z ? i6 : 0;
        int i8 = z2 ? iG * 4 : 0;
        int i9 = iG2 * 2;
        buffer.d((((f.a(UInt.m12488constructorimpl(((i6 + i7) + i8) + i9)) - i6) - i7) - i8) - i9);
        long j = ((long) iM12488constructorimpl) & 4294967295L;
        if (arrayList2 != null) {
            arrayList5 = new ArrayList(CollectionsKt.collectionSizeOrDefault(arrayList2, 10));
            Iterator it = arrayList2.iterator();
            while (it.hasNext()) {
                arrayList5.add(Long.valueOf(((long) ((UInt) it.next()).getData()) & 4294967295L));
            }
        }
        ArrayList arrayList7 = arrayList5;
        ArrayList arrayList8 = new ArrayList(CollectionsKt.collectionSizeOrDefault(arrayList4, 10));
        Iterator it2 = arrayList4.iterator();
        while (it2.hasNext()) {
            arrayList8.add(Long.valueOf(((long) ((UInt) it2.next()).getData()) & 4294967295L));
        }
        return new Vertices(j, false, arrayList3, arrayList, arrayList7, null, null, arrayList8);
    }
}
