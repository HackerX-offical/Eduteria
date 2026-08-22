package com.anychart.graphics.vector;

import java.util.Locale;

/* JADX INFO: loaded from: classes4.dex */
public enum StrokeLineCap {
    BUTT("butt"),
    ROUND("round"),
    SQUARE("square");

    private final String value;

    StrokeLineCap(String str) {
        this.value = str;
    }

    public String getJsBase() {
        return String.format(Locale.US, "\"%s\"", this.value);
    }
}
