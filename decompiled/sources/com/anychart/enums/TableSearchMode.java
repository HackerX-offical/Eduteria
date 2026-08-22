package com.anychart.enums;

import java.util.Locale;

/* JADX INFO: loaded from: classes5.dex */
public enum TableSearchMode {
    EXACT("exact"),
    EXACT_OR_NEXT("exact-or-next"),
    EXACT_OR_PREV("exact-or-prev"),
    NEAREST("nearest");

    private final String value;

    TableSearchMode(String str) {
        this.value = str;
    }

    public String getJsBase() {
        return String.format(Locale.US, "\"%s\"", this.value);
    }
}
