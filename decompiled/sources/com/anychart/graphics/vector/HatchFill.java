package com.anychart.graphics.vector;

import com.amazonaws.services.s3.model.InstructionFileId;
import com.anychart.APIlib;
import com.anychart.chart.common.listener.ListenersInterface;
import java.util.Locale;

/* JADX INFO: loaded from: classes4.dex */
public class HatchFill extends PatternFill {
    protected HatchFill() {
    }

    public static HatchFill instantiate() {
        return new HatchFill("new anychart.graphics.vector.hatchFill()");
    }

    public HatchFill(String str) {
        StringBuilder sb = new StringBuilder("hatchFill");
        int i = variableIndex + 1;
        variableIndex = i;
        this.jsBase = sb.append(i).toString();
        APIlib.getInstance().addJSLine(this.jsBase + " = " + str + ";");
    }

    @Override // com.anychart.graphics.vector.PatternFill, com.anychart.graphics.vector.Layer, com.anychart.graphics.vector.Element, com.anychart.JsObject
    public String getJsBase() {
        return this.jsBase;
    }

    @Override // com.anychart.graphics.vector.PatternFill, com.anychart.graphics.vector.Layer
    public HatchFill addChild(Element element) {
        APIlib.getInstance().addJSLine(String.format(Locale.US, this.jsBase + ".addChild(%s);", element != null ? element.getJsBase() : null));
        return this;
    }

    @Override // com.anychart.graphics.vector.PatternFill, com.anychart.graphics.vector.Layer
    public HatchFill addChildAt(Element element, Number number) {
        APIlib.getInstance().addJSLine(String.format(Locale.US, this.jsBase + ".addChildAt(%s, %s);", element != null ? element.getJsBase() : null, number));
        return this;
    }

    @Override // com.anychart.graphics.vector.PatternFill, com.anychart.graphics.vector.Layer, com.anychart.graphics.vector.Element
    public HatchFill appendTransformationMatrix(Number number, Number number2, Number number3, Number number4, Number number5, Number number6) {
        APIlib.getInstance().addJSLine(String.format(Locale.US, this.jsBase + ".appendTransformationMatrix(%s, %s, %s, %s, %s, %s);", number, number2, number3, number4, number5, number6));
        return this;
    }

    @Override // com.anychart.graphics.vector.PatternFill, com.anychart.graphics.vector.Layer, com.anychart.graphics.vector.Element
    public void attr(String str) {
        APIlib.getInstance().addJSLine(String.format(Locale.US, this.jsBase + ".attr(%s);", wrapQuotes(str)));
    }

    @Override // com.anychart.graphics.vector.PatternFill, com.anychart.graphics.vector.Layer, com.anychart.graphics.vector.Element
    public HatchFill attr(String str, String str2) {
        APIlib.getInstance().addJSLine(String.format(Locale.US, this.jsBase + ".attr(%s, %s);", wrapQuotes(str), wrapQuotes(str2)));
        return this;
    }

    @Override // com.anychart.graphics.vector.PatternFill, com.anychart.graphics.vector.Layer
    public Circle circle(Number number, Number number2, Number number3) {
        return new Circle(String.format(Locale.US, this.jsBase + ".circle(%s, %s, %s)", number, number2, number3));
    }

    @Override // com.anychart.graphics.vector.PatternFill, com.anychart.graphics.vector.Layer, com.anychart.graphics.vector.Element
    public com.anychart.graphics.math.Rect clip() {
        return new com.anychart.graphics.math.Rect(this.jsBase + ".clip()");
    }

    @Override // com.anychart.graphics.vector.PatternFill, com.anychart.graphics.vector.Layer, com.anychart.graphics.vector.Element
    public HatchFill clip(com.anychart.graphics.math.Rect rect) {
        APIlib.getInstance().addJSLine(String.format(Locale.US, this.jsBase + ".clip(%s);", rect != null ? rect.getJsBase() : null));
        return this;
    }

    @Override // com.anychart.graphics.vector.PatternFill, com.anychart.graphics.vector.Layer, com.anychart.graphics.vector.Element
    public HatchFill clip(String str) {
        APIlib.getInstance().addJSLine(String.format(Locale.US, this.jsBase + ".clip(%s);", wrapQuotes(str)));
        return this;
    }

    @Override // com.anychart.graphics.vector.PatternFill, com.anychart.graphics.vector.Layer
    public void cross() {
        APIlib.getInstance().addJSLine(this.jsBase + ".cross();");
    }

    @Override // com.anychart.graphics.vector.PatternFill, com.anychart.graphics.vector.Layer, com.anychart.graphics.vector.Element
    public void cursor() {
        APIlib.getInstance().addJSLine(this.jsBase + ".cursor();");
    }

    @Override // com.anychart.graphics.vector.PatternFill, com.anychart.graphics.vector.Layer, com.anychart.graphics.vector.Element
    public HatchFill cursor(Cursor cursor) {
        APIlib.getInstance().addJSLine(String.format(Locale.US, this.jsBase + ".cursor(%s);", cursor != null ? cursor.getJsBase() : null));
        return this;
    }

    @Override // com.anychart.graphics.vector.PatternFill, com.anychart.graphics.vector.Layer, com.anychart.graphics.vector.Element
    public void desc() {
        APIlib.getInstance().addJSLine(this.jsBase + ".desc();");
    }

    @Override // com.anychart.graphics.vector.PatternFill, com.anychart.graphics.vector.Layer, com.anychart.graphics.vector.Element
    public HatchFill desc(String str) {
        APIlib.getInstance().addJSLine(String.format(Locale.US, this.jsBase + ".desc(%s);", wrapQuotes(str)));
        return this;
    }

    @Override // com.anychart.graphics.vector.PatternFill, com.anychart.graphics.vector.Layer
    public void diagonalCross() {
        APIlib.getInstance().addJSLine(this.jsBase + ".diagonalCross();");
    }

    @Override // com.anychart.graphics.vector.PatternFill, com.anychart.graphics.vector.Layer
    public void diamond() {
        APIlib.getInstance().addJSLine(this.jsBase + ".diamond();");
    }

    @Override // com.anychart.graphics.vector.PatternFill, com.anychart.graphics.vector.Layer, com.anychart.graphics.vector.Element
    public void disablePointerEvents() {
        APIlib.getInstance().addJSLine(this.jsBase + ".disablePointerEvents();");
    }

    @Override // com.anychart.graphics.vector.PatternFill, com.anychart.graphics.vector.Layer, com.anychart.graphics.vector.Element
    public HatchFill disablePointerEvents(Boolean bool) {
        APIlib.getInstance().addJSLine(String.format(Locale.US, this.jsBase + ".disablePointerEvents(%s);", bool));
        return this;
    }

    @Override // com.anychart.graphics.vector.PatternFill, com.anychart.graphics.vector.Layer, com.anychart.graphics.vector.Element
    public void disableStrokeScaling() {
        APIlib.getInstance().addJSLine(this.jsBase + ".disableStrokeScaling();");
    }

    @Override // com.anychart.graphics.vector.PatternFill, com.anychart.graphics.vector.Layer, com.anychart.graphics.vector.Element
    public HatchFill disableStrokeScaling(Boolean bool) {
        APIlib.getInstance().addJSLine(String.format(Locale.US, this.jsBase + ".disableStrokeScaling(%s);", bool));
        return this;
    }

    @Override // com.anychart.graphics.vector.PatternFill, com.anychart.graphics.vector.Layer, com.anychart.graphics.vector.Element
    public void dispose() {
        APIlib.getInstance().addJSLine(this.jsBase + ".dispose();");
    }

    @Override // com.anychart.graphics.vector.PatternFill, com.anychart.graphics.vector.Layer, com.anychart.graphics.vector.Element
    public void domElement() {
        APIlib.getInstance().addJSLine(this.jsBase + ".domElement();");
    }

    @Override // com.anychart.graphics.vector.PatternFill, com.anychart.graphics.vector.Layer
    public void donut() {
        APIlib.getInstance().addJSLine(this.jsBase + ".donut();");
    }

    @Override // com.anychart.graphics.vector.PatternFill, com.anychart.graphics.vector.Layer, com.anychart.graphics.vector.Element
    public void drag() {
        APIlib.getInstance().addJSLine(this.jsBase + ".drag();");
    }

    @Override // com.anychart.graphics.vector.PatternFill, com.anychart.graphics.vector.Layer, com.anychart.graphics.vector.Element
    public HatchFill drag(Boolean bool) {
        APIlib.getInstance().addJSLine(String.format(Locale.US, this.jsBase + ".drag(%s);", bool));
        return this;
    }

    @Override // com.anychart.graphics.vector.PatternFill, com.anychart.graphics.vector.Layer, com.anychart.graphics.vector.Element
    public HatchFill drag(com.anychart.graphics.math.Rect rect) {
        APIlib.getInstance().addJSLine(String.format(Locale.US, this.jsBase + ".drag(%s);", rect != null ? rect.getJsBase() : null));
        return this;
    }

    @Override // com.anychart.graphics.vector.PatternFill, com.anychart.graphics.vector.Layer
    public Ellipse ellipse(Number number, Number number2, Number number3, Number number4) {
        return new Ellipse(String.format(Locale.US, this.jsBase + ".ellipse(%s, %s, %s, %s)", number, number2, number3, number4));
    }

    @Override // com.anychart.graphics.vector.PatternFill, com.anychart.graphics.vector.Layer, com.anychart.graphics.vector.Element
    public com.anychart.graphics.math.Rect getAbsoluteBounds() {
        return new com.anychart.graphics.math.Rect(this.jsBase + ".getAbsoluteBounds()");
    }

    @Override // com.anychart.graphics.vector.PatternFill, com.anychart.graphics.vector.Layer, com.anychart.graphics.vector.Element
    public void getAbsoluteHeight() {
        APIlib.getInstance().addJSLine(this.jsBase + ".getAbsoluteHeight();");
    }

    @Override // com.anychart.graphics.vector.PatternFill, com.anychart.graphics.vector.Layer, com.anychart.graphics.vector.Element
    public void getAbsoluteWidth() {
        APIlib.getInstance().addJSLine(this.jsBase + ".getAbsoluteWidth();");
    }

    @Override // com.anychart.graphics.vector.PatternFill, com.anychart.graphics.vector.Layer, com.anychart.graphics.vector.Element
    public void getAbsoluteX() {
        APIlib.getInstance().addJSLine(this.jsBase + ".getAbsoluteX();");
    }

    @Override // com.anychart.graphics.vector.PatternFill, com.anychart.graphics.vector.Layer, com.anychart.graphics.vector.Element
    public void getAbsoluteY() {
        APIlib.getInstance().addJSLine(this.jsBase + ".getAbsoluteY();");
    }

    @Override // com.anychart.graphics.vector.PatternFill, com.anychart.graphics.vector.Layer, com.anychart.graphics.vector.Element
    public com.anychart.graphics.math.Rect getBounds() {
        return new com.anychart.graphics.math.Rect(this.jsBase + ".getBounds()");
    }

    @Override // com.anychart.graphics.vector.PatternFill, com.anychart.graphics.vector.Layer
    public HatchFill getChildAt(Number number) {
        APIlib.getInstance().addJSLine(String.format(Locale.US, this.jsBase + ".getChildAt(%s);", number));
        return this;
    }

    @Override // com.anychart.graphics.vector.PatternFill, com.anychart.graphics.vector.Layer, com.anychart.graphics.vector.Element
    public void getHeight() {
        APIlib.getInstance().addJSLine(this.jsBase + ".getHeight();");
    }

    @Override // com.anychart.graphics.vector.PatternFill, com.anychart.graphics.vector.Layer, com.anychart.graphics.vector.Element
    public void getRotationAngle() {
        APIlib.getInstance().addJSLine(this.jsBase + ".getRotationAngle();");
    }

    @Override // com.anychart.graphics.vector.PatternFill, com.anychart.graphics.vector.Layer, com.anychart.graphics.vector.Element
    public Stage getStage() {
        return new Stage(this.jsBase + ".getStage()");
    }

    @Override // com.anychart.graphics.vector.PatternFill, com.anychart.graphics.vector.Layer, com.anychart.graphics.vector.Element
    public void getTransformationMatrix() {
        APIlib.getInstance().addJSLine(this.jsBase + ".getTransformationMatrix();");
    }

    @Override // com.anychart.graphics.vector.PatternFill, com.anychart.graphics.vector.Layer, com.anychart.graphics.vector.Element
    public void getWidth() {
        APIlib.getInstance().addJSLine(this.jsBase + ".getWidth();");
    }

    @Override // com.anychart.graphics.vector.PatternFill, com.anychart.graphics.vector.Layer, com.anychart.graphics.vector.Element
    public void getX() {
        APIlib.getInstance().addJSLine(this.jsBase + ".getX();");
    }

    @Override // com.anychart.graphics.vector.PatternFill, com.anychart.graphics.vector.Layer, com.anychart.graphics.vector.Element
    public void getY() {
        APIlib.getInstance().addJSLine(this.jsBase + ".getY();");
    }

    @Override // com.anychart.graphics.vector.PatternFill, com.anychart.graphics.vector.Layer
    public void hLine() {
        APIlib.getInstance().addJSLine(this.jsBase + ".hLine();");
    }

    @Override // com.anychart.graphics.vector.PatternFill, com.anychart.graphics.vector.Layer
    public void hasChild(Element element) {
        APIlib.getInstance().addJSLine(String.format(Locale.US, this.jsBase + ".hasChild(%s);", element != null ? element.getJsBase() : null));
    }

    @Override // com.anychart.graphics.vector.PatternFill, com.anychart.graphics.vector.Layer, com.anychart.graphics.vector.Element
    public void hasParent() {
        APIlib.getInstance().addJSLine(this.jsBase + ".hasParent();");
    }

    @Override // com.anychart.graphics.vector.PatternFill, com.anychart.graphics.vector.Layer, com.anychart.graphics.vector.Element
    public void id() {
        APIlib.getInstance().addJSLine(this.jsBase + ".id();");
    }

    @Override // com.anychart.graphics.vector.PatternFill, com.anychart.graphics.vector.Layer, com.anychart.graphics.vector.Element
    public HatchFill id(String str) {
        APIlib.getInstance().addJSLine(String.format(Locale.US, this.jsBase + ".id(%s);", wrapQuotes(str)));
        return this;
    }

    @Override // com.anychart.graphics.vector.PatternFill, com.anychart.graphics.vector.Layer
    public Image image(String str, Number number, Number number2, Number number3, Number number4) {
        return new Image(String.format(Locale.US, this.jsBase + ".image(%s, %s, %s, %s, %s)", wrapQuotes(str), number, number2, number3, number4));
    }

    @Override // com.anychart.graphics.vector.PatternFill, com.anychart.graphics.vector.Layer
    public void indexOfChild(Element element) {
        APIlib.getInstance().addJSLine(String.format(Locale.US, this.jsBase + ".indexOfChild(%s);", element != null ? element.getJsBase() : null));
    }

    @Override // com.anychart.graphics.vector.PatternFill, com.anychart.graphics.vector.Layer
    public HatchFill layer() {
        APIlib.getInstance().addJSLine(this.jsBase + ".layer();");
        return this;
    }

    @Override // com.anychart.graphics.vector.PatternFill, com.anychart.graphics.vector.Layer
    public void numChildren() {
        APIlib.getInstance().addJSLine(this.jsBase + ".numChildren();");
    }

    @Override // com.anychart.graphics.vector.PatternFill, com.anychart.graphics.vector.Layer, com.anychart.graphics.vector.Element
    public HatchFill parent() {
        APIlib.getInstance().addJSLine(this.jsBase + ".parent();");
        return this;
    }

    @Override // com.anychart.graphics.vector.PatternFill, com.anychart.graphics.vector.Layer, com.anychart.graphics.vector.Element
    public HatchFill parent(Layer layer) {
        APIlib.getInstance().addJSLine(String.format(Locale.US, this.jsBase + ".parent(%s);", layer != null ? layer.getJsBase() : null));
        return this;
    }

    @Override // com.anychart.graphics.vector.PatternFill, com.anychart.graphics.vector.Layer, com.anychart.graphics.vector.Element
    public HatchFill parent(Stage stage) {
        APIlib.getInstance().addJSLine(String.format(Locale.US, this.jsBase + ".parent(%s);", stage != null ? stage.getJsBase() : null));
        return this;
    }

    @Override // com.anychart.graphics.vector.PatternFill, com.anychart.graphics.vector.Layer
    public Path path() {
        return new Path(this.jsBase + ".path()");
    }

    @Override // com.anychart.graphics.vector.PatternFill, com.anychart.graphics.vector.Layer
    public void pie() {
        APIlib.getInstance().addJSLine(this.jsBase + ".pie();");
    }

    @Override // com.anychart.graphics.vector.PatternFill, com.anychart.graphics.vector.Layer
    public Rect rect(Number number, Number number2, Number number3, Number number4) {
        return new Rect(String.format(Locale.US, this.jsBase + ".rect(%s, %s, %s, %s)", number, number2, number3, number4));
    }

    @Override // com.anychart.graphics.vector.PatternFill, com.anychart.graphics.vector.Layer, com.anychart.graphics.vector.Element
    public HatchFill remove() {
        APIlib.getInstance().addJSLine(this.jsBase + ".remove();");
        return this;
    }

    @Override // com.anychart.graphics.vector.PatternFill, com.anychart.graphics.vector.Layer, com.anychart.graphics.vector.Element
    public void removeAllListeners(String str) {
        APIlib.getInstance().addJSLine(String.format(Locale.US, this.jsBase + ".removeAllListeners(%s);", wrapQuotes(str)));
    }

    @Override // com.anychart.graphics.vector.PatternFill, com.anychart.graphics.vector.Layer
    public HatchFill removeChild(Element element) {
        APIlib.getInstance().addJSLine(String.format(Locale.US, this.jsBase + ".removeChild(%s);", element != null ? element.getJsBase() : null));
        return this;
    }

    @Override // com.anychart.graphics.vector.PatternFill, com.anychart.graphics.vector.Layer
    public HatchFill removeChildAt(Number number) {
        APIlib.getInstance().addJSLine(String.format(Locale.US, this.jsBase + ".removeChildAt(%s);", number));
        return this;
    }

    @Override // com.anychart.graphics.vector.PatternFill, com.anychart.graphics.vector.Layer
    public void removeChildren() {
        APIlib.getInstance().addJSLine(this.jsBase + ".removeChildren();");
    }

    @Override // com.anychart.graphics.vector.PatternFill, com.anychart.graphics.vector.Layer, com.anychart.graphics.vector.Element
    public HatchFill rotate(Number number, Number number2, Number number3) {
        APIlib.getInstance().addJSLine(String.format(Locale.US, this.jsBase + ".rotate(%s, %s, %s);", number, number2, number3));
        return this;
    }

    @Override // com.anychart.graphics.vector.PatternFill, com.anychart.graphics.vector.Layer, com.anychart.graphics.vector.Element
    public HatchFill rotateByAnchor(Number number, Anchor anchor) {
        APIlib.getInstance().addJSLine(String.format(Locale.US, this.jsBase + ".rotateByAnchor(%s, %s);", number, anchor != null ? anchor.getJsBase() : null));
        return this;
    }

    @Override // com.anychart.graphics.vector.PatternFill, com.anychart.graphics.vector.Layer, com.anychart.graphics.vector.Element
    public HatchFill rotateByAnchor(Number number, String str) {
        APIlib.getInstance().addJSLine(String.format(Locale.US, this.jsBase + ".rotateByAnchor(%s, %s);", number, wrapQuotes(str)));
        return this;
    }

    @Override // com.anychart.graphics.vector.PatternFill, com.anychart.graphics.vector.Layer
    public void roundedInnerRect() {
        APIlib.getInstance().addJSLine(this.jsBase + ".roundedInnerRect();");
    }

    @Override // com.anychart.graphics.vector.PatternFill, com.anychart.graphics.vector.Layer
    public void roundedRect() {
        APIlib.getInstance().addJSLine(this.jsBase + ".roundedRect();");
    }

    @Override // com.anychart.graphics.vector.PatternFill, com.anychart.graphics.vector.Layer, com.anychart.graphics.vector.Element
    public HatchFill scale(Number number, Number number2, Number number3, Number number4) {
        APIlib.getInstance().addJSLine(String.format(Locale.US, this.jsBase + ".scale(%s, %s, %s, %s);", number, number2, number3, number4));
        return this;
    }

    @Override // com.anychart.graphics.vector.PatternFill, com.anychart.graphics.vector.Layer, com.anychart.graphics.vector.Element
    public HatchFill scaleByAnchor(Number number, Number number2, Anchor anchor) {
        APIlib.getInstance().addJSLine(String.format(Locale.US, this.jsBase + ".scaleByAnchor(%s, %s, %s);", number, number2, anchor != null ? anchor.getJsBase() : null));
        return this;
    }

    @Override // com.anychart.graphics.vector.PatternFill, com.anychart.graphics.vector.Layer, com.anychart.graphics.vector.Element
    public HatchFill scaleByAnchor(Number number, Number number2, String str) {
        APIlib.getInstance().addJSLine(String.format(Locale.US, this.jsBase + ".scaleByAnchor(%s, %s, %s);", number, number2, wrapQuotes(str)));
        return this;
    }

    @Override // com.anychart.graphics.vector.PatternFill, com.anychart.graphics.vector.Layer, com.anychart.graphics.vector.Element
    public HatchFill setPosition(Number number, Number number2) {
        APIlib.getInstance().addJSLine(String.format(Locale.US, this.jsBase + ".setPosition(%s, %s);", number, number2));
        return this;
    }

    @Override // com.anychart.graphics.vector.PatternFill, com.anychart.graphics.vector.Layer, com.anychart.graphics.vector.Element
    public HatchFill setRotation(Number number, Number number2, Number number3) {
        APIlib.getInstance().addJSLine(String.format(Locale.US, this.jsBase + ".setRotation(%s, %s, %s);", number, number2, number3));
        return this;
    }

    @Override // com.anychart.graphics.vector.PatternFill, com.anychart.graphics.vector.Layer, com.anychart.graphics.vector.Element
    public HatchFill setRotationByAnchor(Number number, Anchor anchor) {
        APIlib.getInstance().addJSLine(String.format(Locale.US, this.jsBase + ".setRotationByAnchor(%s, %s);", number, anchor != null ? anchor.getJsBase() : null));
        return this;
    }

    @Override // com.anychart.graphics.vector.PatternFill, com.anychart.graphics.vector.Layer, com.anychart.graphics.vector.Element
    public HatchFill setRotationByAnchor(Number number, String str) {
        APIlib.getInstance().addJSLine(String.format(Locale.US, this.jsBase + ".setRotationByAnchor(%s, %s);", number, wrapQuotes(str)));
        return this;
    }

    @Override // com.anychart.graphics.vector.PatternFill, com.anychart.graphics.vector.Layer, com.anychart.graphics.vector.Element
    public HatchFill setTransformationMatrix(Number number, Number number2, Number number3, Number number4, Number number5, Number number6) {
        APIlib.getInstance().addJSLine(String.format(Locale.US, this.jsBase + ".setTransformationMatrix(%s, %s, %s, %s, %s, %s);", number, number2, number3, number4, number5, number6));
        return this;
    }

    @Override // com.anychart.graphics.vector.PatternFill, com.anychart.graphics.vector.Layer
    public void star() {
        APIlib.getInstance().addJSLine(this.jsBase + ".star();");
    }

    @Override // com.anychart.graphics.vector.PatternFill, com.anychart.graphics.vector.Layer
    public void star10() {
        APIlib.getInstance().addJSLine(this.jsBase + ".star10();");
    }

    @Override // com.anychart.graphics.vector.PatternFill, com.anychart.graphics.vector.Layer
    public void star4() {
        APIlib.getInstance().addJSLine(this.jsBase + ".star4();");
    }

    @Override // com.anychart.graphics.vector.PatternFill, com.anychart.graphics.vector.Layer
    public void star5() {
        APIlib.getInstance().addJSLine(this.jsBase + ".star5();");
    }

    @Override // com.anychart.graphics.vector.PatternFill, com.anychart.graphics.vector.Layer
    public void star6() {
        APIlib.getInstance().addJSLine(this.jsBase + ".star6();");
    }

    @Override // com.anychart.graphics.vector.PatternFill, com.anychart.graphics.vector.Layer
    public void star7() {
        APIlib.getInstance().addJSLine(this.jsBase + ".star7();");
    }

    @Override // com.anychart.graphics.vector.PatternFill, com.anychart.graphics.vector.Layer
    public HatchFill swapChildren(Element element, Element element2) {
        APIlib.getInstance().addJSLine(String.format(Locale.US, this.jsBase + ".swapChildren(%s, %s);", element != null ? element.getJsBase() : null, element2 != null ? element2.getJsBase() : null));
        return this;
    }

    @Override // com.anychart.graphics.vector.PatternFill, com.anychart.graphics.vector.Layer
    public HatchFill swapChildrenAt(Number number, Number number2) {
        APIlib.getInstance().addJSLine(String.format(Locale.US, this.jsBase + ".swapChildrenAt(%s, %s);", number, number2));
        return this;
    }

    @Override // com.anychart.graphics.vector.PatternFill, com.anychart.graphics.vector.Layer, com.anychart.graphics.vector.Element
    public void title() {
        APIlib.getInstance().addJSLine(this.jsBase + ".title();");
    }

    @Override // com.anychart.graphics.vector.PatternFill, com.anychart.graphics.vector.Layer, com.anychart.graphics.vector.Element
    public HatchFill title(String str) {
        APIlib.getInstance().addJSLine(String.format(Locale.US, this.jsBase + ".title(%s);", wrapQuotes(str)));
        return this;
    }

    @Override // com.anychart.graphics.vector.PatternFill, com.anychart.graphics.vector.Layer, com.anychart.graphics.vector.Element
    public HatchFill translate(Number number, Number number2) {
        APIlib.getInstance().addJSLine(String.format(Locale.US, this.jsBase + ".translate(%s, %s);", number, number2));
        return this;
    }

    @Override // com.anychart.graphics.vector.PatternFill, com.anychart.graphics.vector.Layer
    public void triangleDown() {
        APIlib.getInstance().addJSLine(this.jsBase + ".triangleDown();");
    }

    @Override // com.anychart.graphics.vector.PatternFill, com.anychart.graphics.vector.Layer
    public void triangleLeft() {
        APIlib.getInstance().addJSLine(this.jsBase + ".triangleLeft();");
    }

    @Override // com.anychart.graphics.vector.PatternFill, com.anychart.graphics.vector.Layer
    public void triangleRight() {
        APIlib.getInstance().addJSLine(this.jsBase + ".triangleRight();");
    }

    @Override // com.anychart.graphics.vector.PatternFill, com.anychart.graphics.vector.Layer
    public void triangleUp() {
        APIlib.getInstance().addJSLine(this.jsBase + ".triangleUp();");
    }

    @Override // com.anychart.graphics.vector.PatternFill, com.anychart.graphics.vector.Layer
    public void truncatedRect() {
        APIlib.getInstance().addJSLine(this.jsBase + ".truncatedRect();");
    }

    @Override // com.anychart.graphics.vector.PatternFill, com.anychart.graphics.vector.Layer, com.anychart.graphics.vector.Element
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

    @Override // com.anychart.graphics.vector.PatternFill, com.anychart.graphics.vector.Layer, com.anychart.graphics.vector.Element
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

    @Override // com.anychart.graphics.vector.PatternFill, com.anychart.graphics.vector.Layer
    public void vLine() {
        APIlib.getInstance().addJSLine(this.jsBase + ".vLine();");
    }

    @Override // com.anychart.graphics.vector.PatternFill, com.anychart.graphics.vector.Layer, com.anychart.graphics.vector.Element
    public void visible() {
        APIlib.getInstance().addJSLine(this.jsBase + ".visible();");
    }

    @Override // com.anychart.graphics.vector.PatternFill, com.anychart.graphics.vector.Layer, com.anychart.graphics.vector.Element
    public HatchFill visible(Boolean bool) {
        APIlib.getInstance().addJSLine(String.format(Locale.US, this.jsBase + ".visible(%s);", bool));
        return this;
    }

    @Override // com.anychart.graphics.vector.PatternFill, com.anychart.graphics.vector.Layer, com.anychart.graphics.vector.Element
    public void zIndex() {
        APIlib.getInstance().addJSLine(this.jsBase + ".zIndex();");
    }

    @Override // com.anychart.graphics.vector.PatternFill, com.anychart.graphics.vector.Layer, com.anychart.graphics.vector.Element
    public HatchFill zIndex(Number number) {
        APIlib.getInstance().addJSLine(String.format(Locale.US, this.jsBase + ".zIndex(%s);", number));
        return this;
    }

    @Override // com.anychart.graphics.vector.PatternFill, com.anychart.graphics.vector.Layer, com.anychart.graphics.vector.Element
    public void unlistenByKey(String str) {
        APIlib.getInstance().addJSLine(String.format(Locale.US, this.jsBase + ".unlistenByKey(%s);", wrapQuotes(str)));
    }
}
