package androidx.compose.foundation.gestures;

import androidx.compose.ui.input.pointer.PointerId;
import androidx.compose.ui.input.pointer.PointerInputChange;
import kotlin.Metadata;
import kotlin.enums.EnumEntries;
import kotlin.enums.EnumEntriesKt;
import kotlin.jvm.internal.DefaultConstructorMarker;

/* JADX INFO: compiled from: Draggable.kt */
/* JADX INFO: loaded from: classes.dex */
@Metadata(d1 = {"\u0000\u001e\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\b2\u0018\u00002\u00020\u0001:\u0004\u0004\u0005\u0006\u0007B\t\b\u0004¢\u0006\u0004\b\u0002\u0010\u0003\u0082\u0001\u0004\b\t\n\u000b¨\u0006\f"}, d2 = {"Landroidx/compose/foundation/gestures/DragDetectionState;", "", "<init>", "()V", "AwaitDown", "AwaitTouchSlop", "AwaitGesturePickup", "Dragging", "Landroidx/compose/foundation/gestures/DragDetectionState$AwaitDown;", "Landroidx/compose/foundation/gestures/DragDetectionState$AwaitGesturePickup;", "Landroidx/compose/foundation/gestures/DragDetectionState$AwaitTouchSlop;", "Landroidx/compose/foundation/gestures/DragDetectionState$Dragging;", "foundation"}, k = 1, mv = {2, 1, 0}, xi = 48)
abstract class DragDetectionState {
    public /* synthetic */ DragDetectionState(DefaultConstructorMarker defaultConstructorMarker) {
        this();
    }

    private DragDetectionState() {
    }

    /* JADX INFO: compiled from: Draggable.kt */
    @Metadata(d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\f\b\u0007\u0018\u00002\u00020\u0001:\u0001\u0010B\u001b\u0012\b\b\u0002\u0010\u0002\u001a\u00020\u0003\u0012\b\b\u0002\u0010\u0004\u001a\u00020\u0005¢\u0006\u0004\b\u0006\u0010\u0007R\u001a\u0010\u0002\u001a\u00020\u0003X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\b\u0010\t\"\u0004\b\n\u0010\u000bR\u001a\u0010\u0004\u001a\u00020\u0005X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\f\u0010\r\"\u0004\b\u000e\u0010\u000f¨\u0006\u0011"}, d2 = {"Landroidx/compose/foundation/gestures/DragDetectionState$AwaitDown;", "Landroidx/compose/foundation/gestures/DragDetectionState;", "awaitTouchSlop", "Landroidx/compose/foundation/gestures/DragDetectionState$AwaitDown$AwaitTouchSlop;", "consumedOnInitial", "", "<init>", "(Landroidx/compose/foundation/gestures/DragDetectionState$AwaitDown$AwaitTouchSlop;Z)V", "getAwaitTouchSlop", "()Landroidx/compose/foundation/gestures/DragDetectionState$AwaitDown$AwaitTouchSlop;", "setAwaitTouchSlop", "(Landroidx/compose/foundation/gestures/DragDetectionState$AwaitDown$AwaitTouchSlop;)V", "getConsumedOnInitial", "()Z", "setConsumedOnInitial", "(Z)V", "AwaitTouchSlop", "foundation"}, k = 1, mv = {2, 1, 0}, xi = 48)
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
        /* JADX INFO: compiled from: Draggable.kt */
        @Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\b\u0006\b\u0086\u0081\u0002\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003j\u0002\b\u0004j\u0002\b\u0005j\u0002\b\u0006¨\u0006\u0007"}, d2 = {"Landroidx/compose/foundation/gestures/DragDetectionState$AwaitDown$AwaitTouchSlop;", "", "<init>", "(Ljava/lang/String;I)V", "Yes", "No", "NotInitialized", "foundation"}, k = 1, mv = {2, 1, 0}, xi = 48)
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

    /* JADX INFO: compiled from: Draggable.kt */
    @Metadata(d1 = {"\u0000\u001e\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0010\b\u0007\u0018\u00002\u00020\u0001B'\u0012\n\b\u0002\u0010\u0002\u001a\u0004\u0018\u00010\u0003\u0012\b\b\u0002\u0010\u0004\u001a\u00020\u0005\u0012\b\b\u0002\u0010\u0006\u001a\u00020\u0007¢\u0006\u0004\b\b\u0010\tR\u001c\u0010\u0002\u001a\u0004\u0018\u00010\u0003X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\n\u0010\u000b\"\u0004\b\f\u0010\rR\u001c\u0010\u0004\u001a\u00020\u0005X\u0086\u000e¢\u0006\u0010\n\u0002\u0010\u0012\u001a\u0004\b\u000e\u0010\u000f\"\u0004\b\u0010\u0010\u0011R\u001a\u0010\u0006\u001a\u00020\u0007X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0013\u0010\u0014\"\u0004\b\u0015\u0010\u0016¨\u0006\u0017"}, d2 = {"Landroidx/compose/foundation/gestures/DragDetectionState$AwaitTouchSlop;", "Landroidx/compose/foundation/gestures/DragDetectionState;", "initialDown", "Landroidx/compose/ui/input/pointer/PointerInputChange;", "pointerId", "Landroidx/compose/ui/input/pointer/PointerId;", "verifyConsumptionInFinalPass", "", "<init>", "(Landroidx/compose/ui/input/pointer/PointerInputChange;JZLkotlin/jvm/internal/DefaultConstructorMarker;)V", "getInitialDown", "()Landroidx/compose/ui/input/pointer/PointerInputChange;", "setInitialDown", "(Landroidx/compose/ui/input/pointer/PointerInputChange;)V", "getPointerId-J3iCeTQ", "()J", "setPointerId-0FcD4WY", "(J)V", "J", "getVerifyConsumptionInFinalPass", "()Z", "setVerifyConsumptionInFinalPass", "(Z)V", "foundation"}, k = 1, mv = {2, 1, 0}, xi = 48)
    public static final class AwaitTouchSlop extends DragDetectionState {
        public static final int $stable = 8;
        private PointerInputChange initialDown;
        private long pointerId;
        private boolean verifyConsumptionInFinalPass;

        public /* synthetic */ AwaitTouchSlop(PointerInputChange pointerInputChange, long j, boolean z, DefaultConstructorMarker defaultConstructorMarker) {
            this(pointerInputChange, j, z);
        }

        private AwaitTouchSlop(PointerInputChange pointerInputChange, long j, boolean z) {
            super(null);
            this.initialDown = pointerInputChange;
            this.pointerId = j;
            this.verifyConsumptionInFinalPass = z;
        }

        public final PointerInputChange getInitialDown() {
            return this.initialDown;
        }

        public final void setInitialDown(PointerInputChange pointerInputChange) {
            this.initialDown = pointerInputChange;
        }

        public /* synthetic */ AwaitTouchSlop(PointerInputChange pointerInputChange, long j, boolean z, int i, DefaultConstructorMarker defaultConstructorMarker) {
            this((i & 1) != 0 ? null : pointerInputChange, (i & 2) != 0 ? PointerId.m7289constructorimpl(Long.MAX_VALUE) : j, (i & 4) != 0 ? false : z, null);
        }

        /* JADX INFO: renamed from: getPointerId-J3iCeTQ, reason: not valid java name and from getter */
        public final long getPointerId() {
            return this.pointerId;
        }

        /* JADX INFO: renamed from: setPointerId-0FcD4WY, reason: not valid java name */
        public final void m548setPointerId0FcD4WY(long j) {
            this.pointerId = j;
        }

        public final boolean getVerifyConsumptionInFinalPass() {
            return this.verifyConsumptionInFinalPass;
        }

        public final void setVerifyConsumptionInFinalPass(boolean z) {
            this.verifyConsumptionInFinalPass = z;
        }
    }

    /* JADX INFO: compiled from: Draggable.kt */
    @Metadata(d1 = {"\u0000\u001e\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0010\b\u0007\u0018\u00002\u00020\u0001B)\u0012\n\b\u0002\u0010\u0002\u001a\u0004\u0018\u00010\u0003\u0012\b\b\u0002\u0010\u0004\u001a\u00020\u0005\u0012\n\b\u0002\u0010\u0006\u001a\u0004\u0018\u00010\u0007¢\u0006\u0004\b\b\u0010\tR\u001c\u0010\u0002\u001a\u0004\u0018\u00010\u0003X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\n\u0010\u000b\"\u0004\b\f\u0010\rR\u001c\u0010\u0004\u001a\u00020\u0005X\u0086\u000e¢\u0006\u0010\n\u0002\u0010\u0012\u001a\u0004\b\u000e\u0010\u000f\"\u0004\b\u0010\u0010\u0011R\u001c\u0010\u0006\u001a\u0004\u0018\u00010\u0007X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0013\u0010\u0014\"\u0004\b\u0015\u0010\u0016¨\u0006\u0017"}, d2 = {"Landroidx/compose/foundation/gestures/DragDetectionState$AwaitGesturePickup;", "Landroidx/compose/foundation/gestures/DragDetectionState;", "initialDown", "Landroidx/compose/ui/input/pointer/PointerInputChange;", "pointerId", "Landroidx/compose/ui/input/pointer/PointerId;", "touchSlopDetector", "Landroidx/compose/foundation/gestures/TouchSlopDetector;", "<init>", "(Landroidx/compose/ui/input/pointer/PointerInputChange;JLandroidx/compose/foundation/gestures/TouchSlopDetector;Lkotlin/jvm/internal/DefaultConstructorMarker;)V", "getInitialDown", "()Landroidx/compose/ui/input/pointer/PointerInputChange;", "setInitialDown", "(Landroidx/compose/ui/input/pointer/PointerInputChange;)V", "getPointerId-J3iCeTQ", "()J", "setPointerId-0FcD4WY", "(J)V", "J", "getTouchSlopDetector", "()Landroidx/compose/foundation/gestures/TouchSlopDetector;", "setTouchSlopDetector", "(Landroidx/compose/foundation/gestures/TouchSlopDetector;)V", "foundation"}, k = 1, mv = {2, 1, 0}, xi = 48)
    public static final class AwaitGesturePickup extends DragDetectionState {
        public static final int $stable = 8;
        private PointerInputChange initialDown;
        private long pointerId;
        private TouchSlopDetector touchSlopDetector;

        public /* synthetic */ AwaitGesturePickup(PointerInputChange pointerInputChange, long j, TouchSlopDetector touchSlopDetector, DefaultConstructorMarker defaultConstructorMarker) {
            this(pointerInputChange, j, touchSlopDetector);
        }

        private AwaitGesturePickup(PointerInputChange pointerInputChange, long j, TouchSlopDetector touchSlopDetector) {
            super(null);
            this.initialDown = pointerInputChange;
            this.pointerId = j;
            this.touchSlopDetector = touchSlopDetector;
        }

        public final PointerInputChange getInitialDown() {
            return this.initialDown;
        }

        public final void setInitialDown(PointerInputChange pointerInputChange) {
            this.initialDown = pointerInputChange;
        }

        public /* synthetic */ AwaitGesturePickup(PointerInputChange pointerInputChange, long j, TouchSlopDetector touchSlopDetector, int i, DefaultConstructorMarker defaultConstructorMarker) {
            this((i & 1) != 0 ? null : pointerInputChange, (i & 2) != 0 ? PointerId.m7289constructorimpl(Long.MAX_VALUE) : j, (i & 4) != 0 ? null : touchSlopDetector, null);
        }

        /* JADX INFO: renamed from: getPointerId-J3iCeTQ, reason: not valid java name and from getter */
        public final long getPointerId() {
            return this.pointerId;
        }

        /* JADX INFO: renamed from: setPointerId-0FcD4WY, reason: not valid java name */
        public final void m546setPointerId0FcD4WY(long j) {
            this.pointerId = j;
        }

        public final TouchSlopDetector getTouchSlopDetector() {
            return this.touchSlopDetector;
        }

        public final void setTouchSlopDetector(TouchSlopDetector touchSlopDetector) {
            this.touchSlopDetector = touchSlopDetector;
        }
    }

    /* JADX INFO: compiled from: Draggable.kt */
    @Metadata(d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\b\b\u0007\u0018\u00002\u00020\u0001B\u0011\u0012\b\b\u0002\u0010\u0002\u001a\u00020\u0003¢\u0006\u0004\b\u0004\u0010\u0005R\u001c\u0010\u0002\u001a\u00020\u0003X\u0086\u000e¢\u0006\u0010\n\u0002\u0010\n\u001a\u0004\b\u0006\u0010\u0007\"\u0004\b\b\u0010\t¨\u0006\u000b"}, d2 = {"Landroidx/compose/foundation/gestures/DragDetectionState$Dragging;", "Landroidx/compose/foundation/gestures/DragDetectionState;", "pointerId", "Landroidx/compose/ui/input/pointer/PointerId;", "<init>", "(JLkotlin/jvm/internal/DefaultConstructorMarker;)V", "getPointerId-J3iCeTQ", "()J", "setPointerId-0FcD4WY", "(J)V", "J", "foundation"}, k = 1, mv = {2, 1, 0}, xi = 48)
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
        public final void m550setPointerId0FcD4WY(long j) {
            this.pointerId = j;
        }
    }
}
