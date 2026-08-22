package androidx.compose.ui.graphics;

import androidx.compose.ui.graphics.colorspace.ColorModel;
import androidx.compose.ui.graphics.colorspace.ColorSpace;
import androidx.compose.ui.graphics.colorspace.ColorSpaces;
import androidx.compose.ui.graphics.colorspace.DoubleFunction;
import androidx.compose.ui.graphics.colorspace.Rgb;
import androidx.compose.ui.util.MathHelpersKt;
import com.appnew.android.Utils.Const;
import kotlin.Metadata;
import kotlin.ULong;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;
import org.jivesoftware.smackx.blocking.element.BlockContactsIQ;

/* JADX INFO: compiled from: Color.kt */
/* JADX INFO: loaded from: classes3.dex */
@Metadata(d1 = {"\u0000F\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0007\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\b\n\u0000\n\u0002\u0010\t\n\u0002\b\u0013\n\u0002\u0010\u0014\n\u0002\b\t\n\u0002\u0010\u000b\n\u0002\b\t\n\u0002\u0018\u0002\n\u0002\b\u0003\u001a9\u0010\u0005\u001a\u00020\u00062\u0006\u0010\u0007\u001a\u00020\b2\u0006\u0010\t\u001a\u00020\b2\u0006\u0010\n\u001a\u00020\b2\b\b\u0002\u0010\u000b\u001a\u00020\b2\b\b\u0002\u0010\f\u001a\u00020\rH\u0007¢\u0006\u0002\u0010\u000e\u001a9\u0010\u000f\u001a\u00020\u00062\u0006\u0010\u0007\u001a\u00020\b2\u0006\u0010\t\u001a\u00020\b2\u0006\u0010\n\u001a\u00020\b2\b\b\u0002\u0010\u000b\u001a\u00020\b2\b\b\u0002\u0010\f\u001a\u00020\rH\u0001¢\u0006\u0002\u0010\u000e\u001a\u0017\u0010\u0005\u001a\u00020\u00062\b\b\u0001\u0010\u0010\u001a\u00020\u0011H\u0007¢\u0006\u0002\u0010\u0012\u001a\u0015\u0010\u0005\u001a\u00020\u00062\u0006\u0010\u0010\u001a\u00020\u0013H\u0007¢\u0006\u0002\u0010\u0014\u001a5\u0010\u0005\u001a\u00020\u00062\b\b\u0001\u0010\u0007\u001a\u00020\u00112\b\b\u0001\u0010\t\u001a\u00020\u00112\b\b\u0001\u0010\n\u001a\u00020\u00112\b\b\u0003\u0010\u000b\u001a\u00020\u0011H\u0007¢\u0006\u0002\u0010\u0015\u001a)\u0010\u0016\u001a\u00020\u00062\u0006\u0010\u0017\u001a\u00020\u00062\u0006\u0010\u0018\u001a\u00020\u00062\b\b\u0001\u0010\u0019\u001a\u00020\bH\u0007¢\u0006\u0004\b\u001a\u0010\u001b\u001a\u001b\u0010\u001c\u001a\u00020\u0006*\u00020\u00062\u0006\u0010\u001d\u001a\u00020\u0006H\u0007¢\u0006\u0004\b\u001e\u0010\u001f\u001a1\u0010 \u001a\u00020\b2\u0006\u0010!\u001a\u00020\b2\u0006\u0010\"\u001a\u00020\b2\u0006\u0010#\u001a\u00020\b2\u0006\u0010$\u001a\u00020\b2\u0006\u0010%\u001a\u00020\bH\u0082\b\u001a\u0013\u0010&\u001a\u00020'*\u00020\u0006H\u0003¢\u0006\u0004\b(\u0010)\u001a\u0013\u0010*\u001a\u00020\b*\u00020\u0006H\u0007¢\u0006\u0004\b+\u0010,\u001a\u0013\u0010-\u001a\u00020\u0011*\u00020\u0006H\u0007¢\u0006\u0004\b.\u0010/\u001a\"\u00109\u001a\u00020\u0006*\u00020\u00062\f\u0010:\u001a\b\u0012\u0004\u0012\u00020\u00060;H\u0086\b¢\u0006\u0004\b<\u0010=\"\u0018\u0010\u0000\u001a\u00020\u00018\u0000X\u0081T¢\u0006\n\n\u0002\u0010\u0004\u0012\u0004\b\u0002\u0010\u0003\"\u001f\u00100\u001a\u000201*\u00020\u00068Æ\u0002X\u0087\u0004¢\u0006\f\u0012\u0004\b2\u00103\u001a\u0004\b4\u00105\"\u001f\u00106\u001a\u000201*\u00020\u00068Æ\u0002X\u0087\u0004¢\u0006\f\u0012\u0004\b7\u00103\u001a\u0004\b8\u00105¨\u0006>"}, d2 = {"UnspecifiedColor", "Lkotlin/ULong;", "getUnspecifiedColor$annotations", "()V", "J", "Color", "Landroidx/compose/ui/graphics/Color;", Const.RED, "", "green", "blue", "alpha", "colorSpace", "Landroidx/compose/ui/graphics/colorspace/ColorSpace;", "(FFFFLandroidx/compose/ui/graphics/colorspace/ColorSpace;)J", "UncheckedColor", "color", "", "(I)J", "", "(J)J", "(IIII)J", "lerp", "start", "stop", "fraction", "lerp-jxsXWHM", "(JJF)J", "compositeOver", "background", "compositeOver--OWjLjI", "(JJ)J", "compositeComponent", "fgC", "bgC", "fgA", "bgA", "a", "getComponents", "", "getComponents-8_81llA", "(J)[F", "luminance", "luminance-8_81llA", "(J)F", "toArgb", "toArgb-8_81llA", "(J)I", "isSpecified", "", "isSpecified-8_81llA$annotations", "(J)V", "isSpecified-8_81llA", "(J)Z", "isUnspecified", "isUnspecified-8_81llA$annotations", "isUnspecified-8_81llA", "takeOrElse", BlockContactsIQ.ELEMENT, "Lkotlin/Function0;", "takeOrElse-DxMtmZc", "(JLkotlin/jvm/functions/Function0;)J", "ui-graphics"}, k = 2, mv = {2, 1, 0}, xi = 48)
public final class ColorKt {
    public static final long UnspecifiedColor = 16;

    private static final float compositeComponent(float f2, float f3, float f4, float f5, float f6) {
        if (f6 == 0.0f) {
            return 0.0f;
        }
        return ((f2 * f4) + ((f3 * f5) * (1.0f - f4))) / f6;
    }

    public static /* synthetic */ void getUnspecifiedColor$annotations() {
    }

    /* JADX INFO: renamed from: isSpecified-8_81llA, reason: not valid java name */
    public static final boolean m6015isSpecified8_81llA(long j) {
        return j != 16;
    }

    /* JADX INFO: renamed from: isSpecified-8_81llA$annotations, reason: not valid java name */
    public static /* synthetic */ void m6016isSpecified8_81llA$annotations(long j) {
    }

    /* JADX INFO: renamed from: isUnspecified-8_81llA, reason: not valid java name */
    public static final boolean m6017isUnspecified8_81llA(long j) {
        return j == 16;
    }

    /* JADX INFO: renamed from: isUnspecified-8_81llA$annotations, reason: not valid java name */
    public static /* synthetic */ void m6018isUnspecified8_81llA$annotations(long j) {
    }

    public static /* synthetic */ long Color$default(float f2, float f3, float f4, float f5, ColorSpace colorSpace, int i, Object obj) {
        if ((i & 8) != 0) {
            f5 = 1.0f;
        }
        if ((i & 16) != 0) {
            colorSpace = ColorSpaces.INSTANCE.getSrgb();
        }
        return Color(f2, f3, f4, f5, colorSpace);
    }

    /* JADX WARN: Removed duplicated region for block: B:108:0x016d  */
    /* JADX WARN: Removed duplicated region for block: B:112:0x0174  */
    /* JADX WARN: Removed duplicated region for block: B:115:0x0181  */
    /* JADX WARN: Removed duplicated region for block: B:118:0x0188  */
    /* JADX WARN: Removed duplicated region for block: B:136:0x01c0  */
    /* JADX WARN: Removed duplicated region for block: B:140:0x01c7  */
    /* JADX WARN: Removed duplicated region for block: B:79:0x010b  */
    /* JADX WARN: Removed duplicated region for block: B:83:0x0112  */
    /* JADX WARN: Removed duplicated region for block: B:86:0x0120  */
    /* JADX WARN: Removed duplicated region for block: B:90:0x0128  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public static final long Color(float r20, float r21, float r22, float r23, androidx.compose.ui.graphics.colorspace.ColorSpace r24) {
        /*
            Method dump skipped, instruction units count: 503
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.compose.ui.graphics.ColorKt.Color(float, float, float, float, androidx.compose.ui.graphics.colorspace.ColorSpace):long");
    }

    public static /* synthetic */ long UncheckedColor$default(float f2, float f3, float f4, float f5, ColorSpace colorSpace, int i, Object obj) {
        if ((i & 8) != 0) {
            f5 = 1.0f;
        }
        if ((i & 16) != 0) {
            colorSpace = ColorSpaces.INSTANCE.getSrgb();
        }
        return UncheckedColor(f2, f3, f4, f5, colorSpace);
    }

    /* JADX WARN: Removed duplicated region for block: B:29:0x009c  */
    /* JADX WARN: Removed duplicated region for block: B:33:0x00a3  */
    /* JADX WARN: Removed duplicated region for block: B:50:0x00e7  */
    /* JADX WARN: Removed duplicated region for block: B:54:0x00ee  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public static final long UncheckedColor(float r17, float r18, float r19, float r20, androidx.compose.ui.graphics.colorspace.ColorSpace r21) {
        /*
            Method dump skipped, instruction units count: 350
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.compose.ui.graphics.ColorKt.UncheckedColor(float, float, float, float, androidx.compose.ui.graphics.colorspace.ColorSpace):long");
    }

    public static final long Color(int i) {
        return Color.m5964constructorimpl(ULong.m12567constructorimpl(ULong.m12567constructorimpl(i) << 32));
    }

    public static final long Color(long j) {
        return Color.m5964constructorimpl(ULong.m12567constructorimpl(j << 32));
    }

    public static /* synthetic */ long Color$default(int i, int i2, int i3, int i4, int i5, Object obj) {
        if ((i5 & 8) != 0) {
            i4 = 255;
        }
        return Color(i, i2, i3, i4);
    }

    public static final long Color(int i, int i2, int i3, int i4) {
        return Color(((i & 255) << 16) | ((i4 & 255) << 24) | ((i2 & 255) << 8) | (i3 & 255));
    }

    /* JADX INFO: renamed from: lerp-jxsXWHM, reason: not valid java name */
    public static final long m6019lerpjxsXWHM(long j, long j2, float f2) {
        ColorSpace oklab = ColorSpaces.INSTANCE.getOklab();
        long jM5965convertvNxB06k = Color.m5965convertvNxB06k(j, oklab);
        long jM5965convertvNxB06k2 = Color.m5965convertvNxB06k(j2, oklab);
        float fM5970getAlphaimpl = Color.m5970getAlphaimpl(jM5965convertvNxB06k);
        float fM5974getRedimpl = Color.m5974getRedimpl(jM5965convertvNxB06k);
        float fM5973getGreenimpl = Color.m5973getGreenimpl(jM5965convertvNxB06k);
        float fM5971getBlueimpl = Color.m5971getBlueimpl(jM5965convertvNxB06k);
        float fM5970getAlphaimpl2 = Color.m5970getAlphaimpl(jM5965convertvNxB06k2);
        float fM5974getRedimpl2 = Color.m5974getRedimpl(jM5965convertvNxB06k2);
        float fM5973getGreenimpl2 = Color.m5973getGreenimpl(jM5965convertvNxB06k2);
        float fM5971getBlueimpl2 = Color.m5971getBlueimpl(jM5965convertvNxB06k2);
        if (f2 < 0.0f) {
            f2 = 0.0f;
        }
        if (f2 > 1.0f) {
            f2 = 1.0f;
        }
        return Color.m5965convertvNxB06k(UncheckedColor(MathHelpersKt.lerp(fM5974getRedimpl, fM5974getRedimpl2, f2), MathHelpersKt.lerp(fM5973getGreenimpl, fM5973getGreenimpl2, f2), MathHelpersKt.lerp(fM5971getBlueimpl, fM5971getBlueimpl2, f2), MathHelpersKt.lerp(fM5970getAlphaimpl, fM5970getAlphaimpl2, f2), oklab), Color.m5972getColorSpaceimpl(j2));
    }

    /* JADX INFO: renamed from: compositeOver--OWjLjI, reason: not valid java name */
    public static final long m6013compositeOverOWjLjI(long j, long j2) {
        long jM5965convertvNxB06k = Color.m5965convertvNxB06k(j, Color.m5972getColorSpaceimpl(j2));
        float fM5970getAlphaimpl = Color.m5970getAlphaimpl(j2);
        float fM5970getAlphaimpl2 = Color.m5970getAlphaimpl(jM5965convertvNxB06k);
        float f2 = 1.0f - fM5970getAlphaimpl2;
        float f3 = (fM5970getAlphaimpl * f2) + fM5970getAlphaimpl2;
        return UncheckedColor(f3 == 0.0f ? 0.0f : ((Color.m5974getRedimpl(jM5965convertvNxB06k) * fM5970getAlphaimpl2) + ((Color.m5974getRedimpl(j2) * fM5970getAlphaimpl) * f2)) / f3, f3 == 0.0f ? 0.0f : ((Color.m5973getGreenimpl(jM5965convertvNxB06k) * fM5970getAlphaimpl2) + ((Color.m5973getGreenimpl(j2) * fM5970getAlphaimpl) * f2)) / f3, f3 != 0.0f ? ((Color.m5971getBlueimpl(jM5965convertvNxB06k) * fM5970getAlphaimpl2) + ((Color.m5971getBlueimpl(j2) * fM5970getAlphaimpl) * f2)) / f3 : 0.0f, f3, Color.m5972getColorSpaceimpl(j2));
    }

    /* JADX INFO: renamed from: getComponents-8_81llA, reason: not valid java name */
    private static final float[] m6014getComponents8_81llA(long j) {
        return new float[]{Color.m5974getRedimpl(j), Color.m5973getGreenimpl(j), Color.m5971getBlueimpl(j), Color.m5970getAlphaimpl(j)};
    }

    /* JADX INFO: renamed from: luminance-8_81llA, reason: not valid java name */
    public static final float m6020luminance8_81llA(long j) {
        ColorSpace colorSpaceM5972getColorSpaceimpl = Color.m5972getColorSpaceimpl(j);
        if (!ColorModel.m6400equalsimpl0(colorSpaceM5972getColorSpaceimpl.getModel(), ColorModel.INSTANCE.m6407getRgbxdoWZVw())) {
            InlineClassHelperKt.throwIllegalArgumentException("The specified color must be encoded in an RGB color space. The supplied color space is " + ((Object) ColorModel.m6403toStringimpl(colorSpaceM5972getColorSpaceimpl.getModel())));
        }
        Intrinsics.checkNotNull(colorSpaceM5972getColorSpaceimpl, "null cannot be cast to non-null type androidx.compose.ui.graphics.colorspace.Rgb");
        DoubleFunction eotfFunc$ui_graphics = ((Rgb) colorSpaceM5972getColorSpaceimpl).getEotfFunc();
        float fInvoke = (float) ((eotfFunc$ui_graphics.invoke(Color.m5974getRedimpl(j)) * 0.2126d) + (eotfFunc$ui_graphics.invoke(Color.m5973getGreenimpl(j)) * 0.7152d) + (eotfFunc$ui_graphics.invoke(Color.m5971getBlueimpl(j)) * 0.0722d));
        if (fInvoke < 0.0f) {
            fInvoke = 0.0f;
        }
        if (fInvoke > 1.0f) {
            return 1.0f;
        }
        return fInvoke;
    }

    /* JADX INFO: renamed from: toArgb-8_81llA, reason: not valid java name */
    public static final int m6022toArgb8_81llA(long j) {
        return (int) ULong.m12567constructorimpl(Color.m5965convertvNxB06k(j, ColorSpaces.INSTANCE.getSrgb()) >>> 32);
    }

    /* JADX INFO: renamed from: takeOrElse-DxMtmZc, reason: not valid java name */
    public static final long m6021takeOrElseDxMtmZc(long j, Function0<Color> function0) {
        return j != 16 ? j : function0.invoke().m5978unboximpl();
    }
}
