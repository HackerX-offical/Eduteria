package com.anychart.graphics.vector;

import java.util.Locale;

/* JADX INFO: loaded from: classes4.dex */
public enum StrokeLineJoin {
    BEVEL("bevel"),
    MITER("miter"),
    ROUND("round");

    private final String value;

    StrokeLineJoin(String str) {
        this.value = str;
    }

    public String getJsBase() {
        return String.format(Locale.US, "\"%s\"", this.value);
    }
}
