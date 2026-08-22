package com.anychart.scales;

import com.amazonaws.services.s3.model.InstructionFileId;
import com.anychart.APIlib;
import com.anychart.chart.common.listener.ListenersInterface;
import com.anychart.enums.Interval;
import java.util.Locale;

/* JADX INFO: loaded from: classes4.dex */
public class DateTimeWithCalendar extends ScatterBase {
    protected DateTimeWithCalendar() {
    }

    public static DateTimeWithCalendar instantiate() {
        return new DateTimeWithCalendar("new anychart.scales.dateTimeWithCalendar()");
    }

    public DateTimeWithCalendar(String str) {
        StringBuilder sb = new StringBuilder("dateTimeWithCalendar");
        int i = variableIndex + 1;
        variableIndex = i;
        this.jsBase = sb.append(i).toString();
        APIlib.getInstance().addJSLine(this.jsBase + " = " + str + ";");
    }

    @Override // com.anychart.scales.ScatterBase, com.anychart.scales.Base, com.anychart.JsObject
    public String getJsBase() {
        return this.jsBase;
    }

    public Calendar calendar() {
        return new Calendar(this.jsBase + ".calendar()");
    }

    public DateTimeWithCalendar calendar(Calendar calendar) {
        APIlib.getInstance().addJSLine(String.format(Locale.US, this.jsBase + ".calendar(%s);", calendar != null ? calendar.getJsBase() : null));
        return this;
    }

    public void count() {
        APIlib.getInstance().addJSLine(this.jsBase + ".count();");
    }

    public DateTimeWithCalendar count(Number number) {
        APIlib.getInstance().addJSLine(String.format(Locale.US, this.jsBase + ".count(%s);", number));
        return this;
    }

    public void dateToPix(Number number) {
        APIlib.getInstance().addJSLine(String.format(Locale.US, this.jsBase + ".dateToPix(%s);", number));
    }

    @Override // com.anychart.scales.ScatterBase
    public DateTimeWithCalendar extendDataRange(String str) {
        APIlib.getInstance().addJSLine(String.format(Locale.US, this.jsBase + ".extendDataRange(%s);", wrapQuotes(str)));
        return this;
    }

    @Override // com.anychart.scales.ScatterBase, com.anychart.scales.Base
    public void finishAutoCalc(Boolean bool) {
        APIlib.getInstance().addJSLine(String.format(Locale.US, this.jsBase + ".finishAutoCalc(%s);", bool));
    }

    public void getTicks(Number number, Number number2, Interval interval, Number number3) {
        APIlib.getInstance().addJSLine(String.format(Locale.US, this.jsBase + ".getTicks(%s, %s, %s, %s);", number, number2, interval != null ? interval.getJsBase() : null, number3));
    }

    public void getTicks(Number number, Number number2, String str, Number number3) {
        APIlib.getInstance().addJSLine(String.format(Locale.US, this.jsBase + ".getTicks(%s, %s, %s, %s);", number, number2, wrapQuotes(str), number3));
    }

    @Override // com.anychart.scales.ScatterBase, com.anychart.scales.Base
    public void getType() {
        APIlib.getInstance().addJSLine(this.jsBase + ".getType();");
    }

    @Override // com.anychart.scales.ScatterBase
    public void inverseTransform(Number number) {
        APIlib.getInstance().addJSLine(String.format(Locale.US, this.jsBase + ".inverseTransform(%s);", number));
    }

    @Override // com.anychart.scales.ScatterBase, com.anychart.scales.Base
    public void inverted() {
        APIlib.getInstance().addJSLine(this.jsBase + ".inverted();");
    }

    @Override // com.anychart.scales.ScatterBase, com.anychart.scales.Base
    public DateTimeWithCalendar inverted(Boolean bool) {
        APIlib.getInstance().addJSLine(String.format(Locale.US, this.jsBase + ".inverted(%s);", bool));
        return this;
    }

    @Override // com.anychart.scales.ScatterBase
    public void maximum() {
        APIlib.getInstance().addJSLine(this.jsBase + ".maximum();");
    }

    @Override // com.anychart.scales.ScatterBase
    public DateTimeWithCalendar maximum(Number number) {
        APIlib.getInstance().addJSLine(String.format(Locale.US, this.jsBase + ".maximum(%s);", number));
        return this;
    }

    public void maximumGap() {
        APIlib.getInstance().addJSLine(this.jsBase + ".maximumGap();");
    }

    public DateTime maximumGap(Number number) {
        return new DateTime(String.format(Locale.US, this.jsBase + ".maximumGap(%s)", number));
    }

    @Override // com.anychart.scales.ScatterBase
    public void minimum() {
        APIlib.getInstance().addJSLine(this.jsBase + ".minimum();");
    }

    @Override // com.anychart.scales.ScatterBase
    public DateTimeWithCalendar minimum(Number number) {
        APIlib.getInstance().addJSLine(String.format(Locale.US, this.jsBase + ".minimum(%s);", number));
        return this;
    }

    public void minimumGap() {
        APIlib.getInstance().addJSLine(this.jsBase + ".minimumGap();");
    }

    public DateTime minimumGap(Number number) {
        return new DateTime(String.format(Locale.US, this.jsBase + ".minimumGap(%s)", number));
    }

    public void pixToDate(Number number) {
        APIlib.getInstance().addJSLine(String.format(Locale.US, this.jsBase + ".pixToDate(%s);", number));
    }

    @Override // com.anychart.scales.ScatterBase, com.anychart.scales.Base
    public void removeAllListeners(String str) {
        APIlib.getInstance().addJSLine(String.format(Locale.US, this.jsBase + ".removeAllListeners(%s);", wrapQuotes(str)));
    }

    public void skipHolidays() {
        APIlib.getInstance().addJSLine(this.jsBase + ".skipHolidays();");
    }

    public DateTimeWithCalendar skipHolidays(Boolean bool) {
        APIlib.getInstance().addJSLine(String.format(Locale.US, this.jsBase + ".skipHolidays(%s);", bool));
        return this;
    }

    public void softMaximum() {
        APIlib.getInstance().addJSLine(this.jsBase + ".softMaximum();");
    }

    public DateTime softMaximum(Number number) {
        return new DateTime(String.format(Locale.US, this.jsBase + ".softMaximum(%s)", number));
    }

    public void softMinimum() {
        APIlib.getInstance().addJSLine(this.jsBase + ".softMinimum();");
    }

    public DateTime softMinimum(Number number) {
        return new DateTime(String.format(Locale.US, this.jsBase + ".softMinimum(%s)", number));
    }

    @Override // com.anychart.scales.ScatterBase, com.anychart.scales.Base
    public DateTimeWithCalendar startAutoCalc() {
        APIlib.getInstance().addJSLine(this.jsBase + ".startAutoCalc();");
        return this;
    }

    public void startDate() {
        APIlib.getInstance().addJSLine(this.jsBase + ".startDate();");
    }

    public DateTimeWithCalendar startDate(Number number) {
        APIlib.getInstance().addJSLine(String.format(Locale.US, this.jsBase + ".startDate(%s);", number));
        return this;
    }

    @Override // com.anychart.scales.ScatterBase
    public void transform(String str) {
        APIlib.getInstance().addJSLine(String.format(Locale.US, this.jsBase + ".transform(%s);", wrapQuotes(str)));
    }

    public void unit() {
        APIlib.getInstance().addJSLine(this.jsBase + ".unit();");
    }

    public DateTimeWithCalendar unit(Interval interval) {
        APIlib.getInstance().addJSLine(String.format(Locale.US, this.jsBase + ".unit(%s);", interval != null ? interval.getJsBase() : null));
        return this;
    }

    public DateTimeWithCalendar unit(String str) {
        APIlib.getInstance().addJSLine(String.format(Locale.US, this.jsBase + ".unit(%s);", wrapQuotes(str)));
        return this;
    }

    public void unitPixSize() {
        APIlib.getInstance().addJSLine(this.jsBase + ".unitPixSize();");
    }

    public DateTimeWithCalendar unitPixSize(Number number) {
        APIlib.getInstance().addJSLine(String.format(Locale.US, this.jsBase + ".unitPixSize(%s);", number));
        return this;
    }

    public DateTimeWithCalendar unitPixSize(String str) {
        APIlib.getInstance().addJSLine(String.format(Locale.US, this.jsBase + ".unitPixSize(%s);", wrapQuotes(str)));
        return this;
    }

    @Override // com.anychart.scales.ScatterBase, com.anychart.scales.Base
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

    @Override // com.anychart.scales.ScatterBase, com.anychart.scales.Base
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

    @Override // com.anychart.scales.ScatterBase, com.anychart.scales.Base
    public void unlistenByKey(String str) {
        APIlib.getInstance().addJSLine(String.format(Locale.US, this.jsBase + ".unlistenByKey(%s);", wrapQuotes(str)));
    }

    @Override // com.anychart.scales.ScatterBase
    public void alignMaximum() {
        APIlib.getInstance().addJSLine(this.jsBase + ".alignMaximum();");
    }

    @Override // com.anychart.scales.ScatterBase
    public DateTimeWithCalendar alignMaximum(Boolean bool) {
        APIlib.getInstance().addJSLine(String.format(Locale.US, this.jsBase + ".alignMaximum(%s);", bool));
        return this;
    }

    @Override // com.anychart.scales.ScatterBase
    public void alignMinimum() {
        APIlib.getInstance().addJSLine(this.jsBase + ".alignMinimum();");
    }

    @Override // com.anychart.scales.ScatterBase
    public DateTimeWithCalendar alignMinimum(Boolean bool) {
        APIlib.getInstance().addJSLine(String.format(Locale.US, this.jsBase + ".alignMinimum(%s);", bool));
        return this;
    }

    @Override // com.anychart.scales.ScatterBase
    public void maxTicksCount() {
        APIlib.getInstance().addJSLine(this.jsBase + ".maxTicksCount();");
    }

    @Override // com.anychart.scales.ScatterBase
    public DateTimeWithCalendar maxTicksCount(Number number) {
        APIlib.getInstance().addJSLine(String.format(Locale.US, this.jsBase + ".maxTicksCount(%s);", number));
        return this;
    }
}
