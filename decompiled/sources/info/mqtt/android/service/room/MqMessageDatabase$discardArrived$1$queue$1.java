package info.mqtt.android.service.room;

import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.Boxing;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function2;
import kotlinx.coroutines.CoroutineScope;

/* JADX INFO: compiled from: MqMessageDatabase.kt */
/* JADX INFO: loaded from: classes9.dex */
@Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u000b\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\n"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {2, 1, 0}, xi = 48)
@DebugMetadata(c = "info.mqtt.android.service.room.MqMessageDatabase$discardArrived$1$queue$1", f = "MqMessageDatabase.kt", i = {}, l = {}, m = "invokeSuspend", n = {}, s = {})
final class MqMessageDatabase$discardArrived$1$queue$1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Boolean>, Object> {
    final /* synthetic */ String $clientHandle;
    final /* synthetic */ String $id;
    int label;
    final /* synthetic */ MqMessageDatabase this$0;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    MqMessageDatabase$discardArrived$1$queue$1(MqMessageDatabase mqMessageDatabase, String str, String str2, Continuation<? super MqMessageDatabase$discardArrived$1$queue$1> continuation) {
        super(2, continuation);
        this.this$0 = mqMessageDatabase;
        this.$clientHandle = str;
        this.$id = str2;
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
        return new MqMessageDatabase$discardArrived$1$queue$1(this.this$0, this.$clientHandle, this.$id, continuation);
    }

    @Override // kotlin.jvm.functions.Function2
    public final Object invoke(CoroutineScope coroutineScope, Continuation<? super Boolean> continuation) {
        return ((MqMessageDatabase$discardArrived$1$queue$1) create(coroutineScope, continuation)).invokeSuspend(Unit.INSTANCE);
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object invokeSuspend(Object obj) {
        IntrinsicsKt.getCOROUTINE_SUSPENDED();
        if (this.label != 0) {
            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        }
        ResultKt.throwOnFailure(obj);
        return Boxing.boxBoolean(this.this$0.persistenceDao().deleteId(this.$clientHandle, this.$id) == 1);
    }
}
