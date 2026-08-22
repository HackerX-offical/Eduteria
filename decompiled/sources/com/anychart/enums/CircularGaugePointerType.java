package com.anychart.enums;

import java.util.Locale;

/* JADX INFO: loaded from: classes5.dex */
public enum CircularGaugePointerType {
    BAR("bar"),
    KNOB("knob"),
    MARKER("marker"),
    NEEDLE("needle");

    private final String value;

    CircularGaugePointerType(String str) {
        this.value = str;
    }

    public String getJsBase() {
        return String.format(Locale.US, "\"%s\"", this.value);
    }
}
