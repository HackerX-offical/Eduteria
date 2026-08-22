package com.skydoves.powermenu;

import android.content.Context;
import android.util.TypedValue;

/* JADX INFO: loaded from: classes9.dex */
class ConvertUtil {
    ConvertUtil() {
    }

    protected static int convertDpToPixel(float f2, Context context) {
        return Math.round(TypedValue.applyDimension(1, f2, context.getResources().getDisplayMetrics()));
    }
}
