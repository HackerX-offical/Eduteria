package androidx.compose.runtime;

import androidx.collection.MutableIntObjectMap;
import androidx.collection.MutableScatterMap;
import androidx.compose.runtime.collection.MultiValueMap;
import androidx.compose.runtime.composer.GroupInfo;
import androidx.compose.runtime.composer.gapbuffer.BitVector;
import androidx.compose.runtime.composer.linkbuffer.GroupHandleKt;
import androidx.compose.runtime.composer.linkbuffer.KeyInfo;
import com.google.firebase.analytics.FirebaseAnalytics;
import java.util.ArrayList;
import java.util.List;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.Metadata;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: compiled from: LinkComposer.kt */
/* JADX INFO: loaded from: classes.dex */
@Metadata(d1 = {"\u0000`\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010!\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u000b\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010 \n\u0002\b\u0002\n\u0002\u0010\t\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\n\n\u0002\u0018\u0002\n\u0002\b\u0005\b\u0002\u0018\u00002\u00020\u0001B\u001d\u0012\f\u0010\u0002\u001a\b\u0012\u0004\u0012\u00020\u00040\u0003\u0012\u0006\u0010\u0005\u001a\u00020\u0006¢\u0006\u0004\b\u0007\u0010\bJ\u001a\u0010\u001d\u001a\u0004\u0018\u00010\u00042\u0006\u0010\u001e\u001a\u00020\u00062\b\u0010\u001f\u001a\u0004\u0018\u00010\u0001J\u000e\u0010 \u001a\u00020!2\u0006\u0010\"\u001a\u00020\u0004J\n\u0010&\u001a\u00060'j\u0002`(J\u000e\u0010)\u001a\u00020*2\u0006\u0010+\u001a\u00020\u0006J\u0016\u0010,\u001a\u00020*2\u0006\u0010-\u001a\u00020\u00062\u0006\u0010.\u001a\u00020\u0006J\u001e\u0010/\u001a\u00020*2\u0006\u0010-\u001a\u00020\u00062\u0006\u0010.\u001a\u00020\u00062\u0006\u00100\u001a\u00020\u0006J\u0016\u00101\u001a\u00020*2\u0006\u0010\"\u001a\u00020\u00042\u0006\u00102\u001a\u00020\u0006J\u001a\u00103\u001a\u00020!2\n\u00104\u001a\u00060\u0006j\u0002`52\u0006\u00106\u001a\u00020\u0006J\u000e\u00107\u001a\u00020\u00062\u0006\u0010\"\u001a\u00020\u0004J\u000e\u00108\u001a\u00020\u00062\u0006\u0010\"\u001a\u00020\u0004J\u000e\u00109\u001a\u00020\u00062\u0006\u0010\"\u001a\u00020\u0004R\u0017\u0010\u0002\u001a\b\u0012\u0004\u0012\u00020\u00040\u0003¢\u0006\b\n\u0000\u001a\u0004\b\t\u0010\nR\u0011\u0010\u0005\u001a\u00020\u0006¢\u0006\b\n\u0000\u001a\u0004\b\u000b\u0010\fR\u001a\u0010\r\u001a\u00020\u0006X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u000e\u0010\f\"\u0004\b\u000f\u0010\u0010R\u000e\u0010\u0011\u001a\u00020\u0012X\u0082\u0004¢\u0006\u0002\n\u0000R\u0014\u0010\u0013\u001a\b\u0012\u0004\u0012\u00020\u00040\u0003X\u0082\u0004¢\u0006\u0002\n\u0000R\u0014\u0010\u0014\u001a\b\u0012\u0004\u0012\u00020\u00160\u0015X\u0082\u0004¢\u0006\u0002\n\u0000R'\u0010\u0017\u001a\u000e\u0012\u0004\u0012\u00020\u0001\u0012\u0004\u0012\u00020\u00040\u00188FX\u0086\u0084\u0002¢\u0006\f\n\u0004\b\u001b\u0010\u001c\u001a\u0004\b\u0019\u0010\u001aR\u0017\u0010#\u001a\b\u0012\u0004\u0012\u00020\u00040$8F¢\u0006\u0006\u001a\u0004\b%\u0010\n¨\u0006:"}, d2 = {"Landroidx/compose/runtime/LinkPending;", "", "keyInfos", "", "Landroidx/compose/runtime/composer/linkbuffer/KeyInfo;", "startIndex", "", "<init>", "(Ljava/util/List;I)V", "getKeyInfos", "()Ljava/util/List;", "getStartIndex", "()I", "groupIndex", "getGroupIndex", "setGroupIndex", "(I)V", "placedGroups", "Landroidx/compose/runtime/composer/gapbuffer/BitVector;", "usedKeys", "groupInfos", "Landroidx/collection/MutableIntObjectMap;", "Landroidx/compose/runtime/composer/GroupInfo;", "keyMap", "Landroidx/compose/runtime/collection/MultiValueMap;", "getKeyMap-fVlnmYg", "()Landroidx/collection/MutableScatterMap;", "keyMap$delegate", "Lkotlin/Lazy;", "getNext", "key", "dataKey", "recordUsed", "", "keyInfo", "used", "", "getUsed", "groupHandleOfNextUnmovedGroup", "", "Landroidx/compose/runtime/composer/linkbuffer/GroupHandle;", "markGroupLocationReconciled", "", FirebaseAnalytics.Param.INDEX, "registerMoveSlot", "from", "to", "registerMoveNode", "count", "registerInsert", "insertIndex", "updateNodeCount", "group", "Landroidx/compose/runtime/composer/linkbuffer/GroupAddress;", "newCount", "slotPositionOf", "nodePositionOf", "updatedNodeCountOf", "runtime"}, k = 1, mv = {2, 1, 0}, xi = 48)
final class LinkPending {
    private int groupIndex;
    private final MutableIntObjectMap<GroupInfo> groupInfos;
    private final List<KeyInfo> keyInfos;

    /* JADX INFO: renamed from: keyMap$delegate, reason: from kotlin metadata */
    private final Lazy keyMap;
    private final BitVector placedGroups = new BitVector();
    private final int startIndex;
    private final List<KeyInfo> usedKeys;

    public LinkPending(List<KeyInfo> list, int i) {
        this.keyInfos = list;
        this.startIndex = i;
        if (!(i >= 0)) {
            PreconditionsKt.throwIllegalArgumentException("Invalid start index");
        }
        this.usedKeys = new ArrayList();
        MutableIntObjectMap<GroupInfo> mutableIntObjectMap = new MutableIntObjectMap<>(0, 1, null);
        int size = this.keyInfos.size();
        int nodes = 0;
        for (int i2 = 0; i2 < size; i2++) {
            KeyInfo keyInfo = this.keyInfos.get(i2);
            mutableIntObjectMap.set(GroupHandleKt.getGroup(keyInfo.getHandle()), new GroupInfo(i2, nodes, keyInfo.getNodes()));
            nodes += keyInfo.getNodes();
        }
        this.groupInfos = mutableIntObjectMap;
        this.keyMap = LazyKt.lazy(new Function0<MultiValueMap<Object, KeyInfo>>() { // from class: androidx.compose.runtime.LinkPending$keyMap$2
            @Override // kotlin.jvm.functions.Function0
            public /* bridge */ /* synthetic */ MultiValueMap<Object, KeyInfo> invoke() {
                return MultiValueMap.m5083boximpl(m5027invokefVlnmYg());
            }

            /* JADX INFO: renamed from: invoke-fVlnmYg, reason: not valid java name */
            public final MutableScatterMap<Object, Object> m5027invokefVlnmYg() {
                MutableScatterMap<Object, Object> mutableScatterMapMultiMap = LinkComposerKt.multiMap(this.this$0.getKeyInfos().size());
                LinkPending linkPending = this.this$0;
                int size2 = linkPending.getKeyInfos().size();
                for (int i3 = 0; i3 < size2; i3++) {
                    KeyInfo keyInfo2 = linkPending.getKeyInfos().get(i3);
                    MultiValueMap.m5082addimpl(mutableScatterMapMultiMap, keyInfo2.getJoinedKey(), keyInfo2);
                }
                return mutableScatterMapMultiMap;
            }
        });
    }

    public final List<KeyInfo> getKeyInfos() {
        return this.keyInfos;
    }

    public final int getStartIndex() {
        return this.startIndex;
    }

    public final int getGroupIndex() {
        return this.groupIndex;
    }

    public final void setGroupIndex(int i) {
        this.groupIndex = i;
    }

    /* JADX INFO: renamed from: getKeyMap-fVlnmYg, reason: not valid java name */
    public final MutableScatterMap<Object, Object> m5026getKeyMapfVlnmYg() {
        return ((MultiValueMap) this.keyMap.getValue()).getMap();
    }

    public final KeyInfo getNext(int key, Object dataKey) {
        return (KeyInfo) MultiValueMap.m5096removeFirstimpl(m5026getKeyMapfVlnmYg(), dataKey != null ? new JoinedKey(Integer.valueOf(key), dataKey) : Integer.valueOf(key));
    }

    public final boolean recordUsed(KeyInfo keyInfo) {
        return this.usedKeys.add(keyInfo);
    }

    public final List<KeyInfo> getUsed() {
        return this.usedKeys;
    }

    public final long groupHandleOfNextUnmovedGroup() {
        return this.keyInfos.get(this.placedGroups.nextClear(0)).getHandle();
    }

    public final void markGroupLocationReconciled(int index) {
        this.placedGroups.set(index, true);
    }

    public final void registerMoveSlot(int from, int to) {
        char c2;
        long j;
        char c3;
        long j2;
        char c4 = 7;
        long j3 = -9187201950435737472L;
        if (from > to) {
            MutableIntObjectMap<GroupInfo> mutableIntObjectMap = this.groupInfos;
            Object[] objArr = mutableIntObjectMap.values;
            long[] jArr = mutableIntObjectMap.metadata;
            int length = jArr.length - 2;
            if (length < 0) {
                return;
            }
            int i = 0;
            while (true) {
                long j4 = jArr[i];
                if ((((~j4) << c4) & j4 & j3) != j3) {
                    int i2 = 8 - ((~(i - length)) >>> 31);
                    int i3 = 0;
                    while (i3 < i2) {
                        if ((j4 & 255) < 128) {
                            c3 = c4;
                            GroupInfo groupInfo = (GroupInfo) objArr[(i << 3) + i3];
                            j2 = j3;
                            int slotIndex = groupInfo.getSlotIndex();
                            if (slotIndex == from) {
                                groupInfo.setSlotIndex(to);
                            } else if (to <= slotIndex && slotIndex < from) {
                                groupInfo.setSlotIndex(slotIndex + 1);
                            }
                        } else {
                            c3 = c4;
                            j2 = j3;
                        }
                        j4 >>= 8;
                        i3++;
                        c4 = c3;
                        j3 = j2;
                    }
                    c2 = c4;
                    j = j3;
                    if (i2 != 8) {
                        return;
                    }
                } else {
                    c2 = c4;
                    j = j3;
                }
                if (i == length) {
                    return;
                }
                i++;
                c4 = c2;
                j3 = j;
            }
        } else {
            if (to <= from) {
                return;
            }
            MutableIntObjectMap<GroupInfo> mutableIntObjectMap2 = this.groupInfos;
            Object[] objArr2 = mutableIntObjectMap2.values;
            long[] jArr2 = mutableIntObjectMap2.metadata;
            int length2 = jArr2.length - 2;
            if (length2 < 0) {
                return;
            }
            int i4 = 0;
            while (true) {
                long j5 = jArr2[i4];
                if ((((~j5) << 7) & j5 & (-9187201950435737472L)) != -9187201950435737472L) {
                    int i5 = 8 - ((~(i4 - length2)) >>> 31);
                    for (int i6 = 0; i6 < i5; i6++) {
                        if ((j5 & 255) < 128) {
                            GroupInfo groupInfo2 = (GroupInfo) objArr2[(i4 << 3) + i6];
                            int slotIndex2 = groupInfo2.getSlotIndex();
                            if (slotIndex2 == from) {
                                groupInfo2.setSlotIndex(to);
                            } else if (from + 1 <= slotIndex2 && slotIndex2 < to) {
                                groupInfo2.setSlotIndex(slotIndex2 - 1);
                            }
                        }
                        j5 >>= 8;
                    }
                    if (i5 != 8) {
                        return;
                    }
                }
                if (i4 == length2) {
                    return;
                } else {
                    i4++;
                }
            }
        }
    }

    public final void registerMoveNode(int from, int to, int count) {
        char c2;
        long j;
        char c3;
        long j2;
        char c4 = 7;
        long j3 = -9187201950435737472L;
        if (from > to) {
            MutableIntObjectMap<GroupInfo> mutableIntObjectMap = this.groupInfos;
            Object[] objArr = mutableIntObjectMap.values;
            long[] jArr = mutableIntObjectMap.metadata;
            int length = jArr.length - 2;
            if (length < 0) {
                return;
            }
            int i = 0;
            while (true) {
                long j4 = jArr[i];
                if ((((~j4) << c4) & j4 & j3) != j3) {
                    int i2 = 8 - ((~(i - length)) >>> 31);
                    int i3 = 0;
                    while (i3 < i2) {
                        if ((j4 & 255) < 128) {
                            c3 = c4;
                            GroupInfo groupInfo = (GroupInfo) objArr[(i << 3) + i3];
                            j2 = j3;
                            int nodeIndex = groupInfo.getNodeIndex();
                            if (from <= nodeIndex && nodeIndex < from + count) {
                                groupInfo.setNodeIndex((nodeIndex - from) + to);
                            } else if (to <= nodeIndex && nodeIndex < from) {
                                groupInfo.setNodeIndex(nodeIndex + count);
                            }
                        } else {
                            c3 = c4;
                            j2 = j3;
                        }
                        j4 >>= 8;
                        i3++;
                        c4 = c3;
                        j3 = j2;
                    }
                    c2 = c4;
                    j = j3;
                    if (i2 != 8) {
                        return;
                    }
                } else {
                    c2 = c4;
                    j = j3;
                }
                if (i == length) {
                    return;
                }
                i++;
                c4 = c2;
                j3 = j;
            }
        } else {
            if (to <= from) {
                return;
            }
            MutableIntObjectMap<GroupInfo> mutableIntObjectMap2 = this.groupInfos;
            Object[] objArr2 = mutableIntObjectMap2.values;
            long[] jArr2 = mutableIntObjectMap2.metadata;
            int length2 = jArr2.length - 2;
            if (length2 < 0) {
                return;
            }
            int i4 = 0;
            while (true) {
                long j5 = jArr2[i4];
                if ((((~j5) << 7) & j5 & (-9187201950435737472L)) != -9187201950435737472L) {
                    int i5 = 8 - ((~(i4 - length2)) >>> 31);
                    for (int i6 = 0; i6 < i5; i6++) {
                        if ((j5 & 255) < 128) {
                            GroupInfo groupInfo2 = (GroupInfo) objArr2[(i4 << 3) + i6];
                            int nodeIndex2 = groupInfo2.getNodeIndex();
                            if (from <= nodeIndex2 && nodeIndex2 < from + count) {
                                groupInfo2.setNodeIndex((nodeIndex2 - from) + to);
                            } else if (from + 1 <= nodeIndex2 && nodeIndex2 < to) {
                                groupInfo2.setNodeIndex(nodeIndex2 - count);
                            }
                        }
                        j5 >>= 8;
                    }
                    if (i5 != 8) {
                        return;
                    }
                }
                if (i4 == length2) {
                    return;
                } else {
                    i4++;
                }
            }
        }
    }

    public final void registerInsert(KeyInfo keyInfo, int insertIndex) {
        this.groupInfos.set(GroupHandleKt.getGroup(keyInfo.getHandle()), new GroupInfo(-1, insertIndex, 0));
    }

    public final boolean updateNodeCount(int group, int newCount) {
        int nodeIndex;
        GroupInfo groupInfo = this.groupInfos.get(group);
        if (groupInfo == null) {
            return false;
        }
        int nodeIndex2 = groupInfo.getNodeIndex();
        int nodeCount = newCount - groupInfo.getNodeCount();
        groupInfo.setNodeCount(newCount);
        if (nodeCount == 0) {
            return true;
        }
        MutableIntObjectMap<GroupInfo> mutableIntObjectMap = this.groupInfos;
        Object[] objArr = mutableIntObjectMap.values;
        long[] jArr = mutableIntObjectMap.metadata;
        int length = jArr.length - 2;
        if (length < 0) {
            return true;
        }
        int i = 0;
        while (true) {
            long j = jArr[i];
            if ((((~j) << 7) & j & (-9187201950435737472L)) != -9187201950435737472L) {
                int i2 = 8 - ((~(i - length)) >>> 31);
                for (int i3 = 0; i3 < i2; i3++) {
                    if ((255 & j) < 128) {
                        GroupInfo groupInfo2 = (GroupInfo) objArr[(i << 3) + i3];
                        if (groupInfo2.getNodeIndex() >= nodeIndex2 && !Intrinsics.areEqual(groupInfo2, groupInfo) && (nodeIndex = groupInfo2.getNodeIndex() + nodeCount) >= 0) {
                            groupInfo2.setNodeIndex(nodeIndex);
                        }
                    }
                    j >>= 8;
                }
                if (i2 != 8) {
                    return true;
                }
            }
            if (i == length) {
                return true;
            }
            i++;
        }
    }

    public final int slotPositionOf(KeyInfo keyInfo) {
        GroupInfo groupInfo = this.groupInfos.get(GroupHandleKt.getGroup(keyInfo.getHandle()));
        if (groupInfo != null) {
            return groupInfo.getSlotIndex();
        }
        return -1;
    }

    public final int nodePositionOf(KeyInfo keyInfo) {
        GroupInfo groupInfo = this.groupInfos.get(GroupHandleKt.getGroup(keyInfo.getHandle()));
        if (groupInfo != null) {
            return groupInfo.getNodeIndex();
        }
        return -1;
    }

    public final int updatedNodeCountOf(KeyInfo keyInfo) {
        GroupInfo groupInfo = this.groupInfos.get(GroupHandleKt.getGroup(keyInfo.getHandle()));
        return groupInfo != null ? groupInfo.getNodeCount() : keyInfo.getNodes();
    }
}
