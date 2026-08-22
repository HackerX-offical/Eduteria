package info.mqtt.android.service;

import kotlin.Metadata;
import kotlin.enums.EnumEntries;
import kotlin.enums.EnumEntriesKt;
import kotlin.jvm.JvmStatic;
import kotlin.jvm.internal.DefaultConstructorMarker;

/* JADX WARN: Failed to restore enum class, 'enum' modifier and super class removed */
/* JADX WARN: Unknown enum class pattern. Please report as an issue! */
/* JADX INFO: compiled from: QoS.kt */
/* JADX INFO: loaded from: classes9.dex */
@Metadata(d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0000\n\u0002\u0010\b\n\u0002\b\t\b\u0086\u0081\u0002\u0018\u0000 \u000b2\b\u0012\u0004\u0012\u00020\u00000\u0001:\u0001\u000bB\u0011\b\u0002\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0004\b\u0004\u0010\u0005R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0006\u0010\u0007j\u0002\b\bj\u0002\b\tj\u0002\b\n¨\u0006\f"}, d2 = {"Linfo/mqtt/android/service/QoS;", "", "value", "", "<init>", "(Ljava/lang/String;II)V", "getValue", "()I", "AtMostOnce", "AtLeastOnce", "ExactlyOnce", "Companion", "serviceLibrary_release"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final class QoS {
    private static final /* synthetic */ EnumEntries $ENTRIES;
    private static final /* synthetic */ QoS[] $VALUES;

    /* JADX INFO: renamed from: Companion, reason: from kotlin metadata */
    public static final Companion INSTANCE;
    private final int value;
    public static final QoS AtMostOnce = new QoS("AtMostOnce", 0, 0);
    public static final QoS AtLeastOnce = new QoS("AtLeastOnce", 1, 1);
    public static final QoS ExactlyOnce = new QoS("ExactlyOnce", 2, 2);

    private static final /* synthetic */ QoS[] $values() {
        return new QoS[]{AtMostOnce, AtLeastOnce, ExactlyOnce};
    }

    public static EnumEntries<QoS> getEntries() {
        return $ENTRIES;
    }

    @JvmStatic
    public static final QoS valueOf(int i) {
        return INSTANCE.valueOf(i);
    }

    private QoS(String str, int i, int i2) {
        this.value = i2;
    }

    public final int getValue() {
        return this.value;
    }

    static {
        QoS[] qoSArr$values = $values();
        $VALUES = qoSArr$values;
        $ENTRIES = EnumEntriesKt.enumEntries(qoSArr$values);
        INSTANCE = new Companion(null);
    }

    /* JADX INFO: compiled from: QoS.kt */
    @Metadata(d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\u0010\u0010\u0004\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u0007H\u0007¨\u0006\b"}, d2 = {"Linfo/mqtt/android/service/QoS$Companion;", "", "<init>", "()V", "valueOf", "Linfo/mqtt/android/service/QoS;", "qos", "", "serviceLibrary_release"}, k = 1, mv = {2, 1, 0}, xi = 48)
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        private Companion() {
        }

        @JvmStatic
        public final QoS valueOf(int qos) {
            return QoS.getEntries().get(qos);
        }
    }

    public static QoS valueOf(String str) {
        return (QoS) Enum.valueOf(QoS.class, str);
    }

    public static QoS[] values() {
        return (QoS[]) $VALUES.clone();
    }
}
