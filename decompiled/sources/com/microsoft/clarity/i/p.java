package com.microsoft.clarity.i;

import com.microsoft.clarity.models.display.images.Image;
import com.microsoft.clarity.models.display.images.Sampling;
import com.microsoft.clarity.models.display.paints.shaders.ImageShader;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes9.dex */
public class p extends o {

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final long f1036b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final d f1037c;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public p(long j, com.microsoft.clarity.h.d dVar, d parserFactory) {
        super(dVar);
        Intrinsics.checkNotNullParameter(parserFactory, "parserFactory");
        this.f1036b = j;
        this.f1037c = parserFactory;
    }

    @Override // com.microsoft.clarity.i.o
    public boolean b() {
        return false;
    }

    @Override // com.microsoft.clarity.i.o
    public ImageShader c(g buffer) {
        Intrinsics.checkNotNullParameter(buffer, "buffer");
        int i = buffer.i();
        int i2 = buffer.i();
        Sampling samplingS = buffer.s();
        return new ImageShader(((long) i) & 4294967295L, 4294967295L & ((long) i2), buffer.m(), false, (Image) this.f1037c.b(d(), a()).d(buffer), samplingS);
    }

    @Override // com.microsoft.clarity.i.o
    public boolean c() {
        return true;
    }

    public long d() {
        return this.f1036b;
    }
}
