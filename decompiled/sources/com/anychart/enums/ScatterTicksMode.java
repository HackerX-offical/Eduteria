package com.anychart.enums;

import java.util.Locale;

/* JADX INFO: loaded from: classes5.dex */
public enum ScatterTicksMode {
    LINEAR("linear"),
    LOGARITHMIC("logarithmic");

    private final String value;

    ScatterTicksMode(String str) {
        this.value = str;
    }

    public String getJsBase() {
        return String.format(Locale.US, "\"%s\"", this.value);
    }
}
