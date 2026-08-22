package androidx.compose.foundation.lazy.staggeredgrid;

import androidx.collection.IntObjectMapKt;
import androidx.collection.IntSet;
import androidx.collection.IntSetKt;
import androidx.collection.MutableIntObjectMap;
import androidx.collection.MutableIntSet;
import androidx.compose.foundation.MutatePriority;
import androidx.compose.foundation.ScrollIndicatorState;
import androidx.compose.foundation.gestures.Orientation;
import androidx.compose.foundation.gestures.ScrollExtensionsKt;
import androidx.compose.foundation.gestures.ScrollScope;
import androidx.compose.foundation.gestures.ScrollableState;
import androidx.compose.foundation.gestures.ScrollableStateKt;
import androidx.compose.foundation.interaction.InteractionSource;
import androidx.compose.foundation.interaction.InteractionSourceKt;
import androidx.compose.foundation.interaction.MutableInteractionSource;
import androidx.compose.foundation.internal.InlineClassHelperKt;
import androidx.compose.foundation.lazy.layout.AwaitFirstLayoutModifier;
import androidx.compose.foundation.lazy.layout.LazyLayoutBeyondBoundsInfo;
import androidx.compose.foundation.lazy.layout.LazyLayoutItemAnimator;
import androidx.compose.foundation.lazy.layout.LazyLayoutItemProvider;
import androidx.compose.foundation.lazy.layout.LazyLayoutPinnedItemList;
import androidx.compose.foundation.lazy.layout.LazyLayoutPrefetchState;
import androidx.compose.foundation.lazy.layout.LazyLayoutScrollDeltaBetweenPasses;
import androidx.compose.foundation.lazy.layout.LazyLayoutScrollScopeKt;
import androidx.compose.foundation.lazy.layout.ObservableScopeInvalidator;
import androidx.compose.foundation.lazy.layout.PrefetchScheduler;
import androidx.compose.runtime.MutableState;
import androidx.compose.runtime.SnapshotStateKt;
import androidx.compose.runtime.SnapshotStateKt__SnapshotStateKt;
import androidx.compose.runtime.saveable.ListSaverKt;
import androidx.compose.runtime.saveable.Saver;
import androidx.compose.runtime.saveable.SaverScope;
import androidx.compose.runtime.snapshots.Snapshot;
import androidx.compose.ui.layout.Remeasurement;
import androidx.compose.ui.layout.RemeasurementModifier;
import androidx.compose.ui.unit.Constraints;
import androidx.compose.ui.unit.IntOffset;
import com.google.firebase.analytics.FirebaseAnalytics;
import java.util.Arrays;
import java.util.List;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.collections.ArraysKt;
import kotlin.collections.CollectionsKt;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.ContinuationImpl;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.math.MathKt;
import kotlin.ranges.IntRange;
import kotlinx.coroutines.BuildersKt__Builders_commonKt;
import kotlinx.coroutines.CoroutineScope;
import org.jivesoftware.smackx.blocking.element.BlockContactsIQ;

/* JADX INFO: compiled from: LazyStaggeredGridState.kt */
/* JADX INFO: loaded from: classes.dex */
@Metadata(d1 = {"\u0000\u008b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0015\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\t\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0012\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\u0007\n\u0002\b\b\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0002\b\u0011\n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0018\u0002\n\u0002\b\t\n\u0002\u0018\u0002\n\u0002\b\u0004*\u0001&\b\u0007\u0018\u0000 ²\u00012\u00020\u0001:\u0002²\u0001B#\b\u0000\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0003\u0012\b\u0010\u0005\u001a\u0004\u0018\u00010\u0006¢\u0006\u0004\b\u0007\u0010\bB\u001d\b\u0016\u0012\b\b\u0002\u0010\t\u001a\u00020\n\u0012\b\b\u0002\u0010\u000b\u001a\u00020\n¢\u0006\u0004\b\u0007\u0010\fJ\b\u0010(\u001a\u00020\nH\u0002J\u0015\u0010X\u001a\u00020Y2\u0006\u0010Z\u001a\u00020\u000eH\u0000¢\u0006\u0002\b[JK\u0010\u0081\u0001\u001a\u00030\u0082\u00012\b\u0010\u0083\u0001\u001a\u00030\u0084\u00012.\u0010\u0085\u0001\u001a)\b\u0001\u0012\u0005\u0012\u00030\u0087\u0001\u0012\f\u0012\n\u0012\u0005\u0012\u00030\u0082\u00010\u0088\u0001\u0012\u0007\u0012\u0005\u0018\u00010\u0089\u00010\u0086\u0001¢\u0006\u0003\b\u008a\u0001H\u0096@¢\u0006\u0003\u0010\u008b\u0001J\u0012\u0010\u008d\u0001\u001a\u00020Y2\u0007\u0010\u008e\u0001\u001a\u00020YH\u0002J%\u0010\u008f\u0001\u001a\u00030\u0082\u00012\u0007\u0010\u0090\u0001\u001a\u00020\n2\t\b\u0002\u0010\u0091\u0001\u001a\u00020\nH\u0086@¢\u0006\u0003\u0010\u0092\u0001J%\u0010\u0093\u0001\u001a\u00030\u0082\u00012\u0007\u0010\u0090\u0001\u001a\u00020\n2\t\b\u0002\u0010\u0091\u0001\u001a\u00020\nH\u0086@¢\u0006\u0003\u0010\u0092\u0001J\u001e\u0010\u0096\u0001\u001a\u00030\u0082\u00012\t\b\u0001\u0010\u0090\u0001\u001a\u00020\n2\t\b\u0002\u0010\u0091\u0001\u001a\u00020\nJ+\u0010\u0097\u0001\u001a\u00030\u0082\u00012\u0007\u0010\u0090\u0001\u001a\u00020\n2\u0007\u0010\u0091\u0001\u001a\u00020\n2\u0007\u0010\u0098\u0001\u001a\u00020\u000eH\u0000¢\u0006\u0003\b\u0099\u0001J\"\u0010\u009a\u0001\u001a\u00020\u00032\b\u0010\u009b\u0001\u001a\u00030\u009c\u00012\u0007\u0010\u009d\u0001\u001a\u00020\u0003H\u0000¢\u0006\u0003\b\u009e\u0001J\u0012\u0010\u009f\u0001\u001a\u00020Y2\u0007\u0010 \u0001\u001a\u00020YH\u0016J\u001e\u0010¡\u0001\u001a\u00030\u0082\u00012\u0007\u0010 \u0001\u001a\u00020Y2\t\b\u0002\u0010¢\u0001\u001a\u00020\u0012H\u0002J\u0014\u0010£\u0001\u001a\u00030\u0082\u00012\b\u0010¤\u0001\u001a\u00030¥\u0001H\u0002J\u0013\u0010¦\u0001\u001a\u00030\u0082\u00012\u0007\u0010¢\u0001\u001a\u00020 H\u0002J,\u0010§\u0001\u001a\u00030\u0082\u00012\u0007\u0010¨\u0001\u001a\u00020\u00122\u0006\u0010Z\u001a\u00020\u000e2\t\b\u0002\u0010©\u0001\u001a\u00020\u000eH\u0000¢\u0006\u0003\bª\u0001J\u001a\u0010°\u0001\u001a\u00020\u00032\u0007\u0010±\u0001\u001a\u00020\n2\u0006\u0010d\u001a\u00020\nH\u0002R\u001e\u0010\u000f\u001a\u00020\u000e2\u0006\u0010\r\u001a\u00020\u000e@BX\u0080\u000e¢\u0006\b\n\u0000\u001a\u0004\b\u0010\u0010\u0011R\"\u0010\u0013\u001a\u0004\u0018\u00010\u00122\b\u0010\r\u001a\u0004\u0018\u00010\u0012@BX\u0080\u000e¢\u0006\b\n\u0000\u001a\u0004\b\u0014\u0010\u0015R\u0011\u0010\u0016\u001a\u00020\n8F¢\u0006\u0006\u001a\u0004\b\u0017\u0010\u0018R\u0011\u0010\u0019\u001a\u00020\n8F¢\u0006\u0006\u001a\u0004\b\u001a\u0010\u0018R\u0014\u0010\u001b\u001a\u00020\u001cX\u0080\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u001d\u0010\u001eR\u0011\u0010\u001f\u001a\u00020 8F¢\u0006\u0006\u001a\u0004\b!\u0010\"R\u0014\u0010#\u001a\b\u0012\u0004\u0012\u00020\u00120$X\u0082\u0004¢\u0006\u0002\n\u0000R\u0010\u0010%\u001a\u00020&X\u0082\u0004¢\u0006\u0004\n\u0002\u0010'R\u0014\u0010)\u001a\u00020*X\u0080\u0004¢\u0006\b\n\u0000\u001a\u0004\b+\u0010,R+\u0010.\u001a\u00020\u000e2\u0006\u0010-\u001a\u00020\u000e8V@RX\u0096\u008e\u0002¢\u0006\u0012\n\u0004\b2\u00103\u001a\u0004\b/\u0010\u0011\"\u0004\b0\u00101R+\u00104\u001a\u00020\u000e2\u0006\u0010-\u001a\u00020\u000e8V@RX\u0096\u008e\u0002¢\u0006\u0012\n\u0004\b7\u00103\u001a\u0004\b5\u0010\u0011\"\u0004\b6\u00101R\u0014\u00108\u001a\u00020\u000e8VX\u0096\u0004¢\u0006\u0006\u001a\u0004\b9\u0010\u0011R\u0014\u0010:\u001a\u00020\u000e8VX\u0096\u0004¢\u0006\u0006\u001a\u0004\b;\u0010\u0011R\u0016\u0010<\u001a\u0004\u0018\u00010=8VX\u0096\u0004¢\u0006\u0006\u001a\u0004\b>\u0010?R\"\u0010A\u001a\u0004\u0018\u00010@2\b\u0010\r\u001a\u0004\u0018\u00010@@BX\u0080\u000e¢\u0006\b\n\u0000\u001a\u0004\bB\u0010CR\u0014\u0010D\u001a\u00020EX\u0080\u0004¢\u0006\b\n\u0000\u001a\u0004\bF\u0010GR\u0014\u0010H\u001a\u00020IX\u0080\u0004¢\u0006\b\n\u0000\u001a\u0004\bJ\u0010KR\u0014\u0010L\u001a\u00020MX\u0080\u0004¢\u0006\b\n\u0000\u001a\u0004\bN\u0010OR\u001a\u0010P\u001a\u00020\u000eX\u0080\u000e¢\u0006\u000e\n\u0000\u001a\u0004\bQ\u0010\u0011\"\u0004\bR\u00101R\u0014\u0010S\u001a\u00020TX\u0080\u0004¢\u0006\b\n\u0000\u001a\u0004\bU\u0010VR\u000e\u0010W\u001a\u00020\u0001X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010X\u001a\u00020YX\u0082\u000e¢\u0006\u0002\n\u0000R\u001a\u0010\\\u001a\u00020\nX\u0080\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b]\u0010\u0018\"\u0004\b^\u0010_R\u000e\u0010`\u001a\u00020\nX\u0082\u000e¢\u0006\u0002\n\u0000R\u0014\u0010a\u001a\b\u0012\u0004\u0012\u00020c0bX\u0082\u0004¢\u0006\u0002\n\u0000R\u0014\u0010d\u001a\u00020\n8@X\u0080\u0004¢\u0006\u0006\u001a\u0004\be\u0010\u0018R\u0011\u0010f\u001a\u00020g8F¢\u0006\u0006\u001a\u0004\bh\u0010iR\u0014\u0010j\u001a\u00020kX\u0080\u0004¢\u0006\b\n\u0000\u001a\u0004\bl\u0010mR\u0014\u0010n\u001a\u00020oX\u0080\u0004¢\u0006\b\n\u0000\u001a\u0004\bp\u0010qR\u001a\u0010r\u001a\b\u0012\u0004\u0012\u00020t0sX\u0080\u0004¢\u0006\b\n\u0000\u001a\u0004\bu\u0010vR\u001b\u0010w\u001a\u00020x8@X\u0080\u0084\u0002¢\u0006\f\u001a\u0004\b{\u0010|*\u0004\by\u0010zR\u0017\u0010}\u001a\u00020~X\u0080\u0004¢\u0006\u000b\n\u0002\u00103\u001a\u0005\b\u007f\u0010\u0080\u0001R\u0016\u0010\u008c\u0001\u001a\u00020\u000e8VX\u0096\u0004¢\u0006\u0007\u001a\u0005\b\u008c\u0001\u0010\u0011R\u0019\u0010\u0094\u0001\u001a\u00020~X\u0080\u0004¢\u0006\f\n\u0002\u00103\u001a\u0006\b\u0095\u0001\u0010\u0080\u0001R\u0017\u0010«\u0001\u001a\u00020Y8@X\u0080\u0004¢\u0006\b\u001a\u0006\b¬\u0001\u0010\u00ad\u0001R\u0010\u0010®\u0001\u001a\u00030¯\u0001X\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006³\u0001"}, d2 = {"Landroidx/compose/foundation/lazy/staggeredgrid/LazyStaggeredGridState;", "Landroidx/compose/foundation/gestures/ScrollableState;", "initialFirstVisibleItems", "", "initialFirstVisibleOffsets", "prefetchScheduler", "Landroidx/compose/foundation/lazy/layout/PrefetchScheduler;", "<init>", "([I[ILandroidx/compose/foundation/lazy/layout/PrefetchScheduler;)V", "initialFirstVisibleItemIndex", "", "initialFirstVisibleItemOffset", "(II)V", "value", "", "hasLookaheadOccurred", "getHasLookaheadOccurred$foundation", "()Z", "Landroidx/compose/foundation/lazy/staggeredgrid/LazyStaggeredGridMeasureResult;", "approachLayoutInfo", "getApproachLayoutInfo$foundation", "()Landroidx/compose/foundation/lazy/staggeredgrid/LazyStaggeredGridMeasureResult;", "firstVisibleItemIndex", "getFirstVisibleItemIndex", "()I", "firstVisibleItemScrollOffset", "getFirstVisibleItemScrollOffset", "scrollPosition", "Landroidx/compose/foundation/lazy/staggeredgrid/LazyStaggeredGridScrollPosition;", "getScrollPosition$foundation", "()Landroidx/compose/foundation/lazy/staggeredgrid/LazyStaggeredGridScrollPosition;", "layoutInfo", "Landroidx/compose/foundation/lazy/staggeredgrid/LazyStaggeredGridLayoutInfo;", "getLayoutInfo", "()Landroidx/compose/foundation/lazy/staggeredgrid/LazyStaggeredGridLayoutInfo;", "layoutInfoState", "Landroidx/compose/runtime/MutableState;", "_scrollIndicatorState", "androidx/compose/foundation/lazy/staggeredgrid/LazyStaggeredGridState$_scrollIndicatorState$1", "Landroidx/compose/foundation/lazy/staggeredgrid/LazyStaggeredGridState$_scrollIndicatorState$1;", "calculateScrollOffset", "laneInfo", "Landroidx/compose/foundation/lazy/staggeredgrid/LazyStaggeredGridLaneInfo;", "getLaneInfo$foundation", "()Landroidx/compose/foundation/lazy/staggeredgrid/LazyStaggeredGridLaneInfo;", "<set-?>", "canScrollForward", "getCanScrollForward", "setCanScrollForward", "(Z)V", "canScrollForward$delegate", "Landroidx/compose/runtime/MutableState;", "canScrollBackward", "getCanScrollBackward", "setCanScrollBackward", "canScrollBackward$delegate", "lastScrolledForward", "getLastScrolledForward", "lastScrolledBackward", "getLastScrolledBackward", "scrollIndicatorState", "Landroidx/compose/foundation/ScrollIndicatorState;", "getScrollIndicatorState", "()Landroidx/compose/foundation/ScrollIndicatorState;", "Landroidx/compose/ui/layout/Remeasurement;", "remeasurement", "getRemeasurement$foundation", "()Landroidx/compose/ui/layout/Remeasurement;", "remeasurementModifier", "Landroidx/compose/ui/layout/RemeasurementModifier;", "getRemeasurementModifier$foundation", "()Landroidx/compose/ui/layout/RemeasurementModifier;", "awaitLayoutModifier", "Landroidx/compose/foundation/lazy/layout/AwaitFirstLayoutModifier;", "getAwaitLayoutModifier$foundation", "()Landroidx/compose/foundation/lazy/layout/AwaitFirstLayoutModifier;", "beyondBoundsInfo", "Landroidx/compose/foundation/lazy/layout/LazyLayoutBeyondBoundsInfo;", "getBeyondBoundsInfo$foundation", "()Landroidx/compose/foundation/lazy/layout/LazyLayoutBeyondBoundsInfo;", "prefetchingEnabled", "getPrefetchingEnabled$foundation", "setPrefetchingEnabled$foundation", "prefetchState", "Landroidx/compose/foundation/lazy/layout/LazyLayoutPrefetchState;", "getPrefetchState$foundation", "()Landroidx/compose/foundation/lazy/layout/LazyLayoutPrefetchState;", "scrollableState", "scrollToBeConsumed", "", "isLookingAhead", "scrollToBeConsumed$foundation", "measurePassCount", "getMeasurePassCount$foundation", "setMeasurePassCount$foundation", "(I)V", "prefetchBaseIndex", "currentItemPrefetchHandles", "Landroidx/collection/MutableIntObjectMap;", "Landroidx/compose/foundation/lazy/layout/LazyLayoutPrefetchState$PrefetchHandle;", "laneCount", "getLaneCount$foundation", "interactionSource", "Landroidx/compose/foundation/interaction/InteractionSource;", "getInteractionSource", "()Landroidx/compose/foundation/interaction/InteractionSource;", "mutableInteractionSource", "Landroidx/compose/foundation/interaction/MutableInteractionSource;", "getMutableInteractionSource$foundation", "()Landroidx/compose/foundation/interaction/MutableInteractionSource;", "pinnedItems", "Landroidx/compose/foundation/lazy/layout/LazyLayoutPinnedItemList;", "getPinnedItems$foundation", "()Landroidx/compose/foundation/lazy/layout/LazyLayoutPinnedItemList;", "itemAnimator", "Landroidx/compose/foundation/lazy/layout/LazyLayoutItemAnimator;", "Landroidx/compose/foundation/lazy/staggeredgrid/LazyStaggeredGridMeasuredItem;", "getItemAnimator$foundation", "()Landroidx/compose/foundation/lazy/layout/LazyLayoutItemAnimator;", "nearestRange", "Lkotlin/ranges/IntRange;", "getNearestRange$foundation$delegate", "(Landroidx/compose/foundation/lazy/staggeredgrid/LazyStaggeredGridState;)Ljava/lang/Object;", "getNearestRange$foundation", "()Lkotlin/ranges/IntRange;", "placementScopeInvalidator", "Landroidx/compose/foundation/lazy/layout/ObservableScopeInvalidator;", "getPlacementScopeInvalidator-zYiylxw$foundation", "()Landroidx/compose/runtime/MutableState;", "scroll", "", "scrollPriority", "Landroidx/compose/foundation/MutatePriority;", BlockContactsIQ.ELEMENT, "Lkotlin/Function2;", "Landroidx/compose/foundation/gestures/ScrollScope;", "Lkotlin/coroutines/Continuation;", "", "Lkotlin/ExtensionFunctionType;", "(Landroidx/compose/foundation/MutatePriority;Lkotlin/jvm/functions/Function2;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "isScrollInProgress", "onScroll", "distance", "scrollToItem", FirebaseAnalytics.Param.INDEX, "scrollOffset", "(IILkotlin/coroutines/Continuation;)Ljava/lang/Object;", "animateScrollToItem", "measurementScopeInvalidator", "getMeasurementScopeInvalidator-zYiylxw$foundation", "requestScrollToItem", "snapToItemInternal", "forceRemeasure", "snapToItemInternal$foundation", "updateScrollPositionIfTheFirstItemWasMoved", "itemProvider", "Landroidx/compose/foundation/lazy/layout/LazyLayoutItemProvider;", "firstItemIndex", "updateScrollPositionIfTheFirstItemWasMoved$foundation", "dispatchRawDelta", "delta", "notifyPrefetch", "info", "clearLeftoverPrefetchHandles", "prefetchHandlesUsed", "Landroidx/collection/IntSet;", "cancelPrefetchIfVisibleItemsChanged", "applyMeasureResult", "result", "visibleItemsStayedTheSame", "applyMeasureResult$foundation", "scrollDeltaBetweenPasses", "getScrollDeltaBetweenPasses$foundation", "()F", "_lazyLayoutScrollDeltaBetweenPasses", "Landroidx/compose/foundation/lazy/layout/LazyLayoutScrollDeltaBetweenPasses;", "fillNearestIndices", "itemIndex", "Companion", "foundation"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final class LazyStaggeredGridState implements ScrollableState {
    public static final int $stable = 0;

    /* JADX INFO: renamed from: Companion, reason: from kotlin metadata */
    public static final Companion INSTANCE = new Companion(null);
    private static final Saver<LazyStaggeredGridState, Object> Saver = ListSaverKt.listSaver(new Function2() { // from class: androidx.compose.foundation.lazy.staggeredgrid.LazyStaggeredGridState$$ExternalSyntheticLambda0
        @Override // kotlin.jvm.functions.Function2
        public final Object invoke(Object obj, Object obj2) {
            return LazyStaggeredGridState.Saver$lambda$0((SaverScope) obj, (LazyStaggeredGridState) obj2);
        }
    }, new Function1() { // from class: androidx.compose.foundation.lazy.staggeredgrid.LazyStaggeredGridState$$ExternalSyntheticLambda1
        @Override // kotlin.jvm.functions.Function1
        public final Object invoke(Object obj) {
            return LazyStaggeredGridState.Saver$lambda$1((List) obj);
        }
    });
    private final LazyLayoutScrollDeltaBetweenPasses _lazyLayoutScrollDeltaBetweenPasses;
    private final LazyStaggeredGridState$_scrollIndicatorState$1 _scrollIndicatorState;
    private LazyStaggeredGridMeasureResult approachLayoutInfo;
    private final AwaitFirstLayoutModifier awaitLayoutModifier;
    private final LazyLayoutBeyondBoundsInfo beyondBoundsInfo;

    /* JADX INFO: renamed from: canScrollBackward$delegate, reason: from kotlin metadata */
    private final MutableState canScrollBackward;

    /* JADX INFO: renamed from: canScrollForward$delegate, reason: from kotlin metadata */
    private final MutableState canScrollForward;
    private final MutableIntObjectMap<LazyLayoutPrefetchState.PrefetchHandle> currentItemPrefetchHandles;
    private boolean hasLookaheadOccurred;
    private final LazyLayoutItemAnimator<LazyStaggeredGridMeasuredItem> itemAnimator;
    private final LazyStaggeredGridLaneInfo laneInfo;
    private final MutableState<LazyStaggeredGridMeasureResult> layoutInfoState;
    private int measurePassCount;
    private final MutableState<Unit> measurementScopeInvalidator;
    private final MutableInteractionSource mutableInteractionSource;
    private final LazyLayoutPinnedItemList pinnedItems;
    private final MutableState<Unit> placementScopeInvalidator;
    private int prefetchBaseIndex;
    private final LazyLayoutPrefetchState prefetchState;
    private boolean prefetchingEnabled;
    private Remeasurement remeasurement;
    private final RemeasurementModifier remeasurementModifier;
    private final LazyStaggeredGridScrollPosition scrollPosition;
    private float scrollToBeConsumed;
    private final ScrollableState scrollableState;

    /* JADX INFO: renamed from: androidx.compose.foundation.lazy.staggeredgrid.LazyStaggeredGridState$scroll$1, reason: invalid class name and case insensitive filesystem */
    /* JADX INFO: compiled from: LazyStaggeredGridState.kt */
    @Metadata(k = 3, mv = {2, 1, 0}, xi = 48)
    @DebugMetadata(c = "androidx.compose.foundation.lazy.staggeredgrid.LazyStaggeredGridState", f = "LazyStaggeredGridState.kt", i = {0, 0}, l = {282, 284}, m = "scroll", n = {"scrollPriority", BlockContactsIQ.ELEMENT}, s = {"L$0", "L$1"}, v = 1)
    static final class C03561 extends ContinuationImpl {
        Object L$0;
        Object L$1;
        int label;
        /* synthetic */ Object result;

        C03561(Continuation<? super C03561> continuation) {
            super(continuation);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object obj) {
            this.result = obj;
            this.label |= Integer.MIN_VALUE;
            return LazyStaggeredGridState.this.scroll(null, null, this);
        }
    }

    /* JADX WARN: Type inference failed for: r4v3, types: [androidx.compose.foundation.lazy.staggeredgrid.LazyStaggeredGridState$_scrollIndicatorState$1] */
    public LazyStaggeredGridState(int[] iArr, int[] iArr2, PrefetchScheduler prefetchScheduler) {
        LazyStaggeredGridScrollPosition lazyStaggeredGridScrollPosition = new LazyStaggeredGridScrollPosition(iArr, iArr2, new LazyStaggeredGridState$scrollPosition$1(this));
        this.scrollPosition = lazyStaggeredGridScrollPosition;
        this.layoutInfoState = SnapshotStateKt.mutableStateOf(LazyStaggeredGridMeasureResultKt.getEmptyLazyStaggeredGridLayoutInfo(), SnapshotStateKt.neverEqualPolicy());
        this._scrollIndicatorState = new ScrollIndicatorState() { // from class: androidx.compose.foundation.lazy.staggeredgrid.LazyStaggeredGridState$_scrollIndicatorState$1
            @Override // androidx.compose.foundation.ScrollIndicatorState
            public int getScrollOffset() {
                return this.this$0.calculateScrollOffset();
            }

            @Override // androidx.compose.foundation.ScrollIndicatorState
            public int getContentSize() {
                return LazyStaggeredGridMeasureResultKt.calculateContentSize(this.this$0.getLayoutInfo(), this.this$0.getLaneCount$foundation());
            }

            @Override // androidx.compose.foundation.ScrollIndicatorState
            public int getViewportSize() {
                return LazyStaggeredGridMeasureResultKt.getSingleAxisViewportSize(this.this$0.getLayoutInfo());
            }
        };
        this.laneInfo = new LazyStaggeredGridLaneInfo();
        this.canScrollForward = SnapshotStateKt__SnapshotStateKt.mutableStateOf$default(false, null, 2, null);
        this.canScrollBackward = SnapshotStateKt__SnapshotStateKt.mutableStateOf$default(false, null, 2, null);
        this.remeasurementModifier = new RemeasurementModifier() { // from class: androidx.compose.foundation.lazy.staggeredgrid.LazyStaggeredGridState$remeasurementModifier$1
            @Override // androidx.compose.ui.layout.RemeasurementModifier
            public void onRemeasurementAvailable(Remeasurement remeasurement) {
                this.this$0.remeasurement = remeasurement;
            }
        };
        this.awaitLayoutModifier = new AwaitFirstLayoutModifier();
        this.beyondBoundsInfo = new LazyLayoutBeyondBoundsInfo();
        this.prefetchingEnabled = true;
        this.prefetchState = new LazyLayoutPrefetchState(prefetchScheduler, null, 2, null);
        this.scrollableState = ScrollableStateKt.ScrollableState(new Function1() { // from class: androidx.compose.foundation.lazy.staggeredgrid.LazyStaggeredGridState$$ExternalSyntheticLambda2
            @Override // kotlin.jvm.functions.Function1
            public final Object invoke(Object obj) {
                return Float.valueOf(LazyStaggeredGridState.scrollableState$lambda$0(this.f$0, ((Float) obj).floatValue()));
            }
        });
        this.prefetchBaseIndex = -1;
        this.currentItemPrefetchHandles = IntObjectMapKt.mutableIntObjectMapOf();
        this.mutableInteractionSource = InteractionSourceKt.MutableInteractionSource();
        this.pinnedItems = new LazyLayoutPinnedItemList();
        this.itemAnimator = new LazyLayoutItemAnimator<>();
        lazyStaggeredGridScrollPosition.getNearestRangeState();
        this.placementScopeInvalidator = ObservableScopeInvalidator.m1396constructorimpl$default(null, 1, null);
        this.measurementScopeInvalidator = ObservableScopeInvalidator.m1396constructorimpl$default(null, 1, null);
        this._lazyLayoutScrollDeltaBetweenPasses = new LazyLayoutScrollDeltaBetweenPasses();
    }

    public /* synthetic */ LazyStaggeredGridState(int i, int i2, int i3, DefaultConstructorMarker defaultConstructorMarker) {
        this((i3 & 1) != 0 ? 0 : i, (i3 & 2) != 0 ? 0 : i2);
    }

    public LazyStaggeredGridState(int i, int i2) {
        this(new int[]{i}, new int[]{i2}, null);
    }

    /* JADX INFO: renamed from: getHasLookaheadOccurred$foundation, reason: from getter */
    public final boolean getHasLookaheadOccurred() {
        return this.hasLookaheadOccurred;
    }

    /* JADX INFO: renamed from: getApproachLayoutInfo$foundation, reason: from getter */
    public final LazyStaggeredGridMeasureResult getApproachLayoutInfo() {
        return this.approachLayoutInfo;
    }

    public final int getFirstVisibleItemIndex() {
        return this.scrollPosition.getIndex();
    }

    public final int getFirstVisibleItemScrollOffset() {
        return this.scrollPosition.getScrollOffset();
    }

    /* JADX INFO: renamed from: getScrollPosition$foundation, reason: from getter */
    public final LazyStaggeredGridScrollPosition getScrollPosition() {
        return this.scrollPosition;
    }

    public final LazyStaggeredGridLayoutInfo getLayoutInfo() {
        return this.layoutInfoState.getValue();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final int calculateScrollOffset() {
        LazyStaggeredGridLayoutInfo layoutInfo = getLayoutInfo();
        if (layoutInfo.getTotalItemsCount() == 0) {
            return 0;
        }
        return ((LazyStaggeredGridMeasureResultKt.visibleItemsAverageSize(layoutInfo) * getFirstVisibleItemIndex()) / getLaneCount$foundation()) + getFirstVisibleItemScrollOffset();
    }

    /* JADX INFO: renamed from: getLaneInfo$foundation, reason: from getter */
    public final LazyStaggeredGridLaneInfo getLaneInfo() {
        return this.laneInfo;
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

    /* JADX INFO: renamed from: getBeyondBoundsInfo$foundation, reason: from getter */
    public final LazyLayoutBeyondBoundsInfo getBeyondBoundsInfo() {
        return this.beyondBoundsInfo;
    }

    /* JADX INFO: renamed from: getPrefetchingEnabled$foundation, reason: from getter */
    public final boolean getPrefetchingEnabled() {
        return this.prefetchingEnabled;
    }

    public final void setPrefetchingEnabled$foundation(boolean z) {
        this.prefetchingEnabled = z;
    }

    /* JADX INFO: renamed from: getPrefetchState$foundation, reason: from getter */
    public final LazyLayoutPrefetchState getPrefetchState() {
        return this.prefetchState;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final float scrollableState$lambda$0(LazyStaggeredGridState lazyStaggeredGridState, float f2) {
        return -lazyStaggeredGridState.onScroll(-f2);
    }

    public final float scrollToBeConsumed$foundation(boolean isLookingAhead) {
        if (isLookingAhead || !this.hasLookaheadOccurred) {
            return this.scrollToBeConsumed;
        }
        return getScrollDeltaBetweenPasses$foundation();
    }

    /* JADX INFO: renamed from: getMeasurePassCount$foundation, reason: from getter */
    public final int getMeasurePassCount() {
        return this.measurePassCount;
    }

    public final void setMeasurePassCount$foundation(int i) {
        this.measurePassCount = i;
    }

    public final int getLaneCount$foundation() {
        return this.layoutInfoState.getValue().getSlots().getSizes().length;
    }

    public final InteractionSource getInteractionSource() {
        return this.mutableInteractionSource;
    }

    /* JADX INFO: renamed from: getMutableInteractionSource$foundation, reason: from getter */
    public final MutableInteractionSource getMutableInteractionSource() {
        return this.mutableInteractionSource;
    }

    /* JADX INFO: renamed from: getPinnedItems$foundation, reason: from getter */
    public final LazyLayoutPinnedItemList getPinnedItems() {
        return this.pinnedItems;
    }

    public final LazyLayoutItemAnimator<LazyStaggeredGridMeasuredItem> getItemAnimator$foundation() {
        return this.itemAnimator;
    }

    public final IntRange getNearestRange$foundation() {
        return this.scrollPosition.getNearestRangeState().getValue();
    }

    /* JADX INFO: renamed from: getPlacementScopeInvalidator-zYiylxw$foundation, reason: not valid java name */
    public final MutableState<Unit> m1445getPlacementScopeInvalidatorzYiylxw$foundation() {
        return this.placementScopeInvalidator;
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
            boolean r0 = r9 instanceof androidx.compose.foundation.lazy.staggeredgrid.LazyStaggeredGridState.C03561
            if (r0 == 0) goto L14
            r0 = r9
            androidx.compose.foundation.lazy.staggeredgrid.LazyStaggeredGridState$scroll$1 r0 = (androidx.compose.foundation.lazy.staggeredgrid.LazyStaggeredGridState.C03561) r0
            int r1 = r0.label
            r2 = -2147483648(0xffffffff80000000, float:-0.0)
            r1 = r1 & r2
            if (r1 == 0) goto L14
            int r9 = r0.label
            int r9 = r9 - r2
            r0.label = r9
            goto L19
        L14:
            androidx.compose.foundation.lazy.staggeredgrid.LazyStaggeredGridState$scroll$1 r0 = new androidx.compose.foundation.lazy.staggeredgrid.LazyStaggeredGridState$scroll$1
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
            androidx.compose.runtime.MutableState<androidx.compose.foundation.lazy.staggeredgrid.LazyStaggeredGridMeasureResult> r9 = r6.layoutInfoState
            java.lang.Object r9 = r9.getValue()
            androidx.compose.foundation.lazy.staggeredgrid.LazyStaggeredGridMeasureResult r2 = androidx.compose.foundation.lazy.staggeredgrid.LazyStaggeredGridMeasureResultKt.getEmptyLazyStaggeredGridLayoutInfo()
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
        throw new UnsupportedOperationException("Method not decompiled: androidx.compose.foundation.lazy.staggeredgrid.LazyStaggeredGridState.scroll(androidx.compose.foundation.MutatePriority, kotlin.jvm.functions.Function2, kotlin.coroutines.Continuation):java.lang.Object");
    }

    @Override // androidx.compose.foundation.gestures.ScrollableState
    public boolean isScrollInProgress() {
        return this.scrollableState.isScrollInProgress();
    }

    private final float onScroll(float distance) {
        LazyStaggeredGridMeasureResult lazyStaggeredGridMeasureResult;
        if ((distance < 0.0f && !getCanScrollForward()) || (distance > 0.0f && !getCanScrollBackward())) {
            return 0.0f;
        }
        if (!(Math.abs(this.scrollToBeConsumed) <= 0.5f)) {
            InlineClassHelperKt.throwIllegalStateException("entered drag with non-zero pending scroll");
        }
        float f2 = this.scrollToBeConsumed + distance;
        this.scrollToBeConsumed = f2;
        if (Math.abs(f2) > 0.5f) {
            float f3 = this.scrollToBeConsumed;
            int iRoundToInt = MathKt.roundToInt(f3);
            LazyStaggeredGridMeasureResult lazyStaggeredGridMeasureResultCopyWithScrollDeltaWithoutRemeasure = this.layoutInfoState.getValue().copyWithScrollDeltaWithoutRemeasure(iRoundToInt, !this.hasLookaheadOccurred);
            if (lazyStaggeredGridMeasureResultCopyWithScrollDeltaWithoutRemeasure != null && (lazyStaggeredGridMeasureResult = this.approachLayoutInfo) != null) {
                LazyStaggeredGridMeasureResult lazyStaggeredGridMeasureResultCopyWithScrollDeltaWithoutRemeasure2 = lazyStaggeredGridMeasureResult != null ? lazyStaggeredGridMeasureResult.copyWithScrollDeltaWithoutRemeasure(iRoundToInt, true) : null;
                if (lazyStaggeredGridMeasureResultCopyWithScrollDeltaWithoutRemeasure2 != null) {
                    this.approachLayoutInfo = lazyStaggeredGridMeasureResultCopyWithScrollDeltaWithoutRemeasure2;
                } else {
                    lazyStaggeredGridMeasureResultCopyWithScrollDeltaWithoutRemeasure = null;
                }
            }
            if (lazyStaggeredGridMeasureResultCopyWithScrollDeltaWithoutRemeasure != null) {
                applyMeasureResult$foundation(lazyStaggeredGridMeasureResultCopyWithScrollDeltaWithoutRemeasure, this.hasLookaheadOccurred, true);
                ObservableScopeInvalidator.m1400invalidateScopeimpl(this.placementScopeInvalidator);
                notifyPrefetch(f3 - this.scrollToBeConsumed, lazyStaggeredGridMeasureResultCopyWithScrollDeltaWithoutRemeasure);
            } else {
                Remeasurement remeasurement = this.remeasurement;
                if (remeasurement != null) {
                    remeasurement.forceRemeasure();
                }
                notifyPrefetch$default(this, f3 - this.scrollToBeConsumed, null, 2, null);
            }
        }
        if (Math.abs(this.scrollToBeConsumed) <= 0.5f) {
            return distance;
        }
        float f4 = distance - this.scrollToBeConsumed;
        this.scrollToBeConsumed = 0.0f;
        return f4;
    }

    public static /* synthetic */ Object scrollToItem$default(LazyStaggeredGridState lazyStaggeredGridState, int i, int i2, Continuation continuation, int i3, Object obj) {
        if ((i3 & 2) != 0) {
            i2 = 0;
        }
        return lazyStaggeredGridState.scrollToItem(i, i2, continuation);
    }

    /* JADX INFO: renamed from: androidx.compose.foundation.lazy.staggeredgrid.LazyStaggeredGridState$scrollToItem$2, reason: invalid class name and case insensitive filesystem */
    /* JADX INFO: compiled from: LazyStaggeredGridState.kt */
    @Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\n"}, d2 = {"<anonymous>", "", "Landroidx/compose/foundation/gestures/ScrollScope;"}, k = 3, mv = {2, 1, 0}, xi = 48)
    @DebugMetadata(c = "androidx.compose.foundation.lazy.staggeredgrid.LazyStaggeredGridState$scrollToItem$2", f = "LazyStaggeredGridState.kt", i = {}, l = {}, m = "invokeSuspend", n = {}, s = {}, v = 1)
    static final class C03572 extends SuspendLambda implements Function2<ScrollScope, Continuation<? super Unit>, Object> {
        final /* synthetic */ int $index;
        final /* synthetic */ int $scrollOffset;
        int label;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        C03572(int i, int i2, Continuation<? super C03572> continuation) {
            super(2, continuation);
            this.$index = i;
            this.$scrollOffset = i2;
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
            return LazyStaggeredGridState.this.new C03572(this.$index, this.$scrollOffset, continuation);
        }

        @Override // kotlin.jvm.functions.Function2
        public final Object invoke(ScrollScope scrollScope, Continuation<? super Unit> continuation) {
            return ((C03572) create(scrollScope, continuation)).invokeSuspend(Unit.INSTANCE);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object obj) {
            IntrinsicsKt.getCOROUTINE_SUSPENDED();
            if (this.label != 0) {
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
            }
            ResultKt.throwOnFailure(obj);
            LazyStaggeredGridState.this.snapToItemInternal$foundation(this.$index, this.$scrollOffset, true);
            return Unit.INSTANCE;
        }
    }

    public final Object scrollToItem(int i, int i2, Continuation<? super Unit> continuation) {
        Object objScroll$default = ScrollableState.scroll$default(this, null, new C03572(i, i2, null), continuation, 1, null);
        return objScroll$default == IntrinsicsKt.getCOROUTINE_SUSPENDED() ? objScroll$default : Unit.INSTANCE;
    }

    public static /* synthetic */ Object animateScrollToItem$default(LazyStaggeredGridState lazyStaggeredGridState, int i, int i2, Continuation continuation, int i3, Object obj) {
        if ((i3 & 2) != 0) {
            i2 = 0;
        }
        return lazyStaggeredGridState.animateScrollToItem(i, i2, continuation);
    }

    public final Object animateScrollToItem(int i, int i2, Continuation<? super Unit> continuation) {
        LazyStaggeredGridMeasureResult value = this.layoutInfoState.getValue();
        Object objScroll$default = ScrollableState.scroll$default(this, null, new AnonymousClass2(i, i2, value.getSlots().getSizes().length * 100, value, null), continuation, 1, null);
        return objScroll$default == IntrinsicsKt.getCOROUTINE_SUSPENDED() ? objScroll$default : Unit.INSTANCE;
    }

    /* JADX INFO: renamed from: androidx.compose.foundation.lazy.staggeredgrid.LazyStaggeredGridState$animateScrollToItem$2, reason: invalid class name */
    /* JADX INFO: compiled from: LazyStaggeredGridState.kt */
    @Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\n"}, d2 = {"<anonymous>", "", "Landroidx/compose/foundation/gestures/ScrollScope;"}, k = 3, mv = {2, 1, 0}, xi = 48)
    @DebugMetadata(c = "androidx.compose.foundation.lazy.staggeredgrid.LazyStaggeredGridState$animateScrollToItem$2", f = "LazyStaggeredGridState.kt", i = {}, l = {396}, m = "invokeSuspend", n = {}, s = {}, v = 1)
    static final class AnonymousClass2 extends SuspendLambda implements Function2<ScrollScope, Continuation<? super Unit>, Object> {
        final /* synthetic */ int $index;
        final /* synthetic */ LazyStaggeredGridMeasureResult $layoutInfo;
        final /* synthetic */ int $numOfItemsToTeleport;
        final /* synthetic */ int $scrollOffset;
        private /* synthetic */ Object L$0;
        int label;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        AnonymousClass2(int i, int i2, int i3, LazyStaggeredGridMeasureResult lazyStaggeredGridMeasureResult, Continuation<? super AnonymousClass2> continuation) {
            super(2, continuation);
            this.$index = i;
            this.$scrollOffset = i2;
            this.$numOfItemsToTeleport = i3;
            this.$layoutInfo = lazyStaggeredGridMeasureResult;
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
            AnonymousClass2 anonymousClass2 = LazyStaggeredGridState.this.new AnonymousClass2(this.$index, this.$scrollOffset, this.$numOfItemsToTeleport, this.$layoutInfo, continuation);
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
                if (LazyLayoutScrollScopeKt.animateScrollToItem(LazyStaggeredGridScrollScopeKt.LazyLayoutScrollScope(LazyStaggeredGridState.this, scrollScope), this.$index, this.$scrollOffset, this.$numOfItemsToTeleport, this.$layoutInfo.getDensity(), this) == coroutine_suspended) {
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

    /* JADX INFO: renamed from: getMeasurementScopeInvalidator-zYiylxw$foundation, reason: not valid java name */
    public final MutableState<Unit> m1444getMeasurementScopeInvalidatorzYiylxw$foundation() {
        return this.measurementScopeInvalidator;
    }

    public static /* synthetic */ void requestScrollToItem$default(LazyStaggeredGridState lazyStaggeredGridState, int i, int i2, int i3, Object obj) {
        if ((i3 & 2) != 0) {
            i2 = 0;
        }
        lazyStaggeredGridState.requestScrollToItem(i, i2);
    }

    /* JADX INFO: renamed from: androidx.compose.foundation.lazy.staggeredgrid.LazyStaggeredGridState$requestScrollToItem$1, reason: invalid class name */
    /* JADX INFO: compiled from: LazyStaggeredGridState.kt */
    @Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\n"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {2, 1, 0}, xi = 48)
    @DebugMetadata(c = "androidx.compose.foundation.lazy.staggeredgrid.LazyStaggeredGridState$requestScrollToItem$1", f = "LazyStaggeredGridState.kt", i = {}, l = {420}, m = "invokeSuspend", n = {}, s = {}, v = 1)
    static final class AnonymousClass1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
        int label;

        AnonymousClass1(Continuation<? super AnonymousClass1> continuation) {
            super(2, continuation);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
            return LazyStaggeredGridState.this.new AnonymousClass1(continuation);
        }

        @Override // kotlin.jvm.functions.Function2
        public final Object invoke(CoroutineScope coroutineScope, Continuation<? super Unit> continuation) {
            return ((AnonymousClass1) create(coroutineScope, continuation)).invokeSuspend(Unit.INSTANCE);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object obj) {
            Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
            int i = this.label;
            if (i == 0) {
                ResultKt.throwOnFailure(obj);
                this.label = 1;
                if (ScrollExtensionsKt.stopScroll$default(LazyStaggeredGridState.this, (MutatePriority) null, this, 1, (Object) null) == coroutine_suspended) {
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
            BuildersKt__Builders_commonKt.launch$default(this.layoutInfoState.getValue().getCoroutineScope(), null, null, new AnonymousClass1(null), 3, null);
        }
        snapToItemInternal$foundation(index, scrollOffset, false);
    }

    public final void snapToItemInternal$foundation(int index, int scrollOffset, boolean forceRemeasure) {
        int iM8958getXimpl;
        boolean z = (this.scrollPosition.getIndex() == index && this.scrollPosition.getScrollOffset() == scrollOffset) ? false : true;
        if (z) {
            this.itemAnimator.reset();
        }
        LazyStaggeredGridMeasureResult value = this.layoutInfoState.getValue();
        LazyStaggeredGridItemInfo lazyStaggeredGridItemInfoFindVisibleItem = LazyStaggeredGridMeasureResultKt.findVisibleItem(value, index);
        if (lazyStaggeredGridItemInfoFindVisibleItem != null && z) {
            if (value.getOrientation() == Orientation.Vertical) {
                iM8958getXimpl = IntOffset.m8959getYimpl(lazyStaggeredGridItemInfoFindVisibleItem.getOffset());
            } else {
                iM8958getXimpl = IntOffset.m8958getXimpl(lazyStaggeredGridItemInfoFindVisibleItem.getOffset());
            }
            int i = iM8958getXimpl + scrollOffset;
            int length = value.getFirstVisibleItemScrollOffsets().length;
            int[] iArr = new int[length];
            for (int i2 = 0; i2 < length; i2++) {
                iArr[i2] = value.getFirstVisibleItemScrollOffsets()[i2] + i;
            }
            this.scrollPosition.updateScrollOffset(iArr);
        } else {
            this.scrollPosition.requestPositionAndForgetLastKnownKey(index, scrollOffset);
        }
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

    public final int[] updateScrollPositionIfTheFirstItemWasMoved$foundation(LazyLayoutItemProvider itemProvider, int[] firstItemIndex) {
        return this.scrollPosition.updateScrollPositionIfTheFirstItemWasMoved(itemProvider, firstItemIndex);
    }

    @Override // androidx.compose.foundation.gestures.ScrollableState
    public float dispatchRawDelta(float delta) {
        return this.scrollableState.dispatchRawDelta(delta);
    }

    static /* synthetic */ void notifyPrefetch$default(LazyStaggeredGridState lazyStaggeredGridState, float f2, LazyStaggeredGridMeasureResult lazyStaggeredGridMeasureResult, int i, Object obj) {
        if ((i & 2) != 0) {
            lazyStaggeredGridMeasureResult = lazyStaggeredGridState.layoutInfoState.getValue();
        }
        lazyStaggeredGridState.notifyPrefetch(f2, lazyStaggeredGridMeasureResult);
    }

    private final void notifyPrefetch(float delta, LazyStaggeredGridMeasureResult info2) {
        int index;
        int iFindPreviousItemIndex;
        int i;
        long jM8794fixedHeightOenEA2s;
        if (!this.prefetchingEnabled || info2.getVisibleItemsInfo().isEmpty()) {
            return;
        }
        boolean z = delta < 0.0f;
        if (z) {
            index = ((LazyStaggeredGridMeasuredItem) CollectionsKt.last((List) info2.getVisibleItemsInfo())).getIndex();
        } else {
            index = ((LazyStaggeredGridMeasuredItem) CollectionsKt.first((List) info2.getVisibleItemsInfo())).getIndex();
        }
        if (index == this.prefetchBaseIndex) {
            return;
        }
        this.prefetchBaseIndex = index;
        MutableIntSet mutableIntSetMutableIntSetOf = IntSetKt.mutableIntSetOf();
        LazyStaggeredGridSlots slots = info2.getSlots();
        int length = slots.getSizes().length;
        int i2 = 0;
        while (i2 < length) {
            if (z) {
                iFindPreviousItemIndex = this.laneInfo.findNextItemIndex(index, i2);
            } else {
                iFindPreviousItemIndex = this.laneInfo.findPreviousItemIndex(index, i2);
            }
            int i3 = iFindPreviousItemIndex;
            if (i3 < 0 || i3 >= info2.getTotalItemsCount() || mutableIntSetMutableIntSetOf.contains(i3)) {
                break;
            }
            mutableIntSetMutableIntSetOf.plusAssign(i3);
            if (!this.currentItemPrefetchHandles.containsKey(i3)) {
                boolean zIsFullSpan = info2.getSpanProvider().isFullSpan(i3);
                int i4 = zIsFullSpan ? 0 : i2;
                int i5 = zIsFullSpan ? length : 1;
                if (i5 == 1) {
                    i = slots.getSizes()[i4];
                } else {
                    int i6 = slots.getPositions()[i4];
                    int i7 = (i4 + i5) - 1;
                    i = (slots.getPositions()[i7] + slots.getSizes()[i7]) - i6;
                }
                if (info2.getOrientation() == Orientation.Vertical) {
                    jM8794fixedHeightOenEA2s = Constraints.INSTANCE.m8795fixedWidthOenEA2s(i);
                } else {
                    jM8794fixedHeightOenEA2s = Constraints.INSTANCE.m8794fixedHeightOenEA2s(i);
                }
                this.currentItemPrefetchHandles.set(i3, LazyLayoutPrefetchState.m1383schedulePrecompositionAndPremeasureVKLhPVY$default(this.prefetchState, i3, jM8794fixedHeightOenEA2s, null, 4, null));
            }
            i2++;
            index = i3;
        }
        clearLeftoverPrefetchHandles(mutableIntSetMutableIntSetOf);
    }

    private final void clearLeftoverPrefetchHandles(IntSet prefetchHandlesUsed) {
        MutableIntObjectMap<LazyLayoutPrefetchState.PrefetchHandle> mutableIntObjectMap = this.currentItemPrefetchHandles;
        long[] jArr = mutableIntObjectMap.metadata;
        int length = jArr.length - 2;
        if (length < 0) {
            return;
        }
        int i = 0;
        while (true) {
            long j = jArr[i];
            if ((((~j) << 7) & j & (-9187201950435737472L)) != -9187201950435737472L) {
                int i2 = 8 - ((~(i - length)) >>> 31);
                for (int i3 = 0; i3 < i2; i3++) {
                    if ((255 & j) < 128) {
                        int i4 = (i << 3) + i3;
                        int i5 = mutableIntObjectMap.keys[i4];
                        LazyLayoutPrefetchState.PrefetchHandle prefetchHandle = (LazyLayoutPrefetchState.PrefetchHandle) mutableIntObjectMap.values[i4];
                        boolean zContains = prefetchHandlesUsed.contains(i5);
                        if (!zContains) {
                            prefetchHandle.cancel();
                        }
                        if (!zContains) {
                            mutableIntObjectMap.removeValueAt(i4);
                        }
                    }
                    j >>= 8;
                }
                if (i2 != 8) {
                    return;
                }
            }
            if (i == length) {
                return;
            } else {
                i++;
            }
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:22:0x0073  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    private final void cancelPrefetchIfVisibleItemsChanged(androidx.compose.foundation.lazy.staggeredgrid.LazyStaggeredGridLayoutInfo r14) {
        /*
            r13 = this;
            java.util.List r14 = r14.getVisibleItemsInfo()
            int r0 = r13.prefetchBaseIndex
            r1 = -1
            if (r0 == r1) goto L7d
            r0 = r14
            java.util.Collection r0 = (java.util.Collection) r0
            boolean r0 = r0.isEmpty()
            if (r0 != 0) goto L7d
            java.lang.Object r0 = kotlin.collections.CollectionsKt.first(r14)
            androidx.compose.foundation.lazy.staggeredgrid.LazyStaggeredGridItemInfo r0 = (androidx.compose.foundation.lazy.staggeredgrid.LazyStaggeredGridItemInfo) r0
            int r0 = r0.getIndex()
            java.lang.Object r14 = kotlin.collections.CollectionsKt.last(r14)
            androidx.compose.foundation.lazy.staggeredgrid.LazyStaggeredGridItemInfo r14 = (androidx.compose.foundation.lazy.staggeredgrid.LazyStaggeredGridItemInfo) r14
            int r14 = r14.getIndex()
            int r2 = r13.prefetchBaseIndex
            if (r0 > r2) goto L2d
            if (r2 > r14) goto L2d
            return
        L2d:
            r13.prefetchBaseIndex = r1
            androidx.collection.MutableIntObjectMap<androidx.compose.foundation.lazy.layout.LazyLayoutPrefetchState$PrefetchHandle> r14 = r13.currentItemPrefetchHandles
            androidx.collection.IntObjectMap r14 = (androidx.collection.IntObjectMap) r14
            java.lang.Object[] r0 = r14.values
            long[] r14 = r14.metadata
            int r1 = r14.length
            int r1 = r1 + (-2)
            if (r1 < 0) goto L78
            r2 = 0
            r3 = r2
        L3e:
            r4 = r14[r3]
            long r6 = ~r4
            r8 = 7
            long r6 = r6 << r8
            long r6 = r6 & r4
            r8 = -9187201950435737472(0x8080808080808080, double:-2.937446524422997E-306)
            long r6 = r6 & r8
            int r6 = (r6 > r8 ? 1 : (r6 == r8 ? 0 : -1))
            if (r6 == 0) goto L73
            int r6 = r3 - r1
            int r6 = ~r6
            int r6 = r6 >>> 31
            r7 = 8
            int r6 = 8 - r6
            r8 = r2
        L58:
            if (r8 >= r6) goto L71
            r9 = 255(0xff, double:1.26E-321)
            long r9 = r9 & r4
            r11 = 128(0x80, double:6.3E-322)
            int r9 = (r9 > r11 ? 1 : (r9 == r11 ? 0 : -1))
            if (r9 >= 0) goto L6d
            int r9 = r3 << 3
            int r9 = r9 + r8
            r9 = r0[r9]
            androidx.compose.foundation.lazy.layout.LazyLayoutPrefetchState$PrefetchHandle r9 = (androidx.compose.foundation.lazy.layout.LazyLayoutPrefetchState.PrefetchHandle) r9
            r9.cancel()
        L6d:
            long r4 = r4 >> r7
            int r8 = r8 + 1
            goto L58
        L71:
            if (r6 != r7) goto L78
        L73:
            if (r3 == r1) goto L78
            int r3 = r3 + 1
            goto L3e
        L78:
            androidx.collection.MutableIntObjectMap<androidx.compose.foundation.lazy.layout.LazyLayoutPrefetchState$PrefetchHandle> r14 = r13.currentItemPrefetchHandles
            r14.clear()
        L7d:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.compose.foundation.lazy.staggeredgrid.LazyStaggeredGridState.cancelPrefetchIfVisibleItemsChanged(androidx.compose.foundation.lazy.staggeredgrid.LazyStaggeredGridLayoutInfo):void");
    }

    public static /* synthetic */ void applyMeasureResult$foundation$default(LazyStaggeredGridState lazyStaggeredGridState, LazyStaggeredGridMeasureResult lazyStaggeredGridMeasureResult, boolean z, boolean z2, int i, Object obj) {
        if ((i & 4) != 0) {
            z2 = false;
        }
        lazyStaggeredGridState.applyMeasureResult$foundation(lazyStaggeredGridMeasureResult, z, z2);
    }

    public final void applyMeasureResult$foundation(LazyStaggeredGridMeasureResult result, boolean isLookingAhead, boolean visibleItemsStayedTheSame) {
        if (!isLookingAhead && this.hasLookaheadOccurred) {
            this.approachLayoutInfo = result;
            Snapshot.Companion companion = Snapshot.INSTANCE;
            Snapshot currentThreadSnapshot = companion.getCurrentThreadSnapshot();
            Function1<Object, Unit> readObserver = currentThreadSnapshot != null ? currentThreadSnapshot.getReadObserver() : null;
            Snapshot snapshotMakeCurrentNonObservable = companion.makeCurrentNonObservable(currentThreadSnapshot);
            try {
                if (this._lazyLayoutScrollDeltaBetweenPasses.isActive$foundation() && Arrays.equals(result.getFirstVisibleItemIndices(), this.scrollPosition.getIndices()) && Arrays.equals(result.getFirstVisibleItemScrollOffsets(), this.scrollPosition.getScrollOffsets())) {
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
        this.scrollToBeConsumed -= result.getConsumedScroll();
        this.layoutInfoState.setValue(result);
        if (visibleItemsStayedTheSame) {
            this.scrollPosition.updateScrollOffset(result.getFirstVisibleItemScrollOffsets());
        } else {
            this.scrollPosition.updateFromMeasureResult(result);
            cancelPrefetchIfVisibleItemsChanged(result);
        }
        setCanScrollBackward(result.getCanScrollBackward());
        setCanScrollForward(result.getCanScrollForward());
        if (isLookingAhead) {
            this._lazyLayoutScrollDeltaBetweenPasses.updateScrollDeltaForApproach$foundation(result.getScrollBackAmount(), result.getDensity(), result.getCoroutineScope());
        }
        this.measurePassCount++;
    }

    public final float getScrollDeltaBetweenPasses$foundation() {
        return this._lazyLayoutScrollDeltaBetweenPasses.getScrollDeltaBetweenPasses$foundation();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final int[] fillNearestIndices(int itemIndex, int laneCount) {
        int[] iArr = new int[laneCount];
        if (this.layoutInfoState.getValue().getSpanProvider().isFullSpan(itemIndex)) {
            ArraysKt.fill$default(iArr, itemIndex, 0, 0, 6, (Object) null);
            return iArr;
        }
        this.laneInfo.ensureValidIndex(itemIndex + laneCount);
        int lane = this.laneInfo.getLane(itemIndex);
        if (lane != -2 && lane != -1) {
            if ((lane >= 0 ? 1 : 0) == 0) {
                InlineClassHelperKt.throwIllegalArgumentException("Expected positive lane number, got " + lane + " instead.");
            }
            iMin = Math.min(lane, laneCount);
        }
        int i = iMin;
        int i2 = i - 1;
        int iFindPreviousItemIndex = itemIndex;
        while (true) {
            if (-1 >= i2) {
                break;
            }
            iFindPreviousItemIndex = this.laneInfo.findPreviousItemIndex(iFindPreviousItemIndex, i2);
            iArr[i2] = iFindPreviousItemIndex;
            if (iFindPreviousItemIndex == -1) {
                ArraysKt.fill$default(iArr, -1, 0, i2, 2, (Object) null);
                break;
            }
            i2--;
        }
        iArr[i] = itemIndex;
        for (int i3 = i + 1; i3 < laneCount; i3++) {
            itemIndex = this.laneInfo.findNextItemIndex(itemIndex, i3);
            iArr[i3] = itemIndex;
        }
        return iArr;
    }

    /* JADX INFO: compiled from: LazyStaggeredGridState.kt */
    @Metadata(d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003R\u001d\u0010\u0004\u001a\u000e\u0012\u0004\u0012\u00020\u0006\u0012\u0004\u0012\u00020\u00010\u0005¢\u0006\b\n\u0000\u001a\u0004\b\u0007\u0010\b¨\u0006\t"}, d2 = {"Landroidx/compose/foundation/lazy/staggeredgrid/LazyStaggeredGridState$Companion;", "", "<init>", "()V", "Saver", "Landroidx/compose/runtime/saveable/Saver;", "Landroidx/compose/foundation/lazy/staggeredgrid/LazyStaggeredGridState;", "getSaver", "()Landroidx/compose/runtime/saveable/Saver;", "foundation"}, k = 1, mv = {2, 1, 0}, xi = 48)
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        private Companion() {
        }

        public final Saver<LazyStaggeredGridState, Object> getSaver() {
            return LazyStaggeredGridState.Saver;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final List Saver$lambda$0(SaverScope saverScope, LazyStaggeredGridState lazyStaggeredGridState) {
        return CollectionsKt.listOf((Object[]) new int[][]{lazyStaggeredGridState.scrollPosition.getIndices(), lazyStaggeredGridState.scrollPosition.getScrollOffsets()});
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final LazyStaggeredGridState Saver$lambda$1(List list) {
        return new LazyStaggeredGridState((int[]) list.get(0), (int[]) list.get(1), null);
    }
}
