package androidx.compose.ui.layout;

import com.google.common.net.HttpHeaders;
import kotlin.Metadata;
import kotlin.enums.EnumEntries;
import kotlin.enums.EnumEntriesKt;

/* JADX WARN: Failed to restore enum class, 'enum' modifier and super class removed */
/* JADX WARN: Unknown enum class pattern. Please report as an issue! */
/* JADX INFO: compiled from: Layout.kt */
/* JADX INFO: loaded from: classes3.dex */
@Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\b\u0005\b\u0080\u0081\u0002\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003j\u0002\b\u0004j\u0002\b\u0005¨\u0006\u0006"}, d2 = {"Landroidx/compose/ui/layout/IntrinsicWidthHeight;", "", "<init>", "(Ljava/lang/String;I)V", HttpHeaders.WIDTH, "Height", "ui"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final class IntrinsicWidthHeight {
    private static final /* synthetic */ EnumEntries $ENTRIES;
    private static final /* synthetic */ IntrinsicWidthHeight[] $VALUES;
    public static final IntrinsicWidthHeight Width = new IntrinsicWidthHeight(HttpHeaders.WIDTH, 0);
    public static final IntrinsicWidthHeight Height = new IntrinsicWidthHeight("Height", 1);

    private static final /* synthetic */ IntrinsicWidthHeight[] $values() {
        return new IntrinsicWidthHeight[]{Width, Height};
    }

    public static EnumEntries<IntrinsicWidthHeight> getEntries() {
        return $ENTRIES;
    }

    public static IntrinsicWidthHeight valueOf(String str) {
        return (IntrinsicWidthHeight) Enum.valueOf(IntrinsicWidthHeight.class, str);
    }

    public static IntrinsicWidthHeight[] values() {
        return (IntrinsicWidthHeight[]) $VALUES.clone();
    }

    private IntrinsicWidthHeight(String str, int i) {
    }

    static {
        IntrinsicWidthHeight[] intrinsicWidthHeightArr$values = $values();
        $VALUES = intrinsicWidthHeightArr$values;
        $ENTRIES = EnumEntriesKt.enumEntries(intrinsicWidthHeightArr$values);
    }
}
