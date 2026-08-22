package com.anychart.scales;

import com.amazonaws.services.s3.model.InstructionFileId;
import com.anychart.APIlib;
import com.anychart.chart.common.listener.ListenersInterface;
import java.util.Locale;

/* JADX INFO: loaded from: classes4.dex */
public class StockOrdinalDateTime extends StockScatterDateTime {
    protected StockOrdinalDateTime() {
    }

    public static StockOrdinalDateTime instantiate() {
        return new StockOrdinalDateTime("new anychart.scales.stockOrdinalDateTime()");
    }

    public StockOrdinalDateTime(String str) {
        StringBuilder sb = new StringBuilder("stockOrdinalDateTime");
        int i = variableIndex + 1;
        variableIndex = i;
        this.jsBase = sb.append(i).toString();
        APIlib.getInstance().addJSLine(this.jsBase + " = " + str + ";");
    }

    @Override // com.anychart.scales.StockScatterDateTime, com.anychart.core.Base, com.anychart.JsObject
    public String getJsBase() {
        return this.jsBase;
    }

    @Override // com.anychart.scales.StockScatterDateTime
    public void getFullMaximum() {
        APIlib.getInstance().addJSLine(this.jsBase + ".getFullMaximum();");
    }

    @Override // com.anychart.scales.StockScatterDateTime
    public void getFullMinimum() {
        APIlib.getInstance().addJSLine(this.jsBase + ".getFullMinimum();");
    }

    @Override // com.anychart.scales.StockScatterDateTime
    public void getGroupingUnit() {
        APIlib.getInstance().addJSLine(this.jsBase + ".getGroupingUnit();");
    }

    @Override // com.anychart.scales.StockScatterDateTime
    public void getGroupingUnitCount() {
        APIlib.getInstance().addJSLine(this.jsBase + ".getGroupingUnitCount();");
    }

    @Override // com.anychart.scales.StockScatterDateTime
    public void getMaximum() {
        APIlib.getInstance().addJSLine(this.jsBase + ".getMaximum();");
    }

    @Override // com.anychart.scales.StockScatterDateTime
    public void getMinimum() {
        APIlib.getInstance().addJSLine(this.jsBase + ".getMinimum();");
    }

    @Override // com.anychart.scales.StockScatterDateTime
    public void inverseTransform(Number number) {
        APIlib.getInstance().addJSLine(String.format(Locale.US, this.jsBase + ".inverseTransform(%s);", number));
    }

    @Override // com.anychart.scales.StockScatterDateTime, com.anychart.core.Base
    public void removeAllListeners(String str) {
        APIlib.getInstance().addJSLine(String.format(Locale.US, this.jsBase + ".removeAllListeners(%s);", wrapQuotes(str)));
    }

    @Override // com.anychart.scales.StockScatterDateTime
    public void transform(Number number) {
        APIlib.getInstance().addJSLine(String.format(Locale.US, this.jsBase + ".transform(%s);", number));
    }

    @Override // com.anychart.scales.StockScatterDateTime
    public void transform(String str) {
        APIlib.getInstance().addJSLine(String.format(Locale.US, this.jsBase + ".transform(%s);", wrapQuotes(str)));
    }

    @Override // com.anychart.scales.StockScatterDateTime, com.anychart.core.Base
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

    @Override // com.anychart.scales.StockScatterDateTime, com.anychart.core.Base
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

    @Override // com.anychart.scales.StockScatterDateTime, com.anychart.core.Base
    public void unlistenByKey(String str) {
        APIlib.getInstance().addJSLine(String.format(Locale.US, this.jsBase + ".unlistenByKey(%s);", wrapQuotes(str)));
    }

    @Override // com.anychart.scales.StockScatterDateTime
    public void ticks() {
        APIlib.getInstance().addJSLine(this.jsBase + ".ticks();");
    }

    @Override // com.anychart.scales.StockScatterDateTime
    public void ticksCount() {
        APIlib.getInstance().addJSLine(this.jsBase + ".ticksCount();");
    }

    @Override // com.anychart.scales.StockScatterDateTime
    public StockOrdinalDateTime ticksCount(Number number) {
        APIlib.getInstance().addJSLine(String.format(Locale.US, this.jsBase + ".ticksCount(%s);", number));
        return this;
    }
}
