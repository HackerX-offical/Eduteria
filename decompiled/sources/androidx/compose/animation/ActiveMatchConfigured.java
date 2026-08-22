package androidx.compose.animation;

import androidx.compose.animation.SharedTransitionStateMachine;
import androidx.compose.runtime.MutableState;
import androidx.compose.runtime.SnapshotStateKt__SnapshotStateKt;
import androidx.compose.ui.geometry.Offset;
import androidx.compose.ui.geometry.Rect;
import androidx.compose.ui.geometry.RectKt;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: compiled from: SharedTransitionStateMachine.kt */
/* JADX INFO: loaded from: classes.dex */
@Metadata(d1 = {"\u0000J\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u000b\n\u0002\b\u000f\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u0002\n\u0002\b\u0002\b\u0001\u0018\u00002\u00020\u0001B\u001f\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\u0006\u0010\u0006\u001a\u00020\u0007¢\u0006\u0004\b\b\u0010\tJ\u0012\u0010\u001c\u001a\u00020\u001d2\b\u0010\u001e\u001a\u0004\u0018\u00010\u0005H\u0016J7\u0010\u001f\u001a\u00020\u001d2\u0006\u0010 \u001a\u00020!2\u0006\u0010\u0004\u001a\u00020\u00052\u0006\u0010\"\u001a\u00020#2\u0006\u0010$\u001a\u00020%2\u0006\u0010&\u001a\u00020%H\u0016¢\u0006\u0004\b'\u0010(J\b\u0010)\u001a\u00020\u001dH\u0016J\u0010\u0010*\u001a\u00020+2\u0006\u0010,\u001a\u00020\u0007H\u0016R\u0014\u0010\u0002\u001a\u00020\u0003X\u0096\u0004¢\u0006\b\n\u0000\u001a\u0004\b\n\u0010\u000bR\u0014\u0010\f\u001a\u00020\r8VX\u0096\u0004¢\u0006\u0006\u001a\u0004\b\u000e\u0010\u000fR+\u0010\u0004\u001a\u00020\u00052\u0006\u0010\u0010\u001a\u00020\u00058F@FX\u0086\u008e\u0002¢\u0006\u0012\n\u0004\b\u0015\u0010\u0016\u001a\u0004\b\u0011\u0010\u0012\"\u0004\b\u0013\u0010\u0014R+\u0010\u0006\u001a\u00020\u00072\u0006\u0010\u0010\u001a\u00020\u00078V@RX\u0096\u008e\u0002¢\u0006\u0012\n\u0004\b\u001b\u0010\u0016\u001a\u0004\b\u0017\u0010\u0018\"\u0004\b\u0019\u0010\u001a¨\u0006-"}, d2 = {"Landroidx/compose/animation/ActiveMatchConfigured;", "Landroidx/compose/animation/MatchIsOrHasBeenConfigured;", "targetData", "Landroidx/compose/animation/TargetData;", "targetBoundsProvider", "Landroidx/compose/animation/BoundsProvider;", "currentBounds", "Landroidx/compose/ui/geometry/Rect;", "<init>", "(Landroidx/compose/animation/TargetData;Landroidx/compose/animation/BoundsProvider;Landroidx/compose/ui/geometry/Rect;)V", "getTargetData", "()Landroidx/compose/animation/TargetData;", "activeMatchFound", "", "getActiveMatchFound", "()Z", "<set-?>", "getTargetBoundsProvider", "()Landroidx/compose/animation/BoundsProvider;", "setTargetBoundsProvider", "(Landroidx/compose/animation/BoundsProvider;)V", "targetBoundsProvider$delegate", "Landroidx/compose/runtime/MutableState;", "getCurrentBounds", "()Landroidx/compose/ui/geometry/Rect;", "setCurrentBounds", "(Landroidx/compose/ui/geometry/Rect;)V", "currentBounds$delegate", "onMatchFound", "Landroidx/compose/animation/SharedTransitionStateMachine$State;", "previousTargetBoundsProvider", "configureActiveMatch", "sharedElement", "Landroidx/compose/animation/SharedElement;", "lookaheadSize", "Landroidx/compose/ui/geometry/Size;", "topLeft", "Landroidx/compose/ui/geometry/Offset;", "structuralOffset", "configureActiveMatch-38uP1EE", "(Landroidx/compose/animation/SharedElement;Landroidx/compose/animation/BoundsProvider;JJJ)Landroidx/compose/animation/SharedTransitionStateMachine$State;", "onVisibleContentRemovedDuringTransition", "updateBounds", "", "bounds", "animation"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final class ActiveMatchConfigured extends MatchIsOrHasBeenConfigured {
    public static final int $stable = 0;

    /* JADX INFO: renamed from: currentBounds$delegate, reason: from kotlin metadata */
    private final MutableState currentBounds;

    /* JADX INFO: renamed from: targetBoundsProvider$delegate, reason: from kotlin metadata */
    private final MutableState targetBoundsProvider;
    private final TargetData targetData;

    @Override // androidx.compose.animation.SharedTransitionStateMachine.State
    public boolean getActiveMatchFound() {
        return true;
    }

    public ActiveMatchConfigured(TargetData targetData, BoundsProvider boundsProvider, Rect rect) {
        this.targetData = targetData;
        this.targetBoundsProvider = SnapshotStateKt__SnapshotStateKt.mutableStateOf$default(boundsProvider, null, 2, null);
        this.currentBounds = SnapshotStateKt__SnapshotStateKt.mutableStateOf$default(rect, null, 2, null);
    }

    @Override // androidx.compose.animation.MatchIsOrHasBeenConfigured, androidx.compose.animation.SharedTransitionStateMachine.State
    public TargetData getTargetData() {
        return this.targetData;
    }

    public final BoundsProvider getTargetBoundsProvider() {
        return (BoundsProvider) this.targetBoundsProvider.getValue();
    }

    public final void setTargetBoundsProvider(BoundsProvider boundsProvider) {
        this.targetBoundsProvider.setValue(boundsProvider);
    }

    private void setCurrentBounds(Rect rect) {
        this.currentBounds.setValue(rect);
    }

    /* JADX WARN: Multi-variable type inference failed */
    @Override // androidx.compose.animation.MatchIsOrHasBeenConfigured, androidx.compose.animation.SharedTransitionStateMachine.State
    public Rect getCurrentBounds() {
        return (Rect) this.currentBounds.getValue();
    }

    @Override // androidx.compose.animation.SharedTransitionStateMachine.State
    public SharedTransitionStateMachine.State onMatchFound(BoundsProvider previousTargetBoundsProvider) {
        return this;
    }

    @Override // androidx.compose.animation.SharedTransitionStateMachine.State
    /* JADX INFO: renamed from: configureActiveMatch-38uP1EE, reason: not valid java name */
    public SharedTransitionStateMachine.State mo39configureActiveMatch38uP1EE(SharedElement sharedElement, BoundsProvider targetBoundsProvider, long lookaheadSize, long topLeft, long structuralOffset) {
        SharedTransitionStateMachineKt.m159updateTargetDataBGTQxF0(getTargetData(), lookaheadSize, topLeft, structuralOffset, !Intrinsics.areEqual(getTargetBoundsProvider(), targetBoundsProvider));
        setTargetBoundsProvider(targetBoundsProvider);
        return this;
    }

    @Override // androidx.compose.animation.SharedTransitionStateMachine.State
    public SharedTransitionStateMachine.State onVisibleContentRemovedDuringTransition() {
        Rect rectCalculateAlternativeTargetBounds = getTargetBoundsProvider().calculateAlternativeTargetBounds(RectKt.m5763Recttz77jQw(Offset.m5728plusMKHz9U(getTargetData().m172getCurrentMfrOffsetF1C5BW0(), getTargetData().m175getTargetStructuralOffsetF1C5BW0()), getTargetData().m174getSizeNHjbRc()));
        if (rectCalculateAlternativeTargetBounds == null) {
            return NoMatchFound.INSTANCE;
        }
        TargetData targetData = new TargetData(rectCalculateAlternativeTargetBounds.m5756getSizeNHjbRc(), getTargetData().m173getInitialMfrOffsetF1C5BW0(), Offset.m5727minusMKHz9U(rectCalculateAlternativeTargetBounds.m5758getTopLeftF1C5BW0(), getTargetData().m172getCurrentMfrOffsetF1C5BW0()), null);
        targetData.m176setCurrentMfrOffsetk4lQ0M(getTargetData().m172getCurrentMfrOffsetF1C5BW0());
        return new ActiveMatchRemovedDuringTransition(targetData, getCurrentBounds());
    }

    @Override // androidx.compose.animation.SharedTransitionStateMachine.State
    public void updateBounds(Rect bounds) {
        setCurrentBounds(bounds);
    }
}
