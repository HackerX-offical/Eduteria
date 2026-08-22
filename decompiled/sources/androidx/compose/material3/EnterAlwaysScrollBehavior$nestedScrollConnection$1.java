package androidx.compose.material3;

import androidx.compose.ui.geometry.Offset;
import androidx.compose.ui.input.nestedscroll.NestedScrollConnection;
import kotlin.Metadata;

/* JADX INFO: compiled from: AppBar.kt */
/* JADX INFO: loaded from: classes.dex */
@Metadata(d1 = {"\u0000#\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\u0003*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\u001f\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u00032\u0006\u0010\u0005\u001a\u00020\u0006H\u0016¢\u0006\u0004\b\u0007\u0010\bJ'\u0010\t\u001a\u00020\u00032\u0006\u0010\n\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u00032\u0006\u0010\u0005\u001a\u00020\u0006H\u0016¢\u0006\u0004\b\u000b\u0010\fJ \u0010\r\u001a\u00020\u000e2\u0006\u0010\n\u001a\u00020\u000e2\u0006\u0010\u0004\u001a\u00020\u000eH\u0096@¢\u0006\u0004\b\u000f\u0010\u0010¨\u0006\u0011"}, d2 = {"androidx/compose/material3/EnterAlwaysScrollBehavior$nestedScrollConnection$1", "Landroidx/compose/ui/input/nestedscroll/NestedScrollConnection;", "onPreScroll", "Landroidx/compose/ui/geometry/Offset;", "available", "source", "Landroidx/compose/ui/input/nestedscroll/NestedScrollSource;", "onPreScroll-OzD1aCk", "(JI)J", "onPostScroll", "consumed", "onPostScroll-DzOQY0M", "(JJI)J", "onPostFling", "Landroidx/compose/ui/unit/Velocity;", "onPostFling-RZ2iAVY", "(JJLkotlin/coroutines/Continuation;)Ljava/lang/Object;", "material3"}, k = 1, mv = {2, 0, 0}, xi = 48)
public final class EnterAlwaysScrollBehavior$nestedScrollConnection$1 implements NestedScrollConnection {
    final /* synthetic */ EnterAlwaysScrollBehavior this$0;

    EnterAlwaysScrollBehavior$nestedScrollConnection$1(EnterAlwaysScrollBehavior enterAlwaysScrollBehavior) {
        this.this$0 = enterAlwaysScrollBehavior;
    }

    @Override // androidx.compose.ui.input.nestedscroll.NestedScrollConnection
    /* JADX INFO: renamed from: onPreScroll-OzD1aCk */
    public long mo1255onPreScrollOzD1aCk(long available, int source) {
        if (!this.this$0.getCanScroll().invoke().booleanValue()) {
            return Offset.INSTANCE.m5739getZeroF1C5BW0();
        }
        float heightOffset = this.this$0.getState().getHeightOffset();
        TopAppBarState state = this.this$0.getState();
        state.setHeightOffset(state.getHeightOffset() + Float.intBitsToFloat((int) (4294967295L & available)));
        if (!this.this$0.getReverseLayout() && heightOffset != this.this$0.getState().getHeightOffset()) {
            return Offset.m5717copydBAh8RU$default(available, 0.0f, 0.0f, 2, null);
        }
        return Offset.INSTANCE.m5739getZeroF1C5BW0();
    }

    @Override // androidx.compose.ui.input.nestedscroll.NestedScrollConnection
    /* JADX INFO: renamed from: onPostScroll-DzOQY0M */
    public long mo677onPostScrollDzOQY0M(long consumed, long available, int source) {
        if (!this.this$0.getCanScroll().invoke().booleanValue()) {
            return Offset.INSTANCE.m5739getZeroF1C5BW0();
        }
        TopAppBarState state = this.this$0.getState();
        int i = (int) (consumed & 4294967295L);
        state.setContentOffset(state.getContentOffset() + Float.intBitsToFloat(i));
        if (!this.this$0.getReverseLayout()) {
            TopAppBarState state2 = this.this$0.getState();
            state2.setHeightOffset(state2.getHeightOffset() + Float.intBitsToFloat(i));
        }
        return Offset.INSTANCE.m5739getZeroF1C5BW0();
    }

    /* JADX WARN: Code restructure failed: missing block: B:29:0x00b0, code lost:
    
        if (r13 == r0) goto L30;
     */
    /* JADX WARN: Removed duplicated region for block: B:7:0x0014  */
    @Override // androidx.compose.ui.input.nestedscroll.NestedScrollConnection
    /* JADX INFO: renamed from: onPostFling-RZ2iAVY */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public java.lang.Object mo676onPostFlingRZ2iAVY(long r9, long r11, kotlin.coroutines.Continuation<? super androidx.compose.ui.unit.Velocity> r13) {
        /*
            r8 = this;
            boolean r0 = r13 instanceof androidx.compose.material3.EnterAlwaysScrollBehavior$nestedScrollConnection$1$onPostFling$1
            if (r0 == 0) goto L14
            r0 = r13
            androidx.compose.material3.EnterAlwaysScrollBehavior$nestedScrollConnection$1$onPostFling$1 r0 = (androidx.compose.material3.EnterAlwaysScrollBehavior$nestedScrollConnection$1$onPostFling$1) r0
            int r1 = r0.label
            r2 = -2147483648(0xffffffff80000000, float:-0.0)
            r1 = r1 & r2
            if (r1 == 0) goto L14
            int r13 = r0.label
            int r13 = r13 - r2
            r0.label = r13
            goto L19
        L14:
            androidx.compose.material3.EnterAlwaysScrollBehavior$nestedScrollConnection$1$onPostFling$1 r0 = new androidx.compose.material3.EnterAlwaysScrollBehavior$nestedScrollConnection$1$onPostFling$1
            r0.<init>(r8, r13)
        L19:
            r6 = r0
            java.lang.Object r13 = r6.result
            java.lang.Object r0 = kotlin.coroutines.intrinsics.IntrinsicsKt.getCOROUTINE_SUSPENDED()
            int r1 = r6.label
            r7 = 2
            r2 = 1
            if (r1 == 0) goto L41
            if (r1 == r2) goto L3a
            if (r1 != r7) goto L32
            long r9 = r6.J$0
            kotlin.ResultKt.throwOnFailure(r13)
            r1 = r8
            goto Lb3
        L32:
            java.lang.IllegalStateException r9 = new java.lang.IllegalStateException
            java.lang.String r10 = "call to 'resume' before 'invoke' with coroutine"
            r9.<init>(r10)
            throw r9
        L3a:
            long r11 = r6.J$0
            kotlin.ResultKt.throwOnFailure(r13)
            r1 = r8
            goto L8c
        L41:
            kotlin.ResultKt.throwOnFailure(r13)
            float r13 = androidx.compose.ui.unit.Velocity.m9069getYimpl(r11)
            r1 = 0
            int r13 = (r13 > r1 ? 1 : (r13 == r1 ? 0 : -1))
            if (r13 <= 0) goto L7d
            androidx.compose.material3.EnterAlwaysScrollBehavior r13 = r8.this$0
            androidx.compose.material3.TopAppBarState r13 = r13.getState()
            float r13 = r13.getHeightOffset()
            int r13 = (r13 > r1 ? 1 : (r13 == r1 ? 0 : -1))
            if (r13 != 0) goto L5c
            goto L74
        L5c:
            androidx.compose.material3.EnterAlwaysScrollBehavior r13 = r8.this$0
            androidx.compose.material3.TopAppBarState r13 = r13.getState()
            float r13 = r13.getHeightOffset()
            androidx.compose.material3.EnterAlwaysScrollBehavior r3 = r8.this$0
            androidx.compose.material3.TopAppBarState r3 = r3.getState()
            float r3 = r3.getHeightOffsetLimit()
            int r13 = (r13 > r3 ? 1 : (r13 == r3 ? 0 : -1))
            if (r13 != 0) goto L7d
        L74:
            androidx.compose.material3.EnterAlwaysScrollBehavior r13 = r8.this$0
            androidx.compose.material3.TopAppBarState r13 = r13.getState()
            r13.setContentOffset(r1)
        L7d:
            r6.J$0 = r11
            r6.label = r2
            r1 = r8
            r2 = r9
            r4 = r11
            java.lang.Object r13 = super.mo676onPostFlingRZ2iAVY(r2, r4, r6)
            if (r13 != r0) goto L8b
            goto Lb2
        L8b:
            r11 = r4
        L8c:
            androidx.compose.ui.unit.Velocity r13 = (androidx.compose.ui.unit.Velocity) r13
            long r9 = r13.getPackedValue()
            androidx.compose.material3.EnterAlwaysScrollBehavior r13 = r1.this$0
            androidx.compose.material3.TopAppBarState r13 = r13.getState()
            float r11 = androidx.compose.ui.unit.Velocity.m9069getYimpl(r11)
            androidx.compose.material3.EnterAlwaysScrollBehavior r12 = r1.this$0
            androidx.compose.animation.core.DecayAnimationSpec r12 = r12.getFlingAnimationSpec()
            androidx.compose.material3.EnterAlwaysScrollBehavior r2 = r1.this$0
            androidx.compose.animation.core.AnimationSpec r2 = r2.getSnapAnimationSpec()
            r6.J$0 = r9
            r6.label = r7
            java.lang.Object r13 = androidx.compose.material3.AppBarKt.access$settleAppBar(r13, r11, r12, r2, r6)
            if (r13 != r0) goto Lb3
        Lb2:
            return r0
        Lb3:
            androidx.compose.ui.unit.Velocity r13 = (androidx.compose.ui.unit.Velocity) r13
            long r11 = r13.getPackedValue()
            long r9 = androidx.compose.ui.unit.Velocity.m9072plusAH228Gc(r9, r11)
            androidx.compose.ui.unit.Velocity r9 = androidx.compose.ui.unit.Velocity.m9059boximpl(r9)
            return r9
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.compose.material3.EnterAlwaysScrollBehavior$nestedScrollConnection$1.mo676onPostFlingRZ2iAVY(long, long, kotlin.coroutines.Continuation):java.lang.Object");
    }
}
