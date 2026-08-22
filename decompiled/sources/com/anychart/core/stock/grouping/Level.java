package com.anychart.core.stock.grouping;

import com.anychart.JsObject;
import com.anychart.enums.Interval;
import java.util.Locale;

/* JADX INFO: loaded from: classes5.dex */
public class Level extends JsObject {
    public Level(Number number, Interval interval) {
        this.js.append(String.format(Locale.US, "{count:%s, unit: %s, } ", number, interval != null ? interval.getJsBase() : null));
    }

    public Level(Number number, String str) {
        this.js.append(String.format(Locale.US, "{count:%s, unit: %s, } ", number, wrapQuotes(str)));
    }

    @Override // com.anychart.JsObject
    public String getJsBase() {
        return this.js.toString();
    }
}
