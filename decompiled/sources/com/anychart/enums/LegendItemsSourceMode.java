package com.anychart.enums;

import cz.msebera.android.httpclient.client.config.CookieSpecs;
import java.util.Locale;

/* JADX INFO: loaded from: classes5.dex */
public enum LegendItemsSourceMode {
    CATEGORIES("categories"),
    DEFAULT(CookieSpecs.DEFAULT);

    private final String value;

    LegendItemsSourceMode(String str) {
        this.value = str;
    }

    public String getJsBase() {
        return String.format(Locale.US, "\"%s\"", this.value);
    }
}
