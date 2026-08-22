package com.microsoft.clarity.i;

import com.microsoft.clarity.a.c;
import com.microsoft.clarity.models.display.common.IRect;
import com.microsoft.clarity.models.display.images.Image;
import kotlin.UInt;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes9.dex */
public final class j extends i {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final com.microsoft.clarity.h.d f1028a;

    public j(com.microsoft.clarity.h.d dVar) {
        this.f1028a = dVar;
    }

    @Override // com.microsoft.clarity.i.i
    /* JADX INFO: renamed from: c */
    public final Image a(g buffer) {
        byte[] bArrA;
        Intrinsics.checkNotNullParameter(buffer, "buffer");
        int iG = buffer.g();
        int i = buffer.i();
        byte[] bArrA2 = null;
        if (Integer.compareUnsigned(i, 0) > 0) {
            int iA = f.a(i);
            bArrA = buffer.a(i);
            buffer.d(iA - i);
        } else {
            bArrA = null;
        }
        IRect iRectL = (iG & 256) != 0 ? buffer.l() : null;
        if ((iG & 512) != 0) {
            int i2 = buffer.i();
            if (Integer.compareUnsigned(i2, 0) > 0) {
                int iA2 = f.a(i2);
                bArrA2 = buffer.a(i2);
                buffer.d(UInt.m12488constructorimpl(iA2 - i2));
            }
        }
        if (bArrA != null) {
            return new Image(iRectL, bArrA, com.microsoft.clarity.n.b.b(bArrA), bArrA2);
        }
        Image image = com.microsoft.clarity.a.c.f682a;
        return c.a.a();
    }
}
