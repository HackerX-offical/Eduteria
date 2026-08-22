package com.clevertap.android.sdk.inapp;

import com.clevertap.android.sdk.Constants;
import com.facebook.appevents.iap.InAppPurchaseConstants;
import kotlin.Metadata;
import kotlin.enums.EnumEntries;
import kotlin.enums.EnumEntriesKt;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* JADX WARN: Failed to restore enum class, 'enum' modifier and super class removed */
/* JADX WARN: Unknown enum class pattern. Please report as an issue! */
/* JADX INFO: compiled from: CTInAppAction.kt */
/* JADX INFO: loaded from: classes7.dex */
@Metadata(d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0000\n\u0002\u0010\u000e\n\u0002\b\n\b\u0086\u0081\u0002\u0018\u0000 \f2\b\u0012\u0004\u0012\u00020\u00000\u0001:\u0001\fB\u0011\b\u0002\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0004\b\u0004\u0010\u0005J\b\u0010\u000b\u001a\u00020\u0003H\u0016R\u000e\u0010\u0002\u001a\u00020\u0003X\u0082\u0004¢\u0006\u0002\n\u0000j\u0002\b\u0006j\u0002\b\u0007j\u0002\b\bj\u0002\b\tj\u0002\b\n¨\u0006\r"}, d2 = {"Lcom/clevertap/android/sdk/inapp/InAppActionType;", "", "stringValue", "", "<init>", "(Ljava/lang/String;ILjava/lang/String;)V", "CLOSE", "OPEN_URL", "KEY_VALUES", "CUSTOM_CODE", "REQUEST_FOR_PERMISSIONS", InAppPurchaseConstants.METHOD_TO_STRING, "Companion", "clevertap-core_release"}, k = 1, mv = {2, 0, 0}, xi = 48)
public final class InAppActionType {
    private static final /* synthetic */ EnumEntries $ENTRIES;
    private static final /* synthetic */ InAppActionType[] $VALUES;

    /* JADX INFO: renamed from: Companion, reason: from kotlin metadata */
    public static final Companion INSTANCE;
    private final String stringValue;
    public static final InAppActionType CLOSE = new InAppActionType("CLOSE", 0, "close");
    public static final InAppActionType OPEN_URL = new InAppActionType("OPEN_URL", 1, "url");
    public static final InAppActionType KEY_VALUES = new InAppActionType("KEY_VALUES", 2, Constants.KEY_KV);
    public static final InAppActionType CUSTOM_CODE = new InAppActionType("CUSTOM_CODE", 3, "custom-code");
    public static final InAppActionType REQUEST_FOR_PERMISSIONS = new InAppActionType("REQUEST_FOR_PERMISSIONS", 4, Constants.KEY_REQUEST_FOR_NOTIFICATION_PERMISSION);

    private static final /* synthetic */ InAppActionType[] $values() {
        return new InAppActionType[]{CLOSE, OPEN_URL, KEY_VALUES, CUSTOM_CODE, REQUEST_FOR_PERMISSIONS};
    }

    public static EnumEntries<InAppActionType> getEntries() {
        return $ENTRIES;
    }

    private InAppActionType(String str, int i, String str2) {
        this.stringValue = str2;
    }

    static {
        InAppActionType[] inAppActionTypeArr$values = $values();
        $VALUES = inAppActionTypeArr$values;
        $ENTRIES = EnumEntriesKt.enumEntries(inAppActionTypeArr$values);
        INSTANCE = new Companion(null);
    }

    @Override // java.lang.Enum
    public String toString() {
        return this.stringValue;
    }

    /* JADX INFO: compiled from: CTInAppAction.kt */
    @Metadata(d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\u0010\u0010\u0004\u001a\u0004\u0018\u00010\u00052\u0006\u0010\u0006\u001a\u00020\u0007¨\u0006\b"}, d2 = {"Lcom/clevertap/android/sdk/inapp/InAppActionType$Companion;", "", "<init>", "()V", "fromString", "Lcom/clevertap/android/sdk/inapp/InAppActionType;", "string", "", "clevertap-core_release"}, k = 1, mv = {2, 0, 0}, xi = 48)
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        private Companion() {
        }

        public final InAppActionType fromString(String string) {
            Intrinsics.checkNotNullParameter(string, "string");
            for (InAppActionType inAppActionType : InAppActionType.values()) {
                if (Intrinsics.areEqual(inAppActionType.stringValue, string)) {
                    return inAppActionType;
                }
            }
            return null;
        }
    }

    public static InAppActionType valueOf(String str) {
        return (InAppActionType) Enum.valueOf(InAppActionType.class, str);
    }

    public static InAppActionType[] values() {
        return (InAppActionType[]) $VALUES.clone();
    }
}
