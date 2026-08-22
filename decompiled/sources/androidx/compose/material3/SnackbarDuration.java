package androidx.compose.material3;

import kotlin.Metadata;
import kotlin.enums.EnumEntries;
import kotlin.enums.EnumEntriesKt;

/* JADX WARN: Failed to restore enum class, 'enum' modifier and super class removed */
/* JADX WARN: Unknown enum class pattern. Please report as an issue! */
/* JADX INFO: compiled from: SnackbarHost.kt */
/* JADX INFO: loaded from: classes.dex */
@Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\b\u0006\b\u0086\u0081\u0002\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003j\u0002\b\u0004j\u0002\b\u0005j\u0002\b\u0006¨\u0006\u0007"}, d2 = {"Landroidx/compose/material3/SnackbarDuration;", "", "<init>", "(Ljava/lang/String;I)V", "Short", "Long", "Indefinite", "material3"}, k = 1, mv = {2, 0, 0}, xi = 48)
public final class SnackbarDuration {
    private static final /* synthetic */ EnumEntries $ENTRIES;
    private static final /* synthetic */ SnackbarDuration[] $VALUES;
    public static final SnackbarDuration Short = new SnackbarDuration("Short", 0);
    public static final SnackbarDuration Long = new SnackbarDuration("Long", 1);
    public static final SnackbarDuration Indefinite = new SnackbarDuration("Indefinite", 2);

    private static final /* synthetic */ SnackbarDuration[] $values() {
        return new SnackbarDuration[]{Short, Long, Indefinite};
    }

    public static EnumEntries<SnackbarDuration> getEntries() {
        return $ENTRIES;
    }

    private SnackbarDuration(String str, int i) {
    }

    static {
        SnackbarDuration[] snackbarDurationArr$values = $values();
        $VALUES = snackbarDurationArr$values;
        $ENTRIES = EnumEntriesKt.enumEntries(snackbarDurationArr$values);
    }

    public static SnackbarDuration valueOf(String str) {
        return (SnackbarDuration) Enum.valueOf(SnackbarDuration.class, str);
    }

    public static SnackbarDuration[] values() {
        return (SnackbarDuration[]) $VALUES.clone();
    }
}
