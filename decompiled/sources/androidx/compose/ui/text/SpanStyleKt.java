package androidx.compose.ui.text;

import androidx.compose.ui.graphics.Color;
import androidx.compose.ui.graphics.ColorKt;
import androidx.compose.ui.graphics.Shadow;
import androidx.compose.ui.graphics.ShadowKt;
import androidx.compose.ui.graphics.drawscope.DrawStyle;
import androidx.compose.ui.graphics.drawscope.Fill;
import androidx.compose.ui.text.font.FontFamily;
import androidx.compose.ui.text.font.FontStyle;
import androidx.compose.ui.text.font.FontSynthesis;
import androidx.compose.ui.text.font.FontWeight;
import androidx.compose.ui.text.font.FontWeightKt;
import androidx.compose.ui.text.font.SystemFontFamily;
import androidx.compose.ui.text.intl.LocaleList;
import androidx.compose.ui.text.style.BaselineShift;
import androidx.compose.ui.text.style.BaselineShiftKt;
import androidx.compose.ui.text.style.TextDecoration;
import androidx.compose.ui.text.style.TextDrawStyleKt;
import androidx.compose.ui.text.style.TextForegroundStyle;
import androidx.compose.ui.text.style.TextGeometricTransform;
import androidx.compose.ui.text.style.TextGeometricTransformKt;
import androidx.compose.ui.unit.TextUnit;
import androidx.compose.ui.unit.TextUnitKt;
import androidx.exifinterface.media.ExifInterface;
import kotlin.Metadata;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: compiled from: SpanStyle.kt */
/* JADX INFO: loaded from: classes3.dex */
@Metadata(d1 = {"\u0000\u0086\u0001\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\u0007\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0005\u001a'\u0010\t\u001a\u00020\u00012\u0006\u0010\n\u001a\u00020\u00012\u0006\u0010\u000b\u001a\u00020\u00012\u0006\u0010\f\u001a\u00020\rH\u0000¢\u0006\u0004\b\u000e\u0010\u000f\u001a+\u0010\u0010\u001a\u0002H\u0011\"\u0004\b\u0000\u0010\u00112\u0006\u0010\n\u001a\u0002H\u00112\u0006\u0010\u000b\u001a\u0002H\u00112\u0006\u0010\u0012\u001a\u00020\rH\u0000¢\u0006\u0002\u0010\u0013\u001a\u001e\u0010\u0014\u001a\u00020\u00152\u0006\u0010\u0016\u001a\u00020\u00152\u0006\u0010\u0017\u001a\u00020\u00152\u0006\u0010\u0012\u001a\u00020\r\u001a&\u0010\u0018\u001a\u0004\u0018\u00010\u00192\b\u0010\u001a\u001a\u0004\u0018\u00010\u00192\b\u0010\u001b\u001a\u0004\u0018\u00010\u00192\u0006\u0010\u0012\u001a\u00020\rH\u0000\u001a\f\u0010\u001c\u001a\u00020\u0019*\u00020\u0019H\u0002\u001a&\u0010\u001d\u001a\u0004\u0018\u00010\u001e2\b\u0010\u0016\u001a\u0004\u0018\u00010\u001e2\b\u0010\u0017\u001a\u0004\u0018\u00010\u001e2\u0006\u0010\u0012\u001a\u00020\rH\u0002\u001a\u0010\u0010\u001f\u001a\u00020\u00152\u0006\u0010 \u001a\u00020\u0015H\u0000\u001a½\u0001\u0010!\u001a\u00020\u0015*\u00020\u00152\u0006\u0010\"\u001a\u00020\u00052\b\u0010#\u001a\u0004\u0018\u00010$2\u0006\u0010%\u001a\u00020\r2\u0006\u0010&\u001a\u00020\u00012\b\u0010'\u001a\u0004\u0018\u00010(2\b\u0010)\u001a\u0004\u0018\u00010*2\b\u0010+\u001a\u0004\u0018\u00010,2\b\u0010-\u001a\u0004\u0018\u00010.2\b\u0010/\u001a\u0004\u0018\u0001002\u0006\u00101\u001a\u00020\u00012\b\u00102\u001a\u0004\u0018\u0001032\b\u00104\u001a\u0004\u0018\u0001052\b\u00106\u001a\u0004\u0018\u0001072\u0006\u00108\u001a\u00020\u00052\b\u00109\u001a\u0004\u0018\u00010:2\b\u0010;\u001a\u0004\u0018\u00010\u00192\b\u0010<\u001a\u0004\u0018\u00010\u001e2\b\u0010=\u001a\u0004\u0018\u00010>H\u0000¢\u0006\u0004\b?\u0010@\u001a\u0018\u0010A\u001a\u0004\u0018\u00010\u001e*\u00020\u00152\b\u0010B\u001a\u0004\u0018\u00010\u001eH\u0002\"\u0010\u0010\u0000\u001a\u00020\u0001X\u0082\u0004¢\u0006\u0004\n\u0002\u0010\u0002\"\u0010\u0010\u0003\u001a\u00020\u0001X\u0082\u0004¢\u0006\u0004\n\u0002\u0010\u0002\"\u0010\u0010\u0004\u001a\u00020\u0005X\u0082\u0004¢\u0006\u0004\n\u0002\u0010\u0002\"\u0010\u0010\u0006\u001a\u00020\u0005X\u0082\u0004¢\u0006\u0004\n\u0002\u0010\u0002\"\u000e\u0010\u0007\u001a\u00020\bX\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006C"}, d2 = {"DefaultFontSize", "Landroidx/compose/ui/unit/TextUnit;", "J", "DefaultLetterSpacing", "DefaultBackgroundColor", "Landroidx/compose/ui/graphics/Color;", "DefaultColor", "DefaultColorForegroundStyle", "Landroidx/compose/ui/text/style/TextForegroundStyle;", "lerpTextUnitInheritable", "a", "b", "t", "", "lerpTextUnitInheritable-C3pnCVY", "(JJF)J", "lerpDiscrete", ExifInterface.GPS_DIRECTION_TRUE, "fraction", "(Ljava/lang/Object;Ljava/lang/Object;F)Ljava/lang/Object;", "lerp", "Landroidx/compose/ui/text/SpanStyle;", "start", "stop", "nullSafeLerp", "Landroidx/compose/ui/graphics/Shadow;", "lhs", "rhs", "dropAlpha", "lerpPlatformStyle", "Landroidx/compose/ui/text/PlatformSpanStyle;", "resolveSpanStyleDefaults", "style", "fastMerge", "color", "brush", "Landroidx/compose/ui/graphics/Brush;", "alpha", "fontSize", "fontWeight", "Landroidx/compose/ui/text/font/FontWeight;", "fontStyle", "Landroidx/compose/ui/text/font/FontStyle;", "fontSynthesis", "Landroidx/compose/ui/text/font/FontSynthesis;", "fontFamily", "Landroidx/compose/ui/text/font/FontFamily;", "fontFeatureSettings", "", "letterSpacing", "baselineShift", "Landroidx/compose/ui/text/style/BaselineShift;", "textGeometricTransform", "Landroidx/compose/ui/text/style/TextGeometricTransform;", "localeList", "Landroidx/compose/ui/text/intl/LocaleList;", "background", "textDecoration", "Landroidx/compose/ui/text/style/TextDecoration;", "shadow", "platformStyle", "drawStyle", "Landroidx/compose/ui/graphics/drawscope/DrawStyle;", "fastMerge-dSHsh3o", "(Landroidx/compose/ui/text/SpanStyle;JLandroidx/compose/ui/graphics/Brush;FJLandroidx/compose/ui/text/font/FontWeight;Landroidx/compose/ui/text/font/FontStyle;Landroidx/compose/ui/text/font/FontSynthesis;Landroidx/compose/ui/text/font/FontFamily;Ljava/lang/String;JLandroidx/compose/ui/text/style/BaselineShift;Landroidx/compose/ui/text/style/TextGeometricTransform;Landroidx/compose/ui/text/intl/LocaleList;JLandroidx/compose/ui/text/style/TextDecoration;Landroidx/compose/ui/graphics/Shadow;Landroidx/compose/ui/text/PlatformSpanStyle;Landroidx/compose/ui/graphics/drawscope/DrawStyle;)Landroidx/compose/ui/text/SpanStyle;", "mergePlatformStyle", "other", "ui-text"}, k = 2, mv = {2, 1, 0}, xi = 48)
public final class SpanStyleKt {
    private static final long DefaultColor;
    private static final TextForegroundStyle DefaultColorForegroundStyle;
    private static final long DefaultFontSize = TextUnitKt.getSp(14);
    private static final long DefaultLetterSpacing = TextUnitKt.getSp(0);
    private static final long DefaultBackgroundColor = Color.INSTANCE.m6003getTransparent0d7_KjU();

    public static final <T> T lerpDiscrete(T t, T t2, float f2) {
        return ((double) f2) < 0.5d ? t : t2;
    }

    static {
        long jM5994getBlack0d7_KjU = Color.INSTANCE.m5994getBlack0d7_KjU();
        DefaultColor = jM5994getBlack0d7_KjU;
        DefaultColorForegroundStyle = TextForegroundStyle.INSTANCE.m8735from8_81llA(jM5994getBlack0d7_KjU);
    }

    public static final SpanStyle lerp(SpanStyle spanStyle, SpanStyle spanStyle2, float f2) {
        TextForegroundStyle textForegroundStyleLerp = TextDrawStyleKt.lerp(spanStyle.getTextForegroundStyle(), spanStyle2.getTextForegroundStyle(), f2);
        FontFamily fontFamily = (FontFamily) lerpDiscrete(spanStyle.getFontFamily(), spanStyle2.getFontFamily(), f2);
        long jM8219lerpTextUnitInheritableC3pnCVY = m8219lerpTextUnitInheritableC3pnCVY(spanStyle.getFontSize(), spanStyle2.getFontSize(), f2);
        FontWeight fontWeight = spanStyle.getFontWeight();
        if (fontWeight == null) {
            fontWeight = FontWeight.INSTANCE.getNormal();
        }
        FontWeight fontWeight2 = spanStyle2.getFontWeight();
        if (fontWeight2 == null) {
            fontWeight2 = FontWeight.INSTANCE.getNormal();
        }
        FontWeight fontWeightLerp = FontWeightKt.lerp(fontWeight, fontWeight2, f2);
        FontStyle fontStyle = (FontStyle) lerpDiscrete(spanStyle.getFontStyle(), spanStyle2.getFontStyle(), f2);
        FontSynthesis fontSynthesis = (FontSynthesis) lerpDiscrete(spanStyle.getFontSynthesis(), spanStyle2.getFontSynthesis(), f2);
        String str = (String) lerpDiscrete(spanStyle.getFontFeatureSettings(), spanStyle2.getFontFeatureSettings(), f2);
        long jM8219lerpTextUnitInheritableC3pnCVY2 = m8219lerpTextUnitInheritableC3pnCVY(spanStyle.getLetterSpacing(), spanStyle2.getLetterSpacing(), f2);
        BaselineShift baselineShift = spanStyle.getBaselineShift();
        float fM8576unboximpl = baselineShift != null ? baselineShift.m8576unboximpl() : BaselineShift.m8571constructorimpl(0.0f);
        BaselineShift baselineShift2 = spanStyle2.getBaselineShift();
        float fM8586lerpjWV1Mfo = BaselineShiftKt.m8586lerpjWV1Mfo(fM8576unboximpl, baselineShift2 != null ? baselineShift2.m8576unboximpl() : BaselineShift.m8571constructorimpl(0.0f), f2);
        TextGeometricTransform textGeometricTransform = spanStyle.getTextGeometricTransform();
        if (textGeometricTransform == null) {
            textGeometricTransform = TextGeometricTransform.INSTANCE.getNone$ui_text();
        }
        TextGeometricTransform textGeometricTransform2 = spanStyle2.getTextGeometricTransform();
        if (textGeometricTransform2 == null) {
            textGeometricTransform2 = TextGeometricTransform.INSTANCE.getNone$ui_text();
        }
        return new SpanStyle(textForegroundStyleLerp, jM8219lerpTextUnitInheritableC3pnCVY, fontWeightLerp, fontStyle, fontSynthesis, fontFamily, str, jM8219lerpTextUnitInheritableC3pnCVY2, BaselineShift.m8570boximpl(fM8586lerpjWV1Mfo), TextGeometricTransformKt.lerp(textGeometricTransform, textGeometricTransform2, f2), (LocaleList) lerpDiscrete(spanStyle.getLocaleList(), spanStyle2.getLocaleList(), f2), ColorKt.m6019lerpjxsXWHM(spanStyle.getBackground(), spanStyle2.getBackground(), f2), (TextDecoration) lerpDiscrete(spanStyle.getTextDecoration(), spanStyle2.getTextDecoration(), f2), nullSafeLerp(spanStyle.getShadow(), spanStyle2.getShadow(), f2), lerpPlatformStyle(spanStyle.getPlatformStyle(), spanStyle2.getPlatformStyle(), f2), (DrawStyle) lerpDiscrete(spanStyle.getDrawStyle(), spanStyle2.getDrawStyle(), f2), (DefaultConstructorMarker) null);
    }

    public static final Shadow nullSafeLerp(Shadow shadow, Shadow shadow2, float f2) {
        if (!ComposeUiTextFlags.isCorrectShadowLerpWithNullsEnabled) {
            if (shadow == null) {
                shadow = new Shadow(0L, 0L, 0.0f, 7, null);
            }
            if (shadow2 == null) {
                shadow2 = new Shadow(0L, 0L, 0.0f, 7, null);
            }
            return ShadowKt.lerp(shadow, shadow2, f2);
        }
        if (shadow == null && shadow2 == null) {
            return null;
        }
        if (shadow == null) {
            Intrinsics.checkNotNull(shadow2);
            return ShadowKt.lerp(dropAlpha(shadow2), shadow2, f2);
        }
        if (shadow2 == null) {
            return ShadowKt.lerp(shadow, dropAlpha(shadow), f2);
        }
        return ShadowKt.lerp(shadow, shadow2, f2);
    }

    private static final Shadow dropAlpha(Shadow shadow) {
        return Shadow.m6310copyqcb84PM$default(shadow, Color.m5967copywmQWz5c$default(shadow.getColor(), 0.0f, 0.0f, 0.0f, 0.0f, 14, null), 0L, 0.0f, 6, null);
    }

    private static final PlatformSpanStyle lerpPlatformStyle(PlatformSpanStyle platformSpanStyle, PlatformSpanStyle platformSpanStyle2, float f2) {
        if (platformSpanStyle == null && platformSpanStyle2 == null) {
            return null;
        }
        if (platformSpanStyle == null) {
            platformSpanStyle = PlatformSpanStyle.INSTANCE.getDefault();
        }
        if (platformSpanStyle2 == null) {
            platformSpanStyle2 = PlatformSpanStyle.INSTANCE.getDefault();
        }
        return AndroidTextStyle_androidKt.lerp(platformSpanStyle, platformSpanStyle2, f2);
    }

    public static final SpanStyle resolveSpanStyleDefaults(SpanStyle spanStyle) {
        long letterSpacing;
        TextForegroundStyle textForegroundStyleTakeOrElse = spanStyle.getTextForegroundStyle().takeOrElse(new Function0() { // from class: androidx.compose.ui.text.SpanStyleKt$$ExternalSyntheticLambda0
            @Override // kotlin.jvm.functions.Function0
            public final Object invoke() {
                return SpanStyleKt.DefaultColorForegroundStyle;
            }
        });
        long fontSize = TextUnit.m9022getRawTypeimpl(spanStyle.getFontSize()) == 0 ? DefaultFontSize : spanStyle.getFontSize();
        FontWeight fontWeight = spanStyle.getFontWeight();
        if (fontWeight == null) {
            fontWeight = FontWeight.INSTANCE.getNormal();
        }
        FontWeight fontWeight2 = fontWeight;
        FontStyle fontStyle = spanStyle.getFontStyle();
        FontStyle fontStyleM8384boximpl = FontStyle.m8384boximpl(fontStyle != null ? fontStyle.m8390unboximpl() : FontStyle.INSTANCE.m8394getNormal_LCdwA());
        FontSynthesis fontSynthesis = spanStyle.getFontSynthesis();
        FontSynthesis fontSynthesisM8395boximpl = FontSynthesis.m8395boximpl(fontSynthesis != null ? fontSynthesis.m8403unboximpl() : FontSynthesis.INSTANCE.m8404getAllGVVA2EU());
        SystemFontFamily fontFamily = spanStyle.getFontFamily();
        if (fontFamily == null) {
            fontFamily = FontFamily.INSTANCE.getDefault();
        }
        FontFamily fontFamily2 = fontFamily;
        String fontFeatureSettings = spanStyle.getFontFeatureSettings();
        if (fontFeatureSettings == null) {
            fontFeatureSettings = "";
        }
        String str = fontFeatureSettings;
        if (TextUnit.m9022getRawTypeimpl(spanStyle.getLetterSpacing()) == 0) {
            letterSpacing = DefaultLetterSpacing;
        } else {
            letterSpacing = spanStyle.getLetterSpacing();
        }
        long j = letterSpacing;
        BaselineShift baselineShift = spanStyle.getBaselineShift();
        float fM8576unboximpl = baselineShift != null ? baselineShift.m8576unboximpl() : BaselineShift.INSTANCE.m8581getNoney9eOQZs();
        if (Float.isNaN(fM8576unboximpl)) {
            fM8576unboximpl = BaselineShift.INSTANCE.m8581getNoney9eOQZs();
        }
        BaselineShift baselineShiftM8570boximpl = BaselineShift.m8570boximpl(fM8576unboximpl);
        TextGeometricTransform textGeometricTransform = spanStyle.getTextGeometricTransform();
        if (textGeometricTransform == null) {
            textGeometricTransform = TextGeometricTransform.INSTANCE.getNone$ui_text();
        }
        TextGeometricTransform textGeometricTransform2 = textGeometricTransform;
        LocaleList localeList = spanStyle.getLocaleList();
        if (localeList == null) {
            localeList = LocaleList.INSTANCE.getCurrent();
        }
        LocaleList localeList2 = localeList;
        long background = spanStyle.getBackground();
        if (background == 16) {
            background = DefaultBackgroundColor;
        }
        long j2 = background;
        TextDecoration textDecoration = spanStyle.getTextDecoration();
        if (textDecoration == null) {
            textDecoration = TextDecoration.INSTANCE.getNone();
        }
        TextDecoration textDecoration2 = textDecoration;
        Shadow shadow = spanStyle.getShadow();
        if (shadow == null) {
            shadow = Shadow.INSTANCE.getNone();
        }
        Shadow shadow2 = shadow;
        PlatformSpanStyle platformStyle = spanStyle.getPlatformStyle();
        Fill drawStyle = spanStyle.getDrawStyle();
        if (drawStyle == null) {
            drawStyle = Fill.INSTANCE;
        }
        return new SpanStyle(textForegroundStyleTakeOrElse, fontSize, fontWeight2, fontStyleM8384boximpl, fontSynthesisM8395boximpl, fontFamily2, str, j, baselineShiftM8570boximpl, textGeometricTransform2, localeList2, j2, textDecoration2, shadow2, platformStyle, drawStyle, (DefaultConstructorMarker) null);
    }

    private static final PlatformSpanStyle mergePlatformStyle(SpanStyle spanStyle, PlatformSpanStyle platformSpanStyle) {
        if (spanStyle.getPlatformStyle() == null) {
            return platformSpanStyle;
        }
        if (platformSpanStyle == null) {
            return spanStyle.getPlatformStyle();
        }
        return spanStyle.getPlatformStyle().merge(platformSpanStyle);
    }

    /* JADX INFO: renamed from: lerpTextUnitInheritable-C3pnCVY, reason: not valid java name */
    public static final long m8219lerpTextUnitInheritableC3pnCVY(long j, long j2, float f2) {
        if (TextUnit.m9022getRawTypeimpl(j) == 0 || TextUnit.m9022getRawTypeimpl(j2) == 0) {
            return ((TextUnit) lerpDiscrete(TextUnit.m9014boximpl(j), TextUnit.m9014boximpl(j2), f2)).getPackedValue();
        }
        return TextUnitKt.m9044lerpC3pnCVY(j, j2, f2);
    }

    /* JADX WARN: Removed duplicated region for block: B:100:0x017f  */
    /* JADX WARN: Removed duplicated region for block: B:101:0x0184  */
    /* JADX WARN: Removed duplicated region for block: B:103:0x0188  */
    /* JADX WARN: Removed duplicated region for block: B:106:0x0194  */
    /* JADX WARN: Removed duplicated region for block: B:107:0x0199  */
    /* JADX WARN: Removed duplicated region for block: B:109:0x019d  */
    /* JADX WARN: Removed duplicated region for block: B:111:0x01a3  */
    /* JADX WARN: Removed duplicated region for block: B:113:0x01a9  */
    /* JADX WARN: Removed duplicated region for block: B:114:0x01ae  */
    /* JADX WARN: Removed duplicated region for block: B:118:0x01b5  */
    /* JADX WARN: Removed duplicated region for block: B:11:0x003a A[PHI: r11
      0x003a: PHI (r11v7 long) = 
      (r11v1 long)
      (r11v1 long)
      (r11v1 long)
      (r11v1 long)
      (r11v1 long)
      (r11v1 long)
      (r11v1 long)
      (r11v1 long)
      (r11v1 long)
      (r11v1 long)
      (r11v1 long)
      (r11v8 long)
     binds: [B:42:0x00ac, B:54:0x00de, B:51:0x00d2, B:48:0x00c6, B:45:0x00ba, B:40:0x009e, B:35:0x008f, B:28:0x0076, B:25:0x006e, B:22:0x0062, B:19:0x0056, B:9:0x0037] A[DONT_GENERATE, DONT_INLINE]] */
    /* JADX WARN: Removed duplicated region for block: B:120:0x01bb  */
    /* JADX WARN: Removed duplicated region for block: B:122:0x01c1  */
    /* JADX WARN: Removed duplicated region for block: B:125:0x01cf  */
    /* JADX WARN: Removed duplicated region for block: B:126:0x01d4  */
    /* JADX WARN: Removed duplicated region for block: B:84:0x013f  */
    /* JADX WARN: Removed duplicated region for block: B:85:0x0148  */
    /* JADX WARN: Removed duplicated region for block: B:88:0x0158  */
    /* JADX WARN: Removed duplicated region for block: B:89:0x015d  */
    /* JADX WARN: Removed duplicated region for block: B:92:0x0167  */
    /* JADX WARN: Removed duplicated region for block: B:94:0x016d  */
    /* JADX WARN: Removed duplicated region for block: B:95:0x0172  */
    /* JADX WARN: Removed duplicated region for block: B:97:0x0176  */
    /* JADX WARN: Removed duplicated region for block: B:98:0x017b  */
    /* JADX INFO: renamed from: fastMerge-dSHsh3o, reason: not valid java name */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public static final androidx.compose.ui.text.SpanStyle m8218fastMergedSHsh3o(androidx.compose.ui.text.SpanStyle r23, long r24, androidx.compose.ui.graphics.Brush r26, float r27, long r28, androidx.compose.ui.text.font.FontWeight r30, androidx.compose.ui.text.font.FontStyle r31, androidx.compose.ui.text.font.FontSynthesis r32, androidx.compose.ui.text.font.FontFamily r33, java.lang.String r34, long r35, androidx.compose.ui.text.style.BaselineShift r37, androidx.compose.ui.text.style.TextGeometricTransform r38, androidx.compose.ui.text.intl.LocaleList r39, long r40, androidx.compose.ui.text.style.TextDecoration r42, androidx.compose.ui.graphics.Shadow r43, androidx.compose.ui.text.PlatformSpanStyle r44, androidx.compose.ui.graphics.drawscope.DrawStyle r45) {
        /*
            Method dump skipped, instruction units count: 513
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.compose.ui.text.SpanStyleKt.m8218fastMergedSHsh3o(androidx.compose.ui.text.SpanStyle, long, androidx.compose.ui.graphics.Brush, float, long, androidx.compose.ui.text.font.FontWeight, androidx.compose.ui.text.font.FontStyle, androidx.compose.ui.text.font.FontSynthesis, androidx.compose.ui.text.font.FontFamily, java.lang.String, long, androidx.compose.ui.text.style.BaselineShift, androidx.compose.ui.text.style.TextGeometricTransform, androidx.compose.ui.text.intl.LocaleList, long, androidx.compose.ui.text.style.TextDecoration, androidx.compose.ui.graphics.Shadow, androidx.compose.ui.text.PlatformSpanStyle, androidx.compose.ui.graphics.drawscope.DrawStyle):androidx.compose.ui.text.SpanStyle");
    }
}
