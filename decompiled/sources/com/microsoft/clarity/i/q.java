package com.microsoft.clarity.i;

import com.microsoft.clarity.models.display.paints.shaders.ImageShader;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes9.dex */
public final class q extends p {

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final long f1038d;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public q(long j, com.microsoft.clarity.h.d dVar, d parserFactory) {
        super(j, dVar, parserFactory);
        Intrinsics.checkNotNullParameter(parserFactory, "parserFactory");
        Intrinsics.checkNotNullParameter(parserFactory, "parserFactory");
        this.f1038d = j;
    }

    @Override // com.microsoft.clarity.i.p, com.microsoft.clarity.i.o
    public final /* bridge */ /* synthetic */ boolean b() {
        return true;
    }

    @Override // com.microsoft.clarity.i.p, com.microsoft.clarity.i.o
    public final ImageShader c(g buffer) {
        Intrinsics.checkNotNullParameter(buffer, "buffer");
        ImageShader imageShaderC = super.c(buffer);
        return new ImageShader(imageShaderC.getTX(), imageShaderC.getTY(), imageShaderC.getMatrix(), buffer.i() != 0, imageShaderC.getImage(), imageShaderC.getSampling());
    }

    @Override // com.microsoft.clarity.i.p, com.microsoft.clarity.i.o
    public final /* bridge */ /* synthetic */ boolean c() {
        return false;
    }

    @Override // com.microsoft.clarity.i.p
    public final long d() {
        return this.f1038d;
    }
}
