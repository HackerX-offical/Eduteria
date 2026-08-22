package com.anychart.core.annotations;

import com.amazonaws.services.s3.model.InstructionFileId;
import com.anychart.APIlib;
import com.anychart.chart.common.listener.ListenersInterface;
import com.anychart.core.VisualBase;
import com.anychart.enums.AnnotationTypes;
import com.anychart.graphics.vector.Layer;
import com.anychart.graphics.vector.PaperSize;
import com.anychart.graphics.vector.Stage;
import com.anychart.math.Rect;
import java.util.Locale;

/* JADX INFO: loaded from: classes5.dex */
public class PlotController extends VisualBase {
    protected PlotController() {
    }

    public static PlotController instantiate() {
        return new PlotController("new anychart.core.annotations.plotController()");
    }

    public PlotController(String str) {
        StringBuilder sb = new StringBuilder("plotController");
        int i = variableIndex + 1;
        variableIndex = i;
        this.jsBase = sb.append(i).toString();
        APIlib.getInstance().addJSLine(this.jsBase + " = " + str + ";");
    }

    @Override // com.anychart.core.VisualBase, com.anychart.core.Base, com.anychart.JsObject
    public String getJsBase() {
        return this.jsBase;
    }

    public Base add(AnnotationTypes annotationTypes) {
        return new Base(String.format(Locale.US, this.jsBase + ".add(%s)", annotationTypes != null ? annotationTypes.getJsBase() : null));
    }

    public Base add(String str) {
        return new Base(String.format(Locale.US, this.jsBase + ".add(%s)", wrapQuotes(str)));
    }

    public Base add(AnnotationJSONFormat annotationJSONFormat) {
        return new Base(String.format(Locale.US, this.jsBase + ".add(%s)", annotationJSONFormat != null ? annotationJSONFormat.getJsBase() : null));
    }

    public AndrewsPitchfork andrewsPitchfork(String str) {
        return new AndrewsPitchfork(String.format(Locale.US, this.jsBase + ".andrewsPitchfork(%s)", wrapQuotes(str)));
    }

    public void cancelDrawing() {
        APIlib.getInstance().addJSLine(this.jsBase + ".cancelDrawing();");
    }

    public Ellipse ellipse(String str) {
        return new Ellipse(String.format(Locale.US, this.jsBase + ".ellipse(%s)", wrapQuotes(str)));
    }

    @Override // com.anychart.core.VisualBase
    public void enabled() {
        APIlib.getInstance().addJSLine(this.jsBase + ".enabled();");
    }

    @Override // com.anychart.core.VisualBase
    public PlotController enabled(Boolean bool) {
        APIlib.getInstance().addJSLine(String.format(Locale.US, this.jsBase + ".enabled(%s);", bool));
        return this;
    }

    public FibonacciArc fibonacciArc(String str) {
        return new FibonacciArc(String.format(Locale.US, this.jsBase + ".fibonacciArc(%s)", wrapQuotes(str)));
    }

    public FibonacciFan fibonacciFan(String str) {
        return new FibonacciFan(String.format(Locale.US, this.jsBase + ".fibonacciFan(%s)", wrapQuotes(str)));
    }

    public FibonacciRetracement fibonacciRetracement(String str) {
        return new FibonacciRetracement(String.format(Locale.US, this.jsBase + ".fibonacciRetracement(%s)", wrapQuotes(str)));
    }

    public FibonacciTimezones fibonacciTimezones(String str) {
        return new FibonacciTimezones(String.format(Locale.US, this.jsBase + ".fibonacciTimezones(%s)", wrapQuotes(str)));
    }

    public PlotController fromJson(String str) {
        APIlib.getInstance().addJSLine(String.format(Locale.US, this.jsBase + ".fromJson(%s);", wrapQuotes(str)));
        return this;
    }

    public PlotController fromXml(String str) {
        APIlib.getInstance().addJSLine(String.format(Locale.US, this.jsBase + ".fromXml(%s);", wrapQuotes(str)));
        return this;
    }

    public Base getAnnotationAt(Number number) {
        return new Base(String.format(Locale.US, this.jsBase + ".getAnnotationAt(%s)", number));
    }

    public void getAnnotationsCount() {
        APIlib.getInstance().addJSLine(this.jsBase + ".getAnnotationsCount();");
    }

    public Base getSelectedAnnotation() {
        return new Base(this.jsBase + ".getSelectedAnnotation()");
    }

    public HorizontalLine horizontalLine(String str) {
        return new HorizontalLine(String.format(Locale.US, this.jsBase + ".horizontalLine(%s)", wrapQuotes(str)));
    }

    public InfiniteLine infiniteLine(String str) {
        return new InfiniteLine(String.format(Locale.US, this.jsBase + ".infiniteLine(%s)", wrapQuotes(str)));
    }

    public Label label(String str) {
        return new Label(String.format(Locale.US, this.jsBase + ".label(%s)", wrapQuotes(str)));
    }

    public Line line(String str) {
        return new Line(String.format(Locale.US, this.jsBase + ".line(%s)", wrapQuotes(str)));
    }

    public Marker marker(String str) {
        return new Marker(String.format(Locale.US, this.jsBase + ".marker(%s)", wrapQuotes(str)));
    }

    @Override // com.anychart.core.VisualBase
    public void print(PaperSize paperSize, Boolean bool) {
        APIlib.getInstance().addJSLine(String.format(Locale.US, this.jsBase + ".print(%s, %s);", paperSize != null ? paperSize.getJsBase() : null, bool));
    }

    @Override // com.anychart.core.VisualBase
    public void print(String str, Boolean bool) {
        APIlib.getInstance().addJSLine(String.format(Locale.US, this.jsBase + ".print(%s, %s);", wrapQuotes(str), bool));
    }

    public Ray ray(String str) {
        return new Ray(String.format(Locale.US, this.jsBase + ".ray(%s)", wrapQuotes(str)));
    }

    public Rectangle rectangle(String str) {
        return new Rectangle(String.format(Locale.US, this.jsBase + ".rectangle(%s)", wrapQuotes(str)));
    }

    public PlotController removeAllAnnotations() {
        APIlib.getInstance().addJSLine(this.jsBase + ".removeAllAnnotations();");
        return this;
    }

    @Override // com.anychart.core.VisualBase, com.anychart.core.Base
    public void removeAllListeners(String str) {
        APIlib.getInstance().addJSLine(String.format(Locale.US, this.jsBase + ".removeAllListeners(%s);", wrapQuotes(str)));
    }

    public PlotController removeAnnotation(Base base) {
        APIlib.getInstance().addJSLine(String.format(Locale.US, this.jsBase + ".removeAnnotation(%s);", base != null ? base.getJsBase() : null));
        return this;
    }

    public PlotController removeAnnotationAt(Number number) {
        APIlib.getInstance().addJSLine(String.format(Locale.US, this.jsBase + ".removeAnnotationAt(%s);", number));
        return this;
    }

    public PlotController select(Base base) {
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

    public void toJson(Boolean bool) {
        APIlib.getInstance().addJSLine(String.format(Locale.US, this.jsBase + ".toJson(%s);", bool));
    }

    public void toXml(Boolean bool) {
        APIlib.getInstance().addJSLine(String.format(Locale.US, this.jsBase + ".toXml(%s);", bool));
    }

    public TrendChannel trendChannel(String str) {
        return new TrendChannel(String.format(Locale.US, this.jsBase + ".trendChannel(%s)", wrapQuotes(str)));
    }

    public Triangle triangle(String str) {
        return new Triangle(String.format(Locale.US, this.jsBase + ".triangle(%s)", wrapQuotes(str)));
    }

    @Override // com.anychart.core.VisualBase, com.anychart.core.Base
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

    @Override // com.anychart.core.VisualBase, com.anychart.core.Base
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

    @Override // com.anychart.core.VisualBase, com.anychart.core.Base
    public void unlistenByKey(String str) {
        APIlib.getInstance().addJSLine(String.format(Locale.US, this.jsBase + ".unlistenByKey(%s);", wrapQuotes(str)));
    }

    public PlotController unselect() {
        APIlib.getInstance().addJSLine(this.jsBase + ".unselect();");
        return this;
    }

    public VerticalLine verticalLine(String str) {
        return new VerticalLine(String.format(Locale.US, this.jsBase + ".verticalLine(%s)", wrapQuotes(str)));
    }

    @Override // com.anychart.core.VisualBase
    public void zIndex() {
        APIlib.getInstance().addJSLine(this.jsBase + ".zIndex();");
    }

    @Override // com.anychart.core.VisualBase
    public PlotController zIndex(Number number) {
        APIlib.getInstance().addJSLine(String.format(Locale.US, this.jsBase + ".zIndex(%s);", number));
        return this;
    }

    @Override // com.anychart.core.VisualBase
    public Layer container() {
        return new Layer(this.jsBase + ".container()");
    }

    @Override // com.anychart.core.VisualBase
    public PlotController container(Layer layer) {
        APIlib.getInstance().addJSLine(String.format(Locale.US, this.jsBase + ".container(%s);", layer != null ? layer.getJsBase() : null));
        return this;
    }

    @Override // com.anychart.core.VisualBase
    public PlotController container(Stage stage) {
        APIlib.getInstance().addJSLine(String.format(Locale.US, this.jsBase + ".container(%s);", stage != null ? stage.getJsBase() : null));
        return this;
    }

    @Override // com.anychart.core.VisualBase
    public PlotController container(String str) {
        APIlib.getInstance().addJSLine(String.format(Locale.US, this.jsBase + ".container(%s);", wrapQuotes(str)));
        return this;
    }

    @Override // com.anychart.core.VisualBase
    public Rect parentBounds() {
        return new Rect(this.jsBase + ".parentBounds()");
    }

    @Override // com.anychart.core.VisualBase
    public PlotController parentBounds(Rect rect) {
        APIlib.getInstance().addJSLine(String.format(Locale.US, this.jsBase + ".parentBounds(%s);", rect != null ? rect.getJsBase() : null));
        return this;
    }

    @Override // com.anychart.core.VisualBase
    public PlotController parentBounds(String str) {
        APIlib.getInstance().addJSLine(String.format(Locale.US, this.jsBase + ".parentBounds(%s);", wrapQuotes(str)));
        return this;
    }

    @Override // com.anychart.core.VisualBase
    public PlotController parentBounds(Number number) {
        APIlib.getInstance().addJSLine(String.format(Locale.US, this.jsBase + ".parentBounds(%s);", number));
        return this;
    }

    @Override // com.anychart.core.VisualBase
    public PlotController parentBounds(Number number, Number number2, Number number3, Number number4) {
        APIlib.getInstance().addJSLine(String.format(Locale.US, this.jsBase + ".parentBounds(%s, %s, %s, %s);", number, number2, number3, number4));
        return this;
    }
}
