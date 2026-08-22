package com.anychart;

import java.util.Locale;

/* JADX INFO: loaded from: classes4.dex */
public class AnyChartFormat {
    public static void date(String str, int i, String str2) {
        APIlib.getInstance().addJSLine(String.format(Locale.US, "anychart.format.date(%s, %s, %s);", str, Integer.valueOf(i), str2));
    }

    public static void dateTime(String str, String str2, int i, String str3) {
        APIlib.getInstance().addJSLine(String.format(Locale.US, "anychart.format.dateTime(%s, %s, %s, %s);", str, str2, Integer.valueOf(i), str3));
    }

    public static void outputDateFormat(String str) {
        APIlib.getInstance().addJSLine(String.format(Locale.US, "anychart.format.outputDateFormat(%s);", str));
    }

    public static void outputDateTimeFormat(String str) {
        APIlib.getInstance().addJSLine(String.format(Locale.US, "anychart.format.outputDateTimeFormat(%s);", str));
    }

    public static void outputLocale(String str) {
        APIlib.getInstance().addJSLine(String.format(Locale.US, "anychart.format.outputLocale(%s);", str));
    }

    public static void outputTimeFormat(String str) {
        APIlib.getInstance().addJSLine(String.format(Locale.US, "anychart.format.outputTimeFormat(%s);", str));
    }

    public static void outputTimezone(Number number) {
        APIlib.getInstance().addJSLine(String.format(Locale.US, "anychart.format.outputTimezone(%s);", number));
    }
}
