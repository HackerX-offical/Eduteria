package com.anychart.enums;

import java.util.Locale;

/* JADX INFO: loaded from: classes5.dex */
public enum LabelsOverlapMode {
    ALLOW_OVERLAP("allow-overlap"),
    NO_OVERLAP("no-overlap");

    private final String value;

    LabelsOverlapMode(String str) {
        this.value = str;
    }

    public String getJsBase() {
        return String.format(Locale.US, "\"%s\"", this.value);
    }
}
