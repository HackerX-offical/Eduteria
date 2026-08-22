package com.microsoft.clarity.n;

import android.os.Trace;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Ref;

/* JADX INFO: loaded from: classes9.dex */
public final class m {
    /* JADX WARN: Type inference failed for: r7v1, types: [T, java.lang.Object] */
    public static Object a(String section, com.microsoft.clarity.e.e eVar, Function0 code) {
        Intrinsics.checkNotNullParameter(section, "section");
        Intrinsics.checkNotNullParameter(code, "code");
        try {
            Trace.beginSection(section);
            Ref.ObjectRef objectRef = new Ref.ObjectRef();
            long jCurrentTimeMillis = System.currentTimeMillis();
            objectRef.element = code.invoke();
            long jCurrentTimeMillis2 = System.currentTimeMillis() - jCurrentTimeMillis;
            if (eVar != null) {
                eVar.a(section, jCurrentTimeMillis2);
            }
            return objectRef.element;
        } finally {
            Trace.endSection();
        }
    }
}
