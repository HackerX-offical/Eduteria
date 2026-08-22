package com.anychart.graphics.vector;

import com.anychart.JsObject;
import java.util.Locale;

/* JADX INFO: loaded from: classes4.dex */
public class LinearGradientFill extends JsObject implements ColoredFill, Fill {
    public LinearGradientFill(Number number, GradientKey[] gradientKeyArr, Boolean bool, Number number2) {
        this.js.append(String.format(Locale.US, "{angle:%s, keys: %s, mode: %s, opacity: %s, } ", number, arrayToString((JsObject[]) gradientKeyArr), bool, number2));
    }

    public LinearGradientFill(Number number, GradientKey[] gradientKeyArr, Rect rect, Number number2) {
        this.js.append(String.format(Locale.US, "{angle:%s, keys: %s, mode: %s, opacity: %s, } ", number, arrayToString((JsObject[]) gradientKeyArr), rect != null ? rect.getJsBase() : null, number2));
    }

    public LinearGradientFill(Number number, String str, Boolean bool, Number number2) {
        this.js.append(String.format(Locale.US, "{angle:%s, keys: %s, mode: %s, opacity: %s, } ", number, wrapQuotes(str), bool, number2));
    }

    public LinearGradientFill(Number number, String str, Rect rect, Number number2) {
        this.js.append(String.format(Locale.US, "{angle:%s, keys: %s, mode: %s, opacity: %s, } ", number, wrapQuotes(str), rect != null ? rect.getJsBase() : null, number2));
    }

    @Override // com.anychart.JsObject
    public String getJsBase() {
        return this.js.toString();
    }
}
