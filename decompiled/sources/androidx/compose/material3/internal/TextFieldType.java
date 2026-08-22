package androidx.compose.material3.internal;

import kotlin.Metadata;
import kotlin.enums.EnumEntries;
import kotlin.enums.EnumEntriesKt;

/* JADX WARN: Failed to restore enum class, 'enum' modifier and super class removed */
/* JADX WARN: Unknown enum class pattern. Please report as an issue! */
/* JADX INFO: compiled from: TextFieldImpl.kt */
/* JADX INFO: loaded from: classes.dex */
@Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\b\u0005\b\u0080\u0081\u0002\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003j\u0002\b\u0004j\u0002\b\u0005¨\u0006\u0006"}, d2 = {"Landroidx/compose/material3/internal/TextFieldType;", "", "<init>", "(Ljava/lang/String;I)V", "Filled", "Outlined", "material3"}, k = 1, mv = {2, 0, 0}, xi = 48)
public final class TextFieldType {
    private static final /* synthetic */ EnumEntries $ENTRIES;
    private static final /* synthetic */ TextFieldType[] $VALUES;
    public static final TextFieldType Filled = new TextFieldType("Filled", 0);
    public static final TextFieldType Outlined = new TextFieldType("Outlined", 1);

    private static final /* synthetic */ TextFieldType[] $values() {
        return new TextFieldType[]{Filled, Outlined};
    }

    public static EnumEntries<TextFieldType> getEntries() {
        return $ENTRIES;
    }

    private TextFieldType(String str, int i) {
    }

    static {
        TextFieldType[] textFieldTypeArr$values = $values();
        $VALUES = textFieldTypeArr$values;
        $ENTRIES = EnumEntriesKt.enumEntries(textFieldTypeArr$values);
    }

    public static TextFieldType valueOf(String str) {
        return (TextFieldType) Enum.valueOf(TextFieldType.class, str);
    }

    public static TextFieldType[] values() {
        return (TextFieldType[]) $VALUES.clone();
    }
}
