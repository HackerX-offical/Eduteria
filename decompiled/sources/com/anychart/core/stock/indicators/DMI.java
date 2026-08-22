package com.anychart.core.stock.indicators;

import com.anychart.APIlib;
import com.anychart.JsObject;
import com.anychart.enums.StockSeriesType;
import java.util.Locale;

/* JADX INFO: loaded from: classes5.dex */
public class DMI extends JsObject {
    protected DMI() {
    }

    public static DMI instantiate() {
        return new DMI("new anychart.core.stock.indicators.dMI()");
    }

    public DMI(String str) {
        StringBuilder sb = new StringBuilder("dMI");
        int i = variableIndex + 1;
        variableIndex = i;
        this.jsBase = sb.append(i).toString();
        APIlib.getInstance().addJSLine(this.jsBase + " = " + str + ";");
    }

    @Override // com.anychart.JsObject
    public String getJsBase() {
        return this.jsBase;
    }

    public void adxPeriod() {
        APIlib.getInstance().addJSLine(this.jsBase + ".adxPeriod();");
    }

    public DMI adxPeriod(Number number) {
        APIlib.getInstance().addJSLine(String.format(Locale.US, this.jsBase + ".adxPeriod(%s);", number));
        return this;
    }

    public com.anychart.core.stock.series.Base adxSeries() {
        return new com.anychart.core.stock.series.Base(this.jsBase + ".adxSeries()");
    }

    public DMI adxSeries(StockSeriesType stockSeriesType) {
        APIlib.getInstance().addJSLine(String.format(Locale.US, this.jsBase + ".adxSeries(%s);", stockSeriesType != null ? stockSeriesType.getJsBase() : null));
        return this;
    }

    public DMI adxSeries(String str) {
        APIlib.getInstance().addJSLine(String.format(Locale.US, this.jsBase + ".adxSeries(%s);", wrapQuotes(str)));
        return this;
    }

    public com.anychart.core.stock.series.Base ndiSeries() {
        return new com.anychart.core.stock.series.Base(this.jsBase + ".ndiSeries()");
    }

    public DMI ndiSeries(StockSeriesType stockSeriesType) {
        APIlib.getInstance().addJSLine(String.format(Locale.US, this.jsBase + ".ndiSeries(%s);", stockSeriesType != null ? stockSeriesType.getJsBase() : null));
        return this;
    }

    public DMI ndiSeries(String str) {
        APIlib.getInstance().addJSLine(String.format(Locale.US, this.jsBase + ".ndiSeries(%s);", wrapQuotes(str)));
        return this;
    }

    public com.anychart.core.stock.series.Base pdiSeries() {
        return new com.anychart.core.stock.series.Base(this.jsBase + ".pdiSeries()");
    }

    public DMI pdiSeries(StockSeriesType stockSeriesType) {
        APIlib.getInstance().addJSLine(String.format(Locale.US, this.jsBase + ".pdiSeries(%s);", stockSeriesType != null ? stockSeriesType.getJsBase() : null));
        return this;
    }

    public DMI pdiSeries(String str) {
        APIlib.getInstance().addJSLine(String.format(Locale.US, this.jsBase + ".pdiSeries(%s);", wrapQuotes(str)));
        return this;
    }

    public void period() {
        APIlib.getInstance().addJSLine(this.jsBase + ".period();");
    }

    public DMI period(Number number) {
        APIlib.getInstance().addJSLine(String.format(Locale.US, this.jsBase + ".period(%s);", number));
        return this;
    }

    public void useWildersSmoothing() {
        APIlib.getInstance().addJSLine(this.jsBase + ".useWildersSmoothing();");
    }

    public DMI useWildersSmoothing(Boolean bool) {
        APIlib.getInstance().addJSLine(String.format(Locale.US, this.jsBase + ".useWildersSmoothing(%s);", bool));
        return this;
    }
}
