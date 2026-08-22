package com.anychart.scales;

import com.amazonaws.services.s3.model.InstructionFileId;
import com.anychart.APIlib;
import com.anychart.chart.common.listener.ListenersInterface;
import java.util.Locale;

/* JADX INFO: loaded from: classes4.dex */
public class GanttDateTime extends com.anychart.core.Base {
    protected GanttDateTime() {
    }

    public static GanttDateTime instantiate() {
        return new GanttDateTime("new anychart.scales.ganttDateTime()");
    }

    public GanttDateTime(String str) {
        StringBuilder sb = new StringBuilder("ganttDateTime");
        int i = variableIndex + 1;
        variableIndex = i;
        this.jsBase = sb.append(i).toString();
        APIlib.getInstance().addJSLine(this.jsBase + " = " + str + ";");
    }

    @Override // com.anychart.core.Base, com.anychart.JsObject
    public String getJsBase() {
        return this.jsBase;
    }

    public void getRange() {
        APIlib.getInstance().addJSLine(this.jsBase + ".getRange();");
    }

    public void getTotalRange() {
        APIlib.getInstance().addJSLine(this.jsBase + ".getTotalRange();");
    }

    public void inverseTransform(Number number) {
        APIlib.getInstance().addJSLine(String.format(Locale.US, this.jsBase + ".inverseTransform(%s);", number));
    }

    public void maximum() {
        APIlib.getInstance().addJSLine(this.jsBase + ".maximum();");
    }

    public GanttDateTime maximum(Number number) {
        APIlib.getInstance().addJSLine(String.format(Locale.US, this.jsBase + ".maximum(%s);", number));
        return this;
    }

    public void maximumGap() {
        APIlib.getInstance().addJSLine(this.jsBase + ".maximumGap();");
    }

    public GanttDateTime maximumGap(Number number) {
        APIlib.getInstance().addJSLine(String.format(Locale.US, this.jsBase + ".maximumGap(%s);", number));
        return this;
    }

    public void minimum() {
        APIlib.getInstance().addJSLine(this.jsBase + ".minimum();");
    }

    public GanttDateTime minimum(Number number) {
        APIlib.getInstance().addJSLine(String.format(Locale.US, this.jsBase + ".minimum(%s);", number));
        return this;
    }

    public void minimumGap() {
        APIlib.getInstance().addJSLine(this.jsBase + ".minimumGap();");
    }

    public GanttDateTime minimumGap(Number number) {
        APIlib.getInstance().addJSLine(String.format(Locale.US, this.jsBase + ".minimumGap(%s);", number));
        return this;
    }

    @Override // com.anychart.core.Base
    public void removeAllListeners(String str) {
        APIlib.getInstance().addJSLine(String.format(Locale.US, this.jsBase + ".removeAllListeners(%s);", wrapQuotes(str)));
    }

    public void softMaximum() {
        APIlib.getInstance().addJSLine(this.jsBase + ".softMaximum();");
    }

    public GanttDateTime softMaximum(Number number) {
        APIlib.getInstance().addJSLine(String.format(Locale.US, this.jsBase + ".softMaximum(%s);", number));
        return this;
    }

    public void softMinimum() {
        APIlib.getInstance().addJSLine(this.jsBase + ".softMinimum();");
    }

    public GanttDateTime softMinimum(Number number) {
        APIlib.getInstance().addJSLine(String.format(Locale.US, this.jsBase + ".softMinimum(%s);", number));
        return this;
    }

    public void transform(String str) {
        APIlib.getInstance().addJSLine(String.format(Locale.US, this.jsBase + ".transform(%s);", wrapQuotes(str)));
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

    public void zoomLevels() {
        APIlib.getInstance().addJSLine(this.jsBase + ".zoomLevels();");
    }
}
