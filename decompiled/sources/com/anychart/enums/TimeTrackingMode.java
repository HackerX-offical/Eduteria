package com.anychart.enums;

import java.util.Locale;

/* JADX INFO: loaded from: classes5.dex */
public enum TimeTrackingMode {
    ACTIVITY_PER_CHART("activity-per-chart"),
    ACTIVITY_PER_RESOURCE("activity-per-resource"),
    AVAILABILITY_PER_CHART("availability-per-chart"),
    AVAILABILITY_PER_RESOURCE("availability-per-resource");

    private final String value;

    TimeTrackingMode(String str) {
        this.value = str;
    }

    public String getJsBase() {
        return String.format(Locale.US, "\"%s\"", this.value);
    }
}
