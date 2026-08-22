package androidx.compose.animation;

import androidx.compose.animation.SharedTransitionStateMachine;
import androidx.compose.animation.core.AnimationSpecKt;
import androidx.compose.animation.core.FiniteAnimationSpec;
import androidx.compose.animation.core.SpringSpec;
import androidx.compose.animation.core.VisibilityThresholdsKt;
import androidx.compose.ui.Modifier;
import androidx.compose.ui.geometry.Offset;
import androidx.compose.ui.geometry.Rect;
import androidx.compose.ui.geometry.RectKt;
import androidx.compose.ui.graphics.Color;
import androidx.compose.ui.graphics.drawscope.ContentDrawScope;
import androidx.compose.ui.graphics.drawscope.DrawScope;
import androidx.compose.ui.graphics.layer.GraphicsLayer;
import androidx.compose.ui.graphics.layer.GraphicsLayerKt;
import androidx.compose.ui.layout.ApproachLayoutModifierNode;
import androidx.compose.ui.layout.ApproachMeasureScope;
import androidx.compose.ui.layout.LayoutCoordinates;
import androidx.compose.ui.layout.LayoutCoordinatesKt;
import androidx.compose.ui.layout.Measurable;
import androidx.compose.ui.layout.MeasureResult;
import androidx.compose.ui.layout.MeasureScope;
import androidx.compose.ui.layout.Placeable;
import androidx.compose.ui.modifier.ModifierLocalMap;
import androidx.compose.ui.modifier.ModifierLocalModifierNode;
import androidx.compose.ui.modifier.ModifierLocalModifierNodeKt;
import androidx.compose.ui.node.CompositionLocalConsumerModifierNode;
import androidx.compose.ui.node.CompositionLocalConsumerModifierNodeKt;
import androidx.compose.ui.node.DelegatableNodeKt;
import androidx.compose.ui.node.DrawModifierNode;
import androidx.compose.ui.node.ObserverModifierNode;
import androidx.compose.ui.node.ObserverModifierNodeKt;
import androidx.compose.ui.text.TextMeasurer;
import androidx.compose.ui.text.font.FontFamily;
import androidx.compose.ui.unit.Constraints;
import androidx.compose.ui.unit.Density;
import androidx.compose.ui.unit.Dp;
import androidx.compose.ui.unit.IntOffset;
import androidx.compose.ui.unit.IntOffsetKt;
import androidx.compose.ui.unit.IntSize;
import androidx.compose.ui.unit.IntSizeKt;
import androidx.compose.ui.unit.LayoutDirection;
import com.appnew.android.Utils.Const;
import kotlin.Metadata;
import kotlin.TuplesKt;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlin.ranges.RangesKt;

/* JADX INFO: compiled from: SharedContentNode.kt */
/* JADX INFO: loaded from: classes.dex */
@Metadata(d1 = {"\u0000Ö\u0001\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0002\b\t\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0004\b\u0001\u0018\u00002\u00020\u00012\u00020\u00022\u00020\u00032\u00020\u00042\u00020\u00052\u00020\u00062\u00020\u0007B\u000f\u0012\u0006\u0010\b\u001a\u00020\t¢\u0006\u0004\b\n\u0010\u000bJ\u0012\u0010\u0011\u001a\u0004\u0018\u00010\r2\u0006\u0010\u0012\u001a\u00020\rH\u0016J\b\u0010 \u001a\u00020\u0014H\u0002J\b\u00101\u001a\u000202H\u0002J\b\u00103\u001a\u000202H\u0016J\b\u00104\u001a\u000202H\u0016J\b\u00105\u001a\u000202H\u0016J#\u00106\u001a\u000207*\u0002082\u0006\u00109\u001a\u00020:2\u0006\u0010;\u001a\u00020<H\u0016¢\u0006\u0004\b=\u0010>J\u001c\u0010I\u001a\u000202*\u00020J2\u0006\u0010K\u001a\u00020L2\u0006\u0010M\u001a\u00020\rH\u0002J)\u0010N\u001a\u000202*\u00020J2\u0006\u0010K\u001a\u00020L2\u0006\u0010O\u001a\u00020P2\u0006\u0010M\u001a\u00020\rH\u0000¢\u0006\u0002\bQJ\u0014\u0010R\u001a\u000207*\u0002082\u0006\u0010K\u001a\u00020LH\u0002J\u0017\u0010S\u001a\u00020\u00182\u0006\u0010T\u001a\u00020UH\u0016¢\u0006\u0004\bV\u0010WJ#\u0010X\u001a\u000207*\u00020Y2\u0006\u00109\u001a\u00020:2\u0006\u0010;\u001a\u00020<H\u0016¢\u0006\u0004\bZ\u0010[J\f\u0010\\\u001a\u000202*\u00020]H\u0016J&\u0010^\u001a\u000202*\u00020]2\u0006\u0010&\u001a\u00020%2\b\u0010_\u001a\u0004\u0018\u00010\r2\u0006\u0010`\u001a\u00020aH\u0002J\b\u0010b\u001a\u000202H\u0016J\u0010\u0010c\u001a\u0002022\u0006\u0010d\u001a\u00020DH\u0002R\u0010\u0010\f\u001a\u0004\u0018\u00010\rX\u0082\u000e¢\u0006\u0002\n\u0000R\u0016\u0010\u000e\u001a\u0004\u0018\u00010\r8VX\u0096\u0004¢\u0006\u0006\u001a\u0004\b\u000f\u0010\u0010R\u0014\u0010\u0013\u001a\u00020\u00148BX\u0082\u0004¢\u0006\u0006\u001a\u0004\b\u0015\u0010\u0016R\u000e\u0010\u0017\u001a\u00020\u0018X\u0082\u000e¢\u0006\u0002\n\u0000R\u0014\u0010\u0019\u001a\u00020\u00148BX\u0082\u0004¢\u0006\u0006\u001a\u0004\b\u001a\u0010\u0016R$\u0010\u001c\u001a\u00020\t2\u0006\u0010\u001b\u001a\u00020\t@@X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u001d\u0010\u001e\"\u0004\b\u001f\u0010\u000bR\u0014\u0010!\u001a\u00020\"8BX\u0082\u0004¢\u0006\u0006\u001a\u0004\b#\u0010$R\"\u0010&\u001a\u0004\u0018\u00010%2\b\u0010\u001b\u001a\u0004\u0018\u00010%@BX\u0082\u000e¢\u0006\b\n\u0000\"\u0004\b'\u0010(R\u0014\u0010)\u001a\u00020*8BX\u0082\u0004¢\u0006\u0006\u001a\u0004\b+\u0010,R\u0014\u0010-\u001a\u00020.X\u0096\u0004¢\u0006\b\n\u0000\u001a\u0004\b/\u00100R\u0010\u0010?\u001a\u0004\u0018\u00010@X\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010A\u001a\u0004\u0018\u00010BX\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010C\u001a\u0004\u0018\u00010DX\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010E\u001a\u0004\u0018\u00010FX\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010G\u001a\u0004\u0018\u00010HX\u0082\u000e¢\u0006\u0002\n\u0000¨\u0006e"}, d2 = {"Landroidx/compose/animation/SharedBoundsNode;", "Landroidx/compose/ui/layout/ApproachLayoutModifierNode;", "Landroidx/compose/ui/Modifier$Node;", "Landroidx/compose/ui/node/DrawModifierNode;", "Landroidx/compose/ui/modifier/ModifierLocalModifierNode;", "Landroidx/compose/ui/node/ObserverModifierNode;", "Landroidx/compose/animation/BoundsProvider;", "Landroidx/compose/ui/node/CompositionLocalConsumerModifierNode;", "state", "Landroidx/compose/animation/SharedElementEntry;", "<init>", "(Landroidx/compose/animation/SharedElementEntry;)V", "boundsBeforeDetached", "Landroidx/compose/ui/geometry/Rect;", "lastBoundsInSharedTransitionScope", "getLastBoundsInSharedTransitionScope", "()Landroidx/compose/ui/geometry/Rect;", "calculateAlternativeTargetBounds", "targetBoundsBeforeDisposed", "approachCoordinates", "Landroidx/compose/ui/layout/LayoutCoordinates;", "getApproachCoordinates", "()Landroidx/compose/ui/layout/LayoutCoordinates;", "isPlaced", "", "rootCoords", "getRootCoords", "value", "sharedElementEntry", "getSharedElementEntry", "()Landroidx/compose/animation/SharedElementEntry;", "setSharedElementEntry$animation", "requireLookaheadLayoutCoordinates", "boundsAnimation", "Landroidx/compose/animation/BoundsAnimation;", "getBoundsAnimation", "()Landroidx/compose/animation/BoundsAnimation;", "Landroidx/compose/ui/graphics/layer/GraphicsLayer;", Const.LAYER, "setLayer", "(Landroidx/compose/ui/graphics/layer/GraphicsLayer;)V", "sharedElement", "Landroidx/compose/animation/SharedElement;", "getSharedElement", "()Landroidx/compose/animation/SharedElement;", "providedValues", "Landroidx/compose/ui/modifier/ModifierLocalMap;", "getProvidedValues", "()Landroidx/compose/ui/modifier/ModifierLocalMap;", "setup", "", "onAttach", "onDetach", "onReset", "measure", "Landroidx/compose/ui/layout/MeasureResult;", "Landroidx/compose/ui/layout/MeasureScope;", "measurable", "Landroidx/compose/ui/layout/Measurable;", "constraints", "Landroidx/compose/ui/unit/Constraints;", "measure-3p2s80s", "(Landroidx/compose/ui/layout/MeasureScope;Landroidx/compose/ui/layout/Measurable;J)Landroidx/compose/ui/layout/MeasureResult;", "textMeasurer", "Landroidx/compose/ui/text/TextMeasurer;", "lookaheadAnimationVisualDebugHelper", "Landroidx/compose/animation/LookaheadAnimationVisualDebugHelper;", "currentResolver", "Landroidx/compose/ui/text/font/FontFamily$Resolver;", "currentDensity", "Landroidx/compose/ui/unit/Density;", "currentLayoutDirection", "Landroidx/compose/ui/unit/LayoutDirection;", "approachPlaceMatchBeyondTransition", "Landroidx/compose/ui/layout/Placeable$PlacementScope;", "placeable", "Landroidx/compose/ui/layout/Placeable;", "currentBounds", "approachPlaceMatchInTransition", "targetData", "Landroidx/compose/animation/TargetData;", "approachPlaceMatchInTransition$animation", "approachPlace", "isMeasurementApproachInProgress", "lookaheadSize", "Landroidx/compose/ui/unit/IntSize;", "isMeasurementApproachInProgress-ozmzZPI", "(J)Z", "approachMeasure", "Landroidx/compose/ui/layout/ApproachMeasureScope;", "approachMeasure-3p2s80s", "(Landroidx/compose/ui/layout/ApproachMeasureScope;Landroidx/compose/ui/layout/Measurable;J)Landroidx/compose/ui/layout/MeasureResult;", "draw", "Landroidx/compose/ui/graphics/drawscope/ContentDrawScope;", "drawContentWithLookaheadAnimationDebug", "bounds", "visualDebugConfig", "Landroidx/compose/animation/LookaheadAnimationVisualDebugConfig;", "onObservedReadsChanged", "updateTextMeasurer", "fontFamilyResolver", "animation"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final class SharedBoundsNode extends Modifier.Node implements ApproachLayoutModifierNode, DrawModifierNode, ModifierLocalModifierNode, ObserverModifierNode, BoundsProvider, CompositionLocalConsumerModifierNode {
    public static final int $stable = 8;
    private Rect boundsBeforeDetached;
    private Density currentDensity;
    private LayoutDirection currentLayoutDirection;
    private FontFamily.Resolver currentResolver;
    private boolean isPlaced;
    private GraphicsLayer layer;
    private LookaheadAnimationVisualDebugHelper lookaheadAnimationVisualDebugHelper;
    private final ModifierLocalMap providedValues;
    private SharedElementEntry sharedElementEntry;
    private TextMeasurer textMeasurer;

    public SharedBoundsNode(SharedElementEntry sharedElementEntry) {
        this.sharedElementEntry = sharedElementEntry;
        this.layer = sharedElementEntry.getLayer();
        this.providedValues = ModifierLocalModifierNodeKt.modifierLocalMapOf(TuplesKt.to(SharedContentNodeKt.getModifierLocalSharedElementInternalState(), sharedElementEntry));
    }

    @Override // androidx.compose.animation.BoundsProvider
    public Rect getLastBoundsInSharedTransitionScope() {
        if (getIsAttached()) {
            return !this.isPlaced ? this.boundsBeforeDetached : RectKt.m5763Recttz77jQw(LayoutCoordinates.m7452localPositionOfS_NoaFU$default(getRootCoords(), getApproachCoordinates(), 0L, false, 6, null), IntSizeKt.m9013toSizeozmzZPI(getApproachCoordinates().mo7453getSizeYbymL2g()));
        }
        return null;
    }

    @Override // androidx.compose.animation.BoundsProvider
    public Rect calculateAlternativeTargetBounds(Rect targetBoundsBeforeDisposed) {
        return this.sharedElementEntry.calculateTargetBounds(targetBoundsBeforeDisposed);
    }

    private final LayoutCoordinates getApproachCoordinates() {
        return DelegatableNodeKt.requireLayoutCoordinates(this);
    }

    private final LayoutCoordinates getRootCoords() {
        return getSharedElement().getScope().getRoot$animation();
    }

    public final SharedElementEntry getSharedElementEntry() {
        return this.sharedElementEntry;
    }

    public final void setSharedElementEntry$animation(SharedElementEntry sharedElementEntry) {
        if (Intrinsics.areEqual(sharedElementEntry, this.sharedElementEntry)) {
            return;
        }
        this.sharedElementEntry.setAttached(false);
        this.sharedElementEntry = sharedElementEntry;
        sharedElementEntry.setAttached(getIsAttached());
        if (getIsAttached()) {
            setup();
        }
    }

    private final LayoutCoordinates requireLookaheadLayoutCoordinates() {
        return this.sharedElementEntry.getSharedElement().getScope().toLookaheadCoordinates(DelegatableNodeKt.requireLayoutCoordinates(this));
    }

    private final BoundsAnimation getBoundsAnimation() {
        return this.sharedElementEntry.getBoundsAnimation();
    }

    private final void setLayer(GraphicsLayer graphicsLayer) {
        if (graphicsLayer == null) {
            GraphicsLayer graphicsLayer2 = this.layer;
            if (graphicsLayer2 != null) {
                DelegatableNodeKt.requireGraphicsContext(this).releaseGraphicsLayer(graphicsLayer2);
            }
        } else {
            this.sharedElementEntry.setLayer(graphicsLayer);
        }
        this.layer = graphicsLayer;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final SharedElement getSharedElement() {
        return this.sharedElementEntry.getSharedElement();
    }

    @Override // androidx.compose.ui.modifier.ModifierLocalModifierNode
    public ModifierLocalMap getProvidedValues() {
        return this.providedValues;
    }

    private final void setup() {
        provide(SharedContentNodeKt.getModifierLocalSharedElementInternalState(), this.sharedElementEntry);
        this.sharedElementEntry.setParentState((SharedElementEntry) getCurrent(SharedContentNodeKt.getModifierLocalSharedElementInternalState()));
        setLayer(DelegatableNodeKt.requireGraphicsContext(this).createGraphicsLayer());
        this.isPlaced = false;
        this.sharedElementEntry.setBoundsProvider(this);
    }

    @Override // androidx.compose.ui.Modifier.Node
    public void onAttach() {
        super.onAttach();
        ObserverModifierNodeKt.observeReads(this, getSharedElement().getObservingVisibilityChange$animation());
        setup();
        this.sharedElementEntry.setAttached(true);
    }

    @Override // androidx.compose.ui.Modifier.Node
    public void onDetach() {
        super.onDetach();
        LayoutCoordinates nullableRoot = getSharedElement().getScope().getNullableRoot();
        if (nullableRoot != null) {
            this.boundsBeforeDetached = (nullableRoot.isAttached() && this.isPlaced) ? RectKt.m5763Recttz77jQw(Offset.m5727minusMKHz9U(LayoutCoordinatesKt.positionInRoot(getApproachCoordinates()), LayoutCoordinatesKt.positionInRoot(nullableRoot)), IntSizeKt.m9013toSizeozmzZPI(getApproachCoordinates().mo7453getSizeYbymL2g())) : null;
        }
        setLayer(null);
        this.sharedElementEntry.setParentState(null);
        this.sharedElementEntry.setBoundsProvider(null);
        this.sharedElementEntry.setAttached(false);
        this.isPlaced = false;
    }

    @Override // androidx.compose.ui.Modifier.Node
    public void onReset() {
        super.onReset();
        this.boundsBeforeDetached = null;
        GraphicsLayer graphicsLayer = this.layer;
        if (graphicsLayer != null) {
            DelegatableNodeKt.requireGraphicsContext(this).releaseGraphicsLayer(graphicsLayer);
        }
        setLayer(DelegatableNodeKt.requireGraphicsContext(this).createGraphicsLayer());
    }

    @Override // androidx.compose.ui.layout.ApproachLayoutModifierNode, androidx.compose.ui.node.LayoutModifierNode
    /* JADX INFO: renamed from: measure-3p2s80s */
    public MeasureResult mo72measure3p2s80s(MeasureScope measureScope, Measurable measurable, long j) {
        final Placeable placeableMo7445measureBRTryo0 = measurable.mo7445measureBRTryo0(j);
        return MeasureScope.layout$default(measureScope, placeableMo7445measureBRTryo0.getWidth(), placeableMo7445measureBRTryo0.getHeight(), null, new Function1<Placeable.PlacementScope, Unit>() { // from class: androidx.compose.animation.SharedBoundsNode$measure$1
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            {
                super(1);
            }

            @Override // kotlin.jvm.functions.Function1
            public /* bridge */ /* synthetic */ Unit invoke(Placeable.PlacementScope placementScope) {
                invoke2(placementScope);
                return Unit.INSTANCE;
            }

            /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
            public final void invoke2(Placeable.PlacementScope placementScope) {
                Placeable.PlacementScope.place$default(placementScope, placeableMo7445measureBRTryo0, 0, 0, 0.0f, 4, null);
                this.getSharedElement().onLookaheadPlaced(placementScope, this.getSharedElementEntry());
            }
        }, 4, null);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void approachPlaceMatchBeyondTransition(Placeable.PlacementScope placementScope, Placeable placeable, Rect rect) {
        long jM8969getZeronOccac;
        if (!getBoundsAnimation().getTarget()) {
            LayoutCoordinates coordinates = placementScope.getCoordinates();
            if (coordinates != null) {
                jM8969getZeronOccac = IntOffsetKt.m8975roundk4lQ0M(Offset.m5727minusMKHz9U(rect.m5758getTopLeftF1C5BW0(), getRootCoords().mo7454localPositionOfR5De75A(coordinates, Offset.INSTANCE.m5739getZeroF1C5BW0())));
            } else {
                jM8969getZeronOccac = IntOffset.INSTANCE.m8969getZeronOccac();
            }
            Placeable.PlacementScope.place$default(placementScope, placeable, IntOffset.m8958getXimpl(jM8969getZeronOccac), IntOffset.m8959getYimpl(jM8969getZeronOccac), 0.0f, 4, null);
            return;
        }
        Placeable.PlacementScope.place$default(placementScope, placeable, 0, 0, 0.0f, 4, null);
    }

    public final void approachPlaceMatchInTransition$animation(Placeable.PlacementScope placementScope, Placeable placeable, TargetData targetData, Rect rect) {
        FiniteAnimationSpec<Rect> finiteAnimationSpec;
        Rect rectM5763Recttz77jQw;
        long jM5733unboximpl;
        LookaheadAnimationVisualDebugHelper lookaheadAnimationVisualDebugHelper;
        LayoutCoordinates coordinates = placementScope.getCoordinates();
        if (coordinates == null) {
            Placeable.PlacementScope.place$default(placementScope, placeable, 0, 0, 0.0f, 4, null);
            return;
        }
        boolean activeMatchFound = getSharedElement().getState$animation().getActiveMatchFound();
        long jMo7454localPositionOfR5De75A = getRootCoords().mo7454localPositionOfR5De75A(coordinates, Offset.INSTANCE.m5739getZeroF1C5BW0());
        Rect targetBounds = SharedTransitionStateMachineKt.getTargetBounds(targetData);
        boolean isEnabled = IsLookaheadAnimationVisualDebuggingEnabledKt.isLookaheadAnimationVisualDebuggingEnabled() ? ((LookaheadAnimationVisualDebugConfig) CompositionLocalConsumerModifierNodeKt.currentValueOf(this, CompositionLocalsKt.getLocalLookaheadAnimationVisualDebugConfig())).getIsEnabled() : false;
        if (!activeMatchFound) {
            FiniteAnimationSpec<Rect> finiteAnimationSpecCreateAnimationSpec = isEnabled ? new BoundsTransform() { // from class: androidx.compose.animation.SharedBoundsNode$$ExternalSyntheticLambda0
                @Override // androidx.compose.animation.BoundsTransform
                public final FiniteAnimationSpec createAnimationSpec(Rect rect2, Rect rect3) {
                    return SharedBoundsNode.approachPlaceMatchInTransition$lambda$0(rect2, rect3);
                }
            }.createAnimationSpec(rect, targetBounds) : null;
            getBoundsAnimation().animate(rect, SharedTransitionStateMachineKt.getTargetBounds(targetData), new BoundsTransform() { // from class: androidx.compose.animation.SharedBoundsNode$$ExternalSyntheticLambda1
                @Override // androidx.compose.animation.BoundsTransform
                public final FiniteAnimationSpec createAnimationSpec(Rect rect2, Rect rect3) {
                    return SharedBoundsNode.approachPlaceMatchInTransition$lambda$1(rect2, rect3);
                }
            });
            finiteAnimationSpec = finiteAnimationSpecCreateAnimationSpec;
        } else {
            SpringSpec springSpecSpring$default = isEnabled ? AnimationSpecKt.spring$default(0.0f, 0.0f, null, 7, null) : null;
            BoundsAnimation.animate$default(getBoundsAnimation(), rect, SharedTransitionStateMachineKt.getTargetBounds(targetData), null, 4, null);
            finiteAnimationSpec = springSpecSpring$default;
        }
        if (isEnabled && (lookaheadAnimationVisualDebugHelper = this.lookaheadAnimationVisualDebugHelper) != null) {
            Intrinsics.checkNotNull(lookaheadAnimationVisualDebugHelper);
            Intrinsics.checkNotNull(finiteAnimationSpec);
            LookaheadAnimationVisualDebugHelper.calculatePath$animation$default(lookaheadAnimationVisualDebugHelper, finiteAnimationSpec, rect, targetBounds, null, 8, null);
        }
        Rect value = getBoundsAnimation().getValue();
        Offset offsetM5712boximpl = value != null ? Offset.m5712boximpl(SharedTransitionStateMachineKt.calculateOffsetFromDirectManipulation(targetData, value)) : null;
        if (getBoundsAnimation().getTarget() || !activeMatchFound) {
            long jM5733unboximpl2 = offsetM5712boximpl != null ? offsetM5712boximpl.m5733unboximpl() : jMo7454localPositionOfR5De75A;
            if (offsetM5712boximpl == null) {
                rectM5763Recttz77jQw = RectKt.m5763Recttz77jQw(jMo7454localPositionOfR5De75A, IntSizeKt.m9013toSizeozmzZPI(coordinates.mo7453getSizeYbymL2g()));
            } else {
                rectM5763Recttz77jQw = RectKt.m5763Recttz77jQw(offsetM5712boximpl.m5733unboximpl(), value.m5756getSizeNHjbRc());
            }
            getSharedElement().getState$animation().updateBounds(rectM5763Recttz77jQw);
            jM5733unboximpl = jM5733unboximpl2;
        } else {
            jM5733unboximpl = offsetM5712boximpl != null ? offsetM5712boximpl.m5733unboximpl() : rect.m5758getTopLeftF1C5BW0();
        }
        long jM5727minusMKHz9U = Offset.m5727minusMKHz9U(jM5733unboximpl, jMo7454localPositionOfR5De75A);
        Placeable.PlacementScope.place$default(placementScope, placeable, Math.round(Float.intBitsToFloat((int) (jM5727minusMKHz9U >> 32))), Math.round(Float.intBitsToFloat((int) (jM5727minusMKHz9U & 4294967295L))), 0.0f, 4, null);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final FiniteAnimationSpec approachPlaceMatchInTransition$lambda$0(Rect rect, Rect rect2) {
        return AnimationSpecKt.spring$default(0.0f, 0.0f, VisibilityThresholdsKt.getVisibilityThreshold(Rect.INSTANCE), 3, null);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final FiniteAnimationSpec approachPlaceMatchInTransition$lambda$1(Rect rect, Rect rect2) {
        return AnimationSpecKt.spring$default(0.0f, 0.0f, VisibilityThresholdsKt.getVisibilityThreshold(Rect.INSTANCE), 3, null);
    }

    private final MeasureResult approachPlace(MeasureScope measureScope, final Placeable placeable) {
        long jM8996constructorimpl;
        if (getSharedElement().getState$animation().getMatchIsOrHasBeenConfigured()) {
            jM8996constructorimpl = this.sharedElementEntry.getPlaceholderSize().mo151calculateSizeJyjRU_E(requireLookaheadLayoutCoordinates().mo7453getSizeYbymL2g(), IntSize.m8996constructorimpl((((long) placeable.getHeight()) & 4294967295L) | (((long) placeable.getWidth()) << 32)));
        } else {
            jM8996constructorimpl = IntSize.m8996constructorimpl((((long) placeable.getWidth()) << 32) | (((long) placeable.getHeight()) & 4294967295L));
        }
        return MeasureScope.layout$default(measureScope, (int) (jM8996constructorimpl >> 32), (int) (jM8996constructorimpl & 4294967295L), null, new Function1<Placeable.PlacementScope, Unit>() { // from class: androidx.compose.animation.SharedBoundsNode.approachPlace.1
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            {
                super(1);
            }

            @Override // kotlin.jvm.functions.Function1
            public /* bridge */ /* synthetic */ Unit invoke(Placeable.PlacementScope placementScope) {
                invoke2(placementScope);
                return Unit.INSTANCE;
            }

            /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
            public final void invoke2(Placeable.PlacementScope placementScope) {
                SharedBoundsNode.this.isPlaced = true;
                SharedBoundsNode.this.boundsBeforeDetached = null;
                SharedTransitionStateMachine.State state$animation = SharedBoundsNode.this.getSharedElement().getState$animation();
                if (!SharedBoundsNode.this.getSharedElementEntry().isEnabled()) {
                    Placeable.PlacementScope.place$default(placementScope, placeable, 0, 0, 0.0f, 4, null);
                    return;
                }
                if (state$animation.getMatchIsOrHasBeenConfigured()) {
                    TargetData targetData = state$animation.getTargetData();
                    if (targetData == null) {
                        throw new IllegalArgumentException(("Match State is configured, but target data is null. State = " + state$animation).toString());
                    }
                    Rect currentBounds = state$animation.getCurrentBounds();
                    if (currentBounds != null) {
                        if (!SharedBoundsNode.this.getSharedElement().getScope().isTransitionActive()) {
                            SharedBoundsNode.this.approachPlaceMatchBeyondTransition(placementScope, placeable, currentBounds);
                            return;
                        } else {
                            SharedBoundsNode.this.approachPlaceMatchInTransition$animation(placementScope, placeable, targetData, currentBounds);
                            return;
                        }
                    }
                    throw new IllegalArgumentException(("Match State is configured, but current bounds is null. State = " + state$animation).toString());
                }
                Placeable.PlacementScope.place$default(placementScope, placeable, 0, 0, 0.0f, 4, null);
            }
        }, 4, null);
    }

    @Override // androidx.compose.ui.layout.ApproachLayoutModifierNode
    /* JADX INFO: renamed from: isMeasurementApproachInProgress-ozmzZPI */
    public boolean mo78isMeasurementApproachInProgressozmzZPI(long lookaheadSize) {
        return this.sharedElementEntry.isEnabled() && getSharedElement().getFoundMatch() && getSharedElement().getScope().isTransitionActive();
    }

    @Override // androidx.compose.ui.layout.ApproachLayoutModifierNode
    /* JADX INFO: renamed from: approachMeasure-3p2s80s */
    public MeasureResult mo77approachMeasure3p2s80s(ApproachMeasureScope approachMeasureScope, Measurable measurable, long j) {
        Rect value = getBoundsAnimation().getValue();
        if (value == null) {
            value = getSharedElement().tryInitializingCurrentBounds();
        }
        if (value != null) {
            long jM9009roundToIntSizeuvyYCjk = IntSizeKt.m9009roundToIntSizeuvyYCjk(value.m5756getSizeNHjbRc());
            int i = (int) (jM9009roundToIntSizeuvyYCjk >> 32);
            int i2 = (int) (jM9009roundToIntSizeuvyYCjk & 4294967295L);
            if (i == Integer.MAX_VALUE || i2 == Integer.MAX_VALUE) {
                throw new IllegalArgumentException(("Error: Infinite width/height is invalid. animated bounds: " + getBoundsAnimation().getValue() + ", current bounds: " + getSharedElement().getState$animation().getCurrentBounds()).toString());
            }
            j = Constraints.INSTANCE.m8793fixedJhjzzOo(RangesKt.coerceAtLeast(i, 0), RangesKt.coerceAtLeast(i2, 0));
        }
        return approachPlace(approachMeasureScope, measurable.mo7445measureBRTryo0(j));
    }

    @Override // androidx.compose.ui.node.DrawModifierNode
    public void draw(final ContentDrawScope contentDrawScope) {
        final SharedElement sharedElement = getSharedElement();
        final Rect currentBounds = sharedElement.getState$animation().getCurrentBounds();
        SharedElementEntry sharedElementEntry = this.sharedElementEntry;
        sharedElementEntry.setClipPathInOverlay$animation((!sharedElementEntry.getShouldRenderInOverlay$animation() || currentBounds == null) ? null : this.sharedElementEntry.getOverlayClip().getClipPath(this.sharedElementEntry.getUserState(), currentBounds, contentDrawScope.getLayoutDirection(), DelegatableNodeKt.requireDensity(this)));
        GraphicsLayer layer = this.sharedElementEntry.getLayer();
        if (layer == null) {
            throw new IllegalArgumentException(("Error: Layer is null when accessed for shared bounds/element : " + sharedElement.getKey() + ",target: " + this.sharedElementEntry.getBoundsAnimation().getTarget() + ", is attached: " + getIsAttached()).toString());
        }
        LookaheadAnimationVisualDebugConfig lookaheadAnimationVisualDebugConfig = IsLookaheadAnimationVisualDebuggingEnabledKt.isLookaheadAnimationVisualDebuggingEnabled() ? (LookaheadAnimationVisualDebugConfig) CompositionLocalConsumerModifierNodeKt.currentValueOf(this, CompositionLocalsKt.getLocalLookaheadAnimationVisualDebugConfig()) : null;
        if (lookaheadAnimationVisualDebugConfig == null || !lookaheadAnimationVisualDebugConfig.getIsEnabled()) {
            DrawScope.m6547recordJVtK1S4$default(contentDrawScope, layer, 0L, new Function1<DrawScope, Unit>() { // from class: androidx.compose.animation.SharedBoundsNode.draw.2
                /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                {
                    super(1);
                }

                @Override // kotlin.jvm.functions.Function1
                public /* bridge */ /* synthetic */ Unit invoke(DrawScope drawScope) {
                    invoke2(drawScope);
                    return Unit.INSTANCE;
                }

                /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
                public final void invoke2(DrawScope drawScope) {
                    contentDrawScope.drawContent();
                }
            }, 1, null);
        } else {
            drawContentWithLookaheadAnimationDebug(contentDrawScope, layer, currentBounds, lookaheadAnimationVisualDebugConfig);
        }
        if (this.sharedElementEntry.getShouldRenderInPlace()) {
            GraphicsLayerKt.drawLayer(contentDrawScope, layer);
        }
    }

    private final void drawContentWithLookaheadAnimationDebug(final ContentDrawScope contentDrawScope, GraphicsLayer graphicsLayer, final Rect rect, final LookaheadAnimationVisualDebugConfig lookaheadAnimationVisualDebugConfig) {
        if (this.lookaheadAnimationVisualDebugHelper == null) {
            this.lookaheadAnimationVisualDebugHelper = new LookaheadAnimationVisualDebugHelper();
        }
        if (this.currentDensity == null) {
            SharedBoundsNode sharedBoundsNode = this;
            this.currentDensity = (Density) CompositionLocalConsumerModifierNodeKt.currentValueOf(sharedBoundsNode, androidx.compose.ui.platform.CompositionLocalsKt.getLocalDensity());
            this.currentLayoutDirection = (LayoutDirection) CompositionLocalConsumerModifierNodeKt.currentValueOf(sharedBoundsNode, androidx.compose.ui.platform.CompositionLocalsKt.getLocalLayoutDirection());
        }
        SharedBoundsNode sharedBoundsNode2 = this;
        final long jM5978unboximpl = ((Color) CompositionLocalConsumerModifierNodeKt.currentValueOf(sharedBoundsNode2, CompositionLocalsKt.getLocalLookaheadAnimationVisualDebugColor())).m5978unboximpl();
        final float f2 = contentDrawScope.mo488toPx0680j_4(Dp.m8830constructorimpl((float) 2.5d));
        final TargetData targetData = getSharedElement().getState$animation().getTargetData();
        updateTextMeasurer((FontFamily.Resolver) CompositionLocalConsumerModifierNodeKt.currentValueOf(sharedBoundsNode2, androidx.compose.ui.platform.CompositionLocalsKt.getLocalFontFamilyResolver()));
        DrawScope.m6547recordJVtK1S4$default(contentDrawScope, graphicsLayer, 0L, new Function1<DrawScope, Unit>() { // from class: androidx.compose.animation.SharedBoundsNode.drawContentWithLookaheadAnimationDebug.1
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            {
                super(1);
            }

            @Override // kotlin.jvm.functions.Function1
            public /* bridge */ /* synthetic */ Unit invoke(DrawScope drawScope) throws Throwable {
                invoke2(drawScope);
                return Unit.INSTANCE;
            }

            /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
            public final void invoke2(DrawScope drawScope) throws Throwable {
                ContentDrawScope contentDrawScope2 = contentDrawScope;
                contentDrawScope2.drawContent();
                if (this.getSharedElementEntry().isEnabled()) {
                    LookaheadAnimationVisualDebugHelper lookaheadAnimationVisualDebugHelper = this.lookaheadAnimationVisualDebugHelper;
                    Intrinsics.checkNotNull(lookaheadAnimationVisualDebugHelper);
                    SharedBoundsNode sharedBoundsNode3 = this;
                    LookaheadAnimationVisualDebugConfig lookaheadAnimationVisualDebugConfig2 = lookaheadAnimationVisualDebugConfig;
                    float f3 = f2;
                    TargetData targetData2 = targetData;
                    Rect rect2 = rect;
                    long j = jM5978unboximpl;
                    if (sharedBoundsNode3.getSharedElement().getScope().isTransitionActive()) {
                        if (sharedBoundsNode3.getSharedElement().getBoundsTransformIsActive()) {
                            if (sharedBoundsNode3.getSharedElement().getEnabledEntries().size() <= 2) {
                                if (targetData2 == null || rect2 == null) {
                                    return;
                                }
                                lookaheadAnimationVisualDebugHelper.m127drawLocalVisualizations0XenJco$animation(contentDrawScope2, j, SharedTransitionStateMachineKt.getTargetBounds(targetData2).m5758getTopLeftF1C5BW0(), targetData2.m174getSizeNHjbRc(), rect2, drawScope.mo6548getCenterF1C5BW0(), lookaheadAnimationVisualDebugConfig2.getIsShowKeyLabelEnabled(), f3, sharedBoundsNode3.getSharedElement().getKey(), sharedBoundsNode3.textMeasurer);
                                return;
                            }
                            long multipleMatchesColor = lookaheadAnimationVisualDebugConfig2.getMultipleMatchesColor();
                            boolean isShowKeyLabelEnabled = lookaheadAnimationVisualDebugConfig2.getIsShowKeyLabelEnabled();
                            Object key = sharedBoundsNode3.getSharedElement().getKey();
                            int size = sharedBoundsNode3.getSharedElement().getEnabledEntries().size() - 1;
                            TextMeasurer textMeasurer = sharedBoundsNode3.textMeasurer;
                            Intrinsics.checkNotNull(textMeasurer);
                            lookaheadAnimationVisualDebugHelper.m128drawMultipleMatchesElementsW7UJKQ$animation(contentDrawScope2, multipleMatchesColor, isShowKeyLabelEnabled, key, size, textMeasurer, 3 * f3);
                            return;
                        }
                        long unmatchedElementColor = lookaheadAnimationVisualDebugConfig2.getUnmatchedElementColor();
                        boolean isShowKeyLabelEnabled2 = lookaheadAnimationVisualDebugConfig2.getIsShowKeyLabelEnabled();
                        Object key2 = sharedBoundsNode3.getSharedElement().getKey();
                        TextMeasurer textMeasurer2 = sharedBoundsNode3.textMeasurer;
                        Intrinsics.checkNotNull(textMeasurer2);
                        lookaheadAnimationVisualDebugHelper.m130drawUnmatchedElement3IgeMak$animation(contentDrawScope2, unmatchedElementColor, isShowKeyLabelEnabled2, key2, textMeasurer2, f3);
                        return;
                    }
                    lookaheadAnimationVisualDebugHelper.m126drawInactiveVisualizations3IgeMak$animation(contentDrawScope2, j, lookaheadAnimationVisualDebugConfig2.getIsShowKeyLabelEnabled(), f3, sharedBoundsNode3.getSharedElement().getKey(), sharedBoundsNode3.textMeasurer);
                }
            }
        }, 1, null);
    }

    @Override // androidx.compose.ui.node.ObserverModifierNode
    public void onObservedReadsChanged() {
        getSharedElement().updateMatch$animation();
        ObserverModifierNodeKt.observeReads(this, getSharedElement().getObservingVisibilityChange$animation());
    }

    private final void updateTextMeasurer(FontFamily.Resolver fontFamilyResolver) {
        if (this.textMeasurer == null || !Intrinsics.areEqual(this.currentResolver, fontFamilyResolver)) {
            Density density = this.currentDensity;
            Intrinsics.checkNotNull(density);
            LayoutDirection layoutDirection = this.currentLayoutDirection;
            Intrinsics.checkNotNull(layoutDirection);
            this.textMeasurer = new TextMeasurer(fontFamilyResolver, density, layoutDirection, 0, 8, null);
            this.currentResolver = fontFamilyResolver;
        }
    }
}
