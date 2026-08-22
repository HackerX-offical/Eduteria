package com.microsoft.clarity.f;

import com.microsoft.clarity.models.display.DisplayFrame;
import com.microsoft.clarity.models.display.ErrorDisplayFrame;
import com.microsoft.clarity.models.ingest.WebViewAnalyticsEvent;
import com.microsoft.clarity.models.ingest.WebViewMutationEvent;
import com.microsoft.clarity.models.ingest.analytics.AnalyticsEvent;
import com.microsoft.clarity.models.telemetry.ErrorType;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes9.dex */
public final class g implements com.microsoft.clarity.h.a {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ k f836a;

    public g(k kVar) {
        this.f836a = kVar;
    }

    @Override // com.microsoft.clarity.h.a
    public final void a(DisplayFrame frame) {
        Intrinsics.checkNotNullParameter(frame, "frame");
        this.f836a.f842c.a(frame);
    }

    @Override // com.microsoft.clarity.h.a
    public final void a(ErrorDisplayFrame errorDisplayFrame) {
        Intrinsics.checkNotNullParameter(errorDisplayFrame, "errorDisplayFrame");
        this.f836a.f842c.a(errorDisplayFrame);
    }

    @Override // com.microsoft.clarity.h.a
    public final void a(WebViewAnalyticsEvent event) {
        Intrinsics.checkNotNullParameter(event, "event");
        this.f836a.f842c.a(event);
    }

    @Override // com.microsoft.clarity.h.a
    public final void a(WebViewMutationEvent event) {
        Intrinsics.checkNotNullParameter(event, "event");
        this.f836a.f842c.a(event);
    }

    @Override // com.microsoft.clarity.h.d
    public final void a(Exception exception, ErrorType errorType) {
        Intrinsics.checkNotNullParameter(exception, "exception");
        Intrinsics.checkNotNullParameter(errorType, "errorType");
        this.f836a.b(exception, errorType);
    }

    @Override // com.microsoft.clarity.h.a
    public final void b(AnalyticsEvent event) {
        Intrinsics.checkNotNullParameter(event, "event");
        this.f836a.f842c.a(event);
    }
}
