package com.clevertap.android.sdk.inapp.images.preload;

import java.util.List;
import kotlin.Metadata;
import kotlin.Pair;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function2;
import kotlinx.coroutines.AwaitKt;
import kotlinx.coroutines.CoroutineScope;
import kotlinx.coroutines.Deferred;

/* JADX INFO: compiled from: FilePreloaderCoroutine.kt */
/* JADX INFO: loaded from: classes7.dex */
@Metadata(d1 = {"\u0000\u0016\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0002\u0010\u000b\n\u0002\u0018\u0002\u0010\u0000\u001a\u0014\u0012\u0010\u0012\u000e\u0012\u0004\u0012\u00020\u0003\u0012\u0004\u0012\u00020\u00040\u00020\u0001*\u00020\u0005H\n"}, d2 = {"<anonymous>", "", "Lkotlin/Pair;", "", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {2, 0, 0}, xi = 48)
@DebugMetadata(c = "com.clevertap.android.sdk.inapp.images.preload.FilePreloaderCoroutine$preloadAssets$job$1$pairs$1", f = "FilePreloaderCoroutine.kt", i = {}, l = {105}, m = "invokeSuspend", n = {}, s = {})
final class FilePreloaderCoroutine$preloadAssets$job$1$pairs$1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super List<? extends Pair<? extends String, ? extends Boolean>>>, Object> {
    final /* synthetic */ List<Deferred<Pair<String, Boolean>>> $dowloadResults;
    int label;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    FilePreloaderCoroutine$preloadAssets$job$1$pairs$1(List<Deferred<Pair<String, Boolean>>> list, Continuation<? super FilePreloaderCoroutine$preloadAssets$job$1$pairs$1> continuation) {
        super(2, continuation);
        this.$dowloadResults = list;
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
        return new FilePreloaderCoroutine$preloadAssets$job$1$pairs$1(this.$dowloadResults, continuation);
    }

    @Override // kotlin.jvm.functions.Function2
    public /* bridge */ /* synthetic */ Object invoke(CoroutineScope coroutineScope, Continuation<? super List<? extends Pair<? extends String, ? extends Boolean>>> continuation) {
        return invoke2(coroutineScope, (Continuation<? super List<Pair<String, Boolean>>>) continuation);
    }

    /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
    public final Object invoke2(CoroutineScope coroutineScope, Continuation<? super List<Pair<String, Boolean>>> continuation) {
        return ((FilePreloaderCoroutine$preloadAssets$job$1$pairs$1) create(coroutineScope, continuation)).invokeSuspend(Unit.INSTANCE);
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object invokeSuspend(Object obj) {
        Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int i = this.label;
        if (i != 0) {
            if (i != 1) {
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
            }
            ResultKt.throwOnFailure(obj);
            return obj;
        }
        ResultKt.throwOnFailure(obj);
        this.label = 1;
        Object objAwaitAll = AwaitKt.awaitAll(this.$dowloadResults, this);
        return objAwaitAll == coroutine_suspended ? coroutine_suspended : objAwaitAll;
    }
}
