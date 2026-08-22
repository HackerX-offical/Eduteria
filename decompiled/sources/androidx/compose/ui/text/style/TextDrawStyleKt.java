package androidx.compose.ui.text.style;

import androidx.compose.ui.graphics.Brush;
import androidx.compose.ui.graphics.Color;
import androidx.compose.ui.graphics.ColorKt;
import androidx.compose.ui.text.SpanStyleKt;
import androidx.compose.ui.util.MathHelpersKt;
import kotlin.Metadata;
import kotlin.jvm.functions.Function0;
import org.jivesoftware.smackx.blocking.element.BlockContactsIQ;

/* JADX INFO: compiled from: TextForegroundStyle.kt */
/* JADX INFO: loaded from: classes3.dex */
@Metadata(d1 = {"\u0000\u001e\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0007\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0000\u001a \u0010\u0000\u001a\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u00012\u0006\u0010\u0003\u001a\u00020\u00012\u0006\u0010\u0004\u001a\u00020\u0005H\u0000\u001a\u001b\u0010\u0006\u001a\u00020\u0007*\u00020\u00072\u0006\u0010\b\u001a\u00020\u0005H\u0000¢\u0006\u0004\b\t\u0010\n\u001a\u001a\u0010\u000b\u001a\u00020\u0005*\u00020\u00052\f\u0010\f\u001a\b\u0012\u0004\u0012\u00020\u00050\rH\u0002¨\u0006\u000e"}, d2 = {"lerp", "Landroidx/compose/ui/text/style/TextForegroundStyle;", "start", "stop", "fraction", "", "modulate", "Landroidx/compose/ui/graphics/Color;", "alpha", "modulate-DxMtmZc", "(JF)J", "takeOrElse", BlockContactsIQ.ELEMENT, "Lkotlin/Function0;", "ui-text"}, k = 2, mv = {2, 1, 0}, xi = 48)
public final class TextDrawStyleKt {
    public static final TextForegroundStyle lerp(TextForegroundStyle textForegroundStyle, TextForegroundStyle textForegroundStyle2, float f2) {
        boolean z = textForegroundStyle instanceof BrushStyle;
        if (!z && !(textForegroundStyle2 instanceof BrushStyle)) {
            return TextForegroundStyle.INSTANCE.m8735from8_81llA(ColorKt.m6019lerpjxsXWHM(textForegroundStyle.mo8588getColor0d7_KjU(), textForegroundStyle2.mo8588getColor0d7_KjU(), f2));
        }
        if (z && (textForegroundStyle2 instanceof BrushStyle)) {
            BrushStyle brushStyle = (BrushStyle) textForegroundStyle;
            BrushStyle brushStyle2 = (BrushStyle) textForegroundStyle2;
            return TextForegroundStyle.INSTANCE.from((Brush) SpanStyleKt.lerpDiscrete(brushStyle.getBrush(), brushStyle2.getBrush(), f2), MathHelpersKt.lerp(brushStyle.getAlpha(), brushStyle2.getAlpha(), f2));
        }
        return (TextForegroundStyle) SpanStyleKt.lerpDiscrete(textForegroundStyle, textForegroundStyle2, f2);
    }

    /* JADX INFO: renamed from: modulate-DxMtmZc, reason: not valid java name */
    public static final long m8734modulateDxMtmZc(long j, float f2) {
        return (Float.isNaN(f2) || f2 >= 1.0f) ? j : Color.m5967copywmQWz5c$default(j, Color.m5970getAlphaimpl(j) * f2, 0.0f, 0.0f, 0.0f, 14, null);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final float takeOrElse(float f2, Function0<Float> function0) {
        return Float.isNaN(f2) ? function0.invoke().floatValue() : f2;
    }
}
