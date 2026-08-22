package com.clevertap.android.sdk.video.inbox;

import com.facebook.appevents.internal.ViewHierarchyConstants;
import com.google.android.exoplayer2.DeviceInfo;
import com.google.android.exoplayer2.MediaItem;
import com.google.android.exoplayer2.MediaMetadata;
import com.google.android.exoplayer2.PlaybackException;
import com.google.android.exoplayer2.PlaybackParameters;
import com.google.android.exoplayer2.Player;
import com.google.android.exoplayer2.Timeline;
import com.google.android.exoplayer2.Tracks;
import com.google.android.exoplayer2.audio.AudioAttributes;
import com.google.android.exoplayer2.text.Cue;
import com.google.android.exoplayer2.text.CueGroup;
import com.google.android.exoplayer2.trackselection.TrackSelectionParameters;
import com.google.android.exoplayer2.video.VideoSize;
import com.google.firebase.dynamiclinks.DynamicLink;
import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: compiled from: ExoplayerPlayerListener.kt */
/* JADX INFO: loaded from: classes7.dex */
@Metadata(d1 = {"\u0000¶\u0001\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u000e\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\t\n\u0002\b\b\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0007\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0010!\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\b\u0016\u0018\u00002\u00020\u0001B\u0007¢\u0006\u0004\b\u0002\u0010\u0003J\u0018\u0010\u0004\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u00072\u0006\u0010\b\u001a\u00020\tH\u0016J\u0018\u0010\n\u001a\u00020\u00052\u0006\u0010\u000b\u001a\u00020\f2\u0006\u0010\r\u001a\u00020\u000eH\u0016J\u001a\u0010\u000f\u001a\u00020\u00052\b\u0010\u0010\u001a\u0004\u0018\u00010\u00112\u0006\u0010\r\u001a\u00020\u000eH\u0016J\u0010\u0010\u0012\u001a\u00020\u00052\u0006\u0010\u0013\u001a\u00020\u0014H\u0016J\u0010\u0010\u0015\u001a\u00020\u00052\u0006\u0010\u0016\u001a\u00020\u0017H\u0016J\u0010\u0010\u0018\u001a\u00020\u00052\u0006\u0010\u0016\u001a\u00020\u0017H\u0016J\u0010\u0010\u0019\u001a\u00020\u00052\u0006\u0010\u001a\u001a\u00020\u001bH\u0016J\u0010\u0010\u001c\u001a\u00020\u00052\u0006\u0010\u001d\u001a\u00020\u001eH\u0016J\u0010\u0010\u001f\u001a\u00020\u00052\u0006\u0010 \u001a\u00020!H\u0016J\u0018\u0010\"\u001a\u00020\u00052\u0006\u0010#\u001a\u00020\u001b2\u0006\u0010$\u001a\u00020\u000eH\u0016J\u0018\u0010%\u001a\u00020\u00052\u0006\u0010#\u001a\u00020\u001b2\u0006\u0010\r\u001a\u00020\u000eH\u0016J\u0010\u0010&\u001a\u00020\u00052\u0006\u0010'\u001a\u00020\u000eH\u0016J\u0010\u0010(\u001a\u00020\u00052\u0006\u0010)\u001a\u00020\u001bH\u0016J\u0010\u0010*\u001a\u00020\u00052\u0006\u0010+\u001a\u00020\u000eH\u0016J\u0010\u0010,\u001a\u00020\u00052\u0006\u0010-\u001a\u00020\u001bH\u0016J\u0010\u0010.\u001a\u00020\u00052\u0006\u0010/\u001a\u000200H\u0016J\u0012\u00101\u001a\u00020\u00052\b\u0010/\u001a\u0004\u0018\u000100H\u0016J\u0010\u00102\u001a\u00020\u00052\u0006\u0010\r\u001a\u00020\u000eH\u0016J \u00102\u001a\u00020\u00052\u0006\u00103\u001a\u0002042\u0006\u00105\u001a\u0002042\u0006\u0010\r\u001a\u00020\u000eH\u0016J\u0010\u00106\u001a\u00020\u00052\u0006\u00107\u001a\u000208H\u0016J\u0010\u00109\u001a\u00020\u00052\u0006\u0010:\u001a\u00020;H\u0016J\u0010\u0010<\u001a\u00020\u00052\u0006\u0010=\u001a\u00020;H\u0016J\u0010\u0010>\u001a\u00020\u00052\u0006\u0010?\u001a\u00020;H\u0016J\u0010\u0010@\u001a\u00020\u00052\u0006\u0010A\u001a\u00020\u000eH\u0016J\u0010\u0010B\u001a\u00020\u00052\u0006\u0010C\u001a\u00020DH\u0016J\u0010\u0010E\u001a\u00020\u00052\u0006\u0010F\u001a\u00020GH\u0016J\u0010\u0010H\u001a\u00020\u00052\u0006\u0010I\u001a\u00020\u001bH\u0016J\u0010\u0010J\u001a\u00020\u00052\u0006\u0010K\u001a\u00020LH\u0016J\u0018\u0010M\u001a\u00020\u00052\u0006\u0010F\u001a\u00020\u000e2\u0006\u0010N\u001a\u00020\u001bH\u0016J\u0010\u0010O\u001a\u00020\u00052\u0006\u0010P\u001a\u00020QH\u0016J\u0018\u0010R\u001a\u00020\u00052\u0006\u0010S\u001a\u00020\u000e2\u0006\u0010T\u001a\u00020\u000eH\u0016J\b\u0010U\u001a\u00020\u0005H\u0016J\u0016\u0010V\u001a\u00020\u00052\f\u0010W\u001a\b\u0012\u0004\u0012\u00020Y0XH\u0016J\u0010\u0010V\u001a\u00020\u00052\u0006\u0010Z\u001a\u00020[H\u0016J\u0010\u0010\\\u001a\u00020\u00052\u0006\u0010]\u001a\u00020^H\u0016¨\u0006_"}, d2 = {"Lcom/clevertap/android/sdk/video/inbox/ExoplayerPlayerListener;", "Lcom/google/android/exoplayer2/Player$Listener;", "<init>", "()V", "onEvents", "", "player", "Lcom/google/android/exoplayer2/Player;", "events", "Lcom/google/android/exoplayer2/Player$Events;", "onTimelineChanged", "timeline", "Lcom/google/android/exoplayer2/Timeline;", "reason", "", "onMediaItemTransition", "mediaItem", "Lcom/google/android/exoplayer2/MediaItem;", "onTracksChanged", "tracks", "Lcom/google/android/exoplayer2/Tracks;", "onMediaMetadataChanged", "mediaMetadata", "Lcom/google/android/exoplayer2/MediaMetadata;", "onPlaylistMetadataChanged", "onIsLoadingChanged", "isLoading", "", "onAvailableCommandsChanged", "availableCommands", "Lcom/google/android/exoplayer2/Player$Commands;", "onTrackSelectionParametersChanged", DynamicLink.Builder.KEY_DYNAMIC_LINK_PARAMETERS, "Lcom/google/android/exoplayer2/trackselection/TrackSelectionParameters;", "onPlayerStateChanged", "playWhenReady", "playbackState", "onPlayWhenReadyChanged", "onPlaybackSuppressionReasonChanged", "playbackSuppressionReason", "onIsPlayingChanged", "isPlaying", "onRepeatModeChanged", "repeatMode", "onShuffleModeEnabledChanged", "shuffleModeEnabled", "onPlayerError", "error", "Lcom/google/android/exoplayer2/PlaybackException;", "onPlayerErrorChanged", "onPositionDiscontinuity", "oldPosition", "Lcom/google/android/exoplayer2/Player$PositionInfo;", "newPosition", "onPlaybackParametersChanged", "playbackParameters", "Lcom/google/android/exoplayer2/PlaybackParameters;", "onSeekBackIncrementChanged", "seekBackIncrementMs", "", "onSeekForwardIncrementChanged", "seekForwardIncrementMs", "onMaxSeekToPreviousPositionChanged", "maxSeekToPreviousPositionMs", "onAudioSessionIdChanged", "audioSessionId", "onAudioAttributesChanged", "audioAttributes", "Lcom/google/android/exoplayer2/audio/AudioAttributes;", "onVolumeChanged", "volume", "", "onSkipSilenceEnabledChanged", "skipSilenceEnabled", "onDeviceInfoChanged", "deviceInfo", "Lcom/google/android/exoplayer2/DeviceInfo;", "onDeviceVolumeChanged", "muted", "onVideoSizeChanged", "videoSize", "Lcom/google/android/exoplayer2/video/VideoSize;", "onSurfaceSizeChanged", ViewHierarchyConstants.DIMENSION_WIDTH_KEY, ViewHierarchyConstants.DIMENSION_HEIGHT_KEY, "onRenderedFirstFrame", "onCues", "cues", "", "Lcom/google/android/exoplayer2/text/Cue;", "cueGroup", "Lcom/google/android/exoplayer2/text/CueGroup;", "onMetadata", "metadata", "Lcom/google/android/exoplayer2/metadata/Metadata;", "clevertap-core_release"}, k = 1, mv = {2, 0, 0}, xi = 48)
public class ExoplayerPlayerListener implements Player.Listener {
    @Override // com.google.android.exoplayer2.Player.Listener
    public void onAudioAttributesChanged(AudioAttributes audioAttributes) {
        Intrinsics.checkNotNullParameter(audioAttributes, "audioAttributes");
    }

    @Override // com.google.android.exoplayer2.Player.Listener
    public void onAudioSessionIdChanged(int audioSessionId) {
    }

    @Override // com.google.android.exoplayer2.Player.Listener
    public void onAvailableCommandsChanged(Player.Commands availableCommands) {
        Intrinsics.checkNotNullParameter(availableCommands, "availableCommands");
    }

    public void onCues(CueGroup cueGroup) {
        Intrinsics.checkNotNullParameter(cueGroup, "cueGroup");
    }

    @Override // com.google.android.exoplayer2.Player.Listener
    public void onCues(List<Cue> cues) {
        Intrinsics.checkNotNullParameter(cues, "cues");
    }

    @Override // com.google.android.exoplayer2.Player.Listener
    public void onDeviceInfoChanged(DeviceInfo deviceInfo) {
        Intrinsics.checkNotNullParameter(deviceInfo, "deviceInfo");
    }

    @Override // com.google.android.exoplayer2.Player.Listener
    public void onDeviceVolumeChanged(int volume, boolean muted) {
    }

    @Override // com.google.android.exoplayer2.Player.Listener
    public void onEvents(Player player, Player.Events events) {
        Intrinsics.checkNotNullParameter(player, "player");
        Intrinsics.checkNotNullParameter(events, "events");
    }

    @Override // com.google.android.exoplayer2.Player.Listener
    public void onIsLoadingChanged(boolean isLoading) {
    }

    @Override // com.google.android.exoplayer2.Player.Listener
    public void onIsPlayingChanged(boolean isPlaying) {
    }

    @Override // com.google.android.exoplayer2.Player.Listener
    public void onMaxSeekToPreviousPositionChanged(long maxSeekToPreviousPositionMs) {
    }

    @Override // com.google.android.exoplayer2.Player.Listener
    public void onMediaItemTransition(MediaItem mediaItem, int reason) {
    }

    @Override // com.google.android.exoplayer2.Player.Listener
    public void onMediaMetadataChanged(MediaMetadata mediaMetadata) {
        Intrinsics.checkNotNullParameter(mediaMetadata, "mediaMetadata");
    }

    @Override // com.google.android.exoplayer2.Player.Listener
    public void onMetadata(com.google.android.exoplayer2.metadata.Metadata metadata) {
        Intrinsics.checkNotNullParameter(metadata, "metadata");
    }

    @Override // com.google.android.exoplayer2.Player.Listener
    public void onPlayWhenReadyChanged(boolean playWhenReady, int reason) {
    }

    @Override // com.google.android.exoplayer2.Player.Listener
    public void onPlaybackParametersChanged(PlaybackParameters playbackParameters) {
        Intrinsics.checkNotNullParameter(playbackParameters, "playbackParameters");
    }

    @Override // com.google.android.exoplayer2.Player.Listener
    public void onPlaybackSuppressionReasonChanged(int playbackSuppressionReason) {
    }

    @Override // com.google.android.exoplayer2.Player.Listener
    public void onPlayerError(PlaybackException error) {
        Intrinsics.checkNotNullParameter(error, "error");
    }

    @Override // com.google.android.exoplayer2.Player.Listener
    public void onPlayerErrorChanged(PlaybackException error) {
    }

    @Override // com.google.android.exoplayer2.Player.Listener
    public void onPlayerStateChanged(boolean playWhenReady, int playbackState) {
    }

    @Override // com.google.android.exoplayer2.Player.Listener
    public void onPlaylistMetadataChanged(MediaMetadata mediaMetadata) {
        Intrinsics.checkNotNullParameter(mediaMetadata, "mediaMetadata");
    }

    @Override // com.google.android.exoplayer2.Player.Listener
    public void onPositionDiscontinuity(int reason) {
    }

    @Override // com.google.android.exoplayer2.Player.Listener
    public void onPositionDiscontinuity(Player.PositionInfo oldPosition, Player.PositionInfo newPosition, int reason) {
        Intrinsics.checkNotNullParameter(oldPosition, "oldPosition");
        Intrinsics.checkNotNullParameter(newPosition, "newPosition");
    }

    @Override // com.google.android.exoplayer2.Player.Listener
    public void onRenderedFirstFrame() {
    }

    @Override // com.google.android.exoplayer2.Player.Listener
    public void onRepeatModeChanged(int repeatMode) {
    }

    @Override // com.google.android.exoplayer2.Player.Listener
    public void onSeekBackIncrementChanged(long seekBackIncrementMs) {
    }

    @Override // com.google.android.exoplayer2.Player.Listener
    public void onSeekForwardIncrementChanged(long seekForwardIncrementMs) {
    }

    @Override // com.google.android.exoplayer2.Player.Listener
    public void onShuffleModeEnabledChanged(boolean shuffleModeEnabled) {
    }

    @Override // com.google.android.exoplayer2.Player.Listener
    public void onSkipSilenceEnabledChanged(boolean skipSilenceEnabled) {
    }

    @Override // com.google.android.exoplayer2.Player.Listener
    public void onSurfaceSizeChanged(int width, int height) {
    }

    @Override // com.google.android.exoplayer2.Player.Listener
    public void onTimelineChanged(Timeline timeline, int reason) {
        Intrinsics.checkNotNullParameter(timeline, "timeline");
    }

    @Override // com.google.android.exoplayer2.Player.Listener
    public void onTrackSelectionParametersChanged(TrackSelectionParameters parameters) {
        Intrinsics.checkNotNullParameter(parameters, "parameters");
    }

    public void onTracksChanged(Tracks tracks) {
        Intrinsics.checkNotNullParameter(tracks, "tracks");
    }

    @Override // com.google.android.exoplayer2.Player.Listener
    public void onVideoSizeChanged(VideoSize videoSize) {
        Intrinsics.checkNotNullParameter(videoSize, "videoSize");
    }

    @Override // com.google.android.exoplayer2.Player.Listener
    public void onVolumeChanged(float volume) {
    }
}
