package com.microsoft.clarity.f;

import com.microsoft.clarity.models.display.ErrorDisplayFrame;
import com.microsoft.clarity.models.observers.FramePicture;
import com.microsoft.clarity.models.telemetry.ErrorType;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes9.dex */
public final class a implements com.microsoft.clarity.h.c {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ e f814a;

    public a(e eVar) {
        this.f814a = eVar;
    }

    @Override // com.microsoft.clarity.h.c
    public final void a(ErrorDisplayFrame errorDisplayFrame) {
        Intrinsics.checkNotNullParameter(errorDisplayFrame, "errorDisplayFrame");
        e.a(this.f814a, errorDisplayFrame);
    }

    @Override // com.microsoft.clarity.h.c
    public final void a(FramePicture framePicture) {
        Intrinsics.checkNotNullParameter(framePicture, "framePicture");
        e.a(this.f814a, framePicture);
    }

    @Override // com.microsoft.clarity.h.d
    public final void a(Exception exception, ErrorType errorType) {
        Intrinsics.checkNotNullParameter(exception, "exception");
        Intrinsics.checkNotNullParameter(errorType, "errorType");
        e.a(this.f814a, exception, errorType);
    }
}
