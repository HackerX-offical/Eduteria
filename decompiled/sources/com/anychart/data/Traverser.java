package com.anychart.data;

import com.anychart.APIlib;
import com.anychart.JsObject;
import com.anychart.data.tree.DataItem;
import java.util.Locale;

/* JADX INFO: loaded from: classes5.dex */
public class Traverser extends JsObject {
    protected Traverser() {
    }

    public static Traverser instantiate() {
        return new Traverser("new anychart.data.traverser()");
    }

    public Traverser(String str) {
        StringBuilder sb = new StringBuilder("traverser");
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

    public DataItem current() {
        return new DataItem(this.jsBase + ".current()");
    }

    public void get(String str) {
        APIlib.getInstance().addJSLine(String.format(Locale.US, this.jsBase + ".get(%s);", wrapQuotes(str)));
    }

    public void getDepth() {
        APIlib.getInstance().addJSLine(this.jsBase + ".getDepth();");
    }

    public void meta(String str) {
        APIlib.getInstance().addJSLine(String.format(Locale.US, this.jsBase + ".meta(%s);", wrapQuotes(str)));
    }

    public void meta(String str, String str2) {
        APIlib.getInstance().addJSLine(String.format(Locale.US, this.jsBase + ".meta(%s, %s);", wrapQuotes(str), wrapQuotes(str2)));
    }

    public void nodeYieldCondition() {
        APIlib.getInstance().addJSLine(this.jsBase + ".nodeYieldCondition();");
    }

    public Traverser reset() {
        APIlib.getInstance().addJSLine(this.jsBase + ".reset();");
        return this;
    }

    public Traverser set(String str, String str2) {
        APIlib.getInstance().addJSLine(String.format(Locale.US, this.jsBase + ".set(%s, %s);", wrapQuotes(str), wrapQuotes(str2)));
        return this;
    }

    public void toArray() {
        APIlib.getInstance().addJSLine(this.jsBase + ".toArray();");
    }

    public void traverseChildrenCondition() {
        APIlib.getInstance().addJSLine(this.jsBase + ".traverseChildrenCondition();");
    }
}
