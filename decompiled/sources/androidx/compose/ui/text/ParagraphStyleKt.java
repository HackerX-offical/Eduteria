package androidx.compose.ui.text;

import androidx.compose.ui.text.style.Hyphens;
import androidx.compose.ui.text.style.LineBreak;
import androidx.compose.ui.text.style.LineHeightStyle;
import androidx.compose.ui.text.style.TextAlign;
import androidx.compose.ui.text.style.TextDirection;
import androidx.compose.ui.text.style.TextIndent;
import androidx.compose.ui.text.style.TextIndentKt;
import androidx.compose.ui.text.style.TextMotion;
import androidx.compose.ui.unit.LayoutDirection;
import androidx.compose.ui.unit.TextUnit;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: compiled from: ParagraphStyle.kt */
/* JADX INFO: loaded from: classes3.dex */
@Metadata(d1 = {"\u0000X\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0007\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\u001a \u0010\u0003\u001a\u00020\u00042\u0006\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0006\u001a\u00020\u00042\u0006\u0010\u0007\u001a\u00020\bH\u0007\u001a&\u0010\t\u001a\u0004\u0018\u00010\n2\b\u0010\u0005\u001a\u0004\u0018\u00010\n2\b\u0010\u0006\u001a\u0004\u0018\u00010\n2\u0006\u0010\u0007\u001a\u00020\bH\u0002\u001a\u0018\u0010\u000b\u001a\u00020\u00042\u0006\u0010\f\u001a\u00020\u00042\u0006\u0010\r\u001a\u00020\u000eH\u0000\u001ac\u0010\u000f\u001a\u00020\u0004*\u00020\u00042\u0006\u0010\u0010\u001a\u00020\u00112\u0006\u0010\u0012\u001a\u00020\u00132\u0006\u0010\u0014\u001a\u00020\u00012\b\u0010\u0015\u001a\u0004\u0018\u00010\u00162\b\u0010\u0017\u001a\u0004\u0018\u00010\n2\b\u0010\u0018\u001a\u0004\u0018\u00010\u00192\u0006\u0010\u001a\u001a\u00020\u001b2\u0006\u0010\u001c\u001a\u00020\u001d2\b\u0010\u001e\u001a\u0004\u0018\u00010\u001fH\u0000¢\u0006\u0004\b \u0010!\u001a\u0018\u0010\"\u001a\u0004\u0018\u00010\n*\u00020\u00042\b\u0010#\u001a\u0004\u0018\u00010\nH\u0002\"\u0010\u0010\u0000\u001a\u00020\u0001X\u0082\u0004¢\u0006\u0004\n\u0002\u0010\u0002¨\u0006$"}, d2 = {"DefaultLineHeight", "Landroidx/compose/ui/unit/TextUnit;", "J", "lerp", "Landroidx/compose/ui/text/ParagraphStyle;", "start", "stop", "fraction", "", "lerpPlatformStyle", "Landroidx/compose/ui/text/PlatformParagraphStyle;", "resolveParagraphStyleDefaults", "style", "direction", "Landroidx/compose/ui/unit/LayoutDirection;", "fastMerge", "textAlign", "Landroidx/compose/ui/text/style/TextAlign;", "textDirection", "Landroidx/compose/ui/text/style/TextDirection;", "lineHeight", "textIndent", "Landroidx/compose/ui/text/style/TextIndent;", "platformStyle", "lineHeightStyle", "Landroidx/compose/ui/text/style/LineHeightStyle;", "lineBreak", "Landroidx/compose/ui/text/style/LineBreak;", "hyphens", "Landroidx/compose/ui/text/style/Hyphens;", "textMotion", "Landroidx/compose/ui/text/style/TextMotion;", "fastMerge-j5T8yCg", "(Landroidx/compose/ui/text/ParagraphStyle;IIJLandroidx/compose/ui/text/style/TextIndent;Landroidx/compose/ui/text/PlatformParagraphStyle;Landroidx/compose/ui/text/style/LineHeightStyle;IILandroidx/compose/ui/text/style/TextMotion;)Landroidx/compose/ui/text/ParagraphStyle;", "mergePlatformStyle", "other", "ui-text"}, k = 2, mv = {2, 1, 0}, xi = 48)
public final class ParagraphStyleKt {
    private static final long DefaultLineHeight = TextUnit.INSTANCE.m9035getUnspecifiedXSAIIZE();

    public static final ParagraphStyle lerp(ParagraphStyle paragraphStyle, ParagraphStyle paragraphStyle2, float f2) {
        int iM8707unboximpl = ((TextAlign) SpanStyleKt.lerpDiscrete(TextAlign.m8701boximpl(paragraphStyle.getTextAlign()), TextAlign.m8701boximpl(paragraphStyle2.getTextAlign()), f2)).m8707unboximpl();
        int iM8724unboximpl = ((TextDirection) SpanStyleKt.lerpDiscrete(TextDirection.m8718boximpl(paragraphStyle.getTextDirection()), TextDirection.m8718boximpl(paragraphStyle2.getTextDirection()), f2)).m8724unboximpl();
        long jM8219lerpTextUnitInheritableC3pnCVY = SpanStyleKt.m8219lerpTextUnitInheritableC3pnCVY(paragraphStyle.getLineHeight(), paragraphStyle2.getLineHeight(), f2);
        TextIndent textIndent = paragraphStyle.getTextIndent();
        if (textIndent == null) {
            textIndent = TextIndent.INSTANCE.getNone();
        }
        TextIndent textIndent2 = paragraphStyle2.getTextIndent();
        if (textIndent2 == null) {
            textIndent2 = TextIndent.INSTANCE.getNone();
        }
        return new ParagraphStyle(iM8707unboximpl, iM8724unboximpl, jM8219lerpTextUnitInheritableC3pnCVY, TextIndentKt.lerp(textIndent, textIndent2, f2), lerpPlatformStyle(paragraphStyle.getPlatformStyle(), paragraphStyle2.getPlatformStyle(), f2), (LineHeightStyle) SpanStyleKt.lerpDiscrete(paragraphStyle.getLineHeightStyle(), paragraphStyle2.getLineHeightStyle(), f2), ((LineBreak) SpanStyleKt.lerpDiscrete(LineBreak.m8606boximpl(paragraphStyle.getLineBreak()), LineBreak.m8606boximpl(paragraphStyle2.getLineBreak()), f2)).getMask(), ((Hyphens) SpanStyleKt.lerpDiscrete(Hyphens.m8593boximpl(paragraphStyle.getHyphens()), Hyphens.m8593boximpl(paragraphStyle2.getHyphens()), f2)).m8599unboximpl(), (TextMotion) SpanStyleKt.lerpDiscrete(paragraphStyle.getTextMotion(), paragraphStyle2.getTextMotion(), f2), (DefaultConstructorMarker) null);
    }

    private static final PlatformParagraphStyle lerpPlatformStyle(PlatformParagraphStyle platformParagraphStyle, PlatformParagraphStyle platformParagraphStyle2, float f2) {
        if (platformParagraphStyle == null && platformParagraphStyle2 == null) {
            return null;
        }
        if (platformParagraphStyle == null) {
            platformParagraphStyle = PlatformParagraphStyle.INSTANCE.getDefault();
        }
        if (platformParagraphStyle2 == null) {
            platformParagraphStyle2 = PlatformParagraphStyle.INSTANCE.getDefault();
        }
        return AndroidTextStyle_androidKt.lerp(platformParagraphStyle, platformParagraphStyle2, f2);
    }

    public static final ParagraphStyle resolveParagraphStyleDefaults(ParagraphStyle paragraphStyle, LayoutDirection layoutDirection) {
        int iM8713getStarte0LSkKk = TextAlign.m8704equalsimpl0(paragraphStyle.getTextAlign(), TextAlign.INSTANCE.m8714getUnspecifiede0LSkKk()) ? TextAlign.INSTANCE.m8713getStarte0LSkKk() : paragraphStyle.getTextAlign();
        int iM8319resolveTextDirectionIhaHGbI = TextStyleKt.m8319resolveTextDirectionIhaHGbI(layoutDirection, paragraphStyle.getTextDirection());
        long lineHeight = TextUnit.m9022getRawTypeimpl(paragraphStyle.getLineHeight()) == 0 ? DefaultLineHeight : paragraphStyle.getLineHeight();
        TextIndent textIndent = paragraphStyle.getTextIndent();
        if (textIndent == null) {
            textIndent = TextIndent.INSTANCE.getNone();
        }
        TextIndent textIndent2 = textIndent;
        PlatformParagraphStyle platformStyle = paragraphStyle.getPlatformStyle();
        LineHeightStyle lineHeightStyle = paragraphStyle.getLineHeightStyle();
        int iM8625getSimplerAG3T2k = LineBreak.m8612equalsimpl0(paragraphStyle.getLineBreak(), LineBreak.INSTANCE.m8626getUnspecifiedrAG3T2k()) ? LineBreak.INSTANCE.m8625getSimplerAG3T2k() : paragraphStyle.getLineBreak();
        int iM8601getNonevmbZdU8 = Hyphens.m8596equalsimpl0(paragraphStyle.getHyphens(), Hyphens.INSTANCE.m8602getUnspecifiedvmbZdU8()) ? Hyphens.INSTANCE.m8601getNonevmbZdU8() : paragraphStyle.getHyphens();
        TextMotion textMotion = paragraphStyle.getTextMotion();
        if (textMotion == null) {
            textMotion = TextMotion.INSTANCE.getStatic();
        }
        return new ParagraphStyle(iM8713getStarte0LSkKk, iM8319resolveTextDirectionIhaHGbI, lineHeight, textIndent2, platformStyle, lineHeightStyle, iM8625getSimplerAG3T2k, iM8601getNonevmbZdU8, textMotion, (DefaultConstructorMarker) null);
    }

    /* JADX INFO: renamed from: fastMerge-j5T8yCg, reason: not valid java name */
    public static final ParagraphStyle m8155fastMergej5T8yCg(ParagraphStyle paragraphStyle, int i, int i2, long j, TextIndent textIndent, PlatformParagraphStyle platformParagraphStyle, LineHeightStyle lineHeightStyle, int i3, int i4, TextMotion textMotion) {
        long lineHeight;
        int textAlign = i;
        TextIndent textIndent2 = textIndent;
        if (TextAlign.m8704equalsimpl0(textAlign, TextAlign.INSTANCE.m8714getUnspecifiede0LSkKk()) || TextAlign.m8704equalsimpl0(textAlign, paragraphStyle.getTextAlign())) {
            if (TextUnit.m9022getRawTypeimpl(j) == 0) {
                lineHeight = j;
            } else {
                lineHeight = j;
                if (TextUnit.m9021equalsimpl0(lineHeight, paragraphStyle.getLineHeight())) {
                }
            }
            if ((textIndent2 == null || Intrinsics.areEqual(textIndent2, paragraphStyle.getTextIndent())) && ((TextDirection.m8721equalsimpl0(i2, TextDirection.INSTANCE.m8730getUnspecifieds_7Xco()) || TextDirection.m8721equalsimpl0(i2, paragraphStyle.getTextDirection())) && ((platformParagraphStyle == null || Intrinsics.areEqual(platformParagraphStyle, paragraphStyle.getPlatformStyle())) && ((lineHeightStyle == null || Intrinsics.areEqual(lineHeightStyle, paragraphStyle.getLineHeightStyle())) && ((LineBreak.m8612equalsimpl0(i3, LineBreak.INSTANCE.m8626getUnspecifiedrAG3T2k()) || LineBreak.m8612equalsimpl0(i3, paragraphStyle.getLineBreak())) && ((Hyphens.m8596equalsimpl0(i4, Hyphens.INSTANCE.m8602getUnspecifiedvmbZdU8()) || Hyphens.m8596equalsimpl0(i4, paragraphStyle.getHyphens())) && (textMotion == null || Intrinsics.areEqual(textMotion, paragraphStyle.getTextMotion())))))))) {
                return paragraphStyle;
            }
        } else {
            lineHeight = j;
        }
        if (TextUnit.m9022getRawTypeimpl(lineHeight) == 0) {
            lineHeight = paragraphStyle.getLineHeight();
        }
        if (textIndent2 == null) {
            textIndent2 = paragraphStyle.getTextIndent();
        }
        TextIndent textIndent3 = textIndent2;
        if (TextAlign.m8704equalsimpl0(textAlign, TextAlign.INSTANCE.m8714getUnspecifiede0LSkKk())) {
            textAlign = paragraphStyle.getTextAlign();
        }
        return new ParagraphStyle(textAlign, !TextDirection.m8721equalsimpl0(i2, TextDirection.INSTANCE.m8730getUnspecifieds_7Xco()) ? i2 : paragraphStyle.getTextDirection(), lineHeight, textIndent3, mergePlatformStyle(paragraphStyle, platformParagraphStyle), lineHeightStyle == null ? paragraphStyle.getLineHeightStyle() : lineHeightStyle, !LineBreak.m8612equalsimpl0(i3, LineBreak.INSTANCE.m8626getUnspecifiedrAG3T2k()) ? i3 : paragraphStyle.getLineBreak(), !Hyphens.m8596equalsimpl0(i4, Hyphens.INSTANCE.m8602getUnspecifiedvmbZdU8()) ? i4 : paragraphStyle.getHyphens(), textMotion == null ? paragraphStyle.getTextMotion() : textMotion, (DefaultConstructorMarker) null);
    }

    private static final PlatformParagraphStyle mergePlatformStyle(ParagraphStyle paragraphStyle, PlatformParagraphStyle platformParagraphStyle) {
        if (paragraphStyle.getPlatformStyle() == null) {
            return platformParagraphStyle;
        }
        if (platformParagraphStyle == null) {
            return paragraphStyle.getPlatformStyle();
        }
        return paragraphStyle.getPlatformStyle().merge(platformParagraphStyle);
    }
}
