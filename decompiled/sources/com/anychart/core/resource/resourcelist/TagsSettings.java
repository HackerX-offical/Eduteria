package com.anychart.core.resource.resourcelist;

import com.anychart.APIlib;
import com.anychart.core.ui.Background;
import com.anychart.core.utils.Margin;
import com.anychart.core.utils.Padding;
import com.anychart.enums.WordBreak;
import com.anychart.enums.WordWrap;
import com.anychart.graphics.vector.text.Decoration;
import com.anychart.graphics.vector.text.Direction;
import com.anychart.graphics.vector.text.FontStyle;
import com.anychart.graphics.vector.text.FontVariant;
import com.anychart.graphics.vector.text.HAlign;
import com.anychart.graphics.vector.text.TextOverflow;
import com.anychart.graphics.vector.text.VAlign;
import java.util.Arrays;
import java.util.Locale;

/* JADX INFO: loaded from: classes5.dex */
public class TagsSettings extends TextSettings {
    protected TagsSettings() {
    }

    public static TagsSettings instantiate() {
        return new TagsSettings("new anychart.core.resource.resourceList.tagsSettings()");
    }

    public TagsSettings(String str) {
        StringBuilder sb = new StringBuilder("tagsSettings");
        int i = variableIndex + 1;
        variableIndex = i;
        this.jsBase = sb.append(i).toString();
        APIlib.getInstance().addJSLine(this.jsBase + " = " + str + ";");
    }

    @Override // com.anychart.core.resource.resourcelist.TextSettings, com.anychart.core.resource.resourcelist.SettingsWithMargin, com.anychart.JsObject
    public String getJsBase() {
        return this.jsBase;
    }

    public Background background() {
        return new Background(this.jsBase + ".background()");
    }

    public TagsSettings background(String str) {
        APIlib.getInstance().addJSLine(String.format(Locale.US, this.jsBase + ".background(%s);", wrapQuotes(str)));
        return this;
    }

    public TagsSettings background(Boolean bool) {
        APIlib.getInstance().addJSLine(String.format(Locale.US, this.jsBase + ".background(%s);", bool));
        return this;
    }

    @Override // com.anychart.core.resource.resourcelist.TextSettings
    public void fontColor() {
        APIlib.getInstance().addJSLine(this.jsBase + ".fontColor();");
    }

    @Override // com.anychart.core.resource.resourcelist.TextSettings
    public TagsSettings fontColor(String str) {
        APIlib.getInstance().addJSLine(String.format(Locale.US, this.jsBase + ".fontColor(%s);", wrapQuotes(str)));
        return this;
    }

    @Override // com.anychart.core.resource.resourcelist.TextSettings
    public void fontDecoration() {
        APIlib.getInstance().addJSLine(this.jsBase + ".fontDecoration();");
    }

    @Override // com.anychart.core.resource.resourcelist.TextSettings
    public TagsSettings fontDecoration(Decoration decoration) {
        APIlib.getInstance().addJSLine(String.format(Locale.US, this.jsBase + ".fontDecoration(%s);", decoration != null ? decoration.getJsBase() : null));
        return this;
    }

    @Override // com.anychart.core.resource.resourcelist.TextSettings
    public TagsSettings fontDecoration(String str) {
        APIlib.getInstance().addJSLine(String.format(Locale.US, this.jsBase + ".fontDecoration(%s);", wrapQuotes(str)));
        return this;
    }

    @Override // com.anychart.core.resource.resourcelist.TextSettings
    public void fontFamily() {
        APIlib.getInstance().addJSLine(this.jsBase + ".fontFamily();");
    }

    @Override // com.anychart.core.resource.resourcelist.TextSettings
    public TagsSettings fontFamily(String str) {
        APIlib.getInstance().addJSLine(String.format(Locale.US, this.jsBase + ".fontFamily(%s);", wrapQuotes(str)));
        return this;
    }

    @Override // com.anychart.core.resource.resourcelist.TextSettings
    public void fontOpacity() {
        APIlib.getInstance().addJSLine(this.jsBase + ".fontOpacity();");
    }

    @Override // com.anychart.core.resource.resourcelist.TextSettings
    public TagsSettings fontOpacity(Number number) {
        APIlib.getInstance().addJSLine(String.format(Locale.US, this.jsBase + ".fontOpacity(%s);", number));
        return this;
    }

    @Override // com.anychart.core.resource.resourcelist.TextSettings
    public void fontSize() {
        APIlib.getInstance().addJSLine(this.jsBase + ".fontSize();");
    }

    @Override // com.anychart.core.resource.resourcelist.TextSettings
    public TagsSettings fontSize(String str) {
        APIlib.getInstance().addJSLine(String.format(Locale.US, this.jsBase + ".fontSize(%s);", wrapQuotes(str)));
        return this;
    }

    @Override // com.anychart.core.resource.resourcelist.TextSettings
    public TagsSettings fontSize(Number number) {
        APIlib.getInstance().addJSLine(String.format(Locale.US, this.jsBase + ".fontSize(%s);", number));
        return this;
    }

    @Override // com.anychart.core.resource.resourcelist.TextSettings
    public void fontStyle() {
        APIlib.getInstance().addJSLine(this.jsBase + ".fontStyle();");
    }

    @Override // com.anychart.core.resource.resourcelist.TextSettings
    public TagsSettings fontStyle(FontStyle fontStyle) {
        APIlib.getInstance().addJSLine(String.format(Locale.US, this.jsBase + ".fontStyle(%s);", fontStyle != null ? fontStyle.getJsBase() : null));
        return this;
    }

    @Override // com.anychart.core.resource.resourcelist.TextSettings
    public TagsSettings fontStyle(String str) {
        APIlib.getInstance().addJSLine(String.format(Locale.US, this.jsBase + ".fontStyle(%s);", wrapQuotes(str)));
        return this;
    }

    @Override // com.anychart.core.resource.resourcelist.TextSettings
    public void fontVariant() {
        APIlib.getInstance().addJSLine(this.jsBase + ".fontVariant();");
    }

    @Override // com.anychart.core.resource.resourcelist.TextSettings
    public TagsSettings fontVariant(FontVariant fontVariant) {
        APIlib.getInstance().addJSLine(String.format(Locale.US, this.jsBase + ".fontVariant(%s);", fontVariant != null ? fontVariant.getJsBase() : null));
        return this;
    }

    @Override // com.anychart.core.resource.resourcelist.TextSettings
    public TagsSettings fontVariant(String str) {
        APIlib.getInstance().addJSLine(String.format(Locale.US, this.jsBase + ".fontVariant(%s);", wrapQuotes(str)));
        return this;
    }

    @Override // com.anychart.core.resource.resourcelist.TextSettings
    public void fontWeight() {
        APIlib.getInstance().addJSLine(this.jsBase + ".fontWeight();");
    }

    @Override // com.anychart.core.resource.resourcelist.TextSettings
    public TagsSettings fontWeight(String str) {
        APIlib.getInstance().addJSLine(String.format(Locale.US, this.jsBase + ".fontWeight(%s);", wrapQuotes(str)));
        return this;
    }

    @Override // com.anychart.core.resource.resourcelist.TextSettings
    public TagsSettings fontWeight(Number number) {
        APIlib.getInstance().addJSLine(String.format(Locale.US, this.jsBase + ".fontWeight(%s);", number));
        return this;
    }

    @Override // com.anychart.core.resource.resourcelist.TextSettings
    public void hAlign() {
        APIlib.getInstance().addJSLine(this.jsBase + ".hAlign();");
    }

    @Override // com.anychart.core.resource.resourcelist.TextSettings
    public TagsSettings hAlign(HAlign hAlign) {
        APIlib.getInstance().addJSLine(String.format(Locale.US, this.jsBase + ".hAlign(%s);", hAlign != null ? hAlign.getJsBase() : null));
        return this;
    }

    @Override // com.anychart.core.resource.resourcelist.TextSettings
    public TagsSettings hAlign(String str) {
        APIlib.getInstance().addJSLine(String.format(Locale.US, this.jsBase + ".hAlign(%s);", wrapQuotes(str)));
        return this;
    }

    @Override // com.anychart.core.resource.resourcelist.TextSettings
    public void letterSpacing() {
        APIlib.getInstance().addJSLine(this.jsBase + ".letterSpacing();");
    }

    @Override // com.anychart.core.resource.resourcelist.TextSettings
    public TagsSettings letterSpacing(String str) {
        APIlib.getInstance().addJSLine(String.format(Locale.US, this.jsBase + ".letterSpacing(%s);", wrapQuotes(str)));
        return this;
    }

    @Override // com.anychart.core.resource.resourcelist.TextSettings
    public TagsSettings letterSpacing(Number number) {
        APIlib.getInstance().addJSLine(String.format(Locale.US, this.jsBase + ".letterSpacing(%s);", number));
        return this;
    }

    @Override // com.anychart.core.resource.resourcelist.TextSettings
    public void lineHeight() {
        APIlib.getInstance().addJSLine(this.jsBase + ".lineHeight();");
    }

    @Override // com.anychart.core.resource.resourcelist.TextSettings
    public TagsSettings lineHeight(String str) {
        APIlib.getInstance().addJSLine(String.format(Locale.US, this.jsBase + ".lineHeight(%s);", wrapQuotes(str)));
        return this;
    }

    @Override // com.anychart.core.resource.resourcelist.TextSettings
    public TagsSettings lineHeight(Number number) {
        APIlib.getInstance().addJSLine(String.format(Locale.US, this.jsBase + ".lineHeight(%s);", number));
        return this;
    }

    @Override // com.anychart.core.resource.resourcelist.TextSettings, com.anychart.core.resource.resourcelist.SettingsWithMargin
    public Margin margin() {
        return new Margin(this.jsBase + ".margin()");
    }

    @Override // com.anychart.core.resource.resourcelist.TextSettings, com.anychart.core.resource.resourcelist.SettingsWithMargin
    public TagsSettings margin(Number[] numberArr) {
        APIlib.getInstance().addJSLine(String.format(Locale.US, this.jsBase + ".margin(%s);", Arrays.toString(numberArr)));
        return this;
    }

    @Override // com.anychart.core.resource.resourcelist.TextSettings, com.anychart.core.resource.resourcelist.SettingsWithMargin
    public TagsSettings margin(String[] strArr) {
        APIlib.getInstance().addJSLine(String.format(Locale.US, this.jsBase + ".margin(%s);", arrayToStringWrapQuotes(strArr)));
        return this;
    }

    @Override // com.anychart.core.resource.resourcelist.TextSettings, com.anychart.core.resource.resourcelist.SettingsWithMargin
    public TagsSettings margin(String str) {
        APIlib.getInstance().addJSLine(String.format(Locale.US, this.jsBase + ".margin(%s);", wrapQuotes(str)));
        return this;
    }

    @Override // com.anychart.core.resource.resourcelist.TextSettings, com.anychart.core.resource.resourcelist.SettingsWithMargin
    public TagsSettings margin(String str, String str2, String str3, String str4) {
        APIlib.getInstance().addJSLine(String.format(Locale.US, this.jsBase + ".margin(%s, %s, %s, %s);", wrapQuotes(str), wrapQuotes(str2), wrapQuotes(str3), wrapQuotes(str4)));
        return this;
    }

    @Override // com.anychart.core.resource.resourcelist.TextSettings, com.anychart.core.resource.resourcelist.SettingsWithMargin
    public TagsSettings margin(String str, String str2, String str3, Number number) {
        APIlib.getInstance().addJSLine(String.format(Locale.US, this.jsBase + ".margin(%s, %s, %s, %s);", wrapQuotes(str), wrapQuotes(str2), wrapQuotes(str3), number));
        return this;
    }

    @Override // com.anychart.core.resource.resourcelist.TextSettings, com.anychart.core.resource.resourcelist.SettingsWithMargin
    public TagsSettings margin(String str, String str2, Number number, String str3) {
        APIlib.getInstance().addJSLine(String.format(Locale.US, this.jsBase + ".margin(%s, %s, %s, %s);", wrapQuotes(str), wrapQuotes(str2), number, wrapQuotes(str3)));
        return this;
    }

    @Override // com.anychart.core.resource.resourcelist.TextSettings, com.anychart.core.resource.resourcelist.SettingsWithMargin
    public TagsSettings margin(String str, String str2, Number number, Number number2) {
        APIlib.getInstance().addJSLine(String.format(Locale.US, this.jsBase + ".margin(%s, %s, %s, %s);", wrapQuotes(str), wrapQuotes(str2), number, number2));
        return this;
    }

    @Override // com.anychart.core.resource.resourcelist.TextSettings, com.anychart.core.resource.resourcelist.SettingsWithMargin
    public TagsSettings margin(String str, Number number, String str2, String str3) {
        APIlib.getInstance().addJSLine(String.format(Locale.US, this.jsBase + ".margin(%s, %s, %s, %s);", wrapQuotes(str), number, wrapQuotes(str2), wrapQuotes(str3)));
        return this;
    }

    @Override // com.anychart.core.resource.resourcelist.TextSettings, com.anychart.core.resource.resourcelist.SettingsWithMargin
    public TagsSettings margin(String str, Number number, String str2, Number number2) {
        APIlib.getInstance().addJSLine(String.format(Locale.US, this.jsBase + ".margin(%s, %s, %s, %s);", wrapQuotes(str), number, wrapQuotes(str2), number2));
        return this;
    }

    @Override // com.anychart.core.resource.resourcelist.TextSettings, com.anychart.core.resource.resourcelist.SettingsWithMargin
    public TagsSettings margin(String str, Number number, Number number2, String str2) {
        APIlib.getInstance().addJSLine(String.format(Locale.US, this.jsBase + ".margin(%s, %s, %s, %s);", wrapQuotes(str), number, number2, wrapQuotes(str2)));
        return this;
    }

    @Override // com.anychart.core.resource.resourcelist.TextSettings, com.anychart.core.resource.resourcelist.SettingsWithMargin
    public TagsSettings margin(String str, Number number, Number number2, Number number3) {
        APIlib.getInstance().addJSLine(String.format(Locale.US, this.jsBase + ".margin(%s, %s, %s, %s);", wrapQuotes(str), number, number2, number3));
        return this;
    }

    @Override // com.anychart.core.resource.resourcelist.TextSettings, com.anychart.core.resource.resourcelist.SettingsWithMargin
    public TagsSettings margin(Number number, String str, String str2, String str3) {
        APIlib.getInstance().addJSLine(String.format(Locale.US, this.jsBase + ".margin(%s, %s, %s, %s);", number, wrapQuotes(str), wrapQuotes(str2), wrapQuotes(str3)));
        return this;
    }

    @Override // com.anychart.core.resource.resourcelist.TextSettings, com.anychart.core.resource.resourcelist.SettingsWithMargin
    public TagsSettings margin(Number number, String str, String str2, Number number2) {
        APIlib.getInstance().addJSLine(String.format(Locale.US, this.jsBase + ".margin(%s, %s, %s, %s);", number, wrapQuotes(str), wrapQuotes(str2), number2));
        return this;
    }

    @Override // com.anychart.core.resource.resourcelist.TextSettings, com.anychart.core.resource.resourcelist.SettingsWithMargin
    public TagsSettings margin(Number number, String str, Number number2, String str2) {
        APIlib.getInstance().addJSLine(String.format(Locale.US, this.jsBase + ".margin(%s, %s, %s, %s);", number, wrapQuotes(str), number2, wrapQuotes(str2)));
        return this;
    }

    @Override // com.anychart.core.resource.resourcelist.TextSettings, com.anychart.core.resource.resourcelist.SettingsWithMargin
    public TagsSettings margin(Number number, String str, Number number2, Number number3) {
        APIlib.getInstance().addJSLine(String.format(Locale.US, this.jsBase + ".margin(%s, %s, %s, %s);", number, wrapQuotes(str), number2, number3));
        return this;
    }

    @Override // com.anychart.core.resource.resourcelist.TextSettings, com.anychart.core.resource.resourcelist.SettingsWithMargin
    public TagsSettings margin(Number number, Number number2, String str, String str2) {
        APIlib.getInstance().addJSLine(String.format(Locale.US, this.jsBase + ".margin(%s, %s, %s, %s);", number, number2, wrapQuotes(str), wrapQuotes(str2)));
        return this;
    }

    @Override // com.anychart.core.resource.resourcelist.TextSettings, com.anychart.core.resource.resourcelist.SettingsWithMargin
    public TagsSettings margin(Number number, Number number2, String str, Number number3) {
        APIlib.getInstance().addJSLine(String.format(Locale.US, this.jsBase + ".margin(%s, %s, %s, %s);", number, number2, wrapQuotes(str), number3));
        return this;
    }

    @Override // com.anychart.core.resource.resourcelist.TextSettings, com.anychart.core.resource.resourcelist.SettingsWithMargin
    public TagsSettings margin(Number number, Number number2, Number number3, String str) {
        APIlib.getInstance().addJSLine(String.format(Locale.US, this.jsBase + ".margin(%s, %s, %s, %s);", number, number2, number3, wrapQuotes(str)));
        return this;
    }

    @Override // com.anychart.core.resource.resourcelist.TextSettings, com.anychart.core.resource.resourcelist.SettingsWithMargin
    public TagsSettings margin(Number number, Number number2, Number number3, Number number4) {
        APIlib.getInstance().addJSLine(String.format(Locale.US, this.jsBase + ".margin(%s, %s, %s, %s);", number, number2, number3, number4));
        return this;
    }

    public Padding padding() {
        return new Padding(this.jsBase + ".padding()");
    }

    public TagsSettings padding(Number[] numberArr) {
        APIlib.getInstance().addJSLine(String.format(Locale.US, this.jsBase + ".padding(%s);", Arrays.toString(numberArr)));
        return this;
    }

    public TagsSettings padding(String[] strArr) {
        APIlib.getInstance().addJSLine(String.format(Locale.US, this.jsBase + ".padding(%s);", arrayToStringWrapQuotes(strArr)));
        return this;
    }

    public TagsSettings padding(String str) {
        APIlib.getInstance().addJSLine(String.format(Locale.US, this.jsBase + ".padding(%s);", wrapQuotes(str)));
        return this;
    }

    public TagsSettings padding(String str, String str2, String str3, String str4) {
        APIlib.getInstance().addJSLine(String.format(Locale.US, this.jsBase + ".padding(%s, %s, %s, %s);", wrapQuotes(str), wrapQuotes(str2), wrapQuotes(str3), wrapQuotes(str4)));
        return this;
    }

    public TagsSettings padding(String str, String str2, String str3, Number number) {
        APIlib.getInstance().addJSLine(String.format(Locale.US, this.jsBase + ".padding(%s, %s, %s, %s);", wrapQuotes(str), wrapQuotes(str2), wrapQuotes(str3), number));
        return this;
    }

    public TagsSettings padding(String str, String str2, Number number, String str3) {
        APIlib.getInstance().addJSLine(String.format(Locale.US, this.jsBase + ".padding(%s, %s, %s, %s);", wrapQuotes(str), wrapQuotes(str2), number, wrapQuotes(str3)));
        return this;
    }

    public TagsSettings padding(String str, String str2, Number number, Number number2) {
        APIlib.getInstance().addJSLine(String.format(Locale.US, this.jsBase + ".padding(%s, %s, %s, %s);", wrapQuotes(str), wrapQuotes(str2), number, number2));
        return this;
    }

    public TagsSettings padding(String str, Number number, String str2, String str3) {
        APIlib.getInstance().addJSLine(String.format(Locale.US, this.jsBase + ".padding(%s, %s, %s, %s);", wrapQuotes(str), number, wrapQuotes(str2), wrapQuotes(str3)));
        return this;
    }

    public TagsSettings padding(String str, Number number, String str2, Number number2) {
        APIlib.getInstance().addJSLine(String.format(Locale.US, this.jsBase + ".padding(%s, %s, %s, %s);", wrapQuotes(str), number, wrapQuotes(str2), number2));
        return this;
    }

    public TagsSettings padding(String str, Number number, Number number2, String str2) {
        APIlib.getInstance().addJSLine(String.format(Locale.US, this.jsBase + ".padding(%s, %s, %s, %s);", wrapQuotes(str), number, number2, wrapQuotes(str2)));
        return this;
    }

    public TagsSettings padding(String str, Number number, Number number2, Number number3) {
        APIlib.getInstance().addJSLine(String.format(Locale.US, this.jsBase + ".padding(%s, %s, %s, %s);", wrapQuotes(str), number, number2, number3));
        return this;
    }

    public TagsSettings padding(Number number, String str, String str2, String str3) {
        APIlib.getInstance().addJSLine(String.format(Locale.US, this.jsBase + ".padding(%s, %s, %s, %s);", number, wrapQuotes(str), wrapQuotes(str2), wrapQuotes(str3)));
        return this;
    }

    public TagsSettings padding(Number number, String str, String str2, Number number2) {
        APIlib.getInstance().addJSLine(String.format(Locale.US, this.jsBase + ".padding(%s, %s, %s, %s);", number, wrapQuotes(str), wrapQuotes(str2), number2));
        return this;
    }

    public TagsSettings padding(Number number, String str, Number number2, String str2) {
        APIlib.getInstance().addJSLine(String.format(Locale.US, this.jsBase + ".padding(%s, %s, %s, %s);", number, wrapQuotes(str), number2, wrapQuotes(str2)));
        return this;
    }

    public TagsSettings padding(Number number, String str, Number number2, Number number3) {
        APIlib.getInstance().addJSLine(String.format(Locale.US, this.jsBase + ".padding(%s, %s, %s, %s);", number, wrapQuotes(str), number2, number3));
        return this;
    }

    public TagsSettings padding(Number number, Number number2, String str, String str2) {
        APIlib.getInstance().addJSLine(String.format(Locale.US, this.jsBase + ".padding(%s, %s, %s, %s);", number, number2, wrapQuotes(str), wrapQuotes(str2)));
        return this;
    }

    public TagsSettings padding(Number number, Number number2, String str, Number number3) {
        APIlib.getInstance().addJSLine(String.format(Locale.US, this.jsBase + ".padding(%s, %s, %s, %s);", number, number2, wrapQuotes(str), number3));
        return this;
    }

    public TagsSettings padding(Number number, Number number2, Number number3, String str) {
        APIlib.getInstance().addJSLine(String.format(Locale.US, this.jsBase + ".padding(%s, %s, %s, %s);", number, number2, number3, wrapQuotes(str)));
        return this;
    }

    public TagsSettings padding(Number number, Number number2, Number number3, Number number4) {
        APIlib.getInstance().addJSLine(String.format(Locale.US, this.jsBase + ".padding(%s, %s, %s, %s);", number, number2, number3, number4));
        return this;
    }

    @Override // com.anychart.core.resource.resourcelist.TextSettings
    public void selectable() {
        APIlib.getInstance().addJSLine(this.jsBase + ".selectable();");
    }

    @Override // com.anychart.core.resource.resourcelist.TextSettings
    public TagsSettings selectable(Boolean bool) {
        APIlib.getInstance().addJSLine(String.format(Locale.US, this.jsBase + ".selectable(%s);", bool));
        return this;
    }

    @Override // com.anychart.core.resource.resourcelist.TextSettings
    public void textDirection() {
        APIlib.getInstance().addJSLine(this.jsBase + ".textDirection();");
    }

    @Override // com.anychart.core.resource.resourcelist.TextSettings
    public TagsSettings textDirection(Direction direction) {
        APIlib.getInstance().addJSLine(String.format(Locale.US, this.jsBase + ".textDirection(%s);", direction != null ? direction.getJsBase() : null));
        return this;
    }

    @Override // com.anychart.core.resource.resourcelist.TextSettings
    public TagsSettings textDirection(String str) {
        APIlib.getInstance().addJSLine(String.format(Locale.US, this.jsBase + ".textDirection(%s);", wrapQuotes(str)));
        return this;
    }

    @Override // com.anychart.core.resource.resourcelist.TextSettings
    public void textIndent() {
        APIlib.getInstance().addJSLine(this.jsBase + ".textIndent();");
    }

    @Override // com.anychart.core.resource.resourcelist.TextSettings
    public TagsSettings textIndent(Number number) {
        APIlib.getInstance().addJSLine(String.format(Locale.US, this.jsBase + ".textIndent(%s);", number));
        return this;
    }

    @Override // com.anychart.core.resource.resourcelist.TextSettings
    public void textOverflow() {
        APIlib.getInstance().addJSLine(this.jsBase + ".textOverflow();");
    }

    @Override // com.anychart.core.resource.resourcelist.TextSettings
    public TagsSettings textOverflow(TextOverflow textOverflow) {
        APIlib.getInstance().addJSLine(String.format(Locale.US, this.jsBase + ".textOverflow(%s);", textOverflow != null ? textOverflow.getJsBase() : null));
        return this;
    }

    @Override // com.anychart.core.resource.resourcelist.TextSettings
    public TagsSettings textOverflow(String str) {
        APIlib.getInstance().addJSLine(String.format(Locale.US, this.jsBase + ".textOverflow(%s);", wrapQuotes(str)));
        return this;
    }

    @Override // com.anychart.core.resource.resourcelist.TextSettings
    public void useHtml() {
        APIlib.getInstance().addJSLine(this.jsBase + ".useHtml();");
    }

    @Override // com.anychart.core.resource.resourcelist.TextSettings
    public TagsSettings useHtml(Boolean bool) {
        APIlib.getInstance().addJSLine(String.format(Locale.US, this.jsBase + ".useHtml(%s);", bool));
        return this;
    }

    @Override // com.anychart.core.resource.resourcelist.TextSettings
    public void vAlign() {
        APIlib.getInstance().addJSLine(this.jsBase + ".vAlign();");
    }

    @Override // com.anychart.core.resource.resourcelist.TextSettings
    public TagsSettings vAlign(VAlign vAlign) {
        APIlib.getInstance().addJSLine(String.format(Locale.US, this.jsBase + ".vAlign(%s);", vAlign != null ? vAlign.getJsBase() : null));
        return this;
    }

    @Override // com.anychart.core.resource.resourcelist.TextSettings
    public TagsSettings vAlign(String str) {
        APIlib.getInstance().addJSLine(String.format(Locale.US, this.jsBase + ".vAlign(%s);", wrapQuotes(str)));
        return this;
    }

    @Override // com.anychart.core.resource.resourcelist.TextSettings
    public void wordBreak() {
        APIlib.getInstance().addJSLine(this.jsBase + ".wordBreak();");
    }

    @Override // com.anychart.core.resource.resourcelist.TextSettings
    public TagsSettings wordBreak(WordBreak wordBreak) {
        APIlib.getInstance().addJSLine(String.format(Locale.US, this.jsBase + ".wordBreak(%s);", wordBreak != null ? wordBreak.getJsBase() : null));
        return this;
    }

    @Override // com.anychart.core.resource.resourcelist.TextSettings
    public TagsSettings wordBreak(String str) {
        APIlib.getInstance().addJSLine(String.format(Locale.US, this.jsBase + ".wordBreak(%s);", wrapQuotes(str)));
        return this;
    }

    @Override // com.anychart.core.resource.resourcelist.TextSettings
    public void wordWrap() {
        APIlib.getInstance().addJSLine(this.jsBase + ".wordWrap();");
    }

    @Override // com.anychart.core.resource.resourcelist.TextSettings
    public TagsSettings wordWrap(WordWrap wordWrap) {
        APIlib.getInstance().addJSLine(String.format(Locale.US, this.jsBase + ".wordWrap(%s);", wordWrap != null ? wordWrap.getJsBase() : null));
        return this;
    }

    @Override // com.anychart.core.resource.resourcelist.TextSettings
    public TagsSettings wordWrap(String str) {
        APIlib.getInstance().addJSLine(String.format(Locale.US, this.jsBase + ".wordWrap(%s);", wrapQuotes(str)));
        return this;
    }
}
