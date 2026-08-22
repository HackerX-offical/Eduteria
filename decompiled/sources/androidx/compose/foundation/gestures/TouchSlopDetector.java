package androidx.compose.foundation.gestures;

import androidx.compose.ui.geometry.Offset;
import com.clevertap.android.sdk.Constants;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;

/* JADX INFO: compiled from: DragGestureDetector.kt */
/* JADX INFO: loaded from: classes.dex */
@Metadata(d1 = {"\u00000\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0010\u0007\n\u0002\b\n\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0002\b\u000b\b\u0001\u0018\u00002\u00020\u0001B\u001d\u0012\n\b\u0002\u0010\u0002\u001a\u0004\u0018\u00010\u0003\u0012\b\b\u0002\u0010\u0004\u001a\u00020\u0005¢\u0006\u0004\b\u0006\u0010\u0007J\u0011\u0010\f\u001a\u00020\r*\u00020\u0005¢\u0006\u0004\b\u000e\u0010\u000fJ\u0011\u0010\u0010\u001a\u00020\r*\u00020\u0005¢\u0006\u0004\b\u0011\u0010\u000fJ'\u0010\u0014\u001a\u00020\u00052\u0006\u0010\u0015\u001a\u00020\u00052\u0006\u0010\u0016\u001a\u00020\r2\b\b\u0002\u0010\u0017\u001a\u00020\u0018¢\u0006\u0004\b\u0019\u0010\u001aJ\u0017\u0010\u001b\u001a\u00020\u001c2\b\b\u0002\u0010\u001d\u001a\u00020\u0005¢\u0006\u0004\b\u001e\u0010\u001fJ\u0015\u0010 \u001a\u00020\u00182\u0006\u0010!\u001a\u00020\u0005¢\u0006\u0004\b\"\u0010#J\u0017\u0010$\u001a\u00020\u00052\u0006\u0010\u0016\u001a\u00020\rH\u0002¢\u0006\u0004\b%\u0010&R\u001c\u0010\u0002\u001a\u0004\u0018\u00010\u0003X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\b\u0010\t\"\u0004\b\n\u0010\u000bR\u0010\u0010\u0012\u001a\u00020\u0005X\u0082\u000e¢\u0006\u0004\n\u0002\u0010\u0013¨\u0006'"}, d2 = {"Landroidx/compose/foundation/gestures/TouchSlopDetector;", "", Constants.KEY_ORIENTATION, "Landroidx/compose/foundation/gestures/Orientation;", "initialPositionChange", "Landroidx/compose/ui/geometry/Offset;", "<init>", "(Landroidx/compose/foundation/gestures/Orientation;JLkotlin/jvm/internal/DefaultConstructorMarker;)V", "getOrientation", "()Landroidx/compose/foundation/gestures/Orientation;", "setOrientation", "(Landroidx/compose/foundation/gestures/Orientation;)V", "mainAxis", "", "mainAxis-k-4lQ0M", "(J)F", "crossAxis", "crossAxis-k-4lQ0M", "totalPositionChange", "J", "getPostSlopOffset", "positionChange", "touchSlop", "shouldCommit", "", "getPostSlopOffset-qto3Fdw", "(JFZ)J", "reset", "", "initialPositionAccumulator", "reset-k-4lQ0M", "(J)V", "isDeltaAtAngleOfInterest", "delta", "isDeltaAtAngleOfInterest-k-4lQ0M", "(J)Z", "calculatePostSlopOffset", "calculatePostSlopOffset-tuRUvjQ", "(F)J", "foundation"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final class TouchSlopDetector {
    public static final int $stable = 8;
    private Orientation orientation;
    private long totalPositionChange;

    /* JADX INFO: compiled from: DragGestureDetector.kt */
    @Metadata(k = 3, mv = {2, 1, 0}, xi = 48)
    public static final /* synthetic */ class WhenMappings {
        public static final /* synthetic */ int[] $EnumSwitchMapping$0;

        static {
            int[] iArr = new int[Orientation.values().length];
            try {
                iArr[Orientation.Horizontal.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                iArr[Orientation.Vertical.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            $EnumSwitchMapping$0 = iArr;
        }
    }

    public /* synthetic */ TouchSlopDetector(Orientation orientation, long j, DefaultConstructorMarker defaultConstructorMarker) {
        this(orientation, j);
    }

    private TouchSlopDetector(Orientation orientation, long j) {
        this.orientation = orientation;
        this.totalPositionChange = j;
    }

    public final Orientation getOrientation() {
        return this.orientation;
    }

    public final void setOrientation(Orientation orientation) {
        this.orientation = orientation;
    }

    public /* synthetic */ TouchSlopDetector(Orientation orientation, long j, int i, DefaultConstructorMarker defaultConstructorMarker) {
        this((i & 1) != 0 ? null : orientation, (i & 2) != 0 ? Offset.INSTANCE.m5739getZeroF1C5BW0() : j, null);
    }

    /* JADX INFO: renamed from: mainAxis-k-4lQ0M, reason: not valid java name */
    public final float m716mainAxisk4lQ0M(long j) {
        return Float.intBitsToFloat((int) (this.orientation == Orientation.Horizontal ? j >> 32 : j & 4294967295L));
    }

    /* JADX INFO: renamed from: crossAxis-k-4lQ0M, reason: not valid java name */
    public final float m713crossAxisk4lQ0M(long j) {
        return Float.intBitsToFloat((int) (this.orientation == Orientation.Horizontal ? j & 4294967295L : j >> 32));
    }

    /* JADX INFO: renamed from: getPostSlopOffset-qto3Fdw$default, reason: not valid java name */
    public static /* synthetic */ long m711getPostSlopOffsetqto3Fdw$default(TouchSlopDetector touchSlopDetector, long j, float f2, boolean z, int i, Object obj) {
        if ((i & 4) != 0) {
            z = true;
        }
        return touchSlopDetector.m714getPostSlopOffsetqto3Fdw(j, f2, z);
    }

    /* JADX INFO: renamed from: getPostSlopOffset-qto3Fdw, reason: not valid java name */
    public final long m714getPostSlopOffsetqto3Fdw(long positionChange, float touchSlop, boolean shouldCommit) {
        long jM5728plusMKHz9U;
        float fAbs;
        if (shouldCommit) {
            jM5728plusMKHz9U = Offset.m5728plusMKHz9U(this.totalPositionChange, positionChange);
            this.totalPositionChange = jM5728plusMKHz9U;
        } else {
            jM5728plusMKHz9U = Offset.m5728plusMKHz9U(this.totalPositionChange, positionChange);
        }
        if (this.orientation == null) {
            fAbs = Offset.m5721getDistanceimpl(jM5728plusMKHz9U);
        } else {
            fAbs = Math.abs(m716mainAxisk4lQ0M(jM5728plusMKHz9U));
        }
        if (fAbs >= touchSlop) {
            return m710calculatePostSlopOffsettuRUvjQ(touchSlop);
        }
        return Offset.INSTANCE.m5738getUnspecifiedF1C5BW0();
    }

    /* JADX INFO: renamed from: reset-k-4lQ0M$default, reason: not valid java name */
    public static /* synthetic */ void m712resetk4lQ0M$default(TouchSlopDetector touchSlopDetector, long j, int i, Object obj) {
        if ((i & 1) != 0) {
            j = Offset.INSTANCE.m5739getZeroF1C5BW0();
        }
        touchSlopDetector.m717resetk4lQ0M(j);
    }

    /* JADX INFO: renamed from: reset-k-4lQ0M, reason: not valid java name */
    public final void m717resetk4lQ0M(long initialPositionAccumulator) {
        this.totalPositionChange = initialPositionAccumulator;
    }

    /* JADX INFO: renamed from: isDeltaAtAngleOfInterest-k-4lQ0M, reason: not valid java name */
    public final boolean m715isDeltaAtAngleOfInterestk4lQ0M(long delta) {
        long jM5728plusMKHz9U = Offset.m5728plusMKHz9U(this.totalPositionChange, delta);
        double dAtan2 = ((double) (((float) Math.atan2(Math.abs(Float.intBitsToFloat((int) (jM5728plusMKHz9U & 4294967295L))), Math.abs(Float.intBitsToFloat((int) (jM5728plusMKHz9U >> 32))))) * 180)) / 3.141592653589793d;
        Orientation orientation = this.orientation;
        int i = orientation == null ? -1 : WhenMappings.$EnumSwitchMapping$0[orientation.ordinal()];
        return i != 1 ? i == 2 && dAtan2 > 30.0d : dAtan2 < 30.0d;
    }

    /* JADX INFO: renamed from: calculatePostSlopOffset-tuRUvjQ, reason: not valid java name */
    private final long m710calculatePostSlopOffsettuRUvjQ(float touchSlop) {
        if (this.orientation == null) {
            long j = this.totalPositionChange;
            return Offset.m5727minusMKHz9U(this.totalPositionChange, Offset.m5730timestuRUvjQ(Offset.m5718divtuRUvjQ(j, Offset.m5721getDistanceimpl(j)), touchSlop));
        }
        float fM716mainAxisk4lQ0M = m716mainAxisk4lQ0M(this.totalPositionChange) - (Math.signum(m716mainAxisk4lQ0M(this.totalPositionChange)) * touchSlop);
        float fM713crossAxisk4lQ0M = m713crossAxisk4lQ0M(this.totalPositionChange);
        if (this.orientation == Orientation.Horizontal) {
            return Offset.m5715constructorimpl((((long) Float.floatToRawIntBits(fM716mainAxisk4lQ0M)) << 32) | (((long) Float.floatToRawIntBits(fM713crossAxisk4lQ0M)) & 4294967295L));
        }
        return Offset.m5715constructorimpl((((long) Float.floatToRawIntBits(fM713crossAxisk4lQ0M)) << 32) | (((long) Float.floatToRawIntBits(fM716mainAxisk4lQ0M)) & 4294967295L));
    }
}
