package com.anychart.graphics;

import java.util.Locale;

/* JADX INFO: loaded from: classes.dex */
public enum StageType {
    SVG("svg"),
    VML("vml");

    private final String value;

    StageType(String str) {
        this.value = str;
    }

    public String getJsBase() {
        return String.format(Locale.US, "\"%s\"", this.value);
    }
}
