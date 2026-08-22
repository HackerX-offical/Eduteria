package com.anychart.core.stock.indicators;

import com.anychart.APIlib;
import com.anychart.JsObject;
import com.anychart.enums.StockSeriesType;
import java.util.Locale;

/* JADX INFO: loaded from: classes5.dex */
public class PSAR extends JsObject {
    protected PSAR() {
    }

    public static PSAR instantiate() {
        return new PSAR("new anychart.core.stock.indicators.pSAR()");
    }

    public PSAR(String str) {
        StringBuilder sb = new StringBuilder("pSAR");
        int i = variableIndex + 1;
        variableIndex = i;
        this.jsBase = sb.append(i).toString();
        APIlib.getInstance().addJSLine(this.jsBase + " = " + str + ";");
    }

    @Override // com.anychart.JsObject
    public String getJsBase() {
        return this.jsBase;
    }

    public void accelerationFactorIncrement() {
        APIlib.getInstance().addJSLine(this.jsBase + ".accelerationFactorIncrement();");
    }

    public PSAR accelerationFactorIncrement(Number number) {
        APIlib.getInstance().addJSLine(String.format(Locale.US, this.jsBase + ".accelerationFactorIncrement(%s);", number));
        return this;
    }

    public void accelerationFactorMaximum() {
        APIlib.getInstance().addJSLine(this.jsBase + ".accelerationFactorMaximum();");
    }

    public PSAR accelerationFactorMaximum(Number number) {
        APIlib.getInstance().addJSLine(String.format(Locale.US, this.jsBase + ".accelerationFactorMaximum(%s);", number));
        return this;
    }

    public void accelerationFactorStart() {
        APIlib.getInstance().addJSLine(this.jsBase + ".accelerationFactorStart();");
    }

    public PSAR accelerationFactorStart(Number number) {
        APIlib.getInstance().addJSLine(String.format(Locale.US, this.jsBase + ".accelerationFactorStart(%s);", number));
        return this;
    }

    public com.anychart.core.stock.series.Base series() {
        return new com.anychart.core.stock.series.Base(this.jsBase + ".series()");
    }

    public PSAR series(StockSeriesType stockSeriesType) {
        APIlib.getInstance().addJSLine(String.format(Locale.US, this.jsBase + ".series(%s);", stockSeriesType != null ? stockSeriesType.getJsBase() : null));
        return this;
    }

    public PSAR series(String str) {
        APIlib.getInstance().addJSLine(String.format(Locale.US, this.jsBase + ".series(%s);", wrapQuotes(str)));
        return this;
    }
}
