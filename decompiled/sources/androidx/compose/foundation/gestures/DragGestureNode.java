package androidx.compose.foundation.gestures;

import androidx.compose.foundation.ComposeFoundationFlags;
import androidx.compose.foundation.GestureConnection;
import androidx.compose.foundation.GestureNodeKt;
import androidx.compose.foundation.gestures.DragDetectionState;
import androidx.compose.foundation.gestures.DragEvent;
import androidx.compose.foundation.interaction.DragInteraction;
import androidx.compose.foundation.interaction.MutableInteractionSource;
import androidx.compose.ui.geometry.InlineClassHelperKt;
import androidx.compose.ui.geometry.Offset;
import androidx.compose.ui.input.indirect.IndirectPointerEvent;
import androidx.compose.ui.input.indirect.IndirectPointerInputChange;
import androidx.compose.ui.input.indirect.IndirectPointerInputModifierNode;
import androidx.compose.ui.input.pointer.PointerEvent;
import androidx.compose.ui.input.pointer.PointerEventKt;
import androidx.compose.ui.input.pointer.PointerEventPass;
import androidx.compose.ui.input.pointer.PointerId;
import androidx.compose.ui.input.pointer.PointerInputChange;
import androidx.compose.ui.input.pointer.PointerType;
import androidx.compose.ui.input.pointer.util.VelocityTracker;
import androidx.compose.ui.input.pointer.util.VelocityTrackerKt;
import androidx.compose.ui.layout.LayoutCoordinatesKt;
import androidx.compose.ui.node.CompositionLocalConsumerModifierNode;
import androidx.compose.ui.node.CompositionLocalConsumerModifierNodeKt;
import androidx.compose.ui.node.DelegatableNode;
import androidx.compose.ui.node.DelegatableNodeKt;
import androidx.compose.ui.node.DelegatingNode;
import androidx.compose.ui.node.PointerInputModifierNode;
import androidx.compose.ui.platform.CompositionLocalsKt;
import androidx.compose.ui.platform.ViewConfiguration;
import androidx.compose.ui.unit.VelocityKt;
import androidx.constraintlayout.core.motion.utils.TypedValues;
import java.util.List;
import kotlin.Metadata;
import kotlin.NoWhenBranchMatchedException;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.jvm.internal.ContinuationImpl;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Ref;
import kotlinx.coroutines.BuildersKt__Builders_commonKt;
import kotlinx.coroutines.CoroutineScope;
import kotlinx.coroutines.channels.Channel;
import kotlinx.coroutines.channels.ChannelKt;
import org.jivesoftware.smack.sm.packet.StreamManagement;
import org.jivesoftware.smackx.disco.packet.DiscoverItems;

/* JADX INFO: compiled from: Draggable.kt */
/* JADX INFO: loaded from: classes.dex */
@Metadata(d1 = {"\u0000ø\u0001\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u000e\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\r\n\u0002\u0018\u0002\n\u0002\b\u001e\b!\u0018\u00002\u00020\u00012\u00020\u00022\u00020\u00032\u00020\u00042\u00020\u0005B7\u0012\u0012\u0010\u0006\u001a\u000e\u0012\u0004\u0012\u00020\b\u0012\u0004\u0012\u00020\t0\u0007\u0012\u0006\u0010\n\u001a\u00020\t\u0012\b\u0010\u000b\u001a\u0004\u0018\u00010\f\u0012\b\u0010\r\u001a\u0004\u0018\u00010\u000e¢\u0006\u0004\b\u000f\u0010\u0010JM\u0010K\u001a\u00020L2=\u0010M\u001a9\b\u0001\u0012\u001f\u0012\u001d\u0012\u0013\u0012\u00110O¢\u0006\f\bP\u0012\b\bQ\u0012\u0004\b\b(R\u0012\u0004\u0012\u00020L0\u0007\u0012\n\u0012\b\u0012\u0004\u0012\u00020L0S\u0012\u0006\u0012\u0004\u0018\u00010T0NH¦@¢\u0006\u0002\u0010UJ\u0017\u0010V\u001a\u00020L2\u0006\u0010W\u001a\u00020DH&¢\u0006\u0004\bX\u0010YJ\u0010\u0010Z\u001a\u00020L2\u0006\u0010[\u001a\u00020\\H&J\b\u0010]\u001a\u00020\tH&J\b\u0010^\u001a\u00020BH\u0002J\u000e\u0010_\u001a\b\u0012\u0004\u0012\u00020!0 H\u0002J\b\u0010`\u001a\u00020GH\u0002J\b\u0010a\u001a\u00020LH\u0002J\b\u0010b\u001a\u00020LH\u0016J\b\u0010c\u001a\u00020LH\u0004J\u0010\u0010d\u001a\u00020\t2\u0006\u0010[\u001a\u00020eH\u0016J'\u0010f\u001a\u00020L2\u0006\u0010g\u001a\u00020h2\u0006\u0010i\u001a\u00020j2\u0006\u0010k\u001a\u00020lH\u0016¢\u0006\u0004\bm\u0010nJ\u0018\u0010o\u001a\u00020L2\u0006\u0010[\u001a\u00020p2\u0006\u0010i\u001a\u00020jH\u0016J\b\u0010q\u001a\u00020LH\u0016J\u0010\u0010d\u001a\u00020\t2\u0006\u0010[\u001a\u00020rH\u0016J\b\u0010s\u001a\u00020LH\u0016J\u0016\u0010t\u001a\u00020L2\u0006\u0010[\u001a\u00020uH\u0082@¢\u0006\u0002\u0010vJ\u0016\u0010w\u001a\u00020L2\u0006\u0010[\u001a\u00020\\H\u0082@¢\u0006\u0002\u0010xJ\u000e\u0010y\u001a\u00020LH\u0082@¢\u0006\u0002\u0010zJ\u0006\u0010{\u001a\u00020LJH\u0010|\u001a\u00020L2\u0014\b\u0002\u0010\u0006\u001a\u000e\u0012\u0004\u0012\u00020\b\u0012\u0004\u0012\u00020\t0\u00072\b\b\u0002\u0010\n\u001a\u00020\t2\n\b\u0002\u0010\u000b\u001a\u0004\u0018\u00010\f2\n\b\u0002\u0010\r\u001a\u0004\u0018\u00010\u000e2\b\b\u0002\u0010}\u001a\u00020\tJ\u0018\u0010~\u001a\u00020L2\u0006\u0010g\u001a\u00020h2\u0006\u0010i\u001a\u00020jH\u0002J\b\u0010\u007f\u001a\u00020LH\u0002J;\u0010\u0080\u0001\u001a\u00020L2\u0007\u0010\u0081\u0001\u001a\u00020r2\b\u0010\u0082\u0001\u001a\u00030\u0083\u00012\t\b\u0002\u0010\u0084\u0001\u001a\u00020D2\t\b\u0002\u0010\u0085\u0001\u001a\u00020\tH\u0002¢\u0006\u0006\b\u0086\u0001\u0010\u0087\u0001J\u001b\u0010\u0088\u0001\u001a\u00020L2\b\u0010\u0082\u0001\u001a\u00030\u0083\u0001H\u0002¢\u0006\u0005\b\u0089\u0001\u0010YJ\t\u0010\u008a\u0001\u001a\u00020LH\u0002J-\u0010\u008b\u0001\u001a\u00020L2\u0007\u0010\u0081\u0001\u001a\u00020r2\b\u0010\u0082\u0001\u001a\u00030\u0083\u00012\u0006\u0010F\u001a\u00020GH\u0002¢\u0006\u0006\b\u008c\u0001\u0010\u008d\u0001J\"\u0010\u008e\u0001\u001a\u00020L2\u0006\u0010g\u001a\u00020h2\u0006\u0010i\u001a\u00020j2\u0007\u0010\u008f\u0001\u001a\u00020,H\u0002J\"\u0010\u0090\u0001\u001a\u00020L2\u0006\u0010g\u001a\u00020h2\u0006\u0010i\u001a\u00020j2\u0007\u0010\u008f\u0001\u001a\u000206H\u0002J\"\u0010\u0091\u0001\u001a\u00020L2\u0006\u0010g\u001a\u00020h2\u0006\u0010i\u001a\u00020j2\u0007\u0010\u008f\u0001\u001a\u00020;H\u0002J\"\u0010\u0092\u0001\u001a\u00020L2\u0006\u0010g\u001a\u00020h2\u0006\u0010i\u001a\u00020j2\u0007\u0010\u008f\u0001\u001a\u000201H\u0002J-\u0010\u0093\u0001\u001a\u00020L2\u0007\u0010\u0094\u0001\u001a\u00020r2\u0007\u0010\u0095\u0001\u001a\u00020r2\u0007\u0010\u0096\u0001\u001a\u00020DH\u0002¢\u0006\u0006\b\u0097\u0001\u0010\u0098\u0001J$\u0010\u0099\u0001\u001a\u00020L2\u0007\u0010\u009a\u0001\u001a\u00020r2\u0007\u0010\u009b\u0001\u001a\u00020DH\u0002¢\u0006\u0006\b\u009c\u0001\u0010\u009d\u0001J\u0012\u0010\u009e\u0001\u001a\u00020L2\u0007\u0010\u009a\u0001\u001a\u00020rH\u0002J\t\u0010\u009f\u0001\u001a\u00020LH\u0002J\u000f\u0010 \u0001\u001a\u00020L2\u0006\u0010[\u001a\u00020!R\u001c\u0010\r\u001a\u0004\u0018\u00010\u000eX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0011\u0010\u0012\"\u0004\b\u0013\u0010\u0014R6\u0010\u0006\u001a\u000e\u0012\u0004\u0012\u00020\b\u0012\u0004\u0012\u00020\t0\u00072\u0012\u0010\u0015\u001a\u000e\u0012\u0004\u0012\u00020\b\u0012\u0004\u0012\u00020\t0\u0007@BX\u0086\u000e¢\u0006\b\n\u0000\u001a\u0004\b\u0016\u0010\u0017R\u001e\u0010\n\u001a\u00020\t2\u0006\u0010\u0015\u001a\u00020\t@BX\u0084\u000e¢\u0006\b\n\u0000\u001a\u0004\b\u0018\u0010\u0019R\"\u0010\u000b\u001a\u0004\u0018\u00010\f2\b\u0010\u0015\u001a\u0004\u0018\u00010\f@BX\u0084\u000e¢\u0006\b\n\u0000\u001a\u0004\b\u001a\u0010\u001bR\u0010\u0010\u001c\u001a\u0004\u0018\u00010\u001dX\u0082\u000e¢\u0006\u0002\n\u0000R\u001a\u0010\u001e\u001a\u000e\u0012\u0004\u0012\u00020\b\u0012\u0004\u0012\u00020\t0\u0007X\u0082\u0004¢\u0006\u0002\n\u0000R\u0016\u0010\u001f\u001a\n\u0012\u0004\u0012\u00020!\u0018\u00010 X\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\"\u001a\u0004\u0018\u00010#X\u0082\u000e¢\u0006\u0002\n\u0000R\u001a\u0010$\u001a\u00020\tX\u0080\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b%\u0010\u0019\"\u0004\b&\u0010'R\u001a\u0010(\u001a\u00020\tX\u0080\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b)\u0010\u0019\"\u0004\b*\u0010'R\u0010\u0010+\u001a\u0004\u0018\u00010,X\u0082\u000e¢\u0006\u0002\n\u0000R\u0014\u0010-\u001a\u00020,8BX\u0082\u0004¢\u0006\u0006\u001a\u0004\b.\u0010/R\u0010\u00100\u001a\u0004\u0018\u000101X\u0082\u000e¢\u0006\u0002\n\u0000R\u0014\u00102\u001a\u0002018BX\u0082\u0004¢\u0006\u0006\u001a\u0004\b3\u00104R\u0010\u00105\u001a\u0004\u0018\u000106X\u0082\u000e¢\u0006\u0002\n\u0000R\u0014\u00107\u001a\u0002068BX\u0082\u0004¢\u0006\u0006\u001a\u0004\b8\u00109R\u0010\u0010:\u001a\u0004\u0018\u00010;X\u0082\u000e¢\u0006\u0002\n\u0000R\u0014\u0010<\u001a\u00020;8BX\u0082\u0004¢\u0006\u0006\u001a\u0004\b=\u0010>R\u0010\u0010?\u001a\u0004\u0018\u00010@X\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010A\u001a\u0004\u0018\u00010BX\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010C\u001a\u00020DX\u0082\u000e¢\u0006\u0004\n\u0002\u0010ER\u0010\u0010F\u001a\u0004\u0018\u00010GX\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010H\u001a\u0004\u0018\u00010IX\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010J\u001a\u00020DX\u0082\u000e¢\u0006\u0004\n\u0002\u0010E¨\u0006¡\u0001"}, d2 = {"Landroidx/compose/foundation/gestures/DragGestureNode;", "Landroidx/compose/ui/node/DelegatingNode;", "Landroidx/compose/ui/node/PointerInputModifierNode;", "Landroidx/compose/ui/input/indirect/IndirectPointerInputModifierNode;", "Landroidx/compose/ui/node/CompositionLocalConsumerModifierNode;", "Landroidx/compose/foundation/GestureConnection;", "canDrag", "Lkotlin/Function1;", "Landroidx/compose/ui/input/pointer/PointerType;", "", StreamManagement.Enabled.ELEMENT, "interactionSource", "Landroidx/compose/foundation/interaction/MutableInteractionSource;", "orientationLock", "Landroidx/compose/foundation/gestures/Orientation;", "<init>", "(Lkotlin/jvm/functions/Function1;ZLandroidx/compose/foundation/interaction/MutableInteractionSource;Landroidx/compose/foundation/gestures/Orientation;)V", "getOrientationLock", "()Landroidx/compose/foundation/gestures/Orientation;", "setOrientationLock", "(Landroidx/compose/foundation/gestures/Orientation;)V", "value", "getCanDrag", "()Lkotlin/jvm/functions/Function1;", "getEnabled", "()Z", "getInteractionSource", "()Landroidx/compose/foundation/interaction/MutableInteractionSource;", "gestureNode", "Landroidx/compose/ui/node/DelegatableNode;", "_canDrag", "channel", "Lkotlinx/coroutines/channels/Channel;", "Landroidx/compose/foundation/gestures/DragEvent;", "dragInteraction", "Landroidx/compose/foundation/interaction/DragInteraction$Start;", "isListeningForEvents", "isListeningForEvents$foundation", "setListeningForEvents$foundation", "(Z)V", "isListeningForPointerInputEvents", "isListeningForPointerInputEvents$foundation", "setListeningForPointerInputEvents$foundation", "_awaitDownState", "Landroidx/compose/foundation/gestures/DragDetectionState$AwaitDown;", "awaitDownState", "getAwaitDownState", "()Landroidx/compose/foundation/gestures/DragDetectionState$AwaitDown;", "_draggingState", "Landroidx/compose/foundation/gestures/DragDetectionState$Dragging;", "draggingState", "getDraggingState", "()Landroidx/compose/foundation/gestures/DragDetectionState$Dragging;", "_awaitTouchSlopState", "Landroidx/compose/foundation/gestures/DragDetectionState$AwaitTouchSlop;", "awaitTouchSlopState", "getAwaitTouchSlopState", "()Landroidx/compose/foundation/gestures/DragDetectionState$AwaitTouchSlop;", "_awaitGesturePickupState", "Landroidx/compose/foundation/gestures/DragDetectionState$AwaitGesturePickup;", "awaitGesturePickupState", "getAwaitGesturePickupState", "()Landroidx/compose/foundation/gestures/DragDetectionState$AwaitGesturePickup;", "currentDragState", "Landroidx/compose/foundation/gestures/DragDetectionState;", "velocityTracker", "Landroidx/compose/ui/input/pointer/util/VelocityTracker;", "previousPositionOnScreen", "Landroidx/compose/ui/geometry/Offset;", "J", "touchSlopDetector", "Landroidx/compose/foundation/gestures/TouchSlopDetector;", "indirectPointerInputDragCycleDetector", "Landroidx/compose/foundation/gestures/IndirectPointerInputDragCycleDetector;", "nodeOffset", "drag", "", "forEachDelta", "Lkotlin/Function2;", "Landroidx/compose/foundation/gestures/DragEvent$DragDelta;", "Lkotlin/ParameterName;", "name", "dragDelta", "Lkotlin/coroutines/Continuation;", "", "(Lkotlin/jvm/functions/Function2;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "onDragStarted", "startedPosition", "onDragStarted-k-4lQ0M", "(J)V", "onDragStopped", "event", "Landroidx/compose/foundation/gestures/DragEvent$DragStopped;", "startDragImmediately", "requireVelocityTracker", "requireChannel", "requireTouchSlopDetector", "startListeningForEvents", "onDetach", "initializeGestureCoordination", "isInterested", "Landroidx/compose/ui/input/indirect/IndirectPointerInputChange;", "onPointerEvent", "pointerEvent", "Landroidx/compose/ui/input/pointer/PointerEvent;", "pass", "Landroidx/compose/ui/input/pointer/PointerEventPass;", "bounds", "Landroidx/compose/ui/unit/IntSize;", "onPointerEvent-H0pRuoY", "(Landroidx/compose/ui/input/pointer/PointerEvent;Landroidx/compose/ui/input/pointer/PointerEventPass;J)V", "onIndirectPointerEvent", "Landroidx/compose/ui/input/indirect/IndirectPointerEvent;", "onCancelIndirectPointerInput", "Landroidx/compose/ui/input/pointer/PointerInputChange;", "onCancelPointerInput", "processDragStart", "Landroidx/compose/foundation/gestures/DragEvent$DragStarted;", "(Landroidx/compose/foundation/gestures/DragEvent$DragStarted;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "processDragStop", "(Landroidx/compose/foundation/gestures/DragEvent$DragStopped;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "processDragCancel", "(Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "disposeInteractionSource", DiscoverItems.Item.UPDATE_ACTION, "shouldResetPointerInputHandling", "processRawPointerEvent", "resetDragDetectionState", "moveToAwaitTouchSlopState", "initialDown", "pointerId", "Landroidx/compose/ui/input/pointer/PointerId;", "initialTouchSlopPositionChange", "verifyConsumptionInFinalPass", "moveToAwaitTouchSlopState-aWI9W7U", "(Landroidx/compose/ui/input/pointer/PointerInputChange;JJZ)V", "moveToDraggingState", "moveToDraggingState-0FcD4WY", "moveToAwaitDownState", "moveToAwaitGesturePickupState", "moveToAwaitGesturePickupState-rnUCldI", "(Landroidx/compose/ui/input/pointer/PointerInputChange;JLandroidx/compose/foundation/gestures/TouchSlopDetector;)V", "processInitialDownState", "state", "processAwaitTouchSlop", "processAwaitGesturePickup", "processDraggingState", "sendDragStart", "down", "slopTriggerChange", "overSlopOffset", "sendDragStart-0AR0LA0", "(Landroidx/compose/ui/input/pointer/PointerInputChange;Landroidx/compose/ui/input/pointer/PointerInputChange;J)V", "sendDragEvent", "change", "dragAmount", "sendDragEvent-Uv8p0NA", "(Landroidx/compose/ui/input/pointer/PointerInputChange;J)V", "sendDragStopped", "sendDragCancelled", "onDragEvent", "foundation"}, k = 1, mv = {2, 1, 0}, xi = 48)
public abstract class DragGestureNode extends DelegatingNode implements PointerInputModifierNode, IndirectPointerInputModifierNode, CompositionLocalConsumerModifierNode, GestureConnection {
    public static final int $stable = 8;
    private DragDetectionState.AwaitDown _awaitDownState;
    private DragDetectionState.AwaitGesturePickup _awaitGesturePickupState;
    private DragDetectionState.AwaitTouchSlop _awaitTouchSlopState;
    private DragDetectionState.Dragging _draggingState;
    private Function1<? super PointerType, Boolean> canDrag;
    private Channel<DragEvent> channel;
    private DragDetectionState currentDragState;
    private DragInteraction.Start dragInteraction;
    private boolean enabled;
    private DelegatableNode gestureNode;
    private IndirectPointerInputDragCycleDetector indirectPointerInputDragCycleDetector;
    private MutableInteractionSource interactionSource;
    private boolean isListeningForEvents;
    private boolean isListeningForPointerInputEvents;
    private Orientation orientationLock;
    private TouchSlopDetector touchSlopDetector;
    private VelocityTracker velocityTracker;
    private final Function1<PointerType, Boolean> _canDrag = new Function1() { // from class: androidx.compose.foundation.gestures.DragGestureNode$$ExternalSyntheticLambda0
        @Override // kotlin.jvm.functions.Function1
        public final Object invoke(Object obj) {
            return Boolean.valueOf(DragGestureNode._canDrag$lambda$0(this.f$0, (PointerType) obj));
        }
    };
    private long previousPositionOnScreen = Offset.INSTANCE.m5738getUnspecifiedF1C5BW0();
    private long nodeOffset = Offset.INSTANCE.m5739getZeroF1C5BW0();

    /* JADX INFO: compiled from: Draggable.kt */
    @Metadata(k = 3, mv = {2, 1, 0}, xi = 48)
    public static final /* synthetic */ class WhenMappings {
        public static final /* synthetic */ int[] $EnumSwitchMapping$0;

        static {
            int[] iArr = new int[DragDetectionState.AwaitDown.AwaitTouchSlop.values().length];
            try {
                iArr[DragDetectionState.AwaitDown.AwaitTouchSlop.NotInitialized.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            $EnumSwitchMapping$0 = iArr;
        }
    }

    /* JADX INFO: renamed from: androidx.compose.foundation.gestures.DragGestureNode$processDragCancel$1, reason: invalid class name */
    /* JADX INFO: compiled from: Draggable.kt */
    @Metadata(k = 3, mv = {2, 1, 0}, xi = 48)
    @DebugMetadata(c = "androidx.compose.foundation.gestures.DragGestureNode", f = "Draggable.kt", i = {}, l = {634}, m = "processDragCancel", n = {}, s = {}, v = 1)
    static final class AnonymousClass1 extends ContinuationImpl {
        int label;
        /* synthetic */ Object result;

        AnonymousClass1(Continuation<? super AnonymousClass1> continuation) {
            super(continuation);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object obj) {
            this.result = obj;
            this.label |= Integer.MIN_VALUE;
            return DragGestureNode.this.processDragCancel(this);
        }
    }

    /* JADX INFO: renamed from: androidx.compose.foundation.gestures.DragGestureNode$processDragStart$1, reason: invalid class name and case insensitive filesystem */
    /* JADX INFO: compiled from: Draggable.kt */
    @Metadata(k = 3, mv = {2, 1, 0}, xi = 48)
    @DebugMetadata(c = "androidx.compose.foundation.gestures.DragGestureNode", f = "Draggable.kt", i = {0, 1, 1}, l = {616, 619}, m = "processDragStart", n = {"event", "event", "interaction"}, s = {"L$0", "L$0", "L$1"}, v = 1)
    static final class C02901 extends ContinuationImpl {
        Object L$0;
        Object L$1;
        int label;
        /* synthetic */ Object result;

        C02901(Continuation<? super C02901> continuation) {
            super(continuation);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object obj) {
            this.result = obj;
            this.label |= Integer.MIN_VALUE;
            return DragGestureNode.this.processDragStart(null, this);
        }
    }

    /* JADX INFO: renamed from: androidx.compose.foundation.gestures.DragGestureNode$processDragStop$1, reason: invalid class name and case insensitive filesystem */
    /* JADX INFO: compiled from: Draggable.kt */
    @Metadata(k = 3, mv = {2, 1, 0}, xi = 48)
    @DebugMetadata(c = "androidx.compose.foundation.gestures.DragGestureNode", f = "Draggable.kt", i = {0}, l = {626}, m = "processDragStop", n = {"event"}, s = {"L$0"}, v = 1)
    static final class C02911 extends ContinuationImpl {
        Object L$0;
        int label;
        /* synthetic */ Object result;

        C02911(Continuation<? super C02911> continuation) {
            super(continuation);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object obj) {
            this.result = obj;
            this.label |= Integer.MIN_VALUE;
            return DragGestureNode.this.processDragStop(null, this);
        }
    }

    public abstract Object drag(Function2<? super Function1<? super DragEvent.DragDelta, Unit>, ? super Continuation<? super Unit>, ? extends Object> function2, Continuation<? super Unit> continuation);

    /* JADX INFO: renamed from: onDragStarted-k-4lQ0M */
    public abstract void mo509onDragStartedk4lQ0M(long startedPosition);

    public abstract void onDragStopped(DragEvent.DragStopped event);

    /* JADX INFO: renamed from: startDragImmediately */
    public abstract boolean getStartDragImmediately();

    public DragGestureNode(Function1<? super PointerType, Boolean> function1, boolean z, MutableInteractionSource mutableInteractionSource, Orientation orientation) {
        this.orientationLock = orientation;
        this.canDrag = function1;
        this.enabled = z;
        this.interactionSource = mutableInteractionSource;
    }

    public final Orientation getOrientationLock() {
        return this.orientationLock;
    }

    public final void setOrientationLock(Orientation orientation) {
        this.orientationLock = orientation;
    }

    public final Function1<PointerType, Boolean> getCanDrag() {
        return this.canDrag;
    }

    protected final boolean getEnabled() {
        return this.enabled;
    }

    protected final MutableInteractionSource getInteractionSource() {
        return this.interactionSource;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final boolean _canDrag$lambda$0(DragGestureNode dragGestureNode, PointerType pointerType) {
        return dragGestureNode.canDrag.invoke(pointerType).booleanValue();
    }

    /* JADX INFO: renamed from: isListeningForEvents$foundation, reason: from getter */
    public final boolean getIsListeningForEvents() {
        return this.isListeningForEvents;
    }

    public final void setListeningForEvents$foundation(boolean z) {
        this.isListeningForEvents = z;
    }

    /* JADX INFO: renamed from: isListeningForPointerInputEvents$foundation, reason: from getter */
    public final boolean getIsListeningForPointerInputEvents() {
        return this.isListeningForPointerInputEvents;
    }

    public final void setListeningForPointerInputEvents$foundation(boolean z) {
        this.isListeningForPointerInputEvents = z;
    }

    private final DragDetectionState.AwaitDown getAwaitDownState() {
        DragDetectionState.AwaitDown awaitDown = this._awaitDownState;
        if (awaitDown != null) {
            return awaitDown;
        }
        DragDetectionState.AwaitDown awaitDown2 = new DragDetectionState.AwaitDown(null, false, 3, null);
        this._awaitDownState = awaitDown2;
        return awaitDown2;
    }

    private final DragDetectionState.Dragging getDraggingState() {
        DragDetectionState.Dragging dragging = this._draggingState;
        if (dragging != null) {
            return dragging;
        }
        DragDetectionState.Dragging dragging2 = new DragDetectionState.Dragging(0L, 1, null);
        this._draggingState = dragging2;
        return dragging2;
    }

    private final DragDetectionState.AwaitTouchSlop getAwaitTouchSlopState() {
        DragDetectionState.AwaitTouchSlop awaitTouchSlop = this._awaitTouchSlopState;
        if (awaitTouchSlop != null) {
            return awaitTouchSlop;
        }
        DragDetectionState.AwaitTouchSlop awaitTouchSlop2 = new DragDetectionState.AwaitTouchSlop(null, 0L, false, 7, null);
        this._awaitTouchSlopState = awaitTouchSlop2;
        return awaitTouchSlop2;
    }

    private final DragDetectionState.AwaitGesturePickup getAwaitGesturePickupState() {
        DragDetectionState.AwaitGesturePickup awaitGesturePickup = this._awaitGesturePickupState;
        if (awaitGesturePickup != null) {
            return awaitGesturePickup;
        }
        DragDetectionState.AwaitGesturePickup awaitGesturePickup2 = new DragDetectionState.AwaitGesturePickup(null, 0L, null, 7, null);
        this._awaitGesturePickupState = awaitGesturePickup2;
        return awaitGesturePickup2;
    }

    private final VelocityTracker requireVelocityTracker() {
        VelocityTracker velocityTracker = this.velocityTracker;
        if (velocityTracker != null) {
            return velocityTracker;
        }
        throw new IllegalArgumentException("Velocity Tracker not initialized.".toString());
    }

    private final Channel<DragEvent> requireChannel() {
        Channel<DragEvent> channel = this.channel;
        if (channel != null) {
            return channel;
        }
        throw new IllegalArgumentException("Events channel not initialized.".toString());
    }

    private final TouchSlopDetector requireTouchSlopDetector() {
        TouchSlopDetector touchSlopDetector = this.touchSlopDetector;
        if (touchSlopDetector != null) {
            return touchSlopDetector;
        }
        throw new IllegalArgumentException("Touch slop detector not initialized.".toString());
    }

    private final void startListeningForEvents() {
        this.isListeningForEvents = true;
        if (this.channel == null) {
            this.channel = ChannelKt.Channel$default(Integer.MAX_VALUE, null, null, 6, null);
        }
        BuildersKt__Builders_commonKt.launch$default(getCoroutineScope(), null, null, new C02921(null), 3, null);
    }

    /* JADX INFO: renamed from: androidx.compose.foundation.gestures.DragGestureNode$startListeningForEvents$1, reason: invalid class name and case insensitive filesystem */
    /* JADX INFO: compiled from: Draggable.kt */
    @Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\n"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {2, 1, 0}, xi = 48)
    @DebugMetadata(c = "androidx.compose.foundation.gestures.DragGestureNode$startListeningForEvents$1", f = "Draggable.kt", i = {0, 0, 1, 1, 2, 2, 3, 4, 5}, l = {TypedValues.PositionType.TYPE_CURVE_FIT, TypedValues.PositionType.TYPE_POSITION_TYPE, 512, 519, 521, 524}, m = "invokeSuspend", n = {"$this$launch", "event", "$this$launch", "event", "$this$launch", "event", "$this$launch", "$this$launch", "$this$launch"}, s = {"L$0", "L$1", "L$0", "L$1", "L$0", "L$1", "L$0", "L$0", "L$0"}, v = 1)
    static final class C02921 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
        private /* synthetic */ Object L$0;
        Object L$1;
        Object L$2;
        int label;

        C02921(Continuation<? super C02921> continuation) {
            super(2, continuation);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
            C02921 c02921 = DragGestureNode.this.new C02921(continuation);
            c02921.L$0 = obj;
            return c02921;
        }

        @Override // kotlin.jvm.functions.Function2
        public final Object invoke(CoroutineScope coroutineScope, Continuation<? super Unit> continuation) {
            return ((C02921) create(coroutineScope, continuation)).invokeSuspend(Unit.INSTANCE);
        }

        /* JADX WARN: Code restructure failed: missing block: B:50:0x0118, code lost:
        
            if (r7.this$0.processDragCancel(r7) != r0) goto L11;
         */
        /* JADX WARN: Multi-variable type inference failed */
        /* JADX WARN: Path cross not found for [B:43:0x00ee, B:40:0x00d2], limit reached: 56 */
        /* JADX WARN: Path cross not found for [B:45:0x00f4, B:19:0x005f], limit reached: 56 */
        /* JADX WARN: Removed duplicated region for block: B:14:0x0034 A[PHI: r1 r3
          0x0034: PHI (r1v14 kotlin.jvm.internal.Ref$ObjectRef) = (r1v6 kotlin.jvm.internal.Ref$ObjectRef), (r1v20 kotlin.jvm.internal.Ref$ObjectRef) binds: [B:13:0x0031, B:36:0x00c9] A[DONT_GENERATE, DONT_INLINE]
          0x0034: PHI (r3v9 kotlinx.coroutines.CoroutineScope) = (r3v5 kotlinx.coroutines.CoroutineScope), (r3v14 kotlinx.coroutines.CoroutineScope) binds: [B:13:0x0031, B:36:0x00c9] A[DONT_GENERATE, DONT_INLINE]] */
        /* JADX WARN: Removed duplicated region for block: B:19:0x005f A[PHI: r4
          0x005f: PHI (r4v9 kotlinx.coroutines.CoroutineScope) = 
          (r4v0 kotlinx.coroutines.CoroutineScope)
          (r4v4 kotlinx.coroutines.CoroutineScope)
          (r4v4 kotlinx.coroutines.CoroutineScope)
          (r4v4 kotlinx.coroutines.CoroutineScope)
          (r4v7 kotlinx.coroutines.CoroutineScope)
          (r4v10 kotlinx.coroutines.CoroutineScope)
         binds: [B:18:0x0057, B:44:0x00f2, B:46:0x0104, B:41:0x00eb, B:30:0x0092, B:11:0x0027] A[DONT_GENERATE, DONT_INLINE]] */
        /* JADX WARN: Removed duplicated region for block: B:21:0x0065  */
        /* JADX WARN: Removed duplicated region for block: B:31:0x0094  */
        /* JADX WARN: Removed duplicated region for block: B:40:0x00d2 A[Catch: CancellationException -> 0x0107, TryCatch #0 {CancellationException -> 0x0107, blocks: (B:38:0x00cc, B:40:0x00d2, B:43:0x00ee, B:45:0x00f4), top: B:55:0x00cc }] */
        /* JADX WARN: Removed duplicated region for block: B:43:0x00ee A[Catch: CancellationException -> 0x0107, TryCatch #0 {CancellationException -> 0x0107, blocks: (B:38:0x00cc, B:40:0x00d2, B:43:0x00ee, B:45:0x00f4), top: B:55:0x00cc }] */
        /* JADX WARN: Removed duplicated region for block: B:52:0x011b  */
        /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:30:0x0092 -> B:19:0x005f). Please report as a decompilation issue!!! */
        /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:41:0x00eb -> B:19:0x005f). Please report as a decompilation issue!!! */
        /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:44:0x00f2 -> B:19:0x005f). Please report as a decompilation issue!!! */
        /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:46:0x0104 -> B:19:0x005f). Please report as a decompilation issue!!! */
        /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:50:0x0118 -> B:11:0x0027). Please report as a decompilation issue!!! */
        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        /*
            Code decompiled incorrectly, please refer to instructions dump.
            To view partially-correct add '--show-bad-code' argument
        */
        public final java.lang.Object invokeSuspend(java.lang.Object r8) {
            /*
                Method dump skipped, instruction units count: 304
                To view this dump add '--comments-level debug' option
            */
            throw new UnsupportedOperationException("Method not decompiled: androidx.compose.foundation.gestures.DragGestureNode.C02921.invokeSuspend(java.lang.Object):java.lang.Object");
        }

        /* JADX INFO: renamed from: androidx.compose.foundation.gestures.DragGestureNode$startListeningForEvents$1$1, reason: invalid class name and collision with other inner class name */
        /* JADX INFO: compiled from: Draggable.kt */
        @Metadata(d1 = {"\u0000\u0018\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\u0010\u0000\u001a\u00020\u00012!\u0010\u0002\u001a\u001d\u0012\u0013\u0012\u00110\u0004¢\u0006\f\b\u0005\u0012\b\b\u0006\u0012\u0004\b\b(\u0007\u0012\u0004\u0012\u00020\u00010\u0003H\n"}, d2 = {"<anonymous>", "", "processDelta", "Lkotlin/Function1;", "Landroidx/compose/foundation/gestures/DragEvent$DragDelta;", "Lkotlin/ParameterName;", "name", "dragDelta"}, k = 3, mv = {2, 1, 0}, xi = 48)
        @DebugMetadata(c = "androidx.compose.foundation.gestures.DragGestureNode$startListeningForEvents$1$1", f = "Draggable.kt", i = {0}, l = {515}, m = "invokeSuspend", n = {"processDelta"}, s = {"L$0"}, v = 1)
        static final class C00181 extends SuspendLambda implements Function2<Function1<? super DragEvent.DragDelta, ? extends Unit>, Continuation<? super Unit>, Object> {
            final /* synthetic */ Ref.ObjectRef<DragEvent> $event;
            /* synthetic */ Object L$0;
            Object L$1;
            int label;
            final /* synthetic */ DragGestureNode this$0;

            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            C00181(Ref.ObjectRef<DragEvent> objectRef, DragGestureNode dragGestureNode, Continuation<? super C00181> continuation) {
                super(2, continuation);
                this.$event = objectRef;
                this.this$0 = dragGestureNode;
            }

            @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
            public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
                C00181 c00181 = new C00181(this.$event, this.this$0, continuation);
                c00181.L$0 = obj;
                return c00181;
            }

            @Override // kotlin.jvm.functions.Function2
            public /* bridge */ /* synthetic */ Object invoke(Function1<? super DragEvent.DragDelta, ? extends Unit> function1, Continuation<? super Unit> continuation) {
                return invoke2((Function1<? super DragEvent.DragDelta, Unit>) function1, continuation);
            }

            /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
            public final Object invoke2(Function1<? super DragEvent.DragDelta, Unit> function1, Continuation<? super Unit> continuation) {
                return ((C00181) create(function1, continuation)).invokeSuspend(Unit.INSTANCE);
            }

            /* JADX WARN: Multi-variable type inference failed */
            /* JADX WARN: Removed duplicated region for block: B:11:0x002f  */
            /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:20:0x0051 -> B:25:0x0066). Please report as a decompilation issue!!! */
            /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:22:0x0060 -> B:24:0x0063). Please report as a decompilation issue!!! */
            @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
            /*
                Code decompiled incorrectly, please refer to instructions dump.
                To view partially-correct add '--show-bad-code' argument
            */
            public final java.lang.Object invokeSuspend(java.lang.Object r6) {
                /*
                    r5 = this;
                    java.lang.Object r0 = kotlin.coroutines.intrinsics.IntrinsicsKt.getCOROUTINE_SUSPENDED()
                    int r1 = r5.label
                    r2 = 1
                    if (r1 == 0) goto L1f
                    if (r1 != r2) goto L17
                    java.lang.Object r1 = r5.L$1
                    kotlin.jvm.internal.Ref$ObjectRef r1 = (kotlin.jvm.internal.Ref.ObjectRef) r1
                    java.lang.Object r3 = r5.L$0
                    kotlin.jvm.functions.Function1 r3 = (kotlin.jvm.functions.Function1) r3
                    kotlin.ResultKt.throwOnFailure(r6)
                    goto L63
                L17:
                    java.lang.IllegalStateException r6 = new java.lang.IllegalStateException
                    java.lang.String r0 = "call to 'resume' before 'invoke' with coroutine"
                    r6.<init>(r0)
                    throw r6
                L1f:
                    kotlin.ResultKt.throwOnFailure(r6)
                    java.lang.Object r6 = r5.L$0
                    kotlin.jvm.functions.Function1 r6 = (kotlin.jvm.functions.Function1) r6
                    r3 = r6
                L27:
                    kotlin.jvm.internal.Ref$ObjectRef<androidx.compose.foundation.gestures.DragEvent> r6 = r5.$event
                    T r6 = r6.element
                    boolean r6 = r6 instanceof androidx.compose.foundation.gestures.DragEvent.DragStopped
                    if (r6 != 0) goto L69
                    kotlin.jvm.internal.Ref$ObjectRef<androidx.compose.foundation.gestures.DragEvent> r6 = r5.$event
                    T r6 = r6.element
                    boolean r6 = r6 instanceof androidx.compose.foundation.gestures.DragEvent.DragCancelled
                    if (r6 != 0) goto L69
                    kotlin.jvm.internal.Ref$ObjectRef<androidx.compose.foundation.gestures.DragEvent> r6 = r5.$event
                    T r6 = r6.element
                    boolean r1 = r6 instanceof androidx.compose.foundation.gestures.DragEvent.DragDelta
                    r4 = 0
                    if (r1 == 0) goto L43
                    androidx.compose.foundation.gestures.DragEvent$DragDelta r6 = (androidx.compose.foundation.gestures.DragEvent.DragDelta) r6
                    goto L44
                L43:
                    r6 = r4
                L44:
                    if (r6 == 0) goto L49
                    r3.invoke(r6)
                L49:
                    kotlin.jvm.internal.Ref$ObjectRef<androidx.compose.foundation.gestures.DragEvent> r1 = r5.$event
                    androidx.compose.foundation.gestures.DragGestureNode r6 = r5.this$0
                    kotlinx.coroutines.channels.Channel r6 = androidx.compose.foundation.gestures.DragGestureNode.access$getChannel$p(r6)
                    if (r6 == 0) goto L66
                    r4 = r5
                    kotlin.coroutines.Continuation r4 = (kotlin.coroutines.Continuation) r4
                    r5.L$0 = r3
                    r5.L$1 = r1
                    r5.label = r2
                    java.lang.Object r6 = r6.receive(r4)
                    if (r6 != r0) goto L63
                    return r0
                L63:
                    r4 = r6
                    androidx.compose.foundation.gestures.DragEvent r4 = (androidx.compose.foundation.gestures.DragEvent) r4
                L66:
                    r1.element = r4
                    goto L27
                L69:
                    kotlin.Unit r6 = kotlin.Unit.INSTANCE
                    return r6
                */
                throw new UnsupportedOperationException("Method not decompiled: androidx.compose.foundation.gestures.DragGestureNode.C02921.C00181.invokeSuspend(java.lang.Object):java.lang.Object");
            }
        }
    }

    @Override // androidx.compose.ui.Modifier.Node
    public void onDetach() {
        this.isListeningForEvents = false;
        disposeInteractionSource();
        this.nodeOffset = Offset.INSTANCE.m5739getZeroF1C5BW0();
        DelegatableNode delegatableNode = this.gestureNode;
        if (delegatableNode != null) {
            undelegate(delegatableNode);
        }
        this.gestureNode = null;
    }

    protected final void initializeGestureCoordination() {
        if (ComposeFoundationFlags.isDelayPressesUsingGestureConsumptionEnabled && this.gestureNode == null) {
            this.gestureNode = delegate(GestureNodeKt.gestureNode(this));
        }
    }

    @Override // androidx.compose.foundation.GestureConnection
    public boolean isInterested(IndirectPointerInputChange event) {
        return IndirectPointerInputDragCycleDetectorKt.changedToDownIgnoreConsumed(event) && this.enabled;
    }

    @Override // androidx.compose.ui.node.PointerInputModifierNode
    /* JADX INFO: renamed from: onPointerEvent-H0pRuoY */
    public void mo280onPointerEventH0pRuoY(PointerEvent pointerEvent, PointerEventPass pass, long bounds) {
        this.isListeningForPointerInputEvents = true;
        initializeGestureCoordination();
        if (this.enabled) {
            if (this.currentDragState == null) {
                this.currentDragState = getAwaitDownState();
            }
            processRawPointerEvent(pointerEvent, pass);
        }
    }

    @Override // androidx.compose.ui.input.indirect.IndirectPointerInputModifierNode
    public void onIndirectPointerEvent(IndirectPointerEvent event, PointerEventPass pass) {
        initializeGestureCoordination();
        if (this.enabled) {
            if (this.indirectPointerInputDragCycleDetector == null) {
                this.indirectPointerInputDragCycleDetector = new IndirectPointerInputDragCycleDetector(this);
            }
            IndirectPointerInputDragCycleDetector indirectPointerInputDragCycleDetector = this.indirectPointerInputDragCycleDetector;
            if (indirectPointerInputDragCycleDetector != null) {
                indirectPointerInputDragCycleDetector.processIndirectPointerInputEvent(event, pass);
            }
        }
    }

    @Override // androidx.compose.ui.input.indirect.IndirectPointerInputModifierNode
    public void onCancelIndirectPointerInput() {
        IndirectPointerInputDragCycleDetector indirectPointerInputDragCycleDetector = this.indirectPointerInputDragCycleDetector;
        if (indirectPointerInputDragCycleDetector != null) {
            indirectPointerInputDragCycleDetector.resetDragDetectionState();
        }
    }

    @Override // androidx.compose.foundation.GestureConnection
    public boolean isInterested(PointerInputChange event) {
        if (PointerEventKt.changedToDownIgnoreConsumed(event)) {
            return this.enabled;
        }
        if (!ComposeFoundationFlags.isNestedDraggablesTouchConflictFixEnabled || PointerEventKt.changedToUpIgnoreConsumed(event)) {
            return false;
        }
        if (this.touchSlopDetector == null) {
            this.touchSlopDetector = new TouchSlopDetector(this.orientationLock, 0L, 2, null);
        }
        float touchSlop = ((ViewConfiguration) CompositionLocalConsumerModifierNodeKt.currentValueOf(this, CompositionLocalsKt.getLocalViewConfiguration())).getTouchSlop();
        long jPositionChange = PointerEventKt.positionChange(event);
        TouchSlopDetector touchSlopDetectorRequireTouchSlopDetector = requireTouchSlopDetector();
        return !Offset.m5720equalsimpl0(touchSlopDetectorRequireTouchSlopDetector.m714getPostSlopOffsetqto3Fdw(jPositionChange, touchSlop, false), Offset.INSTANCE.m5738getUnspecifiedF1C5BW0()) && touchSlopDetectorRequireTouchSlopDetector.m715isDeltaAtAngleOfInterestk4lQ0M(jPositionChange);
    }

    @Override // androidx.compose.ui.node.PointerInputModifierNode
    public void onCancelPointerInput() {
        if (this.isListeningForPointerInputEvents) {
            resetDragDetectionState();
        }
        this.isListeningForPointerInputEvents = false;
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Removed duplicated region for block: B:7:0x0014  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final java.lang.Object processDragStart(androidx.compose.foundation.gestures.DragEvent.DragStarted r7, kotlin.coroutines.Continuation<? super kotlin.Unit> r8) {
        /*
            r6 = this;
            boolean r0 = r8 instanceof androidx.compose.foundation.gestures.DragGestureNode.C02901
            if (r0 == 0) goto L14
            r0 = r8
            androidx.compose.foundation.gestures.DragGestureNode$processDragStart$1 r0 = (androidx.compose.foundation.gestures.DragGestureNode.C02901) r0
            int r1 = r0.label
            r2 = -2147483648(0xffffffff80000000, float:-0.0)
            r1 = r1 & r2
            if (r1 == 0) goto L14
            int r8 = r0.label
            int r8 = r8 - r2
            r0.label = r8
            goto L19
        L14:
            androidx.compose.foundation.gestures.DragGestureNode$processDragStart$1 r0 = new androidx.compose.foundation.gestures.DragGestureNode$processDragStart$1
            r0.<init>(r8)
        L19:
            java.lang.Object r8 = r0.result
            java.lang.Object r1 = kotlin.coroutines.intrinsics.IntrinsicsKt.getCOROUTINE_SUSPENDED()
            int r2 = r0.label
            r3 = 2
            r4 = 1
            if (r2 == 0) goto L45
            if (r2 == r4) goto L3d
            if (r2 != r3) goto L35
            java.lang.Object r7 = r0.L$1
            androidx.compose.foundation.interaction.DragInteraction$Start r7 = (androidx.compose.foundation.interaction.DragInteraction.Start) r7
            java.lang.Object r0 = r0.L$0
            androidx.compose.foundation.gestures.DragEvent$DragStarted r0 = (androidx.compose.foundation.gestures.DragEvent.DragStarted) r0
            kotlin.ResultKt.throwOnFailure(r8)
            goto L7d
        L35:
            java.lang.IllegalStateException r7 = new java.lang.IllegalStateException
            java.lang.String r8 = "call to 'resume' before 'invoke' with coroutine"
            r7.<init>(r8)
            throw r7
        L3d:
            java.lang.Object r7 = r0.L$0
            androidx.compose.foundation.gestures.DragEvent$DragStarted r7 = (androidx.compose.foundation.gestures.DragEvent.DragStarted) r7
            kotlin.ResultKt.throwOnFailure(r8)
            goto L62
        L45:
            kotlin.ResultKt.throwOnFailure(r8)
            androidx.compose.foundation.interaction.DragInteraction$Start r8 = r6.dragInteraction
            if (r8 == 0) goto L62
            androidx.compose.foundation.interaction.MutableInteractionSource r2 = r6.interactionSource
            if (r2 == 0) goto L62
            androidx.compose.foundation.interaction.DragInteraction$Cancel r5 = new androidx.compose.foundation.interaction.DragInteraction$Cancel
            r5.<init>(r8)
            androidx.compose.foundation.interaction.Interaction r5 = (androidx.compose.foundation.interaction.Interaction) r5
            r0.L$0 = r7
            r0.label = r4
            java.lang.Object r8 = r2.emit(r5, r0)
            if (r8 != r1) goto L62
            goto L7a
        L62:
            androidx.compose.foundation.interaction.DragInteraction$Start r8 = new androidx.compose.foundation.interaction.DragInteraction$Start
            r8.<init>()
            androidx.compose.foundation.interaction.MutableInteractionSource r2 = r6.interactionSource
            if (r2 == 0) goto L7f
            r4 = r8
            androidx.compose.foundation.interaction.Interaction r4 = (androidx.compose.foundation.interaction.Interaction) r4
            r0.L$0 = r7
            r0.L$1 = r8
            r0.label = r3
            java.lang.Object r0 = r2.emit(r4, r0)
            if (r0 != r1) goto L7b
        L7a:
            return r1
        L7b:
            r0 = r7
            r7 = r8
        L7d:
            r8 = r7
            r7 = r0
        L7f:
            r6.dragInteraction = r8
            long r7 = r7.getStartPoint()
            r6.mo509onDragStartedk4lQ0M(r7)
            kotlin.Unit r7 = kotlin.Unit.INSTANCE
            return r7
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.compose.foundation.gestures.DragGestureNode.processDragStart(androidx.compose.foundation.gestures.DragEvent$DragStarted, kotlin.coroutines.Continuation):java.lang.Object");
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Removed duplicated region for block: B:7:0x0014  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final java.lang.Object processDragStop(androidx.compose.foundation.gestures.DragEvent.DragStopped r6, kotlin.coroutines.Continuation<? super kotlin.Unit> r7) {
        /*
            r5 = this;
            boolean r0 = r7 instanceof androidx.compose.foundation.gestures.DragGestureNode.C02911
            if (r0 == 0) goto L14
            r0 = r7
            androidx.compose.foundation.gestures.DragGestureNode$processDragStop$1 r0 = (androidx.compose.foundation.gestures.DragGestureNode.C02911) r0
            int r1 = r0.label
            r2 = -2147483648(0xffffffff80000000, float:-0.0)
            r1 = r1 & r2
            if (r1 == 0) goto L14
            int r7 = r0.label
            int r7 = r7 - r2
            r0.label = r7
            goto L19
        L14:
            androidx.compose.foundation.gestures.DragGestureNode$processDragStop$1 r0 = new androidx.compose.foundation.gestures.DragGestureNode$processDragStop$1
            r0.<init>(r7)
        L19:
            java.lang.Object r7 = r0.result
            java.lang.Object r1 = kotlin.coroutines.intrinsics.IntrinsicsKt.getCOROUTINE_SUSPENDED()
            int r2 = r0.label
            r3 = 1
            if (r2 == 0) goto L36
            if (r2 != r3) goto L2e
            java.lang.Object r6 = r0.L$0
            androidx.compose.foundation.gestures.DragEvent$DragStopped r6 = (androidx.compose.foundation.gestures.DragEvent.DragStopped) r6
            kotlin.ResultKt.throwOnFailure(r7)
            goto L53
        L2e:
            java.lang.IllegalStateException r6 = new java.lang.IllegalStateException
            java.lang.String r7 = "call to 'resume' before 'invoke' with coroutine"
            r6.<init>(r7)
            throw r6
        L36:
            kotlin.ResultKt.throwOnFailure(r7)
            androidx.compose.foundation.interaction.DragInteraction$Start r7 = r5.dragInteraction
            if (r7 == 0) goto L56
            androidx.compose.foundation.interaction.MutableInteractionSource r2 = r5.interactionSource
            if (r2 == 0) goto L53
            androidx.compose.foundation.interaction.DragInteraction$Stop r4 = new androidx.compose.foundation.interaction.DragInteraction$Stop
            r4.<init>(r7)
            androidx.compose.foundation.interaction.Interaction r4 = (androidx.compose.foundation.interaction.Interaction) r4
            r0.L$0 = r6
            r0.label = r3
            java.lang.Object r7 = r2.emit(r4, r0)
            if (r7 != r1) goto L53
            return r1
        L53:
            r7 = 0
            r5.dragInteraction = r7
        L56:
            r5.onDragStopped(r6)
            kotlin.Unit r6 = kotlin.Unit.INSTANCE
            return r6
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.compose.foundation.gestures.DragGestureNode.processDragStop(androidx.compose.foundation.gestures.DragEvent$DragStopped, kotlin.coroutines.Continuation):java.lang.Object");
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Removed duplicated region for block: B:7:0x0014  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final java.lang.Object processDragCancel(kotlin.coroutines.Continuation<? super kotlin.Unit> r7) {
        /*
            r6 = this;
            boolean r0 = r7 instanceof androidx.compose.foundation.gestures.DragGestureNode.AnonymousClass1
            if (r0 == 0) goto L14
            r0 = r7
            androidx.compose.foundation.gestures.DragGestureNode$processDragCancel$1 r0 = (androidx.compose.foundation.gestures.DragGestureNode.AnonymousClass1) r0
            int r1 = r0.label
            r2 = -2147483648(0xffffffff80000000, float:-0.0)
            r1 = r1 & r2
            if (r1 == 0) goto L14
            int r7 = r0.label
            int r7 = r7 - r2
            r0.label = r7
            goto L19
        L14:
            androidx.compose.foundation.gestures.DragGestureNode$processDragCancel$1 r0 = new androidx.compose.foundation.gestures.DragGestureNode$processDragCancel$1
            r0.<init>(r7)
        L19:
            java.lang.Object r7 = r0.result
            java.lang.Object r1 = kotlin.coroutines.intrinsics.IntrinsicsKt.getCOROUTINE_SUSPENDED()
            int r2 = r0.label
            r3 = 0
            r4 = 1
            if (r2 == 0) goto L33
            if (r2 != r4) goto L2b
            kotlin.ResultKt.throwOnFailure(r7)
            goto L4e
        L2b:
            java.lang.IllegalStateException r7 = new java.lang.IllegalStateException
            java.lang.String r0 = "call to 'resume' before 'invoke' with coroutine"
            r7.<init>(r0)
            throw r7
        L33:
            kotlin.ResultKt.throwOnFailure(r7)
            androidx.compose.foundation.interaction.DragInteraction$Start r7 = r6.dragInteraction
            if (r7 == 0) goto L50
            androidx.compose.foundation.interaction.MutableInteractionSource r2 = r6.interactionSource
            if (r2 == 0) goto L4e
            androidx.compose.foundation.interaction.DragInteraction$Cancel r5 = new androidx.compose.foundation.interaction.DragInteraction$Cancel
            r5.<init>(r7)
            androidx.compose.foundation.interaction.Interaction r5 = (androidx.compose.foundation.interaction.Interaction) r5
            r0.label = r4
            java.lang.Object r7 = r2.emit(r5, r0)
            if (r7 != r1) goto L4e
            return r1
        L4e:
            r6.dragInteraction = r3
        L50:
            androidx.compose.foundation.gestures.DragEvent$DragStopped r7 = new androidx.compose.foundation.gestures.DragEvent$DragStopped
            androidx.compose.ui.unit.Velocity$Companion r0 = androidx.compose.ui.unit.Velocity.INSTANCE
            long r0 = r0.m9079getZero9UxMQ8M()
            r2 = 0
            r7.<init>(r0, r2, r3)
            r6.onDragStopped(r7)
            kotlin.Unit r7 = kotlin.Unit.INSTANCE
            return r7
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.compose.foundation.gestures.DragGestureNode.processDragCancel(kotlin.coroutines.Continuation):java.lang.Object");
    }

    public final void disposeInteractionSource() {
        DragInteraction.Start start = this.dragInteraction;
        if (start != null) {
            MutableInteractionSource mutableInteractionSource = this.interactionSource;
            if (mutableInteractionSource != null) {
                mutableInteractionSource.tryEmit(new DragInteraction.Cancel(start));
            }
            this.dragInteraction = null;
        }
    }

    /* JADX WARN: Multi-variable type inference failed */
    public static /* synthetic */ void update$default(DragGestureNode dragGestureNode, Function1 function1, boolean z, MutableInteractionSource mutableInteractionSource, Orientation orientation, boolean z2, int i, Object obj) {
        if (obj != null) {
            throw new UnsupportedOperationException("Super calls with default arguments not supported in this target, function: update");
        }
        if ((i & 1) != 0) {
            function1 = dragGestureNode.canDrag;
        }
        if ((i & 2) != 0) {
            z = dragGestureNode.enabled;
        }
        if ((i & 4) != 0) {
            mutableInteractionSource = dragGestureNode.interactionSource;
        }
        if ((i & 8) != 0) {
            orientation = dragGestureNode.orientationLock;
        }
        if ((i & 16) != 0) {
            z2 = false;
        }
        boolean z3 = z2;
        MutableInteractionSource mutableInteractionSource2 = mutableInteractionSource;
        Function1 function12 = function1;
        dragGestureNode.update(function12, z, mutableInteractionSource2, orientation, z3);
    }

    public final void update(Function1<? super PointerType, Boolean> canDrag, boolean enabled, MutableInteractionSource interactionSource, Orientation orientationLock, boolean shouldResetPointerInputHandling) {
        this.canDrag = canDrag;
        boolean z = true;
        if (this.enabled != enabled) {
            this.enabled = enabled;
            if (!enabled) {
                disposeInteractionSource();
                this.indirectPointerInputDragCycleDetector = null;
            }
            shouldResetPointerInputHandling = true;
        }
        if (!Intrinsics.areEqual(this.interactionSource, interactionSource)) {
            disposeInteractionSource();
            this.interactionSource = interactionSource;
        }
        if (this.orientationLock != orientationLock) {
            this.orientationLock = orientationLock;
        } else {
            z = shouldResetPointerInputHandling;
        }
        if (z) {
            if (this.isListeningForPointerInputEvents) {
                resetDragDetectionState();
            }
            IndirectPointerInputDragCycleDetector indirectPointerInputDragCycleDetector = this.indirectPointerInputDragCycleDetector;
            if (indirectPointerInputDragCycleDetector != null) {
                indirectPointerInputDragCycleDetector.resetDragDetectionState();
            }
        }
    }

    private final void processRawPointerEvent(PointerEvent pointerEvent, PointerEventPass pass) {
        DragDetectionState dragDetectionState = this.currentDragState;
        if (dragDetectionState == null) {
            throw new IllegalArgumentException("currentDragState should not be null".toString());
        }
        if (dragDetectionState instanceof DragDetectionState.AwaitDown) {
            processInitialDownState(pointerEvent, pass, (DragDetectionState.AwaitDown) dragDetectionState);
            return;
        }
        if (dragDetectionState instanceof DragDetectionState.AwaitTouchSlop) {
            processAwaitTouchSlop(pointerEvent, pass, (DragDetectionState.AwaitTouchSlop) dragDetectionState);
        } else if (dragDetectionState instanceof DragDetectionState.AwaitGesturePickup) {
            processAwaitGesturePickup(pointerEvent, pass, (DragDetectionState.AwaitGesturePickup) dragDetectionState);
        } else {
            if (!(dragDetectionState instanceof DragDetectionState.Dragging)) {
                throw new NoWhenBranchMatchedException();
            }
            processDraggingState(pointerEvent, pass, (DragDetectionState.Dragging) dragDetectionState);
        }
    }

    private final void resetDragDetectionState() {
        moveToAwaitDownState();
        if (this.isListeningForEvents) {
            sendDragCancelled();
        }
        this.velocityTracker = null;
    }

    /* JADX INFO: renamed from: moveToAwaitTouchSlopState-aWI9W7U$default, reason: not valid java name */
    static /* synthetic */ void m584moveToAwaitTouchSlopStateaWI9W7U$default(DragGestureNode dragGestureNode, PointerInputChange pointerInputChange, long j, long j2, boolean z, int i, Object obj) {
        if (obj != null) {
            throw new UnsupportedOperationException("Super calls with default arguments not supported in this target, function: moveToAwaitTouchSlopState-aWI9W7U");
        }
        if ((i & 4) != 0) {
            j2 = Offset.INSTANCE.m5739getZeroF1C5BW0();
        }
        long j3 = j2;
        if ((i & 8) != 0) {
            z = false;
        }
        dragGestureNode.m583moveToAwaitTouchSlopStateaWI9W7U(pointerInputChange, j, j3, z);
    }

    /* JADX INFO: renamed from: moveToAwaitTouchSlopState-aWI9W7U, reason: not valid java name */
    private final void m583moveToAwaitTouchSlopStateaWI9W7U(PointerInputChange initialDown, long pointerId, long initialTouchSlopPositionChange, boolean verifyConsumptionInFinalPass) {
        DragDetectionState.AwaitTouchSlop awaitTouchSlopState = getAwaitTouchSlopState();
        awaitTouchSlopState.setInitialDown(initialDown);
        awaitTouchSlopState.m548setPointerId0FcD4WY(pointerId);
        TouchSlopDetector touchSlopDetector = this.touchSlopDetector;
        if (touchSlopDetector == null) {
            this.touchSlopDetector = new TouchSlopDetector(this.orientationLock, 0L, 2, null);
        } else {
            if (touchSlopDetector != null) {
                touchSlopDetector.setOrientation(this.orientationLock);
            }
            TouchSlopDetector touchSlopDetector2 = this.touchSlopDetector;
            if (touchSlopDetector2 != null) {
                touchSlopDetector2.m717resetk4lQ0M(initialTouchSlopPositionChange);
            }
        }
        awaitTouchSlopState.setVerifyConsumptionInFinalPass(verifyConsumptionInFinalPass);
        this.currentDragState = awaitTouchSlopState;
    }

    /* JADX INFO: renamed from: moveToDraggingState-0FcD4WY, reason: not valid java name */
    private final void m585moveToDraggingState0FcD4WY(long pointerId) {
        DragDetectionState.Dragging draggingState = getDraggingState();
        draggingState.m550setPointerId0FcD4WY(pointerId);
        this.currentDragState = draggingState;
    }

    private final void moveToAwaitDownState() {
        DragDetectionState.AwaitDown awaitDownState = getAwaitDownState();
        awaitDownState.setAwaitTouchSlop(DragDetectionState.AwaitDown.AwaitTouchSlop.NotInitialized);
        awaitDownState.setConsumedOnInitial(false);
        this.currentDragState = awaitDownState;
    }

    /* JADX INFO: renamed from: moveToAwaitGesturePickupState-rnUCldI, reason: not valid java name */
    private final void m582moveToAwaitGesturePickupStaternUCldI(PointerInputChange initialDown, long pointerId, TouchSlopDetector touchSlopDetector) {
        DragDetectionState.AwaitGesturePickup awaitGesturePickupState = getAwaitGesturePickupState();
        awaitGesturePickupState.setInitialDown(initialDown);
        awaitGesturePickupState.m546setPointerId0FcD4WY(pointerId);
        TouchSlopDetector.m712resetk4lQ0M$default(touchSlopDetector, 0L, 1, null);
        awaitGesturePickupState.setTouchSlopDetector(touchSlopDetector);
        this.currentDragState = awaitGesturePickupState;
    }

    private final void processInitialDownState(PointerEvent pointerEvent, PointerEventPass pass, DragDetectionState.AwaitDown state) {
        DragDetectionState.AwaitDown.AwaitTouchSlop awaitTouchSlop;
        if (!pointerEvent.getChanges().isEmpty() && TapGestureDetectorKt.isChangedToDown$default(pointerEvent, false, false, 2, null)) {
            PointerInputChange pointerInputChange = (PointerInputChange) CollectionsKt.first((List) pointerEvent.getChanges());
            if (WhenMappings.$EnumSwitchMapping$0[state.getAwaitTouchSlop().ordinal()] == 1) {
                if (!getStartDragImmediately()) {
                    awaitTouchSlop = DragDetectionState.AwaitDown.AwaitTouchSlop.Yes;
                } else {
                    awaitTouchSlop = DragDetectionState.AwaitDown.AwaitTouchSlop.No;
                }
            } else {
                awaitTouchSlop = state.getAwaitTouchSlop();
            }
            state.setAwaitTouchSlop(awaitTouchSlop);
            if (pass == PointerEventPass.Initial && awaitTouchSlop == DragDetectionState.AwaitDown.AwaitTouchSlop.No) {
                pointerInputChange.consume();
                state.setConsumedOnInitial(true);
            }
            if (pass == PointerEventPass.Main) {
                if (awaitTouchSlop == DragDetectionState.AwaitDown.AwaitTouchSlop.Yes) {
                    m584moveToAwaitTouchSlopStateaWI9W7U$default(this, pointerInputChange, pointerInputChange.getId(), 0L, false, 12, null);
                } else if (state.getConsumedOnInitial()) {
                    m587sendDragStart0AR0LA0(pointerInputChange, pointerInputChange, Offset.INSTANCE.m5739getZeroF1C5BW0());
                    m586sendDragEventUv8p0NA(pointerInputChange, Offset.INSTANCE.m5739getZeroF1C5BW0());
                    m585moveToDraggingState0FcD4WY(pointerInputChange.getId());
                }
            }
        }
    }

    private final void processAwaitTouchSlop(PointerEvent pointerEvent, PointerEventPass pass, DragDetectionState.AwaitTouchSlop state) {
        PointerInputChange pointerInputChange;
        PointerInputChange pointerInputChange2;
        PointerInputChange pointerInputChange3;
        if (pass == PointerEventPass.Initial) {
            return;
        }
        List<PointerInputChange> changes = pointerEvent.getChanges();
        int size = changes.size();
        int i = 0;
        while (true) {
            pointerInputChange = null;
            if (i >= size) {
                pointerInputChange2 = null;
                break;
            }
            pointerInputChange2 = changes.get(i);
            if (PointerId.m7291equalsimpl0(pointerInputChange2.getId(), state.getPointerId())) {
                break;
            } else {
                i++;
            }
        }
        PointerInputChange pointerInputChange4 = pointerInputChange2;
        if (pointerInputChange4 == null) {
            List<PointerInputChange> changes2 = pointerEvent.getChanges();
            int size2 = changes2.size();
            int i2 = 0;
            while (true) {
                if (i2 >= size2) {
                    pointerInputChange3 = null;
                    break;
                }
                pointerInputChange3 = changes2.get(i2);
                if (pointerInputChange3.getPressed()) {
                    break;
                } else {
                    i2++;
                }
            }
            pointerInputChange4 = pointerInputChange3;
            if (pointerInputChange4 == null) {
                moveToAwaitDownState();
                return;
            }
            state.m548setPointerId0FcD4WY(pointerInputChange4.getId());
        }
        if (pass == PointerEventPass.Main) {
            if (!pointerInputChange4.isConsumed()) {
                if (PointerEventKt.changedToUpIgnoreConsumed(pointerInputChange4)) {
                    List<PointerInputChange> changes3 = pointerEvent.getChanges();
                    int size3 = changes3.size();
                    int i3 = 0;
                    while (true) {
                        if (i3 >= size3) {
                            break;
                        }
                        PointerInputChange pointerInputChange5 = changes3.get(i3);
                        if (pointerInputChange5.getPressed()) {
                            pointerInputChange = pointerInputChange5;
                            break;
                        }
                        i3++;
                    }
                    PointerInputChange pointerInputChange6 = pointerInputChange;
                    if (pointerInputChange6 == null) {
                        moveToAwaitDownState();
                    } else {
                        state.m548setPointerId0FcD4WY(pointerInputChange6.getId());
                    }
                } else {
                    long jM711getPostSlopOffsetqto3Fdw$default = TouchSlopDetector.m711getPostSlopOffsetqto3Fdw$default(requireTouchSlopDetector(), PointerEventKt.positionChangeIgnoreConsumed(pointerInputChange4), DragGestureDetectorKt.m578pointerSlopE8SPZFQ((ViewConfiguration) CompositionLocalConsumerModifierNodeKt.currentValueOf(this, CompositionLocalsKt.getLocalViewConfiguration()), pointerInputChange4.getType()), false, 4, null);
                    if (ComposeFoundationFlags.isNestedDraggablesTouchConflictFixEnabled) {
                        if ((9223372034707292159L & jM711getPostSlopOffsetqto3Fdw$default) != InlineClassHelperKt.UnspecifiedPackedFloats) {
                            boolean zIsInterested = isInterested(pointerInputChange4);
                            GestureConnection parentGestureConnection = GestureNodeKt.getParentGestureConnection(this);
                            boolean z = parentGestureConnection != null && parentGestureConnection.isInterested(pointerInputChange4);
                            if (!zIsInterested && z) {
                                state.setVerifyConsumptionInFinalPass(true);
                            } else {
                                pointerInputChange4.consume();
                                PointerInputChange initialDown = state.getInitialDown();
                                Intrinsics.checkNotNull(initialDown);
                                m587sendDragStart0AR0LA0(initialDown, pointerInputChange4, jM711getPostSlopOffsetqto3Fdw$default);
                                m586sendDragEventUv8p0NA(pointerInputChange4, jM711getPostSlopOffsetqto3Fdw$default);
                                m585moveToDraggingState0FcD4WY(pointerInputChange4.getId());
                            }
                        } else {
                            state.setVerifyConsumptionInFinalPass(true);
                        }
                    } else if ((9223372034707292159L & jM711getPostSlopOffsetqto3Fdw$default) != InlineClassHelperKt.UnspecifiedPackedFloats) {
                        pointerInputChange4.consume();
                        PointerInputChange initialDown2 = state.getInitialDown();
                        Intrinsics.checkNotNull(initialDown2);
                        m587sendDragStart0AR0LA0(initialDown2, pointerInputChange4, jM711getPostSlopOffsetqto3Fdw$default);
                        m586sendDragEventUv8p0NA(pointerInputChange4, jM711getPostSlopOffsetqto3Fdw$default);
                        m585moveToDraggingState0FcD4WY(pointerInputChange4.getId());
                    } else {
                        state.setVerifyConsumptionInFinalPass(true);
                    }
                }
            } else {
                PointerInputChange initialDown3 = state.getInitialDown();
                if (initialDown3 == null) {
                    throw new IllegalArgumentException("AwaitTouchSlop.initialDown was not initialized".toString());
                }
                long pointerId = state.getPointerId();
                TouchSlopDetector touchSlopDetector = this.touchSlopDetector;
                if (touchSlopDetector != null) {
                    m582moveToAwaitGesturePickupStaternUCldI(initialDown3, pointerId, touchSlopDetector);
                } else {
                    throw new IllegalArgumentException("AwaitTouchSlop.touchSlopDetector was not initialized".toString());
                }
            }
        }
        if (pass == PointerEventPass.Final && state.getVerifyConsumptionInFinalPass()) {
            if (pointerInputChange4.isConsumed()) {
                PointerInputChange initialDown4 = state.getInitialDown();
                if (initialDown4 == null) {
                    throw new IllegalArgumentException("AwaitTouchSlop.initialDown was not initialized".toString());
                }
                long pointerId2 = state.getPointerId();
                TouchSlopDetector touchSlopDetector2 = this.touchSlopDetector;
                if (touchSlopDetector2 != null) {
                    m582moveToAwaitGesturePickupStaternUCldI(initialDown4, pointerId2, touchSlopDetector2);
                    return;
                }
                throw new IllegalArgumentException("AwaitTouchSlop.touchSlopDetector was not initialized".toString());
            }
            state.setVerifyConsumptionInFinalPass(false);
        }
    }

    private final void processAwaitGesturePickup(PointerEvent pointerEvent, PointerEventPass pass, DragDetectionState.AwaitGesturePickup state) {
        boolean z;
        if (pass != PointerEventPass.Final) {
            return;
        }
        List<PointerInputChange> changes = pointerEvent.getChanges();
        int size = changes.size();
        int i = 0;
        int i2 = 0;
        while (true) {
            if (i2 >= size) {
                z = true;
                break;
            } else {
                if (changes.get(i2).isConsumed()) {
                    z = false;
                    break;
                }
                i2++;
            }
        }
        List<PointerInputChange> changes2 = pointerEvent.getChanges();
        int size2 = changes2.size();
        while (true) {
            if (i >= size2) {
                break;
            }
            if (!changes2.get(i).getPressed()) {
                i++;
            } else if (!pointerEvent.getChanges().isEmpty()) {
                if (z) {
                    long position = ((PointerInputChange) CollectionsKt.first((List) pointerEvent.getChanges())).getPosition();
                    PointerInputChange initialDown = state.getInitialDown();
                    Intrinsics.checkNotNull(initialDown);
                    long jM5727minusMKHz9U = Offset.m5727minusMKHz9U(position, initialDown.getPosition());
                    PointerInputChange initialDown2 = state.getInitialDown();
                    if (initialDown2 != null) {
                        m584moveToAwaitTouchSlopStateaWI9W7U$default(this, initialDown2, state.getPointerId(), jM5727minusMKHz9U, false, 8, null);
                        return;
                    }
                    throw new IllegalArgumentException("AwaitGesturePickup.initialDown was not initialized.".toString());
                }
                return;
            }
        }
        moveToAwaitDownState();
    }

    private final void processDraggingState(PointerEvent pointerEvent, PointerEventPass pass, DragDetectionState.Dragging state) {
        PointerInputChange pointerInputChange;
        PointerInputChange pointerInputChange2;
        if (pass != PointerEventPass.Main) {
            return;
        }
        long pointerId = state.getPointerId();
        List<PointerInputChange> changes = pointerEvent.getChanges();
        int size = changes.size();
        int i = 0;
        int i2 = 0;
        while (true) {
            pointerInputChange = null;
            if (i2 >= size) {
                pointerInputChange2 = null;
                break;
            }
            pointerInputChange2 = changes.get(i2);
            if (PointerId.m7291equalsimpl0(pointerInputChange2.getId(), pointerId)) {
                break;
            } else {
                i2++;
            }
        }
        PointerInputChange pointerInputChange3 = pointerInputChange2;
        if (pointerInputChange3 == null) {
            return;
        }
        if (PointerEventKt.changedToUpIgnoreConsumed(pointerInputChange3)) {
            List<PointerInputChange> changes2 = pointerEvent.getChanges();
            int size2 = changes2.size();
            while (true) {
                if (i >= size2) {
                    break;
                }
                PointerInputChange pointerInputChange4 = changes2.get(i);
                if (pointerInputChange4.getPressed()) {
                    pointerInputChange = pointerInputChange4;
                    break;
                }
                i++;
            }
            PointerInputChange pointerInputChange5 = pointerInputChange;
            if (pointerInputChange5 == null) {
                if (!pointerInputChange3.isConsumed() && PointerEventKt.changedToUpIgnoreConsumed(pointerInputChange3)) {
                    sendDragStopped(pointerInputChange3);
                } else {
                    sendDragCancelled();
                }
                moveToAwaitDownState();
                return;
            }
            state.m550setPointerId0FcD4WY(pointerInputChange5.getId());
            return;
        }
        if (pointerInputChange3.isConsumed()) {
            sendDragCancelled();
        } else {
            if (Offset.m5721getDistanceimpl(PointerEventKt.positionChangeIgnoreConsumed(pointerInputChange3)) == 0.0f) {
                return;
            }
            m586sendDragEventUv8p0NA(pointerInputChange3, PointerEventKt.positionChange(pointerInputChange3));
            pointerInputChange3.consume();
        }
    }

    /* JADX INFO: renamed from: sendDragStart-0AR0LA0, reason: not valid java name */
    private final void m587sendDragStart0AR0LA0(PointerInputChange down, PointerInputChange slopTriggerChange, long overSlopOffset) {
        if (this.velocityTracker == null) {
            this.velocityTracker = new VelocityTracker();
        }
        VelocityTrackerKt.addPointerInputChange(requireVelocityTracker(), down);
        long jM5727minusMKHz9U = Offset.m5727minusMKHz9U(slopTriggerChange.getPosition(), overSlopOffset);
        this.nodeOffset = Offset.INSTANCE.m5739getZeroF1C5BW0();
        if (this.canDrag.invoke(PointerType.m7382boximpl(down.getType())).booleanValue()) {
            if (!this.isListeningForEvents) {
                if (this.channel == null) {
                    this.channel = ChannelKt.Channel$default(Integer.MAX_VALUE, null, null, 6, null);
                }
                startListeningForEvents();
            }
            this.previousPositionOnScreen = LayoutCoordinatesKt.positionOnScreen(DelegatableNodeKt.requireLayoutCoordinates(this));
            requireChannel().mo13895trySendJP2dKIU(new DragEvent.DragStarted(jM5727minusMKHz9U, null));
        }
    }

    /* JADX INFO: renamed from: sendDragEvent-Uv8p0NA, reason: not valid java name */
    private final void m586sendDragEventUv8p0NA(PointerInputChange change, long dragAmount) {
        long jPositionOnScreen = LayoutCoordinatesKt.positionOnScreen(DelegatableNodeKt.requireLayoutCoordinates(getNode()));
        if (!Offset.m5720equalsimpl0(this.previousPositionOnScreen, Offset.INSTANCE.m5738getUnspecifiedF1C5BW0()) && !Offset.m5720equalsimpl0(jPositionOnScreen, this.previousPositionOnScreen)) {
            this.nodeOffset = Offset.m5728plusMKHz9U(this.nodeOffset, Offset.m5727minusMKHz9U(jPositionOnScreen, this.previousPositionOnScreen));
        }
        this.previousPositionOnScreen = jPositionOnScreen;
        VelocityTrackerKt.m7421addPointerInputChange0AR0LA0(requireVelocityTracker(), change, this.nodeOffset);
        requireChannel().mo13895trySendJP2dKIU(new DragEvent.DragDelta(dragAmount, false, null));
    }

    private final void sendDragStopped(PointerInputChange change) {
        VelocityTrackerKt.addPointerInputChange(requireVelocityTracker(), change);
        float maximumFlingVelocity = ((ViewConfiguration) CompositionLocalConsumerModifierNodeKt.currentValueOf(this, CompositionLocalsKt.getLocalViewConfiguration())).getMaximumFlingVelocity();
        long jM7420calculateVelocityAH228Gc = requireVelocityTracker().m7420calculateVelocityAH228Gc(VelocityKt.Velocity(maximumFlingVelocity, maximumFlingVelocity));
        requireVelocityTracker().resetTracking();
        requireChannel().mo13895trySendJP2dKIU(new DragEvent.DragStopped(DraggableKt.m592toValidVelocityTH1AsA0(jM7420calculateVelocityAH228Gc), false, null));
        this.isListeningForPointerInputEvents = false;
    }

    private final void sendDragCancelled() {
        requireChannel().mo13895trySendJP2dKIU(DragEvent.DragCancelled.INSTANCE);
    }

    public final void onDragEvent(DragEvent event) {
        if ((event instanceof DragEvent.DragStarted) && !this.isListeningForEvents) {
            this.isListeningForEvents = true;
            startListeningForEvents();
        }
        requireChannel().mo13895trySendJP2dKIU(event);
    }
}
