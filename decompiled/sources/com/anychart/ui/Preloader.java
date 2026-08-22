package com.anychart.ui;

import com.anychart.APIlib;
import com.anychart.JsObject;
import java.util.Locale;

/* JADX INFO: loaded from: classes6.dex */
public class Preloader extends JsObject {
    protected Preloader() {
    }

    public static Preloader instantiate() {
        return new Preloader("new anychart.ui.preloader()");
    }

    public Preloader(String str) {
        StringBuilder sb = new StringBuilder("preloader");
        int i = variableIndex + 1;
        variableIndex = i;
        this.jsBase = sb.append(i).toString();
        APIlib.getInstance().addJSLine(this.jsBase + " = " + str + ";");
    }

    @Override // com.anychart.JsObject
    public String getJsBase() {
        return this.jsBase;
    }

    public void visible() {
        APIlib.getInstance().addJSLine(this.jsBase + ".visible();");
    }

    public Preloader visible(Boolean bool) {
        APIlib.getInstance().addJSLine(String.format(Locale.US, this.jsBase + ".visible(%s);", bool));
        return this;
    }
}
