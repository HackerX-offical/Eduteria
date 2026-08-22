package com.anychart.editor;

import com.anychart.JsObject;
import java.util.Locale;

/* JADX INFO: loaded from: classes5.dex */
public class JavascriptOptions extends JsObject {
    public JavascriptOptions(Boolean bool, Boolean bool2, Boolean bool3, String str, Boolean bool4, String str2) {
        this.js.append(String.format(Locale.US, "{addData:%s, addGeoData: %s, addMarkers: %s, container: %s, minify: %s, wrapper: %s, } ", bool, bool2, bool3, wrapQuotes(str), bool4, wrapQuotes(str2)));
    }

    @Override // com.anychart.JsObject
    public String getJsBase() {
        return this.js.toString();
    }
}
