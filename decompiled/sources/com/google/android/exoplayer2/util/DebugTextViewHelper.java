package com.google.android.exoplayer2.util;

import android.os.Looper;
import android.widget.TextView;
import com.google.android.exoplayer2.ExoPlayer;
import com.google.android.exoplayer2.Format;
import com.google.android.exoplayer2.Player;
import com.google.android.exoplayer2.decoder.DecoderCounters;
import java.util.Locale;
import org.jivesoftware.smackx.last_interaction.element.IdleElement;

/* JADX INFO: loaded from: classes7.dex */
public class DebugTextViewHelper implements Player.Listener, Runnable {
    private static final int REFRESH_INTERVAL_MS = 1000;
    private final ExoPlayer player;
    private boolean started;
    private final TextView textView;

    public DebugTextViewHelper(ExoPlayer exoPlayer, TextView textView) {
        Assertions.checkArgument(exoPlayer.getApplicationLooper() == Looper.getMainLooper());
        this.player = exoPlayer;
        this.textView = textView;
    }

    public final void start() {
        if (this.started) {
            return;
        }
        this.started = true;
        this.player.addListener(this);
        updateAndPost();
    }

    public final void stop() {
        if (this.started) {
            this.started = false;
            this.player.removeListener(this);
            this.textView.removeCallbacks(this);
        }
    }

    @Override // com.google.android.exoplayer2.Player.Listener
    public final void onPlaybackStateChanged(int i) {
        updateAndPost();
    }

    @Override // com.google.android.exoplayer2.Player.Listener
    public final void onPlayWhenReadyChanged(boolean z, int i) {
        updateAndPost();
    }

    @Override // com.google.android.exoplayer2.Player.Listener
    public final void onPositionDiscontinuity(Player.PositionInfo positionInfo, Player.PositionInfo positionInfo2, int i) {
        updateAndPost();
    }

    @Override // java.lang.Runnable
    public final void run() {
        updateAndPost();
    }

    protected final void updateAndPost() {
        this.textView.setText(getDebugString());
        this.textView.removeCallbacks(this);
        this.textView.postDelayed(this, 1000L);
    }

    protected String getDebugString() {
        String playerStateString = getPlayerStateString();
        String videoString = getVideoString();
        String audioString = getAudioString();
        return new StringBuilder(String.valueOf(playerStateString).length() + String.valueOf(videoString).length() + String.valueOf(audioString).length()).append(playerStateString).append(videoString).append(audioString).toString();
    }

    protected String getPlayerStateString() {
        String str;
        int playbackState = this.player.getPlaybackState();
        if (playbackState == 1) {
            str = IdleElement.ELEMENT;
        } else if (playbackState == 2) {
            str = "buffering";
        } else if (playbackState == 3) {
            str = "ready";
        } else if (playbackState == 4) {
            str = "ended";
        } else {
            str = "unknown";
        }
        return String.format("playWhenReady:%s playbackState:%s item:%s", Boolean.valueOf(this.player.getPlayWhenReady()), str, Integer.valueOf(this.player.getCurrentMediaItemIndex()));
    }

    protected String getVideoString() {
        Format videoFormat = this.player.getVideoFormat();
        DecoderCounters videoDecoderCounters = this.player.getVideoDecoderCounters();
        if (videoFormat == null || videoDecoderCounters == null) {
            return "";
        }
        String str = videoFormat.sampleMimeType;
        String str2 = videoFormat.id;
        int i = videoFormat.width;
        int i2 = videoFormat.height;
        String pixelAspectRatioString = getPixelAspectRatioString(videoFormat.pixelWidthHeightRatio);
        String decoderCountersBufferCountString = getDecoderCountersBufferCountString(videoDecoderCounters);
        String videoFrameProcessingOffsetAverageString = getVideoFrameProcessingOffsetAverageString(videoDecoderCounters.totalVideoFrameProcessingOffsetUs, videoDecoderCounters.videoFrameProcessingOffsetCount);
        return new StringBuilder(String.valueOf(str).length() + 39 + String.valueOf(str2).length() + String.valueOf(pixelAspectRatioString).length() + String.valueOf(decoderCountersBufferCountString).length() + String.valueOf(videoFrameProcessingOffsetAverageString).length()).append("\n").append(str).append("(id:").append(str2).append(" r:").append(i).append("x").append(i2).append(pixelAspectRatioString).append(decoderCountersBufferCountString).append(" vfpo: ").append(videoFrameProcessingOffsetAverageString).append(")").toString();
    }

    protected String getAudioString() {
        Format audioFormat = this.player.getAudioFormat();
        DecoderCounters audioDecoderCounters = this.player.getAudioDecoderCounters();
        if (audioFormat == null || audioDecoderCounters == null) {
            return "";
        }
        String str = audioFormat.sampleMimeType;
        String str2 = audioFormat.id;
        int i = audioFormat.sampleRate;
        int i2 = audioFormat.channelCount;
        String decoderCountersBufferCountString = getDecoderCountersBufferCountString(audioDecoderCounters);
        return new StringBuilder(String.valueOf(str).length() + 36 + String.valueOf(str2).length() + String.valueOf(decoderCountersBufferCountString).length()).append("\n").append(str).append("(id:").append(str2).append(" hz:").append(i).append(" ch:").append(i2).append(decoderCountersBufferCountString).append(")").toString();
    }

    private static String getDecoderCountersBufferCountString(DecoderCounters decoderCounters) {
        if (decoderCounters == null) {
            return "";
        }
        decoderCounters.ensureUpdated();
        int i = decoderCounters.skippedInputBufferCount;
        int i2 = decoderCounters.skippedOutputBufferCount;
        int i3 = decoderCounters.renderedOutputBufferCount;
        int i4 = decoderCounters.droppedBufferCount;
        int i5 = decoderCounters.maxConsecutiveDroppedBufferCount;
        return new StringBuilder(93).append(" sib:").append(i).append(" sb:").append(i2).append(" rb:").append(i3).append(" db:").append(i4).append(" mcdb:").append(i5).append(" dk:").append(decoderCounters.droppedToKeyframeCount).toString();
    }

    private static String getPixelAspectRatioString(float f2) {
        if (f2 == -1.0f || f2 == 1.0f) {
            return "";
        }
        String strValueOf = String.valueOf(String.format(Locale.US, "%.02f", Float.valueOf(f2)));
        return strValueOf.length() != 0 ? " par:".concat(strValueOf) : new String(" par:");
    }

    private static String getVideoFrameProcessingOffsetAverageString(long j, int i) {
        if (i == 0) {
            return "N/A";
        }
        return String.valueOf((long) (j / ((double) i)));
    }
}
