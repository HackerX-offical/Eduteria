package com.anychart.core.stock;

import com.amazonaws.services.s3.model.InstructionFileId;
import com.anychart.APIlib;
import com.anychart.chart.common.listener.ListenersInterface;
import com.anychart.core.Base;
import com.anychart.core.stock.grouping.Level;
import java.util.Locale;

/* JADX INFO: loaded from: classes5.dex */
public class Grouping extends Base {
    protected Grouping() {
    }

    public static Grouping instantiate() {
        return new Grouping("new anychart.core.stock.grouping()");
    }

    public Grouping(String str) {
        StringBuilder sb = new StringBuilder("grouping");
        int i = variableIndex + 1;
        variableIndex = i;
        this.jsBase = sb.append(i).toString();
        APIlib.getInstance().addJSLine(this.jsBase + " = " + str + ";");
    }

    @Override // com.anychart.core.Base, com.anychart.JsObject
    public String getJsBase() {
        return this.jsBase;
    }

    public void enabled() {
        APIlib.getInstance().addJSLine(this.jsBase + ".enabled();");
    }

    public Grouping enabled(Boolean bool) {
        APIlib.getInstance().addJSLine(String.format(Locale.US, this.jsBase + ".enabled(%s);", bool));
        return this;
    }

    public void forced() {
        APIlib.getInstance().addJSLine(this.jsBase + ".forced();");
    }

    public Grouping forced(Boolean bool) {
        APIlib.getInstance().addJSLine(String.format(Locale.US, this.jsBase + ".forced(%s);", bool));
        return this;
    }

    public void getCurrentDataInterval() {
        APIlib.getInstance().addJSLine(this.jsBase + ".getCurrentDataInterval();");
    }

    public void isGrouped() {
        APIlib.getInstance().addJSLine(this.jsBase + ".isGrouped();");
    }

    public void levels() {
        APIlib.getInstance().addJSLine(this.jsBase + ".levels();");
    }

    public Grouping levels(Level level) {
        APIlib.getInstance().addJSLine(String.format(Locale.US, this.jsBase + ".levels(%s);", level != null ? level.getJsBase() : null));
        return this;
    }

    public Grouping levels(String[] strArr) {
        APIlib.getInstance().addJSLine(String.format(Locale.US, this.jsBase + ".levels(%s);", arrayToStringWrapQuotes(strArr)));
        return this;
    }

    public void maxVisiblePoints() {
        APIlib.getInstance().addJSLine(this.jsBase + ".maxVisiblePoints();");
    }

    public Grouping maxVisiblePoints(Number number) {
        APIlib.getInstance().addJSLine(String.format(Locale.US, this.jsBase + ".maxVisiblePoints(%s);", number));
        return this;
    }

    public void minPixPerPoint() {
        APIlib.getInstance().addJSLine(this.jsBase + ".minPixPerPoint();");
    }

    public Grouping minPixPerPoint(Number number) {
        APIlib.getInstance().addJSLine(String.format(Locale.US, this.jsBase + ".minPixPerPoint(%s);", number));
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
