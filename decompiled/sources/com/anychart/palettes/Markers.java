package com.anychart.palettes;

import com.amazonaws.services.s3.model.InstructionFileId;
import com.anychart.APIlib;
import com.anychart.chart.common.listener.ListenersInterface;
import com.anychart.core.Base;
import com.anychart.enums.BulletMarkerType;
import com.anychart.enums.MarkerType;
import java.util.Locale;

/* JADX INFO: loaded from: classes4.dex */
public class Markers extends Base {
    protected Markers() {
    }

    public static Markers instantiate() {
        return new Markers("new anychart.palettes.markers()");
    }

    public Markers(String str) {
        StringBuilder sb = new StringBuilder("markers");
        int i = variableIndex + 1;
        variableIndex = i;
        this.jsBase = sb.append(i).toString();
        APIlib.getInstance().addJSLine(this.jsBase + " = " + str + ";");
    }

    @Override // com.anychart.core.Base, com.anychart.JsObject
    public String getJsBase() {
        return this.jsBase;
    }

    public void itemAt(Number number) {
        APIlib.getInstance().addJSLine(String.format(Locale.US, this.jsBase + ".itemAt(%s);", number));
    }

    public Markers itemAt(Number number, MarkerType markerType) {
        APIlib.getInstance().addJSLine(String.format(Locale.US, this.jsBase + ".itemAt(%s, %s);", number, markerType != null ? markerType.getJsBase() : null));
        return this;
    }

    public Markers itemAt(Number number, BulletMarkerType bulletMarkerType) {
        APIlib.getInstance().addJSLine(String.format(Locale.US, this.jsBase + ".itemAt(%s, %s);", number, bulletMarkerType != null ? bulletMarkerType.getJsBase() : null));
        return this;
    }

    public Markers itemAt(Number number, String str) {
        APIlib.getInstance().addJSLine(String.format(Locale.US, this.jsBase + ".itemAt(%s, %s);", number, wrapQuotes(str)));
        return this;
    }

    public void items() {
        APIlib.getInstance().addJSLine(this.jsBase + ".items();");
    }

    public Markers items(String[] strArr, String str) {
        APIlib.getInstance().addJSLine(String.format(Locale.US, this.jsBase + ".items(%s, %s);", arrayToStringWrapQuotes(strArr), wrapQuotes(str)));
        return this;
    }

    public Markers items(String str, String str2) {
        APIlib.getInstance().addJSLine(String.format(Locale.US, this.jsBase + ".items(%s, %s);", wrapQuotes(str), wrapQuotes(str2)));
        return this;
    }

    public Markers items(MarkerType markerType, String str) {
        APIlib.getInstance().addJSLine(String.format(Locale.US, this.jsBase + ".items(%s, %s);", markerType != null ? markerType.getJsBase() : null, wrapQuotes(str)));
        return this;
    }

    public Markers items(BulletMarkerType bulletMarkerType, String str) {
        APIlib.getInstance().addJSLine(String.format(Locale.US, this.jsBase + ".items(%s, %s);", bulletMarkerType != null ? bulletMarkerType.getJsBase() : null, wrapQuotes(str)));
        return this;
    }

    @Override // com.anychart.core.Base
    public void removeAllListeners(String str) {
        APIlib.getInstance().addJSLine(String.format(Locale.US, this.jsBase + ".removeAllListeners(%s);", wrapQuotes(str)));
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
}
