package com.microsoft.clarity.m;

import java.io.File;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Lambda;

/* JADX INFO: loaded from: classes9.dex */
public final class b extends Lambda implements Function1<File, Boolean> {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ boolean f1073a;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public b(boolean z) {
        super(1);
        this.f1073a = z;
    }

    @Override // kotlin.jvm.functions.Function1
    public final Boolean invoke(File file) {
        File it = file;
        Intrinsics.checkNotNullParameter(it, "it");
        return Boolean.valueOf(this.f1073a || !it.isDirectory());
    }
}
