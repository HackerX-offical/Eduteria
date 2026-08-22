package com.anychart.enums;

import java.util.Locale;

/* JADX INFO: loaded from: classes5.dex */
public enum MilestoneShape {
    CIRCLE("circle"),
    RECTANGLE("rectangle"),
    RHOMBUS("rhombus");

    private final String value;

    MilestoneShape(String str) {
        this.value = str;
    }

    public String getJsBase() {
        return String.format(Locale.US, "\"%s\"", this.value);
    }
}
