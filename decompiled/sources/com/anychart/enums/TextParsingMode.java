package com.anychart.enums;

import java.util.Locale;

/* JADX INFO: loaded from: classes5.dex */
public enum TextParsingMode {
    BY_CHAR("by-char"),
    BY_WORD("by-word"),
    CSV("csv");

    private final String value;

    TextParsingMode(String str) {
        this.value = str;
    }

    public String getJsBase() {
        return String.format(Locale.US, "\"%s\"", this.value);
    }
}
