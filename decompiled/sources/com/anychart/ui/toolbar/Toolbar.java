package com.anychart.ui.toolbar;

import com.anychart.APIlib;
import com.anychart.JsObject;
import com.anychart.core.Chart;
import java.util.Locale;

/* JADX INFO: loaded from: classes6.dex */
public class Toolbar extends JsObject {
    protected Toolbar() {
    }

    public static Toolbar instantiate() {
        return new Toolbar("new anychart.ui.toolbar.toolbar()");
    }

    public Toolbar(String str) {
        StringBuilder sb = new StringBuilder("toolbar");
        int i = variableIndex + 1;
        variableIndex = i;
        this.jsBase = sb.append(i).toString();
        APIlib.getInstance().addJSLine(this.jsBase + " = " + str + ";");
    }

    @Override // com.anychart.JsObject
    public String getJsBase() {
        return this.jsBase;
    }

    public Toolbar container(String str) {
        APIlib.getInstance().addJSLine(String.format(Locale.US, this.jsBase + ".container(%s);", wrapQuotes(str)));
        return this;
    }

    public Toolbar draw() {
        APIlib.getInstance().addJSLine(this.jsBase + ".draw();");
        return this;
    }

    public Toolbar target(Chart chart) {
        APIlib.getInstance().addJSLine(String.format(Locale.US, this.jsBase + ".target(%s);", chart != null ? chart.getJsBase() : null));
        return this;
    }
}
