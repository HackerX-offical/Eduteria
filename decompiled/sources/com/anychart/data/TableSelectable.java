package com.anychart.data;

import com.anychart.APIlib;
import com.anychart.JsObject;
import com.anychart.data.tableselectable.RowProxy;
import com.anychart.enums.Interval;
import com.anychart.enums.TableSearchMode;
import java.util.Locale;

/* JADX INFO: loaded from: classes5.dex */
public class TableSelectable extends JsObject {
    protected TableSelectable() {
    }

    public static TableSelectable instantiate() {
        return new TableSelectable("new anychart.data.tableSelectable()");
    }

    public TableSelectable(String str) {
        StringBuilder sb = new StringBuilder("tableSelectable");
        int i = variableIndex + 1;
        variableIndex = i;
        this.jsBase = sb.append(i).toString();
        APIlib.getInstance().addJSLine(this.jsBase + " = " + str + ";");
    }

    @Override // com.anychart.JsObject
    public String getJsBase() {
        return this.jsBase;
    }

    public TableIterator getIterator() {
        return new TableIterator(this.jsBase + ".getIterator()");
    }

    public RowProxy search(Number number, TableSearchMode tableSearchMode) {
        return new RowProxy(String.format(Locale.US, this.jsBase + ".search(%s, %s)", number, tableSearchMode != null ? tableSearchMode.getJsBase() : null));
    }

    public RowProxy search(Number number, String str) {
        return new RowProxy(String.format(Locale.US, this.jsBase + ".search(%s, %s)", number, wrapQuotes(str)));
    }

    public RowProxy search(String str, TableSearchMode tableSearchMode) {
        return new RowProxy(String.format(Locale.US, this.jsBase + ".search(%s, %s)", wrapQuotes(str), tableSearchMode != null ? tableSearchMode.getJsBase() : null));
    }

    public RowProxy search(String str, String str2) {
        return new RowProxy(String.format(Locale.US, this.jsBase + ".search(%s, %s)", wrapQuotes(str), wrapQuotes(str2)));
    }

    public TableSelectable select(Number number, Number number2, Interval interval, Number number3) {
        APIlib.getInstance().addJSLine(String.format(Locale.US, this.jsBase + ".select(%s, %s, %s, %s);", number, number2, interval != null ? interval.getJsBase() : null, number3));
        return this;
    }

    public TableSelectable select(Number number, Number number2, String str, Number number3) {
        APIlib.getInstance().addJSLine(String.format(Locale.US, this.jsBase + ".select(%s, %s, %s, %s);", number, number2, wrapQuotes(str), number3));
        return this;
    }

    public TableSelectable select(Number number, String str, Interval interval, Number number2) {
        APIlib.getInstance().addJSLine(String.format(Locale.US, this.jsBase + ".select(%s, %s, %s, %s);", number, wrapQuotes(str), interval != null ? interval.getJsBase() : null, number2));
        return this;
    }

    public TableSelectable select(Number number, String str, String str2, Number number2) {
        APIlib.getInstance().addJSLine(String.format(Locale.US, this.jsBase + ".select(%s, %s, %s, %s);", number, wrapQuotes(str), wrapQuotes(str2), number2));
        return this;
    }

    public TableSelectable select(String str, Number number, Interval interval, Number number2) {
        APIlib.getInstance().addJSLine(String.format(Locale.US, this.jsBase + ".select(%s, %s, %s, %s);", wrapQuotes(str), number, interval != null ? interval.getJsBase() : null, number2));
        return this;
    }

    public TableSelectable select(String str, Number number, String str2, Number number2) {
        APIlib.getInstance().addJSLine(String.format(Locale.US, this.jsBase + ".select(%s, %s, %s, %s);", wrapQuotes(str), number, wrapQuotes(str2), number2));
        return this;
    }

    public TableSelectable select(String str, String str2, Interval interval, Number number) {
        APIlib.getInstance().addJSLine(String.format(Locale.US, this.jsBase + ".select(%s, %s, %s, %s);", wrapQuotes(str), wrapQuotes(str2), interval != null ? interval.getJsBase() : null, number));
        return this;
    }

    public TableSelectable select(String str, String str2, String str3, Number number) {
        APIlib.getInstance().addJSLine(String.format(Locale.US, this.jsBase + ".select(%s, %s, %s, %s);", wrapQuotes(str), wrapQuotes(str2), wrapQuotes(str3), number));
        return this;
    }

    public TableSelectable selectAll(Interval interval, Number number) {
        APIlib.getInstance().addJSLine(String.format(Locale.US, this.jsBase + ".selectAll(%s, %s);", interval != null ? interval.getJsBase() : null, number));
        return this;
    }

    public TableSelectable selectAll(String str, Number number) {
        APIlib.getInstance().addJSLine(String.format(Locale.US, this.jsBase + ".selectAll(%s, %s);", wrapQuotes(str), number));
        return this;
    }
}
