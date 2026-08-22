package androidx.compose.material3;

import kotlin.Metadata;
import kotlin.enums.EnumEntries;
import kotlin.enums.EnumEntriesKt;

/* JADX WARN: Failed to restore enum class, 'enum' modifier and super class removed */
/* JADX WARN: Unknown enum class pattern. Please report as an issue! */
/* JADX INFO: compiled from: TabRow.kt */
/* JADX INFO: loaded from: classes.dex */
@Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\b\u0006\b\u0082\u0081\u0002\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003j\u0002\b\u0004j\u0002\b\u0005j\u0002\b\u0006¨\u0006\u0007"}, d2 = {"Landroidx/compose/material3/TabSlots;", "", "<init>", "(Ljava/lang/String;I)V", "Tabs", "Divider", "Indicator", "material3"}, k = 1, mv = {2, 0, 0}, xi = 48)
final class TabSlots {
    private static final /* synthetic */ EnumEntries $ENTRIES;
    private static final /* synthetic */ TabSlots[] $VALUES;
    public static final TabSlots Tabs = new TabSlots("Tabs", 0);
    public static final TabSlots Divider = new TabSlots("Divider", 1);
    public static final TabSlots Indicator = new TabSlots("Indicator", 2);

    private static final /* synthetic */ TabSlots[] $values() {
        return new TabSlots[]{Tabs, Divider, Indicator};
    }

    public static EnumEntries<TabSlots> getEntries() {
        return $ENTRIES;
    }

    private TabSlots(String str, int i) {
    }

    static {
        TabSlots[] tabSlotsArr$values = $values();
        $VALUES = tabSlotsArr$values;
        $ENTRIES = EnumEntriesKt.enumEntries(tabSlotsArr$values);
    }

    public static TabSlots valueOf(String str) {
        return (TabSlots) Enum.valueOf(TabSlots.class, str);
    }

    public static TabSlots[] values() {
        return (TabSlots[]) $VALUES.clone();
    }
}
