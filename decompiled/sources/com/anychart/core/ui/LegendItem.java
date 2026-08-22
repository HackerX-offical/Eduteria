package com.anychart.core.ui;

import com.amazonaws.services.s3.model.InstructionFileId;
import com.anychart.APIlib;
import com.anychart.chart.common.listener.ListenersInterface;
import com.anychart.core.Text;
import com.anychart.enums.WordBreak;
import com.anychart.enums.WordWrap;
import com.anychart.graphics.vector.Fill;
import com.anychart.graphics.vector.HatchFill;
import com.anychart.graphics.vector.Layer;
import com.anychart.graphics.vector.PaperSize;
import com.anychart.graphics.vector.PatternFill;
import com.anychart.graphics.vector.Stage;
import com.anychart.graphics.vector.Stroke;
import com.anychart.graphics.vector.hatchfill.HatchFillType;
import com.anychart.graphics.vector.text.Decoration;
import com.anychart.graphics.vector.text.Direction;
import com.anychart.graphics.vector.text.FontStyle;
import com.anychart.graphics.vector.text.FontVariant;
import com.anychart.graphics.vector.text.HAlign;
import com.anychart.graphics.vector.text.TextOverflow;
import com.anychart.graphics.vector.text.VAlign;
import com.anychart.math.Rect;
import java.util.Locale;

/* JADX INFO: loaded from: classes5.dex */
public class LegendItem extends Text {
    protected LegendItem() {
    }

    public static LegendItem instantiate() {
        return new LegendItem("new anychart.core.ui.legendItem()");
    }

    public LegendItem(String str) {
        StringBuilder sb = new StringBuilder("legendItem");
        int i = variableIndex + 1;
        variableIndex = i;
        this.jsBase = sb.append(i).toString();
        APIlib.getInstance().addJSLine(this.jsBase + " = " + str + ";");
    }

    @Override // com.anychart.core.Text, com.anychart.core.VisualBase, com.anychart.core.Base, com.anychart.JsObject
    public String getJsBase() {
        return this.jsBase;
    }

    @Override // com.anychart.core.Text
    public void disablePointerEvents() {
        APIlib.getInstance().addJSLine(this.jsBase + ".disablePointerEvents();");
    }

    @Override // com.anychart.core.Text
    public LegendItem disablePointerEvents(Boolean bool) {
        APIlib.getInstance().addJSLine(String.format(Locale.US, this.jsBase + ".disablePointerEvents(%s);", bool));
        return this;
    }

    public LegendItem draw() {
        APIlib.getInstance().addJSLine(this.jsBase + ".draw();");
        return this;
    }

    @Override // com.anychart.core.Text, com.anychart.core.VisualBase
    public void enabled() {
        APIlib.getInstance().addJSLine(this.jsBase + ".enabled();");
    }

    @Override // com.anychart.core.Text, com.anychart.core.VisualBase
    public LegendItem enabled(Boolean bool) {
        APIlib.getInstance().addJSLine(String.format(Locale.US, this.jsBase + ".enabled(%s);", bool));
        return this;
    }

    @Override // com.anychart.core.Text
    public void fontColor() {
        APIlib.getInstance().addJSLine(this.jsBase + ".fontColor();");
    }

    @Override // com.anychart.core.Text
    public LegendItem fontColor(String str) {
        APIlib.getInstance().addJSLine(String.format(Locale.US, this.jsBase + ".fontColor(%s);", wrapQuotes(str)));
        return this;
    }

    @Override // com.anychart.core.Text
    public void fontDecoration() {
        APIlib.getInstance().addJSLine(this.jsBase + ".fontDecoration();");
    }

    @Override // com.anychart.core.Text
    public LegendItem fontDecoration(Decoration decoration) {
        APIlib.getInstance().addJSLine(String.format(Locale.US, this.jsBase + ".fontDecoration(%s);", decoration != null ? decoration.getJsBase() : null));
        return this;
    }

    @Override // com.anychart.core.Text
    public LegendItem fontDecoration(String str) {
        APIlib.getInstance().addJSLine(String.format(Locale.US, this.jsBase + ".fontDecoration(%s);", wrapQuotes(str)));
        return this;
    }

    @Override // com.anychart.core.Text
    public void fontFamily() {
        APIlib.getInstance().addJSLine(this.jsBase + ".fontFamily();");
    }

    @Override // com.anychart.core.Text
    public LegendItem fontFamily(String str) {
        APIlib.getInstance().addJSLine(String.format(Locale.US, this.jsBase + ".fontFamily(%s);", wrapQuotes(str)));
        return this;
    }

    @Override // com.anychart.core.Text
    public void fontOpacity() {
        APIlib.getInstance().addJSLine(this.jsBase + ".fontOpacity();");
    }

    @Override // com.anychart.core.Text
    public LegendItem fontOpacity(Number number) {
        APIlib.getInstance().addJSLine(String.format(Locale.US, this.jsBase + ".fontOpacity(%s);", number));
        return this;
    }

    @Override // com.anychart.core.Text
    public void fontSize() {
        APIlib.getInstance().addJSLine(this.jsBase + ".fontSize();");
    }

    @Override // com.anychart.core.Text
    public LegendItem fontSize(String str) {
        APIlib.getInstance().addJSLine(String.format(Locale.US, this.jsBase + ".fontSize(%s);", wrapQuotes(str)));
        return this;
    }

    @Override // com.anychart.core.Text
    public LegendItem fontSize(Number number) {
        APIlib.getInstance().addJSLine(String.format(Locale.US, this.jsBase + ".fontSize(%s);", number));
        return this;
    }

    @Override // com.anychart.core.Text
    public void fontStyle() {
        APIlib.getInstance().addJSLine(this.jsBase + ".fontStyle();");
    }

    @Override // com.anychart.core.Text
    public LegendItem fontStyle(FontStyle fontStyle) {
        APIlib.getInstance().addJSLine(String.format(Locale.US, this.jsBase + ".fontStyle(%s);", fontStyle != null ? fontStyle.getJsBase() : null));
        return this;
    }

    @Override // com.anychart.core.Text
    public LegendItem fontStyle(String str) {
        APIlib.getInstance().addJSLine(String.format(Locale.US, this.jsBase + ".fontStyle(%s);", wrapQuotes(str)));
        return this;
    }

    @Override // com.anychart.core.Text
    public void fontVariant() {
        APIlib.getInstance().addJSLine(this.jsBase + ".fontVariant();");
    }

    @Override // com.anychart.core.Text
    public LegendItem fontVariant(FontVariant fontVariant) {
        APIlib.getInstance().addJSLine(String.format(Locale.US, this.jsBase + ".fontVariant(%s);", fontVariant != null ? fontVariant.getJsBase() : null));
        return this;
    }

    @Override // com.anychart.core.Text
    public LegendItem fontVariant(String str) {
        APIlib.getInstance().addJSLine(String.format(Locale.US, this.jsBase + ".fontVariant(%s);", wrapQuotes(str)));
        return this;
    }

    @Override // com.anychart.core.Text
    public void fontWeight() {
        APIlib.getInstance().addJSLine(this.jsBase + ".fontWeight();");
    }

    @Override // com.anychart.core.Text
    public LegendItem fontWeight(String str) {
        APIlib.getInstance().addJSLine(String.format(Locale.US, this.jsBase + ".fontWeight(%s);", wrapQuotes(str)));
        return this;
    }

    @Override // com.anychart.core.Text
    public LegendItem fontWeight(Number number) {
        APIlib.getInstance().addJSLine(String.format(Locale.US, this.jsBase + ".fontWeight(%s);", number));
        return this;
    }

    public Rect getContentBounds() {
        return new Rect(this.jsBase + ".getContentBounds()");
    }

    public void getHeight() {
        APIlib.getInstance().addJSLine(this.jsBase + ".getHeight();");
    }

    public com.anychart.graphics.vector.Text getTextElement() {
        return new com.anychart.graphics.vector.Text(this.jsBase + ".getTextElement()");
    }

    public void getWidth() {
        APIlib.getInstance().addJSLine(this.jsBase + ".getWidth();");
    }

    @Override // com.anychart.core.Text
    public void hAlign() {
        APIlib.getInstance().addJSLine(this.jsBase + ".hAlign();");
    }

    @Override // com.anychart.core.Text
    public LegendItem hAlign(HAlign hAlign) {
        APIlib.getInstance().addJSLine(String.format(Locale.US, this.jsBase + ".hAlign(%s);", hAlign != null ? hAlign.getJsBase() : null));
        return this;
    }

    @Override // com.anychart.core.Text
    public LegendItem hAlign(String str) {
        APIlib.getInstance().addJSLine(String.format(Locale.US, this.jsBase + ".hAlign(%s);", wrapQuotes(str)));
        return this;
    }

    public void iconFill(Fill fill) {
        APIlib.getInstance().addJSLine(String.format(Locale.US, this.jsBase + ".iconFill(%s);", fill != null ? fill.getJsBase() : null));
    }

    public PatternFill iconHatchFill() {
        return new PatternFill(this.jsBase + ".iconHatchFill()");
    }

    public LegendItem iconHatchFill(PatternFill patternFill, String str, Number number, Number number2) {
        APIlib.getInstance().addJSLine(String.format(Locale.US, this.jsBase + ".iconHatchFill(%s, %s, %s, %s);", patternFill != null ? patternFill.getJsBase() : null, wrapQuotes(str), number, number2));
        return this;
    }

    public LegendItem iconHatchFill(HatchFill hatchFill, String str, Number number, Number number2) {
        APIlib.getInstance().addJSLine(String.format(Locale.US, this.jsBase + ".iconHatchFill(%s, %s, %s, %s);", hatchFill != null ? hatchFill.getJsBase() : null, wrapQuotes(str), number, number2));
        return this;
    }

    public LegendItem iconHatchFill(String str, String str2, Number number, Number number2) {
        APIlib.getInstance().addJSLine(String.format(Locale.US, this.jsBase + ".iconHatchFill(%s, %s, %s, %s);", wrapQuotes(str), wrapQuotes(str2), number, number2));
        return this;
    }

    public LegendItem iconHatchFill(HatchFillType hatchFillType, String str, Number number, Number number2) {
        APIlib.getInstance().addJSLine(String.format(Locale.US, this.jsBase + ".iconHatchFill(%s, %s, %s, %s);", hatchFillType != null ? hatchFillType.getJsBase() : null, wrapQuotes(str), number, number2));
        return this;
    }

    public void iconStroke(Stroke stroke) {
        APIlib.getInstance().addJSLine(String.format(Locale.US, this.jsBase + ".iconStroke(%s);", stroke != null ? stroke.getJsBase() : null));
    }

    public LegendItem iconTextSpacing(Number number) {
        APIlib.getInstance().addJSLine(String.format(Locale.US, this.jsBase + ".iconTextSpacing(%s);", number));
        return this;
    }

    public void iconType(String str) {
        APIlib.getInstance().addJSLine(String.format(Locale.US, this.jsBase + ".iconType(%s);", wrapQuotes(str)));
    }

    @Override // com.anychart.core.Text
    public void letterSpacing() {
        APIlib.getInstance().addJSLine(this.jsBase + ".letterSpacing();");
    }

    @Override // com.anychart.core.Text
    public LegendItem letterSpacing(String str) {
        APIlib.getInstance().addJSLine(String.format(Locale.US, this.jsBase + ".letterSpacing(%s);", wrapQuotes(str)));
        return this;
    }

    @Override // com.anychart.core.Text
    public LegendItem letterSpacing(Number number) {
        APIlib.getInstance().addJSLine(String.format(Locale.US, this.jsBase + ".letterSpacing(%s);", number));
        return this;
    }

    @Override // com.anychart.core.Text
    public void lineHeight() {
        APIlib.getInstance().addJSLine(this.jsBase + ".lineHeight();");
    }

    @Override // com.anychart.core.Text
    public LegendItem lineHeight(String str) {
        APIlib.getInstance().addJSLine(String.format(Locale.US, this.jsBase + ".lineHeight(%s);", wrapQuotes(str)));
        return this;
    }

    @Override // com.anychart.core.Text
    public LegendItem lineHeight(Number number) {
        APIlib.getInstance().addJSLine(String.format(Locale.US, this.jsBase + ".lineHeight(%s);", number));
        return this;
    }

    public void maxHeight() {
        APIlib.getInstance().addJSLine(this.jsBase + ".maxHeight();");
    }

    public LegendItem maxHeight(Number number) {
        APIlib.getInstance().addJSLine(String.format(Locale.US, this.jsBase + ".maxHeight(%s);", number));
        return this;
    }

    public LegendItem maxHeight(String str) {
        APIlib.getInstance().addJSLine(String.format(Locale.US, this.jsBase + ".maxHeight(%s);", wrapQuotes(str)));
        return this;
    }

    public void maxWidth() {
        APIlib.getInstance().addJSLine(this.jsBase + ".maxWidth();");
    }

    public LegendItem maxWidth(Number number) {
        APIlib.getInstance().addJSLine(String.format(Locale.US, this.jsBase + ".maxWidth(%s);", number));
        return this;
    }

    public LegendItem maxWidth(String str) {
        APIlib.getInstance().addJSLine(String.format(Locale.US, this.jsBase + ".maxWidth(%s);", wrapQuotes(str)));
        return this;
    }

    @Override // com.anychart.core.Text, com.anychart.core.VisualBase
    public void print(PaperSize paperSize, Boolean bool) {
        APIlib.getInstance().addJSLine(String.format(Locale.US, this.jsBase + ".print(%s, %s);", paperSize != null ? paperSize.getJsBase() : null, bool));
    }

    @Override // com.anychart.core.Text, com.anychart.core.VisualBase
    public void print(String str, Boolean bool) {
        APIlib.getInstance().addJSLine(String.format(Locale.US, this.jsBase + ".print(%s, %s);", wrapQuotes(str), bool));
    }

    @Override // com.anychart.core.Text, com.anychart.core.VisualBase, com.anychart.core.Base
    public void removeAllListeners(String str) {
        APIlib.getInstance().addJSLine(String.format(Locale.US, this.jsBase + ".removeAllListeners(%s);", wrapQuotes(str)));
    }

    @Override // com.anychart.core.Text
    public void selectable() {
        APIlib.getInstance().addJSLine(this.jsBase + ".selectable();");
    }

    @Override // com.anychart.core.Text
    public LegendItem selectable(Boolean bool) {
        APIlib.getInstance().addJSLine(String.format(Locale.US, this.jsBase + ".selectable(%s);", bool));
        return this;
    }

    public void text(String str) {
        APIlib.getInstance().addJSLine(String.format(Locale.US, this.jsBase + ".text(%s);", wrapQuotes(str)));
    }

    @Override // com.anychart.core.Text
    public void textDirection() {
        APIlib.getInstance().addJSLine(this.jsBase + ".textDirection();");
    }

    @Override // com.anychart.core.Text
    public LegendItem textDirection(Direction direction) {
        APIlib.getInstance().addJSLine(String.format(Locale.US, this.jsBase + ".textDirection(%s);", direction != null ? direction.getJsBase() : null));
        return this;
    }

    @Override // com.anychart.core.Text
    public LegendItem textDirection(String str) {
        APIlib.getInstance().addJSLine(String.format(Locale.US, this.jsBase + ".textDirection(%s);", wrapQuotes(str)));
        return this;
    }

    @Override // com.anychart.core.Text
    public void textIndent() {
        APIlib.getInstance().addJSLine(this.jsBase + ".textIndent();");
    }

    @Override // com.anychart.core.Text
    public LegendItem textIndent(Number number) {
        APIlib.getInstance().addJSLine(String.format(Locale.US, this.jsBase + ".textIndent(%s);", number));
        return this;
    }

    @Override // com.anychart.core.Text
    public void textOverflow() {
        APIlib.getInstance().addJSLine(this.jsBase + ".textOverflow();");
    }

    @Override // com.anychart.core.Text
    public LegendItem textOverflow(TextOverflow textOverflow) {
        APIlib.getInstance().addJSLine(String.format(Locale.US, this.jsBase + ".textOverflow(%s);", textOverflow != null ? textOverflow.getJsBase() : null));
        return this;
    }

    @Override // com.anychart.core.Text
    public LegendItem textOverflow(String str) {
        APIlib.getInstance().addJSLine(String.format(Locale.US, this.jsBase + ".textOverflow(%s);", wrapQuotes(str)));
        return this;
    }

    @Override // com.anychart.core.Text
    public void textSettings() {
        APIlib.getInstance().addJSLine(this.jsBase + ".textSettings();");
    }

    @Override // com.anychart.core.Text
    public void textSettings(String str) {
        APIlib.getInstance().addJSLine(String.format(Locale.US, this.jsBase + ".textSettings(%s);", wrapQuotes(str)));
    }

    @Override // com.anychart.core.Text
    public LegendItem textSettings(String str, String str2) {
        APIlib.getInstance().addJSLine(String.format(Locale.US, this.jsBase + ".textSettings(%s, %s);", wrapQuotes(str), wrapQuotes(str2)));
        return this;
    }

    @Override // com.anychart.core.Text
    public LegendItem textSettings(String str, Number number) {
        APIlib.getInstance().addJSLine(String.format(Locale.US, this.jsBase + ".textSettings(%s, %s);", wrapQuotes(str), number));
        return this;
    }

    @Override // com.anychart.core.Text
    public LegendItem textSettings(String str, Boolean bool) {
        APIlib.getInstance().addJSLine(String.format(Locale.US, this.jsBase + ".textSettings(%s, %s);", wrapQuotes(str), bool));
        return this;
    }

    @Override // com.anychart.core.Text, com.anychart.core.VisualBase, com.anychart.core.Base
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

    @Override // com.anychart.core.Text, com.anychart.core.VisualBase, com.anychart.core.Base
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

    @Override // com.anychart.core.Text, com.anychart.core.VisualBase, com.anychart.core.Base
    public void unlistenByKey(String str) {
        APIlib.getInstance().addJSLine(String.format(Locale.US, this.jsBase + ".unlistenByKey(%s);", wrapQuotes(str)));
    }

    @Override // com.anychart.core.Text
    public void useHtml() {
        APIlib.getInstance().addJSLine(this.jsBase + ".useHtml();");
    }

    @Override // com.anychart.core.Text
    public LegendItem useHtml(Boolean bool) {
        APIlib.getInstance().addJSLine(String.format(Locale.US, this.jsBase + ".useHtml(%s);", bool));
        return this;
    }

    @Override // com.anychart.core.Text
    public void vAlign() {
        APIlib.getInstance().addJSLine(this.jsBase + ".vAlign();");
    }

    @Override // com.anychart.core.Text
    public LegendItem vAlign(VAlign vAlign) {
        APIlib.getInstance().addJSLine(String.format(Locale.US, this.jsBase + ".vAlign(%s);", vAlign != null ? vAlign.getJsBase() : null));
        return this;
    }

    @Override // com.anychart.core.Text
    public LegendItem vAlign(String str) {
        APIlib.getInstance().addJSLine(String.format(Locale.US, this.jsBase + ".vAlign(%s);", wrapQuotes(str)));
        return this;
    }

    @Override // com.anychart.core.Text
    public void wordBreak() {
        APIlib.getInstance().addJSLine(this.jsBase + ".wordBreak();");
    }

    @Override // com.anychart.core.Text
    public LegendItem wordBreak(WordBreak wordBreak) {
        APIlib.getInstance().addJSLine(String.format(Locale.US, this.jsBase + ".wordBreak(%s);", wordBreak != null ? wordBreak.getJsBase() : null));
        return this;
    }

    @Override // com.anychart.core.Text
    public LegendItem wordBreak(String str) {
        APIlib.getInstance().addJSLine(String.format(Locale.US, this.jsBase + ".wordBreak(%s);", wrapQuotes(str)));
        return this;
    }

    @Override // com.anychart.core.Text
    public void wordWrap() {
        APIlib.getInstance().addJSLine(this.jsBase + ".wordWrap();");
    }

    @Override // com.anychart.core.Text
    public LegendItem wordWrap(WordWrap wordWrap) {
        APIlib.getInstance().addJSLine(String.format(Locale.US, this.jsBase + ".wordWrap(%s);", wordWrap != null ? wordWrap.getJsBase() : null));
        return this;
    }

    @Override // com.anychart.core.Text
    public LegendItem wordWrap(String str) {
        APIlib.getInstance().addJSLine(String.format(Locale.US, this.jsBase + ".wordWrap(%s);", wrapQuotes(str)));
        return this;
    }

    public void x(Number number) {
        APIlib.getInstance().addJSLine(String.format(Locale.US, this.jsBase + ".x(%s);", number));
    }

    public void x(String str) {
        APIlib.getInstance().addJSLine(String.format(Locale.US, this.jsBase + ".x(%s);", wrapQuotes(str)));
    }

    public void y(Number number) {
        APIlib.getInstance().addJSLine(String.format(Locale.US, this.jsBase + ".y(%s);", number));
    }

    public void y(String str) {
        APIlib.getInstance().addJSLine(String.format(Locale.US, this.jsBase + ".y(%s);", wrapQuotes(str)));
    }

    @Override // com.anychart.core.Text, com.anychart.core.VisualBase
    public void zIndex() {
        APIlib.getInstance().addJSLine(this.jsBase + ".zIndex();");
    }

    @Override // com.anychart.core.Text, com.anychart.core.VisualBase
    public LegendItem zIndex(Number number) {
        APIlib.getInstance().addJSLine(String.format(Locale.US, this.jsBase + ".zIndex(%s);", number));
        return this;
    }

    @Override // com.anychart.core.Text, com.anychart.core.VisualBase
    public Layer container() {
        return new Layer(this.jsBase + ".container()");
    }

    @Override // com.anychart.core.Text, com.anychart.core.VisualBase
    public LegendItem container(Layer layer) {
        APIlib.getInstance().addJSLine(String.format(Locale.US, this.jsBase + ".container(%s);", layer != null ? layer.getJsBase() : null));
        return this;
    }

    @Override // com.anychart.core.Text, com.anychart.core.VisualBase
    public LegendItem container(Stage stage) {
        APIlib.getInstance().addJSLine(String.format(Locale.US, this.jsBase + ".container(%s);", stage != null ? stage.getJsBase() : null));
        return this;
    }

    @Override // com.anychart.core.Text, com.anychart.core.VisualBase
    public LegendItem container(String str) {
        APIlib.getInstance().addJSLine(String.format(Locale.US, this.jsBase + ".container(%s);", wrapQuotes(str)));
        return this;
    }

    @Override // com.anychart.core.Text, com.anychart.core.VisualBase
    public Rect parentBounds() {
        return new Rect(this.jsBase + ".parentBounds()");
    }

    @Override // com.anychart.core.Text, com.anychart.core.VisualBase
    public LegendItem parentBounds(Rect rect) {
        APIlib.getInstance().addJSLine(String.format(Locale.US, this.jsBase + ".parentBounds(%s);", rect != null ? rect.getJsBase() : null));
        return this;
    }

    @Override // com.anychart.core.Text, com.anychart.core.VisualBase
    public LegendItem parentBounds(String str) {
        APIlib.getInstance().addJSLine(String.format(Locale.US, this.jsBase + ".parentBounds(%s);", wrapQuotes(str)));
        return this;
    }

    @Override // com.anychart.core.Text, com.anychart.core.VisualBase
    public LegendItem parentBounds(Number number) {
        APIlib.getInstance().addJSLine(String.format(Locale.US, this.jsBase + ".parentBounds(%s);", number));
        return this;
    }

    @Override // com.anychart.core.Text, com.anychart.core.VisualBase
    public LegendItem parentBounds(Number number, Number number2, Number number3, Number number4) {
        APIlib.getInstance().addJSLine(String.format(Locale.US, this.jsBase + ".parentBounds(%s, %s, %s, %s);", number, number2, number3, number4));
        return this;
    }
}
