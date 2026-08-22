package com.appnew.android.Utils;

import android.content.Context;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: compiled from: AndroidUtils.kt */
/* JADX INFO: loaded from: classes6.dex */
@Metadata(d1 = {"\u0000&\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0010\u0007\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\bÇ\u0002\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\u0016\u0010\u0006\u001a\u00020\u00072\u0006\u0010\b\u001a\u00020\u00052\u0006\u0010\t\u001a\u00020\nJ\u0010\u0010\u000b\u001a\u00020\f2\u0006\u0010\t\u001a\u00020\nH\u0002R\u000e\u0010\u0004\u001a\u00020\u0005X\u0082\u000e¢\u0006\u0002\n\u0000¨\u0006\r"}, d2 = {"Lcom/appnew/android/Utils/AndroidUtils;", "", "<init>", "()V", "density", "", "dp", "", "value", "context", "Landroid/content/Context;", "checkDisplaySize", "", "app_EDUTERIARelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final class AndroidUtils {
    public static final AndroidUtils INSTANCE = new AndroidUtils();
    private static float density = 1.0f;
    public static final int $stable = 8;

    private AndroidUtils() {
    }

    public final int dp(float value, Context context) {
        Intrinsics.checkNotNullParameter(context, "context");
        if (density == 1.0f) {
            checkDisplaySize(context);
        }
        if (value == 0.0f) {
            return 0;
        }
        return (int) Math.ceil(density * value);
    }

    private final void checkDisplaySize(Context context) {
        try {
            density = context.getResources().getDisplayMetrics().density;
        } catch (Exception e2) {
            e2.printStackTrace();
        }
    }
}
