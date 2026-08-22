package com.anychart.enums;

import java.util.Locale;

/* JADX INFO: loaded from: classes5.dex */
public enum Interval {
    DAY("day"),
    HOUR("hour"),
    MILLISECOND("millisecond"),
    MINUTE("minute"),
    MONTH("month"),
    QUARTER("quarter"),
    SECOND("second"),
    SEMESTER("semester"),
    THIRD_OF_MONTH("third-of-month"),
    WEEK("week"),
    YEAR("year");

    private final String value;

    Interval(String str) {
        this.value = str;
    }

    public String getJsBase() {
        return String.format(Locale.US, "\"%s\"", this.value);
    }
}
