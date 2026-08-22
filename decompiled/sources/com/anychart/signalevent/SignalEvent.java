package com.anychart.signalevent;

import com.anychart.APIlib;
import com.anychart.JsObject;

/* JADX INFO: loaded from: classes4.dex */
public class SignalEvent extends JsObject {
    protected SignalEvent() {
    }

    public static SignalEvent instantiate() {
        return new SignalEvent("new anychart.signalEvent()");
    }

    public SignalEvent(String str) {
        StringBuilder sb = new StringBuilder("signalEvent");
        int i = variableIndex + 1;
        variableIndex = i;
        this.jsBase = sb.append(i).toString();
        APIlib.getInstance().addJSLine(this.jsBase + " = " + str + ";");
    }

    @Override // com.anychart.JsObject
    public String getJsBase() {
        return this.jsBase;
    }

    public void targetBoundsChanged() {
        APIlib.getInstance().addJSLine(this.jsBase + ".targetBoundsChanged();");
    }

    public void targetDataChanged() {
        APIlib.getInstance().addJSLine(this.jsBase + ".targetDataChanged();");
    }

    public void targetMetaChanged() {
        APIlib.getInstance().addJSLine(this.jsBase + ".targetMetaChanged();");
    }

    public void targetNeedsReapplication() {
        APIlib.getInstance().addJSLine(this.jsBase + ".targetNeedsReapplication();");
    }

    public void targetNeedsRecalculation() {
        APIlib.getInstance().addJSLine(this.jsBase + ".targetNeedsRecalculation();");
    }

    public void targetNeedsRedraw() {
        APIlib.getInstance().addJSLine(this.jsBase + ".targetNeedsRedraw();");
    }
}
