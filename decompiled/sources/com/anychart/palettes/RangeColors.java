package com.anychart.palettes;

import com.amazonaws.services.s3.model.InstructionFileId;
import com.anychart.APIlib;
import com.anychart.JsObject;
import com.anychart.chart.common.listener.ListenersInterface;
import com.anychart.core.Base;
import com.anychart.graphics.vector.GradientKey;
import com.anychart.graphics.vector.LinearGradientFill;
import com.anychart.graphics.vector.RadialGradientFill;
import com.anychart.graphics.vector.SolidFill;
import java.util.Locale;

/* JADX INFO: loaded from: classes4.dex */
public class RangeColors extends Base {
    protected RangeColors() {
    }

    public static RangeColors instantiate() {
        return new RangeColors("new anychart.palettes.rangeColors()");
    }

    public RangeColors(String str) {
        StringBuilder sb = new StringBuilder("rangeColors");
        int i = variableIndex + 1;
        variableIndex = i;
        this.jsBase = sb.append(i).toString();
        APIlib.getInstance().addJSLine(this.jsBase + " = " + str + ";");
    }

    @Override // com.anychart.core.Base, com.anychart.JsObject
    public String getJsBase() {
        return this.jsBase;
    }

    public void count() {
        APIlib.getInstance().addJSLine(this.jsBase + ".count();");
    }

    public RangeColors count(Number number) {
        APIlib.getInstance().addJSLine(String.format(Locale.US, this.jsBase + ".count(%s);", number));
        return this;
    }

    public void itemAt(Number number) {
        APIlib.getInstance().addJSLine(String.format(Locale.US, this.jsBase + ".itemAt(%s);", number));
    }

    public RangeColors itemAt(Number number, SolidFill solidFill) {
        APIlib.getInstance().addJSLine(String.format(Locale.US, this.jsBase + ".itemAt(%s, %s);", number, solidFill != null ? solidFill.getJsBase() : null));
        return this;
    }

    public void items() {
        APIlib.getInstance().addJSLine(this.jsBase + ".items();");
    }

    public RangeColors items(String[] strArr, SolidFill solidFill) {
        APIlib.getInstance().addJSLine(String.format(Locale.US, this.jsBase + ".items(%s, %s);", arrayToStringWrapQuotes(strArr), solidFill != null ? solidFill.getJsBase() : null));
        return this;
    }

    public RangeColors items(String[] strArr, String str) {
        APIlib.getInstance().addJSLine(String.format(Locale.US, this.jsBase + ".items(%s, %s);", arrayToStringWrapQuotes(strArr), wrapQuotes(str)));
        return this;
    }

    public RangeColors items(LinearGradientFill linearGradientFill, SolidFill solidFill) {
        APIlib.getInstance().addJSLine(String.format(Locale.US, this.jsBase + ".items(%s, %s);", linearGradientFill != null ? linearGradientFill.getJsBase() : null, solidFill != null ? solidFill.getJsBase() : null));
        return this;
    }

    public RangeColors items(LinearGradientFill linearGradientFill, String str) {
        APIlib.getInstance().addJSLine(String.format(Locale.US, this.jsBase + ".items(%s, %s);", linearGradientFill != null ? linearGradientFill.getJsBase() : null, wrapQuotes(str)));
        return this;
    }

    public RangeColors items(RadialGradientFill radialGradientFill, SolidFill solidFill) {
        APIlib.getInstance().addJSLine(String.format(Locale.US, this.jsBase + ".items(%s, %s);", radialGradientFill != null ? radialGradientFill.getJsBase() : null, solidFill != null ? solidFill.getJsBase() : null));
        return this;
    }

    public RangeColors items(RadialGradientFill radialGradientFill, String str) {
        APIlib.getInstance().addJSLine(String.format(Locale.US, this.jsBase + ".items(%s, %s);", radialGradientFill != null ? radialGradientFill.getJsBase() : null, wrapQuotes(str)));
        return this;
    }

    public RangeColors items(GradientKey[] gradientKeyArr, SolidFill solidFill) {
        APIlib.getInstance().addJSLine(String.format(Locale.US, this.jsBase + ".items(%s, %s);", arrayToString((JsObject[]) gradientKeyArr), solidFill != null ? solidFill.getJsBase() : null));
        return this;
    }

    public RangeColors items(GradientKey[] gradientKeyArr, String str) {
        APIlib.getInstance().addJSLine(String.format(Locale.US, this.jsBase + ".items(%s, %s);", arrayToString((JsObject[]) gradientKeyArr), wrapQuotes(str)));
        return this;
    }

    public RangeColors items(SolidFill solidFill, SolidFill solidFill2) {
        APIlib.getInstance().addJSLine(String.format(Locale.US, this.jsBase + ".items(%s, %s);", solidFill != null ? solidFill.getJsBase() : null, solidFill2 != null ? solidFill2.getJsBase() : null));
        return this;
    }

    public RangeColors items(SolidFill solidFill, String str) {
        APIlib.getInstance().addJSLine(String.format(Locale.US, this.jsBase + ".items(%s, %s);", solidFill != null ? solidFill.getJsBase() : null, wrapQuotes(str)));
        return this;
    }

    public RangeColors items(String str, SolidFill solidFill) {
        APIlib.getInstance().addJSLine(String.format(Locale.US, this.jsBase + ".items(%s, %s);", wrapQuotes(str), solidFill != null ? solidFill.getJsBase() : null));
        return this;
    }

    public RangeColors items(String str, String str2) {
        APIlib.getInstance().addJSLine(String.format(Locale.US, this.jsBase + ".items(%s, %s);", wrapQuotes(str), wrapQuotes(str2)));
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
