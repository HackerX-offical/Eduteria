package com.anychart.ui;

import com.anychart.APIlib;
import com.anychart.JsObject;
import com.anychart.charts.Stock;
import java.util.Locale;

/* JADX INFO: loaded from: classes6.dex */
public class RangePicker extends JsObject {
    protected RangePicker() {
    }

    public static RangePicker instantiate() {
        return new RangePicker("new anychart.ui.rangePicker()");
    }

    public RangePicker(String str) {
        StringBuilder sb = new StringBuilder("rangePicker");
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

    public void format() {
        APIlib.getInstance().addJSLine(this.jsBase + ".format();");
    }

    public void format(String str) {
        APIlib.getInstance().addJSLine(String.format(Locale.US, this.jsBase + ".format(%s);", wrapQuotes(str)));
    }

    public void fromLabelText() {
        APIlib.getInstance().addJSLine(this.jsBase + ".fromLabelText();");
    }

    public RangePicker fromLabelText(String str) {
        APIlib.getInstance().addJSLine(String.format(Locale.US, this.jsBase + ".fromLabelText(%s);", wrapQuotes(str)));
        return this;
    }

    public void getElement() {
        APIlib.getInstance().addJSLine(this.jsBase + ".getElement();");
    }

    public void render(Stock stock) {
        APIlib.getInstance().addJSLine(String.format(Locale.US, this.jsBase + ".render(%s);", stock != null ? stock.getJsBase() : null));
    }

    public void target(Stock stock) {
        APIlib.getInstance().addJSLine(String.format(Locale.US, this.jsBase + ".target(%s);", stock != null ? stock.getJsBase() : null));
    }

    public void toLabelText() {
        APIlib.getInstance().addJSLine(this.jsBase + ".toLabelText();");
    }

    public RangePicker toLabelText(String str) {
        APIlib.getInstance().addJSLine(String.format(Locale.US, this.jsBase + ".toLabelText(%s);", wrapQuotes(str)));
        return this;
    }
}
