package com.clevertap.android.sdk.video;

import android.content.Context;
import android.view.View;
import com.appnew.android.DownloadServices.VideoDownloadService;
import kotlin.Metadata;

/* JADX INFO: compiled from: InAppVideoPlayerHandle.kt */
/* JADX INFO: loaded from: classes7.dex */
@Metadata(d1 = {"\u0000,\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0000\bf\u0018\u00002\u00020\u0001J\u0018\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u0007H&J\u0018\u0010\b\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u00052\u0006\u0010\t\u001a\u00020\nH&J\b\u0010\u000b\u001a\u00020\u0003H&J\b\u0010\f\u001a\u00020\u0003H&J\b\u0010\r\u001a\u00020\u0003H&J\u0010\u0010\u000e\u001a\u00020\u00032\u0006\u0010\u000f\u001a\u00020\nH&J\b\u0010\u0010\u001a\u00020\u0011H&¨\u0006\u0012"}, d2 = {"Lcom/clevertap/android/sdk/video/InAppVideoPlayerHandle;", "", "initExoplayer", "", "context", "Landroid/content/Context;", "url", "", "initPlayerView", "isTablet", "", "play", VideoDownloadService.PAUSE, "savePosition", "switchToFullScreen", "isFullScreen", "videoSurface", "Landroid/view/View;", "clevertap-core_release"}, k = 1, mv = {2, 0, 0}, xi = 48)
public interface InAppVideoPlayerHandle {
    void initExoplayer(Context context, String url);

    void initPlayerView(Context context, boolean isTablet);

    void pause();

    void play();

    void savePosition();

    void switchToFullScreen(boolean isFullScreen);

    View videoSurface();
}
