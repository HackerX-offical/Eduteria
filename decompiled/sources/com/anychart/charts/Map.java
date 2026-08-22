package com.anychart.charts;

import com.amazonaws.services.s3.model.InstructionFileId;
import com.anychart.APIlib;
import com.anychart.chart.common.dataentry.DataEntry;
import com.anychart.chart.common.listener.ListenersInterface;
import com.anychart.core.NoDataSettings;
import com.anychart.core.SeparateChart;
import com.anychart.core.StateSettings;
import com.anychart.core.axes.MapSettings;
import com.anychart.core.map.series.Base;
import com.anychart.core.map.series.Bubble;
import com.anychart.core.map.series.Choropleth;
import com.anychart.core.map.series.Connector;
import com.anychart.core.map.series.Marker;
import com.anychart.core.ui.Background;
import com.anychart.core.ui.Callout;
import com.anychart.core.ui.ChartCredits;
import com.anychart.core.ui.ColorRange;
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
import com.anychart.core.utils.MapInteractivity;
import com.anychart.core.utils.Margin;
import com.anychart.core.utils.Padding;
import com.anychart.core.utils.UnboundRegionsSettings;
import com.anychart.data.Set;
import com.anychart.data.View;
import com.anychart.enums.ChartDataExportMode;
import com.anychart.enums.HoverMode;
import com.anychart.enums.LabelsOverlapMode;
import com.anychart.enums.MapProjections;
import com.anychart.enums.MapSeriesType;
import com.anychart.enums.MapUnboundRegionsMode;
import com.anychart.enums.MarkerType;
import com.anychart.enums.Statistics;
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
import com.anychart.scales.Geo;
import com.anychart.ui.ContextMenu;
import com.anychart.utils.RectObj;
import java.util.Arrays;
import java.util.List;
import java.util.Locale;

/* JADX INFO: loaded from: classes4.dex */
public class Map extends SeparateChart {
    protected Map() {
    }

    public static Map instantiate() {
        return new Map("new anychart.charts.map()");
    }

    public Map(String str) {
        StringBuilder sb = new StringBuilder("map");
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
    public Map a11y(Boolean bool) {
        APIlib.getInstance().addJSLine(String.format(Locale.US, this.jsBase + ".a11y(%s);", bool));
        return this;
    }

    @Override // com.anychart.core.SeparateChart, com.anychart.core.Chart
    public Map a11y(String str) {
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
    public Map animation(Boolean bool) {
        APIlib.getInstance().addJSLine(String.format(Locale.US, this.jsBase + ".animation(%s);", bool));
        return this;
    }

    @Override // com.anychart.core.SeparateChart, com.anychart.core.Chart
    public Map animation(String str) {
        APIlib.getInstance().addJSLine(String.format(Locale.US, this.jsBase + ".animation(%s);", wrapQuotes(str)));
        return this;
    }

    @Override // com.anychart.core.SeparateChart, com.anychart.core.Chart
    public Map animation(Boolean bool, Number number) {
        APIlib.getInstance().addJSLine(String.format(Locale.US, this.jsBase + ".animation(%s, %s);", bool, number));
        return this;
    }

    @Override // com.anychart.core.SeparateChart, com.anychart.core.Chart
    public void autoRedraw() {
        APIlib.getInstance().addJSLine(this.jsBase + ".autoRedraw();");
    }

    @Override // com.anychart.core.SeparateChart, com.anychart.core.Chart
    public Map autoRedraw(Boolean bool) {
        APIlib.getInstance().addJSLine(String.format(Locale.US, this.jsBase + ".autoRedraw(%s);", bool));
        return this;
    }

    public MapSettings axes() {
        return new MapSettings(this.jsBase + ".axes()");
    }

    public Map axes(String str) {
        APIlib.getInstance().addJSLine(String.format(Locale.US, this.jsBase + ".axes(%s);", wrapQuotes(str)));
        return this;
    }

    public Map axes(Boolean bool) {
        APIlib.getInstance().addJSLine(String.format(Locale.US, this.jsBase + ".axes(%s);", bool));
        return this;
    }

    @Override // com.anychart.core.SeparateChart, com.anychart.core.Chart
    public Background background() {
        return new Background(this.jsBase + ".background()");
    }

    @Override // com.anychart.core.SeparateChart, com.anychart.core.Chart
    public Map background(String str) {
        APIlib.getInstance().addJSLine(String.format(Locale.US, this.jsBase + ".background(%s);", wrapQuotes(str)));
        return this;
    }

    @Override // com.anychart.core.SeparateChart, com.anychart.core.Chart, com.anychart.core.VisualBaseWithBounds
    public void bottom() {
        APIlib.getInstance().addJSLine(this.jsBase + ".bottom();");
    }

    @Override // com.anychart.core.SeparateChart, com.anychart.core.Chart, com.anychart.core.VisualBaseWithBounds
    public Map bottom(Number number) {
        APIlib.getInstance().addJSLine(String.format(Locale.US, this.jsBase + ".bottom(%s);", number));
        return this;
    }

    @Override // com.anychart.core.SeparateChart, com.anychart.core.Chart, com.anychart.core.VisualBaseWithBounds
    public Map bottom(String str) {
        APIlib.getInstance().addJSLine(String.format(Locale.US, this.jsBase + ".bottom(%s);", wrapQuotes(str)));
        return this;
    }

    @Override // com.anychart.core.SeparateChart, com.anychart.core.Chart, com.anychart.core.VisualBaseWithBounds
    public Bounds bounds() {
        return new Bounds(this.jsBase + ".bounds()");
    }

    @Override // com.anychart.core.SeparateChart, com.anychart.core.Chart, com.anychart.core.VisualBaseWithBounds
    public Map bounds(RectObj rectObj) {
        APIlib.getInstance().addJSLine(String.format(Locale.US, this.jsBase + ".bounds(%s);", rectObj != null ? rectObj.getJsBase() : null));
        return this;
    }

    @Override // com.anychart.core.SeparateChart, com.anychart.core.Chart, com.anychart.core.VisualBaseWithBounds
    public Map bounds(Rect rect) {
        APIlib.getInstance().addJSLine(String.format(Locale.US, this.jsBase + ".bounds(%s);", rect != null ? rect.getJsBase() : null));
        return this;
    }

    @Override // com.anychart.core.SeparateChart, com.anychart.core.Chart, com.anychart.core.VisualBaseWithBounds
    public Map bounds(Bounds bounds) {
        APIlib.getInstance().addJSLine(String.format(Locale.US, this.jsBase + ".bounds(%s);", bounds != null ? bounds.getJsBase() : null));
        return this;
    }

    @Override // com.anychart.core.SeparateChart, com.anychart.core.Chart, com.anychart.core.VisualBaseWithBounds
    public Map bounds(Number number, Number number2, Number number3, Number number4) {
        APIlib.getInstance().addJSLine(String.format(Locale.US, this.jsBase + ".bounds(%s, %s, %s, %s);", number, number2, number3, number4));
        return this;
    }

    @Override // com.anychart.core.SeparateChart, com.anychart.core.Chart, com.anychart.core.VisualBaseWithBounds
    public Map bounds(Number number, Number number2, Number number3, String str) {
        APIlib.getInstance().addJSLine(String.format(Locale.US, this.jsBase + ".bounds(%s, %s, %s, %s);", number, number2, number3, wrapQuotes(str)));
        return this;
    }

    @Override // com.anychart.core.SeparateChart, com.anychart.core.Chart, com.anychart.core.VisualBaseWithBounds
    public Map bounds(Number number, Number number2, String str, Number number3) {
        APIlib.getInstance().addJSLine(String.format(Locale.US, this.jsBase + ".bounds(%s, %s, %s, %s);", number, number2, wrapQuotes(str), number3));
        return this;
    }

    @Override // com.anychart.core.SeparateChart, com.anychart.core.Chart, com.anychart.core.VisualBaseWithBounds
    public Map bounds(Number number, Number number2, String str, String str2) {
        APIlib.getInstance().addJSLine(String.format(Locale.US, this.jsBase + ".bounds(%s, %s, %s, %s);", number, number2, wrapQuotes(str), wrapQuotes(str2)));
        return this;
    }

    @Override // com.anychart.core.SeparateChart, com.anychart.core.Chart, com.anychart.core.VisualBaseWithBounds
    public Map bounds(Number number, String str, Number number2, Number number3) {
        APIlib.getInstance().addJSLine(String.format(Locale.US, this.jsBase + ".bounds(%s, %s, %s, %s);", number, wrapQuotes(str), number2, number3));
        return this;
    }

    @Override // com.anychart.core.SeparateChart, com.anychart.core.Chart, com.anychart.core.VisualBaseWithBounds
    public Map bounds(Number number, String str, Number number2, String str2) {
        APIlib.getInstance().addJSLine(String.format(Locale.US, this.jsBase + ".bounds(%s, %s, %s, %s);", number, wrapQuotes(str), number2, wrapQuotes(str2)));
        return this;
    }

    @Override // com.anychart.core.SeparateChart, com.anychart.core.Chart, com.anychart.core.VisualBaseWithBounds
    public Map bounds(Number number, String str, String str2, Number number2) {
        APIlib.getInstance().addJSLine(String.format(Locale.US, this.jsBase + ".bounds(%s, %s, %s, %s);", number, wrapQuotes(str), wrapQuotes(str2), number2));
        return this;
    }

    @Override // com.anychart.core.SeparateChart, com.anychart.core.Chart, com.anychart.core.VisualBaseWithBounds
    public Map bounds(Number number, String str, String str2, String str3) {
        APIlib.getInstance().addJSLine(String.format(Locale.US, this.jsBase + ".bounds(%s, %s, %s, %s);", number, wrapQuotes(str), wrapQuotes(str2), wrapQuotes(str3)));
        return this;
    }

    @Override // com.anychart.core.SeparateChart, com.anychart.core.Chart, com.anychart.core.VisualBaseWithBounds
    public Map bounds(String str, Number number, Number number2, Number number3) {
        APIlib.getInstance().addJSLine(String.format(Locale.US, this.jsBase + ".bounds(%s, %s, %s, %s);", wrapQuotes(str), number, number2, number3));
        return this;
    }

    @Override // com.anychart.core.SeparateChart, com.anychart.core.Chart, com.anychart.core.VisualBaseWithBounds
    public Map bounds(String str, Number number, Number number2, String str2) {
        APIlib.getInstance().addJSLine(String.format(Locale.US, this.jsBase + ".bounds(%s, %s, %s, %s);", wrapQuotes(str), number, number2, wrapQuotes(str2)));
        return this;
    }

    @Override // com.anychart.core.SeparateChart, com.anychart.core.Chart, com.anychart.core.VisualBaseWithBounds
    public Map bounds(String str, Number number, String str2, Number number2) {
        APIlib.getInstance().addJSLine(String.format(Locale.US, this.jsBase + ".bounds(%s, %s, %s, %s);", wrapQuotes(str), number, wrapQuotes(str2), number2));
        return this;
    }

    @Override // com.anychart.core.SeparateChart, com.anychart.core.Chart, com.anychart.core.VisualBaseWithBounds
    public Map bounds(String str, Number number, String str2, String str3) {
        APIlib.getInstance().addJSLine(String.format(Locale.US, this.jsBase + ".bounds(%s, %s, %s, %s);", wrapQuotes(str), number, wrapQuotes(str2), wrapQuotes(str3)));
        return this;
    }

    @Override // com.anychart.core.SeparateChart, com.anychart.core.Chart, com.anychart.core.VisualBaseWithBounds
    public Map bounds(String str, String str2, Number number, Number number2) {
        APIlib.getInstance().addJSLine(String.format(Locale.US, this.jsBase + ".bounds(%s, %s, %s, %s);", wrapQuotes(str), wrapQuotes(str2), number, number2));
        return this;
    }

    @Override // com.anychart.core.SeparateChart, com.anychart.core.Chart, com.anychart.core.VisualBaseWithBounds
    public Map bounds(String str, String str2, Number number, String str3) {
        APIlib.getInstance().addJSLine(String.format(Locale.US, this.jsBase + ".bounds(%s, %s, %s, %s);", wrapQuotes(str), wrapQuotes(str2), number, wrapQuotes(str3)));
        return this;
    }

    @Override // com.anychart.core.SeparateChart, com.anychart.core.Chart, com.anychart.core.VisualBaseWithBounds
    public Map bounds(String str, String str2, String str3, Number number) {
        APIlib.getInstance().addJSLine(String.format(Locale.US, this.jsBase + ".bounds(%s, %s, %s, %s);", wrapQuotes(str), wrapQuotes(str2), wrapQuotes(str3), number));
        return this;
    }

    @Override // com.anychart.core.SeparateChart, com.anychart.core.Chart, com.anychart.core.VisualBaseWithBounds
    public Map bounds(String str, String str2, String str3, String str4) {
        APIlib.getInstance().addJSLine(String.format(Locale.US, this.jsBase + ".bounds(%s, %s, %s, %s);", wrapQuotes(str), wrapQuotes(str2), wrapQuotes(str3), wrapQuotes(str4)));
        return this;
    }

    public Bubble bubble(List<DataEntry> list) {
        return new Bubble(String.format(Locale.US, this.jsBase + ".bubble(%s)", arrayToString(list)));
    }

    public Callout callout(Number number) {
        return new Callout(String.format(Locale.US, this.jsBase + ".callout(%s)", number));
    }

    public Map callout(String str) {
        APIlib.getInstance().addJSLine(String.format(Locale.US, this.jsBase + ".callout(%s);", wrapQuotes(str)));
        return this;
    }

    public Map callout(Boolean bool) {
        APIlib.getInstance().addJSLine(String.format(Locale.US, this.jsBase + ".callout(%s);", bool));
        return this;
    }

    public Map callout(Number number, String str) {
        APIlib.getInstance().addJSLine(String.format(Locale.US, this.jsBase + ".callout(%s, %s);", number, wrapQuotes(str)));
        return this;
    }

    public Map callout(Number number, Boolean bool) {
        APIlib.getInstance().addJSLine(String.format(Locale.US, this.jsBase + ".callout(%s, %s);", number, bool));
        return this;
    }

    @Override // com.anychart.core.SeparateChart, com.anychart.core.Chart
    public Map cancelMarquee() {
        APIlib.getInstance().addJSLine(this.jsBase + ".cancelMarquee();");
        return this;
    }

    public Choropleth choropleth(List<DataEntry> list) {
        return new Choropleth(String.format(Locale.US, this.jsBase + ".choropleth(%s)", arrayToString(list)));
    }

    public ColorRange colorRange() {
        return new ColorRange(this.jsBase + ".colorRange()");
    }

    public Map colorRange(String str) {
        APIlib.getInstance().addJSLine(String.format(Locale.US, this.jsBase + ".colorRange(%s);", wrapQuotes(str)));
        return this;
    }

    public Connector connector(List<DataEntry> list) {
        return new Connector(String.format(Locale.US, this.jsBase + ".connector(%s)", arrayToString(list)));
    }

    @Override // com.anychart.core.SeparateChart, com.anychart.core.Chart, com.anychart.core.VisualBaseWithBounds, com.anychart.core.VisualBase
    public Layer container() {
        return new Layer(this.jsBase + ".container()");
    }

    @Override // com.anychart.core.SeparateChart, com.anychart.core.Chart, com.anychart.core.VisualBaseWithBounds, com.anychart.core.VisualBase
    public Map container(Layer layer) {
        APIlib.getInstance().addJSLine(String.format(Locale.US, this.jsBase + ".container(%s);", layer != null ? layer.getJsBase() : null));
        return this;
    }

    @Override // com.anychart.core.SeparateChart, com.anychart.core.Chart, com.anychart.core.VisualBaseWithBounds, com.anychart.core.VisualBase
    public Map container(Stage stage) {
        APIlib.getInstance().addJSLine(String.format(Locale.US, this.jsBase + ".container(%s);", stage != null ? stage.getJsBase() : null));
        return this;
    }

    @Override // com.anychart.core.SeparateChart, com.anychart.core.Chart, com.anychart.core.VisualBaseWithBounds, com.anychart.core.VisualBase
    public Map container(String str) {
        APIlib.getInstance().addJSLine(String.format(Locale.US, this.jsBase + ".container(%s);", wrapQuotes(str)));
        return this;
    }

    @Override // com.anychart.core.SeparateChart, com.anychart.core.Chart
    public ContextMenu contextMenu() {
        return new ContextMenu(this.jsBase + ".contextMenu()");
    }

    @Override // com.anychart.core.SeparateChart, com.anychart.core.Chart
    public Map contextMenu(String str) {
        APIlib.getInstance().addJSLine(String.format(Locale.US, this.jsBase + ".contextMenu(%s);", wrapQuotes(str)));
        return this;
    }

    @Override // com.anychart.core.SeparateChart, com.anychart.core.Chart
    public Map contextMenu(Boolean bool) {
        APIlib.getInstance().addJSLine(String.format(Locale.US, this.jsBase + ".contextMenu(%s);", bool));
        return this;
    }

    @Override // com.anychart.core.SeparateChart, com.anychart.core.Chart
    public ChartCredits credits() {
        return new ChartCredits(this.jsBase + ".credits()");
    }

    @Override // com.anychart.core.SeparateChart, com.anychart.core.Chart
    public Map credits(String str) {
        APIlib.getInstance().addJSLine(String.format(Locale.US, this.jsBase + ".credits(%s);", wrapQuotes(str)));
        return this;
    }

    @Override // com.anychart.core.SeparateChart, com.anychart.core.Chart
    public Map credits(Boolean bool) {
        APIlib.getInstance().addJSLine(String.format(Locale.US, this.jsBase + ".credits(%s);", bool));
        return this;
    }

    public Crosshair crosshair() {
        return new Crosshair(this.jsBase + ".crosshair()");
    }

    public Map crosshair(String str) {
        APIlib.getInstance().addJSLine(String.format(Locale.US, this.jsBase + ".crosshair(%s);", wrapQuotes(str)));
        return this;
    }

    public Map crosshair(Boolean bool) {
        APIlib.getInstance().addJSLine(String.format(Locale.US, this.jsBase + ".crosshair(%s);", bool));
        return this;
    }

    public void crs() {
        APIlib.getInstance().addJSLine(this.jsBase + ".crs();");
    }

    public Map crs(String str) {
        APIlib.getInstance().addJSLine(String.format(Locale.US, this.jsBase + ".crs(%s);", wrapQuotes(str)));
        return this;
    }

    public Map crs(MapProjections mapProjections) {
        APIlib.getInstance().addJSLine(String.format(Locale.US, this.jsBase + ".crs(%s);", mapProjections != null ? mapProjections.getJsBase() : null));
        return this;
    }

    public Animation crsAnimation() {
        return new Animation(this.jsBase + ".crsAnimation()");
    }

    public Map crsAnimation(Boolean bool, Number number) {
        APIlib.getInstance().addJSLine(String.format(Locale.US, this.jsBase + ".crsAnimation(%s, %s);", bool, number));
        return this;
    }

    public Map crsAnimation(String str, Number number) {
        APIlib.getInstance().addJSLine(String.format(Locale.US, this.jsBase + ".crsAnimation(%s, %s);", wrapQuotes(str), number));
        return this;
    }

    public void defaultSeriesType() {
        APIlib.getInstance().addJSLine(this.jsBase + ".defaultSeriesType();");
    }

    public Map defaultSeriesType(MapSeriesType mapSeriesType) {
        APIlib.getInstance().addJSLine(String.format(Locale.US, this.jsBase + ".defaultSeriesType(%s);", mapSeriesType != null ? mapSeriesType.getJsBase() : null));
        return this;
    }

    public Map defaultSeriesType(String str) {
        APIlib.getInstance().addJSLine(String.format(Locale.US, this.jsBase + ".defaultSeriesType(%s);", wrapQuotes(str)));
        return this;
    }

    @Override // com.anychart.core.SeparateChart, com.anychart.core.Chart
    public void dispose() {
        APIlib.getInstance().addJSLine(this.jsBase + ".dispose();");
    }

    @Override // com.anychart.core.SeparateChart, com.anychart.core.Chart
    public Map draw(Boolean bool) {
        APIlib.getInstance().addJSLine(String.format(Locale.US, this.jsBase + ".draw(%s);", bool));
        return this;
    }

    public Map drillTo(String str, Map map) {
        APIlib.getInstance().addJSLine(String.format(Locale.US, this.jsBase + ".drillTo(%s, %s);", wrapQuotes(str), map != null ? map.getJsBase() : null));
        return this;
    }

    public Map drillUp() {
        APIlib.getInstance().addJSLine(this.jsBase + ".drillUp();");
        return this;
    }

    @Override // com.anychart.core.SeparateChart, com.anychart.core.Chart, com.anychart.core.VisualBaseWithBounds, com.anychart.core.VisualBase
    public void enabled() {
        APIlib.getInstance().addJSLine(this.jsBase + ".enabled();");
    }

    @Override // com.anychart.core.SeparateChart, com.anychart.core.Chart, com.anychart.core.VisualBaseWithBounds, com.anychart.core.VisualBase
    public Map enabled(Boolean bool) {
        APIlib.getInstance().addJSLine(String.format(Locale.US, this.jsBase + ".enabled(%s);", bool));
        return this;
    }

    @Override // com.anychart.core.SeparateChart, com.anychart.core.Chart
    public Exports exports() {
        return new Exports(this.jsBase + ".exports()");
    }

    @Override // com.anychart.core.SeparateChart, com.anychart.core.Chart
    public Map exports(String str) {
        APIlib.getInstance().addJSLine(String.format(Locale.US, this.jsBase + ".exports(%s);", wrapQuotes(str)));
        return this;
    }

    public void featureCrs(String str) {
        APIlib.getInstance().addJSLine(String.format(Locale.US, this.jsBase + ".featureCrs(%s);", wrapQuotes(str)));
    }

    public Map featureCrs(String str, String str2) {
        APIlib.getInstance().addJSLine(String.format(Locale.US, this.jsBase + ".featureCrs(%s, %s);", wrapQuotes(str), wrapQuotes(str2)));
        return this;
    }

    public void featureScaleFactor(String str) {
        APIlib.getInstance().addJSLine(String.format(Locale.US, this.jsBase + ".featureScaleFactor(%s);", wrapQuotes(str)));
    }

    public Map featureScaleFactor(String str, Number number) {
        APIlib.getInstance().addJSLine(String.format(Locale.US, this.jsBase + ".featureScaleFactor(%s, %s);", wrapQuotes(str), number));
        return this;
    }

    public void featureTranslation(String str) {
        APIlib.getInstance().addJSLine(String.format(Locale.US, this.jsBase + ".featureTranslation(%s);", wrapQuotes(str)));
    }

    public Map featureTranslation(String str, Number number, Number number2) {
        APIlib.getInstance().addJSLine(String.format(Locale.US, this.jsBase + ".featureTranslation(%s, %s, %s);", wrapQuotes(str), number, number2));
        return this;
    }

    @Override // com.anychart.core.SeparateChart, com.anychart.core.Chart
    public void fullScreen() {
        APIlib.getInstance().addJSLine(this.jsBase + ".fullScreen();");
    }

    @Override // com.anychart.core.SeparateChart, com.anychart.core.Chart
    public Map fullScreen(Boolean bool) {
        APIlib.getInstance().addJSLine(String.format(Locale.US, this.jsBase + ".fullScreen(%s);", bool));
        return this;
    }

    public void geoData() {
        APIlib.getInstance().addJSLine(this.jsBase + ".geoData();");
    }

    public Map geoData(String str) {
        APIlib.getInstance().addJSLine(String.format(Locale.US, this.jsBase + ".geoData(%s);", wrapQuotes(str)));
        return this;
    }

    public void geoIdField() {
        APIlib.getInstance().addJSLine(this.jsBase + ".geoIdField();");
    }

    public Map geoIdField(String str) {
        APIlib.getInstance().addJSLine(String.format(Locale.US, this.jsBase + ".geoIdField(%s);", wrapQuotes(str)));
        return this;
    }

    public void getDrilldownPath() {
        APIlib.getInstance().addJSLine(this.jsBase + ".getDrilldownPath();");
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

    public void getZoomLevel() {
        APIlib.getInstance().addJSLine(this.jsBase + ".getZoomLevel();");
    }

    @Override // com.anychart.core.SeparateChart, com.anychart.core.Chart
    public void globalToLocal(Number number, Number number2) {
        APIlib.getInstance().addJSLine(String.format(Locale.US, this.jsBase + ".globalToLocal(%s, %s);", number, number2));
    }

    public com.anychart.core.grids.MapSettings grids() {
        return new com.anychart.core.grids.MapSettings(this.jsBase + ".grids()");
    }

    public Map grids(String str) {
        APIlib.getInstance().addJSLine(String.format(Locale.US, this.jsBase + ".grids(%s);", wrapQuotes(str)));
        return this;
    }

    public Map grids(Boolean bool) {
        APIlib.getInstance().addJSLine(String.format(Locale.US, this.jsBase + ".grids(%s);", bool));
        return this;
    }

    public HatchFills hatchFillPalette() {
        return new HatchFills(this.jsBase + ".hatchFillPalette()");
    }

    public Map hatchFillPalette(HatchFillType[] hatchFillTypeArr) {
        APIlib.getInstance().addJSLine(String.format(Locale.US, this.jsBase + ".hatchFillPalette(%s);", arrayToString(hatchFillTypeArr)));
        return this;
    }

    public Map hatchFillPalette(String str) {
        APIlib.getInstance().addJSLine(String.format(Locale.US, this.jsBase + ".hatchFillPalette(%s);", wrapQuotes(str)));
        return this;
    }

    public Map hatchFillPalette(HatchFills hatchFills) {
        APIlib.getInstance().addJSLine(String.format(Locale.US, this.jsBase + ".hatchFillPalette(%s);", hatchFills != null ? hatchFills.getJsBase() : null));
        return this;
    }

    @Override // com.anychart.core.SeparateChart, com.anychart.core.Chart, com.anychart.core.VisualBaseWithBounds
    public void height() {
        APIlib.getInstance().addJSLine(this.jsBase + ".height();");
    }

    @Override // com.anychart.core.SeparateChart, com.anychart.core.Chart, com.anychart.core.VisualBaseWithBounds
    public Map height(Number number) {
        APIlib.getInstance().addJSLine(String.format(Locale.US, this.jsBase + ".height(%s);", number));
        return this;
    }

    @Override // com.anychart.core.SeparateChart, com.anychart.core.Chart, com.anychart.core.VisualBaseWithBounds
    public Map height(String str) {
        APIlib.getInstance().addJSLine(String.format(Locale.US, this.jsBase + ".height(%s);", wrapQuotes(str)));
        return this;
    }

    public StateSettings hovered() {
        return new StateSettings(this.jsBase + ".hovered()");
    }

    public Map hovered(String str) {
        APIlib.getInstance().addJSLine(String.format(Locale.US, this.jsBase + ".hovered(%s);", wrapQuotes(str)));
        return this;
    }

    @Override // com.anychart.core.SeparateChart, com.anychart.core.Chart
    public void id() {
        APIlib.getInstance().addJSLine(this.jsBase + ".id();");
    }

    @Override // com.anychart.core.SeparateChart, com.anychart.core.Chart
    public Map id(String str) {
        APIlib.getInstance().addJSLine(String.format(Locale.US, this.jsBase + ".id(%s);", wrapQuotes(str)));
        return this;
    }

    @Override // com.anychart.core.SeparateChart, com.anychart.core.Chart
    public void inMarquee() {
        APIlib.getInstance().addJSLine(this.jsBase + ".inMarquee();");
    }

    @Override // com.anychart.core.SeparateChart
    public Map interactivity(String str) {
        APIlib.getInstance().addJSLine(String.format(Locale.US, this.jsBase + ".interactivity(%s);", wrapQuotes(str)));
        return this;
    }

    public void inverseTransform(Number number, Number number2) {
        APIlib.getInstance().addJSLine(String.format(Locale.US, this.jsBase + ".inverseTransform(%s, %s);", number, number2));
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
    public Map label(Boolean bool) {
        APIlib.getInstance().addJSLine(String.format(Locale.US, this.jsBase + ".label(%s);", bool));
        return this;
    }

    @Override // com.anychart.core.SeparateChart, com.anychart.core.Chart
    public Map label(String str, Boolean bool) {
        APIlib.getInstance().addJSLine(String.format(Locale.US, this.jsBase + ".label(%s, %s);", wrapQuotes(str), bool));
        return this;
    }

    @Override // com.anychart.core.SeparateChart, com.anychart.core.Chart
    public Map label(String str, String str2) {
        APIlib.getInstance().addJSLine(String.format(Locale.US, this.jsBase + ".label(%s, %s);", wrapQuotes(str), wrapQuotes(str2)));
        return this;
    }

    @Override // com.anychart.core.SeparateChart, com.anychart.core.Chart
    public Map label(Number number, Boolean bool) {
        APIlib.getInstance().addJSLine(String.format(Locale.US, this.jsBase + ".label(%s, %s);", number, bool));
        return this;
    }

    @Override // com.anychart.core.SeparateChart, com.anychart.core.Chart
    public Map label(Number number, String str) {
        APIlib.getInstance().addJSLine(String.format(Locale.US, this.jsBase + ".label(%s, %s);", number, wrapQuotes(str)));
        return this;
    }

    public LabelsFactory labels() {
        return new LabelsFactory(this.jsBase + ".labels()");
    }

    public Map labels(String str) {
        APIlib.getInstance().addJSLine(String.format(Locale.US, this.jsBase + ".labels(%s);", wrapQuotes(str)));
        return this;
    }

    public Map labels(Boolean bool) {
        APIlib.getInstance().addJSLine(String.format(Locale.US, this.jsBase + ".labels(%s);", bool));
        return this;
    }

    @Override // com.anychart.core.SeparateChart, com.anychart.core.Chart, com.anychart.core.VisualBaseWithBounds
    public void left() {
        APIlib.getInstance().addJSLine(this.jsBase + ".left();");
    }

    @Override // com.anychart.core.SeparateChart, com.anychart.core.Chart, com.anychart.core.VisualBaseWithBounds
    public Map left(Number number) {
        APIlib.getInstance().addJSLine(String.format(Locale.US, this.jsBase + ".left(%s);", number));
        return this;
    }

    @Override // com.anychart.core.SeparateChart, com.anychart.core.Chart, com.anychart.core.VisualBaseWithBounds
    public Map left(String str) {
        APIlib.getInstance().addJSLine(String.format(Locale.US, this.jsBase + ".left(%s);", wrapQuotes(str)));
        return this;
    }

    @Override // com.anychart.core.SeparateChart
    public Legend legend() {
        return new Legend(this.jsBase + ".legend()");
    }

    @Override // com.anychart.core.SeparateChart
    public Map legend(String str) {
        APIlib.getInstance().addJSLine(String.format(Locale.US, this.jsBase + ".legend(%s);", wrapQuotes(str)));
        return this;
    }

    @Override // com.anychart.core.SeparateChart
    public Map legend(Boolean bool) {
        APIlib.getInstance().addJSLine(String.format(Locale.US, this.jsBase + ".legend(%s);", bool));
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
    public Map margin(Number[] numberArr) {
        APIlib.getInstance().addJSLine(String.format(Locale.US, this.jsBase + ".margin(%s);", Arrays.toString(numberArr)));
        return this;
    }

    @Override // com.anychart.core.SeparateChart, com.anychart.core.Chart
    public Map margin(String[] strArr) {
        APIlib.getInstance().addJSLine(String.format(Locale.US, this.jsBase + ".margin(%s);", arrayToStringWrapQuotes(strArr)));
        return this;
    }

    @Override // com.anychart.core.SeparateChart, com.anychart.core.Chart
    public Map margin(String str) {
        APIlib.getInstance().addJSLine(String.format(Locale.US, this.jsBase + ".margin(%s);", wrapQuotes(str)));
        return this;
    }

    @Override // com.anychart.core.SeparateChart, com.anychart.core.Chart
    public Map margin(String str, String str2, String str3, String str4) {
        APIlib.getInstance().addJSLine(String.format(Locale.US, this.jsBase + ".margin(%s, %s, %s, %s);", wrapQuotes(str), wrapQuotes(str2), wrapQuotes(str3), wrapQuotes(str4)));
        return this;
    }

    @Override // com.anychart.core.SeparateChart, com.anychart.core.Chart
    public Map margin(String str, String str2, String str3, Number number) {
        APIlib.getInstance().addJSLine(String.format(Locale.US, this.jsBase + ".margin(%s, %s, %s, %s);", wrapQuotes(str), wrapQuotes(str2), wrapQuotes(str3), number));
        return this;
    }

    @Override // com.anychart.core.SeparateChart, com.anychart.core.Chart
    public Map margin(String str, String str2, Number number, String str3) {
        APIlib.getInstance().addJSLine(String.format(Locale.US, this.jsBase + ".margin(%s, %s, %s, %s);", wrapQuotes(str), wrapQuotes(str2), number, wrapQuotes(str3)));
        return this;
    }

    @Override // com.anychart.core.SeparateChart, com.anychart.core.Chart
    public Map margin(String str, String str2, Number number, Number number2) {
        APIlib.getInstance().addJSLine(String.format(Locale.US, this.jsBase + ".margin(%s, %s, %s, %s);", wrapQuotes(str), wrapQuotes(str2), number, number2));
        return this;
    }

    @Override // com.anychart.core.SeparateChart, com.anychart.core.Chart
    public Map margin(String str, Number number, String str2, String str3) {
        APIlib.getInstance().addJSLine(String.format(Locale.US, this.jsBase + ".margin(%s, %s, %s, %s);", wrapQuotes(str), number, wrapQuotes(str2), wrapQuotes(str3)));
        return this;
    }

    @Override // com.anychart.core.SeparateChart, com.anychart.core.Chart
    public Map margin(String str, Number number, String str2, Number number2) {
        APIlib.getInstance().addJSLine(String.format(Locale.US, this.jsBase + ".margin(%s, %s, %s, %s);", wrapQuotes(str), number, wrapQuotes(str2), number2));
        return this;
    }

    @Override // com.anychart.core.SeparateChart, com.anychart.core.Chart
    public Map margin(String str, Number number, Number number2, String str2) {
        APIlib.getInstance().addJSLine(String.format(Locale.US, this.jsBase + ".margin(%s, %s, %s, %s);", wrapQuotes(str), number, number2, wrapQuotes(str2)));
        return this;
    }

    @Override // com.anychart.core.SeparateChart, com.anychart.core.Chart
    public Map margin(String str, Number number, Number number2, Number number3) {
        APIlib.getInstance().addJSLine(String.format(Locale.US, this.jsBase + ".margin(%s, %s, %s, %s);", wrapQuotes(str), number, number2, number3));
        return this;
    }

    @Override // com.anychart.core.SeparateChart, com.anychart.core.Chart
    public Map margin(Number number, String str, String str2, String str3) {
        APIlib.getInstance().addJSLine(String.format(Locale.US, this.jsBase + ".margin(%s, %s, %s, %s);", number, wrapQuotes(str), wrapQuotes(str2), wrapQuotes(str3)));
        return this;
    }

    @Override // com.anychart.core.SeparateChart, com.anychart.core.Chart
    public Map margin(Number number, String str, String str2, Number number2) {
        APIlib.getInstance().addJSLine(String.format(Locale.US, this.jsBase + ".margin(%s, %s, %s, %s);", number, wrapQuotes(str), wrapQuotes(str2), number2));
        return this;
    }

    @Override // com.anychart.core.SeparateChart, com.anychart.core.Chart
    public Map margin(Number number, String str, Number number2, String str2) {
        APIlib.getInstance().addJSLine(String.format(Locale.US, this.jsBase + ".margin(%s, %s, %s, %s);", number, wrapQuotes(str), number2, wrapQuotes(str2)));
        return this;
    }

    @Override // com.anychart.core.SeparateChart, com.anychart.core.Chart
    public Map margin(Number number, String str, Number number2, Number number3) {
        APIlib.getInstance().addJSLine(String.format(Locale.US, this.jsBase + ".margin(%s, %s, %s, %s);", number, wrapQuotes(str), number2, number3));
        return this;
    }

    @Override // com.anychart.core.SeparateChart, com.anychart.core.Chart
    public Map margin(Number number, Number number2, String str, String str2) {
        APIlib.getInstance().addJSLine(String.format(Locale.US, this.jsBase + ".margin(%s, %s, %s, %s);", number, number2, wrapQuotes(str), wrapQuotes(str2)));
        return this;
    }

    @Override // com.anychart.core.SeparateChart, com.anychart.core.Chart
    public Map margin(Number number, Number number2, String str, Number number3) {
        APIlib.getInstance().addJSLine(String.format(Locale.US, this.jsBase + ".margin(%s, %s, %s, %s);", number, number2, wrapQuotes(str), number3));
        return this;
    }

    @Override // com.anychart.core.SeparateChart, com.anychart.core.Chart
    public Map margin(Number number, Number number2, Number number3, String str) {
        APIlib.getInstance().addJSLine(String.format(Locale.US, this.jsBase + ".margin(%s, %s, %s, %s);", number, number2, number3, wrapQuotes(str)));
        return this;
    }

    @Override // com.anychart.core.SeparateChart, com.anychart.core.Chart
    public Map margin(Number number, Number number2, Number number3, Number number4) {
        APIlib.getInstance().addJSLine(String.format(Locale.US, this.jsBase + ".margin(%s, %s, %s, %s);", number, number2, number3, number4));
        return this;
    }

    public Marker marker(List<DataEntry> list) {
        return new Marker(String.format(Locale.US, this.jsBase + ".marker(%s)", arrayToString(list)));
    }

    public Markers markerPalette() {
        return new Markers(this.jsBase + ".markerPalette()");
    }

    public Map markerPalette(Markers markers) {
        APIlib.getInstance().addJSLine(String.format(Locale.US, this.jsBase + ".markerPalette(%s);", markers != null ? markers.getJsBase() : null));
        return this;
    }

    public Map markerPalette(String str) {
        APIlib.getInstance().addJSLine(String.format(Locale.US, this.jsBase + ".markerPalette(%s);", wrapQuotes(str)));
        return this;
    }

    public Map markerPalette(MarkerType markerType) {
        APIlib.getInstance().addJSLine(String.format(Locale.US, this.jsBase + ".markerPalette(%s);", markerType != null ? markerType.getJsBase() : null));
        return this;
    }

    public Map markerPalette(String[] strArr) {
        APIlib.getInstance().addJSLine(String.format(Locale.US, this.jsBase + ".markerPalette(%s);", arrayToStringWrapQuotes(strArr)));
        return this;
    }

    public void maxBubbleSize() {
        APIlib.getInstance().addJSLine(this.jsBase + ".maxBubbleSize();");
    }

    public Map maxBubbleSize(Number number) {
        APIlib.getInstance().addJSLine(String.format(Locale.US, this.jsBase + ".maxBubbleSize(%s);", number));
        return this;
    }

    public Map maxBubbleSize(String str) {
        APIlib.getInstance().addJSLine(String.format(Locale.US, this.jsBase + ".maxBubbleSize(%s);", wrapQuotes(str)));
        return this;
    }

    @Override // com.anychart.core.SeparateChart, com.anychart.core.Chart, com.anychart.core.VisualBaseWithBounds
    public void maxHeight() {
        APIlib.getInstance().addJSLine(this.jsBase + ".maxHeight();");
    }

    @Override // com.anychart.core.SeparateChart, com.anychart.core.Chart, com.anychart.core.VisualBaseWithBounds
    public Map maxHeight(Number number) {
        APIlib.getInstance().addJSLine(String.format(Locale.US, this.jsBase + ".maxHeight(%s);", number));
        return this;
    }

    @Override // com.anychart.core.SeparateChart, com.anychart.core.Chart, com.anychart.core.VisualBaseWithBounds
    public Map maxHeight(String str) {
        APIlib.getInstance().addJSLine(String.format(Locale.US, this.jsBase + ".maxHeight(%s);", wrapQuotes(str)));
        return this;
    }

    @Override // com.anychart.core.SeparateChart, com.anychart.core.Chart, com.anychart.core.VisualBaseWithBounds
    public void maxWidth() {
        APIlib.getInstance().addJSLine(this.jsBase + ".maxWidth();");
    }

    @Override // com.anychart.core.SeparateChart, com.anychart.core.Chart, com.anychart.core.VisualBaseWithBounds
    public Map maxWidth(Number number) {
        APIlib.getInstance().addJSLine(String.format(Locale.US, this.jsBase + ".maxWidth(%s);", number));
        return this;
    }

    @Override // com.anychart.core.SeparateChart, com.anychart.core.Chart, com.anychart.core.VisualBaseWithBounds
    public Map maxWidth(String str) {
        APIlib.getInstance().addJSLine(String.format(Locale.US, this.jsBase + ".maxWidth(%s);", wrapQuotes(str)));
        return this;
    }

    public void maxZoomLevel() {
        APIlib.getInstance().addJSLine(this.jsBase + ".maxZoomLevel();");
    }

    public Map maxZoomLevel(Number number) {
        APIlib.getInstance().addJSLine(String.format(Locale.US, this.jsBase + ".maxZoomLevel(%s);", number));
        return this;
    }

    public void minBubbleSize() {
        APIlib.getInstance().addJSLine(this.jsBase + ".minBubbleSize();");
    }

    public Map minBubbleSize(Number number) {
        APIlib.getInstance().addJSLine(String.format(Locale.US, this.jsBase + ".minBubbleSize(%s);", number));
        return this;
    }

    public Map minBubbleSize(String str) {
        APIlib.getInstance().addJSLine(String.format(Locale.US, this.jsBase + ".minBubbleSize(%s);", wrapQuotes(str)));
        return this;
    }

    @Override // com.anychart.core.SeparateChart, com.anychart.core.Chart, com.anychart.core.VisualBaseWithBounds
    public void minHeight() {
        APIlib.getInstance().addJSLine(this.jsBase + ".minHeight();");
    }

    @Override // com.anychart.core.SeparateChart, com.anychart.core.Chart, com.anychart.core.VisualBaseWithBounds
    public Map minHeight(Number number) {
        APIlib.getInstance().addJSLine(String.format(Locale.US, this.jsBase + ".minHeight(%s);", number));
        return this;
    }

    @Override // com.anychart.core.SeparateChart, com.anychart.core.Chart, com.anychart.core.VisualBaseWithBounds
    public Map minHeight(String str) {
        APIlib.getInstance().addJSLine(String.format(Locale.US, this.jsBase + ".minHeight(%s);", wrapQuotes(str)));
        return this;
    }

    @Override // com.anychart.core.SeparateChart, com.anychart.core.Chart, com.anychart.core.VisualBaseWithBounds
    public void minWidth() {
        APIlib.getInstance().addJSLine(this.jsBase + ".minWidth();");
    }

    @Override // com.anychart.core.SeparateChart, com.anychart.core.Chart, com.anychart.core.VisualBaseWithBounds
    public Map minWidth(Number number) {
        APIlib.getInstance().addJSLine(String.format(Locale.US, this.jsBase + ".minWidth(%s);", number));
        return this;
    }

    @Override // com.anychart.core.SeparateChart, com.anychart.core.Chart, com.anychart.core.VisualBaseWithBounds
    public Map minWidth(String str) {
        APIlib.getInstance().addJSLine(String.format(Locale.US, this.jsBase + ".minWidth(%s);", wrapQuotes(str)));
        return this;
    }

    public Map move(Number number, Number number2) {
        APIlib.getInstance().addJSLine(String.format(Locale.US, this.jsBase + ".move(%s, %s);", number, number2));
        return this;
    }

    @Override // com.anychart.core.SeparateChart, com.anychart.core.Chart
    public NoDataSettings noData() {
        return new NoDataSettings(this.jsBase + ".noData()");
    }

    @Override // com.anychart.core.SeparateChart, com.anychart.core.Chart
    public Map noData(String str) {
        APIlib.getInstance().addJSLine(String.format(Locale.US, this.jsBase + ".noData(%s);", wrapQuotes(str)));
        return this;
    }

    public StateSettings normal() {
        return new StateSettings(this.jsBase + ".normal()");
    }

    public Map normal(String str) {
        APIlib.getInstance().addJSLine(String.format(Locale.US, this.jsBase + ".normal(%s);", wrapQuotes(str)));
        return this;
    }

    public void overlapMode() {
        APIlib.getInstance().addJSLine(this.jsBase + ".overlapMode();");
    }

    public Map overlapMode(LabelsOverlapMode labelsOverlapMode) {
        APIlib.getInstance().addJSLine(String.format(Locale.US, this.jsBase + ".overlapMode(%s);", labelsOverlapMode != null ? labelsOverlapMode.getJsBase() : null));
        return this;
    }

    public Map overlapMode(String str) {
        APIlib.getInstance().addJSLine(String.format(Locale.US, this.jsBase + ".overlapMode(%s);", wrapQuotes(str)));
        return this;
    }

    public Map overlapMode(Boolean bool) {
        APIlib.getInstance().addJSLine(String.format(Locale.US, this.jsBase + ".overlapMode(%s);", bool));
        return this;
    }

    @Override // com.anychart.core.SeparateChart, com.anychart.core.Chart
    public Padding padding() {
        return new Padding(this.jsBase + ".padding()");
    }

    @Override // com.anychart.core.SeparateChart, com.anychart.core.Chart
    public Map padding(Number[] numberArr) {
        APIlib.getInstance().addJSLine(String.format(Locale.US, this.jsBase + ".padding(%s);", Arrays.toString(numberArr)));
        return this;
    }

    @Override // com.anychart.core.SeparateChart, com.anychart.core.Chart
    public Map padding(String[] strArr) {
        APIlib.getInstance().addJSLine(String.format(Locale.US, this.jsBase + ".padding(%s);", arrayToStringWrapQuotes(strArr)));
        return this;
    }

    @Override // com.anychart.core.SeparateChart, com.anychart.core.Chart
    public Map padding(String str) {
        APIlib.getInstance().addJSLine(String.format(Locale.US, this.jsBase + ".padding(%s);", wrapQuotes(str)));
        return this;
    }

    @Override // com.anychart.core.SeparateChart, com.anychart.core.Chart
    public Map padding(String str, String str2, String str3, String str4) {
        APIlib.getInstance().addJSLine(String.format(Locale.US, this.jsBase + ".padding(%s, %s, %s, %s);", wrapQuotes(str), wrapQuotes(str2), wrapQuotes(str3), wrapQuotes(str4)));
        return this;
    }

    @Override // com.anychart.core.SeparateChart, com.anychart.core.Chart
    public Map padding(String str, String str2, String str3, Number number) {
        APIlib.getInstance().addJSLine(String.format(Locale.US, this.jsBase + ".padding(%s, %s, %s, %s);", wrapQuotes(str), wrapQuotes(str2), wrapQuotes(str3), number));
        return this;
    }

    @Override // com.anychart.core.SeparateChart, com.anychart.core.Chart
    public Map padding(String str, String str2, Number number, String str3) {
        APIlib.getInstance().addJSLine(String.format(Locale.US, this.jsBase + ".padding(%s, %s, %s, %s);", wrapQuotes(str), wrapQuotes(str2), number, wrapQuotes(str3)));
        return this;
    }

    @Override // com.anychart.core.SeparateChart, com.anychart.core.Chart
    public Map padding(String str, String str2, Number number, Number number2) {
        APIlib.getInstance().addJSLine(String.format(Locale.US, this.jsBase + ".padding(%s, %s, %s, %s);", wrapQuotes(str), wrapQuotes(str2), number, number2));
        return this;
    }

    @Override // com.anychart.core.SeparateChart, com.anychart.core.Chart
    public Map padding(String str, Number number, String str2, String str3) {
        APIlib.getInstance().addJSLine(String.format(Locale.US, this.jsBase + ".padding(%s, %s, %s, %s);", wrapQuotes(str), number, wrapQuotes(str2), wrapQuotes(str3)));
        return this;
    }

    @Override // com.anychart.core.SeparateChart, com.anychart.core.Chart
    public Map padding(String str, Number number, String str2, Number number2) {
        APIlib.getInstance().addJSLine(String.format(Locale.US, this.jsBase + ".padding(%s, %s, %s, %s);", wrapQuotes(str), number, wrapQuotes(str2), number2));
        return this;
    }

    @Override // com.anychart.core.SeparateChart, com.anychart.core.Chart
    public Map padding(String str, Number number, Number number2, String str2) {
        APIlib.getInstance().addJSLine(String.format(Locale.US, this.jsBase + ".padding(%s, %s, %s, %s);", wrapQuotes(str), number, number2, wrapQuotes(str2)));
        return this;
    }

    @Override // com.anychart.core.SeparateChart, com.anychart.core.Chart
    public Map padding(String str, Number number, Number number2, Number number3) {
        APIlib.getInstance().addJSLine(String.format(Locale.US, this.jsBase + ".padding(%s, %s, %s, %s);", wrapQuotes(str), number, number2, number3));
        return this;
    }

    @Override // com.anychart.core.SeparateChart, com.anychart.core.Chart
    public Map padding(Number number, String str, String str2, String str3) {
        APIlib.getInstance().addJSLine(String.format(Locale.US, this.jsBase + ".padding(%s, %s, %s, %s);", number, wrapQuotes(str), wrapQuotes(str2), wrapQuotes(str3)));
        return this;
    }

    @Override // com.anychart.core.SeparateChart, com.anychart.core.Chart
    public Map padding(Number number, String str, String str2, Number number2) {
        APIlib.getInstance().addJSLine(String.format(Locale.US, this.jsBase + ".padding(%s, %s, %s, %s);", number, wrapQuotes(str), wrapQuotes(str2), number2));
        return this;
    }

    @Override // com.anychart.core.SeparateChart, com.anychart.core.Chart
    public Map padding(Number number, String str, Number number2, String str2) {
        APIlib.getInstance().addJSLine(String.format(Locale.US, this.jsBase + ".padding(%s, %s, %s, %s);", number, wrapQuotes(str), number2, wrapQuotes(str2)));
        return this;
    }

    @Override // com.anychart.core.SeparateChart, com.anychart.core.Chart
    public Map padding(Number number, String str, Number number2, Number number3) {
        APIlib.getInstance().addJSLine(String.format(Locale.US, this.jsBase + ".padding(%s, %s, %s, %s);", number, wrapQuotes(str), number2, number3));
        return this;
    }

    @Override // com.anychart.core.SeparateChart, com.anychart.core.Chart
    public Map padding(Number number, Number number2, String str, String str2) {
        APIlib.getInstance().addJSLine(String.format(Locale.US, this.jsBase + ".padding(%s, %s, %s, %s);", number, number2, wrapQuotes(str), wrapQuotes(str2)));
        return this;
    }

    @Override // com.anychart.core.SeparateChart, com.anychart.core.Chart
    public Map padding(Number number, Number number2, String str, Number number3) {
        APIlib.getInstance().addJSLine(String.format(Locale.US, this.jsBase + ".padding(%s, %s, %s, %s);", number, number2, wrapQuotes(str), number3));
        return this;
    }

    @Override // com.anychart.core.SeparateChart, com.anychart.core.Chart
    public Map padding(Number number, Number number2, Number number3, String str) {
        APIlib.getInstance().addJSLine(String.format(Locale.US, this.jsBase + ".padding(%s, %s, %s, %s);", number, number2, number3, wrapQuotes(str)));
        return this;
    }

    @Override // com.anychart.core.SeparateChart, com.anychart.core.Chart
    public Map padding(Number number, Number number2, Number number3, Number number4) {
        APIlib.getInstance().addJSLine(String.format(Locale.US, this.jsBase + ".padding(%s, %s, %s, %s);", number, number2, number3, number4));
        return this;
    }

    public RangeColors palette() {
        return new RangeColors(this.jsBase + ".palette()");
    }

    public Map palette(RangeColors rangeColors) {
        APIlib.getInstance().addJSLine(String.format(Locale.US, this.jsBase + ".palette(%s);", rangeColors != null ? rangeColors.getJsBase() : null));
        return this;
    }

    public Map palette(DistinctColors distinctColors) {
        APIlib.getInstance().addJSLine(String.format(Locale.US, this.jsBase + ".palette(%s);", distinctColors != null ? distinctColors.getJsBase() : null));
        return this;
    }

    public Map palette(String str) {
        APIlib.getInstance().addJSLine(String.format(Locale.US, this.jsBase + ".palette(%s);", wrapQuotes(str)));
        return this;
    }

    public Map palette(String[] strArr) {
        APIlib.getInstance().addJSLine(String.format(Locale.US, this.jsBase + ".palette(%s);", arrayToStringWrapQuotes(strArr)));
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

    @Override // com.anychart.core.SeparateChart, com.anychart.core.Chart, com.anychart.core.VisualBaseWithBounds, com.anychart.core.VisualBase, com.anychart.core.Base
    public void removeAllListeners(String str) {
        APIlib.getInstance().addJSLine(String.format(Locale.US, this.jsBase + ".removeAllListeners(%s);", wrapQuotes(str)));
    }

    public Map removeAllSeries() {
        APIlib.getInstance().addJSLine(this.jsBase + ".removeAllSeries();");
        return this;
    }

    public Map removeSeries(Number number) {
        APIlib.getInstance().addJSLine(String.format(Locale.US, this.jsBase + ".removeSeries(%s);", number));
        return this;
    }

    public Map removeSeries(String str) {
        APIlib.getInstance().addJSLine(String.format(Locale.US, this.jsBase + ".removeSeries(%s);", wrapQuotes(str)));
        return this;
    }

    public Map removeSeriesAt(Number number) {
        APIlib.getInstance().addJSLine(String.format(Locale.US, this.jsBase + ".removeSeriesAt(%s);", number));
        return this;
    }

    @Override // com.anychart.core.SeparateChart, com.anychart.core.Chart, com.anychart.core.VisualBaseWithBounds
    public void right() {
        APIlib.getInstance().addJSLine(this.jsBase + ".right();");
    }

    @Override // com.anychart.core.SeparateChart, com.anychart.core.Chart, com.anychart.core.VisualBaseWithBounds
    public Map right(Number number) {
        APIlib.getInstance().addJSLine(String.format(Locale.US, this.jsBase + ".right(%s);", number));
        return this;
    }

    @Override // com.anychart.core.SeparateChart, com.anychart.core.Chart, com.anychart.core.VisualBaseWithBounds
    public Map right(String str) {
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

    public Geo scale() {
        return new Geo(this.jsBase + ".scale()");
    }

    public Geo scale(Geo geo) {
        return new Geo(String.format(Locale.US, this.jsBase + ".scale(%s)", geo != null ? geo.getJsBase() : null));
    }

    public Geo scale(String str) {
        return new Geo(String.format(Locale.US, this.jsBase + ".scale(%s)", wrapQuotes(str)));
    }

    @Override // com.anychart.core.SeparateChart, com.anychart.core.Chart
    public void selectMarqueeFill() {
        APIlib.getInstance().addJSLine(this.jsBase + ".selectMarqueeFill();");
    }

    @Override // com.anychart.core.SeparateChart, com.anychart.core.Chart
    public Map selectMarqueeFill(Fill fill) {
        APIlib.getInstance().addJSLine(String.format(Locale.US, this.jsBase + ".selectMarqueeFill(%s);", fill != null ? fill.getJsBase() : null));
        return this;
    }

    @Override // com.anychart.core.SeparateChart, com.anychart.core.Chart
    public Map selectMarqueeFill(GradientKey gradientKey) {
        APIlib.getInstance().addJSLine(String.format(Locale.US, this.jsBase + ".selectMarqueeFill(%s);", gradientKey != null ? gradientKey.getJsBase() : null));
        return this;
    }

    @Override // com.anychart.core.SeparateChart, com.anychart.core.Chart
    public Map selectMarqueeFill(String[] strArr) {
        APIlib.getInstance().addJSLine(String.format(Locale.US, this.jsBase + ".selectMarqueeFill(%s);", arrayToStringWrapQuotes(strArr)));
        return this;
    }

    @Override // com.anychart.core.SeparateChart, com.anychart.core.Chart
    public Map selectMarqueeFill(String str, Number number) {
        APIlib.getInstance().addJSLine(String.format(Locale.US, this.jsBase + ".selectMarqueeFill(%s, %s);", wrapQuotes(str), number));
        return this;
    }

    @Override // com.anychart.core.SeparateChart, com.anychart.core.Chart
    public Map selectMarqueeFill(GradientKey gradientKey, Number number, Boolean bool, Number number2) {
        APIlib.getInstance().addJSLine(String.format(Locale.US, this.jsBase + ".selectMarqueeFill(%s, %s, %s, %s);", gradientKey != null ? gradientKey.getJsBase() : null, number, bool, number2));
        return this;
    }

    @Override // com.anychart.core.SeparateChart, com.anychart.core.Chart
    public Map selectMarqueeFill(GradientKey gradientKey, Number number, com.anychart.graphics.vector.Rect rect, Number number2) {
        APIlib.getInstance().addJSLine(String.format(Locale.US, this.jsBase + ".selectMarqueeFill(%s, %s, %s, %s);", gradientKey != null ? gradientKey.getJsBase() : null, number, rect != null ? rect.getJsBase() : null, number2));
        return this;
    }

    @Override // com.anychart.core.SeparateChart, com.anychart.core.Chart
    public Map selectMarqueeFill(GradientKey gradientKey, Number number, String str, Number number2) {
        APIlib.getInstance().addJSLine(String.format(Locale.US, this.jsBase + ".selectMarqueeFill(%s, %s, %s, %s);", gradientKey != null ? gradientKey.getJsBase() : null, number, wrapQuotes(str), number2));
        return this;
    }

    @Override // com.anychart.core.SeparateChart, com.anychart.core.Chart
    public Map selectMarqueeFill(String[] strArr, Number number, Boolean bool, Number number2) {
        APIlib.getInstance().addJSLine(String.format(Locale.US, this.jsBase + ".selectMarqueeFill(%s, %s, %s, %s);", arrayToStringWrapQuotes(strArr), number, bool, number2));
        return this;
    }

    @Override // com.anychart.core.SeparateChart, com.anychart.core.Chart
    public Map selectMarqueeFill(String[] strArr, Number number, com.anychart.graphics.vector.Rect rect, Number number2) {
        APIlib.getInstance().addJSLine(String.format(Locale.US, this.jsBase + ".selectMarqueeFill(%s, %s, %s, %s);", arrayToStringWrapQuotes(strArr), number, rect != null ? rect.getJsBase() : null, number2));
        return this;
    }

    @Override // com.anychart.core.SeparateChart, com.anychart.core.Chart
    public Map selectMarqueeFill(String[] strArr, Number number, String str, Number number2) {
        APIlib.getInstance().addJSLine(String.format(Locale.US, this.jsBase + ".selectMarqueeFill(%s, %s, %s, %s);", arrayToStringWrapQuotes(strArr), number, wrapQuotes(str), number2));
        return this;
    }

    @Override // com.anychart.core.SeparateChart, com.anychart.core.Chart
    public Map selectMarqueeFill(GradientKey gradientKey, Number number, Number number2, com.anychart.graphics.math.Rect rect, Number number3, Number number4, Number number5) {
        APIlib.getInstance().addJSLine(String.format(Locale.US, this.jsBase + ".selectMarqueeFill(%s, %s, %s, %s, %s, %s, %s);", gradientKey != null ? gradientKey.getJsBase() : null, number, number2, rect != null ? rect.getJsBase() : null, number3, number4, number5));
        return this;
    }

    @Override // com.anychart.core.SeparateChart, com.anychart.core.Chart
    public Map selectMarqueeFill(String[] strArr, Number number, Number number2, com.anychart.graphics.math.Rect rect, Number number3, Number number4, Number number5) {
        APIlib.getInstance().addJSLine(String.format(Locale.US, this.jsBase + ".selectMarqueeFill(%s, %s, %s, %s, %s, %s, %s);", arrayToStringWrapQuotes(strArr), number, number2, rect != null ? rect.getJsBase() : null, number3, number4, number5));
        return this;
    }

    @Override // com.anychart.core.SeparateChart, com.anychart.core.Chart
    public void selectMarqueeStroke() {
        APIlib.getInstance().addJSLine(this.jsBase + ".selectMarqueeStroke();");
    }

    @Override // com.anychart.core.SeparateChart, com.anychart.core.Chart
    public Map selectMarqueeStroke(Stroke stroke, Number number, String str, String str2, String str3) {
        APIlib.getInstance().addJSLine(String.format(Locale.US, this.jsBase + ".selectMarqueeStroke(%s, %s, %s, %s, %s);", stroke != null ? stroke.getJsBase() : null, number, wrapQuotes(str), wrapQuotes(str2), wrapQuotes(str3)));
        return this;
    }

    @Override // com.anychart.core.SeparateChart, com.anychart.core.Chart
    public Map selectMarqueeStroke(Stroke stroke, Number number, String str, String str2, StrokeLineCap strokeLineCap) {
        APIlib.getInstance().addJSLine(String.format(Locale.US, this.jsBase + ".selectMarqueeStroke(%s, %s, %s, %s, %s);", stroke != null ? stroke.getJsBase() : null, number, wrapQuotes(str), wrapQuotes(str2), strokeLineCap != null ? strokeLineCap.getJsBase() : null));
        return this;
    }

    @Override // com.anychart.core.SeparateChart, com.anychart.core.Chart
    public Map selectMarqueeStroke(Stroke stroke, Number number, String str, StrokeLineJoin strokeLineJoin, String str2) {
        APIlib.getInstance().addJSLine(String.format(Locale.US, this.jsBase + ".selectMarqueeStroke(%s, %s, %s, %s, %s);", stroke != null ? stroke.getJsBase() : null, number, wrapQuotes(str), strokeLineJoin != null ? strokeLineJoin.getJsBase() : null, wrapQuotes(str2)));
        return this;
    }

    @Override // com.anychart.core.SeparateChart, com.anychart.core.Chart
    public Map selectMarqueeStroke(Stroke stroke, Number number, String str, StrokeLineJoin strokeLineJoin, StrokeLineCap strokeLineCap) {
        APIlib.getInstance().addJSLine(String.format(Locale.US, this.jsBase + ".selectMarqueeStroke(%s, %s, %s, %s, %s);", stroke != null ? stroke.getJsBase() : null, number, wrapQuotes(str), strokeLineJoin != null ? strokeLineJoin.getJsBase() : null, strokeLineCap != null ? strokeLineCap.getJsBase() : null));
        return this;
    }

    @Override // com.anychart.core.SeparateChart, com.anychart.core.Chart
    public Map selectMarqueeStroke(ColoredFill coloredFill, Number number, String str, String str2, String str3) {
        APIlib.getInstance().addJSLine(String.format(Locale.US, this.jsBase + ".selectMarqueeStroke(%s, %s, %s, %s, %s);", coloredFill != null ? coloredFill.getJsBase() : null, number, wrapQuotes(str), wrapQuotes(str2), wrapQuotes(str3)));
        return this;
    }

    @Override // com.anychart.core.SeparateChart, com.anychart.core.Chart
    public Map selectMarqueeStroke(ColoredFill coloredFill, Number number, String str, String str2, StrokeLineCap strokeLineCap) {
        APIlib.getInstance().addJSLine(String.format(Locale.US, this.jsBase + ".selectMarqueeStroke(%s, %s, %s, %s, %s);", coloredFill != null ? coloredFill.getJsBase() : null, number, wrapQuotes(str), wrapQuotes(str2), strokeLineCap != null ? strokeLineCap.getJsBase() : null));
        return this;
    }

    @Override // com.anychart.core.SeparateChart, com.anychart.core.Chart
    public Map selectMarqueeStroke(ColoredFill coloredFill, Number number, String str, StrokeLineJoin strokeLineJoin, String str2) {
        APIlib.getInstance().addJSLine(String.format(Locale.US, this.jsBase + ".selectMarqueeStroke(%s, %s, %s, %s, %s);", coloredFill != null ? coloredFill.getJsBase() : null, number, wrapQuotes(str), strokeLineJoin != null ? strokeLineJoin.getJsBase() : null, wrapQuotes(str2)));
        return this;
    }

    @Override // com.anychart.core.SeparateChart, com.anychart.core.Chart
    public Map selectMarqueeStroke(ColoredFill coloredFill, Number number, String str, StrokeLineJoin strokeLineJoin, StrokeLineCap strokeLineCap) {
        APIlib.getInstance().addJSLine(String.format(Locale.US, this.jsBase + ".selectMarqueeStroke(%s, %s, %s, %s, %s);", coloredFill != null ? coloredFill.getJsBase() : null, number, wrapQuotes(str), strokeLineJoin != null ? strokeLineJoin.getJsBase() : null, strokeLineCap != null ? strokeLineCap.getJsBase() : null));
        return this;
    }

    @Override // com.anychart.core.SeparateChart, com.anychart.core.Chart
    public Map selectMarqueeStroke(String str, Number number, String str2, String str3, String str4) {
        APIlib.getInstance().addJSLine(String.format(Locale.US, this.jsBase + ".selectMarqueeStroke(%s, %s, %s, %s, %s);", wrapQuotes(str), number, wrapQuotes(str2), wrapQuotes(str3), wrapQuotes(str4)));
        return this;
    }

    @Override // com.anychart.core.SeparateChart, com.anychart.core.Chart
    public Map selectMarqueeStroke(String str, Number number, String str2, String str3, StrokeLineCap strokeLineCap) {
        APIlib.getInstance().addJSLine(String.format(Locale.US, this.jsBase + ".selectMarqueeStroke(%s, %s, %s, %s, %s);", wrapQuotes(str), number, wrapQuotes(str2), wrapQuotes(str3), strokeLineCap != null ? strokeLineCap.getJsBase() : null));
        return this;
    }

    @Override // com.anychart.core.SeparateChart, com.anychart.core.Chart
    public Map selectMarqueeStroke(String str, Number number, String str2, StrokeLineJoin strokeLineJoin, String str3) {
        APIlib.getInstance().addJSLine(String.format(Locale.US, this.jsBase + ".selectMarqueeStroke(%s, %s, %s, %s, %s);", wrapQuotes(str), number, wrapQuotes(str2), strokeLineJoin != null ? strokeLineJoin.getJsBase() : null, wrapQuotes(str3)));
        return this;
    }

    @Override // com.anychart.core.SeparateChart, com.anychart.core.Chart
    public Map selectMarqueeStroke(String str, Number number, String str2, StrokeLineJoin strokeLineJoin, StrokeLineCap strokeLineCap) {
        APIlib.getInstance().addJSLine(String.format(Locale.US, this.jsBase + ".selectMarqueeStroke(%s, %s, %s, %s, %s);", wrapQuotes(str), number, wrapQuotes(str2), strokeLineJoin != null ? strokeLineJoin.getJsBase() : null, strokeLineCap != null ? strokeLineCap.getJsBase() : null));
        return this;
    }

    public StateSettings selected() {
        return new StateSettings(this.jsBase + ".selected()");
    }

    public Map selected(String str) {
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
    public Map startSelectMarquee(Boolean bool) {
        APIlib.getInstance().addJSLine(String.format(Locale.US, this.jsBase + ".startSelectMarquee(%s);", bool));
        return this;
    }

    @Override // com.anychart.core.SeparateChart, com.anychart.core.Chart
    public Title title() {
        return new Title(this.jsBase + ".title()");
    }

    @Override // com.anychart.core.SeparateChart, com.anychart.core.Chart
    public Map title(Boolean bool) {
        APIlib.getInstance().addJSLine(String.format(Locale.US, this.jsBase + ".title(%s);", bool));
        return this;
    }

    @Override // com.anychart.core.SeparateChart, com.anychart.core.Chart
    public Map title(String str) {
        APIlib.getInstance().addJSLine(String.format(Locale.US, this.jsBase + ".title(%s);", wrapQuotes(str)));
        return this;
    }

    public void toGeoJSON() {
        APIlib.getInstance().addJSLine(this.jsBase + ".toGeoJSON();");
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
    public Map tooltip(String str) {
        APIlib.getInstance().addJSLine(String.format(Locale.US, this.jsBase + ".tooltip(%s);", wrapQuotes(str)));
        return this;
    }

    @Override // com.anychart.core.SeparateChart, com.anychart.core.Chart
    public Map tooltip(Boolean bool) {
        APIlib.getInstance().addJSLine(String.format(Locale.US, this.jsBase + ".tooltip(%s);", bool));
        return this;
    }

    @Override // com.anychart.core.SeparateChart, com.anychart.core.Chart, com.anychart.core.VisualBaseWithBounds
    public void top() {
        APIlib.getInstance().addJSLine(this.jsBase + ".top();");
    }

    @Override // com.anychart.core.SeparateChart, com.anychart.core.Chart, com.anychart.core.VisualBaseWithBounds
    public Map top(Number number) {
        APIlib.getInstance().addJSLine(String.format(Locale.US, this.jsBase + ".top(%s);", number));
        return this;
    }

    @Override // com.anychart.core.SeparateChart, com.anychart.core.Chart, com.anychart.core.VisualBaseWithBounds
    public Map top(String str) {
        APIlib.getInstance().addJSLine(String.format(Locale.US, this.jsBase + ".top(%s);", wrapQuotes(str)));
        return this;
    }

    public void transform(Number number, Number number2) {
        APIlib.getInstance().addJSLine(String.format(Locale.US, this.jsBase + ".transform(%s, %s);", number, number2));
    }

    public Map translateFeature(String str, Number number, Number number2) {
        APIlib.getInstance().addJSLine(String.format(Locale.US, this.jsBase + ".translateFeature(%s, %s, %s);", wrapQuotes(str), number, number2));
        return this;
    }

    public UnboundRegionsSettings unboundRegions() {
        return new UnboundRegionsSettings(this.jsBase + ".unboundRegions()");
    }

    public Map unboundRegions(String str) {
        APIlib.getInstance().addJSLine(String.format(Locale.US, this.jsBase + ".unboundRegions(%s);", wrapQuotes(str)));
        return this;
    }

    public Map unboundRegions(MapUnboundRegionsMode mapUnboundRegionsMode) {
        APIlib.getInstance().addJSLine(String.format(Locale.US, this.jsBase + ".unboundRegions(%s);", mapUnboundRegionsMode != null ? mapUnboundRegionsMode.getJsBase() : null));
        return this;
    }

    public Map unboundRegions(Boolean bool) {
        APIlib.getInstance().addJSLine(String.format(Locale.US, this.jsBase + ".unboundRegions(%s);", bool));
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
    public Map width(Number number) {
        APIlib.getInstance().addJSLine(String.format(Locale.US, this.jsBase + ".width(%s);", number));
        return this;
    }

    @Override // com.anychart.core.SeparateChart, com.anychart.core.Chart, com.anychart.core.VisualBaseWithBounds
    public Map width(String str) {
        APIlib.getInstance().addJSLine(String.format(Locale.US, this.jsBase + ".width(%s);", wrapQuotes(str)));
        return this;
    }

    @Override // com.anychart.core.SeparateChart, com.anychart.core.Chart, com.anychart.core.VisualBaseWithBounds, com.anychart.core.VisualBase
    public void zIndex() {
        APIlib.getInstance().addJSLine(this.jsBase + ".zIndex();");
    }

    @Override // com.anychart.core.SeparateChart, com.anychart.core.Chart, com.anychart.core.VisualBaseWithBounds, com.anychart.core.VisualBase
    public Map zIndex(Number number) {
        APIlib.getInstance().addJSLine(String.format(Locale.US, this.jsBase + ".zIndex(%s);", number));
        return this;
    }

    public Map zoom(Number number, Number number2, Number number3, Number number4) {
        APIlib.getInstance().addJSLine(String.format(Locale.US, this.jsBase + ".zoom(%s, %s, %s, %s);", number, number2, number3, number4));
        return this;
    }

    public Map zoomTo(Number number, Number number2, Number number3) {
        APIlib.getInstance().addJSLine(String.format(Locale.US, this.jsBase + ".zoomTo(%s, %s, %s);", number, number2, number3));
        return this;
    }

    public void zoomToFeature(String str) {
        APIlib.getInstance().addJSLine(String.format(Locale.US, this.jsBase + ".zoomToFeature(%s);", wrapQuotes(str)));
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
    public Map parentBounds(Rect rect) {
        APIlib.getInstance().addJSLine(String.format(Locale.US, this.jsBase + ".parentBounds(%s);", rect != null ? rect.getJsBase() : null));
        return this;
    }

    @Override // com.anychart.core.SeparateChart, com.anychart.core.Chart, com.anychart.core.VisualBaseWithBounds, com.anychart.core.VisualBase
    public Map parentBounds(String str) {
        APIlib.getInstance().addJSLine(String.format(Locale.US, this.jsBase + ".parentBounds(%s);", wrapQuotes(str)));
        return this;
    }

    @Override // com.anychart.core.SeparateChart, com.anychart.core.Chart, com.anychart.core.VisualBaseWithBounds, com.anychart.core.VisualBase
    public Map parentBounds(Number number) {
        APIlib.getInstance().addJSLine(String.format(Locale.US, this.jsBase + ".parentBounds(%s);", number));
        return this;
    }

    @Override // com.anychart.core.SeparateChart, com.anychart.core.Chart, com.anychart.core.VisualBaseWithBounds, com.anychart.core.VisualBase
    public Map parentBounds(Number number, Number number2, Number number3, Number number4) {
        APIlib.getInstance().addJSLine(String.format(Locale.US, this.jsBase + ".parentBounds(%s, %s, %s, %s);", number, number2, number3, number4));
        return this;
    }

    public Bubble bubble(View view) {
        return new Bubble(String.format(Locale.US, this.jsBase + ".bubble(%s)", view != null ? view.getJsBase() : null));
    }

    public Choropleth choropleth(View view) {
        return new Choropleth(String.format(Locale.US, this.jsBase + ".choropleth(%s)", view != null ? view.getJsBase() : null));
    }

    public Connector connector(View view) {
        return new Connector(String.format(Locale.US, this.jsBase + ".connector(%s)", view != null ? view.getJsBase() : null));
    }

    public Marker marker(View view) {
        return new Marker(String.format(Locale.US, this.jsBase + ".marker(%s)", view != null ? view.getJsBase() : null));
    }

    @Override // com.anychart.core.SeparateChart
    public Map interactivity(HoverMode hoverMode) {
        APIlib.getInstance().addJSLine(String.format(Locale.US, this.jsBase + ".interactivity(%s);", hoverMode != null ? hoverMode.getJsBase() : null));
        return this;
    }

    @Override // com.anychart.core.SeparateChart
    public MapInteractivity interactivity() {
        return new MapInteractivity(this.jsBase + ".interactivity()");
    }
}
