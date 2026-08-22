package com.anychart.enums;

import java.util.Locale;

/* JADX INFO: loaded from: classes5.dex */
public enum ConnectorType {
    FINISH_FINISH("finish-finish"),
    FINISH_START("finish-start"),
    START_FINISH("start-finish"),
    START_START("start-start");

    private final String value;

    ConnectorType(String str) {
        this.value = str;
    }

    public String getJsBase() {
        return String.format(Locale.US, "\"%s\"", this.value);
    }
}
