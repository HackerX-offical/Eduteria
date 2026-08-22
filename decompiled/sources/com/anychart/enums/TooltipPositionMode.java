package com.anychart.enums;

import androidx.constraintlayout.core.motion.utils.TypedValues;
import com.appnew.android.Utils.Const;
import java.util.Locale;

/* JADX INFO: loaded from: classes5.dex */
public enum TooltipPositionMode {
    CHART("chart"),
    FLOAT(TypedValues.Custom.S_FLOAT),
    POINT(Const.POINT);

    private final String value;

    TooltipPositionMode(String str) {
        this.value = str;
    }

    public String getJsBase() {
        return String.format(Locale.US, "\"%s\"", this.value);
    }
}
