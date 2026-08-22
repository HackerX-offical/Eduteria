package androidx.compose.material3.tokens;

import kotlin.Metadata;
import kotlin.enums.EnumEntries;
import kotlin.enums.EnumEntriesKt;

/* JADX WARN: Failed to restore enum class, 'enum' modifier and super class removed */
/* JADX WARN: Unknown enum class pattern. Please report as an issue! */
/* JADX INFO: compiled from: MotionSchemeKeyTokens.kt */
/* JADX INFO: loaded from: classes.dex */
@Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\b\t\b\u0080\u0081\u0002\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003j\u0002\b\u0004j\u0002\b\u0005j\u0002\b\u0006j\u0002\b\u0007j\u0002\b\bj\u0002\b\t¨\u0006\n"}, d2 = {"Landroidx/compose/material3/tokens/MotionSchemeKeyTokens;", "", "<init>", "(Ljava/lang/String;I)V", "DefaultSpatial", "FastSpatial", "SlowSpatial", "DefaultEffects", "FastEffects", "SlowEffects", "material3"}, k = 1, mv = {2, 0, 0}, xi = 48)
public final class MotionSchemeKeyTokens {
    private static final /* synthetic */ EnumEntries $ENTRIES;
    private static final /* synthetic */ MotionSchemeKeyTokens[] $VALUES;
    public static final MotionSchemeKeyTokens DefaultSpatial = new MotionSchemeKeyTokens("DefaultSpatial", 0);
    public static final MotionSchemeKeyTokens FastSpatial = new MotionSchemeKeyTokens("FastSpatial", 1);
    public static final MotionSchemeKeyTokens SlowSpatial = new MotionSchemeKeyTokens("SlowSpatial", 2);
    public static final MotionSchemeKeyTokens DefaultEffects = new MotionSchemeKeyTokens("DefaultEffects", 3);
    public static final MotionSchemeKeyTokens FastEffects = new MotionSchemeKeyTokens("FastEffects", 4);
    public static final MotionSchemeKeyTokens SlowEffects = new MotionSchemeKeyTokens("SlowEffects", 5);

    private static final /* synthetic */ MotionSchemeKeyTokens[] $values() {
        return new MotionSchemeKeyTokens[]{DefaultSpatial, FastSpatial, SlowSpatial, DefaultEffects, FastEffects, SlowEffects};
    }

    public static EnumEntries<MotionSchemeKeyTokens> getEntries() {
        return $ENTRIES;
    }

    private MotionSchemeKeyTokens(String str, int i) {
    }

    static {
        MotionSchemeKeyTokens[] motionSchemeKeyTokensArr$values = $values();
        $VALUES = motionSchemeKeyTokensArr$values;
        $ENTRIES = EnumEntriesKt.enumEntries(motionSchemeKeyTokensArr$values);
    }

    public static MotionSchemeKeyTokens valueOf(String str) {
        return (MotionSchemeKeyTokens) Enum.valueOf(MotionSchemeKeyTokens.class, str);
    }

    public static MotionSchemeKeyTokens[] values() {
        return (MotionSchemeKeyTokens[]) $VALUES.clone();
    }
}
