package com.razorpay;

import android.app.Activity;
import android.content.Context;
import android.util.DisplayMetrics;
import android.util.TypedValue;

/* JADX INFO: loaded from: classes9.dex */
class ResourceUtils {
    ResourceUtils() {
    }

    static int getMagicVersionCode() {
        return ConfigDroid.MAGIC_VERSION_CODE.intValue();
    }

    static boolean isTablet(Context context) {
        return context.getResources().getBoolean(R.bool.isTablet);
    }

    static int dpToPx(Context context, int i) {
        return (int) TypedValue.applyDimension(1, i, context.getResources().getDisplayMetrics());
    }

    static int getStatusBarHeight(Context context) {
        int identifier = context.getResources().getIdentifier("status_bar_height", "dimen", "android");
        if (identifier > 0) {
            return context.getResources().getDimensionPixelSize(identifier);
        }
        return 0;
    }

    static int getViewHeight(Activity activity) {
        DisplayMetrics displayMetrics = new DisplayMetrics();
        activity.getWindowManager().getDefaultDisplay().getMetrics(displayMetrics);
        return displayMetrics.heightPixels - getStatusBarHeight(activity);
    }

    static int getRzpAssistVersionCode() {
        return ConfigDroid.RZP_ASSIST_VERSION_CODE.intValue();
    }
}
