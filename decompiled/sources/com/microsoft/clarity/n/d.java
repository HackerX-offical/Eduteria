package com.microsoft.clarity.n;

import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Lambda;

/* JADX INFO: loaded from: classes9.dex */
public final class d extends Lambda implements Function0<Boolean> {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ Function0<Unit> f1082a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final /* synthetic */ boolean f1083b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final /* synthetic */ Function1<Exception, Unit> f1084c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final /* synthetic */ Function0<Unit> f1085d;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    /* JADX WARN: Multi-variable type inference failed */
    public d(Function0<Unit> function0, boolean z, Function1<? super Exception, Unit> function1, Function0<Unit> function02) {
        super(0);
        this.f1082a = function0;
        this.f1083b = z;
        this.f1084c = function1;
        this.f1085d = function02;
    }

    @Override // kotlin.jvm.functions.Function0
    public final Boolean invoke() {
        return Boolean.valueOf(e.a(this.f1082a, this.f1083b, this.f1084c, this.f1085d));
    }
}
