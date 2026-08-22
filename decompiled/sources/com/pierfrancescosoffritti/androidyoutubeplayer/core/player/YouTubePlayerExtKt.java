package com.pierfrancescosoffritti.androidyoutubeplayer.core.player;

import kotlin.Metadata;
import kotlin.Result;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.SafeContinuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.DebugProbesKt;

/* JADX INFO: compiled from: YouTubePlayerExt.kt */
/* JADX INFO: loaded from: classes9.dex */
@Metadata(d1 = {"\u0000\u000e\n\u0000\n\u0002\u0010\u000b\n\u0002\u0018\u0002\n\u0002\b\u0002\u001a\u0015\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\u0086@ø\u0001\u0000¢\u0006\u0002\u0010\u0003\u0082\u0002\u0004\n\u0002\b\u0019¨\u0006\u0004"}, d2 = {"isMuted", "", "Lcom/pierfrancescosoffritti/androidyoutubeplayer/core/player/YouTubePlayer;", "(Lcom/pierfrancescosoffritti/androidyoutubeplayer/core/player/YouTubePlayer;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "core_release"}, k = 2, mv = {1, 8, 0}, xi = 48)
public final class YouTubePlayerExtKt {
    public static final Object isMuted(YouTubePlayer youTubePlayer, Continuation<? super Boolean> continuation) throws Throwable {
        SafeContinuation safeContinuation = new SafeContinuation(IntrinsicsKt.intercepted(continuation));
        final SafeContinuation safeContinuation2 = safeContinuation;
        youTubePlayer.isMutedAsync(new BooleanProvider() { // from class: com.pierfrancescosoffritti.androidyoutubeplayer.core.player.YouTubePlayerExtKt$isMuted$2$1
            @Override // com.pierfrancescosoffritti.androidyoutubeplayer.core.player.BooleanProvider
            public final void accept(boolean z) {
                Boolean boolValueOf = Boolean.valueOf(z);
                Continuation<Boolean> continuation2 = safeContinuation2;
                Result.Companion companion = Result.INSTANCE;
                continuation2.resumeWith(Result.m12393constructorimpl(boolValueOf));
            }
        });
        Object orThrow = safeContinuation.getOrThrow();
        if (orThrow == IntrinsicsKt.getCOROUTINE_SUSPENDED()) {
            DebugProbesKt.probeCoroutineSuspended(continuation);
        }
        return orThrow;
    }
}
