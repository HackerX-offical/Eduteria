package com.anychart.scales;

import com.amazonaws.services.s3.model.InstructionFileId;
import com.anychart.APIlib;
import com.anychart.JsObject;
import com.anychart.chart.common.listener.ListenersInterface;
import com.anychart.enums.Interval;
import com.anychart.scales.calendar.Availability;
import java.util.Arrays;
import java.util.Locale;

/* JADX INFO: loaded from: classes4.dex */
public class Calendar extends com.anychart.core.Base {
    protected Calendar() {
    }

    public static Calendar instantiate() {
        return new Calendar("new anychart.scales.calendar()");
    }

    public Calendar(String str) {
        StringBuilder sb = new StringBuilder("calendar");
        int i = variableIndex + 1;
        variableIndex = i;
        this.jsBase = sb.append(i).toString();
        APIlib.getInstance().addJSLine(this.jsBase + " = " + str + ";");
    }

    @Override // com.anychart.core.Base, com.anychart.JsObject
    public String getJsBase() {
        return this.jsBase;
    }

    public void availabilities() {
        APIlib.getInstance().addJSLine(this.jsBase + ".availabilities();");
    }

    public Calendar availabilities(Availability[] availabilityArr) {
        APIlib.getInstance().addJSLine(String.format(Locale.US, this.jsBase + ".availabilities(%s);", arrayToString((JsObject[]) availabilityArr)));
        return this;
    }

    public void getWorkingSchedule(Number number, Number number2, Interval interval, Number number3) {
        APIlib.getInstance().addJSLine(String.format(Locale.US, this.jsBase + ".getWorkingSchedule(%s, %s, %s, %s);", number, number2, interval != null ? interval.getJsBase() : null, number3));
    }

    public void getWorkingSchedule(Number number, Number number2, String str, Number number3) {
        APIlib.getInstance().addJSLine(String.format(Locale.US, this.jsBase + ".getWorkingSchedule(%s, %s, %s, %s);", number, number2, wrapQuotes(str), number3));
    }

    @Override // com.anychart.core.Base
    public void removeAllListeners(String str) {
        APIlib.getInstance().addJSLine(String.format(Locale.US, this.jsBase + ".removeAllListeners(%s);", wrapQuotes(str)));
    }

    public void timezoneOffset() {
        APIlib.getInstance().addJSLine(this.jsBase + ".timezoneOffset();");
    }

    public Calendar timezoneOffset(Number number) {
        APIlib.getInstance().addJSLine(String.format(Locale.US, this.jsBase + ".timezoneOffset(%s);", number));
        return this;
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

    public void weekendRange() {
        APIlib.getInstance().addJSLine(this.jsBase + ".weekendRange();");
    }

    public Calendar weekendRange(Number[] numberArr) {
        APIlib.getInstance().addJSLine(String.format(Locale.US, this.jsBase + ".weekendRange(%s);", Arrays.toString(numberArr)));
        return this;
    }
}
