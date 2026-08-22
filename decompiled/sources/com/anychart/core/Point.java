package com.anychart.core;

import com.anychart.APIlib;
import com.anychart.JsObject;
import com.anychart.enums.Statistics;
import com.appnew.android.Utils.Const;
import java.util.Locale;

/* JADX INFO: loaded from: classes3.dex */
public class Point extends JsObject {
    protected Point() {
    }

    public static Point instantiate() {
        return new Point("new anychart.core.point()");
    }

    public Point(String str) {
        StringBuilder sb = new StringBuilder(Const.POINT);
        int i = variableIndex + 1;
        variableIndex = i;
        this.jsBase = sb.append(i).toString();
        APIlib.getInstance().addJSLine(this.jsBase + " = " + str + ";");
    }

    @Override // com.anychart.JsObject
    public String getJsBase() {
        return this.jsBase;
    }

    public void exists() {
        APIlib.getInstance().addJSLine(this.jsBase + ".exists();");
    }

    public void get(String str) {
        APIlib.getInstance().addJSLine(String.format(Locale.US, this.jsBase + ".get(%s);", wrapQuotes(str)));
    }

    public SeparateChart getChart() {
        return new SeparateChart(this.jsBase + ".getChart()");
    }

    public void getIndex() {
        APIlib.getInstance().addJSLine(this.jsBase + ".getIndex();");
    }

    public void getStat(Statistics statistics) {
        APIlib.getInstance().addJSLine(String.format(Locale.US, this.jsBase + ".getStat(%s);", statistics != null ? statistics.getJsBase() : null));
    }

    public void getStat(String str) {
        APIlib.getInstance().addJSLine(String.format(Locale.US, this.jsBase + ".getStat(%s);", wrapQuotes(str)));
    }

    public void hovered() {
        APIlib.getInstance().addJSLine(this.jsBase + ".hovered();");
    }

    public Point hovered(Boolean bool) {
        APIlib.getInstance().addJSLine(String.format(Locale.US, this.jsBase + ".hovered(%s);", bool));
        return this;
    }

    public void selected() {
        APIlib.getInstance().addJSLine(this.jsBase + ".selected();");
    }

    public Point selected(Boolean bool) {
        APIlib.getInstance().addJSLine(String.format(Locale.US, this.jsBase + ".selected(%s);", bool));
        return this;
    }

    public Point set(String str, String str2) {
        APIlib.getInstance().addJSLine(String.format(Locale.US, this.jsBase + ".set(%s, %s);", wrapQuotes(str), wrapQuotes(str2)));
        return this;
    }
}
