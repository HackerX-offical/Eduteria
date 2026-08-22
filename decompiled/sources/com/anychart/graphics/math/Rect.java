package com.anychart.graphics.math;

import com.anychart.APIlib;
import com.anychart.JsObject;

/* JADX INFO: loaded from: classes.dex */
public class Rect extends JsObject {
    protected Rect() {
    }

    public static Rect instantiate() {
        return new Rect("new anychart.graphics.math.rect()");
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

    public void getBottom() {
        APIlib.getInstance().addJSLine(this.jsBase + ".getBottom();");
    }

    public void getHeight() {
        APIlib.getInstance().addJSLine(this.jsBase + ".getHeight();");
    }

    public void getLeft() {
        APIlib.getInstance().addJSLine(this.jsBase + ".getLeft();");
    }

    public void getRight() {
        APIlib.getInstance().addJSLine(this.jsBase + ".getRight();");
    }

    public void getTop() {
        APIlib.getInstance().addJSLine(this.jsBase + ".getTop();");
    }

    public void getWidth() {
        APIlib.getInstance().addJSLine(this.jsBase + ".getWidth();");
    }
}
