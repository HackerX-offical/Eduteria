package androidx.compose.animation;

import androidx.compose.ui.Modifier;
import androidx.compose.ui.geometry.InlineClassHelperKt;
import androidx.compose.ui.geometry.Offset;
import androidx.compose.ui.geometry.Rect;
import androidx.compose.ui.graphics.Color;
import androidx.compose.ui.graphics.drawscope.ContentDrawScope;
import androidx.compose.ui.layout.ApproachLayoutModifierNode;
import androidx.compose.ui.layout.ApproachMeasureScope;
import androidx.compose.ui.layout.LayoutCoordinates;
import androidx.compose.ui.layout.LookaheadScope;
import androidx.compose.ui.layout.Measurable;
import androidx.compose.ui.layout.MeasureResult;
import androidx.compose.ui.layout.MeasureScope;
import androidx.compose.ui.layout.Placeable;
import androidx.compose.ui.node.CompositionLocalConsumerModifierNode;
import androidx.compose.ui.node.CompositionLocalConsumerModifierNodeKt;
import androidx.compose.ui.node.DrawModifierNode;
import androidx.compose.ui.text.TextMeasurer;
import androidx.compose.ui.text.font.FontFamily;
import androidx.compose.ui.unit.Constraints;
import androidx.compose.ui.unit.ConstraintsKt;
import androidx.compose.ui.unit.Density;
import androidx.compose.ui.unit.Dp;
import androidx.compose.ui.unit.IntSize;
import androidx.compose.ui.unit.IntSizeKt;
import androidx.compose.ui.unit.LayoutDirection;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: compiled from: AnimateBoundsModifier.kt */
/* JADX INFO: loaded from: classes.dex */
@Metadata(d1 = {"\u0000\u0092\u0001\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u0014\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\t\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\b\u0001\u0018\u00002\u00020\u00012\u00020\u00022\u00020\u00032\u00020\u0004BW\u0012\u0006\u0010\u0005\u001a\u00020\u0006\u0012\u0006\u0010\u0007\u001a\u00020\b\u00126\u0010\t\u001a2\u0012\u0013\u0012\u00110\u000b¢\u0006\f\b\f\u0012\b\b\r\u0012\u0004\b\b(\u000e\u0012\u0013\u0012\u00110\u000f¢\u0006\f\b\f\u0012\b\b\r\u0012\u0004\b\b(\u0010\u0012\u0004\u0012\u00020\u000f0\n\u0012\u0006\u0010\u0011\u001a\u00020\u0012¢\u0006\u0004\b\u0013\u0010\u0014J\u0017\u0010<\u001a\u00020\u00122\u0006\u0010=\u001a\u00020\u000bH\u0016¢\u0006\u0004\b>\u0010?J\b\u0010@\u001a\u00020AH\u0016J\u0014\u0010B\u001a\u00020\u0012*\u00020C2\u0006\u0010D\u001a\u00020EH\u0016J#\u0010F\u001a\u00020G*\u00020H2\u0006\u0010I\u001a\u00020J2\u0006\u0010\u0010\u001a\u00020\u000fH\u0016¢\u0006\u0004\bK\u0010LJ\f\u0010M\u001a\u00020A*\u00020NH\u0016J\u0010\u0010O\u001a\u00020A2\u0006\u0010P\u001a\u00020+H\u0002R\u001a\u0010\u0005\u001a\u00020\u0006X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0015\u0010\u0016\"\u0004\b\u0017\u0010\u0018R\u001a\u0010\u0007\u001a\u00020\bX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0019\u0010\u001a\"\u0004\b\u001b\u0010\u001cRJ\u0010\t\u001a2\u0012\u0013\u0012\u00110\u000b¢\u0006\f\b\f\u0012\b\b\r\u0012\u0004\b\b(\u000e\u0012\u0013\u0012\u00110\u000f¢\u0006\f\b\f\u0012\b\b\r\u0012\u0004\b\b(\u0010\u0012\u0004\u0012\u00020\u000f0\nX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u001d\u0010\u001e\"\u0004\b\u001f\u0010 R\u001a\u0010\u0011\u001a\u00020\u0012X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b!\u0010\"\"\u0004\b#\u0010$R\u000e\u0010%\u001a\u00020\u0012X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010&\u001a\u00020'X\u0082\u0004¢\u0006\u0002\n\u0000R\u0010\u0010(\u001a\u0004\u0018\u00010)X\u0082\u000e¢\u0006\u0002\n\u0000R\u001c\u0010*\u001a\u0004\u0018\u00010+X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b,\u0010-\"\u0004\b.\u0010/R\u001c\u00100\u001a\u0004\u0018\u000101X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b2\u00103\"\u0004\b4\u00105R\u001c\u00106\u001a\u0004\u0018\u000107X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b8\u00109\"\u0004\b:\u0010;¨\u0006Q"}, d2 = {"Landroidx/compose/animation/BoundsAnimationModifierNode;", "Landroidx/compose/ui/layout/ApproachLayoutModifierNode;", "Landroidx/compose/ui/Modifier$Node;", "Landroidx/compose/ui/node/CompositionLocalConsumerModifierNode;", "Landroidx/compose/ui/node/DrawModifierNode;", "lookaheadScope", "Landroidx/compose/ui/layout/LookaheadScope;", "boundsTransform", "Landroidx/compose/animation/BoundsTransform;", "onChooseMeasureConstraints", "Lkotlin/Function2;", "Landroidx/compose/ui/unit/IntSize;", "Lkotlin/ParameterName;", "name", "animatedSize", "Landroidx/compose/ui/unit/Constraints;", "constraints", "animateMotionFrameOfReference", "", "<init>", "(Landroidx/compose/ui/layout/LookaheadScope;Landroidx/compose/animation/BoundsTransform;Lkotlin/jvm/functions/Function2;Z)V", "getLookaheadScope", "()Landroidx/compose/ui/layout/LookaheadScope;", "setLookaheadScope", "(Landroidx/compose/ui/layout/LookaheadScope;)V", "getBoundsTransform", "()Landroidx/compose/animation/BoundsTransform;", "setBoundsTransform", "(Landroidx/compose/animation/BoundsTransform;)V", "getOnChooseMeasureConstraints", "()Lkotlin/jvm/functions/Function2;", "setOnChooseMeasureConstraints", "(Lkotlin/jvm/functions/Function2;)V", "getAnimateMotionFrameOfReference", "()Z", "setAnimateMotionFrameOfReference", "(Z)V", "directManipulationParentsDirty", "boundsAnimation", "Landroidx/compose/animation/BoundsTransformDeferredAnimation;", "textMeasurer", "Landroidx/compose/ui/text/TextMeasurer;", "currentResolver", "Landroidx/compose/ui/text/font/FontFamily$Resolver;", "getCurrentResolver", "()Landroidx/compose/ui/text/font/FontFamily$Resolver;", "setCurrentResolver", "(Landroidx/compose/ui/text/font/FontFamily$Resolver;)V", "currentDensity", "Landroidx/compose/ui/unit/Density;", "getCurrentDensity", "()Landroidx/compose/ui/unit/Density;", "setCurrentDensity", "(Landroidx/compose/ui/unit/Density;)V", "currentLayoutDirection", "Landroidx/compose/ui/unit/LayoutDirection;", "getCurrentLayoutDirection", "()Landroidx/compose/ui/unit/LayoutDirection;", "setCurrentLayoutDirection", "(Landroidx/compose/ui/unit/LayoutDirection;)V", "isMeasurementApproachInProgress", "lookaheadSize", "isMeasurementApproachInProgress-ozmzZPI", "(J)Z", "onAttach", "", "isPlacementApproachInProgress", "Landroidx/compose/ui/layout/Placeable$PlacementScope;", "lookaheadCoordinates", "Landroidx/compose/ui/layout/LayoutCoordinates;", "approachMeasure", "Landroidx/compose/ui/layout/MeasureResult;", "Landroidx/compose/ui/layout/ApproachMeasureScope;", "measurable", "Landroidx/compose/ui/layout/Measurable;", "approachMeasure-3p2s80s", "(Landroidx/compose/ui/layout/ApproachMeasureScope;Landroidx/compose/ui/layout/Measurable;J)Landroidx/compose/ui/layout/MeasureResult;", "draw", "Landroidx/compose/ui/graphics/drawscope/ContentDrawScope;", "updateTextMeasurer", "fontFamilyResolver", "animation"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final class BoundsAnimationModifierNode extends Modifier.Node implements ApproachLayoutModifierNode, CompositionLocalConsumerModifierNode, DrawModifierNode {
    public static final int $stable = 8;
    private boolean animateMotionFrameOfReference;
    private BoundsTransform boundsTransform;
    private Density currentDensity;
    private LayoutDirection currentLayoutDirection;
    private FontFamily.Resolver currentResolver;
    private LookaheadScope lookaheadScope;
    private Function2<? super IntSize, ? super Constraints, Constraints> onChooseMeasureConstraints;
    private TextMeasurer textMeasurer;
    private boolean directManipulationParentsDirty = true;
    private final BoundsTransformDeferredAnimation boundsAnimation = new BoundsTransformDeferredAnimation();

    public BoundsAnimationModifierNode(LookaheadScope lookaheadScope, BoundsTransform boundsTransform, Function2<? super IntSize, ? super Constraints, Constraints> function2, boolean z) {
        this.lookaheadScope = lookaheadScope;
        this.boundsTransform = boundsTransform;
        this.onChooseMeasureConstraints = function2;
        this.animateMotionFrameOfReference = z;
    }

    public final LookaheadScope getLookaheadScope() {
        return this.lookaheadScope;
    }

    public final void setLookaheadScope(LookaheadScope lookaheadScope) {
        this.lookaheadScope = lookaheadScope;
    }

    public final BoundsTransform getBoundsTransform() {
        return this.boundsTransform;
    }

    public final void setBoundsTransform(BoundsTransform boundsTransform) {
        this.boundsTransform = boundsTransform;
    }

    public final Function2<IntSize, Constraints, Constraints> getOnChooseMeasureConstraints() {
        return this.onChooseMeasureConstraints;
    }

    public final void setOnChooseMeasureConstraints(Function2<? super IntSize, ? super Constraints, Constraints> function2) {
        this.onChooseMeasureConstraints = function2;
    }

    public final boolean getAnimateMotionFrameOfReference() {
        return this.animateMotionFrameOfReference;
    }

    public final void setAnimateMotionFrameOfReference(boolean z) {
        this.animateMotionFrameOfReference = z;
    }

    public final FontFamily.Resolver getCurrentResolver() {
        return this.currentResolver;
    }

    public final void setCurrentResolver(FontFamily.Resolver resolver) {
        this.currentResolver = resolver;
    }

    public final Density getCurrentDensity() {
        return this.currentDensity;
    }

    public final void setCurrentDensity(Density density) {
        this.currentDensity = density;
    }

    public final LayoutDirection getCurrentLayoutDirection() {
        return this.currentLayoutDirection;
    }

    public final void setCurrentLayoutDirection(LayoutDirection layoutDirection) {
        this.currentLayoutDirection = layoutDirection;
    }

    @Override // androidx.compose.ui.layout.ApproachLayoutModifierNode
    /* JADX INFO: renamed from: isMeasurementApproachInProgress-ozmzZPI, reason: not valid java name */
    public boolean mo78isMeasurementApproachInProgressozmzZPI(long lookaheadSize) {
        this.boundsAnimation.m85updateTargetSizeuvyYCjk(IntSizeKt.m9013toSizeozmzZPI(lookaheadSize));
        return !this.boundsAnimation.isIdle();
    }

    @Override // androidx.compose.ui.Modifier.Node
    public void onAttach() {
        this.directManipulationParentsDirty = true;
    }

    @Override // androidx.compose.ui.layout.ApproachLayoutModifierNode
    public boolean isPlacementApproachInProgress(Placeable.PlacementScope placementScope, LayoutCoordinates layoutCoordinates) {
        if (IsLookaheadAnimationVisualDebuggingEnabledKt.isLookaheadAnimationVisualDebuggingEnabled() && this.boundsAnimation.getLookaheadAnimationVisualDebugHelper() == null) {
            this.boundsAnimation.setLookaheadAnimationVisualDebugHelper(new LookaheadAnimationVisualDebugHelper());
        }
        this.boundsAnimation.updateTargetOffsetAndAnimate(this.lookaheadScope, placementScope, getCoroutineScope(), this.directManipulationParentsDirty, this.animateMotionFrameOfReference, this.boundsTransform);
        this.directManipulationParentsDirty = this.animateMotionFrameOfReference;
        return !this.boundsAnimation.isIdle();
    }

    @Override // androidx.compose.ui.layout.ApproachLayoutModifierNode
    /* JADX INFO: renamed from: approachMeasure-3p2s80s, reason: not valid java name */
    public MeasureResult mo77approachMeasure3p2s80s(ApproachMeasureScope approachMeasureScope, Measurable measurable, long j) {
        long currentSize;
        if (this.boundsAnimation.getCurrentSize() == InlineClassHelperKt.UnspecifiedPackedFloats) {
            currentSize = IntSizeKt.m9013toSizeozmzZPI(approachMeasureScope.mo7423getLookaheadSizeYbymL2g());
        } else {
            currentSize = this.boundsAnimation.getCurrentSize();
        }
        Rect value = this.boundsAnimation.getValue();
        if (value != null) {
            currentSize = value.m5756getSizeNHjbRc();
        }
        long jM9009roundToIntSizeuvyYCjk = IntSizeKt.m9009roundToIntSizeuvyYCjk(currentSize);
        long value2 = this.onChooseMeasureConstraints.invoke(IntSize.m8993boximpl(jM9009roundToIntSizeuvyYCjk), Constraints.m8770boximpl(j)).getValue();
        final Placeable placeableMo7445measureBRTryo0 = measurable.mo7445measureBRTryo0(value2);
        long jM8797constrain4WqzIAM = ConstraintsKt.m8797constrain4WqzIAM(value2, jM9009roundToIntSizeuvyYCjk);
        return MeasureScope.layout$default(approachMeasureScope, (int) (jM8797constrain4WqzIAM >> 32), (int) (jM8797constrain4WqzIAM & 4294967295L), null, new Function1<Placeable.PlacementScope, Unit>() { // from class: androidx.compose.animation.BoundsAnimationModifierNode$approachMeasure$1
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
                long jM5758getTopLeftF1C5BW0;
                Rect value3 = this.this$0.boundsAnimation.getValue();
                LookaheadScope lookaheadScope = this.this$0.getLookaheadScope();
                BoundsAnimationModifierNode boundsAnimationModifierNode = this.this$0;
                LayoutCoordinates coordinates = placementScope.getCoordinates();
                Offset offsetM5712boximpl = coordinates != null ? Offset.m5712boximpl(lookaheadScope.getLookaheadScopeCoordinates(placementScope).mo7455localPositionOfS_NoaFU(coordinates, Offset.INSTANCE.m5739getZeroF1C5BW0(), boundsAnimationModifierNode.getAnimateMotionFrameOfReference())) : null;
                if (value3 != null) {
                    this.this$0.boundsAnimation.m84updateCurrentBoundstz77jQw(value3.m5758getTopLeftF1C5BW0(), value3.m5756getSizeNHjbRc());
                    jM5758getTopLeftF1C5BW0 = value3.m5758getTopLeftF1C5BW0();
                } else {
                    Rect currentBounds = this.this$0.boundsAnimation.getCurrentBounds();
                    jM5758getTopLeftF1C5BW0 = currentBounds != null ? currentBounds.m5758getTopLeftF1C5BW0() : Offset.INSTANCE.m5739getZeroF1C5BW0();
                }
                long jM5727minusMKHz9U = offsetM5712boximpl != null ? Offset.m5727minusMKHz9U(jM5758getTopLeftF1C5BW0, offsetM5712boximpl.m5733unboximpl()) : Offset.INSTANCE.m5739getZeroF1C5BW0();
                Placeable.PlacementScope.place$default(placementScope, placeableMo7445measureBRTryo0, Math.round(Float.intBitsToFloat((int) (jM5727minusMKHz9U >> 32))), Math.round(Float.intBitsToFloat((int) (jM5727minusMKHz9U & 4294967295L))), 0.0f, 4, null);
            }
        }, 4, null);
    }

    @Override // androidx.compose.ui.node.DrawModifierNode
    public void draw(ContentDrawScope contentDrawScope) throws Throwable {
        contentDrawScope.drawContent();
        if (IsLookaheadAnimationVisualDebuggingEnabledKt.isLookaheadAnimationVisualDebuggingEnabled() && Constraints.m8781getHasFixedWidthimpl(this.onChooseMeasureConstraints.invoke(IntSize.m8993boximpl(IntSize.INSTANCE.m9006getZeroYbymL2g()), Constraints.m8770boximpl(ConstraintsKt.Constraints$default(0, 0, 0, 0, 15, null))).getValue())) {
            BoundsAnimationModifierNode boundsAnimationModifierNode = this;
            LookaheadAnimationVisualDebugConfig lookaheadAnimationVisualDebugConfig = (LookaheadAnimationVisualDebugConfig) CompositionLocalConsumerModifierNodeKt.currentValueOf(boundsAnimationModifierNode, CompositionLocalsKt.getLocalLookaheadAnimationVisualDebugConfig());
            if (lookaheadAnimationVisualDebugConfig.getIsEnabled()) {
                if (this.currentDensity == null) {
                    this.currentDensity = (Density) CompositionLocalConsumerModifierNodeKt.currentValueOf(boundsAnimationModifierNode, androidx.compose.ui.platform.CompositionLocalsKt.getLocalDensity());
                    this.currentLayoutDirection = (LayoutDirection) CompositionLocalConsumerModifierNodeKt.currentValueOf(boundsAnimationModifierNode, androidx.compose.ui.platform.CompositionLocalsKt.getLocalLayoutDirection());
                }
                LookaheadAnimationVisualDebugHelper lookaheadAnimationVisualDebugHelper = this.boundsAnimation.getLookaheadAnimationVisualDebugHelper();
                Intrinsics.checkNotNull(lookaheadAnimationVisualDebugHelper);
                long jM5978unboximpl = ((Color) CompositionLocalConsumerModifierNodeKt.currentValueOf(boundsAnimationModifierNode, CompositionLocalsKt.getLocalLookaheadAnimationVisualDebugColor())).m5978unboximpl();
                updateTextMeasurer((FontFamily.Resolver) CompositionLocalConsumerModifierNodeKt.currentValueOf(boundsAnimationModifierNode, androidx.compose.ui.platform.CompositionLocalsKt.getLocalFontFamilyResolver()));
                if (this.boundsAnimation.isIdle()) {
                    boolean isShowKeyLabelEnabled = lookaheadAnimationVisualDebugConfig.getIsShowKeyLabelEnabled();
                    float f2 = contentDrawScope.mo488toPx0680j_4(Dp.m8830constructorimpl((float) 2.5d));
                    String strSubstring = this.boundsAnimation.toString().substring(60);
                    Intrinsics.checkNotNullExpressionValue(strSubstring, "substring(...)");
                    lookaheadAnimationVisualDebugHelper.m126drawInactiveVisualizations3IgeMak$animation(contentDrawScope, jM5978unboximpl, isShowKeyLabelEnabled, f2, strSubstring, this.textMeasurer);
                    return;
                }
                long targetOffset = this.boundsAnimation.getTargetOffset();
                long targetSize = this.boundsAnimation.getTargetSize();
                Rect value = this.boundsAnimation.getValue();
                Intrinsics.checkNotNull(value);
                long j = contentDrawScope.mo6548getCenterF1C5BW0();
                boolean isShowKeyLabelEnabled2 = lookaheadAnimationVisualDebugConfig.getIsShowKeyLabelEnabled();
                float f3 = contentDrawScope.mo488toPx0680j_4(Dp.m8830constructorimpl((float) 2.5d));
                String strSubstring2 = this.boundsAnimation.toString().substring(60);
                Intrinsics.checkNotNullExpressionValue(strSubstring2, "substring(...)");
                lookaheadAnimationVisualDebugHelper.m127drawLocalVisualizations0XenJco$animation(contentDrawScope, jM5978unboximpl, targetOffset, targetSize, value, j, isShowKeyLabelEnabled2, f3, strSubstring2, this.textMeasurer);
            }
        }
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
