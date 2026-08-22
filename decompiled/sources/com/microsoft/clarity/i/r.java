package com.microsoft.clarity.i;

import com.microsoft.clarity.models.display.images.Image;
import com.microsoft.clarity.models.display.paints.shaders.ImageShader;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes9.dex */
public final class r extends o {

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final long f1039b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final d f1040c;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public r(long j, com.microsoft.clarity.h.d dVar, d parserFactory) {
        super(dVar);
        Intrinsics.checkNotNullParameter(parserFactory, "parserFactory");
        this.f1039b = j;
        this.f1040c = parserFactory;
    }

    @Override // com.microsoft.clarity.i.o
    public final boolean b() {
        return false;
    }

    @Override // com.microsoft.clarity.i.o
    public final ImageShader c(g buffer) {
        Intrinsics.checkNotNullParameter(buffer, "buffer");
        int i = buffer.i();
        int i2 = buffer.i();
        return new ImageShader(((long) i) & 4294967295L, 4294967295L & ((long) i2), buffer.m(), false, (Image) this.f1040c.b(this.f1039b, a()).d(buffer), null);
    }

    @Override // com.microsoft.clarity.i.o
    public final boolean c() {
        return true;
    }
}
