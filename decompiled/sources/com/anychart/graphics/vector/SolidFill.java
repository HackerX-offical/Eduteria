package com.anychart.graphics.vector;

import com.anychart.JsObject;
import java.util.Locale;

/* JADX INFO: loaded from: classes4.dex */
public class SolidFill extends JsObject implements ColoredFill, Fill {
    public SolidFill(String str, Number number) {
        this.js.append(String.format(Locale.US, "{color:%s, opacity: %s, } ", wrapQuotes(str), number));
    }

    @Override // com.anychart.JsObject
    public String getJsBase() {
        return this.js.toString();
    }
}
