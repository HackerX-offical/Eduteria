package com.anychart.enums;

import androidx.constraintlayout.core.motion.utils.TypedValues;
import java.util.Locale;

/* JADX INFO: loaded from: classes5.dex */
public enum CrosshairDisplayMode {
    FLOAT(TypedValues.Custom.S_FLOAT),
    STICKY("sticky");

    private final String value;

    CrosshairDisplayMode(String str) {
        this.value = str;
    }

    public String getJsBase() {
        return String.format(Locale.US, "\"%s\"", this.value);
    }
}
