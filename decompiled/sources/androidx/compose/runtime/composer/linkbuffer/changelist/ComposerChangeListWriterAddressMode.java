package androidx.compose.runtime.composer.linkbuffer.changelist;

import kotlin.Metadata;
import kotlin.enums.EnumEntries;
import kotlin.enums.EnumEntriesKt;

/* JADX WARN: Failed to restore enum class, 'enum' modifier and super class removed */
/* JADX WARN: Unknown enum class pattern. Please report as an issue! */
/* JADX INFO: compiled from: ComposerChangeListWriter.kt */
/* JADX INFO: loaded from: classes.dex */
@Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\b\u0006\b\u0080\u0081\u0002\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003j\u0002\b\u0004j\u0002\b\u0005j\u0002\b\u0006¨\u0006\u0007"}, d2 = {"Landroidx/compose/runtime/composer/linkbuffer/changelist/ComposerChangeListWriterAddressMode;", "", "<init>", "(Ljava/lang/String;I)V", "AbsoluteAddressing", "AnchorAddressing", "RelativeAddressing", "runtime"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final class ComposerChangeListWriterAddressMode {
    private static final /* synthetic */ EnumEntries $ENTRIES;
    private static final /* synthetic */ ComposerChangeListWriterAddressMode[] $VALUES;
    public static final ComposerChangeListWriterAddressMode AbsoluteAddressing = new ComposerChangeListWriterAddressMode("AbsoluteAddressing", 0);
    public static final ComposerChangeListWriterAddressMode AnchorAddressing = new ComposerChangeListWriterAddressMode("AnchorAddressing", 1);
    public static final ComposerChangeListWriterAddressMode RelativeAddressing = new ComposerChangeListWriterAddressMode("RelativeAddressing", 2);

    private static final /* synthetic */ ComposerChangeListWriterAddressMode[] $values() {
        return new ComposerChangeListWriterAddressMode[]{AbsoluteAddressing, AnchorAddressing, RelativeAddressing};
    }

    public static EnumEntries<ComposerChangeListWriterAddressMode> getEntries() {
        return $ENTRIES;
    }

    public static ComposerChangeListWriterAddressMode valueOf(String str) {
        return (ComposerChangeListWriterAddressMode) Enum.valueOf(ComposerChangeListWriterAddressMode.class, str);
    }

    public static ComposerChangeListWriterAddressMode[] values() {
        return (ComposerChangeListWriterAddressMode[]) $VALUES.clone();
    }

    private ComposerChangeListWriterAddressMode(String str, int i) {
    }

    static {
        ComposerChangeListWriterAddressMode[] composerChangeListWriterAddressModeArr$values = $values();
        $VALUES = composerChangeListWriterAddressModeArr$values;
        $ENTRIES = EnumEntriesKt.enumEntries(composerChangeListWriterAddressModeArr$values);
    }
}
