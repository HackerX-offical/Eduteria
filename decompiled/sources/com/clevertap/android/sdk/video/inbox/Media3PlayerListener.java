package com.clevertap.android.sdk.video.inbox;

import androidx.media3.common.AudioAttributes;
import androidx.media3.common.DeviceInfo;
import androidx.media3.common.MediaItem;
import androidx.media3.common.MediaMetadata;
import androidx.media3.common.PlaybackException;
import androidx.media3.common.PlaybackParameters;
import androidx.media3.common.Player;
import androidx.media3.common.Timeline;
import androidx.media3.common.TrackSelectionParameters;
import androidx.media3.common.Tracks;
import androidx.media3.common.VideoSize;
import androidx.media3.common.text.Cue;
import androidx.media3.common.text.CueGroup;
import com.facebook.appevents.internal.ViewHierarchyConstants;
import com.google.firebase.dynamiclinks.DynamicLink;
import java.util.List;
import kotlin.Deprecated;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: compiled from: Media3PlayerListener.kt */
/* JADX INFO: loaded from: classes7.dex */
@Metadata(d1 = {"\u0000¸\u0001\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0004\n\u0002\u0010!\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\f\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\t\n\u0002\b\b\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0007\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0000\b\u0017\u0018\u00002\u00020\u0001B\u0007¢\u0006\u0004\b\u0002\u0010\u0003J\u0018\u0010\u0004\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u00072\u0006\u0010\b\u001a\u00020\u0007H\u0016J\b\u0010\t\u001a\u00020\u0005H\u0016J\u0016\u0010\n\u001a\u00020\u00052\f\u0010\u000b\u001a\b\u0012\u0004\u0012\u00020\r0\fH\u0017J\u0010\u0010\n\u001a\u00020\u00052\u0006\u0010\u000e\u001a\u00020\u000fH\u0016J\u0010\u0010\u0010\u001a\u00020\u00052\u0006\u0010\u0011\u001a\u00020\u0012H\u0016J\u0018\u0010\u0013\u001a\u00020\u00052\u0006\u0010\u0014\u001a\u00020\u00152\u0006\u0010\u0016\u001a\u00020\u0017H\u0016J\u0018\u0010\u0018\u001a\u00020\u00052\u0006\u0010\u0019\u001a\u00020\u001a2\u0006\u0010\u001b\u001a\u00020\u0007H\u0016J\u001a\u0010\u001c\u001a\u00020\u00052\b\u0010\u001d\u001a\u0004\u0018\u00010\u001e2\u0006\u0010\u001b\u001a\u00020\u0007H\u0016J\u0010\u0010\u001f\u001a\u00020\u00052\u0006\u0010 \u001a\u00020!H\u0016J\u0010\u0010\"\u001a\u00020\u00052\u0006\u0010#\u001a\u00020$H\u0016J\u0010\u0010%\u001a\u00020\u00052\u0006\u0010#\u001a\u00020$H\u0016J\u0010\u0010&\u001a\u00020\u00052\u0006\u0010'\u001a\u00020(H\u0016J\u0010\u0010)\u001a\u00020\u00052\u0006\u0010*\u001a\u00020+H\u0016J\u0010\u0010,\u001a\u00020\u00052\u0006\u0010-\u001a\u00020.H\u0016J\u0018\u0010/\u001a\u00020\u00052\u0006\u00100\u001a\u00020(2\u0006\u0010\u001b\u001a\u00020\u0007H\u0016J\u0010\u00101\u001a\u00020\u00052\u0006\u00102\u001a\u00020\u0007H\u0016J\u0010\u00103\u001a\u00020\u00052\u0006\u00104\u001a\u00020(H\u0016J\u0010\u00105\u001a\u00020\u00052\u0006\u00106\u001a\u00020\u0007H\u0016J\u0010\u00107\u001a\u00020\u00052\u0006\u00108\u001a\u00020(H\u0016J\u0010\u00109\u001a\u00020\u00052\u0006\u0010:\u001a\u00020;H\u0016J\u0012\u0010<\u001a\u00020\u00052\b\u0010:\u001a\u0004\u0018\u00010;H\u0016J \u0010=\u001a\u00020\u00052\u0006\u0010>\u001a\u00020?2\u0006\u0010@\u001a\u00020?2\u0006\u0010\u001b\u001a\u00020\u0007H\u0016J\u0010\u0010A\u001a\u00020\u00052\u0006\u0010B\u001a\u00020CH\u0016J\u0010\u0010D\u001a\u00020\u00052\u0006\u0010E\u001a\u00020FH\u0016J\u0010\u0010G\u001a\u00020\u00052\u0006\u0010H\u001a\u00020FH\u0016J\u0010\u0010I\u001a\u00020\u00052\u0006\u0010J\u001a\u00020FH\u0016J\u0010\u0010K\u001a\u00020\u00052\u0006\u0010L\u001a\u00020\u0007H\u0016J\u0010\u0010M\u001a\u00020\u00052\u0006\u0010N\u001a\u00020OH\u0016J\u0010\u0010P\u001a\u00020\u00052\u0006\u0010Q\u001a\u00020RH\u0016J\u0010\u0010S\u001a\u00020\u00052\u0006\u0010T\u001a\u00020(H\u0016J\u0010\u0010U\u001a\u00020\u00052\u0006\u0010V\u001a\u00020WH\u0016J\u0018\u0010X\u001a\u00020\u00052\u0006\u0010Q\u001a\u00020\u00072\u0006\u0010Y\u001a\u00020(H\u0016J\u0010\u0010Z\u001a\u00020\u00052\u0006\u0010[\u001a\u00020\\H\u0016¨\u0006]"}, d2 = {"Lcom/clevertap/android/sdk/video/inbox/Media3PlayerListener;", "Landroidx/media3/common/Player$Listener;", "<init>", "()V", "onSurfaceSizeChanged", "", ViewHierarchyConstants.DIMENSION_WIDTH_KEY, "", ViewHierarchyConstants.DIMENSION_HEIGHT_KEY, "onRenderedFirstFrame", "onCues", "cues", "", "Landroidx/media3/common/text/Cue;", "cueGroup", "Landroidx/media3/common/text/CueGroup;", "onMetadata", "metadata", "Landroidx/media3/common/Metadata;", "onEvents", "player", "Landroidx/media3/common/Player;", "events", "Landroidx/media3/common/Player$Events;", "onTimelineChanged", "timeline", "Landroidx/media3/common/Timeline;", "reason", "onMediaItemTransition", "mediaItem", "Landroidx/media3/common/MediaItem;", "onTracksChanged", "tracks", "Landroidx/media3/common/Tracks;", "onMediaMetadataChanged", "mediaMetadata", "Landroidx/media3/common/MediaMetadata;", "onPlaylistMetadataChanged", "onIsLoadingChanged", "isLoading", "", "onAvailableCommandsChanged", "availableCommands", "Landroidx/media3/common/Player$Commands;", "onTrackSelectionParametersChanged", DynamicLink.Builder.KEY_DYNAMIC_LINK_PARAMETERS, "Landroidx/media3/common/TrackSelectionParameters;", "onPlayWhenReadyChanged", "playWhenReady", "onPlaybackSuppressionReasonChanged", "playbackSuppressionReason", "onIsPlayingChanged", "isPlaying", "onRepeatModeChanged", "repeatMode", "onShuffleModeEnabledChanged", "shuffleModeEnabled", "onPlayerError", "error", "Landroidx/media3/common/PlaybackException;", "onPlayerErrorChanged", "onPositionDiscontinuity", "oldPosition", "Landroidx/media3/common/Player$PositionInfo;", "newPosition", "onPlaybackParametersChanged", "playbackParameters", "Landroidx/media3/common/PlaybackParameters;", "onSeekBackIncrementChanged", "seekBackIncrementMs", "", "onSeekForwardIncrementChanged", "seekForwardIncrementMs", "onMaxSeekToPreviousPositionChanged", "maxSeekToPreviousPositionMs", "onAudioSessionIdChanged", "audioSessionId", "onAudioAttributesChanged", "audioAttributes", "Landroidx/media3/common/AudioAttributes;", "onVolumeChanged", "volume", "", "onSkipSilenceEnabledChanged", "skipSilenceEnabled", "onDeviceInfoChanged", "deviceInfo", "Landroidx/media3/common/DeviceInfo;", "onDeviceVolumeChanged", "muted", "onVideoSizeChanged", "videoSize", "Landroidx/media3/common/VideoSize;", "clevertap-core_release"}, k = 1, mv = {2, 0, 0}, xi = 48)
public class Media3PlayerListener implements Player.Listener {
    @Override // androidx.media3.common.Player.Listener
    public void onAudioAttributesChanged(AudioAttributes audioAttributes) {
        Intrinsics.checkNotNullParameter(audioAttributes, "audioAttributes");
    }

    @Override // androidx.media3.common.Player.Listener
    public void onAudioSessionIdChanged(int audioSessionId) {
    }

    @Override // androidx.media3.common.Player.Listener
    public void onAvailableCommandsChanged(Player.Commands availableCommands) {
        Intrinsics.checkNotNullParameter(availableCommands, "availableCommands");
    }

    @Override // androidx.media3.common.Player.Listener
    public void onCues(CueGroup cueGroup) {
        Intrinsics.checkNotNullParameter(cueGroup, "cueGroup");
    }

    @Override // androidx.media3.common.Player.Listener
    @Deprecated(message = "Deprecated in Java")
    public void onCues(List<Cue> cues) {
        Intrinsics.checkNotNullParameter(cues, "cues");
    }

    @Override // androidx.media3.common.Player.Listener
    public void onDeviceInfoChanged(DeviceInfo deviceInfo) {
        Intrinsics.checkNotNullParameter(deviceInfo, "deviceInfo");
    }

    @Override // androidx.media3.common.Player.Listener
    public void onDeviceVolumeChanged(int volume, boolean muted) {
    }

    @Override // androidx.media3.common.Player.Listener
    public void onEvents(Player player, Player.Events events) {
        Intrinsics.checkNotNullParameter(player, "player");
        Intrinsics.checkNotNullParameter(events, "events");
    }

    @Override // androidx.media3.common.Player.Listener
    public void onIsLoadingChanged(boolean isLoading) {
    }

    @Override // androidx.media3.common.Player.Listener
    public void onIsPlayingChanged(boolean isPlaying) {
    }

    @Override // androidx.media3.common.Player.Listener
    public void onMaxSeekToPreviousPositionChanged(long maxSeekToPreviousPositionMs) {
    }

    @Override // androidx.media3.common.Player.Listener
    public void onMediaItemTransition(MediaItem mediaItem, int reason) {
    }

    @Override // androidx.media3.common.Player.Listener
    public void onMediaMetadataChanged(MediaMetadata mediaMetadata) {
        Intrinsics.checkNotNullParameter(mediaMetadata, "mediaMetadata");
    }

    @Override // androidx.media3.common.Player.Listener
    public void onMetadata(androidx.media3.common.Metadata metadata) {
        Intrinsics.checkNotNullParameter(metadata, "metadata");
    }

    @Override // androidx.media3.common.Player.Listener
    public void onPlayWhenReadyChanged(boolean playWhenReady, int reason) {
    }

    @Override // androidx.media3.common.Player.Listener
    public void onPlaybackParametersChanged(PlaybackParameters playbackParameters) {
        Intrinsics.checkNotNullParameter(playbackParameters, "playbackParameters");
    }

    @Override // androidx.media3.common.Player.Listener
    public void onPlaybackSuppressionReasonChanged(int playbackSuppressionReason) {
    }

    @Override // androidx.media3.common.Player.Listener
    public void onPlayerError(PlaybackException error) {
        Intrinsics.checkNotNullParameter(error, "error");
    }

    @Override // androidx.media3.common.Player.Listener
    public void onPlayerErrorChanged(PlaybackException error) {
    }

    @Override // androidx.media3.common.Player.Listener
    public void onPlaylistMetadataChanged(MediaMetadata mediaMetadata) {
        Intrinsics.checkNotNullParameter(mediaMetadata, "mediaMetadata");
    }

    @Override // androidx.media3.common.Player.Listener
    public void onPositionDiscontinuity(Player.PositionInfo oldPosition, Player.PositionInfo newPosition, int reason) {
        Intrinsics.checkNotNullParameter(oldPosition, "oldPosition");
        Intrinsics.checkNotNullParameter(newPosition, "newPosition");
    }

    @Override // androidx.media3.common.Player.Listener
    public void onRenderedFirstFrame() {
    }

    @Override // androidx.media3.common.Player.Listener
    public void onRepeatModeChanged(int repeatMode) {
    }

    @Override // androidx.media3.common.Player.Listener
    public void onSeekBackIncrementChanged(long seekBackIncrementMs) {
    }

    @Override // androidx.media3.common.Player.Listener
    public void onSeekForwardIncrementChanged(long seekForwardIncrementMs) {
    }

    @Override // androidx.media3.common.Player.Listener
    public void onShuffleModeEnabledChanged(boolean shuffleModeEnabled) {
    }

    @Override // androidx.media3.common.Player.Listener
    public void onSkipSilenceEnabledChanged(boolean skipSilenceEnabled) {
    }

    @Override // androidx.media3.common.Player.Listener
    public void onSurfaceSizeChanged(int width, int height) {
    }

    @Override // androidx.media3.common.Player.Listener
    public void onTimelineChanged(Timeline timeline, int reason) {
        Intrinsics.checkNotNullParameter(timeline, "timeline");
    }

    @Override // androidx.media3.common.Player.Listener
    public void onTrackSelectionParametersChanged(TrackSelectionParameters parameters) {
        Intrinsics.checkNotNullParameter(parameters, "parameters");
    }

    @Override // androidx.media3.common.Player.Listener
    public void onTracksChanged(Tracks tracks) {
        Intrinsics.checkNotNullParameter(tracks, "tracks");
    }

    @Override // androidx.media3.common.Player.Listener
    public void onVideoSizeChanged(VideoSize videoSize) {
        Intrinsics.checkNotNullParameter(videoSize, "videoSize");
    }

    @Override // androidx.media3.common.Player.Listener
    public void onVolumeChanged(float volume) {
    }
}
