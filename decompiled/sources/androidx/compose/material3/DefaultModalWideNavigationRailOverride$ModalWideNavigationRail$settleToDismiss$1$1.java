package androidx.compose.material3;

import kotlin.Metadata;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function2;

/* JADX INFO: compiled from: WideNavigationRail.kt */
/* JADX INFO: loaded from: classes.dex */
@Metadata(d1 = {"\u0000\f\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u0007\u0010\u0000\u001a\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u0003H\n"}, d2 = {"<anonymous>", "", "it", ""}, k = 3, mv = {2, 0, 0}, xi = 48)
@DebugMetadata(c = "androidx.compose.material3.DefaultModalWideNavigationRailOverride$ModalWideNavigationRail$settleToDismiss$1$1", f = "WideNavigationRail.kt", i = {}, l = {538, 539}, m = "invokeSuspend", n = {}, s = {})
final class DefaultModalWideNavigationRailOverride$ModalWideNavigationRail$settleToDismiss$1$1 extends SuspendLambda implements Function2<Float, Continuation<? super Unit>, Object> {
    final /* synthetic */ ModalWideNavigationRailState $modalState;
    final /* synthetic */ ModalWideNavigationRailOverrideScope $this_ModalWideNavigationRail;
    /* synthetic */ float F$0;
    int label;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    DefaultModalWideNavigationRailOverride$ModalWideNavigationRail$settleToDismiss$1$1(ModalWideNavigationRailOverrideScope modalWideNavigationRailOverrideScope, ModalWideNavigationRailState modalWideNavigationRailState, Continuation<? super DefaultModalWideNavigationRailOverride$ModalWideNavigationRail$settleToDismiss$1$1> continuation) {
        super(2, continuation);
        this.$this_ModalWideNavigationRail = modalWideNavigationRailOverrideScope;
        this.$modalState = modalWideNavigationRailState;
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
        DefaultModalWideNavigationRailOverride$ModalWideNavigationRail$settleToDismiss$1$1 defaultModalWideNavigationRailOverride$ModalWideNavigationRail$settleToDismiss$1$1 = new DefaultModalWideNavigationRailOverride$ModalWideNavigationRail$settleToDismiss$1$1(this.$this_ModalWideNavigationRail, this.$modalState, continuation);
        defaultModalWideNavigationRailOverride$ModalWideNavigationRail$settleToDismiss$1$1.F$0 = ((Number) obj).floatValue();
        return defaultModalWideNavigationRailOverride$ModalWideNavigationRail$settleToDismiss$1$1;
    }

    public final Object invoke(float f2, Continuation<? super Unit> continuation) {
        return ((DefaultModalWideNavigationRailOverride$ModalWideNavigationRail$settleToDismiss$1$1) create(Float.valueOf(f2), continuation)).invokeSuspend(Unit.INSTANCE);
    }

    @Override // kotlin.jvm.functions.Function2
    public /* bridge */ /* synthetic */ Object invoke(Float f2, Continuation<? super Unit> continuation) {
        return invoke(f2.floatValue(), continuation);
    }

    /* JADX WARN: Code restructure failed: missing block: B:18:0x0054, code lost:
    
        if (r5.$this_ModalWideNavigationRail.getState().collapse(r5) == r0) goto L19;
     */
    /* JADX WARN: Removed duplicated region for block: B:17:0x0045  */
    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final java.lang.Object invokeSuspend(java.lang.Object r6) {
        /*
            r5 = this;
            java.lang.Object r0 = kotlin.coroutines.intrinsics.IntrinsicsKt.getCOROUTINE_SUSPENDED()
            int r1 = r5.label
            r2 = 2
            r3 = 1
            if (r1 == 0) goto L1e
            if (r1 == r3) goto L1a
            if (r1 != r2) goto L12
            kotlin.ResultKt.throwOnFailure(r6)
            goto L57
        L12:
            java.lang.IllegalStateException r6 = new java.lang.IllegalStateException
            java.lang.String r0 = "call to 'resume' before 'invoke' with coroutine"
            r6.<init>(r0)
            throw r6
        L1a:
            kotlin.ResultKt.throwOnFailure(r6)
            goto L39
        L1e:
            kotlin.ResultKt.throwOnFailure(r6)
            float r6 = r5.F$0
            androidx.compose.material3.ModalWideNavigationRailOverrideScope r1 = r5.$this_ModalWideNavigationRail
            boolean r1 = r1.getShouldHideOnCollapse()
            if (r1 == 0) goto L57
            androidx.compose.material3.ModalWideNavigationRailState r1 = r5.$modalState
            r4 = r5
            kotlin.coroutines.Continuation r4 = (kotlin.coroutines.Continuation) r4
            r5.label = r3
            java.lang.Object r6 = r1.settle$material3(r6, r4)
            if (r6 != r0) goto L39
            goto L56
        L39:
            androidx.compose.material3.ModalWideNavigationRailState r6 = r5.$modalState
            androidx.compose.material3.WideNavigationRailValue r6 = r6.getTargetValue()
            boolean r6 = androidx.compose.material3.WideNavigationRailStateKt.isExpanded(r6)
            if (r6 != 0) goto L57
            androidx.compose.material3.ModalWideNavigationRailOverrideScope r6 = r5.$this_ModalWideNavigationRail
            androidx.compose.material3.WideNavigationRailState r6 = r6.getState()
            r1 = r5
            kotlin.coroutines.Continuation r1 = (kotlin.coroutines.Continuation) r1
            r5.label = r2
            java.lang.Object r6 = r6.collapse(r1)
            if (r6 != r0) goto L57
        L56:
            return r0
        L57:
            kotlin.Unit r6 = kotlin.Unit.INSTANCE
            return r6
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.compose.material3.DefaultModalWideNavigationRailOverride$ModalWideNavigationRail$settleToDismiss$1$1.invokeSuspend(java.lang.Object):java.lang.Object");
    }
}
