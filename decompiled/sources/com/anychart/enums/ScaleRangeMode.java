package com.anychart.enums;

import java.util.Locale;

/* JADX INFO: loaded from: classes5.dex */
public enum ScaleRangeMode {
    CONSIDER("consider"),
    NONE("none");

    private final String value;

    ScaleRangeMode(String str) {
        this.value = str;
    }

    public String getJsBase() {
        return String.format(Locale.US, "\"%s\"", this.value);
    }
}
