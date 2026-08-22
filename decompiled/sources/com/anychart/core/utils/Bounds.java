package com.anychart.core.utils;

import com.amazonaws.services.s3.model.InstructionFileId;
import com.anychart.APIlib;
import com.anychart.chart.common.listener.ListenersInterface;
import com.anychart.core.Base;
import com.anychart.math.Rect;
import com.anychart.utils.RectObj;
import java.util.Arrays;
import java.util.Locale;

/* JADX INFO: loaded from: classes5.dex */
public class Bounds extends Base {
    protected Bounds() {
    }

    public static Bounds instantiate() {
        return new Bounds("new anychart.core.utils.bounds()");
    }

    public Bounds(String str) {
        StringBuilder sb = new StringBuilder("bounds");
        int i = variableIndex + 1;
        variableIndex = i;
        this.jsBase = sb.append(i).toString();
        APIlib.getInstance().addJSLine(this.jsBase + " = " + str + ";");
    }

    @Override // com.anychart.core.Base, com.anychart.JsObject
    public String getJsBase() {
        return this.jsBase;
    }

    public void bottom() {
        APIlib.getInstance().addJSLine(this.jsBase + ".bottom();");
    }

    public Bounds bottom(Number number) {
        APIlib.getInstance().addJSLine(String.format(Locale.US, this.jsBase + ".bottom(%s);", number));
        return this;
    }

    public Bounds bottom(String str) {
        APIlib.getInstance().addJSLine(String.format(Locale.US, this.jsBase + ".bottom(%s);", wrapQuotes(str)));
        return this;
    }

    public void height() {
        APIlib.getInstance().addJSLine(this.jsBase + ".height();");
    }

    public Bounds height(Number number) {
        APIlib.getInstance().addJSLine(String.format(Locale.US, this.jsBase + ".height(%s);", number));
        return this;
    }

    public Bounds height(String str) {
        APIlib.getInstance().addJSLine(String.format(Locale.US, this.jsBase + ".height(%s);", wrapQuotes(str)));
        return this;
    }

    public void left() {
        APIlib.getInstance().addJSLine(this.jsBase + ".left();");
    }

    public Bounds left(Number number) {
        APIlib.getInstance().addJSLine(String.format(Locale.US, this.jsBase + ".left(%s);", number));
        return this;
    }

    public Bounds left(String str) {
        APIlib.getInstance().addJSLine(String.format(Locale.US, this.jsBase + ".left(%s);", wrapQuotes(str)));
        return this;
    }

    public void maxHeight() {
        APIlib.getInstance().addJSLine(this.jsBase + ".maxHeight();");
    }

    public Bounds maxHeight(Number number) {
        APIlib.getInstance().addJSLine(String.format(Locale.US, this.jsBase + ".maxHeight(%s);", number));
        return this;
    }

    public Bounds maxHeight(String str) {
        APIlib.getInstance().addJSLine(String.format(Locale.US, this.jsBase + ".maxHeight(%s);", wrapQuotes(str)));
        return this;
    }

    public void maxWidth() {
        APIlib.getInstance().addJSLine(this.jsBase + ".maxWidth();");
    }

    public Bounds maxWidth(Number number) {
        APIlib.getInstance().addJSLine(String.format(Locale.US, this.jsBase + ".maxWidth(%s);", number));
        return this;
    }

    public Bounds maxWidth(String str) {
        APIlib.getInstance().addJSLine(String.format(Locale.US, this.jsBase + ".maxWidth(%s);", wrapQuotes(str)));
        return this;
    }

    public void minHeight() {
        APIlib.getInstance().addJSLine(this.jsBase + ".minHeight();");
    }

    public Bounds minHeight(Number number) {
        APIlib.getInstance().addJSLine(String.format(Locale.US, this.jsBase + ".minHeight(%s);", number));
        return this;
    }

    public Bounds minHeight(String str) {
        APIlib.getInstance().addJSLine(String.format(Locale.US, this.jsBase + ".minHeight(%s);", wrapQuotes(str)));
        return this;
    }

    public void minWidth() {
        APIlib.getInstance().addJSLine(this.jsBase + ".minWidth();");
    }

    public Bounds minWidth(Number number) {
        APIlib.getInstance().addJSLine(String.format(Locale.US, this.jsBase + ".minWidth(%s);", number));
        return this;
    }

    public Bounds minWidth(String str) {
        APIlib.getInstance().addJSLine(String.format(Locale.US, this.jsBase + ".minWidth(%s);", wrapQuotes(str)));
        return this;
    }

    public void right() {
        APIlib.getInstance().addJSLine(this.jsBase + ".right();");
    }

    public Bounds right(Number number) {
        APIlib.getInstance().addJSLine(String.format(Locale.US, this.jsBase + ".right(%s);", number));
        return this;
    }

    public Bounds right(String str) {
        APIlib.getInstance().addJSLine(String.format(Locale.US, this.jsBase + ".right(%s);", wrapQuotes(str)));
        return this;
    }

    public Bounds set(Number number, Number number2, Number number3, Number number4) {
        APIlib.getInstance().addJSLine(String.format(Locale.US, this.jsBase + ".set(%s, %s, %s, %s);", number, number2, number3, number4));
        return this;
    }

    public Bounds set(Number number, Number number2, Number number3, String str) {
        APIlib.getInstance().addJSLine(String.format(Locale.US, this.jsBase + ".set(%s, %s, %s, %s);", number, number2, number3, wrapQuotes(str)));
        return this;
    }

    public Bounds set(Number number, Number number2, String str, Number number3) {
        APIlib.getInstance().addJSLine(String.format(Locale.US, this.jsBase + ".set(%s, %s, %s, %s);", number, number2, wrapQuotes(str), number3));
        return this;
    }

    public Bounds set(Number number, Number number2, String str, String str2) {
        APIlib.getInstance().addJSLine(String.format(Locale.US, this.jsBase + ".set(%s, %s, %s, %s);", number, number2, wrapQuotes(str), wrapQuotes(str2)));
        return this;
    }

    public Bounds set(Number number, String str, Number number2, Number number3) {
        APIlib.getInstance().addJSLine(String.format(Locale.US, this.jsBase + ".set(%s, %s, %s, %s);", number, wrapQuotes(str), number2, number3));
        return this;
    }

    public Bounds set(Number number, String str, Number number2, String str2) {
        APIlib.getInstance().addJSLine(String.format(Locale.US, this.jsBase + ".set(%s, %s, %s, %s);", number, wrapQuotes(str), number2, wrapQuotes(str2)));
        return this;
    }

    public Bounds set(Number number, String str, String str2, Number number2) {
        APIlib.getInstance().addJSLine(String.format(Locale.US, this.jsBase + ".set(%s, %s, %s, %s);", number, wrapQuotes(str), wrapQuotes(str2), number2));
        return this;
    }

    public Bounds set(Number number, String str, String str2, String str3) {
        APIlib.getInstance().addJSLine(String.format(Locale.US, this.jsBase + ".set(%s, %s, %s, %s);", number, wrapQuotes(str), wrapQuotes(str2), wrapQuotes(str3)));
        return this;
    }

    public Bounds set(String str, Number number, Number number2, Number number3) {
        APIlib.getInstance().addJSLine(String.format(Locale.US, this.jsBase + ".set(%s, %s, %s, %s);", wrapQuotes(str), number, number2, number3));
        return this;
    }

    public Bounds set(String str, Number number, Number number2, String str2) {
        APIlib.getInstance().addJSLine(String.format(Locale.US, this.jsBase + ".set(%s, %s, %s, %s);", wrapQuotes(str), number, number2, wrapQuotes(str2)));
        return this;
    }

    public Bounds set(String str, Number number, String str2, Number number2) {
        APIlib.getInstance().addJSLine(String.format(Locale.US, this.jsBase + ".set(%s, %s, %s, %s);", wrapQuotes(str), number, wrapQuotes(str2), number2));
        return this;
    }

    public Bounds set(String str, Number number, String str2, String str3) {
        APIlib.getInstance().addJSLine(String.format(Locale.US, this.jsBase + ".set(%s, %s, %s, %s);", wrapQuotes(str), number, wrapQuotes(str2), wrapQuotes(str3)));
        return this;
    }

    public Bounds set(String str, String str2, Number number, Number number2) {
        APIlib.getInstance().addJSLine(String.format(Locale.US, this.jsBase + ".set(%s, %s, %s, %s);", wrapQuotes(str), wrapQuotes(str2), number, number2));
        return this;
    }

    public Bounds set(String str, String str2, Number number, String str3) {
        APIlib.getInstance().addJSLine(String.format(Locale.US, this.jsBase + ".set(%s, %s, %s, %s);", wrapQuotes(str), wrapQuotes(str2), number, wrapQuotes(str3)));
        return this;
    }

    public Bounds set(String str, String str2, String str3, Number number) {
        APIlib.getInstance().addJSLine(String.format(Locale.US, this.jsBase + ".set(%s, %s, %s, %s);", wrapQuotes(str), wrapQuotes(str2), wrapQuotes(str3), number));
        return this;
    }

    public Bounds set(String str, String str2, String str3, String str4) {
        APIlib.getInstance().addJSLine(String.format(Locale.US, this.jsBase + ".set(%s, %s, %s, %s);", wrapQuotes(str), wrapQuotes(str2), wrapQuotes(str3), wrapQuotes(str4)));
        return this;
    }

    public Bounds set(Number[] numberArr, Number number, Number number2, Number number3) {
        APIlib.getInstance().addJSLine(String.format(Locale.US, this.jsBase + ".set(%s, %s, %s, %s);", Arrays.toString(numberArr), number, number2, number3));
        return this;
    }

    public Bounds set(Number[] numberArr, Number number, Number number2, String str) {
        APIlib.getInstance().addJSLine(String.format(Locale.US, this.jsBase + ".set(%s, %s, %s, %s);", Arrays.toString(numberArr), number, number2, wrapQuotes(str)));
        return this;
    }

    public Bounds set(Number[] numberArr, Number number, String str, Number number2) {
        APIlib.getInstance().addJSLine(String.format(Locale.US, this.jsBase + ".set(%s, %s, %s, %s);", Arrays.toString(numberArr), number, wrapQuotes(str), number2));
        return this;
    }

    public Bounds set(Number[] numberArr, Number number, String str, String str2) {
        APIlib.getInstance().addJSLine(String.format(Locale.US, this.jsBase + ".set(%s, %s, %s, %s);", Arrays.toString(numberArr), number, wrapQuotes(str), wrapQuotes(str2)));
        return this;
    }

    public Bounds set(Number[] numberArr, String str, Number number, Number number2) {
        APIlib.getInstance().addJSLine(String.format(Locale.US, this.jsBase + ".set(%s, %s, %s, %s);", Arrays.toString(numberArr), wrapQuotes(str), number, number2));
        return this;
    }

    public Bounds set(Number[] numberArr, String str, Number number, String str2) {
        APIlib.getInstance().addJSLine(String.format(Locale.US, this.jsBase + ".set(%s, %s, %s, %s);", Arrays.toString(numberArr), wrapQuotes(str), number, wrapQuotes(str2)));
        return this;
    }

    public Bounds set(Number[] numberArr, String str, String str2, Number number) {
        APIlib.getInstance().addJSLine(String.format(Locale.US, this.jsBase + ".set(%s, %s, %s, %s);", Arrays.toString(numberArr), wrapQuotes(str), wrapQuotes(str2), number));
        return this;
    }

    public Bounds set(Number[] numberArr, String str, String str2, String str3) {
        APIlib.getInstance().addJSLine(String.format(Locale.US, this.jsBase + ".set(%s, %s, %s, %s);", Arrays.toString(numberArr), wrapQuotes(str), wrapQuotes(str2), wrapQuotes(str3)));
        return this;
    }

    public Bounds set(RectObj rectObj, Number number, Number number2, Number number3) {
        APIlib.getInstance().addJSLine(String.format(Locale.US, this.jsBase + ".set(%s, %s, %s, %s);", rectObj != null ? rectObj.getJsBase() : null, number, number2, number3));
        return this;
    }

    public Bounds set(RectObj rectObj, Number number, Number number2, String str) {
        APIlib.getInstance().addJSLine(String.format(Locale.US, this.jsBase + ".set(%s, %s, %s, %s);", rectObj != null ? rectObj.getJsBase() : null, number, number2, wrapQuotes(str)));
        return this;
    }

    public Bounds set(RectObj rectObj, Number number, String str, Number number2) {
        APIlib.getInstance().addJSLine(String.format(Locale.US, this.jsBase + ".set(%s, %s, %s, %s);", rectObj != null ? rectObj.getJsBase() : null, number, wrapQuotes(str), number2));
        return this;
    }

    public Bounds set(RectObj rectObj, Number number, String str, String str2) {
        APIlib.getInstance().addJSLine(String.format(Locale.US, this.jsBase + ".set(%s, %s, %s, %s);", rectObj != null ? rectObj.getJsBase() : null, number, wrapQuotes(str), wrapQuotes(str2)));
        return this;
    }

    public Bounds set(RectObj rectObj, String str, Number number, Number number2) {
        APIlib.getInstance().addJSLine(String.format(Locale.US, this.jsBase + ".set(%s, %s, %s, %s);", rectObj != null ? rectObj.getJsBase() : null, wrapQuotes(str), number, number2));
        return this;
    }

    public Bounds set(RectObj rectObj, String str, Number number, String str2) {
        APIlib.getInstance().addJSLine(String.format(Locale.US, this.jsBase + ".set(%s, %s, %s, %s);", rectObj != null ? rectObj.getJsBase() : null, wrapQuotes(str), number, wrapQuotes(str2)));
        return this;
    }

    public Bounds set(RectObj rectObj, String str, String str2, Number number) {
        APIlib.getInstance().addJSLine(String.format(Locale.US, this.jsBase + ".set(%s, %s, %s, %s);", rectObj != null ? rectObj.getJsBase() : null, wrapQuotes(str), wrapQuotes(str2), number));
        return this;
    }

    public Bounds set(RectObj rectObj, String str, String str2, String str3) {
        APIlib.getInstance().addJSLine(String.format(Locale.US, this.jsBase + ".set(%s, %s, %s, %s);", rectObj != null ? rectObj.getJsBase() : null, wrapQuotes(str), wrapQuotes(str2), wrapQuotes(str3)));
        return this;
    }

    public Bounds set(Rect rect, Number number, Number number2, Number number3) {
        APIlib.getInstance().addJSLine(String.format(Locale.US, this.jsBase + ".set(%s, %s, %s, %s);", rect != null ? rect.getJsBase() : null, number, number2, number3));
        return this;
    }

    public Bounds set(Rect rect, Number number, Number number2, String str) {
        APIlib.getInstance().addJSLine(String.format(Locale.US, this.jsBase + ".set(%s, %s, %s, %s);", rect != null ? rect.getJsBase() : null, number, number2, wrapQuotes(str)));
        return this;
    }

    public Bounds set(Rect rect, Number number, String str, Number number2) {
        APIlib.getInstance().addJSLine(String.format(Locale.US, this.jsBase + ".set(%s, %s, %s, %s);", rect != null ? rect.getJsBase() : null, number, wrapQuotes(str), number2));
        return this;
    }

    public Bounds set(Rect rect, Number number, String str, String str2) {
        APIlib.getInstance().addJSLine(String.format(Locale.US, this.jsBase + ".set(%s, %s, %s, %s);", rect != null ? rect.getJsBase() : null, number, wrapQuotes(str), wrapQuotes(str2)));
        return this;
    }

    public Bounds set(Rect rect, String str, Number number, Number number2) {
        APIlib.getInstance().addJSLine(String.format(Locale.US, this.jsBase + ".set(%s, %s, %s, %s);", rect != null ? rect.getJsBase() : null, wrapQuotes(str), number, number2));
        return this;
    }

    public Bounds set(Rect rect, String str, Number number, String str2) {
        APIlib.getInstance().addJSLine(String.format(Locale.US, this.jsBase + ".set(%s, %s, %s, %s);", rect != null ? rect.getJsBase() : null, wrapQuotes(str), number, wrapQuotes(str2)));
        return this;
    }

    public Bounds set(Rect rect, String str, String str2, Number number) {
        APIlib.getInstance().addJSLine(String.format(Locale.US, this.jsBase + ".set(%s, %s, %s, %s);", rect != null ? rect.getJsBase() : null, wrapQuotes(str), wrapQuotes(str2), number));
        return this;
    }

    public Bounds set(Rect rect, String str, String str2, String str3) {
        APIlib.getInstance().addJSLine(String.format(Locale.US, this.jsBase + ".set(%s, %s, %s, %s);", rect != null ? rect.getJsBase() : null, wrapQuotes(str), wrapQuotes(str2), wrapQuotes(str3)));
        return this;
    }

    public Bounds set(Bounds bounds, Number number, Number number2, Number number3) {
        APIlib.getInstance().addJSLine(String.format(Locale.US, this.jsBase + ".set(%s, %s, %s, %s);", bounds != null ? bounds.getJsBase() : null, number, number2, number3));
        return this;
    }

    public Bounds set(Bounds bounds, Number number, Number number2, String str) {
        APIlib.getInstance().addJSLine(String.format(Locale.US, this.jsBase + ".set(%s, %s, %s, %s);", bounds != null ? bounds.getJsBase() : null, number, number2, wrapQuotes(str)));
        return this;
    }

    public Bounds set(Bounds bounds, Number number, String str, Number number2) {
        APIlib.getInstance().addJSLine(String.format(Locale.US, this.jsBase + ".set(%s, %s, %s, %s);", bounds != null ? bounds.getJsBase() : null, number, wrapQuotes(str), number2));
        return this;
    }

    public Bounds set(Bounds bounds, Number number, String str, String str2) {
        APIlib.getInstance().addJSLine(String.format(Locale.US, this.jsBase + ".set(%s, %s, %s, %s);", bounds != null ? bounds.getJsBase() : null, number, wrapQuotes(str), wrapQuotes(str2)));
        return this;
    }

    public Bounds set(Bounds bounds, String str, Number number, Number number2) {
        APIlib.getInstance().addJSLine(String.format(Locale.US, this.jsBase + ".set(%s, %s, %s, %s);", bounds != null ? bounds.getJsBase() : null, wrapQuotes(str), number, number2));
        return this;
    }

    public Bounds set(Bounds bounds, String str, Number number, String str2) {
        APIlib.getInstance().addJSLine(String.format(Locale.US, this.jsBase + ".set(%s, %s, %s, %s);", bounds != null ? bounds.getJsBase() : null, wrapQuotes(str), number, wrapQuotes(str2)));
        return this;
    }

    public Bounds set(Bounds bounds, String str, String str2, Number number) {
        APIlib.getInstance().addJSLine(String.format(Locale.US, this.jsBase + ".set(%s, %s, %s, %s);", bounds != null ? bounds.getJsBase() : null, wrapQuotes(str), wrapQuotes(str2), number));
        return this;
    }

    public Bounds set(Bounds bounds, String str, String str2, String str3) {
        APIlib.getInstance().addJSLine(String.format(Locale.US, this.jsBase + ".set(%s, %s, %s, %s);", bounds != null ? bounds.getJsBase() : null, wrapQuotes(str), wrapQuotes(str2), wrapQuotes(str3)));
        return this;
    }

    public Rect toRect(Number number, Number number2, Number number3, Number number4) {
        return new Rect(String.format(Locale.US, this.jsBase + ".toRect(%s, %s, %s, %s)", number, number2, number3, number4));
    }

    public Rect toRect(Rect rect, Number number, Number number2, Number number3) {
        return new Rect(String.format(Locale.US, this.jsBase + ".toRect(%s, %s, %s, %s)", rect != null ? rect.getJsBase() : null, number, number2, number3));
    }

    public Rect toRect(String str, Number number, Number number2, Number number3) {
        return new Rect(String.format(Locale.US, this.jsBase + ".toRect(%s, %s, %s, %s)", wrapQuotes(str), number, number2, number3));
    }

    public void top() {
        APIlib.getInstance().addJSLine(this.jsBase + ".top();");
    }

    public Bounds top(Number number) {
        APIlib.getInstance().addJSLine(String.format(Locale.US, this.jsBase + ".top(%s);", number));
        return this;
    }

    public Bounds top(String str) {
        APIlib.getInstance().addJSLine(String.format(Locale.US, this.jsBase + ".top(%s);", wrapQuotes(str)));
        return this;
    }

    public void width() {
        APIlib.getInstance().addJSLine(this.jsBase + ".width();");
    }

    public Bounds width(Number number) {
        APIlib.getInstance().addJSLine(String.format(Locale.US, this.jsBase + ".width(%s);", number));
        return this;
    }

    public Bounds width(String str) {
        APIlib.getInstance().addJSLine(String.format(Locale.US, this.jsBase + ".width(%s);", wrapQuotes(str)));
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
