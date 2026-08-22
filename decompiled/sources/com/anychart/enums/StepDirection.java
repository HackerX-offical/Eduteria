package com.anychart.enums;

import java.util.Locale;

/* JADX INFO: loaded from: classes5.dex */
public enum StepDirection {
    BACKWARD("backward"),
    CENTER("center"),
    FORWARD("forward");

    private final String value;

    StepDirection(String str) {
        this.value = str;
    }

    public String getJsBase() {
        return String.format(Locale.US, "\"%s\"", this.value);
    }
}
