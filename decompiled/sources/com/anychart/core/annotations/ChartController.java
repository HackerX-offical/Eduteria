package com.anychart.core.annotations;

import com.amazonaws.services.s3.model.InstructionFileId;
import com.anychart.APIlib;
import com.anychart.chart.common.listener.ListenersInterface;
import com.anychart.enums.AnnotationTypes;
import java.util.Locale;

/* JADX INFO: loaded from: classes5.dex */
public class ChartController extends com.anychart.core.Base {
    protected ChartController() {
    }

    public static ChartController instantiate() {
        return new ChartController("new anychart.core.annotations.chartController()");
    }

    public ChartController(String str) {
        StringBuilder sb = new StringBuilder("chartController");
        int i = variableIndex + 1;
        variableIndex = i;
        this.jsBase = sb.append(i).toString();
        APIlib.getInstance().addJSLine(this.jsBase + " = " + str + ";");
    }

    @Override // com.anychart.core.Base, com.anychart.JsObject
    public String getJsBase() {
        return this.jsBase;
    }

    public void cancelDrawing() {
        APIlib.getInstance().addJSLine(this.jsBase + ".cancelDrawing();");
    }

    public Base getSelectedAnnotation() {
        return new Base(this.jsBase + ".getSelectedAnnotation()");
    }

    public ChartController removeAllAnnotations() {
        APIlib.getInstance().addJSLine(this.jsBase + ".removeAllAnnotations();");
        return this;
    }

    @Override // com.anychart.core.Base
    public void removeAllListeners(String str) {
        APIlib.getInstance().addJSLine(String.format(Locale.US, this.jsBase + ".removeAllListeners(%s);", wrapQuotes(str)));
    }

    public ChartController removeAnnotation(Base base) {
        APIlib.getInstance().addJSLine(String.format(Locale.US, this.jsBase + ".removeAnnotation(%s);", base != null ? base.getJsBase() : null));
        return this;
    }

    public ChartController select(Base base) {
        APIlib.getInstance().addJSLine(String.format(Locale.US, this.jsBase + ".select(%s);", base != null ? base.getJsBase() : null));
        return this;
    }

    public Base startDrawing(AnnotationTypes annotationTypes) {
        return new Base(String.format(Locale.US, this.jsBase + ".startDrawing(%s)", annotationTypes != null ? annotationTypes.getJsBase() : null));
    }

    public Base startDrawing(String str) {
        return new Base(String.format(Locale.US, this.jsBase + ".startDrawing(%s)", wrapQuotes(str)));
    }

    public Base startDrawing(AnnotationJSONFormat annotationJSONFormat) {
        return new Base(String.format(Locale.US, this.jsBase + ".startDrawing(%s)", annotationJSONFormat != null ? annotationJSONFormat.getJsBase() : null));
    }

    @Override // com.anychart.core.Base
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

    @Override // com.anychart.core.Base
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

    @Override // com.anychart.core.Base
    public void unlistenByKey(String str) {
        APIlib.getInstance().addJSLine(String.format(Locale.US, this.jsBase + ".unlistenByKey(%s);", wrapQuotes(str)));
    }

    public ChartController unselect() {
        APIlib.getInstance().addJSLine(this.jsBase + ".unselect();");
        return this;
    }
}
