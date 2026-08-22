package com.microsoft.clarity.f;

import com.microsoft.clarity.models.ingest.analytics.AnalyticsEvent;
import com.microsoft.clarity.models.observers.UserInteraction;
import com.microsoft.clarity.models.telemetry.ErrorType;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes9.dex */
public final class b implements com.microsoft.clarity.h.f {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ e f815a;

    public b(e eVar) {
        this.f815a = eVar;
    }

    @Override // com.microsoft.clarity.h.f
    public final void a(AnalyticsEvent event) {
        Intrinsics.checkNotNullParameter(event, "event");
        this.f815a.f824g.add(new UserInteraction(event));
    }

    @Override // com.microsoft.clarity.h.d
    public final void a(Exception exception, ErrorType errorType) {
        Intrinsics.checkNotNullParameter(exception, "exception");
        Intrinsics.checkNotNullParameter(errorType, "errorType");
        e.a(this.f815a, exception, errorType);
    }
}
