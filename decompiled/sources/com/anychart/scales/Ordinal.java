package com.anychart.scales;

import com.amazonaws.services.s3.model.InstructionFileId;
import com.anychart.APIlib;
import com.anychart.chart.common.listener.ListenersInterface;
import java.util.Arrays;
import java.util.Locale;

/* JADX INFO: loaded from: classes4.dex */
public class Ordinal extends Base {
    protected Ordinal() {
    }

    public static Ordinal instantiate() {
        return new Ordinal("new anychart.scales.ordinal()");
    }

    public Ordinal(String str) {
        StringBuilder sb = new StringBuilder("ordinal");
        int i = variableIndex + 1;
        variableIndex = i;
        this.jsBase = sb.append(i).toString();
        APIlib.getInstance().addJSLine(this.jsBase + " = " + str + ";");
    }

    @Override // com.anychart.scales.Base, com.anychart.JsObject
    public String getJsBase() {
        return this.jsBase;
    }

    public Ordinal extendDataRange(String str) {
        APIlib.getInstance().addJSLine(String.format(Locale.US, this.jsBase + ".extendDataRange(%s);", wrapQuotes(str)));
        return this;
    }

    @Override // com.anychart.scales.Base
    public void finishAutoCalc(Boolean bool) {
        APIlib.getInstance().addJSLine(String.format(Locale.US, this.jsBase + ".finishAutoCalc(%s);", bool));
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
    public Ordinal inverted(Boolean bool) {
        APIlib.getInstance().addJSLine(String.format(Locale.US, this.jsBase + ".inverted(%s);", bool));
        return this;
    }

    public void names() {
        APIlib.getInstance().addJSLine(this.jsBase + ".names();");
    }

    public Ordinal names(String[] strArr) {
        APIlib.getInstance().addJSLine(String.format(Locale.US, this.jsBase + ".names(%s);", arrayToStringWrapQuotes(strArr)));
        return this;
    }

    public Ordinal names(String str) {
        APIlib.getInstance().addJSLine(String.format(Locale.US, this.jsBase + ".names(%s);", wrapQuotes(str)));
        return this;
    }

    @Override // com.anychart.scales.Base
    public void removeAllListeners(String str) {
        APIlib.getInstance().addJSLine(String.format(Locale.US, this.jsBase + ".removeAllListeners(%s);", wrapQuotes(str)));
    }

    @Override // com.anychart.scales.Base
    public Ordinal startAutoCalc() {
        APIlib.getInstance().addJSLine(this.jsBase + ".startAutoCalc();");
        return this;
    }

    public OrdinalTicks ticks() {
        return new OrdinalTicks(this.jsBase + ".ticks()");
    }

    public Ordinal ticks(String str) {
        APIlib.getInstance().addJSLine(String.format(Locale.US, this.jsBase + ".ticks(%s);", wrapQuotes(str)));
        return this;
    }

    public Ordinal ticks(String[] strArr) {
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

    public Ordinal values(String[] strArr) {
        APIlib.getInstance().addJSLine(String.format(Locale.US, this.jsBase + ".values(%s);", arrayToStringWrapQuotes(strArr)));
        return this;
    }

    public void weights() {
        APIlib.getInstance().addJSLine(this.jsBase + ".weights();");
    }

    public Ordinal weights(Number[] numberArr) {
        APIlib.getInstance().addJSLine(String.format(Locale.US, this.jsBase + ".weights(%s);", Arrays.toString(numberArr)));
        return this;
    }

    public Ordinal values(String str) {
        APIlib.getInstance().addJSLine(String.format(Locale.US, this.jsBase + ".values(%s);", wrapQuotes(str)));
        return this;
    }
}
