package androidx.compose.material3.tokens;

import kotlin.Metadata;
import kotlin.enums.EnumEntries;
import kotlin.enums.EnumEntriesKt;

/* JADX WARN: Failed to restore enum class, 'enum' modifier and super class removed */
/* JADX WARN: Unknown enum class pattern. Please report as an issue! */
/* JADX INFO: compiled from: ShapeKeyTokens.kt */
/* JADX INFO: loaded from: classes.dex */
@Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\b\u0012\b\u0080\u0081\u0002\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003j\u0002\b\u0004j\u0002\b\u0005j\u0002\b\u0006j\u0002\b\u0007j\u0002\b\bj\u0002\b\tj\u0002\b\nj\u0002\b\u000bj\u0002\b\fj\u0002\b\rj\u0002\b\u000ej\u0002\b\u000fj\u0002\b\u0010j\u0002\b\u0011j\u0002\b\u0012¨\u0006\u0013"}, d2 = {"Landroidx/compose/material3/tokens/ShapeKeyTokens;", "", "<init>", "(Ljava/lang/String;I)V", "CornerExtraExtraLarge", "CornerExtraLarge", "CornerExtraLargeIncreased", "CornerExtraLargeTop", "CornerExtraSmall", "CornerExtraSmallTop", "CornerFull", "CornerLarge", "CornerLargeEnd", "CornerLargeIncreased", "CornerLargeStart", "CornerLargeTop", "CornerMedium", "CornerNone", "CornerSmall", "material3"}, k = 1, mv = {2, 0, 0}, xi = 48)
public final class ShapeKeyTokens {
    private static final /* synthetic */ EnumEntries $ENTRIES;
    private static final /* synthetic */ ShapeKeyTokens[] $VALUES;
    public static final ShapeKeyTokens CornerExtraExtraLarge = new ShapeKeyTokens("CornerExtraExtraLarge", 0);
    public static final ShapeKeyTokens CornerExtraLarge = new ShapeKeyTokens("CornerExtraLarge", 1);
    public static final ShapeKeyTokens CornerExtraLargeIncreased = new ShapeKeyTokens("CornerExtraLargeIncreased", 2);
    public static final ShapeKeyTokens CornerExtraLargeTop = new ShapeKeyTokens("CornerExtraLargeTop", 3);
    public static final ShapeKeyTokens CornerExtraSmall = new ShapeKeyTokens("CornerExtraSmall", 4);
    public static final ShapeKeyTokens CornerExtraSmallTop = new ShapeKeyTokens("CornerExtraSmallTop", 5);
    public static final ShapeKeyTokens CornerFull = new ShapeKeyTokens("CornerFull", 6);
    public static final ShapeKeyTokens CornerLarge = new ShapeKeyTokens("CornerLarge", 7);
    public static final ShapeKeyTokens CornerLargeEnd = new ShapeKeyTokens("CornerLargeEnd", 8);
    public static final ShapeKeyTokens CornerLargeIncreased = new ShapeKeyTokens("CornerLargeIncreased", 9);
    public static final ShapeKeyTokens CornerLargeStart = new ShapeKeyTokens("CornerLargeStart", 10);
    public static final ShapeKeyTokens CornerLargeTop = new ShapeKeyTokens("CornerLargeTop", 11);
    public static final ShapeKeyTokens CornerMedium = new ShapeKeyTokens("CornerMedium", 12);
    public static final ShapeKeyTokens CornerNone = new ShapeKeyTokens("CornerNone", 13);
    public static final ShapeKeyTokens CornerSmall = new ShapeKeyTokens("CornerSmall", 14);

    private static final /* synthetic */ ShapeKeyTokens[] $values() {
        return new ShapeKeyTokens[]{CornerExtraExtraLarge, CornerExtraLarge, CornerExtraLargeIncreased, CornerExtraLargeTop, CornerExtraSmall, CornerExtraSmallTop, CornerFull, CornerLarge, CornerLargeEnd, CornerLargeIncreased, CornerLargeStart, CornerLargeTop, CornerMedium, CornerNone, CornerSmall};
    }

    public static EnumEntries<ShapeKeyTokens> getEntries() {
        return $ENTRIES;
    }

    private ShapeKeyTokens(String str, int i) {
    }

    static {
        ShapeKeyTokens[] shapeKeyTokensArr$values = $values();
        $VALUES = shapeKeyTokensArr$values;
        $ENTRIES = EnumEntriesKt.enumEntries(shapeKeyTokensArr$values);
    }

    public static ShapeKeyTokens valueOf(String str) {
        return (ShapeKeyTokens) Enum.valueOf(ShapeKeyTokens.class, str);
    }

    public static ShapeKeyTokens[] values() {
        return (ShapeKeyTokens[]) $VALUES.clone();
    }
}
