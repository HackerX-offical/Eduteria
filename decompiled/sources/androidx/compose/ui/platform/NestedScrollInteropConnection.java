package androidx.compose.ui.platform;

import android.view.View;
import androidx.compose.ui.geometry.Offset;
import androidx.compose.ui.input.nestedscroll.NestedScrollConnection;
import androidx.compose.ui.unit.Velocity;
import androidx.core.view.NestedScrollingChildHelper;
import androidx.core.view.ViewCompat;
import com.facebook.appevents.internal.ViewHierarchyConstants;
import kotlin.Metadata;
import kotlin.collections.ArraysKt;
import kotlin.coroutines.Continuation;

/* JADX INFO: compiled from: NestedScrollInteropConnection.android.kt */
/* JADX INFO: loaded from: classes3.dex */
@Metadata(d1 = {"\u0000B\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0007\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0015\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0010\u0002\n\u0000\b\u0001\u0018\u00002\u00020\u0001B\u0017\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005¢\u0006\u0004\b\u0006\u0010\u0007J\u001f\u0010\f\u001a\u00020\r2\u0006\u0010\u000e\u001a\u00020\r2\u0006\u0010\u000f\u001a\u00020\u0010H\u0016¢\u0006\u0004\b\u0011\u0010\u0012J'\u0010\u0013\u001a\u00020\r2\u0006\u0010\u0014\u001a\u00020\r2\u0006\u0010\u000e\u001a\u00020\r2\u0006\u0010\u000f\u001a\u00020\u0010H\u0016¢\u0006\u0004\b\u0015\u0010\u0016J\u0018\u0010\u0017\u001a\u00020\u00182\u0006\u0010\u000e\u001a\u00020\u0018H\u0096@¢\u0006\u0004\b\u0019\u0010\u001aJ \u0010\u001b\u001a\u00020\u00182\u0006\u0010\u0014\u001a\u00020\u00182\u0006\u0010\u000e\u001a\u00020\u0018H\u0096@¢\u0006\u0004\b\u001c\u0010\u001dJ\b\u0010\u001e\u001a\u00020\u001fH\u0002R\u000e\u0010\u0002\u001a\u00020\u0003X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0004\u001a\u00020\u0005X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\b\u001a\u00020\tX\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\n\u001a\u00020\u000bX\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006 "}, d2 = {"Landroidx/compose/ui/platform/NestedScrollInteropConnection;", "Landroidx/compose/ui/input/nestedscroll/NestedScrollConnection;", ViewHierarchyConstants.VIEW_KEY, "Landroid/view/View;", "minFlingVelocity", "", "<init>", "(Landroid/view/View;F)V", "nestedScrollChildHelper", "Landroidx/core/view/NestedScrollingChildHelper;", "consumedScrollCache", "", "onPreScroll", "Landroidx/compose/ui/geometry/Offset;", "available", "source", "Landroidx/compose/ui/input/nestedscroll/NestedScrollSource;", "onPreScroll-OzD1aCk", "(JI)J", "onPostScroll", "consumed", "onPostScroll-DzOQY0M", "(JJI)J", "onPreFling", "Landroidx/compose/ui/unit/Velocity;", "onPreFling-QWom1Mo", "(JLkotlin/coroutines/Continuation;)Ljava/lang/Object;", "onPostFling", "onPostFling-RZ2iAVY", "(JJLkotlin/coroutines/Continuation;)Ljava/lang/Object;", "stopNestedScrolls", "", "ui"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final class NestedScrollInteropConnection implements NestedScrollConnection {
    public static final int $stable = 8;
    private final int[] consumedScrollCache;
    private final float minFlingVelocity;
    private final NestedScrollingChildHelper nestedScrollChildHelper;
    private final View view;

    public NestedScrollInteropConnection(View view, float f2) {
        this.view = view;
        this.minFlingVelocity = f2;
        NestedScrollingChildHelper nestedScrollingChildHelper = new NestedScrollingChildHelper(view);
        nestedScrollingChildHelper.setNestedScrollingEnabled(true);
        this.nestedScrollChildHelper = nestedScrollingChildHelper;
        this.consumedScrollCache = new int[2];
        ViewCompat.setNestedScrollingEnabled(view, true);
    }

    @Override // androidx.compose.ui.input.nestedscroll.NestedScrollConnection
    /* JADX INFO: renamed from: onPreScroll-OzD1aCk */
    public long mo1255onPreScrollOzD1aCk(long available, int source) {
        if (this.nestedScrollChildHelper.startNestedScroll(NestedScrollInteropConnectionKt.m7978getScrollAxesk4lQ0M(available), NestedScrollInteropConnectionKt.m7981toViewTypeGyEprt8(source))) {
            ArraysKt.fill$default(this.consumedScrollCache, 0, 0, 0, 6, (Object) null);
            int iComposeToViewOffset = NestedScrollInteropConnectionKt.composeToViewOffset(Float.intBitsToFloat((int) (available >> 32)));
            int iComposeToViewOffset2 = NestedScrollInteropConnectionKt.composeToViewOffset(Float.intBitsToFloat((int) (4294967295L & available)));
            this.nestedScrollChildHelper.dispatchNestedPreScroll(iComposeToViewOffset, iComposeToViewOffset2, this.consumedScrollCache, null, NestedScrollInteropConnectionKt.m7981toViewTypeGyEprt8(source));
            return NestedScrollInteropConnectionKt.m7980toOffsetmoWRBKg(iComposeToViewOffset, iComposeToViewOffset2, this.consumedScrollCache, available);
        }
        return Offset.INSTANCE.m5739getZeroF1C5BW0();
    }

    @Override // androidx.compose.ui.input.nestedscroll.NestedScrollConnection
    /* JADX INFO: renamed from: onPostScroll-DzOQY0M */
    public long mo677onPostScrollDzOQY0M(long consumed, long available, int source) {
        if (this.nestedScrollChildHelper.startNestedScroll(NestedScrollInteropConnectionKt.m7978getScrollAxesk4lQ0M(available), NestedScrollInteropConnectionKt.m7981toViewTypeGyEprt8(source))) {
            ArraysKt.fill$default(this.consumedScrollCache, 0, 0, 0, 6, (Object) null);
            int iComposeToViewOffset = NestedScrollInteropConnectionKt.composeToViewOffset(Float.intBitsToFloat((int) (available >> 32)));
            int iComposeToViewOffset2 = NestedScrollInteropConnectionKt.composeToViewOffset(Float.intBitsToFloat((int) (available & 4294967295L)));
            this.nestedScrollChildHelper.dispatchNestedScroll(NestedScrollInteropConnectionKt.composeToViewOffset(Float.intBitsToFloat((int) (consumed >> 32))), NestedScrollInteropConnectionKt.composeToViewOffset(Float.intBitsToFloat((int) (consumed & 4294967295L))), iComposeToViewOffset, iComposeToViewOffset2, null, NestedScrollInteropConnectionKt.m7981toViewTypeGyEprt8(source), this.consumedScrollCache);
            return NestedScrollInteropConnectionKt.m7980toOffsetmoWRBKg(iComposeToViewOffset, iComposeToViewOffset2, this.consumedScrollCache, available);
        }
        return Offset.INSTANCE.m5739getZeroF1C5BW0();
    }

    @Override // androidx.compose.ui.input.nestedscroll.NestedScrollConnection
    /* JADX INFO: renamed from: onPreFling-QWom1Mo */
    public Object mo1254onPreFlingQWom1Mo(long j, Continuation<? super Velocity> continuation) {
        if (!this.nestedScrollChildHelper.dispatchNestedPreFling(NestedScrollInteropConnectionKt.toViewVelocity(Velocity.m9068getXimpl(j)), NestedScrollInteropConnectionKt.toViewVelocity(Velocity.m9069getYimpl(j))) && !this.nestedScrollChildHelper.dispatchNestedFling(NestedScrollInteropConnectionKt.toViewVelocity(Velocity.m9068getXimpl(j)), NestedScrollInteropConnectionKt.toViewVelocity(Velocity.m9069getYimpl(j)), true)) {
            j = Velocity.INSTANCE.m9079getZero9UxMQ8M();
        }
        return Velocity.m9059boximpl(j);
    }

    @Override // androidx.compose.ui.input.nestedscroll.NestedScrollConnection
    /* JADX INFO: renamed from: onPostFling-RZ2iAVY */
    public Object mo676onPostFlingRZ2iAVY(long j, long j2, Continuation<? super Velocity> continuation) {
        stopNestedScrolls();
        return Velocity.m9059boximpl(Velocity.INSTANCE.m9079getZero9UxMQ8M());
    }

    private final void stopNestedScrolls() {
        if (this.nestedScrollChildHelper.hasNestedScrollingParent(0)) {
            this.nestedScrollChildHelper.stopNestedScroll(0);
        }
        if (this.nestedScrollChildHelper.hasNestedScrollingParent(1)) {
            this.nestedScrollChildHelper.stopNestedScroll(1);
        }
    }
}
