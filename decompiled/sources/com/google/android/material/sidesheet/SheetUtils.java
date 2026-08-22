package com.google.android.material.sidesheet;

/* JADX INFO: loaded from: classes8.dex */
final class SheetUtils {
    private SheetUtils() {
    }

    static boolean isSwipeMostlyHorizontal(float f2, float f3) {
        return Math.abs(f2) > Math.abs(f3);
    }
}
