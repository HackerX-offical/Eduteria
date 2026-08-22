package androidx.compose.foundation.text;

import androidx.compose.foundation.ComposeFoundationFlags;
import androidx.compose.foundation.internal.InlineClassHelperKt;
import androidx.compose.foundation.layout.SizeKt;
import androidx.compose.runtime.Composer;
import androidx.compose.runtime.ComposerKt;
import androidx.compose.runtime.ProvidableCompositionLocal;
import androidx.compose.runtime.State;
import androidx.compose.ui.ComposedModifierKt;
import androidx.compose.ui.Modifier;
import androidx.compose.ui.platform.CompositionLocalsKt;
import androidx.compose.ui.platform.InspectableValueKt;
import androidx.compose.ui.platform.InspectorInfo;
import androidx.compose.ui.text.TextStyle;
import androidx.compose.ui.text.TextStyleKt;
import androidx.compose.ui.text.font.FontFamily;
import androidx.compose.ui.text.font.FontStyle;
import androidx.compose.ui.text.font.FontSynthesis;
import androidx.compose.ui.text.font.FontWeight;
import androidx.compose.ui.unit.Density;
import androidx.compose.ui.unit.Dp;
import androidx.compose.ui.unit.LayoutDirection;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function3;

/* JADX INFO: compiled from: HeightInLinesModifier.kt */
/* JADX INFO: loaded from: classes.dex */
@Metadata(d1 = {"\u0000\"\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0010\u0000\u001a(\u0010\u0002\u001a\u00020\u0003*\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u00052\b\b\u0002\u0010\u0006\u001a\u00020\u00012\b\b\u0002\u0010\u0007\u001a\u00020\u0001H\u0000\u001a(\u0010\b\u001a\u00020\u0003*\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u00052\b\b\u0002\u0010\u0006\u001a\u00020\u00012\b\b\u0002\u0010\u0007\u001a\u00020\u0001H\u0000\u001a\u0018\u0010\t\u001a\u00020\n2\u0006\u0010\u0006\u001a\u00020\u00012\u0006\u0010\u0007\u001a\u00020\u0001H\u0000\"\u000e\u0010\u0000\u001a\u00020\u0001X\u0080T¢\u0006\u0002\n\u0000¨\u0006\u000b²\u0006\n\u0010\f\u001a\u00020\rX\u008a\u0084\u0002"}, d2 = {"DefaultMinLines", "", "heightInLines", "Landroidx/compose/ui/Modifier;", "textStyle", "Landroidx/compose/ui/text/TextStyle;", "minLines", "maxLines", "legacyHeightInLines", "validateMinMaxLines", "", "foundation", "typeface", ""}, k = 2, mv = {2, 1, 0}, xi = 48)
public final class HeightInLinesModifierKt {
    public static final int DefaultMinLines = 1;

    public static /* synthetic */ Modifier heightInLines$default(Modifier modifier, TextStyle textStyle, int i, int i2, int i3, Object obj) {
        if ((i3 & 2) != 0) {
            i = 1;
        }
        if ((i3 & 4) != 0) {
            i2 = Integer.MAX_VALUE;
        }
        return heightInLines(modifier, textStyle, i, i2);
    }

    public static final Modifier heightInLines(Modifier modifier, TextStyle textStyle, int i, int i2) {
        validateMinMaxLines(i, i2);
        if (i == 1 && i2 == Integer.MAX_VALUE) {
            return modifier;
        }
        if (ComposeFoundationFlags.isBasicTextFieldMinSizeOptimizationEnabled) {
            return modifier.then(new HeightInLinesElement(textStyle, i, i2));
        }
        return legacyHeightInLines(modifier, textStyle, i, i2);
    }

    public static /* synthetic */ Modifier legacyHeightInLines$default(Modifier modifier, TextStyle textStyle, int i, int i2, int i3, Object obj) {
        if ((i3 & 2) != 0) {
            i = 1;
        }
        if ((i3 & 4) != 0) {
            i2 = Integer.MAX_VALUE;
        }
        return legacyHeightInLines(modifier, textStyle, i, i2);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Modifier legacyHeightInLines$lambda$1(TextStyle textStyle, int i, int i2, Modifier modifier, Composer composer, int i3) {
        long j;
        composer.startReplaceGroup(595899793);
        ComposerKt.sourceInformation(composer, "C297@10617L7,298@10682L7,299@10741L7,302@10790L84,304@10911L369,314@11324L430,326@11802L500:HeightInLinesModifier.kt#423gt5");
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventStart(595899793, i3, -1, "androidx.compose.foundation.text.legacyHeightInLines.<anonymous> (HeightInLinesModifier.kt:297)");
        }
        ProvidableCompositionLocal<Density> localDensity = CompositionLocalsKt.getLocalDensity();
        ComposerKt.sourceInformationMarkerStart(composer, 2023513938, "CC(<get-current>):CompositionLocal.kt#9igjgp");
        Object objConsume = composer.consume(localDensity);
        ComposerKt.sourceInformationMarkerEnd(composer);
        Density density = (Density) objConsume;
        ProvidableCompositionLocal<FontFamily.Resolver> localFontFamilyResolver = CompositionLocalsKt.getLocalFontFamilyResolver();
        ComposerKt.sourceInformationMarkerStart(composer, 2023513938, "CC(<get-current>):CompositionLocal.kt#9igjgp");
        Object objConsume2 = composer.consume(localFontFamilyResolver);
        ComposerKt.sourceInformationMarkerEnd(composer);
        FontFamily.Resolver resolver = (FontFamily.Resolver) objConsume2;
        ProvidableCompositionLocal<LayoutDirection> localLayoutDirection = CompositionLocalsKt.getLocalLayoutDirection();
        ComposerKt.sourceInformationMarkerStart(composer, 2023513938, "CC(<get-current>):CompositionLocal.kt#9igjgp");
        Object objConsume3 = composer.consume(localLayoutDirection);
        ComposerKt.sourceInformationMarkerEnd(composer);
        LayoutDirection layoutDirection = (LayoutDirection) objConsume3;
        ComposerKt.sourceInformationMarkerStart(composer, 1429057509, "CC(remember):HeightInLinesModifier.kt#9igjgp");
        LayoutDirection layoutDirection2 = layoutDirection;
        boolean zChanged = composer.changed(textStyle) | composer.changed(layoutDirection2.ordinal());
        Object objRememberedValue = composer.rememberedValue();
        if (zChanged || objRememberedValue == Composer.INSTANCE.getEmpty()) {
            objRememberedValue = TextStyleKt.resolveDefaults(textStyle, layoutDirection);
            composer.updateRememberedValue(objRememberedValue);
        }
        TextStyle textStyle2 = (TextStyle) objRememberedValue;
        ComposerKt.sourceInformationMarkerEnd(composer);
        ComposerKt.sourceInformationMarkerStart(composer, 1429061666, "CC(remember):HeightInLinesModifier.kt#9igjgp");
        boolean zChanged2 = composer.changed(resolver) | composer.changed(textStyle2);
        Object objRememberedValue2 = composer.rememberedValue();
        if (zChanged2 || objRememberedValue2 == Composer.INSTANCE.getEmpty()) {
            FontFamily fontFamily = textStyle2.getFontFamily();
            FontWeight fontWeight = textStyle2.getFontWeight();
            if (fontWeight == null) {
                fontWeight = FontWeight.INSTANCE.getNormal();
            }
            FontStyle fontStyleM8305getFontStyle4Lr2A7w = textStyle2.m8305getFontStyle4Lr2A7w();
            int iM8390unboximpl = fontStyleM8305getFontStyle4Lr2A7w != null ? fontStyleM8305getFontStyle4Lr2A7w.m8390unboximpl() : FontStyle.INSTANCE.m8394getNormal_LCdwA();
            FontSynthesis fontSynthesisM8306getFontSynthesisZQGJjVo = textStyle2.m8306getFontSynthesisZQGJjVo();
            objRememberedValue2 = resolver.mo8359resolveDPcqOEQ(fontFamily, fontWeight, iM8390unboximpl, fontSynthesisM8306getFontSynthesisZQGJjVo != null ? fontSynthesisM8306getFontSynthesisZQGJjVo.m8403unboximpl() : FontSynthesis.INSTANCE.m8404getAllGVVA2EU());
            composer.updateRememberedValue(objRememberedValue2);
        }
        State state = (State) objRememberedValue2;
        ComposerKt.sourceInformationMarkerEnd(composer);
        Object value = state.getValue();
        ComposerKt.sourceInformationMarkerStart(composer, 1429074943, "CC(remember):HeightInLinesModifier.kt#9igjgp");
        boolean zChanged3 = composer.changed(value) | composer.changed(density) | composer.changed(resolver) | composer.changed(textStyle) | composer.changed(layoutDirection2.ordinal());
        Object objRememberedValue3 = composer.rememberedValue();
        if (zChanged3 || objRememberedValue3 == Composer.INSTANCE.getEmpty()) {
            j = 4294967295L;
            objRememberedValue3 = Integer.valueOf((int) (TextFieldDelegateKt.computeSizeForDefaultText(textStyle2, density, resolver, TextFieldDelegateKt.getEmptyTextReplacement(), 1) & 4294967295L));
            composer.updateRememberedValue(objRememberedValue3);
        } else {
            j = 4294967295L;
        }
        int iIntValue = ((Number) objRememberedValue3).intValue();
        ComposerKt.sourceInformationMarkerEnd(composer);
        Object value2 = state.getValue();
        ComposerKt.sourceInformationMarkerStart(composer, 1429090309, "CC(remember):HeightInLinesModifier.kt#9igjgp");
        boolean zChanged4 = composer.changed(textStyle) | composer.changed(density) | composer.changed(resolver) | composer.changed(layoutDirection2.ordinal()) | composer.changed(value2);
        Object objRememberedValue4 = composer.rememberedValue();
        if (zChanged4 || objRememberedValue4 == Composer.INSTANCE.getEmpty()) {
            objRememberedValue4 = Integer.valueOf((int) (TextFieldDelegateKt.computeSizeForDefaultText(textStyle2, density, resolver, TextFieldDelegateKt.getEmptyTextReplacement() + '\n' + TextFieldDelegateKt.getEmptyTextReplacement(), 2) & j));
            composer.updateRememberedValue(objRememberedValue4);
        }
        int iIntValue2 = ((Number) objRememberedValue4).intValue();
        ComposerKt.sourceInformationMarkerEnd(composer);
        int i4 = iIntValue2 - iIntValue;
        Integer numValueOf = i == 1 ? null : Integer.valueOf(((i - 1) * i4) + iIntValue);
        Integer numValueOf2 = i2 != Integer.MAX_VALUE ? Integer.valueOf(iIntValue + (i4 * (i2 - 1))) : null;
        Modifier modifierM1208heightInVpY3zN4 = SizeKt.m1208heightInVpY3zN4(Modifier.INSTANCE, numValueOf != null ? density.mo485toDpu2uoSUM(numValueOf.intValue()) : Dp.INSTANCE.m8850getUnspecifiedD9Ej5fM(), numValueOf2 != null ? density.mo485toDpu2uoSUM(numValueOf2.intValue()) : Dp.INSTANCE.m8850getUnspecifiedD9Ej5fM());
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventEnd();
        }
        composer.endReplaceGroup();
        return modifierM1208heightInVpY3zN4;
    }

    public static final void validateMinMaxLines(int i, int i2) {
        if (!(i > 0 && i2 > 0)) {
            InlineClassHelperKt.throwIllegalArgumentException("both minLines " + i + " and maxLines " + i2 + " must be greater than zero");
        }
        if (i <= i2) {
            return;
        }
        InlineClassHelperKt.throwIllegalArgumentException("minLines " + i + " must be less than or equal to maxLines " + i2);
    }

    public static final Modifier legacyHeightInLines(Modifier modifier, final TextStyle textStyle, final int i, final int i2) {
        return ComposedModifierKt.composed(modifier, InspectableValueKt.isDebugInspectorInfoEnabled() ? new Function1<InspectorInfo, Unit>() { // from class: androidx.compose.foundation.text.HeightInLinesModifierKt$legacyHeightInLines$$inlined$debugInspectorInfo$1
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            {
                super(1);
            }

            @Override // kotlin.jvm.functions.Function1
            public /* bridge */ /* synthetic */ Unit invoke(InspectorInfo inspectorInfo) {
                invoke2(inspectorInfo);
                return Unit.INSTANCE;
            }

            /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
            public final void invoke2(InspectorInfo inspectorInfo) {
                inspectorInfo.setName("heightInLines");
                inspectorInfo.getProperties().set("minLines", Integer.valueOf(i));
                inspectorInfo.getProperties().set("maxLines", Integer.valueOf(i2));
                inspectorInfo.getProperties().set("textStyle", textStyle);
            }
        } : InspectableValueKt.getNoInspectorInfo(), new Function3() { // from class: androidx.compose.foundation.text.HeightInLinesModifierKt$$ExternalSyntheticLambda0
            @Override // kotlin.jvm.functions.Function3
            public final Object invoke(Object obj, Object obj2, Object obj3) {
                return HeightInLinesModifierKt.legacyHeightInLines$lambda$1(textStyle, i, i2, (Modifier) obj, (Composer) obj2, ((Integer) obj3).intValue());
            }
        });
    }
}
