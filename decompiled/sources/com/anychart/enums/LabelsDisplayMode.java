package com.anychart.enums;

import java.util.Locale;

/* JADX INFO: loaded from: classes5.dex */
public enum LabelsDisplayMode {
    ALWAYS_SHOW("always-show"),
    CLIP("clip"),
    DROP("drop");

    private final String value;

    LabelsDisplayMode(String str) {
        this.value = str;
    }

    public String getJsBase() {
        return String.format(Locale.US, "\"%s\"", this.value);
    }
}
