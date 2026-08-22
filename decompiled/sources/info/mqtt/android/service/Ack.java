package info.mqtt.android.service;

import kotlin.Metadata;
import kotlin.enums.EnumEntries;
import kotlin.enums.EnumEntriesKt;

/* JADX WARN: Failed to restore enum class, 'enum' modifier and super class removed */
/* JADX WARN: Unknown enum class pattern. Please report as an issue! */
/* JADX INFO: compiled from: Ack.kt */
/* JADX INFO: loaded from: classes9.dex */
@Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\b\u0005\b\u0086\u0081\u0002\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003j\u0002\b\u0004j\u0002\b\u0005¨\u0006\u0006"}, d2 = {"Linfo/mqtt/android/service/Ack;", "", "<init>", "(Ljava/lang/String;I)V", "AUTO_ACK", "MANUAL_ACK", "serviceLibrary_release"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final class Ack {
    private static final /* synthetic */ EnumEntries $ENTRIES;
    private static final /* synthetic */ Ack[] $VALUES;
    public static final Ack AUTO_ACK = new Ack("AUTO_ACK", 0);
    public static final Ack MANUAL_ACK = new Ack("MANUAL_ACK", 1);

    private static final /* synthetic */ Ack[] $values() {
        return new Ack[]{AUTO_ACK, MANUAL_ACK};
    }

    public static EnumEntries<Ack> getEntries() {
        return $ENTRIES;
    }

    private Ack(String str, int i) {
    }

    static {
        Ack[] ackArr$values = $values();
        $VALUES = ackArr$values;
        $ENTRIES = EnumEntriesKt.enumEntries(ackArr$values);
    }

    public static Ack valueOf(String str) {
        return (Ack) Enum.valueOf(Ack.class, str);
    }

    public static Ack[] values() {
        return (Ack[]) $VALUES.clone();
    }
}
