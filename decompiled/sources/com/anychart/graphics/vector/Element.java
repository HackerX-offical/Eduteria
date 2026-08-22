package com.anychart.graphics.vector;

import com.amazonaws.services.s3.model.InstructionFileId;
import com.anychart.APIlib;
import com.anychart.JsObject;
import com.anychart.chart.common.listener.ListenersInterface;
import java.util.Locale;

/* JADX INFO: loaded from: classes4.dex */
public class Element extends JsObject {
    protected Element() {
    }

    public static Element instantiate() {
        return new Element("new anychart.graphics.vector.element()");
    }

    public Element(String str) {
        StringBuilder sb = new StringBuilder("element");
        int i = variableIndex + 1;
        variableIndex = i;
        this.jsBase = sb.append(i).toString();
        APIlib.getInstance().addJSLine(this.jsBase + " = " + str + ";");
    }

    @Override // com.anychart.JsObject
    public String getJsBase() {
        return this.jsBase;
    }

    public Element appendTransformationMatrix(Number number, Number number2, Number number3, Number number4, Number number5, Number number6) {
        APIlib.getInstance().addJSLine(String.format(Locale.US, this.jsBase + ".appendTransformationMatrix(%s, %s, %s, %s, %s, %s);", number, number2, number3, number4, number5, number6));
        return this;
    }

    public void attr(String str) {
        APIlib.getInstance().addJSLine(String.format(Locale.US, this.jsBase + ".attr(%s);", wrapQuotes(str)));
    }

    public Element attr(String str, String str2) {
        APIlib.getInstance().addJSLine(String.format(Locale.US, this.jsBase + ".attr(%s, %s);", wrapQuotes(str), wrapQuotes(str2)));
        return this;
    }

    public com.anychart.graphics.math.Rect clip() {
        return new com.anychart.graphics.math.Rect(this.jsBase + ".clip()");
    }

    public Element clip(com.anychart.graphics.math.Rect rect) {
        APIlib.getInstance().addJSLine(String.format(Locale.US, this.jsBase + ".clip(%s);", rect != null ? rect.getJsBase() : null));
        return this;
    }

    public Element clip(String str) {
        APIlib.getInstance().addJSLine(String.format(Locale.US, this.jsBase + ".clip(%s);", wrapQuotes(str)));
        return this;
    }

    public void cursor() {
        APIlib.getInstance().addJSLine(this.jsBase + ".cursor();");
    }

    public Element cursor(Cursor cursor) {
        APIlib.getInstance().addJSLine(String.format(Locale.US, this.jsBase + ".cursor(%s);", cursor != null ? cursor.getJsBase() : null));
        return this;
    }

    public void desc() {
        APIlib.getInstance().addJSLine(this.jsBase + ".desc();");
    }

    public Element desc(String str) {
        APIlib.getInstance().addJSLine(String.format(Locale.US, this.jsBase + ".desc(%s);", wrapQuotes(str)));
        return this;
    }

    public void disablePointerEvents() {
        APIlib.getInstance().addJSLine(this.jsBase + ".disablePointerEvents();");
    }

    public Element disablePointerEvents(Boolean bool) {
        APIlib.getInstance().addJSLine(String.format(Locale.US, this.jsBase + ".disablePointerEvents(%s);", bool));
        return this;
    }

    public void disableStrokeScaling() {
        APIlib.getInstance().addJSLine(this.jsBase + ".disableStrokeScaling();");
    }

    public Element disableStrokeScaling(Boolean bool) {
        APIlib.getInstance().addJSLine(String.format(Locale.US, this.jsBase + ".disableStrokeScaling(%s);", bool));
        return this;
    }

    public void dispose() {
        APIlib.getInstance().addJSLine(this.jsBase + ".dispose();");
    }

    public void domElement() {
        APIlib.getInstance().addJSLine(this.jsBase + ".domElement();");
    }

    public void drag() {
        APIlib.getInstance().addJSLine(this.jsBase + ".drag();");
    }

    public Element drag(Boolean bool) {
        APIlib.getInstance().addJSLine(String.format(Locale.US, this.jsBase + ".drag(%s);", bool));
        return this;
    }

    public Element drag(com.anychart.graphics.math.Rect rect) {
        APIlib.getInstance().addJSLine(String.format(Locale.US, this.jsBase + ".drag(%s);", rect != null ? rect.getJsBase() : null));
        return this;
    }

    public com.anychart.graphics.math.Rect getAbsoluteBounds() {
        return new com.anychart.graphics.math.Rect(this.jsBase + ".getAbsoluteBounds()");
    }

    public void getAbsoluteHeight() {
        APIlib.getInstance().addJSLine(this.jsBase + ".getAbsoluteHeight();");
    }

    public void getAbsoluteWidth() {
        APIlib.getInstance().addJSLine(this.jsBase + ".getAbsoluteWidth();");
    }

    public void getAbsoluteX() {
        APIlib.getInstance().addJSLine(this.jsBase + ".getAbsoluteX();");
    }

    public void getAbsoluteY() {
        APIlib.getInstance().addJSLine(this.jsBase + ".getAbsoluteY();");
    }

    public com.anychart.graphics.math.Rect getBounds() {
        return new com.anychart.graphics.math.Rect(this.jsBase + ".getBounds()");
    }

    public void getHeight() {
        APIlib.getInstance().addJSLine(this.jsBase + ".getHeight();");
    }

    public void getRotationAngle() {
        APIlib.getInstance().addJSLine(this.jsBase + ".getRotationAngle();");
    }

    public Stage getStage() {
        return new Stage(this.jsBase + ".getStage()");
    }

    public void getTransformationMatrix() {
        APIlib.getInstance().addJSLine(this.jsBase + ".getTransformationMatrix();");
    }

    public void getWidth() {
        APIlib.getInstance().addJSLine(this.jsBase + ".getWidth();");
    }

    public void getX() {
        APIlib.getInstance().addJSLine(this.jsBase + ".getX();");
    }

    public void getY() {
        APIlib.getInstance().addJSLine(this.jsBase + ".getY();");
    }

    public void hasParent() {
        APIlib.getInstance().addJSLine(this.jsBase + ".hasParent();");
    }

    public void id() {
        APIlib.getInstance().addJSLine(this.jsBase + ".id();");
    }

    public Element id(String str) {
        APIlib.getInstance().addJSLine(String.format(Locale.US, this.jsBase + ".id(%s);", wrapQuotes(str)));
        return this;
    }

    public Layer parent() {
        return new Layer(this.jsBase + ".parent()");
    }

    public Element parent(Layer layer) {
        APIlib.getInstance().addJSLine(String.format(Locale.US, this.jsBase + ".parent(%s);", layer != null ? layer.getJsBase() : null));
        return this;
    }

    public Element parent(Stage stage) {
        APIlib.getInstance().addJSLine(String.format(Locale.US, this.jsBase + ".parent(%s);", stage != null ? stage.getJsBase() : null));
        return this;
    }

    public Element remove() {
        APIlib.getInstance().addJSLine(this.jsBase + ".remove();");
        return this;
    }

    public void removeAllListeners(String str) {
        APIlib.getInstance().addJSLine(String.format(Locale.US, this.jsBase + ".removeAllListeners(%s);", wrapQuotes(str)));
    }

    public Element rotate(Number number, Number number2, Number number3) {
        APIlib.getInstance().addJSLine(String.format(Locale.US, this.jsBase + ".rotate(%s, %s, %s);", number, number2, number3));
        return this;
    }

    public Element rotateByAnchor(Number number, Anchor anchor) {
        APIlib.getInstance().addJSLine(String.format(Locale.US, this.jsBase + ".rotateByAnchor(%s, %s);", number, anchor != null ? anchor.getJsBase() : null));
        return this;
    }

    public Element rotateByAnchor(Number number, String str) {
        APIlib.getInstance().addJSLine(String.format(Locale.US, this.jsBase + ".rotateByAnchor(%s, %s);", number, wrapQuotes(str)));
        return this;
    }

    public Element scale(Number number, Number number2, Number number3, Number number4) {
        APIlib.getInstance().addJSLine(String.format(Locale.US, this.jsBase + ".scale(%s, %s, %s, %s);", number, number2, number3, number4));
        return this;
    }

    public Element scaleByAnchor(Number number, Number number2, Anchor anchor) {
        APIlib.getInstance().addJSLine(String.format(Locale.US, this.jsBase + ".scaleByAnchor(%s, %s, %s);", number, number2, anchor != null ? anchor.getJsBase() : null));
        return this;
    }

    public Element scaleByAnchor(Number number, Number number2, String str) {
        APIlib.getInstance().addJSLine(String.format(Locale.US, this.jsBase + ".scaleByAnchor(%s, %s, %s);", number, number2, wrapQuotes(str)));
        return this;
    }

    public Element setPosition(Number number, Number number2) {
        APIlib.getInstance().addJSLine(String.format(Locale.US, this.jsBase + ".setPosition(%s, %s);", number, number2));
        return this;
    }

    public Element setRotation(Number number, Number number2, Number number3) {
        APIlib.getInstance().addJSLine(String.format(Locale.US, this.jsBase + ".setRotation(%s, %s, %s);", number, number2, number3));
        return this;
    }

    public Element setRotationByAnchor(Number number, Anchor anchor) {
        APIlib.getInstance().addJSLine(String.format(Locale.US, this.jsBase + ".setRotationByAnchor(%s, %s);", number, anchor != null ? anchor.getJsBase() : null));
        return this;
    }

    public Element setRotationByAnchor(Number number, String str) {
        APIlib.getInstance().addJSLine(String.format(Locale.US, this.jsBase + ".setRotationByAnchor(%s, %s);", number, wrapQuotes(str)));
        return this;
    }

    public Element setTransformationMatrix(Number number, Number number2, Number number3, Number number4, Number number5, Number number6) {
        APIlib.getInstance().addJSLine(String.format(Locale.US, this.jsBase + ".setTransformationMatrix(%s, %s, %s, %s, %s, %s);", number, number2, number3, number4, number5, number6));
        return this;
    }

    public void title() {
        APIlib.getInstance().addJSLine(this.jsBase + ".title();");
    }

    public Element title(String str) {
        APIlib.getInstance().addJSLine(String.format(Locale.US, this.jsBase + ".title(%s);", wrapQuotes(str)));
        return this;
    }

    public Element translate(Number number, Number number2) {
        APIlib.getInstance().addJSLine(String.format(Locale.US, this.jsBase + ".translate(%s, %s);", number, number2));
        return this;
    }

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

    public void unlistenByKey(String str) {
        APIlib.getInstance().addJSLine(String.format(Locale.US, this.jsBase + ".unlistenByKey(%s);", wrapQuotes(str)));
    }

    public void visible() {
        APIlib.getInstance().addJSLine(this.jsBase + ".visible();");
    }

    public Element visible(Boolean bool) {
        APIlib.getInstance().addJSLine(String.format(Locale.US, this.jsBase + ".visible(%s);", bool));
        return this;
    }

    public void zIndex() {
        APIlib.getInstance().addJSLine(this.jsBase + ".zIndex();");
    }

    public Element zIndex(Number number) {
        APIlib.getInstance().addJSLine(String.format(Locale.US, this.jsBase + ".zIndex(%s);", number));
        return this;
    }
}
