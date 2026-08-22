package com.microsoft.clarity;

import android.os.Handler;
import com.microsoft.clarity.a;
import com.microsoft.clarity.models.telemetry.ErrorType;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Lambda;

/* JADX INFO: loaded from: classes9.dex */
public final class g extends Lambda implements Function1<Exception, Unit> {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final g f880a = new g();

    public g() {
        super(1);
    }

    @Override // kotlin.jvm.functions.Function1
    public final Unit invoke(Exception exc) {
        Exception it = exc;
        Intrinsics.checkNotNullParameter(it, "it");
        Handler handler = a.f656a;
        a.C0182a.a(it, ErrorType.SettingCustomUserId);
        return Unit.INSTANCE;
    }
}
