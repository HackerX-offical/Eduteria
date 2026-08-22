package androidx.compose.foundation.pager;

import androidx.compose.foundation.gestures.FlingBehavior;
import androidx.compose.foundation.gestures.ScrollScope;
import androidx.compose.foundation.gestures.TargetedFlingBehavior;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.jvm.internal.ContinuationImpl;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.math.MathKt;

/* JADX INFO: compiled from: LazyLayoutPager.kt */
/* JADX INFO: loaded from: classes.dex */
@Metadata(d1 = {"\u0000$\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0010\u0007\n\u0002\u0018\u0002\n\u0002\b\u0003\b\u0002\u0018\u00002\u00020\u0001B\u0017\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005¢\u0006\u0004\b\u0006\u0010\u0007J\u001a\u0010\f\u001a\u00020\r*\u00020\u000e2\u0006\u0010\u000f\u001a\u00020\rH\u0096@¢\u0006\u0002\u0010\u0010R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\b\u0010\tR\u0011\u0010\u0004\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b\n\u0010\u000b¨\u0006\u0011"}, d2 = {"Landroidx/compose/foundation/pager/PagerWrapperFlingBehavior;", "Landroidx/compose/foundation/gestures/FlingBehavior;", "originalFlingBehavior", "Landroidx/compose/foundation/gestures/TargetedFlingBehavior;", "pagerState", "Landroidx/compose/foundation/pager/PagerState;", "<init>", "(Landroidx/compose/foundation/gestures/TargetedFlingBehavior;Landroidx/compose/foundation/pager/PagerState;)V", "getOriginalFlingBehavior", "()Landroidx/compose/foundation/gestures/TargetedFlingBehavior;", "getPagerState", "()Landroidx/compose/foundation/pager/PagerState;", "performFling", "", "Landroidx/compose/foundation/gestures/ScrollScope;", "initialVelocity", "(Landroidx/compose/foundation/gestures/ScrollScope;FLkotlin/coroutines/Continuation;)Ljava/lang/Object;", "foundation"}, k = 1, mv = {2, 1, 0}, xi = 48)
final class PagerWrapperFlingBehavior implements FlingBehavior {
    private final TargetedFlingBehavior originalFlingBehavior;
    private final PagerState pagerState;

    /* JADX INFO: renamed from: androidx.compose.foundation.pager.PagerWrapperFlingBehavior$performFling$1, reason: invalid class name */
    /* JADX INFO: compiled from: LazyLayoutPager.kt */
    @Metadata(k = 3, mv = {2, 1, 0}, xi = 48)
    @DebugMetadata(c = "androidx.compose.foundation.pager.PagerWrapperFlingBehavior", f = "LazyLayoutPager.kt", i = {}, l = {488}, m = "performFling", n = {}, s = {}, v = 1)
    static final class AnonymousClass1 extends ContinuationImpl {
        int label;
        /* synthetic */ Object result;

        AnonymousClass1(Continuation<? super AnonymousClass1> continuation) {
            super(continuation);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object obj) {
            this.result = obj;
            this.label |= Integer.MIN_VALUE;
            return PagerWrapperFlingBehavior.this.performFling(null, 0.0f, this);
        }
    }

    public PagerWrapperFlingBehavior(TargetedFlingBehavior targetedFlingBehavior, PagerState pagerState) {
        this.originalFlingBehavior = targetedFlingBehavior;
        this.pagerState = pagerState;
    }

    public final TargetedFlingBehavior getOriginalFlingBehavior() {
        return this.originalFlingBehavior;
    }

    public final PagerState getPagerState() {
        return this.pagerState;
    }

    /* JADX WARN: Removed duplicated region for block: B:7:0x0014  */
    @Override // androidx.compose.foundation.gestures.FlingBehavior
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public java.lang.Object performFling(final androidx.compose.foundation.gestures.ScrollScope r5, float r6, kotlin.coroutines.Continuation<? super java.lang.Float> r7) {
        /*
            r4 = this;
            boolean r0 = r7 instanceof androidx.compose.foundation.pager.PagerWrapperFlingBehavior.AnonymousClass1
            if (r0 == 0) goto L14
            r0 = r7
            androidx.compose.foundation.pager.PagerWrapperFlingBehavior$performFling$1 r0 = (androidx.compose.foundation.pager.PagerWrapperFlingBehavior.AnonymousClass1) r0
            int r1 = r0.label
            r2 = -2147483648(0xffffffff80000000, float:-0.0)
            r1 = r1 & r2
            if (r1 == 0) goto L14
            int r7 = r0.label
            int r7 = r7 - r2
            r0.label = r7
            goto L19
        L14:
            androidx.compose.foundation.pager.PagerWrapperFlingBehavior$performFling$1 r0 = new androidx.compose.foundation.pager.PagerWrapperFlingBehavior$performFling$1
            r0.<init>(r7)
        L19:
            java.lang.Object r7 = r0.result
            java.lang.Object r1 = kotlin.coroutines.intrinsics.IntrinsicsKt.getCOROUTINE_SUSPENDED()
            int r2 = r0.label
            r3 = 1
            if (r2 == 0) goto L32
            if (r2 != r3) goto L2a
            kotlin.ResultKt.throwOnFailure(r7)
            goto L45
        L2a:
            java.lang.IllegalStateException r5 = new java.lang.IllegalStateException
            java.lang.String r6 = "call to 'resume' before 'invoke' with coroutine"
            r5.<init>(r6)
            throw r5
        L32:
            kotlin.ResultKt.throwOnFailure(r7)
            androidx.compose.foundation.gestures.TargetedFlingBehavior r7 = r4.originalFlingBehavior
            androidx.compose.foundation.pager.PagerWrapperFlingBehavior$$ExternalSyntheticLambda0 r2 = new androidx.compose.foundation.pager.PagerWrapperFlingBehavior$$ExternalSyntheticLambda0
            r2.<init>()
            r0.label = r3
            java.lang.Object r7 = r7.performFling(r5, r6, r2, r0)
            if (r7 != r1) goto L45
            return r1
        L45:
            java.lang.Number r7 = (java.lang.Number) r7
            float r5 = r7.floatValue()
            androidx.compose.foundation.pager.PagerState r6 = r4.pagerState
            float r6 = r6.getCurrentPageOffsetFraction()
            r7 = 0
            int r6 = (r6 > r7 ? 1 : (r6 == r7 ? 0 : -1))
            if (r6 != 0) goto L57
            goto L77
        L57:
            androidx.compose.foundation.pager.PagerState r6 = r4.pagerState
            float r6 = r6.getCurrentPageOffsetFraction()
            float r6 = java.lang.Math.abs(r6)
            double r0 = (double) r6
            r2 = 4562254508917369340(0x3f50624dd2f1a9fc, double:0.001)
            int r6 = (r0 > r2 ? 1 : (r0 == r2 ? 0 : -1))
            if (r6 >= 0) goto L77
            androidx.compose.foundation.pager.PagerState r6 = r4.pagerState
            int r0 = r6.getCurrentPage()
            r1 = 2
            r2 = 0
            androidx.compose.foundation.pager.PagerState.requestScrollToPage$default(r6, r0, r7, r1, r2)
            goto L80
        L77:
            androidx.compose.foundation.pager.PagerState r6 = r4.pagerState
            float r6 = r6.getCurrentPageOffsetFraction()
            kotlin.coroutines.jvm.internal.Boxing.boxFloat(r6)
        L80:
            java.lang.Float r5 = kotlin.coroutines.jvm.internal.Boxing.boxFloat(r5)
            return r5
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.compose.foundation.pager.PagerWrapperFlingBehavior.performFling(androidx.compose.foundation.gestures.ScrollScope, float, kotlin.coroutines.Continuation):java.lang.Object");
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit performFling$lambda$0$0(PagerWrapperFlingBehavior pagerWrapperFlingBehavior, ScrollScope scrollScope, float f2) {
        pagerWrapperFlingBehavior.pagerState.updateTargetPage(scrollScope, MathKt.roundToInt(pagerWrapperFlingBehavior.pagerState.getPageSizeWithSpacing$foundation() != 0 ? f2 / pagerWrapperFlingBehavior.pagerState.getPageSizeWithSpacing$foundation() : 0.0f) + pagerWrapperFlingBehavior.pagerState.getCurrentPage());
        return Unit.INSTANCE;
    }
}
