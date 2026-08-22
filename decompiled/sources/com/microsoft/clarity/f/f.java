package com.microsoft.clarity.f;

import com.microsoft.clarity.models.telemetry.ErrorType;
import kotlin.Unit;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.FunctionReferenceImpl;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes9.dex */
public final /* synthetic */ class f extends FunctionReferenceImpl implements Function2<Exception, ErrorType, Unit> {
    public f(Object obj) {
        super(2, obj, e.class, "processError", "processError(Ljava/lang/Exception;Lcom/microsoft/clarity/models/telemetry/ErrorType;)V", 0);
    }

    @Override // kotlin.jvm.functions.Function2
    public final Unit invoke(Exception exc, ErrorType errorType) {
        Exception p0 = exc;
        ErrorType p1 = errorType;
        Intrinsics.checkNotNullParameter(p0, "p0");
        Intrinsics.checkNotNullParameter(p1, "p1");
        e.a((e) this.receiver, p0, p1);
        return Unit.INSTANCE;
    }
}
