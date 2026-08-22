package com.anychart.graphics.vector.text;

import java.util.Locale;

/* JADX INFO: loaded from: classes4.dex */
public enum Direction {
    LTR("ltr"),
    RTL("rtl");

    private final String value;

    Direction(String str) {
        this.value = str;
    }

    public String getJsBase() {
        return String.format(Locale.US, "\"%s\"", this.value);
    }
}
