package com.anychart.graphics.vector;

import com.anychart.JsObject;
import java.util.Locale;

/* JADX INFO: loaded from: classes4.dex */
public class GradientKey extends JsObject {
    public GradientKey(String str, Number number, Number number2) {
        this.js.append(String.format(Locale.US, "{color:%s, offset: %s, opacity: %s, } ", wrapQuotes(str), number, number2));
    }

    @Override // com.anychart.JsObject
    public String getJsBase() {
        return this.js.toString();
    }
}
