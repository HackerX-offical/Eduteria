package com.anychart.core.series.renderingsettings;

import com.anychart.JsObject;
import com.anychart.enums.ShapeType;
import java.util.Locale;

/* JADX INFO: loaded from: classes5.dex */
public class ShapeConfig extends JsObject {
    public ShapeConfig(Boolean bool, String str, Boolean bool2, String str2, Boolean bool3, ShapeType shapeType, String str3, Number number) {
        this.js.append(String.format(Locale.US, "{canBeHoveredSelected:%s, fillName: %s, isHatchFill: %s, name: %s, scrollerSelected: %s, shapeType: %s, strokeName: %s, zIndex: %s, } ", bool, wrapQuotes(str), bool2, wrapQuotes(str2), bool3, shapeType != null ? shapeType.getJsBase() : null, wrapQuotes(str3), number));
    }

    public ShapeConfig(Boolean bool, String str, Boolean bool2, String str2, Boolean bool3, String str3, String str4, Number number) {
        this.js.append(String.format(Locale.US, "{canBeHoveredSelected:%s, fillName: %s, isHatchFill: %s, name: %s, scrollerSelected: %s, shapeType: %s, strokeName: %s, zIndex: %s, } ", bool, wrapQuotes(str), bool2, wrapQuotes(str2), bool3, wrapQuotes(str3), wrapQuotes(str4), number));
    }

    @Override // com.anychart.JsObject
    public String getJsBase() {
        return this.js.toString();
    }
}
