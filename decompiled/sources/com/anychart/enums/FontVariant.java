package com.anychart.enums;

import com.clevertap.android.sdk.Constants;
import java.util.Locale;

/* JADX INFO: loaded from: classes5.dex */
public enum FontVariant {
    NORMAL(Constants.PRIORITY_NORMAL),
    SMALL_CAP("small-caps");

    private final String value;

    FontVariant(String str) {
        this.value = str;
    }

    public String getJsBase() {
        return String.format(Locale.US, "\"%s\"", this.value);
    }
}
