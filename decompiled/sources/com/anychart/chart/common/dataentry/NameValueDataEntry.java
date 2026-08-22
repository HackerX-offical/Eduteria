package com.anychart.chart.common.dataentry;

/* JADX INFO: loaded from: classes4.dex */
public class NameValueDataEntry extends DataEntry {
    public NameValueDataEntry(String str, String str2, Integer num) {
        setValue("x", str);
        setValue("name", str2);
        setValue("value", num);
    }

    public NameValueDataEntry(String str, String str2, Double d2) {
        setValue("x", str);
        setValue("name", str2);
        setValue("value", d2);
    }
}
