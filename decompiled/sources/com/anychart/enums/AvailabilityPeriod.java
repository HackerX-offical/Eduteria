package com.anychart.enums;

import java.util.Locale;

/* JADX INFO: loaded from: classes5.dex */
public enum AvailabilityPeriod {
    DAY("day"),
    NONE("none"),
    WEEK("week"),
    YEAR("year");

    private final String value;

    AvailabilityPeriod(String str) {
        this.value = str;
    }

    public String getJsBase() {
        return String.format(Locale.US, "\"%s\"", this.value);
    }
}
