package androidx.compose.runtime.composer.linkbuffer;

import androidx.compose.runtime.Composer;
import androidx.compose.runtime.ComposerKt;
import androidx.compose.runtime.IntStack;
import com.google.firebase.analytics.FirebaseAnalytics;
import java.util.ArrayList;
import java.util.List;
import kotlin.Metadata;
import kotlin.UInt;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import org.jivesoftware.smack.packet.Message;
import org.jivesoftware.smackx.blocking.element.BlockContactsIQ;
import org.jivesoftware.smackx.iot.data.element.NodeElement;
import org.mozilla.javascript.ES6Iterator;

/* JADX INFO: compiled from: SlotTableReader.kt */
/* JADX INFO: loaded from: classes.dex */
@Metadata(d1 = {"\u0000\u0088\u0001\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0015\n\u0000\n\u0002\u0010\u0011\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u000e\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b&\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\t\n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0018\u0002\n\u0002\b\u000e\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\f\n\u0002\u0010!\n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\n\b\u0001\u0018\u00002\u00020\u0001B\u000f\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0004\b\u0004\u0010\u0005J\u001c\u00100\u001a\u0004\u0018\u00010\u00012\n\u00101\u001a\u00060\u0010j\u0002`\u00132\u0006\u0010\u001f\u001a\u00020\u0010J\u001c\u00102\u001a\u0004\u0018\u00010\u00012\n\u00101\u001a\u00060\u0010j\u0002`\u00132\u0006\u0010\u001f\u001a\u00020\u0010J\u0012\u00103\u001a\u00020\u00102\n\u00101\u001a\u00060\u0010j\u0002`\u0013J\u0014\u00106\u001a\u0004\u0018\u00010\u00012\n\u0010?\u001a\u00060\u0010j\u0002`\u0013J\u0012\u0010@\u001a\u00020$2\n\u00101\u001a\u00060\u0010j\u0002`\u0013J\u0014\u0010;\u001a\u0004\u0018\u00010\u00012\n\u00101\u001a\u00060\u0010j\u0002`\u0013J\u0014\u0010=\u001a\u0004\u0018\u00010\u00012\n\u0010?\u001a\u00060\u0010j\u0002`\u0013J\u0012\u0010C\u001a\u00020$2\n\u0010?\u001a\u00060\u0010j\u0002`\u0013J\u0014\u0010]\u001a\u0004\u0018\u00010\u00012\n\u0010?\u001a\u00060\u0010j\u0002`\u0013J\u0014\u0010^\u001a\u0004\u0018\u00010\u00012\n\u0010?\u001a\u00060\u0010j\u0002`\u0013J\u0012\u0010_\u001a\u00020\u00102\n\u0010?\u001a\u00060\u0010j\u0002`\u0013J\u0012\u0010`\u001a\u00020\u00102\n\u0010?\u001a\u00060\u0010j\u0002`\u0013J\u0012\u0010a\u001a\u00020\u00102\n\u0010?\u001a\u00060\u0010j\u0002`\u0013J\u0012\u0010b\u001a\u00020\u00102\n\u0010?\u001a\u00060\u0010j\u0002`\u0013J\n\u0010c\u001a\u00060Oj\u0002`PJ\n\u0010d\u001a\u00060Oj\u0002`PJ\u0012\u0010e\u001a\u00020$2\n\u0010?\u001a\u00060\u0010j\u0002`\u0013J\u0012\u0010f\u001a\u00020$2\n\u0010?\u001a\u00060\u0010j\u0002`\u0013J\u0016\u0010g\u001a\u00060\u0010j\u0002`h2\n\u00101\u001a\u00060\u0010j\u0002`\u0013J\n\u0010i\u001a\u00060\u0010j\u0002`hJ\u0006\u0010j\u001a\u00020kJ\u0006\u0010l\u001a\u00020kJ\u0006\u0010m\u001a\u00020kJ\u0006\u0010n\u001a\u00020kJ\u0006\u0010o\u001a\u00020\u0010J\u0006\u0010p\u001a\u00020kJ\u0012\u0010q\u001a\u00020k2\n\u0010\u000f\u001a\u00060\u0010j\u0002`\u0013J\b\u0010r\u001a\u0004\u0018\u00010\u0001J\u0012\u00109\u001a\u00020\u00102\n\u0010?\u001a\u00060\u0010j\u0002`\u0013J\u0010\u00100\u001a\u0004\u0018\u00010\u00012\u0006\u0010s\u001a\u00020\u0010J\u0006\u0010t\u001a\u00020kJ\u0006\u0010u\u001a\u00020kJ\u0012\u0010v\u001a\u00020k2\n\u0010?\u001a\u00060\u0010j\u0002`\u0013J\u0012\u0010v\u001a\u00020k2\n\u0010c\u001a\u00060Oj\u0002`PJ\f\u0010w\u001a\b\u0012\u0004\u0012\u00020y0xJ \u0010z\u001a\u00020k2\f\b\u0002\u0010{\u001a\u00060\u0010j\u0002`\u00132\n\u0010|\u001a\u00060\u0010j\u0002`hJ\u0012\u0010}\u001a\u00020k2\n\u0010|\u001a\u00060\u0010j\u0002`hJ\u001e\u0010}\u001a\u00020k2\n\u0010?\u001a\u00060\u0010j\u0002`\u00132\n\u0010|\u001a\u00060\u0010j\u0002`hJK\u0010~\u001a\u00020k2\n\u0010\u007f\u001a\u00060\u0010j\u0002`\u00132\t\b\u0002\u0010\u0080\u0001\u001a\u00020$2)\u0010\u0081\u0001\u001a$\u0012\u0019\u0012\u00170\u0010j\u0002`\u0013¢\u0006\u000e\b\u0083\u0001\u0012\t\b\u0084\u0001\u0012\u0004\b\b(?\u0012\u0004\u0012\u00020$0\u0082\u0001H\u0086\bJÂ\u0001\u0010\u0085\u0001\u001a\u00020k2\n\u0010?\u001a\u00060\u0010j\u0002`\u00132)\u0010\u0086\u0001\u001a$\u0012\u0019\u0012\u00170\u0010j\u0002`\u0013¢\u0006\u000e\b\u0083\u0001\u0012\t\b\u0084\u0001\u0012\u0004\b\b(?\u0012\u0004\u0012\u00020$0\u0082\u00012)\u0010\u0087\u0001\u001a$\u0012\u0019\u0012\u00170\u0010j\u0002`\u0013¢\u0006\u000e\b\u0083\u0001\u0012\t\b\u0084\u0001\u0012\u0004\b\b(?\u0012\u0004\u0012\u00020$0\u0082\u00012)\u0010\u0088\u0001\u001a$\u0012\u0019\u0012\u00170\u0010j\u0002`\u0013¢\u0006\u000e\b\u0083\u0001\u0012\t\b\u0084\u0001\u0012\u0004\b\b(?\u0012\u0004\u0012\u00020k0\u0082\u00012)\u0010\u0089\u0001\u001a$\u0012\u0019\u0012\u00170\u0010j\u0002`\u0013¢\u0006\u000e\b\u0083\u0001\u0012\t\b\u0084\u0001\u0012\u0004\b\b(?\u0012\u0004\u0012\u00020k0\u0082\u0001H\u0086\bJA\u0010\u008a\u0001\u001a\u00020k2\n\u0010?\u001a\u00060\u0010j\u0002`\u00132)\u0010\u0087\u0001\u001a$\u0012\u0019\u0012\u00170Oj\u0002`P¢\u0006\u000e\b\u0083\u0001\u0012\t\b\u0084\u0001\u0012\u0004\b\b(c\u0012\u0004\u0012\u00020k0\u0082\u0001H\u0086\bJ\u0018\u0010\u008b\u0001\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010\u00010\rH\u0082\b¢\u0006\u0003\u0010\u008c\u0001R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0006\u0010\u0007R\u000e\u0010\b\u001a\u00020\tX\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\n\u001a\u00020\u000bX\u0082\u000e¢\u0006\u0002\n\u0000R\u0018\u0010\f\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010\u00010\rX\u0082\u000e¢\u0006\u0004\n\u0002\u0010\u000eR\u000e\u0010\u000f\u001a\u00020\u0010X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0011\u001a\u00020\u0010X\u0082\u000e¢\u0006\u0002\n\u0000R,\u0010\u0014\u001a\u00060\u0010j\u0002`\u00132\n\u0010\u0012\u001a\u00060\u0010j\u0002`\u00138B@BX\u0082\u000e¢\u0006\f\u001a\u0004\b\u0015\u0010\u0016\"\u0004\b\u0017\u0010\u0018R\u001a\u0010\u0019\u001a\u00020\u0010X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u001a\u0010\u0016\"\u0004\b\u001b\u0010\u0018R\u001a\u0010\u001c\u001a\u00020\u0010X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u001d\u0010\u0016\"\u0004\b\u001e\u0010\u0018R\u0011\u0010\u001f\u001a\u00020\u00108F¢\u0006\u0006\u001a\u0004\b \u0010\u0016R\u000e\u0010!\u001a\u00020\"X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010#\u001a\u00020\u0010X\u0082\u000e¢\u0006\u0002\n\u0000R\u001e\u0010%\u001a\u00020$2\u0006\u0010\u0012\u001a\u00020$@BX\u0086\u000e¢\u0006\b\n\u0000\u001a\u0004\b&\u0010'R\u001e\u0010(\u001a\u00020$2\u0006\u0010\u0012\u001a\u00020$@BX\u0086\u000e¢\u0006\b\n\u0000\u001a\u0004\b(\u0010'R\u0011\u0010)\u001a\u00020$8F¢\u0006\u0006\u001a\u0004\b)\u0010'R\u000e\u0010*\u001a\u00020\u0010X\u0082\u000e¢\u0006\u0002\n\u0000R,\u0010+\u001a\u00060\u0010j\u0002`\u00132\n\u0010\u0012\u001a\u00060\u0010j\u0002`\u00138F@BX\u0086\u000e¢\u0006\f\u001a\u0004\b,\u0010\u0016\"\u0004\b-\u0010\u0018R\u0011\u0010.\u001a\u00020\u00108F¢\u0006\u0006\u001a\u0004\b/\u0010\u0016R\u0011\u00104\u001a\u00020\u00108F¢\u0006\u0006\u001a\u0004\b5\u0010\u0016R\u0013\u00106\u001a\u0004\u0018\u00010\u00018F¢\u0006\u0006\u001a\u0004\b7\u00108R\u0011\u00109\u001a\u00020\u00108F¢\u0006\u0006\u001a\u0004\b:\u0010\u0016R\u0013\u0010;\u001a\u0004\u0018\u00010\u00018F¢\u0006\u0006\u001a\u0004\b<\u00108R\u0013\u0010=\u001a\u0004\u0018\u00010\u00018F¢\u0006\u0006\u001a\u0004\b>\u00108R\u0011\u0010@\u001a\u00020$8F¢\u0006\u0006\u001a\u0004\bA\u0010'R\u0011\u0010B\u001a\u00020$8F¢\u0006\u0006\u001a\u0004\bB\u0010'R\u0011\u0010C\u001a\u00020$8F¢\u0006\u0006\u001a\u0004\bC\u0010'R\u0011\u0010D\u001a\u00020$8F¢\u0006\u0006\u001a\u0004\bE\u0010'R\u0015\u0010F\u001a\u00060\u0010j\u0002`\u00138F¢\u0006\u0006\u001a\u0004\bG\u0010\u0016R\u0015\u0010H\u001a\u00060\u0010j\u0002`\u00138F¢\u0006\u0006\u001a\u0004\bI\u0010\u0016R\u0011\u0010J\u001a\u00020K8F¢\u0006\u0006\u001a\u0004\bL\u0010MR\u0015\u0010N\u001a\u00060Oj\u0002`P8F¢\u0006\u0006\u001a\u0004\bQ\u0010RR\u0013\u0010S\u001a\u0004\u0018\u00010\u00018F¢\u0006\u0006\u001a\u0004\bT\u00108R\u0011\u00103\u001a\u00020\u00108F¢\u0006\u0006\u001a\u0004\bU\u0010\u0016R\u0011\u0010V\u001a\u00020\u00108F¢\u0006\u0006\u001a\u0004\bW\u0010\u0016R\u0015\u0010X\u001a\u00060\u0010j\u0002`Y8F¢\u0006\u0006\u001a\u0004\bZ\u0010\u0016R\u0011\u0010[\u001a\u00020\u00108F¢\u0006\u0006\u001a\u0004\b\\\u0010\u0016¨\u0006\u008d\u0001"}, d2 = {"Landroidx/compose/runtime/composer/linkbuffer/SlotTableReader;", "", "table", "Landroidx/compose/runtime/composer/linkbuffer/SlotTable;", "<init>", "(Landroidx/compose/runtime/composer/linkbuffer/SlotTable;)V", "getTable", "()Landroidx/compose/runtime/composer/linkbuffer/SlotTable;", "addressSpace", "Landroidx/compose/runtime/composer/linkbuffer/SlotTableAddressSpace;", "groups", "", "slots", "", "[Ljava/lang/Object;", Message.Thread.PARENT_ATTRIBUTE_NAME, "", "_current", "value", "Landroidx/compose/runtime/composer/linkbuffer/GroupAddress;", "current", "getCurrent", "()I", "setCurrent", "(I)V", "slotCurrent", "getSlotCurrent", "setSlotCurrent", "slotEnd", "getSlotEnd", "setSlotEnd", "slotIndex", "getSlotIndex", "previousSlotCurrentOffset", "Landroidx/compose/runtime/IntStack;", "emptyCount", "", "hadNext", "getHadNext", "()Z", "isClosed", "isEmpty", "_previousSibling", "previousSibling", "getPreviousSibling", "setPreviousSibling", "remainingSlots", "getRemainingSlots", "get", "address", "getOrNull", "nodeCount", "parentCurrentSlotOffset", "getParentCurrentSlotOffset", "groupAux", "getGroupAux", "()Ljava/lang/Object;", "groupKey", "getGroupKey", "groupObjectKey", "getGroupObjectKey", "groupNode", "getGroupNode", "group", "hasObjectKey", "getHasObjectKey", "isGroupEnd", "isNode", "inEmpty", "getInEmpty", "currentGroup", "getCurrentGroup", "parentGroup", "getParentGroup", "parentAnchor", "Landroidx/compose/runtime/composer/linkbuffer/LinkAnchor;", "getParentAnchor", "()Landroidx/compose/runtime/composer/linkbuffer/LinkAnchor;", "parentHandle", "", "Landroidx/compose/runtime/composer/linkbuffer/GroupHandle;", "getParentHandle", "()J", "parentNode", "getParentNode", "getNodeCount", "parentNodeCount", "getParentNodeCount", "groupReferenceSlotStartAddress", "Landroidx/compose/runtime/composer/linkbuffer/SlotAddress;", "getGroupReferenceSlotStartAddress", "nextParentSlotAddress", "getNextParentSlotAddress", NodeElement.ELEMENT, "maybeNode", "parentOf", "firstChildOf", "nextSiblingOf", "childNodeCountOf", "handle", "rootHandle", "recomposeRequired", "hasRecomposeRequired", "flagsOf", "Landroidx/compose/runtime/composer/linkbuffer/GroupFlags;", "parentGroupFlags", "close", "", "startGroup", "startNode", "endGroup", "skipGroup", "skipToGroupEnd", "restoreParent", ES6Iterator.NEXT_METHOD, FirebaseAnalytics.Param.INDEX, "beginEmpty", "endEmpty", "reposition", "extractKeys", "", "Landroidx/compose/runtime/composer/linkbuffer/KeyInfo;", "addFlag", "groupAddress", "flags", "removeFlag", "traverseGroupPartially", "start", "includeSiblingsOfStartGroup", "visit", "Lkotlin/Function1;", "Lkotlin/ParameterName;", "name", "traverseChildrenConditionally", "enter", BlockContactsIQ.ELEMENT, "exit", "skip", "traverseChildrenByHandle", "upToDateSlots", "()[Ljava/lang/Object;", "runtime"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final class SlotTableReader {
    public static final int $stable = 8;
    private int _current;
    private int _previousSibling;
    private SlotTableAddressSpace addressSpace;
    private int emptyCount;
    private int[] groups;
    private boolean hadNext;
    private boolean isClosed;
    private int parent;
    private final IntStack previousSlotCurrentOffset;
    private int slotCurrent;
    private int slotEnd;
    private Object[] slots;
    private final SlotTable table;

    public SlotTableReader(SlotTable slotTable) {
        this.table = slotTable;
        SlotTableAddressSpace addressSpace = slotTable.getAddressSpace();
        this.addressSpace = addressSpace;
        this.groups = addressSpace.getGroups();
        this.slots = slotTable.getAddressSpace().getSlots();
        this.parent = -1;
        this._current = slotTable.getRoot();
        this.previousSlotCurrentOffset = new IntStack();
        this._previousSibling = -1;
    }

    public final SlotTable getTable() {
        return this.table;
    }

    /* JADX INFO: renamed from: getCurrent, reason: from getter */
    private final int get_current() {
        return this._current;
    }

    private final void setCurrent(int i) {
        this._current = i;
    }

    public final int getSlotCurrent() {
        return this.slotCurrent;
    }

    public final void setSlotCurrent(int i) {
        this.slotCurrent = i;
    }

    public final int getSlotEnd() {
        return this.slotEnd;
    }

    public final void setSlotEnd(int i) {
        this.slotEnd = i;
    }

    public final int getSlotIndex() {
        int i = this.parent;
        if (i >= 0) {
            return this.slotCurrent - (this.groups[i + 5] >> 4);
        }
        return 0;
    }

    public final boolean getHadNext() {
        return this.hadNext;
    }

    /* JADX INFO: renamed from: isClosed, reason: from getter */
    public final boolean getIsClosed() {
        return this.isClosed;
    }

    public final boolean isEmpty() {
        return this.table.isEmpty();
    }

    /* JADX INFO: renamed from: getPreviousSibling, reason: from getter */
    public final int get_previousSibling() {
        return this._previousSibling;
    }

    private final void setPreviousSibling(int i) {
        this._previousSibling = i;
    }

    public final int getRemainingSlots() {
        return this.slotEnd - this.slotCurrent;
    }

    public final Object get(int address, int slotIndex) {
        if (slotIndex >= 0) {
            int[] iArr = this.groups;
            Object[] objArr = this.slots;
            int i = iArr[address + 5];
            if (i != -1) {
                int i2 = iArr[address + 4];
                SlotTableAddressSpace slotTableAddressSpace = this.addressSpace;
                int i3 = (i & 15) + 1;
                int i4 = i >> 4;
                if (i3 > 15) {
                    i3 = slotTableAddressSpace.getLargeSizes().get(i4);
                }
                int iUtilitySlotsCountForFlags = slotIndex + GroupFlagsKt.utilitySlotsCountForFlags(i2);
                if (iUtilitySlotsCountForFlags < i3) {
                    return objArr[i4 + iUtilitySlotsCountForFlags];
                }
            }
        }
        return Composer.INSTANCE.getEmpty();
    }

    public final Object getOrNull(int address, int slotIndex) {
        Object obj = get(address, slotIndex);
        if (obj == null || Intrinsics.areEqual(obj, Composer.INSTANCE.getEmpty())) {
            return null;
        }
        return obj;
    }

    public final int nodeCount(int address) {
        int i = this.groups[address + 4];
        if ((i & 8388608) == 8388608) {
            return 1;
        }
        return i & GroupFlagsSpec.CHILD_NODE_COUNT_MASK;
    }

    public final int getParentCurrentSlotOffset() {
        int i = this.groups[this.parent + 5];
        if (i == -1) {
            return 0;
        }
        return this.slotCurrent - (i >> 4);
    }

    public final Object getGroupAux() {
        return groupAux(get_current());
    }

    public final int getGroupKey() {
        int i = get_current();
        if (i != -1) {
            return this.addressSpace.getGroups()[i];
        }
        return 0;
    }

    public final Object getGroupObjectKey() {
        return groupObjectKey(get_current());
    }

    public final Object getGroupNode() {
        return groupNode(get_current());
    }

    public final Object groupAux(int group) {
        int[] iArr = this.groups;
        int i = iArr[group + 4];
        int i2 = iArr[group + 5];
        if ((i & GroupFlagsKt.HasAuxSlotFlag) != 33554432) {
            return Composer.INSTANCE.getEmpty();
        }
        if (this.emptyCount > 0) {
            this.slots = this.addressSpace.getSlots();
        }
        return this.slots[(i2 >> 4) + Integer.bitCount(i & 25165824)];
    }

    public final boolean getHasObjectKey() {
        return hasObjectKey(get_current());
    }

    public final boolean hasObjectKey(int address) {
        return (this.groups[address + 4] & 16777216) == 16777216;
    }

    public final Object groupObjectKey(int address) {
        int[] iArr = this.groups;
        int i = iArr[address + 4];
        int i2 = iArr[address + 5];
        if ((i & 16777216) != 16777216) {
            return null;
        }
        if (this.emptyCount > 0) {
            this.slots = this.addressSpace.getSlots();
        }
        return this.slots[(i2 >> 4) + Integer.bitCount(i & 8388608)];
    }

    public final Object groupNode(int group) {
        int[] iArr = this.groups;
        int i = iArr[group + 4];
        int i2 = iArr[group + 5];
        if ((i & 8388608) != 8388608) {
            return null;
        }
        if (this.emptyCount > 0) {
            this.slots = this.addressSpace.getSlots();
        }
        return this.slots[i2 >> 4];
    }

    public final boolean isGroupEnd() {
        return get_current() == -1 && !getInEmpty();
    }

    public final boolean isNode() {
        return (this.groups[get_current() + 4] & 8388608) == 8388608;
    }

    public final boolean getInEmpty() {
        return this.emptyCount > 0;
    }

    public final boolean isNode(int group) {
        return (this.groups[group + 4] & 8388608) == 8388608;
    }

    public final int getCurrentGroup() {
        return get_current();
    }

    /* JADX INFO: renamed from: getParentGroup, reason: from getter */
    public final int getParent() {
        return this.parent;
    }

    public final LinkAnchor getParentAnchor() {
        return this.addressSpace.anchorOfAddress(getParent());
    }

    public final long getParentHandle() {
        return (((long) 0) << 32) | (((long) UInt.m12488constructorimpl(this.parent)) & 4294967295L);
    }

    public final Object getParentNode() {
        return groupNode(this.parent);
    }

    public final int getNodeCount() {
        return this.groups[get_current() + 4] & GroupFlagsSpec.CHILD_NODE_COUNT_MASK;
    }

    public final int getParentNodeCount() {
        int i = this.parent;
        if (i == -1) {
            return 0;
        }
        int i2 = this.groups[i + 4];
        if ((i2 & 8388608) == 8388608) {
            return 1;
        }
        return i2 & GroupFlagsSpec.CHILD_NODE_COUNT_MASK;
    }

    public final int getGroupReferenceSlotStartAddress() {
        return this.groups[this.parent + 5] >> 4;
    }

    /* JADX INFO: renamed from: getNextParentSlotAddress, reason: from getter */
    public final int getSlotCurrent() {
        return this.slotCurrent;
    }

    public final Object node(int group) {
        return this.slots[this.groups[group + 5] >> 4];
    }

    public final Object maybeNode(int group) {
        if ((this.groups[group + 4] & 8388608) != 8388608) {
            return Composer.INSTANCE.getEmpty();
        }
        if (this.emptyCount > 0) {
            this.slots = this.addressSpace.getSlots();
        }
        return this.slots[this.groups[group + 5] >> 4];
    }

    public final int parentOf(int group) {
        return this.groups[group + 2];
    }

    public final int firstChildOf(int group) {
        return this.groups[group + 3];
    }

    public final int nextSiblingOf(int group) {
        return this.groups[group + 1];
    }

    public final int childNodeCountOf(int group) {
        return this.groups[group + 4] & GroupFlagsSpec.CHILD_NODE_COUNT_MASK;
    }

    public final long handle() {
        return GroupHandleKt.makeGroupHandle(this.parent, get_previousSibling(), get_current());
    }

    public final long rootHandle() {
        return (((long) (-1)) << 32) | (((long) UInt.m12488constructorimpl(this.table.getRoot())) & 4294967295L);
    }

    public final boolean recomposeRequired(int group) {
        return (this.groups[group + 4] & 67108864) == 67108864;
    }

    public final boolean hasRecomposeRequired(int group) {
        return (this.groups[group + 4] & 201326592) != 0;
    }

    public final int flagsOf(int address) {
        return this.groups[address + 4];
    }

    public final int parentGroupFlags() {
        return flagsOf(this.parent);
    }

    public final void close() {
        if (this.isClosed) {
            return;
        }
        this.isClosed = true;
        this.table.closeReader(this);
    }

    public final void startGroup() {
        int i;
        int i2 = get_current();
        this.parent = i2;
        int[] iArr = this.groups;
        if (i2 + 6 > iArr.length) {
            return;
        }
        setCurrent(iArr[i2 + 3]);
        setPreviousSibling(-1);
        this.previousSlotCurrentOffset.push(this.slotEnd - this.slotCurrent);
        int i3 = iArr[i2 + 5];
        if (i3 == -1) {
            this.slotCurrent = -1;
            this.slotEnd = -1;
            return;
        }
        int i4 = iArr[i2 + 4];
        int i5 = i3 >> 4;
        this.slotCurrent = GroupFlagsKt.utilitySlotsCountForFlags(i4) + i5;
        SlotTableAddressSpace slotTableAddressSpace = this.addressSpace;
        if (i3 == -1) {
            i = 0;
        } else {
            int i6 = (i3 & 15) + 1;
            i = i6 > 15 ? slotTableAddressSpace.getLargeSizes().get(i5) : i6;
        }
        this.slotEnd = i5 + i;
    }

    public final void startNode() {
        if (!isNode()) {
            ComposerKt.composeImmediateRuntimeError("Expected a node group");
        }
        startGroup();
    }

    public final void endGroup() {
        int i;
        int i2 = this.parent;
        int[] iArr = this.groups;
        if (i2 + 6 > iArr.length) {
            return;
        }
        int i3 = iArr[i2 + 1];
        int i4 = iArr[i2 + 2];
        this.parent = i4;
        setPreviousSibling(i2);
        setCurrent(i3);
        int i5 = this.groups[i4 + 5];
        int i6 = i5 >> 4;
        SlotTableAddressSpace slotTableAddressSpace = this.addressSpace;
        if (i5 == -1) {
            i = 0;
        } else {
            i = (i5 & 15) + 1;
            if (i > 15) {
                i = slotTableAddressSpace.getLargeSizes().get(i6);
            }
        }
        int i7 = i6 + i;
        this.slotEnd = i7;
        this.slotCurrent = i7 - this.previousSlotCurrentOffset.popOr(0);
    }

    public final int skipGroup() {
        int i = get_current();
        int[] iArr = this.groups;
        if (i + 6 > iArr.length) {
            return 0;
        }
        int i2 = iArr[i + 4];
        int i3 = (i2 & 8388608) == 8388608 ? 1 : i2 & GroupFlagsSpec.CHILD_NODE_COUNT_MASK;
        setCurrent(iArr[i + 1]);
        setPreviousSibling(i);
        return i3;
    }

    public final void skipToGroupEnd() {
        setCurrent(-1);
        setPreviousSibling(0);
        this.slotCurrent = 0;
        this.slotEnd = 0;
    }

    public final void restoreParent(int parent) {
        setPreviousSibling(0);
        this.parent = parent;
        this.slotCurrent = 0;
        this.slotEnd = 0;
    }

    public final Object next() {
        int i;
        if (getInEmpty() || (i = this.slotCurrent) >= this.slotEnd) {
            this.hadNext = false;
            return Composer.INSTANCE.getEmpty();
        }
        this.hadNext = true;
        Object[] objArr = this.slots;
        this.slotCurrent = i + 1;
        return objArr[i];
    }

    public final int groupKey(int group) {
        return this.groups[group];
    }

    public final Object get(int index) {
        return get(get_current(), index);
    }

    public final void beginEmpty() {
        this.emptyCount++;
    }

    public final void endEmpty() {
        if (!(this.emptyCount > 0)) {
            ComposerKt.composeImmediateRuntimeError("Unbalanced begin/end empty");
        }
        int i = this.emptyCount - 1;
        this.emptyCount = i;
        if (i == 0) {
            this.slots = this.addressSpace.getSlots();
            int[] groups = this.addressSpace.getGroups();
            this.groups = groups;
            int i2 = this.slotEnd - this.slotCurrent;
            int i3 = groups[this.parent + 5];
            if (i3 != -1) {
                SlotTableAddressSpace slotTableAddressSpace = this.addressSpace;
                int i4 = (i3 & 15) + 1;
                int i5 = i3 >> 4;
                if (i4 > 15) {
                    i4 = slotTableAddressSpace.getLargeSizes().get(i5);
                }
                int i6 = i5 + i4;
                this.slotCurrent = i6 - i2;
                this.slotEnd = i6;
            }
        }
    }

    public final void reposition(long handle) {
        if (getInEmpty()) {
            ComposerKt.composeImmediateRuntimeError("Cannot reposition while in an empty region");
        }
        setCurrent(GroupHandleKt.getGroup(handle));
        setPreviousSibling(GroupHandleKt.getContext(handle));
        this.parent = this.groups[get_current() + 2];
    }

    public final List<KeyInfo> extractKeys() {
        ArrayList arrayList = new ArrayList();
        if (!getInEmpty()) {
            int i = get_previousSibling();
            int[] iArr = this.groups;
            Object[] objArr = this.slots;
            SlotTable slotTable = this.table;
            int currentGroup = getCurrentGroup();
            int[] groups = slotTable.getAddressSpace().getGroups();
            int i2 = i;
            int i3 = currentGroup;
            int i4 = 0;
            while (i3 >= 0) {
                int i5 = iArr[i3 + 4];
                arrayList.add(new KeyInfo(iArr[i3], (i5 & 16777216) == 16777216 ? objArr[(iArr[i3 + 5] >> 4) + Integer.bitCount(i5 & 8388608)] : null, (((long) i2) << 32) | (((long) UInt.m12488constructorimpl(i3)) & 4294967295L), (i5 & 8388608) == 8388608 ? 1 : 8388607 & i5, i4));
                i2 = i3;
                i3 = groups[i3 + 1];
                i4++;
            }
        }
        return arrayList;
    }

    public static /* synthetic */ void addFlag$default(SlotTableReader slotTableReader, int i, int i2, int i3, Object obj) {
        if ((i3 & 1) != 0) {
            i = slotTableReader.getParent();
        }
        slotTableReader.addFlag(i, i2);
    }

    public final void addFlag(int groupAddress, int flags) {
        int iPropagatingFlagsOf = GroupFlagsKt.propagatingFlagsOf(flags);
        int[] groups = this.addressSpace.getGroups();
        int[] groups2 = this.table.getAddressSpace().getGroups();
        int i = groupAddress;
        while (i > 0) {
            int i2 = i + 4;
            int i3 = groups[i2];
            int i4 = i == groupAddress ? flags : iPropagatingFlagsOf;
            if ((i4 & i3) == i4) {
                return;
            }
            groups[i2] = i3 | i4;
            i = groups2[i + 2];
        }
        if (i != 0) {
            return;
        }
        ComposerKt.composeImmediateRuntimeError("Traversing parent of group not in the slot table: " + groupAddress);
    }

    public final void removeFlag(int flags) {
        removeFlag(this.parent, flags);
    }

    public final void removeFlag(int group, int flags) {
        int[] groups = this.addressSpace.getGroups();
        int i = group + 4;
        int i2 = groups[i];
        if ((flags & i2) == flags) {
            int i3 = i2 & (~flags);
            groups[i] = i3;
            int iPropagatingFlagsOf = GroupFlagsKt.propagatingFlagsOf(flags);
            if ((i3 & iPropagatingFlagsOf) != 0) {
                return;
            }
            int i4 = flags | iPropagatingFlagsOf;
            int[] groups2 = this.addressSpace.getGroups();
            int i5 = groups2[group + 2];
            while (i5 > 0) {
                int i6 = i5 + 4;
                int i7 = groups[i6];
                if ((i7 & iPropagatingFlagsOf) == 0) {
                    return;
                }
                int[] groups3 = this.addressSpace.getGroups();
                for (int i8 = groups3[i5 + 3]; i8 > 0; i8 = groups3[i8 + 1]) {
                    if ((groups[i8 + 4] & i4) != 0) {
                        return;
                    }
                }
                groups[i6] = i7 & (~iPropagatingFlagsOf);
                i5 = groups2[i5 + 2];
            }
            if (i5 != 0) {
                return;
            }
            ComposerKt.composeImmediateRuntimeError("Traversing parent of group not in the slot table: " + group);
        }
    }

    public static /* synthetic */ void traverseGroupPartially$default(SlotTableReader slotTableReader, int i, boolean z, Function1 function1, int i2, Object obj) {
        int i3;
        if ((i2 & 2) != 0) {
            z = false;
        }
        SlotTableAddressSpace slotTableAddressSpace = slotTableReader.addressSpace;
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

    public final void traverseGroupPartially(int start, boolean includeSiblingsOfStartGroup, Function1<? super Integer, Boolean> visit) {
        int i;
        SlotTableAddressSpace slotTableAddressSpace = this.addressSpace;
        if (start < 0) {
            return;
        }
        IntStack intStack = new IntStack();
        int[] groups = slotTableAddressSpace.getGroups();
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

    public final void traverseChildrenConditionally(int group, Function1<? super Integer, Boolean> enter, Function1<? super Integer, Boolean> block, Function1<? super Integer, Unit> exit, Function1<? super Integer, Unit> skip) {
        int iFirstChildOf = firstChildOf(group);
        while (iFirstChildOf != -1) {
            boolean zBooleanValue = block.invoke(Integer.valueOf(iFirstChildOf)).booleanValue();
            int iFirstChildOf2 = firstChildOf(iFirstChildOf);
            if (zBooleanValue || iFirstChildOf2 == -1 || !enter.invoke(Integer.valueOf(iFirstChildOf)).booleanValue()) {
                if (iFirstChildOf2 == -1 && !zBooleanValue) {
                    skip.invoke(Integer.valueOf(iFirstChildOf));
                }
                int iParentOf = iFirstChildOf;
                iFirstChildOf = nextSiblingOf(iFirstChildOf);
                while (iFirstChildOf == -1) {
                    iParentOf = parentOf(iParentOf);
                    if (iParentOf == -1 || iParentOf == group) {
                        return;
                    }
                    exit.invoke(Integer.valueOf(iParentOf));
                    iFirstChildOf = nextSiblingOf(iParentOf);
                }
            } else {
                iFirstChildOf = iFirstChildOf2;
            }
        }
    }

    public final void traverseChildrenByHandle(int group, Function1<? super Long, Unit> block) {
        long jM12488constructorimpl = ((long) (-1)) << 32;
        long jM12488constructorimpl2 = ((long) UInt.m12488constructorimpl(firstChildOf(group))) & 4294967295L;
        while (true) {
            long j = jM12488constructorimpl | jM12488constructorimpl2;
            if (GroupHandleKt.getGroup(j) == -1) {
                return;
            }
            block.invoke(Long.valueOf(j));
            jM12488constructorimpl2 = ((long) GroupHandleKt.getGroup(j)) << 32;
            jM12488constructorimpl = ((long) UInt.m12488constructorimpl(nextSiblingOf(GroupHandleKt.getGroup(j)))) & 4294967295L;
        }
    }

    private final Object[] upToDateSlots() {
        if (this.emptyCount > 0) {
            this.slots = this.addressSpace.getSlots();
        }
        return this.slots;
    }

    public final void reposition(int group) {
        reposition((((long) 0) << 32) | (((long) UInt.m12488constructorimpl(group)) & 4294967295L));
    }
}
