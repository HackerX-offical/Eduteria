package androidx.compose.foundation.text;

import androidx.compose.foundation.ComposeFoundationFlags;
import androidx.compose.foundation.ScrollState;
import androidx.compose.foundation.gestures.Orientation;
import androidx.compose.foundation.interaction.MutableInteractionSource;
import androidx.compose.foundation.layout.BoxKt;
import androidx.compose.foundation.layout.BoxScopeInstance;
import androidx.compose.foundation.layout.SizeKt;
import androidx.compose.foundation.text.contextmenu.modifier.ToolbarRequesterImpl;
import androidx.compose.foundation.text.input.InputTransformation;
import androidx.compose.foundation.text.input.KeyboardActionHandler;
import androidx.compose.foundation.text.input.OutputTransformation;
import androidx.compose.foundation.text.input.TextFieldDecorator;
import androidx.compose.foundation.text.input.TextFieldLineLimits;
import androidx.compose.foundation.text.input.TextFieldState;
import androidx.compose.foundation.text.input.internal.CodepointTransformation;
import androidx.compose.foundation.text.input.internal.TextFieldCoreModifier;
import androidx.compose.foundation.text.input.internal.TextFieldTextLayoutModifier;
import androidx.compose.foundation.text.input.internal.TextLayoutState;
import androidx.compose.foundation.text.input.internal.TransformedTextFieldState;
import androidx.compose.foundation.text.input.internal.selection.TextFieldHandleState;
import androidx.compose.foundation.text.input.internal.selection.TextFieldSelectionState;
import androidx.compose.foundation.text.input.internal.selection.TextFieldSelectionState_androidKt;
import androidx.compose.foundation.text.selection.AndroidSelectionHandles_androidKt;
import androidx.compose.foundation.text.selection.OffsetProvider;
import androidx.compose.foundation.text.selection.PlatformSelectionBehaviors;
import androidx.compose.runtime.Applier;
import androidx.compose.runtime.ComposablesKt;
import androidx.compose.runtime.Composer;
import androidx.compose.runtime.ComposerKt;
import androidx.compose.runtime.CompositionLocalMap;
import androidx.compose.runtime.DisposableEffectResult;
import androidx.compose.runtime.DisposableEffectScope;
import androidx.compose.runtime.MutableState;
import androidx.compose.runtime.RecomposeScopeImplKt;
import androidx.compose.runtime.ScopeUpdateScope;
import androidx.compose.runtime.SnapshotStateKt;
import androidx.compose.runtime.State;
import androidx.compose.runtime.Updater;
import androidx.compose.runtime.internal.ComposableLambdaKt;
import androidx.compose.ui.Alignment;
import androidx.compose.ui.ComposedModifierKt;
import androidx.compose.ui.Modifier;
import androidx.compose.ui.draw.ClipKt;
import androidx.compose.ui.graphics.Brush;
import androidx.compose.ui.hapticfeedback.HapticFeedback;
import androidx.compose.ui.input.pointer.PointerInputEventHandler;
import androidx.compose.ui.input.pointer.PointerInputScope;
import androidx.compose.ui.input.pointer.SuspendingPointerInputFilterKt;
import androidx.compose.ui.layout.LayoutModifierKt;
import androidx.compose.ui.layout.Measurable;
import androidx.compose.ui.layout.MeasurePolicy;
import androidx.compose.ui.layout.MeasureResult;
import androidx.compose.ui.layout.MeasureScope;
import androidx.compose.ui.layout.Placeable;
import androidx.compose.ui.node.ComposeUiNode;
import androidx.compose.ui.platform.Clipboard;
import androidx.compose.ui.text.AnnotatedString;
import androidx.compose.ui.text.TextLayoutResult;
import androidx.compose.ui.text.TextRange;
import androidx.compose.ui.text.TextStyle;
import androidx.compose.ui.text.input.TextFieldValue;
import androidx.compose.ui.text.input.VisualTransformation;
import androidx.compose.ui.text.style.ResolvedTextDirection;
import androidx.compose.ui.unit.Constraints;
import androidx.compose.ui.unit.ConstraintsKt;
import androidx.compose.ui.unit.Density;
import androidx.compose.ui.unit.Dp;
import androidx.compose.ui.unit.DpKt;
import androidx.media3.exoplayer.RendererCapabilities;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.functions.Function3;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.coroutines.CoroutineScope;
import kotlinx.coroutines.flow.MutableSharedFlow;
import org.jivesoftware.smack.sm.packet.StreamManagement;

/* JADX INFO: compiled from: BasicTextField.kt */
/* JADX INFO: loaded from: classes.dex */
@Metadata(d1 = {"\u0000Ø\u0001\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0003\u001aÛ\u0001\u0010\u0000\u001a\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u00052\b\b\u0002\u0010\u0006\u001a\u00020\u00072\b\b\u0002\u0010\b\u001a\u00020\u00072\n\b\u0002\u0010\t\u001a\u0004\u0018\u00010\n2\b\b\u0002\u0010\u000b\u001a\u00020\f2\b\b\u0002\u0010\r\u001a\u00020\u000e2\n\b\u0002\u0010\u000f\u001a\u0004\u0018\u00010\u00102\b\b\u0002\u0010\u0011\u001a\u00020\u001228\b\u0002\u0010\u0013\u001a2\u0012\u0004\u0012\u00020\u0015\u0012\u001b\u0012\u0019\u0012\u0006\u0012\u0004\u0018\u00010\u00170\u0016¢\u0006\f\b\u0018\u0012\b\b\u0019\u0012\u0004\b\b(\u001a\u0012\u0004\u0012\u00020\u0001\u0018\u00010\u0014¢\u0006\u0002\b\u001b2\n\b\u0002\u0010\u001c\u001a\u0004\u0018\u00010\u001d2\b\b\u0002\u0010\u001e\u001a\u00020\u001f2\n\b\u0002\u0010 \u001a\u0004\u0018\u00010!2\n\b\u0002\u0010\"\u001a\u0004\u0018\u00010#2\b\b\u0002\u0010$\u001a\u00020%H\u0007¢\u0006\u0002\u0010&\u001añ\u0001\u0010\u0000\u001a\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u00052\b\b\u0002\u0010\u0006\u001a\u00020\u00072\b\b\u0002\u0010\b\u001a\u00020\u00072\n\b\u0002\u0010\t\u001a\u0004\u0018\u00010\n2\b\b\u0002\u0010\u000b\u001a\u00020\f2\b\b\u0002\u0010\r\u001a\u00020\u000e2\n\b\u0002\u0010\u000f\u001a\u0004\u0018\u00010\u00102\b\b\u0002\u0010\u0011\u001a\u00020\u001228\b\u0002\u0010\u0013\u001a2\u0012\u0004\u0012\u00020\u0015\u0012\u001b\u0012\u0019\u0012\u0006\u0012\u0004\u0018\u00010\u00170\u0016¢\u0006\f\b\u0018\u0012\b\b\u0019\u0012\u0004\b\b(\u001a\u0012\u0004\u0012\u00020\u0001\u0018\u00010\u0014¢\u0006\u0002\b\u001b2\n\b\u0002\u0010\u001c\u001a\u0004\u0018\u00010\u001d2\b\b\u0002\u0010\u001e\u001a\u00020\u001f2\n\b\u0002\u0010'\u001a\u0004\u0018\u00010(2\n\b\u0002\u0010 \u001a\u0004\u0018\u00010!2\n\b\u0002\u0010\"\u001a\u0004\u0018\u00010#2\b\b\u0002\u0010$\u001a\u00020%2\b\b\u0002\u0010)\u001a\u00020\u0007H\u0001¢\u0006\u0002\u0010*\u001a\u0014\u0010+\u001a\u00020\u0005*\u00020\u00052\u0006\u0010,\u001a\u00020-H\u0002\u001a\u001c\u0010.\u001a\u00020\u0005*\u00020\u00052\u0006\u0010/\u001a\u0002002\u0006\u00101\u001a\u000202H\u0002\u001a\u0015\u00103\u001a\u00020\u00012\u0006\u00104\u001a\u000200H\u0001¢\u0006\u0002\u00105\u001a\u0015\u00106\u001a\u00020\u00012\u0006\u00104\u001a\u000200H\u0001¢\u0006\u0002\u00105\u001aî\u0001\u0010\u0000\u001a\u00020\u00012\u0006\u0010;\u001a\u00020<2\u0012\u0010=\u001a\u000e\u0012\u0004\u0012\u00020<\u0012\u0004\u0012\u00020\u00010>2\b\b\u0002\u0010\u0004\u001a\u00020\u00052\b\b\u0002\u0010\u0006\u001a\u00020\u00072\b\b\u0002\u0010\b\u001a\u00020\u00072\b\b\u0002\u0010\u000b\u001a\u00020\f2\b\b\u0002\u0010\r\u001a\u00020\u000e2\b\b\u0002\u0010?\u001a\u00020@2\b\b\u0002\u0010A\u001a\u00020\u00072\b\b\u0002\u0010B\u001a\u00020C2\b\b\u0002\u0010D\u001a\u00020C2\b\b\u0002\u0010E\u001a\u00020F2\u0014\b\u0002\u0010\u0013\u001a\u000e\u0012\u0004\u0012\u00020\u0017\u0012\u0004\u0012\u00020\u00010>2\n\b\u0002\u0010\u001c\u001a\u0004\u0018\u00010\u001d2\b\b\u0002\u0010\u001e\u001a\u00020\u001f23\b\u0002\u0010G\u001a-\u0012\u001e\u0012\u001c\u0012\u0004\u0012\u00020\u00010\u0016¢\u0006\u0002\bH¢\u0006\f\b\u0018\u0012\b\b\u0019\u0012\u0004\b\b(I\u0012\u0004\u0012\u00020\u00010>¢\u0006\u0002\bHH\u0007¢\u0006\u0002\u0010J\u001aî\u0001\u0010\u0000\u001a\u00020\u00012\u0006\u0010;\u001a\u00020K2\u0012\u0010=\u001a\u000e\u0012\u0004\u0012\u00020K\u0012\u0004\u0012\u00020\u00010>2\b\b\u0002\u0010\u0004\u001a\u00020\u00052\b\b\u0002\u0010\u0006\u001a\u00020\u00072\b\b\u0002\u0010\b\u001a\u00020\u00072\b\b\u0002\u0010\u000b\u001a\u00020\f2\b\b\u0002\u0010\r\u001a\u00020\u000e2\b\b\u0002\u0010?\u001a\u00020@2\b\b\u0002\u0010A\u001a\u00020\u00072\b\b\u0002\u0010B\u001a\u00020C2\b\b\u0002\u0010D\u001a\u00020C2\b\b\u0002\u0010E\u001a\u00020F2\u0014\b\u0002\u0010\u0013\u001a\u000e\u0012\u0004\u0012\u00020\u0017\u0012\u0004\u0012\u00020\u00010>2\n\b\u0002\u0010\u001c\u001a\u0004\u0018\u00010\u001d2\b\b\u0002\u0010\u001e\u001a\u00020\u001f23\b\u0002\u0010G\u001a-\u0012\u001e\u0012\u001c\u0012\u0004\u0012\u00020\u00010\u0016¢\u0006\u0002\bH¢\u0006\f\b\u0018\u0012\b\b\u0019\u0012\u0004\b\b(I\u0012\u0004\u0012\u00020\u00010>¢\u0006\u0002\bHH\u0007¢\u0006\u0002\u0010L\u001aâ\u0001\u0010\u0000\u001a\u00020\u00012\u0006\u0010;\u001a\u00020<2\u0012\u0010=\u001a\u000e\u0012\u0004\u0012\u00020<\u0012\u0004\u0012\u00020\u00010>2\b\b\u0002\u0010\u0004\u001a\u00020\u00052\b\b\u0002\u0010\u0006\u001a\u00020\u00072\b\b\u0002\u0010\b\u001a\u00020\u00072\b\b\u0002\u0010\u000b\u001a\u00020\f2\b\b\u0002\u0010\r\u001a\u00020\u000e2\b\b\u0002\u0010?\u001a\u00020@2\b\b\u0002\u0010A\u001a\u00020\u00072\b\b\u0002\u0010B\u001a\u00020C2\b\b\u0002\u0010E\u001a\u00020F2\u0014\b\u0002\u0010\u0013\u001a\u000e\u0012\u0004\u0012\u00020\u0017\u0012\u0004\u0012\u00020\u00010>2\b\b\u0002\u0010\u001c\u001a\u00020\u001d2\b\b\u0002\u0010\u001e\u001a\u00020\u001f23\b\u0002\u0010G\u001a-\u0012\u001e\u0012\u001c\u0012\u0004\u0012\u00020\u00010\u0016¢\u0006\u0002\bH¢\u0006\f\b\u0018\u0012\b\b\u0019\u0012\u0004\b\b(I\u0012\u0004\u0012\u00020\u00010>¢\u0006\u0002\bHH\u0007¢\u0006\u0002\u0010M\u001aâ\u0001\u0010\u0000\u001a\u00020\u00012\u0006\u0010;\u001a\u00020K2\u0012\u0010=\u001a\u000e\u0012\u0004\u0012\u00020K\u0012\u0004\u0012\u00020\u00010>2\b\b\u0002\u0010\u0004\u001a\u00020\u00052\b\b\u0002\u0010\u0006\u001a\u00020\u00072\b\b\u0002\u0010\b\u001a\u00020\u00072\b\b\u0002\u0010\u000b\u001a\u00020\f2\b\b\u0002\u0010\r\u001a\u00020\u000e2\b\b\u0002\u0010?\u001a\u00020@2\b\b\u0002\u0010A\u001a\u00020\u00072\b\b\u0002\u0010B\u001a\u00020C2\b\b\u0002\u0010E\u001a\u00020F2\u0014\b\u0002\u0010\u0013\u001a\u000e\u0012\u0004\u0012\u00020\u0017\u0012\u0004\u0012\u00020\u00010>2\b\b\u0002\u0010\u001c\u001a\u00020\u001d2\b\b\u0002\u0010\u001e\u001a\u00020\u001f23\b\u0002\u0010G\u001a-\u0012\u001e\u0012\u001c\u0012\u0004\u0012\u00020\u00010\u0016¢\u0006\u0002\bH¢\u0006\f\b\u0018\u0012\b\b\u0019\u0012\u0004\b\b(I\u0012\u0004\u0012\u00020\u00010>¢\u0006\u0002\bHH\u0007¢\u0006\u0002\u0010N\"\u000e\u00107\u001a\u00020#X\u0082\u0004¢\u0006\u0002\n\u0000\"\u0010\u00108\u001a\u000209X\u0082\u0004¢\u0006\u0004\n\u0002\u0010:¨\u0006O²\u0006\n\u0010P\u001a\u00020\u0007X\u008a\u0084\u0002²\u0006\n\u0010Q\u001a\u00020RX\u008a\u0084\u0002²\u0006\n\u0010S\u001a\u00020RX\u008a\u0084\u0002²\u0006\n\u0010T\u001a\u00020KX\u008a\u008e\u0002²\u0006\n\u0010U\u001a\u00020<X\u008a\u008e\u0002"}, d2 = {"BasicTextField", "", "state", "Landroidx/compose/foundation/text/input/TextFieldState;", "modifier", "Landroidx/compose/ui/Modifier;", StreamManagement.Enabled.ELEMENT, "", "readOnly", "inputTransformation", "Landroidx/compose/foundation/text/input/InputTransformation;", "textStyle", "Landroidx/compose/ui/text/TextStyle;", "keyboardOptions", "Landroidx/compose/foundation/text/KeyboardOptions;", "onKeyboardAction", "Landroidx/compose/foundation/text/input/KeyboardActionHandler;", "lineLimits", "Landroidx/compose/foundation/text/input/TextFieldLineLimits;", "onTextLayout", "Lkotlin/Function2;", "Landroidx/compose/ui/unit/Density;", "Lkotlin/Function0;", "Landroidx/compose/ui/text/TextLayoutResult;", "Lkotlin/ParameterName;", "name", "getResult", "Lkotlin/ExtensionFunctionType;", "interactionSource", "Landroidx/compose/foundation/interaction/MutableInteractionSource;", "cursorBrush", "Landroidx/compose/ui/graphics/Brush;", "outputTransformation", "Landroidx/compose/foundation/text/input/OutputTransformation;", "decorator", "Landroidx/compose/foundation/text/input/TextFieldDecorator;", "scrollState", "Landroidx/compose/foundation/ScrollState;", "(Landroidx/compose/foundation/text/input/TextFieldState;Landroidx/compose/ui/Modifier;ZZLandroidx/compose/foundation/text/input/InputTransformation;Landroidx/compose/ui/text/TextStyle;Landroidx/compose/foundation/text/KeyboardOptions;Landroidx/compose/foundation/text/input/KeyboardActionHandler;Landroidx/compose/foundation/text/input/TextFieldLineLimits;Lkotlin/jvm/functions/Function2;Landroidx/compose/foundation/interaction/MutableInteractionSource;Landroidx/compose/ui/graphics/Brush;Landroidx/compose/foundation/text/input/OutputTransformation;Landroidx/compose/foundation/text/input/TextFieldDecorator;Landroidx/compose/foundation/ScrollState;Landroidx/compose/runtime/Composer;III)V", "codepointTransformation", "Landroidx/compose/foundation/text/input/internal/CodepointTransformation;", "isPassword", "(Landroidx/compose/foundation/text/input/TextFieldState;Landroidx/compose/ui/Modifier;ZZLandroidx/compose/foundation/text/input/InputTransformation;Landroidx/compose/ui/text/TextStyle;Landroidx/compose/foundation/text/KeyboardOptions;Landroidx/compose/foundation/text/input/KeyboardActionHandler;Landroidx/compose/foundation/text/input/TextFieldLineLimits;Lkotlin/jvm/functions/Function2;Landroidx/compose/foundation/interaction/MutableInteractionSource;Landroidx/compose/ui/graphics/Brush;Landroidx/compose/foundation/text/input/internal/CodepointTransformation;Landroidx/compose/foundation/text/input/OutputTransformation;Landroidx/compose/foundation/text/input/TextFieldDecorator;Landroidx/compose/foundation/ScrollState;ZLandroidx/compose/runtime/Composer;III)V", "minHeightForSingleLineField", "textLayoutState", "Landroidx/compose/foundation/text/input/internal/TextLayoutState;", "addContextMenuComponents", "textFieldSelectionState", "Landroidx/compose/foundation/text/input/internal/selection/TextFieldSelectionState;", "coroutineScope", "Lkotlinx/coroutines/CoroutineScope;", "TextFieldCursorHandle", "selectionState", "(Landroidx/compose/foundation/text/input/internal/selection/TextFieldSelectionState;Landroidx/compose/runtime/Composer;I)V", "TextFieldSelectionHandles", "DefaultTextFieldDecorator", "MinTouchTargetSizeForHandles", "Landroidx/compose/ui/unit/DpSize;", "J", "value", "", "onValueChange", "Lkotlin/Function1;", "keyboardActions", "Landroidx/compose/foundation/text/KeyboardActions;", "singleLine", "maxLines", "", "minLines", "visualTransformation", "Landroidx/compose/ui/text/input/VisualTransformation;", "decorationBox", "Landroidx/compose/runtime/Composable;", "innerTextField", "(Ljava/lang/String;Lkotlin/jvm/functions/Function1;Landroidx/compose/ui/Modifier;ZZLandroidx/compose/ui/text/TextStyle;Landroidx/compose/foundation/text/KeyboardOptions;Landroidx/compose/foundation/text/KeyboardActions;ZIILandroidx/compose/ui/text/input/VisualTransformation;Lkotlin/jvm/functions/Function1;Landroidx/compose/foundation/interaction/MutableInteractionSource;Landroidx/compose/ui/graphics/Brush;Lkotlin/jvm/functions/Function3;Landroidx/compose/runtime/Composer;III)V", "Landroidx/compose/ui/text/input/TextFieldValue;", "(Landroidx/compose/ui/text/input/TextFieldValue;Lkotlin/jvm/functions/Function1;Landroidx/compose/ui/Modifier;ZZLandroidx/compose/ui/text/TextStyle;Landroidx/compose/foundation/text/KeyboardOptions;Landroidx/compose/foundation/text/KeyboardActions;ZIILandroidx/compose/ui/text/input/VisualTransformation;Lkotlin/jvm/functions/Function1;Landroidx/compose/foundation/interaction/MutableInteractionSource;Landroidx/compose/ui/graphics/Brush;Lkotlin/jvm/functions/Function3;Landroidx/compose/runtime/Composer;III)V", "(Ljava/lang/String;Lkotlin/jvm/functions/Function1;Landroidx/compose/ui/Modifier;ZZLandroidx/compose/ui/text/TextStyle;Landroidx/compose/foundation/text/KeyboardOptions;Landroidx/compose/foundation/text/KeyboardActions;ZILandroidx/compose/ui/text/input/VisualTransformation;Lkotlin/jvm/functions/Function1;Landroidx/compose/foundation/interaction/MutableInteractionSource;Landroidx/compose/ui/graphics/Brush;Lkotlin/jvm/functions/Function3;Landroidx/compose/runtime/Composer;III)V", "(Landroidx/compose/ui/text/input/TextFieldValue;Lkotlin/jvm/functions/Function1;Landroidx/compose/ui/Modifier;ZZLandroidx/compose/ui/text/TextStyle;Landroidx/compose/foundation/text/KeyboardOptions;Landroidx/compose/foundation/text/KeyboardActions;ZILandroidx/compose/ui/text/input/VisualTransformation;Lkotlin/jvm/functions/Function1;Landroidx/compose/foundation/interaction/MutableInteractionSource;Landroidx/compose/ui/graphics/Brush;Lkotlin/jvm/functions/Function3;Landroidx/compose/runtime/Composer;III)V", "foundation", "cursorHandleVisible", "startHandleState", "Landroidx/compose/foundation/text/input/internal/selection/TextFieldHandleState;", "endHandleState", "textFieldValueState", "lastTextValue"}, k = 2, mv = {2, 1, 0}, xi = 48)
public final class BasicTextFieldKt {
    private static final TextFieldDecorator DefaultTextFieldDecorator = BasicTextFieldKt$DefaultTextFieldDecorator$1.INSTANCE;
    private static final long MinTouchTargetSizeForHandles;

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit BasicTextField$lambda$0(TextFieldState textFieldState, Modifier modifier, boolean z, boolean z2, InputTransformation inputTransformation, TextStyle textStyle, KeyboardOptions keyboardOptions, KeyboardActionHandler keyboardActionHandler, TextFieldLineLimits textFieldLineLimits, Function2 function2, MutableInteractionSource mutableInteractionSource, Brush brush, OutputTransformation outputTransformation, TextFieldDecorator textFieldDecorator, ScrollState scrollState, int i, int i2, int i3, Composer composer, int i4) {
        BasicTextField(textFieldState, modifier, z, z2, inputTransformation, textStyle, keyboardOptions, keyboardActionHandler, textFieldLineLimits, (Function2<? super Density, ? super Function0<TextLayoutResult>, Unit>) function2, mutableInteractionSource, brush, outputTransformation, textFieldDecorator, scrollState, composer, RecomposeScopeImplKt.updateChangedFlags(i | 1), RecomposeScopeImplKt.updateChangedFlags(i2), i3);
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit BasicTextField$lambda$15(TextFieldState textFieldState, Modifier modifier, boolean z, boolean z2, InputTransformation inputTransformation, TextStyle textStyle, KeyboardOptions keyboardOptions, KeyboardActionHandler keyboardActionHandler, TextFieldLineLimits textFieldLineLimits, Function2 function2, MutableInteractionSource mutableInteractionSource, Brush brush, CodepointTransformation codepointTransformation, OutputTransformation outputTransformation, TextFieldDecorator textFieldDecorator, ScrollState scrollState, boolean z3, int i, int i2, int i3, Composer composer, int i4) {
        BasicTextField(textFieldState, modifier, z, z2, inputTransformation, textStyle, keyboardOptions, keyboardActionHandler, textFieldLineLimits, function2, mutableInteractionSource, brush, codepointTransformation, outputTransformation, textFieldDecorator, scrollState, z3, composer, RecomposeScopeImplKt.updateChangedFlags(i | 1), RecomposeScopeImplKt.updateChangedFlags(i2), i3);
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit BasicTextField$lambda$25(String str, Function1 function1, Modifier modifier, boolean z, boolean z2, TextStyle textStyle, KeyboardOptions keyboardOptions, KeyboardActions keyboardActions, boolean z3, int i, int i2, VisualTransformation visualTransformation, Function1 function12, MutableInteractionSource mutableInteractionSource, Brush brush, Function3 function3, int i3, int i4, int i5, Composer composer, int i6) {
        BasicTextField(str, (Function1<? super String, Unit>) function1, modifier, z, z2, textStyle, keyboardOptions, keyboardActions, z3, i, i2, visualTransformation, (Function1<? super TextLayoutResult, Unit>) function12, mutableInteractionSource, brush, (Function3<? super Function2<? super Composer, ? super Integer, Unit>, ? super Composer, ? super Integer, Unit>) function3, composer, RecomposeScopeImplKt.updateChangedFlags(i3 | 1), RecomposeScopeImplKt.updateChangedFlags(i4), i5);
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit BasicTextField$lambda$28(TextFieldValue textFieldValue, Function1 function1, Modifier modifier, boolean z, boolean z2, TextStyle textStyle, KeyboardOptions keyboardOptions, KeyboardActions keyboardActions, boolean z3, int i, int i2, VisualTransformation visualTransformation, Function1 function12, MutableInteractionSource mutableInteractionSource, Brush brush, Function3 function3, int i3, int i4, int i5, Composer composer, int i6) {
        BasicTextField(textFieldValue, (Function1<? super TextFieldValue, Unit>) function1, modifier, z, z2, textStyle, keyboardOptions, keyboardActions, z3, i, i2, visualTransformation, (Function1<? super TextLayoutResult, Unit>) function12, mutableInteractionSource, brush, (Function3<? super Function2<? super Composer, ? super Integer, Unit>, ? super Composer, ? super Integer, Unit>) function3, composer, RecomposeScopeImplKt.updateChangedFlags(i3 | 1), RecomposeScopeImplKt.updateChangedFlags(i4), i5);
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit BasicTextField$lambda$31(String str, Function1 function1, Modifier modifier, boolean z, boolean z2, TextStyle textStyle, KeyboardOptions keyboardOptions, KeyboardActions keyboardActions, boolean z3, int i, VisualTransformation visualTransformation, Function1 function12, MutableInteractionSource mutableInteractionSource, Brush brush, Function3 function3, int i2, int i3, int i4, Composer composer, int i5) {
        BasicTextField(str, function1, modifier, z, z2, textStyle, keyboardOptions, keyboardActions, z3, i, visualTransformation, function12, mutableInteractionSource, brush, function3, composer, RecomposeScopeImplKt.updateChangedFlags(i2 | 1), RecomposeScopeImplKt.updateChangedFlags(i3), i4);
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit BasicTextField$lambda$34(TextFieldValue textFieldValue, Function1 function1, Modifier modifier, boolean z, boolean z2, TextStyle textStyle, KeyboardOptions keyboardOptions, KeyboardActions keyboardActions, boolean z3, int i, VisualTransformation visualTransformation, Function1 function12, MutableInteractionSource mutableInteractionSource, Brush brush, Function3 function3, int i2, int i3, int i4, Composer composer, int i5) {
        BasicTextField(textFieldValue, function1, modifier, z, z2, textStyle, keyboardOptions, keyboardActions, z3, i, visualTransformation, function12, mutableInteractionSource, brush, function3, composer, RecomposeScopeImplKt.updateChangedFlags(i2 | 1), RecomposeScopeImplKt.updateChangedFlags(i3), i4);
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit TextFieldCursorHandle$lambda$4(TextFieldSelectionState textFieldSelectionState, int i, Composer composer, int i2) {
        TextFieldCursorHandle(textFieldSelectionState, composer, RecomposeScopeImplKt.updateChangedFlags(i | 1));
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit TextFieldSelectionHandles$lambda$8(TextFieldSelectionState textFieldSelectionState, int i, Composer composer, int i2) {
        TextFieldSelectionHandles(textFieldSelectionState, composer, RecomposeScopeImplKt.updateChangedFlags(i | 1));
        return Unit.INSTANCE;
    }

    /* JADX WARN: Removed duplicated region for block: B:108:0x014b  */
    /* JADX WARN: Removed duplicated region for block: B:109:0x0152  */
    /* JADX WARN: Removed duplicated region for block: B:119:0x0172  */
    /* JADX WARN: Removed duplicated region for block: B:120:0x0177  */
    /* JADX WARN: Removed duplicated region for block: B:130:0x0199  */
    /* JADX WARN: Removed duplicated region for block: B:131:0x019c  */
    /* JADX WARN: Removed duplicated region for block: B:140:0x01bb  */
    /* JADX WARN: Removed duplicated region for block: B:141:0x01be  */
    /* JADX WARN: Removed duplicated region for block: B:154:0x01df  */
    /* JADX WARN: Removed duplicated region for block: B:161:0x01f3  */
    /* JADX WARN: Removed duplicated region for block: B:164:0x0202  */
    /* JADX WARN: Removed duplicated region for block: B:168:0x020b  */
    /* JADX WARN: Removed duplicated region for block: B:171:0x0214  */
    /* JADX WARN: Removed duplicated region for block: B:227:0x0317  */
    /* JADX WARN: Removed duplicated region for block: B:230:0x0338  */
    /* JADX WARN: Removed duplicated region for block: B:232:? A[RETURN, SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:23:0x004c  */
    /* JADX WARN: Removed duplicated region for block: B:24:0x004f  */
    /* JADX WARN: Removed duplicated region for block: B:34:0x006d  */
    /* JADX WARN: Removed duplicated region for block: B:35:0x0070  */
    /* JADX WARN: Removed duplicated region for block: B:45:0x008e  */
    /* JADX WARN: Removed duplicated region for block: B:46:0x0091  */
    /* JADX WARN: Removed duplicated region for block: B:56:0x00ad  */
    /* JADX WARN: Removed duplicated region for block: B:57:0x00b2  */
    /* JADX WARN: Removed duplicated region for block: B:66:0x00cb  */
    /* JADX WARN: Removed duplicated region for block: B:67:0x00d0  */
    /* JADX WARN: Removed duplicated region for block: B:76:0x00e9  */
    /* JADX WARN: Removed duplicated region for block: B:77:0x00ee  */
    /* JADX WARN: Removed duplicated region for block: B:86:0x0107  */
    /* JADX WARN: Removed duplicated region for block: B:87:0x010a  */
    /* JADX WARN: Removed duplicated region for block: B:97:0x012a  */
    /* JADX WARN: Removed duplicated region for block: B:98:0x012d  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public static final void BasicTextField(final androidx.compose.foundation.text.input.TextFieldState r36, androidx.compose.ui.Modifier r37, boolean r38, boolean r39, androidx.compose.foundation.text.input.InputTransformation r40, androidx.compose.ui.text.TextStyle r41, androidx.compose.foundation.text.KeyboardOptions r42, androidx.compose.foundation.text.input.KeyboardActionHandler r43, androidx.compose.foundation.text.input.TextFieldLineLimits r44, kotlin.jvm.functions.Function2<? super androidx.compose.ui.unit.Density, ? super kotlin.jvm.functions.Function0<androidx.compose.ui.text.TextLayoutResult>, kotlin.Unit> r45, androidx.compose.foundation.interaction.MutableInteractionSource r46, androidx.compose.ui.graphics.Brush r47, androidx.compose.foundation.text.input.OutputTransformation r48, androidx.compose.foundation.text.input.TextFieldDecorator r49, androidx.compose.foundation.ScrollState r50, androidx.compose.runtime.Composer r51, final int r52, final int r53, final int r54) {
        /*
            Method dump skipped, instruction units count: 846
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.compose.foundation.text.BasicTextFieldKt.BasicTextField(androidx.compose.foundation.text.input.TextFieldState, androidx.compose.ui.Modifier, boolean, boolean, androidx.compose.foundation.text.input.InputTransformation, androidx.compose.ui.text.TextStyle, androidx.compose.foundation.text.KeyboardOptions, androidx.compose.foundation.text.input.KeyboardActionHandler, androidx.compose.foundation.text.input.TextFieldLineLimits, kotlin.jvm.functions.Function2, androidx.compose.foundation.interaction.MutableInteractionSource, androidx.compose.ui.graphics.Brush, androidx.compose.foundation.text.input.OutputTransformation, androidx.compose.foundation.text.input.TextFieldDecorator, androidx.compose.foundation.ScrollState, androidx.compose.runtime.Composer, int, int, int):void");
    }

    /* JADX WARN: Removed duplicated region for block: B:108:0x0141  */
    /* JADX WARN: Removed duplicated region for block: B:109:0x014a  */
    /* JADX WARN: Removed duplicated region for block: B:119:0x016a  */
    /* JADX WARN: Removed duplicated region for block: B:120:0x016f  */
    /* JADX WARN: Removed duplicated region for block: B:130:0x018f  */
    /* JADX WARN: Removed duplicated region for block: B:131:0x0192  */
    /* JADX WARN: Removed duplicated region for block: B:142:0x01b2  */
    /* JADX WARN: Removed duplicated region for block: B:143:0x01b5  */
    /* JADX WARN: Removed duplicated region for block: B:152:0x01d7  */
    /* JADX WARN: Removed duplicated region for block: B:153:0x01da  */
    /* JADX WARN: Removed duplicated region for block: B:166:0x01ff  */
    /* JADX WARN: Removed duplicated region for block: B:173:0x0213  */
    /* JADX WARN: Removed duplicated region for block: B:176:0x021b  */
    /* JADX WARN: Removed duplicated region for block: B:177:0x0220  */
    /* JADX WARN: Removed duplicated region for block: B:186:0x0240  */
    /* JADX WARN: Removed duplicated region for block: B:190:0x024d  */
    /* JADX WARN: Removed duplicated region for block: B:193:0x0256  */
    /* JADX WARN: Removed duplicated region for block: B:23:0x0048  */
    /* JADX WARN: Removed duplicated region for block: B:24:0x004b  */
    /* JADX WARN: Removed duplicated region for block: B:34:0x0067  */
    /* JADX WARN: Removed duplicated region for block: B:35:0x006a  */
    /* JADX WARN: Removed duplicated region for block: B:385:0x08a5  */
    /* JADX WARN: Removed duplicated region for block: B:388:0x08ca  */
    /* JADX WARN: Removed duplicated region for block: B:390:? A[RETURN, SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:45:0x0084  */
    /* JADX WARN: Removed duplicated region for block: B:46:0x0087  */
    /* JADX WARN: Removed duplicated region for block: B:56:0x00a3  */
    /* JADX WARN: Removed duplicated region for block: B:57:0x00a8  */
    /* JADX WARN: Removed duplicated region for block: B:66:0x00c1  */
    /* JADX WARN: Removed duplicated region for block: B:67:0x00c6  */
    /* JADX WARN: Removed duplicated region for block: B:76:0x00df  */
    /* JADX WARN: Removed duplicated region for block: B:77:0x00e4  */
    /* JADX WARN: Removed duplicated region for block: B:86:0x00fd  */
    /* JADX WARN: Removed duplicated region for block: B:87:0x0100  */
    /* JADX WARN: Removed duplicated region for block: B:97:0x0120  */
    /* JADX WARN: Removed duplicated region for block: B:98:0x0123  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public static final void BasicTextField(final androidx.compose.foundation.text.input.TextFieldState r57, androidx.compose.ui.Modifier r58, boolean r59, boolean r60, androidx.compose.foundation.text.input.InputTransformation r61, androidx.compose.ui.text.TextStyle r62, androidx.compose.foundation.text.KeyboardOptions r63, androidx.compose.foundation.text.input.KeyboardActionHandler r64, androidx.compose.foundation.text.input.TextFieldLineLimits r65, kotlin.jvm.functions.Function2<? super androidx.compose.ui.unit.Density, ? super kotlin.jvm.functions.Function0<androidx.compose.ui.text.TextLayoutResult>, kotlin.Unit> r66, androidx.compose.foundation.interaction.MutableInteractionSource r67, androidx.compose.ui.graphics.Brush r68, androidx.compose.foundation.text.input.internal.CodepointTransformation r69, androidx.compose.foundation.text.input.OutputTransformation r70, androidx.compose.foundation.text.input.TextFieldDecorator r71, androidx.compose.foundation.ScrollState r72, boolean r73, androidx.compose.runtime.Composer r74, final int r75, final int r76, final int r77) {
        /*
            Method dump skipped, instruction units count: 2272
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.compose.foundation.text.BasicTextFieldKt.BasicTextField(androidx.compose.foundation.text.input.TextFieldState, androidx.compose.ui.Modifier, boolean, boolean, androidx.compose.foundation.text.input.InputTransformation, androidx.compose.ui.text.TextStyle, androidx.compose.foundation.text.KeyboardOptions, androidx.compose.foundation.text.input.KeyboardActionHandler, androidx.compose.foundation.text.input.TextFieldLineLimits, kotlin.jvm.functions.Function2, androidx.compose.foundation.interaction.MutableInteractionSource, androidx.compose.ui.graphics.Brush, androidx.compose.foundation.text.input.internal.CodepointTransformation, androidx.compose.foundation.text.input.OutputTransformation, androidx.compose.foundation.text.input.TextFieldDecorator, androidx.compose.foundation.ScrollState, boolean, androidx.compose.runtime.Composer, int, int, int):void");
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit BasicTextField$lambda$8(TextFieldSelectionState textFieldSelectionState, AnnotatedString annotatedString) {
        textFieldSelectionState.onPasteEvent$foundation(annotatedString);
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final AnnotatedString BasicTextField$lambda$9(TextFieldSelectionState textFieldSelectionState) {
        return TextFieldSelectionState.copyWithResult$foundation$default(textFieldSelectionState, false, 1, null);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit BasicTextField$lambda$11$0(TransformedTextFieldState transformedTextFieldState, InputTransformation inputTransformation, TextFieldSelectionState textFieldSelectionState, HapticFeedback hapticFeedback, Clipboard clipboard, BasicTextFieldKt$BasicTextField$textToolbarHandler$1$1 basicTextFieldKt$BasicTextField$textToolbarHandler$1$1, Density density, boolean z, boolean z2, boolean z3) {
        transformedTextFieldState.update(inputTransformation);
        textFieldSelectionState.update(hapticFeedback, clipboard, basicTextFieldKt$BasicTextField$textToolbarHandler$1$1, density, z, z2, z3);
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit BasicTextField$lambda$13$0(boolean z, MutableSharedFlow mutableSharedFlow) {
        if (z) {
            mutableSharedFlow.tryEmit(Unit.INSTANCE);
        }
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit BasicTextField$lambda$14$0(TextFieldDecorator textFieldDecorator, final TextFieldLineLimits textFieldLineLimits, final TextLayoutState textLayoutState, final TextStyle textStyle, final boolean z, final boolean z2, final TransformedTextFieldState transformedTextFieldState, final TextFieldSelectionState textFieldSelectionState, final Brush brush, final boolean z3, final boolean z4, final ScrollState scrollState, final Orientation orientation, final ToolbarRequesterImpl toolbarRequesterImpl, final PlatformSelectionBehaviors platformSelectionBehaviors, final boolean z5, final Function2 function2, final KeyboardOptions keyboardOptions, Composer composer, int i) {
        ComposerKt.sourceInformation(composer, "C468@24974L2901,468@24963L2912:BasicTextField.kt#423gt5");
        if (!composer.shouldExecute((i & 3) != 2, i & 1)) {
            composer.skipToGroupEnd();
        } else {
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(-673241599, i, -1, "androidx.compose.foundation.text.BasicTextField.<anonymous>.<anonymous> (BasicTextField.kt:467)");
            }
            (textFieldDecorator == null ? DefaultTextFieldDecorator : textFieldDecorator).Decoration(ComposableLambdaKt.rememberComposableLambda(1969169726, true, new Function2() { // from class: androidx.compose.foundation.text.BasicTextFieldKt$$ExternalSyntheticLambda4
                @Override // kotlin.jvm.functions.Function2
                public final Object invoke(Object obj, Object obj2) {
                    return BasicTextFieldKt.BasicTextField$lambda$14$0$0(textFieldLineLimits, textLayoutState, textStyle, z, z2, transformedTextFieldState, textFieldSelectionState, brush, z3, z4, scrollState, orientation, toolbarRequesterImpl, platformSelectionBehaviors, z5, function2, keyboardOptions, (Composer) obj, ((Integer) obj2).intValue());
                }
            }, composer, 54), composer, 6);
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventEnd();
            }
        }
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit BasicTextField$lambda$14$0$0(TextFieldLineLimits textFieldLineLimits, TextLayoutState textLayoutState, TextStyle textStyle, boolean z, boolean z2, TransformedTextFieldState transformedTextFieldState, TextFieldSelectionState textFieldSelectionState, Brush brush, boolean z3, boolean z4, ScrollState scrollState, Orientation orientation, ToolbarRequesterImpl toolbarRequesterImpl, PlatformSelectionBehaviors platformSelectionBehaviors, boolean z5, Function2 function2, KeyboardOptions keyboardOptions, Composer composer, int i) {
        int maxHeightInLines;
        int minHeightInLines;
        ComposerKt.sourceInformation(composer, "C479@25335L2526:BasicTextField.kt#423gt5");
        if (!composer.shouldExecute((i & 3) != 2, i & 1)) {
            composer.skipToGroupEnd();
        } else {
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(1969169726, i, -1, "androidx.compose.foundation.text.BasicTextField.<anonymous>.<anonymous>.<anonymous> (BasicTextField.kt:469)");
            }
            if (textFieldLineLimits instanceof TextFieldLineLimits.MultiLine) {
                TextFieldLineLimits.MultiLine multiLine = (TextFieldLineLimits.MultiLine) textFieldLineLimits;
                minHeightInLines = multiLine.getMinHeightInLines();
                maxHeightInLines = multiLine.getMaxHeightInLines();
            } else {
                maxHeightInLines = 1;
                minHeightInLines = 1;
            }
            Modifier modifierThen = ClipKt.clipToBounds(TextFieldSizeKt.textFieldMinSize(HeightInLinesModifierKt.heightInLines(minHeightForSingleLineField(Modifier.INSTANCE, textLayoutState), textStyle, minHeightInLines, maxHeightInLines), textStyle)).then(new TextFieldCoreModifier(z, z2, textLayoutState, transformedTextFieldState, textFieldSelectionState, brush, z3 && !z4, scrollState, orientation, toolbarRequesterImpl, platformSelectionBehaviors));
            ComposerKt.sourceInformationMarkerStart(composer, 1042775818, "CC(Box)N(modifier,contentAlignment,propagateMinConstraints,content)71@3424L131:Box.kt#2w3rfo");
            MeasurePolicy measurePolicyMaybeCachedBoxMeasurePolicy = BoxKt.maybeCachedBoxMeasurePolicy(Alignment.INSTANCE.getTopStart(), true);
            ComposerKt.sourceInformationMarkerStart(composer, -1159599143, "CC(Layout)N(content,modifier,measurePolicy)81@3355L27,84@3521L415:Layout.kt#80mrfh");
            int iHashCode = Long.hashCode(ComposablesKt.getCurrentCompositeKeyHashCode(composer, 0));
            CompositionLocalMap currentCompositionLocalMap = composer.getCurrentCompositionLocalMap();
            Modifier modifierMaterializeModifier = ComposedModifierKt.materializeModifier(composer, modifierThen);
            Function0<ComposeUiNode> constructor = ComposeUiNode.INSTANCE.getConstructor();
            ComposerKt.sourceInformationMarkerStart(composer, -553112988, "CC(ReusableComposeNode)N(factory,update,content)410@16187L9:Composables.kt#9igjgp");
            if (!(composer.getApplier() instanceof Applier)) {
                ComposablesKt.invalidApplier();
            }
            composer.startReusableNode();
            if (composer.getInserting()) {
                composer.createNode(constructor);
            } else {
                composer.useNode();
            }
            Composer composerM5069constructorimpl = Updater.m5069constructorimpl(composer);
            Updater.m5077setimpl(composerM5069constructorimpl, measurePolicyMaybeCachedBoxMeasurePolicy, ComposeUiNode.INSTANCE.getSetMeasurePolicy());
            Updater.m5077setimpl(composerM5069constructorimpl, currentCompositionLocalMap, ComposeUiNode.INSTANCE.getSetResolvedCompositionLocals());
            Updater.m5077setimpl(composerM5069constructorimpl, Integer.valueOf(iHashCode), ComposeUiNode.INSTANCE.getSetCompositeKeyHash());
            Updater.m5075reconcileimpl(composerM5069constructorimpl, ComposeUiNode.INSTANCE.getApplyOnDeactivatedNodeAssertion());
            Updater.m5077setimpl(composerM5069constructorimpl, modifierMaterializeModifier, ComposeUiNode.INSTANCE.getSetModifier());
            ComposerKt.sourceInformationMarkerStart(composer, 1833054614, "C72@3469L9:Box.kt#2w3rfo");
            BoxScopeInstance boxScopeInstance = BoxScopeInstance.INSTANCE;
            ComposerKt.sourceInformationMarkerStart(composer, -811364182, "C506@26830L530:BasicTextField.kt#423gt5");
            BoxKt.Box(new TextFieldTextLayoutModifier(textLayoutState, transformedTextFieldState, textStyle, z5, function2, keyboardOptions), composer, 0);
            if (z3 && z && textFieldSelectionState.isInTouchMode()) {
                composer.startReplaceGroup(-810654004);
                ComposerKt.sourceInformation(composer, "523@27595L67");
                TextFieldSelectionHandles(textFieldSelectionState, composer, 0);
                if (!z4) {
                    composer.startReplaceGroup(-810526873);
                    ComposerKt.sourceInformation(composer, "525@27732L63");
                    TextFieldCursorHandle(textFieldSelectionState, composer, 0);
                    composer.endReplaceGroup();
                } else {
                    composer.startReplaceGroup(-810412514);
                    composer.endReplaceGroup();
                }
                composer.endReplaceGroup();
            } else {
                composer.startReplaceGroup(-810390690);
                composer.endReplaceGroup();
            }
            ComposerKt.sourceInformationMarkerEnd(composer);
            ComposerKt.sourceInformationMarkerEnd(composer);
            composer.endNode();
            ComposerKt.sourceInformationMarkerEnd(composer);
            ComposerKt.sourceInformationMarkerEnd(composer);
            ComposerKt.sourceInformationMarkerEnd(composer);
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventEnd();
            }
        }
        return Unit.INSTANCE;
    }

    private static final Modifier minHeightForSingleLineField(Modifier modifier, final TextLayoutState textLayoutState) {
        if (ComposeFoundationFlags.isBasicTextFieldMinSizeOptimizationEnabled) {
            return LayoutModifierKt.layout(modifier, new Function3() { // from class: androidx.compose.foundation.text.BasicTextFieldKt$$ExternalSyntheticLambda0
                @Override // kotlin.jvm.functions.Function3
                public final Object invoke(Object obj, Object obj2, Object obj3) {
                    return BasicTextFieldKt.minHeightForSingleLineField$lambda$0(textLayoutState, (MeasureScope) obj, (Measurable) obj2, (Constraints) obj3);
                }
            });
        }
        return SizeKt.m1209heightInVpY3zN4$default(modifier, textLayoutState.m2111getMinHeightForSingleLineFieldD9Ej5fM(), 0.0f, 2, null);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final MeasureResult minHeightForSingleLineField$lambda$0(TextLayoutState textLayoutState, MeasureScope measureScope, Measurable measurable, Constraints constraints) {
        final Placeable placeableMo7445measureBRTryo0 = measurable.mo7445measureBRTryo0(ConstraintsKt.m8798constrainN9IONVI(constraints.getValue(), ConstraintsKt.Constraints(0, Integer.MAX_VALUE, measureScope.mo482roundToPx0680j_4(textLayoutState.m2111getMinHeightForSingleLineFieldD9Ej5fM()), Integer.MAX_VALUE)));
        return MeasureScope.layout$default(measureScope, placeableMo7445measureBRTryo0.getWidth(), placeableMo7445measureBRTryo0.getHeight(), null, new Function1() { // from class: androidx.compose.foundation.text.BasicTextFieldKt$$ExternalSyntheticLambda1
            @Override // kotlin.jvm.functions.Function1
            public final Object invoke(Object obj) {
                return BasicTextFieldKt.minHeightForSingleLineField$lambda$0$0(placeableMo7445measureBRTryo0, (Placeable.PlacementScope) obj);
            }
        }, 4, null);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit minHeightForSingleLineField$lambda$0$0(Placeable placeable, Placeable.PlacementScope placementScope) {
        Placeable.PlacementScope.placeRelative$default(placementScope, placeable, 0, 0, 0.0f, 4, null);
        return Unit.INSTANCE;
    }

    private static final Modifier addContextMenuComponents(Modifier modifier, TextFieldSelectionState textFieldSelectionState, CoroutineScope coroutineScope) {
        return ComposeFoundationFlags.isNewContextMenuEnabled ? TextFieldSelectionState_androidKt.addBasicTextFieldTextContextMenuComponents(modifier, textFieldSelectionState, coroutineScope) : modifier;
    }

    public static final void TextFieldCursorHandle(final TextFieldSelectionState textFieldSelectionState, Composer composer, final int i) {
        int i2;
        Composer composerStartRestartGroup = composer.startRestartGroup(1991581797);
        ComposerKt.sourceInformation(composerStartRestartGroup, "C(TextFieldCursorHandle)N(selectionState)567@29340L136:BasicTextField.kt#423gt5");
        if ((i & 6) == 0) {
            i2 = (composerStartRestartGroup.changedInstance(textFieldSelectionState) ? 4 : 2) | i;
        } else {
            i2 = i;
        }
        if (!composerStartRestartGroup.shouldExecute((i2 & 3) != 2, i2 & 1)) {
            composerStartRestartGroup.skipToGroupEnd();
        } else {
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(1991581797, i2, -1, "androidx.compose.foundation.text.TextFieldCursorHandle (BasicTextField.kt:564)");
            }
            ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, -1645301395, "CC(remember):BasicTextField.kt#9igjgp");
            boolean zChanged = composerStartRestartGroup.changed(textFieldSelectionState);
            Object objRememberedValue = composerStartRestartGroup.rememberedValue();
            if (zChanged || objRememberedValue == Composer.INSTANCE.getEmpty()) {
                objRememberedValue = SnapshotStateKt.derivedStateOf(new Function0() { // from class: androidx.compose.foundation.text.BasicTextFieldKt$$ExternalSyntheticLambda18
                    @Override // kotlin.jvm.functions.Function0
                    public final Object invoke() {
                        return Boolean.valueOf(BasicTextFieldKt.TextFieldCursorHandle$lambda$0$0(textFieldSelectionState));
                    }
                });
                composerStartRestartGroup.updateRememberedValue(objRememberedValue);
            }
            ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
            if (TextFieldCursorHandle$lambda$1((State) objRememberedValue)) {
                composerStartRestartGroup.startReplaceGroup(535437134);
                ComposerKt.sourceInformation(composerStartRestartGroup, "572@29559L100,576@29738L87,571@29516L383");
                ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, -1645294423, "CC(remember):BasicTextField.kt#9igjgp");
                boolean zChangedInstance = composerStartRestartGroup.changedInstance(textFieldSelectionState);
                OffsetProvider offsetProviderRememberedValue = composerStartRestartGroup.rememberedValue();
                if (zChangedInstance || offsetProviderRememberedValue == Composer.INSTANCE.getEmpty()) {
                    offsetProviderRememberedValue = new OffsetProvider() { // from class: androidx.compose.foundation.text.BasicTextFieldKt$TextFieldCursorHandle$1$1
                        @Override // androidx.compose.foundation.text.selection.OffsetProvider
                        /* JADX INFO: renamed from: provide-F1C5BW0, reason: not valid java name */
                        public final long mo1654provideF1C5BW0() {
                            return textFieldSelectionState.getCursorHandleState$foundation(true).m2158getPositionF1C5BW0();
                        }
                    };
                    composerStartRestartGroup.updateRememberedValue(offsetProviderRememberedValue);
                }
                OffsetProvider offsetProvider = (OffsetProvider) offsetProviderRememberedValue;
                ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
                Modifier.Companion companion = Modifier.INSTANCE;
                ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, -1645288708, "CC(remember):BasicTextField.kt#9igjgp");
                boolean zChangedInstance2 = composerStartRestartGroup.changedInstance(textFieldSelectionState);
                PointerInputEventHandler pointerInputEventHandlerRememberedValue = composerStartRestartGroup.rememberedValue();
                if (zChangedInstance2 || pointerInputEventHandlerRememberedValue == Composer.INSTANCE.getEmpty()) {
                    pointerInputEventHandlerRememberedValue = new PointerInputEventHandler() { // from class: androidx.compose.foundation.text.BasicTextFieldKt$TextFieldCursorHandle$2$1
                        @Override // androidx.compose.ui.input.pointer.PointerInputEventHandler
                        public final Object invoke(PointerInputScope pointerInputScope, Continuation<? super Unit> continuation) {
                            Object objCursorHandleGestures = textFieldSelectionState.cursorHandleGestures(pointerInputScope, continuation);
                            return objCursorHandleGestures == IntrinsicsKt.getCOROUTINE_SUSPENDED() ? objCursorHandleGestures : Unit.INSTANCE;
                        }
                    };
                    composerStartRestartGroup.updateRememberedValue(pointerInputEventHandlerRememberedValue);
                }
                ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
                AndroidCursorHandle_androidKt.m1634CursorHandleUSBMPiE(offsetProvider, SuspendingPointerInputFilterKt.pointerInput(companion, textFieldSelectionState, (PointerInputEventHandler) pointerInputEventHandlerRememberedValue), MinTouchTargetSizeForHandles, composerStartRestartGroup, RendererCapabilities.DECODER_SUPPORT_MASK, 0);
                composerStartRestartGroup.endReplaceGroup();
            } else {
                composerStartRestartGroup.startReplaceGroup(535820573);
                composerStartRestartGroup.endReplaceGroup();
            }
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventEnd();
            }
        }
        ScopeUpdateScope scopeUpdateScopeEndRestartGroup = composerStartRestartGroup.endRestartGroup();
        if (scopeUpdateScopeEndRestartGroup != null) {
            scopeUpdateScopeEndRestartGroup.updateScope(new Function2() { // from class: androidx.compose.foundation.text.BasicTextFieldKt$$ExternalSyntheticLambda19
                @Override // kotlin.jvm.functions.Function2
                public final Object invoke(Object obj, Object obj2) {
                    return BasicTextFieldKt.TextFieldCursorHandle$lambda$4(textFieldSelectionState, i, (Composer) obj, ((Integer) obj2).intValue());
                }
            });
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final boolean TextFieldCursorHandle$lambda$0$0(TextFieldSelectionState textFieldSelectionState) {
        return textFieldSelectionState.getCursorHandleState$foundation(false).getVisible();
    }

    public static final void TextFieldSelectionHandles(final TextFieldSelectionState textFieldSelectionState, Composer composer, final int i) {
        int i2;
        Composer composerStartRestartGroup = composer.startRestartGroup(2025287684);
        ComposerKt.sourceInformation(composerStartRestartGroup, "C(TextFieldSelectionHandles)N(selectionState)588@30105L240,619@31240L241:BasicTextField.kt#423gt5");
        if ((i & 6) == 0) {
            i2 = (composerStartRestartGroup.changedInstance(textFieldSelectionState) ? 4 : 2) | i;
        } else {
            i2 = i;
        }
        if (!composerStartRestartGroup.shouldExecute((i2 & 3) != 2, i2 & 1)) {
            composerStartRestartGroup.skipToGroupEnd();
        } else {
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(2025287684, i2, -1, "androidx.compose.foundation.text.TextFieldSelectionHandles (BasicTextField.kt:585)");
            }
            ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, 681285076, "CC(remember):BasicTextField.kt#9igjgp");
            boolean zChanged = composerStartRestartGroup.changed(textFieldSelectionState);
            Object objRememberedValue = composerStartRestartGroup.rememberedValue();
            if (zChanged || objRememberedValue == Composer.INSTANCE.getEmpty()) {
                objRememberedValue = SnapshotStateKt.derivedStateOf(new Function0() { // from class: androidx.compose.foundation.text.BasicTextFieldKt$$ExternalSyntheticLambda25
                    @Override // kotlin.jvm.functions.Function0
                    public final Object invoke() {
                        return BasicTextFieldKt.TextFieldSelectionHandles$lambda$0$0(textFieldSelectionState);
                    }
                });
                composerStartRestartGroup.updateRememberedValue(objRememberedValue);
            }
            ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
            TextFieldHandleState textFieldHandleStateTextFieldSelectionHandles$lambda$1 = TextFieldSelectionHandles$lambda$1((State) objRememberedValue);
            if (textFieldHandleStateTextFieldSelectionHandles$lambda$1.getVisible()) {
                composerStartRestartGroup.startReplaceGroup(-354609545);
                ComposerKt.sourceInformation(composerStartRestartGroup, "600@30531L167,609@30915L94,599@30485L647");
                ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, 681298635, "CC(remember):BasicTextField.kt#9igjgp");
                boolean zChangedInstance = composerStartRestartGroup.changedInstance(textFieldSelectionState);
                OffsetProvider offsetProviderRememberedValue = composerStartRestartGroup.rememberedValue();
                if (zChangedInstance || offsetProviderRememberedValue == Composer.INSTANCE.getEmpty()) {
                    offsetProviderRememberedValue = new OffsetProvider() { // from class: androidx.compose.foundation.text.BasicTextFieldKt$TextFieldSelectionHandles$1$1
                        @Override // androidx.compose.foundation.text.selection.OffsetProvider
                        /* JADX INFO: renamed from: provide-F1C5BW0 */
                        public final long mo1654provideF1C5BW0() {
                            return textFieldSelectionState.getSelectionHandleState$foundation(true, true).m2158getPositionF1C5BW0();
                        }
                    };
                    composerStartRestartGroup.updateRememberedValue(offsetProviderRememberedValue);
                }
                OffsetProvider offsetProvider = (OffsetProvider) offsetProviderRememberedValue;
                ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
                ResolvedTextDirection direction = textFieldHandleStateTextFieldSelectionHandles$lambda$1.getDirection();
                boolean handlesCrossed = textFieldHandleStateTextFieldSelectionHandles$lambda$1.getHandlesCrossed();
                Modifier.Companion companion = Modifier.INSTANCE;
                ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, 681310850, "CC(remember):BasicTextField.kt#9igjgp");
                boolean zChangedInstance2 = composerStartRestartGroup.changedInstance(textFieldSelectionState);
                PointerInputEventHandler pointerInputEventHandlerRememberedValue = composerStartRestartGroup.rememberedValue();
                if (zChangedInstance2 || pointerInputEventHandlerRememberedValue == Composer.INSTANCE.getEmpty()) {
                    pointerInputEventHandlerRememberedValue = new PointerInputEventHandler() { // from class: androidx.compose.foundation.text.BasicTextFieldKt$TextFieldSelectionHandles$2$1
                        @Override // androidx.compose.ui.input.pointer.PointerInputEventHandler
                        public final Object invoke(PointerInputScope pointerInputScope, Continuation<? super Unit> continuation) {
                            Object objSelectionHandleGestures = textFieldSelectionState.selectionHandleGestures(pointerInputScope, true, continuation);
                            return objSelectionHandleGestures == IntrinsicsKt.getCOROUTINE_SUSPENDED() ? objSelectionHandleGestures : Unit.INSTANCE;
                        }
                    };
                    composerStartRestartGroup.updateRememberedValue(pointerInputEventHandlerRememberedValue);
                }
                ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
                AndroidSelectionHandles_androidKt.m2271SelectionHandlewLIcFTc(offsetProvider, true, direction, handlesCrossed, MinTouchTargetSizeForHandles, textFieldHandleStateTextFieldSelectionHandles$lambda$1.getLineHeight(), SuspendingPointerInputFilterKt.pointerInput(companion, textFieldSelectionState, (PointerInputEventHandler) pointerInputEventHandlerRememberedValue), composerStartRestartGroup, 24624, 0);
                composerStartRestartGroup.endReplaceGroup();
            } else {
                composerStartRestartGroup.startReplaceGroup(-353981826);
                composerStartRestartGroup.endReplaceGroup();
            }
            ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, 681321397, "CC(remember):BasicTextField.kt#9igjgp");
            boolean zChanged2 = composerStartRestartGroup.changed(textFieldSelectionState);
            Object objRememberedValue2 = composerStartRestartGroup.rememberedValue();
            if (zChanged2 || objRememberedValue2 == Composer.INSTANCE.getEmpty()) {
                objRememberedValue2 = SnapshotStateKt.derivedStateOf(new Function0() { // from class: androidx.compose.foundation.text.BasicTextFieldKt$$ExternalSyntheticLambda26
                    @Override // kotlin.jvm.functions.Function0
                    public final Object invoke() {
                        return BasicTextFieldKt.TextFieldSelectionHandles$lambda$4$0(textFieldSelectionState);
                    }
                });
                composerStartRestartGroup.updateRememberedValue(objRememberedValue2);
            }
            ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
            TextFieldHandleState textFieldHandleStateTextFieldSelectionHandles$lambda$5 = TextFieldSelectionHandles$lambda$5((State) objRememberedValue2);
            if (textFieldHandleStateTextFieldSelectionHandles$lambda$5.getVisible()) {
                composerStartRestartGroup.startReplaceGroup(-353488678);
                ComposerKt.sourceInformation(composerStartRestartGroup, "631@31661L168,640@32043L95,630@31615L644");
                ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, 681334796, "CC(remember):BasicTextField.kt#9igjgp");
                boolean zChangedInstance3 = composerStartRestartGroup.changedInstance(textFieldSelectionState);
                OffsetProvider offsetProviderRememberedValue2 = composerStartRestartGroup.rememberedValue();
                if (zChangedInstance3 || offsetProviderRememberedValue2 == Composer.INSTANCE.getEmpty()) {
                    offsetProviderRememberedValue2 = new OffsetProvider() { // from class: androidx.compose.foundation.text.BasicTextFieldKt$TextFieldSelectionHandles$3$1
                        @Override // androidx.compose.foundation.text.selection.OffsetProvider
                        /* JADX INFO: renamed from: provide-F1C5BW0 */
                        public final long mo1654provideF1C5BW0() {
                            return textFieldSelectionState.getSelectionHandleState$foundation(false, true).m2158getPositionF1C5BW0();
                        }
                    };
                    composerStartRestartGroup.updateRememberedValue(offsetProviderRememberedValue2);
                }
                OffsetProvider offsetProvider2 = (OffsetProvider) offsetProviderRememberedValue2;
                ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
                ResolvedTextDirection direction2 = textFieldHandleStateTextFieldSelectionHandles$lambda$5.getDirection();
                boolean handlesCrossed2 = textFieldHandleStateTextFieldSelectionHandles$lambda$5.getHandlesCrossed();
                Modifier.Companion companion2 = Modifier.INSTANCE;
                ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, 681346947, "CC(remember):BasicTextField.kt#9igjgp");
                boolean zChangedInstance4 = composerStartRestartGroup.changedInstance(textFieldSelectionState);
                PointerInputEventHandler pointerInputEventHandlerRememberedValue2 = composerStartRestartGroup.rememberedValue();
                if (zChangedInstance4 || pointerInputEventHandlerRememberedValue2 == Composer.INSTANCE.getEmpty()) {
                    pointerInputEventHandlerRememberedValue2 = new PointerInputEventHandler() { // from class: androidx.compose.foundation.text.BasicTextFieldKt$TextFieldSelectionHandles$4$1
                        @Override // androidx.compose.ui.input.pointer.PointerInputEventHandler
                        public final Object invoke(PointerInputScope pointerInputScope, Continuation<? super Unit> continuation) {
                            Object objSelectionHandleGestures = textFieldSelectionState.selectionHandleGestures(pointerInputScope, false, continuation);
                            return objSelectionHandleGestures == IntrinsicsKt.getCOROUTINE_SUSPENDED() ? objSelectionHandleGestures : Unit.INSTANCE;
                        }
                    };
                    composerStartRestartGroup.updateRememberedValue(pointerInputEventHandlerRememberedValue2);
                }
                ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
                AndroidSelectionHandles_androidKt.m2271SelectionHandlewLIcFTc(offsetProvider2, false, direction2, handlesCrossed2, MinTouchTargetSizeForHandles, textFieldHandleStateTextFieldSelectionHandles$lambda$5.getLineHeight(), SuspendingPointerInputFilterKt.pointerInput(companion2, textFieldSelectionState, (PointerInputEventHandler) pointerInputEventHandlerRememberedValue2), composerStartRestartGroup, 24624, 0);
                composerStartRestartGroup.endReplaceGroup();
            } else {
                composerStartRestartGroup.startReplaceGroup(-352863842);
                composerStartRestartGroup.endReplaceGroup();
            }
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventEnd();
            }
        }
        ScopeUpdateScope scopeUpdateScopeEndRestartGroup = composerStartRestartGroup.endRestartGroup();
        if (scopeUpdateScopeEndRestartGroup != null) {
            scopeUpdateScopeEndRestartGroup.updateScope(new Function2() { // from class: androidx.compose.foundation.text.BasicTextFieldKt$$ExternalSyntheticLambda27
                @Override // kotlin.jvm.functions.Function2
                public final Object invoke(Object obj, Object obj2) {
                    return BasicTextFieldKt.TextFieldSelectionHandles$lambda$8(textFieldSelectionState, i, (Composer) obj, ((Integer) obj2).intValue());
                }
            });
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final TextFieldHandleState TextFieldSelectionHandles$lambda$0$0(TextFieldSelectionState textFieldSelectionState) {
        return textFieldSelectionState.getSelectionHandleState$foundation(true, false);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final TextFieldHandleState TextFieldSelectionHandles$lambda$4$0(TextFieldSelectionState textFieldSelectionState) {
        return textFieldSelectionState.getSelectionHandleState$foundation(false, false);
    }

    static {
        float f2 = 40;
        MinTouchTargetSizeForHandles = DpKt.m8852DpSizeYgX7TsA(Dp.m8830constructorimpl(f2), Dp.m8830constructorimpl(f2));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit BasicTextField$lambda$16$0(TextLayoutResult textLayoutResult) {
        return Unit.INSTANCE;
    }

    /* JADX WARN: Removed duplicated region for block: B:100:0x012b  */
    /* JADX WARN: Removed duplicated region for block: B:103:0x0131  */
    /* JADX WARN: Removed duplicated region for block: B:104:0x013a  */
    /* JADX WARN: Removed duplicated region for block: B:114:0x015a  */
    /* JADX WARN: Removed duplicated region for block: B:115:0x015f  */
    /* JADX WARN: Removed duplicated region for block: B:125:0x017f  */
    /* JADX WARN: Removed duplicated region for block: B:126:0x0182  */
    /* JADX WARN: Removed duplicated region for block: B:136:0x01a4  */
    /* JADX WARN: Removed duplicated region for block: B:137:0x01a7  */
    /* JADX WARN: Removed duplicated region for block: B:147:0x01c7  */
    /* JADX WARN: Removed duplicated region for block: B:148:0x01cc  */
    /* JADX WARN: Removed duplicated region for block: B:158:0x01e9  */
    /* JADX WARN: Removed duplicated region for block: B:159:0x01ec  */
    /* JADX WARN: Removed duplicated region for block: B:168:0x0211  */
    /* JADX WARN: Removed duplicated region for block: B:172:0x021d  */
    /* JADX WARN: Removed duplicated region for block: B:175:0x0227  */
    /* JADX WARN: Removed duplicated region for block: B:246:0x03df  */
    /* JADX WARN: Removed duplicated region for block: B:247:0x03e2  */
    /* JADX WARN: Removed duplicated region for block: B:252:0x03f1  */
    /* JADX WARN: Removed duplicated region for block: B:255:0x0409  */
    /* JADX WARN: Removed duplicated region for block: B:256:0x040c  */
    /* JADX WARN: Removed duplicated region for block: B:258:0x0410  */
    /* JADX WARN: Removed duplicated region for block: B:259:0x0413  */
    /* JADX WARN: Removed duplicated region for block: B:263:0x042a  */
    /* JADX WARN: Removed duplicated region for block: B:268:0x043c  */
    /* JADX WARN: Removed duplicated region for block: B:271:0x048d  */
    /* JADX WARN: Removed duplicated region for block: B:273:0x04a5  */
    /* JADX WARN: Removed duplicated region for block: B:276:0x04c5  */
    /* JADX WARN: Removed duplicated region for block: B:278:? A[RETURN, SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:30:0x005d  */
    /* JADX WARN: Removed duplicated region for block: B:31:0x0060  */
    /* JADX WARN: Removed duplicated region for block: B:41:0x007e  */
    /* JADX WARN: Removed duplicated region for block: B:42:0x0081  */
    /* JADX WARN: Removed duplicated region for block: B:52:0x009d  */
    /* JADX WARN: Removed duplicated region for block: B:53:0x00a2  */
    /* JADX WARN: Removed duplicated region for block: B:62:0x00bb  */
    /* JADX WARN: Removed duplicated region for block: B:63:0x00c0  */
    /* JADX WARN: Removed duplicated region for block: B:72:0x00d9  */
    /* JADX WARN: Removed duplicated region for block: B:73:0x00de  */
    /* JADX WARN: Removed duplicated region for block: B:82:0x00f7  */
    /* JADX WARN: Removed duplicated region for block: B:83:0x00fc  */
    /* JADX WARN: Removed duplicated region for block: B:92:0x0115  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public static final void BasicTextField(final java.lang.String r36, final kotlin.jvm.functions.Function1<? super java.lang.String, kotlin.Unit> r37, androidx.compose.ui.Modifier r38, boolean r39, boolean r40, androidx.compose.ui.text.TextStyle r41, androidx.compose.foundation.text.KeyboardOptions r42, androidx.compose.foundation.text.KeyboardActions r43, boolean r44, int r45, int r46, androidx.compose.ui.text.input.VisualTransformation r47, kotlin.jvm.functions.Function1<? super androidx.compose.ui.text.TextLayoutResult, kotlin.Unit> r48, androidx.compose.foundation.interaction.MutableInteractionSource r49, androidx.compose.ui.graphics.Brush r50, kotlin.jvm.functions.Function3<? super kotlin.jvm.functions.Function2<? super androidx.compose.runtime.Composer, ? super java.lang.Integer, kotlin.Unit>, ? super androidx.compose.runtime.Composer, ? super java.lang.Integer, kotlin.Unit> r51, androidx.compose.runtime.Composer r52, final int r53, final int r54, final int r55) {
        /*
            Method dump skipped, instruction units count: 1243
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.compose.foundation.text.BasicTextFieldKt.BasicTextField(java.lang.String, kotlin.jvm.functions.Function1, androidx.compose.ui.Modifier, boolean, boolean, androidx.compose.ui.text.TextStyle, androidx.compose.foundation.text.KeyboardOptions, androidx.compose.foundation.text.KeyboardActions, boolean, int, int, androidx.compose.ui.text.input.VisualTransformation, kotlin.jvm.functions.Function1, androidx.compose.foundation.interaction.MutableInteractionSource, androidx.compose.ui.graphics.Brush, kotlin.jvm.functions.Function3, androidx.compose.runtime.Composer, int, int, int):void");
    }

    private static final TextFieldValue BasicTextField$lambda$18(MutableState<TextFieldValue> mutableState) {
        return mutableState.getValue();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit BasicTextField$lambda$20$0(TextFieldValue textFieldValue, MutableState mutableState) {
        if (!TextRange.m8266equalsimpl0(textFieldValue.getSelection(), BasicTextField$lambda$18(mutableState).getSelection()) || !Intrinsics.areEqual(textFieldValue.getComposition(), BasicTextField$lambda$18(mutableState).getComposition())) {
            mutableState.setValue(textFieldValue);
        }
        return Unit.INSTANCE;
    }

    private static final String BasicTextField$lambda$22(MutableState<String> mutableState) {
        return mutableState.getValue();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit BasicTextField$lambda$24$0(Function1 function1, MutableState mutableState, MutableState mutableState2, TextFieldValue textFieldValue) {
        mutableState.setValue(textFieldValue);
        boolean zAreEqual = Intrinsics.areEqual(BasicTextField$lambda$22(mutableState2), textFieldValue.getText());
        mutableState2.setValue(textFieldValue.getText());
        if (!zAreEqual) {
            function1.invoke(textFieldValue.getText());
        }
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit BasicTextField$lambda$26$0(TextLayoutResult textLayoutResult) {
        return Unit.INSTANCE;
    }

    /* JADX WARN: Removed duplicated region for block: B:100:0x012d  */
    /* JADX WARN: Removed duplicated region for block: B:103:0x0133  */
    /* JADX WARN: Removed duplicated region for block: B:104:0x013c  */
    /* JADX WARN: Removed duplicated region for block: B:114:0x015c  */
    /* JADX WARN: Removed duplicated region for block: B:115:0x0161  */
    /* JADX WARN: Removed duplicated region for block: B:125:0x0183  */
    /* JADX WARN: Removed duplicated region for block: B:126:0x0186  */
    /* JADX WARN: Removed duplicated region for block: B:136:0x01a8  */
    /* JADX WARN: Removed duplicated region for block: B:137:0x01ab  */
    /* JADX WARN: Removed duplicated region for block: B:147:0x01cb  */
    /* JADX WARN: Removed duplicated region for block: B:148:0x01d0  */
    /* JADX WARN: Removed duplicated region for block: B:158:0x01ed  */
    /* JADX WARN: Removed duplicated region for block: B:159:0x01f0  */
    /* JADX WARN: Removed duplicated region for block: B:167:0x0212  */
    /* JADX WARN: Removed duplicated region for block: B:171:0x021f  */
    /* JADX WARN: Removed duplicated region for block: B:174:0x0229  */
    /* JADX WARN: Removed duplicated region for block: B:258:0x041a  */
    /* JADX WARN: Removed duplicated region for block: B:261:0x043b  */
    /* JADX WARN: Removed duplicated region for block: B:263:? A[RETURN, SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:30:0x005d  */
    /* JADX WARN: Removed duplicated region for block: B:31:0x0060  */
    /* JADX WARN: Removed duplicated region for block: B:41:0x007e  */
    /* JADX WARN: Removed duplicated region for block: B:42:0x0081  */
    /* JADX WARN: Removed duplicated region for block: B:52:0x009f  */
    /* JADX WARN: Removed duplicated region for block: B:53:0x00a4  */
    /* JADX WARN: Removed duplicated region for block: B:62:0x00bd  */
    /* JADX WARN: Removed duplicated region for block: B:63:0x00c2  */
    /* JADX WARN: Removed duplicated region for block: B:72:0x00db  */
    /* JADX WARN: Removed duplicated region for block: B:73:0x00e0  */
    /* JADX WARN: Removed duplicated region for block: B:82:0x00f9  */
    /* JADX WARN: Removed duplicated region for block: B:83:0x00fe  */
    /* JADX WARN: Removed duplicated region for block: B:92:0x0117  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public static final void BasicTextField(final androidx.compose.ui.text.input.TextFieldValue r37, final kotlin.jvm.functions.Function1<? super androidx.compose.ui.text.input.TextFieldValue, kotlin.Unit> r38, androidx.compose.ui.Modifier r39, boolean r40, boolean r41, androidx.compose.ui.text.TextStyle r42, androidx.compose.foundation.text.KeyboardOptions r43, androidx.compose.foundation.text.KeyboardActions r44, boolean r45, int r46, int r47, androidx.compose.ui.text.input.VisualTransformation r48, kotlin.jvm.functions.Function1<? super androidx.compose.ui.text.TextLayoutResult, kotlin.Unit> r49, androidx.compose.foundation.interaction.MutableInteractionSource r50, androidx.compose.ui.graphics.Brush r51, kotlin.jvm.functions.Function3<? super kotlin.jvm.functions.Function2<? super androidx.compose.runtime.Composer, ? super java.lang.Integer, kotlin.Unit>, ? super androidx.compose.runtime.Composer, ? super java.lang.Integer, kotlin.Unit> r52, androidx.compose.runtime.Composer r53, final int r54, final int r55, final int r56) {
        /*
            Method dump skipped, instruction units count: 1107
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.compose.foundation.text.BasicTextFieldKt.BasicTextField(androidx.compose.ui.text.input.TextFieldValue, kotlin.jvm.functions.Function1, androidx.compose.ui.Modifier, boolean, boolean, androidx.compose.ui.text.TextStyle, androidx.compose.foundation.text.KeyboardOptions, androidx.compose.foundation.text.KeyboardActions, boolean, int, int, androidx.compose.ui.text.input.VisualTransformation, kotlin.jvm.functions.Function1, androidx.compose.foundation.interaction.MutableInteractionSource, androidx.compose.ui.graphics.Brush, kotlin.jvm.functions.Function3, androidx.compose.runtime.Composer, int, int, int):void");
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit BasicTextField$lambda$27$0(TextFieldValue textFieldValue, Function1 function1, TextFieldValue textFieldValue2) {
        if (!Intrinsics.areEqual(textFieldValue, textFieldValue2)) {
            function1.invoke(textFieldValue2);
        }
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit BasicTextField$lambda$29$0(TextLayoutResult textLayoutResult) {
        return Unit.INSTANCE;
    }

    /* JADX WARN: Removed duplicated region for block: B:104:0x013b  */
    /* JADX WARN: Removed duplicated region for block: B:105:0x0142  */
    /* JADX WARN: Removed duplicated region for block: B:115:0x0162  */
    /* JADX WARN: Removed duplicated region for block: B:116:0x0167  */
    /* JADX WARN: Removed duplicated region for block: B:126:0x0189  */
    /* JADX WARN: Removed duplicated region for block: B:127:0x018c  */
    /* JADX WARN: Removed duplicated region for block: B:138:0x01ac  */
    /* JADX WARN: Removed duplicated region for block: B:139:0x01af  */
    /* JADX WARN: Removed duplicated region for block: B:149:0x01cf  */
    /* JADX WARN: Removed duplicated region for block: B:150:0x01d2  */
    /* JADX WARN: Removed duplicated region for block: B:161:0x01f8  */
    /* JADX WARN: Removed duplicated region for block: B:165:0x0202  */
    /* JADX WARN: Removed duplicated region for block: B:168:0x020c  */
    /* JADX WARN: Removed duplicated region for block: B:220:0x0330  */
    /* JADX WARN: Removed duplicated region for block: B:223:0x0351  */
    /* JADX WARN: Removed duplicated region for block: B:225:? A[RETURN, SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:31:0x0062  */
    /* JADX WARN: Removed duplicated region for block: B:32:0x0065  */
    /* JADX WARN: Removed duplicated region for block: B:42:0x0083  */
    /* JADX WARN: Removed duplicated region for block: B:43:0x0086  */
    /* JADX WARN: Removed duplicated region for block: B:53:0x00a2  */
    /* JADX WARN: Removed duplicated region for block: B:54:0x00a7  */
    /* JADX WARN: Removed duplicated region for block: B:63:0x00c0  */
    /* JADX WARN: Removed duplicated region for block: B:64:0x00c5  */
    /* JADX WARN: Removed duplicated region for block: B:73:0x00de  */
    /* JADX WARN: Removed duplicated region for block: B:74:0x00e3  */
    /* JADX WARN: Removed duplicated region for block: B:83:0x00fc  */
    /* JADX WARN: Removed duplicated region for block: B:84:0x0101  */
    /* JADX WARN: Removed duplicated region for block: B:93:0x011a  */
    /* JADX WARN: Removed duplicated region for block: B:94:0x011d  */
    @kotlin.Deprecated(level = kotlin.DeprecationLevel.HIDDEN, message = "Maintained for binary compatibility")
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public static final /* synthetic */ void BasicTextField(final java.lang.String r36, final kotlin.jvm.functions.Function1 r37, androidx.compose.ui.Modifier r38, boolean r39, boolean r40, androidx.compose.ui.text.TextStyle r41, androidx.compose.foundation.text.KeyboardOptions r42, androidx.compose.foundation.text.KeyboardActions r43, boolean r44, int r45, androidx.compose.ui.text.input.VisualTransformation r46, kotlin.jvm.functions.Function1 r47, androidx.compose.foundation.interaction.MutableInteractionSource r48, androidx.compose.ui.graphics.Brush r49, kotlin.jvm.functions.Function3 r50, androidx.compose.runtime.Composer r51, final int r52, final int r53, final int r54) {
        /*
            Method dump skipped, instruction units count: 873
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.compose.foundation.text.BasicTextFieldKt.BasicTextField(java.lang.String, kotlin.jvm.functions.Function1, androidx.compose.ui.Modifier, boolean, boolean, androidx.compose.ui.text.TextStyle, androidx.compose.foundation.text.KeyboardOptions, androidx.compose.foundation.text.KeyboardActions, boolean, int, androidx.compose.ui.text.input.VisualTransformation, kotlin.jvm.functions.Function1, androidx.compose.foundation.interaction.MutableInteractionSource, androidx.compose.ui.graphics.Brush, kotlin.jvm.functions.Function3, androidx.compose.runtime.Composer, int, int, int):void");
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit BasicTextField$lambda$32$0(TextLayoutResult textLayoutResult) {
        return Unit.INSTANCE;
    }

    /* JADX WARN: Removed duplicated region for block: B:104:0x013b  */
    /* JADX WARN: Removed duplicated region for block: B:105:0x0142  */
    /* JADX WARN: Removed duplicated region for block: B:115:0x0162  */
    /* JADX WARN: Removed duplicated region for block: B:116:0x0167  */
    /* JADX WARN: Removed duplicated region for block: B:126:0x0189  */
    /* JADX WARN: Removed duplicated region for block: B:127:0x018c  */
    /* JADX WARN: Removed duplicated region for block: B:138:0x01ac  */
    /* JADX WARN: Removed duplicated region for block: B:139:0x01af  */
    /* JADX WARN: Removed duplicated region for block: B:149:0x01cf  */
    /* JADX WARN: Removed duplicated region for block: B:150:0x01d2  */
    /* JADX WARN: Removed duplicated region for block: B:161:0x01f8  */
    /* JADX WARN: Removed duplicated region for block: B:165:0x0202  */
    /* JADX WARN: Removed duplicated region for block: B:168:0x020c  */
    /* JADX WARN: Removed duplicated region for block: B:220:0x0330  */
    /* JADX WARN: Removed duplicated region for block: B:223:0x0351  */
    /* JADX WARN: Removed duplicated region for block: B:225:? A[RETURN, SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:31:0x0062  */
    /* JADX WARN: Removed duplicated region for block: B:32:0x0065  */
    /* JADX WARN: Removed duplicated region for block: B:42:0x0083  */
    /* JADX WARN: Removed duplicated region for block: B:43:0x0086  */
    /* JADX WARN: Removed duplicated region for block: B:53:0x00a2  */
    /* JADX WARN: Removed duplicated region for block: B:54:0x00a7  */
    /* JADX WARN: Removed duplicated region for block: B:63:0x00c0  */
    /* JADX WARN: Removed duplicated region for block: B:64:0x00c5  */
    /* JADX WARN: Removed duplicated region for block: B:73:0x00de  */
    /* JADX WARN: Removed duplicated region for block: B:74:0x00e3  */
    /* JADX WARN: Removed duplicated region for block: B:83:0x00fc  */
    /* JADX WARN: Removed duplicated region for block: B:84:0x0101  */
    /* JADX WARN: Removed duplicated region for block: B:93:0x011a  */
    /* JADX WARN: Removed duplicated region for block: B:94:0x011d  */
    @kotlin.Deprecated(level = kotlin.DeprecationLevel.HIDDEN, message = "Maintained for binary compatibility")
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public static final /* synthetic */ void BasicTextField(final androidx.compose.ui.text.input.TextFieldValue r36, final kotlin.jvm.functions.Function1 r37, androidx.compose.ui.Modifier r38, boolean r39, boolean r40, androidx.compose.ui.text.TextStyle r41, androidx.compose.foundation.text.KeyboardOptions r42, androidx.compose.foundation.text.KeyboardActions r43, boolean r44, int r45, androidx.compose.ui.text.input.VisualTransformation r46, kotlin.jvm.functions.Function1 r47, androidx.compose.foundation.interaction.MutableInteractionSource r48, androidx.compose.ui.graphics.Brush r49, kotlin.jvm.functions.Function3 r50, androidx.compose.runtime.Composer r51, final int r52, final int r53, final int r54) {
        /*
            Method dump skipped, instruction units count: 873
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.compose.foundation.text.BasicTextFieldKt.BasicTextField(androidx.compose.ui.text.input.TextFieldValue, kotlin.jvm.functions.Function1, androidx.compose.ui.Modifier, boolean, boolean, androidx.compose.ui.text.TextStyle, androidx.compose.foundation.text.KeyboardOptions, androidx.compose.foundation.text.KeyboardActions, boolean, int, androidx.compose.ui.text.input.VisualTransformation, kotlin.jvm.functions.Function1, androidx.compose.foundation.interaction.MutableInteractionSource, androidx.compose.ui.graphics.Brush, kotlin.jvm.functions.Function3, androidx.compose.runtime.Composer, int, int, int):void");
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final DisposableEffectResult BasicTextField$lambda$12$0(final TextFieldSelectionState textFieldSelectionState, DisposableEffectScope disposableEffectScope) {
        return new DisposableEffectResult() { // from class: androidx.compose.foundation.text.BasicTextFieldKt$BasicTextField$lambda$12$0$$inlined$onDispose$1
            @Override // androidx.compose.runtime.DisposableEffectResult
            public void dispose() {
                textFieldSelectionState.dispose();
            }
        };
    }

    private static final boolean TextFieldCursorHandle$lambda$1(State<Boolean> state) {
        return state.getValue().booleanValue();
    }

    private static final TextFieldHandleState TextFieldSelectionHandles$lambda$1(State<TextFieldHandleState> state) {
        return state.getValue();
    }

    private static final TextFieldHandleState TextFieldSelectionHandles$lambda$5(State<TextFieldHandleState> state) {
        return state.getValue();
    }
}
