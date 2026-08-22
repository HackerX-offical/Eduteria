package com.microsoft.clarity.f;

import kotlin.Unit;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.FunctionReferenceImpl;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes9.dex */
public final /* synthetic */ class p extends FunctionReferenceImpl implements Function2<String, byte[], Unit> {
    public p(Object obj) {
        super(2, obj, o.class, "processWebAsset", "processWebAsset(Ljava/lang/String;[B)V", 0);
    }

    @Override // kotlin.jvm.functions.Function2
    public final Unit invoke(String str, byte[] bArr) {
        String p0 = str;
        byte[] p1 = bArr;
        Intrinsics.checkNotNullParameter(p0, "p0");
        Intrinsics.checkNotNullParameter(p1, "p1");
        ((o) this.receiver).a(p0, p1);
        return Unit.INSTANCE;
    }
}
