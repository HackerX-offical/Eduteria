package com.anychart.data;

import com.amazonaws.services.s3.model.InstructionFileId;
import com.anychart.APIlib;
import com.anychart.chart.common.dataentry.DataEntry;
import com.anychart.chart.common.listener.ListenersInterface;
import com.anychart.core.Base;
import java.util.List;
import java.util.Locale;

/* JADX INFO: loaded from: classes5.dex */
public class Table extends Base {
    protected Table() {
    }

    public static Table instantiate() {
        return new Table("new anychart.data.table()");
    }

    public static Table instantiate(String str) {
        return new Table(String.format(Locale.US, "new anychart.data.table(%s)", wrapQuotes(str)));
    }

    public Table(String str) {
        StringBuilder sb = new StringBuilder("table");
        int i = variableIndex + 1;
        variableIndex = i;
        this.jsBase = sb.append(i).toString();
        APIlib.getInstance().addJSLine(this.jsBase + " = " + str + ";");
    }

    @Override // com.anychart.core.Base, com.anychart.JsObject
    public String getJsBase() {
        return this.jsBase;
    }

    public Table addData(List<DataEntry> list) {
        APIlib.getInstance().addJSLine(String.format(Locale.US, this.jsBase + ".addData(%s);", arrayToString(list)));
        return this;
    }

    public TableComputer createComputer(TableMapping tableMapping) {
        return new TableComputer(String.format(Locale.US, this.jsBase + ".createComputer(%s)", tableMapping != null ? tableMapping.getJsBase() : null));
    }

    public TableMapping mapAs(String str) {
        return new TableMapping(String.format(Locale.US, this.jsBase + ".mapAs(%s)", wrapQuotes(str)));
    }

    public Table remove(Number number, Number number2) {
        APIlib.getInstance().addJSLine(String.format(Locale.US, this.jsBase + ".remove(%s, %s);", number, number2));
        return this;
    }

    public Table remove(Number number, String str) {
        APIlib.getInstance().addJSLine(String.format(Locale.US, this.jsBase + ".remove(%s, %s);", number, wrapQuotes(str)));
        return this;
    }

    public Table remove(String str, Number number) {
        APIlib.getInstance().addJSLine(String.format(Locale.US, this.jsBase + ".remove(%s, %s);", wrapQuotes(str), number));
        return this;
    }

    public Table remove(String str, String str2) {
        APIlib.getInstance().addJSLine(String.format(Locale.US, this.jsBase + ".remove(%s, %s);", wrapQuotes(str), wrapQuotes(str2)));
        return this;
    }

    @Override // com.anychart.core.Base
    public void removeAllListeners(String str) {
        APIlib.getInstance().addJSLine(String.format(Locale.US, this.jsBase + ".removeAllListeners(%s);", wrapQuotes(str)));
    }

    public Table removeFirst(Number number) {
        APIlib.getInstance().addJSLine(String.format(Locale.US, this.jsBase + ".removeFirst(%s);", number));
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
