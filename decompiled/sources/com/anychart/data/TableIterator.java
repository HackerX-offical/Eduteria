package com.anychart.data;

import com.anychart.APIlib;
import com.anychart.JsObject;
import java.util.Locale;

/* JADX INFO: loaded from: classes5.dex */
public class TableIterator extends JsObject {
    protected TableIterator() {
    }

    public static TableIterator instantiate() {
        return new TableIterator("new anychart.data.tableIterator()");
    }

    public TableIterator(String str) {
        StringBuilder sb = new StringBuilder("tableIterator");
        int i = variableIndex + 1;
        variableIndex = i;
        this.jsBase = sb.append(i).toString();
        APIlib.getInstance().addJSLine(this.jsBase + " = " + str + ";");
    }

    @Override // com.anychart.JsObject
    public String getJsBase() {
        return this.jsBase;
    }

    public void advance() {
        APIlib.getInstance().addJSLine(this.jsBase + ".advance();");
    }

    public void get(String str) {
        APIlib.getInstance().addJSLine(String.format(Locale.US, this.jsBase + ".get(%s);", wrapQuotes(str)));
    }

    public void getIndex() {
        APIlib.getInstance().addJSLine(this.jsBase + ".getIndex();");
    }

    public void getKey() {
        APIlib.getInstance().addJSLine(this.jsBase + ".getKey();");
    }

    public void reset() {
        APIlib.getInstance().addJSLine(this.jsBase + ".reset();");
    }
}
