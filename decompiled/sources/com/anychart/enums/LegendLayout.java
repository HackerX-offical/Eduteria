package com.anychart.enums;

import java.util.Locale;

/* JADX INFO: loaded from: classes5.dex */
public enum LegendLayout {
    HORIZONTAL("horizontal"),
    HORIZONTAL_EXPANDABLE("horizontal-expandable"),
    VERTICAL("vertical"),
    VERTICAL_EXPANDABLE("vertical-expandable");

    private final String value;

    LegendLayout(String str) {
        this.value = str;
    }

    public String getJsBase() {
        return String.format(Locale.US, "\"%s\"", this.value);
    }
}
