package com.anychart.core.radar.series;

import com.amazonaws.services.s3.model.InstructionFileId;
import com.anychart.APIlib;
import com.anychart.chart.common.dataentry.DataEntry;
import com.anychart.chart.common.listener.ListenersInterface;
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
import com.anychart.graphics.vector.ColoredFill;
import com.anychart.graphics.vector.Layer;
import com.anychart.graphics.vector.PaperSize;
import com.anychart.graphics.vector.Stage;
import com.anychart.graphics.vector.Stroke;
import com.anychart.graphics.vector.StrokeLineCap;
import com.anychart.graphics.vector.StrokeLineJoin;
import com.anychart.math.Rect;
import com.anychart.scales.LinearColor;
import com.anychart.scales.Ordinal;
import com.anychart.scales.OrdinalColor;
import com.anychart.utils.RectObj;
import java.lang.reflect.InvocationTargetException;
import java.util.Arrays;
import java.util.List;
import java.util.Locale;

/* JADX INFO: loaded from: classes5.dex */
public class Line extends ContinuousBase {
    protected Line() {
    }

    public static Line instantiate() {
        return new Line("new anychart.core.radar.series.line()");
    }

    public Line(String str) {
        StringBuilder sb = new StringBuilder("line");
        int i = variableIndex + 1;
        variableIndex = i;
        this.jsBase = sb.append(i).toString();
        APIlib.getInstance().addJSLine(this.jsBase + " = " + str + ";");
    }

    @Override // com.anychart.core.radar.series.ContinuousBase, com.anychart.core.radar.series.Base, com.anychart.core.SeriesBase, com.anychart.core.VisualBaseWithBounds, com.anychart.core.VisualBase, com.anychart.core.Base, com.anychart.JsObject
    public String getJsBase() {
        return this.jsBase;
    }

    @Override // com.anychart.core.radar.series.ContinuousBase, com.anychart.core.radar.series.Base, com.anychart.core.SeriesBase
    public SeriesA11y a11y() {
        return new SeriesA11y(this.jsBase + ".a11y()");
    }

    @Override // com.anychart.core.radar.series.ContinuousBase, com.anychart.core.radar.series.Base, com.anychart.core.SeriesBase
    public Line a11y(Boolean bool) {
        APIlib.getInstance().addJSLine(String.format(Locale.US, this.jsBase + ".a11y(%s);", bool));
        return this;
    }

    @Override // com.anychart.core.radar.series.ContinuousBase, com.anychart.core.radar.series.Base, com.anychart.core.SeriesBase
    public Line a11y(String str) {
        APIlib.getInstance().addJSLine(String.format(Locale.US, this.jsBase + ".a11y(%s);", wrapQuotes(str)));
        return this;
    }

    @Override // com.anychart.core.radar.series.ContinuousBase, com.anychart.core.radar.series.Base, com.anychart.core.SeriesBase, com.anychart.core.VisualBaseWithBounds
    public void bottom() {
        APIlib.getInstance().addJSLine(this.jsBase + ".bottom();");
    }

    @Override // com.anychart.core.radar.series.ContinuousBase, com.anychart.core.radar.series.Base, com.anychart.core.SeriesBase, com.anychart.core.VisualBaseWithBounds
    public Line bottom(Number number) {
        APIlib.getInstance().addJSLine(String.format(Locale.US, this.jsBase + ".bottom(%s);", number));
        return this;
    }

    @Override // com.anychart.core.radar.series.ContinuousBase, com.anychart.core.radar.series.Base, com.anychart.core.SeriesBase, com.anychart.core.VisualBaseWithBounds
    public Line bottom(String str) {
        APIlib.getInstance().addJSLine(String.format(Locale.US, this.jsBase + ".bottom(%s);", wrapQuotes(str)));
        return this;
    }

    @Override // com.anychart.core.radar.series.ContinuousBase, com.anychart.core.radar.series.Base, com.anychart.core.SeriesBase, com.anychart.core.VisualBaseWithBounds
    public Bounds bounds() {
        return new Bounds(this.jsBase + ".bounds()");
    }

    @Override // com.anychart.core.radar.series.ContinuousBase, com.anychart.core.radar.series.Base, com.anychart.core.SeriesBase, com.anychart.core.VisualBaseWithBounds
    public Line bounds(RectObj rectObj) {
        APIlib.getInstance().addJSLine(String.format(Locale.US, this.jsBase + ".bounds(%s);", rectObj != null ? rectObj.getJsBase() : null));
        return this;
    }

    @Override // com.anychart.core.radar.series.ContinuousBase, com.anychart.core.radar.series.Base, com.anychart.core.SeriesBase, com.anychart.core.VisualBaseWithBounds
    public Line bounds(Rect rect) {
        APIlib.getInstance().addJSLine(String.format(Locale.US, this.jsBase + ".bounds(%s);", rect != null ? rect.getJsBase() : null));
        return this;
    }

    @Override // com.anychart.core.radar.series.ContinuousBase, com.anychart.core.radar.series.Base, com.anychart.core.SeriesBase, com.anychart.core.VisualBaseWithBounds
    public Line bounds(Bounds bounds) {
        APIlib.getInstance().addJSLine(String.format(Locale.US, this.jsBase + ".bounds(%s);", bounds != null ? bounds.getJsBase() : null));
        return this;
    }

    @Override // com.anychart.core.radar.series.ContinuousBase, com.anychart.core.radar.series.Base, com.anychart.core.SeriesBase, com.anychart.core.VisualBaseWithBounds
    public Line bounds(Number number, Number number2, Number number3, Number number4) {
        APIlib.getInstance().addJSLine(String.format(Locale.US, this.jsBase + ".bounds(%s, %s, %s, %s);", number, number2, number3, number4));
        return this;
    }

    @Override // com.anychart.core.radar.series.ContinuousBase, com.anychart.core.radar.series.Base, com.anychart.core.SeriesBase, com.anychart.core.VisualBaseWithBounds
    public Line bounds(Number number, Number number2, Number number3, String str) {
        APIlib.getInstance().addJSLine(String.format(Locale.US, this.jsBase + ".bounds(%s, %s, %s, %s);", number, number2, number3, wrapQuotes(str)));
        return this;
    }

    @Override // com.anychart.core.radar.series.ContinuousBase, com.anychart.core.radar.series.Base, com.anychart.core.SeriesBase, com.anychart.core.VisualBaseWithBounds
    public Line bounds(Number number, Number number2, String str, Number number3) {
        APIlib.getInstance().addJSLine(String.format(Locale.US, this.jsBase + ".bounds(%s, %s, %s, %s);", number, number2, wrapQuotes(str), number3));
        return this;
    }

    @Override // com.anychart.core.radar.series.ContinuousBase, com.anychart.core.radar.series.Base, com.anychart.core.SeriesBase, com.anychart.core.VisualBaseWithBounds
    public Line bounds(Number number, Number number2, String str, String str2) {
        APIlib.getInstance().addJSLine(String.format(Locale.US, this.jsBase + ".bounds(%s, %s, %s, %s);", number, number2, wrapQuotes(str), wrapQuotes(str2)));
        return this;
    }

    @Override // com.anychart.core.radar.series.ContinuousBase, com.anychart.core.radar.series.Base, com.anychart.core.SeriesBase, com.anychart.core.VisualBaseWithBounds
    public Line bounds(Number number, String str, Number number2, Number number3) {
        APIlib.getInstance().addJSLine(String.format(Locale.US, this.jsBase + ".bounds(%s, %s, %s, %s);", number, wrapQuotes(str), number2, number3));
        return this;
    }

    @Override // com.anychart.core.radar.series.ContinuousBase, com.anychart.core.radar.series.Base, com.anychart.core.SeriesBase, com.anychart.core.VisualBaseWithBounds
    public Line bounds(Number number, String str, Number number2, String str2) {
        APIlib.getInstance().addJSLine(String.format(Locale.US, this.jsBase + ".bounds(%s, %s, %s, %s);", number, wrapQuotes(str), number2, wrapQuotes(str2)));
        return this;
    }

    @Override // com.anychart.core.radar.series.ContinuousBase, com.anychart.core.radar.series.Base, com.anychart.core.SeriesBase, com.anychart.core.VisualBaseWithBounds
    public Line bounds(Number number, String str, String str2, Number number2) {
        APIlib.getInstance().addJSLine(String.format(Locale.US, this.jsBase + ".bounds(%s, %s, %s, %s);", number, wrapQuotes(str), wrapQuotes(str2), number2));
        return this;
    }

    @Override // com.anychart.core.radar.series.ContinuousBase, com.anychart.core.radar.series.Base, com.anychart.core.SeriesBase, com.anychart.core.VisualBaseWithBounds
    public Line bounds(Number number, String str, String str2, String str3) {
        APIlib.getInstance().addJSLine(String.format(Locale.US, this.jsBase + ".bounds(%s, %s, %s, %s);", number, wrapQuotes(str), wrapQuotes(str2), wrapQuotes(str3)));
        return this;
    }

    @Override // com.anychart.core.radar.series.ContinuousBase, com.anychart.core.radar.series.Base, com.anychart.core.SeriesBase, com.anychart.core.VisualBaseWithBounds
    public Line bounds(String str, Number number, Number number2, Number number3) {
        APIlib.getInstance().addJSLine(String.format(Locale.US, this.jsBase + ".bounds(%s, %s, %s, %s);", wrapQuotes(str), number, number2, number3));
        return this;
    }

    @Override // com.anychart.core.radar.series.ContinuousBase, com.anychart.core.radar.series.Base, com.anychart.core.SeriesBase, com.anychart.core.VisualBaseWithBounds
    public Line bounds(String str, Number number, Number number2, String str2) {
        APIlib.getInstance().addJSLine(String.format(Locale.US, this.jsBase + ".bounds(%s, %s, %s, %s);", wrapQuotes(str), number, number2, wrapQuotes(str2)));
        return this;
    }

    @Override // com.anychart.core.radar.series.ContinuousBase, com.anychart.core.radar.series.Base, com.anychart.core.SeriesBase, com.anychart.core.VisualBaseWithBounds
    public Line bounds(String str, Number number, String str2, Number number2) {
        APIlib.getInstance().addJSLine(String.format(Locale.US, this.jsBase + ".bounds(%s, %s, %s, %s);", wrapQuotes(str), number, wrapQuotes(str2), number2));
        return this;
    }

    @Override // com.anychart.core.radar.series.ContinuousBase, com.anychart.core.radar.series.Base, com.anychart.core.SeriesBase, com.anychart.core.VisualBaseWithBounds
    public Line bounds(String str, Number number, String str2, String str3) {
        APIlib.getInstance().addJSLine(String.format(Locale.US, this.jsBase + ".bounds(%s, %s, %s, %s);", wrapQuotes(str), number, wrapQuotes(str2), wrapQuotes(str3)));
        return this;
    }

    @Override // com.anychart.core.radar.series.ContinuousBase, com.anychart.core.radar.series.Base, com.anychart.core.SeriesBase, com.anychart.core.VisualBaseWithBounds
    public Line bounds(String str, String str2, Number number, Number number2) {
        APIlib.getInstance().addJSLine(String.format(Locale.US, this.jsBase + ".bounds(%s, %s, %s, %s);", wrapQuotes(str), wrapQuotes(str2), number, number2));
        return this;
    }

    @Override // com.anychart.core.radar.series.ContinuousBase, com.anychart.core.radar.series.Base, com.anychart.core.SeriesBase, com.anychart.core.VisualBaseWithBounds
    public Line bounds(String str, String str2, Number number, String str3) {
        APIlib.getInstance().addJSLine(String.format(Locale.US, this.jsBase + ".bounds(%s, %s, %s, %s);", wrapQuotes(str), wrapQuotes(str2), number, wrapQuotes(str3)));
        return this;
    }

    @Override // com.anychart.core.radar.series.ContinuousBase, com.anychart.core.radar.series.Base, com.anychart.core.SeriesBase, com.anychart.core.VisualBaseWithBounds
    public Line bounds(String str, String str2, String str3, Number number) {
        APIlib.getInstance().addJSLine(String.format(Locale.US, this.jsBase + ".bounds(%s, %s, %s, %s);", wrapQuotes(str), wrapQuotes(str2), wrapQuotes(str3), number));
        return this;
    }

    @Override // com.anychart.core.radar.series.ContinuousBase, com.anychart.core.radar.series.Base, com.anychart.core.SeriesBase, com.anychart.core.VisualBaseWithBounds
    public Line bounds(String str, String str2, String str3, String str4) {
        APIlib.getInstance().addJSLine(String.format(Locale.US, this.jsBase + ".bounds(%s, %s, %s, %s);", wrapQuotes(str), wrapQuotes(str2), wrapQuotes(str3), wrapQuotes(str4)));
        return this;
    }

    @Override // com.anychart.core.radar.series.ContinuousBase, com.anychart.core.radar.series.Base, com.anychart.core.SeriesBase
    public void color() {
        APIlib.getInstance().addJSLine(this.jsBase + ".color();");
    }

    @Override // com.anychart.core.radar.series.ContinuousBase, com.anychart.core.radar.series.Base, com.anychart.core.SeriesBase
    public Line color(String str) {
        APIlib.getInstance().addJSLine(String.format(Locale.US, this.jsBase + ".color(%s);", wrapQuotes(str)));
        return this;
    }

    @Override // com.anychart.core.radar.series.ContinuousBase, com.anychart.core.radar.series.Base, com.anychart.core.SeriesBase
    public LinearColor colorScale() {
        return new LinearColor(this.jsBase + ".colorScale()");
    }

    @Override // com.anychart.core.radar.series.ContinuousBase, com.anychart.core.radar.series.Base, com.anychart.core.SeriesBase
    public Line colorScale(LinearColor linearColor) {
        APIlib.getInstance().addJSLine(String.format(Locale.US, this.jsBase + ".colorScale(%s);", linearColor != null ? linearColor.getJsBase() : null));
        return this;
    }

    @Override // com.anychart.core.radar.series.ContinuousBase, com.anychart.core.radar.series.Base, com.anychart.core.SeriesBase
    public Line colorScale(OrdinalColor ordinalColor) {
        APIlib.getInstance().addJSLine(String.format(Locale.US, this.jsBase + ".colorScale(%s);", ordinalColor != null ? ordinalColor.getJsBase() : null));
        return this;
    }

    @Override // com.anychart.core.radar.series.ContinuousBase, com.anychart.core.radar.series.Base, com.anychart.core.SeriesBase
    public Line colorScale(String str) {
        APIlib.getInstance().addJSLine(String.format(Locale.US, this.jsBase + ".colorScale(%s);", wrapQuotes(str)));
        return this;
    }

    @Override // com.anychart.core.radar.series.ContinuousBase, com.anychart.core.radar.series.Base, com.anychart.core.SeriesBase
    public Line colorScale(ScaleTypes scaleTypes) {
        APIlib.getInstance().addJSLine(String.format(Locale.US, this.jsBase + ".colorScale(%s);", scaleTypes != null ? scaleTypes.getJsBase() : null));
        return this;
    }

    @Override // com.anychart.core.radar.series.ContinuousBase
    public void connectMissingPoints() {
        APIlib.getInstance().addJSLine(this.jsBase + ".connectMissingPoints();");
    }

    @Override // com.anychart.core.radar.series.ContinuousBase
    public Line connectMissingPoints(Boolean bool) {
        APIlib.getInstance().addJSLine(String.format(Locale.US, this.jsBase + ".connectMissingPoints(%s);", bool));
        return this;
    }

    @Override // com.anychart.core.radar.series.ContinuousBase, com.anychart.core.radar.series.Base, com.anychart.core.SeriesBase
    public View data(List<DataEntry> list) {
        return new View(String.format(Locale.US, this.jsBase + ".data(%s)", arrayToString(list)));
    }

    @Override // com.anychart.core.radar.series.ContinuousBase, com.anychart.core.radar.series.Base, com.anychart.core.SeriesBase, com.anychart.core.VisualBaseWithBounds, com.anychart.core.VisualBase
    public void enabled() {
        APIlib.getInstance().addJSLine(this.jsBase + ".enabled();");
    }

    @Override // com.anychart.core.radar.series.ContinuousBase, com.anychart.core.radar.series.Base, com.anychart.core.SeriesBase, com.anychart.core.VisualBaseWithBounds, com.anychart.core.VisualBase
    public Line enabled(Boolean bool) {
        APIlib.getInstance().addJSLine(String.format(Locale.US, this.jsBase + ".enabled(%s);", bool));
        return this;
    }

    @Override // com.anychart.core.radar.series.ContinuousBase, com.anychart.core.radar.series.Base
    public void excludePoint(Number number) {
        APIlib.getInstance().addJSLine(String.format(Locale.US, this.jsBase + ".excludePoint(%s);", number));
    }

    @Override // com.anychart.core.radar.series.ContinuousBase, com.anychart.core.radar.series.Base
    public void excludePoint(Number[] numberArr) {
        APIlib.getInstance().addJSLine(String.format(Locale.US, this.jsBase + ".excludePoint(%s);", Arrays.toString(numberArr)));
    }

    @Override // com.anychart.core.radar.series.ContinuousBase, com.anychart.core.radar.series.Base
    public void getExcludedPoints() {
        APIlib.getInstance().addJSLine(this.jsBase + ".getExcludedPoints();");
    }

    @Override // com.anychart.core.radar.series.ContinuousBase, com.anychart.core.radar.series.Base, com.anychart.core.SeriesBase, com.anychart.core.VisualBaseWithBounds
    public Rect getPixelBounds() {
        return new Rect(this.jsBase + ".getPixelBounds()");
    }

    @Override // com.anychart.core.radar.series.ContinuousBase, com.anychart.core.radar.series.Base, com.anychart.core.SeriesBase
    public SeriesPoint getPoint(Number number) {
        return new SeriesPoint(String.format(Locale.US, this.jsBase + ".getPoint(%s)", number));
    }

    @Override // com.anychart.core.radar.series.ContinuousBase, com.anychart.core.radar.series.Base, com.anychart.core.SeriesBase
    public void getStat(Statistics statistics) {
        APIlib.getInstance().addJSLine(String.format(Locale.US, this.jsBase + ".getStat(%s);", statistics != null ? statistics.getJsBase() : null));
    }

    @Override // com.anychart.core.radar.series.ContinuousBase, com.anychart.core.radar.series.Base, com.anychart.core.SeriesBase
    public void getStat(String str) {
        APIlib.getInstance().addJSLine(String.format(Locale.US, this.jsBase + ".getStat(%s);", wrapQuotes(str)));
    }

    @Override // com.anychart.core.radar.series.ContinuousBase, com.anychart.core.radar.series.Base, com.anychart.core.SeriesBase, com.anychart.core.VisualBaseWithBounds
    public void height() {
        APIlib.getInstance().addJSLine(this.jsBase + ".height();");
    }

    @Override // com.anychart.core.radar.series.ContinuousBase, com.anychart.core.radar.series.Base, com.anychart.core.SeriesBase, com.anychart.core.VisualBaseWithBounds
    public Line height(Number number) {
        APIlib.getInstance().addJSLine(String.format(Locale.US, this.jsBase + ".height(%s);", number));
        return this;
    }

    @Override // com.anychart.core.radar.series.ContinuousBase, com.anychart.core.radar.series.Base, com.anychart.core.SeriesBase, com.anychart.core.VisualBaseWithBounds
    public Line height(String str) {
        APIlib.getInstance().addJSLine(String.format(Locale.US, this.jsBase + ".height(%s);", wrapQuotes(str)));
        return this;
    }

    @Override // com.anychart.core.radar.series.ContinuousBase, com.anychart.core.radar.series.Base, com.anychart.core.SeriesBase
    public Line hover() {
        APIlib.getInstance().addJSLine(this.jsBase + ".hover();");
        return this;
    }

    @Override // com.anychart.core.radar.series.ContinuousBase, com.anychart.core.radar.series.Base, com.anychart.core.SeriesBase
    public Line hover(Number number) {
        APIlib.getInstance().addJSLine(String.format(Locale.US, this.jsBase + ".hover(%s);", number));
        return this;
    }

    @Override // com.anychart.core.radar.series.ContinuousBase, com.anychart.core.radar.series.Base, com.anychart.core.SeriesBase
    public Line hover(Number[] numberArr) {
        APIlib.getInstance().addJSLine(String.format(Locale.US, this.jsBase + ".hover(%s);", Arrays.toString(numberArr)));
        return this;
    }

    @Override // com.anychart.core.radar.series.ContinuousBase, com.anychart.core.radar.series.Base, com.anychart.core.SeriesBase
    public StateSettings hovered() {
        return new StateSettings(this.jsBase + ".hovered()");
    }

    @Override // com.anychart.core.radar.series.ContinuousBase, com.anychart.core.radar.series.Base, com.anychart.core.SeriesBase
    public Line hovered(String str) {
        APIlib.getInstance().addJSLine(String.format(Locale.US, this.jsBase + ".hovered(%s);", wrapQuotes(str)));
        return this;
    }

    @Override // com.anychart.core.radar.series.ContinuousBase, com.anychart.core.radar.series.Base, com.anychart.core.SeriesBase
    public void id() {
        APIlib.getInstance().addJSLine(this.jsBase + ".id();");
    }

    @Override // com.anychart.core.radar.series.ContinuousBase, com.anychart.core.radar.series.Base, com.anychart.core.SeriesBase
    public Line id(String str) {
        APIlib.getInstance().addJSLine(String.format(Locale.US, this.jsBase + ".id(%s);", wrapQuotes(str)));
        return this;
    }

    @Override // com.anychart.core.radar.series.ContinuousBase, com.anychart.core.radar.series.Base, com.anychart.core.SeriesBase
    public Line id(Number number) {
        APIlib.getInstance().addJSLine(String.format(Locale.US, this.jsBase + ".id(%s);", number));
        return this;
    }

    @Override // com.anychart.core.radar.series.ContinuousBase, com.anychart.core.radar.series.Base
    public void includeAllPoints() {
        APIlib.getInstance().addJSLine(this.jsBase + ".includeAllPoints();");
    }

    @Override // com.anychart.core.radar.series.ContinuousBase, com.anychart.core.radar.series.Base
    public void includePoint(Number number) {
        APIlib.getInstance().addJSLine(String.format(Locale.US, this.jsBase + ".includePoint(%s);", number));
    }

    @Override // com.anychart.core.radar.series.ContinuousBase, com.anychart.core.radar.series.Base
    public void includePoint(Number[] numberArr) {
        APIlib.getInstance().addJSLine(String.format(Locale.US, this.jsBase + ".includePoint(%s);", Arrays.toString(numberArr)));
    }

    @Override // com.anychart.core.radar.series.ContinuousBase, com.anychart.core.radar.series.Base
    public void keepOnlyPoints(Number number) {
        APIlib.getInstance().addJSLine(String.format(Locale.US, this.jsBase + ".keepOnlyPoints(%s);", number));
    }

    @Override // com.anychart.core.radar.series.ContinuousBase, com.anychart.core.radar.series.Base
    public void keepOnlyPoints(Number[] numberArr) {
        APIlib.getInstance().addJSLine(String.format(Locale.US, this.jsBase + ".keepOnlyPoints(%s);", Arrays.toString(numberArr)));
    }

    @Override // com.anychart.core.radar.series.ContinuousBase, com.anychart.core.radar.series.Base, com.anychart.core.SeriesBase
    public LabelsFactory labels() {
        return new LabelsFactory(this.jsBase + ".labels()");
    }

    @Override // com.anychart.core.radar.series.ContinuousBase, com.anychart.core.radar.series.Base, com.anychart.core.SeriesBase
    public Line labels(String str) {
        APIlib.getInstance().addJSLine(String.format(Locale.US, this.jsBase + ".labels(%s);", wrapQuotes(str)));
        return this;
    }

    @Override // com.anychart.core.radar.series.ContinuousBase, com.anychart.core.radar.series.Base, com.anychart.core.SeriesBase
    public Line labels(Boolean bool) {
        APIlib.getInstance().addJSLine(String.format(Locale.US, this.jsBase + ".labels(%s);", bool));
        return this;
    }

    @Override // com.anychart.core.radar.series.ContinuousBase, com.anychart.core.radar.series.Base, com.anychart.core.SeriesBase, com.anychart.core.VisualBaseWithBounds
    public void left() {
        APIlib.getInstance().addJSLine(this.jsBase + ".left();");
    }

    @Override // com.anychart.core.radar.series.ContinuousBase, com.anychart.core.radar.series.Base, com.anychart.core.SeriesBase, com.anychart.core.VisualBaseWithBounds
    public Line left(Number number) {
        APIlib.getInstance().addJSLine(String.format(Locale.US, this.jsBase + ".left(%s);", number));
        return this;
    }

    @Override // com.anychart.core.radar.series.ContinuousBase, com.anychart.core.radar.series.Base, com.anychart.core.SeriesBase, com.anychart.core.VisualBaseWithBounds
    public Line left(String str) {
        APIlib.getInstance().addJSLine(String.format(Locale.US, this.jsBase + ".left(%s);", wrapQuotes(str)));
        return this;
    }

    @Override // com.anychart.core.radar.series.ContinuousBase, com.anychart.core.radar.series.Base, com.anychart.core.SeriesBase
    public LegendItemSettings legendItem() {
        return new LegendItemSettings(this.jsBase + ".legendItem()");
    }

    @Override // com.anychart.core.radar.series.ContinuousBase, com.anychart.core.radar.series.Base, com.anychart.core.SeriesBase
    public Line legendItem(String str) {
        APIlib.getInstance().addJSLine(String.format(Locale.US, this.jsBase + ".legendItem(%s);", wrapQuotes(str)));
        return this;
    }

    @Override // com.anychart.core.radar.series.ContinuousBase, com.anychart.core.radar.series.Base, com.anychart.core.SeriesBase
    public MarkersFactory markers() {
        return new MarkersFactory(this.jsBase + ".markers()");
    }

    @Override // com.anychart.core.radar.series.ContinuousBase, com.anychart.core.radar.series.Base, com.anychart.core.SeriesBase
    public Line markers(String str) {
        APIlib.getInstance().addJSLine(String.format(Locale.US, this.jsBase + ".markers(%s);", wrapQuotes(str)));
        return this;
    }

    @Override // com.anychart.core.radar.series.ContinuousBase, com.anychart.core.radar.series.Base, com.anychart.core.SeriesBase
    public Line markers(Boolean bool) {
        APIlib.getInstance().addJSLine(String.format(Locale.US, this.jsBase + ".markers(%s);", bool));
        return this;
    }

    @Override // com.anychart.core.radar.series.ContinuousBase, com.anychart.core.radar.series.Base, com.anychart.core.SeriesBase, com.anychart.core.VisualBaseWithBounds
    public void maxHeight() {
        APIlib.getInstance().addJSLine(this.jsBase + ".maxHeight();");
    }

    @Override // com.anychart.core.radar.series.ContinuousBase, com.anychart.core.radar.series.Base, com.anychart.core.SeriesBase, com.anychart.core.VisualBaseWithBounds
    public Line maxHeight(Number number) {
        APIlib.getInstance().addJSLine(String.format(Locale.US, this.jsBase + ".maxHeight(%s);", number));
        return this;
    }

    @Override // com.anychart.core.radar.series.ContinuousBase, com.anychart.core.radar.series.Base, com.anychart.core.SeriesBase, com.anychart.core.VisualBaseWithBounds
    public Line maxHeight(String str) {
        APIlib.getInstance().addJSLine(String.format(Locale.US, this.jsBase + ".maxHeight(%s);", wrapQuotes(str)));
        return this;
    }

    @Override // com.anychart.core.radar.series.ContinuousBase, com.anychart.core.radar.series.Base
    public LabelsFactory maxLabels() {
        return new LabelsFactory(this.jsBase + ".maxLabels()");
    }

    @Override // com.anychart.core.radar.series.ContinuousBase, com.anychart.core.radar.series.Base
    public Line maxLabels(String str) {
        APIlib.getInstance().addJSLine(String.format(Locale.US, this.jsBase + ".maxLabels(%s);", wrapQuotes(str)));
        return this;
    }

    @Override // com.anychart.core.radar.series.ContinuousBase, com.anychart.core.radar.series.Base
    public Line maxLabels(Boolean bool) {
        APIlib.getInstance().addJSLine(String.format(Locale.US, this.jsBase + ".maxLabels(%s);", bool));
        return this;
    }

    @Override // com.anychart.core.radar.series.ContinuousBase, com.anychart.core.radar.series.Base, com.anychart.core.SeriesBase, com.anychart.core.VisualBaseWithBounds
    public void maxWidth() {
        APIlib.getInstance().addJSLine(this.jsBase + ".maxWidth();");
    }

    @Override // com.anychart.core.radar.series.ContinuousBase, com.anychart.core.radar.series.Base, com.anychart.core.SeriesBase, com.anychart.core.VisualBaseWithBounds
    public Line maxWidth(Number number) {
        APIlib.getInstance().addJSLine(String.format(Locale.US, this.jsBase + ".maxWidth(%s);", number));
        return this;
    }

    @Override // com.anychart.core.radar.series.ContinuousBase, com.anychart.core.radar.series.Base, com.anychart.core.SeriesBase, com.anychart.core.VisualBaseWithBounds
    public Line maxWidth(String str) {
        APIlib.getInstance().addJSLine(String.format(Locale.US, this.jsBase + ".maxWidth(%s);", wrapQuotes(str)));
        return this;
    }

    @Override // com.anychart.core.radar.series.ContinuousBase, com.anychart.core.radar.series.Base, com.anychart.core.SeriesBase
    public void meta(String str) {
        APIlib.getInstance().addJSLine(String.format(Locale.US, this.jsBase + ".meta(%s);", wrapQuotes(str)));
    }

    @Override // com.anychart.core.radar.series.ContinuousBase, com.anychart.core.radar.series.Base, com.anychart.core.SeriesBase
    public Line meta(String str, String str2) {
        APIlib.getInstance().addJSLine(String.format(Locale.US, this.jsBase + ".meta(%s, %s);", wrapQuotes(str), wrapQuotes(str2)));
        return this;
    }

    @Override // com.anychart.core.radar.series.ContinuousBase, com.anychart.core.radar.series.Base, com.anychart.core.SeriesBase, com.anychart.core.VisualBaseWithBounds
    public void minHeight() {
        APIlib.getInstance().addJSLine(this.jsBase + ".minHeight();");
    }

    @Override // com.anychart.core.radar.series.ContinuousBase, com.anychart.core.radar.series.Base, com.anychart.core.SeriesBase, com.anychart.core.VisualBaseWithBounds
    public Line minHeight(Number number) {
        APIlib.getInstance().addJSLine(String.format(Locale.US, this.jsBase + ".minHeight(%s);", number));
        return this;
    }

    @Override // com.anychart.core.radar.series.ContinuousBase, com.anychart.core.radar.series.Base, com.anychart.core.SeriesBase, com.anychart.core.VisualBaseWithBounds
    public Line minHeight(String str) {
        APIlib.getInstance().addJSLine(String.format(Locale.US, this.jsBase + ".minHeight(%s);", wrapQuotes(str)));
        return this;
    }

    @Override // com.anychart.core.radar.series.ContinuousBase, com.anychart.core.radar.series.Base
    public LabelsFactory minLabels() {
        return new LabelsFactory(this.jsBase + ".minLabels()");
    }

    @Override // com.anychart.core.radar.series.ContinuousBase, com.anychart.core.radar.series.Base
    public Line minLabels(String str) {
        APIlib.getInstance().addJSLine(String.format(Locale.US, this.jsBase + ".minLabels(%s);", wrapQuotes(str)));
        return this;
    }

    @Override // com.anychart.core.radar.series.ContinuousBase, com.anychart.core.radar.series.Base
    public Line minLabels(Boolean bool) {
        APIlib.getInstance().addJSLine(String.format(Locale.US, this.jsBase + ".minLabels(%s);", bool));
        return this;
    }

    @Override // com.anychart.core.radar.series.ContinuousBase, com.anychart.core.radar.series.Base, com.anychart.core.SeriesBase, com.anychart.core.VisualBaseWithBounds
    public void minWidth() {
        APIlib.getInstance().addJSLine(this.jsBase + ".minWidth();");
    }

    @Override // com.anychart.core.radar.series.ContinuousBase, com.anychart.core.radar.series.Base, com.anychart.core.SeriesBase, com.anychart.core.VisualBaseWithBounds
    public Line minWidth(Number number) {
        APIlib.getInstance().addJSLine(String.format(Locale.US, this.jsBase + ".minWidth(%s);", number));
        return this;
    }

    @Override // com.anychart.core.radar.series.ContinuousBase, com.anychart.core.radar.series.Base, com.anychart.core.SeriesBase, com.anychart.core.VisualBaseWithBounds
    public Line minWidth(String str) {
        APIlib.getInstance().addJSLine(String.format(Locale.US, this.jsBase + ".minWidth(%s);", wrapQuotes(str)));
        return this;
    }

    @Override // com.anychart.core.radar.series.ContinuousBase, com.anychart.core.radar.series.Base, com.anychart.core.SeriesBase
    public void name() {
        APIlib.getInstance().addJSLine(this.jsBase + ".name();");
    }

    @Override // com.anychart.core.radar.series.ContinuousBase, com.anychart.core.radar.series.Base, com.anychart.core.SeriesBase
    public Line name(String str) {
        APIlib.getInstance().addJSLine(String.format(Locale.US, this.jsBase + ".name(%s);", wrapQuotes(str)));
        return this;
    }

    @Override // com.anychart.core.radar.series.ContinuousBase, com.anychart.core.radar.series.Base, com.anychart.core.SeriesBase
    public StateSettings normal() {
        return new StateSettings(this.jsBase + ".normal()");
    }

    @Override // com.anychart.core.radar.series.ContinuousBase, com.anychart.core.radar.series.Base, com.anychart.core.SeriesBase
    public Line normal(String str) {
        APIlib.getInstance().addJSLine(String.format(Locale.US, this.jsBase + ".normal(%s);", wrapQuotes(str)));
        return this;
    }

    @Override // com.anychart.core.radar.series.ContinuousBase, com.anychart.core.radar.series.Base, com.anychart.core.SeriesBase, com.anychart.core.VisualBaseWithBounds, com.anychart.core.VisualBase
    public void print(PaperSize paperSize, Boolean bool) {
        APIlib.getInstance().addJSLine(String.format(Locale.US, this.jsBase + ".print(%s, %s);", paperSize != null ? paperSize.getJsBase() : null, bool));
    }

    @Override // com.anychart.core.radar.series.ContinuousBase, com.anychart.core.radar.series.Base, com.anychart.core.SeriesBase, com.anychart.core.VisualBaseWithBounds, com.anychart.core.VisualBase
    public void print(String str, Boolean bool) {
        APIlib.getInstance().addJSLine(String.format(Locale.US, this.jsBase + ".print(%s, %s);", wrapQuotes(str), bool));
    }

    @Override // com.anychart.core.radar.series.ContinuousBase, com.anychart.core.radar.series.Base, com.anychart.core.SeriesBase, com.anychart.core.VisualBaseWithBounds, com.anychart.core.VisualBase, com.anychart.core.Base
    public void removeAllListeners(String str) {
        APIlib.getInstance().addJSLine(String.format(Locale.US, this.jsBase + ".removeAllListeners(%s);", wrapQuotes(str)));
    }

    @Override // com.anychart.core.radar.series.ContinuousBase, com.anychart.core.radar.series.Base, com.anychart.core.SeriesBase, com.anychart.core.VisualBaseWithBounds
    public void right() {
        APIlib.getInstance().addJSLine(this.jsBase + ".right();");
    }

    @Override // com.anychart.core.radar.series.ContinuousBase, com.anychart.core.radar.series.Base, com.anychart.core.SeriesBase, com.anychart.core.VisualBaseWithBounds
    public Line right(Number number) {
        APIlib.getInstance().addJSLine(String.format(Locale.US, this.jsBase + ".right(%s);", number));
        return this;
    }

    @Override // com.anychart.core.radar.series.ContinuousBase, com.anychart.core.radar.series.Base, com.anychart.core.SeriesBase, com.anychart.core.VisualBaseWithBounds
    public Line right(String str) {
        APIlib.getInstance().addJSLine(String.format(Locale.US, this.jsBase + ".right(%s);", wrapQuotes(str)));
        return this;
    }

    @Override // com.anychart.core.radar.series.ContinuousBase, com.anychart.core.radar.series.Base, com.anychart.core.SeriesBase
    public Line select(Number number) {
        APIlib.getInstance().addJSLine(String.format(Locale.US, this.jsBase + ".select(%s);", number));
        return this;
    }

    @Override // com.anychart.core.radar.series.ContinuousBase, com.anychart.core.radar.series.Base, com.anychart.core.SeriesBase
    public Line select(Number[] numberArr) {
        APIlib.getInstance().addJSLine(String.format(Locale.US, this.jsBase + ".select(%s);", Arrays.toString(numberArr)));
        return this;
    }

    @Override // com.anychart.core.radar.series.ContinuousBase, com.anychart.core.radar.series.Base, com.anychart.core.SeriesBase
    public StateSettings selected() {
        return new StateSettings(this.jsBase + ".selected()");
    }

    @Override // com.anychart.core.radar.series.ContinuousBase, com.anychart.core.radar.series.Base, com.anychart.core.SeriesBase
    public Line selected(String str) {
        APIlib.getInstance().addJSLine(String.format(Locale.US, this.jsBase + ".selected(%s);", wrapQuotes(str)));
        return this;
    }

    @Override // com.anychart.core.radar.series.ContinuousBase, com.anychart.core.radar.series.Base, com.anychart.core.SeriesBase
    public void selectionMode() {
        APIlib.getInstance().addJSLine(this.jsBase + ".selectionMode();");
    }

    @Override // com.anychart.core.radar.series.ContinuousBase, com.anychart.core.radar.series.Base, com.anychart.core.SeriesBase
    public Line selectionMode(SelectionMode selectionMode) {
        APIlib.getInstance().addJSLine(String.format(Locale.US, this.jsBase + ".selectionMode(%s);", selectionMode != null ? selectionMode.getJsBase() : null));
        return this;
    }

    @Override // com.anychart.core.radar.series.ContinuousBase, com.anychart.core.radar.series.Base, com.anychart.core.SeriesBase
    public Line selectionMode(String str) {
        APIlib.getInstance().addJSLine(String.format(Locale.US, this.jsBase + ".selectionMode(%s);", wrapQuotes(str)));
        return this;
    }

    public void stroke() {
        APIlib.getInstance().addJSLine(this.jsBase + ".stroke();");
    }

    public Line stroke(Stroke stroke, Number number, String str, String str2, String str3) {
        APIlib.getInstance().addJSLine(String.format(Locale.US, this.jsBase + ".stroke(%s, %s, %s, %s, %s);", stroke != null ? stroke.getJsBase() : null, number, wrapQuotes(str), wrapQuotes(str2), wrapQuotes(str3)));
        return this;
    }

    public Line stroke(Stroke stroke, Number number, String str, String str2, StrokeLineCap strokeLineCap) {
        APIlib.getInstance().addJSLine(String.format(Locale.US, this.jsBase + ".stroke(%s, %s, %s, %s, %s);", stroke != null ? stroke.getJsBase() : null, number, wrapQuotes(str), wrapQuotes(str2), strokeLineCap != null ? strokeLineCap.getJsBase() : null));
        return this;
    }

    public Line stroke(Stroke stroke, Number number, String str, StrokeLineJoin strokeLineJoin, String str2) {
        APIlib.getInstance().addJSLine(String.format(Locale.US, this.jsBase + ".stroke(%s, %s, %s, %s, %s);", stroke != null ? stroke.getJsBase() : null, number, wrapQuotes(str), strokeLineJoin != null ? strokeLineJoin.getJsBase() : null, wrapQuotes(str2)));
        return this;
    }

    public Line stroke(Stroke stroke, Number number, String str, StrokeLineJoin strokeLineJoin, StrokeLineCap strokeLineCap) {
        APIlib.getInstance().addJSLine(String.format(Locale.US, this.jsBase + ".stroke(%s, %s, %s, %s, %s);", stroke != null ? stroke.getJsBase() : null, number, wrapQuotes(str), strokeLineJoin != null ? strokeLineJoin.getJsBase() : null, strokeLineCap != null ? strokeLineCap.getJsBase() : null));
        return this;
    }

    public Line stroke(ColoredFill coloredFill, Number number, String str, String str2, String str3) {
        APIlib.getInstance().addJSLine(String.format(Locale.US, this.jsBase + ".stroke(%s, %s, %s, %s, %s);", coloredFill != null ? coloredFill.getJsBase() : null, number, wrapQuotes(str), wrapQuotes(str2), wrapQuotes(str3)));
        return this;
    }

    public Line stroke(ColoredFill coloredFill, Number number, String str, String str2, StrokeLineCap strokeLineCap) {
        APIlib.getInstance().addJSLine(String.format(Locale.US, this.jsBase + ".stroke(%s, %s, %s, %s, %s);", coloredFill != null ? coloredFill.getJsBase() : null, number, wrapQuotes(str), wrapQuotes(str2), strokeLineCap != null ? strokeLineCap.getJsBase() : null));
        return this;
    }

    public Line stroke(ColoredFill coloredFill, Number number, String str, StrokeLineJoin strokeLineJoin, String str2) {
        APIlib.getInstance().addJSLine(String.format(Locale.US, this.jsBase + ".stroke(%s, %s, %s, %s, %s);", coloredFill != null ? coloredFill.getJsBase() : null, number, wrapQuotes(str), strokeLineJoin != null ? strokeLineJoin.getJsBase() : null, wrapQuotes(str2)));
        return this;
    }

    public Line stroke(ColoredFill coloredFill, Number number, String str, StrokeLineJoin strokeLineJoin, StrokeLineCap strokeLineCap) {
        APIlib.getInstance().addJSLine(String.format(Locale.US, this.jsBase + ".stroke(%s, %s, %s, %s, %s);", coloredFill != null ? coloredFill.getJsBase() : null, number, wrapQuotes(str), strokeLineJoin != null ? strokeLineJoin.getJsBase() : null, strokeLineCap != null ? strokeLineCap.getJsBase() : null));
        return this;
    }

    public Line stroke(String str, Number number, String str2, String str3, String str4) {
        APIlib.getInstance().addJSLine(String.format(Locale.US, this.jsBase + ".stroke(%s, %s, %s, %s, %s);", wrapQuotes(str), number, wrapQuotes(str2), wrapQuotes(str3), wrapQuotes(str4)));
        return this;
    }

    public Line stroke(String str, Number number, String str2, String str3, StrokeLineCap strokeLineCap) {
        APIlib.getInstance().addJSLine(String.format(Locale.US, this.jsBase + ".stroke(%s, %s, %s, %s, %s);", wrapQuotes(str), number, wrapQuotes(str2), wrapQuotes(str3), strokeLineCap != null ? strokeLineCap.getJsBase() : null));
        return this;
    }

    public Line stroke(String str, Number number, String str2, StrokeLineJoin strokeLineJoin, String str3) {
        APIlib.getInstance().addJSLine(String.format(Locale.US, this.jsBase + ".stroke(%s, %s, %s, %s, %s);", wrapQuotes(str), number, wrapQuotes(str2), strokeLineJoin != null ? strokeLineJoin.getJsBase() : null, wrapQuotes(str3)));
        return this;
    }

    public Line stroke(String str, Number number, String str2, StrokeLineJoin strokeLineJoin, StrokeLineCap strokeLineCap) {
        APIlib.getInstance().addJSLine(String.format(Locale.US, this.jsBase + ".stroke(%s, %s, %s, %s, %s);", wrapQuotes(str), number, wrapQuotes(str2), strokeLineJoin != null ? strokeLineJoin.getJsBase() : null, strokeLineCap != null ? strokeLineCap.getJsBase() : null));
        return this;
    }

    public Line stroke(String str) {
        APIlib.getInstance().addJSLine(String.format(Locale.US, this.jsBase + ".stroke(%s);", wrapQuotes(str)));
        return this;
    }

    @Override // com.anychart.core.radar.series.ContinuousBase, com.anychart.core.radar.series.Base, com.anychart.core.SeriesBase
    public Tooltip tooltip() {
        return new Tooltip(this.jsBase + ".tooltip()");
    }

    @Override // com.anychart.core.radar.series.ContinuousBase, com.anychart.core.radar.series.Base, com.anychart.core.SeriesBase
    public Line tooltip(String str) {
        APIlib.getInstance().addJSLine(String.format(Locale.US, this.jsBase + ".tooltip(%s);", wrapQuotes(str)));
        return this;
    }

    @Override // com.anychart.core.radar.series.ContinuousBase, com.anychart.core.radar.series.Base, com.anychart.core.SeriesBase
    public Line tooltip(Boolean bool) {
        APIlib.getInstance().addJSLine(String.format(Locale.US, this.jsBase + ".tooltip(%s);", bool));
        return this;
    }

    @Override // com.anychart.core.radar.series.ContinuousBase, com.anychart.core.radar.series.Base, com.anychart.core.SeriesBase, com.anychart.core.VisualBaseWithBounds
    public void top() {
        APIlib.getInstance().addJSLine(this.jsBase + ".top();");
    }

    @Override // com.anychart.core.radar.series.ContinuousBase, com.anychart.core.radar.series.Base, com.anychart.core.SeriesBase, com.anychart.core.VisualBaseWithBounds
    public Line top(Number number) {
        APIlib.getInstance().addJSLine(String.format(Locale.US, this.jsBase + ".top(%s);", number));
        return this;
    }

    @Override // com.anychart.core.radar.series.ContinuousBase, com.anychart.core.radar.series.Base, com.anychart.core.SeriesBase, com.anychart.core.VisualBaseWithBounds
    public Line top(String str) {
        APIlib.getInstance().addJSLine(String.format(Locale.US, this.jsBase + ".top(%s);", wrapQuotes(str)));
        return this;
    }

    @Override // com.anychart.core.radar.series.ContinuousBase, com.anychart.core.radar.series.Base
    public void transformXY(String str, String str2, Number number) {
        APIlib.getInstance().addJSLine(String.format(Locale.US, this.jsBase + ".transformXY(%s, %s, %s);", wrapQuotes(str), wrapQuotes(str2), number));
    }

    @Override // com.anychart.core.radar.series.ContinuousBase, com.anychart.core.radar.series.Base
    public Line unhover() {
        APIlib.getInstance().addJSLine(this.jsBase + ".unhover();");
        return this;
    }

    @Override // com.anychart.core.radar.series.ContinuousBase, com.anychart.core.radar.series.Base, com.anychart.core.SeriesBase, com.anychart.core.VisualBaseWithBounds, com.anychart.core.VisualBase, com.anychart.core.Base
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

    @Override // com.anychart.core.radar.series.ContinuousBase, com.anychart.core.radar.series.Base, com.anychart.core.SeriesBase, com.anychart.core.VisualBaseWithBounds, com.anychart.core.VisualBase, com.anychart.core.Base
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

    @Override // com.anychart.core.radar.series.ContinuousBase, com.anychart.core.radar.series.Base, com.anychart.core.SeriesBase, com.anychart.core.VisualBaseWithBounds, com.anychart.core.VisualBase, com.anychart.core.Base
    public void unlistenByKey(String str) {
        APIlib.getInstance().addJSLine(String.format(Locale.US, this.jsBase + ".unlistenByKey(%s);", wrapQuotes(str)));
    }

    @Override // com.anychart.core.radar.series.ContinuousBase, com.anychart.core.radar.series.Base, com.anychart.core.SeriesBase
    public Line unselect() {
        APIlib.getInstance().addJSLine(this.jsBase + ".unselect();");
        return this;
    }

    @Override // com.anychart.core.radar.series.ContinuousBase, com.anychart.core.radar.series.Base, com.anychart.core.SeriesBase
    public Line unselect(Number number) {
        APIlib.getInstance().addJSLine(String.format(Locale.US, this.jsBase + ".unselect(%s);", number));
        return this;
    }

    @Override // com.anychart.core.radar.series.ContinuousBase, com.anychart.core.radar.series.Base, com.anychart.core.SeriesBase
    public Line unselect(Number[] numberArr) {
        APIlib.getInstance().addJSLine(String.format(Locale.US, this.jsBase + ".unselect(%s);", Arrays.toString(numberArr)));
        return this;
    }

    @Override // com.anychart.core.radar.series.ContinuousBase, com.anychart.core.radar.series.Base, com.anychart.core.SeriesBase, com.anychart.core.VisualBaseWithBounds
    public void width() {
        APIlib.getInstance().addJSLine(this.jsBase + ".width();");
    }

    @Override // com.anychart.core.radar.series.ContinuousBase, com.anychart.core.radar.series.Base, com.anychart.core.SeriesBase, com.anychart.core.VisualBaseWithBounds
    public Line width(Number number) {
        APIlib.getInstance().addJSLine(String.format(Locale.US, this.jsBase + ".width(%s);", number));
        return this;
    }

    @Override // com.anychart.core.radar.series.ContinuousBase, com.anychart.core.radar.series.Base, com.anychart.core.SeriesBase, com.anychart.core.VisualBaseWithBounds
    public Line width(String str) {
        APIlib.getInstance().addJSLine(String.format(Locale.US, this.jsBase + ".width(%s);", wrapQuotes(str)));
        return this;
    }

    @Override // com.anychart.core.radar.series.ContinuousBase, com.anychart.core.radar.series.Base
    public Ordinal xScale() {
        return new Ordinal(this.jsBase + ".xScale()");
    }

    @Override // com.anychart.core.radar.series.ContinuousBase, com.anychart.core.radar.series.Base
    public Line xScale(com.anychart.scales.Base base) {
        APIlib.getInstance().addJSLine(String.format(Locale.US, this.jsBase + ".xScale(%s);", base != null ? base.getJsBase() : null));
        return this;
    }

    @Override // com.anychart.core.radar.series.ContinuousBase, com.anychart.core.radar.series.Base
    public Line xScale(String str) {
        APIlib.getInstance().addJSLine(String.format(Locale.US, this.jsBase + ".xScale(%s);", wrapQuotes(str)));
        return this;
    }

    @Override // com.anychart.core.radar.series.ContinuousBase, com.anychart.core.radar.series.Base
    public Line xScale(ScaleTypes scaleTypes) {
        APIlib.getInstance().addJSLine(String.format(Locale.US, this.jsBase + ".xScale(%s);", scaleTypes != null ? scaleTypes.getJsBase() : null));
        return this;
    }

    @Override // com.anychart.core.radar.series.ContinuousBase, com.anychart.core.radar.series.Base
    public com.anychart.scales.Base yScale() {
        return new com.anychart.scales.Base(this.jsBase + ".yScale()");
    }

    @Override // com.anychart.core.radar.series.ContinuousBase, com.anychart.core.radar.series.Base
    public Line yScale(com.anychart.scales.Base base) {
        APIlib.getInstance().addJSLine(String.format(Locale.US, this.jsBase + ".yScale(%s);", base != null ? base.getJsBase() : null));
        return this;
    }

    @Override // com.anychart.core.radar.series.ContinuousBase, com.anychart.core.radar.series.Base
    public Line yScale(String str) {
        APIlib.getInstance().addJSLine(String.format(Locale.US, this.jsBase + ".yScale(%s);", wrapQuotes(str)));
        return this;
    }

    @Override // com.anychart.core.radar.series.ContinuousBase, com.anychart.core.radar.series.Base
    public Line yScale(ScaleTypes scaleTypes) {
        APIlib.getInstance().addJSLine(String.format(Locale.US, this.jsBase + ".yScale(%s);", scaleTypes != null ? scaleTypes.getJsBase() : null));
        return this;
    }

    @Override // com.anychart.core.radar.series.ContinuousBase, com.anychart.core.radar.series.Base, com.anychart.core.SeriesBase, com.anychart.core.VisualBaseWithBounds, com.anychart.core.VisualBase
    public void zIndex() {
        APIlib.getInstance().addJSLine(this.jsBase + ".zIndex();");
    }

    @Override // com.anychart.core.radar.series.ContinuousBase, com.anychart.core.radar.series.Base, com.anychart.core.SeriesBase, com.anychart.core.VisualBaseWithBounds, com.anychart.core.VisualBase
    public Line zIndex(Number number) {
        APIlib.getInstance().addJSLine(String.format(Locale.US, this.jsBase + ".zIndex(%s);", number));
        return this;
    }

    @Override // com.anychart.core.radar.series.ContinuousBase, com.anychart.core.radar.series.Base, com.anychart.core.SeriesBase, com.anychart.core.VisualBaseWithBounds, com.anychart.core.VisualBase
    public Layer container() {
        return new Layer(this.jsBase + ".container()");
    }

    @Override // com.anychart.core.radar.series.ContinuousBase, com.anychart.core.radar.series.Base, com.anychart.core.SeriesBase, com.anychart.core.VisualBaseWithBounds, com.anychart.core.VisualBase
    public Line container(Layer layer) {
        APIlib.getInstance().addJSLine(String.format(Locale.US, this.jsBase + ".container(%s);", layer != null ? layer.getJsBase() : null));
        return this;
    }

    @Override // com.anychart.core.radar.series.ContinuousBase, com.anychart.core.radar.series.Base, com.anychart.core.SeriesBase, com.anychart.core.VisualBaseWithBounds, com.anychart.core.VisualBase
    public Line container(Stage stage) {
        APIlib.getInstance().addJSLine(String.format(Locale.US, this.jsBase + ".container(%s);", stage != null ? stage.getJsBase() : null));
        return this;
    }

    @Override // com.anychart.core.radar.series.ContinuousBase, com.anychart.core.radar.series.Base, com.anychart.core.SeriesBase, com.anychart.core.VisualBaseWithBounds, com.anychart.core.VisualBase
    public Line container(String str) {
        APIlib.getInstance().addJSLine(String.format(Locale.US, this.jsBase + ".container(%s);", wrapQuotes(str)));
        return this;
    }

    @Override // com.anychart.core.radar.series.ContinuousBase, com.anychart.core.radar.series.Base, com.anychart.core.SeriesBase, com.anychart.core.VisualBaseWithBounds, com.anychart.core.VisualBase
    public Rect parentBounds() {
        return new Rect(this.jsBase + ".parentBounds()");
    }

    @Override // com.anychart.core.radar.series.ContinuousBase, com.anychart.core.radar.series.Base, com.anychart.core.SeriesBase, com.anychart.core.VisualBaseWithBounds, com.anychart.core.VisualBase
    public Line parentBounds(Rect rect) {
        APIlib.getInstance().addJSLine(String.format(Locale.US, this.jsBase + ".parentBounds(%s);", rect != null ? rect.getJsBase() : null));
        return this;
    }

    @Override // com.anychart.core.radar.series.ContinuousBase, com.anychart.core.radar.series.Base, com.anychart.core.SeriesBase, com.anychart.core.VisualBaseWithBounds, com.anychart.core.VisualBase
    public Line parentBounds(String str) {
        APIlib.getInstance().addJSLine(String.format(Locale.US, this.jsBase + ".parentBounds(%s);", wrapQuotes(str)));
        return this;
    }

    @Override // com.anychart.core.radar.series.ContinuousBase, com.anychart.core.radar.series.Base, com.anychart.core.SeriesBase, com.anychart.core.VisualBaseWithBounds, com.anychart.core.VisualBase
    public Line parentBounds(Number number) {
        APIlib.getInstance().addJSLine(String.format(Locale.US, this.jsBase + ".parentBounds(%s);", number));
        return this;
    }

    @Override // com.anychart.core.radar.series.ContinuousBase, com.anychart.core.radar.series.Base, com.anychart.core.SeriesBase, com.anychart.core.VisualBaseWithBounds, com.anychart.core.VisualBase
    public Line parentBounds(Number number, Number number2, Number number3, Number number4) {
        APIlib.getInstance().addJSLine(String.format(Locale.US, this.jsBase + ".parentBounds(%s, %s, %s, %s);", number, number2, number3, number4));
        return this;
    }

    @Override // com.anychart.core.radar.series.ContinuousBase, com.anychart.core.radar.series.Base, com.anychart.core.SeriesBase
    public View data(View view) {
        return new View(String.format(Locale.US, this.jsBase + ".data(%s)", view != null ? view.getJsBase() : null));
    }

    @Override // com.anychart.core.radar.series.ContinuousBase, com.anychart.core.radar.series.Base, com.anychart.core.SeriesBase
    public View data(List<DataEntry> list, TreeFillingMethod treeFillingMethod) {
        return new View(String.format(Locale.US, this.jsBase + ".data(%s, %s)", arrayToString(list), treeFillingMethod != null ? treeFillingMethod.getJsBase() : null));
    }

    @Override // com.anychart.core.radar.series.ContinuousBase, com.anychart.core.radar.series.Base, com.anychart.core.SeriesBase
    public View data(List<DataEntry> list, String str) {
        return new View(String.format(Locale.US, this.jsBase + ".data(%s, %s)", arrayToString(list), wrapQuotes(str)));
    }

    @Override // com.anychart.core.radar.series.ContinuousBase, com.anychart.core.radar.series.Base
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

    @Override // com.anychart.core.radar.series.ContinuousBase, com.anychart.core.radar.series.Base
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
