package com.anychart.enums;

import java.util.Locale;

/* JADX INFO: loaded from: classes5.dex */
public enum AnnotationTypes {
    ANDREWS_PITCHFORK("andrews-pitchfork"),
    ELLIPSE("ellipse"),
    FIBONACCI_ARC("fibonacci-arc"),
    FIBONACCI_FAN("fibonacci-fan"),
    FIBONACCI_RETRACEMENT("fibonacci-retracement"),
    FIBONACCI_TIMEZONES("fibonacci-timezones"),
    HORIZONTAL_LINE("horizontal-line"),
    INFINITE_LINE("infinite-line"),
    LABEL("label"),
    LINE("line"),
    MARKER("marker"),
    RAY("ray"),
    RECTANGLE("rectangle"),
    TREND_CHANNEL("trend-channel"),
    TRIANGLE("triangle"),
    VERTICAL_LINE("vertical-line");

    private final String value;

    AnnotationTypes(String str) {
        this.value = str;
    }

    public String getJsBase() {
        return String.format(Locale.US, "\"%s\"", this.value);
    }
}
