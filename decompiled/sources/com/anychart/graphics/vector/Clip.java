package com.anychart.graphics.vector;

import com.anychart.APIlib;
import com.anychart.JsObject;
import java.util.Arrays;
import java.util.Locale;

/* JADX INFO: loaded from: classes4.dex */
public class Clip extends JsObject {
    protected Clip() {
    }

    public static Clip instantiate() {
        return new Clip("new anychart.graphics.vector.clip()");
    }

    public Clip(String str) {
        StringBuilder sb = new StringBuilder("clip");
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

    public Shape shape() {
        return new Shape(this.jsBase + ".shape()");
    }

    public Clip shape(Number[] numberArr) {
        APIlib.getInstance().addJSLine(String.format(Locale.US, this.jsBase + ".shape(%s);", Arrays.toString(numberArr)));
        return this;
    }

    public Clip shape(Shape shape) {
        APIlib.getInstance().addJSLine(String.format(Locale.US, this.jsBase + ".shape(%s);", shape != null ? shape.getJsBase() : null));
        return this;
    }

    public Clip shape(com.anychart.graphics.math.Rect rect) {
        APIlib.getInstance().addJSLine(String.format(Locale.US, this.jsBase + ".shape(%s);", rect != null ? rect.getJsBase() : null));
        return this;
    }

    public Clip shape(String str) {
        APIlib.getInstance().addJSLine(String.format(Locale.US, this.jsBase + ".shape(%s);", wrapQuotes(str)));
        return this;
    }

    public Clip shape(Number number, Number number2, Number number3, Number number4) {
        APIlib.getInstance().addJSLine(String.format(Locale.US, this.jsBase + ".shape(%s, %s, %s, %s);", number, number2, number3, number4));
        return this;
    }
}
