package com.anychart.enums;

import cz.msebera.android.httpclient.client.config.CookieSpecs;
import java.util.Locale;

/* JADX INFO: loaded from: classes5.dex */
public enum ChartDataExportMode {
    DEFAULT(CookieSpecs.DEFAULT),
    GROUPED("grouped"),
    RAW("raw"),
    SELECTED("selected");

    private final String value;

    ChartDataExportMode(String str) {
        this.value = str;
    }

    public String getJsBase() {
        return String.format(Locale.US, "\"%s\"", this.value);
    }
}
