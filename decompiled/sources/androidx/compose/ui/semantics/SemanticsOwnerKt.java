package androidx.compose.ui.semantics;

import android.os.Trace;
import androidx.collection.IntObjectMap;
import androidx.collection.IntObjectMapKt;
import androidx.collection.MutableIntObjectMap;
import androidx.compose.ui.ComposeUiFlags;
import androidx.compose.ui.geometry.Rect;
import androidx.compose.ui.layout.LayoutInfo;
import androidx.compose.ui.unit.IntRect;
import androidx.compose.ui.unit.IntRectKt;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.functions.Function1;

/* JADX INFO: compiled from: SemanticsOwner.kt */
/* JADX INFO: loaded from: classes3.dex */
@Metadata(d1 = {"\u0000>\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010$\n\u0002\u0010\b\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\u001a\"\u0010\u0000\u001a\b\u0012\u0004\u0012\u00020\u00020\u0001*\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u00052\b\b\u0002\u0010\u0006\u001a\u00020\u0005\u001a\u001a\u0010\u0000\u001a\b\u0012\u0004\u0012\u00020\u00020\u0001*\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u0005H\u0007\u001a,\u0010\u0007\u001a\u000e\u0012\u0004\u0012\u00020\t\u0012\u0004\u0012\u00020\u00020\b*\u00020\u00032\b\b\u0002\u0010\n\u001a\u00020\u00052\b\b\u0002\u0010\u0006\u001a\u00020\u0005H\u0000\u001a\f\u0010\u000b\u001a\u00020\u0005*\u00020\u0002H\u0000\u001a.\u0010\u0012\u001a\b\u0012\u0004\u0012\u00020\u00140\u0013*\u00020\u00032\u0006\u0010\u0015\u001a\u00020\t2\u0012\u0010\u0016\u001a\u000e\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u00050\u0017H\u0000\u001a\u000e\u0010\u0019\u001a\u0004\u0018\u00010\u0002*\u00020\u0002H\u0002\"\u001e\u0010\f\u001a\u00020\u0005*\u00020\u00028@X\u0080\u0004¢\u0006\f\u0012\u0004\b\r\u0010\u000e\u001a\u0004\b\f\u0010\u000f\"\u000e\u0010\u0010\u001a\u00020\u0011X\u0082\u0004¢\u0006\u0002\n\u0000\"\u0018\u0010\u0018\u001a\u00020\u0005*\u00020\u00028BX\u0082\u0004¢\u0006\u0006\u001a\u0004\b\u0018\u0010\u000f\"\u0018\u0010\u001a\u001a\u00020\u0005*\u00020\u00028BX\u0082\u0004¢\u0006\u0006\u001a\u0004\b\u001a\u0010\u000f¨\u0006\u001b"}, d2 = {"getAllSemanticsNodes", "", "Landroidx/compose/ui/semantics/SemanticsNode;", "Landroidx/compose/ui/semantics/SemanticsOwner;", "mergingEnabled", "", "skipDeactivatedNodes", "getAllSemanticsNodesToMap", "", "", "useUnmergedTree", "isImportantForAccessibility", "isHidden", "isHidden$annotations", "(Landroidx/compose/ui/semantics/SemanticsNode;)V", "(Landroidx/compose/ui/semantics/SemanticsNode;)Z", "DefaultFakeNodeBounds", "Landroidx/compose/ui/geometry/Rect;", "getAllUncoveredSemanticsNodesToIntObjectMap", "Landroidx/collection/IntObjectMap;", "Landroidx/compose/ui/semantics/SemanticsNodeWithAdjustedBounds;", "customRootNodeId", "shouldIgnoreNode", "Lkotlin/Function1;", "isPartiallyOffscreenInScrollParent", "getScrollableParent", "isScrollNode", "ui"}, k = 2, mv = {2, 1, 0}, xi = 48)
public final class SemanticsOwnerKt {
    private static final Rect DefaultFakeNodeBounds = new Rect(0.0f, 0.0f, 10.0f, 10.0f);

    public static /* synthetic */ void isHidden$annotations(SemanticsNode semanticsNode) {
    }

    public static /* synthetic */ List getAllSemanticsNodes$default(SemanticsOwner semanticsOwner, boolean z, boolean z2, int i, Object obj) {
        if ((i & 2) != 0) {
            z2 = true;
        }
        return getAllSemanticsNodes(semanticsOwner, z, z2);
    }

    public static final List<SemanticsNode> getAllSemanticsNodes(SemanticsOwner semanticsOwner, boolean z, boolean z2) {
        return CollectionsKt.toList(getAllSemanticsNodesToMap(semanticsOwner, !z, z2).values());
    }

    public static /* synthetic */ Map getAllSemanticsNodesToMap$default(SemanticsOwner semanticsOwner, boolean z, boolean z2, int i, Object obj) {
        if ((i & 1) != 0) {
            z = false;
        }
        if ((i & 2) != 0) {
            z2 = true;
        }
        return getAllSemanticsNodesToMap(semanticsOwner, z, z2);
    }

    public static final Map<Integer, SemanticsNode> getAllSemanticsNodesToMap(SemanticsOwner semanticsOwner, boolean z, boolean z2) {
        LinkedHashMap linkedHashMap = new LinkedHashMap();
        SemanticsNode unmergedRootSemanticsNode = z ? semanticsOwner.getUnmergedRootSemanticsNode() : semanticsOwner.getRootSemanticsNode();
        if (z2 && unmergedRootSemanticsNode.getLayoutNode().getIsDeactivated()) {
            return linkedHashMap;
        }
        getAllSemanticsNodesToMap$findAllSemanticNodesRecursive(linkedHashMap, z2, unmergedRootSemanticsNode);
        return linkedHashMap;
    }

    private static final void getAllSemanticsNodesToMap$findAllSemanticNodesRecursive(Map<Integer, SemanticsNode> map, boolean z, SemanticsNode semanticsNode) {
        map.put(Integer.valueOf(semanticsNode.getId()), semanticsNode);
        List children$ui$default = SemanticsNode.getChildren$ui$default(semanticsNode, false, false, !z, 3, null);
        int size = children$ui$default.size();
        for (int i = 0; i < size; i++) {
            getAllSemanticsNodesToMap$findAllSemanticNodesRecursive(map, z, (SemanticsNode) children$ui$default.get(i));
        }
    }

    public static final boolean isImportantForAccessibility(SemanticsNode semanticsNode) {
        if (isHidden(semanticsNode)) {
            return false;
        }
        return semanticsNode.getUnmergedConfig().getIsMergingSemanticsOfDescendants() || semanticsNode.getUnmergedConfig().containsImportantForAccessibility$ui();
    }

    public static final boolean isHidden(SemanticsNode semanticsNode) {
        return semanticsNode.isTransparent$ui() || semanticsNode.getUnmergedConfig().contains(SemanticsProperties.INSTANCE.getHideFromAccessibility()) || semanticsNode.getUnmergedConfig().contains(SemanticsProperties.INSTANCE.getInvisibleToUser());
    }

    public static final IntObjectMap<SemanticsNodeWithAdjustedBounds> getAllUncoveredSemanticsNodesToIntObjectMap(SemanticsOwner semanticsOwner, int i, Function1<? super SemanticsNode, Boolean> function1) {
        Trace.beginSection("getAllUncoveredSemanticsNodesToIntObjectMap");
        try {
            SemanticsNode unmergedRootSemanticsNode = semanticsOwner.getUnmergedRootSemanticsNode();
            if (unmergedRootSemanticsNode.getLayoutNode().isPlaced() && unmergedRootSemanticsNode.getLayoutNode().isAttached()) {
                Rect boundsInRoot = unmergedRootSemanticsNode.getBoundsInRoot();
                MutableIntObjectMap mutableIntObjectMap = new MutableIntObjectMap(48);
                SemanticsRegion SemanticsRegion = SemanticsRegion_androidKt.SemanticsRegion();
                SemanticsRegion.set(IntRectKt.roundToIntRect(boundsInRoot));
                getAllUncoveredSemanticsNodesToIntObjectMap$lambda$0$findAllSemanticNodesRecursive(unmergedRootSemanticsNode, mutableIntObjectMap, function1, i, unmergedRootSemanticsNode, SemanticsRegion_androidKt.SemanticsRegion(), SemanticsRegion);
                return mutableIntObjectMap;
            }
            return IntObjectMapKt.emptyIntObjectMap();
        } finally {
            Trace.endSection();
        }
    }

    private static final int getAllUncoveredSemanticsNodesToIntObjectMap$lambda$0$virtualViewId(SemanticsNode semanticsNode, int i, SemanticsNode semanticsNode2) {
        return semanticsNode2.getId() == semanticsNode.getId() ? i : semanticsNode2.getId();
    }

    private static final void getAllUncoveredSemanticsNodesToIntObjectMap$lambda$0$addFakeNode(MutableIntObjectMap<SemanticsNodeWithAdjustedBounds> mutableIntObjectMap, SemanticsNode semanticsNode, int i, SemanticsNode semanticsNode2) {
        Rect boundsInRoot;
        LayoutInfo layoutInfo;
        SemanticsNode parent = semanticsNode2.getParent();
        if (parent != null && (layoutInfo = parent.getLayoutInfo()) != null && layoutInfo.isPlaced()) {
            boundsInRoot = parent.getBoundsInRoot();
        } else {
            boundsInRoot = DefaultFakeNodeBounds;
        }
        mutableIntObjectMap.set(getAllUncoveredSemanticsNodesToIntObjectMap$lambda$0$virtualViewId(semanticsNode, i, semanticsNode2), new SemanticsNodeWithAdjustedBounds(semanticsNode2, IntRectKt.roundToIntRect(boundsInRoot)));
    }

    private static final void getAllUncoveredSemanticsNodesToIntObjectMap$lambda$0$addDescendantsOfMergingNodePartiallyVisibleInScrollParent(MutableIntObjectMap<SemanticsNodeWithAdjustedBounds> mutableIntObjectMap, Function1<? super SemanticsNode, Boolean> function1, SemanticsNode semanticsNode, int i, SemanticsNode semanticsNode2, SemanticsRegion semanticsRegion, SemanticsRegion semanticsRegion2) {
        if (!semanticsNode2.getLayoutNode().isPlaced() || !semanticsNode2.getLayoutNode().isAttached() || semanticsRegion2.isEmpty()) {
            if (semanticsNode2.isFake$ui()) {
                getAllUncoveredSemanticsNodesToIntObjectMap$lambda$0$addFakeNode(mutableIntObjectMap, semanticsNode, i, semanticsNode2);
                return;
            }
            return;
        }
        Rect touchBoundsInRoot = semanticsNode2.getTouchBoundsInRoot();
        if (touchBoundsInRoot.isEmpty()) {
            touchBoundsInRoot = semanticsNode2.getUnclippedBoundsInRoot$ui();
        }
        IntRect intRectRoundToIntRect = IntRectKt.roundToIntRect(touchBoundsInRoot);
        SemanticsRegion semanticsRegion3 = semanticsRegion;
        semanticsRegion.set(intRectRoundToIntRect);
        if (semanticsRegion.intersect(semanticsRegion2)) {
            mutableIntObjectMap.set(getAllUncoveredSemanticsNodesToIntObjectMap$lambda$0$virtualViewId(semanticsNode, i, semanticsNode2), new SemanticsNodeWithAdjustedBounds(semanticsNode2, semanticsRegion.getBounds()));
            List<SemanticsNode> replacedChildren$ui = semanticsNode2.getReplacedChildren$ui();
            int size = replacedChildren$ui.size() - 1;
            while (-1 < size) {
                if (!function1.invoke(replacedChildren$ui.get(size)).booleanValue()) {
                    getAllUncoveredSemanticsNodesToIntObjectMap$lambda$0$addDescendantsOfMergingNodePartiallyVisibleInScrollParent(mutableIntObjectMap, function1, semanticsNode, i, replacedChildren$ui.get(size), semanticsRegion3, semanticsRegion2);
                }
                size--;
                semanticsRegion3 = semanticsRegion;
            }
            if (isImportantForAccessibility(semanticsNode2)) {
                semanticsRegion2.difference(intRectRoundToIntRect);
            }
        }
    }

    private static final void getAllUncoveredSemanticsNodesToIntObjectMap$lambda$0$findAllSemanticNodesRecursive(SemanticsNode semanticsNode, MutableIntObjectMap<SemanticsNodeWithAdjustedBounds> mutableIntObjectMap, Function1<? super SemanticsNode, Boolean> function1, int i, SemanticsNode semanticsNode2, SemanticsRegion semanticsRegion, SemanticsRegion semanticsRegion2) {
        int i2 = i;
        boolean z = (semanticsNode2.getLayoutNode().isPlaced() && semanticsNode2.getLayoutNode().isAttached()) ? false : true;
        if (!semanticsRegion2.isEmpty() || semanticsNode2.getId() == semanticsNode.getId()) {
            if (!z || semanticsNode2.isFake$ui()) {
                IntRect intRectRoundToIntRect = IntRectKt.roundToIntRect(semanticsNode2.getTouchBoundsInRoot());
                SemanticsRegion semanticsRegion3 = semanticsRegion;
                semanticsRegion3.set(intRectRoundToIntRect);
                int allUncoveredSemanticsNodesToIntObjectMap$lambda$0$virtualViewId = getAllUncoveredSemanticsNodesToIntObjectMap$lambda$0$virtualViewId(semanticsNode, i, semanticsNode2);
                if (semanticsRegion.intersect(semanticsRegion2)) {
                    mutableIntObjectMap.set(allUncoveredSemanticsNodesToIntObjectMap$lambda$0$virtualViewId, new SemanticsNodeWithAdjustedBounds(semanticsNode2, semanticsRegion3.getBounds()));
                    List<SemanticsNode> replacedChildren$ui = semanticsNode2.getReplacedChildren$ui();
                    if (ComposeUiFlags.isAccessibilityShouldIncludeOffscreenChildrenEnabled && semanticsNode2.getUnmergedConfig().getIsMergingSemanticsOfDescendants() && isPartiallyOffscreenInScrollParent(semanticsNode2)) {
                        SemanticsRegion SemanticsRegion = SemanticsRegion_androidKt.SemanticsRegion();
                        SemanticsRegion.set(IntRectKt.roundToIntRect(semanticsNode2.getUnclippedBoundsInRoot$ui()));
                        int size = replacedChildren$ui.size() - 1;
                        while (-1 < size) {
                            if (!function1.invoke(replacedChildren$ui.get(size)).booleanValue()) {
                                getAllUncoveredSemanticsNodesToIntObjectMap$lambda$0$addDescendantsOfMergingNodePartiallyVisibleInScrollParent(mutableIntObjectMap, function1, semanticsNode, i2, replacedChildren$ui.get(size), SemanticsRegion_androidKt.SemanticsRegion(), SemanticsRegion);
                            }
                            size--;
                            i2 = i;
                        }
                    } else {
                        int size2 = replacedChildren$ui.size() - 1;
                        while (-1 < size2) {
                            if (!function1.invoke(replacedChildren$ui.get(size2)).booleanValue()) {
                                getAllUncoveredSemanticsNodesToIntObjectMap$lambda$0$findAllSemanticNodesRecursive(semanticsNode, mutableIntObjectMap, function1, i, replacedChildren$ui.get(size2), semanticsRegion3, semanticsRegion2);
                            }
                            size2--;
                            semanticsRegion3 = semanticsRegion;
                        }
                    }
                    if (isImportantForAccessibility(semanticsNode2)) {
                        semanticsRegion2.difference(intRectRoundToIntRect);
                        return;
                    }
                    return;
                }
                if (semanticsNode2.isFake$ui()) {
                    getAllUncoveredSemanticsNodesToIntObjectMap$lambda$0$addFakeNode(mutableIntObjectMap, semanticsNode, i, semanticsNode2);
                } else if (allUncoveredSemanticsNodesToIntObjectMap$lambda$0$virtualViewId == i2) {
                    mutableIntObjectMap.set(allUncoveredSemanticsNodesToIntObjectMap$lambda$0$virtualViewId, new SemanticsNodeWithAdjustedBounds(semanticsNode2, semanticsRegion.getBounds()));
                }
            }
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:12:0x001d  */
    /* JADX WARN: Removed duplicated region for block: B:15:0x0024  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    private static final boolean isPartiallyOffscreenInScrollParent(androidx.compose.ui.semantics.SemanticsNode r4) {
        /*
            androidx.compose.ui.semantics.SemanticsNode r0 = getScrollableParent(r4)
            r1 = 0
            if (r0 == 0) goto L58
            androidx.compose.ui.node.NodeCoordinator r4 = r4.findCoordinatorToGetBounds$ui()
            r2 = 0
            if (r4 == 0) goto L1d
            boolean r3 = r4.isAttached()
            if (r3 == 0) goto L15
            goto L16
        L15:
            r4 = r2
        L16:
            if (r4 == 0) goto L1d
            androidx.compose.ui.layout.LayoutCoordinates r4 = r4.getCoordinates()
            goto L1e
        L1d:
            r4 = r2
        L1e:
            androidx.compose.ui.node.NodeCoordinator r0 = r0.findCoordinatorToGetBounds$ui()
            if (r0 == 0) goto L32
            boolean r3 = r0.isAttached()
            if (r3 == 0) goto L2b
            goto L2c
        L2b:
            r0 = r2
        L2c:
            if (r0 == 0) goto L32
            androidx.compose.ui.layout.LayoutCoordinates r2 = r0.getCoordinates()
        L32:
            if (r4 == 0) goto L58
            if (r2 != 0) goto L37
            goto L58
        L37:
            androidx.compose.ui.geometry.Rect r4 = r2.localBoundingBoxOf(r4, r1)
            androidx.compose.ui.geometry.Offset$Companion r0 = androidx.compose.ui.geometry.Offset.INSTANCE
            long r0 = r0.m5739getZeroF1C5BW0()
            long r2 = r2.mo7453getSizeYbymL2g()
            long r2 = androidx.compose.ui.unit.IntSizeKt.m9013toSizeozmzZPI(r2)
            androidx.compose.ui.geometry.Rect r0 = androidx.compose.ui.geometry.RectKt.m5763Recttz77jQw(r0, r2)
            androidx.compose.ui.geometry.Rect r0 = r4.intersect(r0)
            boolean r4 = kotlin.jvm.internal.Intrinsics.areEqual(r4, r0)
            r4 = r4 ^ 1
            return r4
        L58:
            return r1
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.compose.ui.semantics.SemanticsOwnerKt.isPartiallyOffscreenInScrollParent(androidx.compose.ui.semantics.SemanticsNode):boolean");
    }

    private static final SemanticsNode getScrollableParent(SemanticsNode semanticsNode) {
        for (SemanticsNode parent = semanticsNode.getParent(); parent != null; parent = parent.getParent()) {
            if (isScrollNode(parent)) {
                return parent;
            }
        }
        return null;
    }

    private static final boolean isScrollNode(SemanticsNode semanticsNode) {
        return semanticsNode.getUnmergedConfig().contains(SemanticsProperties.INSTANCE.getVerticalScrollAxisRange()) || semanticsNode.getUnmergedConfig().contains(SemanticsProperties.INSTANCE.getHorizontalScrollAxisRange());
    }
}
