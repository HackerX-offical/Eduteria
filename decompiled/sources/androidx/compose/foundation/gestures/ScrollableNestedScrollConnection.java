package androidx.compose.foundation.gestures;

import androidx.compose.ui.geometry.Offset;
import androidx.compose.ui.input.nestedscroll.NestedScrollConnection;
import kotlin.Metadata;
import org.jivesoftware.smack.sm.packet.StreamManagement;

/* JADX INFO: compiled from: Scrollable.kt */
/* JADX INFO: loaded from: classes.dex */
@Metadata(d1 = {"\u00000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\t\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\b\u0001\u0018\u00002\u00020\u0001B\u0017\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005¢\u0006\u0004\b\u0006\u0010\u0007J'\u0010\u000e\u001a\u00020\u000f2\u0006\u0010\u0010\u001a\u00020\u000f2\u0006\u0010\u0011\u001a\u00020\u000f2\u0006\u0010\u0012\u001a\u00020\u0013H\u0016¢\u0006\u0004\b\u0014\u0010\u0015J \u0010\u0016\u001a\u00020\u00172\u0006\u0010\u0010\u001a\u00020\u00172\u0006\u0010\u0011\u001a\u00020\u0017H\u0096@¢\u0006\u0004\b\u0018\u0010\u0019R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\b\u0010\tR\u001a\u0010\u0004\u001a\u00020\u0005X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\n\u0010\u000b\"\u0004\b\f\u0010\r¨\u0006\u001a"}, d2 = {"Landroidx/compose/foundation/gestures/ScrollableNestedScrollConnection;", "Landroidx/compose/ui/input/nestedscroll/NestedScrollConnection;", "scrollingLogic", "Landroidx/compose/foundation/gestures/ScrollLogic;", StreamManagement.Enabled.ELEMENT, "", "<init>", "(Landroidx/compose/foundation/gestures/ScrollLogic;Z)V", "getScrollingLogic", "()Landroidx/compose/foundation/gestures/ScrollLogic;", "getEnabled", "()Z", "setEnabled", "(Z)V", "onPostScroll", "Landroidx/compose/ui/geometry/Offset;", "consumed", "available", "source", "Landroidx/compose/ui/input/nestedscroll/NestedScrollSource;", "onPostScroll-DzOQY0M", "(JJI)J", "onPostFling", "Landroidx/compose/ui/unit/Velocity;", "onPostFling-RZ2iAVY", "(JJLkotlin/coroutines/Continuation;)Ljava/lang/Object;", "foundation"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final class ScrollableNestedScrollConnection implements NestedScrollConnection {
    public static final int $stable = 8;
    private boolean enabled;
    private final ScrollLogic scrollingLogic;

    public ScrollableNestedScrollConnection(ScrollLogic scrollLogic, boolean z) {
        this.scrollingLogic = scrollLogic;
        this.enabled = z;
    }

    public final ScrollLogic getScrollingLogic() {
        return this.scrollingLogic;
    }

    public final boolean getEnabled() {
        return this.enabled;
    }

    public final void setEnabled(boolean z) {
        this.enabled = z;
    }

    @Override // androidx.compose.ui.input.nestedscroll.NestedScrollConnection
    /* JADX INFO: renamed from: onPostScroll-DzOQY0M, reason: not valid java name */
    public long mo677onPostScrollDzOQY0M(long consumed, long available, int source) {
        if (this.enabled) {
            return this.scrollingLogic.mo664performRawScrollMKHz9U(available);
        }
        return Offset.INSTANCE.m5739getZeroF1C5BW0();
    }

    /* JADX WARN: Removed duplicated region for block: B:7:0x0014  */
    @Override // androidx.compose.ui.input.nestedscroll.NestedScrollConnection
    /* JADX INFO: renamed from: onPostFling-RZ2iAVY, reason: not valid java name */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public java.lang.Object mo676onPostFlingRZ2iAVY(long r3, long r5, kotlin.coroutines.Continuation<? super androidx.compose.ui.unit.Velocity> r7) {
        /*
            r2 = this;
            boolean r3 = r7 instanceof androidx.compose.foundation.gestures.ScrollableNestedScrollConnection$onPostFling$1
            if (r3 == 0) goto L14
            r3 = r7
            androidx.compose.foundation.gestures.ScrollableNestedScrollConnection$onPostFling$1 r3 = (androidx.compose.foundation.gestures.ScrollableNestedScrollConnection$onPostFling$1) r3
            int r4 = r3.label
            r0 = -2147483648(0xffffffff80000000, float:-0.0)
            r4 = r4 & r0
            if (r4 == 0) goto L14
            int r4 = r3.label
            int r4 = r4 - r0
            r3.label = r4
            goto L19
        L14:
            androidx.compose.foundation.gestures.ScrollableNestedScrollConnection$onPostFling$1 r3 = new androidx.compose.foundation.gestures.ScrollableNestedScrollConnection$onPostFling$1
            r3.<init>(r2, r7)
        L19:
            java.lang.Object r4 = r3.result
            java.lang.Object r7 = kotlin.coroutines.intrinsics.IntrinsicsKt.getCOROUTINE_SUSPENDED()
            int r0 = r3.label
            r1 = 1
            if (r0 == 0) goto L34
            if (r0 != r1) goto L2c
            long r5 = r3.J$0
            kotlin.ResultKt.throwOnFailure(r4)
            goto L57
        L2c:
            java.lang.IllegalStateException r3 = new java.lang.IllegalStateException
            java.lang.String r4 = "call to 'resume' before 'invoke' with coroutine"
            r3.<init>(r4)
            throw r3
        L34:
            kotlin.ResultKt.throwOnFailure(r4)
            boolean r4 = r2.enabled
            if (r4 == 0) goto L62
            androidx.compose.foundation.gestures.ScrollLogic r4 = r2.scrollingLogic
            boolean r4 = r4.isFlinging()
            if (r4 == 0) goto L4a
            androidx.compose.ui.unit.Velocity$Companion r3 = androidx.compose.ui.unit.Velocity.INSTANCE
            long r3 = r3.m9079getZero9UxMQ8M()
            goto L5d
        L4a:
            androidx.compose.foundation.gestures.ScrollLogic r4 = r2.scrollingLogic
            r3.J$0 = r5
            r3.label = r1
            java.lang.Object r4 = r4.mo663doFlingAnimationQWom1Mo(r5, r3)
            if (r4 != r7) goto L57
            return r7
        L57:
            androidx.compose.ui.unit.Velocity r4 = (androidx.compose.ui.unit.Velocity) r4
            long r3 = r4.getPackedValue()
        L5d:
            long r3 = androidx.compose.ui.unit.Velocity.m9071minusAH228Gc(r5, r3)
            goto L68
        L62:
            androidx.compose.ui.unit.Velocity$Companion r3 = androidx.compose.ui.unit.Velocity.INSTANCE
            long r3 = r3.m9079getZero9UxMQ8M()
        L68:
            androidx.compose.ui.unit.Velocity r3 = androidx.compose.ui.unit.Velocity.m9059boximpl(r3)
            return r3
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.compose.foundation.gestures.ScrollableNestedScrollConnection.mo676onPostFlingRZ2iAVY(long, long, kotlin.coroutines.Continuation):java.lang.Object");
    }
}
