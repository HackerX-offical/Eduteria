package com.anychart.enums;

import java.util.Locale;

/* JADX INFO: loaded from: classes5.dex */
public enum EventMarkerPosition {
    AXIS("axis"),
    SERIES("series"),
    SERIES_NEGATIVE("series-negative"),
    SERIES_POSITIVE("series-positive"),
    ZERO("zero");

    private final String value;

    EventMarkerPosition(String str) {
        this.value = str;
    }

    public String getJsBase() {
        return String.format(Locale.US, "\"%s\"", this.value);
    }
}
