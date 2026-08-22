package com.anychart.enums;

import java.util.Locale;

/* JADX INFO: loaded from: classes5.dex */
public enum PointState {
    HOVER("1"),
    NORMAL("0"),
    SELECT("2");

    private final String value;

    PointState(String str) {
        this.value = str;
    }

    public String getJsBase() {
        return String.format(Locale.US, "\"%s\"", this.value);
    }
}
