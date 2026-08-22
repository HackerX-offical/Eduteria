package com.anychart.charts;

import com.amazonaws.services.s3.model.InstructionFileId;
import com.anychart.APIlib;
import com.anychart.chart.common.dataentry.DataEntry;
import com.anychart.chart.common.listener.ListenersInterface;
import com.anychart.core.Chart;
import com.anychart.core.NoDataSettings;
import com.anychart.core.axes.Linear;
import com.anychart.core.axismarkers.Range;
import com.anychart.core.ui.Background;
import com.anychart.core.ui.ChartCredits;
import com.anychart.core.ui.Label;
import com.anychart.core.ui.Title;
import com.anychart.core.ui.Tooltip;
import com.anychart.core.utils.Animation;
import com.anychart.core.utils.Bounds;
import com.anychart.core.utils.ChartA11y;
import com.anychart.core.utils.Exports;
import com.anychart.core.utils.Margin;
import com.anychart.core.utils.Padding;
import com.anychart.data.View;
import com.anychart.enums.ChartDataExportMode;
import com.anychart.enums.Layout;
import com.anychart.enums.MarkerType;
import com.anychart.enums.ScaleTypes;
import com.anychart.enums.Statistics;
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
import com.anychart.math.Rect;
import com.anychart.palettes.DistinctColors;
import com.anychart.palettes.Markers;
import com.anychart.scales.Base;
import com.anychart.ui.ContextMenu;
import com.anychart.utils.RectObj;
import java.util.Arrays;
import java.util.List;
import java.util.Locale;

/* JADX INFO: loaded from: classes4.dex */
public class Bullet extends Chart {
    protected Bullet() {
    }

    public static Bullet instantiate() {
        return new Bullet("new anychart.charts.bullet()");
    }

    public Bullet(String str) {
        StringBuilder sb = new StringBuilder("bullet");
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
    public Bullet a11y(Boolean bool) {
        APIlib.getInstance().addJSLine(String.format(Locale.US, this.jsBase + ".a11y(%s);", bool));
        return this;
    }

    @Override // com.anychart.core.Chart
    public Bullet a11y(String str) {
        APIlib.getInstance().addJSLine(String.format(Locale.US, this.jsBase + ".a11y(%s);", wrapQuotes(str)));
        return this;
    }

    @Override // com.anychart.core.Chart
    public Animation animation() {
        return new Animation(this.jsBase + ".animation()");
    }

    @Override // com.anychart.core.Chart
    public Bullet animation(Boolean bool) {
        APIlib.getInstance().addJSLine(String.format(Locale.US, this.jsBase + ".animation(%s);", bool));
        return this;
    }

    @Override // com.anychart.core.Chart
    public Bullet animation(String str) {
        APIlib.getInstance().addJSLine(String.format(Locale.US, this.jsBase + ".animation(%s);", wrapQuotes(str)));
        return this;
    }

    @Override // com.anychart.core.Chart
    public Bullet animation(Boolean bool, Number number) {
        APIlib.getInstance().addJSLine(String.format(Locale.US, this.jsBase + ".animation(%s, %s);", bool, number));
        return this;
    }

    @Override // com.anychart.core.Chart
    public void autoRedraw() {
        APIlib.getInstance().addJSLine(this.jsBase + ".autoRedraw();");
    }

    @Override // com.anychart.core.Chart
    public Bullet autoRedraw(Boolean bool) {
        APIlib.getInstance().addJSLine(String.format(Locale.US, this.jsBase + ".autoRedraw(%s);", bool));
        return this;
    }

    public Linear axis() {
        return new Linear(this.jsBase + ".axis()");
    }

    public Bullet axis(String str) {
        APIlib.getInstance().addJSLine(String.format(Locale.US, this.jsBase + ".axis(%s);", wrapQuotes(str)));
        return this;
    }

    public Bullet axis(Boolean bool) {
        APIlib.getInstance().addJSLine(String.format(Locale.US, this.jsBase + ".axis(%s);", bool));
        return this;
    }

    @Override // com.anychart.core.Chart
    public Background background() {
        return new Background(this.jsBase + ".background()");
    }

    @Override // com.anychart.core.Chart
    public Bullet background(String str) {
        APIlib.getInstance().addJSLine(String.format(Locale.US, this.jsBase + ".background(%s);", wrapQuotes(str)));
        return this;
    }

    @Override // com.anychart.core.Chart, com.anychart.core.VisualBaseWithBounds
    public void bottom() {
        APIlib.getInstance().addJSLine(this.jsBase + ".bottom();");
    }

    @Override // com.anychart.core.Chart, com.anychart.core.VisualBaseWithBounds
    public Bullet bottom(Number number) {
        APIlib.getInstance().addJSLine(String.format(Locale.US, this.jsBase + ".bottom(%s);", number));
        return this;
    }

    @Override // com.anychart.core.Chart, com.anychart.core.VisualBaseWithBounds
    public Bullet bottom(String str) {
        APIlib.getInstance().addJSLine(String.format(Locale.US, this.jsBase + ".bottom(%s);", wrapQuotes(str)));
        return this;
    }

    @Override // com.anychart.core.Chart, com.anychart.core.VisualBaseWithBounds
    public Bounds bounds() {
        return new Bounds(this.jsBase + ".bounds()");
    }

    @Override // com.anychart.core.Chart, com.anychart.core.VisualBaseWithBounds
    public Bullet bounds(RectObj rectObj) {
        APIlib.getInstance().addJSLine(String.format(Locale.US, this.jsBase + ".bounds(%s);", rectObj != null ? rectObj.getJsBase() : null));
        return this;
    }

    @Override // com.anychart.core.Chart, com.anychart.core.VisualBaseWithBounds
    public Bullet bounds(Rect rect) {
        APIlib.getInstance().addJSLine(String.format(Locale.US, this.jsBase + ".bounds(%s);", rect != null ? rect.getJsBase() : null));
        return this;
    }

    @Override // com.anychart.core.Chart, com.anychart.core.VisualBaseWithBounds
    public Bullet bounds(Bounds bounds) {
        APIlib.getInstance().addJSLine(String.format(Locale.US, this.jsBase + ".bounds(%s);", bounds != null ? bounds.getJsBase() : null));
        return this;
    }

    @Override // com.anychart.core.Chart, com.anychart.core.VisualBaseWithBounds
    public Bullet bounds(Number number, Number number2, Number number3, Number number4) {
        APIlib.getInstance().addJSLine(String.format(Locale.US, this.jsBase + ".bounds(%s, %s, %s, %s);", number, number2, number3, number4));
        return this;
    }

    @Override // com.anychart.core.Chart, com.anychart.core.VisualBaseWithBounds
    public Bullet bounds(Number number, Number number2, Number number3, String str) {
        APIlib.getInstance().addJSLine(String.format(Locale.US, this.jsBase + ".bounds(%s, %s, %s, %s);", number, number2, number3, wrapQuotes(str)));
        return this;
    }

    @Override // com.anychart.core.Chart, com.anychart.core.VisualBaseWithBounds
    public Bullet bounds(Number number, Number number2, String str, Number number3) {
        APIlib.getInstance().addJSLine(String.format(Locale.US, this.jsBase + ".bounds(%s, %s, %s, %s);", number, number2, wrapQuotes(str), number3));
        return this;
    }

    @Override // com.anychart.core.Chart, com.anychart.core.VisualBaseWithBounds
    public Bullet bounds(Number number, Number number2, String str, String str2) {
        APIlib.getInstance().addJSLine(String.format(Locale.US, this.jsBase + ".bounds(%s, %s, %s, %s);", number, number2, wrapQuotes(str), wrapQuotes(str2)));
        return this;
    }

    @Override // com.anychart.core.Chart, com.anychart.core.VisualBaseWithBounds
    public Bullet bounds(Number number, String str, Number number2, Number number3) {
        APIlib.getInstance().addJSLine(String.format(Locale.US, this.jsBase + ".bounds(%s, %s, %s, %s);", number, wrapQuotes(str), number2, number3));
        return this;
    }

    @Override // com.anychart.core.Chart, com.anychart.core.VisualBaseWithBounds
    public Bullet bounds(Number number, String str, Number number2, String str2) {
        APIlib.getInstance().addJSLine(String.format(Locale.US, this.jsBase + ".bounds(%s, %s, %s, %s);", number, wrapQuotes(str), number2, wrapQuotes(str2)));
        return this;
    }

    @Override // com.anychart.core.Chart, com.anychart.core.VisualBaseWithBounds
    public Bullet bounds(Number number, String str, String str2, Number number2) {
        APIlib.getInstance().addJSLine(String.format(Locale.US, this.jsBase + ".bounds(%s, %s, %s, %s);", number, wrapQuotes(str), wrapQuotes(str2), number2));
        return this;
    }

    @Override // com.anychart.core.Chart, com.anychart.core.VisualBaseWithBounds
    public Bullet bounds(Number number, String str, String str2, String str3) {
        APIlib.getInstance().addJSLine(String.format(Locale.US, this.jsBase + ".bounds(%s, %s, %s, %s);", number, wrapQuotes(str), wrapQuotes(str2), wrapQuotes(str3)));
        return this;
    }

    @Override // com.anychart.core.Chart, com.anychart.core.VisualBaseWithBounds
    public Bullet bounds(String str, Number number, Number number2, Number number3) {
        APIlib.getInstance().addJSLine(String.format(Locale.US, this.jsBase + ".bounds(%s, %s, %s, %s);", wrapQuotes(str), number, number2, number3));
        return this;
    }

    @Override // com.anychart.core.Chart, com.anychart.core.VisualBaseWithBounds
    public Bullet bounds(String str, Number number, Number number2, String str2) {
        APIlib.getInstance().addJSLine(String.format(Locale.US, this.jsBase + ".bounds(%s, %s, %s, %s);", wrapQuotes(str), number, number2, wrapQuotes(str2)));
        return this;
    }

    @Override // com.anychart.core.Chart, com.anychart.core.VisualBaseWithBounds
    public Bullet bounds(String str, Number number, String str2, Number number2) {
        APIlib.getInstance().addJSLine(String.format(Locale.US, this.jsBase + ".bounds(%s, %s, %s, %s);", wrapQuotes(str), number, wrapQuotes(str2), number2));
        return this;
    }

    @Override // com.anychart.core.Chart, com.anychart.core.VisualBaseWithBounds
    public Bullet bounds(String str, Number number, String str2, String str3) {
        APIlib.getInstance().addJSLine(String.format(Locale.US, this.jsBase + ".bounds(%s, %s, %s, %s);", wrapQuotes(str), number, wrapQuotes(str2), wrapQuotes(str3)));
        return this;
    }

    @Override // com.anychart.core.Chart, com.anychart.core.VisualBaseWithBounds
    public Bullet bounds(String str, String str2, Number number, Number number2) {
        APIlib.getInstance().addJSLine(String.format(Locale.US, this.jsBase + ".bounds(%s, %s, %s, %s);", wrapQuotes(str), wrapQuotes(str2), number, number2));
        return this;
    }

    @Override // com.anychart.core.Chart, com.anychart.core.VisualBaseWithBounds
    public Bullet bounds(String str, String str2, Number number, String str3) {
        APIlib.getInstance().addJSLine(String.format(Locale.US, this.jsBase + ".bounds(%s, %s, %s, %s);", wrapQuotes(str), wrapQuotes(str2), number, wrapQuotes(str3)));
        return this;
    }

    @Override // com.anychart.core.Chart, com.anychart.core.VisualBaseWithBounds
    public Bullet bounds(String str, String str2, String str3, Number number) {
        APIlib.getInstance().addJSLine(String.format(Locale.US, this.jsBase + ".bounds(%s, %s, %s, %s);", wrapQuotes(str), wrapQuotes(str2), wrapQuotes(str3), number));
        return this;
    }

    @Override // com.anychart.core.Chart, com.anychart.core.VisualBaseWithBounds
    public Bullet bounds(String str, String str2, String str3, String str4) {
        APIlib.getInstance().addJSLine(String.format(Locale.US, this.jsBase + ".bounds(%s, %s, %s, %s);", wrapQuotes(str), wrapQuotes(str2), wrapQuotes(str3), wrapQuotes(str4)));
        return this;
    }

    @Override // com.anychart.core.Chart
    public Bullet cancelMarquee() {
        APIlib.getInstance().addJSLine(this.jsBase + ".cancelMarquee();");
        return this;
    }

    @Override // com.anychart.core.Chart, com.anychart.core.VisualBaseWithBounds, com.anychart.core.VisualBase
    public Layer container() {
        return new Layer(this.jsBase + ".container()");
    }

    @Override // com.anychart.core.Chart, com.anychart.core.VisualBaseWithBounds, com.anychart.core.VisualBase
    public Bullet container(Layer layer) {
        APIlib.getInstance().addJSLine(String.format(Locale.US, this.jsBase + ".container(%s);", layer != null ? layer.getJsBase() : null));
        return this;
    }

    @Override // com.anychart.core.Chart, com.anychart.core.VisualBaseWithBounds, com.anychart.core.VisualBase
    public Bullet container(Stage stage) {
        APIlib.getInstance().addJSLine(String.format(Locale.US, this.jsBase + ".container(%s);", stage != null ? stage.getJsBase() : null));
        return this;
    }

    @Override // com.anychart.core.Chart, com.anychart.core.VisualBaseWithBounds, com.anychart.core.VisualBase
    public Bullet container(String str) {
        APIlib.getInstance().addJSLine(String.format(Locale.US, this.jsBase + ".container(%s);", wrapQuotes(str)));
        return this;
    }

    @Override // com.anychart.core.Chart
    public ContextMenu contextMenu() {
        return new ContextMenu(this.jsBase + ".contextMenu()");
    }

    @Override // com.anychart.core.Chart
    public Bullet contextMenu(String str) {
        APIlib.getInstance().addJSLine(String.format(Locale.US, this.jsBase + ".contextMenu(%s);", wrapQuotes(str)));
        return this;
    }

    @Override // com.anychart.core.Chart
    public Bullet contextMenu(Boolean bool) {
        APIlib.getInstance().addJSLine(String.format(Locale.US, this.jsBase + ".contextMenu(%s);", bool));
        return this;
    }

    @Override // com.anychart.core.Chart
    public ChartCredits credits() {
        return new ChartCredits(this.jsBase + ".credits()");
    }

    @Override // com.anychart.core.Chart
    public Bullet credits(String str) {
        APIlib.getInstance().addJSLine(String.format(Locale.US, this.jsBase + ".credits(%s);", wrapQuotes(str)));
        return this;
    }

    @Override // com.anychart.core.Chart
    public Bullet credits(Boolean bool) {
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
    public Bullet draw(Boolean bool) {
        APIlib.getInstance().addJSLine(String.format(Locale.US, this.jsBase + ".draw(%s);", bool));
        return this;
    }

    @Override // com.anychart.core.Chart, com.anychart.core.VisualBaseWithBounds, com.anychart.core.VisualBase
    public void enabled() {
        APIlib.getInstance().addJSLine(this.jsBase + ".enabled();");
    }

    @Override // com.anychart.core.Chart, com.anychart.core.VisualBaseWithBounds, com.anychart.core.VisualBase
    public Bullet enabled(Boolean bool) {
        APIlib.getInstance().addJSLine(String.format(Locale.US, this.jsBase + ".enabled(%s);", bool));
        return this;
    }

    @Override // com.anychart.core.Chart
    public Exports exports() {
        return new Exports(this.jsBase + ".exports()");
    }

    @Override // com.anychart.core.Chart
    public Bullet exports(String str) {
        APIlib.getInstance().addJSLine(String.format(Locale.US, this.jsBase + ".exports(%s);", wrapQuotes(str)));
        return this;
    }

    @Override // com.anychart.core.Chart
    public void fullScreen() {
        APIlib.getInstance().addJSLine(this.jsBase + ".fullScreen();");
    }

    @Override // com.anychart.core.Chart
    public Bullet fullScreen(Boolean bool) {
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

    @Override // com.anychart.core.Chart, com.anychart.core.VisualBaseWithBounds
    public void height() {
        APIlib.getInstance().addJSLine(this.jsBase + ".height();");
    }

    @Override // com.anychart.core.Chart, com.anychart.core.VisualBaseWithBounds
    public Bullet height(Number number) {
        APIlib.getInstance().addJSLine(String.format(Locale.US, this.jsBase + ".height(%s);", number));
        return this;
    }

    @Override // com.anychart.core.Chart, com.anychart.core.VisualBaseWithBounds
    public Bullet height(String str) {
        APIlib.getInstance().addJSLine(String.format(Locale.US, this.jsBase + ".height(%s);", wrapQuotes(str)));
        return this;
    }

    @Override // com.anychart.core.Chart
    public void id() {
        APIlib.getInstance().addJSLine(this.jsBase + ".id();");
    }

    @Override // com.anychart.core.Chart
    public Bullet id(String str) {
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

    public void isHorizontal() {
        APIlib.getInstance().addJSLine(this.jsBase + ".isHorizontal();");
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
    public Bullet label(Boolean bool) {
        APIlib.getInstance().addJSLine(String.format(Locale.US, this.jsBase + ".label(%s);", bool));
        return this;
    }

    @Override // com.anychart.core.Chart
    public Bullet label(String str, Boolean bool) {
        APIlib.getInstance().addJSLine(String.format(Locale.US, this.jsBase + ".label(%s, %s);", wrapQuotes(str), bool));
        return this;
    }

    @Override // com.anychart.core.Chart
    public Bullet label(String str, String str2) {
        APIlib.getInstance().addJSLine(String.format(Locale.US, this.jsBase + ".label(%s, %s);", wrapQuotes(str), wrapQuotes(str2)));
        return this;
    }

    @Override // com.anychart.core.Chart
    public Bullet label(Number number, Boolean bool) {
        APIlib.getInstance().addJSLine(String.format(Locale.US, this.jsBase + ".label(%s, %s);", number, bool));
        return this;
    }

    @Override // com.anychart.core.Chart
    public Bullet label(Number number, String str) {
        APIlib.getInstance().addJSLine(String.format(Locale.US, this.jsBase + ".label(%s, %s);", number, wrapQuotes(str)));
        return this;
    }

    public void layout() {
        APIlib.getInstance().addJSLine(this.jsBase + ".layout();");
    }

    public Bullet layout(Layout layout) {
        APIlib.getInstance().addJSLine(String.format(Locale.US, this.jsBase + ".layout(%s);", layout != null ? layout.getJsBase() : null));
        return this;
    }

    public Bullet layout(String str) {
        APIlib.getInstance().addJSLine(String.format(Locale.US, this.jsBase + ".layout(%s);", wrapQuotes(str)));
        return this;
    }

    @Override // com.anychart.core.Chart, com.anychart.core.VisualBaseWithBounds
    public void left() {
        APIlib.getInstance().addJSLine(this.jsBase + ".left();");
    }

    @Override // com.anychart.core.Chart, com.anychart.core.VisualBaseWithBounds
    public Bullet left(Number number) {
        APIlib.getInstance().addJSLine(String.format(Locale.US, this.jsBase + ".left(%s);", number));
        return this;
    }

    @Override // com.anychart.core.Chart, com.anychart.core.VisualBaseWithBounds
    public Bullet left(String str) {
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
    public Bullet margin(Number[] numberArr) {
        APIlib.getInstance().addJSLine(String.format(Locale.US, this.jsBase + ".margin(%s);", Arrays.toString(numberArr)));
        return this;
    }

    @Override // com.anychart.core.Chart
    public Bullet margin(String[] strArr) {
        APIlib.getInstance().addJSLine(String.format(Locale.US, this.jsBase + ".margin(%s);", arrayToStringWrapQuotes(strArr)));
        return this;
    }

    @Override // com.anychart.core.Chart
    public Bullet margin(String str) {
        APIlib.getInstance().addJSLine(String.format(Locale.US, this.jsBase + ".margin(%s);", wrapQuotes(str)));
        return this;
    }

    @Override // com.anychart.core.Chart
    public Bullet margin(String str, String str2, String str3, String str4) {
        APIlib.getInstance().addJSLine(String.format(Locale.US, this.jsBase + ".margin(%s, %s, %s, %s);", wrapQuotes(str), wrapQuotes(str2), wrapQuotes(str3), wrapQuotes(str4)));
        return this;
    }

    @Override // com.anychart.core.Chart
    public Bullet margin(String str, String str2, String str3, Number number) {
        APIlib.getInstance().addJSLine(String.format(Locale.US, this.jsBase + ".margin(%s, %s, %s, %s);", wrapQuotes(str), wrapQuotes(str2), wrapQuotes(str3), number));
        return this;
    }

    @Override // com.anychart.core.Chart
    public Bullet margin(String str, String str2, Number number, String str3) {
        APIlib.getInstance().addJSLine(String.format(Locale.US, this.jsBase + ".margin(%s, %s, %s, %s);", wrapQuotes(str), wrapQuotes(str2), number, wrapQuotes(str3)));
        return this;
    }

    @Override // com.anychart.core.Chart
    public Bullet margin(String str, String str2, Number number, Number number2) {
        APIlib.getInstance().addJSLine(String.format(Locale.US, this.jsBase + ".margin(%s, %s, %s, %s);", wrapQuotes(str), wrapQuotes(str2), number, number2));
        return this;
    }

    @Override // com.anychart.core.Chart
    public Bullet margin(String str, Number number, String str2, String str3) {
        APIlib.getInstance().addJSLine(String.format(Locale.US, this.jsBase + ".margin(%s, %s, %s, %s);", wrapQuotes(str), number, wrapQuotes(str2), wrapQuotes(str3)));
        return this;
    }

    @Override // com.anychart.core.Chart
    public Bullet margin(String str, Number number, String str2, Number number2) {
        APIlib.getInstance().addJSLine(String.format(Locale.US, this.jsBase + ".margin(%s, %s, %s, %s);", wrapQuotes(str), number, wrapQuotes(str2), number2));
        return this;
    }

    @Override // com.anychart.core.Chart
    public Bullet margin(String str, Number number, Number number2, String str2) {
        APIlib.getInstance().addJSLine(String.format(Locale.US, this.jsBase + ".margin(%s, %s, %s, %s);", wrapQuotes(str), number, number2, wrapQuotes(str2)));
        return this;
    }

    @Override // com.anychart.core.Chart
    public Bullet margin(String str, Number number, Number number2, Number number3) {
        APIlib.getInstance().addJSLine(String.format(Locale.US, this.jsBase + ".margin(%s, %s, %s, %s);", wrapQuotes(str), number, number2, number3));
        return this;
    }

    @Override // com.anychart.core.Chart
    public Bullet margin(Number number, String str, String str2, String str3) {
        APIlib.getInstance().addJSLine(String.format(Locale.US, this.jsBase + ".margin(%s, %s, %s, %s);", number, wrapQuotes(str), wrapQuotes(str2), wrapQuotes(str3)));
        return this;
    }

    @Override // com.anychart.core.Chart
    public Bullet margin(Number number, String str, String str2, Number number2) {
        APIlib.getInstance().addJSLine(String.format(Locale.US, this.jsBase + ".margin(%s, %s, %s, %s);", number, wrapQuotes(str), wrapQuotes(str2), number2));
        return this;
    }

    @Override // com.anychart.core.Chart
    public Bullet margin(Number number, String str, Number number2, String str2) {
        APIlib.getInstance().addJSLine(String.format(Locale.US, this.jsBase + ".margin(%s, %s, %s, %s);", number, wrapQuotes(str), number2, wrapQuotes(str2)));
        return this;
    }

    @Override // com.anychart.core.Chart
    public Bullet margin(Number number, String str, Number number2, Number number3) {
        APIlib.getInstance().addJSLine(String.format(Locale.US, this.jsBase + ".margin(%s, %s, %s, %s);", number, wrapQuotes(str), number2, number3));
        return this;
    }

    @Override // com.anychart.core.Chart
    public Bullet margin(Number number, Number number2, String str, String str2) {
        APIlib.getInstance().addJSLine(String.format(Locale.US, this.jsBase + ".margin(%s, %s, %s, %s);", number, number2, wrapQuotes(str), wrapQuotes(str2)));
        return this;
    }

    @Override // com.anychart.core.Chart
    public Bullet margin(Number number, Number number2, String str, Number number3) {
        APIlib.getInstance().addJSLine(String.format(Locale.US, this.jsBase + ".margin(%s, %s, %s, %s);", number, number2, wrapQuotes(str), number3));
        return this;
    }

    @Override // com.anychart.core.Chart
    public Bullet margin(Number number, Number number2, Number number3, String str) {
        APIlib.getInstance().addJSLine(String.format(Locale.US, this.jsBase + ".margin(%s, %s, %s, %s);", number, number2, number3, wrapQuotes(str)));
        return this;
    }

    @Override // com.anychart.core.Chart
    public Bullet margin(Number number, Number number2, Number number3, Number number4) {
        APIlib.getInstance().addJSLine(String.format(Locale.US, this.jsBase + ".margin(%s, %s, %s, %s);", number, number2, number3, number4));
        return this;
    }

    public Markers markerPalette() {
        return new Markers(this.jsBase + ".markerPalette()");
    }

    public Bullet markerPalette(MarkerType markerType) {
        APIlib.getInstance().addJSLine(String.format(Locale.US, this.jsBase + ".markerPalette(%s);", markerType != null ? markerType.getJsBase() : null));
        return this;
    }

    public Bullet markerPalette(String[] strArr) {
        APIlib.getInstance().addJSLine(String.format(Locale.US, this.jsBase + ".markerPalette(%s);", arrayToStringWrapQuotes(strArr)));
        return this;
    }

    public Bullet markerPalette(String str) {
        APIlib.getInstance().addJSLine(String.format(Locale.US, this.jsBase + ".markerPalette(%s);", wrapQuotes(str)));
        return this;
    }

    public Bullet markerPalette(Markers markers) {
        APIlib.getInstance().addJSLine(String.format(Locale.US, this.jsBase + ".markerPalette(%s);", markers != null ? markers.getJsBase() : null));
        return this;
    }

    @Override // com.anychart.core.Chart, com.anychart.core.VisualBaseWithBounds
    public void maxHeight() {
        APIlib.getInstance().addJSLine(this.jsBase + ".maxHeight();");
    }

    @Override // com.anychart.core.Chart, com.anychart.core.VisualBaseWithBounds
    public Bullet maxHeight(Number number) {
        APIlib.getInstance().addJSLine(String.format(Locale.US, this.jsBase + ".maxHeight(%s);", number));
        return this;
    }

    @Override // com.anychart.core.Chart, com.anychart.core.VisualBaseWithBounds
    public Bullet maxHeight(String str) {
        APIlib.getInstance().addJSLine(String.format(Locale.US, this.jsBase + ".maxHeight(%s);", wrapQuotes(str)));
        return this;
    }

    @Override // com.anychart.core.Chart, com.anychart.core.VisualBaseWithBounds
    public void maxWidth() {
        APIlib.getInstance().addJSLine(this.jsBase + ".maxWidth();");
    }

    @Override // com.anychart.core.Chart, com.anychart.core.VisualBaseWithBounds
    public Bullet maxWidth(Number number) {
        APIlib.getInstance().addJSLine(String.format(Locale.US, this.jsBase + ".maxWidth(%s);", number));
        return this;
    }

    @Override // com.anychart.core.Chart, com.anychart.core.VisualBaseWithBounds
    public Bullet maxWidth(String str) {
        APIlib.getInstance().addJSLine(String.format(Locale.US, this.jsBase + ".maxWidth(%s);", wrapQuotes(str)));
        return this;
    }

    @Override // com.anychart.core.Chart, com.anychart.core.VisualBaseWithBounds
    public void minHeight() {
        APIlib.getInstance().addJSLine(this.jsBase + ".minHeight();");
    }

    @Override // com.anychart.core.Chart, com.anychart.core.VisualBaseWithBounds
    public Bullet minHeight(Number number) {
        APIlib.getInstance().addJSLine(String.format(Locale.US, this.jsBase + ".minHeight(%s);", number));
        return this;
    }

    @Override // com.anychart.core.Chart, com.anychart.core.VisualBaseWithBounds
    public Bullet minHeight(String str) {
        APIlib.getInstance().addJSLine(String.format(Locale.US, this.jsBase + ".minHeight(%s);", wrapQuotes(str)));
        return this;
    }

    @Override // com.anychart.core.Chart, com.anychart.core.VisualBaseWithBounds
    public void minWidth() {
        APIlib.getInstance().addJSLine(this.jsBase + ".minWidth();");
    }

    @Override // com.anychart.core.Chart, com.anychart.core.VisualBaseWithBounds
    public Bullet minWidth(Number number) {
        APIlib.getInstance().addJSLine(String.format(Locale.US, this.jsBase + ".minWidth(%s);", number));
        return this;
    }

    @Override // com.anychart.core.Chart, com.anychart.core.VisualBaseWithBounds
    public Bullet minWidth(String str) {
        APIlib.getInstance().addJSLine(String.format(Locale.US, this.jsBase + ".minWidth(%s);", wrapQuotes(str)));
        return this;
    }

    @Override // com.anychart.core.Chart
    public NoDataSettings noData() {
        return new NoDataSettings(this.jsBase + ".noData()");
    }

    @Override // com.anychart.core.Chart
    public Bullet noData(String str) {
        APIlib.getInstance().addJSLine(String.format(Locale.US, this.jsBase + ".noData(%s);", wrapQuotes(str)));
        return this;
    }

    @Override // com.anychart.core.Chart
    public Padding padding() {
        return new Padding(this.jsBase + ".padding()");
    }

    @Override // com.anychart.core.Chart
    public Bullet padding(Number[] numberArr) {
        APIlib.getInstance().addJSLine(String.format(Locale.US, this.jsBase + ".padding(%s);", Arrays.toString(numberArr)));
        return this;
    }

    @Override // com.anychart.core.Chart
    public Bullet padding(String[] strArr) {
        APIlib.getInstance().addJSLine(String.format(Locale.US, this.jsBase + ".padding(%s);", arrayToStringWrapQuotes(strArr)));
        return this;
    }

    @Override // com.anychart.core.Chart
    public Bullet padding(String str) {
        APIlib.getInstance().addJSLine(String.format(Locale.US, this.jsBase + ".padding(%s);", wrapQuotes(str)));
        return this;
    }

    @Override // com.anychart.core.Chart
    public Bullet padding(String str, String str2, String str3, String str4) {
        APIlib.getInstance().addJSLine(String.format(Locale.US, this.jsBase + ".padding(%s, %s, %s, %s);", wrapQuotes(str), wrapQuotes(str2), wrapQuotes(str3), wrapQuotes(str4)));
        return this;
    }

    @Override // com.anychart.core.Chart
    public Bullet padding(String str, String str2, String str3, Number number) {
        APIlib.getInstance().addJSLine(String.format(Locale.US, this.jsBase + ".padding(%s, %s, %s, %s);", wrapQuotes(str), wrapQuotes(str2), wrapQuotes(str3), number));
        return this;
    }

    @Override // com.anychart.core.Chart
    public Bullet padding(String str, String str2, Number number, String str3) {
        APIlib.getInstance().addJSLine(String.format(Locale.US, this.jsBase + ".padding(%s, %s, %s, %s);", wrapQuotes(str), wrapQuotes(str2), number, wrapQuotes(str3)));
        return this;
    }

    @Override // com.anychart.core.Chart
    public Bullet padding(String str, String str2, Number number, Number number2) {
        APIlib.getInstance().addJSLine(String.format(Locale.US, this.jsBase + ".padding(%s, %s, %s, %s);", wrapQuotes(str), wrapQuotes(str2), number, number2));
        return this;
    }

    @Override // com.anychart.core.Chart
    public Bullet padding(String str, Number number, String str2, String str3) {
        APIlib.getInstance().addJSLine(String.format(Locale.US, this.jsBase + ".padding(%s, %s, %s, %s);", wrapQuotes(str), number, wrapQuotes(str2), wrapQuotes(str3)));
        return this;
    }

    @Override // com.anychart.core.Chart
    public Bullet padding(String str, Number number, String str2, Number number2) {
        APIlib.getInstance().addJSLine(String.format(Locale.US, this.jsBase + ".padding(%s, %s, %s, %s);", wrapQuotes(str), number, wrapQuotes(str2), number2));
        return this;
    }

    @Override // com.anychart.core.Chart
    public Bullet padding(String str, Number number, Number number2, String str2) {
        APIlib.getInstance().addJSLine(String.format(Locale.US, this.jsBase + ".padding(%s, %s, %s, %s);", wrapQuotes(str), number, number2, wrapQuotes(str2)));
        return this;
    }

    @Override // com.anychart.core.Chart
    public Bullet padding(String str, Number number, Number number2, Number number3) {
        APIlib.getInstance().addJSLine(String.format(Locale.US, this.jsBase + ".padding(%s, %s, %s, %s);", wrapQuotes(str), number, number2, number3));
        return this;
    }

    @Override // com.anychart.core.Chart
    public Bullet padding(Number number, String str, String str2, String str3) {
        APIlib.getInstance().addJSLine(String.format(Locale.US, this.jsBase + ".padding(%s, %s, %s, %s);", number, wrapQuotes(str), wrapQuotes(str2), wrapQuotes(str3)));
        return this;
    }

    @Override // com.anychart.core.Chart
    public Bullet padding(Number number, String str, String str2, Number number2) {
        APIlib.getInstance().addJSLine(String.format(Locale.US, this.jsBase + ".padding(%s, %s, %s, %s);", number, wrapQuotes(str), wrapQuotes(str2), number2));
        return this;
    }

    @Override // com.anychart.core.Chart
    public Bullet padding(Number number, String str, Number number2, String str2) {
        APIlib.getInstance().addJSLine(String.format(Locale.US, this.jsBase + ".padding(%s, %s, %s, %s);", number, wrapQuotes(str), number2, wrapQuotes(str2)));
        return this;
    }

    @Override // com.anychart.core.Chart
    public Bullet padding(Number number, String str, Number number2, Number number3) {
        APIlib.getInstance().addJSLine(String.format(Locale.US, this.jsBase + ".padding(%s, %s, %s, %s);", number, wrapQuotes(str), number2, number3));
        return this;
    }

    @Override // com.anychart.core.Chart
    public Bullet padding(Number number, Number number2, String str, String str2) {
        APIlib.getInstance().addJSLine(String.format(Locale.US, this.jsBase + ".padding(%s, %s, %s, %s);", number, number2, wrapQuotes(str), wrapQuotes(str2)));
        return this;
    }

    @Override // com.anychart.core.Chart
    public Bullet padding(Number number, Number number2, String str, Number number3) {
        APIlib.getInstance().addJSLine(String.format(Locale.US, this.jsBase + ".padding(%s, %s, %s, %s);", number, number2, wrapQuotes(str), number3));
        return this;
    }

    @Override // com.anychart.core.Chart
    public Bullet padding(Number number, Number number2, Number number3, String str) {
        APIlib.getInstance().addJSLine(String.format(Locale.US, this.jsBase + ".padding(%s, %s, %s, %s);", number, number2, number3, wrapQuotes(str)));
        return this;
    }

    @Override // com.anychart.core.Chart
    public Bullet padding(Number number, Number number2, Number number3, Number number4) {
        APIlib.getInstance().addJSLine(String.format(Locale.US, this.jsBase + ".padding(%s, %s, %s, %s);", number, number2, number3, number4));
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

    public Range range(Number number) {
        return new Range(String.format(Locale.US, this.jsBase + ".range(%s)", number));
    }

    public Bullet range(String str) {
        APIlib.getInstance().addJSLine(String.format(Locale.US, this.jsBase + ".range(%s);", wrapQuotes(str)));
        return this;
    }

    public Bullet range(Boolean bool) {
        APIlib.getInstance().addJSLine(String.format(Locale.US, this.jsBase + ".range(%s);", bool));
        return this;
    }

    public Bullet range(Number number, String str) {
        APIlib.getInstance().addJSLine(String.format(Locale.US, this.jsBase + ".range(%s, %s);", number, wrapQuotes(str)));
        return this;
    }

    public Bullet range(Number number, Boolean bool) {
        APIlib.getInstance().addJSLine(String.format(Locale.US, this.jsBase + ".range(%s, %s);", number, bool));
        return this;
    }

    public DistinctColors rangePalette() {
        return new DistinctColors(this.jsBase + ".rangePalette()");
    }

    public Bullet rangePalette(DistinctColors distinctColors) {
        APIlib.getInstance().addJSLine(String.format(Locale.US, this.jsBase + ".rangePalette(%s);", distinctColors != null ? distinctColors.getJsBase() : null));
        return this;
    }

    public Bullet rangePalette(String str) {
        APIlib.getInstance().addJSLine(String.format(Locale.US, this.jsBase + ".rangePalette(%s);", wrapQuotes(str)));
        return this;
    }

    public Bullet rangePalette(String[] strArr) {
        APIlib.getInstance().addJSLine(String.format(Locale.US, this.jsBase + ".rangePalette(%s);", arrayToStringWrapQuotes(strArr)));
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
    public Bullet right(Number number) {
        APIlib.getInstance().addJSLine(String.format(Locale.US, this.jsBase + ".right(%s);", number));
        return this;
    }

    @Override // com.anychart.core.Chart, com.anychart.core.VisualBaseWithBounds
    public Bullet right(String str) {
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

    public Base scale() {
        return new Base(this.jsBase + ".scale()");
    }

    public Bullet scale(Base base) {
        APIlib.getInstance().addJSLine(String.format(Locale.US, this.jsBase + ".scale(%s);", base != null ? base.getJsBase() : null));
        return this;
    }

    public Bullet scale(String str) {
        APIlib.getInstance().addJSLine(String.format(Locale.US, this.jsBase + ".scale(%s);", wrapQuotes(str)));
        return this;
    }

    public Bullet scale(ScaleTypes scaleTypes) {
        APIlib.getInstance().addJSLine(String.format(Locale.US, this.jsBase + ".scale(%s);", scaleTypes != null ? scaleTypes.getJsBase() : null));
        return this;
    }

    @Override // com.anychart.core.Chart
    public void selectMarqueeFill() {
        APIlib.getInstance().addJSLine(this.jsBase + ".selectMarqueeFill();");
    }

    @Override // com.anychart.core.Chart
    public Bullet selectMarqueeFill(Fill fill) {
        APIlib.getInstance().addJSLine(String.format(Locale.US, this.jsBase + ".selectMarqueeFill(%s);", fill != null ? fill.getJsBase() : null));
        return this;
    }

    @Override // com.anychart.core.Chart
    public Bullet selectMarqueeFill(GradientKey gradientKey) {
        APIlib.getInstance().addJSLine(String.format(Locale.US, this.jsBase + ".selectMarqueeFill(%s);", gradientKey != null ? gradientKey.getJsBase() : null));
        return this;
    }

    @Override // com.anychart.core.Chart
    public Bullet selectMarqueeFill(String[] strArr) {
        APIlib.getInstance().addJSLine(String.format(Locale.US, this.jsBase + ".selectMarqueeFill(%s);", arrayToStringWrapQuotes(strArr)));
        return this;
    }

    @Override // com.anychart.core.Chart
    public Bullet selectMarqueeFill(String str, Number number) {
        APIlib.getInstance().addJSLine(String.format(Locale.US, this.jsBase + ".selectMarqueeFill(%s, %s);", wrapQuotes(str), number));
        return this;
    }

    @Override // com.anychart.core.Chart
    public Bullet selectMarqueeFill(GradientKey gradientKey, Number number, Boolean bool, Number number2) {
        APIlib.getInstance().addJSLine(String.format(Locale.US, this.jsBase + ".selectMarqueeFill(%s, %s, %s, %s);", gradientKey != null ? gradientKey.getJsBase() : null, number, bool, number2));
        return this;
    }

    @Override // com.anychart.core.Chart
    public Bullet selectMarqueeFill(GradientKey gradientKey, Number number, com.anychart.graphics.vector.Rect rect, Number number2) {
        APIlib.getInstance().addJSLine(String.format(Locale.US, this.jsBase + ".selectMarqueeFill(%s, %s, %s, %s);", gradientKey != null ? gradientKey.getJsBase() : null, number, rect != null ? rect.getJsBase() : null, number2));
        return this;
    }

    @Override // com.anychart.core.Chart
    public Bullet selectMarqueeFill(GradientKey gradientKey, Number number, String str, Number number2) {
        APIlib.getInstance().addJSLine(String.format(Locale.US, this.jsBase + ".selectMarqueeFill(%s, %s, %s, %s);", gradientKey != null ? gradientKey.getJsBase() : null, number, wrapQuotes(str), number2));
        return this;
    }

    @Override // com.anychart.core.Chart
    public Bullet selectMarqueeFill(String[] strArr, Number number, Boolean bool, Number number2) {
        APIlib.getInstance().addJSLine(String.format(Locale.US, this.jsBase + ".selectMarqueeFill(%s, %s, %s, %s);", arrayToStringWrapQuotes(strArr), number, bool, number2));
        return this;
    }

    @Override // com.anychart.core.Chart
    public Bullet selectMarqueeFill(String[] strArr, Number number, com.anychart.graphics.vector.Rect rect, Number number2) {
        APIlib.getInstance().addJSLine(String.format(Locale.US, this.jsBase + ".selectMarqueeFill(%s, %s, %s, %s);", arrayToStringWrapQuotes(strArr), number, rect != null ? rect.getJsBase() : null, number2));
        return this;
    }

    @Override // com.anychart.core.Chart
    public Bullet selectMarqueeFill(String[] strArr, Number number, String str, Number number2) {
        APIlib.getInstance().addJSLine(String.format(Locale.US, this.jsBase + ".selectMarqueeFill(%s, %s, %s, %s);", arrayToStringWrapQuotes(strArr), number, wrapQuotes(str), number2));
        return this;
    }

    @Override // com.anychart.core.Chart
    public Bullet selectMarqueeFill(GradientKey gradientKey, Number number, Number number2, com.anychart.graphics.math.Rect rect, Number number3, Number number4, Number number5) {
        APIlib.getInstance().addJSLine(String.format(Locale.US, this.jsBase + ".selectMarqueeFill(%s, %s, %s, %s, %s, %s, %s);", gradientKey != null ? gradientKey.getJsBase() : null, number, number2, rect != null ? rect.getJsBase() : null, number3, number4, number5));
        return this;
    }

    @Override // com.anychart.core.Chart
    public Bullet selectMarqueeFill(String[] strArr, Number number, Number number2, com.anychart.graphics.math.Rect rect, Number number3, Number number4, Number number5) {
        APIlib.getInstance().addJSLine(String.format(Locale.US, this.jsBase + ".selectMarqueeFill(%s, %s, %s, %s, %s, %s, %s);", arrayToStringWrapQuotes(strArr), number, number2, rect != null ? rect.getJsBase() : null, number3, number4, number5));
        return this;
    }

    @Override // com.anychart.core.Chart
    public void selectMarqueeStroke() {
        APIlib.getInstance().addJSLine(this.jsBase + ".selectMarqueeStroke();");
    }

    @Override // com.anychart.core.Chart
    public Bullet selectMarqueeStroke(Stroke stroke, Number number, String str, String str2, String str3) {
        APIlib.getInstance().addJSLine(String.format(Locale.US, this.jsBase + ".selectMarqueeStroke(%s, %s, %s, %s, %s);", stroke != null ? stroke.getJsBase() : null, number, wrapQuotes(str), wrapQuotes(str2), wrapQuotes(str3)));
        return this;
    }

    @Override // com.anychart.core.Chart
    public Bullet selectMarqueeStroke(Stroke stroke, Number number, String str, String str2, StrokeLineCap strokeLineCap) {
        APIlib.getInstance().addJSLine(String.format(Locale.US, this.jsBase + ".selectMarqueeStroke(%s, %s, %s, %s, %s);", stroke != null ? stroke.getJsBase() : null, number, wrapQuotes(str), wrapQuotes(str2), strokeLineCap != null ? strokeLineCap.getJsBase() : null));
        return this;
    }

    @Override // com.anychart.core.Chart
    public Bullet selectMarqueeStroke(Stroke stroke, Number number, String str, StrokeLineJoin strokeLineJoin, String str2) {
        APIlib.getInstance().addJSLine(String.format(Locale.US, this.jsBase + ".selectMarqueeStroke(%s, %s, %s, %s, %s);", stroke != null ? stroke.getJsBase() : null, number, wrapQuotes(str), strokeLineJoin != null ? strokeLineJoin.getJsBase() : null, wrapQuotes(str2)));
        return this;
    }

    @Override // com.anychart.core.Chart
    public Bullet selectMarqueeStroke(Stroke stroke, Number number, String str, StrokeLineJoin strokeLineJoin, StrokeLineCap strokeLineCap) {
        APIlib.getInstance().addJSLine(String.format(Locale.US, this.jsBase + ".selectMarqueeStroke(%s, %s, %s, %s, %s);", stroke != null ? stroke.getJsBase() : null, number, wrapQuotes(str), strokeLineJoin != null ? strokeLineJoin.getJsBase() : null, strokeLineCap != null ? strokeLineCap.getJsBase() : null));
        return this;
    }

    @Override // com.anychart.core.Chart
    public Bullet selectMarqueeStroke(ColoredFill coloredFill, Number number, String str, String str2, String str3) {
        APIlib.getInstance().addJSLine(String.format(Locale.US, this.jsBase + ".selectMarqueeStroke(%s, %s, %s, %s, %s);", coloredFill != null ? coloredFill.getJsBase() : null, number, wrapQuotes(str), wrapQuotes(str2), wrapQuotes(str3)));
        return this;
    }

    @Override // com.anychart.core.Chart
    public Bullet selectMarqueeStroke(ColoredFill coloredFill, Number number, String str, String str2, StrokeLineCap strokeLineCap) {
        APIlib.getInstance().addJSLine(String.format(Locale.US, this.jsBase + ".selectMarqueeStroke(%s, %s, %s, %s, %s);", coloredFill != null ? coloredFill.getJsBase() : null, number, wrapQuotes(str), wrapQuotes(str2), strokeLineCap != null ? strokeLineCap.getJsBase() : null));
        return this;
    }

    @Override // com.anychart.core.Chart
    public Bullet selectMarqueeStroke(ColoredFill coloredFill, Number number, String str, StrokeLineJoin strokeLineJoin, String str2) {
        APIlib.getInstance().addJSLine(String.format(Locale.US, this.jsBase + ".selectMarqueeStroke(%s, %s, %s, %s, %s);", coloredFill != null ? coloredFill.getJsBase() : null, number, wrapQuotes(str), strokeLineJoin != null ? strokeLineJoin.getJsBase() : null, wrapQuotes(str2)));
        return this;
    }

    @Override // com.anychart.core.Chart
    public Bullet selectMarqueeStroke(ColoredFill coloredFill, Number number, String str, StrokeLineJoin strokeLineJoin, StrokeLineCap strokeLineCap) {
        APIlib.getInstance().addJSLine(String.format(Locale.US, this.jsBase + ".selectMarqueeStroke(%s, %s, %s, %s, %s);", coloredFill != null ? coloredFill.getJsBase() : null, number, wrapQuotes(str), strokeLineJoin != null ? strokeLineJoin.getJsBase() : null, strokeLineCap != null ? strokeLineCap.getJsBase() : null));
        return this;
    }

    @Override // com.anychart.core.Chart
    public Bullet selectMarqueeStroke(String str, Number number, String str2, String str3, String str4) {
        APIlib.getInstance().addJSLine(String.format(Locale.US, this.jsBase + ".selectMarqueeStroke(%s, %s, %s, %s, %s);", wrapQuotes(str), number, wrapQuotes(str2), wrapQuotes(str3), wrapQuotes(str4)));
        return this;
    }

    @Override // com.anychart.core.Chart
    public Bullet selectMarqueeStroke(String str, Number number, String str2, String str3, StrokeLineCap strokeLineCap) {
        APIlib.getInstance().addJSLine(String.format(Locale.US, this.jsBase + ".selectMarqueeStroke(%s, %s, %s, %s, %s);", wrapQuotes(str), number, wrapQuotes(str2), wrapQuotes(str3), strokeLineCap != null ? strokeLineCap.getJsBase() : null));
        return this;
    }

    @Override // com.anychart.core.Chart
    public Bullet selectMarqueeStroke(String str, Number number, String str2, StrokeLineJoin strokeLineJoin, String str3) {
        APIlib.getInstance().addJSLine(String.format(Locale.US, this.jsBase + ".selectMarqueeStroke(%s, %s, %s, %s, %s);", wrapQuotes(str), number, wrapQuotes(str2), strokeLineJoin != null ? strokeLineJoin.getJsBase() : null, wrapQuotes(str3)));
        return this;
    }

    @Override // com.anychart.core.Chart
    public Bullet selectMarqueeStroke(String str, Number number, String str2, StrokeLineJoin strokeLineJoin, StrokeLineCap strokeLineCap) {
        APIlib.getInstance().addJSLine(String.format(Locale.US, this.jsBase + ".selectMarqueeStroke(%s, %s, %s, %s, %s);", wrapQuotes(str), number, wrapQuotes(str2), strokeLineJoin != null ? strokeLineJoin.getJsBase() : null, strokeLineCap != null ? strokeLineCap.getJsBase() : null));
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
    public Bullet startSelectMarquee(Boolean bool) {
        APIlib.getInstance().addJSLine(String.format(Locale.US, this.jsBase + ".startSelectMarquee(%s);", bool));
        return this;
    }

    @Override // com.anychart.core.Chart
    public Title title() {
        return new Title(this.jsBase + ".title()");
    }

    @Override // com.anychart.core.Chart
    public Bullet title(Boolean bool) {
        APIlib.getInstance().addJSLine(String.format(Locale.US, this.jsBase + ".title(%s);", bool));
        return this;
    }

    @Override // com.anychart.core.Chart
    public Bullet title(String str) {
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
    public Bullet tooltip(String str) {
        APIlib.getInstance().addJSLine(String.format(Locale.US, this.jsBase + ".tooltip(%s);", wrapQuotes(str)));
        return this;
    }

    @Override // com.anychart.core.Chart
    public Bullet tooltip(Boolean bool) {
        APIlib.getInstance().addJSLine(String.format(Locale.US, this.jsBase + ".tooltip(%s);", bool));
        return this;
    }

    @Override // com.anychart.core.Chart, com.anychart.core.VisualBaseWithBounds
    public void top() {
        APIlib.getInstance().addJSLine(this.jsBase + ".top();");
    }

    @Override // com.anychart.core.Chart, com.anychart.core.VisualBaseWithBounds
    public Bullet top(Number number) {
        APIlib.getInstance().addJSLine(String.format(Locale.US, this.jsBase + ".top(%s);", number));
        return this;
    }

    @Override // com.anychart.core.Chart, com.anychart.core.VisualBaseWithBounds
    public Bullet top(String str) {
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
    public Bullet width(Number number) {
        APIlib.getInstance().addJSLine(String.format(Locale.US, this.jsBase + ".width(%s);", number));
        return this;
    }

    @Override // com.anychart.core.Chart, com.anychart.core.VisualBaseWithBounds
    public Bullet width(String str) {
        APIlib.getInstance().addJSLine(String.format(Locale.US, this.jsBase + ".width(%s);", wrapQuotes(str)));
        return this;
    }

    @Override // com.anychart.core.Chart, com.anychart.core.VisualBaseWithBounds, com.anychart.core.VisualBase
    public void zIndex() {
        APIlib.getInstance().addJSLine(this.jsBase + ".zIndex();");
    }

    @Override // com.anychart.core.Chart, com.anychart.core.VisualBaseWithBounds, com.anychart.core.VisualBase
    public Bullet zIndex(Number number) {
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
    public Bullet parentBounds(Rect rect) {
        APIlib.getInstance().addJSLine(String.format(Locale.US, this.jsBase + ".parentBounds(%s);", rect != null ? rect.getJsBase() : null));
        return this;
    }

    @Override // com.anychart.core.Chart, com.anychart.core.VisualBaseWithBounds, com.anychart.core.VisualBase
    public Bullet parentBounds(String str) {
        APIlib.getInstance().addJSLine(String.format(Locale.US, this.jsBase + ".parentBounds(%s);", wrapQuotes(str)));
        return this;
    }

    @Override // com.anychart.core.Chart, com.anychart.core.VisualBaseWithBounds, com.anychart.core.VisualBase
    public Bullet parentBounds(Number number) {
        APIlib.getInstance().addJSLine(String.format(Locale.US, this.jsBase + ".parentBounds(%s);", number));
        return this;
    }

    @Override // com.anychart.core.Chart, com.anychart.core.VisualBaseWithBounds, com.anychart.core.VisualBase
    public Bullet parentBounds(Number number, Number number2, Number number3, Number number4) {
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
}
