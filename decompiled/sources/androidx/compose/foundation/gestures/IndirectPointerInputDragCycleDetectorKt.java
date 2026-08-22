package androidx.compose.foundation.gestures;

import androidx.compose.ui.geometry.Offset;
import androidx.compose.ui.input.indirect.IndirectPointerEventPrimaryDirectionalMotionAxis;
import androidx.compose.ui.input.indirect.IndirectPointerInputChange;
import androidx.compose.ui.input.pointer.util.VelocityTracker;
import com.clevertap.android.sdk.Constants;
import kotlin.Metadata;

/* JADX INFO: compiled from: IndirectPointerInputDragCycleDetector.kt */
/* JADX INFO: loaded from: classes.dex */
@Metadata(d1 = {"\u0000>\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u000b\n\u0002\b\r\n\u0002\u0010\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\b\n\u0002\b\u0002\u001a'\u0010\u0000\u001a\u00020\u0001*\u00020\u00022\b\u0010\u0003\u001a\u0004\u0018\u00010\u00042\b\u0010\u0005\u001a\u0004\u0018\u00010\u0006H\u0002¢\u0006\u0004\b\u0007\u0010\b\u001a'\u0010\t\u001a\u00020\u0001*\u00020\u00022\b\u0010\u0003\u001a\u0004\u0018\u00010\u00042\b\u0010\u0005\u001a\u0004\u0018\u00010\u0006H\u0002¢\u0006\u0004\b\n\u0010\b\u001a\f\u0010\u000b\u001a\u00020\f*\u00020\u0002H\u0002\u001a\f\u0010\r\u001a\u00020\f*\u00020\u0002H\u0002\u001a\f\u0010\u000e\u001a\u00020\f*\u00020\u0002H\u0000\u001a1\u0010\u000f\u001a\u00020\u0001*\u00020\u00022\b\u0010\u0003\u001a\u0004\u0018\u00010\u00042\b\u0010\u0005\u001a\u0004\u0018\u00010\u00062\b\b\u0002\u0010\u0010\u001a\u00020\fH\u0002¢\u0006\u0004\b\u0011\u0010\u0012\u001a'\u0010\u0013\u001a\u00020\u0001*\u00020\u00022\b\u0010\u0003\u001a\u0004\u0018\u00010\u00042\b\u0010\u0005\u001a\u0004\u0018\u00010\u0006H\u0002¢\u0006\u0004\b\u0014\u0010\b\u001a'\u0010\u0013\u001a\u00020\u0001*\u00020\u00012\b\u0010\u0003\u001a\u0004\u0018\u00010\u00042\b\u0010\u0005\u001a\u0004\u0018\u00010\u0006H\u0002¢\u0006\u0004\b\u0015\u0010\u0016\u001a'\u0010\u0017\u001a\u00020\u0001*\u00020\u00022\b\u0010\u0003\u001a\u0004\u0018\u00010\u00042\b\u0010\u0005\u001a\u0004\u0018\u00010\u0006H\u0002¢\u0006\u0004\b\u0018\u0010\b\u001a?\u0010\u0019\u001a\u00020\u001a*\u00020\u001b2\u0006\u0010\u001c\u001a\u00020\u00022\b\u0010\u0003\u001a\u0004\u0018\u00010\u00042\b\u0010\u0005\u001a\u0004\u0018\u00010\u00062\u0006\u0010\u001d\u001a\u00020\u001e2\u0006\u0010\u001f\u001a\u00020\u0001H\u0002¢\u0006\u0004\b \u0010!\"\u000e\u0010\"\u001a\u00020#X\u0082T¢\u0006\u0002\n\u0000\"\u000e\u0010$\u001a\u00020#X\u0082T¢\u0006\u0002\n\u0000¨\u0006%"}, d2 = {"positionChange", "Landroidx/compose/ui/geometry/Offset;", "Landroidx/compose/ui/input/indirect/IndirectPointerInputChange;", Constants.KEY_ORIENTATION, "Landroidx/compose/foundation/gestures/Orientation;", "primaryDirectionalMotionAxis", "Landroidx/compose/ui/input/indirect/IndirectPointerEventPrimaryDirectionalMotionAxis;", "positionChange-_bfSUIo", "(Landroidx/compose/ui/input/indirect/IndirectPointerInputChange;Landroidx/compose/foundation/gestures/Orientation;Landroidx/compose/ui/input/indirect/IndirectPointerEventPrimaryDirectionalMotionAxis;)J", "positionChangeIgnoreConsumed", "positionChangeIgnoreConsumed-_bfSUIo", "changedToUpIgnoreConsumed", "", "changedToDown", "changedToDownIgnoreConsumed", "positionChangeInternal", "ignoreConsumed", "positionChangeInternal-wfG_k4k", "(Landroidx/compose/ui/input/indirect/IndirectPointerInputChange;Landroidx/compose/foundation/gestures/Orientation;Landroidx/compose/ui/input/indirect/IndirectPointerEventPrimaryDirectionalMotionAxis;Z)J", "primaryAxisPosition", "primaryAxisPosition-_bfSUIo", "primaryAxisPosition-grjNGvw", "(JLandroidx/compose/foundation/gestures/Orientation;Landroidx/compose/ui/input/indirect/IndirectPointerEventPrimaryDirectionalMotionAxis;)J", "primaryAxisPreviousPosition", "primaryAxisPreviousPosition-_bfSUIo", "addIndirectPointerInputChange", "", "Landroidx/compose/ui/input/pointer/util/VelocityTracker;", "event", "smoother", "Landroidx/compose/foundation/gestures/IndirectPointerInputEventSmoother;", "nodeOffset", "addIndirectPointerInputChange-Qf4Zb88", "(Landroidx/compose/ui/input/pointer/util/VelocityTracker;Landroidx/compose/ui/input/indirect/IndirectPointerInputChange;Landroidx/compose/foundation/gestures/Orientation;Landroidx/compose/ui/input/indirect/IndirectPointerEventPrimaryDirectionalMotionAxis;Landroidx/compose/foundation/gestures/IndirectPointerInputEventSmoother;J)V", "SmoothingFactor", "", "PixelSensibility", "foundation"}, k = 2, mv = {2, 1, 0}, xi = 48)
public final class IndirectPointerInputDragCycleDetectorKt {
    private static final int PixelSensibility = 2;
    private static final int SmoothingFactor = 3;

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX INFO: renamed from: positionChange-_bfSUIo, reason: not valid java name */
    public static final long m617positionChange_bfSUIo(IndirectPointerInputChange indirectPointerInputChange, Orientation orientation, IndirectPointerEventPrimaryDirectionalMotionAxis indirectPointerEventPrimaryDirectionalMotionAxis) {
        return m619positionChangeInternalwfG_k4k(indirectPointerInputChange, orientation, indirectPointerEventPrimaryDirectionalMotionAxis, false);
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX INFO: renamed from: positionChangeIgnoreConsumed-_bfSUIo, reason: not valid java name */
    public static final long m618positionChangeIgnoreConsumed_bfSUIo(IndirectPointerInputChange indirectPointerInputChange, Orientation orientation, IndirectPointerEventPrimaryDirectionalMotionAxis indirectPointerEventPrimaryDirectionalMotionAxis) {
        return m619positionChangeInternalwfG_k4k(indirectPointerInputChange, orientation, indirectPointerEventPrimaryDirectionalMotionAxis, true);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final boolean changedToUpIgnoreConsumed(IndirectPointerInputChange indirectPointerInputChange) {
        return indirectPointerInputChange.getPreviousPressed() && !indirectPointerInputChange.getPressed();
    }

    private static final boolean changedToDown(IndirectPointerInputChange indirectPointerInputChange) {
        return (indirectPointerInputChange.getIsConsumed() || indirectPointerInputChange.getPreviousPressed() || !indirectPointerInputChange.getPressed()) ? false : true;
    }

    public static final boolean changedToDownIgnoreConsumed(IndirectPointerInputChange indirectPointerInputChange) {
        return !indirectPointerInputChange.getPreviousPressed() && indirectPointerInputChange.getPressed();
    }

    /* JADX INFO: renamed from: positionChangeInternal-wfG_k4k$default, reason: not valid java name */
    static /* synthetic */ long m620positionChangeInternalwfG_k4k$default(IndirectPointerInputChange indirectPointerInputChange, Orientation orientation, IndirectPointerEventPrimaryDirectionalMotionAxis indirectPointerEventPrimaryDirectionalMotionAxis, boolean z, int i, Object obj) {
        if ((i & 4) != 0) {
            z = false;
        }
        return m619positionChangeInternalwfG_k4k(indirectPointerInputChange, orientation, indirectPointerEventPrimaryDirectionalMotionAxis, z);
    }

    /* JADX INFO: renamed from: positionChangeInternal-wfG_k4k, reason: not valid java name */
    private static final long m619positionChangeInternalwfG_k4k(IndirectPointerInputChange indirectPointerInputChange, Orientation orientation, IndirectPointerEventPrimaryDirectionalMotionAxis indirectPointerEventPrimaryDirectionalMotionAxis, boolean z) {
        return (z || !indirectPointerInputChange.getIsConsumed()) ? Offset.m5727minusMKHz9U(m621primaryAxisPosition_bfSUIo(indirectPointerInputChange, orientation, indirectPointerEventPrimaryDirectionalMotionAxis), m623primaryAxisPreviousPosition_bfSUIo(indirectPointerInputChange, orientation, indirectPointerEventPrimaryDirectionalMotionAxis)) : Offset.INSTANCE.m5739getZeroF1C5BW0();
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX INFO: renamed from: primaryAxisPosition-_bfSUIo, reason: not valid java name */
    public static final long m621primaryAxisPosition_bfSUIo(IndirectPointerInputChange indirectPointerInputChange, Orientation orientation, IndirectPointerEventPrimaryDirectionalMotionAxis indirectPointerEventPrimaryDirectionalMotionAxis) {
        float fIntBitsToFloat;
        if (orientation == null) {
            return indirectPointerInputChange.getPosition();
        }
        if (indirectPointerEventPrimaryDirectionalMotionAxis == null ? false : IndirectPointerEventPrimaryDirectionalMotionAxis.m6798equalsimpl0(indirectPointerEventPrimaryDirectionalMotionAxis.getValue(), IndirectPointerEventPrimaryDirectionalMotionAxis.INSTANCE.m6803getXnZO2Niw())) {
            fIntBitsToFloat = Float.intBitsToFloat((int) (indirectPointerInputChange.getPosition() >> 32));
        } else {
            if (!(indirectPointerEventPrimaryDirectionalMotionAxis != null ? IndirectPointerEventPrimaryDirectionalMotionAxis.m6798equalsimpl0(indirectPointerEventPrimaryDirectionalMotionAxis.getValue(), IndirectPointerEventPrimaryDirectionalMotionAxis.INSTANCE.m6804getYnZO2Niw()) : false)) {
                return indirectPointerInputChange.getPosition();
            }
            fIntBitsToFloat = Float.intBitsToFloat((int) (indirectPointerInputChange.getPosition() & 4294967295L));
        }
        if (orientation == Orientation.Horizontal) {
            return Offset.m5715constructorimpl((((long) Float.floatToRawIntBits(fIntBitsToFloat)) << 32) | (((long) Float.floatToRawIntBits(0.0f)) & 4294967295L));
        }
        return Offset.m5715constructorimpl((((long) Float.floatToRawIntBits(0.0f)) << 32) | (((long) Float.floatToRawIntBits(fIntBitsToFloat)) & 4294967295L));
    }

    /* JADX INFO: renamed from: primaryAxisPosition-grjNGvw, reason: not valid java name */
    private static final long m622primaryAxisPositiongrjNGvw(long j, Orientation orientation, IndirectPointerEventPrimaryDirectionalMotionAxis indirectPointerEventPrimaryDirectionalMotionAxis) {
        float fIntBitsToFloat;
        if (orientation == null) {
            return j;
        }
        if (indirectPointerEventPrimaryDirectionalMotionAxis == null ? false : IndirectPointerEventPrimaryDirectionalMotionAxis.m6798equalsimpl0(indirectPointerEventPrimaryDirectionalMotionAxis.getValue(), IndirectPointerEventPrimaryDirectionalMotionAxis.INSTANCE.m6803getXnZO2Niw())) {
            fIntBitsToFloat = Float.intBitsToFloat((int) (j >> 32));
        } else {
            if (!(indirectPointerEventPrimaryDirectionalMotionAxis != null ? IndirectPointerEventPrimaryDirectionalMotionAxis.m6798equalsimpl0(indirectPointerEventPrimaryDirectionalMotionAxis.getValue(), IndirectPointerEventPrimaryDirectionalMotionAxis.INSTANCE.m6804getYnZO2Niw()) : false)) {
                return j;
            }
            fIntBitsToFloat = Float.intBitsToFloat((int) (j & 4294967295L));
        }
        if (orientation == Orientation.Horizontal) {
            return Offset.m5715constructorimpl((((long) Float.floatToRawIntBits(fIntBitsToFloat)) << 32) | (((long) Float.floatToRawIntBits(0.0f)) & 4294967295L));
        }
        return Offset.m5715constructorimpl((((long) Float.floatToRawIntBits(0.0f)) << 32) | (((long) Float.floatToRawIntBits(fIntBitsToFloat)) & 4294967295L));
    }

    /* JADX INFO: renamed from: primaryAxisPreviousPosition-_bfSUIo, reason: not valid java name */
    private static final long m623primaryAxisPreviousPosition_bfSUIo(IndirectPointerInputChange indirectPointerInputChange, Orientation orientation, IndirectPointerEventPrimaryDirectionalMotionAxis indirectPointerEventPrimaryDirectionalMotionAxis) {
        float fIntBitsToFloat;
        if (orientation == null) {
            return indirectPointerInputChange.getPreviousPosition();
        }
        if (indirectPointerEventPrimaryDirectionalMotionAxis == null ? false : IndirectPointerEventPrimaryDirectionalMotionAxis.m6798equalsimpl0(indirectPointerEventPrimaryDirectionalMotionAxis.getValue(), IndirectPointerEventPrimaryDirectionalMotionAxis.INSTANCE.m6803getXnZO2Niw())) {
            fIntBitsToFloat = Float.intBitsToFloat((int) (indirectPointerInputChange.getPreviousPosition() >> 32));
        } else {
            if (!(indirectPointerEventPrimaryDirectionalMotionAxis != null ? IndirectPointerEventPrimaryDirectionalMotionAxis.m6798equalsimpl0(indirectPointerEventPrimaryDirectionalMotionAxis.getValue(), IndirectPointerEventPrimaryDirectionalMotionAxis.INSTANCE.m6804getYnZO2Niw()) : false)) {
                return indirectPointerInputChange.getPreviousPosition();
            }
            fIntBitsToFloat = Float.intBitsToFloat((int) (indirectPointerInputChange.getPreviousPosition() & 4294967295L));
        }
        if (orientation == Orientation.Horizontal) {
            return Offset.m5715constructorimpl((((long) Float.floatToRawIntBits(fIntBitsToFloat)) << 32) | (((long) Float.floatToRawIntBits(0.0f)) & 4294967295L));
        }
        return Offset.m5715constructorimpl((((long) Float.floatToRawIntBits(0.0f)) << 32) | (((long) Float.floatToRawIntBits(fIntBitsToFloat)) & 4294967295L));
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX INFO: renamed from: addIndirectPointerInputChange-Qf4Zb88, reason: not valid java name */
    public static final void m616addIndirectPointerInputChangeQf4Zb88(VelocityTracker velocityTracker, IndirectPointerInputChange indirectPointerInputChange, Orientation orientation, IndirectPointerEventPrimaryDirectionalMotionAxis indirectPointerEventPrimaryDirectionalMotionAxis, IndirectPointerInputEventSmoother indirectPointerInputEventSmoother, long j) {
        velocityTracker.m7418addPositionUv8p0NA(indirectPointerInputChange.getUptimeMillis(), Offset.m5728plusMKHz9U(m622primaryAxisPositiongrjNGvw(indirectPointerInputEventSmoother.m624smoothEventPositiontuRUvjQ(indirectPointerInputChange), orientation, indirectPointerEventPrimaryDirectionalMotionAxis), j));
    }
}
