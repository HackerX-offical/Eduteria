package com.anychart.core.resource.resourcelist;

import com.anychart.APIlib;
import com.anychart.core.utils.Margin;
import com.anychart.graphics.vector.image.Align;
import com.anychart.graphics.vector.image.Fitting;
import java.util.Arrays;
import java.util.Locale;

/* JADX INFO: loaded from: classes5.dex */
public class ImageSettings extends SettingsWithMargin {
    protected ImageSettings() {
    }

    public static ImageSettings instantiate() {
        return new ImageSettings("new anychart.core.resource.resourceList.imageSettings()");
    }

    public ImageSettings(String str) {
        StringBuilder sb = new StringBuilder("imageSettings");
        int i = variableIndex + 1;
        variableIndex = i;
        this.jsBase = sb.append(i).toString();
        APIlib.getInstance().addJSLine(this.jsBase + " = " + str + ";");
    }

    @Override // com.anychart.core.resource.resourcelist.SettingsWithMargin, com.anychart.JsObject
    public String getJsBase() {
        return this.jsBase;
    }

    public void align() {
        APIlib.getInstance().addJSLine(this.jsBase + ".align();");
    }

    public ImageSettings align(String str) {
        APIlib.getInstance().addJSLine(String.format(Locale.US, this.jsBase + ".align(%s);", wrapQuotes(str)));
        return this;
    }

    public ImageSettings align(Align align) {
        APIlib.getInstance().addJSLine(String.format(Locale.US, this.jsBase + ".align(%s);", align != null ? align.getJsBase() : null));
        return this;
    }

    public void borderRadius() {
        APIlib.getInstance().addJSLine(this.jsBase + ".borderRadius();");
    }

    public ImageSettings borderRadius(Number number) {
        APIlib.getInstance().addJSLine(String.format(Locale.US, this.jsBase + ".borderRadius(%s);", number));
        return this;
    }

    public ImageSettings borderRadius(Number[] numberArr) {
        APIlib.getInstance().addJSLine(String.format(Locale.US, this.jsBase + ".borderRadius(%s);", Arrays.toString(numberArr)));
        return this;
    }

    public void fittingMode() {
        APIlib.getInstance().addJSLine(this.jsBase + ".fittingMode();");
    }

    public ImageSettings fittingMode(String str) {
        APIlib.getInstance().addJSLine(String.format(Locale.US, this.jsBase + ".fittingMode(%s);", wrapQuotes(str)));
        return this;
    }

    public ImageSettings fittingMode(Fitting fitting) {
        APIlib.getInstance().addJSLine(String.format(Locale.US, this.jsBase + ".fittingMode(%s);", fitting != null ? fitting.getJsBase() : null));
        return this;
    }

    @Override // com.anychart.core.resource.resourcelist.SettingsWithMargin
    public Margin margin() {
        return new Margin(this.jsBase + ".margin()");
    }

    @Override // com.anychart.core.resource.resourcelist.SettingsWithMargin
    public ImageSettings margin(Number[] numberArr) {
        APIlib.getInstance().addJSLine(String.format(Locale.US, this.jsBase + ".margin(%s);", Arrays.toString(numberArr)));
        return this;
    }

    @Override // com.anychart.core.resource.resourcelist.SettingsWithMargin
    public ImageSettings margin(String[] strArr) {
        APIlib.getInstance().addJSLine(String.format(Locale.US, this.jsBase + ".margin(%s);", arrayToStringWrapQuotes(strArr)));
        return this;
    }

    @Override // com.anychart.core.resource.resourcelist.SettingsWithMargin
    public ImageSettings margin(String str) {
        APIlib.getInstance().addJSLine(String.format(Locale.US, this.jsBase + ".margin(%s);", wrapQuotes(str)));
        return this;
    }

    @Override // com.anychart.core.resource.resourcelist.SettingsWithMargin
    public ImageSettings margin(String str, String str2, String str3, String str4) {
        APIlib.getInstance().addJSLine(String.format(Locale.US, this.jsBase + ".margin(%s, %s, %s, %s);", wrapQuotes(str), wrapQuotes(str2), wrapQuotes(str3), wrapQuotes(str4)));
        return this;
    }

    @Override // com.anychart.core.resource.resourcelist.SettingsWithMargin
    public ImageSettings margin(String str, String str2, String str3, Number number) {
        APIlib.getInstance().addJSLine(String.format(Locale.US, this.jsBase + ".margin(%s, %s, %s, %s);", wrapQuotes(str), wrapQuotes(str2), wrapQuotes(str3), number));
        return this;
    }

    @Override // com.anychart.core.resource.resourcelist.SettingsWithMargin
    public ImageSettings margin(String str, String str2, Number number, String str3) {
        APIlib.getInstance().addJSLine(String.format(Locale.US, this.jsBase + ".margin(%s, %s, %s, %s);", wrapQuotes(str), wrapQuotes(str2), number, wrapQuotes(str3)));
        return this;
    }

    @Override // com.anychart.core.resource.resourcelist.SettingsWithMargin
    public ImageSettings margin(String str, String str2, Number number, Number number2) {
        APIlib.getInstance().addJSLine(String.format(Locale.US, this.jsBase + ".margin(%s, %s, %s, %s);", wrapQuotes(str), wrapQuotes(str2), number, number2));
        return this;
    }

    @Override // com.anychart.core.resource.resourcelist.SettingsWithMargin
    public ImageSettings margin(String str, Number number, String str2, String str3) {
        APIlib.getInstance().addJSLine(String.format(Locale.US, this.jsBase + ".margin(%s, %s, %s, %s);", wrapQuotes(str), number, wrapQuotes(str2), wrapQuotes(str3)));
        return this;
    }

    @Override // com.anychart.core.resource.resourcelist.SettingsWithMargin
    public ImageSettings margin(String str, Number number, String str2, Number number2) {
        APIlib.getInstance().addJSLine(String.format(Locale.US, this.jsBase + ".margin(%s, %s, %s, %s);", wrapQuotes(str), number, wrapQuotes(str2), number2));
        return this;
    }

    @Override // com.anychart.core.resource.resourcelist.SettingsWithMargin
    public ImageSettings margin(String str, Number number, Number number2, String str2) {
        APIlib.getInstance().addJSLine(String.format(Locale.US, this.jsBase + ".margin(%s, %s, %s, %s);", wrapQuotes(str), number, number2, wrapQuotes(str2)));
        return this;
    }

    @Override // com.anychart.core.resource.resourcelist.SettingsWithMargin
    public ImageSettings margin(String str, Number number, Number number2, Number number3) {
        APIlib.getInstance().addJSLine(String.format(Locale.US, this.jsBase + ".margin(%s, %s, %s, %s);", wrapQuotes(str), number, number2, number3));
        return this;
    }

    @Override // com.anychart.core.resource.resourcelist.SettingsWithMargin
    public ImageSettings margin(Number number, String str, String str2, String str3) {
        APIlib.getInstance().addJSLine(String.format(Locale.US, this.jsBase + ".margin(%s, %s, %s, %s);", number, wrapQuotes(str), wrapQuotes(str2), wrapQuotes(str3)));
        return this;
    }

    @Override // com.anychart.core.resource.resourcelist.SettingsWithMargin
    public ImageSettings margin(Number number, String str, String str2, Number number2) {
        APIlib.getInstance().addJSLine(String.format(Locale.US, this.jsBase + ".margin(%s, %s, %s, %s);", number, wrapQuotes(str), wrapQuotes(str2), number2));
        return this;
    }

    @Override // com.anychart.core.resource.resourcelist.SettingsWithMargin
    public ImageSettings margin(Number number, String str, Number number2, String str2) {
        APIlib.getInstance().addJSLine(String.format(Locale.US, this.jsBase + ".margin(%s, %s, %s, %s);", number, wrapQuotes(str), number2, wrapQuotes(str2)));
        return this;
    }

    @Override // com.anychart.core.resource.resourcelist.SettingsWithMargin
    public ImageSettings margin(Number number, String str, Number number2, Number number3) {
        APIlib.getInstance().addJSLine(String.format(Locale.US, this.jsBase + ".margin(%s, %s, %s, %s);", number, wrapQuotes(str), number2, number3));
        return this;
    }

    @Override // com.anychart.core.resource.resourcelist.SettingsWithMargin
    public ImageSettings margin(Number number, Number number2, String str, String str2) {
        APIlib.getInstance().addJSLine(String.format(Locale.US, this.jsBase + ".margin(%s, %s, %s, %s);", number, number2, wrapQuotes(str), wrapQuotes(str2)));
        return this;
    }

    @Override // com.anychart.core.resource.resourcelist.SettingsWithMargin
    public ImageSettings margin(Number number, Number number2, String str, Number number3) {
        APIlib.getInstance().addJSLine(String.format(Locale.US, this.jsBase + ".margin(%s, %s, %s, %s);", number, number2, wrapQuotes(str), number3));
        return this;
    }

    @Override // com.anychart.core.resource.resourcelist.SettingsWithMargin
    public ImageSettings margin(Number number, Number number2, Number number3, String str) {
        APIlib.getInstance().addJSLine(String.format(Locale.US, this.jsBase + ".margin(%s, %s, %s, %s);", number, number2, number3, wrapQuotes(str)));
        return this;
    }

    @Override // com.anychart.core.resource.resourcelist.SettingsWithMargin
    public ImageSettings margin(Number number, Number number2, Number number3, Number number4) {
        APIlib.getInstance().addJSLine(String.format(Locale.US, this.jsBase + ".margin(%s, %s, %s, %s);", number, number2, number3, number4));
        return this;
    }

    public void opacity() {
        APIlib.getInstance().addJSLine(this.jsBase + ".opacity();");
    }

    public ImageSettings opacity(Number number) {
        APIlib.getInstance().addJSLine(String.format(Locale.US, this.jsBase + ".opacity(%s);", number));
        return this;
    }

    public void size() {
        APIlib.getInstance().addJSLine(this.jsBase + ".size();");
    }

    public ImageSettings size(String str) {
        APIlib.getInstance().addJSLine(String.format(Locale.US, this.jsBase + ".size(%s);", wrapQuotes(str)));
        return this;
    }

    public ImageSettings size(Number number) {
        APIlib.getInstance().addJSLine(String.format(Locale.US, this.jsBase + ".size(%s);", number));
        return this;
    }
}
