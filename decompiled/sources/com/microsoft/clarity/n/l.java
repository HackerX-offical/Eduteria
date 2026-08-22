package com.microsoft.clarity.n;

import com.microsoft.clarity.e.d;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes9.dex */
public final class l {
    public static Object a(d.b code) throws Exception {
        Intrinsics.checkNotNullParameter(code, "code");
        int i = 0;
        while (i < 3) {
            try {
                return code.invoke();
            } catch (Exception e2) {
                i++;
                if (i >= 3) {
                    throw e2;
                }
            }
        }
        throw new com.microsoft.clarity.c.d(3);
    }
}
