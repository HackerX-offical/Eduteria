package com.anychart.core.ui.table;

import com.anychart.APIlib;
import com.anychart.JsObject;
import com.anychart.graphics.vector.ColoredFill;
import com.anychart.graphics.vector.Stroke;
import com.anychart.graphics.vector.StrokeLineCap;
import com.anychart.graphics.vector.StrokeLineJoin;
import com.clevertap.android.sdk.Constants;
import java.util.Locale;

/* JADX INFO: loaded from: classes5.dex */
public class Border extends JsObject {
    protected Border() {
    }

    public static Border instantiate() {
        return new Border("new anychart.core.ui.table.border()");
    }

    public Border(String str) {
        StringBuilder sb = new StringBuilder(Constants.KEY_BORDER);
        int i = variableIndex + 1;
        variableIndex = i;
        this.jsBase = sb.append(i).toString();
        APIlib.getInstance().addJSLine(this.jsBase + " = " + str + ";");
    }

    @Override // com.anychart.JsObject
    public String getJsBase() {
        return this.jsBase;
    }

    public void bottom() {
        APIlib.getInstance().addJSLine(this.jsBase + ".bottom();");
    }

    public Base bottom(Stroke stroke, Number number, String str, String str2, String str3) {
        return new Base(String.format(Locale.US, this.jsBase + ".bottom(%s, %s, %s, %s, %s)", stroke != null ? stroke.getJsBase() : null, number, wrapQuotes(str), wrapQuotes(str2), wrapQuotes(str3)));
    }

    public Base bottom(Stroke stroke, Number number, String str, String str2, StrokeLineCap strokeLineCap) {
        return new Base(String.format(Locale.US, this.jsBase + ".bottom(%s, %s, %s, %s, %s)", stroke != null ? stroke.getJsBase() : null, number, wrapQuotes(str), wrapQuotes(str2), strokeLineCap != null ? strokeLineCap.getJsBase() : null));
    }

    public Base bottom(Stroke stroke, Number number, String str, StrokeLineJoin strokeLineJoin, String str2) {
        return new Base(String.format(Locale.US, this.jsBase + ".bottom(%s, %s, %s, %s, %s)", stroke != null ? stroke.getJsBase() : null, number, wrapQuotes(str), strokeLineJoin != null ? strokeLineJoin.getJsBase() : null, wrapQuotes(str2)));
    }

    public Base bottom(Stroke stroke, Number number, String str, StrokeLineJoin strokeLineJoin, StrokeLineCap strokeLineCap) {
        return new Base(String.format(Locale.US, this.jsBase + ".bottom(%s, %s, %s, %s, %s)", stroke != null ? stroke.getJsBase() : null, number, wrapQuotes(str), strokeLineJoin != null ? strokeLineJoin.getJsBase() : null, strokeLineCap != null ? strokeLineCap.getJsBase() : null));
    }

    public Base bottom(ColoredFill coloredFill, Number number, String str, String str2, String str3) {
        return new Base(String.format(Locale.US, this.jsBase + ".bottom(%s, %s, %s, %s, %s)", coloredFill != null ? coloredFill.getJsBase() : null, number, wrapQuotes(str), wrapQuotes(str2), wrapQuotes(str3)));
    }

    public Base bottom(ColoredFill coloredFill, Number number, String str, String str2, StrokeLineCap strokeLineCap) {
        return new Base(String.format(Locale.US, this.jsBase + ".bottom(%s, %s, %s, %s, %s)", coloredFill != null ? coloredFill.getJsBase() : null, number, wrapQuotes(str), wrapQuotes(str2), strokeLineCap != null ? strokeLineCap.getJsBase() : null));
    }

    public Base bottom(ColoredFill coloredFill, Number number, String str, StrokeLineJoin strokeLineJoin, String str2) {
        return new Base(String.format(Locale.US, this.jsBase + ".bottom(%s, %s, %s, %s, %s)", coloredFill != null ? coloredFill.getJsBase() : null, number, wrapQuotes(str), strokeLineJoin != null ? strokeLineJoin.getJsBase() : null, wrapQuotes(str2)));
    }

    public Base bottom(ColoredFill coloredFill, Number number, String str, StrokeLineJoin strokeLineJoin, StrokeLineCap strokeLineCap) {
        return new Base(String.format(Locale.US, this.jsBase + ".bottom(%s, %s, %s, %s, %s)", coloredFill != null ? coloredFill.getJsBase() : null, number, wrapQuotes(str), strokeLineJoin != null ? strokeLineJoin.getJsBase() : null, strokeLineCap != null ? strokeLineCap.getJsBase() : null));
    }

    public Base bottom(String str, Number number, String str2, String str3, String str4) {
        return new Base(String.format(Locale.US, this.jsBase + ".bottom(%s, %s, %s, %s, %s)", wrapQuotes(str), number, wrapQuotes(str2), wrapQuotes(str3), wrapQuotes(str4)));
    }

    public Base bottom(String str, Number number, String str2, String str3, StrokeLineCap strokeLineCap) {
        return new Base(String.format(Locale.US, this.jsBase + ".bottom(%s, %s, %s, %s, %s)", wrapQuotes(str), number, wrapQuotes(str2), wrapQuotes(str3), strokeLineCap != null ? strokeLineCap.getJsBase() : null));
    }

    public Base bottom(String str, Number number, String str2, StrokeLineJoin strokeLineJoin, String str3) {
        return new Base(String.format(Locale.US, this.jsBase + ".bottom(%s, %s, %s, %s, %s)", wrapQuotes(str), number, wrapQuotes(str2), strokeLineJoin != null ? strokeLineJoin.getJsBase() : null, wrapQuotes(str3)));
    }

    public Base bottom(String str, Number number, String str2, StrokeLineJoin strokeLineJoin, StrokeLineCap strokeLineCap) {
        return new Base(String.format(Locale.US, this.jsBase + ".bottom(%s, %s, %s, %s, %s)", wrapQuotes(str), number, wrapQuotes(str2), strokeLineJoin != null ? strokeLineJoin.getJsBase() : null, strokeLineCap != null ? strokeLineCap.getJsBase() : null));
    }

    public void left() {
        APIlib.getInstance().addJSLine(this.jsBase + ".left();");
    }

    public Base left(Stroke stroke, Number number, String str, String str2, String str3) {
        return new Base(String.format(Locale.US, this.jsBase + ".left(%s, %s, %s, %s, %s)", stroke != null ? stroke.getJsBase() : null, number, wrapQuotes(str), wrapQuotes(str2), wrapQuotes(str3)));
    }

    public Base left(Stroke stroke, Number number, String str, String str2, StrokeLineCap strokeLineCap) {
        return new Base(String.format(Locale.US, this.jsBase + ".left(%s, %s, %s, %s, %s)", stroke != null ? stroke.getJsBase() : null, number, wrapQuotes(str), wrapQuotes(str2), strokeLineCap != null ? strokeLineCap.getJsBase() : null));
    }

    public Base left(Stroke stroke, Number number, String str, StrokeLineJoin strokeLineJoin, String str2) {
        return new Base(String.format(Locale.US, this.jsBase + ".left(%s, %s, %s, %s, %s)", stroke != null ? stroke.getJsBase() : null, number, wrapQuotes(str), strokeLineJoin != null ? strokeLineJoin.getJsBase() : null, wrapQuotes(str2)));
    }

    public Base left(Stroke stroke, Number number, String str, StrokeLineJoin strokeLineJoin, StrokeLineCap strokeLineCap) {
        return new Base(String.format(Locale.US, this.jsBase + ".left(%s, %s, %s, %s, %s)", stroke != null ? stroke.getJsBase() : null, number, wrapQuotes(str), strokeLineJoin != null ? strokeLineJoin.getJsBase() : null, strokeLineCap != null ? strokeLineCap.getJsBase() : null));
    }

    public Base left(ColoredFill coloredFill, Number number, String str, String str2, String str3) {
        return new Base(String.format(Locale.US, this.jsBase + ".left(%s, %s, %s, %s, %s)", coloredFill != null ? coloredFill.getJsBase() : null, number, wrapQuotes(str), wrapQuotes(str2), wrapQuotes(str3)));
    }

    public Base left(ColoredFill coloredFill, Number number, String str, String str2, StrokeLineCap strokeLineCap) {
        return new Base(String.format(Locale.US, this.jsBase + ".left(%s, %s, %s, %s, %s)", coloredFill != null ? coloredFill.getJsBase() : null, number, wrapQuotes(str), wrapQuotes(str2), strokeLineCap != null ? strokeLineCap.getJsBase() : null));
    }

    public Base left(ColoredFill coloredFill, Number number, String str, StrokeLineJoin strokeLineJoin, String str2) {
        return new Base(String.format(Locale.US, this.jsBase + ".left(%s, %s, %s, %s, %s)", coloredFill != null ? coloredFill.getJsBase() : null, number, wrapQuotes(str), strokeLineJoin != null ? strokeLineJoin.getJsBase() : null, wrapQuotes(str2)));
    }

    public Base left(ColoredFill coloredFill, Number number, String str, StrokeLineJoin strokeLineJoin, StrokeLineCap strokeLineCap) {
        return new Base(String.format(Locale.US, this.jsBase + ".left(%s, %s, %s, %s, %s)", coloredFill != null ? coloredFill.getJsBase() : null, number, wrapQuotes(str), strokeLineJoin != null ? strokeLineJoin.getJsBase() : null, strokeLineCap != null ? strokeLineCap.getJsBase() : null));
    }

    public Base left(String str, Number number, String str2, String str3, String str4) {
        return new Base(String.format(Locale.US, this.jsBase + ".left(%s, %s, %s, %s, %s)", wrapQuotes(str), number, wrapQuotes(str2), wrapQuotes(str3), wrapQuotes(str4)));
    }

    public Base left(String str, Number number, String str2, String str3, StrokeLineCap strokeLineCap) {
        return new Base(String.format(Locale.US, this.jsBase + ".left(%s, %s, %s, %s, %s)", wrapQuotes(str), number, wrapQuotes(str2), wrapQuotes(str3), strokeLineCap != null ? strokeLineCap.getJsBase() : null));
    }

    public Base left(String str, Number number, String str2, StrokeLineJoin strokeLineJoin, String str3) {
        return new Base(String.format(Locale.US, this.jsBase + ".left(%s, %s, %s, %s, %s)", wrapQuotes(str), number, wrapQuotes(str2), strokeLineJoin != null ? strokeLineJoin.getJsBase() : null, wrapQuotes(str3)));
    }

    public Base left(String str, Number number, String str2, StrokeLineJoin strokeLineJoin, StrokeLineCap strokeLineCap) {
        return new Base(String.format(Locale.US, this.jsBase + ".left(%s, %s, %s, %s, %s)", wrapQuotes(str), number, wrapQuotes(str2), strokeLineJoin != null ? strokeLineJoin.getJsBase() : null, strokeLineCap != null ? strokeLineCap.getJsBase() : null));
    }

    public void right() {
        APIlib.getInstance().addJSLine(this.jsBase + ".right();");
    }

    public Base right(Stroke stroke, Number number, String str, String str2, String str3) {
        return new Base(String.format(Locale.US, this.jsBase + ".right(%s, %s, %s, %s, %s)", stroke != null ? stroke.getJsBase() : null, number, wrapQuotes(str), wrapQuotes(str2), wrapQuotes(str3)));
    }

    public Base right(Stroke stroke, Number number, String str, String str2, StrokeLineCap strokeLineCap) {
        return new Base(String.format(Locale.US, this.jsBase + ".right(%s, %s, %s, %s, %s)", stroke != null ? stroke.getJsBase() : null, number, wrapQuotes(str), wrapQuotes(str2), strokeLineCap != null ? strokeLineCap.getJsBase() : null));
    }

    public Base right(Stroke stroke, Number number, String str, StrokeLineJoin strokeLineJoin, String str2) {
        return new Base(String.format(Locale.US, this.jsBase + ".right(%s, %s, %s, %s, %s)", stroke != null ? stroke.getJsBase() : null, number, wrapQuotes(str), strokeLineJoin != null ? strokeLineJoin.getJsBase() : null, wrapQuotes(str2)));
    }

    public Base right(Stroke stroke, Number number, String str, StrokeLineJoin strokeLineJoin, StrokeLineCap strokeLineCap) {
        return new Base(String.format(Locale.US, this.jsBase + ".right(%s, %s, %s, %s, %s)", stroke != null ? stroke.getJsBase() : null, number, wrapQuotes(str), strokeLineJoin != null ? strokeLineJoin.getJsBase() : null, strokeLineCap != null ? strokeLineCap.getJsBase() : null));
    }

    public Base right(ColoredFill coloredFill, Number number, String str, String str2, String str3) {
        return new Base(String.format(Locale.US, this.jsBase + ".right(%s, %s, %s, %s, %s)", coloredFill != null ? coloredFill.getJsBase() : null, number, wrapQuotes(str), wrapQuotes(str2), wrapQuotes(str3)));
    }

    public Base right(ColoredFill coloredFill, Number number, String str, String str2, StrokeLineCap strokeLineCap) {
        return new Base(String.format(Locale.US, this.jsBase + ".right(%s, %s, %s, %s, %s)", coloredFill != null ? coloredFill.getJsBase() : null, number, wrapQuotes(str), wrapQuotes(str2), strokeLineCap != null ? strokeLineCap.getJsBase() : null));
    }

    public Base right(ColoredFill coloredFill, Number number, String str, StrokeLineJoin strokeLineJoin, String str2) {
        return new Base(String.format(Locale.US, this.jsBase + ".right(%s, %s, %s, %s, %s)", coloredFill != null ? coloredFill.getJsBase() : null, number, wrapQuotes(str), strokeLineJoin != null ? strokeLineJoin.getJsBase() : null, wrapQuotes(str2)));
    }

    public Base right(ColoredFill coloredFill, Number number, String str, StrokeLineJoin strokeLineJoin, StrokeLineCap strokeLineCap) {
        return new Base(String.format(Locale.US, this.jsBase + ".right(%s, %s, %s, %s, %s)", coloredFill != null ? coloredFill.getJsBase() : null, number, wrapQuotes(str), strokeLineJoin != null ? strokeLineJoin.getJsBase() : null, strokeLineCap != null ? strokeLineCap.getJsBase() : null));
    }

    public Base right(String str, Number number, String str2, String str3, String str4) {
        return new Base(String.format(Locale.US, this.jsBase + ".right(%s, %s, %s, %s, %s)", wrapQuotes(str), number, wrapQuotes(str2), wrapQuotes(str3), wrapQuotes(str4)));
    }

    public Base right(String str, Number number, String str2, String str3, StrokeLineCap strokeLineCap) {
        return new Base(String.format(Locale.US, this.jsBase + ".right(%s, %s, %s, %s, %s)", wrapQuotes(str), number, wrapQuotes(str2), wrapQuotes(str3), strokeLineCap != null ? strokeLineCap.getJsBase() : null));
    }

    public Base right(String str, Number number, String str2, StrokeLineJoin strokeLineJoin, String str3) {
        return new Base(String.format(Locale.US, this.jsBase + ".right(%s, %s, %s, %s, %s)", wrapQuotes(str), number, wrapQuotes(str2), strokeLineJoin != null ? strokeLineJoin.getJsBase() : null, wrapQuotes(str3)));
    }

    public Base right(String str, Number number, String str2, StrokeLineJoin strokeLineJoin, StrokeLineCap strokeLineCap) {
        return new Base(String.format(Locale.US, this.jsBase + ".right(%s, %s, %s, %s, %s)", wrapQuotes(str), number, wrapQuotes(str2), strokeLineJoin != null ? strokeLineJoin.getJsBase() : null, strokeLineCap != null ? strokeLineCap.getJsBase() : null));
    }

    public void top() {
        APIlib.getInstance().addJSLine(this.jsBase + ".top();");
    }

    public Base top(Stroke stroke, Number number, String str, String str2, String str3) {
        return new Base(String.format(Locale.US, this.jsBase + ".top(%s, %s, %s, %s, %s)", stroke != null ? stroke.getJsBase() : null, number, wrapQuotes(str), wrapQuotes(str2), wrapQuotes(str3)));
    }

    public Base top(Stroke stroke, Number number, String str, String str2, StrokeLineCap strokeLineCap) {
        return new Base(String.format(Locale.US, this.jsBase + ".top(%s, %s, %s, %s, %s)", stroke != null ? stroke.getJsBase() : null, number, wrapQuotes(str), wrapQuotes(str2), strokeLineCap != null ? strokeLineCap.getJsBase() : null));
    }

    public Base top(Stroke stroke, Number number, String str, StrokeLineJoin strokeLineJoin, String str2) {
        return new Base(String.format(Locale.US, this.jsBase + ".top(%s, %s, %s, %s, %s)", stroke != null ? stroke.getJsBase() : null, number, wrapQuotes(str), strokeLineJoin != null ? strokeLineJoin.getJsBase() : null, wrapQuotes(str2)));
    }

    public Base top(Stroke stroke, Number number, String str, StrokeLineJoin strokeLineJoin, StrokeLineCap strokeLineCap) {
        return new Base(String.format(Locale.US, this.jsBase + ".top(%s, %s, %s, %s, %s)", stroke != null ? stroke.getJsBase() : null, number, wrapQuotes(str), strokeLineJoin != null ? strokeLineJoin.getJsBase() : null, strokeLineCap != null ? strokeLineCap.getJsBase() : null));
    }

    public Base top(ColoredFill coloredFill, Number number, String str, String str2, String str3) {
        return new Base(String.format(Locale.US, this.jsBase + ".top(%s, %s, %s, %s, %s)", coloredFill != null ? coloredFill.getJsBase() : null, number, wrapQuotes(str), wrapQuotes(str2), wrapQuotes(str3)));
    }

    public Base top(ColoredFill coloredFill, Number number, String str, String str2, StrokeLineCap strokeLineCap) {
        return new Base(String.format(Locale.US, this.jsBase + ".top(%s, %s, %s, %s, %s)", coloredFill != null ? coloredFill.getJsBase() : null, number, wrapQuotes(str), wrapQuotes(str2), strokeLineCap != null ? strokeLineCap.getJsBase() : null));
    }

    public Base top(ColoredFill coloredFill, Number number, String str, StrokeLineJoin strokeLineJoin, String str2) {
        return new Base(String.format(Locale.US, this.jsBase + ".top(%s, %s, %s, %s, %s)", coloredFill != null ? coloredFill.getJsBase() : null, number, wrapQuotes(str), strokeLineJoin != null ? strokeLineJoin.getJsBase() : null, wrapQuotes(str2)));
    }

    public Base top(ColoredFill coloredFill, Number number, String str, StrokeLineJoin strokeLineJoin, StrokeLineCap strokeLineCap) {
        return new Base(String.format(Locale.US, this.jsBase + ".top(%s, %s, %s, %s, %s)", coloredFill != null ? coloredFill.getJsBase() : null, number, wrapQuotes(str), strokeLineJoin != null ? strokeLineJoin.getJsBase() : null, strokeLineCap != null ? strokeLineCap.getJsBase() : null));
    }

    public Base top(String str, Number number, String str2, String str3, String str4) {
        return new Base(String.format(Locale.US, this.jsBase + ".top(%s, %s, %s, %s, %s)", wrapQuotes(str), number, wrapQuotes(str2), wrapQuotes(str3), wrapQuotes(str4)));
    }

    public Base top(String str, Number number, String str2, String str3, StrokeLineCap strokeLineCap) {
        return new Base(String.format(Locale.US, this.jsBase + ".top(%s, %s, %s, %s, %s)", wrapQuotes(str), number, wrapQuotes(str2), wrapQuotes(str3), strokeLineCap != null ? strokeLineCap.getJsBase() : null));
    }

    public Base top(String str, Number number, String str2, StrokeLineJoin strokeLineJoin, String str3) {
        return new Base(String.format(Locale.US, this.jsBase + ".top(%s, %s, %s, %s, %s)", wrapQuotes(str), number, wrapQuotes(str2), strokeLineJoin != null ? strokeLineJoin.getJsBase() : null, wrapQuotes(str3)));
    }

    public Base top(String str, Number number, String str2, StrokeLineJoin strokeLineJoin, StrokeLineCap strokeLineCap) {
        return new Base(String.format(Locale.US, this.jsBase + ".top(%s, %s, %s, %s, %s)", wrapQuotes(str), number, wrapQuotes(str2), strokeLineJoin != null ? strokeLineJoin.getJsBase() : null, strokeLineCap != null ? strokeLineCap.getJsBase() : null));
    }
}
