package com.pallycon.widevine.model;

import kotlin.Metadata;
import kotlin.enums.EnumEntries;
import kotlin.enums.EnumEntriesKt;

/* JADX WARN: Failed to restore enum class, 'enum' modifier and super class removed */
/* JADX WARN: Unknown enum class pattern. Please report as an issue! */
/* JADX INFO: loaded from: classes9.dex */
@Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\b\u000b\b\u0086\u0081\u0002\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002j\u0002\b\u0003j\u0002\b\u0004j\u0002\b\u0005j\u0002\b\u0006j\u0002\b\u0007j\u0002\b\bj\u0002\b\tj\u0002\b\nj\u0002\b\u000b¨\u0006\f"}, d2 = {"Lcom/pallycon/widevine/model/DownloadState;", "", "(Ljava/lang/String;I)V", "NOT", "QUEUED", "STOPPED", "DOWNLOADING", "COMPLETED", "FAILED", "REMOVING", "RESTARTING", "PAUSED", "widevine_release"}, k = 1, mv = {1, 9, 0}, xi = 48)
public final class DownloadState {
    private static final /* synthetic */ EnumEntries $ENTRIES;
    private static final /* synthetic */ DownloadState[] $VALUES;
    public static final DownloadState NOT = new DownloadState("NOT", 0);
    public static final DownloadState QUEUED = new DownloadState("QUEUED", 1);
    public static final DownloadState STOPPED = new DownloadState("STOPPED", 2);
    public static final DownloadState DOWNLOADING = new DownloadState("DOWNLOADING", 3);
    public static final DownloadState COMPLETED = new DownloadState("COMPLETED", 4);
    public static final DownloadState FAILED = new DownloadState("FAILED", 5);
    public static final DownloadState REMOVING = new DownloadState("REMOVING", 6);
    public static final DownloadState RESTARTING = new DownloadState("RESTARTING", 7);
    public static final DownloadState PAUSED = new DownloadState("PAUSED", 8);

    private static final /* synthetic */ DownloadState[] $values() {
        return new DownloadState[]{NOT, QUEUED, STOPPED, DOWNLOADING, COMPLETED, FAILED, REMOVING, RESTARTING, PAUSED};
    }

    static {
        DownloadState[] downloadStateArr$values = $values();
        $VALUES = downloadStateArr$values;
        $ENTRIES = EnumEntriesKt.enumEntries(downloadStateArr$values);
    }

    private DownloadState(String str, int i) {
    }

    public static EnumEntries<DownloadState> getEntries() {
        return $ENTRIES;
    }

    public static DownloadState valueOf(String str) {
        return (DownloadState) Enum.valueOf(DownloadState.class, str);
    }

    public static DownloadState[] values() {
        return (DownloadState[]) $VALUES.clone();
    }
}
