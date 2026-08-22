package androidx.compose.foundation.text.selection;

import kotlin.Metadata;
import kotlin.enums.EnumEntries;
import kotlin.enums.EnumEntriesKt;

/* JADX WARN: Failed to restore enum class, 'enum' modifier and super class removed */
/* JADX WARN: Unknown enum class pattern. Please report as an issue! */
/* JADX INFO: compiled from: SelectionHandles.kt */
/* JADX INFO: loaded from: classes.dex */
@Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\b\u0006\b\u0080\u0081\u0002\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003j\u0002\b\u0004j\u0002\b\u0005j\u0002\b\u0006¨\u0006\u0007"}, d2 = {"Landroidx/compose/foundation/text/selection/SelectionHandleAnchor;", "", "<init>", "(Ljava/lang/String;I)V", "Left", "Middle", "Right", "foundation"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final class SelectionHandleAnchor {
    private static final /* synthetic */ EnumEntries $ENTRIES;
    private static final /* synthetic */ SelectionHandleAnchor[] $VALUES;
    public static final SelectionHandleAnchor Left = new SelectionHandleAnchor("Left", 0);
    public static final SelectionHandleAnchor Middle = new SelectionHandleAnchor("Middle", 1);
    public static final SelectionHandleAnchor Right = new SelectionHandleAnchor("Right", 2);

    private static final /* synthetic */ SelectionHandleAnchor[] $values() {
        return new SelectionHandleAnchor[]{Left, Middle, Right};
    }

    public static EnumEntries<SelectionHandleAnchor> getEntries() {
        return $ENTRIES;
    }

    public static SelectionHandleAnchor valueOf(String str) {
        return (SelectionHandleAnchor) Enum.valueOf(SelectionHandleAnchor.class, str);
    }

    public static SelectionHandleAnchor[] values() {
        return (SelectionHandleAnchor[]) $VALUES.clone();
    }

    private SelectionHandleAnchor(String str, int i) {
    }

    static {
        SelectionHandleAnchor[] selectionHandleAnchorArr$values = $values();
        $VALUES = selectionHandleAnchorArr$values;
        $ENTRIES = EnumEntriesKt.enumEntries(selectionHandleAnchorArr$values);
    }
}
