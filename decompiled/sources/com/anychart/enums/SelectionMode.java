package com.anychart.enums;

import java.util.Locale;

/* JADX INFO: loaded from: classes5.dex */
public enum SelectionMode {
    DRILL_DOWN("drill-down"),
    MULTI_SELECT("multi-select"),
    NONE("none"),
    SINGLE_SELECT("single-select");

    private final String value;

    SelectionMode(String str) {
        this.value = str;
    }

    public String getJsBase() {
        return String.format(Locale.US, "\"%s\"", this.value);
    }
}
