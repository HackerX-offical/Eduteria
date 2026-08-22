package com.clevertap.android.sdk.inapp.delay;

import kotlin.Metadata;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.jvm.internal.ContinuationImpl;
import kotlin.coroutines.jvm.internal.DebugMetadata;

/* JADX INFO: compiled from: InAppDelayManager.kt */
/* JADX INFO: loaded from: classes7.dex */
@Metadata(k = 3, mv = {2, 0, 0}, xi = 48)
@DebugMetadata(c = "com.clevertap.android.sdk.inapp.delay.InAppDelayManager", f = "InAppDelayManager.kt", i = {0}, l = {356}, m = "cleanup$clevertap_core_release", n = {"this"}, s = {"L$0"})
final class InAppDelayManager$cleanup$1 extends ContinuationImpl {
    Object L$0;
    int label;
    /* synthetic */ Object result;
    final /* synthetic */ InAppDelayManager this$0;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    InAppDelayManager$cleanup$1(InAppDelayManager inAppDelayManager, Continuation<? super InAppDelayManager$cleanup$1> continuation) {
        super(continuation);
        this.this$0 = inAppDelayManager;
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object invokeSuspend(Object obj) {
        this.result = obj;
        this.label |= Integer.MIN_VALUE;
        return this.this$0.cleanup$clevertap_core_release(this);
    }
}
