package com.microsoft.clarity.i;

import com.microsoft.clarity.models.display.common.Point;
import com.microsoft.clarity.models.display.common.RRect;
import com.microsoft.clarity.models.display.paths.AddRRectPathVerb;
import com.microsoft.clarity.models.display.paths.ClosePathVerb;
import com.microsoft.clarity.models.display.paths.ConicPathVerb;
import com.microsoft.clarity.models.display.paths.CubicPathVerb;
import com.microsoft.clarity.models.display.paths.DonePathVerb;
import com.microsoft.clarity.models.display.paths.LinePathVerb;
import com.microsoft.clarity.models.display.paths.MovePathVerb;
import com.microsoft.clarity.models.display.paths.Path;
import com.microsoft.clarity.models.display.paths.PathVerb;
import com.microsoft.clarity.models.display.paths.QuadPathVerb;
import java.util.ArrayList;
import java.util.Iterator;
import kotlin.UInt;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes9.dex */
public final class t implements b<Path> {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final com.microsoft.clarity.h.d f1041a;

    public t(com.microsoft.clarity.h.d dVar) {
        this.f1041a = dVar;
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r11v0, types: [java.lang.Iterable, java.util.ArrayList] */
    /* JADX WARN: Type inference failed for: r11v1, types: [java.util.List] */
    /* JADX WARN: Type inference failed for: r11v8, types: [java.util.List] */
    public static Path c(g buffer) {
        int i;
        PathVerb movePathVerb;
        PathVerb closePathVerb;
        Intrinsics.checkNotNullParameter(buffer, "buffer");
        int iG = buffer.g();
        int i2 = iG & 255;
        int i3 = (iG >> 8) & 3;
        if (i2 <= 3) {
            return null;
        }
        if (i2 != 4 && i2 != 5) {
            return null;
        }
        int i4 = 0;
        if (((iG >> 28) & 15) != 0) {
            boolean z = ((iG >> 26) & 3) != 0;
            RRect rRectQ = buffer.q();
            buffer.i();
            return new Path(i3, CollectionsKt.arrayListOf(new AddRRectPathVerb(rRectQ, z)));
        }
        boolean z2 = i2 != 5;
        int iG2 = buffer.g();
        int iG3 = buffer.g();
        int iG4 = buffer.g();
        int i5 = (iG3 * 4) + (iG2 * 8) + iG4;
        ArrayList arrayList = new ArrayList();
        ArrayList arrayList2 = new ArrayList();
        ?? arrayList3 = new ArrayList();
        for (int i6 = 0; i6 < iG2; i6++) {
            arrayList.add(buffer.p());
        }
        for (int i7 = 0; i7 < iG3; i7++) {
            arrayList2.add(Float.valueOf(buffer.f()));
        }
        for (int i8 = 0; i8 < iG4; i8++) {
            arrayList3.add(Integer.valueOf(buffer.e()));
        }
        if (z2) {
            arrayList3 = CollectionsKt.reversed(arrayList3);
        }
        ArrayList arrayList4 = new ArrayList();
        Iterator it = arrayList3.iterator();
        int i9 = 0;
        while (it.hasNext()) {
            switch (((Number) it.next()).intValue()) {
                case 0:
                    i = i4 + 1;
                    movePathVerb = new MovePathVerb(((Point) arrayList.get(i4)).getX(), ((Point) arrayList.get(i4)).getY());
                    i4 = i;
                    closePathVerb = movePathVerb;
                    break;
                case 1:
                    i = i4 + 1;
                    movePathVerb = new LinePathVerb(((Point) arrayList.get(i4)).getX(), ((Point) arrayList.get(i4)).getY());
                    i4 = i;
                    closePathVerb = movePathVerb;
                    break;
                case 2:
                    i = i4 + 2;
                    float x = ((Point) arrayList.get(i4)).getX();
                    float y = ((Point) arrayList.get(i4)).getY();
                    int i10 = i4 + 1;
                    movePathVerb = new QuadPathVerb(x, y, ((Point) arrayList.get(i10)).getX(), ((Point) arrayList.get(i10)).getY());
                    i4 = i;
                    closePathVerb = movePathVerb;
                    break;
                case 3:
                    int i11 = i4 + 2;
                    int i12 = i9 + 1;
                    float x2 = ((Point) arrayList.get(i4)).getX();
                    float y2 = ((Point) arrayList.get(i4)).getY();
                    int i13 = i4 + 1;
                    float x3 = ((Point) arrayList.get(i13)).getX();
                    float y3 = ((Point) arrayList.get(i13)).getY();
                    Object obj = arrayList2.get(i9);
                    Intrinsics.checkNotNullExpressionValue(obj, "conics[conicIndex - 1]");
                    PathVerb conicPathVerb = new ConicPathVerb(x2, y2, x3, y3, ((Number) obj).floatValue());
                    i4 = i11;
                    i9 = i12;
                    closePathVerb = conicPathVerb;
                    break;
                case 4:
                    i = i4 + 3;
                    int i14 = i4 + 1;
                    int i15 = i4 + 2;
                    movePathVerb = new CubicPathVerb(((Point) arrayList.get(i4)).getX(), ((Point) arrayList.get(i4)).getY(), ((Point) arrayList.get(i14)).getX(), ((Point) arrayList.get(i14)).getY(), ((Point) arrayList.get(i15)).getX(), ((Point) arrayList.get(i15)).getY());
                    i4 = i;
                    closePathVerb = movePathVerb;
                    break;
                case 5:
                    closePathVerb = new ClosePathVerb();
                    break;
                case 6:
                    closePathVerb = new DonePathVerb();
                    break;
                default:
                    closePathVerb = null;
                    break;
            }
            if (closePathVerb != null) {
                arrayList4.add(closePathVerb);
            }
        }
        buffer.d(f.a(UInt.m12488constructorimpl(i5)) - i5);
        return new Path(i3, arrayList4);
    }

    @Override // com.microsoft.clarity.i.b
    public final /* bridge */ /* synthetic */ Path a(g gVar) {
        return c(gVar);
    }

    public final ArrayList b(g buffer) {
        Intrinsics.checkNotNullParameter(buffer, "buffer");
        int i = buffer.i();
        buffer.i();
        ArrayList arrayList = new ArrayList();
        for (int i2 = 0; i2 < i; i2++) {
            Path pathC = c(buffer);
            if (pathC != null) {
                arrayList.add(pathC);
            }
        }
        return arrayList;
    }
}
