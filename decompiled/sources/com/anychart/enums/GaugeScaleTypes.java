package com.anychart.enums;

import java.util.Locale;

/* JADX INFO: loaded from: classes5.dex */
public enum GaugeScaleTypes {
    LINEAR("linear"),
    LOG("log");

    private final String value;

    GaugeScaleTypes(String str) {
        this.value = str;
    }

    public String getJsBase() {
        return String.format(Locale.US, "\"%s\"", this.value);
    }
}
