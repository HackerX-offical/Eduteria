package com.anychart.math;

import com.anychart.JsObject;
import java.util.Locale;

/* JADX INFO: loaded from: classes4.dex */
public class CoordinateObject extends JsObject {
    public CoordinateObject(String str, String str2) {
        this.js.append(String.format(Locale.US, "{x:%s, y: %s, } ", wrapQuotes(str), wrapQuotes(str2)));
    }

    public CoordinateObject(String str, Number number) {
        this.js.append(String.format(Locale.US, "{x:%s, y: %s, } ", wrapQuotes(str), number));
    }

    public CoordinateObject(Number number, String str) {
        this.js.append(String.format(Locale.US, "{x:%s, y: %s, } ", number, wrapQuotes(str)));
    }

    public CoordinateObject(Number number, Number number2) {
        this.js.append(String.format(Locale.US, "{x:%s, y: %s, } ", number, number2));
    }

    @Override // com.anychart.JsObject
    public String getJsBase() {
        return this.js.toString();
    }
}
