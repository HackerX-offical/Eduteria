package com.anychart.utils;

import com.anychart.JsObject;
import java.util.Locale;

/* JADX INFO: loaded from: classes6.dex */
public class RectObj extends JsObject {
    public RectObj(Number number, Number number2, Number number3, Number number4, Number number5, Number number6) {
        this.js.append(String.format(Locale.US, "{bottom:%s, height: %s, left: %s, right: %s, top: %s, width: %s, } ", number, number2, number3, number4, number5, number6));
    }

    public RectObj(Number number, Number number2, Number number3, Number number4, Number number5, String str) {
        this.js.append(String.format(Locale.US, "{bottom:%s, height: %s, left: %s, right: %s, top: %s, width: %s, } ", number, number2, number3, number4, number5, wrapQuotes(str)));
    }

    public RectObj(Number number, Number number2, Number number3, Number number4, String str, Number number5) {
        this.js.append(String.format(Locale.US, "{bottom:%s, height: %s, left: %s, right: %s, top: %s, width: %s, } ", number, number2, number3, number4, wrapQuotes(str), number5));
    }

    public RectObj(Number number, Number number2, Number number3, Number number4, String str, String str2) {
        this.js.append(String.format(Locale.US, "{bottom:%s, height: %s, left: %s, right: %s, top: %s, width: %s, } ", number, number2, number3, number4, wrapQuotes(str), wrapQuotes(str2)));
    }

    public RectObj(Number number, Number number2, Number number3, String str, Number number4, Number number5) {
        this.js.append(String.format(Locale.US, "{bottom:%s, height: %s, left: %s, right: %s, top: %s, width: %s, } ", number, number2, number3, wrapQuotes(str), number4, number5));
    }

    public RectObj(Number number, Number number2, Number number3, String str, Number number4, String str2) {
        this.js.append(String.format(Locale.US, "{bottom:%s, height: %s, left: %s, right: %s, top: %s, width: %s, } ", number, number2, number3, wrapQuotes(str), number4, wrapQuotes(str2)));
    }

    public RectObj(Number number, Number number2, Number number3, String str, String str2, Number number4) {
        this.js.append(String.format(Locale.US, "{bottom:%s, height: %s, left: %s, right: %s, top: %s, width: %s, } ", number, number2, number3, wrapQuotes(str), wrapQuotes(str2), number4));
    }

    public RectObj(Number number, Number number2, Number number3, String str, String str2, String str3) {
        this.js.append(String.format(Locale.US, "{bottom:%s, height: %s, left: %s, right: %s, top: %s, width: %s, } ", number, number2, number3, wrapQuotes(str), wrapQuotes(str2), wrapQuotes(str3)));
    }

    public RectObj(Number number, Number number2, String str, Number number3, Number number4, Number number5) {
        this.js.append(String.format(Locale.US, "{bottom:%s, height: %s, left: %s, right: %s, top: %s, width: %s, } ", number, number2, wrapQuotes(str), number3, number4, number5));
    }

    public RectObj(Number number, Number number2, String str, Number number3, Number number4, String str2) {
        this.js.append(String.format(Locale.US, "{bottom:%s, height: %s, left: %s, right: %s, top: %s, width: %s, } ", number, number2, wrapQuotes(str), number3, number4, wrapQuotes(str2)));
    }

    public RectObj(Number number, Number number2, String str, Number number3, String str2, Number number4) {
        this.js.append(String.format(Locale.US, "{bottom:%s, height: %s, left: %s, right: %s, top: %s, width: %s, } ", number, number2, wrapQuotes(str), number3, wrapQuotes(str2), number4));
    }

    public RectObj(Number number, Number number2, String str, Number number3, String str2, String str3) {
        this.js.append(String.format(Locale.US, "{bottom:%s, height: %s, left: %s, right: %s, top: %s, width: %s, } ", number, number2, wrapQuotes(str), number3, wrapQuotes(str2), wrapQuotes(str3)));
    }

    public RectObj(Number number, Number number2, String str, String str2, Number number3, Number number4) {
        this.js.append(String.format(Locale.US, "{bottom:%s, height: %s, left: %s, right: %s, top: %s, width: %s, } ", number, number2, wrapQuotes(str), wrapQuotes(str2), number3, number4));
    }

    public RectObj(Number number, Number number2, String str, String str2, Number number3, String str3) {
        this.js.append(String.format(Locale.US, "{bottom:%s, height: %s, left: %s, right: %s, top: %s, width: %s, } ", number, number2, wrapQuotes(str), wrapQuotes(str2), number3, wrapQuotes(str3)));
    }

    public RectObj(Number number, Number number2, String str, String str2, String str3, Number number3) {
        this.js.append(String.format(Locale.US, "{bottom:%s, height: %s, left: %s, right: %s, top: %s, width: %s, } ", number, number2, wrapQuotes(str), wrapQuotes(str2), wrapQuotes(str3), number3));
    }

    public RectObj(Number number, Number number2, String str, String str2, String str3, String str4) {
        this.js.append(String.format(Locale.US, "{bottom:%s, height: %s, left: %s, right: %s, top: %s, width: %s, } ", number, number2, wrapQuotes(str), wrapQuotes(str2), wrapQuotes(str3), wrapQuotes(str4)));
    }

    public RectObj(Number number, String str, Number number2, Number number3, Number number4, Number number5) {
        this.js.append(String.format(Locale.US, "{bottom:%s, height: %s, left: %s, right: %s, top: %s, width: %s, } ", number, wrapQuotes(str), number2, number3, number4, number5));
    }

    public RectObj(Number number, String str, Number number2, Number number3, Number number4, String str2) {
        this.js.append(String.format(Locale.US, "{bottom:%s, height: %s, left: %s, right: %s, top: %s, width: %s, } ", number, wrapQuotes(str), number2, number3, number4, wrapQuotes(str2)));
    }

    public RectObj(Number number, String str, Number number2, Number number3, String str2, Number number4) {
        this.js.append(String.format(Locale.US, "{bottom:%s, height: %s, left: %s, right: %s, top: %s, width: %s, } ", number, wrapQuotes(str), number2, number3, wrapQuotes(str2), number4));
    }

    public RectObj(Number number, String str, Number number2, Number number3, String str2, String str3) {
        this.js.append(String.format(Locale.US, "{bottom:%s, height: %s, left: %s, right: %s, top: %s, width: %s, } ", number, wrapQuotes(str), number2, number3, wrapQuotes(str2), wrapQuotes(str3)));
    }

    public RectObj(Number number, String str, Number number2, String str2, Number number3, Number number4) {
        this.js.append(String.format(Locale.US, "{bottom:%s, height: %s, left: %s, right: %s, top: %s, width: %s, } ", number, wrapQuotes(str), number2, wrapQuotes(str2), number3, number4));
    }

    public RectObj(Number number, String str, Number number2, String str2, Number number3, String str3) {
        this.js.append(String.format(Locale.US, "{bottom:%s, height: %s, left: %s, right: %s, top: %s, width: %s, } ", number, wrapQuotes(str), number2, wrapQuotes(str2), number3, wrapQuotes(str3)));
    }

    public RectObj(Number number, String str, Number number2, String str2, String str3, Number number3) {
        this.js.append(String.format(Locale.US, "{bottom:%s, height: %s, left: %s, right: %s, top: %s, width: %s, } ", number, wrapQuotes(str), number2, wrapQuotes(str2), wrapQuotes(str3), number3));
    }

    public RectObj(Number number, String str, Number number2, String str2, String str3, String str4) {
        this.js.append(String.format(Locale.US, "{bottom:%s, height: %s, left: %s, right: %s, top: %s, width: %s, } ", number, wrapQuotes(str), number2, wrapQuotes(str2), wrapQuotes(str3), wrapQuotes(str4)));
    }

    public RectObj(Number number, String str, String str2, Number number2, Number number3, Number number4) {
        this.js.append(String.format(Locale.US, "{bottom:%s, height: %s, left: %s, right: %s, top: %s, width: %s, } ", number, wrapQuotes(str), wrapQuotes(str2), number2, number3, number4));
    }

    public RectObj(Number number, String str, String str2, Number number2, Number number3, String str3) {
        this.js.append(String.format(Locale.US, "{bottom:%s, height: %s, left: %s, right: %s, top: %s, width: %s, } ", number, wrapQuotes(str), wrapQuotes(str2), number2, number3, wrapQuotes(str3)));
    }

    public RectObj(Number number, String str, String str2, Number number2, String str3, Number number3) {
        this.js.append(String.format(Locale.US, "{bottom:%s, height: %s, left: %s, right: %s, top: %s, width: %s, } ", number, wrapQuotes(str), wrapQuotes(str2), number2, wrapQuotes(str3), number3));
    }

    public RectObj(Number number, String str, String str2, Number number2, String str3, String str4) {
        this.js.append(String.format(Locale.US, "{bottom:%s, height: %s, left: %s, right: %s, top: %s, width: %s, } ", number, wrapQuotes(str), wrapQuotes(str2), number2, wrapQuotes(str3), wrapQuotes(str4)));
    }

    public RectObj(Number number, String str, String str2, String str3, Number number2, Number number3) {
        this.js.append(String.format(Locale.US, "{bottom:%s, height: %s, left: %s, right: %s, top: %s, width: %s, } ", number, wrapQuotes(str), wrapQuotes(str2), wrapQuotes(str3), number2, number3));
    }

    public RectObj(Number number, String str, String str2, String str3, Number number2, String str4) {
        this.js.append(String.format(Locale.US, "{bottom:%s, height: %s, left: %s, right: %s, top: %s, width: %s, } ", number, wrapQuotes(str), wrapQuotes(str2), wrapQuotes(str3), number2, wrapQuotes(str4)));
    }

    public RectObj(Number number, String str, String str2, String str3, String str4, Number number2) {
        this.js.append(String.format(Locale.US, "{bottom:%s, height: %s, left: %s, right: %s, top: %s, width: %s, } ", number, wrapQuotes(str), wrapQuotes(str2), wrapQuotes(str3), wrapQuotes(str4), number2));
    }

    public RectObj(Number number, String str, String str2, String str3, String str4, String str5) {
        this.js.append(String.format(Locale.US, "{bottom:%s, height: %s, left: %s, right: %s, top: %s, width: %s, } ", number, wrapQuotes(str), wrapQuotes(str2), wrapQuotes(str3), wrapQuotes(str4), wrapQuotes(str5)));
    }

    public RectObj(String str, Number number, Number number2, Number number3, Number number4, Number number5) {
        this.js.append(String.format(Locale.US, "{bottom:%s, height: %s, left: %s, right: %s, top: %s, width: %s, } ", wrapQuotes(str), number, number2, number3, number4, number5));
    }

    public RectObj(String str, Number number, Number number2, Number number3, Number number4, String str2) {
        this.js.append(String.format(Locale.US, "{bottom:%s, height: %s, left: %s, right: %s, top: %s, width: %s, } ", wrapQuotes(str), number, number2, number3, number4, wrapQuotes(str2)));
    }

    public RectObj(String str, Number number, Number number2, Number number3, String str2, Number number4) {
        this.js.append(String.format(Locale.US, "{bottom:%s, height: %s, left: %s, right: %s, top: %s, width: %s, } ", wrapQuotes(str), number, number2, number3, wrapQuotes(str2), number4));
    }

    public RectObj(String str, Number number, Number number2, Number number3, String str2, String str3) {
        this.js.append(String.format(Locale.US, "{bottom:%s, height: %s, left: %s, right: %s, top: %s, width: %s, } ", wrapQuotes(str), number, number2, number3, wrapQuotes(str2), wrapQuotes(str3)));
    }

    public RectObj(String str, Number number, Number number2, String str2, Number number3, Number number4) {
        this.js.append(String.format(Locale.US, "{bottom:%s, height: %s, left: %s, right: %s, top: %s, width: %s, } ", wrapQuotes(str), number, number2, wrapQuotes(str2), number3, number4));
    }

    public RectObj(String str, Number number, Number number2, String str2, Number number3, String str3) {
        this.js.append(String.format(Locale.US, "{bottom:%s, height: %s, left: %s, right: %s, top: %s, width: %s, } ", wrapQuotes(str), number, number2, wrapQuotes(str2), number3, wrapQuotes(str3)));
    }

    public RectObj(String str, Number number, Number number2, String str2, String str3, Number number3) {
        this.js.append(String.format(Locale.US, "{bottom:%s, height: %s, left: %s, right: %s, top: %s, width: %s, } ", wrapQuotes(str), number, number2, wrapQuotes(str2), wrapQuotes(str3), number3));
    }

    public RectObj(String str, Number number, Number number2, String str2, String str3, String str4) {
        this.js.append(String.format(Locale.US, "{bottom:%s, height: %s, left: %s, right: %s, top: %s, width: %s, } ", wrapQuotes(str), number, number2, wrapQuotes(str2), wrapQuotes(str3), wrapQuotes(str4)));
    }

    public RectObj(String str, Number number, String str2, Number number2, Number number3, Number number4) {
        this.js.append(String.format(Locale.US, "{bottom:%s, height: %s, left: %s, right: %s, top: %s, width: %s, } ", wrapQuotes(str), number, wrapQuotes(str2), number2, number3, number4));
    }

    public RectObj(String str, Number number, String str2, Number number2, Number number3, String str3) {
        this.js.append(String.format(Locale.US, "{bottom:%s, height: %s, left: %s, right: %s, top: %s, width: %s, } ", wrapQuotes(str), number, wrapQuotes(str2), number2, number3, wrapQuotes(str3)));
    }

    public RectObj(String str, Number number, String str2, Number number2, String str3, Number number3) {
        this.js.append(String.format(Locale.US, "{bottom:%s, height: %s, left: %s, right: %s, top: %s, width: %s, } ", wrapQuotes(str), number, wrapQuotes(str2), number2, wrapQuotes(str3), number3));
    }

    public RectObj(String str, Number number, String str2, Number number2, String str3, String str4) {
        this.js.append(String.format(Locale.US, "{bottom:%s, height: %s, left: %s, right: %s, top: %s, width: %s, } ", wrapQuotes(str), number, wrapQuotes(str2), number2, wrapQuotes(str3), wrapQuotes(str4)));
    }

    public RectObj(String str, Number number, String str2, String str3, Number number2, Number number3) {
        this.js.append(String.format(Locale.US, "{bottom:%s, height: %s, left: %s, right: %s, top: %s, width: %s, } ", wrapQuotes(str), number, wrapQuotes(str2), wrapQuotes(str3), number2, number3));
    }

    public RectObj(String str, Number number, String str2, String str3, Number number2, String str4) {
        this.js.append(String.format(Locale.US, "{bottom:%s, height: %s, left: %s, right: %s, top: %s, width: %s, } ", wrapQuotes(str), number, wrapQuotes(str2), wrapQuotes(str3), number2, wrapQuotes(str4)));
    }

    public RectObj(String str, Number number, String str2, String str3, String str4, Number number2) {
        this.js.append(String.format(Locale.US, "{bottom:%s, height: %s, left: %s, right: %s, top: %s, width: %s, } ", wrapQuotes(str), number, wrapQuotes(str2), wrapQuotes(str3), wrapQuotes(str4), number2));
    }

    public RectObj(String str, Number number, String str2, String str3, String str4, String str5) {
        this.js.append(String.format(Locale.US, "{bottom:%s, height: %s, left: %s, right: %s, top: %s, width: %s, } ", wrapQuotes(str), number, wrapQuotes(str2), wrapQuotes(str3), wrapQuotes(str4), wrapQuotes(str5)));
    }

    public RectObj(String str, String str2, Number number, Number number2, Number number3, Number number4) {
        this.js.append(String.format(Locale.US, "{bottom:%s, height: %s, left: %s, right: %s, top: %s, width: %s, } ", wrapQuotes(str), wrapQuotes(str2), number, number2, number3, number4));
    }

    public RectObj(String str, String str2, Number number, Number number2, Number number3, String str3) {
        this.js.append(String.format(Locale.US, "{bottom:%s, height: %s, left: %s, right: %s, top: %s, width: %s, } ", wrapQuotes(str), wrapQuotes(str2), number, number2, number3, wrapQuotes(str3)));
    }

    public RectObj(String str, String str2, Number number, Number number2, String str3, Number number3) {
        this.js.append(String.format(Locale.US, "{bottom:%s, height: %s, left: %s, right: %s, top: %s, width: %s, } ", wrapQuotes(str), wrapQuotes(str2), number, number2, wrapQuotes(str3), number3));
    }

    public RectObj(String str, String str2, Number number, Number number2, String str3, String str4) {
        this.js.append(String.format(Locale.US, "{bottom:%s, height: %s, left: %s, right: %s, top: %s, width: %s, } ", wrapQuotes(str), wrapQuotes(str2), number, number2, wrapQuotes(str3), wrapQuotes(str4)));
    }

    public RectObj(String str, String str2, Number number, String str3, Number number2, Number number3) {
        this.js.append(String.format(Locale.US, "{bottom:%s, height: %s, left: %s, right: %s, top: %s, width: %s, } ", wrapQuotes(str), wrapQuotes(str2), number, wrapQuotes(str3), number2, number3));
    }

    public RectObj(String str, String str2, Number number, String str3, Number number2, String str4) {
        this.js.append(String.format(Locale.US, "{bottom:%s, height: %s, left: %s, right: %s, top: %s, width: %s, } ", wrapQuotes(str), wrapQuotes(str2), number, wrapQuotes(str3), number2, wrapQuotes(str4)));
    }

    public RectObj(String str, String str2, Number number, String str3, String str4, Number number2) {
        this.js.append(String.format(Locale.US, "{bottom:%s, height: %s, left: %s, right: %s, top: %s, width: %s, } ", wrapQuotes(str), wrapQuotes(str2), number, wrapQuotes(str3), wrapQuotes(str4), number2));
    }

    public RectObj(String str, String str2, Number number, String str3, String str4, String str5) {
        this.js.append(String.format(Locale.US, "{bottom:%s, height: %s, left: %s, right: %s, top: %s, width: %s, } ", wrapQuotes(str), wrapQuotes(str2), number, wrapQuotes(str3), wrapQuotes(str4), wrapQuotes(str5)));
    }

    public RectObj(String str, String str2, String str3, Number number, Number number2, Number number3) {
        this.js.append(String.format(Locale.US, "{bottom:%s, height: %s, left: %s, right: %s, top: %s, width: %s, } ", wrapQuotes(str), wrapQuotes(str2), wrapQuotes(str3), number, number2, number3));
    }

    public RectObj(String str, String str2, String str3, Number number, Number number2, String str4) {
        this.js.append(String.format(Locale.US, "{bottom:%s, height: %s, left: %s, right: %s, top: %s, width: %s, } ", wrapQuotes(str), wrapQuotes(str2), wrapQuotes(str3), number, number2, wrapQuotes(str4)));
    }

    public RectObj(String str, String str2, String str3, Number number, String str4, Number number2) {
        this.js.append(String.format(Locale.US, "{bottom:%s, height: %s, left: %s, right: %s, top: %s, width: %s, } ", wrapQuotes(str), wrapQuotes(str2), wrapQuotes(str3), number, wrapQuotes(str4), number2));
    }

    public RectObj(String str, String str2, String str3, Number number, String str4, String str5) {
        this.js.append(String.format(Locale.US, "{bottom:%s, height: %s, left: %s, right: %s, top: %s, width: %s, } ", wrapQuotes(str), wrapQuotes(str2), wrapQuotes(str3), number, wrapQuotes(str4), wrapQuotes(str5)));
    }

    public RectObj(String str, String str2, String str3, String str4, Number number, Number number2) {
        this.js.append(String.format(Locale.US, "{bottom:%s, height: %s, left: %s, right: %s, top: %s, width: %s, } ", wrapQuotes(str), wrapQuotes(str2), wrapQuotes(str3), wrapQuotes(str4), number, number2));
    }

    public RectObj(String str, String str2, String str3, String str4, Number number, String str5) {
        this.js.append(String.format(Locale.US, "{bottom:%s, height: %s, left: %s, right: %s, top: %s, width: %s, } ", wrapQuotes(str), wrapQuotes(str2), wrapQuotes(str3), wrapQuotes(str4), number, wrapQuotes(str5)));
    }

    public RectObj(String str, String str2, String str3, String str4, String str5, Number number) {
        this.js.append(String.format(Locale.US, "{bottom:%s, height: %s, left: %s, right: %s, top: %s, width: %s, } ", wrapQuotes(str), wrapQuotes(str2), wrapQuotes(str3), wrapQuotes(str4), wrapQuotes(str5), number));
    }

    public RectObj(String str, String str2, String str3, String str4, String str5, String str6) {
        this.js.append(String.format(Locale.US, "{bottom:%s, height: %s, left: %s, right: %s, top: %s, width: %s, } ", wrapQuotes(str), wrapQuotes(str2), wrapQuotes(str3), wrapQuotes(str4), wrapQuotes(str5), wrapQuotes(str6)));
    }

    @Override // com.anychart.JsObject
    public String getJsBase() {
        return this.js.toString();
    }
}
