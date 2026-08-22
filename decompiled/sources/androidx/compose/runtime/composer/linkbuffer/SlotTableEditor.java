package androidx.compose.runtime.composer.linkbuffer;

import androidx.collection.IntSet;
import androidx.compose.runtime.Composer;
import androidx.compose.runtime.ComposerKt;
import androidx.compose.runtime.IntStack;
import androidx.compose.runtime.LinkComposerKt;
import androidx.compose.runtime.RememberObserverHolder;
import androidx.compose.runtime.composer.linkbuffer.SlotTable;
import com.clevertap.android.sdk.Constants;
import com.google.firebase.analytics.FirebaseAnalytics;
import kotlin.Metadata;
import kotlin.UInt;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;
import org.jivesoftware.smack.packet.Message;
import org.jivesoftware.smackx.blocking.element.BlockContactsIQ;
import org.jivesoftware.smackx.httpfileupload.element.Slot;
import org.jivesoftware.smackx.iot.data.element.NodeElement;
import org.jivesoftware.smackx.reference.element.ReferenceElement;

/* JADX INFO: compiled from: SlotTableEditor.kt */
/* JADX INFO: loaded from: classes.dex */
@Metadata(d1 = {"\u0000\u0098\u0001\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0010\u000b\n\u0002\b\u0010\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0007\n\u0002\u0010\t\n\u0002\u0018\u0002\n\u0002\b\u0014\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\t\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0010\u0011\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\b\u0001\u0018\u00002\u00020\u0001:\u0001zB\u000f\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0004\b\u0004\u0010\u0005J\u0012\u0010\u001b\u001a\u00020\t2\n\u0010%\u001a\u00060\tj\u0002`&J\u0014\u0010\u001d\u001a\u0004\u0018\u00010\u00012\n\u0010%\u001a\u00060\tj\u0002`&J\u0014\u0010 \u001a\u0004\u0018\u00010\u00012\n\u0010%\u001a\u00060\tj\u0002`&J\u001e\u0010'\u001a\u00020(2\f\b\u0002\u0010%\u001a\u00060\tj\u0002`&2\b\u0010)\u001a\u0004\u0018\u00010\u0001J\u0012\u0010*\u001a\u00020\t2\n\u0010%\u001a\u00060\tj\u0002`&J\u0012\u0010\u0014\u001a\u00020\u00152\n\u0010%\u001a\u00060\tj\u0002`&J\u0012\u0010+\u001a\u00020\t2\n\u0010,\u001a\u00060\tj\u0002`&J\u0012\u0010-\u001a\u00020\t2\n\u0010%\u001a\u00060\tj\u0002`&J\u0012\u0010.\u001a\u00020\t2\n\u0010%\u001a\u00060\tj\u0002`&J\n\u0010/\u001a\u000600j\u0002`1J\u0016\u0010\u0012\u001a\u00060\tj\u0002`&2\n\u00102\u001a\u00060\tj\u0002`&J\u0006\u00103\u001a\u00020(J\u0006\u00104\u001a\u00020(J\u0006\u00105\u001a\u00020(J\u0010\u00106\u001a\u00020(2\b\b\u0002\u00107\u001a\u00020\u0015J\u001a\u00108\u001a\u00020(2\u0006\u00109\u001a\u00020\u00032\n\u0010/\u001a\u000600j\u0002`1J\u0014\u0010:\u001a\u00020(2\n\u0010%\u001a\u00060\tj\u0002`&H\u0002J\u000e\u0010;\u001a\u00020(2\u0006\u0010<\u001a\u00020\tJ\u0012\u0010;\u001a\u00020(2\n\u0010/\u001a\u000600j\u0002`1J(\u0010=\u001a\u00020(2\u0006\u0010>\u001a\u00020\u00032\n\u0010?\u001a\u000600j\u0002`12\f\b\u0002\u0010@\u001a\u000600j\u0002`1J,\u0010=\u001a\u000600j\u0002`12\u0006\u0010A\u001a\u00020\u00002\n\u0010?\u001a\u000600j\u0002`12\f\b\u0002\u0010@\u001a\u000600j\u0002`1J\u0006\u0010B\u001a\u00020\tJ\u0006\u0010C\u001a\u00020(J\u000e\u0010D\u001a\u00020(2\u0006\u0010E\u001a\u00020FJ\u0012\u0010D\u001a\u00020(2\n\u0010/\u001a\u000600j\u0002`1J\u0010\u0010G\u001a\u00020(2\b\u0010 \u001a\u0004\u0018\u00010\u0001J\u0010\u0010H\u001a\u00020(2\b\u0010\u0018\u001a\u0004\u0018\u00010\u0001J\u001e\u0010I\u001a\u0004\u0018\u00010\u00012\n\u0010J\u001a\u00060\tj\u0002`K2\b\u0010\u0018\u001a\u0004\u0018\u00010\u0001J\u001a\u0010L\u001a\u0004\u0018\u00010\u00012\u0006\u0010M\u001a\u00020\t2\b\u0010\u0018\u001a\u0004\u0018\u00010\u0001J\u0010\u0010N\u001a\u00020(2\b\u0010\u0018\u001a\u0004\u0018\u00010\u0001J\u000e\u0010O\u001a\u00020(2\u0006\u0010P\u001a\u00020\tJ\u0012\u0010Q\u001a\u00020\u00152\n\u0010R\u001a\u000600j\u0002`1J\"\u0010S\u001a\u00020\u00032\u0017\u0010T\u001a\u0013\u0012\u0004\u0012\u00020V\u0012\u0004\u0012\u00020(0U¢\u0006\u0002\bWH\u0086\bJ\u0015\u0010X\u001a\u00020(2\u0006\u0010Y\u001a\u00020\tH\u0000¢\u0006\u0002\bZJ\u001a\u0010[\u001a\u00020(2\n\u0010\\\u001a\u00060\tj\u0002`&2\u0006\u0010]\u001a\u00020^J5\u0010_\u001a\u00020(2\n\u0010\\\u001a\u00060\tj\u0002`&2\n\u0010`\u001a\u00060\tj\u0002`&2\u0006\u0010a\u001a\u00020\t2\u0006\u0010]\u001a\u00020^H\u0000¢\u0006\u0002\bbJ\u0012\u0010c\u001a\u00020(2\n\u0010d\u001a\u00060\tj\u0002`eJ\u001a\u0010f\u001a\u00020(2\u0006\u0010g\u001a\u00020h2\n\u0010d\u001a\u00060\tj\u0002`eJ\u0006\u0010i\u001a\u00020(J4\u0010j\u001a\u00020(2\n\u0010%\u001a\u00060\tj\u0002`&2\u0006\u0010k\u001a\u00020\t2\u0006\u0010l\u001a\u00020\t2\u0006\u0010m\u001a\u00020\t2\u0006\u0010n\u001a\u00020\u0015H\u0002Jd\u0010o\u001a\u00020(*\n\u0012\u0006\u0012\u0004\u0018\u00010\u00010p2\u0006\u0010q\u001a\u00020\t2\u0006\u0010r\u001a\u00020\t28\u0010T\u001a4\u0012\u0013\u0012\u00110\t¢\u0006\f\bt\u0012\b\bu\u0012\u0004\b\b(M\u0012\u0015\u0012\u0013\u0018\u00010\u0001¢\u0006\f\bt\u0012\b\bu\u0012\u0004\b\b(\u0018\u0012\u0004\u0012\u00020(0sH\u0082\b¢\u0006\u0002\u0010vJ`\u0010o\u001a\u00020(*\n\u0012\u0006\u0012\u0004\u0018\u00010\u00010p2\n\u0010w\u001a\u00060\tj\u0002`x28\u0010T\u001a4\u0012\u0013\u0012\u00110\t¢\u0006\f\bt\u0012\b\bu\u0012\u0004\b\b(M\u0012\u0015\u0012\u0013\u0018\u00010\u0001¢\u0006\f\bt\u0012\b\bu\u0012\u0004\b\b(\u0018\u0012\u0004\u0012\u00020(0sH\u0082\b¢\u0006\u0002\u0010yR\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0006\u0010\u0007R\u000e\u0010\b\u001a\u00020\tX\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\n\u001a\u00020\tX\u0082\u000e¢\u0006\u0002\n\u0000R\u0014\u0010\u000b\u001a\u00020\fX\u0080\u0004¢\u0006\b\n\u0000\u001a\u0004\b\r\u0010\u000eR\u0011\u0010\u000f\u001a\u00020\t8F¢\u0006\u0006\u001a\u0004\b\u0010\u0010\u0011R\u0011\u0010\u0012\u001a\u00020\t8F¢\u0006\u0006\u001a\u0004\b\u0013\u0010\u0011R\u0011\u0010\u0014\u001a\u00020\u00158F¢\u0006\u0006\u001a\u0004\b\u0014\u0010\u0016R\u0011\u0010\u0017\u001a\u00020\u00158F¢\u0006\u0006\u001a\u0004\b\u0017\u0010\u0016R\u001e\u0010\u0019\u001a\u00020\u00152\u0006\u0010\u0018\u001a\u00020\u0015@BX\u0086\u000e¢\u0006\b\n\u0000\u001a\u0004\b\u0019\u0010\u0016R\u0011\u0010\u001a\u001a\u00020\u00158F¢\u0006\u0006\u001a\u0004\b\u001a\u0010\u0016R\u0011\u0010\u001b\u001a\u00020\t8F¢\u0006\u0006\u001a\u0004\b\u001c\u0010\u0011R\u0013\u0010\u001d\u001a\u0004\u0018\u00010\u00018F¢\u0006\u0006\u001a\u0004\b\u001e\u0010\u001fR\u0013\u0010 \u001a\u0004\u0018\u00010\u00018F¢\u0006\u0006\u001a\u0004\b!\u0010\u001fR\u0011\u0010\"\u001a\u00020\u00158F¢\u0006\u0006\u001a\u0004\b\"\u0010\u0016R\u001e\u0010#\u001a\u00020\t2\u0006\u0010\u0018\u001a\u00020\t@BX\u0086\u000e¢\u0006\b\n\u0000\u001a\u0004\b$\u0010\u0011¨\u0006{"}, d2 = {"Landroidx/compose/runtime/composer/linkbuffer/SlotTableEditor;", "", "table", "Landroidx/compose/runtime/composer/linkbuffer/SlotTable;", "<init>", "(Landroidx/compose/runtime/composer/linkbuffer/SlotTable;)V", "getTable", "()Landroidx/compose/runtime/composer/linkbuffer/SlotTable;", Message.Thread.PARENT_ATTRIBUTE_NAME, "", "current", "addressSpace", "Landroidx/compose/runtime/composer/linkbuffer/SlotTableAddressSpace;", "getAddressSpace$runtime", "()Landroidx/compose/runtime/composer/linkbuffer/SlotTableAddressSpace;", "currentGroup", "getCurrentGroup", "()I", "parentGroup", "getParentGroup", "isNode", "", "()Z", "isGroupEnd", "value", "isClosed", "isEmpty", "groupKey", "getGroupKey", "objectKey", "getObjectKey", "()Ljava/lang/Object;", NodeElement.ELEMENT, "getNode", "isParentGroupANode", "previousSibling", "getPreviousSibling", "group", "Landroidx/compose/runtime/composer/linkbuffer/GroupAddress;", "updateNode", "", Constants.KEY_NEW_VALUE, "flagsOf", "nodeCountOf", "groups", "parentOf", "firstChildOf", "handle", "", "Landroidx/compose/runtime/composer/linkbuffer/GroupHandle;", "groupAddress", "close", "startGroup", "endGroup", "removeGroup", "freeGroup", "insertGroupFrom", "insertTable", "insertGroup", "moveGroup", "offset", "moveFrom", "sourceTable", "sourceHandle", "destination", "sourceEditor", "skipGroup", "skipToGroupEnd", "seek", ReferenceElement.ATTR_ANCHOR, "Landroidx/compose/runtime/composer/linkbuffer/LinkAnchor;", "updateParentNode", "updateAux", "setAbsolute", "slotAddress", "Landroidx/compose/runtime/composer/linkbuffer/SlotAddress;", "setRelative", FirebaseAnalytics.Param.INDEX, "appendSlot", "trimSlots", "slots", "containsHandle", "groupHandle", "buildInsertTable", BlockContactsIQ.ELEMENT, "Lkotlin/Function1;", "Landroidx/compose/runtime/composer/linkbuffer/SlotTableBuilder;", "Lkotlin/ExtensionFunctionType;", "bashGroup", "newKey", "bashGroup$runtime", "visitSlotsInRememberOrder", "inGroup", "callback", "Landroidx/compose/runtime/composer/linkbuffer/SlotTableEditor$VisitSlotsInRememberOrderCallback;", "visitTailSlotsInRememberOrder", "firstTailGroupToVisit", "tailSlots", "visitTailSlotsInRememberOrder$runtime", "removeAllInstancesOfFlags", "flags", "Landroidx/compose/runtime/composer/linkbuffer/GroupFlags;", "addFlagsToAllGroupsIn", "groupSet", "Landroidx/collection/IntSet;", "reset", "propagateChanges", "nodeCountDelta", "flagsToRemove", "flagsToAdd", "removingGroup", "forEachSlotInRangeIndexed", "", "start", "end", "Lkotlin/Function2;", "Lkotlin/ParameterName;", "name", "([Ljava/lang/Object;IILkotlin/jvm/functions/Function2;)V", "slotRange", "Landroidx/compose/runtime/composer/linkbuffer/SlotRange;", "([Ljava/lang/Object;ILkotlin/jvm/functions/Function2;)V", "VisitSlotsInRememberOrderCallback", "runtime"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final class SlotTableEditor {
    public static final int $stable = 8;
    private final SlotTableAddressSpace addressSpace;
    private int current;
    private boolean isClosed;
    private int parent = -1;
    private int previousSibling = -1;
    private final SlotTable table;

    /* JADX INFO: compiled from: SlotTableEditor.kt */
    @Metadata(d1 = {"\u0000\u001c\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\b\n\u0002\u0018\u0002\n\u0002\b\u0003\bæ\u0080\u0001\u0018\u00002\u00020\u0001J&\u0010\u0002\u001a\u00020\u00032\n\u0010\u0004\u001a\u00060\u0005j\u0002`\u00062\u0006\u0010\u0007\u001a\u00020\u00052\b\u0010\b\u001a\u0004\u0018\u00010\u0001H&ø\u0001\u0000\u0082\u0002\u0006\n\u0004\b!0\u0001¨\u0006\tÀ\u0006\u0001"}, d2 = {"Landroidx/compose/runtime/composer/linkbuffer/SlotTableEditor$VisitSlotsInRememberOrderCallback;", "", "visit", "", "group", "", "Landroidx/compose/runtime/composer/linkbuffer/GroupAddress;", "slotIndex", Slot.ELEMENT, "runtime"}, k = 1, mv = {2, 1, 0}, xi = 48)
    public interface VisitSlotsInRememberOrderCallback {
        boolean visit(int group, int slotIndex, Object slot);
    }

    public SlotTableEditor(SlotTable slotTable) {
        this.table = slotTable;
        this.current = slotTable.getRoot();
        this.addressSpace = slotTable.getAddressSpace();
    }

    public final SlotTable getTable() {
        return this.table;
    }

    /* JADX INFO: renamed from: getAddressSpace$runtime, reason: from getter */
    public final SlotTableAddressSpace getAddressSpace() {
        return this.addressSpace;
    }

    /* JADX INFO: renamed from: getCurrentGroup, reason: from getter */
    public final int getCurrent() {
        return this.current;
    }

    /* JADX INFO: renamed from: getParentGroup, reason: from getter */
    public final int getParent() {
        return this.parent;
    }

    public final boolean isNode() {
        return (this.addressSpace.getGroups()[this.current + 4] & 8388608) == 8388608;
    }

    public final boolean isGroupEnd() {
        return this.current == -1;
    }

    /* JADX INFO: renamed from: isClosed, reason: from getter */
    public final boolean getIsClosed() {
        return this.isClosed;
    }

    public final boolean isEmpty() {
        return this.table.isEmpty();
    }

    public final int getGroupKey() {
        return this.addressSpace.getGroups()[this.current];
    }

    public final Object getObjectKey() {
        return objectKey(this.current);
    }

    public final Object getNode() {
        return node(this.current);
    }

    public final boolean isParentGroupANode() {
        return (this.addressSpace.getGroups()[this.parent + 4] & 8388608) == 8388608;
    }

    public final int getPreviousSibling() {
        return this.previousSibling;
    }

    public final int groupKey(int group) {
        return this.addressSpace.getGroups()[group];
    }

    public final Object objectKey(int group) {
        int[] groups = this.addressSpace.getGroups();
        int i = groups[group + 4];
        if ((i & 16777216) == 16777216) {
            return this.addressSpace.getSlots()[(groups[group + 5] >> 4) + Integer.bitCount(8388608 & i)];
        }
        return Composer.INSTANCE.getEmpty();
    }

    public final Object node(int group) {
        int[] groups = this.addressSpace.getGroups();
        if ((groups[group + 4] & 8388608) == 8388608) {
            return this.addressSpace.getSlots()[groups[group + 5] >> 4];
        }
        return null;
    }

    public static /* synthetic */ void updateNode$default(SlotTableEditor slotTableEditor, int i, Object obj, int i2, Object obj2) {
        if ((i2 & 1) != 0) {
            i = slotTableEditor.getCurrent();
        }
        slotTableEditor.updateNode(i, obj);
    }

    public final void updateNode(int group, Object newValue) {
        SlotTableAddressSpace slotTableAddressSpace = this.addressSpace;
        int[] groups = slotTableAddressSpace.getGroups();
        Object[] slots = slotTableAddressSpace.getSlots();
        int i = groups[group + 4];
        slots[groups[group + 5] >> 4] = newValue;
    }

    public final int flagsOf(int group) {
        return this.addressSpace.getGroups()[group + 4];
    }

    public final boolean isNode(int group) {
        return (flagsOf(group) & 8388608) == 8388608;
    }

    public final int nodeCountOf(int groups) {
        int i = this.addressSpace.getGroups()[groups + 4];
        if ((i & 8388608) == 8388608) {
            return 1;
        }
        return i & GroupFlagsSpec.CHILD_NODE_COUNT_MASK;
    }

    public final int parentOf(int group) {
        return this.addressSpace.getGroups()[group + 2];
    }

    public final int firstChildOf(int group) {
        return this.addressSpace.getGroups()[group + 3];
    }

    public final long handle() {
        return (((long) UInt.m12488constructorimpl(this.current)) & 4294967295L) | (((long) this.previousSibling) << 32);
    }

    public final int parentGroup(int groupAddress) {
        return this.addressSpace.getGroups()[groupAddress + 2];
    }

    public final void close() {
        if (this.isClosed) {
            return;
        }
        this.isClosed = true;
        this.table.closeEditor(this);
    }

    public final void startGroup() {
        int i = this.current;
        if (!(i > 0)) {
            ComposerKt.composeImmediateRuntimeError("Cannot start a group because current does not refer to a child of a group");
        }
        this.parent = i;
        int[] groups = this.addressSpace.getGroups();
        if (i + 6 > groups.length) {
            return;
        }
        this.current = groups[i + 3];
        this.previousSibling = -1;
    }

    public final void endGroup() {
        int i = this.parent;
        int[] groups = this.addressSpace.getGroups();
        if (i + 6 > groups.length) {
            return;
        }
        int i2 = groups[i + 1];
        this.parent = groups[i + 2];
        this.previousSibling = i;
        this.current = i2;
    }

    public static /* synthetic */ void removeGroup$default(SlotTableEditor slotTableEditor, boolean z, int i, Object obj) {
        if ((i & 1) != 0) {
            z = true;
        }
        slotTableEditor.removeGroup(z);
    }

    public final void removeGroup(boolean freeGroup) {
        int[] groups = this.addressSpace.getGroups();
        int i = this.current;
        int i2 = groups[i + 4];
        propagateChanges(i, -((i2 & 8388608) == 8388608 ? 1 : 8388607 & i2), GroupFlagsKt.propagatingFlagsOf(i2), 0, true);
        int i3 = groups[i + 1];
        int i4 = this.previousSibling;
        if (i4 == -1) {
            int i5 = this.parent;
            if (i5 == -1) {
                this.table.setRoot(i3);
            } else {
                groups[i5 + 3] = i3;
            }
        } else {
            groups[i4 + 1] = i3;
        }
        if (freeGroup) {
            this.addressSpace.freeGroupTree(i);
        }
        this.current = i3;
    }

    public final void insertGroupFrom(SlotTable insertTable, long handle) {
        if (!Intrinsics.areEqual(insertTable.getAddressSpace(), this.table.getAddressSpace())) {
            throw new IllegalArgumentException("Cannot insert a group from an unrelated table".toString());
        }
        SlotTableEditor slotTableEditorOpenEditor = insertTable.openEditor();
        try {
            slotTableEditorOpenEditor.seek(handle);
            slotTableEditorOpenEditor.removeGroup(false);
            Unit unit = Unit.INSTANCE;
            slotTableEditorOpenEditor.close();
            insertGroup(GroupHandleKt.getGroup(handle));
        } catch (Throwable th) {
            slotTableEditorOpenEditor.close();
            throw th;
        }
    }

    private final void insertGroup(int group) {
        int i = this.previousSibling;
        int i2 = this.parent;
        int[] groups = this.addressSpace.getGroups();
        if (i != -1) {
            groups[i + 1] = group;
        } else if (i2 == -1) {
            this.table.setRoot(group);
        } else {
            groups[i2 + 3] = group;
        }
        groups[group + 2] = i2;
        groups[group + 1] = this.current;
        int i3 = groups[group + 4];
        int i4 = (i3 & 8388608) != 8388608 ? i3 & GroupFlagsSpec.CHILD_NODE_COUNT_MASK : 1;
        this.current = group;
        propagateChanges(group, i4, 0, GroupFlagsKt.propagatingFlagsOf(i3), false);
    }

    public final void moveGroup(int offset) {
        if (offset == 0) {
            return;
        }
        int i = this.current;
        int i2 = this.previousSibling;
        int[] groups = this.addressSpace.getGroups();
        int i3 = 0;
        int i4 = i;
        int i5 = i2;
        while (i3 < offset) {
            int i6 = groups[i4 + 1];
            if (i6 == -1) {
                throw new IllegalStateException(("Offset(" + offset + ") too large").toString());
            }
            i3++;
            i5 = i4;
            i4 = i6;
        }
        int i7 = i4 + 1;
        groups[i5 + 1] = groups[i7];
        groups[i7] = i;
        if (i2 == -1) {
            groups[this.parent + 3] = i4;
        } else {
            groups[i2 + 1] = i4;
        }
        this.current = i4;
    }

    public final void moveGroup(long handle) {
        int i = this.current;
        int i2 = this.previousSibling;
        int group = GroupHandleKt.getGroup(handle);
        int context = GroupHandleKt.getContext(handle);
        int[] groups = this.addressSpace.getGroups();
        int i3 = this.parent;
        if ((context == -1 && groups[i3 + 3] != group) || (context != -1 && groups[context + 1] != group)) {
            context = i;
            while (context != -1) {
                int i4 = groups[context + 1];
                if (i4 == group) {
                    break;
                } else {
                    context = i4;
                }
            }
            if (context == -1) {
                throw new IllegalStateException(("Could not find the group previous to current(" + i + ')').toString());
            }
        }
        int i5 = group + 1;
        groups[context + 1] = groups[i5];
        groups[i5] = i;
        if (i2 == -1) {
            groups[i3 + 3] = group;
        } else {
            groups[i2 + 1] = group;
        }
        this.current = group;
    }

    public static /* synthetic */ void moveFrom$default(SlotTableEditor slotTableEditor, SlotTable slotTable, long j, long j2, int i, Object obj) {
        if ((i & 4) != 0) {
            j2 = -1;
        }
        slotTableEditor.moveFrom(slotTable, j, j2);
    }

    public static /* synthetic */ long moveFrom$default(SlotTableEditor slotTableEditor, SlotTableEditor slotTableEditor2, long j, long j2, int i, Object obj) {
        if ((i & 4) != 0) {
            j2 = -1;
        }
        return slotTableEditor.moveFrom(slotTableEditor2, j, j2);
    }

    public final long moveFrom(SlotTableEditor sourceEditor, long sourceHandle, long destination) {
        int group;
        long jHandle;
        sourceEditor.seek(sourceHandle);
        if (!Intrinsics.areEqual(sourceEditor.addressSpace, this.addressSpace)) {
            group = this.addressSpace.copyTreeFrom(sourceEditor.addressSpace, GroupHandleKt.getGroup(sourceHandle));
            sourceEditor.removeGroup(true);
        } else {
            group = GroupHandleKt.getGroup(sourceHandle);
            sourceEditor.removeGroup(false);
        }
        if (destination != -1) {
            jHandle = handle();
            seek(destination);
        } else {
            jHandle = -1;
        }
        int i = this.previousSibling;
        insertGroup(group);
        this.previousSibling = i;
        this.current = group;
        long jM12488constructorimpl = (((long) i) << 32) | (((long) UInt.m12488constructorimpl(group)) & 4294967295L);
        if (jHandle != -1) {
            seek(jHandle);
        }
        if (this.table.getRecordSourceInformation()) {
            this.addressSpace.recordMovedSourceInformation(group, i);
        }
        return jM12488constructorimpl;
    }

    public final int skipGroup() {
        int i = this.current;
        if (i == -1) {
            throw new IllegalStateException("Skipping past the end of a group".toString());
        }
        this.previousSibling = i;
        this.current = this.addressSpace.getGroups()[i + 1];
        int i2 = this.addressSpace.getGroups()[i + 4];
        if ((i2 & 8388608) == 8388608) {
            return 1;
        }
        return i2 & GroupFlagsSpec.CHILD_NODE_COUNT_MASK;
    }

    public final void skipToGroupEnd() {
        int i = this.current;
        if (i != -1) {
            int i2 = this.previousSibling;
            int[] groups = this.addressSpace.getGroups();
            while (i != -1) {
                i2 = i;
                i = groups[i + 1];
            }
            this.previousSibling = i2;
            this.current = -1;
        }
    }

    public final void seek(LinkAnchor anchor) {
        seek((((long) 0) << 32) | (((long) UInt.m12488constructorimpl(anchor.getAddress())) & 4294967295L));
    }

    public final void seek(long handle) {
        int root;
        containsHandle(handle);
        int context = GroupHandleKt.getContext(handle);
        int[] groups = this.addressSpace.getGroups();
        int group = GroupHandleKt.getGroup(handle);
        int i = group == -1 ? context : groups[group + 2];
        if (group == -1) {
            context = -1;
        }
        this.parent = i;
        this.current = group;
        if (context != -1 ? groups[context + 1] != group : !(i != -1 ? groups[i + 3] == group : this.table.getRoot() == group)) {
            if (i == -1) {
                root = this.table.getRoot();
            } else {
                root = groups[i + 3];
            }
            int[] groups2 = this.addressSpace.getGroups();
            int i2 = -1;
            while (root >= 0 && root != group) {
                i2 = root;
                root = groups2[root + 1];
            }
            context = i2;
        }
        if (context != -1) {
            int i3 = groups[context + 1];
        } else if (i == -1) {
            this.table.getRoot();
        } else {
            int i4 = groups[i + 3];
        }
        this.previousSibling = context;
    }

    public final void updateParentNode(Object node) {
        int[] groups = this.addressSpace.getGroups();
        int i = this.parent;
        int i2 = groups[i + 4];
        this.addressSpace.getSlots()[groups[i + 5] >> 4] = node;
    }

    public final void updateAux(Object value) {
        int[] groups = this.addressSpace.getGroups();
        int i = this.current;
        this.addressSpace.getSlots()[(groups[i + 5] >> 4) + Integer.bitCount(25165824 & groups[i + 4])] = value;
    }

    public final Object setAbsolute(int slotAddress, Object value) {
        Object[] slots = this.addressSpace.getSlots();
        if (slotAddress >= 0) {
            int length = slots.length;
        }
        Object obj = slots[slotAddress];
        slots[slotAddress] = value;
        return obj;
    }

    public final Object setRelative(int index, Object value) {
        return setAbsolute((this.addressSpace.getGroups()[this.parent + 5] >> 4) + index, value);
    }

    public final void appendSlot(Object value) {
        int[] groups = this.addressSpace.getGroups();
        int i = this.parent;
        int i2 = groups[i + 5];
        if (i2 == -1) {
            this.addressSpace.writeSlot(i, 0, value);
            return;
        }
        SlotTableAddressSpace slotTableAddressSpace = this.addressSpace;
        int i3 = (i2 & 15) + 1;
        int i4 = i2 >> 4;
        if (i3 > 15) {
            i3 = slotTableAddressSpace.getLargeSizes().get(i4);
        }
        this.addressSpace.writeSlot(i, i3, value);
    }

    public final void trimSlots(int slots) {
        int i;
        SlotTableAddressSpace slotTableAddressSpace = this.addressSpace;
        int i2 = this.parent;
        int[] groups = slotTableAddressSpace.getGroups();
        int i3 = groups[i2 + 5];
        if (i3 == -1) {
            i = 0;
        } else {
            i = (i3 & 15) + 1;
            if (i > 15) {
                i = slotTableAddressSpace.getLargeSizes().get(i3 >> 4);
            }
        }
        int i4 = i - slots;
        if (!(i4 >= GroupFlagsKt.utilitySlotsCountForFlags(groups[i2 + 4]))) {
            ComposerKt.composeImmediateRuntimeError("Attempted to trim more slots than the group has");
        }
        slotTableAddressSpace.resizeSlotRangeAtGroup(i2, i4);
    }

    public final boolean containsHandle(long groupHandle) {
        int group = GroupHandleKt.getGroup(groupHandle);
        if (group == -1) {
            group = GroupHandleKt.getContext(groupHandle);
        }
        if (group == -1) {
            return false;
        }
        int root = this.table.getRoot();
        int[] groups = this.addressSpace.getGroups();
        int[] groups2 = this.addressSpace.getGroups();
        int i = group;
        while (true) {
            if (i <= 0) {
                if (!(i != 0)) {
                    ComposerKt.composeImmediateRuntimeError("Traversing parent of group not in the slot table: " + group);
                }
                return false;
            }
            if (i == root) {
                return true;
            }
            if (i <= 0) {
                return false;
            }
            int i2 = i + 2;
            if (groups[i2] == -1) {
                int[] groups3 = this.addressSpace.getGroups();
                for (int i3 = root; i3 >= 0; i3 = groups3[i3 + 1]) {
                    if (i3 == i) {
                        return true;
                    }
                }
            }
            i = groups2[i2];
        }
    }

    public final SlotTable buildInsertTable(Function1<? super SlotTableBuilder, Unit> block) {
        SlotTable.Companion companion = SlotTable.INSTANCE;
        SlotTableBuilder slotTableBuilder = new SlotTableBuilder(getAddressSpace(), false, false);
        slotTableBuilder.buildStart();
        block.invoke(slotTableBuilder);
        return slotTableBuilder.build();
    }

    public final void bashGroup$runtime(int newKey) {
        this.addressSpace.getGroups()[getCurrent()] = newKey;
    }

    public final void visitSlotsInRememberOrder(int inGroup, VisitSlotsInRememberOrderCallback callback) {
        int i;
        if (inGroup < 0) {
            return;
        }
        int[] groups = this.addressSpace.getGroups();
        Object[] slots = this.addressSpace.getSlots();
        int i2 = groups[inGroup + 5];
        int i3 = -1;
        if (i2 != -1) {
            SlotTableAddressSpace slotTableAddressSpace = this.addressSpace;
            int i4 = (i2 & 15) + 1;
            int i5 = i2 >> 4;
            if (i4 > 15) {
                i4 = slotTableAddressSpace.getLargeSizes().get(i5);
            }
            int i6 = i4 + i5;
            for (int i7 = i5; i7 < i6; i7++) {
                int i8 = i7 - i5;
                Object obj = slots[i7];
                if (obj instanceof RememberObserverHolder) {
                    int address = LinkComposerKt.asLinkRememberObserverHolder((RememberObserverHolder) obj).getAfter().getAddress();
                    while (i3 != address) {
                        if (i3 < 0) {
                            i3 = groups[inGroup + 3];
                        } else {
                            i3 = groups[i3 + 1];
                        }
                        if (!(i3 >= 0)) {
                            ComposerKt.composeImmediateRuntimeError("A RememberObserver cannot be forgotten correctly because its group ordering metadata is inconsistent with the rest of the SlotTable");
                        }
                        visitSlotsInRememberOrder(i3, callback);
                    }
                }
                if (callback.visit(inGroup, i8, obj)) {
                    slots[i8 + i5] = Composer.INSTANCE.getEmpty();
                }
            }
        }
        if (i3 < 0) {
            i = groups[inGroup + 3];
        } else {
            i = groups[i3 + 1];
        }
        while (i >= 0) {
            visitSlotsInRememberOrder(i, callback);
            i = groups[i + 1];
        }
    }

    public final void visitTailSlotsInRememberOrder$runtime(int inGroup, int firstTailGroupToVisit, int tailSlots, VisitSlotsInRememberOrderCallback callback) {
        int i;
        int i2;
        if (inGroup < 0) {
            return;
        }
        int[] groups = this.addressSpace.getGroups();
        Object[] slots = this.addressSpace.getSlots();
        int i3 = groups[inGroup + 5];
        int i4 = i3 >> 4;
        SlotTableAddressSpace slotTableAddressSpace = this.addressSpace;
        int i5 = -1;
        if (i3 == -1) {
            i = 0;
        } else {
            i = (i3 & 15) + 1;
            if (i > 15) {
                i = slotTableAddressSpace.getLargeSizes().get(i4);
            }
        }
        int i6 = (i + i4) - tailSlots;
        int i7 = i6 + tailSlots;
        boolean z = false;
        for (int i8 = i6; i8 < i7; i8++) {
            int i9 = i8 - i6;
            Object obj = slots[i8];
            if (obj instanceof RememberObserverHolder) {
                int address = LinkComposerKt.asLinkRememberObserverHolder((RememberObserverHolder) obj).getAfter().getAddress();
                while (i5 != address) {
                    if (i5 < 0) {
                        i5 = groups[inGroup + 3];
                    } else {
                        i5 = groups[i5 + 1];
                    }
                    if (!(i5 >= 0)) {
                        ComposerKt.composeImmediateRuntimeError("A RememberObserver cannot be forgotten correctly because its group ordering metadata is inconsistent with the rest of the SlotTable");
                    }
                    z |= firstTailGroupToVisit == i5;
                    if (z) {
                        visitSlotsInRememberOrder(i5, callback);
                    }
                }
            }
            if (callback.visit(inGroup, i9, obj)) {
                slots[i9 + i4] = Composer.INSTANCE.getEmpty();
            }
        }
        if (i5 < 0) {
            i2 = groups[inGroup + 3];
        } else {
            i2 = groups[i5 + 1];
        }
        while (i2 >= 0) {
            z |= firstTailGroupToVisit == i2;
            if (z) {
                visitSlotsInRememberOrder(i2, callback);
            }
            i2 = groups[i2 + 1];
        }
    }

    public final void removeAllInstancesOfFlags(int flags) {
        boolean z;
        int iPropagatingFlagsOf = flags | GroupFlagsKt.propagatingFlagsOf(flags);
        SlotTableAddressSpace slotTableAddressSpace = this.addressSpace;
        int[] groups = slotTableAddressSpace.getGroups();
        int root = this.table.getRoot();
        if (root < 0) {
            return;
        }
        IntStack intStack = new IntStack();
        int[] groups2 = slotTableAddressSpace.getGroups();
        while (true) {
            int i = root + 4;
            int i2 = groups[i];
            if ((iPropagatingFlagsOf & i2) == 0) {
                z = false;
            } else {
                groups[i] = i2 & (~iPropagatingFlagsOf);
                z = true;
            }
            int i3 = groups2[root + 1];
            if (i3 >= 0) {
                intStack.push(i3);
            }
            root = groups2[root + 3];
            if (!z || root < 0) {
                if (intStack.tos == 0) {
                    return;
                } else {
                    root = intStack.pop();
                }
            }
        }
    }

    public final void reset() {
        this.parent = -1;
        this.previousSibling = -1;
        this.current = this.table.getRoot();
    }

    private final void propagateChanges(int group, int nodeCountDelta, int flagsToRemove, int flagsToAdd, boolean removingGroup) {
        int i;
        int i2;
        int[] groups = this.addressSpace.getGroups();
        int[] groups2 = this.addressSpace.getGroups();
        int i3 = groups2[group + 2];
        while (true) {
            if (i3 <= 0) {
                if (i3 != 0) {
                    return;
                }
                ComposerKt.composeImmediateRuntimeError("Traversing parent of group not in the slot table: " + group);
                return;
            }
            int i4 = i3 + 4;
            int i5 = groups[i4];
            if (nodeCountDelta != 0) {
                i5 = (i5 & (-8388608)) | ((8388607 & i5) + nodeCountDelta);
                groups[i4] = i5;
                if ((i5 & 8388608) == 8388608) {
                    nodeCountDelta = 0;
                }
            }
            if (flagsToRemove == 0) {
                i = 0;
                break;
            }
            int i6 = (flagsToRemove >> 1) | flagsToRemove;
            int[] groups3 = this.addressSpace.getGroups();
            for (int i7 = groups3[i3 + 3]; i7 > 0; i7 = groups3[i7 + 1]) {
                if ((!removingGroup || i7 != group) && (groups[i7 + 4] & i6) != 0) {
                    i = 0;
                    break;
                }
            }
            i = flagsToRemove;
            if ((i == 0 && flagsToAdd == 0) || (i2 = ((~i) & i5) | flagsToAdd) == i5) {
                flagsToAdd = 0;
            } else {
                groups[i4] = i2;
                flagsToRemove = i;
            }
            if (nodeCountDelta == 0 && flagsToRemove == 0 && flagsToAdd == 0) {
                return;
            } else {
                i3 = groups2[i3 + 2];
            }
        }
    }

    private final void forEachSlotInRangeIndexed(Object[] objArr, int i, int i2, Function2<? super Integer, Object, Unit> function2) {
        for (int i3 = i; i3 < i2; i3++) {
            function2.invoke(Integer.valueOf(i3 - i), objArr[i3]);
        }
    }

    private final void forEachSlotInRangeIndexed(Object[] objArr, int i, Function2<? super Integer, Object, Unit> function2) {
        if (i != -1) {
            SlotTableAddressSpace slotTableAddressSpace = this.addressSpace;
            int i2 = (i & 15) + 1;
            int i3 = i >> 4;
            if (i2 > 15) {
                i2 = slotTableAddressSpace.getLargeSizes().get(i3);
            }
            int i4 = i2 + i3;
            for (int i5 = i3; i5 < i4; i5++) {
                function2.invoke(Integer.valueOf(i5 - i3), objArr[i5]);
            }
        }
    }

    public final void moveFrom(SlotTable sourceTable, long sourceHandle, long destination) {
        SlotTableEditor slotTableEditorOpenEditor = sourceTable.openEditor();
        try {
            moveFrom(slotTableEditorOpenEditor, sourceHandle, destination);
        } finally {
            slotTableEditorOpenEditor.close();
        }
    }

    public final void addFlagsToAllGroupsIn(IntSet groupSet, int flags) {
        int[] iArr = groupSet.elements;
        long[] jArr = groupSet.metadata;
        int length = jArr.length - 2;
        if (length < 0) {
            return;
        }
        int i = 0;
        while (true) {
            long j = jArr[i];
            if ((((~j) << 7) & j & (-9187201950435737472L)) != -9187201950435737472L) {
                int i2 = 8 - ((~(i - length)) >>> 31);
                for (int i3 = 0; i3 < i2; i3++) {
                    if ((255 & j) < 128) {
                        propagateChanges(iArr[(i << 3) + i3], 0, 0, flags, false);
                    }
                    j >>= 8;
                }
                if (i2 != 8) {
                    return;
                }
            }
            if (i == length) {
                return;
            } else {
                i++;
            }
        }
    }
}
