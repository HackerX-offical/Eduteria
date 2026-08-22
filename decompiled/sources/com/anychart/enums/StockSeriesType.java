package com.anychart.enums;

import com.appnew.android.Utils.Const;
import java.util.Locale;

/* JADX INFO: loaded from: classes5.dex */
public enum StockSeriesType {
    AREA(Const.AREA),
    CANDLESTICK("candlestick"),
    COLUMN("column"),
    JUMP_LINE("jump-line"),
    LINE("line"),
    MARKER("marker"),
    OHLC("ohlc"),
    RANGE_AREA("range-area"),
    RANGE_COLUMN("range-column"),
    RANGE_SPLINE_AREA("range-spline-area"),
    RANGE_STEP_AREA("range-step-area"),
    SPLINE("spline"),
    SPLINE_AREA("spline-area"),
    STEP_AREA("step-area"),
    STEP_LINE("step-line"),
    STICK("stick");

    private final String value;

    StockSeriesType(String str) {
        this.value = str;
    }

    public String getJsBase() {
        return String.format(Locale.US, "\"%s\"", this.value);
    }
}
