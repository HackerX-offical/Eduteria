package androidx.compose.material3;

import kotlin.Metadata;
import kotlin.enums.EnumEntries;
import kotlin.enums.EnumEntriesKt;

/* JADX WARN: Failed to restore enum class, 'enum' modifier and super class removed */
/* JADX WARN: Unknown enum class pattern. Please report as an issue! */
/* JADX INFO: compiled from: WideNavigationRailState.kt */
/* JADX INFO: loaded from: classes.dex */
@Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\b\u0005\b\u0086\u0081\u0002\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003j\u0002\b\u0004j\u0002\b\u0005¨\u0006\u0006"}, d2 = {"Landroidx/compose/material3/WideNavigationRailValue;", "", "<init>", "(Ljava/lang/String;I)V", "Collapsed", "Expanded", "material3"}, k = 1, mv = {2, 0, 0}, xi = 48)
public final class WideNavigationRailValue {
    private static final /* synthetic */ EnumEntries $ENTRIES;
    private static final /* synthetic */ WideNavigationRailValue[] $VALUES;
    public static final WideNavigationRailValue Collapsed = new WideNavigationRailValue("Collapsed", 0);
    public static final WideNavigationRailValue Expanded = new WideNavigationRailValue("Expanded", 1);

    private static final /* synthetic */ WideNavigationRailValue[] $values() {
        return new WideNavigationRailValue[]{Collapsed, Expanded};
    }

    public static EnumEntries<WideNavigationRailValue> getEntries() {
        return $ENTRIES;
    }

    private WideNavigationRailValue(String str, int i) {
    }

    static {
        WideNavigationRailValue[] wideNavigationRailValueArr$values = $values();
        $VALUES = wideNavigationRailValueArr$values;
        $ENTRIES = EnumEntriesKt.enumEntries(wideNavigationRailValueArr$values);
    }

    public static WideNavigationRailValue valueOf(String str) {
        return (WideNavigationRailValue) Enum.valueOf(WideNavigationRailValue.class, str);
    }

    public static WideNavigationRailValue[] values() {
        return (WideNavigationRailValue[]) $VALUES.clone();
    }
}
