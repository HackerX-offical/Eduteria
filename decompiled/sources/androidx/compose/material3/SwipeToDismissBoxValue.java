package androidx.compose.material3;

import kotlin.Metadata;
import kotlin.enums.EnumEntries;
import kotlin.enums.EnumEntriesKt;

/* JADX WARN: Failed to restore enum class, 'enum' modifier and super class removed */
/* JADX WARN: Unknown enum class pattern. Please report as an issue! */
/* JADX INFO: compiled from: SwipeToDismissBox.kt */
/* JADX INFO: loaded from: classes.dex */
@Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\b\u0006\b\u0086\u0081\u0002\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003j\u0002\b\u0004j\u0002\b\u0005j\u0002\b\u0006¨\u0006\u0007"}, d2 = {"Landroidx/compose/material3/SwipeToDismissBoxValue;", "", "<init>", "(Ljava/lang/String;I)V", "StartToEnd", "EndToStart", "Settled", "material3"}, k = 1, mv = {2, 0, 0}, xi = 48)
public final class SwipeToDismissBoxValue {
    private static final /* synthetic */ EnumEntries $ENTRIES;
    private static final /* synthetic */ SwipeToDismissBoxValue[] $VALUES;
    public static final SwipeToDismissBoxValue StartToEnd = new SwipeToDismissBoxValue("StartToEnd", 0);
    public static final SwipeToDismissBoxValue EndToStart = new SwipeToDismissBoxValue("EndToStart", 1);
    public static final SwipeToDismissBoxValue Settled = new SwipeToDismissBoxValue("Settled", 2);

    private static final /* synthetic */ SwipeToDismissBoxValue[] $values() {
        return new SwipeToDismissBoxValue[]{StartToEnd, EndToStart, Settled};
    }

    public static EnumEntries<SwipeToDismissBoxValue> getEntries() {
        return $ENTRIES;
    }

    private SwipeToDismissBoxValue(String str, int i) {
    }

    static {
        SwipeToDismissBoxValue[] swipeToDismissBoxValueArr$values = $values();
        $VALUES = swipeToDismissBoxValueArr$values;
        $ENTRIES = EnumEntriesKt.enumEntries(swipeToDismissBoxValueArr$values);
    }

    public static SwipeToDismissBoxValue valueOf(String str) {
        return (SwipeToDismissBoxValue) Enum.valueOf(SwipeToDismissBoxValue.class, str);
    }

    public static SwipeToDismissBoxValue[] values() {
        return (SwipeToDismissBoxValue[]) $VALUES.clone();
    }
}
