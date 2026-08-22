package com.anychart.core;

import com.anychart.APIlib;
import com.anychart.enums.Statistics;
import com.anychart.math.Rect;
import java.util.Locale;

/* JADX INFO: loaded from: classes3.dex */
public class ChoroplethPoint extends SeriesPoint {
    protected ChoroplethPoint() {
    }

    public static ChoroplethPoint instantiate() {
        return new ChoroplethPoint("new anychart.core.choroplethPoint()");
    }

    public ChoroplethPoint(String str) {
        StringBuilder sb = new StringBuilder("choroplethPoint");
        int i = variableIndex + 1;
        variableIndex = i;
        this.jsBase = sb.append(i).toString();
        APIlib.getInstance().addJSLine(this.jsBase + " = " + str + ";");
    }

    @Override // com.anychart.core.SeriesPoint, com.anychart.core.Point, com.anychart.JsObject
    public String getJsBase() {
        return this.jsBase;
    }

    public void crs() {
        APIlib.getInstance().addJSLine(this.jsBase + ".crs();");
    }

    public ChoroplethPoint crs(String str) {
        APIlib.getInstance().addJSLine(String.format(Locale.US, this.jsBase + ".crs(%s);", wrapQuotes(str)));
        return this;
    }

    @Override // com.anychart.core.SeriesPoint, com.anychart.core.Point
    public void exists() {
        APIlib.getInstance().addJSLine(this.jsBase + ".exists();");
    }

    @Override // com.anychart.core.SeriesPoint, com.anychart.core.Point
    public void get(String str) {
        APIlib.getInstance().addJSLine(String.format(Locale.US, this.jsBase + ".get(%s);", wrapQuotes(str)));
    }

    @Override // com.anychart.core.SeriesPoint, com.anychart.core.Point
    public SeparateChart getChart() {
        return new SeparateChart(this.jsBase + ".getChart()");
    }

    public Rect getFeatureBounds() {
        return new Rect(this.jsBase + ".getFeatureBounds()");
    }

    public void getFeatureProp() {
        APIlib.getInstance().addJSLine(this.jsBase + ".getFeatureProp();");
    }

    @Override // com.anychart.core.SeriesPoint, com.anychart.core.Point
    public void getIndex() {
        APIlib.getInstance().addJSLine(this.jsBase + ".getIndex();");
    }

    @Override // com.anychart.core.SeriesPoint
    public SeriesBase getSeries() {
        return new SeriesBase(this.jsBase + ".getSeries()");
    }

    @Override // com.anychart.core.SeriesPoint
    public void getStackValue() {
        APIlib.getInstance().addJSLine(this.jsBase + ".getStackValue();");
    }

    @Override // com.anychart.core.SeriesPoint
    public void getStackZero() {
        APIlib.getInstance().addJSLine(this.jsBase + ".getStackZero();");
    }

    @Override // com.anychart.core.SeriesPoint, com.anychart.core.Point
    public void getStat(Statistics statistics) {
        APIlib.getInstance().addJSLine(String.format(Locale.US, this.jsBase + ".getStat(%s);", statistics != null ? statistics.getJsBase() : null));
    }

    @Override // com.anychart.core.SeriesPoint, com.anychart.core.Point
    public void getStat(String str) {
        APIlib.getInstance().addJSLine(String.format(Locale.US, this.jsBase + ".getStat(%s);", wrapQuotes(str)));
    }

    @Override // com.anychart.core.SeriesPoint, com.anychart.core.Point
    public void hovered() {
        APIlib.getInstance().addJSLine(this.jsBase + ".hovered();");
    }

    @Override // com.anychart.core.SeriesPoint, com.anychart.core.Point
    public ChoroplethPoint hovered(Boolean bool) {
        APIlib.getInstance().addJSLine(String.format(Locale.US, this.jsBase + ".hovered(%s);", bool));
        return this;
    }

    public void middleX() {
        APIlib.getInstance().addJSLine(this.jsBase + ".middleX();");
    }

    public ChoroplethPoint middleX(Number number) {
        APIlib.getInstance().addJSLine(String.format(Locale.US, this.jsBase + ".middleX(%s);", number));
        return this;
    }

    public void middleY() {
        APIlib.getInstance().addJSLine(this.jsBase + ".middleY();");
    }

    public ChoroplethPoint middleY(Number number) {
        APIlib.getInstance().addJSLine(String.format(Locale.US, this.jsBase + ".middleY(%s);", number));
        return this;
    }

    public void scaleFactor() {
        APIlib.getInstance().addJSLine(this.jsBase + ".scaleFactor();");
    }

    public ChoroplethPoint scaleFactor(Number number) {
        APIlib.getInstance().addJSLine(String.format(Locale.US, this.jsBase + ".scaleFactor(%s);", number));
        return this;
    }

    @Override // com.anychart.core.SeriesPoint, com.anychart.core.Point
    public void selected() {
        APIlib.getInstance().addJSLine(this.jsBase + ".selected();");
    }

    @Override // com.anychart.core.SeriesPoint, com.anychart.core.Point
    public ChoroplethPoint selected(Boolean bool) {
        APIlib.getInstance().addJSLine(String.format(Locale.US, this.jsBase + ".selected(%s);", bool));
        return this;
    }

    @Override // com.anychart.core.SeriesPoint, com.anychart.core.Point
    public ChoroplethPoint set(String str, String str2) {
        APIlib.getInstance().addJSLine(String.format(Locale.US, this.jsBase + ".set(%s, %s);", wrapQuotes(str), wrapQuotes(str2)));
        return this;
    }

    public ChoroplethPoint translate(Number number, Number number2) {
        APIlib.getInstance().addJSLine(String.format(Locale.US, this.jsBase + ".translate(%s, %s);", number, number2));
        return this;
    }

    public void translation() {
        APIlib.getInstance().addJSLine(this.jsBase + ".translation();");
    }

    public ChoroplethPoint translation(Number number, Number number2) {
        APIlib.getInstance().addJSLine(String.format(Locale.US, this.jsBase + ".translation(%s, %s);", number, number2));
        return this;
    }
}
