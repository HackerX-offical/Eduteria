package com.appnew.android.Utils;

import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Ref;

/* JADX INFO: compiled from: MessageSender.kt */
/* JADX INFO: loaded from: classes6.dex */
@Metadata(d1 = {"\u0000\f\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u000e\u0010\u0000\u001a\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u0003H\n"}, d2 = {"<anonymous>", "", "message", ""}, k = 3, mv = {2, 1, 0}, xi = 48)
@DebugMetadata(c = "com.appnew.android.Utils.MessageSender$startMessageProcessing$1$1$1", f = "MessageSender.kt", i = {}, l = {94}, m = "invokeSuspend", n = {}, s = {})
final class MessageSender$startMessageProcessing$1$1$1 extends SuspendLambda implements Function2<String, Continuation<? super Unit>, Object> {
    final /* synthetic */ Ref.IntRef $processedCount;
    /* synthetic */ Object L$0;
    int label;
    final /* synthetic */ MessageSender this$0;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    MessageSender$startMessageProcessing$1$1$1(MessageSender messageSender, Ref.IntRef intRef, Continuation<? super MessageSender$startMessageProcessing$1$1$1> continuation) {
        super(2, continuation);
        this.this$0 = messageSender;
        this.$processedCount = intRef;
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
        MessageSender$startMessageProcessing$1$1$1 messageSender$startMessageProcessing$1$1$1 = new MessageSender$startMessageProcessing$1$1$1(this.this$0, this.$processedCount, continuation);
        messageSender$startMessageProcessing$1$1$1.L$0 = obj;
        return messageSender$startMessageProcessing$1$1$1;
    }

    @Override // kotlin.jvm.functions.Function2
    public final Object invoke(String str, Continuation<? super Unit> continuation) {
        return ((MessageSender$startMessageProcessing$1$1$1) create(str, continuation)).invokeSuspend(Unit.INSTANCE);
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object invokeSuspend(Object obj) {
        Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int i = this.label;
        if (i == 0) {
            ResultKt.throwOnFailure(obj);
            String str = (String) this.L$0;
            Function2 function2 = this.this$0.messageProcessingFunction;
            this.label = 1;
            if (function2.invoke(str, this) == coroutine_suspended) {
                return coroutine_suspended;
            }
        } else {
            if (i != 1) {
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
            }
            ResultKt.throwOnFailure(obj);
        }
        this.$processedCount.element++;
        return Unit.INSTANCE;
    }
}
