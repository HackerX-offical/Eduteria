package androidx.compose.runtime.composer.linkbuffer;

import androidx.compose.runtime.ComposerKt;
import androidx.compose.runtime.tooling.ComposeStackTraceFrame;
import java.util.List;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt;

/* JADX INFO: compiled from: SlotTableReader.kt */
/* JADX INFO: loaded from: classes.dex */
@Metadata(d1 = {"\u0000\u001e\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u0000\n\u0000\u001a\u0012\u0010\u0000\u001a\b\u0012\u0004\u0012\u00020\u00020\u0001*\u00020\u0003H\u0000\u001a$\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00020\u0001*\u00020\u00032\u0006\u0010\u0005\u001a\u00020\u00062\b\u0010\u0007\u001a\u0004\u0018\u00010\bH\u0000¨\u0006\t"}, d2 = {"buildTrace", "", "Landroidx/compose/runtime/tooling/ComposeStackTraceFrame;", "Landroidx/compose/runtime/composer/linkbuffer/SlotTableReader;", "traceForGroup", "group", "", "child", "", "runtime"}, k = 2, mv = {2, 1, 0}, xi = 48)
public final class SlotTableReaderKt {
    public static final List<ComposeStackTraceFrame> buildTrace(SlotTableReader slotTableReader) {
        if (!slotTableReader.getIsClosed() && !slotTableReader.isEmpty()) {
            return SlotTableAddresSpaceKt.buildTrace(slotTableReader.getTable().getAddressSpace(), slotTableReader.getParent(), Integer.valueOf(slotTableReader.getSlotIndex()), new ReaderTraceBuilder(slotTableReader));
        }
        return CollectionsKt.emptyList();
    }

    public static final List<ComposeStackTraceFrame> traceForGroup(SlotTableReader slotTableReader, int i, Object obj) {
        ReaderTraceBuilder readerTraceBuilder = new ReaderTraceBuilder(slotTableReader);
        SlotTableAddressSpace addressSpace = slotTableReader.getTable().getAddressSpace();
        int[] groups = addressSpace.getGroups();
        int i2 = i;
        while (i2 > 0) {
            readerTraceBuilder.processEdge(slotTableReader.groupKey(i2), slotTableReader.groupObjectKey(i2), addressSpace.sourceInformationOf(i2), obj);
            obj = addressSpace.anchorOfAddress(i2);
            i2 = groups[i2 + 2];
        }
        if (!(i2 != 0)) {
            ComposerKt.composeImmediateRuntimeError("Traversing parent of group not in the slot table: " + i);
        }
        return readerTraceBuilder.trace();
    }
}
