package com.anychart.editor;

import com.amazonaws.services.s3.model.InstructionFileId;
import com.anychart.APIlib;
import com.anychart.JsObject;
import com.anychart.chart.common.dataentry.DataEntry;
import com.anychart.chart.common.listener.ListenersInterface;
import com.anychart.enums.EditorSteps;
import java.util.List;
import java.util.Locale;

/* JADX INFO: loaded from: classes5.dex */
public class Editor extends JsObject {
    protected Editor() {
    }

    public static Editor instantiate() {
        return new Editor("new anychart.editor.editor()");
    }

    public Editor(String str) {
        StringBuilder sb = new StringBuilder("editor");
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

    public void data(List<DataEntry> list) {
        APIlib.getInstance().addJSLine(String.format(Locale.US, this.jsBase + ".data(%s);", arrayToString(list)));
    }

    public void dialogRender() {
        APIlib.getInstance().addJSLine(this.jsBase + ".dialogRender();");
    }

    public void dialogRender(String str) {
        APIlib.getInstance().addJSLine(String.format(Locale.US, this.jsBase + ".dialogRender(%s);", wrapQuotes(str)));
    }

    public void dialogVisible() {
        APIlib.getInstance().addJSLine(this.jsBase + ".dialogVisible();");
    }

    public Editor dialogVisible(Boolean bool) {
        APIlib.getInstance().addJSLine(String.format(Locale.US, this.jsBase + ".dialogVisible(%s);", bool));
        return this;
    }

    public void dispose() {
        APIlib.getInstance().addJSLine(this.jsBase + ".dispose();");
    }

    public void getJavascript() {
        APIlib.getInstance().addJSLine(this.jsBase + ".getJavascript();");
    }

    public void getJavascript(JavascriptOptions javascriptOptions) {
        APIlib.getInstance().addJSLine(String.format(Locale.US, this.jsBase + ".getJavascript(%s);", javascriptOptions != null ? javascriptOptions.getJsBase() : null));
    }

    public void getJson() {
        APIlib.getInstance().addJSLine(this.jsBase + ".getJson();");
    }

    public void getXml() {
        APIlib.getInstance().addJSLine(this.jsBase + ".getXml();");
    }

    public void hide(Boolean bool) {
        APIlib.getInstance().addJSLine(String.format(Locale.US, this.jsBase + ".hide(%s);", bool));
    }

    public Editor localization(String str) {
        APIlib.getInstance().addJSLine(String.format(Locale.US, this.jsBase + ".localization(%s);", wrapQuotes(str)));
        return this;
    }

    public void removeAllListeners(String str) {
        APIlib.getInstance().addJSLine(String.format(Locale.US, this.jsBase + ".removeAllListeners(%s);", wrapQuotes(str)));
    }

    public void removeClassName(String str) {
        APIlib.getInstance().addJSLine(String.format(Locale.US, this.jsBase + ".removeClassName(%s);", wrapQuotes(str)));
    }

    public void show(Boolean bool) {
        APIlib.getInstance().addJSLine(String.format(Locale.US, this.jsBase + ".show(%s);", bool));
    }

    public Step step(EditorSteps editorSteps) {
        return new Step(String.format(Locale.US, this.jsBase + ".step(%s)", editorSteps != null ? editorSteps.getJsBase() : null));
    }

    public Step step(String str) {
        return new Step(String.format(Locale.US, this.jsBase + ".step(%s)", wrapQuotes(str)));
    }

    public Step step(EditorSteps editorSteps, Boolean bool) {
        return new Step(String.format(Locale.US, this.jsBase + ".step(%s, %s)", editorSteps != null ? editorSteps.getJsBase() : null, bool));
    }

    public Step step(String str, Boolean bool) {
        return new Step(String.format(Locale.US, this.jsBase + ".step(%s, %s)", wrapQuotes(str), bool));
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

    public void unlistenByKey(String str) {
        APIlib.getInstance().addJSLine(String.format(Locale.US, this.jsBase + ".unlistenByKey(%s);", wrapQuotes(str)));
    }

    public void version() {
        APIlib.getInstance().addJSLine(this.jsBase + ".version();");
    }
}
