package com.clevertap.android.sdk.inapp.customtemplates;

import com.clevertap.android.sdk.variables.CTVariableUtils;
import com.facebook.appevents.iap.InAppPurchaseConstants;
import com.facebook.share.internal.ShareConstants;
import kotlin.Metadata;
import kotlin.enums.EnumEntries;
import kotlin.enums.EnumEntriesKt;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* JADX WARN: Failed to restore enum class, 'enum' modifier and super class removed */
/* JADX WARN: Unknown enum class pattern. Please report as an issue! */
/* JADX INFO: compiled from: TemplateArgument.kt */
/* JADX INFO: loaded from: classes7.dex */
@Metadata(d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0000\n\u0002\u0010\u000e\n\u0002\b\n\b\u0080\u0081\u0002\u0018\u0000 \f2\b\u0012\u0004\u0012\u00020\u00000\u0001:\u0001\fB\u0011\b\u0002\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0004\b\u0004\u0010\u0005J\b\u0010\u000b\u001a\u00020\u0003H\u0016R\u000e\u0010\u0002\u001a\u00020\u0003X\u0082\u0004¢\u0006\u0002\n\u0000j\u0002\b\u0006j\u0002\b\u0007j\u0002\b\bj\u0002\b\tj\u0002\b\n¨\u0006\r"}, d2 = {"Lcom/clevertap/android/sdk/inapp/customtemplates/TemplateArgumentType;", "", "stringName", "", "<init>", "(Ljava/lang/String;ILjava/lang/String;)V", "STRING", "BOOLEAN", "NUMBER", "FILE", ShareConstants.ACTION, InAppPurchaseConstants.METHOD_TO_STRING, "Companion", "clevertap-core_release"}, k = 1, mv = {2, 0, 0}, xi = 48)
public final class TemplateArgumentType {
    private static final /* synthetic */ EnumEntries $ENTRIES;
    private static final /* synthetic */ TemplateArgumentType[] $VALUES;

    /* JADX INFO: renamed from: Companion, reason: from kotlin metadata */
    public static final Companion INSTANCE;
    private final String stringName;
    public static final TemplateArgumentType STRING = new TemplateArgumentType("STRING", 0, "string");
    public static final TemplateArgumentType BOOLEAN = new TemplateArgumentType("BOOLEAN", 1, "boolean");
    public static final TemplateArgumentType NUMBER = new TemplateArgumentType("NUMBER", 2, CTVariableUtils.NUMBER);
    public static final TemplateArgumentType FILE = new TemplateArgumentType("FILE", 3, "file");
    public static final TemplateArgumentType ACTION = new TemplateArgumentType(ShareConstants.ACTION, 4, "action");

    private static final /* synthetic */ TemplateArgumentType[] $values() {
        return new TemplateArgumentType[]{STRING, BOOLEAN, NUMBER, FILE, ACTION};
    }

    public static EnumEntries<TemplateArgumentType> getEntries() {
        return $ENTRIES;
    }

    private TemplateArgumentType(String str, int i, String str2) {
        this.stringName = str2;
    }

    static {
        TemplateArgumentType[] templateArgumentTypeArr$values = $values();
        $VALUES = templateArgumentTypeArr$values;
        $ENTRIES = EnumEntriesKt.enumEntries(templateArgumentTypeArr$values);
        INSTANCE = new Companion(null);
    }

    /* JADX INFO: compiled from: TemplateArgument.kt */
    @Metadata(d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\u0010\u0010\u0004\u001a\u0004\u0018\u00010\u00052\u0006\u0010\u0006\u001a\u00020\u0007¨\u0006\b"}, d2 = {"Lcom/clevertap/android/sdk/inapp/customtemplates/TemplateArgumentType$Companion;", "", "<init>", "()V", "fromString", "Lcom/clevertap/android/sdk/inapp/customtemplates/TemplateArgumentType;", "string", "", "clevertap-core_release"}, k = 1, mv = {2, 0, 0}, xi = 48)
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        private Companion() {
        }

        public final TemplateArgumentType fromString(String string) {
            Intrinsics.checkNotNullParameter(string, "string");
            for (TemplateArgumentType templateArgumentType : TemplateArgumentType.values()) {
                if (Intrinsics.areEqual(templateArgumentType.stringName, string)) {
                    return templateArgumentType;
                }
            }
            return null;
        }
    }

    @Override // java.lang.Enum
    public String toString() {
        return this.stringName;
    }

    public static TemplateArgumentType valueOf(String str) {
        return (TemplateArgumentType) Enum.valueOf(TemplateArgumentType.class, str);
    }

    public static TemplateArgumentType[] values() {
        return (TemplateArgumentType[]) $VALUES.clone();
    }
}
