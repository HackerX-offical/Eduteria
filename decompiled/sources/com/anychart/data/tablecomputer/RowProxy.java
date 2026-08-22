package com.anychart.data.tablecomputer;

import com.anychart.APIlib;
import com.anychart.JsObject;
import java.util.Locale;

/* JADX INFO: loaded from: classes5.dex */
public class RowProxy extends JsObject {
    protected RowProxy() {
    }

    public static RowProxy instantiate() {
        return new RowProxy("new anychart.data.TableComputer.rowProxy()");
    }

    public RowProxy(String str) {
        StringBuilder sb = new StringBuilder("rowProxy");
        int i = variableIndex + 1;
        variableIndex = i;
        this.jsBase = sb.append(i).toString();
        APIlib.getInstance().addJSLine(this.jsBase + " = " + str + ";");
    }

    @Override // com.anychart.JsObject
    public String getJsBase() {
        return this.jsBase;
    }

    public void get(String str) {
        APIlib.getInstance().addJSLine(String.format(Locale.US, this.jsBase + ".get(%s);", wrapQuotes(str)));
    }

    public void getColumn(Number number) {
        APIlib.getInstance().addJSLine(String.format(Locale.US, this.jsBase + ".getColumn(%s);", number));
    }

    public void getIndex() {
        APIlib.getInstance().addJSLine(this.jsBase + ".getIndex();");
    }

    public void getKey() {
        APIlib.getInstance().addJSLine(this.jsBase + ".getKey();");
    }

    public void set(String str, String str2) {
        APIlib.getInstance().addJSLine(String.format(Locale.US, this.jsBase + ".set(%s, %s);", wrapQuotes(str), wrapQuotes(str2)));
    }

    public void setColumn(Number number, String str) {
        APIlib.getInstance().addJSLine(String.format(Locale.US, this.jsBase + ".setColumn(%s, %s);", number, wrapQuotes(str)));
    }
}
