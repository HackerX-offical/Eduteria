package androidx.compose.animation;

import androidx.compose.animation.SharedTransitionScope;
import androidx.compose.animation.core.AnimationVector4D;
import androidx.compose.animation.core.MutableTransitionState;
import androidx.compose.animation.core.Transition;
import androidx.compose.animation.core.VectorConvertersKt;
import androidx.compose.runtime.Composer;
import androidx.compose.runtime.ComposerKt;
import androidx.compose.runtime.MutableState;
import androidx.compose.runtime.SnapshotStateKt;
import androidx.compose.runtime.SnapshotStateKt__SnapshotStateKt;
import androidx.compose.runtime.snapshots.SnapshotStateList;
import androidx.compose.runtime.snapshots.SnapshotStateMap;
import androidx.compose.ui.ComposedModifierKt;
import androidx.compose.ui.Modifier;
import androidx.compose.ui.geometry.Rect;
import androidx.compose.ui.graphics.AndroidPath_androidKt;
import androidx.compose.ui.graphics.OutlineKt;
import androidx.compose.ui.graphics.Path;
import androidx.compose.ui.graphics.Shape;
import androidx.compose.ui.graphics.drawscope.ContentDrawScope;
import androidx.compose.ui.layout.LayoutCoordinates;
import androidx.compose.ui.layout.LookaheadScope;
import androidx.compose.ui.layout.Placeable;
import androidx.compose.ui.unit.Density;
import androidx.compose.ui.unit.LayoutDirection;
import androidx.exifinterface.media.ExifInterface;
import java.util.Collection;
import java.util.Comparator;
import java.util.Iterator;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.comparisons.ComparisonsKt;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function3;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.TypeIntrinsics;
import kotlinx.coroutines.BuildersKt__Builders_commonKt;
import kotlinx.coroutines.CoroutineScope;
import org.jivesoftware.smack.sm.packet.StreamManagement;

/* JADX INFO: compiled from: SharedTransitionScope.kt */
/* JADX INFO: loaded from: classes.dex */
@Metadata(d1 = {"\u0000Ü\u0001\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\b\u0005\n\u0002\u0010\u000b\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\n\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0007\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\t\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\f\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u001e\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\f\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\u0004\b\u0001\u0018\u00002\u00020\u00012\u00020\u0002:\u0002\u008a\u0001B\u0019\b\u0000\u0012\u0006\u0010\u0003\u001a\u00020\u0002\u0012\u0006\u0010\u0004\u001a\u00020\u0005¢\u0006\u0004\b\u0006\u0010\u0007J\u001a\u0010$\u001a\u00020%*\u00020%2\f\u0010&\u001a\b\u0012\u0004\u0012\u00020\u00120\u000bH\u0016J\"\u0010'\u001a\u00020%*\u00020%2\u0006\u0010(\u001a\u00020)2\f\u0010*\u001a\b\u0012\u0004\u0012\u00020\u00120\u000bH\u0016JD\u0010+\u001a\u00020%*\u00020%2\u0006\u0010,\u001a\u00020-2\u0006\u0010.\u001a\u00020/2\u0006\u00100\u001a\u0002012\u0006\u00102\u001a\u0002032\u0006\u00104\u001a\u00020\u00122\u0006\u0010(\u001a\u00020)2\u0006\u00105\u001a\u000206H\u0016J\\\u00107\u001a\u00020%*\u00020%2\u0006\u0010,\u001a\u00020-2\u0006\u0010.\u001a\u00020/2\u0006\u00108\u001a\u0002092\u0006\u0010:\u001a\u00020;2\u0006\u00100\u001a\u0002012\u0006\u0010<\u001a\u00020=2\u0006\u00102\u001a\u0002032\u0006\u00104\u001a\u00020\u00122\u0006\u0010(\u001a\u00020)2\u0006\u00105\u001a\u000206H\u0016JD\u0010>\u001a\u00020%*\u00020%2\u0006\u0010,\u001a\u00020-2\u0006\u0010?\u001a\u00020\u00122\u0006\u00100\u001a\u0002012\u0006\u00102\u001a\u0002032\u0006\u00104\u001a\u00020\u00122\u0006\u0010(\u001a\u00020)2\u0006\u00105\u001a\u000206H\u0016JS\u0010@\u001a\u00020%*\u00020%2\u0006\u0010,\u001a\u00020-2\u0006\u0010?\u001a\u00020\u00122\b\b\u0002\u00100\u001a\u0002012\b\b\u0002\u00102\u001a\u0002032\b\b\u0002\u00104\u001a\u00020\u00122\b\b\u0002\u0010(\u001a\u00020)2\b\b\u0002\u00105\u001a\u000206H\u0000¢\u0006\u0002\bAJ\u0010\u0010B\u001a\u0002062\u0006\u0010C\u001a\u00020DH\u0016J\r\u0010G\u001a\u00020\fH\u0000¢\u0006\u0002\bHJ\b\u0010I\u001a\u00020\fH\u0002J\b\u0010J\u001a\u00020\fH\u0002Jp\u0010K\u001a\u00020%\"\u0004\b\u0000\u0010L*\u00020%2\u0006\u0010,\u001a\u00020-2\u000e\u0010M\u001a\n\u0012\u0004\u0012\u0002HL\u0018\u00010N2\u0012\u0010?\u001a\u000e\u0012\u0004\u0012\u0002HL\u0012\u0004\u0012\u00020\u00120O2\u0006\u00100\u001a\u0002012\b\b\u0002\u00102\u001a\u0002032\u0006\u0010P\u001a\u00020\u00122\u0006\u00104\u001a\u00020\u00122\u0006\u0010(\u001a\u00020)2\u0006\u00105\u001a\u000206H\u0002JM\u0010Q\u001a\u00020R2\u0006\u0010+\u001a\u00020S2\u0006\u0010T\u001a\u00020U2\u0006\u00102\u001a\u0002032\u0006\u0010P\u001a\u00020\u00122\u0006\u0010,\u001a\u00020-2\u0006\u00105\u001a\u0002062\u0006\u0010(\u001a\u00020)2\u0006\u00104\u001a\u00020\u0012H\u0003¢\u0006\u0002\u0010VJ\u0010\u0010n\u001a\u00020S2\u0006\u0010o\u001a\u00020iH\u0002J\u0015\u0010p\u001a\u00020\f2\u0006\u0010q\u001a\u00020rH\u0000¢\u0006\u0002\bsJ\u0015\u0010t\u001a\u00020\f2\u0006\u0010u\u001a\u00020RH\u0000¢\u0006\u0002\bvJ\u0015\u0010w\u001a\u00020\f2\u0006\u0010u\u001a\u00020RH\u0000¢\u0006\u0002\bxJ\u0015\u0010y\u001a\u00020\f2\u0006\u0010z\u001a\u00020fH\u0000¢\u0006\u0002\b{J\u0015\u0010|\u001a\u00020\f2\u0006\u0010z\u001a\u00020fH\u0000¢\u0006\u0002\b}J1\u0010~\u001a\u00020\u007f*\u00020X2\u0007\u0010\u0080\u0001\u001a\u00020X2\u0007\u0010\u0081\u0001\u001a\u00020\u007f2\u0007\u0010\u0082\u0001\u001a\u00020\u0012H\u0096\u0001¢\u0006\u0006\b\u0083\u0001\u0010\u0084\u0001J\u000e\u0010\u0085\u0001\u001a\u00020X*\u00020XH\u0096\u0001R\u0011\u0010\u0004\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b\b\u0010\tR\"\u0010\n\u001a\n\u0012\u0004\u0012\u00020\f\u0018\u00010\u000bX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\r\u0010\u000e\"\u0004\b\u000f\u0010\u0010R+\u0010\u0013\u001a\u00020\u00122\u0006\u0010\u0011\u001a\u00020\u00128V@RX\u0096\u008e\u0002¢\u0006\u0012\n\u0004\b\u0017\u0010\u0018\u001a\u0004\b\u0013\u0010\u0014\"\u0004\b\u0015\u0010\u0016R\u001c\u0010\u0019\u001a\u0004\u0018\u00010\u001aX\u0080\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u001b\u0010\u001c\"\u0004\b\u001d\u0010\u001eR,\u0010\u001f\u001a\n\u0012\u0004\u0012\u00020\f\u0018\u00010\u000b8\u0006@\u0006X\u0087\u000e¢\u0006\u0014\n\u0000\u0012\u0004\b \u0010!\u001a\u0004\b\"\u0010\u000e\"\u0004\b#\u0010\u0010R\u001a\u0010E\u001a\b\u0012\u0004\u0012\u00020\f0\u000bX\u0080\u0004¢\u0006\b\n\u0000\u001a\u0004\bF\u0010\u000eR$\u0010Y\u001a\u00020X2\u0006\u0010W\u001a\u00020X8@@@X\u0080\u000e¢\u0006\f\u001a\u0004\bZ\u0010[\"\u0004\b\\\u0010]R\"\u0010^\u001a\u0004\u0018\u00010X2\b\u0010W\u001a\u0004\u0018\u00010X@BX\u0080\u000e¢\u0006\b\n\u0000\u001a\u0004\b_\u0010[R$\u0010`\u001a\u00020X2\u0006\u0010W\u001a\u00020X8@@@X\u0080\u000e¢\u0006\f\u001a\u0004\ba\u0010[\"\u0004\bb\u0010]R\u0010\u0010c\u001a\u0004\u0018\u00010XX\u0082\u000e¢\u0006\u0002\n\u0000R\u0014\u0010d\u001a\b\u0012\u0004\u0012\u00020f0eX\u0082\u0004¢\u0006\u0002\n\u0000R\u001a\u0010g\u001a\u000e\u0012\u0004\u0012\u00020i\u0012\u0004\u0012\u00020S0hX\u0082\u0004¢\u0006\u0002\n\u0000R\u001b\u0010j\u001a\b\u0012\u0004\u0012\u00020S0k8Â\u0002X\u0082\u0004¢\u0006\u0006\u001a\u0004\bl\u0010mR\u001a\u0010\u0086\u0001\u001a\u00020X*\u00030\u0087\u0001X\u0096\u0005¢\u0006\b\u001a\u0006\b\u0088\u0001\u0010\u0089\u0001¨\u0006\u008b\u0001"}, d2 = {"Landroidx/compose/animation/SharedTransitionScopeImpl;", "Landroidx/compose/animation/SharedTransitionScope;", "Landroidx/compose/ui/layout/LookaheadScope;", "lookaheadScope", "coroutineScope", "Lkotlinx/coroutines/CoroutineScope;", "<init>", "(Landroidx/compose/ui/layout/LookaheadScope;Lkotlinx/coroutines/CoroutineScope;)V", "getCoroutineScope", "()Lkotlinx/coroutines/CoroutineScope;", "invalidateOverlay", "Lkotlin/Function0;", "", "getInvalidateOverlay", "()Lkotlin/jvm/functions/Function0;", "setInvalidateOverlay", "(Lkotlin/jvm/functions/Function0;)V", "<set-?>", "", "isTransitionActive", "()Z", "setTransitionActive", "(Z)V", "isTransitionActive$delegate", "Landroidx/compose/runtime/MutableState;", "lookaheadAnimationVisualDebugHelper", "Landroidx/compose/animation/LookaheadAnimationVisualDebugHelper;", "getLookaheadAnimationVisualDebugHelper$animation", "()Landroidx/compose/animation/LookaheadAnimationVisualDebugHelper;", "setLookaheadAnimationVisualDebugHelper$animation", "(Landroidx/compose/animation/LookaheadAnimationVisualDebugHelper;)V", "testBlockToRun", "getTestBlockToRun$annotations", "()V", "getTestBlockToRun", "setTestBlockToRun", "skipToLookaheadSize", "Landroidx/compose/ui/Modifier;", StreamManagement.Enabled.ELEMENT, "renderInSharedTransitionScopeOverlay", "zIndexInOverlay", "", "renderInOverlay", "sharedElement", "sharedContentState", "Landroidx/compose/animation/SharedTransitionScope$SharedContentState;", "animatedVisibilityScope", "Landroidx/compose/animation/AnimatedVisibilityScope;", "boundsTransform", "Landroidx/compose/animation/BoundsTransform;", "placeholderSize", "Landroidx/compose/animation/SharedTransitionScope$PlaceholderSize;", "renderInOverlayDuringTransition", "clipInOverlayDuringTransition", "Landroidx/compose/animation/SharedTransitionScope$OverlayClip;", "sharedBounds", "enter", "Landroidx/compose/animation/EnterTransition;", "exit", "Landroidx/compose/animation/ExitTransition;", "resizeMode", "Landroidx/compose/animation/SharedTransitionScope$ResizeMode;", "sharedElementWithCallerManagedVisibility", "visible", "sharedBoundsWithCallerManagedVisibility", "sharedBoundsWithCallerManagedVisibility$animation", "OverlayClip", "clipShape", "Landroidx/compose/ui/graphics/Shape;", "observeAnimatingBlock", "getObserveAnimatingBlock$animation", "updateTransitionActiveness", "updateTransitionActiveness$animation", "attachLookaheadAnimationVisualDebugHelper", "detachLookaheadAnimationVisualDebugHelper", "sharedBoundsImpl", ExifInterface.GPS_DIRECTION_TRUE, "parentTransition", "Landroidx/compose/animation/core/Transition;", "Lkotlin/Function1;", "renderOnlyWhenVisible", "rememberSharedElementState", "Landroidx/compose/animation/SharedElementEntry;", "Landroidx/compose/animation/SharedElement;", "boundsAnimation", "Landroidx/compose/animation/BoundsAnimation;", "(Landroidx/compose/animation/SharedElement;Landroidx/compose/animation/BoundsAnimation;Landroidx/compose/animation/SharedTransitionScope$PlaceholderSize;ZLandroidx/compose/animation/SharedTransitionScope$SharedContentState;Landroidx/compose/animation/SharedTransitionScope$OverlayClip;FZLandroidx/compose/runtime/Composer;I)Landroidx/compose/animation/SharedElementEntry;", "value", "Landroidx/compose/ui/layout/LayoutCoordinates;", "root", "getRoot$animation", "()Landroidx/compose/ui/layout/LayoutCoordinates;", "setRoot$animation", "(Landroidx/compose/ui/layout/LayoutCoordinates;)V", "nullableRoot", "getNullableRoot$animation", "lookaheadRoot", "getLookaheadRoot$animation", "setLookaheadRoot$animation", "_nullableLookaheadRoot", "renderers", "Landroidx/compose/runtime/snapshots/SnapshotStateList;", "Landroidx/compose/animation/LayerRenderer;", "sharedElements", "Landroidx/compose/runtime/snapshots/SnapshotStateMap;", "", "sharedElementsIterator", "", "getSharedElementsIterator", "()Ljava/util/Collection;", "sharedElementsFor", "key", "drawInOverlay", "scope", "Landroidx/compose/ui/graphics/drawscope/ContentDrawScope;", "drawInOverlay$animation", "onEntryRemoved", "sharedElementState", "onEntryRemoved$animation", "onEntryAdded", "onEntryAdded$animation", "onLayerRendererCreated", "renderer", "onLayerRendererCreated$animation", "onLayerRendererRemoved", "onLayerRendererRemoved$animation", "localLookaheadPositionOf", "Landroidx/compose/ui/geometry/Offset;", "sourceCoordinates", "relativeToSource", "includeMotionFrameOfReference", "localLookaheadPositionOf-au-aQtc", "(Landroidx/compose/ui/layout/LayoutCoordinates;Landroidx/compose/ui/layout/LayoutCoordinates;JZ)J", "toLookaheadCoordinates", "lookaheadScopeCoordinates", "Landroidx/compose/ui/layout/Placeable$PlacementScope;", "getLookaheadScopeCoordinates", "(Landroidx/compose/ui/layout/Placeable$PlacementScope;)Landroidx/compose/ui/layout/LayoutCoordinates;", "ShapeBasedClip", "animation"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final class SharedTransitionScopeImpl implements SharedTransitionScope, LookaheadScope {
    public static final int $stable = 0;
    private final /* synthetic */ LookaheadScope $$delegate_0;
    private LayoutCoordinates _nullableLookaheadRoot;
    private final CoroutineScope coroutineScope;
    private Function0<Unit> invalidateOverlay;
    private LookaheadAnimationVisualDebugHelper lookaheadAnimationVisualDebugHelper;
    private LayoutCoordinates nullableRoot;
    private Function0<Unit> testBlockToRun;

    /* JADX INFO: renamed from: isTransitionActive$delegate, reason: from kotlin metadata */
    private final MutableState isTransitionActive = SnapshotStateKt__SnapshotStateKt.mutableStateOf$default(false, null, 2, null);
    private final Function0<Unit> observeAnimatingBlock = new Function0<Unit>() { // from class: androidx.compose.animation.SharedTransitionScopeImpl$observeAnimatingBlock$1
        {
            super(0);
        }

        @Override // kotlin.jvm.functions.Function0
        public /* bridge */ /* synthetic */ Unit invoke() {
            invoke2();
            return Unit.INSTANCE;
        }

        /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
        public final void invoke2() {
            Collection collectionValues = this.this$0.sharedElements.toMap().values();
            if ((collectionValues instanceof Collection) && collectionValues.isEmpty()) {
                return;
            }
            Iterator it = collectionValues.iterator();
            while (it.hasNext() && !((SharedElement) it.next()).isAnimating()) {
            }
        }
    };
    private final SnapshotStateList<LayerRenderer> renderers = SnapshotStateKt.mutableStateListOf();
    private final SnapshotStateMap<Object, SharedElement> sharedElements = SnapshotStateKt.mutableStateMapOf();

    public static /* synthetic */ void getTestBlockToRun$annotations() {
    }

    @Override // androidx.compose.ui.layout.LookaheadScope
    public LayoutCoordinates getLookaheadScopeCoordinates(Placeable.PlacementScope placementScope) {
        return this.$$delegate_0.getLookaheadScopeCoordinates(placementScope);
    }

    @Override // androidx.compose.ui.layout.LookaheadScope
    /* JADX INFO: renamed from: localLookaheadPositionOf-au-aQtc, reason: not valid java name */
    public long mo156localLookaheadPositionOfauaQtc(LayoutCoordinates layoutCoordinates, LayoutCoordinates layoutCoordinates2, long j, boolean z) {
        return this.$$delegate_0.mo156localLookaheadPositionOfauaQtc(layoutCoordinates, layoutCoordinates2, j, z);
    }

    @Override // androidx.compose.ui.layout.LookaheadScope
    public LayoutCoordinates toLookaheadCoordinates(LayoutCoordinates layoutCoordinates) {
        return this.$$delegate_0.toLookaheadCoordinates(layoutCoordinates);
    }

    public SharedTransitionScopeImpl(LookaheadScope lookaheadScope, CoroutineScope coroutineScope) {
        this.$$delegate_0 = lookaheadScope;
        this.coroutineScope = coroutineScope;
    }

    public final CoroutineScope getCoroutineScope() {
        return this.coroutineScope;
    }

    public final Function0<Unit> getInvalidateOverlay() {
        return this.invalidateOverlay;
    }

    public final void setInvalidateOverlay(Function0<Unit> function0) {
        this.invalidateOverlay = function0;
    }

    private void setTransitionActive(boolean z) {
        this.isTransitionActive.setValue(Boolean.valueOf(z));
    }

    /* JADX WARN: Multi-variable type inference failed */
    @Override // androidx.compose.animation.SharedTransitionScope
    public boolean isTransitionActive() {
        return ((Boolean) this.isTransitionActive.getValue()).booleanValue();
    }

    /* JADX INFO: renamed from: getLookaheadAnimationVisualDebugHelper$animation, reason: from getter */
    public final LookaheadAnimationVisualDebugHelper getLookaheadAnimationVisualDebugHelper() {
        return this.lookaheadAnimationVisualDebugHelper;
    }

    public final void setLookaheadAnimationVisualDebugHelper$animation(LookaheadAnimationVisualDebugHelper lookaheadAnimationVisualDebugHelper) {
        this.lookaheadAnimationVisualDebugHelper = lookaheadAnimationVisualDebugHelper;
    }

    public final Function0<Unit> getTestBlockToRun() {
        return this.testBlockToRun;
    }

    public final void setTestBlockToRun(Function0<Unit> function0) {
        this.testBlockToRun = function0;
    }

    /* JADX WARN: Multi-variable type inference failed */
    @Override // androidx.compose.animation.SharedTransitionScope
    public Modifier skipToLookaheadSize(Modifier modifier, Function0<Boolean> function0) {
        return modifier.then(new SkipToLookaheadSizeElement(null, function0, 1, 0 == true ? 1 : 0));
    }

    @Override // androidx.compose.animation.SharedTransitionScope
    public Modifier renderInSharedTransitionScopeOverlay(Modifier modifier, float f2, Function0<Boolean> function0) {
        return modifier.then(new RenderInTransitionOverlayNodeElement(this, function0, f2));
    }

    @Override // androidx.compose.animation.SharedTransitionScope
    public Modifier sharedElement(Modifier modifier, SharedTransitionScope.SharedContentState sharedContentState, AnimatedVisibilityScope animatedVisibilityScope, BoundsTransform boundsTransform, SharedTransitionScope.PlaceholderSize placeholderSize, boolean z, float f2, SharedTransitionScope.OverlayClip overlayClip) {
        return sharedBoundsImpl(modifier, sharedContentState, animatedVisibilityScope.getTransition(), new Function1<EnterExitState, Boolean>() { // from class: androidx.compose.animation.SharedTransitionScopeImpl.sharedElement.1
            @Override // kotlin.jvm.functions.Function1
            public final Boolean invoke(EnterExitState enterExitState) {
                return Boolean.valueOf(enterExitState == EnterExitState.Visible);
            }
        }, boundsTransform, placeholderSize, true, z, f2, overlayClip);
    }

    @Override // androidx.compose.animation.SharedTransitionScope
    public Modifier sharedBounds(Modifier modifier, final SharedTransitionScope.SharedContentState sharedContentState, final AnimatedVisibilityScope animatedVisibilityScope, final EnterTransition enterTransition, final ExitTransition exitTransition, BoundsTransform boundsTransform, final SharedTransitionScope.ResizeMode resizeMode, SharedTransitionScope.PlaceholderSize placeholderSize, boolean z, float f2, SharedTransitionScope.OverlayClip overlayClip) {
        return ComposedModifierKt.composed$default(sharedBoundsImpl(modifier, sharedContentState, animatedVisibilityScope.getTransition(), new Function1<EnterExitState, Boolean>() { // from class: androidx.compose.animation.SharedTransitionScopeImpl.sharedBounds.1
            @Override // kotlin.jvm.functions.Function1
            public final Boolean invoke(EnterExitState enterExitState) {
                return Boolean.valueOf(enterExitState == EnterExitState.Visible);
            }
        }, boundsTransform, placeholderSize, false, z, f2, overlayClip), null, new Function3<Modifier, Composer, Integer, Modifier>() { // from class: androidx.compose.animation.SharedTransitionScopeImpl.sharedBounds.2
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            {
                super(3);
            }

            @Override // kotlin.jvm.functions.Function3
            public /* bridge */ /* synthetic */ Modifier invoke(Modifier modifier2, Composer composer, Integer num) {
                return invoke(modifier2, composer, num.intValue());
            }

            public final Modifier invoke(Modifier modifier2, Composer composer, int i) {
                Modifier.Companion companionCreateContentScaleModifier;
                composer.startReplaceGroup(-233734437);
                ComposerKt.sourceInformation(composer, "C1096@60541L35,1088@60018L657:SharedTransitionScope.kt#xbi5r1");
                if (ComposerKt.isTraceInProgress()) {
                    ComposerKt.traceEventStart(-233734437, i, -1, "androidx.compose.animation.SharedTransitionScopeImpl.sharedBounds.<anonymous> (SharedTransitionScope.kt:1087)");
                }
                Transition<EnterExitState> transition = animatedVisibilityScope.getTransition();
                EnterTransition enterTransition2 = enterTransition;
                ExitTransition exitTransition2 = exitTransition;
                ComposerKt.sourceInformationMarkerStart(composer, -1280475426, "CC(remember):SharedTransitionScope.kt#9igjgp");
                boolean zChangedInstance = composer.changedInstance(sharedContentState);
                final SharedTransitionScope.SharedContentState sharedContentState2 = sharedContentState;
                Object objRememberedValue = composer.rememberedValue();
                if (zChangedInstance || objRememberedValue == Composer.INSTANCE.getEmpty()) {
                    objRememberedValue = (Function0) new Function0<Boolean>() { // from class: androidx.compose.animation.SharedTransitionScopeImpl$sharedBounds$2$1$1
                        {
                            super(0);
                        }

                        /* JADX WARN: Can't rename method to resolve collision */
                        @Override // kotlin.jvm.functions.Function0
                        public final Boolean invoke() {
                            return Boolean.valueOf(sharedContentState2.isMatchFound());
                        }
                    };
                    composer.updateRememberedValue(objRememberedValue);
                }
                ComposerKt.sourceInformationMarkerEnd(composer);
                Modifier modifierCreateModifier = EnterExitTransitionKt.createModifier(transition, enterTransition2, exitTransition2, false, (Function0) objRememberedValue, "enter/exit for " + sharedContentState.getKey(), composer, 0, 4);
                if (resizeMode instanceof ScaleToBoundsImpl) {
                    composer.startReplaceGroup(-1039792755);
                    ComposerKt.sourceInformation(composer, "1101@60842L530");
                    Modifier.Companion companion = Modifier.INSTANCE;
                    ScaleToBoundsImpl scaleToBoundsImpl = (ScaleToBoundsImpl) resizeMode;
                    ComposerKt.sourceInformationMarkerStart(composer, -1280465299, "CC(remember):SharedTransitionScope.kt#9igjgp");
                    boolean zChangedInstance2 = composer.changedInstance(sharedContentState);
                    final SharedTransitionScope.SharedContentState sharedContentState3 = sharedContentState;
                    Object objRememberedValue2 = composer.rememberedValue();
                    if (zChangedInstance2 || objRememberedValue2 == Composer.INSTANCE.getEmpty()) {
                        objRememberedValue2 = (Function0) new Function0<Boolean>() { // from class: androidx.compose.animation.SharedTransitionScopeImpl$sharedBounds$2$2$1
                            {
                                super(0);
                            }

                            /* JADX WARN: Can't rename method to resolve collision */
                            @Override // kotlin.jvm.functions.Function0
                            public final Boolean invoke() {
                                return Boolean.valueOf(sharedContentState3.isMatchFound());
                            }
                        };
                        composer.updateRememberedValue(objRememberedValue2);
                    }
                    ComposerKt.sourceInformationMarkerEnd(composer);
                    companionCreateContentScaleModifier = SkipToLookaheadSizeNodeKt.createContentScaleModifier(companion, scaleToBoundsImpl, (Function0) objRememberedValue2);
                    composer.endReplaceGroup();
                } else {
                    composer.startReplaceGroup(-1039175545);
                    composer.endReplaceGroup();
                    companionCreateContentScaleModifier = Modifier.INSTANCE;
                }
                Modifier modifierThen = modifierCreateModifier.then(companionCreateContentScaleModifier);
                if (ComposerKt.isTraceInProgress()) {
                    ComposerKt.traceEventEnd();
                }
                composer.endReplaceGroup();
                return modifierThen;
            }
        }, 1, null);
    }

    @Override // androidx.compose.animation.SharedTransitionScope
    public Modifier sharedElementWithCallerManagedVisibility(Modifier modifier, SharedTransitionScope.SharedContentState sharedContentState, final boolean z, BoundsTransform boundsTransform, SharedTransitionScope.PlaceholderSize placeholderSize, boolean z2, float f2, SharedTransitionScope.OverlayClip overlayClip) {
        return sharedBoundsImpl(modifier, sharedContentState, null, new Function1<Unit, Boolean>() { // from class: androidx.compose.animation.SharedTransitionScopeImpl.sharedElementWithCallerManagedVisibility.1
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            {
                super(1);
            }

            @Override // kotlin.jvm.functions.Function1
            public final Boolean invoke(Unit unit) {
                return Boolean.valueOf(z);
            }
        }, boundsTransform, placeholderSize, true, z2, f2, overlayClip);
    }

    public static /* synthetic */ Modifier sharedBoundsWithCallerManagedVisibility$animation$default(SharedTransitionScopeImpl sharedTransitionScopeImpl, Modifier modifier, SharedTransitionScope.SharedContentState sharedContentState, boolean z, BoundsTransform boundsTransform, SharedTransitionScope.PlaceholderSize placeholderSize, boolean z2, float f2, SharedTransitionScope.OverlayClip overlayClip, int i, Object obj) {
        if ((i & 4) != 0) {
            boundsTransform = SharedTransitionDefaults.INSTANCE.getBoundsTransform();
        }
        BoundsTransform boundsTransform2 = boundsTransform;
        if ((i & 8) != 0) {
            placeholderSize = SharedTransitionScope.PlaceholderSize.INSTANCE.getContentSize();
        }
        return sharedTransitionScopeImpl.sharedBoundsWithCallerManagedVisibility$animation(modifier, sharedContentState, z, boundsTransform2, placeholderSize, (i & 16) != 0 ? true : z2, (i & 32) != 0 ? 0.0f : f2, (i & 64) != 0 ? SharedTransitionScopeKt.ParentClip : overlayClip);
    }

    public final Modifier sharedBoundsWithCallerManagedVisibility$animation(Modifier modifier, SharedTransitionScope.SharedContentState sharedContentState, final boolean z, BoundsTransform boundsTransform, SharedTransitionScope.PlaceholderSize placeholderSize, boolean z2, float f2, SharedTransitionScope.OverlayClip overlayClip) {
        return sharedBoundsImpl(modifier, sharedContentState, null, new Function1<Unit, Boolean>() { // from class: androidx.compose.animation.SharedTransitionScopeImpl$sharedBoundsWithCallerManagedVisibility$1
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            {
                super(1);
            }

            @Override // kotlin.jvm.functions.Function1
            public final Boolean invoke(Unit unit) {
                return Boolean.valueOf(z);
            }
        }, boundsTransform, placeholderSize, false, z2, f2, overlayClip);
    }

    @Override // androidx.compose.animation.SharedTransitionScope
    public SharedTransitionScope.OverlayClip OverlayClip(Shape clipShape) {
        return new ShapeBasedClip(clipShape);
    }

    public final Function0<Unit> getObserveAnimatingBlock$animation() {
        return this.observeAnimatingBlock;
    }

    private final void attachLookaheadAnimationVisualDebugHelper() {
        LookaheadAnimationVisualDebugHelper lookaheadAnimationVisualDebugHelper;
        if (!IsLookaheadAnimationVisualDebuggingEnabledKt.isLookaheadAnimationVisualDebuggingEnabled() || (lookaheadAnimationVisualDebugHelper = this.lookaheadAnimationVisualDebugHelper) == null) {
            return;
        }
        lookaheadAnimationVisualDebugHelper.onAttach$animation(this.coroutineScope);
    }

    private final void detachLookaheadAnimationVisualDebugHelper() {
        LookaheadAnimationVisualDebugHelper lookaheadAnimationVisualDebugHelper;
        if (!IsLookaheadAnimationVisualDebuggingEnabledKt.isLookaheadAnimationVisualDebuggingEnabled() || (lookaheadAnimationVisualDebugHelper = this.lookaheadAnimationVisualDebugHelper) == null) {
            return;
        }
        lookaheadAnimationVisualDebugHelper.onDetach$animation(this.coroutineScope);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final <T> Modifier sharedBoundsImpl(Modifier modifier, final SharedTransitionScope.SharedContentState sharedContentState, final Transition<T> transition, final Function1<? super T, Boolean> function1, final BoundsTransform boundsTransform, final SharedTransitionScope.PlaceholderSize placeholderSize, final boolean z, final boolean z2, final float f2, final SharedTransitionScope.OverlayClip overlayClip) {
        return ComposedModifierKt.composed$default(modifier, null, new Function3<Modifier, Composer, Integer, Modifier>() { // from class: androidx.compose.animation.SharedTransitionScopeImpl.sharedBoundsImpl.1
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            /* JADX WARN: Multi-variable type inference failed */
            {
                super(3);
            }

            @Override // kotlin.jvm.functions.Function3
            public /* bridge */ /* synthetic */ Modifier invoke(Modifier modifier2, Composer composer, Integer num) {
                return invoke(modifier2, composer, num.intValue());
            }

            /* JADX WARN: Type inference incomplete: some casts might be missing */
            public final Modifier invoke(Modifier modifier2, Composer composer, int i) {
                Transition transitionRememberTransition;
                Composer composer2 = composer;
                composer2.startReplaceGroup(-1539505585);
                ComposerKt.sourceInformation(composer2, "C:SharedTransitionScope.kt#xbi5r1");
                if (ComposerKt.isTraceInProgress()) {
                    ComposerKt.traceEventStart(-1539505585, i, -1, "androidx.compose.animation.SharedTransitionScopeImpl.sharedBoundsImpl.<anonymous> (SharedTransitionScope.kt:1284)");
                }
                Object key = sharedContentState.getKey();
                composer2.startMovableGroup(-1996110647, key);
                ComposerKt.sourceInformation(composer2, "1287@70741L35,1342@74019L559");
                ComposerKt.sourceInformationMarkerStart(composer2, -1996113006, "CC(remember):SharedTransitionScope.kt#9igjgp");
                SharedTransitionScopeImpl sharedTransitionScopeImpl = this;
                Object objRememberedValue = composer2.rememberedValue();
                if (objRememberedValue == Composer.INSTANCE.getEmpty()) {
                    objRememberedValue = sharedTransitionScopeImpl.sharedElementsFor(key);
                    composer2.updateRememberedValue(objRememberedValue);
                }
                SharedElement sharedElement = (SharedElement) objRememberedValue;
                ComposerKt.sourceInformationMarkerEnd(composer2);
                composer2.startMovableGroup(-1996106866, transition);
                ComposerKt.sourceInformation(composer2, "1324@73090L438");
                boolean z3 = false;
                if (transition != 0) {
                    composer2.startReplaceGroup(-1749734647);
                    ComposerKt.sourceInformation(composer2, "1292@71015L121");
                    Transition<T> transition2 = transition;
                    String string = key.toString();
                    Function1<T, Boolean> function12 = function1;
                    ComposerKt.sourceInformationMarkerStart(composer2, -539313577, "CC(createChildTransition)N(label,transformToChildState)1788@75927L36,1789@75987L74,1790@76084L39,1791@76135L63:Transition.kt#pdpnli");
                    ComposerKt.sourceInformationMarkerStart(composer2, 1410701659, "CC(remember):Transition.kt#9igjgp");
                    boolean zChanged = composer2.changed(transition2);
                    Object objRememberedValue2 = composer2.rememberedValue();
                    if (zChanged || objRememberedValue2 == Composer.INSTANCE.getEmpty()) {
                        objRememberedValue2 = transition2.getCurrentState();
                        composer2.updateRememberedValue(objRememberedValue2);
                    }
                    ComposerKt.sourceInformationMarkerEnd(composer2);
                    if (transition2.isSeeking()) {
                        objRememberedValue2 = transition2.getCurrentState();
                    }
                    composer2.startReplaceGroup(1498260051);
                    ComposerKt.sourceInformation(composer2, "CN(it):SharedTransitionScope.kt#xbi5r1");
                    if (ComposerKt.isTraceInProgress()) {
                        ComposerKt.traceEventStart(1498260051, 0, -1, "androidx.compose.animation.SharedTransitionScopeImpl.sharedBoundsImpl.<anonymous>.<anonymous>.<anonymous>.<anonymous> (SharedTransitionScope.kt:1293)");
                    }
                    boolean zBooleanValue = function12.invoke((T) objRememberedValue2).booleanValue();
                    if (ComposerKt.isTraceInProgress()) {
                        ComposerKt.traceEventEnd();
                    }
                    composer2.endReplaceGroup();
                    Boolean boolValueOf = Boolean.valueOf(zBooleanValue);
                    Object targetState = transition2.getTargetState();
                    composer2.startReplaceGroup(1498260051);
                    ComposerKt.sourceInformation(composer2, "CN(it):SharedTransitionScope.kt#xbi5r1");
                    if (ComposerKt.isTraceInProgress()) {
                        ComposerKt.traceEventStart(1498260051, 0, -1, "androidx.compose.animation.SharedTransitionScopeImpl.sharedBoundsImpl.<anonymous>.<anonymous>.<anonymous>.<anonymous> (SharedTransitionScope.kt:1293)");
                    }
                    boolean zBooleanValue2 = function12.invoke((T) targetState).booleanValue();
                    if (ComposerKt.isTraceInProgress()) {
                        ComposerKt.traceEventEnd();
                    }
                    composer2.endReplaceGroup();
                    transitionRememberTransition = androidx.compose.animation.core.TransitionKt.createChildTransitionInternal(transition2, boolValueOf, Boolean.valueOf(zBooleanValue2), string, composer2, 0);
                    composer2 = composer2;
                    ComposerKt.sourceInformationMarkerEnd(composer2);
                    composer2.endReplaceGroup();
                } else {
                    composer2.startReplaceGroup(-1749482679);
                    ComposerKt.sourceInformation(composer2, "1299@71418L1251,1318@72781L35");
                    Function1<T, Boolean> function13 = function1;
                    Intrinsics.checkNotNull(function13, "null cannot be cast to non-null type kotlin.Function1<kotlin.Unit, kotlin.Boolean>");
                    boolean zBooleanValue3 = ((Boolean) ((Function1) TypeIntrinsics.beforeCheckcastToFunctionOfArity(function13, 1)).invoke(Unit.INSTANCE)).booleanValue();
                    ComposerKt.sourceInformationMarkerStart(composer2, -1996090126, "CC(remember):SharedTransitionScope.kt#9igjgp");
                    Object objRememberedValue3 = composer2.rememberedValue();
                    if (objRememberedValue3 == Composer.INSTANCE.getEmpty()) {
                        if (sharedElement.getEnabledEntries().isEmpty()) {
                            z3 = zBooleanValue3;
                        } else if (!zBooleanValue3) {
                            z3 = true;
                        }
                        objRememberedValue3 = new MutableTransitionState(Boolean.valueOf(z3));
                        composer2.updateRememberedValue(objRememberedValue3);
                    }
                    MutableTransitionState mutableTransitionState = (MutableTransitionState) objRememberedValue3;
                    ComposerKt.sourceInformationMarkerEnd(composer2);
                    mutableTransitionState.setTargetState$animation_core(Boolean.valueOf(zBooleanValue3));
                    transitionRememberTransition = androidx.compose.animation.core.TransitionKt.rememberTransition(mutableTransitionState, null, composer2, MutableTransitionState.$stable, 2);
                    composer2.endReplaceGroup();
                }
                composer2.startMovableGroup(-1996043323, Boolean.valueOf(this.isTransitionActive()));
                ComposerKt.sourceInformation(composer2, "1322@72990L45");
                Transition<Boolean>.DeferredAnimation<Rect, AnimationVector4D> deferredAnimationCreateDeferredAnimation = androidx.compose.animation.core.TransitionKt.createDeferredAnimation(transitionRememberTransition, VectorConvertersKt.getVectorConverter(Rect.INSTANCE), null, composer2, 0, 2);
                composer2.endMovableGroup();
                ComposerKt.sourceInformationMarkerStart(composer2, -1996037435, "CC(remember):SharedTransitionScope.kt#9igjgp");
                boolean zChanged2 = composer2.changed(transitionRememberTransition);
                SharedTransitionScopeImpl sharedTransitionScopeImpl2 = this;
                BoundsTransform boundsTransform2 = boundsTransform;
                Object objRememberedValue4 = composer2.rememberedValue();
                if (zChanged2 || objRememberedValue4 == Composer.INSTANCE.getEmpty()) {
                    BoundsAnimation boundsAnimation = new BoundsAnimation(sharedTransitionScopeImpl2, transitionRememberTransition, deferredAnimationCreateDeferredAnimation, boundsTransform2, sharedElement.getMomentumAnimationOffset());
                    composer2.updateRememberedValue(boundsAnimation);
                    objRememberedValue4 = boundsAnimation;
                }
                BoundsAnimation boundsAnimation2 = (BoundsAnimation) objRememberedValue4;
                ComposerKt.sourceInformationMarkerEnd(composer2);
                boundsAnimation2.updateAnimation(deferredAnimationCreateDeferredAnimation, boundsTransform);
                composer2.endMovableGroup();
                SharedElementEntry sharedElementEntryRememberSharedElementState = this.rememberSharedElementState(sharedElement, boundsAnimation2, placeholderSize, z, sharedContentState, overlayClip, f2, z2, composer, 0);
                composer.endMovableGroup();
                Modifier modifierThen = modifier2.then(new SharedBoundsNodeElement(sharedElementEntryRememberSharedElementState));
                if (ComposerKt.isTraceInProgress()) {
                    ComposerKt.traceEventEnd();
                }
                composer.endReplaceGroup();
                return modifierThen;
            }
        }, 1, null);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final SharedElementEntry rememberSharedElementState(SharedElement sharedElement, BoundsAnimation boundsAnimation, SharedTransitionScope.PlaceholderSize placeholderSize, boolean z, SharedTransitionScope.SharedContentState sharedContentState, SharedTransitionScope.OverlayClip overlayClip, float f2, boolean z2, Composer composer, int i) {
        ComposerKt.sourceInformationMarkerStart(composer, 864401334, "C(rememberSharedElementState)N(sharedElement,boundsAnimation,placeholderSize,renderOnlyWhenVisible,sharedContentState,clipInOverlayDuringTransition,zIndexInOverlay,renderInOverlayDuringTransition)1368@75103L504:SharedTransitionScope.kt#xbi5r1");
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventStart(864401334, i, -1, "androidx.compose.animation.SharedTransitionScopeImpl.rememberSharedElementState (SharedTransitionScope.kt:1368)");
        }
        ComposerKt.sourceInformationMarkerStart(composer, 1761007534, "CC(remember):SharedTransitionScope.kt#9igjgp");
        Object objRememberedValue = composer.rememberedValue();
        if (objRememberedValue == Composer.INSTANCE.getEmpty()) {
            objRememberedValue = new SharedElementEntry(sharedElement, boundsAnimation, placeholderSize, z, overlayClip, z2, sharedContentState, f2);
            composer.updateRememberedValue(objRememberedValue);
        }
        SharedElementEntry sharedElementEntry = (SharedElementEntry) objRememberedValue;
        ComposerKt.sourceInformationMarkerEnd(composer);
        sharedContentState.setInternalState$animation(sharedElementEntry);
        sharedElementEntry.setSharedElement(sharedElement);
        sharedElementEntry.setRenderOnlyWhenVisible(z);
        sharedElementEntry.setBoundsAnimation(boundsAnimation);
        sharedElementEntry.setPlaceholderSize(placeholderSize);
        sharedElementEntry.setOverlayClip(overlayClip);
        sharedElementEntry.setZIndex(f2);
        sharedElementEntry.setRenderInOverlayDuringTransition(z2);
        sharedElementEntry.setUserState(sharedContentState);
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventEnd();
        }
        ComposerKt.sourceInformationMarkerEnd(composer);
        return sharedElementEntry;
    }

    public final LayoutCoordinates getRoot$animation() {
        LayoutCoordinates layoutCoordinates = this.nullableRoot;
        if (layoutCoordinates != null) {
            return layoutCoordinates;
        }
        throw new IllegalArgumentException("Error: Uninitialized LayoutCoordinates. Please make sure when using the SharedTransitionScope composable function, the modifier passed to the child content is being used, or use SharedTransitionLayout instead.".toString());
    }

    public final void setRoot$animation(LayoutCoordinates layoutCoordinates) {
        this.nullableRoot = layoutCoordinates;
    }

    /* JADX INFO: renamed from: getNullableRoot$animation, reason: from getter */
    public final LayoutCoordinates getNullableRoot() {
        return this.nullableRoot;
    }

    public final LayoutCoordinates getLookaheadRoot$animation() {
        LayoutCoordinates layoutCoordinates = this._nullableLookaheadRoot;
        if (layoutCoordinates != null) {
            return layoutCoordinates;
        }
        throw new IllegalArgumentException("Error: Uninitialized LayoutCoordinates. Please make sure when using the SharedTransitionScope composable function, the modifier passed to the child content is being used, or use SharedTransitionLayout instead.".toString());
    }

    public final void setLookaheadRoot$animation(LayoutCoordinates layoutCoordinates) {
        this._nullableLookaheadRoot = layoutCoordinates;
    }

    private final Collection<SharedElement> getSharedElementsIterator() {
        return this.sharedElements.toMap().values();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final SharedElement sharedElementsFor(Object key) {
        SharedElement sharedElement = this.sharedElements.get(key);
        if (sharedElement != null) {
            return sharedElement;
        }
        SharedElement sharedElement2 = new SharedElement(key, this);
        this.sharedElements.put(key, sharedElement2);
        return sharedElement2;
    }

    public final void drawInOverlay$animation(ContentDrawScope scope) {
        SnapshotStateList<LayerRenderer> snapshotStateList = this.renderers;
        if (snapshotStateList.size() > 1) {
            CollectionsKt.sortWith(snapshotStateList, new Comparator() { // from class: androidx.compose.animation.SharedTransitionScopeImpl$drawInOverlay$$inlined$sortBy$1
                @Override // java.util.Comparator
                public final int compare(T t, T t2) {
                    LayerRenderer layerRenderer = (LayerRenderer) t;
                    LayerRenderer layerRenderer2 = (LayerRenderer) t2;
                    return ComparisonsKt.compareValues(Float.valueOf((layerRenderer.getZIndex() == 0.0f && (layerRenderer instanceof SharedElementEntry) && ((SharedElementEntry) layerRenderer).getParentState() == null) ? -1.0f : layerRenderer.getZIndex()), Float.valueOf((layerRenderer2.getZIndex() == 0.0f && (layerRenderer2 instanceof SharedElementEntry) && ((SharedElementEntry) layerRenderer2).getParentState() == null) ? -1.0f : layerRenderer2.getZIndex()));
                }
            });
        }
        SnapshotStateList<LayerRenderer> snapshotStateList2 = this.renderers;
        int size = snapshotStateList2.size();
        for (int i = 0; i < size; i++) {
            snapshotStateList2.get(i).drawInOverlay(scope);
        }
    }

    public final void onEntryRemoved$animation(SharedElementEntry sharedElementState) {
        SharedElement sharedElement = sharedElementState.getSharedElement();
        sharedElement.removeEntry(sharedElementState);
        updateTransitionActiveness$animation();
        this.renderers.remove(sharedElementState);
        if (sharedElement.getAllEntries().isEmpty()) {
            BuildersKt__Builders_commonKt.launch$default(sharedElement.getScope().coroutineScope, null, null, new SharedTransitionScopeImpl$onEntryRemoved$2$1(sharedElement, sharedElementState, null), 3, null);
        }
    }

    public final void onEntryAdded$animation(SharedElementEntry sharedElementState) {
        sharedElementState.getSharedElement().addEntry(sharedElementState);
        updateTransitionActiveness$animation();
        Iterator<LayerRenderer> it = this.renderers.iterator();
        int i = 0;
        while (true) {
            if (!it.hasNext()) {
                i = -1;
                break;
            }
            LayerRenderer next = it.next();
            SharedElementEntry sharedElementEntry = next instanceof SharedElementEntry ? (SharedElementEntry) next : null;
            if (Intrinsics.areEqual(sharedElementEntry != null ? sharedElementEntry.getSharedElement() : null, sharedElementState.getSharedElement())) {
                break;
            } else {
                i++;
            }
        }
        if (i == this.renderers.size() - 1 || i == -1) {
            this.renderers.add(sharedElementState);
        } else {
            this.renderers.add(i + 1, sharedElementState);
        }
    }

    public final void onLayerRendererCreated$animation(LayerRenderer renderer) {
        this.renderers.add(renderer);
    }

    public final void onLayerRendererRemoved$animation(LayerRenderer renderer) {
        this.renderers.remove(renderer);
    }

    /* JADX INFO: compiled from: SharedTransitionScope.kt */
    @Metadata(d1 = {"\u00002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\b\u0002\u0018\u00002\u00020\u0001B\u000f\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0004\b\u0004\u0010\u0005J(\u0010\n\u001a\u00020\t2\u0006\u0010\u000b\u001a\u00020\f2\u0006\u0010\r\u001a\u00020\u000e2\u0006\u0010\u000f\u001a\u00020\u00102\u0006\u0010\u0011\u001a\u00020\u0012H\u0016R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0006\u0010\u0007R\u000e\u0010\b\u001a\u00020\tX\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006\u0013"}, d2 = {"Landroidx/compose/animation/SharedTransitionScopeImpl$ShapeBasedClip;", "Landroidx/compose/animation/SharedTransitionScope$OverlayClip;", "clipShape", "Landroidx/compose/ui/graphics/Shape;", "<init>", "(Landroidx/compose/ui/graphics/Shape;)V", "getClipShape", "()Landroidx/compose/ui/graphics/Shape;", "path", "Landroidx/compose/ui/graphics/Path;", "getClipPath", "sharedContentState", "Landroidx/compose/animation/SharedTransitionScope$SharedContentState;", "bounds", "Landroidx/compose/ui/geometry/Rect;", "layoutDirection", "Landroidx/compose/ui/unit/LayoutDirection;", "density", "Landroidx/compose/ui/unit/Density;", "animation"}, k = 1, mv = {2, 1, 0}, xi = 48)
    private static final class ShapeBasedClip implements SharedTransitionScope.OverlayClip {
        private final Shape clipShape;
        private final Path path = AndroidPath_androidKt.Path();

        public ShapeBasedClip(Shape shape) {
            this.clipShape = shape;
        }

        public final Shape getClipShape() {
            return this.clipShape;
        }

        @Override // androidx.compose.animation.SharedTransitionScope.OverlayClip
        public Path getClipPath(SharedTransitionScope.SharedContentState sharedContentState, Rect bounds, LayoutDirection layoutDirection, Density density) {
            this.path.reset();
            OutlineKt.addOutline(this.path, this.clipShape.mo382createOutlinePq9zytI(bounds.m5756getSizeNHjbRc(), layoutDirection, density));
            this.path.mo5860translatek4lQ0M(bounds.m5758getTopLeftF1C5BW0());
            return this.path;
        }
    }

    public final void updateTransitionActiveness$animation() {
        Collection<SharedElement> collectionValues = this.sharedElements.toMap().values();
        boolean z = false;
        for (SharedElement sharedElement : collectionValues) {
            z = z || (sharedElement.getFoundMatch() && sharedElement.isAnimating());
            sharedElement.updateMatch$animation();
        }
        if (z != isTransitionActive()) {
            setTransitionActive(z);
            if (!z) {
                attachLookaheadAnimationVisualDebugHelper();
                Iterator it = collectionValues.iterator();
                while (it.hasNext()) {
                    ((SharedElement) it.next()).onSharedTransitionFinished();
                }
                return;
            }
            detachLookaheadAnimationVisualDebugHelper();
        }
    }
}
