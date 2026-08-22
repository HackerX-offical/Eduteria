package com.microsoft.clarity.n;

import com.microsoft.clarity.models.display.common.ImageSize;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes9.dex */
public final class a {
    public static ImageSize a(byte[] imageBytes) {
        Intrinsics.checkNotNullParameter(imageBytes, "imageBytes");
        com.microsoft.clarity.i.a aVar = new com.microsoft.clarity.i.a(imageBytes);
        aVar.d(8);
        aVar.d(4);
        aVar.d(4);
        return new ImageSize(aVar.d(), aVar.d(), null);
    }
}
