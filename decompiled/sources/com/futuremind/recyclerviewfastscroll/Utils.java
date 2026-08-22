package com.futuremind.recyclerviewfastscroll;

import android.graphics.drawable.Drawable;
import android.view.View;

/* JADX INFO: loaded from: classes7.dex */
public class Utils {
    public static float getViewRawY(View view) {
        ((View) view.getParent()).getLocationInWindow(new int[]{0, (int) view.getY()});
        return r0[1];
    }

    public static float getViewRawX(View view) {
        ((View) view.getParent()).getLocationInWindow(new int[]{(int) view.getX(), 0});
        return r0[0];
    }

    public static float getValueInRange(float min, float max, float value) {
        return Math.min(Math.max(min, value), max);
    }

    public static void setBackground(View view, Drawable drawable) {
        view.setBackground(drawable);
    }
}
