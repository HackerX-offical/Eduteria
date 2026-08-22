package com.anychart.graphics.vector;

import java.util.Locale;

/* JADX INFO: loaded from: classes4.dex */
public enum PaperSize {
    A0("a0"),
    A1("a1"),
    A2("a2"),
    A3("a3"),
    A4("a4"),
    A5("a5"),
    A6("a6"),
    US_LETTER("us-letter");

    private final String value;

    PaperSize(String str) {
        this.value = str;
    }

    public String getJsBase() {
        return String.format(Locale.US, "\"%s\"", this.value);
    }
}
