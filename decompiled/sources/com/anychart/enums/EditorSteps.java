package com.anychart.enums;

import java.util.Locale;

/* JADX INFO: loaded from: classes5.dex */
public enum EditorSteps {
    APPEARANCE("appearance"),
    CHART("chart"),
    DATA("data"),
    EXPORT("export");

    private final String value;

    EditorSteps(String str) {
        this.value = str;
    }

    public String getJsBase() {
        return String.format(Locale.US, "\"%s\"", this.value);
    }
}
