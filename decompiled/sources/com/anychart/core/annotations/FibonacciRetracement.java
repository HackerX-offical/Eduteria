package com.anychart.core.annotations;

import com.amazonaws.services.s3.model.InstructionFileId;
import com.anychart.APIlib;
import com.anychart.chart.common.listener.ListenersInterface;
import com.anychart.core.SeparateChart;
import com.anychart.core.StateSettings;
import com.anychart.core.stock.Plot;
import com.anychart.core.ui.LabelsFactory;
import com.anychart.core.ui.MarkersFactory;
import com.anychart.core.utils.Bounds;
import com.anychart.enums.ScaleTypes;
import com.anychart.graphics.vector.ColoredFill;
import com.anychart.graphics.vector.Layer;
import com.anychart.graphics.vector.PaperSize;
import com.anychart.graphics.vector.Stage;
import com.anychart.graphics.vector.Stroke;
import com.anychart.graphics.vector.StrokeLineCap;
import com.anychart.graphics.vector.StrokeLineJoin;
import com.anychart.math.Rect;
import com.anychart.scales.Ordinal;
import com.anychart.scales.StockScatterDateTime;
import com.anychart.utils.RectObj;
import java.lang.reflect.InvocationTargetException;
import java.util.Locale;

/* JADX INFO: loaded from: classes5.dex */
public class FibonacciRetracement extends FibonacciBase {
    protected FibonacciRetracement() {
    }

    public static FibonacciRetracement instantiate() {
        return new FibonacciRetracement("new anychart.core.annotations.fibonacciRetracement()");
    }

    public FibonacciRetracement(String str) {
        StringBuilder sb = new StringBuilder("fibonacciRetracement");
        int i = variableIndex + 1;
        variableIndex = i;
        this.jsBase = sb.append(i).toString();
        APIlib.getInstance().addJSLine(this.jsBase + " = " + str + ";");
    }

    @Override // com.anychart.core.annotations.FibonacciBase, com.anychart.core.annotations.Base, com.anychart.core.VisualBaseWithBounds, com.anychart.core.VisualBase, com.anychart.core.Base, com.anychart.JsObject
    public String getJsBase() {
        return this.jsBase;
    }

    @Override // com.anychart.core.annotations.FibonacciBase, com.anychart.core.annotations.Base
    public void allowEdit() {
        APIlib.getInstance().addJSLine(this.jsBase + ".allowEdit();");
    }

    @Override // com.anychart.core.annotations.FibonacciBase, com.anychart.core.annotations.Base
    public FibonacciRetracement allowEdit(String str) {
        APIlib.getInstance().addJSLine(String.format(Locale.US, this.jsBase + ".allowEdit(%s);", wrapQuotes(str)));
        return this;
    }

    @Override // com.anychart.core.annotations.FibonacciBase, com.anychart.core.annotations.Base
    public void color() {
        APIlib.getInstance().addJSLine(this.jsBase + ".color();");
    }

    @Override // com.anychart.core.annotations.FibonacciBase, com.anychart.core.annotations.Base
    public FibonacciRetracement color(String str) {
        APIlib.getInstance().addJSLine(String.format(Locale.US, this.jsBase + ".color(%s);", wrapQuotes(str)));
        return this;
    }

    @Override // com.anychart.core.annotations.FibonacciBase, com.anychart.core.annotations.Base
    public SeparateChart getChart() {
        return new SeparateChart(this.jsBase + ".getChart()");
    }

    @Override // com.anychart.core.annotations.FibonacciBase, com.anychart.core.annotations.Base
    public Plot getPlot() {
        return new Plot(this.jsBase + ".getPlot()");
    }

    @Override // com.anychart.core.annotations.FibonacciBase, com.anychart.core.annotations.Base
    public void getType() {
        APIlib.getInstance().addJSLine(this.jsBase + ".getType();");
    }

    @Override // com.anychart.core.annotations.FibonacciBase, com.anychart.core.annotations.Base
    public void hoverGap() {
        APIlib.getInstance().addJSLine(this.jsBase + ".hoverGap();");
    }

    @Override // com.anychart.core.annotations.FibonacciBase, com.anychart.core.annotations.Base
    public FibonacciRetracement hoverGap(String str) {
        APIlib.getInstance().addJSLine(String.format(Locale.US, this.jsBase + ".hoverGap(%s);", wrapQuotes(str)));
        return this;
    }

    @Override // com.anychart.core.annotations.FibonacciBase, com.anychart.core.annotations.Base
    public StateSettings hovered() {
        return new StateSettings(this.jsBase + ".hovered()");
    }

    @Override // com.anychart.core.annotations.FibonacciBase, com.anychart.core.annotations.Base
    public FibonacciRetracement hovered(String str) {
        APIlib.getInstance().addJSLine(String.format(Locale.US, this.jsBase + ".hovered(%s);", wrapQuotes(str)));
        return this;
    }

    @Override // com.anychart.core.annotations.FibonacciBase
    public LabelsFactory labels() {
        return new LabelsFactory(this.jsBase + ".labels()");
    }

    @Override // com.anychart.core.annotations.FibonacciBase
    public FibonacciRetracement labels(String str) {
        APIlib.getInstance().addJSLine(String.format(Locale.US, this.jsBase + ".labels(%s);", wrapQuotes(str)));
        return this;
    }

    @Override // com.anychart.core.annotations.FibonacciBase
    public FibonacciRetracement labels(Boolean bool) {
        APIlib.getInstance().addJSLine(String.format(Locale.US, this.jsBase + ".labels(%s);", bool));
        return this;
    }

    @Override // com.anychart.core.annotations.FibonacciBase
    public void levels() {
        APIlib.getInstance().addJSLine(this.jsBase + ".levels();");
    }

    @Override // com.anychart.core.annotations.FibonacciBase
    public FibonacciRetracement levels(String[] strArr) {
        APIlib.getInstance().addJSLine(String.format(Locale.US, this.jsBase + ".levels(%s);", arrayToStringWrapQuotes(strArr)));
        return this;
    }

    @Override // com.anychart.core.annotations.FibonacciBase, com.anychart.core.annotations.Base
    public MarkersFactory markers() {
        return new MarkersFactory(this.jsBase + ".markers()");
    }

    @Override // com.anychart.core.annotations.FibonacciBase, com.anychart.core.annotations.Base
    public FibonacciRetracement markers(String str) {
        APIlib.getInstance().addJSLine(String.format(Locale.US, this.jsBase + ".markers(%s);", wrapQuotes(str)));
        return this;
    }

    @Override // com.anychart.core.annotations.FibonacciBase, com.anychart.core.annotations.Base
    public FibonacciRetracement markers(Boolean bool) {
        APIlib.getInstance().addJSLine(String.format(Locale.US, this.jsBase + ".markers(%s);", bool));
        return this;
    }

    @Override // com.anychart.core.annotations.FibonacciBase, com.anychart.core.annotations.Base
    public StateSettings normal() {
        return new StateSettings(this.jsBase + ".normal()");
    }

    @Override // com.anychart.core.annotations.FibonacciBase, com.anychart.core.annotations.Base
    public FibonacciRetracement normal(String str) {
        APIlib.getInstance().addJSLine(String.format(Locale.US, this.jsBase + ".normal(%s);", wrapQuotes(str)));
        return this;
    }

    @Override // com.anychart.core.annotations.FibonacciBase
    public void secondValueAnchor() {
        APIlib.getInstance().addJSLine(this.jsBase + ".secondValueAnchor();");
    }

    @Override // com.anychart.core.annotations.FibonacciBase
    public FibonacciRetracement secondValueAnchor(String str) {
        APIlib.getInstance().addJSLine(String.format(Locale.US, this.jsBase + ".secondValueAnchor(%s);", wrapQuotes(str)));
        return this;
    }

    @Override // com.anychart.core.annotations.FibonacciBase
    public void secondXAnchor() {
        APIlib.getInstance().addJSLine(this.jsBase + ".secondXAnchor();");
    }

    @Override // com.anychart.core.annotations.FibonacciBase
    public FibonacciRetracement secondXAnchor(String str) {
        APIlib.getInstance().addJSLine(String.format(Locale.US, this.jsBase + ".secondXAnchor(%s);", wrapQuotes(str)));
        return this;
    }

    @Override // com.anychart.core.annotations.FibonacciBase, com.anychart.core.annotations.Base
    public void select() {
        APIlib.getInstance().addJSLine(this.jsBase + ".select();");
    }

    @Override // com.anychart.core.annotations.FibonacciBase, com.anychart.core.annotations.Base
    public StateSettings selected() {
        return new StateSettings(this.jsBase + ".selected()");
    }

    @Override // com.anychart.core.annotations.FibonacciBase, com.anychart.core.annotations.Base
    public FibonacciRetracement selected(String str) {
        APIlib.getInstance().addJSLine(String.format(Locale.US, this.jsBase + ".selected(%s);", wrapQuotes(str)));
        return this;
    }

    @Override // com.anychart.core.annotations.FibonacciBase
    public void stroke() {
        APIlib.getInstance().addJSLine(this.jsBase + ".stroke();");
    }

    @Override // com.anychart.core.annotations.FibonacciBase
    public FibonacciRetracement stroke(Stroke stroke, Number number, String str, String str2, String str3) {
        APIlib.getInstance().addJSLine(String.format(Locale.US, this.jsBase + ".stroke(%s, %s, %s, %s, %s);", stroke != null ? stroke.getJsBase() : null, number, wrapQuotes(str), wrapQuotes(str2), wrapQuotes(str3)));
        return this;
    }

    @Override // com.anychart.core.annotations.FibonacciBase
    public FibonacciRetracement stroke(Stroke stroke, Number number, String str, String str2, StrokeLineCap strokeLineCap) {
        APIlib.getInstance().addJSLine(String.format(Locale.US, this.jsBase + ".stroke(%s, %s, %s, %s, %s);", stroke != null ? stroke.getJsBase() : null, number, wrapQuotes(str), wrapQuotes(str2), strokeLineCap != null ? strokeLineCap.getJsBase() : null));
        return this;
    }

    @Override // com.anychart.core.annotations.FibonacciBase
    public FibonacciRetracement stroke(Stroke stroke, Number number, String str, StrokeLineJoin strokeLineJoin, String str2) {
        APIlib.getInstance().addJSLine(String.format(Locale.US, this.jsBase + ".stroke(%s, %s, %s, %s, %s);", stroke != null ? stroke.getJsBase() : null, number, wrapQuotes(str), strokeLineJoin != null ? strokeLineJoin.getJsBase() : null, wrapQuotes(str2)));
        return this;
    }

    @Override // com.anychart.core.annotations.FibonacciBase
    public FibonacciRetracement stroke(Stroke stroke, Number number, String str, StrokeLineJoin strokeLineJoin, StrokeLineCap strokeLineCap) {
        APIlib.getInstance().addJSLine(String.format(Locale.US, this.jsBase + ".stroke(%s, %s, %s, %s, %s);", stroke != null ? stroke.getJsBase() : null, number, wrapQuotes(str), strokeLineJoin != null ? strokeLineJoin.getJsBase() : null, strokeLineCap != null ? strokeLineCap.getJsBase() : null));
        return this;
    }

    @Override // com.anychart.core.annotations.FibonacciBase
    public FibonacciRetracement stroke(ColoredFill coloredFill, Number number, String str, String str2, String str3) {
        APIlib.getInstance().addJSLine(String.format(Locale.US, this.jsBase + ".stroke(%s, %s, %s, %s, %s);", coloredFill != null ? coloredFill.getJsBase() : null, number, wrapQuotes(str), wrapQuotes(str2), wrapQuotes(str3)));
        return this;
    }

    @Override // com.anychart.core.annotations.FibonacciBase
    public FibonacciRetracement stroke(ColoredFill coloredFill, Number number, String str, String str2, StrokeLineCap strokeLineCap) {
        APIlib.getInstance().addJSLine(String.format(Locale.US, this.jsBase + ".stroke(%s, %s, %s, %s, %s);", coloredFill != null ? coloredFill.getJsBase() : null, number, wrapQuotes(str), wrapQuotes(str2), strokeLineCap != null ? strokeLineCap.getJsBase() : null));
        return this;
    }

    @Override // com.anychart.core.annotations.FibonacciBase
    public FibonacciRetracement stroke(ColoredFill coloredFill, Number number, String str, StrokeLineJoin strokeLineJoin, String str2) {
        APIlib.getInstance().addJSLine(String.format(Locale.US, this.jsBase + ".stroke(%s, %s, %s, %s, %s);", coloredFill != null ? coloredFill.getJsBase() : null, number, wrapQuotes(str), strokeLineJoin != null ? strokeLineJoin.getJsBase() : null, wrapQuotes(str2)));
        return this;
    }

    @Override // com.anychart.core.annotations.FibonacciBase
    public FibonacciRetracement stroke(ColoredFill coloredFill, Number number, String str, StrokeLineJoin strokeLineJoin, StrokeLineCap strokeLineCap) {
        APIlib.getInstance().addJSLine(String.format(Locale.US, this.jsBase + ".stroke(%s, %s, %s, %s, %s);", coloredFill != null ? coloredFill.getJsBase() : null, number, wrapQuotes(str), strokeLineJoin != null ? strokeLineJoin.getJsBase() : null, strokeLineCap != null ? strokeLineCap.getJsBase() : null));
        return this;
    }

    @Override // com.anychart.core.annotations.FibonacciBase
    public FibonacciRetracement stroke(String str, Number number, String str2, String str3, String str4) {
        APIlib.getInstance().addJSLine(String.format(Locale.US, this.jsBase + ".stroke(%s, %s, %s, %s, %s);", wrapQuotes(str), number, wrapQuotes(str2), wrapQuotes(str3), wrapQuotes(str4)));
        return this;
    }

    @Override // com.anychart.core.annotations.FibonacciBase
    public FibonacciRetracement stroke(String str, Number number, String str2, String str3, StrokeLineCap strokeLineCap) {
        APIlib.getInstance().addJSLine(String.format(Locale.US, this.jsBase + ".stroke(%s, %s, %s, %s, %s);", wrapQuotes(str), number, wrapQuotes(str2), wrapQuotes(str3), strokeLineCap != null ? strokeLineCap.getJsBase() : null));
        return this;
    }

    @Override // com.anychart.core.annotations.FibonacciBase
    public FibonacciRetracement stroke(String str, Number number, String str2, StrokeLineJoin strokeLineJoin, String str3) {
        APIlib.getInstance().addJSLine(String.format(Locale.US, this.jsBase + ".stroke(%s, %s, %s, %s, %s);", wrapQuotes(str), number, wrapQuotes(str2), strokeLineJoin != null ? strokeLineJoin.getJsBase() : null, wrapQuotes(str3)));
        return this;
    }

    @Override // com.anychart.core.annotations.FibonacciBase
    public FibonacciRetracement stroke(String str, Number number, String str2, StrokeLineJoin strokeLineJoin, StrokeLineCap strokeLineCap) {
        APIlib.getInstance().addJSLine(String.format(Locale.US, this.jsBase + ".stroke(%s, %s, %s, %s, %s);", wrapQuotes(str), number, wrapQuotes(str2), strokeLineJoin != null ? strokeLineJoin.getJsBase() : null, strokeLineCap != null ? strokeLineCap.getJsBase() : null));
        return this;
    }

    @Override // com.anychart.core.annotations.FibonacciBase
    public FibonacciRetracement stroke(String str) {
        APIlib.getInstance().addJSLine(String.format(Locale.US, this.jsBase + ".stroke(%s);", wrapQuotes(str)));
        return this;
    }

    @Override // com.anychart.core.annotations.FibonacciBase
    public void trend() {
        APIlib.getInstance().addJSLine(this.jsBase + ".trend();");
    }

    @Override // com.anychart.core.annotations.FibonacciBase
    public FibonacciRetracement trend(Stroke stroke, Number number, String str, String str2, String str3) {
        APIlib.getInstance().addJSLine(String.format(Locale.US, this.jsBase + ".trend(%s, %s, %s, %s, %s);", stroke != null ? stroke.getJsBase() : null, number, wrapQuotes(str), wrapQuotes(str2), wrapQuotes(str3)));
        return this;
    }

    @Override // com.anychart.core.annotations.FibonacciBase
    public FibonacciRetracement trend(Stroke stroke, Number number, String str, String str2, StrokeLineCap strokeLineCap) {
        APIlib.getInstance().addJSLine(String.format(Locale.US, this.jsBase + ".trend(%s, %s, %s, %s, %s);", stroke != null ? stroke.getJsBase() : null, number, wrapQuotes(str), wrapQuotes(str2), strokeLineCap != null ? strokeLineCap.getJsBase() : null));
        return this;
    }

    @Override // com.anychart.core.annotations.FibonacciBase
    public FibonacciRetracement trend(Stroke stroke, Number number, String str, StrokeLineJoin strokeLineJoin, String str2) {
        APIlib.getInstance().addJSLine(String.format(Locale.US, this.jsBase + ".trend(%s, %s, %s, %s, %s);", stroke != null ? stroke.getJsBase() : null, number, wrapQuotes(str), strokeLineJoin != null ? strokeLineJoin.getJsBase() : null, wrapQuotes(str2)));
        return this;
    }

    @Override // com.anychart.core.annotations.FibonacciBase
    public FibonacciRetracement trend(Stroke stroke, Number number, String str, StrokeLineJoin strokeLineJoin, StrokeLineCap strokeLineCap) {
        APIlib.getInstance().addJSLine(String.format(Locale.US, this.jsBase + ".trend(%s, %s, %s, %s, %s);", stroke != null ? stroke.getJsBase() : null, number, wrapQuotes(str), strokeLineJoin != null ? strokeLineJoin.getJsBase() : null, strokeLineCap != null ? strokeLineCap.getJsBase() : null));
        return this;
    }

    @Override // com.anychart.core.annotations.FibonacciBase
    public FibonacciRetracement trend(ColoredFill coloredFill, Number number, String str, String str2, String str3) {
        APIlib.getInstance().addJSLine(String.format(Locale.US, this.jsBase + ".trend(%s, %s, %s, %s, %s);", coloredFill != null ? coloredFill.getJsBase() : null, number, wrapQuotes(str), wrapQuotes(str2), wrapQuotes(str3)));
        return this;
    }

    @Override // com.anychart.core.annotations.FibonacciBase
    public FibonacciRetracement trend(ColoredFill coloredFill, Number number, String str, String str2, StrokeLineCap strokeLineCap) {
        APIlib.getInstance().addJSLine(String.format(Locale.US, this.jsBase + ".trend(%s, %s, %s, %s, %s);", coloredFill != null ? coloredFill.getJsBase() : null, number, wrapQuotes(str), wrapQuotes(str2), strokeLineCap != null ? strokeLineCap.getJsBase() : null));
        return this;
    }

    @Override // com.anychart.core.annotations.FibonacciBase
    public FibonacciRetracement trend(ColoredFill coloredFill, Number number, String str, StrokeLineJoin strokeLineJoin, String str2) {
        APIlib.getInstance().addJSLine(String.format(Locale.US, this.jsBase + ".trend(%s, %s, %s, %s, %s);", coloredFill != null ? coloredFill.getJsBase() : null, number, wrapQuotes(str), strokeLineJoin != null ? strokeLineJoin.getJsBase() : null, wrapQuotes(str2)));
        return this;
    }

    @Override // com.anychart.core.annotations.FibonacciBase
    public FibonacciRetracement trend(ColoredFill coloredFill, Number number, String str, StrokeLineJoin strokeLineJoin, StrokeLineCap strokeLineCap) {
        APIlib.getInstance().addJSLine(String.format(Locale.US, this.jsBase + ".trend(%s, %s, %s, %s, %s);", coloredFill != null ? coloredFill.getJsBase() : null, number, wrapQuotes(str), strokeLineJoin != null ? strokeLineJoin.getJsBase() : null, strokeLineCap != null ? strokeLineCap.getJsBase() : null));
        return this;
    }

    @Override // com.anychart.core.annotations.FibonacciBase
    public FibonacciRetracement trend(String str, Number number, String str2, String str3, String str4) {
        APIlib.getInstance().addJSLine(String.format(Locale.US, this.jsBase + ".trend(%s, %s, %s, %s, %s);", wrapQuotes(str), number, wrapQuotes(str2), wrapQuotes(str3), wrapQuotes(str4)));
        return this;
    }

    @Override // com.anychart.core.annotations.FibonacciBase
    public FibonacciRetracement trend(String str, Number number, String str2, String str3, StrokeLineCap strokeLineCap) {
        APIlib.getInstance().addJSLine(String.format(Locale.US, this.jsBase + ".trend(%s, %s, %s, %s, %s);", wrapQuotes(str), number, wrapQuotes(str2), wrapQuotes(str3), strokeLineCap != null ? strokeLineCap.getJsBase() : null));
        return this;
    }

    @Override // com.anychart.core.annotations.FibonacciBase
    public FibonacciRetracement trend(String str, Number number, String str2, StrokeLineJoin strokeLineJoin, String str3) {
        APIlib.getInstance().addJSLine(String.format(Locale.US, this.jsBase + ".trend(%s, %s, %s, %s, %s);", wrapQuotes(str), number, wrapQuotes(str2), strokeLineJoin != null ? strokeLineJoin.getJsBase() : null, wrapQuotes(str3)));
        return this;
    }

    @Override // com.anychart.core.annotations.FibonacciBase
    public FibonacciRetracement trend(String str, Number number, String str2, StrokeLineJoin strokeLineJoin, StrokeLineCap strokeLineCap) {
        APIlib.getInstance().addJSLine(String.format(Locale.US, this.jsBase + ".trend(%s, %s, %s, %s, %s);", wrapQuotes(str), number, wrapQuotes(str2), strokeLineJoin != null ? strokeLineJoin.getJsBase() : null, strokeLineCap != null ? strokeLineCap.getJsBase() : null));
        return this;
    }

    @Override // com.anychart.core.annotations.FibonacciBase
    public void valueAnchor() {
        APIlib.getInstance().addJSLine(this.jsBase + ".valueAnchor();");
    }

    @Override // com.anychart.core.annotations.FibonacciBase
    public FibonacciRetracement valueAnchor(String str) {
        APIlib.getInstance().addJSLine(String.format(Locale.US, this.jsBase + ".valueAnchor(%s);", wrapQuotes(str)));
        return this;
    }

    @Override // com.anychart.core.annotations.FibonacciBase
    public void xAnchor() {
        APIlib.getInstance().addJSLine(this.jsBase + ".xAnchor();");
    }

    @Override // com.anychart.core.annotations.FibonacciBase
    public FibonacciRetracement xAnchor(String str) {
        APIlib.getInstance().addJSLine(String.format(Locale.US, this.jsBase + ".xAnchor(%s);", wrapQuotes(str)));
        return this;
    }

    @Override // com.anychart.core.annotations.FibonacciBase, com.anychart.core.annotations.Base
    public Ordinal xScale() {
        return new Ordinal(this.jsBase + ".xScale()");
    }

    @Override // com.anychart.core.annotations.FibonacciBase, com.anychart.core.annotations.Base
    public FibonacciRetracement xScale(com.anychart.scales.Base base) {
        APIlib.getInstance().addJSLine(String.format(Locale.US, this.jsBase + ".xScale(%s);", base != null ? base.getJsBase() : null));
        return this;
    }

    @Override // com.anychart.core.annotations.FibonacciBase, com.anychart.core.annotations.Base
    public FibonacciRetracement xScale(StockScatterDateTime stockScatterDateTime) {
        APIlib.getInstance().addJSLine(String.format(Locale.US, this.jsBase + ".xScale(%s);", stockScatterDateTime != null ? stockScatterDateTime.getJsBase() : null));
        return this;
    }

    @Override // com.anychart.core.annotations.FibonacciBase, com.anychart.core.annotations.Base
    public FibonacciRetracement xScale(String str) {
        APIlib.getInstance().addJSLine(String.format(Locale.US, this.jsBase + ".xScale(%s);", wrapQuotes(str)));
        return this;
    }

    @Override // com.anychart.core.annotations.FibonacciBase, com.anychart.core.annotations.Base
    public FibonacciRetracement xScale(ScaleTypes scaleTypes) {
        APIlib.getInstance().addJSLine(String.format(Locale.US, this.jsBase + ".xScale(%s);", scaleTypes != null ? scaleTypes.getJsBase() : null));
        return this;
    }

    @Override // com.anychart.core.annotations.FibonacciBase, com.anychart.core.annotations.Base
    public com.anychart.scales.Base yScale() {
        return new com.anychart.scales.Base(this.jsBase + ".yScale()");
    }

    @Override // com.anychart.core.annotations.FibonacciBase, com.anychart.core.annotations.Base
    public FibonacciRetracement yScale(com.anychart.scales.Base base) {
        APIlib.getInstance().addJSLine(String.format(Locale.US, this.jsBase + ".yScale(%s);", base != null ? base.getJsBase() : null));
        return this;
    }

    @Override // com.anychart.core.annotations.FibonacciBase, com.anychart.core.annotations.Base
    public FibonacciRetracement yScale(String str) {
        APIlib.getInstance().addJSLine(String.format(Locale.US, this.jsBase + ".yScale(%s);", wrapQuotes(str)));
        return this;
    }

    @Override // com.anychart.core.annotations.FibonacciBase, com.anychart.core.annotations.Base
    public FibonacciRetracement yScale(ScaleTypes scaleTypes) {
        APIlib.getInstance().addJSLine(String.format(Locale.US, this.jsBase + ".yScale(%s);", scaleTypes != null ? scaleTypes.getJsBase() : null));
        return this;
    }

    @Override // com.anychart.core.annotations.FibonacciBase, com.anychart.core.annotations.Base, com.anychart.core.VisualBaseWithBounds
    public void bottom() {
        APIlib.getInstance().addJSLine(this.jsBase + ".bottom();");
    }

    @Override // com.anychart.core.annotations.FibonacciBase, com.anychart.core.annotations.Base, com.anychart.core.VisualBaseWithBounds
    public FibonacciRetracement bottom(Number number) {
        APIlib.getInstance().addJSLine(String.format(Locale.US, this.jsBase + ".bottom(%s);", number));
        return this;
    }

    @Override // com.anychart.core.annotations.FibonacciBase, com.anychart.core.annotations.Base, com.anychart.core.VisualBaseWithBounds
    public FibonacciRetracement bottom(String str) {
        APIlib.getInstance().addJSLine(String.format(Locale.US, this.jsBase + ".bottom(%s);", wrapQuotes(str)));
        return this;
    }

    @Override // com.anychart.core.annotations.FibonacciBase, com.anychart.core.annotations.Base, com.anychart.core.VisualBaseWithBounds
    public Bounds bounds() {
        return new Bounds(this.jsBase + ".bounds()");
    }

    @Override // com.anychart.core.annotations.FibonacciBase, com.anychart.core.annotations.Base, com.anychart.core.VisualBaseWithBounds
    public FibonacciRetracement bounds(RectObj rectObj) {
        APIlib.getInstance().addJSLine(String.format(Locale.US, this.jsBase + ".bounds(%s);", rectObj != null ? rectObj.getJsBase() : null));
        return this;
    }

    @Override // com.anychart.core.annotations.FibonacciBase, com.anychart.core.annotations.Base, com.anychart.core.VisualBaseWithBounds
    public FibonacciRetracement bounds(Rect rect) {
        APIlib.getInstance().addJSLine(String.format(Locale.US, this.jsBase + ".bounds(%s);", rect != null ? rect.getJsBase() : null));
        return this;
    }

    @Override // com.anychart.core.annotations.FibonacciBase, com.anychart.core.annotations.Base, com.anychart.core.VisualBaseWithBounds
    public FibonacciRetracement bounds(Bounds bounds) {
        APIlib.getInstance().addJSLine(String.format(Locale.US, this.jsBase + ".bounds(%s);", bounds != null ? bounds.getJsBase() : null));
        return this;
    }

    @Override // com.anychart.core.annotations.FibonacciBase, com.anychart.core.annotations.Base, com.anychart.core.VisualBaseWithBounds
    public FibonacciRetracement bounds(Number number, Number number2, Number number3, Number number4) {
        APIlib.getInstance().addJSLine(String.format(Locale.US, this.jsBase + ".bounds(%s, %s, %s, %s);", number, number2, number3, number4));
        return this;
    }

    @Override // com.anychart.core.annotations.FibonacciBase, com.anychart.core.annotations.Base, com.anychart.core.VisualBaseWithBounds
    public FibonacciRetracement bounds(Number number, Number number2, Number number3, String str) {
        APIlib.getInstance().addJSLine(String.format(Locale.US, this.jsBase + ".bounds(%s, %s, %s, %s);", number, number2, number3, wrapQuotes(str)));
        return this;
    }

    @Override // com.anychart.core.annotations.FibonacciBase, com.anychart.core.annotations.Base, com.anychart.core.VisualBaseWithBounds
    public FibonacciRetracement bounds(Number number, Number number2, String str, Number number3) {
        APIlib.getInstance().addJSLine(String.format(Locale.US, this.jsBase + ".bounds(%s, %s, %s, %s);", number, number2, wrapQuotes(str), number3));
        return this;
    }

    @Override // com.anychart.core.annotations.FibonacciBase, com.anychart.core.annotations.Base, com.anychart.core.VisualBaseWithBounds
    public FibonacciRetracement bounds(Number number, Number number2, String str, String str2) {
        APIlib.getInstance().addJSLine(String.format(Locale.US, this.jsBase + ".bounds(%s, %s, %s, %s);", number, number2, wrapQuotes(str), wrapQuotes(str2)));
        return this;
    }

    @Override // com.anychart.core.annotations.FibonacciBase, com.anychart.core.annotations.Base, com.anychart.core.VisualBaseWithBounds
    public FibonacciRetracement bounds(Number number, String str, Number number2, Number number3) {
        APIlib.getInstance().addJSLine(String.format(Locale.US, this.jsBase + ".bounds(%s, %s, %s, %s);", number, wrapQuotes(str), number2, number3));
        return this;
    }

    @Override // com.anychart.core.annotations.FibonacciBase, com.anychart.core.annotations.Base, com.anychart.core.VisualBaseWithBounds
    public FibonacciRetracement bounds(Number number, String str, Number number2, String str2) {
        APIlib.getInstance().addJSLine(String.format(Locale.US, this.jsBase + ".bounds(%s, %s, %s, %s);", number, wrapQuotes(str), number2, wrapQuotes(str2)));
        return this;
    }

    @Override // com.anychart.core.annotations.FibonacciBase, com.anychart.core.annotations.Base, com.anychart.core.VisualBaseWithBounds
    public FibonacciRetracement bounds(Number number, String str, String str2, Number number2) {
        APIlib.getInstance().addJSLine(String.format(Locale.US, this.jsBase + ".bounds(%s, %s, %s, %s);", number, wrapQuotes(str), wrapQuotes(str2), number2));
        return this;
    }

    @Override // com.anychart.core.annotations.FibonacciBase, com.anychart.core.annotations.Base, com.anychart.core.VisualBaseWithBounds
    public FibonacciRetracement bounds(Number number, String str, String str2, String str3) {
        APIlib.getInstance().addJSLine(String.format(Locale.US, this.jsBase + ".bounds(%s, %s, %s, %s);", number, wrapQuotes(str), wrapQuotes(str2), wrapQuotes(str3)));
        return this;
    }

    @Override // com.anychart.core.annotations.FibonacciBase, com.anychart.core.annotations.Base, com.anychart.core.VisualBaseWithBounds
    public FibonacciRetracement bounds(String str, Number number, Number number2, Number number3) {
        APIlib.getInstance().addJSLine(String.format(Locale.US, this.jsBase + ".bounds(%s, %s, %s, %s);", wrapQuotes(str), number, number2, number3));
        return this;
    }

    @Override // com.anychart.core.annotations.FibonacciBase, com.anychart.core.annotations.Base, com.anychart.core.VisualBaseWithBounds
    public FibonacciRetracement bounds(String str, Number number, Number number2, String str2) {
        APIlib.getInstance().addJSLine(String.format(Locale.US, this.jsBase + ".bounds(%s, %s, %s, %s);", wrapQuotes(str), number, number2, wrapQuotes(str2)));
        return this;
    }

    @Override // com.anychart.core.annotations.FibonacciBase, com.anychart.core.annotations.Base, com.anychart.core.VisualBaseWithBounds
    public FibonacciRetracement bounds(String str, Number number, String str2, Number number2) {
        APIlib.getInstance().addJSLine(String.format(Locale.US, this.jsBase + ".bounds(%s, %s, %s, %s);", wrapQuotes(str), number, wrapQuotes(str2), number2));
        return this;
    }

    @Override // com.anychart.core.annotations.FibonacciBase, com.anychart.core.annotations.Base, com.anychart.core.VisualBaseWithBounds
    public FibonacciRetracement bounds(String str, Number number, String str2, String str3) {
        APIlib.getInstance().addJSLine(String.format(Locale.US, this.jsBase + ".bounds(%s, %s, %s, %s);", wrapQuotes(str), number, wrapQuotes(str2), wrapQuotes(str3)));
        return this;
    }

    @Override // com.anychart.core.annotations.FibonacciBase, com.anychart.core.annotations.Base, com.anychart.core.VisualBaseWithBounds
    public FibonacciRetracement bounds(String str, String str2, Number number, Number number2) {
        APIlib.getInstance().addJSLine(String.format(Locale.US, this.jsBase + ".bounds(%s, %s, %s, %s);", wrapQuotes(str), wrapQuotes(str2), number, number2));
        return this;
    }

    @Override // com.anychart.core.annotations.FibonacciBase, com.anychart.core.annotations.Base, com.anychart.core.VisualBaseWithBounds
    public FibonacciRetracement bounds(String str, String str2, Number number, String str3) {
        APIlib.getInstance().addJSLine(String.format(Locale.US, this.jsBase + ".bounds(%s, %s, %s, %s);", wrapQuotes(str), wrapQuotes(str2), number, wrapQuotes(str3)));
        return this;
    }

    @Override // com.anychart.core.annotations.FibonacciBase, com.anychart.core.annotations.Base, com.anychart.core.VisualBaseWithBounds
    public FibonacciRetracement bounds(String str, String str2, String str3, Number number) {
        APIlib.getInstance().addJSLine(String.format(Locale.US, this.jsBase + ".bounds(%s, %s, %s, %s);", wrapQuotes(str), wrapQuotes(str2), wrapQuotes(str3), number));
        return this;
    }

    @Override // com.anychart.core.annotations.FibonacciBase, com.anychart.core.annotations.Base, com.anychart.core.VisualBaseWithBounds
    public FibonacciRetracement bounds(String str, String str2, String str3, String str4) {
        APIlib.getInstance().addJSLine(String.format(Locale.US, this.jsBase + ".bounds(%s, %s, %s, %s);", wrapQuotes(str), wrapQuotes(str2), wrapQuotes(str3), wrapQuotes(str4)));
        return this;
    }

    @Override // com.anychart.core.annotations.FibonacciBase, com.anychart.core.annotations.Base, com.anychart.core.VisualBaseWithBounds, com.anychart.core.VisualBase
    public void enabled() {
        APIlib.getInstance().addJSLine(this.jsBase + ".enabled();");
    }

    @Override // com.anychart.core.annotations.FibonacciBase, com.anychart.core.annotations.Base, com.anychart.core.VisualBaseWithBounds, com.anychart.core.VisualBase
    public FibonacciRetracement enabled(Boolean bool) {
        APIlib.getInstance().addJSLine(String.format(Locale.US, this.jsBase + ".enabled(%s);", bool));
        return this;
    }

    @Override // com.anychart.core.annotations.FibonacciBase, com.anychart.core.annotations.Base, com.anychart.core.VisualBaseWithBounds
    public Rect getPixelBounds() {
        return new Rect(this.jsBase + ".getPixelBounds()");
    }

    @Override // com.anychart.core.annotations.FibonacciBase, com.anychart.core.annotations.Base, com.anychart.core.VisualBaseWithBounds
    public void height() {
        APIlib.getInstance().addJSLine(this.jsBase + ".height();");
    }

    @Override // com.anychart.core.annotations.FibonacciBase, com.anychart.core.annotations.Base, com.anychart.core.VisualBaseWithBounds
    public FibonacciRetracement height(Number number) {
        APIlib.getInstance().addJSLine(String.format(Locale.US, this.jsBase + ".height(%s);", number));
        return this;
    }

    @Override // com.anychart.core.annotations.FibonacciBase, com.anychart.core.annotations.Base, com.anychart.core.VisualBaseWithBounds
    public FibonacciRetracement height(String str) {
        APIlib.getInstance().addJSLine(String.format(Locale.US, this.jsBase + ".height(%s);", wrapQuotes(str)));
        return this;
    }

    @Override // com.anychart.core.annotations.FibonacciBase, com.anychart.core.annotations.Base, com.anychart.core.VisualBaseWithBounds
    public void left() {
        APIlib.getInstance().addJSLine(this.jsBase + ".left();");
    }

    @Override // com.anychart.core.annotations.FibonacciBase, com.anychart.core.annotations.Base, com.anychart.core.VisualBaseWithBounds
    public FibonacciRetracement left(Number number) {
        APIlib.getInstance().addJSLine(String.format(Locale.US, this.jsBase + ".left(%s);", number));
        return this;
    }

    @Override // com.anychart.core.annotations.FibonacciBase, com.anychart.core.annotations.Base, com.anychart.core.VisualBaseWithBounds
    public FibonacciRetracement left(String str) {
        APIlib.getInstance().addJSLine(String.format(Locale.US, this.jsBase + ".left(%s);", wrapQuotes(str)));
        return this;
    }

    @Override // com.anychart.core.annotations.FibonacciBase, com.anychart.core.annotations.Base, com.anychart.core.VisualBaseWithBounds
    public void maxHeight() {
        APIlib.getInstance().addJSLine(this.jsBase + ".maxHeight();");
    }

    @Override // com.anychart.core.annotations.FibonacciBase, com.anychart.core.annotations.Base, com.anychart.core.VisualBaseWithBounds
    public FibonacciRetracement maxHeight(Number number) {
        APIlib.getInstance().addJSLine(String.format(Locale.US, this.jsBase + ".maxHeight(%s);", number));
        return this;
    }

    @Override // com.anychart.core.annotations.FibonacciBase, com.anychart.core.annotations.Base, com.anychart.core.VisualBaseWithBounds
    public FibonacciRetracement maxHeight(String str) {
        APIlib.getInstance().addJSLine(String.format(Locale.US, this.jsBase + ".maxHeight(%s);", wrapQuotes(str)));
        return this;
    }

    @Override // com.anychart.core.annotations.FibonacciBase, com.anychart.core.annotations.Base, com.anychart.core.VisualBaseWithBounds
    public void maxWidth() {
        APIlib.getInstance().addJSLine(this.jsBase + ".maxWidth();");
    }

    @Override // com.anychart.core.annotations.FibonacciBase, com.anychart.core.annotations.Base, com.anychart.core.VisualBaseWithBounds
    public FibonacciRetracement maxWidth(Number number) {
        APIlib.getInstance().addJSLine(String.format(Locale.US, this.jsBase + ".maxWidth(%s);", number));
        return this;
    }

    @Override // com.anychart.core.annotations.FibonacciBase, com.anychart.core.annotations.Base, com.anychart.core.VisualBaseWithBounds
    public FibonacciRetracement maxWidth(String str) {
        APIlib.getInstance().addJSLine(String.format(Locale.US, this.jsBase + ".maxWidth(%s);", wrapQuotes(str)));
        return this;
    }

    @Override // com.anychart.core.annotations.FibonacciBase, com.anychart.core.annotations.Base, com.anychart.core.VisualBaseWithBounds
    public void minHeight() {
        APIlib.getInstance().addJSLine(this.jsBase + ".minHeight();");
    }

    @Override // com.anychart.core.annotations.FibonacciBase, com.anychart.core.annotations.Base, com.anychart.core.VisualBaseWithBounds
    public FibonacciRetracement minHeight(Number number) {
        APIlib.getInstance().addJSLine(String.format(Locale.US, this.jsBase + ".minHeight(%s);", number));
        return this;
    }

    @Override // com.anychart.core.annotations.FibonacciBase, com.anychart.core.annotations.Base, com.anychart.core.VisualBaseWithBounds
    public FibonacciRetracement minHeight(String str) {
        APIlib.getInstance().addJSLine(String.format(Locale.US, this.jsBase + ".minHeight(%s);", wrapQuotes(str)));
        return this;
    }

    @Override // com.anychart.core.annotations.FibonacciBase, com.anychart.core.annotations.Base, com.anychart.core.VisualBaseWithBounds
    public void minWidth() {
        APIlib.getInstance().addJSLine(this.jsBase + ".minWidth();");
    }

    @Override // com.anychart.core.annotations.FibonacciBase, com.anychart.core.annotations.Base, com.anychart.core.VisualBaseWithBounds
    public FibonacciRetracement minWidth(Number number) {
        APIlib.getInstance().addJSLine(String.format(Locale.US, this.jsBase + ".minWidth(%s);", number));
        return this;
    }

    @Override // com.anychart.core.annotations.FibonacciBase, com.anychart.core.annotations.Base, com.anychart.core.VisualBaseWithBounds
    public FibonacciRetracement minWidth(String str) {
        APIlib.getInstance().addJSLine(String.format(Locale.US, this.jsBase + ".minWidth(%s);", wrapQuotes(str)));
        return this;
    }

    @Override // com.anychart.core.annotations.FibonacciBase, com.anychart.core.annotations.Base, com.anychart.core.VisualBaseWithBounds, com.anychart.core.VisualBase
    public void print(PaperSize paperSize, Boolean bool) {
        APIlib.getInstance().addJSLine(String.format(Locale.US, this.jsBase + ".print(%s, %s);", paperSize != null ? paperSize.getJsBase() : null, bool));
    }

    @Override // com.anychart.core.annotations.FibonacciBase, com.anychart.core.annotations.Base, com.anychart.core.VisualBaseWithBounds, com.anychart.core.VisualBase
    public void print(String str, Boolean bool) {
        APIlib.getInstance().addJSLine(String.format(Locale.US, this.jsBase + ".print(%s, %s);", wrapQuotes(str), bool));
    }

    @Override // com.anychart.core.annotations.FibonacciBase, com.anychart.core.annotations.Base, com.anychart.core.VisualBaseWithBounds, com.anychart.core.VisualBase, com.anychart.core.Base
    public void removeAllListeners(String str) {
        APIlib.getInstance().addJSLine(String.format(Locale.US, this.jsBase + ".removeAllListeners(%s);", wrapQuotes(str)));
    }

    @Override // com.anychart.core.annotations.FibonacciBase, com.anychart.core.annotations.Base, com.anychart.core.VisualBaseWithBounds
    public void right() {
        APIlib.getInstance().addJSLine(this.jsBase + ".right();");
    }

    @Override // com.anychart.core.annotations.FibonacciBase, com.anychart.core.annotations.Base, com.anychart.core.VisualBaseWithBounds
    public FibonacciRetracement right(Number number) {
        APIlib.getInstance().addJSLine(String.format(Locale.US, this.jsBase + ".right(%s);", number));
        return this;
    }

    @Override // com.anychart.core.annotations.FibonacciBase, com.anychart.core.annotations.Base, com.anychart.core.VisualBaseWithBounds
    public FibonacciRetracement right(String str) {
        APIlib.getInstance().addJSLine(String.format(Locale.US, this.jsBase + ".right(%s);", wrapQuotes(str)));
        return this;
    }

    @Override // com.anychart.core.annotations.FibonacciBase, com.anychart.core.annotations.Base, com.anychart.core.VisualBaseWithBounds
    public void top() {
        APIlib.getInstance().addJSLine(this.jsBase + ".top();");
    }

    @Override // com.anychart.core.annotations.FibonacciBase, com.anychart.core.annotations.Base, com.anychart.core.VisualBaseWithBounds
    public FibonacciRetracement top(Number number) {
        APIlib.getInstance().addJSLine(String.format(Locale.US, this.jsBase + ".top(%s);", number));
        return this;
    }

    @Override // com.anychart.core.annotations.FibonacciBase, com.anychart.core.annotations.Base, com.anychart.core.VisualBaseWithBounds
    public FibonacciRetracement top(String str) {
        APIlib.getInstance().addJSLine(String.format(Locale.US, this.jsBase + ".top(%s);", wrapQuotes(str)));
        return this;
    }

    @Override // com.anychart.core.annotations.FibonacciBase, com.anychart.core.annotations.Base, com.anychart.core.VisualBaseWithBounds, com.anychart.core.VisualBase, com.anychart.core.Base
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

    @Override // com.anychart.core.annotations.FibonacciBase, com.anychart.core.annotations.Base, com.anychart.core.VisualBaseWithBounds, com.anychart.core.VisualBase, com.anychart.core.Base
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

    @Override // com.anychart.core.annotations.FibonacciBase, com.anychart.core.annotations.Base, com.anychart.core.VisualBaseWithBounds, com.anychart.core.VisualBase, com.anychart.core.Base
    public void unlistenByKey(String str) {
        APIlib.getInstance().addJSLine(String.format(Locale.US, this.jsBase + ".unlistenByKey(%s);", wrapQuotes(str)));
    }

    @Override // com.anychart.core.annotations.FibonacciBase, com.anychart.core.annotations.Base, com.anychart.core.VisualBaseWithBounds
    public void width() {
        APIlib.getInstance().addJSLine(this.jsBase + ".width();");
    }

    @Override // com.anychart.core.annotations.FibonacciBase, com.anychart.core.annotations.Base, com.anychart.core.VisualBaseWithBounds
    public FibonacciRetracement width(Number number) {
        APIlib.getInstance().addJSLine(String.format(Locale.US, this.jsBase + ".width(%s);", number));
        return this;
    }

    @Override // com.anychart.core.annotations.FibonacciBase, com.anychart.core.annotations.Base, com.anychart.core.VisualBaseWithBounds
    public FibonacciRetracement width(String str) {
        APIlib.getInstance().addJSLine(String.format(Locale.US, this.jsBase + ".width(%s);", wrapQuotes(str)));
        return this;
    }

    @Override // com.anychart.core.annotations.FibonacciBase, com.anychart.core.annotations.Base, com.anychart.core.VisualBaseWithBounds, com.anychart.core.VisualBase
    public void zIndex() {
        APIlib.getInstance().addJSLine(this.jsBase + ".zIndex();");
    }

    @Override // com.anychart.core.annotations.FibonacciBase, com.anychart.core.annotations.Base, com.anychart.core.VisualBaseWithBounds, com.anychart.core.VisualBase
    public FibonacciRetracement zIndex(Number number) {
        APIlib.getInstance().addJSLine(String.format(Locale.US, this.jsBase + ".zIndex(%s);", number));
        return this;
    }

    @Override // com.anychart.core.annotations.FibonacciBase, com.anychart.core.annotations.Base, com.anychart.core.VisualBaseWithBounds, com.anychart.core.VisualBase
    public Layer container() {
        return new Layer(this.jsBase + ".container()");
    }

    @Override // com.anychart.core.annotations.FibonacciBase, com.anychart.core.annotations.Base, com.anychart.core.VisualBaseWithBounds, com.anychart.core.VisualBase
    public FibonacciRetracement container(Layer layer) {
        APIlib.getInstance().addJSLine(String.format(Locale.US, this.jsBase + ".container(%s);", layer != null ? layer.getJsBase() : null));
        return this;
    }

    @Override // com.anychart.core.annotations.FibonacciBase, com.anychart.core.annotations.Base, com.anychart.core.VisualBaseWithBounds, com.anychart.core.VisualBase
    public FibonacciRetracement container(Stage stage) {
        APIlib.getInstance().addJSLine(String.format(Locale.US, this.jsBase + ".container(%s);", stage != null ? stage.getJsBase() : null));
        return this;
    }

    @Override // com.anychart.core.annotations.FibonacciBase, com.anychart.core.annotations.Base, com.anychart.core.VisualBaseWithBounds, com.anychart.core.VisualBase
    public FibonacciRetracement container(String str) {
        APIlib.getInstance().addJSLine(String.format(Locale.US, this.jsBase + ".container(%s);", wrapQuotes(str)));
        return this;
    }

    @Override // com.anychart.core.annotations.FibonacciBase, com.anychart.core.annotations.Base, com.anychart.core.VisualBaseWithBounds, com.anychart.core.VisualBase
    public Rect parentBounds() {
        return new Rect(this.jsBase + ".parentBounds()");
    }

    @Override // com.anychart.core.annotations.FibonacciBase, com.anychart.core.annotations.Base, com.anychart.core.VisualBaseWithBounds, com.anychart.core.VisualBase
    public FibonacciRetracement parentBounds(Rect rect) {
        APIlib.getInstance().addJSLine(String.format(Locale.US, this.jsBase + ".parentBounds(%s);", rect != null ? rect.getJsBase() : null));
        return this;
    }

    @Override // com.anychart.core.annotations.FibonacciBase, com.anychart.core.annotations.Base, com.anychart.core.VisualBaseWithBounds, com.anychart.core.VisualBase
    public FibonacciRetracement parentBounds(String str) {
        APIlib.getInstance().addJSLine(String.format(Locale.US, this.jsBase + ".parentBounds(%s);", wrapQuotes(str)));
        return this;
    }

    @Override // com.anychart.core.annotations.FibonacciBase, com.anychart.core.annotations.Base, com.anychart.core.VisualBaseWithBounds, com.anychart.core.VisualBase
    public FibonacciRetracement parentBounds(Number number) {
        APIlib.getInstance().addJSLine(String.format(Locale.US, this.jsBase + ".parentBounds(%s);", number));
        return this;
    }

    @Override // com.anychart.core.annotations.FibonacciBase, com.anychart.core.annotations.Base, com.anychart.core.VisualBaseWithBounds, com.anychart.core.VisualBase
    public FibonacciRetracement parentBounds(Number number, Number number2, Number number3, Number number4) {
        APIlib.getInstance().addJSLine(String.format(Locale.US, this.jsBase + ".parentBounds(%s, %s, %s, %s);", number, number2, number3, number4));
        return this;
    }

    @Override // com.anychart.core.annotations.FibonacciBase, com.anychart.core.annotations.Base
    public Object xScale(Class cls) {
        try {
            return cls.getDeclaredConstructor(String.class).newInstance(this.jsBase + ".xScale()");
        } catch (IllegalAccessException e2) {
            e2.printStackTrace();
            return null;
        } catch (InstantiationException e3) {
            e3.printStackTrace();
            return null;
        } catch (NoSuchMethodException e4) {
            e4.printStackTrace();
            return null;
        } catch (InvocationTargetException e5) {
            e5.printStackTrace();
            return null;
        }
    }

    @Override // com.anychart.core.annotations.FibonacciBase, com.anychart.core.annotations.Base
    public Object yScale(Class cls) {
        try {
            return cls.getDeclaredConstructor(String.class).newInstance(this.jsBase + ".yScale()");
        } catch (IllegalAccessException e2) {
            e2.printStackTrace();
            return null;
        } catch (InstantiationException e3) {
            e3.printStackTrace();
            return null;
        } catch (NoSuchMethodException e4) {
            e4.printStackTrace();
            return null;
        } catch (InvocationTargetException e5) {
            e5.printStackTrace();
            return null;
        }
    }
}
