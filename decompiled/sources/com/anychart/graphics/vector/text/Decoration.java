package com.anychart.graphics.vector.text;

import java.util.Locale;

/* JADX INFO: loaded from: classes4.dex */
public enum Decoration {
    BLINK("blink"),
    LINE_THROUGH("line-through"),
    NONE("none"),
    OVERLINE("overline"),
    UNDERLINE("underline");

    private final String value;

    Decoration(String str) {
        this.value = str;
    }

    public String getJsBase() {
        return String.format(Locale.US, "\"%s\"", this.value);
    }
}
