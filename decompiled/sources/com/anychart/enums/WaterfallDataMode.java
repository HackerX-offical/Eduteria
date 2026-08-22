package com.anychart.enums;

import com.facebook.appevents.codeless.internal.Constants;
import java.util.Locale;

/* JADX INFO: loaded from: classes5.dex */
public enum WaterfallDataMode {
    ABSOLUTE(Constants.PATH_TYPE_ABSOLUTE),
    DIFF("diff");

    private final String value;

    WaterfallDataMode(String str) {
        this.value = str;
    }

    public String getJsBase() {
        return String.format(Locale.US, "\"%s\"", this.value);
    }
}
