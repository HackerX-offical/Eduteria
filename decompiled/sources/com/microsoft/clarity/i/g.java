package com.microsoft.clarity.i;

import com.microsoft.clarity.models.display.common.IRect;
import com.microsoft.clarity.models.display.common.Point;
import com.microsoft.clarity.models.display.common.RRect;
import com.microsoft.clarity.models.display.common.Rect;
import com.microsoft.clarity.models.display.images.CubicSampling;
import com.microsoft.clarity.models.display.images.NonCubicSampling;
import com.microsoft.clarity.models.display.images.Sampling;
import com.microsoft.clarity.models.display.paints.Color4f;
import java.util.ArrayList;
import java.util.Collections;
import kotlin.UByte;
import kotlin.UInt;
import kotlin.collections.ArraysKt;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes9.dex */
public final class g extends a {
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public g(byte[] bytes) {
        super(bytes);
        Intrinsics.checkNotNullParameter(bytes, "bytes");
    }

    public final Color4f j() {
        return new Color4f(f(), f(), f(), f());
    }

    public final String k() {
        byte[] bArrCopyOfRange = ArraysKt.copyOfRange(b(), c(), c() + 4);
        String string = com.microsoft.clarity.a.b.a(com.microsoft.clarity.a.b.a(com.microsoft.clarity.a.b.a(com.microsoft.clarity.a.b.a("").append((char) bArrCopyOfRange[3]).toString()).append((char) bArrCopyOfRange[2]).toString()).append((char) bArrCopyOfRange[1]).toString()).append((char) bArrCopyOfRange[0]).toString();
        c(c() + 4);
        return string;
    }

    public final IRect l() {
        return new IRect(g(), g(), g(), g());
    }

    public final ArrayList<Float> m() {
        ArrayList<Float> arrayList = new ArrayList<>();
        for (int i = 0; i < 9; i++) {
            arrayList.add(Float.valueOf(f()));
        }
        return arrayList;
    }

    public final ArrayList<Float> n() {
        ArrayList<Float> arrayList = new ArrayList<>();
        for (int i = 0; i < 16; i++) {
            arrayList.add(Float.valueOf(f()));
        }
        int iRint = (int) Math.rint(Math.sqrt(arrayList.size()));
        for (int i2 = 0; i2 < iRint; i2++) {
            for (int i3 = 0; i3 < i2; i3++) {
                Collections.swap(arrayList, (i3 * iRint) + i2, (i2 * iRint) + i3);
            }
        }
        return arrayList;
    }

    public final int o() {
        int iM12411constructorimpl = UByte.m12411constructorimpl(b()[c()]) & 255;
        c(c() + 1);
        return iM12411constructorimpl != 254 ? iM12411constructorimpl != 255 ? UInt.m12488constructorimpl(iM12411constructorimpl) : i() : h();
    }

    public final Point p() {
        return new Point(f(), f());
    }

    public final RRect q() {
        float f2 = f();
        float f3 = f();
        float f4 = f();
        float f5 = f();
        ArrayList arrayList = new ArrayList();
        for (int i = 0; i < 4; i++) {
            ArrayList arrayList2 = new ArrayList();
            for (int i2 = 0; i2 < 2; i2++) {
                arrayList2.add(Float.valueOf(f()));
            }
            arrayList.add(arrayList2);
        }
        return new RRect(f2, f3, f4, f5, arrayList);
    }

    public final Rect r() {
        return new Rect(f(), f(), f(), f());
    }

    public final Sampling s() {
        return g() != 0 ? new CubicSampling(f(), f()) : new NonCubicSampling(g(), g());
    }
}
