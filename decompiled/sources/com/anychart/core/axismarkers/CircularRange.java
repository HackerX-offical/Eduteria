package com.anychart.core.axismarkers;

import com.amazonaws.services.s3.model.InstructionFileId;
import com.anychart.APIlib;
import com.anychart.chart.common.listener.ListenersInterface;
import com.anychart.core.VisualBase;
import com.anychart.enums.GaugeSidePosition;
import com.anychart.graphics.vector.Fill;
import com.anychart.graphics.vector.GradientKey;
import com.anychart.graphics.vector.Layer;
import com.anychart.graphics.vector.PaperSize;
import com.anychart.graphics.vector.Stage;
import com.anychart.math.Rect;
import java.util.Locale;

/* JADX INFO: loaded from: classes5.dex */
public class CircularRange extends VisualBase {
    protected CircularRange() {
    }

    public static CircularRange instantiate() {
        return new CircularRange("new anychart.core.axisMarkers.circularRange()");
    }

    public CircularRange(String str) {
        StringBuilder sb = new StringBuilder("circularRange");
        int i = variableIndex + 1;
        variableIndex = i;
        this.jsBase = sb.append(i).toString();
        APIlib.getInstance().addJSLine(this.jsBase + " = " + str + ";");
    }

    @Override // com.anychart.core.VisualBase, com.anychart.core.Base, com.anychart.JsObject
    public String getJsBase() {
        return this.jsBase;
    }

    public void axisIndex() {
        APIlib.getInstance().addJSLine(this.jsBase + ".axisIndex();");
    }

    public CircularRange axisIndex(Number number) {
        APIlib.getInstance().addJSLine(String.format(Locale.US, this.jsBase + ".axisIndex(%s);", number));
        return this;
    }

    public void cornersRounding() {
        APIlib.getInstance().addJSLine(this.jsBase + ".cornersRounding();");
    }

    public CircularRange cornersRounding(Number number) {
        APIlib.getInstance().addJSLine(String.format(Locale.US, this.jsBase + ".cornersRounding(%s);", number));
        return this;
    }

    public CircularRange cornersRounding(String str) {
        APIlib.getInstance().addJSLine(String.format(Locale.US, this.jsBase + ".cornersRounding(%s);", wrapQuotes(str)));
        return this;
    }

    @Override // com.anychart.core.VisualBase
    public void enabled() {
        APIlib.getInstance().addJSLine(this.jsBase + ".enabled();");
    }

    @Override // com.anychart.core.VisualBase
    public CircularRange enabled(Boolean bool) {
        APIlib.getInstance().addJSLine(String.format(Locale.US, this.jsBase + ".enabled(%s);", bool));
        return this;
    }

    public void endSize() {
        APIlib.getInstance().addJSLine(this.jsBase + ".endSize();");
    }

    public CircularRange endSize(Number number) {
        APIlib.getInstance().addJSLine(String.format(Locale.US, this.jsBase + ".endSize(%s);", number));
        return this;
    }

    public CircularRange endSize(String str) {
        APIlib.getInstance().addJSLine(String.format(Locale.US, this.jsBase + ".endSize(%s);", wrapQuotes(str)));
        return this;
    }

    public void fill() {
        APIlib.getInstance().addJSLine(this.jsBase + ".fill();");
    }

    public CircularRange fill(Fill fill) {
        APIlib.getInstance().addJSLine(String.format(Locale.US, this.jsBase + ".fill(%s);", fill != null ? fill.getJsBase() : null));
        return this;
    }

    public CircularRange fill(GradientKey gradientKey) {
        APIlib.getInstance().addJSLine(String.format(Locale.US, this.jsBase + ".fill(%s);", gradientKey != null ? gradientKey.getJsBase() : null));
        return this;
    }

    public CircularRange fill(String[] strArr) {
        APIlib.getInstance().addJSLine(String.format(Locale.US, this.jsBase + ".fill(%s);", arrayToStringWrapQuotes(strArr)));
        return this;
    }

    public void from() {
        APIlib.getInstance().addJSLine(this.jsBase + ".from();");
    }

    public CircularRange from(Number number) {
        APIlib.getInstance().addJSLine(String.format(Locale.US, this.jsBase + ".from(%s);", number));
        return this;
    }

    public void position() {
        APIlib.getInstance().addJSLine(this.jsBase + ".position();");
    }

    public CircularRange position(GaugeSidePosition gaugeSidePosition) {
        APIlib.getInstance().addJSLine(String.format(Locale.US, this.jsBase + ".position(%s);", gaugeSidePosition != null ? gaugeSidePosition.getJsBase() : null));
        return this;
    }

    public CircularRange position(String str) {
        APIlib.getInstance().addJSLine(String.format(Locale.US, this.jsBase + ".position(%s);", wrapQuotes(str)));
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

    public void radius() {
        APIlib.getInstance().addJSLine(this.jsBase + ".radius();");
    }

    public CircularRange radius(Number number) {
        APIlib.getInstance().addJSLine(String.format(Locale.US, this.jsBase + ".radius(%s);", number));
        return this;
    }

    public CircularRange radius(String str) {
        APIlib.getInstance().addJSLine(String.format(Locale.US, this.jsBase + ".radius(%s);", wrapQuotes(str)));
        return this;
    }

    @Override // com.anychart.core.VisualBase, com.anychart.core.Base
    public void removeAllListeners(String str) {
        APIlib.getInstance().addJSLine(String.format(Locale.US, this.jsBase + ".removeAllListeners(%s);", wrapQuotes(str)));
    }

    public void startSize() {
        APIlib.getInstance().addJSLine(this.jsBase + ".startSize();");
    }

    public CircularRange startSize(Number number) {
        APIlib.getInstance().addJSLine(String.format(Locale.US, this.jsBase + ".startSize(%s);", number));
        return this;
    }

    public CircularRange startSize(String str) {
        APIlib.getInstance().addJSLine(String.format(Locale.US, this.jsBase + ".startSize(%s);", wrapQuotes(str)));
        return this;
    }

    public void to() {
        APIlib.getInstance().addJSLine(this.jsBase + ".to();");
    }

    public CircularRange to(Number number) {
        APIlib.getInstance().addJSLine(String.format(Locale.US, this.jsBase + ".to(%s);", number));
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

    @Override // com.anychart.core.VisualBase
    public void zIndex() {
        APIlib.getInstance().addJSLine(this.jsBase + ".zIndex();");
    }

    @Override // com.anychart.core.VisualBase
    public CircularRange zIndex(Number number) {
        APIlib.getInstance().addJSLine(String.format(Locale.US, this.jsBase + ".zIndex(%s);", number));
        return this;
    }

    @Override // com.anychart.core.VisualBase
    public Layer container() {
        return new Layer(this.jsBase + ".container()");
    }

    @Override // com.anychart.core.VisualBase
    public CircularRange container(Layer layer) {
        APIlib.getInstance().addJSLine(String.format(Locale.US, this.jsBase + ".container(%s);", layer != null ? layer.getJsBase() : null));
        return this;
    }

    @Override // com.anychart.core.VisualBase
    public CircularRange container(Stage stage) {
        APIlib.getInstance().addJSLine(String.format(Locale.US, this.jsBase + ".container(%s);", stage != null ? stage.getJsBase() : null));
        return this;
    }

    @Override // com.anychart.core.VisualBase
    public CircularRange container(String str) {
        APIlib.getInstance().addJSLine(String.format(Locale.US, this.jsBase + ".container(%s);", wrapQuotes(str)));
        return this;
    }

    @Override // com.anychart.core.VisualBase
    public Rect parentBounds() {
        return new Rect(this.jsBase + ".parentBounds()");
    }

    @Override // com.anychart.core.VisualBase
    public CircularRange parentBounds(Rect rect) {
        APIlib.getInstance().addJSLine(String.format(Locale.US, this.jsBase + ".parentBounds(%s);", rect != null ? rect.getJsBase() : null));
        return this;
    }

    @Override // com.anychart.core.VisualBase
    public CircularRange parentBounds(String str) {
        APIlib.getInstance().addJSLine(String.format(Locale.US, this.jsBase + ".parentBounds(%s);", wrapQuotes(str)));
        return this;
    }

    @Override // com.anychart.core.VisualBase
    public CircularRange parentBounds(Number number) {
        APIlib.getInstance().addJSLine(String.format(Locale.US, this.jsBase + ".parentBounds(%s);", number));
        return this;
    }

    @Override // com.anychart.core.VisualBase
    public CircularRange parentBounds(Number number, Number number2, Number number3, Number number4) {
        APIlib.getInstance().addJSLine(String.format(Locale.US, this.jsBase + ".parentBounds(%s, %s, %s, %s);", number, number2, number3, number4));
        return this;
    }

    public CircularRange fill(String str) {
        APIlib.getInstance().addJSLine(String.format(Locale.US, this.jsBase + ".fill(%s);", wrapQuotes(str)));
        return this;
    }
}
