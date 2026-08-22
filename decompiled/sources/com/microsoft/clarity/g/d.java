package com.microsoft.clarity.g;

import android.app.Activity;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Lambda;

/* JADX INFO: loaded from: classes9.dex */
public final class d extends Lambda implements Function0<Unit> {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ b f941a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final /* synthetic */ Activity f942b;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public d(b bVar, Activity activity) {
        super(0);
        this.f941a = bVar;
        this.f942b = activity;
    }

    @Override // kotlin.jvm.functions.Function0
    public final Unit invoke() throws com.microsoft.clarity.c.a {
        b bVar = this.f941a;
        if (!bVar.p) {
            bVar.b(this.f942b);
        }
        return Unit.INSTANCE;
    }
}
