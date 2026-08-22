package com.razorpay;

import android.app.ActivityManager;
import android.content.Context;
import android.os.Build;
import kotlin.Metadata;
import kotlin.jvm.JvmStatic;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: compiled from: PerformanceUtil.kt */
/* JADX INFO: loaded from: classes9.dex */
@Metadata(d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0000\bÆ\u0002\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\u0010\u0010\u0003\u001a\u00020\u00042\u0006\u0010\u0005\u001a\u00020\u0006H\u0007J\u0010\u0010\u0007\u001a\u00020\u00042\u0006\u0010\u0005\u001a\u00020\u0006H\u0002J\u0010\u0010\b\u001a\u00020\t2\u0006\u0010\u0005\u001a\u00020\u0006H\u0007¨\u0006\n"}, d2 = {"Lcom/razorpay/PerformanceUtil;", "", "()V", "getPerformanceClass", "", "context", "Landroid/content/Context;", "getPerformanceClassFromRAM", "isLowEndDevice", "", "core_release"}, k = 1, mv = {1, 6, 0}, xi = 48)
public final class PerformanceUtil {
    public static final PerformanceUtil INSTANCE = new PerformanceUtil();

    private PerformanceUtil() {
    }

    @JvmStatic
    public static final int getPerformanceClass(Context context) {
        int i;
        Intrinsics.checkNotNullParameter(context, "context");
        try {
            return (Build.VERSION.SDK_INT < 31 || (i = Build.VERSION.MEDIA_PERFORMANCE_CLASS) == 0) ? INSTANCE.getPerformanceClassFromRAM(context) : i;
        } catch (Exception e2) {
            e2.printStackTrace();
            return 0;
        }
    }

    private final int getPerformanceClassFromRAM(Context context) {
        try {
            Object systemService = context.getSystemService("activity");
            if (systemService == null) {
                throw new NullPointerException("null cannot be cast to non-null type android.app.ActivityManager");
            }
            ((ActivityManager) systemService).getMemoryInfo(new ActivityManager.MemoryInfo());
            double d2 = r1.totalMem / 1.073741824E9d;
            if (d2 < 2.0d) {
                return 0;
            }
            if (d2 < 4.0d) {
                return 30;
            }
            return d2 < 6.0d ? 31 : 33;
        } catch (Exception e2) {
            e2.printStackTrace();
            return 0;
        }
    }

    @JvmStatic
    public static final boolean isLowEndDevice(Context context) {
        Intrinsics.checkNotNullParameter(context, "context");
        int performanceClass = getPerformanceClass(context);
        return performanceClass == 0 || performanceClass == 30;
    }
}
