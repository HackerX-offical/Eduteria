package com.appnew.android.feeds.activity;

import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function2;
import kotlinx.coroutines.CoroutineScope;

/* JADX INFO: compiled from: FeedsActivity.kt */
/* JADX INFO: loaded from: classes6.dex */
@Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\n"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {2, 1, 0}, xi = 48)
@DebugMetadata(c = "com.appnew.android.feeds.activity.FeedsActivity$onRestart$1$jobrerutn$1", f = "FeedsActivity.kt", i = {}, l = {}, m = "invokeSuspend", n = {}, s = {})
final class FeedsActivity$onRestart$1$jobrerutn$1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
    int label;
    final /* synthetic */ FeedsActivity this$0;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    FeedsActivity$onRestart$1$jobrerutn$1(FeedsActivity feedsActivity, Continuation<? super FeedsActivity$onRestart$1$jobrerutn$1> continuation) {
        super(2, continuation);
        this.this$0 = feedsActivity;
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
        return new FeedsActivity$onRestart$1$jobrerutn$1(this.this$0, continuation);
    }

    @Override // kotlin.jvm.functions.Function2
    public final Object invoke(CoroutineScope coroutineScope, Continuation<? super Unit> continuation) {
        return ((FeedsActivity$onRestart$1$jobrerutn$1) create(coroutineScope, continuation)).invokeSuspend(Unit.INSTANCE);
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object invokeSuspend(Object obj) {
        IntrinsicsKt.getCOROUTINE_SUSPENDED();
        if (this.label != 0) {
            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        }
        ResultKt.throwOnFailure(obj);
        if (this.this$0.getPosttypeid().equals("0")) {
            FeedsActivity feedsActivity = this.this$0;
            feedsActivity.setFeedParentData(feedsActivity.getUtkashRoom().getFeedDao().retrievePostData(this.this$0.getMaster_cat(), this.this$0.getMain_cat(), this.this$0.getSub_cat()));
        } else {
            FeedsActivity feedsActivity2 = this.this$0;
            feedsActivity2.setFeedParentData(feedsActivity2.getUtkashRoom().getFeedDao().retrievePostData_viaposttype(this.this$0.getMaster_cat(), this.this$0.getMain_cat(), this.this$0.getSub_cat(), this.this$0.getPosttypeid()));
        }
        return Unit.INSTANCE;
    }
}
