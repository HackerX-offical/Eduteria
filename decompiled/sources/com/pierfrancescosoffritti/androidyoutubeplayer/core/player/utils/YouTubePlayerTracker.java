package com.pierfrancescosoffritti.androidyoutubeplayer.core.player.utils;

import androidx.constraintlayout.core.motion.utils.TypedValues;
import com.pierfrancescosoffritti.androidyoutubeplayer.core.player.PlayerConstants;
import com.pierfrancescosoffritti.androidyoutubeplayer.core.player.YouTubePlayer;
import com.pierfrancescosoffritti.androidyoutubeplayer.core.player.listeners.AbstractYouTubePlayerListener;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: compiled from: YouTubePlayerTracker.kt */
/* JADX INFO: loaded from: classes9.dex */
@Metadata(d1 = {"\u00002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0007\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u000e\n\u0002\b\u0004\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0006\u0018\u00002\u00020\u0001B\u0005¢\u0006\u0002\u0010\u0002J\u0018\u0010\u0012\u001a\u00020\u00132\u0006\u0010\u0014\u001a\u00020\u00152\u0006\u0010\u0016\u001a\u00020\u0004H\u0016J\u0018\u0010\u0017\u001a\u00020\u00132\u0006\u0010\u0014\u001a\u00020\u00152\u0006\u0010\t\u001a\u00020\bH\u0016J\u0018\u0010\u0018\u001a\u00020\u00132\u0006\u0010\u0014\u001a\u00020\u00152\u0006\u0010\u0019\u001a\u00020\u0004H\u0016J\u0018\u0010\u001a\u001a\u00020\u00132\u0006\u0010\u0014\u001a\u00020\u00152\u0006\u0010\u000f\u001a\u00020\u000eH\u0016R\u001e\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0004@BX\u0086\u000e¢\u0006\b\n\u0000\u001a\u0004\b\u0006\u0010\u0007R\u001e\u0010\t\u001a\u00020\b2\u0006\u0010\u0003\u001a\u00020\b@BX\u0086\u000e¢\u0006\b\n\u0000\u001a\u0004\b\n\u0010\u000bR\u001e\u0010\f\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0004@BX\u0086\u000e¢\u0006\b\n\u0000\u001a\u0004\b\r\u0010\u0007R\"\u0010\u000f\u001a\u0004\u0018\u00010\u000e2\b\u0010\u0003\u001a\u0004\u0018\u00010\u000e@BX\u0086\u000e¢\u0006\b\n\u0000\u001a\u0004\b\u0010\u0010\u0011¨\u0006\u001b"}, d2 = {"Lcom/pierfrancescosoffritti/androidyoutubeplayer/core/player/utils/YouTubePlayerTracker;", "Lcom/pierfrancescosoffritti/androidyoutubeplayer/core/player/listeners/AbstractYouTubePlayerListener;", "()V", "<set-?>", "", "currentSecond", "getCurrentSecond", "()F", "Lcom/pierfrancescosoffritti/androidyoutubeplayer/core/player/PlayerConstants$PlayerState;", "state", "getState", "()Lcom/pierfrancescosoffritti/androidyoutubeplayer/core/player/PlayerConstants$PlayerState;", "videoDuration", "getVideoDuration", "", "videoId", "getVideoId", "()Ljava/lang/String;", "onCurrentSecond", "", "youTubePlayer", "Lcom/pierfrancescosoffritti/androidyoutubeplayer/core/player/YouTubePlayer;", "second", "onStateChange", "onVideoDuration", TypedValues.TransitionType.S_DURATION, "onVideoId", "core_release"}, k = 1, mv = {1, 8, 0}, xi = 48)
public final class YouTubePlayerTracker extends AbstractYouTubePlayerListener {
    private float currentSecond;
    private PlayerConstants.PlayerState state = PlayerConstants.PlayerState.UNKNOWN;
    private float videoDuration;
    private String videoId;

    public final PlayerConstants.PlayerState getState() {
        return this.state;
    }

    public final float getCurrentSecond() {
        return this.currentSecond;
    }

    public final float getVideoDuration() {
        return this.videoDuration;
    }

    public final String getVideoId() {
        return this.videoId;
    }

    @Override // com.pierfrancescosoffritti.androidyoutubeplayer.core.player.listeners.AbstractYouTubePlayerListener, com.pierfrancescosoffritti.androidyoutubeplayer.core.player.listeners.YouTubePlayerListener
    public void onStateChange(YouTubePlayer youTubePlayer, PlayerConstants.PlayerState state) {
        Intrinsics.checkNotNullParameter(youTubePlayer, "youTubePlayer");
        Intrinsics.checkNotNullParameter(state, "state");
        this.state = state;
    }

    @Override // com.pierfrancescosoffritti.androidyoutubeplayer.core.player.listeners.AbstractYouTubePlayerListener, com.pierfrancescosoffritti.androidyoutubeplayer.core.player.listeners.YouTubePlayerListener
    public void onCurrentSecond(YouTubePlayer youTubePlayer, float second) {
        Intrinsics.checkNotNullParameter(youTubePlayer, "youTubePlayer");
        this.currentSecond = second;
    }

    @Override // com.pierfrancescosoffritti.androidyoutubeplayer.core.player.listeners.AbstractYouTubePlayerListener, com.pierfrancescosoffritti.androidyoutubeplayer.core.player.listeners.YouTubePlayerListener
    public void onVideoDuration(YouTubePlayer youTubePlayer, float duration) {
        Intrinsics.checkNotNullParameter(youTubePlayer, "youTubePlayer");
        this.videoDuration = duration;
    }

    @Override // com.pierfrancescosoffritti.androidyoutubeplayer.core.player.listeners.AbstractYouTubePlayerListener, com.pierfrancescosoffritti.androidyoutubeplayer.core.player.listeners.YouTubePlayerListener
    public void onVideoId(YouTubePlayer youTubePlayer, String videoId) {
        Intrinsics.checkNotNullParameter(youTubePlayer, "youTubePlayer");
        Intrinsics.checkNotNullParameter(videoId, "videoId");
        this.videoId = videoId;
    }
}
