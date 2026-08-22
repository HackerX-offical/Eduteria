package com.anychart.data;

import com.anychart.APIlib;
import com.anychart.JsObject;
import java.util.Locale;

/* JADX INFO: loaded from: classes5.dex */
public class TableComputer extends JsObject {
    protected TableComputer() {
    }

    public static TableComputer instantiate() {
        return new TableComputer("new anychart.data.tableComputer()");
    }

    public TableComputer(String str) {
        StringBuilder sb = new StringBuilder("tableComputer");
        int i = variableIndex + 1;
        variableIndex = i;
        this.jsBase = sb.append(i).toString();
        APIlib.getInstance().addJSLine(this.jsBase + " = " + str + ";");
    }

    @Override // com.anychart.JsObject
    public String getJsBase() {
        return this.jsBase;
    }

    public void addOutputField(String str, String str2) {
        APIlib.getInstance().addJSLine(String.format(Locale.US, this.jsBase + ".addOutputField(%s, %s);", wrapQuotes(str), wrapQuotes(str2)));
    }

    public void getFieldIndex(String str) {
        APIlib.getInstance().addJSLine(String.format(Locale.US, this.jsBase + ".getFieldIndex(%s);", wrapQuotes(str)));
    }

    public void setContext(String str) {
        APIlib.getInstance().addJSLine(String.format(Locale.US, this.jsBase + ".setContext(%s);", wrapQuotes(str)));
    }
}
