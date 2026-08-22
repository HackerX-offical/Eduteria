package com.anychart.core.ui;

import com.amazonaws.services.s3.model.InstructionFileId;
import com.anychart.APIlib;
import com.anychart.chart.common.listener.ListenersInterface;
import com.anychart.core.utils.Padding;
import com.anychart.enums.Anchor;
import com.anychart.enums.WordBreak;
import com.anychart.enums.WordWrap;
import com.anychart.graphics.vector.Layer;
import com.anychart.graphics.vector.PaperSize;
import com.anychart.graphics.vector.Stage;
import com.anychart.graphics.vector.Stroke;
import com.anychart.graphics.vector.StrokeLineCap;
import com.anychart.graphics.vector.StrokeLineJoin;
import com.anychart.graphics.vector.text.Decoration;
import com.anychart.graphics.vector.text.Direction;
import com.anychart.graphics.vector.text.FontStyle;
import com.anychart.graphics.vector.text.FontVariant;
import com.anychart.graphics.vector.text.HAlign;
import com.anychart.graphics.vector.text.TextOverflow;
import com.anychart.graphics.vector.text.VAlign;
import com.anychart.math.Rect;
import java.util.Arrays;
import java.util.Locale;

/* JADX INFO: loaded from: classes5.dex */
public class CircularLabelsFactory extends LabelsFactory {
    protected CircularLabelsFactory() {
    }

    public static CircularLabelsFactory instantiate() {
        return new CircularLabelsFactory("new anychart.core.ui.circularLabelsFactory()");
    }

    public CircularLabelsFactory(String str) {
        StringBuilder sb = new StringBuilder("circularLabelsFactory");
        int i = variableIndex + 1;
        variableIndex = i;
        this.jsBase = sb.append(i).toString();
        APIlib.getInstance().addJSLine(this.jsBase + " = " + str + ";");
    }

    @Override // com.anychart.core.ui.LabelsFactory, com.anychart.core.Text, com.anychart.core.VisualBase, com.anychart.core.Base, com.anychart.JsObject
    public String getJsBase() {
        return this.jsBase;
    }

    @Override // com.anychart.core.ui.LabelsFactory
    public void adjustFontSize() {
        APIlib.getInstance().addJSLine(this.jsBase + ".adjustFontSize();");
    }

    @Override // com.anychart.core.ui.LabelsFactory
    public CircularLabelsFactory adjustFontSize(Boolean bool, Boolean bool2) {
        APIlib.getInstance().addJSLine(String.format(Locale.US, this.jsBase + ".adjustFontSize(%s, %s);", bool, bool2));
        return this;
    }

    @Override // com.anychart.core.ui.LabelsFactory
    public CircularLabelsFactory adjustFontSize(String str) {
        APIlib.getInstance().addJSLine(String.format(Locale.US, this.jsBase + ".adjustFontSize(%s);", wrapQuotes(str)));
        return this;
    }

    @Override // com.anychart.core.ui.LabelsFactory
    public CircularLabelsFactory adjustFontSize(Boolean[] boolArr) {
        APIlib.getInstance().addJSLine(String.format(Locale.US, this.jsBase + ".adjustFontSize(%s);", arrayToString(boolArr)));
        return this;
    }

    @Override // com.anychart.core.ui.LabelsFactory
    public CircularLabelsFactory adjustFontSize(Boolean bool) {
        APIlib.getInstance().addJSLine(String.format(Locale.US, this.jsBase + ".adjustFontSize(%s);", bool));
        return this;
    }

    @Override // com.anychart.core.ui.LabelsFactory
    public void anchor() {
        APIlib.getInstance().addJSLine(this.jsBase + ".anchor();");
    }

    @Override // com.anychart.core.ui.LabelsFactory
    public CircularLabelsFactory anchor(Anchor anchor) {
        APIlib.getInstance().addJSLine(String.format(Locale.US, this.jsBase + ".anchor(%s);", anchor != null ? anchor.getJsBase() : null));
        return this;
    }

    @Override // com.anychart.core.ui.LabelsFactory
    public CircularLabelsFactory anchor(String str) {
        APIlib.getInstance().addJSLine(String.format(Locale.US, this.jsBase + ".anchor(%s);", wrapQuotes(str)));
        return this;
    }

    public void autoRotate() {
        APIlib.getInstance().addJSLine(this.jsBase + ".autoRotate();");
    }

    public CircularLabelsFactory autoRotate(Boolean bool) {
        APIlib.getInstance().addJSLine(String.format(Locale.US, this.jsBase + ".autoRotate(%s);", bool));
        return this;
    }

    @Override // com.anychart.core.ui.LabelsFactory
    public Background background() {
        return new Background(this.jsBase + ".background()");
    }

    @Override // com.anychart.core.ui.LabelsFactory
    public CircularLabelsFactory background(String str) {
        APIlib.getInstance().addJSLine(String.format(Locale.US, this.jsBase + ".background(%s);", wrapQuotes(str)));
        return this;
    }

    @Override // com.anychart.core.ui.LabelsFactory
    public CircularLabelsFactory background(Boolean bool) {
        APIlib.getInstance().addJSLine(String.format(Locale.US, this.jsBase + ".background(%s);", bool));
        return this;
    }

    @Override // com.anychart.core.ui.LabelsFactory, com.anychart.core.Text
    public void disablePointerEvents() {
        APIlib.getInstance().addJSLine(this.jsBase + ".disablePointerEvents();");
    }

    @Override // com.anychart.core.ui.LabelsFactory, com.anychart.core.Text
    public CircularLabelsFactory disablePointerEvents(Boolean bool) {
        APIlib.getInstance().addJSLine(String.format(Locale.US, this.jsBase + ".disablePointerEvents(%s);", bool));
        return this;
    }

    @Override // com.anychart.core.ui.LabelsFactory, com.anychart.core.Text, com.anychart.core.VisualBase
    public void enabled() {
        APIlib.getInstance().addJSLine(this.jsBase + ".enabled();");
    }

    @Override // com.anychart.core.ui.LabelsFactory, com.anychart.core.Text, com.anychart.core.VisualBase
    public CircularLabelsFactory enabled(Boolean bool) {
        APIlib.getInstance().addJSLine(String.format(Locale.US, this.jsBase + ".enabled(%s);", bool));
        return this;
    }

    @Override // com.anychart.core.ui.LabelsFactory, com.anychart.core.Text
    public void fontColor() {
        APIlib.getInstance().addJSLine(this.jsBase + ".fontColor();");
    }

    @Override // com.anychart.core.ui.LabelsFactory, com.anychart.core.Text
    public CircularLabelsFactory fontColor(String str) {
        APIlib.getInstance().addJSLine(String.format(Locale.US, this.jsBase + ".fontColor(%s);", wrapQuotes(str)));
        return this;
    }

    @Override // com.anychart.core.ui.LabelsFactory, com.anychart.core.Text
    public void fontDecoration() {
        APIlib.getInstance().addJSLine(this.jsBase + ".fontDecoration();");
    }

    @Override // com.anychart.core.ui.LabelsFactory, com.anychart.core.Text
    public CircularLabelsFactory fontDecoration(Decoration decoration) {
        APIlib.getInstance().addJSLine(String.format(Locale.US, this.jsBase + ".fontDecoration(%s);", decoration != null ? decoration.getJsBase() : null));
        return this;
    }

    @Override // com.anychart.core.ui.LabelsFactory, com.anychart.core.Text
    public CircularLabelsFactory fontDecoration(String str) {
        APIlib.getInstance().addJSLine(String.format(Locale.US, this.jsBase + ".fontDecoration(%s);", wrapQuotes(str)));
        return this;
    }

    @Override // com.anychart.core.ui.LabelsFactory, com.anychart.core.Text
    public void fontFamily() {
        APIlib.getInstance().addJSLine(this.jsBase + ".fontFamily();");
    }

    @Override // com.anychart.core.ui.LabelsFactory, com.anychart.core.Text
    public CircularLabelsFactory fontFamily(String str) {
        APIlib.getInstance().addJSLine(String.format(Locale.US, this.jsBase + ".fontFamily(%s);", wrapQuotes(str)));
        return this;
    }

    @Override // com.anychart.core.ui.LabelsFactory, com.anychart.core.Text
    public void fontOpacity() {
        APIlib.getInstance().addJSLine(this.jsBase + ".fontOpacity();");
    }

    @Override // com.anychart.core.ui.LabelsFactory, com.anychart.core.Text
    public CircularLabelsFactory fontOpacity(Number number) {
        APIlib.getInstance().addJSLine(String.format(Locale.US, this.jsBase + ".fontOpacity(%s);", number));
        return this;
    }

    @Override // com.anychart.core.ui.LabelsFactory, com.anychart.core.Text
    public void fontSize() {
        APIlib.getInstance().addJSLine(this.jsBase + ".fontSize();");
    }

    @Override // com.anychart.core.ui.LabelsFactory, com.anychart.core.Text
    public CircularLabelsFactory fontSize(String str) {
        APIlib.getInstance().addJSLine(String.format(Locale.US, this.jsBase + ".fontSize(%s);", wrapQuotes(str)));
        return this;
    }

    @Override // com.anychart.core.ui.LabelsFactory, com.anychart.core.Text
    public CircularLabelsFactory fontSize(Number number) {
        APIlib.getInstance().addJSLine(String.format(Locale.US, this.jsBase + ".fontSize(%s);", number));
        return this;
    }

    @Override // com.anychart.core.ui.LabelsFactory, com.anychart.core.Text
    public void fontStyle() {
        APIlib.getInstance().addJSLine(this.jsBase + ".fontStyle();");
    }

    @Override // com.anychart.core.ui.LabelsFactory, com.anychart.core.Text
    public CircularLabelsFactory fontStyle(FontStyle fontStyle) {
        APIlib.getInstance().addJSLine(String.format(Locale.US, this.jsBase + ".fontStyle(%s);", fontStyle != null ? fontStyle.getJsBase() : null));
        return this;
    }

    @Override // com.anychart.core.ui.LabelsFactory, com.anychart.core.Text
    public CircularLabelsFactory fontStyle(String str) {
        APIlib.getInstance().addJSLine(String.format(Locale.US, this.jsBase + ".fontStyle(%s);", wrapQuotes(str)));
        return this;
    }

    @Override // com.anychart.core.ui.LabelsFactory, com.anychart.core.Text
    public void fontVariant() {
        APIlib.getInstance().addJSLine(this.jsBase + ".fontVariant();");
    }

    @Override // com.anychart.core.ui.LabelsFactory, com.anychart.core.Text
    public CircularLabelsFactory fontVariant(FontVariant fontVariant) {
        APIlib.getInstance().addJSLine(String.format(Locale.US, this.jsBase + ".fontVariant(%s);", fontVariant != null ? fontVariant.getJsBase() : null));
        return this;
    }

    @Override // com.anychart.core.ui.LabelsFactory, com.anychart.core.Text
    public CircularLabelsFactory fontVariant(String str) {
        APIlib.getInstance().addJSLine(String.format(Locale.US, this.jsBase + ".fontVariant(%s);", wrapQuotes(str)));
        return this;
    }

    @Override // com.anychart.core.ui.LabelsFactory, com.anychart.core.Text
    public void fontWeight() {
        APIlib.getInstance().addJSLine(this.jsBase + ".fontWeight();");
    }

    @Override // com.anychart.core.ui.LabelsFactory, com.anychart.core.Text
    public CircularLabelsFactory fontWeight(String str) {
        APIlib.getInstance().addJSLine(String.format(Locale.US, this.jsBase + ".fontWeight(%s);", wrapQuotes(str)));
        return this;
    }

    @Override // com.anychart.core.ui.LabelsFactory, com.anychart.core.Text
    public CircularLabelsFactory fontWeight(Number number) {
        APIlib.getInstance().addJSLine(String.format(Locale.US, this.jsBase + ".fontWeight(%s);", number));
        return this;
    }

    @Override // com.anychart.core.ui.LabelsFactory, com.anychart.core.Text
    public void hAlign() {
        APIlib.getInstance().addJSLine(this.jsBase + ".hAlign();");
    }

    @Override // com.anychart.core.ui.LabelsFactory, com.anychart.core.Text
    public CircularLabelsFactory hAlign(HAlign hAlign) {
        APIlib.getInstance().addJSLine(String.format(Locale.US, this.jsBase + ".hAlign(%s);", hAlign != null ? hAlign.getJsBase() : null));
        return this;
    }

    @Override // com.anychart.core.ui.LabelsFactory, com.anychart.core.Text
    public CircularLabelsFactory hAlign(String str) {
        APIlib.getInstance().addJSLine(String.format(Locale.US, this.jsBase + ".hAlign(%s);", wrapQuotes(str)));
        return this;
    }

    @Override // com.anychart.core.ui.LabelsFactory
    public void height() {
        APIlib.getInstance().addJSLine(this.jsBase + ".height();");
    }

    @Override // com.anychart.core.ui.LabelsFactory
    public CircularLabelsFactory height(Number number) {
        APIlib.getInstance().addJSLine(String.format(Locale.US, this.jsBase + ".height(%s);", number));
        return this;
    }

    @Override // com.anychart.core.ui.LabelsFactory
    public CircularLabelsFactory height(String str) {
        APIlib.getInstance().addJSLine(String.format(Locale.US, this.jsBase + ".height(%s);", wrapQuotes(str)));
        return this;
    }

    @Override // com.anychart.core.ui.LabelsFactory, com.anychart.core.Text
    public void letterSpacing() {
        APIlib.getInstance().addJSLine(this.jsBase + ".letterSpacing();");
    }

    @Override // com.anychart.core.ui.LabelsFactory, com.anychart.core.Text
    public CircularLabelsFactory letterSpacing(String str) {
        APIlib.getInstance().addJSLine(String.format(Locale.US, this.jsBase + ".letterSpacing(%s);", wrapQuotes(str)));
        return this;
    }

    @Override // com.anychart.core.ui.LabelsFactory, com.anychart.core.Text
    public CircularLabelsFactory letterSpacing(Number number) {
        APIlib.getInstance().addJSLine(String.format(Locale.US, this.jsBase + ".letterSpacing(%s);", number));
        return this;
    }

    @Override // com.anychart.core.ui.LabelsFactory, com.anychart.core.Text
    public void lineHeight() {
        APIlib.getInstance().addJSLine(this.jsBase + ".lineHeight();");
    }

    @Override // com.anychart.core.ui.LabelsFactory, com.anychart.core.Text
    public CircularLabelsFactory lineHeight(String str) {
        APIlib.getInstance().addJSLine(String.format(Locale.US, this.jsBase + ".lineHeight(%s);", wrapQuotes(str)));
        return this;
    }

    @Override // com.anychart.core.ui.LabelsFactory, com.anychart.core.Text
    public CircularLabelsFactory lineHeight(Number number) {
        APIlib.getInstance().addJSLine(String.format(Locale.US, this.jsBase + ".lineHeight(%s);", number));
        return this;
    }

    @Override // com.anychart.core.ui.LabelsFactory
    public void maxFontSize() {
        APIlib.getInstance().addJSLine(this.jsBase + ".maxFontSize();");
    }

    @Override // com.anychart.core.ui.LabelsFactory
    public CircularLabelsFactory maxFontSize(Number number) {
        APIlib.getInstance().addJSLine(String.format(Locale.US, this.jsBase + ".maxFontSize(%s);", number));
        return this;
    }

    @Override // com.anychart.core.ui.LabelsFactory
    public CircularLabelsFactory maxFontSize(String str) {
        APIlib.getInstance().addJSLine(String.format(Locale.US, this.jsBase + ".maxFontSize(%s);", wrapQuotes(str)));
        return this;
    }

    @Override // com.anychart.core.ui.LabelsFactory
    public void minFontSize() {
        APIlib.getInstance().addJSLine(this.jsBase + ".minFontSize();");
    }

    @Override // com.anychart.core.ui.LabelsFactory
    public CircularLabelsFactory minFontSize(Number number) {
        APIlib.getInstance().addJSLine(String.format(Locale.US, this.jsBase + ".minFontSize(%s);", number));
        return this;
    }

    @Override // com.anychart.core.ui.LabelsFactory
    public CircularLabelsFactory minFontSize(String str) {
        APIlib.getInstance().addJSLine(String.format(Locale.US, this.jsBase + ".minFontSize(%s);", wrapQuotes(str)));
        return this;
    }

    @Override // com.anychart.core.ui.LabelsFactory
    public void offsetX() {
        APIlib.getInstance().addJSLine(this.jsBase + ".offsetX();");
    }

    @Override // com.anychart.core.ui.LabelsFactory
    public CircularLabelsFactory offsetX(Number number) {
        APIlib.getInstance().addJSLine(String.format(Locale.US, this.jsBase + ".offsetX(%s);", number));
        return this;
    }

    @Override // com.anychart.core.ui.LabelsFactory
    public CircularLabelsFactory offsetX(String str) {
        APIlib.getInstance().addJSLine(String.format(Locale.US, this.jsBase + ".offsetX(%s);", wrapQuotes(str)));
        return this;
    }

    @Override // com.anychart.core.ui.LabelsFactory
    public void offsetY() {
        APIlib.getInstance().addJSLine(this.jsBase + ".offsetY();");
    }

    @Override // com.anychart.core.ui.LabelsFactory
    public CircularLabelsFactory offsetY(Number number) {
        APIlib.getInstance().addJSLine(String.format(Locale.US, this.jsBase + ".offsetY(%s);", number));
        return this;
    }

    @Override // com.anychart.core.ui.LabelsFactory
    public CircularLabelsFactory offsetY(String str) {
        APIlib.getInstance().addJSLine(String.format(Locale.US, this.jsBase + ".offsetY(%s);", wrapQuotes(str)));
        return this;
    }

    @Override // com.anychart.core.ui.LabelsFactory
    public Padding padding() {
        return new Padding(this.jsBase + ".padding()");
    }

    @Override // com.anychart.core.ui.LabelsFactory
    public CircularLabelsFactory padding(Number[] numberArr) {
        APIlib.getInstance().addJSLine(String.format(Locale.US, this.jsBase + ".padding(%s);", Arrays.toString(numberArr)));
        return this;
    }

    @Override // com.anychart.core.ui.LabelsFactory
    public CircularLabelsFactory padding(String[] strArr) {
        APIlib.getInstance().addJSLine(String.format(Locale.US, this.jsBase + ".padding(%s);", arrayToStringWrapQuotes(strArr)));
        return this;
    }

    @Override // com.anychart.core.ui.LabelsFactory
    public CircularLabelsFactory padding(String str) {
        APIlib.getInstance().addJSLine(String.format(Locale.US, this.jsBase + ".padding(%s);", wrapQuotes(str)));
        return this;
    }

    @Override // com.anychart.core.ui.LabelsFactory
    public CircularLabelsFactory padding(Number number) {
        APIlib.getInstance().addJSLine(String.format(Locale.US, this.jsBase + ".padding(%s);", number));
        return this;
    }

    @Override // com.anychart.core.ui.LabelsFactory
    public CircularLabelsFactory padding(String str, String str2, String str3, String str4) {
        APIlib.getInstance().addJSLine(String.format(Locale.US, this.jsBase + ".padding(%s, %s, %s, %s);", wrapQuotes(str), wrapQuotes(str2), wrapQuotes(str3), wrapQuotes(str4)));
        return this;
    }

    @Override // com.anychart.core.ui.LabelsFactory
    public CircularLabelsFactory padding(String str, String str2, String str3, Number number) {
        APIlib.getInstance().addJSLine(String.format(Locale.US, this.jsBase + ".padding(%s, %s, %s, %s);", wrapQuotes(str), wrapQuotes(str2), wrapQuotes(str3), number));
        return this;
    }

    @Override // com.anychart.core.ui.LabelsFactory
    public CircularLabelsFactory padding(String str, String str2, Number number, String str3) {
        APIlib.getInstance().addJSLine(String.format(Locale.US, this.jsBase + ".padding(%s, %s, %s, %s);", wrapQuotes(str), wrapQuotes(str2), number, wrapQuotes(str3)));
        return this;
    }

    @Override // com.anychart.core.ui.LabelsFactory
    public CircularLabelsFactory padding(String str, String str2, Number number, Number number2) {
        APIlib.getInstance().addJSLine(String.format(Locale.US, this.jsBase + ".padding(%s, %s, %s, %s);", wrapQuotes(str), wrapQuotes(str2), number, number2));
        return this;
    }

    @Override // com.anychart.core.ui.LabelsFactory
    public CircularLabelsFactory padding(String str, Number number, String str2, String str3) {
        APIlib.getInstance().addJSLine(String.format(Locale.US, this.jsBase + ".padding(%s, %s, %s, %s);", wrapQuotes(str), number, wrapQuotes(str2), wrapQuotes(str3)));
        return this;
    }

    @Override // com.anychart.core.ui.LabelsFactory
    public CircularLabelsFactory padding(String str, Number number, String str2, Number number2) {
        APIlib.getInstance().addJSLine(String.format(Locale.US, this.jsBase + ".padding(%s, %s, %s, %s);", wrapQuotes(str), number, wrapQuotes(str2), number2));
        return this;
    }

    @Override // com.anychart.core.ui.LabelsFactory
    public CircularLabelsFactory padding(String str, Number number, Number number2, String str2) {
        APIlib.getInstance().addJSLine(String.format(Locale.US, this.jsBase + ".padding(%s, %s, %s, %s);", wrapQuotes(str), number, number2, wrapQuotes(str2)));
        return this;
    }

    @Override // com.anychart.core.ui.LabelsFactory
    public CircularLabelsFactory padding(String str, Number number, Number number2, Number number3) {
        APIlib.getInstance().addJSLine(String.format(Locale.US, this.jsBase + ".padding(%s, %s, %s, %s);", wrapQuotes(str), number, number2, number3));
        return this;
    }

    @Override // com.anychart.core.ui.LabelsFactory
    public CircularLabelsFactory padding(Number number, String str, String str2, String str3) {
        APIlib.getInstance().addJSLine(String.format(Locale.US, this.jsBase + ".padding(%s, %s, %s, %s);", number, wrapQuotes(str), wrapQuotes(str2), wrapQuotes(str3)));
        return this;
    }

    @Override // com.anychart.core.ui.LabelsFactory
    public CircularLabelsFactory padding(Number number, String str, String str2, Number number2) {
        APIlib.getInstance().addJSLine(String.format(Locale.US, this.jsBase + ".padding(%s, %s, %s, %s);", number, wrapQuotes(str), wrapQuotes(str2), number2));
        return this;
    }

    @Override // com.anychart.core.ui.LabelsFactory
    public CircularLabelsFactory padding(Number number, String str, Number number2, String str2) {
        APIlib.getInstance().addJSLine(String.format(Locale.US, this.jsBase + ".padding(%s, %s, %s, %s);", number, wrapQuotes(str), number2, wrapQuotes(str2)));
        return this;
    }

    @Override // com.anychart.core.ui.LabelsFactory
    public CircularLabelsFactory padding(Number number, String str, Number number2, Number number3) {
        APIlib.getInstance().addJSLine(String.format(Locale.US, this.jsBase + ".padding(%s, %s, %s, %s);", number, wrapQuotes(str), number2, number3));
        return this;
    }

    @Override // com.anychart.core.ui.LabelsFactory
    public CircularLabelsFactory padding(Number number, Number number2, String str, String str2) {
        APIlib.getInstance().addJSLine(String.format(Locale.US, this.jsBase + ".padding(%s, %s, %s, %s);", number, number2, wrapQuotes(str), wrapQuotes(str2)));
        return this;
    }

    @Override // com.anychart.core.ui.LabelsFactory
    public CircularLabelsFactory padding(Number number, Number number2, String str, Number number3) {
        APIlib.getInstance().addJSLine(String.format(Locale.US, this.jsBase + ".padding(%s, %s, %s, %s);", number, number2, wrapQuotes(str), number3));
        return this;
    }

    @Override // com.anychart.core.ui.LabelsFactory
    public CircularLabelsFactory padding(Number number, Number number2, Number number3, String str) {
        APIlib.getInstance().addJSLine(String.format(Locale.US, this.jsBase + ".padding(%s, %s, %s, %s);", number, number2, number3, wrapQuotes(str)));
        return this;
    }

    @Override // com.anychart.core.ui.LabelsFactory
    public CircularLabelsFactory padding(Number number, Number number2, Number number3, Number number4) {
        APIlib.getInstance().addJSLine(String.format(Locale.US, this.jsBase + ".padding(%s, %s, %s, %s);", number, number2, number3, number4));
        return this;
    }

    @Override // com.anychart.core.ui.LabelsFactory
    public void position() {
        APIlib.getInstance().addJSLine(this.jsBase + ".position();");
    }

    @Override // com.anychart.core.ui.LabelsFactory
    public CircularLabelsFactory position(String str) {
        APIlib.getInstance().addJSLine(String.format(Locale.US, this.jsBase + ".position(%s);", wrapQuotes(str)));
        return this;
    }

    @Override // com.anychart.core.ui.LabelsFactory
    public void positionFormatter() {
        APIlib.getInstance().addJSLine(this.jsBase + ".positionFormatter();");
    }

    @Override // com.anychart.core.ui.LabelsFactory
    public CircularLabelsFactory positionFormatter(String str) {
        APIlib.getInstance().addJSLine(String.format(Locale.US, this.jsBase + ".positionFormatter(%s);", wrapQuotes(str)));
        return this;
    }

    @Override // com.anychart.core.ui.LabelsFactory, com.anychart.core.Text, com.anychart.core.VisualBase
    public void print(PaperSize paperSize, Boolean bool) {
        APIlib.getInstance().addJSLine(String.format(Locale.US, this.jsBase + ".print(%s, %s);", paperSize != null ? paperSize.getJsBase() : null, bool));
    }

    @Override // com.anychart.core.ui.LabelsFactory, com.anychart.core.Text, com.anychart.core.VisualBase
    public void print(String str, Boolean bool) {
        APIlib.getInstance().addJSLine(String.format(Locale.US, this.jsBase + ".print(%s, %s);", wrapQuotes(str), bool));
    }

    @Override // com.anychart.core.ui.LabelsFactory, com.anychart.core.Text, com.anychart.core.VisualBase, com.anychart.core.Base
    public void removeAllListeners(String str) {
        APIlib.getInstance().addJSLine(String.format(Locale.US, this.jsBase + ".removeAllListeners(%s);", wrapQuotes(str)));
    }

    @Override // com.anychart.core.ui.LabelsFactory
    public void rotation() {
        APIlib.getInstance().addJSLine(this.jsBase + ".rotation();");
    }

    @Override // com.anychart.core.ui.LabelsFactory
    public CircularLabelsFactory rotation(Number number) {
        APIlib.getInstance().addJSLine(String.format(Locale.US, this.jsBase + ".rotation(%s);", number));
        return this;
    }

    @Override // com.anychart.core.ui.LabelsFactory, com.anychart.core.Text
    public void selectable() {
        APIlib.getInstance().addJSLine(this.jsBase + ".selectable();");
    }

    @Override // com.anychart.core.ui.LabelsFactory, com.anychart.core.Text
    public CircularLabelsFactory selectable(Boolean bool) {
        APIlib.getInstance().addJSLine(String.format(Locale.US, this.jsBase + ".selectable(%s);", bool));
        return this;
    }

    @Override // com.anychart.core.ui.LabelsFactory, com.anychart.core.Text
    public void textDirection() {
        APIlib.getInstance().addJSLine(this.jsBase + ".textDirection();");
    }

    @Override // com.anychart.core.ui.LabelsFactory, com.anychart.core.Text
    public CircularLabelsFactory textDirection(Direction direction) {
        APIlib.getInstance().addJSLine(String.format(Locale.US, this.jsBase + ".textDirection(%s);", direction != null ? direction.getJsBase() : null));
        return this;
    }

    @Override // com.anychart.core.ui.LabelsFactory, com.anychart.core.Text
    public CircularLabelsFactory textDirection(String str) {
        APIlib.getInstance().addJSLine(String.format(Locale.US, this.jsBase + ".textDirection(%s);", wrapQuotes(str)));
        return this;
    }

    @Override // com.anychart.core.ui.LabelsFactory, com.anychart.core.Text
    public void textIndent() {
        APIlib.getInstance().addJSLine(this.jsBase + ".textIndent();");
    }

    @Override // com.anychart.core.ui.LabelsFactory, com.anychart.core.Text
    public CircularLabelsFactory textIndent(Number number) {
        APIlib.getInstance().addJSLine(String.format(Locale.US, this.jsBase + ".textIndent(%s);", number));
        return this;
    }

    @Override // com.anychart.core.ui.LabelsFactory, com.anychart.core.Text
    public void textOverflow() {
        APIlib.getInstance().addJSLine(this.jsBase + ".textOverflow();");
    }

    @Override // com.anychart.core.ui.LabelsFactory, com.anychart.core.Text
    public CircularLabelsFactory textOverflow(TextOverflow textOverflow) {
        APIlib.getInstance().addJSLine(String.format(Locale.US, this.jsBase + ".textOverflow(%s);", textOverflow != null ? textOverflow.getJsBase() : null));
        return this;
    }

    @Override // com.anychart.core.ui.LabelsFactory, com.anychart.core.Text
    public CircularLabelsFactory textOverflow(String str) {
        APIlib.getInstance().addJSLine(String.format(Locale.US, this.jsBase + ".textOverflow(%s);", wrapQuotes(str)));
        return this;
    }

    @Override // com.anychart.core.ui.LabelsFactory, com.anychart.core.Text
    public void textSettings() {
        APIlib.getInstance().addJSLine(this.jsBase + ".textSettings();");
    }

    @Override // com.anychart.core.ui.LabelsFactory, com.anychart.core.Text
    public void textSettings(String str) {
        APIlib.getInstance().addJSLine(String.format(Locale.US, this.jsBase + ".textSettings(%s);", wrapQuotes(str)));
    }

    @Override // com.anychart.core.ui.LabelsFactory, com.anychart.core.Text
    public CircularLabelsFactory textSettings(String str, String str2) {
        APIlib.getInstance().addJSLine(String.format(Locale.US, this.jsBase + ".textSettings(%s, %s);", wrapQuotes(str), wrapQuotes(str2)));
        return this;
    }

    @Override // com.anychart.core.ui.LabelsFactory, com.anychart.core.Text
    public CircularLabelsFactory textSettings(String str, Number number) {
        APIlib.getInstance().addJSLine(String.format(Locale.US, this.jsBase + ".textSettings(%s, %s);", wrapQuotes(str), number));
        return this;
    }

    @Override // com.anychart.core.ui.LabelsFactory, com.anychart.core.Text
    public CircularLabelsFactory textSettings(String str, Boolean bool) {
        APIlib.getInstance().addJSLine(String.format(Locale.US, this.jsBase + ".textSettings(%s, %s);", wrapQuotes(str), bool));
        return this;
    }

    @Override // com.anychart.core.ui.LabelsFactory, com.anychart.core.Text, com.anychart.core.VisualBase, com.anychart.core.Base
    public void setOnClickListener(ListenersInterface.OnClickListener onClickListener) {
        StringBuilder sb = new StringBuilder();
        sb.append(this.jsBase).append(".listen('pointClick', function(e) {");
        if (onClickListener.getFields() != null) {
            sb.append("var result = ");
            for (String str : onClickListener.getFields()) {
                sb.append(String.format(Locale.US, "'%1$s' + ':' + e.point.get('%1$s') + ',' +", str));
            }
            sb.setLength(sb.length() - 8);
            sb.append(";");
            sb.append("android.onClick(result);");
        } else {
            sb.append("android.onClick(null);");
        }
        sb.append("});");
        ListenersInterface.getInstance().setOnClickListener(onClickListener);
        APIlib.getInstance().addJSLine(sb.toString());
    }

    @Override // com.anychart.core.ui.LabelsFactory, com.anychart.core.Text, com.anychart.core.VisualBase, com.anychart.core.Base
    public void setOnClickListener(ListenersInterface.OnClickListener onClickListener, String str, String str2) {
        StringBuilder sb = new StringBuilder();
        sb.append(this.jsBase).append(String.format(Locale.US, ".listen('%1$s', function(e) {", str));
        if (onClickListener.getFields() != null) {
            String str3 = str2 != null ? str2 + InstructionFileId.DOT : "";
            sb.append("var result = ");
            for (String str4 : onClickListener.getFields()) {
                sb.append(String.format(Locale.US, "'%1$s' + ':' + e.%2$s%1$s + ',' +", str4, str3));
            }
            sb.setLength(sb.length() - 8);
            sb.append(";");
            sb.append("android.onClick(result);");
        } else {
            sb.append("android.onClick(null);");
        }
        sb.append("});");
        ListenersInterface.getInstance().setOnClickListener(onClickListener);
        APIlib.getInstance().addJSLine(sb.toString());
    }

    @Override // com.anychart.core.ui.LabelsFactory, com.anychart.core.Text, com.anychart.core.VisualBase, com.anychart.core.Base
    public void unlistenByKey(String str) {
        APIlib.getInstance().addJSLine(String.format(Locale.US, this.jsBase + ".unlistenByKey(%s);", wrapQuotes(str)));
    }

    @Override // com.anychart.core.ui.LabelsFactory, com.anychart.core.Text
    public void useHtml() {
        APIlib.getInstance().addJSLine(this.jsBase + ".useHtml();");
    }

    @Override // com.anychart.core.ui.LabelsFactory, com.anychart.core.Text
    public CircularLabelsFactory useHtml(Boolean bool) {
        APIlib.getInstance().addJSLine(String.format(Locale.US, this.jsBase + ".useHtml(%s);", bool));
        return this;
    }

    @Override // com.anychart.core.ui.LabelsFactory, com.anychart.core.Text
    public void vAlign() {
        APIlib.getInstance().addJSLine(this.jsBase + ".vAlign();");
    }

    @Override // com.anychart.core.ui.LabelsFactory, com.anychart.core.Text
    public CircularLabelsFactory vAlign(VAlign vAlign) {
        APIlib.getInstance().addJSLine(String.format(Locale.US, this.jsBase + ".vAlign(%s);", vAlign != null ? vAlign.getJsBase() : null));
        return this;
    }

    @Override // com.anychart.core.ui.LabelsFactory, com.anychart.core.Text
    public CircularLabelsFactory vAlign(String str) {
        APIlib.getInstance().addJSLine(String.format(Locale.US, this.jsBase + ".vAlign(%s);", wrapQuotes(str)));
        return this;
    }

    @Override // com.anychart.core.ui.LabelsFactory
    public void width() {
        APIlib.getInstance().addJSLine(this.jsBase + ".width();");
    }

    @Override // com.anychart.core.ui.LabelsFactory
    public CircularLabelsFactory width(Number number) {
        APIlib.getInstance().addJSLine(String.format(Locale.US, this.jsBase + ".width(%s);", number));
        return this;
    }

    @Override // com.anychart.core.ui.LabelsFactory
    public CircularLabelsFactory width(String str) {
        APIlib.getInstance().addJSLine(String.format(Locale.US, this.jsBase + ".width(%s);", wrapQuotes(str)));
        return this;
    }

    @Override // com.anychart.core.ui.LabelsFactory, com.anychart.core.Text
    public void wordBreak() {
        APIlib.getInstance().addJSLine(this.jsBase + ".wordBreak();");
    }

    @Override // com.anychart.core.ui.LabelsFactory, com.anychart.core.Text
    public CircularLabelsFactory wordBreak(WordBreak wordBreak) {
        APIlib.getInstance().addJSLine(String.format(Locale.US, this.jsBase + ".wordBreak(%s);", wordBreak != null ? wordBreak.getJsBase() : null));
        return this;
    }

    @Override // com.anychart.core.ui.LabelsFactory, com.anychart.core.Text
    public CircularLabelsFactory wordBreak(String str) {
        APIlib.getInstance().addJSLine(String.format(Locale.US, this.jsBase + ".wordBreak(%s);", wrapQuotes(str)));
        return this;
    }

    @Override // com.anychart.core.ui.LabelsFactory, com.anychart.core.Text
    public void wordWrap() {
        APIlib.getInstance().addJSLine(this.jsBase + ".wordWrap();");
    }

    @Override // com.anychart.core.ui.LabelsFactory, com.anychart.core.Text
    public CircularLabelsFactory wordWrap(WordWrap wordWrap) {
        APIlib.getInstance().addJSLine(String.format(Locale.US, this.jsBase + ".wordWrap(%s);", wordWrap != null ? wordWrap.getJsBase() : null));
        return this;
    }

    @Override // com.anychart.core.ui.LabelsFactory, com.anychart.core.Text
    public CircularLabelsFactory wordWrap(String str) {
        APIlib.getInstance().addJSLine(String.format(Locale.US, this.jsBase + ".wordWrap(%s);", wrapQuotes(str)));
        return this;
    }

    @Override // com.anychart.core.ui.LabelsFactory, com.anychart.core.Text, com.anychart.core.VisualBase
    public void zIndex() {
        APIlib.getInstance().addJSLine(this.jsBase + ".zIndex();");
    }

    @Override // com.anychart.core.ui.LabelsFactory, com.anychart.core.Text, com.anychart.core.VisualBase
    public CircularLabelsFactory zIndex(Number number) {
        APIlib.getInstance().addJSLine(String.format(Locale.US, this.jsBase + ".zIndex(%s);", number));
        return this;
    }

    @Override // com.anychart.core.ui.LabelsFactory
    public void connectorStroke() {
        APIlib.getInstance().addJSLine(this.jsBase + ".connectorStroke();");
    }

    @Override // com.anychart.core.ui.LabelsFactory
    public CircularLabelsFactory connectorStroke(Stroke stroke, Number number, String str, StrokeLineJoin strokeLineJoin, StrokeLineCap strokeLineCap) {
        APIlib.getInstance().addJSLine(String.format(Locale.US, this.jsBase + ".connectorStroke(%s, %s, %s, %s, %s);", stroke != null ? stroke.getJsBase() : null, number, wrapQuotes(str), strokeLineJoin != null ? strokeLineJoin.getJsBase() : null, strokeLineCap != null ? strokeLineCap.getJsBase() : null));
        return this;
    }

    @Override // com.anychart.core.ui.LabelsFactory
    public CircularLabelsFactory connectorStroke(String str, Number number, String str2, StrokeLineJoin strokeLineJoin, StrokeLineCap strokeLineCap) {
        APIlib.getInstance().addJSLine(String.format(Locale.US, this.jsBase + ".connectorStroke(%s, %s, %s, %s, %s);", wrapQuotes(str), number, wrapQuotes(str2), strokeLineJoin != null ? strokeLineJoin.getJsBase() : null, strokeLineCap != null ? strokeLineCap.getJsBase() : null));
        return this;
    }

    @Override // com.anychart.core.ui.LabelsFactory
    public CircularLabelsFactory connectorStroke(String str) {
        APIlib.getInstance().addJSLine(String.format(Locale.US, this.jsBase + ".connectorStroke(%s);", wrapQuotes(str)));
        return this;
    }

    @Override // com.anychart.core.ui.LabelsFactory
    public void format() {
        APIlib.getInstance().addJSLine(this.jsBase + ".format();");
    }

    @Override // com.anychart.core.ui.LabelsFactory
    public CircularLabelsFactory format(String str) {
        APIlib.getInstance().addJSLine(String.format(Locale.US, this.jsBase + ".format(%s);", wrapQuotes(str)));
        return this;
    }

    @Override // com.anychart.core.ui.LabelsFactory
    public com.anychart.core.ui.labelsfactory.Label getLabel(Number number) {
        return new com.anychart.core.ui.labelsfactory.Label(String.format(Locale.US, this.jsBase + ".getLabel(%s)", number));
    }

    @Override // com.anychart.core.ui.LabelsFactory
    public void getLabelsCount() {
        APIlib.getInstance().addJSLine(this.jsBase + ".getLabelsCount();");
    }

    @Override // com.anychart.core.ui.LabelsFactory, com.anychart.core.Text, com.anychart.core.VisualBase
    public Layer container() {
        return new Layer(this.jsBase + ".container()");
    }

    @Override // com.anychart.core.ui.LabelsFactory, com.anychart.core.Text, com.anychart.core.VisualBase
    public CircularLabelsFactory container(Layer layer) {
        APIlib.getInstance().addJSLine(String.format(Locale.US, this.jsBase + ".container(%s);", layer != null ? layer.getJsBase() : null));
        return this;
    }

    @Override // com.anychart.core.ui.LabelsFactory, com.anychart.core.Text, com.anychart.core.VisualBase
    public CircularLabelsFactory container(Stage stage) {
        APIlib.getInstance().addJSLine(String.format(Locale.US, this.jsBase + ".container(%s);", stage != null ? stage.getJsBase() : null));
        return this;
    }

    @Override // com.anychart.core.ui.LabelsFactory, com.anychart.core.Text, com.anychart.core.VisualBase
    public CircularLabelsFactory container(String str) {
        APIlib.getInstance().addJSLine(String.format(Locale.US, this.jsBase + ".container(%s);", wrapQuotes(str)));
        return this;
    }

    @Override // com.anychart.core.ui.LabelsFactory, com.anychart.core.Text, com.anychart.core.VisualBase
    public Rect parentBounds() {
        return new Rect(this.jsBase + ".parentBounds()");
    }

    @Override // com.anychart.core.ui.LabelsFactory, com.anychart.core.Text, com.anychart.core.VisualBase
    public CircularLabelsFactory parentBounds(Rect rect) {
        APIlib.getInstance().addJSLine(String.format(Locale.US, this.jsBase + ".parentBounds(%s);", rect != null ? rect.getJsBase() : null));
        return this;
    }

    @Override // com.anychart.core.ui.LabelsFactory, com.anychart.core.Text, com.anychart.core.VisualBase
    public CircularLabelsFactory parentBounds(String str) {
        APIlib.getInstance().addJSLine(String.format(Locale.US, this.jsBase + ".parentBounds(%s);", wrapQuotes(str)));
        return this;
    }

    @Override // com.anychart.core.ui.LabelsFactory, com.anychart.core.Text, com.anychart.core.VisualBase
    public CircularLabelsFactory parentBounds(Number number) {
        APIlib.getInstance().addJSLine(String.format(Locale.US, this.jsBase + ".parentBounds(%s);", number));
        return this;
    }

    @Override // com.anychart.core.ui.LabelsFactory, com.anychart.core.Text, com.anychart.core.VisualBase
    public CircularLabelsFactory parentBounds(Number number, Number number2, Number number3, Number number4) {
        APIlib.getInstance().addJSLine(String.format(Locale.US, this.jsBase + ".parentBounds(%s, %s, %s, %s);", number, number2, number3, number4));
        return this;
    }
}
