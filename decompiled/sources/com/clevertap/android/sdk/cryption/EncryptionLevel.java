package com.clevertap.android.sdk.cryption;

import kotlin.Metadata;
import kotlin.enums.EnumEntries;
import kotlin.enums.EnumEntriesKt;
import kotlin.jvm.JvmStatic;
import kotlin.jvm.internal.DefaultConstructorMarker;

/* JADX WARN: Failed to restore enum class, 'enum' modifier and super class removed */
/* JADX WARN: Unknown enum class pattern. Please report as an issue! */
/* JADX INFO: compiled from: EncryptionLevel.kt */
/* JADX INFO: loaded from: classes7.dex */
@Metadata(d1 = {"\u0000\u001a\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0000\n\u0002\u0010\b\n\u0002\b\u0007\n\u0002\u0010\u000b\n\u0002\b\u0002\b\u0086\u0081\u0002\u0018\u0000 \f2\b\u0012\u0004\u0012\u00020\u00000\u0001:\u0001\fB\u0011\b\u0002\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0004\b\u0004\u0010\u0005J\u0006\u0010\t\u001a\u00020\u0003J\u0006\u0010\n\u001a\u00020\u000bR\u000e\u0010\u0002\u001a\u00020\u0003X\u0082\u0004¢\u0006\u0002\n\u0000j\u0002\b\u0006j\u0002\b\u0007j\u0002\b\b¨\u0006\r"}, d2 = {"Lcom/clevertap/android/sdk/cryption/EncryptionLevel;", "", "value", "", "<init>", "(Ljava/lang/String;II)V", "NONE", "MEDIUM", "FULL_DATA", "intValue", "shouldEncrypt", "", "Companion", "clevertap-core_release"}, k = 1, mv = {2, 0, 0}, xi = 48)
public final class EncryptionLevel {
    private static final /* synthetic */ EnumEntries $ENTRIES;
    private static final /* synthetic */ EncryptionLevel[] $VALUES;

    /* JADX INFO: renamed from: Companion, reason: from kotlin metadata */
    public static final Companion INSTANCE;
    private final int value;
    public static final EncryptionLevel NONE = new EncryptionLevel("NONE", 0, 0);
    public static final EncryptionLevel MEDIUM = new EncryptionLevel("MEDIUM", 1, 1);
    public static final EncryptionLevel FULL_DATA = new EncryptionLevel("FULL_DATA", 2, 2);

    private static final /* synthetic */ EncryptionLevel[] $values() {
        return new EncryptionLevel[]{NONE, MEDIUM, FULL_DATA};
    }

    @JvmStatic
    public static final EncryptionLevel fromInt(int i) {
        return INSTANCE.fromInt(i);
    }

    public static EnumEntries<EncryptionLevel> getEntries() {
        return $ENTRIES;
    }

    private EncryptionLevel(String str, int i, int i2) {
        this.value = i2;
    }

    static {
        EncryptionLevel[] encryptionLevelArr$values = $values();
        $VALUES = encryptionLevelArr$values;
        $ENTRIES = EnumEntriesKt.enumEntries(encryptionLevelArr$values);
        INSTANCE = new Companion(null);
    }

    /* JADX INFO: renamed from: intValue, reason: from getter */
    public final int getValue() {
        return this.value;
    }

    public final boolean shouldEncrypt() {
        return this.value > 0;
    }

    /* JADX INFO: compiled from: EncryptionLevel.kt */
    @Metadata(d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\u0010\u0010\u0004\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u0007H\u0007¨\u0006\b"}, d2 = {"Lcom/clevertap/android/sdk/cryption/EncryptionLevel$Companion;", "", "<init>", "()V", "fromInt", "Lcom/clevertap/android/sdk/cryption/EncryptionLevel;", "value", "", "clevertap-core_release"}, k = 1, mv = {2, 0, 0}, xi = 48)
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        private Companion() {
        }

        @JvmStatic
        public final EncryptionLevel fromInt(int value) {
            EncryptionLevel encryptionLevel;
            EncryptionLevel[] encryptionLevelArrValues = EncryptionLevel.values();
            int length = encryptionLevelArrValues.length;
            int i = 0;
            while (true) {
                if (i >= length) {
                    encryptionLevel = null;
                    break;
                }
                encryptionLevel = encryptionLevelArrValues[i];
                if (encryptionLevel.value == value) {
                    break;
                }
                i++;
            }
            return encryptionLevel == null ? EncryptionLevel.NONE : encryptionLevel;
        }
    }

    public static EncryptionLevel valueOf(String str) {
        return (EncryptionLevel) Enum.valueOf(EncryptionLevel.class, str);
    }

    public static EncryptionLevel[] values() {
        return (EncryptionLevel[]) $VALUES.clone();
    }
}
