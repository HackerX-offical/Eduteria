package com.anychart.ui;

import com.amazonaws.services.s3.model.InstructionFileId;
import com.anychart.APIlib;
import com.anychart.JsObject;
import com.anychart.chart.common.listener.ListenersInterface;
import com.anychart.core.Chart;
import com.anychart.ui.contextmenu.Item;
import java.util.Locale;

/* JADX INFO: loaded from: classes6.dex */
public class ContextMenu extends JsObject {
    protected ContextMenu() {
    }

    public static ContextMenu instantiate() {
        return new ContextMenu("new anychart.ui.contextMenu()");
    }

    public ContextMenu(String str) {
        StringBuilder sb = new StringBuilder("contextMenu");
        int i = variableIndex + 1;
        variableIndex = i;
        this.jsBase = sb.append(i).toString();
        APIlib.getInstance().addJSLine(this.jsBase + " = " + str + ";");
    }

    @Override // com.anychart.JsObject
    public String getJsBase() {
        return this.jsBase;
    }

    public void addClassName(String str) {
        APIlib.getInstance().addJSLine(String.format(Locale.US, this.jsBase + ".addClassName(%s);", wrapQuotes(str)));
    }

    public ContextMenu attach(Chart chart, Boolean bool) {
        APIlib.getInstance().addJSLine(String.format(Locale.US, this.jsBase + ".attach(%s, %s);", chart != null ? chart.getJsBase() : null, bool));
        return this;
    }

    public void enabled() {
        APIlib.getInstance().addJSLine(this.jsBase + ".enabled();");
    }

    public ContextMenu enabled(Boolean bool) {
        APIlib.getInstance().addJSLine(String.format(Locale.US, this.jsBase + ".enabled(%s);", bool));
        return this;
    }

    public void hide() {
        APIlib.getInstance().addJSLine(this.jsBase + ".hide();");
    }

    public void items() {
        APIlib.getInstance().addJSLine(this.jsBase + ".items();");
    }

    public ContextMenu items(Item[] itemArr) {
        APIlib.getInstance().addJSLine(String.format(Locale.US, this.jsBase + ".items(%s);", arrayToString((JsObject[]) itemArr)));
        return this;
    }

    public void itemsFormatter() {
        APIlib.getInstance().addJSLine(this.jsBase + ".itemsFormatter();");
    }

    public void itemsProvider() {
        APIlib.getInstance().addJSLine(this.jsBase + ".itemsProvider();");
    }

    public void removeClassName(String str) {
        APIlib.getInstance().addJSLine(String.format(Locale.US, this.jsBase + ".removeClassName(%s);", wrapQuotes(str)));
    }

    public void serialize() {
        APIlib.getInstance().addJSLine(this.jsBase + ".serialize();");
    }

    public ContextMenu setup(String str) {
        APIlib.getInstance().addJSLine(String.format(Locale.US, this.jsBase + ".setup(%s);", wrapQuotes(str)));
        return this;
    }

    public ContextMenu setup(String[] strArr) {
        APIlib.getInstance().addJSLine(String.format(Locale.US, this.jsBase + ".setup(%s);", arrayToStringWrapQuotes(strArr)));
        return this;
    }

    public ContextMenu setup(Number number) {
        APIlib.getInstance().addJSLine(String.format(Locale.US, this.jsBase + ".setup(%s);", number));
        return this;
    }

    public ContextMenu setup(Boolean bool) {
        APIlib.getInstance().addJSLine(String.format(Locale.US, this.jsBase + ".setup(%s);", bool));
        return this;
    }

    public void show(Number number, Number number2) {
        APIlib.getInstance().addJSLine(String.format(Locale.US, this.jsBase + ".show(%s, %s);", number, number2));
    }

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
}
