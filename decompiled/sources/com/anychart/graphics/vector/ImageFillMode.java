package com.anychart.graphics.vector;

import java.util.Locale;

/* JADX INFO: loaded from: classes4.dex */
public enum ImageFillMode {
    FIT("fit"),
    FIT_MAX("fit-max"),
    STRETCH("stretch"),
    TILE("tile");

    private final String value;

    ImageFillMode(String str) {
        this.value = str;
    }

    public String getJsBase() {
        return String.format(Locale.US, "\"%s\"", this.value);
    }
}
