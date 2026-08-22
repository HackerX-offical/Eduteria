package com.anychart.graphics.vector;

import com.anychart.JsObject;
import java.util.Locale;

/* JADX INFO: loaded from: classes4.dex */
public class RadialGradientStroke extends JsObject implements Stroke {
    public RadialGradientStroke(Number number, Number number2, String str, Number number3, Number number4, GradientKey[] gradientKeyArr, String str2, String str3, com.anychart.graphics.math.Rect rect, Number number5, Number number6) {
        this.js.append(String.format(Locale.US, "{cx:%s, cy: %s, dash: %s, fx: %s, fy: %s, keys: %s, lineCap: %s, lineJoin: %s, mode: %s, opacity: %s, thickness: %s, } ", number, number2, wrapQuotes(str), number3, number4, arrayToString((JsObject[]) gradientKeyArr), wrapQuotes(str2), wrapQuotes(str3), rect != null ? rect.getJsBase() : null, number5, number6));
    }

    public RadialGradientStroke(Number number, Number number2, String str, Number number3, Number number4, String str2, String str3, String str4, com.anychart.graphics.math.Rect rect, Number number5, Number number6) {
        this.js.append(String.format(Locale.US, "{cx:%s, cy: %s, dash: %s, fx: %s, fy: %s, keys: %s, lineCap: %s, lineJoin: %s, mode: %s, opacity: %s, thickness: %s, } ", number, number2, wrapQuotes(str), number3, number4, wrapQuotes(str2), wrapQuotes(str3), wrapQuotes(str4), rect != null ? rect.getJsBase() : null, number5, number6));
    }

    @Override // com.anychart.JsObject
    public String getJsBase() {
        return this.js.toString();
    }
}
