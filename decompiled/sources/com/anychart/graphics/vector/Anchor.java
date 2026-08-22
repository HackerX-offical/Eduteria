package com.anychart.graphics.vector;

import java.util.Locale;

/* JADX INFO: loaded from: classes4.dex */
public enum Anchor {
    AUTO("auto"),
    CENTER("center"),
    CENTER_BOTTOM("center-bottom"),
    CENTER_TOP("center-top"),
    LEFT_BOTTOM("left-bottom"),
    LEFT_CENTER("left-center"),
    LEFT_TOP("left-top"),
    RIGHT_BOTTOM("right-bottom"),
    RIGHT_CENTER("right-center"),
    RIGHT_TOP("right-top");

    private final String value;

    Anchor(String str) {
        this.value = str;
    }

    public String getJsBase() {
        return String.format(Locale.US, "\"%s\"", this.value);
    }
}
