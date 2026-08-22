package com.anychart.chart.common.dataentry;

/* JADX INFO: loaded from: classes4.dex */
public class BubbleDataEntry extends DataEntry {
    public BubbleDataEntry(String str, Integer num, Integer num2) {
        setValue("x", str);
        setValue("value", num);
        setValue("size", num2);
    }

    public BubbleDataEntry(String str, Double d2, Double d3) {
        setValue("x", str);
        setValue("value", d2);
        setValue("size", d3);
    }

    public BubbleDataEntry(Integer num, Integer num2, Integer num3) {
        setValue("x", num);
        setValue("value", num2);
        setValue("size", num3);
    }

    public BubbleDataEntry(Double d2, Double d3, Double d4) {
        setValue("x", d2);
        setValue("value", d3);
        setValue("size", d4);
    }
}
