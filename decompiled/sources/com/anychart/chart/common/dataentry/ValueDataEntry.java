package com.anychart.chart.common.dataentry;

/* JADX INFO: loaded from: classes4.dex */
public class ValueDataEntry extends DataEntry {
    public ValueDataEntry(String str, Number number) {
        setValue("x", str);
        setValue("value", number);
    }

    public ValueDataEntry(Number number, Number number2) {
        setValue("x", number);
        setValue("value", number2);
    }
}
