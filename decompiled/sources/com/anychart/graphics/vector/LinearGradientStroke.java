package com.anychart.graphics.vector;

import com.anychart.JsObject;
import java.util.Locale;

/* JADX INFO: loaded from: classes4.dex */
public class LinearGradientStroke extends JsObject implements Stroke {
    public LinearGradientStroke(Number number, String str, GradientKey[] gradientKeyArr, String str2, String str3, Boolean bool, Number number2, Number number3) {
        this.js.append(String.format(Locale.US, "{angle:%s, dash: %s, keys: %s, lineCap: %s, lineJoin: %s, mode: %s, opacity: %s, thickness: %s, } ", number, wrapQuotes(str), arrayToString((JsObject[]) gradientKeyArr), wrapQuotes(str2), wrapQuotes(str3), bool, number2, number3));
    }

    public LinearGradientStroke(Number number, String str, GradientKey[] gradientKeyArr, String str2, String str3, com.anychart.graphics.math.Rect rect, Number number2, Number number3) {
        this.js.append(String.format(Locale.US, "{angle:%s, dash: %s, keys: %s, lineCap: %s, lineJoin: %s, mode: %s, opacity: %s, thickness: %s, } ", number, wrapQuotes(str), arrayToString((JsObject[]) gradientKeyArr), wrapQuotes(str2), wrapQuotes(str3), rect != null ? rect.getJsBase() : null, number2, number3));
    }

    public LinearGradientStroke(Number number, String str, String str2, String str3, String str4, Boolean bool, Number number2, Number number3) {
        this.js.append(String.format(Locale.US, "{angle:%s, dash: %s, keys: %s, lineCap: %s, lineJoin: %s, mode: %s, opacity: %s, thickness: %s, } ", number, wrapQuotes(str), wrapQuotes(str2), wrapQuotes(str3), wrapQuotes(str4), bool, number2, number3));
    }

    public LinearGradientStroke(Number number, String str, String str2, String str3, String str4, com.anychart.graphics.math.Rect rect, Number number2, Number number3) {
        this.js.append(String.format(Locale.US, "{angle:%s, dash: %s, keys: %s, lineCap: %s, lineJoin: %s, mode: %s, opacity: %s, thickness: %s, } ", number, wrapQuotes(str), wrapQuotes(str2), wrapQuotes(str3), wrapQuotes(str4), rect != null ? rect.getJsBase() : null, number2, number3));
    }

    @Override // com.anychart.JsObject
    public String getJsBase() {
        return this.js.toString();
    }
}
