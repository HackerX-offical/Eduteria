package com.anychart.charts;

import com.amazonaws.services.s3.model.InstructionFileId;
import com.anychart.APIlib;
import com.anychart.chart.common.dataentry.DataEntry;
import com.anychart.chart.common.listener.ListenersInterface;
import com.anychart.core.NoDataSettings;
import com.anychart.core.SeparateChart;
import com.anychart.core.StateSettings;
import com.anychart.core.annotations.PlotController;
import com.anychart.core.axes.Linear;
import com.anychart.core.axismarkers.Range;
import com.anychart.core.axismarkers.Text;
import com.anychart.core.cartesian.series.Area;
import com.anychart.core.cartesian.series.Bar;
import com.anychart.core.cartesian.series.Base;
import com.anychart.core.cartesian.series.Box;
import com.anychart.core.cartesian.series.Bubble;
import com.anychart.core.cartesian.series.Candlestick;
import com.anychart.core.cartesian.series.Column;
import com.anychart.core.cartesian.series.Hilo;
import com.anychart.core.cartesian.series.JumpLine;
import com.anychart.core.cartesian.series.Line;
import com.anychart.core.cartesian.series.Marker;
import com.anychart.core.cartesian.series.OHLC;
import com.anychart.core.cartesian.series.RangeArea;
import com.anychart.core.cartesian.series.RangeBar;
import com.anychart.core.cartesian.series.RangeColumn;
import com.anychart.core.cartesian.series.RangeSplineArea;
import com.anychart.core.cartesian.series.RangeStepArea;
import com.anychart.core.cartesian.series.Spline;
import com.anychart.core.cartesian.series.SplineArea;
import com.anychart.core.cartesian.series.StepArea;
import com.anychart.core.cartesian.series.StepLine;
import com.anychart.core.cartesian.series.Stick;
import com.anychart.core.ui.Background;
import com.anychart.core.ui.ChartCredits;
import com.anychart.core.ui.ChartScroller;
import com.anychart.core.ui.Crosshair;
import com.anychart.core.ui.DataArea;
import com.anychart.core.ui.Label;
import com.anychart.core.ui.LabelsFactory;
import com.anychart.core.ui.Legend;
import com.anychart.core.ui.Title;
import com.anychart.core.ui.Tooltip;
import com.anychart.core.utils.Animation;
import com.anychart.core.utils.Bounds;
import com.anychart.core.utils.ChartA11y;
import com.anychart.core.utils.Exports;
import com.anychart.core.utils.Interactivity;
import com.anychart.core.utils.Margin;
import com.anychart.core.utils.OrdinalZoom;
import com.anychart.core.utils.Padding;
import com.anychart.data.Set;
import com.anychart.data.TextParsingSettings;
import com.anychart.data.View;
import com.anychart.enums.CartesianSeriesType;
import com.anychart.enums.ChartDataExportMode;
import com.anychart.enums.HoverMode;
import com.anychart.enums.MarkerType;
import com.anychart.enums.ScaleTypes;
import com.anychart.enums.Statistics;
import com.anychart.enums.TextParsingMode;
import com.anychart.enums.TreeFillingMethod;
import com.anychart.graphics.vector.ColoredFill;
import com.anychart.graphics.vector.Fill;
import com.anychart.graphics.vector.GradientKey;
import com.anychart.graphics.vector.Layer;
import com.anychart.graphics.vector.PaperSize;
import com.anychart.graphics.vector.Stage;
import com.anychart.graphics.vector.Stroke;
import com.anychart.graphics.vector.StrokeLineCap;
import com.anychart.graphics.vector.StrokeLineJoin;
import com.anychart.graphics.vector.hatchfill.HatchFillType;
import com.anychart.math.Rect;
import com.anychart.palettes.DistinctColors;
import com.anychart.palettes.HatchFills;
import com.anychart.palettes.Markers;
import com.anychart.palettes.RangeColors;
import com.anychart.ui.ContextMenu;
import com.anychart.utils.RectObj;
import java.lang.reflect.InvocationTargetException;
import java.util.Arrays;
import java.util.List;
import java.util.Locale;

/* JADX INFO: loaded from: classes4.dex */
public class Cartesian extends SeparateChart {
    protected Cartesian() {
    }

    public static Cartesian instantiate() {
        return new Cartesian("new anychart.charts.cartesian()");
    }

    public Cartesian(String str) {
        StringBuilder sb = new StringBuilder("cartesian");
        int i = variableIndex + 1;
        variableIndex = i;
        this.jsBase = sb.append(i).toString();
        APIlib.getInstance().addJSLine(this.jsBase + " = " + str + ";");
    }

    @Override // com.anychart.core.SeparateChart, com.anychart.core.Chart, com.anychart.core.VisualBaseWithBounds, com.anychart.core.VisualBase, com.anychart.core.Base, com.anychart.JsObject
    public String getJsBase() {
        return this.jsBase;
    }

    @Override // com.anychart.core.SeparateChart, com.anychart.core.Chart
    public ChartA11y a11y() {
        return new ChartA11y(this.jsBase + ".a11y()");
    }

    @Override // com.anychart.core.SeparateChart, com.anychart.core.Chart
    public Cartesian a11y(Boolean bool) {
        APIlib.getInstance().addJSLine(String.format(Locale.US, this.jsBase + ".a11y(%s);", bool));
        return this;
    }

    @Override // com.anychart.core.SeparateChart, com.anychart.core.Chart
    public Cartesian a11y(String str) {
        APIlib.getInstance().addJSLine(String.format(Locale.US, this.jsBase + ".a11y(%s);", wrapQuotes(str)));
        return this;
    }

    public void addSeries(View view) {
        APIlib.getInstance().addJSLine(String.format(Locale.US, this.jsBase + ".addSeries(%s);", view != null ? view.getJsBase() : null));
    }

    public void addSeries(Set set) {
        APIlib.getInstance().addJSLine(String.format(Locale.US, this.jsBase + ".addSeries(%s);", set != null ? set.getJsBase() : null));
    }

    public void addSeries(String[] strArr) {
        APIlib.getInstance().addJSLine(String.format(Locale.US, this.jsBase + ".addSeries(%s);", arrayToStringWrapQuotes(strArr)));
    }

    @Override // com.anychart.core.SeparateChart, com.anychart.core.Chart
    public Animation animation() {
        return new Animation(this.jsBase + ".animation()");
    }

    @Override // com.anychart.core.SeparateChart, com.anychart.core.Chart
    public Cartesian animation(Boolean bool) {
        APIlib.getInstance().addJSLine(String.format(Locale.US, this.jsBase + ".animation(%s);", bool));
        return this;
    }

    @Override // com.anychart.core.SeparateChart, com.anychart.core.Chart
    public Cartesian animation(String str) {
        APIlib.getInstance().addJSLine(String.format(Locale.US, this.jsBase + ".animation(%s);", wrapQuotes(str)));
        return this;
    }

    @Override // com.anychart.core.SeparateChart, com.anychart.core.Chart
    public Cartesian animation(Boolean bool, Number number) {
        APIlib.getInstance().addJSLine(String.format(Locale.US, this.jsBase + ".animation(%s, %s);", bool, number));
        return this;
    }

    public PlotController annotations() {
        return new PlotController(this.jsBase + ".annotations()");
    }

    public Cartesian annotations(String[] strArr) {
        APIlib.getInstance().addJSLine(String.format(Locale.US, this.jsBase + ".annotations(%s);", arrayToStringWrapQuotes(strArr)));
        return this;
    }

    public Area area(List<DataEntry> list) {
        return new Area(String.format(Locale.US, this.jsBase + ".area(%s)", arrayToString(list)));
    }

    @Override // com.anychart.core.SeparateChart, com.anychart.core.Chart
    public void autoRedraw() {
        APIlib.getInstance().addJSLine(this.jsBase + ".autoRedraw();");
    }

    @Override // com.anychart.core.SeparateChart, com.anychart.core.Chart
    public Cartesian autoRedraw(Boolean bool) {
        APIlib.getInstance().addJSLine(String.format(Locale.US, this.jsBase + ".autoRedraw(%s);", bool));
        return this;
    }

    @Override // com.anychart.core.SeparateChart, com.anychart.core.Chart
    public Background background() {
        return new Background(this.jsBase + ".background()");
    }

    @Override // com.anychart.core.SeparateChart, com.anychart.core.Chart
    public Cartesian background(String str) {
        APIlib.getInstance().addJSLine(String.format(Locale.US, this.jsBase + ".background(%s);", wrapQuotes(str)));
        return this;
    }

    public Cartesian background(Boolean bool) {
        APIlib.getInstance().addJSLine(String.format(Locale.US, this.jsBase + ".background(%s);", bool));
        return this;
    }

    public Bar bar(List<DataEntry> list) {
        return new Bar(String.format(Locale.US, this.jsBase + ".bar(%s)", arrayToString(list)));
    }

    public void barGroupsPadding() {
        APIlib.getInstance().addJSLine(this.jsBase + ".barGroupsPadding();");
    }

    public Cartesian barGroupsPadding(Number number) {
        APIlib.getInstance().addJSLine(String.format(Locale.US, this.jsBase + ".barGroupsPadding(%s);", number));
        return this;
    }

    public void barsPadding() {
        APIlib.getInstance().addJSLine(this.jsBase + ".barsPadding();");
    }

    public Cartesian barsPadding(Number number) {
        APIlib.getInstance().addJSLine(String.format(Locale.US, this.jsBase + ".barsPadding(%s);", number));
        return this;
    }

    public void baseline() {
        APIlib.getInstance().addJSLine(this.jsBase + ".baseline();");
    }

    public Cartesian baseline(Number number) {
        APIlib.getInstance().addJSLine(String.format(Locale.US, this.jsBase + ".baseline(%s);", number));
        return this;
    }

    @Override // com.anychart.core.SeparateChart, com.anychart.core.Chart, com.anychart.core.VisualBaseWithBounds
    public void bottom() {
        APIlib.getInstance().addJSLine(this.jsBase + ".bottom();");
    }

    @Override // com.anychart.core.SeparateChart, com.anychart.core.Chart, com.anychart.core.VisualBaseWithBounds
    public Cartesian bottom(Number number) {
        APIlib.getInstance().addJSLine(String.format(Locale.US, this.jsBase + ".bottom(%s);", number));
        return this;
    }

    @Override // com.anychart.core.SeparateChart, com.anychart.core.Chart, com.anychart.core.VisualBaseWithBounds
    public Cartesian bottom(String str) {
        APIlib.getInstance().addJSLine(String.format(Locale.US, this.jsBase + ".bottom(%s);", wrapQuotes(str)));
        return this;
    }

    @Override // com.anychart.core.SeparateChart, com.anychart.core.Chart, com.anychart.core.VisualBaseWithBounds
    public Bounds bounds() {
        return new Bounds(this.jsBase + ".bounds()");
    }

    @Override // com.anychart.core.SeparateChart, com.anychart.core.Chart, com.anychart.core.VisualBaseWithBounds
    public Cartesian bounds(RectObj rectObj) {
        APIlib.getInstance().addJSLine(String.format(Locale.US, this.jsBase + ".bounds(%s);", rectObj != null ? rectObj.getJsBase() : null));
        return this;
    }

    @Override // com.anychart.core.SeparateChart, com.anychart.core.Chart, com.anychart.core.VisualBaseWithBounds
    public Cartesian bounds(Rect rect) {
        APIlib.getInstance().addJSLine(String.format(Locale.US, this.jsBase + ".bounds(%s);", rect != null ? rect.getJsBase() : null));
        return this;
    }

    @Override // com.anychart.core.SeparateChart, com.anychart.core.Chart, com.anychart.core.VisualBaseWithBounds
    public Cartesian bounds(Bounds bounds) {
        APIlib.getInstance().addJSLine(String.format(Locale.US, this.jsBase + ".bounds(%s);", bounds != null ? bounds.getJsBase() : null));
        return this;
    }

    @Override // com.anychart.core.SeparateChart, com.anychart.core.Chart, com.anychart.core.VisualBaseWithBounds
    public Cartesian bounds(Number number, Number number2, Number number3, Number number4) {
        APIlib.getInstance().addJSLine(String.format(Locale.US, this.jsBase + ".bounds(%s, %s, %s, %s);", number, number2, number3, number4));
        return this;
    }

    @Override // com.anychart.core.SeparateChart, com.anychart.core.Chart, com.anychart.core.VisualBaseWithBounds
    public Cartesian bounds(Number number, Number number2, Number number3, String str) {
        APIlib.getInstance().addJSLine(String.format(Locale.US, this.jsBase + ".bounds(%s, %s, %s, %s);", number, number2, number3, wrapQuotes(str)));
        return this;
    }

    @Override // com.anychart.core.SeparateChart, com.anychart.core.Chart, com.anychart.core.VisualBaseWithBounds
    public Cartesian bounds(Number number, Number number2, String str, Number number3) {
        APIlib.getInstance().addJSLine(String.format(Locale.US, this.jsBase + ".bounds(%s, %s, %s, %s);", number, number2, wrapQuotes(str), number3));
        return this;
    }

    @Override // com.anychart.core.SeparateChart, com.anychart.core.Chart, com.anychart.core.VisualBaseWithBounds
    public Cartesian bounds(Number number, Number number2, String str, String str2) {
        APIlib.getInstance().addJSLine(String.format(Locale.US, this.jsBase + ".bounds(%s, %s, %s, %s);", number, number2, wrapQuotes(str), wrapQuotes(str2)));
        return this;
    }

    @Override // com.anychart.core.SeparateChart, com.anychart.core.Chart, com.anychart.core.VisualBaseWithBounds
    public Cartesian bounds(Number number, String str, Number number2, Number number3) {
        APIlib.getInstance().addJSLine(String.format(Locale.US, this.jsBase + ".bounds(%s, %s, %s, %s);", number, wrapQuotes(str), number2, number3));
        return this;
    }

    @Override // com.anychart.core.SeparateChart, com.anychart.core.Chart, com.anychart.core.VisualBaseWithBounds
    public Cartesian bounds(Number number, String str, Number number2, String str2) {
        APIlib.getInstance().addJSLine(String.format(Locale.US, this.jsBase + ".bounds(%s, %s, %s, %s);", number, wrapQuotes(str), number2, wrapQuotes(str2)));
        return this;
    }

    @Override // com.anychart.core.SeparateChart, com.anychart.core.Chart, com.anychart.core.VisualBaseWithBounds
    public Cartesian bounds(Number number, String str, String str2, Number number2) {
        APIlib.getInstance().addJSLine(String.format(Locale.US, this.jsBase + ".bounds(%s, %s, %s, %s);", number, wrapQuotes(str), wrapQuotes(str2), number2));
        return this;
    }

    @Override // com.anychart.core.SeparateChart, com.anychart.core.Chart, com.anychart.core.VisualBaseWithBounds
    public Cartesian bounds(Number number, String str, String str2, String str3) {
        APIlib.getInstance().addJSLine(String.format(Locale.US, this.jsBase + ".bounds(%s, %s, %s, %s);", number, wrapQuotes(str), wrapQuotes(str2), wrapQuotes(str3)));
        return this;
    }

    @Override // com.anychart.core.SeparateChart, com.anychart.core.Chart, com.anychart.core.VisualBaseWithBounds
    public Cartesian bounds(String str, Number number, Number number2, Number number3) {
        APIlib.getInstance().addJSLine(String.format(Locale.US, this.jsBase + ".bounds(%s, %s, %s, %s);", wrapQuotes(str), number, number2, number3));
        return this;
    }

    @Override // com.anychart.core.SeparateChart, com.anychart.core.Chart, com.anychart.core.VisualBaseWithBounds
    public Cartesian bounds(String str, Number number, Number number2, String str2) {
        APIlib.getInstance().addJSLine(String.format(Locale.US, this.jsBase + ".bounds(%s, %s, %s, %s);", wrapQuotes(str), number, number2, wrapQuotes(str2)));
        return this;
    }

    @Override // com.anychart.core.SeparateChart, com.anychart.core.Chart, com.anychart.core.VisualBaseWithBounds
    public Cartesian bounds(String str, Number number, String str2, Number number2) {
        APIlib.getInstance().addJSLine(String.format(Locale.US, this.jsBase + ".bounds(%s, %s, %s, %s);", wrapQuotes(str), number, wrapQuotes(str2), number2));
        return this;
    }

    @Override // com.anychart.core.SeparateChart, com.anychart.core.Chart, com.anychart.core.VisualBaseWithBounds
    public Cartesian bounds(String str, Number number, String str2, String str3) {
        APIlib.getInstance().addJSLine(String.format(Locale.US, this.jsBase + ".bounds(%s, %s, %s, %s);", wrapQuotes(str), number, wrapQuotes(str2), wrapQuotes(str3)));
        return this;
    }

    @Override // com.anychart.core.SeparateChart, com.anychart.core.Chart, com.anychart.core.VisualBaseWithBounds
    public Cartesian bounds(String str, String str2, Number number, Number number2) {
        APIlib.getInstance().addJSLine(String.format(Locale.US, this.jsBase + ".bounds(%s, %s, %s, %s);", wrapQuotes(str), wrapQuotes(str2), number, number2));
        return this;
    }

    @Override // com.anychart.core.SeparateChart, com.anychart.core.Chart, com.anychart.core.VisualBaseWithBounds
    public Cartesian bounds(String str, String str2, Number number, String str3) {
        APIlib.getInstance().addJSLine(String.format(Locale.US, this.jsBase + ".bounds(%s, %s, %s, %s);", wrapQuotes(str), wrapQuotes(str2), number, wrapQuotes(str3)));
        return this;
    }

    @Override // com.anychart.core.SeparateChart, com.anychart.core.Chart, com.anychart.core.VisualBaseWithBounds
    public Cartesian bounds(String str, String str2, String str3, Number number) {
        APIlib.getInstance().addJSLine(String.format(Locale.US, this.jsBase + ".bounds(%s, %s, %s, %s);", wrapQuotes(str), wrapQuotes(str2), wrapQuotes(str3), number));
        return this;
    }

    @Override // com.anychart.core.SeparateChart, com.anychart.core.Chart, com.anychart.core.VisualBaseWithBounds
    public Cartesian bounds(String str, String str2, String str3, String str4) {
        APIlib.getInstance().addJSLine(String.format(Locale.US, this.jsBase + ".bounds(%s, %s, %s, %s);", wrapQuotes(str), wrapQuotes(str2), wrapQuotes(str3), wrapQuotes(str4)));
        return this;
    }

    public Box box(List<DataEntry> list) {
        return new Box(String.format(Locale.US, this.jsBase + ".box(%s)", arrayToString(list)));
    }

    public Bubble bubble(List<DataEntry> list) {
        return new Bubble(String.format(Locale.US, this.jsBase + ".bubble(%s)", arrayToString(list)));
    }

    @Override // com.anychart.core.SeparateChart, com.anychart.core.Chart
    public Cartesian cancelMarquee() {
        APIlib.getInstance().addJSLine(this.jsBase + ".cancelMarquee();");
        return this;
    }

    public Candlestick candlestick(View view, TextParsingMode textParsingMode) {
        return new Candlestick(String.format(Locale.US, this.jsBase + ".candlestick(%s, %s)", view != null ? view.getJsBase() : null, textParsingMode != null ? textParsingMode.getJsBase() : null));
    }

    public Candlestick candlestick(View view, String str) {
        return new Candlestick(String.format(Locale.US, this.jsBase + ".candlestick(%s, %s)", view != null ? view.getJsBase() : null, wrapQuotes(str)));
    }

    public Candlestick candlestick(View view, TextParsingSettings textParsingSettings) {
        return new Candlestick(String.format(Locale.US, this.jsBase + ".candlestick(%s, %s)", view != null ? view.getJsBase() : null, textParsingSettings != null ? textParsingSettings.getJsBase() : null));
    }

    public Candlestick candlestick(Set set, TextParsingMode textParsingMode) {
        return new Candlestick(String.format(Locale.US, this.jsBase + ".candlestick(%s, %s)", set != null ? set.getJsBase() : null, textParsingMode != null ? textParsingMode.getJsBase() : null));
    }

    public Candlestick candlestick(Set set, String str) {
        return new Candlestick(String.format(Locale.US, this.jsBase + ".candlestick(%s, %s)", set != null ? set.getJsBase() : null, wrapQuotes(str)));
    }

    public Candlestick candlestick(Set set, TextParsingSettings textParsingSettings) {
        return new Candlestick(String.format(Locale.US, this.jsBase + ".candlestick(%s, %s)", set != null ? set.getJsBase() : null, textParsingSettings != null ? textParsingSettings.getJsBase() : null));
    }

    public Candlestick candlestick(String[] strArr, TextParsingMode textParsingMode) {
        return new Candlestick(String.format(Locale.US, this.jsBase + ".candlestick(%s, %s)", arrayToStringWrapQuotes(strArr), textParsingMode != null ? textParsingMode.getJsBase() : null));
    }

    public Candlestick candlestick(String[] strArr, String str) {
        return new Candlestick(String.format(Locale.US, this.jsBase + ".candlestick(%s, %s)", arrayToStringWrapQuotes(strArr), wrapQuotes(str)));
    }

    public Candlestick candlestick(String[] strArr, TextParsingSettings textParsingSettings) {
        return new Candlestick(String.format(Locale.US, this.jsBase + ".candlestick(%s, %s)", arrayToStringWrapQuotes(strArr), textParsingSettings != null ? textParsingSettings.getJsBase() : null));
    }

    public Candlestick candlestick(String str, TextParsingMode textParsingMode) {
        return new Candlestick(String.format(Locale.US, this.jsBase + ".candlestick(%s, %s)", wrapQuotes(str), textParsingMode != null ? textParsingMode.getJsBase() : null));
    }

    public Candlestick candlestick(String str, String str2) {
        return new Candlestick(String.format(Locale.US, this.jsBase + ".candlestick(%s, %s)", wrapQuotes(str), wrapQuotes(str2)));
    }

    public Candlestick candlestick(String str, TextParsingSettings textParsingSettings) {
        return new Candlestick(String.format(Locale.US, this.jsBase + ".candlestick(%s, %s)", wrapQuotes(str), textParsingSettings != null ? textParsingSettings.getJsBase() : null));
    }

    public Column column(List<DataEntry> list) {
        return new Column(String.format(Locale.US, this.jsBase + ".column(%s)", arrayToString(list)));
    }

    @Override // com.anychart.core.SeparateChart, com.anychart.core.Chart, com.anychart.core.VisualBaseWithBounds, com.anychart.core.VisualBase
    public Layer container() {
        return new Layer(this.jsBase + ".container()");
    }

    @Override // com.anychart.core.SeparateChart, com.anychart.core.Chart, com.anychart.core.VisualBaseWithBounds, com.anychart.core.VisualBase
    public Cartesian container(Layer layer) {
        APIlib.getInstance().addJSLine(String.format(Locale.US, this.jsBase + ".container(%s);", layer != null ? layer.getJsBase() : null));
        return this;
    }

    @Override // com.anychart.core.SeparateChart, com.anychart.core.Chart, com.anychart.core.VisualBaseWithBounds, com.anychart.core.VisualBase
    public Cartesian container(Stage stage) {
        APIlib.getInstance().addJSLine(String.format(Locale.US, this.jsBase + ".container(%s);", stage != null ? stage.getJsBase() : null));
        return this;
    }

    @Override // com.anychart.core.SeparateChart, com.anychart.core.Chart, com.anychart.core.VisualBaseWithBounds, com.anychart.core.VisualBase
    public Cartesian container(String str) {
        APIlib.getInstance().addJSLine(String.format(Locale.US, this.jsBase + ".container(%s);", wrapQuotes(str)));
        return this;
    }

    @Override // com.anychart.core.SeparateChart, com.anychart.core.Chart
    public ContextMenu contextMenu() {
        return new ContextMenu(this.jsBase + ".contextMenu()");
    }

    @Override // com.anychart.core.SeparateChart, com.anychart.core.Chart
    public Cartesian contextMenu(String str) {
        APIlib.getInstance().addJSLine(String.format(Locale.US, this.jsBase + ".contextMenu(%s);", wrapQuotes(str)));
        return this;
    }

    @Override // com.anychart.core.SeparateChart, com.anychart.core.Chart
    public Cartesian contextMenu(Boolean bool) {
        APIlib.getInstance().addJSLine(String.format(Locale.US, this.jsBase + ".contextMenu(%s);", bool));
        return this;
    }

    @Override // com.anychart.core.SeparateChart, com.anychart.core.Chart
    public ChartCredits credits() {
        return new ChartCredits(this.jsBase + ".credits()");
    }

    @Override // com.anychart.core.SeparateChart, com.anychart.core.Chart
    public Cartesian credits(String str) {
        APIlib.getInstance().addJSLine(String.format(Locale.US, this.jsBase + ".credits(%s);", wrapQuotes(str)));
        return this;
    }

    @Override // com.anychart.core.SeparateChart, com.anychart.core.Chart
    public Cartesian credits(Boolean bool) {
        APIlib.getInstance().addJSLine(String.format(Locale.US, this.jsBase + ".credits(%s);", bool));
        return this;
    }

    public Crosshair crosshair() {
        return new Crosshair(this.jsBase + ".crosshair()");
    }

    public Cartesian crosshair(String str) {
        APIlib.getInstance().addJSLine(String.format(Locale.US, this.jsBase + ".crosshair(%s);", wrapQuotes(str)));
        return this;
    }

    public Cartesian crosshair(Boolean bool) {
        APIlib.getInstance().addJSLine(String.format(Locale.US, this.jsBase + ".crosshair(%s);", bool));
        return this;
    }

    public View data(List<DataEntry> list) {
        return new View(String.format(Locale.US, this.jsBase + ".data(%s)", arrayToString(list)));
    }

    public DataArea dataArea() {
        return new DataArea(this.jsBase + ".dataArea()");
    }

    public Cartesian dataArea(String str) {
        APIlib.getInstance().addJSLine(String.format(Locale.US, this.jsBase + ".dataArea(%s);", wrapQuotes(str)));
        return this;
    }

    public Cartesian dataArea(Boolean bool) {
        APIlib.getInstance().addJSLine(String.format(Locale.US, this.jsBase + ".dataArea(%s);", bool));
        return this;
    }

    public void defaultSeriesType() {
        APIlib.getInstance().addJSLine(this.jsBase + ".defaultSeriesType();");
    }

    public Cartesian defaultSeriesType(CartesianSeriesType cartesianSeriesType) {
        APIlib.getInstance().addJSLine(String.format(Locale.US, this.jsBase + ".defaultSeriesType(%s);", cartesianSeriesType != null ? cartesianSeriesType.getJsBase() : null));
        return this;
    }

    public Cartesian defaultSeriesType(String str) {
        APIlib.getInstance().addJSLine(String.format(Locale.US, this.jsBase + ".defaultSeriesType(%s);", wrapQuotes(str)));
        return this;
    }

    @Override // com.anychart.core.SeparateChart, com.anychart.core.Chart
    public void dispose() {
        APIlib.getInstance().addJSLine(this.jsBase + ".dispose();");
    }

    @Override // com.anychart.core.SeparateChart, com.anychart.core.Chart
    public Cartesian draw(Boolean bool) {
        APIlib.getInstance().addJSLine(String.format(Locale.US, this.jsBase + ".draw(%s);", bool));
        return this;
    }

    @Override // com.anychart.core.SeparateChart, com.anychart.core.Chart, com.anychart.core.VisualBaseWithBounds, com.anychart.core.VisualBase
    public void enabled() {
        APIlib.getInstance().addJSLine(this.jsBase + ".enabled();");
    }

    @Override // com.anychart.core.SeparateChart, com.anychart.core.Chart, com.anychart.core.VisualBaseWithBounds, com.anychart.core.VisualBase
    public Cartesian enabled(Boolean bool) {
        APIlib.getInstance().addJSLine(String.format(Locale.US, this.jsBase + ".enabled(%s);", bool));
        return this;
    }

    @Override // com.anychart.core.SeparateChart, com.anychart.core.Chart
    public Exports exports() {
        return new Exports(this.jsBase + ".exports()");
    }

    @Override // com.anychart.core.SeparateChart, com.anychart.core.Chart
    public Cartesian exports(String str) {
        APIlib.getInstance().addJSLine(String.format(Locale.US, this.jsBase + ".exports(%s);", wrapQuotes(str)));
        return this;
    }

    @Override // com.anychart.core.SeparateChart, com.anychart.core.Chart
    public void fullScreen() {
        APIlib.getInstance().addJSLine(this.jsBase + ".fullScreen();");
    }

    @Override // com.anychart.core.SeparateChart, com.anychart.core.Chart
    public Cartesian fullScreen(Boolean bool) {
        APIlib.getInstance().addJSLine(String.format(Locale.US, this.jsBase + ".fullScreen(%s);", bool));
        return this;
    }

    @Override // com.anychart.core.SeparateChart, com.anychart.core.Chart, com.anychart.core.VisualBaseWithBounds
    public Rect getPixelBounds() {
        return new Rect(this.jsBase + ".getPixelBounds()");
    }

    public Rect getPlotBounds() {
        return new Rect(this.jsBase + ".getPlotBounds()");
    }

    @Override // com.anychart.core.SeparateChart, com.anychart.core.Chart
    public void getSelectedPoints() {
        APIlib.getInstance().addJSLine(this.jsBase + ".getSelectedPoints();");
    }

    public Base getSeries(Number number) {
        return new Base(String.format(Locale.US, this.jsBase + ".getSeries(%s)", number));
    }

    public Base getSeries(String str) {
        return new Base(String.format(Locale.US, this.jsBase + ".getSeries(%s)", wrapQuotes(str)));
    }

    public Base getSeriesAt(Number number) {
        return new Base(String.format(Locale.US, this.jsBase + ".getSeriesAt(%s)", number));
    }

    public void getSeriesCount() {
        APIlib.getInstance().addJSLine(this.jsBase + ".getSeriesCount();");
    }

    @Override // com.anychart.core.SeparateChart, com.anychart.core.Chart
    public void getStat(Statistics statistics) {
        APIlib.getInstance().addJSLine(String.format(Locale.US, this.jsBase + ".getStat(%s);", statistics != null ? statistics.getJsBase() : null));
    }

    @Override // com.anychart.core.SeparateChart, com.anychart.core.Chart
    public void getStat(String str) {
        APIlib.getInstance().addJSLine(String.format(Locale.US, this.jsBase + ".getStat(%s);", wrapQuotes(str)));
    }

    public void getType() {
        APIlib.getInstance().addJSLine(this.jsBase + ".getType();");
    }

    public void getXAxesCount() {
        APIlib.getInstance().addJSLine(this.jsBase + ".getXAxesCount();");
    }

    public void getXScales() {
        APIlib.getInstance().addJSLine(this.jsBase + ".getXScales();");
    }

    public void getYAxesCount() {
        APIlib.getInstance().addJSLine(this.jsBase + ".getYAxesCount();");
    }

    public void getYScales() {
        APIlib.getInstance().addJSLine(this.jsBase + ".getYScales();");
    }

    @Override // com.anychart.core.SeparateChart, com.anychart.core.Chart
    public void globalToLocal(Number number, Number number2) {
        APIlib.getInstance().addJSLine(String.format(Locale.US, this.jsBase + ".globalToLocal(%s, %s);", number, number2));
    }

    public HatchFills hatchFillPalette() {
        return new HatchFills(this.jsBase + ".hatchFillPalette()");
    }

    public Cartesian hatchFillPalette(HatchFillType[] hatchFillTypeArr) {
        APIlib.getInstance().addJSLine(String.format(Locale.US, this.jsBase + ".hatchFillPalette(%s);", arrayToString(hatchFillTypeArr)));
        return this;
    }

    public Cartesian hatchFillPalette(String str) {
        APIlib.getInstance().addJSLine(String.format(Locale.US, this.jsBase + ".hatchFillPalette(%s);", wrapQuotes(str)));
        return this;
    }

    public Cartesian hatchFillPalette(HatchFills hatchFills) {
        APIlib.getInstance().addJSLine(String.format(Locale.US, this.jsBase + ".hatchFillPalette(%s);", hatchFills != null ? hatchFills.getJsBase() : null));
        return this;
    }

    @Override // com.anychart.core.SeparateChart, com.anychart.core.Chart, com.anychart.core.VisualBaseWithBounds
    public void height() {
        APIlib.getInstance().addJSLine(this.jsBase + ".height();");
    }

    @Override // com.anychart.core.SeparateChart, com.anychart.core.Chart, com.anychart.core.VisualBaseWithBounds
    public Cartesian height(Number number) {
        APIlib.getInstance().addJSLine(String.format(Locale.US, this.jsBase + ".height(%s);", number));
        return this;
    }

    @Override // com.anychart.core.SeparateChart, com.anychart.core.Chart, com.anychart.core.VisualBaseWithBounds
    public Cartesian height(String str) {
        APIlib.getInstance().addJSLine(String.format(Locale.US, this.jsBase + ".height(%s);", wrapQuotes(str)));
        return this;
    }

    public Hilo hilo(List<DataEntry> list) {
        return new Hilo(String.format(Locale.US, this.jsBase + ".hilo(%s)", arrayToString(list)));
    }

    public StateSettings hovered() {
        return new StateSettings(this.jsBase + ".hovered()");
    }

    public Cartesian hovered(String str) {
        APIlib.getInstance().addJSLine(String.format(Locale.US, this.jsBase + ".hovered(%s);", wrapQuotes(str)));
        return this;
    }

    @Override // com.anychart.core.SeparateChart, com.anychart.core.Chart
    public void id() {
        APIlib.getInstance().addJSLine(this.jsBase + ".id();");
    }

    @Override // com.anychart.core.SeparateChart, com.anychart.core.Chart
    public Cartesian id(String str) {
        APIlib.getInstance().addJSLine(String.format(Locale.US, this.jsBase + ".id(%s);", wrapQuotes(str)));
        return this;
    }

    @Override // com.anychart.core.SeparateChart, com.anychart.core.Chart
    public void inMarquee() {
        APIlib.getInstance().addJSLine(this.jsBase + ".inMarquee();");
    }

    @Override // com.anychart.core.SeparateChart
    public Interactivity interactivity() {
        return new Interactivity(this.jsBase + ".interactivity()");
    }

    @Override // com.anychart.core.SeparateChart
    public Cartesian interactivity(String str) {
        APIlib.getInstance().addJSLine(String.format(Locale.US, this.jsBase + ".interactivity(%s);", wrapQuotes(str)));
        return this;
    }

    @Override // com.anychart.core.SeparateChart
    public Cartesian interactivity(HoverMode hoverMode) {
        APIlib.getInstance().addJSLine(String.format(Locale.US, this.jsBase + ".interactivity(%s);", hoverMode != null ? hoverMode.getJsBase() : null));
        return this;
    }

    @Override // com.anychart.core.SeparateChart, com.anychart.core.Chart
    public void isFullScreenAvailable() {
        APIlib.getInstance().addJSLine(this.jsBase + ".isFullScreenAvailable();");
    }

    public void isVertical() {
        APIlib.getInstance().addJSLine(this.jsBase + ".isVertical();");
    }

    public Cartesian isVertical(Boolean bool) {
        APIlib.getInstance().addJSLine(String.format(Locale.US, this.jsBase + ".isVertical(%s);", bool));
        return this;
    }

    public JumpLine jumpLine(List<DataEntry> list) {
        return new JumpLine(String.format(Locale.US, this.jsBase + ".jumpLine(%s)", arrayToString(list)));
    }

    @Override // com.anychart.core.SeparateChart, com.anychart.core.Chart
    public Label label(String str) {
        return new Label(String.format(Locale.US, this.jsBase + ".label(%s)", wrapQuotes(str)));
    }

    @Override // com.anychart.core.SeparateChart, com.anychart.core.Chart
    public Label label(Number number) {
        return new Label(String.format(Locale.US, this.jsBase + ".label(%s)", number));
    }

    @Override // com.anychart.core.SeparateChart, com.anychart.core.Chart
    public Cartesian label(Boolean bool) {
        APIlib.getInstance().addJSLine(String.format(Locale.US, this.jsBase + ".label(%s);", bool));
        return this;
    }

    @Override // com.anychart.core.SeparateChart, com.anychart.core.Chart
    public Cartesian label(String str, Boolean bool) {
        APIlib.getInstance().addJSLine(String.format(Locale.US, this.jsBase + ".label(%s, %s);", wrapQuotes(str), bool));
        return this;
    }

    @Override // com.anychart.core.SeparateChart, com.anychart.core.Chart
    public Cartesian label(String str, String str2) {
        APIlib.getInstance().addJSLine(String.format(Locale.US, this.jsBase + ".label(%s, %s);", wrapQuotes(str), wrapQuotes(str2)));
        return this;
    }

    @Override // com.anychart.core.SeparateChart, com.anychart.core.Chart
    public Cartesian label(Number number, Boolean bool) {
        APIlib.getInstance().addJSLine(String.format(Locale.US, this.jsBase + ".label(%s, %s);", number, bool));
        return this;
    }

    @Override // com.anychart.core.SeparateChart, com.anychart.core.Chart
    public Cartesian label(Number number, String str) {
        APIlib.getInstance().addJSLine(String.format(Locale.US, this.jsBase + ".label(%s, %s);", number, wrapQuotes(str)));
        return this;
    }

    public LabelsFactory labels() {
        return new LabelsFactory(this.jsBase + ".labels()");
    }

    public Cartesian labels(String str) {
        APIlib.getInstance().addJSLine(String.format(Locale.US, this.jsBase + ".labels(%s);", wrapQuotes(str)));
        return this;
    }

    public Cartesian labels(Boolean bool) {
        APIlib.getInstance().addJSLine(String.format(Locale.US, this.jsBase + ".labels(%s);", bool));
        return this;
    }

    @Override // com.anychart.core.SeparateChart, com.anychart.core.Chart, com.anychart.core.VisualBaseWithBounds
    public void left() {
        APIlib.getInstance().addJSLine(this.jsBase + ".left();");
    }

    @Override // com.anychart.core.SeparateChart, com.anychart.core.Chart, com.anychart.core.VisualBaseWithBounds
    public Cartesian left(Number number) {
        APIlib.getInstance().addJSLine(String.format(Locale.US, this.jsBase + ".left(%s);", number));
        return this;
    }

    @Override // com.anychart.core.SeparateChart, com.anychart.core.Chart, com.anychart.core.VisualBaseWithBounds
    public Cartesian left(String str) {
        APIlib.getInstance().addJSLine(String.format(Locale.US, this.jsBase + ".left(%s);", wrapQuotes(str)));
        return this;
    }

    @Override // com.anychart.core.SeparateChart
    public Legend legend() {
        return new Legend(this.jsBase + ".legend()");
    }

    @Override // com.anychart.core.SeparateChart
    public Cartesian legend(String str) {
        APIlib.getInstance().addJSLine(String.format(Locale.US, this.jsBase + ".legend(%s);", wrapQuotes(str)));
        return this;
    }

    @Override // com.anychart.core.SeparateChart
    public Cartesian legend(Boolean bool) {
        APIlib.getInstance().addJSLine(String.format(Locale.US, this.jsBase + ".legend(%s);", bool));
        return this;
    }

    public Line line(List<DataEntry> list) {
        return new Line(String.format(Locale.US, this.jsBase + ".line(%s)", arrayToString(list)));
    }

    public com.anychart.core.axismarkers.Line lineMarker(Number number) {
        return new com.anychart.core.axismarkers.Line(String.format(Locale.US, this.jsBase + ".lineMarker(%s)", number));
    }

    public Cartesian lineMarker(String str) {
        APIlib.getInstance().addJSLine(String.format(Locale.US, this.jsBase + ".lineMarker(%s);", wrapQuotes(str)));
        return this;
    }

    public Cartesian lineMarker(Boolean bool) {
        APIlib.getInstance().addJSLine(String.format(Locale.US, this.jsBase + ".lineMarker(%s);", bool));
        return this;
    }

    public Cartesian lineMarker(Number number, String str) {
        APIlib.getInstance().addJSLine(String.format(Locale.US, this.jsBase + ".lineMarker(%s, %s);", number, wrapQuotes(str)));
        return this;
    }

    public Cartesian lineMarker(Number number, Boolean bool) {
        APIlib.getInstance().addJSLine(String.format(Locale.US, this.jsBase + ".lineMarker(%s, %s);", number, bool));
        return this;
    }

    @Override // com.anychart.core.SeparateChart, com.anychart.core.Chart
    public void localToGlobal(Number number, Number number2) {
        APIlib.getInstance().addJSLine(String.format(Locale.US, this.jsBase + ".localToGlobal(%s, %s);", number, number2));
    }

    @Override // com.anychart.core.SeparateChart, com.anychart.core.Chart
    public Margin margin() {
        return new Margin(this.jsBase + ".margin()");
    }

    @Override // com.anychart.core.SeparateChart, com.anychart.core.Chart
    public Cartesian margin(Number[] numberArr) {
        APIlib.getInstance().addJSLine(String.format(Locale.US, this.jsBase + ".margin(%s);", Arrays.toString(numberArr)));
        return this;
    }

    @Override // com.anychart.core.SeparateChart, com.anychart.core.Chart
    public Cartesian margin(String[] strArr) {
        APIlib.getInstance().addJSLine(String.format(Locale.US, this.jsBase + ".margin(%s);", arrayToStringWrapQuotes(strArr)));
        return this;
    }

    @Override // com.anychart.core.SeparateChart, com.anychart.core.Chart
    public Cartesian margin(String str) {
        APIlib.getInstance().addJSLine(String.format(Locale.US, this.jsBase + ".margin(%s);", wrapQuotes(str)));
        return this;
    }

    @Override // com.anychart.core.SeparateChart, com.anychart.core.Chart
    public Cartesian margin(String str, String str2, String str3, String str4) {
        APIlib.getInstance().addJSLine(String.format(Locale.US, this.jsBase + ".margin(%s, %s, %s, %s);", wrapQuotes(str), wrapQuotes(str2), wrapQuotes(str3), wrapQuotes(str4)));
        return this;
    }

    @Override // com.anychart.core.SeparateChart, com.anychart.core.Chart
    public Cartesian margin(String str, String str2, String str3, Number number) {
        APIlib.getInstance().addJSLine(String.format(Locale.US, this.jsBase + ".margin(%s, %s, %s, %s);", wrapQuotes(str), wrapQuotes(str2), wrapQuotes(str3), number));
        return this;
    }

    @Override // com.anychart.core.SeparateChart, com.anychart.core.Chart
    public Cartesian margin(String str, String str2, Number number, String str3) {
        APIlib.getInstance().addJSLine(String.format(Locale.US, this.jsBase + ".margin(%s, %s, %s, %s);", wrapQuotes(str), wrapQuotes(str2), number, wrapQuotes(str3)));
        return this;
    }

    @Override // com.anychart.core.SeparateChart, com.anychart.core.Chart
    public Cartesian margin(String str, String str2, Number number, Number number2) {
        APIlib.getInstance().addJSLine(String.format(Locale.US, this.jsBase + ".margin(%s, %s, %s, %s);", wrapQuotes(str), wrapQuotes(str2), number, number2));
        return this;
    }

    @Override // com.anychart.core.SeparateChart, com.anychart.core.Chart
    public Cartesian margin(String str, Number number, String str2, String str3) {
        APIlib.getInstance().addJSLine(String.format(Locale.US, this.jsBase + ".margin(%s, %s, %s, %s);", wrapQuotes(str), number, wrapQuotes(str2), wrapQuotes(str3)));
        return this;
    }

    @Override // com.anychart.core.SeparateChart, com.anychart.core.Chart
    public Cartesian margin(String str, Number number, String str2, Number number2) {
        APIlib.getInstance().addJSLine(String.format(Locale.US, this.jsBase + ".margin(%s, %s, %s, %s);", wrapQuotes(str), number, wrapQuotes(str2), number2));
        return this;
    }

    @Override // com.anychart.core.SeparateChart, com.anychart.core.Chart
    public Cartesian margin(String str, Number number, Number number2, String str2) {
        APIlib.getInstance().addJSLine(String.format(Locale.US, this.jsBase + ".margin(%s, %s, %s, %s);", wrapQuotes(str), number, number2, wrapQuotes(str2)));
        return this;
    }

    @Override // com.anychart.core.SeparateChart, com.anychart.core.Chart
    public Cartesian margin(String str, Number number, Number number2, Number number3) {
        APIlib.getInstance().addJSLine(String.format(Locale.US, this.jsBase + ".margin(%s, %s, %s, %s);", wrapQuotes(str), number, number2, number3));
        return this;
    }

    @Override // com.anychart.core.SeparateChart, com.anychart.core.Chart
    public Cartesian margin(Number number, String str, String str2, String str3) {
        APIlib.getInstance().addJSLine(String.format(Locale.US, this.jsBase + ".margin(%s, %s, %s, %s);", number, wrapQuotes(str), wrapQuotes(str2), wrapQuotes(str3)));
        return this;
    }

    @Override // com.anychart.core.SeparateChart, com.anychart.core.Chart
    public Cartesian margin(Number number, String str, String str2, Number number2) {
        APIlib.getInstance().addJSLine(String.format(Locale.US, this.jsBase + ".margin(%s, %s, %s, %s);", number, wrapQuotes(str), wrapQuotes(str2), number2));
        return this;
    }

    @Override // com.anychart.core.SeparateChart, com.anychart.core.Chart
    public Cartesian margin(Number number, String str, Number number2, String str2) {
        APIlib.getInstance().addJSLine(String.format(Locale.US, this.jsBase + ".margin(%s, %s, %s, %s);", number, wrapQuotes(str), number2, wrapQuotes(str2)));
        return this;
    }

    @Override // com.anychart.core.SeparateChart, com.anychart.core.Chart
    public Cartesian margin(Number number, String str, Number number2, Number number3) {
        APIlib.getInstance().addJSLine(String.format(Locale.US, this.jsBase + ".margin(%s, %s, %s, %s);", number, wrapQuotes(str), number2, number3));
        return this;
    }

    @Override // com.anychart.core.SeparateChart, com.anychart.core.Chart
    public Cartesian margin(Number number, Number number2, String str, String str2) {
        APIlib.getInstance().addJSLine(String.format(Locale.US, this.jsBase + ".margin(%s, %s, %s, %s);", number, number2, wrapQuotes(str), wrapQuotes(str2)));
        return this;
    }

    @Override // com.anychart.core.SeparateChart, com.anychart.core.Chart
    public Cartesian margin(Number number, Number number2, String str, Number number3) {
        APIlib.getInstance().addJSLine(String.format(Locale.US, this.jsBase + ".margin(%s, %s, %s, %s);", number, number2, wrapQuotes(str), number3));
        return this;
    }

    @Override // com.anychart.core.SeparateChart, com.anychart.core.Chart
    public Cartesian margin(Number number, Number number2, Number number3, String str) {
        APIlib.getInstance().addJSLine(String.format(Locale.US, this.jsBase + ".margin(%s, %s, %s, %s);", number, number2, number3, wrapQuotes(str)));
        return this;
    }

    @Override // com.anychart.core.SeparateChart, com.anychart.core.Chart
    public Cartesian margin(Number number, Number number2, Number number3, Number number4) {
        APIlib.getInstance().addJSLine(String.format(Locale.US, this.jsBase + ".margin(%s, %s, %s, %s);", number, number2, number3, number4));
        return this;
    }

    public Marker marker(List<DataEntry> list) {
        return new Marker(String.format(Locale.US, this.jsBase + ".marker(%s)", arrayToString(list)));
    }

    public Markers markerPalette() {
        return new Markers(this.jsBase + ".markerPalette()");
    }

    public Cartesian markerPalette(Markers markers) {
        APIlib.getInstance().addJSLine(String.format(Locale.US, this.jsBase + ".markerPalette(%s);", markers != null ? markers.getJsBase() : null));
        return this;
    }

    public Cartesian markerPalette(String str) {
        APIlib.getInstance().addJSLine(String.format(Locale.US, this.jsBase + ".markerPalette(%s);", wrapQuotes(str)));
        return this;
    }

    public Cartesian markerPalette(MarkerType markerType) {
        APIlib.getInstance().addJSLine(String.format(Locale.US, this.jsBase + ".markerPalette(%s);", markerType != null ? markerType.getJsBase() : null));
        return this;
    }

    public Cartesian markerPalette(String[] strArr) {
        APIlib.getInstance().addJSLine(String.format(Locale.US, this.jsBase + ".markerPalette(%s);", arrayToStringWrapQuotes(strArr)));
        return this;
    }

    public void maxBubbleSize() {
        APIlib.getInstance().addJSLine(this.jsBase + ".maxBubbleSize();");
    }

    public Cartesian maxBubbleSize(Number number) {
        APIlib.getInstance().addJSLine(String.format(Locale.US, this.jsBase + ".maxBubbleSize(%s);", number));
        return this;
    }

    public Cartesian maxBubbleSize(String str) {
        APIlib.getInstance().addJSLine(String.format(Locale.US, this.jsBase + ".maxBubbleSize(%s);", wrapQuotes(str)));
        return this;
    }

    @Override // com.anychart.core.SeparateChart, com.anychart.core.Chart, com.anychart.core.VisualBaseWithBounds
    public void maxHeight() {
        APIlib.getInstance().addJSLine(this.jsBase + ".maxHeight();");
    }

    @Override // com.anychart.core.SeparateChart, com.anychart.core.Chart, com.anychart.core.VisualBaseWithBounds
    public Cartesian maxHeight(Number number) {
        APIlib.getInstance().addJSLine(String.format(Locale.US, this.jsBase + ".maxHeight(%s);", number));
        return this;
    }

    @Override // com.anychart.core.SeparateChart, com.anychart.core.Chart, com.anychart.core.VisualBaseWithBounds
    public Cartesian maxHeight(String str) {
        APIlib.getInstance().addJSLine(String.format(Locale.US, this.jsBase + ".maxHeight(%s);", wrapQuotes(str)));
        return this;
    }

    public LabelsFactory maxLabels() {
        return new LabelsFactory(this.jsBase + ".maxLabels()");
    }

    public Cartesian maxLabels(String str) {
        APIlib.getInstance().addJSLine(String.format(Locale.US, this.jsBase + ".maxLabels(%s);", wrapQuotes(str)));
        return this;
    }

    public Cartesian maxLabels(Boolean bool) {
        APIlib.getInstance().addJSLine(String.format(Locale.US, this.jsBase + ".maxLabels(%s);", bool));
        return this;
    }

    public void maxPointWidth() {
        APIlib.getInstance().addJSLine(this.jsBase + ".maxPointWidth();");
    }

    public Cartesian maxPointWidth(Number number) {
        APIlib.getInstance().addJSLine(String.format(Locale.US, this.jsBase + ".maxPointWidth(%s);", number));
        return this;
    }

    public Cartesian maxPointWidth(String str) {
        APIlib.getInstance().addJSLine(String.format(Locale.US, this.jsBase + ".maxPointWidth(%s);", wrapQuotes(str)));
        return this;
    }

    @Override // com.anychart.core.SeparateChart, com.anychart.core.Chart, com.anychart.core.VisualBaseWithBounds
    public void maxWidth() {
        APIlib.getInstance().addJSLine(this.jsBase + ".maxWidth();");
    }

    @Override // com.anychart.core.SeparateChart, com.anychart.core.Chart, com.anychart.core.VisualBaseWithBounds
    public Cartesian maxWidth(Number number) {
        APIlib.getInstance().addJSLine(String.format(Locale.US, this.jsBase + ".maxWidth(%s);", number));
        return this;
    }

    @Override // com.anychart.core.SeparateChart, com.anychart.core.Chart, com.anychart.core.VisualBaseWithBounds
    public Cartesian maxWidth(String str) {
        APIlib.getInstance().addJSLine(String.format(Locale.US, this.jsBase + ".maxWidth(%s);", wrapQuotes(str)));
        return this;
    }

    public void minBubbleSize() {
        APIlib.getInstance().addJSLine(this.jsBase + ".minBubbleSize();");
    }

    public Cartesian minBubbleSize(Number number) {
        APIlib.getInstance().addJSLine(String.format(Locale.US, this.jsBase + ".minBubbleSize(%s);", number));
        return this;
    }

    public Cartesian minBubbleSize(String str) {
        APIlib.getInstance().addJSLine(String.format(Locale.US, this.jsBase + ".minBubbleSize(%s);", wrapQuotes(str)));
        return this;
    }

    @Override // com.anychart.core.SeparateChart, com.anychart.core.Chart, com.anychart.core.VisualBaseWithBounds
    public void minHeight() {
        APIlib.getInstance().addJSLine(this.jsBase + ".minHeight();");
    }

    @Override // com.anychart.core.SeparateChart, com.anychart.core.Chart, com.anychart.core.VisualBaseWithBounds
    public Cartesian minHeight(Number number) {
        APIlib.getInstance().addJSLine(String.format(Locale.US, this.jsBase + ".minHeight(%s);", number));
        return this;
    }

    @Override // com.anychart.core.SeparateChart, com.anychart.core.Chart, com.anychart.core.VisualBaseWithBounds
    public Cartesian minHeight(String str) {
        APIlib.getInstance().addJSLine(String.format(Locale.US, this.jsBase + ".minHeight(%s);", wrapQuotes(str)));
        return this;
    }

    public LabelsFactory minLabels() {
        return new LabelsFactory(this.jsBase + ".minLabels()");
    }

    public Cartesian minLabels(String str) {
        APIlib.getInstance().addJSLine(String.format(Locale.US, this.jsBase + ".minLabels(%s);", wrapQuotes(str)));
        return this;
    }

    public Cartesian minLabels(Boolean bool) {
        APIlib.getInstance().addJSLine(String.format(Locale.US, this.jsBase + ".minLabels(%s);", bool));
        return this;
    }

    public void minPointLength() {
        APIlib.getInstance().addJSLine(this.jsBase + ".minPointLength();");
    }

    public Cartesian minPointLength(Number number) {
        APIlib.getInstance().addJSLine(String.format(Locale.US, this.jsBase + ".minPointLength(%s);", number));
        return this;
    }

    public Cartesian minPointLength(String str) {
        APIlib.getInstance().addJSLine(String.format(Locale.US, this.jsBase + ".minPointLength(%s);", wrapQuotes(str)));
        return this;
    }

    @Override // com.anychart.core.SeparateChart, com.anychart.core.Chart, com.anychart.core.VisualBaseWithBounds
    public void minWidth() {
        APIlib.getInstance().addJSLine(this.jsBase + ".minWidth();");
    }

    @Override // com.anychart.core.SeparateChart, com.anychart.core.Chart, com.anychart.core.VisualBaseWithBounds
    public Cartesian minWidth(Number number) {
        APIlib.getInstance().addJSLine(String.format(Locale.US, this.jsBase + ".minWidth(%s);", number));
        return this;
    }

    @Override // com.anychart.core.SeparateChart, com.anychart.core.Chart, com.anychart.core.VisualBaseWithBounds
    public Cartesian minWidth(String str) {
        APIlib.getInstance().addJSLine(String.format(Locale.US, this.jsBase + ".minWidth(%s);", wrapQuotes(str)));
        return this;
    }

    @Override // com.anychart.core.SeparateChart, com.anychart.core.Chart
    public NoDataSettings noData() {
        return new NoDataSettings(this.jsBase + ".noData()");
    }

    @Override // com.anychart.core.SeparateChart, com.anychart.core.Chart
    public Cartesian noData(String str) {
        APIlib.getInstance().addJSLine(String.format(Locale.US, this.jsBase + ".noData(%s);", wrapQuotes(str)));
        return this;
    }

    public StateSettings normal() {
        return new StateSettings(this.jsBase + ".normal()");
    }

    public Cartesian normal(String str) {
        APIlib.getInstance().addJSLine(String.format(Locale.US, this.jsBase + ".normal(%s);", wrapQuotes(str)));
        return this;
    }

    public OHLC ohlc(List<DataEntry> list) {
        return new OHLC(String.format(Locale.US, this.jsBase + ".ohlc(%s)", arrayToString(list)));
    }

    @Override // com.anychart.core.SeparateChart, com.anychart.core.Chart
    public Padding padding() {
        return new Padding(this.jsBase + ".padding()");
    }

    @Override // com.anychart.core.SeparateChart, com.anychart.core.Chart
    public Cartesian padding(Number[] numberArr) {
        APIlib.getInstance().addJSLine(String.format(Locale.US, this.jsBase + ".padding(%s);", Arrays.toString(numberArr)));
        return this;
    }

    @Override // com.anychart.core.SeparateChart, com.anychart.core.Chart
    public Cartesian padding(String[] strArr) {
        APIlib.getInstance().addJSLine(String.format(Locale.US, this.jsBase + ".padding(%s);", arrayToStringWrapQuotes(strArr)));
        return this;
    }

    @Override // com.anychart.core.SeparateChart, com.anychart.core.Chart
    public Cartesian padding(String str) {
        APIlib.getInstance().addJSLine(String.format(Locale.US, this.jsBase + ".padding(%s);", wrapQuotes(str)));
        return this;
    }

    @Override // com.anychart.core.SeparateChart, com.anychart.core.Chart
    public Cartesian padding(String str, String str2, String str3, String str4) {
        APIlib.getInstance().addJSLine(String.format(Locale.US, this.jsBase + ".padding(%s, %s, %s, %s);", wrapQuotes(str), wrapQuotes(str2), wrapQuotes(str3), wrapQuotes(str4)));
        return this;
    }

    @Override // com.anychart.core.SeparateChart, com.anychart.core.Chart
    public Cartesian padding(String str, String str2, String str3, Number number) {
        APIlib.getInstance().addJSLine(String.format(Locale.US, this.jsBase + ".padding(%s, %s, %s, %s);", wrapQuotes(str), wrapQuotes(str2), wrapQuotes(str3), number));
        return this;
    }

    @Override // com.anychart.core.SeparateChart, com.anychart.core.Chart
    public Cartesian padding(String str, String str2, Number number, String str3) {
        APIlib.getInstance().addJSLine(String.format(Locale.US, this.jsBase + ".padding(%s, %s, %s, %s);", wrapQuotes(str), wrapQuotes(str2), number, wrapQuotes(str3)));
        return this;
    }

    @Override // com.anychart.core.SeparateChart, com.anychart.core.Chart
    public Cartesian padding(String str, String str2, Number number, Number number2) {
        APIlib.getInstance().addJSLine(String.format(Locale.US, this.jsBase + ".padding(%s, %s, %s, %s);", wrapQuotes(str), wrapQuotes(str2), number, number2));
        return this;
    }

    @Override // com.anychart.core.SeparateChart, com.anychart.core.Chart
    public Cartesian padding(String str, Number number, String str2, String str3) {
        APIlib.getInstance().addJSLine(String.format(Locale.US, this.jsBase + ".padding(%s, %s, %s, %s);", wrapQuotes(str), number, wrapQuotes(str2), wrapQuotes(str3)));
        return this;
    }

    @Override // com.anychart.core.SeparateChart, com.anychart.core.Chart
    public Cartesian padding(String str, Number number, String str2, Number number2) {
        APIlib.getInstance().addJSLine(String.format(Locale.US, this.jsBase + ".padding(%s, %s, %s, %s);", wrapQuotes(str), number, wrapQuotes(str2), number2));
        return this;
    }

    @Override // com.anychart.core.SeparateChart, com.anychart.core.Chart
    public Cartesian padding(String str, Number number, Number number2, String str2) {
        APIlib.getInstance().addJSLine(String.format(Locale.US, this.jsBase + ".padding(%s, %s, %s, %s);", wrapQuotes(str), number, number2, wrapQuotes(str2)));
        return this;
    }

    @Override // com.anychart.core.SeparateChart, com.anychart.core.Chart
    public Cartesian padding(String str, Number number, Number number2, Number number3) {
        APIlib.getInstance().addJSLine(String.format(Locale.US, this.jsBase + ".padding(%s, %s, %s, %s);", wrapQuotes(str), number, number2, number3));
        return this;
    }

    @Override // com.anychart.core.SeparateChart, com.anychart.core.Chart
    public Cartesian padding(Number number, String str, String str2, String str3) {
        APIlib.getInstance().addJSLine(String.format(Locale.US, this.jsBase + ".padding(%s, %s, %s, %s);", number, wrapQuotes(str), wrapQuotes(str2), wrapQuotes(str3)));
        return this;
    }

    @Override // com.anychart.core.SeparateChart, com.anychart.core.Chart
    public Cartesian padding(Number number, String str, String str2, Number number2) {
        APIlib.getInstance().addJSLine(String.format(Locale.US, this.jsBase + ".padding(%s, %s, %s, %s);", number, wrapQuotes(str), wrapQuotes(str2), number2));
        return this;
    }

    @Override // com.anychart.core.SeparateChart, com.anychart.core.Chart
    public Cartesian padding(Number number, String str, Number number2, String str2) {
        APIlib.getInstance().addJSLine(String.format(Locale.US, this.jsBase + ".padding(%s, %s, %s, %s);", number, wrapQuotes(str), number2, wrapQuotes(str2)));
        return this;
    }

    @Override // com.anychart.core.SeparateChart, com.anychart.core.Chart
    public Cartesian padding(Number number, String str, Number number2, Number number3) {
        APIlib.getInstance().addJSLine(String.format(Locale.US, this.jsBase + ".padding(%s, %s, %s, %s);", number, wrapQuotes(str), number2, number3));
        return this;
    }

    @Override // com.anychart.core.SeparateChart, com.anychart.core.Chart
    public Cartesian padding(Number number, Number number2, String str, String str2) {
        APIlib.getInstance().addJSLine(String.format(Locale.US, this.jsBase + ".padding(%s, %s, %s, %s);", number, number2, wrapQuotes(str), wrapQuotes(str2)));
        return this;
    }

    @Override // com.anychart.core.SeparateChart, com.anychart.core.Chart
    public Cartesian padding(Number number, Number number2, String str, Number number3) {
        APIlib.getInstance().addJSLine(String.format(Locale.US, this.jsBase + ".padding(%s, %s, %s, %s);", number, number2, wrapQuotes(str), number3));
        return this;
    }

    @Override // com.anychart.core.SeparateChart, com.anychart.core.Chart
    public Cartesian padding(Number number, Number number2, Number number3, String str) {
        APIlib.getInstance().addJSLine(String.format(Locale.US, this.jsBase + ".padding(%s, %s, %s, %s);", number, number2, number3, wrapQuotes(str)));
        return this;
    }

    @Override // com.anychart.core.SeparateChart, com.anychart.core.Chart
    public Cartesian padding(Number number, Number number2, Number number3, Number number4) {
        APIlib.getInstance().addJSLine(String.format(Locale.US, this.jsBase + ".padding(%s, %s, %s, %s);", number, number2, number3, number4));
        return this;
    }

    public RangeColors palette() {
        return new RangeColors(this.jsBase + ".palette()");
    }

    public Cartesian palette(RangeColors rangeColors) {
        APIlib.getInstance().addJSLine(String.format(Locale.US, this.jsBase + ".palette(%s);", rangeColors != null ? rangeColors.getJsBase() : null));
        return this;
    }

    public Cartesian palette(DistinctColors distinctColors) {
        APIlib.getInstance().addJSLine(String.format(Locale.US, this.jsBase + ".palette(%s);", distinctColors != null ? distinctColors.getJsBase() : null));
        return this;
    }

    public Cartesian palette(String str) {
        APIlib.getInstance().addJSLine(String.format(Locale.US, this.jsBase + ".palette(%s);", wrapQuotes(str)));
        return this;
    }

    public Cartesian palette(String[] strArr) {
        APIlib.getInstance().addJSLine(String.format(Locale.US, this.jsBase + ".palette(%s);", arrayToStringWrapQuotes(strArr)));
        return this;
    }

    public void pointWidth() {
        APIlib.getInstance().addJSLine(this.jsBase + ".pointWidth();");
    }

    public Cartesian pointWidth(Number number) {
        APIlib.getInstance().addJSLine(String.format(Locale.US, this.jsBase + ".pointWidth(%s);", number));
        return this;
    }

    public Cartesian pointWidth(String str) {
        APIlib.getInstance().addJSLine(String.format(Locale.US, this.jsBase + ".pointWidth(%s);", wrapQuotes(str)));
        return this;
    }

    @Override // com.anychart.core.SeparateChart, com.anychart.core.Chart, com.anychart.core.VisualBaseWithBounds, com.anychart.core.VisualBase
    public void print(PaperSize paperSize, Boolean bool) {
        APIlib.getInstance().addJSLine(String.format(Locale.US, this.jsBase + ".print(%s, %s);", paperSize != null ? paperSize.getJsBase() : null, bool));
    }

    public RangeArea rangeArea(View view, TextParsingMode textParsingMode) {
        return new RangeArea(String.format(Locale.US, this.jsBase + ".rangeArea(%s, %s)", view != null ? view.getJsBase() : null, textParsingMode != null ? textParsingMode.getJsBase() : null));
    }

    public RangeArea rangeArea(View view, String str) {
        return new RangeArea(String.format(Locale.US, this.jsBase + ".rangeArea(%s, %s)", view != null ? view.getJsBase() : null, wrapQuotes(str)));
    }

    public RangeArea rangeArea(View view, TextParsingSettings textParsingSettings) {
        return new RangeArea(String.format(Locale.US, this.jsBase + ".rangeArea(%s, %s)", view != null ? view.getJsBase() : null, textParsingSettings != null ? textParsingSettings.getJsBase() : null));
    }

    public RangeArea rangeArea(Set set, TextParsingMode textParsingMode) {
        return new RangeArea(String.format(Locale.US, this.jsBase + ".rangeArea(%s, %s)", set != null ? set.getJsBase() : null, textParsingMode != null ? textParsingMode.getJsBase() : null));
    }

    public RangeArea rangeArea(Set set, String str) {
        return new RangeArea(String.format(Locale.US, this.jsBase + ".rangeArea(%s, %s)", set != null ? set.getJsBase() : null, wrapQuotes(str)));
    }

    public RangeArea rangeArea(Set set, TextParsingSettings textParsingSettings) {
        return new RangeArea(String.format(Locale.US, this.jsBase + ".rangeArea(%s, %s)", set != null ? set.getJsBase() : null, textParsingSettings != null ? textParsingSettings.getJsBase() : null));
    }

    public RangeArea rangeArea(String[] strArr, TextParsingMode textParsingMode) {
        return new RangeArea(String.format(Locale.US, this.jsBase + ".rangeArea(%s, %s)", arrayToStringWrapQuotes(strArr), textParsingMode != null ? textParsingMode.getJsBase() : null));
    }

    public RangeArea rangeArea(String[] strArr, String str) {
        return new RangeArea(String.format(Locale.US, this.jsBase + ".rangeArea(%s, %s)", arrayToStringWrapQuotes(strArr), wrapQuotes(str)));
    }

    public RangeArea rangeArea(String[] strArr, TextParsingSettings textParsingSettings) {
        return new RangeArea(String.format(Locale.US, this.jsBase + ".rangeArea(%s, %s)", arrayToStringWrapQuotes(strArr), textParsingSettings != null ? textParsingSettings.getJsBase() : null));
    }

    public RangeArea rangeArea(String str, TextParsingMode textParsingMode) {
        return new RangeArea(String.format(Locale.US, this.jsBase + ".rangeArea(%s, %s)", wrapQuotes(str), textParsingMode != null ? textParsingMode.getJsBase() : null));
    }

    public RangeArea rangeArea(String str, String str2) {
        return new RangeArea(String.format(Locale.US, this.jsBase + ".rangeArea(%s, %s)", wrapQuotes(str), wrapQuotes(str2)));
    }

    public RangeArea rangeArea(String str, TextParsingSettings textParsingSettings) {
        return new RangeArea(String.format(Locale.US, this.jsBase + ".rangeArea(%s, %s)", wrapQuotes(str), textParsingSettings != null ? textParsingSettings.getJsBase() : null));
    }

    public RangeBar rangeBar(List<DataEntry> list) {
        return new RangeBar(String.format(Locale.US, this.jsBase + ".rangeBar(%s)", arrayToString(list)));
    }

    public RangeColumn rangeColumn(List<DataEntry> list) {
        return new RangeColumn(String.format(Locale.US, this.jsBase + ".rangeColumn(%s)", arrayToString(list)));
    }

    public Range rangeMarker(Number number) {
        return new Range(String.format(Locale.US, this.jsBase + ".rangeMarker(%s)", number));
    }

    public Cartesian rangeMarker(String str) {
        APIlib.getInstance().addJSLine(String.format(Locale.US, this.jsBase + ".rangeMarker(%s);", wrapQuotes(str)));
        return this;
    }

    public Cartesian rangeMarker(Boolean bool) {
        APIlib.getInstance().addJSLine(String.format(Locale.US, this.jsBase + ".rangeMarker(%s);", bool));
        return this;
    }

    public Cartesian rangeMarker(Number number, String str) {
        APIlib.getInstance().addJSLine(String.format(Locale.US, this.jsBase + ".rangeMarker(%s, %s);", number, wrapQuotes(str)));
        return this;
    }

    public Cartesian rangeMarker(Number number, Boolean bool) {
        APIlib.getInstance().addJSLine(String.format(Locale.US, this.jsBase + ".rangeMarker(%s, %s);", number, bool));
        return this;
    }

    public RangeSplineArea rangeSplineArea(View view, TextParsingMode textParsingMode) {
        return new RangeSplineArea(String.format(Locale.US, this.jsBase + ".rangeSplineArea(%s, %s)", view != null ? view.getJsBase() : null, textParsingMode != null ? textParsingMode.getJsBase() : null));
    }

    public RangeSplineArea rangeSplineArea(View view, String str) {
        return new RangeSplineArea(String.format(Locale.US, this.jsBase + ".rangeSplineArea(%s, %s)", view != null ? view.getJsBase() : null, wrapQuotes(str)));
    }

    public RangeSplineArea rangeSplineArea(View view, TextParsingSettings textParsingSettings) {
        return new RangeSplineArea(String.format(Locale.US, this.jsBase + ".rangeSplineArea(%s, %s)", view != null ? view.getJsBase() : null, textParsingSettings != null ? textParsingSettings.getJsBase() : null));
    }

    public RangeSplineArea rangeSplineArea(Set set, TextParsingMode textParsingMode) {
        return new RangeSplineArea(String.format(Locale.US, this.jsBase + ".rangeSplineArea(%s, %s)", set != null ? set.getJsBase() : null, textParsingMode != null ? textParsingMode.getJsBase() : null));
    }

    public RangeSplineArea rangeSplineArea(Set set, String str) {
        return new RangeSplineArea(String.format(Locale.US, this.jsBase + ".rangeSplineArea(%s, %s)", set != null ? set.getJsBase() : null, wrapQuotes(str)));
    }

    public RangeSplineArea rangeSplineArea(Set set, TextParsingSettings textParsingSettings) {
        return new RangeSplineArea(String.format(Locale.US, this.jsBase + ".rangeSplineArea(%s, %s)", set != null ? set.getJsBase() : null, textParsingSettings != null ? textParsingSettings.getJsBase() : null));
    }

    public RangeSplineArea rangeSplineArea(String[] strArr, TextParsingMode textParsingMode) {
        return new RangeSplineArea(String.format(Locale.US, this.jsBase + ".rangeSplineArea(%s, %s)", arrayToStringWrapQuotes(strArr), textParsingMode != null ? textParsingMode.getJsBase() : null));
    }

    public RangeSplineArea rangeSplineArea(String[] strArr, String str) {
        return new RangeSplineArea(String.format(Locale.US, this.jsBase + ".rangeSplineArea(%s, %s)", arrayToStringWrapQuotes(strArr), wrapQuotes(str)));
    }

    public RangeSplineArea rangeSplineArea(String[] strArr, TextParsingSettings textParsingSettings) {
        return new RangeSplineArea(String.format(Locale.US, this.jsBase + ".rangeSplineArea(%s, %s)", arrayToStringWrapQuotes(strArr), textParsingSettings != null ? textParsingSettings.getJsBase() : null));
    }

    public RangeSplineArea rangeSplineArea(String str, TextParsingMode textParsingMode) {
        return new RangeSplineArea(String.format(Locale.US, this.jsBase + ".rangeSplineArea(%s, %s)", wrapQuotes(str), textParsingMode != null ? textParsingMode.getJsBase() : null));
    }

    public RangeSplineArea rangeSplineArea(String str, String str2) {
        return new RangeSplineArea(String.format(Locale.US, this.jsBase + ".rangeSplineArea(%s, %s)", wrapQuotes(str), wrapQuotes(str2)));
    }

    public RangeSplineArea rangeSplineArea(String str, TextParsingSettings textParsingSettings) {
        return new RangeSplineArea(String.format(Locale.US, this.jsBase + ".rangeSplineArea(%s, %s)", wrapQuotes(str), textParsingSettings != null ? textParsingSettings.getJsBase() : null));
    }

    public RangeStepArea rangeStepArea(View view, TextParsingMode textParsingMode) {
        return new RangeStepArea(String.format(Locale.US, this.jsBase + ".rangeStepArea(%s, %s)", view != null ? view.getJsBase() : null, textParsingMode != null ? textParsingMode.getJsBase() : null));
    }

    public RangeStepArea rangeStepArea(View view, String str) {
        return new RangeStepArea(String.format(Locale.US, this.jsBase + ".rangeStepArea(%s, %s)", view != null ? view.getJsBase() : null, wrapQuotes(str)));
    }

    public RangeStepArea rangeStepArea(View view, TextParsingSettings textParsingSettings) {
        return new RangeStepArea(String.format(Locale.US, this.jsBase + ".rangeStepArea(%s, %s)", view != null ? view.getJsBase() : null, textParsingSettings != null ? textParsingSettings.getJsBase() : null));
    }

    public RangeStepArea rangeStepArea(Set set, TextParsingMode textParsingMode) {
        return new RangeStepArea(String.format(Locale.US, this.jsBase + ".rangeStepArea(%s, %s)", set != null ? set.getJsBase() : null, textParsingMode != null ? textParsingMode.getJsBase() : null));
    }

    public RangeStepArea rangeStepArea(Set set, String str) {
        return new RangeStepArea(String.format(Locale.US, this.jsBase + ".rangeStepArea(%s, %s)", set != null ? set.getJsBase() : null, wrapQuotes(str)));
    }

    public RangeStepArea rangeStepArea(Set set, TextParsingSettings textParsingSettings) {
        return new RangeStepArea(String.format(Locale.US, this.jsBase + ".rangeStepArea(%s, %s)", set != null ? set.getJsBase() : null, textParsingSettings != null ? textParsingSettings.getJsBase() : null));
    }

    public RangeStepArea rangeStepArea(String[] strArr, TextParsingMode textParsingMode) {
        return new RangeStepArea(String.format(Locale.US, this.jsBase + ".rangeStepArea(%s, %s)", arrayToStringWrapQuotes(strArr), textParsingMode != null ? textParsingMode.getJsBase() : null));
    }

    public RangeStepArea rangeStepArea(String[] strArr, String str) {
        return new RangeStepArea(String.format(Locale.US, this.jsBase + ".rangeStepArea(%s, %s)", arrayToStringWrapQuotes(strArr), wrapQuotes(str)));
    }

    public RangeStepArea rangeStepArea(String[] strArr, TextParsingSettings textParsingSettings) {
        return new RangeStepArea(String.format(Locale.US, this.jsBase + ".rangeStepArea(%s, %s)", arrayToStringWrapQuotes(strArr), textParsingSettings != null ? textParsingSettings.getJsBase() : null));
    }

    public RangeStepArea rangeStepArea(String str, TextParsingMode textParsingMode) {
        return new RangeStepArea(String.format(Locale.US, this.jsBase + ".rangeStepArea(%s, %s)", wrapQuotes(str), textParsingMode != null ? textParsingMode.getJsBase() : null));
    }

    public RangeStepArea rangeStepArea(String str, String str2) {
        return new RangeStepArea(String.format(Locale.US, this.jsBase + ".rangeStepArea(%s, %s)", wrapQuotes(str), wrapQuotes(str2)));
    }

    public RangeStepArea rangeStepArea(String str, TextParsingSettings textParsingSettings) {
        return new RangeStepArea(String.format(Locale.US, this.jsBase + ".rangeStepArea(%s, %s)", wrapQuotes(str), textParsingSettings != null ? textParsingSettings.getJsBase() : null));
    }

    @Override // com.anychart.core.SeparateChart, com.anychart.core.Chart, com.anychart.core.VisualBaseWithBounds, com.anychart.core.VisualBase, com.anychart.core.Base
    public void removeAllListeners(String str) {
        APIlib.getInstance().addJSLine(String.format(Locale.US, this.jsBase + ".removeAllListeners(%s);", wrapQuotes(str)));
    }

    public Cartesian removeAllSeries() {
        APIlib.getInstance().addJSLine(this.jsBase + ".removeAllSeries();");
        return this;
    }

    public Cartesian removeSeries(Number number) {
        APIlib.getInstance().addJSLine(String.format(Locale.US, this.jsBase + ".removeSeries(%s);", number));
        return this;
    }

    public Cartesian removeSeries(String str) {
        APIlib.getInstance().addJSLine(String.format(Locale.US, this.jsBase + ".removeSeries(%s);", wrapQuotes(str)));
        return this;
    }

    public Cartesian removeSeriesAt(Number number) {
        APIlib.getInstance().addJSLine(String.format(Locale.US, this.jsBase + ".removeSeriesAt(%s);", number));
        return this;
    }

    @Override // com.anychart.core.SeparateChart, com.anychart.core.Chart, com.anychart.core.VisualBaseWithBounds
    public void right() {
        APIlib.getInstance().addJSLine(this.jsBase + ".right();");
    }

    @Override // com.anychart.core.SeparateChart, com.anychart.core.Chart, com.anychart.core.VisualBaseWithBounds
    public Cartesian right(Number number) {
        APIlib.getInstance().addJSLine(String.format(Locale.US, this.jsBase + ".right(%s);", number));
        return this;
    }

    @Override // com.anychart.core.SeparateChart, com.anychart.core.Chart, com.anychart.core.VisualBaseWithBounds
    public Cartesian right(String str) {
        APIlib.getInstance().addJSLine(String.format(Locale.US, this.jsBase + ".right(%s);", wrapQuotes(str)));
        return this;
    }

    public void saveAsJpg(Number number, Number number2, Number number3, Boolean bool) {
        APIlib.getInstance().addJSLine(String.format(Locale.US, this.jsBase + ".saveAsJpg(%s, %s, %s, %s);", number, number2, number3, bool));
    }

    @Override // com.anychart.core.SeparateChart, com.anychart.core.Chart
    public void saveAsJson(String str) {
        APIlib.getInstance().addJSLine(String.format(Locale.US, this.jsBase + ".saveAsJson(%s);", wrapQuotes(str)));
    }

    public void saveAsPdf(String str, Boolean bool, Number number, Number number2) {
        APIlib.getInstance().addJSLine(String.format(Locale.US, this.jsBase + ".saveAsPdf(%s, %s, %s, %s);", wrapQuotes(str), bool, number, number2));
    }

    public void saveAsPng(Number number, Number number2, Number number3) {
        APIlib.getInstance().addJSLine(String.format(Locale.US, this.jsBase + ".saveAsPng(%s, %s, %s);", number, number2, number3));
    }

    public void saveAsSvg(String str, Boolean bool) {
        APIlib.getInstance().addJSLine(String.format(Locale.US, this.jsBase + ".saveAsSvg(%s, %s);", wrapQuotes(str), bool));
    }

    @Override // com.anychart.core.SeparateChart, com.anychart.core.Chart
    public void saveAsSvg(Number number, Number number2) {
        APIlib.getInstance().addJSLine(String.format(Locale.US, this.jsBase + ".saveAsSvg(%s, %s);", number, number2));
    }

    @Override // com.anychart.core.SeparateChart, com.anychart.core.Chart
    public void saveAsXlsx(ChartDataExportMode chartDataExportMode, String str) {
        APIlib.getInstance().addJSLine(String.format(Locale.US, this.jsBase + ".saveAsXlsx(%s, %s);", chartDataExportMode != null ? chartDataExportMode.getJsBase() : null, wrapQuotes(str)));
    }

    @Override // com.anychart.core.SeparateChart, com.anychart.core.Chart
    public void saveAsXlsx(String str, String str2) {
        APIlib.getInstance().addJSLine(String.format(Locale.US, this.jsBase + ".saveAsXlsx(%s, %s);", wrapQuotes(str), wrapQuotes(str2)));
    }

    @Override // com.anychart.core.SeparateChart, com.anychart.core.Chart
    public void saveAsXml(String str) {
        APIlib.getInstance().addJSLine(String.format(Locale.US, this.jsBase + ".saveAsXml(%s);", wrapQuotes(str)));
    }

    @Override // com.anychart.core.SeparateChart, com.anychart.core.Chart
    public void selectMarqueeFill() {
        APIlib.getInstance().addJSLine(this.jsBase + ".selectMarqueeFill();");
    }

    @Override // com.anychart.core.SeparateChart, com.anychart.core.Chart
    public Cartesian selectMarqueeFill(Fill fill) {
        APIlib.getInstance().addJSLine(String.format(Locale.US, this.jsBase + ".selectMarqueeFill(%s);", fill != null ? fill.getJsBase() : null));
        return this;
    }

    @Override // com.anychart.core.SeparateChart, com.anychart.core.Chart
    public Cartesian selectMarqueeFill(GradientKey gradientKey) {
        APIlib.getInstance().addJSLine(String.format(Locale.US, this.jsBase + ".selectMarqueeFill(%s);", gradientKey != null ? gradientKey.getJsBase() : null));
        return this;
    }

    @Override // com.anychart.core.SeparateChart, com.anychart.core.Chart
    public Cartesian selectMarqueeFill(String[] strArr) {
        APIlib.getInstance().addJSLine(String.format(Locale.US, this.jsBase + ".selectMarqueeFill(%s);", arrayToStringWrapQuotes(strArr)));
        return this;
    }

    @Override // com.anychart.core.SeparateChart, com.anychart.core.Chart
    public Cartesian selectMarqueeFill(String str, Number number) {
        APIlib.getInstance().addJSLine(String.format(Locale.US, this.jsBase + ".selectMarqueeFill(%s, %s);", wrapQuotes(str), number));
        return this;
    }

    @Override // com.anychart.core.SeparateChart, com.anychart.core.Chart
    public Cartesian selectMarqueeFill(GradientKey gradientKey, Number number, Boolean bool, Number number2) {
        APIlib.getInstance().addJSLine(String.format(Locale.US, this.jsBase + ".selectMarqueeFill(%s, %s, %s, %s);", gradientKey != null ? gradientKey.getJsBase() : null, number, bool, number2));
        return this;
    }

    @Override // com.anychart.core.SeparateChart, com.anychart.core.Chart
    public Cartesian selectMarqueeFill(GradientKey gradientKey, Number number, com.anychart.graphics.vector.Rect rect, Number number2) {
        APIlib.getInstance().addJSLine(String.format(Locale.US, this.jsBase + ".selectMarqueeFill(%s, %s, %s, %s);", gradientKey != null ? gradientKey.getJsBase() : null, number, rect != null ? rect.getJsBase() : null, number2));
        return this;
    }

    @Override // com.anychart.core.SeparateChart, com.anychart.core.Chart
    public Cartesian selectMarqueeFill(GradientKey gradientKey, Number number, String str, Number number2) {
        APIlib.getInstance().addJSLine(String.format(Locale.US, this.jsBase + ".selectMarqueeFill(%s, %s, %s, %s);", gradientKey != null ? gradientKey.getJsBase() : null, number, wrapQuotes(str), number2));
        return this;
    }

    @Override // com.anychart.core.SeparateChart, com.anychart.core.Chart
    public Cartesian selectMarqueeFill(String[] strArr, Number number, Boolean bool, Number number2) {
        APIlib.getInstance().addJSLine(String.format(Locale.US, this.jsBase + ".selectMarqueeFill(%s, %s, %s, %s);", arrayToStringWrapQuotes(strArr), number, bool, number2));
        return this;
    }

    @Override // com.anychart.core.SeparateChart, com.anychart.core.Chart
    public Cartesian selectMarqueeFill(String[] strArr, Number number, com.anychart.graphics.vector.Rect rect, Number number2) {
        APIlib.getInstance().addJSLine(String.format(Locale.US, this.jsBase + ".selectMarqueeFill(%s, %s, %s, %s);", arrayToStringWrapQuotes(strArr), number, rect != null ? rect.getJsBase() : null, number2));
        return this;
    }

    @Override // com.anychart.core.SeparateChart, com.anychart.core.Chart
    public Cartesian selectMarqueeFill(String[] strArr, Number number, String str, Number number2) {
        APIlib.getInstance().addJSLine(String.format(Locale.US, this.jsBase + ".selectMarqueeFill(%s, %s, %s, %s);", arrayToStringWrapQuotes(strArr), number, wrapQuotes(str), number2));
        return this;
    }

    @Override // com.anychart.core.SeparateChart, com.anychart.core.Chart
    public Cartesian selectMarqueeFill(GradientKey gradientKey, Number number, Number number2, com.anychart.graphics.math.Rect rect, Number number3, Number number4, Number number5) {
        APIlib.getInstance().addJSLine(String.format(Locale.US, this.jsBase + ".selectMarqueeFill(%s, %s, %s, %s, %s, %s, %s);", gradientKey != null ? gradientKey.getJsBase() : null, number, number2, rect != null ? rect.getJsBase() : null, number3, number4, number5));
        return this;
    }

    @Override // com.anychart.core.SeparateChart, com.anychart.core.Chart
    public Cartesian selectMarqueeFill(String[] strArr, Number number, Number number2, com.anychart.graphics.math.Rect rect, Number number3, Number number4, Number number5) {
        APIlib.getInstance().addJSLine(String.format(Locale.US, this.jsBase + ".selectMarqueeFill(%s, %s, %s, %s, %s, %s, %s);", arrayToStringWrapQuotes(strArr), number, number2, rect != null ? rect.getJsBase() : null, number3, number4, number5));
        return this;
    }

    @Override // com.anychart.core.SeparateChart, com.anychart.core.Chart
    public void selectMarqueeStroke() {
        APIlib.getInstance().addJSLine(this.jsBase + ".selectMarqueeStroke();");
    }

    @Override // com.anychart.core.SeparateChart, com.anychart.core.Chart
    public Cartesian selectMarqueeStroke(Stroke stroke, Number number, String str, String str2, String str3) {
        APIlib.getInstance().addJSLine(String.format(Locale.US, this.jsBase + ".selectMarqueeStroke(%s, %s, %s, %s, %s);", stroke != null ? stroke.getJsBase() : null, number, wrapQuotes(str), wrapQuotes(str2), wrapQuotes(str3)));
        return this;
    }

    @Override // com.anychart.core.SeparateChart, com.anychart.core.Chart
    public Cartesian selectMarqueeStroke(Stroke stroke, Number number, String str, String str2, StrokeLineCap strokeLineCap) {
        APIlib.getInstance().addJSLine(String.format(Locale.US, this.jsBase + ".selectMarqueeStroke(%s, %s, %s, %s, %s);", stroke != null ? stroke.getJsBase() : null, number, wrapQuotes(str), wrapQuotes(str2), strokeLineCap != null ? strokeLineCap.getJsBase() : null));
        return this;
    }

    @Override // com.anychart.core.SeparateChart, com.anychart.core.Chart
    public Cartesian selectMarqueeStroke(Stroke stroke, Number number, String str, StrokeLineJoin strokeLineJoin, String str2) {
        APIlib.getInstance().addJSLine(String.format(Locale.US, this.jsBase + ".selectMarqueeStroke(%s, %s, %s, %s, %s);", stroke != null ? stroke.getJsBase() : null, number, wrapQuotes(str), strokeLineJoin != null ? strokeLineJoin.getJsBase() : null, wrapQuotes(str2)));
        return this;
    }

    @Override // com.anychart.core.SeparateChart, com.anychart.core.Chart
    public Cartesian selectMarqueeStroke(Stroke stroke, Number number, String str, StrokeLineJoin strokeLineJoin, StrokeLineCap strokeLineCap) {
        APIlib.getInstance().addJSLine(String.format(Locale.US, this.jsBase + ".selectMarqueeStroke(%s, %s, %s, %s, %s);", stroke != null ? stroke.getJsBase() : null, number, wrapQuotes(str), strokeLineJoin != null ? strokeLineJoin.getJsBase() : null, strokeLineCap != null ? strokeLineCap.getJsBase() : null));
        return this;
    }

    @Override // com.anychart.core.SeparateChart, com.anychart.core.Chart
    public Cartesian selectMarqueeStroke(ColoredFill coloredFill, Number number, String str, String str2, String str3) {
        APIlib.getInstance().addJSLine(String.format(Locale.US, this.jsBase + ".selectMarqueeStroke(%s, %s, %s, %s, %s);", coloredFill != null ? coloredFill.getJsBase() : null, number, wrapQuotes(str), wrapQuotes(str2), wrapQuotes(str3)));
        return this;
    }

    @Override // com.anychart.core.SeparateChart, com.anychart.core.Chart
    public Cartesian selectMarqueeStroke(ColoredFill coloredFill, Number number, String str, String str2, StrokeLineCap strokeLineCap) {
        APIlib.getInstance().addJSLine(String.format(Locale.US, this.jsBase + ".selectMarqueeStroke(%s, %s, %s, %s, %s);", coloredFill != null ? coloredFill.getJsBase() : null, number, wrapQuotes(str), wrapQuotes(str2), strokeLineCap != null ? strokeLineCap.getJsBase() : null));
        return this;
    }

    @Override // com.anychart.core.SeparateChart, com.anychart.core.Chart
    public Cartesian selectMarqueeStroke(ColoredFill coloredFill, Number number, String str, StrokeLineJoin strokeLineJoin, String str2) {
        APIlib.getInstance().addJSLine(String.format(Locale.US, this.jsBase + ".selectMarqueeStroke(%s, %s, %s, %s, %s);", coloredFill != null ? coloredFill.getJsBase() : null, number, wrapQuotes(str), strokeLineJoin != null ? strokeLineJoin.getJsBase() : null, wrapQuotes(str2)));
        return this;
    }

    @Override // com.anychart.core.SeparateChart, com.anychart.core.Chart
    public Cartesian selectMarqueeStroke(ColoredFill coloredFill, Number number, String str, StrokeLineJoin strokeLineJoin, StrokeLineCap strokeLineCap) {
        APIlib.getInstance().addJSLine(String.format(Locale.US, this.jsBase + ".selectMarqueeStroke(%s, %s, %s, %s, %s);", coloredFill != null ? coloredFill.getJsBase() : null, number, wrapQuotes(str), strokeLineJoin != null ? strokeLineJoin.getJsBase() : null, strokeLineCap != null ? strokeLineCap.getJsBase() : null));
        return this;
    }

    @Override // com.anychart.core.SeparateChart, com.anychart.core.Chart
    public Cartesian selectMarqueeStroke(String str, Number number, String str2, String str3, String str4) {
        APIlib.getInstance().addJSLine(String.format(Locale.US, this.jsBase + ".selectMarqueeStroke(%s, %s, %s, %s, %s);", wrapQuotes(str), number, wrapQuotes(str2), wrapQuotes(str3), wrapQuotes(str4)));
        return this;
    }

    @Override // com.anychart.core.SeparateChart, com.anychart.core.Chart
    public Cartesian selectMarqueeStroke(String str, Number number, String str2, String str3, StrokeLineCap strokeLineCap) {
        APIlib.getInstance().addJSLine(String.format(Locale.US, this.jsBase + ".selectMarqueeStroke(%s, %s, %s, %s, %s);", wrapQuotes(str), number, wrapQuotes(str2), wrapQuotes(str3), strokeLineCap != null ? strokeLineCap.getJsBase() : null));
        return this;
    }

    @Override // com.anychart.core.SeparateChart, com.anychart.core.Chart
    public Cartesian selectMarqueeStroke(String str, Number number, String str2, StrokeLineJoin strokeLineJoin, String str3) {
        APIlib.getInstance().addJSLine(String.format(Locale.US, this.jsBase + ".selectMarqueeStroke(%s, %s, %s, %s, %s);", wrapQuotes(str), number, wrapQuotes(str2), strokeLineJoin != null ? strokeLineJoin.getJsBase() : null, wrapQuotes(str3)));
        return this;
    }

    @Override // com.anychart.core.SeparateChart, com.anychart.core.Chart
    public Cartesian selectMarqueeStroke(String str, Number number, String str2, StrokeLineJoin strokeLineJoin, StrokeLineCap strokeLineCap) {
        APIlib.getInstance().addJSLine(String.format(Locale.US, this.jsBase + ".selectMarqueeStroke(%s, %s, %s, %s, %s);", wrapQuotes(str), number, wrapQuotes(str2), strokeLineJoin != null ? strokeLineJoin.getJsBase() : null, strokeLineCap != null ? strokeLineCap.getJsBase() : null));
        return this;
    }

    public StateSettings selected() {
        return new StateSettings(this.jsBase + ".selected()");
    }

    public Cartesian selected(String str) {
        APIlib.getInstance().addJSLine(String.format(Locale.US, this.jsBase + ".selected(%s);", wrapQuotes(str)));
        return this;
    }

    @Override // com.anychart.core.SeparateChart, com.anychart.core.Chart
    public void shareWithFacebook(String str, String str2, String str3, String str4) {
        APIlib.getInstance().addJSLine(String.format(Locale.US, this.jsBase + ".shareWithFacebook(%s, %s, %s, %s);", wrapQuotes(str), wrapQuotes(str2), wrapQuotes(str3), wrapQuotes(str4)));
    }

    @Override // com.anychart.core.SeparateChart, com.anychart.core.Chart
    public void shareWithLinkedIn(String str, String str2) {
        APIlib.getInstance().addJSLine(String.format(Locale.US, this.jsBase + ".shareWithLinkedIn(%s, %s);", wrapQuotes(str), wrapQuotes(str2)));
    }

    @Override // com.anychart.core.SeparateChart, com.anychart.core.Chart
    public void shareWithPinterest(String str, String str2) {
        APIlib.getInstance().addJSLine(String.format(Locale.US, this.jsBase + ".shareWithPinterest(%s, %s);", wrapQuotes(str), wrapQuotes(str2)));
    }

    @Override // com.anychart.core.SeparateChart, com.anychart.core.Chart
    public void shareWithTwitter() {
        APIlib.getInstance().addJSLine(this.jsBase + ".shareWithTwitter();");
    }

    public Spline spline(View view, TextParsingMode textParsingMode) {
        return new Spline(String.format(Locale.US, this.jsBase + ".spline(%s, %s)", view != null ? view.getJsBase() : null, textParsingMode != null ? textParsingMode.getJsBase() : null));
    }

    public Spline spline(View view, String str) {
        return new Spline(String.format(Locale.US, this.jsBase + ".spline(%s, %s)", view != null ? view.getJsBase() : null, wrapQuotes(str)));
    }

    public Spline spline(View view, TextParsingSettings textParsingSettings) {
        return new Spline(String.format(Locale.US, this.jsBase + ".spline(%s, %s)", view != null ? view.getJsBase() : null, textParsingSettings != null ? textParsingSettings.getJsBase() : null));
    }

    public Spline spline(Set set, TextParsingMode textParsingMode) {
        return new Spline(String.format(Locale.US, this.jsBase + ".spline(%s, %s)", set != null ? set.getJsBase() : null, textParsingMode != null ? textParsingMode.getJsBase() : null));
    }

    public Spline spline(Set set, String str) {
        return new Spline(String.format(Locale.US, this.jsBase + ".spline(%s, %s)", set != null ? set.getJsBase() : null, wrapQuotes(str)));
    }

    public Spline spline(Set set, TextParsingSettings textParsingSettings) {
        return new Spline(String.format(Locale.US, this.jsBase + ".spline(%s, %s)", set != null ? set.getJsBase() : null, textParsingSettings != null ? textParsingSettings.getJsBase() : null));
    }

    public Spline spline(String[] strArr, TextParsingMode textParsingMode) {
        return new Spline(String.format(Locale.US, this.jsBase + ".spline(%s, %s)", arrayToStringWrapQuotes(strArr), textParsingMode != null ? textParsingMode.getJsBase() : null));
    }

    public Spline spline(String[] strArr, String str) {
        return new Spline(String.format(Locale.US, this.jsBase + ".spline(%s, %s)", arrayToStringWrapQuotes(strArr), wrapQuotes(str)));
    }

    public Spline spline(String[] strArr, TextParsingSettings textParsingSettings) {
        return new Spline(String.format(Locale.US, this.jsBase + ".spline(%s, %s)", arrayToStringWrapQuotes(strArr), textParsingSettings != null ? textParsingSettings.getJsBase() : null));
    }

    public Spline spline(String str, TextParsingMode textParsingMode) {
        return new Spline(String.format(Locale.US, this.jsBase + ".spline(%s, %s)", wrapQuotes(str), textParsingMode != null ? textParsingMode.getJsBase() : null));
    }

    public Spline spline(String str, String str2) {
        return new Spline(String.format(Locale.US, this.jsBase + ".spline(%s, %s)", wrapQuotes(str), wrapQuotes(str2)));
    }

    public Spline spline(String str, TextParsingSettings textParsingSettings) {
        return new Spline(String.format(Locale.US, this.jsBase + ".spline(%s, %s)", wrapQuotes(str), textParsingSettings != null ? textParsingSettings.getJsBase() : null));
    }

    public SplineArea splineArea(View view, TextParsingMode textParsingMode) {
        return new SplineArea(String.format(Locale.US, this.jsBase + ".splineArea(%s, %s)", view != null ? view.getJsBase() : null, textParsingMode != null ? textParsingMode.getJsBase() : null));
    }

    public SplineArea splineArea(View view, String str) {
        return new SplineArea(String.format(Locale.US, this.jsBase + ".splineArea(%s, %s)", view != null ? view.getJsBase() : null, wrapQuotes(str)));
    }

    public SplineArea splineArea(View view, TextParsingSettings textParsingSettings) {
        return new SplineArea(String.format(Locale.US, this.jsBase + ".splineArea(%s, %s)", view != null ? view.getJsBase() : null, textParsingSettings != null ? textParsingSettings.getJsBase() : null));
    }

    public SplineArea splineArea(Set set, TextParsingMode textParsingMode) {
        return new SplineArea(String.format(Locale.US, this.jsBase + ".splineArea(%s, %s)", set != null ? set.getJsBase() : null, textParsingMode != null ? textParsingMode.getJsBase() : null));
    }

    public SplineArea splineArea(Set set, String str) {
        return new SplineArea(String.format(Locale.US, this.jsBase + ".splineArea(%s, %s)", set != null ? set.getJsBase() : null, wrapQuotes(str)));
    }

    public SplineArea splineArea(Set set, TextParsingSettings textParsingSettings) {
        return new SplineArea(String.format(Locale.US, this.jsBase + ".splineArea(%s, %s)", set != null ? set.getJsBase() : null, textParsingSettings != null ? textParsingSettings.getJsBase() : null));
    }

    public SplineArea splineArea(String[] strArr, TextParsingMode textParsingMode) {
        return new SplineArea(String.format(Locale.US, this.jsBase + ".splineArea(%s, %s)", arrayToStringWrapQuotes(strArr), textParsingMode != null ? textParsingMode.getJsBase() : null));
    }

    public SplineArea splineArea(String[] strArr, String str) {
        return new SplineArea(String.format(Locale.US, this.jsBase + ".splineArea(%s, %s)", arrayToStringWrapQuotes(strArr), wrapQuotes(str)));
    }

    public SplineArea splineArea(String[] strArr, TextParsingSettings textParsingSettings) {
        return new SplineArea(String.format(Locale.US, this.jsBase + ".splineArea(%s, %s)", arrayToStringWrapQuotes(strArr), textParsingSettings != null ? textParsingSettings.getJsBase() : null));
    }

    public SplineArea splineArea(String str, TextParsingMode textParsingMode) {
        return new SplineArea(String.format(Locale.US, this.jsBase + ".splineArea(%s, %s)", wrapQuotes(str), textParsingMode != null ? textParsingMode.getJsBase() : null));
    }

    public SplineArea splineArea(String str, String str2) {
        return new SplineArea(String.format(Locale.US, this.jsBase + ".splineArea(%s, %s)", wrapQuotes(str), wrapQuotes(str2)));
    }

    public SplineArea splineArea(String str, TextParsingSettings textParsingSettings) {
        return new SplineArea(String.format(Locale.US, this.jsBase + ".splineArea(%s, %s)", wrapQuotes(str), textParsingSettings != null ? textParsingSettings.getJsBase() : null));
    }

    @Override // com.anychart.core.SeparateChart, com.anychart.core.Chart
    public Cartesian startSelectMarquee(Boolean bool) {
        APIlib.getInstance().addJSLine(String.format(Locale.US, this.jsBase + ".startSelectMarquee(%s);", bool));
        return this;
    }

    public StepArea stepArea(View view, TextParsingMode textParsingMode) {
        return new StepArea(String.format(Locale.US, this.jsBase + ".stepArea(%s, %s)", view != null ? view.getJsBase() : null, textParsingMode != null ? textParsingMode.getJsBase() : null));
    }

    public StepArea stepArea(View view, String str) {
        return new StepArea(String.format(Locale.US, this.jsBase + ".stepArea(%s, %s)", view != null ? view.getJsBase() : null, wrapQuotes(str)));
    }

    public StepArea stepArea(View view, TextParsingSettings textParsingSettings) {
        return new StepArea(String.format(Locale.US, this.jsBase + ".stepArea(%s, %s)", view != null ? view.getJsBase() : null, textParsingSettings != null ? textParsingSettings.getJsBase() : null));
    }

    public StepArea stepArea(Set set, TextParsingMode textParsingMode) {
        return new StepArea(String.format(Locale.US, this.jsBase + ".stepArea(%s, %s)", set != null ? set.getJsBase() : null, textParsingMode != null ? textParsingMode.getJsBase() : null));
    }

    public StepArea stepArea(Set set, String str) {
        return new StepArea(String.format(Locale.US, this.jsBase + ".stepArea(%s, %s)", set != null ? set.getJsBase() : null, wrapQuotes(str)));
    }

    public StepArea stepArea(Set set, TextParsingSettings textParsingSettings) {
        return new StepArea(String.format(Locale.US, this.jsBase + ".stepArea(%s, %s)", set != null ? set.getJsBase() : null, textParsingSettings != null ? textParsingSettings.getJsBase() : null));
    }

    public StepArea stepArea(String[] strArr, TextParsingMode textParsingMode) {
        return new StepArea(String.format(Locale.US, this.jsBase + ".stepArea(%s, %s)", arrayToStringWrapQuotes(strArr), textParsingMode != null ? textParsingMode.getJsBase() : null));
    }

    public StepArea stepArea(String[] strArr, String str) {
        return new StepArea(String.format(Locale.US, this.jsBase + ".stepArea(%s, %s)", arrayToStringWrapQuotes(strArr), wrapQuotes(str)));
    }

    public StepArea stepArea(String[] strArr, TextParsingSettings textParsingSettings) {
        return new StepArea(String.format(Locale.US, this.jsBase + ".stepArea(%s, %s)", arrayToStringWrapQuotes(strArr), textParsingSettings != null ? textParsingSettings.getJsBase() : null));
    }

    public StepArea stepArea(String str, TextParsingMode textParsingMode) {
        return new StepArea(String.format(Locale.US, this.jsBase + ".stepArea(%s, %s)", wrapQuotes(str), textParsingMode != null ? textParsingMode.getJsBase() : null));
    }

    public StepArea stepArea(String str, String str2) {
        return new StepArea(String.format(Locale.US, this.jsBase + ".stepArea(%s, %s)", wrapQuotes(str), wrapQuotes(str2)));
    }

    public StepArea stepArea(String str, TextParsingSettings textParsingSettings) {
        return new StepArea(String.format(Locale.US, this.jsBase + ".stepArea(%s, %s)", wrapQuotes(str), textParsingSettings != null ? textParsingSettings.getJsBase() : null));
    }

    public StepLine stepLine(View view, TextParsingMode textParsingMode) {
        return new StepLine(String.format(Locale.US, this.jsBase + ".stepLine(%s, %s)", view != null ? view.getJsBase() : null, textParsingMode != null ? textParsingMode.getJsBase() : null));
    }

    public StepLine stepLine(View view, String str) {
        return new StepLine(String.format(Locale.US, this.jsBase + ".stepLine(%s, %s)", view != null ? view.getJsBase() : null, wrapQuotes(str)));
    }

    public StepLine stepLine(View view, TextParsingSettings textParsingSettings) {
        return new StepLine(String.format(Locale.US, this.jsBase + ".stepLine(%s, %s)", view != null ? view.getJsBase() : null, textParsingSettings != null ? textParsingSettings.getJsBase() : null));
    }

    public StepLine stepLine(Set set, TextParsingMode textParsingMode) {
        return new StepLine(String.format(Locale.US, this.jsBase + ".stepLine(%s, %s)", set != null ? set.getJsBase() : null, textParsingMode != null ? textParsingMode.getJsBase() : null));
    }

    public StepLine stepLine(Set set, String str) {
        return new StepLine(String.format(Locale.US, this.jsBase + ".stepLine(%s, %s)", set != null ? set.getJsBase() : null, wrapQuotes(str)));
    }

    public StepLine stepLine(Set set, TextParsingSettings textParsingSettings) {
        return new StepLine(String.format(Locale.US, this.jsBase + ".stepLine(%s, %s)", set != null ? set.getJsBase() : null, textParsingSettings != null ? textParsingSettings.getJsBase() : null));
    }

    public StepLine stepLine(String[] strArr, TextParsingMode textParsingMode) {
        return new StepLine(String.format(Locale.US, this.jsBase + ".stepLine(%s, %s)", arrayToStringWrapQuotes(strArr), textParsingMode != null ? textParsingMode.getJsBase() : null));
    }

    public StepLine stepLine(String[] strArr, String str) {
        return new StepLine(String.format(Locale.US, this.jsBase + ".stepLine(%s, %s)", arrayToStringWrapQuotes(strArr), wrapQuotes(str)));
    }

    public StepLine stepLine(String[] strArr, TextParsingSettings textParsingSettings) {
        return new StepLine(String.format(Locale.US, this.jsBase + ".stepLine(%s, %s)", arrayToStringWrapQuotes(strArr), textParsingSettings != null ? textParsingSettings.getJsBase() : null));
    }

    public StepLine stepLine(String str, TextParsingMode textParsingMode) {
        return new StepLine(String.format(Locale.US, this.jsBase + ".stepLine(%s, %s)", wrapQuotes(str), textParsingMode != null ? textParsingMode.getJsBase() : null));
    }

    public StepLine stepLine(String str, String str2) {
        return new StepLine(String.format(Locale.US, this.jsBase + ".stepLine(%s, %s)", wrapQuotes(str), wrapQuotes(str2)));
    }

    public StepLine stepLine(String str, TextParsingSettings textParsingSettings) {
        return new StepLine(String.format(Locale.US, this.jsBase + ".stepLine(%s, %s)", wrapQuotes(str), textParsingSettings != null ? textParsingSettings.getJsBase() : null));
    }

    public Stick stick(View view, TextParsingMode textParsingMode) {
        return new Stick(String.format(Locale.US, this.jsBase + ".stick(%s, %s)", view != null ? view.getJsBase() : null, textParsingMode != null ? textParsingMode.getJsBase() : null));
    }

    public Stick stick(View view, String str) {
        return new Stick(String.format(Locale.US, this.jsBase + ".stick(%s, %s)", view != null ? view.getJsBase() : null, wrapQuotes(str)));
    }

    public Stick stick(View view, TextParsingSettings textParsingSettings) {
        return new Stick(String.format(Locale.US, this.jsBase + ".stick(%s, %s)", view != null ? view.getJsBase() : null, textParsingSettings != null ? textParsingSettings.getJsBase() : null));
    }

    public Stick stick(Set set, TextParsingMode textParsingMode) {
        return new Stick(String.format(Locale.US, this.jsBase + ".stick(%s, %s)", set != null ? set.getJsBase() : null, textParsingMode != null ? textParsingMode.getJsBase() : null));
    }

    public Stick stick(Set set, String str) {
        return new Stick(String.format(Locale.US, this.jsBase + ".stick(%s, %s)", set != null ? set.getJsBase() : null, wrapQuotes(str)));
    }

    public Stick stick(Set set, TextParsingSettings textParsingSettings) {
        return new Stick(String.format(Locale.US, this.jsBase + ".stick(%s, %s)", set != null ? set.getJsBase() : null, textParsingSettings != null ? textParsingSettings.getJsBase() : null));
    }

    public Stick stick(String[] strArr, TextParsingMode textParsingMode) {
        return new Stick(String.format(Locale.US, this.jsBase + ".stick(%s, %s)", arrayToStringWrapQuotes(strArr), textParsingMode != null ? textParsingMode.getJsBase() : null));
    }

    public Stick stick(String[] strArr, String str) {
        return new Stick(String.format(Locale.US, this.jsBase + ".stick(%s, %s)", arrayToStringWrapQuotes(strArr), wrapQuotes(str)));
    }

    public Stick stick(String[] strArr, TextParsingSettings textParsingSettings) {
        return new Stick(String.format(Locale.US, this.jsBase + ".stick(%s, %s)", arrayToStringWrapQuotes(strArr), textParsingSettings != null ? textParsingSettings.getJsBase() : null));
    }

    public Stick stick(String str, TextParsingMode textParsingMode) {
        return new Stick(String.format(Locale.US, this.jsBase + ".stick(%s, %s)", wrapQuotes(str), textParsingMode != null ? textParsingMode.getJsBase() : null));
    }

    public Stick stick(String str, String str2) {
        return new Stick(String.format(Locale.US, this.jsBase + ".stick(%s, %s)", wrapQuotes(str), wrapQuotes(str2)));
    }

    public Stick stick(String str, TextParsingSettings textParsingSettings) {
        return new Stick(String.format(Locale.US, this.jsBase + ".stick(%s, %s)", wrapQuotes(str), textParsingSettings != null ? textParsingSettings.getJsBase() : null));
    }

    public Text textMarker(Number number) {
        return new Text(String.format(Locale.US, this.jsBase + ".textMarker(%s)", number));
    }

    public Cartesian textMarker(String str) {
        APIlib.getInstance().addJSLine(String.format(Locale.US, this.jsBase + ".textMarker(%s);", wrapQuotes(str)));
        return this;
    }

    public Cartesian textMarker(Boolean bool) {
        APIlib.getInstance().addJSLine(String.format(Locale.US, this.jsBase + ".textMarker(%s);", bool));
        return this;
    }

    public Cartesian textMarker(Number number, String str) {
        APIlib.getInstance().addJSLine(String.format(Locale.US, this.jsBase + ".textMarker(%s, %s);", number, wrapQuotes(str)));
        return this;
    }

    public Cartesian textMarker(Number number, Boolean bool) {
        APIlib.getInstance().addJSLine(String.format(Locale.US, this.jsBase + ".textMarker(%s, %s);", number, bool));
        return this;
    }

    @Override // com.anychart.core.SeparateChart, com.anychart.core.Chart
    public Title title() {
        return new Title(this.jsBase + ".title()");
    }

    @Override // com.anychart.core.SeparateChart, com.anychart.core.Chart
    public Cartesian title(Boolean bool) {
        APIlib.getInstance().addJSLine(String.format(Locale.US, this.jsBase + ".title(%s);", bool));
        return this;
    }

    @Override // com.anychart.core.SeparateChart, com.anychart.core.Chart
    public Cartesian title(String str) {
        APIlib.getInstance().addJSLine(String.format(Locale.US, this.jsBase + ".title(%s);", wrapQuotes(str)));
        return this;
    }

    @Override // com.anychart.core.SeparateChart, com.anychart.core.Chart
    public void toJson(Boolean bool) {
        APIlib.getInstance().addJSLine(String.format(Locale.US, this.jsBase + ".toJson(%s);", bool));
    }

    @Override // com.anychart.core.SeparateChart, com.anychart.core.Chart
    public void toSvg(String str, Boolean bool) {
        APIlib.getInstance().addJSLine(String.format(Locale.US, this.jsBase + ".toSvg(%s, %s);", wrapQuotes(str), bool));
    }

    @Override // com.anychart.core.SeparateChart, com.anychart.core.Chart
    public void toSvg(Number number, Number number2) {
        APIlib.getInstance().addJSLine(String.format(Locale.US, this.jsBase + ".toSvg(%s, %s);", number, number2));
    }

    @Override // com.anychart.core.SeparateChart, com.anychart.core.Chart
    public void toXml(Boolean bool) {
        APIlib.getInstance().addJSLine(String.format(Locale.US, this.jsBase + ".toXml(%s);", bool));
    }

    @Override // com.anychart.core.SeparateChart, com.anychart.core.Chart
    public Tooltip tooltip() {
        return new Tooltip(this.jsBase + ".tooltip()");
    }

    @Override // com.anychart.core.SeparateChart, com.anychart.core.Chart
    public Cartesian tooltip(String str) {
        APIlib.getInstance().addJSLine(String.format(Locale.US, this.jsBase + ".tooltip(%s);", wrapQuotes(str)));
        return this;
    }

    @Override // com.anychart.core.SeparateChart, com.anychart.core.Chart
    public Cartesian tooltip(Boolean bool) {
        APIlib.getInstance().addJSLine(String.format(Locale.US, this.jsBase + ".tooltip(%s);", bool));
        return this;
    }

    @Override // com.anychart.core.SeparateChart, com.anychart.core.Chart, com.anychart.core.VisualBaseWithBounds
    public void top() {
        APIlib.getInstance().addJSLine(this.jsBase + ".top();");
    }

    @Override // com.anychart.core.SeparateChart, com.anychart.core.Chart, com.anychart.core.VisualBaseWithBounds
    public Cartesian top(Number number) {
        APIlib.getInstance().addJSLine(String.format(Locale.US, this.jsBase + ".top(%s);", number));
        return this;
    }

    @Override // com.anychart.core.SeparateChart, com.anychart.core.Chart, com.anychart.core.VisualBaseWithBounds
    public Cartesian top(String str) {
        APIlib.getInstance().addJSLine(String.format(Locale.US, this.jsBase + ".top(%s);", wrapQuotes(str)));
        return this;
    }

    @Override // com.anychart.core.SeparateChart, com.anychart.core.Chart, com.anychart.core.VisualBaseWithBounds, com.anychart.core.VisualBase, com.anychart.core.Base
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

    @Override // com.anychart.core.SeparateChart, com.anychart.core.Chart, com.anychart.core.VisualBaseWithBounds, com.anychart.core.VisualBase, com.anychart.core.Base
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

    @Override // com.anychart.core.SeparateChart, com.anychart.core.Chart, com.anychart.core.VisualBaseWithBounds, com.anychart.core.VisualBase, com.anychart.core.Base
    public void unlistenByKey(String str) {
        APIlib.getInstance().addJSLine(String.format(Locale.US, this.jsBase + ".unlistenByKey(%s);", wrapQuotes(str)));
    }

    @Override // com.anychart.core.SeparateChart, com.anychart.core.Chart, com.anychart.core.VisualBaseWithBounds
    public void width() {
        APIlib.getInstance().addJSLine(this.jsBase + ".width();");
    }

    @Override // com.anychart.core.SeparateChart, com.anychart.core.Chart, com.anychart.core.VisualBaseWithBounds
    public Cartesian width(Number number) {
        APIlib.getInstance().addJSLine(String.format(Locale.US, this.jsBase + ".width(%s);", number));
        return this;
    }

    @Override // com.anychart.core.SeparateChart, com.anychart.core.Chart, com.anychart.core.VisualBaseWithBounds
    public Cartesian width(String str) {
        APIlib.getInstance().addJSLine(String.format(Locale.US, this.jsBase + ".width(%s);", wrapQuotes(str)));
        return this;
    }

    public Linear xAxis(Number number) {
        return new Linear(String.format(Locale.US, this.jsBase + ".xAxis(%s)", number));
    }

    public Cartesian xAxis(String str) {
        APIlib.getInstance().addJSLine(String.format(Locale.US, this.jsBase + ".xAxis(%s);", wrapQuotes(str)));
        return this;
    }

    public Cartesian xAxis(Boolean bool) {
        APIlib.getInstance().addJSLine(String.format(Locale.US, this.jsBase + ".xAxis(%s);", bool));
        return this;
    }

    public Cartesian xAxis(Number number, String str) {
        APIlib.getInstance().addJSLine(String.format(Locale.US, this.jsBase + ".xAxis(%s, %s);", number, wrapQuotes(str)));
        return this;
    }

    public Cartesian xAxis(Number number, Boolean bool) {
        APIlib.getInstance().addJSLine(String.format(Locale.US, this.jsBase + ".xAxis(%s, %s);", number, bool));
        return this;
    }

    public com.anychart.core.grids.Linear xGrid(Number number) {
        return new com.anychart.core.grids.Linear(String.format(Locale.US, this.jsBase + ".xGrid(%s)", number));
    }

    public Cartesian xGrid(String str) {
        APIlib.getInstance().addJSLine(String.format(Locale.US, this.jsBase + ".xGrid(%s);", wrapQuotes(str)));
        return this;
    }

    public Cartesian xGrid(Boolean bool) {
        APIlib.getInstance().addJSLine(String.format(Locale.US, this.jsBase + ".xGrid(%s);", bool));
        return this;
    }

    public Cartesian xGrid(Number number, String str) {
        APIlib.getInstance().addJSLine(String.format(Locale.US, this.jsBase + ".xGrid(%s, %s);", number, wrapQuotes(str)));
        return this;
    }

    public Cartesian xGrid(Number number, Boolean bool) {
        APIlib.getInstance().addJSLine(String.format(Locale.US, this.jsBase + ".xGrid(%s, %s);", number, bool));
        return this;
    }

    public com.anychart.core.grids.Linear xMinorGrid(Number number) {
        return new com.anychart.core.grids.Linear(String.format(Locale.US, this.jsBase + ".xMinorGrid(%s)", number));
    }

    public Cartesian xMinorGrid(String str) {
        APIlib.getInstance().addJSLine(String.format(Locale.US, this.jsBase + ".xMinorGrid(%s);", wrapQuotes(str)));
        return this;
    }

    public Cartesian xMinorGrid(Boolean bool) {
        APIlib.getInstance().addJSLine(String.format(Locale.US, this.jsBase + ".xMinorGrid(%s);", bool));
        return this;
    }

    public Cartesian xMinorGrid(Number number, String str) {
        APIlib.getInstance().addJSLine(String.format(Locale.US, this.jsBase + ".xMinorGrid(%s, %s);", number, wrapQuotes(str)));
        return this;
    }

    public Cartesian xMinorGrid(Number number, Boolean bool) {
        APIlib.getInstance().addJSLine(String.format(Locale.US, this.jsBase + ".xMinorGrid(%s, %s);", number, bool));
        return this;
    }

    public com.anychart.scales.Base xScale() {
        return new com.anychart.scales.Base(this.jsBase + ".xScale()");
    }

    public Cartesian xScale(String str) {
        APIlib.getInstance().addJSLine(String.format(Locale.US, this.jsBase + ".xScale(%s);", wrapQuotes(str)));
        return this;
    }

    public Cartesian xScale(ScaleTypes scaleTypes) {
        APIlib.getInstance().addJSLine(String.format(Locale.US, this.jsBase + ".xScale(%s);", scaleTypes != null ? scaleTypes.getJsBase() : null));
        return this;
    }

    public Cartesian xScale(com.anychart.scales.Base base) {
        APIlib.getInstance().addJSLine(String.format(Locale.US, this.jsBase + ".xScale(%s);", base != null ? base.getJsBase() : null));
        return this;
    }

    public ChartScroller xScroller() {
        return new ChartScroller(this.jsBase + ".xScroller()");
    }

    public Cartesian xScroller(String str) {
        APIlib.getInstance().addJSLine(String.format(Locale.US, this.jsBase + ".xScroller(%s);", wrapQuotes(str)));
        return this;
    }

    public Cartesian xScroller(Boolean bool) {
        APIlib.getInstance().addJSLine(String.format(Locale.US, this.jsBase + ".xScroller(%s);", bool));
        return this;
    }

    public OrdinalZoom xZoom() {
        return new OrdinalZoom(this.jsBase + ".xZoom()");
    }

    public Cartesian xZoom(Number number) {
        APIlib.getInstance().addJSLine(String.format(Locale.US, this.jsBase + ".xZoom(%s);", number));
        return this;
    }

    public Cartesian xZoom(Boolean bool) {
        APIlib.getInstance().addJSLine(String.format(Locale.US, this.jsBase + ".xZoom(%s);", bool));
        return this;
    }

    public Cartesian xZoom(String str) {
        APIlib.getInstance().addJSLine(String.format(Locale.US, this.jsBase + ".xZoom(%s);", wrapQuotes(str)));
        return this;
    }

    public Linear yAxis(Number number) {
        return new Linear(String.format(Locale.US, this.jsBase + ".yAxis(%s)", number));
    }

    public Cartesian yAxis(String str) {
        APIlib.getInstance().addJSLine(String.format(Locale.US, this.jsBase + ".yAxis(%s);", wrapQuotes(str)));
        return this;
    }

    public Cartesian yAxis(Boolean bool) {
        APIlib.getInstance().addJSLine(String.format(Locale.US, this.jsBase + ".yAxis(%s);", bool));
        return this;
    }

    public Cartesian yAxis(Number number, String str) {
        APIlib.getInstance().addJSLine(String.format(Locale.US, this.jsBase + ".yAxis(%s, %s);", number, wrapQuotes(str)));
        return this;
    }

    public Cartesian yAxis(Number number, Boolean bool) {
        APIlib.getInstance().addJSLine(String.format(Locale.US, this.jsBase + ".yAxis(%s, %s);", number, bool));
        return this;
    }

    public com.anychart.core.grids.Linear yGrid(Number number) {
        return new com.anychart.core.grids.Linear(String.format(Locale.US, this.jsBase + ".yGrid(%s)", number));
    }

    public Cartesian yGrid(String str) {
        APIlib.getInstance().addJSLine(String.format(Locale.US, this.jsBase + ".yGrid(%s);", wrapQuotes(str)));
        return this;
    }

    public Cartesian yGrid(Boolean bool) {
        APIlib.getInstance().addJSLine(String.format(Locale.US, this.jsBase + ".yGrid(%s);", bool));
        return this;
    }

    public Cartesian yGrid(Number number, String str) {
        APIlib.getInstance().addJSLine(String.format(Locale.US, this.jsBase + ".yGrid(%s, %s);", number, wrapQuotes(str)));
        return this;
    }

    public Cartesian yGrid(Number number, Boolean bool) {
        APIlib.getInstance().addJSLine(String.format(Locale.US, this.jsBase + ".yGrid(%s, %s);", number, bool));
        return this;
    }

    public com.anychart.core.grids.Linear yMinorGrid(Number number) {
        return new com.anychart.core.grids.Linear(String.format(Locale.US, this.jsBase + ".yMinorGrid(%s)", number));
    }

    public Cartesian yMinorGrid(String str) {
        APIlib.getInstance().addJSLine(String.format(Locale.US, this.jsBase + ".yMinorGrid(%s);", wrapQuotes(str)));
        return this;
    }

    public Cartesian yMinorGrid(Boolean bool) {
        APIlib.getInstance().addJSLine(String.format(Locale.US, this.jsBase + ".yMinorGrid(%s);", bool));
        return this;
    }

    public Cartesian yMinorGrid(Number number, String str) {
        APIlib.getInstance().addJSLine(String.format(Locale.US, this.jsBase + ".yMinorGrid(%s, %s);", number, wrapQuotes(str)));
        return this;
    }

    public Cartesian yMinorGrid(Number number, Boolean bool) {
        APIlib.getInstance().addJSLine(String.format(Locale.US, this.jsBase + ".yMinorGrid(%s, %s);", number, bool));
        return this;
    }

    public com.anychart.scales.Linear yScale() {
        return new com.anychart.scales.Linear(this.jsBase + ".yScale()");
    }

    public Cartesian yScale(String str) {
        APIlib.getInstance().addJSLine(String.format(Locale.US, this.jsBase + ".yScale(%s);", wrapQuotes(str)));
        return this;
    }

    public Cartesian yScale(ScaleTypes scaleTypes) {
        APIlib.getInstance().addJSLine(String.format(Locale.US, this.jsBase + ".yScale(%s);", scaleTypes != null ? scaleTypes.getJsBase() : null));
        return this;
    }

    public Cartesian yScale(com.anychart.scales.Base base) {
        APIlib.getInstance().addJSLine(String.format(Locale.US, this.jsBase + ".yScale(%s);", base != null ? base.getJsBase() : null));
        return this;
    }

    @Override // com.anychart.core.SeparateChart, com.anychart.core.Chart, com.anychart.core.VisualBaseWithBounds, com.anychart.core.VisualBase
    public void zIndex() {
        APIlib.getInstance().addJSLine(this.jsBase + ".zIndex();");
    }

    @Override // com.anychart.core.SeparateChart, com.anychart.core.Chart, com.anychart.core.VisualBaseWithBounds, com.anychart.core.VisualBase
    public Cartesian zIndex(Number number) {
        APIlib.getInstance().addJSLine(String.format(Locale.US, this.jsBase + ".zIndex(%s);", number));
        return this;
    }

    @Override // com.anychart.core.SeparateChart, com.anychart.core.Chart
    public void toA11yTable(String str, Boolean bool) {
        APIlib.getInstance().addJSLine(String.format(Locale.US, this.jsBase + ".toA11yTable(%s, %s);", wrapQuotes(str), bool));
    }

    @Override // com.anychart.core.SeparateChart, com.anychart.core.Chart
    public void toHtmlTable(String str, Boolean bool) {
        APIlib.getInstance().addJSLine(String.format(Locale.US, this.jsBase + ".toHtmlTable(%s, %s);", wrapQuotes(str), bool));
    }

    @Override // com.anychart.core.SeparateChart, com.anychart.core.Chart, com.anychart.core.VisualBaseWithBounds, com.anychart.core.VisualBase
    public Rect parentBounds() {
        return new Rect(this.jsBase + ".parentBounds()");
    }

    @Override // com.anychart.core.SeparateChart, com.anychart.core.Chart, com.anychart.core.VisualBaseWithBounds, com.anychart.core.VisualBase
    public Cartesian parentBounds(Rect rect) {
        APIlib.getInstance().addJSLine(String.format(Locale.US, this.jsBase + ".parentBounds(%s);", rect != null ? rect.getJsBase() : null));
        return this;
    }

    @Override // com.anychart.core.SeparateChart, com.anychart.core.Chart, com.anychart.core.VisualBaseWithBounds, com.anychart.core.VisualBase
    public Cartesian parentBounds(String str) {
        APIlib.getInstance().addJSLine(String.format(Locale.US, this.jsBase + ".parentBounds(%s);", wrapQuotes(str)));
        return this;
    }

    @Override // com.anychart.core.SeparateChart, com.anychart.core.Chart, com.anychart.core.VisualBaseWithBounds, com.anychart.core.VisualBase
    public Cartesian parentBounds(Number number) {
        APIlib.getInstance().addJSLine(String.format(Locale.US, this.jsBase + ".parentBounds(%s);", number));
        return this;
    }

    @Override // com.anychart.core.SeparateChart, com.anychart.core.Chart, com.anychart.core.VisualBaseWithBounds, com.anychart.core.VisualBase
    public Cartesian parentBounds(Number number, Number number2, Number number3, Number number4) {
        APIlib.getInstance().addJSLine(String.format(Locale.US, this.jsBase + ".parentBounds(%s, %s, %s, %s);", number, number2, number3, number4));
        return this;
    }

    public View data(View view) {
        return new View(String.format(Locale.US, this.jsBase + ".data(%s)", view != null ? view.getJsBase() : null));
    }

    public View data(List<DataEntry> list, TreeFillingMethod treeFillingMethod) {
        return new View(String.format(Locale.US, this.jsBase + ".data(%s, %s)", arrayToString(list), treeFillingMethod != null ? treeFillingMethod.getJsBase() : null));
    }

    public View data(List<DataEntry> list, String str) {
        return new View(String.format(Locale.US, this.jsBase + ".data(%s, %s)", arrayToString(list), wrapQuotes(str)));
    }

    public Area area(View view) {
        return new Area(String.format(Locale.US, this.jsBase + ".area(%s)", view != null ? view.getJsBase() : null));
    }

    public Bar bar(View view) {
        return new Bar(String.format(Locale.US, this.jsBase + ".bar(%s)", view != null ? view.getJsBase() : null));
    }

    public Box box(View view) {
        return new Box(String.format(Locale.US, this.jsBase + ".box(%s)", view != null ? view.getJsBase() : null));
    }

    public Bubble bubble(View view) {
        return new Bubble(String.format(Locale.US, this.jsBase + ".bubble(%s)", view != null ? view.getJsBase() : null));
    }

    public Column column(View view) {
        return new Column(String.format(Locale.US, this.jsBase + ".column(%s)", view != null ? view.getJsBase() : null));
    }

    public Line line(View view) {
        return new Line(String.format(Locale.US, this.jsBase + ".line(%s)", view != null ? view.getJsBase() : null));
    }

    public RangeColumn rangeColumn(View view) {
        return new RangeColumn(String.format(Locale.US, this.jsBase + ".rangeColumn(%s)", view != null ? view.getJsBase() : null));
    }

    public RangeBar rangeBar(View view) {
        return new RangeBar(String.format(Locale.US, this.jsBase + ".rangeBar(%s)", view != null ? view.getJsBase() : null));
    }

    public JumpLine jumpLine(View view) {
        return new JumpLine(String.format(Locale.US, this.jsBase + ".jumpLine(%s)", view != null ? view.getJsBase() : null));
    }

    public Marker marker(View view) {
        return new Marker(String.format(Locale.US, this.jsBase + ".marker(%s)", view != null ? view.getJsBase() : null));
    }

    public Hilo hilo(View view) {
        return new Hilo(String.format(Locale.US, this.jsBase + ".hilo(%s)", view != null ? view.getJsBase() : null));
    }

    public OHLC ohlc(View view) {
        return new OHLC(String.format(Locale.US, this.jsBase + ".ohlc(%s)", view != null ? view.getJsBase() : null));
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
