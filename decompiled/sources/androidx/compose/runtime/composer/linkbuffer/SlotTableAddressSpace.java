package androidx.compose.runtime.composer.linkbuffer;

import androidx.collection.IntIntMapKt;
import androidx.collection.IntObjectMapKt;
import androidx.collection.IntSetKt;
import androidx.collection.MutableIntIntMap;
import androidx.collection.MutableIntObjectMap;
import androidx.collection.MutableIntSet;
import androidx.collection.MutableScatterMap;
import androidx.collection.ScatterMapKt;
import androidx.compose.runtime.Composer;
import androidx.compose.runtime.ComposerKt;
import androidx.compose.runtime.IntStack;
import java.util.Arrays;
import kotlin.KotlinNothingValueException;
import kotlin.Metadata;
import kotlin.UInt;
import kotlin.Unit;
import kotlin.collections.ArraysKt;
import kotlin.internal.ProgressionUtilKt;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;
import kotlin.ranges.RangesKt;
import org.jivesoftware.smack.packet.Message;
import org.jivesoftware.smackx.blocking.element.BlockContactsIQ;
import org.jivesoftware.smackx.reference.element.ReferenceElement;
import org.jivesoftware.smackx.xdata.FormField;
import org.jivesoftware.smackx.xdatavalidation.packet.ValidateElement;

/* JADX INFO: compiled from: SlotTableAddresSpace.kt */
/* JADX INFO: loaded from: classes.dex */
@Metadata(d1 = {"\u0000\u0090\u0001\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u0015\n\u0000\n\u0002\u0010\u0011\n\u0002\b\u0003\n\u0002\u0010\b\n\u0002\b\r\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\t\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\t\n\u0002\b\t\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\u000e\n\u0002\b\f\n\u0002\u0010\u000b\n\u0002\b\u000b\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u001d\n\u0002\u0018\u0002\n\u0002\b\n\b\u0001\u0018\u0000 \u008c\u00012\u00020\u0001:\u0002\u008c\u0001B\u001f\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u000e\u0010\u0004\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010\u00010\u0005¢\u0006\u0004\b\u0006\u0010\u0007B\u001d\b\u0016\u0012\b\b\u0001\u0010\b\u001a\u00020\t\u0012\b\b\u0001\u0010\n\u001a\u00020\t¢\u0006\u0004\b\u0006\u0010\u000bB\t\b\u0016¢\u0006\u0004\b\u0006\u0010\fJ\u0006\u0010/\u001a\u000200J-\u00101\u001a\u00060\tj\u0002`22\u0006\u00103\u001a\u00020\t2\n\u00104\u001a\u00060\tj\u0002`22\n\u00105\u001a\u00060\tj\u0002`6H\u0086\bJ\u0012\u00107\u001a\u0002002\n\u00108\u001a\u00060\tj\u0002`2J\u0014\u00109\u001a\u0002002\n\u00108\u001a\u00060\tj\u0002`2H\u0002J\u0014\u0010:\u001a\u0002002\n\u00108\u001a\u00060\tj\u0002`2H\u0002J\u0006\u0010;\u001a\u00020<J\u0016\u0010=\u001a\u0002002\u0006\u0010>\u001a\u00020\t2\u0006\u0010?\u001a\u00020\tJ\u0016\u0010@\u001a\u0002002\u0006\u00108\u001a\u00020\t2\u0006\u0010A\u001a\u00020\tJ\u001c\u0010B\u001a\u0004\u0018\u00010\u00012\n\u0010C\u001a\u00060\tj\u0002`22\u0006\u0010D\u001a\u00020\tJ(\u0010E\u001a\u00060\tj\u0002`F2\n\u0010C\u001a\u00060\tj\u0002`22\u0006\u0010D\u001a\u00020\t2\b\u0010G\u001a\u0004\u0018\u00010\u0001J\u0014\u0010H\u001a\u0004\u0018\u00010 2\n\u0010C\u001a\u00060\tj\u0002`2J(\u0010I\u001a\u00020 2\n\u00104\u001a\u00060\tj\u0002`22\b\u0010J\u001a\u0004\u0018\u00010K2\n\u0010C\u001a\u00060\tj\u0002`2J\u0016\u0010L\u001a\u0002002\u0006\u00103\u001a\u00020\t2\u0006\u0010M\u001a\u00020\tJ\u0010\u0010N\u001a\u00020\t2\u0006\u0010A\u001a\u00020\tH\u0002J&\u0010O\u001a\u00060\tj\u0002`F2\n\u0010C\u001a\u00060\tj\u0002`22\u0006\u0010A\u001a\u00020\t2\u0006\u0010P\u001a\u00020\tJ\u001e\u0010O\u001a\u00060\tj\u0002`F2\n\u0010C\u001a\u00060\tj\u0002`22\u0006\u0010P\u001a\u00020\tJ\u001e\u0010Q\u001a\u00060\tj\u0002`22\u0006\u0010R\u001a\u00020\u00002\n\u0010S\u001a\u00060\tj\u0002`2J\u001e\u0010T\u001a\u0002002\n\u0010C\u001a\u00060\tj\u0002`22\n\u0010U\u001a\u00060\tj\u0002`2J\u0012\u0010V\u001a\u00020\u001d2\n\u00108\u001a\u00060\tj\u0002`2J\u000e\u0010W\u001a\u00020X2\u0006\u0010Y\u001a\u00020\u001dJ(\u0010Z\u001a\u0004\u0018\u00010\u001d2\u0006\u0010R\u001a\u00020\u00002\n\u0010[\u001a\u00060\tj\u0002`22\n\u0010\\\u001a\u00060\tj\u0002`2J\u0018\u0010]\u001a\u0002002\u0006\u0010R\u001a\u00020\u00002\b\u0010Y\u001a\u0004\u0018\u00010\u001dJ%\u0010^\u001a\u00020\t2\n\u0010_\u001a\u00060\tj\u0002`22\n\u0010`\u001a\u00060\tj\u0002`2H\u0000¢\u0006\u0002\baJA\u0010b\u001a\u0002002\n\u0010C\u001a\u00060\tj\u0002`22%\u0010c\u001a!\u0012\u0017\u0012\u00150\tj\u0002`2¢\u0006\f\be\u0012\b\bf\u0012\u0004\b\b(C\u0012\u0004\u0012\u0002000dH\u0080\b¢\u0006\u0002\bgJA\u0010h\u001a\u0002002\n\u0010C\u001a\u00060\tj\u0002`22%\u0010c\u001a!\u0012\u0017\u0012\u00150\tj\u0002`2¢\u0006\f\be\u0012\b\bf\u0012\u0004\b\b(C\u0012\u0004\u0012\u0002000dH\u0080\b¢\u0006\u0002\biJA\u0010j\u001a\u0002002\n\u00104\u001a\u00060\tj\u0002`22%\u0010c\u001a!\u0012\u0017\u0012\u00150\tj\u0002`2¢\u0006\f\be\u0012\b\bf\u0012\u0004\b\b(C\u0012\u0004\u0012\u0002000dH\u0080\b¢\u0006\u0002\bkJA\u0010l\u001a\u0002002\n\u0010C\u001a\u00060\tj\u0002`22%\u0010c\u001a!\u0012\u0017\u0012\u00150\tj\u0002`2¢\u0006\f\be\u0012\b\bf\u0012\u0004\b\b(C\u0012\u0004\u0012\u0002000dH\u0080\b¢\u0006\u0002\bmJK\u0010n\u001a\u0002002\n\u0010C\u001a\u00060\tj\u0002`22\b\b\u0002\u0010o\u001a\u00020X2%\u0010c\u001a!\u0012\u0017\u0012\u00150\tj\u0002`2¢\u0006\f\be\u0012\b\bf\u0012\u0004\b\b(C\u0012\u0004\u0012\u0002000dH\u0080\b¢\u0006\u0002\bpJK\u0010q\u001a\u0002002\n\u0010>\u001a\u00060\tj\u0002`22\b\b\u0002\u0010r\u001a\u00020X2%\u0010c\u001a!\u0012\u0017\u0012\u00150\tj\u0002`2¢\u0006\f\be\u0012\b\bf\u0012\u0004\b\b(C\u0012\u0004\u0012\u0002000dH\u0080\b¢\u0006\u0002\bsJK\u0010t\u001a\u0002002\n\u0010>\u001a\u00060\tj\u0002`22\b\b\u0002\u0010r\u001a\u00020X2%\u0010c\u001a!\u0012\u0017\u0012\u00150\tj\u0002`2¢\u0006\f\be\u0012\b\bf\u0012\u0004\b\b(C\u0012\u0004\u0012\u00020X0dH\u0080\b¢\u0006\u0002\buJA\u0010v\u001a\u0002002\n\u00104\u001a\u00060\tj\u0002`22%\u0010c\u001a!\u0012\u0017\u0012\u00150\tj\u0002`2¢\u0006\f\be\u0012\b\bf\u0012\u0004\b\b(C\u0012\u0004\u0012\u0002000dH\u0080\b¢\u0006\u0002\bwJ\u0015\u0010x\u001a\u00020X2\n\u0010C\u001a\u00060\tj\u0002`2H\u0086\u0002J$\u0010y\u001a\u00020\t2\n\u0010C\u001a\u00060\tj\u0002`22\u0006\u0010z\u001a\u00020\t2\u0006\u0010P\u001a\u00020\tH\u0002J(\u0010{\u001a\u00060\tj\u0002`F2\n\u0010|\u001a\u00060\tj\u0002`F2\u0006\u0010z\u001a\u00020\t2\u0006\u0010P\u001a\u00020\tH\u0002J(\u0010}\u001a\u00060\tj\u0002`F2\n\u0010C\u001a\u00060\tj\u0002`22\u0006\u0010z\u001a\u00020\t2\u0006\u0010P\u001a\u00020\tH\u0002J\u0015\u0010~\u001a\u00020\t2\n\u0010\u007f\u001a\u00060\tj\u0002`FH\u0086\bJ[\u0010\u0080\u0001\u001a\u0003H\u0081\u0001\"\u0005\b\u0000\u0010\u0081\u00012\u0006\u0010\u007f\u001a\u00020\t29\u0010\u0082\u0001\u001a4\u0012\u0013\u0012\u00110\t¢\u0006\f\be\u0012\b\bf\u0012\u0004\b\b(8\u0012\u0013\u0012\u00110\t¢\u0006\f\be\u0012\b\bf\u0012\u0004\b\b(A\u0012\u0005\u0012\u0003H\u0081\u00010\u0083\u0001H\u0086\b¢\u0006\u0003\u0010\u0084\u0001J\u0015\u0010\u0085\u0001\u001a\u0002002\n\u0010\u007f\u001a\u00060\tj\u0002`FH\u0002J\u0019\u0010\u0086\u0001\u001a\u0002002\u0006\u00108\u001a\u00020\t2\u0006\u0010A\u001a\u00020\tH\u0002J\t\u0010\u0087\u0001\u001a\u000200H\u0002J\u0007\u0010\u0088\u0001\u001a\u00020KJ\u0012\u0010\u0089\u0001\u001a\u0002002\u0007\u0010\u008a\u0001\u001a\u00020\tH\u0002J\r\u0010\u008b\u0001\u001a\u000200*\u00020\u0003H\u0002R\u001a\u0010\u0002\u001a\u00020\u0003X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\r\u0010\u000e\"\u0004\b\u000f\u0010\u0010R$\u0010\u0004\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010\u00010\u0005X\u0086\u000e¢\u0006\u0010\n\u0002\u0010\u0015\u001a\u0004\b\u0011\u0010\u0012\"\u0004\b\u0013\u0010\u0014R\u0010\u0010\u0016\u001a\u0004\u0018\u00010\u0017X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0018\u001a\u00020\tX\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0019\u001a\u00020\tX\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u001a\u001a\u00020\tX\u0082\u000e¢\u0006\u0002\n\u0000R\u0014\u0010\u001b\u001a\b\u0012\u0004\u0012\u00020\u001d0\u001cX\u0082\u000e¢\u0006\u0002\n\u0000R2\u0010\u001e\u001a\u0010\u0012\u0004\u0012\u00020\u001d\u0012\u0004\u0012\u00020 \u0018\u00010\u001f8\u0006@\u0006X\u0087\u000e¢\u0006\u0014\n\u0000\u0012\u0004\b!\u0010\f\u001a\u0004\b\"\u0010#\"\u0004\b$\u0010%R\u0014\u0010&\u001a\u00020\u00178BX\u0082\u0004¢\u0006\u0006\u001a\u0004\b'\u0010(R\"\u0010)\u001a\n\u0012\u0004\u0012\u00020*\u0018\u00010\u001cX\u0080\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b+\u0010,\"\u0004\b-\u0010.¨\u0006\u008d\u0001"}, d2 = {"Landroidx/compose/runtime/composer/linkbuffer/SlotTableAddressSpace;", "", "groups", "", "slots", "", "<init>", "([I[Ljava/lang/Object;)V", "groupsCapacity", "", "slotsCapacity", "(II)V", "()V", "getGroups", "()[I", "setGroups", "([I)V", "getSlots", "()[Ljava/lang/Object;", "setSlots", "([Ljava/lang/Object;)V", "[Ljava/lang/Object;", "_largeSizes", "Landroidx/collection/MutableIntIntMap;", "unallocatedStart", "unallocatedEnd", "freeSlotCount", "anchors", "Landroidx/collection/MutableIntObjectMap;", "Landroidx/compose/runtime/composer/linkbuffer/LinkAnchor;", "sourceInformationMap", "Landroidx/collection/MutableScatterMap;", "Landroidx/compose/runtime/composer/linkbuffer/LinkGroupSourceInformation;", "getSourceInformationMap$annotations", "getSourceInformationMap", "()Landroidx/collection/MutableScatterMap;", "setSourceInformationMap", "(Landroidx/collection/MutableScatterMap;)V", "largeSizes", "getLargeSizes", "()Landroidx/collection/MutableIntIntMap;", "calledByMap", "Landroidx/collection/MutableIntSet;", "getCalledByMap$runtime", "()Landroidx/collection/MutableIntObjectMap;", "setCalledByMap$runtime", "(Landroidx/collection/MutableIntObjectMap;)V", ValidateElement.ELEMENT, "", "allocateGroup", "Landroidx/compose/runtime/composer/linkbuffer/GroupAddress;", "key", Message.Thread.PARENT_ATTRIBUTE_NAME, "flags", "Landroidx/compose/runtime/composer/linkbuffer/GroupFlags;", "freeGroupTree", "address", "removeSourceInformation", "freeGroup", "reserveSlots", "", "restoreSlots", "start", "end", "recordLargeBlock", "size", "readSlot", "group", "offset", "writeSlot", "Landroidx/compose/runtime/composer/linkbuffer/SlotRange;", "value", "sourceInformationOf", "recordSourceInformation", "sourceInformation", "", "recordCalledBy", "parentKey", "allocateSlots", "resizeSlotRangeAtGroup", "newSize", "copyTreeFrom", "sourceSpace", "sourceAddress", "recordMovedSourceInformation", "previous", "anchorOfAddress", "ownsAnchor", "", ReferenceElement.ATTR_ANCHOR, "moveAnchorFrom", "oldAddress", "newAddress", "moveSourceInformation", "distanceFrom", "groupAddress", "common", "distanceFrom$runtime", "traverseSiblings", "visit", "Lkotlin/Function1;", "Lkotlin/ParameterName;", "name", "traverseSiblings$runtime", "traverseSiblingsAfter", "traverseSiblingsAfter$runtime", "traverseChildren", "traverseChildren$runtime", "traverseParents", "traverseParents$runtime", "traverseGroupAndParents", "includeGroup", "traverseGroupAndParents$runtime", "traverseGroup", "includeSiblingsOfStartGroup", "traverseGroup$runtime", "traverseGroupPartially", "traverseGroupPartially$runtime", "traverseAllChildren", "traverseAllChildren$runtime", "contains", "growSlotRangeAtGroup", "currentSize", "shrinkSlotRange", "range", "shrinkSlotRangeAtGroup", "slotSize", "slotRange", "slotAddressAndSize", "R", BlockContactsIQ.ELEMENT, "Lkotlin/Function2;", "(ILkotlin/jvm/functions/Function2;)Ljava/lang/Object;", "freeSlots", "freeSlotsAt", "growGroups", "toDebugString", "compactAndMaybeGrow", FormField.Required.ELEMENT, "validateSlotReferences", "Companion", "runtime"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final class SlotTableAddressSpace {
    private MutableIntIntMap _largeSizes;
    private MutableIntObjectMap<LinkAnchor> anchors;
    private MutableIntObjectMap<MutableIntSet> calledByMap;
    private int freeSlotCount;
    private int[] groups;
    private Object[] slots;
    private MutableScatterMap<LinkAnchor, LinkGroupSourceInformation> sourceInformationMap;
    private int unallocatedEnd;
    private int unallocatedStart;
    public static final int $stable = 8;
    private static final int[] EmptyGroupData = SlotTableAddresSpaceKt.newGroupsArray(6);
    private static final Object[] EmptySlotData = SlotTableAddresSpaceKt.newSlotsArray(0);

    public static /* synthetic */ void getSourceInformationMap$annotations() {
    }

    public SlotTableAddressSpace(int[] iArr, Object[] objArr) {
        this.groups = iArr;
        this.slots = objArr;
        this.unallocatedEnd = objArr.length;
        this.anchors = IntObjectMapKt.mutableIntObjectMapOf();
    }

    public final int[] getGroups() {
        return this.groups;
    }

    public final void setGroups(int[] iArr) {
        this.groups = iArr;
    }

    public final Object[] getSlots() {
        return this.slots;
    }

    public final void setSlots(Object[] objArr) {
        this.slots = objArr;
    }

    public final MutableScatterMap<LinkAnchor, LinkGroupSourceInformation> getSourceInformationMap() {
        return this.sourceInformationMap;
    }

    public final void setSourceInformationMap(MutableScatterMap<LinkAnchor, LinkGroupSourceInformation> mutableScatterMap) {
        this.sourceInformationMap = mutableScatterMap;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final MutableIntIntMap getLargeSizes() {
        MutableIntIntMap mutableIntIntMap = this._largeSizes;
        if (mutableIntIntMap != null) {
            return mutableIntIntMap;
        }
        MutableIntIntMap mutableIntIntMapMutableIntIntMapOf = IntIntMapKt.mutableIntIntMapOf();
        this._largeSizes = mutableIntIntMapMutableIntIntMapOf;
        return mutableIntIntMapMutableIntIntMapOf;
    }

    public SlotTableAddressSpace(int i, int i2) {
        this(SlotTableAddresSpaceKt.newGroupsArray(i), SlotTableAddresSpaceKt.newSlotsArray(i2));
    }

    public SlotTableAddressSpace() {
        this(EmptyGroupData, EmptySlotData);
        int[] iArr = this.groups;
        if (iArr[0] == 0 && iArr[1] == -1 && iArr[2] == 0 && iArr[3] == 6 && iArr[4] == 0) {
            int i = iArr[5];
        }
    }

    public final MutableIntObjectMap<MutableIntSet> getCalledByMap$runtime() {
        return this.calledByMap;
    }

    public final void setCalledByMap$runtime(MutableIntObjectMap<MutableIntSet> mutableIntObjectMap) {
        this.calledByMap = mutableIntObjectMap;
    }

    public final void validate() {
        SlotTableAddresSpaceKt.validateFreeList(this.groups);
        validateSlotReferences(this.groups);
    }

    public final int allocateGroup(int key, int parent, int flags) {
        int iGroupAllocate = SlotTableAddresSpaceKt.groupAllocate(getGroups(), key, parent, flags);
        if (iGroupAllocate >= 0) {
            return iGroupAllocate;
        }
        growGroups();
        return SlotTableAddresSpaceKt.groupAllocate(getGroups(), key, parent, flags);
    }

    public final void freeGroupTree(int address) {
        removeSourceInformation(address);
        freeGroup(address);
    }

    private final void removeSourceInformation(int address) {
        LinkAnchor linkAnchor;
        LinkAnchor linkAnchor2;
        LinkGroupSourceInformation linkGroupSourceInformation;
        MutableScatterMap<LinkAnchor, LinkGroupSourceInformation> mutableScatterMap = this.sourceInformationMap;
        if (mutableScatterMap == null || (linkAnchor = this.anchors.get(address)) == null || (linkAnchor2 = this.anchors.get(this.groups[address + 2])) == null || (linkGroupSourceInformation = mutableScatterMap.get(linkAnchor2)) == null) {
            return;
        }
        linkGroupSourceInformation.removeGroup(linkAnchor);
    }

    private final void freeGroup(int address) {
        int[] iArr = this.groups;
        if (address + 6 > iArr.length) {
            return;
        }
        int i = address + 4;
        if ((iArr[i] & GroupFlagsSpec.CHILD_NODE_COUNT_MASK) == 8388607) {
            ComposerKt.composeImmediateRuntimeError("Recursive loop in group structure detected at " + address);
        }
        LinkAnchor linkAnchor = this.anchors.get(address);
        if (linkAnchor != null) {
            linkAnchor.setAddress(-1);
            this.anchors.remove(address);
            MutableScatterMap<LinkAnchor, LinkGroupSourceInformation> mutableScatterMap = this.sourceInformationMap;
            if (mutableScatterMap != null) {
                mutableScatterMap.remove(linkAnchor);
            }
        }
        int i2 = address + 5;
        freeSlots(iArr[i2]);
        iArr[i2] = -1;
        int i3 = iArr[address + 3];
        while (i3 != -1) {
            if (i3 + 6 > iArr.length) {
                return;
            }
            int i4 = iArr[i3 + 1];
            freeGroup(i3);
            i3 = i4;
        }
        iArr[address + 1] = iArr[1];
        iArr[address + 2] = -1;
        iArr[1] = address;
        iArr[i] = 8388607;
    }

    public final long reserveSlots() {
        int i = this.unallocatedStart;
        int i2 = this.unallocatedEnd;
        this.unallocatedStart = i2;
        return ((((long) UInt.m12488constructorimpl(i2)) & 4294967295L) << 32) | (((long) UInt.m12488constructorimpl(i)) & 4294967295L);
    }

    public final void restoreSlots(int start, int end) {
        if (end == this.unallocatedEnd) {
            this.unallocatedStart = start;
        }
    }

    public final void recordLargeBlock(int address, int size) {
        getLargeSizes().set(address, size);
    }

    public final Object readSlot(int group, int offset) {
        return this.slots[(this.groups[group + 5] >> 4) + offset];
    }

    public final int writeSlot(int group, int offset, Object value) {
        int iAllocateSlots;
        int[] iArr = this.groups;
        int i = group + 5;
        int iGrowSlotRangeAtGroup = iArr[i];
        if (iGrowSlotRangeAtGroup == -1) {
            iAllocateSlots = allocateSlots(offset + 1);
            iArr[i] = iAllocateSlots;
        } else {
            int i2 = (iGrowSlotRangeAtGroup & 15) + 1;
            int i3 = iGrowSlotRangeAtGroup >> 4;
            if (i2 > 15) {
                i2 = getLargeSizes().get(i3);
            }
            if (offset >= i2) {
                iGrowSlotRangeAtGroup = growSlotRangeAtGroup(group, i2, offset + 1);
            }
            iAllocateSlots = iGrowSlotRangeAtGroup;
        }
        this.slots[(iAllocateSlots >> 4) + offset] = value;
        return iAllocateSlots;
    }

    public final LinkGroupSourceInformation sourceInformationOf(int group) {
        LinkAnchor linkAnchor;
        MutableScatterMap<LinkAnchor, LinkGroupSourceInformation> mutableScatterMap = this.sourceInformationMap;
        if (mutableScatterMap == null || (linkAnchor = this.anchors.get(group)) == null) {
            return null;
        }
        return mutableScatterMap.get(linkAnchor);
    }

    public final LinkGroupSourceInformation recordSourceInformation(int parent, String sourceInformation, int group) {
        MutableScatterMap<LinkAnchor, LinkGroupSourceInformation> mutableScatterMapMutableScatterMapOf = this.sourceInformationMap;
        if (mutableScatterMapMutableScatterMapOf == null) {
            mutableScatterMapMutableScatterMapOf = ScatterMapKt.mutableScatterMapOf();
            this.sourceInformationMap = mutableScatterMapMutableScatterMapOf;
        }
        LinkAnchor linkAnchorAnchorOfAddress = anchorOfAddress(parent);
        LinkGroupSourceInformation linkGroupSourceInformation = mutableScatterMapMutableScatterMapOf.get(linkAnchorAnchorOfAddress);
        if (linkGroupSourceInformation == null) {
            linkGroupSourceInformation = new LinkGroupSourceInformation(0, sourceInformation, 0);
            if (sourceInformation == null) {
                int i = this.groups[parent + 3];
                while (i != group && i != -1) {
                    linkGroupSourceInformation.reportGroup(anchorOfAddress(i));
                    i = this.groups[i + 1];
                }
            }
            mutableScatterMapMutableScatterMapOf.set(linkAnchorAnchorOfAddress, linkGroupSourceInformation);
        }
        return linkGroupSourceInformation;
    }

    public final void recordCalledBy(int key, int parentKey) {
        MutableIntObjectMap<MutableIntSet> mutableIntObjectMapMutableIntObjectMapOf = this.calledByMap;
        if (mutableIntObjectMapMutableIntObjectMapOf == null) {
            mutableIntObjectMapMutableIntObjectMapOf = IntObjectMapKt.mutableIntObjectMapOf();
            this.calledByMap = mutableIntObjectMapMutableIntObjectMapOf;
        }
        MutableIntSet mutableIntSetMutableIntSetOf = mutableIntObjectMapMutableIntObjectMapOf.get(key);
        if (mutableIntSetMutableIntSetOf == null) {
            mutableIntSetMutableIntSetOf = IntSetKt.mutableIntSetOf();
            mutableIntObjectMapMutableIntObjectMapOf.set(key, mutableIntSetMutableIntSetOf);
        }
        mutableIntSetMutableIntSetOf.add(parentKey);
    }

    private final int allocateSlots(int size) {
        int i = this.unallocatedStart;
        int i2 = i + size;
        if (i2 <= this.unallocatedEnd) {
            this.unallocatedStart = i2;
            if (size > 15) {
                getLargeSizes().set(i, size);
            }
            ArraysKt.fill(this.slots, Composer.INSTANCE.getEmpty(), i, i2);
            return SlotTableAddresSpaceKt.slotRangeFromAddressAndSize(i, size);
        }
        compactAndMaybeGrow(size);
        int i3 = this.unallocatedStart;
        int i4 = i3 + size;
        if (i4 <= this.unallocatedEnd) {
            this.unallocatedStart = i4;
            if (size > 15) {
                getLargeSizes().set(i3, size);
            }
            ArraysKt.fill(this.slots, Composer.INSTANCE.getEmpty(), i3, i4);
            return SlotTableAddresSpaceKt.slotRangeFromAddressAndSize(i3, size);
        }
        ComposerKt.composeRuntimeError("compactAndMaybeGrow did not grow enough");
        throw new KotlinNothingValueException();
    }

    public final int resizeSlotRangeAtGroup(int group, int size, int newSize) {
        if (newSize == size) {
            return this.groups[group + 5];
        }
        if (newSize > size) {
            return growSlotRangeAtGroup(group, size, newSize);
        }
        return shrinkSlotRangeAtGroup(group, size, newSize);
    }

    public final int resizeSlotRangeAtGroup(int group, int newSize) {
        int i;
        int i2 = this.groups[group + 5];
        if (i2 == -1 && newSize == 0) {
            return i2;
        }
        if (i2 == -1) {
            i = 0;
        } else {
            int i3 = (i2 & 15) + 1;
            i = i3 > 15 ? getLargeSizes().get(i2 >> 4) : i3;
        }
        return resizeSlotRangeAtGroup(group, i, newSize);
    }

    private static final int copyTreeFrom$copyGroup(SlotTableAddressSpace slotTableAddressSpace, SlotTableAddressSpace slotTableAddressSpace2, int i, int i2) {
        int[] iArr = slotTableAddressSpace.groups;
        Object[] objArr = slotTableAddressSpace.slots;
        int i3 = iArr[i2 + 4];
        int i4 = iArr[i2];
        int iGroupAllocate = SlotTableAddresSpaceKt.groupAllocate(slotTableAddressSpace2.getGroups(), i4, i, i3);
        if (iGroupAllocate < 0) {
            slotTableAddressSpace2.growGroups();
            iGroupAllocate = SlotTableAddresSpaceKt.groupAllocate(slotTableAddressSpace2.getGroups(), i4, i, i3);
        }
        slotTableAddressSpace2.moveSourceInformation(slotTableAddressSpace, slotTableAddressSpace2.moveAnchorFrom(slotTableAddressSpace, i2, iGroupAllocate));
        int i5 = iArr[i2 + 5];
        if (i5 != -1) {
            int i6 = (i5 & 15) + 1;
            int i7 = i5 >> 4;
            if (i6 > 15) {
                i6 = slotTableAddressSpace.getLargeSizes().get(i7);
            }
            int iAllocateSlots = slotTableAddressSpace2.allocateSlots(i6);
            ArraysKt.copyInto(objArr, slotTableAddressSpace2.slots, iAllocateSlots >> 4, i7, i6 + i7);
            slotTableAddressSpace2.groups[iGroupAllocate + 5] = iAllocateSlots;
        }
        int i8 = iArr[i2 + 3];
        int i9 = -1;
        while (i8 != -1) {
            int iCopyTreeFrom$copyGroup = copyTreeFrom$copyGroup(slotTableAddressSpace, slotTableAddressSpace2, iGroupAllocate, i8);
            if (i9 == -1) {
                slotTableAddressSpace2.groups[iGroupAllocate + 3] = iCopyTreeFrom$copyGroup;
            } else {
                slotTableAddressSpace2.groups[i9 + 1] = iCopyTreeFrom$copyGroup;
            }
            i8 = iArr[i8 + 1];
            i9 = iCopyTreeFrom$copyGroup;
        }
        return iGroupAllocate;
    }

    public final int copyTreeFrom(SlotTableAddressSpace sourceSpace, int sourceAddress) {
        return copyTreeFrom$copyGroup(sourceSpace, this, -1, sourceAddress);
    }

    public final void recordMovedSourceInformation(int group, int previous) {
        LinkGroupSourceInformation linkGroupSourceInformation;
        MutableScatterMap<LinkAnchor, LinkGroupSourceInformation> mutableScatterMap = this.sourceInformationMap;
        if (mutableScatterMap == null) {
            return;
        }
        LinkAnchor linkAnchor = this.anchors.get(this.groups[group + 2]);
        if (linkAnchor == null || (linkGroupSourceInformation = mutableScatterMap.get(linkAnchor)) == null) {
            return;
        }
        linkGroupSourceInformation.addGroupAfter(previous != -1 ? anchorOfAddress(previous) : null, anchorOfAddress(group));
    }

    public final LinkAnchor anchorOfAddress(int address) {
        if (address == -1) {
            return LinkAnchorKt.getNullAnchor();
        }
        if (address == 0) {
            return LinkAnchorKt.getLazyAnchor();
        }
        if (!(address >= 0)) {
            ComposerKt.composeImmediateRuntimeError("Invalid anchor address " + address);
        }
        MutableIntObjectMap<LinkAnchor> mutableIntObjectMap = this.anchors;
        LinkAnchor linkAnchor = mutableIntObjectMap.get(address);
        if (linkAnchor == null) {
            linkAnchor = new LinkAnchor(address);
            mutableIntObjectMap.set(address, linkAnchor);
        }
        return linkAnchor;
    }

    public final boolean ownsAnchor(LinkAnchor anchor) {
        return this.anchors.get(anchor.getAddress()) == anchor;
    }

    public final LinkAnchor moveAnchorFrom(SlotTableAddressSpace sourceSpace, int oldAddress, int newAddress) {
        this.anchors.containsKey(newAddress);
        LinkAnchor linkAnchorRemove = sourceSpace.anchors.remove(oldAddress);
        if (linkAnchorRemove == null) {
            return null;
        }
        linkAnchorRemove.setAddress(newAddress);
        this.anchors.set(newAddress, linkAnchorRemove);
        return linkAnchorRemove;
    }

    public final void moveSourceInformation(SlotTableAddressSpace sourceSpace, LinkAnchor anchor) {
        MutableScatterMap<LinkAnchor, LinkGroupSourceInformation> mutableScatterMap;
        LinkGroupSourceInformation linkGroupSourceInformation;
        if (anchor == null || (mutableScatterMap = sourceSpace.sourceInformationMap) == null || (linkGroupSourceInformation = mutableScatterMap.get(anchor)) == null) {
            return;
        }
        MutableScatterMap<LinkAnchor, LinkGroupSourceInformation> mutableScatterMapMutableScatterMapOf = this.sourceInformationMap;
        if (mutableScatterMapMutableScatterMapOf == null) {
            mutableScatterMapMutableScatterMapOf = ScatterMapKt.mutableScatterMapOf();
            this.sourceInformationMap = mutableScatterMapMutableScatterMapOf;
        } else {
            mutableScatterMapMutableScatterMapOf.contains(anchor);
        }
        mutableScatterMapMutableScatterMapOf.set(anchor, linkGroupSourceInformation);
        mutableScatterMap.remove(anchor);
    }

    public final int distanceFrom$runtime(int groupAddress, int common) {
        int[] iArr = this.groups;
        int i = 0;
        while (groupAddress != common && groupAddress >= 0) {
            i++;
            groupAddress = iArr[groupAddress + 2];
        }
        return i;
    }

    public final void traverseSiblings$runtime(int group, Function1<? super Integer, Unit> visit) {
        int[] groups = getGroups();
        while (group >= 0) {
            visit.invoke(Integer.valueOf(group));
            group = groups[group + 1];
        }
    }

    public final void traverseSiblingsAfter$runtime(int group, Function1<? super Integer, Unit> visit) {
        int[] groups = getGroups();
        for (int i = groups[group + 1]; i >= 0; i = groups[i + 1]) {
            visit.invoke(Integer.valueOf(i));
        }
    }

    public final void traverseChildren$runtime(int parent, Function1<? super Integer, Unit> visit) {
        int[] groups = getGroups();
        for (int i = groups[parent + 3]; i > 0; i = groups[i + 1]) {
            visit.invoke(Integer.valueOf(i));
        }
    }

    public static /* synthetic */ void traverseGroupAndParents$runtime$default(SlotTableAddressSpace slotTableAddressSpace, int i, boolean z, Function1 function1, int i2, Object obj) {
        if ((i2 & 2) != 0) {
            z = true;
        }
        int[] groups = slotTableAddressSpace.getGroups();
        int i3 = !z ? groups[i + 2] : i;
        while (i3 > 0) {
            function1.invoke(Integer.valueOf(i3));
            i3 = groups[i3 + 2];
        }
        if (i3 != 0) {
            return;
        }
        ComposerKt.composeImmediateRuntimeError("Traversing parent of group not in the slot table: " + i);
    }

    public final void traverseGroupAndParents$runtime(int group, boolean includeGroup, Function1<? super Integer, Unit> visit) {
        int[] groups = getGroups();
        int i = !includeGroup ? groups[group + 2] : group;
        while (i > 0) {
            visit.invoke(Integer.valueOf(i));
            i = groups[i + 2];
        }
        if (i != 0) {
            return;
        }
        ComposerKt.composeImmediateRuntimeError("Traversing parent of group not in the slot table: " + group);
    }

    public static /* synthetic */ void traverseGroup$runtime$default(SlotTableAddressSpace slotTableAddressSpace, int i, boolean z, Function1 function1, int i2, Object obj) {
        int i3;
        if ((i2 & 2) != 0) {
            z = false;
        }
        if (i < 0) {
            return;
        }
        IntStack intStack = new IntStack();
        int[] groups = slotTableAddressSpace.getGroups();
        int iPop = i;
        while (true) {
            function1.invoke(Integer.valueOf(iPop));
            if ((iPop != i || z) && (i3 = groups[iPop + 1]) >= 0) {
                intStack.push(i3);
            }
            iPop = groups[iPop + 3];
            if (iPop < 0) {
                if (intStack.tos == 0) {
                    return;
                } else {
                    iPop = intStack.pop();
                }
            }
        }
    }

    public final void traverseGroup$runtime(int start, boolean includeSiblingsOfStartGroup, Function1<? super Integer, Unit> visit) {
        int i;
        if (start < 0) {
            return;
        }
        IntStack intStack = new IntStack();
        int[] groups = getGroups();
        int iPop = start;
        while (true) {
            visit.invoke(Integer.valueOf(iPop));
            if ((iPop != start || includeSiblingsOfStartGroup) && (i = groups[iPop + 1]) >= 0) {
                intStack.push(i);
            }
            iPop = groups[iPop + 3];
            if (iPop < 0) {
                if (intStack.tos == 0) {
                    return;
                } else {
                    iPop = intStack.pop();
                }
            }
        }
    }

    public static /* synthetic */ void traverseGroupPartially$runtime$default(SlotTableAddressSpace slotTableAddressSpace, int i, boolean z, Function1 function1, int i2, Object obj) {
        int i3;
        if ((i2 & 2) != 0) {
            z = false;
        }
        if (i < 0) {
            return;
        }
        IntStack intStack = new IntStack();
        int[] groups = slotTableAddressSpace.getGroups();
        int iPop = i;
        while (true) {
            boolean zBooleanValue = ((Boolean) function1.invoke(Integer.valueOf(iPop))).booleanValue();
            if ((iPop != i || z) && (i3 = groups[iPop + 1]) >= 0) {
                intStack.push(i3);
            }
            iPop = groups[iPop + 3];
            if (!zBooleanValue || iPop < 0) {
                if (intStack.tos == 0) {
                    return;
                } else {
                    iPop = intStack.pop();
                }
            }
        }
    }

    public final void traverseGroupPartially$runtime(int start, boolean includeSiblingsOfStartGroup, Function1<? super Integer, Boolean> visit) {
        int i;
        if (start < 0) {
            return;
        }
        IntStack intStack = new IntStack();
        int[] groups = getGroups();
        int iPop = start;
        while (true) {
            boolean zBooleanValue = visit.invoke(Integer.valueOf(iPop)).booleanValue();
            if ((iPop != start || includeSiblingsOfStartGroup) && (i = groups[iPop + 1]) >= 0) {
                intStack.push(i);
            }
            iPop = groups[iPop + 3];
            if (!zBooleanValue || iPop < 0) {
                if (intStack.tos == 0) {
                    return;
                } else {
                    iPop = intStack.pop();
                }
            }
        }
    }

    public final void traverseAllChildren$runtime(int parent, Function1<? super Integer, Unit> visit) {
        int iPop;
        if (parent < 0 || (iPop = getGroups()[parent + 3]) < 0) {
            return;
        }
        IntStack intStack = new IntStack();
        int[] groups = getGroups();
        while (true) {
            visit.invoke(Integer.valueOf(iPop));
            int i = groups[iPop + 1];
            if (i >= 0) {
                intStack.push(i);
            }
            iPop = groups[iPop + 3];
            if (iPop < 0) {
                if (intStack.tos == 0) {
                    return;
                } else {
                    iPop = intStack.pop();
                }
            }
        }
    }

    public final boolean contains(int group) {
        return group > 0 && group < this.groups[3];
    }

    private final int growSlotRangeAtGroup(int group, int currentSize, int newSize) {
        int i;
        int i2 = this.unallocatedStart;
        int i3 = this.unallocatedEnd;
        int i4 = group + 5;
        int i5 = this.groups[i4] >> 4;
        int i6 = i5 + currentSize;
        if (i6 == i2 && (i = i5 + newSize) <= i3) {
            this.unallocatedStart = i2 + (newSize - currentSize);
            if (newSize > 15) {
                getLargeSizes().set(i5, newSize);
            }
            int iSlotRangeFromAddressAndSize = SlotTableAddresSpaceKt.slotRangeFromAddressAndSize(i5, newSize);
            Object[] objArr = this.slots;
            if (i == i6 + 1) {
                objArr[i6] = SlotTableAddresSpaceKt.Unallocated;
            } else {
                ArraysKt.fill(objArr, SlotTableAddresSpaceKt.Unallocated, i6, i);
            }
            this.groups[i4] = iSlotRangeFromAddressAndSize;
            return iSlotRangeFromAddressAndSize;
        }
        int i7 = newSize - currentSize;
        Object[] objArr2 = this.slots;
        int i8 = i6 + i7;
        if (i8 < objArr2.length) {
            for (int i9 = i6; i9 < i8; i9++) {
                if (objArr2[i9] == SlotTableAddresSpaceKt.Unallocated) {
                }
            }
            if (newSize > 15) {
                getLargeSizes().set(i5, newSize);
            }
            int iSlotRangeFromAddressAndSize2 = SlotTableAddresSpaceKt.slotRangeFromAddressAndSize(i5, newSize);
            Object[] objArr3 = this.slots;
            int i10 = i5 + newSize;
            if (i10 == i6 + 1) {
                objArr3[i6] = SlotTableAddresSpaceKt.Unallocated;
            } else {
                ArraysKt.fill(objArr3, SlotTableAddresSpaceKt.Unallocated, i6, i10);
            }
            this.groups[i4] = iSlotRangeFromAddressAndSize2;
            this.freeSlotCount -= i7;
            return iSlotRangeFromAddressAndSize2;
        }
        int i11 = newSize + 8;
        int iShrinkSlotRange = shrinkSlotRange(allocateSlots(i11), i11, newSize);
        int i12 = iShrinkSlotRange >> 4;
        int i13 = this.groups[i4] >> 4;
        if (i12 != i13) {
            Object[] objArr4 = this.slots;
            ArraysKt.copyInto(objArr4, objArr4, i12, i13, i13 + currentSize);
            freeSlotsAt(i13, currentSize);
        }
        this.groups[i4] = iShrinkSlotRange;
        return iShrinkSlotRange;
    }

    private final int shrinkSlotRange(int range, int currentSize, int newSize) {
        int i = range >> 4;
        if (newSize == 0) {
            if (range != -1) {
                freeSlotsAt(i, currentSize);
            }
            return -1;
        }
        int i2 = currentSize - newSize;
        int i3 = i + newSize;
        if (i2 > 0) {
            freeSlotsAt(i3, i2);
        }
        if (newSize > 15) {
            getLargeSizes().set(i, newSize);
        }
        return SlotTableAddresSpaceKt.slotRangeFromAddressAndSize(i, newSize);
    }

    private final int shrinkSlotRangeAtGroup(int group, int currentSize, int newSize) {
        int i = group + 5;
        int iShrinkSlotRange = shrinkSlotRange(this.groups[i], currentSize, newSize);
        this.groups[i] = iShrinkSlotRange;
        return iShrinkSlotRange;
    }

    public final int slotSize(int slotRange) {
        if (slotRange == -1) {
            return 0;
        }
        int i = (slotRange & 15) + 1;
        return i > 15 ? getLargeSizes().get(slotRange >> 4) : i;
    }

    public final <R> R slotAddressAndSize(int slotRange, Function2<? super Integer, ? super Integer, ? extends R> block) {
        int i = (slotRange & 15) + 1;
        int i2 = slotRange >> 4;
        if (i > 15) {
            i = getLargeSizes().get(i2);
        }
        return block.invoke(Integer.valueOf(i2), Integer.valueOf(i));
    }

    private final void freeSlotsAt(int address, int size) {
        Object[] objArr = this.slots;
        int i = address + size;
        if (i == address + 1) {
            objArr[address] = SlotTableAddresSpaceKt.Unallocated;
        } else {
            ArraysKt.fill(objArr, SlotTableAddresSpaceKt.Unallocated, address, i);
        }
        this.freeSlotCount += size;
        if (size > 15) {
            getLargeSizes().remove(address);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void growGroups() {
        int[] iArr = this.groups;
        int length = iArr.length;
        int[] iArrCopyOf = Arrays.copyOf(this.groups, RangesKt.coerceAtLeast(iArr.length * 2, 768));
        Intrinsics.checkNotNullExpressionValue(iArrCopyOf, "copyOf(...)");
        this.groups = iArrCopyOf;
        SlotTableAddresSpaceKt.initGroups(iArrCopyOf, length);
    }

    public final String toDebugString() {
        StringBuilder sb = new StringBuilder("SlotTableAddressSpace:\n  Group size: ");
        int[] iArr = this.groups;
        sb.append(iArr.length);
        sb.append("\n  Slots size: ");
        sb.append(this.slots.length);
        sb.append("\n\n Groups:\n  Unallocated groups: ");
        int length = (iArr.length - iArr[3]) / 6;
        sb.append(length);
        sb.append('\n');
        int i = 0;
        for (int i2 = iArr[1]; i2 != -1; i2 = iArr[i2 + 1]) {
            i++;
        }
        sb.append("  Free groups:        ");
        sb.append(i);
        sb.append("\n  Total free groups:  ");
        int i3 = i + length;
        sb.append(i3);
        sb.append("\n  Used group%:        ");
        sb.append(((double) ((iArr.length / 6) - i3)) / ((double) (iArr.length / 6)));
        sb.append("\n\n Slots:\n  Unallocated slots: ");
        int i4 = this.unallocatedEnd - this.unallocatedStart;
        sb.append(i4);
        sb.append("\n  Slot used%:    ");
        int length2 = this.slots.length;
        sb.append(((double) ((length2 - this.freeSlotCount) - i4)) / ((double) length2));
        sb.append('\n');
        return sb.toString();
    }

    private final void compactAndMaybeGrow(int required) {
        Object[] objArr = this.slots;
        int length = objArr.length;
        int length2 = objArr.length - ((this.unallocatedEnd - this.unallocatedStart) + this.freeSlotCount);
        int iNumberOfLeadingZeros = 1 << (32 - Integer.numberOfLeadingZeros((required + length2) + (objArr.length >> 5)));
        if (iNumberOfLeadingZeros < length) {
            iNumberOfLeadingZeros = length;
        }
        Object[] objArrNewSlotsArray = iNumberOfLeadingZeros != length ? SlotTableAddresSpaceKt.newSlotsArray(RangesKt.coerceAtLeast(iNumberOfLeadingZeros, 256)) : objArr;
        MutableIntIntMap mutableIntIntMapMutableIntIntMapOf = IntIntMapKt.mutableIntIntMapOf();
        int i = this.groups[3];
        SlotMoveManager slotMoveManager = new SlotMoveManager(objArr, objArrNewSlotsArray);
        int i2 = 6;
        int progressionLastElement = ProgressionUtilKt.getProgressionLastElement(6, i - 1, 6);
        int i3 = 0;
        if (6 <= progressionLastElement) {
            while (true) {
                int i4 = i2 + 5;
                int i5 = this.groups[i4];
                if (i5 != -1) {
                    int i6 = (i5 & 15) + 1;
                    int i7 = i5 >> 4;
                    if (i6 > 15) {
                        i6 = getLargeSizes().get(i7);
                    }
                    slotMoveManager.move(i3, i7, i7 + i6);
                    if (i6 > 15) {
                        mutableIntIntMapMutableIntIntMapOf.set(i3, i6);
                    }
                    this.groups[i4] = SlotTableAddresSpaceKt.slotRangeFromAddressAndSize(i3, i6);
                    i3 += i6;
                }
                if (i2 == progressionLastElement) {
                    break;
                } else {
                    i2 += 6;
                }
            }
        }
        if (!(i3 == length2)) {
            ComposerKt.composeImmediateRuntimeError("Unexpected slot compaction result, computed we had " + length2 + " slots, but copied " + i3 + " slots");
        }
        this.slots = slotMoveManager.done();
        if (!mutableIntIntMapMutableIntIntMapOf.isNotEmpty()) {
            mutableIntIntMapMutableIntIntMapOf = null;
        }
        this._largeSizes = mutableIntIntMapMutableIntIntMapOf;
        this.unallocatedStart = i3;
        this.unallocatedEnd = objArrNewSlotsArray.length;
        this.freeSlotCount = 0;
    }

    private final void validateSlotReferences(int[] iArr) {
        MutableIntIntMap mutableIntIntMapMutableIntIntMapOf = IntIntMapKt.mutableIntIntMapOf();
        int length = this.slots.length;
        int i = 6;
        int progressionLastElement = ProgressionUtilKt.getProgressionLastElement(6, iArr[3] - 1, 6);
        if (6 <= progressionLastElement) {
            while (true) {
                int i2 = iArr[i + 5];
                if (i2 != -1) {
                    int i3 = (i2 & 15) + 1;
                    int i4 = i2 >> 4;
                    if (i3 > 15) {
                        i3 = getLargeSizes().get(i4);
                    }
                    if (i4 < 0) {
                        throw new IllegalStateException(("Group " + i + " has an invalid slot address").toString());
                    }
                    int i5 = i3 + i4;
                    if (i5 > length) {
                        throw new IllegalStateException(("Group " + i + " slot range extends beyond the slot size").toString());
                    }
                    while (i4 < i5) {
                        if (mutableIntIntMapMutableIntIntMapOf.containsKey(i4)) {
                            int i6 = mutableIntIntMapMutableIntIntMapOf.get(i4);
                            throw new IllegalStateException(("Group " + i + " contains a slot address (" + validateSlotReferences$slotRangeTextOf(this, iArr, i) + ") that overlaps with group " + i6 + "'s address (" + validateSlotReferences$slotRangeTextOf(this, iArr, i6) + ')').toString());
                        }
                        mutableIntIntMapMutableIntIntMapOf.set(i4, i);
                        i4++;
                    }
                }
                if (i == progressionLastElement) {
                    break;
                } else {
                    i += 6;
                }
            }
        }
        int length2 = (this.slots.length - mutableIntIntMapMutableIntIntMapOf.get_size()) - (this.unallocatedEnd - this.unallocatedStart);
        if (this.freeSlotCount != length2) {
            throw new IllegalStateException(("Unexpected freeSlotCount, " + this.freeSlotCount + ", expected " + length2).toString());
        }
    }

    public final void traverseParents$runtime(int group, Function1<? super Integer, Unit> visit) {
        int[] groups = getGroups();
        int i = groups[group + 2];
        while (i > 0) {
            visit.invoke(Integer.valueOf(i));
            i = groups[i + 2];
        }
        if (i != 0) {
            return;
        }
        ComposerKt.composeImmediateRuntimeError("Traversing parent of group not in the slot table: " + group);
    }

    private final void freeSlots(int slotRange) {
        if (slotRange != -1) {
            int i = (slotRange & 15) + 1;
            int i2 = slotRange >> 4;
            if (i > 15) {
                i = getLargeSizes().get(i2);
            }
            freeSlotsAt(i2, i);
        }
    }

    private static final String validateSlotReferences$slotRangeTextOf(SlotTableAddressSpace slotTableAddressSpace, int[] iArr, int i) {
        int i2 = iArr[i + 5];
        int i3 = (i2 & 15) + 1;
        int i4 = i2 >> 4;
        if (i3 > 15) {
            i3 = slotTableAddressSpace.getLargeSizes().get(i4);
        }
        return new StringBuilder().append(i4).append('-').append(i4 + i3).toString();
    }
}
