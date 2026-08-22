package com.anychart.core.stock.indicators;

import com.anychart.APIlib;
import com.anychart.JsObject;
import com.anychart.enums.StockSeriesType;
import java.util.Locale;

/* JADX INFO: loaded from: classes5.dex */
public class BBands extends JsObject {
    protected BBands() {
    }

    public static BBands instantiate() {
        return new BBands("new anychart.core.stock.indicators.bBands()");
    }

    public BBands(String str) {
        StringBuilder sb = new StringBuilder("bBands");
        int i = variableIndex + 1;
        variableIndex = i;
        this.jsBase = sb.append(i).toString();
        APIlib.getInstance().addJSLine(this.jsBase + " = " + str + ";");
    }

    @Override // com.anychart.JsObject
    public String getJsBase() {
        return this.jsBase;
    }

    public void deviation() {
        APIlib.getInstance().addJSLine(this.jsBase + ".deviation();");
    }

    public BBands deviation(Number number) {
        APIlib.getInstance().addJSLine(String.format(Locale.US, this.jsBase + ".deviation(%s);", number));
        return this;
    }

    public com.anychart.core.stock.series.Base lowerSeries() {
        return new com.anychart.core.stock.series.Base(this.jsBase + ".lowerSeries()");
    }

    public BBands lowerSeries(StockSeriesType stockSeriesType) {
        APIlib.getInstance().addJSLine(String.format(Locale.US, this.jsBase + ".lowerSeries(%s);", stockSeriesType != null ? stockSeriesType.getJsBase() : null));
        return this;
    }

    public BBands lowerSeries(String str) {
        APIlib.getInstance().addJSLine(String.format(Locale.US, this.jsBase + ".lowerSeries(%s);", wrapQuotes(str)));
        return this;
    }

    public com.anychart.core.stock.series.Base middleSeries() {
        return new com.anychart.core.stock.series.Base(this.jsBase + ".middleSeries()");
    }

    public BBands middleSeries(StockSeriesType stockSeriesType) {
        APIlib.getInstance().addJSLine(String.format(Locale.US, this.jsBase + ".middleSeries(%s);", stockSeriesType != null ? stockSeriesType.getJsBase() : null));
        return this;
    }

    public BBands middleSeries(String str) {
        APIlib.getInstance().addJSLine(String.format(Locale.US, this.jsBase + ".middleSeries(%s);", wrapQuotes(str)));
        return this;
    }

    public void period() {
        APIlib.getInstance().addJSLine(this.jsBase + ".period();");
    }

    public BBands period(Number number) {
        APIlib.getInstance().addJSLine(String.format(Locale.US, this.jsBase + ".period(%s);", number));
        return this;
    }

    public com.anychart.core.stock.series.Base rangeSeries() {
        return new com.anychart.core.stock.series.Base(this.jsBase + ".rangeSeries()");
    }

    public BBands rangeSeries(StockSeriesType stockSeriesType) {
        APIlib.getInstance().addJSLine(String.format(Locale.US, this.jsBase + ".rangeSeries(%s);", stockSeriesType != null ? stockSeriesType.getJsBase() : null));
        return this;
    }

    public BBands rangeSeries(String str) {
        APIlib.getInstance().addJSLine(String.format(Locale.US, this.jsBase + ".rangeSeries(%s);", wrapQuotes(str)));
        return this;
    }

    public com.anychart.core.stock.series.Base upperSeries() {
        return new com.anychart.core.stock.series.Base(this.jsBase + ".upperSeries()");
    }

    public BBands upperSeries(StockSeriesType stockSeriesType) {
        APIlib.getInstance().addJSLine(String.format(Locale.US, this.jsBase + ".upperSeries(%s);", stockSeriesType != null ? stockSeriesType.getJsBase() : null));
        return this;
    }

    public BBands upperSeries(String str) {
        APIlib.getInstance().addJSLine(String.format(Locale.US, this.jsBase + ".upperSeries(%s);", wrapQuotes(str)));
        return this;
    }
}
