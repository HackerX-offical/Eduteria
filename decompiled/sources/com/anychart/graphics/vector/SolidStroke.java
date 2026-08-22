package com.anychart.graphics.vector;

import com.anychart.JsObject;
import java.util.Locale;

/* JADX INFO: loaded from: classes4.dex */
public class SolidStroke extends JsObject implements Stroke {
    public SolidStroke(String str, String str2, String str3, String str4, Number number, Number number2) {
        this.js.append(String.format(Locale.US, "{color:%s, dash: %s, lineCap: %s, lineJoin: %s, opacity: %s, thickness: %s, } ", wrapQuotes(str), wrapQuotes(str2), wrapQuotes(str3), wrapQuotes(str4), number, number2));
    }

    @Override // com.anychart.JsObject
    public String getJsBase() {
        return this.js.toString();
    }
}
