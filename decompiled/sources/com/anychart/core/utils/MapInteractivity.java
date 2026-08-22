package com.anychart.core.utils;

import com.amazonaws.services.s3.model.InstructionFileId;
import com.anychart.APIlib;
import com.anychart.chart.common.listener.ListenersInterface;
import com.anychart.enums.HoverMode;
import com.anychart.enums.SelectionMode;
import java.util.Locale;

/* JADX INFO: loaded from: classes5.dex */
public class MapInteractivity extends Interactivity {
    protected MapInteractivity() {
    }

    public static MapInteractivity instantiate() {
        return new MapInteractivity("new anychart.core.utils.mapInteractivity()");
    }

    public MapInteractivity(String str) {
        StringBuilder sb = new StringBuilder("mapInteractivity");
        int i = variableIndex + 1;
        variableIndex = i;
        this.jsBase = sb.append(i).toString();
        APIlib.getInstance().addJSLine(this.jsBase + " = " + str + ";");
    }

    @Override // com.anychart.core.utils.Interactivity, com.anychart.core.Base, com.anychart.JsObject
    public String getJsBase() {
        return this.jsBase;
    }

    @Override // com.anychart.core.utils.Interactivity
    public MapInteractivity allowMultiSeriesSelection(Boolean bool) {
        APIlib.getInstance().addJSLine(String.format(Locale.US, this.jsBase + ".allowMultiSeriesSelection(%s);", bool));
        return this;
    }

    public void copyFormat() {
        APIlib.getInstance().addJSLine(this.jsBase + ".copyFormat();");
    }

    public MapInteractivity copyFormat(String str) {
        APIlib.getInstance().addJSLine(String.format(Locale.US, this.jsBase + ".copyFormat(%s);", wrapQuotes(str)));
        return this;
    }

    public void drag() {
        APIlib.getInstance().addJSLine(this.jsBase + ".drag();");
    }

    public MapInteractivity drag(Boolean bool) {
        APIlib.getInstance().addJSLine(String.format(Locale.US, this.jsBase + ".drag(%s);", bool));
        return this;
    }

    @Override // com.anychart.core.utils.Interactivity
    public void hoverMode() {
        APIlib.getInstance().addJSLine(this.jsBase + ".hoverMode();");
    }

    @Override // com.anychart.core.utils.Interactivity
    public MapInteractivity hoverMode(HoverMode hoverMode) {
        APIlib.getInstance().addJSLine(String.format(Locale.US, this.jsBase + ".hoverMode(%s);", hoverMode != null ? hoverMode.getJsBase() : null));
        return this;
    }

    @Override // com.anychart.core.utils.Interactivity
    public MapInteractivity hoverMode(String str) {
        APIlib.getInstance().addJSLine(String.format(Locale.US, this.jsBase + ".hoverMode(%s);", wrapQuotes(str)));
        return this;
    }

    public void keyboardZoomAndMove() {
        APIlib.getInstance().addJSLine(this.jsBase + ".keyboardZoomAndMove();");
    }

    public MapInteractivity keyboardZoomAndMove(Boolean bool) {
        APIlib.getInstance().addJSLine(String.format(Locale.US, this.jsBase + ".keyboardZoomAndMove(%s);", bool));
        return this;
    }

    public void mouseWheel() {
        APIlib.getInstance().addJSLine(this.jsBase + ".mouseWheel();");
    }

    public MapInteractivity mouseWheel(Boolean bool) {
        APIlib.getInstance().addJSLine(String.format(Locale.US, this.jsBase + ".mouseWheel(%s);", bool));
        return this;
    }

    @Override // com.anychart.core.utils.Interactivity
    public void multiSelectOnClick() {
        APIlib.getInstance().addJSLine(this.jsBase + ".multiSelectOnClick();");
    }

    @Override // com.anychart.core.utils.Interactivity
    public MapInteractivity multiSelectOnClick(Boolean bool) {
        APIlib.getInstance().addJSLine(String.format(Locale.US, this.jsBase + ".multiSelectOnClick(%s);", bool));
        return this;
    }

    @Override // com.anychart.core.utils.Interactivity, com.anychart.core.Base
    public void removeAllListeners(String str) {
        APIlib.getInstance().addJSLine(String.format(Locale.US, this.jsBase + ".removeAllListeners(%s);", wrapQuotes(str)));
    }

    @Override // com.anychart.core.utils.Interactivity
    public void selectionMode() {
        APIlib.getInstance().addJSLine(this.jsBase + ".selectionMode();");
    }

    @Override // com.anychart.core.utils.Interactivity
    public MapInteractivity selectionMode(SelectionMode selectionMode) {
        APIlib.getInstance().addJSLine(String.format(Locale.US, this.jsBase + ".selectionMode(%s);", selectionMode != null ? selectionMode.getJsBase() : null));
        return this;
    }

    @Override // com.anychart.core.utils.Interactivity
    public MapInteractivity selectionMode(String str) {
        APIlib.getInstance().addJSLine(String.format(Locale.US, this.jsBase + ".selectionMode(%s);", wrapQuotes(str)));
        return this;
    }

    @Override // com.anychart.core.utils.Interactivity
    public void spotRadius() {
        APIlib.getInstance().addJSLine(this.jsBase + ".spotRadius();");
    }

    @Override // com.anychart.core.utils.Interactivity
    public MapInteractivity spotRadius(Number number) {
        APIlib.getInstance().addJSLine(String.format(Locale.US, this.jsBase + ".spotRadius(%s);", number));
        return this;
    }

    @Override // com.anychart.core.utils.Interactivity, com.anychart.core.Base
    public void setOnClickListener(ListenersInterface.OnClickListener onClickListener) {
        StringBuilder sb = new StringBuilder();
        sb.append(this.jsBase).append(".listen('pointClick', function(e) {");
        if (onClickListener.getFields() != null) {
            sb.append("var result = ");
            for (String str : onClickListener.getFields()) {
                sb.append(String.format(Locale.US, "'%1$s' + ':' + e.point.get('%1$s') + ',' +", str));
            }
            sb.setLength(sb.length() - 8);
            sb.append(";");
            sb.append("android.onClick(result);");
        } else {
            sb.append("android.onClick(null);");
        }
        sb.append("});");
        ListenersInterface.getInstance().setOnClickListener(onClickListener);
        APIlib.getInstance().addJSLine(sb.toString());
    }

    @Override // com.anychart.core.utils.Interactivity, com.anychart.core.Base
    public void setOnClickListener(ListenersInterface.OnClickListener onClickListener, String str, String str2) {
        StringBuilder sb = new StringBuilder();
        sb.append(this.jsBase).append(String.format(Locale.US, ".listen('%1$s', function(e) {", str));
        if (onClickListener.getFields() != null) {
            String str3 = str2 != null ? str2 + InstructionFileId.DOT : "";
            sb.append("var result = ");
            for (String str4 : onClickListener.getFields()) {
                sb.append(String.format(Locale.US, "'%1$s' + ':' + e.%2$s%1$s + ',' +", str4, str3));
            }
            sb.setLength(sb.length() - 8);
            sb.append(";");
            sb.append("android.onClick(result);");
        } else {
            sb.append("android.onClick(null);");
        }
        sb.append("});");
        ListenersInterface.getInstance().setOnClickListener(onClickListener);
        APIlib.getInstance().addJSLine(sb.toString());
    }

    @Override // com.anychart.core.utils.Interactivity, com.anychart.core.Base
    public void unlistenByKey(String str) {
        APIlib.getInstance().addJSLine(String.format(Locale.US, this.jsBase + ".unlistenByKey(%s);", wrapQuotes(str)));
    }

    @Override // com.anychart.core.utils.Interactivity
    public void unselectOnClickOutOfPoint() {
        APIlib.getInstance().addJSLine(this.jsBase + ".unselectOnClickOutOfPoint();");
    }

    @Override // com.anychart.core.utils.Interactivity
    public MapInteractivity unselectOnClickOutOfPoint(Boolean bool) {
        APIlib.getInstance().addJSLine(String.format(Locale.US, this.jsBase + ".unselectOnClickOutOfPoint(%s);", bool));
        return this;
    }

    public void zoomOnDoubleClick() {
        APIlib.getInstance().addJSLine(this.jsBase + ".zoomOnDoubleClick();");
    }

    public MapInteractivity zoomOnDoubleClick(Boolean bool) {
        APIlib.getInstance().addJSLine(String.format(Locale.US, this.jsBase + ".zoomOnDoubleClick(%s);", bool));
        return this;
    }

    public void zoomOnMouseWheel() {
        APIlib.getInstance().addJSLine(this.jsBase + ".zoomOnMouseWheel();");
    }

    public MapInteractivity zoomOnMouseWheel(Boolean bool) {
        APIlib.getInstance().addJSLine(String.format(Locale.US, this.jsBase + ".zoomOnMouseWheel(%s);", bool));
        return this;
    }
}
