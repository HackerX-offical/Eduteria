package androidx.compose.material3;

import kotlin.Metadata;
import kotlin.enums.EnumEntries;
import kotlin.enums.EnumEntriesKt;

/* JADX WARN: Failed to restore enum class, 'enum' modifier and super class removed */
/* JADX WARN: Unknown enum class pattern. Please report as an issue! */
/* JADX INFO: compiled from: SheetDefaults.kt */
/* JADX INFO: loaded from: classes.dex */
@Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\b\u0006\b\u0087\u0081\u0002\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003j\u0002\b\u0004j\u0002\b\u0005j\u0002\b\u0006¨\u0006\u0007"}, d2 = {"Landroidx/compose/material3/SheetValue;", "", "<init>", "(Ljava/lang/String;I)V", "Hidden", "Expanded", "PartiallyExpanded", "material3"}, k = 1, mv = {2, 0, 0}, xi = 48)
public final class SheetValue {
    private static final /* synthetic */ EnumEntries $ENTRIES;
    private static final /* synthetic */ SheetValue[] $VALUES;
    public static final SheetValue Hidden = new SheetValue("Hidden", 0);
    public static final SheetValue Expanded = new SheetValue("Expanded", 1);
    public static final SheetValue PartiallyExpanded = new SheetValue("PartiallyExpanded", 2);

    private static final /* synthetic */ SheetValue[] $values() {
        return new SheetValue[]{Hidden, Expanded, PartiallyExpanded};
    }

    public static EnumEntries<SheetValue> getEntries() {
        return $ENTRIES;
    }

    private SheetValue(String str, int i) {
    }

    static {
        SheetValue[] sheetValueArr$values = $values();
        $VALUES = sheetValueArr$values;
        $ENTRIES = EnumEntriesKt.enumEntries(sheetValueArr$values);
    }

    public static SheetValue valueOf(String str) {
        return (SheetValue) Enum.valueOf(SheetValue.class, str);
    }

    public static SheetValue[] values() {
        return (SheetValue[]) $VALUES.clone();
    }
}
