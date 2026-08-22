package com.anychart.core.ui.legend;

import com.anychart.JsObject;
import com.anychart.enums.LegendItemIconType;
import com.anychart.enums.MarkerType;
import com.anychart.graphics.vector.Fill;
import com.anychart.graphics.vector.HatchFill;
import com.anychart.graphics.vector.PatternFill;
import com.anychart.graphics.vector.Stroke;
import com.anychart.graphics.vector.hatchfill.HatchFillType;
import java.util.Locale;

/* JADX INFO: loaded from: classes5.dex */
public class LegendItemProvider extends JsObject {
    public LegendItemProvider(Boolean bool, Boolean bool2, Fill fill, HatchFillType hatchFillType, Fill fill2, Stroke stroke, MarkerType markerType, Stroke stroke2, Number number, LegendItemIconType legendItemIconType, Number number2, String str, String str2) {
        this.js.append(String.format(Locale.US, "{disabled:%s, iconEnabled: %s, iconFill: %s, iconHatchFill: %s, iconMarkerFill: %s, iconMarkerStroke: %s, iconMarkerType: %s, iconStroke: %s, iconTextSpacing: %s, iconType: %s, index: %s, meta: %s, text: %s, } ", bool, bool2, fill != null ? fill.getJsBase() : null, hatchFillType != null ? hatchFillType.getJsBase() : null, fill2 != null ? fill2.getJsBase() : null, stroke != null ? stroke.getJsBase() : null, markerType != null ? markerType.getJsBase() : null, stroke2 != null ? stroke2.getJsBase() : null, number, legendItemIconType != null ? legendItemIconType.getJsBase() : null, number2, wrapQuotes(str), wrapQuotes(str2)));
    }

    public LegendItemProvider(Boolean bool, Boolean bool2, Fill fill, HatchFillType hatchFillType, Fill fill2, Stroke stroke, MarkerType markerType, Stroke stroke2, Number number, String str, Number number2, String str2, String str3) {
        this.js.append(String.format(Locale.US, "{disabled:%s, iconEnabled: %s, iconFill: %s, iconHatchFill: %s, iconMarkerFill: %s, iconMarkerStroke: %s, iconMarkerType: %s, iconStroke: %s, iconTextSpacing: %s, iconType: %s, index: %s, meta: %s, text: %s, } ", bool, bool2, fill != null ? fill.getJsBase() : null, hatchFillType != null ? hatchFillType.getJsBase() : null, fill2 != null ? fill2.getJsBase() : null, stroke != null ? stroke.getJsBase() : null, markerType != null ? markerType.getJsBase() : null, stroke2 != null ? stroke2.getJsBase() : null, number, wrapQuotes(str), number2, wrapQuotes(str2), wrapQuotes(str3)));
    }

    public LegendItemProvider(Boolean bool, Boolean bool2, Fill fill, HatchFillType hatchFillType, Fill fill2, Stroke stroke, String str, Stroke stroke2, Number number, LegendItemIconType legendItemIconType, Number number2, String str2, String str3) {
        this.js.append(String.format(Locale.US, "{disabled:%s, iconEnabled: %s, iconFill: %s, iconHatchFill: %s, iconMarkerFill: %s, iconMarkerStroke: %s, iconMarkerType: %s, iconStroke: %s, iconTextSpacing: %s, iconType: %s, index: %s, meta: %s, text: %s, } ", bool, bool2, fill != null ? fill.getJsBase() : null, hatchFillType != null ? hatchFillType.getJsBase() : null, fill2 != null ? fill2.getJsBase() : null, stroke != null ? stroke.getJsBase() : null, wrapQuotes(str), stroke2 != null ? stroke2.getJsBase() : null, number, legendItemIconType != null ? legendItemIconType.getJsBase() : null, number2, wrapQuotes(str2), wrapQuotes(str3)));
    }

    public LegendItemProvider(Boolean bool, Boolean bool2, Fill fill, HatchFillType hatchFillType, Fill fill2, Stroke stroke, String str, Stroke stroke2, Number number, String str2, Number number2, String str3, String str4) {
        this.js.append(String.format(Locale.US, "{disabled:%s, iconEnabled: %s, iconFill: %s, iconHatchFill: %s, iconMarkerFill: %s, iconMarkerStroke: %s, iconMarkerType: %s, iconStroke: %s, iconTextSpacing: %s, iconType: %s, index: %s, meta: %s, text: %s, } ", bool, bool2, fill != null ? fill.getJsBase() : null, hatchFillType != null ? hatchFillType.getJsBase() : null, fill2 != null ? fill2.getJsBase() : null, stroke != null ? stroke.getJsBase() : null, wrapQuotes(str), stroke2 != null ? stroke2.getJsBase() : null, number, wrapQuotes(str2), number2, wrapQuotes(str3), wrapQuotes(str4)));
    }

    public LegendItemProvider(Boolean bool, Boolean bool2, Fill fill, PatternFill patternFill, Fill fill2, Stroke stroke, MarkerType markerType, Stroke stroke2, Number number, LegendItemIconType legendItemIconType, Number number2, String str, String str2) {
        this.js.append(String.format(Locale.US, "{disabled:%s, iconEnabled: %s, iconFill: %s, iconHatchFill: %s, iconMarkerFill: %s, iconMarkerStroke: %s, iconMarkerType: %s, iconStroke: %s, iconTextSpacing: %s, iconType: %s, index: %s, meta: %s, text: %s, } ", bool, bool2, fill != null ? fill.getJsBase() : null, patternFill != null ? patternFill.getJsBase() : null, fill2 != null ? fill2.getJsBase() : null, stroke != null ? stroke.getJsBase() : null, markerType != null ? markerType.getJsBase() : null, stroke2 != null ? stroke2.getJsBase() : null, number, legendItemIconType != null ? legendItemIconType.getJsBase() : null, number2, wrapQuotes(str), wrapQuotes(str2)));
    }

    public LegendItemProvider(Boolean bool, Boolean bool2, Fill fill, PatternFill patternFill, Fill fill2, Stroke stroke, MarkerType markerType, Stroke stroke2, Number number, String str, Number number2, String str2, String str3) {
        this.js.append(String.format(Locale.US, "{disabled:%s, iconEnabled: %s, iconFill: %s, iconHatchFill: %s, iconMarkerFill: %s, iconMarkerStroke: %s, iconMarkerType: %s, iconStroke: %s, iconTextSpacing: %s, iconType: %s, index: %s, meta: %s, text: %s, } ", bool, bool2, fill != null ? fill.getJsBase() : null, patternFill != null ? patternFill.getJsBase() : null, fill2 != null ? fill2.getJsBase() : null, stroke != null ? stroke.getJsBase() : null, markerType != null ? markerType.getJsBase() : null, stroke2 != null ? stroke2.getJsBase() : null, number, wrapQuotes(str), number2, wrapQuotes(str2), wrapQuotes(str3)));
    }

    public LegendItemProvider(Boolean bool, Boolean bool2, Fill fill, PatternFill patternFill, Fill fill2, Stroke stroke, String str, Stroke stroke2, Number number, LegendItemIconType legendItemIconType, Number number2, String str2, String str3) {
        this.js.append(String.format(Locale.US, "{disabled:%s, iconEnabled: %s, iconFill: %s, iconHatchFill: %s, iconMarkerFill: %s, iconMarkerStroke: %s, iconMarkerType: %s, iconStroke: %s, iconTextSpacing: %s, iconType: %s, index: %s, meta: %s, text: %s, } ", bool, bool2, fill != null ? fill.getJsBase() : null, patternFill != null ? patternFill.getJsBase() : null, fill2 != null ? fill2.getJsBase() : null, stroke != null ? stroke.getJsBase() : null, wrapQuotes(str), stroke2 != null ? stroke2.getJsBase() : null, number, legendItemIconType != null ? legendItemIconType.getJsBase() : null, number2, wrapQuotes(str2), wrapQuotes(str3)));
    }

    public LegendItemProvider(Boolean bool, Boolean bool2, Fill fill, PatternFill patternFill, Fill fill2, Stroke stroke, String str, Stroke stroke2, Number number, String str2, Number number2, String str3, String str4) {
        this.js.append(String.format(Locale.US, "{disabled:%s, iconEnabled: %s, iconFill: %s, iconHatchFill: %s, iconMarkerFill: %s, iconMarkerStroke: %s, iconMarkerType: %s, iconStroke: %s, iconTextSpacing: %s, iconType: %s, index: %s, meta: %s, text: %s, } ", bool, bool2, fill != null ? fill.getJsBase() : null, patternFill != null ? patternFill.getJsBase() : null, fill2 != null ? fill2.getJsBase() : null, stroke != null ? stroke.getJsBase() : null, wrapQuotes(str), stroke2 != null ? stroke2.getJsBase() : null, number, wrapQuotes(str2), number2, wrapQuotes(str3), wrapQuotes(str4)));
    }

    public LegendItemProvider(Boolean bool, Boolean bool2, Fill fill, HatchFill hatchFill, Fill fill2, Stroke stroke, MarkerType markerType, Stroke stroke2, Number number, LegendItemIconType legendItemIconType, Number number2, String str, String str2) {
        this.js.append(String.format(Locale.US, "{disabled:%s, iconEnabled: %s, iconFill: %s, iconHatchFill: %s, iconMarkerFill: %s, iconMarkerStroke: %s, iconMarkerType: %s, iconStroke: %s, iconTextSpacing: %s, iconType: %s, index: %s, meta: %s, text: %s, } ", bool, bool2, fill != null ? fill.getJsBase() : null, hatchFill != null ? hatchFill.getJsBase() : null, fill2 != null ? fill2.getJsBase() : null, stroke != null ? stroke.getJsBase() : null, markerType != null ? markerType.getJsBase() : null, stroke2 != null ? stroke2.getJsBase() : null, number, legendItemIconType != null ? legendItemIconType.getJsBase() : null, number2, wrapQuotes(str), wrapQuotes(str2)));
    }

    public LegendItemProvider(Boolean bool, Boolean bool2, Fill fill, HatchFill hatchFill, Fill fill2, Stroke stroke, MarkerType markerType, Stroke stroke2, Number number, String str, Number number2, String str2, String str3) {
        this.js.append(String.format(Locale.US, "{disabled:%s, iconEnabled: %s, iconFill: %s, iconHatchFill: %s, iconMarkerFill: %s, iconMarkerStroke: %s, iconMarkerType: %s, iconStroke: %s, iconTextSpacing: %s, iconType: %s, index: %s, meta: %s, text: %s, } ", bool, bool2, fill != null ? fill.getJsBase() : null, hatchFill != null ? hatchFill.getJsBase() : null, fill2 != null ? fill2.getJsBase() : null, stroke != null ? stroke.getJsBase() : null, markerType != null ? markerType.getJsBase() : null, stroke2 != null ? stroke2.getJsBase() : null, number, wrapQuotes(str), number2, wrapQuotes(str2), wrapQuotes(str3)));
    }

    public LegendItemProvider(Boolean bool, Boolean bool2, Fill fill, HatchFill hatchFill, Fill fill2, Stroke stroke, String str, Stroke stroke2, Number number, LegendItemIconType legendItemIconType, Number number2, String str2, String str3) {
        this.js.append(String.format(Locale.US, "{disabled:%s, iconEnabled: %s, iconFill: %s, iconHatchFill: %s, iconMarkerFill: %s, iconMarkerStroke: %s, iconMarkerType: %s, iconStroke: %s, iconTextSpacing: %s, iconType: %s, index: %s, meta: %s, text: %s, } ", bool, bool2, fill != null ? fill.getJsBase() : null, hatchFill != null ? hatchFill.getJsBase() : null, fill2 != null ? fill2.getJsBase() : null, stroke != null ? stroke.getJsBase() : null, wrapQuotes(str), stroke2 != null ? stroke2.getJsBase() : null, number, legendItemIconType != null ? legendItemIconType.getJsBase() : null, number2, wrapQuotes(str2), wrapQuotes(str3)));
    }

    public LegendItemProvider(Boolean bool, Boolean bool2, Fill fill, HatchFill hatchFill, Fill fill2, Stroke stroke, String str, Stroke stroke2, Number number, String str2, Number number2, String str3, String str4) {
        this.js.append(String.format(Locale.US, "{disabled:%s, iconEnabled: %s, iconFill: %s, iconHatchFill: %s, iconMarkerFill: %s, iconMarkerStroke: %s, iconMarkerType: %s, iconStroke: %s, iconTextSpacing: %s, iconType: %s, index: %s, meta: %s, text: %s, } ", bool, bool2, fill != null ? fill.getJsBase() : null, hatchFill != null ? hatchFill.getJsBase() : null, fill2 != null ? fill2.getJsBase() : null, stroke != null ? stroke.getJsBase() : null, wrapQuotes(str), stroke2 != null ? stroke2.getJsBase() : null, number, wrapQuotes(str2), number2, wrapQuotes(str3), wrapQuotes(str4)));
    }

    @Override // com.anychart.JsObject
    public String getJsBase() {
        return this.js.toString();
    }
}
