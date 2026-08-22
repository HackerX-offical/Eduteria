package com.anychart.enums;

import java.util.Locale;

/* JADX INFO: loaded from: classes5.dex */
public enum StockLabelsOverlapMode {
    ALLOW_MAJOR_OVERLAP("allow-major-overlap"),
    ALLOW_MINOR_OVERLAP("allow-minor-overlap"),
    ALLOW_OVERLAP("allow-overlap"),
    NO_OVERLAP("no-overlap");

    private final String value;

    StockLabelsOverlapMode(String str) {
        this.value = str;
    }

    public String getJsBase() {
        return String.format(Locale.US, "\"%s\"", this.value);
    }
}
