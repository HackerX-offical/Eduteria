package com.anychart.enums;

import java.util.Locale;

/* JADX INFO: loaded from: classes5.dex */
public enum GanttRangeAnchor {
    FIRST_DATE("first-date"),
    FIRST_VISIBLE_DATE("first-visible-date"),
    LAST_DATE("last-date"),
    LAST_VISIBLE_DATE("last-visible-date");

    private final String value;

    GanttRangeAnchor(String str) {
        this.value = str;
    }

    public String getJsBase() {
        return String.format(Locale.US, "\"%s\"", this.value);
    }
}
