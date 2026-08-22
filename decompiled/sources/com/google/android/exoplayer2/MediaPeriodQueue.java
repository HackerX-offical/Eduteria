package com.google.android.exoplayer2;

import android.os.Handler;
import android.util.Pair;
import com.google.android.exoplayer2.Timeline;
import com.google.android.exoplayer2.analytics.AnalyticsCollector;
import com.google.android.exoplayer2.source.MediaPeriod;
import com.google.android.exoplayer2.source.MediaSource;
import com.google.android.exoplayer2.trackselection.TrackSelector;
import com.google.android.exoplayer2.trackselection.TrackSelectorResult;
import com.google.android.exoplayer2.upstream.Allocator;
import com.google.android.exoplayer2.util.Assertions;
import com.google.common.collect.ImmutableList;

/* JADX INFO: loaded from: classes7.dex */
final class MediaPeriodQueue {
    public static final long INITIAL_RENDERER_POSITION_OFFSET_US = 1000000000000L;
    private static final int MAXIMUM_BUFFER_AHEAD_PERIODS = 100;
    private final AnalyticsCollector analyticsCollector;
    private final Handler analyticsCollectorHandler;
    private int length;
    private MediaPeriodHolder loading;
    private long nextWindowSequenceNumber;
    private Object oldFrontPeriodUid;
    private long oldFrontPeriodWindowSequenceNumber;
    private MediaPeriodHolder playing;
    private MediaPeriodHolder reading;
    private int repeatMode;
    private boolean shuffleModeEnabled;
    private final Timeline.Period period = new Timeline.Period();
    private final Timeline.Window window = new Timeline.Window();

    private boolean areDurationsCompatible(long j, long j2) {
        return j == -9223372036854775807L || j == j2;
    }

    public MediaPeriodQueue(AnalyticsCollector analyticsCollector, Handler handler) {
        this.analyticsCollector = analyticsCollector;
        this.analyticsCollectorHandler = handler;
    }

    public boolean updateRepeatMode(Timeline timeline, int i) {
        this.repeatMode = i;
        return updateForPlaybackModeChange(timeline);
    }

    public boolean updateShuffleModeEnabled(Timeline timeline, boolean z) {
        this.shuffleModeEnabled = z;
        return updateForPlaybackModeChange(timeline);
    }

    public boolean isLoading(MediaPeriod mediaPeriod) {
        MediaPeriodHolder mediaPeriodHolder = this.loading;
        return mediaPeriodHolder != null && mediaPeriodHolder.mediaPeriod == mediaPeriod;
    }

    public void reevaluateBuffer(long j) {
        MediaPeriodHolder mediaPeriodHolder = this.loading;
        if (mediaPeriodHolder != null) {
            mediaPeriodHolder.reevaluateBuffer(j);
        }
    }

    public boolean shouldLoadNextMediaPeriod() {
        MediaPeriodHolder mediaPeriodHolder = this.loading;
        if (mediaPeriodHolder != null) {
            return !mediaPeriodHolder.f596info.isFinal && this.loading.isFullyBuffered() && this.loading.f596info.durationUs != -9223372036854775807L && this.length < 100;
        }
        return true;
    }

    public MediaPeriodInfo getNextMediaPeriodInfo(long j, PlaybackInfo playbackInfo) {
        if (this.loading == null) {
            return getFirstMediaPeriodInfo(playbackInfo);
        }
        return getFollowingMediaPeriodInfo(playbackInfo.timeline, this.loading, j);
    }

    public MediaPeriodHolder enqueueNextMediaPeriodHolder(RendererCapabilities[] rendererCapabilitiesArr, TrackSelector trackSelector, Allocator allocator, MediaSourceList mediaSourceList, MediaPeriodInfo mediaPeriodInfo, TrackSelectorResult trackSelectorResult) {
        MediaPeriodInfo mediaPeriodInfo2;
        long rendererOffset;
        MediaPeriodHolder mediaPeriodHolder = this.loading;
        if (mediaPeriodHolder == null) {
            rendererOffset = 1000000000000L;
            mediaPeriodInfo2 = mediaPeriodInfo;
        } else {
            mediaPeriodInfo2 = mediaPeriodInfo;
            rendererOffset = (mediaPeriodHolder.getRendererOffset() + this.loading.f596info.durationUs) - mediaPeriodInfo2.startPositionUs;
        }
        MediaPeriodHolder mediaPeriodHolder2 = new MediaPeriodHolder(rendererCapabilitiesArr, rendererOffset, trackSelector, allocator, mediaSourceList, mediaPeriodInfo2, trackSelectorResult);
        MediaPeriodHolder mediaPeriodHolder3 = this.loading;
        if (mediaPeriodHolder3 != null) {
            mediaPeriodHolder3.setNext(mediaPeriodHolder2);
        } else {
            this.playing = mediaPeriodHolder2;
            this.reading = mediaPeriodHolder2;
        }
        this.oldFrontPeriodUid = null;
        this.loading = mediaPeriodHolder2;
        this.length++;
        notifyQueueUpdate();
        return mediaPeriodHolder2;
    }

    public MediaPeriodHolder getLoadingPeriod() {
        return this.loading;
    }

    public MediaPeriodHolder getPlayingPeriod() {
        return this.playing;
    }

    public MediaPeriodHolder getReadingPeriod() {
        return this.reading;
    }

    public MediaPeriodHolder advanceReadingPeriod() {
        MediaPeriodHolder mediaPeriodHolder = this.reading;
        Assertions.checkState((mediaPeriodHolder == null || mediaPeriodHolder.getNext() == null) ? false : true);
        this.reading = this.reading.getNext();
        notifyQueueUpdate();
        return this.reading;
    }

    public MediaPeriodHolder advancePlayingPeriod() {
        MediaPeriodHolder mediaPeriodHolder = this.playing;
        if (mediaPeriodHolder == null) {
            return null;
        }
        if (mediaPeriodHolder == this.reading) {
            this.reading = mediaPeriodHolder.getNext();
        }
        this.playing.release();
        int i = this.length - 1;
        this.length = i;
        if (i == 0) {
            this.loading = null;
            this.oldFrontPeriodUid = this.playing.uid;
            this.oldFrontPeriodWindowSequenceNumber = this.playing.f596info.id.windowSequenceNumber;
        }
        this.playing = this.playing.getNext();
        notifyQueueUpdate();
        return this.playing;
    }

    public boolean removeAfter(MediaPeriodHolder mediaPeriodHolder) {
        boolean z = false;
        Assertions.checkState(mediaPeriodHolder != null);
        if (mediaPeriodHolder.equals(this.loading)) {
            return false;
        }
        this.loading = mediaPeriodHolder;
        while (mediaPeriodHolder.getNext() != null) {
            mediaPeriodHolder = mediaPeriodHolder.getNext();
            if (mediaPeriodHolder == this.reading) {
                this.reading = this.playing;
                z = true;
            }
            mediaPeriodHolder.release();
            this.length--;
        }
        this.loading.setNext(null);
        notifyQueueUpdate();
        return z;
    }

    public void clear() {
        if (this.length == 0) {
            return;
        }
        MediaPeriodHolder next = (MediaPeriodHolder) Assertions.checkStateNotNull(this.playing);
        this.oldFrontPeriodUid = next.uid;
        this.oldFrontPeriodWindowSequenceNumber = next.f596info.id.windowSequenceNumber;
        while (next != null) {
            next.release();
            next = next.getNext();
        }
        this.playing = null;
        this.loading = null;
        this.reading = null;
        this.length = 0;
        notifyQueueUpdate();
    }

    public boolean updateQueuedPeriods(Timeline timeline, long j, long j2) {
        boolean zRemoveAfter;
        MediaPeriodInfo updatedMediaPeriodInfo;
        MediaPeriodHolder next = this.playing;
        MediaPeriodHolder mediaPeriodHolder = null;
        while (next != null) {
            MediaPeriodInfo mediaPeriodInfo = next.f596info;
            if (mediaPeriodHolder == null) {
                updatedMediaPeriodInfo = getUpdatedMediaPeriodInfo(timeline, mediaPeriodInfo);
            } else {
                MediaPeriodInfo followingMediaPeriodInfo = getFollowingMediaPeriodInfo(timeline, mediaPeriodHolder, j);
                if (followingMediaPeriodInfo == null) {
                    zRemoveAfter = removeAfter(mediaPeriodHolder);
                } else if (canKeepMediaPeriodHolder(mediaPeriodInfo, followingMediaPeriodInfo)) {
                    updatedMediaPeriodInfo = followingMediaPeriodInfo;
                } else {
                    zRemoveAfter = removeAfter(mediaPeriodHolder);
                }
                return !zRemoveAfter;
            }
            next.f596info = updatedMediaPeriodInfo.copyWithRequestedContentPositionUs(mediaPeriodInfo.requestedContentPositionUs);
            if (!areDurationsCompatible(mediaPeriodInfo.durationUs, updatedMediaPeriodInfo.durationUs)) {
                next.updateClipping();
                return (removeAfter(next) || (next == this.reading && !next.f596info.isFollowedByTransitionToSameStream && ((j2 > Long.MIN_VALUE ? 1 : (j2 == Long.MIN_VALUE ? 0 : -1)) == 0 || (j2 > ((updatedMediaPeriodInfo.durationUs > (-9223372036854775807L) ? 1 : (updatedMediaPeriodInfo.durationUs == (-9223372036854775807L) ? 0 : -1)) == 0 ? Long.MAX_VALUE : next.toRendererTime(updatedMediaPeriodInfo.durationUs)) ? 1 : (j2 == ((updatedMediaPeriodInfo.durationUs > (-9223372036854775807L) ? 1 : (updatedMediaPeriodInfo.durationUs == (-9223372036854775807L) ? 0 : -1)) == 0 ? Long.MAX_VALUE : next.toRendererTime(updatedMediaPeriodInfo.durationUs)) ? 0 : -1)) >= 0))) ? false : true;
            }
            mediaPeriodHolder = next;
            next = next.getNext();
        }
        return true;
    }

    /* JADX WARN: Removed duplicated region for block: B:22:0x0062  */
    /* JADX WARN: Removed duplicated region for block: B:24:0x006c  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public com.google.android.exoplayer2.MediaPeriodInfo getUpdatedMediaPeriodInfo(com.google.android.exoplayer2.Timeline r16, com.google.android.exoplayer2.MediaPeriodInfo r17) {
        /*
            r15 = this;
            r1 = r16
            r2 = r17
            com.google.android.exoplayer2.source.MediaSource$MediaPeriodId r3 = r2.id
            boolean r12 = r15.isLastInPeriod(r3)
            boolean r13 = r15.isLastInWindow(r1, r3)
            boolean r14 = r15.isLastInTimeline(r1, r3, r12)
            com.google.android.exoplayer2.source.MediaSource$MediaPeriodId r4 = r2.id
            java.lang.Object r4 = r4.periodUid
            com.google.android.exoplayer2.Timeline$Period r5 = r15.period
            r1.getPeriodByUid(r4, r5)
            boolean r1 = r3.isAd()
            r4 = -1
            r5 = -9223372036854775807(0x8000000000000001, double:-4.9E-324)
            if (r1 != 0) goto L35
            int r1 = r3.nextAdGroupIndex
            if (r1 != r4) goto L2c
            goto L35
        L2c:
            com.google.android.exoplayer2.Timeline$Period r1 = r15.period
            int r7 = r3.nextAdGroupIndex
            long r7 = r1.getAdGroupTimeUs(r7)
            goto L36
        L35:
            r7 = r5
        L36:
            boolean r1 = r3.isAd()
            if (r1 == 0) goto L48
            com.google.android.exoplayer2.Timeline$Period r1 = r15.period
            int r5 = r3.adGroupIndex
            int r6 = r3.adIndexInAdGroup
            long r5 = r1.getAdDurationUs(r5, r6)
        L46:
            r9 = r5
            goto L5c
        L48:
            int r1 = (r7 > r5 ? 1 : (r7 == r5 ? 0 : -1))
            if (r1 == 0) goto L55
            r5 = -9223372036854775808
            int r1 = (r7 > r5 ? 1 : (r7 == r5 ? 0 : -1))
            if (r1 != 0) goto L53
            goto L55
        L53:
            r9 = r7
            goto L5c
        L55:
            com.google.android.exoplayer2.Timeline$Period r1 = r15.period
            long r5 = r1.getDurationUs()
            goto L46
        L5c:
            boolean r1 = r3.isAd()
            if (r1 == 0) goto L6c
            com.google.android.exoplayer2.Timeline$Period r1 = r15.period
            int r4 = r3.adGroupIndex
            boolean r1 = r1.isServerSideInsertedAdGroup(r4)
        L6a:
            r11 = r1
            goto L7e
        L6c:
            int r1 = r3.nextAdGroupIndex
            if (r1 == r4) goto L7c
            com.google.android.exoplayer2.Timeline$Period r1 = r15.period
            int r4 = r3.nextAdGroupIndex
            boolean r1 = r1.isServerSideInsertedAdGroup(r4)
            if (r1 == 0) goto L7c
            r1 = 1
            goto L6a
        L7c:
            r1 = 0
            goto L6a
        L7e:
            com.google.android.exoplayer2.MediaPeriodInfo r1 = new com.google.android.exoplayer2.MediaPeriodInfo
            r5 = r3
            long r3 = r2.startPositionUs
            r16 = r1
            long r0 = r2.requestedContentPositionUs
            r2 = r5
            r5 = r0
            r1 = r16
            r1.<init>(r2, r3, r5, r7, r9, r11, r12, r13, r14)
            return r1
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.exoplayer2.MediaPeriodQueue.getUpdatedMediaPeriodInfo(com.google.android.exoplayer2.Timeline, com.google.android.exoplayer2.MediaPeriodInfo):com.google.android.exoplayer2.MediaPeriodInfo");
    }

    public MediaSource.MediaPeriodId resolveMediaPeriodIdForAds(Timeline timeline, Object obj, long j) {
        return resolveMediaPeriodIdForAds(timeline, obj, j, resolvePeriodIndexToWindowSequenceNumber(timeline, obj), this.window, this.period);
    }

    private static MediaSource.MediaPeriodId resolveMediaPeriodIdForAds(Timeline timeline, Object obj, long j, long j2, Timeline.Window window, Timeline.Period period) {
        timeline.getPeriodByUid(obj, period);
        timeline.getWindow(period.windowIndex, window);
        int indexOfPeriod = timeline.getIndexOfPeriod(obj);
        while (period.durationUs == 0 && period.getAdGroupCount() > 0 && period.isServerSideInsertedAdGroup(period.getRemovedAdGroupCount()) && period.getAdGroupIndexForPositionUs(0L) == -1) {
            int i = indexOfPeriod + 1;
            if (indexOfPeriod >= window.lastPeriodIndex) {
                break;
            }
            timeline.getPeriod(i, period, true);
            obj = Assertions.checkNotNull(period.uid);
            indexOfPeriod = i;
        }
        timeline.getPeriodByUid(obj, period);
        int adGroupIndexForPositionUs = period.getAdGroupIndexForPositionUs(j);
        if (adGroupIndexForPositionUs == -1) {
            return new MediaSource.MediaPeriodId(obj, j2, period.getAdGroupIndexAfterPositionUs(j));
        }
        return new MediaSource.MediaPeriodId(obj, adGroupIndexForPositionUs, period.getFirstAdIndexToPlay(adGroupIndexForPositionUs), j2);
    }

    public MediaSource.MediaPeriodId resolveMediaPeriodIdForAdsAfterPeriodPositionChange(Timeline timeline, Object obj, long j) {
        long jResolvePeriodIndexToWindowSequenceNumber = resolvePeriodIndexToWindowSequenceNumber(timeline, obj);
        timeline.getPeriodByUid(obj, this.period);
        timeline.getWindow(this.period.windowIndex, this.window);
        boolean z = false;
        for (int indexOfPeriod = timeline.getIndexOfPeriod(obj); indexOfPeriod >= this.window.firstPeriodIndex; indexOfPeriod--) {
            timeline.getPeriod(indexOfPeriod, this.period, true);
            boolean z2 = this.period.getAdGroupCount() > 0;
            z |= z2;
            Timeline.Period period = this.period;
            if (period.getAdGroupIndexForPositionUs(period.durationUs) != -1) {
                obj = Assertions.checkNotNull(this.period.uid);
            }
            if (z && (!z2 || this.period.durationUs != 0)) {
                break;
            }
        }
        return resolveMediaPeriodIdForAds(timeline, obj, j, jResolvePeriodIndexToWindowSequenceNumber, this.window, this.period);
    }

    private void notifyQueueUpdate() {
        final ImmutableList.Builder builder = ImmutableList.builder();
        for (MediaPeriodHolder next = this.playing; next != null; next = next.getNext()) {
            builder.add(next.f596info.id);
        }
        MediaPeriodHolder mediaPeriodHolder = this.reading;
        final MediaSource.MediaPeriodId mediaPeriodId = mediaPeriodHolder == null ? null : mediaPeriodHolder.f596info.id;
        this.analyticsCollectorHandler.post(new Runnable() { // from class: com.google.android.exoplayer2.MediaPeriodQueue$$ExternalSyntheticLambda0
            @Override // java.lang.Runnable
            public final void run() {
                this.f$0.m12069xb2cc2342(builder, mediaPeriodId);
            }
        });
    }

    /* JADX INFO: renamed from: lambda$notifyQueueUpdate$0$com-google-android-exoplayer2-MediaPeriodQueue, reason: not valid java name */
    /* synthetic */ void m12069xb2cc2342(ImmutableList.Builder builder, MediaSource.MediaPeriodId mediaPeriodId) {
        this.analyticsCollector.updateMediaPeriodQueueInfo(builder.build(), mediaPeriodId);
    }

    private long resolvePeriodIndexToWindowSequenceNumber(Timeline timeline, Object obj) {
        int indexOfPeriod;
        int i = timeline.getPeriodByUid(obj, this.period).windowIndex;
        Object obj2 = this.oldFrontPeriodUid;
        if (obj2 != null && (indexOfPeriod = timeline.getIndexOfPeriod(obj2)) != -1 && timeline.getPeriod(indexOfPeriod, this.period).windowIndex == i) {
            return this.oldFrontPeriodWindowSequenceNumber;
        }
        for (MediaPeriodHolder next = this.playing; next != null; next = next.getNext()) {
            if (next.uid.equals(obj)) {
                return next.f596info.id.windowSequenceNumber;
            }
        }
        for (MediaPeriodHolder next2 = this.playing; next2 != null; next2 = next2.getNext()) {
            int indexOfPeriod2 = timeline.getIndexOfPeriod(next2.uid);
            if (indexOfPeriod2 != -1 && timeline.getPeriod(indexOfPeriod2, this.period).windowIndex == i) {
                return next2.f596info.id.windowSequenceNumber;
            }
        }
        long j = this.nextWindowSequenceNumber;
        this.nextWindowSequenceNumber = 1 + j;
        if (this.playing == null) {
            this.oldFrontPeriodUid = obj;
            this.oldFrontPeriodWindowSequenceNumber = j;
        }
        return j;
    }

    private boolean canKeepMediaPeriodHolder(MediaPeriodInfo mediaPeriodInfo, MediaPeriodInfo mediaPeriodInfo2) {
        return mediaPeriodInfo.startPositionUs == mediaPeriodInfo2.startPositionUs && mediaPeriodInfo.id.equals(mediaPeriodInfo2.id);
    }

    private boolean updateForPlaybackModeChange(Timeline timeline) {
        Timeline timeline2;
        MediaPeriodHolder next = this.playing;
        if (next == null) {
            return true;
        }
        int indexOfPeriod = timeline.getIndexOfPeriod(next.uid);
        while (true) {
            timeline2 = timeline;
            indexOfPeriod = timeline2.getNextPeriodIndex(indexOfPeriod, this.period, this.window, this.repeatMode, this.shuffleModeEnabled);
            while (next.getNext() != null && !next.f596info.isLastInTimelinePeriod) {
                next = next.getNext();
            }
            MediaPeriodHolder next2 = next.getNext();
            if (indexOfPeriod == -1 || next2 == null || timeline2.getIndexOfPeriod(next2.uid) != indexOfPeriod) {
                break;
            }
            next = next2;
            timeline = timeline2;
        }
        boolean zRemoveAfter = removeAfter(next);
        next.f596info = getUpdatedMediaPeriodInfo(timeline2, next.f596info);
        return !zRemoveAfter;
    }

    private MediaPeriodInfo getFirstMediaPeriodInfo(PlaybackInfo playbackInfo) {
        return getMediaPeriodInfo(playbackInfo.timeline, playbackInfo.periodId, playbackInfo.requestedContentPositionUs, playbackInfo.positionUs);
    }

    private MediaPeriodInfo getFollowingMediaPeriodInfo(Timeline timeline, MediaPeriodHolder mediaPeriodHolder, long j) {
        Timeline timeline2;
        Object obj;
        long j2;
        MediaPeriodInfo mediaPeriodInfo = mediaPeriodHolder.f596info;
        long rendererOffset = (mediaPeriodHolder.getRendererOffset() + mediaPeriodInfo.durationUs) - j;
        boolean z = false;
        if (mediaPeriodInfo.isLastInTimelinePeriod) {
            long j3 = 0;
            int nextPeriodIndex = timeline.getNextPeriodIndex(timeline.getIndexOfPeriod(mediaPeriodInfo.id.periodUid), this.period, this.window, this.repeatMode, this.shuffleModeEnabled);
            if (nextPeriodIndex == -1) {
                return null;
            }
            int i = timeline.getPeriod(nextPeriodIndex, this.period, true).windowIndex;
            Object objCheckNotNull = Assertions.checkNotNull(this.period.uid);
            long j4 = mediaPeriodInfo.id.windowSequenceNumber;
            if (timeline.getWindow(i, this.window).firstPeriodIndex == nextPeriodIndex) {
                Pair<Object, Long> periodPositionUs = timeline.getPeriodPositionUs(this.window, this.period, i, -9223372036854775807L, Math.max(0L, rendererOffset));
                if (periodPositionUs == null) {
                    return null;
                }
                Object obj2 = periodPositionUs.first;
                long jLongValue = ((Long) periodPositionUs.second).longValue();
                MediaPeriodHolder next = mediaPeriodHolder.getNext();
                if (next != null && next.uid.equals(obj2)) {
                    j4 = next.f596info.id.windowSequenceNumber;
                } else {
                    j4 = this.nextWindowSequenceNumber;
                    this.nextWindowSequenceNumber = 1 + j4;
                }
                obj = obj2;
                j2 = jLongValue;
                j3 = -9223372036854775807L;
            } else {
                obj = objCheckNotNull;
                j2 = 0;
            }
            MediaSource.MediaPeriodId mediaPeriodIdResolveMediaPeriodIdForAds = resolveMediaPeriodIdForAds(timeline, obj, j2, j4, this.window, this.period);
            if (j3 != -9223372036854775807L && mediaPeriodInfo.requestedContentPositionUs != -9223372036854775807L) {
                if (timeline.getPeriodByUid(mediaPeriodInfo.id.periodUid, this.period).getAdGroupCount() > 0) {
                    Timeline.Period period = this.period;
                    if (period.isServerSideInsertedAdGroup(period.getRemovedAdGroupCount())) {
                        z = true;
                    }
                }
                if (mediaPeriodIdResolveMediaPeriodIdForAds.isAd() && z) {
                    j3 = mediaPeriodInfo.requestedContentPositionUs;
                } else if (z) {
                    j2 = mediaPeriodInfo.requestedContentPositionUs;
                }
            }
            return getMediaPeriodInfo(timeline, mediaPeriodIdResolveMediaPeriodIdForAds, j3, j2);
        }
        MediaSource.MediaPeriodId mediaPeriodId = mediaPeriodInfo.id;
        timeline.getPeriodByUid(mediaPeriodId.periodUid, this.period);
        if (mediaPeriodId.isAd()) {
            int i2 = mediaPeriodId.adGroupIndex;
            int adCountInAdGroup = this.period.getAdCountInAdGroup(i2);
            if (adCountInAdGroup == -1) {
                return null;
            }
            int nextAdIndexToPlay = this.period.getNextAdIndexToPlay(i2, mediaPeriodId.adIndexInAdGroup);
            if (nextAdIndexToPlay < adCountInAdGroup) {
                return getMediaPeriodInfoForAd(timeline, mediaPeriodId.periodUid, i2, nextAdIndexToPlay, mediaPeriodInfo.requestedContentPositionUs, mediaPeriodId.windowSequenceNumber);
            }
            long jLongValue2 = mediaPeriodInfo.requestedContentPositionUs;
            if (jLongValue2 == -9223372036854775807L) {
                Timeline.Window window = this.window;
                Timeline.Period period2 = this.period;
                Pair<Object, Long> periodPositionUs2 = timeline.getPeriodPositionUs(window, period2, period2.windowIndex, -9223372036854775807L, Math.max(0L, rendererOffset));
                timeline2 = timeline;
                if (periodPositionUs2 == null) {
                    return null;
                }
                jLongValue2 = ((Long) periodPositionUs2.second).longValue();
            } else {
                timeline2 = timeline;
            }
            return getMediaPeriodInfoForContent(timeline, mediaPeriodId.periodUid, Math.max(getMinStartPositionAfterAdGroupUs(timeline2, mediaPeriodId.periodUid, mediaPeriodId.adGroupIndex), jLongValue2), mediaPeriodInfo.requestedContentPositionUs, mediaPeriodId.windowSequenceNumber);
        }
        int firstAdIndexToPlay = this.period.getFirstAdIndexToPlay(mediaPeriodId.nextAdGroupIndex);
        if (this.period.isServerSideInsertedAdGroup(mediaPeriodId.nextAdGroupIndex) && this.period.getAdState(mediaPeriodId.nextAdGroupIndex, firstAdIndexToPlay) == 3) {
            z = true;
        }
        if (firstAdIndexToPlay == this.period.getAdCountInAdGroup(mediaPeriodId.nextAdGroupIndex) || z) {
            return getMediaPeriodInfoForContent(timeline, mediaPeriodId.periodUid, getMinStartPositionAfterAdGroupUs(timeline, mediaPeriodId.periodUid, mediaPeriodId.nextAdGroupIndex), mediaPeriodInfo.durationUs, mediaPeriodId.windowSequenceNumber);
        }
        return getMediaPeriodInfoForAd(timeline, mediaPeriodId.periodUid, mediaPeriodId.nextAdGroupIndex, firstAdIndexToPlay, mediaPeriodInfo.durationUs, mediaPeriodId.windowSequenceNumber);
    }

    private MediaPeriodInfo getMediaPeriodInfo(Timeline timeline, MediaSource.MediaPeriodId mediaPeriodId, long j, long j2) {
        timeline.getPeriodByUid(mediaPeriodId.periodUid, this.period);
        if (mediaPeriodId.isAd()) {
            return getMediaPeriodInfoForAd(timeline, mediaPeriodId.periodUid, mediaPeriodId.adGroupIndex, mediaPeriodId.adIndexInAdGroup, j, mediaPeriodId.windowSequenceNumber);
        }
        return getMediaPeriodInfoForContent(timeline, mediaPeriodId.periodUid, j2, j, mediaPeriodId.windowSequenceNumber);
    }

    private MediaPeriodInfo getMediaPeriodInfoForAd(Timeline timeline, Object obj, int i, int i2, long j, long j2) {
        MediaSource.MediaPeriodId mediaPeriodId = new MediaSource.MediaPeriodId(obj, i, i2, j2);
        long adDurationUs = timeline.getPeriodByUid(mediaPeriodId.periodUid, this.period).getAdDurationUs(mediaPeriodId.adGroupIndex, mediaPeriodId.adIndexInAdGroup);
        long adResumePositionUs = i2 == this.period.getFirstAdIndexToPlay(i) ? this.period.getAdResumePositionUs() : 0L;
        boolean zIsServerSideInsertedAdGroup = this.period.isServerSideInsertedAdGroup(mediaPeriodId.adGroupIndex);
        if (adDurationUs != -9223372036854775807L && adResumePositionUs >= adDurationUs) {
            adResumePositionUs = Math.max(0L, adDurationUs - 1);
        }
        return new MediaPeriodInfo(mediaPeriodId, adResumePositionUs, j, -9223372036854775807L, adDurationUs, zIsServerSideInsertedAdGroup, false, false, false);
    }

    /* JADX WARN: Removed duplicated region for block: B:16:0x004f  */
    /* JADX WARN: Removed duplicated region for block: B:36:0x0099  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    private com.google.android.exoplayer2.MediaPeriodInfo getMediaPeriodInfoForContent(com.google.android.exoplayer2.Timeline r25, java.lang.Object r26, long r27, long r29, long r31) {
        /*
            r24 = this;
            r0 = r24
            r1 = r25
            r2 = r26
            r3 = r27
            com.google.android.exoplayer2.Timeline$Period r5 = r0.period
            r1.getPeriodByUid(r2, r5)
            com.google.android.exoplayer2.Timeline$Period r5 = r0.period
            int r5 = r5.getAdGroupIndexAfterPositionUs(r3)
            r6 = 1
            r7 = 0
            r8 = -1
            if (r5 != r8) goto L2e
            com.google.android.exoplayer2.Timeline$Period r9 = r0.period
            int r9 = r9.getAdGroupCount()
            if (r9 <= 0) goto L4f
            com.google.android.exoplayer2.Timeline$Period r9 = r0.period
            int r10 = r9.getRemovedAdGroupCount()
            boolean r9 = r9.isServerSideInsertedAdGroup(r10)
            if (r9 == 0) goto L4f
            r9 = r6
            goto L50
        L2e:
            com.google.android.exoplayer2.Timeline$Period r9 = r0.period
            boolean r9 = r9.isServerSideInsertedAdGroup(r5)
            if (r9 == 0) goto L4f
            com.google.android.exoplayer2.Timeline$Period r9 = r0.period
            long r9 = r9.getAdGroupTimeUs(r5)
            com.google.android.exoplayer2.Timeline$Period r11 = r0.period
            long r11 = r11.durationUs
            int r9 = (r9 > r11 ? 1 : (r9 == r11 ? 0 : -1))
            if (r9 != 0) goto L4f
            com.google.android.exoplayer2.Timeline$Period r9 = r0.period
            boolean r9 = r9.hasPlayedAdGroup(r5)
            if (r9 == 0) goto L4f
            r9 = r6
            r5 = r8
            goto L50
        L4f:
            r9 = r7
        L50:
            com.google.android.exoplayer2.source.MediaSource$MediaPeriodId r11 = new com.google.android.exoplayer2.source.MediaSource$MediaPeriodId
            r12 = r31
            r11.<init>(r2, r12, r5)
            boolean r2 = r0.isLastInPeriod(r11)
            boolean r22 = r0.isLastInWindow(r1, r11)
            boolean r23 = r0.isLastInTimeline(r1, r11, r2)
            if (r5 == r8) goto L70
            com.google.android.exoplayer2.Timeline$Period r1 = r0.period
            boolean r1 = r1.isServerSideInsertedAdGroup(r5)
            if (r1 == 0) goto L70
            r20 = r6
            goto L72
        L70:
            r20 = r7
        L72:
            r6 = -9223372036854775807(0x8000000000000001, double:-4.9E-324)
            if (r5 == r8) goto L82
            com.google.android.exoplayer2.Timeline$Period r1 = r0.period
            long r8 = r1.getAdGroupTimeUs(r5)
        L7f:
            r16 = r8
            goto L8b
        L82:
            if (r9 == 0) goto L89
            com.google.android.exoplayer2.Timeline$Period r1 = r0.period
            long r8 = r1.durationUs
            goto L7f
        L89:
            r16 = r6
        L8b:
            int r1 = (r16 > r6 ? 1 : (r16 == r6 ? 0 : -1))
            if (r1 == 0) goto L99
            r8 = -9223372036854775808
            int r1 = (r16 > r8 ? 1 : (r16 == r8 ? 0 : -1))
            if (r1 != 0) goto L96
            goto L99
        L96:
            r18 = r16
            goto L9f
        L99:
            com.google.android.exoplayer2.Timeline$Period r1 = r0.period
            long r8 = r1.durationUs
            r18 = r8
        L9f:
            int r1 = (r18 > r6 ? 1 : (r18 == r6 ? 0 : -1))
            if (r1 == 0) goto Lb1
            int r1 = (r3 > r18 ? 1 : (r3 == r18 ? 0 : -1))
            if (r1 < 0) goto Lb1
            r3 = 1
            long r3 = r18 - r3
            r5 = 0
            long r3 = java.lang.Math.max(r5, r3)
        Lb1:
            r12 = r3
            com.google.android.exoplayer2.MediaPeriodInfo r10 = new com.google.android.exoplayer2.MediaPeriodInfo
            r14 = r29
            r21 = r2
            r10.<init>(r11, r12, r14, r16, r18, r20, r21, r22, r23)
            return r10
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.exoplayer2.MediaPeriodQueue.getMediaPeriodInfoForContent(com.google.android.exoplayer2.Timeline, java.lang.Object, long, long, long):com.google.android.exoplayer2.MediaPeriodInfo");
    }

    private boolean isLastInPeriod(MediaSource.MediaPeriodId mediaPeriodId) {
        return !mediaPeriodId.isAd() && mediaPeriodId.nextAdGroupIndex == -1;
    }

    private boolean isLastInWindow(Timeline timeline, MediaSource.MediaPeriodId mediaPeriodId) {
        if (isLastInPeriod(mediaPeriodId)) {
            return timeline.getWindow(timeline.getPeriodByUid(mediaPeriodId.periodUid, this.period).windowIndex, this.window).lastPeriodIndex == timeline.getIndexOfPeriod(mediaPeriodId.periodUid);
        }
        return false;
    }

    private boolean isLastInTimeline(Timeline timeline, MediaSource.MediaPeriodId mediaPeriodId, boolean z) {
        int indexOfPeriod = timeline.getIndexOfPeriod(mediaPeriodId.periodUid);
        return !timeline.getWindow(timeline.getPeriod(indexOfPeriod, this.period).windowIndex, this.window).isDynamic && timeline.isLastPeriod(indexOfPeriod, this.period, this.window, this.repeatMode, this.shuffleModeEnabled) && z;
    }

    private long getMinStartPositionAfterAdGroupUs(Timeline timeline, Object obj, int i) {
        timeline.getPeriodByUid(obj, this.period);
        long adGroupTimeUs = this.period.getAdGroupTimeUs(i);
        if (adGroupTimeUs == Long.MIN_VALUE) {
            return this.period.durationUs;
        }
        return adGroupTimeUs + this.period.getContentResumeOffsetUs(i);
    }
}
