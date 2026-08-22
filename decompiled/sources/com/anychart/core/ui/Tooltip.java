package com.anychart.core.ui;

import com.amazonaws.services.s3.model.InstructionFileId;
import com.anychart.APIlib;
import com.anychart.chart.common.listener.ListenersInterface;
import com.anychart.core.VisualBase;
import com.anychart.core.utils.Padding;
import com.anychart.enums.Anchor;
import com.anychart.enums.Position;
import com.anychart.enums.TooltipDisplayMode;
import com.anychart.enums.TooltipPositionMode;
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
public class Tooltip extends VisualBase {
    protected Tooltip() {
    }

    public static Tooltip instantiate() {
        return new Tooltip("new anychart.core.ui.tooltip()");
    }

    public Tooltip(String str) {
        StringBuilder sb = new StringBuilder("tooltip");
        int i = variableIndex + 1;
        variableIndex = i;
        this.jsBase = sb.append(i).toString();
        APIlib.getInstance().addJSLine(this.jsBase + " = " + str + ";");
    }

    @Override // com.anychart.core.VisualBase, com.anychart.core.Base, com.anychart.JsObject
    public String getJsBase() {
        return this.jsBase;
    }

    public void adjustFontSize() {
        APIlib.getInstance().addJSLine(this.jsBase + ".adjustFontSize();");
    }

    public Tooltip adjustFontSize(Boolean bool, Boolean bool2) {
        APIlib.getInstance().addJSLine(String.format(Locale.US, this.jsBase + ".adjustFontSize(%s, %s);", bool, bool2));
        return this;
    }

    public Tooltip adjustFontSize(Boolean[] boolArr, Boolean bool) {
        APIlib.getInstance().addJSLine(String.format(Locale.US, this.jsBase + ".adjustFontSize(%s, %s);", arrayToString(boolArr), bool));
        return this;
    }

    public Tooltip adjustFontSize(String str, Boolean bool) {
        APIlib.getInstance().addJSLine(String.format(Locale.US, this.jsBase + ".adjustFontSize(%s, %s);", wrapQuotes(str), bool));
        return this;
    }

    public void allowLeaveChart() {
        APIlib.getInstance().addJSLine(this.jsBase + ".allowLeaveChart();");
    }

    public Tooltip allowLeaveChart(Boolean bool) {
        APIlib.getInstance().addJSLine(String.format(Locale.US, this.jsBase + ".allowLeaveChart(%s);", bool));
        return this;
    }

    public void allowLeaveScreen() {
        APIlib.getInstance().addJSLine(this.jsBase + ".allowLeaveScreen();");
    }

    public Tooltip allowLeaveScreen(Boolean bool) {
        APIlib.getInstance().addJSLine(String.format(Locale.US, this.jsBase + ".allowLeaveScreen(%s);", bool));
        return this;
    }

    public void allowLeaveStage() {
        APIlib.getInstance().addJSLine(this.jsBase + ".allowLeaveStage();");
    }

    public Tooltip allowLeaveStage(Boolean bool) {
        APIlib.getInstance().addJSLine(String.format(Locale.US, this.jsBase + ".allowLeaveStage(%s);", bool));
        return this;
    }

    public void anchor() {
        APIlib.getInstance().addJSLine(this.jsBase + ".anchor();");
    }

    public Tooltip anchor(Anchor anchor) {
        APIlib.getInstance().addJSLine(String.format(Locale.US, this.jsBase + ".anchor(%s);", anchor != null ? anchor.getJsBase() : null));
        return this;
    }

    public Tooltip anchor(String str) {
        APIlib.getInstance().addJSLine(String.format(Locale.US, this.jsBase + ".anchor(%s);", wrapQuotes(str)));
        return this;
    }

    public Background background() {
        return new Background(this.jsBase + ".background()");
    }

    public Tooltip background(Boolean bool) {
        APIlib.getInstance().addJSLine(String.format(Locale.US, this.jsBase + ".background(%s);", bool));
        return this;
    }

    public Tooltip background(String str) {
        APIlib.getInstance().addJSLine(String.format(Locale.US, this.jsBase + ".background(%s);", wrapQuotes(str)));
        return this;
    }

    public void disablePointerEvents() {
        APIlib.getInstance().addJSLine(this.jsBase + ".disablePointerEvents();");
    }

    public Tooltip disablePointerEvents(Boolean bool) {
        APIlib.getInstance().addJSLine(String.format(Locale.US, this.jsBase + ".disablePointerEvents(%s);", bool));
        return this;
    }

    public void displayMode() {
        APIlib.getInstance().addJSLine(this.jsBase + ".displayMode();");
    }

    public Tooltip displayMode(TooltipDisplayMode tooltipDisplayMode) {
        APIlib.getInstance().addJSLine(String.format(Locale.US, this.jsBase + ".displayMode(%s);", tooltipDisplayMode != null ? tooltipDisplayMode.getJsBase() : null));
        return this;
    }

    public Tooltip displayMode(String str) {
        APIlib.getInstance().addJSLine(String.format(Locale.US, this.jsBase + ".displayMode(%s);", wrapQuotes(str)));
        return this;
    }

    @Override // com.anychart.core.VisualBase
    public void enabled() {
        APIlib.getInstance().addJSLine(this.jsBase + ".enabled();");
    }

    @Override // com.anychart.core.VisualBase
    public Tooltip enabled(Boolean bool) {
        APIlib.getInstance().addJSLine(String.format(Locale.US, this.jsBase + ".enabled(%s);", bool));
        return this;
    }

    public void fontColor() {
        APIlib.getInstance().addJSLine(this.jsBase + ".fontColor();");
    }

    public Tooltip fontColor(String str) {
        APIlib.getInstance().addJSLine(String.format(Locale.US, this.jsBase + ".fontColor(%s);", wrapQuotes(str)));
        return this;
    }

    public void fontDecoration() {
        APIlib.getInstance().addJSLine(this.jsBase + ".fontDecoration();");
    }

    public Tooltip fontDecoration(Decoration decoration) {
        APIlib.getInstance().addJSLine(String.format(Locale.US, this.jsBase + ".fontDecoration(%s);", decoration != null ? decoration.getJsBase() : null));
        return this;
    }

    public Tooltip fontDecoration(String str) {
        APIlib.getInstance().addJSLine(String.format(Locale.US, this.jsBase + ".fontDecoration(%s);", wrapQuotes(str)));
        return this;
    }

    public void fontFamily() {
        APIlib.getInstance().addJSLine(this.jsBase + ".fontFamily();");
    }

    public Tooltip fontFamily(String str) {
        APIlib.getInstance().addJSLine(String.format(Locale.US, this.jsBase + ".fontFamily(%s);", wrapQuotes(str)));
        return this;
    }

    public void fontOpacity() {
        APIlib.getInstance().addJSLine(this.jsBase + ".fontOpacity();");
    }

    public Tooltip fontOpacity(Number number) {
        APIlib.getInstance().addJSLine(String.format(Locale.US, this.jsBase + ".fontOpacity(%s);", number));
        return this;
    }

    public void fontSize() {
        APIlib.getInstance().addJSLine(this.jsBase + ".fontSize();");
    }

    public Tooltip fontSize(Number number) {
        APIlib.getInstance().addJSLine(String.format(Locale.US, this.jsBase + ".fontSize(%s);", number));
        return this;
    }

    public Tooltip fontSize(String str) {
        APIlib.getInstance().addJSLine(String.format(Locale.US, this.jsBase + ".fontSize(%s);", wrapQuotes(str)));
        return this;
    }

    public void fontStyle() {
        APIlib.getInstance().addJSLine(this.jsBase + ".fontStyle();");
    }

    public Tooltip fontStyle(String str) {
        APIlib.getInstance().addJSLine(String.format(Locale.US, this.jsBase + ".fontStyle(%s);", wrapQuotes(str)));
        return this;
    }

    public Tooltip fontStyle(FontStyle fontStyle) {
        APIlib.getInstance().addJSLine(String.format(Locale.US, this.jsBase + ".fontStyle(%s);", fontStyle != null ? fontStyle.getJsBase() : null));
        return this;
    }

    public void fontVariant() {
        APIlib.getInstance().addJSLine(this.jsBase + ".fontVariant();");
    }

    public Tooltip fontVariant(String str) {
        APIlib.getInstance().addJSLine(String.format(Locale.US, this.jsBase + ".fontVariant(%s);", wrapQuotes(str)));
        return this;
    }

    public Tooltip fontVariant(FontVariant fontVariant) {
        APIlib.getInstance().addJSLine(String.format(Locale.US, this.jsBase + ".fontVariant(%s);", fontVariant != null ? fontVariant.getJsBase() : null));
        return this;
    }

    public void fontWeight() {
        APIlib.getInstance().addJSLine(this.jsBase + ".fontWeight();");
    }

    public Tooltip fontWeight(String str) {
        APIlib.getInstance().addJSLine(String.format(Locale.US, this.jsBase + ".fontWeight(%s);", wrapQuotes(str)));
        return this;
    }

    public Tooltip fontWeight(Number number) {
        APIlib.getInstance().addJSLine(String.format(Locale.US, this.jsBase + ".fontWeight(%s);", number));
        return this;
    }

    public void format() {
        APIlib.getInstance().addJSLine(this.jsBase + ".format();");
    }

    public Tooltip format(String str) {
        APIlib.getInstance().addJSLine(String.format(Locale.US, this.jsBase + ".format(%s);", wrapQuotes(str)));
        return this;
    }

    public void hAlign() {
        APIlib.getInstance().addJSLine(this.jsBase + ".hAlign();");
    }

    public Tooltip hAlign(String str) {
        APIlib.getInstance().addJSLine(String.format(Locale.US, this.jsBase + ".hAlign(%s);", wrapQuotes(str)));
        return this;
    }

    public Tooltip hAlign(HAlign hAlign) {
        APIlib.getInstance().addJSLine(String.format(Locale.US, this.jsBase + ".hAlign(%s);", hAlign != null ? hAlign.getJsBase() : null));
        return this;
    }

    public void height() {
        APIlib.getInstance().addJSLine(this.jsBase + ".height();");
    }

    public Tooltip height(String str) {
        APIlib.getInstance().addJSLine(String.format(Locale.US, this.jsBase + ".height(%s);", wrapQuotes(str)));
        return this;
    }

    public Tooltip height(Number number) {
        APIlib.getInstance().addJSLine(String.format(Locale.US, this.jsBase + ".height(%s);", number));
        return this;
    }

    public void hideDelay() {
        APIlib.getInstance().addJSLine(this.jsBase + ".hideDelay();");
    }

    public Tooltip hideDelay(Number number) {
        APIlib.getInstance().addJSLine(String.format(Locale.US, this.jsBase + ".hideDelay(%s);", number));
        return this;
    }

    public void letterSpacing() {
        APIlib.getInstance().addJSLine(this.jsBase + ".letterSpacing();");
    }

    public Tooltip letterSpacing(Number number) {
        APIlib.getInstance().addJSLine(String.format(Locale.US, this.jsBase + ".letterSpacing(%s);", number));
        return this;
    }

    public void lineHeight() {
        APIlib.getInstance().addJSLine(this.jsBase + ".lineHeight();");
    }

    public Tooltip lineHeight(Number number) {
        APIlib.getInstance().addJSLine(String.format(Locale.US, this.jsBase + ".lineHeight(%s);", number));
        return this;
    }

    public Tooltip lineHeight(String str) {
        APIlib.getInstance().addJSLine(String.format(Locale.US, this.jsBase + ".lineHeight(%s);", wrapQuotes(str)));
        return this;
    }

    public void maxFontSize() {
        APIlib.getInstance().addJSLine(this.jsBase + ".maxFontSize();");
    }

    public Tooltip maxFontSize(Number number) {
        APIlib.getInstance().addJSLine(String.format(Locale.US, this.jsBase + ".maxFontSize(%s);", number));
        return this;
    }

    public Tooltip maxFontSize(String str) {
        APIlib.getInstance().addJSLine(String.format(Locale.US, this.jsBase + ".maxFontSize(%s);", wrapQuotes(str)));
        return this;
    }

    public void minFontSize() {
        APIlib.getInstance().addJSLine(this.jsBase + ".minFontSize();");
    }

    public Tooltip minFontSize(Number number) {
        APIlib.getInstance().addJSLine(String.format(Locale.US, this.jsBase + ".minFontSize(%s);", number));
        return this;
    }

    public Tooltip minFontSize(String str) {
        APIlib.getInstance().addJSLine(String.format(Locale.US, this.jsBase + ".minFontSize(%s);", wrapQuotes(str)));
        return this;
    }

    public void offsetX() {
        APIlib.getInstance().addJSLine(this.jsBase + ".offsetX();");
    }

    public Tooltip offsetX(Number number) {
        APIlib.getInstance().addJSLine(String.format(Locale.US, this.jsBase + ".offsetX(%s);", number));
        return this;
    }

    public void offsetY() {
        APIlib.getInstance().addJSLine(this.jsBase + ".offsetY();");
    }

    public Tooltip offsetY(Number number) {
        APIlib.getInstance().addJSLine(String.format(Locale.US, this.jsBase + ".offsetY(%s);", number));
        return this;
    }

    public void onBeforeContentChange() {
        APIlib.getInstance().addJSLine(this.jsBase + ".onBeforeContentChange();");
    }

    public void onBeforeTitleChange() {
        APIlib.getInstance().addJSLine(this.jsBase + ".onBeforeTitleChange();");
    }

    public void onContentChanged() {
        APIlib.getInstance().addJSLine(this.jsBase + ".onContentChanged();");
    }

    public Tooltip onContentChanged(String str) {
        APIlib.getInstance().addJSLine(String.format(Locale.US, this.jsBase + ".onContentChanged(%s);", wrapQuotes(str)));
        return this;
    }

    public void onDomReady() {
        APIlib.getInstance().addJSLine(this.jsBase + ".onDomReady();");
    }

    public Tooltip onDomReady(String str) {
        APIlib.getInstance().addJSLine(String.format(Locale.US, this.jsBase + ".onDomReady(%s);", wrapQuotes(str)));
        return this;
    }

    public void onTitleChanged() {
        APIlib.getInstance().addJSLine(this.jsBase + ".onTitleChanged();");
    }

    public Tooltip onTitleChanged(String str) {
        APIlib.getInstance().addJSLine(String.format(Locale.US, this.jsBase + ".onTitleChanged(%s);", wrapQuotes(str)));
        return this;
    }

    public Padding padding() {
        return new Padding(this.jsBase + ".padding()");
    }

    public Tooltip padding(Number[] numberArr) {
        APIlib.getInstance().addJSLine(String.format(Locale.US, this.jsBase + ".padding(%s);", Arrays.toString(numberArr)));
        return this;
    }

    public Tooltip padding(String[] strArr) {
        APIlib.getInstance().addJSLine(String.format(Locale.US, this.jsBase + ".padding(%s);", arrayToStringWrapQuotes(strArr)));
        return this;
    }

    public Tooltip padding(String str) {
        APIlib.getInstance().addJSLine(String.format(Locale.US, this.jsBase + ".padding(%s);", wrapQuotes(str)));
        return this;
    }

    public Tooltip padding(String str, String str2, String str3, String str4) {
        APIlib.getInstance().addJSLine(String.format(Locale.US, this.jsBase + ".padding(%s, %s, %s, %s);", wrapQuotes(str), wrapQuotes(str2), wrapQuotes(str3), wrapQuotes(str4)));
        return this;
    }

    public Tooltip padding(String str, String str2, String str3, Number number) {
        APIlib.getInstance().addJSLine(String.format(Locale.US, this.jsBase + ".padding(%s, %s, %s, %s);", wrapQuotes(str), wrapQuotes(str2), wrapQuotes(str3), number));
        return this;
    }

    public Tooltip padding(String str, String str2, Number number, String str3) {
        APIlib.getInstance().addJSLine(String.format(Locale.US, this.jsBase + ".padding(%s, %s, %s, %s);", wrapQuotes(str), wrapQuotes(str2), number, wrapQuotes(str3)));
        return this;
    }

    public Tooltip padding(String str, String str2, Number number, Number number2) {
        APIlib.getInstance().addJSLine(String.format(Locale.US, this.jsBase + ".padding(%s, %s, %s, %s);", wrapQuotes(str), wrapQuotes(str2), number, number2));
        return this;
    }

    public Tooltip padding(String str, Number number, String str2, String str3) {
        APIlib.getInstance().addJSLine(String.format(Locale.US, this.jsBase + ".padding(%s, %s, %s, %s);", wrapQuotes(str), number, wrapQuotes(str2), wrapQuotes(str3)));
        return this;
    }

    public Tooltip padding(String str, Number number, String str2, Number number2) {
        APIlib.getInstance().addJSLine(String.format(Locale.US, this.jsBase + ".padding(%s, %s, %s, %s);", wrapQuotes(str), number, wrapQuotes(str2), number2));
        return this;
    }

    public Tooltip padding(String str, Number number, Number number2, String str2) {
        APIlib.getInstance().addJSLine(String.format(Locale.US, this.jsBase + ".padding(%s, %s, %s, %s);", wrapQuotes(str), number, number2, wrapQuotes(str2)));
        return this;
    }

    public Tooltip padding(String str, Number number, Number number2, Number number3) {
        APIlib.getInstance().addJSLine(String.format(Locale.US, this.jsBase + ".padding(%s, %s, %s, %s);", wrapQuotes(str), number, number2, number3));
        return this;
    }

    public Tooltip padding(Number number, String str, String str2, String str3) {
        APIlib.getInstance().addJSLine(String.format(Locale.US, this.jsBase + ".padding(%s, %s, %s, %s);", number, wrapQuotes(str), wrapQuotes(str2), wrapQuotes(str3)));
        return this;
    }

    public Tooltip padding(Number number, String str, String str2, Number number2) {
        APIlib.getInstance().addJSLine(String.format(Locale.US, this.jsBase + ".padding(%s, %s, %s, %s);", number, wrapQuotes(str), wrapQuotes(str2), number2));
        return this;
    }

    public Tooltip padding(Number number, String str, Number number2, String str2) {
        APIlib.getInstance().addJSLine(String.format(Locale.US, this.jsBase + ".padding(%s, %s, %s, %s);", number, wrapQuotes(str), number2, wrapQuotes(str2)));
        return this;
    }

    public Tooltip padding(Number number, String str, Number number2, Number number3) {
        APIlib.getInstance().addJSLine(String.format(Locale.US, this.jsBase + ".padding(%s, %s, %s, %s);", number, wrapQuotes(str), number2, number3));
        return this;
    }

    public Tooltip padding(Number number, Number number2, String str, String str2) {
        APIlib.getInstance().addJSLine(String.format(Locale.US, this.jsBase + ".padding(%s, %s, %s, %s);", number, number2, wrapQuotes(str), wrapQuotes(str2)));
        return this;
    }

    public Tooltip padding(Number number, Number number2, String str, Number number3) {
        APIlib.getInstance().addJSLine(String.format(Locale.US, this.jsBase + ".padding(%s, %s, %s, %s);", number, number2, wrapQuotes(str), number3));
        return this;
    }

    public Tooltip padding(Number number, Number number2, Number number3, String str) {
        APIlib.getInstance().addJSLine(String.format(Locale.US, this.jsBase + ".padding(%s, %s, %s, %s);", number, number2, number3, wrapQuotes(str)));
        return this;
    }

    public Tooltip padding(Number number, Number number2, Number number3, Number number4) {
        APIlib.getInstance().addJSLine(String.format(Locale.US, this.jsBase + ".padding(%s, %s, %s, %s);", number, number2, number3, number4));
        return this;
    }

    public void position() {
        APIlib.getInstance().addJSLine(this.jsBase + ".position();");
    }

    public Tooltip position(Position position) {
        APIlib.getInstance().addJSLine(String.format(Locale.US, this.jsBase + ".position(%s);", position != null ? position.getJsBase() : null));
        return this;
    }

    public Tooltip position(String str) {
        APIlib.getInstance().addJSLine(String.format(Locale.US, this.jsBase + ".position(%s);", wrapQuotes(str)));
        return this;
    }

    public void positionMode() {
        APIlib.getInstance().addJSLine(this.jsBase + ".positionMode();");
    }

    public Tooltip positionMode(TooltipPositionMode tooltipPositionMode) {
        APIlib.getInstance().addJSLine(String.format(Locale.US, this.jsBase + ".positionMode(%s);", tooltipPositionMode != null ? tooltipPositionMode.getJsBase() : null));
        return this;
    }

    public Tooltip positionMode(String str) {
        APIlib.getInstance().addJSLine(String.format(Locale.US, this.jsBase + ".positionMode(%s);", wrapQuotes(str)));
        return this;
    }

    @Override // com.anychart.core.VisualBase
    public void print(PaperSize paperSize, Boolean bool) {
        APIlib.getInstance().addJSLine(String.format(Locale.US, this.jsBase + ".print(%s, %s);", paperSize != null ? paperSize.getJsBase() : null, bool));
    }

    @Override // com.anychart.core.VisualBase
    public void print(String str, Boolean bool) {
        APIlib.getInstance().addJSLine(String.format(Locale.US, this.jsBase + ".print(%s, %s);", wrapQuotes(str), bool));
    }

    @Override // com.anychart.core.VisualBase, com.anychart.core.Base
    public void removeAllListeners(String str) {
        APIlib.getInstance().addJSLine(String.format(Locale.US, this.jsBase + ".removeAllListeners(%s);", wrapQuotes(str)));
    }

    public void selectable() {
        APIlib.getInstance().addJSLine(this.jsBase + ".selectable();");
    }

    public Tooltip selectable(Boolean bool) {
        APIlib.getInstance().addJSLine(String.format(Locale.US, this.jsBase + ".selectable(%s);", bool));
        return this;
    }

    public Separator separator() {
        return new Separator(this.jsBase + ".separator()");
    }

    public Tooltip separator(Boolean bool) {
        APIlib.getInstance().addJSLine(String.format(Locale.US, this.jsBase + ".separator(%s);", bool));
        return this;
    }

    public Tooltip separator(String str) {
        APIlib.getInstance().addJSLine(String.format(Locale.US, this.jsBase + ".separator(%s);", wrapQuotes(str)));
        return this;
    }

    public void textDirection() {
        APIlib.getInstance().addJSLine(this.jsBase + ".textDirection();");
    }

    public Tooltip textDirection(String str) {
        APIlib.getInstance().addJSLine(String.format(Locale.US, this.jsBase + ".textDirection(%s);", wrapQuotes(str)));
        return this;
    }

    public Tooltip textDirection(Direction direction) {
        APIlib.getInstance().addJSLine(String.format(Locale.US, this.jsBase + ".textDirection(%s);", direction != null ? direction.getJsBase() : null));
        return this;
    }

    public void textIndent() {
        APIlib.getInstance().addJSLine(this.jsBase + ".textIndent();");
    }

    public Tooltip textIndent(Number number) {
        APIlib.getInstance().addJSLine(String.format(Locale.US, this.jsBase + ".textIndent(%s);", number));
        return this;
    }

    public void textOverflow() {
        APIlib.getInstance().addJSLine(this.jsBase + ".textOverflow();");
    }

    public Tooltip textOverflow(TextOverflow textOverflow) {
        APIlib.getInstance().addJSLine(String.format(Locale.US, this.jsBase + ".textOverflow(%s);", textOverflow != null ? textOverflow.getJsBase() : null));
        return this;
    }

    public Tooltip textOverflow(String str) {
        APIlib.getInstance().addJSLine(String.format(Locale.US, this.jsBase + ".textOverflow(%s);", wrapQuotes(str)));
        return this;
    }

    public void textSettings() {
        APIlib.getInstance().addJSLine(this.jsBase + ".textSettings();");
    }

    public Tooltip textSettings(String str) {
        APIlib.getInstance().addJSLine(String.format(Locale.US, this.jsBase + ".textSettings(%s);", wrapQuotes(str)));
        return this;
    }

    public Tooltip textSettings(String str, String str2) {
        APIlib.getInstance().addJSLine(String.format(Locale.US, this.jsBase + ".textSettings(%s, %s);", wrapQuotes(str), wrapQuotes(str2)));
        return this;
    }

    public Tooltip textSettings(String str, Number number) {
        APIlib.getInstance().addJSLine(String.format(Locale.US, this.jsBase + ".textSettings(%s, %s);", wrapQuotes(str), number));
        return this;
    }

    public Tooltip textSettings(String str, Boolean bool) {
        APIlib.getInstance().addJSLine(String.format(Locale.US, this.jsBase + ".textSettings(%s, %s);", wrapQuotes(str), bool));
        return this;
    }

    public Title title() {
        return new Title(this.jsBase + ".title()");
    }

    public Tooltip title(Boolean bool) {
        APIlib.getInstance().addJSLine(String.format(Locale.US, this.jsBase + ".title(%s);", bool));
        return this;
    }

    public Tooltip title(String str) {
        APIlib.getInstance().addJSLine(String.format(Locale.US, this.jsBase + ".title(%s);", wrapQuotes(str)));
        return this;
    }

    public void titleFormat() {
        APIlib.getInstance().addJSLine(this.jsBase + ".titleFormat();");
    }

    public Tooltip titleFormat(String str) {
        APIlib.getInstance().addJSLine(String.format(Locale.US, this.jsBase + ".titleFormat(%s);", wrapQuotes(str)));
        return this;
    }

    public void unionFormat() {
        APIlib.getInstance().addJSLine(this.jsBase + ".unionFormat();");
    }

    public Tooltip unionFormat(String str) {
        APIlib.getInstance().addJSLine(String.format(Locale.US, this.jsBase + ".unionFormat(%s);", wrapQuotes(str)));
        return this;
    }

    @Override // com.anychart.core.VisualBase, com.anychart.core.Base
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

    @Override // com.anychart.core.VisualBase, com.anychart.core.Base
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

    @Override // com.anychart.core.VisualBase, com.anychart.core.Base
    public void unlistenByKey(String str) {
        APIlib.getInstance().addJSLine(String.format(Locale.US, this.jsBase + ".unlistenByKey(%s);", wrapQuotes(str)));
    }

    public void useHtml() {
        APIlib.getInstance().addJSLine(this.jsBase + ".useHtml();");
    }

    public Tooltip useHtml(Boolean bool) {
        APIlib.getInstance().addJSLine(String.format(Locale.US, this.jsBase + ".useHtml(%s);", bool));
        return this;
    }

    public void vAlign() {
        APIlib.getInstance().addJSLine(this.jsBase + ".vAlign();");
    }

    public Tooltip vAlign(String str) {
        APIlib.getInstance().addJSLine(String.format(Locale.US, this.jsBase + ".vAlign(%s);", wrapQuotes(str)));
        return this;
    }

    public Tooltip vAlign(VAlign vAlign) {
        APIlib.getInstance().addJSLine(String.format(Locale.US, this.jsBase + ".vAlign(%s);", vAlign != null ? vAlign.getJsBase() : null));
        return this;
    }

    public void valuePostfix() {
        APIlib.getInstance().addJSLine(this.jsBase + ".valuePostfix();");
    }

    public Tooltip valuePostfix(String str) {
        APIlib.getInstance().addJSLine(String.format(Locale.US, this.jsBase + ".valuePostfix(%s);", wrapQuotes(str)));
        return this;
    }

    public void valuePrefix() {
        APIlib.getInstance().addJSLine(this.jsBase + ".valuePrefix();");
    }

    public Tooltip valuePrefix(String str) {
        APIlib.getInstance().addJSLine(String.format(Locale.US, this.jsBase + ".valuePrefix(%s);", wrapQuotes(str)));
        return this;
    }

    public void width() {
        APIlib.getInstance().addJSLine(this.jsBase + ".width();");
    }

    public Tooltip width(String str) {
        APIlib.getInstance().addJSLine(String.format(Locale.US, this.jsBase + ".width(%s);", wrapQuotes(str)));
        return this;
    }

    public Tooltip width(Number number) {
        APIlib.getInstance().addJSLine(String.format(Locale.US, this.jsBase + ".width(%s);", number));
        return this;
    }

    public void wordBreak() {
        APIlib.getInstance().addJSLine(this.jsBase + ".wordBreak();");
    }

    public Tooltip wordBreak(WordBreak wordBreak) {
        APIlib.getInstance().addJSLine(String.format(Locale.US, this.jsBase + ".wordBreak(%s);", wordBreak != null ? wordBreak.getJsBase() : null));
        return this;
    }

    public Tooltip wordBreak(String str) {
        APIlib.getInstance().addJSLine(String.format(Locale.US, this.jsBase + ".wordBreak(%s);", wrapQuotes(str)));
        return this;
    }

    public void wordWrap() {
        APIlib.getInstance().addJSLine(this.jsBase + ".wordWrap();");
    }

    public Tooltip wordWrap(WordWrap wordWrap) {
        APIlib.getInstance().addJSLine(String.format(Locale.US, this.jsBase + ".wordWrap(%s);", wordWrap != null ? wordWrap.getJsBase() : null));
        return this;
    }

    public Tooltip wordWrap(String str) {
        APIlib.getInstance().addJSLine(String.format(Locale.US, this.jsBase + ".wordWrap(%s);", wrapQuotes(str)));
        return this;
    }

    @Override // com.anychart.core.VisualBase
    public void zIndex() {
        APIlib.getInstance().addJSLine(this.jsBase + ".zIndex();");
    }

    @Override // com.anychart.core.VisualBase
    public Tooltip zIndex(Number number) {
        APIlib.getInstance().addJSLine(String.format(Locale.US, this.jsBase + ".zIndex(%s);", number));
        return this;
    }

    @Override // com.anychart.core.VisualBase
    public Layer container() {
        return new Layer(this.jsBase + ".container()");
    }

    @Override // com.anychart.core.VisualBase
    public Tooltip container(Layer layer) {
        APIlib.getInstance().addJSLine(String.format(Locale.US, this.jsBase + ".container(%s);", layer != null ? layer.getJsBase() : null));
        return this;
    }

    @Override // com.anychart.core.VisualBase
    public Tooltip container(Stage stage) {
        APIlib.getInstance().addJSLine(String.format(Locale.US, this.jsBase + ".container(%s);", stage != null ? stage.getJsBase() : null));
        return this;
    }

    @Override // com.anychart.core.VisualBase
    public Tooltip container(String str) {
        APIlib.getInstance().addJSLine(String.format(Locale.US, this.jsBase + ".container(%s);", wrapQuotes(str)));
        return this;
    }

    @Override // com.anychart.core.VisualBase
    public Rect parentBounds() {
        return new Rect(this.jsBase + ".parentBounds()");
    }

    @Override // com.anychart.core.VisualBase
    public Tooltip parentBounds(Rect rect) {
        APIlib.getInstance().addJSLine(String.format(Locale.US, this.jsBase + ".parentBounds(%s);", rect != null ? rect.getJsBase() : null));
        return this;
    }

    @Override // com.anychart.core.VisualBase
    public Tooltip parentBounds(String str) {
        APIlib.getInstance().addJSLine(String.format(Locale.US, this.jsBase + ".parentBounds(%s);", wrapQuotes(str)));
        return this;
    }

    @Override // com.anychart.core.VisualBase
    public Tooltip parentBounds(Number number) {
        APIlib.getInstance().addJSLine(String.format(Locale.US, this.jsBase + ".parentBounds(%s);", number));
        return this;
    }

    @Override // com.anychart.core.VisualBase
    public Tooltip parentBounds(Number number, Number number2, Number number3, Number number4) {
        APIlib.getInstance().addJSLine(String.format(Locale.US, this.jsBase + ".parentBounds(%s, %s, %s, %s);", number, number2, number3, number4));
        return this;
    }
}
