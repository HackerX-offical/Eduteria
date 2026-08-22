package com.anychart.core;

import com.anychart.APIlib;
import com.anychart.enums.Statistics;
import java.util.Locale;

/* JADX INFO: loaded from: classes3.dex */
public class MapPoint extends Point {
    protected MapPoint() {
    }

    public static MapPoint instantiate() {
        return new MapPoint("new anychart.core.mapPoint()");
    }

    public MapPoint(String str) {
        StringBuilder sb = new StringBuilder("mapPoint");
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

    public SeparateChart getCurrentChart() {
        return new SeparateChart(this.jsBase + ".getCurrentChart()");
    }

    public void getId() {
        APIlib.getInstance().addJSLine(this.jsBase + ".getId();");
    }

    @Override // com.anychart.core.Point
    public void getIndex() {
        APIlib.getInstance().addJSLine(this.jsBase + ".getIndex();");
    }

    public SeparateChart getParentChart() {
        return new SeparateChart(this.jsBase + ".getParentChart()");
    }

    public void getProperties() {
        APIlib.getInstance().addJSLine(this.jsBase + ".getProperties();");
    }

    @Override // com.anychart.core.Point
    public void hovered() {
        APIlib.getInstance().addJSLine(this.jsBase + ".hovered();");
    }

    @Override // com.anychart.core.Point
    public MapPoint hovered(Boolean bool) {
        APIlib.getInstance().addJSLine(String.format(Locale.US, this.jsBase + ".hovered(%s);", bool));
        return this;
    }

    @Override // com.anychart.core.Point
    public void selected() {
        APIlib.getInstance().addJSLine(this.jsBase + ".selected();");
    }

    @Override // com.anychart.core.Point
    public MapPoint selected(Boolean bool) {
        APIlib.getInstance().addJSLine(String.format(Locale.US, this.jsBase + ".selected(%s);", bool));
        return this;
    }

    @Override // com.anychart.core.Point
    public MapPoint set(String str, String str2) {
        APIlib.getInstance().addJSLine(String.format(Locale.US, this.jsBase + ".set(%s, %s);", wrapQuotes(str), wrapQuotes(str2)));
        return this;
    }

    @Override // com.anychart.core.Point
    public void getStat(Statistics statistics) {
        APIlib.getInstance().addJSLine(String.format(Locale.US, this.jsBase + ".getStat(%s);", statistics != null ? statistics.getJsBase() : null));
    }

    @Override // com.anychart.core.Point
    public void getStat(String str) {
        APIlib.getInstance().addJSLine(String.format(Locale.US, this.jsBase + ".getStat(%s);", wrapQuotes(str)));
    }
}
