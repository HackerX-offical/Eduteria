package com.clevertap.android.sdk.inapp.customtemplates;

import com.facebook.appevents.iap.InAppPurchaseConstants;
import com.facebook.gamingservices.cloudgaming.internal.SDKConstants;
import kotlin.Metadata;
import kotlin.enums.EnumEntries;
import kotlin.enums.EnumEntriesKt;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* JADX WARN: Failed to restore enum class, 'enum' modifier and super class removed */
/* JADX WARN: Unknown enum class pattern. Please report as an issue! */
/* JADX INFO: compiled from: CustomTemplate.kt */
/* JADX INFO: loaded from: classes7.dex */
@Metadata(d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0007\b\u0080\u0081\u0002\u0018\u0000 \t2\b\u0012\u0004\u0012\u00020\u00000\u0001:\u0001\tB\u0011\b\u0002\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0004\b\u0004\u0010\u0005J\b\u0010\b\u001a\u00020\u0003H\u0016R\u000e\u0010\u0002\u001a\u00020\u0003X\u0082\u0004¢\u0006\u0002\n\u0000j\u0002\b\u0006j\u0002\b\u0007¨\u0006\n"}, d2 = {"Lcom/clevertap/android/sdk/inapp/customtemplates/CustomTemplateType;", "", "stringName", "", "<init>", "(Ljava/lang/String;ILjava/lang/String;)V", "TEMPLATE", "FUNCTION", InAppPurchaseConstants.METHOD_TO_STRING, "Companion", "clevertap-core_release"}, k = 1, mv = {2, 0, 0}, xi = 48)
public final class CustomTemplateType {
    private static final /* synthetic */ EnumEntries $ENTRIES;
    private static final /* synthetic */ CustomTemplateType[] $VALUES;

    /* JADX INFO: renamed from: Companion, reason: from kotlin metadata */
    public static final Companion INSTANCE;
    private final String stringName;
    public static final CustomTemplateType TEMPLATE = new CustomTemplateType("TEMPLATE", 0, SDKConstants.PARAM_UPDATE_TEMPLATE);
    public static final CustomTemplateType FUNCTION = new CustomTemplateType("FUNCTION", 1, "function");

    private static final /* synthetic */ CustomTemplateType[] $values() {
        return new CustomTemplateType[]{TEMPLATE, FUNCTION};
    }

    public static EnumEntries<CustomTemplateType> getEntries() {
        return $ENTRIES;
    }

    private CustomTemplateType(String str, int i, String str2) {
        this.stringName = str2;
    }

    static {
        CustomTemplateType[] customTemplateTypeArr$values = $values();
        $VALUES = customTemplateTypeArr$values;
        $ENTRIES = EnumEntriesKt.enumEntries(customTemplateTypeArr$values);
        INSTANCE = new Companion(null);
    }

    /* JADX INFO: compiled from: CustomTemplate.kt */
    @Metadata(d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\u0010\u0010\u0004\u001a\u0004\u0018\u00010\u00052\u0006\u0010\u0006\u001a\u00020\u0007¨\u0006\b"}, d2 = {"Lcom/clevertap/android/sdk/inapp/customtemplates/CustomTemplateType$Companion;", "", "<init>", "()V", "fromString", "Lcom/clevertap/android/sdk/inapp/customtemplates/CustomTemplateType;", "string", "", "clevertap-core_release"}, k = 1, mv = {2, 0, 0}, xi = 48)
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        private Companion() {
        }

        public final CustomTemplateType fromString(String string) {
            Intrinsics.checkNotNullParameter(string, "string");
            for (CustomTemplateType customTemplateType : CustomTemplateType.values()) {
                if (Intrinsics.areEqual(customTemplateType.stringName, string)) {
                    return customTemplateType;
                }
            }
            return null;
        }
    }

    @Override // java.lang.Enum
    public String toString() {
        return this.stringName;
    }

    public static CustomTemplateType valueOf(String str) {
        return (CustomTemplateType) Enum.valueOf(CustomTemplateType.class, str);
    }

    public static CustomTemplateType[] values() {
        return (CustomTemplateType[]) $VALUES.clone();
    }
}
