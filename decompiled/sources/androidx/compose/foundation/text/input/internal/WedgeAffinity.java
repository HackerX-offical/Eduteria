package androidx.compose.foundation.text.input.internal;

import kotlin.Metadata;
import kotlin.enums.EnumEntries;
import kotlin.enums.EnumEntriesKt;

/* JADX WARN: Failed to restore enum class, 'enum' modifier and super class removed */
/* JADX WARN: Unknown enum class pattern. Please report as an issue! */
/* JADX INFO: compiled from: TransformedTextFieldState.kt */
/* JADX INFO: loaded from: classes.dex */
@Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\b\u0005\b\u0080\u0081\u0002\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003j\u0002\b\u0004j\u0002\b\u0005¨\u0006\u0006"}, d2 = {"Landroidx/compose/foundation/text/input/internal/WedgeAffinity;", "", "<init>", "(Ljava/lang/String;I)V", "Start", "End", "foundation"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final class WedgeAffinity {
    private static final /* synthetic */ EnumEntries $ENTRIES;
    private static final /* synthetic */ WedgeAffinity[] $VALUES;
    public static final WedgeAffinity Start = new WedgeAffinity("Start", 0);
    public static final WedgeAffinity End = new WedgeAffinity("End", 1);

    private static final /* synthetic */ WedgeAffinity[] $values() {
        return new WedgeAffinity[]{Start, End};
    }

    public static EnumEntries<WedgeAffinity> getEntries() {
        return $ENTRIES;
    }

    public static WedgeAffinity valueOf(String str) {
        return (WedgeAffinity) Enum.valueOf(WedgeAffinity.class, str);
    }

    public static WedgeAffinity[] values() {
        return (WedgeAffinity[]) $VALUES.clone();
    }

    private WedgeAffinity(String str, int i) {
    }

    static {
        WedgeAffinity[] wedgeAffinityArr$values = $values();
        $VALUES = wedgeAffinityArr$values;
        $ENTRIES = EnumEntriesKt.enumEntries(wedgeAffinityArr$values);
    }
}
