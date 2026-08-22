package androidx.compose.ui.scrollcapture;

import com.clevertap.android.sdk.Constants;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.ContinuationImpl;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.jvm.functions.Function2;
import kotlin.math.MathKt;
import kotlin.ranges.RangesKt;

/* JADX INFO: compiled from: ComposeScrollCaptureCallback.android.kt */
/* JADX INFO: loaded from: classes3.dex */
@Metadata(d1 = {"\u0000(\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u0007\n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0010\u0002\n\u0002\b\n\b\u0002\u0018\u00002\u00020\u0001B3\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\"\u0010\u0004\u001a\u001e\b\u0001\u0012\u0004\u0012\u00020\u0006\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00060\u0007\u0012\u0006\u0012\u0004\u0018\u00010\u00010\u0005¢\u0006\u0004\b\b\u0010\tJ\u0006\u0010\u000f\u001a\u00020\u0010J\u001e\u0010\u0011\u001a\u00020\u00102\u0006\u0010\u0012\u001a\u00020\u00032\u0006\u0010\u0013\u001a\u00020\u0003H\u0086@¢\u0006\u0002\u0010\u0014J\u000e\u0010\u0015\u001a\u00020\u00032\u0006\u0010\u0016\u001a\u00020\u0003J\u0016\u0010\u0017\u001a\u00020\u00102\u0006\u0010\u0016\u001a\u00020\u0006H\u0086@¢\u0006\u0002\u0010\u0018J\u0016\u0010\u0004\u001a\u00020\u00102\u0006\u0010\u0019\u001a\u00020\u0006H\u0082@¢\u0006\u0002\u0010\u0018R\u000e\u0010\u0002\u001a\u00020\u0003X\u0082\u0004¢\u0006\u0002\n\u0000R,\u0010\u0004\u001a\u001e\b\u0001\u0012\u0004\u0012\u00020\u0006\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00060\u0007\u0012\u0006\u0012\u0004\u0018\u00010\u00010\u0005X\u0082\u0004¢\u0006\u0004\n\u0002\u0010\nR\u001e\u0010\f\u001a\u00020\u00062\u0006\u0010\u000b\u001a\u00020\u0006@BX\u0086\u000e¢\u0006\b\n\u0000\u001a\u0004\b\r\u0010\u000e¨\u0006\u001a"}, d2 = {"Landroidx/compose/ui/scrollcapture/RelativeScroller;", "", "viewportSize", "", "scrollBy", "Lkotlin/Function2;", "", "Lkotlin/coroutines/Continuation;", "<init>", "(ILkotlin/jvm/functions/Function2;)V", "Lkotlin/jvm/functions/Function2;", "value", "scrollAmount", "getScrollAmount", "()F", "reset", "", "scrollRangeToCenter", "min", Constants.PRIORITY_MAX, "(IILkotlin/coroutines/Continuation;)Ljava/lang/Object;", "mapOffsetToViewport", "offset", "scrollTo", "(FLkotlin/coroutines/Continuation;)Ljava/lang/Object;", "delta", "ui"}, k = 1, mv = {2, 1, 0}, xi = 48)
final class RelativeScroller {
    private float scrollAmount;
    private final Function2<Float, Continuation<? super Float>, Object> scrollBy;
    private final int viewportSize;

    /* JADX INFO: renamed from: androidx.compose.ui.scrollcapture.RelativeScroller$scrollBy$1, reason: invalid class name */
    /* JADX INFO: compiled from: ComposeScrollCaptureCallback.android.kt */
    @Metadata(k = 3, mv = {2, 1, 0}, xi = 48)
    @DebugMetadata(c = "androidx.compose.ui.scrollcapture.RelativeScroller", f = "ComposeScrollCaptureCallback.android.kt", i = {}, l = {296}, m = "scrollBy", n = {}, s = {}, v = 1)
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
            return RelativeScroller.this.scrollBy(0.0f, this);
        }
    }

    /* JADX WARN: Multi-variable type inference failed */
    public RelativeScroller(int i, Function2<? super Float, ? super Continuation<? super Float>, ? extends Object> function2) {
        this.viewportSize = i;
        this.scrollBy = function2;
    }

    public final float getScrollAmount() {
        return this.scrollAmount;
    }

    public final void reset() {
        this.scrollAmount = 0.0f;
    }

    public final Object scrollRangeToCenter(int i, int i2, Continuation<? super Unit> continuation) {
        if (i > i2) {
            throw new IllegalArgumentException(("Expected min=" + i + " ≤ max=" + i2).toString());
        }
        int i3 = i2 - i;
        int i4 = this.viewportSize;
        if (i3 > i4) {
            throw new IllegalArgumentException(("Expected range (" + i3 + ") to be ≤ viewportSize=" + this.viewportSize).toString());
        }
        float f2 = i;
        float f3 = this.scrollAmount;
        if (f2 >= f3 && i2 <= f3 + i4) {
            return Unit.INSTANCE;
        }
        Object objScrollTo = scrollTo((i + (i3 / 2)) - (i4 / 2), continuation);
        return objScrollTo == IntrinsicsKt.getCOROUTINE_SUSPENDED() ? objScrollTo : Unit.INSTANCE;
    }

    public final int mapOffsetToViewport(int offset) {
        return RangesKt.coerceIn(offset - MathKt.roundToInt(this.scrollAmount), 0, this.viewportSize);
    }

    public final Object scrollTo(float f2, Continuation<? super Unit> continuation) {
        Object objScrollBy = scrollBy(f2 - this.scrollAmount, continuation);
        return objScrollBy == IntrinsicsKt.getCOROUTINE_SUSPENDED() ? objScrollBy : Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Removed duplicated region for block: B:7:0x0014  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final java.lang.Object scrollBy(float r5, kotlin.coroutines.Continuation<? super kotlin.Unit> r6) {
        /*
            r4 = this;
            boolean r0 = r6 instanceof androidx.compose.ui.scrollcapture.RelativeScroller.AnonymousClass1
            if (r0 == 0) goto L14
            r0 = r6
            androidx.compose.ui.scrollcapture.RelativeScroller$scrollBy$1 r0 = (androidx.compose.ui.scrollcapture.RelativeScroller.AnonymousClass1) r0
            int r1 = r0.label
            r2 = -2147483648(0xffffffff80000000, float:-0.0)
            r1 = r1 & r2
            if (r1 == 0) goto L14
            int r6 = r0.label
            int r6 = r6 - r2
            r0.label = r6
            goto L19
        L14:
            androidx.compose.ui.scrollcapture.RelativeScroller$scrollBy$1 r0 = new androidx.compose.ui.scrollcapture.RelativeScroller$scrollBy$1
            r0.<init>(r6)
        L19:
            java.lang.Object r6 = r0.result
            java.lang.Object r1 = kotlin.coroutines.intrinsics.IntrinsicsKt.getCOROUTINE_SUSPENDED()
            int r2 = r0.label
            r3 = 1
            if (r2 == 0) goto L32
            if (r2 != r3) goto L2a
            kotlin.ResultKt.throwOnFailure(r6)
            goto L44
        L2a:
            java.lang.IllegalStateException r5 = new java.lang.IllegalStateException
            java.lang.String r6 = "call to 'resume' before 'invoke' with coroutine"
            r5.<init>(r6)
            throw r5
        L32:
            kotlin.ResultKt.throwOnFailure(r6)
            kotlin.jvm.functions.Function2<java.lang.Float, kotlin.coroutines.Continuation<? super java.lang.Float>, java.lang.Object> r6 = r4.scrollBy
            java.lang.Float r5 = kotlin.coroutines.jvm.internal.Boxing.boxFloat(r5)
            r0.label = r3
            java.lang.Object r6 = r6.invoke(r5, r0)
            if (r6 != r1) goto L44
            return r1
        L44:
            java.lang.Number r6 = (java.lang.Number) r6
            float r5 = r6.floatValue()
            float r6 = r4.scrollAmount
            float r6 = r6 + r5
            r4.scrollAmount = r6
            kotlin.Unit r5 = kotlin.Unit.INSTANCE
            return r5
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.compose.ui.scrollcapture.RelativeScroller.scrollBy(float, kotlin.coroutines.Continuation):java.lang.Object");
    }
}
