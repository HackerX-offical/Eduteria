package com.appnew.android.loginRevamp.Activity;

import com.appnew.android.BuildConfig;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function2;
import kotlin.text.StringsKt;
import kotlinx.coroutines.CoroutineScope;

/* JADX INFO: compiled from: SignInNewActivity.kt */
/* JADX INFO: loaded from: classes6.dex */
@Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\n"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {2, 1, 0}, xi = 48)
@DebugMetadata(c = "com.appnew.android.loginRevamp.Activity.SignInNewActivity$onCreate$3$onPermissionsChecked$1", f = "SignInNewActivity.kt", i = {}, l = {}, m = "invokeSuspend", n = {}, s = {})
final class SignInNewActivity$onCreate$3$onPermissionsChecked$1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
    int label;
    final /* synthetic */ SignInNewActivity this$0;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    SignInNewActivity$onCreate$3$onPermissionsChecked$1(SignInNewActivity signInNewActivity, Continuation<? super SignInNewActivity$onCreate$3$onPermissionsChecked$1> continuation) {
        super(2, continuation);
        this.this$0 = signInNewActivity;
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
        return new SignInNewActivity$onCreate$3$onPermissionsChecked$1(this.this$0, continuation);
    }

    @Override // kotlin.jvm.functions.Function2
    public final Object invoke(CoroutineScope coroutineScope, Continuation<? super Unit> continuation) {
        return ((SignInNewActivity$onCreate$3$onPermissionsChecked$1) create(coroutineScope, continuation)).invokeSuspend(Unit.INSTANCE);
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object invokeSuspend(Object obj) {
        IntrinsicsKt.getCOROUTINE_SUSPENDED();
        if (this.label != 0) {
            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        }
        ResultKt.throwOnFailure(obj);
        if (!StringsKt.equals(BuildConfig.FLAVOR, "Testink", true) || !StringsKt.equals(BuildConfig.FLAVOR, "thinkssc", true)) {
            this.this$0.getLocation();
        }
        return Unit.INSTANCE;
    }
}
