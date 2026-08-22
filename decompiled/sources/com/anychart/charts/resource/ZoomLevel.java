package com.anychart.charts.resource;

import com.anychart.JsObject;
import com.anychart.core.gantt.timelineheader.LevelWrapper;
import com.anychart.enums.Interval;
import java.util.Locale;

/* JADX INFO: loaded from: classes4.dex */
public class ZoomLevel extends JsObject {
    public ZoomLevel(Number number, String str, LevelWrapper[] levelWrapperArr, Interval interval, Number number2) {
        this.js.append(String.format(Locale.US, "{count:%s, id: %s, levels: %s, unit: %s, unitPixSize: %s, } ", number, wrapQuotes(str), arrayToString((JsObject[]) levelWrapperArr), interval != null ? interval.getJsBase() : null, number2));
    }

    public ZoomLevel(Number number, String str, LevelWrapper[] levelWrapperArr, String str2, Number number2) {
        this.js.append(String.format(Locale.US, "{count:%s, id: %s, levels: %s, unit: %s, unitPixSize: %s, } ", number, wrapQuotes(str), arrayToString((JsObject[]) levelWrapperArr), wrapQuotes(str2), number2));
    }

    @Override // com.anychart.JsObject
    public String getJsBase() {
        return this.js.toString();
    }
}
