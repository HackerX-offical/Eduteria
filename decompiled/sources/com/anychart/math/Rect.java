package com.anychart.math;

import com.anychart.APIlib;
import com.anychart.JsObject;

/* JADX INFO: loaded from: classes4.dex */
public class Rect extends JsObject {
    protected Rect() {
    }

    public static Rect instantiate() {
        return new Rect("new anychart.math.rect()");
    }

    public Rect(String str) {
        StringBuilder sb = new StringBuilder("rect");
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
