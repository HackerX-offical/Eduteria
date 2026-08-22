package com.anychart.enums;

import com.appnew.android.Utils.Const;
import java.util.Locale;

/* JADX INFO: loaded from: classes5.dex */
public enum RadarSeriesType {
    AREA(Const.AREA),
    LINE("line"),
    MARKER("marker");

    private final String value;

    RadarSeriesType(String str) {
        this.value = str;
    }

    public String getJsBase() {
        return String.format(Locale.US, "\"%s\"", this.value);
    }
}
