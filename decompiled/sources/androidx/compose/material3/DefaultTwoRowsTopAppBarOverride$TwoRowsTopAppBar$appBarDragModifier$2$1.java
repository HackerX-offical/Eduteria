package androidx.compose.material3;

import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function3;
import kotlinx.coroutines.CoroutineScope;

/* JADX INFO: compiled from: AppBar.kt */
/* JADX INFO: loaded from: classes.dex */
@Metadata(d1 = {"\u0000\u0010\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0007\u0010\u0000\u001a\u00020\u0001*\u00020\u00022\u0006\u0010\u0003\u001a\u00020\u0004H\n"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;", "velocity", ""}, k = 3, mv = {2, 0, 0}, xi = 48)
@DebugMetadata(c = "androidx.compose.material3.DefaultTwoRowsTopAppBarOverride$TwoRowsTopAppBar$appBarDragModifier$2$1", f = "AppBar.kt", i = {}, l = {2782}, m = "invokeSuspend", n = {}, s = {})
final class DefaultTwoRowsTopAppBarOverride$TwoRowsTopAppBar$appBarDragModifier$2$1 extends SuspendLambda implements Function3<CoroutineScope, Float, Continuation<? super Unit>, Object> {
    final /* synthetic */ TwoRowsTopAppBarOverrideScope $this_TwoRowsTopAppBar;
    /* synthetic */ float F$0;
    int label;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    DefaultTwoRowsTopAppBarOverride$TwoRowsTopAppBar$appBarDragModifier$2$1(TwoRowsTopAppBarOverrideScope twoRowsTopAppBarOverrideScope, Continuation<? super DefaultTwoRowsTopAppBarOverride$TwoRowsTopAppBar$appBarDragModifier$2$1> continuation) {
        super(3, continuation);
        this.$this_TwoRowsTopAppBar = twoRowsTopAppBarOverrideScope;
    }

    @Override // kotlin.jvm.functions.Function3
    public /* bridge */ /* synthetic */ Object invoke(CoroutineScope coroutineScope, Float f2, Continuation<? super Unit> continuation) {
        return invoke(coroutineScope, f2.floatValue(), continuation);
    }

    public final Object invoke(CoroutineScope coroutineScope, float f2, Continuation<? super Unit> continuation) {
        DefaultTwoRowsTopAppBarOverride$TwoRowsTopAppBar$appBarDragModifier$2$1 defaultTwoRowsTopAppBarOverride$TwoRowsTopAppBar$appBarDragModifier$2$1 = new DefaultTwoRowsTopAppBarOverride$TwoRowsTopAppBar$appBarDragModifier$2$1(this.$this_TwoRowsTopAppBar, continuation);
        defaultTwoRowsTopAppBarOverride$TwoRowsTopAppBar$appBarDragModifier$2$1.F$0 = f2;
        return defaultTwoRowsTopAppBarOverride$TwoRowsTopAppBar$appBarDragModifier$2$1.invokeSuspend(Unit.INSTANCE);
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object invokeSuspend(Object obj) {
        Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int i = this.label;
        if (i == 0) {
            ResultKt.throwOnFailure(obj);
            float f2 = this.F$0;
            this.label = 1;
            if (AppBarKt.settleAppBar(this.$this_TwoRowsTopAppBar.getScrollBehavior().getState(), f2, this.$this_TwoRowsTopAppBar.getScrollBehavior().getFlingAnimationSpec(), this.$this_TwoRowsTopAppBar.getScrollBehavior().getSnapAnimationSpec(), this) == coroutine_suspended) {
                return coroutine_suspended;
            }
        } else {
            if (i != 1) {
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
            }
            ResultKt.throwOnFailure(obj);
        }
        return Unit.INSTANCE;
    }
}
