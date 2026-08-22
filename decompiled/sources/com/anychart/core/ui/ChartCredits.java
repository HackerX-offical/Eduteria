package com.anychart.core.ui;

import com.amazonaws.services.s3.model.InstructionFileId;
import com.anychart.APIlib;
import com.anychart.chart.common.listener.ListenersInterface;
import com.anychart.core.Base;
import java.util.Locale;

/* JADX INFO: loaded from: classes5.dex */
public class ChartCredits extends Base {
    protected ChartCredits() {
    }

    public static ChartCredits instantiate() {
        return new ChartCredits("new anychart.core.ui.chartCredits()");
    }

    public ChartCredits(String str) {
        StringBuilder sb = new StringBuilder("chartCredits");
        int i = variableIndex + 1;
        variableIndex = i;
        this.jsBase = sb.append(i).toString();
        APIlib.getInstance().addJSLine(this.jsBase + " = " + str + ";");
    }

    @Override // com.anychart.core.Base, com.anychart.JsObject
    public String getJsBase() {
        return this.jsBase;
    }

    public void alt() {
        APIlib.getInstance().addJSLine(this.jsBase + ".alt();");
    }

    public ChartCredits alt(String str) {
        APIlib.getInstance().addJSLine(String.format(Locale.US, this.jsBase + ".alt(%s);", wrapQuotes(str)));
        return this;
    }

    public void enabled() {
        APIlib.getInstance().addJSLine(this.jsBase + ".enabled();");
    }

    public ChartCredits enabled(Boolean bool) {
        APIlib.getInstance().addJSLine(String.format(Locale.US, this.jsBase + ".enabled(%s);", bool));
        return this;
    }

    public void imgAlt() {
        APIlib.getInstance().addJSLine(this.jsBase + ".imgAlt();");
    }

    public ChartCredits imgAlt(String str) {
        APIlib.getInstance().addJSLine(String.format(Locale.US, this.jsBase + ".imgAlt(%s);", wrapQuotes(str)));
        return this;
    }

    public void logoSrc() {
        APIlib.getInstance().addJSLine(this.jsBase + ".logoSrc();");
    }

    public ChartCredits logoSrc(String str) {
        APIlib.getInstance().addJSLine(String.format(Locale.US, this.jsBase + ".logoSrc(%s);", wrapQuotes(str)));
        return this;
    }

    @Override // com.anychart.core.Base
    public void removeAllListeners(String str) {
        APIlib.getInstance().addJSLine(String.format(Locale.US, this.jsBase + ".removeAllListeners(%s);", wrapQuotes(str)));
    }

    public void text() {
        APIlib.getInstance().addJSLine(this.jsBase + ".text();");
    }

    public ChartCredits text(String str) {
        APIlib.getInstance().addJSLine(String.format(Locale.US, this.jsBase + ".text(%s);", wrapQuotes(str)));
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

    public void url() {
        APIlib.getInstance().addJSLine(this.jsBase + ".url();");
    }

    public ChartCredits url(String str) {
        APIlib.getInstance().addJSLine(String.format(Locale.US, this.jsBase + ".url(%s);", wrapQuotes(str)));
        return this;
    }
}
