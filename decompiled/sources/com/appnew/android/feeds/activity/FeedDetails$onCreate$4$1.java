package com.appnew.android.feeds.activity;

import com.appnew.android.Dao.FeedsDao;
import com.appnew.android.Room.UtkashRoom;
import com.appnew.android.table.PostDataTable;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.coroutines.CoroutineScope;

/* JADX INFO: compiled from: FeedDetails.kt */
/* JADX INFO: loaded from: classes6.dex */
@Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\n"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {2, 1, 0}, xi = 48)
@DebugMetadata(c = "com.appnew.android.feeds.activity.FeedDetails$onCreate$4$1", f = "FeedDetails.kt", i = {}, l = {}, m = "invokeSuspend", n = {}, s = {})
final class FeedDetails$onCreate$4$1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
    int label;
    final /* synthetic */ FeedDetails this$0;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    FeedDetails$onCreate$4$1(FeedDetails feedDetails, Continuation<? super FeedDetails$onCreate$4$1> continuation) {
        super(2, continuation);
        this.this$0 = feedDetails;
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
        return new FeedDetails$onCreate$4$1(this.this$0, continuation);
    }

    @Override // kotlin.jvm.functions.Function2
    public final Object invoke(CoroutineScope coroutineScope, Continuation<? super Unit> continuation) {
        return ((FeedDetails$onCreate$4$1) create(coroutineScope, continuation)).invokeSuspend(Unit.INSTANCE);
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object invokeSuspend(Object obj) {
        IntrinsicsKt.getCOROUTINE_SUSPENDED();
        if (this.label != 0) {
            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        }
        ResultKt.throwOnFailure(obj);
        if (this.this$0.getIs_postexist()) {
            UtkashRoom utkashRoom = this.this$0.getUtkashRoom();
            Intrinsics.checkNotNull(utkashRoom);
            FeedsDao feedDao = utkashRoom.getFeedDao();
            String str = this.this$0.postId;
            PostDataTable postDataTable = this.this$0.postDataTable;
            Intrinsics.checkNotNull(postDataTable);
            String my_like = postDataTable.getMy_like();
            PostDataTable postDataTable2 = this.this$0.postDataTable;
            Intrinsics.checkNotNull(postDataTable2);
            feedDao.updateMyLike(str, my_like, postDataTable2.getTotal_likes());
        }
        return Unit.INSTANCE;
    }
}
