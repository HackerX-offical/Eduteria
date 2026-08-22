package com.anychart.scales;

import com.amazonaws.services.s3.model.InstructionFileId;
import com.anychart.APIlib;
import com.anychart.chart.common.listener.ListenersInterface;
import java.util.Locale;

/* JADX INFO: loaded from: classes4.dex */
public class DateTime extends ScatterBase {
    protected DateTime() {
    }

    public static DateTime instantiate() {
        return new DateTime("new anychart.scales.dateTime()");
    }

    public DateTime(String str) {
        StringBuilder sb = new StringBuilder("dateTime");
        int i = variableIndex + 1;
        variableIndex = i;
        this.jsBase = sb.append(i).toString();
        APIlib.getInstance().addJSLine(this.jsBase + " = " + str + ";");
    }

    @Override // com.anychart.scales.ScatterBase, com.anychart.scales.Base, com.anychart.JsObject
    public String getJsBase() {
        return this.jsBase;
    }

    @Override // com.anychart.scales.ScatterBase
    public void alignMaximum() {
        APIlib.getInstance().addJSLine(this.jsBase + ".alignMaximum();");
    }

    @Override // com.anychart.scales.ScatterBase
    public DateTime alignMaximum(Boolean bool) {
        APIlib.getInstance().addJSLine(String.format(Locale.US, this.jsBase + ".alignMaximum(%s);", bool));
        return this;
    }

    @Override // com.anychart.scales.ScatterBase
    public void alignMinimum() {
        APIlib.getInstance().addJSLine(this.jsBase + ".alignMinimum();");
    }

    @Override // com.anychart.scales.ScatterBase
    public DateTime alignMinimum(Boolean bool) {
        APIlib.getInstance().addJSLine(String.format(Locale.US, this.jsBase + ".alignMinimum(%s);", bool));
        return this;
    }

    @Override // com.anychart.scales.ScatterBase
    public DateTime extendDataRange(String str) {
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
    public DateTime inverted(Boolean bool) {
        APIlib.getInstance().addJSLine(String.format(Locale.US, this.jsBase + ".inverted(%s);", bool));
        return this;
    }

    @Override // com.anychart.scales.ScatterBase
    public void maximum() {
        APIlib.getInstance().addJSLine(this.jsBase + ".maximum();");
    }

    @Override // com.anychart.scales.ScatterBase
    public DateTime maximum(Number number) {
        APIlib.getInstance().addJSLine(String.format(Locale.US, this.jsBase + ".maximum(%s);", number));
        return this;
    }

    public void maximumGap() {
        APIlib.getInstance().addJSLine(this.jsBase + ".maximumGap();");
    }

    public DateTime maximumGap(Number number) {
        APIlib.getInstance().addJSLine(String.format(Locale.US, this.jsBase + ".maximumGap(%s);", number));
        return this;
    }

    @Override // com.anychart.scales.ScatterBase
    public void minimum() {
        APIlib.getInstance().addJSLine(this.jsBase + ".minimum();");
    }

    @Override // com.anychart.scales.ScatterBase
    public DateTime minimum(Number number) {
        APIlib.getInstance().addJSLine(String.format(Locale.US, this.jsBase + ".minimum(%s);", number));
        return this;
    }

    public void minimumGap() {
        APIlib.getInstance().addJSLine(this.jsBase + ".minimumGap();");
    }

    public DateTime minimumGap(Number number) {
        APIlib.getInstance().addJSLine(String.format(Locale.US, this.jsBase + ".minimumGap(%s);", number));
        return this;
    }

    public DateTimeTicks minorTicks() {
        return new DateTimeTicks(this.jsBase + ".minorTicks()");
    }

    public DateTime minorTicks(String str) {
        APIlib.getInstance().addJSLine(String.format(Locale.US, this.jsBase + ".minorTicks(%s);", wrapQuotes(str)));
        return this;
    }

    public DateTime minorTicks(String[] strArr) {
        APIlib.getInstance().addJSLine(String.format(Locale.US, this.jsBase + ".minorTicks(%s);", arrayToStringWrapQuotes(strArr)));
        return this;
    }

    @Override // com.anychart.scales.ScatterBase, com.anychart.scales.Base
    public void removeAllListeners(String str) {
        APIlib.getInstance().addJSLine(String.format(Locale.US, this.jsBase + ".removeAllListeners(%s);", wrapQuotes(str)));
    }

    public void softMaximum() {
        APIlib.getInstance().addJSLine(this.jsBase + ".softMaximum();");
    }

    public DateTime softMaximum(Number number) {
        APIlib.getInstance().addJSLine(String.format(Locale.US, this.jsBase + ".softMaximum(%s);", number));
        return this;
    }

    public void softMinimum() {
        APIlib.getInstance().addJSLine(this.jsBase + ".softMinimum();");
    }

    public DateTime softMinimum(Number number) {
        APIlib.getInstance().addJSLine(String.format(Locale.US, this.jsBase + ".softMinimum(%s);", number));
        return this;
    }

    @Override // com.anychart.scales.ScatterBase, com.anychart.scales.Base
    public DateTime startAutoCalc() {
        APIlib.getInstance().addJSLine(this.jsBase + ".startAutoCalc();");
        return this;
    }

    public DateTimeTicks ticks() {
        return new DateTimeTicks(this.jsBase + ".ticks()");
    }

    public DateTime ticks(String str) {
        APIlib.getInstance().addJSLine(String.format(Locale.US, this.jsBase + ".ticks(%s);", wrapQuotes(str)));
        return this;
    }

    public DateTime ticks(String[] strArr) {
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

    @Override // com.anychart.scales.ScatterBase
    public void maxTicksCount() {
        APIlib.getInstance().addJSLine(this.jsBase + ".maxTicksCount();");
    }

    @Override // com.anychart.scales.ScatterBase
    public DateTime maxTicksCount(Number number) {
        APIlib.getInstance().addJSLine(String.format(Locale.US, this.jsBase + ".maxTicksCount(%s);", number));
        return this;
    }
}
