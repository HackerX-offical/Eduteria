package com.anychart.graphics.vector;

import com.anychart.JsObject;
import java.util.Locale;

/* JADX INFO: loaded from: classes4.dex */
public class TextSegmentStyle extends JsObject {
    public TextSegmentStyle(String str, String str2, String str3, String str4, String str5, String str6, Number number, String str7, Number number2) {
        this.js.append(String.format(Locale.US, "{color:%s, decoration: %s, fontFamily: %s, fontSize: %s, fontStyle: %s, fontVariant: %s, fontWeight: %s, letterSpacing: %s, opacity: %s, } ", wrapQuotes(str), wrapQuotes(str2), wrapQuotes(str3), wrapQuotes(str4), wrapQuotes(str5), wrapQuotes(str6), number, wrapQuotes(str7), number2));
    }

    public TextSegmentStyle(String str, String str2, String str3, String str4, String str5, String str6, String str7, String str8, Number number) {
        this.js.append(String.format(Locale.US, "{color:%s, decoration: %s, fontFamily: %s, fontSize: %s, fontStyle: %s, fontVariant: %s, fontWeight: %s, letterSpacing: %s, opacity: %s, } ", wrapQuotes(str), wrapQuotes(str2), wrapQuotes(str3), wrapQuotes(str4), wrapQuotes(str5), wrapQuotes(str6), wrapQuotes(str7), wrapQuotes(str8), number));
    }

    public TextSegmentStyle(String str, String str2, String str3, Number number, String str4, String str5, Number number2, String str6, Number number3) {
        this.js.append(String.format(Locale.US, "{color:%s, decoration: %s, fontFamily: %s, fontSize: %s, fontStyle: %s, fontVariant: %s, fontWeight: %s, letterSpacing: %s, opacity: %s, } ", wrapQuotes(str), wrapQuotes(str2), wrapQuotes(str3), number, wrapQuotes(str4), wrapQuotes(str5), number2, wrapQuotes(str6), number3));
    }

    public TextSegmentStyle(String str, String str2, String str3, Number number, String str4, String str5, String str6, String str7, Number number2) {
        this.js.append(String.format(Locale.US, "{color:%s, decoration: %s, fontFamily: %s, fontSize: %s, fontStyle: %s, fontVariant: %s, fontWeight: %s, letterSpacing: %s, opacity: %s, } ", wrapQuotes(str), wrapQuotes(str2), wrapQuotes(str3), number, wrapQuotes(str4), wrapQuotes(str5), wrapQuotes(str6), wrapQuotes(str7), number2));
    }

    @Override // com.anychart.JsObject
    public String getJsBase() {
        return this.js.toString();
    }
}
