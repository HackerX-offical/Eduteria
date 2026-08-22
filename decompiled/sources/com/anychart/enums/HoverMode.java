package com.anychart.enums;

import java.util.Locale;

/* JADX INFO: loaded from: classes5.dex */
public enum HoverMode {
    BY_SPOT("by-spot"),
    BY_X("by-x"),
    SINGLE("single");

    private final String value;

    HoverMode(String str) {
        this.value = str;
    }

    public String getJsBase() {
        return String.format(Locale.US, "\"%s\"", this.value);
    }
}
