package com.anychart.enums;

import com.clevertap.android.sdk.Constants;
import java.util.Locale;

/* JADX INFO: loaded from: classes5.dex */
public enum WordBreak {
    BREAK_ALL("break-all"),
    KEEP_ALL("keep-all"),
    NORMAL(Constants.PRIORITY_NORMAL);

    private final String value;

    WordBreak(String str) {
        this.value = str;
    }

    public String getJsBase() {
        return String.format(Locale.US, "\"%s\"", this.value);
    }
}
