package com.anychart.core.gantt.rendering.settings;

import com.anychart.JsObject;
import com.anychart.enums.ShapeType;
import java.util.Locale;

/* JADX INFO: loaded from: classes5.dex */
public class ShapeConfig extends JsObject {
    public ShapeConfig(Boolean bool, String str, ShapeType shapeType, Number number) {
        this.js.append(String.format(Locale.US, "{disablePointerEvents:%s, name: %s, shapeType: %s, zIndex: %s, } ", bool, wrapQuotes(str), shapeType != null ? shapeType.getJsBase() : null, number));
    }

    @Override // com.anychart.JsObject
    public String getJsBase() {
        return this.js.toString();
    }
}
