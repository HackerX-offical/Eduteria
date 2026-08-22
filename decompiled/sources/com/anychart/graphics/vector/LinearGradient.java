package com.anychart.graphics.vector;

import com.anychart.APIlib;
import com.anychart.JsObject;

/* JADX INFO: loaded from: classes4.dex */
public class LinearGradient extends JsObject {
    protected LinearGradient() {
    }

    public static LinearGradient instantiate() {
        return new LinearGradient("new anychart.graphics.vector.linearGradient()");
    }

    public LinearGradient(String str) {
        StringBuilder sb = new StringBuilder("linearGradient");
        int i = variableIndex + 1;
        variableIndex = i;
        this.jsBase = sb.append(i).toString();
        APIlib.getInstance().addJSLine(this.jsBase + " = " + str + ";");
    }

    @Override // com.anychart.JsObject
    public String getJsBase() {
        return this.jsBase;
    }

    public void dispose() {
        APIlib.getInstance().addJSLine(this.jsBase + ".dispose();");
    }
}
