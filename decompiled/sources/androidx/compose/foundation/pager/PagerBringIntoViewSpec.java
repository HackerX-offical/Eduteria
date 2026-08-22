package androidx.compose.foundation.pager;

import androidx.compose.animation.core.VisibilityThresholdsKt;
import androidx.compose.foundation.gestures.BringIntoViewSpec;
import androidx.compose.foundation.gestures.Orientation;
import androidx.compose.ui.unit.LayoutDirection;
import kotlin.Metadata;
import kotlin.jvm.internal.IntCompanionObject;
import kotlin.ranges.RangesKt;

/* JADX INFO: compiled from: LazyLayoutPager.kt */
/* JADX INFO: loaded from: classes.dex */
@Metadata(d1 = {"\u00002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\t\n\u0002\u0010\u0007\n\u0002\b\u0007\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0010\b\n\u0002\b\u0003\b\u0002\u0018\u00002\u00020\u0001B\u001f\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0001\u0012\u0006\u0010\u0005\u001a\u00020\u0006¢\u0006\u0004\b\u0007\u0010\bJ \u0010\u000f\u001a\u00020\u00102\u0006\u0010\u0011\u001a\u00020\u00102\u0006\u0010\u0012\u001a\u00020\u00102\u0006\u0010\u0013\u001a\u00020\u0010H\u0016J\u0010\u0010\u0014\u001a\u00020\u00102\u0006\u0010\u0013\u001a\u00020\u0010H\u0002J\u0010\u0010\u0015\u001a\u00020\u00102\u0006\u0010\u0016\u001a\u00020\u0010H\u0002R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\t\u0010\nR\u0011\u0010\u0004\u001a\u00020\u0001¢\u0006\b\n\u0000\u001a\u0004\b\u000b\u0010\fR\u0011\u0010\u0005\u001a\u00020\u0006¢\u0006\b\n\u0000\u001a\u0004\b\r\u0010\u000eR\u0018\u0010\u0017\u001a\u00020\u0018*\u00020\u00038BX\u0082\u0004¢\u0006\u0006\u001a\u0004\b\u0019\u0010\u001aR\u0015\u0010\u001b\u001a\u00020\u001c*\u00020\u00038F¢\u0006\u0006\u001a\u0004\b\u001d\u0010\u001e¨\u0006\u001f"}, d2 = {"Landroidx/compose/foundation/pager/PagerBringIntoViewSpec;", "Landroidx/compose/foundation/gestures/BringIntoViewSpec;", "pagerState", "Landroidx/compose/foundation/pager/PagerState;", "defaultBringIntoViewSpec", "layoutDirection", "Landroidx/compose/ui/unit/LayoutDirection;", "<init>", "(Landroidx/compose/foundation/pager/PagerState;Landroidx/compose/foundation/gestures/BringIntoViewSpec;Landroidx/compose/ui/unit/LayoutDirection;)V", "getPagerState", "()Landroidx/compose/foundation/pager/PagerState;", "getDefaultBringIntoViewSpec", "()Landroidx/compose/foundation/gestures/BringIntoViewSpec;", "getLayoutDirection", "()Landroidx/compose/ui/unit/LayoutDirection;", "calculateScrollDistance", "", "offset", "size", "containerSize", "settlingScrollDistance", "overrideProposedOffsetMove", "proposedOffsetMove", "shouldChangeScrollDirection", "", "getShouldChangeScrollDirection", "(Landroidx/compose/foundation/pager/PagerState;)Z", "layoutAwareFirstOffset", "", "getLayoutAwareFirstOffset", "(Landroidx/compose/foundation/pager/PagerState;)I", "foundation"}, k = 1, mv = {2, 1, 0}, xi = 48)
final class PagerBringIntoViewSpec implements BringIntoViewSpec {
    private final BringIntoViewSpec defaultBringIntoViewSpec;
    private final LayoutDirection layoutDirection;
    private final PagerState pagerState;

    public PagerBringIntoViewSpec(PagerState pagerState, BringIntoViewSpec bringIntoViewSpec, LayoutDirection layoutDirection) {
        this.pagerState = pagerState;
        this.defaultBringIntoViewSpec = bringIntoViewSpec;
        this.layoutDirection = layoutDirection;
    }

    public final PagerState getPagerState() {
        return this.pagerState;
    }

    public final BringIntoViewSpec getDefaultBringIntoViewSpec() {
        return this.defaultBringIntoViewSpec;
    }

    public final LayoutDirection getLayoutDirection() {
        return this.layoutDirection;
    }

    @Override // androidx.compose.foundation.gestures.BringIntoViewSpec
    public float calculateScrollDistance(float offset, float size, float containerSize) {
        float fCalculateScrollDistance = this.defaultBringIntoViewSpec.calculateScrollDistance(offset, size, containerSize);
        boolean z = true;
        if (offset <= 0.0f ? offset + size > VisibilityThresholdsKt.getVisibilityThreshold(IntCompanionObject.INSTANCE) : offset + size <= containerSize) {
            z = false;
        }
        if (Math.abs(fCalculateScrollDistance) != 0.0f && z) {
            return overrideProposedOffsetMove(fCalculateScrollDistance);
        }
        if (Math.abs(this.pagerState.getFirstVisiblePageOffset()) < 1.0E-6d) {
            return 0.0f;
        }
        return settlingScrollDistance(containerSize);
    }

    private final float settlingScrollDistance(float containerSize) {
        int pageSizeWithSpacing$foundation;
        float layoutAwareFirstOffset = getLayoutAwareFirstOffset(this.pagerState) * (-1.0f);
        if (getShouldChangeScrollDirection(this.pagerState)) {
            if (!this.pagerState.getLastScrolledForward()) {
                pageSizeWithSpacing$foundation = this.pagerState.getPageSizeWithSpacing$foundation();
                layoutAwareFirstOffset += pageSizeWithSpacing$foundation;
            }
        } else if (this.pagerState.getLastScrolledForward()) {
            pageSizeWithSpacing$foundation = this.pagerState.getPageSizeWithSpacing$foundation();
            layoutAwareFirstOffset += pageSizeWithSpacing$foundation;
        }
        return RangesKt.coerceIn(layoutAwareFirstOffset, -containerSize, containerSize);
    }

    private final float overrideProposedOffsetMove(float proposedOffsetMove) {
        float layoutAwareFirstOffset = getLayoutAwareFirstOffset(this.pagerState) * (-1);
        while (proposedOffsetMove > 0.0f && layoutAwareFirstOffset < proposedOffsetMove) {
            layoutAwareFirstOffset += this.pagerState.getPageSizeWithSpacing$foundation();
        }
        while (proposedOffsetMove < 0.0f && layoutAwareFirstOffset > proposedOffsetMove) {
            layoutAwareFirstOffset -= this.pagerState.getPageSizeWithSpacing$foundation();
        }
        return layoutAwareFirstOffset;
    }

    private final boolean getShouldChangeScrollDirection(PagerState pagerState) {
        return this.layoutDirection == LayoutDirection.Rtl && pagerState.getLayoutInfo().getOrientation() == Orientation.Horizontal;
    }

    public final int getLayoutAwareFirstOffset(PagerState pagerState) {
        if (getShouldChangeScrollDirection(pagerState)) {
            return (-pagerState.getFirstVisiblePageOffset()) + pagerState.getPageSizeWithSpacing$foundation();
        }
        return pagerState.getFirstVisiblePageOffset();
    }
}
