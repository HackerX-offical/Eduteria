package com.google.android.exoplayer2.util;

import android.text.TextUtils;
import com.clevertap.android.sdk.Constants;
import com.google.android.exoplayer2.Format;
import com.google.android.exoplayer2.MediaItem;
import com.google.android.exoplayer2.PlaybackException;
import com.google.android.exoplayer2.PlaybackParameters;
import com.google.android.exoplayer2.Player;
import com.google.android.exoplayer2.RendererCapabilities;
import com.google.android.exoplayer2.Timeline;
import com.google.android.exoplayer2.analytics.AnalyticsListener;
import com.google.android.exoplayer2.audio.AudioAttributes;
import com.google.android.exoplayer2.decoder.DecoderCounters;
import com.google.android.exoplayer2.decoder.DecoderReuseEvaluation;
import com.google.android.exoplayer2.metadata.Metadata;
import com.google.android.exoplayer2.source.LoadEventInfo;
import com.google.android.exoplayer2.source.MediaLoadData;
import com.google.android.exoplayer2.source.TrackGroup;
import com.google.android.exoplayer2.source.TrackGroupArray;
import com.google.android.exoplayer2.trackselection.MappingTrackSelector;
import com.google.android.exoplayer2.trackselection.TrackSelection;
import com.google.android.exoplayer2.trackselection.TrackSelectionArray;
import com.google.android.exoplayer2.video.VideoSize;
import java.io.IOException;
import java.text.NumberFormat;
import java.util.Locale;
import okhttp3.HttpUrl;

/* JADX INFO: loaded from: classes7.dex */
public class EventLogger implements AnalyticsListener {
    private static final String DEFAULT_TAG = "EventLogger";
    private static final int MAX_TIMELINE_ITEM_LINES = 3;
    private static final NumberFormat TIME_FORMAT;
    private final Timeline.Period period;
    private final long startTimeMs;
    private final String tag;
    private final MappingTrackSelector trackSelector;
    private final Timeline.Window window;

    @Override // com.google.android.exoplayer2.analytics.AnalyticsListener
    public void onBandwidthEstimate(AnalyticsListener.EventTime eventTime, int i, long j, long j2) {
    }

    @Override // com.google.android.exoplayer2.analytics.AnalyticsListener
    public void onLoadCanceled(AnalyticsListener.EventTime eventTime, LoadEventInfo loadEventInfo, MediaLoadData mediaLoadData) {
    }

    @Override // com.google.android.exoplayer2.analytics.AnalyticsListener
    public void onLoadCompleted(AnalyticsListener.EventTime eventTime, LoadEventInfo loadEventInfo, MediaLoadData mediaLoadData) {
    }

    @Override // com.google.android.exoplayer2.analytics.AnalyticsListener
    public void onLoadStarted(AnalyticsListener.EventTime eventTime, LoadEventInfo loadEventInfo, MediaLoadData mediaLoadData) {
    }

    static {
        NumberFormat numberFormat = NumberFormat.getInstance(Locale.US);
        TIME_FORMAT = numberFormat;
        numberFormat.setMinimumFractionDigits(2);
        numberFormat.setMaximumFractionDigits(2);
        numberFormat.setGroupingUsed(false);
    }

    public EventLogger(MappingTrackSelector mappingTrackSelector) {
        this(mappingTrackSelector, DEFAULT_TAG);
    }

    public EventLogger(MappingTrackSelector mappingTrackSelector, String str) {
        this.trackSelector = mappingTrackSelector;
        this.tag = str;
        this.window = new Timeline.Window();
        this.period = new Timeline.Period();
        this.startTimeMs = android.os.SystemClock.elapsedRealtime();
    }

    @Override // com.google.android.exoplayer2.analytics.AnalyticsListener
    public void onIsLoadingChanged(AnalyticsListener.EventTime eventTime, boolean z) {
        logd(eventTime, "loading", Boolean.toString(z));
    }

    @Override // com.google.android.exoplayer2.analytics.AnalyticsListener
    public void onPlaybackStateChanged(AnalyticsListener.EventTime eventTime, int i) {
        logd(eventTime, "state", getStateString(i));
    }

    @Override // com.google.android.exoplayer2.analytics.AnalyticsListener
    public void onPlayWhenReadyChanged(AnalyticsListener.EventTime eventTime, boolean z, int i) {
        String playWhenReadyChangeReasonString = getPlayWhenReadyChangeReasonString(i);
        logd(eventTime, "playWhenReady", new StringBuilder(String.valueOf(playWhenReadyChangeReasonString).length() + 7).append(z).append(", ").append(playWhenReadyChangeReasonString).toString());
    }

    @Override // com.google.android.exoplayer2.analytics.AnalyticsListener
    public void onPlaybackSuppressionReasonChanged(AnalyticsListener.EventTime eventTime, int i) {
        logd(eventTime, "playbackSuppressionReason", getPlaybackSuppressionReasonString(i));
    }

    @Override // com.google.android.exoplayer2.analytics.AnalyticsListener
    public void onIsPlayingChanged(AnalyticsListener.EventTime eventTime, boolean z) {
        logd(eventTime, "isPlaying", Boolean.toString(z));
    }

    @Override // com.google.android.exoplayer2.analytics.AnalyticsListener
    public void onRepeatModeChanged(AnalyticsListener.EventTime eventTime, int i) {
        logd(eventTime, "repeatMode", getRepeatModeString(i));
    }

    @Override // com.google.android.exoplayer2.analytics.AnalyticsListener
    public void onShuffleModeChanged(AnalyticsListener.EventTime eventTime, boolean z) {
        logd(eventTime, "shuffleModeEnabled", Boolean.toString(z));
    }

    @Override // com.google.android.exoplayer2.analytics.AnalyticsListener
    public void onPositionDiscontinuity(AnalyticsListener.EventTime eventTime, Player.PositionInfo positionInfo, Player.PositionInfo positionInfo2, int i) {
        StringBuilder sb = new StringBuilder("reason=");
        sb.append(getDiscontinuityReasonString(i)).append(", PositionInfo:old [mediaItem=").append(positionInfo.mediaItemIndex).append(", period=").append(positionInfo.periodIndex).append(", pos=").append(positionInfo.positionMs);
        if (positionInfo.adGroupIndex != -1) {
            sb.append(", contentPos=").append(positionInfo.contentPositionMs).append(", adGroup=").append(positionInfo.adGroupIndex).append(", ad=").append(positionInfo.adIndexInAdGroup);
        }
        sb.append("], PositionInfo:new [mediaItem=").append(positionInfo2.mediaItemIndex).append(", period=").append(positionInfo2.periodIndex).append(", pos=").append(positionInfo2.positionMs);
        if (positionInfo2.adGroupIndex != -1) {
            sb.append(", contentPos=").append(positionInfo2.contentPositionMs).append(", adGroup=").append(positionInfo2.adGroupIndex).append(", ad=").append(positionInfo2.adIndexInAdGroup);
        }
        sb.append(Constants.AES_SUFFIX);
        logd(eventTime, "positionDiscontinuity", sb.toString());
    }

    @Override // com.google.android.exoplayer2.analytics.AnalyticsListener
    public void onPlaybackParametersChanged(AnalyticsListener.EventTime eventTime, PlaybackParameters playbackParameters) {
        logd(eventTime, "playbackParameters", playbackParameters.toString());
    }

    @Override // com.google.android.exoplayer2.analytics.AnalyticsListener
    public void onTimelineChanged(AnalyticsListener.EventTime eventTime, int i) {
        int periodCount = eventTime.timeline.getPeriodCount();
        int windowCount = eventTime.timeline.getWindowCount();
        String eventTimeString = getEventTimeString(eventTime);
        String timelineChangeReasonString = getTimelineChangeReasonString(i);
        logd(new StringBuilder(String.valueOf(eventTimeString).length() + 69 + String.valueOf(timelineChangeReasonString).length()).append("timeline [").append(eventTimeString).append(", periodCount=").append(periodCount).append(", windowCount=").append(windowCount).append(", reason=").append(timelineChangeReasonString).toString());
        for (int i2 = 0; i2 < Math.min(periodCount, 3); i2++) {
            eventTime.timeline.getPeriod(i2, this.period);
            String timeString = getTimeString(this.period.getDurationMs());
            logd(new StringBuilder(String.valueOf(timeString).length() + 11).append("  period [").append(timeString).append(Constants.AES_SUFFIX).toString());
        }
        if (periodCount > 3) {
            logd("  ...");
        }
        for (int i3 = 0; i3 < Math.min(windowCount, 3); i3++) {
            eventTime.timeline.getWindow(i3, this.window);
            String timeString2 = getTimeString(this.window.getDurationMs());
            logd(new StringBuilder(String.valueOf(timeString2).length() + 42).append("  window [").append(timeString2).append(", seekable=").append(this.window.isSeekable).append(", dynamic=").append(this.window.isDynamic).append(Constants.AES_SUFFIX).toString());
        }
        if (windowCount > 3) {
            logd("  ...");
        }
        logd(Constants.AES_SUFFIX);
    }

    @Override // com.google.android.exoplayer2.analytics.AnalyticsListener
    public void onMediaItemTransition(AnalyticsListener.EventTime eventTime, MediaItem mediaItem, int i) {
        String eventTimeString = getEventTimeString(eventTime);
        String mediaItemTransitionReasonString = getMediaItemTransitionReasonString(i);
        logd(new StringBuilder(String.valueOf(eventTimeString).length() + 21 + String.valueOf(mediaItemTransitionReasonString).length()).append("mediaItem [").append(eventTimeString).append(", reason=").append(mediaItemTransitionReasonString).append(Constants.AES_SUFFIX).toString());
    }

    @Override // com.google.android.exoplayer2.analytics.AnalyticsListener
    public void onPlayerError(AnalyticsListener.EventTime eventTime, PlaybackException playbackException) {
        loge(eventTime, "playerFailed", playbackException);
    }

    @Override // com.google.android.exoplayer2.analytics.AnalyticsListener
    public void onTracksChanged(AnalyticsListener.EventTime eventTime, TrackGroupArray trackGroupArray, TrackSelectionArray trackSelectionArray) {
        MappingTrackSelector.MappedTrackInfo mappedTrackInfo;
        int i;
        MappingTrackSelector mappingTrackSelector = this.trackSelector;
        MappingTrackSelector.MappedTrackInfo currentMappedTrackInfo = mappingTrackSelector != null ? mappingTrackSelector.getCurrentMappedTrackInfo() : null;
        if (currentMappedTrackInfo == null) {
            logd(eventTime, "tracks", HttpUrl.PATH_SEGMENT_ENCODE_SET_URI);
            return;
        }
        String strValueOf = String.valueOf(getEventTimeString(eventTime));
        logd(strValueOf.length() != 0 ? "tracks [".concat(strValueOf) : new String("tracks ["));
        int rendererCount = currentMappedTrackInfo.getRendererCount();
        int i2 = 0;
        while (true) {
            String str = "    ]";
            if (i2 >= rendererCount) {
                break;
            }
            TrackGroupArray trackGroups = currentMappedTrackInfo.getTrackGroups(i2);
            TrackSelection trackSelection = trackSelectionArray.get(i2);
            int i3 = rendererCount;
            if (trackGroups.length == 0) {
                String rendererName = currentMappedTrackInfo.getRendererName(i2);
                logd(new StringBuilder(String.valueOf(rendererName).length() + 5).append("  ").append(rendererName).append(" []").toString());
                mappedTrackInfo = currentMappedTrackInfo;
                i = i2;
            } else {
                String rendererName2 = currentMappedTrackInfo.getRendererName(i2);
                logd(new StringBuilder(String.valueOf(rendererName2).length() + 4).append("  ").append(rendererName2).append(" [").toString());
                int i4 = 0;
                while (i4 < trackGroups.length) {
                    TrackGroup trackGroup = trackGroups.get(i4);
                    TrackGroupArray trackGroupArray2 = trackGroups;
                    String adaptiveSupportString = getAdaptiveSupportString(trackGroup.length, currentMappedTrackInfo.getAdaptiveSupport(i2, i4, false));
                    String str2 = trackGroup.id;
                    String str3 = str;
                    logd(new StringBuilder(String.valueOf(str2).length() + 33 + String.valueOf(adaptiveSupportString).length()).append("    Group:").append(str2).append(", adaptive_supported=").append(adaptiveSupportString).append(" [").toString());
                    int i5 = 0;
                    while (i5 < trackGroup.length) {
                        String trackStatusString = getTrackStatusString(trackSelection, trackGroup, i5);
                        int capabilities = currentMappedTrackInfo.getCapabilities(i2, i4, i5);
                        String formatSupportString = Util.getFormatSupportString(RendererCapabilities.getFormatSupport(capabilities));
                        MappingTrackSelector.MappedTrackInfo mappedTrackInfo2 = currentMappedTrackInfo;
                        int i6 = i4;
                        String str4 = "";
                        String str5 = RendererCapabilities.getHardwareAccelerationSupport(capabilities) == 64 ? ", accelerated=YES" : "";
                        if (RendererCapabilities.getDecoderSupport(capabilities) == 0) {
                            str4 = ", fallback=YES";
                        }
                        String str6 = str4;
                        String logString = Format.toLogString(trackGroup.getFormat(i5));
                        logd(new StringBuilder(String.valueOf(trackStatusString).length() + 38 + String.valueOf(logString).length() + String.valueOf(formatSupportString).length() + String.valueOf(str5).length() + String.valueOf(str6).length()).append("      ").append(trackStatusString).append(" Track:").append(i5).append(", ").append(logString).append(", supported=").append(formatSupportString).append(str5).append(str6).toString());
                        i5++;
                        currentMappedTrackInfo = mappedTrackInfo2;
                        i4 = i6;
                        i2 = i2;
                        trackGroup = trackGroup;
                    }
                    logd(str3);
                    i4++;
                    str = str3;
                    trackGroups = trackGroupArray2;
                    currentMappedTrackInfo = currentMappedTrackInfo;
                }
                mappedTrackInfo = currentMappedTrackInfo;
                i = i2;
                String str7 = str;
                if (trackSelection != null) {
                    int i7 = 0;
                    while (true) {
                        if (i7 >= trackSelection.length()) {
                            break;
                        }
                        Metadata metadata = trackSelection.getFormat(i7).metadata;
                        if (metadata != null) {
                            logd("    Metadata [");
                            printMetadata(metadata, "      ");
                            logd(str7);
                            break;
                        }
                        i7++;
                    }
                }
                logd("  ]");
            }
            i2 = i + 1;
            rendererCount = i3;
            currentMappedTrackInfo = mappedTrackInfo;
        }
        TrackGroupArray unmappedTrackGroups = currentMappedTrackInfo.getUnmappedTrackGroups();
        if (unmappedTrackGroups.length > 0) {
            logd("  Unmapped [");
            for (int i8 = 0; i8 < unmappedTrackGroups.length; i8++) {
                logd(new StringBuilder(23).append("    Group:").append(i8).append(" [").toString());
                int i9 = 0;
                for (TrackGroup trackGroup2 = unmappedTrackGroups.get(i8); i9 < trackGroup2.length; trackGroup2 = trackGroup2) {
                    String trackStatusString2 = getTrackStatusString(false);
                    String formatSupportString2 = Util.getFormatSupportString(0);
                    String logString2 = Format.toLogString(trackGroup2.getFormat(i9));
                    logd(new StringBuilder(String.valueOf(trackStatusString2).length() + 38 + String.valueOf(logString2).length() + String.valueOf(formatSupportString2).length()).append("      ").append(trackStatusString2).append(" Track:").append(i9).append(", ").append(logString2).append(", supported=").append(formatSupportString2).toString());
                    i9++;
                    unmappedTrackGroups = unmappedTrackGroups;
                }
                logd("    ]");
            }
            logd("  ]");
        }
        logd(Constants.AES_SUFFIX);
    }

    @Override // com.google.android.exoplayer2.analytics.AnalyticsListener
    public void onMetadata(AnalyticsListener.EventTime eventTime, Metadata metadata) {
        String strValueOf = String.valueOf(getEventTimeString(eventTime));
        logd(strValueOf.length() != 0 ? "metadata [".concat(strValueOf) : new String("metadata ["));
        printMetadata(metadata, "  ");
        logd(Constants.AES_SUFFIX);
    }

    @Override // com.google.android.exoplayer2.analytics.AnalyticsListener
    public void onAudioEnabled(AnalyticsListener.EventTime eventTime, DecoderCounters decoderCounters) {
        logd(eventTime, "audioEnabled");
    }

    @Override // com.google.android.exoplayer2.analytics.AnalyticsListener
    public void onAudioDecoderInitialized(AnalyticsListener.EventTime eventTime, String str, long j) {
        logd(eventTime, "audioDecoderInitialized", str);
    }

    @Override // com.google.android.exoplayer2.analytics.AnalyticsListener
    public void onAudioInputFormatChanged(AnalyticsListener.EventTime eventTime, Format format, DecoderReuseEvaluation decoderReuseEvaluation) {
        logd(eventTime, "audioInputFormat", Format.toLogString(format));
    }

    @Override // com.google.android.exoplayer2.analytics.AnalyticsListener
    public void onAudioUnderrun(AnalyticsListener.EventTime eventTime, int i, long j, long j2) {
        loge(eventTime, "audioTrackUnderrun", new StringBuilder(55).append(i).append(", ").append(j).append(", ").append(j2).toString(), null);
    }

    @Override // com.google.android.exoplayer2.analytics.AnalyticsListener
    public void onAudioDecoderReleased(AnalyticsListener.EventTime eventTime, String str) {
        logd(eventTime, "audioDecoderReleased", str);
    }

    @Override // com.google.android.exoplayer2.analytics.AnalyticsListener
    public void onAudioDisabled(AnalyticsListener.EventTime eventTime, DecoderCounters decoderCounters) {
        logd(eventTime, "audioDisabled");
    }

    @Override // com.google.android.exoplayer2.analytics.AnalyticsListener
    public void onAudioSessionIdChanged(AnalyticsListener.EventTime eventTime, int i) {
        logd(eventTime, "audioSessionId", Integer.toString(i));
    }

    @Override // com.google.android.exoplayer2.analytics.AnalyticsListener
    public void onAudioAttributesChanged(AnalyticsListener.EventTime eventTime, AudioAttributes audioAttributes) {
        int i = audioAttributes.contentType;
        int i2 = audioAttributes.flags;
        int i3 = audioAttributes.usage;
        logd(eventTime, "audioAttributes", new StringBuilder(47).append(i).append(Constants.SEPARATOR_COMMA).append(i2).append(Constants.SEPARATOR_COMMA).append(i3).append(Constants.SEPARATOR_COMMA).append(audioAttributes.allowedCapturePolicy).toString());
    }

    @Override // com.google.android.exoplayer2.analytics.AnalyticsListener
    public void onSkipSilenceEnabledChanged(AnalyticsListener.EventTime eventTime, boolean z) {
        logd(eventTime, "skipSilenceEnabled", Boolean.toString(z));
    }

    @Override // com.google.android.exoplayer2.analytics.AnalyticsListener
    public void onVolumeChanged(AnalyticsListener.EventTime eventTime, float f2) {
        logd(eventTime, "volume", Float.toString(f2));
    }

    @Override // com.google.android.exoplayer2.analytics.AnalyticsListener
    public void onVideoEnabled(AnalyticsListener.EventTime eventTime, DecoderCounters decoderCounters) {
        logd(eventTime, "videoEnabled");
    }

    @Override // com.google.android.exoplayer2.analytics.AnalyticsListener
    public void onVideoDecoderInitialized(AnalyticsListener.EventTime eventTime, String str, long j) {
        logd(eventTime, "videoDecoderInitialized", str);
    }

    @Override // com.google.android.exoplayer2.analytics.AnalyticsListener
    public void onVideoInputFormatChanged(AnalyticsListener.EventTime eventTime, Format format, DecoderReuseEvaluation decoderReuseEvaluation) {
        logd(eventTime, "videoInputFormat", Format.toLogString(format));
    }

    @Override // com.google.android.exoplayer2.analytics.AnalyticsListener
    public void onDroppedVideoFrames(AnalyticsListener.EventTime eventTime, int i, long j) {
        logd(eventTime, "droppedFrames", Integer.toString(i));
    }

    @Override // com.google.android.exoplayer2.analytics.AnalyticsListener
    public void onVideoDecoderReleased(AnalyticsListener.EventTime eventTime, String str) {
        logd(eventTime, "videoDecoderReleased", str);
    }

    @Override // com.google.android.exoplayer2.analytics.AnalyticsListener
    public void onVideoDisabled(AnalyticsListener.EventTime eventTime, DecoderCounters decoderCounters) {
        logd(eventTime, "videoDisabled");
    }

    @Override // com.google.android.exoplayer2.analytics.AnalyticsListener
    public void onRenderedFirstFrame(AnalyticsListener.EventTime eventTime, Object obj, long j) {
        logd(eventTime, "renderedFirstFrame", String.valueOf(obj));
    }

    @Override // com.google.android.exoplayer2.analytics.AnalyticsListener
    public void onVideoSizeChanged(AnalyticsListener.EventTime eventTime, VideoSize videoSize) {
        int i = videoSize.width;
        logd(eventTime, "videoSize", new StringBuilder(24).append(i).append(", ").append(videoSize.height).toString());
    }

    @Override // com.google.android.exoplayer2.analytics.AnalyticsListener
    public void onLoadError(AnalyticsListener.EventTime eventTime, LoadEventInfo loadEventInfo, MediaLoadData mediaLoadData, IOException iOException, boolean z) {
        printInternalError(eventTime, "loadError", iOException);
    }

    @Override // com.google.android.exoplayer2.analytics.AnalyticsListener
    public void onSurfaceSizeChanged(AnalyticsListener.EventTime eventTime, int i, int i2) {
        logd(eventTime, "surfaceSize", new StringBuilder(24).append(i).append(", ").append(i2).toString());
    }

    @Override // com.google.android.exoplayer2.analytics.AnalyticsListener
    public void onUpstreamDiscarded(AnalyticsListener.EventTime eventTime, MediaLoadData mediaLoadData) {
        logd(eventTime, "upstreamDiscarded", Format.toLogString(mediaLoadData.trackFormat));
    }

    @Override // com.google.android.exoplayer2.analytics.AnalyticsListener
    public void onDownstreamFormatChanged(AnalyticsListener.EventTime eventTime, MediaLoadData mediaLoadData) {
        logd(eventTime, "downstreamFormat", Format.toLogString(mediaLoadData.trackFormat));
    }

    @Override // com.google.android.exoplayer2.analytics.AnalyticsListener
    public void onDrmSessionAcquired(AnalyticsListener.EventTime eventTime, int i) {
        logd(eventTime, "drmSessionAcquired", new StringBuilder(17).append("state=").append(i).toString());
    }

    @Override // com.google.android.exoplayer2.analytics.AnalyticsListener
    public void onDrmSessionManagerError(AnalyticsListener.EventTime eventTime, Exception exc) {
        printInternalError(eventTime, "drmSessionManagerError", exc);
    }

    @Override // com.google.android.exoplayer2.analytics.AnalyticsListener
    public void onDrmKeysRestored(AnalyticsListener.EventTime eventTime) {
        logd(eventTime, "drmKeysRestored");
    }

    @Override // com.google.android.exoplayer2.analytics.AnalyticsListener
    public void onDrmKeysRemoved(AnalyticsListener.EventTime eventTime) {
        logd(eventTime, "drmKeysRemoved");
    }

    @Override // com.google.android.exoplayer2.analytics.AnalyticsListener
    public void onDrmKeysLoaded(AnalyticsListener.EventTime eventTime) {
        logd(eventTime, "drmKeysLoaded");
    }

    @Override // com.google.android.exoplayer2.analytics.AnalyticsListener
    public void onDrmSessionReleased(AnalyticsListener.EventTime eventTime) {
        logd(eventTime, "drmSessionReleased");
    }

    protected void logd(String str) {
        Log.d(this.tag, str);
    }

    protected void loge(String str) {
        Log.e(this.tag, str);
    }

    private void logd(AnalyticsListener.EventTime eventTime, String str) {
        logd(getEventString(eventTime, str, null, null));
    }

    private void logd(AnalyticsListener.EventTime eventTime, String str, String str2) {
        logd(getEventString(eventTime, str, str2, null));
    }

    private void loge(AnalyticsListener.EventTime eventTime, String str, Throwable th) {
        loge(getEventString(eventTime, str, null, th));
    }

    private void loge(AnalyticsListener.EventTime eventTime, String str, String str2, Throwable th) {
        loge(getEventString(eventTime, str, str2, th));
    }

    private void printInternalError(AnalyticsListener.EventTime eventTime, String str, Exception exc) {
        loge(eventTime, "internalError", str, exc);
    }

    private void printMetadata(Metadata metadata, String str) {
        for (int i = 0; i < metadata.length(); i++) {
            String strValueOf = String.valueOf(metadata.get(i));
            logd(new StringBuilder(String.valueOf(str).length() + String.valueOf(strValueOf).length()).append(str).append(strValueOf).toString());
        }
    }

    private String getEventString(AnalyticsListener.EventTime eventTime, String str, String str2, Throwable th) {
        String eventTimeString = getEventTimeString(eventTime);
        String string = new StringBuilder(String.valueOf(str).length() + 2 + String.valueOf(eventTimeString).length()).append(str).append(" [").append(eventTimeString).toString();
        if (th instanceof PlaybackException) {
            String strValueOf = String.valueOf(string);
            String errorCodeName = ((PlaybackException) th).getErrorCodeName();
            string = new StringBuilder(String.valueOf(strValueOf).length() + 12 + String.valueOf(errorCodeName).length()).append(strValueOf).append(", errorCode=").append(errorCodeName).toString();
        }
        if (str2 != null) {
            String strValueOf2 = String.valueOf(string);
            string = new StringBuilder(String.valueOf(strValueOf2).length() + 2 + String.valueOf(str2).length()).append(strValueOf2).append(", ").append(str2).toString();
        }
        String throwableString = Log.getThrowableString(th);
        if (!TextUtils.isEmpty(throwableString)) {
            String strValueOf3 = String.valueOf(string);
            String strReplace = throwableString.replace("\n", "\n  ");
            string = new StringBuilder(String.valueOf(strValueOf3).length() + 4 + String.valueOf(strReplace).length()).append(strValueOf3).append("\n  ").append(strReplace).append('\n').toString();
        }
        return String.valueOf(string).concat(Constants.AES_SUFFIX);
    }

    private String getEventTimeString(AnalyticsListener.EventTime eventTime) {
        String string = new StringBuilder(18).append("window=").append(eventTime.windowIndex).toString();
        if (eventTime.mediaPeriodId != null) {
            String strValueOf = String.valueOf(string);
            string = new StringBuilder(String.valueOf(strValueOf).length() + 20).append(strValueOf).append(", period=").append(eventTime.timeline.getIndexOfPeriod(eventTime.mediaPeriodId.periodUid)).toString();
            if (eventTime.mediaPeriodId.isAd()) {
                String strValueOf2 = String.valueOf(string);
                String strValueOf3 = String.valueOf(new StringBuilder(String.valueOf(strValueOf2).length() + 21).append(strValueOf2).append(", adGroup=").append(eventTime.mediaPeriodId.adGroupIndex).toString());
                string = new StringBuilder(String.valueOf(strValueOf3).length() + 16).append(strValueOf3).append(", ad=").append(eventTime.mediaPeriodId.adIndexInAdGroup).toString();
            }
        }
        String timeString = getTimeString(eventTime.realtimeMs - this.startTimeMs);
        String timeString2 = getTimeString(eventTime.eventPlaybackPositionMs);
        return new StringBuilder(String.valueOf(timeString).length() + 23 + String.valueOf(timeString2).length() + String.valueOf(string).length()).append("eventTime=").append(timeString).append(", mediaPos=").append(timeString2).append(", ").append(string).toString();
    }

    private static String getTimeString(long j) {
        return j == -9223372036854775807L ? "?" : TIME_FORMAT.format(j / 1000.0f);
    }

    private static String getStateString(int i) {
        if (i == 1) {
            return "IDLE";
        }
        if (i == 2) {
            return "BUFFERING";
        }
        if (i == 3) {
            return "READY";
        }
        if (i == 4) {
            return "ENDED";
        }
        return "?";
    }

    private static String getAdaptiveSupportString(int i, int i2) {
        if (i < 2) {
            return "N/A";
        }
        if (i2 == 0) {
            return "NO";
        }
        if (i2 == 8) {
            return "YES_NOT_SEAMLESS";
        }
        if (i2 == 16) {
            return "YES";
        }
        throw new IllegalStateException();
    }

    private static String getTrackStatusString(TrackSelection trackSelection, TrackGroup trackGroup, int i) {
        return getTrackStatusString((trackSelection == null || !trackSelection.getTrackGroup().equals(trackGroup) || trackSelection.indexOf(i) == -1) ? false : true);
    }

    private static String getTrackStatusString(boolean z) {
        return z ? "[X]" : "[ ]";
    }

    private static String getRepeatModeString(int i) {
        if (i == 0) {
            return "OFF";
        }
        if (i == 1) {
            return "ONE";
        }
        if (i == 2) {
            return "ALL";
        }
        return "?";
    }

    private static String getDiscontinuityReasonString(int i) {
        if (i == 0) {
            return "AUTO_TRANSITION";
        }
        if (i == 1) {
            return "SEEK";
        }
        if (i == 2) {
            return "SEEK_ADJUSTMENT";
        }
        if (i == 3) {
            return "SKIP";
        }
        if (i == 4) {
            return "REMOVE";
        }
        if (i == 5) {
            return "INTERNAL";
        }
        return "?";
    }

    private static String getTimelineChangeReasonString(int i) {
        if (i == 0) {
            return "PLAYLIST_CHANGED";
        }
        if (i == 1) {
            return "SOURCE_UPDATE";
        }
        return "?";
    }

    private static String getMediaItemTransitionReasonString(int i) {
        if (i == 0) {
            return "REPEAT";
        }
        if (i == 1) {
            return "AUTO";
        }
        if (i == 2) {
            return "SEEK";
        }
        if (i == 3) {
            return "PLAYLIST_CHANGED";
        }
        return "?";
    }

    private static String getPlaybackSuppressionReasonString(int i) {
        if (i == 0) {
            return "NONE";
        }
        if (i == 1) {
            return "TRANSIENT_AUDIO_FOCUS_LOSS";
        }
        return "?";
    }

    private static String getPlayWhenReadyChangeReasonString(int i) {
        if (i == 1) {
            return "USER_REQUEST";
        }
        if (i == 2) {
            return "AUDIO_FOCUS_LOSS";
        }
        if (i == 3) {
            return "AUDIO_BECOMING_NOISY";
        }
        if (i == 4) {
            return "REMOTE";
        }
        if (i == 5) {
            return "END_OF_MEDIA_ITEM";
        }
        return "?";
    }
}
