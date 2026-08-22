package com.google.android.exoplayer2;

import android.os.Bundle;
import com.google.android.exoplayer2.Bundleable;
import com.google.android.exoplayer2.util.Assertions;
import com.google.android.exoplayer2.util.Util;

/* JADX INFO: loaded from: classes7.dex */
public final class PlaybackParameters implements Bundleable {
    private static final int FIELD_PITCH = 1;
    private static final int FIELD_SPEED = 0;
    public final float pitch;
    private final int scaledUsPerMs;
    public final float speed;
    public static final PlaybackParameters DEFAULT = new PlaybackParameters(1.0f);
    public static final Bundleable.Creator<PlaybackParameters> CREATOR = new Bundleable.Creator() { // from class: com.google.android.exoplayer2.PlaybackParameters$$ExternalSyntheticLambda0
        @Override // com.google.android.exoplayer2.Bundleable.Creator
        public final Bundleable fromBundle(Bundle bundle) {
            return PlaybackParameters.lambda$static$0(bundle);
        }
    };

    public PlaybackParameters(float f2) {
        this(f2, 1.0f);
    }

    public PlaybackParameters(float f2, float f3) {
        Assertions.checkArgument(f2 > 0.0f);
        Assertions.checkArgument(f3 > 0.0f);
        this.speed = f2;
        this.pitch = f3;
        this.scaledUsPerMs = Math.round(f2 * 1000.0f);
    }

    public long getMediaTimeUsForPlayoutTimeMs(long j) {
        return j * ((long) this.scaledUsPerMs);
    }

    public PlaybackParameters withSpeed(float f2) {
        return new PlaybackParameters(f2, this.pitch);
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj != null && getClass() == obj.getClass()) {
            PlaybackParameters playbackParameters = (PlaybackParameters) obj;
            if (this.speed == playbackParameters.speed && this.pitch == playbackParameters.pitch) {
                return true;
            }
        }
        return false;
    }

    public int hashCode() {
        return ((527 + Float.floatToRawIntBits(this.speed)) * 31) + Float.floatToRawIntBits(this.pitch);
    }

    public String toString() {
        return Util.formatInvariant("PlaybackParameters(speed=%.2f, pitch=%.2f)", Float.valueOf(this.speed), Float.valueOf(this.pitch));
    }

    @Override // com.google.android.exoplayer2.Bundleable
    public Bundle toBundle() {
        Bundle bundle = new Bundle();
        bundle.putFloat(keyForField(0), this.speed);
        bundle.putFloat(keyForField(1), this.pitch);
        return bundle;
    }

    static /* synthetic */ PlaybackParameters lambda$static$0(Bundle bundle) {
        return new PlaybackParameters(bundle.getFloat(keyForField(0), 1.0f), bundle.getFloat(keyForField(1), 1.0f));
    }

    private static String keyForField(int i) {
        return Integer.toString(i, 36);
    }
}
