package com.anychart.core.stock.indicators;

import com.anychart.APIlib;
import com.anychart.JsObject;
import com.anychart.enums.StockSeriesType;
import java.util.Locale;

/* JADX INFO: loaded from: classes5.dex */
public class KeltnerChannels extends JsObject {
    protected KeltnerChannels() {
    }

    public static KeltnerChannels instantiate() {
        return new KeltnerChannels("new anychart.core.stock.indicators.keltnerChannels()");
    }

    public KeltnerChannels(String str) {
        StringBuilder sb = new StringBuilder("keltnerChannels");
        int i = variableIndex + 1;
        variableIndex = i;
        this.jsBase = sb.append(i).toString();
        APIlib.getInstance().addJSLine(this.jsBase + " = " + str + ";");
    }

    @Override // com.anychart.JsObject
    public String getJsBase() {
        return this.jsBase;
    }

    public void atrPeriod() {
        APIlib.getInstance().addJSLine(this.jsBase + ".atrPeriod();");
    }

    public KeltnerChannels atrPeriod(Number number) {
        APIlib.getInstance().addJSLine(String.format(Locale.US, this.jsBase + ".atrPeriod(%s);", number));
        return this;
    }

    public void maPeriod() {
        APIlib.getInstance().addJSLine(this.jsBase + ".maPeriod();");
    }

    public KeltnerChannels maPeriod(Number number) {
        APIlib.getInstance().addJSLine(String.format(Locale.US, this.jsBase + ".maPeriod(%s);", number));
        return this;
    }

    public com.anychart.core.stock.series.Base maSeries() {
        return new com.anychart.core.stock.series.Base(this.jsBase + ".maSeries()");
    }

    public KeltnerChannels maSeries(StockSeriesType stockSeriesType) {
        APIlib.getInstance().addJSLine(String.format(Locale.US, this.jsBase + ".maSeries(%s);", stockSeriesType != null ? stockSeriesType.getJsBase() : null));
        return this;
    }

    public KeltnerChannels maSeries(String str) {
        APIlib.getInstance().addJSLine(String.format(Locale.US, this.jsBase + ".maSeries(%s);", wrapQuotes(str)));
        return this;
    }

    public void multiplier() {
        APIlib.getInstance().addJSLine(this.jsBase + ".multiplier();");
    }

    public KeltnerChannels multiplier(Number number) {
        APIlib.getInstance().addJSLine(String.format(Locale.US, this.jsBase + ".multiplier(%s);", number));
        return this;
    }

    public com.anychart.core.stock.series.Base rangeSeries() {
        return new com.anychart.core.stock.series.Base(this.jsBase + ".rangeSeries()");
    }

    public KeltnerChannels rangeSeries(StockSeriesType stockSeriesType) {
        APIlib.getInstance().addJSLine(String.format(Locale.US, this.jsBase + ".rangeSeries(%s);", stockSeriesType != null ? stockSeriesType.getJsBase() : null));
        return this;
    }

    public KeltnerChannels rangeSeries(String str) {
        APIlib.getInstance().addJSLine(String.format(Locale.US, this.jsBase + ".rangeSeries(%s);", wrapQuotes(str)));
        return this;
    }
}
