package androidx.compose.foundation.gestures.snapping;

import androidx.compose.foundation.gestures.Orientation;
import androidx.compose.foundation.internal.InlineClassHelperKt;
import androidx.compose.foundation.pager.PageInfo;
import androidx.compose.foundation.pager.PagerLayoutInfo;
import androidx.compose.foundation.pager.PagerLayoutInfoKt;
import androidx.compose.foundation.pager.PagerSnapDistance;
import androidx.compose.foundation.pager.PagerState;
import java.util.List;
import kotlin.Metadata;
import kotlin.Pair;
import kotlin.TuplesKt;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function3;
import kotlin.ranges.RangesKt;

/* JADX INFO: compiled from: PagerSnapLayoutInfoProvider.kt */
/* JADX INFO: loaded from: classes.dex */
@Metadata(d1 = {"\u0000>\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u0007\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\u001a8\u0010\u0000\u001a\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u00052\u001e\u0010\u0006\u001a\u001a\u0012\u0004\u0012\u00020\b\u0012\u0004\u0012\u00020\b\u0012\u0004\u0012\u00020\b\u0012\u0004\u0012\u00020\b0\u0007H\u0000\u001a\u0014\u0010\t\u001a\u00020\n*\u00020\u00032\u0006\u0010\u000b\u001a\u00020\bH\u0002\u001a\f\u0010\f\u001a\u00020\b*\u00020\u0003H\u0002\u001a\u0017\u0010\r\u001a\u00020\u000e2\f\u0010\u000f\u001a\b\u0012\u0004\u0012\u00020\u00110\u0010H\u0082\b\u001a8\u0010\u0006\u001a\u00020\b2\u0006\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0012\u001a\u00020\u00132\u0006\u0010\u0014\u001a\u00020\b2\u0006\u0010\u0015\u001a\u00020\b2\u0006\u0010\u0016\u001a\u00020\b2\u0006\u0010\u0017\u001a\u00020\bH\u0000¨\u0006\u0018"}, d2 = {"SnapLayoutInfoProvider", "Landroidx/compose/foundation/gestures/snapping/SnapLayoutInfoProvider;", "pagerState", "Landroidx/compose/foundation/pager/PagerState;", "pagerSnapDistance", "Landroidx/compose/foundation/pager/PagerSnapDistance;", "calculateFinalSnappingBound", "Lkotlin/Function3;", "", "isScrollingForward", "", "velocity", "dragGestureDelta", "debugLog", "", "generateMsg", "Lkotlin/Function0;", "", "layoutDirection", "Landroidx/compose/ui/unit/LayoutDirection;", "snapPositionalThreshold", "flingVelocity", "lowerBoundOffset", "upperBoundOffset", "foundation"}, k = 2, mv = {2, 1, 0}, xi = 48)
public final class PagerSnapLayoutInfoProviderKt {
    private static final void debugLog(Function0<String> function0) {
    }

    public static final SnapLayoutInfoProvider SnapLayoutInfoProvider(final PagerState pagerState, final PagerSnapDistance pagerSnapDistance, final Function3<? super Float, ? super Float, ? super Float, Float> function3) {
        return new SnapLayoutInfoProvider() { // from class: androidx.compose.foundation.gestures.snapping.PagerSnapLayoutInfoProviderKt.SnapLayoutInfoProvider.1
            public final boolean isValidDistance(float f2) {
                return (f2 == Float.POSITIVE_INFINITY || f2 == Float.NEGATIVE_INFINITY) ? false : true;
            }

            public final PagerLayoutInfo getLayoutInfo() {
                return pagerState.getLayoutInfo();
            }

            @Override // androidx.compose.foundation.gestures.snapping.SnapLayoutInfoProvider
            public float calculateSnapOffset(float velocity) {
                Pair<Float, Float> pairSearchForSnappingBounds = searchForSnappingBounds(pagerState.getLayoutInfo().getSnapPosition(), velocity);
                float fFloatValue = pairSearchForSnappingBounds.component1().floatValue();
                float fFloatValue2 = pairSearchForSnappingBounds.component2().floatValue();
                float fFloatValue3 = function3.invoke(Float.valueOf(velocity), Float.valueOf(fFloatValue), Float.valueOf(fFloatValue2)).floatValue();
                if (!(fFloatValue3 == fFloatValue || fFloatValue3 == fFloatValue2 || fFloatValue3 == 0.0f)) {
                    InlineClassHelperKt.throwIllegalStateException("Final Snapping Offset Should Be one of " + fFloatValue + ", " + fFloatValue2 + " or 0.0");
                }
                if (isValidDistance(fFloatValue3)) {
                    return fFloatValue3;
                }
                return 0.0f;
            }

            @Override // androidx.compose.foundation.gestures.snapping.SnapLayoutInfoProvider
            public float calculateApproachOffset(float velocity, float decayOffset) {
                int firstVisiblePage;
                int pageSize$foundation = pagerState.getPageSize$foundation() + pagerState.getPageSpacing$foundation();
                if (pageSize$foundation == 0) {
                    return 0.0f;
                }
                if (velocity < 0.0f) {
                    firstVisiblePage = pagerState.getFirstVisiblePage() + 1;
                } else {
                    firstVisiblePage = pagerState.getFirstVisiblePage();
                }
                int i = firstVisiblePage;
                int iCoerceAtLeast = RangesKt.coerceAtLeast(Math.abs((RangesKt.coerceIn(pagerSnapDistance.calculateTargetPage(i, RangesKt.coerceIn(((int) (decayOffset / pageSize$foundation)) + i, 0, pagerState.getPageCount()), velocity, pagerState.getPageSize$foundation(), pagerState.getPageSpacing$foundation()), 0, pagerState.getPageCount()) - i) * pageSize$foundation) - pageSize$foundation, 0);
                return iCoerceAtLeast == 0 ? iCoerceAtLeast : iCoerceAtLeast * Math.signum(velocity);
            }

            private final Pair<Float, Float> searchForSnappingBounds(SnapPosition snapPosition, float velocity) {
                float f2;
                List<PageInfo> visiblePagesInfo = getLayoutInfo().getVisiblePagesInfo();
                PagerState pagerState2 = pagerState;
                int size = visiblePagesInfo.size();
                int i = 0;
                float f3 = Float.NEGATIVE_INFINITY;
                float f4 = Float.POSITIVE_INFINITY;
                while (true) {
                    f2 = 0.0f;
                    if (i >= size) {
                        break;
                    }
                    PageInfo pageInfo = visiblePagesInfo.get(i);
                    float fCalculateDistanceToDesiredSnapPosition = SnapPositionKt.calculateDistanceToDesiredSnapPosition(PagerLayoutInfoKt.getMainAxisViewportSize(getLayoutInfo()), getLayoutInfo().getBeforeContentPadding(), getLayoutInfo().getAfterContentPadding(), getLayoutInfo().getPageSize(), pageInfo.getOffset(), pageInfo.getIndex(), snapPosition, pagerState2.getPageCount());
                    if (fCalculateDistanceToDesiredSnapPosition <= 0.0f && fCalculateDistanceToDesiredSnapPosition > f3) {
                        f3 = fCalculateDistanceToDesiredSnapPosition;
                    }
                    if (fCalculateDistanceToDesiredSnapPosition >= 0.0f && fCalculateDistanceToDesiredSnapPosition < f4) {
                        f4 = fCalculateDistanceToDesiredSnapPosition;
                    }
                    i++;
                }
                if (f3 == Float.NEGATIVE_INFINITY) {
                    f3 = f4;
                }
                if (f4 == Float.POSITIVE_INFINITY) {
                    f4 = f3;
                }
                if (!pagerState.getCanScrollForward()) {
                    if (PagerSnapLayoutInfoProviderKt.isScrollingForward(pagerState, velocity)) {
                        f3 = 0.0f;
                        f4 = 0.0f;
                    } else {
                        f4 = 0.0f;
                    }
                }
                if (pagerState.getCanScrollBackward()) {
                    f2 = f3;
                } else if (!PagerSnapLayoutInfoProviderKt.isScrollingForward(pagerState, velocity)) {
                    f4 = 0.0f;
                }
                return TuplesKt.to(Float.valueOf(f2), Float.valueOf(f4));
            }
        };
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final boolean isScrollingForward(PagerState pagerState, float f2) {
        boolean reverseLayout = pagerState.getLayoutInfo().getReverseLayout();
        boolean z = (pagerState.isNotGestureAction$foundation() ? -f2 : dragGestureDelta(pagerState)) > 0.0f;
        return (z && reverseLayout) || !(z || reverseLayout);
    }

    private static final float dragGestureDelta(PagerState pagerState) {
        if (pagerState.getLayoutInfo().getOrientation() == Orientation.Horizontal) {
            return Float.intBitsToFloat((int) (pagerState.m1485getUpDownDifferenceF1C5BW0$foundation() >> 32));
        }
        return Float.intBitsToFloat((int) (pagerState.m1485getUpDownDifferenceF1C5BW0$foundation() & 4294967295L));
    }

    /* JADX WARN: Removed duplicated region for block: B:33:0x008a A[RETURN] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public static final float calculateFinalSnappingBound(androidx.compose.foundation.pager.PagerState r4, androidx.compose.ui.unit.LayoutDirection r5, float r6, float r7, float r8, float r9) {
        /*
            boolean r0 = isScrollingForward(r4, r7)
            androidx.compose.foundation.pager.PagerLayoutInfo r1 = r4.getLayoutInfo()
            androidx.compose.foundation.gestures.Orientation r1 = r1.getOrientation()
            androidx.compose.foundation.gestures.Orientation r2 = androidx.compose.foundation.gestures.Orientation.Vertical
            if (r1 != r2) goto L11
            goto L1b
        L11:
            androidx.compose.ui.unit.LayoutDirection r1 = androidx.compose.ui.unit.LayoutDirection.Ltr
            if (r5 != r1) goto L16
            goto L1b
        L16:
            if (r0 != 0) goto L1a
            r0 = 1
            goto L1b
        L1a:
            r0 = 0
        L1b:
            androidx.compose.foundation.pager.PagerLayoutInfo r5 = r4.getLayoutInfo()
            int r5 = r5.getPageSize()
            r1 = 0
            if (r5 != 0) goto L28
            r2 = r1
            goto L2e
        L28:
            float r2 = dragGestureDelta(r4)
            float r5 = (float) r5
            float r2 = r2 / r5
        L2e:
            int r5 = (int) r2
            float r5 = (float) r5
            float r5 = r2 - r5
            androidx.compose.ui.unit.Density r3 = r4.getDensity()
            int r7 = androidx.compose.foundation.gestures.snapping.LazyListSnapLayoutInfoProviderKt.calculateFinalSnappingItem(r3, r7)
            androidx.compose.foundation.gestures.snapping.FinalSnappingItem$Companion r3 = androidx.compose.foundation.gestures.snapping.FinalSnappingItem.INSTANCE
            int r3 = r3.m758getClosestItembbeMdSM()
            boolean r3 = androidx.compose.foundation.gestures.snapping.FinalSnappingItem.m754equalsimpl0(r7, r3)
            if (r3 == 0) goto L71
            float r5 = java.lang.Math.abs(r5)
            int r5 = (r5 > r6 ? 1 : (r5 == r6 ? 0 : -1))
            if (r5 <= 0) goto L51
            if (r0 == 0) goto L8a
            goto L7d
        L51:
            float r5 = java.lang.Math.abs(r2)
            float r4 = r4.getPositionThresholdFraction$foundation()
            float r4 = java.lang.Math.abs(r4)
            int r4 = (r5 > r4 ? 1 : (r5 == r4 ? 0 : -1))
            if (r4 < 0) goto L64
            if (r0 == 0) goto L7d
            goto L8a
        L64:
            float r4 = java.lang.Math.abs(r8)
            float r5 = java.lang.Math.abs(r9)
            int r4 = (r4 > r5 ? 1 : (r4 == r5 ? 0 : -1))
            if (r4 >= 0) goto L7d
            goto L8a
        L71:
            androidx.compose.foundation.gestures.snapping.FinalSnappingItem$Companion r4 = androidx.compose.foundation.gestures.snapping.FinalSnappingItem.INSTANCE
            int r4 = r4.m759getNextItembbeMdSM()
            boolean r4 = androidx.compose.foundation.gestures.snapping.FinalSnappingItem.m754equalsimpl0(r7, r4)
            if (r4 == 0) goto L7e
        L7d:
            return r9
        L7e:
            androidx.compose.foundation.gestures.snapping.FinalSnappingItem$Companion r4 = androidx.compose.foundation.gestures.snapping.FinalSnappingItem.INSTANCE
            int r4 = r4.m760getPreviousItembbeMdSM()
            boolean r4 = androidx.compose.foundation.gestures.snapping.FinalSnappingItem.m754equalsimpl0(r7, r4)
            if (r4 == 0) goto L8b
        L8a:
            return r8
        L8b:
            return r1
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.compose.foundation.gestures.snapping.PagerSnapLayoutInfoProviderKt.calculateFinalSnappingBound(androidx.compose.foundation.pager.PagerState, androidx.compose.ui.unit.LayoutDirection, float, float, float, float):float");
    }
}
