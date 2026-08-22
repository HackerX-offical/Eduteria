package com.anychart.graphics.vector.text;

import java.util.Locale;

/* JADX INFO: loaded from: classes4.dex */
public enum TextOverflow {
    CLIP(""),
    ELLIPSIS("...");

    private final String value;

    TextOverflow(String str) {
        this.value = str;
    }

    public String getJsBase() {
        return String.format(Locale.US, "\"%s\"", this.value);
    }
}
