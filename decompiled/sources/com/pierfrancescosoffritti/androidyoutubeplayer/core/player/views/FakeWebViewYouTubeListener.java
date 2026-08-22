package com.pierfrancescosoffritti.androidyoutubeplayer.core.player.views;

import android.view.View;
import com.pierfrancescosoffritti.androidyoutubeplayer.core.player.listeners.FullscreenListener;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: compiled from: WebViewYouTubePlayer.kt */
/* JADX INFO: loaded from: classes9.dex */
@Metadata(d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\bÀ\u0002\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\u001e\u0010\u0003\u001a\u00020\u00042\u0006\u0010\u0005\u001a\u00020\u00062\f\u0010\u0007\u001a\b\u0012\u0004\u0012\u00020\u00040\bH\u0016J\b\u0010\t\u001a\u00020\u0004H\u0016¨\u0006\n"}, d2 = {"Lcom/pierfrancescosoffritti/androidyoutubeplayer/core/player/views/FakeWebViewYouTubeListener;", "Lcom/pierfrancescosoffritti/androidyoutubeplayer/core/player/listeners/FullscreenListener;", "()V", "onEnterFullscreen", "", "fullscreenView", "Landroid/view/View;", "exitFullscreen", "Lkotlin/Function0;", "onExitFullscreen", "core_release"}, k = 1, mv = {1, 8, 0}, xi = 48)
public final class FakeWebViewYouTubeListener implements FullscreenListener {
    public static final FakeWebViewYouTubeListener INSTANCE = new FakeWebViewYouTubeListener();

    @Override // com.pierfrancescosoffritti.androidyoutubeplayer.core.player.listeners.FullscreenListener
    public void onEnterFullscreen(View fullscreenView, Function0<Unit> exitFullscreen) {
        Intrinsics.checkNotNullParameter(fullscreenView, "fullscreenView");
        Intrinsics.checkNotNullParameter(exitFullscreen, "exitFullscreen");
    }

    @Override // com.pierfrancescosoffritti.androidyoutubeplayer.core.player.listeners.FullscreenListener
    public void onExitFullscreen() {
    }

    private FakeWebViewYouTubeListener() {
    }
}
