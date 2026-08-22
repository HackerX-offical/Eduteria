package com.anychart.enums;

import com.appnew.android.Utils.Const;
import java.util.Locale;

/* JADX INFO: loaded from: classes5.dex */
public enum PolarSeriesType {
    AREA(Const.AREA),
    COLUMN("column"),
    LINE("line"),
    MARKER("marker"),
    POLYGON("polygon"),
    POLYLINE("polyline"),
    RANGE_COLUMN("range-column");

    private final String value;

    PolarSeriesType(String str) {
        this.value = str;
    }

    public String getJsBase() {
        return String.format(Locale.US, "\"%s\"", this.value);
    }
}
