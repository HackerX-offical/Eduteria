package com.anychart.core.stock.indicators;

import com.anychart.APIlib;
import com.anychart.JsObject;
import com.anychart.enums.MovingAverageType;
import com.anychart.enums.StockSeriesType;
import java.util.Locale;

/* JADX INFO: loaded from: classes5.dex */
public class CHO extends JsObject {
    protected CHO() {
    }

    public static CHO instantiate() {
        return new CHO("new anychart.core.stock.indicators.cHO()");
    }

    public CHO(String str) {
        StringBuilder sb = new StringBuilder("cHO");
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

    public CHO fastPeriod(Number number) {
        APIlib.getInstance().addJSLine(String.format(Locale.US, this.jsBase + ".fastPeriod(%s);", number));
        return this;
    }

    public void maType() {
        APIlib.getInstance().addJSLine(this.jsBase + ".maType();");
    }

    public CHO maType(MovingAverageType movingAverageType) {
        APIlib.getInstance().addJSLine(String.format(Locale.US, this.jsBase + ".maType(%s);", movingAverageType != null ? movingAverageType.getJsBase() : null));
        return this;
    }

    public CHO maType(String str) {
        APIlib.getInstance().addJSLine(String.format(Locale.US, this.jsBase + ".maType(%s);", wrapQuotes(str)));
        return this;
    }

    public com.anychart.core.stock.series.Base series() {
        return new com.anychart.core.stock.series.Base(this.jsBase + ".series()");
    }

    public CHO series(StockSeriesType stockSeriesType) {
        APIlib.getInstance().addJSLine(String.format(Locale.US, this.jsBase + ".series(%s);", stockSeriesType != null ? stockSeriesType.getJsBase() : null));
        return this;
    }

    public CHO series(String str) {
        APIlib.getInstance().addJSLine(String.format(Locale.US, this.jsBase + ".series(%s);", wrapQuotes(str)));
        return this;
    }

    public void slowPeriod() {
        APIlib.getInstance().addJSLine(this.jsBase + ".slowPeriod();");
    }

    public CHO slowPeriod(Number number) {
        APIlib.getInstance().addJSLine(String.format(Locale.US, this.jsBase + ".slowPeriod(%s);", number));
        return this;
    }
}
