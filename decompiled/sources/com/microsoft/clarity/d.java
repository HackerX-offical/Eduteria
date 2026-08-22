package com.microsoft.clarity;

import android.os.Handler;
import com.microsoft.clarity.a;
import com.microsoft.clarity.models.telemetry.ErrorType;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Lambda;

/* JADX INFO: loaded from: classes9.dex */
public final class d extends Lambda implements Function1<Exception, Unit> {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final d f704a = new d();

    public d() {
        super(1);
    }

    @Override // kotlin.jvm.functions.Function1
    public final Unit invoke(Exception exc) {
        Exception it = exc;
        Intrinsics.checkNotNullParameter(it, "it");
        Handler handler = a.f656a;
        a.C0182a.a(it, ErrorType.Initialization);
        return Unit.INSTANCE;
    }
}
