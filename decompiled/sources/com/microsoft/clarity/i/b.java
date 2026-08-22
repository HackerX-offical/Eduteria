package com.microsoft.clarity.i;

import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes9.dex */
public interface b<T> extends c {

    public static final class a {
        public static <T> T a(b<T> bVar, g buffer) {
            Intrinsics.checkNotNullParameter(buffer, "buffer");
            T tA = bVar.a(buffer);
            Intrinsics.checkNotNull(tA);
            return tA;
        }
    }

    T a(g gVar);
}
