package androidx.compose.material3;

import kotlin.Metadata;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function1;

/* JADX INFO: compiled from: WideNavigationRail.kt */
/* JADX INFO: loaded from: classes.dex */
@Metadata(d1 = {"\u0000\u0006\n\u0000\n\u0002\u0010\u0002\u0010\u0000\u001a\u00020\u0001H\n"}, d2 = {"<anonymous>", ""}, k = 3, mv = {2, 0, 0}, xi = 48)
@DebugMetadata(c = "androidx.compose.material3.DefaultModalWideNavigationRailOverride$ModalWideNavigationRail$animateToDismiss$1$1", f = "WideNavigationRail.kt", i = {}, l = {531, 533}, m = "invokeSuspend", n = {}, s = {})
final class DefaultModalWideNavigationRailOverride$ModalWideNavigationRail$animateToDismiss$1$1 extends SuspendLambda implements Function1<Continuation<? super Unit>, Object> {
    final /* synthetic */ ModalWideNavigationRailState $modalState;
    final /* synthetic */ ModalWideNavigationRailOverrideScope $this_ModalWideNavigationRail;
    int label;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    DefaultModalWideNavigationRailOverride$ModalWideNavigationRail$animateToDismiss$1$1(ModalWideNavigationRailOverrideScope modalWideNavigationRailOverrideScope, ModalWideNavigationRailState modalWideNavigationRailState, Continuation<? super DefaultModalWideNavigationRailOverride$ModalWideNavigationRail$animateToDismiss$1$1> continuation) {
        super(1, continuation);
        this.$this_ModalWideNavigationRail = modalWideNavigationRailOverrideScope;
        this.$modalState = modalWideNavigationRailState;
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Continuation<Unit> create(Continuation<?> continuation) {
        return new DefaultModalWideNavigationRailOverride$ModalWideNavigationRail$animateToDismiss$1$1(this.$this_ModalWideNavigationRail, this.$modalState, continuation);
    }

    @Override // kotlin.jvm.functions.Function1
    public final Object invoke(Continuation<? super Unit> continuation) {
        return ((DefaultModalWideNavigationRailOverride$ModalWideNavigationRail$animateToDismiss$1$1) create(continuation)).invokeSuspend(Unit.INSTANCE);
    }

    /* JADX WARN: Code restructure failed: missing block: B:16:0x0046, code lost:
    
        if (r4.$this_ModalWideNavigationRail.getState().collapse(r4) == r0) goto L17;
     */
    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final java.lang.Object invokeSuspend(java.lang.Object r5) {
        /*
            r4 = this;
            java.lang.Object r0 = kotlin.coroutines.intrinsics.IntrinsicsKt.getCOROUTINE_SUSPENDED()
            int r1 = r4.label
            r2 = 2
            r3 = 1
            if (r1 == 0) goto L1e
            if (r1 == r3) goto L1a
            if (r1 != r2) goto L12
            kotlin.ResultKt.throwOnFailure(r5)
            goto L49
        L12:
            java.lang.IllegalStateException r5 = new java.lang.IllegalStateException
            java.lang.String r0 = "call to 'resume' before 'invoke' with coroutine"
            r5.<init>(r0)
            throw r5
        L1a:
            kotlin.ResultKt.throwOnFailure(r5)
            goto L37
        L1e:
            kotlin.ResultKt.throwOnFailure(r5)
            androidx.compose.material3.ModalWideNavigationRailOverrideScope r5 = r4.$this_ModalWideNavigationRail
            boolean r5 = r5.getShouldHideOnCollapse()
            if (r5 == 0) goto L37
            androidx.compose.material3.ModalWideNavigationRailState r5 = r4.$modalState
            r1 = r4
            kotlin.coroutines.Continuation r1 = (kotlin.coroutines.Continuation) r1
            r4.label = r3
            java.lang.Object r5 = r5.collapse(r1)
            if (r5 != r0) goto L37
            goto L48
        L37:
            androidx.compose.material3.ModalWideNavigationRailOverrideScope r5 = r4.$this_ModalWideNavigationRail
            androidx.compose.material3.WideNavigationRailState r5 = r5.getState()
            r1 = r4
            kotlin.coroutines.Continuation r1 = (kotlin.coroutines.Continuation) r1
            r4.label = r2
            java.lang.Object r5 = r5.collapse(r1)
            if (r5 != r0) goto L49
        L48:
            return r0
        L49:
            kotlin.Unit r5 = kotlin.Unit.INSTANCE
            return r5
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.compose.material3.DefaultModalWideNavigationRailOverride$ModalWideNavigationRail$animateToDismiss$1$1.invokeSuspend(java.lang.Object):java.lang.Object");
    }
}
