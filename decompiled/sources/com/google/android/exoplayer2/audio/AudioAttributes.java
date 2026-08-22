package com.google.android.exoplayer2.audio;

import android.media.AudioAttributes;
import android.os.Bundle;
import com.google.android.exoplayer2.Bundleable;
import com.google.android.exoplayer2.util.Util;

/* JADX INFO: loaded from: classes7.dex */
public final class AudioAttributes implements Bundleable {
    private static final int FIELD_ALLOWED_CAPTURE_POLICY = 3;
    private static final int FIELD_CONTENT_TYPE = 0;
    private static final int FIELD_FLAGS = 1;
    private static final int FIELD_SPATIALIZATION_BEHAVIOR = 4;
    private static final int FIELD_USAGE = 2;
    public final int allowedCapturePolicy;
    private android.media.AudioAttributes audioAttributesV21;
    public final int contentType;
    public final int flags;
    public final int spatializationBehavior;
    public final int usage;
    public static final AudioAttributes DEFAULT = new Builder().build();
    public static final Bundleable.Creator<AudioAttributes> CREATOR = new Bundleable.Creator() { // from class: com.google.android.exoplayer2.audio.AudioAttributes$$ExternalSyntheticLambda0
        @Override // com.google.android.exoplayer2.Bundleable.Creator
        public final Bundleable fromBundle(Bundle bundle) {
            return AudioAttributes.lambda$static$0(bundle);
        }
    };

    public static final class Builder {
        private int contentType = 0;
        private int flags = 0;
        private int usage = 1;
        private int allowedCapturePolicy = 1;
        private int spatializationBehavior = 0;

        public Builder setContentType(int i) {
            this.contentType = i;
            return this;
        }

        public Builder setFlags(int i) {
            this.flags = i;
            return this;
        }

        public Builder setUsage(int i) {
            this.usage = i;
            return this;
        }

        public Builder setAllowedCapturePolicy(int i) {
            this.allowedCapturePolicy = i;
            return this;
        }

        public Builder setSpatializationBehavior(int i) {
            this.spatializationBehavior = i;
            return this;
        }

        public AudioAttributes build() {
            return new AudioAttributes(this.contentType, this.flags, this.usage, this.allowedCapturePolicy, this.spatializationBehavior);
        }
    }

    private AudioAttributes(int i, int i2, int i3, int i4, int i5) {
        this.contentType = i;
        this.flags = i2;
        this.usage = i3;
        this.allowedCapturePolicy = i4;
        this.spatializationBehavior = i5;
    }

    public android.media.AudioAttributes getAudioAttributesV21() {
        if (this.audioAttributesV21 == null) {
            AudioAttributes.Builder usage = new AudioAttributes.Builder().setContentType(this.contentType).setFlags(this.flags).setUsage(this.usage);
            if (Util.SDK_INT >= 29) {
                Api29.setAllowedCapturePolicy(usage, this.allowedCapturePolicy);
            }
            if (Util.SDK_INT >= 32) {
                Api32.setSpatializationBehavior(usage, this.spatializationBehavior);
            }
            this.audioAttributesV21 = usage.build();
        }
        return this.audioAttributesV21;
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj != null && getClass() == obj.getClass()) {
            AudioAttributes audioAttributes = (AudioAttributes) obj;
            if (this.contentType == audioAttributes.contentType && this.flags == audioAttributes.flags && this.usage == audioAttributes.usage && this.allowedCapturePolicy == audioAttributes.allowedCapturePolicy && this.spatializationBehavior == audioAttributes.spatializationBehavior) {
                return true;
            }
        }
        return false;
    }

    public int hashCode() {
        return ((((((((527 + this.contentType) * 31) + this.flags) * 31) + this.usage) * 31) + this.allowedCapturePolicy) * 31) + this.spatializationBehavior;
    }

    @Override // com.google.android.exoplayer2.Bundleable
    public Bundle toBundle() {
        Bundle bundle = new Bundle();
        bundle.putInt(keyForField(0), this.contentType);
        bundle.putInt(keyForField(1), this.flags);
        bundle.putInt(keyForField(2), this.usage);
        bundle.putInt(keyForField(3), this.allowedCapturePolicy);
        bundle.putInt(keyForField(4), this.spatializationBehavior);
        return bundle;
    }

    static /* synthetic */ AudioAttributes lambda$static$0(Bundle bundle) {
        Builder builder = new Builder();
        if (bundle.containsKey(keyForField(0))) {
            builder.setContentType(bundle.getInt(keyForField(0)));
        }
        if (bundle.containsKey(keyForField(1))) {
            builder.setFlags(bundle.getInt(keyForField(1)));
        }
        if (bundle.containsKey(keyForField(2))) {
            builder.setUsage(bundle.getInt(keyForField(2)));
        }
        if (bundle.containsKey(keyForField(3))) {
            builder.setAllowedCapturePolicy(bundle.getInt(keyForField(3)));
        }
        if (bundle.containsKey(keyForField(4))) {
            builder.setSpatializationBehavior(bundle.getInt(keyForField(4)));
        }
        return builder.build();
    }

    private static String keyForField(int i) {
        return Integer.toString(i, 36);
    }

    private static final class Api29 {
        private Api29() {
        }

        public static void setAllowedCapturePolicy(AudioAttributes.Builder builder, int i) {
            builder.setAllowedCapturePolicy(i);
        }
    }

    private static final class Api32 {
        private Api32() {
        }

        public static void setSpatializationBehavior(AudioAttributes.Builder builder, int i) {
            try {
                builder.getClass().getMethod("setSpatializationBehavior", Integer.TYPE).invoke(builder, Integer.valueOf(i));
            } catch (Exception unused) {
            }
        }
    }
}
