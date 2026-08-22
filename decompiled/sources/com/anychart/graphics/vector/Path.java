package com.anychart.graphics.vector;

import com.amazonaws.services.s3.model.InstructionFileId;
import com.anychart.APIlib;
import com.anychart.chart.common.listener.ListenersInterface;
import com.anychart.graphics.math.Coordinate;
import java.util.Locale;

/* JADX INFO: loaded from: classes4.dex */
public class Path extends Shape {
    protected Path() {
    }

    public static Path instantiate() {
        return new Path("new anychart.graphics.vector.path()");
    }

    public Path(String str) {
        StringBuilder sb = new StringBuilder("path");
        int i = variableIndex + 1;
        variableIndex = i;
        this.jsBase = sb.append(i).toString();
        APIlib.getInstance().addJSLine(this.jsBase + " = " + str + ";");
    }

    @Override // com.anychart.graphics.vector.Shape, com.anychart.graphics.vector.Element, com.anychart.JsObject
    public String getJsBase() {
        return this.jsBase;
    }

    @Override // com.anychart.graphics.vector.Shape, com.anychart.graphics.vector.Element
    public Path appendTransformationMatrix(Number number, Number number2, Number number3, Number number4, Number number5, Number number6) {
        APIlib.getInstance().addJSLine(String.format(Locale.US, this.jsBase + ".appendTransformationMatrix(%s, %s, %s, %s, %s, %s);", number, number2, number3, number4, number5, number6));
        return this;
    }

    public Path arcTo(Number number, Number number2, Number number3, Number number4) {
        APIlib.getInstance().addJSLine(String.format(Locale.US, this.jsBase + ".arcTo(%s, %s, %s, %s);", number, number2, number3, number4));
        return this;
    }

    public Path arcToAsCurves(Number number, Number number2, Number number3, Number number4) {
        APIlib.getInstance().addJSLine(String.format(Locale.US, this.jsBase + ".arcToAsCurves(%s, %s, %s, %s);", number, number2, number3, number4));
        return this;
    }

    public Path arcToByEndPoint(Number number, Number number2, Number number3, Number number4, Boolean bool, Boolean bool2) {
        APIlib.getInstance().addJSLine(String.format(Locale.US, this.jsBase + ".arcToByEndPoint(%s, %s, %s, %s, %s, %s);", number, number2, number3, number4, bool, bool2));
        return this;
    }

    @Override // com.anychart.graphics.vector.Shape, com.anychart.graphics.vector.Element
    public void attr(String str) {
        APIlib.getInstance().addJSLine(String.format(Locale.US, this.jsBase + ".attr(%s);", wrapQuotes(str)));
    }

    @Override // com.anychart.graphics.vector.Shape, com.anychart.graphics.vector.Element
    public Path attr(String str, String str2) {
        APIlib.getInstance().addJSLine(String.format(Locale.US, this.jsBase + ".attr(%s, %s);", wrapQuotes(str), wrapQuotes(str2)));
        return this;
    }

    public Path circularArc(Number number, Number number2, Number number3, Number number4, Number number5, Number number6, Boolean bool) {
        APIlib.getInstance().addJSLine(String.format(Locale.US, this.jsBase + ".circularArc(%s, %s, %s, %s, %s, %s, %s);", number, number2, number3, number4, number5, number6, bool));
        return this;
    }

    public Path clear() {
        APIlib.getInstance().addJSLine(this.jsBase + ".clear();");
        return this;
    }

    @Override // com.anychart.graphics.vector.Shape, com.anychart.graphics.vector.Element
    public com.anychart.graphics.math.Rect clip() {
        return new com.anychart.graphics.math.Rect(this.jsBase + ".clip()");
    }

    @Override // com.anychart.graphics.vector.Shape, com.anychart.graphics.vector.Element
    public Path clip(com.anychart.graphics.math.Rect rect) {
        APIlib.getInstance().addJSLine(String.format(Locale.US, this.jsBase + ".clip(%s);", rect != null ? rect.getJsBase() : null));
        return this;
    }

    @Override // com.anychart.graphics.vector.Shape, com.anychart.graphics.vector.Element
    public Path clip(String str) {
        APIlib.getInstance().addJSLine(String.format(Locale.US, this.jsBase + ".clip(%s);", wrapQuotes(str)));
        return this;
    }

    public Path close() {
        APIlib.getInstance().addJSLine(this.jsBase + ".close();");
        return this;
    }

    @Override // com.anychart.graphics.vector.Shape, com.anychart.graphics.vector.Element
    public void cursor() {
        APIlib.getInstance().addJSLine(this.jsBase + ".cursor();");
    }

    @Override // com.anychart.graphics.vector.Shape, com.anychart.graphics.vector.Element
    public Path cursor(Cursor cursor) {
        APIlib.getInstance().addJSLine(String.format(Locale.US, this.jsBase + ".cursor(%s);", cursor != null ? cursor.getJsBase() : null));
        return this;
    }

    public Path curveTo(Number number, Number number2, Number number3, Number number4, Number number5, Number number6, Number number7) {
        APIlib.getInstance().addJSLine(String.format(Locale.US, this.jsBase + ".curveTo(%s, %s, %s, %s, %s, %s, %s);", number, number2, number3, number4, number5, number6, number7));
        return this;
    }

    @Override // com.anychart.graphics.vector.Shape, com.anychart.graphics.vector.Element
    public void desc() {
        APIlib.getInstance().addJSLine(this.jsBase + ".desc();");
    }

    @Override // com.anychart.graphics.vector.Shape, com.anychart.graphics.vector.Element
    public Path desc(String str) {
        APIlib.getInstance().addJSLine(String.format(Locale.US, this.jsBase + ".desc(%s);", wrapQuotes(str)));
        return this;
    }

    @Override // com.anychart.graphics.vector.Shape, com.anychart.graphics.vector.Element
    public void disablePointerEvents() {
        APIlib.getInstance().addJSLine(this.jsBase + ".disablePointerEvents();");
    }

    @Override // com.anychart.graphics.vector.Shape, com.anychart.graphics.vector.Element
    public Path disablePointerEvents(Boolean bool) {
        APIlib.getInstance().addJSLine(String.format(Locale.US, this.jsBase + ".disablePointerEvents(%s);", bool));
        return this;
    }

    @Override // com.anychart.graphics.vector.Shape, com.anychart.graphics.vector.Element
    public void disableStrokeScaling() {
        APIlib.getInstance().addJSLine(this.jsBase + ".disableStrokeScaling();");
    }

    @Override // com.anychart.graphics.vector.Shape, com.anychart.graphics.vector.Element
    public Path disableStrokeScaling(Boolean bool) {
        APIlib.getInstance().addJSLine(String.format(Locale.US, this.jsBase + ".disableStrokeScaling(%s);", bool));
        return this;
    }

    @Override // com.anychart.graphics.vector.Shape, com.anychart.graphics.vector.Element
    public void dispose() {
        APIlib.getInstance().addJSLine(this.jsBase + ".dispose();");
    }

    @Override // com.anychart.graphics.vector.Shape, com.anychart.graphics.vector.Element
    public void domElement() {
        APIlib.getInstance().addJSLine(this.jsBase + ".domElement();");
    }

    @Override // com.anychart.graphics.vector.Shape, com.anychart.graphics.vector.Element
    public void drag() {
        APIlib.getInstance().addJSLine(this.jsBase + ".drag();");
    }

    @Override // com.anychart.graphics.vector.Shape, com.anychart.graphics.vector.Element
    public Path drag(Boolean bool) {
        APIlib.getInstance().addJSLine(String.format(Locale.US, this.jsBase + ".drag(%s);", bool));
        return this;
    }

    @Override // com.anychart.graphics.vector.Shape, com.anychart.graphics.vector.Element
    public Path drag(com.anychart.graphics.math.Rect rect) {
        APIlib.getInstance().addJSLine(String.format(Locale.US, this.jsBase + ".drag(%s);", rect != null ? rect.getJsBase() : null));
        return this;
    }

    @Override // com.anychart.graphics.vector.Shape
    public void fill() {
        APIlib.getInstance().addJSLine(this.jsBase + ".fill();");
    }

    @Override // com.anychart.graphics.vector.Shape
    public Path fill(Fill fill) {
        APIlib.getInstance().addJSLine(String.format(Locale.US, this.jsBase + ".fill(%s);", fill != null ? fill.getJsBase() : null));
        return this;
    }

    @Override // com.anychart.graphics.vector.Shape
    public Path fill(String str, Number number) {
        APIlib.getInstance().addJSLine(String.format(Locale.US, this.jsBase + ".fill(%s, %s);", wrapQuotes(str), number));
        return this;
    }

    @Override // com.anychart.graphics.vector.Shape
    public Path fill(GradientKey gradientKey, Number number, Boolean bool, Number number2) {
        APIlib.getInstance().addJSLine(String.format(Locale.US, this.jsBase + ".fill(%s, %s, %s, %s);", gradientKey != null ? gradientKey.getJsBase() : null, number, bool, number2));
        return this;
    }

    @Override // com.anychart.graphics.vector.Shape
    public Path fill(GradientKey gradientKey, Number number, Rect rect, Number number2) {
        APIlib.getInstance().addJSLine(String.format(Locale.US, this.jsBase + ".fill(%s, %s, %s, %s);", gradientKey != null ? gradientKey.getJsBase() : null, number, rect != null ? rect.getJsBase() : null, number2));
        return this;
    }

    @Override // com.anychart.graphics.vector.Shape
    public Path fill(GradientKey gradientKey, Number number, String str, Number number2) {
        APIlib.getInstance().addJSLine(String.format(Locale.US, this.jsBase + ".fill(%s, %s, %s, %s);", gradientKey != null ? gradientKey.getJsBase() : null, number, wrapQuotes(str), number2));
        return this;
    }

    @Override // com.anychart.graphics.vector.Shape
    public Path fill(String[] strArr, Number number, Boolean bool, Number number2) {
        APIlib.getInstance().addJSLine(String.format(Locale.US, this.jsBase + ".fill(%s, %s, %s, %s);", arrayToStringWrapQuotes(strArr), number, bool, number2));
        return this;
    }

    @Override // com.anychart.graphics.vector.Shape
    public Path fill(String[] strArr, Number number, Rect rect, Number number2) {
        APIlib.getInstance().addJSLine(String.format(Locale.US, this.jsBase + ".fill(%s, %s, %s, %s);", arrayToStringWrapQuotes(strArr), number, rect != null ? rect.getJsBase() : null, number2));
        return this;
    }

    @Override // com.anychart.graphics.vector.Shape
    public Path fill(String[] strArr, Number number, String str, Number number2) {
        APIlib.getInstance().addJSLine(String.format(Locale.US, this.jsBase + ".fill(%s, %s, %s, %s);", arrayToStringWrapQuotes(strArr), number, wrapQuotes(str), number2));
        return this;
    }

    @Override // com.anychart.graphics.vector.Shape
    public Path fill(GradientKey gradientKey, Number number, Number number2, com.anychart.graphics.math.Rect rect, Number number3, Number number4, Number number5) {
        APIlib.getInstance().addJSLine(String.format(Locale.US, this.jsBase + ".fill(%s, %s, %s, %s, %s, %s, %s);", gradientKey != null ? gradientKey.getJsBase() : null, number, number2, rect != null ? rect.getJsBase() : null, number3, number4, number5));
        return this;
    }

    @Override // com.anychart.graphics.vector.Shape
    public Path fill(String[] strArr, Number number, Number number2, com.anychart.graphics.math.Rect rect, Number number3, Number number4, Number number5) {
        APIlib.getInstance().addJSLine(String.format(Locale.US, this.jsBase + ".fill(%s, %s, %s, %s, %s, %s, %s);", arrayToStringWrapQuotes(strArr), number, number2, rect != null ? rect.getJsBase() : null, number3, number4, number5));
        return this;
    }

    @Override // com.anychart.graphics.vector.Shape, com.anychart.graphics.vector.Element
    public com.anychart.graphics.math.Rect getAbsoluteBounds() {
        return new com.anychart.graphics.math.Rect(this.jsBase + ".getAbsoluteBounds()");
    }

    @Override // com.anychart.graphics.vector.Shape, com.anychart.graphics.vector.Element
    public void getAbsoluteHeight() {
        APIlib.getInstance().addJSLine(this.jsBase + ".getAbsoluteHeight();");
    }

    @Override // com.anychart.graphics.vector.Shape, com.anychart.graphics.vector.Element
    public void getAbsoluteWidth() {
        APIlib.getInstance().addJSLine(this.jsBase + ".getAbsoluteWidth();");
    }

    @Override // com.anychart.graphics.vector.Shape, com.anychart.graphics.vector.Element
    public void getAbsoluteX() {
        APIlib.getInstance().addJSLine(this.jsBase + ".getAbsoluteX();");
    }

    @Override // com.anychart.graphics.vector.Shape, com.anychart.graphics.vector.Element
    public void getAbsoluteY() {
        APIlib.getInstance().addJSLine(this.jsBase + ".getAbsoluteY();");
    }

    @Override // com.anychart.graphics.vector.Shape, com.anychart.graphics.vector.Element
    public com.anychart.graphics.math.Rect getBounds() {
        return new com.anychart.graphics.math.Rect(this.jsBase + ".getBounds()");
    }

    public Coordinate getCurrentPoint() {
        return new Coordinate(this.jsBase + ".getCurrentPoint()");
    }

    @Override // com.anychart.graphics.vector.Shape, com.anychart.graphics.vector.Element
    public void getHeight() {
        APIlib.getInstance().addJSLine(this.jsBase + ".getHeight();");
    }

    public void getLength() {
        APIlib.getInstance().addJSLine(this.jsBase + ".getLength();");
    }

    @Override // com.anychart.graphics.vector.Shape, com.anychart.graphics.vector.Element
    public void getRotationAngle() {
        APIlib.getInstance().addJSLine(this.jsBase + ".getRotationAngle();");
    }

    @Override // com.anychart.graphics.vector.Shape, com.anychart.graphics.vector.Element
    public Stage getStage() {
        return new Stage(this.jsBase + ".getStage()");
    }

    @Override // com.anychart.graphics.vector.Shape, com.anychart.graphics.vector.Element
    public void getTransformationMatrix() {
        APIlib.getInstance().addJSLine(this.jsBase + ".getTransformationMatrix();");
    }

    @Override // com.anychart.graphics.vector.Shape, com.anychart.graphics.vector.Element
    public void getWidth() {
        APIlib.getInstance().addJSLine(this.jsBase + ".getWidth();");
    }

    @Override // com.anychart.graphics.vector.Shape, com.anychart.graphics.vector.Element
    public void getX() {
        APIlib.getInstance().addJSLine(this.jsBase + ".getX();");
    }

    @Override // com.anychart.graphics.vector.Shape, com.anychart.graphics.vector.Element
    public void getY() {
        APIlib.getInstance().addJSLine(this.jsBase + ".getY();");
    }

    @Override // com.anychart.graphics.vector.Shape, com.anychart.graphics.vector.Element
    public void hasParent() {
        APIlib.getInstance().addJSLine(this.jsBase + ".hasParent();");
    }

    @Override // com.anychart.graphics.vector.Shape, com.anychart.graphics.vector.Element
    public void id() {
        APIlib.getInstance().addJSLine(this.jsBase + ".id();");
    }

    @Override // com.anychart.graphics.vector.Shape, com.anychart.graphics.vector.Element
    public Path id(String str) {
        APIlib.getInstance().addJSLine(String.format(Locale.US, this.jsBase + ".id(%s);", wrapQuotes(str)));
        return this;
    }

    public Path lineTo(Number number, Number number2, Number number3) {
        APIlib.getInstance().addJSLine(String.format(Locale.US, this.jsBase + ".lineTo(%s, %s, %s);", number, number2, number3));
        return this;
    }

    public Path moveTo(Number number, Number number2) {
        APIlib.getInstance().addJSLine(String.format(Locale.US, this.jsBase + ".moveTo(%s, %s);", number, number2));
        return this;
    }

    @Override // com.anychart.graphics.vector.Shape, com.anychart.graphics.vector.Element
    public Layer parent() {
        return new Layer(this.jsBase + ".parent()");
    }

    @Override // com.anychart.graphics.vector.Shape, com.anychart.graphics.vector.Element
    public Path parent(Layer layer) {
        APIlib.getInstance().addJSLine(String.format(Locale.US, this.jsBase + ".parent(%s);", layer != null ? layer.getJsBase() : null));
        return this;
    }

    @Override // com.anychart.graphics.vector.Shape, com.anychart.graphics.vector.Element
    public Path parent(Stage stage) {
        APIlib.getInstance().addJSLine(String.format(Locale.US, this.jsBase + ".parent(%s);", stage != null ? stage.getJsBase() : null));
        return this;
    }

    public Path quadraticCurveTo(Number number, Number number2, Number number3, Number number4, Number number5) {
        APIlib.getInstance().addJSLine(String.format(Locale.US, this.jsBase + ".quadraticCurveTo(%s, %s, %s, %s, %s);", number, number2, number3, number4, number5));
        return this;
    }

    @Override // com.anychart.graphics.vector.Shape, com.anychart.graphics.vector.Element
    public Path remove() {
        APIlib.getInstance().addJSLine(this.jsBase + ".remove();");
        return this;
    }

    @Override // com.anychart.graphics.vector.Shape, com.anychart.graphics.vector.Element
    public void removeAllListeners(String str) {
        APIlib.getInstance().addJSLine(String.format(Locale.US, this.jsBase + ".removeAllListeners(%s);", wrapQuotes(str)));
    }

    @Override // com.anychart.graphics.vector.Shape, com.anychart.graphics.vector.Element
    public Path rotate(Number number, Number number2, Number number3) {
        APIlib.getInstance().addJSLine(String.format(Locale.US, this.jsBase + ".rotate(%s, %s, %s);", number, number2, number3));
        return this;
    }

    @Override // com.anychart.graphics.vector.Shape, com.anychart.graphics.vector.Element
    public Path rotateByAnchor(Number number, Anchor anchor) {
        APIlib.getInstance().addJSLine(String.format(Locale.US, this.jsBase + ".rotateByAnchor(%s, %s);", number, anchor != null ? anchor.getJsBase() : null));
        return this;
    }

    @Override // com.anychart.graphics.vector.Shape, com.anychart.graphics.vector.Element
    public Path rotateByAnchor(Number number, String str) {
        APIlib.getInstance().addJSLine(String.format(Locale.US, this.jsBase + ".rotateByAnchor(%s, %s);", number, wrapQuotes(str)));
        return this;
    }

    @Override // com.anychart.graphics.vector.Shape, com.anychart.graphics.vector.Element
    public Path scale(Number number, Number number2, Number number3, Number number4) {
        APIlib.getInstance().addJSLine(String.format(Locale.US, this.jsBase + ".scale(%s, %s, %s, %s);", number, number2, number3, number4));
        return this;
    }

    @Override // com.anychart.graphics.vector.Shape, com.anychart.graphics.vector.Element
    public Path scaleByAnchor(Number number, Number number2, Anchor anchor) {
        APIlib.getInstance().addJSLine(String.format(Locale.US, this.jsBase + ".scaleByAnchor(%s, %s, %s);", number, number2, anchor != null ? anchor.getJsBase() : null));
        return this;
    }

    @Override // com.anychart.graphics.vector.Shape, com.anychart.graphics.vector.Element
    public Path scaleByAnchor(Number number, Number number2, String str) {
        APIlib.getInstance().addJSLine(String.format(Locale.US, this.jsBase + ".scaleByAnchor(%s, %s, %s);", number, number2, wrapQuotes(str)));
        return this;
    }

    @Override // com.anychart.graphics.vector.Shape, com.anychart.graphics.vector.Element
    public Path setPosition(Number number, Number number2) {
        APIlib.getInstance().addJSLine(String.format(Locale.US, this.jsBase + ".setPosition(%s, %s);", number, number2));
        return this;
    }

    @Override // com.anychart.graphics.vector.Shape, com.anychart.graphics.vector.Element
    public Path setRotation(Number number, Number number2, Number number3) {
        APIlib.getInstance().addJSLine(String.format(Locale.US, this.jsBase + ".setRotation(%s, %s, %s);", number, number2, number3));
        return this;
    }

    @Override // com.anychart.graphics.vector.Shape, com.anychart.graphics.vector.Element
    public Path setRotationByAnchor(Number number, Anchor anchor) {
        APIlib.getInstance().addJSLine(String.format(Locale.US, this.jsBase + ".setRotationByAnchor(%s, %s);", number, anchor != null ? anchor.getJsBase() : null));
        return this;
    }

    @Override // com.anychart.graphics.vector.Shape, com.anychart.graphics.vector.Element
    public Path setRotationByAnchor(Number number, String str) {
        APIlib.getInstance().addJSLine(String.format(Locale.US, this.jsBase + ".setRotationByAnchor(%s, %s);", number, wrapQuotes(str)));
        return this;
    }

    @Override // com.anychart.graphics.vector.Shape, com.anychart.graphics.vector.Element
    public Path setTransformationMatrix(Number number, Number number2, Number number3, Number number4, Number number5, Number number6) {
        APIlib.getInstance().addJSLine(String.format(Locale.US, this.jsBase + ".setTransformationMatrix(%s, %s, %s, %s, %s, %s);", number, number2, number3, number4, number5, number6));
        return this;
    }

    @Override // com.anychart.graphics.vector.Shape
    public void stroke() {
        APIlib.getInstance().addJSLine(this.jsBase + ".stroke();");
    }

    @Override // com.anychart.graphics.vector.Shape
    public Path stroke(Stroke stroke) {
        APIlib.getInstance().addJSLine(String.format(Locale.US, this.jsBase + ".stroke(%s);", stroke != null ? stroke.getJsBase() : null));
        return this;
    }

    @Override // com.anychart.graphics.vector.Shape
    public Path stroke(ColoredFill coloredFill) {
        APIlib.getInstance().addJSLine(String.format(Locale.US, this.jsBase + ".stroke(%s);", coloredFill != null ? coloredFill.getJsBase() : null));
        return this;
    }

    @Override // com.anychart.graphics.vector.Shape
    public Path stroke(String str) {
        APIlib.getInstance().addJSLine(String.format(Locale.US, this.jsBase + ".stroke(%s);", wrapQuotes(str)));
        return this;
    }

    @Override // com.anychart.graphics.vector.Shape
    public Path stroke(Stroke stroke, Number number, String str, String str2, String str3) {
        APIlib.getInstance().addJSLine(String.format(Locale.US, this.jsBase + ".stroke(%s, %s, %s, %s, %s);", stroke != null ? stroke.getJsBase() : null, number, wrapQuotes(str), wrapQuotes(str2), wrapQuotes(str3)));
        return this;
    }

    @Override // com.anychart.graphics.vector.Shape
    public Path stroke(Stroke stroke, Number number, String str, String str2, StrokeLineCap strokeLineCap) {
        APIlib.getInstance().addJSLine(String.format(Locale.US, this.jsBase + ".stroke(%s, %s, %s, %s, %s);", stroke != null ? stroke.getJsBase() : null, number, wrapQuotes(str), wrapQuotes(str2), strokeLineCap != null ? strokeLineCap.getJsBase() : null));
        return this;
    }

    @Override // com.anychart.graphics.vector.Shape
    public Path stroke(Stroke stroke, Number number, String str, StrokeLineJoin strokeLineJoin, String str2) {
        APIlib.getInstance().addJSLine(String.format(Locale.US, this.jsBase + ".stroke(%s, %s, %s, %s, %s);", stroke != null ? stroke.getJsBase() : null, number, wrapQuotes(str), strokeLineJoin != null ? strokeLineJoin.getJsBase() : null, wrapQuotes(str2)));
        return this;
    }

    @Override // com.anychart.graphics.vector.Shape
    public Path stroke(Stroke stroke, Number number, String str, StrokeLineJoin strokeLineJoin, StrokeLineCap strokeLineCap) {
        APIlib.getInstance().addJSLine(String.format(Locale.US, this.jsBase + ".stroke(%s, %s, %s, %s, %s);", stroke != null ? stroke.getJsBase() : null, number, wrapQuotes(str), strokeLineJoin != null ? strokeLineJoin.getJsBase() : null, strokeLineCap != null ? strokeLineCap.getJsBase() : null));
        return this;
    }

    @Override // com.anychart.graphics.vector.Shape
    public Path stroke(ColoredFill coloredFill, Number number, String str, String str2, String str3) {
        APIlib.getInstance().addJSLine(String.format(Locale.US, this.jsBase + ".stroke(%s, %s, %s, %s, %s);", coloredFill != null ? coloredFill.getJsBase() : null, number, wrapQuotes(str), wrapQuotes(str2), wrapQuotes(str3)));
        return this;
    }

    @Override // com.anychart.graphics.vector.Shape
    public Path stroke(ColoredFill coloredFill, Number number, String str, String str2, StrokeLineCap strokeLineCap) {
        APIlib.getInstance().addJSLine(String.format(Locale.US, this.jsBase + ".stroke(%s, %s, %s, %s, %s);", coloredFill != null ? coloredFill.getJsBase() : null, number, wrapQuotes(str), wrapQuotes(str2), strokeLineCap != null ? strokeLineCap.getJsBase() : null));
        return this;
    }

    @Override // com.anychart.graphics.vector.Shape
    public Path stroke(ColoredFill coloredFill, Number number, String str, StrokeLineJoin strokeLineJoin, String str2) {
        APIlib.getInstance().addJSLine(String.format(Locale.US, this.jsBase + ".stroke(%s, %s, %s, %s, %s);", coloredFill != null ? coloredFill.getJsBase() : null, number, wrapQuotes(str), strokeLineJoin != null ? strokeLineJoin.getJsBase() : null, wrapQuotes(str2)));
        return this;
    }

    @Override // com.anychart.graphics.vector.Shape
    public Path stroke(ColoredFill coloredFill, Number number, String str, StrokeLineJoin strokeLineJoin, StrokeLineCap strokeLineCap) {
        APIlib.getInstance().addJSLine(String.format(Locale.US, this.jsBase + ".stroke(%s, %s, %s, %s, %s);", coloredFill != null ? coloredFill.getJsBase() : null, number, wrapQuotes(str), strokeLineJoin != null ? strokeLineJoin.getJsBase() : null, strokeLineCap != null ? strokeLineCap.getJsBase() : null));
        return this;
    }

    @Override // com.anychart.graphics.vector.Shape
    public Path stroke(String str, Number number, String str2, String str3, String str4) {
        APIlib.getInstance().addJSLine(String.format(Locale.US, this.jsBase + ".stroke(%s, %s, %s, %s, %s);", wrapQuotes(str), number, wrapQuotes(str2), wrapQuotes(str3), wrapQuotes(str4)));
        return this;
    }

    @Override // com.anychart.graphics.vector.Shape
    public Path stroke(String str, Number number, String str2, String str3, StrokeLineCap strokeLineCap) {
        APIlib.getInstance().addJSLine(String.format(Locale.US, this.jsBase + ".stroke(%s, %s, %s, %s, %s);", wrapQuotes(str), number, wrapQuotes(str2), wrapQuotes(str3), strokeLineCap != null ? strokeLineCap.getJsBase() : null));
        return this;
    }

    @Override // com.anychart.graphics.vector.Shape
    public Path stroke(String str, Number number, String str2, StrokeLineJoin strokeLineJoin, String str3) {
        APIlib.getInstance().addJSLine(String.format(Locale.US, this.jsBase + ".stroke(%s, %s, %s, %s, %s);", wrapQuotes(str), number, wrapQuotes(str2), strokeLineJoin != null ? strokeLineJoin.getJsBase() : null, wrapQuotes(str3)));
        return this;
    }

    @Override // com.anychart.graphics.vector.Shape
    public Path stroke(String str, Number number, String str2, StrokeLineJoin strokeLineJoin, StrokeLineCap strokeLineCap) {
        APIlib.getInstance().addJSLine(String.format(Locale.US, this.jsBase + ".stroke(%s, %s, %s, %s, %s);", wrapQuotes(str), number, wrapQuotes(str2), strokeLineJoin != null ? strokeLineJoin.getJsBase() : null, strokeLineCap != null ? strokeLineCap.getJsBase() : null));
        return this;
    }

    @Override // com.anychart.graphics.vector.Shape
    public void strokeThickness() {
        APIlib.getInstance().addJSLine(this.jsBase + ".strokeThickness();");
    }

    @Override // com.anychart.graphics.vector.Shape
    public Path strokeThickness(Number number) {
        APIlib.getInstance().addJSLine(String.format(Locale.US, this.jsBase + ".strokeThickness(%s);", number));
        return this;
    }

    @Override // com.anychart.graphics.vector.Shape, com.anychart.graphics.vector.Element
    public void title() {
        APIlib.getInstance().addJSLine(this.jsBase + ".title();");
    }

    @Override // com.anychart.graphics.vector.Shape, com.anychart.graphics.vector.Element
    public Path title(String str) {
        APIlib.getInstance().addJSLine(String.format(Locale.US, this.jsBase + ".title(%s);", wrapQuotes(str)));
        return this;
    }

    @Override // com.anychart.graphics.vector.Shape, com.anychart.graphics.vector.Element
    public Path translate(Number number, Number number2) {
        APIlib.getInstance().addJSLine(String.format(Locale.US, this.jsBase + ".translate(%s, %s);", number, number2));
        return this;
    }

    @Override // com.anychart.graphics.vector.Shape, com.anychart.graphics.vector.Element
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

    @Override // com.anychart.graphics.vector.Shape, com.anychart.graphics.vector.Element
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

    @Override // com.anychart.graphics.vector.Shape, com.anychart.graphics.vector.Element
    public void visible() {
        APIlib.getInstance().addJSLine(this.jsBase + ".visible();");
    }

    @Override // com.anychart.graphics.vector.Shape, com.anychart.graphics.vector.Element
    public Path visible(Boolean bool) {
        APIlib.getInstance().addJSLine(String.format(Locale.US, this.jsBase + ".visible(%s);", bool));
        return this;
    }

    @Override // com.anychart.graphics.vector.Shape, com.anychart.graphics.vector.Element
    public void zIndex() {
        APIlib.getInstance().addJSLine(this.jsBase + ".zIndex();");
    }

    @Override // com.anychart.graphics.vector.Shape, com.anychart.graphics.vector.Element
    public Path zIndex(Number number) {
        APIlib.getInstance().addJSLine(String.format(Locale.US, this.jsBase + ".zIndex(%s);", number));
        return this;
    }

    @Override // com.anychart.graphics.vector.Shape, com.anychart.graphics.vector.Element
    public void unlistenByKey(String str) {
        APIlib.getInstance().addJSLine(String.format(Locale.US, this.jsBase + ".unlistenByKey(%s);", wrapQuotes(str)));
    }

    @Override // com.anychart.graphics.vector.Shape
    public Path fill(String str) {
        APIlib.getInstance().addJSLine(String.format(Locale.US, this.jsBase + ".fill(%s);", wrapQuotes(str)));
        return this;
    }
}
