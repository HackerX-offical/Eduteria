package com.anychart.core.stock.indicators;

import com.anychart.APIlib;
import com.anychart.JsObject;
import com.anychart.enums.StockSeriesType;
import java.util.Locale;

/* JADX INFO: loaded from: classes5.dex */
public class Aroon extends JsObject {
    protected Aroon() {
    }

    public static Aroon instantiate() {
        return new Aroon("new anychart.core.stock.indicators.aroon()");
    }

    public Aroon(String str) {
        StringBuilder sb = new StringBuilder("aroon");
        int i = variableIndex + 1;
        variableIndex = i;
        this.jsBase = sb.append(i).toString();
        APIlib.getInstance().addJSLine(this.jsBase + " = " + str + ";");
    }

    @Override // com.anychart.JsObject
    public String getJsBase() {
        return this.jsBase;
    }

    public com.anychart.core.stock.series.Base downSeries() {
        return new com.anychart.core.stock.series.Base(this.jsBase + ".downSeries()");
    }

    public Aroon downSeries(StockSeriesType stockSeriesType) {
        APIlib.getInstance().addJSLine(String.format(Locale.US, this.jsBase + ".downSeries(%s);", stockSeriesType != null ? stockSeriesType.getJsBase() : null));
        return this;
    }

    public Aroon downSeries(String str) {
        APIlib.getInstance().addJSLine(String.format(Locale.US, this.jsBase + ".downSeries(%s);", wrapQuotes(str)));
        return this;
    }

    public void period() {
        APIlib.getInstance().addJSLine(this.jsBase + ".period();");
    }

    public Aroon period(Number number) {
        APIlib.getInstance().addJSLine(String.format(Locale.US, this.jsBase + ".period(%s);", number));
        return this;
    }

    public com.anychart.core.stock.series.Base rangeSeries() {
        return new com.anychart.core.stock.series.Base(this.jsBase + ".rangeSeries()");
    }

    public Aroon rangeSeries(StockSeriesType stockSeriesType) {
        APIlib.getInstance().addJSLine(String.format(Locale.US, this.jsBase + ".rangeSeries(%s);", stockSeriesType != null ? stockSeriesType.getJsBase() : null));
        return this;
    }

    public Aroon rangeSeries(String str) {
        APIlib.getInstance().addJSLine(String.format(Locale.US, this.jsBase + ".rangeSeries(%s);", wrapQuotes(str)));
        return this;
    }

    public com.anychart.core.stock.series.Base upSeries() {
        return new com.anychart.core.stock.series.Base(this.jsBase + ".upSeries()");
    }

    public Aroon upSeries(StockSeriesType stockSeriesType) {
        APIlib.getInstance().addJSLine(String.format(Locale.US, this.jsBase + ".upSeries(%s);", stockSeriesType != null ? stockSeriesType.getJsBase() : null));
        return this;
    }

    public Aroon upSeries(String str) {
        APIlib.getInstance().addJSLine(String.format(Locale.US, this.jsBase + ".upSeries(%s);", wrapQuotes(str)));
        return this;
    }
}
