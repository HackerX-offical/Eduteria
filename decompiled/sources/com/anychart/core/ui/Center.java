package com.anychart.core.ui;

import com.amazonaws.services.s3.model.InstructionFileId;
import com.anychart.APIlib;
import com.anychart.chart.common.listener.ListenersInterface;
import com.anychart.core.Base;
import com.anychart.core.VisualBase;
import com.anychart.graphics.vector.ColoredFill;
import com.anychart.graphics.vector.Element;
import com.anychart.graphics.vector.Fill;
import com.anychart.graphics.vector.GradientKey;
import com.anychart.graphics.vector.Rect;
import com.anychart.graphics.vector.Stroke;
import com.anychart.graphics.vector.StrokeLineCap;
import com.anychart.graphics.vector.StrokeLineJoin;
import java.util.Locale;

/* JADX INFO: loaded from: classes5.dex */
public class Center extends Base {
    protected Center() {
    }

    public static Center instantiate() {
        return new Center("new anychart.core.ui.center()");
    }

    public Center(String str) {
        StringBuilder sb = new StringBuilder("center");
        int i = variableIndex + 1;
        variableIndex = i;
        this.jsBase = sb.append(i).toString();
        APIlib.getInstance().addJSLine(this.jsBase + " = " + str + ";");
    }

    @Override // com.anychart.core.Base, com.anychart.JsObject
    public String getJsBase() {
        return this.jsBase;
    }

    public Element content() {
        return new Element(this.jsBase + ".content()");
    }

    public Center content(Element element) {
        APIlib.getInstance().addJSLine(String.format(Locale.US, this.jsBase + ".content(%s);", element != null ? element.getJsBase() : null));
        return this;
    }

    public Center content(VisualBase visualBase) {
        APIlib.getInstance().addJSLine(String.format(Locale.US, this.jsBase + ".content(%s);", visualBase != null ? visualBase.getJsBase() : null));
        return this;
    }

    public Center content(String str) {
        APIlib.getInstance().addJSLine(String.format(Locale.US, this.jsBase + ".content(%s);", wrapQuotes(str)));
        return this;
    }

    public void fill() {
        APIlib.getInstance().addJSLine(this.jsBase + ".fill();");
    }

    public Center fill(Fill fill) {
        APIlib.getInstance().addJSLine(String.format(Locale.US, this.jsBase + ".fill(%s);", fill != null ? fill.getJsBase() : null));
        return this;
    }

    public Center fill(GradientKey gradientKey) {
        APIlib.getInstance().addJSLine(String.format(Locale.US, this.jsBase + ".fill(%s);", gradientKey != null ? gradientKey.getJsBase() : null));
        return this;
    }

    public Center fill(String[] strArr) {
        APIlib.getInstance().addJSLine(String.format(Locale.US, this.jsBase + ".fill(%s);", arrayToStringWrapQuotes(strArr)));
        return this;
    }

    public Center fill(String str, Number number) {
        APIlib.getInstance().addJSLine(String.format(Locale.US, this.jsBase + ".fill(%s, %s);", wrapQuotes(str), number));
        return this;
    }

    public Center fill(GradientKey gradientKey, Number number, Boolean bool, Number number2) {
        APIlib.getInstance().addJSLine(String.format(Locale.US, this.jsBase + ".fill(%s, %s, %s, %s);", gradientKey != null ? gradientKey.getJsBase() : null, number, bool, number2));
        return this;
    }

    public Center fill(GradientKey gradientKey, Number number, Rect rect, Number number2) {
        APIlib.getInstance().addJSLine(String.format(Locale.US, this.jsBase + ".fill(%s, %s, %s, %s);", gradientKey != null ? gradientKey.getJsBase() : null, number, rect != null ? rect.getJsBase() : null, number2));
        return this;
    }

    public Center fill(GradientKey gradientKey, Number number, String str, Number number2) {
        APIlib.getInstance().addJSLine(String.format(Locale.US, this.jsBase + ".fill(%s, %s, %s, %s);", gradientKey != null ? gradientKey.getJsBase() : null, number, wrapQuotes(str), number2));
        return this;
    }

    public Center fill(String[] strArr, Number number, Boolean bool, Number number2) {
        APIlib.getInstance().addJSLine(String.format(Locale.US, this.jsBase + ".fill(%s, %s, %s, %s);", arrayToStringWrapQuotes(strArr), number, bool, number2));
        return this;
    }

    public Center fill(String[] strArr, Number number, Rect rect, Number number2) {
        APIlib.getInstance().addJSLine(String.format(Locale.US, this.jsBase + ".fill(%s, %s, %s, %s);", arrayToStringWrapQuotes(strArr), number, rect != null ? rect.getJsBase() : null, number2));
        return this;
    }

    public Center fill(String[] strArr, Number number, String str, Number number2) {
        APIlib.getInstance().addJSLine(String.format(Locale.US, this.jsBase + ".fill(%s, %s, %s, %s);", arrayToStringWrapQuotes(strArr), number, wrapQuotes(str), number2));
        return this;
    }

    public Center fill(GradientKey gradientKey, Number number, Number number2, com.anychart.graphics.math.Rect rect, Number number3, Number number4, Number number5) {
        APIlib.getInstance().addJSLine(String.format(Locale.US, this.jsBase + ".fill(%s, %s, %s, %s, %s, %s, %s);", gradientKey != null ? gradientKey.getJsBase() : null, number, number2, rect != null ? rect.getJsBase() : null, number3, number4, number5));
        return this;
    }

    public Center fill(String[] strArr, Number number, Number number2, com.anychart.graphics.math.Rect rect, Number number3, Number number4, Number number5) {
        APIlib.getInstance().addJSLine(String.format(Locale.US, this.jsBase + ".fill(%s, %s, %s, %s, %s, %s, %s);", arrayToStringWrapQuotes(strArr), number, number2, rect != null ? rect.getJsBase() : null, number3, number4, number5));
        return this;
    }

    public com.anychart.math.Rect getBounds() {
        return new com.anychart.math.Rect(this.jsBase + ".getBounds()");
    }

    public void getPoint() {
        APIlib.getInstance().addJSLine(this.jsBase + ".getPoint();");
    }

    @Override // com.anychart.core.Base
    public void removeAllListeners(String str) {
        APIlib.getInstance().addJSLine(String.format(Locale.US, this.jsBase + ".removeAllListeners(%s);", wrapQuotes(str)));
    }

    public void stroke() {
        APIlib.getInstance().addJSLine(this.jsBase + ".stroke();");
    }

    public com.anychart.core.map.series.Base stroke(Stroke stroke, Number number, String str, String str2, String str3) {
        return new com.anychart.core.map.series.Base(String.format(Locale.US, this.jsBase + ".stroke(%s, %s, %s, %s, %s)", stroke != null ? stroke.getJsBase() : null, number, wrapQuotes(str), wrapQuotes(str2), wrapQuotes(str3)));
    }

    public com.anychart.core.map.series.Base stroke(Stroke stroke, Number number, String str, String str2, StrokeLineCap strokeLineCap) {
        return new com.anychart.core.map.series.Base(String.format(Locale.US, this.jsBase + ".stroke(%s, %s, %s, %s, %s)", stroke != null ? stroke.getJsBase() : null, number, wrapQuotes(str), wrapQuotes(str2), strokeLineCap != null ? strokeLineCap.getJsBase() : null));
    }

    public com.anychart.core.map.series.Base stroke(Stroke stroke, Number number, String str, StrokeLineJoin strokeLineJoin, String str2) {
        return new com.anychart.core.map.series.Base(String.format(Locale.US, this.jsBase + ".stroke(%s, %s, %s, %s, %s)", stroke != null ? stroke.getJsBase() : null, number, wrapQuotes(str), strokeLineJoin != null ? strokeLineJoin.getJsBase() : null, wrapQuotes(str2)));
    }

    public com.anychart.core.map.series.Base stroke(Stroke stroke, Number number, String str, StrokeLineJoin strokeLineJoin, StrokeLineCap strokeLineCap) {
        return new com.anychart.core.map.series.Base(String.format(Locale.US, this.jsBase + ".stroke(%s, %s, %s, %s, %s)", stroke != null ? stroke.getJsBase() : null, number, wrapQuotes(str), strokeLineJoin != null ? strokeLineJoin.getJsBase() : null, strokeLineCap != null ? strokeLineCap.getJsBase() : null));
    }

    public com.anychart.core.map.series.Base stroke(ColoredFill coloredFill, Number number, String str, String str2, String str3) {
        return new com.anychart.core.map.series.Base(String.format(Locale.US, this.jsBase + ".stroke(%s, %s, %s, %s, %s)", coloredFill != null ? coloredFill.getJsBase() : null, number, wrapQuotes(str), wrapQuotes(str2), wrapQuotes(str3)));
    }

    public com.anychart.core.map.series.Base stroke(ColoredFill coloredFill, Number number, String str, String str2, StrokeLineCap strokeLineCap) {
        return new com.anychart.core.map.series.Base(String.format(Locale.US, this.jsBase + ".stroke(%s, %s, %s, %s, %s)", coloredFill != null ? coloredFill.getJsBase() : null, number, wrapQuotes(str), wrapQuotes(str2), strokeLineCap != null ? strokeLineCap.getJsBase() : null));
    }

    public com.anychart.core.map.series.Base stroke(ColoredFill coloredFill, Number number, String str, StrokeLineJoin strokeLineJoin, String str2) {
        return new com.anychart.core.map.series.Base(String.format(Locale.US, this.jsBase + ".stroke(%s, %s, %s, %s, %s)", coloredFill != null ? coloredFill.getJsBase() : null, number, wrapQuotes(str), strokeLineJoin != null ? strokeLineJoin.getJsBase() : null, wrapQuotes(str2)));
    }

    public com.anychart.core.map.series.Base stroke(ColoredFill coloredFill, Number number, String str, StrokeLineJoin strokeLineJoin, StrokeLineCap strokeLineCap) {
        return new com.anychart.core.map.series.Base(String.format(Locale.US, this.jsBase + ".stroke(%s, %s, %s, %s, %s)", coloredFill != null ? coloredFill.getJsBase() : null, number, wrapQuotes(str), strokeLineJoin != null ? strokeLineJoin.getJsBase() : null, strokeLineCap != null ? strokeLineCap.getJsBase() : null));
    }

    public com.anychart.core.map.series.Base stroke(String str, Number number, String str2, String str3, String str4) {
        return new com.anychart.core.map.series.Base(String.format(Locale.US, this.jsBase + ".stroke(%s, %s, %s, %s, %s)", wrapQuotes(str), number, wrapQuotes(str2), wrapQuotes(str3), wrapQuotes(str4)));
    }

    public com.anychart.core.map.series.Base stroke(String str, Number number, String str2, String str3, StrokeLineCap strokeLineCap) {
        return new com.anychart.core.map.series.Base(String.format(Locale.US, this.jsBase + ".stroke(%s, %s, %s, %s, %s)", wrapQuotes(str), number, wrapQuotes(str2), wrapQuotes(str3), strokeLineCap != null ? strokeLineCap.getJsBase() : null));
    }

    public com.anychart.core.map.series.Base stroke(String str, Number number, String str2, StrokeLineJoin strokeLineJoin, String str3) {
        return new com.anychart.core.map.series.Base(String.format(Locale.US, this.jsBase + ".stroke(%s, %s, %s, %s, %s)", wrapQuotes(str), number, wrapQuotes(str2), strokeLineJoin != null ? strokeLineJoin.getJsBase() : null, wrapQuotes(str3)));
    }

    public com.anychart.core.map.series.Base stroke(String str, Number number, String str2, StrokeLineJoin strokeLineJoin, StrokeLineCap strokeLineCap) {
        return new com.anychart.core.map.series.Base(String.format(Locale.US, this.jsBase + ".stroke(%s, %s, %s, %s, %s)", wrapQuotes(str), number, wrapQuotes(str2), strokeLineJoin != null ? strokeLineJoin.getJsBase() : null, strokeLineCap != null ? strokeLineCap.getJsBase() : null));
    }

    public Center stroke(String str) {
        APIlib.getInstance().addJSLine(String.format(Locale.US, this.jsBase + ".stroke(%s);", wrapQuotes(str)));
        return this;
    }

    @Override // com.anychart.core.Base
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

    @Override // com.anychart.core.Base
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

    @Override // com.anychart.core.Base
    public void unlistenByKey(String str) {
        APIlib.getInstance().addJSLine(String.format(Locale.US, this.jsBase + ".unlistenByKey(%s);", wrapQuotes(str)));
    }

    public Center fill(String str) {
        APIlib.getInstance().addJSLine(String.format(Locale.US, this.jsBase + ".fill(%s);", wrapQuotes(str)));
        return this;
    }
}
