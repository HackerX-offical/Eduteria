package com.anychart.enums;

import java.util.Locale;

/* JADX INFO: loaded from: classes5.dex */
public enum LinearGaugePointerType {
    BAR("bar"),
    LED("led"),
    MARKER("marker"),
    RANGE_BAR("range-bar"),
    TANK("tank"),
    THERMOMETER("thermometer");

    private final String value;

    LinearGaugePointerType(String str) {
        this.value = str;
    }

    public String getJsBase() {
        return String.format(Locale.US, "\"%s\"", this.value);
    }
}
