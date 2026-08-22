package androidx.compose.ui.text.font;

import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: compiled from: FontSynthesis.android.kt */
/* JADX INFO: loaded from: classes3.dex */
@Metadata(d1 = {"\u0000\"\n\u0000\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\u001a3\u0010\u0000\u001a\u00020\u0001*\u00020\u00022\u0006\u0010\u0003\u001a\u00020\u00012\u0006\u0010\u0004\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u00072\u0006\u0010\b\u001a\u00020\tH\u0000¢\u0006\u0004\b\n\u0010\u000b¨\u0006\f"}, d2 = {"synthesizeTypeface", "", "Landroidx/compose/ui/text/font/FontSynthesis;", "typeface", "font", "Landroidx/compose/ui/text/font/Font;", "requestedWeight", "Landroidx/compose/ui/text/font/FontWeight;", "requestedStyle", "Landroidx/compose/ui/text/font/FontStyle;", "synthesizeTypeface-FxwP2eA", "(ILjava/lang/Object;Landroidx/compose/ui/text/font/Font;Landroidx/compose/ui/text/font/FontWeight;I)Ljava/lang/Object;", "ui-text"}, k = 2, mv = {2, 1, 0}, xi = 48)
public final class FontSynthesis_androidKt {
    /* JADX INFO: renamed from: synthesizeTypeface-FxwP2eA, reason: not valid java name */
    public static final Object m8409synthesizeTypefaceFxwP2eA(int i, Object obj, Font font, FontWeight fontWeight, int i2) {
        int weight;
        boolean zM8387equalsimpl0;
        if (obj instanceof android.graphics.Typeface) {
            boolean z = FontSynthesis.m8401isWeightOnimpl$ui_text(i) && !Intrinsics.areEqual(font.getWeight(), fontWeight) && fontWeight.compareTo(AndroidFontUtils_androidKt.getAndroidBold(FontWeight.INSTANCE)) >= 0 && font.getWeight().compareTo(AndroidFontUtils_androidKt.getAndroidBold(FontWeight.INSTANCE)) < 0;
            boolean z2 = FontSynthesis.m8400isStyleOnimpl$ui_text(i) && !FontStyle.m8387equalsimpl0(i2, font.getStyle());
            if (z2 || z) {
                if (z) {
                    weight = fontWeight.getWeight();
                } else {
                    weight = font.getWeight().getWeight();
                }
                if (z2) {
                    zM8387equalsimpl0 = FontStyle.m8387equalsimpl0(i2, FontStyle.INSTANCE.m8393getItalic_LCdwA());
                } else {
                    zM8387equalsimpl0 = FontStyle.m8387equalsimpl0(font.getStyle(), FontStyle.INSTANCE.m8393getItalic_LCdwA());
                }
                return TypefaceHelperMethodsApi28.INSTANCE.create((android.graphics.Typeface) obj, weight, zM8387equalsimpl0);
            }
        }
        return obj;
    }
}
