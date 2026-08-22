package com.anychart.data;

import com.amazonaws.services.s3.model.InstructionFileId;
import com.anychart.APIlib;
import com.anychart.chart.common.listener.ListenersInterface;
import com.anychart.enums.Sort;
import java.util.Locale;

/* JADX INFO: loaded from: classes5.dex */
public class Mapping extends View {
    protected Mapping() {
    }

    public static Mapping instantiate() {
        return new Mapping("new anychart.data.mapping()");
    }

    public Mapping(String str) {
        StringBuilder sb = new StringBuilder("mapping");
        int i = variableIndex + 1;
        variableIndex = i;
        this.jsBase = sb.append(i).toString();
        APIlib.getInstance().addJSLine(this.jsBase + " = " + str + ";");
    }

    @Override // com.anychart.data.View, com.anychart.core.Base, com.anychart.JsObject
    public String getJsBase() {
        return this.jsBase;
    }

    @Override // com.anychart.data.View
    public Mapping concat(View view) {
        APIlib.getInstance().addJSLine(String.format(Locale.US, this.jsBase + ".concat(%s);", view != null ? view.getJsBase() : null));
        return this;
    }

    @Override // com.anychart.data.View
    public Mapping concat(String[] strArr) {
        APIlib.getInstance().addJSLine(String.format(Locale.US, this.jsBase + ".concat(%s);", arrayToStringWrapQuotes(strArr)));
        return this;
    }

    @Override // com.anychart.data.View
    public Mapping derive() {
        APIlib.getInstance().addJSLine(this.jsBase + ".derive();");
        return this;
    }

    @Override // com.anychart.data.View
    public void find(String str, String str2) {
        APIlib.getInstance().addJSLine(String.format(Locale.US, this.jsBase + ".find(%s, %s);", wrapQuotes(str), wrapQuotes(str2)));
    }

    @Override // com.anychart.data.View
    public void get(Number number, String str) {
        APIlib.getInstance().addJSLine(String.format(Locale.US, this.jsBase + ".get(%s, %s);", number, wrapQuotes(str)));
    }

    @Override // com.anychart.data.View
    public void getDataSets() {
        APIlib.getInstance().addJSLine(this.jsBase + ".getDataSets();");
    }

    @Override // com.anychart.data.View
    public Iterator getIterator() {
        return new Iterator(this.jsBase + ".getIterator()");
    }

    public void getMapping() {
        APIlib.getInstance().addJSLine(this.jsBase + ".getMapping();");
    }

    @Override // com.anychart.data.View
    public void getRowsCount() {
        APIlib.getInstance().addJSLine(this.jsBase + ".getRowsCount();");
    }

    @Override // com.anychart.data.View
    public void meta(Number number, String str) {
        APIlib.getInstance().addJSLine(String.format(Locale.US, this.jsBase + ".meta(%s, %s);", number, wrapQuotes(str)));
    }

    @Override // com.anychart.data.View
    public Mapping meta(Number number, String str, String str2) {
        APIlib.getInstance().addJSLine(String.format(Locale.US, this.jsBase + ".meta(%s, %s, %s);", number, wrapQuotes(str), wrapQuotes(str2)));
        return this;
    }

    @Override // com.anychart.data.View, com.anychart.core.Base
    public void removeAllListeners(String str) {
        APIlib.getInstance().addJSLine(String.format(Locale.US, this.jsBase + ".removeAllListeners(%s);", wrapQuotes(str)));
    }

    @Override // com.anychart.data.View
    public void row(Number number) {
        APIlib.getInstance().addJSLine(String.format(Locale.US, this.jsBase + ".row(%s);", number));
    }

    @Override // com.anychart.data.View
    public void row(Number number, String str) {
        APIlib.getInstance().addJSLine(String.format(Locale.US, this.jsBase + ".row(%s, %s);", number, wrapQuotes(str)));
    }

    @Override // com.anychart.data.View
    public Mapping set(Number number, String str, String str2) {
        APIlib.getInstance().addJSLine(String.format(Locale.US, this.jsBase + ".set(%s, %s, %s);", number, wrapQuotes(str), wrapQuotes(str2)));
        return this;
    }

    @Override // com.anychart.data.View
    public Mapping sort(String str, Sort sort) {
        APIlib.getInstance().addJSLine(String.format(Locale.US, this.jsBase + ".sort(%s, %s);", wrapQuotes(str), sort != null ? sort.getJsBase() : null));
        return this;
    }

    @Override // com.anychart.data.View
    public Mapping sort(String str, String str2) {
        APIlib.getInstance().addJSLine(String.format(Locale.US, this.jsBase + ".sort(%s, %s);", wrapQuotes(str), wrapQuotes(str2)));
        return this;
    }

    @Override // com.anychart.data.View, com.anychart.core.Base
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

    @Override // com.anychart.data.View, com.anychart.core.Base
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

    @Override // com.anychart.data.View, com.anychart.core.Base
    public void unlistenByKey(String str) {
        APIlib.getInstance().addJSLine(String.format(Locale.US, this.jsBase + ".unlistenByKey(%s);", wrapQuotes(str)));
    }
}
