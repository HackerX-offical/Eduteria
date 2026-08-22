package androidx.compose.foundation.lazy;

import androidx.compose.foundation.CheckScrollableContainerConstraintsKt;
import androidx.compose.foundation.gestures.Orientation;
import androidx.compose.foundation.internal.InlineClassHelperKt;
import androidx.compose.foundation.layout.Arrangement;
import androidx.compose.foundation.layout.PaddingKt;
import androidx.compose.foundation.layout.PaddingValues;
import androidx.compose.foundation.lazy.layout.CacheWindowLogic;
import androidx.compose.foundation.lazy.layout.LazyLayoutBeyondBoundsStateKt;
import androidx.compose.foundation.lazy.layout.LazyLayoutMeasurePolicy;
import androidx.compose.foundation.lazy.layout.LazyLayoutMeasureScope;
import androidx.compose.foundation.lazy.layout.ObservableScopeInvalidator;
import androidx.compose.foundation.lazy.layout.StickyItemsPlacement;
import androidx.compose.runtime.snapshots.Snapshot;
import androidx.compose.ui.Alignment;
import androidx.compose.ui.graphics.GraphicsContext;
import androidx.compose.ui.layout.MeasureResult;
import androidx.compose.ui.layout.Placeable;
import androidx.compose.ui.unit.Constraints;
import androidx.compose.ui.unit.ConstraintsKt;
import androidx.compose.ui.unit.IntOffset;
import java.util.List;
import kotlin.KotlinNothingValueException;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.collections.MapsKt;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function3;
import kotlinx.coroutines.CoroutineScope;

/* JADX INFO: compiled from: LazyList.kt */
/* JADX INFO: loaded from: classes.dex */
@Metadata(k = 3, mv = {2, 1, 0}, xi = 48)
final class LazyListKt$rememberLazyListMeasurePolicy$1$1 implements LazyLayoutMeasurePolicy {
    final /* synthetic */ int $beyondBoundsItemCount;
    final /* synthetic */ PaddingValues $contentPadding;
    final /* synthetic */ CoroutineScope $coroutineScope;
    final /* synthetic */ GraphicsContext $graphicsContext;
    final /* synthetic */ Alignment.Horizontal $horizontalAlignment;
    final /* synthetic */ Arrangement.Horizontal $horizontalArrangement;
    final /* synthetic */ boolean $isVertical;
    final /* synthetic */ Function0<LazyListItemProvider> $itemProviderLambda;
    final /* synthetic */ boolean $reverseLayout;
    final /* synthetic */ LazyListState $state;
    final /* synthetic */ StickyItemsPlacement $stickyItemsPlacement;
    final /* synthetic */ Alignment.Vertical $verticalAlignment;
    final /* synthetic */ Arrangement.Vertical $verticalArrangement;

    /* JADX WARN: Multi-variable type inference failed */
    LazyListKt$rememberLazyListMeasurePolicy$1$1(LazyListState lazyListState, boolean z, PaddingValues paddingValues, boolean z2, Function0<? extends LazyListItemProvider> function0, Arrangement.Vertical vertical, Arrangement.Horizontal horizontal, int i, CoroutineScope coroutineScope, GraphicsContext graphicsContext, StickyItemsPlacement stickyItemsPlacement, Alignment.Horizontal horizontal2, Alignment.Vertical vertical2) {
        this.$state = lazyListState;
        this.$isVertical = z;
        this.$contentPadding = paddingValues;
        this.$reverseLayout = z2;
        this.$itemProviderLambda = function0;
        this.$verticalArrangement = vertical;
        this.$horizontalArrangement = horizontal;
        this.$beyondBoundsItemCount = i;
        this.$coroutineScope = coroutineScope;
        this.$graphicsContext = graphicsContext;
        this.$stickyItemsPlacement = stickyItemsPlacement;
        this.$horizontalAlignment = horizontal2;
        this.$verticalAlignment = vertical2;
    }

    @Override // androidx.compose.foundation.lazy.layout.LazyLayoutMeasurePolicy
    /* JADX INFO: renamed from: measure-0kLqBqw, reason: not valid java name */
    public final MeasureResult mo1289measure0kLqBqw(final LazyLayoutMeasureScope lazyLayoutMeasureScope, final long j) {
        int i;
        int i2;
        final int i3;
        float spacing;
        int iM8783getMaxWidthimpl;
        long jM8952constructorimpl;
        float scrollToBeConsumed;
        ObservableScopeInvalidator.m1393attachToScopeimpl(this.$state.m1308getMeasurementScopeInvalidatorzYiylxw$foundation());
        boolean z = this.$state.getHasLookaheadOccurred() || lazyLayoutMeasureScope.isLookingAhead();
        CheckScrollableContainerConstraintsKt.m349checkScrollableContainerConstraintsK40F9xA(j, this.$isVertical ? Orientation.Vertical : Orientation.Horizontal);
        if (this.$isVertical) {
            i = lazyLayoutMeasureScope.mo482roundToPx0680j_4(this.$contentPadding.mo1096calculateLeftPaddingu2uoSUM(lazyLayoutMeasureScope.getLayoutDirection()));
        } else {
            i = lazyLayoutMeasureScope.mo482roundToPx0680j_4(PaddingKt.calculateStartPadding(this.$contentPadding, lazyLayoutMeasureScope.getLayoutDirection()));
        }
        if (this.$isVertical) {
            i2 = lazyLayoutMeasureScope.mo482roundToPx0680j_4(this.$contentPadding.mo1097calculateRightPaddingu2uoSUM(lazyLayoutMeasureScope.getLayoutDirection()));
        } else {
            i2 = lazyLayoutMeasureScope.mo482roundToPx0680j_4(PaddingKt.calculateEndPadding(this.$contentPadding, lazyLayoutMeasureScope.getLayoutDirection()));
        }
        int i4 = lazyLayoutMeasureScope.mo482roundToPx0680j_4(this.$contentPadding.getTop());
        int i5 = lazyLayoutMeasureScope.mo482roundToPx0680j_4(this.$contentPadding.getBottom());
        final int i6 = i4 + i5;
        final int i7 = i + i2;
        boolean z2 = this.$isVertical;
        int i8 = z2 ? i6 : i7;
        if (z2 && !this.$reverseLayout) {
            i3 = i4;
        } else if (z2 && this.$reverseLayout) {
            i3 = i5;
        } else {
            i3 = (z2 || this.$reverseLayout) ? i2 : i;
        }
        final int i9 = i8 - i3;
        final long jM8802offsetNN6EwU = ConstraintsKt.m8802offsetNN6EwU(j, -i7, -i6);
        final LazyListItemProvider lazyListItemProviderInvoke = this.$itemProviderLambda.invoke();
        lazyListItemProviderInvoke.getItemScope().setMaxSize(Constraints.m8783getMaxWidthimpl(jM8802offsetNN6EwU), Constraints.m8782getMaxHeightimpl(jM8802offsetNN6EwU));
        if (this.$isVertical) {
            Arrangement.Vertical vertical = this.$verticalArrangement;
            if (vertical != null) {
                spacing = vertical.getSpacing();
            } else {
                InlineClassHelperKt.throwIllegalArgumentExceptionForNullCheck("null verticalArrangement when isVertical == true");
                throw new KotlinNothingValueException();
            }
        } else {
            Arrangement.Horizontal horizontal = this.$horizontalArrangement;
            if (horizontal != null) {
                spacing = horizontal.getSpacing();
            } else {
                InlineClassHelperKt.throwIllegalArgumentExceptionForNullCheck("null horizontalAlignment when isVertical == false");
                throw new KotlinNothingValueException();
            }
        }
        final int i10 = lazyLayoutMeasureScope.mo482roundToPx0680j_4(spacing);
        final int itemCount = lazyListItemProviderInvoke.getItemCount();
        if (this.$isVertical) {
            iM8783getMaxWidthimpl = Constraints.m8782getMaxHeightimpl(j) - i6;
        } else {
            iM8783getMaxWidthimpl = Constraints.m8783getMaxWidthimpl(j) - i7;
        }
        int i11 = iM8783getMaxWidthimpl;
        if (this.$reverseLayout && i11 <= 0) {
            boolean z3 = this.$isVertical;
            if (!z3) {
                i += i11;
            }
            if (z3) {
                i4 += i11;
            }
            jM8952constructorimpl = IntOffset.m8952constructorimpl((((long) i4) & 4294967295L) | (((long) i) << 32));
        } else {
            jM8952constructorimpl = IntOffset.m8952constructorimpl((((long) i4) & 4294967295L) | (((long) i) << 32));
        }
        final long j2 = jM8952constructorimpl;
        final boolean z4 = this.$isVertical;
        final Alignment.Horizontal horizontal2 = this.$horizontalAlignment;
        final Alignment.Vertical vertical2 = this.$verticalAlignment;
        final boolean z5 = this.$reverseLayout;
        final LazyListState lazyListState = this.$state;
        LazyListMeasuredItemProvider lazyListMeasuredItemProvider = new LazyListMeasuredItemProvider(jM8802offsetNN6EwU, z4, lazyListItemProviderInvoke, lazyLayoutMeasureScope, itemCount, i10, horizontal2, vertical2, z5, i3, i9, j2, lazyListState) { // from class: androidx.compose.foundation.lazy.LazyListKt$rememberLazyListMeasurePolicy$1$1$measuredItemProvider$1
            final /* synthetic */ int $afterContentPadding;
            final /* synthetic */ int $beforeContentPadding;
            final /* synthetic */ Alignment.Horizontal $horizontalAlignment;
            final /* synthetic */ boolean $isVertical;
            final /* synthetic */ int $itemsCount;
            final /* synthetic */ boolean $reverseLayout;
            final /* synthetic */ int $spaceBetweenItems;
            final /* synthetic */ LazyListState $state;
            final /* synthetic */ LazyLayoutMeasureScope $this_LazyLayoutMeasurePolicy;
            final /* synthetic */ Alignment.Vertical $verticalAlignment;
            final /* synthetic */ long $visualItemOffset;

            {
                this.$isVertical = z4;
                this.$this_LazyLayoutMeasurePolicy = lazyLayoutMeasureScope;
                this.$itemsCount = itemCount;
                this.$spaceBetweenItems = i10;
                this.$horizontalAlignment = horizontal2;
                this.$verticalAlignment = vertical2;
                this.$reverseLayout = z5;
                this.$beforeContentPadding = i3;
                this.$afterContentPadding = i9;
                this.$visualItemOffset = j2;
                this.$state = lazyListState;
            }

            @Override // androidx.compose.foundation.lazy.LazyListMeasuredItemProvider
            /* JADX INFO: renamed from: createItem-X9ElhV4, reason: not valid java name */
            public LazyListMeasuredItem mo1290createItemX9ElhV4(int index, Object key, Object contentType, List<? extends Placeable> placeables, long constraints) {
                return new LazyListMeasuredItem(index, placeables, this.$isVertical, this.$horizontalAlignment, this.$verticalAlignment, this.$this_LazyLayoutMeasurePolicy.getLayoutDirection(), this.$reverseLayout, this.$beforeContentPadding, this.$afterContentPadding, index == this.$itemsCount + (-1) ? 0 : this.$spaceBetweenItems, this.$visualItemOffset, key, contentType, this.$state.getItemAnimator$foundation(), constraints, null);
            }
        };
        Snapshot.Companion companion = Snapshot.INSTANCE;
        LazyListState lazyListState2 = this.$state;
        Snapshot currentThreadSnapshot = companion.getCurrentThreadSnapshot();
        Function1<Object, Unit> readObserver = currentThreadSnapshot != null ? currentThreadSnapshot.getReadObserver() : null;
        Snapshot snapshotMakeCurrentNonObservable = companion.makeCurrentNonObservable(currentThreadSnapshot);
        try {
            int iUpdateScrollPositionIfTheFirstItemWasMoved$foundation = lazyListState2.updateScrollPositionIfTheFirstItemWasMoved$foundation(lazyListItemProviderInvoke, lazyListState2.getFirstVisibleItemIndex());
            int firstVisibleItemScrollOffset = lazyListState2.getFirstVisibleItemScrollOffset();
            Unit unit = Unit.INSTANCE;
            companion.restoreNonObservable(currentThreadSnapshot, snapshotMakeCurrentNonObservable, readObserver);
            List<Integer> listCalculateLazyLayoutPinnedIndices = LazyLayoutBeyondBoundsStateKt.calculateLazyLayoutPinnedIndices(lazyListItemProviderInvoke, this.$state.getPinnedItems(), this.$state.getBeyondBoundsInfo());
            if (lazyLayoutMeasureScope.isLookingAhead() || !z) {
                scrollToBeConsumed = this.$state.getScrollToBeConsumed();
            } else {
                scrollToBeConsumed = this.$state.getScrollDeltaBetweenPasses$foundation();
            }
            LazyListMeasuredItemProvider lazyListMeasuredItemProvider2 = lazyListMeasuredItemProvider;
            LazyListMeasureResult lazyListMeasureResultM1296measureLazyListpIk1_oM = LazyListMeasureKt.m1296measureLazyListpIk1_oM(itemCount, lazyListMeasuredItemProvider2, i11, i3, i9, i10, iUpdateScrollPositionIfTheFirstItemWasMoved$foundation, firstVisibleItemScrollOffset, scrollToBeConsumed, jM8802offsetNN6EwU, this.$isVertical, this.$verticalArrangement, this.$horizontalArrangement, this.$reverseLayout, lazyLayoutMeasureScope, this.$state.getItemAnimator$foundation(), this.$beyondBoundsItemCount, listCalculateLazyLayoutPinnedIndices, z, lazyLayoutMeasureScope.isLookingAhead(), this.$coroutineScope, this.$state.m1309getPlacementScopeInvalidatorzYiylxw$foundation(), this.$graphicsContext, this.$stickyItemsPlacement, !this.$state.getSkipItemPlacementAnimation(), new Function3() { // from class: androidx.compose.foundation.lazy.LazyListKt$rememberLazyListMeasurePolicy$1$1$$ExternalSyntheticLambda0
                @Override // kotlin.jvm.functions.Function3
                public final Object invoke(Object obj, Object obj2, Object obj3) {
                    return LazyListKt$rememberLazyListMeasurePolicy$1$1.measure_0kLqBqw$lambda$3(lazyLayoutMeasureScope, j, i7, i6, ((Integer) obj).intValue(), ((Integer) obj2).intValue(), (Function1) obj3);
                }
            });
            LazyListState.applyMeasureResult$foundation$default(this.$state, lazyListMeasureResultM1296measureLazyListpIk1_oM, lazyLayoutMeasureScope.isLookingAhead(), false, 4, null);
            Object prefetchStrategy = this.$state.getPrefetchStrategy();
            CacheWindowLogic cacheWindowLogic = prefetchStrategy instanceof CacheWindowLogic ? (CacheWindowLogic) prefetchStrategy : null;
            if (cacheWindowLogic != null) {
                LazyListKt.keepAroundItems(cacheWindowLogic, lazyListMeasureResultM1296measureLazyListpIk1_oM.getVisibleItemsInfo(), lazyListMeasuredItemProvider2);
            }
            return lazyListMeasureResultM1296measureLazyListpIk1_oM;
        } catch (Throwable th) {
            companion.restoreNonObservable(currentThreadSnapshot, snapshotMakeCurrentNonObservable, readObserver);
            throw th;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final MeasureResult measure_0kLqBqw$lambda$3(LazyLayoutMeasureScope lazyLayoutMeasureScope, long j, int i, int i2, int i3, int i4, Function1 function1) {
        return lazyLayoutMeasureScope.layout(ConstraintsKt.m8800constrainWidthK40F9xA(j, i3 + i), ConstraintsKt.m8799constrainHeightK40F9xA(j, i4 + i2), MapsKt.emptyMap(), function1);
    }
}
