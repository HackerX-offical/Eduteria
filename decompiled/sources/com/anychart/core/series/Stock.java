package com.anychart.core.series;

import com.amazonaws.services.s3.model.InstructionFileId;
import com.anychart.APIlib;
import com.anychart.chart.common.dataentry.DataEntry;
import com.anychart.chart.common.listener.ListenersInterface;
import com.anychart.core.ui.LabelsFactory;
import com.anychart.core.ui.MarkersFactory;
import com.anychart.core.utils.Bounds;
import com.anychart.core.utils.Error;
import com.anychart.core.utils.LegendItemSettings;
import com.anychart.data.TableMapping;
import com.anychart.data.View;
import com.anychart.enums.TreeFillingMethod;
import com.anychart.graphics.vector.Layer;
import com.anychart.graphics.vector.PaperSize;
import com.anychart.graphics.vector.Stage;
import com.anychart.math.Rect;
import com.anychart.utils.RectObj;
import java.lang.reflect.InvocationTargetException;
import java.util.List;
import java.util.Locale;

/* JADX INFO: loaded from: classes5.dex */
public class Stock extends Base {
    protected Stock() {
    }

    public static Stock instantiate() {
        return new Stock("new anychart.core.series.stock()");
    }

    public Stock(String str) {
        StringBuilder sb = new StringBuilder("stock");
        int i = variableIndex + 1;
        variableIndex = i;
        this.jsBase = sb.append(i).toString();
        APIlib.getInstance().addJSLine(this.jsBase + " = " + str + ";");
    }

    @Override // com.anychart.core.series.Base, com.anychart.core.VisualBaseWithBounds, com.anychart.core.VisualBase, com.anychart.core.Base, com.anychart.JsObject
    public String getJsBase() {
        return this.jsBase;
    }

    @Override // com.anychart.core.series.Base, com.anychart.core.VisualBaseWithBounds
    public void bottom() {
        APIlib.getInstance().addJSLine(this.jsBase + ".bottom();");
    }

    @Override // com.anychart.core.series.Base, com.anychart.core.VisualBaseWithBounds
    public Stock bottom(Number number) {
        APIlib.getInstance().addJSLine(String.format(Locale.US, this.jsBase + ".bottom(%s);", number));
        return this;
    }

    @Override // com.anychart.core.series.Base, com.anychart.core.VisualBaseWithBounds
    public Stock bottom(String str) {
        APIlib.getInstance().addJSLine(String.format(Locale.US, this.jsBase + ".bottom(%s);", wrapQuotes(str)));
        return this;
    }

    @Override // com.anychart.core.series.Base, com.anychart.core.VisualBaseWithBounds
    public Bounds bounds() {
        return new Bounds(this.jsBase + ".bounds()");
    }

    @Override // com.anychart.core.series.Base, com.anychart.core.VisualBaseWithBounds
    public Stock bounds(RectObj rectObj) {
        APIlib.getInstance().addJSLine(String.format(Locale.US, this.jsBase + ".bounds(%s);", rectObj != null ? rectObj.getJsBase() : null));
        return this;
    }

    @Override // com.anychart.core.series.Base, com.anychart.core.VisualBaseWithBounds
    public Stock bounds(Rect rect) {
        APIlib.getInstance().addJSLine(String.format(Locale.US, this.jsBase + ".bounds(%s);", rect != null ? rect.getJsBase() : null));
        return this;
    }

    @Override // com.anychart.core.series.Base, com.anychart.core.VisualBaseWithBounds
    public Stock bounds(Bounds bounds) {
        APIlib.getInstance().addJSLine(String.format(Locale.US, this.jsBase + ".bounds(%s);", bounds != null ? bounds.getJsBase() : null));
        return this;
    }

    @Override // com.anychart.core.series.Base, com.anychart.core.VisualBaseWithBounds
    public Stock bounds(Number number, Number number2, Number number3, Number number4) {
        APIlib.getInstance().addJSLine(String.format(Locale.US, this.jsBase + ".bounds(%s, %s, %s, %s);", number, number2, number3, number4));
        return this;
    }

    @Override // com.anychart.core.series.Base, com.anychart.core.VisualBaseWithBounds
    public Stock bounds(Number number, Number number2, Number number3, String str) {
        APIlib.getInstance().addJSLine(String.format(Locale.US, this.jsBase + ".bounds(%s, %s, %s, %s);", number, number2, number3, wrapQuotes(str)));
        return this;
    }

    @Override // com.anychart.core.series.Base, com.anychart.core.VisualBaseWithBounds
    public Stock bounds(Number number, Number number2, String str, Number number3) {
        APIlib.getInstance().addJSLine(String.format(Locale.US, this.jsBase + ".bounds(%s, %s, %s, %s);", number, number2, wrapQuotes(str), number3));
        return this;
    }

    @Override // com.anychart.core.series.Base, com.anychart.core.VisualBaseWithBounds
    public Stock bounds(Number number, Number number2, String str, String str2) {
        APIlib.getInstance().addJSLine(String.format(Locale.US, this.jsBase + ".bounds(%s, %s, %s, %s);", number, number2, wrapQuotes(str), wrapQuotes(str2)));
        return this;
    }

    @Override // com.anychart.core.series.Base, com.anychart.core.VisualBaseWithBounds
    public Stock bounds(Number number, String str, Number number2, Number number3) {
        APIlib.getInstance().addJSLine(String.format(Locale.US, this.jsBase + ".bounds(%s, %s, %s, %s);", number, wrapQuotes(str), number2, number3));
        return this;
    }

    @Override // com.anychart.core.series.Base, com.anychart.core.VisualBaseWithBounds
    public Stock bounds(Number number, String str, Number number2, String str2) {
        APIlib.getInstance().addJSLine(String.format(Locale.US, this.jsBase + ".bounds(%s, %s, %s, %s);", number, wrapQuotes(str), number2, wrapQuotes(str2)));
        return this;
    }

    @Override // com.anychart.core.series.Base, com.anychart.core.VisualBaseWithBounds
    public Stock bounds(Number number, String str, String str2, Number number2) {
        APIlib.getInstance().addJSLine(String.format(Locale.US, this.jsBase + ".bounds(%s, %s, %s, %s);", number, wrapQuotes(str), wrapQuotes(str2), number2));
        return this;
    }

    @Override // com.anychart.core.series.Base, com.anychart.core.VisualBaseWithBounds
    public Stock bounds(Number number, String str, String str2, String str3) {
        APIlib.getInstance().addJSLine(String.format(Locale.US, this.jsBase + ".bounds(%s, %s, %s, %s);", number, wrapQuotes(str), wrapQuotes(str2), wrapQuotes(str3)));
        return this;
    }

    @Override // com.anychart.core.series.Base, com.anychart.core.VisualBaseWithBounds
    public Stock bounds(String str, Number number, Number number2, Number number3) {
        APIlib.getInstance().addJSLine(String.format(Locale.US, this.jsBase + ".bounds(%s, %s, %s, %s);", wrapQuotes(str), number, number2, number3));
        return this;
    }

    @Override // com.anychart.core.series.Base, com.anychart.core.VisualBaseWithBounds
    public Stock bounds(String str, Number number, Number number2, String str2) {
        APIlib.getInstance().addJSLine(String.format(Locale.US, this.jsBase + ".bounds(%s, %s, %s, %s);", wrapQuotes(str), number, number2, wrapQuotes(str2)));
        return this;
    }

    @Override // com.anychart.core.series.Base, com.anychart.core.VisualBaseWithBounds
    public Stock bounds(String str, Number number, String str2, Number number2) {
        APIlib.getInstance().addJSLine(String.format(Locale.US, this.jsBase + ".bounds(%s, %s, %s, %s);", wrapQuotes(str), number, wrapQuotes(str2), number2));
        return this;
    }

    @Override // com.anychart.core.series.Base, com.anychart.core.VisualBaseWithBounds
    public Stock bounds(String str, Number number, String str2, String str3) {
        APIlib.getInstance().addJSLine(String.format(Locale.US, this.jsBase + ".bounds(%s, %s, %s, %s);", wrapQuotes(str), number, wrapQuotes(str2), wrapQuotes(str3)));
        return this;
    }

    @Override // com.anychart.core.series.Base, com.anychart.core.VisualBaseWithBounds
    public Stock bounds(String str, String str2, Number number, Number number2) {
        APIlib.getInstance().addJSLine(String.format(Locale.US, this.jsBase + ".bounds(%s, %s, %s, %s);", wrapQuotes(str), wrapQuotes(str2), number, number2));
        return this;
    }

    @Override // com.anychart.core.series.Base, com.anychart.core.VisualBaseWithBounds
    public Stock bounds(String str, String str2, Number number, String str3) {
        APIlib.getInstance().addJSLine(String.format(Locale.US, this.jsBase + ".bounds(%s, %s, %s, %s);", wrapQuotes(str), wrapQuotes(str2), number, wrapQuotes(str3)));
        return this;
    }

    @Override // com.anychart.core.series.Base, com.anychart.core.VisualBaseWithBounds
    public Stock bounds(String str, String str2, String str3, Number number) {
        APIlib.getInstance().addJSLine(String.format(Locale.US, this.jsBase + ".bounds(%s, %s, %s, %s);", wrapQuotes(str), wrapQuotes(str2), wrapQuotes(str3), number));
        return this;
    }

    @Override // com.anychart.core.series.Base, com.anychart.core.VisualBaseWithBounds
    public Stock bounds(String str, String str2, String str3, String str4) {
        APIlib.getInstance().addJSLine(String.format(Locale.US, this.jsBase + ".bounds(%s, %s, %s, %s);", wrapQuotes(str), wrapQuotes(str2), wrapQuotes(str3), wrapQuotes(str4)));
        return this;
    }

    @Override // com.anychart.core.series.Base
    public Stock clip(Boolean bool) {
        APIlib.getInstance().addJSLine(String.format(Locale.US, this.jsBase + ".clip(%s);", bool));
        return this;
    }

    @Override // com.anychart.core.series.Base
    public Stock clip(Rect rect) {
        APIlib.getInstance().addJSLine(String.format(Locale.US, this.jsBase + ".clip(%s);", rect != null ? rect.getJsBase() : null));
        return this;
    }

    public TableMapping data(List<DataEntry> list) {
        return new TableMapping(String.format(Locale.US, this.jsBase + ".data(%s)", arrayToString(list)));
    }

    @Override // com.anychart.core.series.Base, com.anychart.core.VisualBaseWithBounds, com.anychart.core.VisualBase
    public void enabled() {
        APIlib.getInstance().addJSLine(this.jsBase + ".enabled();");
    }

    @Override // com.anychart.core.series.Base, com.anychart.core.VisualBaseWithBounds, com.anychart.core.VisualBase
    public Stock enabled(Boolean bool) {
        APIlib.getInstance().addJSLine(String.format(Locale.US, this.jsBase + ".enabled(%s);", bool));
        return this;
    }

    @Override // com.anychart.core.series.Base
    public Error error(String str) {
        return new Error(String.format(Locale.US, this.jsBase + ".error(%s)", wrapQuotes(str)));
    }

    @Override // com.anychart.core.series.Base
    public Error error(Boolean bool) {
        return new Error(String.format(Locale.US, this.jsBase + ".error(%s)", bool));
    }

    @Override // com.anychart.core.series.Base
    public void getIndex() {
        APIlib.getInstance().addJSLine(this.jsBase + ".getIndex();");
    }

    @Override // com.anychart.core.series.Base, com.anychart.core.VisualBaseWithBounds
    public Rect getPixelBounds() {
        return new Rect(this.jsBase + ".getPixelBounds()");
    }

    @Override // com.anychart.core.series.Base
    public void getPixelPointWidth() {
        APIlib.getInstance().addJSLine(this.jsBase + ".getPixelPointWidth();");
    }

    @Override // com.anychart.core.series.Base, com.anychart.core.VisualBaseWithBounds
    public void height() {
        APIlib.getInstance().addJSLine(this.jsBase + ".height();");
    }

    @Override // com.anychart.core.series.Base, com.anychart.core.VisualBaseWithBounds
    public Stock height(Number number) {
        APIlib.getInstance().addJSLine(String.format(Locale.US, this.jsBase + ".height(%s);", number));
        return this;
    }

    @Override // com.anychart.core.series.Base, com.anychart.core.VisualBaseWithBounds
    public Stock height(String str) {
        APIlib.getInstance().addJSLine(String.format(Locale.US, this.jsBase + ".height(%s);", wrapQuotes(str)));
        return this;
    }

    @Override // com.anychart.core.series.Base
    public LabelsFactory hoverLabels(String str) {
        return new LabelsFactory(String.format(Locale.US, this.jsBase + ".hoverLabels(%s)", wrapQuotes(str)));
    }

    @Override // com.anychart.core.series.Base
    public LabelsFactory hoverLabels(Boolean bool) {
        return new LabelsFactory(String.format(Locale.US, this.jsBase + ".hoverLabels(%s)", bool));
    }

    @Override // com.anychart.core.series.Base
    public MarkersFactory hoverMarkers(String str) {
        return new MarkersFactory(String.format(Locale.US, this.jsBase + ".hoverMarkers(%s)", wrapQuotes(str)));
    }

    @Override // com.anychart.core.series.Base
    public MarkersFactory hoverMarkers(Boolean bool) {
        return new MarkersFactory(String.format(Locale.US, this.jsBase + ".hoverMarkers(%s)", bool));
    }

    @Override // com.anychart.core.series.Base
    public MarkersFactory hoverOutlierMarkers(String str) {
        return new MarkersFactory(String.format(Locale.US, this.jsBase + ".hoverOutlierMarkers(%s)", wrapQuotes(str)));
    }

    @Override // com.anychart.core.series.Base
    public MarkersFactory hoverOutlierMarkers(Boolean bool) {
        return new MarkersFactory(String.format(Locale.US, this.jsBase + ".hoverOutlierMarkers(%s)", bool));
    }

    @Override // com.anychart.core.series.Base
    public void id(String str) {
        APIlib.getInstance().addJSLine(String.format(Locale.US, this.jsBase + ".id(%s);", wrapQuotes(str)));
    }

    @Override // com.anychart.core.series.Base
    public LabelsFactory labels(String str) {
        return new LabelsFactory(String.format(Locale.US, this.jsBase + ".labels(%s)", wrapQuotes(str)));
    }

    @Override // com.anychart.core.series.Base
    public LabelsFactory labels(Boolean bool) {
        return new LabelsFactory(String.format(Locale.US, this.jsBase + ".labels(%s)", bool));
    }

    @Override // com.anychart.core.series.Base, com.anychart.core.VisualBaseWithBounds
    public void left() {
        APIlib.getInstance().addJSLine(this.jsBase + ".left();");
    }

    @Override // com.anychart.core.series.Base, com.anychart.core.VisualBaseWithBounds
    public Stock left(Number number) {
        APIlib.getInstance().addJSLine(String.format(Locale.US, this.jsBase + ".left(%s);", number));
        return this;
    }

    @Override // com.anychart.core.series.Base, com.anychart.core.VisualBaseWithBounds
    public Stock left(String str) {
        APIlib.getInstance().addJSLine(String.format(Locale.US, this.jsBase + ".left(%s);", wrapQuotes(str)));
        return this;
    }

    @Override // com.anychart.core.series.Base
    public LegendItemSettings legendItem(String str) {
        return new LegendItemSettings(String.format(Locale.US, this.jsBase + ".legendItem(%s)", wrapQuotes(str)));
    }

    @Override // com.anychart.core.series.Base
    public MarkersFactory markers(String str) {
        return new MarkersFactory(String.format(Locale.US, this.jsBase + ".markers(%s)", wrapQuotes(str)));
    }

    @Override // com.anychart.core.series.Base
    public MarkersFactory markers(Boolean bool) {
        return new MarkersFactory(String.format(Locale.US, this.jsBase + ".markers(%s)", bool));
    }

    @Override // com.anychart.core.series.Base, com.anychart.core.VisualBaseWithBounds
    public void maxHeight() {
        APIlib.getInstance().addJSLine(this.jsBase + ".maxHeight();");
    }

    @Override // com.anychart.core.series.Base, com.anychart.core.VisualBaseWithBounds
    public Stock maxHeight(Number number) {
        APIlib.getInstance().addJSLine(String.format(Locale.US, this.jsBase + ".maxHeight(%s);", number));
        return this;
    }

    @Override // com.anychart.core.series.Base, com.anychart.core.VisualBaseWithBounds
    public Stock maxHeight(String str) {
        APIlib.getInstance().addJSLine(String.format(Locale.US, this.jsBase + ".maxHeight(%s);", wrapQuotes(str)));
        return this;
    }

    @Override // com.anychart.core.series.Base, com.anychart.core.VisualBaseWithBounds
    public void maxWidth() {
        APIlib.getInstance().addJSLine(this.jsBase + ".maxWidth();");
    }

    @Override // com.anychart.core.series.Base, com.anychart.core.VisualBaseWithBounds
    public Stock maxWidth(Number number) {
        APIlib.getInstance().addJSLine(String.format(Locale.US, this.jsBase + ".maxWidth(%s);", number));
        return this;
    }

    @Override // com.anychart.core.series.Base, com.anychart.core.VisualBaseWithBounds
    public Stock maxWidth(String str) {
        APIlib.getInstance().addJSLine(String.format(Locale.US, this.jsBase + ".maxWidth(%s);", wrapQuotes(str)));
        return this;
    }

    @Override // com.anychart.core.series.Base
    public void meta(String str, String str2) {
        APIlib.getInstance().addJSLine(String.format(Locale.US, this.jsBase + ".meta(%s, %s);", wrapQuotes(str), wrapQuotes(str2)));
    }

    @Override // com.anychart.core.series.Base, com.anychart.core.VisualBaseWithBounds
    public void minHeight() {
        APIlib.getInstance().addJSLine(this.jsBase + ".minHeight();");
    }

    @Override // com.anychart.core.series.Base, com.anychart.core.VisualBaseWithBounds
    public Stock minHeight(Number number) {
        APIlib.getInstance().addJSLine(String.format(Locale.US, this.jsBase + ".minHeight(%s);", number));
        return this;
    }

    @Override // com.anychart.core.series.Base, com.anychart.core.VisualBaseWithBounds
    public Stock minHeight(String str) {
        APIlib.getInstance().addJSLine(String.format(Locale.US, this.jsBase + ".minHeight(%s);", wrapQuotes(str)));
        return this;
    }

    @Override // com.anychart.core.series.Base, com.anychart.core.VisualBaseWithBounds
    public void minWidth() {
        APIlib.getInstance().addJSLine(this.jsBase + ".minWidth();");
    }

    @Override // com.anychart.core.series.Base, com.anychart.core.VisualBaseWithBounds
    public Stock minWidth(Number number) {
        APIlib.getInstance().addJSLine(String.format(Locale.US, this.jsBase + ".minWidth(%s);", number));
        return this;
    }

    @Override // com.anychart.core.series.Base, com.anychart.core.VisualBaseWithBounds
    public Stock minWidth(String str) {
        APIlib.getInstance().addJSLine(String.format(Locale.US, this.jsBase + ".minWidth(%s);", wrapQuotes(str)));
        return this;
    }

    @Override // com.anychart.core.series.Base
    public Stock name(String str) {
        APIlib.getInstance().addJSLine(String.format(Locale.US, this.jsBase + ".name(%s);", wrapQuotes(str)));
        return this;
    }

    @Override // com.anychart.core.series.Base
    public MarkersFactory outlierMarkers(String str) {
        return new MarkersFactory(String.format(Locale.US, this.jsBase + ".outlierMarkers(%s)", wrapQuotes(str)));
    }

    @Override // com.anychart.core.series.Base
    public MarkersFactory outlierMarkers(Boolean bool) {
        return new MarkersFactory(String.format(Locale.US, this.jsBase + ".outlierMarkers(%s)", bool));
    }

    @Override // com.anychart.core.series.Base, com.anychart.core.VisualBaseWithBounds, com.anychart.core.VisualBase
    public void print(PaperSize paperSize, Boolean bool) {
        APIlib.getInstance().addJSLine(String.format(Locale.US, this.jsBase + ".print(%s, %s);", paperSize != null ? paperSize.getJsBase() : null, bool));
    }

    @Override // com.anychart.core.series.Base, com.anychart.core.VisualBaseWithBounds, com.anychart.core.VisualBase
    public void print(String str, Boolean bool) {
        APIlib.getInstance().addJSLine(String.format(Locale.US, this.jsBase + ".print(%s, %s);", wrapQuotes(str), bool));
    }

    @Override // com.anychart.core.series.Base, com.anychart.core.VisualBaseWithBounds, com.anychart.core.VisualBase, com.anychart.core.Base
    public void removeAllListeners(String str) {
        APIlib.getInstance().addJSLine(String.format(Locale.US, this.jsBase + ".removeAllListeners(%s);", wrapQuotes(str)));
    }

    @Override // com.anychart.core.series.Base, com.anychart.core.VisualBaseWithBounds
    public void right() {
        APIlib.getInstance().addJSLine(this.jsBase + ".right();");
    }

    @Override // com.anychart.core.series.Base, com.anychart.core.VisualBaseWithBounds
    public Stock right(Number number) {
        APIlib.getInstance().addJSLine(String.format(Locale.US, this.jsBase + ".right(%s);", number));
        return this;
    }

    @Override // com.anychart.core.series.Base, com.anychart.core.VisualBaseWithBounds
    public Stock right(String str) {
        APIlib.getInstance().addJSLine(String.format(Locale.US, this.jsBase + ".right(%s);", wrapQuotes(str)));
        return this;
    }

    @Override // com.anychart.core.series.Base
    public LabelsFactory selectLabels(String str) {
        return new LabelsFactory(String.format(Locale.US, this.jsBase + ".selectLabels(%s)", wrapQuotes(str)));
    }

    @Override // com.anychart.core.series.Base
    public LabelsFactory selectLabels(Boolean bool) {
        return new LabelsFactory(String.format(Locale.US, this.jsBase + ".selectLabels(%s)", bool));
    }

    @Override // com.anychart.core.series.Base
    public MarkersFactory selectMarkers(String str) {
        return new MarkersFactory(String.format(Locale.US, this.jsBase + ".selectMarkers(%s)", wrapQuotes(str)));
    }

    @Override // com.anychart.core.series.Base
    public MarkersFactory selectMarkers(Boolean bool) {
        return new MarkersFactory(String.format(Locale.US, this.jsBase + ".selectMarkers(%s)", bool));
    }

    @Override // com.anychart.core.series.Base
    public MarkersFactory selectOutlierMarkers(String str) {
        return new MarkersFactory(String.format(Locale.US, this.jsBase + ".selectOutlierMarkers(%s)", wrapQuotes(str)));
    }

    @Override // com.anychart.core.series.Base
    public MarkersFactory selectOutlierMarkers(Boolean bool) {
        return new MarkersFactory(String.format(Locale.US, this.jsBase + ".selectOutlierMarkers(%s)", bool));
    }

    @Override // com.anychart.core.series.Base
    public Stock seriesType(String str) {
        APIlib.getInstance().addJSLine(String.format(Locale.US, this.jsBase + ".seriesType(%s);", wrapQuotes(str)));
        return this;
    }

    @Override // com.anychart.core.series.Base
    public Stock tooltip(String str) {
        APIlib.getInstance().addJSLine(String.format(Locale.US, this.jsBase + ".tooltip(%s);", wrapQuotes(str)));
        return this;
    }

    @Override // com.anychart.core.series.Base
    public Stock tooltip(Boolean bool) {
        APIlib.getInstance().addJSLine(String.format(Locale.US, this.jsBase + ".tooltip(%s);", bool));
        return this;
    }

    @Override // com.anychart.core.series.Base, com.anychart.core.VisualBaseWithBounds
    public void top() {
        APIlib.getInstance().addJSLine(this.jsBase + ".top();");
    }

    @Override // com.anychart.core.series.Base, com.anychart.core.VisualBaseWithBounds
    public Stock top(Number number) {
        APIlib.getInstance().addJSLine(String.format(Locale.US, this.jsBase + ".top(%s);", number));
        return this;
    }

    @Override // com.anychart.core.series.Base, com.anychart.core.VisualBaseWithBounds
    public Stock top(String str) {
        APIlib.getInstance().addJSLine(String.format(Locale.US, this.jsBase + ".top(%s);", wrapQuotes(str)));
        return this;
    }

    @Override // com.anychart.core.series.Base
    public void transformX(String str, Number number) {
        APIlib.getInstance().addJSLine(String.format(Locale.US, this.jsBase + ".transformX(%s, %s);", wrapQuotes(str), number));
    }

    @Override // com.anychart.core.series.Base
    public void transformY(String str, Number number) {
        APIlib.getInstance().addJSLine(String.format(Locale.US, this.jsBase + ".transformY(%s, %s);", wrapQuotes(str), number));
    }

    @Override // com.anychart.core.series.Base, com.anychart.core.VisualBaseWithBounds, com.anychart.core.VisualBase, com.anychart.core.Base
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

    @Override // com.anychart.core.series.Base, com.anychart.core.VisualBaseWithBounds, com.anychart.core.VisualBase, com.anychart.core.Base
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

    @Override // com.anychart.core.series.Base, com.anychart.core.VisualBaseWithBounds, com.anychart.core.VisualBase, com.anychart.core.Base
    public void unlistenByKey(String str) {
        APIlib.getInstance().addJSLine(String.format(Locale.US, this.jsBase + ".unlistenByKey(%s);", wrapQuotes(str)));
    }

    @Override // com.anychart.core.series.Base, com.anychart.core.VisualBaseWithBounds
    public void width() {
        APIlib.getInstance().addJSLine(this.jsBase + ".width();");
    }

    @Override // com.anychart.core.series.Base, com.anychart.core.VisualBaseWithBounds
    public Stock width(Number number) {
        APIlib.getInstance().addJSLine(String.format(Locale.US, this.jsBase + ".width(%s);", number));
        return this;
    }

    @Override // com.anychart.core.series.Base, com.anychart.core.VisualBaseWithBounds
    public Stock width(String str) {
        APIlib.getInstance().addJSLine(String.format(Locale.US, this.jsBase + ".width(%s);", wrapQuotes(str)));
        return this;
    }

    @Override // com.anychart.core.series.Base
    public com.anychart.scales.Base yScale(com.anychart.scales.Base base) {
        return new com.anychart.scales.Base(String.format(Locale.US, this.jsBase + ".yScale(%s)", base != null ? base.getJsBase() : null));
    }

    @Override // com.anychart.core.series.Base, com.anychart.core.VisualBaseWithBounds, com.anychart.core.VisualBase
    public void zIndex() {
        APIlib.getInstance().addJSLine(this.jsBase + ".zIndex();");
    }

    @Override // com.anychart.core.series.Base, com.anychart.core.VisualBaseWithBounds, com.anychart.core.VisualBase
    public Stock zIndex(Number number) {
        APIlib.getInstance().addJSLine(String.format(Locale.US, this.jsBase + ".zIndex(%s);", number));
        return this;
    }

    @Override // com.anychart.core.series.Base, com.anychart.core.VisualBaseWithBounds, com.anychart.core.VisualBase
    public Layer container() {
        return new Layer(this.jsBase + ".container()");
    }

    @Override // com.anychart.core.series.Base, com.anychart.core.VisualBaseWithBounds, com.anychart.core.VisualBase
    public Stock container(Layer layer) {
        APIlib.getInstance().addJSLine(String.format(Locale.US, this.jsBase + ".container(%s);", layer != null ? layer.getJsBase() : null));
        return this;
    }

    @Override // com.anychart.core.series.Base, com.anychart.core.VisualBaseWithBounds, com.anychart.core.VisualBase
    public Stock container(Stage stage) {
        APIlib.getInstance().addJSLine(String.format(Locale.US, this.jsBase + ".container(%s);", stage != null ? stage.getJsBase() : null));
        return this;
    }

    @Override // com.anychart.core.series.Base, com.anychart.core.VisualBaseWithBounds, com.anychart.core.VisualBase
    public Stock container(String str) {
        APIlib.getInstance().addJSLine(String.format(Locale.US, this.jsBase + ".container(%s);", wrapQuotes(str)));
        return this;
    }

    @Override // com.anychart.core.series.Base, com.anychart.core.VisualBaseWithBounds, com.anychart.core.VisualBase
    public Rect parentBounds() {
        return new Rect(this.jsBase + ".parentBounds()");
    }

    @Override // com.anychart.core.series.Base, com.anychart.core.VisualBaseWithBounds, com.anychart.core.VisualBase
    public Stock parentBounds(Rect rect) {
        APIlib.getInstance().addJSLine(String.format(Locale.US, this.jsBase + ".parentBounds(%s);", rect != null ? rect.getJsBase() : null));
        return this;
    }

    @Override // com.anychart.core.series.Base, com.anychart.core.VisualBaseWithBounds, com.anychart.core.VisualBase
    public Stock parentBounds(String str) {
        APIlib.getInstance().addJSLine(String.format(Locale.US, this.jsBase + ".parentBounds(%s);", wrapQuotes(str)));
        return this;
    }

    @Override // com.anychart.core.series.Base, com.anychart.core.VisualBaseWithBounds, com.anychart.core.VisualBase
    public Stock parentBounds(Number number) {
        APIlib.getInstance().addJSLine(String.format(Locale.US, this.jsBase + ".parentBounds(%s);", number));
        return this;
    }

    @Override // com.anychart.core.series.Base, com.anychart.core.VisualBaseWithBounds, com.anychart.core.VisualBase
    public Stock parentBounds(Number number, Number number2, Number number3, Number number4) {
        APIlib.getInstance().addJSLine(String.format(Locale.US, this.jsBase + ".parentBounds(%s, %s, %s, %s);", number, number2, number3, number4));
        return this;
    }

    public TableMapping data(View view) {
        return new TableMapping(String.format(Locale.US, this.jsBase + ".data(%s)", view != null ? view.getJsBase() : null));
    }

    public TableMapping data(List<DataEntry> list, TreeFillingMethod treeFillingMethod) {
        return new TableMapping(String.format(Locale.US, this.jsBase + ".data(%s, %s)", arrayToString(list), treeFillingMethod != null ? treeFillingMethod.getJsBase() : null));
    }

    public TableMapping data(List<DataEntry> list, String str) {
        return new TableMapping(String.format(Locale.US, this.jsBase + ".data(%s, %s)", arrayToString(list), wrapQuotes(str)));
    }

    @Override // com.anychart.core.series.Base
    public Object yScale(Class cls) {
        try {
            return cls.getDeclaredConstructor(String.class).newInstance(this.jsBase + ".yScale()");
        } catch (IllegalAccessException e2) {
            e2.printStackTrace();
            return null;
        } catch (InstantiationException e3) {
            e3.printStackTrace();
            return null;
        } catch (NoSuchMethodException e4) {
            e4.printStackTrace();
            return null;
        } catch (InvocationTargetException e5) {
            e5.printStackTrace();
            return null;
        }
    }
}
