package com.anychart.core.series.renderingsettings;

import com.anychart.APIlib;
import java.util.Locale;

/* JADX INFO: loaded from: classes5.dex */
public class PointContext extends Context {
    protected PointContext() {
    }

    public static PointContext instantiate() {
        return new PointContext("new anychart.core.series.RenderingSettings.pointContext()");
    }

    public PointContext(String str) {
        StringBuilder sb = new StringBuilder("pointContext");
        int i = variableIndex + 1;
        variableIndex = i;
        this.jsBase = sb.append(i).toString();
        APIlib.getInstance().addJSLine(this.jsBase + " = " + str + ";");
    }

    @Override // com.anychart.core.series.renderingsettings.Context, com.anychart.JsObject
    public String getJsBase() {
        return this.jsBase;
    }

    public void getDataValue(String str) {
        APIlib.getInstance().addJSLine(String.format(Locale.US, this.jsBase + ".getDataValue(%s);", wrapQuotes(str)));
    }

    public void getStackedValue() {
        APIlib.getInstance().addJSLine(this.jsBase + ".getStackedValue();");
    }

    public void getStackedZero() {
        APIlib.getInstance().addJSLine(this.jsBase + ".getStackedZero();");
    }

    @Override // com.anychart.core.series.renderingsettings.Context
    public void getStat(String str) {
        APIlib.getInstance().addJSLine(String.format(Locale.US, this.jsBase + ".getStat(%s);", wrapQuotes(str)));
    }
}
