package com.anychart.format;

import com.anychart.JsObject;
import java.util.Locale;

/* JADX INFO: loaded from: classes5.dex */
public class NumberLocale extends JsObject {
    public NumberLocale(String str, Number number, String str2, String str3, String str4, Boolean bool, Boolean bool2) {
        this.js.append(String.format(Locale.US, "{decimalPoint:%s, decimalsCount: %s, groupsSeparator: %s, scale: %s, scaleSuffixSeparator: %s, useBracketsForNegative: %s, zeroFillDecimals: %s, } ", wrapQuotes(str), number, wrapQuotes(str2), wrapQuotes(str3), wrapQuotes(str4), bool, bool2));
    }

    public NumberLocale(String str, Number number, String str2, Boolean bool, String str3, Boolean bool2, Boolean bool3) {
        this.js.append(String.format(Locale.US, "{decimalPoint:%s, decimalsCount: %s, groupsSeparator: %s, scale: %s, scaleSuffixSeparator: %s, useBracketsForNegative: %s, zeroFillDecimals: %s, } ", wrapQuotes(str), number, wrapQuotes(str2), bool, wrapQuotes(str3), bool2, bool3));
    }

    @Override // com.anychart.JsObject
    public String getJsBase() {
        return this.js.toString();
    }
}
