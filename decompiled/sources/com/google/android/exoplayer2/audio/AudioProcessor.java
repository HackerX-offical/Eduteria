package com.google.android.exoplayer2.audio;

import com.google.android.exoplayer2.util.Util;
import java.nio.ByteBuffer;
import java.nio.ByteOrder;

/* JADX INFO: loaded from: classes7.dex */
public interface AudioProcessor {
    public static final ByteBuffer EMPTY_BUFFER = ByteBuffer.allocateDirect(0).order(ByteOrder.nativeOrder());

    AudioFormat configure(AudioFormat audioFormat) throws UnhandledAudioFormatException;

    void flush();

    ByteBuffer getOutput();

    boolean isActive();

    boolean isEnded();

    void queueEndOfStream();

    void queueInput(ByteBuffer byteBuffer);

    void reset();

    public static final class AudioFormat {
        public static final AudioFormat NOT_SET = new AudioFormat(-1, -1, -1);
        public final int bytesPerFrame;
        public final int channelCount;
        public final int encoding;
        public final int sampleRate;

        public AudioFormat(int i, int i2, int i3) {
            this.sampleRate = i;
            this.channelCount = i2;
            this.encoding = i3;
            this.bytesPerFrame = Util.isEncodingLinearPcm(i3) ? Util.getPcmFrameSize(i3, i2) : -1;
        }

        public String toString() {
            int i = this.sampleRate;
            int i2 = this.channelCount;
            return new StringBuilder(83).append("AudioFormat[sampleRate=").append(i).append(", channelCount=").append(i2).append(", encoding=").append(this.encoding).append(']').toString();
        }
    }

    public static final class UnhandledAudioFormatException extends Exception {
        /* JADX WARN: Illegal instructions before constructor call */
        public UnhandledAudioFormatException(AudioFormat audioFormat) {
            String strValueOf = String.valueOf(audioFormat);
            super(new StringBuilder(String.valueOf(strValueOf).length() + 18).append("Unhandled format: ").append(strValueOf).toString());
        }
    }
}
