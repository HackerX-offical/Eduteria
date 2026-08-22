package com.anychart.graphics.vector;

import com.amazonaws.services.s3.model.InstructionFileId;
import com.anychart.APIlib;
import com.anychart.JsObject;
import com.anychart.chart.common.dataentry.DataEntry;
import com.anychart.chart.common.listener.ListenersInterface;
import com.anychart.core.ui.StageCredits;
import com.anychart.data.View;
import com.anychart.enums.TreeFillingMethod;
import com.anychart.graphics.vector.hatchfill.HatchFillType;
import java.util.Arrays;
import java.util.List;
import java.util.Locale;

/* JADX INFO: loaded from: classes4.dex */
public class Stage extends JsObject {
    protected Stage() {
    }

    public static Stage instantiate() {
        return new Stage("new anychart.graphics.vector.stage()");
    }

    public Stage(String str) {
        StringBuilder sb = new StringBuilder("stage");
        int i = variableIndex + 1;
        variableIndex = i;
        this.jsBase = sb.append(i).toString();
        APIlib.getInstance().addJSLine(this.jsBase + " = " + str + ";");
    }

    @Override // com.anychart.JsObject
    public String getJsBase() {
        return this.jsBase;
    }

    public Stage addChild(Element element) {
        APIlib.getInstance().addJSLine(String.format(Locale.US, this.jsBase + ".addChild(%s);", element != null ? element.getJsBase() : null));
        return this;
    }

    public Stage addChildAt(Element element, Number number) {
        APIlib.getInstance().addJSLine(String.format(Locale.US, this.jsBase + ".addChildAt(%s, %s);", element != null ? element.getJsBase() : null, number));
        return this;
    }

    public Stage appendTransformationMatrix(Number number, Number number2, Number number3, Number number4, Number number5, Number number6) {
        APIlib.getInstance().addJSLine(String.format(Locale.US, this.jsBase + ".appendTransformationMatrix(%s, %s, %s, %s, %s, %s);", number, number2, number3, number4, number5, number6));
        return this;
    }

    public void asyncMode() {
        APIlib.getInstance().addJSLine(this.jsBase + ".asyncMode();");
    }

    public Stage asyncMode(Boolean bool) {
        APIlib.getInstance().addJSLine(String.format(Locale.US, this.jsBase + ".asyncMode(%s);", bool));
        return this;
    }

    public Circle circle(Number number, Number number2, Number number3) {
        return new Circle(String.format(Locale.US, this.jsBase + ".circle(%s, %s, %s)", number, number2, number3));
    }

    public com.anychart.graphics.math.Rect clip() {
        return new com.anychart.graphics.math.Rect(this.jsBase + ".clip()");
    }

    public Stage clip(com.anychart.graphics.math.Rect rect) {
        APIlib.getInstance().addJSLine(String.format(Locale.US, this.jsBase + ".clip(%s);", rect != null ? rect.getJsBase() : null));
        return this;
    }

    public void container() {
        APIlib.getInstance().addJSLine(this.jsBase + ".container();");
    }

    public Clip createClip(Number[] numberArr) {
        return new Clip(String.format(Locale.US, this.jsBase + ".createClip(%s)", Arrays.toString(numberArr)));
    }

    public Clip createClip(com.anychart.graphics.math.Rect rect) {
        return new Clip(String.format(Locale.US, this.jsBase + ".createClip(%s)", rect != null ? rect.getJsBase() : null));
    }

    public Clip createClip(String str) {
        return new Clip(String.format(Locale.US, this.jsBase + ".createClip(%s)", wrapQuotes(str)));
    }

    public Clip createClip(Number number, Number number2, Number number3, Number number4) {
        return new Clip(String.format(Locale.US, this.jsBase + ".createClip(%s, %s, %s, %s)", number, number2, number3, number4));
    }

    public StageCredits credits() {
        return new StageCredits(this.jsBase + ".credits()");
    }

    public Stage credits(String str) {
        APIlib.getInstance().addJSLine(String.format(Locale.US, this.jsBase + ".credits(%s);", wrapQuotes(str)));
        return this;
    }

    public Stage credits(Boolean bool) {
        APIlib.getInstance().addJSLine(String.format(Locale.US, this.jsBase + ".credits(%s);", bool));
        return this;
    }

    public void cross() {
        APIlib.getInstance().addJSLine(this.jsBase + ".cross();");
    }

    public void data(List<DataEntry> list) {
        APIlib.getInstance().addJSLine(String.format(Locale.US, this.jsBase + ".data(%s);", arrayToString(list)));
    }

    public void desc() {
        APIlib.getInstance().addJSLine(this.jsBase + ".desc();");
    }

    public Stage desc(String str) {
        APIlib.getInstance().addJSLine(String.format(Locale.US, this.jsBase + ".desc(%s);", wrapQuotes(str)));
        return this;
    }

    public void diagonalCross() {
        APIlib.getInstance().addJSLine(this.jsBase + ".diagonalCross();");
    }

    public void diamond() {
        APIlib.getInstance().addJSLine(this.jsBase + ".diamond();");
    }

    public void dispose() {
        APIlib.getInstance().addJSLine(this.jsBase + ".dispose();");
    }

    public void domElement() {
        APIlib.getInstance().addJSLine(this.jsBase + ".domElement();");
    }

    public void donut() {
        APIlib.getInstance().addJSLine(this.jsBase + ".donut();");
    }

    public Ellipse ellipse(Number number, Number number2, Number number3, Number number4) {
        return new Ellipse(String.format(Locale.US, this.jsBase + ".ellipse(%s, %s, %s, %s)", number, number2, number3, number4));
    }

    public void fullScreen() {
        APIlib.getInstance().addJSLine(this.jsBase + ".fullScreen();");
    }

    public Stage fullScreen(Boolean bool) {
        APIlib.getInstance().addJSLine(String.format(Locale.US, this.jsBase + ".fullScreen(%s);", bool));
        return this;
    }

    public com.anychart.graphics.math.Rect getBounds() {
        return new com.anychart.graphics.math.Rect(this.jsBase + ".getBounds()");
    }

    public Element getChildAt(Number number) {
        return new Element(String.format(Locale.US, this.jsBase + ".getChildAt(%s)", number));
    }

    public void getContainerElement() {
        APIlib.getInstance().addJSLine(this.jsBase + ".getContainerElement();");
    }

    public void getDomWrapper() {
        APIlib.getInstance().addJSLine(this.jsBase + ".getDomWrapper();");
    }

    public void getRotationAngle() {
        APIlib.getInstance().addJSLine(this.jsBase + ".getRotationAngle();");
    }

    public Stage getStage() {
        APIlib.getInstance().addJSLine(this.jsBase + ".getStage();");
        return this;
    }

    public void getTransformationMatrix() {
        APIlib.getInstance().addJSLine(this.jsBase + ".getTransformationMatrix();");
    }

    public void getX() {
        APIlib.getInstance().addJSLine(this.jsBase + ".getX();");
    }

    public void getY() {
        APIlib.getInstance().addJSLine(this.jsBase + ".getY();");
    }

    public void hLine() {
        APIlib.getInstance().addJSLine(this.jsBase + ".hLine();");
    }

    public void hasChild(Element element) {
        APIlib.getInstance().addJSLine(String.format(Locale.US, this.jsBase + ".hasChild(%s);", element != null ? element.getJsBase() : null));
    }

    public HatchFill hatchFill(HatchFillType hatchFillType, String str, Number number, Number number2) {
        return new HatchFill(String.format(Locale.US, this.jsBase + ".hatchFill(%s, %s, %s, %s)", hatchFillType != null ? hatchFillType.getJsBase() : null, wrapQuotes(str), number, number2));
    }

    public void height() {
        APIlib.getInstance().addJSLine(this.jsBase + ".height();");
    }

    public Stage height(String str) {
        APIlib.getInstance().addJSLine(String.format(Locale.US, this.jsBase + ".height(%s);", wrapQuotes(str)));
        return this;
    }

    public Stage height(Number number) {
        APIlib.getInstance().addJSLine(String.format(Locale.US, this.jsBase + ".height(%s);", number));
        return this;
    }

    public void id() {
        APIlib.getInstance().addJSLine(this.jsBase + ".id();");
    }

    public Stage id(String str) {
        APIlib.getInstance().addJSLine(String.format(Locale.US, this.jsBase + ".id(%s);", wrapQuotes(str)));
        return this;
    }

    public Image image(String str, Number number, Number number2, Number number3, Number number4) {
        return new Image(String.format(Locale.US, this.jsBase + ".image(%s, %s, %s, %s, %s)", wrapQuotes(str), number, number2, number3, number4));
    }

    public void indexOfChild(Element element) {
        APIlib.getInstance().addJSLine(String.format(Locale.US, this.jsBase + ".indexOfChild(%s);", element != null ? element.getJsBase() : null));
    }

    public void isFullScreenAvailable() {
        APIlib.getInstance().addJSLine(this.jsBase + ".isFullScreenAvailable();");
    }

    public void isRendering() {
        APIlib.getInstance().addJSLine(this.jsBase + ".isRendering();");
    }

    public void isSuspended() {
        APIlib.getInstance().addJSLine(this.jsBase + ".isSuspended();");
    }

    public Layer layer() {
        return new Layer(this.jsBase + ".layer()");
    }

    public void maxResizeDelay() {
        APIlib.getInstance().addJSLine(this.jsBase + ".maxResizeDelay();");
    }

    public Stage maxResizeDelay(Number number) {
        APIlib.getInstance().addJSLine(String.format(Locale.US, this.jsBase + ".maxResizeDelay(%s);", number));
        return this;
    }

    public void numChildren() {
        APIlib.getInstance().addJSLine(this.jsBase + ".numChildren();");
    }

    public Stage parent() {
        APIlib.getInstance().addJSLine(this.jsBase + ".parent();");
        return this;
    }

    public Path path() {
        return new Path(this.jsBase + ".path()");
    }

    public PatternFill pattern(com.anychart.graphics.math.Rect rect) {
        return new PatternFill(String.format(Locale.US, this.jsBase + ".pattern(%s)", rect != null ? rect.getJsBase() : null));
    }

    public void pie() {
        APIlib.getInstance().addJSLine(this.jsBase + ".pie();");
    }

    public void print(String str, Boolean bool) {
        APIlib.getInstance().addJSLine(String.format(Locale.US, this.jsBase + ".print(%s, %s);", wrapQuotes(str), bool));
    }

    public void print(String str, String str2) {
        APIlib.getInstance().addJSLine(String.format(Locale.US, this.jsBase + ".print(%s, %s);", wrapQuotes(str), wrapQuotes(str2)));
    }

    public void print(Number number, Boolean bool) {
        APIlib.getInstance().addJSLine(String.format(Locale.US, this.jsBase + ".print(%s, %s);", number, bool));
    }

    public void print(Number number, String str) {
        APIlib.getInstance().addJSLine(String.format(Locale.US, this.jsBase + ".print(%s, %s);", number, wrapQuotes(str)));
    }

    public Rect rect(Number number, Number number2, Number number3, Number number4) {
        return new Rect(String.format(Locale.US, this.jsBase + ".rect(%s, %s, %s, %s)", number, number2, number3, number4));
    }

    public Stage remove() {
        APIlib.getInstance().addJSLine(this.jsBase + ".remove();");
        return this;
    }

    public void removeAllListeners(String str) {
        APIlib.getInstance().addJSLine(String.format(Locale.US, this.jsBase + ".removeAllListeners(%s);", wrapQuotes(str)));
    }

    public Element removeChild(Element element) {
        return new Element(String.format(Locale.US, this.jsBase + ".removeChild(%s)", element != null ? element.getJsBase() : null));
    }

    public Element removeChildAt(Number number) {
        return new Element(String.format(Locale.US, this.jsBase + ".removeChildAt(%s)", number));
    }

    public void removeChildren() {
        APIlib.getInstance().addJSLine(this.jsBase + ".removeChildren();");
    }

    public void resize(Number number, Number number2) {
        APIlib.getInstance().addJSLine(String.format(Locale.US, this.jsBase + ".resize(%s, %s);", number, number2));
    }

    public void resize(Number number, String str) {
        APIlib.getInstance().addJSLine(String.format(Locale.US, this.jsBase + ".resize(%s, %s);", number, wrapQuotes(str)));
    }

    public void resize(String str, Number number) {
        APIlib.getInstance().addJSLine(String.format(Locale.US, this.jsBase + ".resize(%s, %s);", wrapQuotes(str), number));
    }

    public void resize(String str, String str2) {
        APIlib.getInstance().addJSLine(String.format(Locale.US, this.jsBase + ".resize(%s, %s);", wrapQuotes(str), wrapQuotes(str2)));
    }

    public Stage resume(Boolean bool) {
        APIlib.getInstance().addJSLine(String.format(Locale.US, this.jsBase + ".resume(%s);", bool));
        return this;
    }

    public Stage rotate(Number number, Number number2, Number number3) {
        APIlib.getInstance().addJSLine(String.format(Locale.US, this.jsBase + ".rotate(%s, %s, %s);", number, number2, number3));
        return this;
    }

    public Stage rotateByAnchor(Number number, Anchor anchor) {
        APIlib.getInstance().addJSLine(String.format(Locale.US, this.jsBase + ".rotateByAnchor(%s, %s);", number, anchor != null ? anchor.getJsBase() : null));
        return this;
    }

    public Stage rotateByAnchor(Number number, String str) {
        APIlib.getInstance().addJSLine(String.format(Locale.US, this.jsBase + ".rotateByAnchor(%s, %s);", number, wrapQuotes(str)));
        return this;
    }

    public void saveAsJpg(Number number, Number number2, Number number3, Boolean bool, String str) {
        APIlib.getInstance().addJSLine(String.format(Locale.US, this.jsBase + ".saveAsJpg(%s, %s, %s, %s, %s);", number, number2, number3, bool, wrapQuotes(str)));
    }

    public void saveAsPdf(String str, Boolean bool, Number number, Number number2, String str2) {
        APIlib.getInstance().addJSLine(String.format(Locale.US, this.jsBase + ".saveAsPdf(%s, %s, %s, %s, %s);", wrapQuotes(str), bool, number, number2, wrapQuotes(str2)));
    }

    public void saveAsPng(Number number, Number number2, Number number3, String str) {
        APIlib.getInstance().addJSLine(String.format(Locale.US, this.jsBase + ".saveAsPng(%s, %s, %s, %s);", number, number2, number3, wrapQuotes(str)));
    }

    public void saveAsSvg(String str, Boolean bool, String str2) {
        APIlib.getInstance().addJSLine(String.format(Locale.US, this.jsBase + ".saveAsSvg(%s, %s, %s);", wrapQuotes(str), bool, wrapQuotes(str2)));
    }

    public void saveAsSvg(Number number, Number number2) {
        APIlib.getInstance().addJSLine(String.format(Locale.US, this.jsBase + ".saveAsSvg(%s, %s);", number, number2));
    }

    public Stage scale(Number number, Number number2, Number number3, Number number4) {
        APIlib.getInstance().addJSLine(String.format(Locale.US, this.jsBase + ".scale(%s, %s, %s, %s);", number, number2, number3, number4));
        return this;
    }

    public Stage scaleByAnchor(Number number, Number number2, Anchor anchor) {
        APIlib.getInstance().addJSLine(String.format(Locale.US, this.jsBase + ".scaleByAnchor(%s, %s, %s);", number, number2, anchor != null ? anchor.getJsBase() : null));
        return this;
    }

    public Stage scaleByAnchor(Number number, Number number2, String str) {
        APIlib.getInstance().addJSLine(String.format(Locale.US, this.jsBase + ".scaleByAnchor(%s, %s, %s);", number, number2, wrapQuotes(str)));
        return this;
    }

    public Stage setPosition(Number number, Number number2) {
        APIlib.getInstance().addJSLine(String.format(Locale.US, this.jsBase + ".setPosition(%s, %s);", number, number2));
        return this;
    }

    public Stage setRotation(Number number, Number number2, Number number3) {
        APIlib.getInstance().addJSLine(String.format(Locale.US, this.jsBase + ".setRotation(%s, %s, %s);", number, number2, number3));
        return this;
    }

    public Stage setRotationByAnchor(Number number, Anchor anchor) {
        APIlib.getInstance().addJSLine(String.format(Locale.US, this.jsBase + ".setRotationByAnchor(%s, %s);", number, anchor != null ? anchor.getJsBase() : null));
        return this;
    }

    public Stage setRotationByAnchor(Number number, String str) {
        APIlib.getInstance().addJSLine(String.format(Locale.US, this.jsBase + ".setRotationByAnchor(%s, %s);", number, wrapQuotes(str)));
        return this;
    }

    public Stage setTransformationMatrix(Number number, Number number2, Number number3, Number number4, Number number5, Number number6) {
        APIlib.getInstance().addJSLine(String.format(Locale.US, this.jsBase + ".setTransformationMatrix(%s, %s, %s, %s, %s, %s);", number, number2, number3, number4, number5, number6));
        return this;
    }

    public void star() {
        APIlib.getInstance().addJSLine(this.jsBase + ".star();");
    }

    public void star10() {
        APIlib.getInstance().addJSLine(this.jsBase + ".star10();");
    }

    public void star4() {
        APIlib.getInstance().addJSLine(this.jsBase + ".star4();");
    }

    public void star5() {
        APIlib.getInstance().addJSLine(this.jsBase + ".star5();");
    }

    public void star6() {
        APIlib.getInstance().addJSLine(this.jsBase + ".star6();");
    }

    public void star7() {
        APIlib.getInstance().addJSLine(this.jsBase + ".star7();");
    }

    public Stage suspend() {
        APIlib.getInstance().addJSLine(this.jsBase + ".suspend();");
        return this;
    }

    public Stage swapChildren(Element element, Element element2) {
        APIlib.getInstance().addJSLine(String.format(Locale.US, this.jsBase + ".swapChildren(%s, %s);", element != null ? element.getJsBase() : null, element2 != null ? element2.getJsBase() : null));
        return this;
    }

    public Stage swapChildrenAt(Number number, Number number2) {
        APIlib.getInstance().addJSLine(String.format(Locale.US, this.jsBase + ".swapChildrenAt(%s, %s);", number, number2));
        return this;
    }

    public void title() {
        APIlib.getInstance().addJSLine(this.jsBase + ".title();");
    }

    public Stage title(String str) {
        APIlib.getInstance().addJSLine(String.format(Locale.US, this.jsBase + ".title(%s);", wrapQuotes(str)));
        return this;
    }

    public void toSvg(String str, Boolean bool) {
        APIlib.getInstance().addJSLine(String.format(Locale.US, this.jsBase + ".toSvg(%s, %s);", wrapQuotes(str), bool));
    }

    public void toSvg(Number number, Number number2) {
        APIlib.getInstance().addJSLine(String.format(Locale.US, this.jsBase + ".toSvg(%s, %s);", number, number2));
    }

    public Stage translate(Number number, Number number2) {
        APIlib.getInstance().addJSLine(String.format(Locale.US, this.jsBase + ".translate(%s, %s);", number, number2));
        return this;
    }

    public void triangleDown() {
        APIlib.getInstance().addJSLine(this.jsBase + ".triangleDown();");
    }

    public void triangleLeft() {
        APIlib.getInstance().addJSLine(this.jsBase + ".triangleLeft();");
    }

    public void triangleRight() {
        APIlib.getInstance().addJSLine(this.jsBase + ".triangleRight();");
    }

    public void triangleUp() {
        APIlib.getInstance().addJSLine(this.jsBase + ".triangleUp();");
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

    public void vLine() {
        APIlib.getInstance().addJSLine(this.jsBase + ".vLine();");
    }

    public void visible() {
        APIlib.getInstance().addJSLine(this.jsBase + ".visible();");
    }

    public Stage visible(Boolean bool) {
        APIlib.getInstance().addJSLine(String.format(Locale.US, this.jsBase + ".visible(%s);", bool));
        return this;
    }

    public void width() {
        APIlib.getInstance().addJSLine(this.jsBase + ".width();");
    }

    public Stage width(String str) {
        APIlib.getInstance().addJSLine(String.format(Locale.US, this.jsBase + ".width(%s);", wrapQuotes(str)));
        return this;
    }

    public Stage width(Number number) {
        APIlib.getInstance().addJSLine(String.format(Locale.US, this.jsBase + ".width(%s);", number));
        return this;
    }

    public Stage data(View view) {
        APIlib.getInstance().addJSLine(String.format(Locale.US, this.jsBase + ".data(%s);", view != null ? view.getJsBase() : null));
        return this;
    }

    public Stage data(List<DataEntry> list, TreeFillingMethod treeFillingMethod) {
        APIlib.getInstance().addJSLine(String.format(Locale.US, this.jsBase + ".data(%s, %s);", arrayToString(list), treeFillingMethod != null ? treeFillingMethod.getJsBase() : null));
        return this;
    }

    public Stage data(List<DataEntry> list, String str) {
        APIlib.getInstance().addJSLine(String.format(Locale.US, this.jsBase + ".data(%s, %s);", arrayToString(list), wrapQuotes(str)));
        return this;
    }
}
