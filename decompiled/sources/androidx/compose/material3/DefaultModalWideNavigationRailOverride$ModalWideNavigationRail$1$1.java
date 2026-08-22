package androidx.compose.material3;

import com.google.android.vending.licensing.Policy;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function2;
import kotlinx.coroutines.CoroutineScope;
import kotlinx.coroutines.channels.Channel;

/* JADX INFO: compiled from: WideNavigationRail.kt */
/* JADX INFO: loaded from: classes.dex */
@Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\n"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {2, 0, 0}, xi = 48)
@DebugMetadata(c = "androidx.compose.material3.DefaultModalWideNavigationRailOverride$ModalWideNavigationRail$1$1", f = "WideNavigationRail.kt", i = {0}, l = {Policy.NOT_LICENSED}, m = "invokeSuspend", n = {"$this$LaunchedEffect"}, s = {"L$0"})
final class DefaultModalWideNavigationRailOverride$ModalWideNavigationRail$1$1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
    final /* synthetic */ Channel<Boolean> $channel;
    final /* synthetic */ ModalWideNavigationRailState $modalState;
    private /* synthetic */ Object L$0;
    Object L$1;
    int label;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    DefaultModalWideNavigationRailOverride$ModalWideNavigationRail$1$1(Channel<Boolean> channel, ModalWideNavigationRailState modalWideNavigationRailState, Continuation<? super DefaultModalWideNavigationRailOverride$ModalWideNavigationRail$1$1> continuation) {
        super(2, continuation);
        this.$channel = channel;
        this.$modalState = modalWideNavigationRailState;
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
        DefaultModalWideNavigationRailOverride$ModalWideNavigationRail$1$1 defaultModalWideNavigationRailOverride$ModalWideNavigationRail$1$1 = new DefaultModalWideNavigationRailOverride$ModalWideNavigationRail$1$1(this.$channel, this.$modalState, continuation);
        defaultModalWideNavigationRailOverride$ModalWideNavigationRail$1$1.L$0 = obj;
        return defaultModalWideNavigationRailOverride$ModalWideNavigationRail$1$1;
    }

    @Override // kotlin.jvm.functions.Function2
    public final Object invoke(CoroutineScope coroutineScope, Continuation<? super Unit> continuation) {
        return ((DefaultModalWideNavigationRailOverride$ModalWideNavigationRail$1$1) create(coroutineScope, continuation)).invokeSuspend(Unit.INSTANCE);
    }

    /* JADX WARN: Removed duplicated region for block: B:11:0x003c A[RETURN] */
    /* JADX WARN: Removed duplicated region for block: B:14:0x0045  */
    /* JADX WARN: Removed duplicated region for block: B:18:0x0074  */
    /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:10:0x003a -> B:12:0x003d). Please report as a decompilation issue!!! */
    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final java.lang.Object invokeSuspend(java.lang.Object r10) {
        /*
            r9 = this;
            java.lang.Object r0 = kotlin.coroutines.intrinsics.IntrinsicsKt.getCOROUTINE_SUSPENDED()
            int r1 = r9.label
            r2 = 1
            if (r1 == 0) goto L1f
            if (r1 != r2) goto L17
            java.lang.Object r1 = r9.L$1
            kotlinx.coroutines.channels.ChannelIterator r1 = (kotlinx.coroutines.channels.ChannelIterator) r1
            java.lang.Object r3 = r9.L$0
            kotlinx.coroutines.CoroutineScope r3 = (kotlinx.coroutines.CoroutineScope) r3
            kotlin.ResultKt.throwOnFailure(r10)
            goto L3d
        L17:
            java.lang.IllegalStateException r10 = new java.lang.IllegalStateException
            java.lang.String r0 = "call to 'resume' before 'invoke' with coroutine"
            r10.<init>(r0)
            throw r10
        L1f:
            kotlin.ResultKt.throwOnFailure(r10)
            java.lang.Object r10 = r9.L$0
            kotlinx.coroutines.CoroutineScope r10 = (kotlinx.coroutines.CoroutineScope) r10
            kotlinx.coroutines.channels.Channel<java.lang.Boolean> r1 = r9.$channel
            kotlinx.coroutines.channels.ChannelIterator r1 = r1.iterator()
            r3 = r10
        L2d:
            r10 = r9
            kotlin.coroutines.Continuation r10 = (kotlin.coroutines.Continuation) r10
            r9.L$0 = r3
            r9.L$1 = r1
            r9.label = r2
            java.lang.Object r10 = r1.hasNext(r10)
            if (r10 != r0) goto L3d
            return r0
        L3d:
            java.lang.Boolean r10 = (java.lang.Boolean) r10
            boolean r10 = r10.booleanValue()
            if (r10 == 0) goto L74
            java.lang.Object r10 = r1.next()
            java.lang.Boolean r10 = (java.lang.Boolean) r10
            boolean r10 = r10.booleanValue()
            kotlinx.coroutines.channels.Channel<java.lang.Boolean> r4 = r9.$channel
            java.lang.Object r4 = r4.mo13903tryReceivePtdJZtk()
            java.lang.Object r4 = kotlinx.coroutines.channels.ChannelResult.m13915getOrNullimpl(r4)
            java.lang.Boolean r4 = (java.lang.Boolean) r4
            if (r4 == 0) goto L61
            boolean r10 = r4.booleanValue()
        L61:
            androidx.compose.material3.DefaultModalWideNavigationRailOverride$ModalWideNavigationRail$1$1$1 r4 = new androidx.compose.material3.DefaultModalWideNavigationRailOverride$ModalWideNavigationRail$1$1$1
            androidx.compose.material3.ModalWideNavigationRailState r5 = r9.$modalState
            r6 = 0
            r4.<init>(r10, r5, r6)
            r6 = r4
            kotlin.jvm.functions.Function2 r6 = (kotlin.jvm.functions.Function2) r6
            r7 = 3
            r8 = 0
            r4 = 0
            r5 = 0
            kotlinx.coroutines.BuildersKt.launch$default(r3, r4, r5, r6, r7, r8)
            goto L2d
        L74:
            kotlin.Unit r10 = kotlin.Unit.INSTANCE
            return r10
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.compose.material3.DefaultModalWideNavigationRailOverride$ModalWideNavigationRail$1$1.invokeSuspend(java.lang.Object):java.lang.Object");
    }

    /* JADX INFO: renamed from: androidx.compose.material3.DefaultModalWideNavigationRailOverride$ModalWideNavigationRail$1$1$1, reason: invalid class name */
    /* JADX INFO: compiled from: WideNavigationRail.kt */
    @Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\n"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {2, 0, 0}, xi = 48)
    @DebugMetadata(c = "androidx.compose.material3.DefaultModalWideNavigationRailOverride$ModalWideNavigationRail$1$1$1", f = "WideNavigationRail.kt", i = {}, l = {565, 567}, m = "invokeSuspend", n = {}, s = {})
    static final class AnonymousClass1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
        final /* synthetic */ ModalWideNavigationRailState $modalState;
        final /* synthetic */ boolean $newTarget;
        int label;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        AnonymousClass1(boolean z, ModalWideNavigationRailState modalWideNavigationRailState, Continuation<? super AnonymousClass1> continuation) {
            super(2, continuation);
            this.$newTarget = z;
            this.$modalState = modalWideNavigationRailState;
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
            return new AnonymousClass1(this.$newTarget, this.$modalState, continuation);
        }

        @Override // kotlin.jvm.functions.Function2
        public final Object invoke(CoroutineScope coroutineScope, Continuation<? super Unit> continuation) {
            return ((AnonymousClass1) create(coroutineScope, continuation)).invokeSuspend(Unit.INSTANCE);
        }

        /* JADX WARN: Code restructure failed: missing block: B:13:0x002d, code lost:
        
            if (r4.$modalState.expand(r4) == r0) goto L17;
         */
        /* JADX WARN: Code restructure failed: missing block: B:16:0x003b, code lost:
        
            if (r4.$modalState.collapse(r4) == r0) goto L17;
         */
        /* JADX WARN: Code restructure failed: missing block: B:17:0x003d, code lost:
        
            return r0;
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
                if (r1 == 0) goto L1b
                if (r1 == r3) goto L17
                if (r1 != r2) goto Lf
                goto L17
            Lf:
                java.lang.IllegalStateException r5 = new java.lang.IllegalStateException
                java.lang.String r0 = "call to 'resume' before 'invoke' with coroutine"
                r5.<init>(r0)
                throw r5
            L17:
                kotlin.ResultKt.throwOnFailure(r5)
                goto L3e
            L1b:
                kotlin.ResultKt.throwOnFailure(r5)
                boolean r5 = r4.$newTarget
                if (r5 == 0) goto L30
                androidx.compose.material3.ModalWideNavigationRailState r5 = r4.$modalState
                r1 = r4
                kotlin.coroutines.Continuation r1 = (kotlin.coroutines.Continuation) r1
                r4.label = r3
                java.lang.Object r5 = r5.expand(r1)
                if (r5 != r0) goto L3e
                goto L3d
            L30:
                androidx.compose.material3.ModalWideNavigationRailState r5 = r4.$modalState
                r1 = r4
                kotlin.coroutines.Continuation r1 = (kotlin.coroutines.Continuation) r1
                r4.label = r2
                java.lang.Object r5 = r5.collapse(r1)
                if (r5 != r0) goto L3e
            L3d:
                return r0
            L3e:
                kotlin.Unit r5 = kotlin.Unit.INSTANCE
                return r5
            */
            throw new UnsupportedOperationException("Method not decompiled: androidx.compose.material3.DefaultModalWideNavigationRailOverride$ModalWideNavigationRail$1$1.AnonymousClass1.invokeSuspend(java.lang.Object):java.lang.Object");
        }
    }
}
