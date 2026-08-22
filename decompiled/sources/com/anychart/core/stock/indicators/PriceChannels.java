package com.anychart.core.stock.indicators;

import com.anychart.APIlib;
import com.anychart.JsObject;
import com.anychart.enums.StockSeriesType;
import java.util.Locale;

/* JADX INFO: loaded from: classes5.dex */
public class PriceChannels extends JsObject {
    protected PriceChannels() {
    }

    public static PriceChannels instantiate() {
        return new PriceChannels("new anychart.core.stock.indicators.priceChannels()");
    }

    public PriceChannels(String str) {
        StringBuilder sb = new StringBuilder("priceChannels");
        int i = variableIndex + 1;
        variableIndex = i;
        this.jsBase = sb.append(i).toString();
        APIlib.getInstance().addJSLine(this.jsBase + " = " + str + ";");
    }

    @Override // com.anychart.JsObject
    public String getJsBase() {
        return this.jsBase;
    }

    public com.anychart.core.stock.series.Base middleSeries() {
        return new com.anychart.core.stock.series.Base(this.jsBase + ".middleSeries()");
    }

    public PriceChannels middleSeries(StockSeriesType stockSeriesType) {
        APIlib.getInstance().addJSLine(String.format(Locale.US, this.jsBase + ".middleSeries(%s);", stockSeriesType != null ? stockSeriesType.getJsBase() : null));
        return this;
    }

    public PriceChannels middleSeries(String str) {
        APIlib.getInstance().addJSLine(String.format(Locale.US, this.jsBase + ".middleSeries(%s);", wrapQuotes(str)));
        return this;
    }

    public void period() {
        APIlib.getInstance().addJSLine(this.jsBase + ".period();");
    }

    public PriceChannels period(Number number) {
        APIlib.getInstance().addJSLine(String.format(Locale.US, this.jsBase + ".period(%s);", number));
        return this;
    }

    public com.anychart.core.stock.series.Base rangeSeries() {
        return new com.anychart.core.stock.series.Base(this.jsBase + ".rangeSeries()");
    }

    public PriceChannels rangeSeries(StockSeriesType stockSeriesType) {
        APIlib.getInstance().addJSLine(String.format(Locale.US, this.jsBase + ".rangeSeries(%s);", stockSeriesType != null ? stockSeriesType.getJsBase() : null));
        return this;
    }

    public PriceChannels rangeSeries(String str) {
        APIlib.getInstance().addJSLine(String.format(Locale.US, this.jsBase + ".rangeSeries(%s);", wrapQuotes(str)));
        return this;
    }
}
