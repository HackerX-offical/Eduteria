package com.anychart.core;

import com.anychart.APIlib;
import com.anychart.enums.Statistics;
import java.util.Locale;

/* JADX INFO: loaded from: classes3.dex */
public class PiePoint extends Point {
    protected PiePoint() {
    }

    public static PiePoint instantiate() {
        return new PiePoint("new anychart.core.piePoint()");
    }

    public PiePoint(String str) {
        StringBuilder sb = new StringBuilder("piePoint");
        int i = variableIndex + 1;
        variableIndex = i;
        this.jsBase = sb.append(i).toString();
        APIlib.getInstance().addJSLine(this.jsBase + " = " + str + ";");
    }

    @Override // com.anychart.core.Point, com.anychart.JsObject
    public String getJsBase() {
        return this.jsBase;
    }

    @Override // com.anychart.core.Point
    public void exists() {
        APIlib.getInstance().addJSLine(this.jsBase + ".exists();");
    }

    @Override // com.anychart.core.Point
    public void get(String str) {
        APIlib.getInstance().addJSLine(String.format(Locale.US, this.jsBase + ".get(%s);", wrapQuotes(str)));
    }

    @Override // com.anychart.core.Point
    public SeparateChart getChart() {
        return new SeparateChart(this.jsBase + ".getChart()");
    }

    public void getEndAngle() {
        APIlib.getInstance().addJSLine(this.jsBase + ".getEndAngle();");
    }

    @Override // com.anychart.core.Point
    public void getIndex() {
        APIlib.getInstance().addJSLine(this.jsBase + ".getIndex();");
    }

    public void getStartAngle() {
        APIlib.getInstance().addJSLine(this.jsBase + ".getStartAngle();");
    }

    @Override // com.anychart.core.Point
    public void getStat(Statistics statistics) {
        APIlib.getInstance().addJSLine(String.format(Locale.US, this.jsBase + ".getStat(%s);", statistics != null ? statistics.getJsBase() : null));
    }

    @Override // com.anychart.core.Point
    public void getStat(String str) {
        APIlib.getInstance().addJSLine(String.format(Locale.US, this.jsBase + ".getStat(%s);", wrapQuotes(str)));
    }

    @Override // com.anychart.core.Point
    public void hovered() {
        APIlib.getInstance().addJSLine(this.jsBase + ".hovered();");
    }

    @Override // com.anychart.core.Point
    public PiePoint hovered(Boolean bool) {
        APIlib.getInstance().addJSLine(String.format(Locale.US, this.jsBase + ".hovered(%s);", bool));
        return this;
    }

    @Override // com.anychart.core.Point
    public void selected() {
        APIlib.getInstance().addJSLine(this.jsBase + ".selected();");
    }

    @Override // com.anychart.core.Point
    public PiePoint selected(Boolean bool) {
        APIlib.getInstance().addJSLine(String.format(Locale.US, this.jsBase + ".selected(%s);", bool));
        return this;
    }

    @Override // com.anychart.core.Point
    public PiePoint set(String str, String str2) {
        APIlib.getInstance().addJSLine(String.format(Locale.US, this.jsBase + ".set(%s, %s);", wrapQuotes(str), wrapQuotes(str2)));
        return this;
    }
}
