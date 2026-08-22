package com.clevertap.android.sdk.inapp.delay;

import kotlin.Metadata;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlinx.coroutines.CoroutineScope;

/* JADX INFO: compiled from: InAppDelayManager.kt */
/* JADX INFO: loaded from: classes7.dex */
@Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\n"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {2, 0, 0}, xi = 48)
@DebugMetadata(c = "com.clevertap.android.sdk.inapp.delay.InAppDelayManager$scheduleInAppCallbackWithDispatcher$job$1", f = "InAppDelayManager.kt", i = {0, 0}, l = {105}, m = "invokeSuspend", n = {"$this$launch", "scheduledAt"}, s = {"L$0", "J$0"})
final class InAppDelayManager$scheduleInAppCallbackWithDispatcher$job$1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
    final /* synthetic */ Function1<DelayedInAppResult, Unit> $callback;
    final /* synthetic */ long $delayInMs;
    final /* synthetic */ String $id;
    long J$0;
    private /* synthetic */ Object L$0;
    int label;
    final /* synthetic */ InAppDelayManager this$0;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    /* JADX WARN: Multi-variable type inference failed */
    InAppDelayManager$scheduleInAppCallbackWithDispatcher$job$1(InAppDelayManager inAppDelayManager, long j, String str, Function1<? super DelayedInAppResult, Unit> function1, Continuation<? super InAppDelayManager$scheduleInAppCallbackWithDispatcher$job$1> continuation) {
        super(2, continuation);
        this.this$0 = inAppDelayManager;
        this.$delayInMs = j;
        this.$id = str;
        this.$callback = function1;
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
        InAppDelayManager$scheduleInAppCallbackWithDispatcher$job$1 inAppDelayManager$scheduleInAppCallbackWithDispatcher$job$1 = new InAppDelayManager$scheduleInAppCallbackWithDispatcher$job$1(this.this$0, this.$delayInMs, this.$id, this.$callback, continuation);
        inAppDelayManager$scheduleInAppCallbackWithDispatcher$job$1.L$0 = obj;
        return inAppDelayManager$scheduleInAppCallbackWithDispatcher$job$1;
    }

    @Override // kotlin.jvm.functions.Function2
    public final Object invoke(CoroutineScope coroutineScope, Continuation<? super Unit> continuation) {
        return ((InAppDelayManager$scheduleInAppCallbackWithDispatcher$job$1) create(coroutineScope, continuation)).invokeSuspend(Unit.INSTANCE);
    }

    /* JADX WARN: Removed duplicated region for block: B:18:0x0053 A[Catch: CancellationException -> 0x001b, all -> 0x00d2, Exception -> 0x00d6, TRY_LEAVE, TryCatch #2 {Exception -> 0x00d6, blocks: (B:6:0x0017, B:16:0x004b, B:18:0x0053, B:21:0x0090, B:23:0x0098, B:25:0x00b0, B:24:0x00a2, B:12:0x0037), top: B:39:0x000d, outer: #0 }] */
    /* JADX WARN: Removed duplicated region for block: B:21:0x0090 A[Catch: CancellationException -> 0x001b, all -> 0x00d2, Exception -> 0x00d6, TRY_ENTER, TryCatch #2 {Exception -> 0x00d6, blocks: (B:6:0x0017, B:16:0x004b, B:18:0x0053, B:21:0x0090, B:23:0x0098, B:25:0x00b0, B:24:0x00a2, B:12:0x0037), top: B:39:0x000d, outer: #0 }] */
    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final java.lang.Object invokeSuspend(java.lang.Object r13) {
        /*
            Method dump skipped, instruction units count: 362
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: com.clevertap.android.sdk.inapp.delay.InAppDelayManager$scheduleInAppCallbackWithDispatcher$job$1.invokeSuspend(java.lang.Object):java.lang.Object");
    }
}
