package com.anychart.enums;

import java.util.Locale;

/* JADX INFO: loaded from: classes5.dex */
public enum ChartScrollerPosition {
    AFTER_AXES("after-axes"),
    BEFORE_AXES("before-axes");

    private final String value;

    ChartScrollerPosition(String str) {
        this.value = str;
    }

    public String getJsBase() {
        return String.format(Locale.US, "\"%s\"", this.value);
    }
}
