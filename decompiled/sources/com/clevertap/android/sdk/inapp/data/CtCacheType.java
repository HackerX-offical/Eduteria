package com.clevertap.android.sdk.inapp.data;

import kotlin.Metadata;
import kotlin.enums.EnumEntries;
import kotlin.enums.EnumEntriesKt;

/* JADX WARN: Failed to restore enum class, 'enum' modifier and super class removed */
/* JADX WARN: Unknown enum class pattern. Please report as an issue! */
/* JADX INFO: compiled from: InAppResponseAdapter.kt */
/* JADX INFO: loaded from: classes7.dex */
@Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\b\u0006\b\u0086\u0081\u0002\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003j\u0002\b\u0004j\u0002\b\u0005j\u0002\b\u0006¨\u0006\u0007"}, d2 = {"Lcom/clevertap/android/sdk/inapp/data/CtCacheType;", "", "<init>", "(Ljava/lang/String;I)V", "IMAGE", "GIF", "FILES", "clevertap-core_release"}, k = 1, mv = {2, 0, 0}, xi = 48)
public final class CtCacheType {
    private static final /* synthetic */ EnumEntries $ENTRIES;
    private static final /* synthetic */ CtCacheType[] $VALUES;
    public static final CtCacheType IMAGE = new CtCacheType("IMAGE", 0);
    public static final CtCacheType GIF = new CtCacheType("GIF", 1);
    public static final CtCacheType FILES = new CtCacheType("FILES", 2);

    private static final /* synthetic */ CtCacheType[] $values() {
        return new CtCacheType[]{IMAGE, GIF, FILES};
    }

    public static EnumEntries<CtCacheType> getEntries() {
        return $ENTRIES;
    }

    private CtCacheType(String str, int i) {
    }

    static {
        CtCacheType[] ctCacheTypeArr$values = $values();
        $VALUES = ctCacheTypeArr$values;
        $ENTRIES = EnumEntriesKt.enumEntries(ctCacheTypeArr$values);
    }

    public static CtCacheType valueOf(String str) {
        return (CtCacheType) Enum.valueOf(CtCacheType.class, str);
    }

    public static CtCacheType[] values() {
        return (CtCacheType[]) $VALUES.clone();
    }
}
