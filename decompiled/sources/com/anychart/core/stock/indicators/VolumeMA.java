package com.anychart.core.stock.indicators;

import com.anychart.APIlib;
import com.anychart.JsObject;
import com.anychart.enums.MovingAverageType;
import com.anychart.enums.StockSeriesType;
import java.util.Locale;

/* JADX INFO: loaded from: classes5.dex */
public class VolumeMA extends JsObject {
    protected VolumeMA() {
    }

    public static VolumeMA instantiate() {
        return new VolumeMA("new anychart.core.stock.indicators.volumeMA()");
    }

    public VolumeMA(String str) {
        StringBuilder sb = new StringBuilder("volumeMA");
        int i = variableIndex + 1;
        variableIndex = i;
        this.jsBase = sb.append(i).toString();
        APIlib.getInstance().addJSLine(this.jsBase + " = " + str + ";");
    }

    @Override // com.anychart.JsObject
    public String getJsBase() {
        return this.jsBase;
    }

    public void maPeriod() {
        APIlib.getInstance().addJSLine(this.jsBase + ".maPeriod();");
    }

    public VolumeMA maPeriod(Number number) {
        APIlib.getInstance().addJSLine(String.format(Locale.US, this.jsBase + ".maPeriod(%s);", number));
        return this;
    }

    public com.anychart.core.stock.series.Base maSeries() {
        return new com.anychart.core.stock.series.Base(this.jsBase + ".maSeries()");
    }

    public Base maSeries(StockSeriesType stockSeriesType) {
        return new Base(String.format(Locale.US, this.jsBase + ".maSeries(%s)", stockSeriesType != null ? stockSeriesType.getJsBase() : null));
    }

    public Base maSeries(String str) {
        return new Base(String.format(Locale.US, this.jsBase + ".maSeries(%s)", wrapQuotes(str)));
    }

    public void maType() {
        APIlib.getInstance().addJSLine(this.jsBase + ".maType();");
    }

    public VolumeMA maType(MovingAverageType movingAverageType) {
        APIlib.getInstance().addJSLine(String.format(Locale.US, this.jsBase + ".maType(%s);", movingAverageType != null ? movingAverageType.getJsBase() : null));
        return this;
    }

    public VolumeMA maType(String str) {
        APIlib.getInstance().addJSLine(String.format(Locale.US, this.jsBase + ".maType(%s);", wrapQuotes(str)));
        return this;
    }

    public com.anychart.core.stock.series.Base volumeSeries() {
        return new com.anychart.core.stock.series.Base(this.jsBase + ".volumeSeries()");
    }

    public VolumeMA volumeSeries(StockSeriesType stockSeriesType) {
        APIlib.getInstance().addJSLine(String.format(Locale.US, this.jsBase + ".volumeSeries(%s);", stockSeriesType != null ? stockSeriesType.getJsBase() : null));
        return this;
    }

    public VolumeMA volumeSeries(String str) {
        APIlib.getInstance().addJSLine(String.format(Locale.US, this.jsBase + ".volumeSeries(%s);", wrapQuotes(str)));
        return this;
    }
}
