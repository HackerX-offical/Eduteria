package androidx.compose.foundation.text.input.internal.undo;

import kotlin.Metadata;
import kotlin.enums.EnumEntries;
import kotlin.enums.EnumEntriesKt;

/* JADX WARN: Failed to restore enum class, 'enum' modifier and super class removed */
/* JADX WARN: Unknown enum class pattern. Please report as an issue! */
/* JADX INFO: compiled from: TextUndoOperation.kt */
/* JADX INFO: loaded from: classes.dex */
@Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\b\u0006\b\u0080\u0081\u0002\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003j\u0002\b\u0004j\u0002\b\u0005j\u0002\b\u0006¨\u0006\u0007"}, d2 = {"Landroidx/compose/foundation/text/input/internal/undo/TextEditType;", "", "<init>", "(Ljava/lang/String;I)V", "Insert", "Delete", "Replace", "foundation"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final class TextEditType {
    private static final /* synthetic */ EnumEntries $ENTRIES;
    private static final /* synthetic */ TextEditType[] $VALUES;
    public static final TextEditType Insert = new TextEditType("Insert", 0);
    public static final TextEditType Delete = new TextEditType("Delete", 1);
    public static final TextEditType Replace = new TextEditType("Replace", 2);

    private static final /* synthetic */ TextEditType[] $values() {
        return new TextEditType[]{Insert, Delete, Replace};
    }

    public static EnumEntries<TextEditType> getEntries() {
        return $ENTRIES;
    }

    public static TextEditType valueOf(String str) {
        return (TextEditType) Enum.valueOf(TextEditType.class, str);
    }

    public static TextEditType[] values() {
        return (TextEditType[]) $VALUES.clone();
    }

    private TextEditType(String str, int i) {
    }

    static {
        TextEditType[] textEditTypeArr$values = $values();
        $VALUES = textEditTypeArr$values;
        $ENTRIES = EnumEntriesKt.enumEntries(textEditTypeArr$values);
    }
}
