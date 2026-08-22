package com.anychart.format;

import com.anychart.APIlib;
import com.anychart.JsObject;
import java.util.Locale;

/* JADX INFO: loaded from: classes5.dex */
public class Context extends JsObject {
    protected Context() {
    }

    public static Context instantiate() {
        return new Context("new anychart.format.context()");
    }

    public Context(String str) {
        StringBuilder sb = new StringBuilder("context");
        int i = variableIndex + 1;
        variableIndex = i;
        this.jsBase = sb.append(i).toString();
        APIlib.getInstance().addJSLine(this.jsBase + " = " + str + ";");
    }

    @Override // com.anychart.JsObject
    public String getJsBase() {
        return this.jsBase;
    }

    public void getData(String str) {
        APIlib.getInstance().addJSLine(String.format(Locale.US, this.jsBase + ".getData(%s);", wrapQuotes(str)));
    }

    public void getMeta(String str) {
        APIlib.getInstance().addJSLine(String.format(Locale.US, this.jsBase + ".getMeta(%s);", wrapQuotes(str)));
    }

    public void getStat(String str) {
        APIlib.getInstance().addJSLine(String.format(Locale.US, this.jsBase + ".getStat(%s);", wrapQuotes(str)));
    }
}
