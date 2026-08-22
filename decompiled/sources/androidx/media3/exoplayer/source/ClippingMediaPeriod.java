package androidx.media3.exoplayer.source;

import androidx.media3.common.Format;
import androidx.media3.common.MimeTypes;
import androidx.media3.common.StreamKey;
import androidx.media3.common.util.Assertions;
import androidx.media3.common.util.Util;
import androidx.media3.decoder.DecoderInputBuffer;
import androidx.media3.exoplayer.FormatHolder;
import androidx.media3.exoplayer.LoadingInfo;
import androidx.media3.exoplayer.SeekParameters;
import androidx.media3.exoplayer.source.ClippingMediaSource;
import androidx.media3.exoplayer.source.MediaPeriod;
import androidx.media3.exoplayer.trackselection.ExoTrackSelection;
import java.io.IOException;
import java.util.List;

/* JADX INFO: loaded from: classes3.dex */
public final class ClippingMediaPeriod implements MediaPeriod, MediaPeriod.Callback {
    private MediaPeriod.Callback callback;
    private ClippingMediaSource.IllegalClippingException clippingError;
    long endUs;
    public final MediaPeriod mediaPeriod;
    private long pendingInitialDiscontinuityPositionUs;
    private ClippingSampleStream[] sampleStreams = new ClippingSampleStream[0];
    long startUs;

    public ClippingMediaPeriod(MediaPeriod mediaPeriod, boolean z, long j, long j2) {
        this.mediaPeriod = mediaPeriod;
        this.pendingInitialDiscontinuityPositionUs = z ? j : -9223372036854775807L;
        this.startUs = j;
        this.endUs = j2;
    }

    public void updateClipping(long j, long j2) {
        this.startUs = j;
        this.endUs = j2;
    }

    public void setClippingError(ClippingMediaSource.IllegalClippingException illegalClippingException) {
        this.clippingError = illegalClippingException;
    }

    @Override // androidx.media3.exoplayer.source.MediaPeriod
    public void prepare(MediaPeriod.Callback callback, long j) {
        this.callback = callback;
        this.mediaPeriod.prepare(this, j);
    }

    @Override // androidx.media3.exoplayer.source.MediaPeriod
    public void maybeThrowPrepareError() throws IOException {
        ClippingMediaSource.IllegalClippingException illegalClippingException = this.clippingError;
        if (illegalClippingException != null) {
            throw illegalClippingException;
        }
        this.mediaPeriod.maybeThrowPrepareError();
    }

    @Override // androidx.media3.exoplayer.source.MediaPeriod
    public List<StreamKey> getStreamKeys(List<ExoTrackSelection> list) {
        return this.mediaPeriod.getStreamKeys(list);
    }

    @Override // androidx.media3.exoplayer.source.MediaPeriod
    public TrackGroupArray getTrackGroups() {
        return this.mediaPeriod.getTrackGroups();
    }

    /* JADX WARN: Removed duplicated region for block: B:16:0x003d  */
    /* JADX WARN: Removed duplicated region for block: B:27:0x005d  */
    @Override // androidx.media3.exoplayer.source.MediaPeriod
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public long selectTracks(androidx.media3.exoplayer.trackselection.ExoTrackSelection[] r10, boolean[] r11, androidx.media3.exoplayer.source.SampleStream[] r12, boolean[] r13, long r14) {
        /*
            r9 = this;
            int r0 = r12.length
            androidx.media3.exoplayer.source.ClippingMediaPeriod$ClippingSampleStream[] r0 = new androidx.media3.exoplayer.source.ClippingMediaPeriod.ClippingSampleStream[r0]
            r9.sampleStreams = r0
            int r0 = r12.length
            androidx.media3.exoplayer.source.SampleStream[] r4 = new androidx.media3.exoplayer.source.SampleStream[r0]
            r0 = 0
            r1 = r0
        La:
            int r2 = r12.length
            r8 = 0
            if (r1 >= r2) goto L1f
            androidx.media3.exoplayer.source.ClippingMediaPeriod$ClippingSampleStream[] r2 = r9.sampleStreams
            r3 = r12[r1]
            androidx.media3.exoplayer.source.ClippingMediaPeriod$ClippingSampleStream r3 = (androidx.media3.exoplayer.source.ClippingMediaPeriod.ClippingSampleStream) r3
            r2[r1] = r3
            if (r3 == 0) goto L1a
            androidx.media3.exoplayer.source.SampleStream r8 = r3.childStream
        L1a:
            r4[r1] = r8
            int r1 = r1 + 1
            goto La
        L1f:
            androidx.media3.exoplayer.source.MediaPeriod r1 = r9.mediaPeriod
            r2 = r10
            r3 = r11
            r5 = r13
            r6 = r14
            long r10 = r1.selectTracks(r2, r3, r4, r5, r6)
            boolean r13 = r9.isPendingInitialDiscontinuity()
            if (r13 == 0) goto L3d
            long r13 = r9.startUs
            int r15 = (r6 > r13 ? 1 : (r6 == r13 ? 0 : -1))
            if (r15 != 0) goto L3d
            boolean r13 = shouldKeepInitialDiscontinuity(r13, r2)
            if (r13 == 0) goto L3d
            r13 = r10
            goto L42
        L3d:
            r13 = -9223372036854775807(0x8000000000000001, double:-4.9E-324)
        L42:
            r9.pendingInitialDiscontinuityPositionUs = r13
            int r13 = (r10 > r6 ? 1 : (r10 == r6 ? 0 : -1))
            if (r13 == 0) goto L5d
            long r13 = r9.startUs
            int r13 = (r10 > r13 ? 1 : (r10 == r13 ? 0 : -1))
            if (r13 < 0) goto L5b
            long r13 = r9.endUs
            r1 = -9223372036854775808
            int r15 = (r13 > r1 ? 1 : (r13 == r1 ? 0 : -1))
            if (r15 == 0) goto L5d
            int r13 = (r10 > r13 ? 1 : (r10 == r13 ? 0 : -1))
            if (r13 > 0) goto L5b
            goto L5d
        L5b:
            r13 = r0
            goto L5e
        L5d:
            r13 = 1
        L5e:
            androidx.media3.common.util.Assertions.checkState(r13)
        L61:
            int r13 = r12.length
            if (r0 >= r13) goto L8d
            r13 = r4[r0]
            if (r13 != 0) goto L6d
            androidx.media3.exoplayer.source.ClippingMediaPeriod$ClippingSampleStream[] r13 = r9.sampleStreams
            r13[r0] = r8
            goto L84
        L6d:
            androidx.media3.exoplayer.source.ClippingMediaPeriod$ClippingSampleStream[] r13 = r9.sampleStreams
            r13 = r13[r0]
            if (r13 == 0) goto L79
            androidx.media3.exoplayer.source.SampleStream r13 = r13.childStream
            r14 = r4[r0]
            if (r13 == r14) goto L84
        L79:
            androidx.media3.exoplayer.source.ClippingMediaPeriod$ClippingSampleStream[] r13 = r9.sampleStreams
            androidx.media3.exoplayer.source.ClippingMediaPeriod$ClippingSampleStream r14 = new androidx.media3.exoplayer.source.ClippingMediaPeriod$ClippingSampleStream
            r15 = r4[r0]
            r14.<init>(r15)
            r13[r0] = r14
        L84:
            androidx.media3.exoplayer.source.ClippingMediaPeriod$ClippingSampleStream[] r13 = r9.sampleStreams
            r13 = r13[r0]
            r12[r0] = r13
            int r0 = r0 + 1
            goto L61
        L8d:
            return r10
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.media3.exoplayer.source.ClippingMediaPeriod.selectTracks(androidx.media3.exoplayer.trackselection.ExoTrackSelection[], boolean[], androidx.media3.exoplayer.source.SampleStream[], boolean[], long):long");
    }

    @Override // androidx.media3.exoplayer.source.MediaPeriod
    public void discardBuffer(long j, boolean z) {
        this.mediaPeriod.discardBuffer(j, z);
    }

    @Override // androidx.media3.exoplayer.source.MediaPeriod, androidx.media3.exoplayer.source.SequenceableLoader
    public void reevaluateBuffer(long j) {
        this.mediaPeriod.reevaluateBuffer(j);
    }

    @Override // androidx.media3.exoplayer.source.MediaPeriod
    public long readDiscontinuity() {
        if (isPendingInitialDiscontinuity()) {
            long j = this.pendingInitialDiscontinuityPositionUs;
            this.pendingInitialDiscontinuityPositionUs = -9223372036854775807L;
            long discontinuity = readDiscontinuity();
            return discontinuity != -9223372036854775807L ? discontinuity : j;
        }
        long discontinuity2 = this.mediaPeriod.readDiscontinuity();
        if (discontinuity2 == -9223372036854775807L) {
            return -9223372036854775807L;
        }
        boolean z = true;
        Assertions.checkState(discontinuity2 >= this.startUs);
        long j2 = this.endUs;
        if (j2 != Long.MIN_VALUE && discontinuity2 > j2) {
            z = false;
        }
        Assertions.checkState(z);
        return discontinuity2;
    }

    @Override // androidx.media3.exoplayer.source.MediaPeriod, androidx.media3.exoplayer.source.SequenceableLoader
    public long getBufferedPositionUs() {
        long bufferedPositionUs = this.mediaPeriod.getBufferedPositionUs();
        if (bufferedPositionUs != Long.MIN_VALUE) {
            long j = this.endUs;
            if (j == Long.MIN_VALUE || bufferedPositionUs < j) {
                return bufferedPositionUs;
            }
        }
        return Long.MIN_VALUE;
    }

    /* JADX WARN: Removed duplicated region for block: B:16:0x0034  */
    @Override // androidx.media3.exoplayer.source.MediaPeriod
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public long seekToUs(long r6) {
        /*
            r5 = this;
            r0 = -9223372036854775807(0x8000000000000001, double:-4.9E-324)
            r5.pendingInitialDiscontinuityPositionUs = r0
            androidx.media3.exoplayer.source.ClippingMediaPeriod$ClippingSampleStream[] r0 = r5.sampleStreams
            int r1 = r0.length
            r2 = 0
            r3 = r2
        Lc:
            if (r3 >= r1) goto L18
            r4 = r0[r3]
            if (r4 == 0) goto L15
            r4.clearSentEos()
        L15:
            int r3 = r3 + 1
            goto Lc
        L18:
            androidx.media3.exoplayer.source.MediaPeriod r0 = r5.mediaPeriod
            long r0 = r0.seekToUs(r6)
            int r6 = (r0 > r6 ? 1 : (r0 == r6 ? 0 : -1))
            if (r6 == 0) goto L34
            long r6 = r5.startUs
            int r6 = (r0 > r6 ? 1 : (r0 == r6 ? 0 : -1))
            if (r6 < 0) goto L35
            long r6 = r5.endUs
            r3 = -9223372036854775808
            int r3 = (r6 > r3 ? 1 : (r6 == r3 ? 0 : -1))
            if (r3 == 0) goto L34
            int r6 = (r0 > r6 ? 1 : (r0 == r6 ? 0 : -1))
            if (r6 > 0) goto L35
        L34:
            r2 = 1
        L35:
            androidx.media3.common.util.Assertions.checkState(r2)
            return r0
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.media3.exoplayer.source.ClippingMediaPeriod.seekToUs(long):long");
    }

    @Override // androidx.media3.exoplayer.source.MediaPeriod
    public long getAdjustedSeekPositionUs(long j, SeekParameters seekParameters) {
        long j2 = this.startUs;
        if (j == j2) {
            return j2;
        }
        return this.mediaPeriod.getAdjustedSeekPositionUs(j, clipSeekParameters(j, seekParameters));
    }

    @Override // androidx.media3.exoplayer.source.MediaPeriod, androidx.media3.exoplayer.source.SequenceableLoader
    public long getNextLoadPositionUs() {
        long nextLoadPositionUs = this.mediaPeriod.getNextLoadPositionUs();
        if (nextLoadPositionUs != Long.MIN_VALUE) {
            long j = this.endUs;
            if (j == Long.MIN_VALUE || nextLoadPositionUs < j) {
                return nextLoadPositionUs;
            }
        }
        return Long.MIN_VALUE;
    }

    @Override // androidx.media3.exoplayer.source.MediaPeriod, androidx.media3.exoplayer.source.SequenceableLoader
    public boolean continueLoading(LoadingInfo loadingInfo) {
        return this.mediaPeriod.continueLoading(loadingInfo);
    }

    @Override // androidx.media3.exoplayer.source.MediaPeriod, androidx.media3.exoplayer.source.SequenceableLoader
    public boolean isLoading() {
        return this.mediaPeriod.isLoading();
    }

    @Override // androidx.media3.exoplayer.source.MediaPeriod.Callback
    public void onPrepared(MediaPeriod mediaPeriod) {
        if (this.clippingError != null) {
            return;
        }
        ((MediaPeriod.Callback) Assertions.checkNotNull(this.callback)).onPrepared(this);
    }

    @Override // androidx.media3.exoplayer.source.SequenceableLoader.Callback
    public void onContinueLoadingRequested(MediaPeriod mediaPeriod) {
        ((MediaPeriod.Callback) Assertions.checkNotNull(this.callback)).onContinueLoadingRequested(this);
    }

    boolean isPendingInitialDiscontinuity() {
        return this.pendingInitialDiscontinuityPositionUs != -9223372036854775807L;
    }

    private SeekParameters clipSeekParameters(long j, SeekParameters seekParameters) {
        long jConstrainValue = Util.constrainValue(seekParameters.toleranceBeforeUs, 0L, j - this.startUs);
        long j2 = seekParameters.toleranceAfterUs;
        long j3 = this.endUs;
        long jConstrainValue2 = Util.constrainValue(j2, 0L, j3 == Long.MIN_VALUE ? Long.MAX_VALUE : j3 - j);
        return (jConstrainValue == seekParameters.toleranceBeforeUs && jConstrainValue2 == seekParameters.toleranceAfterUs) ? seekParameters : new SeekParameters(jConstrainValue, jConstrainValue2);
    }

    private static boolean shouldKeepInitialDiscontinuity(long j, ExoTrackSelection[] exoTrackSelectionArr) {
        if (j != 0) {
            for (ExoTrackSelection exoTrackSelection : exoTrackSelectionArr) {
                if (exoTrackSelection != null) {
                    Format selectedFormat = exoTrackSelection.getSelectedFormat();
                    if (!MimeTypes.allSamplesAreSyncSamples(selectedFormat.sampleMimeType, selectedFormat.codecs)) {
                        return true;
                    }
                }
            }
        }
        return false;
    }

    private final class ClippingSampleStream implements SampleStream {
        public final SampleStream childStream;
        private boolean sentEos;

        public ClippingSampleStream(SampleStream sampleStream) {
            this.childStream = sampleStream;
        }

        public void clearSentEos() {
            this.sentEos = false;
        }

        @Override // androidx.media3.exoplayer.source.SampleStream
        public boolean isReady() {
            return !ClippingMediaPeriod.this.isPendingInitialDiscontinuity() && this.childStream.isReady();
        }

        @Override // androidx.media3.exoplayer.source.SampleStream
        public void maybeThrowError() throws IOException {
            this.childStream.maybeThrowError();
        }

        @Override // androidx.media3.exoplayer.source.SampleStream
        public int readData(FormatHolder formatHolder, DecoderInputBuffer decoderInputBuffer, int i) {
            if (ClippingMediaPeriod.this.isPendingInitialDiscontinuity()) {
                return -3;
            }
            if (this.sentEos) {
                decoderInputBuffer.setFlags(4);
                return -4;
            }
            long bufferedPositionUs = ClippingMediaPeriod.this.getBufferedPositionUs();
            int data = this.childStream.readData(formatHolder, decoderInputBuffer, i);
            if (data == -5) {
                Format format = (Format) Assertions.checkNotNull(formatHolder.format);
                if (format.encoderDelay != 0 || format.encoderPadding != 0) {
                    formatHolder.format = format.buildUpon().setEncoderDelay(ClippingMediaPeriod.this.startUs != 0 ? 0 : format.encoderDelay).setEncoderPadding(ClippingMediaPeriod.this.endUs == Long.MIN_VALUE ? format.encoderPadding : 0).build();
                }
                return -5;
            }
            if (ClippingMediaPeriod.this.endUs == Long.MIN_VALUE || ((data != -4 || decoderInputBuffer.timeUs < ClippingMediaPeriod.this.endUs) && !(data == -3 && bufferedPositionUs == Long.MIN_VALUE && !decoderInputBuffer.waitingForKeys))) {
                return data;
            }
            decoderInputBuffer.clear();
            decoderInputBuffer.setFlags(4);
            this.sentEos = true;
            return -4;
        }

        @Override // androidx.media3.exoplayer.source.SampleStream
        public int skipData(long j) {
            if (ClippingMediaPeriod.this.isPendingInitialDiscontinuity()) {
                return -3;
            }
            return this.childStream.skipData(j);
        }
    }
}
