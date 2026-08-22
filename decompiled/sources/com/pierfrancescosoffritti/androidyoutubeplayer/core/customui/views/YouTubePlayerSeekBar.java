package com.pierfrancescosoffritti.androidyoutubeplayer.core.customui.views;

import android.content.Context;
import android.content.res.TypedArray;
import android.util.AttributeSet;
import android.widget.LinearLayout;
import android.widget.SeekBar;
import android.widget.TextView;
import androidx.constraintlayout.core.motion.utils.TypedValues;
import androidx.core.content.ContextCompat;
import androidx.core.graphics.drawable.DrawableCompat;
import com.pierfrancescosoffritti.androidyoutubeplayer.core.customui.R;
import com.pierfrancescosoffritti.androidyoutubeplayer.core.customui.utils.TimeUtilities;
import com.pierfrancescosoffritti.androidyoutubeplayer.core.player.PlayerConstants;
import com.pierfrancescosoffritti.androidyoutubeplayer.core.player.YouTubePlayer;
import com.pierfrancescosoffritti.androidyoutubeplayer.core.player.listeners.YouTubePlayerListener;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: compiled from: YouTubePlayerSeekBar.kt */
/* JADX INFO: loaded from: classes9.dex */
@Metadata(d1 = {"\u0000\u0082\u0001\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\t\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0007\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u000e\n\u0002\b\t\u0018\u00002\u00020\u00012\u00020\u00022\u00020\u0003B\u0019\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\n\b\u0002\u0010\u0006\u001a\u0004\u0018\u00010\u0007¢\u0006\u0002\u0010\bJ\u0010\u0010#\u001a\u00020$2\u0006\u0010%\u001a\u00020&H\u0016J\u0018\u0010'\u001a\u00020$2\u0006\u0010%\u001a\u00020&2\u0006\u0010(\u001a\u00020)H\u0016J\u0018\u0010*\u001a\u00020$2\u0006\u0010%\u001a\u00020&2\u0006\u0010+\u001a\u00020,H\u0016J\u0018\u0010-\u001a\u00020$2\u0006\u0010%\u001a\u00020&2\u0006\u0010.\u001a\u00020/H\u0016J\u0018\u00100\u001a\u00020$2\u0006\u0010%\u001a\u00020&2\u0006\u00101\u001a\u000202H\u0016J \u00103\u001a\u00020$2\u0006\u0010\r\u001a\u00020\u000e2\u0006\u00104\u001a\u00020\f2\u0006\u00105\u001a\u00020\nH\u0016J\u0010\u00106\u001a\u00020$2\u0006\u0010%\u001a\u00020&H\u0016J\u0010\u00107\u001a\u00020$2\u0006\u0010\r\u001a\u00020\u000eH\u0016J\u0018\u00108\u001a\u00020$2\u0006\u0010%\u001a\u00020&2\u0006\u00109\u001a\u00020:H\u0016J\u0010\u0010;\u001a\u00020$2\u0006\u0010\r\u001a\u00020\u000eH\u0016J\u0018\u0010<\u001a\u00020$2\u0006\u0010%\u001a\u00020&2\u0006\u0010=\u001a\u00020)H\u0016J\u0018\u0010>\u001a\u00020$2\u0006\u0010%\u001a\u00020&2\u0006\u0010?\u001a\u00020@H\u0016J\u0018\u0010A\u001a\u00020$2\u0006\u0010%\u001a\u00020&2\u0006\u0010B\u001a\u00020)H\u0016J\b\u0010C\u001a\u00020$H\u0002J\u0010\u0010D\u001a\u00020$2\b\b\u0001\u0010E\u001a\u00020\fJ\u000e\u0010F\u001a\u00020$2\u0006\u0010G\u001a\u00020)J\u0010\u0010H\u001a\u00020$2\u0006\u00109\u001a\u00020:H\u0002R\u000e\u0010\t\u001a\u00020\nX\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u000b\u001a\u00020\fX\u0082\u000e¢\u0006\u0002\n\u0000R\u0011\u0010\r\u001a\u00020\u000e¢\u0006\b\n\u0000\u001a\u0004\b\u000f\u0010\u0010R\u000e\u0010\u0011\u001a\u00020\nX\u0082\u000e¢\u0006\u0002\n\u0000R\u001a\u0010\u0012\u001a\u00020\nX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0013\u0010\u0014\"\u0004\b\u0015\u0010\u0016R\u0011\u0010\u0017\u001a\u00020\u0018¢\u0006\b\n\u0000\u001a\u0004\b\u0019\u0010\u001aR\u0011\u0010\u001b\u001a\u00020\u0018¢\u0006\b\n\u0000\u001a\u0004\b\u001c\u0010\u001aR\u001c\u0010\u001d\u001a\u0004\u0018\u00010\u001eX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u001f\u0010 \"\u0004\b!\u0010\"¨\u0006I"}, d2 = {"Lcom/pierfrancescosoffritti/androidyoutubeplayer/core/customui/views/YouTubePlayerSeekBar;", "Landroid/widget/LinearLayout;", "Landroid/widget/SeekBar$OnSeekBarChangeListener;", "Lcom/pierfrancescosoffritti/androidyoutubeplayer/core/player/listeners/YouTubePlayerListener;", "context", "Landroid/content/Context;", "attrs", "Landroid/util/AttributeSet;", "(Landroid/content/Context;Landroid/util/AttributeSet;)V", "isPlaying", "", "newSeekBarProgress", "", "seekBar", "Landroid/widget/SeekBar;", "getSeekBar", "()Landroid/widget/SeekBar;", "seekBarTouchStarted", "showBufferingProgress", "getShowBufferingProgress", "()Z", "setShowBufferingProgress", "(Z)V", "videoCurrentTimeTextView", "Landroid/widget/TextView;", "getVideoCurrentTimeTextView", "()Landroid/widget/TextView;", "videoDurationTextView", "getVideoDurationTextView", "youtubePlayerSeekBarListener", "Lcom/pierfrancescosoffritti/androidyoutubeplayer/core/customui/views/YouTubePlayerSeekBarListener;", "getYoutubePlayerSeekBarListener", "()Lcom/pierfrancescosoffritti/androidyoutubeplayer/core/customui/views/YouTubePlayerSeekBarListener;", "setYoutubePlayerSeekBarListener", "(Lcom/pierfrancescosoffritti/androidyoutubeplayer/core/customui/views/YouTubePlayerSeekBarListener;)V", "onApiChange", "", "youTubePlayer", "Lcom/pierfrancescosoffritti/androidyoutubeplayer/core/player/YouTubePlayer;", "onCurrentSecond", "second", "", "onError", "error", "Lcom/pierfrancescosoffritti/androidyoutubeplayer/core/player/PlayerConstants$PlayerError;", "onPlaybackQualityChange", "playbackQuality", "Lcom/pierfrancescosoffritti/androidyoutubeplayer/core/player/PlayerConstants$PlaybackQuality;", "onPlaybackRateChange", "playbackRate", "Lcom/pierfrancescosoffritti/androidyoutubeplayer/core/player/PlayerConstants$PlaybackRate;", "onProgressChanged", "progress", "fromUser", "onReady", "onStartTrackingTouch", "onStateChange", "state", "Lcom/pierfrancescosoffritti/androidyoutubeplayer/core/player/PlayerConstants$PlayerState;", "onStopTrackingTouch", "onVideoDuration", TypedValues.TransitionType.S_DURATION, "onVideoId", "videoId", "", "onVideoLoadedFraction", "loadedFraction", "resetUi", "setColor", "color", "setFontSize", "fontSize", "updateState", "custom-ui_release"}, k = 1, mv = {1, 8, 0}, xi = 48)
public final class YouTubePlayerSeekBar extends LinearLayout implements SeekBar.OnSeekBarChangeListener, YouTubePlayerListener {
    private boolean isPlaying;
    private int newSeekBarProgress;
    private final SeekBar seekBar;
    private boolean seekBarTouchStarted;
    private boolean showBufferingProgress;
    private final TextView videoCurrentTimeTextView;
    private final TextView videoDurationTextView;
    private YouTubePlayerSeekBarListener youtubePlayerSeekBarListener;

    /* JADX INFO: compiled from: YouTubePlayerSeekBar.kt */
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
            $EnumSwitchMapping$0 = iArr;
        }
    }

    @Override // com.pierfrancescosoffritti.androidyoutubeplayer.core.player.listeners.YouTubePlayerListener
    public void onApiChange(YouTubePlayer youTubePlayer) {
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
    public void onVideoId(YouTubePlayer youTubePlayer, String videoId) {
        Intrinsics.checkNotNullParameter(youTubePlayer, "youTubePlayer");
        Intrinsics.checkNotNullParameter(videoId, "videoId");
    }

    public /* synthetic */ YouTubePlayerSeekBar(Context context, AttributeSet attributeSet, int i, DefaultConstructorMarker defaultConstructorMarker) {
        this(context, (i & 2) != 0 ? null : attributeSet);
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public YouTubePlayerSeekBar(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        Intrinsics.checkNotNullParameter(context, "context");
        this.newSeekBarProgress = -1;
        this.showBufferingProgress = true;
        TextView textView = new TextView(context);
        this.videoCurrentTimeTextView = textView;
        TextView textView2 = new TextView(context);
        this.videoDurationTextView = textView2;
        SeekBar seekBar = new SeekBar(context);
        this.seekBar = seekBar;
        TypedArray typedArrayObtainStyledAttributes = context.getTheme().obtainStyledAttributes(attributeSet, R.styleable.YouTubePlayerSeekBar, 0, 0);
        Intrinsics.checkNotNullExpressionValue(typedArrayObtainStyledAttributes, "context.theme.obtainStyl…uTubePlayerSeekBar, 0, 0)");
        int dimensionPixelSize = typedArrayObtainStyledAttributes.getDimensionPixelSize(R.styleable.YouTubePlayerSeekBar_fontSize, getResources().getDimensionPixelSize(R.dimen.ayp_12sp));
        int color = typedArrayObtainStyledAttributes.getColor(R.styleable.YouTubePlayerSeekBar_color, ContextCompat.getColor(context, R.color.ayp_red));
        typedArrayObtainStyledAttributes.recycle();
        int dimensionPixelSize2 = getResources().getDimensionPixelSize(R.dimen.ayp_8dp);
        textView.setText(getResources().getString(R.string.ayp_null_time));
        textView.setPadding(dimensionPixelSize2, dimensionPixelSize2, 0, dimensionPixelSize2);
        textView.setTextColor(ContextCompat.getColor(context, android.R.color.white));
        textView.setGravity(16);
        textView2.setText(getResources().getString(R.string.ayp_null_time));
        textView2.setPadding(0, dimensionPixelSize2, dimensionPixelSize2, dimensionPixelSize2);
        textView2.setTextColor(ContextCompat.getColor(context, android.R.color.white));
        textView2.setGravity(16);
        setFontSize(dimensionPixelSize);
        int i = dimensionPixelSize2 * 2;
        seekBar.setPadding(i, dimensionPixelSize2, i, dimensionPixelSize2);
        setColor(color);
        addView(textView, new LinearLayout.LayoutParams(-2, -2));
        addView(seekBar, new LinearLayout.LayoutParams(0, -2, 1.0f));
        addView(textView2, new LinearLayout.LayoutParams(-2, -2));
        setGravity(16);
        seekBar.setOnSeekBarChangeListener(this);
    }

    public final boolean getShowBufferingProgress() {
        return this.showBufferingProgress;
    }

    public final void setShowBufferingProgress(boolean z) {
        this.showBufferingProgress = z;
    }

    public final YouTubePlayerSeekBarListener getYoutubePlayerSeekBarListener() {
        return this.youtubePlayerSeekBarListener;
    }

    public final void setYoutubePlayerSeekBarListener(YouTubePlayerSeekBarListener youTubePlayerSeekBarListener) {
        this.youtubePlayerSeekBarListener = youTubePlayerSeekBarListener;
    }

    public final TextView getVideoCurrentTimeTextView() {
        return this.videoCurrentTimeTextView;
    }

    public final TextView getVideoDurationTextView() {
        return this.videoDurationTextView;
    }

    public final SeekBar getSeekBar() {
        return this.seekBar;
    }

    public final void setFontSize(float fontSize) {
        this.videoCurrentTimeTextView.setTextSize(0, fontSize);
        this.videoDurationTextView.setTextSize(0, fontSize);
    }

    public final void setColor(int color) {
        DrawableCompat.setTint(this.seekBar.getThumb(), color);
        DrawableCompat.setTint(this.seekBar.getProgressDrawable(), color);
    }

    private final void updateState(PlayerConstants.PlayerState state) {
        int i = WhenMappings.$EnumSwitchMapping$0[state.ordinal()];
        if (i == 1) {
            this.isPlaying = false;
            return;
        }
        if (i == 2) {
            this.isPlaying = false;
        } else if (i == 3) {
            this.isPlaying = true;
        } else {
            if (i != 4) {
                return;
            }
            resetUi();
        }
    }

    private final void resetUi() {
        this.seekBar.setProgress(0);
        this.seekBar.setMax(0);
        this.videoDurationTextView.post(new Runnable() { // from class: com.pierfrancescosoffritti.androidyoutubeplayer.core.customui.views.YouTubePlayerSeekBar$$ExternalSyntheticLambda0
            @Override // java.lang.Runnable
            public final void run() {
                YouTubePlayerSeekBar.resetUi$lambda$0(this.f$0);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void resetUi$lambda$0(YouTubePlayerSeekBar this$0) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        this$0.videoDurationTextView.setText("");
    }

    @Override // android.widget.SeekBar.OnSeekBarChangeListener
    public void onProgressChanged(SeekBar seekBar, int progress, boolean fromUser) {
        Intrinsics.checkNotNullParameter(seekBar, "seekBar");
        this.videoCurrentTimeTextView.setText(TimeUtilities.formatTime(progress));
    }

    @Override // android.widget.SeekBar.OnSeekBarChangeListener
    public void onStartTrackingTouch(SeekBar seekBar) {
        Intrinsics.checkNotNullParameter(seekBar, "seekBar");
        this.seekBarTouchStarted = true;
    }

    @Override // android.widget.SeekBar.OnSeekBarChangeListener
    public void onStopTrackingTouch(SeekBar seekBar) {
        Intrinsics.checkNotNullParameter(seekBar, "seekBar");
        if (this.isPlaying) {
            this.newSeekBarProgress = seekBar.getProgress();
        }
        YouTubePlayerSeekBarListener youTubePlayerSeekBarListener = this.youtubePlayerSeekBarListener;
        if (youTubePlayerSeekBarListener != null) {
            youTubePlayerSeekBarListener.seekTo(seekBar.getProgress());
        }
        this.seekBarTouchStarted = false;
    }

    @Override // com.pierfrancescosoffritti.androidyoutubeplayer.core.player.listeners.YouTubePlayerListener
    public void onStateChange(YouTubePlayer youTubePlayer, PlayerConstants.PlayerState state) {
        Intrinsics.checkNotNullParameter(youTubePlayer, "youTubePlayer");
        Intrinsics.checkNotNullParameter(state, "state");
        this.newSeekBarProgress = -1;
        updateState(state);
    }

    @Override // com.pierfrancescosoffritti.androidyoutubeplayer.core.player.listeners.YouTubePlayerListener
    public void onCurrentSecond(YouTubePlayer youTubePlayer, float second) {
        Intrinsics.checkNotNullParameter(youTubePlayer, "youTubePlayer");
        if (this.seekBarTouchStarted) {
            return;
        }
        if (this.newSeekBarProgress <= 0 || Intrinsics.areEqual(TimeUtilities.formatTime(second), TimeUtilities.formatTime(this.newSeekBarProgress))) {
            this.newSeekBarProgress = -1;
            this.seekBar.setProgress((int) second);
        }
    }

    @Override // com.pierfrancescosoffritti.androidyoutubeplayer.core.player.listeners.YouTubePlayerListener
    public void onVideoDuration(YouTubePlayer youTubePlayer, float duration) {
        Intrinsics.checkNotNullParameter(youTubePlayer, "youTubePlayer");
        this.videoDurationTextView.setText(TimeUtilities.formatTime(duration));
        this.seekBar.setMax((int) duration);
    }

    @Override // com.pierfrancescosoffritti.androidyoutubeplayer.core.player.listeners.YouTubePlayerListener
    public void onVideoLoadedFraction(YouTubePlayer youTubePlayer, float loadedFraction) {
        Intrinsics.checkNotNullParameter(youTubePlayer, "youTubePlayer");
        if (this.showBufferingProgress) {
            this.seekBar.setSecondaryProgress((int) (loadedFraction * r2.getMax()));
        } else {
            this.seekBar.setSecondaryProgress(0);
        }
    }
}
