package com.airbnb.lottie.model.content;

import android.os.Build;
import androidx.core.graphics.BlendModeCompat;

/* JADX INFO: loaded from: classes4.dex */
public enum LBlendMode {
    NORMAL,
    MULTIPLY,
    SCREEN,
    OVERLAY,
    DARKEN,
    LIGHTEN,
    COLOR_DODGE,
    COLOR_BURN,
    HARD_LIGHT,
    SOFT_LIGHT,
    DIFFERENCE,
    EXCLUSION,
    HUE,
    SATURATION,
    COLOR,
    LUMINOSITY,
    ADD,
    HARD_MIX;

    public BlendModeCompat toNativeBlendMode() {
        int iOrdinal = ordinal();
        if (iOrdinal == 1) {
            if (Build.VERSION.SDK_INT >= 29) {
                return BlendModeCompat.MULTIPLY;
            }
            return BlendModeCompat.MODULATE;
        }
        if (iOrdinal == 2) {
            return BlendModeCompat.SCREEN;
        }
        if (iOrdinal == 3) {
            return BlendModeCompat.OVERLAY;
        }
        if (iOrdinal == 4) {
            return BlendModeCompat.DARKEN;
        }
        if (iOrdinal == 5) {
            return BlendModeCompat.LIGHTEN;
        }
        if (iOrdinal != 16) {
            return null;
        }
        return BlendModeCompat.PLUS;
    }
}
