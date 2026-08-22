package com.pierfrancescosoffritti.androidyoutubeplayer.core.player.utils;

import com.pierfrancescosoffritti.androidyoutubeplayer.core.player.PlayerConstants;
import com.pierfrancescosoffritti.androidyoutubeplayer.core.player.YouTubePlayer;
import com.pierfrancescosoffritti.androidyoutubeplayer.core.player.listeners.AbstractYouTubePlayerListener;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: compiled from: PlaybackResumer.kt */
/* JADX INFO: loaded from: classes9.dex */
@Metadata(d1 = {"\u0000<\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0007\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0004\b\u0000\u0018\u00002\u00020\u0001B\u0005¢\u0006\u0002\u0010\u0002J\u0018\u0010\f\u001a\u00020\r2\u0006\u0010\u000e\u001a\u00020\u000f2\u0006\u0010\u0010\u001a\u00020\u0006H\u0016J\u0018\u0010\u0011\u001a\u00020\r2\u0006\u0010\u000e\u001a\u00020\u000f2\u0006\u0010\t\u001a\u00020\nH\u0016J\u0006\u0010\u0012\u001a\u00020\rJ\u0006\u0010\u0013\u001a\u00020\rJ\u0018\u0010\u0014\u001a\u00020\r2\u0006\u0010\u000e\u001a\u00020\u000f2\u0006\u0010\u0015\u001a\u00020\u0016H\u0016J\u0018\u0010\u0017\u001a\u00020\r2\u0006\u0010\u000e\u001a\u00020\u000f2\u0006\u0010\u0018\u001a\u00020\bH\u0016J\u000e\u0010\u0019\u001a\u00020\r2\u0006\u0010\u000e\u001a\u00020\u000fR\u000e\u0010\u0003\u001a\u00020\u0004X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0005\u001a\u00020\u0006X\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\u0007\u001a\u0004\u0018\u00010\bX\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\t\u001a\u0004\u0018\u00010\nX\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u000b\u001a\u00020\u0004X\u0082\u000e¢\u0006\u0002\n\u0000¨\u0006\u001a"}, d2 = {"Lcom/pierfrancescosoffritti/androidyoutubeplayer/core/player/utils/PlaybackResumer;", "Lcom/pierfrancescosoffritti/androidyoutubeplayer/core/player/listeners/AbstractYouTubePlayerListener;", "()V", "canLoad", "", "currentSecond", "", "currentVideoId", "", "error", "Lcom/pierfrancescosoffritti/androidyoutubeplayer/core/player/PlayerConstants$PlayerError;", "isPlaying", "onCurrentSecond", "", "youTubePlayer", "Lcom/pierfrancescosoffritti/androidyoutubeplayer/core/player/YouTubePlayer;", "second", "onError", "onLifecycleResume", "onLifecycleStop", "onStateChange", "state", "Lcom/pierfrancescosoffritti/androidyoutubeplayer/core/player/PlayerConstants$PlayerState;", "onVideoId", "videoId", "resume", "core_release"}, k = 1, mv = {1, 8, 0}, xi = 48)
public final class PlaybackResumer extends AbstractYouTubePlayerListener {
    private boolean canLoad;
    private float currentSecond;
    private String currentVideoId;
    private PlayerConstants.PlayerError error;
    private boolean isPlaying;

    /* JADX INFO: compiled from: PlaybackResumer.kt */
    @Metadata(k = 3, mv = {1, 8, 0}, xi = 48)
    public /* synthetic */ class WhenMappings {
        public static final /* synthetic */ int[] $EnumSwitchMapping$0;

        static {
            int[] iArr = new int[PlayerConstants.PlayerState.values().length];
            try {
                iArr[PlayerConstants.PlayerState.ENDED.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                iArr[PlayerConstants.PlayerState.PAUSED.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            try {
                iArr[PlayerConstants.PlayerState.PLAYING.ordinal()] = 3;
            } catch (NoSuchFieldError unused3) {
            }
            $EnumSwitchMapping$0 = iArr;
        }
    }

    public final void resume(YouTubePlayer youTubePlayer) {
        Intrinsics.checkNotNullParameter(youTubePlayer, "youTubePlayer");
        String str = this.currentVideoId;
        if (str == null) {
            return;
        }
        if (this.isPlaying && this.error == PlayerConstants.PlayerError.HTML_5_PLAYER) {
            YouTubePlayerUtils.loadOrCueVideo(youTubePlayer, this.canLoad, str, this.currentSecond);
        } else if (!this.isPlaying && this.error == PlayerConstants.PlayerError.HTML_5_PLAYER) {
            youTubePlayer.cueVideo(str, this.currentSecond);
        }
        this.error = null;
    }

    @Override // com.pierfrancescosoffritti.androidyoutubeplayer.core.player.listeners.AbstractYouTubePlayerListener, com.pierfrancescosoffritti.androidyoutubeplayer.core.player.listeners.YouTubePlayerListener
    public void onStateChange(YouTubePlayer youTubePlayer, PlayerConstants.PlayerState state) {
        Intrinsics.checkNotNullParameter(youTubePlayer, "youTubePlayer");
        Intrinsics.checkNotNullParameter(state, "state");
        int i = WhenMappings.$EnumSwitchMapping$0[state.ordinal()];
        if (i == 1 || i == 2) {
            this.isPlaying = false;
        } else {
            if (i != 3) {
                return;
            }
            this.isPlaying = true;
        }
    }

    @Override // com.pierfrancescosoffritti.androidyoutubeplayer.core.player.listeners.AbstractYouTubePlayerListener, com.pierfrancescosoffritti.androidyoutubeplayer.core.player.listeners.YouTubePlayerListener
    public void onError(YouTubePlayer youTubePlayer, PlayerConstants.PlayerError error) {
        Intrinsics.checkNotNullParameter(youTubePlayer, "youTubePlayer");
        Intrinsics.checkNotNullParameter(error, "error");
        if (error == PlayerConstants.PlayerError.HTML_5_PLAYER) {
            this.error = error;
        }
    }

    @Override // com.pierfrancescosoffritti.androidyoutubeplayer.core.player.listeners.AbstractYouTubePlayerListener, com.pierfrancescosoffritti.androidyoutubeplayer.core.player.listeners.YouTubePlayerListener
    public void onCurrentSecond(YouTubePlayer youTubePlayer, float second) {
        Intrinsics.checkNotNullParameter(youTubePlayer, "youTubePlayer");
        this.currentSecond = second;
    }

    @Override // com.pierfrancescosoffritti.androidyoutubeplayer.core.player.listeners.AbstractYouTubePlayerListener, com.pierfrancescosoffritti.androidyoutubeplayer.core.player.listeners.YouTubePlayerListener
    public void onVideoId(YouTubePlayer youTubePlayer, String videoId) {
        Intrinsics.checkNotNullParameter(youTubePlayer, "youTubePlayer");
        Intrinsics.checkNotNullParameter(videoId, "videoId");
        this.currentVideoId = videoId;
    }

    public final void onLifecycleResume() {
        this.canLoad = true;
    }

    public final void onLifecycleStop() {
        this.canLoad = false;
    }
}
