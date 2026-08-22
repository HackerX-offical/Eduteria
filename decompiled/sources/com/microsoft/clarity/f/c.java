package com.microsoft.clarity.f;

import com.microsoft.clarity.models.observers.SerializedWebViewEvent;
import com.microsoft.clarity.models.telemetry.ErrorType;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes9.dex */
public final class c implements com.microsoft.clarity.h.g {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ e f816a;

    public c(e eVar) {
        this.f816a = eVar;
    }

    @Override // com.microsoft.clarity.h.g
    public final void a(SerializedWebViewEvent events) {
        Intrinsics.checkNotNullParameter(events, "events");
        this.f816a.f824g.add(events);
    }

    @Override // com.microsoft.clarity.h.d
    public final void a(Exception exception, ErrorType errorType) {
        Intrinsics.checkNotNullParameter(exception, "exception");
        Intrinsics.checkNotNullParameter(errorType, "errorType");
        e.a(this.f816a, exception, errorType);
    }
}
