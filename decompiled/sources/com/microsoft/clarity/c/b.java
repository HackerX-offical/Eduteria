package com.microsoft.clarity.c;

import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes9.dex */
public final class b extends Exception {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final String f700a;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public b(String message) {
        super(message);
        Intrinsics.checkNotNullParameter(message, "message");
        this.f700a = message;
    }

    @Override // java.lang.Throwable
    public final String getMessage() {
        return this.f700a;
    }
}
