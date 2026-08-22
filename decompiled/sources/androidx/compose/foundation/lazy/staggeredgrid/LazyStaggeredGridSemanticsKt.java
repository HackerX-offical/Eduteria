package androidx.compose.foundation.lazy.staggeredgrid;

import androidx.compose.foundation.gestures.Orientation;
import androidx.compose.foundation.lazy.layout.LazyLayoutSemanticState;
import androidx.compose.foundation.lazy.layout.LazyLayoutSemanticsKt;
import androidx.compose.runtime.Composer;
import androidx.compose.runtime.ComposerKt;
import androidx.compose.ui.semantics.CollectionInfo;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;

/* JADX INFO: compiled from: LazyStaggeredGridSemantics.kt */
/* JADX INFO: loaded from: classes.dex */
@Metadata(d1 = {"\u0000\u0016\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0002\u001a\u001d\u0010\u0000\u001a\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u0005H\u0001¢\u0006\u0002\u0010\u0006¨\u0006\u0007"}, d2 = {"rememberLazyStaggeredGridSemanticState", "Landroidx/compose/foundation/lazy/layout/LazyLayoutSemanticState;", "state", "Landroidx/compose/foundation/lazy/staggeredgrid/LazyStaggeredGridState;", "reverseScrolling", "", "(Landroidx/compose/foundation/lazy/staggeredgrid/LazyStaggeredGridState;ZLandroidx/compose/runtime/Composer;I)Landroidx/compose/foundation/lazy/layout/LazyLayoutSemanticState;", "foundation"}, k = 2, mv = {2, 1, 0}, xi = 48)
public final class LazyStaggeredGridSemanticsKt {
    public static final LazyLayoutSemanticState rememberLazyStaggeredGridSemanticState(final LazyStaggeredGridState lazyStaggeredGridState, boolean z, Composer composer, int i) {
        ComposerKt.sourceInformationMarkerStart(composer, 1629354903, "C(rememberLazyStaggeredGridSemanticState)N(state,reverseScrolling)31@1250L1315:LazyStaggeredGridSemantics.kt#fzvcnm");
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventStart(1629354903, i, -1, "androidx.compose.foundation.lazy.staggeredgrid.rememberLazyStaggeredGridSemanticState (LazyStaggeredGridSemantics.kt:31)");
        }
        ComposerKt.sourceInformationMarkerStart(composer, -1852995366, "CC(remember):LazyStaggeredGridSemantics.kt#9igjgp");
        boolean z2 = ((((i & 14) ^ 6) > 4 && composer.changed(lazyStaggeredGridState)) || (i & 6) == 4) | ((((i & 112) ^ 48) > 32 && composer.changed(z)) || (i & 48) == 32);
        Object objRememberedValue = composer.rememberedValue();
        if (z2 || objRememberedValue == Composer.INSTANCE.getEmpty()) {
            objRememberedValue = new LazyLayoutSemanticState() { // from class: androidx.compose.foundation.lazy.staggeredgrid.LazyStaggeredGridSemanticsKt$rememberLazyStaggeredGridSemanticState$1$1
                @Override // androidx.compose.foundation.lazy.layout.LazyLayoutSemanticState
                public float getScrollOffset() {
                    return LazyLayoutSemanticsKt.estimatedLazyScrollOffset(lazyStaggeredGridState.getFirstVisibleItemIndex(), lazyStaggeredGridState.getFirstVisibleItemScrollOffset());
                }

                @Override // androidx.compose.foundation.lazy.layout.LazyLayoutSemanticState
                public float getMaxScrollOffset() {
                    return LazyLayoutSemanticsKt.estimatedLazyMaxScrollOffset(lazyStaggeredGridState.getFirstVisibleItemIndex(), lazyStaggeredGridState.getFirstVisibleItemScrollOffset(), lazyStaggeredGridState.getCanScrollForward());
                }

                @Override // androidx.compose.foundation.lazy.layout.LazyLayoutSemanticState
                public Object scrollToItem(int i2, Continuation<? super Unit> continuation) {
                    Object objScrollToItem$default = LazyStaggeredGridState.scrollToItem$default(lazyStaggeredGridState, i2, 0, continuation, 2, null);
                    return objScrollToItem$default == IntrinsicsKt.getCOROUTINE_SUSPENDED() ? objScrollToItem$default : Unit.INSTANCE;
                }

                @Override // androidx.compose.foundation.lazy.layout.LazyLayoutSemanticState
                public CollectionInfo collectionInfo() {
                    return new CollectionInfo(-1, -1);
                }

                @Override // androidx.compose.foundation.lazy.layout.LazyLayoutSemanticState
                public int getViewport() {
                    long viewportSize;
                    if (lazyStaggeredGridState.getLayoutInfo().getOrientation() == Orientation.Vertical) {
                        viewportSize = lazyStaggeredGridState.getLayoutInfo().getViewportSize() & 4294967295L;
                    } else {
                        viewportSize = lazyStaggeredGridState.getLayoutInfo().getViewportSize() >> 32;
                    }
                    return (int) viewportSize;
                }

                @Override // androidx.compose.foundation.lazy.layout.LazyLayoutSemanticState
                public int getContentPadding() {
                    return lazyStaggeredGridState.getLayoutInfo().getBeforeContentPadding() + lazyStaggeredGridState.getLayoutInfo().getAfterContentPadding();
                }
            };
            composer.updateRememberedValue(objRememberedValue);
        }
        LazyStaggeredGridSemanticsKt$rememberLazyStaggeredGridSemanticState$1$1 lazyStaggeredGridSemanticsKt$rememberLazyStaggeredGridSemanticState$1$1 = (LazyStaggeredGridSemanticsKt$rememberLazyStaggeredGridSemanticState$1$1) objRememberedValue;
        ComposerKt.sourceInformationMarkerEnd(composer);
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventEnd();
        }
        ComposerKt.sourceInformationMarkerEnd(composer);
        return lazyStaggeredGridSemanticsKt$rememberLazyStaggeredGridSemanticState$1$1;
    }
}
