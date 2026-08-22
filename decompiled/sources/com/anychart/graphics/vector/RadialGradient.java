package com.anychart.graphics.vector;

import com.anychart.APIlib;
import com.anychart.JsObject;

/* JADX INFO: loaded from: classes4.dex */
public class RadialGradient extends JsObject {
    protected RadialGradient() {
    }

    public static RadialGradient instantiate() {
        return new RadialGradient("new anychart.graphics.vector.radialGradient()");
    }

    public RadialGradient(String str) {
        StringBuilder sb = new StringBuilder("radialGradient");
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
