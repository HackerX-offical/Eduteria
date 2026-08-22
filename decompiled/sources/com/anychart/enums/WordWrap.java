package com.anychart.enums;

import com.clevertap.android.sdk.Constants;
import java.util.Locale;

/* JADX INFO: loaded from: classes5.dex */
public enum WordWrap {
    BREAK_WORD("break-word"),
    NORMAL(Constants.PRIORITY_NORMAL);

    private final String value;

    WordWrap(String str) {
        this.value = str;
    }

    public String getJsBase() {
        return String.format(Locale.US, "\"%s\"", this.value);
    }
}
