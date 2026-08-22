package com.pierfrancescosoffritti.androidyoutubeplayer.core.player;

import android.os.Handler;
import android.os.Looper;
import android.webkit.JavascriptInterface;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.atomic.AtomicLong;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: compiled from: YouTubePlayerCallbacks.kt */
/* JADX INFO: loaded from: classes9.dex */
@Metadata(d1 = {"\u00004\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0010\t\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\b\u0001\u0018\u00002\u00020\u0001B\u0005¢\u0006\u0002\u0010\u0002J\u000e\u0010\u000b\u001a\u00020\u00052\u0006\u0010\f\u001a\u00020\u0006J\u0018\u0010\r\u001a\u00020\u000e2\u0006\u0010\t\u001a\u00020\u00052\u0006\u0010\u000f\u001a\u00020\u0010H\u0007R\u001a\u0010\u0003\u001a\u000e\u0012\u0004\u0012\u00020\u0005\u0012\u0004\u0012\u00020\u00060\u0004X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0007\u001a\u00020\bX\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\t\u001a\u00020\nX\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006\u0011"}, d2 = {"Lcom/pierfrancescosoffritti/androidyoutubeplayer/core/player/YouTubePlayerCallbacks;", "", "()V", "booleanCallbacks", "Ljava/util/concurrent/ConcurrentHashMap;", "", "Lcom/pierfrancescosoffritti/androidyoutubeplayer/core/player/BooleanProvider;", "mainThreadHandler", "Landroid/os/Handler;", "requestId", "Ljava/util/concurrent/atomic/AtomicLong;", "registerBooleanCallback", "callback", "sendBooleanValue", "", "value", "", "core_release"}, k = 1, mv = {1, 8, 0}, xi = 48)
public final class YouTubePlayerCallbacks {
    private final Handler mainThreadHandler = new Handler(Looper.getMainLooper());
    private final ConcurrentHashMap<Long, BooleanProvider> booleanCallbacks = new ConcurrentHashMap<>();
    private final AtomicLong requestId = new AtomicLong(0);

    public final long registerBooleanCallback(BooleanProvider callback) {
        Intrinsics.checkNotNullParameter(callback, "callback");
        long jIncrementAndGet = this.requestId.incrementAndGet();
        this.booleanCallbacks.put(Long.valueOf(jIncrementAndGet), callback);
        return jIncrementAndGet;
    }

    @JavascriptInterface
    public final void sendBooleanValue(final long requestId, final boolean value) {
        this.mainThreadHandler.post(new Runnable() { // from class: com.pierfrancescosoffritti.androidyoutubeplayer.core.player.YouTubePlayerCallbacks$$ExternalSyntheticLambda0
            @Override // java.lang.Runnable
            public final void run() {
                YouTubePlayerCallbacks.sendBooleanValue$lambda$0(this.f$0, requestId, value);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void sendBooleanValue$lambda$0(YouTubePlayerCallbacks this$0, long j, boolean z) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        BooleanProvider booleanProviderRemove = this$0.booleanCallbacks.remove(Long.valueOf(j));
        if (booleanProviderRemove != null) {
            booleanProviderRemove.accept(z);
        }
    }
}
