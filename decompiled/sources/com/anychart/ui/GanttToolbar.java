package com.anychart.ui;

import com.anychart.APIlib;
import com.anychart.JsObject;
import com.anychart.core.Chart;
import com.anychart.graphics.vector.PaperSize;
import java.util.Locale;

/* JADX INFO: loaded from: classes6.dex */
public class GanttToolbar extends JsObject {
    protected GanttToolbar() {
    }

    public static GanttToolbar instantiate() {
        return new GanttToolbar("new anychart.ui.ganttToolbar()");
    }

    public GanttToolbar(String str) {
        StringBuilder sb = new StringBuilder("ganttToolbar");
        int i = variableIndex + 1;
        variableIndex = i;
        this.jsBase = sb.append(i).toString();
        APIlib.getInstance().addJSLine(this.jsBase + " = " + str + ";");
    }

    @Override // com.anychart.JsObject
    public String getJsBase() {
        return this.jsBase;
    }

    public void container() {
        APIlib.getInstance().addJSLine(this.jsBase + ".container();");
    }

    public GanttToolbar container(String str) {
        APIlib.getInstance().addJSLine(String.format(Locale.US, this.jsBase + ".container(%s);", wrapQuotes(str)));
        return this;
    }

    public GanttToolbar draw() {
        APIlib.getInstance().addJSLine(this.jsBase + ".draw();");
        return this;
    }

    public void printPaperSizes() {
        APIlib.getInstance().addJSLine(this.jsBase + ".printPaperSizes();");
    }

    public GanttToolbar printPaperSizes(PaperSize[] paperSizeArr) {
        APIlib.getInstance().addJSLine(String.format(Locale.US, this.jsBase + ".printPaperSizes(%s);", arrayToString(paperSizeArr)));
        return this;
    }

    public Chart target() {
        return new Chart(this.jsBase + ".target()");
    }

    public GanttToolbar target(Chart chart) {
        APIlib.getInstance().addJSLine(String.format(Locale.US, this.jsBase + ".target(%s);", chart != null ? chart.getJsBase() : null));
        return this;
    }
}
