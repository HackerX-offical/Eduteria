package com.anychart.chart.common.dataentry;

import org.jivesoftware.smack.packet.Message;

/* JADX INFO: loaded from: classes4.dex */
public class TreeDataEntry extends DataEntry {
    public TreeDataEntry(String str, String str2) {
        setValue("id", str);
        setValue(Message.Thread.PARENT_ATTRIBUTE_NAME, str2);
    }

    public TreeDataEntry(Integer num, String str) {
        setValue("id", num);
        setValue(Message.Thread.PARENT_ATTRIBUTE_NAME, str);
    }

    public TreeDataEntry(String str, Integer num) {
        setValue("id", str);
        setValue(Message.Thread.PARENT_ATTRIBUTE_NAME, num);
    }

    public TreeDataEntry(Integer num, Integer num2) {
        setValue("id", num);
        setValue(Message.Thread.PARENT_ATTRIBUTE_NAME, num2);
    }

    public TreeDataEntry(String str, String str2, Integer num) {
        setValue("id", str);
        setValue(Message.Thread.PARENT_ATTRIBUTE_NAME, str2);
        setValue("value", num);
    }
}
