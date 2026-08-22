package com.anychart.enums;

import com.appnew.android.Utils.Const;
import java.util.Locale;

/* JADX INFO: loaded from: classes5.dex */
public enum SparklineSeriesType {
    AREA(Const.AREA),
    COLUMN("column"),
    LINE("line"),
    WIN_LOSS("win-loss");

    private final String value;

    SparklineSeriesType(String str) {
        this.value = str;
    }

    public String getJsBase() {
        return String.format(Locale.US, "\"%s\"", this.value);
    }
}
