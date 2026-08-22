package com.anychart.charts;

import com.amazonaws.services.s3.model.InstructionFileId;
import com.anychart.APIlib;
import com.anychart.chart.common.dataentry.DataEntry;
import com.anychart.chart.common.listener.ListenersInterface;
import com.anychart.core.Chart;
import com.anychart.core.NoDataSettings;
import com.anychart.core.axismarkers.Line;
import com.anychart.core.axismarkers.Range;
import com.anychart.core.axismarkers.Text;
import com.anychart.core.ui.Background;
import com.anychart.core.ui.ChartCredits;
import com.anychart.core.ui.Title;
import com.anychart.core.ui.Tooltip;
import com.anychart.core.ui.labelsfactory.Label;
import com.anychart.core.ui.markersfactory.Marker;
import com.anychart.core.utils.Animation;
import com.anychart.core.utils.Bounds;
import com.anychart.core.utils.ChartA11y;
import com.anychart.core.utils.Exports;
import com.anychart.core.utils.Margin;
import com.anychart.core.utils.Padding;
import com.anychart.data.View;
import com.anychart.enums.ChartDataExportMode;
import com.anychart.enums.ScaleTypes;
import com.anychart.enums.SparklineSeriesType;
import com.anychart.enums.Statistics;
import com.anychart.enums.TreeFillingMethod;
import com.anychart.graphics.vector.ColoredFill;
import com.anychart.graphics.vector.Fill;
import com.anychart.graphics.vector.GradientKey;
import com.anychart.graphics.vector.HatchFill;
import com.anychart.graphics.vector.Layer;
import com.anychart.graphics.vector.PaperSize;
import com.anychart.graphics.vector.PatternFill;
import com.anychart.graphics.vector.Stage;
import com.anychart.graphics.vector.Stroke;
import com.anychart.graphics.vector.StrokeLineCap;
import com.anychart.graphics.vector.StrokeLineJoin;
import com.anychart.graphics.vector.hatchfill.HatchFillType;
import com.anychart.math.Rect;
import com.anychart.scales.Base;
import com.anychart.scales.Ordinal;
import com.anychart.ui.ContextMenu;
import com.anychart.utils.RectObj;
import java.lang.reflect.InvocationTargetException;
import java.util.Arrays;
import java.util.List;
import java.util.Locale;

/* JADX INFO: loaded from: classes4.dex */
public class Sparkline extends Chart {
    protected Sparkline() {
    }

    public static Sparkline instantiate() {
        return new Sparkline("new anychart.charts.sparkline()");
    }

    public Sparkline(String str) {
        StringBuilder sb = new StringBuilder("sparkline");
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
    public Sparkline a11y(Boolean bool) {
        APIlib.getInstance().addJSLine(String.format(Locale.US, this.jsBase + ".a11y(%s);", bool));
        return this;
    }

    @Override // com.anychart.core.Chart
    public Sparkline a11y(String str) {
        APIlib.getInstance().addJSLine(String.format(Locale.US, this.jsBase + ".a11y(%s);", wrapQuotes(str)));
        return this;
    }

    @Override // com.anychart.core.Chart
    public Animation animation() {
        return new Animation(this.jsBase + ".animation()");
    }

    @Override // com.anychart.core.Chart
    public Sparkline animation(Boolean bool) {
        APIlib.getInstance().addJSLine(String.format(Locale.US, this.jsBase + ".animation(%s);", bool));
        return this;
    }

    @Override // com.anychart.core.Chart
    public Sparkline animation(String str) {
        APIlib.getInstance().addJSLine(String.format(Locale.US, this.jsBase + ".animation(%s);", wrapQuotes(str)));
        return this;
    }

    @Override // com.anychart.core.Chart
    public Sparkline animation(Boolean bool, Number number) {
        APIlib.getInstance().addJSLine(String.format(Locale.US, this.jsBase + ".animation(%s, %s);", bool, number));
        return this;
    }

    @Override // com.anychart.core.Chart
    public void autoRedraw() {
        APIlib.getInstance().addJSLine(this.jsBase + ".autoRedraw();");
    }

    @Override // com.anychart.core.Chart
    public Sparkline autoRedraw(Boolean bool) {
        APIlib.getInstance().addJSLine(String.format(Locale.US, this.jsBase + ".autoRedraw(%s);", bool));
        return this;
    }

    @Override // com.anychart.core.Chart
    public Background background() {
        return new Background(this.jsBase + ".background()");
    }

    @Override // com.anychart.core.Chart
    public Sparkline background(String str) {
        APIlib.getInstance().addJSLine(String.format(Locale.US, this.jsBase + ".background(%s);", wrapQuotes(str)));
        return this;
    }

    @Override // com.anychart.core.Chart, com.anychart.core.VisualBaseWithBounds
    public void bottom() {
        APIlib.getInstance().addJSLine(this.jsBase + ".bottom();");
    }

    @Override // com.anychart.core.Chart, com.anychart.core.VisualBaseWithBounds
    public Sparkline bottom(Number number) {
        APIlib.getInstance().addJSLine(String.format(Locale.US, this.jsBase + ".bottom(%s);", number));
        return this;
    }

    @Override // com.anychart.core.Chart, com.anychart.core.VisualBaseWithBounds
    public Sparkline bottom(String str) {
        APIlib.getInstance().addJSLine(String.format(Locale.US, this.jsBase + ".bottom(%s);", wrapQuotes(str)));
        return this;
    }

    @Override // com.anychart.core.Chart, com.anychart.core.VisualBaseWithBounds
    public Bounds bounds() {
        return new Bounds(this.jsBase + ".bounds()");
    }

    @Override // com.anychart.core.Chart, com.anychart.core.VisualBaseWithBounds
    public Sparkline bounds(RectObj rectObj) {
        APIlib.getInstance().addJSLine(String.format(Locale.US, this.jsBase + ".bounds(%s);", rectObj != null ? rectObj.getJsBase() : null));
        return this;
    }

    @Override // com.anychart.core.Chart, com.anychart.core.VisualBaseWithBounds
    public Sparkline bounds(Rect rect) {
        APIlib.getInstance().addJSLine(String.format(Locale.US, this.jsBase + ".bounds(%s);", rect != null ? rect.getJsBase() : null));
        return this;
    }

    @Override // com.anychart.core.Chart, com.anychart.core.VisualBaseWithBounds
    public Sparkline bounds(Bounds bounds) {
        APIlib.getInstance().addJSLine(String.format(Locale.US, this.jsBase + ".bounds(%s);", bounds != null ? bounds.getJsBase() : null));
        return this;
    }

    @Override // com.anychart.core.Chart, com.anychart.core.VisualBaseWithBounds
    public Sparkline bounds(Number number, Number number2, Number number3, Number number4) {
        APIlib.getInstance().addJSLine(String.format(Locale.US, this.jsBase + ".bounds(%s, %s, %s, %s);", number, number2, number3, number4));
        return this;
    }

    @Override // com.anychart.core.Chart, com.anychart.core.VisualBaseWithBounds
    public Sparkline bounds(Number number, Number number2, Number number3, String str) {
        APIlib.getInstance().addJSLine(String.format(Locale.US, this.jsBase + ".bounds(%s, %s, %s, %s);", number, number2, number3, wrapQuotes(str)));
        return this;
    }

    @Override // com.anychart.core.Chart, com.anychart.core.VisualBaseWithBounds
    public Sparkline bounds(Number number, Number number2, String str, Number number3) {
        APIlib.getInstance().addJSLine(String.format(Locale.US, this.jsBase + ".bounds(%s, %s, %s, %s);", number, number2, wrapQuotes(str), number3));
        return this;
    }

    @Override // com.anychart.core.Chart, com.anychart.core.VisualBaseWithBounds
    public Sparkline bounds(Number number, Number number2, String str, String str2) {
        APIlib.getInstance().addJSLine(String.format(Locale.US, this.jsBase + ".bounds(%s, %s, %s, %s);", number, number2, wrapQuotes(str), wrapQuotes(str2)));
        return this;
    }

    @Override // com.anychart.core.Chart, com.anychart.core.VisualBaseWithBounds
    public Sparkline bounds(Number number, String str, Number number2, Number number3) {
        APIlib.getInstance().addJSLine(String.format(Locale.US, this.jsBase + ".bounds(%s, %s, %s, %s);", number, wrapQuotes(str), number2, number3));
        return this;
    }

    @Override // com.anychart.core.Chart, com.anychart.core.VisualBaseWithBounds
    public Sparkline bounds(Number number, String str, Number number2, String str2) {
        APIlib.getInstance().addJSLine(String.format(Locale.US, this.jsBase + ".bounds(%s, %s, %s, %s);", number, wrapQuotes(str), number2, wrapQuotes(str2)));
        return this;
    }

    @Override // com.anychart.core.Chart, com.anychart.core.VisualBaseWithBounds
    public Sparkline bounds(Number number, String str, String str2, Number number2) {
        APIlib.getInstance().addJSLine(String.format(Locale.US, this.jsBase + ".bounds(%s, %s, %s, %s);", number, wrapQuotes(str), wrapQuotes(str2), number2));
        return this;
    }

    @Override // com.anychart.core.Chart, com.anychart.core.VisualBaseWithBounds
    public Sparkline bounds(Number number, String str, String str2, String str3) {
        APIlib.getInstance().addJSLine(String.format(Locale.US, this.jsBase + ".bounds(%s, %s, %s, %s);", number, wrapQuotes(str), wrapQuotes(str2), wrapQuotes(str3)));
        return this;
    }

    @Override // com.anychart.core.Chart, com.anychart.core.VisualBaseWithBounds
    public Sparkline bounds(String str, Number number, Number number2, Number number3) {
        APIlib.getInstance().addJSLine(String.format(Locale.US, this.jsBase + ".bounds(%s, %s, %s, %s);", wrapQuotes(str), number, number2, number3));
        return this;
    }

    @Override // com.anychart.core.Chart, com.anychart.core.VisualBaseWithBounds
    public Sparkline bounds(String str, Number number, Number number2, String str2) {
        APIlib.getInstance().addJSLine(String.format(Locale.US, this.jsBase + ".bounds(%s, %s, %s, %s);", wrapQuotes(str), number, number2, wrapQuotes(str2)));
        return this;
    }

    @Override // com.anychart.core.Chart, com.anychart.core.VisualBaseWithBounds
    public Sparkline bounds(String str, Number number, String str2, Number number2) {
        APIlib.getInstance().addJSLine(String.format(Locale.US, this.jsBase + ".bounds(%s, %s, %s, %s);", wrapQuotes(str), number, wrapQuotes(str2), number2));
        return this;
    }

    @Override // com.anychart.core.Chart, com.anychart.core.VisualBaseWithBounds
    public Sparkline bounds(String str, Number number, String str2, String str3) {
        APIlib.getInstance().addJSLine(String.format(Locale.US, this.jsBase + ".bounds(%s, %s, %s, %s);", wrapQuotes(str), number, wrapQuotes(str2), wrapQuotes(str3)));
        return this;
    }

    @Override // com.anychart.core.Chart, com.anychart.core.VisualBaseWithBounds
    public Sparkline bounds(String str, String str2, Number number, Number number2) {
        APIlib.getInstance().addJSLine(String.format(Locale.US, this.jsBase + ".bounds(%s, %s, %s, %s);", wrapQuotes(str), wrapQuotes(str2), number, number2));
        return this;
    }

    @Override // com.anychart.core.Chart, com.anychart.core.VisualBaseWithBounds
    public Sparkline bounds(String str, String str2, Number number, String str3) {
        APIlib.getInstance().addJSLine(String.format(Locale.US, this.jsBase + ".bounds(%s, %s, %s, %s);", wrapQuotes(str), wrapQuotes(str2), number, wrapQuotes(str3)));
        return this;
    }

    @Override // com.anychart.core.Chart, com.anychart.core.VisualBaseWithBounds
    public Sparkline bounds(String str, String str2, String str3, Number number) {
        APIlib.getInstance().addJSLine(String.format(Locale.US, this.jsBase + ".bounds(%s, %s, %s, %s);", wrapQuotes(str), wrapQuotes(str2), wrapQuotes(str3), number));
        return this;
    }

    @Override // com.anychart.core.Chart, com.anychart.core.VisualBaseWithBounds
    public Sparkline bounds(String str, String str2, String str3, String str4) {
        APIlib.getInstance().addJSLine(String.format(Locale.US, this.jsBase + ".bounds(%s, %s, %s, %s);", wrapQuotes(str), wrapQuotes(str2), wrapQuotes(str3), wrapQuotes(str4)));
        return this;
    }

    @Override // com.anychart.core.Chart
    public Sparkline cancelMarquee() {
        APIlib.getInstance().addJSLine(this.jsBase + ".cancelMarquee();");
        return this;
    }

    public void clip() {
        APIlib.getInstance().addJSLine(this.jsBase + ".clip();");
    }

    public Sparkline clip(Rect rect) {
        APIlib.getInstance().addJSLine(String.format(Locale.US, this.jsBase + ".clip(%s);", rect != null ? rect.getJsBase() : null));
        return this;
    }

    public void connectMissingPoints() {
        APIlib.getInstance().addJSLine(this.jsBase + ".connectMissingPoints();");
    }

    public Sparkline connectMissingPoints(Boolean bool) {
        APIlib.getInstance().addJSLine(String.format(Locale.US, this.jsBase + ".connectMissingPoints(%s);", bool));
        return this;
    }

    @Override // com.anychart.core.Chart, com.anychart.core.VisualBaseWithBounds, com.anychart.core.VisualBase
    public Layer container() {
        return new Layer(this.jsBase + ".container()");
    }

    @Override // com.anychart.core.Chart, com.anychart.core.VisualBaseWithBounds, com.anychart.core.VisualBase
    public Sparkline container(Layer layer) {
        APIlib.getInstance().addJSLine(String.format(Locale.US, this.jsBase + ".container(%s);", layer != null ? layer.getJsBase() : null));
        return this;
    }

    @Override // com.anychart.core.Chart, com.anychart.core.VisualBaseWithBounds, com.anychart.core.VisualBase
    public Sparkline container(Stage stage) {
        APIlib.getInstance().addJSLine(String.format(Locale.US, this.jsBase + ".container(%s);", stage != null ? stage.getJsBase() : null));
        return this;
    }

    @Override // com.anychart.core.Chart, com.anychart.core.VisualBaseWithBounds, com.anychart.core.VisualBase
    public Sparkline container(String str) {
        APIlib.getInstance().addJSLine(String.format(Locale.US, this.jsBase + ".container(%s);", wrapQuotes(str)));
        return this;
    }

    @Override // com.anychart.core.Chart
    public ContextMenu contextMenu() {
        return new ContextMenu(this.jsBase + ".contextMenu()");
    }

    @Override // com.anychart.core.Chart
    public Sparkline contextMenu(String str) {
        APIlib.getInstance().addJSLine(String.format(Locale.US, this.jsBase + ".contextMenu(%s);", wrapQuotes(str)));
        return this;
    }

    @Override // com.anychart.core.Chart
    public Sparkline contextMenu(Boolean bool) {
        APIlib.getInstance().addJSLine(String.format(Locale.US, this.jsBase + ".contextMenu(%s);", bool));
        return this;
    }

    @Override // com.anychart.core.Chart
    public ChartCredits credits() {
        return new ChartCredits(this.jsBase + ".credits()");
    }

    @Override // com.anychart.core.Chart
    public Sparkline credits(String str) {
        APIlib.getInstance().addJSLine(String.format(Locale.US, this.jsBase + ".credits(%s);", wrapQuotes(str)));
        return this;
    }

    @Override // com.anychart.core.Chart
    public Sparkline credits(Boolean bool) {
        APIlib.getInstance().addJSLine(String.format(Locale.US, this.jsBase + ".credits(%s);", bool));
        return this;
    }

    public View data(List<DataEntry> list) {
        return new View(String.format(Locale.US, this.jsBase + ".data(%s)", arrayToString(list)));
    }

    @Override // com.anychart.core.Chart
    public void dispose() {
        APIlib.getInstance().addJSLine(this.jsBase + ".dispose();");
    }

    @Override // com.anychart.core.Chart
    public Sparkline draw(Boolean bool) {
        APIlib.getInstance().addJSLine(String.format(Locale.US, this.jsBase + ".draw(%s);", bool));
        return this;
    }

    @Override // com.anychart.core.Chart, com.anychart.core.VisualBaseWithBounds, com.anychart.core.VisualBase
    public void enabled() {
        APIlib.getInstance().addJSLine(this.jsBase + ".enabled();");
    }

    @Override // com.anychart.core.Chart, com.anychart.core.VisualBaseWithBounds, com.anychart.core.VisualBase
    public Sparkline enabled(Boolean bool) {
        APIlib.getInstance().addJSLine(String.format(Locale.US, this.jsBase + ".enabled(%s);", bool));
        return this;
    }

    @Override // com.anychart.core.Chart
    public Exports exports() {
        return new Exports(this.jsBase + ".exports()");
    }

    @Override // com.anychart.core.Chart
    public Sparkline exports(String str) {
        APIlib.getInstance().addJSLine(String.format(Locale.US, this.jsBase + ".exports(%s);", wrapQuotes(str)));
        return this;
    }

    public void fill() {
        APIlib.getInstance().addJSLine(this.jsBase + ".fill();");
    }

    public Sparkline fill(Fill fill) {
        APIlib.getInstance().addJSLine(String.format(Locale.US, this.jsBase + ".fill(%s);", fill != null ? fill.getJsBase() : null));
        return this;
    }

    public Sparkline fill(GradientKey gradientKey) {
        APIlib.getInstance().addJSLine(String.format(Locale.US, this.jsBase + ".fill(%s);", gradientKey != null ? gradientKey.getJsBase() : null));
        return this;
    }

    public Sparkline fill(String[] strArr) {
        APIlib.getInstance().addJSLine(String.format(Locale.US, this.jsBase + ".fill(%s);", arrayToStringWrapQuotes(strArr)));
        return this;
    }

    public Sparkline fill(String str, Number number) {
        APIlib.getInstance().addJSLine(String.format(Locale.US, this.jsBase + ".fill(%s, %s);", wrapQuotes(str), number));
        return this;
    }

    public Sparkline fill(GradientKey gradientKey, Number number, Boolean bool, Number number2) {
        APIlib.getInstance().addJSLine(String.format(Locale.US, this.jsBase + ".fill(%s, %s, %s, %s);", gradientKey != null ? gradientKey.getJsBase() : null, number, bool, number2));
        return this;
    }

    public Sparkline fill(GradientKey gradientKey, Number number, com.anychart.graphics.vector.Rect rect, Number number2) {
        APIlib.getInstance().addJSLine(String.format(Locale.US, this.jsBase + ".fill(%s, %s, %s, %s);", gradientKey != null ? gradientKey.getJsBase() : null, number, rect != null ? rect.getJsBase() : null, number2));
        return this;
    }

    public Sparkline fill(GradientKey gradientKey, Number number, String str, Number number2) {
        APIlib.getInstance().addJSLine(String.format(Locale.US, this.jsBase + ".fill(%s, %s, %s, %s);", gradientKey != null ? gradientKey.getJsBase() : null, number, wrapQuotes(str), number2));
        return this;
    }

    public Sparkline fill(String[] strArr, Number number, Boolean bool, Number number2) {
        APIlib.getInstance().addJSLine(String.format(Locale.US, this.jsBase + ".fill(%s, %s, %s, %s);", arrayToStringWrapQuotes(strArr), number, bool, number2));
        return this;
    }

    public Sparkline fill(String[] strArr, Number number, com.anychart.graphics.vector.Rect rect, Number number2) {
        APIlib.getInstance().addJSLine(String.format(Locale.US, this.jsBase + ".fill(%s, %s, %s, %s);", arrayToStringWrapQuotes(strArr), number, rect != null ? rect.getJsBase() : null, number2));
        return this;
    }

    public Sparkline fill(String[] strArr, Number number, String str, Number number2) {
        APIlib.getInstance().addJSLine(String.format(Locale.US, this.jsBase + ".fill(%s, %s, %s, %s);", arrayToStringWrapQuotes(strArr), number, wrapQuotes(str), number2));
        return this;
    }

    public Sparkline fill(GradientKey gradientKey, Number number, Number number2, com.anychart.graphics.math.Rect rect, Number number3, Number number4, Number number5) {
        APIlib.getInstance().addJSLine(String.format(Locale.US, this.jsBase + ".fill(%s, %s, %s, %s, %s, %s, %s);", gradientKey != null ? gradientKey.getJsBase() : null, number, number2, rect != null ? rect.getJsBase() : null, number3, number4, number5));
        return this;
    }

    public Sparkline fill(String[] strArr, Number number, Number number2, com.anychart.graphics.math.Rect rect, Number number3, Number number4, Number number5) {
        APIlib.getInstance().addJSLine(String.format(Locale.US, this.jsBase + ".fill(%s, %s, %s, %s, %s, %s, %s);", arrayToStringWrapQuotes(strArr), number, number2, rect != null ? rect.getJsBase() : null, number3, number4, number5));
        return this;
    }

    public void firstFill() {
        APIlib.getInstance().addJSLine(this.jsBase + ".firstFill();");
    }

    public Sparkline firstFill(Fill fill) {
        APIlib.getInstance().addJSLine(String.format(Locale.US, this.jsBase + ".firstFill(%s);", fill != null ? fill.getJsBase() : null));
        return this;
    }

    public Sparkline firstFill(GradientKey gradientKey) {
        APIlib.getInstance().addJSLine(String.format(Locale.US, this.jsBase + ".firstFill(%s);", gradientKey != null ? gradientKey.getJsBase() : null));
        return this;
    }

    public Sparkline firstFill(String[] strArr) {
        APIlib.getInstance().addJSLine(String.format(Locale.US, this.jsBase + ".firstFill(%s);", arrayToStringWrapQuotes(strArr)));
        return this;
    }

    public Sparkline firstFill(String str, Number number) {
        APIlib.getInstance().addJSLine(String.format(Locale.US, this.jsBase + ".firstFill(%s, %s);", wrapQuotes(str), number));
        return this;
    }

    public Sparkline firstFill(GradientKey gradientKey, Number number, Boolean bool, Number number2) {
        APIlib.getInstance().addJSLine(String.format(Locale.US, this.jsBase + ".firstFill(%s, %s, %s, %s);", gradientKey != null ? gradientKey.getJsBase() : null, number, bool, number2));
        return this;
    }

    public Sparkline firstFill(GradientKey gradientKey, Number number, com.anychart.graphics.vector.Rect rect, Number number2) {
        APIlib.getInstance().addJSLine(String.format(Locale.US, this.jsBase + ".firstFill(%s, %s, %s, %s);", gradientKey != null ? gradientKey.getJsBase() : null, number, rect != null ? rect.getJsBase() : null, number2));
        return this;
    }

    public Sparkline firstFill(GradientKey gradientKey, Number number, String str, Number number2) {
        APIlib.getInstance().addJSLine(String.format(Locale.US, this.jsBase + ".firstFill(%s, %s, %s, %s);", gradientKey != null ? gradientKey.getJsBase() : null, number, wrapQuotes(str), number2));
        return this;
    }

    public Sparkline firstFill(String[] strArr, Number number, Boolean bool, Number number2) {
        APIlib.getInstance().addJSLine(String.format(Locale.US, this.jsBase + ".firstFill(%s, %s, %s, %s);", arrayToStringWrapQuotes(strArr), number, bool, number2));
        return this;
    }

    public Sparkline firstFill(String[] strArr, Number number, com.anychart.graphics.vector.Rect rect, Number number2) {
        APIlib.getInstance().addJSLine(String.format(Locale.US, this.jsBase + ".firstFill(%s, %s, %s, %s);", arrayToStringWrapQuotes(strArr), number, rect != null ? rect.getJsBase() : null, number2));
        return this;
    }

    public Sparkline firstFill(String[] strArr, Number number, String str, Number number2) {
        APIlib.getInstance().addJSLine(String.format(Locale.US, this.jsBase + ".firstFill(%s, %s, %s, %s);", arrayToStringWrapQuotes(strArr), number, wrapQuotes(str), number2));
        return this;
    }

    public Sparkline firstFill(GradientKey gradientKey, Number number, Number number2, com.anychart.graphics.math.Rect rect, Number number3, Number number4, Number number5) {
        APIlib.getInstance().addJSLine(String.format(Locale.US, this.jsBase + ".firstFill(%s, %s, %s, %s, %s, %s, %s);", gradientKey != null ? gradientKey.getJsBase() : null, number, number2, rect != null ? rect.getJsBase() : null, number3, number4, number5));
        return this;
    }

    public Sparkline firstFill(String[] strArr, Number number, Number number2, com.anychart.graphics.math.Rect rect, Number number3, Number number4, Number number5) {
        APIlib.getInstance().addJSLine(String.format(Locale.US, this.jsBase + ".firstFill(%s, %s, %s, %s, %s, %s, %s);", arrayToStringWrapQuotes(strArr), number, number2, rect != null ? rect.getJsBase() : null, number3, number4, number5));
        return this;
    }

    public PatternFill firstHatchFill() {
        return new PatternFill(this.jsBase + ".firstHatchFill()");
    }

    public Sparkline firstHatchFill(HatchFillType hatchFillType, String str, Number number, Number number2) {
        APIlib.getInstance().addJSLine(String.format(Locale.US, this.jsBase + ".firstHatchFill(%s, %s, %s, %s);", hatchFillType != null ? hatchFillType.getJsBase() : null, wrapQuotes(str), number, number2));
        return this;
    }

    public Sparkline firstHatchFill(String str, String str2, Number number, Number number2) {
        APIlib.getInstance().addJSLine(String.format(Locale.US, this.jsBase + ".firstHatchFill(%s, %s, %s, %s);", wrapQuotes(str), wrapQuotes(str2), number, number2));
        return this;
    }

    public Sparkline firstHatchFill(String str) {
        APIlib.getInstance().addJSLine(String.format(Locale.US, this.jsBase + ".firstHatchFill(%s);", wrapQuotes(str)));
        return this;
    }

    public Sparkline firstHatchFill(PatternFill patternFill) {
        APIlib.getInstance().addJSLine(String.format(Locale.US, this.jsBase + ".firstHatchFill(%s);", patternFill != null ? patternFill.getJsBase() : null));
        return this;
    }

    public Sparkline firstHatchFill(HatchFill hatchFill) {
        APIlib.getInstance().addJSLine(String.format(Locale.US, this.jsBase + ".firstHatchFill(%s);", hatchFill != null ? hatchFill.getJsBase() : null));
        return this;
    }

    public Sparkline firstHatchFill(Boolean bool) {
        APIlib.getInstance().addJSLine(String.format(Locale.US, this.jsBase + ".firstHatchFill(%s);", bool));
        return this;
    }

    public Label firstLabels() {
        return new Label(this.jsBase + ".firstLabels()");
    }

    public Sparkline firstLabels(String str) {
        APIlib.getInstance().addJSLine(String.format(Locale.US, this.jsBase + ".firstLabels(%s);", wrapQuotes(str)));
        return this;
    }

    public Sparkline firstLabels(Boolean bool) {
        APIlib.getInstance().addJSLine(String.format(Locale.US, this.jsBase + ".firstLabels(%s);", bool));
        return this;
    }

    public Marker firstMarkers() {
        return new Marker(this.jsBase + ".firstMarkers()");
    }

    public Sparkline firstMarkers(String str) {
        APIlib.getInstance().addJSLine(String.format(Locale.US, this.jsBase + ".firstMarkers(%s);", wrapQuotes(str)));
        return this;
    }

    public Sparkline firstMarkers(Boolean bool) {
        APIlib.getInstance().addJSLine(String.format(Locale.US, this.jsBase + ".firstMarkers(%s);", bool));
        return this;
    }

    @Override // com.anychart.core.Chart
    public void fullScreen() {
        APIlib.getInstance().addJSLine(this.jsBase + ".fullScreen();");
    }

    @Override // com.anychart.core.Chart
    public Sparkline fullScreen(Boolean bool) {
        APIlib.getInstance().addJSLine(String.format(Locale.US, this.jsBase + ".fullScreen(%s);", bool));
        return this;
    }

    @Override // com.anychart.core.Chart, com.anychart.core.VisualBaseWithBounds
    public Rect getPixelBounds() {
        return new Rect(this.jsBase + ".getPixelBounds()");
    }

    @Override // com.anychart.core.Chart
    public void getSelectedPoints() {
        APIlib.getInstance().addJSLine(this.jsBase + ".getSelectedPoints();");
    }

    @Override // com.anychart.core.Chart
    public void getStat(Statistics statistics) {
        APIlib.getInstance().addJSLine(String.format(Locale.US, this.jsBase + ".getStat(%s);", statistics != null ? statistics.getJsBase() : null));
    }

    @Override // com.anychart.core.Chart
    public void getStat(String str) {
        APIlib.getInstance().addJSLine(String.format(Locale.US, this.jsBase + ".getStat(%s);", wrapQuotes(str)));
    }

    public void getType() {
        APIlib.getInstance().addJSLine(this.jsBase + ".getType();");
    }

    @Override // com.anychart.core.Chart
    public void globalToLocal(Number number, Number number2) {
        APIlib.getInstance().addJSLine(String.format(Locale.US, this.jsBase + ".globalToLocal(%s, %s);", number, number2));
    }

    public PatternFill hatchFill() {
        return new PatternFill(this.jsBase + ".hatchFill()");
    }

    public Sparkline hatchFill(HatchFillType hatchFillType, String str, Number number, Number number2) {
        APIlib.getInstance().addJSLine(String.format(Locale.US, this.jsBase + ".hatchFill(%s, %s, %s, %s);", hatchFillType != null ? hatchFillType.getJsBase() : null, wrapQuotes(str), number, number2));
        return this;
    }

    public Sparkline hatchFill(String str, String str2, Number number, Number number2) {
        APIlib.getInstance().addJSLine(String.format(Locale.US, this.jsBase + ".hatchFill(%s, %s, %s, %s);", wrapQuotes(str), wrapQuotes(str2), number, number2));
        return this;
    }

    public Sparkline hatchFill(String str) {
        APIlib.getInstance().addJSLine(String.format(Locale.US, this.jsBase + ".hatchFill(%s);", wrapQuotes(str)));
        return this;
    }

    public Sparkline hatchFill(PatternFill patternFill) {
        APIlib.getInstance().addJSLine(String.format(Locale.US, this.jsBase + ".hatchFill(%s);", patternFill != null ? patternFill.getJsBase() : null));
        return this;
    }

    public Sparkline hatchFill(HatchFill hatchFill) {
        APIlib.getInstance().addJSLine(String.format(Locale.US, this.jsBase + ".hatchFill(%s);", hatchFill != null ? hatchFill.getJsBase() : null));
        return this;
    }

    public Sparkline hatchFill(Boolean bool) {
        APIlib.getInstance().addJSLine(String.format(Locale.US, this.jsBase + ".hatchFill(%s);", bool));
        return this;
    }

    @Override // com.anychart.core.Chart, com.anychart.core.VisualBaseWithBounds
    public void height() {
        APIlib.getInstance().addJSLine(this.jsBase + ".height();");
    }

    @Override // com.anychart.core.Chart, com.anychart.core.VisualBaseWithBounds
    public Sparkline height(Number number) {
        APIlib.getInstance().addJSLine(String.format(Locale.US, this.jsBase + ".height(%s);", number));
        return this;
    }

    @Override // com.anychart.core.Chart, com.anychart.core.VisualBaseWithBounds
    public Sparkline height(String str) {
        APIlib.getInstance().addJSLine(String.format(Locale.US, this.jsBase + ".height(%s);", wrapQuotes(str)));
        return this;
    }

    @Override // com.anychart.core.Chart
    public void id() {
        APIlib.getInstance().addJSLine(this.jsBase + ".id();");
    }

    @Override // com.anychart.core.Chart
    public Sparkline id(String str) {
        APIlib.getInstance().addJSLine(String.format(Locale.US, this.jsBase + ".id(%s);", wrapQuotes(str)));
        return this;
    }

    @Override // com.anychart.core.Chart
    public void inMarquee() {
        APIlib.getInstance().addJSLine(this.jsBase + ".inMarquee();");
    }

    @Override // com.anychart.core.Chart
    public void isFullScreenAvailable() {
        APIlib.getInstance().addJSLine(this.jsBase + ".isFullScreenAvailable();");
    }

    @Override // com.anychart.core.Chart
    public com.anychart.core.ui.Label label(String str) {
        return new com.anychart.core.ui.Label(String.format(Locale.US, this.jsBase + ".label(%s)", wrapQuotes(str)));
    }

    @Override // com.anychart.core.Chart
    public com.anychart.core.ui.Label label(Number number) {
        return new com.anychart.core.ui.Label(String.format(Locale.US, this.jsBase + ".label(%s)", number));
    }

    @Override // com.anychart.core.Chart
    public Sparkline label(Boolean bool) {
        APIlib.getInstance().addJSLine(String.format(Locale.US, this.jsBase + ".label(%s);", bool));
        return this;
    }

    @Override // com.anychart.core.Chart
    public Sparkline label(String str, Boolean bool) {
        APIlib.getInstance().addJSLine(String.format(Locale.US, this.jsBase + ".label(%s, %s);", wrapQuotes(str), bool));
        return this;
    }

    @Override // com.anychart.core.Chart
    public Sparkline label(String str, String str2) {
        APIlib.getInstance().addJSLine(String.format(Locale.US, this.jsBase + ".label(%s, %s);", wrapQuotes(str), wrapQuotes(str2)));
        return this;
    }

    @Override // com.anychart.core.Chart
    public Sparkline label(Number number, Boolean bool) {
        APIlib.getInstance().addJSLine(String.format(Locale.US, this.jsBase + ".label(%s, %s);", number, bool));
        return this;
    }

    @Override // com.anychart.core.Chart
    public Sparkline label(Number number, String str) {
        APIlib.getInstance().addJSLine(String.format(Locale.US, this.jsBase + ".label(%s, %s);", number, wrapQuotes(str)));
        return this;
    }

    public Label labels() {
        return new Label(this.jsBase + ".labels()");
    }

    public Sparkline labels(String str) {
        APIlib.getInstance().addJSLine(String.format(Locale.US, this.jsBase + ".labels(%s);", wrapQuotes(str)));
        return this;
    }

    public Sparkline labels(Boolean bool) {
        APIlib.getInstance().addJSLine(String.format(Locale.US, this.jsBase + ".labels(%s);", bool));
        return this;
    }

    public void lastFill() {
        APIlib.getInstance().addJSLine(this.jsBase + ".lastFill();");
    }

    public Sparkline lastFill(Fill fill) {
        APIlib.getInstance().addJSLine(String.format(Locale.US, this.jsBase + ".lastFill(%s);", fill != null ? fill.getJsBase() : null));
        return this;
    }

    public Sparkline lastFill(GradientKey gradientKey) {
        APIlib.getInstance().addJSLine(String.format(Locale.US, this.jsBase + ".lastFill(%s);", gradientKey != null ? gradientKey.getJsBase() : null));
        return this;
    }

    public Sparkline lastFill(String[] strArr) {
        APIlib.getInstance().addJSLine(String.format(Locale.US, this.jsBase + ".lastFill(%s);", arrayToStringWrapQuotes(strArr)));
        return this;
    }

    public Sparkline lastFill(String str, Number number) {
        APIlib.getInstance().addJSLine(String.format(Locale.US, this.jsBase + ".lastFill(%s, %s);", wrapQuotes(str), number));
        return this;
    }

    public Sparkline lastFill(GradientKey gradientKey, Number number, Boolean bool, Number number2) {
        APIlib.getInstance().addJSLine(String.format(Locale.US, this.jsBase + ".lastFill(%s, %s, %s, %s);", gradientKey != null ? gradientKey.getJsBase() : null, number, bool, number2));
        return this;
    }

    public Sparkline lastFill(GradientKey gradientKey, Number number, com.anychart.graphics.vector.Rect rect, Number number2) {
        APIlib.getInstance().addJSLine(String.format(Locale.US, this.jsBase + ".lastFill(%s, %s, %s, %s);", gradientKey != null ? gradientKey.getJsBase() : null, number, rect != null ? rect.getJsBase() : null, number2));
        return this;
    }

    public Sparkline lastFill(GradientKey gradientKey, Number number, String str, Number number2) {
        APIlib.getInstance().addJSLine(String.format(Locale.US, this.jsBase + ".lastFill(%s, %s, %s, %s);", gradientKey != null ? gradientKey.getJsBase() : null, number, wrapQuotes(str), number2));
        return this;
    }

    public Sparkline lastFill(String[] strArr, Number number, Boolean bool, Number number2) {
        APIlib.getInstance().addJSLine(String.format(Locale.US, this.jsBase + ".lastFill(%s, %s, %s, %s);", arrayToStringWrapQuotes(strArr), number, bool, number2));
        return this;
    }

    public Sparkline lastFill(String[] strArr, Number number, com.anychart.graphics.vector.Rect rect, Number number2) {
        APIlib.getInstance().addJSLine(String.format(Locale.US, this.jsBase + ".lastFill(%s, %s, %s, %s);", arrayToStringWrapQuotes(strArr), number, rect != null ? rect.getJsBase() : null, number2));
        return this;
    }

    public Sparkline lastFill(String[] strArr, Number number, String str, Number number2) {
        APIlib.getInstance().addJSLine(String.format(Locale.US, this.jsBase + ".lastFill(%s, %s, %s, %s);", arrayToStringWrapQuotes(strArr), number, wrapQuotes(str), number2));
        return this;
    }

    public Sparkline lastFill(GradientKey gradientKey, Number number, Number number2, com.anychart.graphics.math.Rect rect, Number number3, Number number4, Number number5) {
        APIlib.getInstance().addJSLine(String.format(Locale.US, this.jsBase + ".lastFill(%s, %s, %s, %s, %s, %s, %s);", gradientKey != null ? gradientKey.getJsBase() : null, number, number2, rect != null ? rect.getJsBase() : null, number3, number4, number5));
        return this;
    }

    public Sparkline lastFill(String[] strArr, Number number, Number number2, com.anychart.graphics.math.Rect rect, Number number3, Number number4, Number number5) {
        APIlib.getInstance().addJSLine(String.format(Locale.US, this.jsBase + ".lastFill(%s, %s, %s, %s, %s, %s, %s);", arrayToStringWrapQuotes(strArr), number, number2, rect != null ? rect.getJsBase() : null, number3, number4, number5));
        return this;
    }

    public PatternFill lastHatchFill() {
        return new PatternFill(this.jsBase + ".lastHatchFill()");
    }

    public Sparkline lastHatchFill(HatchFillType hatchFillType, String str, Number number, Number number2) {
        APIlib.getInstance().addJSLine(String.format(Locale.US, this.jsBase + ".lastHatchFill(%s, %s, %s, %s);", hatchFillType != null ? hatchFillType.getJsBase() : null, wrapQuotes(str), number, number2));
        return this;
    }

    public Sparkline lastHatchFill(String str, String str2, Number number, Number number2) {
        APIlib.getInstance().addJSLine(String.format(Locale.US, this.jsBase + ".lastHatchFill(%s, %s, %s, %s);", wrapQuotes(str), wrapQuotes(str2), number, number2));
        return this;
    }

    public Sparkline lastHatchFill(String str) {
        APIlib.getInstance().addJSLine(String.format(Locale.US, this.jsBase + ".lastHatchFill(%s);", wrapQuotes(str)));
        return this;
    }

    public Sparkline lastHatchFill(PatternFill patternFill) {
        APIlib.getInstance().addJSLine(String.format(Locale.US, this.jsBase + ".lastHatchFill(%s);", patternFill != null ? patternFill.getJsBase() : null));
        return this;
    }

    public Sparkline lastHatchFill(HatchFill hatchFill) {
        APIlib.getInstance().addJSLine(String.format(Locale.US, this.jsBase + ".lastHatchFill(%s);", hatchFill != null ? hatchFill.getJsBase() : null));
        return this;
    }

    public Sparkline lastHatchFill(Boolean bool) {
        APIlib.getInstance().addJSLine(String.format(Locale.US, this.jsBase + ".lastHatchFill(%s);", bool));
        return this;
    }

    public Label lastLabels() {
        return new Label(this.jsBase + ".lastLabels()");
    }

    public Sparkline lastLabels(String str) {
        APIlib.getInstance().addJSLine(String.format(Locale.US, this.jsBase + ".lastLabels(%s);", wrapQuotes(str)));
        return this;
    }

    public Sparkline lastLabels(Boolean bool) {
        APIlib.getInstance().addJSLine(String.format(Locale.US, this.jsBase + ".lastLabels(%s);", bool));
        return this;
    }

    public Marker lastMarkers() {
        return new Marker(this.jsBase + ".lastMarkers()");
    }

    public Sparkline lastMarkers(String str) {
        APIlib.getInstance().addJSLine(String.format(Locale.US, this.jsBase + ".lastMarkers(%s);", wrapQuotes(str)));
        return this;
    }

    public Sparkline lastMarkers(Boolean bool) {
        APIlib.getInstance().addJSLine(String.format(Locale.US, this.jsBase + ".lastMarkers(%s);", bool));
        return this;
    }

    @Override // com.anychart.core.Chart, com.anychart.core.VisualBaseWithBounds
    public void left() {
        APIlib.getInstance().addJSLine(this.jsBase + ".left();");
    }

    @Override // com.anychart.core.Chart, com.anychart.core.VisualBaseWithBounds
    public Sparkline left(Number number) {
        APIlib.getInstance().addJSLine(String.format(Locale.US, this.jsBase + ".left(%s);", number));
        return this;
    }

    @Override // com.anychart.core.Chart, com.anychart.core.VisualBaseWithBounds
    public Sparkline left(String str) {
        APIlib.getInstance().addJSLine(String.format(Locale.US, this.jsBase + ".left(%s);", wrapQuotes(str)));
        return this;
    }

    public Line lineMarker(Number number) {
        return new Line(String.format(Locale.US, this.jsBase + ".lineMarker(%s)", number));
    }

    public Sparkline lineMarker(String str) {
        APIlib.getInstance().addJSLine(String.format(Locale.US, this.jsBase + ".lineMarker(%s);", wrapQuotes(str)));
        return this;
    }

    public Sparkline lineMarker(Boolean bool) {
        APIlib.getInstance().addJSLine(String.format(Locale.US, this.jsBase + ".lineMarker(%s);", bool));
        return this;
    }

    public Sparkline lineMarker(Number number, String str) {
        APIlib.getInstance().addJSLine(String.format(Locale.US, this.jsBase + ".lineMarker(%s, %s);", number, wrapQuotes(str)));
        return this;
    }

    public Sparkline lineMarker(Number number, Boolean bool) {
        APIlib.getInstance().addJSLine(String.format(Locale.US, this.jsBase + ".lineMarker(%s, %s);", number, bool));
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
    public Sparkline margin(Number[] numberArr) {
        APIlib.getInstance().addJSLine(String.format(Locale.US, this.jsBase + ".margin(%s);", Arrays.toString(numberArr)));
        return this;
    }

    @Override // com.anychart.core.Chart
    public Sparkline margin(String[] strArr) {
        APIlib.getInstance().addJSLine(String.format(Locale.US, this.jsBase + ".margin(%s);", arrayToStringWrapQuotes(strArr)));
        return this;
    }

    @Override // com.anychart.core.Chart
    public Sparkline margin(String str) {
        APIlib.getInstance().addJSLine(String.format(Locale.US, this.jsBase + ".margin(%s);", wrapQuotes(str)));
        return this;
    }

    @Override // com.anychart.core.Chart
    public Sparkline margin(String str, String str2, String str3, String str4) {
        APIlib.getInstance().addJSLine(String.format(Locale.US, this.jsBase + ".margin(%s, %s, %s, %s);", wrapQuotes(str), wrapQuotes(str2), wrapQuotes(str3), wrapQuotes(str4)));
        return this;
    }

    @Override // com.anychart.core.Chart
    public Sparkline margin(String str, String str2, String str3, Number number) {
        APIlib.getInstance().addJSLine(String.format(Locale.US, this.jsBase + ".margin(%s, %s, %s, %s);", wrapQuotes(str), wrapQuotes(str2), wrapQuotes(str3), number));
        return this;
    }

    @Override // com.anychart.core.Chart
    public Sparkline margin(String str, String str2, Number number, String str3) {
        APIlib.getInstance().addJSLine(String.format(Locale.US, this.jsBase + ".margin(%s, %s, %s, %s);", wrapQuotes(str), wrapQuotes(str2), number, wrapQuotes(str3)));
        return this;
    }

    @Override // com.anychart.core.Chart
    public Sparkline margin(String str, String str2, Number number, Number number2) {
        APIlib.getInstance().addJSLine(String.format(Locale.US, this.jsBase + ".margin(%s, %s, %s, %s);", wrapQuotes(str), wrapQuotes(str2), number, number2));
        return this;
    }

    @Override // com.anychart.core.Chart
    public Sparkline margin(String str, Number number, String str2, String str3) {
        APIlib.getInstance().addJSLine(String.format(Locale.US, this.jsBase + ".margin(%s, %s, %s, %s);", wrapQuotes(str), number, wrapQuotes(str2), wrapQuotes(str3)));
        return this;
    }

    @Override // com.anychart.core.Chart
    public Sparkline margin(String str, Number number, String str2, Number number2) {
        APIlib.getInstance().addJSLine(String.format(Locale.US, this.jsBase + ".margin(%s, %s, %s, %s);", wrapQuotes(str), number, wrapQuotes(str2), number2));
        return this;
    }

    @Override // com.anychart.core.Chart
    public Sparkline margin(String str, Number number, Number number2, String str2) {
        APIlib.getInstance().addJSLine(String.format(Locale.US, this.jsBase + ".margin(%s, %s, %s, %s);", wrapQuotes(str), number, number2, wrapQuotes(str2)));
        return this;
    }

    @Override // com.anychart.core.Chart
    public Sparkline margin(String str, Number number, Number number2, Number number3) {
        APIlib.getInstance().addJSLine(String.format(Locale.US, this.jsBase + ".margin(%s, %s, %s, %s);", wrapQuotes(str), number, number2, number3));
        return this;
    }

    @Override // com.anychart.core.Chart
    public Sparkline margin(Number number, String str, String str2, String str3) {
        APIlib.getInstance().addJSLine(String.format(Locale.US, this.jsBase + ".margin(%s, %s, %s, %s);", number, wrapQuotes(str), wrapQuotes(str2), wrapQuotes(str3)));
        return this;
    }

    @Override // com.anychart.core.Chart
    public Sparkline margin(Number number, String str, String str2, Number number2) {
        APIlib.getInstance().addJSLine(String.format(Locale.US, this.jsBase + ".margin(%s, %s, %s, %s);", number, wrapQuotes(str), wrapQuotes(str2), number2));
        return this;
    }

    @Override // com.anychart.core.Chart
    public Sparkline margin(Number number, String str, Number number2, String str2) {
        APIlib.getInstance().addJSLine(String.format(Locale.US, this.jsBase + ".margin(%s, %s, %s, %s);", number, wrapQuotes(str), number2, wrapQuotes(str2)));
        return this;
    }

    @Override // com.anychart.core.Chart
    public Sparkline margin(Number number, String str, Number number2, Number number3) {
        APIlib.getInstance().addJSLine(String.format(Locale.US, this.jsBase + ".margin(%s, %s, %s, %s);", number, wrapQuotes(str), number2, number3));
        return this;
    }

    @Override // com.anychart.core.Chart
    public Sparkline margin(Number number, Number number2, String str, String str2) {
        APIlib.getInstance().addJSLine(String.format(Locale.US, this.jsBase + ".margin(%s, %s, %s, %s);", number, number2, wrapQuotes(str), wrapQuotes(str2)));
        return this;
    }

    @Override // com.anychart.core.Chart
    public Sparkline margin(Number number, Number number2, String str, Number number3) {
        APIlib.getInstance().addJSLine(String.format(Locale.US, this.jsBase + ".margin(%s, %s, %s, %s);", number, number2, wrapQuotes(str), number3));
        return this;
    }

    @Override // com.anychart.core.Chart
    public Sparkline margin(Number number, Number number2, Number number3, String str) {
        APIlib.getInstance().addJSLine(String.format(Locale.US, this.jsBase + ".margin(%s, %s, %s, %s);", number, number2, number3, wrapQuotes(str)));
        return this;
    }

    @Override // com.anychart.core.Chart
    public Sparkline margin(Number number, Number number2, Number number3, Number number4) {
        APIlib.getInstance().addJSLine(String.format(Locale.US, this.jsBase + ".margin(%s, %s, %s, %s);", number, number2, number3, number4));
        return this;
    }

    public Marker markers() {
        return new Marker(this.jsBase + ".markers()");
    }

    public Sparkline markers(String str) {
        APIlib.getInstance().addJSLine(String.format(Locale.US, this.jsBase + ".markers(%s);", wrapQuotes(str)));
        return this;
    }

    public Sparkline markers(Boolean bool) {
        APIlib.getInstance().addJSLine(String.format(Locale.US, this.jsBase + ".markers(%s);", bool));
        return this;
    }

    public void maxFill() {
        APIlib.getInstance().addJSLine(this.jsBase + ".maxFill();");
    }

    public Sparkline maxFill(Fill fill) {
        APIlib.getInstance().addJSLine(String.format(Locale.US, this.jsBase + ".maxFill(%s);", fill != null ? fill.getJsBase() : null));
        return this;
    }

    public Sparkline maxFill(GradientKey gradientKey) {
        APIlib.getInstance().addJSLine(String.format(Locale.US, this.jsBase + ".maxFill(%s);", gradientKey != null ? gradientKey.getJsBase() : null));
        return this;
    }

    public Sparkline maxFill(String[] strArr) {
        APIlib.getInstance().addJSLine(String.format(Locale.US, this.jsBase + ".maxFill(%s);", arrayToStringWrapQuotes(strArr)));
        return this;
    }

    public Sparkline maxFill(String str, Number number) {
        APIlib.getInstance().addJSLine(String.format(Locale.US, this.jsBase + ".maxFill(%s, %s);", wrapQuotes(str), number));
        return this;
    }

    public Sparkline maxFill(GradientKey gradientKey, Number number, Boolean bool, Number number2) {
        APIlib.getInstance().addJSLine(String.format(Locale.US, this.jsBase + ".maxFill(%s, %s, %s, %s);", gradientKey != null ? gradientKey.getJsBase() : null, number, bool, number2));
        return this;
    }

    public Sparkline maxFill(GradientKey gradientKey, Number number, com.anychart.graphics.vector.Rect rect, Number number2) {
        APIlib.getInstance().addJSLine(String.format(Locale.US, this.jsBase + ".maxFill(%s, %s, %s, %s);", gradientKey != null ? gradientKey.getJsBase() : null, number, rect != null ? rect.getJsBase() : null, number2));
        return this;
    }

    public Sparkline maxFill(GradientKey gradientKey, Number number, String str, Number number2) {
        APIlib.getInstance().addJSLine(String.format(Locale.US, this.jsBase + ".maxFill(%s, %s, %s, %s);", gradientKey != null ? gradientKey.getJsBase() : null, number, wrapQuotes(str), number2));
        return this;
    }

    public Sparkline maxFill(String[] strArr, Number number, Boolean bool, Number number2) {
        APIlib.getInstance().addJSLine(String.format(Locale.US, this.jsBase + ".maxFill(%s, %s, %s, %s);", arrayToStringWrapQuotes(strArr), number, bool, number2));
        return this;
    }

    public Sparkline maxFill(String[] strArr, Number number, com.anychart.graphics.vector.Rect rect, Number number2) {
        APIlib.getInstance().addJSLine(String.format(Locale.US, this.jsBase + ".maxFill(%s, %s, %s, %s);", arrayToStringWrapQuotes(strArr), number, rect != null ? rect.getJsBase() : null, number2));
        return this;
    }

    public Sparkline maxFill(String[] strArr, Number number, String str, Number number2) {
        APIlib.getInstance().addJSLine(String.format(Locale.US, this.jsBase + ".maxFill(%s, %s, %s, %s);", arrayToStringWrapQuotes(strArr), number, wrapQuotes(str), number2));
        return this;
    }

    public Sparkline maxFill(GradientKey gradientKey, Number number, Number number2, com.anychart.graphics.math.Rect rect, Number number3, Number number4, Number number5) {
        APIlib.getInstance().addJSLine(String.format(Locale.US, this.jsBase + ".maxFill(%s, %s, %s, %s, %s, %s, %s);", gradientKey != null ? gradientKey.getJsBase() : null, number, number2, rect != null ? rect.getJsBase() : null, number3, number4, number5));
        return this;
    }

    public Sparkline maxFill(String[] strArr, Number number, Number number2, com.anychart.graphics.math.Rect rect, Number number3, Number number4, Number number5) {
        APIlib.getInstance().addJSLine(String.format(Locale.US, this.jsBase + ".maxFill(%s, %s, %s, %s, %s, %s, %s);", arrayToStringWrapQuotes(strArr), number, number2, rect != null ? rect.getJsBase() : null, number3, number4, number5));
        return this;
    }

    public PatternFill maxHatchFill() {
        return new PatternFill(this.jsBase + ".maxHatchFill()");
    }

    public Sparkline maxHatchFill(HatchFillType hatchFillType, String str, Number number, Number number2) {
        APIlib.getInstance().addJSLine(String.format(Locale.US, this.jsBase + ".maxHatchFill(%s, %s, %s, %s);", hatchFillType != null ? hatchFillType.getJsBase() : null, wrapQuotes(str), number, number2));
        return this;
    }

    public Sparkline maxHatchFill(String str, String str2, Number number, Number number2) {
        APIlib.getInstance().addJSLine(String.format(Locale.US, this.jsBase + ".maxHatchFill(%s, %s, %s, %s);", wrapQuotes(str), wrapQuotes(str2), number, number2));
        return this;
    }

    public Sparkline maxHatchFill(String str) {
        APIlib.getInstance().addJSLine(String.format(Locale.US, this.jsBase + ".maxHatchFill(%s);", wrapQuotes(str)));
        return this;
    }

    public Sparkline maxHatchFill(PatternFill patternFill) {
        APIlib.getInstance().addJSLine(String.format(Locale.US, this.jsBase + ".maxHatchFill(%s);", patternFill != null ? patternFill.getJsBase() : null));
        return this;
    }

    public Sparkline maxHatchFill(HatchFill hatchFill) {
        APIlib.getInstance().addJSLine(String.format(Locale.US, this.jsBase + ".maxHatchFill(%s);", hatchFill != null ? hatchFill.getJsBase() : null));
        return this;
    }

    public Sparkline maxHatchFill(Boolean bool) {
        APIlib.getInstance().addJSLine(String.format(Locale.US, this.jsBase + ".maxHatchFill(%s);", bool));
        return this;
    }

    @Override // com.anychart.core.Chart, com.anychart.core.VisualBaseWithBounds
    public void maxHeight() {
        APIlib.getInstance().addJSLine(this.jsBase + ".maxHeight();");
    }

    @Override // com.anychart.core.Chart, com.anychart.core.VisualBaseWithBounds
    public Sparkline maxHeight(Number number) {
        APIlib.getInstance().addJSLine(String.format(Locale.US, this.jsBase + ".maxHeight(%s);", number));
        return this;
    }

    @Override // com.anychart.core.Chart, com.anychart.core.VisualBaseWithBounds
    public Sparkline maxHeight(String str) {
        APIlib.getInstance().addJSLine(String.format(Locale.US, this.jsBase + ".maxHeight(%s);", wrapQuotes(str)));
        return this;
    }

    public Label maxLabels() {
        return new Label(this.jsBase + ".maxLabels()");
    }

    public Sparkline maxLabels(String str) {
        APIlib.getInstance().addJSLine(String.format(Locale.US, this.jsBase + ".maxLabels(%s);", wrapQuotes(str)));
        return this;
    }

    public Sparkline maxLabels(Boolean bool) {
        APIlib.getInstance().addJSLine(String.format(Locale.US, this.jsBase + ".maxLabels(%s);", bool));
        return this;
    }

    public Marker maxMarkers() {
        return new Marker(this.jsBase + ".maxMarkers()");
    }

    public Sparkline maxMarkers(String str) {
        APIlib.getInstance().addJSLine(String.format(Locale.US, this.jsBase + ".maxMarkers(%s);", wrapQuotes(str)));
        return this;
    }

    public Sparkline maxMarkers(Boolean bool) {
        APIlib.getInstance().addJSLine(String.format(Locale.US, this.jsBase + ".maxMarkers(%s);", bool));
        return this;
    }

    @Override // com.anychart.core.Chart, com.anychart.core.VisualBaseWithBounds
    public void maxWidth() {
        APIlib.getInstance().addJSLine(this.jsBase + ".maxWidth();");
    }

    @Override // com.anychart.core.Chart, com.anychart.core.VisualBaseWithBounds
    public Sparkline maxWidth(Number number) {
        APIlib.getInstance().addJSLine(String.format(Locale.US, this.jsBase + ".maxWidth(%s);", number));
        return this;
    }

    @Override // com.anychart.core.Chart, com.anychart.core.VisualBaseWithBounds
    public Sparkline maxWidth(String str) {
        APIlib.getInstance().addJSLine(String.format(Locale.US, this.jsBase + ".maxWidth(%s);", wrapQuotes(str)));
        return this;
    }

    public void minFill() {
        APIlib.getInstance().addJSLine(this.jsBase + ".minFill();");
    }

    public Sparkline minFill(Fill fill) {
        APIlib.getInstance().addJSLine(String.format(Locale.US, this.jsBase + ".minFill(%s);", fill != null ? fill.getJsBase() : null));
        return this;
    }

    public Sparkline minFill(String str) {
        APIlib.getInstance().addJSLine(String.format(Locale.US, this.jsBase + ".minFill(%s);", wrapQuotes(str)));
        return this;
    }

    public Sparkline minFill(String[] strArr) {
        APIlib.getInstance().addJSLine(String.format(Locale.US, this.jsBase + ".minFill(%s);", arrayToStringWrapQuotes(strArr)));
        return this;
    }

    public Sparkline minFill(String str, Number number) {
        APIlib.getInstance().addJSLine(String.format(Locale.US, this.jsBase + ".minFill(%s, %s);", wrapQuotes(str), number));
        return this;
    }

    public Sparkline minFill(GradientKey gradientKey, Number number, Boolean bool, Number number2) {
        APIlib.getInstance().addJSLine(String.format(Locale.US, this.jsBase + ".minFill(%s, %s, %s, %s);", gradientKey != null ? gradientKey.getJsBase() : null, number, bool, number2));
        return this;
    }

    public Sparkline minFill(GradientKey gradientKey, Number number, com.anychart.graphics.vector.Rect rect, Number number2) {
        APIlib.getInstance().addJSLine(String.format(Locale.US, this.jsBase + ".minFill(%s, %s, %s, %s);", gradientKey != null ? gradientKey.getJsBase() : null, number, rect != null ? rect.getJsBase() : null, number2));
        return this;
    }

    public Sparkline minFill(GradientKey gradientKey, Number number, String str, Number number2) {
        APIlib.getInstance().addJSLine(String.format(Locale.US, this.jsBase + ".minFill(%s, %s, %s, %s);", gradientKey != null ? gradientKey.getJsBase() : null, number, wrapQuotes(str), number2));
        return this;
    }

    public Sparkline minFill(String[] strArr, Number number, Boolean bool, Number number2) {
        APIlib.getInstance().addJSLine(String.format(Locale.US, this.jsBase + ".minFill(%s, %s, %s, %s);", arrayToStringWrapQuotes(strArr), number, bool, number2));
        return this;
    }

    public Sparkline minFill(String[] strArr, Number number, com.anychart.graphics.vector.Rect rect, Number number2) {
        APIlib.getInstance().addJSLine(String.format(Locale.US, this.jsBase + ".minFill(%s, %s, %s, %s);", arrayToStringWrapQuotes(strArr), number, rect != null ? rect.getJsBase() : null, number2));
        return this;
    }

    public Sparkline minFill(String[] strArr, Number number, String str, Number number2) {
        APIlib.getInstance().addJSLine(String.format(Locale.US, this.jsBase + ".minFill(%s, %s, %s, %s);", arrayToStringWrapQuotes(strArr), number, wrapQuotes(str), number2));
        return this;
    }

    public Sparkline minFill(GradientKey gradientKey, Number number, Number number2, com.anychart.graphics.math.Rect rect, Number number3, Number number4, Number number5) {
        APIlib.getInstance().addJSLine(String.format(Locale.US, this.jsBase + ".minFill(%s, %s, %s, %s, %s, %s, %s);", gradientKey != null ? gradientKey.getJsBase() : null, number, number2, rect != null ? rect.getJsBase() : null, number3, number4, number5));
        return this;
    }

    public Sparkline minFill(String[] strArr, Number number, Number number2, com.anychart.graphics.math.Rect rect, Number number3, Number number4, Number number5) {
        APIlib.getInstance().addJSLine(String.format(Locale.US, this.jsBase + ".minFill(%s, %s, %s, %s, %s, %s, %s);", arrayToStringWrapQuotes(strArr), number, number2, rect != null ? rect.getJsBase() : null, number3, number4, number5));
        return this;
    }

    public PatternFill minHatchFill() {
        return new PatternFill(this.jsBase + ".minHatchFill()");
    }

    public Sparkline minHatchFill(HatchFillType hatchFillType, String str, Number number, Number number2) {
        APIlib.getInstance().addJSLine(String.format(Locale.US, this.jsBase + ".minHatchFill(%s, %s, %s, %s);", hatchFillType != null ? hatchFillType.getJsBase() : null, wrapQuotes(str), number, number2));
        return this;
    }

    public Sparkline minHatchFill(String str, String str2, Number number, Number number2) {
        APIlib.getInstance().addJSLine(String.format(Locale.US, this.jsBase + ".minHatchFill(%s, %s, %s, %s);", wrapQuotes(str), wrapQuotes(str2), number, number2));
        return this;
    }

    public Sparkline minHatchFill(String str) {
        APIlib.getInstance().addJSLine(String.format(Locale.US, this.jsBase + ".minHatchFill(%s);", wrapQuotes(str)));
        return this;
    }

    public Sparkline minHatchFill(PatternFill patternFill) {
        APIlib.getInstance().addJSLine(String.format(Locale.US, this.jsBase + ".minHatchFill(%s);", patternFill != null ? patternFill.getJsBase() : null));
        return this;
    }

    public Sparkline minHatchFill(HatchFill hatchFill) {
        APIlib.getInstance().addJSLine(String.format(Locale.US, this.jsBase + ".minHatchFill(%s);", hatchFill != null ? hatchFill.getJsBase() : null));
        return this;
    }

    public Sparkline minHatchFill(Boolean bool) {
        APIlib.getInstance().addJSLine(String.format(Locale.US, this.jsBase + ".minHatchFill(%s);", bool));
        return this;
    }

    @Override // com.anychart.core.Chart, com.anychart.core.VisualBaseWithBounds
    public void minHeight() {
        APIlib.getInstance().addJSLine(this.jsBase + ".minHeight();");
    }

    @Override // com.anychart.core.Chart, com.anychart.core.VisualBaseWithBounds
    public Sparkline minHeight(Number number) {
        APIlib.getInstance().addJSLine(String.format(Locale.US, this.jsBase + ".minHeight(%s);", number));
        return this;
    }

    @Override // com.anychart.core.Chart, com.anychart.core.VisualBaseWithBounds
    public Sparkline minHeight(String str) {
        APIlib.getInstance().addJSLine(String.format(Locale.US, this.jsBase + ".minHeight(%s);", wrapQuotes(str)));
        return this;
    }

    public Label minLabels() {
        return new Label(this.jsBase + ".minLabels()");
    }

    public Sparkline minLabels(String str) {
        APIlib.getInstance().addJSLine(String.format(Locale.US, this.jsBase + ".minLabels(%s);", wrapQuotes(str)));
        return this;
    }

    public Sparkline minLabels(Boolean bool) {
        APIlib.getInstance().addJSLine(String.format(Locale.US, this.jsBase + ".minLabels(%s);", bool));
        return this;
    }

    public Marker minMarkers() {
        return new Marker(this.jsBase + ".minMarkers()");
    }

    public Sparkline minMarkers(String str) {
        APIlib.getInstance().addJSLine(String.format(Locale.US, this.jsBase + ".minMarkers(%s);", wrapQuotes(str)));
        return this;
    }

    public Sparkline minMarkers(Boolean bool) {
        APIlib.getInstance().addJSLine(String.format(Locale.US, this.jsBase + ".minMarkers(%s);", bool));
        return this;
    }

    @Override // com.anychart.core.Chart, com.anychart.core.VisualBaseWithBounds
    public void minWidth() {
        APIlib.getInstance().addJSLine(this.jsBase + ".minWidth();");
    }

    @Override // com.anychart.core.Chart, com.anychart.core.VisualBaseWithBounds
    public Sparkline minWidth(Number number) {
        APIlib.getInstance().addJSLine(String.format(Locale.US, this.jsBase + ".minWidth(%s);", number));
        return this;
    }

    @Override // com.anychart.core.Chart, com.anychart.core.VisualBaseWithBounds
    public Sparkline minWidth(String str) {
        APIlib.getInstance().addJSLine(String.format(Locale.US, this.jsBase + ".minWidth(%s);", wrapQuotes(str)));
        return this;
    }

    public void negativeFill() {
        APIlib.getInstance().addJSLine(this.jsBase + ".negativeFill();");
    }

    public Sparkline negativeFill(Fill fill) {
        APIlib.getInstance().addJSLine(String.format(Locale.US, this.jsBase + ".negativeFill(%s);", fill != null ? fill.getJsBase() : null));
        return this;
    }

    public Sparkline negativeFill(GradientKey gradientKey) {
        APIlib.getInstance().addJSLine(String.format(Locale.US, this.jsBase + ".negativeFill(%s);", gradientKey != null ? gradientKey.getJsBase() : null));
        return this;
    }

    public Sparkline negativeFill(String[] strArr) {
        APIlib.getInstance().addJSLine(String.format(Locale.US, this.jsBase + ".negativeFill(%s);", arrayToStringWrapQuotes(strArr)));
        return this;
    }

    public Sparkline negativeFill(String str, Number number) {
        APIlib.getInstance().addJSLine(String.format(Locale.US, this.jsBase + ".negativeFill(%s, %s);", wrapQuotes(str), number));
        return this;
    }

    public Sparkline negativeFill(GradientKey gradientKey, Number number, Boolean bool, Number number2) {
        APIlib.getInstance().addJSLine(String.format(Locale.US, this.jsBase + ".negativeFill(%s, %s, %s, %s);", gradientKey != null ? gradientKey.getJsBase() : null, number, bool, number2));
        return this;
    }

    public Sparkline negativeFill(GradientKey gradientKey, Number number, com.anychart.graphics.vector.Rect rect, Number number2) {
        APIlib.getInstance().addJSLine(String.format(Locale.US, this.jsBase + ".negativeFill(%s, %s, %s, %s);", gradientKey != null ? gradientKey.getJsBase() : null, number, rect != null ? rect.getJsBase() : null, number2));
        return this;
    }

    public Sparkline negativeFill(GradientKey gradientKey, Number number, String str, Number number2) {
        APIlib.getInstance().addJSLine(String.format(Locale.US, this.jsBase + ".negativeFill(%s, %s, %s, %s);", gradientKey != null ? gradientKey.getJsBase() : null, number, wrapQuotes(str), number2));
        return this;
    }

    public Sparkline negativeFill(String[] strArr, Number number, Boolean bool, Number number2) {
        APIlib.getInstance().addJSLine(String.format(Locale.US, this.jsBase + ".negativeFill(%s, %s, %s, %s);", arrayToStringWrapQuotes(strArr), number, bool, number2));
        return this;
    }

    public Sparkline negativeFill(String[] strArr, Number number, com.anychart.graphics.vector.Rect rect, Number number2) {
        APIlib.getInstance().addJSLine(String.format(Locale.US, this.jsBase + ".negativeFill(%s, %s, %s, %s);", arrayToStringWrapQuotes(strArr), number, rect != null ? rect.getJsBase() : null, number2));
        return this;
    }

    public Sparkline negativeFill(String[] strArr, Number number, String str, Number number2) {
        APIlib.getInstance().addJSLine(String.format(Locale.US, this.jsBase + ".negativeFill(%s, %s, %s, %s);", arrayToStringWrapQuotes(strArr), number, wrapQuotes(str), number2));
        return this;
    }

    public Sparkline negativeFill(GradientKey gradientKey, Number number, Number number2, com.anychart.graphics.math.Rect rect, Number number3, Number number4, Number number5) {
        APIlib.getInstance().addJSLine(String.format(Locale.US, this.jsBase + ".negativeFill(%s, %s, %s, %s, %s, %s, %s);", gradientKey != null ? gradientKey.getJsBase() : null, number, number2, rect != null ? rect.getJsBase() : null, number3, number4, number5));
        return this;
    }

    public Sparkline negativeFill(String[] strArr, Number number, Number number2, com.anychart.graphics.math.Rect rect, Number number3, Number number4, Number number5) {
        APIlib.getInstance().addJSLine(String.format(Locale.US, this.jsBase + ".negativeFill(%s, %s, %s, %s, %s, %s, %s);", arrayToStringWrapQuotes(strArr), number, number2, rect != null ? rect.getJsBase() : null, number3, number4, number5));
        return this;
    }

    public PatternFill negativeHatchFill() {
        return new PatternFill(this.jsBase + ".negativeHatchFill()");
    }

    public Sparkline negativeHatchFill(HatchFillType hatchFillType, String str, Number number, Number number2) {
        APIlib.getInstance().addJSLine(String.format(Locale.US, this.jsBase + ".negativeHatchFill(%s, %s, %s, %s);", hatchFillType != null ? hatchFillType.getJsBase() : null, wrapQuotes(str), number, number2));
        return this;
    }

    public Sparkline negativeHatchFill(String str, String str2, Number number, Number number2) {
        APIlib.getInstance().addJSLine(String.format(Locale.US, this.jsBase + ".negativeHatchFill(%s, %s, %s, %s);", wrapQuotes(str), wrapQuotes(str2), number, number2));
        return this;
    }

    public Sparkline negativeHatchFill(String str) {
        APIlib.getInstance().addJSLine(String.format(Locale.US, this.jsBase + ".negativeHatchFill(%s);", wrapQuotes(str)));
        return this;
    }

    public Sparkline negativeHatchFill(PatternFill patternFill) {
        APIlib.getInstance().addJSLine(String.format(Locale.US, this.jsBase + ".negativeHatchFill(%s);", patternFill != null ? patternFill.getJsBase() : null));
        return this;
    }

    public Sparkline negativeHatchFill(HatchFill hatchFill) {
        APIlib.getInstance().addJSLine(String.format(Locale.US, this.jsBase + ".negativeHatchFill(%s);", hatchFill != null ? hatchFill.getJsBase() : null));
        return this;
    }

    public Sparkline negativeHatchFill(Boolean bool) {
        APIlib.getInstance().addJSLine(String.format(Locale.US, this.jsBase + ".negativeHatchFill(%s);", bool));
        return this;
    }

    public Label negativeLabels() {
        return new Label(this.jsBase + ".negativeLabels()");
    }

    public Sparkline negativeLabels(String str) {
        APIlib.getInstance().addJSLine(String.format(Locale.US, this.jsBase + ".negativeLabels(%s);", wrapQuotes(str)));
        return this;
    }

    public Sparkline negativeLabels(Boolean bool) {
        APIlib.getInstance().addJSLine(String.format(Locale.US, this.jsBase + ".negativeLabels(%s);", bool));
        return this;
    }

    public Marker negativeMarkers() {
        return new Marker(this.jsBase + ".negativeMarkers()");
    }

    public Sparkline negativeMarkers(String str) {
        APIlib.getInstance().addJSLine(String.format(Locale.US, this.jsBase + ".negativeMarkers(%s);", wrapQuotes(str)));
        return this;
    }

    public Sparkline negativeMarkers(Boolean bool) {
        APIlib.getInstance().addJSLine(String.format(Locale.US, this.jsBase + ".negativeMarkers(%s);", bool));
        return this;
    }

    @Override // com.anychart.core.Chart
    public NoDataSettings noData() {
        return new NoDataSettings(this.jsBase + ".noData()");
    }

    @Override // com.anychart.core.Chart
    public Sparkline noData(String str) {
        APIlib.getInstance().addJSLine(String.format(Locale.US, this.jsBase + ".noData(%s);", wrapQuotes(str)));
        return this;
    }

    @Override // com.anychart.core.Chart
    public Padding padding() {
        return new Padding(this.jsBase + ".padding()");
    }

    @Override // com.anychart.core.Chart
    public Sparkline padding(Number[] numberArr) {
        APIlib.getInstance().addJSLine(String.format(Locale.US, this.jsBase + ".padding(%s);", Arrays.toString(numberArr)));
        return this;
    }

    @Override // com.anychart.core.Chart
    public Sparkline padding(String[] strArr) {
        APIlib.getInstance().addJSLine(String.format(Locale.US, this.jsBase + ".padding(%s);", arrayToStringWrapQuotes(strArr)));
        return this;
    }

    @Override // com.anychart.core.Chart
    public Sparkline padding(String str) {
        APIlib.getInstance().addJSLine(String.format(Locale.US, this.jsBase + ".padding(%s);", wrapQuotes(str)));
        return this;
    }

    @Override // com.anychart.core.Chart
    public Sparkline padding(String str, String str2, String str3, String str4) {
        APIlib.getInstance().addJSLine(String.format(Locale.US, this.jsBase + ".padding(%s, %s, %s, %s);", wrapQuotes(str), wrapQuotes(str2), wrapQuotes(str3), wrapQuotes(str4)));
        return this;
    }

    @Override // com.anychart.core.Chart
    public Sparkline padding(String str, String str2, String str3, Number number) {
        APIlib.getInstance().addJSLine(String.format(Locale.US, this.jsBase + ".padding(%s, %s, %s, %s);", wrapQuotes(str), wrapQuotes(str2), wrapQuotes(str3), number));
        return this;
    }

    @Override // com.anychart.core.Chart
    public Sparkline padding(String str, String str2, Number number, String str3) {
        APIlib.getInstance().addJSLine(String.format(Locale.US, this.jsBase + ".padding(%s, %s, %s, %s);", wrapQuotes(str), wrapQuotes(str2), number, wrapQuotes(str3)));
        return this;
    }

    @Override // com.anychart.core.Chart
    public Sparkline padding(String str, String str2, Number number, Number number2) {
        APIlib.getInstance().addJSLine(String.format(Locale.US, this.jsBase + ".padding(%s, %s, %s, %s);", wrapQuotes(str), wrapQuotes(str2), number, number2));
        return this;
    }

    @Override // com.anychart.core.Chart
    public Sparkline padding(String str, Number number, String str2, String str3) {
        APIlib.getInstance().addJSLine(String.format(Locale.US, this.jsBase + ".padding(%s, %s, %s, %s);", wrapQuotes(str), number, wrapQuotes(str2), wrapQuotes(str3)));
        return this;
    }

    @Override // com.anychart.core.Chart
    public Sparkline padding(String str, Number number, String str2, Number number2) {
        APIlib.getInstance().addJSLine(String.format(Locale.US, this.jsBase + ".padding(%s, %s, %s, %s);", wrapQuotes(str), number, wrapQuotes(str2), number2));
        return this;
    }

    @Override // com.anychart.core.Chart
    public Sparkline padding(String str, Number number, Number number2, String str2) {
        APIlib.getInstance().addJSLine(String.format(Locale.US, this.jsBase + ".padding(%s, %s, %s, %s);", wrapQuotes(str), number, number2, wrapQuotes(str2)));
        return this;
    }

    @Override // com.anychart.core.Chart
    public Sparkline padding(String str, Number number, Number number2, Number number3) {
        APIlib.getInstance().addJSLine(String.format(Locale.US, this.jsBase + ".padding(%s, %s, %s, %s);", wrapQuotes(str), number, number2, number3));
        return this;
    }

    @Override // com.anychart.core.Chart
    public Sparkline padding(Number number, String str, String str2, String str3) {
        APIlib.getInstance().addJSLine(String.format(Locale.US, this.jsBase + ".padding(%s, %s, %s, %s);", number, wrapQuotes(str), wrapQuotes(str2), wrapQuotes(str3)));
        return this;
    }

    @Override // com.anychart.core.Chart
    public Sparkline padding(Number number, String str, String str2, Number number2) {
        APIlib.getInstance().addJSLine(String.format(Locale.US, this.jsBase + ".padding(%s, %s, %s, %s);", number, wrapQuotes(str), wrapQuotes(str2), number2));
        return this;
    }

    @Override // com.anychart.core.Chart
    public Sparkline padding(Number number, String str, Number number2, String str2) {
        APIlib.getInstance().addJSLine(String.format(Locale.US, this.jsBase + ".padding(%s, %s, %s, %s);", number, wrapQuotes(str), number2, wrapQuotes(str2)));
        return this;
    }

    @Override // com.anychart.core.Chart
    public Sparkline padding(Number number, String str, Number number2, Number number3) {
        APIlib.getInstance().addJSLine(String.format(Locale.US, this.jsBase + ".padding(%s, %s, %s, %s);", number, wrapQuotes(str), number2, number3));
        return this;
    }

    @Override // com.anychart.core.Chart
    public Sparkline padding(Number number, Number number2, String str, String str2) {
        APIlib.getInstance().addJSLine(String.format(Locale.US, this.jsBase + ".padding(%s, %s, %s, %s);", number, number2, wrapQuotes(str), wrapQuotes(str2)));
        return this;
    }

    @Override // com.anychart.core.Chart
    public Sparkline padding(Number number, Number number2, String str, Number number3) {
        APIlib.getInstance().addJSLine(String.format(Locale.US, this.jsBase + ".padding(%s, %s, %s, %s);", number, number2, wrapQuotes(str), number3));
        return this;
    }

    @Override // com.anychart.core.Chart
    public Sparkline padding(Number number, Number number2, Number number3, String str) {
        APIlib.getInstance().addJSLine(String.format(Locale.US, this.jsBase + ".padding(%s, %s, %s, %s);", number, number2, number3, wrapQuotes(str)));
        return this;
    }

    @Override // com.anychart.core.Chart
    public Sparkline padding(Number number, Number number2, Number number3, Number number4) {
        APIlib.getInstance().addJSLine(String.format(Locale.US, this.jsBase + ".padding(%s, %s, %s, %s);", number, number2, number3, number4));
        return this;
    }

    public void pointWidth() {
        APIlib.getInstance().addJSLine(this.jsBase + ".pointWidth();");
    }

    public Sparkline pointWidth(Number number) {
        APIlib.getInstance().addJSLine(String.format(Locale.US, this.jsBase + ".pointWidth(%s);", number));
        return this;
    }

    public Sparkline pointWidth(String str) {
        APIlib.getInstance().addJSLine(String.format(Locale.US, this.jsBase + ".pointWidth(%s);", wrapQuotes(str)));
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

    public Range rangeMarker(Number number) {
        return new Range(String.format(Locale.US, this.jsBase + ".rangeMarker(%s)", number));
    }

    public Sparkline rangeMarker(String str) {
        APIlib.getInstance().addJSLine(String.format(Locale.US, this.jsBase + ".rangeMarker(%s);", wrapQuotes(str)));
        return this;
    }

    public Sparkline rangeMarker(Boolean bool) {
        APIlib.getInstance().addJSLine(String.format(Locale.US, this.jsBase + ".rangeMarker(%s);", bool));
        return this;
    }

    public Sparkline rangeMarker(Number number, String str) {
        APIlib.getInstance().addJSLine(String.format(Locale.US, this.jsBase + ".rangeMarker(%s, %s);", number, wrapQuotes(str)));
        return this;
    }

    public Sparkline rangeMarker(Number number, Boolean bool) {
        APIlib.getInstance().addJSLine(String.format(Locale.US, this.jsBase + ".rangeMarker(%s, %s);", number, bool));
        return this;
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
    public Sparkline right(Number number) {
        APIlib.getInstance().addJSLine(String.format(Locale.US, this.jsBase + ".right(%s);", number));
        return this;
    }

    @Override // com.anychart.core.Chart, com.anychart.core.VisualBaseWithBounds
    public Sparkline right(String str) {
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

    @Override // com.anychart.core.Chart
    public void selectMarqueeFill() {
        APIlib.getInstance().addJSLine(this.jsBase + ".selectMarqueeFill();");
    }

    @Override // com.anychart.core.Chart
    public Sparkline selectMarqueeFill(Fill fill) {
        APIlib.getInstance().addJSLine(String.format(Locale.US, this.jsBase + ".selectMarqueeFill(%s);", fill != null ? fill.getJsBase() : null));
        return this;
    }

    @Override // com.anychart.core.Chart
    public Sparkline selectMarqueeFill(GradientKey gradientKey) {
        APIlib.getInstance().addJSLine(String.format(Locale.US, this.jsBase + ".selectMarqueeFill(%s);", gradientKey != null ? gradientKey.getJsBase() : null));
        return this;
    }

    @Override // com.anychart.core.Chart
    public Sparkline selectMarqueeFill(String[] strArr) {
        APIlib.getInstance().addJSLine(String.format(Locale.US, this.jsBase + ".selectMarqueeFill(%s);", arrayToStringWrapQuotes(strArr)));
        return this;
    }

    @Override // com.anychart.core.Chart
    public Sparkline selectMarqueeFill(String str, Number number) {
        APIlib.getInstance().addJSLine(String.format(Locale.US, this.jsBase + ".selectMarqueeFill(%s, %s);", wrapQuotes(str), number));
        return this;
    }

    @Override // com.anychart.core.Chart
    public Sparkline selectMarqueeFill(GradientKey gradientKey, Number number, Boolean bool, Number number2) {
        APIlib.getInstance().addJSLine(String.format(Locale.US, this.jsBase + ".selectMarqueeFill(%s, %s, %s, %s);", gradientKey != null ? gradientKey.getJsBase() : null, number, bool, number2));
        return this;
    }

    @Override // com.anychart.core.Chart
    public Sparkline selectMarqueeFill(GradientKey gradientKey, Number number, com.anychart.graphics.vector.Rect rect, Number number2) {
        APIlib.getInstance().addJSLine(String.format(Locale.US, this.jsBase + ".selectMarqueeFill(%s, %s, %s, %s);", gradientKey != null ? gradientKey.getJsBase() : null, number, rect != null ? rect.getJsBase() : null, number2));
        return this;
    }

    @Override // com.anychart.core.Chart
    public Sparkline selectMarqueeFill(GradientKey gradientKey, Number number, String str, Number number2) {
        APIlib.getInstance().addJSLine(String.format(Locale.US, this.jsBase + ".selectMarqueeFill(%s, %s, %s, %s);", gradientKey != null ? gradientKey.getJsBase() : null, number, wrapQuotes(str), number2));
        return this;
    }

    @Override // com.anychart.core.Chart
    public Sparkline selectMarqueeFill(String[] strArr, Number number, Boolean bool, Number number2) {
        APIlib.getInstance().addJSLine(String.format(Locale.US, this.jsBase + ".selectMarqueeFill(%s, %s, %s, %s);", arrayToStringWrapQuotes(strArr), number, bool, number2));
        return this;
    }

    @Override // com.anychart.core.Chart
    public Sparkline selectMarqueeFill(String[] strArr, Number number, com.anychart.graphics.vector.Rect rect, Number number2) {
        APIlib.getInstance().addJSLine(String.format(Locale.US, this.jsBase + ".selectMarqueeFill(%s, %s, %s, %s);", arrayToStringWrapQuotes(strArr), number, rect != null ? rect.getJsBase() : null, number2));
        return this;
    }

    @Override // com.anychart.core.Chart
    public Sparkline selectMarqueeFill(String[] strArr, Number number, String str, Number number2) {
        APIlib.getInstance().addJSLine(String.format(Locale.US, this.jsBase + ".selectMarqueeFill(%s, %s, %s, %s);", arrayToStringWrapQuotes(strArr), number, wrapQuotes(str), number2));
        return this;
    }

    @Override // com.anychart.core.Chart
    public Sparkline selectMarqueeFill(GradientKey gradientKey, Number number, Number number2, com.anychart.graphics.math.Rect rect, Number number3, Number number4, Number number5) {
        APIlib.getInstance().addJSLine(String.format(Locale.US, this.jsBase + ".selectMarqueeFill(%s, %s, %s, %s, %s, %s, %s);", gradientKey != null ? gradientKey.getJsBase() : null, number, number2, rect != null ? rect.getJsBase() : null, number3, number4, number5));
        return this;
    }

    @Override // com.anychart.core.Chart
    public Sparkline selectMarqueeFill(String[] strArr, Number number, Number number2, com.anychart.graphics.math.Rect rect, Number number3, Number number4, Number number5) {
        APIlib.getInstance().addJSLine(String.format(Locale.US, this.jsBase + ".selectMarqueeFill(%s, %s, %s, %s, %s, %s, %s);", arrayToStringWrapQuotes(strArr), number, number2, rect != null ? rect.getJsBase() : null, number3, number4, number5));
        return this;
    }

    @Override // com.anychart.core.Chart
    public void selectMarqueeStroke() {
        APIlib.getInstance().addJSLine(this.jsBase + ".selectMarqueeStroke();");
    }

    @Override // com.anychart.core.Chart
    public Sparkline selectMarqueeStroke(Stroke stroke, Number number, String str, String str2, String str3) {
        APIlib.getInstance().addJSLine(String.format(Locale.US, this.jsBase + ".selectMarqueeStroke(%s, %s, %s, %s, %s);", stroke != null ? stroke.getJsBase() : null, number, wrapQuotes(str), wrapQuotes(str2), wrapQuotes(str3)));
        return this;
    }

    @Override // com.anychart.core.Chart
    public Sparkline selectMarqueeStroke(Stroke stroke, Number number, String str, String str2, StrokeLineCap strokeLineCap) {
        APIlib.getInstance().addJSLine(String.format(Locale.US, this.jsBase + ".selectMarqueeStroke(%s, %s, %s, %s, %s);", stroke != null ? stroke.getJsBase() : null, number, wrapQuotes(str), wrapQuotes(str2), strokeLineCap != null ? strokeLineCap.getJsBase() : null));
        return this;
    }

    @Override // com.anychart.core.Chart
    public Sparkline selectMarqueeStroke(Stroke stroke, Number number, String str, StrokeLineJoin strokeLineJoin, String str2) {
        APIlib.getInstance().addJSLine(String.format(Locale.US, this.jsBase + ".selectMarqueeStroke(%s, %s, %s, %s, %s);", stroke != null ? stroke.getJsBase() : null, number, wrapQuotes(str), strokeLineJoin != null ? strokeLineJoin.getJsBase() : null, wrapQuotes(str2)));
        return this;
    }

    @Override // com.anychart.core.Chart
    public Sparkline selectMarqueeStroke(Stroke stroke, Number number, String str, StrokeLineJoin strokeLineJoin, StrokeLineCap strokeLineCap) {
        APIlib.getInstance().addJSLine(String.format(Locale.US, this.jsBase + ".selectMarqueeStroke(%s, %s, %s, %s, %s);", stroke != null ? stroke.getJsBase() : null, number, wrapQuotes(str), strokeLineJoin != null ? strokeLineJoin.getJsBase() : null, strokeLineCap != null ? strokeLineCap.getJsBase() : null));
        return this;
    }

    @Override // com.anychart.core.Chart
    public Sparkline selectMarqueeStroke(ColoredFill coloredFill, Number number, String str, String str2, String str3) {
        APIlib.getInstance().addJSLine(String.format(Locale.US, this.jsBase + ".selectMarqueeStroke(%s, %s, %s, %s, %s);", coloredFill != null ? coloredFill.getJsBase() : null, number, wrapQuotes(str), wrapQuotes(str2), wrapQuotes(str3)));
        return this;
    }

    @Override // com.anychart.core.Chart
    public Sparkline selectMarqueeStroke(ColoredFill coloredFill, Number number, String str, String str2, StrokeLineCap strokeLineCap) {
        APIlib.getInstance().addJSLine(String.format(Locale.US, this.jsBase + ".selectMarqueeStroke(%s, %s, %s, %s, %s);", coloredFill != null ? coloredFill.getJsBase() : null, number, wrapQuotes(str), wrapQuotes(str2), strokeLineCap != null ? strokeLineCap.getJsBase() : null));
        return this;
    }

    @Override // com.anychart.core.Chart
    public Sparkline selectMarqueeStroke(ColoredFill coloredFill, Number number, String str, StrokeLineJoin strokeLineJoin, String str2) {
        APIlib.getInstance().addJSLine(String.format(Locale.US, this.jsBase + ".selectMarqueeStroke(%s, %s, %s, %s, %s);", coloredFill != null ? coloredFill.getJsBase() : null, number, wrapQuotes(str), strokeLineJoin != null ? strokeLineJoin.getJsBase() : null, wrapQuotes(str2)));
        return this;
    }

    @Override // com.anychart.core.Chart
    public Sparkline selectMarqueeStroke(ColoredFill coloredFill, Number number, String str, StrokeLineJoin strokeLineJoin, StrokeLineCap strokeLineCap) {
        APIlib.getInstance().addJSLine(String.format(Locale.US, this.jsBase + ".selectMarqueeStroke(%s, %s, %s, %s, %s);", coloredFill != null ? coloredFill.getJsBase() : null, number, wrapQuotes(str), strokeLineJoin != null ? strokeLineJoin.getJsBase() : null, strokeLineCap != null ? strokeLineCap.getJsBase() : null));
        return this;
    }

    @Override // com.anychart.core.Chart
    public Sparkline selectMarqueeStroke(String str, Number number, String str2, String str3, String str4) {
        APIlib.getInstance().addJSLine(String.format(Locale.US, this.jsBase + ".selectMarqueeStroke(%s, %s, %s, %s, %s);", wrapQuotes(str), number, wrapQuotes(str2), wrapQuotes(str3), wrapQuotes(str4)));
        return this;
    }

    @Override // com.anychart.core.Chart
    public Sparkline selectMarqueeStroke(String str, Number number, String str2, String str3, StrokeLineCap strokeLineCap) {
        APIlib.getInstance().addJSLine(String.format(Locale.US, this.jsBase + ".selectMarqueeStroke(%s, %s, %s, %s, %s);", wrapQuotes(str), number, wrapQuotes(str2), wrapQuotes(str3), strokeLineCap != null ? strokeLineCap.getJsBase() : null));
        return this;
    }

    @Override // com.anychart.core.Chart
    public Sparkline selectMarqueeStroke(String str, Number number, String str2, StrokeLineJoin strokeLineJoin, String str3) {
        APIlib.getInstance().addJSLine(String.format(Locale.US, this.jsBase + ".selectMarqueeStroke(%s, %s, %s, %s, %s);", wrapQuotes(str), number, wrapQuotes(str2), strokeLineJoin != null ? strokeLineJoin.getJsBase() : null, wrapQuotes(str3)));
        return this;
    }

    @Override // com.anychart.core.Chart
    public Sparkline selectMarqueeStroke(String str, Number number, String str2, StrokeLineJoin strokeLineJoin, StrokeLineCap strokeLineCap) {
        APIlib.getInstance().addJSLine(String.format(Locale.US, this.jsBase + ".selectMarqueeStroke(%s, %s, %s, %s, %s);", wrapQuotes(str), number, wrapQuotes(str2), strokeLineJoin != null ? strokeLineJoin.getJsBase() : null, strokeLineCap != null ? strokeLineCap.getJsBase() : null));
        return this;
    }

    public void seriesType() {
        APIlib.getInstance().addJSLine(this.jsBase + ".seriesType();");
    }

    public Sparkline seriesType(SparklineSeriesType sparklineSeriesType) {
        APIlib.getInstance().addJSLine(String.format(Locale.US, this.jsBase + ".seriesType(%s);", sparklineSeriesType != null ? sparklineSeriesType.getJsBase() : null));
        return this;
    }

    public Sparkline seriesType(String str) {
        APIlib.getInstance().addJSLine(String.format(Locale.US, this.jsBase + ".seriesType(%s);", wrapQuotes(str)));
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
    public Sparkline startSelectMarquee(Boolean bool) {
        APIlib.getInstance().addJSLine(String.format(Locale.US, this.jsBase + ".startSelectMarquee(%s);", bool));
        return this;
    }

    public void stroke() {
        APIlib.getInstance().addJSLine(this.jsBase + ".stroke();");
    }

    public Sparkline stroke(Stroke stroke, Number number, String str, String str2, String str3) {
        APIlib.getInstance().addJSLine(String.format(Locale.US, this.jsBase + ".stroke(%s, %s, %s, %s, %s);", stroke != null ? stroke.getJsBase() : null, number, wrapQuotes(str), wrapQuotes(str2), wrapQuotes(str3)));
        return this;
    }

    public Sparkline stroke(Stroke stroke, Number number, String str, String str2, StrokeLineCap strokeLineCap) {
        APIlib.getInstance().addJSLine(String.format(Locale.US, this.jsBase + ".stroke(%s, %s, %s, %s, %s);", stroke != null ? stroke.getJsBase() : null, number, wrapQuotes(str), wrapQuotes(str2), strokeLineCap != null ? strokeLineCap.getJsBase() : null));
        return this;
    }

    public Sparkline stroke(Stroke stroke, Number number, String str, StrokeLineJoin strokeLineJoin, String str2) {
        APIlib.getInstance().addJSLine(String.format(Locale.US, this.jsBase + ".stroke(%s, %s, %s, %s, %s);", stroke != null ? stroke.getJsBase() : null, number, wrapQuotes(str), strokeLineJoin != null ? strokeLineJoin.getJsBase() : null, wrapQuotes(str2)));
        return this;
    }

    public Sparkline stroke(Stroke stroke, Number number, String str, StrokeLineJoin strokeLineJoin, StrokeLineCap strokeLineCap) {
        APIlib.getInstance().addJSLine(String.format(Locale.US, this.jsBase + ".stroke(%s, %s, %s, %s, %s);", stroke != null ? stroke.getJsBase() : null, number, wrapQuotes(str), strokeLineJoin != null ? strokeLineJoin.getJsBase() : null, strokeLineCap != null ? strokeLineCap.getJsBase() : null));
        return this;
    }

    public Sparkline stroke(ColoredFill coloredFill, Number number, String str, String str2, String str3) {
        APIlib.getInstance().addJSLine(String.format(Locale.US, this.jsBase + ".stroke(%s, %s, %s, %s, %s);", coloredFill != null ? coloredFill.getJsBase() : null, number, wrapQuotes(str), wrapQuotes(str2), wrapQuotes(str3)));
        return this;
    }

    public Sparkline stroke(ColoredFill coloredFill, Number number, String str, String str2, StrokeLineCap strokeLineCap) {
        APIlib.getInstance().addJSLine(String.format(Locale.US, this.jsBase + ".stroke(%s, %s, %s, %s, %s);", coloredFill != null ? coloredFill.getJsBase() : null, number, wrapQuotes(str), wrapQuotes(str2), strokeLineCap != null ? strokeLineCap.getJsBase() : null));
        return this;
    }

    public Sparkline stroke(ColoredFill coloredFill, Number number, String str, StrokeLineJoin strokeLineJoin, String str2) {
        APIlib.getInstance().addJSLine(String.format(Locale.US, this.jsBase + ".stroke(%s, %s, %s, %s, %s);", coloredFill != null ? coloredFill.getJsBase() : null, number, wrapQuotes(str), strokeLineJoin != null ? strokeLineJoin.getJsBase() : null, wrapQuotes(str2)));
        return this;
    }

    public Sparkline stroke(ColoredFill coloredFill, Number number, String str, StrokeLineJoin strokeLineJoin, StrokeLineCap strokeLineCap) {
        APIlib.getInstance().addJSLine(String.format(Locale.US, this.jsBase + ".stroke(%s, %s, %s, %s, %s);", coloredFill != null ? coloredFill.getJsBase() : null, number, wrapQuotes(str), strokeLineJoin != null ? strokeLineJoin.getJsBase() : null, strokeLineCap != null ? strokeLineCap.getJsBase() : null));
        return this;
    }

    public Sparkline stroke(String str, Number number, String str2, String str3, String str4) {
        APIlib.getInstance().addJSLine(String.format(Locale.US, this.jsBase + ".stroke(%s, %s, %s, %s, %s);", wrapQuotes(str), number, wrapQuotes(str2), wrapQuotes(str3), wrapQuotes(str4)));
        return this;
    }

    public Sparkline stroke(String str, Number number, String str2, String str3, StrokeLineCap strokeLineCap) {
        APIlib.getInstance().addJSLine(String.format(Locale.US, this.jsBase + ".stroke(%s, %s, %s, %s, %s);", wrapQuotes(str), number, wrapQuotes(str2), wrapQuotes(str3), strokeLineCap != null ? strokeLineCap.getJsBase() : null));
        return this;
    }

    public Sparkline stroke(String str, Number number, String str2, StrokeLineJoin strokeLineJoin, String str3) {
        APIlib.getInstance().addJSLine(String.format(Locale.US, this.jsBase + ".stroke(%s, %s, %s, %s, %s);", wrapQuotes(str), number, wrapQuotes(str2), strokeLineJoin != null ? strokeLineJoin.getJsBase() : null, wrapQuotes(str3)));
        return this;
    }

    public Sparkline stroke(String str, Number number, String str2, StrokeLineJoin strokeLineJoin, StrokeLineCap strokeLineCap) {
        APIlib.getInstance().addJSLine(String.format(Locale.US, this.jsBase + ".stroke(%s, %s, %s, %s, %s);", wrapQuotes(str), number, wrapQuotes(str2), strokeLineJoin != null ? strokeLineJoin.getJsBase() : null, strokeLineCap != null ? strokeLineCap.getJsBase() : null));
        return this;
    }

    public Sparkline stroke(String str) {
        APIlib.getInstance().addJSLine(String.format(Locale.US, this.jsBase + ".stroke(%s);", wrapQuotes(str)));
        return this;
    }

    public Text textMarker(Number number) {
        return new Text(String.format(Locale.US, this.jsBase + ".textMarker(%s)", number));
    }

    public Sparkline textMarker(String str) {
        APIlib.getInstance().addJSLine(String.format(Locale.US, this.jsBase + ".textMarker(%s);", wrapQuotes(str)));
        return this;
    }

    public Sparkline textMarker(Boolean bool) {
        APIlib.getInstance().addJSLine(String.format(Locale.US, this.jsBase + ".textMarker(%s);", bool));
        return this;
    }

    public Sparkline textMarker(Number number, String str) {
        APIlib.getInstance().addJSLine(String.format(Locale.US, this.jsBase + ".textMarker(%s, %s);", number, wrapQuotes(str)));
        return this;
    }

    public Sparkline textMarker(Number number, Boolean bool) {
        APIlib.getInstance().addJSLine(String.format(Locale.US, this.jsBase + ".textMarker(%s, %s);", number, bool));
        return this;
    }

    @Override // com.anychart.core.Chart
    public Title title() {
        return new Title(this.jsBase + ".title()");
    }

    @Override // com.anychart.core.Chart
    public Sparkline title(Boolean bool) {
        APIlib.getInstance().addJSLine(String.format(Locale.US, this.jsBase + ".title(%s);", bool));
        return this;
    }

    @Override // com.anychart.core.Chart
    public Sparkline title(String str) {
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
    public Sparkline tooltip(String str) {
        APIlib.getInstance().addJSLine(String.format(Locale.US, this.jsBase + ".tooltip(%s);", wrapQuotes(str)));
        return this;
    }

    @Override // com.anychart.core.Chart
    public Sparkline tooltip(Boolean bool) {
        APIlib.getInstance().addJSLine(String.format(Locale.US, this.jsBase + ".tooltip(%s);", bool));
        return this;
    }

    @Override // com.anychart.core.Chart, com.anychart.core.VisualBaseWithBounds
    public void top() {
        APIlib.getInstance().addJSLine(this.jsBase + ".top();");
    }

    @Override // com.anychart.core.Chart, com.anychart.core.VisualBaseWithBounds
    public Sparkline top(Number number) {
        APIlib.getInstance().addJSLine(String.format(Locale.US, this.jsBase + ".top(%s);", number));
        return this;
    }

    @Override // com.anychart.core.Chart, com.anychart.core.VisualBaseWithBounds
    public Sparkline top(String str) {
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
    public Sparkline width(Number number) {
        APIlib.getInstance().addJSLine(String.format(Locale.US, this.jsBase + ".width(%s);", number));
        return this;
    }

    @Override // com.anychart.core.Chart, com.anychart.core.VisualBaseWithBounds
    public Sparkline width(String str) {
        APIlib.getInstance().addJSLine(String.format(Locale.US, this.jsBase + ".width(%s);", wrapQuotes(str)));
        return this;
    }

    public Ordinal xScale() {
        return new Ordinal(this.jsBase + ".xScale()");
    }

    public Sparkline xScale(ScaleTypes scaleTypes) {
        APIlib.getInstance().addJSLine(String.format(Locale.US, this.jsBase + ".xScale(%s);", scaleTypes != null ? scaleTypes.getJsBase() : null));
        return this;
    }

    public Sparkline xScale(String str) {
        APIlib.getInstance().addJSLine(String.format(Locale.US, this.jsBase + ".xScale(%s);", wrapQuotes(str)));
        return this;
    }

    public Sparkline xScale(Base base) {
        APIlib.getInstance().addJSLine(String.format(Locale.US, this.jsBase + ".xScale(%s);", base != null ? base.getJsBase() : null));
        return this;
    }

    public Base yScale() {
        return new Base(this.jsBase + ".yScale()");
    }

    public Sparkline yScale(ScaleTypes scaleTypes) {
        APIlib.getInstance().addJSLine(String.format(Locale.US, this.jsBase + ".yScale(%s);", scaleTypes != null ? scaleTypes.getJsBase() : null));
        return this;
    }

    public Sparkline yScale(String str) {
        APIlib.getInstance().addJSLine(String.format(Locale.US, this.jsBase + ".yScale(%s);", wrapQuotes(str)));
        return this;
    }

    public Sparkline yScale(Base base) {
        APIlib.getInstance().addJSLine(String.format(Locale.US, this.jsBase + ".yScale(%s);", base != null ? base.getJsBase() : null));
        return this;
    }

    @Override // com.anychart.core.Chart, com.anychart.core.VisualBaseWithBounds, com.anychart.core.VisualBase
    public void zIndex() {
        APIlib.getInstance().addJSLine(this.jsBase + ".zIndex();");
    }

    @Override // com.anychart.core.Chart, com.anychart.core.VisualBaseWithBounds, com.anychart.core.VisualBase
    public Sparkline zIndex(Number number) {
        APIlib.getInstance().addJSLine(String.format(Locale.US, this.jsBase + ".zIndex(%s);", number));
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
    public Sparkline parentBounds(Rect rect) {
        APIlib.getInstance().addJSLine(String.format(Locale.US, this.jsBase + ".parentBounds(%s);", rect != null ? rect.getJsBase() : null));
        return this;
    }

    @Override // com.anychart.core.Chart, com.anychart.core.VisualBaseWithBounds, com.anychart.core.VisualBase
    public Sparkline parentBounds(String str) {
        APIlib.getInstance().addJSLine(String.format(Locale.US, this.jsBase + ".parentBounds(%s);", wrapQuotes(str)));
        return this;
    }

    @Override // com.anychart.core.Chart, com.anychart.core.VisualBaseWithBounds, com.anychart.core.VisualBase
    public Sparkline parentBounds(Number number) {
        APIlib.getInstance().addJSLine(String.format(Locale.US, this.jsBase + ".parentBounds(%s);", number));
        return this;
    }

    @Override // com.anychart.core.Chart, com.anychart.core.VisualBaseWithBounds, com.anychart.core.VisualBase
    public Sparkline parentBounds(Number number, Number number2, Number number3, Number number4) {
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

    public Sparkline fill(String str) {
        APIlib.getInstance().addJSLine(String.format(Locale.US, this.jsBase + ".fill(%s);", wrapQuotes(str)));
        return this;
    }
}
