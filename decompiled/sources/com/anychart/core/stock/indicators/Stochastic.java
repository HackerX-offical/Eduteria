package com.anychart.core.stock.indicators;

import com.anychart.APIlib;
import com.anychart.JsObject;
import com.anychart.enums.MovingAverageType;
import com.anychart.enums.StockSeriesType;
import java.util.Locale;

/* JADX INFO: loaded from: classes5.dex */
public class Stochastic extends JsObject {
    protected Stochastic() {
    }

    public static Stochastic instantiate() {
        return new Stochastic("new anychart.core.stock.indicators.stochastic()");
    }

    public Stochastic(String str) {
        StringBuilder sb = new StringBuilder("stochastic");
        int i = variableIndex + 1;
        variableIndex = i;
        this.jsBase = sb.append(i).toString();
        APIlib.getInstance().addJSLine(this.jsBase + " = " + str + ";");
    }

    @Override // com.anychart.JsObject
    public String getJsBase() {
        return this.jsBase;
    }

    public void dMAType() {
        APIlib.getInstance().addJSLine(this.jsBase + ".dMAType();");
    }

    public Stochastic dMAType(MovingAverageType movingAverageType) {
        APIlib.getInstance().addJSLine(String.format(Locale.US, this.jsBase + ".dMAType(%s);", movingAverageType != null ? movingAverageType.getJsBase() : null));
        return this;
    }

    public Stochastic dMAType(String str) {
        APIlib.getInstance().addJSLine(String.format(Locale.US, this.jsBase + ".dMAType(%s);", wrapQuotes(str)));
        return this;
    }

    public void dPeriod() {
        APIlib.getInstance().addJSLine(this.jsBase + ".dPeriod();");
    }

    public Stochastic dPeriod(Number number) {
        APIlib.getInstance().addJSLine(String.format(Locale.US, this.jsBase + ".dPeriod(%s);", number));
        return this;
    }

    public com.anychart.core.stock.series.Base dSeries() {
        return new com.anychart.core.stock.series.Base(this.jsBase + ".dSeries()");
    }

    public Stochastic dSeries(StockSeriesType stockSeriesType) {
        APIlib.getInstance().addJSLine(String.format(Locale.US, this.jsBase + ".dSeries(%s);", stockSeriesType != null ? stockSeriesType.getJsBase() : null));
        return this;
    }

    public Stochastic dSeries(String str) {
        APIlib.getInstance().addJSLine(String.format(Locale.US, this.jsBase + ".dSeries(%s);", wrapQuotes(str)));
        return this;
    }

    public void kMAPeriod() {
        APIlib.getInstance().addJSLine(this.jsBase + ".kMAPeriod();");
    }

    public Stochastic kMAPeriod(Number number) {
        APIlib.getInstance().addJSLine(String.format(Locale.US, this.jsBase + ".kMAPeriod(%s);", number));
        return this;
    }

    public void kMAType() {
        APIlib.getInstance().addJSLine(this.jsBase + ".kMAType();");
    }

    public Stochastic kMAType(MovingAverageType movingAverageType) {
        APIlib.getInstance().addJSLine(String.format(Locale.US, this.jsBase + ".kMAType(%s);", movingAverageType != null ? movingAverageType.getJsBase() : null));
        return this;
    }

    public Stochastic kMAType(String str) {
        APIlib.getInstance().addJSLine(String.format(Locale.US, this.jsBase + ".kMAType(%s);", wrapQuotes(str)));
        return this;
    }

    public void kPeriod() {
        APIlib.getInstance().addJSLine(this.jsBase + ".kPeriod();");
    }

    public Stochastic kPeriod(Number number) {
        APIlib.getInstance().addJSLine(String.format(Locale.US, this.jsBase + ".kPeriod(%s);", number));
        return this;
    }

    public com.anychart.core.stock.series.Base kSeries() {
        return new com.anychart.core.stock.series.Base(this.jsBase + ".kSeries()");
    }

    public Stochastic kSeries(StockSeriesType stockSeriesType) {
        APIlib.getInstance().addJSLine(String.format(Locale.US, this.jsBase + ".kSeries(%s);", stockSeriesType != null ? stockSeriesType.getJsBase() : null));
        return this;
    }

    public Stochastic kSeries(String str) {
        APIlib.getInstance().addJSLine(String.format(Locale.US, this.jsBase + ".kSeries(%s);", wrapQuotes(str)));
        return this;
    }
}
