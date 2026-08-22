package com.anychart.charts;

import com.amazonaws.services.s3.model.InstructionFileId;
import com.anychart.APIlib;
import com.anychart.chart.common.listener.ListenersInterface;
import com.anychart.core.Chart;
import com.anychart.core.NoDataSettings;
import com.anychart.core.SeparateChart;
import com.anychart.core.annotations.ChartController;
import com.anychart.core.stock.Grouping;
import com.anychart.core.stock.Plot;
import com.anychart.core.stock.Scroller;
import com.anychart.core.stock.eventmarkers.Controller;
import com.anychart.core.stock.grouping.Level;
import com.anychart.core.ui.Background;
import com.anychart.core.ui.ChartCredits;
import com.anychart.core.ui.Crosshair;
import com.anychart.core.ui.Label;
import com.anychart.core.ui.Title;
import com.anychart.core.ui.Tooltip;
import com.anychart.core.utils.Animation;
import com.anychart.core.utils.Bounds;
import com.anychart.core.utils.ChartA11y;
import com.anychart.core.utils.Exports;
import com.anychart.core.utils.Margin;
import com.anychart.core.utils.Padding;
import com.anychart.core.utils.StockInteractivity;
import com.anychart.enums.ChartDataExportMode;
import com.anychart.enums.HoverMode;
import com.anychart.enums.Interval;
import com.anychart.enums.ScaleTypes;
import com.anychart.enums.Statistics;
import com.anychart.enums.StockRangeAnchor;
import com.anychart.enums.StockRangeType;
import com.anychart.graphics.vector.ColoredFill;
import com.anychart.graphics.vector.Fill;
import com.anychart.graphics.vector.GradientKey;
import com.anychart.graphics.vector.Layer;
import com.anychart.graphics.vector.PaperSize;
import com.anychart.graphics.vector.Stage;
import com.anychart.graphics.vector.Stroke;
import com.anychart.graphics.vector.StrokeLineCap;
import com.anychart.graphics.vector.StrokeLineJoin;
import com.anychart.math.Rect;
import com.anychart.scales.StockScatterDateTime;
import com.anychart.ui.ContextMenu;
import com.anychart.utils.RectObj;
import java.lang.reflect.InvocationTargetException;
import java.util.Arrays;
import java.util.Locale;

/* JADX INFO: loaded from: classes4.dex */
public class Stock extends Chart {
    protected Stock() {
    }

    public static Stock instantiate() {
        return new Stock("new anychart.charts.stock()");
    }

    public Stock(String str) {
        StringBuilder sb = new StringBuilder("stock");
        int i = variableIndex + 1;
        variableIndex = i;
        this.jsBase = sb.append(i).toString();
        APIlib.getInstance().addJSLine(this.jsBase + " = " + str + ";");
    }

    @Override // com.anychart.core.Chart, com.anychart.core.VisualBaseWithBounds, com.anychart.core.VisualBase, com.anychart.core.Base, com.anychart.JsObject
    public String getJsBase() {
        return this.jsBase;
    }

    @Override // com.anychart.core.Chart
    public ChartA11y a11y() {
        return new ChartA11y(this.jsBase + ".a11y()");
    }

    @Override // com.anychart.core.Chart
    public Stock a11y(Boolean bool) {
        APIlib.getInstance().addJSLine(String.format(Locale.US, this.jsBase + ".a11y(%s);", bool));
        return this;
    }

    @Override // com.anychart.core.Chart
    public Stock a11y(String str) {
        APIlib.getInstance().addJSLine(String.format(Locale.US, this.jsBase + ".a11y(%s);", wrapQuotes(str)));
        return this;
    }

    @Override // com.anychart.core.Chart
    public Animation animation() {
        return new Animation(this.jsBase + ".animation()");
    }

    @Override // com.anychart.core.Chart
    public Stock animation(Boolean bool) {
        APIlib.getInstance().addJSLine(String.format(Locale.US, this.jsBase + ".animation(%s);", bool));
        return this;
    }

    @Override // com.anychart.core.Chart
    public Stock animation(String str) {
        APIlib.getInstance().addJSLine(String.format(Locale.US, this.jsBase + ".animation(%s);", wrapQuotes(str)));
        return this;
    }

    @Override // com.anychart.core.Chart
    public Stock animation(Boolean bool, Number number) {
        APIlib.getInstance().addJSLine(String.format(Locale.US, this.jsBase + ".animation(%s, %s);", bool, number));
        return this;
    }

    public ChartController annotations() {
        return new ChartController(this.jsBase + ".annotations()");
    }

    @Override // com.anychart.core.Chart
    public void autoRedraw() {
        APIlib.getInstance().addJSLine(this.jsBase + ".autoRedraw();");
    }

    @Override // com.anychart.core.Chart
    public Stock autoRedraw(Boolean bool) {
        APIlib.getInstance().addJSLine(String.format(Locale.US, this.jsBase + ".autoRedraw(%s);", bool));
        return this;
    }

    @Override // com.anychart.core.Chart
    public Background background() {
        return new Background(this.jsBase + ".background()");
    }

    @Override // com.anychart.core.Chart
    public Stock background(String str) {
        APIlib.getInstance().addJSLine(String.format(Locale.US, this.jsBase + ".background(%s);", wrapQuotes(str)));
        return this;
    }

    @Override // com.anychart.core.Chart, com.anychart.core.VisualBaseWithBounds
    public void bottom() {
        APIlib.getInstance().addJSLine(this.jsBase + ".bottom();");
    }

    @Override // com.anychart.core.Chart, com.anychart.core.VisualBaseWithBounds
    public Stock bottom(Number number) {
        APIlib.getInstance().addJSLine(String.format(Locale.US, this.jsBase + ".bottom(%s);", number));
        return this;
    }

    @Override // com.anychart.core.Chart, com.anychart.core.VisualBaseWithBounds
    public Stock bottom(String str) {
        APIlib.getInstance().addJSLine(String.format(Locale.US, this.jsBase + ".bottom(%s);", wrapQuotes(str)));
        return this;
    }

    @Override // com.anychart.core.Chart, com.anychart.core.VisualBaseWithBounds
    public Bounds bounds() {
        return new Bounds(this.jsBase + ".bounds()");
    }

    @Override // com.anychart.core.Chart, com.anychart.core.VisualBaseWithBounds
    public Stock bounds(RectObj rectObj) {
        APIlib.getInstance().addJSLine(String.format(Locale.US, this.jsBase + ".bounds(%s);", rectObj != null ? rectObj.getJsBase() : null));
        return this;
    }

    @Override // com.anychart.core.Chart, com.anychart.core.VisualBaseWithBounds
    public Stock bounds(Rect rect) {
        APIlib.getInstance().addJSLine(String.format(Locale.US, this.jsBase + ".bounds(%s);", rect != null ? rect.getJsBase() : null));
        return this;
    }

    @Override // com.anychart.core.Chart, com.anychart.core.VisualBaseWithBounds
    public Stock bounds(Bounds bounds) {
        APIlib.getInstance().addJSLine(String.format(Locale.US, this.jsBase + ".bounds(%s);", bounds != null ? bounds.getJsBase() : null));
        return this;
    }

    @Override // com.anychart.core.Chart, com.anychart.core.VisualBaseWithBounds
    public Stock bounds(Number number, Number number2, Number number3, Number number4) {
        APIlib.getInstance().addJSLine(String.format(Locale.US, this.jsBase + ".bounds(%s, %s, %s, %s);", number, number2, number3, number4));
        return this;
    }

    @Override // com.anychart.core.Chart, com.anychart.core.VisualBaseWithBounds
    public Stock bounds(Number number, Number number2, Number number3, String str) {
        APIlib.getInstance().addJSLine(String.format(Locale.US, this.jsBase + ".bounds(%s, %s, %s, %s);", number, number2, number3, wrapQuotes(str)));
        return this;
    }

    @Override // com.anychart.core.Chart, com.anychart.core.VisualBaseWithBounds
    public Stock bounds(Number number, Number number2, String str, Number number3) {
        APIlib.getInstance().addJSLine(String.format(Locale.US, this.jsBase + ".bounds(%s, %s, %s, %s);", number, number2, wrapQuotes(str), number3));
        return this;
    }

    @Override // com.anychart.core.Chart, com.anychart.core.VisualBaseWithBounds
    public Stock bounds(Number number, Number number2, String str, String str2) {
        APIlib.getInstance().addJSLine(String.format(Locale.US, this.jsBase + ".bounds(%s, %s, %s, %s);", number, number2, wrapQuotes(str), wrapQuotes(str2)));
        return this;
    }

    @Override // com.anychart.core.Chart, com.anychart.core.VisualBaseWithBounds
    public Stock bounds(Number number, String str, Number number2, Number number3) {
        APIlib.getInstance().addJSLine(String.format(Locale.US, this.jsBase + ".bounds(%s, %s, %s, %s);", number, wrapQuotes(str), number2, number3));
        return this;
    }

    @Override // com.anychart.core.Chart, com.anychart.core.VisualBaseWithBounds
    public Stock bounds(Number number, String str, Number number2, String str2) {
        APIlib.getInstance().addJSLine(String.format(Locale.US, this.jsBase + ".bounds(%s, %s, %s, %s);", number, wrapQuotes(str), number2, wrapQuotes(str2)));
        return this;
    }

    @Override // com.anychart.core.Chart, com.anychart.core.VisualBaseWithBounds
    public Stock bounds(Number number, String str, String str2, Number number2) {
        APIlib.getInstance().addJSLine(String.format(Locale.US, this.jsBase + ".bounds(%s, %s, %s, %s);", number, wrapQuotes(str), wrapQuotes(str2), number2));
        return this;
    }

    @Override // com.anychart.core.Chart, com.anychart.core.VisualBaseWithBounds
    public Stock bounds(Number number, String str, String str2, String str3) {
        APIlib.getInstance().addJSLine(String.format(Locale.US, this.jsBase + ".bounds(%s, %s, %s, %s);", number, wrapQuotes(str), wrapQuotes(str2), wrapQuotes(str3)));
        return this;
    }

    @Override // com.anychart.core.Chart, com.anychart.core.VisualBaseWithBounds
    public Stock bounds(String str, Number number, Number number2, Number number3) {
        APIlib.getInstance().addJSLine(String.format(Locale.US, this.jsBase + ".bounds(%s, %s, %s, %s);", wrapQuotes(str), number, number2, number3));
        return this;
    }

    @Override // com.anychart.core.Chart, com.anychart.core.VisualBaseWithBounds
    public Stock bounds(String str, Number number, Number number2, String str2) {
        APIlib.getInstance().addJSLine(String.format(Locale.US, this.jsBase + ".bounds(%s, %s, %s, %s);", wrapQuotes(str), number, number2, wrapQuotes(str2)));
        return this;
    }

    @Override // com.anychart.core.Chart, com.anychart.core.VisualBaseWithBounds
    public Stock bounds(String str, Number number, String str2, Number number2) {
        APIlib.getInstance().addJSLine(String.format(Locale.US, this.jsBase + ".bounds(%s, %s, %s, %s);", wrapQuotes(str), number, wrapQuotes(str2), number2));
        return this;
    }

    @Override // com.anychart.core.Chart, com.anychart.core.VisualBaseWithBounds
    public Stock bounds(String str, Number number, String str2, String str3) {
        APIlib.getInstance().addJSLine(String.format(Locale.US, this.jsBase + ".bounds(%s, %s, %s, %s);", wrapQuotes(str), number, wrapQuotes(str2), wrapQuotes(str3)));
        return this;
    }

    @Override // com.anychart.core.Chart, com.anychart.core.VisualBaseWithBounds
    public Stock bounds(String str, String str2, Number number, Number number2) {
        APIlib.getInstance().addJSLine(String.format(Locale.US, this.jsBase + ".bounds(%s, %s, %s, %s);", wrapQuotes(str), wrapQuotes(str2), number, number2));
        return this;
    }

    @Override // com.anychart.core.Chart, com.anychart.core.VisualBaseWithBounds
    public Stock bounds(String str, String str2, Number number, String str3) {
        APIlib.getInstance().addJSLine(String.format(Locale.US, this.jsBase + ".bounds(%s, %s, %s, %s);", wrapQuotes(str), wrapQuotes(str2), number, wrapQuotes(str3)));
        return this;
    }

    @Override // com.anychart.core.Chart, com.anychart.core.VisualBaseWithBounds
    public Stock bounds(String str, String str2, String str3, Number number) {
        APIlib.getInstance().addJSLine(String.format(Locale.US, this.jsBase + ".bounds(%s, %s, %s, %s);", wrapQuotes(str), wrapQuotes(str2), wrapQuotes(str3), number));
        return this;
    }

    @Override // com.anychart.core.Chart, com.anychart.core.VisualBaseWithBounds
    public Stock bounds(String str, String str2, String str3, String str4) {
        APIlib.getInstance().addJSLine(String.format(Locale.US, this.jsBase + ".bounds(%s, %s, %s, %s);", wrapQuotes(str), wrapQuotes(str2), wrapQuotes(str3), wrapQuotes(str4)));
        return this;
    }

    @Override // com.anychart.core.Chart
    public Stock cancelMarquee() {
        APIlib.getInstance().addJSLine(this.jsBase + ".cancelMarquee();");
        return this;
    }

    @Override // com.anychart.core.Chart, com.anychart.core.VisualBaseWithBounds, com.anychart.core.VisualBase
    public Layer container() {
        return new Layer(this.jsBase + ".container()");
    }

    @Override // com.anychart.core.Chart, com.anychart.core.VisualBaseWithBounds, com.anychart.core.VisualBase
    public Stock container(Layer layer) {
        APIlib.getInstance().addJSLine(String.format(Locale.US, this.jsBase + ".container(%s);", layer != null ? layer.getJsBase() : null));
        return this;
    }

    @Override // com.anychart.core.Chart, com.anychart.core.VisualBaseWithBounds, com.anychart.core.VisualBase
    public Stock container(Stage stage) {
        APIlib.getInstance().addJSLine(String.format(Locale.US, this.jsBase + ".container(%s);", stage != null ? stage.getJsBase() : null));
        return this;
    }

    @Override // com.anychart.core.Chart, com.anychart.core.VisualBaseWithBounds, com.anychart.core.VisualBase
    public Stock container(String str) {
        APIlib.getInstance().addJSLine(String.format(Locale.US, this.jsBase + ".container(%s);", wrapQuotes(str)));
        return this;
    }

    @Override // com.anychart.core.Chart
    public ContextMenu contextMenu() {
        return new ContextMenu(this.jsBase + ".contextMenu()");
    }

    @Override // com.anychart.core.Chart
    public Stock contextMenu(String str) {
        APIlib.getInstance().addJSLine(String.format(Locale.US, this.jsBase + ".contextMenu(%s);", wrapQuotes(str)));
        return this;
    }

    @Override // com.anychart.core.Chart
    public Stock contextMenu(Boolean bool) {
        APIlib.getInstance().addJSLine(String.format(Locale.US, this.jsBase + ".contextMenu(%s);", bool));
        return this;
    }

    @Override // com.anychart.core.Chart
    public ChartCredits credits() {
        return new ChartCredits(this.jsBase + ".credits()");
    }

    @Override // com.anychart.core.Chart
    public Stock credits(String str) {
        APIlib.getInstance().addJSLine(String.format(Locale.US, this.jsBase + ".credits(%s);", wrapQuotes(str)));
        return this;
    }

    @Override // com.anychart.core.Chart
    public Stock credits(Boolean bool) {
        APIlib.getInstance().addJSLine(String.format(Locale.US, this.jsBase + ".credits(%s);", bool));
        return this;
    }

    public Crosshair crosshair() {
        return new Crosshair(this.jsBase + ".crosshair()");
    }

    public Stock crosshair(String str) {
        APIlib.getInstance().addJSLine(String.format(Locale.US, this.jsBase + ".crosshair(%s);", wrapQuotes(str)));
        return this;
    }

    public Stock crosshair(Boolean bool) {
        APIlib.getInstance().addJSLine(String.format(Locale.US, this.jsBase + ".crosshair(%s);", bool));
        return this;
    }

    @Override // com.anychart.core.Chart
    public void dispose() {
        APIlib.getInstance().addJSLine(this.jsBase + ".dispose();");
    }

    @Override // com.anychart.core.Chart
    public Stock draw(Boolean bool) {
        APIlib.getInstance().addJSLine(String.format(Locale.US, this.jsBase + ".draw(%s);", bool));
        return this;
    }

    @Override // com.anychart.core.Chart, com.anychart.core.VisualBaseWithBounds, com.anychart.core.VisualBase
    public void enabled() {
        APIlib.getInstance().addJSLine(this.jsBase + ".enabled();");
    }

    @Override // com.anychart.core.Chart, com.anychart.core.VisualBaseWithBounds, com.anychart.core.VisualBase
    public Stock enabled(Boolean bool) {
        APIlib.getInstance().addJSLine(String.format(Locale.US, this.jsBase + ".enabled(%s);", bool));
        return this;
    }

    public Controller eventMarkers() {
        return new Controller(this.jsBase + ".eventMarkers()");
    }

    public Stock eventMarkers(String str) {
        APIlib.getInstance().addJSLine(String.format(Locale.US, this.jsBase + ".eventMarkers(%s);", wrapQuotes(str)));
        return this;
    }

    public Stock eventMarkers(Boolean bool) {
        APIlib.getInstance().addJSLine(String.format(Locale.US, this.jsBase + ".eventMarkers(%s);", bool));
        return this;
    }

    @Override // com.anychart.core.Chart
    public Exports exports() {
        return new Exports(this.jsBase + ".exports()");
    }

    @Override // com.anychart.core.Chart
    public Stock exports(String str) {
        APIlib.getInstance().addJSLine(String.format(Locale.US, this.jsBase + ".exports(%s);", wrapQuotes(str)));
        return this;
    }

    @Override // com.anychart.core.Chart
    public void fullScreen() {
        APIlib.getInstance().addJSLine(this.jsBase + ".fullScreen();");
    }

    @Override // com.anychart.core.Chart
    public Stock fullScreen(Boolean bool) {
        APIlib.getInstance().addJSLine(String.format(Locale.US, this.jsBase + ".fullScreen(%s);", bool));
        return this;
    }

    @Override // com.anychart.core.Chart, com.anychart.core.VisualBaseWithBounds
    public Rect getPixelBounds() {
        return new Rect(this.jsBase + ".getPixelBounds()");
    }

    public void getPlotsCount() {
        APIlib.getInstance().addJSLine(this.jsBase + ".getPlotsCount();");
    }

    @Override // com.anychart.core.Chart
    public void getSelectedPoints() {
        APIlib.getInstance().addJSLine(this.jsBase + ".getSelectedPoints();");
    }

    public void getSelectedRange() {
        APIlib.getInstance().addJSLine(this.jsBase + ".getSelectedRange();");
    }

    @Override // com.anychart.core.Chart
    public void getStat(Statistics statistics) {
        APIlib.getInstance().addJSLine(String.format(Locale.US, this.jsBase + ".getStat(%s);", statistics != null ? statistics.getJsBase() : null));
    }

    @Override // com.anychart.core.Chart
    public void getStat(String str) {
        APIlib.getInstance().addJSLine(String.format(Locale.US, this.jsBase + ".getStat(%s);", wrapQuotes(str)));
    }

    @Override // com.anychart.core.Chart
    public void globalToLocal(Number number, Number number2) {
        APIlib.getInstance().addJSLine(String.format(Locale.US, this.jsBase + ".globalToLocal(%s, %s);", number, number2));
    }

    public Grouping grouping() {
        return new Grouping(this.jsBase + ".grouping()");
    }

    public Stock grouping(Boolean bool) {
        APIlib.getInstance().addJSLine(String.format(Locale.US, this.jsBase + ".grouping(%s);", bool));
        return this;
    }

    public Stock grouping(String[] strArr) {
        APIlib.getInstance().addJSLine(String.format(Locale.US, this.jsBase + ".grouping(%s);", arrayToStringWrapQuotes(strArr)));
        return this;
    }

    public Stock grouping(Level level) {
        APIlib.getInstance().addJSLine(String.format(Locale.US, this.jsBase + ".grouping(%s);", level != null ? level.getJsBase() : null));
        return this;
    }

    public Stock grouping(String str) {
        APIlib.getInstance().addJSLine(String.format(Locale.US, this.jsBase + ".grouping(%s);", wrapQuotes(str)));
        return this;
    }

    @Override // com.anychart.core.Chart, com.anychart.core.VisualBaseWithBounds
    public void height() {
        APIlib.getInstance().addJSLine(this.jsBase + ".height();");
    }

    @Override // com.anychart.core.Chart, com.anychart.core.VisualBaseWithBounds
    public Stock height(Number number) {
        APIlib.getInstance().addJSLine(String.format(Locale.US, this.jsBase + ".height(%s);", number));
        return this;
    }

    @Override // com.anychart.core.Chart, com.anychart.core.VisualBaseWithBounds
    public Stock height(String str) {
        APIlib.getInstance().addJSLine(String.format(Locale.US, this.jsBase + ".height(%s);", wrapQuotes(str)));
        return this;
    }

    @Override // com.anychart.core.Chart
    public void id() {
        APIlib.getInstance().addJSLine(this.jsBase + ".id();");
    }

    @Override // com.anychart.core.Chart
    public Stock id(String str) {
        APIlib.getInstance().addJSLine(String.format(Locale.US, this.jsBase + ".id(%s);", wrapQuotes(str)));
        return this;
    }

    @Override // com.anychart.core.Chart
    public void inMarquee() {
        APIlib.getInstance().addJSLine(this.jsBase + ".inMarquee();");
    }

    public StockInteractivity interactivity() {
        return new StockInteractivity(this.jsBase + ".interactivity()");
    }

    public SeparateChart interactivity(String str) {
        return new SeparateChart(String.format(Locale.US, this.jsBase + ".interactivity(%s)", wrapQuotes(str)));
    }

    public SeparateChart interactivity(HoverMode hoverMode) {
        return new SeparateChart(String.format(Locale.US, this.jsBase + ".interactivity(%s)", hoverMode != null ? hoverMode.getJsBase() : null));
    }

    @Override // com.anychart.core.Chart
    public void isFullScreenAvailable() {
        APIlib.getInstance().addJSLine(this.jsBase + ".isFullScreenAvailable();");
    }

    @Override // com.anychart.core.Chart
    public Label label(String str) {
        return new Label(String.format(Locale.US, this.jsBase + ".label(%s)", wrapQuotes(str)));
    }

    @Override // com.anychart.core.Chart
    public Label label(Number number) {
        return new Label(String.format(Locale.US, this.jsBase + ".label(%s)", number));
    }

    @Override // com.anychart.core.Chart
    public Stock label(Boolean bool) {
        APIlib.getInstance().addJSLine(String.format(Locale.US, this.jsBase + ".label(%s);", bool));
        return this;
    }

    @Override // com.anychart.core.Chart
    public Stock label(String str, Boolean bool) {
        APIlib.getInstance().addJSLine(String.format(Locale.US, this.jsBase + ".label(%s, %s);", wrapQuotes(str), bool));
        return this;
    }

    @Override // com.anychart.core.Chart
    public Stock label(String str, String str2) {
        APIlib.getInstance().addJSLine(String.format(Locale.US, this.jsBase + ".label(%s, %s);", wrapQuotes(str), wrapQuotes(str2)));
        return this;
    }

    @Override // com.anychart.core.Chart
    public Stock label(Number number, Boolean bool) {
        APIlib.getInstance().addJSLine(String.format(Locale.US, this.jsBase + ".label(%s, %s);", number, bool));
        return this;
    }

    @Override // com.anychart.core.Chart
    public Stock label(Number number, String str) {
        APIlib.getInstance().addJSLine(String.format(Locale.US, this.jsBase + ".label(%s, %s);", number, wrapQuotes(str)));
        return this;
    }

    @Override // com.anychart.core.Chart, com.anychart.core.VisualBaseWithBounds
    public void left() {
        APIlib.getInstance().addJSLine(this.jsBase + ".left();");
    }

    @Override // com.anychart.core.Chart, com.anychart.core.VisualBaseWithBounds
    public Stock left(Number number) {
        APIlib.getInstance().addJSLine(String.format(Locale.US, this.jsBase + ".left(%s);", number));
        return this;
    }

    @Override // com.anychart.core.Chart, com.anychart.core.VisualBaseWithBounds
    public Stock left(String str) {
        APIlib.getInstance().addJSLine(String.format(Locale.US, this.jsBase + ".left(%s);", wrapQuotes(str)));
        return this;
    }

    @Override // com.anychart.core.Chart
    public void localToGlobal(Number number, Number number2) {
        APIlib.getInstance().addJSLine(String.format(Locale.US, this.jsBase + ".localToGlobal(%s, %s);", number, number2));
    }

    @Override // com.anychart.core.Chart
    public Margin margin() {
        return new Margin(this.jsBase + ".margin()");
    }

    @Override // com.anychart.core.Chart
    public Stock margin(Number[] numberArr) {
        APIlib.getInstance().addJSLine(String.format(Locale.US, this.jsBase + ".margin(%s);", Arrays.toString(numberArr)));
        return this;
    }

    @Override // com.anychart.core.Chart
    public Stock margin(String[] strArr) {
        APIlib.getInstance().addJSLine(String.format(Locale.US, this.jsBase + ".margin(%s);", arrayToStringWrapQuotes(strArr)));
        return this;
    }

    @Override // com.anychart.core.Chart
    public Stock margin(String str) {
        APIlib.getInstance().addJSLine(String.format(Locale.US, this.jsBase + ".margin(%s);", wrapQuotes(str)));
        return this;
    }

    @Override // com.anychart.core.Chart
    public Stock margin(String str, String str2, String str3, String str4) {
        APIlib.getInstance().addJSLine(String.format(Locale.US, this.jsBase + ".margin(%s, %s, %s, %s);", wrapQuotes(str), wrapQuotes(str2), wrapQuotes(str3), wrapQuotes(str4)));
        return this;
    }

    @Override // com.anychart.core.Chart
    public Stock margin(String str, String str2, String str3, Number number) {
        APIlib.getInstance().addJSLine(String.format(Locale.US, this.jsBase + ".margin(%s, %s, %s, %s);", wrapQuotes(str), wrapQuotes(str2), wrapQuotes(str3), number));
        return this;
    }

    @Override // com.anychart.core.Chart
    public Stock margin(String str, String str2, Number number, String str3) {
        APIlib.getInstance().addJSLine(String.format(Locale.US, this.jsBase + ".margin(%s, %s, %s, %s);", wrapQuotes(str), wrapQuotes(str2), number, wrapQuotes(str3)));
        return this;
    }

    @Override // com.anychart.core.Chart
    public Stock margin(String str, String str2, Number number, Number number2) {
        APIlib.getInstance().addJSLine(String.format(Locale.US, this.jsBase + ".margin(%s, %s, %s, %s);", wrapQuotes(str), wrapQuotes(str2), number, number2));
        return this;
    }

    @Override // com.anychart.core.Chart
    public Stock margin(String str, Number number, String str2, String str3) {
        APIlib.getInstance().addJSLine(String.format(Locale.US, this.jsBase + ".margin(%s, %s, %s, %s);", wrapQuotes(str), number, wrapQuotes(str2), wrapQuotes(str3)));
        return this;
    }

    @Override // com.anychart.core.Chart
    public Stock margin(String str, Number number, String str2, Number number2) {
        APIlib.getInstance().addJSLine(String.format(Locale.US, this.jsBase + ".margin(%s, %s, %s, %s);", wrapQuotes(str), number, wrapQuotes(str2), number2));
        return this;
    }

    @Override // com.anychart.core.Chart
    public Stock margin(String str, Number number, Number number2, String str2) {
        APIlib.getInstance().addJSLine(String.format(Locale.US, this.jsBase + ".margin(%s, %s, %s, %s);", wrapQuotes(str), number, number2, wrapQuotes(str2)));
        return this;
    }

    @Override // com.anychart.core.Chart
    public Stock margin(String str, Number number, Number number2, Number number3) {
        APIlib.getInstance().addJSLine(String.format(Locale.US, this.jsBase + ".margin(%s, %s, %s, %s);", wrapQuotes(str), number, number2, number3));
        return this;
    }

    @Override // com.anychart.core.Chart
    public Stock margin(Number number, String str, String str2, String str3) {
        APIlib.getInstance().addJSLine(String.format(Locale.US, this.jsBase + ".margin(%s, %s, %s, %s);", number, wrapQuotes(str), wrapQuotes(str2), wrapQuotes(str3)));
        return this;
    }

    @Override // com.anychart.core.Chart
    public Stock margin(Number number, String str, String str2, Number number2) {
        APIlib.getInstance().addJSLine(String.format(Locale.US, this.jsBase + ".margin(%s, %s, %s, %s);", number, wrapQuotes(str), wrapQuotes(str2), number2));
        return this;
    }

    @Override // com.anychart.core.Chart
    public Stock margin(Number number, String str, Number number2, String str2) {
        APIlib.getInstance().addJSLine(String.format(Locale.US, this.jsBase + ".margin(%s, %s, %s, %s);", number, wrapQuotes(str), number2, wrapQuotes(str2)));
        return this;
    }

    @Override // com.anychart.core.Chart
    public Stock margin(Number number, String str, Number number2, Number number3) {
        APIlib.getInstance().addJSLine(String.format(Locale.US, this.jsBase + ".margin(%s, %s, %s, %s);", number, wrapQuotes(str), number2, number3));
        return this;
    }

    @Override // com.anychart.core.Chart
    public Stock margin(Number number, Number number2, String str, String str2) {
        APIlib.getInstance().addJSLine(String.format(Locale.US, this.jsBase + ".margin(%s, %s, %s, %s);", number, number2, wrapQuotes(str), wrapQuotes(str2)));
        return this;
    }

    @Override // com.anychart.core.Chart
    public Stock margin(Number number, Number number2, String str, Number number3) {
        APIlib.getInstance().addJSLine(String.format(Locale.US, this.jsBase + ".margin(%s, %s, %s, %s);", number, number2, wrapQuotes(str), number3));
        return this;
    }

    @Override // com.anychart.core.Chart
    public Stock margin(Number number, Number number2, Number number3, String str) {
        APIlib.getInstance().addJSLine(String.format(Locale.US, this.jsBase + ".margin(%s, %s, %s, %s);", number, number2, number3, wrapQuotes(str)));
        return this;
    }

    @Override // com.anychart.core.Chart
    public Stock margin(Number number, Number number2, Number number3, Number number4) {
        APIlib.getInstance().addJSLine(String.format(Locale.US, this.jsBase + ".margin(%s, %s, %s, %s);", number, number2, number3, number4));
        return this;
    }

    @Override // com.anychart.core.Chart, com.anychart.core.VisualBaseWithBounds
    public void maxHeight() {
        APIlib.getInstance().addJSLine(this.jsBase + ".maxHeight();");
    }

    @Override // com.anychart.core.Chart, com.anychart.core.VisualBaseWithBounds
    public Stock maxHeight(Number number) {
        APIlib.getInstance().addJSLine(String.format(Locale.US, this.jsBase + ".maxHeight(%s);", number));
        return this;
    }

    @Override // com.anychart.core.Chart, com.anychart.core.VisualBaseWithBounds
    public Stock maxHeight(String str) {
        APIlib.getInstance().addJSLine(String.format(Locale.US, this.jsBase + ".maxHeight(%s);", wrapQuotes(str)));
        return this;
    }

    @Override // com.anychart.core.Chart, com.anychart.core.VisualBaseWithBounds
    public void maxWidth() {
        APIlib.getInstance().addJSLine(this.jsBase + ".maxWidth();");
    }

    @Override // com.anychart.core.Chart, com.anychart.core.VisualBaseWithBounds
    public Stock maxWidth(Number number) {
        APIlib.getInstance().addJSLine(String.format(Locale.US, this.jsBase + ".maxWidth(%s);", number));
        return this;
    }

    @Override // com.anychart.core.Chart, com.anychart.core.VisualBaseWithBounds
    public Stock maxWidth(String str) {
        APIlib.getInstance().addJSLine(String.format(Locale.US, this.jsBase + ".maxWidth(%s);", wrapQuotes(str)));
        return this;
    }

    @Override // com.anychart.core.Chart, com.anychart.core.VisualBaseWithBounds
    public void minHeight() {
        APIlib.getInstance().addJSLine(this.jsBase + ".minHeight();");
    }

    @Override // com.anychart.core.Chart, com.anychart.core.VisualBaseWithBounds
    public Stock minHeight(Number number) {
        APIlib.getInstance().addJSLine(String.format(Locale.US, this.jsBase + ".minHeight(%s);", number));
        return this;
    }

    @Override // com.anychart.core.Chart, com.anychart.core.VisualBaseWithBounds
    public Stock minHeight(String str) {
        APIlib.getInstance().addJSLine(String.format(Locale.US, this.jsBase + ".minHeight(%s);", wrapQuotes(str)));
        return this;
    }

    @Override // com.anychart.core.Chart, com.anychart.core.VisualBaseWithBounds
    public void minWidth() {
        APIlib.getInstance().addJSLine(this.jsBase + ".minWidth();");
    }

    @Override // com.anychart.core.Chart, com.anychart.core.VisualBaseWithBounds
    public Stock minWidth(Number number) {
        APIlib.getInstance().addJSLine(String.format(Locale.US, this.jsBase + ".minWidth(%s);", number));
        return this;
    }

    @Override // com.anychart.core.Chart, com.anychart.core.VisualBaseWithBounds
    public Stock minWidth(String str) {
        APIlib.getInstance().addJSLine(String.format(Locale.US, this.jsBase + ".minWidth(%s);", wrapQuotes(str)));
        return this;
    }

    @Override // com.anychart.core.Chart
    public Padding padding() {
        return new Padding(this.jsBase + ".padding()");
    }

    @Override // com.anychart.core.Chart
    public Stock padding(Number[] numberArr) {
        APIlib.getInstance().addJSLine(String.format(Locale.US, this.jsBase + ".padding(%s);", Arrays.toString(numberArr)));
        return this;
    }

    @Override // com.anychart.core.Chart
    public Stock padding(String[] strArr) {
        APIlib.getInstance().addJSLine(String.format(Locale.US, this.jsBase + ".padding(%s);", arrayToStringWrapQuotes(strArr)));
        return this;
    }

    @Override // com.anychart.core.Chart
    public Stock padding(String str) {
        APIlib.getInstance().addJSLine(String.format(Locale.US, this.jsBase + ".padding(%s);", wrapQuotes(str)));
        return this;
    }

    @Override // com.anychart.core.Chart
    public Stock padding(String str, String str2, String str3, String str4) {
        APIlib.getInstance().addJSLine(String.format(Locale.US, this.jsBase + ".padding(%s, %s, %s, %s);", wrapQuotes(str), wrapQuotes(str2), wrapQuotes(str3), wrapQuotes(str4)));
        return this;
    }

    @Override // com.anychart.core.Chart
    public Stock padding(String str, String str2, String str3, Number number) {
        APIlib.getInstance().addJSLine(String.format(Locale.US, this.jsBase + ".padding(%s, %s, %s, %s);", wrapQuotes(str), wrapQuotes(str2), wrapQuotes(str3), number));
        return this;
    }

    @Override // com.anychart.core.Chart
    public Stock padding(String str, String str2, Number number, String str3) {
        APIlib.getInstance().addJSLine(String.format(Locale.US, this.jsBase + ".padding(%s, %s, %s, %s);", wrapQuotes(str), wrapQuotes(str2), number, wrapQuotes(str3)));
        return this;
    }

    @Override // com.anychart.core.Chart
    public Stock padding(String str, String str2, Number number, Number number2) {
        APIlib.getInstance().addJSLine(String.format(Locale.US, this.jsBase + ".padding(%s, %s, %s, %s);", wrapQuotes(str), wrapQuotes(str2), number, number2));
        return this;
    }

    @Override // com.anychart.core.Chart
    public Stock padding(String str, Number number, String str2, String str3) {
        APIlib.getInstance().addJSLine(String.format(Locale.US, this.jsBase + ".padding(%s, %s, %s, %s);", wrapQuotes(str), number, wrapQuotes(str2), wrapQuotes(str3)));
        return this;
    }

    @Override // com.anychart.core.Chart
    public Stock padding(String str, Number number, String str2, Number number2) {
        APIlib.getInstance().addJSLine(String.format(Locale.US, this.jsBase + ".padding(%s, %s, %s, %s);", wrapQuotes(str), number, wrapQuotes(str2), number2));
        return this;
    }

    @Override // com.anychart.core.Chart
    public Stock padding(String str, Number number, Number number2, String str2) {
        APIlib.getInstance().addJSLine(String.format(Locale.US, this.jsBase + ".padding(%s, %s, %s, %s);", wrapQuotes(str), number, number2, wrapQuotes(str2)));
        return this;
    }

    @Override // com.anychart.core.Chart
    public Stock padding(String str, Number number, Number number2, Number number3) {
        APIlib.getInstance().addJSLine(String.format(Locale.US, this.jsBase + ".padding(%s, %s, %s, %s);", wrapQuotes(str), number, number2, number3));
        return this;
    }

    @Override // com.anychart.core.Chart
    public Stock padding(Number number, String str, String str2, String str3) {
        APIlib.getInstance().addJSLine(String.format(Locale.US, this.jsBase + ".padding(%s, %s, %s, %s);", number, wrapQuotes(str), wrapQuotes(str2), wrapQuotes(str3)));
        return this;
    }

    @Override // com.anychart.core.Chart
    public Stock padding(Number number, String str, String str2, Number number2) {
        APIlib.getInstance().addJSLine(String.format(Locale.US, this.jsBase + ".padding(%s, %s, %s, %s);", number, wrapQuotes(str), wrapQuotes(str2), number2));
        return this;
    }

    @Override // com.anychart.core.Chart
    public Stock padding(Number number, String str, Number number2, String str2) {
        APIlib.getInstance().addJSLine(String.format(Locale.US, this.jsBase + ".padding(%s, %s, %s, %s);", number, wrapQuotes(str), number2, wrapQuotes(str2)));
        return this;
    }

    @Override // com.anychart.core.Chart
    public Stock padding(Number number, String str, Number number2, Number number3) {
        APIlib.getInstance().addJSLine(String.format(Locale.US, this.jsBase + ".padding(%s, %s, %s, %s);", number, wrapQuotes(str), number2, number3));
        return this;
    }

    @Override // com.anychart.core.Chart
    public Stock padding(Number number, Number number2, String str, String str2) {
        APIlib.getInstance().addJSLine(String.format(Locale.US, this.jsBase + ".padding(%s, %s, %s, %s);", number, number2, wrapQuotes(str), wrapQuotes(str2)));
        return this;
    }

    @Override // com.anychart.core.Chart
    public Stock padding(Number number, Number number2, String str, Number number3) {
        APIlib.getInstance().addJSLine(String.format(Locale.US, this.jsBase + ".padding(%s, %s, %s, %s);", number, number2, wrapQuotes(str), number3));
        return this;
    }

    @Override // com.anychart.core.Chart
    public Stock padding(Number number, Number number2, Number number3, String str) {
        APIlib.getInstance().addJSLine(String.format(Locale.US, this.jsBase + ".padding(%s, %s, %s, %s);", number, number2, number3, wrapQuotes(str)));
        return this;
    }

    @Override // com.anychart.core.Chart
    public Stock padding(Number number, Number number2, Number number3, Number number4) {
        APIlib.getInstance().addJSLine(String.format(Locale.US, this.jsBase + ".padding(%s, %s, %s, %s);", number, number2, number3, number4));
        return this;
    }

    public Plot plot(Number number) {
        return new Plot(String.format(Locale.US, this.jsBase + ".plot(%s)", number));
    }

    public Stock plot(String str) {
        APIlib.getInstance().addJSLine(String.format(Locale.US, this.jsBase + ".plot(%s);", wrapQuotes(str)));
        return this;
    }

    public Stock plot(Boolean bool) {
        APIlib.getInstance().addJSLine(String.format(Locale.US, this.jsBase + ".plot(%s);", bool));
        return this;
    }

    public Stock plot(Number number, String str) {
        APIlib.getInstance().addJSLine(String.format(Locale.US, this.jsBase + ".plot(%s, %s);", number, wrapQuotes(str)));
        return this;
    }

    public Stock plot(Number number, Boolean bool) {
        APIlib.getInstance().addJSLine(String.format(Locale.US, this.jsBase + ".plot(%s, %s);", number, bool));
        return this;
    }

    public void preserveSelectedRangeOnDataUpdate() {
        APIlib.getInstance().addJSLine(this.jsBase + ".preserveSelectedRangeOnDataUpdate();");
    }

    public Stock preserveSelectedRangeOnDataUpdate(Boolean bool) {
        APIlib.getInstance().addJSLine(String.format(Locale.US, this.jsBase + ".preserveSelectedRangeOnDataUpdate(%s);", bool));
        return this;
    }

    @Override // com.anychart.core.Chart, com.anychart.core.VisualBaseWithBounds, com.anychart.core.VisualBase
    public void print(PaperSize paperSize, Boolean bool) {
        APIlib.getInstance().addJSLine(String.format(Locale.US, this.jsBase + ".print(%s, %s);", paperSize != null ? paperSize.getJsBase() : null, bool));
    }

    @Override // com.anychart.core.Chart, com.anychart.core.VisualBaseWithBounds, com.anychart.core.VisualBase
    public void print(String str, Boolean bool) {
        APIlib.getInstance().addJSLine(String.format(Locale.US, this.jsBase + ".print(%s, %s);", wrapQuotes(str), bool));
    }

    @Override // com.anychart.core.Chart, com.anychart.core.VisualBaseWithBounds, com.anychart.core.VisualBase, com.anychart.core.Base
    public void removeAllListeners(String str) {
        APIlib.getInstance().addJSLine(String.format(Locale.US, this.jsBase + ".removeAllListeners(%s);", wrapQuotes(str)));
    }

    @Override // com.anychart.core.Chart, com.anychart.core.VisualBaseWithBounds
    public void right() {
        APIlib.getInstance().addJSLine(this.jsBase + ".right();");
    }

    @Override // com.anychart.core.Chart, com.anychart.core.VisualBaseWithBounds
    public Stock right(Number number) {
        APIlib.getInstance().addJSLine(String.format(Locale.US, this.jsBase + ".right(%s);", number));
        return this;
    }

    @Override // com.anychart.core.Chart, com.anychart.core.VisualBaseWithBounds
    public Stock right(String str) {
        APIlib.getInstance().addJSLine(String.format(Locale.US, this.jsBase + ".right(%s);", wrapQuotes(str)));
        return this;
    }

    @Override // com.anychart.core.Chart
    public void saveAsJpg(Number number, Number number2, Number number3, Boolean bool, String str) {
        APIlib.getInstance().addJSLine(String.format(Locale.US, this.jsBase + ".saveAsJpg(%s, %s, %s, %s, %s);", number, number2, number3, bool, wrapQuotes(str)));
    }

    @Override // com.anychart.core.Chart
    public void saveAsJpg(String str, Number number, Number number2, Boolean bool, String str2) {
        APIlib.getInstance().addJSLine(String.format(Locale.US, this.jsBase + ".saveAsJpg(%s, %s, %s, %s, %s);", wrapQuotes(str), number, number2, bool, wrapQuotes(str2)));
    }

    @Override // com.anychart.core.Chart
    public void saveAsJson(String str) {
        APIlib.getInstance().addJSLine(String.format(Locale.US, this.jsBase + ".saveAsJson(%s);", wrapQuotes(str)));
    }

    @Override // com.anychart.core.Chart
    public void saveAsPdf(Number number, Boolean bool, Number number2, Number number3, String str) {
        APIlib.getInstance().addJSLine(String.format(Locale.US, this.jsBase + ".saveAsPdf(%s, %s, %s, %s, %s);", number, bool, number2, number3, wrapQuotes(str)));
    }

    @Override // com.anychart.core.Chart
    public void saveAsPdf(String str, Boolean bool, Number number, Number number2, String str2) {
        APIlib.getInstance().addJSLine(String.format(Locale.US, this.jsBase + ".saveAsPdf(%s, %s, %s, %s, %s);", wrapQuotes(str), bool, number, number2, wrapQuotes(str2)));
    }

    @Override // com.anychart.core.Chart
    public void saveAsPng(Number number, Number number2, Number number3, String str) {
        APIlib.getInstance().addJSLine(String.format(Locale.US, this.jsBase + ".saveAsPng(%s, %s, %s, %s);", number, number2, number3, wrapQuotes(str)));
    }

    @Override // com.anychart.core.Chart
    public void saveAsPng(String str, Number number, Number number2, String str2) {
        APIlib.getInstance().addJSLine(String.format(Locale.US, this.jsBase + ".saveAsPng(%s, %s, %s, %s);", wrapQuotes(str), number, number2, wrapQuotes(str2)));
    }

    @Override // com.anychart.core.Chart
    public void saveAsSvg(String str, Boolean bool, String str2) {
        APIlib.getInstance().addJSLine(String.format(Locale.US, this.jsBase + ".saveAsSvg(%s, %s, %s);", wrapQuotes(str), bool, wrapQuotes(str2)));
    }

    @Override // com.anychart.core.Chart
    public void saveAsSvg(Number number, Number number2) {
        APIlib.getInstance().addJSLine(String.format(Locale.US, this.jsBase + ".saveAsSvg(%s, %s);", number, number2));
    }

    @Override // com.anychart.core.Chart
    public void saveAsXlsx(ChartDataExportMode chartDataExportMode, String str) {
        APIlib.getInstance().addJSLine(String.format(Locale.US, this.jsBase + ".saveAsXlsx(%s, %s);", chartDataExportMode != null ? chartDataExportMode.getJsBase() : null, wrapQuotes(str)));
    }

    @Override // com.anychart.core.Chart
    public void saveAsXlsx(String str, String str2) {
        APIlib.getInstance().addJSLine(String.format(Locale.US, this.jsBase + ".saveAsXlsx(%s, %s);", wrapQuotes(str), wrapQuotes(str2)));
    }

    @Override // com.anychart.core.Chart
    public void saveAsXml(String str) {
        APIlib.getInstance().addJSLine(String.format(Locale.US, this.jsBase + ".saveAsXml(%s);", wrapQuotes(str)));
    }

    public Scroller scroller() {
        return new Scroller(this.jsBase + ".scroller()");
    }

    public Stock scroller(String str) {
        APIlib.getInstance().addJSLine(String.format(Locale.US, this.jsBase + ".scroller(%s);", wrapQuotes(str)));
        return this;
    }

    public Stock scroller(Boolean bool) {
        APIlib.getInstance().addJSLine(String.format(Locale.US, this.jsBase + ".scroller(%s);", bool));
        return this;
    }

    public Grouping scrollerGrouping() {
        return new Grouping(this.jsBase + ".scrollerGrouping()");
    }

    public Stock scrollerGrouping(Boolean bool) {
        APIlib.getInstance().addJSLine(String.format(Locale.US, this.jsBase + ".scrollerGrouping(%s);", bool));
        return this;
    }

    public Stock scrollerGrouping(String[] strArr) {
        APIlib.getInstance().addJSLine(String.format(Locale.US, this.jsBase + ".scrollerGrouping(%s);", arrayToStringWrapQuotes(strArr)));
        return this;
    }

    public Stock scrollerGrouping(Level level) {
        APIlib.getInstance().addJSLine(String.format(Locale.US, this.jsBase + ".scrollerGrouping(%s);", level != null ? level.getJsBase() : null));
        return this;
    }

    public Stock scrollerGrouping(String str) {
        APIlib.getInstance().addJSLine(String.format(Locale.US, this.jsBase + ".scrollerGrouping(%s);", wrapQuotes(str)));
        return this;
    }

    @Override // com.anychart.core.Chart
    public void selectMarqueeFill() {
        APIlib.getInstance().addJSLine(this.jsBase + ".selectMarqueeFill();");
    }

    @Override // com.anychart.core.Chart
    public Stock selectMarqueeFill(Fill fill) {
        APIlib.getInstance().addJSLine(String.format(Locale.US, this.jsBase + ".selectMarqueeFill(%s);", fill != null ? fill.getJsBase() : null));
        return this;
    }

    @Override // com.anychart.core.Chart
    public Stock selectMarqueeFill(GradientKey gradientKey) {
        APIlib.getInstance().addJSLine(String.format(Locale.US, this.jsBase + ".selectMarqueeFill(%s);", gradientKey != null ? gradientKey.getJsBase() : null));
        return this;
    }

    @Override // com.anychart.core.Chart
    public Stock selectMarqueeFill(String[] strArr) {
        APIlib.getInstance().addJSLine(String.format(Locale.US, this.jsBase + ".selectMarqueeFill(%s);", arrayToStringWrapQuotes(strArr)));
        return this;
    }

    @Override // com.anychart.core.Chart
    public Stock selectMarqueeFill(String str, Number number) {
        APIlib.getInstance().addJSLine(String.format(Locale.US, this.jsBase + ".selectMarqueeFill(%s, %s);", wrapQuotes(str), number));
        return this;
    }

    @Override // com.anychart.core.Chart
    public Stock selectMarqueeFill(GradientKey gradientKey, Number number, Boolean bool, Number number2) {
        APIlib.getInstance().addJSLine(String.format(Locale.US, this.jsBase + ".selectMarqueeFill(%s, %s, %s, %s);", gradientKey != null ? gradientKey.getJsBase() : null, number, bool, number2));
        return this;
    }

    @Override // com.anychart.core.Chart
    public Stock selectMarqueeFill(GradientKey gradientKey, Number number, com.anychart.graphics.vector.Rect rect, Number number2) {
        APIlib.getInstance().addJSLine(String.format(Locale.US, this.jsBase + ".selectMarqueeFill(%s, %s, %s, %s);", gradientKey != null ? gradientKey.getJsBase() : null, number, rect != null ? rect.getJsBase() : null, number2));
        return this;
    }

    @Override // com.anychart.core.Chart
    public Stock selectMarqueeFill(GradientKey gradientKey, Number number, String str, Number number2) {
        APIlib.getInstance().addJSLine(String.format(Locale.US, this.jsBase + ".selectMarqueeFill(%s, %s, %s, %s);", gradientKey != null ? gradientKey.getJsBase() : null, number, wrapQuotes(str), number2));
        return this;
    }

    @Override // com.anychart.core.Chart
    public Stock selectMarqueeFill(String[] strArr, Number number, Boolean bool, Number number2) {
        APIlib.getInstance().addJSLine(String.format(Locale.US, this.jsBase + ".selectMarqueeFill(%s, %s, %s, %s);", arrayToStringWrapQuotes(strArr), number, bool, number2));
        return this;
    }

    @Override // com.anychart.core.Chart
    public Stock selectMarqueeFill(String[] strArr, Number number, com.anychart.graphics.vector.Rect rect, Number number2) {
        APIlib.getInstance().addJSLine(String.format(Locale.US, this.jsBase + ".selectMarqueeFill(%s, %s, %s, %s);", arrayToStringWrapQuotes(strArr), number, rect != null ? rect.getJsBase() : null, number2));
        return this;
    }

    @Override // com.anychart.core.Chart
    public Stock selectMarqueeFill(String[] strArr, Number number, String str, Number number2) {
        APIlib.getInstance().addJSLine(String.format(Locale.US, this.jsBase + ".selectMarqueeFill(%s, %s, %s, %s);", arrayToStringWrapQuotes(strArr), number, wrapQuotes(str), number2));
        return this;
    }

    @Override // com.anychart.core.Chart
    public Stock selectMarqueeFill(GradientKey gradientKey, Number number, Number number2, com.anychart.graphics.math.Rect rect, Number number3, Number number4, Number number5) {
        APIlib.getInstance().addJSLine(String.format(Locale.US, this.jsBase + ".selectMarqueeFill(%s, %s, %s, %s, %s, %s, %s);", gradientKey != null ? gradientKey.getJsBase() : null, number, number2, rect != null ? rect.getJsBase() : null, number3, number4, number5));
        return this;
    }

    @Override // com.anychart.core.Chart
    public Stock selectMarqueeFill(String[] strArr, Number number, Number number2, com.anychart.graphics.math.Rect rect, Number number3, Number number4, Number number5) {
        APIlib.getInstance().addJSLine(String.format(Locale.US, this.jsBase + ".selectMarqueeFill(%s, %s, %s, %s, %s, %s, %s);", arrayToStringWrapQuotes(strArr), number, number2, rect != null ? rect.getJsBase() : null, number3, number4, number5));
        return this;
    }

    @Override // com.anychart.core.Chart
    public void selectMarqueeStroke() {
        APIlib.getInstance().addJSLine(this.jsBase + ".selectMarqueeStroke();");
    }

    @Override // com.anychart.core.Chart
    public Stock selectMarqueeStroke(Stroke stroke, Number number, String str, String str2, String str3) {
        APIlib.getInstance().addJSLine(String.format(Locale.US, this.jsBase + ".selectMarqueeStroke(%s, %s, %s, %s, %s);", stroke != null ? stroke.getJsBase() : null, number, wrapQuotes(str), wrapQuotes(str2), wrapQuotes(str3)));
        return this;
    }

    @Override // com.anychart.core.Chart
    public Stock selectMarqueeStroke(Stroke stroke, Number number, String str, String str2, StrokeLineCap strokeLineCap) {
        APIlib.getInstance().addJSLine(String.format(Locale.US, this.jsBase + ".selectMarqueeStroke(%s, %s, %s, %s, %s);", stroke != null ? stroke.getJsBase() : null, number, wrapQuotes(str), wrapQuotes(str2), strokeLineCap != null ? strokeLineCap.getJsBase() : null));
        return this;
    }

    @Override // com.anychart.core.Chart
    public Stock selectMarqueeStroke(Stroke stroke, Number number, String str, StrokeLineJoin strokeLineJoin, String str2) {
        APIlib.getInstance().addJSLine(String.format(Locale.US, this.jsBase + ".selectMarqueeStroke(%s, %s, %s, %s, %s);", stroke != null ? stroke.getJsBase() : null, number, wrapQuotes(str), strokeLineJoin != null ? strokeLineJoin.getJsBase() : null, wrapQuotes(str2)));
        return this;
    }

    @Override // com.anychart.core.Chart
    public Stock selectMarqueeStroke(Stroke stroke, Number number, String str, StrokeLineJoin strokeLineJoin, StrokeLineCap strokeLineCap) {
        APIlib.getInstance().addJSLine(String.format(Locale.US, this.jsBase + ".selectMarqueeStroke(%s, %s, %s, %s, %s);", stroke != null ? stroke.getJsBase() : null, number, wrapQuotes(str), strokeLineJoin != null ? strokeLineJoin.getJsBase() : null, strokeLineCap != null ? strokeLineCap.getJsBase() : null));
        return this;
    }

    @Override // com.anychart.core.Chart
    public Stock selectMarqueeStroke(ColoredFill coloredFill, Number number, String str, String str2, String str3) {
        APIlib.getInstance().addJSLine(String.format(Locale.US, this.jsBase + ".selectMarqueeStroke(%s, %s, %s, %s, %s);", coloredFill != null ? coloredFill.getJsBase() : null, number, wrapQuotes(str), wrapQuotes(str2), wrapQuotes(str3)));
        return this;
    }

    @Override // com.anychart.core.Chart
    public Stock selectMarqueeStroke(ColoredFill coloredFill, Number number, String str, String str2, StrokeLineCap strokeLineCap) {
        APIlib.getInstance().addJSLine(String.format(Locale.US, this.jsBase + ".selectMarqueeStroke(%s, %s, %s, %s, %s);", coloredFill != null ? coloredFill.getJsBase() : null, number, wrapQuotes(str), wrapQuotes(str2), strokeLineCap != null ? strokeLineCap.getJsBase() : null));
        return this;
    }

    @Override // com.anychart.core.Chart
    public Stock selectMarqueeStroke(ColoredFill coloredFill, Number number, String str, StrokeLineJoin strokeLineJoin, String str2) {
        APIlib.getInstance().addJSLine(String.format(Locale.US, this.jsBase + ".selectMarqueeStroke(%s, %s, %s, %s, %s);", coloredFill != null ? coloredFill.getJsBase() : null, number, wrapQuotes(str), strokeLineJoin != null ? strokeLineJoin.getJsBase() : null, wrapQuotes(str2)));
        return this;
    }

    @Override // com.anychart.core.Chart
    public Stock selectMarqueeStroke(ColoredFill coloredFill, Number number, String str, StrokeLineJoin strokeLineJoin, StrokeLineCap strokeLineCap) {
        APIlib.getInstance().addJSLine(String.format(Locale.US, this.jsBase + ".selectMarqueeStroke(%s, %s, %s, %s, %s);", coloredFill != null ? coloredFill.getJsBase() : null, number, wrapQuotes(str), strokeLineJoin != null ? strokeLineJoin.getJsBase() : null, strokeLineCap != null ? strokeLineCap.getJsBase() : null));
        return this;
    }

    @Override // com.anychart.core.Chart
    public Stock selectMarqueeStroke(String str, Number number, String str2, String str3, String str4) {
        APIlib.getInstance().addJSLine(String.format(Locale.US, this.jsBase + ".selectMarqueeStroke(%s, %s, %s, %s, %s);", wrapQuotes(str), number, wrapQuotes(str2), wrapQuotes(str3), wrapQuotes(str4)));
        return this;
    }

    @Override // com.anychart.core.Chart
    public Stock selectMarqueeStroke(String str, Number number, String str2, String str3, StrokeLineCap strokeLineCap) {
        APIlib.getInstance().addJSLine(String.format(Locale.US, this.jsBase + ".selectMarqueeStroke(%s, %s, %s, %s, %s);", wrapQuotes(str), number, wrapQuotes(str2), wrapQuotes(str3), strokeLineCap != null ? strokeLineCap.getJsBase() : null));
        return this;
    }

    @Override // com.anychart.core.Chart
    public Stock selectMarqueeStroke(String str, Number number, String str2, StrokeLineJoin strokeLineJoin, String str3) {
        APIlib.getInstance().addJSLine(String.format(Locale.US, this.jsBase + ".selectMarqueeStroke(%s, %s, %s, %s, %s);", wrapQuotes(str), number, wrapQuotes(str2), strokeLineJoin != null ? strokeLineJoin.getJsBase() : null, wrapQuotes(str3)));
        return this;
    }

    @Override // com.anychart.core.Chart
    public Stock selectMarqueeStroke(String str, Number number, String str2, StrokeLineJoin strokeLineJoin, StrokeLineCap strokeLineCap) {
        APIlib.getInstance().addJSLine(String.format(Locale.US, this.jsBase + ".selectMarqueeStroke(%s, %s, %s, %s, %s);", wrapQuotes(str), number, wrapQuotes(str2), strokeLineJoin != null ? strokeLineJoin.getJsBase() : null, strokeLineCap != null ? strokeLineCap.getJsBase() : null));
        return this;
    }

    public Stock selectRange(Number number, Number number2) {
        APIlib.getInstance().addJSLine(String.format(Locale.US, this.jsBase + ".selectRange(%s, %s);", number, number2));
        return this;
    }

    public Stock selectRange(Number number, String str) {
        APIlib.getInstance().addJSLine(String.format(Locale.US, this.jsBase + ".selectRange(%s, %s);", number, wrapQuotes(str)));
        return this;
    }

    public Stock selectRange(String str, Number number) {
        APIlib.getInstance().addJSLine(String.format(Locale.US, this.jsBase + ".selectRange(%s, %s);", wrapQuotes(str), number));
        return this;
    }

    public Stock selectRange(String str, String str2) {
        APIlib.getInstance().addJSLine(String.format(Locale.US, this.jsBase + ".selectRange(%s, %s);", wrapQuotes(str), wrapQuotes(str2)));
        return this;
    }

    public Stock selectRange(Number number, Number number2, Boolean bool) {
        APIlib.getInstance().addJSLine(String.format(Locale.US, this.jsBase + ".selectRange(%s, %s, %s);", number, number2, bool));
        return this;
    }

    public Stock selectRange(Number number, String str, Boolean bool) {
        APIlib.getInstance().addJSLine(String.format(Locale.US, this.jsBase + ".selectRange(%s, %s, %s);", number, wrapQuotes(str), bool));
        return this;
    }

    public Stock selectRange(String str, Number number, Boolean bool) {
        APIlib.getInstance().addJSLine(String.format(Locale.US, this.jsBase + ".selectRange(%s, %s, %s);", wrapQuotes(str), number, bool));
        return this;
    }

    public Stock selectRange(String str, String str2, Boolean bool) {
        APIlib.getInstance().addJSLine(String.format(Locale.US, this.jsBase + ".selectRange(%s, %s, %s);", wrapQuotes(str), wrapQuotes(str2), bool));
        return this;
    }

    public Stock selectRange(StockRangeType stockRangeType, Number number, Boolean bool) {
        APIlib.getInstance().addJSLine(String.format(Locale.US, this.jsBase + ".selectRange(%s, %s, %s);", stockRangeType != null ? stockRangeType.getJsBase() : null, number, bool));
        return this;
    }

    public Stock selectRange(Interval interval, Number number, StockRangeAnchor stockRangeAnchor, Boolean bool) {
        APIlib.getInstance().addJSLine(String.format(Locale.US, this.jsBase + ".selectRange(%s, %s, %s, %s);", interval != null ? interval.getJsBase() : null, number, stockRangeAnchor != null ? stockRangeAnchor.getJsBase() : null, bool));
        return this;
    }

    public Stock selectRange(Interval interval, Number number, String str, Boolean bool) {
        APIlib.getInstance().addJSLine(String.format(Locale.US, this.jsBase + ".selectRange(%s, %s, %s, %s);", interval != null ? interval.getJsBase() : null, number, wrapQuotes(str), bool));
        return this;
    }

    public Stock selectRange(String str, Number number, StockRangeAnchor stockRangeAnchor, Boolean bool) {
        APIlib.getInstance().addJSLine(String.format(Locale.US, this.jsBase + ".selectRange(%s, %s, %s, %s);", wrapQuotes(str), number, stockRangeAnchor != null ? stockRangeAnchor.getJsBase() : null, bool));
        return this;
    }

    public Stock selectRange(String str, Number number, String str2, Boolean bool) {
        APIlib.getInstance().addJSLine(String.format(Locale.US, this.jsBase + ".selectRange(%s, %s, %s, %s);", wrapQuotes(str), number, wrapQuotes(str2), bool));
        return this;
    }

    @Override // com.anychart.core.Chart
    public void shareWithFacebook(String str, String str2, String str3, String str4) {
        APIlib.getInstance().addJSLine(String.format(Locale.US, this.jsBase + ".shareWithFacebook(%s, %s, %s, %s);", wrapQuotes(str), wrapQuotes(str2), wrapQuotes(str3), wrapQuotes(str4)));
    }

    @Override // com.anychart.core.Chart
    public void shareWithLinkedIn(String str, String str2) {
        APIlib.getInstance().addJSLine(String.format(Locale.US, this.jsBase + ".shareWithLinkedIn(%s, %s);", wrapQuotes(str), wrapQuotes(str2)));
    }

    @Override // com.anychart.core.Chart
    public void shareWithPinterest(String str, String str2) {
        APIlib.getInstance().addJSLine(String.format(Locale.US, this.jsBase + ".shareWithPinterest(%s, %s);", wrapQuotes(str), wrapQuotes(str2)));
    }

    @Override // com.anychart.core.Chart
    public void shareWithTwitter() {
        APIlib.getInstance().addJSLine(this.jsBase + ".shareWithTwitter();");
    }

    @Override // com.anychart.core.Chart
    public Stock startSelectMarquee(Boolean bool) {
        APIlib.getInstance().addJSLine(String.format(Locale.US, this.jsBase + ".startSelectMarquee(%s);", bool));
        return this;
    }

    public Stock startZoomMarquee(Boolean bool, Boolean bool2) {
        APIlib.getInstance().addJSLine(String.format(Locale.US, this.jsBase + ".startZoomMarquee(%s, %s);", bool, bool2));
        return this;
    }

    @Override // com.anychart.core.Chart
    public Title title() {
        return new Title(this.jsBase + ".title()");
    }

    @Override // com.anychart.core.Chart
    public Stock title(Boolean bool) {
        APIlib.getInstance().addJSLine(String.format(Locale.US, this.jsBase + ".title(%s);", bool));
        return this;
    }

    @Override // com.anychart.core.Chart
    public Stock title(String str) {
        APIlib.getInstance().addJSLine(String.format(Locale.US, this.jsBase + ".title(%s);", wrapQuotes(str)));
        return this;
    }

    @Override // com.anychart.core.Chart
    public void toJson(Boolean bool) {
        APIlib.getInstance().addJSLine(String.format(Locale.US, this.jsBase + ".toJson(%s);", bool));
    }

    @Override // com.anychart.core.Chart
    public void toSvg(String str, Boolean bool) {
        APIlib.getInstance().addJSLine(String.format(Locale.US, this.jsBase + ".toSvg(%s, %s);", wrapQuotes(str), bool));
    }

    @Override // com.anychart.core.Chart
    public void toSvg(Number number, Number number2) {
        APIlib.getInstance().addJSLine(String.format(Locale.US, this.jsBase + ".toSvg(%s, %s);", number, number2));
    }

    @Override // com.anychart.core.Chart
    public void toXml(Boolean bool) {
        APIlib.getInstance().addJSLine(String.format(Locale.US, this.jsBase + ".toXml(%s);", bool));
    }

    @Override // com.anychart.core.Chart
    public Tooltip tooltip() {
        return new Tooltip(this.jsBase + ".tooltip()");
    }

    @Override // com.anychart.core.Chart
    public Stock tooltip(String str) {
        APIlib.getInstance().addJSLine(String.format(Locale.US, this.jsBase + ".tooltip(%s);", wrapQuotes(str)));
        return this;
    }

    @Override // com.anychart.core.Chart
    public Stock tooltip(Boolean bool) {
        APIlib.getInstance().addJSLine(String.format(Locale.US, this.jsBase + ".tooltip(%s);", bool));
        return this;
    }

    @Override // com.anychart.core.Chart, com.anychart.core.VisualBaseWithBounds
    public void top() {
        APIlib.getInstance().addJSLine(this.jsBase + ".top();");
    }

    @Override // com.anychart.core.Chart, com.anychart.core.VisualBaseWithBounds
    public Stock top(Number number) {
        APIlib.getInstance().addJSLine(String.format(Locale.US, this.jsBase + ".top(%s);", number));
        return this;
    }

    @Override // com.anychart.core.Chart, com.anychart.core.VisualBaseWithBounds
    public Stock top(String str) {
        APIlib.getInstance().addJSLine(String.format(Locale.US, this.jsBase + ".top(%s);", wrapQuotes(str)));
        return this;
    }

    @Override // com.anychart.core.Chart, com.anychart.core.VisualBaseWithBounds, com.anychart.core.VisualBase, com.anychart.core.Base
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

    @Override // com.anychart.core.Chart, com.anychart.core.VisualBaseWithBounds, com.anychart.core.VisualBase, com.anychart.core.Base
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

    @Override // com.anychart.core.Chart, com.anychart.core.VisualBaseWithBounds, com.anychart.core.VisualBase, com.anychart.core.Base
    public void unlistenByKey(String str) {
        APIlib.getInstance().addJSLine(String.format(Locale.US, this.jsBase + ".unlistenByKey(%s);", wrapQuotes(str)));
    }

    @Override // com.anychart.core.Chart, com.anychart.core.VisualBaseWithBounds
    public void width() {
        APIlib.getInstance().addJSLine(this.jsBase + ".width();");
    }

    @Override // com.anychart.core.Chart, com.anychart.core.VisualBaseWithBounds
    public Stock width(Number number) {
        APIlib.getInstance().addJSLine(String.format(Locale.US, this.jsBase + ".width(%s);", number));
        return this;
    }

    @Override // com.anychart.core.Chart, com.anychart.core.VisualBaseWithBounds
    public Stock width(String str) {
        APIlib.getInstance().addJSLine(String.format(Locale.US, this.jsBase + ".width(%s);", wrapQuotes(str)));
        return this;
    }

    public StockScatterDateTime xScale() {
        return new StockScatterDateTime(this.jsBase + ".xScale()");
    }

    public Stock xScale(ScaleTypes scaleTypes) {
        APIlib.getInstance().addJSLine(String.format(Locale.US, this.jsBase + ".xScale(%s);", scaleTypes != null ? scaleTypes.getJsBase() : null));
        return this;
    }

    public Stock xScale(String str) {
        APIlib.getInstance().addJSLine(String.format(Locale.US, this.jsBase + ".xScale(%s);", wrapQuotes(str)));
        return this;
    }

    @Override // com.anychart.core.Chart, com.anychart.core.VisualBaseWithBounds, com.anychart.core.VisualBase
    public void zIndex() {
        APIlib.getInstance().addJSLine(this.jsBase + ".zIndex();");
    }

    @Override // com.anychart.core.Chart, com.anychart.core.VisualBaseWithBounds, com.anychart.core.VisualBase
    public Stock zIndex(Number number) {
        APIlib.getInstance().addJSLine(String.format(Locale.US, this.jsBase + ".zIndex(%s);", number));
        return this;
    }

    public void zoomMarqueeFill() {
        APIlib.getInstance().addJSLine(this.jsBase + ".zoomMarqueeFill();");
    }

    public Stock zoomMarqueeFill(Fill fill) {
        APIlib.getInstance().addJSLine(String.format(Locale.US, this.jsBase + ".zoomMarqueeFill(%s);", fill != null ? fill.getJsBase() : null));
        return this;
    }

    public Stock zoomMarqueeFill(GradientKey gradientKey) {
        APIlib.getInstance().addJSLine(String.format(Locale.US, this.jsBase + ".zoomMarqueeFill(%s);", gradientKey != null ? gradientKey.getJsBase() : null));
        return this;
    }

    public Stock zoomMarqueeFill(String[] strArr) {
        APIlib.getInstance().addJSLine(String.format(Locale.US, this.jsBase + ".zoomMarqueeFill(%s);", arrayToStringWrapQuotes(strArr)));
        return this;
    }

    public Stock zoomMarqueeFill(String str, Number number) {
        APIlib.getInstance().addJSLine(String.format(Locale.US, this.jsBase + ".zoomMarqueeFill(%s, %s);", wrapQuotes(str), number));
        return this;
    }

    public Stock zoomMarqueeFill(GradientKey gradientKey, Number number, Boolean bool, Number number2) {
        APIlib.getInstance().addJSLine(String.format(Locale.US, this.jsBase + ".zoomMarqueeFill(%s, %s, %s, %s);", gradientKey != null ? gradientKey.getJsBase() : null, number, bool, number2));
        return this;
    }

    public Stock zoomMarqueeFill(GradientKey gradientKey, Number number, com.anychart.graphics.vector.Rect rect, Number number2) {
        APIlib.getInstance().addJSLine(String.format(Locale.US, this.jsBase + ".zoomMarqueeFill(%s, %s, %s, %s);", gradientKey != null ? gradientKey.getJsBase() : null, number, rect != null ? rect.getJsBase() : null, number2));
        return this;
    }

    public Stock zoomMarqueeFill(GradientKey gradientKey, Number number, String str, Number number2) {
        APIlib.getInstance().addJSLine(String.format(Locale.US, this.jsBase + ".zoomMarqueeFill(%s, %s, %s, %s);", gradientKey != null ? gradientKey.getJsBase() : null, number, wrapQuotes(str), number2));
        return this;
    }

    public Stock zoomMarqueeFill(String[] strArr, Number number, Boolean bool, Number number2) {
        APIlib.getInstance().addJSLine(String.format(Locale.US, this.jsBase + ".zoomMarqueeFill(%s, %s, %s, %s);", arrayToStringWrapQuotes(strArr), number, bool, number2));
        return this;
    }

    public Stock zoomMarqueeFill(String[] strArr, Number number, com.anychart.graphics.vector.Rect rect, Number number2) {
        APIlib.getInstance().addJSLine(String.format(Locale.US, this.jsBase + ".zoomMarqueeFill(%s, %s, %s, %s);", arrayToStringWrapQuotes(strArr), number, rect != null ? rect.getJsBase() : null, number2));
        return this;
    }

    public Stock zoomMarqueeFill(String[] strArr, Number number, String str, Number number2) {
        APIlib.getInstance().addJSLine(String.format(Locale.US, this.jsBase + ".zoomMarqueeFill(%s, %s, %s, %s);", arrayToStringWrapQuotes(strArr), number, wrapQuotes(str), number2));
        return this;
    }

    public Stock zoomMarqueeFill(GradientKey gradientKey, Number number, Number number2, com.anychart.graphics.math.Rect rect, Number number3, Number number4, Number number5) {
        APIlib.getInstance().addJSLine(String.format(Locale.US, this.jsBase + ".zoomMarqueeFill(%s, %s, %s, %s, %s, %s, %s);", gradientKey != null ? gradientKey.getJsBase() : null, number, number2, rect != null ? rect.getJsBase() : null, number3, number4, number5));
        return this;
    }

    public Stock zoomMarqueeFill(String[] strArr, Number number, Number number2, com.anychart.graphics.math.Rect rect, Number number3, Number number4, Number number5) {
        APIlib.getInstance().addJSLine(String.format(Locale.US, this.jsBase + ".zoomMarqueeFill(%s, %s, %s, %s, %s, %s, %s);", arrayToStringWrapQuotes(strArr), number, number2, rect != null ? rect.getJsBase() : null, number3, number4, number5));
        return this;
    }

    public void zoomMarqueeStroke() {
        APIlib.getInstance().addJSLine(this.jsBase + ".zoomMarqueeStroke();");
    }

    public Stock zoomMarqueeStroke(Stroke stroke, Number number, String str, String str2, String str3) {
        APIlib.getInstance().addJSLine(String.format(Locale.US, this.jsBase + ".zoomMarqueeStroke(%s, %s, %s, %s, %s);", stroke != null ? stroke.getJsBase() : null, number, wrapQuotes(str), wrapQuotes(str2), wrapQuotes(str3)));
        return this;
    }

    public Stock zoomMarqueeStroke(Stroke stroke, Number number, String str, String str2, StrokeLineCap strokeLineCap) {
        APIlib.getInstance().addJSLine(String.format(Locale.US, this.jsBase + ".zoomMarqueeStroke(%s, %s, %s, %s, %s);", stroke != null ? stroke.getJsBase() : null, number, wrapQuotes(str), wrapQuotes(str2), strokeLineCap != null ? strokeLineCap.getJsBase() : null));
        return this;
    }

    public Stock zoomMarqueeStroke(Stroke stroke, Number number, String str, StrokeLineJoin strokeLineJoin, String str2) {
        APIlib.getInstance().addJSLine(String.format(Locale.US, this.jsBase + ".zoomMarqueeStroke(%s, %s, %s, %s, %s);", stroke != null ? stroke.getJsBase() : null, number, wrapQuotes(str), strokeLineJoin != null ? strokeLineJoin.getJsBase() : null, wrapQuotes(str2)));
        return this;
    }

    public Stock zoomMarqueeStroke(Stroke stroke, Number number, String str, StrokeLineJoin strokeLineJoin, StrokeLineCap strokeLineCap) {
        APIlib.getInstance().addJSLine(String.format(Locale.US, this.jsBase + ".zoomMarqueeStroke(%s, %s, %s, %s, %s);", stroke != null ? stroke.getJsBase() : null, number, wrapQuotes(str), strokeLineJoin != null ? strokeLineJoin.getJsBase() : null, strokeLineCap != null ? strokeLineCap.getJsBase() : null));
        return this;
    }

    public Stock zoomMarqueeStroke(ColoredFill coloredFill, Number number, String str, String str2, String str3) {
        APIlib.getInstance().addJSLine(String.format(Locale.US, this.jsBase + ".zoomMarqueeStroke(%s, %s, %s, %s, %s);", coloredFill != null ? coloredFill.getJsBase() : null, number, wrapQuotes(str), wrapQuotes(str2), wrapQuotes(str3)));
        return this;
    }

    public Stock zoomMarqueeStroke(ColoredFill coloredFill, Number number, String str, String str2, StrokeLineCap strokeLineCap) {
        APIlib.getInstance().addJSLine(String.format(Locale.US, this.jsBase + ".zoomMarqueeStroke(%s, %s, %s, %s, %s);", coloredFill != null ? coloredFill.getJsBase() : null, number, wrapQuotes(str), wrapQuotes(str2), strokeLineCap != null ? strokeLineCap.getJsBase() : null));
        return this;
    }

    public Stock zoomMarqueeStroke(ColoredFill coloredFill, Number number, String str, StrokeLineJoin strokeLineJoin, String str2) {
        APIlib.getInstance().addJSLine(String.format(Locale.US, this.jsBase + ".zoomMarqueeStroke(%s, %s, %s, %s, %s);", coloredFill != null ? coloredFill.getJsBase() : null, number, wrapQuotes(str), strokeLineJoin != null ? strokeLineJoin.getJsBase() : null, wrapQuotes(str2)));
        return this;
    }

    public Stock zoomMarqueeStroke(ColoredFill coloredFill, Number number, String str, StrokeLineJoin strokeLineJoin, StrokeLineCap strokeLineCap) {
        APIlib.getInstance().addJSLine(String.format(Locale.US, this.jsBase + ".zoomMarqueeStroke(%s, %s, %s, %s, %s);", coloredFill != null ? coloredFill.getJsBase() : null, number, wrapQuotes(str), strokeLineJoin != null ? strokeLineJoin.getJsBase() : null, strokeLineCap != null ? strokeLineCap.getJsBase() : null));
        return this;
    }

    public Stock zoomMarqueeStroke(String str, Number number, String str2, String str3, String str4) {
        APIlib.getInstance().addJSLine(String.format(Locale.US, this.jsBase + ".zoomMarqueeStroke(%s, %s, %s, %s, %s);", wrapQuotes(str), number, wrapQuotes(str2), wrapQuotes(str3), wrapQuotes(str4)));
        return this;
    }

    public Stock zoomMarqueeStroke(String str, Number number, String str2, String str3, StrokeLineCap strokeLineCap) {
        APIlib.getInstance().addJSLine(String.format(Locale.US, this.jsBase + ".zoomMarqueeStroke(%s, %s, %s, %s, %s);", wrapQuotes(str), number, wrapQuotes(str2), wrapQuotes(str3), strokeLineCap != null ? strokeLineCap.getJsBase() : null));
        return this;
    }

    public Stock zoomMarqueeStroke(String str, Number number, String str2, StrokeLineJoin strokeLineJoin, String str3) {
        APIlib.getInstance().addJSLine(String.format(Locale.US, this.jsBase + ".zoomMarqueeStroke(%s, %s, %s, %s, %s);", wrapQuotes(str), number, wrapQuotes(str2), strokeLineJoin != null ? strokeLineJoin.getJsBase() : null, wrapQuotes(str3)));
        return this;
    }

    public Stock zoomMarqueeStroke(String str, Number number, String str2, StrokeLineJoin strokeLineJoin, StrokeLineCap strokeLineCap) {
        APIlib.getInstance().addJSLine(String.format(Locale.US, this.jsBase + ".zoomMarqueeStroke(%s, %s, %s, %s, %s);", wrapQuotes(str), number, wrapQuotes(str2), strokeLineJoin != null ? strokeLineJoin.getJsBase() : null, strokeLineCap != null ? strokeLineCap.getJsBase() : null));
        return this;
    }

    @Override // com.anychart.core.Chart
    public NoDataSettings noData() {
        return new NoDataSettings(this.jsBase + ".noData()");
    }

    @Override // com.anychart.core.Chart
    public Stock noData(String str) {
        APIlib.getInstance().addJSLine(String.format(Locale.US, this.jsBase + ".noData(%s);", wrapQuotes(str)));
        return this;
    }

    @Override // com.anychart.core.Chart
    public void toA11yTable(String str, Boolean bool) {
        APIlib.getInstance().addJSLine(String.format(Locale.US, this.jsBase + ".toA11yTable(%s, %s);", wrapQuotes(str), bool));
    }

    @Override // com.anychart.core.Chart
    public void toHtmlTable(String str, Boolean bool) {
        APIlib.getInstance().addJSLine(String.format(Locale.US, this.jsBase + ".toHtmlTable(%s, %s);", wrapQuotes(str), bool));
    }

    @Override // com.anychart.core.Chart, com.anychart.core.VisualBaseWithBounds, com.anychart.core.VisualBase
    public Rect parentBounds() {
        return new Rect(this.jsBase + ".parentBounds()");
    }

    @Override // com.anychart.core.Chart, com.anychart.core.VisualBaseWithBounds, com.anychart.core.VisualBase
    public Stock parentBounds(Rect rect) {
        APIlib.getInstance().addJSLine(String.format(Locale.US, this.jsBase + ".parentBounds(%s);", rect != null ? rect.getJsBase() : null));
        return this;
    }

    @Override // com.anychart.core.Chart, com.anychart.core.VisualBaseWithBounds, com.anychart.core.VisualBase
    public Stock parentBounds(String str) {
        APIlib.getInstance().addJSLine(String.format(Locale.US, this.jsBase + ".parentBounds(%s);", wrapQuotes(str)));
        return this;
    }

    @Override // com.anychart.core.Chart, com.anychart.core.VisualBaseWithBounds, com.anychart.core.VisualBase
    public Stock parentBounds(Number number) {
        APIlib.getInstance().addJSLine(String.format(Locale.US, this.jsBase + ".parentBounds(%s);", number));
        return this;
    }

    @Override // com.anychart.core.Chart, com.anychart.core.VisualBaseWithBounds, com.anychart.core.VisualBase
    public Stock parentBounds(Number number, Number number2, Number number3, Number number4) {
        APIlib.getInstance().addJSLine(String.format(Locale.US, this.jsBase + ".parentBounds(%s, %s, %s, %s);", number, number2, number3, number4));
        return this;
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
}
