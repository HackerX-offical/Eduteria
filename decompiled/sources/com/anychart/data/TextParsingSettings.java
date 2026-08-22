package com.anychart.data;

import com.anychart.JsObject;
import com.anychart.enums.TextParsingMode;
import java.util.Locale;

/* JADX INFO: loaded from: classes5.dex */
public class TextParsingSettings extends JsObject {
    public TextParsingSettings(String str, Number number, Boolean bool, String[] strArr, Boolean bool2, Number number2, Number number3, Number number4, TextParsingMode textParsingMode, String str2) {
        this.js.append(String.format(Locale.US, "{columnsSeparator:%s, cutLength: %s, ignoreFirstRow: %s, ignoreItems: %s, ignoreTrailingSpaces: %s, maxItems: %s, maxLength: %s, minLength: %s, mode: %s, rowsSeparator: %s, } ", wrapQuotes(str), number, bool, arrayToStringWrapQuotes(strArr), bool2, number2, number3, number4, textParsingMode != null ? textParsingMode.getJsBase() : null, wrapQuotes(str2)));
    }

    public TextParsingSettings(String str, Number number, Boolean bool, String[] strArr, Boolean bool2, Number number2, Number number3, Number number4, String str2, String str3) {
        this.js.append(String.format(Locale.US, "{columnsSeparator:%s, cutLength: %s, ignoreFirstRow: %s, ignoreItems: %s, ignoreTrailingSpaces: %s, maxItems: %s, maxLength: %s, minLength: %s, mode: %s, rowsSeparator: %s, } ", wrapQuotes(str), number, bool, arrayToStringWrapQuotes(strArr), bool2, number2, number3, number4, wrapQuotes(str2), wrapQuotes(str3)));
    }

    @Override // com.anychart.JsObject
    public String getJsBase() {
        return this.js.toString();
    }
}
