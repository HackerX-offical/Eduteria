package com.anychart.core.utils;

import com.anychart.APIlib;
import com.anychart.JsObject;
import com.anychart.scales.Base;
import java.util.Locale;

/* JADX INFO: loaded from: classes5.dex */
public class OrdinalZoom extends JsObject {
    protected OrdinalZoom() {
    }

    public static OrdinalZoom instantiate() {
        return new OrdinalZoom("new anychart.core.utils.ordinalZoom()");
    }

    public OrdinalZoom(String str) {
        StringBuilder sb = new StringBuilder("ordinalZoom");
        int i = variableIndex + 1;
        variableIndex = i;
        this.jsBase = sb.append(i).toString();
        APIlib.getInstance().addJSLine(this.jsBase + " = " + str + ";");
    }

    @Override // com.anychart.JsObject
    public String getJsBase() {
        return this.jsBase;
    }

    public void continuous() {
        APIlib.getInstance().addJSLine(this.jsBase + ".continuous();");
    }

    public OrdinalZoom continuous(Boolean bool) {
        APIlib.getInstance().addJSLine(String.format(Locale.US, this.jsBase + ".continuous(%s);", bool));
        return this;
    }

    public void getEndRatio() {
        APIlib.getInstance().addJSLine(this.jsBase + ".getEndRatio();");
    }

    public void getStartRatio() {
        APIlib.getInstance().addJSLine(this.jsBase + ".getStartRatio();");
    }

    public OrdinalZoom setTo(Number number, Number number2) {
        APIlib.getInstance().addJSLine(String.format(Locale.US, this.jsBase + ".setTo(%s, %s);", number, number2));
        return this;
    }

    public OrdinalZoom setToPointsCount(Number number, Boolean bool, Base base) {
        APIlib.getInstance().addJSLine(String.format(Locale.US, this.jsBase + ".setToPointsCount(%s, %s, %s);", number, bool, base != null ? base.getJsBase() : null));
        return this;
    }

    public OrdinalZoom setToValues(String str, String str2, Base base) {
        APIlib.getInstance().addJSLine(String.format(Locale.US, this.jsBase + ".setToValues(%s, %s, %s);", wrapQuotes(str), wrapQuotes(str2), base != null ? base.getJsBase() : null));
        return this;
    }
}
