package com.anychart.ui;

import com.anychart.APIlib;
import com.anychart.JsObject;
import com.anychart.charts.Map;
import java.util.Locale;

/* JADX INFO: loaded from: classes6.dex */
public class Zoom extends JsObject {
    protected Zoom() {
    }

    public static Zoom instantiate() {
        return new Zoom("new anychart.ui.zoom()");
    }

    public Zoom(String str) {
        StringBuilder sb = new StringBuilder("zoom");
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

    public void render(Map map) {
        APIlib.getInstance().addJSLine(String.format(Locale.US, this.jsBase + ".render(%s);", map != null ? map.getJsBase() : null));
    }

    public void target(Map map) {
        APIlib.getInstance().addJSLine(String.format(Locale.US, this.jsBase + ".target(%s);", map != null ? map.getJsBase() : null));
    }
}
