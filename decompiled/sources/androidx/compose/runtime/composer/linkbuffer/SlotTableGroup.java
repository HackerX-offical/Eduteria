package androidx.compose.runtime.composer.linkbuffer;

import androidx.compose.runtime.ComposerKt;
import androidx.compose.runtime.IntStack;
import androidx.compose.runtime.tooling.CompositionGroup;
import cz.msebera.android.httpclient.protocol.HTTP;
import java.util.Iterator;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.markers.KMappedMarker;
import org.jivesoftware.smackx.iot.data.element.NodeElement;

/* JADX INFO: compiled from: SlotTable.kt */
/* JADX INFO: loaded from: classes.dex */
@Metadata(d1 = {"\u0000H\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u001c\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\u0018\u0002\n\u0002\b\t\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0002\b\f\n\u0002\u0010(\n\u0002\b\u0005\n\u0002\u0010\u0002\n\u0002\b\u0006\b\u0002\u0018\u00002\u00020\u00012\b\u0012\u0004\u0012\u00020\u00010\u0002B%\u0012\u0006\u0010\u0003\u001a\u00020\u0004\u0012\n\u0010\u0005\u001a\u00060\u0006j\u0002`\u0007\u0012\b\b\u0002\u0010\b\u001a\u00020\u0006¢\u0006\u0004\b\t\u0010\nJ\u000f\u0010$\u001a\b\u0012\u0004\u0012\u00020\u00010%H\u0096\u0002J\b\u0010*\u001a\u00020+H\u0002J\u0012\u0010,\u001a\u0004\u0018\u00010\u00012\u0006\u0010-\u001a\u00020\u0014H\u0016J\u0013\u0010.\u001a\u00020\u00112\b\u0010/\u001a\u0004\u0018\u00010\u0014H\u0096\u0002J\b\u00100\u001a\u00020\u0006H\u0016R\u0011\u0010\u0003\u001a\u00020\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u000b\u0010\fR\u0015\u0010\u0005\u001a\u00060\u0006j\u0002`\u0007¢\u0006\b\n\u0000\u001a\u0004\b\r\u0010\u000eR\u0011\u0010\b\u001a\u00020\u0006¢\u0006\b\n\u0000\u001a\u0004\b\u000f\u0010\u000eR\u0014\u0010\u0010\u001a\u00020\u00118VX\u0096\u0004¢\u0006\u0006\u001a\u0004\b\u0010\u0010\u0012R\u0014\u0010\u0013\u001a\u00020\u00148VX\u0096\u0004¢\u0006\u0006\u001a\u0004\b\u0015\u0010\u0016R\u0016\u0010\u0017\u001a\u0004\u0018\u00010\u00188VX\u0096\u0004¢\u0006\u0006\u001a\u0004\b\u0019\u0010\u001aR\u0016\u0010\u001b\u001a\u0004\u0018\u00010\u00148VX\u0096\u0004¢\u0006\u0006\u001a\u0004\b\u001c\u0010\u0016R\u001c\u0010\u001d\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010\u00140\u00028VX\u0096\u0004¢\u0006\u0006\u001a\u0004\b\u001e\u0010\u001fR\u0014\u0010 \u001a\u00020\u00148VX\u0096\u0004¢\u0006\u0006\u001a\u0004\b!\u0010\u0016R\u001a\u0010\"\u001a\b\u0012\u0004\u0012\u00020\u00010\u00028VX\u0096\u0004¢\u0006\u0006\u001a\u0004\b#\u0010\u001fR\u0014\u0010&\u001a\u00020\u00068VX\u0096\u0004¢\u0006\u0006\u001a\u0004\b'\u0010\u000eR\u0014\u0010(\u001a\u00020\u00068VX\u0096\u0004¢\u0006\u0006\u001a\u0004\b)\u0010\u000e¨\u00061"}, d2 = {"Landroidx/compose/runtime/composer/linkbuffer/SlotTableGroup;", "Landroidx/compose/runtime/tooling/CompositionGroup;", "", "table", "Landroidx/compose/runtime/composer/linkbuffer/SlotTable;", "group", "", "Landroidx/compose/runtime/composer/linkbuffer/GroupAddress;", "version", "<init>", "(Landroidx/compose/runtime/composer/linkbuffer/SlotTable;II)V", "getTable", "()Landroidx/compose/runtime/composer/linkbuffer/SlotTable;", "getGroup", "()I", "getVersion", "isEmpty", "", "()Z", "key", "", "getKey", "()Ljava/lang/Object;", "sourceInfo", "", "getSourceInfo", "()Ljava/lang/String;", NodeElement.ELEMENT, "getNode", "data", "getData", "()Ljava/lang/Iterable;", HTTP.IDENTITY_CODING, "getIdentity", "compositionGroups", "getCompositionGroups", "iterator", "", "groupSize", "getGroupSize", "slotsSize", "getSlotsSize", "validateRead", "", "find", "identityToFind", "equals", "other", "hashCode", "runtime"}, k = 1, mv = {2, 1, 0}, xi = 48)
final class SlotTableGroup implements CompositionGroup, Iterable<CompositionGroup>, KMappedMarker {
    private final int group;
    private final SlotTable table;
    private final int version;

    public SlotTableGroup(SlotTable slotTable, int i, int i2) {
        this.table = slotTable;
        this.group = i;
        this.version = i2;
    }

    public final SlotTable getTable() {
        return this.table;
    }

    public final int getGroup() {
        return this.group;
    }

    public /* synthetic */ SlotTableGroup(SlotTable slotTable, int i, int i2, int i3, DefaultConstructorMarker defaultConstructorMarker) {
        this(slotTable, i, (i3 & 4) != 0 ? slotTable.getVersion() : i2);
    }

    public final int getVersion() {
        return this.version;
    }

    @Override // androidx.compose.runtime.tooling.CompositionData
    public boolean isEmpty() {
        return this.table.firstChildOf$runtime(this.group) == -1;
    }

    @Override // androidx.compose.runtime.tooling.CompositionGroup
    public Object getKey() {
        Object objGroupObjectKey$runtime = this.table.groupObjectKey$runtime(this.group);
        return objGroupObjectKey$runtime == null ? Integer.valueOf(this.table.groupKeyOf$runtime(this.group)) : objGroupObjectKey$runtime;
    }

    @Override // androidx.compose.runtime.tooling.CompositionGroup
    public String getSourceInfo() {
        if (this.table.groupHasAux$runtime(this.group)) {
            Object objGroupAux$runtime = this.table.groupAux$runtime(this.group);
            if (objGroupAux$runtime instanceof String) {
                return (String) objGroupAux$runtime;
            }
            return null;
        }
        LinkGroupSourceInformation linkGroupSourceInformationSourceInformationOf = this.table.getAddressSpace().sourceInformationOf(this.group);
        if (linkGroupSourceInformationSourceInformationOf != null) {
            return linkGroupSourceInformationSourceInformationOf.getSourceInformation();
        }
        return null;
    }

    @Override // androidx.compose.runtime.tooling.CompositionGroup
    public Object getNode() {
        return this.table.groupNode$runtime(this.group);
    }

    @Override // androidx.compose.runtime.tooling.CompositionGroup
    public Iterable<Object> getData() {
        LinkGroupSourceInformation linkGroupSourceInformationSourceInformationOf = this.table.getAddressSpace().sourceInformationOf(this.group);
        if (linkGroupSourceInformationSourceInformationOf != null) {
            return new SourceInformationGroupDataIterator(this.table, this.group, linkGroupSourceInformationSourceInformationOf);
        }
        return new DataIterator(this.table, this.group);
    }

    @Override // androidx.compose.runtime.tooling.CompositionGroup
    public Object getIdentity() {
        validateRead();
        return this.table.getAddressSpace().anchorOfAddress(this.group);
    }

    @Override // androidx.compose.runtime.tooling.CompositionData
    public Iterable<CompositionGroup> getCompositionGroups() {
        return this;
    }

    @Override // java.lang.Iterable
    public Iterator<CompositionGroup> iterator() {
        validateRead();
        LinkGroupSourceInformation linkGroupSourceInformationSourceInformationOf = this.table.getAddressSpace().sourceInformationOf(this.group);
        if (linkGroupSourceInformationSourceInformationOf != null) {
            return new SourceInformationGroupIterator(this.table, this.group, linkGroupSourceInformationSourceInformationOf, new AnchoredGroupPath(this.group));
        }
        SlotTable slotTable = this.table;
        return new GroupIterator(slotTable, slotTable.firstChildOf$runtime(this.group));
    }

    @Override // androidx.compose.runtime.tooling.CompositionGroup
    public int getGroupSize() {
        int i;
        SlotTableAddressSpace addressSpace = this.table.getAddressSpace();
        int i2 = this.group;
        int i3 = 0;
        if (i2 < 0) {
            return 0;
        }
        IntStack intStack = new IntStack();
        int[] groups = addressSpace.getGroups();
        int iPop = i2;
        while (true) {
            i3++;
            if (iPop != i2 && (i = groups[iPop + 1]) >= 0) {
                intStack.push(i);
            }
            iPop = groups[iPop + 3];
            if (iPop < 0) {
                if (intStack.tos == 0) {
                    return i3;
                }
                iPop = intStack.pop();
            }
        }
    }

    @Override // androidx.compose.runtime.tooling.CompositionGroup
    public int getSlotsSize() {
        int i;
        int i2;
        SlotTableAddressSpace addressSpace = this.table.getAddressSpace();
        int i3 = this.group;
        if (i3 < 0) {
            return 0;
        }
        IntStack intStack = new IntStack();
        int[] groups = addressSpace.getGroups();
        int iPop = i3;
        int i4 = 0;
        while (true) {
            int i5 = this.table.getAddressSpace().getGroups()[iPop + 5];
            if (i5 != -1) {
                SlotTableAddressSpace addressSpace2 = this.table.getAddressSpace();
                if (i5 == -1) {
                    i2 = 0;
                } else {
                    i2 = (i5 & 15) + 1;
                    if (i2 > 15) {
                        i2 = addressSpace2.getLargeSizes().get(i5 >> 4);
                    }
                }
                i4 += i2;
            }
            if (iPop != i3 && (i = groups[iPop + 1]) >= 0) {
                intStack.push(i);
            }
            iPop = groups[iPop + 3];
            if (iPop < 0) {
                if (intStack.tos == 0) {
                    return i4;
                }
                iPop = intStack.pop();
            }
        }
    }

    private final void validateRead() {
        if (this.table.getVersion() != this.version) {
            SlotTableKt.throwConcurrentModificationException();
        }
    }

    private static final CompositionGroup find$findAnchoredGroup(SlotTableGroup slotTableGroup, LinkAnchor linkAnchor) {
        SlotTableAddressSpace addressSpace = slotTableGroup.table.getAddressSpace();
        if (!addressSpace.ownsAnchor(linkAnchor)) {
            return null;
        }
        int address = linkAnchor.getAddress();
        if (address == slotTableGroup.group) {
            return slotTableGroup;
        }
        int[] groups = addressSpace.getGroups();
        int i = groups[address + 2];
        while (i > 0) {
            if (i == slotTableGroup.group) {
                return new SlotTableGroup(slotTableGroup.table, address, slotTableGroup.version);
            }
            i = groups[i + 2];
        }
        if (i != 0) {
            return null;
        }
        ComposerKt.composeImmediateRuntimeError("Traversing parent of group not in the slot table: " + address);
        return null;
    }

    private static final CompositionGroup find$findRelativeGroup(CompositionGroup compositionGroup, int i) {
        return (CompositionGroup) CollectionsKt.firstOrNull(CollectionsKt.drop(compositionGroup.getCompositionGroups(), i));
    }

    @Override // androidx.compose.runtime.tooling.CompositionData
    public CompositionGroup find(Object identityToFind) {
        if (identityToFind instanceof LinkAnchor) {
            return find$findAnchoredGroup(this, (LinkAnchor) identityToFind);
        }
        if (identityToFind instanceof SourceInformationSlotTableGroupIdentity) {
            SourceInformationSlotTableGroupIdentity sourceInformationSlotTableGroupIdentity = (SourceInformationSlotTableGroupIdentity) identityToFind;
            CompositionGroup compositionGroupFind = find(sourceInformationSlotTableGroupIdentity.getParentIdentity());
            if (compositionGroupFind != null) {
                return find$findRelativeGroup(compositionGroupFind, sourceInformationSlotTableGroupIdentity.getIndex());
            }
        }
        return null;
    }

    public boolean equals(Object other) {
        if (!(other instanceof SlotTableGroup)) {
            return false;
        }
        SlotTableGroup slotTableGroup = (SlotTableGroup) other;
        return slotTableGroup.group == this.group && slotTableGroup.version == this.version && Intrinsics.areEqual(slotTableGroup.table, this.table);
    }

    public int hashCode() {
        return this.group + (this.table.hashCode() * 31);
    }
}
