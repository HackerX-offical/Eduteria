package androidx.compose.runtime;

import androidx.collection.MutableScatterMap;
import androidx.collection.MutableScatterSet;
import androidx.collection.ScatterSet;
import androidx.collection.ScatterSetKt;
import androidx.compose.runtime.LinkComposer;
import androidx.compose.runtime.collection.MultiValueMap;
import androidx.compose.runtime.composer.linkbuffer.GroupHandleKt;
import androidx.compose.runtime.composer.linkbuffer.SlotTable;
import androidx.compose.runtime.composer.linkbuffer.SlotTableAddressSpace;
import androidx.compose.runtime.composer.linkbuffer.SlotTableReader;
import androidx.exifinterface.media.ExifInterface;
import java.util.ArrayList;
import java.util.List;
import kotlin.KotlinNothingValueException;
import kotlin.Metadata;
import kotlin.UInt;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import org.jivesoftware.smack.packet.Message;

/* JADX INFO: compiled from: LinkComposer.kt */
/* JADX INFO: loaded from: classes.dex */
@Metadata(d1 = {"\u0000\u0096\u0001\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\t\n\u0000\n\u0002\u0010\u000b\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\b\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u000e\n\u0002\u0018\u0002\n\u0002\b\u0005\u001a\u0014\u0010\u0007\u001a\u00060\u0002j\u0002`\u0001*\u00060\u0002j\u0002`\u0001H\u0002\u001a\u0015\u0010\b\u001a\u00060\u0002j\u0002`\u0001*\u00060\u0002j\u0002`\u0005H\u0082\b\u001a\u0015\u0010\b\u001a\u00060\u0002j\u0002`\u0001*\u00060\tj\u0002`\nH\u0082\b\u001a\f\u0010\u000b\u001a\u00020\f*\u00020\rH\u0000\u001a\f\u0010\u000e\u001a\u00020\u000f*\u00020\u0010H\u0000\u001a\f\u0010\u000e\u001a\u00020\u0011*\u00020\u0012H\u0000\u001a\u001b\u0010\u0013\u001a\u0004\u0018\u00010\t*\u00020\u00142\u0006\u0010\u0015\u001a\u00020\u0016H\u0000¢\u0006\u0002\u0010\u0017\u001aE\u0010\u0018\u001a\u0014\u0012\u0010\u0012\u000e\u0012\u0004\u0012\u00020\u001b\u0012\u0004\u0012\u00020\u001c0\u001a0\u0019*\u00020\u001d2\n\u0010\u001e\u001a\u00060\tj\u0002`\n2\u0012\u0010\u001f\u001a\u000e\u0012\u0004\u0012\u00020\u001b\u0012\u0004\u0012\u00020\u001c0 H\u0000¢\u0006\u0004\b!\u0010\"\u001a\u001a\u0010#\u001a\u0004\u0018\u00010\u001b*\u00020\u001d2\n\u0010\u001e\u001a\u00060\tj\u0002`\nH\u0000\u001a4\u0010$\u001a\b\u0012\u0004\u0012\u0002H&0%\"\u0004\b\u0000\u0010&2\u001d\u0010'\u001a\u0019\u0012\n\u0012\b\u0012\u0004\u0012\u0002H&0)\u0012\u0004\u0012\u00020*0(¢\u0006\u0002\b+H\u0082\b\u001a5\u0010,\u001a\u000e\u0012\u0004\u0012\u0002H.\u0012\u0004\u0012\u0002H/0-\"\b\b\u0000\u0010.*\u00020\u001c\"\b\b\u0001\u0010/*\u00020\u001c2\u0006\u00100\u001a\u00020\tH\u0002¢\u0006\u0002\u00101\u001a(\u00102\u001a\u0004\u0018\u00010\u001c2\b\u00103\u001a\u0004\u0018\u00010\u001c2\b\u00104\u001a\u0004\u0018\u00010\u001c2\b\u00105\u001a\u0004\u0018\u00010\u001cH\u0002\u001a\f\u00106\u001a\u00020\t*\u00020\u0004H\u0002\u001a\f\u00107\u001a\u00020\u0004*\u00020\tH\u0002\u001a(\u00108\u001a\u00060\u0002j\u0002`\u0001*\u00020\u00142\n\u00109\u001a\u00060\u0002j\u0002`\u00012\n\u0010:\u001a\u00060\u0002j\u0002`\u0001H\u0002\u001a4\u0010;\u001a\u00060\tj\u0002`\n*\u00020<2\n\u0010=\u001a\u00060\tj\u0002`\n2\n\u00109\u001a\u00060\tj\u0002`\n2\n\u0010:\u001a\u00060\tj\u0002`\nH\u0002\u001a%\u0010>\u001a\u00020\u0004*\u00020<2\n\u0010=\u001a\u00060\tj\u0002`\n2\n\u0010?\u001a\u00060\tj\u0002`\nH\u0082\b\u001a \u0010@\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010\u001c0\u0019*\u00020\u00142\n\u0010\u001e\u001a\u00060\tj\u0002`\nH\u0002\"\u001c\u0010\u0003\u001a\u00020\u0004*\u00060\u0002j\u0002`\u00058BX\u0082\u0004¢\u0006\u0006\u001a\u0004\b\u0003\u0010\u0006*\u0010\b\u0002\u0010\u0000\"\u0002`\u00012\u00060\u0002j\u0002`\u0001¨\u0006A"}, d2 = {"VirtualGroupHandle", "Landroidx/compose/runtime/composer/linkbuffer/GroupHandle;", "", "isInsertHandle", "", "Landroidx/compose/runtime/VirtualGroupHandle;", "(J)Z", "toInsertAddress", "toGroupHandle", "", "Landroidx/compose/runtime/composer/linkbuffer/GroupAddress;", "asLinkComposer", "Landroidx/compose/runtime/LinkComposer;", "Landroidx/compose/runtime/Composer;", "asLinkRememberObserverHolder", "Landroidx/compose/runtime/LinkRememberObserverHolder;", "Landroidx/compose/runtime/RememberObserverHolder;", "Landroidx/compose/runtime/ReusableLinkRememberObserverHolder;", "Landroidx/compose/runtime/ReusableRememberObserverHolder;", "findSubcompositionContextGroup", "Landroidx/compose/runtime/composer/linkbuffer/SlotTable;", "context", "Landroidx/compose/runtime/CompositionContext;", "(Landroidx/compose/runtime/composer/linkbuffer/SlotTable;Landroidx/compose/runtime/CompositionContext;)Ljava/lang/Integer;", "findInvalidations", "", "Lkotlin/Pair;", "Landroidx/compose/runtime/RecomposeScopeImpl;", "", "Landroidx/compose/runtime/composer/linkbuffer/SlotTableReader;", "group", "invalidations", "Landroidx/compose/runtime/collection/ScopeMap;", "findInvalidations-Vpaz1Sg", "(Landroidx/compose/runtime/composer/linkbuffer/SlotTableReader;ILandroidx/collection/MutableScatterMap;)Ljava/util/List;", "getRecomposeScopeOrNull", "buildScatterSet", "Landroidx/collection/ScatterSet;", ExifInterface.GPS_DIRECTION_TRUE, "builderAction", "Lkotlin/Function1;", "Landroidx/collection/MutableScatterSet;", "", "Lkotlin/ExtensionFunctionType;", "multiMap", "Landroidx/compose/runtime/collection/MultiValueMap;", "K", ExifInterface.GPS_MEASUREMENT_INTERRUPTED, "initialCapacity", "(I)Landroidx/collection/MutableScatterMap;", "getKey", "value", "left", "right", "asInt", "asBool", "firstGroupInTopologicalOrder", "a", "b", "findFirstSibling", "Landroidx/compose/runtime/composer/linkbuffer/SlotTableAddressSpace;", Message.Thread.PARENT_ATTRIBUTE_NAME, "childOf", "child", "collectNodesFrom", "runtime"}, k = 2, mv = {2, 1, 0}, xi = 48)
public final class LinkComposerKt {
    /* JADX INFO: Access modifiers changed from: private */
    public static final boolean asBool(int i) {
        return i != 0;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final int asInt(boolean z) {
        return z ? 1 : 0;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final boolean isInsertHandle(long j) {
        return GroupHandleKt.getGroup(j) < -8;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final long toInsertAddress(long j) {
        int context = GroupHandleKt.getContext(j);
        return (((long) UInt.m12488constructorimpl((-10) - GroupHandleKt.getGroup(j))) & 4294967295L) | (((long) context) << 32);
    }

    private static final long toGroupHandle(long j) {
        isInsertHandle(j);
        return j;
    }

    public static final LinkComposer asLinkComposer(Composer composer) {
        LinkComposer linkComposer = composer instanceof LinkComposer ? (LinkComposer) composer : null;
        if (linkComposer != null) {
            return linkComposer;
        }
        ComposerKt.composeRuntimeError("Inconsistent composition");
        throw new KotlinNothingValueException();
    }

    public static final LinkRememberObserverHolder asLinkRememberObserverHolder(RememberObserverHolder rememberObserverHolder) {
        LinkRememberObserverHolder linkRememberObserverHolder = rememberObserverHolder instanceof LinkRememberObserverHolder ? (LinkRememberObserverHolder) rememberObserverHolder : null;
        if (linkRememberObserverHolder != null) {
            return linkRememberObserverHolder;
        }
        ComposerKt.composeRuntimeError("Inconsistent composition");
        throw new KotlinNothingValueException();
    }

    public static final ReusableLinkRememberObserverHolder asLinkRememberObserverHolder(ReusableRememberObserverHolder reusableRememberObserverHolder) {
        ReusableLinkRememberObserverHolder reusableLinkRememberObserverHolder = reusableRememberObserverHolder instanceof ReusableLinkRememberObserverHolder ? (ReusableLinkRememberObserverHolder) reusableRememberObserverHolder : null;
        if (reusableLinkRememberObserverHolder != null) {
            return reusableLinkRememberObserverHolder;
        }
        ComposerKt.composeRuntimeError("Inconsistent composition");
        throw new KotlinNothingValueException();
    }

    /* JADX WARN: Removed duplicated region for block: B:37:0x00a9  */
    /* JADX INFO: renamed from: findInvalidations-Vpaz1Sg, reason: not valid java name */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public static final java.util.List<kotlin.Pair<androidx.compose.runtime.RecomposeScopeImpl, java.lang.Object>> m5025findInvalidationsVpaz1Sg(androidx.compose.runtime.composer.linkbuffer.SlotTableReader r17, int r18, androidx.collection.MutableScatterMap<java.lang.Object, java.lang.Object> r19) {
        /*
            r0 = r18
            boolean r1 = androidx.compose.runtime.collection.ScopeMap.m5119isEmptyimpl(r19)
            if (r1 == 0) goto Ld
            java.util.List r0 = kotlin.collections.CollectionsKt.emptyList()
            return r0
        Ld:
            java.util.List r1 = kotlin.collections.CollectionsKt.createListBuilder()
            androidx.collection.MutableScatterSet r2 = androidx.collection.ScatterSetKt.mutableScatterSetOf()
            androidx.compose.runtime.composer.linkbuffer.SlotTable r3 = r17.getTable()
            androidx.compose.runtime.composer.linkbuffer.SlotTableAddressSpace r3 = r3.getAddressSpace()
            if (r0 < 0) goto L50
            androidx.compose.runtime.IntStack r4 = new androidx.compose.runtime.IntStack
            r4.<init>()
            int[] r3 = r3.getGroups()
            r5 = r17
            r6 = r0
        L2b:
            androidx.compose.runtime.RecomposeScopeImpl r7 = getRecomposeScopeOrNull(r5, r6)
            if (r7 == 0) goto L34
            r2.add(r7)
        L34:
            if (r6 == r0) goto L3f
            int r7 = r6 + 1
            r7 = r3[r7]
            if (r7 < 0) goto L3f
            r4.push(r7)
        L3f:
            int r6 = r6 + 3
            r6 = r3[r6]
            if (r6 < 0) goto L46
            goto L2b
        L46:
            int r6 = r4.tos
            if (r6 != 0) goto L4b
            goto L50
        L4b:
            int r6 = r4.pop()
            goto L2b
        L50:
            androidx.collection.ScatterSet r2 = (androidx.collection.ScatterSet) r2
            r0 = r19
            androidx.collection.ScatterMap r0 = (androidx.collection.ScatterMap) r0
            java.lang.Object[] r3 = r0.keys
            java.lang.Object[] r4 = r0.values
            long[] r0 = r0.metadata
            int r5 = r0.length
            int r5 = r5 + (-2)
            if (r5 < 0) goto Lae
            r6 = 0
            r7 = r6
        L63:
            r8 = r0[r7]
            long r10 = ~r8
            r12 = 7
            long r10 = r10 << r12
            long r10 = r10 & r8
            r12 = -9187201950435737472(0x8080808080808080, double:-2.937446524422997E-306)
            long r10 = r10 & r12
            int r10 = (r10 > r12 ? 1 : (r10 == r12 ? 0 : -1))
            if (r10 == 0) goto La9
            int r10 = r7 - r5
            int r10 = ~r10
            int r10 = r10 >>> 31
            r11 = 8
            int r10 = 8 - r10
            r12 = r6
        L7d:
            if (r12 >= r10) goto La7
            r13 = 255(0xff, double:1.26E-321)
            long r13 = r13 & r8
            r15 = 128(0x80, double:6.3E-322)
            int r13 = (r13 > r15 ? 1 : (r13 == r15 ? 0 : -1))
            if (r13 >= 0) goto La3
            int r13 = r7 << 3
            int r13 = r13 + r12
            r14 = r3[r13]
            r13 = r4[r13]
            java.lang.String r15 = "null cannot be cast to non-null type Key of androidx.compose.runtime.collection.ScopeMap"
            kotlin.jvm.internal.Intrinsics.checkNotNull(r14, r15)
            androidx.compose.runtime.RecomposeScopeImpl r14 = (androidx.compose.runtime.RecomposeScopeImpl) r14
            boolean r15 = r2.contains(r14)
            if (r15 == 0) goto La3
            kotlin.Pair r13 = kotlin.TuplesKt.to(r14, r13)
            r1.add(r13)
        La3:
            long r8 = r8 >> r11
            int r12 = r12 + 1
            goto L7d
        La7:
            if (r10 != r11) goto Lae
        La9:
            if (r7 == r5) goto Lae
            int r7 = r7 + 1
            goto L63
        Lae:
            java.util.List r0 = kotlin.collections.CollectionsKt.build(r1)
            return r0
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.compose.runtime.LinkComposerKt.m5025findInvalidationsVpaz1Sg(androidx.compose.runtime.composer.linkbuffer.SlotTableReader, int, androidx.collection.MutableScatterMap):java.util.List");
    }

    public static final RecomposeScopeImpl getRecomposeScopeOrNull(SlotTableReader slotTableReader, int i) {
        Object orNull = slotTableReader.getOrNull(i, 0);
        if (orNull instanceof RecomposeScopeImpl) {
            return (RecomposeScopeImpl) orNull;
        }
        return null;
    }

    private static final <T> ScatterSet<T> buildScatterSet(Function1<? super MutableScatterSet<T>, Unit> function1) {
        MutableScatterSet mutableScatterSetMutableScatterSetOf = ScatterSetKt.mutableScatterSetOf();
        function1.invoke(mutableScatterSetMutableScatterSetOf);
        return mutableScatterSetMutableScatterSetOf;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final <K, V> MutableScatterMap<Object, Object> multiMap(int i) {
        return MultiValueMap.m5085constructorimpl(new MutableScatterMap(i));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Object getKey(Object obj, Object obj2, Object obj3) {
        JoinedKey joinedKey = obj instanceof JoinedKey ? (JoinedKey) obj : null;
        if (joinedKey == null) {
            return null;
        }
        if (Intrinsics.areEqual(joinedKey.getLeft(), obj2) && Intrinsics.areEqual(joinedKey.getRight(), obj3)) {
            return obj;
        }
        Object key = getKey(joinedKey.getLeft(), obj2, obj3);
        return key == null ? getKey(joinedKey.getRight(), obj2, obj3) : key;
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Code restructure failed: missing block: B:57:0x00e0, code lost:
    
        if (r2 == r3) goto L76;
     */
    /* JADX WARN: Code restructure failed: missing block: B:62:0x00f1, code lost:
    
        if (r3 == r2) goto L74;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public static final long firstGroupInTopologicalOrder(androidx.compose.runtime.composer.linkbuffer.SlotTable r12, long r13, long r15) {
        /*
            Method dump skipped, instruction units count: 289
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.compose.runtime.LinkComposerKt.firstGroupInTopologicalOrder(androidx.compose.runtime.composer.linkbuffer.SlotTable, long, long):long");
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final List<Object> collectNodesFrom(SlotTable slotTable, int i) {
        boolean z;
        int i2;
        ArrayList arrayList = new ArrayList();
        SlotTableReader slotTableReaderOpenReader = slotTable.openReader();
        try {
            SlotTableAddressSpace slotTableAddressSpace = slotTableReaderOpenReader.addressSpace;
            if (i >= 0) {
                IntStack intStack = new IntStack();
                int[] groups = slotTableAddressSpace.getGroups();
                int iPop = i;
                while (true) {
                    if (slotTableReaderOpenReader.isNode(iPop)) {
                        arrayList.add(slotTableReaderOpenReader.node(iPop));
                        z = false;
                    } else {
                        z = true;
                    }
                    if (iPop != i && (i2 = groups[iPop + 1]) >= 0) {
                        intStack.push(i2);
                    }
                    iPop = groups[iPop + 3];
                    if (!z || iPop < 0) {
                        if (intStack.tos == 0) {
                            break;
                        }
                        iPop = intStack.pop();
                    }
                }
            }
            Unit unit = Unit.INSTANCE;
            return arrayList;
        } finally {
            slotTableReaderOpenReader.close();
        }
    }

    private static final long toGroupHandle(int i) {
        return (((long) 0) << 32) | (((long) UInt.m12488constructorimpl(i)) & 4294967295L);
    }

    public static final Integer findSubcompositionContextGroup(SlotTable slotTable, CompositionContext compositionContext) {
        int i;
        SlotTableReader slotTableReaderOpenReader = slotTable.openReader();
        try {
            int root = slotTable.getRoot();
            int iFirstChildOf = slotTableReaderOpenReader.firstChildOf(root);
            loop0: while (iFirstChildOf != -1) {
                if ((slotTable.groupFlags$runtime(iFirstChildOf) & 1073741824) == 1073741824 && (i = slotTable.getGroups()[iFirstChildOf + 5]) != -1) {
                    SlotTableAddressSpace addressSpace = slotTable.getAddressSpace();
                    int i2 = (i & 15) + 1;
                    int i3 = i >> 4;
                    if (i2 > 15) {
                        i2 = addressSpace.getLargeSizes().get(i3);
                    }
                    for (int i4 = 0; i4 < i2; i4++) {
                        Object obj = slotTable.getSlots()[i3 + i4];
                        if (Intrinsics.areEqual(obj, Composer.INSTANCE.getEmpty())) {
                            break;
                        }
                        RememberObserverHolder rememberObserverHolder = obj instanceof RememberObserverHolder ? (RememberObserverHolder) obj : null;
                        RememberObserver wrapped = rememberObserverHolder != null ? rememberObserverHolder.getWrapped() : null;
                        LinkComposer.CompositionContextHolder compositionContextHolder = wrapped instanceof LinkComposer.CompositionContextHolder ? (LinkComposer.CompositionContextHolder) wrapped : null;
                        if (compositionContextHolder != null && Intrinsics.areEqual(compositionContextHolder.getRef(), compositionContext)) {
                            return Integer.valueOf(iFirstChildOf);
                        }
                    }
                }
                int iFirstChildOf2 = slotTableReaderOpenReader.firstChildOf(iFirstChildOf);
                if (iFirstChildOf2 == -1 || (slotTable.groupFlags$runtime(iFirstChildOf) & Integer.MIN_VALUE) != Integer.MIN_VALUE) {
                    int iParentOf = iFirstChildOf;
                    iFirstChildOf = slotTableReaderOpenReader.nextSiblingOf(iFirstChildOf);
                    while (iFirstChildOf == -1) {
                        iParentOf = slotTableReaderOpenReader.parentOf(iParentOf);
                        if (iParentOf == -1 || iParentOf == root) {
                            break loop0;
                        }
                        iFirstChildOf = slotTableReaderOpenReader.nextSiblingOf(iParentOf);
                    }
                } else {
                    iFirstChildOf = iFirstChildOf2;
                }
            }
            Unit unit = Unit.INSTANCE;
            return null;
        } finally {
            slotTableReaderOpenReader.close();
        }
    }

    private static final int findFirstSibling(SlotTableAddressSpace slotTableAddressSpace, int i, int i2, int i3) {
        if (i2 != -1) {
            if (i3 != -1) {
                int[] groups = slotTableAddressSpace.getGroups();
                for (int i4 = groups[i + 3]; i4 > 0; i4 = groups[i4 + 1]) {
                    if (i4 != i2) {
                        if (i4 != i3) {
                        }
                    }
                }
                ComposerKt.composeRuntimeError("Unexpected slot table structure");
                throw new KotlinNothingValueException();
            }
            return i2;
        }
        return i3;
    }

    private static final boolean childOf(SlotTableAddressSpace slotTableAddressSpace, int i, int i2) {
        int[] groups = slotTableAddressSpace.getGroups();
        int i3 = i2;
        while (true) {
            if (i3 <= 0) {
                if (!(i3 != 0)) {
                    ComposerKt.composeImmediateRuntimeError("Traversing parent of group not in the slot table: " + i2);
                }
                return false;
            }
            if (i3 == i) {
                return true;
            }
            i3 = groups[i3 + 2];
        }
    }
}
