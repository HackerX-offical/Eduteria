package com.anychart.enums;

import java.util.Locale;

/* JADX INFO: loaded from: classes5.dex */
public enum PyramidLabelsPosition {
    INSIDE("inside"),
    OUTSIDE_LEFT("outside-left"),
    OUTSIDE_LEFT_IN_COLUMN("outside-left-in-column"),
    OUTSIDE_RIGHT("outside-right"),
    OUTSIDE_RIGHT_IN_COLUMN("outside-right-in-column");

    private final String value;

    PyramidLabelsPosition(String str) {
        this.value = str;
    }

    public String getJsBase() {
        return String.format(Locale.US, "\"%s\"", this.value);
    }
}
