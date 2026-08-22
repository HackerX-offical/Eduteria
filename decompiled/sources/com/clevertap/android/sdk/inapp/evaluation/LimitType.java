package com.clevertap.android.sdk.inapp.evaluation;

import kotlin.Metadata;
import kotlin.enums.EnumEntries;
import kotlin.enums.EnumEntriesKt;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import org.jivesoftware.smack.packet.Session;

/* JADX WARN: Failed to restore enum class, 'enum' modifier and super class removed */
/* JADX WARN: Unknown enum class pattern. Please report as an issue! */
/* JADX INFO: compiled from: LimitAdapter.kt */
/* JADX INFO: loaded from: classes7.dex */
@Metadata(d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u000f\b\u0086\u0081\u0002\u0018\u0000 \u00112\b\u0012\u0004\u0012\u00020\u00000\u0001:\u0001\u0011B\u0011\b\u0002\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0004\b\u0004\u0010\u0005R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0006\u0010\u0007j\u0002\b\bj\u0002\b\tj\u0002\b\nj\u0002\b\u000bj\u0002\b\fj\u0002\b\rj\u0002\b\u000ej\u0002\b\u000fj\u0002\b\u0010¨\u0006\u0012"}, d2 = {"Lcom/clevertap/android/sdk/inapp/evaluation/LimitType;", "", "type", "", "<init>", "(Ljava/lang/String;ILjava/lang/String;)V", "getType", "()Ljava/lang/String;", "Ever", "Session", "Seconds", "Minutes", "Hours", "Days", "Weeks", "OnEvery", "OnExactly", "Companion", "clevertap-core_release"}, k = 1, mv = {2, 0, 0}, xi = 48)
public final class LimitType {
    private static final /* synthetic */ EnumEntries $ENTRIES;
    private static final /* synthetic */ LimitType[] $VALUES;

    /* JADX INFO: renamed from: Companion, reason: from kotlin metadata */
    public static final Companion INSTANCE;
    private final String type;
    public static final LimitType Ever = new LimitType("Ever", 0, "ever");
    public static final LimitType Session = new LimitType("Session", 1, Session.ELEMENT);
    public static final LimitType Seconds = new LimitType("Seconds", 2, "seconds");
    public static final LimitType Minutes = new LimitType("Minutes", 3, "minutes");
    public static final LimitType Hours = new LimitType("Hours", 4, "hours");
    public static final LimitType Days = new LimitType("Days", 5, "days");
    public static final LimitType Weeks = new LimitType("Weeks", 6, "weeks");
    public static final LimitType OnEvery = new LimitType("OnEvery", 7, "onEvery");
    public static final LimitType OnExactly = new LimitType("OnExactly", 8, "onExactly");

    private static final /* synthetic */ LimitType[] $values() {
        return new LimitType[]{Ever, Session, Seconds, Minutes, Hours, Days, Weeks, OnEvery, OnExactly};
    }

    public static EnumEntries<LimitType> getEntries() {
        return $ENTRIES;
    }

    private LimitType(String str, int i, String str2) {
        this.type = str2;
    }

    public final String getType() {
        return this.type;
    }

    static {
        LimitType[] limitTypeArr$values = $values();
        $VALUES = limitTypeArr$values;
        $ENTRIES = EnumEntriesKt.enumEntries(limitTypeArr$values);
        INSTANCE = new Companion(null);
    }

    /* JADX INFO: compiled from: LimitAdapter.kt */
    @Metadata(d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\u000e\u0010\u0004\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u0007¨\u0006\b"}, d2 = {"Lcom/clevertap/android/sdk/inapp/evaluation/LimitType$Companion;", "", "<init>", "()V", "fromString", "Lcom/clevertap/android/sdk/inapp/evaluation/LimitType;", "type", "", "clevertap-core_release"}, k = 1, mv = {2, 0, 0}, xi = 48)
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        private Companion() {
        }

        public final LimitType fromString(String type) {
            LimitType limitType;
            Intrinsics.checkNotNullParameter(type, "type");
            LimitType[] limitTypeArrValues = LimitType.values();
            int length = limitTypeArrValues.length;
            int i = 0;
            while (true) {
                if (i >= length) {
                    limitType = null;
                    break;
                }
                limitType = limitTypeArrValues[i];
                if (Intrinsics.areEqual(limitType.getType(), type)) {
                    break;
                }
                i++;
            }
            return limitType == null ? LimitType.Ever : limitType;
        }
    }

    public static LimitType valueOf(String str) {
        return (LimitType) Enum.valueOf(LimitType.class, str);
    }

    public static LimitType[] values() {
        return (LimitType[]) $VALUES.clone();
    }
}
