package androidx.compose.runtime.composer.linkbuffer;

import androidx.collection.IntSetKt;
import androidx.collection.MutableIntSet;
import androidx.compose.runtime.ComposerKt;
import androidx.compose.runtime.tooling.ComposeStackTraceBuilder;
import androidx.compose.runtime.tooling.ComposeStackTraceFrame;
import java.util.List;
import kotlin.Metadata;
import kotlin.collections.ArraysKt;
import kotlin.jvm.internal.Intrinsics;
import org.jivesoftware.smack.packet.Message;

/* JADX INFO: compiled from: SlotTableAddresSpace.kt */
/* JADX INFO: loaded from: classes.dex */
@Metadata(d1 = {"\u0000b\n\u0000\n\u0002\u0010\b\n\u0002\b\u0013\n\u0002\u0010\u0015\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u0002\n\u0002\b\u0004\n\u0002\u0010\u0011\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0002\b\f\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0005\u001a\u0019\u0010\u0014\u001a\u00020\u0001*\u00020\u00152\n\u0010\u0016\u001a\u00060\u0001j\u0002`\u0017H\u0080\b\u001a\u0019\u0010\u0018\u001a\u00020\u0001*\u00020\u00152\n\u0010\u0016\u001a\u00060\u0001j\u0002`\u0017H\u0080\b\u001a\u0019\u0010\u0019\u001a\u00020\u0001*\u00020\u00152\n\u0010\u0016\u001a\u00060\u0001j\u0002`\u0017H\u0080\b\u001a\u0019\u0010\u001a\u001a\u00020\u0001*\u00020\u00152\n\u0010\u0016\u001a\u00060\u0001j\u0002`\u0017H\u0080\b\u001a\u0019\u0010\u001b\u001a\u00020\u0001*\u00020\u00152\n\u0010\u0016\u001a\u00060\u0001j\u0002`\u0017H\u0080\b\u001a\u0019\u0010\u001c\u001a\u00020\u0001*\u00020\u00152\n\u0010\u0016\u001a\u00060\u0001j\u0002`\u0017H\u0080\b\u001a!\u0010\u0014\u001a\u00020\u001d*\u00020\u00152\n\u0010\u0016\u001a\u00060\u0001j\u0002`\u00172\u0006\u0010\u001e\u001a\u00020\u0001H\u0080\b\u001a!\u0010\u0018\u001a\u00020\u001d*\u00020\u00152\n\u0010\u0016\u001a\u00060\u0001j\u0002`\u00172\u0006\u0010\u001e\u001a\u00020\u0001H\u0080\b\u001a!\u0010\u0019\u001a\u00020\u001d*\u00020\u00152\n\u0010\u0016\u001a\u00060\u0001j\u0002`\u00172\u0006\u0010\u001e\u001a\u00020\u0001H\u0080\b\u001a!\u0010\u001a\u001a\u00020\u001d*\u00020\u00152\n\u0010\u0016\u001a\u00060\u0001j\u0002`\u00172\u0006\u0010\u001e\u001a\u00020\u0001H\u0080\b\u001a!\u0010\u001b\u001a\u00020\u001d*\u00020\u00152\n\u0010\u0016\u001a\u00060\u0001j\u0002`\u00172\u0006\u0010\u001e\u001a\u00020\u0001H\u0080\b\u001a\u0019\u0010\u001f\u001a\u00020\u0001*\u00020\u00152\n\u0010\u0016\u001a\u00060\u0001j\u0002`\u0017H\u0080\b\u001a\u0019\u0010 \u001a\u00020\u0001*\u00020\u00152\n\u0010\u0016\u001a\u00060\u0001j\u0002`\u0017H\u0080\b\u001a!\u0010 \u001a\u00020\u0001*\u00020\u00152\n\u0010\u0016\u001a\u00060\u0001j\u0002`\u00172\u0006\u0010\u001e\u001a\u00020\u0001H\u0080\b\u001a!\u0010\u001c\u001a\u00020\u001d*\u00020\u00152\n\u0010\u0016\u001a\u00060\u0001j\u0002`\u00172\u0006\u0010\u001e\u001a\u00020\u0001H\u0080\b\u001a2\u0010!\u001a\u00020\u001d*\n\u0012\u0006\u0012\u0004\u0018\u00010#0\"2\n\u0010$\u001a\u00060\u0001j\u0002`%2\n\u0010&\u001a\u00060\u0001j\u0002`%H\u0082\b¢\u0006\u0002\u0010'\u001a\u0010\u0010(\u001a\u00020\u00152\u0006\u0010)\u001a\u00020\u0001H\u0002\u001a\u0016\u0010*\u001a\u00020\u001d*\u0004\u0018\u00010\u00152\u0006\u0010+\u001a\u00020\u0001H\u0002\u001a\u001d\u0010,\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010#0\"2\u0006\u0010)\u001a\u00020\u0001H\u0002¢\u0006\u0002\u0010-\u001a2\u0010.\u001a\u00060\u0001j\u0002`\u0017*\u0004\u0018\u00010\u00152\u0006\u0010/\u001a\u00020\u00012\n\u00100\u001a\u00060\u0001j\u0002`\u00172\n\u00101\u001a\u00060\u0001j\u0002`2H\u0002\u001a\f\u00103\u001a\u00020\u0001*\u00020\u0015H\u0002\u001a\u0015\u00104\u001a\u00020\u00012\n\u00105\u001a\u00060\u0001j\u0002`6H\u0080\b\u001a\u0015\u00107\u001a\u00020\u00012\n\u00105\u001a\u00060\u0001j\u0002`6H\u0080\b\u001a\u0011\u00108\u001a\u0002092\u0006\u0010:\u001a\u00020\u0001H\u0080\b\u001a\u001c\u0010;\u001a\u00020\u00012\n\u0010\u0016\u001a\u00060\u0001j\u0002`%2\u0006\u0010:\u001a\u00020\u0001H\u0000\u001a0\u0010<\u001a\b\u0012\u0004\u0012\u00020>0=*\u00020?2\n\u0010@\u001a\u00060\u0001j\u0002`\u00172\b\u0010A\u001a\u0004\u0018\u00010#2\u0006\u0010B\u001a\u00020CH\u0000\u001a*\u0010D\u001a\u000209*\n\u0012\u0006\u0012\u0004\u0018\u00010#0\"2\u0006\u0010$\u001a\u00020\u00012\u0006\u0010:\u001a\u00020\u0001H\u0082\b¢\u0006\u0002\u0010E\u001a\u0012\u0010F\u001a\u0002092\b\u0010\u001e\u001a\u0004\u0018\u00010#H\u0000\"\u000e\u0010\u0000\u001a\u00020\u0001X\u0080T¢\u0006\u0002\n\u0000\"\u000e\u0010\u0002\u001a\u00020\u0001X\u0080T¢\u0006\u0002\n\u0000\"\u000e\u0010\u0003\u001a\u00020\u0001X\u0080T¢\u0006\u0002\n\u0000\"\u000e\u0010\u0004\u001a\u00020\u0001X\u0082T¢\u0006\u0002\n\u0000\"\u000e\u0010\u0005\u001a\u00020\u0001X\u0082T¢\u0006\u0002\n\u0000\"\u000e\u0010\u0006\u001a\u00020\u0001X\u0082T¢\u0006\u0002\n\u0000\"\u000e\u0010\u0007\u001a\u00020\u0001X\u0082T¢\u0006\u0002\n\u0000\"\u000e\u0010\b\u001a\u00020\u0001X\u0082T¢\u0006\u0002\n\u0000\"\u000e\u0010\t\u001a\u00020\u0001X\u0082T¢\u0006\u0002\n\u0000\"\u000e\u0010\n\u001a\u00020\u0001X\u0080T¢\u0006\u0002\n\u0000\"\u000e\u0010\u000b\u001a\u00020\u0001X\u0082T¢\u0006\u0002\n\u0000\"\u000e\u0010\f\u001a\u00020\u0001X\u0082T¢\u0006\u0002\n\u0000\"\u000e\u0010\r\u001a\u00020\u0001X\u0080T¢\u0006\u0002\n\u0000\"\u000e\u0010\u000e\u001a\u00020\u0001X\u0082T¢\u0006\u0002\n\u0000\"\u000e\u0010\u000f\u001a\u00020\u0001X\u0082T¢\u0006\u0002\n\u0000\"\u000e\u0010\u0010\u001a\u00020\u0001X\u0082T¢\u0006\u0002\n\u0000\"\u000e\u0010G\u001a\u00020#X\u0082\u0004¢\u0006\u0002\n\u0000*\f\b\u0000\u0010\u0011\"\u00020\u00012\u00020\u0001*\f\b\u0000\u0010\u0012\"\u00020\u00012\u00020\u0001*\f\b\u0000\u0010\u0013\"\u00020\u00012\u00020\u0001¨\u0006H"}, d2 = {"NULL_ADDRESS", "", "LAZY_ADDRESS", "SLOT_TABLE_GROUP_SIZE", "SLOT_TABLE_GROUP_KEY_OFFSET", "SLOT_TABLE_GROUP_NEXT_OFFSET", "SLOT_TABLE_GROUP_PARENT_OFFSET", "SLOT_TABLE_GROUP_CHILD_OFFSET", "SLOT_TABLE_GROUP_FLAGS_OFFSET", "SLOT_TABLE_GROUP_SLOTS_OFFSET", "SLOT_TABLE_SLOT_SHIFT", "SLOT_TABLE_SLOT_SMALL_SIZE_MASK", "SLOT_TABLE_SLOT_LARGE_SENTINEL", "SLOT_TABLE_SLOT_MAX_SMALL_SIZE", "SLOT_TABLE_SLOT_MOVE_BUFFER_SIZE", "SLOT_TABLE_INITIAL_GROUPS_SIZE", "SLOT_TABLE_INITIAL_SLOTS_SIZE", "GroupAddress", "SlotAddress", "SlotRange", "groupKey", "", "address", "Landroidx/compose/runtime/composer/linkbuffer/GroupAddress;", "groupNext", "groupParent", "groupChild", "groupFlags", "groupSlotRange", "", "value", "groupNodeCount", "groupChildNodeCount", "clearRange", "", "", "start", "Landroidx/compose/runtime/composer/linkbuffer/SlotAddress;", "end", "([Ljava/lang/Object;II)V", "newGroupsArray", "capacity", "initGroups", "offset", "newSlotsArray", "(I)[Ljava/lang/Object;", "groupAllocate", "key", Message.Thread.PARENT_ATTRIBUTE_NAME, "flags", "Landroidx/compose/runtime/composer/linkbuffer/GroupFlags;", "validateFreeList", "slotAddressOf", "slotRange", "Landroidx/compose/runtime/composer/linkbuffer/SlotRange;", "slotSmallSizeOf", "isLargeSlotRangeSize", "", "size", "slotRangeFromAddressAndSize", "buildTrace", "", "Landroidx/compose/runtime/tooling/ComposeStackTraceFrame;", "Landroidx/compose/runtime/composer/linkbuffer/SlotTableAddressSpace;", "group", "child", "traceBuilder", "Landroidx/compose/runtime/tooling/ComposeStackTraceBuilder;", "allUnallocated", "([Ljava/lang/Object;II)Z", "isUnallocated", "Unallocated", "runtime"}, k = 2, mv = {2, 1, 0}, xi = 48)
public final class SlotTableAddresSpaceKt {
    public static final int LAZY_ADDRESS = 0;
    public static final int NULL_ADDRESS = -1;
    private static final int SLOT_TABLE_GROUP_CHILD_OFFSET = 3;
    private static final int SLOT_TABLE_GROUP_FLAGS_OFFSET = 4;
    private static final int SLOT_TABLE_GROUP_KEY_OFFSET = 0;
    private static final int SLOT_TABLE_GROUP_NEXT_OFFSET = 1;
    private static final int SLOT_TABLE_GROUP_PARENT_OFFSET = 2;
    public static final int SLOT_TABLE_GROUP_SIZE = 6;
    private static final int SLOT_TABLE_GROUP_SLOTS_OFFSET = 5;
    private static final int SLOT_TABLE_INITIAL_GROUPS_SIZE = 768;
    private static final int SLOT_TABLE_INITIAL_SLOTS_SIZE = 256;
    private static final int SLOT_TABLE_SLOT_LARGE_SENTINEL = 15;
    public static final int SLOT_TABLE_SLOT_MAX_SMALL_SIZE = 15;
    private static final int SLOT_TABLE_SLOT_MOVE_BUFFER_SIZE = 8;
    public static final int SLOT_TABLE_SLOT_SHIFT = 4;
    private static final int SLOT_TABLE_SLOT_SMALL_SIZE_MASK = 15;
    private static final Object Unallocated = new Object() { // from class: androidx.compose.runtime.composer.linkbuffer.SlotTableAddresSpaceKt$Unallocated$1
        public String toString() {
            return "Unallocated";
        }
    };

    public static final boolean isLargeSlotRangeSize(int i) {
        return i > 15;
    }

    public static final int slotAddressOf(int i) {
        return i >> 4;
    }

    public static final int slotRangeFromAddressAndSize(int i, int i2) {
        return (i << 4) | (i2 <= 15 ? i2 - 1 : 15);
    }

    public static final int slotSmallSizeOf(int i) {
        return (i & 15) + 1;
    }

    public static final int groupKey(int[] iArr, int i) {
        return iArr[i];
    }

    public static final int groupNext(int[] iArr, int i) {
        return iArr[i + 1];
    }

    public static final int groupParent(int[] iArr, int i) {
        return iArr[i + 2];
    }

    public static final int groupChild(int[] iArr, int i) {
        return iArr[i + 3];
    }

    public static final int groupFlags(int[] iArr, int i) {
        return iArr[i + 4];
    }

    public static final int groupSlotRange(int[] iArr, int i) {
        return iArr[i + 5];
    }

    public static final void groupKey(int[] iArr, int i, int i2) {
        iArr[i] = i2;
    }

    public static final void groupNext(int[] iArr, int i, int i2) {
        iArr[i + 1] = i2;
    }

    public static final void groupParent(int[] iArr, int i, int i2) {
        iArr[i + 2] = i2;
    }

    public static final void groupChild(int[] iArr, int i, int i2) {
        iArr[i + 3] = i2;
    }

    public static final void groupFlags(int[] iArr, int i, int i2) {
        iArr[i + 4] = i2;
    }

    public static final void groupSlotRange(int[] iArr, int i, int i2) {
        iArr[i + 5] = i2;
    }

    private static final void clearRange(Object[] objArr, int i, int i2) {
        if (i2 == i + 1) {
            objArr[i] = Unallocated;
        } else {
            ArraysKt.fill(objArr, Unallocated, i, i2);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final int[] newGroupsArray(int i) {
        int[] iArr = new int[i];
        iArr[1] = -1;
        initGroups(iArr, 6);
        return iArr;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Object[] newSlotsArray(int i) {
        Object[] objArr = new Object[i];
        ArraysKt.fill$default(objArr, Unallocated, 0, 0, 6, (Object) null);
        return objArr;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final int groupAllocate(int[] iArr, int i, int i2, int i3) {
        if (iArr == null || iArr.length < 6) {
            return -1;
        }
        int i4 = iArr[3];
        if (i4 >= iArr.length) {
            i4 = iArr[1];
            if (i4 < 0) {
                return -1;
            }
            iArr[1] = iArr[i4 + 1];
        } else {
            iArr[3] = i4 + 6;
        }
        iArr[i4] = i;
        iArr[i4 + 2] = i2;
        iArr[i4 + 1] = -1;
        iArr[i4 + 3] = -1;
        iArr[i4 + 4] = i3;
        iArr[i4 + 5] = -1;
        return i4;
    }

    private static final boolean allUnallocated(Object[] objArr, int i, int i2) {
        int i3 = i2 + i;
        if (i3 >= objArr.length) {
            return false;
        }
        while (i < i3) {
            if (objArr[i] != Unallocated) {
                return false;
            }
            i++;
        }
        return true;
    }

    public static final boolean isUnallocated(Object obj) {
        return Intrinsics.areEqual(obj, Unallocated);
    }

    public static final int groupNodeCount(int[] iArr, int i) {
        int i2 = iArr[i + 4];
        if ((i2 & 8388608) == 8388608) {
            return 1;
        }
        return i2 & GroupFlagsSpec.CHILD_NODE_COUNT_MASK;
    }

    public static final int groupChildNodeCount(int[] iArr, int i) {
        return iArr[i + 4] & GroupFlagsSpec.CHILD_NODE_COUNT_MASK;
    }

    public static final int groupChildNodeCount(int[] iArr, int i, int i2) {
        int i3 = i + 4;
        int i4 = i2 | (iArr[i3] & (-8388608));
        iArr[i3] = i4;
        return i4;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void initGroups(int[] iArr, int i) {
        if (iArr == null) {
            return;
        }
        iArr[1] = -1;
        iArr[3] = i;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final int validateFreeList(int[] iArr) {
        int i = iArr[1];
        MutableIntSet mutableIntSetMutableIntSetOf = IntSetKt.mutableIntSetOf();
        while (i >= 1) {
            if (mutableIntSetMutableIntSetOf.contains(i)) {
                throw new IllegalStateException(("Loop at " + i).toString());
            }
            mutableIntSetMutableIntSetOf.add(i);
            int i2 = iArr[i + 1];
            if (i2 == -1) {
                break;
            }
            if (i2 % 6 != 0 || i2 < 0) {
                throw new IllegalStateException(("Invalid free link at " + i).toString());
            }
            i = i2;
        }
        return mutableIntSetMutableIntSetOf.getSize();
    }

    public static final List<ComposeStackTraceFrame> buildTrace(SlotTableAddressSpace slotTableAddressSpace, int i, Object obj, ComposeStackTraceBuilder composeStackTraceBuilder) {
        int[] groups = slotTableAddressSpace.getGroups();
        int i2 = i;
        while (i2 > 0) {
            int i3 = slotTableAddressSpace.getGroups()[i2 + 4];
            composeStackTraceBuilder.processEdge(slotTableAddressSpace.getGroups()[i2], (i3 & 16777216) == 16777216 ? slotTableAddressSpace.getSlots()[(slotTableAddressSpace.getGroups()[i2 + 5] >> 4) + Integer.bitCount(i3 & 8388608)] : null, slotTableAddressSpace.sourceInformationOf(i2), obj);
            obj = slotTableAddressSpace.anchorOfAddress(i2);
            i2 = groups[i2 + 2];
        }
        if (!(i2 != 0)) {
            ComposerKt.composeImmediateRuntimeError("Traversing parent of group not in the slot table: " + i);
        }
        return composeStackTraceBuilder.trace();
    }
}
