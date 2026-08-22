package androidx.compose.ui.node;

import androidx.compose.ui.Modifier;
import kotlin.Metadata;

/* JADX INFO: compiled from: NodeCoordinator.kt */
/* JADX INFO: loaded from: classes3.dex */
@Metadata(d1 = {"\u0000.\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010$\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\u001a,\u0010\u0000\u001a\u00020\u00012\u000e\u0010\u0002\u001a\n\u0012\u0004\u0012\u00020\u0004\u0018\u00010\u00032\u0012\u0010\u0005\u001a\u000e\u0012\u0004\u0012\u00020\u0004\u0012\u0004\u0012\u00020\u00070\u0006H\u0002\u001a-\u0010\b\u001a\u0004\u0018\u00010\t*\u00020\n2\n\u0010\u000b\u001a\u0006\u0012\u0002\b\u00030\f2\n\u0010\r\u001a\u0006\u0012\u0002\b\u00030\fH\u0002¢\u0006\u0004\b\u000e\u0010\u000f¨\u0006\u0010"}, d2 = {"compareEquals", "", "a", "Landroidx/collection/MutableObjectIntMap;", "Landroidx/compose/ui/layout/AlignmentLine;", "b", "", "", "nextUntil", "Landroidx/compose/ui/Modifier$Node;", "Landroidx/compose/ui/node/DelegatableNode;", "type", "Landroidx/compose/ui/node/NodeKind;", "stopType", "nextUntil-hw7D004", "(Landroidx/compose/ui/node/DelegatableNode;II)Landroidx/compose/ui/Modifier$Node;", "ui"}, k = 2, mv = {2, 1, 0}, xi = 48)
public final class NodeCoordinatorKt {
    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Code restructure failed: missing block: B:22:0x005a, code lost:
    
        return false;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public static final boolean compareEquals(androidx.collection.MutableObjectIntMap<androidx.compose.ui.layout.AlignmentLine> r14, java.util.Map<androidx.compose.ui.layout.AlignmentLine, java.lang.Integer> r15) {
        /*
            r0 = 0
            if (r14 != 0) goto L4
            return r0
        L4:
            int r1 = r14.get_size()
            int r2 = r15.size()
            if (r1 == r2) goto Lf
            return r0
        Lf:
            androidx.collection.ObjectIntMap r14 = (androidx.collection.ObjectIntMap) r14
            java.lang.Object[] r1 = r14.keys
            int[] r2 = r14.values
            long[] r14 = r14.metadata
            int r3 = r14.length
            int r3 = r3 + (-2)
            if (r3 < 0) goto L66
            r4 = r0
        L1d:
            r5 = r14[r4]
            long r7 = ~r5
            r9 = 7
            long r7 = r7 << r9
            long r7 = r7 & r5
            r9 = -9187201950435737472(0x8080808080808080, double:-2.937446524422997E-306)
            long r7 = r7 & r9
            int r7 = (r7 > r9 ? 1 : (r7 == r9 ? 0 : -1))
            if (r7 == 0) goto L61
            int r7 = r4 - r3
            int r7 = ~r7
            int r7 = r7 >>> 31
            r8 = 8
            int r7 = 8 - r7
            r9 = r0
        L37:
            if (r9 >= r7) goto L5f
            r10 = 255(0xff, double:1.26E-321)
            long r10 = r10 & r5
            r12 = 128(0x80, double:6.3E-322)
            int r10 = (r10 > r12 ? 1 : (r10 == r12 ? 0 : -1))
            if (r10 >= 0) goto L5b
            int r10 = r4 << 3
            int r10 = r10 + r9
            r11 = r1[r10]
            r10 = r2[r10]
            androidx.compose.ui.layout.AlignmentLine r11 = (androidx.compose.ui.layout.AlignmentLine) r11
            java.lang.Object r11 = r15.get(r11)
            java.lang.Integer r11 = (java.lang.Integer) r11
            if (r11 != 0) goto L54
            goto L5a
        L54:
            int r11 = r11.intValue()
            if (r11 == r10) goto L5b
        L5a:
            return r0
        L5b:
            long r5 = r5 >> r8
            int r9 = r9 + 1
            goto L37
        L5f:
            if (r7 != r8) goto L66
        L61:
            if (r4 == r3) goto L66
            int r4 = r4 + 1
            goto L1d
        L66:
            r14 = 1
            return r14
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.compose.ui.node.NodeCoordinatorKt.compareEquals(androidx.collection.MutableObjectIntMap, java.util.Map):boolean");
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX INFO: renamed from: nextUntil-hw7D004, reason: not valid java name */
    public static final Modifier.Node m7761nextUntilhw7D004(DelegatableNode delegatableNode, int i, int i2) {
        Modifier.Node child = delegatableNode.getNode().getChild();
        if (child == null || (child.getAggregateChildKindSet() & i) == 0) {
            return null;
        }
        while (child != null) {
            int kindSet = child.getKindSet();
            if ((kindSet & i2) != 0) {
                return null;
            }
            if ((kindSet & i) != 0) {
                return child;
            }
            child = child.getChild();
        }
        return null;
    }
}
