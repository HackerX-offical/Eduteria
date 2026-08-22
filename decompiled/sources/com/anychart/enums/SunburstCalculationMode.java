package com.anychart.enums;

import java.util.Locale;

/* JADX INFO: loaded from: classes5.dex */
public enum SunburstCalculationMode {
    ORDINAL_FROM_LEAVES("ordinal-from-leaves"),
    ORDINAL_FROM_ROOT("ordinal-from-root"),
    PARENT_DEPENDENT("parent-dependent"),
    PARENT_INDEPENDENT("parent-independent");

    private final String value;

    SunburstCalculationMode(String str) {
        this.value = str;
    }

    public String getJsBase() {
        return String.format(Locale.US, "\"%s\"", this.value);
    }
}
