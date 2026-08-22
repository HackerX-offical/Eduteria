package com.anychart.enums;

import java.util.Locale;

/* JADX INFO: loaded from: classes5.dex */
public enum PriceIndicatorDataSource {
    FIRST_VISIBLE("first-visible"),
    LAST_VISIBLE("last-visible"),
    SERIES_END("series-end"),
    SERIES_START("series-start");

    private final String value;

    PriceIndicatorDataSource(String str) {
        this.value = str;
    }

    public String getJsBase() {
        return String.format(Locale.US, "\"%s\"", this.value);
    }
}
