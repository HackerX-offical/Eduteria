package com.anychart.core.series;

import com.amazonaws.services.s3.model.InstructionFileId;
import com.anychart.APIlib;
import com.anychart.chart.common.listener.ListenersInterface;
import java.util.Locale;

/* JADX INFO: loaded from: classes5.dex */
public class RenderingSettings extends com.anychart.core.Base {
    protected RenderingSettings() {
    }

    public static RenderingSettings instantiate() {
        return new RenderingSettings("new anychart.core.series.renderingSettings()");
    }

    public RenderingSettings(String str) {
        StringBuilder sb = new StringBuilder("renderingSettings");
        int i = variableIndex + 1;
        variableIndex = i;
        this.jsBase = sb.append(i).toString();
        APIlib.getInstance().addJSLine(this.jsBase + " = " + str + ";");
    }

    @Override // com.anychart.core.Base, com.anychart.JsObject
    public String getJsBase() {
        return this.jsBase;
    }

    public void finish() {
        APIlib.getInstance().addJSLine(this.jsBase + ".finish();");
    }

    public RenderingSettings finish(String str) {
        APIlib.getInstance().addJSLine(String.format(Locale.US, this.jsBase + ".finish(%s);", wrapQuotes(str)));
        return this;
    }

    public void needsWidth() {
        APIlib.getInstance().addJSLine(this.jsBase + ".needsWidth();");
    }

    public RenderingSettings needsWidth(Boolean bool) {
        APIlib.getInstance().addJSLine(String.format(Locale.US, this.jsBase + ".needsWidth(%s);", bool));
        return this;
    }

    public void needsZero() {
        APIlib.getInstance().addJSLine(this.jsBase + ".needsZero();");
    }

    public RenderingSettings needsZero(Boolean bool) {
        APIlib.getInstance().addJSLine(String.format(Locale.US, this.jsBase + ".needsZero(%s);", bool));
        return this;
    }

    public void point() {
        APIlib.getInstance().addJSLine(this.jsBase + ".point();");
    }

    public RenderingSettings point(String str) {
        APIlib.getInstance().addJSLine(String.format(Locale.US, this.jsBase + ".point(%s);", wrapQuotes(str)));
        return this;
    }

    @Override // com.anychart.core.Base
    public void removeAllListeners(String str) {
        APIlib.getInstance().addJSLine(String.format(Locale.US, this.jsBase + ".removeAllListeners(%s);", wrapQuotes(str)));
    }

    public void shapes() {
        APIlib.getInstance().addJSLine(this.jsBase + ".shapes();");
    }

    public void start() {
        APIlib.getInstance().addJSLine(this.jsBase + ".start();");
    }

    public RenderingSettings start(String str) {
        APIlib.getInstance().addJSLine(String.format(Locale.US, this.jsBase + ".start(%s);", wrapQuotes(str)));
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

    public void updatePoint() {
        APIlib.getInstance().addJSLine(this.jsBase + ".updatePoint();");
    }

    public RenderingSettings updatePoint(String str) {
        APIlib.getInstance().addJSLine(String.format(Locale.US, this.jsBase + ".updatePoint(%s);", wrapQuotes(str)));
        return this;
    }

    public void yValues() {
        APIlib.getInstance().addJSLine(this.jsBase + ".yValues();");
    }

    public RenderingSettings yValues(String[] strArr) {
        APIlib.getInstance().addJSLine(String.format(Locale.US, this.jsBase + ".yValues(%s);", arrayToStringWrapQuotes(strArr)));
        return this;
    }
}
