package androidx.compose.material3;

import androidx.compose.animation.core.Animatable;
import androidx.compose.animation.core.AnimationVector1D;
import androidx.compose.animation.core.FiniteAnimationSpec;
import androidx.compose.animation.core.VectorConvertersKt;
import androidx.compose.runtime.State;
import androidx.compose.ui.Modifier;
import androidx.compose.ui.layout.Measurable;
import androidx.compose.ui.layout.MeasureResult;
import androidx.compose.ui.layout.MeasureScope;
import androidx.compose.ui.layout.Placeable;
import androidx.compose.ui.node.LayoutModifierNode;
import androidx.compose.ui.unit.Constraints;
import androidx.compose.ui.unit.Dp;
import androidx.compose.ui.unit.LayoutDirection;
import java.util.List;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.coroutines.BuildersKt__Builders_commonKt;

/* JADX INFO: compiled from: TabRow.kt */
/* JADX INFO: loaded from: classes.dex */
@Metadata(d1 = {"\u0000X\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0013\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\b\u0001\u0018\u00002\u00020\u00012\u00020\u0002B9\u0012\u0012\u0010\u0003\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00060\u00050\u0004\u0012\u0006\u0010\u0007\u001a\u00020\b\u0012\u0006\u0010\t\u001a\u00020\n\u0012\f\u0010\u000b\u001a\b\u0012\u0004\u0012\u00020\r0\f¢\u0006\u0004\b\u000e\u0010\u000fJ#\u0010&\u001a\u00020'*\u00020(2\u0006\u0010)\u001a\u00020*2\u0006\u0010+\u001a\u00020,H\u0016¢\u0006\u0004\b-\u0010.R&\u0010\u0003\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00060\u00050\u0004X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0010\u0010\u0011\"\u0004\b\u0012\u0010\u0013R\u001a\u0010\u0007\u001a\u00020\bX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0014\u0010\u0015\"\u0004\b\u0016\u0010\u0017R\u001a\u0010\t\u001a\u00020\nX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0018\u0010\u0019\"\u0004\b\u001a\u0010\u001bR \u0010\u000b\u001a\b\u0012\u0004\u0012\u00020\r0\fX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u001c\u0010\u001d\"\u0004\b\u001e\u0010\u001fR\u001c\u0010 \u001a\u0010\u0012\u0004\u0012\u00020\r\u0012\u0004\u0012\u00020\"\u0018\u00010!X\u0082\u000e¢\u0006\u0002\n\u0000R\u001c\u0010#\u001a\u0010\u0012\u0004\u0012\u00020\r\u0012\u0004\u0012\u00020\"\u0018\u00010!X\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010$\u001a\u0004\u0018\u00010\rX\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010%\u001a\u0004\u0018\u00010\rX\u0082\u000e¢\u0006\u0002\n\u0000¨\u0006/"}, d2 = {"Landroidx/compose/material3/TabIndicatorOffsetNode;", "Landroidx/compose/ui/Modifier$Node;", "Landroidx/compose/ui/node/LayoutModifierNode;", "tabPositionsState", "Landroidx/compose/runtime/State;", "", "Landroidx/compose/material3/TabPosition;", "selectedTabIndex", "", "followContentSize", "", "animationSpec", "Landroidx/compose/animation/core/FiniteAnimationSpec;", "Landroidx/compose/ui/unit/Dp;", "<init>", "(Landroidx/compose/runtime/State;IZLandroidx/compose/animation/core/FiniteAnimationSpec;)V", "getTabPositionsState", "()Landroidx/compose/runtime/State;", "setTabPositionsState", "(Landroidx/compose/runtime/State;)V", "getSelectedTabIndex", "()I", "setSelectedTabIndex", "(I)V", "getFollowContentSize", "()Z", "setFollowContentSize", "(Z)V", "getAnimationSpec", "()Landroidx/compose/animation/core/FiniteAnimationSpec;", "setAnimationSpec", "(Landroidx/compose/animation/core/FiniteAnimationSpec;)V", "offsetAnimatable", "Landroidx/compose/animation/core/Animatable;", "Landroidx/compose/animation/core/AnimationVector1D;", "widthAnimatable", "initialOffset", "initialWidth", "measure", "Landroidx/compose/ui/layout/MeasureResult;", "Landroidx/compose/ui/layout/MeasureScope;", "measurable", "Landroidx/compose/ui/layout/Measurable;", "constraints", "Landroidx/compose/ui/unit/Constraints;", "measure-3p2s80s", "(Landroidx/compose/ui/layout/MeasureScope;Landroidx/compose/ui/layout/Measurable;J)Landroidx/compose/ui/layout/MeasureResult;", "material3"}, k = 1, mv = {2, 0, 0}, xi = 48)
public final class TabIndicatorOffsetNode extends Modifier.Node implements LayoutModifierNode {
    public static final int $stable = 8;
    private FiniteAnimationSpec<Dp> animationSpec;
    private boolean followContentSize;
    private Dp initialOffset;
    private Dp initialWidth;
    private Animatable<Dp, AnimationVector1D> offsetAnimatable;
    private int selectedTabIndex;
    private State<? extends List<TabPosition>> tabPositionsState;
    private Animatable<Dp, AnimationVector1D> widthAnimatable;

    public final State<List<TabPosition>> getTabPositionsState() {
        return this.tabPositionsState;
    }

    public final void setTabPositionsState(State<? extends List<TabPosition>> state) {
        this.tabPositionsState = state;
    }

    public final int getSelectedTabIndex() {
        return this.selectedTabIndex;
    }

    public final void setSelectedTabIndex(int i) {
        this.selectedTabIndex = i;
    }

    public final boolean getFollowContentSize() {
        return this.followContentSize;
    }

    public final void setFollowContentSize(boolean z) {
        this.followContentSize = z;
    }

    public final FiniteAnimationSpec<Dp> getAnimationSpec() {
        return this.animationSpec;
    }

    public final void setAnimationSpec(FiniteAnimationSpec<Dp> finiteAnimationSpec) {
        this.animationSpec = finiteAnimationSpec;
    }

    public TabIndicatorOffsetNode(State<? extends List<TabPosition>> state, int i, boolean z, FiniteAnimationSpec<Dp> finiteAnimationSpec) {
        this.tabPositionsState = state;
        this.selectedTabIndex = i;
        this.followContentSize = z;
        this.animationSpec = finiteAnimationSpec;
    }

    @Override // androidx.compose.ui.node.LayoutModifierNode
    /* JADX INFO: renamed from: measure-3p2s80s */
    public MeasureResult mo72measure3p2s80s(final MeasureScope measureScope, Measurable measurable, long j) {
        float width;
        if (this.tabPositionsState.getValue().isEmpty()) {
            return MeasureScope.layout$default(measureScope, 0, 0, null, new Function1() { // from class: androidx.compose.material3.TabIndicatorOffsetNode$$ExternalSyntheticLambda0
                @Override // kotlin.jvm.functions.Function1
                public final Object invoke(Object obj) {
                    return TabIndicatorOffsetNode.measure_3p2s80s$lambda$0((Placeable.PlacementScope) obj);
                }
            }, 4, null);
        }
        if (this.followContentSize) {
            width = this.tabPositionsState.getValue().get(this.selectedTabIndex).getContentWidth();
        } else {
            width = this.tabPositionsState.getValue().get(this.selectedTabIndex).getWidth();
        }
        if (this.initialWidth != null) {
            Animatable<Dp, AnimationVector1D> animatable = this.widthAnimatable;
            if (animatable == null) {
                Dp dp = this.initialWidth;
                Intrinsics.checkNotNull(dp);
                Animatable<Dp, AnimationVector1D> animatable2 = new Animatable<>(dp, VectorConvertersKt.getVectorConverter(Dp.INSTANCE), null, null, 12, null);
                this.widthAnimatable = animatable2;
                animatable = animatable2;
            }
            if (!Dp.m8835equalsimpl0(width, animatable.getTargetValue().m8844unboximpl())) {
                BuildersKt__Builders_commonKt.launch$default(getCoroutineScope(), null, null, new TabIndicatorOffsetNode$measure$2(animatable, width, this, null), 3, null);
            }
        } else {
            this.initialWidth = Dp.m8828boximpl(width);
        }
        float left = this.tabPositionsState.getValue().get(this.selectedTabIndex).getLeft();
        if (this.initialOffset != null) {
            Animatable<Dp, AnimationVector1D> animatable3 = this.offsetAnimatable;
            if (animatable3 == null) {
                Dp dp2 = this.initialOffset;
                Intrinsics.checkNotNull(dp2);
                Animatable<Dp, AnimationVector1D> animatable4 = new Animatable<>(dp2, VectorConvertersKt.getVectorConverter(Dp.INSTANCE), null, null, 12, null);
                this.offsetAnimatable = animatable4;
                animatable3 = animatable4;
            }
            if (!Dp.m8835equalsimpl0(left, animatable3.getTargetValue().m8844unboximpl())) {
                BuildersKt__Builders_commonKt.launch$default(getCoroutineScope(), null, null, new TabIndicatorOffsetNode$measure$3(animatable3, left, this, null), 3, null);
            }
        } else {
            this.initialOffset = Dp.m8828boximpl(left);
        }
        if (measureScope.getLayoutDirection() == LayoutDirection.Ltr) {
            Animatable<Dp, AnimationVector1D> animatable5 = this.offsetAnimatable;
            if (animatable5 != null) {
                left = animatable5.getValue().m8844unboximpl();
            }
        } else {
            Animatable<Dp, AnimationVector1D> animatable6 = this.offsetAnimatable;
            if (animatable6 != null) {
                left = animatable6.getValue().m8844unboximpl();
            }
            left = Dp.m8830constructorimpl(-left);
        }
        Animatable<Dp, AnimationVector1D> animatable7 = this.widthAnimatable;
        if (animatable7 != null) {
            width = animatable7.getValue().m8844unboximpl();
        }
        final Placeable placeableMo7445measureBRTryo0 = measurable.mo7445measureBRTryo0(Constraints.m8773copyZbe2FdA$default(j, measureScope.mo482roundToPx0680j_4(width), measureScope.mo482roundToPx0680j_4(width), 0, 0, 12, null));
        final float f2 = left;
        return MeasureScope.layout$default(measureScope, placeableMo7445measureBRTryo0.getWidth(), placeableMo7445measureBRTryo0.getHeight(), null, new Function1() { // from class: androidx.compose.material3.TabIndicatorOffsetNode$$ExternalSyntheticLambda1
            @Override // kotlin.jvm.functions.Function1
            public final Object invoke(Object obj) {
                return TabIndicatorOffsetNode.measure_3p2s80s$lambda$3(placeableMo7445measureBRTryo0, measureScope, f2, (Placeable.PlacementScope) obj);
            }
        }, 4, null);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit measure_3p2s80s$lambda$0(Placeable.PlacementScope placementScope) {
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit measure_3p2s80s$lambda$3(Placeable placeable, MeasureScope measureScope, float f2, Placeable.PlacementScope placementScope) {
        Placeable.PlacementScope.place$default(placementScope, placeable, measureScope.mo482roundToPx0680j_4(f2), 0, 0.0f, 4, null);
        return Unit.INSTANCE;
    }
}
