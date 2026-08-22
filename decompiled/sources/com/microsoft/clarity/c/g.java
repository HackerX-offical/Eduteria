package com.microsoft.clarity.c;

import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes9.dex */
public final class g extends Exception {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final String f703a;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public g() {
        super("Worker has surpassed the retrial limit!");
        Intrinsics.checkNotNullParameter("Worker has surpassed the retrial limit!", "message");
        this.f703a = "Worker has surpassed the retrial limit!";
    }

    @Override // java.lang.Throwable
    public final String getMessage() {
        return this.f703a;
    }
}
