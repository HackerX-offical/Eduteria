package com.microsoft.clarity.n;

import android.app.ActivityManager;
import android.content.Context;
import kotlin.jvm.internal.Intrinsics;
import kotlin.math.MathKt;

/* JADX INFO: loaded from: classes9.dex */
public final class c {
    public static double a() {
        Runtime runtime = Runtime.getRuntime();
        return (runtime.maxMemory() - (runtime.totalMemory() - runtime.freeMemory())) / runtime.maxMemory();
    }

    public static int a(Context context) {
        Intrinsics.checkNotNullParameter(context, "context");
        Object systemService = context.getSystemService("activity");
        if (systemService == null) {
            throw new NullPointerException("null cannot be cast to non-null type android.app.ActivityManager");
        }
        ((ActivityManager) systemService).getMemoryInfo(new ActivityManager.MemoryInfo());
        return Integer.max(MathKt.roundToInt(r0.totalMem / 1.0E9d), 1);
    }

    public static boolean b(Context context) {
        Intrinsics.checkNotNullParameter(context, "context");
        Object systemService = context.getSystemService("activity");
        if (systemService == null) {
            throw new NullPointerException("null cannot be cast to non-null type android.app.ActivityManager");
        }
        ActivityManager.MemoryInfo memoryInfo = new ActivityManager.MemoryInfo();
        ((ActivityManager) systemService).getMemoryInfo(memoryInfo);
        return memoryInfo.lowMemory;
    }
}
