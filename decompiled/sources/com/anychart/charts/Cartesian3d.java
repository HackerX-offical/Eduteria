package com.anychart.charts;

import com.amazonaws.services.s3.model.InstructionFileId;
import com.anychart.APIlib;
import com.anychart.chart.common.dataentry.DataEntry;
import com.anychart.chart.common.listener.ListenersInterface;
import com.anychart.core.NoDataSettings;
import com.anychart.core.SeparateChart;
import com.anychart.core.StateSettings;
import com.anychart.core.axes.Linear;
import com.anychart.core.axismarkers.Range;
import com.anychart.core.axismarkers.Text;
import com.anychart.core.cartesian.series.Area3d;
import com.anychart.core.cartesian.series.Bar3d;
import com.anychart.core.cartesian.series.Base;
import com.anychart.core.cartesian.series.Column3d;
import com.anychart.core.cartesian.series.Line;
import com.anychart.core.cartesian.series.Line3d;
import com.anychart.core.ui.Background;
import com.anychart.core.ui.ChartCredits;
import com.anychart.core.ui.ChartScroller;
import com.anychart.core.ui.Crosshair;
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
import com.anychart.palettes.RangeColors;
import com.anychart.scales.Ordinal;
import com.anychart.ui.ContextMenu;
import com.anychart.utils.RectObj;
import java.lang.reflect.InvocationTargetException;
import java.util.Arrays;
import java.util.List;
import java.util.Locale;

/* JADX INFO: loaded from: classes4.dex */
public class Cartesian3d extends SeparateChart {
    protected Cartesian3d() {
    }

    public static Cartesian3d instantiate() {
        return new Cartesian3d("new anychart.charts.cartesian3d()");
    }

    public Cartesian3d(String str) {
        StringBuilder sb = new StringBuilder("cartesian3d");
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
    public Cartesian3d a11y(Boolean bool) {
        APIlib.getInstance().addJSLine(String.format(Locale.US, this.jsBase + ".a11y(%s);", bool));
        return this;
    }

    @Override // com.anychart.core.SeparateChart, com.anychart.core.Chart
    public Cartesian3d a11y(String str) {
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
    public Cartesian3d animation(Boolean bool) {
        APIlib.getInstance().addJSLine(String.format(Locale.US, this.jsBase + ".animation(%s);", bool));
        return this;
    }

    @Override // com.anychart.core.SeparateChart, com.anychart.core.Chart
    public Cartesian3d animation(String str) {
        APIlib.getInstance().addJSLine(String.format(Locale.US, this.jsBase + ".animation(%s);", wrapQuotes(str)));
        return this;
    }

    @Override // com.anychart.core.SeparateChart, com.anychart.core.Chart
    public Cartesian3d animation(Boolean bool, Number number) {
        APIlib.getInstance().addJSLine(String.format(Locale.US, this.jsBase + ".animation(%s, %s);", bool, number));
        return this;
    }

    public Area3d area(List<DataEntry> list) {
        return new Area3d(String.format(Locale.US, this.jsBase + ".area(%s)", arrayToString(list)));
    }

    @Override // com.anychart.core.SeparateChart, com.anychart.core.Chart
    public void autoRedraw() {
        APIlib.getInstance().addJSLine(this.jsBase + ".autoRedraw();");
    }

    @Override // com.anychart.core.SeparateChart, com.anychart.core.Chart
    public Cartesian3d autoRedraw(Boolean bool) {
        APIlib.getInstance().addJSLine(String.format(Locale.US, this.jsBase + ".autoRedraw(%s);", bool));
        return this;
    }

    @Override // com.anychart.core.SeparateChart, com.anychart.core.Chart
    public Background background() {
        return new Background(this.jsBase + ".background()");
    }

    @Override // com.anychart.core.SeparateChart, com.anychart.core.Chart
    public Cartesian3d background(String str) {
        APIlib.getInstance().addJSLine(String.format(Locale.US, this.jsBase + ".background(%s);", wrapQuotes(str)));
        return this;
    }

    public Bar3d bar(List<DataEntry> list) {
        return new Bar3d(String.format(Locale.US, this.jsBase + ".bar(%s)", arrayToString(list)));
    }

    public void barGroupsPadding() {
        APIlib.getInstance().addJSLine(this.jsBase + ".barGroupsPadding();");
    }

    public Cartesian3d barGroupsPadding(Number number) {
        APIlib.getInstance().addJSLine(String.format(Locale.US, this.jsBase + ".barGroupsPadding(%s);", number));
        return this;
    }

    public void barsPadding() {
        APIlib.getInstance().addJSLine(this.jsBase + ".barsPadding();");
    }

    public Cartesian3d barsPadding(Number number) {
        APIlib.getInstance().addJSLine(String.format(Locale.US, this.jsBase + ".barsPadding(%s);", number));
        return this;
    }

    public void baseline() {
        APIlib.getInstance().addJSLine(this.jsBase + ".baseline();");
    }

    public Cartesian3d baseline(Number number) {
        APIlib.getInstance().addJSLine(String.format(Locale.US, this.jsBase + ".baseline(%s);", number));
        return this;
    }

    @Override // com.anychart.core.SeparateChart, com.anychart.core.Chart, com.anychart.core.VisualBaseWithBounds
    public void bottom() {
        APIlib.getInstance().addJSLine(this.jsBase + ".bottom();");
    }

    @Override // com.anychart.core.SeparateChart, com.anychart.core.Chart, com.anychart.core.VisualBaseWithBounds
    public Cartesian3d bottom(Number number) {
        APIlib.getInstance().addJSLine(String.format(Locale.US, this.jsBase + ".bottom(%s);", number));
        return this;
    }

    @Override // com.anychart.core.SeparateChart, com.anychart.core.Chart, com.anychart.core.VisualBaseWithBounds
    public Cartesian3d bottom(String str) {
        APIlib.getInstance().addJSLine(String.format(Locale.US, this.jsBase + ".bottom(%s);", wrapQuotes(str)));
        return this;
    }

    @Override // com.anychart.core.SeparateChart, com.anychart.core.Chart, com.anychart.core.VisualBaseWithBounds
    public Bounds bounds() {
        return new Bounds(this.jsBase + ".bounds()");
    }

    @Override // com.anychart.core.SeparateChart, com.anychart.core.Chart, com.anychart.core.VisualBaseWithBounds
    public Cartesian3d bounds(RectObj rectObj) {
        APIlib.getInstance().addJSLine(String.format(Locale.US, this.jsBase + ".bounds(%s);", rectObj != null ? rectObj.getJsBase() : null));
        return this;
    }

    @Override // com.anychart.core.SeparateChart, com.anychart.core.Chart, com.anychart.core.VisualBaseWithBounds
    public Cartesian3d bounds(Rect rect) {
        APIlib.getInstance().addJSLine(String.format(Locale.US, this.jsBase + ".bounds(%s);", rect != null ? rect.getJsBase() : null));
        return this;
    }

    @Override // com.anychart.core.SeparateChart, com.anychart.core.Chart, com.anychart.core.VisualBaseWithBounds
    public Cartesian3d bounds(Bounds bounds) {
        APIlib.getInstance().addJSLine(String.format(Locale.US, this.jsBase + ".bounds(%s);", bounds != null ? bounds.getJsBase() : null));
        return this;
    }

    @Override // com.anychart.core.SeparateChart, com.anychart.core.Chart, com.anychart.core.VisualBaseWithBounds
    public Cartesian3d bounds(Number number, Number number2, Number number3, Number number4) {
        APIlib.getInstance().addJSLine(String.format(Locale.US, this.jsBase + ".bounds(%s, %s, %s, %s);", number, number2, number3, number4));
        return this;
    }

    @Override // com.anychart.core.SeparateChart, com.anychart.core.Chart, com.anychart.core.VisualBaseWithBounds
    public Cartesian3d bounds(Number number, Number number2, Number number3, String str) {
        APIlib.getInstance().addJSLine(String.format(Locale.US, this.jsBase + ".bounds(%s, %s, %s, %s);", number, number2, number3, wrapQuotes(str)));
        return this;
    }

    @Override // com.anychart.core.SeparateChart, com.anychart.core.Chart, com.anychart.core.VisualBaseWithBounds
    public Cartesian3d bounds(Number number, Number number2, String str, Number number3) {
        APIlib.getInstance().addJSLine(String.format(Locale.US, this.jsBase + ".bounds(%s, %s, %s, %s);", number, number2, wrapQuotes(str), number3));
        return this;
    }

    @Override // com.anychart.core.SeparateChart, com.anychart.core.Chart, com.anychart.core.VisualBaseWithBounds
    public Cartesian3d bounds(Number number, Number number2, String str, String str2) {
        APIlib.getInstance().addJSLine(String.format(Locale.US, this.jsBase + ".bounds(%s, %s, %s, %s);", number, number2, wrapQuotes(str), wrapQuotes(str2)));
        return this;
    }

    @Override // com.anychart.core.SeparateChart, com.anychart.core.Chart, com.anychart.core.VisualBaseWithBounds
    public Cartesian3d bounds(Number number, String str, Number number2, Number number3) {
        APIlib.getInstance().addJSLine(String.format(Locale.US, this.jsBase + ".bounds(%s, %s, %s, %s);", number, wrapQuotes(str), number2, number3));
        return this;
    }

    @Override // com.anychart.core.SeparateChart, com.anychart.core.Chart, com.anychart.core.VisualBaseWithBounds
    public Cartesian3d bounds(Number number, String str, Number number2, String str2) {
        APIlib.getInstance().addJSLine(String.format(Locale.US, this.jsBase + ".bounds(%s, %s, %s, %s);", number, wrapQuotes(str), number2, wrapQuotes(str2)));
        return this;
    }

    @Override // com.anychart.core.SeparateChart, com.anychart.core.Chart, com.anychart.core.VisualBaseWithBounds
    public Cartesian3d bounds(Number number, String str, String str2, Number number2) {
        APIlib.getInstance().addJSLine(String.format(Locale.US, this.jsBase + ".bounds(%s, %s, %s, %s);", number, wrapQuotes(str), wrapQuotes(str2), number2));
        return this;
    }

    @Override // com.anychart.core.SeparateChart, com.anychart.core.Chart, com.anychart.core.VisualBaseWithBounds
    public Cartesian3d bounds(Number number, String str, String str2, String str3) {
        APIlib.getInstance().addJSLine(String.format(Locale.US, this.jsBase + ".bounds(%s, %s, %s, %s);", number, wrapQuotes(str), wrapQuotes(str2), wrapQuotes(str3)));
        return this;
    }

    @Override // com.anychart.core.SeparateChart, com.anychart.core.Chart, com.anychart.core.VisualBaseWithBounds
    public Cartesian3d bounds(String str, Number number, Number number2, Number number3) {
        APIlib.getInstance().addJSLine(String.format(Locale.US, this.jsBase + ".bounds(%s, %s, %s, %s);", wrapQuotes(str), number, number2, number3));
        return this;
    }

    @Override // com.anychart.core.SeparateChart, com.anychart.core.Chart, com.anychart.core.VisualBaseWithBounds
    public Cartesian3d bounds(String str, Number number, Number number2, String str2) {
        APIlib.getInstance().addJSLine(String.format(Locale.US, this.jsBase + ".bounds(%s, %s, %s, %s);", wrapQuotes(str), number, number2, wrapQuotes(str2)));
        return this;
    }

    @Override // com.anychart.core.SeparateChart, com.anychart.core.Chart, com.anychart.core.VisualBaseWithBounds
    public Cartesian3d bounds(String str, Number number, String str2, Number number2) {
        APIlib.getInstance().addJSLine(String.format(Locale.US, this.jsBase + ".bounds(%s, %s, %s, %s);", wrapQuotes(str), number, wrapQuotes(str2), number2));
        return this;
    }

    @Override // com.anychart.core.SeparateChart, com.anychart.core.Chart, com.anychart.core.VisualBaseWithBounds
    public Cartesian3d bounds(String str, Number number, String str2, String str3) {
        APIlib.getInstance().addJSLine(String.format(Locale.US, this.jsBase + ".bounds(%s, %s, %s, %s);", wrapQuotes(str), number, wrapQuotes(str2), wrapQuotes(str3)));
        return this;
    }

    @Override // com.anychart.core.SeparateChart, com.anychart.core.Chart, com.anychart.core.VisualBaseWithBounds
    public Cartesian3d bounds(String str, String str2, Number number, Number number2) {
        APIlib.getInstance().addJSLine(String.format(Locale.US, this.jsBase + ".bounds(%s, %s, %s, %s);", wrapQuotes(str), wrapQuotes(str2), number, number2));
        return this;
    }

    @Override // com.anychart.core.SeparateChart, com.anychart.core.Chart, com.anychart.core.VisualBaseWithBounds
    public Cartesian3d bounds(String str, String str2, Number number, String str3) {
        APIlib.getInstance().addJSLine(String.format(Locale.US, this.jsBase + ".bounds(%s, %s, %s, %s);", wrapQuotes(str), wrapQuotes(str2), number, wrapQuotes(str3)));
        return this;
    }

    @Override // com.anychart.core.SeparateChart, com.anychart.core.Chart, com.anychart.core.VisualBaseWithBounds
    public Cartesian3d bounds(String str, String str2, String str3, Number number) {
        APIlib.getInstance().addJSLine(String.format(Locale.US, this.jsBase + ".bounds(%s, %s, %s, %s);", wrapQuotes(str), wrapQuotes(str2), wrapQuotes(str3), number));
        return this;
    }

    @Override // com.anychart.core.SeparateChart, com.anychart.core.Chart, com.anychart.core.VisualBaseWithBounds
    public Cartesian3d bounds(String str, String str2, String str3, String str4) {
        APIlib.getInstance().addJSLine(String.format(Locale.US, this.jsBase + ".bounds(%s, %s, %s, %s);", wrapQuotes(str), wrapQuotes(str2), wrapQuotes(str3), wrapQuotes(str4)));
        return this;
    }

    @Override // com.anychart.core.SeparateChart, com.anychart.core.Chart
    public Cartesian3d cancelMarquee() {
        APIlib.getInstance().addJSLine(this.jsBase + ".cancelMarquee();");
        return this;
    }

    public Column3d column(List<DataEntry> list) {
        return new Column3d(String.format(Locale.US, this.jsBase + ".column(%s)", arrayToString(list)));
    }

    @Override // com.anychart.core.SeparateChart, com.anychart.core.Chart, com.anychart.core.VisualBaseWithBounds, com.anychart.core.VisualBase
    public Layer container() {
        return new Layer(this.jsBase + ".container()");
    }

    @Override // com.anychart.core.SeparateChart, com.anychart.core.Chart, com.anychart.core.VisualBaseWithBounds, com.anychart.core.VisualBase
    public Cartesian3d container(Layer layer) {
        APIlib.getInstance().addJSLine(String.format(Locale.US, this.jsBase + ".container(%s);", layer != null ? layer.getJsBase() : null));
        return this;
    }

    @Override // com.anychart.core.SeparateChart, com.anychart.core.Chart, com.anychart.core.VisualBaseWithBounds, com.anychart.core.VisualBase
    public Cartesian3d container(Stage stage) {
        APIlib.getInstance().addJSLine(String.format(Locale.US, this.jsBase + ".container(%s);", stage != null ? stage.getJsBase() : null));
        return this;
    }

    @Override // com.anychart.core.SeparateChart, com.anychart.core.Chart, com.anychart.core.VisualBaseWithBounds, com.anychart.core.VisualBase
    public Cartesian3d container(String str) {
        APIlib.getInstance().addJSLine(String.format(Locale.US, this.jsBase + ".container(%s);", wrapQuotes(str)));
        return this;
    }

    @Override // com.anychart.core.SeparateChart, com.anychart.core.Chart
    public ContextMenu contextMenu() {
        return new ContextMenu(this.jsBase + ".contextMenu()");
    }

    @Override // com.anychart.core.SeparateChart, com.anychart.core.Chart
    public Cartesian3d contextMenu(String str) {
        APIlib.getInstance().addJSLine(String.format(Locale.US, this.jsBase + ".contextMenu(%s);", wrapQuotes(str)));
        return this;
    }

    @Override // com.anychart.core.SeparateChart, com.anychart.core.Chart
    public Cartesian3d contextMenu(Boolean bool) {
        APIlib.getInstance().addJSLine(String.format(Locale.US, this.jsBase + ".contextMenu(%s);", bool));
        return this;
    }

    @Override // com.anychart.core.SeparateChart, com.anychart.core.Chart
    public ChartCredits credits() {
        return new ChartCredits(this.jsBase + ".credits()");
    }

    @Override // com.anychart.core.SeparateChart, com.anychart.core.Chart
    public Cartesian3d credits(String str) {
        APIlib.getInstance().addJSLine(String.format(Locale.US, this.jsBase + ".credits(%s);", wrapQuotes(str)));
        return this;
    }

    @Override // com.anychart.core.SeparateChart, com.anychart.core.Chart
    public Cartesian3d credits(Boolean bool) {
        APIlib.getInstance().addJSLine(String.format(Locale.US, this.jsBase + ".credits(%s);", bool));
        return this;
    }

    public Crosshair crosshair() {
        return new Crosshair(this.jsBase + ".crosshair()");
    }

    public Cartesian3d crosshair(String str) {
        APIlib.getInstance().addJSLine(String.format(Locale.US, this.jsBase + ".crosshair(%s);", wrapQuotes(str)));
        return this;
    }

    public Cartesian3d crosshair(Boolean bool) {
        APIlib.getInstance().addJSLine(String.format(Locale.US, this.jsBase + ".crosshair(%s);", bool));
        return this;
    }

    public View data(List<DataEntry> list) {
        return new View(String.format(Locale.US, this.jsBase + ".data(%s)", arrayToString(list)));
    }

    public void defaultSeriesType() {
        APIlib.getInstance().addJSLine(this.jsBase + ".defaultSeriesType();");
    }

    public Cartesian3d defaultSeriesType(CartesianSeriesType cartesianSeriesType) {
        APIlib.getInstance().addJSLine(String.format(Locale.US, this.jsBase + ".defaultSeriesType(%s);", cartesianSeriesType != null ? cartesianSeriesType.getJsBase() : null));
        return this;
    }

    public Cartesian3d defaultSeriesType(String str) {
        APIlib.getInstance().addJSLine(String.format(Locale.US, this.jsBase + ".defaultSeriesType(%s);", wrapQuotes(str)));
        return this;
    }

    @Override // com.anychart.core.SeparateChart, com.anychart.core.Chart
    public void dispose() {
        APIlib.getInstance().addJSLine(this.jsBase + ".dispose();");
    }

    @Override // com.anychart.core.SeparateChart, com.anychart.core.Chart
    public Cartesian3d draw(Boolean bool) {
        APIlib.getInstance().addJSLine(String.format(Locale.US, this.jsBase + ".draw(%s);", bool));
        return this;
    }

    @Override // com.anychart.core.SeparateChart, com.anychart.core.Chart, com.anychart.core.VisualBaseWithBounds, com.anychart.core.VisualBase
    public void enabled() {
        APIlib.getInstance().addJSLine(this.jsBase + ".enabled();");
    }

    @Override // com.anychart.core.SeparateChart, com.anychart.core.Chart, com.anychart.core.VisualBaseWithBounds, com.anychart.core.VisualBase
    public Cartesian3d enabled(Boolean bool) {
        APIlib.getInstance().addJSLine(String.format(Locale.US, this.jsBase + ".enabled(%s);", bool));
        return this;
    }

    @Override // com.anychart.core.SeparateChart, com.anychart.core.Chart
    public Exports exports() {
        return new Exports(this.jsBase + ".exports()");
    }

    @Override // com.anychart.core.SeparateChart, com.anychart.core.Chart
    public Cartesian3d exports(String str) {
        APIlib.getInstance().addJSLine(String.format(Locale.US, this.jsBase + ".exports(%s);", wrapQuotes(str)));
        return this;
    }

    @Override // com.anychart.core.SeparateChart, com.anychart.core.Chart
    public void fullScreen() {
        APIlib.getInstance().addJSLine(this.jsBase + ".fullScreen();");
    }

    @Override // com.anychart.core.SeparateChart, com.anychart.core.Chart
    public Cartesian3d fullScreen(Boolean bool) {
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

    public Cartesian3d hatchFillPalette(HatchFillType[] hatchFillTypeArr) {
        APIlib.getInstance().addJSLine(String.format(Locale.US, this.jsBase + ".hatchFillPalette(%s);", arrayToString(hatchFillTypeArr)));
        return this;
    }

    public Cartesian3d hatchFillPalette(String str) {
        APIlib.getInstance().addJSLine(String.format(Locale.US, this.jsBase + ".hatchFillPalette(%s);", wrapQuotes(str)));
        return this;
    }

    public Cartesian3d hatchFillPalette(HatchFills hatchFills) {
        APIlib.getInstance().addJSLine(String.format(Locale.US, this.jsBase + ".hatchFillPalette(%s);", hatchFills != null ? hatchFills.getJsBase() : null));
        return this;
    }

    @Override // com.anychart.core.SeparateChart, com.anychart.core.Chart, com.anychart.core.VisualBaseWithBounds
    public void height() {
        APIlib.getInstance().addJSLine(this.jsBase + ".height();");
    }

    @Override // com.anychart.core.SeparateChart, com.anychart.core.Chart, com.anychart.core.VisualBaseWithBounds
    public Cartesian3d height(Number number) {
        APIlib.getInstance().addJSLine(String.format(Locale.US, this.jsBase + ".height(%s);", number));
        return this;
    }

    @Override // com.anychart.core.SeparateChart, com.anychart.core.Chart, com.anychart.core.VisualBaseWithBounds
    public Cartesian3d height(String str) {
        APIlib.getInstance().addJSLine(String.format(Locale.US, this.jsBase + ".height(%s);", wrapQuotes(str)));
        return this;
    }

    public StateSettings hovered() {
        return new StateSettings(this.jsBase + ".hovered()");
    }

    public Cartesian3d hovered(String str) {
        APIlib.getInstance().addJSLine(String.format(Locale.US, this.jsBase + ".hovered(%s);", wrapQuotes(str)));
        return this;
    }

    @Override // com.anychart.core.SeparateChart, com.anychart.core.Chart
    public void id() {
        APIlib.getInstance().addJSLine(this.jsBase + ".id();");
    }

    @Override // com.anychart.core.SeparateChart, com.anychart.core.Chart
    public Cartesian3d id(String str) {
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
    public Cartesian3d interactivity(String str) {
        APIlib.getInstance().addJSLine(String.format(Locale.US, this.jsBase + ".interactivity(%s);", wrapQuotes(str)));
        return this;
    }

    @Override // com.anychart.core.SeparateChart
    public Cartesian3d interactivity(HoverMode hoverMode) {
        APIlib.getInstance().addJSLine(String.format(Locale.US, this.jsBase + ".interactivity(%s);", hoverMode != null ? hoverMode.getJsBase() : null));
        return this;
    }

    @Override // com.anychart.core.SeparateChart, com.anychart.core.Chart
    public void isFullScreenAvailable() {
        APIlib.getInstance().addJSLine(this.jsBase + ".isFullScreenAvailable();");
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
    public Cartesian3d label(Boolean bool) {
        APIlib.getInstance().addJSLine(String.format(Locale.US, this.jsBase + ".label(%s);", bool));
        return this;
    }

    @Override // com.anychart.core.SeparateChart, com.anychart.core.Chart
    public Cartesian3d label(String str, Boolean bool) {
        APIlib.getInstance().addJSLine(String.format(Locale.US, this.jsBase + ".label(%s, %s);", wrapQuotes(str), bool));
        return this;
    }

    @Override // com.anychart.core.SeparateChart, com.anychart.core.Chart
    public Cartesian3d label(String str, String str2) {
        APIlib.getInstance().addJSLine(String.format(Locale.US, this.jsBase + ".label(%s, %s);", wrapQuotes(str), wrapQuotes(str2)));
        return this;
    }

    @Override // com.anychart.core.SeparateChart, com.anychart.core.Chart
    public Cartesian3d label(Number number, Boolean bool) {
        APIlib.getInstance().addJSLine(String.format(Locale.US, this.jsBase + ".label(%s, %s);", number, bool));
        return this;
    }

    @Override // com.anychart.core.SeparateChart, com.anychart.core.Chart
    public Cartesian3d label(Number number, String str) {
        APIlib.getInstance().addJSLine(String.format(Locale.US, this.jsBase + ".label(%s, %s);", number, wrapQuotes(str)));
        return this;
    }

    public LabelsFactory labels() {
        return new LabelsFactory(this.jsBase + ".labels()");
    }

    public Cartesian3d labels(String str) {
        APIlib.getInstance().addJSLine(String.format(Locale.US, this.jsBase + ".labels(%s);", wrapQuotes(str)));
        return this;
    }

    public Cartesian3d labels(Boolean bool) {
        APIlib.getInstance().addJSLine(String.format(Locale.US, this.jsBase + ".labels(%s);", bool));
        return this;
    }

    @Override // com.anychart.core.SeparateChart, com.anychart.core.Chart, com.anychart.core.VisualBaseWithBounds
    public void left() {
        APIlib.getInstance().addJSLine(this.jsBase + ".left();");
    }

    @Override // com.anychart.core.SeparateChart, com.anychart.core.Chart, com.anychart.core.VisualBaseWithBounds
    public Cartesian3d left(Number number) {
        APIlib.getInstance().addJSLine(String.format(Locale.US, this.jsBase + ".left(%s);", number));
        return this;
    }

    @Override // com.anychart.core.SeparateChart, com.anychart.core.Chart, com.anychart.core.VisualBaseWithBounds
    public Cartesian3d left(String str) {
        APIlib.getInstance().addJSLine(String.format(Locale.US, this.jsBase + ".left(%s);", wrapQuotes(str)));
        return this;
    }

    @Override // com.anychart.core.SeparateChart
    public Legend legend() {
        return new Legend(this.jsBase + ".legend()");
    }

    @Override // com.anychart.core.SeparateChart
    public Cartesian3d legend(String str) {
        APIlib.getInstance().addJSLine(String.format(Locale.US, this.jsBase + ".legend(%s);", wrapQuotes(str)));
        return this;
    }

    @Override // com.anychart.core.SeparateChart
    public Cartesian3d legend(Boolean bool) {
        APIlib.getInstance().addJSLine(String.format(Locale.US, this.jsBase + ".legend(%s);", bool));
        return this;
    }

    public Line3d line(List<DataEntry> list) {
        return new Line3d(String.format(Locale.US, this.jsBase + ".line(%s)", arrayToString(list)));
    }

    public Line line2d(View view, TextParsingMode textParsingMode) {
        return new Line(String.format(Locale.US, this.jsBase + ".line2d(%s, %s)", view != null ? view.getJsBase() : null, textParsingMode != null ? textParsingMode.getJsBase() : null));
    }

    public Line line2d(View view, String str) {
        return new Line(String.format(Locale.US, this.jsBase + ".line2d(%s, %s)", view != null ? view.getJsBase() : null, wrapQuotes(str)));
    }

    public Line line2d(View view, TextParsingSettings textParsingSettings) {
        return new Line(String.format(Locale.US, this.jsBase + ".line2d(%s, %s)", view != null ? view.getJsBase() : null, textParsingSettings != null ? textParsingSettings.getJsBase() : null));
    }

    public Line line2d(Set set, TextParsingMode textParsingMode) {
        return new Line(String.format(Locale.US, this.jsBase + ".line2d(%s, %s)", set != null ? set.getJsBase() : null, textParsingMode != null ? textParsingMode.getJsBase() : null));
    }

    public Line line2d(Set set, String str) {
        return new Line(String.format(Locale.US, this.jsBase + ".line2d(%s, %s)", set != null ? set.getJsBase() : null, wrapQuotes(str)));
    }

    public Line line2d(Set set, TextParsingSettings textParsingSettings) {
        return new Line(String.format(Locale.US, this.jsBase + ".line2d(%s, %s)", set != null ? set.getJsBase() : null, textParsingSettings != null ? textParsingSettings.getJsBase() : null));
    }

    public Line line2d(String[] strArr, TextParsingMode textParsingMode) {
        return new Line(String.format(Locale.US, this.jsBase + ".line2d(%s, %s)", arrayToStringWrapQuotes(strArr), textParsingMode != null ? textParsingMode.getJsBase() : null));
    }

    public Line line2d(String[] strArr, String str) {
        return new Line(String.format(Locale.US, this.jsBase + ".line2d(%s, %s)", arrayToStringWrapQuotes(strArr), wrapQuotes(str)));
    }

    public Line line2d(String[] strArr, TextParsingSettings textParsingSettings) {
        return new Line(String.format(Locale.US, this.jsBase + ".line2d(%s, %s)", arrayToStringWrapQuotes(strArr), textParsingSettings != null ? textParsingSettings.getJsBase() : null));
    }

    public Line line2d(String str, TextParsingMode textParsingMode) {
        return new Line(String.format(Locale.US, this.jsBase + ".line2d(%s, %s)", wrapQuotes(str), textParsingMode != null ? textParsingMode.getJsBase() : null));
    }

    public Line line2d(String str, String str2) {
        return new Line(String.format(Locale.US, this.jsBase + ".line2d(%s, %s)", wrapQuotes(str), wrapQuotes(str2)));
    }

    public Line line2d(String str, TextParsingSettings textParsingSettings) {
        return new Line(String.format(Locale.US, this.jsBase + ".line2d(%s, %s)", wrapQuotes(str), textParsingSettings != null ? textParsingSettings.getJsBase() : null));
    }

    public com.anychart.core.axismarkers.Line lineMarker(Number number) {
        return new com.anychart.core.axismarkers.Line(String.format(Locale.US, this.jsBase + ".lineMarker(%s)", number));
    }

    public Cartesian3d lineMarker(String str) {
        APIlib.getInstance().addJSLine(String.format(Locale.US, this.jsBase + ".lineMarker(%s);", wrapQuotes(str)));
        return this;
    }

    public Cartesian3d lineMarker(Boolean bool) {
        APIlib.getInstance().addJSLine(String.format(Locale.US, this.jsBase + ".lineMarker(%s);", bool));
        return this;
    }

    public Cartesian3d lineMarker(Number number, String str) {
        APIlib.getInstance().addJSLine(String.format(Locale.US, this.jsBase + ".lineMarker(%s, %s);", number, wrapQuotes(str)));
        return this;
    }

    public Cartesian3d lineMarker(Number number, Boolean bool) {
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
    public Cartesian3d margin(Number[] numberArr) {
        APIlib.getInstance().addJSLine(String.format(Locale.US, this.jsBase + ".margin(%s);", Arrays.toString(numberArr)));
        return this;
    }

    @Override // com.anychart.core.SeparateChart, com.anychart.core.Chart
    public Cartesian3d margin(String[] strArr) {
        APIlib.getInstance().addJSLine(String.format(Locale.US, this.jsBase + ".margin(%s);", arrayToStringWrapQuotes(strArr)));
        return this;
    }

    @Override // com.anychart.core.SeparateChart, com.anychart.core.Chart
    public Cartesian3d margin(String str) {
        APIlib.getInstance().addJSLine(String.format(Locale.US, this.jsBase + ".margin(%s);", wrapQuotes(str)));
        return this;
    }

    @Override // com.anychart.core.SeparateChart, com.anychart.core.Chart
    public Cartesian3d margin(String str, String str2, String str3, String str4) {
        APIlib.getInstance().addJSLine(String.format(Locale.US, this.jsBase + ".margin(%s, %s, %s, %s);", wrapQuotes(str), wrapQuotes(str2), wrapQuotes(str3), wrapQuotes(str4)));
        return this;
    }

    @Override // com.anychart.core.SeparateChart, com.anychart.core.Chart
    public Cartesian3d margin(String str, String str2, String str3, Number number) {
        APIlib.getInstance().addJSLine(String.format(Locale.US, this.jsBase + ".margin(%s, %s, %s, %s);", wrapQuotes(str), wrapQuotes(str2), wrapQuotes(str3), number));
        return this;
    }

    @Override // com.anychart.core.SeparateChart, com.anychart.core.Chart
    public Cartesian3d margin(String str, String str2, Number number, String str3) {
        APIlib.getInstance().addJSLine(String.format(Locale.US, this.jsBase + ".margin(%s, %s, %s, %s);", wrapQuotes(str), wrapQuotes(str2), number, wrapQuotes(str3)));
        return this;
    }

    @Override // com.anychart.core.SeparateChart, com.anychart.core.Chart
    public Cartesian3d margin(String str, String str2, Number number, Number number2) {
        APIlib.getInstance().addJSLine(String.format(Locale.US, this.jsBase + ".margin(%s, %s, %s, %s);", wrapQuotes(str), wrapQuotes(str2), number, number2));
        return this;
    }

    @Override // com.anychart.core.SeparateChart, com.anychart.core.Chart
    public Cartesian3d margin(String str, Number number, String str2, String str3) {
        APIlib.getInstance().addJSLine(String.format(Locale.US, this.jsBase + ".margin(%s, %s, %s, %s);", wrapQuotes(str), number, wrapQuotes(str2), wrapQuotes(str3)));
        return this;
    }

    @Override // com.anychart.core.SeparateChart, com.anychart.core.Chart
    public Cartesian3d margin(String str, Number number, String str2, Number number2) {
        APIlib.getInstance().addJSLine(String.format(Locale.US, this.jsBase + ".margin(%s, %s, %s, %s);", wrapQuotes(str), number, wrapQuotes(str2), number2));
        return this;
    }

    @Override // com.anychart.core.SeparateChart, com.anychart.core.Chart
    public Cartesian3d margin(String str, Number number, Number number2, String str2) {
        APIlib.getInstance().addJSLine(String.format(Locale.US, this.jsBase + ".margin(%s, %s, %s, %s);", wrapQuotes(str), number, number2, wrapQuotes(str2)));
        return this;
    }

    @Override // com.anychart.core.SeparateChart, com.anychart.core.Chart
    public Cartesian3d margin(String str, Number number, Number number2, Number number3) {
        APIlib.getInstance().addJSLine(String.format(Locale.US, this.jsBase + ".margin(%s, %s, %s, %s);", wrapQuotes(str), number, number2, number3));
        return this;
    }

    @Override // com.anychart.core.SeparateChart, com.anychart.core.Chart
    public Cartesian3d margin(Number number, String str, String str2, String str3) {
        APIlib.getInstance().addJSLine(String.format(Locale.US, this.jsBase + ".margin(%s, %s, %s, %s);", number, wrapQuotes(str), wrapQuotes(str2), wrapQuotes(str3)));
        return this;
    }

    @Override // com.anychart.core.SeparateChart, com.anychart.core.Chart
    public Cartesian3d margin(Number number, String str, String str2, Number number2) {
        APIlib.getInstance().addJSLine(String.format(Locale.US, this.jsBase + ".margin(%s, %s, %s, %s);", number, wrapQuotes(str), wrapQuotes(str2), number2));
        return this;
    }

    @Override // com.anychart.core.SeparateChart, com.anychart.core.Chart
    public Cartesian3d margin(Number number, String str, Number number2, String str2) {
        APIlib.getInstance().addJSLine(String.format(Locale.US, this.jsBase + ".margin(%s, %s, %s, %s);", number, wrapQuotes(str), number2, wrapQuotes(str2)));
        return this;
    }

    @Override // com.anychart.core.SeparateChart, com.anychart.core.Chart
    public Cartesian3d margin(Number number, String str, Number number2, Number number3) {
        APIlib.getInstance().addJSLine(String.format(Locale.US, this.jsBase + ".margin(%s, %s, %s, %s);", number, wrapQuotes(str), number2, number3));
        return this;
    }

    @Override // com.anychart.core.SeparateChart, com.anychart.core.Chart
    public Cartesian3d margin(Number number, Number number2, String str, String str2) {
        APIlib.getInstance().addJSLine(String.format(Locale.US, this.jsBase + ".margin(%s, %s, %s, %s);", number, number2, wrapQuotes(str), wrapQuotes(str2)));
        return this;
    }

    @Override // com.anychart.core.SeparateChart, com.anychart.core.Chart
    public Cartesian3d margin(Number number, Number number2, String str, Number number3) {
        APIlib.getInstance().addJSLine(String.format(Locale.US, this.jsBase + ".margin(%s, %s, %s, %s);", number, number2, wrapQuotes(str), number3));
        return this;
    }

    @Override // com.anychart.core.SeparateChart, com.anychart.core.Chart
    public Cartesian3d margin(Number number, Number number2, Number number3, String str) {
        APIlib.getInstance().addJSLine(String.format(Locale.US, this.jsBase + ".margin(%s, %s, %s, %s);", number, number2, number3, wrapQuotes(str)));
        return this;
    }

    @Override // com.anychart.core.SeparateChart, com.anychart.core.Chart
    public Cartesian3d margin(Number number, Number number2, Number number3, Number number4) {
        APIlib.getInstance().addJSLine(String.format(Locale.US, this.jsBase + ".margin(%s, %s, %s, %s);", number, number2, number3, number4));
        return this;
    }

    @Override // com.anychart.core.SeparateChart, com.anychart.core.Chart, com.anychart.core.VisualBaseWithBounds
    public void maxHeight() {
        APIlib.getInstance().addJSLine(this.jsBase + ".maxHeight();");
    }

    @Override // com.anychart.core.SeparateChart, com.anychart.core.Chart, com.anychart.core.VisualBaseWithBounds
    public Cartesian3d maxHeight(Number number) {
        APIlib.getInstance().addJSLine(String.format(Locale.US, this.jsBase + ".maxHeight(%s);", number));
        return this;
    }

    @Override // com.anychart.core.SeparateChart, com.anychart.core.Chart, com.anychart.core.VisualBaseWithBounds
    public Cartesian3d maxHeight(String str) {
        APIlib.getInstance().addJSLine(String.format(Locale.US, this.jsBase + ".maxHeight(%s);", wrapQuotes(str)));
        return this;
    }

    public LabelsFactory maxLabels() {
        return new LabelsFactory(this.jsBase + ".maxLabels()");
    }

    public Cartesian3d maxLabels(String str) {
        APIlib.getInstance().addJSLine(String.format(Locale.US, this.jsBase + ".maxLabels(%s);", wrapQuotes(str)));
        return this;
    }

    public Cartesian3d maxLabels(Boolean bool) {
        APIlib.getInstance().addJSLine(String.format(Locale.US, this.jsBase + ".maxLabels(%s);", bool));
        return this;
    }

    public void maxPointWidth() {
        APIlib.getInstance().addJSLine(this.jsBase + ".maxPointWidth();");
    }

    public Cartesian3d maxPointWidth(Number number) {
        APIlib.getInstance().addJSLine(String.format(Locale.US, this.jsBase + ".maxPointWidth(%s);", number));
        return this;
    }

    public Cartesian3d maxPointWidth(String str) {
        APIlib.getInstance().addJSLine(String.format(Locale.US, this.jsBase + ".maxPointWidth(%s);", wrapQuotes(str)));
        return this;
    }

    @Override // com.anychart.core.SeparateChart, com.anychart.core.Chart, com.anychart.core.VisualBaseWithBounds
    public void maxWidth() {
        APIlib.getInstance().addJSLine(this.jsBase + ".maxWidth();");
    }

    @Override // com.anychart.core.SeparateChart, com.anychart.core.Chart, com.anychart.core.VisualBaseWithBounds
    public Cartesian3d maxWidth(Number number) {
        APIlib.getInstance().addJSLine(String.format(Locale.US, this.jsBase + ".maxWidth(%s);", number));
        return this;
    }

    @Override // com.anychart.core.SeparateChart, com.anychart.core.Chart, com.anychart.core.VisualBaseWithBounds
    public Cartesian3d maxWidth(String str) {
        APIlib.getInstance().addJSLine(String.format(Locale.US, this.jsBase + ".maxWidth(%s);", wrapQuotes(str)));
        return this;
    }

    @Override // com.anychart.core.SeparateChart, com.anychart.core.Chart, com.anychart.core.VisualBaseWithBounds
    public void minHeight() {
        APIlib.getInstance().addJSLine(this.jsBase + ".minHeight();");
    }

    @Override // com.anychart.core.SeparateChart, com.anychart.core.Chart, com.anychart.core.VisualBaseWithBounds
    public Cartesian3d minHeight(Number number) {
        APIlib.getInstance().addJSLine(String.format(Locale.US, this.jsBase + ".minHeight(%s);", number));
        return this;
    }

    @Override // com.anychart.core.SeparateChart, com.anychart.core.Chart, com.anychart.core.VisualBaseWithBounds
    public Cartesian3d minHeight(String str) {
        APIlib.getInstance().addJSLine(String.format(Locale.US, this.jsBase + ".minHeight(%s);", wrapQuotes(str)));
        return this;
    }

    public LabelsFactory minLabels() {
        return new LabelsFactory(this.jsBase + ".minLabels()");
    }

    public Cartesian3d minLabels(String str) {
        APIlib.getInstance().addJSLine(String.format(Locale.US, this.jsBase + ".minLabels(%s);", wrapQuotes(str)));
        return this;
    }

    public Cartesian3d minLabels(Boolean bool) {
        APIlib.getInstance().addJSLine(String.format(Locale.US, this.jsBase + ".minLabels(%s);", bool));
        return this;
    }

    public void minPointLength() {
        APIlib.getInstance().addJSLine(this.jsBase + ".minPointLength();");
    }

    public Cartesian3d minPointLength(Number number) {
        APIlib.getInstance().addJSLine(String.format(Locale.US, this.jsBase + ".minPointLength(%s);", number));
        return this;
    }

    public Cartesian3d minPointLength(String str) {
        APIlib.getInstance().addJSLine(String.format(Locale.US, this.jsBase + ".minPointLength(%s);", wrapQuotes(str)));
        return this;
    }

    @Override // com.anychart.core.SeparateChart, com.anychart.core.Chart, com.anychart.core.VisualBaseWithBounds
    public void minWidth() {
        APIlib.getInstance().addJSLine(this.jsBase + ".minWidth();");
    }

    @Override // com.anychart.core.SeparateChart, com.anychart.core.Chart, com.anychart.core.VisualBaseWithBounds
    public Cartesian3d minWidth(Number number) {
        APIlib.getInstance().addJSLine(String.format(Locale.US, this.jsBase + ".minWidth(%s);", number));
        return this;
    }

    @Override // com.anychart.core.SeparateChart, com.anychart.core.Chart, com.anychart.core.VisualBaseWithBounds
    public Cartesian3d minWidth(String str) {
        APIlib.getInstance().addJSLine(String.format(Locale.US, this.jsBase + ".minWidth(%s);", wrapQuotes(str)));
        return this;
    }

    @Override // com.anychart.core.SeparateChart, com.anychart.core.Chart
    public NoDataSettings noData() {
        return new NoDataSettings(this.jsBase + ".noData()");
    }

    @Override // com.anychart.core.SeparateChart, com.anychart.core.Chart
    public Cartesian3d noData(String str) {
        APIlib.getInstance().addJSLine(String.format(Locale.US, this.jsBase + ".noData(%s);", wrapQuotes(str)));
        return this;
    }

    public StateSettings normal() {
        return new StateSettings(this.jsBase + ".normal()");
    }

    public Cartesian3d normal(String str) {
        APIlib.getInstance().addJSLine(String.format(Locale.US, this.jsBase + ".normal(%s);", wrapQuotes(str)));
        return this;
    }

    @Override // com.anychart.core.SeparateChart, com.anychart.core.Chart
    public Padding padding() {
        return new Padding(this.jsBase + ".padding()");
    }

    @Override // com.anychart.core.SeparateChart, com.anychart.core.Chart
    public Cartesian3d padding(Number[] numberArr) {
        APIlib.getInstance().addJSLine(String.format(Locale.US, this.jsBase + ".padding(%s);", Arrays.toString(numberArr)));
        return this;
    }

    @Override // com.anychart.core.SeparateChart, com.anychart.core.Chart
    public Cartesian3d padding(String[] strArr) {
        APIlib.getInstance().addJSLine(String.format(Locale.US, this.jsBase + ".padding(%s);", arrayToStringWrapQuotes(strArr)));
        return this;
    }

    @Override // com.anychart.core.SeparateChart, com.anychart.core.Chart
    public Cartesian3d padding(String str) {
        APIlib.getInstance().addJSLine(String.format(Locale.US, this.jsBase + ".padding(%s);", wrapQuotes(str)));
        return this;
    }

    @Override // com.anychart.core.SeparateChart, com.anychart.core.Chart
    public Cartesian3d padding(String str, String str2, String str3, String str4) {
        APIlib.getInstance().addJSLine(String.format(Locale.US, this.jsBase + ".padding(%s, %s, %s, %s);", wrapQuotes(str), wrapQuotes(str2), wrapQuotes(str3), wrapQuotes(str4)));
        return this;
    }

    @Override // com.anychart.core.SeparateChart, com.anychart.core.Chart
    public Cartesian3d padding(String str, String str2, String str3, Number number) {
        APIlib.getInstance().addJSLine(String.format(Locale.US, this.jsBase + ".padding(%s, %s, %s, %s);", wrapQuotes(str), wrapQuotes(str2), wrapQuotes(str3), number));
        return this;
    }

    @Override // com.anychart.core.SeparateChart, com.anychart.core.Chart
    public Cartesian3d padding(String str, String str2, Number number, String str3) {
        APIlib.getInstance().addJSLine(String.format(Locale.US, this.jsBase + ".padding(%s, %s, %s, %s);", wrapQuotes(str), wrapQuotes(str2), number, wrapQuotes(str3)));
        return this;
    }

    @Override // com.anychart.core.SeparateChart, com.anychart.core.Chart
    public Cartesian3d padding(String str, String str2, Number number, Number number2) {
        APIlib.getInstance().addJSLine(String.format(Locale.US, this.jsBase + ".padding(%s, %s, %s, %s);", wrapQuotes(str), wrapQuotes(str2), number, number2));
        return this;
    }

    @Override // com.anychart.core.SeparateChart, com.anychart.core.Chart
    public Cartesian3d padding(String str, Number number, String str2, String str3) {
        APIlib.getInstance().addJSLine(String.format(Locale.US, this.jsBase + ".padding(%s, %s, %s, %s);", wrapQuotes(str), number, wrapQuotes(str2), wrapQuotes(str3)));
        return this;
    }

    @Override // com.anychart.core.SeparateChart, com.anychart.core.Chart
    public Cartesian3d padding(String str, Number number, String str2, Number number2) {
        APIlib.getInstance().addJSLine(String.format(Locale.US, this.jsBase + ".padding(%s, %s, %s, %s);", wrapQuotes(str), number, wrapQuotes(str2), number2));
        return this;
    }

    @Override // com.anychart.core.SeparateChart, com.anychart.core.Chart
    public Cartesian3d padding(String str, Number number, Number number2, String str2) {
        APIlib.getInstance().addJSLine(String.format(Locale.US, this.jsBase + ".padding(%s, %s, %s, %s);", wrapQuotes(str), number, number2, wrapQuotes(str2)));
        return this;
    }

    @Override // com.anychart.core.SeparateChart, com.anychart.core.Chart
    public Cartesian3d padding(String str, Number number, Number number2, Number number3) {
        APIlib.getInstance().addJSLine(String.format(Locale.US, this.jsBase + ".padding(%s, %s, %s, %s);", wrapQuotes(str), number, number2, number3));
        return this;
    }

    @Override // com.anychart.core.SeparateChart, com.anychart.core.Chart
    public Cartesian3d padding(Number number, String str, String str2, String str3) {
        APIlib.getInstance().addJSLine(String.format(Locale.US, this.jsBase + ".padding(%s, %s, %s, %s);", number, wrapQuotes(str), wrapQuotes(str2), wrapQuotes(str3)));
        return this;
    }

    @Override // com.anychart.core.SeparateChart, com.anychart.core.Chart
    public Cartesian3d padding(Number number, String str, String str2, Number number2) {
        APIlib.getInstance().addJSLine(String.format(Locale.US, this.jsBase + ".padding(%s, %s, %s, %s);", number, wrapQuotes(str), wrapQuotes(str2), number2));
        return this;
    }

    @Override // com.anychart.core.SeparateChart, com.anychart.core.Chart
    public Cartesian3d padding(Number number, String str, Number number2, String str2) {
        APIlib.getInstance().addJSLine(String.format(Locale.US, this.jsBase + ".padding(%s, %s, %s, %s);", number, wrapQuotes(str), number2, wrapQuotes(str2)));
        return this;
    }

    @Override // com.anychart.core.SeparateChart, com.anychart.core.Chart
    public Cartesian3d padding(Number number, String str, Number number2, Number number3) {
        APIlib.getInstance().addJSLine(String.format(Locale.US, this.jsBase + ".padding(%s, %s, %s, %s);", number, wrapQuotes(str), number2, number3));
        return this;
    }

    @Override // com.anychart.core.SeparateChart, com.anychart.core.Chart
    public Cartesian3d padding(Number number, Number number2, String str, String str2) {
        APIlib.getInstance().addJSLine(String.format(Locale.US, this.jsBase + ".padding(%s, %s, %s, %s);", number, number2, wrapQuotes(str), wrapQuotes(str2)));
        return this;
    }

    @Override // com.anychart.core.SeparateChart, com.anychart.core.Chart
    public Cartesian3d padding(Number number, Number number2, String str, Number number3) {
        APIlib.getInstance().addJSLine(String.format(Locale.US, this.jsBase + ".padding(%s, %s, %s, %s);", number, number2, wrapQuotes(str), number3));
        return this;
    }

    @Override // com.anychart.core.SeparateChart, com.anychart.core.Chart
    public Cartesian3d padding(Number number, Number number2, Number number3, String str) {
        APIlib.getInstance().addJSLine(String.format(Locale.US, this.jsBase + ".padding(%s, %s, %s, %s);", number, number2, number3, wrapQuotes(str)));
        return this;
    }

    @Override // com.anychart.core.SeparateChart, com.anychart.core.Chart
    public Cartesian3d padding(Number number, Number number2, Number number3, Number number4) {
        APIlib.getInstance().addJSLine(String.format(Locale.US, this.jsBase + ".padding(%s, %s, %s, %s);", number, number2, number3, number4));
        return this;
    }

    public RangeColors palette() {
        return new RangeColors(this.jsBase + ".palette()");
    }

    public Cartesian3d palette(RangeColors rangeColors) {
        APIlib.getInstance().addJSLine(String.format(Locale.US, this.jsBase + ".palette(%s);", rangeColors != null ? rangeColors.getJsBase() : null));
        return this;
    }

    public Cartesian3d palette(DistinctColors distinctColors) {
        APIlib.getInstance().addJSLine(String.format(Locale.US, this.jsBase + ".palette(%s);", distinctColors != null ? distinctColors.getJsBase() : null));
        return this;
    }

    public Cartesian3d palette(String str) {
        APIlib.getInstance().addJSLine(String.format(Locale.US, this.jsBase + ".palette(%s);", wrapQuotes(str)));
        return this;
    }

    public Cartesian3d palette(String[] strArr) {
        APIlib.getInstance().addJSLine(String.format(Locale.US, this.jsBase + ".palette(%s);", arrayToStringWrapQuotes(strArr)));
        return this;
    }

    public void pointWidth() {
        APIlib.getInstance().addJSLine(this.jsBase + ".pointWidth();");
    }

    public Cartesian3d pointWidth(Number number) {
        APIlib.getInstance().addJSLine(String.format(Locale.US, this.jsBase + ".pointWidth(%s);", number));
        return this;
    }

    public Cartesian3d pointWidth(String str) {
        APIlib.getInstance().addJSLine(String.format(Locale.US, this.jsBase + ".pointWidth(%s);", wrapQuotes(str)));
        return this;
    }

    @Override // com.anychart.core.SeparateChart, com.anychart.core.Chart, com.anychart.core.VisualBaseWithBounds, com.anychart.core.VisualBase
    public void print(PaperSize paperSize, Boolean bool) {
        APIlib.getInstance().addJSLine(String.format(Locale.US, this.jsBase + ".print(%s, %s);", paperSize != null ? paperSize.getJsBase() : null, bool));
    }

    @Override // com.anychart.core.SeparateChart, com.anychart.core.Chart, com.anychart.core.VisualBaseWithBounds, com.anychart.core.VisualBase
    public void print(String str, Boolean bool) {
        APIlib.getInstance().addJSLine(String.format(Locale.US, this.jsBase + ".print(%s, %s);", wrapQuotes(str), bool));
    }

    public Range rangeMarker(Number number) {
        return new Range(String.format(Locale.US, this.jsBase + ".rangeMarker(%s)", number));
    }

    public Cartesian3d rangeMarker(String str) {
        APIlib.getInstance().addJSLine(String.format(Locale.US, this.jsBase + ".rangeMarker(%s);", wrapQuotes(str)));
        return this;
    }

    public Cartesian3d rangeMarker(Boolean bool) {
        APIlib.getInstance().addJSLine(String.format(Locale.US, this.jsBase + ".rangeMarker(%s);", bool));
        return this;
    }

    public Cartesian3d rangeMarker(Number number, String str) {
        APIlib.getInstance().addJSLine(String.format(Locale.US, this.jsBase + ".rangeMarker(%s, %s);", number, wrapQuotes(str)));
        return this;
    }

    public Cartesian3d rangeMarker(Number number, Boolean bool) {
        APIlib.getInstance().addJSLine(String.format(Locale.US, this.jsBase + ".rangeMarker(%s, %s);", number, bool));
        return this;
    }

    @Override // com.anychart.core.SeparateChart, com.anychart.core.Chart, com.anychart.core.VisualBaseWithBounds, com.anychart.core.VisualBase, com.anychart.core.Base
    public void removeAllListeners(String str) {
        APIlib.getInstance().addJSLine(String.format(Locale.US, this.jsBase + ".removeAllListeners(%s);", wrapQuotes(str)));
    }

    public Cartesian3d removeAllSeries() {
        APIlib.getInstance().addJSLine(this.jsBase + ".removeAllSeries();");
        return this;
    }

    public Cartesian3d removeSeries(Number number) {
        APIlib.getInstance().addJSLine(String.format(Locale.US, this.jsBase + ".removeSeries(%s);", number));
        return this;
    }

    public Cartesian3d removeSeries(String str) {
        APIlib.getInstance().addJSLine(String.format(Locale.US, this.jsBase + ".removeSeries(%s);", wrapQuotes(str)));
        return this;
    }

    public Cartesian3d removeSeriesAt(Number number) {
        APIlib.getInstance().addJSLine(String.format(Locale.US, this.jsBase + ".removeSeriesAt(%s);", number));
        return this;
    }

    @Override // com.anychart.core.SeparateChart, com.anychart.core.Chart, com.anychart.core.VisualBaseWithBounds
    public void right() {
        APIlib.getInstance().addJSLine(this.jsBase + ".right();");
    }

    @Override // com.anychart.core.SeparateChart, com.anychart.core.Chart, com.anychart.core.VisualBaseWithBounds
    public Cartesian3d right(Number number) {
        APIlib.getInstance().addJSLine(String.format(Locale.US, this.jsBase + ".right(%s);", number));
        return this;
    }

    @Override // com.anychart.core.SeparateChart, com.anychart.core.Chart, com.anychart.core.VisualBaseWithBounds
    public Cartesian3d right(String str) {
        APIlib.getInstance().addJSLine(String.format(Locale.US, this.jsBase + ".right(%s);", wrapQuotes(str)));
        return this;
    }

    @Override // com.anychart.core.SeparateChart, com.anychart.core.Chart
    public void saveAsJpg(Number number, Number number2, Number number3, Boolean bool, String str) {
        APIlib.getInstance().addJSLine(String.format(Locale.US, this.jsBase + ".saveAsJpg(%s, %s, %s, %s, %s);", number, number2, number3, bool, wrapQuotes(str)));
    }

    @Override // com.anychart.core.SeparateChart, com.anychart.core.Chart
    public void saveAsJpg(String str, Number number, Number number2, Boolean bool, String str2) {
        APIlib.getInstance().addJSLine(String.format(Locale.US, this.jsBase + ".saveAsJpg(%s, %s, %s, %s, %s);", wrapQuotes(str), number, number2, bool, wrapQuotes(str2)));
    }

    @Override // com.anychart.core.SeparateChart, com.anychart.core.Chart
    public void saveAsJson(String str) {
        APIlib.getInstance().addJSLine(String.format(Locale.US, this.jsBase + ".saveAsJson(%s);", wrapQuotes(str)));
    }

    @Override // com.anychart.core.SeparateChart, com.anychart.core.Chart
    public void saveAsPdf(Number number, Boolean bool, Number number2, Number number3, String str) {
        APIlib.getInstance().addJSLine(String.format(Locale.US, this.jsBase + ".saveAsPdf(%s, %s, %s, %s, %s);", number, bool, number2, number3, wrapQuotes(str)));
    }

    @Override // com.anychart.core.SeparateChart, com.anychart.core.Chart
    public void saveAsPdf(String str, Boolean bool, Number number, Number number2, String str2) {
        APIlib.getInstance().addJSLine(String.format(Locale.US, this.jsBase + ".saveAsPdf(%s, %s, %s, %s, %s);", wrapQuotes(str), bool, number, number2, wrapQuotes(str2)));
    }

    @Override // com.anychart.core.SeparateChart, com.anychart.core.Chart
    public void saveAsPng(Number number, Number number2, Number number3, String str) {
        APIlib.getInstance().addJSLine(String.format(Locale.US, this.jsBase + ".saveAsPng(%s, %s, %s, %s);", number, number2, number3, wrapQuotes(str)));
    }

    @Override // com.anychart.core.SeparateChart, com.anychart.core.Chart
    public void saveAsPng(String str, Number number, Number number2, String str2) {
        APIlib.getInstance().addJSLine(String.format(Locale.US, this.jsBase + ".saveAsPng(%s, %s, %s, %s);", wrapQuotes(str), number, number2, wrapQuotes(str2)));
    }

    @Override // com.anychart.core.SeparateChart, com.anychart.core.Chart
    public void saveAsSvg(String str, Boolean bool, String str2) {
        APIlib.getInstance().addJSLine(String.format(Locale.US, this.jsBase + ".saveAsSvg(%s, %s, %s);", wrapQuotes(str), bool, wrapQuotes(str2)));
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
    public Cartesian3d selectMarqueeFill(Fill fill) {
        APIlib.getInstance().addJSLine(String.format(Locale.US, this.jsBase + ".selectMarqueeFill(%s);", fill != null ? fill.getJsBase() : null));
        return this;
    }

    @Override // com.anychart.core.SeparateChart, com.anychart.core.Chart
    public Cartesian3d selectMarqueeFill(GradientKey gradientKey) {
        APIlib.getInstance().addJSLine(String.format(Locale.US, this.jsBase + ".selectMarqueeFill(%s);", gradientKey != null ? gradientKey.getJsBase() : null));
        return this;
    }

    @Override // com.anychart.core.SeparateChart, com.anychart.core.Chart
    public Cartesian3d selectMarqueeFill(String[] strArr) {
        APIlib.getInstance().addJSLine(String.format(Locale.US, this.jsBase + ".selectMarqueeFill(%s);", arrayToStringWrapQuotes(strArr)));
        return this;
    }

    @Override // com.anychart.core.SeparateChart, com.anychart.core.Chart
    public Cartesian3d selectMarqueeFill(String str, Number number) {
        APIlib.getInstance().addJSLine(String.format(Locale.US, this.jsBase + ".selectMarqueeFill(%s, %s);", wrapQuotes(str), number));
        return this;
    }

    @Override // com.anychart.core.SeparateChart, com.anychart.core.Chart
    public Cartesian3d selectMarqueeFill(GradientKey gradientKey, Number number, Boolean bool, Number number2) {
        APIlib.getInstance().addJSLine(String.format(Locale.US, this.jsBase + ".selectMarqueeFill(%s, %s, %s, %s);", gradientKey != null ? gradientKey.getJsBase() : null, number, bool, number2));
        return this;
    }

    @Override // com.anychart.core.SeparateChart, com.anychart.core.Chart
    public Cartesian3d selectMarqueeFill(GradientKey gradientKey, Number number, com.anychart.graphics.vector.Rect rect, Number number2) {
        APIlib.getInstance().addJSLine(String.format(Locale.US, this.jsBase + ".selectMarqueeFill(%s, %s, %s, %s);", gradientKey != null ? gradientKey.getJsBase() : null, number, rect != null ? rect.getJsBase() : null, number2));
        return this;
    }

    @Override // com.anychart.core.SeparateChart, com.anychart.core.Chart
    public Cartesian3d selectMarqueeFill(GradientKey gradientKey, Number number, String str, Number number2) {
        APIlib.getInstance().addJSLine(String.format(Locale.US, this.jsBase + ".selectMarqueeFill(%s, %s, %s, %s);", gradientKey != null ? gradientKey.getJsBase() : null, number, wrapQuotes(str), number2));
        return this;
    }

    @Override // com.anychart.core.SeparateChart, com.anychart.core.Chart
    public Cartesian3d selectMarqueeFill(String[] strArr, Number number, Boolean bool, Number number2) {
        APIlib.getInstance().addJSLine(String.format(Locale.US, this.jsBase + ".selectMarqueeFill(%s, %s, %s, %s);", arrayToStringWrapQuotes(strArr), number, bool, number2));
        return this;
    }

    @Override // com.anychart.core.SeparateChart, com.anychart.core.Chart
    public Cartesian3d selectMarqueeFill(String[] strArr, Number number, com.anychart.graphics.vector.Rect rect, Number number2) {
        APIlib.getInstance().addJSLine(String.format(Locale.US, this.jsBase + ".selectMarqueeFill(%s, %s, %s, %s);", arrayToStringWrapQuotes(strArr), number, rect != null ? rect.getJsBase() : null, number2));
        return this;
    }

    @Override // com.anychart.core.SeparateChart, com.anychart.core.Chart
    public Cartesian3d selectMarqueeFill(String[] strArr, Number number, String str, Number number2) {
        APIlib.getInstance().addJSLine(String.format(Locale.US, this.jsBase + ".selectMarqueeFill(%s, %s, %s, %s);", arrayToStringWrapQuotes(strArr), number, wrapQuotes(str), number2));
        return this;
    }

    @Override // com.anychart.core.SeparateChart, com.anychart.core.Chart
    public Cartesian3d selectMarqueeFill(GradientKey gradientKey, Number number, Number number2, com.anychart.graphics.math.Rect rect, Number number3, Number number4, Number number5) {
        APIlib.getInstance().addJSLine(String.format(Locale.US, this.jsBase + ".selectMarqueeFill(%s, %s, %s, %s, %s, %s, %s);", gradientKey != null ? gradientKey.getJsBase() : null, number, number2, rect != null ? rect.getJsBase() : null, number3, number4, number5));
        return this;
    }

    @Override // com.anychart.core.SeparateChart, com.anychart.core.Chart
    public Cartesian3d selectMarqueeFill(String[] strArr, Number number, Number number2, com.anychart.graphics.math.Rect rect, Number number3, Number number4, Number number5) {
        APIlib.getInstance().addJSLine(String.format(Locale.US, this.jsBase + ".selectMarqueeFill(%s, %s, %s, %s, %s, %s, %s);", arrayToStringWrapQuotes(strArr), number, number2, rect != null ? rect.getJsBase() : null, number3, number4, number5));
        return this;
    }

    @Override // com.anychart.core.SeparateChart, com.anychart.core.Chart
    public void selectMarqueeStroke() {
        APIlib.getInstance().addJSLine(this.jsBase + ".selectMarqueeStroke();");
    }

    @Override // com.anychart.core.SeparateChart, com.anychart.core.Chart
    public Cartesian3d selectMarqueeStroke(Stroke stroke, Number number, String str, String str2, String str3) {
        APIlib.getInstance().addJSLine(String.format(Locale.US, this.jsBase + ".selectMarqueeStroke(%s, %s, %s, %s, %s);", stroke != null ? stroke.getJsBase() : null, number, wrapQuotes(str), wrapQuotes(str2), wrapQuotes(str3)));
        return this;
    }

    @Override // com.anychart.core.SeparateChart, com.anychart.core.Chart
    public Cartesian3d selectMarqueeStroke(Stroke stroke, Number number, String str, String str2, StrokeLineCap strokeLineCap) {
        APIlib.getInstance().addJSLine(String.format(Locale.US, this.jsBase + ".selectMarqueeStroke(%s, %s, %s, %s, %s);", stroke != null ? stroke.getJsBase() : null, number, wrapQuotes(str), wrapQuotes(str2), strokeLineCap != null ? strokeLineCap.getJsBase() : null));
        return this;
    }

    @Override // com.anychart.core.SeparateChart, com.anychart.core.Chart
    public Cartesian3d selectMarqueeStroke(Stroke stroke, Number number, String str, StrokeLineJoin strokeLineJoin, String str2) {
        APIlib.getInstance().addJSLine(String.format(Locale.US, this.jsBase + ".selectMarqueeStroke(%s, %s, %s, %s, %s);", stroke != null ? stroke.getJsBase() : null, number, wrapQuotes(str), strokeLineJoin != null ? strokeLineJoin.getJsBase() : null, wrapQuotes(str2)));
        return this;
    }

    @Override // com.anychart.core.SeparateChart, com.anychart.core.Chart
    public Cartesian3d selectMarqueeStroke(Stroke stroke, Number number, String str, StrokeLineJoin strokeLineJoin, StrokeLineCap strokeLineCap) {
        APIlib.getInstance().addJSLine(String.format(Locale.US, this.jsBase + ".selectMarqueeStroke(%s, %s, %s, %s, %s);", stroke != null ? stroke.getJsBase() : null, number, wrapQuotes(str), strokeLineJoin != null ? strokeLineJoin.getJsBase() : null, strokeLineCap != null ? strokeLineCap.getJsBase() : null));
        return this;
    }

    @Override // com.anychart.core.SeparateChart, com.anychart.core.Chart
    public Cartesian3d selectMarqueeStroke(ColoredFill coloredFill, Number number, String str, String str2, String str3) {
        APIlib.getInstance().addJSLine(String.format(Locale.US, this.jsBase + ".selectMarqueeStroke(%s, %s, %s, %s, %s);", coloredFill != null ? coloredFill.getJsBase() : null, number, wrapQuotes(str), wrapQuotes(str2), wrapQuotes(str3)));
        return this;
    }

    @Override // com.anychart.core.SeparateChart, com.anychart.core.Chart
    public Cartesian3d selectMarqueeStroke(ColoredFill coloredFill, Number number, String str, String str2, StrokeLineCap strokeLineCap) {
        APIlib.getInstance().addJSLine(String.format(Locale.US, this.jsBase + ".selectMarqueeStroke(%s, %s, %s, %s, %s);", coloredFill != null ? coloredFill.getJsBase() : null, number, wrapQuotes(str), wrapQuotes(str2), strokeLineCap != null ? strokeLineCap.getJsBase() : null));
        return this;
    }

    @Override // com.anychart.core.SeparateChart, com.anychart.core.Chart
    public Cartesian3d selectMarqueeStroke(ColoredFill coloredFill, Number number, String str, StrokeLineJoin strokeLineJoin, String str2) {
        APIlib.getInstance().addJSLine(String.format(Locale.US, this.jsBase + ".selectMarqueeStroke(%s, %s, %s, %s, %s);", coloredFill != null ? coloredFill.getJsBase() : null, number, wrapQuotes(str), strokeLineJoin != null ? strokeLineJoin.getJsBase() : null, wrapQuotes(str2)));
        return this;
    }

    @Override // com.anychart.core.SeparateChart, com.anychart.core.Chart
    public Cartesian3d selectMarqueeStroke(ColoredFill coloredFill, Number number, String str, StrokeLineJoin strokeLineJoin, StrokeLineCap strokeLineCap) {
        APIlib.getInstance().addJSLine(String.format(Locale.US, this.jsBase + ".selectMarqueeStroke(%s, %s, %s, %s, %s);", coloredFill != null ? coloredFill.getJsBase() : null, number, wrapQuotes(str), strokeLineJoin != null ? strokeLineJoin.getJsBase() : null, strokeLineCap != null ? strokeLineCap.getJsBase() : null));
        return this;
    }

    @Override // com.anychart.core.SeparateChart, com.anychart.core.Chart
    public Cartesian3d selectMarqueeStroke(String str, Number number, String str2, String str3, String str4) {
        APIlib.getInstance().addJSLine(String.format(Locale.US, this.jsBase + ".selectMarqueeStroke(%s, %s, %s, %s, %s);", wrapQuotes(str), number, wrapQuotes(str2), wrapQuotes(str3), wrapQuotes(str4)));
        return this;
    }

    @Override // com.anychart.core.SeparateChart, com.anychart.core.Chart
    public Cartesian3d selectMarqueeStroke(String str, Number number, String str2, String str3, StrokeLineCap strokeLineCap) {
        APIlib.getInstance().addJSLine(String.format(Locale.US, this.jsBase + ".selectMarqueeStroke(%s, %s, %s, %s, %s);", wrapQuotes(str), number, wrapQuotes(str2), wrapQuotes(str3), strokeLineCap != null ? strokeLineCap.getJsBase() : null));
        return this;
    }

    @Override // com.anychart.core.SeparateChart, com.anychart.core.Chart
    public Cartesian3d selectMarqueeStroke(String str, Number number, String str2, StrokeLineJoin strokeLineJoin, String str3) {
        APIlib.getInstance().addJSLine(String.format(Locale.US, this.jsBase + ".selectMarqueeStroke(%s, %s, %s, %s, %s);", wrapQuotes(str), number, wrapQuotes(str2), strokeLineJoin != null ? strokeLineJoin.getJsBase() : null, wrapQuotes(str3)));
        return this;
    }

    @Override // com.anychart.core.SeparateChart, com.anychart.core.Chart
    public Cartesian3d selectMarqueeStroke(String str, Number number, String str2, StrokeLineJoin strokeLineJoin, StrokeLineCap strokeLineCap) {
        APIlib.getInstance().addJSLine(String.format(Locale.US, this.jsBase + ".selectMarqueeStroke(%s, %s, %s, %s, %s);", wrapQuotes(str), number, wrapQuotes(str2), strokeLineJoin != null ? strokeLineJoin.getJsBase() : null, strokeLineCap != null ? strokeLineCap.getJsBase() : null));
        return this;
    }

    public StateSettings selected() {
        return new StateSettings(this.jsBase + ".selected()");
    }

    public Cartesian3d selected(String str) {
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

    @Override // com.anychart.core.SeparateChart, com.anychart.core.Chart
    public Cartesian3d startSelectMarquee(Boolean bool) {
        APIlib.getInstance().addJSLine(String.format(Locale.US, this.jsBase + ".startSelectMarquee(%s);", bool));
        return this;
    }

    public Text textMarker(Number number) {
        return new Text(String.format(Locale.US, this.jsBase + ".textMarker(%s)", number));
    }

    public Cartesian3d textMarker(String str) {
        APIlib.getInstance().addJSLine(String.format(Locale.US, this.jsBase + ".textMarker(%s);", wrapQuotes(str)));
        return this;
    }

    public Cartesian3d textMarker(Boolean bool) {
        APIlib.getInstance().addJSLine(String.format(Locale.US, this.jsBase + ".textMarker(%s);", bool));
        return this;
    }

    public Cartesian3d textMarker(Number number, String str) {
        APIlib.getInstance().addJSLine(String.format(Locale.US, this.jsBase + ".textMarker(%s, %s);", number, wrapQuotes(str)));
        return this;
    }

    public Cartesian3d textMarker(Number number, Boolean bool) {
        APIlib.getInstance().addJSLine(String.format(Locale.US, this.jsBase + ".textMarker(%s, %s);", number, bool));
        return this;
    }

    @Override // com.anychart.core.SeparateChart, com.anychart.core.Chart
    public Title title() {
        return new Title(this.jsBase + ".title()");
    }

    @Override // com.anychart.core.SeparateChart, com.anychart.core.Chart
    public Cartesian3d title(Boolean bool) {
        APIlib.getInstance().addJSLine(String.format(Locale.US, this.jsBase + ".title(%s);", bool));
        return this;
    }

    @Override // com.anychart.core.SeparateChart, com.anychart.core.Chart
    public Cartesian3d title(String str) {
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
    public Cartesian3d tooltip(String str) {
        APIlib.getInstance().addJSLine(String.format(Locale.US, this.jsBase + ".tooltip(%s);", wrapQuotes(str)));
        return this;
    }

    @Override // com.anychart.core.SeparateChart, com.anychart.core.Chart
    public Cartesian3d tooltip(Boolean bool) {
        APIlib.getInstance().addJSLine(String.format(Locale.US, this.jsBase + ".tooltip(%s);", bool));
        return this;
    }

    @Override // com.anychart.core.SeparateChart, com.anychart.core.Chart, com.anychart.core.VisualBaseWithBounds
    public void top() {
        APIlib.getInstance().addJSLine(this.jsBase + ".top();");
    }

    @Override // com.anychart.core.SeparateChart, com.anychart.core.Chart, com.anychart.core.VisualBaseWithBounds
    public Cartesian3d top(Number number) {
        APIlib.getInstance().addJSLine(String.format(Locale.US, this.jsBase + ".top(%s);", number));
        return this;
    }

    @Override // com.anychart.core.SeparateChart, com.anychart.core.Chart, com.anychart.core.VisualBaseWithBounds
    public Cartesian3d top(String str) {
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
    public Cartesian3d width(Number number) {
        APIlib.getInstance().addJSLine(String.format(Locale.US, this.jsBase + ".width(%s);", number));
        return this;
    }

    @Override // com.anychart.core.SeparateChart, com.anychart.core.Chart, com.anychart.core.VisualBaseWithBounds
    public Cartesian3d width(String str) {
        APIlib.getInstance().addJSLine(String.format(Locale.US, this.jsBase + ".width(%s);", wrapQuotes(str)));
        return this;
    }

    public Linear xAxis(Number number) {
        return new Linear(String.format(Locale.US, this.jsBase + ".xAxis(%s)", number));
    }

    public Cartesian3d xAxis(String str) {
        APIlib.getInstance().addJSLine(String.format(Locale.US, this.jsBase + ".xAxis(%s);", wrapQuotes(str)));
        return this;
    }

    public Cartesian3d xAxis(Boolean bool) {
        APIlib.getInstance().addJSLine(String.format(Locale.US, this.jsBase + ".xAxis(%s);", bool));
        return this;
    }

    public Cartesian3d xAxis(Number number, String str) {
        APIlib.getInstance().addJSLine(String.format(Locale.US, this.jsBase + ".xAxis(%s, %s);", number, wrapQuotes(str)));
        return this;
    }

    public Cartesian3d xAxis(Number number, Boolean bool) {
        APIlib.getInstance().addJSLine(String.format(Locale.US, this.jsBase + ".xAxis(%s, %s);", number, bool));
        return this;
    }

    public com.anychart.core.grids.Linear xGrid(Number number) {
        return new com.anychart.core.grids.Linear(String.format(Locale.US, this.jsBase + ".xGrid(%s)", number));
    }

    public Cartesian3d xGrid(String str) {
        APIlib.getInstance().addJSLine(String.format(Locale.US, this.jsBase + ".xGrid(%s);", wrapQuotes(str)));
        return this;
    }

    public Cartesian3d xGrid(Boolean bool) {
        APIlib.getInstance().addJSLine(String.format(Locale.US, this.jsBase + ".xGrid(%s);", bool));
        return this;
    }

    public Cartesian3d xGrid(Number number, String str) {
        APIlib.getInstance().addJSLine(String.format(Locale.US, this.jsBase + ".xGrid(%s, %s);", number, wrapQuotes(str)));
        return this;
    }

    public Cartesian3d xGrid(Number number, Boolean bool) {
        APIlib.getInstance().addJSLine(String.format(Locale.US, this.jsBase + ".xGrid(%s, %s);", number, bool));
        return this;
    }

    public com.anychart.core.grids.Linear xMinorGrid(Number number) {
        return new com.anychart.core.grids.Linear(String.format(Locale.US, this.jsBase + ".xMinorGrid(%s)", number));
    }

    public Cartesian3d xMinorGrid(String str) {
        APIlib.getInstance().addJSLine(String.format(Locale.US, this.jsBase + ".xMinorGrid(%s);", wrapQuotes(str)));
        return this;
    }

    public Cartesian3d xMinorGrid(Boolean bool) {
        APIlib.getInstance().addJSLine(String.format(Locale.US, this.jsBase + ".xMinorGrid(%s);", bool));
        return this;
    }

    public Cartesian3d xMinorGrid(Number number, String str) {
        APIlib.getInstance().addJSLine(String.format(Locale.US, this.jsBase + ".xMinorGrid(%s, %s);", number, wrapQuotes(str)));
        return this;
    }

    public Cartesian3d xMinorGrid(Number number, Boolean bool) {
        APIlib.getInstance().addJSLine(String.format(Locale.US, this.jsBase + ".xMinorGrid(%s, %s);", number, bool));
        return this;
    }

    public Ordinal xScale() {
        return new Ordinal(this.jsBase + ".xScale()");
    }

    public Cartesian3d xScale(String str) {
        APIlib.getInstance().addJSLine(String.format(Locale.US, this.jsBase + ".xScale(%s);", wrapQuotes(str)));
        return this;
    }

    public Cartesian3d xScale(ScaleTypes scaleTypes) {
        APIlib.getInstance().addJSLine(String.format(Locale.US, this.jsBase + ".xScale(%s);", scaleTypes != null ? scaleTypes.getJsBase() : null));
        return this;
    }

    public Cartesian3d xScale(com.anychart.scales.Base base) {
        APIlib.getInstance().addJSLine(String.format(Locale.US, this.jsBase + ".xScale(%s);", base != null ? base.getJsBase() : null));
        return this;
    }

    public ChartScroller xScroller() {
        return new ChartScroller(this.jsBase + ".xScroller()");
    }

    public Cartesian3d xScroller(String str) {
        APIlib.getInstance().addJSLine(String.format(Locale.US, this.jsBase + ".xScroller(%s);", wrapQuotes(str)));
        return this;
    }

    public Cartesian3d xScroller(Boolean bool) {
        APIlib.getInstance().addJSLine(String.format(Locale.US, this.jsBase + ".xScroller(%s);", bool));
        return this;
    }

    public OrdinalZoom xZoom() {
        return new OrdinalZoom(this.jsBase + ".xZoom()");
    }

    public Cartesian3d xZoom(Number number) {
        APIlib.getInstance().addJSLine(String.format(Locale.US, this.jsBase + ".xZoom(%s);", number));
        return this;
    }

    public Cartesian3d xZoom(Boolean bool) {
        APIlib.getInstance().addJSLine(String.format(Locale.US, this.jsBase + ".xZoom(%s);", bool));
        return this;
    }

    public Cartesian3d xZoom(String str) {
        APIlib.getInstance().addJSLine(String.format(Locale.US, this.jsBase + ".xZoom(%s);", wrapQuotes(str)));
        return this;
    }

    public Linear yAxis(Number number) {
        return new Linear(String.format(Locale.US, this.jsBase + ".yAxis(%s)", number));
    }

    public Cartesian3d yAxis(String str) {
        APIlib.getInstance().addJSLine(String.format(Locale.US, this.jsBase + ".yAxis(%s);", wrapQuotes(str)));
        return this;
    }

    public Cartesian3d yAxis(Boolean bool) {
        APIlib.getInstance().addJSLine(String.format(Locale.US, this.jsBase + ".yAxis(%s);", bool));
        return this;
    }

    public Cartesian3d yAxis(Number number, String str) {
        APIlib.getInstance().addJSLine(String.format(Locale.US, this.jsBase + ".yAxis(%s, %s);", number, wrapQuotes(str)));
        return this;
    }

    public Cartesian3d yAxis(Number number, Boolean bool) {
        APIlib.getInstance().addJSLine(String.format(Locale.US, this.jsBase + ".yAxis(%s, %s);", number, bool));
        return this;
    }

    public com.anychart.core.grids.Linear yGrid(Number number) {
        return new com.anychart.core.grids.Linear(String.format(Locale.US, this.jsBase + ".yGrid(%s)", number));
    }

    public Cartesian3d yGrid(String str) {
        APIlib.getInstance().addJSLine(String.format(Locale.US, this.jsBase + ".yGrid(%s);", wrapQuotes(str)));
        return this;
    }

    public Cartesian3d yGrid(Boolean bool) {
        APIlib.getInstance().addJSLine(String.format(Locale.US, this.jsBase + ".yGrid(%s);", bool));
        return this;
    }

    public Cartesian3d yGrid(Number number, String str) {
        APIlib.getInstance().addJSLine(String.format(Locale.US, this.jsBase + ".yGrid(%s, %s);", number, wrapQuotes(str)));
        return this;
    }

    public Cartesian3d yGrid(Number number, Boolean bool) {
        APIlib.getInstance().addJSLine(String.format(Locale.US, this.jsBase + ".yGrid(%s, %s);", number, bool));
        return this;
    }

    public com.anychart.core.grids.Linear yMinorGrid(Number number) {
        return new com.anychart.core.grids.Linear(String.format(Locale.US, this.jsBase + ".yMinorGrid(%s)", number));
    }

    public Cartesian3d yMinorGrid(String str) {
        APIlib.getInstance().addJSLine(String.format(Locale.US, this.jsBase + ".yMinorGrid(%s);", wrapQuotes(str)));
        return this;
    }

    public Cartesian3d yMinorGrid(Boolean bool) {
        APIlib.getInstance().addJSLine(String.format(Locale.US, this.jsBase + ".yMinorGrid(%s);", bool));
        return this;
    }

    public Cartesian3d yMinorGrid(Number number, String str) {
        APIlib.getInstance().addJSLine(String.format(Locale.US, this.jsBase + ".yMinorGrid(%s, %s);", number, wrapQuotes(str)));
        return this;
    }

    public Cartesian3d yMinorGrid(Number number, Boolean bool) {
        APIlib.getInstance().addJSLine(String.format(Locale.US, this.jsBase + ".yMinorGrid(%s, %s);", number, bool));
        return this;
    }

    public com.anychart.scales.Linear yScale() {
        return new com.anychart.scales.Linear(this.jsBase + ".yScale()");
    }

    public Cartesian3d yScale(String str) {
        APIlib.getInstance().addJSLine(String.format(Locale.US, this.jsBase + ".yScale(%s);", wrapQuotes(str)));
        return this;
    }

    public Cartesian3d yScale(ScaleTypes scaleTypes) {
        APIlib.getInstance().addJSLine(String.format(Locale.US, this.jsBase + ".yScale(%s);", scaleTypes != null ? scaleTypes.getJsBase() : null));
        return this;
    }

    public Cartesian3d yScale(com.anychart.scales.Base base) {
        APIlib.getInstance().addJSLine(String.format(Locale.US, this.jsBase + ".yScale(%s);", base != null ? base.getJsBase() : null));
        return this;
    }

    public void zAngle() {
        APIlib.getInstance().addJSLine(this.jsBase + ".zAngle();");
    }

    public Cartesian3d zAngle(Number number) {
        APIlib.getInstance().addJSLine(String.format(Locale.US, this.jsBase + ".zAngle(%s);", number));
        return this;
    }

    public void zAspect() {
        APIlib.getInstance().addJSLine(this.jsBase + ".zAspect();");
    }

    public Cartesian3d zAspect(Number number) {
        APIlib.getInstance().addJSLine(String.format(Locale.US, this.jsBase + ".zAspect(%s);", number));
        return this;
    }

    public Cartesian3d zAspect(String str) {
        APIlib.getInstance().addJSLine(String.format(Locale.US, this.jsBase + ".zAspect(%s);", wrapQuotes(str)));
        return this;
    }

    public void zDepth() {
        APIlib.getInstance().addJSLine(this.jsBase + ".zDepth();");
    }

    public Cartesian3d zDepth(Number number) {
        APIlib.getInstance().addJSLine(String.format(Locale.US, this.jsBase + ".zDepth(%s);", number));
        return this;
    }

    public void zDistribution() {
        APIlib.getInstance().addJSLine(this.jsBase + ".zDistribution();");
    }

    public Cartesian3d zDistribution(Boolean bool) {
        APIlib.getInstance().addJSLine(String.format(Locale.US, this.jsBase + ".zDistribution(%s);", bool));
        return this;
    }

    @Override // com.anychart.core.SeparateChart, com.anychart.core.Chart, com.anychart.core.VisualBaseWithBounds, com.anychart.core.VisualBase
    public void zIndex() {
        APIlib.getInstance().addJSLine(this.jsBase + ".zIndex();");
    }

    @Override // com.anychart.core.SeparateChart, com.anychart.core.Chart, com.anychart.core.VisualBaseWithBounds, com.anychart.core.VisualBase
    public Cartesian3d zIndex(Number number) {
        APIlib.getInstance().addJSLine(String.format(Locale.US, this.jsBase + ".zIndex(%s);", number));
        return this;
    }

    public void zPadding() {
        APIlib.getInstance().addJSLine(this.jsBase + ".zPadding();");
    }

    public Cartesian3d zPadding(Number number) {
        APIlib.getInstance().addJSLine(String.format(Locale.US, this.jsBase + ".zPadding(%s);", number));
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
    public Cartesian3d parentBounds(Rect rect) {
        APIlib.getInstance().addJSLine(String.format(Locale.US, this.jsBase + ".parentBounds(%s);", rect != null ? rect.getJsBase() : null));
        return this;
    }

    @Override // com.anychart.core.SeparateChart, com.anychart.core.Chart, com.anychart.core.VisualBaseWithBounds, com.anychart.core.VisualBase
    public Cartesian3d parentBounds(String str) {
        APIlib.getInstance().addJSLine(String.format(Locale.US, this.jsBase + ".parentBounds(%s);", wrapQuotes(str)));
        return this;
    }

    @Override // com.anychart.core.SeparateChart, com.anychart.core.Chart, com.anychart.core.VisualBaseWithBounds, com.anychart.core.VisualBase
    public Cartesian3d parentBounds(Number number) {
        APIlib.getInstance().addJSLine(String.format(Locale.US, this.jsBase + ".parentBounds(%s);", number));
        return this;
    }

    @Override // com.anychart.core.SeparateChart, com.anychart.core.Chart, com.anychart.core.VisualBaseWithBounds, com.anychart.core.VisualBase
    public Cartesian3d parentBounds(Number number, Number number2, Number number3, Number number4) {
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

    public Area3d area(View view) {
        return new Area3d(String.format(Locale.US, this.jsBase + ".area(%s)", view != null ? view.getJsBase() : null));
    }

    public Bar3d bar(View view) {
        return new Bar3d(String.format(Locale.US, this.jsBase + ".bar(%s)", view != null ? view.getJsBase() : null));
    }

    public Column3d column(View view) {
        return new Column3d(String.format(Locale.US, this.jsBase + ".column(%s)", view != null ? view.getJsBase() : null));
    }

    public Line3d line(View view) {
        return new Line3d(String.format(Locale.US, this.jsBase + ".line(%s)", view != null ? view.getJsBase() : null));
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
