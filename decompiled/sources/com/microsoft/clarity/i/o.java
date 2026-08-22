package com.microsoft.clarity.i;

import com.microsoft.clarity.models.display.common.Flattenable;
import com.microsoft.clarity.models.display.paints.Color4f;
import com.microsoft.clarity.models.display.paints.Paint;
import com.microsoft.clarity.models.display.paints.colorfilters.ColorFilter;
import com.microsoft.clarity.models.display.paints.loopers.Looper;
import com.microsoft.clarity.models.display.paints.maskfilters.MaskFilter;
import com.microsoft.clarity.models.display.paints.patheffects.PathEffect;
import com.microsoft.clarity.models.display.paints.shaders.GradientShaderDescriptor;
import com.microsoft.clarity.models.display.paints.shaders.ImageShader;
import com.microsoft.clarity.models.display.paints.shaders.Shader;
import java.util.ArrayList;
import kotlin.UInt;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Reflection;

/* JADX INFO: loaded from: classes9.dex */
public abstract class o implements c {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final com.microsoft.clarity.h.d f1035a;

    public o(com.microsoft.clarity.h.d dVar) {
        this.f1035a = dVar;
    }

    public static GradientShaderDescriptor b(g gVar) {
        ArrayList arrayList;
        int i = gVar.i();
        int iM12488constructorimpl = UInt.m12488constructorimpl(UInt.m12488constructorimpl(i >>> 8) & 15);
        int iM12488constructorimpl2 = UInt.m12488constructorimpl(UInt.m12488constructorimpl(i) & 255);
        int i2 = gVar.i();
        ArrayList arrayList2 = new ArrayList();
        for (int i3 = 0; i3 < i2; i3++) {
            arrayList2.add(gVar.j());
        }
        if (UInt.m12488constructorimpl(536870912 & i) != 0) {
            gVar.d(gVar.i());
        }
        if (UInt.m12488constructorimpl(Integer.MIN_VALUE & i) != 0) {
            ArrayList arrayList3 = new ArrayList();
            int i4 = gVar.i();
            for (int i5 = 0; i5 < i4; i5++) {
                arrayList3.add(Float.valueOf(gVar.f()));
            }
            arrayList = arrayList3;
        } else {
            arrayList = null;
        }
        return new GradientShaderDescriptor(((long) iM12488constructorimpl) & 4294967295L, ((long) iM12488constructorimpl2) & 4294967295L, arrayList2, arrayList, UInt.m12488constructorimpl(i & 1073741824) != 0 ? gVar.m() : null);
    }

    @Override // com.microsoft.clarity.i.c
    public final com.microsoft.clarity.h.d a() {
        return this.f1035a;
    }

    /* JADX WARN: Can't fix incorrect switch cases order, some code will duplicate */
    /* JADX WARN: Failed to restore switch over string. Please report as a decompilation issue */
    /* JADX WARN: Removed duplicated region for block: B:59:0x01be  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final com.microsoft.clarity.models.display.common.Flattenable a(com.microsoft.clarity.i.g r19, java.util.ArrayList r20, kotlin.reflect.KClass r21, boolean r22) {
        /*
            Method dump skipped, instruction units count: 814
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: com.microsoft.clarity.i.o.a(com.microsoft.clarity.i.g, java.util.ArrayList, kotlin.reflect.KClass, boolean):com.microsoft.clarity.models.display.common.Flattenable");
    }

    public final ArrayList a(g buffer, ArrayList factories) {
        Intrinsics.checkNotNullParameter(buffer, "buffer");
        Intrinsics.checkNotNullParameter(factories, "factories");
        int i = buffer.i();
        ArrayList arrayList = new ArrayList();
        for (int i2 = 0; i2 < i; i2++) {
            arrayList.add(b(buffer, factories));
        }
        return arrayList;
    }

    public final Paint b(g gVar, ArrayList arrayList) {
        Color4f color4f;
        ColorFilter colorFilter;
        MaskFilter maskFilter;
        Shader shader;
        Looper looper;
        PathEffect pathEffect;
        ColorFilter colorFilter2;
        Looper looper2;
        float f2 = gVar.f();
        float f3 = gVar.f();
        Color4f color4fJ = gVar.j();
        int i = gVar.i();
        boolean z = UInt.m12488constructorimpl(i & 1) != 0;
        boolean z2 = UInt.m12488constructorimpl(i & 2) != 0;
        int iM12488constructorimpl = UInt.m12488constructorimpl(i >>> 8);
        int iM12488constructorimpl2 = UInt.m12488constructorimpl(iM12488constructorimpl & 255);
        int iM12488constructorimpl3 = UInt.m12488constructorimpl(iM12488constructorimpl >>> 8);
        int iM12488constructorimpl4 = UInt.m12488constructorimpl(iM12488constructorimpl3 & 3);
        int iM12488constructorimpl5 = UInt.m12488constructorimpl(iM12488constructorimpl3 >>> 2);
        int iM12488constructorimpl6 = UInt.m12488constructorimpl(iM12488constructorimpl5 & 3);
        int iM12488constructorimpl7 = UInt.m12488constructorimpl(iM12488constructorimpl5 >>> 2);
        int iM12488constructorimpl8 = UInt.m12488constructorimpl(iM12488constructorimpl7 & 3);
        if (UInt.m12488constructorimpl(UInt.m12488constructorimpl(iM12488constructorimpl7 >>> 4) & 2) != 0) {
            PathEffect pathEffect2 = (PathEffect) a(gVar, arrayList, Reflection.getOrCreateKotlinClass(PathEffect.class), false);
            Shader shader2 = (Shader) a(gVar, arrayList, Reflection.getOrCreateKotlinClass(Shader.class), false);
            MaskFilter maskFilter2 = (MaskFilter) a(gVar, arrayList, Reflection.getOrCreateKotlinClass(MaskFilter.class), false);
            ColorFilter colorFilter3 = (ColorFilter) a(gVar, arrayList, Reflection.getOrCreateKotlinClass(ColorFilter.class), false);
            if (c()) {
                colorFilter2 = colorFilter3;
                looper2 = (Looper) a(gVar, arrayList, Reflection.getOrCreateKotlinClass(Looper.class), false);
            } else {
                colorFilter2 = colorFilter3;
                looper2 = null;
            }
            a(gVar, arrayList, Reflection.getOrCreateKotlinClass(Flattenable.class), true);
            if (b()) {
                a(gVar, arrayList, Reflection.getOrCreateKotlinClass(Flattenable.class), true);
            }
            maskFilter = maskFilter2;
            looper = looper2;
            color4f = color4fJ;
            pathEffect = pathEffect2;
            shader = shader2;
            colorFilter = colorFilter2;
        } else {
            color4f = color4fJ;
            colorFilter = null;
            maskFilter = null;
            shader = null;
            looper = null;
            pathEffect = null;
        }
        return new Paint(color4f, ((long) iM12488constructorimpl8) & 4294967295L, ((long) iM12488constructorimpl2) & 4294967295L, ((long) iM12488constructorimpl4) & 4294967295L, ((long) iM12488constructorimpl6) & 4294967295L, f2, f3, z, z2, colorFilter, maskFilter, shader, looper, pathEffect);
    }

    public abstract boolean b();

    public abstract ImageShader c(g gVar);

    public abstract boolean c();
}
