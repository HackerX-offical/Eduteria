package com.anychart.scales;

import com.amazonaws.services.s3.model.InstructionFileId;
import com.anychart.APIlib;
import com.anychart.chart.common.listener.ListenersInterface;
import com.anychart.enums.ScatterTicksMode;
import java.util.Locale;

/* JADX INFO: loaded from: classes4.dex */
public class ScatterTicks extends com.anychart.core.Base {
    protected ScatterTicks() {
    }

    public static ScatterTicks instantiate() {
        return new ScatterTicks("new anychart.scales.scatterTicks()");
    }

    public ScatterTicks(String str) {
        StringBuilder sb = new StringBuilder("scatterTicks");
        int i = variableIndex + 1;
        variableIndex = i;
        this.jsBase = sb.append(i).toString();
        APIlib.getInstance().addJSLine(this.jsBase + " = " + str + ";");
    }

    @Override // com.anychart.core.Base, com.anychart.JsObject
    public String getJsBase() {
        return this.jsBase;
    }

    public void allowFractional() {
        APIlib.getInstance().addJSLine(this.jsBase + ".allowFractional();");
    }

    public ScatterTicks allowFractional(Boolean bool) {
        APIlib.getInstance().addJSLine(String.format(Locale.US, this.jsBase + ".allowFractional(%s);", bool));
        return this;
    }

    public void base() {
        APIlib.getInstance().addJSLine(this.jsBase + ".base();");
    }

    public ScatterTicks base(Number number) {
        APIlib.getInstance().addJSLine(String.format(Locale.US, this.jsBase + ".base(%s);", number));
        return this;
    }

    public void count() {
        APIlib.getInstance().addJSLine(this.jsBase + ".count();");
    }

    public ScatterTicks count(Number number) {
        APIlib.getInstance().addJSLine(String.format(Locale.US, this.jsBase + ".count(%s);", number));
        return this;
    }

    public ScatterTicks count(Number number, Number number2) {
        APIlib.getInstance().addJSLine(String.format(Locale.US, this.jsBase + ".count(%s, %s);", number, number2));
        return this;
    }

    public void get() {
        APIlib.getInstance().addJSLine(this.jsBase + ".get();");
    }

    public void interval() {
        APIlib.getInstance().addJSLine(this.jsBase + ".interval();");
    }

    public ScatterTicks interval(Number number) {
        APIlib.getInstance().addJSLine(String.format(Locale.US, this.jsBase + ".interval(%s);", number));
        return this;
    }

    public void mode() {
        APIlib.getInstance().addJSLine(this.jsBase + ".mode();");
    }

    public ScatterTicks mode(ScatterTicksMode scatterTicksMode) {
        APIlib.getInstance().addJSLine(String.format(Locale.US, this.jsBase + ".mode(%s);", scatterTicksMode != null ? scatterTicksMode.getJsBase() : null));
        return this;
    }

    public ScatterTicks mode(String str) {
        APIlib.getInstance().addJSLine(String.format(Locale.US, this.jsBase + ".mode(%s);", wrapQuotes(str)));
        return this;
    }

    @Override // com.anychart.core.Base
    public void removeAllListeners(String str) {
        APIlib.getInstance().addJSLine(String.format(Locale.US, this.jsBase + ".removeAllListeners(%s);", wrapQuotes(str)));
    }

    public ScatterTicks set(String[] strArr) {
        APIlib.getInstance().addJSLine(String.format(Locale.US, this.jsBase + ".set(%s);", arrayToStringWrapQuotes(strArr)));
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
}
