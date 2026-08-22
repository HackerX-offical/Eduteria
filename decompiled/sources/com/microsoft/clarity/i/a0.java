package com.microsoft.clarity.i;

import com.microsoft.clarity.models.display.common.Vertices;
import java.util.ArrayList;
import java.util.Iterator;
import kotlin.UInt;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes9.dex */
public final class a0 extends y {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final com.microsoft.clarity.h.d f1026a;

    public a0(com.microsoft.clarity.h.d dVar) {
        this.f1026a = dVar;
    }

    @Override // com.microsoft.clarity.i.y
    /* JADX INFO: renamed from: c */
    public final Vertices a(g buffer) {
        ArrayList arrayList;
        ArrayList arrayList2;
        int i;
        ArrayList arrayList3;
        ArrayList<ArrayList> arrayList4;
        int i2;
        ArrayList arrayList5;
        ArrayList arrayList6;
        Intrinsics.checkNotNullParameter(buffer, "buffer");
        buffer.i();
        int i3 = buffer.i();
        int iG = buffer.g();
        int iG2 = buffer.g();
        boolean z = UInt.m12488constructorimpl(i3 & 256) != 0;
        boolean z2 = UInt.m12488constructorimpl(i3 & 512) != 0;
        int iM12488constructorimpl = UInt.m12488constructorimpl(i3 & 255);
        boolean z3 = UInt.m12488constructorimpl(i3 & 1024) != 0;
        boolean z4 = UInt.m12488constructorimpl(i3 & 2048) == 0;
        ArrayList arrayList7 = new ArrayList();
        ArrayList arrayList8 = new ArrayList();
        for (int i4 = 0; i4 < iG; i4++) {
            arrayList7.add(buffer.p());
        }
        if (z) {
            ArrayList arrayList9 = new ArrayList();
            for (int i5 = 0; i5 < iG; i5++) {
                arrayList9.add(buffer.p());
            }
            arrayList = arrayList9;
        } else {
            arrayList = null;
        }
        if (z2) {
            arrayList2 = new ArrayList();
            for (int i6 = 0; i6 < iG; i6++) {
                arrayList2.add(UInt.m12482boximpl(buffer.i()));
            }
        } else {
            arrayList2 = null;
        }
        if (z3) {
            arrayList4 = new ArrayList();
            arrayList3 = new ArrayList();
            i = 0;
            for (int i7 = 0; i7 < iG; i7++) {
                arrayList4.add(CollectionsKt.arrayListOf(UInt.m12482boximpl(buffer.i()), UInt.m12482boximpl(buffer.i()), UInt.m12482boximpl(buffer.i()), UInt.m12482boximpl(buffer.i())));
            }
            int i8 = 0;
            while (true) {
                i2 = iG;
                if (i8 >= iG) {
                    break;
                }
                arrayList3.add(CollectionsKt.arrayListOf(Float.valueOf(buffer.f()), Float.valueOf(buffer.f()), Float.valueOf(buffer.f()), Float.valueOf(buffer.f())));
                i8++;
                iG = i2;
            }
        } else {
            i = 0;
            arrayList3 = null;
            arrayList4 = null;
            i2 = iG;
        }
        for (int i9 = i; i9 < iG2; i9++) {
            arrayList8.add(UInt.m12482boximpl(buffer.h()));
        }
        int i10 = i2 * 8;
        int i11 = z ? i10 : i;
        int i12 = z2 ? i2 * 4 : i;
        int i13 = z3 ? i2 * 16 : i;
        if (z3) {
            i = i2 * 16;
        }
        int i14 = iG2 * 2;
        buffer.d((((((f.a(UInt.m12488constructorimpl(((((i10 + i11) + i12) + i13) + i) + i14)) - i10) - i11) - i12) - i13) - i) - i14);
        long j = ((long) iM12488constructorimpl) & 4294967295L;
        if (arrayList2 != null) {
            ArrayList arrayList10 = new ArrayList(CollectionsKt.collectionSizeOrDefault(arrayList2, 10));
            Iterator it = arrayList2.iterator();
            while (it.hasNext()) {
                arrayList10.add(Long.valueOf(((long) ((UInt) it.next()).getData()) & 4294967295L));
            }
            arrayList5 = arrayList10;
        } else {
            arrayList5 = null;
        }
        if (arrayList4 != null) {
            ArrayList arrayList11 = new ArrayList(CollectionsKt.collectionSizeOrDefault(arrayList4, 10));
            for (ArrayList arrayList12 : arrayList4) {
                ArrayList arrayList13 = new ArrayList(CollectionsKt.collectionSizeOrDefault(arrayList12, 10));
                Iterator it2 = arrayList12.iterator();
                while (it2.hasNext()) {
                    arrayList13.add(Long.valueOf(((long) ((UInt) it2.next()).getData()) & 4294967295L));
                }
                arrayList11.add(arrayList13);
            }
            arrayList6 = arrayList11;
        } else {
            arrayList6 = null;
        }
        ArrayList arrayList14 = new ArrayList(CollectionsKt.collectionSizeOrDefault(arrayList8, 10));
        Iterator it3 = arrayList8.iterator();
        while (it3.hasNext()) {
            arrayList14.add(Long.valueOf(((long) ((UInt) it3.next()).getData()) & 4294967295L));
        }
        return new Vertices(j, z4, arrayList7, arrayList, arrayList5, arrayList6, arrayList3, arrayList14);
    }
}
