package com.anychart.ui.rangeselector;

import com.anychart.JsObject;
import com.anychart.enums.Interval;
import com.anychart.enums.StockRangeAnchor;
import com.anychart.enums.StockRangeType;
import java.util.Locale;

/* JADX INFO: loaded from: classes6.dex */
public class Range extends JsObject {
    public Range(StockRangeAnchor stockRangeAnchor, Number number, String str, String str2, String str3, StockRangeType stockRangeType, Interval interval) {
        this.js.append(String.format(Locale.US, "{anchor:%s, count: %s, endDate: %s, startDate: %s, text: %s, type: %s, unit: %s, } ", stockRangeAnchor != null ? stockRangeAnchor.getJsBase() : null, number, wrapQuotes(str), wrapQuotes(str2), wrapQuotes(str3), stockRangeType != null ? stockRangeType.getJsBase() : null, interval != null ? interval.getJsBase() : null));
    }

    public Range(StockRangeAnchor stockRangeAnchor, Number number, String str, String str2, String str3, StockRangeType stockRangeType, String str4) {
        this.js.append(String.format(Locale.US, "{anchor:%s, count: %s, endDate: %s, startDate: %s, text: %s, type: %s, unit: %s, } ", stockRangeAnchor != null ? stockRangeAnchor.getJsBase() : null, number, wrapQuotes(str), wrapQuotes(str2), wrapQuotes(str3), stockRangeType != null ? stockRangeType.getJsBase() : null, wrapQuotes(str4)));
    }

    public Range(StockRangeAnchor stockRangeAnchor, Number number, String str, String str2, String str3, String str4, Interval interval) {
        this.js.append(String.format(Locale.US, "{anchor:%s, count: %s, endDate: %s, startDate: %s, text: %s, type: %s, unit: %s, } ", stockRangeAnchor != null ? stockRangeAnchor.getJsBase() : null, number, wrapQuotes(str), wrapQuotes(str2), wrapQuotes(str3), wrapQuotes(str4), interval != null ? interval.getJsBase() : null));
    }

    public Range(StockRangeAnchor stockRangeAnchor, Number number, String str, String str2, String str3, String str4, String str5) {
        this.js.append(String.format(Locale.US, "{anchor:%s, count: %s, endDate: %s, startDate: %s, text: %s, type: %s, unit: %s, } ", stockRangeAnchor != null ? stockRangeAnchor.getJsBase() : null, number, wrapQuotes(str), wrapQuotes(str2), wrapQuotes(str3), wrapQuotes(str4), wrapQuotes(str5)));
    }

    public Range(String str, Number number, String str2, String str3, String str4, StockRangeType stockRangeType, Interval interval) {
        this.js.append(String.format(Locale.US, "{anchor:%s, count: %s, endDate: %s, startDate: %s, text: %s, type: %s, unit: %s, } ", wrapQuotes(str), number, wrapQuotes(str2), wrapQuotes(str3), wrapQuotes(str4), stockRangeType != null ? stockRangeType.getJsBase() : null, interval != null ? interval.getJsBase() : null));
    }

    public Range(String str, Number number, String str2, String str3, String str4, StockRangeType stockRangeType, String str5) {
        this.js.append(String.format(Locale.US, "{anchor:%s, count: %s, endDate: %s, startDate: %s, text: %s, type: %s, unit: %s, } ", wrapQuotes(str), number, wrapQuotes(str2), wrapQuotes(str3), wrapQuotes(str4), stockRangeType != null ? stockRangeType.getJsBase() : null, wrapQuotes(str5)));
    }

    public Range(String str, Number number, String str2, String str3, String str4, String str5, Interval interval) {
        this.js.append(String.format(Locale.US, "{anchor:%s, count: %s, endDate: %s, startDate: %s, text: %s, type: %s, unit: %s, } ", wrapQuotes(str), number, wrapQuotes(str2), wrapQuotes(str3), wrapQuotes(str4), wrapQuotes(str5), interval != null ? interval.getJsBase() : null));
    }

    public Range(String str, Number number, String str2, String str3, String str4, String str5, String str6) {
        this.js.append(String.format(Locale.US, "{anchor:%s, count: %s, endDate: %s, startDate: %s, text: %s, type: %s, unit: %s, } ", wrapQuotes(str), number, wrapQuotes(str2), wrapQuotes(str3), wrapQuotes(str4), wrapQuotes(str5), wrapQuotes(str6)));
    }

    @Override // com.anychart.JsObject
    public String getJsBase() {
        return this.js.toString();
    }
}
