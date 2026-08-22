package com.anychart.enums;

import com.clevertap.android.sdk.Constants;
import java.util.Locale;

/* JADX INFO: loaded from: classes5.dex */
public enum StockRangeType {
    MAX(Constants.PRIORITY_MAX),
    MTD("mtd"),
    POINTS("points"),
    QTD("qtd"),
    RANGE("range"),
    UNIT("unit"),
    YTD("ytd");

    private final String value;

    StockRangeType(String str) {
        this.value = str;
    }

    public String getJsBase() {
        return String.format(Locale.US, "\"%s\"", this.value);
    }
}
