package com.anychart.scales.datetimewithcalendar;

import com.anychart.JsObject;
import java.util.Locale;

/* JADX INFO: loaded from: classes4.dex */
public class Tick extends JsObject {
    public Tick(Number number, Boolean bool, Number number2) {
        this.js.append(String.format(Locale.US, "{end:%s, holiday: %s, start: %s, } ", number, bool, number2));
    }

    @Override // com.anychart.JsObject
    public String getJsBase() {
        return this.js.toString();
    }
}
