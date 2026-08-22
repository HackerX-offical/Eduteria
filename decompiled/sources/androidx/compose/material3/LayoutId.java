package androidx.compose.material3;

import kotlin.Metadata;
import kotlin.enums.EnumEntries;
import kotlin.enums.EnumEntriesKt;

/* JADX WARN: Failed to restore enum class, 'enum' modifier and super class removed */
/* JADX WARN: Unknown enum class pattern. Please report as an issue! */
/* JADX INFO: compiled from: TimePicker.kt */
/* JADX INFO: loaded from: classes.dex */
@Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\b\u0005\b\u0082\u0081\u0002\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003j\u0002\b\u0004j\u0002\b\u0005¨\u0006\u0006"}, d2 = {"Landroidx/compose/material3/LayoutId;", "", "<init>", "(Ljava/lang/String;I)V", "Selector", "InnerCircle", "material3"}, k = 1, mv = {2, 0, 0}, xi = 48)
final class LayoutId {
    private static final /* synthetic */ EnumEntries $ENTRIES;
    private static final /* synthetic */ LayoutId[] $VALUES;
    public static final LayoutId Selector = new LayoutId("Selector", 0);
    public static final LayoutId InnerCircle = new LayoutId("InnerCircle", 1);

    private static final /* synthetic */ LayoutId[] $values() {
        return new LayoutId[]{Selector, InnerCircle};
    }

    public static EnumEntries<LayoutId> getEntries() {
        return $ENTRIES;
    }

    private LayoutId(String str, int i) {
    }

    static {
        LayoutId[] layoutIdArr$values = $values();
        $VALUES = layoutIdArr$values;
        $ENTRIES = EnumEntriesKt.enumEntries(layoutIdArr$values);
    }

    public static LayoutId valueOf(String str) {
        return (LayoutId) Enum.valueOf(LayoutId.class, str);
    }

    public static LayoutId[] values() {
        return (LayoutId[]) $VALUES.clone();
    }
}
