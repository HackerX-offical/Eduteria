package androidx.compose.material3;

import kotlin.Metadata;
import kotlin.enums.EnumEntries;
import kotlin.enums.EnumEntriesKt;

/* JADX WARN: Failed to restore enum class, 'enum' modifier and super class removed */
/* JADX WARN: Unknown enum class pattern. Please report as an issue! */
/* JADX INFO: compiled from: NavigationDrawer.kt */
/* JADX INFO: loaded from: classes.dex */
@Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\b\u0005\b\u0086\u0081\u0002\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003j\u0002\b\u0004j\u0002\b\u0005¨\u0006\u0006"}, d2 = {"Landroidx/compose/material3/DrawerValue;", "", "<init>", "(Ljava/lang/String;I)V", "Closed", "Open", "material3"}, k = 1, mv = {2, 0, 0}, xi = 48)
public final class DrawerValue {
    private static final /* synthetic */ EnumEntries $ENTRIES;
    private static final /* synthetic */ DrawerValue[] $VALUES;
    public static final DrawerValue Closed = new DrawerValue("Closed", 0);
    public static final DrawerValue Open = new DrawerValue("Open", 1);

    private static final /* synthetic */ DrawerValue[] $values() {
        return new DrawerValue[]{Closed, Open};
    }

    public static EnumEntries<DrawerValue> getEntries() {
        return $ENTRIES;
    }

    private DrawerValue(String str, int i) {
    }

    static {
        DrawerValue[] drawerValueArr$values = $values();
        $VALUES = drawerValueArr$values;
        $ENTRIES = EnumEntriesKt.enumEntries(drawerValueArr$values);
    }

    public static DrawerValue valueOf(String str) {
        return (DrawerValue) Enum.valueOf(DrawerValue.class, str);
    }

    public static DrawerValue[] values() {
        return (DrawerValue[]) $VALUES.clone();
    }
}
