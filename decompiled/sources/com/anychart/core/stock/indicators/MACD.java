package com.anychart.core.stock.indicators;

import com.anychart.APIlib;
import com.anychart.JsObject;
import com.anychart.enums.StockSeriesType;
import java.util.Locale;

/* JADX INFO: loaded from: classes5.dex */
public class MACD extends JsObject {
    protected MACD() {
    }

    public static MACD instantiate() {
        return new MACD("new anychart.core.stock.indicators.mACD()");
    }

    public MACD(String str) {
        StringBuilder sb = new StringBuilder("mACD");
        int i = variableIndex + 1;
        variableIndex = i;
        this.jsBase = sb.append(i).toString();
        APIlib.getInstance().addJSLine(this.jsBase + " = " + str + ";");
    }

    @Override // com.anychart.JsObject
    public String getJsBase() {
        return this.jsBase;
    }

    public void fastPeriod() {
        APIlib.getInstance().addJSLine(this.jsBase + ".fastPeriod();");
    }

    public MACD fastPeriod(Number number) {
        APIlib.getInstance().addJSLine(String.format(Locale.US, this.jsBase + ".fastPeriod(%s);", number));
        return this;
    }

    public com.anychart.core.stock.series.Base histogramSeries() {
        return new com.anychart.core.stock.series.Base(this.jsBase + ".histogramSeries()");
    }

    public MACD histogramSeries(StockSeriesType stockSeriesType) {
        APIlib.getInstance().addJSLine(String.format(Locale.US, this.jsBase + ".histogramSeries(%s);", stockSeriesType != null ? stockSeriesType.getJsBase() : null));
        return this;
    }

    public MACD histogramSeries(String str) {
        APIlib.getInstance().addJSLine(String.format(Locale.US, this.jsBase + ".histogramSeries(%s);", wrapQuotes(str)));
        return this;
    }

    public com.anychart.core.stock.series.Base macdSeries() {
        return new com.anychart.core.stock.series.Base(this.jsBase + ".macdSeries()");
    }

    public MACD macdSeries(StockSeriesType stockSeriesType) {
        APIlib.getInstance().addJSLine(String.format(Locale.US, this.jsBase + ".macdSeries(%s);", stockSeriesType != null ? stockSeriesType.getJsBase() : null));
        return this;
    }

    public MACD macdSeries(String str) {
        APIlib.getInstance().addJSLine(String.format(Locale.US, this.jsBase + ".macdSeries(%s);", wrapQuotes(str)));
        return this;
    }

    public void signalPeriod() {
        APIlib.getInstance().addJSLine(this.jsBase + ".signalPeriod();");
    }

    public MACD signalPeriod(Number number) {
        APIlib.getInstance().addJSLine(String.format(Locale.US, this.jsBase + ".signalPeriod(%s);", number));
        return this;
    }

    public com.anychart.core.stock.series.Base signalSeries() {
        return new com.anychart.core.stock.series.Base(this.jsBase + ".signalSeries()");
    }

    public MACD signalSeries(StockSeriesType stockSeriesType) {
        APIlib.getInstance().addJSLine(String.format(Locale.US, this.jsBase + ".signalSeries(%s);", stockSeriesType != null ? stockSeriesType.getJsBase() : null));
        return this;
    }

    public MACD signalSeries(String str) {
        APIlib.getInstance().addJSLine(String.format(Locale.US, this.jsBase + ".signalSeries(%s);", wrapQuotes(str)));
        return this;
    }

    public void slowPeriod() {
        APIlib.getInstance().addJSLine(this.jsBase + ".slowPeriod();");
    }

    public MACD slowPeriod(Number number) {
        APIlib.getInstance().addJSLine(String.format(Locale.US, this.jsBase + ".slowPeriod(%s);", number));
        return this;
    }
}
