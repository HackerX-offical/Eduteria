package com.anychart.charts.sunburst;

import com.anychart.JsObject;
import java.util.Locale;

/* JADX INFO: loaded from: classes4.dex */
public class StatsFieldsName extends JsObject {
    public StatsFieldsName(Number number, String[] strArr) {
        this.js.append(String.format(Locale.US, "{depth:%s, level: %s, } ", number, arrayToStringWrapQuotes(strArr)));
    }

    @Override // com.anychart.JsObject
    public String getJsBase() {
        return this.js.toString();
    }
}
