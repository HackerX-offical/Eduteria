package androidx.compose.animation;

import androidx.compose.animation.core.AnimationSpecKt;
import androidx.compose.animation.core.FiniteAnimationSpec;
import androidx.compose.animation.core.VisibilityThresholdsKt;
import androidx.compose.ui.Modifier;
import androidx.compose.ui.geometry.Rect;
import androidx.compose.ui.layout.LookaheadScope;
import androidx.compose.ui.unit.Constraints;
import androidx.compose.ui.unit.IntSize;
import kotlin.Metadata;
import kotlin.jvm.functions.Function2;

/* JADX INFO: compiled from: AnimateBoundsModifier.kt */
/* JADX INFO: loaded from: classes.dex */
@Metadata(d1 = {"\u0000\u001e\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0002\u001a0\u0010\u0000\u001a\u00020\u0001*\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u00012\b\b\u0002\u0010\u0005\u001a\u00020\u00062\b\b\u0002\u0010\u0007\u001a\u00020\b\"\u000e\u0010\t\u001a\u00020\u0006X\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006\n"}, d2 = {"animateBounds", "Landroidx/compose/ui/Modifier;", "lookaheadScope", "Landroidx/compose/ui/layout/LookaheadScope;", "modifier", "boundsTransform", "Landroidx/compose/animation/BoundsTransform;", "animateMotionFrameOfReference", "", "DefaultBoundsTransform", "animation"}, k = 2, mv = {2, 1, 0}, xi = 48)
public final class AnimateBoundsModifierKt {
    private static final BoundsTransform DefaultBoundsTransform = new BoundsTransform() { // from class: androidx.compose.animation.AnimateBoundsModifierKt$$ExternalSyntheticLambda0
        @Override // androidx.compose.animation.BoundsTransform
        public final FiniteAnimationSpec createAnimationSpec(Rect rect, Rect rect2) {
            return AnimateBoundsModifierKt.DefaultBoundsTransform$lambda$0(rect, rect2);
        }
    };

    public static /* synthetic */ Modifier animateBounds$default(Modifier modifier, LookaheadScope lookaheadScope, Modifier modifier2, BoundsTransform boundsTransform, boolean z, int i, Object obj) {
        if ((i & 2) != 0) {
            modifier2 = Modifier.INSTANCE;
        }
        if ((i & 4) != 0) {
            boundsTransform = DefaultBoundsTransform;
        }
        if ((i & 8) != 0) {
            z = false;
        }
        return animateBounds(modifier, lookaheadScope, modifier2, boundsTransform, z);
    }

    public static final Modifier animateBounds(Modifier modifier, LookaheadScope lookaheadScope, Modifier modifier2, BoundsTransform boundsTransform, boolean z) {
        return modifier.then(new BoundsAnimationElement(lookaheadScope, boundsTransform, new Function2<IntSize, Constraints, Constraints>() { // from class: androidx.compose.animation.AnimateBoundsModifierKt.animateBounds.1
            /* JADX INFO: renamed from: invoke-2pbfIzA, reason: not valid java name */
            public final long m40invoke2pbfIzA(long j, long j2) {
                return j2;
            }

            @Override // kotlin.jvm.functions.Function2
            public /* bridge */ /* synthetic */ Constraints invoke(IntSize intSize, Constraints constraints) {
                return Constraints.m8770boximpl(m40invoke2pbfIzA(intSize.m9005unboximpl(), constraints.getValue()));
            }
        }, z)).then(modifier2).then(new BoundsAnimationElement(lookaheadScope, boundsTransform, new Function2<IntSize, Constraints, Constraints>() { // from class: androidx.compose.animation.AnimateBoundsModifierKt.animateBounds.2
            @Override // kotlin.jvm.functions.Function2
            public /* bridge */ /* synthetic */ Constraints invoke(IntSize intSize, Constraints constraints) {
                return Constraints.m8770boximpl(m41invoke2pbfIzA(intSize.m9005unboximpl(), constraints.getValue()));
            }

            /* JADX INFO: renamed from: invoke-2pbfIzA, reason: not valid java name */
            public final long m41invoke2pbfIzA(long j, long j2) {
                return Constraints.INSTANCE.m8793fixedJhjzzOo((int) (j >> 32), (int) (j & 4294967295L));
            }
        }, z));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final FiniteAnimationSpec DefaultBoundsTransform$lambda$0(Rect rect, Rect rect2) {
        return AnimationSpecKt.spring(1.0f, 400.0f, VisibilityThresholdsKt.getVisibilityThreshold(Rect.INSTANCE));
    }
}
