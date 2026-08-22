package androidx.compose.foundation.text.contextmenu.modifier;

import kotlin.Metadata;
import kotlin.enums.EnumEntries;
import kotlin.enums.EnumEntriesKt;

/* JADX WARN: Failed to restore enum class, 'enum' modifier and super class removed */
/* JADX WARN: Unknown enum class pattern. Please report as an issue! */
/* JADX INFO: compiled from: TextContextMenuToolbarHandlerModifier.kt */
/* JADX INFO: loaded from: classes.dex */
@Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\b\u0006\b\u0080\u0081\u0002\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003j\u0002\b\u0004j\u0002\b\u0005j\u0002\b\u0006¨\u0006\u0007"}, d2 = {"Landroidx/compose/foundation/text/contextmenu/modifier/ToolbarHandlerState;", "", "<init>", "(Ljava/lang/String;I)V", "Uninitialized", "Detached", "Attached", "foundation"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final class ToolbarHandlerState {
    private static final /* synthetic */ EnumEntries $ENTRIES;
    private static final /* synthetic */ ToolbarHandlerState[] $VALUES;
    public static final ToolbarHandlerState Uninitialized = new ToolbarHandlerState("Uninitialized", 0);
    public static final ToolbarHandlerState Detached = new ToolbarHandlerState("Detached", 1);
    public static final ToolbarHandlerState Attached = new ToolbarHandlerState("Attached", 2);

    private static final /* synthetic */ ToolbarHandlerState[] $values() {
        return new ToolbarHandlerState[]{Uninitialized, Detached, Attached};
    }

    public static EnumEntries<ToolbarHandlerState> getEntries() {
        return $ENTRIES;
    }

    public static ToolbarHandlerState valueOf(String str) {
        return (ToolbarHandlerState) Enum.valueOf(ToolbarHandlerState.class, str);
    }

    public static ToolbarHandlerState[] values() {
        return (ToolbarHandlerState[]) $VALUES.clone();
    }

    private ToolbarHandlerState(String str, int i) {
    }

    static {
        ToolbarHandlerState[] toolbarHandlerStateArr$values = $values();
        $VALUES = toolbarHandlerStateArr$values;
        $ENTRIES = EnumEntriesKt.enumEntries(toolbarHandlerStateArr$values);
    }
}
