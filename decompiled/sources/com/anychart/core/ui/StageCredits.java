package com.anychart.core.ui;

import com.anychart.APIlib;
import com.anychart.JsObject;
import java.util.Locale;

/* JADX INFO: loaded from: classes5.dex */
public class StageCredits extends JsObject {
    protected StageCredits() {
    }

    public static StageCredits instantiate() {
        return new StageCredits("new anychart.core.ui.stageCredits()");
    }

    public StageCredits(String str) {
        StringBuilder sb = new StringBuilder("stageCredits");
        int i = variableIndex + 1;
        variableIndex = i;
        this.jsBase = sb.append(i).toString();
        APIlib.getInstance().addJSLine(this.jsBase + " = " + str + ";");
    }

    @Override // com.anychart.JsObject
    public String getJsBase() {
        return this.jsBase;
    }

    public void alt() {
        APIlib.getInstance().addJSLine(this.jsBase + ".alt();");
    }

    public StageCredits alt(String str) {
        APIlib.getInstance().addJSLine(String.format(Locale.US, this.jsBase + ".alt(%s);", wrapQuotes(str)));
        return this;
    }

    public void enabled() {
        APIlib.getInstance().addJSLine(this.jsBase + ".enabled();");
    }

    public StageCredits enabled(Boolean bool) {
        APIlib.getInstance().addJSLine(String.format(Locale.US, this.jsBase + ".enabled(%s);", bool));
        return this;
    }

    public void imgAlt() {
        APIlib.getInstance().addJSLine(this.jsBase + ".imgAlt();");
    }

    public StageCredits imgAlt(String str) {
        APIlib.getInstance().addJSLine(String.format(Locale.US, this.jsBase + ".imgAlt(%s);", wrapQuotes(str)));
        return this;
    }

    public void logoSrc() {
        APIlib.getInstance().addJSLine(this.jsBase + ".logoSrc();");
    }

    public StageCredits logoSrc(String str) {
        APIlib.getInstance().addJSLine(String.format(Locale.US, this.jsBase + ".logoSrc(%s);", wrapQuotes(str)));
        return this;
    }

    public void text() {
        APIlib.getInstance().addJSLine(this.jsBase + ".text();");
    }

    public StageCredits text(String str) {
        APIlib.getInstance().addJSLine(String.format(Locale.US, this.jsBase + ".text(%s);", wrapQuotes(str)));
        return this;
    }

    public void url() {
        APIlib.getInstance().addJSLine(this.jsBase + ".url();");
    }

    public StageCredits url(String str) {
        APIlib.getInstance().addJSLine(String.format(Locale.US, this.jsBase + ".url(%s);", wrapQuotes(str)));
        return this;
    }
}
