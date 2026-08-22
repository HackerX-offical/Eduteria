package com.anychart.core.axes;

import com.amazonaws.services.s3.model.InstructionFileId;
import com.anychart.APIlib;
import com.anychart.chart.common.listener.ListenersInterface;
import com.anychart.core.VisualBase;
import com.anychart.core.ui.LabelsFactory;
import com.anychart.core.ui.Title;
import com.anychart.enums.LabelsOverlapMode;
import com.anychart.enums.Orientation;
import com.anychart.enums.ScaleTypes;
import com.anychart.graphics.vector.ColoredFill;
import com.anychart.graphics.vector.Layer;
import com.anychart.graphics.vector.PaperSize;
import com.anychart.graphics.vector.Stage;
import com.anychart.graphics.vector.Stroke;
import com.anychart.graphics.vector.StrokeLineCap;
import com.anychart.graphics.vector.StrokeLineJoin;
import com.anychart.math.Rect;
import com.anychart.scales.Base;
import java.util.Locale;

/* JADX INFO: loaded from: classes5.dex */
public class Linear extends VisualBase {
    protected Linear() {
    }

    public static Linear instantiate() {
        return new Linear("new anychart.core.axes.linear()");
    }

    public Linear(String str) {
        StringBuilder sb = new StringBuilder("linear");
        int i = variableIndex + 1;
        variableIndex = i;
        this.jsBase = sb.append(i).toString();
        APIlib.getInstance().addJSLine(this.jsBase + " = " + str + ";");
    }

    @Override // com.anychart.core.VisualBase, com.anychart.core.Base, com.anychart.JsObject
    public String getJsBase() {
        return this.jsBase;
    }

    public void drawFirstLabel() {
        APIlib.getInstance().addJSLine(this.jsBase + ".drawFirstLabel();");
    }

    public Linear drawFirstLabel(Boolean bool) {
        APIlib.getInstance().addJSLine(String.format(Locale.US, this.jsBase + ".drawFirstLabel(%s);", bool));
        return this;
    }

    public void drawLastLabel() {
        APIlib.getInstance().addJSLine(this.jsBase + ".drawLastLabel();");
    }

    public Linear drawLastLabel(Boolean bool) {
        APIlib.getInstance().addJSLine(String.format(Locale.US, this.jsBase + ".drawLastLabel(%s);", bool));
        return this;
    }

    @Override // com.anychart.core.VisualBase
    public void enabled() {
        APIlib.getInstance().addJSLine(this.jsBase + ".enabled();");
    }

    @Override // com.anychart.core.VisualBase
    public Linear enabled(Boolean bool) {
        APIlib.getInstance().addJSLine(String.format(Locale.US, this.jsBase + ".enabled(%s);", bool));
        return this;
    }

    public Rect getPixelBounds() {
        return new Rect(this.jsBase + ".getPixelBounds()");
    }

    public Rect getRemainingBounds() {
        return new Rect(this.jsBase + ".getRemainingBounds()");
    }

    public void isHorizontal() {
        APIlib.getInstance().addJSLine(this.jsBase + ".isHorizontal();");
    }

    public LabelsFactory labels() {
        return new LabelsFactory(this.jsBase + ".labels()");
    }

    public Linear labels(String str) {
        APIlib.getInstance().addJSLine(String.format(Locale.US, this.jsBase + ".labels(%s);", wrapQuotes(str)));
        return this;
    }

    public Linear labels(Boolean bool) {
        APIlib.getInstance().addJSLine(String.format(Locale.US, this.jsBase + ".labels(%s);", bool));
        return this;
    }

    public LabelsFactory minorLabels() {
        return new LabelsFactory(this.jsBase + ".minorLabels()");
    }

    public Linear minorLabels(String str) {
        APIlib.getInstance().addJSLine(String.format(Locale.US, this.jsBase + ".minorLabels(%s);", wrapQuotes(str)));
        return this;
    }

    public Linear minorLabels(Boolean bool) {
        APIlib.getInstance().addJSLine(String.format(Locale.US, this.jsBase + ".minorLabels(%s);", bool));
        return this;
    }

    public Ticks minorTicks() {
        return new Ticks(this.jsBase + ".minorTicks()");
    }

    public Linear minorTicks(String str) {
        APIlib.getInstance().addJSLine(String.format(Locale.US, this.jsBase + ".minorTicks(%s);", wrapQuotes(str)));
        return this;
    }

    public Linear minorTicks(Boolean bool) {
        APIlib.getInstance().addJSLine(String.format(Locale.US, this.jsBase + ".minorTicks(%s);", bool));
        return this;
    }

    public void orientation() {
        APIlib.getInstance().addJSLine(this.jsBase + ".orientation();");
    }

    public Linear orientation(Orientation orientation) {
        APIlib.getInstance().addJSLine(String.format(Locale.US, this.jsBase + ".orientation(%s);", orientation != null ? orientation.getJsBase() : null));
        return this;
    }

    public Linear orientation(String str) {
        APIlib.getInstance().addJSLine(String.format(Locale.US, this.jsBase + ".orientation(%s);", wrapQuotes(str)));
        return this;
    }

    public void overlapMode() {
        APIlib.getInstance().addJSLine(this.jsBase + ".overlapMode();");
    }

    public Linear overlapMode(LabelsOverlapMode labelsOverlapMode) {
        APIlib.getInstance().addJSLine(String.format(Locale.US, this.jsBase + ".overlapMode(%s);", labelsOverlapMode != null ? labelsOverlapMode.getJsBase() : null));
        return this;
    }

    public Linear overlapMode(String str) {
        APIlib.getInstance().addJSLine(String.format(Locale.US, this.jsBase + ".overlapMode(%s);", wrapQuotes(str)));
        return this;
    }

    @Override // com.anychart.core.VisualBase
    public void print(PaperSize paperSize, Boolean bool) {
        APIlib.getInstance().addJSLine(String.format(Locale.US, this.jsBase + ".print(%s, %s);", paperSize != null ? paperSize.getJsBase() : null, bool));
    }

    @Override // com.anychart.core.VisualBase
    public void print(String str, Boolean bool) {
        APIlib.getInstance().addJSLine(String.format(Locale.US, this.jsBase + ".print(%s, %s);", wrapQuotes(str), bool));
    }

    @Override // com.anychart.core.VisualBase, com.anychart.core.Base
    public void removeAllListeners(String str) {
        APIlib.getInstance().addJSLine(String.format(Locale.US, this.jsBase + ".removeAllListeners(%s);", wrapQuotes(str)));
    }

    public Base scale() {
        return new Base(this.jsBase + ".scale()");
    }

    public Linear scale(Base base) {
        APIlib.getInstance().addJSLine(String.format(Locale.US, this.jsBase + ".scale(%s);", base != null ? base.getJsBase() : null));
        return this;
    }

    public Linear scale(String str) {
        APIlib.getInstance().addJSLine(String.format(Locale.US, this.jsBase + ".scale(%s);", wrapQuotes(str)));
        return this;
    }

    public Linear scale(ScaleTypes scaleTypes) {
        APIlib.getInstance().addJSLine(String.format(Locale.US, this.jsBase + ".scale(%s);", scaleTypes != null ? scaleTypes.getJsBase() : null));
        return this;
    }

    public void staggerLines() {
        APIlib.getInstance().addJSLine(this.jsBase + ".staggerLines();");
    }

    public Linear staggerLines(Number number) {
        APIlib.getInstance().addJSLine(String.format(Locale.US, this.jsBase + ".staggerLines(%s);", number));
        return this;
    }

    public void staggerMaxLines() {
        APIlib.getInstance().addJSLine(this.jsBase + ".staggerMaxLines();");
    }

    public Linear staggerMaxLines(Number number) {
        APIlib.getInstance().addJSLine(String.format(Locale.US, this.jsBase + ".staggerMaxLines(%s);", number));
        return this;
    }

    public void staggerMode() {
        APIlib.getInstance().addJSLine(this.jsBase + ".staggerMode();");
    }

    public Linear staggerMode(Boolean bool) {
        APIlib.getInstance().addJSLine(String.format(Locale.US, this.jsBase + ".staggerMode(%s);", bool));
        return this;
    }

    public void stroke() {
        APIlib.getInstance().addJSLine(this.jsBase + ".stroke();");
    }

    public Linear stroke(Stroke stroke, Number number, String str, String str2, String str3) {
        APIlib.getInstance().addJSLine(String.format(Locale.US, this.jsBase + ".stroke(%s, %s, %s, %s, %s);", stroke != null ? stroke.getJsBase() : null, number, wrapQuotes(str), wrapQuotes(str2), wrapQuotes(str3)));
        return this;
    }

    public Linear stroke(Stroke stroke, Number number, String str, String str2, StrokeLineCap strokeLineCap) {
        APIlib.getInstance().addJSLine(String.format(Locale.US, this.jsBase + ".stroke(%s, %s, %s, %s, %s);", stroke != null ? stroke.getJsBase() : null, number, wrapQuotes(str), wrapQuotes(str2), strokeLineCap != null ? strokeLineCap.getJsBase() : null));
        return this;
    }

    public Linear stroke(Stroke stroke, Number number, String str, StrokeLineJoin strokeLineJoin, String str2) {
        APIlib.getInstance().addJSLine(String.format(Locale.US, this.jsBase + ".stroke(%s, %s, %s, %s, %s);", stroke != null ? stroke.getJsBase() : null, number, wrapQuotes(str), strokeLineJoin != null ? strokeLineJoin.getJsBase() : null, wrapQuotes(str2)));
        return this;
    }

    public Linear stroke(Stroke stroke, Number number, String str, StrokeLineJoin strokeLineJoin, StrokeLineCap strokeLineCap) {
        APIlib.getInstance().addJSLine(String.format(Locale.US, this.jsBase + ".stroke(%s, %s, %s, %s, %s);", stroke != null ? stroke.getJsBase() : null, number, wrapQuotes(str), strokeLineJoin != null ? strokeLineJoin.getJsBase() : null, strokeLineCap != null ? strokeLineCap.getJsBase() : null));
        return this;
    }

    public Linear stroke(ColoredFill coloredFill, Number number, String str, String str2, String str3) {
        APIlib.getInstance().addJSLine(String.format(Locale.US, this.jsBase + ".stroke(%s, %s, %s, %s, %s);", coloredFill != null ? coloredFill.getJsBase() : null, number, wrapQuotes(str), wrapQuotes(str2), wrapQuotes(str3)));
        return this;
    }

    public Linear stroke(ColoredFill coloredFill, Number number, String str, String str2, StrokeLineCap strokeLineCap) {
        APIlib.getInstance().addJSLine(String.format(Locale.US, this.jsBase + ".stroke(%s, %s, %s, %s, %s);", coloredFill != null ? coloredFill.getJsBase() : null, number, wrapQuotes(str), wrapQuotes(str2), strokeLineCap != null ? strokeLineCap.getJsBase() : null));
        return this;
    }

    public Linear stroke(ColoredFill coloredFill, Number number, String str, StrokeLineJoin strokeLineJoin, String str2) {
        APIlib.getInstance().addJSLine(String.format(Locale.US, this.jsBase + ".stroke(%s, %s, %s, %s, %s);", coloredFill != null ? coloredFill.getJsBase() : null, number, wrapQuotes(str), strokeLineJoin != null ? strokeLineJoin.getJsBase() : null, wrapQuotes(str2)));
        return this;
    }

    public Linear stroke(ColoredFill coloredFill, Number number, String str, StrokeLineJoin strokeLineJoin, StrokeLineCap strokeLineCap) {
        APIlib.getInstance().addJSLine(String.format(Locale.US, this.jsBase + ".stroke(%s, %s, %s, %s, %s);", coloredFill != null ? coloredFill.getJsBase() : null, number, wrapQuotes(str), strokeLineJoin != null ? strokeLineJoin.getJsBase() : null, strokeLineCap != null ? strokeLineCap.getJsBase() : null));
        return this;
    }

    public Linear stroke(String str, Number number, String str2, String str3, String str4) {
        APIlib.getInstance().addJSLine(String.format(Locale.US, this.jsBase + ".stroke(%s, %s, %s, %s, %s);", wrapQuotes(str), number, wrapQuotes(str2), wrapQuotes(str3), wrapQuotes(str4)));
        return this;
    }

    public Linear stroke(String str, Number number, String str2, String str3, StrokeLineCap strokeLineCap) {
        APIlib.getInstance().addJSLine(String.format(Locale.US, this.jsBase + ".stroke(%s, %s, %s, %s, %s);", wrapQuotes(str), number, wrapQuotes(str2), wrapQuotes(str3), strokeLineCap != null ? strokeLineCap.getJsBase() : null));
        return this;
    }

    public Linear stroke(String str, Number number, String str2, StrokeLineJoin strokeLineJoin, String str3) {
        APIlib.getInstance().addJSLine(String.format(Locale.US, this.jsBase + ".stroke(%s, %s, %s, %s, %s);", wrapQuotes(str), number, wrapQuotes(str2), strokeLineJoin != null ? strokeLineJoin.getJsBase() : null, wrapQuotes(str3)));
        return this;
    }

    public Linear stroke(String str, Number number, String str2, StrokeLineJoin strokeLineJoin, StrokeLineCap strokeLineCap) {
        APIlib.getInstance().addJSLine(String.format(Locale.US, this.jsBase + ".stroke(%s, %s, %s, %s, %s);", wrapQuotes(str), number, wrapQuotes(str2), strokeLineJoin != null ? strokeLineJoin.getJsBase() : null, strokeLineCap != null ? strokeLineCap.getJsBase() : null));
        return this;
    }

    public Linear stroke(String str) {
        APIlib.getInstance().addJSLine(String.format(Locale.US, this.jsBase + ".stroke(%s);", wrapQuotes(str)));
        return this;
    }

    public Ticks ticks() {
        return new Ticks(this.jsBase + ".ticks()");
    }

    public Linear ticks(String str) {
        APIlib.getInstance().addJSLine(String.format(Locale.US, this.jsBase + ".ticks(%s);", wrapQuotes(str)));
        return this;
    }

    public Linear ticks(Boolean bool) {
        APIlib.getInstance().addJSLine(String.format(Locale.US, this.jsBase + ".ticks(%s);", bool));
        return this;
    }

    public Title title() {
        return new Title(this.jsBase + ".title()");
    }

    public Linear title(Boolean bool) {
        APIlib.getInstance().addJSLine(String.format(Locale.US, this.jsBase + ".title(%s);", bool));
        return this;
    }

    public Linear title(String str) {
        APIlib.getInstance().addJSLine(String.format(Locale.US, this.jsBase + ".title(%s);", wrapQuotes(str)));
        return this;
    }

    @Override // com.anychart.core.VisualBase, com.anychart.core.Base
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

    @Override // com.anychart.core.VisualBase, com.anychart.core.Base
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

    @Override // com.anychart.core.VisualBase, com.anychart.core.Base
    public void unlistenByKey(String str) {
        APIlib.getInstance().addJSLine(String.format(Locale.US, this.jsBase + ".unlistenByKey(%s);", wrapQuotes(str)));
    }

    public void width() {
        APIlib.getInstance().addJSLine(this.jsBase + ".width();");
    }

    public Linear width(Number number) {
        APIlib.getInstance().addJSLine(String.format(Locale.US, this.jsBase + ".width(%s);", number));
        return this;
    }

    public Linear width(String str) {
        APIlib.getInstance().addJSLine(String.format(Locale.US, this.jsBase + ".width(%s);", wrapQuotes(str)));
        return this;
    }

    @Override // com.anychart.core.VisualBase
    public void zIndex() {
        APIlib.getInstance().addJSLine(this.jsBase + ".zIndex();");
    }

    @Override // com.anychart.core.VisualBase
    public Linear zIndex(Number number) {
        APIlib.getInstance().addJSLine(String.format(Locale.US, this.jsBase + ".zIndex(%s);", number));
        return this;
    }

    @Override // com.anychart.core.VisualBase
    public Layer container() {
        return new Layer(this.jsBase + ".container()");
    }

    @Override // com.anychart.core.VisualBase
    public Linear container(Layer layer) {
        APIlib.getInstance().addJSLine(String.format(Locale.US, this.jsBase + ".container(%s);", layer != null ? layer.getJsBase() : null));
        return this;
    }

    @Override // com.anychart.core.VisualBase
    public Linear container(Stage stage) {
        APIlib.getInstance().addJSLine(String.format(Locale.US, this.jsBase + ".container(%s);", stage != null ? stage.getJsBase() : null));
        return this;
    }

    @Override // com.anychart.core.VisualBase
    public Linear container(String str) {
        APIlib.getInstance().addJSLine(String.format(Locale.US, this.jsBase + ".container(%s);", wrapQuotes(str)));
        return this;
    }

    @Override // com.anychart.core.VisualBase
    public Rect parentBounds() {
        return new Rect(this.jsBase + ".parentBounds()");
    }

    @Override // com.anychart.core.VisualBase
    public Linear parentBounds(Rect rect) {
        APIlib.getInstance().addJSLine(String.format(Locale.US, this.jsBase + ".parentBounds(%s);", rect != null ? rect.getJsBase() : null));
        return this;
    }

    @Override // com.anychart.core.VisualBase
    public Linear parentBounds(String str) {
        APIlib.getInstance().addJSLine(String.format(Locale.US, this.jsBase + ".parentBounds(%s);", wrapQuotes(str)));
        return this;
    }

    @Override // com.anychart.core.VisualBase
    public Linear parentBounds(Number number) {
        APIlib.getInstance().addJSLine(String.format(Locale.US, this.jsBase + ".parentBounds(%s);", number));
        return this;
    }

    @Override // com.anychart.core.VisualBase
    public Linear parentBounds(Number number, Number number2, Number number3, Number number4) {
        APIlib.getInstance().addJSLine(String.format(Locale.US, this.jsBase + ".parentBounds(%s, %s, %s, %s);", number, number2, number3, number4));
        return this;
    }
}
