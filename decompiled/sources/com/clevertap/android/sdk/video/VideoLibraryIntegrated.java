package com.clevertap.android.sdk.video;

import kotlin.Metadata;
import kotlin.enums.EnumEntries;
import kotlin.enums.EnumEntriesKt;

/* JADX WARN: Failed to restore enum class, 'enum' modifier and super class removed */
/* JADX WARN: Unknown enum class pattern. Please report as an issue! */
/* JADX INFO: compiled from: VideoLibChecker.kt */
/* JADX INFO: loaded from: classes7.dex */
@Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\b\u0006\b\u0086\u0081\u0002\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003j\u0002\b\u0004j\u0002\b\u0005j\u0002\b\u0006¨\u0006\u0007"}, d2 = {"Lcom/clevertap/android/sdk/video/VideoLibraryIntegrated;", "", "<init>", "(Ljava/lang/String;I)V", "EXOPLAYER", "MEDIA3", "NONE", "clevertap-core_release"}, k = 1, mv = {2, 0, 0}, xi = 48)
public final class VideoLibraryIntegrated {
    private static final /* synthetic */ EnumEntries $ENTRIES;
    private static final /* synthetic */ VideoLibraryIntegrated[] $VALUES;
    public static final VideoLibraryIntegrated EXOPLAYER = new VideoLibraryIntegrated("EXOPLAYER", 0);
    public static final VideoLibraryIntegrated MEDIA3 = new VideoLibraryIntegrated("MEDIA3", 1);
    public static final VideoLibraryIntegrated NONE = new VideoLibraryIntegrated("NONE", 2);

    private static final /* synthetic */ VideoLibraryIntegrated[] $values() {
        return new VideoLibraryIntegrated[]{EXOPLAYER, MEDIA3, NONE};
    }

    public static EnumEntries<VideoLibraryIntegrated> getEntries() {
        return $ENTRIES;
    }

    private VideoLibraryIntegrated(String str, int i) {
    }

    static {
        VideoLibraryIntegrated[] videoLibraryIntegratedArr$values = $values();
        $VALUES = videoLibraryIntegratedArr$values;
        $ENTRIES = EnumEntriesKt.enumEntries(videoLibraryIntegratedArr$values);
    }

    public static VideoLibraryIntegrated valueOf(String str) {
        return (VideoLibraryIntegrated) Enum.valueOf(VideoLibraryIntegrated.class, str);
    }

    public static VideoLibraryIntegrated[] values() {
        return (VideoLibraryIntegrated[]) $VALUES.clone();
    }
}
