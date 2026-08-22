package androidx.media3.exoplayer.hls;

import androidx.media3.common.util.Util;
import androidx.media3.exoplayer.source.chunk.MediaChunk;
import com.clevertap.android.sdk.Constants;
import java.io.IOException;

/* JADX INFO: loaded from: classes3.dex */
final class UnexpectedSampleTimestampException extends IOException {
    public final long lastAcceptedSampleTimeUs;
    public final MediaChunk mediaChunk;
    public final long rejectedSampleTimeUs;

    public UnexpectedSampleTimestampException(MediaChunk mediaChunk, long j, long j2) {
        super("Unexpected sample timestamp: " + Util.usToMs(j2) + " in chunk [" + mediaChunk.startTimeUs + ", " + mediaChunk.endTimeUs + Constants.AES_SUFFIX);
        this.mediaChunk = mediaChunk;
        this.lastAcceptedSampleTimeUs = j;
        this.rejectedSampleTimeUs = j2;
    }
}
