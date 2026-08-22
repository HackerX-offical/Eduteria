package com.anychart.core.stock.indicators;

import com.anychart.APIlib;
import com.anychart.JsObject;
import com.anychart.enums.MovingAverageType;
import com.anychart.enums.StockSeriesType;
import java.util.Locale;

/* JADX INFO: loaded from: classes5.dex */
public class TRIX extends JsObject {
    protected TRIX() {
    }

    public static TRIX instantiate() {
        return new TRIX("new anychart.core.stock.indicators.tRIX()");
    }

    public TRIX(String str) {
        StringBuilder sb = new StringBuilder("tRIX");
        int i = variableIndex + 1;
        variableIndex = i;
        this.jsBase = sb.append(i).toString();
        APIlib.getInstance().addJSLine(this.jsBase + " = " + str + ";");
    }

    @Override // com.anychart.JsObject
    public String getJsBase() {
        return this.jsBase;
    }

    public void maType() {
        APIlib.getInstance().addJSLine(this.jsBase + ".maType();");
    }

    public TRIX maType(MovingAverageType movingAverageType) {
        APIlib.getInstance().addJSLine(String.format(Locale.US, this.jsBase + ".maType(%s);", movingAverageType != null ? movingAverageType.getJsBase() : null));
        return this;
    }

    public TRIX maType(String str) {
        APIlib.getInstance().addJSLine(String.format(Locale.US, this.jsBase + ".maType(%s);", wrapQuotes(str)));
        return this;
    }

    public void period() {
        APIlib.getInstance().addJSLine(this.jsBase + ".period();");
    }

    public TRIX period(Number number) {
        APIlib.getInstance().addJSLine(String.format(Locale.US, this.jsBase + ".period(%s);", number));
        return this;
    }

    public void signalMaType() {
        APIlib.getInstance().addJSLine(this.jsBase + ".signalMaType();");
    }

    public TRIX signalMaType(String str) {
        APIlib.getInstance().addJSLine(String.format(Locale.US, this.jsBase + ".signalMaType(%s);", wrapQuotes(str)));
        return this;
    }

    public TRIX signalMaType(MovingAverageType movingAverageType) {
        APIlib.getInstance().addJSLine(String.format(Locale.US, this.jsBase + ".signalMaType(%s);", movingAverageType != null ? movingAverageType.getJsBase() : null));
        return this;
    }

    public void signalPeriod() {
        APIlib.getInstance().addJSLine(this.jsBase + ".signalPeriod();");
    }

    public TRIX signalPeriod(Number number) {
        APIlib.getInstance().addJSLine(String.format(Locale.US, this.jsBase + ".signalPeriod(%s);", number));
        return this;
    }

    public com.anychart.core.stock.series.Base signalSeries() {
        return new com.anychart.core.stock.series.Base(this.jsBase + ".signalSeries()");
    }

    public TRIX signalSeries(StockSeriesType stockSeriesType) {
        APIlib.getInstance().addJSLine(String.format(Locale.US, this.jsBase + ".signalSeries(%s);", stockSeriesType != null ? stockSeriesType.getJsBase() : null));
        return this;
    }

    public TRIX signalSeries(String str) {
        APIlib.getInstance().addJSLine(String.format(Locale.US, this.jsBase + ".signalSeries(%s);", wrapQuotes(str)));
        return this;
    }

    public com.anychart.core.stock.series.Base trixSeries() {
        return new com.anychart.core.stock.series.Base(this.jsBase + ".trixSeries()");
    }

    public TRIX trixSeries(StockSeriesType stockSeriesType) {
        APIlib.getInstance().addJSLine(String.format(Locale.US, this.jsBase + ".trixSeries(%s);", stockSeriesType != null ? stockSeriesType.getJsBase() : null));
        return this;
    }

    public TRIX trixSeries(String str) {
        APIlib.getInstance().addJSLine(String.format(Locale.US, this.jsBase + ".trixSeries(%s);", wrapQuotes(str)));
        return this;
    }
}
