package com.appnew.android.Utils.firebaseToken;

import android.content.Context;
import android.widget.Toast;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function2;
import kotlinx.coroutines.CoroutineScope;

/* JADX INFO: compiled from: FCMTokenHelper.kt */
/* JADX INFO: loaded from: classes6.dex */
@Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\n"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {2, 1, 0}, xi = 48)
@DebugMetadata(c = "com.appnew.android.Utils.firebaseToken.FCMTokenHelper$isGooglePlayServicesReady$info$2", f = "FCMTokenHelper.kt", i = {}, l = {}, m = "invokeSuspend", n = {}, s = {})
final class FCMTokenHelper$isGooglePlayServicesReady$info$2 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
    final /* synthetic */ Context $context;
    final /* synthetic */ Exception $e;
    int label;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    FCMTokenHelper$isGooglePlayServicesReady$info$2(Context context, Exception exc, Continuation<? super FCMTokenHelper$isGooglePlayServicesReady$info$2> continuation) {
        super(2, continuation);
        this.$context = context;
        this.$e = exc;
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
        return new FCMTokenHelper$isGooglePlayServicesReady$info$2(this.$context, this.$e, continuation);
    }

    @Override // kotlin.jvm.functions.Function2
    public final Object invoke(CoroutineScope coroutineScope, Continuation<? super Unit> continuation) {
        return ((FCMTokenHelper$isGooglePlayServicesReady$info$2) create(coroutineScope, continuation)).invokeSuspend(Unit.INSTANCE);
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object invokeSuspend(Object obj) {
        IntrinsicsKt.getCOROUTINE_SUSPENDED();
        if (this.label != 0) {
            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        }
        ResultKt.throwOnFailure(obj);
        Toast.makeText(this.$context, "Error checking Play Services: " + this.$e.getLocalizedMessage(), 1).show();
        return Unit.INSTANCE;
    }
}
