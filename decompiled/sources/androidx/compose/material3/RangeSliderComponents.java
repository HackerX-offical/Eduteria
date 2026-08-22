package androidx.compose.material3;

import kotlin.Metadata;
import kotlin.enums.EnumEntries;
import kotlin.enums.EnumEntriesKt;

/* JADX WARN: Failed to restore enum class, 'enum' modifier and super class removed */
/* JADX WARN: Unknown enum class pattern. Please report as an issue! */
/* JADX INFO: compiled from: Slider.kt */
/* JADX INFO: loaded from: classes.dex */
@Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\b\u0006\b\u0082\u0081\u0002\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003j\u0002\b\u0004j\u0002\b\u0005j\u0002\b\u0006¨\u0006\u0007"}, d2 = {"Landroidx/compose/material3/RangeSliderComponents;", "", "<init>", "(Ljava/lang/String;I)V", "ENDTHUMB", "STARTTHUMB", "TRACK", "material3"}, k = 1, mv = {2, 0, 0}, xi = 48)
final class RangeSliderComponents {
    private static final /* synthetic */ EnumEntries $ENTRIES;
    private static final /* synthetic */ RangeSliderComponents[] $VALUES;
    public static final RangeSliderComponents ENDTHUMB = new RangeSliderComponents("ENDTHUMB", 0);
    public static final RangeSliderComponents STARTTHUMB = new RangeSliderComponents("STARTTHUMB", 1);
    public static final RangeSliderComponents TRACK = new RangeSliderComponents("TRACK", 2);

    private static final /* synthetic */ RangeSliderComponents[] $values() {
        return new RangeSliderComponents[]{ENDTHUMB, STARTTHUMB, TRACK};
    }

    public static EnumEntries<RangeSliderComponents> getEntries() {
        return $ENTRIES;
    }

    private RangeSliderComponents(String str, int i) {
    }

    static {
        RangeSliderComponents[] rangeSliderComponentsArr$values = $values();
        $VALUES = rangeSliderComponentsArr$values;
        $ENTRIES = EnumEntriesKt.enumEntries(rangeSliderComponentsArr$values);
    }

    public static RangeSliderComponents valueOf(String str) {
        return (RangeSliderComponents) Enum.valueOf(RangeSliderComponents.class, str);
    }

    public static RangeSliderComponents[] values() {
        return (RangeSliderComponents[]) $VALUES.clone();
    }
}
