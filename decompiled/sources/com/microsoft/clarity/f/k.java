package com.microsoft.clarity.f;

import android.app.Activity;
import android.content.Context;
import android.view.View;
import com.microsoft.clarity.h.e;
import com.microsoft.clarity.models.telemetry.ErrorType;
import kotlin.concurrent.TimersKt;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes9.dex */
public final class k implements com.microsoft.clarity.h.e {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final Context f840a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final l f841b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final m f842c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final com.microsoft.clarity.e.e f843d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public boolean f844e;

    public k(Context context, e captureManager, m sessionManager, com.microsoft.clarity.e.e telemetryTracker, com.microsoft.clarity.g.g lifecycleObserver) {
        Intrinsics.checkNotNullParameter(context, "context");
        Intrinsics.checkNotNullParameter(captureManager, "captureManager");
        Intrinsics.checkNotNullParameter(sessionManager, "sessionManager");
        Intrinsics.checkNotNullParameter(telemetryTracker, "telemetryTracker");
        Intrinsics.checkNotNullParameter(lifecycleObserver, "lifecycleObserver");
        this.f840a = context;
        this.f841b = captureManager;
        this.f842c = sessionManager;
        this.f843d = telemetryTracker;
        lifecycleObserver.a(this);
        captureManager.a(new g(this));
        a();
    }

    public final void a() {
        TimersKt.timer("FlowControlTimer", false).schedule(new h(this), 10000L, 10000L);
    }

    public final void a(View view) {
        Intrinsics.checkNotNullParameter(view, "view");
        this.f841b.b(view);
    }

    @Override // com.microsoft.clarity.h.e, com.microsoft.clarity.h.d
    public final void a(Exception exc, ErrorType errorType) {
        e.a.a(exc, errorType);
    }

    public final void a(String str) {
        this.f841b.a(str);
    }

    public final void a(String key, String value) {
        Intrinsics.checkNotNullParameter(key, "key");
        Intrinsics.checkNotNullParameter(value, "value");
        this.f842c.a(key, value);
    }

    public final void b(View view) {
        Intrinsics.checkNotNullParameter(view, "view");
        this.f841b.a(view);
    }

    public final void b(Exception exception, ErrorType errorType) {
        Intrinsics.checkNotNullParameter(exception, "exception");
        Intrinsics.checkNotNullParameter(errorType, "errorType");
        this.f843d.a(exception, errorType, this.f842c.a());
    }

    public final void b(String customUserId) {
        Intrinsics.checkNotNullParameter(customUserId, "customUserId");
        this.f842c.a(customUserId);
    }

    @Override // com.microsoft.clarity.h.e
    public final void onActivityDestroyed(Activity activity) {
        e.a.a(activity);
    }

    @Override // com.microsoft.clarity.h.e
    public final void onActivityPaused(Activity activity) {
        Intrinsics.checkNotNullParameter(activity, "activity");
        this.f843d.a();
    }

    @Override // com.microsoft.clarity.h.e
    public final void onActivityResumed(Activity activity) {
        e.a.c(activity);
    }
}
