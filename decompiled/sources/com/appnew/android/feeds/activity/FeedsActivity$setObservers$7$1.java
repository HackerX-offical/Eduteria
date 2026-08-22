package com.appnew.android.feeds.activity;

import com.appnew.android.table.PostDataTable;
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
@DebugMetadata(c = "com.appnew.android.feeds.activity.FeedsActivity$setObservers$7$1", f = "FeedsActivity.kt", i = {}, l = {}, m = "invokeSuspend", n = {}, s = {})
final class FeedsActivity$setObservers$7$1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
    final /* synthetic */ PostDataTable $postDataTable;
    int label;
    final /* synthetic */ FeedsActivity this$0;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    FeedsActivity$setObservers$7$1(FeedsActivity feedsActivity, PostDataTable postDataTable, Continuation<? super FeedsActivity$setObservers$7$1> continuation) {
        super(2, continuation);
        this.this$0 = feedsActivity;
        this.$postDataTable = postDataTable;
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
        return new FeedsActivity$setObservers$7$1(this.this$0, this.$postDataTable, continuation);
    }

    @Override // kotlin.jvm.functions.Function2
    public final Object invoke(CoroutineScope coroutineScope, Continuation<? super Unit> continuation) {
        return ((FeedsActivity$setObservers$7$1) create(coroutineScope, continuation)).invokeSuspend(Unit.INSTANCE);
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object invokeSuspend(Object obj) {
        IntrinsicsKt.getCOROUTINE_SUSPENDED();
        if (this.label != 0) {
            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        }
        ResultKt.throwOnFailure(obj);
        if (!this.this$0.getUtkashRoom().getFeedDao().isFeedExistviamaincat("1092", this.this$0.getSub_cat())) {
            this.this$0.getUtkashRoom().getFeedDao().insertPost(this.$postDataTable);
        }
        return Unit.INSTANCE;
    }
}
