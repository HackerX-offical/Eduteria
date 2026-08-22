package com.skydoves.powermenu;

import android.content.Context;
import android.content.res.TypedArray;
import android.util.TypedValue;

/* JADX INFO: loaded from: classes9.dex */
class ResourceUtil {
    ResourceUtil() {
    }

    protected static int getAccentColor(Context context) {
        TypedArray typedArrayObtainStyledAttributes = context.obtainStyledAttributes(new TypedValue().data, new int[]{R.attr.colorAccent});
        int color = typedArrayObtainStyledAttributes.getColor(0, 0);
        typedArrayObtainStyledAttributes.recycle();
        return color;
    }
}
