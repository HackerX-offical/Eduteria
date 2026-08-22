package com.anychart.core.stock.indicators;

import com.anychart.APIlib;
import com.anychart.JsObject;

/* JADX INFO: loaded from: classes5.dex */
public class Base extends JsObject {
    protected Base() {
    }

    public static Base instantiate() {
        return new Base("new anychart.core.stock.indicators.base()");
    }

    public Base(String str) {
        StringBuilder sb = new StringBuilder("base");
        int i = variableIndex + 1;
        variableIndex = i;
        this.jsBase = sb.append(i).toString();
        APIlib.getInstance().addJSLine(this.jsBase + " = " + str + ";");
    }

    @Override // com.anychart.JsObject
    public String getJsBase() {
        return this.jsBase;
    }
}
