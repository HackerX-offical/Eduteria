package androidx.compose.foundation.pager;

import androidx.collection.IntObjectMapKt;
import androidx.compose.foundation.CheckScrollableContainerConstraintsKt;
import androidx.compose.foundation.gestures.Orientation;
import androidx.compose.foundation.gestures.snapping.SnapPosition;
import androidx.compose.foundation.layout.PaddingKt;
import androidx.compose.foundation.layout.PaddingValues;
import androidx.compose.foundation.lazy.layout.LazyLayoutBeyondBoundsStateKt;
import androidx.compose.foundation.lazy.layout.LazyLayoutMeasurePolicy;
import androidx.compose.foundation.lazy.layout.LazyLayoutMeasureScope;
import androidx.compose.foundation.lazy.layout.ObservableScopeInvalidator;
import androidx.compose.runtime.snapshots.Snapshot;
import androidx.compose.ui.Alignment;
import androidx.compose.ui.layout.MeasureResult;
import androidx.compose.ui.unit.Constraints;
import androidx.compose.ui.unit.ConstraintsKt;
import androidx.compose.ui.unit.IntOffset;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.collections.MapsKt;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function3;
import kotlin.ranges.RangesKt;
import kotlinx.coroutines.CoroutineScope;

/* JADX INFO: compiled from: PagerMeasurePolicy.kt */
/* JADX INFO: loaded from: classes.dex */
@Metadata(k = 3, mv = {2, 1, 0}, xi = 48)
final class PagerMeasurePolicyKt$rememberPagerMeasurePolicy$1$1 implements LazyLayoutMeasurePolicy {
    final /* synthetic */ int $beyondViewportPageCount;
    final /* synthetic */ PaddingValues $contentPadding;
    final /* synthetic */ CoroutineScope $coroutineScope;
    final /* synthetic */ Alignment.Horizontal $horizontalAlignment;
    final /* synthetic */ Function0<PagerLazyLayoutItemProvider> $itemProviderLambda;
    final /* synthetic */ Orientation $orientation;
    final /* synthetic */ Function0<Integer> $pageCount;
    final /* synthetic */ PageSize $pageSize;
    final /* synthetic */ float $pageSpacing;
    final /* synthetic */ boolean $reverseLayout;
    final /* synthetic */ SnapPosition $snapPosition;
    final /* synthetic */ PagerState $state;
    final /* synthetic */ Alignment.Vertical $verticalAlignment;

    PagerMeasurePolicyKt$rememberPagerMeasurePolicy$1$1(PagerState pagerState, Orientation orientation, PaddingValues paddingValues, boolean z, float f2, PageSize pageSize, Function0<PagerLazyLayoutItemProvider> function0, Function0<Integer> function02, Alignment.Vertical vertical, Alignment.Horizontal horizontal, int i, SnapPosition snapPosition, CoroutineScope coroutineScope) {
        this.$state = pagerState;
        this.$orientation = orientation;
        this.$contentPadding = paddingValues;
        this.$reverseLayout = z;
        this.$pageSpacing = f2;
        this.$pageSize = pageSize;
        this.$itemProviderLambda = function0;
        this.$pageCount = function02;
        this.$verticalAlignment = vertical;
        this.$horizontalAlignment = horizontal;
        this.$beyondViewportPageCount = i;
        this.$snapPosition = snapPosition;
        this.$coroutineScope = coroutineScope;
    }

    @Override // androidx.compose.foundation.lazy.layout.LazyLayoutMeasurePolicy
    /* JADX INFO: renamed from: measure-0kLqBqw */
    public final MeasureResult mo1289measure0kLqBqw(final LazyLayoutMeasureScope lazyLayoutMeasureScope, final long j) {
        int i;
        int i2;
        int i3;
        int iM8783getMaxWidthimpl;
        int i4;
        long jM8952constructorimpl;
        ObservableScopeInvalidator.m1393attachToScopeimpl(this.$state.m1482getMeasurementScopeInvalidatorzYiylxw$foundation());
        boolean z = this.$orientation == Orientation.Vertical;
        CheckScrollableContainerConstraintsKt.m349checkScrollableContainerConstraintsK40F9xA(j, z ? Orientation.Vertical : Orientation.Horizontal);
        if (z) {
            i = lazyLayoutMeasureScope.mo482roundToPx0680j_4(this.$contentPadding.mo1096calculateLeftPaddingu2uoSUM(lazyLayoutMeasureScope.getLayoutDirection()));
        } else {
            i = lazyLayoutMeasureScope.mo482roundToPx0680j_4(PaddingKt.calculateStartPadding(this.$contentPadding, lazyLayoutMeasureScope.getLayoutDirection()));
        }
        if (z) {
            i2 = lazyLayoutMeasureScope.mo482roundToPx0680j_4(this.$contentPadding.mo1097calculateRightPaddingu2uoSUM(lazyLayoutMeasureScope.getLayoutDirection()));
        } else {
            i2 = lazyLayoutMeasureScope.mo482roundToPx0680j_4(PaddingKt.calculateEndPadding(this.$contentPadding, lazyLayoutMeasureScope.getLayoutDirection()));
        }
        int i5 = lazyLayoutMeasureScope.mo482roundToPx0680j_4(this.$contentPadding.getTop());
        int i6 = lazyLayoutMeasureScope.mo482roundToPx0680j_4(this.$contentPadding.getBottom());
        int i7 = i2;
        int i8 = i5 + i6;
        final int i9 = i + i7;
        int i10 = z ? i8 : i9;
        if (z && !this.$reverseLayout) {
            i3 = i5;
        } else if (z && this.$reverseLayout) {
            i3 = i6;
        } else {
            i3 = (z || this.$reverseLayout) ? i7 : i;
        }
        int i11 = i10 - i3;
        long jM8802offsetNN6EwU = ConstraintsKt.m8802offsetNN6EwU(j, -i9, -i8);
        LazyLayoutMeasureScope lazyLayoutMeasureScope2 = lazyLayoutMeasureScope;
        this.$state.setDensity$foundation(lazyLayoutMeasureScope2);
        int i12 = lazyLayoutMeasureScope.mo482roundToPx0680j_4(this.$pageSpacing);
        if (z) {
            iM8783getMaxWidthimpl = Constraints.m8782getMaxHeightimpl(j) - i8;
        } else {
            iM8783getMaxWidthimpl = Constraints.m8783getMaxWidthimpl(j) - i9;
        }
        if (!this.$reverseLayout || iM8783getMaxWidthimpl > 0) {
            i4 = i8;
            jM8952constructorimpl = IntOffset.m8952constructorimpl((((long) i) << 32) | (((long) i5) & 4294967295L));
        } else {
            if (!z) {
                i += iM8783getMaxWidthimpl;
            }
            if (z) {
                i5 += iM8783getMaxWidthimpl;
            }
            i4 = i8;
            jM8952constructorimpl = IntOffset.m8952constructorimpl((((long) i5) & 4294967295L) | (((long) i) << 32));
        }
        int iCoerceAtLeast = RangesKt.coerceAtLeast(this.$pageSize.calculateMainAxisPageSize(lazyLayoutMeasureScope2, iM8783getMaxWidthimpl, i12), 0);
        this.$state.m1486setPremeasureConstraintsBRTryo0$foundation(ConstraintsKt.Constraints$default(0, this.$orientation == Orientation.Vertical ? Constraints.m8783getMaxWidthimpl(jM8802offsetNN6EwU) : iCoerceAtLeast, 0, this.$orientation != Orientation.Vertical ? Constraints.m8782getMaxHeightimpl(jM8802offsetNN6EwU) : iCoerceAtLeast, 5, null));
        PagerLazyLayoutItemProvider pagerLazyLayoutItemProviderInvoke = this.$itemProviderLambda.invoke();
        int i13 = iM8783getMaxWidthimpl + i3 + i11;
        Snapshot.Companion companion = Snapshot.INSTANCE;
        long j2 = jM8952constructorimpl;
        PagerState pagerState = this.$state;
        SnapPosition snapPosition = this.$snapPosition;
        Snapshot currentThreadSnapshot = companion.getCurrentThreadSnapshot();
        Function1<Object, Unit> readObserver = currentThreadSnapshot != null ? currentThreadSnapshot.getReadObserver() : null;
        Snapshot snapshotMakeCurrentNonObservable = companion.makeCurrentNonObservable(currentThreadSnapshot);
        try {
            int iMatchScrollPositionWithKey$foundation = pagerState.matchScrollPositionWithKey$foundation(pagerLazyLayoutItemProviderInvoke, pagerState.getCurrentPage());
            int currentPage = pagerState.getCurrentPage();
            float currentPageOffsetFraction = pagerState.getCurrentPageOffsetFraction();
            int pageCount = pagerState.getPageCount();
            int i14 = iM8783getMaxWidthimpl;
            int iCurrentPageOffset = PagerKt.currentPageOffset(snapPosition, i13, iCoerceAtLeast, i12, i3, i11, currentPage, currentPageOffsetFraction, pageCount);
            Unit unit = Unit.INSTANCE;
            companion.restoreNonObservable(currentThreadSnapshot, snapshotMakeCurrentNonObservable, readObserver);
            final int i15 = i4;
            PagerMeasureResult pagerMeasureResultM1478measurePager7L1iB3k = PagerMeasureKt.m1478measurePager7L1iB3k(lazyLayoutMeasureScope, this.$pageCount.invoke().intValue(), pagerLazyLayoutItemProviderInvoke, i14, i3, i11, i12, iMatchScrollPositionWithKey$foundation, iCurrentPageOffset, jM8802offsetNN6EwU, this.$orientation, this.$verticalAlignment, this.$horizontalAlignment, this.$reverseLayout, j2, iCoerceAtLeast, this.$beyondViewportPageCount, LazyLayoutBeyondBoundsStateKt.calculateLazyLayoutPinnedIndices(pagerLazyLayoutItemProviderInvoke, this.$state.getPinnedPages(), this.$state.getBeyondBoundsInfo()), this.$snapPosition, this.$state.m1483getPlacementScopeInvalidatorzYiylxw$foundation(), this.$coroutineScope, lazyLayoutMeasureScope2, new Function3() { // from class: androidx.compose.foundation.pager.PagerMeasurePolicyKt$rememberPagerMeasurePolicy$1$1$$ExternalSyntheticLambda0
                @Override // kotlin.jvm.functions.Function3
                public final Object invoke(Object obj, Object obj2, Object obj3) {
                    return PagerMeasurePolicyKt$rememberPagerMeasurePolicy$1$1.measure_0kLqBqw$lambda$2(lazyLayoutMeasureScope, j, i9, i15, ((Integer) obj).intValue(), ((Integer) obj2).intValue(), (Function1) obj3);
                }
            }, IntObjectMapKt.mutableIntObjectMapOf());
            PagerState.applyMeasureResult$foundation$default(this.$state, pagerMeasureResultM1478measurePager7L1iB3k, lazyLayoutMeasureScope.isLookingAhead(), false, 4, null);
            PagerMeasurePolicyKt.keepAroundItems(lazyLayoutMeasureScope, this.$state.getCacheWindowLogic(), pagerMeasureResultM1478measurePager7L1iB3k.getVisiblePagesInfo());
            return pagerMeasureResultM1478measurePager7L1iB3k;
        } catch (Throwable th) {
            companion.restoreNonObservable(currentThreadSnapshot, snapshotMakeCurrentNonObservable, readObserver);
            throw th;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final MeasureResult measure_0kLqBqw$lambda$2(LazyLayoutMeasureScope lazyLayoutMeasureScope, long j, int i, int i2, int i3, int i4, Function1 function1) {
        return lazyLayoutMeasureScope.layout(ConstraintsKt.m8800constrainWidthK40F9xA(j, i3 + i), ConstraintsKt.m8799constrainHeightK40F9xA(j, i4 + i2), MapsKt.emptyMap(), function1);
    }
}
