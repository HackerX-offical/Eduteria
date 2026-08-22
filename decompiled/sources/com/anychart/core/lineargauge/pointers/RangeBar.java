package com.anychart.core.lineargauge.pointers;

import com.amazonaws.services.s3.model.InstructionFileId;
import com.anychart.APIlib;
import com.anychart.chart.common.dataentry.DataEntry;
import com.anychart.chart.common.listener.ListenersInterface;
import com.anychart.charts.LinearGauge;
import com.anychart.core.StateSettings;
import com.anychart.core.ui.LabelsFactory;
import com.anychart.core.utils.LegendItemSettings;
import com.anychart.data.View;
import com.anychart.enums.TreeFillingMethod;
import com.anychart.graphics.vector.ColoredFill;
import com.anychart.graphics.vector.Fill;
import com.anychart.graphics.vector.GradientKey;
import com.anychart.graphics.vector.HatchFill;
import com.anychart.graphics.vector.Layer;
import com.anychart.graphics.vector.PaperSize;
import com.anychart.graphics.vector.PatternFill;
import com.anychart.graphics.vector.Rect;
import com.anychart.graphics.vector.Stage;
import com.anychart.graphics.vector.Stroke;
import com.anychart.graphics.vector.StrokeLineCap;
import com.anychart.graphics.vector.StrokeLineJoin;
import com.anychart.graphics.vector.hatchfill.HatchFillType;
import java.util.List;
import java.util.Locale;

/* JADX INFO: loaded from: classes5.dex */
public class RangeBar extends Bar {
    protected RangeBar() {
    }

    public static RangeBar instantiate() {
        return new RangeBar("new anychart.core.linearGauge.pointers.rangeBar()");
    }

    public RangeBar(String str) {
        StringBuilder sb = new StringBuilder("rangeBar");
        int i = variableIndex + 1;
        variableIndex = i;
        this.jsBase = sb.append(i).toString();
        APIlib.getInstance().addJSLine(this.jsBase + " = " + str + ";");
    }

    @Override // com.anychart.core.lineargauge.pointers.Bar, com.anychart.core.lineargauge.pointers.Base, com.anychart.core.VisualBase, com.anychart.core.Base, com.anychart.JsObject
    public String getJsBase() {
        return this.jsBase;
    }

    @Override // com.anychart.core.lineargauge.pointers.Bar, com.anychart.core.lineargauge.pointers.Base
    public void color() {
        APIlib.getInstance().addJSLine(this.jsBase + ".color();");
    }

    @Override // com.anychart.core.lineargauge.pointers.Bar, com.anychart.core.lineargauge.pointers.Base
    public RangeBar color(String str) {
        APIlib.getInstance().addJSLine(String.format(Locale.US, this.jsBase + ".color(%s);", wrapQuotes(str)));
        return this;
    }

    @Override // com.anychart.core.lineargauge.pointers.Bar, com.anychart.core.lineargauge.pointers.Base
    public View data(List<DataEntry> list) {
        return new View(String.format(Locale.US, this.jsBase + ".data(%s)", arrayToString(list)));
    }

    @Override // com.anychart.core.lineargauge.pointers.Bar, com.anychart.core.lineargauge.pointers.Base
    public void dataIndex() {
        APIlib.getInstance().addJSLine(this.jsBase + ".dataIndex();");
    }

    @Override // com.anychart.core.lineargauge.pointers.Bar, com.anychart.core.lineargauge.pointers.Base
    public RangeBar dataIndex(Number number) {
        APIlib.getInstance().addJSLine(String.format(Locale.US, this.jsBase + ".dataIndex(%s);", number));
        return this;
    }

    @Override // com.anychart.core.lineargauge.pointers.Bar, com.anychart.core.lineargauge.pointers.Base, com.anychart.core.VisualBase
    public void enabled() {
        APIlib.getInstance().addJSLine(this.jsBase + ".enabled();");
    }

    @Override // com.anychart.core.lineargauge.pointers.Bar, com.anychart.core.lineargauge.pointers.Base, com.anychart.core.VisualBase
    public RangeBar enabled(Boolean bool) {
        APIlib.getInstance().addJSLine(String.format(Locale.US, this.jsBase + ".enabled(%s);", bool));
        return this;
    }

    @Override // com.anychart.core.lineargauge.pointers.Bar, com.anychart.core.lineargauge.pointers.Base
    public void fill() {
        APIlib.getInstance().addJSLine(this.jsBase + ".fill();");
    }

    @Override // com.anychart.core.lineargauge.pointers.Bar, com.anychart.core.lineargauge.pointers.Base
    public RangeBar fill(Fill fill) {
        APIlib.getInstance().addJSLine(String.format(Locale.US, this.jsBase + ".fill(%s);", fill != null ? fill.getJsBase() : null));
        return this;
    }

    @Override // com.anychart.core.lineargauge.pointers.Bar, com.anychart.core.lineargauge.pointers.Base
    public RangeBar fill(GradientKey gradientKey) {
        APIlib.getInstance().addJSLine(String.format(Locale.US, this.jsBase + ".fill(%s);", gradientKey != null ? gradientKey.getJsBase() : null));
        return this;
    }

    @Override // com.anychart.core.lineargauge.pointers.Bar, com.anychart.core.lineargauge.pointers.Base
    public RangeBar fill(String[] strArr) {
        APIlib.getInstance().addJSLine(String.format(Locale.US, this.jsBase + ".fill(%s);", arrayToStringWrapQuotes(strArr)));
        return this;
    }

    @Override // com.anychart.core.lineargauge.pointers.Bar, com.anychart.core.lineargauge.pointers.Base
    public RangeBar fill(String str, Number number) {
        APIlib.getInstance().addJSLine(String.format(Locale.US, this.jsBase + ".fill(%s, %s);", wrapQuotes(str), number));
        return this;
    }

    @Override // com.anychart.core.lineargauge.pointers.Bar, com.anychart.core.lineargauge.pointers.Base
    public RangeBar fill(GradientKey gradientKey, Number number, Boolean bool, Number number2) {
        APIlib.getInstance().addJSLine(String.format(Locale.US, this.jsBase + ".fill(%s, %s, %s, %s);", gradientKey != null ? gradientKey.getJsBase() : null, number, bool, number2));
        return this;
    }

    @Override // com.anychart.core.lineargauge.pointers.Bar, com.anychart.core.lineargauge.pointers.Base
    public RangeBar fill(GradientKey gradientKey, Number number, Rect rect, Number number2) {
        APIlib.getInstance().addJSLine(String.format(Locale.US, this.jsBase + ".fill(%s, %s, %s, %s);", gradientKey != null ? gradientKey.getJsBase() : null, number, rect != null ? rect.getJsBase() : null, number2));
        return this;
    }

    @Override // com.anychart.core.lineargauge.pointers.Bar, com.anychart.core.lineargauge.pointers.Base
    public RangeBar fill(GradientKey gradientKey, Number number, String str, Number number2) {
        APIlib.getInstance().addJSLine(String.format(Locale.US, this.jsBase + ".fill(%s, %s, %s, %s);", gradientKey != null ? gradientKey.getJsBase() : null, number, wrapQuotes(str), number2));
        return this;
    }

    @Override // com.anychart.core.lineargauge.pointers.Bar, com.anychart.core.lineargauge.pointers.Base
    public RangeBar fill(String[] strArr, Number number, Boolean bool, Number number2) {
        APIlib.getInstance().addJSLine(String.format(Locale.US, this.jsBase + ".fill(%s, %s, %s, %s);", arrayToStringWrapQuotes(strArr), number, bool, number2));
        return this;
    }

    @Override // com.anychart.core.lineargauge.pointers.Bar, com.anychart.core.lineargauge.pointers.Base
    public RangeBar fill(String[] strArr, Number number, Rect rect, Number number2) {
        APIlib.getInstance().addJSLine(String.format(Locale.US, this.jsBase + ".fill(%s, %s, %s, %s);", arrayToStringWrapQuotes(strArr), number, rect != null ? rect.getJsBase() : null, number2));
        return this;
    }

    @Override // com.anychart.core.lineargauge.pointers.Bar, com.anychart.core.lineargauge.pointers.Base
    public RangeBar fill(String[] strArr, Number number, String str, Number number2) {
        APIlib.getInstance().addJSLine(String.format(Locale.US, this.jsBase + ".fill(%s, %s, %s, %s);", arrayToStringWrapQuotes(strArr), number, wrapQuotes(str), number2));
        return this;
    }

    @Override // com.anychart.core.lineargauge.pointers.Bar, com.anychart.core.lineargauge.pointers.Base
    public RangeBar fill(GradientKey gradientKey, Number number, Number number2, com.anychart.graphics.math.Rect rect, Number number3, Number number4, Number number5) {
        APIlib.getInstance().addJSLine(String.format(Locale.US, this.jsBase + ".fill(%s, %s, %s, %s, %s, %s, %s);", gradientKey != null ? gradientKey.getJsBase() : null, number, number2, rect != null ? rect.getJsBase() : null, number3, number4, number5));
        return this;
    }

    @Override // com.anychart.core.lineargauge.pointers.Bar, com.anychart.core.lineargauge.pointers.Base
    public RangeBar fill(String[] strArr, Number number, Number number2, com.anychart.graphics.math.Rect rect, Number number3, Number number4, Number number5) {
        APIlib.getInstance().addJSLine(String.format(Locale.US, this.jsBase + ".fill(%s, %s, %s, %s, %s, %s, %s);", arrayToStringWrapQuotes(strArr), number, number2, rect != null ? rect.getJsBase() : null, number3, number4, number5));
        return this;
    }

    @Override // com.anychart.core.lineargauge.pointers.Bar, com.anychart.core.lineargauge.pointers.Base
    public LinearGauge getGauge() {
        return new LinearGauge(this.jsBase + ".getGauge()");
    }

    @Override // com.anychart.core.lineargauge.pointers.Bar, com.anychart.core.lineargauge.pointers.Base
    public PatternFill hatchFill() {
        return new PatternFill(this.jsBase + ".hatchFill()");
    }

    @Override // com.anychart.core.lineargauge.pointers.Bar, com.anychart.core.lineargauge.pointers.Base
    public RangeBar hatchFill(HatchFillType hatchFillType, String str, Number number, Number number2) {
        APIlib.getInstance().addJSLine(String.format(Locale.US, this.jsBase + ".hatchFill(%s, %s, %s, %s);", hatchFillType != null ? hatchFillType.getJsBase() : null, wrapQuotes(str), number, number2));
        return this;
    }

    @Override // com.anychart.core.lineargauge.pointers.Bar, com.anychart.core.lineargauge.pointers.Base
    public RangeBar hatchFill(String str, String str2, Number number, Number number2) {
        APIlib.getInstance().addJSLine(String.format(Locale.US, this.jsBase + ".hatchFill(%s, %s, %s, %s);", wrapQuotes(str), wrapQuotes(str2), number, number2));
        return this;
    }

    @Override // com.anychart.core.lineargauge.pointers.Bar, com.anychart.core.lineargauge.pointers.Base
    public RangeBar hatchFill(String str) {
        APIlib.getInstance().addJSLine(String.format(Locale.US, this.jsBase + ".hatchFill(%s);", wrapQuotes(str)));
        return this;
    }

    @Override // com.anychart.core.lineargauge.pointers.Bar, com.anychart.core.lineargauge.pointers.Base
    public RangeBar hatchFill(PatternFill patternFill) {
        APIlib.getInstance().addJSLine(String.format(Locale.US, this.jsBase + ".hatchFill(%s);", patternFill != null ? patternFill.getJsBase() : null));
        return this;
    }

    @Override // com.anychart.core.lineargauge.pointers.Bar, com.anychart.core.lineargauge.pointers.Base
    public RangeBar hatchFill(HatchFill hatchFill) {
        APIlib.getInstance().addJSLine(String.format(Locale.US, this.jsBase + ".hatchFill(%s);", hatchFill != null ? hatchFill.getJsBase() : null));
        return this;
    }

    @Override // com.anychart.core.lineargauge.pointers.Bar, com.anychart.core.lineargauge.pointers.Base
    public RangeBar hatchFill(Boolean bool) {
        APIlib.getInstance().addJSLine(String.format(Locale.US, this.jsBase + ".hatchFill(%s);", bool));
        return this;
    }

    @Override // com.anychart.core.lineargauge.pointers.Bar, com.anychart.core.lineargauge.pointers.Base
    public RangeBar hover() {
        APIlib.getInstance().addJSLine(this.jsBase + ".hover();");
        return this;
    }

    @Override // com.anychart.core.lineargauge.pointers.Bar, com.anychart.core.lineargauge.pointers.Base
    public StateSettings hovered() {
        return new StateSettings(this.jsBase + ".hovered()");
    }

    @Override // com.anychart.core.lineargauge.pointers.Bar, com.anychart.core.lineargauge.pointers.Base
    public RangeBar hovered(String str) {
        APIlib.getInstance().addJSLine(String.format(Locale.US, this.jsBase + ".hovered(%s);", wrapQuotes(str)));
        return this;
    }

    @Override // com.anychart.core.lineargauge.pointers.Bar, com.anychart.core.lineargauge.pointers.Base
    public com.anychart.core.gauge.pointers.Base id() {
        return new com.anychart.core.gauge.pointers.Base(this.jsBase + ".id()");
    }

    @Override // com.anychart.core.lineargauge.pointers.Bar, com.anychart.core.lineargauge.pointers.Base
    public com.anychart.core.gauge.pointers.Base id(String str) {
        return new com.anychart.core.gauge.pointers.Base(String.format(Locale.US, this.jsBase + ".id(%s)", wrapQuotes(str)));
    }

    @Override // com.anychart.core.lineargauge.pointers.Bar, com.anychart.core.lineargauge.pointers.Base
    public com.anychart.core.gauge.pointers.Base id(Number number) {
        return new com.anychart.core.gauge.pointers.Base(String.format(Locale.US, this.jsBase + ".id(%s)", number));
    }

    @Override // com.anychart.core.lineargauge.pointers.Bar, com.anychart.core.lineargauge.pointers.Base
    public LabelsFactory labels() {
        return new LabelsFactory(this.jsBase + ".labels()");
    }

    @Override // com.anychart.core.lineargauge.pointers.Bar, com.anychart.core.lineargauge.pointers.Base
    public RangeBar labels(LabelsFactory labelsFactory) {
        APIlib.getInstance().addJSLine(String.format(Locale.US, this.jsBase + ".labels(%s);", labelsFactory != null ? labelsFactory.getJsBase() : null));
        return this;
    }

    @Override // com.anychart.core.lineargauge.pointers.Bar, com.anychart.core.lineargauge.pointers.Base
    public RangeBar labels(String str) {
        APIlib.getInstance().addJSLine(String.format(Locale.US, this.jsBase + ".labels(%s);", wrapQuotes(str)));
        return this;
    }

    @Override // com.anychart.core.lineargauge.pointers.Bar, com.anychart.core.lineargauge.pointers.Base
    public RangeBar labels(Boolean bool) {
        APIlib.getInstance().addJSLine(String.format(Locale.US, this.jsBase + ".labels(%s);", bool));
        return this;
    }

    @Override // com.anychart.core.lineargauge.pointers.Bar, com.anychart.core.lineargauge.pointers.Base
    public LegendItemSettings legendItem() {
        return new LegendItemSettings(this.jsBase + ".legendItem()");
    }

    @Override // com.anychart.core.lineargauge.pointers.Bar, com.anychart.core.lineargauge.pointers.Base
    public RangeBar legendItem(String str) {
        APIlib.getInstance().addJSLine(String.format(Locale.US, this.jsBase + ".legendItem(%s);", wrapQuotes(str)));
        return this;
    }

    @Override // com.anychart.core.lineargauge.pointers.Bar, com.anychart.core.lineargauge.pointers.Base
    public void name() {
        APIlib.getInstance().addJSLine(this.jsBase + ".name();");
    }

    @Override // com.anychart.core.lineargauge.pointers.Bar, com.anychart.core.lineargauge.pointers.Base
    public RangeBar name(String str) {
        APIlib.getInstance().addJSLine(String.format(Locale.US, this.jsBase + ".name(%s);", wrapQuotes(str)));
        return this;
    }

    @Override // com.anychart.core.lineargauge.pointers.Bar, com.anychart.core.lineargauge.pointers.Base
    public StateSettings normal() {
        return new StateSettings(this.jsBase + ".normal()");
    }

    @Override // com.anychart.core.lineargauge.pointers.Bar, com.anychart.core.lineargauge.pointers.Base
    public RangeBar normal(String str) {
        APIlib.getInstance().addJSLine(String.format(Locale.US, this.jsBase + ".normal(%s);", wrapQuotes(str)));
        return this;
    }

    @Override // com.anychart.core.lineargauge.pointers.Bar, com.anychart.core.lineargauge.pointers.Base
    public void offset() {
        APIlib.getInstance().addJSLine(this.jsBase + ".offset();");
    }

    @Override // com.anychart.core.lineargauge.pointers.Bar, com.anychart.core.lineargauge.pointers.Base
    public RangeBar offset(String str) {
        APIlib.getInstance().addJSLine(String.format(Locale.US, this.jsBase + ".offset(%s);", wrapQuotes(str)));
        return this;
    }

    @Override // com.anychart.core.lineargauge.pointers.Bar, com.anychart.core.lineargauge.pointers.Base
    public RangeBar offset(Number number) {
        APIlib.getInstance().addJSLine(String.format(Locale.US, this.jsBase + ".offset(%s);", number));
        return this;
    }

    @Override // com.anychart.core.lineargauge.pointers.Bar, com.anychart.core.lineargauge.pointers.Base, com.anychart.core.VisualBase
    public void print(PaperSize paperSize, Boolean bool) {
        APIlib.getInstance().addJSLine(String.format(Locale.US, this.jsBase + ".print(%s, %s);", paperSize != null ? paperSize.getJsBase() : null, bool));
    }

    @Override // com.anychart.core.lineargauge.pointers.Bar, com.anychart.core.lineargauge.pointers.Base, com.anychart.core.VisualBase
    public void print(String str, Boolean bool) {
        APIlib.getInstance().addJSLine(String.format(Locale.US, this.jsBase + ".print(%s, %s);", wrapQuotes(str), bool));
    }

    @Override // com.anychart.core.lineargauge.pointers.Bar, com.anychart.core.lineargauge.pointers.Base, com.anychart.core.VisualBase, com.anychart.core.Base
    public void removeAllListeners(String str) {
        APIlib.getInstance().addJSLine(String.format(Locale.US, this.jsBase + ".removeAllListeners(%s);", wrapQuotes(str)));
    }

    @Override // com.anychart.core.lineargauge.pointers.Bar, com.anychart.core.lineargauge.pointers.Base
    public com.anychart.scales.Base scale() {
        return new com.anychart.scales.Base(this.jsBase + ".scale()");
    }

    @Override // com.anychart.core.lineargauge.pointers.Bar, com.anychart.core.lineargauge.pointers.Base
    public RangeBar scale(com.anychart.scales.Base base) {
        APIlib.getInstance().addJSLine(String.format(Locale.US, this.jsBase + ".scale(%s);", base != null ? base.getJsBase() : null));
        return this;
    }

    @Override // com.anychart.core.lineargauge.pointers.Bar, com.anychart.core.lineargauge.pointers.Base
    public StateSettings selected() {
        return new StateSettings(this.jsBase + ".selected()");
    }

    @Override // com.anychart.core.lineargauge.pointers.Bar, com.anychart.core.lineargauge.pointers.Base
    public RangeBar selected(String str) {
        APIlib.getInstance().addJSLine(String.format(Locale.US, this.jsBase + ".selected(%s);", wrapQuotes(str)));
        return this;
    }

    @Override // com.anychart.core.lineargauge.pointers.Bar, com.anychart.core.lineargauge.pointers.Base
    public void stroke() {
        APIlib.getInstance().addJSLine(this.jsBase + ".stroke();");
    }

    @Override // com.anychart.core.lineargauge.pointers.Bar, com.anychart.core.lineargauge.pointers.Base
    public RangeBar stroke(Stroke stroke, Number number, String str, String str2, String str3) {
        APIlib.getInstance().addJSLine(String.format(Locale.US, this.jsBase + ".stroke(%s, %s, %s, %s, %s);", stroke != null ? stroke.getJsBase() : null, number, wrapQuotes(str), wrapQuotes(str2), wrapQuotes(str3)));
        return this;
    }

    @Override // com.anychart.core.lineargauge.pointers.Bar, com.anychart.core.lineargauge.pointers.Base
    public RangeBar stroke(Stroke stroke, Number number, String str, String str2, StrokeLineCap strokeLineCap) {
        APIlib.getInstance().addJSLine(String.format(Locale.US, this.jsBase + ".stroke(%s, %s, %s, %s, %s);", stroke != null ? stroke.getJsBase() : null, number, wrapQuotes(str), wrapQuotes(str2), strokeLineCap != null ? strokeLineCap.getJsBase() : null));
        return this;
    }

    @Override // com.anychart.core.lineargauge.pointers.Bar, com.anychart.core.lineargauge.pointers.Base
    public RangeBar stroke(Stroke stroke, Number number, String str, StrokeLineJoin strokeLineJoin, String str2) {
        APIlib.getInstance().addJSLine(String.format(Locale.US, this.jsBase + ".stroke(%s, %s, %s, %s, %s);", stroke != null ? stroke.getJsBase() : null, number, wrapQuotes(str), strokeLineJoin != null ? strokeLineJoin.getJsBase() : null, wrapQuotes(str2)));
        return this;
    }

    @Override // com.anychart.core.lineargauge.pointers.Bar, com.anychart.core.lineargauge.pointers.Base
    public RangeBar stroke(Stroke stroke, Number number, String str, StrokeLineJoin strokeLineJoin, StrokeLineCap strokeLineCap) {
        APIlib.getInstance().addJSLine(String.format(Locale.US, this.jsBase + ".stroke(%s, %s, %s, %s, %s);", stroke != null ? stroke.getJsBase() : null, number, wrapQuotes(str), strokeLineJoin != null ? strokeLineJoin.getJsBase() : null, strokeLineCap != null ? strokeLineCap.getJsBase() : null));
        return this;
    }

    @Override // com.anychart.core.lineargauge.pointers.Bar, com.anychart.core.lineargauge.pointers.Base
    public RangeBar stroke(ColoredFill coloredFill, Number number, String str, String str2, String str3) {
        APIlib.getInstance().addJSLine(String.format(Locale.US, this.jsBase + ".stroke(%s, %s, %s, %s, %s);", coloredFill != null ? coloredFill.getJsBase() : null, number, wrapQuotes(str), wrapQuotes(str2), wrapQuotes(str3)));
        return this;
    }

    @Override // com.anychart.core.lineargauge.pointers.Bar, com.anychart.core.lineargauge.pointers.Base
    public RangeBar stroke(ColoredFill coloredFill, Number number, String str, String str2, StrokeLineCap strokeLineCap) {
        APIlib.getInstance().addJSLine(String.format(Locale.US, this.jsBase + ".stroke(%s, %s, %s, %s, %s);", coloredFill != null ? coloredFill.getJsBase() : null, number, wrapQuotes(str), wrapQuotes(str2), strokeLineCap != null ? strokeLineCap.getJsBase() : null));
        return this;
    }

    @Override // com.anychart.core.lineargauge.pointers.Bar, com.anychart.core.lineargauge.pointers.Base
    public RangeBar stroke(ColoredFill coloredFill, Number number, String str, StrokeLineJoin strokeLineJoin, String str2) {
        APIlib.getInstance().addJSLine(String.format(Locale.US, this.jsBase + ".stroke(%s, %s, %s, %s, %s);", coloredFill != null ? coloredFill.getJsBase() : null, number, wrapQuotes(str), strokeLineJoin != null ? strokeLineJoin.getJsBase() : null, wrapQuotes(str2)));
        return this;
    }

    @Override // com.anychart.core.lineargauge.pointers.Bar, com.anychart.core.lineargauge.pointers.Base
    public RangeBar stroke(ColoredFill coloredFill, Number number, String str, StrokeLineJoin strokeLineJoin, StrokeLineCap strokeLineCap) {
        APIlib.getInstance().addJSLine(String.format(Locale.US, this.jsBase + ".stroke(%s, %s, %s, %s, %s);", coloredFill != null ? coloredFill.getJsBase() : null, number, wrapQuotes(str), strokeLineJoin != null ? strokeLineJoin.getJsBase() : null, strokeLineCap != null ? strokeLineCap.getJsBase() : null));
        return this;
    }

    @Override // com.anychart.core.lineargauge.pointers.Bar, com.anychart.core.lineargauge.pointers.Base
    public RangeBar stroke(String str, Number number, String str2, String str3, String str4) {
        APIlib.getInstance().addJSLine(String.format(Locale.US, this.jsBase + ".stroke(%s, %s, %s, %s, %s);", wrapQuotes(str), number, wrapQuotes(str2), wrapQuotes(str3), wrapQuotes(str4)));
        return this;
    }

    @Override // com.anychart.core.lineargauge.pointers.Bar, com.anychart.core.lineargauge.pointers.Base
    public RangeBar stroke(String str, Number number, String str2, String str3, StrokeLineCap strokeLineCap) {
        APIlib.getInstance().addJSLine(String.format(Locale.US, this.jsBase + ".stroke(%s, %s, %s, %s, %s);", wrapQuotes(str), number, wrapQuotes(str2), wrapQuotes(str3), strokeLineCap != null ? strokeLineCap.getJsBase() : null));
        return this;
    }

    @Override // com.anychart.core.lineargauge.pointers.Bar, com.anychart.core.lineargauge.pointers.Base
    public RangeBar stroke(String str, Number number, String str2, StrokeLineJoin strokeLineJoin, String str3) {
        APIlib.getInstance().addJSLine(String.format(Locale.US, this.jsBase + ".stroke(%s, %s, %s, %s, %s);", wrapQuotes(str), number, wrapQuotes(str2), strokeLineJoin != null ? strokeLineJoin.getJsBase() : null, wrapQuotes(str3)));
        return this;
    }

    @Override // com.anychart.core.lineargauge.pointers.Bar, com.anychart.core.lineargauge.pointers.Base
    public RangeBar stroke(String str, Number number, String str2, StrokeLineJoin strokeLineJoin, StrokeLineCap strokeLineCap) {
        APIlib.getInstance().addJSLine(String.format(Locale.US, this.jsBase + ".stroke(%s, %s, %s, %s, %s);", wrapQuotes(str), number, wrapQuotes(str2), strokeLineJoin != null ? strokeLineJoin.getJsBase() : null, strokeLineCap != null ? strokeLineCap.getJsBase() : null));
        return this;
    }

    @Override // com.anychart.core.lineargauge.pointers.Bar, com.anychart.core.lineargauge.pointers.Base
    public RangeBar stroke(String str) {
        APIlib.getInstance().addJSLine(String.format(Locale.US, this.jsBase + ".stroke(%s);", wrapQuotes(str)));
        return this;
    }

    @Override // com.anychart.core.lineargauge.pointers.Bar, com.anychart.core.lineargauge.pointers.Base
    public RangeBar unhover() {
        APIlib.getInstance().addJSLine(this.jsBase + ".unhover();");
        return this;
    }

    @Override // com.anychart.core.lineargauge.pointers.Bar, com.anychart.core.lineargauge.pointers.Base, com.anychart.core.VisualBase, com.anychart.core.Base
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

    @Override // com.anychart.core.lineargauge.pointers.Bar, com.anychart.core.lineargauge.pointers.Base, com.anychart.core.VisualBase, com.anychart.core.Base
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

    @Override // com.anychart.core.lineargauge.pointers.Bar, com.anychart.core.lineargauge.pointers.Base, com.anychart.core.VisualBase, com.anychart.core.Base
    public void unlistenByKey(String str) {
        APIlib.getInstance().addJSLine(String.format(Locale.US, this.jsBase + ".unlistenByKey(%s);", wrapQuotes(str)));
    }

    @Override // com.anychart.core.lineargauge.pointers.Bar, com.anychart.core.lineargauge.pointers.Base
    public RangeBar unselect() {
        APIlib.getInstance().addJSLine(this.jsBase + ".unselect();");
        return this;
    }

    @Override // com.anychart.core.lineargauge.pointers.Bar, com.anychart.core.lineargauge.pointers.Base
    public void width() {
        APIlib.getInstance().addJSLine(this.jsBase + ".width();");
    }

    @Override // com.anychart.core.lineargauge.pointers.Bar, com.anychart.core.lineargauge.pointers.Base
    public RangeBar width(String str) {
        APIlib.getInstance().addJSLine(String.format(Locale.US, this.jsBase + ".width(%s);", wrapQuotes(str)));
        return this;
    }

    @Override // com.anychart.core.lineargauge.pointers.Bar, com.anychart.core.lineargauge.pointers.Base, com.anychart.core.VisualBase
    public void zIndex() {
        APIlib.getInstance().addJSLine(this.jsBase + ".zIndex();");
    }

    @Override // com.anychart.core.lineargauge.pointers.Bar, com.anychart.core.lineargauge.pointers.Base, com.anychart.core.VisualBase
    public RangeBar zIndex(Number number) {
        APIlib.getInstance().addJSLine(String.format(Locale.US, this.jsBase + ".zIndex(%s);", number));
        return this;
    }

    @Override // com.anychart.core.lineargauge.pointers.Bar, com.anychart.core.lineargauge.pointers.Base, com.anychart.core.VisualBase
    public Layer container() {
        return new Layer(this.jsBase + ".container()");
    }

    @Override // com.anychart.core.lineargauge.pointers.Bar, com.anychart.core.lineargauge.pointers.Base, com.anychart.core.VisualBase
    public RangeBar container(Layer layer) {
        APIlib.getInstance().addJSLine(String.format(Locale.US, this.jsBase + ".container(%s);", layer != null ? layer.getJsBase() : null));
        return this;
    }

    @Override // com.anychart.core.lineargauge.pointers.Bar, com.anychart.core.lineargauge.pointers.Base, com.anychart.core.VisualBase
    public RangeBar container(Stage stage) {
        APIlib.getInstance().addJSLine(String.format(Locale.US, this.jsBase + ".container(%s);", stage != null ? stage.getJsBase() : null));
        return this;
    }

    @Override // com.anychart.core.lineargauge.pointers.Bar, com.anychart.core.lineargauge.pointers.Base, com.anychart.core.VisualBase
    public RangeBar container(String str) {
        APIlib.getInstance().addJSLine(String.format(Locale.US, this.jsBase + ".container(%s);", wrapQuotes(str)));
        return this;
    }

    @Override // com.anychart.core.lineargauge.pointers.Bar, com.anychart.core.lineargauge.pointers.Base, com.anychart.core.VisualBase
    public com.anychart.math.Rect parentBounds() {
        return new com.anychart.math.Rect(this.jsBase + ".parentBounds()");
    }

    @Override // com.anychart.core.lineargauge.pointers.Bar, com.anychart.core.lineargauge.pointers.Base, com.anychart.core.VisualBase
    public RangeBar parentBounds(com.anychart.math.Rect rect) {
        APIlib.getInstance().addJSLine(String.format(Locale.US, this.jsBase + ".parentBounds(%s);", rect != null ? rect.getJsBase() : null));
        return this;
    }

    @Override // com.anychart.core.lineargauge.pointers.Bar, com.anychart.core.lineargauge.pointers.Base, com.anychart.core.VisualBase
    public RangeBar parentBounds(String str) {
        APIlib.getInstance().addJSLine(String.format(Locale.US, this.jsBase + ".parentBounds(%s);", wrapQuotes(str)));
        return this;
    }

    @Override // com.anychart.core.lineargauge.pointers.Bar, com.anychart.core.lineargauge.pointers.Base, com.anychart.core.VisualBase
    public RangeBar parentBounds(Number number) {
        APIlib.getInstance().addJSLine(String.format(Locale.US, this.jsBase + ".parentBounds(%s);", number));
        return this;
    }

    @Override // com.anychart.core.lineargauge.pointers.Bar, com.anychart.core.lineargauge.pointers.Base, com.anychart.core.VisualBase
    public RangeBar parentBounds(Number number, Number number2, Number number3, Number number4) {
        APIlib.getInstance().addJSLine(String.format(Locale.US, this.jsBase + ".parentBounds(%s, %s, %s, %s);", number, number2, number3, number4));
        return this;
    }

    @Override // com.anychart.core.lineargauge.pointers.Bar, com.anychart.core.lineargauge.pointers.Base
    public View data(View view) {
        return new View(String.format(Locale.US, this.jsBase + ".data(%s)", view != null ? view.getJsBase() : null));
    }

    @Override // com.anychart.core.lineargauge.pointers.Bar, com.anychart.core.lineargauge.pointers.Base
    public View data(List<DataEntry> list, TreeFillingMethod treeFillingMethod) {
        return new View(String.format(Locale.US, this.jsBase + ".data(%s, %s)", arrayToString(list), treeFillingMethod != null ? treeFillingMethod.getJsBase() : null));
    }

    @Override // com.anychart.core.lineargauge.pointers.Bar, com.anychart.core.lineargauge.pointers.Base
    public View data(List<DataEntry> list, String str) {
        return new View(String.format(Locale.US, this.jsBase + ".data(%s, %s)", arrayToString(list), wrapQuotes(str)));
    }

    @Override // com.anychart.core.lineargauge.pointers.Bar, com.anychart.core.lineargauge.pointers.Base
    public RangeBar fill(String str) {
        APIlib.getInstance().addJSLine(String.format(Locale.US, this.jsBase + ".fill(%s);", wrapQuotes(str)));
        return this;
    }
}
