package androidx.compose.runtime.composer.linkbuffer;

import androidx.compose.runtime.Composer;
import androidx.compose.runtime.ComposerKt;
import androidx.compose.runtime.IntStack;
import com.facebook.appevents.iap.InAppPurchaseConstants;
import kotlin.Metadata;
import kotlin.UInt;
import kotlin.collections.ArraysKt;
import kotlin.jvm.internal.Intrinsics;
import org.jivesoftware.smack.packet.Message;
import org.jivesoftware.smackx.iot.data.element.NodeElement;

/* JADX INFO: compiled from: SlotTableBuilder.kt */
/* JADX INFO: loaded from: classes.dex */
@Metadata(d1 = {"\u0000x\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\n\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0011\n\u0002\b\u000f\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\t\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0002\b\u000b\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0002\b\f\b\u0001\u0018\u00002\u00020\u0001B\u001f\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\u0006\u0010\u0006\u001a\u00020\u0005¢\u0006\u0004\b\u0007\u0010\bB!\b\u0016\u0012\u0006\u0010\t\u001a\u00020\n\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\u0006\u0010\u0006\u001a\u00020\u0005¢\u0006\u0004\b\u0007\u0010\u000bJ\u0012\u00107\u001a\u00020\u00152\n\u00108\u001a\u00060\u0015j\u0002`\u0019J\u0014\u00109\u001a\u0004\u0018\u00010\u00012\n\u00108\u001a\u00060\u0015j\u0002`\u0019J\u0014\u0010:\u001a\u0004\u0018\u00010\u00012\n\u00108\u001a\u00060\u0015j\u0002`\u0019J\u0012\u0010;\u001a\u00020\u00152\n\u00108\u001a\u00060\u0015j\u0002`<J\u0006\u0010=\u001a\u00020\u0005J\n\u0010>\u001a\u000603j\u0002`4J\u0012\u0010\u0014\u001a\u00020\u00152\n\u00108\u001a\u00060\u0015j\u0002`\u0019J\u0006\u0010?\u001a\u00020@J\u0006\u0010A\u001a\u00020@J\u0006\u0010B\u001a\u00020@J\u001d\u0010C\u001a\u00020@2\u0006\u0010D\u001a\u00020\u00152\n\b\u0002\u0010E\u001a\u0004\u0018\u00010\u0001H\u0086\bJ%\u0010F\u001a\u00020@2\u0006\u0010D\u001a\u00020\u00152\b\u0010E\u001a\u0004\u0018\u00010\u00012\b\u0010G\u001a\u0004\u0018\u00010\u0001H\u0086\bJ%\u0010H\u001a\u00020@2\u0006\u0010D\u001a\u00020\u00152\b\u0010E\u001a\u0004\u0018\u00010\u00012\b\u0010I\u001a\u0004\u0018\u00010\u0001H\u0086\bJ:\u0010J\u001a\u00020@2\u0006\u0010D\u001a\u00020\u00152\n\u0010K\u001a\u00060\u0015j\u0002`L2\b\u0010E\u001a\u0004\u0018\u00010\u00012\b\u0010I\u001a\u0004\u0018\u00010\u00012\b\u0010G\u001a\u0004\u0018\u00010\u0001H\u0002J\u0006\u0010M\u001a\u00020\u0015J\u0010\u0010N\u001a\u00020@2\b\u0010&\u001a\u0004\u0018\u00010\u0001J\u0010\u0010O\u001a\u00020@2\b\u0010&\u001a\u0004\u0018\u00010\u0001J\u0012\u0010P\u001a\u00020@2\n\u0010K\u001a\u00060\u0015j\u0002`LJ\u001a\u0010Q\u001a\u00020@2\u0006\u0010R\u001a\u00020S2\n\u0010T\u001a\u000603j\u0002`4J\u000e\u0010U\u001a\u00020@2\u0006\u0010V\u001a\u00020WJ\u0016\u0010X\u001a\u00020@2\u0006\u0010D\u001a\u00020\u00152\u0006\u0010V\u001a\u00020WJ\u0006\u0010Y\u001a\u00020@J\u0006\u0010Z\u001a\u00020@J\u0006\u0010[\u001a\u00020\u0003J\b\u0010\\\u001a\u00020@H\u0002J\u0010\u0010]\u001a\u00020\u00152\u0006\u0010^\u001a\u00020\u0015H\u0002J\u0014\u0010_\u001a\u00020@2\n\u0010^\u001a\u00060\u0015j\u0002`\u0019H\u0002J\b\u0010`\u001a\u00020@H\u0002J\b\u0010a\u001a\u00020@H\u0002J\u0012\u0010b\u001a\u00020@2\b\u0010&\u001a\u0004\u0018\u00010\u0001H\u0002R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\f\u0010\rR\u001a\u0010\u0004\u001a\u00020\u0005X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u000e\u0010\u000f\"\u0004\b\u0010\u0010\u0011R\u001a\u0010\u0006\u001a\u00020\u0005X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0012\u0010\u000f\"\u0004\b\u0013\u0010\u0011R\u000e\u0010\t\u001a\u00020\nX\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0014\u001a\u00020\u0015X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0016\u001a\u00020\u0017X\u0082\u0004¢\u0006\u0002\n\u0000R\u0012\u0010\u0018\u001a\u00060\u0015j\u0002`\u0019X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u001a\u001a\u00020\u0017X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u001b\u001a\u00020\u0015X\u0082\u000e¢\u0006\u0002\n\u0000R\u0018\u0010\u001c\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010\u00010\u001dX\u0082\u000e¢\u0006\u0004\n\u0002\u0010\u001eR\u000e\u0010\u001f\u001a\u00020\u0015X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010 \u001a\u00020\u0015X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010!\u001a\u00020\u0015X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\"\u001a\u00020\u0005X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010#\u001a\u00020\u0015X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010$\u001a\u00020\u0015X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010%\u001a\u00020\u0015X\u0082\u000e¢\u0006\u0002\n\u0000R\u001e\u0010'\u001a\u00020\u00052\u0006\u0010&\u001a\u00020\u0005@BX\u0086\u000e¢\u0006\b\n\u0000\u001a\u0004\b'\u0010\u000fR\u0011\u0010(\u001a\u00020\u00058F¢\u0006\u0006\u001a\u0004\b(\u0010\u000fR\u0011\u0010)\u001a\u00020\u00158F¢\u0006\u0006\u001a\u0004\b*\u0010+R\u0011\u0010,\u001a\u00020-8F¢\u0006\u0006\u001a\u0004\b.\u0010/R\u0011\u00100\u001a\u00020\u00158F¢\u0006\u0006\u001a\u0004\b1\u0010+R\u0015\u00102\u001a\u000603j\u0002`48F¢\u0006\u0006\u001a\u0004\b5\u00106¨\u0006c"}, d2 = {"Landroidx/compose/runtime/composer/linkbuffer/SlotTableBuilder;", "", "table", "Landroidx/compose/runtime/composer/linkbuffer/SlotTable;", "recordSourceInformation", "", "recordCallByInformation", "<init>", "(Landroidx/compose/runtime/composer/linkbuffer/SlotTable;ZZ)V", "addressSpace", "Landroidx/compose/runtime/composer/linkbuffer/SlotTableAddressSpace;", "(Landroidx/compose/runtime/composer/linkbuffer/SlotTableAddressSpace;ZZ)V", "getTable", "()Landroidx/compose/runtime/composer/linkbuffer/SlotTable;", "getRecordSourceInformation", "()Z", "setRecordSourceInformation", "(Z)V", "getRecordCallByInformation", "setRecordCallByInformation", Message.Thread.PARENT_ATTRIBUTE_NAME, "", "parentStack", "Landroidx/compose/runtime/IntStack;", "previousSibling", "Landroidx/compose/runtime/composer/linkbuffer/GroupAddress;", "previousSiblingStack", "nodeCount", "slots", "", "[Ljava/lang/Object;", "slotStart", "slotCurrent", "slotEnd", "inReservedRange", "slotReserveStart", "slotReserveEnd", "slotReserveUsedUpTo", "value", "isClosed", "isEmpty", "parentGroup", "getParentGroup", "()I", "parentAnchor", "Landroidx/compose/runtime/composer/linkbuffer/LinkAnchor;", "getParentAnchor", "()Landroidx/compose/runtime/composer/linkbuffer/LinkAnchor;", "slotIndex", "getSlotIndex", "parentHandle", "", "Landroidx/compose/runtime/composer/linkbuffer/GroupHandle;", "getParentHandle", "()J", "groupKey", "address", "groupObjectKey", "groupAux", "flagsOf", "Landroidx/compose/runtime/composer/linkbuffer/SlotAddress;", "isNode", "lastRoot", "buildStart", "", "collectSourceInformation", "collectCallByInformation", "startGroup", "key", "objectKey", "startNodeGroup", NodeElement.ELEMENT, "startDataGroup", "aux", "startNewGroup", "flags", "Landroidx/compose/runtime/composer/linkbuffer/GroupFlags;", "endGroup", "append", "insertAux", "addFlags", "moveFrom", "sourceEditor", "Landroidx/compose/runtime/composer/linkbuffer/SlotTableEditor;", "sourceHandle", "recordGroupSourceInformation", "sourceInformation", "", "recordGrouplessCallSourceInformationStart", "recordGrouplessCallSourceInformationEnd", "close", InAppPurchaseConstants.METHOD_BUILD, "buildEnd", "saveSlotRange", "group", "restoreFromSlotRange", "reserveSlotSlotRegion", "returnReservedSlotRegion", "slowAppend", "runtime"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final class SlotTableBuilder {
    public static final int $stable = 8;
    private final SlotTableAddressSpace addressSpace;
    private boolean inReservedRange;
    private boolean isClosed;
    private int nodeCount;
    private int parent;
    private final IntStack parentStack;
    private int previousSibling;
    private final IntStack previousSiblingStack;
    private boolean recordCallByInformation;
    private boolean recordSourceInformation;
    private int slotCurrent;
    private int slotEnd;
    private int slotReserveEnd;
    private int slotReserveStart;
    private int slotReserveUsedUpTo;
    private int slotStart;
    private Object[] slots;
    private final SlotTable table;

    public SlotTableBuilder(SlotTable slotTable, boolean z, boolean z2) {
        int i;
        this.table = slotTable;
        this.recordSourceInformation = z;
        this.recordCallByInformation = z2;
        SlotTableAddressSpace addressSpace = slotTable.getAddressSpace();
        this.addressSpace = addressSpace;
        int i2 = -1;
        this.parent = -1;
        this.parentStack = new IntStack();
        int root = slotTable.getRoot();
        if (root != -1) {
            int[] groups = addressSpace.getGroups();
            while (true) {
                i = i2;
                i2 = root;
                if (i2 < 0) {
                    break;
                } else {
                    root = groups[i2 + 1];
                }
            }
            i2 = i;
        }
        this.previousSibling = i2;
        this.previousSiblingStack = new IntStack();
        this.slots = this.addressSpace.getSlots();
    }

    public final SlotTable getTable() {
        return this.table;
    }

    public final boolean getRecordSourceInformation() {
        return this.recordSourceInformation;
    }

    public final void setRecordSourceInformation(boolean z) {
        this.recordSourceInformation = z;
    }

    public final boolean getRecordCallByInformation() {
        return this.recordCallByInformation;
    }

    public final void setRecordCallByInformation(boolean z) {
        this.recordCallByInformation = z;
    }

    public SlotTableBuilder(SlotTableAddressSpace slotTableAddressSpace, boolean z, boolean z2) {
        this(new SlotTable(0, slotTableAddressSpace, z, z2, 1, null), z, z2);
    }

    /* JADX INFO: renamed from: isClosed, reason: from getter */
    public final boolean getIsClosed() {
        return this.isClosed;
    }

    public final boolean isEmpty() {
        return this.parent == -1;
    }

    /* JADX INFO: renamed from: getParentGroup, reason: from getter */
    public final int getParent() {
        return this.parent;
    }

    public final LinkAnchor getParentAnchor() {
        return this.addressSpace.anchorOfAddress(getParent());
    }

    public final int getSlotIndex() {
        return this.slotCurrent - this.slotStart;
    }

    public final long getParentHandle() {
        return (((long) UInt.m12488constructorimpl(this.parent)) & 4294967295L) | (((long) (this.previousSiblingStack.tos == 0 ? -1 : this.previousSiblingStack.peek())) << 32);
    }

    public final int groupKey(int address) {
        return this.addressSpace.getGroups()[address];
    }

    public final Object groupObjectKey(int address) {
        int[] groups = this.addressSpace.getGroups();
        int i = groups[address + 4];
        if ((i & 16777216) == 16777216) {
            return this.slots[(groups[address + 5] >> 4) + Integer.bitCount(8388608 & i)];
        }
        return null;
    }

    public final Object groupAux(int address) {
        int[] groups = this.addressSpace.getGroups();
        int i = groups[address + 4];
        if ((i & GroupFlagsKt.HasAuxSlotFlag) == 33554432) {
            return this.slots[(groups[address + 5] >> 4) + Integer.bitCount(25165824 & i)];
        }
        return Composer.INSTANCE.getEmpty();
    }

    public final int flagsOf(int address) {
        return this.addressSpace.getGroups()[address + 4];
    }

    public final boolean isNode() {
        int i = this.parent;
        return i != -1 && (this.addressSpace.getGroups()[i + 4] & 8388608) == 8388608;
    }

    public final long lastRoot() {
        int root = this.table.getRoot();
        int i = -1;
        if (root != -1) {
            SlotTableAddressSpace slotTableAddressSpace = this.addressSpace;
            int root2 = this.table.getRoot();
            int[] groups = slotTableAddressSpace.getGroups();
            for (int i2 = groups[root2 + 1]; i2 >= 0; i2 = groups[i2 + 1]) {
                i = root;
                root = i2;
            }
        }
        return (((long) i) << 32) | (((long) UInt.m12488constructorimpl(root)) & 4294967295L);
    }

    public final int parent(int address) {
        return this.addressSpace.getGroups()[address + 2];
    }

    public final void buildStart() {
        reserveSlotSlotRegion();
    }

    public final void collectSourceInformation() {
        this.recordSourceInformation = true;
        this.table.setRecordSourceInformation(true);
    }

    public final void collectCallByInformation() {
        this.recordCallByInformation = true;
        this.table.setRecordCallByInformation(true);
    }

    public static /* synthetic */ void startGroup$default(SlotTableBuilder slotTableBuilder, int i, Object obj, int i2, Object obj2) {
        if ((i2 & 2) != 0) {
            obj = Composer.INSTANCE.getEmpty();
        }
        Object obj3 = obj;
        slotTableBuilder.startNewGroup(i, obj3 == Composer.INSTANCE.getEmpty() ? 0 : 16777216, obj3, null, null);
    }

    public final void startGroup(int key, Object objectKey) {
        startNewGroup(key, objectKey == Composer.INSTANCE.getEmpty() ? 0 : 16777216, objectKey, null, null);
    }

    public final void startNodeGroup(int key, Object objectKey, Object node) {
        startNewGroup(key, objectKey == Composer.INSTANCE.getEmpty() ? 8388608 : 25165824, objectKey, null, node);
    }

    public final void startDataGroup(int key, Object objectKey, Object aux) {
        startNewGroup(key, objectKey == Composer.INSTANCE.getEmpty() ? GroupFlagsKt.HasAuxSlotFlag : 50331648, objectKey, aux, null);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void startNewGroup(int key, int flags, Object objectKey, Object aux, Object node) {
        int i = this.parent;
        SlotTableAddressSpace slotTableAddressSpace = this.addressSpace;
        int iGroupAllocate = SlotTableAddresSpaceKt.groupAllocate(slotTableAddressSpace.getGroups(), key, i, flags);
        if (iGroupAllocate < 0) {
            slotTableAddressSpace.growGroups();
            iGroupAllocate = SlotTableAddresSpaceKt.groupAllocate(slotTableAddressSpace.getGroups(), key, i, flags);
        }
        int[] groups = this.addressSpace.getGroups();
        int i2 = this.previousSibling;
        if (i2 != -1) {
            groups[i2 + 1] = iGroupAllocate;
        } else if (i == -1) {
            this.table.setRoot(iGroupAllocate);
        } else {
            groups[i + 3] = iGroupAllocate;
        }
        this.parentStack.push(i);
        this.previousSiblingStack.push(i2);
        this.parent = iGroupAllocate;
        this.previousSibling = -1;
        if (i != -1) {
            int i3 = i + 4;
            groups[i3] = this.nodeCount | (groups[i3] & (-8388608));
        }
        this.nodeCount = 0;
        saveSlotRange(i);
        int i4 = this.slotReserveUsedUpTo;
        this.slotStart = i4;
        this.slotCurrent = i4;
        this.slotEnd = this.slotReserveEnd;
        this.inReservedRange = true;
        if ((flags & 8388608) == 8388608) {
            append(node);
        }
        if ((flags & 16777216) == 16777216) {
            append(objectKey);
        }
        if ((flags & GroupFlagsKt.HasAuxSlotFlag) == 33554432) {
            append(aux);
        }
        int i5 = this.slotCurrent;
        int i6 = this.slotStart;
        if (i5 > i6) {
            groups[iGroupAllocate + 5] = SlotTableAddresSpaceKt.slotRangeFromAddressAndSize(i6, i5 - i6);
        }
        if (!this.recordSourceInformation || i < 0) {
            return;
        }
        this.addressSpace.recordSourceInformation(i, null, iGroupAllocate).reportGroup(this.addressSpace.anchorOfAddress(iGroupAllocate));
    }

    public final int endGroup() {
        int root;
        int i = this.parent;
        int[] groups = this.addressSpace.getGroups();
        int i2 = i + 4;
        groups[i2] = this.nodeCount | (groups[i2] & (-8388608));
        saveSlotRange(i);
        int iPop = this.parentStack.pop();
        this.parent = iPop;
        int iPop2 = this.previousSiblingStack.pop();
        if (iPop2 != -1) {
            root = groups[iPop2 + 1];
        } else if (iPop == -1) {
            root = this.table.getRoot();
        } else {
            root = groups[iPop + 3];
        }
        this.previousSibling = root;
        restoreFromSlotRange(this.parent);
        int i3 = groups[i2];
        int i4 = (i3 & 8388608) != 8388608 ? i3 & GroupFlagsSpec.CHILD_NODE_COUNT_MASK : 1;
        this.nodeCount = (groups[this.parent + 4] & GroupFlagsSpec.CHILD_NODE_COUNT_MASK) + i4;
        return i4;
    }

    public final void append(Object value) {
        int i = this.slotCurrent;
        if (i < this.slotEnd) {
            Object[] objArr = this.slots;
            this.slotCurrent = i + 1;
            objArr[i] = value;
            return;
        }
        slowAppend(value);
    }

    public final void insertAux(Object value) {
        int parent = getParent();
        int[] groups = this.addressSpace.getGroups();
        int i = parent + 4;
        int i2 = groups[i] | GroupFlagsKt.HasAuxSlotFlag;
        groups[i] = i2;
        append(value);
        int iBitCount = this.slotStart + Integer.bitCount(25165824 & i2);
        int i3 = iBitCount + 1;
        if (i3 != this.slotCurrent) {
            Object[] slots = this.addressSpace.getSlots();
            ArraysKt.copyInto(slots, slots, i3, iBitCount, this.slotCurrent - 1);
            slots[iBitCount] = value;
        }
    }

    public final void addFlags(int flags) {
        int[] groups = this.addressSpace.getGroups();
        int i = this.parent;
        int i2 = flags | groups[i + 4];
        groups[i + 4] = i2;
        int iPropagatingFlagsOf = GroupFlagsKt.propagatingFlagsOf(i2);
        if (iPropagatingFlagsOf != 0) {
            SlotTableAddressSpace slotTableAddressSpace = this.addressSpace;
            int i3 = this.parent;
            int[] groups2 = slotTableAddressSpace.getGroups();
            int i4 = groups2[i3 + 2];
            while (i4 > 0) {
                int i5 = i4 + 4;
                int i6 = groups[i5];
                if ((iPropagatingFlagsOf & i6) == iPropagatingFlagsOf) {
                    return;
                }
                groups[i5] = i6 | iPropagatingFlagsOf;
                i4 = groups2[i4 + 2];
            }
            if (i4 != 0) {
                return;
            }
            ComposerKt.composeImmediateRuntimeError("Traversing parent of group not in the slot table: " + i3);
        }
    }

    public final void moveFrom(SlotTableEditor sourceEditor, long sourceHandle) {
        Intrinsics.areEqual(sourceEditor.getAddressSpace(), this.addressSpace);
        long jHandle = sourceEditor.handle();
        sourceEditor.seek(sourceHandle);
        sourceEditor.removeGroup(false);
        sourceEditor.seek(jHandle);
        int group = GroupHandleKt.getGroup(sourceHandle);
        int[] groups = this.addressSpace.getGroups();
        int i = this.parent;
        int i2 = this.previousSibling;
        if (i2 != -1) {
            groups[i2 + 1] = group;
        } else if (i == -1) {
            this.table.setRoot(group);
        } else {
            groups[i + 3] = group;
        }
        groups[group + 2] = i;
        groups[group + 1] = -1;
        this.previousSibling = group;
        int i3 = this.nodeCount;
        int i4 = groups[group + 4];
        this.nodeCount = i3 + ((i4 & 8388608) == 8388608 ? 1 : 8388607 & i4);
        int iPropagatingFlagsOf = GroupFlagsKt.propagatingFlagsOf(i4);
        if (iPropagatingFlagsOf != 0) {
            int[] groups2 = this.addressSpace.getGroups();
            int i5 = i;
            while (i5 > 0) {
                int i6 = i5 + 4;
                int i7 = groups[i6];
                if ((i7 & iPropagatingFlagsOf) == iPropagatingFlagsOf) {
                    return;
                }
                groups[i6] = i7 | iPropagatingFlagsOf;
                i5 = groups2[i5 + 2];
            }
            if (i5 != 0) {
                return;
            }
            ComposerKt.composeImmediateRuntimeError("Traversing parent of group not in the slot table: " + i);
        }
    }

    public final void recordGroupSourceInformation(String sourceInformation) {
        if (this.recordSourceInformation) {
            this.addressSpace.recordSourceInformation(this.parent, sourceInformation, -1);
        }
    }

    public final void recordGrouplessCallSourceInformationStart(int key, String sourceInformation) {
        if (this.recordCallByInformation) {
            this.addressSpace.recordCalledBy(key, groupKey(this.parent));
        }
        if (this.recordSourceInformation) {
            this.addressSpace.recordSourceInformation(this.parent, null, -1).startGrouplessCall(key, sourceInformation, this.slotCurrent - this.slotStart);
        }
    }

    public final void recordGrouplessCallSourceInformationEnd() {
        if (this.recordSourceInformation) {
            this.addressSpace.recordSourceInformation(this.parent, null, -1).endGrouplessCall(this.slotCurrent - this.slotStart);
        }
    }

    public final void close() {
        this.isClosed = true;
    }

    public final SlotTable build() {
        buildEnd();
        close();
        return this.table;
    }

    private final void buildEnd() {
        int i = this.parent;
        if (i != -1) {
            saveSlotRange(i);
        }
        returnReservedSlotRegion();
    }

    private final int saveSlotRange(int group) {
        if (group < 0) {
            return 0;
        }
        int[] groups = this.addressSpace.getGroups();
        int i = this.slotCurrent;
        int i2 = this.slotStart;
        if (i > i2) {
            if (this.inReservedRange) {
                int i3 = i - i2;
                int iSlotRangeFromAddressAndSize = SlotTableAddresSpaceKt.slotRangeFromAddressAndSize(i2, i3);
                if (i3 > 15) {
                    this.addressSpace.recordLargeBlock(i2, i3);
                }
                this.slotReserveUsedUpTo = i;
                groups[group + 5] = iSlotRangeFromAddressAndSize;
                return i3;
            }
            int i4 = i - i2;
            int i5 = this.slotEnd - i2;
            if (i5 != i4) {
                this.addressSpace.resizeSlotRangeAtGroup(group, i5, i4);
            }
            return i4;
        }
        groups[group + 5] = -1;
        return 0;
    }

    private final void restoreFromSlotRange(int group) {
        int i = this.addressSpace.getGroups()[group + 5];
        if (i != -1) {
            SlotTableAddressSpace slotTableAddressSpace = this.addressSpace;
            int i2 = (i & 15) + 1;
            int i3 = i >> 4;
            if (i2 > 15) {
                i2 = slotTableAddressSpace.getLargeSizes().get(i3);
            }
            this.slotStart = i3;
            int i4 = i3 + i2;
            this.slotEnd = i4;
            this.slotCurrent = i4;
            this.inReservedRange = false;
            return;
        }
        int i5 = this.slotReserveUsedUpTo;
        this.slotStart = i5;
        this.slotCurrent = i5;
        this.slotEnd = this.slotReserveEnd;
        this.inReservedRange = true;
    }

    private final void reserveSlotSlotRegion() {
        long jReserveSlots = this.addressSpace.reserveSlots();
        int i = (int) jReserveSlots;
        this.slotReserveStart = i;
        this.slotReserveUsedUpTo = i;
        this.slotReserveEnd = (int) (jReserveSlots >>> 32);
    }

    private final void returnReservedSlotRegion() {
        int i = this.slotReserveStart;
        int i2 = this.slotReserveEnd;
        if (i != i2) {
            this.addressSpace.restoreSlots(this.slotReserveUsedUpTo, i2);
            this.slotReserveStart = 0;
            this.slotReserveUsedUpTo = 0;
            this.slotReserveEnd = 0;
        }
    }

    private final void slowAppend(Object value) {
        int i = this.parent;
        int iSaveSlotRange = saveSlotRange(i);
        returnReservedSlotRegion();
        this.addressSpace.writeSlot(i, iSaveSlotRange, value);
        this.slots = this.addressSpace.getSlots();
        reserveSlotSlotRegion();
        restoreFromSlotRange(i);
    }
}
