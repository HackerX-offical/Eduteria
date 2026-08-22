package com.anychart.core.utils;

import com.amazonaws.services.s3.model.InstructionFileId;
import com.anychart.APIlib;
import com.anychart.chart.common.listener.ListenersInterface;
import com.anychart.core.Base;
import java.util.Locale;

/* JADX INFO: loaded from: classes5.dex */
public class QuarterSettings extends Base {
    protected QuarterSettings() {
    }

    public static QuarterSettings instantiate() {
        return new QuarterSettings("new anychart.core.utils.quarterSettings()");
    }

    public QuarterSettings(String str) {
        StringBuilder sb = new StringBuilder("quarterSettings");
        int i = variableIndex + 1;
        variableIndex = i;
        this.jsBase = sb.append(i).toString();
        APIlib.getInstance().addJSLine(this.jsBase + " = " + str + ";");
    }

    @Override // com.anychart.core.Base, com.anychart.JsObject
    public String getJsBase() {
        return this.jsBase;
    }

    public Quarter leftBottom() {
        return new Quarter(this.jsBase + ".leftBottom()");
    }

    public QuarterSettings leftBottom(String str) {
        APIlib.getInstance().addJSLine(String.format(Locale.US, this.jsBase + ".leftBottom(%s);", wrapQuotes(str)));
        return this;
    }

    public Quarter leftTop() {
        return new Quarter(this.jsBase + ".leftTop()");
    }

    public QuarterSettings leftTop(String str) {
        APIlib.getInstance().addJSLine(String.format(Locale.US, this.jsBase + ".leftTop(%s);", wrapQuotes(str)));
        return this;
    }

    public Quarter rightBottom() {
        return new Quarter(this.jsBase + ".rightBottom()");
    }

    public QuarterSettings rightBottom(String str) {
        APIlib.getInstance().addJSLine(String.format(Locale.US, this.jsBase + ".rightBottom(%s);", wrapQuotes(str)));
        return this;
    }

    public Quarter rightTop() {
        return new Quarter(this.jsBase + ".rightTop()");
    }

    public QuarterSettings rightTop(String str) {
        APIlib.getInstance().addJSLine(String.format(Locale.US, this.jsBase + ".rightTop(%s);", wrapQuotes(str)));
        return this;
    }

    @Override // com.anychart.core.Base
    public void removeAllListeners(String str) {
        APIlib.getInstance().addJSLine(String.format(Locale.US, this.jsBase + ".removeAllListeners(%s);", wrapQuotes(str)));
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
