package androidx.compose.foundation.text.input.internal;

import kotlin.Metadata;
import kotlin.enums.EnumEntries;
import kotlin.enums.EnumEntriesKt;

/* JADX WARN: Failed to restore enum class, 'enum' modifier and super class removed */
/* JADX WARN: Unknown enum class pattern. Please report as an issue! */
/* JADX INFO: compiled from: TransformedTextFieldState.kt */
/* JADX INFO: loaded from: classes.dex */
@Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\b\u0007\b\u0080\u0081\u0002\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003j\u0002\b\u0004j\u0002\b\u0005j\u0002\b\u0006j\u0002\b\u0007¨\u0006\b"}, d2 = {"Landroidx/compose/foundation/text/input/internal/IndexTransformationType;", "", "<init>", "(Ljava/lang/String;I)V", "Untransformed", "Insertion", "Replacement", "Deletion", "foundation"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final class IndexTransformationType {
    private static final /* synthetic */ EnumEntries $ENTRIES;
    private static final /* synthetic */ IndexTransformationType[] $VALUES;
    public static final IndexTransformationType Untransformed = new IndexTransformationType("Untransformed", 0);
    public static final IndexTransformationType Insertion = new IndexTransformationType("Insertion", 1);
    public static final IndexTransformationType Replacement = new IndexTransformationType("Replacement", 2);
    public static final IndexTransformationType Deletion = new IndexTransformationType("Deletion", 3);

    private static final /* synthetic */ IndexTransformationType[] $values() {
        return new IndexTransformationType[]{Untransformed, Insertion, Replacement, Deletion};
    }

    public static EnumEntries<IndexTransformationType> getEntries() {
        return $ENTRIES;
    }

    public static IndexTransformationType valueOf(String str) {
        return (IndexTransformationType) Enum.valueOf(IndexTransformationType.class, str);
    }

    public static IndexTransformationType[] values() {
        return (IndexTransformationType[]) $VALUES.clone();
    }

    private IndexTransformationType(String str, int i) {
    }

    static {
        IndexTransformationType[] indexTransformationTypeArr$values = $values();
        $VALUES = indexTransformationTypeArr$values;
        $ENTRIES = EnumEntriesKt.enumEntries(indexTransformationTypeArr$values);
    }
}
