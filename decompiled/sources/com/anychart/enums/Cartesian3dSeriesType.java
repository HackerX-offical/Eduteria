package com.anychart.enums;

import com.appnew.android.Utils.Const;
import java.util.Locale;

/* JADX INFO: loaded from: classes5.dex */
public enum Cartesian3dSeriesType {
    AREA(Const.AREA),
    BAR("bar"),
    COLUMN("column"),
    LINE("line"),
    LINE_2D("line-2d");

    private final String value;

    Cartesian3dSeriesType(String str) {
        this.value = str;
    }

    public String getJsBase() {
        return String.format(Locale.US, "\"%s\"", this.value);
    }
}
