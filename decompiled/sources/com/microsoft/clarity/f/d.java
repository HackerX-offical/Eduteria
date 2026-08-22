package com.microsoft.clarity.f;

import com.microsoft.clarity.models.ingest.analytics.ScriptError;
import com.microsoft.clarity.models.telemetry.ErrorType;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes9.dex */
public final class d implements com.microsoft.clarity.h.b {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ e f817a;

    public d(e eVar) {
        this.f817a = eVar;
    }

    @Override // com.microsoft.clarity.h.b
    public final void a(ScriptError event) {
        Intrinsics.checkNotNullParameter(event, "event");
        e.a(this.f817a, event);
    }

    @Override // com.microsoft.clarity.h.d
    public final void a(Exception exception, ErrorType errorType) {
        Intrinsics.checkNotNullParameter(exception, "exception");
        Intrinsics.checkNotNullParameter(errorType, "errorType");
        e.a(this.f817a, exception, errorType);
    }
}
