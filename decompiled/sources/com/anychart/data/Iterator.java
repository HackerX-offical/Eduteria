package com.anychart.data;

import com.anychart.APIlib;
import com.anychart.JsObject;
import java.util.Locale;

/* JADX INFO: loaded from: classes5.dex */
public class Iterator extends JsObject {
    protected Iterator() {
    }

    public static Iterator instantiate() {
        return new Iterator("new anychart.data.iterator()");
    }

    public Iterator(String str) {
        StringBuilder sb = new StringBuilder("iterator");
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

    public void getRowsCount() {
        APIlib.getInstance().addJSLine(this.jsBase + ".getRowsCount();");
    }

    public void meta(String str) {
        APIlib.getInstance().addJSLine(String.format(Locale.US, this.jsBase + ".meta(%s);", wrapQuotes(str)));
    }

    public Iterator meta(String str, String str2) {
        APIlib.getInstance().addJSLine(String.format(Locale.US, this.jsBase + ".meta(%s, %s);", wrapQuotes(str), wrapQuotes(str2)));
        return this;
    }

    public Iterator reset() {
        APIlib.getInstance().addJSLine(this.jsBase + ".reset();");
        return this;
    }

    public void select(Number number) {
        APIlib.getInstance().addJSLine(String.format(Locale.US, this.jsBase + ".select(%s);", number));
    }
}
