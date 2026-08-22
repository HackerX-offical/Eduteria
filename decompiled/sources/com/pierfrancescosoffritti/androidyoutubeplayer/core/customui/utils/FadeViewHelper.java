package com.pierfrancescosoffritti.androidyoutubeplayer.core.customui.utils;

import android.animation.Animator;
import android.os.Handler;
import android.view.View;
import androidx.constraintlayout.core.motion.utils.TypedValues;
import com.pierfrancescosoffritti.androidyoutubeplayer.core.player.PlayerConstants;
import com.pierfrancescosoffritti.androidyoutubeplayer.core.player.YouTubePlayer;
import com.pierfrancescosoffritti.androidyoutubeplayer.core.player.listeners.YouTubePlayerListener;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: compiled from: FadeViewHelper.kt */
/* JADX INFO: loaded from: classes9.dex */
@Metadata(d1 = {"\u0000f\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\t\n\u0002\b\u0005\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\f\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u0007\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\u000e\n\u0002\b\u0006\u0018\u0000 92\u00020\u0001:\u00019B\r\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0002\u0010\u0004J\u0010\u0010\u001a\u001a\u00020\u001b2\u0006\u0010\u001c\u001a\u00020\u001dH\u0002J\u0010\u0010\u001e\u001a\u00020\u001b2\u0006\u0010\u001f\u001a\u00020 H\u0016J\u0018\u0010!\u001a\u00020\u001b2\u0006\u0010\u001f\u001a\u00020 2\u0006\u0010\"\u001a\u00020\u001dH\u0016J\u0018\u0010#\u001a\u00020\u001b2\u0006\u0010\u001f\u001a\u00020 2\u0006\u0010$\u001a\u00020%H\u0016J\u0018\u0010&\u001a\u00020\u001b2\u0006\u0010\u001f\u001a\u00020 2\u0006\u0010'\u001a\u00020(H\u0016J\u0018\u0010)\u001a\u00020\u001b2\u0006\u0010\u001f\u001a\u00020 2\u0006\u0010*\u001a\u00020+H\u0016J\u0010\u0010,\u001a\u00020\u001b2\u0006\u0010\u001f\u001a\u00020 H\u0016J\u0018\u0010-\u001a\u00020\u001b2\u0006\u0010\u001f\u001a\u00020 2\u0006\u0010.\u001a\u00020/H\u0016J\u0018\u00100\u001a\u00020\u001b2\u0006\u0010\u001f\u001a\u00020 2\u0006\u00101\u001a\u00020\u001dH\u0016J\u0018\u00102\u001a\u00020\u001b2\u0006\u0010\u001f\u001a\u00020 2\u0006\u00103\u001a\u000204H\u0016J\u0018\u00105\u001a\u00020\u001b2\u0006\u0010\u001f\u001a\u00020 2\u0006\u00106\u001a\u00020\u001dH\u0016J\u0006\u00107\u001a\u00020\u001bJ\u0010\u00108\u001a\u00020\u001b2\u0006\u0010.\u001a\u00020/H\u0002R\u001a\u0010\u0005\u001a\u00020\u0006X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0007\u0010\b\"\u0004\b\t\u0010\nR\u000e\u0010\u000b\u001a\u00020\fX\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\r\u001a\u00020\u000eX\u0082\u000e¢\u0006\u0002\n\u0000R\u001a\u0010\u000f\u001a\u00020\u0006X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0010\u0010\b\"\u0004\b\u0011\u0010\nR\u001a\u0010\u0012\u001a\u00020\fX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0012\u0010\u0013\"\u0004\b\u0014\u0010\u0015R\u000e\u0010\u0016\u001a\u00020\fX\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0017\u001a\u00020\fX\u0082\u000e¢\u0006\u0002\n\u0000R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0018\u0010\u0019¨\u0006:"}, d2 = {"Lcom/pierfrancescosoffritti/androidyoutubeplayer/core/customui/utils/FadeViewHelper;", "Lcom/pierfrancescosoffritti/androidyoutubeplayer/core/player/listeners/YouTubePlayerListener;", "targetView", "Landroid/view/View;", "(Landroid/view/View;)V", "animationDuration", "", "getAnimationDuration", "()J", "setAnimationDuration", "(J)V", "canFade", "", "fadeOut", "Ljava/lang/Runnable;", "fadeOutDelay", "getFadeOutDelay", "setFadeOutDelay", "isDisabled", "()Z", "setDisabled", "(Z)V", "isPlaying", "isVisible", "getTargetView", "()Landroid/view/View;", "fade", "", "finalAlpha", "", "onApiChange", "youTubePlayer", "Lcom/pierfrancescosoffritti/androidyoutubeplayer/core/player/YouTubePlayer;", "onCurrentSecond", "second", "onError", "error", "Lcom/pierfrancescosoffritti/androidyoutubeplayer/core/player/PlayerConstants$PlayerError;", "onPlaybackQualityChange", "playbackQuality", "Lcom/pierfrancescosoffritti/androidyoutubeplayer/core/player/PlayerConstants$PlaybackQuality;", "onPlaybackRateChange", "playbackRate", "Lcom/pierfrancescosoffritti/androidyoutubeplayer/core/player/PlayerConstants$PlaybackRate;", "onReady", "onStateChange", "state", "Lcom/pierfrancescosoffritti/androidyoutubeplayer/core/player/PlayerConstants$PlayerState;", "onVideoDuration", TypedValues.TransitionType.S_DURATION, "onVideoId", "videoId", "", "onVideoLoadedFraction", "loadedFraction", "toggleVisibility", "updateState", "Companion", "custom-ui_release"}, k = 1, mv = {1, 8, 0}, xi = 48)
public final class FadeViewHelper implements YouTubePlayerListener {
    public static final long DEFAULT_ANIMATION_DURATION = 300;
    public static final long DEFAULT_FADE_OUT_DELAY = 3000;
    private long animationDuration;
    private boolean canFade;
    private Runnable fadeOut;
    private long fadeOutDelay;
    private boolean isDisabled;
    private boolean isPlaying;
    private boolean isVisible;
    private final View targetView;

    /* JADX INFO: compiled from: FadeViewHelper.kt */
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
            try {
                iArr[PlayerConstants.PlayerState.UNSTARTED.ordinal()] = 4;
            } catch (NoSuchFieldError unused4) {
            }
            try {
                iArr[PlayerConstants.PlayerState.VIDEO_CUED.ordinal()] = 5;
            } catch (NoSuchFieldError unused5) {
            }
            try {
                iArr[PlayerConstants.PlayerState.BUFFERING.ordinal()] = 6;
            } catch (NoSuchFieldError unused6) {
            }
            try {
                iArr[PlayerConstants.PlayerState.UNKNOWN.ordinal()] = 7;
            } catch (NoSuchFieldError unused7) {
            }
            $EnumSwitchMapping$0 = iArr;
        }
    }

    @Override // com.pierfrancescosoffritti.androidyoutubeplayer.core.player.listeners.YouTubePlayerListener
    public void onApiChange(YouTubePlayer youTubePlayer) {
        Intrinsics.checkNotNullParameter(youTubePlayer, "youTubePlayer");
    }

    @Override // com.pierfrancescosoffritti.androidyoutubeplayer.core.player.listeners.YouTubePlayerListener
    public void onCurrentSecond(YouTubePlayer youTubePlayer, float second) {
        Intrinsics.checkNotNullParameter(youTubePlayer, "youTubePlayer");
    }

    @Override // com.pierfrancescosoffritti.androidyoutubeplayer.core.player.listeners.YouTubePlayerListener
    public void onError(YouTubePlayer youTubePlayer, PlayerConstants.PlayerError error) {
        Intrinsics.checkNotNullParameter(youTubePlayer, "youTubePlayer");
        Intrinsics.checkNotNullParameter(error, "error");
    }

    @Override // com.pierfrancescosoffritti.androidyoutubeplayer.core.player.listeners.YouTubePlayerListener
    public void onPlaybackQualityChange(YouTubePlayer youTubePlayer, PlayerConstants.PlaybackQuality playbackQuality) {
        Intrinsics.checkNotNullParameter(youTubePlayer, "youTubePlayer");
        Intrinsics.checkNotNullParameter(playbackQuality, "playbackQuality");
    }

    @Override // com.pierfrancescosoffritti.androidyoutubeplayer.core.player.listeners.YouTubePlayerListener
    public void onPlaybackRateChange(YouTubePlayer youTubePlayer, PlayerConstants.PlaybackRate playbackRate) {
        Intrinsics.checkNotNullParameter(youTubePlayer, "youTubePlayer");
        Intrinsics.checkNotNullParameter(playbackRate, "playbackRate");
    }

    @Override // com.pierfrancescosoffritti.androidyoutubeplayer.core.player.listeners.YouTubePlayerListener
    public void onReady(YouTubePlayer youTubePlayer) {
        Intrinsics.checkNotNullParameter(youTubePlayer, "youTubePlayer");
    }

    @Override // com.pierfrancescosoffritti.androidyoutubeplayer.core.player.listeners.YouTubePlayerListener
    public void onVideoDuration(YouTubePlayer youTubePlayer, float duration) {
        Intrinsics.checkNotNullParameter(youTubePlayer, "youTubePlayer");
    }

    @Override // com.pierfrancescosoffritti.androidyoutubeplayer.core.player.listeners.YouTubePlayerListener
    public void onVideoId(YouTubePlayer youTubePlayer, String videoId) {
        Intrinsics.checkNotNullParameter(youTubePlayer, "youTubePlayer");
        Intrinsics.checkNotNullParameter(videoId, "videoId");
    }

    @Override // com.pierfrancescosoffritti.androidyoutubeplayer.core.player.listeners.YouTubePlayerListener
    public void onVideoLoadedFraction(YouTubePlayer youTubePlayer, float loadedFraction) {
        Intrinsics.checkNotNullParameter(youTubePlayer, "youTubePlayer");
    }

    public FadeViewHelper(View targetView) {
        Intrinsics.checkNotNullParameter(targetView, "targetView");
        this.targetView = targetView;
        this.isVisible = true;
        this.fadeOut = new Runnable() { // from class: com.pierfrancescosoffritti.androidyoutubeplayer.core.customui.utils.FadeViewHelper$$ExternalSyntheticLambda0
            @Override // java.lang.Runnable
            public final void run() {
                FadeViewHelper.fadeOut$lambda$0(this.f$0);
            }
        };
        this.animationDuration = 300L;
        this.fadeOutDelay = 3000L;
    }

    public final View getTargetView() {
        return this.targetView;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void fadeOut$lambda$0(FadeViewHelper this$0) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        this$0.fade(0.0f);
    }

    /* JADX INFO: renamed from: isDisabled, reason: from getter */
    public final boolean getIsDisabled() {
        return this.isDisabled;
    }

    public final void setDisabled(boolean z) {
        this.isDisabled = z;
    }

    public final long getAnimationDuration() {
        return this.animationDuration;
    }

    public final void setAnimationDuration(long j) {
        this.animationDuration = j;
    }

    public final long getFadeOutDelay() {
        return this.fadeOutDelay;
    }

    public final void setFadeOutDelay(long j) {
        this.fadeOutDelay = j;
    }

    public final void toggleVisibility() {
        fade(this.isVisible ? 0.0f : 1.0f);
    }

    private final void fade(final float finalAlpha) {
        if (!this.canFade || this.isDisabled) {
            return;
        }
        this.isVisible = !(finalAlpha == 0.0f);
        if (finalAlpha == 1.0f && this.isPlaying) {
            Handler handler = this.targetView.getHandler();
            if (handler != null) {
                handler.postDelayed(this.fadeOut, this.fadeOutDelay);
            }
        } else {
            Handler handler2 = this.targetView.getHandler();
            if (handler2 != null) {
                handler2.removeCallbacks(this.fadeOut);
            }
        }
        this.targetView.animate().alpha(finalAlpha).setDuration(this.animationDuration).setListener(new Animator.AnimatorListener() { // from class: com.pierfrancescosoffritti.androidyoutubeplayer.core.customui.utils.FadeViewHelper.fade.1
            @Override // android.animation.Animator.AnimatorListener
            public void onAnimationCancel(Animator animator) {
                Intrinsics.checkNotNullParameter(animator, "animator");
            }

            @Override // android.animation.Animator.AnimatorListener
            public void onAnimationRepeat(Animator animator) {
                Intrinsics.checkNotNullParameter(animator, "animator");
            }

            @Override // android.animation.Animator.AnimatorListener
            public void onAnimationStart(Animator animator) {
                Intrinsics.checkNotNullParameter(animator, "animator");
                if (finalAlpha == 1.0f) {
                    this.getTargetView().setVisibility(0);
                }
            }

            @Override // android.animation.Animator.AnimatorListener
            public void onAnimationEnd(Animator animator) {
                Intrinsics.checkNotNullParameter(animator, "animator");
                if (finalAlpha == 0.0f) {
                    this.getTargetView().setVisibility(8);
                }
            }
        }).start();
    }

    private final void updateState(PlayerConstants.PlayerState state) {
        int i = WhenMappings.$EnumSwitchMapping$0[state.ordinal()];
        if (i == 1) {
            this.isPlaying = false;
        } else if (i == 2) {
            this.isPlaying = false;
        } else {
            if (i != 3) {
                return;
            }
            this.isPlaying = true;
        }
    }

    @Override // com.pierfrancescosoffritti.androidyoutubeplayer.core.player.listeners.YouTubePlayerListener
    public void onStateChange(YouTubePlayer youTubePlayer, PlayerConstants.PlayerState state) {
        Intrinsics.checkNotNullParameter(youTubePlayer, "youTubePlayer");
        Intrinsics.checkNotNullParameter(state, "state");
        updateState(state);
        switch (WhenMappings.$EnumSwitchMapping$0[state.ordinal()]) {
            case 1:
                fade(1.0f);
                break;
            case 2:
            case 3:
            case 5:
                this.canFade = true;
                if (state == PlayerConstants.PlayerState.PLAYING) {
                    Handler handler = this.targetView.getHandler();
                    if (handler != null) {
                        handler.postDelayed(this.fadeOut, this.fadeOutDelay);
                    }
                } else {
                    Handler handler2 = this.targetView.getHandler();
                    if (handler2 != null) {
                        handler2.removeCallbacks(this.fadeOut);
                    }
                }
                break;
            case 4:
            case 6:
                fade(1.0f);
                this.canFade = false;
                break;
            case 7:
                fade(1.0f);
                break;
        }
    }
}
