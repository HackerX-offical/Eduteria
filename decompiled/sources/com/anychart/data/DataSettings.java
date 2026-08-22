package com.anychart.data;

import com.anychart.JsObject;
import com.anychart.enums.TextParsingMode;
import java.util.Locale;

/* JADX INFO: loaded from: classes5.dex */
public class DataSettings extends JsObject {
    public DataSettings(String str, String[] strArr, String[] strArr2, String str2, TextParsingMode textParsingMode) {
        this.js.append(String.format(Locale.US, "{caption:%s, header: %s, rows: %s, text: %s, textSettings: %s, } ", wrapQuotes(str), arrayToStringWrapQuotes(strArr), arrayToStringWrapQuotes(strArr2), wrapQuotes(str2), textParsingMode != null ? textParsingMode.getJsBase() : null));
    }

    public DataSettings(String str, String[] strArr, String[] strArr2, String str2, String str3) {
        this.js.append(String.format(Locale.US, "{caption:%s, header: %s, rows: %s, text: %s, textSettings: %s, } ", wrapQuotes(str), arrayToStringWrapQuotes(strArr), arrayToStringWrapQuotes(strArr2), wrapQuotes(str2), wrapQuotes(str3)));
    }

    public DataSettings(String str, String[] strArr, String[] strArr2, String str2, TextParsingSettings textParsingSettings) {
        this.js.append(String.format(Locale.US, "{caption:%s, header: %s, rows: %s, text: %s, textSettings: %s, } ", wrapQuotes(str), arrayToStringWrapQuotes(strArr), arrayToStringWrapQuotes(strArr2), wrapQuotes(str2), textParsingSettings != null ? textParsingSettings.getJsBase() : null));
    }

    @Override // com.anychart.JsObject
    public String getJsBase() {
        return this.js.toString();
    }
}
