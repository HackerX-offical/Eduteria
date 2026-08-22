package com.anychart.scales;

import com.amazonaws.services.s3.model.InstructionFileId;
import com.anychart.APIlib;
import com.anychart.chart.common.listener.ListenersInterface;
import java.util.Arrays;
import java.util.Locale;

/* JADX INFO: loaded from: classes4.dex */
public class Geo extends com.anychart.core.Base {
    protected Geo() {
    }

    public static Geo instantiate() {
        return new Geo("new anychart.scales.geo()");
    }

    public Geo(String str) {
        StringBuilder sb = new StringBuilder("geo");
        int i = variableIndex + 1;
        variableIndex = i;
        this.jsBase = sb.append(i).toString();
        APIlib.getInstance().addJSLine(this.jsBase + " = " + str + ";");
    }

    @Override // com.anychart.core.Base, com.anychart.JsObject
    public String getJsBase() {
        return this.jsBase;
    }

    public Geo extendDataRange(Number number, Number number2, String str) {
        APIlib.getInstance().addJSLine(String.format(Locale.US, this.jsBase + ".extendDataRange(%s, %s, %s);", number, number2, wrapQuotes(str)));
        return this;
    }

    public void gap() {
        APIlib.getInstance().addJSLine(this.jsBase + ".gap();");
    }

    public Geo gap(Number number) {
        APIlib.getInstance().addJSLine(String.format(Locale.US, this.jsBase + ".gap(%s);", number));
        return this;
    }

    public void getType() {
        APIlib.getInstance().addJSLine(this.jsBase + ".getType();");
    }

    public void maxTicksCount() {
        APIlib.getInstance().addJSLine(this.jsBase + ".maxTicksCount();");
    }

    public Geo maxTicksCount(Number number) {
        APIlib.getInstance().addJSLine(String.format(Locale.US, this.jsBase + ".maxTicksCount(%s);", number));
        return this;
    }

    public void maximumX() {
        APIlib.getInstance().addJSLine(this.jsBase + ".maximumX();");
    }

    public Geo maximumX(Number number) {
        APIlib.getInstance().addJSLine(String.format(Locale.US, this.jsBase + ".maximumX(%s);", number));
        return this;
    }

    public void maximumY() {
        APIlib.getInstance().addJSLine(this.jsBase + ".maximumY();");
    }

    public Geo maximumY(Number number) {
        APIlib.getInstance().addJSLine(String.format(Locale.US, this.jsBase + ".maximumY(%s);", number));
        return this;
    }

    public void minimumX() {
        APIlib.getInstance().addJSLine(this.jsBase + ".minimumX();");
    }

    public Geo minimumX(Number number) {
        APIlib.getInstance().addJSLine(String.format(Locale.US, this.jsBase + ".minimumX(%s);", number));
        return this;
    }

    public void minimumY() {
        APIlib.getInstance().addJSLine(this.jsBase + ".minimumY();");
    }

    public Geo minimumY(Number number) {
        APIlib.getInstance().addJSLine(String.format(Locale.US, this.jsBase + ".minimumY(%s);", number));
        return this;
    }

    public void precision() {
        APIlib.getInstance().addJSLine(this.jsBase + ".precision();");
    }

    public Geo precision(Number[] numberArr) {
        APIlib.getInstance().addJSLine(String.format(Locale.US, this.jsBase + ".precision(%s);", Arrays.toString(numberArr)));
        return this;
    }

    public Geo precision(Number number, Number number2) {
        APIlib.getInstance().addJSLine(String.format(Locale.US, this.jsBase + ".precision(%s, %s);", number, number2));
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

    public GeoTicks xMinorTicks() {
        return new GeoTicks(this.jsBase + ".xMinorTicks()");
    }

    public Geo xMinorTicks(String str) {
        APIlib.getInstance().addJSLine(String.format(Locale.US, this.jsBase + ".xMinorTicks(%s);", wrapQuotes(str)));
        return this;
    }

    public Geo xMinorTicks(String[] strArr) {
        APIlib.getInstance().addJSLine(String.format(Locale.US, this.jsBase + ".xMinorTicks(%s);", arrayToStringWrapQuotes(strArr)));
        return this;
    }

    public GeoTicks xTicks() {
        return new GeoTicks(this.jsBase + ".xTicks()");
    }

    public Geo xTicks(String str) {
        APIlib.getInstance().addJSLine(String.format(Locale.US, this.jsBase + ".xTicks(%s);", wrapQuotes(str)));
        return this;
    }

    public Geo xTicks(String[] strArr) {
        APIlib.getInstance().addJSLine(String.format(Locale.US, this.jsBase + ".xTicks(%s);", arrayToStringWrapQuotes(strArr)));
        return this;
    }

    public GeoTicks yMinorTicks() {
        return new GeoTicks(this.jsBase + ".yMinorTicks()");
    }

    public Geo yMinorTicks(String str) {
        APIlib.getInstance().addJSLine(String.format(Locale.US, this.jsBase + ".yMinorTicks(%s);", wrapQuotes(str)));
        return this;
    }

    public Geo yMinorTicks(String[] strArr) {
        APIlib.getInstance().addJSLine(String.format(Locale.US, this.jsBase + ".yMinorTicks(%s);", arrayToStringWrapQuotes(strArr)));
        return this;
    }

    public GeoTicks yTicks() {
        return new GeoTicks(this.jsBase + ".yTicks()");
    }

    public Geo yTicks(String str) {
        APIlib.getInstance().addJSLine(String.format(Locale.US, this.jsBase + ".yTicks(%s);", wrapQuotes(str)));
        return this;
    }

    public Geo yTicks(String[] strArr) {
        APIlib.getInstance().addJSLine(String.format(Locale.US, this.jsBase + ".yTicks(%s);", arrayToStringWrapQuotes(strArr)));
        return this;
    }
}
