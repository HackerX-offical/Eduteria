package com.pallycon.widevine.track;

import androidx.media3.common.Format;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes9.dex */
@Metadata(d1 = {"\u0000\u001a\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u000b\u0018\u00002\u00020\u0001B\u000f\b\u0000\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0002\u0010\u0004R\u001a\u0010\u0005\u001a\u00020\u0006X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0007\u0010\b\"\u0004\b\t\u0010\nR\u001a\u0010\u000b\u001a\u00020\u0006X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\f\u0010\b\"\u0004\b\r\u0010\nR\u001a\u0010\u000e\u001a\u00020\u0006X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u000f\u0010\b\"\u0004\b\u0010\u0010\n¨\u0006\u0011"}, d2 = {"Lcom/pallycon/widevine/track/AudioTrackInfo;", "Lcom/pallycon/widevine/track/TrackInfo;", "format", "Landroidx/media3/common/Format;", "(Landroidx/media3/common/Format;)V", "channelCount", "", "getChannelCount", "()I", "setChannelCount", "(I)V", "maxInputSize", "getMaxInputSize", "setMaxInputSize", "sampleRate", "getSampleRate", "setSampleRate", "widevine_release"}, k = 1, mv = {1, 9, 0}, xi = 48)
public final class AudioTrackInfo extends TrackInfo {
    private int channelCount;
    private int maxInputSize;
    private int sampleRate;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public AudioTrackInfo(Format format) {
        super(format);
        Intrinsics.checkNotNullParameter(format, "format");
        this.sampleRate = format.sampleRate;
        this.maxInputSize = format.maxInputSize;
        this.channelCount = format.channelCount;
    }

    public final int getChannelCount() {
        return this.channelCount;
    }

    public final int getMaxInputSize() {
        return this.maxInputSize;
    }

    public final int getSampleRate() {
        return this.sampleRate;
    }

    public final void setChannelCount(int i) {
        this.channelCount = i;
    }

    public final void setMaxInputSize(int i) {
        this.maxInputSize = i;
    }

    public final void setSampleRate(int i) {
        this.sampleRate = i;
    }
}
