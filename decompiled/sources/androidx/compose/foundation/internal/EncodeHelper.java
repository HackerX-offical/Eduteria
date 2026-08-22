package androidx.compose.foundation.internal;

import android.os.Parcel;
import android.util.Base64;
import androidx.compose.ui.graphics.Color;
import androidx.compose.ui.graphics.Shadow;
import androidx.compose.ui.text.SpanStyle;
import androidx.compose.ui.text.font.FontStyle;
import androidx.compose.ui.text.font.FontSynthesis;
import androidx.compose.ui.text.font.FontWeight;
import androidx.compose.ui.text.style.BaselineShift;
import androidx.compose.ui.text.style.TextDecoration;
import androidx.compose.ui.text.style.TextGeometricTransform;
import androidx.compose.ui.unit.TextUnit;
import androidx.compose.ui.unit.TextUnitType;
import androidx.constraintlayout.core.motion.utils.TypedValues;
import kotlin.Metadata;

/* JADX INFO: compiled from: ClipboardUtils.android.kt */
/* JADX INFO: loaded from: classes.dex */
@Metadata(d1 = {"\u0000\u0080\u0001\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0005\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u0007\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\b\u0001\u0018\u00002\u00020\u0001B\u0007¢\u0006\u0004\b\u0002\u0010\u0003J\u0006\u0010\u0006\u001a\u00020\u0007J\u0006\u0010\b\u001a\u00020\tJ\u000e\u0010\n\u001a\u00020\u00072\u0006\u0010\u000b\u001a\u00020\fJ\u0015\u0010\n\u001a\u00020\u00072\u0006\u0010\r\u001a\u00020\u000e¢\u0006\u0004\b\u000f\u0010\u0010J\u0015\u0010\n\u001a\u00020\u00072\u0006\u0010\u0011\u001a\u00020\u0012¢\u0006\u0004\b\u0013\u0010\u0010J\u000e\u0010\n\u001a\u00020\u00072\u0006\u0010\u0014\u001a\u00020\u0015J\u0015\u0010\n\u001a\u00020\u00072\u0006\u0010\u0016\u001a\u00020\u0017¢\u0006\u0004\b\u0018\u0010\u0019J\u0015\u0010\n\u001a\u00020\u00072\u0006\u0010\u001a\u001a\u00020\u001b¢\u0006\u0004\b\u001c\u0010\u0019J\u0015\u0010\n\u001a\u00020\u00072\u0006\u0010\u001d\u001a\u00020\u001e¢\u0006\u0004\b\u001f\u0010 J\u000e\u0010\n\u001a\u00020\u00072\u0006\u0010!\u001a\u00020\"J\u000e\u0010\n\u001a\u00020\u00072\u0006\u0010#\u001a\u00020$J\u000e\u0010\n\u001a\u00020\u00072\u0006\u0010%\u001a\u00020&J\u000e\u0010\n\u001a\u00020\u00072\u0006\u0010'\u001a\u00020(J\u000e\u0010\n\u001a\u00020\u00072\u0006\u0010)\u001a\u00020*J\u000e\u0010\n\u001a\u00020\u00072\u0006\u0010+\u001a\u00020,J\u0015\u0010\n\u001a\u00020\u00072\u0006\u0010-\u001a\u00020.¢\u0006\u0004\b/\u0010\u0010J\u000e\u0010\n\u001a\u00020\u00072\u0006\u00100\u001a\u00020\tR\u000e\u0010\u0004\u001a\u00020\u0005X\u0082\u000e¢\u0006\u0002\n\u0000¨\u00061"}, d2 = {"Landroidx/compose/foundation/internal/EncodeHelper;", "", "<init>", "()V", "parcel", "Landroid/os/Parcel;", "reset", "", "encodedString", "", "encode", "spanStyle", "Landroidx/compose/ui/text/SpanStyle;", "color", "Landroidx/compose/ui/graphics/Color;", "encode-8_81llA", "(J)V", "textUnit", "Landroidx/compose/ui/unit/TextUnit;", "encode--R2X_6o", "fontWeight", "Landroidx/compose/ui/text/font/FontWeight;", "fontStyle", "Landroidx/compose/ui/text/font/FontStyle;", "encode-nzbMABs", "(I)V", "fontSynthesis", "Landroidx/compose/ui/text/font/FontSynthesis;", "encode-6p3vJLY", "baselineShift", "Landroidx/compose/ui/text/style/BaselineShift;", "encode-4Dl_Bck", "(F)V", "textGeometricTransform", "Landroidx/compose/ui/text/style/TextGeometricTransform;", "textDecoration", "Landroidx/compose/ui/text/style/TextDecoration;", "shadow", "Landroidx/compose/ui/graphics/Shadow;", "byte", "", "int", "", TypedValues.Custom.S_FLOAT, "", "uLong", "Lkotlin/ULong;", "encode-VKZWuLQ", "string", "foundation"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final class EncodeHelper {
    public static final int $stable = 8;
    private Parcel parcel = Parcel.obtain();

    public final void reset() {
        this.parcel.recycle();
        this.parcel = Parcel.obtain();
    }

    public final String encodedString() {
        return Base64.encodeToString(this.parcel.marshall(), 0);
    }

    public final void encode(SpanStyle spanStyle) {
        if (!Color.m5969equalsimpl0(spanStyle.m8213getColor0d7_KjU(), Color.INSTANCE.m6004getUnspecified0d7_KjU())) {
            encode((byte) 1);
            m774encode8_81llA(spanStyle.m8213getColor0d7_KjU());
        }
        if (!TextUnit.m9021equalsimpl0(spanStyle.getFontSize(), TextUnit.INSTANCE.m9035getUnspecifiedXSAIIZE())) {
            encode((byte) 2);
            m771encodeR2X_6o(spanStyle.getFontSize());
        }
        FontWeight fontWeight = spanStyle.getFontWeight();
        if (fontWeight != null) {
            encode((byte) 3);
            encode(fontWeight);
        }
        FontStyle fontStyle = spanStyle.getFontStyle();
        if (fontStyle != null) {
            int iM8390unboximpl = fontStyle.m8390unboximpl();
            encode((byte) 4);
            m776encodenzbMABs(iM8390unboximpl);
        }
        FontSynthesis fontSynthesis = spanStyle.getFontSynthesis();
        if (fontSynthesis != null) {
            int iM8403unboximpl = fontSynthesis.m8403unboximpl();
            encode((byte) 5);
            m773encode6p3vJLY(iM8403unboximpl);
        }
        String fontFeatureSettings = spanStyle.getFontFeatureSettings();
        if (fontFeatureSettings != null) {
            encode((byte) 6);
            encode(fontFeatureSettings);
        }
        if (!TextUnit.m9021equalsimpl0(spanStyle.getLetterSpacing(), TextUnit.INSTANCE.m9035getUnspecifiedXSAIIZE())) {
            encode((byte) 7);
            m771encodeR2X_6o(spanStyle.getLetterSpacing());
        }
        BaselineShift baselineShift = spanStyle.getBaselineShift();
        if (baselineShift != null) {
            float fM8576unboximpl = baselineShift.m8576unboximpl();
            encode((byte) 8);
            m772encode4Dl_Bck(fM8576unboximpl);
        }
        TextGeometricTransform textGeometricTransform = spanStyle.getTextGeometricTransform();
        if (textGeometricTransform != null) {
            encode((byte) 9);
            encode(textGeometricTransform);
        }
        if (!Color.m5969equalsimpl0(spanStyle.getBackground(), Color.INSTANCE.m6004getUnspecified0d7_KjU())) {
            encode((byte) 10);
            m774encode8_81llA(spanStyle.getBackground());
        }
        TextDecoration textDecoration = spanStyle.getTextDecoration();
        if (textDecoration != null) {
            encode((byte) 11);
            encode(textDecoration);
        }
        Shadow shadow = spanStyle.getShadow();
        if (shadow != null) {
            encode((byte) 12);
            encode(shadow);
        }
    }

    /* JADX INFO: renamed from: encode-8_81llA, reason: not valid java name */
    public final void m774encode8_81llA(long color) {
        m775encodeVKZWuLQ(color);
    }

    /* JADX INFO: renamed from: encode--R2X_6o, reason: not valid java name */
    public final void m771encodeR2X_6o(long textUnit) {
        long jM9023getTypeUIouoOA = TextUnit.m9023getTypeUIouoOA(textUnit);
        byte b2 = 0;
        if (!TextUnitType.m9052equalsimpl0(jM9023getTypeUIouoOA, TextUnitType.INSTANCE.m9058getUnspecifiedUIouoOA())) {
            if (TextUnitType.m9052equalsimpl0(jM9023getTypeUIouoOA, TextUnitType.INSTANCE.m9057getSpUIouoOA())) {
                b2 = 1;
            } else if (TextUnitType.m9052equalsimpl0(jM9023getTypeUIouoOA, TextUnitType.INSTANCE.m9056getEmUIouoOA())) {
                b2 = 2;
            }
        }
        encode(b2);
        if (TextUnitType.m9052equalsimpl0(TextUnit.m9023getTypeUIouoOA(textUnit), TextUnitType.INSTANCE.m9058getUnspecifiedUIouoOA())) {
            return;
        }
        encode(TextUnit.m9024getValueimpl(textUnit));
    }

    public final void encode(FontWeight fontWeight) {
        encode(fontWeight.getWeight());
    }

    /* JADX INFO: renamed from: encode-nzbMABs, reason: not valid java name */
    public final void m776encodenzbMABs(int fontStyle) {
        byte b2 = 0;
        if (!FontStyle.m8387equalsimpl0(fontStyle, FontStyle.INSTANCE.m8394getNormal_LCdwA()) && FontStyle.m8387equalsimpl0(fontStyle, FontStyle.INSTANCE.m8393getItalic_LCdwA())) {
            b2 = 1;
        }
        encode(b2);
    }

    /* JADX INFO: renamed from: encode-6p3vJLY, reason: not valid java name */
    public final void m773encode6p3vJLY(int fontSynthesis) {
        byte b2 = 0;
        if (!FontSynthesis.m8398equalsimpl0(fontSynthesis, FontSynthesis.INSTANCE.m8405getNoneGVVA2EU())) {
            if (FontSynthesis.m8398equalsimpl0(fontSynthesis, FontSynthesis.INSTANCE.m8404getAllGVVA2EU())) {
                b2 = 1;
            } else if (FontSynthesis.m8398equalsimpl0(fontSynthesis, FontSynthesis.INSTANCE.m8407getWeightGVVA2EU())) {
                b2 = 2;
            } else if (FontSynthesis.m8398equalsimpl0(fontSynthesis, FontSynthesis.INSTANCE.m8406getStyleGVVA2EU())) {
                b2 = 3;
            }
        }
        encode(b2);
    }

    /* JADX INFO: renamed from: encode-4Dl_Bck, reason: not valid java name */
    public final void m772encode4Dl_Bck(float baselineShift) {
        encode(baselineShift);
    }

    public final void encode(TextGeometricTransform textGeometricTransform) {
        encode(textGeometricTransform.getScaleX());
        encode(textGeometricTransform.getSkewX());
    }

    public final void encode(TextDecoration textDecoration) {
        encode(textDecoration.getMask());
    }

    public final void encode(Shadow shadow) {
        m774encode8_81llA(shadow.getColor());
        encode(Float.intBitsToFloat((int) (shadow.getOffset() >> 32)));
        encode(Float.intBitsToFloat((int) (shadow.getOffset() & 4294967295L)));
        encode(shadow.getBlurRadius());
    }

    public final void encode(byte b2) {
        this.parcel.writeByte(b2);
    }

    public final void encode(int i) {
        this.parcel.writeInt(i);
    }

    public final void encode(float f2) {
        this.parcel.writeFloat(f2);
    }

    /* JADX INFO: renamed from: encode-VKZWuLQ, reason: not valid java name */
    public final void m775encodeVKZWuLQ(long uLong) {
        this.parcel.writeLong(uLong);
    }

    public final void encode(String string) {
        this.parcel.writeString(string);
    }
}
