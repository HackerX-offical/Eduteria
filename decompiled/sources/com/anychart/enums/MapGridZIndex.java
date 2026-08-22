package com.anychart.enums;

import java.util.Locale;

/* JADX INFO: loaded from: classes5.dex */
public enum MapGridZIndex {
    OVER_MAP("45"),
    UNDER_MAP("5");

    private final String value;

    MapGridZIndex(String str) {
        this.value = str;
    }

    public String getJsBase() {
        return String.format(Locale.US, "\"%s\"", this.value);
    }
}
