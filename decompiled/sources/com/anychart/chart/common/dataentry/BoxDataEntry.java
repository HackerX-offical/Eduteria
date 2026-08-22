package com.anychart.chart.common.dataentry;

import com.clevertap.android.sdk.Constants;

/* JADX INFO: loaded from: classes4.dex */
public class BoxDataEntry extends DataEntry {
    public BoxDataEntry(String str, Integer num, Integer num2, Integer num3, Integer num4, Integer num5) {
        setValue("x", str);
        setValue("low", num);
        setValue("q1", num2);
        setValue("median", num3);
        setValue("q3", num4);
        setValue(Constants.PRIORITY_HIGH, num5);
    }
}
