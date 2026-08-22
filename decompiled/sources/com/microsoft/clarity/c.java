package com.microsoft.clarity;

import android.app.Activity;
import android.content.Context;
import android.os.Handler;
import com.microsoft.clarity.b.a;
import com.microsoft.clarity.models.LogLevel;
import com.microsoft.clarity.n.i;
import com.microsoft.clarity.n.m;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Lambda;

/* JADX INFO: loaded from: classes9.dex */
public final class c extends Lambda implements Function0<Unit> {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ ClarityConfig f696a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final /* synthetic */ Context f697b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final /* synthetic */ Activity f698c;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public c(Activity activity, Context context, ClarityConfig clarityConfig) {
        super(0);
        this.f696a = clarityConfig;
        this.f697b = context;
        this.f698c = activity;
    }

    @Override // kotlin.jvm.functions.Function0
    public final Unit invoke() {
        Handler handler = a.f656a;
        ClarityConfig clarityConfig = this.f696a;
        i.f1092a = LogLevel.values()[Math.min(clarityConfig.getLogLevel().ordinal(), LogLevel.valueOf("None").ordinal())];
        i.d("Initialize Clarity.");
        i.b("Initialization configs: " + this.f696a);
        com.microsoft.clarity.g.g gVar = com.microsoft.clarity.b.a.f689a;
        m.a("Clarity_Initialize", a.C0184a.a(this.f697b, this.f696a.getProjectId()), new b(this.f698c, this.f697b, this.f696a));
        return Unit.INSTANCE;
    }
}
