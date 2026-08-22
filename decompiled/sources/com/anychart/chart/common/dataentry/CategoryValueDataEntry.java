package com.anychart.chart.common.dataentry;

import com.appnew.android.Utils.Const;

/* JADX INFO: loaded from: classes4.dex */
public class CategoryValueDataEntry extends DataEntry {
    public CategoryValueDataEntry(String str, String str2, Integer num) {
        setValue("x", str);
        setValue("value", num);
        setValue(Const.CATEGORY, str2);
    }

    public CategoryValueDataEntry(String str, String str2, Double d2) {
        setValue("x", str);
        setValue("value", d2);
        setValue(Const.CATEGORY, str2);
    }
}
