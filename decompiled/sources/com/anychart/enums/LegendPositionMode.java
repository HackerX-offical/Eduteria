package com.anychart.enums;

import java.util.Locale;

/* JADX INFO: loaded from: classes5.dex */
public enum LegendPositionMode {
    INSIDE("inside"),
    OUTSIDE("outside");

    private final String value;

    LegendPositionMode(String str) {
        this.value = str;
    }

    public String getJsBase() {
        return String.format(Locale.US, "\"%s\"", this.value);
    }
}
