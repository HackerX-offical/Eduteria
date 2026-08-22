package androidx.compose.foundation.lazy;

import androidx.compose.foundation.ScrollIndicatorState;
import androidx.compose.foundation.gestures.ScrollScope;
import androidx.compose.foundation.gestures.ScrollableState;
import androidx.compose.foundation.gestures.ScrollableStateKt;
import androidx.compose.foundation.interaction.InteractionSource;
import androidx.compose.foundation.interaction.InteractionSourceKt;
import androidx.compose.foundation.interaction.MutableInteractionSource;
import androidx.compose.foundation.internal.InlineClassHelperKt;
import androidx.compose.foundation.lazy.LazyListState;
import androidx.compose.foundation.lazy.layout.AwaitFirstLayoutModifier;
import androidx.compose.foundation.lazy.layout.CacheWindowLogic;
import androidx.compose.foundation.lazy.layout.LazyLayoutBeyondBoundsInfo;
import androidx.compose.foundation.lazy.layout.LazyLayoutCacheWindow;
import androidx.compose.foundation.lazy.layout.LazyLayoutItemAnimator;
import androidx.compose.foundation.lazy.layout.LazyLayoutPinnedItemList;
import androidx.compose.foundation.lazy.layout.LazyLayoutPrefetchState;
import androidx.compose.foundation.lazy.layout.LazyLayoutScrollDeltaBetweenPasses;
import androidx.compose.foundation.lazy.layout.LazyLayoutScrollScopeKt;
import androidx.compose.foundation.lazy.layout.NestedPrefetchScope;
import androidx.compose.foundation.lazy.layout.ObservableScopeInvalidator;
import androidx.compose.runtime.MutableState;
import androidx.compose.runtime.SnapshotStateKt;
import androidx.compose.runtime.SnapshotStateKt__SnapshotStateKt;
import androidx.compose.runtime.saveable.ListSaverKt;
import androidx.compose.runtime.saveable.Saver;
import androidx.compose.runtime.saveable.SaverScope;
import androidx.compose.runtime.snapshots.Snapshot;
import androidx.compose.ui.layout.Remeasurement;
import androidx.compose.ui.layout.RemeasurementModifier;
import androidx.compose.ui.unit.Density;
import androidx.compose.ui.util.AndroidTrace_androidKt;
import com.google.firebase.analytics.FirebaseAnalytics;
import cz.msebera.android.httpclient.HttpStatus;
import java.util.List;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.ContinuationImpl;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.ranges.IntRange;
import kotlinx.coroutines.BuildersKt__Builders_commonKt;
import kotlinx.coroutines.CoroutineScope;
import org.jivesoftware.smackx.blocking.element.BlockContactsIQ;

/* JADX INFO: compiled from: LazyListState.kt */
/* JADX INFO: loaded from: classes.dex */
@Metadata(d1 = {"\u0000ÿ\u0001\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0007\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\f\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0000\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\t\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0002\b\u0012\n\u0002\u0018\u0002\n\u0002\b\u0013\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004*\u0001\\\b\u0007\u0018\u0000 ¬\u00012\u00020\u0001:\u0002¬\u0001B'\b\u0007\u0012\b\b\u0002\u0010\u0002\u001a\u00020\u0003\u0012\b\b\u0002\u0010\u0004\u001a\u00020\u0003\u0012\b\b\u0002\u0010\u0005\u001a\u00020\u0006¢\u0006\u0004\b\u0007\u0010\bB%\b\u0017\u0012\u0006\u0010\t\u001a\u00020\n\u0012\b\b\u0002\u0010\u0002\u001a\u00020\u0003\u0012\b\b\u0002\u0010\u0004\u001a\u00020\u0003¢\u0006\u0004\b\u0007\u0010\u000bB\u001d\b\u0016\u0012\b\b\u0002\u0010\u0002\u001a\u00020\u0003\u0012\b\b\u0002\u0010\u0004\u001a\u00020\u0003¢\u0006\u0004\b\u0007\u0010\fJ\b\u0010^\u001a\u00020\u0003H\u0002J\"\u0010i\u001a\u00020j2\b\b\u0001\u0010k\u001a\u00020\u00032\b\b\u0002\u0010l\u001a\u00020\u0003H\u0086@¢\u0006\u0002\u0010mJ\u001a\u0010s\u001a\u00020j2\b\b\u0001\u0010k\u001a\u00020\u00032\b\b\u0002\u0010l\u001a\u00020\u0003J%\u0010t\u001a\u00020j2\u0006\u0010k\u001a\u00020\u00032\u0006\u0010l\u001a\u00020\u00032\u0006\u0010u\u001a\u00020\u0010H\u0000¢\u0006\u0002\bvJ@\u0010w\u001a\u00020j2\u0006\u0010x\u001a\u00020y2'\u0010z\u001a#\b\u0001\u0012\u0004\u0012\u00020|\u0012\n\u0012\b\u0012\u0004\u0012\u00020j0}\u0012\u0006\u0012\u0004\u0018\u00010~0{¢\u0006\u0002\b\u007fH\u0096@¢\u0006\u0003\u0010\u0080\u0001J\u0012\u0010\u0081\u0001\u001a\u00020,2\u0007\u0010\u0082\u0001\u001a\u00020,H\u0016J\u0018\u0010\u0097\u0001\u001a\u00020,2\u0007\u0010\u0098\u0001\u001a\u00020,H\u0000¢\u0006\u0003\b\u0099\u0001J\u001a\u0010\u009a\u0001\u001a\u00020j2\u0007\u0010\u0082\u0001\u001a\u00020,2\u0006\u0010 \u001a\u00020!H\u0002J#\u0010\u009b\u0001\u001a\u00020j2\b\b\u0001\u0010k\u001a\u00020\u00032\b\b\u0002\u0010l\u001a\u00020\u0003H\u0086@¢\u0006\u0002\u0010mJ,\u0010\u009c\u0001\u001a\u00020j2\u0007\u0010\u009d\u0001\u001a\u00020\u00142\u0007\u0010\u009e\u0001\u001a\u00020\u00102\t\b\u0002\u0010\u009f\u0001\u001a\u00020\u0010H\u0000¢\u0006\u0003\b \u0001J\u0012\u0010¡\u0001\u001a\u00020j2\u0007\u0010¢\u0001\u001a\u00020\u0014H\u0002J\"\u0010§\u0001\u001a\u00020\u00032\b\u0010¨\u0001\u001a\u00030©\u00012\u0007\u0010ª\u0001\u001a\u00020\u0003H\u0000¢\u0006\u0003\b«\u0001R\u0014\u0010\u0005\u001a\u00020\u0006X\u0080\u0004¢\u0006\b\n\u0000\u001a\u0004\b\r\u0010\u000eR\u001e\u0010\u0011\u001a\u00020\u00102\u0006\u0010\u000f\u001a\u00020\u0010@BX\u0080\u000e¢\u0006\b\n\u0000\u001a\u0004\b\u0012\u0010\u0013R\"\u0010\u0015\u001a\u0004\u0018\u00010\u00142\b\u0010\u000f\u001a\u0004\u0018\u00010\u0014@BX\u0080\u000e¢\u0006\b\n\u0000\u001a\u0004\b\u0016\u0010\u0017R\u000e\u0010\u0018\u001a\u00020\u0010X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0019\u001a\u00020\u001aX\u0082\u0004¢\u0006\u0002\n\u0000R\u0011\u0010\u0002\u001a\u00020\u00038G¢\u0006\u0006\u001a\u0004\b\u001b\u0010\u001cR\u0011\u0010\u0004\u001a\u00020\u00038G¢\u0006\u0006\u001a\u0004\b\u001d\u0010\u001cR\u0014\u0010\u001e\u001a\b\u0012\u0004\u0012\u00020\u00140\u001fX\u0082\u0004¢\u0006\u0002\n\u0000R\u0011\u0010 \u001a\u00020!8G¢\u0006\u0006\u001a\u0004\b\"\u0010#R\u0011\u0010$\u001a\u00020%8F¢\u0006\u0006\u001a\u0004\b&\u0010'R\u0014\u0010(\u001a\u00020)X\u0080\u0004¢\u0006\b\n\u0000\u001a\u0004\b*\u0010+R\u001e\u0010-\u001a\u00020,2\u0006\u0010\u000f\u001a\u00020,@BX\u0080\u000e¢\u0006\b\n\u0000\u001a\u0004\b.\u0010/R\u0014\u00100\u001a\u0002018@X\u0080\u0004¢\u0006\u0006\u001a\u0004\b2\u00103R\u001a\u00104\u001a\u00020\u0010X\u0080\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b5\u0010\u0013\"\u0004\b6\u00107R\u000e\u00108\u001a\u00020\u0001X\u0082\u0004¢\u0006\u0002\n\u0000R\u001e\u00109\u001a\u00020\u00032\u0006\u0010\u000f\u001a\u00020\u0003@BX\u0080\u000e¢\u0006\b\n\u0000\u001a\u0004\b:\u0010\u001cR\u001a\u0010;\u001a\u00020\u0010X\u0080\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b<\u0010\u0013\"\u0004\b=\u00107R\"\u0010?\u001a\u0004\u0018\u00010>2\b\u0010\u000f\u001a\u0004\u0018\u00010>@BX\u0080\u000e¢\u0006\b\n\u0000\u001a\u0004\b@\u0010AR\u0014\u0010B\u001a\u00020CX\u0080\u0004¢\u0006\b\n\u0000\u001a\u0004\bD\u0010ER\u0014\u0010F\u001a\u00020GX\u0080\u0004¢\u0006\b\n\u0000\u001a\u0004\bH\u0010IR\u001a\u0010J\u001a\b\u0012\u0004\u0012\u00020L0KX\u0080\u0004¢\u0006\b\n\u0000\u001a\u0004\bM\u0010NR\u0014\u0010O\u001a\u00020PX\u0080\u0004¢\u0006\b\n\u0000\u001a\u0004\bQ\u0010RR\u001a\u0010S\u001a\u00020TX\u0080\u0004¢\u0006\u000e\n\u0000\u0012\u0004\bU\u0010V\u001a\u0004\bW\u0010XR\u000e\u0010Y\u001a\u00020ZX\u0082\u0004¢\u0006\u0002\n\u0000R\u0010\u0010[\u001a\u00020\\X\u0082\u0004¢\u0006\u0004\n\u0002\u0010]R\u0014\u0010_\u001a\u00020`X\u0080\u0004¢\u0006\b\n\u0000\u001a\u0004\ba\u0010bR\u001b\u0010c\u001a\u00020d8@X\u0080\u0084\u0002¢\u0006\f\u001a\u0004\bg\u0010h*\u0004\be\u0010fR\u0016\u0010n\u001a\u00020oX\u0080\u0004¢\u0006\n\n\u0002\u0010r\u001a\u0004\bp\u0010qR\u0016\u0010\u0083\u0001\u001a\u00020\u00108VX\u0096\u0004¢\u0006\u0007\u001a\u0005\b\u0083\u0001\u0010\u0013R0\u0010\u0085\u0001\u001a\u00020\u00102\u0007\u0010\u0084\u0001\u001a\u00020\u00108V@RX\u0096\u008e\u0002¢\u0006\u0015\n\u0005\b\u0088\u0001\u0010r\u001a\u0005\b\u0086\u0001\u0010\u0013\"\u0005\b\u0087\u0001\u00107R0\u0010\u0089\u0001\u001a\u00020\u00102\u0007\u0010\u0084\u0001\u001a\u00020\u00108V@RX\u0096\u008e\u0002¢\u0006\u0015\n\u0005\b\u008c\u0001\u0010r\u001a\u0005\b\u008a\u0001\u0010\u0013\"\u0005\b\u008b\u0001\u00107R\u0016\u0010\u008d\u0001\u001a\u00020\u00108VX\u0096\u0004¢\u0006\u0007\u001a\u0005\b\u008e\u0001\u0010\u0013R\u0016\u0010\u008f\u0001\u001a\u00020\u00108VX\u0096\u0004¢\u0006\u0007\u001a\u0005\b\u0090\u0001\u0010\u0013R\u001a\u0010\u0091\u0001\u001a\u0005\u0018\u00010\u0092\u00018VX\u0096\u0004¢\u0006\b\u001a\u0006\b\u0093\u0001\u0010\u0094\u0001R\u0018\u0010\u0095\u0001\u001a\u00020oX\u0080\u0004¢\u0006\u000b\n\u0002\u0010r\u001a\u0005\b\u0096\u0001\u0010qR\u0016\u0010£\u0001\u001a\u00020,8@X\u0080\u0004¢\u0006\u0007\u001a\u0005\b¤\u0001\u0010/R\u0010\u0010¥\u0001\u001a\u00030¦\u0001X\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006\u00ad\u0001"}, d2 = {"Landroidx/compose/foundation/lazy/LazyListState;", "Landroidx/compose/foundation/gestures/ScrollableState;", "firstVisibleItemIndex", "", "firstVisibleItemScrollOffset", "prefetchStrategy", "Landroidx/compose/foundation/lazy/LazyListPrefetchStrategy;", "<init>", "(IILandroidx/compose/foundation/lazy/LazyListPrefetchStrategy;)V", "cacheWindow", "Landroidx/compose/foundation/lazy/layout/LazyLayoutCacheWindow;", "(Landroidx/compose/foundation/lazy/layout/LazyLayoutCacheWindow;II)V", "(II)V", "getPrefetchStrategy$foundation", "()Landroidx/compose/foundation/lazy/LazyListPrefetchStrategy;", "value", "", "hasLookaheadOccurred", "getHasLookaheadOccurred$foundation", "()Z", "Landroidx/compose/foundation/lazy/LazyListMeasureResult;", "approachLayoutInfo", "getApproachLayoutInfo$foundation", "()Landroidx/compose/foundation/lazy/LazyListMeasureResult;", "executeRequestsInHighPriorityMode", "scrollPosition", "Landroidx/compose/foundation/lazy/LazyListScrollPosition;", "getFirstVisibleItemIndex", "()I", "getFirstVisibleItemScrollOffset", "layoutInfoState", "Landroidx/compose/runtime/MutableState;", "layoutInfo", "Landroidx/compose/foundation/lazy/LazyListLayoutInfo;", "getLayoutInfo", "()Landroidx/compose/foundation/lazy/LazyListLayoutInfo;", "interactionSource", "Landroidx/compose/foundation/interaction/InteractionSource;", "getInteractionSource", "()Landroidx/compose/foundation/interaction/InteractionSource;", "internalInteractionSource", "Landroidx/compose/foundation/interaction/MutableInteractionSource;", "getInternalInteractionSource$foundation", "()Landroidx/compose/foundation/interaction/MutableInteractionSource;", "", "scrollToBeConsumed", "getScrollToBeConsumed$foundation", "()F", "density", "Landroidx/compose/ui/unit/Density;", "getDensity$foundation", "()Landroidx/compose/ui/unit/Density;", "skipItemPlacementAnimation", "getSkipItemPlacementAnimation$foundation", "setSkipItemPlacementAnimation$foundation", "(Z)V", "scrollableState", "numMeasurePasses", "getNumMeasurePasses$foundation", "prefetchingEnabled", "getPrefetchingEnabled$foundation", "setPrefetchingEnabled$foundation", "Landroidx/compose/ui/layout/Remeasurement;", "remeasurement", "getRemeasurement$foundation", "()Landroidx/compose/ui/layout/Remeasurement;", "remeasurementModifier", "Landroidx/compose/ui/layout/RemeasurementModifier;", "getRemeasurementModifier$foundation", "()Landroidx/compose/ui/layout/RemeasurementModifier;", "awaitLayoutModifier", "Landroidx/compose/foundation/lazy/layout/AwaitFirstLayoutModifier;", "getAwaitLayoutModifier$foundation", "()Landroidx/compose/foundation/lazy/layout/AwaitFirstLayoutModifier;", "itemAnimator", "Landroidx/compose/foundation/lazy/layout/LazyLayoutItemAnimator;", "Landroidx/compose/foundation/lazy/LazyListMeasuredItem;", "getItemAnimator$foundation", "()Landroidx/compose/foundation/lazy/layout/LazyLayoutItemAnimator;", "beyondBoundsInfo", "Landroidx/compose/foundation/lazy/layout/LazyLayoutBeyondBoundsInfo;", "getBeyondBoundsInfo$foundation", "()Landroidx/compose/foundation/lazy/layout/LazyLayoutBeyondBoundsInfo;", "prefetchState", "Landroidx/compose/foundation/lazy/layout/LazyLayoutPrefetchState;", "getPrefetchState$foundation$annotations", "()V", "getPrefetchState$foundation", "()Landroidx/compose/foundation/lazy/layout/LazyLayoutPrefetchState;", "prefetchScope", "Landroidx/compose/foundation/lazy/LazyListPrefetchScope;", "_scrollIndicatorState", "androidx/compose/foundation/lazy/LazyListState$_scrollIndicatorState$1", "Landroidx/compose/foundation/lazy/LazyListState$_scrollIndicatorState$1;", "calculateScrollOffset", "pinnedItems", "Landroidx/compose/foundation/lazy/layout/LazyLayoutPinnedItemList;", "getPinnedItems$foundation", "()Landroidx/compose/foundation/lazy/layout/LazyLayoutPinnedItemList;", "nearestRange", "Lkotlin/ranges/IntRange;", "getNearestRange$foundation$delegate", "(Landroidx/compose/foundation/lazy/LazyListState;)Ljava/lang/Object;", "getNearestRange$foundation", "()Lkotlin/ranges/IntRange;", "scrollToItem", "", FirebaseAnalytics.Param.INDEX, "scrollOffset", "(IILkotlin/coroutines/Continuation;)Ljava/lang/Object;", "measurementScopeInvalidator", "Landroidx/compose/foundation/lazy/layout/ObservableScopeInvalidator;", "getMeasurementScopeInvalidator-zYiylxw$foundation", "()Landroidx/compose/runtime/MutableState;", "Landroidx/compose/runtime/MutableState;", "requestScrollToItem", "snapToItemIndexInternal", "forceRemeasure", "snapToItemIndexInternal$foundation", "scroll", "scrollPriority", "Landroidx/compose/foundation/MutatePriority;", BlockContactsIQ.ELEMENT, "Lkotlin/Function2;", "Landroidx/compose/foundation/gestures/ScrollScope;", "Lkotlin/coroutines/Continuation;", "", "Lkotlin/ExtensionFunctionType;", "(Landroidx/compose/foundation/MutatePriority;Lkotlin/jvm/functions/Function2;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "dispatchRawDelta", "delta", "isScrollInProgress", "<set-?>", "canScrollForward", "getCanScrollForward", "setCanScrollForward", "canScrollForward$delegate", "canScrollBackward", "getCanScrollBackward", "setCanScrollBackward", "canScrollBackward$delegate", "lastScrolledForward", "getLastScrolledForward", "lastScrolledBackward", "getLastScrolledBackward", "scrollIndicatorState", "Landroidx/compose/foundation/ScrollIndicatorState;", "getScrollIndicatorState", "()Landroidx/compose/foundation/ScrollIndicatorState;", "placementScopeInvalidator", "getPlacementScopeInvalidator-zYiylxw$foundation", "onScroll", "distance", "onScroll$foundation", "notifyPrefetchOnScroll", "animateScrollToItem", "applyMeasureResult", "result", "isLookingAhead", "visibleItemsStayedTheSame", "applyMeasureResult$foundation", "traceVisibleItems", "measureResult", "scrollDeltaBetweenPasses", "getScrollDeltaBetweenPasses$foundation", "_lazyLayoutScrollDeltaBetweenPasses", "Landroidx/compose/foundation/lazy/layout/LazyLayoutScrollDeltaBetweenPasses;", "updateScrollPositionIfTheFirstItemWasMoved", "itemProvider", "Landroidx/compose/foundation/lazy/LazyListItemProvider;", "firstItemIndex", "updateScrollPositionIfTheFirstItemWasMoved$foundation", "Companion", "foundation"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final class LazyListState implements ScrollableState {
    public static final int $stable = 0;

    /* JADX INFO: renamed from: Companion, reason: from kotlin metadata */
    public static final Companion INSTANCE = new Companion(null);
    private static final Saver<LazyListState, ?> Saver = ListSaverKt.listSaver(new Function2() { // from class: androidx.compose.foundation.lazy.LazyListState$$ExternalSyntheticLambda0
        @Override // kotlin.jvm.functions.Function2
        public final Object invoke(Object obj, Object obj2) {
            return LazyListState.Saver$lambda$0((SaverScope) obj, (LazyListState) obj2);
        }
    }, new Function1() { // from class: androidx.compose.foundation.lazy.LazyListState$$ExternalSyntheticLambda1
        @Override // kotlin.jvm.functions.Function1
        public final Object invoke(Object obj) {
            return LazyListState.Saver$lambda$1((List) obj);
        }
    });
    private final LazyLayoutScrollDeltaBetweenPasses _lazyLayoutScrollDeltaBetweenPasses;
    private final LazyListState$_scrollIndicatorState$1 _scrollIndicatorState;
    private LazyListMeasureResult approachLayoutInfo;
    private final AwaitFirstLayoutModifier awaitLayoutModifier;
    private final LazyLayoutBeyondBoundsInfo beyondBoundsInfo;

    /* JADX INFO: renamed from: canScrollBackward$delegate, reason: from kotlin metadata */
    private final MutableState canScrollBackward;

    /* JADX INFO: renamed from: canScrollForward$delegate, reason: from kotlin metadata */
    private final MutableState canScrollForward;
    private boolean executeRequestsInHighPriorityMode;
    private boolean hasLookaheadOccurred;
    private final MutableInteractionSource internalInteractionSource;
    private final LazyLayoutItemAnimator<LazyListMeasuredItem> itemAnimator;
    private final MutableState<LazyListMeasureResult> layoutInfoState;
    private final MutableState<Unit> measurementScopeInvalidator;
    private int numMeasurePasses;
    private final LazyLayoutPinnedItemList pinnedItems;
    private final MutableState<Unit> placementScopeInvalidator;
    private final LazyListPrefetchScope prefetchScope;
    private final LazyLayoutPrefetchState prefetchState;
    private final LazyListPrefetchStrategy prefetchStrategy;
    private boolean prefetchingEnabled;
    private Remeasurement remeasurement;
    private final RemeasurementModifier remeasurementModifier;
    private final LazyListScrollPosition scrollPosition;
    private float scrollToBeConsumed;
    private final ScrollableState scrollableState;
    private boolean skipItemPlacementAnimation;

    /* JADX INFO: renamed from: androidx.compose.foundation.lazy.LazyListState$animateScrollToItem$1, reason: invalid class name */
    /* JADX INFO: compiled from: LazyListState.kt */
    @Metadata(k = 3, mv = {2, 1, 0}, xi = 48)
    @DebugMetadata(c = "androidx.compose.foundation.lazy.LazyListState", f = "LazyListState.kt", i = {}, l = {585}, m = "animateScrollToItem", n = {}, s = {}, v = 1)
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
            return LazyListState.this.animateScrollToItem(0, 0, this);
        }
    }

    /* JADX INFO: renamed from: androidx.compose.foundation.lazy.LazyListState$scroll$1, reason: invalid class name and case insensitive filesystem */
    /* JADX INFO: compiled from: LazyListState.kt */
    @Metadata(k = 3, mv = {2, 1, 0}, xi = 48)
    @DebugMetadata(c = "androidx.compose.foundation.lazy.LazyListState", f = "LazyListState.kt", i = {0, 0}, l = {464, 466}, m = "scroll", n = {"scrollPriority", BlockContactsIQ.ELEMENT}, s = {"L$0", "L$1"}, v = 1)
    static final class C03321 extends ContinuationImpl {
        Object L$0;
        Object L$1;
        int label;
        /* synthetic */ Object result;

        C03321(Continuation<? super C03321> continuation) {
            super(continuation);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object obj) {
            this.result = obj;
            this.label |= Integer.MIN_VALUE;
            return LazyListState.this.scroll(null, null, this);
        }
    }

    public LazyListState() {
        this(0, 0, (LazyListPrefetchStrategy) null, 7, (DefaultConstructorMarker) null);
    }

    public static /* synthetic */ void getPrefetchState$foundation$annotations() {
    }

    /* JADX WARN: Type inference failed for: r4v3, types: [androidx.compose.foundation.lazy.LazyListState$_scrollIndicatorState$1] */
    public LazyListState(final int i, int i2, LazyListPrefetchStrategy lazyListPrefetchStrategy) {
        this.prefetchStrategy = lazyListPrefetchStrategy;
        LazyListScrollPosition lazyListScrollPosition = new LazyListScrollPosition(i, i2);
        this.scrollPosition = lazyListScrollPosition;
        this.layoutInfoState = SnapshotStateKt.mutableStateOf(LazyListStateKt.EmptyLazyListMeasureResult, SnapshotStateKt.neverEqualPolicy());
        this.internalInteractionSource = InteractionSourceKt.MutableInteractionSource();
        this.scrollableState = ScrollableStateKt.ScrollableState(new Function1() { // from class: androidx.compose.foundation.lazy.LazyListState$$ExternalSyntheticLambda2
            @Override // kotlin.jvm.functions.Function1
            public final Object invoke(Object obj) {
                return Float.valueOf(LazyListState.scrollableState$lambda$0(this.f$0, ((Float) obj).floatValue()));
            }
        });
        this.prefetchingEnabled = true;
        this.remeasurementModifier = new RemeasurementModifier() { // from class: androidx.compose.foundation.lazy.LazyListState$remeasurementModifier$1
            @Override // androidx.compose.ui.layout.RemeasurementModifier
            public void onRemeasurementAvailable(Remeasurement remeasurement) {
                this.this$0.remeasurement = remeasurement;
            }
        };
        this.awaitLayoutModifier = new AwaitFirstLayoutModifier();
        this.itemAnimator = new LazyLayoutItemAnimator<>();
        this.beyondBoundsInfo = new LazyLayoutBeyondBoundsInfo();
        this.prefetchState = new LazyLayoutPrefetchState(lazyListPrefetchStrategy.getPrefetchScheduler(), new Function1() { // from class: androidx.compose.foundation.lazy.LazyListState$$ExternalSyntheticLambda3
            @Override // kotlin.jvm.functions.Function1
            public final Object invoke(Object obj) {
                return LazyListState.prefetchState$lambda$0(this.f$0, i, (NestedPrefetchScope) obj);
            }
        });
        this.prefetchScope = new LazyListState$prefetchScope$1(this);
        this._scrollIndicatorState = new ScrollIndicatorState() { // from class: androidx.compose.foundation.lazy.LazyListState$_scrollIndicatorState$1
            @Override // androidx.compose.foundation.ScrollIndicatorState
            public int getScrollOffset() {
                return this.this$0.calculateScrollOffset();
            }

            @Override // androidx.compose.foundation.ScrollIndicatorState
            public int getContentSize() {
                return LazyListLayoutInfoKt.calculateContentSize(this.this$0.getLayoutInfo());
            }

            @Override // androidx.compose.foundation.ScrollIndicatorState
            public int getViewportSize() {
                return LazyListLayoutInfoKt.getSingleAxisViewportSize(this.this$0.getLayoutInfo());
            }
        };
        this.pinnedItems = new LazyLayoutPinnedItemList();
        lazyListScrollPosition.getNearestRangeState();
        this.measurementScopeInvalidator = ObservableScopeInvalidator.m1396constructorimpl$default(null, 1, null);
        this.canScrollForward = SnapshotStateKt__SnapshotStateKt.mutableStateOf$default(false, null, 2, null);
        this.canScrollBackward = SnapshotStateKt__SnapshotStateKt.mutableStateOf$default(false, null, 2, null);
        this.placementScopeInvalidator = ObservableScopeInvalidator.m1396constructorimpl$default(null, 1, null);
        this._lazyLayoutScrollDeltaBetweenPasses = new LazyLayoutScrollDeltaBetweenPasses();
    }

    public /* synthetic */ LazyListState(int i, int i2, LazyListPrefetchStrategy lazyListPrefetchStrategy, int i3, DefaultConstructorMarker defaultConstructorMarker) {
        this((i3 & 1) != 0 ? 0 : i, (i3 & 2) != 0 ? 0 : i2, (i3 & 4) != 0 ? LazyListPrefetchStrategyKt.LazyListPrefetchStrategy$default(0, 1, null) : lazyListPrefetchStrategy);
    }

    /* JADX INFO: renamed from: getPrefetchStrategy$foundation, reason: from getter */
    public final LazyListPrefetchStrategy getPrefetchStrategy() {
        return this.prefetchStrategy;
    }

    public /* synthetic */ LazyListState(LazyLayoutCacheWindow lazyLayoutCacheWindow, int i, int i2, int i3, DefaultConstructorMarker defaultConstructorMarker) {
        this(lazyLayoutCacheWindow, (i3 & 2) != 0 ? 0 : i, (i3 & 4) != 0 ? 0 : i2);
    }

    public LazyListState(LazyLayoutCacheWindow lazyLayoutCacheWindow, int i, int i2) {
        this(i, i2, new LazyListCacheWindowStrategy(lazyLayoutCacheWindow));
    }

    public /* synthetic */ LazyListState(int i, int i2, int i3, DefaultConstructorMarker defaultConstructorMarker) {
        this((i3 & 1) != 0 ? 0 : i, (i3 & 2) != 0 ? 0 : i2);
    }

    public LazyListState(int i, int i2) {
        this(i, i2, LazyListPrefetchStrategyKt.LazyListPrefetchStrategy$default(0, 1, null));
    }

    /* JADX INFO: renamed from: getHasLookaheadOccurred$foundation, reason: from getter */
    public final boolean getHasLookaheadOccurred() {
        return this.hasLookaheadOccurred;
    }

    /* JADX INFO: renamed from: getApproachLayoutInfo$foundation, reason: from getter */
    public final LazyListMeasureResult getApproachLayoutInfo() {
        return this.approachLayoutInfo;
    }

    public final int getFirstVisibleItemIndex() {
        return this.scrollPosition.getIndex();
    }

    public final int getFirstVisibleItemScrollOffset() {
        return this.scrollPosition.getScrollOffset();
    }

    public final LazyListLayoutInfo getLayoutInfo() {
        return this.layoutInfoState.getValue();
    }

    public final InteractionSource getInteractionSource() {
        return this.internalInteractionSource;
    }

    /* JADX INFO: renamed from: getInternalInteractionSource$foundation, reason: from getter */
    public final MutableInteractionSource getInternalInteractionSource() {
        return this.internalInteractionSource;
    }

    /* JADX INFO: renamed from: getScrollToBeConsumed$foundation, reason: from getter */
    public final float getScrollToBeConsumed() {
        return this.scrollToBeConsumed;
    }

    public final Density getDensity$foundation() {
        return this.layoutInfoState.getValue().getDensity();
    }

    /* JADX INFO: renamed from: getSkipItemPlacementAnimation$foundation, reason: from getter */
    public final boolean getSkipItemPlacementAnimation() {
        return this.skipItemPlacementAnimation;
    }

    public final void setSkipItemPlacementAnimation$foundation(boolean z) {
        this.skipItemPlacementAnimation = z;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final float scrollableState$lambda$0(LazyListState lazyListState, float f2) {
        return -lazyListState.onScroll$foundation(-f2);
    }

    /* JADX INFO: renamed from: getNumMeasurePasses$foundation, reason: from getter */
    public final int getNumMeasurePasses() {
        return this.numMeasurePasses;
    }

    /* JADX INFO: renamed from: getPrefetchingEnabled$foundation, reason: from getter */
    public final boolean getPrefetchingEnabled() {
        return this.prefetchingEnabled;
    }

    public final void setPrefetchingEnabled$foundation(boolean z) {
        this.prefetchingEnabled = z;
    }

    /* JADX INFO: renamed from: getRemeasurement$foundation, reason: from getter */
    public final Remeasurement getRemeasurement() {
        return this.remeasurement;
    }

    /* JADX INFO: renamed from: getRemeasurementModifier$foundation, reason: from getter */
    public final RemeasurementModifier getRemeasurementModifier() {
        return this.remeasurementModifier;
    }

    /* JADX INFO: renamed from: getAwaitLayoutModifier$foundation, reason: from getter */
    public final AwaitFirstLayoutModifier getAwaitLayoutModifier() {
        return this.awaitLayoutModifier;
    }

    public final LazyLayoutItemAnimator<LazyListMeasuredItem> getItemAnimator$foundation() {
        return this.itemAnimator;
    }

    /* JADX INFO: renamed from: getBeyondBoundsInfo$foundation, reason: from getter */
    public final LazyLayoutBeyondBoundsInfo getBeyondBoundsInfo() {
        return this.beyondBoundsInfo;
    }

    /* JADX INFO: renamed from: getPrefetchState$foundation, reason: from getter */
    public final LazyLayoutPrefetchState getPrefetchState() {
        return this.prefetchState;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit prefetchState$lambda$0(LazyListState lazyListState, int i, NestedPrefetchScope nestedPrefetchScope) {
        LazyListPrefetchStrategy lazyListPrefetchStrategy = lazyListState.prefetchStrategy;
        Snapshot.Companion companion = Snapshot.INSTANCE;
        Snapshot currentThreadSnapshot = companion.getCurrentThreadSnapshot();
        companion.restoreNonObservable(currentThreadSnapshot, companion.makeCurrentNonObservable(currentThreadSnapshot), currentThreadSnapshot != null ? currentThreadSnapshot.getReadObserver() : null);
        lazyListPrefetchStrategy.onNestedPrefetch(nestedPrefetchScope, i);
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final int calculateScrollOffset() {
        return (LazyListLayoutInfoKt.visibleItemsAverageSize(getLayoutInfo()) * getFirstVisibleItemIndex()) + getFirstVisibleItemScrollOffset();
    }

    /* JADX INFO: renamed from: getPinnedItems$foundation, reason: from getter */
    public final LazyLayoutPinnedItemList getPinnedItems() {
        return this.pinnedItems;
    }

    public final IntRange getNearestRange$foundation() {
        return this.scrollPosition.getNearestRangeState().getValue();
    }

    /* JADX INFO: renamed from: androidx.compose.foundation.lazy.LazyListState$scrollToItem$2, reason: invalid class name and case insensitive filesystem */
    /* JADX INFO: compiled from: LazyListState.kt */
    @Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\n"}, d2 = {"<anonymous>", "", "Landroidx/compose/foundation/gestures/ScrollScope;"}, k = 3, mv = {2, 1, 0}, xi = 48)
    @DebugMetadata(c = "androidx.compose.foundation.lazy.LazyListState$scrollToItem$2", f = "LazyListState.kt", i = {}, l = {}, m = "invokeSuspend", n = {}, s = {}, v = 1)
    static final class C03332 extends SuspendLambda implements Function2<ScrollScope, Continuation<? super Unit>, Object> {
        final /* synthetic */ int $index;
        final /* synthetic */ int $scrollOffset;
        int label;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        C03332(int i, int i2, Continuation<? super C03332> continuation) {
            super(2, continuation);
            this.$index = i;
            this.$scrollOffset = i2;
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
            return LazyListState.this.new C03332(this.$index, this.$scrollOffset, continuation);
        }

        @Override // kotlin.jvm.functions.Function2
        public final Object invoke(ScrollScope scrollScope, Continuation<? super Unit> continuation) {
            return ((C03332) create(scrollScope, continuation)).invokeSuspend(Unit.INSTANCE);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object obj) {
            IntrinsicsKt.getCOROUTINE_SUSPENDED();
            if (this.label != 0) {
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
            }
            ResultKt.throwOnFailure(obj);
            LazyListState.this.snapToItemIndexInternal$foundation(this.$index, this.$scrollOffset, true);
            return Unit.INSTANCE;
        }
    }

    public static /* synthetic */ Object scrollToItem$default(LazyListState lazyListState, int i, int i2, Continuation continuation, int i3, Object obj) {
        if ((i3 & 2) != 0) {
            i2 = 0;
        }
        return lazyListState.scrollToItem(i, i2, continuation);
    }

    public final Object scrollToItem(int i, int i2, Continuation<? super Unit> continuation) {
        Object objScroll$default = ScrollableState.scroll$default(this, null, new C03332(i, i2, null), continuation, 1, null);
        return objScroll$default == IntrinsicsKt.getCOROUTINE_SUSPENDED() ? objScroll$default : Unit.INSTANCE;
    }

    /* JADX INFO: renamed from: getMeasurementScopeInvalidator-zYiylxw$foundation, reason: not valid java name */
    public final MutableState<Unit> m1308getMeasurementScopeInvalidatorzYiylxw$foundation() {
        return this.measurementScopeInvalidator;
    }

    public static /* synthetic */ void requestScrollToItem$default(LazyListState lazyListState, int i, int i2, int i3, Object obj) {
        if ((i3 & 2) != 0) {
            i2 = 0;
        }
        lazyListState.requestScrollToItem(i, i2);
    }

    /* JADX INFO: renamed from: androidx.compose.foundation.lazy.LazyListState$requestScrollToItem$1, reason: invalid class name and case insensitive filesystem */
    /* JADX INFO: compiled from: LazyListState.kt */
    @Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\n"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {2, 1, 0}, xi = 48)
    @DebugMetadata(c = "androidx.compose.foundation.lazy.LazyListState$requestScrollToItem$1", f = "LazyListState.kt", i = {}, l = {HttpStatus.SC_UNSUPPORTED_MEDIA_TYPE}, m = "invokeSuspend", n = {}, s = {}, v = 1)
    static final class C03311 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
        int label;

        C03311(Continuation<? super C03311> continuation) {
            super(2, continuation);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
            return LazyListState.this.new C03311(continuation);
        }

        @Override // kotlin.jvm.functions.Function2
        public final Object invoke(CoroutineScope coroutineScope, Continuation<? super Unit> continuation) {
            return ((C03311) create(coroutineScope, continuation)).invokeSuspend(Unit.INSTANCE);
        }

        /* JADX INFO: renamed from: androidx.compose.foundation.lazy.LazyListState$requestScrollToItem$1$1, reason: invalid class name and collision with other inner class name */
        /* JADX INFO: compiled from: LazyListState.kt */
        @Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\n"}, d2 = {"<anonymous>", "", "Landroidx/compose/foundation/gestures/ScrollScope;"}, k = 3, mv = {2, 1, 0}, xi = 48)
        @DebugMetadata(c = "androidx.compose.foundation.lazy.LazyListState$requestScrollToItem$1$1", f = "LazyListState.kt", i = {}, l = {}, m = "invokeSuspend", n = {}, s = {}, v = 1)
        static final class C00231 extends SuspendLambda implements Function2<ScrollScope, Continuation<? super Unit>, Object> {
            int label;

            C00231(Continuation<? super C00231> continuation) {
                super(2, continuation);
            }

            @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
            public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
                return new C00231(continuation);
            }

            @Override // kotlin.jvm.functions.Function2
            public final Object invoke(ScrollScope scrollScope, Continuation<? super Unit> continuation) {
                return ((C00231) create(scrollScope, continuation)).invokeSuspend(Unit.INSTANCE);
            }

            @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
            public final Object invokeSuspend(Object obj) {
                IntrinsicsKt.getCOROUTINE_SUSPENDED();
                if (this.label != 0) {
                    throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                }
                ResultKt.throwOnFailure(obj);
                return Unit.INSTANCE;
            }
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object obj) {
            Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
            int i = this.label;
            if (i == 0) {
                ResultKt.throwOnFailure(obj);
                this.label = 1;
                if (ScrollableState.scroll$default(LazyListState.this, null, new C00231(null), this, 1, null) == coroutine_suspended) {
                    return coroutine_suspended;
                }
            } else {
                if (i != 1) {
                    throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                }
                ResultKt.throwOnFailure(obj);
            }
            return Unit.INSTANCE;
        }
    }

    public final void requestScrollToItem(int index, int scrollOffset) {
        if (isScrollInProgress()) {
            BuildersKt__Builders_commonKt.launch$default(this.layoutInfoState.getValue().getCoroutineScope(), null, null, new C03311(null), 3, null);
        }
        snapToItemIndexInternal$foundation(index, scrollOffset, false);
    }

    public final void snapToItemIndexInternal$foundation(int index, int scrollOffset, boolean forceRemeasure) {
        if (this.scrollPosition.getIndex() != index || this.scrollPosition.getScrollOffset() != scrollOffset) {
            this.itemAnimator.reset();
            Object obj = this.prefetchStrategy;
            CacheWindowLogic cacheWindowLogic = obj instanceof CacheWindowLogic ? (CacheWindowLogic) obj : null;
            if (cacheWindowLogic != null) {
                cacheWindowLogic.resetStrategy();
            }
        }
        this.scrollPosition.requestPositionAndForgetLastKnownKey(index, scrollOffset);
        if (forceRemeasure) {
            Remeasurement remeasurement = this.remeasurement;
            if (remeasurement != null) {
                remeasurement.forceRemeasure();
                return;
            }
            return;
        }
        ObservableScopeInvalidator.m1400invalidateScopeimpl(this.measurementScopeInvalidator);
    }

    /* JADX WARN: Code restructure failed: missing block: B:22:0x006f, code lost:
    
        if (r9.scroll(r7, r8, r0) == r1) goto L23;
     */
    /* JADX WARN: Removed duplicated region for block: B:7:0x0014  */
    @Override // androidx.compose.foundation.gestures.ScrollableState
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public java.lang.Object scroll(androidx.compose.foundation.MutatePriority r7, kotlin.jvm.functions.Function2<? super androidx.compose.foundation.gestures.ScrollScope, ? super kotlin.coroutines.Continuation<? super kotlin.Unit>, ? extends java.lang.Object> r8, kotlin.coroutines.Continuation<? super kotlin.Unit> r9) {
        /*
            r6 = this;
            boolean r0 = r9 instanceof androidx.compose.foundation.lazy.LazyListState.C03321
            if (r0 == 0) goto L14
            r0 = r9
            androidx.compose.foundation.lazy.LazyListState$scroll$1 r0 = (androidx.compose.foundation.lazy.LazyListState.C03321) r0
            int r1 = r0.label
            r2 = -2147483648(0xffffffff80000000, float:-0.0)
            r1 = r1 & r2
            if (r1 == 0) goto L14
            int r9 = r0.label
            int r9 = r9 - r2
            r0.label = r9
            goto L19
        L14:
            androidx.compose.foundation.lazy.LazyListState$scroll$1 r0 = new androidx.compose.foundation.lazy.LazyListState$scroll$1
            r0.<init>(r9)
        L19:
            java.lang.Object r9 = r0.result
            java.lang.Object r1 = kotlin.coroutines.intrinsics.IntrinsicsKt.getCOROUTINE_SUSPENDED()
            int r2 = r0.label
            r3 = 2
            r4 = 1
            if (r2 == 0) goto L44
            if (r2 == r4) goto L35
            if (r2 != r3) goto L2d
            kotlin.ResultKt.throwOnFailure(r9)
            goto L72
        L2d:
            java.lang.IllegalStateException r7 = new java.lang.IllegalStateException
            java.lang.String r8 = "call to 'resume' before 'invoke' with coroutine"
            r7.<init>(r8)
            throw r7
        L35:
            java.lang.Object r7 = r0.L$1
            kotlin.jvm.functions.Function2 r7 = (kotlin.jvm.functions.Function2) r7
            java.lang.Object r8 = r0.L$0
            androidx.compose.foundation.MutatePriority r8 = (androidx.compose.foundation.MutatePriority) r8
            kotlin.ResultKt.throwOnFailure(r9)
            r5 = r8
            r8 = r7
            r7 = r5
            goto L62
        L44:
            kotlin.ResultKt.throwOnFailure(r9)
            androidx.compose.runtime.MutableState<androidx.compose.foundation.lazy.LazyListMeasureResult> r9 = r6.layoutInfoState
            java.lang.Object r9 = r9.getValue()
            androidx.compose.foundation.lazy.LazyListMeasureResult r2 = androidx.compose.foundation.lazy.LazyListStateKt.access$getEmptyLazyListMeasureResult$p()
            if (r9 != r2) goto L62
            androidx.compose.foundation.lazy.layout.AwaitFirstLayoutModifier r9 = r6.awaitLayoutModifier
            r0.L$0 = r7
            r0.L$1 = r8
            r0.label = r4
            java.lang.Object r9 = r9.waitForFirstLayout(r0)
            if (r9 != r1) goto L62
            goto L71
        L62:
            androidx.compose.foundation.gestures.ScrollableState r9 = r6.scrollableState
            r2 = 0
            r0.L$0 = r2
            r0.L$1 = r2
            r0.label = r3
            java.lang.Object r7 = r9.scroll(r7, r8, r0)
            if (r7 != r1) goto L72
        L71:
            return r1
        L72:
            kotlin.Unit r7 = kotlin.Unit.INSTANCE
            return r7
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.compose.foundation.lazy.LazyListState.scroll(androidx.compose.foundation.MutatePriority, kotlin.jvm.functions.Function2, kotlin.coroutines.Continuation):java.lang.Object");
    }

    @Override // androidx.compose.foundation.gestures.ScrollableState
    public float dispatchRawDelta(float delta) {
        return this.scrollableState.dispatchRawDelta(delta);
    }

    @Override // androidx.compose.foundation.gestures.ScrollableState
    public boolean isScrollInProgress() {
        return this.scrollableState.isScrollInProgress();
    }

    private void setCanScrollForward(boolean z) {
        this.canScrollForward.setValue(Boolean.valueOf(z));
    }

    /* JADX WARN: Multi-variable type inference failed */
    @Override // androidx.compose.foundation.gestures.ScrollableState
    public boolean getCanScrollForward() {
        return ((Boolean) this.canScrollForward.getValue()).booleanValue();
    }

    private void setCanScrollBackward(boolean z) {
        this.canScrollBackward.setValue(Boolean.valueOf(z));
    }

    /* JADX WARN: Multi-variable type inference failed */
    @Override // androidx.compose.foundation.gestures.ScrollableState
    public boolean getCanScrollBackward() {
        return ((Boolean) this.canScrollBackward.getValue()).booleanValue();
    }

    @Override // androidx.compose.foundation.gestures.ScrollableState
    public boolean getLastScrolledForward() {
        return this.scrollableState.getLastScrolledForward();
    }

    @Override // androidx.compose.foundation.gestures.ScrollableState
    public boolean getLastScrolledBackward() {
        return this.scrollableState.getLastScrolledBackward();
    }

    @Override // androidx.compose.foundation.gestures.ScrollableState
    public ScrollIndicatorState getScrollIndicatorState() {
        return this._scrollIndicatorState;
    }

    /* JADX INFO: renamed from: getPlacementScopeInvalidator-zYiylxw$foundation, reason: not valid java name */
    public final MutableState<Unit> m1309getPlacementScopeInvalidatorzYiylxw$foundation() {
        return this.placementScopeInvalidator;
    }

    public final float onScroll$foundation(float distance) {
        LazyListMeasureResult lazyListMeasureResult;
        if ((distance < 0.0f && !getCanScrollForward()) || (distance > 0.0f && !getCanScrollBackward())) {
            return 0.0f;
        }
        if (!(Math.abs(this.scrollToBeConsumed) <= 0.5f)) {
            InlineClassHelperKt.throwIllegalStateException("entered drag with non-zero pending scroll");
        }
        this.executeRequestsInHighPriorityMode = true;
        float f2 = this.scrollToBeConsumed + distance;
        this.scrollToBeConsumed = f2;
        if (Math.abs(f2) > 0.5f) {
            float f3 = this.scrollToBeConsumed;
            int iRound = Math.round(f3);
            LazyListMeasureResult lazyListMeasureResultCopyWithScrollDeltaWithoutRemeasure = this.layoutInfoState.getValue().copyWithScrollDeltaWithoutRemeasure(iRound, !this.hasLookaheadOccurred);
            if (lazyListMeasureResultCopyWithScrollDeltaWithoutRemeasure != null && (lazyListMeasureResult = this.approachLayoutInfo) != null) {
                LazyListMeasureResult lazyListMeasureResultCopyWithScrollDeltaWithoutRemeasure2 = lazyListMeasureResult != null ? lazyListMeasureResult.copyWithScrollDeltaWithoutRemeasure(iRound, true) : null;
                if (lazyListMeasureResultCopyWithScrollDeltaWithoutRemeasure2 != null) {
                    this.approachLayoutInfo = lazyListMeasureResultCopyWithScrollDeltaWithoutRemeasure2;
                } else {
                    lazyListMeasureResultCopyWithScrollDeltaWithoutRemeasure = null;
                }
            }
            if (lazyListMeasureResultCopyWithScrollDeltaWithoutRemeasure != null) {
                applyMeasureResult$foundation(lazyListMeasureResultCopyWithScrollDeltaWithoutRemeasure, this.hasLookaheadOccurred, true);
                ObservableScopeInvalidator.m1400invalidateScopeimpl(this.placementScopeInvalidator);
                notifyPrefetchOnScroll(f3 - this.scrollToBeConsumed, lazyListMeasureResultCopyWithScrollDeltaWithoutRemeasure);
            } else {
                Remeasurement remeasurement = this.remeasurement;
                if (remeasurement != null) {
                    remeasurement.forceRemeasure();
                }
                notifyPrefetchOnScroll(f3 - this.scrollToBeConsumed, getLayoutInfo());
            }
        }
        if (Math.abs(this.scrollToBeConsumed) <= 0.5f) {
            return distance;
        }
        float f4 = distance - this.scrollToBeConsumed;
        this.scrollToBeConsumed = 0.0f;
        return f4;
    }

    private final void notifyPrefetchOnScroll(float delta, LazyListLayoutInfo layoutInfo) {
        if (this.prefetchingEnabled) {
            this.prefetchStrategy.onScroll(this.prefetchScope, delta, layoutInfo);
        }
    }

    public static /* synthetic */ Object animateScrollToItem$default(LazyListState lazyListState, int i, int i2, Continuation continuation, int i3, Object obj) {
        if ((i3 & 2) != 0) {
            i2 = 0;
        }
        return lazyListState.animateScrollToItem(i, i2, continuation);
    }

    /* JADX WARN: Removed duplicated region for block: B:7:0x0014  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final java.lang.Object animateScrollToItem(int r9, int r10, kotlin.coroutines.Continuation<? super kotlin.Unit> r11) {
        /*
            r8 = this;
            boolean r0 = r11 instanceof androidx.compose.foundation.lazy.LazyListState.AnonymousClass1
            if (r0 == 0) goto L14
            r0 = r11
            androidx.compose.foundation.lazy.LazyListState$animateScrollToItem$1 r0 = (androidx.compose.foundation.lazy.LazyListState.AnonymousClass1) r0
            int r1 = r0.label
            r2 = -2147483648(0xffffffff80000000, float:-0.0)
            r1 = r1 & r2
            if (r1 == 0) goto L14
            int r11 = r0.label
            int r11 = r11 - r2
            r0.label = r11
            goto L19
        L14:
            androidx.compose.foundation.lazy.LazyListState$animateScrollToItem$1 r0 = new androidx.compose.foundation.lazy.LazyListState$animateScrollToItem$1
            r0.<init>(r11)
        L19:
            r4 = r0
            java.lang.Object r11 = r4.result
            java.lang.Object r0 = kotlin.coroutines.intrinsics.IntrinsicsKt.getCOROUTINE_SUSPENDED()
            int r1 = r4.label
            r7 = 0
            r2 = 1
            if (r1 == 0) goto L37
            if (r1 != r2) goto L2f
            kotlin.ResultKt.throwOnFailure(r11)     // Catch: java.lang.Throwable -> L2c
            goto L54
        L2c:
            r0 = move-exception
            r9 = r0
            goto L59
        L2f:
            java.lang.IllegalStateException r9 = new java.lang.IllegalStateException
            java.lang.String r10 = "call to 'resume' before 'invoke' with coroutine"
            r9.<init>(r10)
            throw r9
        L37:
            kotlin.ResultKt.throwOnFailure(r11)
            r8.skipItemPlacementAnimation = r2     // Catch: java.lang.Throwable -> L2c
            r1 = r8
            androidx.compose.foundation.gestures.ScrollableState r1 = (androidx.compose.foundation.gestures.ScrollableState) r1     // Catch: java.lang.Throwable -> L2c
            androidx.compose.foundation.lazy.LazyListState$animateScrollToItem$2 r11 = new androidx.compose.foundation.lazy.LazyListState$animateScrollToItem$2     // Catch: java.lang.Throwable -> L2c
            r3 = 0
            r11.<init>(r9, r10, r3)     // Catch: java.lang.Throwable -> L2c
            r3 = r11
            kotlin.jvm.functions.Function2 r3 = (kotlin.jvm.functions.Function2) r3     // Catch: java.lang.Throwable -> L2c
            r4.label = r2     // Catch: java.lang.Throwable -> L2c
            r2 = 0
            r5 = 1
            r6 = 0
            java.lang.Object r9 = androidx.compose.foundation.gestures.ScrollableState.scroll$default(r1, r2, r3, r4, r5, r6)     // Catch: java.lang.Throwable -> L2c
            if (r9 != r0) goto L54
            return r0
        L54:
            r8.skipItemPlacementAnimation = r7
            kotlin.Unit r9 = kotlin.Unit.INSTANCE
            return r9
        L59:
            r8.skipItemPlacementAnimation = r7
            throw r9
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.compose.foundation.lazy.LazyListState.animateScrollToItem(int, int, kotlin.coroutines.Continuation):java.lang.Object");
    }

    /* JADX INFO: renamed from: androidx.compose.foundation.lazy.LazyListState$animateScrollToItem$2, reason: invalid class name */
    /* JADX INFO: compiled from: LazyListState.kt */
    @Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\n"}, d2 = {"<anonymous>", "", "Landroidx/compose/foundation/gestures/ScrollScope;"}, k = 3, mv = {2, 1, 0}, xi = 48)
    @DebugMetadata(c = "androidx.compose.foundation.lazy.LazyListState$animateScrollToItem$2", f = "LazyListState.kt", i = {}, l = {587}, m = "invokeSuspend", n = {}, s = {}, v = 1)
    static final class AnonymousClass2 extends SuspendLambda implements Function2<ScrollScope, Continuation<? super Unit>, Object> {
        final /* synthetic */ int $index;
        final /* synthetic */ int $scrollOffset;
        private /* synthetic */ Object L$0;
        int label;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        AnonymousClass2(int i, int i2, Continuation<? super AnonymousClass2> continuation) {
            super(2, continuation);
            this.$index = i;
            this.$scrollOffset = i2;
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
            AnonymousClass2 anonymousClass2 = LazyListState.this.new AnonymousClass2(this.$index, this.$scrollOffset, continuation);
            anonymousClass2.L$0 = obj;
            return anonymousClass2;
        }

        @Override // kotlin.jvm.functions.Function2
        public final Object invoke(ScrollScope scrollScope, Continuation<? super Unit> continuation) {
            return ((AnonymousClass2) create(scrollScope, continuation)).invokeSuspend(Unit.INSTANCE);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object obj) {
            Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
            int i = this.label;
            if (i == 0) {
                ResultKt.throwOnFailure(obj);
                ScrollScope scrollScope = (ScrollScope) this.L$0;
                this.label = 1;
                if (LazyLayoutScrollScopeKt.animateScrollToItem(LazyListScrollScopeKt.LazyLayoutScrollScope(LazyListState.this, scrollScope), this.$index, this.$scrollOffset, 100, LazyListState.this.getDensity$foundation(), this) == coroutine_suspended) {
                    return coroutine_suspended;
                }
            } else {
                if (i != 1) {
                    throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                }
                ResultKt.throwOnFailure(obj);
            }
            return Unit.INSTANCE;
        }
    }

    public static /* synthetic */ void applyMeasureResult$foundation$default(LazyListState lazyListState, LazyListMeasureResult lazyListMeasureResult, boolean z, boolean z2, int i, Object obj) {
        if ((i & 4) != 0) {
            z2 = false;
        }
        lazyListState.applyMeasureResult$foundation(lazyListMeasureResult, z, z2);
    }

    public final void applyMeasureResult$foundation(LazyListMeasureResult result, boolean isLookingAhead, boolean visibleItemsStayedTheSame) {
        LazyListMeasuredItem firstVisibleItem;
        this.prefetchState.setIdealNestedPrefetchCount$foundation(result.getVisibleItemsInfo().size());
        if (!isLookingAhead && this.hasLookaheadOccurred) {
            this.approachLayoutInfo = result;
            Snapshot.Companion companion = Snapshot.INSTANCE;
            Snapshot currentThreadSnapshot = companion.getCurrentThreadSnapshot();
            Function1<Object, Unit> readObserver = currentThreadSnapshot != null ? currentThreadSnapshot.getReadObserver() : null;
            Snapshot snapshotMakeCurrentNonObservable = companion.makeCurrentNonObservable(currentThreadSnapshot);
            try {
                if (this._lazyLayoutScrollDeltaBetweenPasses.isActive$foundation() && (firstVisibleItem = result.getFirstVisibleItem()) != null && firstVisibleItem.getIndex() == this.scrollPosition.getIndex() && result.getFirstVisibleItemScrollOffset() == this.scrollPosition.getScrollOffset()) {
                    this._lazyLayoutScrollDeltaBetweenPasses.stop$foundation();
                }
                Unit unit = Unit.INSTANCE;
                return;
            } finally {
                companion.restoreNonObservable(currentThreadSnapshot, snapshotMakeCurrentNonObservable, readObserver);
            }
        }
        if (isLookingAhead) {
            this.hasLookaheadOccurred = true;
        }
        setCanScrollBackward(result.getCanScrollBackward());
        setCanScrollForward(result.getCanScrollForward());
        this.scrollToBeConsumed -= result.getConsumedScroll();
        this.layoutInfoState.setValue(result);
        if (visibleItemsStayedTheSame) {
            this.scrollPosition.updateScrollOffset(result.getFirstVisibleItemScrollOffset());
        } else {
            traceVisibleItems(result);
            this.scrollPosition.updateFromMeasureResult(result);
            if (this.prefetchingEnabled) {
                this.prefetchStrategy.onVisibleItemsUpdated(this.prefetchScope, result);
            }
        }
        if (isLookingAhead) {
            this._lazyLayoutScrollDeltaBetweenPasses.updateScrollDeltaForApproach$foundation(result.getScrollBackAmount(), result.getDensity(), result.getCoroutineScope());
        }
        this.numMeasurePasses++;
    }

    private final void traceVisibleItems(LazyListMeasureResult measureResult) {
        LazyListMeasuredItem lazyListMeasuredItem = (LazyListMeasuredItem) CollectionsKt.firstOrNull((List) measureResult.getVisibleItemsInfo());
        LazyListMeasuredItem lazyListMeasuredItem2 = (LazyListMeasuredItem) CollectionsKt.lastOrNull((List) measureResult.getVisibleItemsInfo());
        AndroidTrace_androidKt.traceValue("firstVisibleItem:index", lazyListMeasuredItem != null ? lazyListMeasuredItem.getIndex() : -1L);
        AndroidTrace_androidKt.traceValue("lastVisibleItem:index", lazyListMeasuredItem2 != null ? lazyListMeasuredItem2.getIndex() : -1L);
    }

    public final float getScrollDeltaBetweenPasses$foundation() {
        return this._lazyLayoutScrollDeltaBetweenPasses.getScrollDeltaBetweenPasses$foundation();
    }

    public final int updateScrollPositionIfTheFirstItemWasMoved$foundation(LazyListItemProvider itemProvider, int firstItemIndex) {
        return this.scrollPosition.updateScrollPositionIfTheFirstItemWasMoved(itemProvider, firstItemIndex);
    }

    /* JADX INFO: compiled from: LazyListState.kt */
    @Metadata(d1 = {"\u0000&\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\u001f\u0010\t\u001a\f\u0012\u0004\u0012\u00020\u0006\u0012\u0002\b\u00030\u00052\u0006\u0010\n\u001a\u00020\u000bH\u0000¢\u0006\u0002\b\fJ\u001f\u0010\t\u001a\f\u0012\u0004\u0012\u00020\u0006\u0012\u0002\b\u00030\u00052\u0006\u0010\r\u001a\u00020\u000eH\u0000¢\u0006\u0002\b\fR\u001b\u0010\u0004\u001a\f\u0012\u0004\u0012\u00020\u0006\u0012\u0002\b\u00030\u0005¢\u0006\b\n\u0000\u001a\u0004\b\u0007\u0010\b¨\u0006\u000f"}, d2 = {"Landroidx/compose/foundation/lazy/LazyListState$Companion;", "", "<init>", "()V", "Saver", "Landroidx/compose/runtime/saveable/Saver;", "Landroidx/compose/foundation/lazy/LazyListState;", "getSaver", "()Landroidx/compose/runtime/saveable/Saver;", "saver", "prefetchStrategy", "Landroidx/compose/foundation/lazy/LazyListPrefetchStrategy;", "saver$foundation", "cacheWindow", "Landroidx/compose/foundation/lazy/layout/LazyLayoutCacheWindow;", "foundation"}, k = 1, mv = {2, 1, 0}, xi = 48)
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        private Companion() {
        }

        public final Saver<LazyListState, ?> getSaver() {
            return LazyListState.Saver;
        }

        public final Saver<LazyListState, ?> saver$foundation(final LazyListPrefetchStrategy prefetchStrategy) {
            return ListSaverKt.listSaver(new Function2() { // from class: androidx.compose.foundation.lazy.LazyListState$Companion$$ExternalSyntheticLambda0
                @Override // kotlin.jvm.functions.Function2
                public final Object invoke(Object obj, Object obj2) {
                    return LazyListState.Companion.saver$lambda$0((SaverScope) obj, (LazyListState) obj2);
                }
            }, new Function1() { // from class: androidx.compose.foundation.lazy.LazyListState$Companion$$ExternalSyntheticLambda1
                @Override // kotlin.jvm.functions.Function1
                public final Object invoke(Object obj) {
                    return LazyListState.Companion.saver$lambda$1(prefetchStrategy, (List) obj);
                }
            });
        }

        /* JADX INFO: Access modifiers changed from: private */
        public static final List saver$lambda$0(SaverScope saverScope, LazyListState lazyListState) {
            return CollectionsKt.listOf((Object[]) new Integer[]{Integer.valueOf(lazyListState.getFirstVisibleItemIndex()), Integer.valueOf(lazyListState.getFirstVisibleItemScrollOffset())});
        }

        /* JADX INFO: Access modifiers changed from: private */
        public static final LazyListState saver$lambda$1(LazyListPrefetchStrategy lazyListPrefetchStrategy, List list) {
            return new LazyListState(((Number) list.get(0)).intValue(), ((Number) list.get(1)).intValue(), lazyListPrefetchStrategy);
        }

        public final Saver<LazyListState, ?> saver$foundation(final LazyLayoutCacheWindow cacheWindow) {
            return ListSaverKt.listSaver(new Function2() { // from class: androidx.compose.foundation.lazy.LazyListState$Companion$$ExternalSyntheticLambda2
                @Override // kotlin.jvm.functions.Function2
                public final Object invoke(Object obj, Object obj2) {
                    return LazyListState.Companion.saver$lambda$2((SaverScope) obj, (LazyListState) obj2);
                }
            }, new Function1() { // from class: androidx.compose.foundation.lazy.LazyListState$Companion$$ExternalSyntheticLambda3
                @Override // kotlin.jvm.functions.Function1
                public final Object invoke(Object obj) {
                    return LazyListState.Companion.saver$lambda$3(cacheWindow, (List) obj);
                }
            });
        }

        /* JADX INFO: Access modifiers changed from: private */
        public static final List saver$lambda$2(SaverScope saverScope, LazyListState lazyListState) {
            return CollectionsKt.listOf((Object[]) new Integer[]{Integer.valueOf(lazyListState.getFirstVisibleItemIndex()), Integer.valueOf(lazyListState.getFirstVisibleItemScrollOffset())});
        }

        /* JADX INFO: Access modifiers changed from: private */
        public static final LazyListState saver$lambda$3(LazyLayoutCacheWindow lazyLayoutCacheWindow, List list) {
            return new LazyListState(lazyLayoutCacheWindow, ((Number) list.get(0)).intValue(), ((Number) list.get(1)).intValue());
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final List Saver$lambda$0(SaverScope saverScope, LazyListState lazyListState) {
        return CollectionsKt.listOf((Object[]) new Integer[]{Integer.valueOf(lazyListState.getFirstVisibleItemIndex()), Integer.valueOf(lazyListState.getFirstVisibleItemScrollOffset())});
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final LazyListState Saver$lambda$1(List list) {
        return new LazyListState(((Number) list.get(0)).intValue(), ((Number) list.get(1)).intValue());
    }
}
