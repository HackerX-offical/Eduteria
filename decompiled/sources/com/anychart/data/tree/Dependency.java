package com.anychart.data.tree;

import com.anychart.JsObject;
import java.util.Locale;

/* JADX INFO: loaded from: classes5.dex */
public class Dependency extends JsObject {
    public Dependency(String str, String str2) {
        this.js.append(String.format(Locale.US, "{from:%s, to: %s, } ", wrapQuotes(str), wrapQuotes(str2)));
    }

    public Dependency(String str, Number number) {
        this.js.append(String.format(Locale.US, "{from:%s, to: %s, } ", wrapQuotes(str), number));
    }

    public Dependency(Number number, String str) {
        this.js.append(String.format(Locale.US, "{from:%s, to: %s, } ", number, wrapQuotes(str)));
    }

    public Dependency(Number number, Number number2) {
        this.js.append(String.format(Locale.US, "{from:%s, to: %s, } ", number, number2));
    }

    @Override // com.anychart.JsObject
    public String getJsBase() {
        return this.js.toString();
    }
}
