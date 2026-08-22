package com.microsoft.clarity.i;

import com.microsoft.clarity.a.c;
import com.microsoft.clarity.models.display.common.IRect;
import com.microsoft.clarity.models.display.images.Image;
import java.security.NoSuchAlgorithmException;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes9.dex */
public final class k extends i {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final com.microsoft.clarity.h.d f1029a;

    public k(com.microsoft.clarity.h.d dVar) {
        this.f1029a = dVar;
    }

    @Override // com.microsoft.clarity.i.i
    /* JADX INFO: renamed from: c */
    public final Image a(g buffer) throws NoSuchAlgorithmException {
        Intrinsics.checkNotNullParameter(buffer, "buffer");
        IRect iRectL = buffer.l();
        int i = buffer.i();
        if (i == 0) {
            Image image = com.microsoft.clarity.a.c.f682a;
            return c.a.a();
        }
        int iA = f.a(i);
        byte[] bArrA = buffer.a(i);
        String strB = com.microsoft.clarity.n.b.b(bArrA);
        buffer.d(iA - i);
        return new Image(iRectL, bArrA, strB, null);
    }
}
