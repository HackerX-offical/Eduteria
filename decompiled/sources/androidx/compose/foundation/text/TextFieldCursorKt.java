package androidx.compose.foundation.text;

import androidx.compose.foundation.text.input.internal.CursorAnimationState;
import androidx.compose.runtime.Composer;
import androidx.compose.runtime.ComposerKt;
import androidx.compose.runtime.EffectsKt;
import androidx.compose.runtime.ProvidableCompositionLocal;
import androidx.compose.ui.ComposedModifierKt;
import androidx.compose.ui.Modifier;
import androidx.compose.ui.draw.DrawModifierKt;
import androidx.compose.ui.geometry.Offset;
import androidx.compose.ui.geometry.Rect;
import androidx.compose.ui.graphics.Brush;
import androidx.compose.ui.graphics.SolidColor;
import androidx.compose.ui.graphics.drawscope.ContentDrawScope;
import androidx.compose.ui.graphics.drawscope.DrawScope;
import androidx.compose.ui.platform.CompositionLocalsKt;
import androidx.compose.ui.platform.WindowInfo;
import androidx.compose.ui.text.AnnotatedString;
import androidx.compose.ui.text.TextLayoutResult;
import androidx.compose.ui.text.TextRange;
import androidx.compose.ui.text.input.OffsetMapping;
import androidx.compose.ui.text.input.TextFieldValue;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.functions.Function3;
import kotlin.ranges.RangesKt;
import org.jivesoftware.smack.sm.packet.StreamManagement;

/* JADX INFO: compiled from: TextFieldCursor.kt */
/* JADX INFO: loaded from: classes.dex */
@Metadata(d1 = {"\u0000&\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\u001a4\u0010\u0000\u001a\u00020\u0001*\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u00072\u0006\u0010\b\u001a\u00020\t2\u0006\u0010\n\u001a\u00020\u000bH\u0000¨\u0006\f"}, d2 = {"cursor", "Landroidx/compose/ui/Modifier;", "state", "Landroidx/compose/foundation/text/LegacyTextFieldState;", "value", "Landroidx/compose/ui/text/input/TextFieldValue;", "offsetMapping", "Landroidx/compose/ui/text/input/OffsetMapping;", "cursorBrush", "Landroidx/compose/ui/graphics/Brush;", StreamManagement.Enabled.ELEMENT, "", "foundation"}, k = 2, mv = {2, 1, 0}, xi = 48)
public final class TextFieldCursorKt {
    public static final Modifier cursor(Modifier modifier, final LegacyTextFieldState legacyTextFieldState, final TextFieldValue textFieldValue, final OffsetMapping offsetMapping, final Brush brush, boolean z) {
        return z ? ComposedModifierKt.composed$default(modifier, null, new Function3() { // from class: androidx.compose.foundation.text.TextFieldCursorKt$$ExternalSyntheticLambda1
            @Override // kotlin.jvm.functions.Function3
            public final Object invoke(Object obj, Object obj2, Object obj3) {
                return TextFieldCursorKt.cursor$lambda$0(brush, legacyTextFieldState, textFieldValue, offsetMapping, (Modifier) obj, (Composer) obj2, ((Integer) obj3).intValue());
            }
        }, 1, null) : modifier;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Modifier cursor$lambda$0(final Brush brush, final LegacyTextFieldState legacyTextFieldState, final TextFieldValue textFieldValue, final OffsetMapping offsetMapping, Modifier modifier, Composer composer, int i) {
        Modifier.Companion companionDrawWithContent;
        composer.startReplaceGroup(-84507373);
        ComposerKt.sourceInformation(composer, "C46@1735L7,47@1777L63,54@2290L7:TextFieldCursor.kt#423gt5");
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventStart(-84507373, i, -1, "androidx.compose.foundation.text.cursor.<anonymous> (TextFieldCursor.kt:46)");
        }
        ProvidableCompositionLocal<Boolean> localCursorBlinkEnabled = CompositionLocalsKt.getLocalCursorBlinkEnabled();
        ComposerKt.sourceInformationMarkerStart(composer, 2023513938, "CC(<get-current>):CompositionLocal.kt#9igjgp");
        Object objConsume = composer.consume(localCursorBlinkEnabled);
        ComposerKt.sourceInformationMarkerEnd(composer);
        boolean zBooleanValue = ((Boolean) objConsume).booleanValue();
        ComposerKt.sourceInformationMarkerStart(composer, 392796434, "CC(remember):TextFieldCursor.kt#9igjgp");
        boolean zChanged = composer.changed(zBooleanValue);
        Object objRememberedValue = composer.rememberedValue();
        if (zChanged || objRememberedValue == Composer.INSTANCE.getEmpty()) {
            objRememberedValue = new CursorAnimationState(zBooleanValue);
            composer.updateRememberedValue(objRememberedValue);
        }
        final CursorAnimationState cursorAnimationState = (CursorAnimationState) objRememberedValue;
        ComposerKt.sourceInformationMarkerEnd(composer);
        boolean z = ((brush instanceof SolidColor) && ((SolidColor) brush).getValue() == 16) ? false : true;
        ProvidableCompositionLocal<WindowInfo> localWindowInfo = CompositionLocalsKt.getLocalWindowInfo();
        ComposerKt.sourceInformationMarkerStart(composer, 2023513938, "CC(<get-current>):CompositionLocal.kt#9igjgp");
        Object objConsume2 = composer.consume(localWindowInfo);
        ComposerKt.sourceInformationMarkerEnd(composer);
        if (((WindowInfo) objConsume2).isWindowFocused() && legacyTextFieldState.getHasFocus() && TextRange.m8267getCollapsedimpl(textFieldValue.getSelection()) && z) {
            composer.startReplaceGroup(-707487962);
            ComposerKt.sourceInformation(composer, "58@2517L81,58@2462L136,61@2631L1888");
            AnnotatedString annotatedString = textFieldValue.getAnnotatedString();
            TextRange textRangeM8261boximpl = TextRange.m8261boximpl(textFieldValue.getSelection());
            ComposerKt.sourceInformationMarkerStart(composer, 392820132, "CC(remember):TextFieldCursor.kt#9igjgp");
            boolean zChangedInstance = composer.changedInstance(cursorAnimationState);
            Object objRememberedValue2 = composer.rememberedValue();
            if (zChangedInstance || objRememberedValue2 == Composer.INSTANCE.getEmpty()) {
                objRememberedValue2 = (Function2) new TextFieldCursorKt$cursor$1$1$1(cursorAnimationState, null);
                composer.updateRememberedValue(objRememberedValue2);
            }
            ComposerKt.sourceInformationMarkerEnd(composer);
            EffectsKt.LaunchedEffect(annotatedString, textRangeM8261boximpl, (Function2) objRememberedValue2, composer, 0);
            ComposerKt.sourceInformationMarkerStart(composer, 392825587, "CC(remember):TextFieldCursor.kt#9igjgp");
            boolean zChangedInstance2 = composer.changedInstance(cursorAnimationState) | composer.changedInstance(offsetMapping) | composer.changed(textFieldValue) | composer.changedInstance(legacyTextFieldState) | composer.changed(brush);
            Object objRememberedValue3 = composer.rememberedValue();
            if (zChangedInstance2 || objRememberedValue3 == Composer.INSTANCE.getEmpty()) {
                Object obj = new Function1() { // from class: androidx.compose.foundation.text.TextFieldCursorKt$$ExternalSyntheticLambda0
                    @Override // kotlin.jvm.functions.Function1
                    public final Object invoke(Object obj2) {
                        return TextFieldCursorKt.cursor$lambda$0$2$0(cursorAnimationState, offsetMapping, textFieldValue, legacyTextFieldState, brush, (ContentDrawScope) obj2);
                    }
                };
                composer.updateRememberedValue(obj);
                objRememberedValue3 = obj;
            }
            ComposerKt.sourceInformationMarkerEnd(composer);
            companionDrawWithContent = DrawModifierKt.drawWithContent(modifier, (Function1) objRememberedValue3);
            composer.endReplaceGroup();
        } else {
            composer.startReplaceGroup(-705473241);
            composer.endReplaceGroup();
            companionDrawWithContent = Modifier.INSTANCE;
        }
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventEnd();
        }
        composer.endReplaceGroup();
        return companionDrawWithContent;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit cursor$lambda$0$2$0(CursorAnimationState cursorAnimationState, OffsetMapping offsetMapping, TextFieldValue textFieldValue, LegacyTextFieldState legacyTextFieldState, Brush brush, ContentDrawScope contentDrawScope) {
        Rect rect;
        float fRint;
        TextLayoutResult value;
        contentDrawScope.drawContent();
        float cursorAlpha = cursorAnimationState.getCursorAlpha();
        if (cursorAlpha != 0.0f) {
            int iOriginalToTransformed = offsetMapping.originalToTransformed(TextRange.m8273getStartimpl(textFieldValue.getSelection()));
            TextLayoutResultProxy layoutResult = legacyTextFieldState.getLayoutResult();
            if (layoutResult == null || (value = layoutResult.getValue()) == null || (rect = value.getCursorRect(iOriginalToTransformed)) == null) {
                rect = new Rect(0.0f, 0.0f, 0.0f, 0.0f);
            }
            float fCoerceAtLeast = RangesKt.coerceAtLeast((float) Math.floor(contentDrawScope.mo488toPx0680j_4(TextFieldCursor_androidKt.getDefaultCursorThickness())), 1.0f);
            float f2 = fCoerceAtLeast / 2;
            float fCoerceAtLeast2 = RangesKt.coerceAtLeast(RangesKt.coerceAtMost(rect.getLeft() + f2, Float.intBitsToFloat((int) (contentDrawScope.mo6549getSizeNHjbRc() >> 32)) - f2), f2);
            if (((int) fCoerceAtLeast) % 2 == 1) {
                fRint = ((float) Math.floor(fCoerceAtLeast2)) + 0.5f;
            } else {
                fRint = (float) Math.rint(fCoerceAtLeast2);
            }
            DrawScope.m6534drawLine1RTmtNc$default(contentDrawScope, brush, Offset.m5715constructorimpl((((long) Float.floatToRawIntBits(rect.getTop())) & 4294967295L) | (((long) Float.floatToRawIntBits(fRint)) << 32)), Offset.m5715constructorimpl((((long) Float.floatToRawIntBits(rect.getBottom())) & 4294967295L) | (((long) Float.floatToRawIntBits(fRint)) << 32)), fCoerceAtLeast, 0, null, cursorAlpha, null, 0, 432, null);
        }
        return Unit.INSTANCE;
    }
}
