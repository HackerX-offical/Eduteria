package androidx.compose.ui.node;

import kotlin.Metadata;
import kotlin.enums.EnumEntries;
import kotlin.enums.EnumEntriesKt;

/* JADX WARN: Failed to restore enum class, 'enum' modifier and super class removed */
/* JADX WARN: Unknown enum class pattern. Please report as an issue! */
/* JADX INFO: compiled from: MeasureAndLayoutDelegate.kt */
/* JADX INFO: loaded from: classes3.dex */
@Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\b\u0007\b\u0080\u0081\u0002\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003j\u0002\b\u0004j\u0002\b\u0005j\u0002\b\u0006j\u0002\b\u0007¨\u0006\b"}, d2 = {"Landroidx/compose/ui/node/Invalidation;", "", "<init>", "(Ljava/lang/String;I)V", "LookaheadMeasurement", "LookaheadPlacement", "Measurement", "Placement", "ui"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final class Invalidation {
    private static final /* synthetic */ EnumEntries $ENTRIES;
    private static final /* synthetic */ Invalidation[] $VALUES;
    public static final Invalidation LookaheadMeasurement = new Invalidation("LookaheadMeasurement", 0);
    public static final Invalidation LookaheadPlacement = new Invalidation("LookaheadPlacement", 1);
    public static final Invalidation Measurement = new Invalidation("Measurement", 2);
    public static final Invalidation Placement = new Invalidation("Placement", 3);

    private static final /* synthetic */ Invalidation[] $values() {
        return new Invalidation[]{LookaheadMeasurement, LookaheadPlacement, Measurement, Placement};
    }

    public static EnumEntries<Invalidation> getEntries() {
        return $ENTRIES;
    }

    public static Invalidation valueOf(String str) {
        return (Invalidation) Enum.valueOf(Invalidation.class, str);
    }

    public static Invalidation[] values() {
        return (Invalidation[]) $VALUES.clone();
    }

    private Invalidation(String str, int i) {
    }

    static {
        Invalidation[] invalidationArr$values = $values();
        $VALUES = invalidationArr$values;
        $ENTRIES = EnumEntriesKt.enumEntries(invalidationArr$values);
    }
}
