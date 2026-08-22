package com.anychart.graphics.vector;

import com.amazonaws.services.s3.model.InstructionFileId;
import com.anychart.APIlib;
import com.anychart.chart.common.listener.ListenersInterface;
import java.util.Locale;

/* JADX INFO: loaded from: classes4.dex */
public class UnmanagedLayer extends Element {
    protected UnmanagedLayer() {
    }

    public static UnmanagedLayer instantiate() {
        return new UnmanagedLayer("new anychart.graphics.vector.unmanagedLayer()");
    }

    public UnmanagedLayer(String str) {
        StringBuilder sb = new StringBuilder("unmanagedLayer");
        int i = variableIndex + 1;
        variableIndex = i;
        this.jsBase = sb.append(i).toString();
        APIlib.getInstance().addJSLine(this.jsBase + " = " + str + ";");
    }

    @Override // com.anychart.graphics.vector.Element, com.anychart.JsObject
    public String getJsBase() {
        return this.jsBase;
    }

    @Override // com.anychart.graphics.vector.Element
    public UnmanagedLayer appendTransformationMatrix(Number number, Number number2, Number number3, Number number4, Number number5, Number number6) {
        APIlib.getInstance().addJSLine(String.format(Locale.US, this.jsBase + ".appendTransformationMatrix(%s, %s, %s, %s, %s, %s);", number, number2, number3, number4, number5, number6));
        return this;
    }

    @Override // com.anychart.graphics.vector.Element
    public void attr(String str) {
        APIlib.getInstance().addJSLine(String.format(Locale.US, this.jsBase + ".attr(%s);", wrapQuotes(str)));
    }

    @Override // com.anychart.graphics.vector.Element
    public UnmanagedLayer attr(String str, String str2) {
        APIlib.getInstance().addJSLine(String.format(Locale.US, this.jsBase + ".attr(%s, %s);", wrapQuotes(str), wrapQuotes(str2)));
        return this;
    }

    @Override // com.anychart.graphics.vector.Element
    public com.anychart.graphics.math.Rect clip() {
        return new com.anychart.graphics.math.Rect(this.jsBase + ".clip()");
    }

    @Override // com.anychart.graphics.vector.Element
    public UnmanagedLayer clip(com.anychart.graphics.math.Rect rect) {
        APIlib.getInstance().addJSLine(String.format(Locale.US, this.jsBase + ".clip(%s);", rect != null ? rect.getJsBase() : null));
        return this;
    }

    @Override // com.anychart.graphics.vector.Element
    public UnmanagedLayer clip(String str) {
        APIlib.getInstance().addJSLine(String.format(Locale.US, this.jsBase + ".clip(%s);", wrapQuotes(str)));
        return this;
    }

    public void content() {
        APIlib.getInstance().addJSLine(this.jsBase + ".content();");
    }

    public UnmanagedLayer content(String str) {
        APIlib.getInstance().addJSLine(String.format(Locale.US, this.jsBase + ".content(%s);", wrapQuotes(str)));
        return this;
    }

    @Override // com.anychart.graphics.vector.Element
    public void cursor() {
        APIlib.getInstance().addJSLine(this.jsBase + ".cursor();");
    }

    @Override // com.anychart.graphics.vector.Element
    public UnmanagedLayer cursor(Cursor cursor) {
        APIlib.getInstance().addJSLine(String.format(Locale.US, this.jsBase + ".cursor(%s);", cursor != null ? cursor.getJsBase() : null));
        return this;
    }

    @Override // com.anychart.graphics.vector.Element
    public void desc() {
        APIlib.getInstance().addJSLine(this.jsBase + ".desc();");
    }

    @Override // com.anychart.graphics.vector.Element
    public UnmanagedLayer desc(String str) {
        APIlib.getInstance().addJSLine(String.format(Locale.US, this.jsBase + ".desc(%s);", wrapQuotes(str)));
        return this;
    }

    @Override // com.anychart.graphics.vector.Element
    public void disablePointerEvents() {
        APIlib.getInstance().addJSLine(this.jsBase + ".disablePointerEvents();");
    }

    @Override // com.anychart.graphics.vector.Element
    public UnmanagedLayer disablePointerEvents(Boolean bool) {
        APIlib.getInstance().addJSLine(String.format(Locale.US, this.jsBase + ".disablePointerEvents(%s);", bool));
        return this;
    }

    @Override // com.anychart.graphics.vector.Element
    public void disableStrokeScaling() {
        APIlib.getInstance().addJSLine(this.jsBase + ".disableStrokeScaling();");
    }

    @Override // com.anychart.graphics.vector.Element
    public UnmanagedLayer disableStrokeScaling(Boolean bool) {
        APIlib.getInstance().addJSLine(String.format(Locale.US, this.jsBase + ".disableStrokeScaling(%s);", bool));
        return this;
    }

    @Override // com.anychart.graphics.vector.Element
    public void dispose() {
        APIlib.getInstance().addJSLine(this.jsBase + ".dispose();");
    }

    @Override // com.anychart.graphics.vector.Element
    public void domElement() {
        APIlib.getInstance().addJSLine(this.jsBase + ".domElement();");
    }

    @Override // com.anychart.graphics.vector.Element
    public void drag() {
        APIlib.getInstance().addJSLine(this.jsBase + ".drag();");
    }

    @Override // com.anychart.graphics.vector.Element
    public UnmanagedLayer drag(Boolean bool) {
        APIlib.getInstance().addJSLine(String.format(Locale.US, this.jsBase + ".drag(%s);", bool));
        return this;
    }

    @Override // com.anychart.graphics.vector.Element
    public UnmanagedLayer drag(com.anychart.graphics.math.Rect rect) {
        APIlib.getInstance().addJSLine(String.format(Locale.US, this.jsBase + ".drag(%s);", rect != null ? rect.getJsBase() : null));
        return this;
    }

    @Override // com.anychart.graphics.vector.Element
    public com.anychart.graphics.math.Rect getAbsoluteBounds() {
        return new com.anychart.graphics.math.Rect(this.jsBase + ".getAbsoluteBounds()");
    }

    @Override // com.anychart.graphics.vector.Element
    public void getAbsoluteHeight() {
        APIlib.getInstance().addJSLine(this.jsBase + ".getAbsoluteHeight();");
    }

    @Override // com.anychart.graphics.vector.Element
    public void getAbsoluteWidth() {
        APIlib.getInstance().addJSLine(this.jsBase + ".getAbsoluteWidth();");
    }

    @Override // com.anychart.graphics.vector.Element
    public void getAbsoluteX() {
        APIlib.getInstance().addJSLine(this.jsBase + ".getAbsoluteX();");
    }

    @Override // com.anychart.graphics.vector.Element
    public void getAbsoluteY() {
        APIlib.getInstance().addJSLine(this.jsBase + ".getAbsoluteY();");
    }

    @Override // com.anychart.graphics.vector.Element
    public com.anychart.graphics.math.Rect getBounds() {
        return new com.anychart.graphics.math.Rect(this.jsBase + ".getBounds()");
    }

    @Override // com.anychart.graphics.vector.Element
    public void getHeight() {
        APIlib.getInstance().addJSLine(this.jsBase + ".getHeight();");
    }

    @Override // com.anychart.graphics.vector.Element
    public void getRotationAngle() {
        APIlib.getInstance().addJSLine(this.jsBase + ".getRotationAngle();");
    }

    @Override // com.anychart.graphics.vector.Element
    public Stage getStage() {
        return new Stage(this.jsBase + ".getStage()");
    }

    @Override // com.anychart.graphics.vector.Element
    public void getTransformationMatrix() {
        APIlib.getInstance().addJSLine(this.jsBase + ".getTransformationMatrix();");
    }

    @Override // com.anychart.graphics.vector.Element
    public void getWidth() {
        APIlib.getInstance().addJSLine(this.jsBase + ".getWidth();");
    }

    @Override // com.anychart.graphics.vector.Element
    public void getX() {
        APIlib.getInstance().addJSLine(this.jsBase + ".getX();");
    }

    @Override // com.anychart.graphics.vector.Element
    public void getY() {
        APIlib.getInstance().addJSLine(this.jsBase + ".getY();");
    }

    @Override // com.anychart.graphics.vector.Element
    public void hasParent() {
        APIlib.getInstance().addJSLine(this.jsBase + ".hasParent();");
    }

    @Override // com.anychart.graphics.vector.Element
    public void id() {
        APIlib.getInstance().addJSLine(this.jsBase + ".id();");
    }

    @Override // com.anychart.graphics.vector.Element
    public UnmanagedLayer id(String str) {
        APIlib.getInstance().addJSLine(String.format(Locale.US, this.jsBase + ".id(%s);", wrapQuotes(str)));
        return this;
    }

    @Override // com.anychart.graphics.vector.Element
    public Layer parent() {
        return new Layer(this.jsBase + ".parent()");
    }

    @Override // com.anychart.graphics.vector.Element
    public UnmanagedLayer parent(Layer layer) {
        APIlib.getInstance().addJSLine(String.format(Locale.US, this.jsBase + ".parent(%s);", layer != null ? layer.getJsBase() : null));
        return this;
    }

    @Override // com.anychart.graphics.vector.Element
    public UnmanagedLayer parent(Stage stage) {
        APIlib.getInstance().addJSLine(String.format(Locale.US, this.jsBase + ".parent(%s);", stage != null ? stage.getJsBase() : null));
        return this;
    }

    @Override // com.anychart.graphics.vector.Element
    public UnmanagedLayer remove() {
        APIlib.getInstance().addJSLine(this.jsBase + ".remove();");
        return this;
    }

    @Override // com.anychart.graphics.vector.Element
    public void removeAllListeners(String str) {
        APIlib.getInstance().addJSLine(String.format(Locale.US, this.jsBase + ".removeAllListeners(%s);", wrapQuotes(str)));
    }

    @Override // com.anychart.graphics.vector.Element
    public UnmanagedLayer rotate(Number number, Number number2, Number number3) {
        APIlib.getInstance().addJSLine(String.format(Locale.US, this.jsBase + ".rotate(%s, %s, %s);", number, number2, number3));
        return this;
    }

    @Override // com.anychart.graphics.vector.Element
    public UnmanagedLayer rotateByAnchor(Number number, Anchor anchor) {
        APIlib.getInstance().addJSLine(String.format(Locale.US, this.jsBase + ".rotateByAnchor(%s, %s);", number, anchor != null ? anchor.getJsBase() : null));
        return this;
    }

    @Override // com.anychart.graphics.vector.Element
    public UnmanagedLayer rotateByAnchor(Number number, String str) {
        APIlib.getInstance().addJSLine(String.format(Locale.US, this.jsBase + ".rotateByAnchor(%s, %s);", number, wrapQuotes(str)));
        return this;
    }

    @Override // com.anychart.graphics.vector.Element
    public UnmanagedLayer scale(Number number, Number number2, Number number3, Number number4) {
        APIlib.getInstance().addJSLine(String.format(Locale.US, this.jsBase + ".scale(%s, %s, %s, %s);", number, number2, number3, number4));
        return this;
    }

    @Override // com.anychart.graphics.vector.Element
    public UnmanagedLayer scaleByAnchor(Number number, Number number2, Anchor anchor) {
        APIlib.getInstance().addJSLine(String.format(Locale.US, this.jsBase + ".scaleByAnchor(%s, %s, %s);", number, number2, anchor != null ? anchor.getJsBase() : null));
        return this;
    }

    @Override // com.anychart.graphics.vector.Element
    public UnmanagedLayer scaleByAnchor(Number number, Number number2, String str) {
        APIlib.getInstance().addJSLine(String.format(Locale.US, this.jsBase + ".scaleByAnchor(%s, %s, %s);", number, number2, wrapQuotes(str)));
        return this;
    }

    @Override // com.anychart.graphics.vector.Element
    public UnmanagedLayer setPosition(Number number, Number number2) {
        APIlib.getInstance().addJSLine(String.format(Locale.US, this.jsBase + ".setPosition(%s, %s);", number, number2));
        return this;
    }

    @Override // com.anychart.graphics.vector.Element
    public UnmanagedLayer setRotation(Number number, Number number2, Number number3) {
        APIlib.getInstance().addJSLine(String.format(Locale.US, this.jsBase + ".setRotation(%s, %s, %s);", number, number2, number3));
        return this;
    }

    @Override // com.anychart.graphics.vector.Element
    public UnmanagedLayer setRotationByAnchor(Number number, Anchor anchor) {
        APIlib.getInstance().addJSLine(String.format(Locale.US, this.jsBase + ".setRotationByAnchor(%s, %s);", number, anchor != null ? anchor.getJsBase() : null));
        return this;
    }

    @Override // com.anychart.graphics.vector.Element
    public UnmanagedLayer setRotationByAnchor(Number number, String str) {
        APIlib.getInstance().addJSLine(String.format(Locale.US, this.jsBase + ".setRotationByAnchor(%s, %s);", number, wrapQuotes(str)));
        return this;
    }

    @Override // com.anychart.graphics.vector.Element
    public UnmanagedLayer setTransformationMatrix(Number number, Number number2, Number number3, Number number4, Number number5, Number number6) {
        APIlib.getInstance().addJSLine(String.format(Locale.US, this.jsBase + ".setTransformationMatrix(%s, %s, %s, %s, %s, %s);", number, number2, number3, number4, number5, number6));
        return this;
    }

    @Override // com.anychart.graphics.vector.Element
    public void title() {
        APIlib.getInstance().addJSLine(this.jsBase + ".title();");
    }

    @Override // com.anychart.graphics.vector.Element
    public UnmanagedLayer title(String str) {
        APIlib.getInstance().addJSLine(String.format(Locale.US, this.jsBase + ".title(%s);", wrapQuotes(str)));
        return this;
    }

    @Override // com.anychart.graphics.vector.Element
    public UnmanagedLayer translate(Number number, Number number2) {
        APIlib.getInstance().addJSLine(String.format(Locale.US, this.jsBase + ".translate(%s, %s);", number, number2));
        return this;
    }

    @Override // com.anychart.graphics.vector.Element
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

    @Override // com.anychart.graphics.vector.Element
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

    @Override // com.anychart.graphics.vector.Element
    public void visible() {
        APIlib.getInstance().addJSLine(this.jsBase + ".visible();");
    }

    @Override // com.anychart.graphics.vector.Element
    public UnmanagedLayer visible(Boolean bool) {
        APIlib.getInstance().addJSLine(String.format(Locale.US, this.jsBase + ".visible(%s);", bool));
        return this;
    }

    @Override // com.anychart.graphics.vector.Element
    public void zIndex() {
        APIlib.getInstance().addJSLine(this.jsBase + ".zIndex();");
    }

    @Override // com.anychart.graphics.vector.Element
    public UnmanagedLayer zIndex(Number number) {
        APIlib.getInstance().addJSLine(String.format(Locale.US, this.jsBase + ".zIndex(%s);", number));
        return this;
    }

    @Override // com.anychart.graphics.vector.Element
    public void unlistenByKey(String str) {
        APIlib.getInstance().addJSLine(String.format(Locale.US, this.jsBase + ".unlistenByKey(%s);", wrapQuotes(str)));
    }
}
