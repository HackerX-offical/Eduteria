package com.github.barteksc.pdfviewer.util;

/* JADX INFO: loaded from: classes7.dex */
public class MathUtils {
    private static final double BIG_ENOUGH_CEIL = 16384.999999999996d;
    private static final double BIG_ENOUGH_FLOOR = 16384.0d;
    private static final int BIG_ENOUGH_INT = 16384;

    public static int ceil(float f2) {
        return ((int) (((double) f2) + BIG_ENOUGH_CEIL)) - 16384;
    }

    public static int floor(float f2) {
        return ((int) (((double) f2) + BIG_ENOUGH_FLOOR)) - 16384;
    }

    public static float limit(float f2, float f3, float f4) {
        return f2 <= f3 ? f3 : f2 >= f4 ? f4 : f2;
    }

    public static int limit(int i, int i2, int i3) {
        return i <= i2 ? i2 : i >= i3 ? i3 : i;
    }

    public static float max(float f2, float f3) {
        return f2 > f3 ? f3 : f2;
    }

    public static int max(int i, int i2) {
        return i > i2 ? i2 : i;
    }

    public static float min(float f2, float f3) {
        return f2 < f3 ? f3 : f2;
    }

    public static int min(int i, int i2) {
        return i < i2 ? i2 : i;
    }

    private MathUtils() {
    }
}
