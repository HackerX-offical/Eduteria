package com.anychart.core.stock.indicators;

import com.anychart.APIlib;
import com.anychart.JsObject;
import com.anychart.enums.StockSeriesType;
import java.util.Locale;

/* JADX INFO: loaded from: classes5.dex */
public class AMA extends JsObject {
    protected AMA() {
    }

    public static AMA instantiate() {
        return new AMA("new anychart.core.stock.indicators.aMA()");
    }

    public AMA(String str) {
        StringBuilder sb = new StringBuilder("aMA");
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

    public AMA fastPeriod(Number number) {
        APIlib.getInstance().addJSLine(String.format(Locale.US, this.jsBase + ".fastPeriod(%s);", number));
        return this;
    }

    public void period() {
        APIlib.getInstance().addJSLine(this.jsBase + ".period();");
    }

    public AMA period(Number number) {
        APIlib.getInstance().addJSLine(String.format(Locale.US, this.jsBase + ".period(%s);", number));
        return this;
    }

    public com.anychart.core.stock.series.Base series() {
        return new com.anychart.core.stock.series.Base(this.jsBase + ".series()");
    }

    public AMA series(StockSeriesType stockSeriesType) {
        APIlib.getInstance().addJSLine(String.format(Locale.US, this.jsBase + ".series(%s);", stockSeriesType != null ? stockSeriesType.getJsBase() : null));
        return this;
    }

    public AMA series(String str) {
        APIlib.getInstance().addJSLine(String.format(Locale.US, this.jsBase + ".series(%s);", wrapQuotes(str)));
        return this;
    }

    public void slowPeriod() {
        APIlib.getInstance().addJSLine(this.jsBase + ".slowPeriod();");
    }

    public AMA slowPeriod(Number number) {
        APIlib.getInstance().addJSLine(String.format(Locale.US, this.jsBase + ".slowPeriod(%s);", number));
        return this;
    }
}
