package com.microsoft.clarity.i;

import com.microsoft.clarity.models.display.blobs.TextBlob;
import com.microsoft.clarity.models.display.blobs.TextBlobRun;
import com.microsoft.clarity.models.display.common.Point;
import com.microsoft.clarity.models.display.common.Rect;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import kotlin.UInt;
import kotlin.UnsignedKt;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes9.dex */
public final class w implements b<TextBlob> {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final com.microsoft.clarity.h.d f1047a;

    public w(com.microsoft.clarity.h.d dVar) {
        this.f1047a = dVar;
    }

    public static TextBlob c(g buffer) {
        Integer numValueOf;
        ArrayList arrayList;
        String str;
        ArrayList arrayList2;
        Intrinsics.checkNotNullParameter(buffer, "buffer");
        Rect rectR = buffer.r();
        ArrayList arrayList3 = new ArrayList();
        while (true) {
            int iG = buffer.g();
            if (iG == 0) {
                return new TextBlob(rectR, arrayList3);
            }
            int iE = buffer.e();
            boolean z = buffer.e() != 0;
            int i = 2;
            buffer.d(2);
            if (z) {
                buffer.i();
            }
            Point pointP = buffer.p();
            int i2 = buffer.i();
            float fUintToDouble = UInt.m12488constructorimpl(UInt.m12488constructorimpl(Integer.MIN_VALUE) & i2) != 0 ? (float) UnsignedKt.uintToDouble(UInt.m12488constructorimpl(UInt.m12488constructorimpl(i2 >>> 16) & 255)) : buffer.f();
            Float fValueOf = UInt.m12488constructorimpl(UInt.m12488constructorimpl(1073741824) & i2) != 0 ? Float.valueOf(buffer.f()) : null;
            Float fValueOf2 = UInt.m12488constructorimpl(UInt.m12488constructorimpl(536870912) & i2) != 0 ? Float.valueOf(buffer.f()) : null;
            if (UInt.m12488constructorimpl(i2 & UInt.m12488constructorimpl(268435456)) != 0) {
                numValueOf = Integer.valueOf(buffer.g());
                if (numValueOf.intValue() < 0) {
                    buffer.d(UInt.m12488constructorimpl(numValueOf.intValue()));
                } else {
                    numValueOf = Integer.valueOf(numValueOf.intValue() - 1);
                }
            } else {
                numValueOf = null;
            }
            int i3 = buffer.i();
            int iA = f.a(i3);
            ArrayList arrayList4 = new ArrayList();
            int i4 = 0;
            while (i4 < iG) {
                arrayList4.add(UInt.m12482boximpl(buffer.h()));
                i4++;
                i = i;
            }
            int i5 = i;
            buffer.d(iA - i3);
            int i6 = buffer.i();
            int iA2 = f.a(i6);
            Integer[] numArr = new Integer[4];
            numArr[0] = 0;
            numArr[1] = 1;
            numArr[i5] = Integer.valueOf(i5);
            numArr[3] = 4;
            ArrayList arrayListArrayListOf = CollectionsKt.arrayListOf(numArr);
            ArrayList arrayList5 = new ArrayList();
            Rect rect = rectR;
            int i7 = 0;
            while (i7 < iG) {
                int i8 = i7;
                ArrayList arrayList6 = new ArrayList();
                boolean z2 = z;
                Object obj = arrayListArrayListOf.get(iE);
                int i9 = iE;
                Intrinsics.checkNotNullExpressionValue(obj, "scalarsPerPositions[pos]");
                int i10 = 0;
                for (int iIntValue = ((Number) obj).intValue(); i10 < iIntValue; iIntValue = iIntValue) {
                    arrayList6.add(Float.valueOf(buffer.f()));
                    i10++;
                }
                arrayList5.add(arrayList6);
                i7 = i8 + 1;
                z = z2;
                iE = i9;
            }
            boolean z3 = z;
            buffer.d(iA2 - i6);
            if (z3) {
                arrayList = new ArrayList();
                int i11 = buffer.i();
                int iA3 = f.a(i11);
                for (int i12 = 0; i12 < iG; i12++) {
                    arrayList.add(UInt.m12482boximpl(buffer.i()));
                }
                buffer.d(iA3 - i11);
                int i13 = buffer.i();
                int iA4 = f.a(i13);
                String strB = buffer.b(i13);
                buffer.d(iA4 - i13);
                str = strB;
            } else {
                arrayList = null;
                str = null;
            }
            ArrayList arrayList7 = new ArrayList(CollectionsKt.collectionSizeOrDefault(arrayList4, 10));
            Iterator it = arrayList4.iterator();
            while (it.hasNext()) {
                arrayList7.add(Long.valueOf(((long) ((UInt) it.next()).getData()) & 4294967295L));
            }
            List mutableList = CollectionsKt.toMutableList((Collection) arrayList7);
            if (arrayList != null) {
                ArrayList arrayList8 = new ArrayList(CollectionsKt.collectionSizeOrDefault(arrayList, 10));
                Iterator it2 = arrayList.iterator();
                while (it2.hasNext()) {
                    arrayList8.add(Long.valueOf(((long) ((UInt) it2.next()).getData()) & 4294967295L));
                }
                arrayList2 = arrayList8;
            } else {
                arrayList2 = null;
            }
            arrayList3.add(new TextBlobRun(pointP, fUintToDouble, fValueOf, fValueOf2, numValueOf, mutableList, arrayList5, arrayList2, str));
            rectR = rect;
        }
    }

    @Override // com.microsoft.clarity.i.b
    public final /* bridge */ /* synthetic */ TextBlob a(g gVar) {
        return c(gVar);
    }

    public final ArrayList b(g buffer) {
        Intrinsics.checkNotNullParameter(buffer, "buffer");
        int i = buffer.i();
        ArrayList arrayList = new ArrayList();
        for (int i2 = 0; i2 < i; i2++) {
            arrayList.add(c(buffer));
        }
        return arrayList;
    }
}
