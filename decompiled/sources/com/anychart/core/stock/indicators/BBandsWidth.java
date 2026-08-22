package com.anychart.core.stock.indicators;

import com.anychart.APIlib;
import com.anychart.JsObject;
import com.anychart.enums.StockSeriesType;
import java.util.Locale;

/* JADX INFO: loaded from: classes5.dex */
public class BBandsWidth extends JsObject {
    protected BBandsWidth() {
    }

    public static BBandsWidth instantiate() {
        return new BBandsWidth("new anychart.core.stock.indicators.bBandsWidth()");
    }

    public BBandsWidth(String str) {
        StringBuilder sb = new StringBuilder("bBandsWidth");
        int i = variableIndex + 1;
        variableIndex = i;
        this.jsBase = sb.append(i).toString();
        APIlib.getInstance().addJSLine(this.jsBase + " = " + str + ";");
    }

    @Override // com.anychart.JsObject
    public String getJsBase() {
        return this.jsBase;
    }

    public void deviation() {
        APIlib.getInstance().addJSLine(this.jsBase + ".deviation();");
    }

    public BBandsWidth deviation(Number number) {
        APIlib.getInstance().addJSLine(String.format(Locale.US, this.jsBase + ".deviation(%s);", number));
        return this;
    }

    public void period() {
        APIlib.getInstance().addJSLine(this.jsBase + ".period();");
    }

    public BBandsWidth period(Number number) {
        APIlib.getInstance().addJSLine(String.format(Locale.US, this.jsBase + ".period(%s);", number));
        return this;
    }

    public com.anychart.core.stock.series.Base series() {
        return new com.anychart.core.stock.series.Base(this.jsBase + ".series()");
    }

    public BBandsWidth series(StockSeriesType stockSeriesType) {
        APIlib.getInstance().addJSLine(String.format(Locale.US, this.jsBase + ".series(%s);", stockSeriesType != null ? stockSeriesType.getJsBase() : null));
        return this;
    }

    public BBandsWidth series(String str) {
        APIlib.getInstance().addJSLine(String.format(Locale.US, this.jsBase + ".series(%s);", wrapQuotes(str)));
        return this;
    }
}
