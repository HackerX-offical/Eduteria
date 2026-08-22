package com.anychart.palettes;

import com.amazonaws.services.s3.model.InstructionFileId;
import com.anychart.APIlib;
import com.anychart.chart.common.listener.ListenersInterface;
import com.anychart.core.Base;
import com.anychart.graphics.vector.HatchFill;
import com.anychart.graphics.vector.PatternFill;
import com.anychart.graphics.vector.hatchfill.HatchFillType;
import java.util.Locale;

/* JADX INFO: loaded from: classes4.dex */
public class HatchFills extends Base {
    protected HatchFills() {
    }

    public static HatchFills instantiate() {
        return new HatchFills("new anychart.palettes.hatchFills()");
    }

    public HatchFills(String str) {
        StringBuilder sb = new StringBuilder("hatchFills");
        int i = variableIndex + 1;
        variableIndex = i;
        this.jsBase = sb.append(i).toString();
        APIlib.getInstance().addJSLine(this.jsBase + " = " + str + ";");
    }

    @Override // com.anychart.core.Base, com.anychart.JsObject
    public String getJsBase() {
        return this.jsBase;
    }

    public HatchFill itemAt(Number number) {
        return new HatchFill(String.format(Locale.US, this.jsBase + ".itemAt(%s)", number));
    }

    public HatchFills itemAt(Number number, HatchFillType hatchFillType, String str, Number number2, Number number3) {
        APIlib.getInstance().addJSLine(String.format(Locale.US, this.jsBase + ".itemAt(%s, %s, %s, %s, %s);", number, hatchFillType != null ? hatchFillType.getJsBase() : null, wrapQuotes(str), number2, number3));
        return this;
    }

    public HatchFills itemAt(Number number, String str, String str2, Number number2, Number number3) {
        APIlib.getInstance().addJSLine(String.format(Locale.US, this.jsBase + ".itemAt(%s, %s, %s, %s, %s);", number, wrapQuotes(str), wrapQuotes(str2), number2, number3));
        return this;
    }

    public HatchFills itemAt(Number number, PatternFill patternFill) {
        APIlib.getInstance().addJSLine(String.format(Locale.US, this.jsBase + ".itemAt(%s, %s);", number, patternFill != null ? patternFill.getJsBase() : null));
        return this;
    }

    public HatchFills itemAt(Number number, HatchFill hatchFill) {
        APIlib.getInstance().addJSLine(String.format(Locale.US, this.jsBase + ".itemAt(%s, %s);", number, hatchFill != null ? hatchFill.getJsBase() : null));
        return this;
    }

    public HatchFills itemAt(Number number, Boolean bool) {
        APIlib.getInstance().addJSLine(String.format(Locale.US, this.jsBase + ".itemAt(%s, %s);", number, bool));
        return this;
    }

    public void items() {
        APIlib.getInstance().addJSLine(this.jsBase + ".items();");
    }

    public HatchFills items(HatchFill hatchFill, HatchFill hatchFill2) {
        APIlib.getInstance().addJSLine(String.format(Locale.US, this.jsBase + ".items(%s, %s);", hatchFill != null ? hatchFill.getJsBase() : null, hatchFill2 != null ? hatchFill2.getJsBase() : null));
        return this;
    }

    public HatchFills items(HatchFill hatchFill, HatchFillType hatchFillType) {
        APIlib.getInstance().addJSLine(String.format(Locale.US, this.jsBase + ".items(%s, %s);", hatchFill != null ? hatchFill.getJsBase() : null, hatchFillType != null ? hatchFillType.getJsBase() : null));
        return this;
    }

    public HatchFills items(HatchFill hatchFill, PatternFill patternFill) {
        APIlib.getInstance().addJSLine(String.format(Locale.US, this.jsBase + ".items(%s, %s);", hatchFill != null ? hatchFill.getJsBase() : null, patternFill != null ? patternFill.getJsBase() : null));
        return this;
    }

    public HatchFills items(HatchFillType hatchFillType, HatchFill hatchFill) {
        APIlib.getInstance().addJSLine(String.format(Locale.US, this.jsBase + ".items(%s, %s);", hatchFillType != null ? hatchFillType.getJsBase() : null, hatchFill != null ? hatchFill.getJsBase() : null));
        return this;
    }

    public HatchFills items(HatchFillType hatchFillType, HatchFillType hatchFillType2) {
        APIlib.getInstance().addJSLine(String.format(Locale.US, this.jsBase + ".items(%s, %s);", hatchFillType != null ? hatchFillType.getJsBase() : null, hatchFillType2 != null ? hatchFillType2.getJsBase() : null));
        return this;
    }

    public HatchFills items(HatchFillType hatchFillType, PatternFill patternFill) {
        APIlib.getInstance().addJSLine(String.format(Locale.US, this.jsBase + ".items(%s, %s);", hatchFillType != null ? hatchFillType.getJsBase() : null, patternFill != null ? patternFill.getJsBase() : null));
        return this;
    }

    public HatchFills items(PatternFill patternFill, HatchFill hatchFill) {
        APIlib.getInstance().addJSLine(String.format(Locale.US, this.jsBase + ".items(%s, %s);", patternFill != null ? patternFill.getJsBase() : null, hatchFill != null ? hatchFill.getJsBase() : null));
        return this;
    }

    public HatchFills items(PatternFill patternFill, HatchFillType hatchFillType) {
        APIlib.getInstance().addJSLine(String.format(Locale.US, this.jsBase + ".items(%s, %s);", patternFill != null ? patternFill.getJsBase() : null, hatchFillType != null ? hatchFillType.getJsBase() : null));
        return this;
    }

    public HatchFills items(PatternFill patternFill, PatternFill patternFill2) {
        APIlib.getInstance().addJSLine(String.format(Locale.US, this.jsBase + ".items(%s, %s);", patternFill != null ? patternFill.getJsBase() : null, patternFill2 != null ? patternFill2.getJsBase() : null));
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
