package info.mqtt.android.service;

import kotlin.Metadata;
import kotlin.enums.EnumEntries;
import kotlin.enums.EnumEntriesKt;

/* JADX WARN: Failed to restore enum class, 'enum' modifier and super class removed */
/* JADX WARN: Unknown enum class pattern. Please report as an issue! */
/* JADX INFO: compiled from: Status.kt */
/* JADX INFO: loaded from: classes9.dex */
@Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\b\u0005\b\u0086\u0081\u0002\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003j\u0002\b\u0004j\u0002\b\u0005¨\u0006\u0006"}, d2 = {"Linfo/mqtt/android/service/Status;", "", "<init>", "(Ljava/lang/String;I)V", "OK", "ERROR", "serviceLibrary_release"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final class Status {
    private static final /* synthetic */ EnumEntries $ENTRIES;
    private static final /* synthetic */ Status[] $VALUES;
    public static final Status OK = new Status("OK", 0);
    public static final Status ERROR = new Status("ERROR", 1);

    private static final /* synthetic */ Status[] $values() {
        return new Status[]{OK, ERROR};
    }

    public static EnumEntries<Status> getEntries() {
        return $ENTRIES;
    }

    private Status(String str, int i) {
    }

    static {
        Status[] statusArr$values = $values();
        $VALUES = statusArr$values;
        $ENTRIES = EnumEntriesKt.enumEntries(statusArr$values);
    }

    public static Status valueOf(String str) {
        return (Status) Enum.valueOf(Status.class, str);
    }

    public static Status[] values() {
        return (Status[]) $VALUES.clone();
    }
}
