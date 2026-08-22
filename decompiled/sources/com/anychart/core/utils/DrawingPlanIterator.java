package com.anychart.core.utils;

import com.anychart.APIlib;
import com.anychart.data.Iterator;
import java.util.Locale;

/* JADX INFO: loaded from: classes5.dex */
public class DrawingPlanIterator extends Iterator {
    protected DrawingPlanIterator() {
    }

    public static DrawingPlanIterator instantiate() {
        return new DrawingPlanIterator("new anychart.core.utils.drawingPlanIterator()");
    }

    public DrawingPlanIterator(String str) {
        StringBuilder sb = new StringBuilder("drawingPlanIterator");
        int i = variableIndex + 1;
        variableIndex = i;
        this.jsBase = sb.append(i).toString();
        APIlib.getInstance().addJSLine(this.jsBase + " = " + str + ";");
    }

    @Override // com.anychart.data.Iterator, com.anychart.JsObject
    public String getJsBase() {
        return this.jsBase;
    }

    @Override // com.anychart.data.Iterator
    public void advance() {
        APIlib.getInstance().addJSLine(this.jsBase + ".advance();");
    }

    @Override // com.anychart.data.Iterator
    public void get(String str) {
        APIlib.getInstance().addJSLine(String.format(Locale.US, this.jsBase + ".get(%s);", wrapQuotes(str)));
    }

    @Override // com.anychart.data.Iterator
    public void getIndex() {
        APIlib.getInstance().addJSLine(this.jsBase + ".getIndex();");
    }

    @Override // com.anychart.data.Iterator
    public void getRowsCount() {
        APIlib.getInstance().addJSLine(this.jsBase + ".getRowsCount();");
    }

    @Override // com.anychart.data.Iterator
    public void meta(String str) {
        APIlib.getInstance().addJSLine(String.format(Locale.US, this.jsBase + ".meta(%s);", wrapQuotes(str)));
    }

    @Override // com.anychart.data.Iterator
    public DrawingPlanIterator meta(String str, String str2) {
        APIlib.getInstance().addJSLine(String.format(Locale.US, this.jsBase + ".meta(%s, %s);", wrapQuotes(str), wrapQuotes(str2)));
        return this;
    }

    @Override // com.anychart.data.Iterator
    public DrawingPlanIterator reset() {
        APIlib.getInstance().addJSLine(this.jsBase + ".reset();");
        return this;
    }

    @Override // com.anychart.data.Iterator
    public void select(Number number) {
        APIlib.getInstance().addJSLine(String.format(Locale.US, this.jsBase + ".select(%s);", number));
    }
}
