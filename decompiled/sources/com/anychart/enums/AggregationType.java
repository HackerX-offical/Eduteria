package com.anychart.enums;

import com.clevertap.android.sdk.Constants;
import java.util.Locale;

/* JADX INFO: loaded from: classes5.dex */
public enum AggregationType {
    AVERAGE("average"),
    FIRST("first"),
    FIRST_VALUE("first-value"),
    LAST("last"),
    LAST_VALUE("last-value"),
    LIST("list"),
    MAX(Constants.PRIORITY_MAX),
    MIN("min"),
    SUM("sum"),
    WEIGHTED_AVERAGE("weighted-average");

    private final String value;

    AggregationType(String str) {
        this.value = str;
    }

    public String getJsBase() {
        return String.format(Locale.US, "\"%s\"", this.value);
    }
}
