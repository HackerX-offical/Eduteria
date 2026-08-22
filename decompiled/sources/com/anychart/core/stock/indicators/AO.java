package com.anychart.core.stock.indicators;

import com.anychart.APIlib;
import com.anychart.enums.MovingAverageType;
import com.anychart.enums.StockSeriesType;
import java.util.Locale;

/* JADX INFO: loaded from: classes5.dex */
public class AO extends Base {
    protected AO() {
    }

    public static AO instantiate() {
        return new AO("new anychart.core.stock.indicators.aO()");
    }

    public AO(String str) {
        StringBuilder sb = new StringBuilder("aO");
        int i = variableIndex + 1;
        variableIndex = i;
        this.jsBase = sb.append(i).toString();
        APIlib.getInstance().addJSLine(this.jsBase + " = " + str + ";");
    }

    @Override // com.anychart.core.stock.indicators.Base, com.anychart.JsObject
    public String getJsBase() {
        return this.jsBase;
    }

    public void fastPeriod() {
        APIlib.getInstance().addJSLine(this.jsBase + ".fastPeriod();");
    }

    public AO fastPeriod(Number number) {
        APIlib.getInstance().addJSLine(String.format(Locale.US, this.jsBase + ".fastPeriod(%s);", number));
        return this;
    }

    public void maType() {
        APIlib.getInstance().addJSLine(this.jsBase + ".maType();");
    }

    public AO maType(MovingAverageType movingAverageType) {
        APIlib.getInstance().addJSLine(String.format(Locale.US, this.jsBase + ".maType(%s);", movingAverageType != null ? movingAverageType.getJsBase() : null));
        return this;
    }

    public AO maType(String str) {
        APIlib.getInstance().addJSLine(String.format(Locale.US, this.jsBase + ".maType(%s);", wrapQuotes(str)));
        return this;
    }

    public com.anychart.core.stock.series.Base series() {
        return new com.anychart.core.stock.series.Base(this.jsBase + ".series()");
    }

    public AO series(StockSeriesType stockSeriesType) {
        APIlib.getInstance().addJSLine(String.format(Locale.US, this.jsBase + ".series(%s);", stockSeriesType != null ? stockSeriesType.getJsBase() : null));
        return this;
    }

    public AO series(String str) {
        APIlib.getInstance().addJSLine(String.format(Locale.US, this.jsBase + ".series(%s);", wrapQuotes(str)));
        return this;
    }

    public void slowPeriod() {
        APIlib.getInstance().addJSLine(this.jsBase + ".slowPeriod();");
    }

    public AO slowPeriod(Number number) {
        APIlib.getInstance().addJSLine(String.format(Locale.US, this.jsBase + ".slowPeriod(%s);", number));
        return this;
    }
}
