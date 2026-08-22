package androidx.compose.foundation.text.input.internal;

import android.view.KeyEvent;
import androidx.compose.foundation.FocusableNode;
import androidx.compose.foundation.content.ReceiveContentListener;
import androidx.compose.foundation.content.TransferableContent;
import androidx.compose.foundation.content.TransferableContent_androidKt;
import androidx.compose.foundation.content.internal.DragAndDropRequestPermission_androidKt;
import androidx.compose.foundation.content.internal.ReceiveContentConfiguration;
import androidx.compose.foundation.content.internal.ReceiveContentConfigurationKt;
import androidx.compose.foundation.interaction.MutableInteractionSource;
import androidx.compose.foundation.text.AutofillHighlightKt;
import androidx.compose.foundation.text.AutofillHighlight_androidKt;
import androidx.compose.foundation.text.Handle;
import androidx.compose.foundation.text.KeyCommand;
import androidx.compose.foundation.text.KeyboardOptions;
import androidx.compose.foundation.text.input.InputTransformation;
import androidx.compose.foundation.text.input.KeyboardActionHandler;
import androidx.compose.foundation.text.input.TextFieldBuffer;
import androidx.compose.foundation.text.input.TextFieldCharSequence;
import androidx.compose.foundation.text.input.TextFieldState;
import androidx.compose.foundation.text.input.internal.DragAndDropHoverInteraction;
import androidx.compose.foundation.text.input.internal.TextFieldDecoratorModifierNode;
import androidx.compose.foundation.text.input.internal.selection.TextFieldSelectionState;
import androidx.compose.foundation.text.input.internal.selection.TextToolbarState;
import androidx.compose.foundation.text.input.internal.undo.TextFieldEditUndoBehavior;
import androidx.compose.runtime.MutableState;
import androidx.compose.runtime.SnapshotStateKt;
import androidx.compose.runtime.SnapshotStateKt__SnapshotStateKt;
import androidx.compose.ui.autofill.ContentDataType;
import androidx.compose.ui.autofill.ContentType;
import androidx.compose.ui.autofill.FillableData;
import androidx.compose.ui.autofill.FillableData_androidKt;
import androidx.compose.ui.draganddrop.DragAndDropEvent;
import androidx.compose.ui.draganddrop.DragAndDropTargetModifierNode;
import androidx.compose.ui.focus.FocusDirection;
import androidx.compose.ui.focus.FocusManager;
import androidx.compose.ui.focus.FocusProperties;
import androidx.compose.ui.focus.FocusPropertiesModifierNode;
import androidx.compose.ui.geometry.Offset;
import androidx.compose.ui.graphics.Brush;
import androidx.compose.ui.graphics.Color;
import androidx.compose.ui.graphics.drawscope.ContentDrawScope;
import androidx.compose.ui.graphics.drawscope.DrawScope;
import androidx.compose.ui.input.InputMode;
import androidx.compose.ui.input.InputModeManager;
import androidx.compose.ui.input.key.KeyInputModifierNode;
import androidx.compose.ui.input.pointer.PointerEvent;
import androidx.compose.ui.input.pointer.PointerEventPass;
import androidx.compose.ui.input.pointer.PointerInputEventHandler;
import androidx.compose.ui.input.pointer.PointerInputScope;
import androidx.compose.ui.input.pointer.SuspendingPointerInputFilterKt;
import androidx.compose.ui.input.pointer.SuspendingPointerInputModifierNode;
import androidx.compose.ui.layout.LayoutCoordinates;
import androidx.compose.ui.modifier.ModifierLocalModifierNode;
import androidx.compose.ui.node.CompositionLocalConsumerModifierNode;
import androidx.compose.ui.node.CompositionLocalConsumerModifierNodeKt;
import androidx.compose.ui.node.DelegatableNodeKt;
import androidx.compose.ui.node.DelegatingNode;
import androidx.compose.ui.node.DrawModifierNode;
import androidx.compose.ui.node.GlobalPositionAwareModifierNode;
import androidx.compose.ui.node.LayoutAwareModifierNode;
import androidx.compose.ui.node.ObserverModifierNode;
import androidx.compose.ui.node.ObserverModifierNodeKt;
import androidx.compose.ui.node.PointerInputModifierNode;
import androidx.compose.ui.node.SemanticsModifierNode;
import androidx.compose.ui.node.SemanticsModifierNodeKt;
import androidx.compose.ui.platform.ClipEntry;
import androidx.compose.ui.platform.ClipMetadata;
import androidx.compose.ui.platform.CompositionLocalsKt;
import androidx.compose.ui.platform.PlatformTextInputModifierNode;
import androidx.compose.ui.platform.PlatformTextInputModifierNodeKt;
import androidx.compose.ui.platform.PlatformTextInputSessionScope;
import androidx.compose.ui.platform.SoftwareKeyboardController;
import androidx.compose.ui.platform.ViewConfiguration;
import androidx.compose.ui.platform.WindowInfo;
import androidx.compose.ui.semantics.InputTextSuggestionState;
import androidx.compose.ui.semantics.SemanticsPropertiesKt;
import androidx.compose.ui.semantics.SemanticsPropertyReceiver;
import androidx.compose.ui.text.AnnotatedString;
import androidx.compose.ui.text.TextLayoutResult;
import androidx.compose.ui.text.TextRange;
import androidx.compose.ui.text.TextRangeKt;
import androidx.compose.ui.text.input.ImeAction;
import androidx.compose.ui.text.input.ImeOptions;
import androidx.compose.ui.text.input.KeyboardType;
import java.util.List;
import java.util.Set;
import java.util.concurrent.CancellationException;
import kotlin.KotlinNothingValueException;
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
import kotlin.jvm.internal.AdaptedFunctionReference;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.coroutines.BuildersKt__Builders_commonKt;
import kotlinx.coroutines.CoroutineScope;
import kotlinx.coroutines.CoroutineScopeKt;
import kotlinx.coroutines.CoroutineStart;
import kotlinx.coroutines.Job;
import kotlinx.coroutines.flow.FlowCollector;
import kotlinx.coroutines.flow.FlowKt;
import kotlinx.coroutines.flow.MutableSharedFlow;
import org.jivesoftware.smack.sm.packet.StreamManagement;

/* JADX INFO: compiled from: TextFieldDecoratorModifier.kt */
/* JADX INFO: loaded from: classes.dex */
@Metadata(d1 = {"\u0000\u008b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\b,\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0010\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0005*\u0001^\b\u0001\u0018\u00002\u00020\u00012\u00020\u00022\u00020\u00032\u00020\u00042\u00020\u00052\u00020\u00062\u00020\u00072\u00020\b2\u00020\t2\u00020\n2\u00020\u000b2\u00020\fBs\u0012\u0006\u0010\r\u001a\u00020\u000e\u0012\u0006\u0010\u000f\u001a\u00020\u0010\u0012\u0006\u0010\u0011\u001a\u00020\u0012\u0012\b\u0010\u0013\u001a\u0004\u0018\u00010\u0014\u0012\u0006\u0010\u0015\u001a\u00020\u0016\u0012\u0006\u0010\u0017\u001a\u00020\u0016\u0012\u0006\u0010\u0018\u001a\u00020\u0019\u0012\b\u0010\u001a\u001a\u0004\u0018\u00010\u001b\u0012\u0006\u0010\u001c\u001a\u00020\u0016\u0012\u0006\u0010\u001d\u001a\u00020\u001e\u0012\u0006\u0010\u001f\u001a\u00020\u0016\u0012\u000e\u0010 \u001a\n\u0012\u0004\u0012\u00020\"\u0018\u00010!¢\u0006\u0004\b#\u0010$J\f\u0010m\u001a\u00020\"*\u00020nH\u0016J\u000e\u0010o\u001a\u00020\"H\u0082@¢\u0006\u0002\u0010pJr\u0010q\u001a\u00020\"2\u0006\u0010\r\u001a\u00020\u000e2\u0006\u0010\u000f\u001a\u00020\u00102\u0006\u0010\u0011\u001a\u00020\u00122\b\u0010\u0013\u001a\u0004\u0018\u00010\u00142\u0006\u0010\u0015\u001a\u00020\u00162\u0006\u0010\u0017\u001a\u00020\u00162\u0006\u0010\u0018\u001a\u00020\u00192\b\u0010\u001a\u001a\u0004\u0018\u00010\u001b2\u0006\u0010\u001c\u001a\u00020\u00162\u0006\u0010\u001d\u001a\u00020\u001e2\u0006\u0010\u001f\u001a\u00020\u00162\u000e\u0010 \u001a\n\u0012\u0004\u0012\u00020\"\u0018\u00010!J\f\u0010t\u001a\u00020\"*\u00020uH\u0016J\b\u0010v\u001a\u00020\"H\u0002J\b\u0010w\u001a\u00020\"H\u0002J\u0010\u0010x\u001a\u00020\"2\u0006\u0010y\u001a\u00020zH\u0016J\b\u0010{\u001a\u00020\"H\u0016J\b\u0010|\u001a\u00020\"H\u0016J\u0010\u0010}\u001a\u00020\"2\u0006\u0010~\u001a\u00020\u007fH\u0016J0\u0010\u0080\u0001\u001a\u00020\"2\b\u0010\u0081\u0001\u001a\u00030\u0082\u00012\b\u0010\u0083\u0001\u001a\u00030\u0084\u00012\b\u0010\u0085\u0001\u001a\u00030\u0086\u0001H\u0016¢\u0006\u0006\b\u0087\u0001\u0010\u0088\u0001J\t\u0010\u0089\u0001\u001a\u00020\"H\u0016J\u001c\u0010\u008a\u0001\u001a\u00020\u00162\b\u0010\u008b\u0001\u001a\u00030\u008c\u0001H\u0016¢\u0006\u0006\b\u008d\u0001\u0010\u008e\u0001J\u001c\u0010\u008f\u0001\u001a\u00020\u00162\b\u0010\u008b\u0001\u001a\u00030\u008c\u0001H\u0016¢\u0006\u0006\b\u0090\u0001\u0010\u008e\u0001J\t\u0010\u0091\u0001\u001a\u00020\"H\u0016J\t\u0010\u0092\u0001\u001a\u00020\"H\u0002J\u0011\u0010\u0093\u0001\u001a\u00020\"2\u0006\u0010~\u001a\u00020\u007fH\u0016J\u001c\u0010\u0094\u0001\u001a\u00020\"2\b\u0010\u0095\u0001\u001a\u00030\u0086\u0001H\u0016¢\u0006\u0006\b\u0096\u0001\u0010\u0097\u0001J\t\u0010\u0098\u0001\u001a\u00020\"H\u0002J\u0012\u0010\u0099\u0001\u001a\u00020\"2\u0007\u0010\u009a\u0001\u001a\u00020\u0016H\u0002J\t\u0010\u009b\u0001\u001a\u00020\"H\u0002J\n\u0010\u009c\u0001\u001a\u00030\u009d\u0001H\u0002J\t\u0010\u009e\u0001\u001a\u00020\"H\u0002J\u001c\u0010\u009f\u0001\u001a\u00020\u00162\b\u0010 \u0001\u001a\u00030¡\u0001H\u0002¢\u0006\u0006\b¢\u0001\u0010£\u0001J\u001c\u0010¤\u0001\u001a\u00020\u00162\b\u0010 \u0001\u001a\u00030¡\u0001H\u0002¢\u0006\u0006\b¥\u0001\u0010£\u0001R\u001a\u0010\r\u001a\u00020\u000eX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b%\u0010&\"\u0004\b'\u0010(R\u001a\u0010\u000f\u001a\u00020\u0010X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b)\u0010*\"\u0004\b+\u0010,R\u001a\u0010\u0011\u001a\u00020\u0012X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b-\u0010.\"\u0004\b/\u00100R\u001c\u0010\u0013\u001a\u0004\u0018\u00010\u0014X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b1\u00102\"\u0004\b3\u00104R\u001a\u0010\u0015\u001a\u00020\u0016X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b5\u00106\"\u0004\b7\u00108R\u001a\u0010\u0017\u001a\u00020\u0016X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b9\u00106\"\u0004\b:\u00108R\u001a\u0010\u0018\u001a\u00020\u0019X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b;\u0010<\"\u0004\b=\u0010>R\u001c\u0010\u001a\u001a\u0004\u0018\u00010\u001bX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b?\u0010@\"\u0004\bA\u0010BR\u001a\u0010\u001c\u001a\u00020\u0016X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\bC\u00106\"\u0004\bD\u00108R\u001a\u0010\u001d\u001a\u00020\u001eX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\bE\u0010F\"\u0004\bG\u0010HR\u001a\u0010\u001f\u001a\u00020\u0016X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u001f\u00106\"\u0004\bI\u00108R\"\u0010 \u001a\n\u0012\u0004\u0012\u00020\"\u0018\u00010!X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\bJ\u0010K\"\u0004\bL\u0010MR\u000e\u0010N\u001a\u00020OX\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010P\u001a\u00020QX\u0082\u0004¢\u0006\u0002\n\u0000R\u0010\u0010R\u001a\u0004\u0018\u00010SX\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010T\u001a\u00020UX\u0082\u0004¢\u0006\u0002\n\u0000R\u0010\u0010V\u001a\u0004\u0018\u00010WX\u0082\u000e¢\u0006\u0002\n\u0000R\u0014\u0010X\u001a\u00020\u00168BX\u0082\u0004¢\u0006\u0006\u001a\u0004\bX\u00106R\u0010\u0010Y\u001a\u0004\u0018\u00010ZX\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010[\u001a\u00020\\X\u0082\u0004¢\u0006\u0002\n\u0000R\u0010\u0010]\u001a\u00020^X\u0082\u0004¢\u0006\u0004\n\u0002\u0010_R\u0010\u0010`\u001a\u00020aX\u0082\u0004¢\u0006\u0004\n\u0002\u0010bR\u0010\u0010c\u001a\u0004\u0018\u00010ZX\u0082\u000e¢\u0006\u0002\n\u0000R\u0016\u0010d\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010f0eX\u0082\u0004¢\u0006\u0002\n\u0000R+\u0010h\u001a\u00020\u00162\u0006\u0010g\u001a\u00020\u00168B@BX\u0082\u008e\u0002¢\u0006\u0012\n\u0004\bk\u0010l\u001a\u0004\bi\u00106\"\u0004\bj\u00108R\u0014\u0010r\u001a\u00020\u00168VX\u0096\u0004¢\u0006\u0006\u001a\u0004\bs\u00106¨\u0006¦\u0001"}, d2 = {"Landroidx/compose/foundation/text/input/internal/TextFieldDecoratorModifierNode;", "Landroidx/compose/ui/node/DelegatingNode;", "Landroidx/compose/ui/node/DrawModifierNode;", "Landroidx/compose/ui/platform/PlatformTextInputModifierNode;", "Landroidx/compose/ui/node/SemanticsModifierNode;", "Landroidx/compose/ui/node/GlobalPositionAwareModifierNode;", "Landroidx/compose/ui/node/PointerInputModifierNode;", "Landroidx/compose/ui/input/key/KeyInputModifierNode;", "Landroidx/compose/ui/node/CompositionLocalConsumerModifierNode;", "Landroidx/compose/ui/modifier/ModifierLocalModifierNode;", "Landroidx/compose/ui/node/ObserverModifierNode;", "Landroidx/compose/ui/node/LayoutAwareModifierNode;", "Landroidx/compose/ui/focus/FocusPropertiesModifierNode;", "textFieldState", "Landroidx/compose/foundation/text/input/internal/TransformedTextFieldState;", "textLayoutState", "Landroidx/compose/foundation/text/input/internal/TextLayoutState;", "textFieldSelectionState", "Landroidx/compose/foundation/text/input/internal/selection/TextFieldSelectionState;", "filter", "Landroidx/compose/foundation/text/input/InputTransformation;", StreamManagement.Enabled.ELEMENT, "", "readOnly", "keyboardOptions", "Landroidx/compose/foundation/text/KeyboardOptions;", "keyboardActionHandler", "Landroidx/compose/foundation/text/input/KeyboardActionHandler;", "singleLine", "interactionSource", "Landroidx/compose/foundation/interaction/MutableInteractionSource;", "isPassword", "stylusHandwritingTrigger", "Lkotlinx/coroutines/flow/MutableSharedFlow;", "", "<init>", "(Landroidx/compose/foundation/text/input/internal/TransformedTextFieldState;Landroidx/compose/foundation/text/input/internal/TextLayoutState;Landroidx/compose/foundation/text/input/internal/selection/TextFieldSelectionState;Landroidx/compose/foundation/text/input/InputTransformation;ZZLandroidx/compose/foundation/text/KeyboardOptions;Landroidx/compose/foundation/text/input/KeyboardActionHandler;ZLandroidx/compose/foundation/interaction/MutableInteractionSource;ZLkotlinx/coroutines/flow/MutableSharedFlow;)V", "getTextFieldState", "()Landroidx/compose/foundation/text/input/internal/TransformedTextFieldState;", "setTextFieldState", "(Landroidx/compose/foundation/text/input/internal/TransformedTextFieldState;)V", "getTextLayoutState", "()Landroidx/compose/foundation/text/input/internal/TextLayoutState;", "setTextLayoutState", "(Landroidx/compose/foundation/text/input/internal/TextLayoutState;)V", "getTextFieldSelectionState", "()Landroidx/compose/foundation/text/input/internal/selection/TextFieldSelectionState;", "setTextFieldSelectionState", "(Landroidx/compose/foundation/text/input/internal/selection/TextFieldSelectionState;)V", "getFilter", "()Landroidx/compose/foundation/text/input/InputTransformation;", "setFilter", "(Landroidx/compose/foundation/text/input/InputTransformation;)V", "getEnabled", "()Z", "setEnabled", "(Z)V", "getReadOnly", "setReadOnly", "getKeyboardOptions", "()Landroidx/compose/foundation/text/KeyboardOptions;", "setKeyboardOptions", "(Landroidx/compose/foundation/text/KeyboardOptions;)V", "getKeyboardActionHandler", "()Landroidx/compose/foundation/text/input/KeyboardActionHandler;", "setKeyboardActionHandler", "(Landroidx/compose/foundation/text/input/KeyboardActionHandler;)V", "getSingleLine", "setSingleLine", "getInteractionSource", "()Landroidx/compose/foundation/interaction/MutableInteractionSource;", "setInteractionSource", "(Landroidx/compose/foundation/interaction/MutableInteractionSource;)V", "setPassword", "getStylusHandwritingTrigger", "()Lkotlinx/coroutines/flow/MutableSharedFlow;", "setStylusHandwritingTrigger", "(Lkotlinx/coroutines/flow/MutableSharedFlow;)V", "focusableNode", "Landroidx/compose/foundation/FocusableNode;", "pointerInputNode", "Landroidx/compose/ui/input/pointer/SuspendingPointerInputModifierNode;", "dragEnterEvent", "Landroidx/compose/foundation/text/input/internal/DragAndDropHoverInteraction$Enter;", "dragAndDropNode", "Landroidx/compose/ui/draganddrop/DragAndDropTargetModifierNode;", "windowInfo", "Landroidx/compose/ui/platform/WindowInfo;", "isFocused", "toolbarAndHandlesVisibilityObserverJob", "Lkotlinx/coroutines/Job;", "textFieldKeyEventHandler", "Landroidx/compose/foundation/text/input/internal/TextFieldKeyEventHandler;", "keyboardActionScope", "androidx/compose/foundation/text/input/internal/TextFieldDecoratorModifierNode$keyboardActionScope$1", "Landroidx/compose/foundation/text/input/internal/TextFieldDecoratorModifierNode$keyboardActionScope$1;", "clipboardKeyCommandsHandler", "Landroidx/compose/foundation/text/input/internal/ClipboardKeyCommandsHandler;", "Lkotlin/jvm/functions/Function1;", "inputSessionJob", "receiveContentConfigurationProvider", "Lkotlin/Function0;", "Landroidx/compose/foundation/content/internal/ReceiveContentConfiguration;", "<set-?>", "autofillHighlightOn", "getAutofillHighlightOn", "setAutofillHighlightOn", "autofillHighlightOn$delegate", "Landroidx/compose/runtime/MutableState;", "draw", "Landroidx/compose/ui/graphics/drawscope/ContentDrawScope;", "observeUntransformedTextChanges", "(Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "updateNode", "shouldMergeDescendantSemantics", "getShouldMergeDescendantSemantics", "applySemantics", "Landroidx/compose/ui/semantics/SemanticsPropertyReceiver;", "requestFocus", "onIsFocusedUpdated", "applyFocusProperties", "focusProperties", "Landroidx/compose/ui/focus/FocusProperties;", "onAttach", "onDetach", "onGloballyPositioned", "coordinates", "Landroidx/compose/ui/layout/LayoutCoordinates;", "onPointerEvent", "pointerEvent", "Landroidx/compose/ui/input/pointer/PointerEvent;", "pass", "Landroidx/compose/ui/input/pointer/PointerEventPass;", "bounds", "Landroidx/compose/ui/unit/IntSize;", "onPointerEvent-H0pRuoY", "(Landroidx/compose/ui/input/pointer/PointerEvent;Landroidx/compose/ui/input/pointer/PointerEventPass;J)V", "onCancelPointerInput", "onPreKeyEvent", "event", "Landroidx/compose/ui/input/key/KeyEvent;", "onPreKeyEvent-ZmokQxo", "(Landroid/view/KeyEvent;)Z", "onKeyEvent", "onKeyEvent-ZmokQxo", "onObservedReadsChanged", "updateWindowFocus", "onPlaced", "onRemeasured", "size", "onRemeasured-ozmzZPI", "(J)V", "applyCurrentInputMode", "startInputSession", "fromTap", "disposeInputSession", "requireKeyboardController", "Landroidx/compose/ui/platform/SoftwareKeyboardController;", "emitDragExitEvent", "onImeActionPerformed", "imeAction", "Landroidx/compose/ui/text/input/ImeAction;", "onImeActionPerformed-KlQnJC8", "(I)Z", "defaultKeyboardActionWithResult", "defaultKeyboardActionWithResult-KlQnJC8", "foundation"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final class TextFieldDecoratorModifierNode extends DelegatingNode implements DrawModifierNode, PlatformTextInputModifierNode, SemanticsModifierNode, GlobalPositionAwareModifierNode, PointerInputModifierNode, KeyInputModifierNode, CompositionLocalConsumerModifierNode, ModifierLocalModifierNode, ObserverModifierNode, LayoutAwareModifierNode, FocusPropertiesModifierNode {
    public static final int $stable = 8;

    /* JADX INFO: renamed from: autofillHighlightOn$delegate, reason: from kotlin metadata */
    private final MutableState autofillHighlightOn;
    private final Function1<? super KeyCommand, ? extends Unit> clipboardKeyCommandsHandler;
    private final DragAndDropTargetModifierNode dragAndDropNode;
    private DragAndDropHoverInteraction.Enter dragEnterEvent;
    private boolean enabled;
    private InputTransformation filter;
    private final FocusableNode focusableNode;
    private Job inputSessionJob;
    private MutableInteractionSource interactionSource;
    private boolean isPassword;
    private KeyboardActionHandler keyboardActionHandler;
    private final TextFieldDecoratorModifierNode$keyboardActionScope$1 keyboardActionScope;
    private KeyboardOptions keyboardOptions;
    private final SuspendingPointerInputModifierNode pointerInputNode;
    private boolean readOnly;
    private final Function0<ReceiveContentConfiguration> receiveContentConfigurationProvider;
    private boolean singleLine;
    private MutableSharedFlow<Unit> stylusHandwritingTrigger;
    private final TextFieldKeyEventHandler textFieldKeyEventHandler;
    private TextFieldSelectionState textFieldSelectionState;
    private TransformedTextFieldState textFieldState;
    private TextLayoutState textLayoutState;
    private Job toolbarAndHandlesVisibilityObserverJob;
    private WindowInfo windowInfo;

    @Override // androidx.compose.ui.node.SemanticsModifierNode
    public boolean getShouldMergeDescendantSemantics() {
        return true;
    }

    public TextFieldDecoratorModifierNode(TransformedTextFieldState transformedTextFieldState, TextLayoutState textLayoutState, TextFieldSelectionState textFieldSelectionState, InputTransformation inputTransformation, boolean z, boolean z2, KeyboardOptions keyboardOptions, KeyboardActionHandler keyboardActionHandler, boolean z3, MutableInteractionSource mutableInteractionSource, boolean z4, MutableSharedFlow<Unit> mutableSharedFlow) {
        this.textFieldState = transformedTextFieldState;
        this.textLayoutState = textLayoutState;
        this.textFieldSelectionState = textFieldSelectionState;
        this.filter = inputTransformation;
        this.enabled = z;
        this.readOnly = z2;
        this.keyboardOptions = keyboardOptions;
        this.keyboardActionHandler = keyboardActionHandler;
        this.singleLine = z3;
        this.interactionSource = mutableInteractionSource;
        this.isPassword = z4;
        this.stylusHandwritingTrigger = mutableSharedFlow;
        textFieldSelectionState.setRequestAutofillAction(new Function0() { // from class: androidx.compose.foundation.text.input.internal.TextFieldDecoratorModifierNode$$ExternalSyntheticLambda5
            @Override // kotlin.jvm.functions.Function0
            public final Object invoke() {
                return TextFieldDecoratorModifierNode._init_$lambda$0(this.f$0);
            }
        });
        this.focusableNode = new FocusableNode(this.interactionSource, 0, new Function1() { // from class: androidx.compose.foundation.text.input.internal.TextFieldDecoratorModifierNode$$ExternalSyntheticLambda7
            @Override // kotlin.jvm.functions.Function1
            public final Object invoke(Object obj) {
                return TextFieldDecoratorModifierNode.focusableNode$lambda$0(this.f$0, ((Boolean) obj).booleanValue());
            }
        }, 2, null);
        this.pointerInputNode = (SuspendingPointerInputModifierNode) delegate(SuspendingPointerInputFilterKt.SuspendingPointerInputModifierNode(new PointerInputEventHandler() { // from class: androidx.compose.foundation.text.input.internal.TextFieldDecoratorModifierNode$pointerInputNode$1

            /* JADX INFO: renamed from: androidx.compose.foundation.text.input.internal.TextFieldDecoratorModifierNode$pointerInputNode$1$1, reason: invalid class name */
            /* JADX INFO: compiled from: TextFieldDecoratorModifier.kt */
            @Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\n"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {2, 1, 0}, xi = 48)
            @DebugMetadata(c = "androidx.compose.foundation.text.input.internal.TextFieldDecoratorModifierNode$pointerInputNode$1$1", f = "TextFieldDecoratorModifier.kt", i = {}, l = {}, m = "invokeSuspend", n = {}, s = {}, v = 1)
            static final class AnonymousClass1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
                final /* synthetic */ PointerInputScope $this_SuspendingPointerInputModifierNode;
                private /* synthetic */ Object L$0;
                int label;
                final /* synthetic */ TextFieldDecoratorModifierNode this$0;

                /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                AnonymousClass1(TextFieldDecoratorModifierNode textFieldDecoratorModifierNode, PointerInputScope pointerInputScope, Continuation<? super AnonymousClass1> continuation) {
                    super(2, continuation);
                    this.this$0 = textFieldDecoratorModifierNode;
                    this.$this_SuspendingPointerInputModifierNode = pointerInputScope;
                }

                @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
                public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
                    AnonymousClass1 anonymousClass1 = new AnonymousClass1(this.this$0, this.$this_SuspendingPointerInputModifierNode, continuation);
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
                    if (this.label != 0) {
                        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                    }
                    ResultKt.throwOnFailure(obj);
                    CoroutineScope coroutineScope = (CoroutineScope) this.L$0;
                    final TextFieldSelectionState textFieldSelectionState = this.this$0.getTextFieldSelectionState();
                    final TextFieldDecoratorModifierNode textFieldDecoratorModifierNode = this.this$0;
                    PointerInputScope pointerInputScope = this.$this_SuspendingPointerInputModifierNode;
                    Function0 function0 = 
                    /*  JADX ERROR: Method code generation error
                        jadx.core.utils.exceptions.CodegenException: Error generate insn: 0x001b: CONSTRUCTOR (r8v0 'function0' kotlin.jvm.functions.Function0) = 
                          (r12v4 'textFieldSelectionState' androidx.compose.foundation.text.input.internal.selection.TextFieldSelectionState A[DONT_INLINE])
                          (r6v0 'textFieldDecoratorModifierNode' androidx.compose.foundation.text.input.internal.TextFieldDecoratorModifierNode A[DONT_INLINE])
                         A[DECLARE_VAR, MD:(androidx.compose.foundation.text.input.internal.selection.TextFieldSelectionState, androidx.compose.foundation.text.input.internal.TextFieldDecoratorModifierNode):void (m)] (LINE:251) call: androidx.compose.foundation.text.input.internal.TextFieldDecoratorModifierNode$pointerInputNode$1$1$$ExternalSyntheticLambda0.<init>(androidx.compose.foundation.text.input.internal.selection.TextFieldSelectionState, androidx.compose.foundation.text.input.internal.TextFieldDecoratorModifierNode):void type: CONSTRUCTOR in method: androidx.compose.foundation.text.input.internal.TextFieldDecoratorModifierNode$pointerInputNode$1.1.invokeSuspend(java.lang.Object):java.lang.Object, file: classes.dex
                        	at jadx.core.codegen.InsnGen.makeInsn(InsnGen.java:310)
                        	at jadx.core.codegen.InsnGen.makeInsn(InsnGen.java:273)
                        	at jadx.core.codegen.RegionGen.makeSimpleBlock(RegionGen.java:94)
                        	at jadx.core.dex.nodes.IBlock.generate(IBlock.java:15)
                        	at jadx.core.codegen.RegionGen.makeRegion(RegionGen.java:66)
                        	at jadx.core.dex.regions.Region.generate(Region.java:35)
                        	at jadx.core.codegen.RegionGen.makeRegion(RegionGen.java:66)
                        	at jadx.core.dex.regions.Region.generate(Region.java:35)
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
                        	at jadx.core.codegen.InsnGen.inlineAnonymousConstructor(InsnGen.java:845)
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
                        	at jadx.core.codegen.InsnGen.generateMethodArguments(InsnGen.java:1143)
                        	at jadx.core.codegen.InsnGen.makeInvoke(InsnGen.java:910)
                        	at jadx.core.codegen.InsnGen.makeInsnBody(InsnGen.java:422)
                        	at jadx.core.codegen.InsnGen.addWrappedArg(InsnGen.java:145)
                        	at jadx.core.codegen.InsnGen.addArg(InsnGen.java:121)
                        	at jadx.core.codegen.InsnGen.addArg(InsnGen.java:108)
                        	at jadx.core.codegen.InsnGen.makeInsnBody(InsnGen.java:345)
                        	at jadx.core.codegen.InsnGen.addWrappedArg(InsnGen.java:145)
                        	at jadx.core.codegen.InsnGen.addArg(InsnGen.java:121)
                        	at jadx.core.codegen.InsnGen.addArg(InsnGen.java:108)
                        	at jadx.core.codegen.InsnGen.makeInsnBody(InsnGen.java:487)
                        	at jadx.core.codegen.InsnGen.makeInsn(InsnGen.java:303)
                        	at jadx.core.codegen.InsnGen.makeInsn(InsnGen.java:273)
                        	at jadx.core.codegen.RegionGen.makeSimpleBlock(RegionGen.java:94)
                        	at jadx.core.dex.nodes.IBlock.generate(IBlock.java:15)
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
                        Caused by: jadx.core.utils.exceptions.JadxRuntimeException: Expected class to be processed at this point, class: androidx.compose.foundation.text.input.internal.TextFieldDecoratorModifierNode$pointerInputNode$1$1$$ExternalSyntheticLambda0, state: NOT_LOADED
                        	at jadx.core.dex.nodes.ClassNode.ensureProcessed(ClassNode.java:306)
                        	at jadx.core.codegen.InsnGen.inlineAnonymousConstructor(InsnGen.java:807)
                        	at jadx.core.codegen.InsnGen.makeConstructor(InsnGen.java:730)
                        	at jadx.core.codegen.InsnGen.makeInsnBody(InsnGen.java:418)
                        	at jadx.core.codegen.InsnGen.makeInsn(InsnGen.java:303)
                        	... 104 more
                        */
                    /*
                        this = this;
                        kotlin.coroutines.intrinsics.IntrinsicsKt.getCOROUTINE_SUSPENDED()
                        int r0 = r11.label
                        if (r0 != 0) goto L58
                        kotlin.ResultKt.throwOnFailure(r12)
                        java.lang.Object r12 = r11.L$0
                        r0 = r12
                        kotlinx.coroutines.CoroutineScope r0 = (kotlinx.coroutines.CoroutineScope) r0
                        androidx.compose.foundation.text.input.internal.TextFieldDecoratorModifierNode r12 = r11.this$0
                        androidx.compose.foundation.text.input.internal.selection.TextFieldSelectionState r12 = r12.getTextFieldSelectionState()
                        androidx.compose.foundation.text.input.internal.TextFieldDecoratorModifierNode r6 = r11.this$0
                        androidx.compose.ui.input.pointer.PointerInputScope r7 = r11.$this_SuspendingPointerInputModifierNode
                        androidx.compose.foundation.text.input.internal.TextFieldDecoratorModifierNode$pointerInputNode$1$1$$ExternalSyntheticLambda0 r8 = new androidx.compose.foundation.text.input.internal.TextFieldDecoratorModifierNode$pointerInputNode$1$1$$ExternalSyntheticLambda0
                        r8.<init>(r12, r6)
                        kotlinx.coroutines.CoroutineStart r2 = kotlinx.coroutines.CoroutineStart.UNDISPATCHED
                        androidx.compose.foundation.text.input.internal.TextFieldDecoratorModifierNode$pointerInputNode$1$1$1$1 r1 = new androidx.compose.foundation.text.input.internal.TextFieldDecoratorModifierNode$pointerInputNode$1$1$1$1
                        r9 = 0
                        r1.<init>(r12, r7, r9)
                        r3 = r1
                        kotlin.jvm.functions.Function2 r3 = (kotlin.jvm.functions.Function2) r3
                        r4 = 1
                        r5 = 0
                        r1 = 0
                        kotlinx.coroutines.BuildersKt.launch$default(r0, r1, r2, r3, r4, r5)
                        kotlinx.coroutines.CoroutineStart r10 = kotlinx.coroutines.CoroutineStart.UNDISPATCHED
                        androidx.compose.foundation.text.input.internal.TextFieldDecoratorModifierNode$pointerInputNode$1$1$1$2 r1 = new androidx.compose.foundation.text.input.internal.TextFieldDecoratorModifierNode$pointerInputNode$1$1$1$2
                        r2 = r6
                        r6 = 0
                        r3 = r12
                        r4 = r7
                        r5 = r8
                        r1.<init>(r2, r3, r4, r5, r6)
                        r6 = r4
                        r7 = r5
                        r3 = r1
                        kotlin.jvm.functions.Function2 r3 = (kotlin.jvm.functions.Function2) r3
                        r4 = 1
                        r5 = 0
                        r1 = 0
                        r2 = r10
                        kotlinx.coroutines.BuildersKt.launch$default(r0, r1, r2, r3, r4, r5)
                        kotlinx.coroutines.CoroutineStart r2 = kotlinx.coroutines.CoroutineStart.UNDISPATCHED
                        androidx.compose.foundation.text.input.internal.TextFieldDecoratorModifierNode$pointerInputNode$1$1$1$3 r1 = new androidx.compose.foundation.text.input.internal.TextFieldDecoratorModifierNode$pointerInputNode$1$1$1$3
                        r1.<init>(r12, r6, r7, r9)
                        r3 = r1
                        kotlin.jvm.functions.Function2 r3 = (kotlin.jvm.functions.Function2) r3
                        r1 = 0
                        kotlinx.coroutines.BuildersKt.launch$default(r0, r1, r2, r3, r4, r5)
                        kotlin.Unit r12 = kotlin.Unit.INSTANCE
                        return r12
                    L58:
                        java.lang.IllegalStateException r12 = new java.lang.IllegalStateException
                        java.lang.String r0 = "call to 'resume' before 'invoke' with coroutine"
                        r12.<init>(r0)
                        throw r12
                    */
                    throw new UnsupportedOperationException("Method not decompiled: androidx.compose.foundation.text.input.internal.TextFieldDecoratorModifierNode$pointerInputNode$1.AnonymousClass1.invokeSuspend(java.lang.Object):java.lang.Object");
                }

                /* JADX INFO: Access modifiers changed from: private */
                public static final Unit invokeSuspend$lambda$0$0(TextFieldSelectionState textFieldSelectionState, TextFieldDecoratorModifierNode textFieldDecoratorModifierNode) {
                    if (!textFieldSelectionState.getIsFocused()) {
                        textFieldDecoratorModifierNode.requestFocus();
                    }
                    return Unit.INSTANCE;
                }
            }

            @Override // androidx.compose.ui.input.pointer.PointerInputEventHandler
            public final Object invoke(PointerInputScope pointerInputScope, Continuation<? super Unit> continuation) {
                Object objCoroutineScope = CoroutineScopeKt.coroutineScope(new AnonymousClass1(this.this$0, pointerInputScope, null), continuation);
                return objCoroutineScope == IntrinsicsKt.getCOROUTINE_SUSPENDED() ? objCoroutineScope : Unit.INSTANCE;
            }
        }));
        this.dragAndDropNode = (DragAndDropTargetModifierNode) delegate(TextFieldDragAndDropNode_androidKt.textFieldDragAndDropNode$default(new Function0() { // from class: androidx.compose.foundation.text.input.internal.TextFieldDecoratorModifierNode$$ExternalSyntheticLambda8
            @Override // kotlin.jvm.functions.Function0
            public final Object invoke() {
                return TextFieldDecoratorModifierNode.dragAndDropNode$lambda$0(this.f$0);
            }
        }, new Function2() { // from class: androidx.compose.foundation.text.input.internal.TextFieldDecoratorModifierNode$$ExternalSyntheticLambda9
            @Override // kotlin.jvm.functions.Function2
            public final Object invoke(Object obj, Object obj2) {
                return Boolean.valueOf(TextFieldDecoratorModifierNode.dragAndDropNode$lambda$1(this.f$0, (ClipEntry) obj, (ClipMetadata) obj2));
            }
        }, new Function1() { // from class: androidx.compose.foundation.text.input.internal.TextFieldDecoratorModifierNode$$ExternalSyntheticLambda10
            @Override // kotlin.jvm.functions.Function1
            public final Object invoke(Object obj) {
                return TextFieldDecoratorModifierNode.dragAndDropNode$lambda$2(this.f$0, (DragAndDropEvent) obj);
            }
        }, null, new Function1() { // from class: androidx.compose.foundation.text.input.internal.TextFieldDecoratorModifierNode$$ExternalSyntheticLambda12
            @Override // kotlin.jvm.functions.Function1
            public final Object invoke(Object obj) {
                return TextFieldDecoratorModifierNode.dragAndDropNode$lambda$3(this.f$0, (DragAndDropEvent) obj);
            }
        }, new Function1() { // from class: androidx.compose.foundation.text.input.internal.TextFieldDecoratorModifierNode$$ExternalSyntheticLambda13
            @Override // kotlin.jvm.functions.Function1
            public final Object invoke(Object obj) {
                return TextFieldDecoratorModifierNode.dragAndDropNode$lambda$4(this.f$0, (Offset) obj);
            }
        }, null, new Function1() { // from class: androidx.compose.foundation.text.input.internal.TextFieldDecoratorModifierNode$$ExternalSyntheticLambda14
            @Override // kotlin.jvm.functions.Function1
            public final Object invoke(Object obj) {
                return TextFieldDecoratorModifierNode.dragAndDropNode$lambda$5(this.f$0, (DragAndDropEvent) obj);
            }
        }, new Function1() { // from class: androidx.compose.foundation.text.input.internal.TextFieldDecoratorModifierNode$$ExternalSyntheticLambda15
            @Override // kotlin.jvm.functions.Function1
            public final Object invoke(Object obj) {
                return TextFieldDecoratorModifierNode.dragAndDropNode$lambda$6(this.f$0, (DragAndDropEvent) obj);
            }
        }, 72, null));
        this.textFieldKeyEventHandler = TextFieldKeyEventHandler_androidKt.createTextFieldKeyEventHandler();
        this.keyboardActionScope = new TextFieldDecoratorModifierNode$keyboardActionScope$1(this);
        this.clipboardKeyCommandsHandler = ClipboardKeyCommandsHandler.m1964constructorimpl(new Function1() { // from class: androidx.compose.foundation.text.input.internal.TextFieldDecoratorModifierNode$$ExternalSyntheticLambda16
            @Override // kotlin.jvm.functions.Function1
            public final Object invoke(Object obj) {
                return TextFieldDecoratorModifierNode.clipboardKeyCommandsHandler$lambda$0(this.f$0, (KeyCommand) obj);
            }
        });
        this.receiveContentConfigurationProvider = new Function0() { // from class: androidx.compose.foundation.text.input.internal.TextFieldDecoratorModifierNode$$ExternalSyntheticLambda6
            @Override // kotlin.jvm.functions.Function0
            public final Object invoke() {
                return TextFieldDecoratorModifierNode.receiveContentConfigurationProvider$lambda$0(this.f$0);
            }
        };
        this.autofillHighlightOn = SnapshotStateKt__SnapshotStateKt.mutableStateOf$default(false, null, 2, null);
    }

    public final TransformedTextFieldState getTextFieldState() {
        return this.textFieldState;
    }

    public final void setTextFieldState(TransformedTextFieldState transformedTextFieldState) {
        this.textFieldState = transformedTextFieldState;
    }

    public final TextLayoutState getTextLayoutState() {
        return this.textLayoutState;
    }

    public final void setTextLayoutState(TextLayoutState textLayoutState) {
        this.textLayoutState = textLayoutState;
    }

    public final TextFieldSelectionState getTextFieldSelectionState() {
        return this.textFieldSelectionState;
    }

    public final void setTextFieldSelectionState(TextFieldSelectionState textFieldSelectionState) {
        this.textFieldSelectionState = textFieldSelectionState;
    }

    public final InputTransformation getFilter() {
        return this.filter;
    }

    public final void setFilter(InputTransformation inputTransformation) {
        this.filter = inputTransformation;
    }

    public final boolean getEnabled() {
        return this.enabled;
    }

    public final void setEnabled(boolean z) {
        this.enabled = z;
    }

    public final boolean getReadOnly() {
        return this.readOnly;
    }

    public final void setReadOnly(boolean z) {
        this.readOnly = z;
    }

    public final KeyboardOptions getKeyboardOptions() {
        return this.keyboardOptions;
    }

    public final void setKeyboardOptions(KeyboardOptions keyboardOptions) {
        this.keyboardOptions = keyboardOptions;
    }

    public final KeyboardActionHandler getKeyboardActionHandler() {
        return this.keyboardActionHandler;
    }

    public final void setKeyboardActionHandler(KeyboardActionHandler keyboardActionHandler) {
        this.keyboardActionHandler = keyboardActionHandler;
    }

    public final boolean getSingleLine() {
        return this.singleLine;
    }

    public final void setSingleLine(boolean z) {
        this.singleLine = z;
    }

    public final MutableInteractionSource getInteractionSource() {
        return this.interactionSource;
    }

    public final void setInteractionSource(MutableInteractionSource mutableInteractionSource) {
        this.interactionSource = mutableInteractionSource;
    }

    /* JADX INFO: renamed from: isPassword, reason: from getter */
    public final boolean getIsPassword() {
        return this.isPassword;
    }

    public final void setPassword(boolean z) {
        this.isPassword = z;
    }

    public final MutableSharedFlow<Unit> getStylusHandwritingTrigger() {
        return this.stylusHandwritingTrigger;
    }

    public final void setStylusHandwritingTrigger(MutableSharedFlow<Unit> mutableSharedFlow) {
        this.stylusHandwritingTrigger = mutableSharedFlow;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit _init_$lambda$0(TextFieldDecoratorModifierNode textFieldDecoratorModifierNode) {
        DelegatableNodeKt.requestAutofill(textFieldDecoratorModifierNode);
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit focusableNode$lambda$0(TextFieldDecoratorModifierNode textFieldDecoratorModifierNode, boolean z) {
        boolean z2 = textFieldDecoratorModifierNode.enabled && !textFieldDecoratorModifierNode.readOnly;
        if (z) {
            textFieldDecoratorModifierNode.applyCurrentInputMode();
            if (z2) {
                textFieldDecoratorModifierNode.startInputSession(false);
            }
        } else {
            textFieldDecoratorModifierNode.disposeInputSession();
            TransformedTextFieldState transformedTextFieldState = textFieldDecoratorModifierNode.textFieldState;
            TextFieldState textFieldState = transformedTextFieldState.textFieldState;
            InputTransformation inputTransformation = transformedTextFieldState.inputTransformation;
            TextFieldEditUndoBehavior textFieldEditUndoBehavior = TextFieldEditUndoBehavior.MergeIfPossible;
            textFieldState.getMainBuffer().getChangeTracker$foundation().clearChanges();
            TextFieldBuffer mainBuffer = textFieldState.getMainBuffer();
            mainBuffer.commitComposition$foundation();
            transformedTextFieldState.updateWedgeAffinity(mainBuffer);
            textFieldState.commitEditAsUser(inputTransformation, true, textFieldEditUndoBehavior);
            textFieldState.setUserCommit(true);
            textFieldDecoratorModifierNode.textFieldState.collapseSelectionToMax();
        }
        textFieldDecoratorModifierNode.updateWindowFocus();
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Set dragAndDropNode$lambda$0(TextFieldDecoratorModifierNode textFieldDecoratorModifierNode) {
        return ReceiveContentConfigurationKt.getReceiveContentConfiguration(textFieldDecoratorModifierNode) != null ? TextFieldDecoratorModifierKt.MediaTypesAll : TextFieldDecoratorModifierKt.MediaTypesText;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit dragAndDropNode$lambda$2(TextFieldDecoratorModifierNode textFieldDecoratorModifierNode, DragAndDropEvent dragAndDropEvent) {
        if (ReceiveContentConfigurationKt.getReceiveContentConfiguration(textFieldDecoratorModifierNode) != null) {
            DragAndDropRequestPermission_androidKt.dragAndDropRequestPermission(textFieldDecoratorModifierNode, dragAndDropEvent);
        }
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit dragAndDropNode$lambda$3(TextFieldDecoratorModifierNode textFieldDecoratorModifierNode, DragAndDropEvent dragAndDropEvent) {
        ReceiveContentListener receiveContentListener;
        DragAndDropHoverInteraction.Enter enter = new DragAndDropHoverInteraction.Enter();
        textFieldDecoratorModifierNode.interactionSource.tryEmit(enter);
        textFieldDecoratorModifierNode.dragEnterEvent = enter;
        ReceiveContentConfiguration receiveContentConfiguration = ReceiveContentConfigurationKt.getReceiveContentConfiguration(textFieldDecoratorModifierNode);
        if (receiveContentConfiguration != null && (receiveContentListener = receiveContentConfiguration.getReceiveContentListener()) != null) {
            receiveContentListener.onDragEnter();
        }
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit dragAndDropNode$lambda$4(TextFieldDecoratorModifierNode textFieldDecoratorModifierNode, Offset offset) {
        long jM2119fromWindowToDecorationUv8p0NA = TextLayoutStateKt.m2119fromWindowToDecorationUv8p0NA(textFieldDecoratorModifierNode.textLayoutState, offset.m5733unboximpl());
        int iM2109getOffsetForPosition3MmeM6k$default = TextLayoutState.m2109getOffsetForPosition3MmeM6k$default(textFieldDecoratorModifierNode.textLayoutState, jM2119fromWindowToDecorationUv8p0NA, false, 2, null);
        if (iM2109getOffsetForPosition3MmeM6k$default >= 0) {
            textFieldDecoratorModifierNode.textFieldState.m2132selectCharsIn5zctL8(TextRangeKt.TextRange(iM2109getOffsetForPosition3MmeM6k$default));
        }
        textFieldDecoratorModifierNode.textFieldSelectionState.m2181updateHandleDraggingUv8p0NA(Handle.Cursor, jM2119fromWindowToDecorationUv8p0NA);
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final boolean dragAndDropNode$lambda$1(TextFieldDecoratorModifierNode textFieldDecoratorModifierNode, ClipEntry clipEntry, ClipMetadata clipMetadata) {
        ClipEntry clipEntry2;
        textFieldDecoratorModifierNode.emitDragExitEvent();
        textFieldDecoratorModifierNode.textFieldSelectionState.clearHandleDragging();
        String plainText = TransferableContent_androidKt.readPlainText(clipEntry);
        ReceiveContentConfiguration receiveContentConfiguration = ReceiveContentConfigurationKt.getReceiveContentConfiguration(textFieldDecoratorModifierNode);
        if (receiveContentConfiguration != null) {
            TransferableContent transferableContentOnReceive = receiveContentConfiguration.getReceiveContentListener().onReceive(new TransferableContent(clipEntry, clipMetadata, TransferableContent.Source.INSTANCE.m440getDragAndDropkB6V9T0(), null, 8, null));
            plainText = (transferableContentOnReceive == null || (clipEntry2 = transferableContentOnReceive.getClipEntry()) == null) ? null : TransferableContent_androidKt.readPlainText(clipEntry2);
        }
        if (plainText == null) {
            return true;
        }
        TransformedTextFieldState.replaceSelectedText$default(textFieldDecoratorModifierNode.textFieldState, plainText, false, null, false, 14, null);
        return true;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit dragAndDropNode$lambda$5(TextFieldDecoratorModifierNode textFieldDecoratorModifierNode, DragAndDropEvent dragAndDropEvent) {
        ReceiveContentListener receiveContentListener;
        textFieldDecoratorModifierNode.emitDragExitEvent();
        textFieldDecoratorModifierNode.textFieldSelectionState.clearHandleDragging();
        ReceiveContentConfiguration receiveContentConfiguration = ReceiveContentConfigurationKt.getReceiveContentConfiguration(textFieldDecoratorModifierNode);
        if (receiveContentConfiguration != null && (receiveContentListener = receiveContentConfiguration.getReceiveContentListener()) != null) {
            receiveContentListener.onDragExit();
        }
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit dragAndDropNode$lambda$6(TextFieldDecoratorModifierNode textFieldDecoratorModifierNode, DragAndDropEvent dragAndDropEvent) {
        textFieldDecoratorModifierNode.emitDragExitEvent();
        return Unit.INSTANCE;
    }

    private final boolean isFocused() {
        WindowInfo windowInfo;
        return this.focusableNode.getFocusState().isFocused() && (windowInfo = this.windowInfo) != null && windowInfo.isWindowFocused();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit clipboardKeyCommandsHandler$lambda$0(TextFieldDecoratorModifierNode textFieldDecoratorModifierNode, KeyCommand keyCommand) {
        BuildersKt__Builders_commonKt.launch$default(textFieldDecoratorModifierNode.getCoroutineScope(), null, CoroutineStart.UNDISPATCHED, new TextFieldDecoratorModifierNode$clipboardKeyCommandsHandler$1$1(keyCommand, textFieldDecoratorModifierNode, null), 1, null);
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final ReceiveContentConfiguration receiveContentConfigurationProvider$lambda$0(TextFieldDecoratorModifierNode textFieldDecoratorModifierNode) {
        return ReceiveContentConfigurationKt.getReceiveContentConfiguration(textFieldDecoratorModifierNode);
    }

    /* JADX WARN: Multi-variable type inference failed */
    private final boolean getAutofillHighlightOn() {
        return ((Boolean) this.autofillHighlightOn.getValue()).booleanValue();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void setAutofillHighlightOn(boolean z) {
        this.autofillHighlightOn.setValue(Boolean.valueOf(z));
    }

    @Override // androidx.compose.ui.node.DrawModifierNode
    public void draw(ContentDrawScope contentDrawScope) {
        contentDrawScope.drawContent();
        if (getAutofillHighlightOn()) {
            ContentDrawScope contentDrawScope2 = contentDrawScope;
            TextFieldDecoratorModifierNode textFieldDecoratorModifierNode = this;
            DrawScope.m6542drawRectAsUm42w$default(contentDrawScope2, AutofillHighlightKt.m1638resolveAutofillHighlightWkMShQ((Brush) CompositionLocalConsumerModifierNodeKt.currentValueOf(textFieldDecoratorModifierNode, AutofillHighlightKt.getLocalAutofillHighlightBrush()), ((Color) CompositionLocalConsumerModifierNodeKt.currentValueOf(textFieldDecoratorModifierNode, AutofillHighlightKt.getLocalAutofillHighlightColor())).m5978unboximpl(), AutofillHighlight_androidKt.autofillHighlightColor()), 0L, 0L, 0.0f, null, null, 0, 126, null);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final Object observeUntransformedTextChanges(Continuation<? super Unit> continuation) {
        Object objCollect = FlowKt.take(FlowKt.drop(SnapshotStateKt.snapshotFlow(new Function0() { // from class: androidx.compose.foundation.text.input.internal.TextFieldDecoratorModifierNode$$ExternalSyntheticLambda0
            @Override // kotlin.jvm.functions.Function0
            public final Object invoke() {
                return TextFieldDecoratorModifierNode.observeUntransformedTextChanges$lambda$0(this.f$0);
            }
        }), 1), 1).collect(new FlowCollector() { // from class: androidx.compose.foundation.text.input.internal.TextFieldDecoratorModifierNode.observeUntransformedTextChanges.3
            @Override // kotlinx.coroutines.flow.FlowCollector
            public /* bridge */ /* synthetic */ Object emit(Object obj, Continuation continuation2) {
                return emit((String) obj, (Continuation<? super Unit>) continuation2);
            }

            public final Object emit(String str, Continuation<? super Unit> continuation2) {
                TextFieldDecoratorModifierNode.this.setAutofillHighlightOn(false);
                return Unit.INSTANCE;
            }
        }, continuation);
        return objCollect == IntrinsicsKt.getCOROUTINE_SUSPENDED() ? objCollect : Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final String observeUntransformedTextChanges$lambda$0(TextFieldDecoratorModifierNode textFieldDecoratorModifierNode) {
        return textFieldDecoratorModifierNode.textFieldState.getUntransformedText().toString();
    }

    public final void updateNode(TransformedTextFieldState textFieldState, TextLayoutState textLayoutState, TextFieldSelectionState textFieldSelectionState, InputTransformation filter, boolean enabled, boolean readOnly, KeyboardOptions keyboardOptions, KeyboardActionHandler keyboardActionHandler, boolean singleLine, MutableInteractionSource interactionSource, boolean isPassword, MutableSharedFlow<Unit> stylusHandwritingTrigger) {
        TextFieldSelectionState textFieldSelectionState2;
        boolean z;
        Job job;
        boolean z2 = this.enabled;
        boolean z3 = z2 && !this.readOnly;
        TransformedTextFieldState transformedTextFieldState = this.textFieldState;
        KeyboardOptions keyboardOptions2 = this.keyboardOptions;
        TextFieldSelectionState textFieldSelectionState3 = this.textFieldSelectionState;
        MutableInteractionSource mutableInteractionSource = this.interactionSource;
        boolean z4 = this.isPassword;
        MutableSharedFlow<Unit> mutableSharedFlow = this.stylusHandwritingTrigger;
        if (!enabled || readOnly) {
            textFieldSelectionState2 = textFieldSelectionState3;
            z = false;
        } else {
            textFieldSelectionState2 = textFieldSelectionState3;
            z = true;
        }
        this.textFieldState = textFieldState;
        this.textLayoutState = textLayoutState;
        this.textFieldSelectionState = textFieldSelectionState;
        this.filter = filter;
        this.enabled = enabled;
        this.readOnly = readOnly;
        this.keyboardOptions = keyboardOptions;
        this.keyboardActionHandler = keyboardActionHandler;
        this.singleLine = singleLine;
        this.interactionSource = interactionSource;
        this.isPassword = isPassword;
        this.stylusHandwritingTrigger = stylusHandwritingTrigger;
        if (z != z3 || !Intrinsics.areEqual(textFieldState, transformedTextFieldState) || !Intrinsics.areEqual(keyboardOptions, keyboardOptions2) || !Intrinsics.areEqual(stylusHandwritingTrigger, mutableSharedFlow)) {
            if (z && (isFocused() || this.inputSessionJob != null)) {
                startInputSession(false);
            } else if (!z) {
                disposeInputSession();
            }
        }
        if (enabled != z2 || z != z3 || !ImeAction.m8445equalsimpl0(keyboardOptions.m1778getImeActionOrDefaulteUduSuo$foundation(), keyboardOptions2.m1778getImeActionOrDefaulteUduSuo$foundation()) || isPassword != z4) {
            SemanticsModifierNodeKt.invalidateSemantics(this);
        }
        if (!Intrinsics.areEqual(textFieldSelectionState, textFieldSelectionState2)) {
            this.pointerInputNode.resetPointerInputHandler();
            if (getIsAttached()) {
                textFieldSelectionState.setReceiveContentConfiguration(this.receiveContentConfigurationProvider);
                if (isFocused() && (job = this.toolbarAndHandlesVisibilityObserverJob) != null) {
                    if (job != null) {
                        Job.DefaultImpls.cancel$default(job, (CancellationException) null, 1, (Object) null);
                    }
                    this.toolbarAndHandlesVisibilityObserverJob = BuildersKt__Builders_commonKt.launch$default(getCoroutineScope(), null, null, new C03641(textFieldSelectionState, null), 3, null);
                }
            }
            textFieldSelectionState.setRequestAutofillAction(new Function0() { // from class: androidx.compose.foundation.text.input.internal.TextFieldDecoratorModifierNode$$ExternalSyntheticLambda4
                @Override // kotlin.jvm.functions.Function0
                public final Object invoke() {
                    return TextFieldDecoratorModifierNode.updateNode$lambda$0(this.f$0);
                }
            });
        }
        if (!Intrinsics.areEqual(interactionSource, mutableInteractionSource)) {
            this.pointerInputNode.resetPointerInputHandler();
            if (this.focusableNode.getIsAttached()) {
                this.focusableNode.update(interactionSource);
            }
        }
        if (enabled != z2) {
            if (enabled) {
                delegate(this.focusableNode);
                this.focusableNode.update(interactionSource);
            } else {
                undelegate(this.focusableNode);
            }
        }
    }

    /* JADX INFO: renamed from: androidx.compose.foundation.text.input.internal.TextFieldDecoratorModifierNode$updateNode$1, reason: invalid class name and case insensitive filesystem */
    /* JADX INFO: compiled from: TextFieldDecoratorModifier.kt */
    @Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\n"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {2, 1, 0}, xi = 48)
    @DebugMetadata(c = "androidx.compose.foundation.text.input.internal.TextFieldDecoratorModifierNode$updateNode$1", f = "TextFieldDecoratorModifier.kt", i = {}, l = {514}, m = "invokeSuspend", n = {}, s = {}, v = 1)
    static final class C03641 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
        final /* synthetic */ TextFieldSelectionState $textFieldSelectionState;
        int label;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        C03641(TextFieldSelectionState textFieldSelectionState, Continuation<? super C03641> continuation) {
            super(2, continuation);
            this.$textFieldSelectionState = textFieldSelectionState;
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
            return new C03641(this.$textFieldSelectionState, continuation);
        }

        @Override // kotlin.jvm.functions.Function2
        public final Object invoke(CoroutineScope coroutineScope, Continuation<? super Unit> continuation) {
            return ((C03641) create(coroutineScope, continuation)).invokeSuspend(Unit.INSTANCE);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object obj) {
            Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
            int i = this.label;
            if (i == 0) {
                ResultKt.throwOnFailure(obj);
                this.label = 1;
                if (this.$textFieldSelectionState.startToolbarAndHandlesVisibilityObserver(this) == coroutine_suspended) {
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

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit updateNode$lambda$0(TextFieldDecoratorModifierNode textFieldDecoratorModifierNode) {
        DelegatableNodeKt.requestAutofill(textFieldDecoratorModifierNode);
        return Unit.INSTANCE;
    }

    @Override // androidx.compose.ui.node.SemanticsModifierNode
    public void applySemantics(SemanticsPropertyReceiver semanticsPropertyReceiver) {
        TextFieldCharSequence outputText = this.textFieldState.getOutputText();
        long selection = outputText.getSelection();
        SemanticsPropertiesKt.setInputText(semanticsPropertyReceiver, new AnnotatedString(this.textFieldState.getUntransformedText().toString(), null, 2, null));
        SemanticsPropertiesKt.setEditableText(semanticsPropertyReceiver, new AnnotatedString(outputText.toString(), null, 2, null));
        SemanticsPropertiesKt.m8034setTextSelectionRangeFDrldGo(semanticsPropertyReceiver, selection);
        SemanticsPropertiesKt.m8033setTextCompositionRangepsREZIo(semanticsPropertyReceiver, this.textFieldState.m2125getUntransformedCompositionMzsxiRA());
        SemanticsPropertiesKt.setInputTextSuggestionState(semanticsPropertyReceiver, new InputTextSuggestionState(this.textFieldState.getUserCommit()));
        if (!this.enabled) {
            SemanticsPropertiesKt.disabled(semanticsPropertyReceiver);
        }
        if (this.isPassword) {
            SemanticsPropertiesKt.password(semanticsPropertyReceiver);
        }
        final boolean z = this.enabled && !this.readOnly;
        SemanticsPropertiesKt.setEditable(semanticsPropertyReceiver, z);
        SemanticsPropertiesKt.setContentDataType(semanticsPropertyReceiver, ContentDataType.INSTANCE.getText());
        FillableData fillableDataCreateFromText = FillableData_androidKt.createFromText(FillableData.INSTANCE, outputText);
        if (fillableDataCreateFromText != null) {
            SemanticsPropertiesKt.setFillableData(semanticsPropertyReceiver, fillableDataCreateFromText);
        }
        SemanticsPropertiesKt.onFillData$default(semanticsPropertyReceiver, null, new Function1() { // from class: androidx.compose.foundation.text.input.internal.TextFieldDecoratorModifierNode$$ExternalSyntheticLambda11
            @Override // kotlin.jvm.functions.Function1
            public final Object invoke(Object obj) {
                return Boolean.valueOf(TextFieldDecoratorModifierNode.applySemantics$lambda$1(z, this, (FillableData) obj));
            }
        }, 1, null);
        int keyboardType = this.keyboardOptions.getKeyboardType();
        if (KeyboardType.m8498equalsimpl0(keyboardType, KeyboardType.INSTANCE.m8514getEmailPjHm6EE())) {
            SemanticsPropertiesKt.setContentType(semanticsPropertyReceiver, ContentType.INSTANCE.getEmailAddress());
        } else if (KeyboardType.m8498equalsimpl0(keyboardType, KeyboardType.INSTANCE.m8517getPasswordPjHm6EE()) || KeyboardType.m8498equalsimpl0(keyboardType, KeyboardType.INSTANCE.m8516getNumberPasswordPjHm6EE())) {
            SemanticsPropertiesKt.setContentType(semanticsPropertyReceiver, ContentType.INSTANCE.getPassword());
        } else if (KeyboardType.m8498equalsimpl0(keyboardType, KeyboardType.INSTANCE.m8518getPhonePjHm6EE())) {
            SemanticsPropertiesKt.setContentType(semanticsPropertyReceiver, ContentType.INSTANCE.getPhoneNumber());
        }
        SemanticsPropertiesKt.getTextLayoutResult$default(semanticsPropertyReceiver, null, new Function1() { // from class: androidx.compose.foundation.text.input.internal.TextFieldDecoratorModifierNode$$ExternalSyntheticLambda20
            @Override // kotlin.jvm.functions.Function1
            public final Object invoke(Object obj) {
                return Boolean.valueOf(TextFieldDecoratorModifierNode.applySemantics$lambda$2(this.f$0, (List) obj));
            }
        }, 1, null);
        if (z) {
            SemanticsPropertiesKt.setText$default(semanticsPropertyReceiver, null, new Function1() { // from class: androidx.compose.foundation.text.input.internal.TextFieldDecoratorModifierNode$$ExternalSyntheticLambda21
                @Override // kotlin.jvm.functions.Function1
                public final Object invoke(Object obj) {
                    return Boolean.valueOf(TextFieldDecoratorModifierNode.applySemantics$lambda$3(z, this, (AnnotatedString) obj));
                }
            }, 1, null);
            SemanticsPropertiesKt.insertTextAtCursor$default(semanticsPropertyReceiver, null, new Function1() { // from class: androidx.compose.foundation.text.input.internal.TextFieldDecoratorModifierNode$$ExternalSyntheticLambda22
                @Override // kotlin.jvm.functions.Function1
                public final Object invoke(Object obj) {
                    return Boolean.valueOf(TextFieldDecoratorModifierNode.applySemantics$lambda$4(z, this, (AnnotatedString) obj));
                }
            }, 1, null);
        }
        SemanticsPropertiesKt.setSelection$default(semanticsPropertyReceiver, null, new Function3() { // from class: androidx.compose.foundation.text.input.internal.TextFieldDecoratorModifierNode$$ExternalSyntheticLambda23
            @Override // kotlin.jvm.functions.Function3
            public final Object invoke(Object obj, Object obj2, Object obj3) {
                return Boolean.valueOf(TextFieldDecoratorModifierNode.applySemantics$lambda$5(this.f$0, ((Integer) obj).intValue(), ((Integer) obj2).intValue(), ((Boolean) obj3).booleanValue()));
            }
        }, 1, null);
        final int iM1778getImeActionOrDefaulteUduSuo$foundation = this.keyboardOptions.m1778getImeActionOrDefaulteUduSuo$foundation();
        SemanticsPropertiesKt.m8029onImeAction9UiTYpY$default(semanticsPropertyReceiver, iM1778getImeActionOrDefaulteUduSuo$foundation, null, new Function0() { // from class: androidx.compose.foundation.text.input.internal.TextFieldDecoratorModifierNode$$ExternalSyntheticLambda24
            @Override // kotlin.jvm.functions.Function0
            public final Object invoke() {
                return Boolean.valueOf(TextFieldDecoratorModifierNode.applySemantics$lambda$6(this.f$0, iM1778getImeActionOrDefaulteUduSuo$foundation));
            }
        }, 2, null);
        SemanticsPropertiesKt.onClick$default(semanticsPropertyReceiver, null, new Function0() { // from class: androidx.compose.foundation.text.input.internal.TextFieldDecoratorModifierNode$$ExternalSyntheticLambda25
            @Override // kotlin.jvm.functions.Function0
            public final Object invoke() {
                return Boolean.valueOf(TextFieldDecoratorModifierNode.applySemantics$lambda$7(this.f$0));
            }
        }, 1, null);
        SemanticsPropertiesKt.onLongClick$default(semanticsPropertyReceiver, null, new Function0() { // from class: androidx.compose.foundation.text.input.internal.TextFieldDecoratorModifierNode$$ExternalSyntheticLambda26
            @Override // kotlin.jvm.functions.Function0
            public final Object invoke() {
                return Boolean.valueOf(TextFieldDecoratorModifierNode.applySemantics$lambda$8(this.f$0));
            }
        }, 1, null);
        if (!TextRange.m8267getCollapsedimpl(selection) && !this.isPassword) {
            SemanticsPropertiesKt.copyText$default(semanticsPropertyReceiver, null, new Function0() { // from class: androidx.compose.foundation.text.input.internal.TextFieldDecoratorModifierNode$$ExternalSyntheticLambda1
                @Override // kotlin.jvm.functions.Function0
                public final Object invoke() {
                    return Boolean.valueOf(TextFieldDecoratorModifierNode.applySemantics$lambda$9(this.f$0));
                }
            }, 1, null);
            if (this.enabled && !this.readOnly) {
                SemanticsPropertiesKt.cutText$default(semanticsPropertyReceiver, null, new Function0() { // from class: androidx.compose.foundation.text.input.internal.TextFieldDecoratorModifierNode$$ExternalSyntheticLambda2
                    @Override // kotlin.jvm.functions.Function0
                    public final Object invoke() {
                        return Boolean.valueOf(TextFieldDecoratorModifierNode.applySemantics$lambda$10(this.f$0));
                    }
                }, 1, null);
            }
        }
        if (z) {
            SemanticsPropertiesKt.pasteText$default(semanticsPropertyReceiver, null, new Function0() { // from class: androidx.compose.foundation.text.input.internal.TextFieldDecoratorModifierNode$$ExternalSyntheticLambda19
                @Override // kotlin.jvm.functions.Function0
                public final Object invoke() {
                    return Boolean.valueOf(TextFieldDecoratorModifierNode.applySemantics$lambda$11(this.f$0));
                }
            }, 1, null);
        }
        InputTransformation inputTransformation = this.filter;
        if (inputTransformation != null) {
            inputTransformation.applySemantics(semanticsPropertyReceiver);
        }
        if (this.enabled) {
            this.focusableNode.applySemantics(semanticsPropertyReceiver);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final boolean applySemantics$lambda$1(boolean z, TextFieldDecoratorModifierNode textFieldDecoratorModifierNode, FillableData fillableData) {
        if (!z) {
            return false;
        }
        CharSequence textValue = fillableData.getTextValue();
        if (textValue != null) {
            textFieldDecoratorModifierNode.textFieldState.replaceAll(textValue);
        }
        textFieldDecoratorModifierNode.setAutofillHighlightOn(true);
        BuildersKt__Builders_commonKt.launch$default(textFieldDecoratorModifierNode.getCoroutineScope(), null, null, new TextFieldDecoratorModifierNode$applySemantics$2$2(textFieldDecoratorModifierNode, null), 3, null);
        return true;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final boolean applySemantics$lambda$2(TextFieldDecoratorModifierNode textFieldDecoratorModifierNode, List list) {
        TextLayoutResult layoutResult = textFieldDecoratorModifierNode.textLayoutState.getLayoutResult();
        if (layoutResult != null) {
            return list.add(layoutResult);
        }
        return false;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final boolean applySemantics$lambda$3(boolean z, TextFieldDecoratorModifierNode textFieldDecoratorModifierNode, AnnotatedString annotatedString) {
        if (!z) {
            return false;
        }
        textFieldDecoratorModifierNode.textFieldState.replaceAll(annotatedString);
        return true;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final boolean applySemantics$lambda$4(boolean z, TextFieldDecoratorModifierNode textFieldDecoratorModifierNode, AnnotatedString annotatedString) {
        if (!z) {
            return false;
        }
        TransformedTextFieldState.replaceSelectedText$default(textFieldDecoratorModifierNode.textFieldState, annotatedString, true, null, false, 12, null);
        return true;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final boolean applySemantics$lambda$5(TextFieldDecoratorModifierNode textFieldDecoratorModifierNode, int i, int i2, boolean z) {
        TextFieldCharSequence visualText;
        if (z) {
            visualText = textFieldDecoratorModifierNode.textFieldState.getUntransformedText();
        } else {
            visualText = textFieldDecoratorModifierNode.textFieldState.getVisualText();
        }
        long selection = visualText.getSelection();
        if (!textFieldDecoratorModifierNode.enabled || Math.min(i, i2) < 0 || Math.max(i, i2) > visualText.length()) {
            return false;
        }
        if (i == TextRange.m8273getStartimpl(selection) && i2 == TextRange.m8268getEndimpl(selection)) {
            return true;
        }
        long jTextRange = TextRangeKt.TextRange(i, i2);
        if (z || i == i2) {
            textFieldDecoratorModifierNode.textFieldSelectionState.updateTextToolbarState(TextToolbarState.None);
        } else {
            textFieldDecoratorModifierNode.textFieldSelectionState.updateTextToolbarState(TextToolbarState.Selection);
        }
        if (z) {
            textFieldDecoratorModifierNode.textFieldState.m2133selectUntransformedCharsIn5zctL8(jTextRange);
        } else {
            textFieldDecoratorModifierNode.textFieldState.m2132selectCharsIn5zctL8(jTextRange);
        }
        return true;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final boolean applySemantics$lambda$6(TextFieldDecoratorModifierNode textFieldDecoratorModifierNode, int i) {
        textFieldDecoratorModifierNode.m2091onImeActionPerformedKlQnJC8(i);
        return true;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final boolean applySemantics$lambda$7(TextFieldDecoratorModifierNode textFieldDecoratorModifierNode) {
        if (!textFieldDecoratorModifierNode.isFocused()) {
            textFieldDecoratorModifierNode.requestFocus();
            return true;
        }
        if (textFieldDecoratorModifierNode.readOnly) {
            return true;
        }
        textFieldDecoratorModifierNode.requireKeyboardController().show();
        return true;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final boolean applySemantics$lambda$8(TextFieldDecoratorModifierNode textFieldDecoratorModifierNode) {
        if (!textFieldDecoratorModifierNode.isFocused()) {
            textFieldDecoratorModifierNode.requestFocus();
        }
        textFieldDecoratorModifierNode.textFieldSelectionState.updateTextToolbarState(TextToolbarState.Selection);
        return true;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final boolean applySemantics$lambda$9(TextFieldDecoratorModifierNode textFieldDecoratorModifierNode) {
        BuildersKt__Builders_commonKt.launch$default(textFieldDecoratorModifierNode.getCoroutineScope(), null, null, new TextFieldDecoratorModifierNode$applySemantics$10$1(textFieldDecoratorModifierNode, null), 3, null);
        return true;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final boolean applySemantics$lambda$10(TextFieldDecoratorModifierNode textFieldDecoratorModifierNode) {
        BuildersKt__Builders_commonKt.launch$default(textFieldDecoratorModifierNode.getCoroutineScope(), null, null, new TextFieldDecoratorModifierNode$applySemantics$11$1(textFieldDecoratorModifierNode, null), 3, null);
        return true;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final boolean applySemantics$lambda$11(TextFieldDecoratorModifierNode textFieldDecoratorModifierNode) {
        BuildersKt__Builders_commonKt.launch$default(textFieldDecoratorModifierNode.getCoroutineScope(), null, null, new TextFieldDecoratorModifierNode$applySemantics$12$1(textFieldDecoratorModifierNode, null), 3, null);
        return true;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void requestFocus() {
        if (this.focusableNode.getIsAttached()) {
            this.focusableNode.requestFocus();
        }
    }

    private final void onIsFocusedUpdated() {
        this.textFieldSelectionState.setFocused(isFocused());
        if (isFocused() && this.toolbarAndHandlesVisibilityObserverJob == null) {
            this.toolbarAndHandlesVisibilityObserverJob = BuildersKt__Builders_commonKt.launch$default(getCoroutineScope(), null, null, new AnonymousClass1(null), 3, null);
        } else {
            if (isFocused()) {
                return;
            }
            Job job = this.toolbarAndHandlesVisibilityObserverJob;
            if (job != null) {
                Job.DefaultImpls.cancel$default(job, (CancellationException) null, 1, (Object) null);
            }
            this.toolbarAndHandlesVisibilityObserverJob = null;
        }
    }

    /* JADX INFO: renamed from: androidx.compose.foundation.text.input.internal.TextFieldDecoratorModifierNode$onIsFocusedUpdated$1, reason: invalid class name */
    /* JADX INFO: compiled from: TextFieldDecoratorModifier.kt */
    @Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\n"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {2, 1, 0}, xi = 48)
    @DebugMetadata(c = "androidx.compose.foundation.text.input.internal.TextFieldDecoratorModifierNode$onIsFocusedUpdated$1", f = "TextFieldDecoratorModifier.kt", i = {}, l = {708}, m = "invokeSuspend", n = {}, s = {}, v = 1)
    static final class AnonymousClass1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
        int label;

        AnonymousClass1(Continuation<? super AnonymousClass1> continuation) {
            super(2, continuation);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
            return TextFieldDecoratorModifierNode.this.new AnonymousClass1(continuation);
        }

        @Override // kotlin.jvm.functions.Function2
        public final Object invoke(CoroutineScope coroutineScope, Continuation<? super Unit> continuation) {
            return ((AnonymousClass1) create(coroutineScope, continuation)).invokeSuspend(Unit.INSTANCE);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object obj) {
            Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
            int i = this.label;
            if (i == 0) {
                ResultKt.throwOnFailure(obj);
                this.label = 1;
                if (TextFieldDecoratorModifierNode.this.getTextFieldSelectionState().startToolbarAndHandlesVisibilityObserver(this) == coroutine_suspended) {
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

    @Override // androidx.compose.ui.focus.FocusPropertiesModifierNode
    public void applyFocusProperties(FocusProperties focusProperties) {
        focusProperties.setFocusRect(this.textFieldSelectionState.getFocusRect());
    }

    @Override // androidx.compose.ui.Modifier.Node
    public void onAttach() {
        onObservedReadsChanged();
        this.textFieldSelectionState.setReceiveContentConfiguration(this.receiveContentConfigurationProvider);
        if (this.enabled) {
            delegate(this.focusableNode);
        }
    }

    @Override // androidx.compose.ui.Modifier.Node
    public void onDetach() {
        disposeInputSession();
        this.textFieldSelectionState.setReceiveContentConfiguration(null);
    }

    @Override // androidx.compose.ui.node.GlobalPositionAwareModifierNode
    public void onGloballyPositioned(LayoutCoordinates coordinates) {
        this.textLayoutState.setDecoratorNodeCoordinates(coordinates);
        if (this.enabled) {
            this.focusableNode.onGloballyPositioned(coordinates);
        }
    }

    @Override // androidx.compose.ui.node.PointerInputModifierNode
    /* JADX INFO: renamed from: onPointerEvent-H0pRuoY */
    public void mo280onPointerEventH0pRuoY(PointerEvent pointerEvent, PointerEventPass pass, long bounds) {
        this.pointerInputNode.mo280onPointerEventH0pRuoY(pointerEvent, pass, bounds);
    }

    @Override // androidx.compose.ui.node.PointerInputModifierNode
    public void onCancelPointerInput() {
        this.pointerInputNode.onCancelPointerInput();
    }

    @Override // androidx.compose.ui.input.key.KeyInputModifierNode
    /* JADX INFO: renamed from: onPreKeyEvent-ZmokQxo */
    public boolean mo281onPreKeyEventZmokQxo(KeyEvent event) {
        return this.textFieldKeyEventHandler.m2099onPreKeyEventMyFupTE(event, this.textFieldState, this.textFieldSelectionState, (FocusManager) CompositionLocalConsumerModifierNodeKt.currentValueOf(this, CompositionLocalsKt.getLocalFocusManager()), requireKeyboardController());
    }

    @Override // androidx.compose.ui.input.key.KeyInputModifierNode
    /* JADX INFO: renamed from: onKeyEvent-ZmokQxo */
    public boolean mo279onKeyEventZmokQxo(KeyEvent event) {
        return this.textFieldKeyEventHandler.mo1956onKeyEvent8zsqlwg(event, this.textFieldState, this.textLayoutState, this.textFieldSelectionState, this.clipboardKeyCommandsHandler, requireKeyboardController(), this.enabled && !this.readOnly, this.singleLine, new Function0() { // from class: androidx.compose.foundation.text.input.internal.TextFieldDecoratorModifierNode$$ExternalSyntheticLambda17
            @Override // kotlin.jvm.functions.Function0
            public final Object invoke() {
                return Boolean.valueOf(TextFieldDecoratorModifierNode.onKeyEvent_ZmokQxo$lambda$0(this.f$0));
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final boolean onKeyEvent_ZmokQxo$lambda$0(TextFieldDecoratorModifierNode textFieldDecoratorModifierNode) {
        return textFieldDecoratorModifierNode.m2091onImeActionPerformedKlQnJC8(textFieldDecoratorModifierNode.keyboardOptions.m1778getImeActionOrDefaulteUduSuo$foundation());
    }

    @Override // androidx.compose.ui.node.ObserverModifierNode
    public void onObservedReadsChanged() {
        updateWindowFocus();
    }

    private final void updateWindowFocus() {
        ObserverModifierNodeKt.observeReads(this, new Function0() { // from class: androidx.compose.foundation.text.input.internal.TextFieldDecoratorModifierNode$$ExternalSyntheticLambda3
            @Override // kotlin.jvm.functions.Function0
            public final Object invoke() {
                return TextFieldDecoratorModifierNode.updateWindowFocus$lambda$0(this.f$0);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit updateWindowFocus$lambda$0(TextFieldDecoratorModifierNode textFieldDecoratorModifierNode) {
        textFieldDecoratorModifierNode.windowInfo = (WindowInfo) CompositionLocalConsumerModifierNodeKt.currentValueOf(textFieldDecoratorModifierNode, CompositionLocalsKt.getLocalWindowInfo());
        textFieldDecoratorModifierNode.onIsFocusedUpdated();
        return Unit.INSTANCE;
    }

    @Override // androidx.compose.ui.node.LayoutAwareModifierNode
    public void onPlaced(LayoutCoordinates coordinates) {
        this.dragAndDropNode.onPlaced(coordinates);
    }

    @Override // androidx.compose.ui.node.LayoutAwareModifierNode, androidx.compose.ui.node.MeasuredSizeAwareModifierNode
    /* JADX INFO: renamed from: onRemeasured-ozmzZPI */
    public void mo477onRemeasuredozmzZPI(long size) {
        this.dragAndDropNode.mo477onRemeasuredozmzZPI(size);
    }

    private final void applyCurrentInputMode() {
        if (InputMode.m6781equalsimpl0(((InputModeManager) CompositionLocalConsumerModifierNodeKt.currentValueOf(this, CompositionLocalsKt.getLocalInputModeManager())).mo6788getInputModeaOaMEAU(), InputMode.INSTANCE.m6786getTouchaOaMEAU())) {
            return;
        }
        this.textFieldSelectionState.setInTouchMode(false);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void startInputSession(boolean fromTap) {
        if (fromTap || this.keyboardOptions.getShowKeyboardOnFocusOrDefault$foundation()) {
            this.inputSessionJob = BuildersKt__Builders_commonKt.launch$default(getCoroutineScope(), null, null, new C03631(ReceiveContentConfigurationKt.getReceiveContentConfiguration(this), null), 3, null);
        }
    }

    /* JADX INFO: renamed from: androidx.compose.foundation.text.input.internal.TextFieldDecoratorModifierNode$startInputSession$1, reason: invalid class name and case insensitive filesystem */
    /* JADX INFO: compiled from: TextFieldDecoratorModifier.kt */
    @Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\n"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {2, 1, 0}, xi = 48)
    @DebugMetadata(c = "androidx.compose.foundation.text.input.internal.TextFieldDecoratorModifierNode$startInputSession$1", f = "TextFieldDecoratorModifier.kt", i = {}, l = {817}, m = "invokeSuspend", n = {}, s = {}, v = 1)
    static final class C03631 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
        final /* synthetic */ ReceiveContentConfiguration $receiveContentConfiguration;
        int label;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        C03631(ReceiveContentConfiguration receiveContentConfiguration, Continuation<? super C03631> continuation) {
            super(2, continuation);
            this.$receiveContentConfiguration = receiveContentConfiguration;
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
            return TextFieldDecoratorModifierNode.this.new C03631(this.$receiveContentConfiguration, continuation);
        }

        @Override // kotlin.jvm.functions.Function2
        public final Object invoke(CoroutineScope coroutineScope, Continuation<? super Unit> continuation) {
            return ((C03631) create(coroutineScope, continuation)).invokeSuspend(Unit.INSTANCE);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object obj) {
            Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
            int i = this.label;
            if (i == 0) {
                ResultKt.throwOnFailure(obj);
                this.label = 1;
                if (PlatformTextInputModifierNodeKt.establishTextInputSession(TextFieldDecoratorModifierNode.this, new C00341(TextFieldDecoratorModifierNode.this, this.$receiveContentConfiguration, null), this) == coroutine_suspended) {
                    return coroutine_suspended;
                }
            } else {
                if (i != 1) {
                    throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                }
                ResultKt.throwOnFailure(obj);
            }
            throw new KotlinNothingValueException();
        }

        /* JADX INFO: renamed from: androidx.compose.foundation.text.input.internal.TextFieldDecoratorModifierNode$startInputSession$1$1, reason: invalid class name and collision with other inner class name */
        /* JADX INFO: compiled from: TextFieldDecoratorModifier.kt */
        @Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0001\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\n"}, d2 = {"<anonymous>", "", "Landroidx/compose/ui/platform/PlatformTextInputSessionScope;"}, k = 3, mv = {2, 1, 0}, xi = 48)
        @DebugMetadata(c = "androidx.compose.foundation.text.input.internal.TextFieldDecoratorModifierNode$startInputSession$1$1", f = "TextFieldDecoratorModifier.kt", i = {}, l = {818}, m = "invokeSuspend", n = {}, s = {}, v = 1)
        static final class C00341 extends SuspendLambda implements Function2<PlatformTextInputSessionScope, Continuation<?>, Object> {
            final /* synthetic */ ReceiveContentConfiguration $receiveContentConfiguration;
            private /* synthetic */ Object L$0;
            int label;
            final /* synthetic */ TextFieldDecoratorModifierNode this$0;

            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            C00341(TextFieldDecoratorModifierNode textFieldDecoratorModifierNode, ReceiveContentConfiguration receiveContentConfiguration, Continuation<? super C00341> continuation) {
                super(2, continuation);
                this.this$0 = textFieldDecoratorModifierNode;
                this.$receiveContentConfiguration = receiveContentConfiguration;
            }

            @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
            public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
                C00341 c00341 = new C00341(this.this$0, this.$receiveContentConfiguration, continuation);
                c00341.L$0 = obj;
                return c00341;
            }

            @Override // kotlin.jvm.functions.Function2
            public final Object invoke(PlatformTextInputSessionScope platformTextInputSessionScope, Continuation<?> continuation) {
                return ((C00341) create(platformTextInputSessionScope, continuation)).invokeSuspend(Unit.INSTANCE);
            }

            @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
            public final Object invokeSuspend(Object obj) {
                Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
                int i = this.label;
                if (i == 0) {
                    ResultKt.throwOnFailure(obj);
                    PlatformTextInputSessionScope platformTextInputSessionScope = (PlatformTextInputSessionScope) this.L$0;
                    TransformedTextFieldState textFieldState = this.this$0.getTextFieldState();
                    TextLayoutState textLayoutState = this.this$0.getTextLayoutState();
                    ImeOptions imeOptions$foundation = this.this$0.getKeyboardOptions().toImeOptions$foundation(this.this$0.getSingleLine());
                    ReceiveContentConfiguration receiveContentConfiguration = this.$receiveContentConfiguration;
                    C00351 c00351 = new C00351(this.this$0);
                    final TextFieldDecoratorModifierNode textFieldDecoratorModifierNode = this.this$0;
                    Function0 function0 = new Function0() { // from class: androidx.compose.foundation.text.input.internal.TextFieldDecoratorModifierNode$startInputSession$1$1$$ExternalSyntheticLambda0
                        @Override // kotlin.jvm.functions.Function0
                        public final Object invoke() {
                            return TextFieldDecoratorModifierNode.C03631.C00341.invokeSuspend$lambda$0(textFieldDecoratorModifierNode);
                        }
                    };
                    MutableSharedFlow<Unit> stylusHandwritingTrigger = this.this$0.getStylusHandwritingTrigger();
                    ViewConfiguration viewConfiguration = (ViewConfiguration) CompositionLocalConsumerModifierNodeKt.currentValueOf(this.this$0, CompositionLocalsKt.getLocalViewConfiguration());
                    final TextFieldDecoratorModifierNode textFieldDecoratorModifierNode2 = this.this$0;
                    this.label = 1;
                    if (AndroidTextInputSession_androidKt.platformSpecificTextInputSession(platformTextInputSessionScope, textFieldState, textLayoutState, imeOptions$foundation, receiveContentConfiguration, c00351, function0, stylusHandwritingTrigger, viewConfiguration, new Function1() { // from class: androidx.compose.foundation.text.input.internal.TextFieldDecoratorModifierNode$startInputSession$1$1$$ExternalSyntheticLambda1
                        @Override // kotlin.jvm.functions.Function1
                        public final Object invoke(Object obj2) {
                            return TextFieldDecoratorModifierNode.C03631.C00341.invokeSuspend$lambda$1(textFieldDecoratorModifierNode2, ((Boolean) obj2).booleanValue());
                        }
                    }, this) == coroutine_suspended) {
                        return coroutine_suspended;
                    }
                } else {
                    if (i != 1) {
                        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                    }
                    ResultKt.throwOnFailure(obj);
                }
                throw new KotlinNothingValueException();
            }

            /* JADX INFO: renamed from: androidx.compose.foundation.text.input.internal.TextFieldDecoratorModifierNode$startInputSession$1$1$1, reason: invalid class name and collision with other inner class name */
            /* JADX INFO: compiled from: TextFieldDecoratorModifier.kt */
            @Metadata(k = 3, mv = {2, 1, 0}, xi = 48)
            static final /* synthetic */ class C00351 extends AdaptedFunctionReference implements Function1<ImeAction, Unit> {
                C00351(Object obj) {
                    super(1, obj, TextFieldDecoratorModifierNode.class, "onImeActionPerformed", "onImeActionPerformed-KlQnJC8(I)Z", 8);
                }

                @Override // kotlin.jvm.functions.Function1
                public /* bridge */ /* synthetic */ Unit invoke(ImeAction imeAction) {
                    m2096invokeKlQnJC8(imeAction.getValue());
                    return Unit.INSTANCE;
                }

                /* JADX INFO: renamed from: invoke-KlQnJC8, reason: not valid java name */
                public final void m2096invokeKlQnJC8(int i) {
                    ((TextFieldDecoratorModifierNode) this.receiver).m2091onImeActionPerformedKlQnJC8(i);
                }
            }

            /* JADX INFO: Access modifiers changed from: private */
            public static final Unit invokeSuspend$lambda$0(TextFieldDecoratorModifierNode textFieldDecoratorModifierNode) {
                textFieldDecoratorModifierNode.getTextFieldSelectionState().updateTextToolbarState(TextToolbarState.Selection);
                return Unit.INSTANCE;
            }

            /* JADX INFO: Access modifiers changed from: private */
            public static final Unit invokeSuspend$lambda$1(TextFieldDecoratorModifierNode textFieldDecoratorModifierNode, boolean z) {
                textFieldDecoratorModifierNode.getTextFieldSelectionState().setInTouchMode(z);
                return Unit.INSTANCE;
            }
        }
    }

    private final void disposeInputSession() {
        Job job = this.inputSessionJob;
        if (job != null) {
            Job.DefaultImpls.cancel$default(job, (CancellationException) null, 1, (Object) null);
        }
        this.inputSessionJob = null;
        MutableSharedFlow<Unit> mutableSharedFlow = this.stylusHandwritingTrigger;
        if (mutableSharedFlow != null) {
            mutableSharedFlow.resetReplayCache();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final SoftwareKeyboardController requireKeyboardController() {
        SoftwareKeyboardController softwareKeyboardController = (SoftwareKeyboardController) CompositionLocalConsumerModifierNodeKt.currentValueOf(this, CompositionLocalsKt.getLocalSoftwareKeyboardController());
        if (softwareKeyboardController != null) {
            return softwareKeyboardController;
        }
        throw new IllegalStateException("No software keyboard controller".toString());
    }

    private final void emitDragExitEvent() {
        DragAndDropHoverInteraction.Enter enter = this.dragEnterEvent;
        if (enter != null) {
            this.interactionSource.tryEmit(new DragAndDropHoverInteraction.Exit(enter));
            this.dragEnterEvent = null;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX INFO: renamed from: onImeActionPerformed-KlQnJC8, reason: not valid java name */
    public final boolean m2091onImeActionPerformedKlQnJC8(final int imeAction) {
        KeyboardActionHandler keyboardActionHandler;
        if (ImeAction.m8445equalsimpl0(imeAction, ImeAction.INSTANCE.m8462getNoneeUduSuo()) || ImeAction.m8445equalsimpl0(imeAction, ImeAction.INSTANCE.m8458getDefaulteUduSuo()) || (keyboardActionHandler = this.keyboardActionHandler) == null) {
            return m2090defaultKeyboardActionWithResultKlQnJC8(imeAction);
        }
        if (keyboardActionHandler == null) {
            return true;
        }
        keyboardActionHandler.onKeyboardAction(new Function0() { // from class: androidx.compose.foundation.text.input.internal.TextFieldDecoratorModifierNode$$ExternalSyntheticLambda18
            @Override // kotlin.jvm.functions.Function0
            public final Object invoke() {
                return TextFieldDecoratorModifierNode.onImeActionPerformed_KlQnJC8$lambda$0(this.f$0, imeAction);
            }
        });
        return true;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit onImeActionPerformed_KlQnJC8$lambda$0(TextFieldDecoratorModifierNode textFieldDecoratorModifierNode, int i) {
        textFieldDecoratorModifierNode.keyboardActionScope.mo1764defaultKeyboardActionKlQnJC8(i);
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX INFO: renamed from: defaultKeyboardActionWithResult-KlQnJC8, reason: not valid java name */
    public final boolean m2090defaultKeyboardActionWithResultKlQnJC8(int imeAction) {
        if (ImeAction.m8445equalsimpl0(imeAction, ImeAction.INSTANCE.m8461getNexteUduSuo())) {
            ((FocusManager) CompositionLocalConsumerModifierNodeKt.currentValueOf(this, CompositionLocalsKt.getLocalFocusManager())).mo5612moveFocus3ESFkO8(FocusDirection.INSTANCE.m5606getNextdhqQ8s());
            return true;
        }
        if (ImeAction.m8445equalsimpl0(imeAction, ImeAction.INSTANCE.m8463getPreviouseUduSuo())) {
            ((FocusManager) CompositionLocalConsumerModifierNodeKt.currentValueOf(this, CompositionLocalsKt.getLocalFocusManager())).mo5612moveFocus3ESFkO8(FocusDirection.INSTANCE.m5607getPreviousdhqQ8s());
            return true;
        }
        if (!ImeAction.m8445equalsimpl0(imeAction, ImeAction.INSTANCE.m8459getDoneeUduSuo())) {
            return false;
        }
        requireKeyboardController().hide();
        return true;
    }
}
