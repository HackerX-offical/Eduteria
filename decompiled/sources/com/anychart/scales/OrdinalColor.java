package com.anychart.scales;

import com.amazonaws.services.s3.model.InstructionFileId;
import com.anychart.APIlib;
import com.anychart.chart.common.listener.ListenersInterface;
import java.util.Locale;

/* JADX INFO: loaded from: classes4.dex */
public class OrdinalColor extends Base {
    protected OrdinalColor() {
    }

    public static OrdinalColor instantiate() {
        return new OrdinalColor("new anychart.scales.ordinalColor()");
    }

    public OrdinalColor(String str) {
        StringBuilder sb = new StringBuilder("ordinalColor");
        int i = variableIndex + 1;
        variableIndex = i;
        this.jsBase = sb.append(i).toString();
        APIlib.getInstance().addJSLine(this.jsBase + " = " + str + ";");
    }

    @Override // com.anychart.scales.Base, com.anychart.JsObject
    public String getJsBase() {
        return this.jsBase;
    }

    public void colorToValue(String str) {
        APIlib.getInstance().addJSLine(String.format(Locale.US, this.jsBase + ".colorToValue(%s);", wrapQuotes(str)));
    }

    public void colors() {
        APIlib.getInstance().addJSLine(this.jsBase + ".colors();");
    }

    public OrdinalColor colors(String[] strArr) {
        APIlib.getInstance().addJSLine(String.format(Locale.US, this.jsBase + ".colors(%s);", arrayToStringWrapQuotes(strArr)));
        return this;
    }

    @Override // com.anychart.scales.Base
    public void finishAutoCalc(Boolean bool) {
        APIlib.getInstance().addJSLine(String.format(Locale.US, this.jsBase + ".finishAutoCalc(%s);", bool));
    }

    public void getIndexByValue(Number number) {
        APIlib.getInstance().addJSLine(String.format(Locale.US, this.jsBase + ".getIndexByValue(%s);", number));
    }

    public void getProcessedRanges() {
        APIlib.getInstance().addJSLine(this.jsBase + ".getProcessedRanges();");
    }

    public void getRangeByValue(Number number) {
        APIlib.getInstance().addJSLine(String.format(Locale.US, this.jsBase + ".getRangeByValue(%s);", number));
    }

    @Override // com.anychart.scales.Base
    public void getType() {
        APIlib.getInstance().addJSLine(this.jsBase + ".getType();");
    }

    public void inverseTransform(Number number) {
        APIlib.getInstance().addJSLine(String.format(Locale.US, this.jsBase + ".inverseTransform(%s);", number));
    }

    @Override // com.anychart.scales.Base
    public void inverted() {
        APIlib.getInstance().addJSLine(this.jsBase + ".inverted();");
    }

    @Override // com.anychart.scales.Base
    public OrdinalColor inverted(Boolean bool) {
        APIlib.getInstance().addJSLine(String.format(Locale.US, this.jsBase + ".inverted(%s);", bool));
        return this;
    }

    public void names() {
        APIlib.getInstance().addJSLine(this.jsBase + ".names();");
    }

    public OrdinalColor names(String[] strArr) {
        APIlib.getInstance().addJSLine(String.format(Locale.US, this.jsBase + ".names(%s);", arrayToStringWrapQuotes(strArr)));
        return this;
    }

    public OrdinalColor names(String str) {
        APIlib.getInstance().addJSLine(String.format(Locale.US, this.jsBase + ".names(%s);", wrapQuotes(str)));
        return this;
    }

    public void ranges() {
        APIlib.getInstance().addJSLine(this.jsBase + ".ranges();");
    }

    public OrdinalColor ranges(String[] strArr) {
        APIlib.getInstance().addJSLine(String.format(Locale.US, this.jsBase + ".ranges(%s);", arrayToStringWrapQuotes(strArr)));
        return this;
    }

    @Override // com.anychart.scales.Base
    public void removeAllListeners(String str) {
        APIlib.getInstance().addJSLine(String.format(Locale.US, this.jsBase + ".removeAllListeners(%s);", wrapQuotes(str)));
    }

    @Override // com.anychart.scales.Base
    public OrdinalColor startAutoCalc() {
        APIlib.getInstance().addJSLine(this.jsBase + ".startAutoCalc();");
        return this;
    }

    public OrdinalTicks ticks() {
        return new OrdinalTicks(this.jsBase + ".ticks()");
    }

    public OrdinalColor ticks(String str) {
        APIlib.getInstance().addJSLine(String.format(Locale.US, this.jsBase + ".ticks(%s);", wrapQuotes(str)));
        return this;
    }

    public OrdinalColor ticks(String[] strArr) {
        APIlib.getInstance().addJSLine(String.format(Locale.US, this.jsBase + ".ticks(%s);", arrayToStringWrapQuotes(strArr)));
        return this;
    }

    public void transform(String str, Number number) {
        APIlib.getInstance().addJSLine(String.format(Locale.US, this.jsBase + ".transform(%s, %s);", wrapQuotes(str), number));
    }

    @Override // com.anychart.scales.Base
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

    @Override // com.anychart.scales.Base
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

    @Override // com.anychart.scales.Base
    public void unlistenByKey(String str) {
        APIlib.getInstance().addJSLine(String.format(Locale.US, this.jsBase + ".unlistenByKey(%s);", wrapQuotes(str)));
    }

    public void valueToColor(Number number) {
        APIlib.getInstance().addJSLine(String.format(Locale.US, this.jsBase + ".valueToColor(%s);", number));
    }
}
