package com.anychart.enums;

import java.util.Locale;

/* JADX INFO: loaded from: classes5.dex */
public enum HAlign {
    CENTER("center"),
    END("end"),
    LEFT("left"),
    RIGHT("right"),
    START("start");

    private final String value;

    HAlign(String str) {
        this.value = str;
    }

    public String getJsBase() {
        return String.format(Locale.US, "\"%s\"", this.value);
    }
}
