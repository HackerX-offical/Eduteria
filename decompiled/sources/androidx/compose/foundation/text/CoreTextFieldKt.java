package androidx.compose.foundation.text;

import androidx.compose.foundation.ComposeFoundationFlags;
import androidx.compose.foundation.gestures.Orientation;
import androidx.compose.foundation.gestures.TapGestureDetectorKt;
import androidx.compose.foundation.interaction.MutableInteractionSource;
import androidx.compose.foundation.layout.BoxKt;
import androidx.compose.foundation.layout.BoxScopeInstance;
import androidx.compose.foundation.layout.SizeKt;
import androidx.compose.foundation.relocation.BringIntoViewRequester;
import androidx.compose.foundation.relocation.BringIntoViewRequesterKt;
import androidx.compose.foundation.text.input.internal.LegacyPlatformTextInputServiceAdapter;
import androidx.compose.foundation.text.selection.OffsetProvider;
import androidx.compose.foundation.text.selection.SelectionHandleAnchor;
import androidx.compose.foundation.text.selection.SelectionHandleInfo;
import androidx.compose.foundation.text.selection.SelectionHandlesKt;
import androidx.compose.foundation.text.selection.SimpleLayoutKt;
import androidx.compose.foundation.text.selection.TextFieldSelectionManager;
import androidx.compose.foundation.text.selection.TextFieldSelectionManagerKt;
import androidx.compose.foundation.text.selection.TextFieldSelectionManager_androidKt;
import androidx.compose.runtime.Applier;
import androidx.compose.runtime.ComposablesKt;
import androidx.compose.runtime.Composer;
import androidx.compose.runtime.ComposerKt;
import androidx.compose.runtime.CompositionLocalMap;
import androidx.compose.runtime.DisposableEffectResult;
import androidx.compose.runtime.DisposableEffectScope;
import androidx.compose.runtime.ProvidableCompositionLocal;
import androidx.compose.runtime.RecomposeScopeImplKt;
import androidx.compose.runtime.ScopeUpdateScope;
import androidx.compose.runtime.State;
import androidx.compose.runtime.Updater;
import androidx.compose.runtime.internal.ComposableLambdaKt;
import androidx.compose.runtime.snapshots.Snapshot;
import androidx.compose.ui.Alignment;
import androidx.compose.ui.ComposedModifierKt;
import androidx.compose.ui.Modifier;
import androidx.compose.ui.draw.DrawModifierKt;
import androidx.compose.ui.focus.FocusRequester;
import androidx.compose.ui.focus.FocusState;
import androidx.compose.ui.geometry.Offset;
import androidx.compose.ui.geometry.Rect;
import androidx.compose.ui.graphics.Brush;
import androidx.compose.ui.graphics.drawscope.ContentDrawScope;
import androidx.compose.ui.graphics.drawscope.DrawScope;
import androidx.compose.ui.input.key.KeyEvent;
import androidx.compose.ui.input.key.KeyInputModifierKt;
import androidx.compose.ui.input.pointer.PointerInputEventHandler;
import androidx.compose.ui.input.pointer.PointerInputScope;
import androidx.compose.ui.input.pointer.SuspendingPointerInputFilterKt;
import androidx.compose.ui.layout.LayoutCoordinates;
import androidx.compose.ui.layout.MeasurePolicy;
import androidx.compose.ui.node.ComposeUiNode;
import androidx.compose.ui.platform.CompositionLocalsKt;
import androidx.compose.ui.platform.SoftwareKeyboardController;
import androidx.compose.ui.platform.WindowInfo;
import androidx.compose.ui.semantics.SemanticsModifierKt;
import androidx.compose.ui.semantics.SemanticsPropertyReceiver;
import androidx.compose.ui.text.AnnotatedString;
import androidx.compose.ui.text.TextLayoutResult;
import androidx.compose.ui.text.TextRange;
import androidx.compose.ui.text.TextStyle;
import androidx.compose.ui.text.input.ImeOptions;
import androidx.compose.ui.text.input.OffsetMapping;
import androidx.compose.ui.text.input.TextFieldValue;
import androidx.compose.ui.text.input.TextInputService;
import androidx.compose.ui.text.input.TextInputSession;
import androidx.compose.ui.text.input.VisualTransformation;
import androidx.compose.ui.text.style.ResolvedTextDirection;
import androidx.compose.ui.unit.Density;
import androidx.media3.exoplayer.RendererCapabilities;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.functions.Function3;
import kotlinx.coroutines.BuildersKt__Builders_commonKt;
import kotlinx.coroutines.CoroutineScope;
import kotlinx.coroutines.CoroutineScopeKt;
import kotlinx.coroutines.CoroutineStart;
import org.jivesoftware.smack.sm.packet.StreamManagement;

/* JADX INFO: compiled from: CoreTextField.kt */
/* JADX INFO: loaded from: classes.dex */
@Metadata(d1 = {"\u0000¨\u0001\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\f\n\u0002\u0018\u0002\n\u0002\b\u0002\u001aú\u0001\u0010\u0000\u001a\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u00032\u0012\u0010\u0004\u001a\u000e\u0012\u0004\u0012\u00020\u0003\u0012\u0004\u0012\u00020\u00010\u00052\b\b\u0002\u0010\u0006\u001a\u00020\u00072\b\b\u0002\u0010\b\u001a\u00020\t2\b\b\u0002\u0010\n\u001a\u00020\u000b2\u0014\b\u0002\u0010\f\u001a\u000e\u0012\u0004\u0012\u00020\r\u0012\u0004\u0012\u00020\u00010\u00052\n\b\u0002\u0010\u000e\u001a\u0004\u0018\u00010\u000f2\b\b\u0002\u0010\u0010\u001a\u00020\u00112\b\b\u0002\u0010\u0012\u001a\u00020\u00132\b\b\u0002\u0010\u0014\u001a\u00020\u00152\b\b\u0002\u0010\u0016\u001a\u00020\u00152\b\b\u0002\u0010\u0017\u001a\u00020\u00182\b\b\u0002\u0010\u0019\u001a\u00020\u001a2\b\b\u0002\u0010\u001b\u001a\u00020\u00132\b\b\u0002\u0010\u001c\u001a\u00020\u001323\b\u0002\u0010\u001d\u001a-\u0012\u001e\u0012\u001c\u0012\u0004\u0012\u00020\u00010\u001e¢\u0006\u0002\b\u001f¢\u0006\f\b \u0012\b\b!\u0012\u0004\b\b(\"\u0012\u0004\u0012\u00020\u00010\u0005¢\u0006\u0002\b\u001f2\n\b\u0002\u0010#\u001a\u0004\u0018\u00010$H\u0001¢\u0006\u0002\u0010%\u001a0\u0010&\u001a\u00020\u00012\u0006\u0010\u0006\u001a\u00020\u00072\u0006\u0010'\u001a\u00020(2\u0011\u0010)\u001a\r\u0012\u0004\u0012\u00020\u00010\u001e¢\u0006\u0002\b\u001fH\u0003¢\u0006\u0002\u0010*\u001a\u001c\u0010+\u001a\u00020\u0007*\u00020\u00072\u0006\u0010,\u001a\u00020-2\u0006\u0010'\u001a\u00020(H\u0002\u001a \u0010.\u001a\u00020\u00012\u0006\u0010,\u001a\u00020-2\u0006\u0010/\u001a\u0002002\u0006\u00101\u001a\u00020\u0013H\u0000\u001a0\u00102\u001a\u00020\u00012\u0006\u00103\u001a\u0002042\u0006\u0010,\u001a\u00020-2\u0006\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0017\u001a\u00020\u00182\u0006\u00105\u001a\u000206H\u0002\u001a\u0010\u00107\u001a\u00020\u00012\u0006\u0010,\u001a\u00020-H\u0002\u001a2\u00108\u001a\u00020\u0001*\u0002092\u0006\u0010\u0002\u001a\u00020\u00032\u0006\u0010:\u001a\u00020;2\u0006\u0010<\u001a\u00020\r2\u0006\u00105\u001a\u000206H\u0080@¢\u0006\u0002\u0010=\u001a\u001d\u0010>\u001a\u00020\u00012\u0006\u0010'\u001a\u00020(2\u0006\u0010?\u001a\u00020\u0013H\u0003¢\u0006\u0002\u0010@\u001a\u0015\u0010A\u001a\u00020\u00012\u0006\u0010'\u001a\u00020(H\u0001¢\u0006\u0002\u0010B\u001a$\u0010C\u001a\u00020\u0007*\u00020\u00072\u0006\u0010,\u001a\u00020-2\u0006\u0010\u0002\u001a\u00020\u00032\u0006\u00105\u001a\u000206H\u0000\u001a \u0010D\u001a\u00020\u00012\u0006\u0010,\u001a\u00020-2\u0006\u0010\u0002\u001a\u00020\u00032\u0006\u00105\u001a\u000206H\u0002\u001a\u001c\u0010E\u001a\u00020\u0007*\u00020\u00072\u0006\u0010F\u001a\u00020(2\u0006\u0010G\u001a\u00020HH\u0002¨\u0006I²\u0006\n\u0010J\u001a\u00020\u0013X\u008a\u0084\u0002"}, d2 = {"CoreTextField", "", "value", "Landroidx/compose/ui/text/input/TextFieldValue;", "onValueChange", "Lkotlin/Function1;", "modifier", "Landroidx/compose/ui/Modifier;", "textStyle", "Landroidx/compose/ui/text/TextStyle;", "visualTransformation", "Landroidx/compose/ui/text/input/VisualTransformation;", "onTextLayout", "Landroidx/compose/ui/text/TextLayoutResult;", "interactionSource", "Landroidx/compose/foundation/interaction/MutableInteractionSource;", "cursorBrush", "Landroidx/compose/ui/graphics/Brush;", "softWrap", "", "maxLines", "", "minLines", "imeOptions", "Landroidx/compose/ui/text/input/ImeOptions;", "keyboardActions", "Landroidx/compose/foundation/text/KeyboardActions;", StreamManagement.Enabled.ELEMENT, "readOnly", "decorationBox", "Lkotlin/Function0;", "Landroidx/compose/runtime/Composable;", "Lkotlin/ParameterName;", "name", "innerTextField", "textScrollerPosition", "Landroidx/compose/foundation/text/TextFieldScrollerPosition;", "(Landroidx/compose/ui/text/input/TextFieldValue;Lkotlin/jvm/functions/Function1;Landroidx/compose/ui/Modifier;Landroidx/compose/ui/text/TextStyle;Landroidx/compose/ui/text/input/VisualTransformation;Lkotlin/jvm/functions/Function1;Landroidx/compose/foundation/interaction/MutableInteractionSource;Landroidx/compose/ui/graphics/Brush;ZIILandroidx/compose/ui/text/input/ImeOptions;Landroidx/compose/foundation/text/KeyboardActions;ZZLkotlin/jvm/functions/Function3;Landroidx/compose/foundation/text/TextFieldScrollerPosition;Landroidx/compose/runtime/Composer;III)V", "CoreTextFieldRootBox", "manager", "Landroidx/compose/foundation/text/selection/TextFieldSelectionManager;", "content", "(Landroidx/compose/ui/Modifier;Landroidx/compose/foundation/text/selection/TextFieldSelectionManager;Lkotlin/jvm/functions/Function2;Landroidx/compose/runtime/Composer;I)V", "previewKeyEventToDeselectOnBack", "state", "Landroidx/compose/foundation/text/LegacyTextFieldState;", "requestFocusAndShowKeyboardIfNeeded", "focusRequester", "Landroidx/compose/ui/focus/FocusRequester;", "allowKeyboard", "startInputSession", "textInputService", "Landroidx/compose/ui/text/input/TextInputService;", "offsetMapping", "Landroidx/compose/ui/text/input/OffsetMapping;", "endInputSession", "bringSelectionEndIntoView", "Landroidx/compose/foundation/relocation/BringIntoViewRequester;", "textDelegate", "Landroidx/compose/foundation/text/TextDelegate;", "textLayoutResult", "(Landroidx/compose/foundation/relocation/BringIntoViewRequester;Landroidx/compose/ui/text/input/TextFieldValue;Landroidx/compose/foundation/text/TextDelegate;Landroidx/compose/ui/text/TextLayoutResult;Landroidx/compose/ui/text/input/OffsetMapping;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "SelectionToolbarAndHandles", "show", "(Landroidx/compose/foundation/text/selection/TextFieldSelectionManager;ZLandroidx/compose/runtime/Composer;I)V", "TextFieldCursorHandle", "(Landroidx/compose/foundation/text/selection/TextFieldSelectionManager;Landroidx/compose/runtime/Composer;I)V", "defaultTextFieldDraw", "notifyFocusedRect", "addContextMenuComponents", "textFieldSelectionManager", "coroutineScope", "Lkotlinx/coroutines/CoroutineScope;", "foundation", "writeable"}, k = 2, mv = {2, 1, 0}, xi = 48)
public final class CoreTextFieldKt {
    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit CoreTextField$lambda$23(TextFieldValue textFieldValue, Function1 function1, Modifier modifier, TextStyle textStyle, VisualTransformation visualTransformation, Function1 function12, MutableInteractionSource mutableInteractionSource, Brush brush, boolean z, int i, int i2, ImeOptions imeOptions, KeyboardActions keyboardActions, boolean z2, boolean z3, Function3 function3, TextFieldScrollerPosition textFieldScrollerPosition, int i3, int i4, int i5, Composer composer, int i6) {
        CoreTextField(textFieldValue, function1, modifier, textStyle, visualTransformation, function12, mutableInteractionSource, brush, z, i, i2, imeOptions, keyboardActions, z2, z3, function3, textFieldScrollerPosition, composer, RecomposeScopeImplKt.updateChangedFlags(i3 | 1), RecomposeScopeImplKt.updateChangedFlags(i4), i5);
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit CoreTextFieldRootBox$lambda$1(Modifier modifier, TextFieldSelectionManager textFieldSelectionManager, Function2 function2, int i, Composer composer, int i2) {
        CoreTextFieldRootBox(modifier, textFieldSelectionManager, function2, composer, RecomposeScopeImplKt.updateChangedFlags(i | 1));
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit SelectionToolbarAndHandles$lambda$1(TextFieldSelectionManager textFieldSelectionManager, boolean z, int i, Composer composer, int i2) {
        SelectionToolbarAndHandles(textFieldSelectionManager, z, composer, RecomposeScopeImplKt.updateChangedFlags(i | 1));
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit TextFieldCursorHandle$lambda$4(TextFieldSelectionManager textFieldSelectionManager, int i, Composer composer, int i2) {
        TextFieldCursorHandle(textFieldSelectionManager, composer, RecomposeScopeImplKt.updateChangedFlags(i | 1));
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit CoreTextField$lambda$0$0(TextLayoutResult textLayoutResult) {
        return Unit.INSTANCE;
    }

    /* JADX WARN: Removed duplicated region for block: B:105:0x0137  */
    /* JADX WARN: Removed duplicated region for block: B:106:0x0140  */
    /* JADX WARN: Removed duplicated region for block: B:116:0x0160  */
    /* JADX WARN: Removed duplicated region for block: B:124:0x0176  */
    /* JADX WARN: Removed duplicated region for block: B:127:0x017e  */
    /* JADX WARN: Removed duplicated region for block: B:128:0x0181  */
    /* JADX WARN: Removed duplicated region for block: B:138:0x01a3  */
    /* JADX WARN: Removed duplicated region for block: B:139:0x01a6  */
    /* JADX WARN: Removed duplicated region for block: B:150:0x01c6  */
    /* JADX WARN: Removed duplicated region for block: B:151:0x01cd  */
    /* JADX WARN: Removed duplicated region for block: B:160:0x01eb  */
    /* JADX WARN: Removed duplicated region for block: B:161:0x01f0  */
    /* JADX WARN: Removed duplicated region for block: B:170:0x0209  */
    /* JADX WARN: Removed duplicated region for block: B:171:0x020e  */
    /* JADX WARN: Removed duplicated region for block: B:180:0x022d  */
    /* JADX WARN: Removed duplicated region for block: B:184:0x023a  */
    /* JADX WARN: Removed duplicated region for block: B:187:0x0243  */
    /* JADX WARN: Removed duplicated region for block: B:31:0x005b  */
    /* JADX WARN: Removed duplicated region for block: B:32:0x005e  */
    /* JADX WARN: Removed duplicated region for block: B:356:0x07a8  */
    /* JADX WARN: Removed duplicated region for block: B:361:0x07e3  */
    /* JADX WARN: Removed duplicated region for block: B:368:0x081f  */
    /* JADX WARN: Removed duplicated region for block: B:371:0x0827  */
    /* JADX WARN: Removed duplicated region for block: B:374:0x082f  */
    /* JADX WARN: Removed duplicated region for block: B:378:0x083e  */
    /* JADX WARN: Removed duplicated region for block: B:381:0x08c9  */
    /* JADX WARN: Removed duplicated region for block: B:382:0x08cb  */
    /* JADX WARN: Removed duplicated region for block: B:385:0x08e1  */
    /* JADX WARN: Removed duplicated region for block: B:386:0x08e3  */
    /* JADX WARN: Removed duplicated region for block: B:389:0x08f4  */
    /* JADX WARN: Removed duplicated region for block: B:393:0x0902  */
    /* JADX WARN: Removed duplicated region for block: B:397:0x0946 A[ADDED_TO_REGION] */
    /* JADX WARN: Removed duplicated region for block: B:403:0x0957  */
    /* JADX WARN: Removed duplicated region for block: B:406:0x098b  */
    /* JADX WARN: Removed duplicated region for block: B:409:0x0996  */
    /* JADX WARN: Removed duplicated region for block: B:413:0x09bb  */
    /* JADX WARN: Removed duplicated region for block: B:414:0x09bd  */
    /* JADX WARN: Removed duplicated region for block: B:417:0x09c3  */
    /* JADX WARN: Removed duplicated region for block: B:419:0x09c9  */
    /* JADX WARN: Removed duplicated region for block: B:425:0x09d7  */
    /* JADX WARN: Removed duplicated region for block: B:427:0x09df  */
    /* JADX WARN: Removed duplicated region for block: B:42:0x007a  */
    /* JADX WARN: Removed duplicated region for block: B:430:0x0a01  */
    /* JADX WARN: Removed duplicated region for block: B:431:0x0a04  */
    /* JADX WARN: Removed duplicated region for block: B:437:0x0a48  */
    /* JADX WARN: Removed duplicated region for block: B:43:0x007d  */
    /* JADX WARN: Removed duplicated region for block: B:442:0x0a73  */
    /* JADX WARN: Removed duplicated region for block: B:447:0x0ae0  */
    /* JADX WARN: Removed duplicated region for block: B:457:0x0b53  */
    /* JADX WARN: Removed duplicated region for block: B:459:0x0b56  */
    /* JADX WARN: Removed duplicated region for block: B:460:0x0b5f  */
    /* JADX WARN: Removed duplicated region for block: B:463:0x0baa  */
    /* JADX WARN: Removed duplicated region for block: B:465:0x0bc8  */
    /* JADX WARN: Removed duplicated region for block: B:468:0x0bea  */
    /* JADX WARN: Removed duplicated region for block: B:470:? A[RETURN, SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:53:0x0099  */
    /* JADX WARN: Removed duplicated region for block: B:54:0x009e  */
    /* JADX WARN: Removed duplicated region for block: B:63:0x00b7  */
    /* JADX WARN: Removed duplicated region for block: B:64:0x00bc  */
    /* JADX WARN: Removed duplicated region for block: B:73:0x00d5  */
    /* JADX WARN: Removed duplicated region for block: B:74:0x00da  */
    /* JADX WARN: Removed duplicated region for block: B:83:0x00f3  */
    /* JADX WARN: Removed duplicated region for block: B:84:0x00f6  */
    /* JADX WARN: Removed duplicated region for block: B:94:0x0116  */
    /* JADX WARN: Removed duplicated region for block: B:95:0x0119  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public static final void CoreTextField(final androidx.compose.ui.text.input.TextFieldValue r47, final kotlin.jvm.functions.Function1<? super androidx.compose.ui.text.input.TextFieldValue, kotlin.Unit> r48, androidx.compose.ui.Modifier r49, androidx.compose.ui.text.TextStyle r50, androidx.compose.ui.text.input.VisualTransformation r51, kotlin.jvm.functions.Function1<? super androidx.compose.ui.text.TextLayoutResult, kotlin.Unit> r52, androidx.compose.foundation.interaction.MutableInteractionSource r53, androidx.compose.ui.graphics.Brush r54, boolean r55, int r56, int r57, androidx.compose.ui.text.input.ImeOptions r58, androidx.compose.foundation.text.KeyboardActions r59, boolean r60, boolean r61, kotlin.jvm.functions.Function3<? super kotlin.jvm.functions.Function2<? super androidx.compose.runtime.Composer, ? super java.lang.Integer, kotlin.Unit>, ? super androidx.compose.runtime.Composer, ? super java.lang.Integer, kotlin.Unit> r62, androidx.compose.foundation.text.TextFieldScrollerPosition r63, androidx.compose.runtime.Composer r64, final int r65, final int r66, final int r67) {
        /*
            Method dump skipped, instruction units count: 3077
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.compose.foundation.text.CoreTextFieldKt.CoreTextField(androidx.compose.ui.text.input.TextFieldValue, kotlin.jvm.functions.Function1, androidx.compose.ui.Modifier, androidx.compose.ui.text.TextStyle, androidx.compose.ui.text.input.VisualTransformation, kotlin.jvm.functions.Function1, androidx.compose.foundation.interaction.MutableInteractionSource, androidx.compose.ui.graphics.Brush, boolean, int, int, androidx.compose.ui.text.input.ImeOptions, androidx.compose.foundation.text.KeyboardActions, boolean, boolean, kotlin.jvm.functions.Function3, androidx.compose.foundation.text.TextFieldScrollerPosition, androidx.compose.runtime.Composer, int, int, int):void");
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final TextFieldScrollerPosition CoreTextField$lambda$4$0(Orientation orientation) {
        return new TextFieldScrollerPosition(orientation, 0.0f, 2, null);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final AnnotatedString CoreTextField$lambda$11(TextFieldSelectionManager textFieldSelectionManager) {
        return TextFieldSelectionManager.copyWithResult$foundation$default(textFieldSelectionManager, false, 1, null);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit CoreTextField$lambda$10(TextFieldSelectionManager textFieldSelectionManager, AnnotatedString annotatedString) {
        textFieldSelectionManager.paste$foundation(annotatedString);
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit CoreTextField$lambda$13$0(LegacyTextFieldState legacyTextFieldState, boolean z, boolean z2, TextInputService textInputService, TextFieldValue textFieldValue, ImeOptions imeOptions, OffsetMapping offsetMapping, TextFieldSelectionManager textFieldSelectionManager, CoroutineScope coroutineScope, BringIntoViewRequester bringIntoViewRequester, FocusState focusState) {
        TextLayoutResultProxy layoutResult;
        if (legacyTextFieldState.getHasFocus() == focusState.isFocused()) {
            return Unit.INSTANCE;
        }
        legacyTextFieldState.setHasFocus(focusState.isFocused());
        if (legacyTextFieldState.getHasFocus() && z && !z2) {
            startInputSession(textInputService, legacyTextFieldState, textFieldValue, imeOptions, offsetMapping);
        } else {
            endInputSession(legacyTextFieldState);
        }
        if (focusState.isFocused() && (layoutResult = legacyTextFieldState.getLayoutResult()) != null) {
            BuildersKt__Builders_commonKt.launch$default(coroutineScope, null, null, new CoreTextFieldKt$CoreTextField$focusModifier$1$1$1$1(bringIntoViewRequester, textFieldValue, legacyTextFieldState, layoutResult, offsetMapping, null), 3, null);
        }
        if (!focusState.isFocused()) {
            TextFieldSelectionManager.m2363deselect_kEHs6E$foundation$default(textFieldSelectionManager, null, 1, null);
        }
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit CoreTextField$lambda$16$0(LegacyTextFieldState legacyTextFieldState, boolean z, WindowInfo windowInfo, TextFieldSelectionManager textFieldSelectionManager, TextFieldValue textFieldValue, OffsetMapping offsetMapping, LayoutCoordinates layoutCoordinates) {
        TextInputSession inputSession;
        legacyTextFieldState.setLayoutCoordinates(layoutCoordinates);
        TextLayoutResultProxy layoutResult = legacyTextFieldState.getLayoutResult();
        if (layoutResult != null) {
            layoutResult.setInnerTextFieldCoordinates(layoutCoordinates);
        }
        if (z) {
            if (legacyTextFieldState.getHandleState() == HandleState.Selection) {
                if (legacyTextFieldState.getShowFloatingToolbar() && windowInfo.isWindowFocused()) {
                    textFieldSelectionManager.showSelectionToolbar$foundation();
                } else {
                    textFieldSelectionManager.hideSelectionToolbar$foundation();
                }
                legacyTextFieldState.setShowSelectionHandleStart(TextFieldSelectionManager_androidKt.isSelectionHandleInVisibleBound(textFieldSelectionManager, true));
                legacyTextFieldState.setShowSelectionHandleEnd(TextFieldSelectionManager_androidKt.isSelectionHandleInVisibleBound(textFieldSelectionManager, false));
                legacyTextFieldState.setShowCursorHandle(TextRange.m8267getCollapsedimpl(textFieldValue.getSelection()));
            } else if (legacyTextFieldState.getHandleState() == HandleState.Cursor) {
                legacyTextFieldState.setShowCursorHandle(TextFieldSelectionManager_androidKt.isSelectionHandleInVisibleBound(textFieldSelectionManager, true));
            }
            notifyFocusedRect(legacyTextFieldState, textFieldValue, offsetMapping);
            TextLayoutResultProxy layoutResult2 = legacyTextFieldState.getLayoutResult();
            if (layoutResult2 != null && (inputSession = legacyTextFieldState.getInputSession()) != null && legacyTextFieldState.getHasFocus()) {
                TextFieldDelegate.INSTANCE.updateTextLayoutResult$foundation(inputSession, textFieldValue, offsetMapping, layoutResult2);
            }
        }
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final DisposableEffectResult CoreTextField$lambda$18$0(LegacyTextFieldState legacyTextFieldState, TextInputService textInputService, TextFieldValue textFieldValue, ImeOptions imeOptions, DisposableEffectScope disposableEffectScope) {
        if (legacyTextFieldState.getHasFocus()) {
            legacyTextFieldState.setInputSession(TextFieldDelegate.INSTANCE.restartInput$foundation(textInputService, textFieldValue, legacyTextFieldState.getProcessor(), imeOptions, legacyTextFieldState.getOnValueChange(), legacyTextFieldState.getOnImeActionPerformed()));
        }
        return new DisposableEffectResult() { // from class: androidx.compose.foundation.text.CoreTextFieldKt$CoreTextField$lambda$18$0$$inlined$onDispose$1
            @Override // androidx.compose.runtime.DisposableEffectResult
            public void dispose() {
            }
        };
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit CoreTextField$lambda$19$0(boolean z, LegacyPlatformTextInputServiceAdapter legacyPlatformTextInputServiceAdapter) {
        if (z) {
            legacyPlatformTextInputServiceAdapter.startStylusHandwriting();
        }
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit CoreTextField$lambda$20$0(LegacyTextFieldState legacyTextFieldState, Brush brush, ContentDrawScope contentDrawScope) {
        contentDrawScope.drawContent();
        if (legacyTextFieldState.getAutofillHighlightOn() || legacyTextFieldState.getJustAutofilled()) {
            DrawScope.m6542drawRectAsUm42w$default(contentDrawScope, brush, 0L, 0L, 0.0f, null, null, 0, 126, null);
        }
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit CoreTextField$lambda$21(LegacyTextFieldState legacyTextFieldState, LayoutCoordinates layoutCoordinates) {
        TextLayoutResultProxy layoutResult = legacyTextFieldState.getLayoutResult();
        if (layoutResult != null) {
            layoutResult.setDecorationBoxCoordinates(layoutCoordinates);
        }
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit CoreTextField$lambda$22(Function3 function3, final LegacyTextFieldState legacyTextFieldState, final TextStyle textStyle, final int i, final int i2, final TextFieldScrollerPosition textFieldScrollerPosition, final TextFieldValue textFieldValue, final VisualTransformation visualTransformation, final Modifier modifier, final Modifier modifier2, final Modifier modifier3, final Modifier modifier4, final BringIntoViewRequester bringIntoViewRequester, final TextFieldSelectionManager textFieldSelectionManager, final boolean z, final boolean z2, final Function1 function1, final OffsetMapping offsetMapping, final Density density, Composer composer, int i3) {
        ComposerKt.sourceInformation(composer, "C548@25668L5379,548@25654L5393:CoreTextField.kt#423gt5");
        if (!composer.shouldExecute((i3 & 3) != 2, i3 & 1)) {
            composer.skipToGroupEnd();
        } else {
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(-814563849, i3, -1, "androidx.compose.foundation.text.CoreTextField.<anonymous> (CoreTextField.kt:548)");
            }
            function3.invoke(ComposableLambdaKt.rememberComposableLambda(-44346382, true, new Function2() { // from class: androidx.compose.foundation.text.CoreTextFieldKt$$ExternalSyntheticLambda13
                @Override // kotlin.jvm.functions.Function2
                public final Object invoke(Object obj, Object obj2) {
                    return CoreTextFieldKt.CoreTextField$lambda$22$0(legacyTextFieldState, textStyle, i, i2, textFieldScrollerPosition, textFieldValue, visualTransformation, modifier, modifier2, modifier3, modifier4, bringIntoViewRequester, textFieldSelectionManager, z, z2, function1, offsetMapping, density, (Composer) obj, ((Integer) obj2).intValue());
                }
            }, composer, 54), composer, 6);
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventEnd();
            }
        }
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit CoreTextField$lambda$22$0(final LegacyTextFieldState legacyTextFieldState, TextStyle textStyle, int i, final int i2, TextFieldScrollerPosition textFieldScrollerPosition, final TextFieldValue textFieldValue, VisualTransformation visualTransformation, Modifier modifier, Modifier modifier2, Modifier modifier3, Modifier modifier4, BringIntoViewRequester bringIntoViewRequester, final TextFieldSelectionManager textFieldSelectionManager, final boolean z, final boolean z2, final Function1 function1, final OffsetMapping offsetMapping, final Density density, Composer composer, int i3) {
        ComposerKt.sourceInformation(composer, "C562@26519L22,571@26906L4131,571@26870L4167:CoreTextField.kt#423gt5");
        if (!composer.shouldExecute((i3 & 3) != 2, i3 & 1)) {
            composer.skipToGroupEnd();
        } else {
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(-44346382, i3, -1, "androidx.compose.foundation.text.CoreTextField.<anonymous>.<anonymous> (CoreTextField.kt:551)");
            }
            Modifier modifierHeightInLines = HeightInLinesModifierKt.heightInLines(SizeKt.m1209heightInVpY3zN4$default(Modifier.INSTANCE, legacyTextFieldState.m1783getMinHeightForSingleLineFieldD9Ej5fM(), 0.0f, 2, null), textStyle, i, i2);
            ComposerKt.sourceInformationMarkerStart(composer, 332827112, "CC(remember):CoreTextField.kt#9igjgp");
            boolean zChangedInstance = composer.changedInstance(legacyTextFieldState);
            Object objRememberedValue = composer.rememberedValue();
            if (zChangedInstance || objRememberedValue == Composer.INSTANCE.getEmpty()) {
                objRememberedValue = new Function0() { // from class: androidx.compose.foundation.text.CoreTextFieldKt$$ExternalSyntheticLambda9
                    @Override // kotlin.jvm.functions.Function0
                    public final Object invoke() {
                        return legacyTextFieldState.getLayoutResult();
                    }
                };
                composer.updateRememberedValue(objRememberedValue);
            }
            ComposerKt.sourceInformationMarkerEnd(composer);
            SimpleLayoutKt.SimpleLayout(BringIntoViewRequesterKt.bringIntoViewRequester(TextFieldSizeKt.textFieldMinSize(TextFieldScroll_androidKt.textFieldScroll(modifierHeightInLines, textFieldScrollerPosition, textFieldValue, visualTransformation, (Function0) objRememberedValue).then(modifier).then(modifier2), textStyle).then(modifier3).then(modifier4), bringIntoViewRequester), ComposableLambdaKt.rememberComposableLambda(1412697320, true, new Function2() { // from class: androidx.compose.foundation.text.CoreTextFieldKt$$ExternalSyntheticLambda10
                @Override // kotlin.jvm.functions.Function2
                public final Object invoke(Object obj, Object obj2) {
                    return CoreTextFieldKt.CoreTextField$lambda$22$0$1(textFieldSelectionManager, legacyTextFieldState, z, z2, function1, textFieldValue, offsetMapping, density, i2, (Composer) obj, ((Integer) obj2).intValue());
                }
            }, composer, 54), composer, 48, 0);
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventEnd();
            }
        }
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Removed duplicated region for block: B:26:0x00e8  */
    /* JADX WARN: Removed duplicated region for block: B:32:0x010a  */
    /* JADX WARN: Removed duplicated region for block: B:35:0x0119  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public static final kotlin.Unit CoreTextField$lambda$22$0$1(androidx.compose.foundation.text.selection.TextFieldSelectionManager r14, androidx.compose.foundation.text.LegacyTextFieldState r15, boolean r16, boolean r17, kotlin.jvm.functions.Function1 r18, androidx.compose.ui.text.input.TextFieldValue r19, androidx.compose.ui.text.input.OffsetMapping r20, androidx.compose.ui.unit.Density r21, int r22, androidx.compose.runtime.Composer r23, int r24) {
        /*
            Method dump skipped, instruction units count: 291
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.compose.foundation.text.CoreTextFieldKt.CoreTextField$lambda$22$0$1(androidx.compose.foundation.text.selection.TextFieldSelectionManager, androidx.compose.foundation.text.LegacyTextFieldState, boolean, boolean, kotlin.jvm.functions.Function1, androidx.compose.ui.text.input.TextFieldValue, androidx.compose.ui.text.input.OffsetMapping, androidx.compose.ui.unit.Density, int, androidx.compose.runtime.Composer, int):kotlin.Unit");
    }

    private static final void CoreTextFieldRootBox(final Modifier modifier, final TextFieldSelectionManager textFieldSelectionManager, final Function2<? super Composer, ? super Integer, Unit> function2, Composer composer, final int i) {
        int i2;
        Composer composerStartRestartGroup = composer.startRestartGroup(2036174316);
        ComposerKt.sourceInformation(composerStartRestartGroup, "C(CoreTextFieldRootBox)N(modifier,manager,content)662@31212L83:CoreTextField.kt#423gt5");
        if ((i & 6) == 0) {
            i2 = (composerStartRestartGroup.changed(modifier) ? 4 : 2) | i;
        } else {
            i2 = i;
        }
        if ((i & 48) == 0) {
            i2 |= composerStartRestartGroup.changedInstance(textFieldSelectionManager) ? 32 : 16;
        }
        if ((i & RendererCapabilities.DECODER_SUPPORT_MASK) == 0) {
            i2 |= composerStartRestartGroup.changedInstance(function2) ? 256 : 128;
        }
        if (!composerStartRestartGroup.shouldExecute((i2 & 147) != 146, i2 & 1)) {
            composerStartRestartGroup.skipToGroupEnd();
        } else {
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(2036174316, i2, -1, "androidx.compose.foundation.text.CoreTextFieldRootBox (CoreTextField.kt:661)");
            }
            ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, 1042775818, "CC(Box)N(modifier,contentAlignment,propagateMinConstraints,content)71@3424L131:Box.kt#2w3rfo");
            MeasurePolicy measurePolicyMaybeCachedBoxMeasurePolicy = BoxKt.maybeCachedBoxMeasurePolicy(Alignment.INSTANCE.getTopStart(), true);
            ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, -1159599143, "CC(Layout)N(content,modifier,measurePolicy)81@3355L27,84@3521L415:Layout.kt#80mrfh");
            int iHashCode = Long.hashCode(ComposablesKt.getCurrentCompositeKeyHashCode(composerStartRestartGroup, 0));
            CompositionLocalMap currentCompositionLocalMap = composerStartRestartGroup.getCurrentCompositionLocalMap();
            Modifier modifierMaterializeModifier = ComposedModifierKt.materializeModifier(composerStartRestartGroup, modifier);
            Function0<ComposeUiNode> constructor = ComposeUiNode.INSTANCE.getConstructor();
            ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, -553112988, "CC(ReusableComposeNode)N(factory,update,content)410@16187L9:Composables.kt#9igjgp");
            if (!(composerStartRestartGroup.getApplier() instanceof Applier)) {
                ComposablesKt.invalidApplier();
            }
            composerStartRestartGroup.startReusableNode();
            if (composerStartRestartGroup.getInserting()) {
                composerStartRestartGroup.createNode(constructor);
            } else {
                composerStartRestartGroup.useNode();
            }
            Composer composerM5069constructorimpl = Updater.m5069constructorimpl(composerStartRestartGroup);
            Updater.m5077setimpl(composerM5069constructorimpl, measurePolicyMaybeCachedBoxMeasurePolicy, ComposeUiNode.INSTANCE.getSetMeasurePolicy());
            Updater.m5077setimpl(composerM5069constructorimpl, currentCompositionLocalMap, ComposeUiNode.INSTANCE.getSetResolvedCompositionLocals());
            Updater.m5077setimpl(composerM5069constructorimpl, Integer.valueOf(iHashCode), ComposeUiNode.INSTANCE.getSetCompositeKeyHash());
            Updater.m5075reconcileimpl(composerM5069constructorimpl, ComposeUiNode.INSTANCE.getApplyOnDeactivatedNodeAssertion());
            Updater.m5077setimpl(composerM5069constructorimpl, modifierMaterializeModifier, ComposeUiNode.INSTANCE.getSetModifier());
            ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, 1833054614, "C72@3469L9:Box.kt#2w3rfo");
            BoxScopeInstance boxScopeInstance = BoxScopeInstance.INSTANCE;
            ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, 1799443472, "C662@31260L33:CoreTextField.kt#423gt5");
            ContextMenu_androidKt.ContextMenuArea(textFieldSelectionManager, function2, composerStartRestartGroup, (i2 >> 3) & 126);
            ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
            ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
            composerStartRestartGroup.endNode();
            ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
            ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
            ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventEnd();
            }
        }
        ScopeUpdateScope scopeUpdateScopeEndRestartGroup = composerStartRestartGroup.endRestartGroup();
        if (scopeUpdateScopeEndRestartGroup != null) {
            scopeUpdateScopeEndRestartGroup.updateScope(new Function2() { // from class: androidx.compose.foundation.text.CoreTextFieldKt$$ExternalSyntheticLambda0
                @Override // kotlin.jvm.functions.Function2
                public final Object invoke(Object obj, Object obj2) {
                    return CoreTextFieldKt.CoreTextFieldRootBox$lambda$1(modifier, textFieldSelectionManager, function2, i, (Composer) obj, ((Integer) obj2).intValue());
                }
            });
        }
    }

    private static final Modifier previewKeyEventToDeselectOnBack(Modifier modifier, final LegacyTextFieldState legacyTextFieldState, final TextFieldSelectionManager textFieldSelectionManager) {
        return KeyInputModifierKt.onPreviewKeyEvent(modifier, new Function1<KeyEvent, Boolean>() { // from class: androidx.compose.foundation.text.CoreTextFieldKt.previewKeyEventToDeselectOnBack.1
            @Override // kotlin.jvm.functions.Function1
            public /* bridge */ /* synthetic */ Boolean invoke(KeyEvent keyEvent) {
                return m1711invokeZmokQxo(keyEvent.m7133unboximpl());
            }

            /* JADX INFO: renamed from: invoke-ZmokQxo, reason: not valid java name */
            public final Boolean m1711invokeZmokQxo(android.view.KeyEvent keyEvent) {
                boolean z;
                if (legacyTextFieldState.getHandleState() == HandleState.Selection && KeyEventHelpers_androidKt.m1716cancelsTextSelectionZmokQxo(keyEvent)) {
                    z = true;
                    TextFieldSelectionManager.m2363deselect_kEHs6E$foundation$default(textFieldSelectionManager, null, 1, null);
                } else {
                    z = false;
                }
                return Boolean.valueOf(z);
            }
        });
    }

    public static final void requestFocusAndShowKeyboardIfNeeded(LegacyTextFieldState legacyTextFieldState, FocusRequester focusRequester, boolean z) {
        SoftwareKeyboardController keyboardController;
        if (!legacyTextFieldState.getHasFocus()) {
            FocusRequester.m5628requestFocus3ESFkO8$default(focusRequester, 0, 1, null);
        } else {
            if (!z || (keyboardController = legacyTextFieldState.getKeyboardController()) == null) {
                return;
            }
            keyboardController.show();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void startInputSession(TextInputService textInputService, LegacyTextFieldState legacyTextFieldState, TextFieldValue textFieldValue, ImeOptions imeOptions, OffsetMapping offsetMapping) {
        legacyTextFieldState.setInputSession(TextFieldDelegate.INSTANCE.onFocus$foundation(textInputService, textFieldValue, legacyTextFieldState.getProcessor(), imeOptions, legacyTextFieldState.getOnValueChange(), legacyTextFieldState.getOnImeActionPerformed()));
        notifyFocusedRect(legacyTextFieldState, textFieldValue, offsetMapping);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void endInputSession(LegacyTextFieldState legacyTextFieldState) {
        TextInputSession inputSession = legacyTextFieldState.getInputSession();
        if (inputSession != null) {
            TextFieldDelegate.INSTANCE.onBlur$foundation(inputSession, legacyTextFieldState.getProcessor(), legacyTextFieldState.getOnValueChange());
        }
        legacyTextFieldState.setInputSession(null);
    }

    public static final Object bringSelectionEndIntoView(BringIntoViewRequester bringIntoViewRequester, TextFieldValue textFieldValue, TextDelegate textDelegate, TextLayoutResult textLayoutResult, OffsetMapping offsetMapping, Continuation<? super Unit> continuation) {
        Rect rect;
        int iOriginalToTransformed = offsetMapping.originalToTransformed(TextRange.m8270getMaximpl(textFieldValue.getSelection()));
        if (iOriginalToTransformed < textLayoutResult.getLayoutInput().getText().length()) {
            rect = textLayoutResult.getBoundingBox(iOriginalToTransformed);
        } else if (iOriginalToTransformed != 0) {
            rect = textLayoutResult.getBoundingBox(iOriginalToTransformed - 1);
        } else {
            rect = new Rect(0.0f, 0.0f, 1.0f, (int) (TextFieldDelegateKt.computeSizeForDefaultText$default(textDelegate.getStyle(), textDelegate.getDensity(), textDelegate.getFontFamilyResolver(), null, 0, 24, null) & 4294967295L));
        }
        Object objBringIntoView = bringIntoViewRequester.bringIntoView(rect, continuation);
        return objBringIntoView == IntrinsicsKt.getCOROUTINE_SUSPENDED() ? objBringIntoView : Unit.INSTANCE;
    }

    private static final void SelectionToolbarAndHandles(final TextFieldSelectionManager textFieldSelectionManager, final boolean z, Composer composer, final int i) {
        int i2;
        TextLayoutResultProxy layoutResult;
        TextLayoutResult value;
        Composer composerStartRestartGroup = composer.startRestartGroup(626339208);
        ComposerKt.sourceInformation(composerStartRestartGroup, "C(SelectionToolbarAndHandles)N(manager,show):CoreTextField.kt#423gt5");
        if ((i & 6) == 0) {
            i2 = (composerStartRestartGroup.changedInstance(textFieldSelectionManager) ? 4 : 2) | i;
        } else {
            i2 = i;
        }
        if ((i & 48) == 0) {
            i2 |= composerStartRestartGroup.changed(z) ? 32 : 16;
        }
        if (composerStartRestartGroup.shouldExecute((i2 & 19) != 18, i2 & 1)) {
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(626339208, i2, -1, "androidx.compose.foundation.text.SelectionToolbarAndHandles (CoreTextField.kt:1014)");
            }
            if (z) {
                composerStartRestartGroup.startReplaceGroup(1530097388);
                ComposerKt.sourceInformation(composerStartRestartGroup, "");
                LegacyTextFieldState state = textFieldSelectionManager.getState();
                TextLayoutResult textLayoutResult = null;
                if (state != null && (layoutResult = state.getLayoutResult()) != null && (value = layoutResult.getValue()) != null) {
                    LegacyTextFieldState state2 = textFieldSelectionManager.getState();
                    if (!(state2 != null ? state2.getIsLayoutResultStale() : true)) {
                        textLayoutResult = value;
                    }
                }
                if (textLayoutResult == null) {
                    composerStartRestartGroup.startReplaceGroup(1530097387);
                    composerStartRestartGroup.endReplaceGroup();
                } else {
                    composerStartRestartGroup.startReplaceGroup(1530097388);
                    ComposerKt.sourceInformation(composerStartRestartGroup, "");
                    if (TextRange.m8267getCollapsedimpl(textFieldSelectionManager.getValue$foundation().getSelection())) {
                        composerStartRestartGroup.startReplaceGroup(2110860558);
                        composerStartRestartGroup.endReplaceGroup();
                    } else {
                        composerStartRestartGroup.startReplaceGroup(2109807302);
                        ComposerKt.sourceInformation(composerStartRestartGroup, "");
                        int iOriginalToTransformed = textFieldSelectionManager.getOffsetMapping().originalToTransformed(TextRange.m8273getStartimpl(textFieldSelectionManager.getValue$foundation().getSelection()));
                        int iOriginalToTransformed2 = textFieldSelectionManager.getOffsetMapping().originalToTransformed(TextRange.m8268getEndimpl(textFieldSelectionManager.getValue$foundation().getSelection()));
                        ResolvedTextDirection bidiRunDirection = textLayoutResult.getBidiRunDirection(iOriginalToTransformed);
                        ResolvedTextDirection bidiRunDirection2 = textLayoutResult.getBidiRunDirection(Math.max(iOriginalToTransformed2 - 1, 0));
                        LegacyTextFieldState state3 = textFieldSelectionManager.getState();
                        if (state3 == null || !state3.getShowSelectionHandleStart()) {
                            composerStartRestartGroup.startReplaceGroup(2110490542);
                            composerStartRestartGroup.endReplaceGroup();
                        } else {
                            composerStartRestartGroup.startReplaceGroup(2110225306);
                            ComposerKt.sourceInformation(composerStartRestartGroup, "1030@46532L220");
                            TextFieldSelectionManagerKt.TextFieldSelectionHandle(true, bidiRunDirection, textFieldSelectionManager, composerStartRestartGroup, ((i2 << 6) & 896) | 6);
                            composerStartRestartGroup.endReplaceGroup();
                        }
                        LegacyTextFieldState state4 = textFieldSelectionManager.getState();
                        if (state4 == null || !state4.getShowSelectionHandleEnd()) {
                            composerStartRestartGroup.startReplaceGroup(2110838734);
                            composerStartRestartGroup.endReplaceGroup();
                        } else {
                            composerStartRestartGroup.startReplaceGroup(2110574459);
                            ComposerKt.sourceInformation(composerStartRestartGroup, "1037@46884L219");
                            TextFieldSelectionManagerKt.TextFieldSelectionHandle(false, bidiRunDirection2, textFieldSelectionManager, composerStartRestartGroup, ((i2 << 6) & 896) | 6);
                            composerStartRestartGroup.endReplaceGroup();
                        }
                        composerStartRestartGroup.endReplaceGroup();
                    }
                    LegacyTextFieldState state5 = textFieldSelectionManager.getState();
                    if (state5 != null) {
                        if (textFieldSelectionManager.isTextChanged$foundation()) {
                            state5.setShowFloatingToolbar(false);
                        }
                        if (state5.getHasFocus()) {
                            if (state5.getShowFloatingToolbar()) {
                                textFieldSelectionManager.showSelectionToolbar$foundation();
                            } else {
                                textFieldSelectionManager.hideSelectionToolbar$foundation();
                            }
                        }
                        Unit unit = Unit.INSTANCE;
                    }
                    composerStartRestartGroup.endReplaceGroup();
                }
                composerStartRestartGroup.endReplaceGroup();
            } else {
                composerStartRestartGroup.startReplaceGroup(1989076778);
                composerStartRestartGroup.endReplaceGroup();
                textFieldSelectionManager.hideSelectionToolbar$foundation();
            }
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventEnd();
            }
        } else {
            composerStartRestartGroup.skipToGroupEnd();
        }
        ScopeUpdateScope scopeUpdateScopeEndRestartGroup = composerStartRestartGroup.endRestartGroup();
        if (scopeUpdateScopeEndRestartGroup != null) {
            scopeUpdateScopeEndRestartGroup.updateScope(new Function2() { // from class: androidx.compose.foundation.text.CoreTextFieldKt$$ExternalSyntheticLambda8
                @Override // kotlin.jvm.functions.Function2
                public final Object invoke(Object obj, Object obj2) {
                    return CoreTextFieldKt.SelectionToolbarAndHandles$lambda$1(textFieldSelectionManager, z, i, (Composer) obj, ((Integer) obj2).intValue());
                }
            });
        }
    }

    public static final void TextFieldCursorHandle(final TextFieldSelectionManager textFieldSelectionManager, Composer composer, final int i) {
        int i2;
        AnnotatedString transformedText$foundation;
        Composer composerStartRestartGroup = composer.startRestartGroup(-1436003720);
        ComposerKt.sourceInformation(composerStartRestartGroup, "C(TextFieldCursorHandle)N(manager):CoreTextField.kt#423gt5");
        if ((i & 6) == 0) {
            i2 = (composerStartRestartGroup.changedInstance(textFieldSelectionManager) ? 4 : 2) | i;
        } else {
            i2 = i;
        }
        if (!composerStartRestartGroup.shouldExecute((i2 & 3) != 2, i2 & 1)) {
            composerStartRestartGroup.skipToGroupEnd();
        } else {
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(-1436003720, i2, -1, "androidx.compose.foundation.text.TextFieldCursorHandle (CoreTextField.kt:1061)");
            }
            LegacyTextFieldState state = textFieldSelectionManager.getState();
            if (state != null && state.getShowCursorHandle() && (transformedText$foundation = textFieldSelectionManager.getTransformedText$foundation()) != null && transformedText$foundation.length() > 0) {
                composerStartRestartGroup.startReplaceGroup(-2112351432);
                ComposerKt.sourceInformation(composerStartRestartGroup, "1063@48047L50,1064@48160L7,1066@48220L12,1068@48305L645,1080@48982L385,1065@48177L1201");
                ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, -1315066870, "CC(remember):CoreTextField.kt#9igjgp");
                boolean zChanged = composerStartRestartGroup.changed(textFieldSelectionManager);
                Object objRememberedValue = composerStartRestartGroup.rememberedValue();
                if (zChanged || objRememberedValue == Composer.INSTANCE.getEmpty()) {
                    objRememberedValue = textFieldSelectionManager.cursorDragObserver$foundation();
                    composerStartRestartGroup.updateRememberedValue(objRememberedValue);
                }
                final TextDragObserver textDragObserver = (TextDragObserver) objRememberedValue;
                ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
                ProvidableCompositionLocal<Density> localDensity = CompositionLocalsKt.getLocalDensity();
                ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, 2023513938, "CC(<get-current>):CompositionLocal.kt#9igjgp");
                Object objConsume = composerStartRestartGroup.consume(localDensity);
                ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
                final long jM2369getCursorPositiontuRUvjQ$foundation = textFieldSelectionManager.m2369getCursorPositiontuRUvjQ$foundation((Density) objConsume);
                ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, -1315061372, "CC(remember):CoreTextField.kt#9igjgp");
                boolean zChanged2 = composerStartRestartGroup.changed(jM2369getCursorPositiontuRUvjQ$foundation);
                OffsetProvider offsetProviderRememberedValue = composerStartRestartGroup.rememberedValue();
                if (zChanged2 || offsetProviderRememberedValue == Composer.INSTANCE.getEmpty()) {
                    offsetProviderRememberedValue = new OffsetProvider() { // from class: androidx.compose.foundation.text.CoreTextFieldKt$TextFieldCursorHandle$1$1
                        @Override // androidx.compose.foundation.text.selection.OffsetProvider
                        /* JADX INFO: renamed from: provide-F1C5BW0 */
                        public final long mo1654provideF1C5BW0() {
                            return jM2369getCursorPositiontuRUvjQ$foundation;
                        }
                    };
                    composerStartRestartGroup.updateRememberedValue(offsetProviderRememberedValue);
                }
                OffsetProvider offsetProvider = (OffsetProvider) offsetProviderRememberedValue;
                ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
                Modifier.Companion companion = Modifier.INSTANCE;
                ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, -1315058019, "CC(remember):CoreTextField.kt#9igjgp");
                boolean zChangedInstance = composerStartRestartGroup.changedInstance(textDragObserver) | composerStartRestartGroup.changedInstance(textFieldSelectionManager);
                PointerInputEventHandler pointerInputEventHandlerRememberedValue = composerStartRestartGroup.rememberedValue();
                if (zChangedInstance || pointerInputEventHandlerRememberedValue == Composer.INSTANCE.getEmpty()) {
                    pointerInputEventHandlerRememberedValue = new PointerInputEventHandler() { // from class: androidx.compose.foundation.text.CoreTextFieldKt$TextFieldCursorHandle$2$1

                        /* JADX INFO: renamed from: androidx.compose.foundation.text.CoreTextFieldKt$TextFieldCursorHandle$2$1$1, reason: invalid class name */
                        /* JADX INFO: compiled from: CoreTextField.kt */
                        @Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\n"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {2, 1, 0}, xi = 48)
                        @DebugMetadata(c = "androidx.compose.foundation.text.CoreTextFieldKt$TextFieldCursorHandle$2$1$1", f = "CoreTextField.kt", i = {}, l = {}, m = "invokeSuspend", n = {}, s = {}, v = 1)
                        static final class AnonymousClass1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
                            final /* synthetic */ TextFieldSelectionManager $manager;
                            final /* synthetic */ TextDragObserver $observer;
                            final /* synthetic */ PointerInputScope $this_pointerInput;
                            private /* synthetic */ Object L$0;
                            int label;

                            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                            AnonymousClass1(PointerInputScope pointerInputScope, TextDragObserver textDragObserver, TextFieldSelectionManager textFieldSelectionManager, Continuation<? super AnonymousClass1> continuation) {
                                super(2, continuation);
                                this.$this_pointerInput = pointerInputScope;
                                this.$observer = textDragObserver;
                                this.$manager = textFieldSelectionManager;
                            }

                            @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
                            public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
                                AnonymousClass1 anonymousClass1 = new AnonymousClass1(this.$this_pointerInput, this.$observer, this.$manager, continuation);
                                anonymousClass1.L$0 = obj;
                                return anonymousClass1;
                            }

                            @Override // kotlin.jvm.functions.Function2
                            public final Object invoke(CoroutineScope coroutineScope, Continuation<? super Unit> continuation) {
                                return ((AnonymousClass1) create(coroutineScope, continuation)).invokeSuspend(Unit.INSTANCE);
                            }

                            @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
                            public final Object invokeSuspend(Object obj) {
                                IntrinsicsKt.getCOROUTINE_SUSPENDED();
                                if (this.label == 0) {
                                    ResultKt.throwOnFailure(obj);
                                    CoroutineScope coroutineScope = (CoroutineScope) this.L$0;
                                    BuildersKt__Builders_commonKt.launch$default(coroutineScope, null, CoroutineStart.UNDISPATCHED, new C00281(this.$this_pointerInput, this.$observer, null), 1, null);
                                    BuildersKt__Builders_commonKt.launch$default(coroutineScope, null, CoroutineStart.UNDISPATCHED, new AnonymousClass2(this.$this_pointerInput, this.$manager, null), 1, null);
                                    return Unit.INSTANCE;
                                }
                                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                            }

                            /* JADX INFO: renamed from: androidx.compose.foundation.text.CoreTextFieldKt$TextFieldCursorHandle$2$1$1$1, reason: invalid class name and collision with other inner class name */
                            /* JADX INFO: compiled from: CoreTextField.kt */
                            @Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\n"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {2, 1, 0}, xi = 48)
                            @DebugMetadata(c = "androidx.compose.foundation.text.CoreTextFieldKt$TextFieldCursorHandle$2$1$1$1", f = "CoreTextField.kt", i = {}, l = {1074}, m = "invokeSuspend", n = {}, s = {}, v = 1)
                            static final class C00281 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
                                final /* synthetic */ TextDragObserver $observer;
                                final /* synthetic */ PointerInputScope $this_pointerInput;
                                int label;

                                /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                                C00281(PointerInputScope pointerInputScope, TextDragObserver textDragObserver, Continuation<? super C00281> continuation) {
                                    super(2, continuation);
                                    this.$this_pointerInput = pointerInputScope;
                                    this.$observer = textDragObserver;
                                }

                                @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
                                public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
                                    return new C00281(this.$this_pointerInput, this.$observer, continuation);
                                }

                                @Override // kotlin.jvm.functions.Function2
                                public final Object invoke(CoroutineScope coroutineScope, Continuation<? super Unit> continuation) {
                                    return ((C00281) create(coroutineScope, continuation)).invokeSuspend(Unit.INSTANCE);
                                }

                                @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
                                public final Object invokeSuspend(Object obj) {
                                    Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
                                    int i = this.label;
                                    if (i == 0) {
                                        ResultKt.throwOnFailure(obj);
                                        this.label = 1;
                                        if (LongPressTextDragObserverKt.detectDownAndDragGesturesWithObserver(this.$this_pointerInput, this.$observer, this) == coroutine_suspended) {
                                            return coroutine_suspended;
                                        }
                                    } else {
                                        if (i != 1) {
                                            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                                        }
                                        ResultKt.throwOnFailure(obj);
                                    }
                                    return Unit.INSTANCE;
                                }
                            }

                            /* JADX INFO: renamed from: androidx.compose.foundation.text.CoreTextFieldKt$TextFieldCursorHandle$2$1$1$2, reason: invalid class name */
                            /* JADX INFO: compiled from: CoreTextField.kt */
                            @Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\n"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {2, 1, 0}, xi = 48)
                            @DebugMetadata(c = "androidx.compose.foundation.text.CoreTextFieldKt$TextFieldCursorHandle$2$1$1$2", f = "CoreTextField.kt", i = {}, l = {1077}, m = "invokeSuspend", n = {}, s = {}, v = 1)
                            static final class AnonymousClass2 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
                                final /* synthetic */ TextFieldSelectionManager $manager;
                                final /* synthetic */ PointerInputScope $this_pointerInput;
                                int label;

                                /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                                AnonymousClass2(PointerInputScope pointerInputScope, TextFieldSelectionManager textFieldSelectionManager, Continuation<? super AnonymousClass2> continuation) {
                                    super(2, continuation);
                                    this.$this_pointerInput = pointerInputScope;
                                    this.$manager = textFieldSelectionManager;
                                }

                                @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
                                public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
                                    return new AnonymousClass2(this.$this_pointerInput, this.$manager, continuation);
                                }

                                @Override // kotlin.jvm.functions.Function2
                                public final Object invoke(CoroutineScope coroutineScope, Continuation<? super Unit> continuation) {
                                    return ((AnonymousClass2) create(coroutineScope, continuation)).invokeSuspend(Unit.INSTANCE);
                                }

                                @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
                                public final Object invokeSuspend(Object obj) {
                                    Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
                                    int i = this.label;
                                    if (i == 0) {
                                        ResultKt.throwOnFailure(obj);
                                        PointerInputScope pointerInputScope = this.$this_pointerInput;
                                        final TextFieldSelectionManager textFieldSelectionManager = this.$manager;
                                        this.label = 1;
                                        if (TapGestureDetectorKt.detectTapGestures$default(pointerInputScope, null, null, null, 
                                        /*  JADX ERROR: Method code generation error
                                            jadx.core.utils.exceptions.JadxRuntimeException: Expected class to be processed at this point, class: androidx.compose.foundation.text.CoreTextFieldKt$TextFieldCursorHandle$2$1$1$2$$ExternalSyntheticLambda0, state: NOT_LOADED
                                            	at jadx.core.dex.nodes.ClassNode.ensureProcessed(ClassNode.java:306)
                                            	at jadx.core.codegen.InsnGen.inlineAnonymousConstructor(InsnGen.java:807)
                                            	at jadx.core.codegen.InsnGen.makeConstructor(InsnGen.java:730)
                                            	at jadx.core.codegen.InsnGen.makeInsnBody(InsnGen.java:418)
                                            	at jadx.core.codegen.InsnGen.addWrappedArg(InsnGen.java:145)
                                            	at jadx.core.codegen.InsnGen.addArg(InsnGen.java:121)
                                            	at jadx.core.codegen.InsnGen.addArg(InsnGen.java:108)
                                            	at jadx.core.codegen.InsnGen.generateMethodArguments(InsnGen.java:1143)
                                            	at jadx.core.codegen.InsnGen.makeInvoke(InsnGen.java:910)
                                            	at jadx.core.codegen.InsnGen.makeInsnBody(InsnGen.java:422)
                                            	at jadx.core.codegen.InsnGen.addWrappedArg(InsnGen.java:145)
                                            	at jadx.core.codegen.InsnGen.addArg(InsnGen.java:121)
                                            	at jadx.core.codegen.InsnGen.addArg(InsnGen.java:108)
                                            	at jadx.core.codegen.ConditionGen.addCompare(ConditionGen.java:129)
                                            	at jadx.core.codegen.ConditionGen.add(ConditionGen.java:57)
                                            	at jadx.core.codegen.ConditionGen.add(ConditionGen.java:46)
                                            	at jadx.core.codegen.RegionGen.makeIf(RegionGen.java:115)
                                            	at jadx.core.dex.regions.conditions.IfRegion.generate(IfRegion.java:90)
                                            	at jadx.core.codegen.RegionGen.makeRegion(RegionGen.java:66)
                                            	at jadx.core.dex.regions.Region.generate(Region.java:35)
                                            	at jadx.core.codegen.RegionGen.makeRegion(RegionGen.java:66)
                                            	at jadx.core.codegen.RegionGen.makeRegionIndent(RegionGen.java:83)
                                            	at jadx.core.codegen.RegionGen.makeIf(RegionGen.java:126)
                                            	at jadx.core.dex.regions.conditions.IfRegion.generate(IfRegion.java:90)
                                            	at jadx.core.codegen.RegionGen.makeRegion(RegionGen.java:66)
                                            	at jadx.core.dex.regions.Region.generate(Region.java:35)
                                            	at jadx.core.codegen.RegionGen.makeRegion(RegionGen.java:66)
                                            	at jadx.core.codegen.MethodGen.addRegionInsns(MethodGen.java:305)
                                            	at jadx.core.codegen.MethodGen.addInstructions(MethodGen.java:284)
                                            	at jadx.core.codegen.ClassGen.addMethodCode(ClassGen.java:412)
                                            	at jadx.core.codegen.ClassGen.addMethod(ClassGen.java:337)
                                            	at jadx.core.codegen.ClassGen.lambda$addInnerClsAndMethods$2(ClassGen.java:303)
                                            	at java.base/java.util.stream.ForEachOps$ForEachOp$OfRef.accept(ForEachOps.java:186)
                                            	at java.base/java.util.ArrayList.forEach(ArrayList.java:1612)
                                            	at java.base/java.util.stream.SortedOps$RefSortingSink.end(SortedOps.java:395)
                                            	at java.base/java.util.stream.Sink$ChainedReference.end(Sink.java:261)
                                            	at java.base/java.util.stream.ReferencePipeline$7$1FlatMap.end(ReferencePipeline.java:284)
                                            	at java.base/java.util.stream.AbstractPipeline.copyInto(AbstractPipeline.java:571)
                                            	at java.base/java.util.stream.AbstractPipeline.wrapAndCopyInto(AbstractPipeline.java:560)
                                            	at java.base/java.util.stream.ForEachOps$ForEachOp.evaluateSequential(ForEachOps.java:153)
                                            	at java.base/java.util.stream.ForEachOps$ForEachOp$OfRef.evaluateSequential(ForEachOps.java:176)
                                            	at java.base/java.util.stream.AbstractPipeline.evaluate(AbstractPipeline.java:265)
                                            	at java.base/java.util.stream.ReferencePipeline.forEach(ReferencePipeline.java:632)
                                            	at jadx.core.codegen.ClassGen.addInnerClsAndMethods(ClassGen.java:299)
                                            	at jadx.core.codegen.ClassGen.addClassBody(ClassGen.java:288)
                                            	at jadx.core.codegen.ClassGen.addClassBody(ClassGen.java:272)
                                            	at jadx.core.codegen.ClassGen.addClassCode(ClassGen.java:159)
                                            	at jadx.core.codegen.ClassGen.addInnerClass(ClassGen.java:312)
                                            	at jadx.core.codegen.ClassGen.lambda$addInnerClsAndMethods$2(ClassGen.java:301)
                                            	at java.base/java.util.stream.ForEachOps$ForEachOp$OfRef.accept(ForEachOps.java:186)
                                            	at java.base/java.util.ArrayList.forEach(ArrayList.java:1612)
                                            	at java.base/java.util.stream.SortedOps$RefSortingSink.end(SortedOps.java:395)
                                            	at java.base/java.util.stream.Sink$ChainedReference.end(Sink.java:261)
                                            	at java.base/java.util.stream.ReferencePipeline$7$1FlatMap.end(ReferencePipeline.java:284)
                                            	at java.base/java.util.stream.AbstractPipeline.copyInto(AbstractPipeline.java:571)
                                            	at java.base/java.util.stream.AbstractPipeline.wrapAndCopyInto(AbstractPipeline.java:560)
                                            	at java.base/java.util.stream.ForEachOps$ForEachOp.evaluateSequential(ForEachOps.java:153)
                                            	at java.base/java.util.stream.ForEachOps$ForEachOp$OfRef.evaluateSequential(ForEachOps.java:176)
                                            	at java.base/java.util.stream.AbstractPipeline.evaluate(AbstractPipeline.java:265)
                                            	at java.base/java.util.stream.ReferencePipeline.forEach(ReferencePipeline.java:632)
                                            	at jadx.core.codegen.ClassGen.addInnerClsAndMethods(ClassGen.java:299)
                                            	at jadx.core.codegen.ClassGen.addClassBody(ClassGen.java:288)
                                            	at jadx.core.codegen.ClassGen.addClassBody(ClassGen.java:272)
                                            	at jadx.core.codegen.ClassGen.addClassCode(ClassGen.java:159)
                                            	at jadx.core.codegen.ClassGen.addInnerClass(ClassGen.java:312)
                                            	at jadx.core.codegen.ClassGen.lambda$addInnerClsAndMethods$2(ClassGen.java:301)
                                            	at java.base/java.util.stream.ForEachOps$ForEachOp$OfRef.accept(ForEachOps.java:186)
                                            	at java.base/java.util.ArrayList.forEach(ArrayList.java:1612)
                                            	at java.base/java.util.stream.SortedOps$RefSortingSink.end(SortedOps.java:395)
                                            	at java.base/java.util.stream.Sink$ChainedReference.end(Sink.java:261)
                                            	at java.base/java.util.stream.ReferencePipeline$7$1FlatMap.end(ReferencePipeline.java:284)
                                            	at java.base/java.util.stream.AbstractPipeline.copyInto(AbstractPipeline.java:571)
                                            	at java.base/java.util.stream.AbstractPipeline.wrapAndCopyInto(AbstractPipeline.java:560)
                                            	at java.base/java.util.stream.ForEachOps$ForEachOp.evaluateSequential(ForEachOps.java:153)
                                            	at java.base/java.util.stream.ForEachOps$ForEachOp$OfRef.evaluateSequential(ForEachOps.java:176)
                                            	at java.base/java.util.stream.AbstractPipeline.evaluate(AbstractPipeline.java:265)
                                            	at java.base/java.util.stream.ReferencePipeline.forEach(ReferencePipeline.java:632)
                                            	at jadx.core.codegen.ClassGen.addInnerClsAndMethods(ClassGen.java:299)
                                            	at jadx.core.codegen.ClassGen.addClassBody(ClassGen.java:288)
                                            	at jadx.core.codegen.InsnGen.inlineAnonymousConstructor(InsnGen.java:845)
                                            	at jadx.core.codegen.InsnGen.makeConstructor(InsnGen.java:730)
                                            	at jadx.core.codegen.InsnGen.makeInsnBody(InsnGen.java:418)
                                            	at jadx.core.codegen.InsnGen.makeInsn(InsnGen.java:303)
                                            	at jadx.core.codegen.InsnGen.makeInsn(InsnGen.java:273)
                                            	at jadx.core.codegen.RegionGen.makeSimpleBlock(RegionGen.java:94)
                                            	at jadx.core.dex.nodes.IBlock.generate(IBlock.java:15)
                                            	at jadx.core.codegen.RegionGen.makeRegion(RegionGen.java:66)
                                            	at jadx.core.dex.regions.Region.generate(Region.java:35)
                                            	at jadx.core.codegen.RegionGen.makeRegion(RegionGen.java:66)
                                            	at jadx.core.codegen.RegionGen.makeRegionIndent(RegionGen.java:83)
                                            	at jadx.core.codegen.RegionGen.makeIf(RegionGen.java:126)
                                            	at jadx.core.dex.regions.conditions.IfRegion.generate(IfRegion.java:90)
                                            	at jadx.core.codegen.RegionGen.makeRegion(RegionGen.java:66)
                                            	at jadx.core.dex.regions.Region.generate(Region.java:35)
                                            	at jadx.core.codegen.RegionGen.makeRegion(RegionGen.java:66)
                                            	at jadx.core.codegen.RegionGen.makeRegionIndent(RegionGen.java:83)
                                            	at jadx.core.codegen.RegionGen.makeIf(RegionGen.java:126)
                                            	at jadx.core.dex.regions.conditions.IfRegion.generate(IfRegion.java:90)
                                            	at jadx.core.codegen.RegionGen.makeRegion(RegionGen.java:66)
                                            	at jadx.core.dex.regions.Region.generate(Region.java:35)
                                            	at jadx.core.codegen.RegionGen.makeRegion(RegionGen.java:66)
                                            	at jadx.core.codegen.RegionGen.makeRegionIndent(RegionGen.java:83)
                                            	at jadx.core.codegen.RegionGen.makeIf(RegionGen.java:140)
                                            	at jadx.core.dex.regions.conditions.IfRegion.generate(IfRegion.java:90)
                                            	at jadx.core.codegen.RegionGen.makeRegion(RegionGen.java:66)
                                            	at jadx.core.dex.regions.Region.generate(Region.java:35)
                                            	at jadx.core.codegen.RegionGen.makeRegion(RegionGen.java:66)
                                            	at jadx.core.codegen.MethodGen.addRegionInsns(MethodGen.java:305)
                                            	at jadx.core.codegen.MethodGen.addInstructions(MethodGen.java:284)
                                            	at jadx.core.codegen.ClassGen.addMethodCode(ClassGen.java:412)
                                            	at jadx.core.codegen.ClassGen.addMethod(ClassGen.java:337)
                                            	at jadx.core.codegen.ClassGen.lambda$addInnerClsAndMethods$2(ClassGen.java:303)
                                            	at java.base/java.util.stream.ForEachOps$ForEachOp$OfRef.accept(ForEachOps.java:186)
                                            	at java.base/java.util.ArrayList.forEach(ArrayList.java:1612)
                                            	at java.base/java.util.stream.SortedOps$RefSortingSink.end(SortedOps.java:395)
                                            	at java.base/java.util.stream.Sink$ChainedReference.end(Sink.java:261)
                                            	at java.base/java.util.stream.ReferencePipeline$7$1FlatMap.end(ReferencePipeline.java:284)
                                            	at java.base/java.util.stream.AbstractPipeline.copyInto(AbstractPipeline.java:571)
                                            	at java.base/java.util.stream.AbstractPipeline.wrapAndCopyInto(AbstractPipeline.java:560)
                                            	at java.base/java.util.stream.ForEachOps$ForEachOp.evaluateSequential(ForEachOps.java:153)
                                            	at java.base/java.util.stream.ForEachOps$ForEachOp$OfRef.evaluateSequential(ForEachOps.java:176)
                                            	at java.base/java.util.stream.AbstractPipeline.evaluate(AbstractPipeline.java:265)
                                            	at java.base/java.util.stream.ReferencePipeline.forEach(ReferencePipeline.java:632)
                                            	at jadx.core.codegen.ClassGen.addInnerClsAndMethods(ClassGen.java:299)
                                            	at jadx.core.codegen.ClassGen.addClassBody(ClassGen.java:288)
                                            	at jadx.core.codegen.ClassGen.addClassBody(ClassGen.java:272)
                                            	at jadx.core.codegen.ClassGen.addClassCode(ClassGen.java:159)
                                            	at jadx.core.codegen.ClassGen.makeClass(ClassGen.java:103)
                                            	at jadx.core.codegen.CodeGen.wrapCodeGen(CodeGen.java:45)
                                            	at jadx.core.codegen.CodeGen.generateJavaCode(CodeGen.java:34)
                                            	at jadx.core.codegen.CodeGen.generate(CodeGen.java:22)
                                            	at jadx.core.ProcessClass.process(ProcessClass.java:88)
                                            	at jadx.core.ProcessClass.generateCode(ProcessClass.java:126)
                                            	at jadx.core.dex.nodes.ClassNode.generateClassCode(ClassNode.java:405)
                                            	at jadx.core.dex.nodes.ClassNode.decompile(ClassNode.java:393)
                                            	at jadx.core.dex.nodes.ClassNode.getCode(ClassNode.java:343)
                                            */
                                        /*
                                            this = this;
                                            java.lang.Object r0 = kotlin.coroutines.intrinsics.IntrinsicsKt.getCOROUTINE_SUSPENDED()
                                            int r1 = r9.label
                                            r2 = 1
                                            if (r1 == 0) goto L17
                                            if (r1 != r2) goto Lf
                                            kotlin.ResultKt.throwOnFailure(r10)
                                            goto L34
                                        Lf:
                                            java.lang.IllegalStateException r10 = new java.lang.IllegalStateException
                                            java.lang.String r0 = "call to 'resume' before 'invoke' with coroutine"
                                            r10.<init>(r0)
                                            throw r10
                                        L17:
                                            kotlin.ResultKt.throwOnFailure(r10)
                                            androidx.compose.ui.input.pointer.PointerInputScope r1 = r9.$this_pointerInput
                                            androidx.compose.foundation.text.selection.TextFieldSelectionManager r10 = r9.$manager
                                            androidx.compose.foundation.text.CoreTextFieldKt$TextFieldCursorHandle$2$1$1$2$$ExternalSyntheticLambda0 r5 = new androidx.compose.foundation.text.CoreTextFieldKt$TextFieldCursorHandle$2$1$1$2$$ExternalSyntheticLambda0
                                            r5.<init>(r10)
                                            r6 = r9
                                            kotlin.coroutines.Continuation r6 = (kotlin.coroutines.Continuation) r6
                                            r9.label = r2
                                            r2 = 0
                                            r3 = 0
                                            r4 = 0
                                            r7 = 7
                                            r8 = 0
                                            java.lang.Object r10 = androidx.compose.foundation.gestures.TapGestureDetectorKt.detectTapGestures$default(r1, r2, r3, r4, r5, r6, r7, r8)
                                            if (r10 != r0) goto L34
                                            return r0
                                        L34:
                                            kotlin.Unit r10 = kotlin.Unit.INSTANCE
                                            return r10
                                        */
                                        throw new UnsupportedOperationException("Method not decompiled: androidx.compose.foundation.text.CoreTextFieldKt$TextFieldCursorHandle$2$1.AnonymousClass1.AnonymousClass2.invokeSuspend(java.lang.Object):java.lang.Object");
                                    }

                                    /* JADX INFO: Access modifiers changed from: private */
                                    public static final Unit invokeSuspend$lambda$0(TextFieldSelectionManager textFieldSelectionManager, Offset offset) {
                                        textFieldSelectionManager.showSelectionToolbar$foundation();
                                        return Unit.INSTANCE;
                                    }
                                }
                            }

                            @Override // androidx.compose.ui.input.pointer.PointerInputEventHandler
                            public final Object invoke(PointerInputScope pointerInputScope, Continuation<? super Unit> continuation) {
                                Object objCoroutineScope = CoroutineScopeKt.coroutineScope(new AnonymousClass1(pointerInputScope, textDragObserver, textFieldSelectionManager, null), continuation);
                                return objCoroutineScope == IntrinsicsKt.getCOROUTINE_SUSPENDED() ? objCoroutineScope : Unit.INSTANCE;
                            }
                        };
                        composerStartRestartGroup.updateRememberedValue(pointerInputEventHandlerRememberedValue);
                    }
                    ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
                    Modifier modifierPointerInput = SuspendingPointerInputFilterKt.pointerInput(companion, textDragObserver, (PointerInputEventHandler) pointerInputEventHandlerRememberedValue);
                    ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, -1315036615, "CC(remember):CoreTextField.kt#9igjgp");
                    boolean zChanged3 = composerStartRestartGroup.changed(jM2369getCursorPositiontuRUvjQ$foundation);
                    Object objRememberedValue2 = composerStartRestartGroup.rememberedValue();
                    if (zChanged3 || objRememberedValue2 == Composer.INSTANCE.getEmpty()) {
                        objRememberedValue2 = new Function1() { // from class: androidx.compose.foundation.text.CoreTextFieldKt$$ExternalSyntheticLambda6
                            @Override // kotlin.jvm.functions.Function1
                            public final Object invoke(Object obj) {
                                return CoreTextFieldKt.TextFieldCursorHandle$lambda$3$0(jM2369getCursorPositiontuRUvjQ$foundation, (SemanticsPropertyReceiver) obj);
                            }
                        };
                        composerStartRestartGroup.updateRememberedValue(objRememberedValue2);
                    }
                    ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
                    AndroidCursorHandle_androidKt.m1634CursorHandleUSBMPiE(offsetProvider, SemanticsModifierKt.semantics$default(modifierPointerInput, false, (Function1) objRememberedValue2, 1, null), 0L, composerStartRestartGroup, 0, 4);
                    composerStartRestartGroup.endReplaceGroup();
                } else {
                    composerStartRestartGroup.startReplaceGroup(-2111042550);
                    composerStartRestartGroup.endReplaceGroup();
                }
                if (ComposerKt.isTraceInProgress()) {
                    ComposerKt.traceEventEnd();
                }
            }
            ScopeUpdateScope scopeUpdateScopeEndRestartGroup = composerStartRestartGroup.endRestartGroup();
            if (scopeUpdateScopeEndRestartGroup != null) {
                scopeUpdateScopeEndRestartGroup.updateScope(new Function2() { // from class: androidx.compose.foundation.text.CoreTextFieldKt$$ExternalSyntheticLambda7
                    @Override // kotlin.jvm.functions.Function2
                    public final Object invoke(Object obj, Object obj2) {
                        return CoreTextFieldKt.TextFieldCursorHandle$lambda$4(textFieldSelectionManager, i, (Composer) obj, ((Integer) obj2).intValue());
                    }
                });
            }
        }

        /* JADX INFO: Access modifiers changed from: private */
        public static final Unit TextFieldCursorHandle$lambda$3$0(long j, SemanticsPropertyReceiver semanticsPropertyReceiver) {
            semanticsPropertyReceiver.set(SelectionHandlesKt.getSelectionHandleInfoKey(), new SelectionHandleInfo(Handle.Cursor, j, SelectionHandleAnchor.Middle, true, null));
            return Unit.INSTANCE;
        }

        public static final Modifier defaultTextFieldDraw(Modifier modifier, final LegacyTextFieldState legacyTextFieldState, final TextFieldValue textFieldValue, final OffsetMapping offsetMapping) {
            return DrawModifierKt.drawBehind(modifier, new Function1() { // from class: androidx.compose.foundation.text.CoreTextFieldKt$$ExternalSyntheticLambda12
                @Override // kotlin.jvm.functions.Function1
                public final Object invoke(Object obj) {
                    return CoreTextFieldKt.defaultTextFieldDraw$lambda$0(legacyTextFieldState, textFieldValue, offsetMapping, (DrawScope) obj);
                }
            });
        }

        /* JADX INFO: Access modifiers changed from: private */
        public static final Unit defaultTextFieldDraw$lambda$0(LegacyTextFieldState legacyTextFieldState, TextFieldValue textFieldValue, OffsetMapping offsetMapping, DrawScope drawScope) {
            TextLayoutResultProxy layoutResult = legacyTextFieldState.getLayoutResult();
            if (layoutResult != null) {
                TextFieldDelegate.INSTANCE.m1827drawQ1vqE60$foundation(drawScope.getDrawContext().getCanvas(), textFieldValue, legacyTextFieldState.m1785getSelectionPreviewHighlightRanged9O1mEE(), legacyTextFieldState.m1782getDeletionPreviewHighlightRanged9O1mEE(), offsetMapping, layoutResult.getValue(), legacyTextFieldState.getHighlightPaint(), legacyTextFieldState.getSelectionBackgroundColor());
            }
            return Unit.INSTANCE;
        }

        /* JADX INFO: Access modifiers changed from: private */
        public static final void notifyFocusedRect(LegacyTextFieldState legacyTextFieldState, TextFieldValue textFieldValue, OffsetMapping offsetMapping) {
            Snapshot.Companion companion = Snapshot.INSTANCE;
            Snapshot currentThreadSnapshot = companion.getCurrentThreadSnapshot();
            Function1<Object, Unit> readObserver = currentThreadSnapshot != null ? currentThreadSnapshot.getReadObserver() : null;
            Snapshot snapshotMakeCurrentNonObservable = companion.makeCurrentNonObservable(currentThreadSnapshot);
            try {
                TextLayoutResultProxy layoutResult = legacyTextFieldState.getLayoutResult();
                if (layoutResult == null) {
                    return;
                }
                TextInputSession inputSession = legacyTextFieldState.getInputSession();
                if (inputSession == null) {
                    return;
                }
                LayoutCoordinates layoutCoordinates = legacyTextFieldState.getLayoutCoordinates();
                if (layoutCoordinates == null) {
                    return;
                }
                TextFieldDelegate.INSTANCE.notifyFocusedRect$foundation(textFieldValue, legacyTextFieldState.getTextDelegate(), layoutResult.getValue(), layoutCoordinates, inputSession, legacyTextFieldState.getHasFocus(), offsetMapping);
                Unit unit = Unit.INSTANCE;
            } finally {
                companion.restoreNonObservable(currentThreadSnapshot, snapshotMakeCurrentNonObservable, readObserver);
            }
        }

        private static final Modifier addContextMenuComponents(Modifier modifier, TextFieldSelectionManager textFieldSelectionManager, CoroutineScope coroutineScope) {
            return ComposeFoundationFlags.isNewContextMenuEnabled ? TextFieldSelectionManager_androidKt.addBasicTextFieldTextContextMenuComponents(modifier, textFieldSelectionManager, coroutineScope) : modifier;
        }

        /* JADX INFO: Access modifiers changed from: private */
        public static final DisposableEffectResult CoreTextField$lambda$17$0(final TextFieldSelectionManager textFieldSelectionManager, DisposableEffectScope disposableEffectScope) {
            return new DisposableEffectResult() { // from class: androidx.compose.foundation.text.CoreTextFieldKt$CoreTextField$lambda$17$0$$inlined$onDispose$1
                @Override // androidx.compose.runtime.DisposableEffectResult
                public void dispose() {
                    textFieldSelectionManager.hideSelectionToolbar$foundation();
                }
            };
        }

        /* JADX INFO: Access modifiers changed from: private */
        public static final boolean CoreTextField$lambda$14(State<Boolean> state) {
            return state.getValue().booleanValue();
        }
    }
