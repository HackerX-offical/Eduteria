package com.anychart.core.ui;

import com.amazonaws.services.s3.model.InstructionFileId;
import com.anychart.APIlib;
import com.anychart.chart.common.listener.ListenersInterface;
import com.anychart.core.axes.Linear;
import com.anychart.core.axes.Ticks;
import com.anychart.core.ui.markersfactory.Marker;
import com.anychart.core.ui.table.Padding;
import com.anychart.enums.Align;
import com.anychart.enums.LabelsOverlapMode;
import com.anychart.enums.Orientation;
import com.anychart.enums.ScaleTypes;
import com.anychart.graphics.vector.ColoredFill;
import com.anychart.graphics.vector.Layer;
import com.anychart.graphics.vector.PaperSize;
import com.anychart.graphics.vector.Stage;
import com.anychart.graphics.vector.Stroke;
import com.anychart.graphics.vector.StrokeLineCap;
import com.anychart.graphics.vector.StrokeLineJoin;
import com.anychart.math.Rect;
import com.anychart.scales.Base;
import java.util.Arrays;
import java.util.Locale;

/* JADX INFO: loaded from: classes5.dex */
public class ColorRange extends Linear {
    protected ColorRange() {
    }

    public static ColorRange instantiate() {
        return new ColorRange("new anychart.core.ui.colorRange()");
    }

    public ColorRange(String str) {
        StringBuilder sb = new StringBuilder("colorRange");
        int i = variableIndex + 1;
        variableIndex = i;
        this.jsBase = sb.append(i).toString();
        APIlib.getInstance().addJSLine(this.jsBase + " = " + str + ";");
    }

    @Override // com.anychart.core.axes.Linear, com.anychart.core.VisualBase, com.anychart.core.Base, com.anychart.JsObject
    public String getJsBase() {
        return this.jsBase;
    }

    public void align() {
        APIlib.getInstance().addJSLine(this.jsBase + ".align();");
    }

    public ColorRange align(Align align) {
        APIlib.getInstance().addJSLine(String.format(Locale.US, this.jsBase + ".align(%s);", align != null ? align.getJsBase() : null));
        return this;
    }

    public ColorRange align(String str) {
        APIlib.getInstance().addJSLine(String.format(Locale.US, this.jsBase + ".align(%s);", wrapQuotes(str)));
        return this;
    }

    public void colorLineSize() {
        APIlib.getInstance().addJSLine(this.jsBase + ".colorLineSize();");
    }

    public ColorRange colorLineSize(Number number) {
        APIlib.getInstance().addJSLine(String.format(Locale.US, this.jsBase + ".colorLineSize(%s);", number));
        return this;
    }

    @Override // com.anychart.core.axes.Linear
    public void drawFirstLabel() {
        APIlib.getInstance().addJSLine(this.jsBase + ".drawFirstLabel();");
    }

    @Override // com.anychart.core.axes.Linear
    public ColorRange drawFirstLabel(Boolean bool) {
        APIlib.getInstance().addJSLine(String.format(Locale.US, this.jsBase + ".drawFirstLabel(%s);", bool));
        return this;
    }

    @Override // com.anychart.core.axes.Linear
    public void drawLastLabel() {
        APIlib.getInstance().addJSLine(this.jsBase + ".drawLastLabel();");
    }

    @Override // com.anychart.core.axes.Linear
    public ColorRange drawLastLabel(Boolean bool) {
        APIlib.getInstance().addJSLine(String.format(Locale.US, this.jsBase + ".drawLastLabel(%s);", bool));
        return this;
    }

    @Override // com.anychart.core.axes.Linear, com.anychart.core.VisualBase
    public void enabled() {
        APIlib.getInstance().addJSLine(this.jsBase + ".enabled();");
    }

    @Override // com.anychart.core.axes.Linear, com.anychart.core.VisualBase
    public ColorRange enabled(Boolean bool) {
        APIlib.getInstance().addJSLine(String.format(Locale.US, this.jsBase + ".enabled(%s);", bool));
        return this;
    }

    @Override // com.anychart.core.axes.Linear
    public Rect getRemainingBounds() {
        return new Rect(this.jsBase + ".getRemainingBounds()");
    }

    @Override // com.anychart.core.axes.Linear
    public void isHorizontal() {
        APIlib.getInstance().addJSLine(this.jsBase + ".isHorizontal();");
    }

    @Override // com.anychart.core.axes.Linear
    public LabelsFactory labels() {
        return new LabelsFactory(this.jsBase + ".labels()");
    }

    @Override // com.anychart.core.axes.Linear
    public ColorRange labels(String str) {
        APIlib.getInstance().addJSLine(String.format(Locale.US, this.jsBase + ".labels(%s);", wrapQuotes(str)));
        return this;
    }

    @Override // com.anychart.core.axes.Linear
    public ColorRange labels(Boolean bool) {
        APIlib.getInstance().addJSLine(String.format(Locale.US, this.jsBase + ".labels(%s);", bool));
        return this;
    }

    public void length() {
        APIlib.getInstance().addJSLine(this.jsBase + ".length();");
    }

    public ColorRange length(String str) {
        APIlib.getInstance().addJSLine(String.format(Locale.US, this.jsBase + ".length(%s);", wrapQuotes(str)));
        return this;
    }

    public ColorRange length(Number number) {
        APIlib.getInstance().addJSLine(String.format(Locale.US, this.jsBase + ".length(%s);", number));
        return this;
    }

    public Marker marker() {
        return new Marker(this.jsBase + ".marker()");
    }

    public ColorRange marker(Marker marker) {
        APIlib.getInstance().addJSLine(String.format(Locale.US, this.jsBase + ".marker(%s);", marker != null ? marker.getJsBase() : null));
        return this;
    }

    public ColorRange marker(String str) {
        APIlib.getInstance().addJSLine(String.format(Locale.US, this.jsBase + ".marker(%s);", wrapQuotes(str)));
        return this;
    }

    @Override // com.anychart.core.axes.Linear
    public LabelsFactory minorLabels() {
        return new LabelsFactory(this.jsBase + ".minorLabels()");
    }

    @Override // com.anychart.core.axes.Linear
    public ColorRange minorLabels(String str) {
        APIlib.getInstance().addJSLine(String.format(Locale.US, this.jsBase + ".minorLabels(%s);", wrapQuotes(str)));
        return this;
    }

    @Override // com.anychart.core.axes.Linear
    public ColorRange minorLabels(Boolean bool) {
        APIlib.getInstance().addJSLine(String.format(Locale.US, this.jsBase + ".minorLabels(%s);", bool));
        return this;
    }

    @Override // com.anychart.core.axes.Linear
    public Ticks minorTicks() {
        return new Ticks(this.jsBase + ".minorTicks()");
    }

    @Override // com.anychart.core.axes.Linear
    public ColorRange minorTicks(String str) {
        APIlib.getInstance().addJSLine(String.format(Locale.US, this.jsBase + ".minorTicks(%s);", wrapQuotes(str)));
        return this;
    }

    @Override // com.anychart.core.axes.Linear
    public ColorRange minorTicks(Boolean bool) {
        APIlib.getInstance().addJSLine(String.format(Locale.US, this.jsBase + ".minorTicks(%s);", bool));
        return this;
    }

    @Override // com.anychart.core.axes.Linear
    public void orientation() {
        APIlib.getInstance().addJSLine(this.jsBase + ".orientation();");
    }

    @Override // com.anychart.core.axes.Linear
    public ColorRange orientation(Orientation orientation) {
        APIlib.getInstance().addJSLine(String.format(Locale.US, this.jsBase + ".orientation(%s);", orientation != null ? orientation.getJsBase() : null));
        return this;
    }

    @Override // com.anychart.core.axes.Linear
    public ColorRange orientation(String str) {
        APIlib.getInstance().addJSLine(String.format(Locale.US, this.jsBase + ".orientation(%s);", wrapQuotes(str)));
        return this;
    }

    @Override // com.anychart.core.axes.Linear
    public void overlapMode() {
        APIlib.getInstance().addJSLine(this.jsBase + ".overlapMode();");
    }

    @Override // com.anychart.core.axes.Linear
    public ColorRange overlapMode(LabelsOverlapMode labelsOverlapMode) {
        APIlib.getInstance().addJSLine(String.format(Locale.US, this.jsBase + ".overlapMode(%s);", labelsOverlapMode != null ? labelsOverlapMode.getJsBase() : null));
        return this;
    }

    @Override // com.anychart.core.axes.Linear
    public ColorRange overlapMode(String str) {
        APIlib.getInstance().addJSLine(String.format(Locale.US, this.jsBase + ".overlapMode(%s);", wrapQuotes(str)));
        return this;
    }

    public Padding padding() {
        return new Padding(this.jsBase + ".padding()");
    }

    public ColorRange padding(Number[] numberArr) {
        APIlib.getInstance().addJSLine(String.format(Locale.US, this.jsBase + ".padding(%s);", Arrays.toString(numberArr)));
        return this;
    }

    public ColorRange padding(String[] strArr) {
        APIlib.getInstance().addJSLine(String.format(Locale.US, this.jsBase + ".padding(%s);", arrayToStringWrapQuotes(strArr)));
        return this;
    }

    public ColorRange padding(String str) {
        APIlib.getInstance().addJSLine(String.format(Locale.US, this.jsBase + ".padding(%s);", wrapQuotes(str)));
        return this;
    }

    public ColorRange padding(String str, String str2, String str3, String str4) {
        APIlib.getInstance().addJSLine(String.format(Locale.US, this.jsBase + ".padding(%s, %s, %s, %s);", wrapQuotes(str), wrapQuotes(str2), wrapQuotes(str3), wrapQuotes(str4)));
        return this;
    }

    public ColorRange padding(String str, String str2, String str3, Number number) {
        APIlib.getInstance().addJSLine(String.format(Locale.US, this.jsBase + ".padding(%s, %s, %s, %s);", wrapQuotes(str), wrapQuotes(str2), wrapQuotes(str3), number));
        return this;
    }

    public ColorRange padding(String str, String str2, Number number, String str3) {
        APIlib.getInstance().addJSLine(String.format(Locale.US, this.jsBase + ".padding(%s, %s, %s, %s);", wrapQuotes(str), wrapQuotes(str2), number, wrapQuotes(str3)));
        return this;
    }

    public ColorRange padding(String str, String str2, Number number, Number number2) {
        APIlib.getInstance().addJSLine(String.format(Locale.US, this.jsBase + ".padding(%s, %s, %s, %s);", wrapQuotes(str), wrapQuotes(str2), number, number2));
        return this;
    }

    public ColorRange padding(String str, Number number, String str2, String str3) {
        APIlib.getInstance().addJSLine(String.format(Locale.US, this.jsBase + ".padding(%s, %s, %s, %s);", wrapQuotes(str), number, wrapQuotes(str2), wrapQuotes(str3)));
        return this;
    }

    public ColorRange padding(String str, Number number, String str2, Number number2) {
        APIlib.getInstance().addJSLine(String.format(Locale.US, this.jsBase + ".padding(%s, %s, %s, %s);", wrapQuotes(str), number, wrapQuotes(str2), number2));
        return this;
    }

    public ColorRange padding(String str, Number number, Number number2, String str2) {
        APIlib.getInstance().addJSLine(String.format(Locale.US, this.jsBase + ".padding(%s, %s, %s, %s);", wrapQuotes(str), number, number2, wrapQuotes(str2)));
        return this;
    }

    public ColorRange padding(String str, Number number, Number number2, Number number3) {
        APIlib.getInstance().addJSLine(String.format(Locale.US, this.jsBase + ".padding(%s, %s, %s, %s);", wrapQuotes(str), number, number2, number3));
        return this;
    }

    public ColorRange padding(Number number, String str, String str2, String str3) {
        APIlib.getInstance().addJSLine(String.format(Locale.US, this.jsBase + ".padding(%s, %s, %s, %s);", number, wrapQuotes(str), wrapQuotes(str2), wrapQuotes(str3)));
        return this;
    }

    public ColorRange padding(Number number, String str, String str2, Number number2) {
        APIlib.getInstance().addJSLine(String.format(Locale.US, this.jsBase + ".padding(%s, %s, %s, %s);", number, wrapQuotes(str), wrapQuotes(str2), number2));
        return this;
    }

    public ColorRange padding(Number number, String str, Number number2, String str2) {
        APIlib.getInstance().addJSLine(String.format(Locale.US, this.jsBase + ".padding(%s, %s, %s, %s);", number, wrapQuotes(str), number2, wrapQuotes(str2)));
        return this;
    }

    public ColorRange padding(Number number, String str, Number number2, Number number3) {
        APIlib.getInstance().addJSLine(String.format(Locale.US, this.jsBase + ".padding(%s, %s, %s, %s);", number, wrapQuotes(str), number2, number3));
        return this;
    }

    public ColorRange padding(Number number, Number number2, String str, String str2) {
        APIlib.getInstance().addJSLine(String.format(Locale.US, this.jsBase + ".padding(%s, %s, %s, %s);", number, number2, wrapQuotes(str), wrapQuotes(str2)));
        return this;
    }

    public ColorRange padding(Number number, Number number2, String str, Number number3) {
        APIlib.getInstance().addJSLine(String.format(Locale.US, this.jsBase + ".padding(%s, %s, %s, %s);", number, number2, wrapQuotes(str), number3));
        return this;
    }

    public ColorRange padding(Number number, Number number2, Number number3, String str) {
        APIlib.getInstance().addJSLine(String.format(Locale.US, this.jsBase + ".padding(%s, %s, %s, %s);", number, number2, number3, wrapQuotes(str)));
        return this;
    }

    public ColorRange padding(Number number, Number number2, Number number3, Number number4) {
        APIlib.getInstance().addJSLine(String.format(Locale.US, this.jsBase + ".padding(%s, %s, %s, %s);", number, number2, number3, number4));
        return this;
    }

    @Override // com.anychart.core.axes.Linear, com.anychart.core.VisualBase
    public void print(PaperSize paperSize, Boolean bool) {
        APIlib.getInstance().addJSLine(String.format(Locale.US, this.jsBase + ".print(%s, %s);", paperSize != null ? paperSize.getJsBase() : null, bool));
    }

    @Override // com.anychart.core.axes.Linear, com.anychart.core.VisualBase
    public void print(String str, Boolean bool) {
        APIlib.getInstance().addJSLine(String.format(Locale.US, this.jsBase + ".print(%s, %s);", wrapQuotes(str), bool));
    }

    @Override // com.anychart.core.axes.Linear, com.anychart.core.VisualBase, com.anychart.core.Base
    public void removeAllListeners(String str) {
        APIlib.getInstance().addJSLine(String.format(Locale.US, this.jsBase + ".removeAllListeners(%s);", wrapQuotes(str)));
    }

    @Override // com.anychart.core.axes.Linear
    public Base scale() {
        return new Base(this.jsBase + ".scale()");
    }

    @Override // com.anychart.core.axes.Linear
    public ColorRange scale(Base base) {
        APIlib.getInstance().addJSLine(String.format(Locale.US, this.jsBase + ".scale(%s);", base != null ? base.getJsBase() : null));
        return this;
    }

    @Override // com.anychart.core.axes.Linear
    public ColorRange scale(String str) {
        APIlib.getInstance().addJSLine(String.format(Locale.US, this.jsBase + ".scale(%s);", wrapQuotes(str)));
        return this;
    }

    @Override // com.anychart.core.axes.Linear
    public ColorRange scale(ScaleTypes scaleTypes) {
        APIlib.getInstance().addJSLine(String.format(Locale.US, this.jsBase + ".scale(%s);", scaleTypes != null ? scaleTypes.getJsBase() : null));
        return this;
    }

    @Override // com.anychart.core.axes.Linear
    public void staggerLines() {
        APIlib.getInstance().addJSLine(this.jsBase + ".staggerLines();");
    }

    @Override // com.anychart.core.axes.Linear
    public ColorRange staggerLines(Number number) {
        APIlib.getInstance().addJSLine(String.format(Locale.US, this.jsBase + ".staggerLines(%s);", number));
        return this;
    }

    @Override // com.anychart.core.axes.Linear
    public void staggerMaxLines() {
        APIlib.getInstance().addJSLine(this.jsBase + ".staggerMaxLines();");
    }

    @Override // com.anychart.core.axes.Linear
    public ColorRange staggerMaxLines(Number number) {
        APIlib.getInstance().addJSLine(String.format(Locale.US, this.jsBase + ".staggerMaxLines(%s);", number));
        return this;
    }

    @Override // com.anychart.core.axes.Linear
    public void staggerMode() {
        APIlib.getInstance().addJSLine(this.jsBase + ".staggerMode();");
    }

    @Override // com.anychart.core.axes.Linear
    public ColorRange staggerMode(Boolean bool) {
        APIlib.getInstance().addJSLine(String.format(Locale.US, this.jsBase + ".staggerMode(%s);", bool));
        return this;
    }

    @Override // com.anychart.core.axes.Linear
    public void stroke() {
        APIlib.getInstance().addJSLine(this.jsBase + ".stroke();");
    }

    @Override // com.anychart.core.axes.Linear
    public ColorRange stroke(Stroke stroke, Number number, String str, String str2, String str3) {
        APIlib.getInstance().addJSLine(String.format(Locale.US, this.jsBase + ".stroke(%s, %s, %s, %s, %s);", stroke != null ? stroke.getJsBase() : null, number, wrapQuotes(str), wrapQuotes(str2), wrapQuotes(str3)));
        return this;
    }

    @Override // com.anychart.core.axes.Linear
    public ColorRange stroke(Stroke stroke, Number number, String str, String str2, StrokeLineCap strokeLineCap) {
        APIlib.getInstance().addJSLine(String.format(Locale.US, this.jsBase + ".stroke(%s, %s, %s, %s, %s);", stroke != null ? stroke.getJsBase() : null, number, wrapQuotes(str), wrapQuotes(str2), strokeLineCap != null ? strokeLineCap.getJsBase() : null));
        return this;
    }

    @Override // com.anychart.core.axes.Linear
    public ColorRange stroke(Stroke stroke, Number number, String str, StrokeLineJoin strokeLineJoin, String str2) {
        APIlib.getInstance().addJSLine(String.format(Locale.US, this.jsBase + ".stroke(%s, %s, %s, %s, %s);", stroke != null ? stroke.getJsBase() : null, number, wrapQuotes(str), strokeLineJoin != null ? strokeLineJoin.getJsBase() : null, wrapQuotes(str2)));
        return this;
    }

    @Override // com.anychart.core.axes.Linear
    public ColorRange stroke(Stroke stroke, Number number, String str, StrokeLineJoin strokeLineJoin, StrokeLineCap strokeLineCap) {
        APIlib.getInstance().addJSLine(String.format(Locale.US, this.jsBase + ".stroke(%s, %s, %s, %s, %s);", stroke != null ? stroke.getJsBase() : null, number, wrapQuotes(str), strokeLineJoin != null ? strokeLineJoin.getJsBase() : null, strokeLineCap != null ? strokeLineCap.getJsBase() : null));
        return this;
    }

    @Override // com.anychart.core.axes.Linear
    public ColorRange stroke(ColoredFill coloredFill, Number number, String str, String str2, String str3) {
        APIlib.getInstance().addJSLine(String.format(Locale.US, this.jsBase + ".stroke(%s, %s, %s, %s, %s);", coloredFill != null ? coloredFill.getJsBase() : null, number, wrapQuotes(str), wrapQuotes(str2), wrapQuotes(str3)));
        return this;
    }

    @Override // com.anychart.core.axes.Linear
    public ColorRange stroke(ColoredFill coloredFill, Number number, String str, String str2, StrokeLineCap strokeLineCap) {
        APIlib.getInstance().addJSLine(String.format(Locale.US, this.jsBase + ".stroke(%s, %s, %s, %s, %s);", coloredFill != null ? coloredFill.getJsBase() : null, number, wrapQuotes(str), wrapQuotes(str2), strokeLineCap != null ? strokeLineCap.getJsBase() : null));
        return this;
    }

    @Override // com.anychart.core.axes.Linear
    public ColorRange stroke(ColoredFill coloredFill, Number number, String str, StrokeLineJoin strokeLineJoin, String str2) {
        APIlib.getInstance().addJSLine(String.format(Locale.US, this.jsBase + ".stroke(%s, %s, %s, %s, %s);", coloredFill != null ? coloredFill.getJsBase() : null, number, wrapQuotes(str), strokeLineJoin != null ? strokeLineJoin.getJsBase() : null, wrapQuotes(str2)));
        return this;
    }

    @Override // com.anychart.core.axes.Linear
    public ColorRange stroke(ColoredFill coloredFill, Number number, String str, StrokeLineJoin strokeLineJoin, StrokeLineCap strokeLineCap) {
        APIlib.getInstance().addJSLine(String.format(Locale.US, this.jsBase + ".stroke(%s, %s, %s, %s, %s);", coloredFill != null ? coloredFill.getJsBase() : null, number, wrapQuotes(str), strokeLineJoin != null ? strokeLineJoin.getJsBase() : null, strokeLineCap != null ? strokeLineCap.getJsBase() : null));
        return this;
    }

    @Override // com.anychart.core.axes.Linear
    public ColorRange stroke(String str, Number number, String str2, String str3, String str4) {
        APIlib.getInstance().addJSLine(String.format(Locale.US, this.jsBase + ".stroke(%s, %s, %s, %s, %s);", wrapQuotes(str), number, wrapQuotes(str2), wrapQuotes(str3), wrapQuotes(str4)));
        return this;
    }

    @Override // com.anychart.core.axes.Linear
    public ColorRange stroke(String str, Number number, String str2, String str3, StrokeLineCap strokeLineCap) {
        APIlib.getInstance().addJSLine(String.format(Locale.US, this.jsBase + ".stroke(%s, %s, %s, %s, %s);", wrapQuotes(str), number, wrapQuotes(str2), wrapQuotes(str3), strokeLineCap != null ? strokeLineCap.getJsBase() : null));
        return this;
    }

    @Override // com.anychart.core.axes.Linear
    public ColorRange stroke(String str, Number number, String str2, StrokeLineJoin strokeLineJoin, String str3) {
        APIlib.getInstance().addJSLine(String.format(Locale.US, this.jsBase + ".stroke(%s, %s, %s, %s, %s);", wrapQuotes(str), number, wrapQuotes(str2), strokeLineJoin != null ? strokeLineJoin.getJsBase() : null, wrapQuotes(str3)));
        return this;
    }

    @Override // com.anychart.core.axes.Linear
    public ColorRange stroke(String str, Number number, String str2, StrokeLineJoin strokeLineJoin, StrokeLineCap strokeLineCap) {
        APIlib.getInstance().addJSLine(String.format(Locale.US, this.jsBase + ".stroke(%s, %s, %s, %s, %s);", wrapQuotes(str), number, wrapQuotes(str2), strokeLineJoin != null ? strokeLineJoin.getJsBase() : null, strokeLineCap != null ? strokeLineCap.getJsBase() : null));
        return this;
    }

    @Override // com.anychart.core.axes.Linear
    public ColorRange stroke(String str) {
        APIlib.getInstance().addJSLine(String.format(Locale.US, this.jsBase + ".stroke(%s);", wrapQuotes(str)));
        return this;
    }

    @Override // com.anychart.core.axes.Linear
    public Ticks ticks() {
        return new Ticks(this.jsBase + ".ticks()");
    }

    @Override // com.anychart.core.axes.Linear
    public ColorRange ticks(String str) {
        APIlib.getInstance().addJSLine(String.format(Locale.US, this.jsBase + ".ticks(%s);", wrapQuotes(str)));
        return this;
    }

    @Override // com.anychart.core.axes.Linear
    public ColorRange ticks(Boolean bool) {
        APIlib.getInstance().addJSLine(String.format(Locale.US, this.jsBase + ".ticks(%s);", bool));
        return this;
    }

    @Override // com.anychart.core.axes.Linear
    public Title title() {
        return new Title(this.jsBase + ".title()");
    }

    @Override // com.anychart.core.axes.Linear
    public ColorRange title(Boolean bool) {
        APIlib.getInstance().addJSLine(String.format(Locale.US, this.jsBase + ".title(%s);", bool));
        return this;
    }

    @Override // com.anychart.core.axes.Linear
    public ColorRange title(String str) {
        APIlib.getInstance().addJSLine(String.format(Locale.US, this.jsBase + ".title(%s);", wrapQuotes(str)));
        return this;
    }

    @Override // com.anychart.core.axes.Linear, com.anychart.core.VisualBase, com.anychart.core.Base
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

    @Override // com.anychart.core.axes.Linear, com.anychart.core.VisualBase, com.anychart.core.Base
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

    @Override // com.anychart.core.axes.Linear, com.anychart.core.VisualBase, com.anychart.core.Base
    public void unlistenByKey(String str) {
        APIlib.getInstance().addJSLine(String.format(Locale.US, this.jsBase + ".unlistenByKey(%s);", wrapQuotes(str)));
    }

    @Override // com.anychart.core.axes.Linear
    public void width() {
        APIlib.getInstance().addJSLine(this.jsBase + ".width();");
    }

    @Override // com.anychart.core.axes.Linear
    public ColorRange width(Number number) {
        APIlib.getInstance().addJSLine(String.format(Locale.US, this.jsBase + ".width(%s);", number));
        return this;
    }

    @Override // com.anychart.core.axes.Linear
    public ColorRange width(String str) {
        APIlib.getInstance().addJSLine(String.format(Locale.US, this.jsBase + ".width(%s);", wrapQuotes(str)));
        return this;
    }

    @Override // com.anychart.core.axes.Linear, com.anychart.core.VisualBase
    public void zIndex() {
        APIlib.getInstance().addJSLine(this.jsBase + ".zIndex();");
    }

    @Override // com.anychart.core.axes.Linear, com.anychart.core.VisualBase
    public ColorRange zIndex(Number number) {
        APIlib.getInstance().addJSLine(String.format(Locale.US, this.jsBase + ".zIndex(%s);", number));
        return this;
    }

    @Override // com.anychart.core.axes.Linear
    public Rect getPixelBounds() {
        return new Rect(this.jsBase + ".getPixelBounds()");
    }

    @Override // com.anychart.core.axes.Linear, com.anychart.core.VisualBase
    public Layer container() {
        return new Layer(this.jsBase + ".container()");
    }

    @Override // com.anychart.core.axes.Linear, com.anychart.core.VisualBase
    public ColorRange container(Layer layer) {
        APIlib.getInstance().addJSLine(String.format(Locale.US, this.jsBase + ".container(%s);", layer != null ? layer.getJsBase() : null));
        return this;
    }

    @Override // com.anychart.core.axes.Linear, com.anychart.core.VisualBase
    public ColorRange container(Stage stage) {
        APIlib.getInstance().addJSLine(String.format(Locale.US, this.jsBase + ".container(%s);", stage != null ? stage.getJsBase() : null));
        return this;
    }

    @Override // com.anychart.core.axes.Linear, com.anychart.core.VisualBase
    public ColorRange container(String str) {
        APIlib.getInstance().addJSLine(String.format(Locale.US, this.jsBase + ".container(%s);", wrapQuotes(str)));
        return this;
    }

    @Override // com.anychart.core.axes.Linear, com.anychart.core.VisualBase
    public Rect parentBounds() {
        return new Rect(this.jsBase + ".parentBounds()");
    }

    @Override // com.anychart.core.axes.Linear, com.anychart.core.VisualBase
    public ColorRange parentBounds(Rect rect) {
        APIlib.getInstance().addJSLine(String.format(Locale.US, this.jsBase + ".parentBounds(%s);", rect != null ? rect.getJsBase() : null));
        return this;
    }

    @Override // com.anychart.core.axes.Linear, com.anychart.core.VisualBase
    public ColorRange parentBounds(String str) {
        APIlib.getInstance().addJSLine(String.format(Locale.US, this.jsBase + ".parentBounds(%s);", wrapQuotes(str)));
        return this;
    }

    @Override // com.anychart.core.axes.Linear, com.anychart.core.VisualBase
    public ColorRange parentBounds(Number number) {
        APIlib.getInstance().addJSLine(String.format(Locale.US, this.jsBase + ".parentBounds(%s);", number));
        return this;
    }

    @Override // com.anychart.core.axes.Linear, com.anychart.core.VisualBase
    public ColorRange parentBounds(Number number, Number number2, Number number3, Number number4) {
        APIlib.getInstance().addJSLine(String.format(Locale.US, this.jsBase + ".parentBounds(%s, %s, %s, %s);", number, number2, number3, number4));
        return this;
    }
}
