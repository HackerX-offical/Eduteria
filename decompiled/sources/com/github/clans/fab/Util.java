package com.github.clans.fab;

import android.content.Context;

/* JADX INFO: loaded from: classes7.dex */
final class Util {
    static boolean hasJellyBean() {
        return true;
    }

    static boolean hasLollipop() {
        return true;
    }

    private Util() {
    }

    static int dpToPx(Context context, float f2) {
        return Math.round(f2 * context.getResources().getDisplayMetrics().density);
    }
}
