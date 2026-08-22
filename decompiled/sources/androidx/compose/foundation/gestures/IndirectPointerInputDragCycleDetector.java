package androidx.compose.foundation.gestures;

import androidx.compose.foundation.gestures.DragEvent;
import androidx.compose.ui.geometry.InlineClassHelperKt;
import androidx.compose.ui.geometry.Offset;
import androidx.compose.ui.input.indirect.IndirectPointerEvent;
import androidx.compose.ui.input.indirect.IndirectPointerEventPrimaryDirectionalMotionAxis;
import androidx.compose.ui.input.indirect.IndirectPointerInputChange;
import androidx.compose.ui.input.pointer.PointerEventPass;
import androidx.compose.ui.input.pointer.PointerId;
import androidx.compose.ui.input.pointer.PointerType;
import androidx.compose.ui.input.pointer.util.VelocityTracker;
import androidx.compose.ui.layout.LayoutCoordinatesKt;
import androidx.compose.ui.node.CompositionLocalConsumerModifierNodeKt;
import androidx.compose.ui.node.DelegatableNodeKt;
import androidx.compose.ui.platform.CompositionLocalsKt;
import androidx.compose.ui.platform.ViewConfiguration;
import androidx.compose.ui.unit.VelocityKt;
import java.util.List;
import kotlin.Metadata;
import kotlin.NoWhenBranchMatchedException;
import kotlin.collections.CollectionsKt;
import kotlin.enums.EnumEntries;
import kotlin.enums.EnumEntriesKt;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import org.jivesoftware.smackx.iot.data.element.NodeElement;

/* JADX INFO: compiled from: IndirectPointerInputDragCycleDetector.kt */
/* JADX INFO: loaded from: classes.dex */
@Metadata(d1 = {"\u0000\u008c\u0001\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u0012\n\u0002\u0018\u0002\n\u0002\b\r\b\u0001\u0018\u00002\u00020\u0001:\u0001YB\u000f\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0004\b\u0004\u0010\u0005J\b\u0010*\u001a\u00020$H\u0002J\b\u0010+\u001a\u00020\u001fH\u0002J\u0016\u0010,\u001a\u00020-2\u0006\u0010.\u001a\u00020/2\u0006\u00100\u001a\u000201J\u0006\u00102\u001a\u00020-J3\u00103\u001a\u00020-2\u0006\u00104\u001a\u0002052\u0006\u00106\u001a\u0002072\b\b\u0002\u00108\u001a\u00020!2\b\b\u0002\u00109\u001a\u00020:H\u0002¢\u0006\u0004\b;\u0010<J\u0017\u0010=\u001a\u00020-2\u0006\u00106\u001a\u000207H\u0002¢\u0006\u0004\b>\u0010?J\b\u0010@\u001a\u00020-H\u0002J'\u0010A\u001a\u00020-2\u0006\u00104\u001a\u0002052\u0006\u00106\u001a\u0002072\u0006\u0010#\u001a\u00020$H\u0002¢\u0006\u0004\bB\u0010CJ \u0010D\u001a\u00020-2\u0006\u0010.\u001a\u00020/2\u0006\u00100\u001a\u0002012\u0006\u0010E\u001a\u00020\tH\u0002J \u0010F\u001a\u00020-2\u0006\u0010.\u001a\u00020/2\u0006\u00100\u001a\u0002012\u0006\u0010E\u001a\u00020\u0013H\u0002J \u0010G\u001a\u00020-2\u0006\u0010.\u001a\u00020/2\u0006\u00100\u001a\u0002012\u0006\u0010E\u001a\u00020\u0018H\u0002J \u0010H\u001a\u00020-2\u0006\u0010.\u001a\u00020/2\u0006\u00100\u001a\u0002012\u0006\u0010E\u001a\u00020\u000eH\u0002J1\u0010I\u001a\u00020-2\u0006\u0010J\u001a\u0002052\u0006\u0010K\u001a\u0002052\b\u0010L\u001a\u0004\u0018\u00010M2\u0006\u0010N\u001a\u00020!H\u0002¢\u0006\u0004\bO\u0010PJ)\u0010Q\u001a\u00020-2\u0006\u0010R\u001a\u0002052\b\u0010L\u001a\u0004\u0018\u00010M2\u0006\u0010S\u001a\u00020!H\u0002¢\u0006\u0004\bT\u0010UJ\u001f\u0010V\u001a\u00020-2\u0006\u0010R\u001a\u0002052\b\u0010L\u001a\u0004\u0018\u00010MH\u0002¢\u0006\u0002\bWJ\b\u0010X\u001a\u00020-H\u0002R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0006\u0010\u0007R\u0010\u0010\b\u001a\u0004\u0018\u00010\tX\u0082\u000e¢\u0006\u0002\n\u0000R\u0014\u0010\n\u001a\u00020\t8BX\u0082\u0004¢\u0006\u0006\u001a\u0004\b\u000b\u0010\fR\u0010\u0010\r\u001a\u0004\u0018\u00010\u000eX\u0082\u000e¢\u0006\u0002\n\u0000R\u0014\u0010\u000f\u001a\u00020\u000e8BX\u0082\u0004¢\u0006\u0006\u001a\u0004\b\u0010\u0010\u0011R\u0010\u0010\u0012\u001a\u0004\u0018\u00010\u0013X\u0082\u000e¢\u0006\u0002\n\u0000R\u0014\u0010\u0014\u001a\u00020\u00138BX\u0082\u0004¢\u0006\u0006\u001a\u0004\b\u0015\u0010\u0016R\u0010\u0010\u0017\u001a\u0004\u0018\u00010\u0018X\u0082\u000e¢\u0006\u0002\n\u0000R\u0014\u0010\u0019\u001a\u00020\u00188BX\u0082\u0004¢\u0006\u0006\u001a\u0004\b\u001a\u0010\u001bR\u0010\u0010\u001c\u001a\u0004\u0018\u00010\u001dX\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\u001e\u001a\u0004\u0018\u00010\u001fX\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010 \u001a\u00020!X\u0082\u000e¢\u0006\u0004\n\u0002\u0010\"R\u0010\u0010#\u001a\u0004\u0018\u00010$X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010%\u001a\u00020&X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010'\u001a\u00020(X\u0082\u0004¢\u0006\u0002\n\u0000R\u0010\u0010)\u001a\u00020!X\u0082\u000e¢\u0006\u0004\n\u0002\u0010\"¨\u0006Z"}, d2 = {"Landroidx/compose/foundation/gestures/IndirectPointerInputDragCycleDetector;", "", NodeElement.ELEMENT, "Landroidx/compose/foundation/gestures/DragGestureNode;", "<init>", "(Landroidx/compose/foundation/gestures/DragGestureNode;)V", "getNode", "()Landroidx/compose/foundation/gestures/DragGestureNode;", "_awaitDownState", "Landroidx/compose/foundation/gestures/IndirectPointerInputDragCycleDetector$DragDetectionState$AwaitDown;", "awaitDownState", "getAwaitDownState", "()Landroidx/compose/foundation/gestures/IndirectPointerInputDragCycleDetector$DragDetectionState$AwaitDown;", "_draggingState", "Landroidx/compose/foundation/gestures/IndirectPointerInputDragCycleDetector$DragDetectionState$Dragging;", "draggingState", "getDraggingState", "()Landroidx/compose/foundation/gestures/IndirectPointerInputDragCycleDetector$DragDetectionState$Dragging;", "_awaitTouchSlopState", "Landroidx/compose/foundation/gestures/IndirectPointerInputDragCycleDetector$DragDetectionState$AwaitTouchSlop;", "awaitTouchSlopState", "getAwaitTouchSlopState", "()Landroidx/compose/foundation/gestures/IndirectPointerInputDragCycleDetector$DragDetectionState$AwaitTouchSlop;", "_awaitGesturePickupState", "Landroidx/compose/foundation/gestures/IndirectPointerInputDragCycleDetector$DragDetectionState$AwaitGesturePickup;", "awaitGesturePickupState", "getAwaitGesturePickupState", "()Landroidx/compose/foundation/gestures/IndirectPointerInputDragCycleDetector$DragDetectionState$AwaitGesturePickup;", "currentDragState", "Landroidx/compose/foundation/gestures/IndirectPointerInputDragCycleDetector$DragDetectionState;", "velocityTracker", "Landroidx/compose/ui/input/pointer/util/VelocityTracker;", "previousPositionOnScreen", "Landroidx/compose/ui/geometry/Offset;", "J", "touchSlopDetector", "Landroidx/compose/foundation/gestures/TouchSlopDetector;", "touchSmooth", "Landroidx/compose/foundation/gestures/IndirectPointerInputEventSmoother;", "offsetSmoother", "Landroidx/compose/foundation/gestures/OffsetSmoother;", "nodeOffset", "requireTouchSlopDetector", "requireVelocityTracker", "processIndirectPointerInputEvent", "", "indirectPointerInputEvent", "Landroidx/compose/ui/input/indirect/IndirectPointerEvent;", "pass", "Landroidx/compose/ui/input/pointer/PointerEventPass;", "resetDragDetectionState", "moveToAwaitTouchSlopState", "initialDown", "Landroidx/compose/ui/input/indirect/IndirectPointerInputChange;", "pointerId", "Landroidx/compose/ui/input/pointer/PointerId;", "initialTouchSlopPositionChange", "verifyConsumptionInFinalPass", "", "moveToAwaitTouchSlopState-aWI9W7U", "(Landroidx/compose/ui/input/indirect/IndirectPointerInputChange;JJZ)V", "moveToDraggingState", "moveToDraggingState-0FcD4WY", "(J)V", "moveToAwaitDownState", "moveToAwaitGesturePickupState", "moveToAwaitGesturePickupState-rnUCldI", "(Landroidx/compose/ui/input/indirect/IndirectPointerInputChange;JLandroidx/compose/foundation/gestures/TouchSlopDetector;)V", "processInitialDownState", "state", "processAwaitTouchSlop", "processAwaitGesturePickup", "processDraggingState", "sendDragStart", "down", "slopTriggerChange", "primaryDirectionalMotionAxis", "Landroidx/compose/ui/input/indirect/IndirectPointerEventPrimaryDirectionalMotionAxis;", "overSlopOffset", "sendDragStart-3f7A7Is", "(Landroidx/compose/ui/input/indirect/IndirectPointerInputChange;Landroidx/compose/ui/input/indirect/IndirectPointerInputChange;Landroidx/compose/ui/input/indirect/IndirectPointerEventPrimaryDirectionalMotionAxis;J)V", "sendDragEvent", "change", "dragAmount", "sendDragEvent-Eu1f8Dk", "(Landroidx/compose/ui/input/indirect/IndirectPointerInputChange;Landroidx/compose/ui/input/indirect/IndirectPointerEventPrimaryDirectionalMotionAxis;J)V", "sendDragStopped", "sendDragStopped-k92h6UU", "sendDragCancelled", "DragDetectionState", "foundation"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final class IndirectPointerInputDragCycleDetector {
    public static final int $stable = 8;
    private DragDetectionState.AwaitDown _awaitDownState;
    private DragDetectionState.AwaitGesturePickup _awaitGesturePickupState;
    private DragDetectionState.AwaitTouchSlop _awaitTouchSlopState;
    private DragDetectionState.Dragging _draggingState;
    private DragDetectionState currentDragState;
    private final DragGestureNode node;
    private TouchSlopDetector touchSlopDetector;
    private VelocityTracker velocityTracker;
    private long previousPositionOnScreen = Offset.INSTANCE.m5738getUnspecifiedF1C5BW0();
    private final IndirectPointerInputEventSmoother touchSmooth = new IndirectPointerInputEventSmoother();
    private final OffsetSmoother offsetSmoother = new OffsetSmoother();
    private long nodeOffset = Offset.INSTANCE.m5739getZeroF1C5BW0();

    /* JADX INFO: compiled from: IndirectPointerInputDragCycleDetector.kt */
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

    public IndirectPointerInputDragCycleDetector(DragGestureNode dragGestureNode) {
        this.node = dragGestureNode;
    }

    public final DragGestureNode getNode() {
        return this.node;
    }

    /* JADX WARN: Multi-variable type inference failed */
    private final DragDetectionState.AwaitDown getAwaitDownState() {
        DragDetectionState.AwaitDown awaitDown = this._awaitDownState;
        if (awaitDown != null) {
            return awaitDown;
        }
        DragDetectionState.AwaitDown awaitDown2 = new DragDetectionState.AwaitDown(null, false, 3, 0 == true ? 1 : 0);
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

    private final TouchSlopDetector requireTouchSlopDetector() {
        TouchSlopDetector touchSlopDetector = this.touchSlopDetector;
        if (touchSlopDetector != null) {
            return touchSlopDetector;
        }
        throw new IllegalArgumentException("Touch slop detector not initialized.".toString());
    }

    private final VelocityTracker requireVelocityTracker() {
        VelocityTracker velocityTracker = this.velocityTracker;
        if (velocityTracker != null) {
            return velocityTracker;
        }
        throw new IllegalArgumentException("Velocity Tracker not initialized.".toString());
    }

    public final void processIndirectPointerInputEvent(IndirectPointerEvent indirectPointerInputEvent, PointerEventPass pass) {
        if (this.currentDragState == null) {
            this.currentDragState = getAwaitDownState();
        }
        DragDetectionState dragDetectionState = this.currentDragState;
        if (dragDetectionState == null) {
            throw new IllegalArgumentException("currentDragState should not be null".toString());
        }
        if (dragDetectionState instanceof DragDetectionState.AwaitDown) {
            processInitialDownState(indirectPointerInputEvent, pass, (DragDetectionState.AwaitDown) dragDetectionState);
            return;
        }
        if (dragDetectionState instanceof DragDetectionState.AwaitTouchSlop) {
            processAwaitTouchSlop(indirectPointerInputEvent, pass, (DragDetectionState.AwaitTouchSlop) dragDetectionState);
        } else if (dragDetectionState instanceof DragDetectionState.AwaitGesturePickup) {
            processAwaitGesturePickup(indirectPointerInputEvent, pass, (DragDetectionState.AwaitGesturePickup) dragDetectionState);
        } else {
            if (!(dragDetectionState instanceof DragDetectionState.Dragging)) {
                throw new NoWhenBranchMatchedException();
            }
            processDraggingState(indirectPointerInputEvent, pass, (DragDetectionState.Dragging) dragDetectionState);
        }
    }

    public final void resetDragDetectionState() {
        moveToAwaitDownState();
        if (this.node.getIsListeningForEvents()) {
            sendDragCancelled();
        }
        this.velocityTracker = null;
        this.offsetSmoother.reset();
    }

    /* JADX INFO: renamed from: moveToAwaitTouchSlopState-aWI9W7U$default, reason: not valid java name */
    static /* synthetic */ void m601moveToAwaitTouchSlopStateaWI9W7U$default(IndirectPointerInputDragCycleDetector indirectPointerInputDragCycleDetector, IndirectPointerInputChange indirectPointerInputChange, long j, long j2, boolean z, int i, Object obj) {
        if ((i & 4) != 0) {
            j2 = Offset.INSTANCE.m5739getZeroF1C5BW0();
        }
        long j3 = j2;
        if ((i & 8) != 0) {
            z = false;
        }
        indirectPointerInputDragCycleDetector.m600moveToAwaitTouchSlopStateaWI9W7U(indirectPointerInputChange, j, j3, z);
    }

    /* JADX INFO: renamed from: moveToAwaitTouchSlopState-aWI9W7U, reason: not valid java name */
    private final void m600moveToAwaitTouchSlopStateaWI9W7U(IndirectPointerInputChange initialDown, long pointerId, long initialTouchSlopPositionChange, boolean verifyConsumptionInFinalPass) {
        DragDetectionState.AwaitTouchSlop awaitTouchSlopState = getAwaitTouchSlopState();
        awaitTouchSlopState.setInitialDown(initialDown);
        awaitTouchSlopState.m609setPointerId0FcD4WY(pointerId);
        TouchSlopDetector touchSlopDetector = this.touchSlopDetector;
        if (touchSlopDetector == null) {
            this.touchSlopDetector = new TouchSlopDetector(this.node.getOrientationLock(), 0L, 2, null);
        } else {
            if (touchSlopDetector != null) {
                touchSlopDetector.setOrientation(this.node.getOrientationLock());
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
    private final void m602moveToDraggingState0FcD4WY(long pointerId) {
        DragDetectionState.Dragging draggingState = getDraggingState();
        draggingState.m611setPointerId0FcD4WY(pointerId);
        this.currentDragState = draggingState;
    }

    private final void moveToAwaitDownState() {
        DragDetectionState.AwaitDown awaitDownState = getAwaitDownState();
        awaitDownState.setAwaitTouchSlop(DragDetectionState.AwaitDown.AwaitTouchSlop.NotInitialized);
        awaitDownState.setConsumedOnInitial(false);
        this.currentDragState = awaitDownState;
    }

    /* JADX INFO: renamed from: moveToAwaitGesturePickupState-rnUCldI, reason: not valid java name */
    private final void m599moveToAwaitGesturePickupStaternUCldI(IndirectPointerInputChange initialDown, long pointerId, TouchSlopDetector touchSlopDetector) {
        DragDetectionState.AwaitGesturePickup awaitGesturePickupState = getAwaitGesturePickupState();
        awaitGesturePickupState.setInitialDown(initialDown);
        awaitGesturePickupState.m607setPointerId0FcD4WY(pointerId);
        TouchSlopDetector.m712resetk4lQ0M$default(touchSlopDetector, 0L, 1, null);
        awaitGesturePickupState.setTouchSlopDetector(touchSlopDetector);
        this.currentDragState = awaitGesturePickupState;
    }

    private final void processInitialDownState(IndirectPointerEvent indirectPointerInputEvent, PointerEventPass pass, DragDetectionState.AwaitDown state) {
        DragDetectionState.AwaitDown.AwaitTouchSlop awaitTouchSlop;
        if (!indirectPointerInputEvent.getChanges().isEmpty()) {
            List<IndirectPointerInputChange> changes = indirectPointerInputEvent.getChanges();
            int size = changes.size();
            for (int i = 0; i < size; i++) {
                if (!IndirectPointerInputDragCycleDetectorKt.changedToDownIgnoreConsumed(changes.get(i))) {
                    return;
                }
            }
            IndirectPointerInputChange indirectPointerInputChange = (IndirectPointerInputChange) CollectionsKt.first((List) indirectPointerInputEvent.getChanges());
            if (WhenMappings.$EnumSwitchMapping$0[state.getAwaitTouchSlop().ordinal()] == 1) {
                if (!this.node.getStartDragImmediately()) {
                    awaitTouchSlop = DragDetectionState.AwaitDown.AwaitTouchSlop.Yes;
                } else {
                    awaitTouchSlop = DragDetectionState.AwaitDown.AwaitTouchSlop.No;
                }
            } else {
                awaitTouchSlop = state.getAwaitTouchSlop();
            }
            state.setAwaitTouchSlop(awaitTouchSlop);
            if (pass == PointerEventPass.Initial && awaitTouchSlop == DragDetectionState.AwaitDown.AwaitTouchSlop.No) {
                indirectPointerInputChange.consume();
                state.setConsumedOnInitial(true);
            }
            if (pass == PointerEventPass.Main) {
                if (awaitTouchSlop == DragDetectionState.AwaitDown.AwaitTouchSlop.Yes) {
                    m601moveToAwaitTouchSlopStateaWI9W7U$default(this, indirectPointerInputChange, indirectPointerInputChange.getId(), 0L, false, 12, null);
                } else if (state.getConsumedOnInitial()) {
                    m604sendDragStart3f7A7Is(indirectPointerInputChange, indirectPointerInputChange, IndirectPointerEventPrimaryDirectionalMotionAxis.m6795boximpl(indirectPointerInputEvent.getPrimaryDirectionalMotionAxis()), Offset.INSTANCE.m5739getZeroF1C5BW0());
                    m603sendDragEventEu1f8Dk(indirectPointerInputChange, IndirectPointerEventPrimaryDirectionalMotionAxis.m6795boximpl(indirectPointerInputEvent.getPrimaryDirectionalMotionAxis()), Offset.INSTANCE.m5739getZeroF1C5BW0());
                    m602moveToDraggingState0FcD4WY(indirectPointerInputChange.getId());
                }
            }
        }
    }

    private final void processAwaitTouchSlop(IndirectPointerEvent indirectPointerInputEvent, PointerEventPass pass, DragDetectionState.AwaitTouchSlop state) {
        IndirectPointerInputChange indirectPointerInputChange;
        IndirectPointerInputChange indirectPointerInputChange2;
        IndirectPointerInputChange indirectPointerInputChange3;
        if (pass == PointerEventPass.Initial) {
            return;
        }
        List<IndirectPointerInputChange> changes = indirectPointerInputEvent.getChanges();
        int size = changes.size();
        int i = 0;
        while (true) {
            indirectPointerInputChange = null;
            if (i >= size) {
                indirectPointerInputChange2 = null;
                break;
            }
            indirectPointerInputChange2 = changes.get(i);
            if (PointerId.m7291equalsimpl0(indirectPointerInputChange2.getId(), state.getPointerId())) {
                break;
            } else {
                i++;
            }
        }
        IndirectPointerInputChange indirectPointerInputChange4 = indirectPointerInputChange2;
        if (indirectPointerInputChange4 == null) {
            List<IndirectPointerInputChange> changes2 = indirectPointerInputEvent.getChanges();
            int size2 = changes2.size();
            int i2 = 0;
            while (true) {
                if (i2 >= size2) {
                    indirectPointerInputChange3 = null;
                    break;
                }
                indirectPointerInputChange3 = changes2.get(i2);
                if (indirectPointerInputChange3.getPressed()) {
                    break;
                } else {
                    i2++;
                }
            }
            indirectPointerInputChange4 = indirectPointerInputChange3;
            if (indirectPointerInputChange4 == null) {
                moveToAwaitDownState();
                return;
            }
            state.m609setPointerId0FcD4WY(indirectPointerInputChange4.getId());
        }
        IndirectPointerInputChange indirectPointerInputChange5 = indirectPointerInputChange4;
        if (pass == PointerEventPass.Main) {
            if (!indirectPointerInputChange5.getIsConsumed()) {
                if (IndirectPointerInputDragCycleDetectorKt.changedToUpIgnoreConsumed(indirectPointerInputChange5)) {
                    List<IndirectPointerInputChange> changes3 = indirectPointerInputEvent.getChanges();
                    int size3 = changes3.size();
                    int i3 = 0;
                    while (true) {
                        if (i3 >= size3) {
                            break;
                        }
                        IndirectPointerInputChange indirectPointerInputChange6 = changes3.get(i3);
                        if (indirectPointerInputChange6.getPressed()) {
                            indirectPointerInputChange = indirectPointerInputChange6;
                            break;
                        }
                        i3++;
                    }
                    IndirectPointerInputChange indirectPointerInputChange7 = indirectPointerInputChange;
                    if (indirectPointerInputChange7 == null) {
                        moveToAwaitDownState();
                    } else {
                        state.m609setPointerId0FcD4WY(indirectPointerInputChange7.getId());
                    }
                } else {
                    long jM711getPostSlopOffsetqto3Fdw$default = TouchSlopDetector.m711getPostSlopOffsetqto3Fdw$default(requireTouchSlopDetector(), IndirectPointerInputDragCycleDetectorKt.m618positionChangeIgnoreConsumed_bfSUIo(indirectPointerInputChange5, this.node.getOrientationLock(), IndirectPointerEventPrimaryDirectionalMotionAxis.m6795boximpl(indirectPointerInputEvent.getPrimaryDirectionalMotionAxis())), DragGestureDetectorKt.m578pointerSlopE8SPZFQ((ViewConfiguration) CompositionLocalConsumerModifierNodeKt.currentValueOf(this.node, CompositionLocalsKt.getLocalViewConfiguration()), PointerType.INSTANCE.m7392getTouchT8wyACA()), false, 4, null);
                    if ((9223372034707292159L & jM711getPostSlopOffsetqto3Fdw$default) != InlineClassHelperKt.UnspecifiedPackedFloats) {
                        indirectPointerInputChange5.consume();
                        IndirectPointerInputChange initialDown = state.getInitialDown();
                        Intrinsics.checkNotNull(initialDown);
                        m604sendDragStart3f7A7Is(initialDown, indirectPointerInputChange5, IndirectPointerEventPrimaryDirectionalMotionAxis.m6795boximpl(indirectPointerInputEvent.getPrimaryDirectionalMotionAxis()), jM711getPostSlopOffsetqto3Fdw$default);
                        m603sendDragEventEu1f8Dk(indirectPointerInputChange5, IndirectPointerEventPrimaryDirectionalMotionAxis.m6795boximpl(indirectPointerInputEvent.getPrimaryDirectionalMotionAxis()), jM711getPostSlopOffsetqto3Fdw$default);
                        m602moveToDraggingState0FcD4WY(indirectPointerInputChange5.getId());
                    } else {
                        state.setVerifyConsumptionInFinalPass(true);
                    }
                }
            } else {
                IndirectPointerInputChange initialDown2 = state.getInitialDown();
                if (initialDown2 == null) {
                    throw new IllegalArgumentException("AwaitTouchSlop.initialDown was not initialized".toString());
                }
                long pointerId = state.getPointerId();
                TouchSlopDetector touchSlopDetector = this.touchSlopDetector;
                if (touchSlopDetector != null) {
                    m599moveToAwaitGesturePickupStaternUCldI(initialDown2, pointerId, touchSlopDetector);
                } else {
                    throw new IllegalArgumentException("AwaitTouchSlop.touchSlopDetector was not initialized".toString());
                }
            }
        }
        if (pass == PointerEventPass.Final && state.getVerifyConsumptionInFinalPass()) {
            if (indirectPointerInputChange5.getIsConsumed()) {
                IndirectPointerInputChange initialDown3 = state.getInitialDown();
                if (initialDown3 == null) {
                    throw new IllegalArgumentException("AwaitTouchSlop.initialDown was not initialized".toString());
                }
                long pointerId2 = state.getPointerId();
                TouchSlopDetector touchSlopDetector2 = this.touchSlopDetector;
                if (touchSlopDetector2 != null) {
                    m599moveToAwaitGesturePickupStaternUCldI(initialDown3, pointerId2, touchSlopDetector2);
                    return;
                }
                throw new IllegalArgumentException("AwaitTouchSlop.touchSlopDetector was not initialized".toString());
            }
            state.setVerifyConsumptionInFinalPass(false);
        }
    }

    private final void processAwaitGesturePickup(IndirectPointerEvent indirectPointerInputEvent, PointerEventPass pass, DragDetectionState.AwaitGesturePickup state) {
        boolean z;
        if (pass != PointerEventPass.Final) {
            return;
        }
        List<IndirectPointerInputChange> changes = indirectPointerInputEvent.getChanges();
        int size = changes.size();
        int i = 0;
        int i2 = 0;
        while (true) {
            if (i2 >= size) {
                z = true;
                break;
            } else {
                if (changes.get(i2).getIsConsumed()) {
                    z = false;
                    break;
                }
                i2++;
            }
        }
        List<IndirectPointerInputChange> changes2 = indirectPointerInputEvent.getChanges();
        int size2 = changes2.size();
        while (true) {
            if (i >= size2) {
                break;
            }
            if (!changes2.get(i).getPressed()) {
                i++;
            } else if (!indirectPointerInputEvent.getChanges().isEmpty()) {
                if (z) {
                    long jM621primaryAxisPosition_bfSUIo = IndirectPointerInputDragCycleDetectorKt.m621primaryAxisPosition_bfSUIo((IndirectPointerInputChange) CollectionsKt.first((List) indirectPointerInputEvent.getChanges()), this.node.getOrientationLock(), IndirectPointerEventPrimaryDirectionalMotionAxis.m6795boximpl(indirectPointerInputEvent.getPrimaryDirectionalMotionAxis()));
                    IndirectPointerInputChange initialDown = state.getInitialDown();
                    Intrinsics.checkNotNull(initialDown);
                    long jM5727minusMKHz9U = Offset.m5727minusMKHz9U(jM621primaryAxisPosition_bfSUIo, IndirectPointerInputDragCycleDetectorKt.m621primaryAxisPosition_bfSUIo(initialDown, this.node.getOrientationLock(), IndirectPointerEventPrimaryDirectionalMotionAxis.m6795boximpl(indirectPointerInputEvent.getPrimaryDirectionalMotionAxis())));
                    IndirectPointerInputChange initialDown2 = state.getInitialDown();
                    if (initialDown2 != null) {
                        m601moveToAwaitTouchSlopStateaWI9W7U$default(this, initialDown2, state.getPointerId(), jM5727minusMKHz9U, false, 8, null);
                        return;
                    }
                    throw new IllegalArgumentException("AwaitGesturePickup.initialDown was not initialized.".toString());
                }
                return;
            }
        }
        moveToAwaitDownState();
    }

    private final void processDraggingState(IndirectPointerEvent indirectPointerInputEvent, PointerEventPass pass, DragDetectionState.Dragging state) {
        IndirectPointerInputChange indirectPointerInputChange;
        IndirectPointerInputChange indirectPointerInputChange2;
        if (pass != PointerEventPass.Main) {
            return;
        }
        long pointerId = state.getPointerId();
        List<IndirectPointerInputChange> changes = indirectPointerInputEvent.getChanges();
        int size = changes.size();
        int i = 0;
        int i2 = 0;
        while (true) {
            indirectPointerInputChange = null;
            if (i2 >= size) {
                indirectPointerInputChange2 = null;
                break;
            }
            indirectPointerInputChange2 = changes.get(i2);
            if (PointerId.m7291equalsimpl0(indirectPointerInputChange2.getId(), pointerId)) {
                break;
            } else {
                i2++;
            }
        }
        IndirectPointerInputChange indirectPointerInputChange3 = indirectPointerInputChange2;
        if (indirectPointerInputChange3 == null) {
            return;
        }
        if (IndirectPointerInputDragCycleDetectorKt.changedToUpIgnoreConsumed(indirectPointerInputChange3)) {
            List<IndirectPointerInputChange> changes2 = indirectPointerInputEvent.getChanges();
            int size2 = changes2.size();
            while (true) {
                if (i >= size2) {
                    break;
                }
                IndirectPointerInputChange indirectPointerInputChange4 = changes2.get(i);
                if (indirectPointerInputChange4.getPressed()) {
                    indirectPointerInputChange = indirectPointerInputChange4;
                    break;
                }
                i++;
            }
            IndirectPointerInputChange indirectPointerInputChange5 = indirectPointerInputChange;
            if (indirectPointerInputChange5 == null) {
                if (!indirectPointerInputChange3.getIsConsumed() && IndirectPointerInputDragCycleDetectorKt.changedToUpIgnoreConsumed(indirectPointerInputChange3)) {
                    m605sendDragStoppedk92h6UU(indirectPointerInputChange3, IndirectPointerEventPrimaryDirectionalMotionAxis.m6795boximpl(indirectPointerInputEvent.getPrimaryDirectionalMotionAxis()));
                } else {
                    sendDragCancelled();
                }
                moveToAwaitDownState();
                return;
            }
            state.m611setPointerId0FcD4WY(indirectPointerInputChange5.getId());
            return;
        }
        if (indirectPointerInputChange3.getIsConsumed()) {
            sendDragCancelled();
        } else {
            if (Offset.m5721getDistanceimpl(IndirectPointerInputDragCycleDetectorKt.m618positionChangeIgnoreConsumed_bfSUIo(indirectPointerInputChange3, this.node.getOrientationLock(), IndirectPointerEventPrimaryDirectionalMotionAxis.m6795boximpl(indirectPointerInputEvent.getPrimaryDirectionalMotionAxis()))) == 0.0f) {
                return;
            }
            m603sendDragEventEu1f8Dk(indirectPointerInputChange3, IndirectPointerEventPrimaryDirectionalMotionAxis.m6795boximpl(indirectPointerInputEvent.getPrimaryDirectionalMotionAxis()), IndirectPointerInputDragCycleDetectorKt.m617positionChange_bfSUIo(indirectPointerInputChange3, this.node.getOrientationLock(), IndirectPointerEventPrimaryDirectionalMotionAxis.m6795boximpl(indirectPointerInputEvent.getPrimaryDirectionalMotionAxis())));
            indirectPointerInputChange3.consume();
        }
    }

    /* JADX INFO: renamed from: sendDragStart-3f7A7Is, reason: not valid java name */
    private final void m604sendDragStart3f7A7Is(IndirectPointerInputChange down, IndirectPointerInputChange slopTriggerChange, IndirectPointerEventPrimaryDirectionalMotionAxis primaryDirectionalMotionAxis, long overSlopOffset) {
        if (this.velocityTracker == null) {
            this.velocityTracker = new VelocityTracker();
        }
        this.nodeOffset = Offset.INSTANCE.m5739getZeroF1C5BW0();
        IndirectPointerInputDragCycleDetectorKt.m616addIndirectPointerInputChangeQf4Zb88(requireVelocityTracker(), down, this.node.getOrientationLock(), primaryDirectionalMotionAxis, this.touchSmooth, this.nodeOffset);
        long jM5727minusMKHz9U = Offset.m5727minusMKHz9U(IndirectPointerInputDragCycleDetectorKt.m621primaryAxisPosition_bfSUIo(slopTriggerChange, this.node.getOrientationLock(), primaryDirectionalMotionAxis), overSlopOffset);
        if (this.node.getCanDrag().invoke(PointerType.m7382boximpl(PointerType.INSTANCE.m7392getTouchT8wyACA())).booleanValue()) {
            this.previousPositionOnScreen = LayoutCoordinatesKt.positionOnScreen(DelegatableNodeKt.requireLayoutCoordinates(this.node));
            this.node.onDragEvent(new DragEvent.DragStarted(jM5727minusMKHz9U, null));
        }
        this.offsetSmoother.reset();
    }

    /* JADX INFO: renamed from: sendDragEvent-Eu1f8Dk, reason: not valid java name */
    private final void m603sendDragEventEu1f8Dk(IndirectPointerInputChange change, IndirectPointerEventPrimaryDirectionalMotionAxis primaryDirectionalMotionAxis, long dragAmount) {
        long jPositionOnScreen = LayoutCoordinatesKt.positionOnScreen(DelegatableNodeKt.requireLayoutCoordinates(this.node));
        if (!Offset.m5720equalsimpl0(this.previousPositionOnScreen, Offset.INSTANCE.m5738getUnspecifiedF1C5BW0()) && !Offset.m5720equalsimpl0(jPositionOnScreen, this.previousPositionOnScreen)) {
            this.nodeOffset = Offset.m5728plusMKHz9U(this.nodeOffset, Offset.m5727minusMKHz9U(jPositionOnScreen, this.previousPositionOnScreen));
        }
        this.previousPositionOnScreen = jPositionOnScreen;
        Orientation orientationLock = this.node.getOrientationLock();
        Intrinsics.checkNotNull(orientationLock);
        if (Math.abs(DraggableKt.m590toFloat3MmeM6k(dragAmount, orientationLock)) > 2.0f) {
            IndirectPointerInputDragCycleDetectorKt.m616addIndirectPointerInputChangeQf4Zb88(requireVelocityTracker(), change, this.node.getOrientationLock(), primaryDirectionalMotionAxis, this.touchSmooth, this.nodeOffset);
            this.node.onDragEvent(new DragEvent.DragDelta(this.offsetSmoother.m634smoothEventPositionMKHz9U(dragAmount), true, null));
        }
    }

    /* JADX INFO: renamed from: sendDragStopped-k92h6UU, reason: not valid java name */
    private final void m605sendDragStoppedk92h6UU(IndirectPointerInputChange change, IndirectPointerEventPrimaryDirectionalMotionAxis primaryDirectionalMotionAxis) {
        IndirectPointerInputDragCycleDetectorKt.m616addIndirectPointerInputChangeQf4Zb88(requireVelocityTracker(), change, this.node.getOrientationLock(), primaryDirectionalMotionAxis, this.touchSmooth, this.nodeOffset);
        float maximumFlingVelocity = ((ViewConfiguration) CompositionLocalConsumerModifierNodeKt.currentValueOf(this.node, CompositionLocalsKt.getLocalViewConfiguration())).getMaximumFlingVelocity();
        long jM7420calculateVelocityAH228Gc = requireVelocityTracker().m7420calculateVelocityAH228Gc(VelocityKt.Velocity(maximumFlingVelocity, maximumFlingVelocity));
        requireVelocityTracker().resetTracking();
        this.node.onDragEvent(new DragEvent.DragStopped(DraggableKt.m592toValidVelocityTH1AsA0(jM7420calculateVelocityAH228Gc), true, null));
    }

    private final void sendDragCancelled() {
        this.node.onDragEvent(DragEvent.DragCancelled.INSTANCE);
    }

    /* JADX INFO: compiled from: IndirectPointerInputDragCycleDetector.kt */
    @Metadata(d1 = {"\u0000\u001e\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\b7\u0018\u00002\u00020\u0001:\u0004\u0004\u0005\u0006\u0007B\t\b\u0004¢\u0006\u0004\b\u0002\u0010\u0003\u0082\u0001\u0004\b\t\n\u000b¨\u0006\f"}, d2 = {"Landroidx/compose/foundation/gestures/IndirectPointerInputDragCycleDetector$DragDetectionState;", "", "<init>", "()V", "AwaitDown", "AwaitTouchSlop", "AwaitGesturePickup", "Dragging", "Landroidx/compose/foundation/gestures/IndirectPointerInputDragCycleDetector$DragDetectionState$AwaitDown;", "Landroidx/compose/foundation/gestures/IndirectPointerInputDragCycleDetector$DragDetectionState$AwaitGesturePickup;", "Landroidx/compose/foundation/gestures/IndirectPointerInputDragCycleDetector$DragDetectionState$AwaitTouchSlop;", "Landroidx/compose/foundation/gestures/IndirectPointerInputDragCycleDetector$DragDetectionState$Dragging;", "foundation"}, k = 1, mv = {2, 1, 0}, xi = 48)
    public static abstract class DragDetectionState {
        public static final int $stable = 0;

        public /* synthetic */ DragDetectionState(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        private DragDetectionState() {
        }

        /* JADX INFO: compiled from: IndirectPointerInputDragCycleDetector.kt */
        @Metadata(d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\f\b\u0007\u0018\u00002\u00020\u0001:\u0001\u0010B\u001b\u0012\b\b\u0002\u0010\u0002\u001a\u00020\u0003\u0012\b\b\u0002\u0010\u0004\u001a\u00020\u0005¢\u0006\u0004\b\u0006\u0010\u0007R\u001a\u0010\u0002\u001a\u00020\u0003X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\b\u0010\t\"\u0004\b\n\u0010\u000bR\u001a\u0010\u0004\u001a\u00020\u0005X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\f\u0010\r\"\u0004\b\u000e\u0010\u000f¨\u0006\u0011"}, d2 = {"Landroidx/compose/foundation/gestures/IndirectPointerInputDragCycleDetector$DragDetectionState$AwaitDown;", "Landroidx/compose/foundation/gestures/IndirectPointerInputDragCycleDetector$DragDetectionState;", "awaitTouchSlop", "Landroidx/compose/foundation/gestures/IndirectPointerInputDragCycleDetector$DragDetectionState$AwaitDown$AwaitTouchSlop;", "consumedOnInitial", "", "<init>", "(Landroidx/compose/foundation/gestures/IndirectPointerInputDragCycleDetector$DragDetectionState$AwaitDown$AwaitTouchSlop;Z)V", "getAwaitTouchSlop", "()Landroidx/compose/foundation/gestures/IndirectPointerInputDragCycleDetector$DragDetectionState$AwaitDown$AwaitTouchSlop;", "setAwaitTouchSlop", "(Landroidx/compose/foundation/gestures/IndirectPointerInputDragCycleDetector$DragDetectionState$AwaitDown$AwaitTouchSlop;)V", "getConsumedOnInitial", "()Z", "setConsumedOnInitial", "(Z)V", "AwaitTouchSlop", "foundation"}, k = 1, mv = {2, 1, 0}, xi = 48)
        public static final class AwaitDown extends DragDetectionState {
            public static final int $stable = 8;
            private AwaitTouchSlop awaitTouchSlop;
            private boolean consumedOnInitial;

            /* JADX WARN: Multi-variable type inference failed */
            public AwaitDown() {
                this(null, false, 3, 0 == true ? 1 : 0);
            }

            public AwaitDown(AwaitTouchSlop awaitTouchSlop, boolean z) {
                super(null);
                this.awaitTouchSlop = awaitTouchSlop;
                this.consumedOnInitial = z;
            }

            public /* synthetic */ AwaitDown(AwaitTouchSlop awaitTouchSlop, boolean z, int i, DefaultConstructorMarker defaultConstructorMarker) {
                this((i & 1) != 0 ? AwaitTouchSlop.NotInitialized : awaitTouchSlop, (i & 2) != 0 ? false : z);
            }

            public final AwaitTouchSlop getAwaitTouchSlop() {
                return this.awaitTouchSlop;
            }

            public final void setAwaitTouchSlop(AwaitTouchSlop awaitTouchSlop) {
                this.awaitTouchSlop = awaitTouchSlop;
            }

            public final boolean getConsumedOnInitial() {
                return this.consumedOnInitial;
            }

            public final void setConsumedOnInitial(boolean z) {
                this.consumedOnInitial = z;
            }

            /* JADX WARN: Failed to restore enum class, 'enum' modifier and super class removed */
            /* JADX WARN: Unknown enum class pattern. Please report as an issue! */
            /* JADX INFO: compiled from: IndirectPointerInputDragCycleDetector.kt */
            @Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\b\u0006\b\u0086\u0081\u0002\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003j\u0002\b\u0004j\u0002\b\u0005j\u0002\b\u0006¨\u0006\u0007"}, d2 = {"Landroidx/compose/foundation/gestures/IndirectPointerInputDragCycleDetector$DragDetectionState$AwaitDown$AwaitTouchSlop;", "", "<init>", "(Ljava/lang/String;I)V", "Yes", "No", "NotInitialized", "foundation"}, k = 1, mv = {2, 1, 0}, xi = 48)
            public static final class AwaitTouchSlop {
                private static final /* synthetic */ EnumEntries $ENTRIES;
                private static final /* synthetic */ AwaitTouchSlop[] $VALUES;
                public static final AwaitTouchSlop Yes = new AwaitTouchSlop("Yes", 0);
                public static final AwaitTouchSlop No = new AwaitTouchSlop("No", 1);
                public static final AwaitTouchSlop NotInitialized = new AwaitTouchSlop("NotInitialized", 2);

                private static final /* synthetic */ AwaitTouchSlop[] $values() {
                    return new AwaitTouchSlop[]{Yes, No, NotInitialized};
                }

                public static EnumEntries<AwaitTouchSlop> getEntries() {
                    return $ENTRIES;
                }

                public static AwaitTouchSlop valueOf(String str) {
                    return (AwaitTouchSlop) Enum.valueOf(AwaitTouchSlop.class, str);
                }

                public static AwaitTouchSlop[] values() {
                    return (AwaitTouchSlop[]) $VALUES.clone();
                }

                private AwaitTouchSlop(String str, int i) {
                }

                static {
                    AwaitTouchSlop[] awaitTouchSlopArr$values = $values();
                    $VALUES = awaitTouchSlopArr$values;
                    $ENTRIES = EnumEntriesKt.enumEntries(awaitTouchSlopArr$values);
                }
            }
        }

        /* JADX INFO: compiled from: IndirectPointerInputDragCycleDetector.kt */
        @Metadata(d1 = {"\u0000\u001e\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0010\b\u0007\u0018\u00002\u00020\u0001B'\u0012\n\b\u0002\u0010\u0002\u001a\u0004\u0018\u00010\u0003\u0012\b\b\u0002\u0010\u0004\u001a\u00020\u0005\u0012\b\b\u0002\u0010\u0006\u001a\u00020\u0007¢\u0006\u0004\b\b\u0010\tR\u001c\u0010\u0002\u001a\u0004\u0018\u00010\u0003X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\n\u0010\u000b\"\u0004\b\f\u0010\rR\u001c\u0010\u0004\u001a\u00020\u0005X\u0086\u000e¢\u0006\u0010\n\u0002\u0010\u0012\u001a\u0004\b\u000e\u0010\u000f\"\u0004\b\u0010\u0010\u0011R\u001a\u0010\u0006\u001a\u00020\u0007X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0013\u0010\u0014\"\u0004\b\u0015\u0010\u0016¨\u0006\u0017"}, d2 = {"Landroidx/compose/foundation/gestures/IndirectPointerInputDragCycleDetector$DragDetectionState$AwaitTouchSlop;", "Landroidx/compose/foundation/gestures/IndirectPointerInputDragCycleDetector$DragDetectionState;", "initialDown", "Landroidx/compose/ui/input/indirect/IndirectPointerInputChange;", "pointerId", "Landroidx/compose/ui/input/pointer/PointerId;", "verifyConsumptionInFinalPass", "", "<init>", "(Landroidx/compose/ui/input/indirect/IndirectPointerInputChange;JZLkotlin/jvm/internal/DefaultConstructorMarker;)V", "getInitialDown", "()Landroidx/compose/ui/input/indirect/IndirectPointerInputChange;", "setInitialDown", "(Landroidx/compose/ui/input/indirect/IndirectPointerInputChange;)V", "getPointerId-J3iCeTQ", "()J", "setPointerId-0FcD4WY", "(J)V", "J", "getVerifyConsumptionInFinalPass", "()Z", "setVerifyConsumptionInFinalPass", "(Z)V", "foundation"}, k = 1, mv = {2, 1, 0}, xi = 48)
        public static final class AwaitTouchSlop extends DragDetectionState {
            public static final int $stable = 8;
            private IndirectPointerInputChange initialDown;
            private long pointerId;
            private boolean verifyConsumptionInFinalPass;

            public /* synthetic */ AwaitTouchSlop(IndirectPointerInputChange indirectPointerInputChange, long j, boolean z, DefaultConstructorMarker defaultConstructorMarker) {
                this(indirectPointerInputChange, j, z);
            }

            private AwaitTouchSlop(IndirectPointerInputChange indirectPointerInputChange, long j, boolean z) {
                super(null);
                this.initialDown = indirectPointerInputChange;
                this.pointerId = j;
                this.verifyConsumptionInFinalPass = z;
            }

            public final IndirectPointerInputChange getInitialDown() {
                return this.initialDown;
            }

            public final void setInitialDown(IndirectPointerInputChange indirectPointerInputChange) {
                this.initialDown = indirectPointerInputChange;
            }

            public /* synthetic */ AwaitTouchSlop(IndirectPointerInputChange indirectPointerInputChange, long j, boolean z, int i, DefaultConstructorMarker defaultConstructorMarker) {
                this((i & 1) != 0 ? null : indirectPointerInputChange, (i & 2) != 0 ? PointerId.m7289constructorimpl(Long.MAX_VALUE) : j, (i & 4) != 0 ? false : z, null);
            }

            /* JADX INFO: renamed from: getPointerId-J3iCeTQ, reason: not valid java name and from getter */
            public final long getPointerId() {
                return this.pointerId;
            }

            /* JADX INFO: renamed from: setPointerId-0FcD4WY, reason: not valid java name */
            public final void m609setPointerId0FcD4WY(long j) {
                this.pointerId = j;
            }

            public final boolean getVerifyConsumptionInFinalPass() {
                return this.verifyConsumptionInFinalPass;
            }

            public final void setVerifyConsumptionInFinalPass(boolean z) {
                this.verifyConsumptionInFinalPass = z;
            }
        }

        /* JADX INFO: compiled from: IndirectPointerInputDragCycleDetector.kt */
        @Metadata(d1 = {"\u0000\u001e\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0010\b\u0007\u0018\u00002\u00020\u0001B)\u0012\n\b\u0002\u0010\u0002\u001a\u0004\u0018\u00010\u0003\u0012\b\b\u0002\u0010\u0004\u001a\u00020\u0005\u0012\n\b\u0002\u0010\u0006\u001a\u0004\u0018\u00010\u0007¢\u0006\u0004\b\b\u0010\tR\u001c\u0010\u0002\u001a\u0004\u0018\u00010\u0003X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\n\u0010\u000b\"\u0004\b\f\u0010\rR\u001c\u0010\u0004\u001a\u00020\u0005X\u0086\u000e¢\u0006\u0010\n\u0002\u0010\u0012\u001a\u0004\b\u000e\u0010\u000f\"\u0004\b\u0010\u0010\u0011R\u001c\u0010\u0006\u001a\u0004\u0018\u00010\u0007X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0013\u0010\u0014\"\u0004\b\u0015\u0010\u0016¨\u0006\u0017"}, d2 = {"Landroidx/compose/foundation/gestures/IndirectPointerInputDragCycleDetector$DragDetectionState$AwaitGesturePickup;", "Landroidx/compose/foundation/gestures/IndirectPointerInputDragCycleDetector$DragDetectionState;", "initialDown", "Landroidx/compose/ui/input/indirect/IndirectPointerInputChange;", "pointerId", "Landroidx/compose/ui/input/pointer/PointerId;", "touchSlopDetector", "Landroidx/compose/foundation/gestures/TouchSlopDetector;", "<init>", "(Landroidx/compose/ui/input/indirect/IndirectPointerInputChange;JLandroidx/compose/foundation/gestures/TouchSlopDetector;Lkotlin/jvm/internal/DefaultConstructorMarker;)V", "getInitialDown", "()Landroidx/compose/ui/input/indirect/IndirectPointerInputChange;", "setInitialDown", "(Landroidx/compose/ui/input/indirect/IndirectPointerInputChange;)V", "getPointerId-J3iCeTQ", "()J", "setPointerId-0FcD4WY", "(J)V", "J", "getTouchSlopDetector", "()Landroidx/compose/foundation/gestures/TouchSlopDetector;", "setTouchSlopDetector", "(Landroidx/compose/foundation/gestures/TouchSlopDetector;)V", "foundation"}, k = 1, mv = {2, 1, 0}, xi = 48)
        public static final class AwaitGesturePickup extends DragDetectionState {
            public static final int $stable = 8;
            private IndirectPointerInputChange initialDown;
            private long pointerId;
            private TouchSlopDetector touchSlopDetector;

            public /* synthetic */ AwaitGesturePickup(IndirectPointerInputChange indirectPointerInputChange, long j, TouchSlopDetector touchSlopDetector, DefaultConstructorMarker defaultConstructorMarker) {
                this(indirectPointerInputChange, j, touchSlopDetector);
            }

            private AwaitGesturePickup(IndirectPointerInputChange indirectPointerInputChange, long j, TouchSlopDetector touchSlopDetector) {
                super(null);
                this.initialDown = indirectPointerInputChange;
                this.pointerId = j;
                this.touchSlopDetector = touchSlopDetector;
            }

            public final IndirectPointerInputChange getInitialDown() {
                return this.initialDown;
            }

            public final void setInitialDown(IndirectPointerInputChange indirectPointerInputChange) {
                this.initialDown = indirectPointerInputChange;
            }

            public /* synthetic */ AwaitGesturePickup(IndirectPointerInputChange indirectPointerInputChange, long j, TouchSlopDetector touchSlopDetector, int i, DefaultConstructorMarker defaultConstructorMarker) {
                this((i & 1) != 0 ? null : indirectPointerInputChange, (i & 2) != 0 ? PointerId.m7289constructorimpl(Long.MAX_VALUE) : j, (i & 4) != 0 ? null : touchSlopDetector, null);
            }

            /* JADX INFO: renamed from: getPointerId-J3iCeTQ, reason: not valid java name and from getter */
            public final long getPointerId() {
                return this.pointerId;
            }

            /* JADX INFO: renamed from: setPointerId-0FcD4WY, reason: not valid java name */
            public final void m607setPointerId0FcD4WY(long j) {
                this.pointerId = j;
            }

            public final TouchSlopDetector getTouchSlopDetector() {
                return this.touchSlopDetector;
            }

            public final void setTouchSlopDetector(TouchSlopDetector touchSlopDetector) {
                this.touchSlopDetector = touchSlopDetector;
            }
        }

        /* JADX INFO: compiled from: IndirectPointerInputDragCycleDetector.kt */
        @Metadata(d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\b\b\u0007\u0018\u00002\u00020\u0001B\u0011\u0012\b\b\u0002\u0010\u0002\u001a\u00020\u0003¢\u0006\u0004\b\u0004\u0010\u0005R\u001c\u0010\u0002\u001a\u00020\u0003X\u0086\u000e¢\u0006\u0010\n\u0002\u0010\n\u001a\u0004\b\u0006\u0010\u0007\"\u0004\b\b\u0010\t¨\u0006\u000b"}, d2 = {"Landroidx/compose/foundation/gestures/IndirectPointerInputDragCycleDetector$DragDetectionState$Dragging;", "Landroidx/compose/foundation/gestures/IndirectPointerInputDragCycleDetector$DragDetectionState;", "pointerId", "Landroidx/compose/ui/input/pointer/PointerId;", "<init>", "(JLkotlin/jvm/internal/DefaultConstructorMarker;)V", "getPointerId-J3iCeTQ", "()J", "setPointerId-0FcD4WY", "(J)V", "J", "foundation"}, k = 1, mv = {2, 1, 0}, xi = 48)
        public static final class Dragging extends DragDetectionState {
            public static final int $stable = 8;
            private long pointerId;

            public /* synthetic */ Dragging(long j, DefaultConstructorMarker defaultConstructorMarker) {
                this(j);
            }

            private Dragging(long j) {
                super(null);
                this.pointerId = j;
            }

            public /* synthetic */ Dragging(long j, int i, DefaultConstructorMarker defaultConstructorMarker) {
                this((i & 1) != 0 ? PointerId.m7289constructorimpl(Long.MAX_VALUE) : j, null);
            }

            /* JADX INFO: renamed from: getPointerId-J3iCeTQ, reason: not valid java name and from getter */
            public final long getPointerId() {
                return this.pointerId;
            }

            /* JADX INFO: renamed from: setPointerId-0FcD4WY, reason: not valid java name */
            public final void m611setPointerId0FcD4WY(long j) {
                this.pointerId = j;
            }
        }
    }
}
