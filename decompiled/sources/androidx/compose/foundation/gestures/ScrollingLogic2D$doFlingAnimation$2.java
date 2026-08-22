package androidx.compose.foundation.gestures;

import androidx.compose.ui.geometry.Offset;
import androidx.compose.ui.input.nestedscroll.NestedScrollSource;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Ref;

/* JADX INFO: compiled from: Scrollable2D.kt */
/* JADX INFO: loaded from: classes.dex */
@Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\n"}, d2 = {"<anonymous>", "", "Landroidx/compose/foundation/gestures/NestedScrollScope;"}, k = 3, mv = {2, 1, 0}, xi = 48)
@DebugMetadata(c = "androidx.compose.foundation.gestures.ScrollingLogic2D$doFlingAnimation$2", f = "Scrollable2D.kt", i = {}, l = {461}, m = "invokeSuspend", n = {}, s = {}, v = 1)
final class ScrollingLogic2D$doFlingAnimation$2 extends SuspendLambda implements Function2<NestedScrollScope, Continuation<? super Unit>, Object> {
    final /* synthetic */ long $available;
    final /* synthetic */ Ref.LongRef $result;
    long J$0;
    private /* synthetic */ Object L$0;
    int label;
    final /* synthetic */ ScrollingLogic2D this$0;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    ScrollingLogic2D$doFlingAnimation$2(ScrollingLogic2D scrollingLogic2D, long j, Ref.LongRef longRef, Continuation<? super ScrollingLogic2D$doFlingAnimation$2> continuation) {
        super(2, continuation);
        this.this$0 = scrollingLogic2D;
        this.$available = j;
        this.$result = longRef;
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
        ScrollingLogic2D$doFlingAnimation$2 scrollingLogic2D$doFlingAnimation$2 = new ScrollingLogic2D$doFlingAnimation$2(this.this$0, this.$available, this.$result, continuation);
        scrollingLogic2D$doFlingAnimation$2.L$0 = obj;
        return scrollingLogic2D$doFlingAnimation$2;
    }

    @Override // kotlin.jvm.functions.Function2
    public final Object invoke(NestedScrollScope nestedScrollScope, Continuation<? super Unit> continuation) {
        return ((ScrollingLogic2D$doFlingAnimation$2) create(nestedScrollScope, continuation)).invokeSuspend(Unit.INSTANCE);
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object invokeSuspend(Object obj) {
        long j;
        Ref.LongRef longRef;
        Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int i = this.label;
        if (i == 0) {
            ResultKt.throwOnFailure(obj);
            final NestedScrollScope nestedScrollScope = (NestedScrollScope) this.L$0;
            final ScrollingLogic2D scrollingLogic2D = this.this$0;
            final long j2 = this.$available;
            ScrollScope scrollScope = new ScrollScope() { // from class: androidx.compose.foundation.gestures.ScrollingLogic2D$doFlingAnimation$2$flingScope$1
                @Override // androidx.compose.foundation.gestures.ScrollScope
                public float scrollBy(float pixels) {
                    long jDoFlingAnimation_QWom1Mo$toDecomposedOffset = ScrollingLogic2D.doFlingAnimation_QWom1Mo$toDecomposedOffset(pixels, j2);
                    if (Offset.m5720equalsimpl0(jDoFlingAnimation_QWom1Mo$toDecomposedOffset, Offset.INSTANCE.m5739getZeroF1C5BW0()) || ((Boolean) scrollingLogic2D.isScrollableNodeAttached.invoke()).booleanValue()) {
                        return ScrollingLogic2D.doFlingAnimation_QWom1Mo$toMagnitudeFloat(nestedScrollScope.mo633scrollByWithOverscrollOzD1aCk(jDoFlingAnimation_QWom1Mo$toDecomposedOffset, NestedScrollSource.INSTANCE.m7180getSideEffectWNlRxjI()));
                    }
                    throw new FlingCancellationException();
                }
            };
            ScrollingLogic2D scrollingLogic2D2 = this.this$0;
            long j3 = this.$available;
            Ref.LongRef longRef2 = this.$result;
            float fM669getMagnitudeTH1AsA0 = Scrollable2DKt.m669getMagnitudeTH1AsA0(j3);
            this.L$0 = longRef2;
            this.J$0 = j3;
            this.label = 1;
            obj = scrollingLogic2D2.flingBehavior.performFling(scrollScope, fM669getMagnitudeTH1AsA0, this);
            if (obj == coroutine_suspended) {
                return coroutine_suspended;
            }
            j = j3;
            longRef = longRef2;
        } else {
            if (i != 1) {
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
            }
            j = this.J$0;
            longRef = (Ref.LongRef) this.L$0;
            ResultKt.throwOnFailure(obj);
        }
        longRef.element = ScrollingLogic2D.doFlingAnimation_QWom1Mo$toDecomposedVelocity(((Number) obj).floatValue(), j);
        return Unit.INSTANCE;
    }
}
