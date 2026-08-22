package com.anychart.enums;

import java.util.Locale;

/* JADX INFO: loaded from: classes5.dex */
public enum ColumnFormats {
    DATE_COMMON_LOG("date-common-log"),
    DATE_DMY_DOTS("date-dmy-dots"),
    DATE_ISO_8601("date-iso-8601"),
    DATE_US_SHORT("date-us-short"),
    DIRECT_NUMBERING("direct-numbering"),
    FINANCIAL("financial"),
    PERCENT("percent"),
    SHORT_TEXT("short-text"),
    TEXT("text");

    private final String value;

    ColumnFormats(String str) {
        this.value = str;
    }

    public String getJsBase() {
        return String.format(Locale.US, "\"%s\"", this.value);
    }
}
