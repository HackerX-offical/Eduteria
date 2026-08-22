package com.microsoft.clarity.n;

import com.microsoft.clarity.g.e;
import com.microsoft.clarity.g.o;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes9.dex */
public final class e {
    public static /* synthetic */ void a(Function0 function0, Function1 function1, o.c cVar, int i) {
        if ((i & 4) != 0) {
            function1 = null;
        }
        if ((i & 8) != 0) {
            cVar = null;
        }
        a(function0, false, function1, (Function0) cVar);
    }

    public static boolean a(Function0 logic, Function1 function1, e.c cVar, int i) {
        com.microsoft.clarity.e.e eVar = null;
        if ((i & 4) != 0) {
            function1 = null;
        }
        if ((i & 8) != 0) {
            cVar = null;
        }
        String sectionName = (i & 16) != 0 ? "Clarity_UIThreadWork" : null;
        Intrinsics.checkNotNullParameter(logic, "logic");
        Intrinsics.checkNotNullParameter(sectionName, "sectionName");
        try {
            eVar = com.microsoft.clarity.b.a.f690b;
        } catch (Exception unused) {
        }
        return ((Boolean) m.a(sectionName, eVar, new d(logic, false, function1, cVar))).booleanValue();
    }

    public static boolean a(Function0 logic, boolean z, Function1 function1, Function0 function0) {
        Intrinsics.checkNotNullParameter(logic, "logic");
        try {
            try {
                logic.invoke();
                if (function0 == null) {
                    return true;
                }
                function0.invoke();
                return true;
            } catch (Exception e2) {
                if (function1 != null) {
                    try {
                        function1.invoke(e2);
                    } catch (Exception e3) {
                        i.a(e3.getMessage(), e3);
                    }
                }
                if (z) {
                    throw e2;
                }
                if (function0 == null) {
                    return false;
                }
                function0.invoke();
                return false;
            }
        } catch (Throwable th) {
            if (function0 != null) {
                function0.invoke();
            }
            throw th;
        }
    }
}
