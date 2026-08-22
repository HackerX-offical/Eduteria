package com.anychart.charts.stock;

import com.anychart.JsObject;
import java.util.Locale;

/* JADX INFO: loaded from: classes4.dex */
public class SelectedRange extends JsObject {
    public SelectedRange(Number number, Number number2, Number number3, Number number4) {
        this.js.append(String.format(Locale.US, "{firstSelected:%s, firstVisible: %s, lastSelected: %s, lastVisible: %s, } ", number, number2, number3, number4));
    }

    @Override // com.anychart.JsObject
    public String getJsBase() {
        return this.js.toString();
    }
}
