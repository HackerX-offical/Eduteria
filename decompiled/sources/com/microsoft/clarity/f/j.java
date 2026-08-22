package com.microsoft.clarity.f;

import com.microsoft.clarity.models.telemetry.ErrorType;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Lambda;

/* JADX INFO: loaded from: classes9.dex */
public final class j extends Lambda implements Function1<Exception, Unit> {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ k f839a;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public j(k kVar) {
        super(1);
        this.f839a = kVar;
    }

    @Override // kotlin.jvm.functions.Function1
    public final Unit invoke(Exception exc) {
        Exception it = exc;
        Intrinsics.checkNotNullParameter(it, "it");
        this.f839a.b(it, ErrorType.FlowControlJob);
        return Unit.INSTANCE;
    }
}
