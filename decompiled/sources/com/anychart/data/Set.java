package com.anychart.data;

import com.amazonaws.services.s3.model.InstructionFileId;
import com.anychart.APIlib;
import com.anychart.chart.common.dataentry.DataEntry;
import com.anychart.chart.common.listener.ListenersInterface;
import com.anychart.core.Base;
import com.anychart.enums.TreeFillingMethod;
import java.util.List;
import java.util.Locale;

/* JADX INFO: loaded from: classes5.dex */
public class Set extends Base {
    protected Set() {
    }

    public static Set instantiate() {
        return new Set("new anychart.data.set()");
    }

    public Set(String str) {
        StringBuilder sb = new StringBuilder("set");
        int i = variableIndex + 1;
        variableIndex = i;
        this.jsBase = sb.append(i).toString();
        APIlib.getInstance().addJSLine(this.jsBase + " = " + str + ";");
    }

    @Override // com.anychart.core.Base, com.anychart.JsObject
    public String getJsBase() {
        return this.jsBase;
    }

    public Set append(String str) {
        APIlib.getInstance().addJSLine(String.format(Locale.US, this.jsBase + ".append(%s);", wrapQuotes(str)));
        return this;
    }

    public void data(List<DataEntry> list) {
        APIlib.getInstance().addJSLine(String.format(Locale.US, this.jsBase + ".data(%s);", arrayToString(list)));
    }

    public void getRowsCount() {
        APIlib.getInstance().addJSLine(this.jsBase + ".getRowsCount();");
    }

    public Set insert(String str, Number number) {
        APIlib.getInstance().addJSLine(String.format(Locale.US, this.jsBase + ".insert(%s, %s);", wrapQuotes(str), number));
        return this;
    }

    public Mapping mapAs(String str) {
        return new Mapping(String.format(Locale.US, this.jsBase + ".mapAs(%s)", wrapQuotes(str)));
    }

    public Set remove(Number number) {
        APIlib.getInstance().addJSLine(String.format(Locale.US, this.jsBase + ".remove(%s);", number));
        return this;
    }

    @Override // com.anychart.core.Base
    public void removeAllListeners(String str) {
        APIlib.getInstance().addJSLine(String.format(Locale.US, this.jsBase + ".removeAllListeners(%s);", wrapQuotes(str)));
    }

    public void row(Number number) {
        APIlib.getInstance().addJSLine(String.format(Locale.US, this.jsBase + ".row(%s);", number));
    }

    public void row(Number number, String str) {
        APIlib.getInstance().addJSLine(String.format(Locale.US, this.jsBase + ".row(%s, %s);", number, wrapQuotes(str)));
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

    public Set data(View view) {
        APIlib.getInstance().addJSLine(String.format(Locale.US, this.jsBase + ".data(%s);", view != null ? view.getJsBase() : null));
        return this;
    }

    public Set data(List<DataEntry> list, TreeFillingMethod treeFillingMethod) {
        APIlib.getInstance().addJSLine(String.format(Locale.US, this.jsBase + ".data(%s, %s);", arrayToString(list), treeFillingMethod != null ? treeFillingMethod.getJsBase() : null));
        return this;
    }

    public Set data(List<DataEntry> list, String str) {
        APIlib.getInstance().addJSLine(String.format(Locale.US, this.jsBase + ".data(%s, %s);", arrayToString(list), wrapQuotes(str)));
        return this;
    }
}
