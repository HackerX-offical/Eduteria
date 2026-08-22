package androidx.compose.foundation.text;

import androidx.compose.foundation.interaction.MutableInteractionSource;
import androidx.compose.foundation.interaction.PressInteraction;
import androidx.compose.runtime.Composer;
import androidx.compose.runtime.ComposerKt;
import androidx.compose.runtime.DisposableEffectResult;
import androidx.compose.runtime.DisposableEffectScope;
import androidx.compose.runtime.EffectsKt;
import androidx.compose.runtime.MutableState;
import androidx.compose.runtime.SnapshotStateKt;
import androidx.compose.runtime.SnapshotStateKt__SnapshotStateKt;
import androidx.compose.runtime.State;
import androidx.compose.ui.ComposedModifierKt;
import androidx.compose.ui.Modifier;
import androidx.compose.ui.geometry.Offset;
import androidx.compose.ui.input.pointer.PointerInputEventHandler;
import androidx.compose.ui.input.pointer.SuspendingPointerInputFilterKt;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.coroutines.EmptyCoroutineContext;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function3;
import kotlinx.coroutines.CoroutineScope;
import org.jivesoftware.smack.sm.packet.StreamManagement;

/* JADX INFO: compiled from: TextFieldPressGestureFilter.kt */
/* JADX INFO: loaded from: classes.dex */
@Metadata(d1 = {"\u0000\"\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0000\u001a4\u0010\u0000\u001a\u00020\u0001*\u00020\u00012\b\u0010\u0002\u001a\u0004\u0018\u00010\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u00052\u0012\u0010\u0006\u001a\u000e\u0012\u0004\u0012\u00020\b\u0012\u0004\u0012\u00020\t0\u0007H\u0000¨\u0006\n"}, d2 = {"tapPressTextFieldModifier", "Landroidx/compose/ui/Modifier;", "interactionSource", "Landroidx/compose/foundation/interaction/MutableInteractionSource;", StreamManagement.Enabled.ELEMENT, "", "onTap", "Lkotlin/Function1;", "Landroidx/compose/ui/geometry/Offset;", "", "foundation"}, k = 2, mv = {2, 1, 0}, xi = 48)
public final class TextFieldPressGestureFilterKt {
    public static /* synthetic */ Modifier tapPressTextFieldModifier$default(Modifier modifier, MutableInteractionSource mutableInteractionSource, boolean z, Function1 function1, int i, Object obj) {
        if ((i & 2) != 0) {
            z = true;
        }
        return tapPressTextFieldModifier(modifier, mutableInteractionSource, z, function1);
    }

    public static final Modifier tapPressTextFieldModifier(Modifier modifier, final MutableInteractionSource mutableInteractionSource, boolean z, final Function1<? super Offset, Unit> function1) {
        return z ? ComposedModifierKt.composed$default(modifier, null, new Function3() { // from class: androidx.compose.foundation.text.TextFieldPressGestureFilterKt$$ExternalSyntheticLambda0
            @Override // kotlin.jvm.functions.Function3
            public final Object invoke(Object obj, Object obj2, Object obj3) {
                return TextFieldPressGestureFilterKt.tapPressTextFieldModifier$lambda$0(function1, mutableInteractionSource, (Modifier) obj, (Composer) obj2, ((Integer) obj3).intValue());
            }
        }, 1, null) : modifier;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Modifier tapPressTextFieldModifier$lambda$0(Function1 function1, final MutableInteractionSource mutableInteractionSource, Modifier modifier, Composer composer, int i) {
        composer.startReplaceGroup(-102778667);
        ComposerKt.sourceInformation(composer, "C40@1628L24,41@1690L58,42@1778L27,43@1854L343,43@1818L379,52@2251L1562:TextFieldPressGestureFilter.kt#423gt5");
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventStart(-102778667, i, -1, "androidx.compose.foundation.text.tapPressTextFieldModifier.<anonymous> (TextFieldPressGestureFilter.kt:40)");
        }
        ComposerKt.sourceInformationMarkerStart(composer, 773894976, "CC(rememberCoroutineScope)N(getContext)616@28039L68:Effects.kt#9igjgp");
        ComposerKt.sourceInformationMarkerStart(composer, 683736516, "CC(remember):Effects.kt#9igjgp");
        Object objRememberedValue = composer.rememberedValue();
        if (objRememberedValue == Composer.INSTANCE.getEmpty()) {
            objRememberedValue = EffectsKt.createCompositionCoroutineScope(EmptyCoroutineContext.INSTANCE, composer);
            composer.updateRememberedValue(objRememberedValue);
        }
        CoroutineScope coroutineScope = (CoroutineScope) objRememberedValue;
        ComposerKt.sourceInformationMarkerEnd(composer);
        ComposerKt.sourceInformationMarkerEnd(composer);
        ComposerKt.sourceInformationMarkerStart(composer, 13951695, "CC(remember):TextFieldPressGestureFilter.kt#9igjgp");
        Object objRememberedValue2 = composer.rememberedValue();
        if (objRememberedValue2 == Composer.INSTANCE.getEmpty()) {
            objRememberedValue2 = SnapshotStateKt__SnapshotStateKt.mutableStateOf$default(null, null, 2, null);
            composer.updateRememberedValue(objRememberedValue2);
        }
        final MutableState mutableState = (MutableState) objRememberedValue2;
        ComposerKt.sourceInformationMarkerEnd(composer);
        State stateRememberUpdatedState = SnapshotStateKt.rememberUpdatedState(function1, composer, 0);
        ComposerKt.sourceInformationMarkerStart(composer, 13957228, "CC(remember):TextFieldPressGestureFilter.kt#9igjgp");
        boolean zChanged = composer.changed(mutableInteractionSource);
        Object objRememberedValue3 = composer.rememberedValue();
        if (zChanged || objRememberedValue3 == Composer.INSTANCE.getEmpty()) {
            objRememberedValue3 = new Function1() { // from class: androidx.compose.foundation.text.TextFieldPressGestureFilterKt$$ExternalSyntheticLambda1
                @Override // kotlin.jvm.functions.Function1
                public final Object invoke(Object obj) {
                    return TextFieldPressGestureFilterKt.tapPressTextFieldModifier$lambda$0$1$0(mutableState, mutableInteractionSource, (DisposableEffectScope) obj);
                }
            };
            composer.updateRememberedValue(objRememberedValue3);
        }
        ComposerKt.sourceInformationMarkerEnd(composer);
        EffectsKt.DisposableEffect(mutableInteractionSource, (Function1<? super DisposableEffectScope, ? extends DisposableEffectResult>) objRememberedValue3, composer, 0);
        Modifier.Companion companion = Modifier.INSTANCE;
        ComposerKt.sourceInformationMarkerStart(composer, 13971151, "CC(remember):TextFieldPressGestureFilter.kt#9igjgp");
        boolean zChangedInstance = composer.changedInstance(coroutineScope) | composer.changed(mutableInteractionSource) | composer.changed(stateRememberUpdatedState);
        Object objRememberedValue4 = composer.rememberedValue();
        if (zChangedInstance || objRememberedValue4 == Composer.INSTANCE.getEmpty()) {
            objRememberedValue4 = (PointerInputEventHandler) new TextFieldPressGestureFilterKt$tapPressTextFieldModifier$1$2$1(coroutineScope, mutableState, mutableInteractionSource, stateRememberUpdatedState);
            composer.updateRememberedValue(objRememberedValue4);
        }
        ComposerKt.sourceInformationMarkerEnd(composer);
        Modifier modifierPointerInput = SuspendingPointerInputFilterKt.pointerInput(companion, mutableInteractionSource, (PointerInputEventHandler) objRememberedValue4);
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventEnd();
        }
        composer.endReplaceGroup();
        return modifierPointerInput;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final DisposableEffectResult tapPressTextFieldModifier$lambda$0$1$0(final MutableState mutableState, final MutableInteractionSource mutableInteractionSource, DisposableEffectScope disposableEffectScope) {
        return new DisposableEffectResult() { // from class: androidx.compose.foundation.text.TextFieldPressGestureFilterKt$tapPressTextFieldModifier$lambda$0$1$0$$inlined$onDispose$1
            @Override // androidx.compose.runtime.DisposableEffectResult
            public void dispose() {
                PressInteraction.Press press = (PressInteraction.Press) mutableState.getValue();
                if (press != null) {
                    PressInteraction.Cancel cancel = new PressInteraction.Cancel(press);
                    MutableInteractionSource mutableInteractionSource2 = mutableInteractionSource;
                    if (mutableInteractionSource2 != null) {
                        mutableInteractionSource2.tryEmit(cancel);
                    }
                    mutableState.setValue(null);
                }
            }
        };
    }
}
