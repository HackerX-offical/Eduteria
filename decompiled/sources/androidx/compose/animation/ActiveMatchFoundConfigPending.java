package androidx.compose.animation;

import androidx.compose.animation.SharedTransitionStateMachine;
import androidx.compose.runtime.MutableState;
import androidx.compose.runtime.SnapshotStateKt__SnapshotStateKt;
import androidx.compose.ui.geometry.Rect;
import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;

/* JADX INFO: compiled from: SharedTransitionStateMachine.kt */
/* JADX INFO: loaded from: classes.dex */
@Metadata(d1 = {"\u0000D\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\t\n\u0002\u0010\u000b\n\u0002\b\u000b\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0010\u0002\n\u0002\b\u0003\b\u0001\u0018\u00002\u00020\u0001B)\u0012\b\u0010\u0002\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u0005\u0012\n\b\u0002\u0010\u0006\u001a\u0004\u0018\u00010\u0007¢\u0006\u0004\b\b\u0010\tJ\u0012\u0010\u001b\u001a\u0004\u0018\u00010\u00072\u0006\u0010\u001c\u001a\u00020\u001dH\u0016J7\u0010\u001e\u001a\u00020\u00012\u0006\u0010\u001c\u001a\u00020\u001d2\u0006\u0010\u001f\u001a\u00020\u00032\u0006\u0010 \u001a\u00020!2\u0006\u0010\"\u001a\u00020#2\u0006\u0010$\u001a\u00020#H\u0016¢\u0006\u0004\b%\u0010&J\u0012\u0010'\u001a\u00020\u00012\b\u0010(\u001a\u0004\u0018\u00010\u0003H\u0016J\u0010\u0010)\u001a\u00020*2\u0006\u0010+\u001a\u00020\u0007H\u0016J\b\u0010,\u001a\u00020\u0001H\u0016R\u001c\u0010\u0002\u001a\u0004\u0018\u00010\u0003X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\n\u0010\u000b\"\u0004\b\f\u0010\rR\u0016\u0010\u0004\u001a\u0004\u0018\u00010\u0005X\u0096\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u000e\u0010\u000fR\u0014\u0010\u0010\u001a\u00020\u00118VX\u0096\u0004¢\u0006\u0006\u001a\u0004\b\u0012\u0010\u0013R/\u0010\u0006\u001a\u0004\u0018\u00010\u00072\b\u0010\u0014\u001a\u0004\u0018\u00010\u00078V@RX\u0096\u008e\u0002¢\u0006\u0012\n\u0004\b\u0019\u0010\u001a\u001a\u0004\b\u0015\u0010\u0016\"\u0004\b\u0017\u0010\u0018¨\u0006-"}, d2 = {"Landroidx/compose/animation/ActiveMatchFoundConfigPending;", "Landroidx/compose/animation/SharedTransitionStateMachine$State;", "targetBoundsProviderBeforeConfig", "Landroidx/compose/animation/BoundsProvider;", "targetData", "Landroidx/compose/animation/TargetData;", "currentBounds", "Landroidx/compose/ui/geometry/Rect;", "<init>", "(Landroidx/compose/animation/BoundsProvider;Landroidx/compose/animation/TargetData;Landroidx/compose/ui/geometry/Rect;)V", "getTargetBoundsProviderBeforeConfig", "()Landroidx/compose/animation/BoundsProvider;", "setTargetBoundsProviderBeforeConfig", "(Landroidx/compose/animation/BoundsProvider;)V", "getTargetData", "()Landroidx/compose/animation/TargetData;", "activeMatchFound", "", "getActiveMatchFound", "()Z", "<set-?>", "getCurrentBounds", "()Landroidx/compose/ui/geometry/Rect;", "setCurrentBounds", "(Landroidx/compose/ui/geometry/Rect;)V", "currentBounds$delegate", "Landroidx/compose/runtime/MutableState;", "initializeCurrentBounds", "sharedElement", "Landroidx/compose/animation/SharedElement;", "configureActiveMatch", "targetBoundsProvider", "lookaheadSize", "Landroidx/compose/ui/geometry/Size;", "topLeft", "Landroidx/compose/ui/geometry/Offset;", "structuralOffset", "configureActiveMatch-38uP1EE", "(Landroidx/compose/animation/SharedElement;Landroidx/compose/animation/BoundsProvider;JJJ)Landroidx/compose/animation/SharedTransitionStateMachine$State;", "onMatchFound", "previousTargetBoundsProvider", "updateBounds", "", "bounds", "onVisibleContentRemovedDuringTransition", "animation"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final class ActiveMatchFoundConfigPending extends SharedTransitionStateMachine.State {
    public static final int $stable = 8;

    /* JADX INFO: renamed from: currentBounds$delegate, reason: from kotlin metadata */
    private final MutableState currentBounds;
    private BoundsProvider targetBoundsProviderBeforeConfig;
    private final TargetData targetData;

    @Override // androidx.compose.animation.SharedTransitionStateMachine.State
    public boolean getActiveMatchFound() {
        return true;
    }

    public ActiveMatchFoundConfigPending(BoundsProvider boundsProvider, TargetData targetData, Rect rect) {
        super(null);
        this.targetBoundsProviderBeforeConfig = boundsProvider;
        this.targetData = targetData;
        this.currentBounds = SnapshotStateKt__SnapshotStateKt.mutableStateOf$default(rect, null, 2, null);
    }

    public /* synthetic */ ActiveMatchFoundConfigPending(BoundsProvider boundsProvider, TargetData targetData, Rect rect, int i, DefaultConstructorMarker defaultConstructorMarker) {
        this(boundsProvider, (i & 2) != 0 ? null : targetData, (i & 4) != 0 ? null : rect);
    }

    public final BoundsProvider getTargetBoundsProviderBeforeConfig() {
        return this.targetBoundsProviderBeforeConfig;
    }

    public final void setTargetBoundsProviderBeforeConfig(BoundsProvider boundsProvider) {
        this.targetBoundsProviderBeforeConfig = boundsProvider;
    }

    @Override // androidx.compose.animation.SharedTransitionStateMachine.State
    public TargetData getTargetData() {
        return this.targetData;
    }

    private void setCurrentBounds(Rect rect) {
        this.currentBounds.setValue(rect);
    }

    /* JADX WARN: Multi-variable type inference failed */
    @Override // androidx.compose.animation.SharedTransitionStateMachine.State
    public Rect getCurrentBounds() {
        return (Rect) this.currentBounds.getValue();
    }

    @Override // androidx.compose.animation.SharedTransitionStateMachine.State
    public Rect initializeCurrentBounds(SharedElement sharedElement) {
        SharedElementEntry sharedElementEntry;
        Rect currentBounds = getCurrentBounds();
        if (currentBounds != null) {
            return currentBounds;
        }
        if (getCurrentBounds() == null) {
            BoundsProvider boundsProvider = this.targetBoundsProviderBeforeConfig;
            if (boundsProvider == null) {
                List<SharedElementEntry> allEntries = sharedElement.getAllEntries();
                int size = allEntries.size();
                int i = 0;
                while (true) {
                    if (i >= size) {
                        sharedElementEntry = null;
                        break;
                    }
                    sharedElementEntry = allEntries.get(i);
                    if (sharedElement.getEnabledEntries().contains(sharedElementEntry)) {
                        break;
                    }
                    i++;
                }
                SharedElementEntry sharedElementEntry2 = sharedElementEntry;
                boundsProvider = sharedElementEntry2 != null ? sharedElementEntry2.getBoundsProvider() : null;
            }
            Rect rectObtainBoundsFromLastTarget = SharedTransitionStateMachineKt.obtainBoundsFromLastTarget(sharedElement, boundsProvider);
            if (rectObtainBoundsFromLastTarget != null) {
                setCurrentBounds(rectObtainBoundsFromLastTarget);
            }
        }
        return getCurrentBounds();
    }

    /* JADX WARN: Removed duplicated region for block: B:24:0x0059 A[PHI: r1
      0x0059: PHI (r1v1 androidx.compose.ui.geometry.Rect) = (r1v0 androidx.compose.ui.geometry.Rect), (r1v5 androidx.compose.ui.geometry.Rect) binds: [B:6:0x0018, B:22:0x0051] A[DONT_GENERATE, DONT_INLINE]] */
    @Override // androidx.compose.animation.SharedTransitionStateMachine.State
    /* JADX INFO: renamed from: configureActiveMatch-38uP1EE */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public androidx.compose.animation.SharedTransitionStateMachine.State mo39configureActiveMatch38uP1EE(androidx.compose.animation.SharedElement r11, androidx.compose.animation.BoundsProvider r12, long r13, long r15, long r17) {
        /*
            r10 = this;
            androidx.compose.animation.TargetData r0 = r10.getTargetData()
            if (r0 != 0) goto L14
            androidx.compose.animation.TargetData r1 = new androidx.compose.animation.TargetData
            long r4 = androidx.compose.ui.geometry.Offset.m5727minusMKHz9U(r15, r17)
            r8 = 0
            r2 = r13
            r6 = r17
            r1.<init>(r2, r4, r6, r8)
            r0 = r1
        L14:
            androidx.compose.ui.geometry.Rect r1 = r10.getCurrentBounds()
            if (r1 != 0) goto L59
            androidx.compose.animation.BoundsProvider r1 = r10.targetBoundsProviderBeforeConfig
            if (r1 != 0) goto L4d
            java.util.List r1 = r11.getAllEntries()
            r4 = r1
            java.util.Collection r4 = (java.util.Collection) r4
            int r4 = r4.size()
            r5 = 0
        L2a:
            r6 = 0
            if (r5 >= r4) goto L42
            java.lang.Object r7 = r1.get(r5)
            r8 = r7
            androidx.compose.animation.SharedElementEntry r8 = (androidx.compose.animation.SharedElementEntry) r8
            java.util.List r9 = r11.getEnabledEntries()
            boolean r8 = r9.contains(r8)
            if (r8 == 0) goto L3f
            goto L43
        L3f:
            int r5 = r5 + 1
            goto L2a
        L42:
            r7 = r6
        L43:
            androidx.compose.animation.SharedElementEntry r7 = (androidx.compose.animation.SharedElementEntry) r7
            if (r7 == 0) goto L4c
            androidx.compose.animation.BoundsProvider r1 = r7.getBoundsProvider()
            goto L4d
        L4c:
            r1 = r6
        L4d:
            androidx.compose.ui.geometry.Rect r1 = androidx.compose.animation.SharedTransitionStateMachineKt.access$obtainBoundsFromLastTarget(r11, r1)
            if (r1 != 0) goto L59
            r5 = r15
            androidx.compose.ui.geometry.Rect r1 = androidx.compose.ui.geometry.RectKt.m5763Recttz77jQw(r5, r13)
            goto L5a
        L59:
            r5 = r15
        L5a:
            r9 = 1
            r3 = r13
            r7 = r17
            r2 = r0
            androidx.compose.animation.SharedTransitionStateMachineKt.m158access$updateTargetDataBGTQxF0(r2, r3, r5, r7, r9)
            androidx.compose.animation.ActiveMatchConfigured r11 = new androidx.compose.animation.ActiveMatchConfigured
            r11.<init>(r2, r12, r1)
            androidx.compose.animation.SharedTransitionStateMachine$State r11 = (androidx.compose.animation.SharedTransitionStateMachine.State) r11
            return r11
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.compose.animation.ActiveMatchFoundConfigPending.mo39configureActiveMatch38uP1EE(androidx.compose.animation.SharedElement, androidx.compose.animation.BoundsProvider, long, long, long):androidx.compose.animation.SharedTransitionStateMachine$State");
    }

    @Override // androidx.compose.animation.SharedTransitionStateMachine.State
    public SharedTransitionStateMachine.State onMatchFound(BoundsProvider previousTargetBoundsProvider) {
        if (this.targetBoundsProviderBeforeConfig == null) {
            this.targetBoundsProviderBeforeConfig = previousTargetBoundsProvider;
        }
        return this;
    }

    @Override // androidx.compose.animation.SharedTransitionStateMachine.State
    public void updateBounds(Rect bounds) {
        setCurrentBounds(bounds);
    }

    @Override // androidx.compose.animation.SharedTransitionStateMachine.State
    public SharedTransitionStateMachine.State onVisibleContentRemovedDuringTransition() {
        return NoMatchFound.INSTANCE;
    }
}
