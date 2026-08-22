package com.anychart.data.tree;

import com.anychart.APIlib;
import com.anychart.JsObject;
import java.util.Locale;

/* JADX INFO: loaded from: classes5.dex */
public class DataItem extends JsObject {
    protected DataItem() {
    }

    public static DataItem instantiate() {
        return new DataItem("new anychart.data.Tree.dataItem()");
    }

    public DataItem(String str) {
        StringBuilder sb = new StringBuilder("dataItem");
        int i = variableIndex + 1;
        variableIndex = i;
        this.jsBase = sb.append(i).toString();
        APIlib.getInstance().addJSLine(this.jsBase + " = " + str + ";");
    }

    @Override // com.anychart.JsObject
    public String getJsBase() {
        return this.jsBase;
    }

    public DataItem addChild(String str) {
        APIlib.getInstance().addJSLine(String.format(Locale.US, this.jsBase + ".addChild(%s);", wrapQuotes(str)));
        return this;
    }

    public DataItem addChild(DataItem dataItem) {
        APIlib.getInstance().addJSLine(String.format(Locale.US, this.jsBase + ".addChild(%s);", dataItem != null ? dataItem.getJsBase() : null));
        return this;
    }

    public DataItem addChildAt(String str, Number number) {
        APIlib.getInstance().addJSLine(String.format(Locale.US, this.jsBase + ".addChildAt(%s, %s);", wrapQuotes(str), number));
        return this;
    }

    public DataItem addChildAt(DataItem dataItem, Number number) {
        APIlib.getInstance().addJSLine(String.format(Locale.US, this.jsBase + ".addChildAt(%s, %s);", dataItem != null ? dataItem.getJsBase() : null, number));
        return this;
    }

    public DataItem addChildAt(com.anychart.data.treeview.DataItem dataItem, Number number) {
        APIlib.getInstance().addJSLine(String.format(Locale.US, this.jsBase + ".addChildAt(%s, %s);", dataItem != null ? dataItem.getJsBase() : null, number));
        return this;
    }

    public DataItem del(String str) {
        APIlib.getInstance().addJSLine(String.format(Locale.US, this.jsBase + ".del(%s);", wrapQuotes(str)));
        return this;
    }

    public void get(String str) {
        APIlib.getInstance().addJSLine(String.format(Locale.US, this.jsBase + ".get(%s);", wrapQuotes(str)));
    }

    public DataItem getChildAt(Number number) {
        APIlib.getInstance().addJSLine(String.format(Locale.US, this.jsBase + ".getChildAt(%s);", number));
        return this;
    }

    public void getChildren() {
        APIlib.getInstance().addJSLine(this.jsBase + ".getChildren();");
    }

    public DataItem getParent() {
        APIlib.getInstance().addJSLine(this.jsBase + ".getParent();");
        return this;
    }

    public void indexOfChild(DataItem dataItem) {
        APIlib.getInstance().addJSLine(String.format(Locale.US, this.jsBase + ".indexOfChild(%s);", dataItem != null ? dataItem.getJsBase() : null));
    }

    public void indexOfChild(com.anychart.data.treeview.DataItem dataItem) {
        APIlib.getInstance().addJSLine(String.format(Locale.US, this.jsBase + ".indexOfChild(%s);", dataItem != null ? dataItem.getJsBase() : null));
    }

    public void meta(String str) {
        APIlib.getInstance().addJSLine(String.format(Locale.US, this.jsBase + ".meta(%s);", wrapQuotes(str)));
    }

    public void meta(String str, String str2) {
        APIlib.getInstance().addJSLine(String.format(Locale.US, this.jsBase + ".meta(%s, %s);", wrapQuotes(str), wrapQuotes(str2)));
    }

    public void numChildren() {
        APIlib.getInstance().addJSLine(this.jsBase + ".numChildren();");
    }

    public DataItem remove() {
        APIlib.getInstance().addJSLine(this.jsBase + ".remove();");
        return this;
    }

    public DataItem removeChild(DataItem dataItem) {
        APIlib.getInstance().addJSLine(String.format(Locale.US, this.jsBase + ".removeChild(%s);", dataItem != null ? dataItem.getJsBase() : null));
        return this;
    }

    public DataItem removeChildAt(Number number) {
        APIlib.getInstance().addJSLine(String.format(Locale.US, this.jsBase + ".removeChildAt(%s);", number));
        return this;
    }

    public DataItem removeChildren() {
        APIlib.getInstance().addJSLine(this.jsBase + ".removeChildren();");
        return this;
    }

    public DataItem set(String str) {
        APIlib.getInstance().addJSLine(String.format(Locale.US, this.jsBase + ".set(%s);", wrapQuotes(str)));
        return this;
    }
}
