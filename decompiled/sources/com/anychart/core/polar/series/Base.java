package com.anychart.core.polar.series;

import com.amazonaws.services.s3.model.InstructionFileId;
import com.anychart.APIlib;
import com.anychart.chart.common.dataentry.DataEntry;
import com.anychart.chart.common.listener.ListenersInterface;
import com.anychart.core.SeriesBase;
import com.anychart.core.SeriesPoint;
import com.anychart.core.StateSettings;
import com.anychart.core.ui.LabelsFactory;
import com.anychart.core.ui.MarkersFactory;
import com.anychart.core.ui.Tooltip;
import com.anychart.core.utils.Bounds;
import com.anychart.core.utils.LegendItemSettings;
import com.anychart.core.utils.SeriesA11y;
import com.anychart.data.View;
import com.anychart.enums.ScaleTypes;
import com.anychart.enums.SelectionMode;
import com.anychart.enums.Statistics;
import com.anychart.enums.TreeFillingMethod;
import com.anychart.graphics.vector.Layer;
import com.anychart.graphics.vector.PaperSize;
import com.anychart.graphics.vector.Stage;
import com.anychart.math.Rect;
import com.anychart.scales.Linear;
import com.anychart.scales.LinearColor;
import com.anychart.scales.OrdinalColor;
import com.anychart.utils.RectObj;
import java.lang.reflect.InvocationTargetException;
import java.util.Arrays;
import java.util.List;
import java.util.Locale;

/* JADX INFO: loaded from: classes5.dex */
public class Base extends SeriesBase {
    protected Base() {
    }

    public static Base instantiate() {
        return new Base("new anychart.core.polar.series.base()");
    }

    public Base(String str) {
        StringBuilder sb = new StringBuilder("base");
        int i = variableIndex + 1;
        variableIndex = i;
        this.jsBase = sb.append(i).toString();
        APIlib.getInstance().addJSLine(this.jsBase + " = " + str + ";");
    }

    @Override // com.anychart.core.SeriesBase, com.anychart.core.VisualBaseWithBounds, com.anychart.core.VisualBase, com.anychart.core.Base, com.anychart.JsObject
    public String getJsBase() {
        return this.jsBase;
    }

    @Override // com.anychart.core.SeriesBase
    public SeriesA11y a11y() {
        return new SeriesA11y(this.jsBase + ".a11y()");
    }

    @Override // com.anychart.core.SeriesBase
    public Base a11y(Boolean bool) {
        APIlib.getInstance().addJSLine(String.format(Locale.US, this.jsBase + ".a11y(%s);", bool));
        return this;
    }

    @Override // com.anychart.core.SeriesBase
    public Base a11y(String str) {
        APIlib.getInstance().addJSLine(String.format(Locale.US, this.jsBase + ".a11y(%s);", wrapQuotes(str)));
        return this;
    }

    @Override // com.anychart.core.SeriesBase, com.anychart.core.VisualBaseWithBounds
    public void bottom() {
        APIlib.getInstance().addJSLine(this.jsBase + ".bottom();");
    }

    @Override // com.anychart.core.SeriesBase, com.anychart.core.VisualBaseWithBounds
    public Base bottom(Number number) {
        APIlib.getInstance().addJSLine(String.format(Locale.US, this.jsBase + ".bottom(%s);", number));
        return this;
    }

    @Override // com.anychart.core.SeriesBase, com.anychart.core.VisualBaseWithBounds
    public Base bottom(String str) {
        APIlib.getInstance().addJSLine(String.format(Locale.US, this.jsBase + ".bottom(%s);", wrapQuotes(str)));
        return this;
    }

    @Override // com.anychart.core.SeriesBase, com.anychart.core.VisualBaseWithBounds
    public Bounds bounds() {
        return new Bounds(this.jsBase + ".bounds()");
    }

    @Override // com.anychart.core.SeriesBase, com.anychart.core.VisualBaseWithBounds
    public Base bounds(RectObj rectObj) {
        APIlib.getInstance().addJSLine(String.format(Locale.US, this.jsBase + ".bounds(%s);", rectObj != null ? rectObj.getJsBase() : null));
        return this;
    }

    @Override // com.anychart.core.SeriesBase, com.anychart.core.VisualBaseWithBounds
    public Base bounds(Rect rect) {
        APIlib.getInstance().addJSLine(String.format(Locale.US, this.jsBase + ".bounds(%s);", rect != null ? rect.getJsBase() : null));
        return this;
    }

    @Override // com.anychart.core.SeriesBase, com.anychart.core.VisualBaseWithBounds
    public Base bounds(Bounds bounds) {
        APIlib.getInstance().addJSLine(String.format(Locale.US, this.jsBase + ".bounds(%s);", bounds != null ? bounds.getJsBase() : null));
        return this;
    }

    @Override // com.anychart.core.SeriesBase, com.anychart.core.VisualBaseWithBounds
    public Base bounds(Number number, Number number2, Number number3, Number number4) {
        APIlib.getInstance().addJSLine(String.format(Locale.US, this.jsBase + ".bounds(%s, %s, %s, %s);", number, number2, number3, number4));
        return this;
    }

    @Override // com.anychart.core.SeriesBase, com.anychart.core.VisualBaseWithBounds
    public Base bounds(Number number, Number number2, Number number3, String str) {
        APIlib.getInstance().addJSLine(String.format(Locale.US, this.jsBase + ".bounds(%s, %s, %s, %s);", number, number2, number3, wrapQuotes(str)));
        return this;
    }

    @Override // com.anychart.core.SeriesBase, com.anychart.core.VisualBaseWithBounds
    public Base bounds(Number number, Number number2, String str, Number number3) {
        APIlib.getInstance().addJSLine(String.format(Locale.US, this.jsBase + ".bounds(%s, %s, %s, %s);", number, number2, wrapQuotes(str), number3));
        return this;
    }

    @Override // com.anychart.core.SeriesBase, com.anychart.core.VisualBaseWithBounds
    public Base bounds(Number number, Number number2, String str, String str2) {
        APIlib.getInstance().addJSLine(String.format(Locale.US, this.jsBase + ".bounds(%s, %s, %s, %s);", number, number2, wrapQuotes(str), wrapQuotes(str2)));
        return this;
    }

    @Override // com.anychart.core.SeriesBase, com.anychart.core.VisualBaseWithBounds
    public Base bounds(Number number, String str, Number number2, Number number3) {
        APIlib.getInstance().addJSLine(String.format(Locale.US, this.jsBase + ".bounds(%s, %s, %s, %s);", number, wrapQuotes(str), number2, number3));
        return this;
    }

    @Override // com.anychart.core.SeriesBase, com.anychart.core.VisualBaseWithBounds
    public Base bounds(Number number, String str, Number number2, String str2) {
        APIlib.getInstance().addJSLine(String.format(Locale.US, this.jsBase + ".bounds(%s, %s, %s, %s);", number, wrapQuotes(str), number2, wrapQuotes(str2)));
        return this;
    }

    @Override // com.anychart.core.SeriesBase, com.anychart.core.VisualBaseWithBounds
    public Base bounds(Number number, String str, String str2, Number number2) {
        APIlib.getInstance().addJSLine(String.format(Locale.US, this.jsBase + ".bounds(%s, %s, %s, %s);", number, wrapQuotes(str), wrapQuotes(str2), number2));
        return this;
    }

    @Override // com.anychart.core.SeriesBase, com.anychart.core.VisualBaseWithBounds
    public Base bounds(Number number, String str, String str2, String str3) {
        APIlib.getInstance().addJSLine(String.format(Locale.US, this.jsBase + ".bounds(%s, %s, %s, %s);", number, wrapQuotes(str), wrapQuotes(str2), wrapQuotes(str3)));
        return this;
    }

    @Override // com.anychart.core.SeriesBase, com.anychart.core.VisualBaseWithBounds
    public Base bounds(String str, Number number, Number number2, Number number3) {
        APIlib.getInstance().addJSLine(String.format(Locale.US, this.jsBase + ".bounds(%s, %s, %s, %s);", wrapQuotes(str), number, number2, number3));
        return this;
    }

    @Override // com.anychart.core.SeriesBase, com.anychart.core.VisualBaseWithBounds
    public Base bounds(String str, Number number, Number number2, String str2) {
        APIlib.getInstance().addJSLine(String.format(Locale.US, this.jsBase + ".bounds(%s, %s, %s, %s);", wrapQuotes(str), number, number2, wrapQuotes(str2)));
        return this;
    }

    @Override // com.anychart.core.SeriesBase, com.anychart.core.VisualBaseWithBounds
    public Base bounds(String str, Number number, String str2, Number number2) {
        APIlib.getInstance().addJSLine(String.format(Locale.US, this.jsBase + ".bounds(%s, %s, %s, %s);", wrapQuotes(str), number, wrapQuotes(str2), number2));
        return this;
    }

    @Override // com.anychart.core.SeriesBase, com.anychart.core.VisualBaseWithBounds
    public Base bounds(String str, Number number, String str2, String str3) {
        APIlib.getInstance().addJSLine(String.format(Locale.US, this.jsBase + ".bounds(%s, %s, %s, %s);", wrapQuotes(str), number, wrapQuotes(str2), wrapQuotes(str3)));
        return this;
    }

    @Override // com.anychart.core.SeriesBase, com.anychart.core.VisualBaseWithBounds
    public Base bounds(String str, String str2, Number number, Number number2) {
        APIlib.getInstance().addJSLine(String.format(Locale.US, this.jsBase + ".bounds(%s, %s, %s, %s);", wrapQuotes(str), wrapQuotes(str2), number, number2));
        return this;
    }

    @Override // com.anychart.core.SeriesBase, com.anychart.core.VisualBaseWithBounds
    public Base bounds(String str, String str2, Number number, String str3) {
        APIlib.getInstance().addJSLine(String.format(Locale.US, this.jsBase + ".bounds(%s, %s, %s, %s);", wrapQuotes(str), wrapQuotes(str2), number, wrapQuotes(str3)));
        return this;
    }

    @Override // com.anychart.core.SeriesBase, com.anychart.core.VisualBaseWithBounds
    public Base bounds(String str, String str2, String str3, Number number) {
        APIlib.getInstance().addJSLine(String.format(Locale.US, this.jsBase + ".bounds(%s, %s, %s, %s);", wrapQuotes(str), wrapQuotes(str2), wrapQuotes(str3), number));
        return this;
    }

    @Override // com.anychart.core.SeriesBase, com.anychart.core.VisualBaseWithBounds
    public Base bounds(String str, String str2, String str3, String str4) {
        APIlib.getInstance().addJSLine(String.format(Locale.US, this.jsBase + ".bounds(%s, %s, %s, %s);", wrapQuotes(str), wrapQuotes(str2), wrapQuotes(str3), wrapQuotes(str4)));
        return this;
    }

    @Override // com.anychart.core.SeriesBase
    public void color() {
        APIlib.getInstance().addJSLine(this.jsBase + ".color();");
    }

    @Override // com.anychart.core.SeriesBase
    public Base color(String str) {
        APIlib.getInstance().addJSLine(String.format(Locale.US, this.jsBase + ".color(%s);", wrapQuotes(str)));
        return this;
    }

    @Override // com.anychart.core.SeriesBase
    public LinearColor colorScale() {
        return new LinearColor(this.jsBase + ".colorScale()");
    }

    @Override // com.anychart.core.SeriesBase
    public Base colorScale(LinearColor linearColor) {
        APIlib.getInstance().addJSLine(String.format(Locale.US, this.jsBase + ".colorScale(%s);", linearColor != null ? linearColor.getJsBase() : null));
        return this;
    }

    @Override // com.anychart.core.SeriesBase
    public Base colorScale(OrdinalColor ordinalColor) {
        APIlib.getInstance().addJSLine(String.format(Locale.US, this.jsBase + ".colorScale(%s);", ordinalColor != null ? ordinalColor.getJsBase() : null));
        return this;
    }

    @Override // com.anychart.core.SeriesBase
    public Base colorScale(String str) {
        APIlib.getInstance().addJSLine(String.format(Locale.US, this.jsBase + ".colorScale(%s);", wrapQuotes(str)));
        return this;
    }

    @Override // com.anychart.core.SeriesBase
    public Base colorScale(ScaleTypes scaleTypes) {
        APIlib.getInstance().addJSLine(String.format(Locale.US, this.jsBase + ".colorScale(%s);", scaleTypes != null ? scaleTypes.getJsBase() : null));
        return this;
    }

    @Override // com.anychart.core.SeriesBase
    public View data(List<DataEntry> list) {
        return new View(String.format(Locale.US, this.jsBase + ".data(%s)", arrayToString(list)));
    }

    @Override // com.anychart.core.SeriesBase, com.anychart.core.VisualBaseWithBounds, com.anychart.core.VisualBase
    public void enabled() {
        APIlib.getInstance().addJSLine(this.jsBase + ".enabled();");
    }

    @Override // com.anychart.core.SeriesBase, com.anychart.core.VisualBaseWithBounds, com.anychart.core.VisualBase
    public Base enabled(Boolean bool) {
        APIlib.getInstance().addJSLine(String.format(Locale.US, this.jsBase + ".enabled(%s);", bool));
        return this;
    }

    public void excludePoint(Number number) {
        APIlib.getInstance().addJSLine(String.format(Locale.US, this.jsBase + ".excludePoint(%s);", number));
    }

    public void excludePoint(Number[] numberArr) {
        APIlib.getInstance().addJSLine(String.format(Locale.US, this.jsBase + ".excludePoint(%s);", Arrays.toString(numberArr)));
    }

    public void getExcludedPoints() {
        APIlib.getInstance().addJSLine(this.jsBase + ".getExcludedPoints();");
    }

    @Override // com.anychart.core.SeriesBase, com.anychart.core.VisualBaseWithBounds
    public Rect getPixelBounds() {
        return new Rect(this.jsBase + ".getPixelBounds()");
    }

    @Override // com.anychart.core.SeriesBase
    public SeriesPoint getPoint(Number number) {
        return new SeriesPoint(String.format(Locale.US, this.jsBase + ".getPoint(%s)", number));
    }

    @Override // com.anychart.core.SeriesBase
    public void getStat(Statistics statistics) {
        APIlib.getInstance().addJSLine(String.format(Locale.US, this.jsBase + ".getStat(%s);", statistics != null ? statistics.getJsBase() : null));
    }

    @Override // com.anychart.core.SeriesBase
    public void getStat(String str) {
        APIlib.getInstance().addJSLine(String.format(Locale.US, this.jsBase + ".getStat(%s);", wrapQuotes(str)));
    }

    @Override // com.anychart.core.SeriesBase, com.anychart.core.VisualBaseWithBounds
    public void height() {
        APIlib.getInstance().addJSLine(this.jsBase + ".height();");
    }

    @Override // com.anychart.core.SeriesBase, com.anychart.core.VisualBaseWithBounds
    public Base height(Number number) {
        APIlib.getInstance().addJSLine(String.format(Locale.US, this.jsBase + ".height(%s);", number));
        return this;
    }

    @Override // com.anychart.core.SeriesBase, com.anychart.core.VisualBaseWithBounds
    public Base height(String str) {
        APIlib.getInstance().addJSLine(String.format(Locale.US, this.jsBase + ".height(%s);", wrapQuotes(str)));
        return this;
    }

    @Override // com.anychart.core.SeriesBase
    public StateSettings hovered() {
        return new StateSettings(this.jsBase + ".hovered()");
    }

    @Override // com.anychart.core.SeriesBase
    public Base hovered(String str) {
        APIlib.getInstance().addJSLine(String.format(Locale.US, this.jsBase + ".hovered(%s);", wrapQuotes(str)));
        return this;
    }

    @Override // com.anychart.core.SeriesBase
    public void id() {
        APIlib.getInstance().addJSLine(this.jsBase + ".id();");
    }

    @Override // com.anychart.core.SeriesBase
    public Base id(String str) {
        APIlib.getInstance().addJSLine(String.format(Locale.US, this.jsBase + ".id(%s);", wrapQuotes(str)));
        return this;
    }

    @Override // com.anychart.core.SeriesBase
    public Base id(Number number) {
        APIlib.getInstance().addJSLine(String.format(Locale.US, this.jsBase + ".id(%s);", number));
        return this;
    }

    public void includeAllPoints() {
        APIlib.getInstance().addJSLine(this.jsBase + ".includeAllPoints();");
    }

    public void includePoint(Number number) {
        APIlib.getInstance().addJSLine(String.format(Locale.US, this.jsBase + ".includePoint(%s);", number));
    }

    public void includePoint(Number[] numberArr) {
        APIlib.getInstance().addJSLine(String.format(Locale.US, this.jsBase + ".includePoint(%s);", Arrays.toString(numberArr)));
    }

    public void keepOnlyPoints(Number number) {
        APIlib.getInstance().addJSLine(String.format(Locale.US, this.jsBase + ".keepOnlyPoints(%s);", number));
    }

    public void keepOnlyPoints(Number[] numberArr) {
        APIlib.getInstance().addJSLine(String.format(Locale.US, this.jsBase + ".keepOnlyPoints(%s);", Arrays.toString(numberArr)));
    }

    @Override // com.anychart.core.SeriesBase
    public LabelsFactory labels() {
        return new LabelsFactory(this.jsBase + ".labels()");
    }

    @Override // com.anychart.core.SeriesBase
    public Base labels(String str) {
        APIlib.getInstance().addJSLine(String.format(Locale.US, this.jsBase + ".labels(%s);", wrapQuotes(str)));
        return this;
    }

    @Override // com.anychart.core.SeriesBase
    public Base labels(Boolean bool) {
        APIlib.getInstance().addJSLine(String.format(Locale.US, this.jsBase + ".labels(%s);", bool));
        return this;
    }

    @Override // com.anychart.core.SeriesBase, com.anychart.core.VisualBaseWithBounds
    public void left() {
        APIlib.getInstance().addJSLine(this.jsBase + ".left();");
    }

    @Override // com.anychart.core.SeriesBase, com.anychart.core.VisualBaseWithBounds
    public Base left(Number number) {
        APIlib.getInstance().addJSLine(String.format(Locale.US, this.jsBase + ".left(%s);", number));
        return this;
    }

    @Override // com.anychart.core.SeriesBase, com.anychart.core.VisualBaseWithBounds
    public Base left(String str) {
        APIlib.getInstance().addJSLine(String.format(Locale.US, this.jsBase + ".left(%s);", wrapQuotes(str)));
        return this;
    }

    @Override // com.anychart.core.SeriesBase
    public LegendItemSettings legendItem() {
        return new LegendItemSettings(this.jsBase + ".legendItem()");
    }

    @Override // com.anychart.core.SeriesBase
    public Base legendItem(String str) {
        APIlib.getInstance().addJSLine(String.format(Locale.US, this.jsBase + ".legendItem(%s);", wrapQuotes(str)));
        return this;
    }

    @Override // com.anychart.core.SeriesBase, com.anychart.core.VisualBaseWithBounds
    public void maxHeight() {
        APIlib.getInstance().addJSLine(this.jsBase + ".maxHeight();");
    }

    @Override // com.anychart.core.SeriesBase, com.anychart.core.VisualBaseWithBounds
    public Base maxHeight(Number number) {
        APIlib.getInstance().addJSLine(String.format(Locale.US, this.jsBase + ".maxHeight(%s);", number));
        return this;
    }

    @Override // com.anychart.core.SeriesBase, com.anychart.core.VisualBaseWithBounds
    public Base maxHeight(String str) {
        APIlib.getInstance().addJSLine(String.format(Locale.US, this.jsBase + ".maxHeight(%s);", wrapQuotes(str)));
        return this;
    }

    public LabelsFactory maxLabels() {
        return new LabelsFactory(this.jsBase + ".maxLabels()");
    }

    public Base maxLabels(String str) {
        APIlib.getInstance().addJSLine(String.format(Locale.US, this.jsBase + ".maxLabels(%s);", wrapQuotes(str)));
        return this;
    }

    public Base maxLabels(Boolean bool) {
        APIlib.getInstance().addJSLine(String.format(Locale.US, this.jsBase + ".maxLabels(%s);", bool));
        return this;
    }

    public void maxPointWidth() {
        APIlib.getInstance().addJSLine(this.jsBase + ".maxPointWidth();");
    }

    public Base maxPointWidth(Number number) {
        APIlib.getInstance().addJSLine(String.format(Locale.US, this.jsBase + ".maxPointWidth(%s);", number));
        return this;
    }

    public Base maxPointWidth(String str) {
        APIlib.getInstance().addJSLine(String.format(Locale.US, this.jsBase + ".maxPointWidth(%s);", wrapQuotes(str)));
        return this;
    }

    @Override // com.anychart.core.SeriesBase, com.anychart.core.VisualBaseWithBounds
    public void maxWidth() {
        APIlib.getInstance().addJSLine(this.jsBase + ".maxWidth();");
    }

    @Override // com.anychart.core.SeriesBase, com.anychart.core.VisualBaseWithBounds
    public Base maxWidth(Number number) {
        APIlib.getInstance().addJSLine(String.format(Locale.US, this.jsBase + ".maxWidth(%s);", number));
        return this;
    }

    @Override // com.anychart.core.SeriesBase, com.anychart.core.VisualBaseWithBounds
    public Base maxWidth(String str) {
        APIlib.getInstance().addJSLine(String.format(Locale.US, this.jsBase + ".maxWidth(%s);", wrapQuotes(str)));
        return this;
    }

    @Override // com.anychart.core.SeriesBase
    public void meta(String str) {
        APIlib.getInstance().addJSLine(String.format(Locale.US, this.jsBase + ".meta(%s);", wrapQuotes(str)));
    }

    @Override // com.anychart.core.SeriesBase
    public Base meta(String str, String str2) {
        APIlib.getInstance().addJSLine(String.format(Locale.US, this.jsBase + ".meta(%s, %s);", wrapQuotes(str), wrapQuotes(str2)));
        return this;
    }

    @Override // com.anychart.core.SeriesBase, com.anychart.core.VisualBaseWithBounds
    public void minHeight() {
        APIlib.getInstance().addJSLine(this.jsBase + ".minHeight();");
    }

    @Override // com.anychart.core.SeriesBase, com.anychart.core.VisualBaseWithBounds
    public Base minHeight(Number number) {
        APIlib.getInstance().addJSLine(String.format(Locale.US, this.jsBase + ".minHeight(%s);", number));
        return this;
    }

    @Override // com.anychart.core.SeriesBase, com.anychart.core.VisualBaseWithBounds
    public Base minHeight(String str) {
        APIlib.getInstance().addJSLine(String.format(Locale.US, this.jsBase + ".minHeight(%s);", wrapQuotes(str)));
        return this;
    }

    public LabelsFactory minLabels() {
        return new LabelsFactory(this.jsBase + ".minLabels()");
    }

    public Base minLabels(String str) {
        APIlib.getInstance().addJSLine(String.format(Locale.US, this.jsBase + ".minLabels(%s);", wrapQuotes(str)));
        return this;
    }

    public Base minLabels(Boolean bool) {
        APIlib.getInstance().addJSLine(String.format(Locale.US, this.jsBase + ".minLabels(%s);", bool));
        return this;
    }

    public void minPointLength() {
        APIlib.getInstance().addJSLine(this.jsBase + ".minPointLength();");
    }

    public Base minPointLength(Number number) {
        APIlib.getInstance().addJSLine(String.format(Locale.US, this.jsBase + ".minPointLength(%s);", number));
        return this;
    }

    public Base minPointLength(String str) {
        APIlib.getInstance().addJSLine(String.format(Locale.US, this.jsBase + ".minPointLength(%s);", wrapQuotes(str)));
        return this;
    }

    @Override // com.anychart.core.SeriesBase, com.anychart.core.VisualBaseWithBounds
    public void minWidth() {
        APIlib.getInstance().addJSLine(this.jsBase + ".minWidth();");
    }

    @Override // com.anychart.core.SeriesBase, com.anychart.core.VisualBaseWithBounds
    public Base minWidth(Number number) {
        APIlib.getInstance().addJSLine(String.format(Locale.US, this.jsBase + ".minWidth(%s);", number));
        return this;
    }

    @Override // com.anychart.core.SeriesBase, com.anychart.core.VisualBaseWithBounds
    public Base minWidth(String str) {
        APIlib.getInstance().addJSLine(String.format(Locale.US, this.jsBase + ".minWidth(%s);", wrapQuotes(str)));
        return this;
    }

    @Override // com.anychart.core.SeriesBase
    public void name() {
        APIlib.getInstance().addJSLine(this.jsBase + ".name();");
    }

    @Override // com.anychart.core.SeriesBase
    public Base name(String str) {
        APIlib.getInstance().addJSLine(String.format(Locale.US, this.jsBase + ".name(%s);", wrapQuotes(str)));
        return this;
    }

    @Override // com.anychart.core.SeriesBase
    public StateSettings normal() {
        return new StateSettings(this.jsBase + ".normal()");
    }

    @Override // com.anychart.core.SeriesBase
    public Base normal(String str) {
        APIlib.getInstance().addJSLine(String.format(Locale.US, this.jsBase + ".normal(%s);", wrapQuotes(str)));
        return this;
    }

    public void pointWidth() {
        APIlib.getInstance().addJSLine(this.jsBase + ".pointWidth();");
    }

    public Base pointWidth(Number number) {
        APIlib.getInstance().addJSLine(String.format(Locale.US, this.jsBase + ".pointWidth(%s);", number));
        return this;
    }

    public Base pointWidth(String str) {
        APIlib.getInstance().addJSLine(String.format(Locale.US, this.jsBase + ".pointWidth(%s);", wrapQuotes(str)));
        return this;
    }

    @Override // com.anychart.core.SeriesBase, com.anychart.core.VisualBaseWithBounds, com.anychart.core.VisualBase
    public void print(PaperSize paperSize, Boolean bool) {
        APIlib.getInstance().addJSLine(String.format(Locale.US, this.jsBase + ".print(%s, %s);", paperSize != null ? paperSize.getJsBase() : null, bool));
    }

    @Override // com.anychart.core.SeriesBase, com.anychart.core.VisualBaseWithBounds, com.anychart.core.VisualBase
    public void print(String str, Boolean bool) {
        APIlib.getInstance().addJSLine(String.format(Locale.US, this.jsBase + ".print(%s, %s);", wrapQuotes(str), bool));
    }

    @Override // com.anychart.core.SeriesBase, com.anychart.core.VisualBaseWithBounds, com.anychart.core.VisualBase, com.anychart.core.Base
    public void removeAllListeners(String str) {
        APIlib.getInstance().addJSLine(String.format(Locale.US, this.jsBase + ".removeAllListeners(%s);", wrapQuotes(str)));
    }

    @Override // com.anychart.core.SeriesBase, com.anychart.core.VisualBaseWithBounds
    public void right() {
        APIlib.getInstance().addJSLine(this.jsBase + ".right();");
    }

    @Override // com.anychart.core.SeriesBase, com.anychart.core.VisualBaseWithBounds
    public Base right(Number number) {
        APIlib.getInstance().addJSLine(String.format(Locale.US, this.jsBase + ".right(%s);", number));
        return this;
    }

    @Override // com.anychart.core.SeriesBase, com.anychart.core.VisualBaseWithBounds
    public Base right(String str) {
        APIlib.getInstance().addJSLine(String.format(Locale.US, this.jsBase + ".right(%s);", wrapQuotes(str)));
        return this;
    }

    @Override // com.anychart.core.SeriesBase
    public Base select(Number number) {
        APIlib.getInstance().addJSLine(String.format(Locale.US, this.jsBase + ".select(%s);", number));
        return this;
    }

    @Override // com.anychart.core.SeriesBase
    public Base select(Number[] numberArr) {
        APIlib.getInstance().addJSLine(String.format(Locale.US, this.jsBase + ".select(%s);", Arrays.toString(numberArr)));
        return this;
    }

    @Override // com.anychart.core.SeriesBase
    public StateSettings selected() {
        return new StateSettings(this.jsBase + ".selected()");
    }

    @Override // com.anychart.core.SeriesBase
    public Base selected(String str) {
        APIlib.getInstance().addJSLine(String.format(Locale.US, this.jsBase + ".selected(%s);", wrapQuotes(str)));
        return this;
    }

    @Override // com.anychart.core.SeriesBase
    public void selectionMode() {
        APIlib.getInstance().addJSLine(this.jsBase + ".selectionMode();");
    }

    @Override // com.anychart.core.SeriesBase
    public Base selectionMode(SelectionMode selectionMode) {
        APIlib.getInstance().addJSLine(String.format(Locale.US, this.jsBase + ".selectionMode(%s);", selectionMode != null ? selectionMode.getJsBase() : null));
        return this;
    }

    @Override // com.anychart.core.SeriesBase
    public Base selectionMode(String str) {
        APIlib.getInstance().addJSLine(String.format(Locale.US, this.jsBase + ".selectionMode(%s);", wrapQuotes(str)));
        return this;
    }

    @Override // com.anychart.core.SeriesBase
    public Tooltip tooltip() {
        return new Tooltip(this.jsBase + ".tooltip()");
    }

    @Override // com.anychart.core.SeriesBase
    public Base tooltip(String str) {
        APIlib.getInstance().addJSLine(String.format(Locale.US, this.jsBase + ".tooltip(%s);", wrapQuotes(str)));
        return this;
    }

    @Override // com.anychart.core.SeriesBase
    public Base tooltip(Boolean bool) {
        APIlib.getInstance().addJSLine(String.format(Locale.US, this.jsBase + ".tooltip(%s);", bool));
        return this;
    }

    @Override // com.anychart.core.SeriesBase, com.anychart.core.VisualBaseWithBounds
    public void top() {
        APIlib.getInstance().addJSLine(this.jsBase + ".top();");
    }

    @Override // com.anychart.core.SeriesBase, com.anychart.core.VisualBaseWithBounds
    public Base top(Number number) {
        APIlib.getInstance().addJSLine(String.format(Locale.US, this.jsBase + ".top(%s);", number));
        return this;
    }

    @Override // com.anychart.core.SeriesBase, com.anychart.core.VisualBaseWithBounds
    public Base top(String str) {
        APIlib.getInstance().addJSLine(String.format(Locale.US, this.jsBase + ".top(%s);", wrapQuotes(str)));
        return this;
    }

    public void transformXY(String str, String str2) {
        APIlib.getInstance().addJSLine(String.format(Locale.US, this.jsBase + ".transformXY(%s, %s);", wrapQuotes(str), wrapQuotes(str2)));
    }

    @Override // com.anychart.core.SeriesBase
    public Base unhover(Number number) {
        APIlib.getInstance().addJSLine(String.format(Locale.US, this.jsBase + ".unhover(%s);", number));
        return this;
    }

    @Override // com.anychart.core.SeriesBase
    public Base unhover(Number[] numberArr) {
        APIlib.getInstance().addJSLine(String.format(Locale.US, this.jsBase + ".unhover(%s);", Arrays.toString(numberArr)));
        return this;
    }

    @Override // com.anychart.core.SeriesBase, com.anychart.core.VisualBaseWithBounds, com.anychart.core.VisualBase, com.anychart.core.Base
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

    @Override // com.anychart.core.SeriesBase, com.anychart.core.VisualBaseWithBounds, com.anychart.core.VisualBase, com.anychart.core.Base
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

    @Override // com.anychart.core.SeriesBase, com.anychart.core.VisualBaseWithBounds, com.anychart.core.VisualBase, com.anychart.core.Base
    public void unlistenByKey(String str) {
        APIlib.getInstance().addJSLine(String.format(Locale.US, this.jsBase + ".unlistenByKey(%s);", wrapQuotes(str)));
    }

    @Override // com.anychart.core.SeriesBase
    public Base unselect() {
        APIlib.getInstance().addJSLine(this.jsBase + ".unselect();");
        return this;
    }

    @Override // com.anychart.core.SeriesBase
    public Base unselect(Number number) {
        APIlib.getInstance().addJSLine(String.format(Locale.US, this.jsBase + ".unselect(%s);", number));
        return this;
    }

    @Override // com.anychart.core.SeriesBase
    public Base unselect(Number[] numberArr) {
        APIlib.getInstance().addJSLine(String.format(Locale.US, this.jsBase + ".unselect(%s);", Arrays.toString(numberArr)));
        return this;
    }

    @Override // com.anychart.core.SeriesBase, com.anychart.core.VisualBaseWithBounds
    public void width() {
        APIlib.getInstance().addJSLine(this.jsBase + ".width();");
    }

    @Override // com.anychart.core.SeriesBase, com.anychart.core.VisualBaseWithBounds
    public Base width(Number number) {
        APIlib.getInstance().addJSLine(String.format(Locale.US, this.jsBase + ".width(%s);", number));
        return this;
    }

    @Override // com.anychart.core.SeriesBase, com.anychart.core.VisualBaseWithBounds
    public Base width(String str) {
        APIlib.getInstance().addJSLine(String.format(Locale.US, this.jsBase + ".width(%s);", wrapQuotes(str)));
        return this;
    }

    public Linear xScale() {
        return new Linear(this.jsBase + ".xScale()");
    }

    public Base xScale(com.anychart.scales.Base base) {
        APIlib.getInstance().addJSLine(String.format(Locale.US, this.jsBase + ".xScale(%s);", base != null ? base.getJsBase() : null));
        return this;
    }

    public Base xScale(String str) {
        APIlib.getInstance().addJSLine(String.format(Locale.US, this.jsBase + ".xScale(%s);", wrapQuotes(str)));
        return this;
    }

    public Base xScale(ScaleTypes scaleTypes) {
        APIlib.getInstance().addJSLine(String.format(Locale.US, this.jsBase + ".xScale(%s);", scaleTypes != null ? scaleTypes.getJsBase() : null));
        return this;
    }

    public com.anychart.scales.Base yScale() {
        return new com.anychart.scales.Base(this.jsBase + ".yScale()");
    }

    public Base yScale(com.anychart.scales.Base base) {
        APIlib.getInstance().addJSLine(String.format(Locale.US, this.jsBase + ".yScale(%s);", base != null ? base.getJsBase() : null));
        return this;
    }

    public Base yScale(String str) {
        APIlib.getInstance().addJSLine(String.format(Locale.US, this.jsBase + ".yScale(%s);", wrapQuotes(str)));
        return this;
    }

    public Base yScale(ScaleTypes scaleTypes) {
        APIlib.getInstance().addJSLine(String.format(Locale.US, this.jsBase + ".yScale(%s);", scaleTypes != null ? scaleTypes.getJsBase() : null));
        return this;
    }

    @Override // com.anychart.core.SeriesBase, com.anychart.core.VisualBaseWithBounds, com.anychart.core.VisualBase
    public void zIndex() {
        APIlib.getInstance().addJSLine(this.jsBase + ".zIndex();");
    }

    @Override // com.anychart.core.SeriesBase, com.anychart.core.VisualBaseWithBounds, com.anychart.core.VisualBase
    public Base zIndex(Number number) {
        APIlib.getInstance().addJSLine(String.format(Locale.US, this.jsBase + ".zIndex(%s);", number));
        return this;
    }

    @Override // com.anychart.core.SeriesBase
    public Base hover() {
        APIlib.getInstance().addJSLine(this.jsBase + ".hover();");
        return this;
    }

    @Override // com.anychart.core.SeriesBase
    public Base hover(Number number) {
        APIlib.getInstance().addJSLine(String.format(Locale.US, this.jsBase + ".hover(%s);", number));
        return this;
    }

    @Override // com.anychart.core.SeriesBase
    public Base hover(Number[] numberArr) {
        APIlib.getInstance().addJSLine(String.format(Locale.US, this.jsBase + ".hover(%s);", Arrays.toString(numberArr)));
        return this;
    }

    @Override // com.anychart.core.SeriesBase
    public MarkersFactory markers() {
        return new MarkersFactory(this.jsBase + ".markers()");
    }

    @Override // com.anychart.core.SeriesBase
    public Base markers(String str) {
        APIlib.getInstance().addJSLine(String.format(Locale.US, this.jsBase + ".markers(%s);", wrapQuotes(str)));
        return this;
    }

    @Override // com.anychart.core.SeriesBase
    public Base markers(Boolean bool) {
        APIlib.getInstance().addJSLine(String.format(Locale.US, this.jsBase + ".markers(%s);", bool));
        return this;
    }

    @Override // com.anychart.core.SeriesBase, com.anychart.core.VisualBaseWithBounds, com.anychart.core.VisualBase
    public Layer container() {
        return new Layer(this.jsBase + ".container()");
    }

    @Override // com.anychart.core.SeriesBase, com.anychart.core.VisualBaseWithBounds, com.anychart.core.VisualBase
    public Base container(Layer layer) {
        APIlib.getInstance().addJSLine(String.format(Locale.US, this.jsBase + ".container(%s);", layer != null ? layer.getJsBase() : null));
        return this;
    }

    @Override // com.anychart.core.SeriesBase, com.anychart.core.VisualBaseWithBounds, com.anychart.core.VisualBase
    public Base container(Stage stage) {
        APIlib.getInstance().addJSLine(String.format(Locale.US, this.jsBase + ".container(%s);", stage != null ? stage.getJsBase() : null));
        return this;
    }

    @Override // com.anychart.core.SeriesBase, com.anychart.core.VisualBaseWithBounds, com.anychart.core.VisualBase
    public Base container(String str) {
        APIlib.getInstance().addJSLine(String.format(Locale.US, this.jsBase + ".container(%s);", wrapQuotes(str)));
        return this;
    }

    @Override // com.anychart.core.SeriesBase, com.anychart.core.VisualBaseWithBounds, com.anychart.core.VisualBase
    public Rect parentBounds() {
        return new Rect(this.jsBase + ".parentBounds()");
    }

    @Override // com.anychart.core.SeriesBase, com.anychart.core.VisualBaseWithBounds, com.anychart.core.VisualBase
    public Base parentBounds(Rect rect) {
        APIlib.getInstance().addJSLine(String.format(Locale.US, this.jsBase + ".parentBounds(%s);", rect != null ? rect.getJsBase() : null));
        return this;
    }

    @Override // com.anychart.core.SeriesBase, com.anychart.core.VisualBaseWithBounds, com.anychart.core.VisualBase
    public Base parentBounds(String str) {
        APIlib.getInstance().addJSLine(String.format(Locale.US, this.jsBase + ".parentBounds(%s);", wrapQuotes(str)));
        return this;
    }

    @Override // com.anychart.core.SeriesBase, com.anychart.core.VisualBaseWithBounds, com.anychart.core.VisualBase
    public Base parentBounds(Number number) {
        APIlib.getInstance().addJSLine(String.format(Locale.US, this.jsBase + ".parentBounds(%s);", number));
        return this;
    }

    @Override // com.anychart.core.SeriesBase, com.anychart.core.VisualBaseWithBounds, com.anychart.core.VisualBase
    public Base parentBounds(Number number, Number number2, Number number3, Number number4) {
        APIlib.getInstance().addJSLine(String.format(Locale.US, this.jsBase + ".parentBounds(%s, %s, %s, %s);", number, number2, number3, number4));
        return this;
    }

    @Override // com.anychart.core.SeriesBase
    public View data(View view) {
        return new View(String.format(Locale.US, this.jsBase + ".data(%s)", view != null ? view.getJsBase() : null));
    }

    @Override // com.anychart.core.SeriesBase
    public View data(List<DataEntry> list, TreeFillingMethod treeFillingMethod) {
        return new View(String.format(Locale.US, this.jsBase + ".data(%s, %s)", arrayToString(list), treeFillingMethod != null ? treeFillingMethod.getJsBase() : null));
    }

    @Override // com.anychart.core.SeriesBase
    public View data(List<DataEntry> list, String str) {
        return new View(String.format(Locale.US, this.jsBase + ".data(%s, %s)", arrayToString(list), wrapQuotes(str)));
    }

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
