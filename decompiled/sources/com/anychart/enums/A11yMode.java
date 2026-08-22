package com.anychart.enums;

import java.util.Locale;

/* JADX INFO: loaded from: classes5.dex */
public enum A11yMode {
    CHART_ELEMENTS("chart-elements"),
    DATA_TABLE("data-table");

    private final String value;

    A11yMode(String str) {
        this.value = str;
    }

    public String getJsBase() {
        return String.format(Locale.US, "\"%s\"", this.value);
    }
}
