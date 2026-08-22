package com.anychart.core.stock.indicators;

import com.anychart.APIlib;
import com.anychart.JsObject;
import com.anychart.enums.StockSeriesType;
import java.util.Locale;

/* JADX INFO: loaded from: classes5.dex */
public class SMA extends JsObject {
    protected SMA() {
    }

    public static SMA instantiate() {
        return new SMA("new anychart.core.stock.indicators.sMA()");
    }

    public SMA(String str) {
        StringBuilder sb = new StringBuilder("sMA");
        int i = variableIndex + 1;
        variableIndex = i;
        this.jsBase = sb.append(i).toString();
        APIlib.getInstance().addJSLine(this.jsBase + " = " + str + ";");
    }

    @Override // com.anychart.JsObject
    public String getJsBase() {
        return this.jsBase;
    }

    public void period() {
        APIlib.getInstance().addJSLine(this.jsBase + ".period();");
    }

    public SMA period(Number number) {
        APIlib.getInstance().addJSLine(String.format(Locale.US, this.jsBase + ".period(%s);", number));
        return this;
    }

    public com.anychart.core.stock.series.Base series() {
        return new com.anychart.core.stock.series.Base(this.jsBase + ".series()");
    }

    public SMA series(StockSeriesType stockSeriesType) {
        APIlib.getInstance().addJSLine(String.format(Locale.US, this.jsBase + ".series(%s);", stockSeriesType != null ? stockSeriesType.getJsBase() : null));
        return this;
    }

    public SMA series(String str) {
        APIlib.getInstance().addJSLine(String.format(Locale.US, this.jsBase + ".series(%s);", wrapQuotes(str)));
        return this;
    }
}
