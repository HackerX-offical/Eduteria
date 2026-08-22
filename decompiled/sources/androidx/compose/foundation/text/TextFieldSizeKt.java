package androidx.compose.foundation.text;

import androidx.compose.foundation.ComposeFoundationFlags;
import androidx.compose.runtime.Composer;
import androidx.compose.runtime.ComposerKt;
import androidx.compose.runtime.ProvidableCompositionLocal;
import androidx.compose.runtime.State;
import androidx.compose.ui.ComposedModifierKt;
import androidx.compose.ui.Modifier;
import androidx.compose.ui.layout.LayoutModifierKt;
import androidx.compose.ui.layout.Measurable;
import androidx.compose.ui.layout.MeasureResult;
import androidx.compose.ui.layout.MeasureScope;
import androidx.compose.ui.layout.Placeable;
import androidx.compose.ui.platform.CompositionLocalsKt;
import androidx.compose.ui.text.TextStyle;
import androidx.compose.ui.text.TextStyleKt;
import androidx.compose.ui.text.font.FontFamily;
import androidx.compose.ui.text.font.FontStyle;
import androidx.compose.ui.text.font.FontSynthesis;
import androidx.compose.ui.text.font.FontWeight;
import androidx.compose.ui.unit.Constraints;
import androidx.compose.ui.unit.Density;
import androidx.compose.ui.unit.LayoutDirection;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function3;
import kotlin.ranges.RangesKt;

/* JADX INFO: compiled from: TextFieldSize.kt */
/* JADX INFO: loaded from: classes.dex */
@Metadata(d1 = {"\u0000\u0014\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0000\u001a\u0014\u0010\u0000\u001a\u00020\u0001*\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u0003H\u0000\u001a\u0014\u0010\u0004\u001a\u00020\u0001*\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u0003H\u0000¨\u0006\u0005²\u0006\n\u0010\u0006\u001a\u00020\u0007X\u008a\u0084\u0002"}, d2 = {"textFieldMinSize", "Landroidx/compose/ui/Modifier;", "style", "Landroidx/compose/ui/text/TextStyle;", "legacyTextFieldMinSize", "foundation", "typeface", ""}, k = 2, mv = {2, 1, 0}, xi = 48)
public final class TextFieldSizeKt {
    public static final Modifier textFieldMinSize(Modifier modifier, TextStyle textStyle) {
        if (ComposeFoundationFlags.isBasicTextFieldMinSizeOptimizationEnabled) {
            return modifier.then(new TextFieldSizeElement(textStyle));
        }
        return legacyTextFieldMinSize(modifier, textStyle);
    }

    public static final Modifier legacyTextFieldMinSize(Modifier modifier, final TextStyle textStyle) {
        return ComposedModifierKt.composed$default(modifier, null, new Function3() { // from class: androidx.compose.foundation.text.TextFieldSizeKt$$ExternalSyntheticLambda2
            @Override // kotlin.jvm.functions.Function3
            public final Object invoke(Object obj, Object obj2, Object obj3) {
                return TextFieldSizeKt.legacyTextFieldMinSize$lambda$0(textStyle, (Modifier) obj, (Composer) obj2, ((Integer) obj3).intValue());
            }
        }, 1, null);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Modifier legacyTextFieldMinSize$lambda$0(TextStyle textStyle, Modifier modifier, Composer composer, int i) {
        composer.startReplaceGroup(-390200690);
        ComposerKt.sourceInformation(composer, "C163@6412L7,164@6473L7,165@6528L7,167@6561L76,169@6666L341,178@7032L107,184@7257L488:TextFieldSize.kt#423gt5");
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventStart(-390200690, i, -1, "androidx.compose.foundation.text.legacyTextFieldMinSize.<anonymous> (TextFieldSize.kt:163)");
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
        ComposerKt.sourceInformationMarkerStart(composer, -1320702438, "CC(remember):TextFieldSize.kt#9igjgp");
        boolean zChanged = composer.changed(textStyle) | composer.changed(layoutDirection.ordinal());
        Object objRememberedValue = composer.rememberedValue();
        if (zChanged || objRememberedValue == Composer.INSTANCE.getEmpty()) {
            objRememberedValue = TextStyleKt.resolveDefaults(textStyle, layoutDirection);
            composer.updateRememberedValue(objRememberedValue);
        }
        TextStyle textStyle2 = (TextStyle) objRememberedValue;
        ComposerKt.sourceInformationMarkerEnd(composer);
        ComposerKt.sourceInformationMarkerStart(composer, -1320698813, "CC(remember):TextFieldSize.kt#9igjgp");
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
        ComposerKt.sourceInformationMarkerStart(composer, -1320687335, "CC(remember):TextFieldSize.kt#9igjgp");
        Object objRememberedValue3 = composer.rememberedValue();
        if (objRememberedValue3 == Composer.INSTANCE.getEmpty()) {
            objRememberedValue3 = new LegacyTextFieldSize(layoutDirection, density, resolver, textStyle, state.getValue());
            composer.updateRememberedValue(objRememberedValue3);
        }
        final LegacyTextFieldSize legacyTextFieldSize = (LegacyTextFieldSize) objRememberedValue3;
        ComposerKt.sourceInformationMarkerEnd(composer);
        legacyTextFieldSize.update(layoutDirection, density, resolver, textStyle2, state.getValue());
        Modifier.Companion companion = Modifier.INSTANCE;
        ComposerKt.sourceInformationMarkerStart(composer, -1320679754, "CC(remember):TextFieldSize.kt#9igjgp");
        boolean zChangedInstance = composer.changedInstance(legacyTextFieldSize);
        Object objRememberedValue4 = composer.rememberedValue();
        if (zChangedInstance || objRememberedValue4 == Composer.INSTANCE.getEmpty()) {
            objRememberedValue4 = new Function3() { // from class: androidx.compose.foundation.text.TextFieldSizeKt$$ExternalSyntheticLambda1
                @Override // kotlin.jvm.functions.Function3
                public final Object invoke(Object obj, Object obj2, Object obj3) {
                    return TextFieldSizeKt.legacyTextFieldMinSize$lambda$0$4$0(legacyTextFieldSize, (MeasureScope) obj, (Measurable) obj2, (Constraints) obj3);
                }
            };
            composer.updateRememberedValue(objRememberedValue4);
        }
        ComposerKt.sourceInformationMarkerEnd(composer);
        Modifier modifierLayout = LayoutModifierKt.layout(companion, (Function3) objRememberedValue4);
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventEnd();
        }
        composer.endReplaceGroup();
        return modifierLayout;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final MeasureResult legacyTextFieldMinSize$lambda$0$4$0(LegacyTextFieldSize legacyTextFieldSize, MeasureScope measureScope, Measurable measurable, Constraints constraints) {
        long minSize = legacyTextFieldSize.getMinSize();
        final Placeable placeableMo7445measureBRTryo0 = measurable.mo7445measureBRTryo0(Constraints.m8773copyZbe2FdA$default(constraints.getValue(), RangesKt.coerceIn((int) (minSize >> 32), Constraints.m8785getMinWidthimpl(constraints.getValue()), Constraints.m8783getMaxWidthimpl(constraints.getValue())), 0, RangesKt.coerceIn((int) (minSize & 4294967295L), Constraints.m8784getMinHeightimpl(constraints.getValue()), Constraints.m8782getMaxHeightimpl(constraints.getValue())), 0, 10, null));
        return MeasureScope.layout$default(measureScope, placeableMo7445measureBRTryo0.getWidth(), placeableMo7445measureBRTryo0.getHeight(), null, new Function1() { // from class: androidx.compose.foundation.text.TextFieldSizeKt$$ExternalSyntheticLambda0
            @Override // kotlin.jvm.functions.Function1
            public final Object invoke(Object obj) {
                return TextFieldSizeKt.legacyTextFieldMinSize$lambda$0$4$0$0(placeableMo7445measureBRTryo0, (Placeable.PlacementScope) obj);
            }
        }, 4, null);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit legacyTextFieldMinSize$lambda$0$4$0$0(Placeable placeable, Placeable.PlacementScope placementScope) {
        Placeable.PlacementScope.placeRelative$default(placementScope, placeable, 0, 0, 0.0f, 4, null);
        return Unit.INSTANCE;
    }
}
