package com.anychart.graphics.math;

import com.anychart.APIlib;
import com.anychart.JsObject;

/* JADX INFO: loaded from: classes.dex */
public class Coordinate extends JsObject {
    protected Coordinate() {
    }

    public static Coordinate instantiate() {
        return new Coordinate("new anychart.graphics.math.coordinate()");
    }

    public Coordinate(String str) {
        StringBuilder sb = new StringBuilder("coordinate");
        int i = variableIndex + 1;
        variableIndex = i;
        this.jsBase = sb.append(i).toString();
        APIlib.getInstance().addJSLine(this.jsBase + " = " + str + ";");
    }

    @Override // com.anychart.JsObject
    public String getJsBase() {
        return this.jsBase;
    }

    public void getX() {
        APIlib.getInstance().addJSLine(this.jsBase + ".getX();");
    }

    public void getY() {
        APIlib.getInstance().addJSLine(this.jsBase + ".getY();");
    }
}
