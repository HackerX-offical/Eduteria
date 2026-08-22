package com.anychart.scales.calendar;

import com.anychart.JsObject;
import java.util.Locale;

/* JADX INFO: loaded from: classes4.dex */
public class ScheduleItem extends JsObject {
    public ScheduleItem(Number number, Number number2, String[] strArr) {
        this.js.append(String.format(Locale.US, "{end:%s, start: %s, workingTime: %s, } ", number, number2, arrayToStringWrapQuotes(strArr)));
    }

    @Override // com.anychart.JsObject
    public String getJsBase() {
        return this.js.toString();
    }
}
