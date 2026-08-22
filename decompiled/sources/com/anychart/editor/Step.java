package com.anychart.editor;

import com.anychart.APIlib;
import com.anychart.JsObject;
import com.anychart.enums.EditorTabs;
import java.util.Locale;

/* JADX INFO: loaded from: classes5.dex */
public class Step extends JsObject {
    protected Step() {
    }

    public static Step instantiate() {
        return new Step("new anychart.editor.step()");
    }

    public Step(String str) {
        StringBuilder sb = new StringBuilder("step");
        int i = variableIndex + 1;
        variableIndex = i;
        this.jsBase = sb.append(i).toString();
        APIlib.getInstance().addJSLine(this.jsBase + " = " + str + ";");
    }

    @Override // com.anychart.JsObject
    public String getJsBase() {
        return this.jsBase;
    }

    public void enabled() {
        APIlib.getInstance().addJSLine(this.jsBase + ".enabled();");
    }

    public Step enabled(Boolean bool) {
        APIlib.getInstance().addJSLine(String.format(Locale.US, this.jsBase + ".enabled(%s);", bool));
        return this;
    }

    public Step tab(EditorTabs editorTabs, Boolean bool) {
        APIlib.getInstance().addJSLine(String.format(Locale.US, this.jsBase + ".tab(%s, %s);", editorTabs != null ? editorTabs.getJsBase() : null, bool));
        return this;
    }

    public Step tab(String str, Boolean bool) {
        APIlib.getInstance().addJSLine(String.format(Locale.US, this.jsBase + ".tab(%s, %s);", wrapQuotes(str), bool));
        return this;
    }
}
