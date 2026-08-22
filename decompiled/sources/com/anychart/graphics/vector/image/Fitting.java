package com.anychart.graphics.vector.image;

import java.util.Locale;

/* JADX INFO: loaded from: classes4.dex */
public enum Fitting {
    MEET("meet"),
    SLICE("slice");

    private final String value;

    Fitting(String str) {
        this.value = str;
    }

    public String getJsBase() {
        return String.format(Locale.US, "\"%s\"", this.value);
    }
}
