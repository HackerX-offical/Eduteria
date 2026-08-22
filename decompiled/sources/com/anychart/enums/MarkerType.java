package com.anychart.enums;

import java.util.Locale;

/* JADX INFO: loaded from: classes5.dex */
public enum MarkerType {
    ARROWHEAD("arrowhead"),
    ARROW_DOWN("arrow-down"),
    ARROW_LEFT("arrow-left"),
    ARROW_RIGHT("arrow-right"),
    ARROW_UP("arrow-up"),
    CIRCLE("circle"),
    CROSS("cross"),
    DIAGONAL_CROSS("diagonal-cross"),
    DIAMOND("diamond"),
    LINE("line"),
    PENTAGON("pentagon"),
    SQUARE("square"),
    STAR10("star10"),
    STAR4("star4"),
    STAR5("star5"),
    STAR6("star6"),
    STAR7("star7"),
    TRAPEZIUM("trapezium"),
    TRIANGLE_DOWN("triangle-down"),
    TRIANGLE_LEFT("triangle-left"),
    TRIANGLE_RIGHT("triangle-right"),
    TRIANGLE_UP("triangle-up");

    private final String value;

    MarkerType(String str) {
        this.value = str;
    }

    public String getJsBase() {
        return String.format(Locale.US, "\"%s\"", this.value);
    }
}
