package com.anychart.graphics.vector;

import com.anychart.JsObject;
import java.util.Locale;

/* JADX INFO: loaded from: classes4.dex */
public class RadialGradientFill extends JsObject implements ColoredFill, Fill {
    public RadialGradientFill(Number number, Number number2, Number number3, Number number4, GradientKey[] gradientKeyArr, com.anychart.graphics.math.Rect rect, Number number5) {
        this.js.append(String.format(Locale.US, "{cx:%s, cy: %s, fx: %s, fy: %s, keys: %s, mode: %s, opacity: %s, } ", number, number2, number3, number4, arrayToString((JsObject[]) gradientKeyArr), rect != null ? rect.getJsBase() : null, number5));
    }

    public RadialGradientFill(Number number, Number number2, Number number3, Number number4, String str, com.anychart.graphics.math.Rect rect, Number number5) {
        this.js.append(String.format(Locale.US, "{cx:%s, cy: %s, fx: %s, fy: %s, keys: %s, mode: %s, opacity: %s, } ", number, number2, number3, number4, wrapQuotes(str), rect != null ? rect.getJsBase() : null, number5));
    }

    @Override // com.anychart.JsObject
    public String getJsBase() {
        return this.js.toString();
    }
}
