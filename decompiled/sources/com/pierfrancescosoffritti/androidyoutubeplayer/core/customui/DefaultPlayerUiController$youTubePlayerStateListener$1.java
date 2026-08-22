package com.pierfrancescosoffritti.androidyoutubeplayer.core.customui;

import android.content.Intent;
import android.net.Uri;
import android.util.Log;
import android.view.View;
import android.widget.ImageView;
import androidx.core.content.ContextCompat;
import com.pierfrancescosoffritti.androidyoutubeplayer.core.player.PlayerConstants;
import com.pierfrancescosoffritti.androidyoutubeplayer.core.player.YouTubePlayer;
import com.pierfrancescosoffritti.androidyoutubeplayer.core.player.listeners.AbstractYouTubePlayerListener;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: compiled from: DefaultPlayerUiController.kt */
/* JADX INFO: loaded from: classes9.dex */
@Metadata(d1 = {"\u0000%\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\u0018\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u0007H\u0016J\u0018\u0010\b\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u00052\u0006\u0010\t\u001a\u00020\nH\u0016¨\u0006\u000b"}, d2 = {"com/pierfrancescosoffritti/androidyoutubeplayer/core/customui/DefaultPlayerUiController$youTubePlayerStateListener$1", "Lcom/pierfrancescosoffritti/androidyoutubeplayer/core/player/listeners/AbstractYouTubePlayerListener;", "onStateChange", "", "youTubePlayer", "Lcom/pierfrancescosoffritti/androidyoutubeplayer/core/player/YouTubePlayer;", "state", "Lcom/pierfrancescosoffritti/androidyoutubeplayer/core/player/PlayerConstants$PlayerState;", "onVideoId", "videoId", "", "custom-ui_release"}, k = 1, mv = {1, 8, 0}, xi = 48)
public final class DefaultPlayerUiController$youTubePlayerStateListener$1 extends AbstractYouTubePlayerListener {
    final /* synthetic */ DefaultPlayerUiController this$0;

    DefaultPlayerUiController$youTubePlayerStateListener$1(DefaultPlayerUiController defaultPlayerUiController) {
        this.this$0 = defaultPlayerUiController;
    }

    @Override // com.pierfrancescosoffritti.androidyoutubeplayer.core.player.listeners.AbstractYouTubePlayerListener, com.pierfrancescosoffritti.androidyoutubeplayer.core.player.listeners.YouTubePlayerListener
    public void onStateChange(YouTubePlayer youTubePlayer, PlayerConstants.PlayerState state) {
        Intrinsics.checkNotNullParameter(youTubePlayer, "youTubePlayer");
        Intrinsics.checkNotNullParameter(state, "state");
        this.this$0.updateState(state);
        if (state == PlayerConstants.PlayerState.PLAYING || state == PlayerConstants.PlayerState.PAUSED || state == PlayerConstants.PlayerState.VIDEO_CUED) {
            this.this$0.panel.setBackgroundColor(ContextCompat.getColor(this.this$0.panel.getContext(), android.R.color.transparent));
            this.this$0.progressBar.setVisibility(8);
            if (this.this$0.isPlayPauseButtonEnabled) {
                this.this$0.playPauseButton.setVisibility(0);
            }
            if (this.this$0.isCustomActionLeftEnabled) {
                this.this$0.customActionLeft.setVisibility(0);
            }
            if (this.this$0.isCustomActionRightEnabled) {
                this.this$0.customActionRight.setVisibility(0);
            }
            this.this$0.updatePlayPauseButtonIcon(state == PlayerConstants.PlayerState.PLAYING);
            return;
        }
        this.this$0.updatePlayPauseButtonIcon(false);
        if (state == PlayerConstants.PlayerState.BUFFERING) {
            this.this$0.progressBar.setVisibility(0);
            this.this$0.panel.setBackgroundColor(ContextCompat.getColor(this.this$0.panel.getContext(), android.R.color.transparent));
            if (this.this$0.isPlayPauseButtonEnabled) {
                this.this$0.playPauseButton.setVisibility(4);
            }
            this.this$0.customActionLeft.setVisibility(8);
            this.this$0.customActionRight.setVisibility(8);
        }
        if (state == PlayerConstants.PlayerState.UNSTARTED) {
            this.this$0.progressBar.setVisibility(8);
            if (this.this$0.isPlayPauseButtonEnabled) {
                this.this$0.playPauseButton.setVisibility(0);
            }
        }
    }

    @Override // com.pierfrancescosoffritti.androidyoutubeplayer.core.player.listeners.AbstractYouTubePlayerListener, com.pierfrancescosoffritti.androidyoutubeplayer.core.player.listeners.YouTubePlayerListener
    public void onVideoId(YouTubePlayer youTubePlayer, final String videoId) {
        Intrinsics.checkNotNullParameter(youTubePlayer, "youTubePlayer");
        Intrinsics.checkNotNullParameter(videoId, "videoId");
        ImageView imageView = this.this$0.youTubeButton;
        final DefaultPlayerUiController defaultPlayerUiController = this.this$0;
        imageView.setOnClickListener(new View.OnClickListener() { // from class: com.pierfrancescosoffritti.androidyoutubeplayer.core.customui.DefaultPlayerUiController$youTubePlayerStateListener$1$$ExternalSyntheticLambda0
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                DefaultPlayerUiController$youTubePlayerStateListener$1.onVideoId$lambda$0(videoId, defaultPlayerUiController, this, view);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void onVideoId$lambda$0(String videoId, DefaultPlayerUiController this$0, DefaultPlayerUiController$youTubePlayerStateListener$1 this$1, View view) {
        Intrinsics.checkNotNullParameter(videoId, "$videoId");
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        Intrinsics.checkNotNullParameter(this$1, "this$1");
        try {
            this$0.youTubeButton.getContext().startActivity(new Intent("android.intent.action.VIEW", Uri.parse("https://www.youtube.com/watch?v=" + videoId + "#t=" + this$0.youtubePlayerSeekBar.getSeekBar().getProgress())));
        } catch (Exception e2) {
            String simpleName = this$1.getClass().getSimpleName();
            String message = e2.getMessage();
            if (message == null) {
                message = "Can't open url to YouTube";
            }
            Log.e(simpleName, message);
        }
    }
}
