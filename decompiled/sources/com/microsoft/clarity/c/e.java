package com.microsoft.clarity.c;

import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes9.dex */
public final class e extends Exception {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final String f701a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final String f702b;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public e(String str, String token, String module) {
        super(str);
        Intrinsics.checkNotNullParameter(token, "token");
        Intrinsics.checkNotNullParameter(module, "module");
        this.f701a = token;
        this.f702b = module;
    }

    @Override // java.lang.Throwable
    public final String toString() {
        return com.microsoft.clarity.a.b.a("Unknown SkPicture token '").append(this.f701a).append("' in module '").append(this.f702b).append("'.").toString();
    }
}
