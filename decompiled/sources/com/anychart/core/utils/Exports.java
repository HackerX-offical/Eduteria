package com.anychart.core.utils;

import com.anychart.APIlib;
import com.anychart.JsObject;
import java.util.Locale;

/* JADX INFO: loaded from: classes5.dex */
public class Exports extends JsObject {
    protected Exports() {
    }

    public static Exports instantiate() {
        return new Exports("new anychart.core.utils.exports()");
    }

    public Exports(String str) {
        StringBuilder sb = new StringBuilder("exports");
        int i = variableIndex + 1;
        variableIndex = i;
        this.jsBase = sb.append(i).toString();
        APIlib.getInstance().addJSLine(this.jsBase + " = " + str + ";");
    }

    @Override // com.anychart.JsObject
    public String getJsBase() {
        return this.jsBase;
    }

    public void facebook() {
        APIlib.getInstance().addJSLine(this.jsBase + ".facebook();");
    }

    public void facebook(String str, String str2, String str3, String str4, String str5, String str6, String str7) {
        APIlib.getInstance().addJSLine(String.format(Locale.US, this.jsBase + ".facebook(%s, %s, %s, %s, %s, %s, %s);", wrapQuotes(str), wrapQuotes(str2), wrapQuotes(str3), wrapQuotes(str4), wrapQuotes(str5), wrapQuotes(str6), wrapQuotes(str7)));
    }

    public void filename(String str) {
        APIlib.getInstance().addJSLine(String.format(Locale.US, this.jsBase + ".filename(%s);", wrapQuotes(str)));
    }

    public void image() {
        APIlib.getInstance().addJSLine(this.jsBase + ".image();");
    }

    public void image(String str, String str2) {
        APIlib.getInstance().addJSLine(String.format(Locale.US, this.jsBase + ".image(%s, %s);", wrapQuotes(str), wrapQuotes(str2)));
    }

    public void linkedin() {
        APIlib.getInstance().addJSLine(this.jsBase + ".linkedin();");
    }

    public void linkedin(String str, String str2, String str3, String str4) {
        APIlib.getInstance().addJSLine(String.format(Locale.US, this.jsBase + ".linkedin(%s, %s, %s, %s);", wrapQuotes(str), wrapQuotes(str2), wrapQuotes(str3), wrapQuotes(str4)));
    }

    public void pinterest() {
        APIlib.getInstance().addJSLine(this.jsBase + ".pinterest();");
    }

    public void pinterest(String str, String str2, String str3, String str4) {
        APIlib.getInstance().addJSLine(String.format(Locale.US, this.jsBase + ".pinterest(%s, %s, %s, %s);", wrapQuotes(str), wrapQuotes(str2), wrapQuotes(str3), wrapQuotes(str4)));
    }

    public void twitter() {
        APIlib.getInstance().addJSLine(this.jsBase + ".twitter();");
    }

    public void twitter(String str, String str2, String str3) {
        APIlib.getInstance().addJSLine(String.format(Locale.US, this.jsBase + ".twitter(%s, %s, %s);", wrapQuotes(str), wrapQuotes(str2), wrapQuotes(str3)));
    }
}
