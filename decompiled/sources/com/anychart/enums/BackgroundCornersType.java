package com.anychart.enums;

import java.util.Locale;

/* JADX INFO: loaded from: classes5.dex */
public enum BackgroundCornersType {
    CUT("cut"),
    NONE("none"),
    ROUND("round"),
    ROUND_INNER("round-inner");

    private final String value;

    BackgroundCornersType(String str) {
        this.value = str;
    }

    public String getJsBase() {
        return String.format(Locale.US, "\"%s\"", this.value);
    }
}
