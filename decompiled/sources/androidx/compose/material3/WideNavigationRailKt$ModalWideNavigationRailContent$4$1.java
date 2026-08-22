package androidx.compose.material3;

import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.Boxing;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.functions.Function3;
import kotlinx.coroutines.CoroutineScope;

/* JADX INFO: compiled from: WideNavigationRail.kt */
/* JADX INFO: loaded from: classes.dex */
@Metadata(d1 = {"\u0000\u0010\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0007\u0010\u0000\u001a\u00020\u0001*\u00020\u00022\u0006\u0010\u0003\u001a\u00020\u0004H\n"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;", "it", ""}, k = 3, mv = {2, 0, 0}, xi = 48)
@DebugMetadata(c = "androidx.compose.material3.WideNavigationRailKt$ModalWideNavigationRailContent$4$1", f = "WideNavigationRail.kt", i = {}, l = {1042}, m = "invokeSuspend", n = {}, s = {})
final class WideNavigationRailKt$ModalWideNavigationRailContent$4$1 extends SuspendLambda implements Function3<CoroutineScope, Float, Continuation<? super Unit>, Object> {
    final /* synthetic */ Function2<Float, Continuation<? super Unit>, Object> $settleToDismiss;
    /* synthetic */ float F$0;
    int label;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    /* JADX WARN: Multi-variable type inference failed */
    WideNavigationRailKt$ModalWideNavigationRailContent$4$1(Function2<? super Float, ? super Continuation<? super Unit>, ? extends Object> function2, Continuation<? super WideNavigationRailKt$ModalWideNavigationRailContent$4$1> continuation) {
        super(3, continuation);
        this.$settleToDismiss = function2;
    }

    @Override // kotlin.jvm.functions.Function3
    public /* bridge */ /* synthetic */ Object invoke(CoroutineScope coroutineScope, Float f2, Continuation<? super Unit> continuation) {
        return invoke(coroutineScope, f2.floatValue(), continuation);
    }

    public final Object invoke(CoroutineScope coroutineScope, float f2, Continuation<? super Unit> continuation) {
        WideNavigationRailKt$ModalWideNavigationRailContent$4$1 wideNavigationRailKt$ModalWideNavigationRailContent$4$1 = new WideNavigationRailKt$ModalWideNavigationRailContent$4$1(this.$settleToDismiss, continuation);
        wideNavigationRailKt$ModalWideNavigationRailContent$4$1.F$0 = f2;
        return wideNavigationRailKt$ModalWideNavigationRailContent$4$1.invokeSuspend(Unit.INSTANCE);
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object invokeSuspend(Object obj) {
        Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int i = this.label;
        if (i == 0) {
            ResultKt.throwOnFailure(obj);
            float f2 = this.F$0;
            Function2<Float, Continuation<? super Unit>, Object> function2 = this.$settleToDismiss;
            Float fBoxFloat = Boxing.boxFloat(f2);
            this.label = 1;
            if (function2.invoke(fBoxFloat, this) == coroutine_suspended) {
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
