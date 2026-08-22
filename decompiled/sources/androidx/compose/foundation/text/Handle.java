package androidx.compose.foundation.text;

import kotlin.Metadata;
import kotlin.enums.EnumEntries;
import kotlin.enums.EnumEntriesKt;

/* JADX WARN: Failed to restore enum class, 'enum' modifier and super class removed */
/* JADX WARN: Unknown enum class pattern. Please report as an issue! */
/* JADX INFO: compiled from: CoreTextField.kt */
/* JADX INFO: loaded from: classes.dex */
@Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\b\u0006\b\u0080\u0081\u0002\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003j\u0002\b\u0004j\u0002\b\u0005j\u0002\b\u0006¨\u0006\u0007"}, d2 = {"Landroidx/compose/foundation/text/Handle;", "", "<init>", "(Ljava/lang/String;I)V", "Cursor", "SelectionStart", "SelectionEnd", "foundation"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final class Handle {
    private static final /* synthetic */ EnumEntries $ENTRIES;
    private static final /* synthetic */ Handle[] $VALUES;
    public static final Handle Cursor = new Handle("Cursor", 0);
    public static final Handle SelectionStart = new Handle("SelectionStart", 1);
    public static final Handle SelectionEnd = new Handle("SelectionEnd", 2);

    private static final /* synthetic */ Handle[] $values() {
        return new Handle[]{Cursor, SelectionStart, SelectionEnd};
    }

    public static EnumEntries<Handle> getEntries() {
        return $ENTRIES;
    }

    public static Handle valueOf(String str) {
        return (Handle) Enum.valueOf(Handle.class, str);
    }

    public static Handle[] values() {
        return (Handle[]) $VALUES.clone();
    }

    private Handle(String str, int i) {
    }

    static {
        Handle[] handleArr$values = $values();
        $VALUES = handleArr$values;
        $ENTRIES = EnumEntriesKt.enumEntries(handleArr$values);
    }
}
