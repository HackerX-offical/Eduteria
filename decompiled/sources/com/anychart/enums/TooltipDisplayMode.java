package com.anychart.enums;

import java.util.Locale;

/* JADX INFO: loaded from: classes5.dex */
public enum TooltipDisplayMode {
    SEPARATED("separated"),
    SINGLE("single"),
    UNION("union");

    private final String value;

    TooltipDisplayMode(String str) {
        this.value = str;
    }

    public String getJsBase() {
        return String.format(Locale.US, "\"%s\"", this.value);
    }
}
