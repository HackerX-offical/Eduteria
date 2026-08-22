package com.anychart.core.scatter.series;

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
import com.anychart.core.utils.Error;
import com.anychart.core.utils.LegendItemSettings;
import com.anychart.core.utils.SeriesA11y;
import com.anychart.data.View;
import com.anychart.enums.ScaleTypes;
import com.anychart.enums.SelectionMode;
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
import com.anychart.scales.LinearColor;
import com.anychart.scales.OrdinalColor;
import com.anychart.scales.ScatterBase;
import com.anychart.utils.RectObj;
import java.lang.reflect.InvocationTargetException;
import java.util.Arrays;
import java.util.List;
import java.util.Locale;

/* JADX INFO: loaded from: classes5.dex */
public class Bubble extends BaseWithMarkers {
    protected Bubble() {
    }

    public static Bubble instantiate() {
        return new Bubble("new anychart.core.scatter.series.bubble()");
    }

    public Bubble(String str) {
        StringBuilder sb = new StringBuilder("bubble");
        int i = variableIndex + 1;
        variableIndex = i;
        this.jsBase = sb.append(i).toString();
        APIlib.getInstance().addJSLine(this.jsBase + " = " + str + ";");
    }

    @Override // com.anychart.core.scatter.series.BaseWithMarkers, com.anychart.core.scatter.series.Base, com.anychart.core.SeriesBase, com.anychart.core.VisualBaseWithBounds, com.anychart.core.VisualBase, com.anychart.core.Base, com.anychart.JsObject
    public String getJsBase() {
        return this.jsBase;
    }

    @Override // com.anychart.core.scatter.series.BaseWithMarkers, com.anychart.core.scatter.series.Base, com.anychart.core.SeriesBase
    public SeriesA11y a11y() {
        return new SeriesA11y(this.jsBase + ".a11y()");
    }

    @Override // com.anychart.core.scatter.series.BaseWithMarkers, com.anychart.core.scatter.series.Base, com.anychart.core.SeriesBase
    public Bubble a11y(Boolean bool) {
        APIlib.getInstance().addJSLine(String.format(Locale.US, this.jsBase + ".a11y(%s);", bool));
        return this;
    }

    @Override // com.anychart.core.scatter.series.BaseWithMarkers, com.anychart.core.scatter.series.Base, com.anychart.core.SeriesBase
    public Bubble a11y(String str) {
        APIlib.getInstance().addJSLine(String.format(Locale.US, this.jsBase + ".a11y(%s);", wrapQuotes(str)));
        return this;
    }

    @Override // com.anychart.core.scatter.series.BaseWithMarkers, com.anychart.core.scatter.series.Base, com.anychart.core.SeriesBase, com.anychart.core.VisualBaseWithBounds
    public void bottom() {
        APIlib.getInstance().addJSLine(this.jsBase + ".bottom();");
    }

    @Override // com.anychart.core.scatter.series.BaseWithMarkers, com.anychart.core.scatter.series.Base, com.anychart.core.SeriesBase, com.anychart.core.VisualBaseWithBounds
    public Bubble bottom(Number number) {
        APIlib.getInstance().addJSLine(String.format(Locale.US, this.jsBase + ".bottom(%s);", number));
        return this;
    }

    @Override // com.anychart.core.scatter.series.BaseWithMarkers, com.anychart.core.scatter.series.Base, com.anychart.core.SeriesBase, com.anychart.core.VisualBaseWithBounds
    public Bubble bottom(String str) {
        APIlib.getInstance().addJSLine(String.format(Locale.US, this.jsBase + ".bottom(%s);", wrapQuotes(str)));
        return this;
    }

    @Override // com.anychart.core.scatter.series.BaseWithMarkers, com.anychart.core.scatter.series.Base, com.anychart.core.SeriesBase, com.anychart.core.VisualBaseWithBounds
    public Bounds bounds() {
        return new Bounds(this.jsBase + ".bounds()");
    }

    @Override // com.anychart.core.scatter.series.BaseWithMarkers, com.anychart.core.scatter.series.Base, com.anychart.core.SeriesBase, com.anychart.core.VisualBaseWithBounds
    public Bubble bounds(RectObj rectObj) {
        APIlib.getInstance().addJSLine(String.format(Locale.US, this.jsBase + ".bounds(%s);", rectObj != null ? rectObj.getJsBase() : null));
        return this;
    }

    @Override // com.anychart.core.scatter.series.BaseWithMarkers, com.anychart.core.scatter.series.Base, com.anychart.core.SeriesBase, com.anychart.core.VisualBaseWithBounds
    public Bubble bounds(Rect rect) {
        APIlib.getInstance().addJSLine(String.format(Locale.US, this.jsBase + ".bounds(%s);", rect != null ? rect.getJsBase() : null));
        return this;
    }

    @Override // com.anychart.core.scatter.series.BaseWithMarkers, com.anychart.core.scatter.series.Base, com.anychart.core.SeriesBase, com.anychart.core.VisualBaseWithBounds
    public Bubble bounds(Bounds bounds) {
        APIlib.getInstance().addJSLine(String.format(Locale.US, this.jsBase + ".bounds(%s);", bounds != null ? bounds.getJsBase() : null));
        return this;
    }

    @Override // com.anychart.core.scatter.series.BaseWithMarkers, com.anychart.core.scatter.series.Base, com.anychart.core.SeriesBase, com.anychart.core.VisualBaseWithBounds
    public Bubble bounds(Number number, Number number2, Number number3, Number number4) {
        APIlib.getInstance().addJSLine(String.format(Locale.US, this.jsBase + ".bounds(%s, %s, %s, %s);", number, number2, number3, number4));
        return this;
    }

    @Override // com.anychart.core.scatter.series.BaseWithMarkers, com.anychart.core.scatter.series.Base, com.anychart.core.SeriesBase, com.anychart.core.VisualBaseWithBounds
    public Bubble bounds(Number number, Number number2, Number number3, String str) {
        APIlib.getInstance().addJSLine(String.format(Locale.US, this.jsBase + ".bounds(%s, %s, %s, %s);", number, number2, number3, wrapQuotes(str)));
        return this;
    }

    @Override // com.anychart.core.scatter.series.BaseWithMarkers, com.anychart.core.scatter.series.Base, com.anychart.core.SeriesBase, com.anychart.core.VisualBaseWithBounds
    public Bubble bounds(Number number, Number number2, String str, Number number3) {
        APIlib.getInstance().addJSLine(String.format(Locale.US, this.jsBase + ".bounds(%s, %s, %s, %s);", number, number2, wrapQuotes(str), number3));
        return this;
    }

    @Override // com.anychart.core.scatter.series.BaseWithMarkers, com.anychart.core.scatter.series.Base, com.anychart.core.SeriesBase, com.anychart.core.VisualBaseWithBounds
    public Bubble bounds(Number number, Number number2, String str, String str2) {
        APIlib.getInstance().addJSLine(String.format(Locale.US, this.jsBase + ".bounds(%s, %s, %s, %s);", number, number2, wrapQuotes(str), wrapQuotes(str2)));
        return this;
    }

    @Override // com.anychart.core.scatter.series.BaseWithMarkers, com.anychart.core.scatter.series.Base, com.anychart.core.SeriesBase, com.anychart.core.VisualBaseWithBounds
    public Bubble bounds(Number number, String str, Number number2, Number number3) {
        APIlib.getInstance().addJSLine(String.format(Locale.US, this.jsBase + ".bounds(%s, %s, %s, %s);", number, wrapQuotes(str), number2, number3));
        return this;
    }

    @Override // com.anychart.core.scatter.series.BaseWithMarkers, com.anychart.core.scatter.series.Base, com.anychart.core.SeriesBase, com.anychart.core.VisualBaseWithBounds
    public Bubble bounds(Number number, String str, Number number2, String str2) {
        APIlib.getInstance().addJSLine(String.format(Locale.US, this.jsBase + ".bounds(%s, %s, %s, %s);", number, wrapQuotes(str), number2, wrapQuotes(str2)));
        return this;
    }

    @Override // com.anychart.core.scatter.series.BaseWithMarkers, com.anychart.core.scatter.series.Base, com.anychart.core.SeriesBase, com.anychart.core.VisualBaseWithBounds
    public Bubble bounds(Number number, String str, String str2, Number number2) {
        APIlib.getInstance().addJSLine(String.format(Locale.US, this.jsBase + ".bounds(%s, %s, %s, %s);", number, wrapQuotes(str), wrapQuotes(str2), number2));
        return this;
    }

    @Override // com.anychart.core.scatter.series.BaseWithMarkers, com.anychart.core.scatter.series.Base, com.anychart.core.SeriesBase, com.anychart.core.VisualBaseWithBounds
    public Bubble bounds(Number number, String str, String str2, String str3) {
        APIlib.getInstance().addJSLine(String.format(Locale.US, this.jsBase + ".bounds(%s, %s, %s, %s);", number, wrapQuotes(str), wrapQuotes(str2), wrapQuotes(str3)));
        return this;
    }

    @Override // com.anychart.core.scatter.series.BaseWithMarkers, com.anychart.core.scatter.series.Base, com.anychart.core.SeriesBase, com.anychart.core.VisualBaseWithBounds
    public Bubble bounds(String str, Number number, Number number2, Number number3) {
        APIlib.getInstance().addJSLine(String.format(Locale.US, this.jsBase + ".bounds(%s, %s, %s, %s);", wrapQuotes(str), number, number2, number3));
        return this;
    }

    @Override // com.anychart.core.scatter.series.BaseWithMarkers, com.anychart.core.scatter.series.Base, com.anychart.core.SeriesBase, com.anychart.core.VisualBaseWithBounds
    public Bubble bounds(String str, Number number, Number number2, String str2) {
        APIlib.getInstance().addJSLine(String.format(Locale.US, this.jsBase + ".bounds(%s, %s, %s, %s);", wrapQuotes(str), number, number2, wrapQuotes(str2)));
        return this;
    }

    @Override // com.anychart.core.scatter.series.BaseWithMarkers, com.anychart.core.scatter.series.Base, com.anychart.core.SeriesBase, com.anychart.core.VisualBaseWithBounds
    public Bubble bounds(String str, Number number, String str2, Number number2) {
        APIlib.getInstance().addJSLine(String.format(Locale.US, this.jsBase + ".bounds(%s, %s, %s, %s);", wrapQuotes(str), number, wrapQuotes(str2), number2));
        return this;
    }

    @Override // com.anychart.core.scatter.series.BaseWithMarkers, com.anychart.core.scatter.series.Base, com.anychart.core.SeriesBase, com.anychart.core.VisualBaseWithBounds
    public Bubble bounds(String str, Number number, String str2, String str3) {
        APIlib.getInstance().addJSLine(String.format(Locale.US, this.jsBase + ".bounds(%s, %s, %s, %s);", wrapQuotes(str), number, wrapQuotes(str2), wrapQuotes(str3)));
        return this;
    }

    @Override // com.anychart.core.scatter.series.BaseWithMarkers, com.anychart.core.scatter.series.Base, com.anychart.core.SeriesBase, com.anychart.core.VisualBaseWithBounds
    public Bubble bounds(String str, String str2, Number number, Number number2) {
        APIlib.getInstance().addJSLine(String.format(Locale.US, this.jsBase + ".bounds(%s, %s, %s, %s);", wrapQuotes(str), wrapQuotes(str2), number, number2));
        return this;
    }

    @Override // com.anychart.core.scatter.series.BaseWithMarkers, com.anychart.core.scatter.series.Base, com.anychart.core.SeriesBase, com.anychart.core.VisualBaseWithBounds
    public Bubble bounds(String str, String str2, Number number, String str3) {
        APIlib.getInstance().addJSLine(String.format(Locale.US, this.jsBase + ".bounds(%s, %s, %s, %s);", wrapQuotes(str), wrapQuotes(str2), number, wrapQuotes(str3)));
        return this;
    }

    @Override // com.anychart.core.scatter.series.BaseWithMarkers, com.anychart.core.scatter.series.Base, com.anychart.core.SeriesBase, com.anychart.core.VisualBaseWithBounds
    public Bubble bounds(String str, String str2, String str3, Number number) {
        APIlib.getInstance().addJSLine(String.format(Locale.US, this.jsBase + ".bounds(%s, %s, %s, %s);", wrapQuotes(str), wrapQuotes(str2), wrapQuotes(str3), number));
        return this;
    }

    @Override // com.anychart.core.scatter.series.BaseWithMarkers, com.anychart.core.scatter.series.Base, com.anychart.core.SeriesBase, com.anychart.core.VisualBaseWithBounds
    public Bubble bounds(String str, String str2, String str3, String str4) {
        APIlib.getInstance().addJSLine(String.format(Locale.US, this.jsBase + ".bounds(%s, %s, %s, %s);", wrapQuotes(str), wrapQuotes(str2), wrapQuotes(str3), wrapQuotes(str4)));
        return this;
    }

    @Override // com.anychart.core.scatter.series.BaseWithMarkers, com.anychart.core.scatter.series.Base
    public void clip() {
        APIlib.getInstance().addJSLine(this.jsBase + ".clip();");
    }

    @Override // com.anychart.core.scatter.series.BaseWithMarkers, com.anychart.core.scatter.series.Base
    public Bubble clip(Boolean bool) {
        APIlib.getInstance().addJSLine(String.format(Locale.US, this.jsBase + ".clip(%s);", bool));
        return this;
    }

    @Override // com.anychart.core.scatter.series.BaseWithMarkers, com.anychart.core.scatter.series.Base
    public Bubble clip(Rect rect) {
        APIlib.getInstance().addJSLine(String.format(Locale.US, this.jsBase + ".clip(%s);", rect != null ? rect.getJsBase() : null));
        return this;
    }

    @Override // com.anychart.core.scatter.series.BaseWithMarkers, com.anychart.core.scatter.series.Base, com.anychart.core.SeriesBase
    public void color() {
        APIlib.getInstance().addJSLine(this.jsBase + ".color();");
    }

    @Override // com.anychart.core.scatter.series.BaseWithMarkers, com.anychart.core.scatter.series.Base, com.anychart.core.SeriesBase
    public Bubble color(String str) {
        APIlib.getInstance().addJSLine(String.format(Locale.US, this.jsBase + ".color(%s);", wrapQuotes(str)));
        return this;
    }

    @Override // com.anychart.core.scatter.series.BaseWithMarkers, com.anychart.core.scatter.series.Base, com.anychart.core.SeriesBase
    public View data(List<DataEntry> list) {
        return new View(String.format(Locale.US, this.jsBase + ".data(%s)", arrayToString(list)));
    }

    public void displayNegative() {
        APIlib.getInstance().addJSLine(this.jsBase + ".displayNegative();");
    }

    public Bubble displayNegative(Boolean bool) {
        APIlib.getInstance().addJSLine(String.format(Locale.US, this.jsBase + ".displayNegative(%s);", bool));
        return this;
    }

    @Override // com.anychart.core.scatter.series.BaseWithMarkers, com.anychart.core.scatter.series.Base, com.anychart.core.SeriesBase, com.anychart.core.VisualBaseWithBounds, com.anychart.core.VisualBase
    public void enabled() {
        APIlib.getInstance().addJSLine(this.jsBase + ".enabled();");
    }

    @Override // com.anychart.core.scatter.series.BaseWithMarkers, com.anychart.core.scatter.series.Base, com.anychart.core.SeriesBase, com.anychart.core.VisualBaseWithBounds, com.anychart.core.VisualBase
    public Bubble enabled(Boolean bool) {
        APIlib.getInstance().addJSLine(String.format(Locale.US, this.jsBase + ".enabled(%s);", bool));
        return this;
    }

    @Override // com.anychart.core.scatter.series.BaseWithMarkers, com.anychart.core.scatter.series.Base
    public Error error() {
        return new Error(this.jsBase + ".error()");
    }

    @Override // com.anychart.core.scatter.series.BaseWithMarkers, com.anychart.core.scatter.series.Base
    public Bubble error(String str) {
        APIlib.getInstance().addJSLine(String.format(Locale.US, this.jsBase + ".error(%s);", wrapQuotes(str)));
        return this;
    }

    @Override // com.anychart.core.scatter.series.BaseWithMarkers, com.anychart.core.scatter.series.Base
    public Bubble error(Boolean bool) {
        APIlib.getInstance().addJSLine(String.format(Locale.US, this.jsBase + ".error(%s);", bool));
        return this;
    }

    @Override // com.anychart.core.scatter.series.BaseWithMarkers, com.anychart.core.scatter.series.Base
    public Bubble error(Number number) {
        APIlib.getInstance().addJSLine(String.format(Locale.US, this.jsBase + ".error(%s);", number));
        return this;
    }

    @Override // com.anychart.core.scatter.series.BaseWithMarkers, com.anychart.core.scatter.series.Base
    public void excludePoint(Number number) {
        APIlib.getInstance().addJSLine(String.format(Locale.US, this.jsBase + ".excludePoint(%s);", number));
    }

    @Override // com.anychart.core.scatter.series.BaseWithMarkers, com.anychart.core.scatter.series.Base
    public void excludePoint(Number[] numberArr) {
        APIlib.getInstance().addJSLine(String.format(Locale.US, this.jsBase + ".excludePoint(%s);", Arrays.toString(numberArr)));
    }

    public void fill() {
        APIlib.getInstance().addJSLine(this.jsBase + ".fill();");
    }

    public Bubble fill(Fill fill) {
        APIlib.getInstance().addJSLine(String.format(Locale.US, this.jsBase + ".fill(%s);", fill != null ? fill.getJsBase() : null));
        return this;
    }

    public Bubble fill(GradientKey gradientKey) {
        APIlib.getInstance().addJSLine(String.format(Locale.US, this.jsBase + ".fill(%s);", gradientKey != null ? gradientKey.getJsBase() : null));
        return this;
    }

    public Bubble fill(String[] strArr) {
        APIlib.getInstance().addJSLine(String.format(Locale.US, this.jsBase + ".fill(%s);", arrayToStringWrapQuotes(strArr)));
        return this;
    }

    public Bubble fill(String str, Number number) {
        APIlib.getInstance().addJSLine(String.format(Locale.US, this.jsBase + ".fill(%s, %s);", wrapQuotes(str), number));
        return this;
    }

    public Bubble fill(GradientKey gradientKey, Number number, Boolean bool, Number number2) {
        APIlib.getInstance().addJSLine(String.format(Locale.US, this.jsBase + ".fill(%s, %s, %s, %s);", gradientKey != null ? gradientKey.getJsBase() : null, number, bool, number2));
        return this;
    }

    public Bubble fill(GradientKey gradientKey, Number number, com.anychart.graphics.vector.Rect rect, Number number2) {
        APIlib.getInstance().addJSLine(String.format(Locale.US, this.jsBase + ".fill(%s, %s, %s, %s);", gradientKey != null ? gradientKey.getJsBase() : null, number, rect != null ? rect.getJsBase() : null, number2));
        return this;
    }

    public Bubble fill(GradientKey gradientKey, Number number, String str, Number number2) {
        APIlib.getInstance().addJSLine(String.format(Locale.US, this.jsBase + ".fill(%s, %s, %s, %s);", gradientKey != null ? gradientKey.getJsBase() : null, number, wrapQuotes(str), number2));
        return this;
    }

    public Bubble fill(String[] strArr, Number number, Boolean bool, Number number2) {
        APIlib.getInstance().addJSLine(String.format(Locale.US, this.jsBase + ".fill(%s, %s, %s, %s);", arrayToStringWrapQuotes(strArr), number, bool, number2));
        return this;
    }

    public Bubble fill(String[] strArr, Number number, com.anychart.graphics.vector.Rect rect, Number number2) {
        APIlib.getInstance().addJSLine(String.format(Locale.US, this.jsBase + ".fill(%s, %s, %s, %s);", arrayToStringWrapQuotes(strArr), number, rect != null ? rect.getJsBase() : null, number2));
        return this;
    }

    public Bubble fill(String[] strArr, Number number, String str, Number number2) {
        APIlib.getInstance().addJSLine(String.format(Locale.US, this.jsBase + ".fill(%s, %s, %s, %s);", arrayToStringWrapQuotes(strArr), number, wrapQuotes(str), number2));
        return this;
    }

    public Bubble fill(GradientKey gradientKey, Number number, Number number2, com.anychart.graphics.math.Rect rect, Number number3, Number number4, Number number5) {
        APIlib.getInstance().addJSLine(String.format(Locale.US, this.jsBase + ".fill(%s, %s, %s, %s, %s, %s, %s);", gradientKey != null ? gradientKey.getJsBase() : null, number, number2, rect != null ? rect.getJsBase() : null, number3, number4, number5));
        return this;
    }

    public Bubble fill(String[] strArr, Number number, Number number2, com.anychart.graphics.math.Rect rect, Number number3, Number number4, Number number5) {
        APIlib.getInstance().addJSLine(String.format(Locale.US, this.jsBase + ".fill(%s, %s, %s, %s, %s, %s, %s);", arrayToStringWrapQuotes(strArr), number, number2, rect != null ? rect.getJsBase() : null, number3, number4, number5));
        return this;
    }

    @Override // com.anychart.core.scatter.series.BaseWithMarkers, com.anychart.core.scatter.series.Base
    public void getExcludedPoints() {
        APIlib.getInstance().addJSLine(this.jsBase + ".getExcludedPoints();");
    }

    @Override // com.anychart.core.scatter.series.BaseWithMarkers, com.anychart.core.scatter.series.Base, com.anychart.core.SeriesBase, com.anychart.core.VisualBaseWithBounds
    public Rect getPixelBounds() {
        return new Rect(this.jsBase + ".getPixelBounds()");
    }

    @Override // com.anychart.core.scatter.series.BaseWithMarkers, com.anychart.core.scatter.series.Base, com.anychart.core.SeriesBase
    public SeriesPoint getPoint(Number number) {
        return new SeriesPoint(String.format(Locale.US, this.jsBase + ".getPoint(%s)", number));
    }

    @Override // com.anychart.core.scatter.series.BaseWithMarkers, com.anychart.core.scatter.series.Base, com.anychart.core.SeriesBase
    public void getStat(Statistics statistics) {
        APIlib.getInstance().addJSLine(String.format(Locale.US, this.jsBase + ".getStat(%s);", statistics != null ? statistics.getJsBase() : null));
    }

    @Override // com.anychart.core.scatter.series.BaseWithMarkers, com.anychart.core.scatter.series.Base, com.anychart.core.SeriesBase
    public void getStat(String str) {
        APIlib.getInstance().addJSLine(String.format(Locale.US, this.jsBase + ".getStat(%s);", wrapQuotes(str)));
    }

    public PatternFill hatchFill() {
        return new PatternFill(this.jsBase + ".hatchFill()");
    }

    public Bubble hatchFill(HatchFillType hatchFillType, String str, Number number, Number number2) {
        APIlib.getInstance().addJSLine(String.format(Locale.US, this.jsBase + ".hatchFill(%s, %s, %s, %s);", hatchFillType != null ? hatchFillType.getJsBase() : null, wrapQuotes(str), number, number2));
        return this;
    }

    public Bubble hatchFill(String str, String str2, Number number, Number number2) {
        APIlib.getInstance().addJSLine(String.format(Locale.US, this.jsBase + ".hatchFill(%s, %s, %s, %s);", wrapQuotes(str), wrapQuotes(str2), number, number2));
        return this;
    }

    public Bubble hatchFill(String str) {
        APIlib.getInstance().addJSLine(String.format(Locale.US, this.jsBase + ".hatchFill(%s);", wrapQuotes(str)));
        return this;
    }

    public Bubble hatchFill(PatternFill patternFill) {
        APIlib.getInstance().addJSLine(String.format(Locale.US, this.jsBase + ".hatchFill(%s);", patternFill != null ? patternFill.getJsBase() : null));
        return this;
    }

    public Bubble hatchFill(HatchFill hatchFill) {
        APIlib.getInstance().addJSLine(String.format(Locale.US, this.jsBase + ".hatchFill(%s);", hatchFill != null ? hatchFill.getJsBase() : null));
        return this;
    }

    public Bubble hatchFill(Boolean bool) {
        APIlib.getInstance().addJSLine(String.format(Locale.US, this.jsBase + ".hatchFill(%s);", bool));
        return this;
    }

    @Override // com.anychart.core.scatter.series.BaseWithMarkers, com.anychart.core.scatter.series.Base, com.anychart.core.SeriesBase, com.anychart.core.VisualBaseWithBounds
    public void height() {
        APIlib.getInstance().addJSLine(this.jsBase + ".height();");
    }

    @Override // com.anychart.core.scatter.series.BaseWithMarkers, com.anychart.core.scatter.series.Base, com.anychart.core.SeriesBase, com.anychart.core.VisualBaseWithBounds
    public Bubble height(Number number) {
        APIlib.getInstance().addJSLine(String.format(Locale.US, this.jsBase + ".height(%s);", number));
        return this;
    }

    @Override // com.anychart.core.scatter.series.BaseWithMarkers, com.anychart.core.scatter.series.Base, com.anychart.core.SeriesBase, com.anychart.core.VisualBaseWithBounds
    public Bubble height(String str) {
        APIlib.getInstance().addJSLine(String.format(Locale.US, this.jsBase + ".height(%s);", wrapQuotes(str)));
        return this;
    }

    @Override // com.anychart.core.scatter.series.BaseWithMarkers, com.anychart.core.scatter.series.Base, com.anychart.core.SeriesBase
    public Bubble hover() {
        APIlib.getInstance().addJSLine(this.jsBase + ".hover();");
        return this;
    }

    @Override // com.anychart.core.scatter.series.BaseWithMarkers, com.anychart.core.scatter.series.Base, com.anychart.core.SeriesBase
    public Bubble hover(Number number) {
        APIlib.getInstance().addJSLine(String.format(Locale.US, this.jsBase + ".hover(%s);", number));
        return this;
    }

    @Override // com.anychart.core.scatter.series.BaseWithMarkers, com.anychart.core.scatter.series.Base, com.anychart.core.SeriesBase
    public Bubble hover(Number[] numberArr) {
        APIlib.getInstance().addJSLine(String.format(Locale.US, this.jsBase + ".hover(%s);", Arrays.toString(numberArr)));
        return this;
    }

    @Override // com.anychart.core.scatter.series.BaseWithMarkers, com.anychart.core.scatter.series.Base, com.anychart.core.SeriesBase
    public StateSettings hovered() {
        return new StateSettings(this.jsBase + ".hovered()");
    }

    @Override // com.anychart.core.scatter.series.BaseWithMarkers, com.anychart.core.scatter.series.Base, com.anychart.core.SeriesBase
    public Bubble hovered(String str) {
        APIlib.getInstance().addJSLine(String.format(Locale.US, this.jsBase + ".hovered(%s);", wrapQuotes(str)));
        return this;
    }

    @Override // com.anychart.core.scatter.series.BaseWithMarkers, com.anychart.core.scatter.series.Base, com.anychart.core.SeriesBase
    public void id() {
        APIlib.getInstance().addJSLine(this.jsBase + ".id();");
    }

    @Override // com.anychart.core.scatter.series.BaseWithMarkers, com.anychart.core.scatter.series.Base, com.anychart.core.SeriesBase
    public Bubble id(String str) {
        APIlib.getInstance().addJSLine(String.format(Locale.US, this.jsBase + ".id(%s);", wrapQuotes(str)));
        return this;
    }

    @Override // com.anychart.core.scatter.series.BaseWithMarkers, com.anychart.core.scatter.series.Base, com.anychart.core.SeriesBase
    public Bubble id(Number number) {
        APIlib.getInstance().addJSLine(String.format(Locale.US, this.jsBase + ".id(%s);", number));
        return this;
    }

    @Override // com.anychart.core.scatter.series.BaseWithMarkers, com.anychart.core.scatter.series.Base
    public void includeAllPoints() {
        APIlib.getInstance().addJSLine(this.jsBase + ".includeAllPoints();");
    }

    @Override // com.anychart.core.scatter.series.BaseWithMarkers, com.anychart.core.scatter.series.Base
    public void includePoint(Number number) {
        APIlib.getInstance().addJSLine(String.format(Locale.US, this.jsBase + ".includePoint(%s);", number));
    }

    @Override // com.anychart.core.scatter.series.BaseWithMarkers, com.anychart.core.scatter.series.Base
    public void includePoint(Number[] numberArr) {
        APIlib.getInstance().addJSLine(String.format(Locale.US, this.jsBase + ".includePoint(%s);", Arrays.toString(numberArr)));
    }

    @Override // com.anychart.core.scatter.series.BaseWithMarkers, com.anychart.core.scatter.series.Base
    public void keepOnlyPoints(Number number) {
        APIlib.getInstance().addJSLine(String.format(Locale.US, this.jsBase + ".keepOnlyPoints(%s);", number));
    }

    @Override // com.anychart.core.scatter.series.BaseWithMarkers, com.anychart.core.scatter.series.Base
    public void keepOnlyPoints(Number[] numberArr) {
        APIlib.getInstance().addJSLine(String.format(Locale.US, this.jsBase + ".keepOnlyPoints(%s);", Arrays.toString(numberArr)));
    }

    @Override // com.anychart.core.scatter.series.BaseWithMarkers, com.anychart.core.scatter.series.Base, com.anychart.core.SeriesBase
    public LabelsFactory labels() {
        return new LabelsFactory(this.jsBase + ".labels()");
    }

    @Override // com.anychart.core.scatter.series.BaseWithMarkers, com.anychart.core.scatter.series.Base, com.anychart.core.SeriesBase
    public Bubble labels(String str) {
        APIlib.getInstance().addJSLine(String.format(Locale.US, this.jsBase + ".labels(%s);", wrapQuotes(str)));
        return this;
    }

    @Override // com.anychart.core.scatter.series.BaseWithMarkers, com.anychart.core.scatter.series.Base, com.anychart.core.SeriesBase
    public Bubble labels(Boolean bool) {
        APIlib.getInstance().addJSLine(String.format(Locale.US, this.jsBase + ".labels(%s);", bool));
        return this;
    }

    @Override // com.anychart.core.scatter.series.BaseWithMarkers, com.anychart.core.scatter.series.Base, com.anychart.core.SeriesBase, com.anychart.core.VisualBaseWithBounds
    public void left() {
        APIlib.getInstance().addJSLine(this.jsBase + ".left();");
    }

    @Override // com.anychart.core.scatter.series.BaseWithMarkers, com.anychart.core.scatter.series.Base, com.anychart.core.SeriesBase, com.anychart.core.VisualBaseWithBounds
    public Bubble left(Number number) {
        APIlib.getInstance().addJSLine(String.format(Locale.US, this.jsBase + ".left(%s);", number));
        return this;
    }

    @Override // com.anychart.core.scatter.series.BaseWithMarkers, com.anychart.core.scatter.series.Base, com.anychart.core.SeriesBase, com.anychart.core.VisualBaseWithBounds
    public Bubble left(String str) {
        APIlib.getInstance().addJSLine(String.format(Locale.US, this.jsBase + ".left(%s);", wrapQuotes(str)));
        return this;
    }

    @Override // com.anychart.core.scatter.series.BaseWithMarkers, com.anychart.core.scatter.series.Base, com.anychart.core.SeriesBase
    public LegendItemSettings legendItem() {
        return new LegendItemSettings(this.jsBase + ".legendItem()");
    }

    @Override // com.anychart.core.scatter.series.BaseWithMarkers, com.anychart.core.scatter.series.Base, com.anychart.core.SeriesBase
    public Bubble legendItem(String str) {
        APIlib.getInstance().addJSLine(String.format(Locale.US, this.jsBase + ".legendItem(%s);", wrapQuotes(str)));
        return this;
    }

    @Override // com.anychart.core.scatter.series.BaseWithMarkers, com.anychart.core.scatter.series.Base, com.anychart.core.SeriesBase
    public MarkersFactory markers() {
        return new MarkersFactory(this.jsBase + ".markers()");
    }

    @Override // com.anychart.core.scatter.series.BaseWithMarkers, com.anychart.core.scatter.series.Base, com.anychart.core.SeriesBase
    public Bubble markers(String str) {
        APIlib.getInstance().addJSLine(String.format(Locale.US, this.jsBase + ".markers(%s);", wrapQuotes(str)));
        return this;
    }

    @Override // com.anychart.core.scatter.series.BaseWithMarkers, com.anychart.core.scatter.series.Base, com.anychart.core.SeriesBase
    public Bubble markers(Boolean bool) {
        APIlib.getInstance().addJSLine(String.format(Locale.US, this.jsBase + ".markers(%s);", bool));
        return this;
    }

    @Override // com.anychart.core.scatter.series.BaseWithMarkers, com.anychart.core.scatter.series.Base, com.anychart.core.SeriesBase, com.anychart.core.VisualBaseWithBounds
    public void maxHeight() {
        APIlib.getInstance().addJSLine(this.jsBase + ".maxHeight();");
    }

    @Override // com.anychart.core.scatter.series.BaseWithMarkers, com.anychart.core.scatter.series.Base, com.anychart.core.SeriesBase, com.anychart.core.VisualBaseWithBounds
    public Bubble maxHeight(Number number) {
        APIlib.getInstance().addJSLine(String.format(Locale.US, this.jsBase + ".maxHeight(%s);", number));
        return this;
    }

    @Override // com.anychart.core.scatter.series.BaseWithMarkers, com.anychart.core.scatter.series.Base, com.anychart.core.SeriesBase, com.anychart.core.VisualBaseWithBounds
    public Bubble maxHeight(String str) {
        APIlib.getInstance().addJSLine(String.format(Locale.US, this.jsBase + ".maxHeight(%s);", wrapQuotes(str)));
        return this;
    }

    @Override // com.anychart.core.scatter.series.BaseWithMarkers, com.anychart.core.scatter.series.Base, com.anychart.core.SeriesBase, com.anychart.core.VisualBaseWithBounds
    public void maxWidth() {
        APIlib.getInstance().addJSLine(this.jsBase + ".maxWidth();");
    }

    @Override // com.anychart.core.scatter.series.BaseWithMarkers, com.anychart.core.scatter.series.Base, com.anychart.core.SeriesBase, com.anychart.core.VisualBaseWithBounds
    public Bubble maxWidth(Number number) {
        APIlib.getInstance().addJSLine(String.format(Locale.US, this.jsBase + ".maxWidth(%s);", number));
        return this;
    }

    @Override // com.anychart.core.scatter.series.BaseWithMarkers, com.anychart.core.scatter.series.Base, com.anychart.core.SeriesBase, com.anychart.core.VisualBaseWithBounds
    public Bubble maxWidth(String str) {
        APIlib.getInstance().addJSLine(String.format(Locale.US, this.jsBase + ".maxWidth(%s);", wrapQuotes(str)));
        return this;
    }

    @Override // com.anychart.core.scatter.series.BaseWithMarkers, com.anychart.core.scatter.series.Base, com.anychart.core.SeriesBase
    public void meta(String str) {
        APIlib.getInstance().addJSLine(String.format(Locale.US, this.jsBase + ".meta(%s);", wrapQuotes(str)));
    }

    @Override // com.anychart.core.scatter.series.BaseWithMarkers, com.anychart.core.scatter.series.Base, com.anychart.core.SeriesBase
    public Bubble meta(String str, String str2) {
        APIlib.getInstance().addJSLine(String.format(Locale.US, this.jsBase + ".meta(%s, %s);", wrapQuotes(str), wrapQuotes(str2)));
        return this;
    }

    @Override // com.anychart.core.scatter.series.BaseWithMarkers, com.anychart.core.scatter.series.Base, com.anychart.core.SeriesBase, com.anychart.core.VisualBaseWithBounds
    public void minHeight() {
        APIlib.getInstance().addJSLine(this.jsBase + ".minHeight();");
    }

    @Override // com.anychart.core.scatter.series.BaseWithMarkers, com.anychart.core.scatter.series.Base, com.anychart.core.SeriesBase, com.anychart.core.VisualBaseWithBounds
    public Bubble minHeight(Number number) {
        APIlib.getInstance().addJSLine(String.format(Locale.US, this.jsBase + ".minHeight(%s);", number));
        return this;
    }

    @Override // com.anychart.core.scatter.series.BaseWithMarkers, com.anychart.core.scatter.series.Base, com.anychart.core.SeriesBase, com.anychart.core.VisualBaseWithBounds
    public Bubble minHeight(String str) {
        APIlib.getInstance().addJSLine(String.format(Locale.US, this.jsBase + ".minHeight(%s);", wrapQuotes(str)));
        return this;
    }

    @Override // com.anychart.core.scatter.series.BaseWithMarkers, com.anychart.core.scatter.series.Base, com.anychart.core.SeriesBase, com.anychart.core.VisualBaseWithBounds
    public void minWidth() {
        APIlib.getInstance().addJSLine(this.jsBase + ".minWidth();");
    }

    @Override // com.anychart.core.scatter.series.BaseWithMarkers, com.anychart.core.scatter.series.Base, com.anychart.core.SeriesBase, com.anychart.core.VisualBaseWithBounds
    public Bubble minWidth(Number number) {
        APIlib.getInstance().addJSLine(String.format(Locale.US, this.jsBase + ".minWidth(%s);", number));
        return this;
    }

    @Override // com.anychart.core.scatter.series.BaseWithMarkers, com.anychart.core.scatter.series.Base, com.anychart.core.SeriesBase, com.anychart.core.VisualBaseWithBounds
    public Bubble minWidth(String str) {
        APIlib.getInstance().addJSLine(String.format(Locale.US, this.jsBase + ".minWidth(%s);", wrapQuotes(str)));
        return this;
    }

    @Override // com.anychart.core.scatter.series.BaseWithMarkers, com.anychart.core.scatter.series.Base, com.anychart.core.SeriesBase
    public void name() {
        APIlib.getInstance().addJSLine(this.jsBase + ".name();");
    }

    @Override // com.anychart.core.scatter.series.BaseWithMarkers, com.anychart.core.scatter.series.Base, com.anychart.core.SeriesBase
    public Bubble name(String str) {
        APIlib.getInstance().addJSLine(String.format(Locale.US, this.jsBase + ".name(%s);", wrapQuotes(str)));
        return this;
    }

    public void negativeFill() {
        APIlib.getInstance().addJSLine(this.jsBase + ".negativeFill();");
    }

    public Bubble negativeFill(Fill fill) {
        APIlib.getInstance().addJSLine(String.format(Locale.US, this.jsBase + ".negativeFill(%s);", fill != null ? fill.getJsBase() : null));
        return this;
    }

    public Bubble negativeFill(GradientKey gradientKey) {
        APIlib.getInstance().addJSLine(String.format(Locale.US, this.jsBase + ".negativeFill(%s);", gradientKey != null ? gradientKey.getJsBase() : null));
        return this;
    }

    public Bubble negativeFill(String[] strArr) {
        APIlib.getInstance().addJSLine(String.format(Locale.US, this.jsBase + ".negativeFill(%s);", arrayToStringWrapQuotes(strArr)));
        return this;
    }

    public Bubble negativeFill(String str, Number number) {
        APIlib.getInstance().addJSLine(String.format(Locale.US, this.jsBase + ".negativeFill(%s, %s);", wrapQuotes(str), number));
        return this;
    }

    public Bubble negativeFill(GradientKey gradientKey, Number number, Boolean bool, Number number2) {
        APIlib.getInstance().addJSLine(String.format(Locale.US, this.jsBase + ".negativeFill(%s, %s, %s, %s);", gradientKey != null ? gradientKey.getJsBase() : null, number, bool, number2));
        return this;
    }

    public Bubble negativeFill(GradientKey gradientKey, Number number, com.anychart.graphics.vector.Rect rect, Number number2) {
        APIlib.getInstance().addJSLine(String.format(Locale.US, this.jsBase + ".negativeFill(%s, %s, %s, %s);", gradientKey != null ? gradientKey.getJsBase() : null, number, rect != null ? rect.getJsBase() : null, number2));
        return this;
    }

    public Bubble negativeFill(GradientKey gradientKey, Number number, String str, Number number2) {
        APIlib.getInstance().addJSLine(String.format(Locale.US, this.jsBase + ".negativeFill(%s, %s, %s, %s);", gradientKey != null ? gradientKey.getJsBase() : null, number, wrapQuotes(str), number2));
        return this;
    }

    public Bubble negativeFill(String[] strArr, Number number, Boolean bool, Number number2) {
        APIlib.getInstance().addJSLine(String.format(Locale.US, this.jsBase + ".negativeFill(%s, %s, %s, %s);", arrayToStringWrapQuotes(strArr), number, bool, number2));
        return this;
    }

    public Bubble negativeFill(String[] strArr, Number number, com.anychart.graphics.vector.Rect rect, Number number2) {
        APIlib.getInstance().addJSLine(String.format(Locale.US, this.jsBase + ".negativeFill(%s, %s, %s, %s);", arrayToStringWrapQuotes(strArr), number, rect != null ? rect.getJsBase() : null, number2));
        return this;
    }

    public Bubble negativeFill(String[] strArr, Number number, String str, Number number2) {
        APIlib.getInstance().addJSLine(String.format(Locale.US, this.jsBase + ".negativeFill(%s, %s, %s, %s);", arrayToStringWrapQuotes(strArr), number, wrapQuotes(str), number2));
        return this;
    }

    public Bubble negativeFill(GradientKey gradientKey, Number number, Number number2, com.anychart.graphics.math.Rect rect, Number number3, Number number4, Number number5) {
        APIlib.getInstance().addJSLine(String.format(Locale.US, this.jsBase + ".negativeFill(%s, %s, %s, %s, %s, %s, %s);", gradientKey != null ? gradientKey.getJsBase() : null, number, number2, rect != null ? rect.getJsBase() : null, number3, number4, number5));
        return this;
    }

    public Bubble negativeFill(String[] strArr, Number number, Number number2, com.anychart.graphics.math.Rect rect, Number number3, Number number4, Number number5) {
        APIlib.getInstance().addJSLine(String.format(Locale.US, this.jsBase + ".negativeFill(%s, %s, %s, %s, %s, %s, %s);", arrayToStringWrapQuotes(strArr), number, number2, rect != null ? rect.getJsBase() : null, number3, number4, number5));
        return this;
    }

    public PatternFill negativeHatchFill() {
        return new PatternFill(this.jsBase + ".negativeHatchFill()");
    }

    public Bubble negativeHatchFill(HatchFillType hatchFillType, String str, Number number, Number number2) {
        APIlib.getInstance().addJSLine(String.format(Locale.US, this.jsBase + ".negativeHatchFill(%s, %s, %s, %s);", hatchFillType != null ? hatchFillType.getJsBase() : null, wrapQuotes(str), number, number2));
        return this;
    }

    public Bubble negativeHatchFill(String str, String str2, Number number, Number number2) {
        APIlib.getInstance().addJSLine(String.format(Locale.US, this.jsBase + ".negativeHatchFill(%s, %s, %s, %s);", wrapQuotes(str), wrapQuotes(str2), number, number2));
        return this;
    }

    public Bubble negativeHatchFill(String str) {
        APIlib.getInstance().addJSLine(String.format(Locale.US, this.jsBase + ".negativeHatchFill(%s);", wrapQuotes(str)));
        return this;
    }

    public Bubble negativeHatchFill(PatternFill patternFill) {
        APIlib.getInstance().addJSLine(String.format(Locale.US, this.jsBase + ".negativeHatchFill(%s);", patternFill != null ? patternFill.getJsBase() : null));
        return this;
    }

    public Bubble negativeHatchFill(HatchFill hatchFill) {
        APIlib.getInstance().addJSLine(String.format(Locale.US, this.jsBase + ".negativeHatchFill(%s);", hatchFill != null ? hatchFill.getJsBase() : null));
        return this;
    }

    public Bubble negativeHatchFill(Boolean bool) {
        APIlib.getInstance().addJSLine(String.format(Locale.US, this.jsBase + ".negativeHatchFill(%s);", bool));
        return this;
    }

    public void negativeStroke() {
        APIlib.getInstance().addJSLine(this.jsBase + ".negativeStroke();");
    }

    public Bubble negativeStroke(Stroke stroke, Number number, String str, String str2, String str3) {
        APIlib.getInstance().addJSLine(String.format(Locale.US, this.jsBase + ".negativeStroke(%s, %s, %s, %s, %s);", stroke != null ? stroke.getJsBase() : null, number, wrapQuotes(str), wrapQuotes(str2), wrapQuotes(str3)));
        return this;
    }

    public Bubble negativeStroke(Stroke stroke, Number number, String str, String str2, StrokeLineCap strokeLineCap) {
        APIlib.getInstance().addJSLine(String.format(Locale.US, this.jsBase + ".negativeStroke(%s, %s, %s, %s, %s);", stroke != null ? stroke.getJsBase() : null, number, wrapQuotes(str), wrapQuotes(str2), strokeLineCap != null ? strokeLineCap.getJsBase() : null));
        return this;
    }

    public Bubble negativeStroke(Stroke stroke, Number number, String str, StrokeLineJoin strokeLineJoin, String str2) {
        APIlib.getInstance().addJSLine(String.format(Locale.US, this.jsBase + ".negativeStroke(%s, %s, %s, %s, %s);", stroke != null ? stroke.getJsBase() : null, number, wrapQuotes(str), strokeLineJoin != null ? strokeLineJoin.getJsBase() : null, wrapQuotes(str2)));
        return this;
    }

    public Bubble negativeStroke(Stroke stroke, Number number, String str, StrokeLineJoin strokeLineJoin, StrokeLineCap strokeLineCap) {
        APIlib.getInstance().addJSLine(String.format(Locale.US, this.jsBase + ".negativeStroke(%s, %s, %s, %s, %s);", stroke != null ? stroke.getJsBase() : null, number, wrapQuotes(str), strokeLineJoin != null ? strokeLineJoin.getJsBase() : null, strokeLineCap != null ? strokeLineCap.getJsBase() : null));
        return this;
    }

    public Bubble negativeStroke(ColoredFill coloredFill, Number number, String str, String str2, String str3) {
        APIlib.getInstance().addJSLine(String.format(Locale.US, this.jsBase + ".negativeStroke(%s, %s, %s, %s, %s);", coloredFill != null ? coloredFill.getJsBase() : null, number, wrapQuotes(str), wrapQuotes(str2), wrapQuotes(str3)));
        return this;
    }

    public Bubble negativeStroke(ColoredFill coloredFill, Number number, String str, String str2, StrokeLineCap strokeLineCap) {
        APIlib.getInstance().addJSLine(String.format(Locale.US, this.jsBase + ".negativeStroke(%s, %s, %s, %s, %s);", coloredFill != null ? coloredFill.getJsBase() : null, number, wrapQuotes(str), wrapQuotes(str2), strokeLineCap != null ? strokeLineCap.getJsBase() : null));
        return this;
    }

    public Bubble negativeStroke(ColoredFill coloredFill, Number number, String str, StrokeLineJoin strokeLineJoin, String str2) {
        APIlib.getInstance().addJSLine(String.format(Locale.US, this.jsBase + ".negativeStroke(%s, %s, %s, %s, %s);", coloredFill != null ? coloredFill.getJsBase() : null, number, wrapQuotes(str), strokeLineJoin != null ? strokeLineJoin.getJsBase() : null, wrapQuotes(str2)));
        return this;
    }

    public Bubble negativeStroke(ColoredFill coloredFill, Number number, String str, StrokeLineJoin strokeLineJoin, StrokeLineCap strokeLineCap) {
        APIlib.getInstance().addJSLine(String.format(Locale.US, this.jsBase + ".negativeStroke(%s, %s, %s, %s, %s);", coloredFill != null ? coloredFill.getJsBase() : null, number, wrapQuotes(str), strokeLineJoin != null ? strokeLineJoin.getJsBase() : null, strokeLineCap != null ? strokeLineCap.getJsBase() : null));
        return this;
    }

    public Bubble negativeStroke(String str, Number number, String str2, String str3, String str4) {
        APIlib.getInstance().addJSLine(String.format(Locale.US, this.jsBase + ".negativeStroke(%s, %s, %s, %s, %s);", wrapQuotes(str), number, wrapQuotes(str2), wrapQuotes(str3), wrapQuotes(str4)));
        return this;
    }

    public Bubble negativeStroke(String str, Number number, String str2, String str3, StrokeLineCap strokeLineCap) {
        APIlib.getInstance().addJSLine(String.format(Locale.US, this.jsBase + ".negativeStroke(%s, %s, %s, %s, %s);", wrapQuotes(str), number, wrapQuotes(str2), wrapQuotes(str3), strokeLineCap != null ? strokeLineCap.getJsBase() : null));
        return this;
    }

    public Bubble negativeStroke(String str, Number number, String str2, StrokeLineJoin strokeLineJoin, String str3) {
        APIlib.getInstance().addJSLine(String.format(Locale.US, this.jsBase + ".negativeStroke(%s, %s, %s, %s, %s);", wrapQuotes(str), number, wrapQuotes(str2), strokeLineJoin != null ? strokeLineJoin.getJsBase() : null, wrapQuotes(str3)));
        return this;
    }

    public Bubble negativeStroke(String str, Number number, String str2, StrokeLineJoin strokeLineJoin, StrokeLineCap strokeLineCap) {
        APIlib.getInstance().addJSLine(String.format(Locale.US, this.jsBase + ".negativeStroke(%s, %s, %s, %s, %s);", wrapQuotes(str), number, wrapQuotes(str2), strokeLineJoin != null ? strokeLineJoin.getJsBase() : null, strokeLineCap != null ? strokeLineCap.getJsBase() : null));
        return this;
    }

    public Bubble negativeStroke(String str) {
        APIlib.getInstance().addJSLine(String.format(Locale.US, this.jsBase + ".negativeStroke(%s);", wrapQuotes(str)));
        return this;
    }

    @Override // com.anychart.core.scatter.series.BaseWithMarkers, com.anychart.core.scatter.series.Base, com.anychart.core.SeriesBase
    public StateSettings normal() {
        return new StateSettings(this.jsBase + ".normal()");
    }

    @Override // com.anychart.core.scatter.series.BaseWithMarkers, com.anychart.core.scatter.series.Base, com.anychart.core.SeriesBase
    public Bubble normal(String str) {
        APIlib.getInstance().addJSLine(String.format(Locale.US, this.jsBase + ".normal(%s);", wrapQuotes(str)));
        return this;
    }

    @Override // com.anychart.core.scatter.series.BaseWithMarkers, com.anychart.core.scatter.series.Base, com.anychart.core.SeriesBase, com.anychart.core.VisualBaseWithBounds, com.anychart.core.VisualBase
    public void print(PaperSize paperSize, Boolean bool) {
        APIlib.getInstance().addJSLine(String.format(Locale.US, this.jsBase + ".print(%s, %s);", paperSize != null ? paperSize.getJsBase() : null, bool));
    }

    @Override // com.anychart.core.scatter.series.BaseWithMarkers, com.anychart.core.scatter.series.Base, com.anychart.core.SeriesBase, com.anychart.core.VisualBaseWithBounds, com.anychart.core.VisualBase
    public void print(String str, Boolean bool) {
        APIlib.getInstance().addJSLine(String.format(Locale.US, this.jsBase + ".print(%s, %s);", wrapQuotes(str), bool));
    }

    @Override // com.anychart.core.scatter.series.BaseWithMarkers, com.anychart.core.scatter.series.Base, com.anychart.core.SeriesBase, com.anychart.core.VisualBaseWithBounds, com.anychart.core.VisualBase, com.anychart.core.Base
    public void removeAllListeners(String str) {
        APIlib.getInstance().addJSLine(String.format(Locale.US, this.jsBase + ".removeAllListeners(%s);", wrapQuotes(str)));
    }

    @Override // com.anychart.core.scatter.series.BaseWithMarkers, com.anychart.core.scatter.series.Base, com.anychart.core.SeriesBase, com.anychart.core.VisualBaseWithBounds
    public void right() {
        APIlib.getInstance().addJSLine(this.jsBase + ".right();");
    }

    @Override // com.anychart.core.scatter.series.BaseWithMarkers, com.anychart.core.scatter.series.Base, com.anychart.core.SeriesBase, com.anychart.core.VisualBaseWithBounds
    public Bubble right(Number number) {
        APIlib.getInstance().addJSLine(String.format(Locale.US, this.jsBase + ".right(%s);", number));
        return this;
    }

    @Override // com.anychart.core.scatter.series.BaseWithMarkers, com.anychart.core.scatter.series.Base, com.anychart.core.SeriesBase, com.anychart.core.VisualBaseWithBounds
    public Bubble right(String str) {
        APIlib.getInstance().addJSLine(String.format(Locale.US, this.jsBase + ".right(%s);", wrapQuotes(str)));
        return this;
    }

    @Override // com.anychart.core.scatter.series.BaseWithMarkers, com.anychart.core.scatter.series.Base, com.anychart.core.SeriesBase
    public Bubble select(Number number) {
        APIlib.getInstance().addJSLine(String.format(Locale.US, this.jsBase + ".select(%s);", number));
        return this;
    }

    @Override // com.anychart.core.scatter.series.BaseWithMarkers, com.anychart.core.scatter.series.Base, com.anychart.core.SeriesBase
    public Bubble select(Number[] numberArr) {
        APIlib.getInstance().addJSLine(String.format(Locale.US, this.jsBase + ".select(%s);", Arrays.toString(numberArr)));
        return this;
    }

    @Override // com.anychart.core.scatter.series.BaseWithMarkers, com.anychart.core.scatter.series.Base, com.anychart.core.SeriesBase
    public StateSettings selected() {
        return new StateSettings(this.jsBase + ".selected()");
    }

    @Override // com.anychart.core.scatter.series.BaseWithMarkers, com.anychart.core.scatter.series.Base, com.anychart.core.SeriesBase
    public Bubble selected(String str) {
        APIlib.getInstance().addJSLine(String.format(Locale.US, this.jsBase + ".selected(%s);", wrapQuotes(str)));
        return this;
    }

    @Override // com.anychart.core.scatter.series.BaseWithMarkers, com.anychart.core.scatter.series.Base, com.anychart.core.SeriesBase
    public void selectionMode() {
        APIlib.getInstance().addJSLine(this.jsBase + ".selectionMode();");
    }

    @Override // com.anychart.core.scatter.series.BaseWithMarkers, com.anychart.core.scatter.series.Base, com.anychart.core.SeriesBase
    public Bubble selectionMode(SelectionMode selectionMode) {
        APIlib.getInstance().addJSLine(String.format(Locale.US, this.jsBase + ".selectionMode(%s);", selectionMode != null ? selectionMode.getJsBase() : null));
        return this;
    }

    @Override // com.anychart.core.scatter.series.BaseWithMarkers, com.anychart.core.scatter.series.Base, com.anychart.core.SeriesBase
    public Bubble selectionMode(String str) {
        APIlib.getInstance().addJSLine(String.format(Locale.US, this.jsBase + ".selectionMode(%s);", wrapQuotes(str)));
        return this;
    }

    public void stroke() {
        APIlib.getInstance().addJSLine(this.jsBase + ".stroke();");
    }

    public Bubble stroke(Stroke stroke, Number number, String str, String str2, String str3) {
        APIlib.getInstance().addJSLine(String.format(Locale.US, this.jsBase + ".stroke(%s, %s, %s, %s, %s);", stroke != null ? stroke.getJsBase() : null, number, wrapQuotes(str), wrapQuotes(str2), wrapQuotes(str3)));
        return this;
    }

    public Bubble stroke(Stroke stroke, Number number, String str, String str2, StrokeLineCap strokeLineCap) {
        APIlib.getInstance().addJSLine(String.format(Locale.US, this.jsBase + ".stroke(%s, %s, %s, %s, %s);", stroke != null ? stroke.getJsBase() : null, number, wrapQuotes(str), wrapQuotes(str2), strokeLineCap != null ? strokeLineCap.getJsBase() : null));
        return this;
    }

    public Bubble stroke(Stroke stroke, Number number, String str, StrokeLineJoin strokeLineJoin, String str2) {
        APIlib.getInstance().addJSLine(String.format(Locale.US, this.jsBase + ".stroke(%s, %s, %s, %s, %s);", stroke != null ? stroke.getJsBase() : null, number, wrapQuotes(str), strokeLineJoin != null ? strokeLineJoin.getJsBase() : null, wrapQuotes(str2)));
        return this;
    }

    public Bubble stroke(Stroke stroke, Number number, String str, StrokeLineJoin strokeLineJoin, StrokeLineCap strokeLineCap) {
        APIlib.getInstance().addJSLine(String.format(Locale.US, this.jsBase + ".stroke(%s, %s, %s, %s, %s);", stroke != null ? stroke.getJsBase() : null, number, wrapQuotes(str), strokeLineJoin != null ? strokeLineJoin.getJsBase() : null, strokeLineCap != null ? strokeLineCap.getJsBase() : null));
        return this;
    }

    public Bubble stroke(ColoredFill coloredFill, Number number, String str, String str2, String str3) {
        APIlib.getInstance().addJSLine(String.format(Locale.US, this.jsBase + ".stroke(%s, %s, %s, %s, %s);", coloredFill != null ? coloredFill.getJsBase() : null, number, wrapQuotes(str), wrapQuotes(str2), wrapQuotes(str3)));
        return this;
    }

    public Bubble stroke(ColoredFill coloredFill, Number number, String str, String str2, StrokeLineCap strokeLineCap) {
        APIlib.getInstance().addJSLine(String.format(Locale.US, this.jsBase + ".stroke(%s, %s, %s, %s, %s);", coloredFill != null ? coloredFill.getJsBase() : null, number, wrapQuotes(str), wrapQuotes(str2), strokeLineCap != null ? strokeLineCap.getJsBase() : null));
        return this;
    }

    public Bubble stroke(ColoredFill coloredFill, Number number, String str, StrokeLineJoin strokeLineJoin, String str2) {
        APIlib.getInstance().addJSLine(String.format(Locale.US, this.jsBase + ".stroke(%s, %s, %s, %s, %s);", coloredFill != null ? coloredFill.getJsBase() : null, number, wrapQuotes(str), strokeLineJoin != null ? strokeLineJoin.getJsBase() : null, wrapQuotes(str2)));
        return this;
    }

    public Bubble stroke(ColoredFill coloredFill, Number number, String str, StrokeLineJoin strokeLineJoin, StrokeLineCap strokeLineCap) {
        APIlib.getInstance().addJSLine(String.format(Locale.US, this.jsBase + ".stroke(%s, %s, %s, %s, %s);", coloredFill != null ? coloredFill.getJsBase() : null, number, wrapQuotes(str), strokeLineJoin != null ? strokeLineJoin.getJsBase() : null, strokeLineCap != null ? strokeLineCap.getJsBase() : null));
        return this;
    }

    public Bubble stroke(String str, Number number, String str2, String str3, String str4) {
        APIlib.getInstance().addJSLine(String.format(Locale.US, this.jsBase + ".stroke(%s, %s, %s, %s, %s);", wrapQuotes(str), number, wrapQuotes(str2), wrapQuotes(str3), wrapQuotes(str4)));
        return this;
    }

    public Bubble stroke(String str, Number number, String str2, String str3, StrokeLineCap strokeLineCap) {
        APIlib.getInstance().addJSLine(String.format(Locale.US, this.jsBase + ".stroke(%s, %s, %s, %s, %s);", wrapQuotes(str), number, wrapQuotes(str2), wrapQuotes(str3), strokeLineCap != null ? strokeLineCap.getJsBase() : null));
        return this;
    }

    public Bubble stroke(String str, Number number, String str2, StrokeLineJoin strokeLineJoin, String str3) {
        APIlib.getInstance().addJSLine(String.format(Locale.US, this.jsBase + ".stroke(%s, %s, %s, %s, %s);", wrapQuotes(str), number, wrapQuotes(str2), strokeLineJoin != null ? strokeLineJoin.getJsBase() : null, wrapQuotes(str3)));
        return this;
    }

    public Bubble stroke(String str, Number number, String str2, StrokeLineJoin strokeLineJoin, StrokeLineCap strokeLineCap) {
        APIlib.getInstance().addJSLine(String.format(Locale.US, this.jsBase + ".stroke(%s, %s, %s, %s, %s);", wrapQuotes(str), number, wrapQuotes(str2), strokeLineJoin != null ? strokeLineJoin.getJsBase() : null, strokeLineCap != null ? strokeLineCap.getJsBase() : null));
        return this;
    }

    public Bubble stroke(String str) {
        APIlib.getInstance().addJSLine(String.format(Locale.US, this.jsBase + ".stroke(%s);", wrapQuotes(str)));
        return this;
    }

    @Override // com.anychart.core.scatter.series.BaseWithMarkers, com.anychart.core.scatter.series.Base, com.anychart.core.SeriesBase
    public Tooltip tooltip() {
        return new Tooltip(this.jsBase + ".tooltip()");
    }

    @Override // com.anychart.core.scatter.series.BaseWithMarkers, com.anychart.core.scatter.series.Base, com.anychart.core.SeriesBase
    public Bubble tooltip(String str) {
        APIlib.getInstance().addJSLine(String.format(Locale.US, this.jsBase + ".tooltip(%s);", wrapQuotes(str)));
        return this;
    }

    @Override // com.anychart.core.scatter.series.BaseWithMarkers, com.anychart.core.scatter.series.Base, com.anychart.core.SeriesBase
    public Bubble tooltip(Boolean bool) {
        APIlib.getInstance().addJSLine(String.format(Locale.US, this.jsBase + ".tooltip(%s);", bool));
        return this;
    }

    @Override // com.anychart.core.scatter.series.BaseWithMarkers, com.anychart.core.scatter.series.Base, com.anychart.core.SeriesBase, com.anychart.core.VisualBaseWithBounds
    public void top() {
        APIlib.getInstance().addJSLine(this.jsBase + ".top();");
    }

    @Override // com.anychart.core.scatter.series.BaseWithMarkers, com.anychart.core.scatter.series.Base, com.anychart.core.SeriesBase, com.anychart.core.VisualBaseWithBounds
    public Bubble top(Number number) {
        APIlib.getInstance().addJSLine(String.format(Locale.US, this.jsBase + ".top(%s);", number));
        return this;
    }

    @Override // com.anychart.core.scatter.series.BaseWithMarkers, com.anychart.core.scatter.series.Base, com.anychart.core.SeriesBase, com.anychart.core.VisualBaseWithBounds
    public Bubble top(String str) {
        APIlib.getInstance().addJSLine(String.format(Locale.US, this.jsBase + ".top(%s);", wrapQuotes(str)));
        return this;
    }

    @Override // com.anychart.core.scatter.series.BaseWithMarkers, com.anychart.core.scatter.series.Base
    public void transformX(String str) {
        APIlib.getInstance().addJSLine(String.format(Locale.US, this.jsBase + ".transformX(%s);", wrapQuotes(str)));
    }

    @Override // com.anychart.core.scatter.series.BaseWithMarkers, com.anychart.core.scatter.series.Base
    public void transformY(String str) {
        APIlib.getInstance().addJSLine(String.format(Locale.US, this.jsBase + ".transformY(%s);", wrapQuotes(str)));
    }

    public Bubble unhover() {
        APIlib.getInstance().addJSLine(this.jsBase + ".unhover();");
        return this;
    }

    @Override // com.anychart.core.scatter.series.BaseWithMarkers, com.anychart.core.scatter.series.Base, com.anychart.core.SeriesBase, com.anychart.core.VisualBaseWithBounds, com.anychart.core.VisualBase, com.anychart.core.Base
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

    @Override // com.anychart.core.scatter.series.BaseWithMarkers, com.anychart.core.scatter.series.Base, com.anychart.core.SeriesBase, com.anychart.core.VisualBaseWithBounds, com.anychart.core.VisualBase, com.anychart.core.Base
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

    @Override // com.anychart.core.scatter.series.BaseWithMarkers, com.anychart.core.scatter.series.Base, com.anychart.core.SeriesBase, com.anychart.core.VisualBaseWithBounds, com.anychart.core.VisualBase, com.anychart.core.Base
    public void unlistenByKey(String str) {
        APIlib.getInstance().addJSLine(String.format(Locale.US, this.jsBase + ".unlistenByKey(%s);", wrapQuotes(str)));
    }

    @Override // com.anychart.core.scatter.series.BaseWithMarkers, com.anychart.core.scatter.series.Base, com.anychart.core.SeriesBase
    public Bubble unselect() {
        APIlib.getInstance().addJSLine(this.jsBase + ".unselect();");
        return this;
    }

    @Override // com.anychart.core.scatter.series.BaseWithMarkers, com.anychart.core.scatter.series.Base, com.anychart.core.SeriesBase
    public Bubble unselect(Number number) {
        APIlib.getInstance().addJSLine(String.format(Locale.US, this.jsBase + ".unselect(%s);", number));
        return this;
    }

    @Override // com.anychart.core.scatter.series.BaseWithMarkers, com.anychart.core.scatter.series.Base, com.anychart.core.SeriesBase
    public Bubble unselect(Number[] numberArr) {
        APIlib.getInstance().addJSLine(String.format(Locale.US, this.jsBase + ".unselect(%s);", Arrays.toString(numberArr)));
        return this;
    }

    @Override // com.anychart.core.scatter.series.BaseWithMarkers, com.anychart.core.scatter.series.Base, com.anychart.core.SeriesBase, com.anychart.core.VisualBaseWithBounds
    public void width() {
        APIlib.getInstance().addJSLine(this.jsBase + ".width();");
    }

    @Override // com.anychart.core.scatter.series.BaseWithMarkers, com.anychart.core.scatter.series.Base, com.anychart.core.SeriesBase, com.anychart.core.VisualBaseWithBounds
    public Bubble width(Number number) {
        APIlib.getInstance().addJSLine(String.format(Locale.US, this.jsBase + ".width(%s);", number));
        return this;
    }

    @Override // com.anychart.core.scatter.series.BaseWithMarkers, com.anychart.core.scatter.series.Base, com.anychart.core.SeriesBase, com.anychart.core.VisualBaseWithBounds
    public Bubble width(String str) {
        APIlib.getInstance().addJSLine(String.format(Locale.US, this.jsBase + ".width(%s);", wrapQuotes(str)));
        return this;
    }

    @Override // com.anychart.core.scatter.series.BaseWithMarkers, com.anychart.core.scatter.series.Base
    public ScatterBase xScale() {
        return new ScatterBase(this.jsBase + ".xScale()");
    }

    @Override // com.anychart.core.scatter.series.BaseWithMarkers, com.anychart.core.scatter.series.Base
    public Bubble xScale(com.anychart.scales.Base base) {
        APIlib.getInstance().addJSLine(String.format(Locale.US, this.jsBase + ".xScale(%s);", base != null ? base.getJsBase() : null));
        return this;
    }

    @Override // com.anychart.core.scatter.series.BaseWithMarkers, com.anychart.core.scatter.series.Base
    public ScatterBase yScale() {
        return new ScatterBase(this.jsBase + ".yScale()");
    }

    @Override // com.anychart.core.scatter.series.BaseWithMarkers, com.anychart.core.scatter.series.Base
    public Bubble yScale(ScatterBase scatterBase) {
        APIlib.getInstance().addJSLine(String.format(Locale.US, this.jsBase + ".yScale(%s);", scatterBase != null ? scatterBase.getJsBase() : null));
        return this;
    }

    @Override // com.anychart.core.scatter.series.BaseWithMarkers, com.anychart.core.scatter.series.Base
    public Bubble yScale(String str) {
        APIlib.getInstance().addJSLine(String.format(Locale.US, this.jsBase + ".yScale(%s);", wrapQuotes(str)));
        return this;
    }

    @Override // com.anychart.core.scatter.series.BaseWithMarkers, com.anychart.core.scatter.series.Base
    public Bubble yScale(ScaleTypes scaleTypes) {
        APIlib.getInstance().addJSLine(String.format(Locale.US, this.jsBase + ".yScale(%s);", scaleTypes != null ? scaleTypes.getJsBase() : null));
        return this;
    }

    @Override // com.anychart.core.scatter.series.BaseWithMarkers, com.anychart.core.scatter.series.Base, com.anychart.core.SeriesBase, com.anychart.core.VisualBaseWithBounds, com.anychart.core.VisualBase
    public void zIndex() {
        APIlib.getInstance().addJSLine(this.jsBase + ".zIndex();");
    }

    @Override // com.anychart.core.scatter.series.BaseWithMarkers, com.anychart.core.scatter.series.Base, com.anychart.core.SeriesBase, com.anychart.core.VisualBaseWithBounds, com.anychart.core.VisualBase
    public Bubble zIndex(Number number) {
        APIlib.getInstance().addJSLine(String.format(Locale.US, this.jsBase + ".zIndex(%s);", number));
        return this;
    }

    @Override // com.anychart.core.scatter.series.BaseWithMarkers, com.anychart.core.scatter.series.Base, com.anychart.core.SeriesBase
    public LinearColor colorScale() {
        return new LinearColor(this.jsBase + ".colorScale()");
    }

    @Override // com.anychart.core.scatter.series.BaseWithMarkers, com.anychart.core.scatter.series.Base, com.anychart.core.SeriesBase
    public Bubble colorScale(LinearColor linearColor) {
        APIlib.getInstance().addJSLine(String.format(Locale.US, this.jsBase + ".colorScale(%s);", linearColor != null ? linearColor.getJsBase() : null));
        return this;
    }

    @Override // com.anychart.core.scatter.series.BaseWithMarkers, com.anychart.core.scatter.series.Base, com.anychart.core.SeriesBase
    public Bubble colorScale(OrdinalColor ordinalColor) {
        APIlib.getInstance().addJSLine(String.format(Locale.US, this.jsBase + ".colorScale(%s);", ordinalColor != null ? ordinalColor.getJsBase() : null));
        return this;
    }

    @Override // com.anychart.core.scatter.series.BaseWithMarkers, com.anychart.core.scatter.series.Base, com.anychart.core.SeriesBase
    public Bubble colorScale(String str) {
        APIlib.getInstance().addJSLine(String.format(Locale.US, this.jsBase + ".colorScale(%s);", wrapQuotes(str)));
        return this;
    }

    @Override // com.anychart.core.scatter.series.BaseWithMarkers, com.anychart.core.scatter.series.Base, com.anychart.core.SeriesBase
    public Bubble colorScale(ScaleTypes scaleTypes) {
        APIlib.getInstance().addJSLine(String.format(Locale.US, this.jsBase + ".colorScale(%s);", scaleTypes != null ? scaleTypes.getJsBase() : null));
        return this;
    }

    @Override // com.anychart.core.scatter.series.BaseWithMarkers, com.anychart.core.scatter.series.Base, com.anychart.core.SeriesBase, com.anychart.core.VisualBaseWithBounds, com.anychart.core.VisualBase
    public Layer container() {
        return new Layer(this.jsBase + ".container()");
    }

    @Override // com.anychart.core.scatter.series.BaseWithMarkers, com.anychart.core.scatter.series.Base, com.anychart.core.SeriesBase, com.anychart.core.VisualBaseWithBounds, com.anychart.core.VisualBase
    public Bubble container(Layer layer) {
        APIlib.getInstance().addJSLine(String.format(Locale.US, this.jsBase + ".container(%s);", layer != null ? layer.getJsBase() : null));
        return this;
    }

    @Override // com.anychart.core.scatter.series.BaseWithMarkers, com.anychart.core.scatter.series.Base, com.anychart.core.SeriesBase, com.anychart.core.VisualBaseWithBounds, com.anychart.core.VisualBase
    public Bubble container(Stage stage) {
        APIlib.getInstance().addJSLine(String.format(Locale.US, this.jsBase + ".container(%s);", stage != null ? stage.getJsBase() : null));
        return this;
    }

    @Override // com.anychart.core.scatter.series.BaseWithMarkers, com.anychart.core.scatter.series.Base, com.anychart.core.SeriesBase, com.anychart.core.VisualBaseWithBounds, com.anychart.core.VisualBase
    public Bubble container(String str) {
        APIlib.getInstance().addJSLine(String.format(Locale.US, this.jsBase + ".container(%s);", wrapQuotes(str)));
        return this;
    }

    @Override // com.anychart.core.scatter.series.BaseWithMarkers, com.anychart.core.scatter.series.Base, com.anychart.core.SeriesBase, com.anychart.core.VisualBaseWithBounds, com.anychart.core.VisualBase
    public Rect parentBounds() {
        return new Rect(this.jsBase + ".parentBounds()");
    }

    @Override // com.anychart.core.scatter.series.BaseWithMarkers, com.anychart.core.scatter.series.Base, com.anychart.core.SeriesBase, com.anychart.core.VisualBaseWithBounds, com.anychart.core.VisualBase
    public Bubble parentBounds(Rect rect) {
        APIlib.getInstance().addJSLine(String.format(Locale.US, this.jsBase + ".parentBounds(%s);", rect != null ? rect.getJsBase() : null));
        return this;
    }

    @Override // com.anychart.core.scatter.series.BaseWithMarkers, com.anychart.core.scatter.series.Base, com.anychart.core.SeriesBase, com.anychart.core.VisualBaseWithBounds, com.anychart.core.VisualBase
    public Bubble parentBounds(String str) {
        APIlib.getInstance().addJSLine(String.format(Locale.US, this.jsBase + ".parentBounds(%s);", wrapQuotes(str)));
        return this;
    }

    @Override // com.anychart.core.scatter.series.BaseWithMarkers, com.anychart.core.scatter.series.Base, com.anychart.core.SeriesBase, com.anychart.core.VisualBaseWithBounds, com.anychart.core.VisualBase
    public Bubble parentBounds(Number number) {
        APIlib.getInstance().addJSLine(String.format(Locale.US, this.jsBase + ".parentBounds(%s);", number));
        return this;
    }

    @Override // com.anychart.core.scatter.series.BaseWithMarkers, com.anychart.core.scatter.series.Base, com.anychart.core.SeriesBase, com.anychart.core.VisualBaseWithBounds, com.anychart.core.VisualBase
    public Bubble parentBounds(Number number, Number number2, Number number3, Number number4) {
        APIlib.getInstance().addJSLine(String.format(Locale.US, this.jsBase + ".parentBounds(%s, %s, %s, %s);", number, number2, number3, number4));
        return this;
    }

    @Override // com.anychart.core.scatter.series.BaseWithMarkers, com.anychart.core.scatter.series.Base, com.anychart.core.SeriesBase
    public View data(View view) {
        return new View(String.format(Locale.US, this.jsBase + ".data(%s)", view != null ? view.getJsBase() : null));
    }

    @Override // com.anychart.core.scatter.series.BaseWithMarkers, com.anychart.core.scatter.series.Base, com.anychart.core.SeriesBase
    public View data(List<DataEntry> list, TreeFillingMethod treeFillingMethod) {
        return new View(String.format(Locale.US, this.jsBase + ".data(%s, %s)", arrayToString(list), treeFillingMethod != null ? treeFillingMethod.getJsBase() : null));
    }

    @Override // com.anychart.core.scatter.series.BaseWithMarkers, com.anychart.core.scatter.series.Base, com.anychart.core.SeriesBase
    public View data(List<DataEntry> list, String str) {
        return new View(String.format(Locale.US, this.jsBase + ".data(%s, %s)", arrayToString(list), wrapQuotes(str)));
    }

    @Override // com.anychart.core.scatter.series.BaseWithMarkers, com.anychart.core.scatter.series.Base
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

    @Override // com.anychart.core.scatter.series.BaseWithMarkers, com.anychart.core.scatter.series.Base
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

    public Bubble fill(String str) {
        APIlib.getInstance().addJSLine(String.format(Locale.US, this.jsBase + ".fill(%s);", wrapQuotes(str)));
        return this;
    }
}
