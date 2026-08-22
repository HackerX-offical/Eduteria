package androidx.compose.runtime.composer.linkbuffer;

import androidx.compose.runtime.tooling.ComposeStackTraceFrame;
import java.util.List;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt;

/* JADX INFO: compiled from: SlotTableBuilder.kt */
/* JADX INFO: loaded from: classes.dex */
@Metadata(d1 = {"\u0000*\n\u0000\n\u0002\u0010\u000b\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\u001a\u0015\u0010\u0000\u001a\u00020\u0001*\u00020\u00022\u0006\u0010\u0003\u001a\u00020\u0002H\u0080\n\u001a\u0012\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00060\u0005*\u00020\u0007H\u0000\u001a!\u0010\b\u001a\u00060\u0002j\u0002`\t2\n\u0010\n\u001a\u00060\u0002j\u0002`\t2\u0006\u0010\u000b\u001a\u00020\fH\u0082\b¨\u0006\r"}, d2 = {"contains", "", "", "other", "buildTrace", "", "Landroidx/compose/runtime/tooling/ComposeStackTraceFrame;", "Landroidx/compose/runtime/composer/linkbuffer/SlotTableBuilder;", "lastSiblingOf", "Landroidx/compose/runtime/composer/linkbuffer/GroupAddress;", "address", "addressSpace", "Landroidx/compose/runtime/composer/linkbuffer/SlotTableAddressSpace;", "runtime"}, k = 2, mv = {2, 1, 0}, xi = 48)
public final class SlotTableBuilderKt {
    public static final boolean contains(int i, int i2) {
        return (i & i2) == i2;
    }

    public static final List<ComposeStackTraceFrame> buildTrace(SlotTableBuilder slotTableBuilder) {
        if (!slotTableBuilder.getIsClosed() && !slotTableBuilder.isEmpty()) {
            return SlotTableAddresSpaceKt.buildTrace(slotTableBuilder.getTable().getAddressSpace(), slotTableBuilder.getParent(), Integer.valueOf(slotTableBuilder.getSlotIndex()), new BuilderTraceBuilder(slotTableBuilder));
        }
        return CollectionsKt.emptyList();
    }

    private static final int lastSiblingOf(int i, SlotTableAddressSpace slotTableAddressSpace) {
        int i2 = -1;
        if (i == -1) {
            return -1;
        }
        int[] groups = slotTableAddressSpace.getGroups();
        while (i >= 0) {
            i2 = i;
            i = groups[i + 1];
        }
        return i2;
    }
}
