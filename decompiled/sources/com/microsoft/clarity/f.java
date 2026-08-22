package com.microsoft.clarity;

import com.microsoft.clarity.f.k;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Lambda;

/* JADX INFO: loaded from: classes9.dex */
public final class f extends Lambda implements Function0<Unit> {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ String f813a;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public f(String str) {
        super(0);
        this.f813a = str;
    }

    @Override // kotlin.jvm.functions.Function0
    public final Unit invoke() {
        Unit unit;
        Object obj = a.k;
        String str = this.f813a;
        synchronized (obj) {
            if (a.f657b != null) {
                k kVar = a.f657b;
                if (kVar != null) {
                    kVar.a(str);
                }
            } else {
                a.j = str;
            }
            unit = Unit.INSTANCE;
        }
        return unit;
    }
}
