package androidx.compose.runtime.composer.linkbuffer;

import com.google.firebase.analytics.FirebaseAnalytics;
import java.util.Iterator;
import kotlin.Metadata;
import kotlin.jvm.internal.markers.KMappedMarker;
import org.mozilla.javascript.ES6Iterator;

/* JADX INFO: compiled from: SlotTable.kt */
/* JADX INFO: loaded from: classes.dex */
@Metadata(d1 = {"\u0000(\n\u0002\u0018\u0002\n\u0002\u0010\u001c\n\u0002\u0010\u0000\n\u0002\u0010(\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u000e\n\u0002\u0010\u000b\n\u0002\b\u0002\b\u0002\u0018\u00002\n\u0012\u0006\u0012\u0004\u0018\u00010\u00020\u00012\n\u0012\u0006\u0012\u0004\u0018\u00010\u00020\u0003B\u0017\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\u0006\u0010\u0006\u001a\u00020\u0007¢\u0006\u0004\b\b\u0010\tJ\u0011\u0010\u0014\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010\u00020\u0003H\u0096\u0002J\t\u0010\u0015\u001a\u00020\u0016H\u0096\u0002J\u000b\u0010\u0017\u001a\u0004\u0018\u00010\u0002H\u0096\u0002R\u0011\u0010\u0004\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b\n\u0010\u000bR\u0011\u0010\u0006\u001a\u00020\u0007¢\u0006\b\n\u0000\u001a\u0004\b\f\u0010\rR\u0011\u0010\u000e\u001a\u00020\u0007¢\u0006\b\n\u0000\u001a\u0004\b\u000f\u0010\rR\u001a\u0010\u0010\u001a\u00020\u0007X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0011\u0010\r\"\u0004\b\u0012\u0010\u0013¨\u0006\u0018"}, d2 = {"Landroidx/compose/runtime/composer/linkbuffer/DataIterator;", "", "", "", "table", "Landroidx/compose/runtime/composer/linkbuffer/SlotTable;", "group", "", "<init>", "(Landroidx/compose/runtime/composer/linkbuffer/SlotTable;I)V", "getTable", "()Landroidx/compose/runtime/composer/linkbuffer/SlotTable;", "getGroup", "()I", "end", "getEnd", FirebaseAnalytics.Param.INDEX, "getIndex", "setIndex", "(I)V", "iterator", "hasNext", "", ES6Iterator.NEXT_METHOD, "runtime"}, k = 1, mv = {2, 1, 0}, xi = 48)
final class DataIterator implements Iterable<Object>, Iterator<Object>, KMappedMarker {
    private final int end;
    private final int group;
    private int index;
    private final SlotTable table;

    @Override // java.util.Iterator
    public void remove() {
        throw new UnsupportedOperationException("Operation is not supported for read-only collection");
    }

    public DataIterator(SlotTable slotTable, int i) {
        int i2;
        this.table = slotTable;
        this.group = i;
        SlotTableAddressSpace addressSpace = slotTable.getAddressSpace();
        int iGroupSlotRange$runtime = slotTable.groupSlotRange$runtime(i);
        if (iGroupSlotRange$runtime == -1) {
            i2 = 0;
        } else {
            int i3 = (iGroupSlotRange$runtime & 15) + 1;
            i2 = i3 > 15 ? addressSpace.getLargeSizes().get(iGroupSlotRange$runtime >> 4) : i3;
        }
        this.end = i2;
        this.index = GroupFlagsKt.utilitySlotsCountForFlags(slotTable.groupFlags$runtime(i));
    }

    public final int getGroup() {
        return this.group;
    }

    public final SlotTable getTable() {
        return this.table;
    }

    public final int getEnd() {
        return this.end;
    }

    public final int getIndex() {
        return this.index;
    }

    public final void setIndex(int i) {
        this.index = i;
    }

    @Override // java.lang.Iterable
    public Iterator<Object> iterator() {
        return this;
    }

    @Override // java.util.Iterator
    public boolean hasNext() {
        return this.index < this.end;
    }

    @Override // java.util.Iterator
    public Object next() {
        SlotTable slotTable = this.table;
        int i = this.group;
        int i2 = this.index;
        this.index = i2 + 1;
        return slotTable.groupSlotAtIndex$runtime(i, i2);
    }
}
