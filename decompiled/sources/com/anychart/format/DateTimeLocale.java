package com.anychart.format;

import com.anychart.JsObject;
import java.util.Arrays;
import java.util.Locale;

/* JADX INFO: loaded from: classes5.dex */
public class DateTimeLocale extends JsObject {
    public DateTimeLocale(String[] strArr, String str, String str2, String[] strArr2, String[] strArr3, Number number, Number number2, String[] strArr4, String[] strArr5, String[] strArr6, String[] strArr7, String[] strArr8, String[] strArr9, String[] strArr10, String[] strArr11, String[] strArr12, String[] strArr13, String[] strArr14, String[] strArr15, String[] strArr16, String[] strArr17, String str3, String[] strArr18, Number[] numberArr) {
        this.js.append(String.format(Locale.US, "{ampms:%s, dateFormats: %s, dateTimeFormats: %s, eras: %s, erasNames: %s, firstDayOfWeek: %s, firstWeekCutOfDay: %s, formats: %s, months: %s, narrowMonths: %s, narrowWeekdays: %s, quarters: %s, shortMonths: %s, shortQuarters: %s, shortWeekdays: %s, standaloneMonths: %s, standaloneNarrowMonths: %s, standaloneNarrowWeekdays: %s, standaloneShortMonths: %s, standaloneShortWeekdays: %s, standaloneWeekdays: %s, timeFormats: %s, weekdays: %s, weekendRange: %s, } ", arrayToStringWrapQuotes(strArr), wrapQuotes(str), wrapQuotes(str2), arrayToStringWrapQuotes(strArr2), arrayToStringWrapQuotes(strArr3), number, number2, arrayToStringWrapQuotes(strArr4), arrayToStringWrapQuotes(strArr5), arrayToStringWrapQuotes(strArr6), arrayToStringWrapQuotes(strArr7), arrayToStringWrapQuotes(strArr8), arrayToStringWrapQuotes(strArr9), arrayToStringWrapQuotes(strArr10), arrayToStringWrapQuotes(strArr11), arrayToStringWrapQuotes(strArr12), arrayToStringWrapQuotes(strArr13), arrayToStringWrapQuotes(strArr14), arrayToStringWrapQuotes(strArr15), arrayToStringWrapQuotes(strArr16), arrayToStringWrapQuotes(strArr17), wrapQuotes(str3), arrayToStringWrapQuotes(strArr18), Arrays.toString(numberArr)));
    }

    @Override // com.anychart.JsObject
    public String getJsBase() {
        return this.js.toString();
    }
}
