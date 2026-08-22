package com.anychart.core.utils;

import com.amazonaws.services.s3.model.InstructionFileId;
import com.anychart.APIlib;
import com.anychart.chart.common.listener.ListenersInterface;
import com.anychart.enums.A11yMode;
import java.util.Locale;

/* JADX INFO: loaded from: classes5.dex */
public class ChartA11y extends A11y {
    protected ChartA11y() {
    }

    public static ChartA11y instantiate() {
        return new ChartA11y("new anychart.core.utils.chartA11y()");
    }

    public ChartA11y(String str) {
        StringBuilder sb = new StringBuilder("chartA11y");
        int i = variableIndex + 1;
        variableIndex = i;
        this.jsBase = sb.append(i).toString();
        APIlib.getInstance().addJSLine(this.jsBase + " = " + str + ";");
    }

    @Override // com.anychart.core.utils.A11y, com.anychart.core.Base, com.anychart.JsObject
    public String getJsBase() {
        return this.jsBase;
    }

    public void enabled() {
        APIlib.getInstance().addJSLine(this.jsBase + ".enabled();");
    }

    public ChartA11y enabled(Boolean bool) {
        APIlib.getInstance().addJSLine(String.format(Locale.US, this.jsBase + ".enabled(%s);", bool));
        return this;
    }

    public void mode() {
        APIlib.getInstance().addJSLine(this.jsBase + ".mode();");
    }

    public ChartA11y mode(A11yMode a11yMode) {
        APIlib.getInstance().addJSLine(String.format(Locale.US, this.jsBase + ".mode(%s);", a11yMode != null ? a11yMode.getJsBase() : null));
        return this;
    }

    public ChartA11y mode(String str) {
        APIlib.getInstance().addJSLine(String.format(Locale.US, this.jsBase + ".mode(%s);", wrapQuotes(str)));
        return this;
    }

    public void titleFormat() {
        APIlib.getInstance().addJSLine(this.jsBase + ".titleFormat();");
    }

    public ChartA11y titleFormat(String str) {
        APIlib.getInstance().addJSLine(String.format(Locale.US, this.jsBase + ".titleFormat(%s);", wrapQuotes(str)));
        return this;
    }

    @Override // com.anychart.core.utils.A11y, com.anychart.core.Base
    public void removeAllListeners(String str) {
        APIlib.getInstance().addJSLine(String.format(Locale.US, this.jsBase + ".removeAllListeners(%s);", wrapQuotes(str)));
    }

    @Override // com.anychart.core.utils.A11y, com.anychart.core.Base
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

    @Override // com.anychart.core.utils.A11y, com.anychart.core.Base
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

    @Override // com.anychart.core.utils.A11y, com.anychart.core.Base
    public void unlistenByKey(String str) {
        APIlib.getInstance().addJSLine(String.format(Locale.US, this.jsBase + ".unlistenByKey(%s);", wrapQuotes(str)));
    }
}
