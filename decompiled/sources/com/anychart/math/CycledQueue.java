package com.anychart.math;

import com.anychart.APIlib;
import com.anychart.JsObject;
import java.util.Locale;

/* JADX INFO: loaded from: classes4.dex */
public class CycledQueue extends JsObject {
    protected CycledQueue() {
    }

    public static CycledQueue instantiate() {
        return new CycledQueue("new anychart.math.cycledQueue()");
    }

    public CycledQueue(String str) {
        StringBuilder sb = new StringBuilder("cycledQueue");
        int i = variableIndex + 1;
        variableIndex = i;
        this.jsBase = sb.append(i).toString();
        APIlib.getInstance().addJSLine(this.jsBase + " = " + str + ";");
    }

    @Override // com.anychart.JsObject
    public String getJsBase() {
        return this.jsBase;
    }

    public void clear(Number number) {
        APIlib.getInstance().addJSLine(String.format(Locale.US, this.jsBase + ".clear(%s);", number));
    }

    public void dequeue() {
        APIlib.getInstance().addJSLine(this.jsBase + ".dequeue();");
    }

    public void enqueue(String str) {
        APIlib.getInstance().addJSLine(String.format(Locale.US, this.jsBase + ".enqueue(%s);", wrapQuotes(str)));
    }

    public void get(Number number) {
        APIlib.getInstance().addJSLine(String.format(Locale.US, this.jsBase + ".get(%s);", number));
    }

    public void getLength() {
        APIlib.getInstance().addJSLine(this.jsBase + ".getLength();");
    }
}
