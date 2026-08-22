package com.anychart.ui.contextmenu;

import com.anychart.JsObject;
import com.anychart.core.Chart;
import com.anychart.core.Point;
import com.anychart.core.VisualBase;
import java.util.Locale;

/* JADX INFO: loaded from: classes6.dex */
public class ActionContext extends JsObject {
    public ActionContext(Chart chart, String str, Item item, Point[] pointArr, VisualBase visualBase, String str2) {
        this.js.append(String.format(Locale.US, "{chart:%s, event: %s, item: %s, selectedPoints: %s, target: %s, type: %s, } ", chart != null ? chart.getJsBase() : null, wrapQuotes(str), item != null ? item.getJsBase() : null, arrayToString((JsObject[]) pointArr), visualBase != null ? visualBase.getJsBase() : null, wrapQuotes(str2)));
    }

    @Override // com.anychart.JsObject
    public String getJsBase() {
        return this.js.toString();
    }
}
