package com.anychart.scales;

import com.amazonaws.services.s3.model.InstructionFileId;
import com.anychart.APIlib;
import com.anychart.chart.common.listener.ListenersInterface;
import com.anychart.enums.ScaleCompareWithMode;
import com.anychart.enums.ScaleComparisonMode;
import com.anychart.enums.ScaleStackDirection;
import com.anychart.enums.ScaleStackMode;
import java.util.Locale;

/* JADX INFO: loaded from: classes4.dex */
public class Logarithmic extends Linear {
    protected Logarithmic() {
    }

    public static Logarithmic instantiate() {
        return new Logarithmic("new anychart.scales.logarithmic()");
    }

    public Logarithmic(String str) {
        StringBuilder sb = new StringBuilder("logarithmic");
        int i = variableIndex + 1;
        variableIndex = i;
        this.jsBase = sb.append(i).toString();
        APIlib.getInstance().addJSLine(this.jsBase + " = " + str + ";");
    }

    @Override // com.anychart.scales.Linear, com.anychart.scales.ScatterBase, com.anychart.scales.Base, com.anychart.JsObject
    public String getJsBase() {
        return this.jsBase;
    }

    @Override // com.anychart.scales.Linear, com.anychart.scales.ScatterBase
    public void alignMaximum() {
        APIlib.getInstance().addJSLine(this.jsBase + ".alignMaximum();");
    }

    @Override // com.anychart.scales.Linear, com.anychart.scales.ScatterBase
    public Logarithmic alignMaximum(Boolean bool) {
        APIlib.getInstance().addJSLine(String.format(Locale.US, this.jsBase + ".alignMaximum(%s);", bool));
        return this;
    }

    @Override // com.anychart.scales.Linear, com.anychart.scales.ScatterBase
    public void alignMinimum() {
        APIlib.getInstance().addJSLine(this.jsBase + ".alignMinimum();");
    }

    @Override // com.anychart.scales.Linear, com.anychart.scales.ScatterBase
    public Logarithmic alignMinimum(Boolean bool) {
        APIlib.getInstance().addJSLine(String.format(Locale.US, this.jsBase + ".alignMinimum(%s);", bool));
        return this;
    }

    @Override // com.anychart.scales.Linear, com.anychart.scales.ScatterBase
    public Logarithmic extendDataRange(String str) {
        APIlib.getInstance().addJSLine(String.format(Locale.US, this.jsBase + ".extendDataRange(%s);", wrapQuotes(str)));
        return this;
    }

    @Override // com.anychart.scales.Linear, com.anychart.scales.ScatterBase, com.anychart.scales.Base
    public void finishAutoCalc(Boolean bool) {
        APIlib.getInstance().addJSLine(String.format(Locale.US, this.jsBase + ".finishAutoCalc(%s);", bool));
    }

    @Override // com.anychart.scales.Linear, com.anychart.scales.ScatterBase, com.anychart.scales.Base
    public void getType() {
        APIlib.getInstance().addJSLine(this.jsBase + ".getType();");
    }

    @Override // com.anychart.scales.Linear, com.anychart.scales.ScatterBase
    public void inverseTransform(Number number) {
        APIlib.getInstance().addJSLine(String.format(Locale.US, this.jsBase + ".inverseTransform(%s);", number));
    }

    @Override // com.anychart.scales.Linear, com.anychart.scales.ScatterBase, com.anychart.scales.Base
    public void inverted() {
        APIlib.getInstance().addJSLine(this.jsBase + ".inverted();");
    }

    @Override // com.anychart.scales.Linear, com.anychart.scales.ScatterBase, com.anychart.scales.Base
    public Logarithmic inverted(Boolean bool) {
        APIlib.getInstance().addJSLine(String.format(Locale.US, this.jsBase + ".inverted(%s);", bool));
        return this;
    }

    public void logBase() {
        APIlib.getInstance().addJSLine(this.jsBase + ".logBase();");
    }

    public Logarithmic logBase(Number number) {
        APIlib.getInstance().addJSLine(String.format(Locale.US, this.jsBase + ".logBase(%s);", number));
        return this;
    }

    @Override // com.anychart.scales.Linear, com.anychart.scales.ScatterBase
    public void maximum() {
        APIlib.getInstance().addJSLine(this.jsBase + ".maximum();");
    }

    @Override // com.anychart.scales.Linear, com.anychart.scales.ScatterBase
    public Logarithmic maximum(Number number) {
        APIlib.getInstance().addJSLine(String.format(Locale.US, this.jsBase + ".maximum(%s);", number));
        return this;
    }

    @Override // com.anychart.scales.Linear
    public void maximumGap() {
        APIlib.getInstance().addJSLine(this.jsBase + ".maximumGap();");
    }

    @Override // com.anychart.scales.Linear
    public Logarithmic maximumGap(Number number) {
        APIlib.getInstance().addJSLine(String.format(Locale.US, this.jsBase + ".maximumGap(%s);", number));
        return this;
    }

    @Override // com.anychart.scales.Linear, com.anychart.scales.ScatterBase
    public void minimum() {
        APIlib.getInstance().addJSLine(this.jsBase + ".minimum();");
    }

    @Override // com.anychart.scales.Linear, com.anychart.scales.ScatterBase
    public Logarithmic minimum(Number number) {
        APIlib.getInstance().addJSLine(String.format(Locale.US, this.jsBase + ".minimum(%s);", number));
        return this;
    }

    @Override // com.anychart.scales.Linear
    public void minimumGap() {
        APIlib.getInstance().addJSLine(this.jsBase + ".minimumGap();");
    }

    @Override // com.anychart.scales.Linear
    public Logarithmic minimumGap(Number number) {
        APIlib.getInstance().addJSLine(String.format(Locale.US, this.jsBase + ".minimumGap(%s);", number));
        return this;
    }

    @Override // com.anychart.scales.Linear
    public ScatterTicks minorTicks() {
        return new ScatterTicks(this.jsBase + ".minorTicks()");
    }

    @Override // com.anychart.scales.Linear
    public Logarithmic minorTicks(String str) {
        APIlib.getInstance().addJSLine(String.format(Locale.US, this.jsBase + ".minorTicks(%s);", wrapQuotes(str)));
        return this;
    }

    @Override // com.anychart.scales.Linear
    public Logarithmic minorTicks(String[] strArr) {
        APIlib.getInstance().addJSLine(String.format(Locale.US, this.jsBase + ".minorTicks(%s);", arrayToStringWrapQuotes(strArr)));
        return this;
    }

    @Override // com.anychart.scales.Linear, com.anychart.scales.ScatterBase, com.anychart.scales.Base
    public void removeAllListeners(String str) {
        APIlib.getInstance().addJSLine(String.format(Locale.US, this.jsBase + ".removeAllListeners(%s);", wrapQuotes(str)));
    }

    @Override // com.anychart.scales.Linear
    public void softMaximum() {
        APIlib.getInstance().addJSLine(this.jsBase + ".softMaximum();");
    }

    @Override // com.anychart.scales.Linear
    public Logarithmic softMaximum(Number number) {
        APIlib.getInstance().addJSLine(String.format(Locale.US, this.jsBase + ".softMaximum(%s);", number));
        return this;
    }

    @Override // com.anychart.scales.Linear
    public void softMinimum() {
        APIlib.getInstance().addJSLine(this.jsBase + ".softMinimum();");
    }

    @Override // com.anychart.scales.Linear
    public Logarithmic softMinimum(Number number) {
        APIlib.getInstance().addJSLine(String.format(Locale.US, this.jsBase + ".softMinimum(%s);", number));
        return this;
    }

    @Override // com.anychart.scales.Linear
    public void stackDirection() {
        APIlib.getInstance().addJSLine(this.jsBase + ".stackDirection();");
    }

    @Override // com.anychart.scales.Linear
    public Logarithmic stackDirection(ScaleStackDirection scaleStackDirection) {
        APIlib.getInstance().addJSLine(String.format(Locale.US, this.jsBase + ".stackDirection(%s);", scaleStackDirection != null ? scaleStackDirection.getJsBase() : null));
        return this;
    }

    @Override // com.anychart.scales.Linear
    public Logarithmic stackDirection(String str) {
        APIlib.getInstance().addJSLine(String.format(Locale.US, this.jsBase + ".stackDirection(%s);", wrapQuotes(str)));
        return this;
    }

    @Override // com.anychart.scales.Linear
    public void stackMode() {
        APIlib.getInstance().addJSLine(this.jsBase + ".stackMode();");
    }

    @Override // com.anychart.scales.Linear
    public Logarithmic stackMode(ScaleStackMode scaleStackMode) {
        APIlib.getInstance().addJSLine(String.format(Locale.US, this.jsBase + ".stackMode(%s);", scaleStackMode != null ? scaleStackMode.getJsBase() : null));
        return this;
    }

    @Override // com.anychart.scales.Linear
    public Logarithmic stackMode(String str) {
        APIlib.getInstance().addJSLine(String.format(Locale.US, this.jsBase + ".stackMode(%s);", wrapQuotes(str)));
        return this;
    }

    @Override // com.anychart.scales.Linear, com.anychart.scales.ScatterBase, com.anychart.scales.Base
    public Logarithmic startAutoCalc() {
        APIlib.getInstance().addJSLine(this.jsBase + ".startAutoCalc();");
        return this;
    }

    @Override // com.anychart.scales.Linear
    public void stickToZero() {
        APIlib.getInstance().addJSLine(this.jsBase + ".stickToZero();");
    }

    @Override // com.anychart.scales.Linear
    public Logarithmic stickToZero(Boolean bool) {
        APIlib.getInstance().addJSLine(String.format(Locale.US, this.jsBase + ".stickToZero(%s);", bool));
        return this;
    }

    @Override // com.anychart.scales.Linear
    public ScatterTicks ticks() {
        return new ScatterTicks(this.jsBase + ".ticks()");
    }

    @Override // com.anychart.scales.Linear
    public Logarithmic ticks(String str) {
        APIlib.getInstance().addJSLine(String.format(Locale.US, this.jsBase + ".ticks(%s);", wrapQuotes(str)));
        return this;
    }

    @Override // com.anychart.scales.Linear
    public Logarithmic ticks(String[] strArr) {
        APIlib.getInstance().addJSLine(String.format(Locale.US, this.jsBase + ".ticks(%s);", arrayToStringWrapQuotes(strArr)));
        return this;
    }

    @Override // com.anychart.scales.Linear, com.anychart.scales.ScatterBase
    public void transform(String str) {
        APIlib.getInstance().addJSLine(String.format(Locale.US, this.jsBase + ".transform(%s);", wrapQuotes(str)));
    }

    @Override // com.anychart.scales.Linear, com.anychart.scales.ScatterBase, com.anychart.scales.Base
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

    @Override // com.anychart.scales.Linear, com.anychart.scales.ScatterBase, com.anychart.scales.Base
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

    @Override // com.anychart.scales.Linear, com.anychart.scales.ScatterBase, com.anychart.scales.Base
    public void unlistenByKey(String str) {
        APIlib.getInstance().addJSLine(String.format(Locale.US, this.jsBase + ".unlistenByKey(%s);", wrapQuotes(str)));
    }

    @Override // com.anychart.scales.Linear
    public void compareWith() {
        APIlib.getInstance().addJSLine(this.jsBase + ".compareWith();");
    }

    @Override // com.anychart.scales.Linear
    public Logarithmic compareWith(ScaleCompareWithMode scaleCompareWithMode) {
        APIlib.getInstance().addJSLine(String.format(Locale.US, this.jsBase + ".compareWith(%s);", scaleCompareWithMode != null ? scaleCompareWithMode.getJsBase() : null));
        return this;
    }

    @Override // com.anychart.scales.Linear
    public Logarithmic compareWith(String str) {
        APIlib.getInstance().addJSLine(String.format(Locale.US, this.jsBase + ".compareWith(%s);", wrapQuotes(str)));
        return this;
    }

    @Override // com.anychart.scales.Linear
    public Logarithmic compareWith(Number number) {
        APIlib.getInstance().addJSLine(String.format(Locale.US, this.jsBase + ".compareWith(%s);", number));
        return this;
    }

    @Override // com.anychart.scales.Linear
    public void comparisonMode() {
        APIlib.getInstance().addJSLine(this.jsBase + ".comparisonMode();");
    }

    @Override // com.anychart.scales.Linear
    public Logarithmic comparisonMode(ScaleComparisonMode scaleComparisonMode) {
        APIlib.getInstance().addJSLine(String.format(Locale.US, this.jsBase + ".comparisonMode(%s);", scaleComparisonMode != null ? scaleComparisonMode.getJsBase() : null));
        return this;
    }

    @Override // com.anychart.scales.Linear
    public Logarithmic comparisonMode(String str) {
        APIlib.getInstance().addJSLine(String.format(Locale.US, this.jsBase + ".comparisonMode(%s);", wrapQuotes(str)));
        return this;
    }

    @Override // com.anychart.scales.Linear, com.anychart.scales.ScatterBase
    public void maxTicksCount() {
        APIlib.getInstance().addJSLine(this.jsBase + ".maxTicksCount();");
    }

    @Override // com.anychart.scales.Linear, com.anychart.scales.ScatterBase
    public Logarithmic maxTicksCount(Number number) {
        APIlib.getInstance().addJSLine(String.format(Locale.US, this.jsBase + ".maxTicksCount(%s);", number));
        return this;
    }
}
