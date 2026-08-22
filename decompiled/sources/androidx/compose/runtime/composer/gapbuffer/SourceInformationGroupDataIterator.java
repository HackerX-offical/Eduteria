package androidx.compose.runtime.composer.gapbuffer;

import com.google.firebase.analytics.FirebaseAnalytics;
import java.util.ArrayList;
import java.util.Iterator;
import kotlin.Metadata;
import kotlin.jvm.internal.markers.KMappedMarker;
import org.mozilla.javascript.ES6Iterator;

/* JADX INFO: compiled from: SlotTable.kt */
/* JADX INFO: loaded from: classes.dex */
@Metadata(d1 = {"\u00006\n\u0002\u0018\u0002\n\u0002\u0010\u001c\n\u0002\u0010\u0000\n\u0002\u0010(\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0002\b\u0002\b\u0002\u0018\u00002\n\u0012\u0006\u0012\u0004\u0018\u00010\u00020\u00012\n\u0012\u0006\u0012\u0004\u0018\u00010\u00020\u0003B\u001f\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\u0006\u0010\u0006\u001a\u00020\u0007\u0012\u0006\u0010\b\u001a\u00020\t¢\u0006\u0004\b\n\u0010\u000bJ\u0011\u0010\u0014\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010\u00020\u0003H\u0096\u0002J\t\u0010\u0015\u001a\u00020\u0016H\u0096\u0002J\u000b\u0010\u0017\u001a\u0004\u0018\u00010\u0002H\u0096\u0002R\u0011\u0010\u0004\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b\f\u0010\rR\u000e\u0010\u000e\u001a\u00020\u0007X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u000f\u001a\u00020\u0007X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0010\u001a\u00020\u0007X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0011\u001a\u00020\u0012X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0013\u001a\u00020\u0007X\u0082\u000e¢\u0006\u0002\n\u0000¨\u0006\u0018"}, d2 = {"Landroidx/compose/runtime/composer/gapbuffer/SourceInformationGroupDataIterator;", "", "", "", "table", "Landroidx/compose/runtime/composer/gapbuffer/SlotTable;", "group", "", "sourceInformation", "Landroidx/compose/runtime/composer/gapbuffer/GapGroupSourceInformation;", "<init>", "(Landroidx/compose/runtime/composer/gapbuffer/SlotTable;ILandroidx/compose/runtime/composer/gapbuffer/GapGroupSourceInformation;)V", "getTable", "()Landroidx/compose/runtime/composer/gapbuffer/SlotTable;", "base", "start", "end", "filter", "Landroidx/compose/runtime/composer/gapbuffer/BitVector;", FirebaseAnalytics.Param.INDEX, "iterator", "hasNext", "", ES6Iterator.NEXT_METHOD, "runtime"}, k = 1, mv = {2, 1, 0}, xi = 48)
final class SourceInformationGroupDataIterator implements Iterable<Object>, Iterator<Object>, KMappedMarker {
    private final int base;
    private final int end;
    private final BitVector filter;
    private int index;
    private final int start;
    private final SlotTable table;

    @Override // java.util.Iterator
    public void remove() {
        throw new UnsupportedOperationException("Operation is not supported for read-only collection");
    }

    public SourceInformationGroupDataIterator(SlotTable slotTable, int i, GapGroupSourceInformation gapGroupSourceInformation) {
        int slotsSize;
        this.table = slotTable;
        int i2 = slotTable.getGroups()[(i * 5) + 4];
        this.base = i2;
        this.start = gapGroupSourceInformation.getDataStartOffset();
        int dataEndOffset = gapGroupSourceInformation.getDataEndOffset();
        if (dataEndOffset <= 0) {
            int i3 = i + 1;
            if (i3 >= slotTable.getGroupsSize()) {
                slotsSize = slotTable.getSlotsSize();
            } else {
                slotsSize = slotTable.getGroups()[(i3 * 5) + 4];
            }
            dataEndOffset = slotsSize - i2;
        }
        this.end = dataEndOffset;
        BitVector bitVector = new BitVector();
        ArrayList<Object> groups = gapGroupSourceInformation.getGroups();
        if (groups != null) {
            ArrayList<Object> arrayList = groups;
            int size = arrayList.size();
            for (int i4 = 0; i4 < size; i4++) {
                Object obj = arrayList.get(i4);
                if (obj instanceof GapGroupSourceInformation) {
                    GapGroupSourceInformation gapGroupSourceInformation2 = (GapGroupSourceInformation) obj;
                    bitVector.setRange(gapGroupSourceInformation2.getDataStartOffset(), gapGroupSourceInformation2.getDataEndOffset());
                }
            }
        }
        this.filter = bitVector;
        this.index = bitVector.nextClear(this.start);
    }

    public final SlotTable getTable() {
        return this.table;
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
        int i = this.end;
        int i2 = this.index;
        Object obj = (i2 < 0 || i2 >= i) ? null : this.table.getSlots()[this.base + this.index];
        this.index = this.filter.nextClear(this.index + 1);
        return obj;
    }
}
