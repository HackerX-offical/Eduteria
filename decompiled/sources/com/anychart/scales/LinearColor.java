package com.anychart.scales;

import com.amazonaws.services.s3.model.InstructionFileId;
import com.anychart.APIlib;
import com.anychart.chart.common.listener.ListenersInterface;
import com.anychart.graphics.vector.LinearGradientFill;
import com.anychart.graphics.vector.RadialGradientFill;
import com.anychart.graphics.vector.SolidFill;
import java.util.Locale;

/* JADX INFO: loaded from: classes4.dex */
public class LinearColor extends ScatterBase {
    protected LinearColor() {
    }

    public static LinearColor instantiate() {
        return new LinearColor("new anychart.scales.linearColor()");
    }

    public LinearColor(String str) {
        StringBuilder sb = new StringBuilder("linearColor");
        int i = variableIndex + 1;
        variableIndex = i;
        this.jsBase = sb.append(i).toString();
        APIlib.getInstance().addJSLine(this.jsBase + " = " + str + ";");
    }

    @Override // com.anychart.scales.ScatterBase, com.anychart.scales.Base, com.anychart.JsObject
    public String getJsBase() {
        return this.jsBase;
    }

    public void colorToValue(String str) {
        APIlib.getInstance().addJSLine(String.format(Locale.US, this.jsBase + ".colorToValue(%s);", wrapQuotes(str)));
    }

    public void colors() {
        APIlib.getInstance().addJSLine(this.jsBase + ".colors();");
    }

    public LinearColor colors(String str) {
        APIlib.getInstance().addJSLine(String.format(Locale.US, this.jsBase + ".colors(%s);", wrapQuotes(str)));
        return this;
    }

    public LinearColor colors(SolidFill solidFill) {
        APIlib.getInstance().addJSLine(String.format(Locale.US, this.jsBase + ".colors(%s);", solidFill != null ? solidFill.getJsBase() : null));
        return this;
    }

    public LinearColor colors(LinearGradientFill linearGradientFill) {
        APIlib.getInstance().addJSLine(String.format(Locale.US, this.jsBase + ".colors(%s);", linearGradientFill != null ? linearGradientFill.getJsBase() : null));
        return this;
    }

    public LinearColor colors(RadialGradientFill radialGradientFill) {
        APIlib.getInstance().addJSLine(String.format(Locale.US, this.jsBase + ".colors(%s);", radialGradientFill != null ? radialGradientFill.getJsBase() : null));
        return this;
    }

    public LinearColor colors(String[] strArr) {
        APIlib.getInstance().addJSLine(String.format(Locale.US, this.jsBase + ".colors(%s);", arrayToStringWrapQuotes(strArr)));
        return this;
    }

    @Override // com.anychart.scales.ScatterBase
    public LinearColor extendDataRange(String str) {
        APIlib.getInstance().addJSLine(String.format(Locale.US, this.jsBase + ".extendDataRange(%s);", wrapQuotes(str)));
        return this;
    }

    @Override // com.anychart.scales.ScatterBase, com.anychart.scales.Base
    public void finishAutoCalc(Boolean bool) {
        APIlib.getInstance().addJSLine(String.format(Locale.US, this.jsBase + ".finishAutoCalc(%s);", bool));
    }

    @Override // com.anychart.scales.ScatterBase, com.anychart.scales.Base
    public void getType() {
        APIlib.getInstance().addJSLine(this.jsBase + ".getType();");
    }

    @Override // com.anychart.scales.ScatterBase
    public void inverseTransform(Number number) {
        APIlib.getInstance().addJSLine(String.format(Locale.US, this.jsBase + ".inverseTransform(%s);", number));
    }

    @Override // com.anychart.scales.ScatterBase, com.anychart.scales.Base
    public void inverted() {
        APIlib.getInstance().addJSLine(this.jsBase + ".inverted();");
    }

    @Override // com.anychart.scales.ScatterBase, com.anychart.scales.Base
    public LinearColor inverted(Boolean bool) {
        APIlib.getInstance().addJSLine(String.format(Locale.US, this.jsBase + ".inverted(%s);", bool));
        return this;
    }

    @Override // com.anychart.scales.ScatterBase
    public void maximum() {
        APIlib.getInstance().addJSLine(this.jsBase + ".maximum();");
    }

    @Override // com.anychart.scales.ScatterBase
    public LinearColor maximum(Number number) {
        APIlib.getInstance().addJSLine(String.format(Locale.US, this.jsBase + ".maximum(%s);", number));
        return this;
    }

    @Override // com.anychart.scales.ScatterBase
    public void minimum() {
        APIlib.getInstance().addJSLine(this.jsBase + ".minimum();");
    }

    @Override // com.anychart.scales.ScatterBase
    public LinearColor minimum(Number number) {
        APIlib.getInstance().addJSLine(String.format(Locale.US, this.jsBase + ".minimum(%s);", number));
        return this;
    }

    public ScatterTicks minorTicks() {
        return new ScatterTicks(this.jsBase + ".minorTicks()");
    }

    public LinearColor minorTicks(String str) {
        APIlib.getInstance().addJSLine(String.format(Locale.US, this.jsBase + ".minorTicks(%s);", wrapQuotes(str)));
        return this;
    }

    public LinearColor minorTicks(String[] strArr) {
        APIlib.getInstance().addJSLine(String.format(Locale.US, this.jsBase + ".minorTicks(%s);", arrayToStringWrapQuotes(strArr)));
        return this;
    }

    @Override // com.anychart.scales.ScatterBase, com.anychart.scales.Base
    public void removeAllListeners(String str) {
        APIlib.getInstance().addJSLine(String.format(Locale.US, this.jsBase + ".removeAllListeners(%s);", wrapQuotes(str)));
    }

    @Override // com.anychart.scales.ScatterBase, com.anychart.scales.Base
    public LinearColor startAutoCalc() {
        APIlib.getInstance().addJSLine(this.jsBase + ".startAutoCalc();");
        return this;
    }

    public ScatterTicks ticks() {
        return new ScatterTicks(this.jsBase + ".ticks()");
    }

    public LinearColor ticks(String str) {
        APIlib.getInstance().addJSLine(String.format(Locale.US, this.jsBase + ".ticks(%s);", wrapQuotes(str)));
        return this;
    }

    public LinearColor ticks(String[] strArr) {
        APIlib.getInstance().addJSLine(String.format(Locale.US, this.jsBase + ".ticks(%s);", arrayToStringWrapQuotes(strArr)));
        return this;
    }

    @Override // com.anychart.scales.ScatterBase
    public void transform(String str) {
        APIlib.getInstance().addJSLine(String.format(Locale.US, this.jsBase + ".transform(%s);", wrapQuotes(str)));
    }

    @Override // com.anychart.scales.ScatterBase, com.anychart.scales.Base
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

    @Override // com.anychart.scales.ScatterBase, com.anychart.scales.Base
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

    @Override // com.anychart.scales.ScatterBase, com.anychart.scales.Base
    public void unlistenByKey(String str) {
        APIlib.getInstance().addJSLine(String.format(Locale.US, this.jsBase + ".unlistenByKey(%s);", wrapQuotes(str)));
    }

    public void valueToColor(Number number) {
        APIlib.getInstance().addJSLine(String.format(Locale.US, this.jsBase + ".valueToColor(%s);", number));
    }

    @Override // com.anychart.scales.ScatterBase
    public void alignMaximum() {
        APIlib.getInstance().addJSLine(this.jsBase + ".alignMaximum();");
    }

    @Override // com.anychart.scales.ScatterBase
    public LinearColor alignMaximum(Boolean bool) {
        APIlib.getInstance().addJSLine(String.format(Locale.US, this.jsBase + ".alignMaximum(%s);", bool));
        return this;
    }

    @Override // com.anychart.scales.ScatterBase
    public void alignMinimum() {
        APIlib.getInstance().addJSLine(this.jsBase + ".alignMinimum();");
    }

    @Override // com.anychart.scales.ScatterBase
    public LinearColor alignMinimum(Boolean bool) {
        APIlib.getInstance().addJSLine(String.format(Locale.US, this.jsBase + ".alignMinimum(%s);", bool));
        return this;
    }

    @Override // com.anychart.scales.ScatterBase
    public void maxTicksCount() {
        APIlib.getInstance().addJSLine(this.jsBase + ".maxTicksCount();");
    }

    @Override // com.anychart.scales.ScatterBase
    public LinearColor maxTicksCount(Number number) {
        APIlib.getInstance().addJSLine(String.format(Locale.US, this.jsBase + ".maxTicksCount(%s);", number));
        return this;
    }
}
