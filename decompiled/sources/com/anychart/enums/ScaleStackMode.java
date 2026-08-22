package com.anychart.enums;

import java.util.Locale;

/* JADX INFO: loaded from: classes5.dex */
public enum ScaleStackMode {
    NONE("none"),
    PERCENT("percent"),
    VALUE("value");

    private final String value;

    ScaleStackMode(String str) {
        this.value = str;
    }

    public String getJsBase() {
        return String.format(Locale.US, "\"%s\"", this.value);
    }
}
