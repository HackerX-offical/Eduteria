package com.anychart.standalones;

import com.anychart.APIlib;
import com.anychart.core.axismarkers.GanttLine;
import com.anychart.core.axismarkers.GanttRange;
import com.anychart.core.axismarkers.GanttText;
import com.anychart.core.gantt.TimeLineHeader;
import com.anychart.core.gantt.edit.StructureEdit;
import com.anychart.core.gantt.elements.BaselinesElement;
import com.anychart.core.gantt.elements.ConnectorElement;
import com.anychart.core.gantt.elements.GroupingTasksElement;
import com.anychart.core.gantt.elements.MilestonesElement;
import com.anychart.core.gantt.elements.PeriodsElement;
import com.anychart.core.gantt.elements.TasksElement;
import com.anychart.core.gantt.elements.TimelineElement;
import com.anychart.core.ui.ScrollBar;
import com.anychart.core.ui.Timeline;
import com.anychart.core.ui.Tooltip;
import com.anychart.enums.Anchor;
import com.anychart.enums.GanttDateTimeMarkers;
import com.anychart.enums.MarkerType;
import com.anychart.graphics.vector.ColoredFill;
import com.anychart.graphics.vector.Fill;
import com.anychart.graphics.vector.GradientKey;
import com.anychart.graphics.vector.Rect;
import com.anychart.graphics.vector.Stroke;
import com.anychart.graphics.vector.StrokeLineCap;
import com.anychart.graphics.vector.StrokeLineJoin;
import com.anychart.palettes.DistinctColors;
import com.anychart.palettes.RangeColors;
import com.anychart.scales.GanttDateTime;
import java.util.Locale;

/* JADX INFO: loaded from: classes6.dex */
public class ProjectTimeline extends Timeline {
    protected ProjectTimeline() {
    }

    public static ProjectTimeline instantiate() {
        return new ProjectTimeline("new anychart.standalones.projectTimeline()");
    }

    public ProjectTimeline(String str) {
        StringBuilder sb = new StringBuilder("projectTimeline");
        int i = variableIndex + 1;
        variableIndex = i;
        this.jsBase = sb.append(i).toString();
        APIlib.getInstance().addJSLine(this.jsBase + " = " + str + ";");
    }

    @Override // com.anychart.core.ui.Timeline, com.anychart.JsObject
    public String getJsBase() {
        return this.jsBase;
    }

    @Override // com.anychart.core.ui.Timeline
    public void backgroundFill() {
        APIlib.getInstance().addJSLine(this.jsBase + ".backgroundFill();");
    }

    @Override // com.anychart.core.ui.Timeline
    public ProjectTimeline backgroundFill(Fill fill) {
        APIlib.getInstance().addJSLine(String.format(Locale.US, this.jsBase + ".backgroundFill(%s);", fill != null ? fill.getJsBase() : null));
        return this;
    }

    @Override // com.anychart.core.ui.Timeline
    public ProjectTimeline backgroundFill(GradientKey gradientKey) {
        APIlib.getInstance().addJSLine(String.format(Locale.US, this.jsBase + ".backgroundFill(%s);", gradientKey != null ? gradientKey.getJsBase() : null));
        return this;
    }

    @Override // com.anychart.core.ui.Timeline
    public ProjectTimeline backgroundFill(String[] strArr) {
        APIlib.getInstance().addJSLine(String.format(Locale.US, this.jsBase + ".backgroundFill(%s);", arrayToStringWrapQuotes(strArr)));
        return this;
    }

    @Override // com.anychart.core.ui.Timeline
    public ProjectTimeline backgroundFill(String str, Number number) {
        APIlib.getInstance().addJSLine(String.format(Locale.US, this.jsBase + ".backgroundFill(%s, %s);", wrapQuotes(str), number));
        return this;
    }

    @Override // com.anychart.core.ui.Timeline
    public ProjectTimeline backgroundFill(GradientKey gradientKey, Number number, Boolean bool, Number number2) {
        APIlib.getInstance().addJSLine(String.format(Locale.US, this.jsBase + ".backgroundFill(%s, %s, %s, %s);", gradientKey != null ? gradientKey.getJsBase() : null, number, bool, number2));
        return this;
    }

    @Override // com.anychart.core.ui.Timeline
    public ProjectTimeline backgroundFill(GradientKey gradientKey, Number number, Rect rect, Number number2) {
        APIlib.getInstance().addJSLine(String.format(Locale.US, this.jsBase + ".backgroundFill(%s, %s, %s, %s);", gradientKey != null ? gradientKey.getJsBase() : null, number, rect != null ? rect.getJsBase() : null, number2));
        return this;
    }

    @Override // com.anychart.core.ui.Timeline
    public ProjectTimeline backgroundFill(GradientKey gradientKey, Number number, String str, Number number2) {
        APIlib.getInstance().addJSLine(String.format(Locale.US, this.jsBase + ".backgroundFill(%s, %s, %s, %s);", gradientKey != null ? gradientKey.getJsBase() : null, number, wrapQuotes(str), number2));
        return this;
    }

    @Override // com.anychart.core.ui.Timeline
    public ProjectTimeline backgroundFill(String[] strArr, Number number, Boolean bool, Number number2) {
        APIlib.getInstance().addJSLine(String.format(Locale.US, this.jsBase + ".backgroundFill(%s, %s, %s, %s);", arrayToStringWrapQuotes(strArr), number, bool, number2));
        return this;
    }

    @Override // com.anychart.core.ui.Timeline
    public ProjectTimeline backgroundFill(String[] strArr, Number number, Rect rect, Number number2) {
        APIlib.getInstance().addJSLine(String.format(Locale.US, this.jsBase + ".backgroundFill(%s, %s, %s, %s);", arrayToStringWrapQuotes(strArr), number, rect != null ? rect.getJsBase() : null, number2));
        return this;
    }

    @Override // com.anychart.core.ui.Timeline
    public ProjectTimeline backgroundFill(String[] strArr, Number number, String str, Number number2) {
        APIlib.getInstance().addJSLine(String.format(Locale.US, this.jsBase + ".backgroundFill(%s, %s, %s, %s);", arrayToStringWrapQuotes(strArr), number, wrapQuotes(str), number2));
        return this;
    }

    @Override // com.anychart.core.ui.Timeline
    public ProjectTimeline backgroundFill(GradientKey gradientKey, Number number, Number number2, com.anychart.graphics.math.Rect rect, Number number3, Number number4, Number number5) {
        APIlib.getInstance().addJSLine(String.format(Locale.US, this.jsBase + ".backgroundFill(%s, %s, %s, %s, %s, %s, %s);", gradientKey != null ? gradientKey.getJsBase() : null, number, number2, rect != null ? rect.getJsBase() : null, number3, number4, number5));
        return this;
    }

    @Override // com.anychart.core.ui.Timeline
    public ProjectTimeline backgroundFill(String[] strArr, Number number, Number number2, com.anychart.graphics.math.Rect rect, Number number3, Number number4, Number number5) {
        APIlib.getInstance().addJSLine(String.format(Locale.US, this.jsBase + ".backgroundFill(%s, %s, %s, %s, %s, %s, %s);", arrayToStringWrapQuotes(strArr), number, number2, rect != null ? rect.getJsBase() : null, number3, number4, number5));
        return this;
    }

    @Override // com.anychart.core.ui.Timeline
    public void baseBarAnchor() {
        APIlib.getInstance().addJSLine(this.jsBase + ".baseBarAnchor();");
    }

    @Override // com.anychart.core.ui.Timeline
    public ProjectTimeline baseBarAnchor(String str) {
        APIlib.getInstance().addJSLine(String.format(Locale.US, this.jsBase + ".baseBarAnchor(%s);", wrapQuotes(str)));
        return this;
    }

    @Override // com.anychart.core.ui.Timeline
    public ProjectTimeline baseBarAnchor(Anchor anchor) {
        APIlib.getInstance().addJSLine(String.format(Locale.US, this.jsBase + ".baseBarAnchor(%s);", anchor != null ? anchor.getJsBase() : null));
        return this;
    }

    @Override // com.anychart.core.ui.Timeline
    public void baseBarHeight() {
        APIlib.getInstance().addJSLine(this.jsBase + ".baseBarHeight();");
    }

    @Override // com.anychart.core.ui.Timeline
    public ProjectTimeline baseBarHeight(String str) {
        APIlib.getInstance().addJSLine(String.format(Locale.US, this.jsBase + ".baseBarHeight(%s);", wrapQuotes(str)));
        return this;
    }

    @Override // com.anychart.core.ui.Timeline
    public ProjectTimeline baseBarHeight(Number number) {
        APIlib.getInstance().addJSLine(String.format(Locale.US, this.jsBase + ".baseBarHeight(%s);", number));
        return this;
    }

    @Override // com.anychart.core.ui.Timeline
    public void baseBarOffset() {
        APIlib.getInstance().addJSLine(this.jsBase + ".baseBarOffset();");
    }

    @Override // com.anychart.core.ui.Timeline
    public ProjectTimeline baseBarOffset(String str) {
        APIlib.getInstance().addJSLine(String.format(Locale.US, this.jsBase + ".baseBarOffset(%s);", wrapQuotes(str)));
        return this;
    }

    @Override // com.anychart.core.ui.Timeline
    public ProjectTimeline baseBarOffset(Number number) {
        APIlib.getInstance().addJSLine(String.format(Locale.US, this.jsBase + ".baseBarOffset(%s);", number));
        return this;
    }

    @Override // com.anychart.core.ui.Timeline
    public void baseBarPosition() {
        APIlib.getInstance().addJSLine(this.jsBase + ".baseBarPosition();");
    }

    @Override // com.anychart.core.ui.Timeline
    public ProjectTimeline baseBarPosition(String str) {
        APIlib.getInstance().addJSLine(String.format(Locale.US, this.jsBase + ".baseBarPosition(%s);", wrapQuotes(str)));
        return this;
    }

    @Override // com.anychart.core.ui.Timeline
    public ProjectTimeline baseBarPosition(Anchor anchor) {
        APIlib.getInstance().addJSLine(String.format(Locale.US, this.jsBase + ".baseBarPosition(%s);", anchor != null ? anchor.getJsBase() : null));
        return this;
    }

    @Override // com.anychart.core.ui.Timeline
    public void baseFill() {
        APIlib.getInstance().addJSLine(this.jsBase + ".baseFill();");
    }

    @Override // com.anychart.core.ui.Timeline
    public ProjectTimeline baseFill(Fill fill) {
        APIlib.getInstance().addJSLine(String.format(Locale.US, this.jsBase + ".baseFill(%s);", fill != null ? fill.getJsBase() : null));
        return this;
    }

    @Override // com.anychart.core.ui.Timeline
    public ProjectTimeline baseFill(String str, Number number) {
        APIlib.getInstance().addJSLine(String.format(Locale.US, this.jsBase + ".baseFill(%s, %s);", wrapQuotes(str), number));
        return this;
    }

    @Override // com.anychart.core.ui.Timeline
    public ProjectTimeline baseFill(GradientKey gradientKey, Number number, Boolean bool, Number number2) {
        APIlib.getInstance().addJSLine(String.format(Locale.US, this.jsBase + ".baseFill(%s, %s, %s, %s);", gradientKey != null ? gradientKey.getJsBase() : null, number, bool, number2));
        return this;
    }

    @Override // com.anychart.core.ui.Timeline
    public ProjectTimeline baseFill(GradientKey gradientKey, Number number, Rect rect, Number number2) {
        APIlib.getInstance().addJSLine(String.format(Locale.US, this.jsBase + ".baseFill(%s, %s, %s, %s);", gradientKey != null ? gradientKey.getJsBase() : null, number, rect != null ? rect.getJsBase() : null, number2));
        return this;
    }

    @Override // com.anychart.core.ui.Timeline
    public ProjectTimeline baseFill(GradientKey gradientKey, Number number, String str, Number number2) {
        APIlib.getInstance().addJSLine(String.format(Locale.US, this.jsBase + ".baseFill(%s, %s, %s, %s);", gradientKey != null ? gradientKey.getJsBase() : null, number, wrapQuotes(str), number2));
        return this;
    }

    @Override // com.anychart.core.ui.Timeline
    public ProjectTimeline baseFill(String[] strArr, Number number, Boolean bool, Number number2) {
        APIlib.getInstance().addJSLine(String.format(Locale.US, this.jsBase + ".baseFill(%s, %s, %s, %s);", arrayToStringWrapQuotes(strArr), number, bool, number2));
        return this;
    }

    @Override // com.anychart.core.ui.Timeline
    public ProjectTimeline baseFill(String[] strArr, Number number, Rect rect, Number number2) {
        APIlib.getInstance().addJSLine(String.format(Locale.US, this.jsBase + ".baseFill(%s, %s, %s, %s);", arrayToStringWrapQuotes(strArr), number, rect != null ? rect.getJsBase() : null, number2));
        return this;
    }

    @Override // com.anychart.core.ui.Timeline
    public ProjectTimeline baseFill(String[] strArr, Number number, String str, Number number2) {
        APIlib.getInstance().addJSLine(String.format(Locale.US, this.jsBase + ".baseFill(%s, %s, %s, %s);", arrayToStringWrapQuotes(strArr), number, wrapQuotes(str), number2));
        return this;
    }

    @Override // com.anychart.core.ui.Timeline
    public ProjectTimeline baseFill(GradientKey gradientKey, Number number, Number number2, com.anychart.graphics.math.Rect rect, Number number3, Number number4, Number number5) {
        APIlib.getInstance().addJSLine(String.format(Locale.US, this.jsBase + ".baseFill(%s, %s, %s, %s, %s, %s, %s);", gradientKey != null ? gradientKey.getJsBase() : null, number, number2, rect != null ? rect.getJsBase() : null, number3, number4, number5));
        return this;
    }

    @Override // com.anychart.core.ui.Timeline
    public ProjectTimeline baseFill(String[] strArr, Number number, Number number2, com.anychart.graphics.math.Rect rect, Number number3, Number number4, Number number5) {
        APIlib.getInstance().addJSLine(String.format(Locale.US, this.jsBase + ".baseFill(%s, %s, %s, %s, %s, %s, %s);", arrayToStringWrapQuotes(strArr), number, number2, rect != null ? rect.getJsBase() : null, number3, number4, number5));
        return this;
    }

    @Override // com.anychart.core.ui.Timeline
    public void baseStroke() {
        APIlib.getInstance().addJSLine(this.jsBase + ".baseStroke();");
    }

    @Override // com.anychart.core.ui.Timeline
    public ProjectTimeline baseStroke(Stroke stroke, Number number, String str, String str2, String str3) {
        APIlib.getInstance().addJSLine(String.format(Locale.US, this.jsBase + ".baseStroke(%s, %s, %s, %s, %s);", stroke != null ? stroke.getJsBase() : null, number, wrapQuotes(str), wrapQuotes(str2), wrapQuotes(str3)));
        return this;
    }

    @Override // com.anychart.core.ui.Timeline
    public ProjectTimeline baseStroke(Stroke stroke, Number number, String str, String str2, StrokeLineCap strokeLineCap) {
        APIlib.getInstance().addJSLine(String.format(Locale.US, this.jsBase + ".baseStroke(%s, %s, %s, %s, %s);", stroke != null ? stroke.getJsBase() : null, number, wrapQuotes(str), wrapQuotes(str2), strokeLineCap != null ? strokeLineCap.getJsBase() : null));
        return this;
    }

    @Override // com.anychart.core.ui.Timeline
    public ProjectTimeline baseStroke(Stroke stroke, Number number, String str, StrokeLineJoin strokeLineJoin, String str2) {
        APIlib.getInstance().addJSLine(String.format(Locale.US, this.jsBase + ".baseStroke(%s, %s, %s, %s, %s);", stroke != null ? stroke.getJsBase() : null, number, wrapQuotes(str), strokeLineJoin != null ? strokeLineJoin.getJsBase() : null, wrapQuotes(str2)));
        return this;
    }

    @Override // com.anychart.core.ui.Timeline
    public ProjectTimeline baseStroke(Stroke stroke, Number number, String str, StrokeLineJoin strokeLineJoin, StrokeLineCap strokeLineCap) {
        APIlib.getInstance().addJSLine(String.format(Locale.US, this.jsBase + ".baseStroke(%s, %s, %s, %s, %s);", stroke != null ? stroke.getJsBase() : null, number, wrapQuotes(str), strokeLineJoin != null ? strokeLineJoin.getJsBase() : null, strokeLineCap != null ? strokeLineCap.getJsBase() : null));
        return this;
    }

    @Override // com.anychart.core.ui.Timeline
    public ProjectTimeline baseStroke(ColoredFill coloredFill, Number number, String str, String str2, String str3) {
        APIlib.getInstance().addJSLine(String.format(Locale.US, this.jsBase + ".baseStroke(%s, %s, %s, %s, %s);", coloredFill != null ? coloredFill.getJsBase() : null, number, wrapQuotes(str), wrapQuotes(str2), wrapQuotes(str3)));
        return this;
    }

    @Override // com.anychart.core.ui.Timeline
    public ProjectTimeline baseStroke(ColoredFill coloredFill, Number number, String str, String str2, StrokeLineCap strokeLineCap) {
        APIlib.getInstance().addJSLine(String.format(Locale.US, this.jsBase + ".baseStroke(%s, %s, %s, %s, %s);", coloredFill != null ? coloredFill.getJsBase() : null, number, wrapQuotes(str), wrapQuotes(str2), strokeLineCap != null ? strokeLineCap.getJsBase() : null));
        return this;
    }

    @Override // com.anychart.core.ui.Timeline
    public ProjectTimeline baseStroke(ColoredFill coloredFill, Number number, String str, StrokeLineJoin strokeLineJoin, String str2) {
        APIlib.getInstance().addJSLine(String.format(Locale.US, this.jsBase + ".baseStroke(%s, %s, %s, %s, %s);", coloredFill != null ? coloredFill.getJsBase() : null, number, wrapQuotes(str), strokeLineJoin != null ? strokeLineJoin.getJsBase() : null, wrapQuotes(str2)));
        return this;
    }

    @Override // com.anychart.core.ui.Timeline
    public ProjectTimeline baseStroke(ColoredFill coloredFill, Number number, String str, StrokeLineJoin strokeLineJoin, StrokeLineCap strokeLineCap) {
        APIlib.getInstance().addJSLine(String.format(Locale.US, this.jsBase + ".baseStroke(%s, %s, %s, %s, %s);", coloredFill != null ? coloredFill.getJsBase() : null, number, wrapQuotes(str), strokeLineJoin != null ? strokeLineJoin.getJsBase() : null, strokeLineCap != null ? strokeLineCap.getJsBase() : null));
        return this;
    }

    @Override // com.anychart.core.ui.Timeline
    public ProjectTimeline baseStroke(String str, Number number, String str2, String str3, String str4) {
        APIlib.getInstance().addJSLine(String.format(Locale.US, this.jsBase + ".baseStroke(%s, %s, %s, %s, %s);", wrapQuotes(str), number, wrapQuotes(str2), wrapQuotes(str3), wrapQuotes(str4)));
        return this;
    }

    @Override // com.anychart.core.ui.Timeline
    public ProjectTimeline baseStroke(String str, Number number, String str2, String str3, StrokeLineCap strokeLineCap) {
        APIlib.getInstance().addJSLine(String.format(Locale.US, this.jsBase + ".baseStroke(%s, %s, %s, %s, %s);", wrapQuotes(str), number, wrapQuotes(str2), wrapQuotes(str3), strokeLineCap != null ? strokeLineCap.getJsBase() : null));
        return this;
    }

    @Override // com.anychart.core.ui.Timeline
    public ProjectTimeline baseStroke(String str, Number number, String str2, StrokeLineJoin strokeLineJoin, String str3) {
        APIlib.getInstance().addJSLine(String.format(Locale.US, this.jsBase + ".baseStroke(%s, %s, %s, %s, %s);", wrapQuotes(str), number, wrapQuotes(str2), strokeLineJoin != null ? strokeLineJoin.getJsBase() : null, wrapQuotes(str3)));
        return this;
    }

    @Override // com.anychart.core.ui.Timeline
    public ProjectTimeline baseStroke(String str, Number number, String str2, StrokeLineJoin strokeLineJoin, StrokeLineCap strokeLineCap) {
        APIlib.getInstance().addJSLine(String.format(Locale.US, this.jsBase + ".baseStroke(%s, %s, %s, %s, %s);", wrapQuotes(str), number, wrapQuotes(str2), strokeLineJoin != null ? strokeLineJoin.getJsBase() : null, strokeLineCap != null ? strokeLineCap.getJsBase() : null));
        return this;
    }

    @Override // com.anychart.core.ui.Timeline
    public void baselineAbove() {
        APIlib.getInstance().addJSLine(this.jsBase + ".baselineAbove();");
    }

    @Override // com.anychart.core.ui.Timeline
    public ProjectTimeline baselineAbove(Boolean bool) {
        APIlib.getInstance().addJSLine(String.format(Locale.US, this.jsBase + ".baselineAbove(%s);", bool));
        return this;
    }

    @Override // com.anychart.core.ui.Timeline
    public void baselineBarAnchor() {
        APIlib.getInstance().addJSLine(this.jsBase + ".baselineBarAnchor();");
    }

    @Override // com.anychart.core.ui.Timeline
    public ProjectTimeline baselineBarAnchor(String str) {
        APIlib.getInstance().addJSLine(String.format(Locale.US, this.jsBase + ".baselineBarAnchor(%s);", wrapQuotes(str)));
        return this;
    }

    @Override // com.anychart.core.ui.Timeline
    public ProjectTimeline baselineBarAnchor(Anchor anchor) {
        APIlib.getInstance().addJSLine(String.format(Locale.US, this.jsBase + ".baselineBarAnchor(%s);", anchor != null ? anchor.getJsBase() : null));
        return this;
    }

    @Override // com.anychart.core.ui.Timeline
    public void baselineBarHeight() {
        APIlib.getInstance().addJSLine(this.jsBase + ".baselineBarHeight();");
    }

    @Override // com.anychart.core.ui.Timeline
    public ProjectTimeline baselineBarHeight(String str) {
        APIlib.getInstance().addJSLine(String.format(Locale.US, this.jsBase + ".baselineBarHeight(%s);", wrapQuotes(str)));
        return this;
    }

    @Override // com.anychart.core.ui.Timeline
    public ProjectTimeline baselineBarHeight(Number number) {
        APIlib.getInstance().addJSLine(String.format(Locale.US, this.jsBase + ".baselineBarHeight(%s);", number));
        return this;
    }

    @Override // com.anychart.core.ui.Timeline
    public void baselineBarOffset() {
        APIlib.getInstance().addJSLine(this.jsBase + ".baselineBarOffset();");
    }

    @Override // com.anychart.core.ui.Timeline
    public ProjectTimeline baselineBarOffset(String str) {
        APIlib.getInstance().addJSLine(String.format(Locale.US, this.jsBase + ".baselineBarOffset(%s);", wrapQuotes(str)));
        return this;
    }

    @Override // com.anychart.core.ui.Timeline
    public ProjectTimeline baselineBarOffset(Number number) {
        APIlib.getInstance().addJSLine(String.format(Locale.US, this.jsBase + ".baselineBarOffset(%s);", number));
        return this;
    }

    @Override // com.anychart.core.ui.Timeline
    public void baselineBarPosition() {
        APIlib.getInstance().addJSLine(this.jsBase + ".baselineBarPosition();");
    }

    @Override // com.anychart.core.ui.Timeline
    public ProjectTimeline baselineBarPosition(String str) {
        APIlib.getInstance().addJSLine(String.format(Locale.US, this.jsBase + ".baselineBarPosition(%s);", wrapQuotes(str)));
        return this;
    }

    @Override // com.anychart.core.ui.Timeline
    public ProjectTimeline baselineBarPosition(Anchor anchor) {
        APIlib.getInstance().addJSLine(String.format(Locale.US, this.jsBase + ".baselineBarPosition(%s);", anchor != null ? anchor.getJsBase() : null));
        return this;
    }

    @Override // com.anychart.core.ui.Timeline
    public void baselineFill() {
        APIlib.getInstance().addJSLine(this.jsBase + ".baselineFill();");
    }

    @Override // com.anychart.core.ui.Timeline
    public ProjectTimeline baselineFill(Fill fill) {
        APIlib.getInstance().addJSLine(String.format(Locale.US, this.jsBase + ".baselineFill(%s);", fill != null ? fill.getJsBase() : null));
        return this;
    }

    @Override // com.anychart.core.ui.Timeline
    public ProjectTimeline baselineFill(String str, Number number) {
        APIlib.getInstance().addJSLine(String.format(Locale.US, this.jsBase + ".baselineFill(%s, %s);", wrapQuotes(str), number));
        return this;
    }

    @Override // com.anychart.core.ui.Timeline
    public ProjectTimeline baselineFill(GradientKey gradientKey, Number number, Boolean bool, Number number2) {
        APIlib.getInstance().addJSLine(String.format(Locale.US, this.jsBase + ".baselineFill(%s, %s, %s, %s);", gradientKey != null ? gradientKey.getJsBase() : null, number, bool, number2));
        return this;
    }

    @Override // com.anychart.core.ui.Timeline
    public ProjectTimeline baselineFill(GradientKey gradientKey, Number number, Rect rect, Number number2) {
        APIlib.getInstance().addJSLine(String.format(Locale.US, this.jsBase + ".baselineFill(%s, %s, %s, %s);", gradientKey != null ? gradientKey.getJsBase() : null, number, rect != null ? rect.getJsBase() : null, number2));
        return this;
    }

    @Override // com.anychart.core.ui.Timeline
    public ProjectTimeline baselineFill(GradientKey gradientKey, Number number, String str, Number number2) {
        APIlib.getInstance().addJSLine(String.format(Locale.US, this.jsBase + ".baselineFill(%s, %s, %s, %s);", gradientKey != null ? gradientKey.getJsBase() : null, number, wrapQuotes(str), number2));
        return this;
    }

    @Override // com.anychart.core.ui.Timeline
    public ProjectTimeline baselineFill(String[] strArr, Number number, Boolean bool, Number number2) {
        APIlib.getInstance().addJSLine(String.format(Locale.US, this.jsBase + ".baselineFill(%s, %s, %s, %s);", arrayToStringWrapQuotes(strArr), number, bool, number2));
        return this;
    }

    @Override // com.anychart.core.ui.Timeline
    public ProjectTimeline baselineFill(String[] strArr, Number number, Rect rect, Number number2) {
        APIlib.getInstance().addJSLine(String.format(Locale.US, this.jsBase + ".baselineFill(%s, %s, %s, %s);", arrayToStringWrapQuotes(strArr), number, rect != null ? rect.getJsBase() : null, number2));
        return this;
    }

    @Override // com.anychart.core.ui.Timeline
    public ProjectTimeline baselineFill(String[] strArr, Number number, String str, Number number2) {
        APIlib.getInstance().addJSLine(String.format(Locale.US, this.jsBase + ".baselineFill(%s, %s, %s, %s);", arrayToStringWrapQuotes(strArr), number, wrapQuotes(str), number2));
        return this;
    }

    @Override // com.anychart.core.ui.Timeline
    public ProjectTimeline baselineFill(GradientKey gradientKey, Number number, Number number2, com.anychart.graphics.math.Rect rect, Number number3, Number number4, Number number5) {
        APIlib.getInstance().addJSLine(String.format(Locale.US, this.jsBase + ".baselineFill(%s, %s, %s, %s, %s, %s, %s);", gradientKey != null ? gradientKey.getJsBase() : null, number, number2, rect != null ? rect.getJsBase() : null, number3, number4, number5));
        return this;
    }

    @Override // com.anychart.core.ui.Timeline
    public ProjectTimeline baselineFill(String[] strArr, Number number, Number number2, com.anychart.graphics.math.Rect rect, Number number3, Number number4, Number number5) {
        APIlib.getInstance().addJSLine(String.format(Locale.US, this.jsBase + ".baselineFill(%s, %s, %s, %s, %s, %s, %s);", arrayToStringWrapQuotes(strArr), number, number2, rect != null ? rect.getJsBase() : null, number3, number4, number5));
        return this;
    }

    @Override // com.anychart.core.ui.Timeline
    public void baselineStroke() {
        APIlib.getInstance().addJSLine(this.jsBase + ".baselineStroke();");
    }

    @Override // com.anychart.core.ui.Timeline
    public ProjectTimeline baselineStroke(Stroke stroke, Number number, String str, String str2, String str3) {
        APIlib.getInstance().addJSLine(String.format(Locale.US, this.jsBase + ".baselineStroke(%s, %s, %s, %s, %s);", stroke != null ? stroke.getJsBase() : null, number, wrapQuotes(str), wrapQuotes(str2), wrapQuotes(str3)));
        return this;
    }

    @Override // com.anychart.core.ui.Timeline
    public ProjectTimeline baselineStroke(Stroke stroke, Number number, String str, String str2, StrokeLineCap strokeLineCap) {
        APIlib.getInstance().addJSLine(String.format(Locale.US, this.jsBase + ".baselineStroke(%s, %s, %s, %s, %s);", stroke != null ? stroke.getJsBase() : null, number, wrapQuotes(str), wrapQuotes(str2), strokeLineCap != null ? strokeLineCap.getJsBase() : null));
        return this;
    }

    @Override // com.anychart.core.ui.Timeline
    public ProjectTimeline baselineStroke(Stroke stroke, Number number, String str, StrokeLineJoin strokeLineJoin, String str2) {
        APIlib.getInstance().addJSLine(String.format(Locale.US, this.jsBase + ".baselineStroke(%s, %s, %s, %s, %s);", stroke != null ? stroke.getJsBase() : null, number, wrapQuotes(str), strokeLineJoin != null ? strokeLineJoin.getJsBase() : null, wrapQuotes(str2)));
        return this;
    }

    @Override // com.anychart.core.ui.Timeline
    public ProjectTimeline baselineStroke(Stroke stroke, Number number, String str, StrokeLineJoin strokeLineJoin, StrokeLineCap strokeLineCap) {
        APIlib.getInstance().addJSLine(String.format(Locale.US, this.jsBase + ".baselineStroke(%s, %s, %s, %s, %s);", stroke != null ? stroke.getJsBase() : null, number, wrapQuotes(str), strokeLineJoin != null ? strokeLineJoin.getJsBase() : null, strokeLineCap != null ? strokeLineCap.getJsBase() : null));
        return this;
    }

    @Override // com.anychart.core.ui.Timeline
    public ProjectTimeline baselineStroke(ColoredFill coloredFill, Number number, String str, String str2, String str3) {
        APIlib.getInstance().addJSLine(String.format(Locale.US, this.jsBase + ".baselineStroke(%s, %s, %s, %s, %s);", coloredFill != null ? coloredFill.getJsBase() : null, number, wrapQuotes(str), wrapQuotes(str2), wrapQuotes(str3)));
        return this;
    }

    @Override // com.anychart.core.ui.Timeline
    public ProjectTimeline baselineStroke(ColoredFill coloredFill, Number number, String str, String str2, StrokeLineCap strokeLineCap) {
        APIlib.getInstance().addJSLine(String.format(Locale.US, this.jsBase + ".baselineStroke(%s, %s, %s, %s, %s);", coloredFill != null ? coloredFill.getJsBase() : null, number, wrapQuotes(str), wrapQuotes(str2), strokeLineCap != null ? strokeLineCap.getJsBase() : null));
        return this;
    }

    @Override // com.anychart.core.ui.Timeline
    public ProjectTimeline baselineStroke(ColoredFill coloredFill, Number number, String str, StrokeLineJoin strokeLineJoin, String str2) {
        APIlib.getInstance().addJSLine(String.format(Locale.US, this.jsBase + ".baselineStroke(%s, %s, %s, %s, %s);", coloredFill != null ? coloredFill.getJsBase() : null, number, wrapQuotes(str), strokeLineJoin != null ? strokeLineJoin.getJsBase() : null, wrapQuotes(str2)));
        return this;
    }

    @Override // com.anychart.core.ui.Timeline
    public ProjectTimeline baselineStroke(ColoredFill coloredFill, Number number, String str, StrokeLineJoin strokeLineJoin, StrokeLineCap strokeLineCap) {
        APIlib.getInstance().addJSLine(String.format(Locale.US, this.jsBase + ".baselineStroke(%s, %s, %s, %s, %s);", coloredFill != null ? coloredFill.getJsBase() : null, number, wrapQuotes(str), strokeLineJoin != null ? strokeLineJoin.getJsBase() : null, strokeLineCap != null ? strokeLineCap.getJsBase() : null));
        return this;
    }

    @Override // com.anychart.core.ui.Timeline
    public ProjectTimeline baselineStroke(String str, Number number, String str2, String str3, String str4) {
        APIlib.getInstance().addJSLine(String.format(Locale.US, this.jsBase + ".baselineStroke(%s, %s, %s, %s, %s);", wrapQuotes(str), number, wrapQuotes(str2), wrapQuotes(str3), wrapQuotes(str4)));
        return this;
    }

    @Override // com.anychart.core.ui.Timeline
    public ProjectTimeline baselineStroke(String str, Number number, String str2, String str3, StrokeLineCap strokeLineCap) {
        APIlib.getInstance().addJSLine(String.format(Locale.US, this.jsBase + ".baselineStroke(%s, %s, %s, %s, %s);", wrapQuotes(str), number, wrapQuotes(str2), wrapQuotes(str3), strokeLineCap != null ? strokeLineCap.getJsBase() : null));
        return this;
    }

    @Override // com.anychart.core.ui.Timeline
    public ProjectTimeline baselineStroke(String str, Number number, String str2, StrokeLineJoin strokeLineJoin, String str3) {
        APIlib.getInstance().addJSLine(String.format(Locale.US, this.jsBase + ".baselineStroke(%s, %s, %s, %s, %s);", wrapQuotes(str), number, wrapQuotes(str2), strokeLineJoin != null ? strokeLineJoin.getJsBase() : null, wrapQuotes(str3)));
        return this;
    }

    @Override // com.anychart.core.ui.Timeline
    public ProjectTimeline baselineStroke(String str, Number number, String str2, StrokeLineJoin strokeLineJoin, StrokeLineCap strokeLineCap) {
        APIlib.getInstance().addJSLine(String.format(Locale.US, this.jsBase + ".baselineStroke(%s, %s, %s, %s, %s);", wrapQuotes(str), number, wrapQuotes(str2), strokeLineJoin != null ? strokeLineJoin.getJsBase() : null, strokeLineCap != null ? strokeLineCap.getJsBase() : null));
        return this;
    }

    @Override // com.anychart.core.ui.Timeline
    public BaselinesElement baselines() {
        return new BaselinesElement(this.jsBase + ".baselines()");
    }

    @Override // com.anychart.core.ui.Timeline
    public ProjectTimeline baselines(String str) {
        APIlib.getInstance().addJSLine(String.format(Locale.US, this.jsBase + ".baselines(%s);", wrapQuotes(str)));
        return this;
    }

    @Override // com.anychart.core.ui.Timeline
    public void columnStroke() {
        APIlib.getInstance().addJSLine(this.jsBase + ".columnStroke();");
    }

    @Override // com.anychart.core.ui.Timeline
    public ProjectTimeline columnStroke(Stroke stroke) {
        APIlib.getInstance().addJSLine(String.format(Locale.US, this.jsBase + ".columnStroke(%s);", stroke != null ? stroke.getJsBase() : null));
        return this;
    }

    @Override // com.anychart.core.ui.Timeline
    public ProjectTimeline columnStroke(String str) {
        APIlib.getInstance().addJSLine(String.format(Locale.US, this.jsBase + ".columnStroke(%s);", wrapQuotes(str)));
        return this;
    }

    @Override // com.anychart.core.ui.Timeline
    public void connectorFill() {
        APIlib.getInstance().addJSLine(this.jsBase + ".connectorFill();");
    }

    @Override // com.anychart.core.ui.Timeline
    public ProjectTimeline connectorFill(Fill fill, Number number, Number number2, com.anychart.graphics.math.Rect rect, Number number3, Number number4, Number number5) {
        APIlib.getInstance().addJSLine(String.format(Locale.US, this.jsBase + ".connectorFill(%s, %s, %s, %s, %s, %s, %s);", fill != null ? fill.getJsBase() : null, number, number2, rect != null ? rect.getJsBase() : null, number3, number4, number5));
        return this;
    }

    @Override // com.anychart.core.ui.Timeline
    public ProjectTimeline connectorFill(GradientKey gradientKey, Number number, Number number2, com.anychart.graphics.math.Rect rect, Number number3, Number number4, Number number5) {
        APIlib.getInstance().addJSLine(String.format(Locale.US, this.jsBase + ".connectorFill(%s, %s, %s, %s, %s, %s, %s);", gradientKey != null ? gradientKey.getJsBase() : null, number, number2, rect != null ? rect.getJsBase() : null, number3, number4, number5));
        return this;
    }

    @Override // com.anychart.core.ui.Timeline
    public ProjectTimeline connectorFill(String[] strArr, Number number, Number number2, com.anychart.graphics.math.Rect rect, Number number3, Number number4, Number number5) {
        APIlib.getInstance().addJSLine(String.format(Locale.US, this.jsBase + ".connectorFill(%s, %s, %s, %s, %s, %s, %s);", arrayToStringWrapQuotes(strArr), number, number2, rect != null ? rect.getJsBase() : null, number3, number4, number5));
        return this;
    }

    @Override // com.anychart.core.ui.Timeline
    public void connectorPreviewStroke() {
        APIlib.getInstance().addJSLine(this.jsBase + ".connectorPreviewStroke();");
    }

    @Override // com.anychart.core.ui.Timeline
    public ProjectTimeline connectorPreviewStroke(Stroke stroke, Number number, String str, String str2, String str3) {
        APIlib.getInstance().addJSLine(String.format(Locale.US, this.jsBase + ".connectorPreviewStroke(%s, %s, %s, %s, %s);", stroke != null ? stroke.getJsBase() : null, number, wrapQuotes(str), wrapQuotes(str2), wrapQuotes(str3)));
        return this;
    }

    @Override // com.anychart.core.ui.Timeline
    public ProjectTimeline connectorPreviewStroke(Stroke stroke, Number number, String str, String str2, StrokeLineCap strokeLineCap) {
        APIlib.getInstance().addJSLine(String.format(Locale.US, this.jsBase + ".connectorPreviewStroke(%s, %s, %s, %s, %s);", stroke != null ? stroke.getJsBase() : null, number, wrapQuotes(str), wrapQuotes(str2), strokeLineCap != null ? strokeLineCap.getJsBase() : null));
        return this;
    }

    @Override // com.anychart.core.ui.Timeline
    public ProjectTimeline connectorPreviewStroke(Stroke stroke, Number number, String str, StrokeLineJoin strokeLineJoin, String str2) {
        APIlib.getInstance().addJSLine(String.format(Locale.US, this.jsBase + ".connectorPreviewStroke(%s, %s, %s, %s, %s);", stroke != null ? stroke.getJsBase() : null, number, wrapQuotes(str), strokeLineJoin != null ? strokeLineJoin.getJsBase() : null, wrapQuotes(str2)));
        return this;
    }

    @Override // com.anychart.core.ui.Timeline
    public ProjectTimeline connectorPreviewStroke(Stroke stroke, Number number, String str, StrokeLineJoin strokeLineJoin, StrokeLineCap strokeLineCap) {
        APIlib.getInstance().addJSLine(String.format(Locale.US, this.jsBase + ".connectorPreviewStroke(%s, %s, %s, %s, %s);", stroke != null ? stroke.getJsBase() : null, number, wrapQuotes(str), strokeLineJoin != null ? strokeLineJoin.getJsBase() : null, strokeLineCap != null ? strokeLineCap.getJsBase() : null));
        return this;
    }

    @Override // com.anychart.core.ui.Timeline
    public ProjectTimeline connectorPreviewStroke(ColoredFill coloredFill, Number number, String str, String str2, String str3) {
        APIlib.getInstance().addJSLine(String.format(Locale.US, this.jsBase + ".connectorPreviewStroke(%s, %s, %s, %s, %s);", coloredFill != null ? coloredFill.getJsBase() : null, number, wrapQuotes(str), wrapQuotes(str2), wrapQuotes(str3)));
        return this;
    }

    @Override // com.anychart.core.ui.Timeline
    public ProjectTimeline connectorPreviewStroke(ColoredFill coloredFill, Number number, String str, String str2, StrokeLineCap strokeLineCap) {
        APIlib.getInstance().addJSLine(String.format(Locale.US, this.jsBase + ".connectorPreviewStroke(%s, %s, %s, %s, %s);", coloredFill != null ? coloredFill.getJsBase() : null, number, wrapQuotes(str), wrapQuotes(str2), strokeLineCap != null ? strokeLineCap.getJsBase() : null));
        return this;
    }

    @Override // com.anychart.core.ui.Timeline
    public ProjectTimeline connectorPreviewStroke(ColoredFill coloredFill, Number number, String str, StrokeLineJoin strokeLineJoin, String str2) {
        APIlib.getInstance().addJSLine(String.format(Locale.US, this.jsBase + ".connectorPreviewStroke(%s, %s, %s, %s, %s);", coloredFill != null ? coloredFill.getJsBase() : null, number, wrapQuotes(str), strokeLineJoin != null ? strokeLineJoin.getJsBase() : null, wrapQuotes(str2)));
        return this;
    }

    @Override // com.anychart.core.ui.Timeline
    public ProjectTimeline connectorPreviewStroke(ColoredFill coloredFill, Number number, String str, StrokeLineJoin strokeLineJoin, StrokeLineCap strokeLineCap) {
        APIlib.getInstance().addJSLine(String.format(Locale.US, this.jsBase + ".connectorPreviewStroke(%s, %s, %s, %s, %s);", coloredFill != null ? coloredFill.getJsBase() : null, number, wrapQuotes(str), strokeLineJoin != null ? strokeLineJoin.getJsBase() : null, strokeLineCap != null ? strokeLineCap.getJsBase() : null));
        return this;
    }

    @Override // com.anychart.core.ui.Timeline
    public ProjectTimeline connectorPreviewStroke(String str, Number number, String str2, String str3, String str4) {
        APIlib.getInstance().addJSLine(String.format(Locale.US, this.jsBase + ".connectorPreviewStroke(%s, %s, %s, %s, %s);", wrapQuotes(str), number, wrapQuotes(str2), wrapQuotes(str3), wrapQuotes(str4)));
        return this;
    }

    @Override // com.anychart.core.ui.Timeline
    public ProjectTimeline connectorPreviewStroke(String str, Number number, String str2, String str3, StrokeLineCap strokeLineCap) {
        APIlib.getInstance().addJSLine(String.format(Locale.US, this.jsBase + ".connectorPreviewStroke(%s, %s, %s, %s, %s);", wrapQuotes(str), number, wrapQuotes(str2), wrapQuotes(str3), strokeLineCap != null ? strokeLineCap.getJsBase() : null));
        return this;
    }

    @Override // com.anychart.core.ui.Timeline
    public ProjectTimeline connectorPreviewStroke(String str, Number number, String str2, StrokeLineJoin strokeLineJoin, String str3) {
        APIlib.getInstance().addJSLine(String.format(Locale.US, this.jsBase + ".connectorPreviewStroke(%s, %s, %s, %s, %s);", wrapQuotes(str), number, wrapQuotes(str2), strokeLineJoin != null ? strokeLineJoin.getJsBase() : null, wrapQuotes(str3)));
        return this;
    }

    @Override // com.anychart.core.ui.Timeline
    public ProjectTimeline connectorPreviewStroke(String str, Number number, String str2, StrokeLineJoin strokeLineJoin, StrokeLineCap strokeLineCap) {
        APIlib.getInstance().addJSLine(String.format(Locale.US, this.jsBase + ".connectorPreviewStroke(%s, %s, %s, %s, %s);", wrapQuotes(str), number, wrapQuotes(str2), strokeLineJoin != null ? strokeLineJoin.getJsBase() : null, strokeLineCap != null ? strokeLineCap.getJsBase() : null));
        return this;
    }

    @Override // com.anychart.core.ui.Timeline
    public void connectorStroke() {
        APIlib.getInstance().addJSLine(this.jsBase + ".connectorStroke();");
    }

    @Override // com.anychart.core.ui.Timeline
    public ProjectTimeline connectorStroke(Stroke stroke, Number number, String str, String str2, String str3) {
        APIlib.getInstance().addJSLine(String.format(Locale.US, this.jsBase + ".connectorStroke(%s, %s, %s, %s, %s);", stroke != null ? stroke.getJsBase() : null, number, wrapQuotes(str), wrapQuotes(str2), wrapQuotes(str3)));
        return this;
    }

    @Override // com.anychart.core.ui.Timeline
    public ProjectTimeline connectorStroke(Stroke stroke, Number number, String str, String str2, StrokeLineCap strokeLineCap) {
        APIlib.getInstance().addJSLine(String.format(Locale.US, this.jsBase + ".connectorStroke(%s, %s, %s, %s, %s);", stroke != null ? stroke.getJsBase() : null, number, wrapQuotes(str), wrapQuotes(str2), strokeLineCap != null ? strokeLineCap.getJsBase() : null));
        return this;
    }

    @Override // com.anychart.core.ui.Timeline
    public ProjectTimeline connectorStroke(Stroke stroke, Number number, String str, StrokeLineJoin strokeLineJoin, String str2) {
        APIlib.getInstance().addJSLine(String.format(Locale.US, this.jsBase + ".connectorStroke(%s, %s, %s, %s, %s);", stroke != null ? stroke.getJsBase() : null, number, wrapQuotes(str), strokeLineJoin != null ? strokeLineJoin.getJsBase() : null, wrapQuotes(str2)));
        return this;
    }

    @Override // com.anychart.core.ui.Timeline
    public ProjectTimeline connectorStroke(Stroke stroke, Number number, String str, StrokeLineJoin strokeLineJoin, StrokeLineCap strokeLineCap) {
        APIlib.getInstance().addJSLine(String.format(Locale.US, this.jsBase + ".connectorStroke(%s, %s, %s, %s, %s);", stroke != null ? stroke.getJsBase() : null, number, wrapQuotes(str), strokeLineJoin != null ? strokeLineJoin.getJsBase() : null, strokeLineCap != null ? strokeLineCap.getJsBase() : null));
        return this;
    }

    @Override // com.anychart.core.ui.Timeline
    public ProjectTimeline connectorStroke(ColoredFill coloredFill, Number number, String str, String str2, String str3) {
        APIlib.getInstance().addJSLine(String.format(Locale.US, this.jsBase + ".connectorStroke(%s, %s, %s, %s, %s);", coloredFill != null ? coloredFill.getJsBase() : null, number, wrapQuotes(str), wrapQuotes(str2), wrapQuotes(str3)));
        return this;
    }

    @Override // com.anychart.core.ui.Timeline
    public ProjectTimeline connectorStroke(ColoredFill coloredFill, Number number, String str, String str2, StrokeLineCap strokeLineCap) {
        APIlib.getInstance().addJSLine(String.format(Locale.US, this.jsBase + ".connectorStroke(%s, %s, %s, %s, %s);", coloredFill != null ? coloredFill.getJsBase() : null, number, wrapQuotes(str), wrapQuotes(str2), strokeLineCap != null ? strokeLineCap.getJsBase() : null));
        return this;
    }

    @Override // com.anychart.core.ui.Timeline
    public ProjectTimeline connectorStroke(ColoredFill coloredFill, Number number, String str, StrokeLineJoin strokeLineJoin, String str2) {
        APIlib.getInstance().addJSLine(String.format(Locale.US, this.jsBase + ".connectorStroke(%s, %s, %s, %s, %s);", coloredFill != null ? coloredFill.getJsBase() : null, number, wrapQuotes(str), strokeLineJoin != null ? strokeLineJoin.getJsBase() : null, wrapQuotes(str2)));
        return this;
    }

    @Override // com.anychart.core.ui.Timeline
    public ProjectTimeline connectorStroke(ColoredFill coloredFill, Number number, String str, StrokeLineJoin strokeLineJoin, StrokeLineCap strokeLineCap) {
        APIlib.getInstance().addJSLine(String.format(Locale.US, this.jsBase + ".connectorStroke(%s, %s, %s, %s, %s);", coloredFill != null ? coloredFill.getJsBase() : null, number, wrapQuotes(str), strokeLineJoin != null ? strokeLineJoin.getJsBase() : null, strokeLineCap != null ? strokeLineCap.getJsBase() : null));
        return this;
    }

    @Override // com.anychart.core.ui.Timeline
    public ProjectTimeline connectorStroke(String str, Number number, String str2, String str3, String str4) {
        APIlib.getInstance().addJSLine(String.format(Locale.US, this.jsBase + ".connectorStroke(%s, %s, %s, %s, %s);", wrapQuotes(str), number, wrapQuotes(str2), wrapQuotes(str3), wrapQuotes(str4)));
        return this;
    }

    @Override // com.anychart.core.ui.Timeline
    public ProjectTimeline connectorStroke(String str, Number number, String str2, String str3, StrokeLineCap strokeLineCap) {
        APIlib.getInstance().addJSLine(String.format(Locale.US, this.jsBase + ".connectorStroke(%s, %s, %s, %s, %s);", wrapQuotes(str), number, wrapQuotes(str2), wrapQuotes(str3), strokeLineCap != null ? strokeLineCap.getJsBase() : null));
        return this;
    }

    @Override // com.anychart.core.ui.Timeline
    public ProjectTimeline connectorStroke(String str, Number number, String str2, StrokeLineJoin strokeLineJoin, String str3) {
        APIlib.getInstance().addJSLine(String.format(Locale.US, this.jsBase + ".connectorStroke(%s, %s, %s, %s, %s);", wrapQuotes(str), number, wrapQuotes(str2), strokeLineJoin != null ? strokeLineJoin.getJsBase() : null, wrapQuotes(str3)));
        return this;
    }

    @Override // com.anychart.core.ui.Timeline
    public ProjectTimeline connectorStroke(String str, Number number, String str2, StrokeLineJoin strokeLineJoin, StrokeLineCap strokeLineCap) {
        APIlib.getInstance().addJSLine(String.format(Locale.US, this.jsBase + ".connectorStroke(%s, %s, %s, %s, %s);", wrapQuotes(str), number, wrapQuotes(str2), strokeLineJoin != null ? strokeLineJoin.getJsBase() : null, strokeLineCap != null ? strokeLineCap.getJsBase() : null));
        return this;
    }

    @Override // com.anychart.core.ui.Timeline
    public ProjectTimeline connectorStroke(String str) {
        APIlib.getInstance().addJSLine(String.format(Locale.US, this.jsBase + ".connectorStroke(%s);", wrapQuotes(str)));
        return this;
    }

    @Override // com.anychart.core.ui.Timeline
    public ConnectorElement connectors() {
        return new ConnectorElement(this.jsBase + ".connectors()");
    }

    @Override // com.anychart.core.ui.Timeline
    public ProjectTimeline connectors(String str) {
        APIlib.getInstance().addJSLine(String.format(Locale.US, this.jsBase + ".connectors(%s);", wrapQuotes(str)));
        return this;
    }

    public void defaultRowHeight() {
        APIlib.getInstance().addJSLine(this.jsBase + ".defaultRowHeight();");
    }

    public ProjectTimeline defaultRowHeight(Number number) {
        APIlib.getInstance().addJSLine(String.format(Locale.US, this.jsBase + ".defaultRowHeight(%s);", number));
        return this;
    }

    @Override // com.anychart.core.ui.Timeline
    public StructureEdit edit() {
        return new StructureEdit(this.jsBase + ".edit()");
    }

    @Override // com.anychart.core.ui.Timeline
    public ProjectTimeline edit(String str) {
        APIlib.getInstance().addJSLine(String.format(Locale.US, this.jsBase + ".edit(%s);", wrapQuotes(str)));
        return this;
    }

    @Override // com.anychart.core.ui.Timeline
    public ProjectTimeline edit(Boolean bool) {
        APIlib.getInstance().addJSLine(String.format(Locale.US, this.jsBase + ".edit(%s);", bool));
        return this;
    }

    @Override // com.anychart.core.ui.Timeline
    public void editConnectorThumbFill() {
        APIlib.getInstance().addJSLine(this.jsBase + ".editConnectorThumbFill();");
    }

    @Override // com.anychart.core.ui.Timeline
    public ProjectTimeline editConnectorThumbFill(Fill fill) {
        APIlib.getInstance().addJSLine(String.format(Locale.US, this.jsBase + ".editConnectorThumbFill(%s);", fill != null ? fill.getJsBase() : null));
        return this;
    }

    @Override // com.anychart.core.ui.Timeline
    public ProjectTimeline editConnectorThumbFill(String str, Number number) {
        APIlib.getInstance().addJSLine(String.format(Locale.US, this.jsBase + ".editConnectorThumbFill(%s, %s);", wrapQuotes(str), number));
        return this;
    }

    @Override // com.anychart.core.ui.Timeline
    public ProjectTimeline editConnectorThumbFill(GradientKey gradientKey, Number number, Boolean bool, Number number2) {
        APIlib.getInstance().addJSLine(String.format(Locale.US, this.jsBase + ".editConnectorThumbFill(%s, %s, %s, %s);", gradientKey != null ? gradientKey.getJsBase() : null, number, bool, number2));
        return this;
    }

    @Override // com.anychart.core.ui.Timeline
    public ProjectTimeline editConnectorThumbFill(GradientKey gradientKey, Number number, Rect rect, Number number2) {
        APIlib.getInstance().addJSLine(String.format(Locale.US, this.jsBase + ".editConnectorThumbFill(%s, %s, %s, %s);", gradientKey != null ? gradientKey.getJsBase() : null, number, rect != null ? rect.getJsBase() : null, number2));
        return this;
    }

    @Override // com.anychart.core.ui.Timeline
    public ProjectTimeline editConnectorThumbFill(GradientKey gradientKey, Number number, String str, Number number2) {
        APIlib.getInstance().addJSLine(String.format(Locale.US, this.jsBase + ".editConnectorThumbFill(%s, %s, %s, %s);", gradientKey != null ? gradientKey.getJsBase() : null, number, wrapQuotes(str), number2));
        return this;
    }

    @Override // com.anychart.core.ui.Timeline
    public ProjectTimeline editConnectorThumbFill(String[] strArr, Number number, Boolean bool, Number number2) {
        APIlib.getInstance().addJSLine(String.format(Locale.US, this.jsBase + ".editConnectorThumbFill(%s, %s, %s, %s);", arrayToStringWrapQuotes(strArr), number, bool, number2));
        return this;
    }

    @Override // com.anychart.core.ui.Timeline
    public ProjectTimeline editConnectorThumbFill(String[] strArr, Number number, Rect rect, Number number2) {
        APIlib.getInstance().addJSLine(String.format(Locale.US, this.jsBase + ".editConnectorThumbFill(%s, %s, %s, %s);", arrayToStringWrapQuotes(strArr), number, rect != null ? rect.getJsBase() : null, number2));
        return this;
    }

    @Override // com.anychart.core.ui.Timeline
    public ProjectTimeline editConnectorThumbFill(String[] strArr, Number number, String str, Number number2) {
        APIlib.getInstance().addJSLine(String.format(Locale.US, this.jsBase + ".editConnectorThumbFill(%s, %s, %s, %s);", arrayToStringWrapQuotes(strArr), number, wrapQuotes(str), number2));
        return this;
    }

    @Override // com.anychart.core.ui.Timeline
    public ProjectTimeline editConnectorThumbFill(GradientKey gradientKey, Number number, Number number2, com.anychart.graphics.math.Rect rect, Number number3, Number number4, Number number5) {
        APIlib.getInstance().addJSLine(String.format(Locale.US, this.jsBase + ".editConnectorThumbFill(%s, %s, %s, %s, %s, %s, %s);", gradientKey != null ? gradientKey.getJsBase() : null, number, number2, rect != null ? rect.getJsBase() : null, number3, number4, number5));
        return this;
    }

    @Override // com.anychart.core.ui.Timeline
    public ProjectTimeline editConnectorThumbFill(String[] strArr, Number number, Number number2, com.anychart.graphics.math.Rect rect, Number number3, Number number4, Number number5) {
        APIlib.getInstance().addJSLine(String.format(Locale.US, this.jsBase + ".editConnectorThumbFill(%s, %s, %s, %s, %s, %s, %s);", arrayToStringWrapQuotes(strArr), number, number2, rect != null ? rect.getJsBase() : null, number3, number4, number5));
        return this;
    }

    @Override // com.anychart.core.ui.Timeline
    public void editConnectorThumbStroke() {
        APIlib.getInstance().addJSLine(this.jsBase + ".editConnectorThumbStroke();");
    }

    @Override // com.anychart.core.ui.Timeline
    public ProjectTimeline editConnectorThumbStroke(Stroke stroke, Number number, String str, String str2, String str3) {
        APIlib.getInstance().addJSLine(String.format(Locale.US, this.jsBase + ".editConnectorThumbStroke(%s, %s, %s, %s, %s);", stroke != null ? stroke.getJsBase() : null, number, wrapQuotes(str), wrapQuotes(str2), wrapQuotes(str3)));
        return this;
    }

    @Override // com.anychart.core.ui.Timeline
    public ProjectTimeline editConnectorThumbStroke(Stroke stroke, Number number, String str, String str2, StrokeLineCap strokeLineCap) {
        APIlib.getInstance().addJSLine(String.format(Locale.US, this.jsBase + ".editConnectorThumbStroke(%s, %s, %s, %s, %s);", stroke != null ? stroke.getJsBase() : null, number, wrapQuotes(str), wrapQuotes(str2), strokeLineCap != null ? strokeLineCap.getJsBase() : null));
        return this;
    }

    @Override // com.anychart.core.ui.Timeline
    public ProjectTimeline editConnectorThumbStroke(Stroke stroke, Number number, String str, StrokeLineJoin strokeLineJoin, String str2) {
        APIlib.getInstance().addJSLine(String.format(Locale.US, this.jsBase + ".editConnectorThumbStroke(%s, %s, %s, %s, %s);", stroke != null ? stroke.getJsBase() : null, number, wrapQuotes(str), strokeLineJoin != null ? strokeLineJoin.getJsBase() : null, wrapQuotes(str2)));
        return this;
    }

    @Override // com.anychart.core.ui.Timeline
    public ProjectTimeline editConnectorThumbStroke(Stroke stroke, Number number, String str, StrokeLineJoin strokeLineJoin, StrokeLineCap strokeLineCap) {
        APIlib.getInstance().addJSLine(String.format(Locale.US, this.jsBase + ".editConnectorThumbStroke(%s, %s, %s, %s, %s);", stroke != null ? stroke.getJsBase() : null, number, wrapQuotes(str), strokeLineJoin != null ? strokeLineJoin.getJsBase() : null, strokeLineCap != null ? strokeLineCap.getJsBase() : null));
        return this;
    }

    @Override // com.anychart.core.ui.Timeline
    public ProjectTimeline editConnectorThumbStroke(ColoredFill coloredFill, Number number, String str, String str2, String str3) {
        APIlib.getInstance().addJSLine(String.format(Locale.US, this.jsBase + ".editConnectorThumbStroke(%s, %s, %s, %s, %s);", coloredFill != null ? coloredFill.getJsBase() : null, number, wrapQuotes(str), wrapQuotes(str2), wrapQuotes(str3)));
        return this;
    }

    @Override // com.anychart.core.ui.Timeline
    public ProjectTimeline editConnectorThumbStroke(ColoredFill coloredFill, Number number, String str, String str2, StrokeLineCap strokeLineCap) {
        APIlib.getInstance().addJSLine(String.format(Locale.US, this.jsBase + ".editConnectorThumbStroke(%s, %s, %s, %s, %s);", coloredFill != null ? coloredFill.getJsBase() : null, number, wrapQuotes(str), wrapQuotes(str2), strokeLineCap != null ? strokeLineCap.getJsBase() : null));
        return this;
    }

    @Override // com.anychart.core.ui.Timeline
    public ProjectTimeline editConnectorThumbStroke(ColoredFill coloredFill, Number number, String str, StrokeLineJoin strokeLineJoin, String str2) {
        APIlib.getInstance().addJSLine(String.format(Locale.US, this.jsBase + ".editConnectorThumbStroke(%s, %s, %s, %s, %s);", coloredFill != null ? coloredFill.getJsBase() : null, number, wrapQuotes(str), strokeLineJoin != null ? strokeLineJoin.getJsBase() : null, wrapQuotes(str2)));
        return this;
    }

    @Override // com.anychart.core.ui.Timeline
    public ProjectTimeline editConnectorThumbStroke(ColoredFill coloredFill, Number number, String str, StrokeLineJoin strokeLineJoin, StrokeLineCap strokeLineCap) {
        APIlib.getInstance().addJSLine(String.format(Locale.US, this.jsBase + ".editConnectorThumbStroke(%s, %s, %s, %s, %s);", coloredFill != null ? coloredFill.getJsBase() : null, number, wrapQuotes(str), strokeLineJoin != null ? strokeLineJoin.getJsBase() : null, strokeLineCap != null ? strokeLineCap.getJsBase() : null));
        return this;
    }

    @Override // com.anychart.core.ui.Timeline
    public ProjectTimeline editConnectorThumbStroke(String str, Number number, String str2, String str3, String str4) {
        APIlib.getInstance().addJSLine(String.format(Locale.US, this.jsBase + ".editConnectorThumbStroke(%s, %s, %s, %s, %s);", wrapQuotes(str), number, wrapQuotes(str2), wrapQuotes(str3), wrapQuotes(str4)));
        return this;
    }

    @Override // com.anychart.core.ui.Timeline
    public ProjectTimeline editConnectorThumbStroke(String str, Number number, String str2, String str3, StrokeLineCap strokeLineCap) {
        APIlib.getInstance().addJSLine(String.format(Locale.US, this.jsBase + ".editConnectorThumbStroke(%s, %s, %s, %s, %s);", wrapQuotes(str), number, wrapQuotes(str2), wrapQuotes(str3), strokeLineCap != null ? strokeLineCap.getJsBase() : null));
        return this;
    }

    @Override // com.anychart.core.ui.Timeline
    public ProjectTimeline editConnectorThumbStroke(String str, Number number, String str2, StrokeLineJoin strokeLineJoin, String str3) {
        APIlib.getInstance().addJSLine(String.format(Locale.US, this.jsBase + ".editConnectorThumbStroke(%s, %s, %s, %s, %s);", wrapQuotes(str), number, wrapQuotes(str2), strokeLineJoin != null ? strokeLineJoin.getJsBase() : null, wrapQuotes(str3)));
        return this;
    }

    @Override // com.anychart.core.ui.Timeline
    public ProjectTimeline editConnectorThumbStroke(String str, Number number, String str2, StrokeLineJoin strokeLineJoin, StrokeLineCap strokeLineCap) {
        APIlib.getInstance().addJSLine(String.format(Locale.US, this.jsBase + ".editConnectorThumbStroke(%s, %s, %s, %s, %s);", wrapQuotes(str), number, wrapQuotes(str2), strokeLineJoin != null ? strokeLineJoin.getJsBase() : null, strokeLineCap != null ? strokeLineCap.getJsBase() : null));
        return this;
    }

    @Override // com.anychart.core.ui.Timeline
    public void editIntervalThumbFill() {
        APIlib.getInstance().addJSLine(this.jsBase + ".editIntervalThumbFill();");
    }

    @Override // com.anychart.core.ui.Timeline
    public ProjectTimeline editIntervalThumbFill(Fill fill) {
        APIlib.getInstance().addJSLine(String.format(Locale.US, this.jsBase + ".editIntervalThumbFill(%s);", fill != null ? fill.getJsBase() : null));
        return this;
    }

    @Override // com.anychart.core.ui.Timeline
    public ProjectTimeline editIntervalThumbFill(String str, Number number) {
        APIlib.getInstance().addJSLine(String.format(Locale.US, this.jsBase + ".editIntervalThumbFill(%s, %s);", wrapQuotes(str), number));
        return this;
    }

    @Override // com.anychart.core.ui.Timeline
    public ProjectTimeline editIntervalThumbFill(GradientKey gradientKey, Number number, Boolean bool, Number number2) {
        APIlib.getInstance().addJSLine(String.format(Locale.US, this.jsBase + ".editIntervalThumbFill(%s, %s, %s, %s);", gradientKey != null ? gradientKey.getJsBase() : null, number, bool, number2));
        return this;
    }

    @Override // com.anychart.core.ui.Timeline
    public ProjectTimeline editIntervalThumbFill(GradientKey gradientKey, Number number, Rect rect, Number number2) {
        APIlib.getInstance().addJSLine(String.format(Locale.US, this.jsBase + ".editIntervalThumbFill(%s, %s, %s, %s);", gradientKey != null ? gradientKey.getJsBase() : null, number, rect != null ? rect.getJsBase() : null, number2));
        return this;
    }

    @Override // com.anychart.core.ui.Timeline
    public ProjectTimeline editIntervalThumbFill(GradientKey gradientKey, Number number, String str, Number number2) {
        APIlib.getInstance().addJSLine(String.format(Locale.US, this.jsBase + ".editIntervalThumbFill(%s, %s, %s, %s);", gradientKey != null ? gradientKey.getJsBase() : null, number, wrapQuotes(str), number2));
        return this;
    }

    @Override // com.anychart.core.ui.Timeline
    public ProjectTimeline editIntervalThumbFill(String[] strArr, Number number, Boolean bool, Number number2) {
        APIlib.getInstance().addJSLine(String.format(Locale.US, this.jsBase + ".editIntervalThumbFill(%s, %s, %s, %s);", arrayToStringWrapQuotes(strArr), number, bool, number2));
        return this;
    }

    @Override // com.anychart.core.ui.Timeline
    public ProjectTimeline editIntervalThumbFill(String[] strArr, Number number, Rect rect, Number number2) {
        APIlib.getInstance().addJSLine(String.format(Locale.US, this.jsBase + ".editIntervalThumbFill(%s, %s, %s, %s);", arrayToStringWrapQuotes(strArr), number, rect != null ? rect.getJsBase() : null, number2));
        return this;
    }

    @Override // com.anychart.core.ui.Timeline
    public ProjectTimeline editIntervalThumbFill(String[] strArr, Number number, String str, Number number2) {
        APIlib.getInstance().addJSLine(String.format(Locale.US, this.jsBase + ".editIntervalThumbFill(%s, %s, %s, %s);", arrayToStringWrapQuotes(strArr), number, wrapQuotes(str), number2));
        return this;
    }

    @Override // com.anychart.core.ui.Timeline
    public ProjectTimeline editIntervalThumbFill(GradientKey gradientKey, Number number, Number number2, com.anychart.graphics.math.Rect rect, Number number3, Number number4, Number number5) {
        APIlib.getInstance().addJSLine(String.format(Locale.US, this.jsBase + ".editIntervalThumbFill(%s, %s, %s, %s, %s, %s, %s);", gradientKey != null ? gradientKey.getJsBase() : null, number, number2, rect != null ? rect.getJsBase() : null, number3, number4, number5));
        return this;
    }

    @Override // com.anychart.core.ui.Timeline
    public ProjectTimeline editIntervalThumbFill(String[] strArr, Number number, Number number2, com.anychart.graphics.math.Rect rect, Number number3, Number number4, Number number5) {
        APIlib.getInstance().addJSLine(String.format(Locale.US, this.jsBase + ".editIntervalThumbFill(%s, %s, %s, %s, %s, %s, %s);", arrayToStringWrapQuotes(strArr), number, number2, rect != null ? rect.getJsBase() : null, number3, number4, number5));
        return this;
    }

    @Override // com.anychart.core.ui.Timeline
    public void editIntervalThumbStroke() {
        APIlib.getInstance().addJSLine(this.jsBase + ".editIntervalThumbStroke();");
    }

    @Override // com.anychart.core.ui.Timeline
    public ProjectTimeline editIntervalThumbStroke(Stroke stroke, Number number, String str, String str2, String str3) {
        APIlib.getInstance().addJSLine(String.format(Locale.US, this.jsBase + ".editIntervalThumbStroke(%s, %s, %s, %s, %s);", stroke != null ? stroke.getJsBase() : null, number, wrapQuotes(str), wrapQuotes(str2), wrapQuotes(str3)));
        return this;
    }

    @Override // com.anychart.core.ui.Timeline
    public ProjectTimeline editIntervalThumbStroke(Stroke stroke, Number number, String str, String str2, StrokeLineCap strokeLineCap) {
        APIlib.getInstance().addJSLine(String.format(Locale.US, this.jsBase + ".editIntervalThumbStroke(%s, %s, %s, %s, %s);", stroke != null ? stroke.getJsBase() : null, number, wrapQuotes(str), wrapQuotes(str2), strokeLineCap != null ? strokeLineCap.getJsBase() : null));
        return this;
    }

    @Override // com.anychart.core.ui.Timeline
    public ProjectTimeline editIntervalThumbStroke(Stroke stroke, Number number, String str, StrokeLineJoin strokeLineJoin, String str2) {
        APIlib.getInstance().addJSLine(String.format(Locale.US, this.jsBase + ".editIntervalThumbStroke(%s, %s, %s, %s, %s);", stroke != null ? stroke.getJsBase() : null, number, wrapQuotes(str), strokeLineJoin != null ? strokeLineJoin.getJsBase() : null, wrapQuotes(str2)));
        return this;
    }

    @Override // com.anychart.core.ui.Timeline
    public ProjectTimeline editIntervalThumbStroke(Stroke stroke, Number number, String str, StrokeLineJoin strokeLineJoin, StrokeLineCap strokeLineCap) {
        APIlib.getInstance().addJSLine(String.format(Locale.US, this.jsBase + ".editIntervalThumbStroke(%s, %s, %s, %s, %s);", stroke != null ? stroke.getJsBase() : null, number, wrapQuotes(str), strokeLineJoin != null ? strokeLineJoin.getJsBase() : null, strokeLineCap != null ? strokeLineCap.getJsBase() : null));
        return this;
    }

    @Override // com.anychart.core.ui.Timeline
    public ProjectTimeline editIntervalThumbStroke(ColoredFill coloredFill, Number number, String str, String str2, String str3) {
        APIlib.getInstance().addJSLine(String.format(Locale.US, this.jsBase + ".editIntervalThumbStroke(%s, %s, %s, %s, %s);", coloredFill != null ? coloredFill.getJsBase() : null, number, wrapQuotes(str), wrapQuotes(str2), wrapQuotes(str3)));
        return this;
    }

    @Override // com.anychart.core.ui.Timeline
    public ProjectTimeline editIntervalThumbStroke(ColoredFill coloredFill, Number number, String str, String str2, StrokeLineCap strokeLineCap) {
        APIlib.getInstance().addJSLine(String.format(Locale.US, this.jsBase + ".editIntervalThumbStroke(%s, %s, %s, %s, %s);", coloredFill != null ? coloredFill.getJsBase() : null, number, wrapQuotes(str), wrapQuotes(str2), strokeLineCap != null ? strokeLineCap.getJsBase() : null));
        return this;
    }

    @Override // com.anychart.core.ui.Timeline
    public ProjectTimeline editIntervalThumbStroke(ColoredFill coloredFill, Number number, String str, StrokeLineJoin strokeLineJoin, String str2) {
        APIlib.getInstance().addJSLine(String.format(Locale.US, this.jsBase + ".editIntervalThumbStroke(%s, %s, %s, %s, %s);", coloredFill != null ? coloredFill.getJsBase() : null, number, wrapQuotes(str), strokeLineJoin != null ? strokeLineJoin.getJsBase() : null, wrapQuotes(str2)));
        return this;
    }

    @Override // com.anychart.core.ui.Timeline
    public ProjectTimeline editIntervalThumbStroke(ColoredFill coloredFill, Number number, String str, StrokeLineJoin strokeLineJoin, StrokeLineCap strokeLineCap) {
        APIlib.getInstance().addJSLine(String.format(Locale.US, this.jsBase + ".editIntervalThumbStroke(%s, %s, %s, %s, %s);", coloredFill != null ? coloredFill.getJsBase() : null, number, wrapQuotes(str), strokeLineJoin != null ? strokeLineJoin.getJsBase() : null, strokeLineCap != null ? strokeLineCap.getJsBase() : null));
        return this;
    }

    @Override // com.anychart.core.ui.Timeline
    public ProjectTimeline editIntervalThumbStroke(String str, Number number, String str2, String str3, String str4) {
        APIlib.getInstance().addJSLine(String.format(Locale.US, this.jsBase + ".editIntervalThumbStroke(%s, %s, %s, %s, %s);", wrapQuotes(str), number, wrapQuotes(str2), wrapQuotes(str3), wrapQuotes(str4)));
        return this;
    }

    @Override // com.anychart.core.ui.Timeline
    public ProjectTimeline editIntervalThumbStroke(String str, Number number, String str2, String str3, StrokeLineCap strokeLineCap) {
        APIlib.getInstance().addJSLine(String.format(Locale.US, this.jsBase + ".editIntervalThumbStroke(%s, %s, %s, %s, %s);", wrapQuotes(str), number, wrapQuotes(str2), wrapQuotes(str3), strokeLineCap != null ? strokeLineCap.getJsBase() : null));
        return this;
    }

    @Override // com.anychart.core.ui.Timeline
    public ProjectTimeline editIntervalThumbStroke(String str, Number number, String str2, StrokeLineJoin strokeLineJoin, String str3) {
        APIlib.getInstance().addJSLine(String.format(Locale.US, this.jsBase + ".editIntervalThumbStroke(%s, %s, %s, %s, %s);", wrapQuotes(str), number, wrapQuotes(str2), strokeLineJoin != null ? strokeLineJoin.getJsBase() : null, wrapQuotes(str3)));
        return this;
    }

    @Override // com.anychart.core.ui.Timeline
    public ProjectTimeline editIntervalThumbStroke(String str, Number number, String str2, StrokeLineJoin strokeLineJoin, StrokeLineCap strokeLineCap) {
        APIlib.getInstance().addJSLine(String.format(Locale.US, this.jsBase + ".editIntervalThumbStroke(%s, %s, %s, %s, %s);", wrapQuotes(str), number, wrapQuotes(str2), strokeLineJoin != null ? strokeLineJoin.getJsBase() : null, strokeLineCap != null ? strokeLineCap.getJsBase() : null));
        return this;
    }

    @Override // com.anychart.core.ui.Timeline
    public void editPreviewFill() {
        APIlib.getInstance().addJSLine(this.jsBase + ".editPreviewFill();");
    }

    @Override // com.anychart.core.ui.Timeline
    public ProjectTimeline editPreviewFill(Fill fill) {
        APIlib.getInstance().addJSLine(String.format(Locale.US, this.jsBase + ".editPreviewFill(%s);", fill != null ? fill.getJsBase() : null));
        return this;
    }

    @Override // com.anychart.core.ui.Timeline
    public ProjectTimeline editPreviewFill(String str, Number number) {
        APIlib.getInstance().addJSLine(String.format(Locale.US, this.jsBase + ".editPreviewFill(%s, %s);", wrapQuotes(str), number));
        return this;
    }

    @Override // com.anychart.core.ui.Timeline
    public ProjectTimeline editPreviewFill(GradientKey gradientKey, Number number, Boolean bool, Number number2) {
        APIlib.getInstance().addJSLine(String.format(Locale.US, this.jsBase + ".editPreviewFill(%s, %s, %s, %s);", gradientKey != null ? gradientKey.getJsBase() : null, number, bool, number2));
        return this;
    }

    @Override // com.anychart.core.ui.Timeline
    public ProjectTimeline editPreviewFill(GradientKey gradientKey, Number number, Rect rect, Number number2) {
        APIlib.getInstance().addJSLine(String.format(Locale.US, this.jsBase + ".editPreviewFill(%s, %s, %s, %s);", gradientKey != null ? gradientKey.getJsBase() : null, number, rect != null ? rect.getJsBase() : null, number2));
        return this;
    }

    @Override // com.anychart.core.ui.Timeline
    public ProjectTimeline editPreviewFill(GradientKey gradientKey, Number number, String str, Number number2) {
        APIlib.getInstance().addJSLine(String.format(Locale.US, this.jsBase + ".editPreviewFill(%s, %s, %s, %s);", gradientKey != null ? gradientKey.getJsBase() : null, number, wrapQuotes(str), number2));
        return this;
    }

    @Override // com.anychart.core.ui.Timeline
    public ProjectTimeline editPreviewFill(String[] strArr, Number number, Boolean bool, Number number2) {
        APIlib.getInstance().addJSLine(String.format(Locale.US, this.jsBase + ".editPreviewFill(%s, %s, %s, %s);", arrayToStringWrapQuotes(strArr), number, bool, number2));
        return this;
    }

    @Override // com.anychart.core.ui.Timeline
    public ProjectTimeline editPreviewFill(String[] strArr, Number number, Rect rect, Number number2) {
        APIlib.getInstance().addJSLine(String.format(Locale.US, this.jsBase + ".editPreviewFill(%s, %s, %s, %s);", arrayToStringWrapQuotes(strArr), number, rect != null ? rect.getJsBase() : null, number2));
        return this;
    }

    @Override // com.anychart.core.ui.Timeline
    public ProjectTimeline editPreviewFill(String[] strArr, Number number, String str, Number number2) {
        APIlib.getInstance().addJSLine(String.format(Locale.US, this.jsBase + ".editPreviewFill(%s, %s, %s, %s);", arrayToStringWrapQuotes(strArr), number, wrapQuotes(str), number2));
        return this;
    }

    @Override // com.anychart.core.ui.Timeline
    public ProjectTimeline editPreviewFill(GradientKey gradientKey, Number number, Number number2, com.anychart.graphics.math.Rect rect, Number number3, Number number4, Number number5) {
        APIlib.getInstance().addJSLine(String.format(Locale.US, this.jsBase + ".editPreviewFill(%s, %s, %s, %s, %s, %s, %s);", gradientKey != null ? gradientKey.getJsBase() : null, number, number2, rect != null ? rect.getJsBase() : null, number3, number4, number5));
        return this;
    }

    @Override // com.anychart.core.ui.Timeline
    public ProjectTimeline editPreviewFill(String[] strArr, Number number, Number number2, com.anychart.graphics.math.Rect rect, Number number3, Number number4, Number number5) {
        APIlib.getInstance().addJSLine(String.format(Locale.US, this.jsBase + ".editPreviewFill(%s, %s, %s, %s, %s, %s, %s);", arrayToStringWrapQuotes(strArr), number, number2, rect != null ? rect.getJsBase() : null, number3, number4, number5));
        return this;
    }

    @Override // com.anychart.core.ui.Timeline
    public void editPreviewStroke() {
        APIlib.getInstance().addJSLine(this.jsBase + ".editPreviewStroke();");
    }

    @Override // com.anychart.core.ui.Timeline
    public ProjectTimeline editPreviewStroke(Stroke stroke, Number number, String str, String str2, String str3) {
        APIlib.getInstance().addJSLine(String.format(Locale.US, this.jsBase + ".editPreviewStroke(%s, %s, %s, %s, %s);", stroke != null ? stroke.getJsBase() : null, number, wrapQuotes(str), wrapQuotes(str2), wrapQuotes(str3)));
        return this;
    }

    @Override // com.anychart.core.ui.Timeline
    public ProjectTimeline editPreviewStroke(Stroke stroke, Number number, String str, String str2, StrokeLineCap strokeLineCap) {
        APIlib.getInstance().addJSLine(String.format(Locale.US, this.jsBase + ".editPreviewStroke(%s, %s, %s, %s, %s);", stroke != null ? stroke.getJsBase() : null, number, wrapQuotes(str), wrapQuotes(str2), strokeLineCap != null ? strokeLineCap.getJsBase() : null));
        return this;
    }

    @Override // com.anychart.core.ui.Timeline
    public ProjectTimeline editPreviewStroke(Stroke stroke, Number number, String str, StrokeLineJoin strokeLineJoin, String str2) {
        APIlib.getInstance().addJSLine(String.format(Locale.US, this.jsBase + ".editPreviewStroke(%s, %s, %s, %s, %s);", stroke != null ? stroke.getJsBase() : null, number, wrapQuotes(str), strokeLineJoin != null ? strokeLineJoin.getJsBase() : null, wrapQuotes(str2)));
        return this;
    }

    @Override // com.anychart.core.ui.Timeline
    public ProjectTimeline editPreviewStroke(Stroke stroke, Number number, String str, StrokeLineJoin strokeLineJoin, StrokeLineCap strokeLineCap) {
        APIlib.getInstance().addJSLine(String.format(Locale.US, this.jsBase + ".editPreviewStroke(%s, %s, %s, %s, %s);", stroke != null ? stroke.getJsBase() : null, number, wrapQuotes(str), strokeLineJoin != null ? strokeLineJoin.getJsBase() : null, strokeLineCap != null ? strokeLineCap.getJsBase() : null));
        return this;
    }

    @Override // com.anychart.core.ui.Timeline
    public ProjectTimeline editPreviewStroke(ColoredFill coloredFill, Number number, String str, String str2, String str3) {
        APIlib.getInstance().addJSLine(String.format(Locale.US, this.jsBase + ".editPreviewStroke(%s, %s, %s, %s, %s);", coloredFill != null ? coloredFill.getJsBase() : null, number, wrapQuotes(str), wrapQuotes(str2), wrapQuotes(str3)));
        return this;
    }

    @Override // com.anychart.core.ui.Timeline
    public ProjectTimeline editPreviewStroke(ColoredFill coloredFill, Number number, String str, String str2, StrokeLineCap strokeLineCap) {
        APIlib.getInstance().addJSLine(String.format(Locale.US, this.jsBase + ".editPreviewStroke(%s, %s, %s, %s, %s);", coloredFill != null ? coloredFill.getJsBase() : null, number, wrapQuotes(str), wrapQuotes(str2), strokeLineCap != null ? strokeLineCap.getJsBase() : null));
        return this;
    }

    @Override // com.anychart.core.ui.Timeline
    public ProjectTimeline editPreviewStroke(ColoredFill coloredFill, Number number, String str, StrokeLineJoin strokeLineJoin, String str2) {
        APIlib.getInstance().addJSLine(String.format(Locale.US, this.jsBase + ".editPreviewStroke(%s, %s, %s, %s, %s);", coloredFill != null ? coloredFill.getJsBase() : null, number, wrapQuotes(str), strokeLineJoin != null ? strokeLineJoin.getJsBase() : null, wrapQuotes(str2)));
        return this;
    }

    @Override // com.anychart.core.ui.Timeline
    public ProjectTimeline editPreviewStroke(ColoredFill coloredFill, Number number, String str, StrokeLineJoin strokeLineJoin, StrokeLineCap strokeLineCap) {
        APIlib.getInstance().addJSLine(String.format(Locale.US, this.jsBase + ".editPreviewStroke(%s, %s, %s, %s, %s);", coloredFill != null ? coloredFill.getJsBase() : null, number, wrapQuotes(str), strokeLineJoin != null ? strokeLineJoin.getJsBase() : null, strokeLineCap != null ? strokeLineCap.getJsBase() : null));
        return this;
    }

    @Override // com.anychart.core.ui.Timeline
    public ProjectTimeline editPreviewStroke(String str, Number number, String str2, String str3, String str4) {
        APIlib.getInstance().addJSLine(String.format(Locale.US, this.jsBase + ".editPreviewStroke(%s, %s, %s, %s, %s);", wrapQuotes(str), number, wrapQuotes(str2), wrapQuotes(str3), wrapQuotes(str4)));
        return this;
    }

    @Override // com.anychart.core.ui.Timeline
    public ProjectTimeline editPreviewStroke(String str, Number number, String str2, String str3, StrokeLineCap strokeLineCap) {
        APIlib.getInstance().addJSLine(String.format(Locale.US, this.jsBase + ".editPreviewStroke(%s, %s, %s, %s, %s);", wrapQuotes(str), number, wrapQuotes(str2), wrapQuotes(str3), strokeLineCap != null ? strokeLineCap.getJsBase() : null));
        return this;
    }

    @Override // com.anychart.core.ui.Timeline
    public ProjectTimeline editPreviewStroke(String str, Number number, String str2, StrokeLineJoin strokeLineJoin, String str3) {
        APIlib.getInstance().addJSLine(String.format(Locale.US, this.jsBase + ".editPreviewStroke(%s, %s, %s, %s, %s);", wrapQuotes(str), number, wrapQuotes(str2), strokeLineJoin != null ? strokeLineJoin.getJsBase() : null, wrapQuotes(str3)));
        return this;
    }

    @Override // com.anychart.core.ui.Timeline
    public ProjectTimeline editPreviewStroke(String str, Number number, String str2, StrokeLineJoin strokeLineJoin, StrokeLineCap strokeLineCap) {
        APIlib.getInstance().addJSLine(String.format(Locale.US, this.jsBase + ".editPreviewStroke(%s, %s, %s, %s, %s);", wrapQuotes(str), number, wrapQuotes(str2), strokeLineJoin != null ? strokeLineJoin.getJsBase() : null, strokeLineCap != null ? strokeLineCap.getJsBase() : null));
        return this;
    }

    @Override // com.anychart.core.ui.Timeline
    public void editProgressFill() {
        APIlib.getInstance().addJSLine(this.jsBase + ".editProgressFill();");
    }

    @Override // com.anychart.core.ui.Timeline
    public ProjectTimeline editProgressFill(Fill fill) {
        APIlib.getInstance().addJSLine(String.format(Locale.US, this.jsBase + ".editProgressFill(%s);", fill != null ? fill.getJsBase() : null));
        return this;
    }

    @Override // com.anychart.core.ui.Timeline
    public ProjectTimeline editProgressFill(String str, Number number) {
        APIlib.getInstance().addJSLine(String.format(Locale.US, this.jsBase + ".editProgressFill(%s, %s);", wrapQuotes(str), number));
        return this;
    }

    @Override // com.anychart.core.ui.Timeline
    public ProjectTimeline editProgressFill(GradientKey gradientKey, Number number, Boolean bool, Number number2) {
        APIlib.getInstance().addJSLine(String.format(Locale.US, this.jsBase + ".editProgressFill(%s, %s, %s, %s);", gradientKey != null ? gradientKey.getJsBase() : null, number, bool, number2));
        return this;
    }

    @Override // com.anychart.core.ui.Timeline
    public ProjectTimeline editProgressFill(GradientKey gradientKey, Number number, Rect rect, Number number2) {
        APIlib.getInstance().addJSLine(String.format(Locale.US, this.jsBase + ".editProgressFill(%s, %s, %s, %s);", gradientKey != null ? gradientKey.getJsBase() : null, number, rect != null ? rect.getJsBase() : null, number2));
        return this;
    }

    @Override // com.anychart.core.ui.Timeline
    public ProjectTimeline editProgressFill(GradientKey gradientKey, Number number, String str, Number number2) {
        APIlib.getInstance().addJSLine(String.format(Locale.US, this.jsBase + ".editProgressFill(%s, %s, %s, %s);", gradientKey != null ? gradientKey.getJsBase() : null, number, wrapQuotes(str), number2));
        return this;
    }

    @Override // com.anychart.core.ui.Timeline
    public ProjectTimeline editProgressFill(String[] strArr, Number number, Boolean bool, Number number2) {
        APIlib.getInstance().addJSLine(String.format(Locale.US, this.jsBase + ".editProgressFill(%s, %s, %s, %s);", arrayToStringWrapQuotes(strArr), number, bool, number2));
        return this;
    }

    @Override // com.anychart.core.ui.Timeline
    public ProjectTimeline editProgressFill(String[] strArr, Number number, Rect rect, Number number2) {
        APIlib.getInstance().addJSLine(String.format(Locale.US, this.jsBase + ".editProgressFill(%s, %s, %s, %s);", arrayToStringWrapQuotes(strArr), number, rect != null ? rect.getJsBase() : null, number2));
        return this;
    }

    @Override // com.anychart.core.ui.Timeline
    public ProjectTimeline editProgressFill(String[] strArr, Number number, String str, Number number2) {
        APIlib.getInstance().addJSLine(String.format(Locale.US, this.jsBase + ".editProgressFill(%s, %s, %s, %s);", arrayToStringWrapQuotes(strArr), number, wrapQuotes(str), number2));
        return this;
    }

    @Override // com.anychart.core.ui.Timeline
    public ProjectTimeline editProgressFill(GradientKey gradientKey, Number number, Number number2, com.anychart.graphics.math.Rect rect, Number number3, Number number4, Number number5) {
        APIlib.getInstance().addJSLine(String.format(Locale.US, this.jsBase + ".editProgressFill(%s, %s, %s, %s, %s, %s, %s);", gradientKey != null ? gradientKey.getJsBase() : null, number, number2, rect != null ? rect.getJsBase() : null, number3, number4, number5));
        return this;
    }

    @Override // com.anychart.core.ui.Timeline
    public ProjectTimeline editProgressFill(String[] strArr, Number number, Number number2, com.anychart.graphics.math.Rect rect, Number number3, Number number4, Number number5) {
        APIlib.getInstance().addJSLine(String.format(Locale.US, this.jsBase + ".editProgressFill(%s, %s, %s, %s, %s, %s, %s);", arrayToStringWrapQuotes(strArr), number, number2, rect != null ? rect.getJsBase() : null, number3, number4, number5));
        return this;
    }

    @Override // com.anychart.core.ui.Timeline
    public void editProgressStroke() {
        APIlib.getInstance().addJSLine(this.jsBase + ".editProgressStroke();");
    }

    @Override // com.anychart.core.ui.Timeline
    public ProjectTimeline editProgressStroke(Stroke stroke, Number number, String str, String str2, String str3) {
        APIlib.getInstance().addJSLine(String.format(Locale.US, this.jsBase + ".editProgressStroke(%s, %s, %s, %s, %s);", stroke != null ? stroke.getJsBase() : null, number, wrapQuotes(str), wrapQuotes(str2), wrapQuotes(str3)));
        return this;
    }

    @Override // com.anychart.core.ui.Timeline
    public ProjectTimeline editProgressStroke(Stroke stroke, Number number, String str, String str2, StrokeLineCap strokeLineCap) {
        APIlib.getInstance().addJSLine(String.format(Locale.US, this.jsBase + ".editProgressStroke(%s, %s, %s, %s, %s);", stroke != null ? stroke.getJsBase() : null, number, wrapQuotes(str), wrapQuotes(str2), strokeLineCap != null ? strokeLineCap.getJsBase() : null));
        return this;
    }

    @Override // com.anychart.core.ui.Timeline
    public ProjectTimeline editProgressStroke(Stroke stroke, Number number, String str, StrokeLineJoin strokeLineJoin, String str2) {
        APIlib.getInstance().addJSLine(String.format(Locale.US, this.jsBase + ".editProgressStroke(%s, %s, %s, %s, %s);", stroke != null ? stroke.getJsBase() : null, number, wrapQuotes(str), strokeLineJoin != null ? strokeLineJoin.getJsBase() : null, wrapQuotes(str2)));
        return this;
    }

    @Override // com.anychart.core.ui.Timeline
    public ProjectTimeline editProgressStroke(Stroke stroke, Number number, String str, StrokeLineJoin strokeLineJoin, StrokeLineCap strokeLineCap) {
        APIlib.getInstance().addJSLine(String.format(Locale.US, this.jsBase + ".editProgressStroke(%s, %s, %s, %s, %s);", stroke != null ? stroke.getJsBase() : null, number, wrapQuotes(str), strokeLineJoin != null ? strokeLineJoin.getJsBase() : null, strokeLineCap != null ? strokeLineCap.getJsBase() : null));
        return this;
    }

    @Override // com.anychart.core.ui.Timeline
    public ProjectTimeline editProgressStroke(ColoredFill coloredFill, Number number, String str, String str2, String str3) {
        APIlib.getInstance().addJSLine(String.format(Locale.US, this.jsBase + ".editProgressStroke(%s, %s, %s, %s, %s);", coloredFill != null ? coloredFill.getJsBase() : null, number, wrapQuotes(str), wrapQuotes(str2), wrapQuotes(str3)));
        return this;
    }

    @Override // com.anychart.core.ui.Timeline
    public ProjectTimeline editProgressStroke(ColoredFill coloredFill, Number number, String str, String str2, StrokeLineCap strokeLineCap) {
        APIlib.getInstance().addJSLine(String.format(Locale.US, this.jsBase + ".editProgressStroke(%s, %s, %s, %s, %s);", coloredFill != null ? coloredFill.getJsBase() : null, number, wrapQuotes(str), wrapQuotes(str2), strokeLineCap != null ? strokeLineCap.getJsBase() : null));
        return this;
    }

    @Override // com.anychart.core.ui.Timeline
    public ProjectTimeline editProgressStroke(ColoredFill coloredFill, Number number, String str, StrokeLineJoin strokeLineJoin, String str2) {
        APIlib.getInstance().addJSLine(String.format(Locale.US, this.jsBase + ".editProgressStroke(%s, %s, %s, %s, %s);", coloredFill != null ? coloredFill.getJsBase() : null, number, wrapQuotes(str), strokeLineJoin != null ? strokeLineJoin.getJsBase() : null, wrapQuotes(str2)));
        return this;
    }

    @Override // com.anychart.core.ui.Timeline
    public ProjectTimeline editProgressStroke(ColoredFill coloredFill, Number number, String str, StrokeLineJoin strokeLineJoin, StrokeLineCap strokeLineCap) {
        APIlib.getInstance().addJSLine(String.format(Locale.US, this.jsBase + ".editProgressStroke(%s, %s, %s, %s, %s);", coloredFill != null ? coloredFill.getJsBase() : null, number, wrapQuotes(str), strokeLineJoin != null ? strokeLineJoin.getJsBase() : null, strokeLineCap != null ? strokeLineCap.getJsBase() : null));
        return this;
    }

    @Override // com.anychart.core.ui.Timeline
    public ProjectTimeline editProgressStroke(String str, Number number, String str2, String str3, String str4) {
        APIlib.getInstance().addJSLine(String.format(Locale.US, this.jsBase + ".editProgressStroke(%s, %s, %s, %s, %s);", wrapQuotes(str), number, wrapQuotes(str2), wrapQuotes(str3), wrapQuotes(str4)));
        return this;
    }

    @Override // com.anychart.core.ui.Timeline
    public ProjectTimeline editProgressStroke(String str, Number number, String str2, String str3, StrokeLineCap strokeLineCap) {
        APIlib.getInstance().addJSLine(String.format(Locale.US, this.jsBase + ".editProgressStroke(%s, %s, %s, %s, %s);", wrapQuotes(str), number, wrapQuotes(str2), wrapQuotes(str3), strokeLineCap != null ? strokeLineCap.getJsBase() : null));
        return this;
    }

    @Override // com.anychart.core.ui.Timeline
    public ProjectTimeline editProgressStroke(String str, Number number, String str2, StrokeLineJoin strokeLineJoin, String str3) {
        APIlib.getInstance().addJSLine(String.format(Locale.US, this.jsBase + ".editProgressStroke(%s, %s, %s, %s, %s);", wrapQuotes(str), number, wrapQuotes(str2), strokeLineJoin != null ? strokeLineJoin.getJsBase() : null, wrapQuotes(str3)));
        return this;
    }

    @Override // com.anychart.core.ui.Timeline
    public ProjectTimeline editProgressStroke(String str, Number number, String str2, StrokeLineJoin strokeLineJoin, StrokeLineCap strokeLineCap) {
        APIlib.getInstance().addJSLine(String.format(Locale.US, this.jsBase + ".editProgressStroke(%s, %s, %s, %s, %s);", wrapQuotes(str), number, wrapQuotes(str2), strokeLineJoin != null ? strokeLineJoin.getJsBase() : null, strokeLineCap != null ? strokeLineCap.getJsBase() : null));
        return this;
    }

    @Override // com.anychart.core.ui.Timeline
    public void editStructurePreviewDashStroke() {
        APIlib.getInstance().addJSLine(this.jsBase + ".editStructurePreviewDashStroke();");
    }

    @Override // com.anychart.core.ui.Timeline
    public ProjectTimeline editStructurePreviewDashStroke(Stroke stroke, Number number, String str, String str2, String str3) {
        APIlib.getInstance().addJSLine(String.format(Locale.US, this.jsBase + ".editStructurePreviewDashStroke(%s, %s, %s, %s, %s);", stroke != null ? stroke.getJsBase() : null, number, wrapQuotes(str), wrapQuotes(str2), wrapQuotes(str3)));
        return this;
    }

    @Override // com.anychart.core.ui.Timeline
    public ProjectTimeline editStructurePreviewDashStroke(Stroke stroke, Number number, String str, String str2, StrokeLineCap strokeLineCap) {
        APIlib.getInstance().addJSLine(String.format(Locale.US, this.jsBase + ".editStructurePreviewDashStroke(%s, %s, %s, %s, %s);", stroke != null ? stroke.getJsBase() : null, number, wrapQuotes(str), wrapQuotes(str2), strokeLineCap != null ? strokeLineCap.getJsBase() : null));
        return this;
    }

    @Override // com.anychart.core.ui.Timeline
    public ProjectTimeline editStructurePreviewDashStroke(Stroke stroke, Number number, String str, StrokeLineJoin strokeLineJoin, String str2) {
        APIlib.getInstance().addJSLine(String.format(Locale.US, this.jsBase + ".editStructurePreviewDashStroke(%s, %s, %s, %s, %s);", stroke != null ? stroke.getJsBase() : null, number, wrapQuotes(str), strokeLineJoin != null ? strokeLineJoin.getJsBase() : null, wrapQuotes(str2)));
        return this;
    }

    @Override // com.anychart.core.ui.Timeline
    public ProjectTimeline editStructurePreviewDashStroke(Stroke stroke, Number number, String str, StrokeLineJoin strokeLineJoin, StrokeLineCap strokeLineCap) {
        APIlib.getInstance().addJSLine(String.format(Locale.US, this.jsBase + ".editStructurePreviewDashStroke(%s, %s, %s, %s, %s);", stroke != null ? stroke.getJsBase() : null, number, wrapQuotes(str), strokeLineJoin != null ? strokeLineJoin.getJsBase() : null, strokeLineCap != null ? strokeLineCap.getJsBase() : null));
        return this;
    }

    @Override // com.anychart.core.ui.Timeline
    public ProjectTimeline editStructurePreviewDashStroke(ColoredFill coloredFill, Number number, String str, String str2, String str3) {
        APIlib.getInstance().addJSLine(String.format(Locale.US, this.jsBase + ".editStructurePreviewDashStroke(%s, %s, %s, %s, %s);", coloredFill != null ? coloredFill.getJsBase() : null, number, wrapQuotes(str), wrapQuotes(str2), wrapQuotes(str3)));
        return this;
    }

    @Override // com.anychart.core.ui.Timeline
    public ProjectTimeline editStructurePreviewDashStroke(ColoredFill coloredFill, Number number, String str, String str2, StrokeLineCap strokeLineCap) {
        APIlib.getInstance().addJSLine(String.format(Locale.US, this.jsBase + ".editStructurePreviewDashStroke(%s, %s, %s, %s, %s);", coloredFill != null ? coloredFill.getJsBase() : null, number, wrapQuotes(str), wrapQuotes(str2), strokeLineCap != null ? strokeLineCap.getJsBase() : null));
        return this;
    }

    @Override // com.anychart.core.ui.Timeline
    public ProjectTimeline editStructurePreviewDashStroke(ColoredFill coloredFill, Number number, String str, StrokeLineJoin strokeLineJoin, String str2) {
        APIlib.getInstance().addJSLine(String.format(Locale.US, this.jsBase + ".editStructurePreviewDashStroke(%s, %s, %s, %s, %s);", coloredFill != null ? coloredFill.getJsBase() : null, number, wrapQuotes(str), strokeLineJoin != null ? strokeLineJoin.getJsBase() : null, wrapQuotes(str2)));
        return this;
    }

    @Override // com.anychart.core.ui.Timeline
    public ProjectTimeline editStructurePreviewDashStroke(ColoredFill coloredFill, Number number, String str, StrokeLineJoin strokeLineJoin, StrokeLineCap strokeLineCap) {
        APIlib.getInstance().addJSLine(String.format(Locale.US, this.jsBase + ".editStructurePreviewDashStroke(%s, %s, %s, %s, %s);", coloredFill != null ? coloredFill.getJsBase() : null, number, wrapQuotes(str), strokeLineJoin != null ? strokeLineJoin.getJsBase() : null, strokeLineCap != null ? strokeLineCap.getJsBase() : null));
        return this;
    }

    @Override // com.anychart.core.ui.Timeline
    public ProjectTimeline editStructurePreviewDashStroke(String str, Number number, String str2, String str3, String str4) {
        APIlib.getInstance().addJSLine(String.format(Locale.US, this.jsBase + ".editStructurePreviewDashStroke(%s, %s, %s, %s, %s);", wrapQuotes(str), number, wrapQuotes(str2), wrapQuotes(str3), wrapQuotes(str4)));
        return this;
    }

    @Override // com.anychart.core.ui.Timeline
    public ProjectTimeline editStructurePreviewDashStroke(String str, Number number, String str2, String str3, StrokeLineCap strokeLineCap) {
        APIlib.getInstance().addJSLine(String.format(Locale.US, this.jsBase + ".editStructurePreviewDashStroke(%s, %s, %s, %s, %s);", wrapQuotes(str), number, wrapQuotes(str2), wrapQuotes(str3), strokeLineCap != null ? strokeLineCap.getJsBase() : null));
        return this;
    }

    @Override // com.anychart.core.ui.Timeline
    public ProjectTimeline editStructurePreviewDashStroke(String str, Number number, String str2, StrokeLineJoin strokeLineJoin, String str3) {
        APIlib.getInstance().addJSLine(String.format(Locale.US, this.jsBase + ".editStructurePreviewDashStroke(%s, %s, %s, %s, %s);", wrapQuotes(str), number, wrapQuotes(str2), strokeLineJoin != null ? strokeLineJoin.getJsBase() : null, wrapQuotes(str3)));
        return this;
    }

    @Override // com.anychart.core.ui.Timeline
    public ProjectTimeline editStructurePreviewDashStroke(String str, Number number, String str2, StrokeLineJoin strokeLineJoin, StrokeLineCap strokeLineCap) {
        APIlib.getInstance().addJSLine(String.format(Locale.US, this.jsBase + ".editStructurePreviewDashStroke(%s, %s, %s, %s, %s);", wrapQuotes(str), number, wrapQuotes(str2), strokeLineJoin != null ? strokeLineJoin.getJsBase() : null, strokeLineCap != null ? strokeLineCap.getJsBase() : null));
        return this;
    }

    @Override // com.anychart.core.ui.Timeline
    public void editStructurePreviewFill() {
        APIlib.getInstance().addJSLine(this.jsBase + ".editStructurePreviewFill();");
    }

    @Override // com.anychart.core.ui.Timeline
    public ProjectTimeline editStructurePreviewFill(Fill fill) {
        APIlib.getInstance().addJSLine(String.format(Locale.US, this.jsBase + ".editStructurePreviewFill(%s);", fill != null ? fill.getJsBase() : null));
        return this;
    }

    @Override // com.anychart.core.ui.Timeline
    public ProjectTimeline editStructurePreviewFill(String str, Number number) {
        APIlib.getInstance().addJSLine(String.format(Locale.US, this.jsBase + ".editStructurePreviewFill(%s, %s);", wrapQuotes(str), number));
        return this;
    }

    @Override // com.anychart.core.ui.Timeline
    public ProjectTimeline editStructurePreviewFill(GradientKey gradientKey, Number number, Boolean bool, Number number2) {
        APIlib.getInstance().addJSLine(String.format(Locale.US, this.jsBase + ".editStructurePreviewFill(%s, %s, %s, %s);", gradientKey != null ? gradientKey.getJsBase() : null, number, bool, number2));
        return this;
    }

    @Override // com.anychart.core.ui.Timeline
    public ProjectTimeline editStructurePreviewFill(GradientKey gradientKey, Number number, Rect rect, Number number2) {
        APIlib.getInstance().addJSLine(String.format(Locale.US, this.jsBase + ".editStructurePreviewFill(%s, %s, %s, %s);", gradientKey != null ? gradientKey.getJsBase() : null, number, rect != null ? rect.getJsBase() : null, number2));
        return this;
    }

    @Override // com.anychart.core.ui.Timeline
    public ProjectTimeline editStructurePreviewFill(GradientKey gradientKey, Number number, String str, Number number2) {
        APIlib.getInstance().addJSLine(String.format(Locale.US, this.jsBase + ".editStructurePreviewFill(%s, %s, %s, %s);", gradientKey != null ? gradientKey.getJsBase() : null, number, wrapQuotes(str), number2));
        return this;
    }

    @Override // com.anychart.core.ui.Timeline
    public ProjectTimeline editStructurePreviewFill(String[] strArr, Number number, Boolean bool, Number number2) {
        APIlib.getInstance().addJSLine(String.format(Locale.US, this.jsBase + ".editStructurePreviewFill(%s, %s, %s, %s);", arrayToStringWrapQuotes(strArr), number, bool, number2));
        return this;
    }

    @Override // com.anychart.core.ui.Timeline
    public ProjectTimeline editStructurePreviewFill(String[] strArr, Number number, Rect rect, Number number2) {
        APIlib.getInstance().addJSLine(String.format(Locale.US, this.jsBase + ".editStructurePreviewFill(%s, %s, %s, %s);", arrayToStringWrapQuotes(strArr), number, rect != null ? rect.getJsBase() : null, number2));
        return this;
    }

    @Override // com.anychart.core.ui.Timeline
    public ProjectTimeline editStructurePreviewFill(String[] strArr, Number number, String str, Number number2) {
        APIlib.getInstance().addJSLine(String.format(Locale.US, this.jsBase + ".editStructurePreviewFill(%s, %s, %s, %s);", arrayToStringWrapQuotes(strArr), number, wrapQuotes(str), number2));
        return this;
    }

    @Override // com.anychart.core.ui.Timeline
    public ProjectTimeline editStructurePreviewFill(GradientKey gradientKey, Number number, Number number2, com.anychart.graphics.math.Rect rect, Number number3, Number number4, Number number5) {
        APIlib.getInstance().addJSLine(String.format(Locale.US, this.jsBase + ".editStructurePreviewFill(%s, %s, %s, %s, %s, %s, %s);", gradientKey != null ? gradientKey.getJsBase() : null, number, number2, rect != null ? rect.getJsBase() : null, number3, number4, number5));
        return this;
    }

    @Override // com.anychart.core.ui.Timeline
    public ProjectTimeline editStructurePreviewFill(String[] strArr, Number number, Number number2, com.anychart.graphics.math.Rect rect, Number number3, Number number4, Number number5) {
        APIlib.getInstance().addJSLine(String.format(Locale.US, this.jsBase + ".editStructurePreviewFill(%s, %s, %s, %s, %s, %s, %s);", arrayToStringWrapQuotes(strArr), number, number2, rect != null ? rect.getJsBase() : null, number3, number4, number5));
        return this;
    }

    @Override // com.anychart.core.ui.Timeline
    public void editStructurePreviewStroke() {
        APIlib.getInstance().addJSLine(this.jsBase + ".editStructurePreviewStroke();");
    }

    @Override // com.anychart.core.ui.Timeline
    public ProjectTimeline editStructurePreviewStroke(Stroke stroke, Number number, String str, String str2, String str3) {
        APIlib.getInstance().addJSLine(String.format(Locale.US, this.jsBase + ".editStructurePreviewStroke(%s, %s, %s, %s, %s);", stroke != null ? stroke.getJsBase() : null, number, wrapQuotes(str), wrapQuotes(str2), wrapQuotes(str3)));
        return this;
    }

    @Override // com.anychart.core.ui.Timeline
    public ProjectTimeline editStructurePreviewStroke(Stroke stroke, Number number, String str, String str2, StrokeLineCap strokeLineCap) {
        APIlib.getInstance().addJSLine(String.format(Locale.US, this.jsBase + ".editStructurePreviewStroke(%s, %s, %s, %s, %s);", stroke != null ? stroke.getJsBase() : null, number, wrapQuotes(str), wrapQuotes(str2), strokeLineCap != null ? strokeLineCap.getJsBase() : null));
        return this;
    }

    @Override // com.anychart.core.ui.Timeline
    public ProjectTimeline editStructurePreviewStroke(Stroke stroke, Number number, String str, StrokeLineJoin strokeLineJoin, String str2) {
        APIlib.getInstance().addJSLine(String.format(Locale.US, this.jsBase + ".editStructurePreviewStroke(%s, %s, %s, %s, %s);", stroke != null ? stroke.getJsBase() : null, number, wrapQuotes(str), strokeLineJoin != null ? strokeLineJoin.getJsBase() : null, wrapQuotes(str2)));
        return this;
    }

    @Override // com.anychart.core.ui.Timeline
    public ProjectTimeline editStructurePreviewStroke(Stroke stroke, Number number, String str, StrokeLineJoin strokeLineJoin, StrokeLineCap strokeLineCap) {
        APIlib.getInstance().addJSLine(String.format(Locale.US, this.jsBase + ".editStructurePreviewStroke(%s, %s, %s, %s, %s);", stroke != null ? stroke.getJsBase() : null, number, wrapQuotes(str), strokeLineJoin != null ? strokeLineJoin.getJsBase() : null, strokeLineCap != null ? strokeLineCap.getJsBase() : null));
        return this;
    }

    @Override // com.anychart.core.ui.Timeline
    public ProjectTimeline editStructurePreviewStroke(ColoredFill coloredFill, Number number, String str, String str2, String str3) {
        APIlib.getInstance().addJSLine(String.format(Locale.US, this.jsBase + ".editStructurePreviewStroke(%s, %s, %s, %s, %s);", coloredFill != null ? coloredFill.getJsBase() : null, number, wrapQuotes(str), wrapQuotes(str2), wrapQuotes(str3)));
        return this;
    }

    @Override // com.anychart.core.ui.Timeline
    public ProjectTimeline editStructurePreviewStroke(ColoredFill coloredFill, Number number, String str, String str2, StrokeLineCap strokeLineCap) {
        APIlib.getInstance().addJSLine(String.format(Locale.US, this.jsBase + ".editStructurePreviewStroke(%s, %s, %s, %s, %s);", coloredFill != null ? coloredFill.getJsBase() : null, number, wrapQuotes(str), wrapQuotes(str2), strokeLineCap != null ? strokeLineCap.getJsBase() : null));
        return this;
    }

    @Override // com.anychart.core.ui.Timeline
    public ProjectTimeline editStructurePreviewStroke(ColoredFill coloredFill, Number number, String str, StrokeLineJoin strokeLineJoin, String str2) {
        APIlib.getInstance().addJSLine(String.format(Locale.US, this.jsBase + ".editStructurePreviewStroke(%s, %s, %s, %s, %s);", coloredFill != null ? coloredFill.getJsBase() : null, number, wrapQuotes(str), strokeLineJoin != null ? strokeLineJoin.getJsBase() : null, wrapQuotes(str2)));
        return this;
    }

    @Override // com.anychart.core.ui.Timeline
    public ProjectTimeline editStructurePreviewStroke(ColoredFill coloredFill, Number number, String str, StrokeLineJoin strokeLineJoin, StrokeLineCap strokeLineCap) {
        APIlib.getInstance().addJSLine(String.format(Locale.US, this.jsBase + ".editStructurePreviewStroke(%s, %s, %s, %s, %s);", coloredFill != null ? coloredFill.getJsBase() : null, number, wrapQuotes(str), strokeLineJoin != null ? strokeLineJoin.getJsBase() : null, strokeLineCap != null ? strokeLineCap.getJsBase() : null));
        return this;
    }

    @Override // com.anychart.core.ui.Timeline
    public ProjectTimeline editStructurePreviewStroke(String str, Number number, String str2, String str3, String str4) {
        APIlib.getInstance().addJSLine(String.format(Locale.US, this.jsBase + ".editStructurePreviewStroke(%s, %s, %s, %s, %s);", wrapQuotes(str), number, wrapQuotes(str2), wrapQuotes(str3), wrapQuotes(str4)));
        return this;
    }

    @Override // com.anychart.core.ui.Timeline
    public ProjectTimeline editStructurePreviewStroke(String str, Number number, String str2, String str3, StrokeLineCap strokeLineCap) {
        APIlib.getInstance().addJSLine(String.format(Locale.US, this.jsBase + ".editStructurePreviewStroke(%s, %s, %s, %s, %s);", wrapQuotes(str), number, wrapQuotes(str2), wrapQuotes(str3), strokeLineCap != null ? strokeLineCap.getJsBase() : null));
        return this;
    }

    @Override // com.anychart.core.ui.Timeline
    public ProjectTimeline editStructurePreviewStroke(String str, Number number, String str2, StrokeLineJoin strokeLineJoin, String str3) {
        APIlib.getInstance().addJSLine(String.format(Locale.US, this.jsBase + ".editStructurePreviewStroke(%s, %s, %s, %s, %s);", wrapQuotes(str), number, wrapQuotes(str2), strokeLineJoin != null ? strokeLineJoin.getJsBase() : null, wrapQuotes(str3)));
        return this;
    }

    @Override // com.anychart.core.ui.Timeline
    public ProjectTimeline editStructurePreviewStroke(String str, Number number, String str2, StrokeLineJoin strokeLineJoin, StrokeLineCap strokeLineCap) {
        APIlib.getInstance().addJSLine(String.format(Locale.US, this.jsBase + ".editStructurePreviewStroke(%s, %s, %s, %s, %s);", wrapQuotes(str), number, wrapQuotes(str2), strokeLineJoin != null ? strokeLineJoin.getJsBase() : null, strokeLineCap != null ? strokeLineCap.getJsBase() : null));
        return this;
    }

    @Override // com.anychart.core.ui.Timeline
    public void editing() {
        APIlib.getInstance().addJSLine(this.jsBase + ".editing();");
    }

    @Override // com.anychart.core.ui.Timeline
    public ProjectTimeline editing(Boolean bool) {
        APIlib.getInstance().addJSLine(String.format(Locale.US, this.jsBase + ".editing(%s);", bool));
        return this;
    }

    @Override // com.anychart.core.ui.Timeline
    public TimelineElement elements() {
        return new TimelineElement(this.jsBase + ".elements()");
    }

    @Override // com.anychart.core.ui.Timeline
    public ProjectTimeline elements(String str) {
        APIlib.getInstance().addJSLine(String.format(Locale.US, this.jsBase + ".elements(%s);", wrapQuotes(str)));
        return this;
    }

    @Override // com.anychart.core.ui.Timeline
    public GroupingTasksElement groupingTasks() {
        return new GroupingTasksElement(this.jsBase + ".groupingTasks()");
    }

    @Override // com.anychart.core.ui.Timeline
    public ProjectTimeline groupingTasks(String str) {
        APIlib.getInstance().addJSLine(String.format(Locale.US, this.jsBase + ".groupingTasks(%s);", wrapQuotes(str)));
        return this;
    }

    @Override // com.anychart.core.ui.Timeline
    public com.anychart.core.ui.LabelsFactory labels() {
        return new com.anychart.core.ui.LabelsFactory(this.jsBase + ".labels()");
    }

    @Override // com.anychart.core.ui.Timeline
    public ProjectTimeline labels(String str) {
        APIlib.getInstance().addJSLine(String.format(Locale.US, this.jsBase + ".labels(%s);", wrapQuotes(str)));
        return this;
    }

    @Override // com.anychart.core.ui.Timeline
    public GanttLine lineMarker(Number number) {
        return new GanttLine(String.format(Locale.US, this.jsBase + ".lineMarker(%s)", number));
    }

    @Override // com.anychart.core.ui.Timeline
    public ProjectTimeline lineMarker(String str) {
        APIlib.getInstance().addJSLine(String.format(Locale.US, this.jsBase + ".lineMarker(%s);", wrapQuotes(str)));
        return this;
    }

    @Override // com.anychart.core.ui.Timeline
    public ProjectTimeline lineMarker(Boolean bool) {
        APIlib.getInstance().addJSLine(String.format(Locale.US, this.jsBase + ".lineMarker(%s);", bool));
        return this;
    }

    @Override // com.anychart.core.ui.Timeline
    public ProjectTimeline lineMarker(Number number, String str) {
        APIlib.getInstance().addJSLine(String.format(Locale.US, this.jsBase + ".lineMarker(%s, %s);", number, wrapQuotes(str)));
        return this;
    }

    @Override // com.anychart.core.ui.Timeline
    public ProjectTimeline lineMarker(Number number, Boolean bool) {
        APIlib.getInstance().addJSLine(String.format(Locale.US, this.jsBase + ".lineMarker(%s, %s);", number, bool));
        return this;
    }

    @Override // com.anychart.core.ui.Timeline
    public ProjectTimeline lineMarker(Number number, GanttDateTimeMarkers ganttDateTimeMarkers) {
        APIlib.getInstance().addJSLine(String.format(Locale.US, this.jsBase + ".lineMarker(%s, %s);", number, ganttDateTimeMarkers != null ? ganttDateTimeMarkers.getJsBase() : null));
        return this;
    }

    @Override // com.anychart.core.ui.Timeline
    public com.anychart.core.ui.MarkersFactory markers() {
        return new com.anychart.core.ui.MarkersFactory(this.jsBase + ".markers()");
    }

    @Override // com.anychart.core.ui.Timeline
    public ProjectTimeline markers(String str) {
        APIlib.getInstance().addJSLine(String.format(Locale.US, this.jsBase + ".markers(%s);", wrapQuotes(str)));
        return this;
    }

    @Override // com.anychart.core.ui.Timeline
    public void maximumGap() {
        APIlib.getInstance().addJSLine(this.jsBase + ".maximumGap();");
    }

    @Override // com.anychart.core.ui.Timeline
    public ProjectTimeline maximumGap(Number number) {
        APIlib.getInstance().addJSLine(String.format(Locale.US, this.jsBase + ".maximumGap(%s);", number));
        return this;
    }

    @Override // com.anychart.core.ui.Timeline
    public void milestoneAnchor() {
        APIlib.getInstance().addJSLine(this.jsBase + ".milestoneAnchor();");
    }

    @Override // com.anychart.core.ui.Timeline
    public ProjectTimeline milestoneAnchor(String str) {
        APIlib.getInstance().addJSLine(String.format(Locale.US, this.jsBase + ".milestoneAnchor(%s);", wrapQuotes(str)));
        return this;
    }

    @Override // com.anychart.core.ui.Timeline
    public ProjectTimeline milestoneAnchor(Anchor anchor) {
        APIlib.getInstance().addJSLine(String.format(Locale.US, this.jsBase + ".milestoneAnchor(%s);", anchor != null ? anchor.getJsBase() : null));
        return this;
    }

    @Override // com.anychart.core.ui.Timeline
    public void milestoneFill() {
        APIlib.getInstance().addJSLine(this.jsBase + ".milestoneFill();");
    }

    @Override // com.anychart.core.ui.Timeline
    public ProjectTimeline milestoneFill(Fill fill) {
        APIlib.getInstance().addJSLine(String.format(Locale.US, this.jsBase + ".milestoneFill(%s);", fill != null ? fill.getJsBase() : null));
        return this;
    }

    @Override // com.anychart.core.ui.Timeline
    public ProjectTimeline milestoneFill(String str, Number number) {
        APIlib.getInstance().addJSLine(String.format(Locale.US, this.jsBase + ".milestoneFill(%s, %s);", wrapQuotes(str), number));
        return this;
    }

    @Override // com.anychart.core.ui.Timeline
    public ProjectTimeline milestoneFill(GradientKey gradientKey, Number number, Boolean bool, Number number2) {
        APIlib.getInstance().addJSLine(String.format(Locale.US, this.jsBase + ".milestoneFill(%s, %s, %s, %s);", gradientKey != null ? gradientKey.getJsBase() : null, number, bool, number2));
        return this;
    }

    @Override // com.anychart.core.ui.Timeline
    public ProjectTimeline milestoneFill(GradientKey gradientKey, Number number, Rect rect, Number number2) {
        APIlib.getInstance().addJSLine(String.format(Locale.US, this.jsBase + ".milestoneFill(%s, %s, %s, %s);", gradientKey != null ? gradientKey.getJsBase() : null, number, rect != null ? rect.getJsBase() : null, number2));
        return this;
    }

    @Override // com.anychart.core.ui.Timeline
    public ProjectTimeline milestoneFill(GradientKey gradientKey, Number number, String str, Number number2) {
        APIlib.getInstance().addJSLine(String.format(Locale.US, this.jsBase + ".milestoneFill(%s, %s, %s, %s);", gradientKey != null ? gradientKey.getJsBase() : null, number, wrapQuotes(str), number2));
        return this;
    }

    @Override // com.anychart.core.ui.Timeline
    public ProjectTimeline milestoneFill(String[] strArr, Number number, Boolean bool, Number number2) {
        APIlib.getInstance().addJSLine(String.format(Locale.US, this.jsBase + ".milestoneFill(%s, %s, %s, %s);", arrayToStringWrapQuotes(strArr), number, bool, number2));
        return this;
    }

    @Override // com.anychart.core.ui.Timeline
    public ProjectTimeline milestoneFill(String[] strArr, Number number, Rect rect, Number number2) {
        APIlib.getInstance().addJSLine(String.format(Locale.US, this.jsBase + ".milestoneFill(%s, %s, %s, %s);", arrayToStringWrapQuotes(strArr), number, rect != null ? rect.getJsBase() : null, number2));
        return this;
    }

    @Override // com.anychart.core.ui.Timeline
    public ProjectTimeline milestoneFill(String[] strArr, Number number, String str, Number number2) {
        APIlib.getInstance().addJSLine(String.format(Locale.US, this.jsBase + ".milestoneFill(%s, %s, %s, %s);", arrayToStringWrapQuotes(strArr), number, wrapQuotes(str), number2));
        return this;
    }

    @Override // com.anychart.core.ui.Timeline
    public ProjectTimeline milestoneFill(GradientKey gradientKey, Number number, Number number2, com.anychart.graphics.math.Rect rect, Number number3, Number number4, Number number5) {
        APIlib.getInstance().addJSLine(String.format(Locale.US, this.jsBase + ".milestoneFill(%s, %s, %s, %s, %s, %s, %s);", gradientKey != null ? gradientKey.getJsBase() : null, number, number2, rect != null ? rect.getJsBase() : null, number3, number4, number5));
        return this;
    }

    @Override // com.anychart.core.ui.Timeline
    public ProjectTimeline milestoneFill(String[] strArr, Number number, Number number2, com.anychart.graphics.math.Rect rect, Number number3, Number number4, Number number5) {
        APIlib.getInstance().addJSLine(String.format(Locale.US, this.jsBase + ".milestoneFill(%s, %s, %s, %s, %s, %s, %s);", arrayToStringWrapQuotes(strArr), number, number2, rect != null ? rect.getJsBase() : null, number3, number4, number5));
        return this;
    }

    @Override // com.anychart.core.ui.Timeline
    public void milestoneHeight() {
        APIlib.getInstance().addJSLine(this.jsBase + ".milestoneHeight();");
    }

    @Override // com.anychart.core.ui.Timeline
    public ProjectTimeline milestoneHeight(String str) {
        APIlib.getInstance().addJSLine(String.format(Locale.US, this.jsBase + ".milestoneHeight(%s);", wrapQuotes(str)));
        return this;
    }

    @Override // com.anychart.core.ui.Timeline
    public ProjectTimeline milestoneHeight(Number number) {
        APIlib.getInstance().addJSLine(String.format(Locale.US, this.jsBase + ".milestoneHeight(%s);", number));
        return this;
    }

    @Override // com.anychart.core.ui.Timeline
    public void milestoneOffset() {
        APIlib.getInstance().addJSLine(this.jsBase + ".milestoneOffset();");
    }

    @Override // com.anychart.core.ui.Timeline
    public ProjectTimeline milestoneOffset(String str) {
        APIlib.getInstance().addJSLine(String.format(Locale.US, this.jsBase + ".milestoneOffset(%s);", wrapQuotes(str)));
        return this;
    }

    @Override // com.anychart.core.ui.Timeline
    public ProjectTimeline milestoneOffset(Number number) {
        APIlib.getInstance().addJSLine(String.format(Locale.US, this.jsBase + ".milestoneOffset(%s);", number));
        return this;
    }

    @Override // com.anychart.core.ui.Timeline
    public void milestonePosition() {
        APIlib.getInstance().addJSLine(this.jsBase + ".milestonePosition();");
    }

    @Override // com.anychart.core.ui.Timeline
    public ProjectTimeline milestonePosition(String str) {
        APIlib.getInstance().addJSLine(String.format(Locale.US, this.jsBase + ".milestonePosition(%s);", wrapQuotes(str)));
        return this;
    }

    @Override // com.anychart.core.ui.Timeline
    public ProjectTimeline milestonePosition(Anchor anchor) {
        APIlib.getInstance().addJSLine(String.format(Locale.US, this.jsBase + ".milestonePosition(%s);", anchor != null ? anchor.getJsBase() : null));
        return this;
    }

    @Override // com.anychart.core.ui.Timeline
    public void milestoneStroke() {
        APIlib.getInstance().addJSLine(this.jsBase + ".milestoneStroke();");
    }

    @Override // com.anychart.core.ui.Timeline
    public ProjectTimeline milestoneStroke(Stroke stroke, Number number, String str, String str2, String str3) {
        APIlib.getInstance().addJSLine(String.format(Locale.US, this.jsBase + ".milestoneStroke(%s, %s, %s, %s, %s);", stroke != null ? stroke.getJsBase() : null, number, wrapQuotes(str), wrapQuotes(str2), wrapQuotes(str3)));
        return this;
    }

    @Override // com.anychart.core.ui.Timeline
    public ProjectTimeline milestoneStroke(Stroke stroke, Number number, String str, String str2, StrokeLineCap strokeLineCap) {
        APIlib.getInstance().addJSLine(String.format(Locale.US, this.jsBase + ".milestoneStroke(%s, %s, %s, %s, %s);", stroke != null ? stroke.getJsBase() : null, number, wrapQuotes(str), wrapQuotes(str2), strokeLineCap != null ? strokeLineCap.getJsBase() : null));
        return this;
    }

    @Override // com.anychart.core.ui.Timeline
    public ProjectTimeline milestoneStroke(Stroke stroke, Number number, String str, StrokeLineJoin strokeLineJoin, String str2) {
        APIlib.getInstance().addJSLine(String.format(Locale.US, this.jsBase + ".milestoneStroke(%s, %s, %s, %s, %s);", stroke != null ? stroke.getJsBase() : null, number, wrapQuotes(str), strokeLineJoin != null ? strokeLineJoin.getJsBase() : null, wrapQuotes(str2)));
        return this;
    }

    @Override // com.anychart.core.ui.Timeline
    public ProjectTimeline milestoneStroke(Stroke stroke, Number number, String str, StrokeLineJoin strokeLineJoin, StrokeLineCap strokeLineCap) {
        APIlib.getInstance().addJSLine(String.format(Locale.US, this.jsBase + ".milestoneStroke(%s, %s, %s, %s, %s);", stroke != null ? stroke.getJsBase() : null, number, wrapQuotes(str), strokeLineJoin != null ? strokeLineJoin.getJsBase() : null, strokeLineCap != null ? strokeLineCap.getJsBase() : null));
        return this;
    }

    @Override // com.anychart.core.ui.Timeline
    public ProjectTimeline milestoneStroke(ColoredFill coloredFill, Number number, String str, String str2, String str3) {
        APIlib.getInstance().addJSLine(String.format(Locale.US, this.jsBase + ".milestoneStroke(%s, %s, %s, %s, %s);", coloredFill != null ? coloredFill.getJsBase() : null, number, wrapQuotes(str), wrapQuotes(str2), wrapQuotes(str3)));
        return this;
    }

    @Override // com.anychart.core.ui.Timeline
    public ProjectTimeline milestoneStroke(ColoredFill coloredFill, Number number, String str, String str2, StrokeLineCap strokeLineCap) {
        APIlib.getInstance().addJSLine(String.format(Locale.US, this.jsBase + ".milestoneStroke(%s, %s, %s, %s, %s);", coloredFill != null ? coloredFill.getJsBase() : null, number, wrapQuotes(str), wrapQuotes(str2), strokeLineCap != null ? strokeLineCap.getJsBase() : null));
        return this;
    }

    @Override // com.anychart.core.ui.Timeline
    public ProjectTimeline milestoneStroke(ColoredFill coloredFill, Number number, String str, StrokeLineJoin strokeLineJoin, String str2) {
        APIlib.getInstance().addJSLine(String.format(Locale.US, this.jsBase + ".milestoneStroke(%s, %s, %s, %s, %s);", coloredFill != null ? coloredFill.getJsBase() : null, number, wrapQuotes(str), strokeLineJoin != null ? strokeLineJoin.getJsBase() : null, wrapQuotes(str2)));
        return this;
    }

    @Override // com.anychart.core.ui.Timeline
    public ProjectTimeline milestoneStroke(ColoredFill coloredFill, Number number, String str, StrokeLineJoin strokeLineJoin, StrokeLineCap strokeLineCap) {
        APIlib.getInstance().addJSLine(String.format(Locale.US, this.jsBase + ".milestoneStroke(%s, %s, %s, %s, %s);", coloredFill != null ? coloredFill.getJsBase() : null, number, wrapQuotes(str), strokeLineJoin != null ? strokeLineJoin.getJsBase() : null, strokeLineCap != null ? strokeLineCap.getJsBase() : null));
        return this;
    }

    @Override // com.anychart.core.ui.Timeline
    public ProjectTimeline milestoneStroke(String str, Number number, String str2, String str3, String str4) {
        APIlib.getInstance().addJSLine(String.format(Locale.US, this.jsBase + ".milestoneStroke(%s, %s, %s, %s, %s);", wrapQuotes(str), number, wrapQuotes(str2), wrapQuotes(str3), wrapQuotes(str4)));
        return this;
    }

    @Override // com.anychart.core.ui.Timeline
    public ProjectTimeline milestoneStroke(String str, Number number, String str2, String str3, StrokeLineCap strokeLineCap) {
        APIlib.getInstance().addJSLine(String.format(Locale.US, this.jsBase + ".milestoneStroke(%s, %s, %s, %s, %s);", wrapQuotes(str), number, wrapQuotes(str2), wrapQuotes(str3), strokeLineCap != null ? strokeLineCap.getJsBase() : null));
        return this;
    }

    @Override // com.anychart.core.ui.Timeline
    public ProjectTimeline milestoneStroke(String str, Number number, String str2, StrokeLineJoin strokeLineJoin, String str3) {
        APIlib.getInstance().addJSLine(String.format(Locale.US, this.jsBase + ".milestoneStroke(%s, %s, %s, %s, %s);", wrapQuotes(str), number, wrapQuotes(str2), strokeLineJoin != null ? strokeLineJoin.getJsBase() : null, wrapQuotes(str3)));
        return this;
    }

    @Override // com.anychart.core.ui.Timeline
    public ProjectTimeline milestoneStroke(String str, Number number, String str2, StrokeLineJoin strokeLineJoin, StrokeLineCap strokeLineCap) {
        APIlib.getInstance().addJSLine(String.format(Locale.US, this.jsBase + ".milestoneStroke(%s, %s, %s, %s, %s);", wrapQuotes(str), number, wrapQuotes(str2), strokeLineJoin != null ? strokeLineJoin.getJsBase() : null, strokeLineCap != null ? strokeLineCap.getJsBase() : null));
        return this;
    }

    @Override // com.anychart.core.ui.Timeline
    public MilestonesElement milestones() {
        return new MilestonesElement(this.jsBase + ".milestones()");
    }

    @Override // com.anychart.core.ui.Timeline
    public ProjectTimeline milestones(String str) {
        APIlib.getInstance().addJSLine(String.format(Locale.US, this.jsBase + ".milestones(%s);", wrapQuotes(str)));
        return this;
    }

    @Override // com.anychart.core.ui.Timeline
    public void minimumGap() {
        APIlib.getInstance().addJSLine(this.jsBase + ".minimumGap();");
    }

    @Override // com.anychart.core.ui.Timeline
    public ProjectTimeline minimumGap(Number number) {
        APIlib.getInstance().addJSLine(String.format(Locale.US, this.jsBase + ".minimumGap(%s);", number));
        return this;
    }

    public RangeColors palette() {
        return new RangeColors(this.jsBase + ".palette()");
    }

    public ProjectTimeline palette(RangeColors rangeColors) {
        APIlib.getInstance().addJSLine(String.format(Locale.US, this.jsBase + ".palette(%s);", rangeColors != null ? rangeColors.getJsBase() : null));
        return this;
    }

    public ProjectTimeline palette(DistinctColors distinctColors) {
        APIlib.getInstance().addJSLine(String.format(Locale.US, this.jsBase + ".palette(%s);", distinctColors != null ? distinctColors.getJsBase() : null));
        return this;
    }

    public ProjectTimeline palette(String str) {
        APIlib.getInstance().addJSLine(String.format(Locale.US, this.jsBase + ".palette(%s);", wrapQuotes(str)));
        return this;
    }

    public ProjectTimeline palette(String[] strArr) {
        APIlib.getInstance().addJSLine(String.format(Locale.US, this.jsBase + ".palette(%s);", arrayToStringWrapQuotes(strArr)));
        return this;
    }

    @Override // com.anychart.core.ui.Timeline
    public void parentBarAnchor() {
        APIlib.getInstance().addJSLine(this.jsBase + ".parentBarAnchor();");
    }

    @Override // com.anychart.core.ui.Timeline
    public ProjectTimeline parentBarAnchor(String str) {
        APIlib.getInstance().addJSLine(String.format(Locale.US, this.jsBase + ".parentBarAnchor(%s);", wrapQuotes(str)));
        return this;
    }

    @Override // com.anychart.core.ui.Timeline
    public ProjectTimeline parentBarAnchor(Anchor anchor) {
        APIlib.getInstance().addJSLine(String.format(Locale.US, this.jsBase + ".parentBarAnchor(%s);", anchor != null ? anchor.getJsBase() : null));
        return this;
    }

    @Override // com.anychart.core.ui.Timeline
    public void parentBarHeight() {
        APIlib.getInstance().addJSLine(this.jsBase + ".parentBarHeight();");
    }

    @Override // com.anychart.core.ui.Timeline
    public ProjectTimeline parentBarHeight(String str) {
        APIlib.getInstance().addJSLine(String.format(Locale.US, this.jsBase + ".parentBarHeight(%s);", wrapQuotes(str)));
        return this;
    }

    @Override // com.anychart.core.ui.Timeline
    public ProjectTimeline parentBarHeight(Number number) {
        APIlib.getInstance().addJSLine(String.format(Locale.US, this.jsBase + ".parentBarHeight(%s);", number));
        return this;
    }

    @Override // com.anychart.core.ui.Timeline
    public void parentBarOffset() {
        APIlib.getInstance().addJSLine(this.jsBase + ".parentBarOffset();");
    }

    @Override // com.anychart.core.ui.Timeline
    public ProjectTimeline parentBarOffset(String str) {
        APIlib.getInstance().addJSLine(String.format(Locale.US, this.jsBase + ".parentBarOffset(%s);", wrapQuotes(str)));
        return this;
    }

    @Override // com.anychart.core.ui.Timeline
    public ProjectTimeline parentBarOffset(Number number) {
        APIlib.getInstance().addJSLine(String.format(Locale.US, this.jsBase + ".parentBarOffset(%s);", number));
        return this;
    }

    @Override // com.anychart.core.ui.Timeline
    public void parentBarPosition() {
        APIlib.getInstance().addJSLine(this.jsBase + ".parentBarPosition();");
    }

    @Override // com.anychart.core.ui.Timeline
    public ProjectTimeline parentBarPosition(String str) {
        APIlib.getInstance().addJSLine(String.format(Locale.US, this.jsBase + ".parentBarPosition(%s);", wrapQuotes(str)));
        return this;
    }

    @Override // com.anychart.core.ui.Timeline
    public ProjectTimeline parentBarPosition(Anchor anchor) {
        APIlib.getInstance().addJSLine(String.format(Locale.US, this.jsBase + ".parentBarPosition(%s);", anchor != null ? anchor.getJsBase() : null));
        return this;
    }

    @Override // com.anychart.core.ui.Timeline
    public void parentFill() {
        APIlib.getInstance().addJSLine(this.jsBase + ".parentFill();");
    }

    @Override // com.anychart.core.ui.Timeline
    public ProjectTimeline parentFill(Fill fill) {
        APIlib.getInstance().addJSLine(String.format(Locale.US, this.jsBase + ".parentFill(%s);", fill != null ? fill.getJsBase() : null));
        return this;
    }

    @Override // com.anychart.core.ui.Timeline
    public ProjectTimeline parentFill(String str, Number number) {
        APIlib.getInstance().addJSLine(String.format(Locale.US, this.jsBase + ".parentFill(%s, %s);", wrapQuotes(str), number));
        return this;
    }

    @Override // com.anychart.core.ui.Timeline
    public ProjectTimeline parentFill(GradientKey gradientKey, Number number, Boolean bool, Number number2) {
        APIlib.getInstance().addJSLine(String.format(Locale.US, this.jsBase + ".parentFill(%s, %s, %s, %s);", gradientKey != null ? gradientKey.getJsBase() : null, number, bool, number2));
        return this;
    }

    @Override // com.anychart.core.ui.Timeline
    public ProjectTimeline parentFill(GradientKey gradientKey, Number number, Rect rect, Number number2) {
        APIlib.getInstance().addJSLine(String.format(Locale.US, this.jsBase + ".parentFill(%s, %s, %s, %s);", gradientKey != null ? gradientKey.getJsBase() : null, number, rect != null ? rect.getJsBase() : null, number2));
        return this;
    }

    @Override // com.anychart.core.ui.Timeline
    public ProjectTimeline parentFill(GradientKey gradientKey, Number number, String str, Number number2) {
        APIlib.getInstance().addJSLine(String.format(Locale.US, this.jsBase + ".parentFill(%s, %s, %s, %s);", gradientKey != null ? gradientKey.getJsBase() : null, number, wrapQuotes(str), number2));
        return this;
    }

    @Override // com.anychart.core.ui.Timeline
    public ProjectTimeline parentFill(String[] strArr, Number number, Boolean bool, Number number2) {
        APIlib.getInstance().addJSLine(String.format(Locale.US, this.jsBase + ".parentFill(%s, %s, %s, %s);", arrayToStringWrapQuotes(strArr), number, bool, number2));
        return this;
    }

    @Override // com.anychart.core.ui.Timeline
    public ProjectTimeline parentFill(String[] strArr, Number number, Rect rect, Number number2) {
        APIlib.getInstance().addJSLine(String.format(Locale.US, this.jsBase + ".parentFill(%s, %s, %s, %s);", arrayToStringWrapQuotes(strArr), number, rect != null ? rect.getJsBase() : null, number2));
        return this;
    }

    @Override // com.anychart.core.ui.Timeline
    public ProjectTimeline parentFill(String[] strArr, Number number, String str, Number number2) {
        APIlib.getInstance().addJSLine(String.format(Locale.US, this.jsBase + ".parentFill(%s, %s, %s, %s);", arrayToStringWrapQuotes(strArr), number, wrapQuotes(str), number2));
        return this;
    }

    @Override // com.anychart.core.ui.Timeline
    public ProjectTimeline parentFill(GradientKey gradientKey, Number number, Number number2, com.anychart.graphics.math.Rect rect, Number number3, Number number4, Number number5) {
        APIlib.getInstance().addJSLine(String.format(Locale.US, this.jsBase + ".parentFill(%s, %s, %s, %s, %s, %s, %s);", gradientKey != null ? gradientKey.getJsBase() : null, number, number2, rect != null ? rect.getJsBase() : null, number3, number4, number5));
        return this;
    }

    @Override // com.anychart.core.ui.Timeline
    public ProjectTimeline parentFill(String[] strArr, Number number, Number number2, com.anychart.graphics.math.Rect rect, Number number3, Number number4, Number number5) {
        APIlib.getInstance().addJSLine(String.format(Locale.US, this.jsBase + ".parentFill(%s, %s, %s, %s, %s, %s, %s);", arrayToStringWrapQuotes(strArr), number, number2, rect != null ? rect.getJsBase() : null, number3, number4, number5));
        return this;
    }

    @Override // com.anychart.core.ui.Timeline
    public void parentStroke() {
        APIlib.getInstance().addJSLine(this.jsBase + ".parentStroke();");
    }

    @Override // com.anychart.core.ui.Timeline
    public ProjectTimeline parentStroke(Stroke stroke, Number number, String str, String str2, String str3) {
        APIlib.getInstance().addJSLine(String.format(Locale.US, this.jsBase + ".parentStroke(%s, %s, %s, %s, %s);", stroke != null ? stroke.getJsBase() : null, number, wrapQuotes(str), wrapQuotes(str2), wrapQuotes(str3)));
        return this;
    }

    @Override // com.anychart.core.ui.Timeline
    public ProjectTimeline parentStroke(Stroke stroke, Number number, String str, String str2, StrokeLineCap strokeLineCap) {
        APIlib.getInstance().addJSLine(String.format(Locale.US, this.jsBase + ".parentStroke(%s, %s, %s, %s, %s);", stroke != null ? stroke.getJsBase() : null, number, wrapQuotes(str), wrapQuotes(str2), strokeLineCap != null ? strokeLineCap.getJsBase() : null));
        return this;
    }

    @Override // com.anychart.core.ui.Timeline
    public ProjectTimeline parentStroke(Stroke stroke, Number number, String str, StrokeLineJoin strokeLineJoin, String str2) {
        APIlib.getInstance().addJSLine(String.format(Locale.US, this.jsBase + ".parentStroke(%s, %s, %s, %s, %s);", stroke != null ? stroke.getJsBase() : null, number, wrapQuotes(str), strokeLineJoin != null ? strokeLineJoin.getJsBase() : null, wrapQuotes(str2)));
        return this;
    }

    @Override // com.anychart.core.ui.Timeline
    public ProjectTimeline parentStroke(Stroke stroke, Number number, String str, StrokeLineJoin strokeLineJoin, StrokeLineCap strokeLineCap) {
        APIlib.getInstance().addJSLine(String.format(Locale.US, this.jsBase + ".parentStroke(%s, %s, %s, %s, %s);", stroke != null ? stroke.getJsBase() : null, number, wrapQuotes(str), strokeLineJoin != null ? strokeLineJoin.getJsBase() : null, strokeLineCap != null ? strokeLineCap.getJsBase() : null));
        return this;
    }

    @Override // com.anychart.core.ui.Timeline
    public ProjectTimeline parentStroke(ColoredFill coloredFill, Number number, String str, String str2, String str3) {
        APIlib.getInstance().addJSLine(String.format(Locale.US, this.jsBase + ".parentStroke(%s, %s, %s, %s, %s);", coloredFill != null ? coloredFill.getJsBase() : null, number, wrapQuotes(str), wrapQuotes(str2), wrapQuotes(str3)));
        return this;
    }

    @Override // com.anychart.core.ui.Timeline
    public ProjectTimeline parentStroke(ColoredFill coloredFill, Number number, String str, String str2, StrokeLineCap strokeLineCap) {
        APIlib.getInstance().addJSLine(String.format(Locale.US, this.jsBase + ".parentStroke(%s, %s, %s, %s, %s);", coloredFill != null ? coloredFill.getJsBase() : null, number, wrapQuotes(str), wrapQuotes(str2), strokeLineCap != null ? strokeLineCap.getJsBase() : null));
        return this;
    }

    @Override // com.anychart.core.ui.Timeline
    public ProjectTimeline parentStroke(ColoredFill coloredFill, Number number, String str, StrokeLineJoin strokeLineJoin, String str2) {
        APIlib.getInstance().addJSLine(String.format(Locale.US, this.jsBase + ".parentStroke(%s, %s, %s, %s, %s);", coloredFill != null ? coloredFill.getJsBase() : null, number, wrapQuotes(str), strokeLineJoin != null ? strokeLineJoin.getJsBase() : null, wrapQuotes(str2)));
        return this;
    }

    @Override // com.anychart.core.ui.Timeline
    public ProjectTimeline parentStroke(ColoredFill coloredFill, Number number, String str, StrokeLineJoin strokeLineJoin, StrokeLineCap strokeLineCap) {
        APIlib.getInstance().addJSLine(String.format(Locale.US, this.jsBase + ".parentStroke(%s, %s, %s, %s, %s);", coloredFill != null ? coloredFill.getJsBase() : null, number, wrapQuotes(str), strokeLineJoin != null ? strokeLineJoin.getJsBase() : null, strokeLineCap != null ? strokeLineCap.getJsBase() : null));
        return this;
    }

    @Override // com.anychart.core.ui.Timeline
    public ProjectTimeline parentStroke(String str, Number number, String str2, String str3, String str4) {
        APIlib.getInstance().addJSLine(String.format(Locale.US, this.jsBase + ".parentStroke(%s, %s, %s, %s, %s);", wrapQuotes(str), number, wrapQuotes(str2), wrapQuotes(str3), wrapQuotes(str4)));
        return this;
    }

    @Override // com.anychart.core.ui.Timeline
    public ProjectTimeline parentStroke(String str, Number number, String str2, String str3, StrokeLineCap strokeLineCap) {
        APIlib.getInstance().addJSLine(String.format(Locale.US, this.jsBase + ".parentStroke(%s, %s, %s, %s, %s);", wrapQuotes(str), number, wrapQuotes(str2), wrapQuotes(str3), strokeLineCap != null ? strokeLineCap.getJsBase() : null));
        return this;
    }

    @Override // com.anychart.core.ui.Timeline
    public ProjectTimeline parentStroke(String str, Number number, String str2, StrokeLineJoin strokeLineJoin, String str3) {
        APIlib.getInstance().addJSLine(String.format(Locale.US, this.jsBase + ".parentStroke(%s, %s, %s, %s, %s);", wrapQuotes(str), number, wrapQuotes(str2), strokeLineJoin != null ? strokeLineJoin.getJsBase() : null, wrapQuotes(str3)));
        return this;
    }

    @Override // com.anychart.core.ui.Timeline
    public ProjectTimeline parentStroke(String str, Number number, String str2, StrokeLineJoin strokeLineJoin, StrokeLineCap strokeLineCap) {
        APIlib.getInstance().addJSLine(String.format(Locale.US, this.jsBase + ".parentStroke(%s, %s, %s, %s, %s);", wrapQuotes(str), number, wrapQuotes(str2), strokeLineJoin != null ? strokeLineJoin.getJsBase() : null, strokeLineCap != null ? strokeLineCap.getJsBase() : null));
        return this;
    }

    @Override // com.anychart.core.ui.Timeline
    public void progressBarAnchor() {
        APIlib.getInstance().addJSLine(this.jsBase + ".progressBarAnchor();");
    }

    @Override // com.anychart.core.ui.Timeline
    public ProjectTimeline progressBarAnchor(String str) {
        APIlib.getInstance().addJSLine(String.format(Locale.US, this.jsBase + ".progressBarAnchor(%s);", wrapQuotes(str)));
        return this;
    }

    @Override // com.anychart.core.ui.Timeline
    public ProjectTimeline progressBarAnchor(Anchor anchor) {
        APIlib.getInstance().addJSLine(String.format(Locale.US, this.jsBase + ".progressBarAnchor(%s);", anchor != null ? anchor.getJsBase() : null));
        return this;
    }

    @Override // com.anychart.core.ui.Timeline
    public void progressBarHeight() {
        APIlib.getInstance().addJSLine(this.jsBase + ".progressBarHeight();");
    }

    @Override // com.anychart.core.ui.Timeline
    public ProjectTimeline progressBarHeight(String str) {
        APIlib.getInstance().addJSLine(String.format(Locale.US, this.jsBase + ".progressBarHeight(%s);", wrapQuotes(str)));
        return this;
    }

    @Override // com.anychart.core.ui.Timeline
    public ProjectTimeline progressBarHeight(Number number) {
        APIlib.getInstance().addJSLine(String.format(Locale.US, this.jsBase + ".progressBarHeight(%s);", number));
        return this;
    }

    @Override // com.anychart.core.ui.Timeline
    public void progressBarOffset() {
        APIlib.getInstance().addJSLine(this.jsBase + ".progressBarOffset();");
    }

    @Override // com.anychart.core.ui.Timeline
    public ProjectTimeline progressBarOffset(String str) {
        APIlib.getInstance().addJSLine(String.format(Locale.US, this.jsBase + ".progressBarOffset(%s);", wrapQuotes(str)));
        return this;
    }

    @Override // com.anychart.core.ui.Timeline
    public ProjectTimeline progressBarOffset(Number number) {
        APIlib.getInstance().addJSLine(String.format(Locale.US, this.jsBase + ".progressBarOffset(%s);", number));
        return this;
    }

    @Override // com.anychart.core.ui.Timeline
    public void progressBarPosition() {
        APIlib.getInstance().addJSLine(this.jsBase + ".progressBarPosition();");
    }

    @Override // com.anychart.core.ui.Timeline
    public ProjectTimeline progressBarPosition(String str) {
        APIlib.getInstance().addJSLine(String.format(Locale.US, this.jsBase + ".progressBarPosition(%s);", wrapQuotes(str)));
        return this;
    }

    @Override // com.anychart.core.ui.Timeline
    public ProjectTimeline progressBarPosition(Anchor anchor) {
        APIlib.getInstance().addJSLine(String.format(Locale.US, this.jsBase + ".progressBarPosition(%s);", anchor != null ? anchor.getJsBase() : null));
        return this;
    }

    @Override // com.anychart.core.ui.Timeline
    public void progressFill() {
        APIlib.getInstance().addJSLine(this.jsBase + ".progressFill();");
    }

    @Override // com.anychart.core.ui.Timeline
    public ProjectTimeline progressFill(Fill fill) {
        APIlib.getInstance().addJSLine(String.format(Locale.US, this.jsBase + ".progressFill(%s);", fill != null ? fill.getJsBase() : null));
        return this;
    }

    @Override // com.anychart.core.ui.Timeline
    public ProjectTimeline progressFill(String str, Number number) {
        APIlib.getInstance().addJSLine(String.format(Locale.US, this.jsBase + ".progressFill(%s, %s);", wrapQuotes(str), number));
        return this;
    }

    @Override // com.anychart.core.ui.Timeline
    public ProjectTimeline progressFill(GradientKey gradientKey, Number number, Boolean bool, Number number2) {
        APIlib.getInstance().addJSLine(String.format(Locale.US, this.jsBase + ".progressFill(%s, %s, %s, %s);", gradientKey != null ? gradientKey.getJsBase() : null, number, bool, number2));
        return this;
    }

    @Override // com.anychart.core.ui.Timeline
    public ProjectTimeline progressFill(GradientKey gradientKey, Number number, Rect rect, Number number2) {
        APIlib.getInstance().addJSLine(String.format(Locale.US, this.jsBase + ".progressFill(%s, %s, %s, %s);", gradientKey != null ? gradientKey.getJsBase() : null, number, rect != null ? rect.getJsBase() : null, number2));
        return this;
    }

    @Override // com.anychart.core.ui.Timeline
    public ProjectTimeline progressFill(GradientKey gradientKey, Number number, String str, Number number2) {
        APIlib.getInstance().addJSLine(String.format(Locale.US, this.jsBase + ".progressFill(%s, %s, %s, %s);", gradientKey != null ? gradientKey.getJsBase() : null, number, wrapQuotes(str), number2));
        return this;
    }

    @Override // com.anychart.core.ui.Timeline
    public ProjectTimeline progressFill(String[] strArr, Number number, Boolean bool, Number number2) {
        APIlib.getInstance().addJSLine(String.format(Locale.US, this.jsBase + ".progressFill(%s, %s, %s, %s);", arrayToStringWrapQuotes(strArr), number, bool, number2));
        return this;
    }

    @Override // com.anychart.core.ui.Timeline
    public ProjectTimeline progressFill(String[] strArr, Number number, Rect rect, Number number2) {
        APIlib.getInstance().addJSLine(String.format(Locale.US, this.jsBase + ".progressFill(%s, %s, %s, %s);", arrayToStringWrapQuotes(strArr), number, rect != null ? rect.getJsBase() : null, number2));
        return this;
    }

    @Override // com.anychart.core.ui.Timeline
    public ProjectTimeline progressFill(String[] strArr, Number number, String str, Number number2) {
        APIlib.getInstance().addJSLine(String.format(Locale.US, this.jsBase + ".progressFill(%s, %s, %s, %s);", arrayToStringWrapQuotes(strArr), number, wrapQuotes(str), number2));
        return this;
    }

    @Override // com.anychart.core.ui.Timeline
    public ProjectTimeline progressFill(GradientKey gradientKey, Number number, Number number2, com.anychart.graphics.math.Rect rect, Number number3, Number number4, Number number5) {
        APIlib.getInstance().addJSLine(String.format(Locale.US, this.jsBase + ".progressFill(%s, %s, %s, %s, %s, %s, %s);", gradientKey != null ? gradientKey.getJsBase() : null, number, number2, rect != null ? rect.getJsBase() : null, number3, number4, number5));
        return this;
    }

    @Override // com.anychart.core.ui.Timeline
    public ProjectTimeline progressFill(String[] strArr, Number number, Number number2, com.anychart.graphics.math.Rect rect, Number number3, Number number4, Number number5) {
        APIlib.getInstance().addJSLine(String.format(Locale.US, this.jsBase + ".progressFill(%s, %s, %s, %s, %s, %s, %s);", arrayToStringWrapQuotes(strArr), number, number2, rect != null ? rect.getJsBase() : null, number3, number4, number5));
        return this;
    }

    @Override // com.anychart.core.ui.Timeline
    public void progressStroke() {
        APIlib.getInstance().addJSLine(this.jsBase + ".progressStroke();");
    }

    @Override // com.anychart.core.ui.Timeline
    public ProjectTimeline progressStroke(Stroke stroke, Number number, String str, String str2, String str3) {
        APIlib.getInstance().addJSLine(String.format(Locale.US, this.jsBase + ".progressStroke(%s, %s, %s, %s, %s);", stroke != null ? stroke.getJsBase() : null, number, wrapQuotes(str), wrapQuotes(str2), wrapQuotes(str3)));
        return this;
    }

    @Override // com.anychart.core.ui.Timeline
    public ProjectTimeline progressStroke(Stroke stroke, Number number, String str, String str2, StrokeLineCap strokeLineCap) {
        APIlib.getInstance().addJSLine(String.format(Locale.US, this.jsBase + ".progressStroke(%s, %s, %s, %s, %s);", stroke != null ? stroke.getJsBase() : null, number, wrapQuotes(str), wrapQuotes(str2), strokeLineCap != null ? strokeLineCap.getJsBase() : null));
        return this;
    }

    @Override // com.anychart.core.ui.Timeline
    public ProjectTimeline progressStroke(Stroke stroke, Number number, String str, StrokeLineJoin strokeLineJoin, String str2) {
        APIlib.getInstance().addJSLine(String.format(Locale.US, this.jsBase + ".progressStroke(%s, %s, %s, %s, %s);", stroke != null ? stroke.getJsBase() : null, number, wrapQuotes(str), strokeLineJoin != null ? strokeLineJoin.getJsBase() : null, wrapQuotes(str2)));
        return this;
    }

    @Override // com.anychart.core.ui.Timeline
    public ProjectTimeline progressStroke(Stroke stroke, Number number, String str, StrokeLineJoin strokeLineJoin, StrokeLineCap strokeLineCap) {
        APIlib.getInstance().addJSLine(String.format(Locale.US, this.jsBase + ".progressStroke(%s, %s, %s, %s, %s);", stroke != null ? stroke.getJsBase() : null, number, wrapQuotes(str), strokeLineJoin != null ? strokeLineJoin.getJsBase() : null, strokeLineCap != null ? strokeLineCap.getJsBase() : null));
        return this;
    }

    @Override // com.anychart.core.ui.Timeline
    public ProjectTimeline progressStroke(ColoredFill coloredFill, Number number, String str, String str2, String str3) {
        APIlib.getInstance().addJSLine(String.format(Locale.US, this.jsBase + ".progressStroke(%s, %s, %s, %s, %s);", coloredFill != null ? coloredFill.getJsBase() : null, number, wrapQuotes(str), wrapQuotes(str2), wrapQuotes(str3)));
        return this;
    }

    @Override // com.anychart.core.ui.Timeline
    public ProjectTimeline progressStroke(ColoredFill coloredFill, Number number, String str, String str2, StrokeLineCap strokeLineCap) {
        APIlib.getInstance().addJSLine(String.format(Locale.US, this.jsBase + ".progressStroke(%s, %s, %s, %s, %s);", coloredFill != null ? coloredFill.getJsBase() : null, number, wrapQuotes(str), wrapQuotes(str2), strokeLineCap != null ? strokeLineCap.getJsBase() : null));
        return this;
    }

    @Override // com.anychart.core.ui.Timeline
    public ProjectTimeline progressStroke(ColoredFill coloredFill, Number number, String str, StrokeLineJoin strokeLineJoin, String str2) {
        APIlib.getInstance().addJSLine(String.format(Locale.US, this.jsBase + ".progressStroke(%s, %s, %s, %s, %s);", coloredFill != null ? coloredFill.getJsBase() : null, number, wrapQuotes(str), strokeLineJoin != null ? strokeLineJoin.getJsBase() : null, wrapQuotes(str2)));
        return this;
    }

    @Override // com.anychart.core.ui.Timeline
    public ProjectTimeline progressStroke(ColoredFill coloredFill, Number number, String str, StrokeLineJoin strokeLineJoin, StrokeLineCap strokeLineCap) {
        APIlib.getInstance().addJSLine(String.format(Locale.US, this.jsBase + ".progressStroke(%s, %s, %s, %s, %s);", coloredFill != null ? coloredFill.getJsBase() : null, number, wrapQuotes(str), strokeLineJoin != null ? strokeLineJoin.getJsBase() : null, strokeLineCap != null ? strokeLineCap.getJsBase() : null));
        return this;
    }

    @Override // com.anychart.core.ui.Timeline
    public ProjectTimeline progressStroke(String str, Number number, String str2, String str3, String str4) {
        APIlib.getInstance().addJSLine(String.format(Locale.US, this.jsBase + ".progressStroke(%s, %s, %s, %s, %s);", wrapQuotes(str), number, wrapQuotes(str2), wrapQuotes(str3), wrapQuotes(str4)));
        return this;
    }

    @Override // com.anychart.core.ui.Timeline
    public ProjectTimeline progressStroke(String str, Number number, String str2, String str3, StrokeLineCap strokeLineCap) {
        APIlib.getInstance().addJSLine(String.format(Locale.US, this.jsBase + ".progressStroke(%s, %s, %s, %s, %s);", wrapQuotes(str), number, wrapQuotes(str2), wrapQuotes(str3), strokeLineCap != null ? strokeLineCap.getJsBase() : null));
        return this;
    }

    @Override // com.anychart.core.ui.Timeline
    public ProjectTimeline progressStroke(String str, Number number, String str2, StrokeLineJoin strokeLineJoin, String str3) {
        APIlib.getInstance().addJSLine(String.format(Locale.US, this.jsBase + ".progressStroke(%s, %s, %s, %s, %s);", wrapQuotes(str), number, wrapQuotes(str2), strokeLineJoin != null ? strokeLineJoin.getJsBase() : null, wrapQuotes(str3)));
        return this;
    }

    @Override // com.anychart.core.ui.Timeline
    public ProjectTimeline progressStroke(String str, Number number, String str2, StrokeLineJoin strokeLineJoin, StrokeLineCap strokeLineCap) {
        APIlib.getInstance().addJSLine(String.format(Locale.US, this.jsBase + ".progressStroke(%s, %s, %s, %s, %s);", wrapQuotes(str), number, wrapQuotes(str2), strokeLineJoin != null ? strokeLineJoin.getJsBase() : null, strokeLineCap != null ? strokeLineCap.getJsBase() : null));
        return this;
    }

    @Override // com.anychart.core.ui.Timeline
    public GanttRange rangeMarker(Number number) {
        return new GanttRange(String.format(Locale.US, this.jsBase + ".rangeMarker(%s)", number));
    }

    @Override // com.anychart.core.ui.Timeline
    public ProjectTimeline rangeMarker(String str) {
        APIlib.getInstance().addJSLine(String.format(Locale.US, this.jsBase + ".rangeMarker(%s);", wrapQuotes(str)));
        return this;
    }

    @Override // com.anychart.core.ui.Timeline
    public ProjectTimeline rangeMarker(Boolean bool) {
        APIlib.getInstance().addJSLine(String.format(Locale.US, this.jsBase + ".rangeMarker(%s);", bool));
        return this;
    }

    @Override // com.anychart.core.ui.Timeline
    public ProjectTimeline rangeMarker(Number number, String str) {
        APIlib.getInstance().addJSLine(String.format(Locale.US, this.jsBase + ".rangeMarker(%s, %s);", number, wrapQuotes(str)));
        return this;
    }

    @Override // com.anychart.core.ui.Timeline
    public ProjectTimeline rangeMarker(Number number, Boolean bool) {
        APIlib.getInstance().addJSLine(String.format(Locale.US, this.jsBase + ".rangeMarker(%s, %s);", number, bool));
        return this;
    }

    @Override // com.anychart.core.ui.Timeline
    public ProjectTimeline rangeMarker(Number number, GanttDateTimeMarkers ganttDateTimeMarkers) {
        APIlib.getInstance().addJSLine(String.format(Locale.US, this.jsBase + ".rangeMarker(%s, %s);", number, ganttDateTimeMarkers != null ? ganttDateTimeMarkers.getJsBase() : null));
        return this;
    }

    @Override // com.anychart.core.ui.Timeline
    public void rowEvenFill() {
        APIlib.getInstance().addJSLine(this.jsBase + ".rowEvenFill();");
    }

    @Override // com.anychart.core.ui.Timeline
    public ProjectTimeline rowEvenFill(Fill fill) {
        APIlib.getInstance().addJSLine(String.format(Locale.US, this.jsBase + ".rowEvenFill(%s);", fill != null ? fill.getJsBase() : null));
        return this;
    }

    @Override // com.anychart.core.ui.Timeline
    public ProjectTimeline rowEvenFill(GradientKey gradientKey) {
        APIlib.getInstance().addJSLine(String.format(Locale.US, this.jsBase + ".rowEvenFill(%s);", gradientKey != null ? gradientKey.getJsBase() : null));
        return this;
    }

    @Override // com.anychart.core.ui.Timeline
    public ProjectTimeline rowEvenFill(String[] strArr) {
        APIlib.getInstance().addJSLine(String.format(Locale.US, this.jsBase + ".rowEvenFill(%s);", arrayToStringWrapQuotes(strArr)));
        return this;
    }

    @Override // com.anychart.core.ui.Timeline
    public ProjectTimeline rowEvenFill(String str, Number number) {
        APIlib.getInstance().addJSLine(String.format(Locale.US, this.jsBase + ".rowEvenFill(%s, %s);", wrapQuotes(str), number));
        return this;
    }

    @Override // com.anychart.core.ui.Timeline
    public ProjectTimeline rowEvenFill(GradientKey gradientKey, Number number, Boolean bool, Number number2) {
        APIlib.getInstance().addJSLine(String.format(Locale.US, this.jsBase + ".rowEvenFill(%s, %s, %s, %s);", gradientKey != null ? gradientKey.getJsBase() : null, number, bool, number2));
        return this;
    }

    @Override // com.anychart.core.ui.Timeline
    public ProjectTimeline rowEvenFill(GradientKey gradientKey, Number number, Rect rect, Number number2) {
        APIlib.getInstance().addJSLine(String.format(Locale.US, this.jsBase + ".rowEvenFill(%s, %s, %s, %s);", gradientKey != null ? gradientKey.getJsBase() : null, number, rect != null ? rect.getJsBase() : null, number2));
        return this;
    }

    @Override // com.anychart.core.ui.Timeline
    public ProjectTimeline rowEvenFill(GradientKey gradientKey, Number number, String str, Number number2) {
        APIlib.getInstance().addJSLine(String.format(Locale.US, this.jsBase + ".rowEvenFill(%s, %s, %s, %s);", gradientKey != null ? gradientKey.getJsBase() : null, number, wrapQuotes(str), number2));
        return this;
    }

    @Override // com.anychart.core.ui.Timeline
    public ProjectTimeline rowEvenFill(String[] strArr, Number number, Boolean bool, Number number2) {
        APIlib.getInstance().addJSLine(String.format(Locale.US, this.jsBase + ".rowEvenFill(%s, %s, %s, %s);", arrayToStringWrapQuotes(strArr), number, bool, number2));
        return this;
    }

    @Override // com.anychart.core.ui.Timeline
    public ProjectTimeline rowEvenFill(String[] strArr, Number number, Rect rect, Number number2) {
        APIlib.getInstance().addJSLine(String.format(Locale.US, this.jsBase + ".rowEvenFill(%s, %s, %s, %s);", arrayToStringWrapQuotes(strArr), number, rect != null ? rect.getJsBase() : null, number2));
        return this;
    }

    @Override // com.anychart.core.ui.Timeline
    public ProjectTimeline rowEvenFill(String[] strArr, Number number, String str, Number number2) {
        APIlib.getInstance().addJSLine(String.format(Locale.US, this.jsBase + ".rowEvenFill(%s, %s, %s, %s);", arrayToStringWrapQuotes(strArr), number, wrapQuotes(str), number2));
        return this;
    }

    @Override // com.anychart.core.ui.Timeline
    public ProjectTimeline rowEvenFill(GradientKey gradientKey, Number number, Number number2, com.anychart.graphics.math.Rect rect, Number number3, Number number4, Number number5) {
        APIlib.getInstance().addJSLine(String.format(Locale.US, this.jsBase + ".rowEvenFill(%s, %s, %s, %s, %s, %s, %s);", gradientKey != null ? gradientKey.getJsBase() : null, number, number2, rect != null ? rect.getJsBase() : null, number3, number4, number5));
        return this;
    }

    @Override // com.anychart.core.ui.Timeline
    public ProjectTimeline rowEvenFill(String[] strArr, Number number, Number number2, com.anychart.graphics.math.Rect rect, Number number3, Number number4, Number number5) {
        APIlib.getInstance().addJSLine(String.format(Locale.US, this.jsBase + ".rowEvenFill(%s, %s, %s, %s, %s, %s, %s);", arrayToStringWrapQuotes(strArr), number, number2, rect != null ? rect.getJsBase() : null, number3, number4, number5));
        return this;
    }

    @Override // com.anychart.core.ui.Timeline
    public void rowFill() {
        APIlib.getInstance().addJSLine(this.jsBase + ".rowFill();");
    }

    @Override // com.anychart.core.ui.Timeline
    public ProjectTimeline rowFill(Fill fill) {
        APIlib.getInstance().addJSLine(String.format(Locale.US, this.jsBase + ".rowFill(%s);", fill != null ? fill.getJsBase() : null));
        return this;
    }

    @Override // com.anychart.core.ui.Timeline
    public ProjectTimeline rowFill(GradientKey gradientKey) {
        APIlib.getInstance().addJSLine(String.format(Locale.US, this.jsBase + ".rowFill(%s);", gradientKey != null ? gradientKey.getJsBase() : null));
        return this;
    }

    @Override // com.anychart.core.ui.Timeline
    public ProjectTimeline rowFill(String[] strArr) {
        APIlib.getInstance().addJSLine(String.format(Locale.US, this.jsBase + ".rowFill(%s);", arrayToStringWrapQuotes(strArr)));
        return this;
    }

    @Override // com.anychart.core.ui.Timeline
    public ProjectTimeline rowFill(String str, Number number) {
        APIlib.getInstance().addJSLine(String.format(Locale.US, this.jsBase + ".rowFill(%s, %s);", wrapQuotes(str), number));
        return this;
    }

    @Override // com.anychart.core.ui.Timeline
    public ProjectTimeline rowFill(GradientKey gradientKey, Number number, Boolean bool, Number number2) {
        APIlib.getInstance().addJSLine(String.format(Locale.US, this.jsBase + ".rowFill(%s, %s, %s, %s);", gradientKey != null ? gradientKey.getJsBase() : null, number, bool, number2));
        return this;
    }

    @Override // com.anychart.core.ui.Timeline
    public ProjectTimeline rowFill(GradientKey gradientKey, Number number, Rect rect, Number number2) {
        APIlib.getInstance().addJSLine(String.format(Locale.US, this.jsBase + ".rowFill(%s, %s, %s, %s);", gradientKey != null ? gradientKey.getJsBase() : null, number, rect != null ? rect.getJsBase() : null, number2));
        return this;
    }

    @Override // com.anychart.core.ui.Timeline
    public ProjectTimeline rowFill(GradientKey gradientKey, Number number, String str, Number number2) {
        APIlib.getInstance().addJSLine(String.format(Locale.US, this.jsBase + ".rowFill(%s, %s, %s, %s);", gradientKey != null ? gradientKey.getJsBase() : null, number, wrapQuotes(str), number2));
        return this;
    }

    @Override // com.anychart.core.ui.Timeline
    public ProjectTimeline rowFill(String[] strArr, Number number, Boolean bool, Number number2) {
        APIlib.getInstance().addJSLine(String.format(Locale.US, this.jsBase + ".rowFill(%s, %s, %s, %s);", arrayToStringWrapQuotes(strArr), number, bool, number2));
        return this;
    }

    @Override // com.anychart.core.ui.Timeline
    public ProjectTimeline rowFill(String[] strArr, Number number, Rect rect, Number number2) {
        APIlib.getInstance().addJSLine(String.format(Locale.US, this.jsBase + ".rowFill(%s, %s, %s, %s);", arrayToStringWrapQuotes(strArr), number, rect != null ? rect.getJsBase() : null, number2));
        return this;
    }

    @Override // com.anychart.core.ui.Timeline
    public ProjectTimeline rowFill(String[] strArr, Number number, String str, Number number2) {
        APIlib.getInstance().addJSLine(String.format(Locale.US, this.jsBase + ".rowFill(%s, %s, %s, %s);", arrayToStringWrapQuotes(strArr), number, wrapQuotes(str), number2));
        return this;
    }

    @Override // com.anychart.core.ui.Timeline
    public ProjectTimeline rowFill(GradientKey gradientKey, Number number, Number number2, com.anychart.graphics.math.Rect rect, Number number3, Number number4, Number number5) {
        APIlib.getInstance().addJSLine(String.format(Locale.US, this.jsBase + ".rowFill(%s, %s, %s, %s, %s, %s, %s);", gradientKey != null ? gradientKey.getJsBase() : null, number, number2, rect != null ? rect.getJsBase() : null, number3, number4, number5));
        return this;
    }

    @Override // com.anychart.core.ui.Timeline
    public ProjectTimeline rowFill(String[] strArr, Number number, Number number2, com.anychart.graphics.math.Rect rect, Number number3, Number number4, Number number5) {
        APIlib.getInstance().addJSLine(String.format(Locale.US, this.jsBase + ".rowFill(%s, %s, %s, %s, %s, %s, %s);", arrayToStringWrapQuotes(strArr), number, number2, rect != null ? rect.getJsBase() : null, number3, number4, number5));
        return this;
    }

    @Override // com.anychart.core.ui.Timeline
    public void rowHoverFill() {
        APIlib.getInstance().addJSLine(this.jsBase + ".rowHoverFill();");
    }

    @Override // com.anychart.core.ui.Timeline
    public ProjectTimeline rowHoverFill(Fill fill) {
        APIlib.getInstance().addJSLine(String.format(Locale.US, this.jsBase + ".rowHoverFill(%s);", fill != null ? fill.getJsBase() : null));
        return this;
    }

    @Override // com.anychart.core.ui.Timeline
    public ProjectTimeline rowHoverFill(GradientKey gradientKey) {
        APIlib.getInstance().addJSLine(String.format(Locale.US, this.jsBase + ".rowHoverFill(%s);", gradientKey != null ? gradientKey.getJsBase() : null));
        return this;
    }

    @Override // com.anychart.core.ui.Timeline
    public ProjectTimeline rowHoverFill(String[] strArr) {
        APIlib.getInstance().addJSLine(String.format(Locale.US, this.jsBase + ".rowHoverFill(%s);", arrayToStringWrapQuotes(strArr)));
        return this;
    }

    @Override // com.anychart.core.ui.Timeline
    public ProjectTimeline rowHoverFill(String str, Number number) {
        APIlib.getInstance().addJSLine(String.format(Locale.US, this.jsBase + ".rowHoverFill(%s, %s);", wrapQuotes(str), number));
        return this;
    }

    @Override // com.anychart.core.ui.Timeline
    public ProjectTimeline rowHoverFill(GradientKey gradientKey, Number number, Boolean bool, Number number2) {
        APIlib.getInstance().addJSLine(String.format(Locale.US, this.jsBase + ".rowHoverFill(%s, %s, %s, %s);", gradientKey != null ? gradientKey.getJsBase() : null, number, bool, number2));
        return this;
    }

    @Override // com.anychart.core.ui.Timeline
    public ProjectTimeline rowHoverFill(GradientKey gradientKey, Number number, Rect rect, Number number2) {
        APIlib.getInstance().addJSLine(String.format(Locale.US, this.jsBase + ".rowHoverFill(%s, %s, %s, %s);", gradientKey != null ? gradientKey.getJsBase() : null, number, rect != null ? rect.getJsBase() : null, number2));
        return this;
    }

    @Override // com.anychart.core.ui.Timeline
    public ProjectTimeline rowHoverFill(GradientKey gradientKey, Number number, String str, Number number2) {
        APIlib.getInstance().addJSLine(String.format(Locale.US, this.jsBase + ".rowHoverFill(%s, %s, %s, %s);", gradientKey != null ? gradientKey.getJsBase() : null, number, wrapQuotes(str), number2));
        return this;
    }

    @Override // com.anychart.core.ui.Timeline
    public ProjectTimeline rowHoverFill(String[] strArr, Number number, Boolean bool, Number number2) {
        APIlib.getInstance().addJSLine(String.format(Locale.US, this.jsBase + ".rowHoverFill(%s, %s, %s, %s);", arrayToStringWrapQuotes(strArr), number, bool, number2));
        return this;
    }

    @Override // com.anychart.core.ui.Timeline
    public ProjectTimeline rowHoverFill(String[] strArr, Number number, Rect rect, Number number2) {
        APIlib.getInstance().addJSLine(String.format(Locale.US, this.jsBase + ".rowHoverFill(%s, %s, %s, %s);", arrayToStringWrapQuotes(strArr), number, rect != null ? rect.getJsBase() : null, number2));
        return this;
    }

    @Override // com.anychart.core.ui.Timeline
    public ProjectTimeline rowHoverFill(String[] strArr, Number number, String str, Number number2) {
        APIlib.getInstance().addJSLine(String.format(Locale.US, this.jsBase + ".rowHoverFill(%s, %s, %s, %s);", arrayToStringWrapQuotes(strArr), number, wrapQuotes(str), number2));
        return this;
    }

    @Override // com.anychart.core.ui.Timeline
    public ProjectTimeline rowHoverFill(GradientKey gradientKey, Number number, Number number2, com.anychart.graphics.math.Rect rect, Number number3, Number number4, Number number5) {
        APIlib.getInstance().addJSLine(String.format(Locale.US, this.jsBase + ".rowHoverFill(%s, %s, %s, %s, %s, %s, %s);", gradientKey != null ? gradientKey.getJsBase() : null, number, number2, rect != null ? rect.getJsBase() : null, number3, number4, number5));
        return this;
    }

    @Override // com.anychart.core.ui.Timeline
    public ProjectTimeline rowHoverFill(String[] strArr, Number number, Number number2, com.anychart.graphics.math.Rect rect, Number number3, Number number4, Number number5) {
        APIlib.getInstance().addJSLine(String.format(Locale.US, this.jsBase + ".rowHoverFill(%s, %s, %s, %s, %s, %s, %s);", arrayToStringWrapQuotes(strArr), number, number2, rect != null ? rect.getJsBase() : null, number3, number4, number5));
        return this;
    }

    @Override // com.anychart.core.ui.Timeline
    public void rowOddFill() {
        APIlib.getInstance().addJSLine(this.jsBase + ".rowOddFill();");
    }

    @Override // com.anychart.core.ui.Timeline
    public ProjectTimeline rowOddFill(Fill fill) {
        APIlib.getInstance().addJSLine(String.format(Locale.US, this.jsBase + ".rowOddFill(%s);", fill != null ? fill.getJsBase() : null));
        return this;
    }

    @Override // com.anychart.core.ui.Timeline
    public ProjectTimeline rowOddFill(GradientKey gradientKey) {
        APIlib.getInstance().addJSLine(String.format(Locale.US, this.jsBase + ".rowOddFill(%s);", gradientKey != null ? gradientKey.getJsBase() : null));
        return this;
    }

    @Override // com.anychart.core.ui.Timeline
    public ProjectTimeline rowOddFill(String[] strArr) {
        APIlib.getInstance().addJSLine(String.format(Locale.US, this.jsBase + ".rowOddFill(%s);", arrayToStringWrapQuotes(strArr)));
        return this;
    }

    @Override // com.anychart.core.ui.Timeline
    public ProjectTimeline rowOddFill(String str, Number number) {
        APIlib.getInstance().addJSLine(String.format(Locale.US, this.jsBase + ".rowOddFill(%s, %s);", wrapQuotes(str), number));
        return this;
    }

    @Override // com.anychart.core.ui.Timeline
    public ProjectTimeline rowOddFill(GradientKey gradientKey, Number number, Boolean bool, Number number2) {
        APIlib.getInstance().addJSLine(String.format(Locale.US, this.jsBase + ".rowOddFill(%s, %s, %s, %s);", gradientKey != null ? gradientKey.getJsBase() : null, number, bool, number2));
        return this;
    }

    @Override // com.anychart.core.ui.Timeline
    public ProjectTimeline rowOddFill(GradientKey gradientKey, Number number, Rect rect, Number number2) {
        APIlib.getInstance().addJSLine(String.format(Locale.US, this.jsBase + ".rowOddFill(%s, %s, %s, %s);", gradientKey != null ? gradientKey.getJsBase() : null, number, rect != null ? rect.getJsBase() : null, number2));
        return this;
    }

    @Override // com.anychart.core.ui.Timeline
    public ProjectTimeline rowOddFill(GradientKey gradientKey, Number number, String str, Number number2) {
        APIlib.getInstance().addJSLine(String.format(Locale.US, this.jsBase + ".rowOddFill(%s, %s, %s, %s);", gradientKey != null ? gradientKey.getJsBase() : null, number, wrapQuotes(str), number2));
        return this;
    }

    @Override // com.anychart.core.ui.Timeline
    public ProjectTimeline rowOddFill(String[] strArr, Number number, Boolean bool, Number number2) {
        APIlib.getInstance().addJSLine(String.format(Locale.US, this.jsBase + ".rowOddFill(%s, %s, %s, %s);", arrayToStringWrapQuotes(strArr), number, bool, number2));
        return this;
    }

    @Override // com.anychart.core.ui.Timeline
    public ProjectTimeline rowOddFill(String[] strArr, Number number, Rect rect, Number number2) {
        APIlib.getInstance().addJSLine(String.format(Locale.US, this.jsBase + ".rowOddFill(%s, %s, %s, %s);", arrayToStringWrapQuotes(strArr), number, rect != null ? rect.getJsBase() : null, number2));
        return this;
    }

    @Override // com.anychart.core.ui.Timeline
    public ProjectTimeline rowOddFill(String[] strArr, Number number, String str, Number number2) {
        APIlib.getInstance().addJSLine(String.format(Locale.US, this.jsBase + ".rowOddFill(%s, %s, %s, %s);", arrayToStringWrapQuotes(strArr), number, wrapQuotes(str), number2));
        return this;
    }

    @Override // com.anychart.core.ui.Timeline
    public ProjectTimeline rowOddFill(GradientKey gradientKey, Number number, Number number2, com.anychart.graphics.math.Rect rect, Number number3, Number number4, Number number5) {
        APIlib.getInstance().addJSLine(String.format(Locale.US, this.jsBase + ".rowOddFill(%s, %s, %s, %s, %s, %s, %s);", gradientKey != null ? gradientKey.getJsBase() : null, number, number2, rect != null ? rect.getJsBase() : null, number3, number4, number5));
        return this;
    }

    @Override // com.anychart.core.ui.Timeline
    public ProjectTimeline rowOddFill(String[] strArr, Number number, Number number2, com.anychart.graphics.math.Rect rect, Number number3, Number number4, Number number5) {
        APIlib.getInstance().addJSLine(String.format(Locale.US, this.jsBase + ".rowOddFill(%s, %s, %s, %s, %s, %s, %s);", arrayToStringWrapQuotes(strArr), number, number2, rect != null ? rect.getJsBase() : null, number3, number4, number5));
        return this;
    }

    @Override // com.anychart.core.ui.Timeline
    public void rowSelectedFill() {
        APIlib.getInstance().addJSLine(this.jsBase + ".rowSelectedFill();");
    }

    @Override // com.anychart.core.ui.Timeline
    public ProjectTimeline rowSelectedFill(Fill fill) {
        APIlib.getInstance().addJSLine(String.format(Locale.US, this.jsBase + ".rowSelectedFill(%s);", fill != null ? fill.getJsBase() : null));
        return this;
    }

    @Override // com.anychart.core.ui.Timeline
    public ProjectTimeline rowSelectedFill(GradientKey gradientKey) {
        APIlib.getInstance().addJSLine(String.format(Locale.US, this.jsBase + ".rowSelectedFill(%s);", gradientKey != null ? gradientKey.getJsBase() : null));
        return this;
    }

    @Override // com.anychart.core.ui.Timeline
    public ProjectTimeline rowSelectedFill(String[] strArr) {
        APIlib.getInstance().addJSLine(String.format(Locale.US, this.jsBase + ".rowSelectedFill(%s);", arrayToStringWrapQuotes(strArr)));
        return this;
    }

    @Override // com.anychart.core.ui.Timeline
    public ProjectTimeline rowSelectedFill(String str, Number number) {
        APIlib.getInstance().addJSLine(String.format(Locale.US, this.jsBase + ".rowSelectedFill(%s, %s);", wrapQuotes(str), number));
        return this;
    }

    @Override // com.anychart.core.ui.Timeline
    public ProjectTimeline rowSelectedFill(GradientKey gradientKey, Number number, Boolean bool) {
        APIlib.getInstance().addJSLine(String.format(Locale.US, this.jsBase + ".rowSelectedFill(%s, %s, %s);", gradientKey != null ? gradientKey.getJsBase() : null, number, bool));
        return this;
    }

    @Override // com.anychart.core.ui.Timeline
    public ProjectTimeline rowSelectedFill(GradientKey gradientKey, Number number, Rect rect) {
        APIlib.getInstance().addJSLine(String.format(Locale.US, this.jsBase + ".rowSelectedFill(%s, %s, %s);", gradientKey != null ? gradientKey.getJsBase() : null, number, rect != null ? rect.getJsBase() : null));
        return this;
    }

    @Override // com.anychart.core.ui.Timeline
    public ProjectTimeline rowSelectedFill(GradientKey gradientKey, Number number, String str) {
        APIlib.getInstance().addJSLine(String.format(Locale.US, this.jsBase + ".rowSelectedFill(%s, %s, %s);", gradientKey != null ? gradientKey.getJsBase() : null, number, wrapQuotes(str)));
        return this;
    }

    @Override // com.anychart.core.ui.Timeline
    public ProjectTimeline rowSelectedFill(String[] strArr, Number number, Boolean bool) {
        APIlib.getInstance().addJSLine(String.format(Locale.US, this.jsBase + ".rowSelectedFill(%s, %s, %s);", arrayToStringWrapQuotes(strArr), number, bool));
        return this;
    }

    @Override // com.anychart.core.ui.Timeline
    public ProjectTimeline rowSelectedFill(String[] strArr, Number number, Rect rect) {
        APIlib.getInstance().addJSLine(String.format(Locale.US, this.jsBase + ".rowSelectedFill(%s, %s, %s);", arrayToStringWrapQuotes(strArr), number, rect != null ? rect.getJsBase() : null));
        return this;
    }

    @Override // com.anychart.core.ui.Timeline
    public ProjectTimeline rowSelectedFill(String[] strArr, Number number, String str) {
        APIlib.getInstance().addJSLine(String.format(Locale.US, this.jsBase + ".rowSelectedFill(%s, %s, %s);", arrayToStringWrapQuotes(strArr), number, wrapQuotes(str)));
        return this;
    }

    @Override // com.anychart.core.ui.Timeline
    public ProjectTimeline rowSelectedFill(GradientKey gradientKey, Number number, Number number2, com.anychart.graphics.math.Rect rect, Number number3, Number number4, Number number5) {
        APIlib.getInstance().addJSLine(String.format(Locale.US, this.jsBase + ".rowSelectedFill(%s, %s, %s, %s, %s, %s, %s);", gradientKey != null ? gradientKey.getJsBase() : null, number, number2, rect != null ? rect.getJsBase() : null, number3, number4, number5));
        return this;
    }

    @Override // com.anychart.core.ui.Timeline
    public ProjectTimeline rowSelectedFill(String[] strArr, Number number, Number number2, com.anychart.graphics.math.Rect rect, Number number3, Number number4, Number number5) {
        APIlib.getInstance().addJSLine(String.format(Locale.US, this.jsBase + ".rowSelectedFill(%s, %s, %s, %s, %s, %s, %s);", arrayToStringWrapQuotes(strArr), number, number2, rect != null ? rect.getJsBase() : null, number3, number4, number5));
        return this;
    }

    @Override // com.anychart.core.ui.Timeline
    public void selectedElementFill() {
        APIlib.getInstance().addJSLine(this.jsBase + ".selectedElementFill();");
    }

    @Override // com.anychart.core.ui.Timeline
    public ProjectTimeline selectedElementFill(Fill fill) {
        APIlib.getInstance().addJSLine(String.format(Locale.US, this.jsBase + ".selectedElementFill(%s);", fill != null ? fill.getJsBase() : null));
        return this;
    }

    @Override // com.anychart.core.ui.Timeline
    public ProjectTimeline selectedElementFill(String str, Number number) {
        APIlib.getInstance().addJSLine(String.format(Locale.US, this.jsBase + ".selectedElementFill(%s, %s);", wrapQuotes(str), number));
        return this;
    }

    @Override // com.anychart.core.ui.Timeline
    public ProjectTimeline selectedElementFill(GradientKey gradientKey, Number number, Boolean bool, Number number2) {
        APIlib.getInstance().addJSLine(String.format(Locale.US, this.jsBase + ".selectedElementFill(%s, %s, %s, %s);", gradientKey != null ? gradientKey.getJsBase() : null, number, bool, number2));
        return this;
    }

    @Override // com.anychart.core.ui.Timeline
    public ProjectTimeline selectedElementFill(GradientKey gradientKey, Number number, Rect rect, Number number2) {
        APIlib.getInstance().addJSLine(String.format(Locale.US, this.jsBase + ".selectedElementFill(%s, %s, %s, %s);", gradientKey != null ? gradientKey.getJsBase() : null, number, rect != null ? rect.getJsBase() : null, number2));
        return this;
    }

    @Override // com.anychart.core.ui.Timeline
    public ProjectTimeline selectedElementFill(GradientKey gradientKey, Number number, String str, Number number2) {
        APIlib.getInstance().addJSLine(String.format(Locale.US, this.jsBase + ".selectedElementFill(%s, %s, %s, %s);", gradientKey != null ? gradientKey.getJsBase() : null, number, wrapQuotes(str), number2));
        return this;
    }

    @Override // com.anychart.core.ui.Timeline
    public ProjectTimeline selectedElementFill(String[] strArr, Number number, Boolean bool, Number number2) {
        APIlib.getInstance().addJSLine(String.format(Locale.US, this.jsBase + ".selectedElementFill(%s, %s, %s, %s);", arrayToStringWrapQuotes(strArr), number, bool, number2));
        return this;
    }

    @Override // com.anychart.core.ui.Timeline
    public ProjectTimeline selectedElementFill(String[] strArr, Number number, Rect rect, Number number2) {
        APIlib.getInstance().addJSLine(String.format(Locale.US, this.jsBase + ".selectedElementFill(%s, %s, %s, %s);", arrayToStringWrapQuotes(strArr), number, rect != null ? rect.getJsBase() : null, number2));
        return this;
    }

    @Override // com.anychart.core.ui.Timeline
    public ProjectTimeline selectedElementFill(String[] strArr, Number number, String str, Number number2) {
        APIlib.getInstance().addJSLine(String.format(Locale.US, this.jsBase + ".selectedElementFill(%s, %s, %s, %s);", arrayToStringWrapQuotes(strArr), number, wrapQuotes(str), number2));
        return this;
    }

    @Override // com.anychart.core.ui.Timeline
    public ProjectTimeline selectedElementFill(GradientKey gradientKey, Number number, Number number2, com.anychart.graphics.math.Rect rect, Number number3, Number number4, Number number5) {
        APIlib.getInstance().addJSLine(String.format(Locale.US, this.jsBase + ".selectedElementFill(%s, %s, %s, %s, %s, %s, %s);", gradientKey != null ? gradientKey.getJsBase() : null, number, number2, rect != null ? rect.getJsBase() : null, number3, number4, number5));
        return this;
    }

    @Override // com.anychart.core.ui.Timeline
    public ProjectTimeline selectedElementFill(String[] strArr, Number number, Number number2, com.anychart.graphics.math.Rect rect, Number number3, Number number4, Number number5) {
        APIlib.getInstance().addJSLine(String.format(Locale.US, this.jsBase + ".selectedElementFill(%s, %s, %s, %s, %s, %s, %s);", arrayToStringWrapQuotes(strArr), number, number2, rect != null ? rect.getJsBase() : null, number3, number4, number5));
        return this;
    }

    @Override // com.anychart.core.ui.Timeline
    public void selectedElementStroke() {
        APIlib.getInstance().addJSLine(this.jsBase + ".selectedElementStroke();");
    }

    @Override // com.anychart.core.ui.Timeline
    public ProjectTimeline selectedElementStroke(Stroke stroke, Number number, String str, String str2, String str3) {
        APIlib.getInstance().addJSLine(String.format(Locale.US, this.jsBase + ".selectedElementStroke(%s, %s, %s, %s, %s);", stroke != null ? stroke.getJsBase() : null, number, wrapQuotes(str), wrapQuotes(str2), wrapQuotes(str3)));
        return this;
    }

    @Override // com.anychart.core.ui.Timeline
    public ProjectTimeline selectedElementStroke(Stroke stroke, Number number, String str, String str2, StrokeLineCap strokeLineCap) {
        APIlib.getInstance().addJSLine(String.format(Locale.US, this.jsBase + ".selectedElementStroke(%s, %s, %s, %s, %s);", stroke != null ? stroke.getJsBase() : null, number, wrapQuotes(str), wrapQuotes(str2), strokeLineCap != null ? strokeLineCap.getJsBase() : null));
        return this;
    }

    @Override // com.anychart.core.ui.Timeline
    public ProjectTimeline selectedElementStroke(Stroke stroke, Number number, String str, StrokeLineJoin strokeLineJoin, String str2) {
        APIlib.getInstance().addJSLine(String.format(Locale.US, this.jsBase + ".selectedElementStroke(%s, %s, %s, %s, %s);", stroke != null ? stroke.getJsBase() : null, number, wrapQuotes(str), strokeLineJoin != null ? strokeLineJoin.getJsBase() : null, wrapQuotes(str2)));
        return this;
    }

    @Override // com.anychart.core.ui.Timeline
    public ProjectTimeline selectedElementStroke(Stroke stroke, Number number, String str, StrokeLineJoin strokeLineJoin, StrokeLineCap strokeLineCap) {
        APIlib.getInstance().addJSLine(String.format(Locale.US, this.jsBase + ".selectedElementStroke(%s, %s, %s, %s, %s);", stroke != null ? stroke.getJsBase() : null, number, wrapQuotes(str), strokeLineJoin != null ? strokeLineJoin.getJsBase() : null, strokeLineCap != null ? strokeLineCap.getJsBase() : null));
        return this;
    }

    @Override // com.anychart.core.ui.Timeline
    public ProjectTimeline selectedElementStroke(ColoredFill coloredFill, Number number, String str, String str2, String str3) {
        APIlib.getInstance().addJSLine(String.format(Locale.US, this.jsBase + ".selectedElementStroke(%s, %s, %s, %s, %s);", coloredFill != null ? coloredFill.getJsBase() : null, number, wrapQuotes(str), wrapQuotes(str2), wrapQuotes(str3)));
        return this;
    }

    @Override // com.anychart.core.ui.Timeline
    public ProjectTimeline selectedElementStroke(ColoredFill coloredFill, Number number, String str, String str2, StrokeLineCap strokeLineCap) {
        APIlib.getInstance().addJSLine(String.format(Locale.US, this.jsBase + ".selectedElementStroke(%s, %s, %s, %s, %s);", coloredFill != null ? coloredFill.getJsBase() : null, number, wrapQuotes(str), wrapQuotes(str2), strokeLineCap != null ? strokeLineCap.getJsBase() : null));
        return this;
    }

    @Override // com.anychart.core.ui.Timeline
    public ProjectTimeline selectedElementStroke(ColoredFill coloredFill, Number number, String str, StrokeLineJoin strokeLineJoin, String str2) {
        APIlib.getInstance().addJSLine(String.format(Locale.US, this.jsBase + ".selectedElementStroke(%s, %s, %s, %s, %s);", coloredFill != null ? coloredFill.getJsBase() : null, number, wrapQuotes(str), strokeLineJoin != null ? strokeLineJoin.getJsBase() : null, wrapQuotes(str2)));
        return this;
    }

    @Override // com.anychart.core.ui.Timeline
    public ProjectTimeline selectedElementStroke(ColoredFill coloredFill, Number number, String str, StrokeLineJoin strokeLineJoin, StrokeLineCap strokeLineCap) {
        APIlib.getInstance().addJSLine(String.format(Locale.US, this.jsBase + ".selectedElementStroke(%s, %s, %s, %s, %s);", coloredFill != null ? coloredFill.getJsBase() : null, number, wrapQuotes(str), strokeLineJoin != null ? strokeLineJoin.getJsBase() : null, strokeLineCap != null ? strokeLineCap.getJsBase() : null));
        return this;
    }

    @Override // com.anychart.core.ui.Timeline
    public ProjectTimeline selectedElementStroke(String str, Number number, String str2, String str3, String str4) {
        APIlib.getInstance().addJSLine(String.format(Locale.US, this.jsBase + ".selectedElementStroke(%s, %s, %s, %s, %s);", wrapQuotes(str), number, wrapQuotes(str2), wrapQuotes(str3), wrapQuotes(str4)));
        return this;
    }

    @Override // com.anychart.core.ui.Timeline
    public ProjectTimeline selectedElementStroke(String str, Number number, String str2, String str3, StrokeLineCap strokeLineCap) {
        APIlib.getInstance().addJSLine(String.format(Locale.US, this.jsBase + ".selectedElementStroke(%s, %s, %s, %s, %s);", wrapQuotes(str), number, wrapQuotes(str2), wrapQuotes(str3), strokeLineCap != null ? strokeLineCap.getJsBase() : null));
        return this;
    }

    @Override // com.anychart.core.ui.Timeline
    public ProjectTimeline selectedElementStroke(String str, Number number, String str2, StrokeLineJoin strokeLineJoin, String str3) {
        APIlib.getInstance().addJSLine(String.format(Locale.US, this.jsBase + ".selectedElementStroke(%s, %s, %s, %s, %s);", wrapQuotes(str), number, wrapQuotes(str2), strokeLineJoin != null ? strokeLineJoin.getJsBase() : null, wrapQuotes(str3)));
        return this;
    }

    @Override // com.anychart.core.ui.Timeline
    public ProjectTimeline selectedElementStroke(String str, Number number, String str2, StrokeLineJoin strokeLineJoin, StrokeLineCap strokeLineCap) {
        APIlib.getInstance().addJSLine(String.format(Locale.US, this.jsBase + ".selectedElementStroke(%s, %s, %s, %s, %s);", wrapQuotes(str), number, wrapQuotes(str2), strokeLineJoin != null ? strokeLineJoin.getJsBase() : null, strokeLineCap != null ? strokeLineCap.getJsBase() : null));
        return this;
    }

    @Override // com.anychart.core.ui.Timeline
    public TasksElement tasks() {
        return new TasksElement(this.jsBase + ".tasks()");
    }

    @Override // com.anychart.core.ui.Timeline
    public ProjectTimeline tasks(String str) {
        APIlib.getInstance().addJSLine(String.format(Locale.US, this.jsBase + ".tasks(%s);", wrapQuotes(str)));
        return this;
    }

    @Override // com.anychart.core.ui.Timeline
    public GanttText textMarker(Number number) {
        return new GanttText(String.format(Locale.US, this.jsBase + ".textMarker(%s)", number));
    }

    @Override // com.anychart.core.ui.Timeline
    public ProjectTimeline textMarker(String str) {
        APIlib.getInstance().addJSLine(String.format(Locale.US, this.jsBase + ".textMarker(%s);", wrapQuotes(str)));
        return this;
    }

    @Override // com.anychart.core.ui.Timeline
    public ProjectTimeline textMarker(Boolean bool) {
        APIlib.getInstance().addJSLine(String.format(Locale.US, this.jsBase + ".textMarker(%s);", bool));
        return this;
    }

    @Override // com.anychart.core.ui.Timeline
    public ProjectTimeline textMarker(Number number, String str) {
        APIlib.getInstance().addJSLine(String.format(Locale.US, this.jsBase + ".textMarker(%s, %s);", number, wrapQuotes(str)));
        return this;
    }

    @Override // com.anychart.core.ui.Timeline
    public ProjectTimeline textMarker(Number number, Boolean bool) {
        APIlib.getInstance().addJSLine(String.format(Locale.US, this.jsBase + ".textMarker(%s, %s);", number, bool));
        return this;
    }

    @Override // com.anychart.core.ui.Timeline
    public ProjectTimeline textMarker(Number number, GanttDateTimeMarkers ganttDateTimeMarkers) {
        APIlib.getInstance().addJSLine(String.format(Locale.US, this.jsBase + ".textMarker(%s, %s);", number, ganttDateTimeMarkers != null ? ganttDateTimeMarkers.getJsBase() : null));
        return this;
    }

    @Override // com.anychart.core.ui.Timeline
    public Tooltip tooltip() {
        return new Tooltip(this.jsBase + ".tooltip()");
    }

    @Override // com.anychart.core.ui.Timeline
    public ProjectTimeline tooltip(String str) {
        APIlib.getInstance().addJSLine(String.format(Locale.US, this.jsBase + ".tooltip(%s);", wrapQuotes(str)));
        return this;
    }

    @Override // com.anychart.core.ui.Timeline
    public ProjectTimeline tooltip(Boolean bool) {
        APIlib.getInstance().addJSLine(String.format(Locale.US, this.jsBase + ".tooltip(%s);", bool));
        return this;
    }

    @Override // com.anychart.core.ui.Timeline
    public com.anychart.core.ui.LabelsFactory baseLabels() {
        return new com.anychart.core.ui.LabelsFactory(this.jsBase + ".baseLabels()");
    }

    @Override // com.anychart.core.ui.Timeline
    public ProjectTimeline baseLabels(String str) {
        APIlib.getInstance().addJSLine(String.format(Locale.US, this.jsBase + ".baseLabels(%s);", wrapQuotes(str)));
        return this;
    }

    @Override // com.anychart.core.ui.Timeline
    public ProjectTimeline baseLabels(Boolean bool) {
        APIlib.getInstance().addJSLine(String.format(Locale.US, this.jsBase + ".baseLabels(%s);", bool));
        return this;
    }

    @Override // com.anychart.core.ui.Timeline
    public com.anychart.core.ui.LabelsFactory baselineLabels() {
        return new com.anychart.core.ui.LabelsFactory(this.jsBase + ".baselineLabels()");
    }

    @Override // com.anychart.core.ui.Timeline
    public ProjectTimeline baselineLabels(String str) {
        APIlib.getInstance().addJSLine(String.format(Locale.US, this.jsBase + ".baselineLabels(%s);", wrapQuotes(str)));
        return this;
    }

    @Override // com.anychart.core.ui.Timeline
    public ProjectTimeline baselineLabels(Boolean bool) {
        APIlib.getInstance().addJSLine(String.format(Locale.US, this.jsBase + ".baselineLabels(%s);", bool));
        return this;
    }

    @Override // com.anychart.core.ui.Timeline
    public void editFinishConnectorMarkerHorizontalOffset() {
        APIlib.getInstance().addJSLine(this.jsBase + ".editFinishConnectorMarkerHorizontalOffset();");
    }

    @Override // com.anychart.core.ui.Timeline
    public ProjectTimeline editFinishConnectorMarkerHorizontalOffset(Number number) {
        APIlib.getInstance().addJSLine(String.format(Locale.US, this.jsBase + ".editFinishConnectorMarkerHorizontalOffset(%s);", number));
        return this;
    }

    @Override // com.anychart.core.ui.Timeline
    public void editFinishConnectorMarkerSize() {
        APIlib.getInstance().addJSLine(this.jsBase + ".editFinishConnectorMarkerSize();");
    }

    @Override // com.anychart.core.ui.Timeline
    public ProjectTimeline editFinishConnectorMarkerSize(Number number) {
        APIlib.getInstance().addJSLine(String.format(Locale.US, this.jsBase + ".editFinishConnectorMarkerSize(%s);", number));
        return this;
    }

    @Override // com.anychart.core.ui.Timeline
    public void editFinishConnectorMarkerType() {
        APIlib.getInstance().addJSLine(this.jsBase + ".editFinishConnectorMarkerType();");
    }

    @Override // com.anychart.core.ui.Timeline
    public ProjectTimeline editFinishConnectorMarkerType(MarkerType markerType) {
        APIlib.getInstance().addJSLine(String.format(Locale.US, this.jsBase + ".editFinishConnectorMarkerType(%s);", markerType != null ? markerType.getJsBase() : null));
        return this;
    }

    @Override // com.anychart.core.ui.Timeline
    public ProjectTimeline editFinishConnectorMarkerType(String str) {
        APIlib.getInstance().addJSLine(String.format(Locale.US, this.jsBase + ".editFinishConnectorMarkerType(%s);", wrapQuotes(str)));
        return this;
    }

    @Override // com.anychart.core.ui.Timeline
    public void editFinishConnectorMarkerVerticalOffset() {
        APIlib.getInstance().addJSLine(this.jsBase + ".editFinishConnectorMarkerVerticalOffset();");
    }

    @Override // com.anychart.core.ui.Timeline
    public ProjectTimeline editFinishConnectorMarkerVerticalOffset(Number number) {
        APIlib.getInstance().addJSLine(String.format(Locale.US, this.jsBase + ".editFinishConnectorMarkerVerticalOffset(%s);", number));
        return this;
    }

    @Override // com.anychart.core.ui.Timeline
    public void editIntervalWidth() {
        APIlib.getInstance().addJSLine(this.jsBase + ".editIntervalWidth();");
    }

    @Override // com.anychart.core.ui.Timeline
    public ProjectTimeline editIntervalWidth(Number number) {
        APIlib.getInstance().addJSLine(String.format(Locale.US, this.jsBase + ".editIntervalWidth(%s);", number));
        return this;
    }

    @Override // com.anychart.core.ui.Timeline
    public void editStartConnectorMarkerHorizontalOffset() {
        APIlib.getInstance().addJSLine(this.jsBase + ".editStartConnectorMarkerHorizontalOffset();");
    }

    @Override // com.anychart.core.ui.Timeline
    public ProjectTimeline editStartConnectorMarkerHorizontalOffset(Number number) {
        APIlib.getInstance().addJSLine(String.format(Locale.US, this.jsBase + ".editStartConnectorMarkerHorizontalOffset(%s);", number));
        return this;
    }

    @Override // com.anychart.core.ui.Timeline
    public void editStartConnectorMarkerSize() {
        APIlib.getInstance().addJSLine(this.jsBase + ".editStartConnectorMarkerSize();");
    }

    @Override // com.anychart.core.ui.Timeline
    public ProjectTimeline editStartConnectorMarkerSize(Number number) {
        APIlib.getInstance().addJSLine(String.format(Locale.US, this.jsBase + ".editStartConnectorMarkerSize(%s);", number));
        return this;
    }

    @Override // com.anychart.core.ui.Timeline
    public void editStartConnectorMarkerType() {
        APIlib.getInstance().addJSLine(this.jsBase + ".editStartConnectorMarkerType();");
    }

    @Override // com.anychart.core.ui.Timeline
    public ProjectTimeline editStartConnectorMarkerType(MarkerType markerType) {
        APIlib.getInstance().addJSLine(String.format(Locale.US, this.jsBase + ".editStartConnectorMarkerType(%s);", markerType != null ? markerType.getJsBase() : null));
        return this;
    }

    @Override // com.anychart.core.ui.Timeline
    public ProjectTimeline editStartConnectorMarkerType(String str) {
        APIlib.getInstance().addJSLine(String.format(Locale.US, this.jsBase + ".editStartConnectorMarkerType(%s);", wrapQuotes(str)));
        return this;
    }

    @Override // com.anychart.core.ui.Timeline
    public void editStartConnectorMarkerVerticalOffset() {
        APIlib.getInstance().addJSLine(this.jsBase + ".editStartConnectorMarkerVerticalOffset();");
    }

    @Override // com.anychart.core.ui.Timeline
    public ProjectTimeline editStartConnectorMarkerVerticalOffset(Number number) {
        APIlib.getInstance().addJSLine(String.format(Locale.US, this.jsBase + ".editStartConnectorMarkerVerticalOffset(%s);", number));
        return this;
    }

    @Override // com.anychart.core.ui.Timeline
    public TimeLineHeader header() {
        return new TimeLineHeader(this.jsBase + ".header()");
    }

    @Override // com.anychart.core.ui.Timeline
    public ProjectTimeline header(String str) {
        APIlib.getInstance().addJSLine(String.format(Locale.US, this.jsBase + ".header(%s);", wrapQuotes(str)));
        return this;
    }

    @Override // com.anychart.core.ui.Timeline
    public ScrollBar horizontalScrollBar() {
        return new ScrollBar(this.jsBase + ".horizontalScrollBar()");
    }

    @Override // com.anychart.core.ui.Timeline
    public ProjectTimeline horizontalScrollBar(String str) {
        APIlib.getInstance().addJSLine(String.format(Locale.US, this.jsBase + ".horizontalScrollBar(%s);", wrapQuotes(str)));
        return this;
    }

    @Override // com.anychart.core.ui.Timeline
    public com.anychart.core.ui.LabelsFactory milestoneLabels() {
        return new com.anychart.core.ui.LabelsFactory(this.jsBase + ".milestoneLabels()");
    }

    @Override // com.anychart.core.ui.Timeline
    public ProjectTimeline milestoneLabels(String str) {
        APIlib.getInstance().addJSLine(String.format(Locale.US, this.jsBase + ".milestoneLabels(%s);", wrapQuotes(str)));
        return this;
    }

    @Override // com.anychart.core.ui.Timeline
    public ProjectTimeline milestoneLabels(Boolean bool) {
        APIlib.getInstance().addJSLine(String.format(Locale.US, this.jsBase + ".milestoneLabels(%s);", bool));
        return this;
    }

    @Override // com.anychart.core.ui.Timeline
    public com.anychart.core.ui.LabelsFactory parentLabels() {
        return new com.anychart.core.ui.LabelsFactory(this.jsBase + ".parentLabels()");
    }

    @Override // com.anychart.core.ui.Timeline
    public ProjectTimeline parentLabels(String str) {
        APIlib.getInstance().addJSLine(String.format(Locale.US, this.jsBase + ".parentLabels(%s);", wrapQuotes(str)));
        return this;
    }

    @Override // com.anychart.core.ui.Timeline
    public ProjectTimeline parentLabels(Boolean bool) {
        APIlib.getInstance().addJSLine(String.format(Locale.US, this.jsBase + ".parentLabels(%s);", bool));
        return this;
    }

    @Override // com.anychart.core.ui.Timeline
    public PeriodsElement periods() {
        return new PeriodsElement(this.jsBase + ".periods()");
    }

    @Override // com.anychart.core.ui.Timeline
    public ProjectTimeline periods(String str) {
        APIlib.getInstance().addJSLine(String.format(Locale.US, this.jsBase + ".periods(%s);", wrapQuotes(str)));
        return this;
    }

    @Override // com.anychart.core.ui.Timeline
    public com.anychart.core.ui.LabelsFactory progressLabels() {
        return new com.anychart.core.ui.LabelsFactory(this.jsBase + ".progressLabels()");
    }

    @Override // com.anychart.core.ui.Timeline
    public ProjectTimeline progressLabels(String str) {
        APIlib.getInstance().addJSLine(String.format(Locale.US, this.jsBase + ".progressLabels(%s);", wrapQuotes(str)));
        return this;
    }

    @Override // com.anychart.core.ui.Timeline
    public ProjectTimeline progressLabels(Boolean bool) {
        APIlib.getInstance().addJSLine(String.format(Locale.US, this.jsBase + ".progressLabels(%s);", bool));
        return this;
    }

    @Override // com.anychart.core.ui.Timeline
    public GanttDateTime scale() {
        return new GanttDateTime(this.jsBase + ".scale()");
    }

    @Override // com.anychart.core.ui.Timeline
    public ProjectTimeline scale(String str) {
        APIlib.getInstance().addJSLine(String.format(Locale.US, this.jsBase + ".scale(%s);", wrapQuotes(str)));
        return this;
    }

    @Override // com.anychart.core.ui.Timeline
    public void selectedConnectorStroke() {
        APIlib.getInstance().addJSLine(this.jsBase + ".selectedConnectorStroke();");
    }

    @Override // com.anychart.core.ui.Timeline
    public ProjectTimeline selectedConnectorStroke(Stroke stroke, Number number, String str, String str2, String str3) {
        APIlib.getInstance().addJSLine(String.format(Locale.US, this.jsBase + ".selectedConnectorStroke(%s, %s, %s, %s, %s);", stroke != null ? stroke.getJsBase() : null, number, wrapQuotes(str), wrapQuotes(str2), wrapQuotes(str3)));
        return this;
    }

    @Override // com.anychart.core.ui.Timeline
    public ProjectTimeline selectedConnectorStroke(Stroke stroke, Number number, String str, String str2, StrokeLineCap strokeLineCap) {
        APIlib.getInstance().addJSLine(String.format(Locale.US, this.jsBase + ".selectedConnectorStroke(%s, %s, %s, %s, %s);", stroke != null ? stroke.getJsBase() : null, number, wrapQuotes(str), wrapQuotes(str2), strokeLineCap != null ? strokeLineCap.getJsBase() : null));
        return this;
    }

    @Override // com.anychart.core.ui.Timeline
    public ProjectTimeline selectedConnectorStroke(Stroke stroke, Number number, String str, StrokeLineJoin strokeLineJoin, String str2) {
        APIlib.getInstance().addJSLine(String.format(Locale.US, this.jsBase + ".selectedConnectorStroke(%s, %s, %s, %s, %s);", stroke != null ? stroke.getJsBase() : null, number, wrapQuotes(str), strokeLineJoin != null ? strokeLineJoin.getJsBase() : null, wrapQuotes(str2)));
        return this;
    }

    @Override // com.anychart.core.ui.Timeline
    public ProjectTimeline selectedConnectorStroke(Stroke stroke, Number number, String str, StrokeLineJoin strokeLineJoin, StrokeLineCap strokeLineCap) {
        APIlib.getInstance().addJSLine(String.format(Locale.US, this.jsBase + ".selectedConnectorStroke(%s, %s, %s, %s, %s);", stroke != null ? stroke.getJsBase() : null, number, wrapQuotes(str), strokeLineJoin != null ? strokeLineJoin.getJsBase() : null, strokeLineCap != null ? strokeLineCap.getJsBase() : null));
        return this;
    }

    @Override // com.anychart.core.ui.Timeline
    public ProjectTimeline selectedConnectorStroke(ColoredFill coloredFill, Number number, String str, String str2, String str3) {
        APIlib.getInstance().addJSLine(String.format(Locale.US, this.jsBase + ".selectedConnectorStroke(%s, %s, %s, %s, %s);", coloredFill != null ? coloredFill.getJsBase() : null, number, wrapQuotes(str), wrapQuotes(str2), wrapQuotes(str3)));
        return this;
    }

    @Override // com.anychart.core.ui.Timeline
    public ProjectTimeline selectedConnectorStroke(ColoredFill coloredFill, Number number, String str, String str2, StrokeLineCap strokeLineCap) {
        APIlib.getInstance().addJSLine(String.format(Locale.US, this.jsBase + ".selectedConnectorStroke(%s, %s, %s, %s, %s);", coloredFill != null ? coloredFill.getJsBase() : null, number, wrapQuotes(str), wrapQuotes(str2), strokeLineCap != null ? strokeLineCap.getJsBase() : null));
        return this;
    }

    @Override // com.anychart.core.ui.Timeline
    public ProjectTimeline selectedConnectorStroke(ColoredFill coloredFill, Number number, String str, StrokeLineJoin strokeLineJoin, String str2) {
        APIlib.getInstance().addJSLine(String.format(Locale.US, this.jsBase + ".selectedConnectorStroke(%s, %s, %s, %s, %s);", coloredFill != null ? coloredFill.getJsBase() : null, number, wrapQuotes(str), strokeLineJoin != null ? strokeLineJoin.getJsBase() : null, wrapQuotes(str2)));
        return this;
    }

    @Override // com.anychart.core.ui.Timeline
    public ProjectTimeline selectedConnectorStroke(ColoredFill coloredFill, Number number, String str, StrokeLineJoin strokeLineJoin, StrokeLineCap strokeLineCap) {
        APIlib.getInstance().addJSLine(String.format(Locale.US, this.jsBase + ".selectedConnectorStroke(%s, %s, %s, %s, %s);", coloredFill != null ? coloredFill.getJsBase() : null, number, wrapQuotes(str), strokeLineJoin != null ? strokeLineJoin.getJsBase() : null, strokeLineCap != null ? strokeLineCap.getJsBase() : null));
        return this;
    }

    @Override // com.anychart.core.ui.Timeline
    public ProjectTimeline selectedConnectorStroke(String str, Number number, String str2, String str3, String str4) {
        APIlib.getInstance().addJSLine(String.format(Locale.US, this.jsBase + ".selectedConnectorStroke(%s, %s, %s, %s, %s);", wrapQuotes(str), number, wrapQuotes(str2), wrapQuotes(str3), wrapQuotes(str4)));
        return this;
    }

    @Override // com.anychart.core.ui.Timeline
    public ProjectTimeline selectedConnectorStroke(String str, Number number, String str2, String str3, StrokeLineCap strokeLineCap) {
        APIlib.getInstance().addJSLine(String.format(Locale.US, this.jsBase + ".selectedConnectorStroke(%s, %s, %s, %s, %s);", wrapQuotes(str), number, wrapQuotes(str2), wrapQuotes(str3), strokeLineCap != null ? strokeLineCap.getJsBase() : null));
        return this;
    }

    @Override // com.anychart.core.ui.Timeline
    public ProjectTimeline selectedConnectorStroke(String str, Number number, String str2, StrokeLineJoin strokeLineJoin, String str3) {
        APIlib.getInstance().addJSLine(String.format(Locale.US, this.jsBase + ".selectedConnectorStroke(%s, %s, %s, %s, %s);", wrapQuotes(str), number, wrapQuotes(str2), strokeLineJoin != null ? strokeLineJoin.getJsBase() : null, wrapQuotes(str3)));
        return this;
    }

    @Override // com.anychart.core.ui.Timeline
    public ProjectTimeline selectedConnectorStroke(String str, Number number, String str2, StrokeLineJoin strokeLineJoin, StrokeLineCap strokeLineCap) {
        APIlib.getInstance().addJSLine(String.format(Locale.US, this.jsBase + ".selectedConnectorStroke(%s, %s, %s, %s, %s);", wrapQuotes(str), number, wrapQuotes(str2), strokeLineJoin != null ? strokeLineJoin.getJsBase() : null, strokeLineCap != null ? strokeLineCap.getJsBase() : null));
        return this;
    }

    @Override // com.anychart.core.ui.Timeline
    public ScrollBar verticalScrollBar() {
        return new ScrollBar(this.jsBase + ".verticalScrollBar()");
    }

    @Override // com.anychart.core.ui.Timeline
    public ProjectTimeline verticalScrollBar(String str) {
        APIlib.getInstance().addJSLine(String.format(Locale.US, this.jsBase + ".verticalScrollBar(%s);", wrapQuotes(str)));
        return this;
    }
}
