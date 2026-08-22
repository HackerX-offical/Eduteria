package androidx.compose.ui.input.pointer;

import androidx.collection.LongSparseArray;
import androidx.collection.MutableObjectList;
import androidx.compose.runtime.collection.MutableVector;
import androidx.compose.ui.Modifier;
import androidx.compose.ui.geometry.InlineClassHelperKt;
import androidx.compose.ui.geometry.Offset;
import androidx.compose.ui.input.pointer.util.PointerIdArray;
import androidx.compose.ui.layout.LayoutCoordinates;
import androidx.compose.ui.node.DelegatableNodeKt;
import androidx.compose.ui.node.DelegatingNode;
import androidx.compose.ui.node.LayoutNode;
import androidx.compose.ui.node.NodeCoordinator;
import androidx.compose.ui.node.NodeKind;
import androidx.compose.ui.node.PointerInputModifierNode;
import androidx.compose.ui.node.PointerInputModifierNodeKt;
import com.facebook.appevents.iap.InAppPurchaseConstants;
import java.util.ArrayList;
import java.util.List;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import org.jivesoftware.smackx.blocking.element.BlockContactsIQ;
import org.jivesoftware.smackx.iot.provisioning.element.ClearCache;

/* JADX INFO: compiled from: HitPathTracker.kt */
/* JADX INFO: loaded from: classes3.dex */
@Metadata(d1 = {"\u0000b\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\t\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\t\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\u000e\n\u0000\b\u0001\u0018\u00002\u00020\u0001B\u000f\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0004\b\u0004\u0010\u0005J\u001e\u0010\u0017\u001a\u00020\u00182\u0006\u0010\u0019\u001a\u00020\u001a2\f\u0010\u001b\u001a\b\u0012\u0004\u0012\u00020\u00000\u001cH\u0016J.\u0010\u001d\u001a\u00020\u00142\f\u0010\u001e\u001a\b\u0012\u0004\u0012\u00020\u000e0\r2\u0006\u0010\u001f\u001a\u00020\u00102\u0006\u0010 \u001a\u00020!2\u0006\u0010\"\u001a\u00020\u0014H\u0016J\u0010\u0010#\u001a\u00020\u00142\u0006\u0010 \u001a\u00020!H\u0016J.\u0010$\u001a\u00020\u00142\f\u0010\u001e\u001a\b\u0012\u0004\u0012\u00020\u000e0\r2\u0006\u0010\u001f\u001a\u00020\u00102\u0006\u0010 \u001a\u00020!2\u0006\u0010\"\u001a\u00020\u0014H\u0016J\u001a\u0010%\u001a\u00020\u00142\b\u0010&\u001a\u0004\u0018\u00010\u00122\u0006\u0010'\u001a\u00020\u0012H\u0002J\b\u0010(\u001a\u00020\u0018H\u0002J\u0017\u0010)\u001a\u00020\u00142\f\u0010*\u001a\b\u0012\u0004\u0012\u00020\u00180+H\u0082\bJ\b\u0010,\u001a\u00020\u0018H\u0016J\u0006\u0010-\u001a\u00020\u0018J\u0010\u0010.\u001a\u00020\u00182\u0006\u0010 \u001a\u00020!H\u0016J\b\u0010/\u001a\u000200H\u0016R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0006\u0010\u0007R\u0011\u0010\b\u001a\u00020\t¢\u0006\b\n\u0000\u001a\u0004\b\n\u0010\u000bR\u0014\u0010\f\u001a\b\u0012\u0004\u0012\u00020\u000e0\rX\u0082\u0004¢\u0006\u0002\n\u0000R\u0010\u0010\u000f\u001a\u0004\u0018\u00010\u0010X\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\u0011\u001a\u0004\u0018\u00010\u0012X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0013\u001a\u00020\u0014X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0015\u001a\u00020\u0014X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0016\u001a\u00020\u0014X\u0082\u000e¢\u0006\u0002\n\u0000¨\u00061"}, d2 = {"Landroidx/compose/ui/input/pointer/Node;", "Landroidx/compose/ui/input/pointer/NodeParent;", "modifierNode", "Landroidx/compose/ui/Modifier$Node;", "<init>", "(Landroidx/compose/ui/Modifier$Node;)V", "getModifierNode", "()Landroidx/compose/ui/Modifier$Node;", "pointerIds", "Landroidx/compose/ui/input/pointer/util/PointerIdArray;", "getPointerIds", "()Landroidx/compose/ui/input/pointer/util/PointerIdArray;", "relevantChanges", "Landroidx/collection/LongSparseArray;", "Landroidx/compose/ui/input/pointer/PointerInputChange;", "coordinates", "Landroidx/compose/ui/layout/LayoutCoordinates;", "pointerEvent", "Landroidx/compose/ui/input/pointer/PointerEvent;", "wasIn", "", "isIn", "hasExited", "removeInvalidPointerIdsAndChanges", "", "pointerIdValue", "", "hitNodes", "Landroidx/collection/MutableObjectList;", "dispatchMainEventPass", "changes", "parentCoordinates", "internalPointerEvent", "Landroidx/compose/ui/input/pointer/InternalPointerEvent;", "isInBounds", "dispatchFinalEventPass", "buildCache", "hasPositionChanged", "oldEvent", "newEvent", ClearCache.ELEMENT, "dispatchIfNeeded", BlockContactsIQ.ELEMENT, "Lkotlin/Function0;", "dispatchCancel", "markIsIn", "cleanUpHits", InAppPurchaseConstants.METHOD_TO_STRING, "", "ui"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final class Node extends NodeParent {
    public static final int $stable = 8;
    private LayoutCoordinates coordinates;
    private final Modifier.Node modifierNode;
    private PointerEvent pointerEvent;
    private boolean wasIn;
    private final PointerIdArray pointerIds = new PointerIdArray();
    private final LongSparseArray<PointerInputChange> relevantChanges = new LongSparseArray<>(2);
    private boolean isIn = true;
    private boolean hasExited = true;

    public Node(Modifier.Node node) {
        this.modifierNode = node;
    }

    public final Modifier.Node getModifierNode() {
        return this.modifierNode;
    }

    public final PointerIdArray getPointerIds() {
        return this.pointerIds;
    }

    @Override // androidx.compose.ui.input.pointer.NodeParent
    public void removeInvalidPointerIdsAndChanges(long pointerIdValue, MutableObjectList<Node> hitNodes) {
        if (this.pointerIds.contains(pointerIdValue) && !hitNodes.contains(this)) {
            this.pointerIds.remove(pointerIdValue);
            this.relevantChanges.remove(pointerIdValue);
        }
        MutableVector<Node> children = getChildren();
        Node[] nodeArr = children.content;
        int size = children.getSize();
        for (int i = 0; i < size; i++) {
            nodeArr[i].removeInvalidPointerIdsAndChanges(pointerIdValue, hitNodes);
        }
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r5v24 */
    @Override // androidx.compose.ui.input.pointer.NodeParent
    public boolean buildCache(LongSparseArray<PointerInputChange> changes, LayoutCoordinates parentCoordinates, InternalPointerEvent internalPointerEvent, boolean isInBounds) {
        PointerInputChange pointerInputChange;
        boolean z;
        int iM7257getExit7fucELk;
        boolean z2;
        int i;
        boolean z3;
        int i2;
        int i3;
        boolean zBuildCache = super.buildCache(changes, parentCoordinates, internalPointerEvent, isInBounds);
        boolean z4 = true;
        if (!this.modifierNode.getIsAttached()) {
            return true;
        }
        Modifier.Node nodePop = this.modifierNode;
        int iM7763constructorimpl = NodeKind.m7763constructorimpl(16);
        MutableVector mutableVector = null;
        while (nodePop != 0) {
            if (nodePop instanceof PointerInputModifierNode) {
                this.coordinates = PointerInputModifierNodeKt.getLayoutCoordinates((PointerInputModifierNode) nodePop);
            } else if ((nodePop.getKindSet() & iM7763constructorimpl) != 0 && (nodePop instanceof DelegatingNode)) {
                Modifier.Node delegate = ((DelegatingNode) nodePop).getDelegate();
                int i4 = 0;
                nodePop = nodePop;
                while (delegate != null) {
                    if ((delegate.getKindSet() & iM7763constructorimpl) != 0) {
                        i4++;
                        if (i4 == 1) {
                            nodePop = delegate;
                        } else {
                            if (mutableVector == null) {
                                mutableVector = new MutableVector(new Modifier.Node[16], 0);
                            }
                            if (nodePop != 0) {
                                if (mutableVector != null) {
                                    mutableVector.add(nodePop);
                                }
                                nodePop = 0;
                            }
                            if (mutableVector != null) {
                                mutableVector.add(delegate);
                            }
                        }
                    }
                    delegate = delegate.getChild();
                    nodePop = nodePop;
                }
                if (i4 == 1) {
                }
            }
            nodePop = DelegatableNodeKt.pop(mutableVector);
        }
        if (this.coordinates == null) {
            return true;
        }
        int size = changes.size();
        int i5 = 0;
        while (i5 < size) {
            long jKeyAt = changes.keyAt(i5);
            PointerInputChange pointerInputChangeValueAt = changes.valueAt(i5);
            if (this.pointerIds.contains(jKeyAt)) {
                boolean z5 = z4;
                int i6 = i5;
                long previousPosition = pointerInputChangeValueAt.getPreviousPosition();
                z3 = z5;
                long position = pointerInputChangeValueAt.getPosition();
                if ((((previousPosition & 9223372034707292159L) + InlineClassHelperKt.DualLoadedSignificand) & (-9223372034707292160L)) == 0 && (((position & 9223372034707292159L) + InlineClassHelperKt.DualLoadedSignificand) & (-9223372034707292160L)) == 0) {
                    ArrayList arrayList = new ArrayList(pointerInputChangeValueAt.getHistorical().size());
                    List<HistoricalChange> historical = pointerInputChangeValueAt.getHistorical();
                    z2 = zBuildCache;
                    int size2 = historical.size();
                    i = size;
                    int i7 = 0;
                    while (i7 < size2) {
                        HistoricalChange historicalChange = historical.get(i7);
                        int i8 = size2;
                        int i9 = i7;
                        long position2 = historicalChange.getPosition();
                        if ((((position2 & 9223372034707292159L) + InlineClassHelperKt.DualLoadedSignificand) & (-9223372034707292160L)) == 0) {
                            long uptimeMillis = historicalChange.getUptimeMillis();
                            i3 = i6;
                            LayoutCoordinates layoutCoordinates = this.coordinates;
                            Intrinsics.checkNotNull(layoutCoordinates);
                            arrayList.add(new HistoricalChange(uptimeMillis, layoutCoordinates.mo7454localPositionOfR5De75A(parentCoordinates, position2), historicalChange.getScaleFactor(), historicalChange.getPanOffset(), historicalChange.getOriginalEventPosition(), (DefaultConstructorMarker) null));
                        } else {
                            i3 = i6;
                        }
                        i7 = i9 + 1;
                        size2 = i8;
                        i6 = i3;
                    }
                    i2 = i6;
                    LongSparseArray<PointerInputChange> longSparseArray = this.relevantChanges;
                    LayoutCoordinates layoutCoordinates2 = this.coordinates;
                    Intrinsics.checkNotNull(layoutCoordinates2);
                    long jMo7454localPositionOfR5De75A = layoutCoordinates2.mo7454localPositionOfR5De75A(parentCoordinates, previousPosition);
                    LayoutCoordinates layoutCoordinates3 = this.coordinates;
                    Intrinsics.checkNotNull(layoutCoordinates3);
                    longSparseArray.put(jKeyAt, PointerInputChange.m7298copyOHpmEuE$default(pointerInputChangeValueAt, 0L, 0L, layoutCoordinates3.mo7454localPositionOfR5De75A(parentCoordinates, position), false, 0L, jMo7454localPositionOfR5De75A, false, 0, arrayList, 0L, 731, null));
                } else {
                    z2 = zBuildCache;
                    i = size;
                    i2 = i6;
                }
            } else {
                z2 = zBuildCache;
                i = size;
                z3 = z4;
                i2 = i5;
            }
            i5 = i2 + 1;
            z4 = z3;
            zBuildCache = z2;
            size = i;
        }
        boolean z6 = zBuildCache;
        boolean z7 = z4;
        if (this.relevantChanges.isEmpty()) {
            this.pointerIds.clear();
            getChildren().clear();
            return z7;
        }
        int size3 = this.pointerIds.getSize();
        while (true) {
            size3--;
            if (-1 >= size3) {
                break;
            }
            if (!changes.containsKey(this.pointerIds.m7415get_I2yYro(size3))) {
                this.pointerIds.removeAt(size3);
            }
        }
        ArrayList arrayList2 = new ArrayList(this.relevantChanges.size());
        int size4 = this.relevantChanges.size();
        for (int i10 = 0; i10 < size4; i10++) {
            arrayList2.add(this.relevantChanges.valueAt(i10));
        }
        PointerEvent pointerEvent = new PointerEvent(arrayList2, internalPointerEvent);
        List<PointerInputChange> changes2 = pointerEvent.getChanges();
        int size5 = changes2.size();
        int i11 = 0;
        while (true) {
            if (i11 >= size5) {
                pointerInputChange = null;
                break;
            }
            PointerInputChange pointerInputChange2 = changes2.get(i11);
            if (internalPointerEvent.m7217activeHoverEvent0FcD4WY(pointerInputChange2.getId())) {
                pointerInputChange = pointerInputChange2;
                break;
            }
            i11++;
        }
        PointerInputChange pointerInputChange3 = pointerInputChange;
        if (pointerInputChange3 != null) {
            if (!isInBounds) {
                z = false;
                this.isIn = false;
            } else {
                z = false;
                if (!this.isIn && (pointerInputChange3.getPressed() || pointerInputChange3.getPreviousPressed())) {
                    Intrinsics.checkNotNull(this.coordinates);
                    this.isIn = !PointerEventKt.m7247isOutOfBoundsO0kMr_c(pointerInputChange3, r3.mo7453getSizeYbymL2g());
                }
            }
            if (this.isIn != this.wasIn && (PointerEventType.m7252equalsimpl0(pointerEvent.getType(), PointerEventType.INSTANCE.m7258getMove7fucELk()) || PointerEventType.m7252equalsimpl0(pointerEvent.getType(), PointerEventType.INSTANCE.m7256getEnter7fucELk()) || PointerEventType.m7252equalsimpl0(pointerEvent.getType(), PointerEventType.INSTANCE.m7257getExit7fucELk()))) {
                if (this.isIn) {
                    iM7257getExit7fucELk = PointerEventType.INSTANCE.m7256getEnter7fucELk();
                } else {
                    iM7257getExit7fucELk = PointerEventType.INSTANCE.m7257getExit7fucELk();
                }
                pointerEvent.m7246setTypeEhbLWgg$ui(iM7257getExit7fucELk);
            } else if (PointerEventType.m7252equalsimpl0(pointerEvent.getType(), PointerEventType.INSTANCE.m7256getEnter7fucELk()) && this.wasIn && !this.hasExited) {
                pointerEvent.m7246setTypeEhbLWgg$ui(PointerEventType.INSTANCE.m7258getMove7fucELk());
            } else if (PointerEventType.m7252equalsimpl0(pointerEvent.getType(), PointerEventType.INSTANCE.m7257getExit7fucELk()) && this.isIn && pointerInputChange3.getPressed()) {
                pointerEvent.m7246setTypeEhbLWgg$ui(PointerEventType.INSTANCE.m7258getMove7fucELk());
            }
        } else {
            z = false;
        }
        boolean z8 = (z6 || !PointerEventType.m7252equalsimpl0(pointerEvent.getType(), PointerEventType.INSTANCE.m7258getMove7fucELk()) || hasPositionChanged(this.pointerEvent, pointerEvent)) ? z7 : z;
        this.pointerEvent = pointerEvent;
        return z8;
    }

    private final boolean hasPositionChanged(PointerEvent oldEvent, PointerEvent newEvent) {
        if (oldEvent == null || oldEvent.getChanges().size() != newEvent.getChanges().size()) {
            return true;
        }
        int size = newEvent.getChanges().size();
        for (int i = 0; i < size; i++) {
            if (!Offset.m5720equalsimpl0(oldEvent.getChanges().get(i).getPosition(), newEvent.getChanges().get(i).getPosition())) {
                return true;
            }
        }
        return false;
    }

    private final void clearCache() {
        this.relevantChanges.clear();
        this.coordinates = null;
    }

    private final boolean dispatchIfNeeded(Function0<Unit> block) {
        LayoutNode layoutNode;
        if (this.relevantChanges.isEmpty() || !this.modifierNode.getIsAttached()) {
            return false;
        }
        NodeCoordinator coordinator = this.modifierNode.getCoordinator();
        if (!((coordinator == null || (layoutNode = coordinator.getLayoutNode()) == null) ? false : layoutNode.isPlaced())) {
            return false;
        }
        block.invoke();
        return true;
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r0v8 */
    @Override // androidx.compose.ui.input.pointer.NodeParent
    public void dispatchCancel() {
        MutableVector<Node> children = getChildren();
        Node[] nodeArr = children.content;
        int size = children.getSize();
        for (int i = 0; i < size; i++) {
            nodeArr[i].dispatchCancel();
        }
        Modifier.Node nodePop = this.modifierNode;
        int iM7763constructorimpl = NodeKind.m7763constructorimpl(16);
        MutableVector mutableVector = null;
        while (nodePop != 0) {
            if (nodePop instanceof PointerInputModifierNode) {
                ((PointerInputModifierNode) nodePop).onCancelPointerInput();
            } else if ((nodePop.getKindSet() & iM7763constructorimpl) != 0 && (nodePop instanceof DelegatingNode)) {
                Modifier.Node delegate = ((DelegatingNode) nodePop).getDelegate();
                int i2 = 0;
                nodePop = nodePop;
                while (delegate != null) {
                    if ((delegate.getKindSet() & iM7763constructorimpl) != 0) {
                        i2++;
                        if (i2 == 1) {
                            nodePop = delegate;
                        } else {
                            if (mutableVector == null) {
                                mutableVector = new MutableVector(new Modifier.Node[16], 0);
                            }
                            if (nodePop != 0) {
                                if (mutableVector != null) {
                                    mutableVector.add(nodePop);
                                }
                                nodePop = 0;
                            }
                            if (mutableVector != null) {
                                mutableVector.add(delegate);
                            }
                        }
                    }
                    delegate = delegate.getChild();
                    nodePop = nodePop;
                }
                if (i2 == 1) {
                }
            }
            nodePop = DelegatableNodeKt.pop(mutableVector);
        }
    }

    public final void markIsIn() {
        this.isIn = true;
    }

    @Override // androidx.compose.ui.input.pointer.NodeParent
    public void cleanUpHits(InternalPointerEvent internalPointerEvent) {
        super.cleanUpHits(internalPointerEvent);
        PointerEvent pointerEvent = this.pointerEvent;
        if (pointerEvent == null) {
            return;
        }
        this.wasIn = this.isIn;
        List<PointerInputChange> changes = pointerEvent.getChanges();
        int size = changes.size();
        for (int i = 0; i < size; i++) {
            PointerInputChange pointerInputChange = changes.get(i);
            boolean pressed = pointerInputChange.getPressed();
            boolean zM7217activeHoverEvent0FcD4WY = internalPointerEvent.m7217activeHoverEvent0FcD4WY(pointerInputChange.getId());
            boolean z = this.isIn;
            if ((!pressed && !zM7217activeHoverEvent0FcD4WY) || (!pressed && !z)) {
                this.pointerIds.remove(pointerInputChange.getId());
            }
        }
        this.isIn = false;
        this.hasExited = PointerEventType.m7252equalsimpl0(pointerEvent.getType(), PointerEventType.INSTANCE.m7257getExit7fucELk());
    }

    public String toString() {
        return "Node(modifierNode=" + this.modifierNode + ", children=" + getChildren() + ", pointerIds=" + this.pointerIds + ')';
    }

    @Override // androidx.compose.ui.input.pointer.NodeParent
    public boolean dispatchMainEventPass(LongSparseArray<PointerInputChange> changes, LayoutCoordinates parentCoordinates, InternalPointerEvent internalPointerEvent, boolean isInBounds) {
        boolean z;
        boolean z2;
        LayoutNode layoutNode;
        if (this.relevantChanges.isEmpty() || !this.modifierNode.getIsAttached()) {
            return false;
        }
        NodeCoordinator coordinator = this.modifierNode.getCoordinator();
        if (!((coordinator == null || (layoutNode = coordinator.getLayoutNode()) == null) ? false : layoutNode.isPlaced())) {
            return false;
        }
        PointerEvent pointerEvent = this.pointerEvent;
        Intrinsics.checkNotNull(pointerEvent);
        LayoutCoordinates layoutCoordinates = this.coordinates;
        Intrinsics.checkNotNull(layoutCoordinates);
        long jMo7453getSizeYbymL2g = layoutCoordinates.mo7453getSizeYbymL2g();
        Modifier.Node nodePop = this.modifierNode;
        int iM7763constructorimpl = NodeKind.m7763constructorimpl(16);
        MutableVector mutableVector = null;
        while (nodePop != null) {
            if (nodePop instanceof PointerInputModifierNode) {
                ((PointerInputModifierNode) nodePop).mo280onPointerEventH0pRuoY(pointerEvent, PointerEventPass.Initial, jMo7453getSizeYbymL2g);
                z2 = false;
            } else {
                z2 = true;
            }
            if (z2) {
                if (((nodePop.getKindSet() & iM7763constructorimpl) != 0) && (nodePop instanceof DelegatingNode)) {
                    int i = 0;
                    for (Modifier.Node delegate = ((DelegatingNode) nodePop).getDelegate(); delegate != null; delegate = delegate.getChild()) {
                        if ((delegate.getKindSet() & iM7763constructorimpl) != 0) {
                            i++;
                            if (i == 1) {
                                nodePop = delegate;
                            } else {
                                if (mutableVector == null) {
                                    mutableVector = new MutableVector(new Modifier.Node[16], 0);
                                }
                                if (nodePop != null) {
                                    if (mutableVector != null) {
                                        mutableVector.add(nodePop);
                                    }
                                    nodePop = null;
                                }
                                if (mutableVector != null) {
                                    mutableVector.add(delegate);
                                }
                            }
                        }
                    }
                    if (i == 1) {
                    }
                }
            }
            nodePop = DelegatableNodeKt.pop(mutableVector);
        }
        if (this.modifierNode.getIsAttached()) {
            MutableVector<Node> children = getChildren();
            Node[] nodeArr = children.content;
            int size = children.getSize();
            for (int i2 = 0; i2 < size; i2++) {
                Node node = nodeArr[i2];
                LongSparseArray<PointerInputChange> longSparseArray = this.relevantChanges;
                LayoutCoordinates layoutCoordinates2 = this.coordinates;
                Intrinsics.checkNotNull(layoutCoordinates2);
                node.dispatchMainEventPass(longSparseArray, layoutCoordinates2, internalPointerEvent, isInBounds);
            }
        }
        if (this.modifierNode.getIsAttached()) {
            Modifier.Node nodePop2 = this.modifierNode;
            int iM7763constructorimpl2 = NodeKind.m7763constructorimpl(16);
            MutableVector mutableVector2 = null;
            while (nodePop2 != null) {
                if (nodePop2 instanceof PointerInputModifierNode) {
                    ((PointerInputModifierNode) nodePop2).mo280onPointerEventH0pRuoY(pointerEvent, PointerEventPass.Main, jMo7453getSizeYbymL2g);
                    z = false;
                } else {
                    z = true;
                }
                if (z) {
                    if (((nodePop2.getKindSet() & iM7763constructorimpl2) != 0) && (nodePop2 instanceof DelegatingNode)) {
                        int i3 = 0;
                        for (Modifier.Node delegate2 = ((DelegatingNode) nodePop2).getDelegate(); delegate2 != null; delegate2 = delegate2.getChild()) {
                            if ((delegate2.getKindSet() & iM7763constructorimpl2) != 0) {
                                i3++;
                                if (i3 == 1) {
                                    nodePop2 = delegate2;
                                } else {
                                    if (mutableVector2 == null) {
                                        mutableVector2 = new MutableVector(new Modifier.Node[16], 0);
                                    }
                                    if (nodePop2 != null) {
                                        if (mutableVector2 != null) {
                                            mutableVector2.add(nodePop2);
                                        }
                                        nodePop2 = null;
                                    }
                                    if (mutableVector2 != null) {
                                        mutableVector2.add(delegate2);
                                    }
                                }
                            }
                        }
                        if (i3 == 1) {
                        }
                    }
                }
                nodePop2 = DelegatableNodeKt.pop(mutableVector2);
            }
        }
        return true;
    }

    /* JADX WARN: Multi-variable type inference failed */
    @Override // androidx.compose.ui.input.pointer.NodeParent
    public boolean dispatchFinalEventPass(InternalPointerEvent internalPointerEvent) {
        Object[] objArr;
        LayoutNode layoutNode;
        boolean z = false;
        z = false;
        z = false;
        if (!this.relevantChanges.isEmpty() && this.modifierNode.getIsAttached()) {
            NodeCoordinator coordinator = this.modifierNode.getCoordinator();
            if ((coordinator == null || (layoutNode = coordinator.getLayoutNode()) == null) ? false : layoutNode.isPlaced()) {
                PointerEvent pointerEvent = this.pointerEvent;
                Intrinsics.checkNotNull(pointerEvent);
                LayoutCoordinates layoutCoordinates = this.coordinates;
                Intrinsics.checkNotNull(layoutCoordinates);
                long jMo7453getSizeYbymL2g = layoutCoordinates.mo7453getSizeYbymL2g();
                Modifier.Node nodePop = this.modifierNode;
                int iM7763constructorimpl = NodeKind.m7763constructorimpl(16);
                MutableVector mutableVector = null;
                while (nodePop != null) {
                    if (nodePop instanceof PointerInputModifierNode) {
                        ((PointerInputModifierNode) nodePop).mo280onPointerEventH0pRuoY(pointerEvent, PointerEventPass.Final, jMo7453getSizeYbymL2g);
                        objArr = false;
                    } else {
                        objArr = true;
                    }
                    if (objArr != false) {
                        if (((nodePop.getKindSet() & iM7763constructorimpl) != 0) != false && (nodePop instanceof DelegatingNode)) {
                            int i = 0;
                            for (Modifier.Node delegate = ((DelegatingNode) nodePop).getDelegate(); delegate != null; delegate = delegate.getChild()) {
                                if (((delegate.getKindSet() & iM7763constructorimpl) != 0) != false) {
                                    i++;
                                    if (i == 1) {
                                        nodePop = delegate;
                                    } else {
                                        if (mutableVector == null) {
                                            mutableVector = new MutableVector(new Modifier.Node[16], 0);
                                        }
                                        if (nodePop != null) {
                                            if (mutableVector != null) {
                                                mutableVector.add(nodePop);
                                            }
                                            nodePop = null;
                                        }
                                        if (mutableVector != null) {
                                            mutableVector.add(delegate);
                                        }
                                    }
                                }
                            }
                            if (i == 1) {
                            }
                        }
                    }
                    nodePop = DelegatableNodeKt.pop(mutableVector);
                }
                if (this.modifierNode.getIsAttached()) {
                    MutableVector<Node> children = getChildren();
                    Node[] nodeArr = children.content;
                    int size = children.getSize();
                    for (int i2 = 0; i2 < size; i2++) {
                        nodeArr[i2].dispatchFinalEventPass(internalPointerEvent);
                    }
                }
                z = true;
            }
        }
        cleanUpHits(internalPointerEvent);
        clearCache();
        return z;
    }
}
