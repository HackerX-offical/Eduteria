package com.anychart.ui;

import com.anychart.APIlib;
import com.anychart.JsObject;
import com.anychart.charts.Stock;
import com.anychart.ui.rangeselector.Range;
import java.util.Locale;

/* JADX INFO: loaded from: classes6.dex */
public class RangeSelector extends JsObject {
    protected RangeSelector() {
    }

    public static RangeSelector instantiate() {
        return new RangeSelector("new anychart.ui.rangeSelector()");
    }

    public RangeSelector(String str) {
        StringBuilder sb = new StringBuilder("rangeSelector");
        int i = variableIndex + 1;
        variableIndex = i;
        this.jsBase = sb.append(i).toString();
        APIlib.getInstance().addJSLine(this.jsBase + " = " + str + ";");
    }

    @Override // com.anychart.JsObject
    public String getJsBase() {
        return this.jsBase;
    }

    public void dispose() {
        APIlib.getInstance().addJSLine(this.jsBase + ".dispose();");
    }

    public void getElement() {
        APIlib.getInstance().addJSLine(this.jsBase + ".getElement();");
    }

    public void ranges() {
        APIlib.getInstance().addJSLine(this.jsBase + ".ranges();");
    }

    public void ranges(Range[] rangeArr) {
        APIlib.getInstance().addJSLine(String.format(Locale.US, this.jsBase + ".ranges(%s);", arrayToString((JsObject[]) rangeArr)));
    }

    public void render(Stock stock) {
        APIlib.getInstance().addJSLine(String.format(Locale.US, this.jsBase + ".render(%s);", stock != null ? stock.getJsBase() : null));
    }

    public void target(Stock stock) {
        APIlib.getInstance().addJSLine(String.format(Locale.US, this.jsBase + ".target(%s);", stock != null ? stock.getJsBase() : null));
    }

    public void zoomLabelText() {
        APIlib.getInstance().addJSLine(this.jsBase + ".zoomLabelText();");
    }

    public RangeSelector zoomLabelText(String str) {
        APIlib.getInstance().addJSLine(String.format(Locale.US, this.jsBase + ".zoomLabelText(%s);", wrapQuotes(str)));
        return this;
    }
}
