package com.anychart.enums;

import com.appnew.android.Utils.Const;
import java.util.Locale;

/* JADX INFO: loaded from: classes5.dex */
public enum LegendItemIconType {
    AREA(Const.AREA),
    BAR("bar"),
    BUBBLE("bubble"),
    CANDLESTICK("candlestick"),
    CIRCLE("circle"),
    COLUMN("column"),
    LINE("line"),
    MARKER("marker"),
    OHLC("ohlc"),
    RANGE_AREA("range-area"),
    RANGE_BAR("range-bar"),
    RANGE_COLUMN("range-column"),
    RANGE_SPLINE_AREA("range-spline-area"),
    RANGE_STEP_AREA("range-step-area"),
    SPLINE("spline"),
    SPLINE_AREA("spline-area"),
    SQUARE("square"),
    STEP_AREA("step-area"),
    STEP_LINE("step-line");

    private final String value;

    LegendItemIconType(String str) {
        this.value = str;
    }

    public String getJsBase() {
        return String.format(Locale.US, "\"%s\"", this.value);
    }
}
