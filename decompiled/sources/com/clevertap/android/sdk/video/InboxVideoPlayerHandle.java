package com.clevertap.android.sdk.video;

import android.content.Context;
import android.graphics.drawable.Drawable;
import android.view.View;
import com.appnew.android.DownloadServices.VideoDownloadService;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;

/* JADX INFO: compiled from: InboxVideoPlayerHandle.kt */
/* JADX INFO: loaded from: classes7.dex */
@Metadata(d1 = {"\u0000D\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0007\n\u0002\b\u0004\n\u0002\u0010\u000e\n\u0002\b\u0003\bf\u0018\u00002\u00020\u0001J,\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u00052\f\u0010\u0006\u001a\b\u0012\u0004\u0012\u00020\u00030\u00072\f\u0010\b\u001a\b\u0012\u0004\u0012\u00020\u00030\u0007H&J\b\u0010\t\u001a\u00020\nH&J\u0010\u0010\u000b\u001a\u00020\u00032\u0006\u0010\f\u001a\u00020\rH&J\b\u0010\u000e\u001a\u00020\u0003H&J \u0010\u000f\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u00052\u000e\u0010\u0010\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010\u00110\u0007H&J\b\u0010\u0012\u001a\u00020\u0013H&J\b\u0010\u0014\u001a\u00020\u0003H&J(\u0010\u0015\u001a\u00020\u00032\u0006\u0010\u0016\u001a\u00020\u00052\u0006\u0010\u0017\u001a\u00020\u00182\u0006\u0010\u0019\u001a\u00020\r2\u0006\u0010\u001a\u001a\u00020\rH&¨\u0006\u001b"}, d2 = {"Lcom/clevertap/android/sdk/video/InboxVideoPlayerHandle;", "", "initExoplayer", "", "context", "Landroid/content/Context;", "buffering", "Lkotlin/Function0;", "playerReady", "videoSurface", "Landroid/view/View;", "setPlayWhenReady", "play", "", VideoDownloadService.PAUSE, "initPlayerView", "artworkAsset", "Landroid/graphics/drawable/Drawable;", "playerVolume", "", "handleMute", "startPlaying", "ctx", "uriString", "", "isMediaAudio", "isMediaVideo", "clevertap-core_release"}, k = 1, mv = {2, 0, 0}, xi = 48)
public interface InboxVideoPlayerHandle {
    void handleMute();

    void initExoplayer(Context context, Function0<Unit> buffering, Function0<Unit> playerReady);

    void initPlayerView(Context context, Function0<? extends Drawable> artworkAsset);

    void pause();

    float playerVolume();

    void setPlayWhenReady(boolean play);

    void startPlaying(Context ctx, String uriString, boolean isMediaAudio, boolean isMediaVideo);

    View videoSurface();
}
