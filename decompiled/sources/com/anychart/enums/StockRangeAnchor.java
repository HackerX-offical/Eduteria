package com.anychart.enums;

import java.util.Locale;

/* JADX INFO: loaded from: classes5.dex */
public enum StockRangeAnchor {
    FIRST_DATE("first-date"),
    FIRST_VISIBLE_DATE("first-visible-date"),
    LAST_DATE("last-date"),
    LAST_VISIBLE_DATE("last-visible-date");

    private final String value;

    StockRangeAnchor(String str) {
        this.value = str;
    }

    public String getJsBase() {
        return String.format(Locale.US, "\"%s\"", this.value);
    }
}
