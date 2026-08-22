package com.anychart.core.stock.indicators;

import com.anychart.APIlib;
import com.anychart.JsObject;
import com.anychart.enums.MovingAverageType;
import com.anychart.enums.StockSeriesType;
import java.util.Locale;

/* JADX INFO: loaded from: classes5.dex */
public class KDJ extends JsObject {
    protected KDJ() {
    }

    public static KDJ instantiate() {
        return new KDJ("new anychart.core.stock.indicators.kDJ()");
    }

    public KDJ(String str) {
        StringBuilder sb = new StringBuilder("kDJ");
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

    public KDJ dMAType(MovingAverageType movingAverageType) {
        APIlib.getInstance().addJSLine(String.format(Locale.US, this.jsBase + ".dMAType(%s);", movingAverageType != null ? movingAverageType.getJsBase() : null));
        return this;
    }

    public KDJ dMAType(String str) {
        APIlib.getInstance().addJSLine(String.format(Locale.US, this.jsBase + ".dMAType(%s);", wrapQuotes(str)));
        return this;
    }

    public void dMultiplier() {
        APIlib.getInstance().addJSLine(this.jsBase + ".dMultiplier();");
    }

    public KDJ dMultiplier(Number number) {
        APIlib.getInstance().addJSLine(String.format(Locale.US, this.jsBase + ".dMultiplier(%s);", number));
        return this;
    }

    public void dPeriod() {
        APIlib.getInstance().addJSLine(this.jsBase + ".dPeriod();");
    }

    public KDJ dPeriod(Number number) {
        APIlib.getInstance().addJSLine(String.format(Locale.US, this.jsBase + ".dPeriod(%s);", number));
        return this;
    }

    public com.anychart.core.stock.series.Base dSeries() {
        return new com.anychart.core.stock.series.Base(this.jsBase + ".dSeries()");
    }

    public KDJ dSeries(StockSeriesType stockSeriesType) {
        APIlib.getInstance().addJSLine(String.format(Locale.US, this.jsBase + ".dSeries(%s);", stockSeriesType != null ? stockSeriesType.getJsBase() : null));
        return this;
    }

    public KDJ dSeries(String str) {
        APIlib.getInstance().addJSLine(String.format(Locale.US, this.jsBase + ".dSeries(%s);", wrapQuotes(str)));
        return this;
    }

    public com.anychart.core.stock.series.Base jSeries() {
        return new com.anychart.core.stock.series.Base(this.jsBase + ".jSeries()");
    }

    public KDJ jSeries(StockSeriesType stockSeriesType) {
        APIlib.getInstance().addJSLine(String.format(Locale.US, this.jsBase + ".jSeries(%s);", stockSeriesType != null ? stockSeriesType.getJsBase() : null));
        return this;
    }

    public KDJ jSeries(String str) {
        APIlib.getInstance().addJSLine(String.format(Locale.US, this.jsBase + ".jSeries(%s);", wrapQuotes(str)));
        return this;
    }

    public void kMAPeriod() {
        APIlib.getInstance().addJSLine(this.jsBase + ".kMAPeriod();");
    }

    public KDJ kMAPeriod(Number number) {
        APIlib.getInstance().addJSLine(String.format(Locale.US, this.jsBase + ".kMAPeriod(%s);", number));
        return this;
    }

    public void kMAType() {
        APIlib.getInstance().addJSLine(this.jsBase + ".kMAType();");
    }

    public KDJ kMAType(MovingAverageType movingAverageType) {
        APIlib.getInstance().addJSLine(String.format(Locale.US, this.jsBase + ".kMAType(%s);", movingAverageType != null ? movingAverageType.getJsBase() : null));
        return this;
    }

    public KDJ kMAType(String str) {
        APIlib.getInstance().addJSLine(String.format(Locale.US, this.jsBase + ".kMAType(%s);", wrapQuotes(str)));
        return this;
    }

    public void kMultiplier() {
        APIlib.getInstance().addJSLine(this.jsBase + ".kMultiplier();");
    }

    public KDJ kMultiplier(Number number) {
        APIlib.getInstance().addJSLine(String.format(Locale.US, this.jsBase + ".kMultiplier(%s);", number));
        return this;
    }

    public void kPeriod() {
        APIlib.getInstance().addJSLine(this.jsBase + ".kPeriod();");
    }

    public KDJ kPeriod(Number number) {
        APIlib.getInstance().addJSLine(String.format(Locale.US, this.jsBase + ".kPeriod(%s);", number));
        return this;
    }

    public com.anychart.core.stock.series.Base kSeries() {
        return new com.anychart.core.stock.series.Base(this.jsBase + ".kSeries()");
    }

    public KDJ kSeries(StockSeriesType stockSeriesType) {
        APIlib.getInstance().addJSLine(String.format(Locale.US, this.jsBase + ".kSeries(%s);", stockSeriesType != null ? stockSeriesType.getJsBase() : null));
        return this;
    }

    public KDJ kSeries(String str) {
        APIlib.getInstance().addJSLine(String.format(Locale.US, this.jsBase + ".kSeries(%s);", wrapQuotes(str)));
        return this;
    }
}
