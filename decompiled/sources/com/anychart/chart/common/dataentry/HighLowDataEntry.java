package com.anychart.chart.common.dataentry;

import com.clevertap.android.sdk.Constants;

/* JADX INFO: loaded from: classes4.dex */
public class HighLowDataEntry extends DataEntry {
    public HighLowDataEntry(String str, Number number, Number number2) {
        setValue("x", str);
        setValue(Constants.PRIORITY_HIGH, number);
        setValue("low", number2);
    }

    public HighLowDataEntry(Number number, Number number2, Number number3) {
        setValue("x", number);
        setValue(Constants.PRIORITY_HIGH, number2);
        setValue("low", number3);
    }
}
