package com.anychart.core.lineargauge.scalebar;

import com.anychart.JsObject;
import java.util.Locale;

/* JADX INFO: loaded from: classes5.dex */
public class ControlPoint extends JsObject {
    public ControlPoint(Number number, Number number2, Number number3) {
        this.js.append(String.format(Locale.US, "{height:%s, left: %s, right: %s, } ", number, number2, number3));
    }

    @Override // com.anychart.JsObject
    public String getJsBase() {
        return this.js.toString();
    }
}
