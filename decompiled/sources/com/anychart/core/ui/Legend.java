package com.anychart.core.ui;

import com.amazonaws.services.s3.model.InstructionFileId;
import com.anychart.APIlib;
import com.anychart.JsObject;
import com.anychart.chart.common.listener.ListenersInterface;
import com.anychart.core.Text;
import com.anychart.core.ui.legend.LegendItemProvider;
import com.anychart.core.utils.Margin;
import com.anychart.core.utils.Padding;
import com.anychart.enums.Align;
import com.anychart.enums.Cursor;
import com.anychart.enums.LegendItemsSourceMode;
import com.anychart.enums.LegendLayout;
import com.anychart.enums.LegendPositionMode;
import com.anychart.enums.Orientation;
import com.anychart.enums.WordBreak;
import com.anychart.enums.WordWrap;
import com.anychart.graphics.vector.Layer;
import com.anychart.graphics.vector.PaperSize;
import com.anychart.graphics.vector.Stage;
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
public class Legend extends Text {
    protected Legend() {
    }

    public static Legend instantiate() {
        return new Legend("new anychart.core.ui.legend()");
    }

    public Legend(String str) {
        StringBuilder sb = new StringBuilder("legend");
        int i = variableIndex + 1;
        variableIndex = i;
        this.jsBase = sb.append(i).toString();
        APIlib.getInstance().addJSLine(this.jsBase + " = " + str + ";");
    }

    @Override // com.anychart.core.Text, com.anychart.core.VisualBase, com.anychart.core.Base, com.anychart.JsObject
    public String getJsBase() {
        return this.jsBase;
    }

    public void align() {
        APIlib.getInstance().addJSLine(this.jsBase + ".align();");
    }

    public Legend align(Align align) {
        APIlib.getInstance().addJSLine(String.format(Locale.US, this.jsBase + ".align(%s);", align != null ? align.getJsBase() : null));
        return this;
    }

    public Legend align(String str) {
        APIlib.getInstance().addJSLine(String.format(Locale.US, this.jsBase + ".align(%s);", wrapQuotes(str)));
        return this;
    }

    public Background background() {
        return new Background(this.jsBase + ".background()");
    }

    public Legend background(String str) {
        APIlib.getInstance().addJSLine(String.format(Locale.US, this.jsBase + ".background(%s);", wrapQuotes(str)));
        return this;
    }

    public Legend background(Boolean bool) {
        APIlib.getInstance().addJSLine(String.format(Locale.US, this.jsBase + ".background(%s);", bool));
        return this;
    }

    @Override // com.anychart.core.Text
    public void disablePointerEvents() {
        APIlib.getInstance().addJSLine(this.jsBase + ".disablePointerEvents();");
    }

    @Override // com.anychart.core.Text
    public Legend disablePointerEvents(Boolean bool) {
        APIlib.getInstance().addJSLine(String.format(Locale.US, this.jsBase + ".disablePointerEvents(%s);", bool));
        return this;
    }

    public void drag() {
        APIlib.getInstance().addJSLine(this.jsBase + ".drag();");
    }

    public Legend drag(Boolean bool) {
        APIlib.getInstance().addJSLine(String.format(Locale.US, this.jsBase + ".drag(%s);", bool));
        return this;
    }

    @Override // com.anychart.core.Text, com.anychart.core.VisualBase
    public void enabled() {
        APIlib.getInstance().addJSLine(this.jsBase + ".enabled();");
    }

    @Override // com.anychart.core.Text, com.anychart.core.VisualBase
    public Legend enabled(Boolean bool) {
        APIlib.getInstance().addJSLine(String.format(Locale.US, this.jsBase + ".enabled(%s);", bool));
        return this;
    }

    @Override // com.anychart.core.Text
    public void fontColor() {
        APIlib.getInstance().addJSLine(this.jsBase + ".fontColor();");
    }

    @Override // com.anychart.core.Text
    public Legend fontColor(String str) {
        APIlib.getInstance().addJSLine(String.format(Locale.US, this.jsBase + ".fontColor(%s);", wrapQuotes(str)));
        return this;
    }

    @Override // com.anychart.core.Text
    public void fontDecoration() {
        APIlib.getInstance().addJSLine(this.jsBase + ".fontDecoration();");
    }

    @Override // com.anychart.core.Text
    public Legend fontDecoration(Decoration decoration) {
        APIlib.getInstance().addJSLine(String.format(Locale.US, this.jsBase + ".fontDecoration(%s);", decoration != null ? decoration.getJsBase() : null));
        return this;
    }

    @Override // com.anychart.core.Text
    public Legend fontDecoration(String str) {
        APIlib.getInstance().addJSLine(String.format(Locale.US, this.jsBase + ".fontDecoration(%s);", wrapQuotes(str)));
        return this;
    }

    @Override // com.anychart.core.Text
    public void fontFamily() {
        APIlib.getInstance().addJSLine(this.jsBase + ".fontFamily();");
    }

    @Override // com.anychart.core.Text
    public Legend fontFamily(String str) {
        APIlib.getInstance().addJSLine(String.format(Locale.US, this.jsBase + ".fontFamily(%s);", wrapQuotes(str)));
        return this;
    }

    @Override // com.anychart.core.Text
    public void fontOpacity() {
        APIlib.getInstance().addJSLine(this.jsBase + ".fontOpacity();");
    }

    @Override // com.anychart.core.Text
    public Legend fontOpacity(Number number) {
        APIlib.getInstance().addJSLine(String.format(Locale.US, this.jsBase + ".fontOpacity(%s);", number));
        return this;
    }

    @Override // com.anychart.core.Text
    public void fontSize() {
        APIlib.getInstance().addJSLine(this.jsBase + ".fontSize();");
    }

    @Override // com.anychart.core.Text
    public Legend fontSize(String str) {
        APIlib.getInstance().addJSLine(String.format(Locale.US, this.jsBase + ".fontSize(%s);", wrapQuotes(str)));
        return this;
    }

    @Override // com.anychart.core.Text
    public Legend fontSize(Number number) {
        APIlib.getInstance().addJSLine(String.format(Locale.US, this.jsBase + ".fontSize(%s);", number));
        return this;
    }

    @Override // com.anychart.core.Text
    public void fontStyle() {
        APIlib.getInstance().addJSLine(this.jsBase + ".fontStyle();");
    }

    @Override // com.anychart.core.Text
    public Legend fontStyle(FontStyle fontStyle) {
        APIlib.getInstance().addJSLine(String.format(Locale.US, this.jsBase + ".fontStyle(%s);", fontStyle != null ? fontStyle.getJsBase() : null));
        return this;
    }

    @Override // com.anychart.core.Text
    public Legend fontStyle(String str) {
        APIlib.getInstance().addJSLine(String.format(Locale.US, this.jsBase + ".fontStyle(%s);", wrapQuotes(str)));
        return this;
    }

    @Override // com.anychart.core.Text
    public void fontVariant() {
        APIlib.getInstance().addJSLine(this.jsBase + ".fontVariant();");
    }

    @Override // com.anychart.core.Text
    public Legend fontVariant(FontVariant fontVariant) {
        APIlib.getInstance().addJSLine(String.format(Locale.US, this.jsBase + ".fontVariant(%s);", fontVariant != null ? fontVariant.getJsBase() : null));
        return this;
    }

    @Override // com.anychart.core.Text
    public Legend fontVariant(String str) {
        APIlib.getInstance().addJSLine(String.format(Locale.US, this.jsBase + ".fontVariant(%s);", wrapQuotes(str)));
        return this;
    }

    @Override // com.anychart.core.Text
    public void fontWeight() {
        APIlib.getInstance().addJSLine(this.jsBase + ".fontWeight();");
    }

    @Override // com.anychart.core.Text
    public Legend fontWeight(String str) {
        APIlib.getInstance().addJSLine(String.format(Locale.US, this.jsBase + ".fontWeight(%s);", wrapQuotes(str)));
        return this;
    }

    @Override // com.anychart.core.Text
    public Legend fontWeight(Number number) {
        APIlib.getInstance().addJSLine(String.format(Locale.US, this.jsBase + ".fontWeight(%s);", number));
        return this;
    }

    public Rect getPixelBounds() {
        return new Rect(this.jsBase + ".getPixelBounds()");
    }

    public Rect getRemainingBounds() {
        return new Rect(this.jsBase + ".getRemainingBounds()");
    }

    @Override // com.anychart.core.Text
    public void hAlign() {
        APIlib.getInstance().addJSLine(this.jsBase + ".hAlign();");
    }

    @Override // com.anychart.core.Text
    public Legend hAlign(HAlign hAlign) {
        APIlib.getInstance().addJSLine(String.format(Locale.US, this.jsBase + ".hAlign(%s);", hAlign != null ? hAlign.getJsBase() : null));
        return this;
    }

    @Override // com.anychart.core.Text
    public Legend hAlign(String str) {
        APIlib.getInstance().addJSLine(String.format(Locale.US, this.jsBase + ".hAlign(%s);", wrapQuotes(str)));
        return this;
    }

    public void height() {
        APIlib.getInstance().addJSLine(this.jsBase + ".height();");
    }

    public Legend height(Number number) {
        APIlib.getInstance().addJSLine(String.format(Locale.US, this.jsBase + ".height(%s);", number));
        return this;
    }

    public Legend height(String str) {
        APIlib.getInstance().addJSLine(String.format(Locale.US, this.jsBase + ".height(%s);", wrapQuotes(str)));
        return this;
    }

    public void hoverCursor() {
        APIlib.getInstance().addJSLine(this.jsBase + ".hoverCursor();");
    }

    public Legend hoverCursor(Cursor cursor) {
        APIlib.getInstance().addJSLine(String.format(Locale.US, this.jsBase + ".hoverCursor(%s);", cursor != null ? cursor.getJsBase() : null));
        return this;
    }

    public Legend hoverCursor(String str) {
        APIlib.getInstance().addJSLine(String.format(Locale.US, this.jsBase + ".hoverCursor(%s);", wrapQuotes(str)));
        return this;
    }

    public void iconSize() {
        APIlib.getInstance().addJSLine(this.jsBase + ".iconSize();");
    }

    public Legend iconSize(Number number) {
        APIlib.getInstance().addJSLine(String.format(Locale.US, this.jsBase + ".iconSize(%s);", number));
        return this;
    }

    public Legend iconSize(String str) {
        APIlib.getInstance().addJSLine(String.format(Locale.US, this.jsBase + ".iconSize(%s);", wrapQuotes(str)));
        return this;
    }

    public void iconTextSpacing() {
        APIlib.getInstance().addJSLine(this.jsBase + ".iconTextSpacing();");
    }

    public Legend iconTextSpacing(String str) {
        APIlib.getInstance().addJSLine(String.format(Locale.US, this.jsBase + ".iconTextSpacing(%s);", wrapQuotes(str)));
        return this;
    }

    public Legend iconTextSpacing(Number number) {
        APIlib.getInstance().addJSLine(String.format(Locale.US, this.jsBase + ".iconTextSpacing(%s);", number));
        return this;
    }

    public void inverted() {
        APIlib.getInstance().addJSLine(this.jsBase + ".inverted();");
    }

    public Legend inverted(Boolean bool) {
        APIlib.getInstance().addJSLine(String.format(Locale.US, this.jsBase + ".inverted(%s);", bool));
        return this;
    }

    public void items() {
        APIlib.getInstance().addJSLine(this.jsBase + ".items();");
    }

    public Legend items(LegendItemProvider[] legendItemProviderArr) {
        APIlib.getInstance().addJSLine(String.format(Locale.US, this.jsBase + ".items(%s);", arrayToString((JsObject[]) legendItemProviderArr)));
        return this;
    }

    public void itemsFormat() {
        APIlib.getInstance().addJSLine(this.jsBase + ".itemsFormat();");
    }

    public Legend itemsFormat(String str) {
        APIlib.getInstance().addJSLine(String.format(Locale.US, this.jsBase + ".itemsFormat(%s);", wrapQuotes(str)));
        return this;
    }

    public void itemsFormatter() {
        APIlib.getInstance().addJSLine(this.jsBase + ".itemsFormatter();");
    }

    public Legend itemsFormatter(LegendItemProvider[] legendItemProviderArr) {
        APIlib.getInstance().addJSLine(String.format(Locale.US, this.jsBase + ".itemsFormatter(%s);", arrayToString((JsObject[]) legendItemProviderArr)));
        return this;
    }

    public void itemsLayout() {
        APIlib.getInstance().addJSLine(this.jsBase + ".itemsLayout();");
    }

    public Legend itemsLayout(LegendLayout legendLayout) {
        APIlib.getInstance().addJSLine(String.format(Locale.US, this.jsBase + ".itemsLayout(%s);", legendLayout != null ? legendLayout.getJsBase() : null));
        return this;
    }

    public Legend itemsLayout(String str) {
        APIlib.getInstance().addJSLine(String.format(Locale.US, this.jsBase + ".itemsLayout(%s);", wrapQuotes(str)));
        return this;
    }

    public void itemsSourceMode() {
        APIlib.getInstance().addJSLine(this.jsBase + ".itemsSourceMode();");
    }

    public Legend itemsSourceMode(LegendItemsSourceMode legendItemsSourceMode) {
        APIlib.getInstance().addJSLine(String.format(Locale.US, this.jsBase + ".itemsSourceMode(%s);", legendItemsSourceMode != null ? legendItemsSourceMode.getJsBase() : null));
        return this;
    }

    public Legend itemsSourceMode(String str) {
        APIlib.getInstance().addJSLine(String.format(Locale.US, this.jsBase + ".itemsSourceMode(%s);", wrapQuotes(str)));
        return this;
    }

    public void itemsSpacing() {
        APIlib.getInstance().addJSLine(this.jsBase + ".itemsSpacing();");
    }

    public Legend itemsSpacing(String str) {
        APIlib.getInstance().addJSLine(String.format(Locale.US, this.jsBase + ".itemsSpacing(%s);", wrapQuotes(str)));
        return this;
    }

    public Legend itemsSpacing(Number number) {
        APIlib.getInstance().addJSLine(String.format(Locale.US, this.jsBase + ".itemsSpacing(%s);", number));
        return this;
    }

    @Override // com.anychart.core.Text
    public void letterSpacing() {
        APIlib.getInstance().addJSLine(this.jsBase + ".letterSpacing();");
    }

    @Override // com.anychart.core.Text
    public Legend letterSpacing(String str) {
        APIlib.getInstance().addJSLine(String.format(Locale.US, this.jsBase + ".letterSpacing(%s);", wrapQuotes(str)));
        return this;
    }

    @Override // com.anychart.core.Text
    public Legend letterSpacing(Number number) {
        APIlib.getInstance().addJSLine(String.format(Locale.US, this.jsBase + ".letterSpacing(%s);", number));
        return this;
    }

    @Override // com.anychart.core.Text
    public void lineHeight() {
        APIlib.getInstance().addJSLine(this.jsBase + ".lineHeight();");
    }

    @Override // com.anychart.core.Text
    public Legend lineHeight(String str) {
        APIlib.getInstance().addJSLine(String.format(Locale.US, this.jsBase + ".lineHeight(%s);", wrapQuotes(str)));
        return this;
    }

    @Override // com.anychart.core.Text
    public Legend lineHeight(Number number) {
        APIlib.getInstance().addJSLine(String.format(Locale.US, this.jsBase + ".lineHeight(%s);", number));
        return this;
    }

    public Margin margin() {
        return new Margin(this.jsBase + ".margin()");
    }

    public Legend margin(Number[] numberArr) {
        APIlib.getInstance().addJSLine(String.format(Locale.US, this.jsBase + ".margin(%s);", Arrays.toString(numberArr)));
        return this;
    }

    public Legend margin(String[] strArr) {
        APIlib.getInstance().addJSLine(String.format(Locale.US, this.jsBase + ".margin(%s);", arrayToStringWrapQuotes(strArr)));
        return this;
    }

    public Legend margin(String str) {
        APIlib.getInstance().addJSLine(String.format(Locale.US, this.jsBase + ".margin(%s);", wrapQuotes(str)));
        return this;
    }

    public Legend margin(Number number) {
        APIlib.getInstance().addJSLine(String.format(Locale.US, this.jsBase + ".margin(%s);", number));
        return this;
    }

    public Legend margin(String str, String str2, String str3, String str4) {
        APIlib.getInstance().addJSLine(String.format(Locale.US, this.jsBase + ".margin(%s, %s, %s, %s);", wrapQuotes(str), wrapQuotes(str2), wrapQuotes(str3), wrapQuotes(str4)));
        return this;
    }

    public Legend margin(String str, String str2, String str3, Number number) {
        APIlib.getInstance().addJSLine(String.format(Locale.US, this.jsBase + ".margin(%s, %s, %s, %s);", wrapQuotes(str), wrapQuotes(str2), wrapQuotes(str3), number));
        return this;
    }

    public Legend margin(String str, String str2, Number number, String str3) {
        APIlib.getInstance().addJSLine(String.format(Locale.US, this.jsBase + ".margin(%s, %s, %s, %s);", wrapQuotes(str), wrapQuotes(str2), number, wrapQuotes(str3)));
        return this;
    }

    public Legend margin(String str, String str2, Number number, Number number2) {
        APIlib.getInstance().addJSLine(String.format(Locale.US, this.jsBase + ".margin(%s, %s, %s, %s);", wrapQuotes(str), wrapQuotes(str2), number, number2));
        return this;
    }

    public Legend margin(String str, Number number, String str2, String str3) {
        APIlib.getInstance().addJSLine(String.format(Locale.US, this.jsBase + ".margin(%s, %s, %s, %s);", wrapQuotes(str), number, wrapQuotes(str2), wrapQuotes(str3)));
        return this;
    }

    public Legend margin(String str, Number number, String str2, Number number2) {
        APIlib.getInstance().addJSLine(String.format(Locale.US, this.jsBase + ".margin(%s, %s, %s, %s);", wrapQuotes(str), number, wrapQuotes(str2), number2));
        return this;
    }

    public Legend margin(String str, Number number, Number number2, String str2) {
        APIlib.getInstance().addJSLine(String.format(Locale.US, this.jsBase + ".margin(%s, %s, %s, %s);", wrapQuotes(str), number, number2, wrapQuotes(str2)));
        return this;
    }

    public Legend margin(String str, Number number, Number number2, Number number3) {
        APIlib.getInstance().addJSLine(String.format(Locale.US, this.jsBase + ".margin(%s, %s, %s, %s);", wrapQuotes(str), number, number2, number3));
        return this;
    }

    public Legend margin(Number number, String str, String str2, String str3) {
        APIlib.getInstance().addJSLine(String.format(Locale.US, this.jsBase + ".margin(%s, %s, %s, %s);", number, wrapQuotes(str), wrapQuotes(str2), wrapQuotes(str3)));
        return this;
    }

    public Legend margin(Number number, String str, String str2, Number number2) {
        APIlib.getInstance().addJSLine(String.format(Locale.US, this.jsBase + ".margin(%s, %s, %s, %s);", number, wrapQuotes(str), wrapQuotes(str2), number2));
        return this;
    }

    public Legend margin(Number number, String str, Number number2, String str2) {
        APIlib.getInstance().addJSLine(String.format(Locale.US, this.jsBase + ".margin(%s, %s, %s, %s);", number, wrapQuotes(str), number2, wrapQuotes(str2)));
        return this;
    }

    public Legend margin(Number number, String str, Number number2, Number number3) {
        APIlib.getInstance().addJSLine(String.format(Locale.US, this.jsBase + ".margin(%s, %s, %s, %s);", number, wrapQuotes(str), number2, number3));
        return this;
    }

    public Legend margin(Number number, Number number2, String str, String str2) {
        APIlib.getInstance().addJSLine(String.format(Locale.US, this.jsBase + ".margin(%s, %s, %s, %s);", number, number2, wrapQuotes(str), wrapQuotes(str2)));
        return this;
    }

    public Legend margin(Number number, Number number2, String str, Number number3) {
        APIlib.getInstance().addJSLine(String.format(Locale.US, this.jsBase + ".margin(%s, %s, %s, %s);", number, number2, wrapQuotes(str), number3));
        return this;
    }

    public Legend margin(Number number, Number number2, Number number3, String str) {
        APIlib.getInstance().addJSLine(String.format(Locale.US, this.jsBase + ".margin(%s, %s, %s, %s);", number, number2, number3, wrapQuotes(str)));
        return this;
    }

    public Legend margin(Number number, Number number2, Number number3, Number number4) {
        APIlib.getInstance().addJSLine(String.format(Locale.US, this.jsBase + ".margin(%s, %s, %s, %s);", number, number2, number3, number4));
        return this;
    }

    public void maxHeight() {
        APIlib.getInstance().addJSLine(this.jsBase + ".maxHeight();");
    }

    public Legend maxHeight(Number number) {
        APIlib.getInstance().addJSLine(String.format(Locale.US, this.jsBase + ".maxHeight(%s);", number));
        return this;
    }

    public Legend maxHeight(String str) {
        APIlib.getInstance().addJSLine(String.format(Locale.US, this.jsBase + ".maxHeight(%s);", wrapQuotes(str)));
        return this;
    }

    public void maxWidth() {
        APIlib.getInstance().addJSLine(this.jsBase + ".maxWidth();");
    }

    public Legend maxWidth(Number number) {
        APIlib.getInstance().addJSLine(String.format(Locale.US, this.jsBase + ".maxWidth(%s);", number));
        return this;
    }

    public Legend maxWidth(String str) {
        APIlib.getInstance().addJSLine(String.format(Locale.US, this.jsBase + ".maxWidth(%s);", wrapQuotes(str)));
        return this;
    }

    public Padding padding() {
        return new Padding(this.jsBase + ".padding()");
    }

    public Legend padding(Number[] numberArr) {
        APIlib.getInstance().addJSLine(String.format(Locale.US, this.jsBase + ".padding(%s);", Arrays.toString(numberArr)));
        return this;
    }

    public Legend padding(String[] strArr) {
        APIlib.getInstance().addJSLine(String.format(Locale.US, this.jsBase + ".padding(%s);", arrayToStringWrapQuotes(strArr)));
        return this;
    }

    public Legend padding(String str) {
        APIlib.getInstance().addJSLine(String.format(Locale.US, this.jsBase + ".padding(%s);", wrapQuotes(str)));
        return this;
    }

    public Legend padding(Number number) {
        APIlib.getInstance().addJSLine(String.format(Locale.US, this.jsBase + ".padding(%s);", number));
        return this;
    }

    public Legend padding(String str, String str2, String str3, String str4) {
        APIlib.getInstance().addJSLine(String.format(Locale.US, this.jsBase + ".padding(%s, %s, %s, %s);", wrapQuotes(str), wrapQuotes(str2), wrapQuotes(str3), wrapQuotes(str4)));
        return this;
    }

    public Legend padding(String str, String str2, String str3, Number number) {
        APIlib.getInstance().addJSLine(String.format(Locale.US, this.jsBase + ".padding(%s, %s, %s, %s);", wrapQuotes(str), wrapQuotes(str2), wrapQuotes(str3), number));
        return this;
    }

    public Legend padding(String str, String str2, Number number, String str3) {
        APIlib.getInstance().addJSLine(String.format(Locale.US, this.jsBase + ".padding(%s, %s, %s, %s);", wrapQuotes(str), wrapQuotes(str2), number, wrapQuotes(str3)));
        return this;
    }

    public Legend padding(String str, String str2, Number number, Number number2) {
        APIlib.getInstance().addJSLine(String.format(Locale.US, this.jsBase + ".padding(%s, %s, %s, %s);", wrapQuotes(str), wrapQuotes(str2), number, number2));
        return this;
    }

    public Legend padding(String str, Number number, String str2, String str3) {
        APIlib.getInstance().addJSLine(String.format(Locale.US, this.jsBase + ".padding(%s, %s, %s, %s);", wrapQuotes(str), number, wrapQuotes(str2), wrapQuotes(str3)));
        return this;
    }

    public Legend padding(String str, Number number, String str2, Number number2) {
        APIlib.getInstance().addJSLine(String.format(Locale.US, this.jsBase + ".padding(%s, %s, %s, %s);", wrapQuotes(str), number, wrapQuotes(str2), number2));
        return this;
    }

    public Legend padding(String str, Number number, Number number2, String str2) {
        APIlib.getInstance().addJSLine(String.format(Locale.US, this.jsBase + ".padding(%s, %s, %s, %s);", wrapQuotes(str), number, number2, wrapQuotes(str2)));
        return this;
    }

    public Legend padding(String str, Number number, Number number2, Number number3) {
        APIlib.getInstance().addJSLine(String.format(Locale.US, this.jsBase + ".padding(%s, %s, %s, %s);", wrapQuotes(str), number, number2, number3));
        return this;
    }

    public Legend padding(Number number, String str, String str2, String str3) {
        APIlib.getInstance().addJSLine(String.format(Locale.US, this.jsBase + ".padding(%s, %s, %s, %s);", number, wrapQuotes(str), wrapQuotes(str2), wrapQuotes(str3)));
        return this;
    }

    public Legend padding(Number number, String str, String str2, Number number2) {
        APIlib.getInstance().addJSLine(String.format(Locale.US, this.jsBase + ".padding(%s, %s, %s, %s);", number, wrapQuotes(str), wrapQuotes(str2), number2));
        return this;
    }

    public Legend padding(Number number, String str, Number number2, String str2) {
        APIlib.getInstance().addJSLine(String.format(Locale.US, this.jsBase + ".padding(%s, %s, %s, %s);", number, wrapQuotes(str), number2, wrapQuotes(str2)));
        return this;
    }

    public Legend padding(Number number, String str, Number number2, Number number3) {
        APIlib.getInstance().addJSLine(String.format(Locale.US, this.jsBase + ".padding(%s, %s, %s, %s);", number, wrapQuotes(str), number2, number3));
        return this;
    }

    public Legend padding(Number number, Number number2, String str, String str2) {
        APIlib.getInstance().addJSLine(String.format(Locale.US, this.jsBase + ".padding(%s, %s, %s, %s);", number, number2, wrapQuotes(str), wrapQuotes(str2)));
        return this;
    }

    public Legend padding(Number number, Number number2, String str, Number number3) {
        APIlib.getInstance().addJSLine(String.format(Locale.US, this.jsBase + ".padding(%s, %s, %s, %s);", number, number2, wrapQuotes(str), number3));
        return this;
    }

    public Legend padding(Number number, Number number2, Number number3, String str) {
        APIlib.getInstance().addJSLine(String.format(Locale.US, this.jsBase + ".padding(%s, %s, %s, %s);", number, number2, number3, wrapQuotes(str)));
        return this;
    }

    public Legend padding(Number number, Number number2, Number number3, Number number4) {
        APIlib.getInstance().addJSLine(String.format(Locale.US, this.jsBase + ".padding(%s, %s, %s, %s);", number, number2, number3, number4));
        return this;
    }

    public Paginator paginator() {
        return new Paginator(this.jsBase + ".paginator()");
    }

    public Legend paginator(String str) {
        APIlib.getInstance().addJSLine(String.format(Locale.US, this.jsBase + ".paginator(%s);", wrapQuotes(str)));
        return this;
    }

    public Legend paginator(Boolean bool) {
        APIlib.getInstance().addJSLine(String.format(Locale.US, this.jsBase + ".paginator(%s);", bool));
        return this;
    }

    public void position() {
        APIlib.getInstance().addJSLine(this.jsBase + ".position();");
    }

    public Legend position(Orientation orientation) {
        APIlib.getInstance().addJSLine(String.format(Locale.US, this.jsBase + ".position(%s);", orientation != null ? orientation.getJsBase() : null));
        return this;
    }

    public Legend position(String str) {
        APIlib.getInstance().addJSLine(String.format(Locale.US, this.jsBase + ".position(%s);", wrapQuotes(str)));
        return this;
    }

    public void positionMode() {
        APIlib.getInstance().addJSLine(this.jsBase + ".positionMode();");
    }

    public Legend positionMode(LegendPositionMode legendPositionMode) {
        APIlib.getInstance().addJSLine(String.format(Locale.US, this.jsBase + ".positionMode(%s);", legendPositionMode != null ? legendPositionMode.getJsBase() : null));
        return this;
    }

    public Legend positionMode(String str) {
        APIlib.getInstance().addJSLine(String.format(Locale.US, this.jsBase + ".positionMode(%s);", wrapQuotes(str)));
        return this;
    }

    @Override // com.anychart.core.Text, com.anychart.core.VisualBase
    public void print(PaperSize paperSize, Boolean bool) {
        APIlib.getInstance().addJSLine(String.format(Locale.US, this.jsBase + ".print(%s, %s);", paperSize != null ? paperSize.getJsBase() : null, bool));
    }

    @Override // com.anychart.core.Text, com.anychart.core.VisualBase
    public void print(String str, Boolean bool) {
        APIlib.getInstance().addJSLine(String.format(Locale.US, this.jsBase + ".print(%s, %s);", wrapQuotes(str), bool));
    }

    @Override // com.anychart.core.Text, com.anychart.core.VisualBase, com.anychart.core.Base
    public void removeAllListeners(String str) {
        APIlib.getInstance().addJSLine(String.format(Locale.US, this.jsBase + ".removeAllListeners(%s);", wrapQuotes(str)));
    }

    @Override // com.anychart.core.Text
    public void selectable() {
        APIlib.getInstance().addJSLine(this.jsBase + ".selectable();");
    }

    @Override // com.anychart.core.Text
    public Legend selectable(Boolean bool) {
        APIlib.getInstance().addJSLine(String.format(Locale.US, this.jsBase + ".selectable(%s);", bool));
        return this;
    }

    @Override // com.anychart.core.Text
    public void textDirection() {
        APIlib.getInstance().addJSLine(this.jsBase + ".textDirection();");
    }

    @Override // com.anychart.core.Text
    public Legend textDirection(Direction direction) {
        APIlib.getInstance().addJSLine(String.format(Locale.US, this.jsBase + ".textDirection(%s);", direction != null ? direction.getJsBase() : null));
        return this;
    }

    @Override // com.anychart.core.Text
    public Legend textDirection(String str) {
        APIlib.getInstance().addJSLine(String.format(Locale.US, this.jsBase + ".textDirection(%s);", wrapQuotes(str)));
        return this;
    }

    @Override // com.anychart.core.Text
    public void textIndent() {
        APIlib.getInstance().addJSLine(this.jsBase + ".textIndent();");
    }

    @Override // com.anychart.core.Text
    public Legend textIndent(Number number) {
        APIlib.getInstance().addJSLine(String.format(Locale.US, this.jsBase + ".textIndent(%s);", number));
        return this;
    }

    @Override // com.anychart.core.Text
    public void textOverflow() {
        APIlib.getInstance().addJSLine(this.jsBase + ".textOverflow();");
    }

    @Override // com.anychart.core.Text
    public Legend textOverflow(TextOverflow textOverflow) {
        APIlib.getInstance().addJSLine(String.format(Locale.US, this.jsBase + ".textOverflow(%s);", textOverflow != null ? textOverflow.getJsBase() : null));
        return this;
    }

    @Override // com.anychart.core.Text
    public Legend textOverflow(String str) {
        APIlib.getInstance().addJSLine(String.format(Locale.US, this.jsBase + ".textOverflow(%s);", wrapQuotes(str)));
        return this;
    }

    @Override // com.anychart.core.Text
    public void textSettings() {
        APIlib.getInstance().addJSLine(this.jsBase + ".textSettings();");
    }

    @Override // com.anychart.core.Text
    public void textSettings(String str) {
        APIlib.getInstance().addJSLine(String.format(Locale.US, this.jsBase + ".textSettings(%s);", wrapQuotes(str)));
    }

    @Override // com.anychart.core.Text
    public Legend textSettings(String str, String str2) {
        APIlib.getInstance().addJSLine(String.format(Locale.US, this.jsBase + ".textSettings(%s, %s);", wrapQuotes(str), wrapQuotes(str2)));
        return this;
    }

    @Override // com.anychart.core.Text
    public Legend textSettings(String str, Number number) {
        APIlib.getInstance().addJSLine(String.format(Locale.US, this.jsBase + ".textSettings(%s, %s);", wrapQuotes(str), number));
        return this;
    }

    @Override // com.anychart.core.Text
    public Legend textSettings(String str, Boolean bool) {
        APIlib.getInstance().addJSLine(String.format(Locale.US, this.jsBase + ".textSettings(%s, %s);", wrapQuotes(str), bool));
        return this;
    }

    public Title title() {
        return new Title(this.jsBase + ".title()");
    }

    public Legend title(Boolean bool) {
        APIlib.getInstance().addJSLine(String.format(Locale.US, this.jsBase + ".title(%s);", bool));
        return this;
    }

    public Legend title(String str) {
        APIlib.getInstance().addJSLine(String.format(Locale.US, this.jsBase + ".title(%s);", wrapQuotes(str)));
        return this;
    }

    public void titleFormat() {
        APIlib.getInstance().addJSLine(this.jsBase + ".titleFormat();");
    }

    public Legend titleFormat(String str) {
        APIlib.getInstance().addJSLine(String.format(Locale.US, this.jsBase + ".titleFormat(%s);", wrapQuotes(str)));
        return this;
    }

    public Separator titleSeparator() {
        return new Separator(this.jsBase + ".titleSeparator()");
    }

    public Legend titleSeparator(String str) {
        APIlib.getInstance().addJSLine(String.format(Locale.US, this.jsBase + ".titleSeparator(%s);", wrapQuotes(str)));
        return this;
    }

    public Legend titleSeparator(Boolean bool) {
        APIlib.getInstance().addJSLine(String.format(Locale.US, this.jsBase + ".titleSeparator(%s);", bool));
        return this;
    }

    public Tooltip tooltip() {
        return new Tooltip(this.jsBase + ".tooltip()");
    }

    public Legend tooltip(String str) {
        APIlib.getInstance().addJSLine(String.format(Locale.US, this.jsBase + ".tooltip(%s);", wrapQuotes(str)));
        return this;
    }

    public Legend tooltip(Boolean bool) {
        APIlib.getInstance().addJSLine(String.format(Locale.US, this.jsBase + ".tooltip(%s);", bool));
        return this;
    }

    @Override // com.anychart.core.Text, com.anychart.core.VisualBase, com.anychart.core.Base
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

    @Override // com.anychart.core.Text, com.anychart.core.VisualBase, com.anychart.core.Base
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

    @Override // com.anychart.core.Text, com.anychart.core.VisualBase, com.anychart.core.Base
    public void unlistenByKey(String str) {
        APIlib.getInstance().addJSLine(String.format(Locale.US, this.jsBase + ".unlistenByKey(%s);", wrapQuotes(str)));
    }

    @Override // com.anychart.core.Text
    public void useHtml() {
        APIlib.getInstance().addJSLine(this.jsBase + ".useHtml();");
    }

    @Override // com.anychart.core.Text
    public Legend useHtml(Boolean bool) {
        APIlib.getInstance().addJSLine(String.format(Locale.US, this.jsBase + ".useHtml(%s);", bool));
        return this;
    }

    @Override // com.anychart.core.Text
    public void vAlign() {
        APIlib.getInstance().addJSLine(this.jsBase + ".vAlign();");
    }

    @Override // com.anychart.core.Text
    public Legend vAlign(VAlign vAlign) {
        APIlib.getInstance().addJSLine(String.format(Locale.US, this.jsBase + ".vAlign(%s);", vAlign != null ? vAlign.getJsBase() : null));
        return this;
    }

    @Override // com.anychart.core.Text
    public Legend vAlign(String str) {
        APIlib.getInstance().addJSLine(String.format(Locale.US, this.jsBase + ".vAlign(%s);", wrapQuotes(str)));
        return this;
    }

    public void width() {
        APIlib.getInstance().addJSLine(this.jsBase + ".width();");
    }

    public Legend width(Number number) {
        APIlib.getInstance().addJSLine(String.format(Locale.US, this.jsBase + ".width(%s);", number));
        return this;
    }

    public Legend width(String str) {
        APIlib.getInstance().addJSLine(String.format(Locale.US, this.jsBase + ".width(%s);", wrapQuotes(str)));
        return this;
    }

    @Override // com.anychart.core.Text
    public void wordBreak() {
        APIlib.getInstance().addJSLine(this.jsBase + ".wordBreak();");
    }

    @Override // com.anychart.core.Text
    public Legend wordBreak(WordBreak wordBreak) {
        APIlib.getInstance().addJSLine(String.format(Locale.US, this.jsBase + ".wordBreak(%s);", wordBreak != null ? wordBreak.getJsBase() : null));
        return this;
    }

    @Override // com.anychart.core.Text
    public Legend wordBreak(String str) {
        APIlib.getInstance().addJSLine(String.format(Locale.US, this.jsBase + ".wordBreak(%s);", wrapQuotes(str)));
        return this;
    }

    @Override // com.anychart.core.Text
    public void wordWrap() {
        APIlib.getInstance().addJSLine(this.jsBase + ".wordWrap();");
    }

    @Override // com.anychart.core.Text
    public Legend wordWrap(WordWrap wordWrap) {
        APIlib.getInstance().addJSLine(String.format(Locale.US, this.jsBase + ".wordWrap(%s);", wordWrap != null ? wordWrap.getJsBase() : null));
        return this;
    }

    @Override // com.anychart.core.Text
    public Legend wordWrap(String str) {
        APIlib.getInstance().addJSLine(String.format(Locale.US, this.jsBase + ".wordWrap(%s);", wrapQuotes(str)));
        return this;
    }

    @Override // com.anychart.core.Text, com.anychart.core.VisualBase
    public void zIndex() {
        APIlib.getInstance().addJSLine(this.jsBase + ".zIndex();");
    }

    @Override // com.anychart.core.Text, com.anychart.core.VisualBase
    public Legend zIndex(Number number) {
        APIlib.getInstance().addJSLine(String.format(Locale.US, this.jsBase + ".zIndex(%s);", number));
        return this;
    }

    @Override // com.anychart.core.Text, com.anychart.core.VisualBase
    public Layer container() {
        return new Layer(this.jsBase + ".container()");
    }

    @Override // com.anychart.core.Text, com.anychart.core.VisualBase
    public Legend container(Layer layer) {
        APIlib.getInstance().addJSLine(String.format(Locale.US, this.jsBase + ".container(%s);", layer != null ? layer.getJsBase() : null));
        return this;
    }

    @Override // com.anychart.core.Text, com.anychart.core.VisualBase
    public Legend container(Stage stage) {
        APIlib.getInstance().addJSLine(String.format(Locale.US, this.jsBase + ".container(%s);", stage != null ? stage.getJsBase() : null));
        return this;
    }

    @Override // com.anychart.core.Text, com.anychart.core.VisualBase
    public Legend container(String str) {
        APIlib.getInstance().addJSLine(String.format(Locale.US, this.jsBase + ".container(%s);", wrapQuotes(str)));
        return this;
    }

    @Override // com.anychart.core.Text, com.anychart.core.VisualBase
    public Rect parentBounds() {
        return new Rect(this.jsBase + ".parentBounds()");
    }

    @Override // com.anychart.core.Text, com.anychart.core.VisualBase
    public Legend parentBounds(Rect rect) {
        APIlib.getInstance().addJSLine(String.format(Locale.US, this.jsBase + ".parentBounds(%s);", rect != null ? rect.getJsBase() : null));
        return this;
    }

    @Override // com.anychart.core.Text, com.anychart.core.VisualBase
    public Legend parentBounds(String str) {
        APIlib.getInstance().addJSLine(String.format(Locale.US, this.jsBase + ".parentBounds(%s);", wrapQuotes(str)));
        return this;
    }

    @Override // com.anychart.core.Text, com.anychart.core.VisualBase
    public Legend parentBounds(Number number) {
        APIlib.getInstance().addJSLine(String.format(Locale.US, this.jsBase + ".parentBounds(%s);", number));
        return this;
    }

    @Override // com.anychart.core.Text, com.anychart.core.VisualBase
    public Legend parentBounds(Number number, Number number2, Number number3, Number number4) {
        APIlib.getInstance().addJSLine(String.format(Locale.US, this.jsBase + ".parentBounds(%s, %s, %s, %s);", number, number2, number3, number4));
        return this;
    }
}
