package com.anychart.core.stock.indicators;

import com.anychart.APIlib;
import com.anychart.JsObject;
import com.anychart.enums.StockSeriesType;
import java.util.Locale;

/* JADX INFO: loaded from: classes5.dex */
public class Momentum extends JsObject {
    protected Momentum() {
    }

    public static Momentum instantiate() {
        return new Momentum("new anychart.core.stock.indicators.momentum()");
    }

    public Momentum(String str) {
        StringBuilder sb = new StringBuilder("momentum");
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

    public MFI period(Number number) {
        return new MFI(String.format(Locale.US, this.jsBase + ".period(%s)", number));
    }

    public com.anychart.core.stock.series.Base series() {
        return new com.anychart.core.stock.series.Base(this.jsBase + ".series()");
    }

    public MFI series(StockSeriesType stockSeriesType) {
        return new MFI(String.format(Locale.US, this.jsBase + ".series(%s)", stockSeriesType != null ? stockSeriesType.getJsBase() : null));
    }

    public MFI series(String str) {
        return new MFI(String.format(Locale.US, this.jsBase + ".series(%s)", wrapQuotes(str)));
    }
}
