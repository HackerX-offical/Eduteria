package com.anychart.chart.common.dataentry;

/* JADX INFO: loaded from: classes4.dex */
public class PertDataEntry extends DataEntry {
    public PertDataEntry(String str, String str2, String str3) {
        setValue("id", str);
        setValue("name", str2);
        setValue("fullName", str3);
    }

    public PertDataEntry(String str, String str2, String str3, String[] strArr) {
        setValue("id", str);
        setValue("name", str2);
        setValue("fullName", str3);
        setValue("dependsOn", strArr);
    }
}
