package com.microsoft.clarity.c;

import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes9.dex */
public final class a extends Exception {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final String f699a;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public a() {
        super("View hierarchy traversal failed.");
        Intrinsics.checkNotNullParameter("View hierarchy traversal failed.", "message");
        this.f699a = "View hierarchy traversal failed.";
    }

    @Override // java.lang.Throwable
    public final String getMessage() {
        return this.f699a;
    }
}
