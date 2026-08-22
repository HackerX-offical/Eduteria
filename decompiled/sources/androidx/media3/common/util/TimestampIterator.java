package androidx.media3.common.util;

/* JADX INFO: loaded from: classes3.dex */
public interface TimestampIterator {
    TimestampIterator copyOf();

    default long getLastTimestampUs() {
        return -9223372036854775807L;
    }

    boolean hasNext();

    long next();
}
