package androidx.compose.foundation.text;

import androidx.compose.foundation.text.selection.TextFieldSelectionManager;
import androidx.compose.foundation.text.selection.TextPreparedSelectionState;
import androidx.compose.runtime.Composer;
import androidx.compose.runtime.ComposerKt;
import androidx.compose.ui.ComposedModifierKt;
import androidx.compose.ui.Modifier;
import androidx.compose.ui.input.key.KeyInputModifierKt;
import androidx.compose.ui.text.input.OffsetMapping;
import androidx.compose.ui.text.input.TextFieldValue;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function3;
import kotlin.reflect.KFunction;

/* JADX INFO: compiled from: TextFieldKeyInput.kt */
/* JADX INFO: loaded from: classes.dex */
@Metadata(d1 = {"\u0000@\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\u001ai\u0010\u0000\u001a\u00020\u0001*\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u00072\u0014\b\u0002\u0010\b\u001a\u000e\u0012\u0004\u0012\u00020\u0007\u0012\u0004\u0012\u00020\n0\t2\u0006\u0010\u000b\u001a\u00020\f2\u0006\u0010\r\u001a\u00020\f2\u0006\u0010\u000e\u001a\u00020\u000f2\u0006\u0010\u0010\u001a\u00020\u00112\u0006\u0010\u0012\u001a\u00020\u0013H\u0000¢\u0006\u0004\b\u0014\u0010\u0015¨\u0006\u0016"}, d2 = {"textFieldKeyInput", "Landroidx/compose/ui/Modifier;", "state", "Landroidx/compose/foundation/text/LegacyTextFieldState;", "manager", "Landroidx/compose/foundation/text/selection/TextFieldSelectionManager;", "value", "Landroidx/compose/ui/text/input/TextFieldValue;", "onValueChange", "Lkotlin/Function1;", "", "editable", "", "singleLine", "offsetMapping", "Landroidx/compose/ui/text/input/OffsetMapping;", "undoManager", "Landroidx/compose/foundation/text/UndoManager;", "imeAction", "Landroidx/compose/ui/text/input/ImeAction;", "textFieldKeyInput-2WJ9YEU", "(Landroidx/compose/ui/Modifier;Landroidx/compose/foundation/text/LegacyTextFieldState;Landroidx/compose/foundation/text/selection/TextFieldSelectionManager;Landroidx/compose/ui/text/input/TextFieldValue;Lkotlin/jvm/functions/Function1;ZZLandroidx/compose/ui/text/input/OffsetMapping;Landroidx/compose/foundation/text/UndoManager;I)Landroidx/compose/ui/Modifier;", "foundation"}, k = 2, mv = {2, 1, 0}, xi = 48)
public final class TextFieldKeyInputKt {
    /* JADX INFO: renamed from: textFieldKeyInput-2WJ9YEU$default, reason: not valid java name */
    public static /* synthetic */ Modifier m1844textFieldKeyInput2WJ9YEU$default(Modifier modifier, LegacyTextFieldState legacyTextFieldState, TextFieldSelectionManager textFieldSelectionManager, TextFieldValue textFieldValue, Function1 function1, boolean z, boolean z2, OffsetMapping offsetMapping, UndoManager undoManager, int i, int i2, Object obj) {
        if ((i2 & 8) != 0) {
            function1 = new Function1() { // from class: androidx.compose.foundation.text.TextFieldKeyInputKt$$ExternalSyntheticLambda1
                @Override // kotlin.jvm.functions.Function1
                public final Object invoke(Object obj2) {
                    return TextFieldKeyInputKt.textFieldKeyInput_2WJ9YEU$lambda$0((TextFieldValue) obj2);
                }
            };
        }
        return m1843textFieldKeyInput2WJ9YEU(modifier, legacyTextFieldState, textFieldSelectionManager, textFieldValue, function1, z, z2, offsetMapping, undoManager, i);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit textFieldKeyInput_2WJ9YEU$lambda$0(TextFieldValue textFieldValue) {
        return Unit.INSTANCE;
    }

    /* JADX INFO: renamed from: textFieldKeyInput-2WJ9YEU, reason: not valid java name */
    public static final Modifier m1843textFieldKeyInput2WJ9YEU(Modifier modifier, final LegacyTextFieldState legacyTextFieldState, final TextFieldSelectionManager textFieldSelectionManager, final TextFieldValue textFieldValue, final Function1<? super TextFieldValue, Unit> function1, final boolean z, final boolean z2, final OffsetMapping offsetMapping, final UndoManager undoManager, final int i) {
        return ComposedModifierKt.composed$default(modifier, null, new Function3() { // from class: androidx.compose.foundation.text.TextFieldKeyInputKt$$ExternalSyntheticLambda0
            @Override // kotlin.jvm.functions.Function3
            public final Object invoke(Object obj, Object obj2, Object obj3) {
                return TextFieldKeyInputKt.textFieldKeyInput_2WJ9YEU$lambda$1(legacyTextFieldState, textFieldSelectionManager, textFieldValue, z, z2, offsetMapping, undoManager, function1, i, (Modifier) obj, (Composer) obj2, ((Integer) obj3).intValue());
            }
        }, 1, null);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Modifier textFieldKeyInput_2WJ9YEU$lambda$1(LegacyTextFieldState legacyTextFieldState, TextFieldSelectionManager textFieldSelectionManager, TextFieldValue textFieldValue, boolean z, boolean z2, OffsetMapping offsetMapping, UndoManager undoManager, Function1 function1, int i, Modifier modifier, Composer composer, int i2) {
        composer.startReplaceGroup(851809892);
        ComposerKt.sourceInformation(composer, "C256@11984L41,257@12048L30,272@12584L18:TextFieldKeyInput.kt#423gt5");
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventStart(851809892, i2, -1, "androidx.compose.foundation.text.textFieldKeyInput.<anonymous> (TextFieldKeyInput.kt:256)");
        }
        ComposerKt.sourceInformationMarkerStart(composer, -1749446163, "CC(remember):TextFieldKeyInput.kt#9igjgp");
        Object objRememberedValue = composer.rememberedValue();
        if (objRememberedValue == Composer.INSTANCE.getEmpty()) {
            objRememberedValue = new TextPreparedSelectionState();
            composer.updateRememberedValue(objRememberedValue);
        }
        TextPreparedSelectionState textPreparedSelectionState = (TextPreparedSelectionState) objRememberedValue;
        ComposerKt.sourceInformationMarkerEnd(composer);
        ComposerKt.sourceInformationMarkerStart(composer, -1749444126, "CC(remember):TextFieldKeyInput.kt#9igjgp");
        Object objRememberedValue2 = composer.rememberedValue();
        if (objRememberedValue2 == Composer.INSTANCE.getEmpty()) {
            objRememberedValue2 = new DeadKeyCombiner();
            composer.updateRememberedValue(objRememberedValue2);
        }
        ComposerKt.sourceInformationMarkerEnd(composer);
        TextFieldKeyInput textFieldKeyInput = new TextFieldKeyInput(legacyTextFieldState, textFieldSelectionManager, textFieldValue, z, z2, textPreparedSelectionState, offsetMapping, undoManager, (DeadKeyCombiner) objRememberedValue2, null, function1, i, 512, null);
        Modifier.Companion companion = Modifier.INSTANCE;
        ComposerKt.sourceInformationMarkerStart(composer, -1749426986, "CC(remember):TextFieldKeyInput.kt#9igjgp");
        boolean zChangedInstance = composer.changedInstance(textFieldKeyInput);
        TextFieldKeyInputKt$textFieldKeyInput$2$1$1 textFieldKeyInputKt$textFieldKeyInput$2$1$1RememberedValue = composer.rememberedValue();
        if (zChangedInstance || textFieldKeyInputKt$textFieldKeyInput$2$1$1RememberedValue == Composer.INSTANCE.getEmpty()) {
            textFieldKeyInputKt$textFieldKeyInput$2$1$1RememberedValue = new TextFieldKeyInputKt$textFieldKeyInput$2$1$1(textFieldKeyInput);
            composer.updateRememberedValue(textFieldKeyInputKt$textFieldKeyInput$2$1$1RememberedValue);
        }
        ComposerKt.sourceInformationMarkerEnd(composer);
        Modifier modifierOnKeyEvent = KeyInputModifierKt.onKeyEvent(companion, (Function1) ((KFunction) textFieldKeyInputKt$textFieldKeyInput$2$1$1RememberedValue));
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventEnd();
        }
        composer.endReplaceGroup();
        return modifierOnKeyEvent;
    }
}
