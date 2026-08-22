package com.anychart.graphics.events;

import com.anychart.APIlib;
import com.anychart.JsObject;

/* JADX INFO: loaded from: classes.dex */
public class BrowserEvent extends JsObject {
    protected BrowserEvent() {
    }

    public static BrowserEvent instantiate() {
        return new BrowserEvent("new anychart.graphics.events.browserEvent()");
    }

    public BrowserEvent(String str) {
        StringBuilder sb = new StringBuilder("browserEvent");
        int i = variableIndex + 1;
        variableIndex = i;
        this.jsBase = sb.append(i).toString();
        APIlib.getInstance().addJSLine(this.jsBase + " = " + str + ";");
    }

    @Override // com.anychart.JsObject
    public String getJsBase() {
        return this.jsBase;
    }

    public void preventDefault() {
        APIlib.getInstance().addJSLine(this.jsBase + ".preventDefault();");
    }

    public void stopPropagation() {
        APIlib.getInstance().addJSLine(this.jsBase + ".stopPropagation();");
    }

    public void stopWrapperPropagation() {
        APIlib.getInstance().addJSLine(this.jsBase + ".stopWrapperPropagation();");
    }
}
