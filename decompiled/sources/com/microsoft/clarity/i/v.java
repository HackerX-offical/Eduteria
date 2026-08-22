package com.microsoft.clarity.i;

import com.microsoft.clarity.models.display.DisplayFrame;
import com.microsoft.clarity.models.display.common.SkiaPictureHeader;
import com.microsoft.clarity.models.display.paints.Paint;
import com.microsoft.clarity.models.display.paints.shaders.ImageShader;
import com.microsoft.clarity.models.display.paints.shaders.LocalMatrixShader;
import com.microsoft.clarity.models.display.paints.shaders.Shader;
import java.util.ArrayList;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes9.dex */
public final class v implements e {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final d f1045a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final com.microsoft.clarity.h.d f1046b;

    public v(d factory, com.microsoft.clarity.h.d dVar) {
        Intrinsics.checkNotNullParameter(factory, "factory");
        this.f1045a = factory;
        this.f1046b = dVar;
    }

    public final DisplayFrame a(g buffer) {
        Shader shader;
        Intrinsics.checkNotNullParameter(buffer, "buffer");
        Intrinsics.areEqual(buffer.b(8), "skiapict");
        int i = buffer.i();
        buffer.r();
        buffer.e();
        DisplayFrame displayFrame = (DisplayFrame) this.f1045a.a(new SkiaPictureHeader(((long) i) & 4294967295L).getPictureVersion(), this.f1046b).c(buffer);
        ArrayList arrayList = (ArrayList) displayFrame.getImages();
        for (Paint paint : displayFrame.getPaints()) {
            if (paint.getShader() != null && (paint.getShader() instanceof ImageShader)) {
                arrayList.add(((ImageShader) paint.getShader()).getImage());
                shader = paint.getShader();
            } else if (paint.getShader() != null && (paint.getShader() instanceof LocalMatrixShader) && (((LocalMatrixShader) paint.getShader()).getShader() instanceof ImageShader)) {
                arrayList.add(((ImageShader) ((LocalMatrixShader) paint.getShader()).getShader()).getImage());
                shader = ((LocalMatrixShader) paint.getShader()).getShader();
            }
            ((ImageShader) shader).setImageIndex(Integer.valueOf(CollectionsKt.getLastIndex(arrayList)));
        }
        return displayFrame;
    }

    @Override // com.microsoft.clarity.i.e
    public final DisplayFrame a(byte[] byteArray) {
        Intrinsics.checkNotNullParameter(byteArray, "byteArray");
        return a(new g(byteArray));
    }
}
