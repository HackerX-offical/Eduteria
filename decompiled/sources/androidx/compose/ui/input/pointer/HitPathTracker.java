package androidx.compose.ui.input.pointer;

import androidx.collection.MutableLongObjectMap;
import androidx.collection.MutableObjectList;
import androidx.compose.ui.Modifier;
import androidx.compose.ui.layout.LayoutCoordinates;
import java.util.List;
import kotlin.Metadata;

/* JADX INFO: compiled from: HitPathTracker.kt */
/* JADX INFO: loaded from: classes3.dex */
@Metadata(d1 = {"\u0000Z\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010 \n\u0002\b\u0006\n\u0002\u0010\t\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0004\b\u0001\u0018\u00002\u00020\u0001B\u000f\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0004\b\u0004\u0010\u0005J-\u0010\u0015\u001a\u00020\u00162\u0006\u0010\u0017\u001a\u00020\u00182\f\u0010\u0019\u001a\b\u0012\u0004\u0012\u00020\r0\u001a2\b\b\u0002\u0010\u001b\u001a\u00020\u0007¢\u0006\u0004\b\u001c\u0010\u001dJ\u0010\u0010\u001e\u001a\u00020\u00162\u0006\u0010\u001f\u001a\u00020\rH\u0002J\u001e\u0010 \u001a\u00020\u00162\u0006\u0010\u0017\u001a\u00020!2\f\u0010\"\u001a\b\u0012\u0004\u0012\u00020\u00140\fH\u0002J\u0018\u0010#\u001a\u00020\u00072\u0006\u0010$\u001a\u00020%2\b\b\u0002\u0010&\u001a\u00020\u0007J\u0006\u0010'\u001a\u00020\u0016J\u0006\u0010(\u001a\u00020\u0016R\u000e\u0010\u0002\u001a\u00020\u0003X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0006\u001a\u00020\u0007X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\b\u001a\u00020\u0007X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\t\u001a\u00020\u0007X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\n\u001a\u00020\u0007X\u0082\u000e¢\u0006\u0002\n\u0000R\u0014\u0010\u000b\u001a\b\u0012\u0004\u0012\u00020\r0\fX\u0082\u0004¢\u0006\u0002\n\u0000R\u0014\u0010\u000e\u001a\u00020\u000fX\u0080\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0010\u0010\u0011R\u001a\u0010\u0012\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00140\f0\u0013X\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006)"}, d2 = {"Landroidx/compose/ui/input/pointer/HitPathTracker;", "", "rootCoordinates", "Landroidx/compose/ui/layout/LayoutCoordinates;", "<init>", "(Landroidx/compose/ui/layout/LayoutCoordinates;)V", "dispatchingEvent", "", "dispatchCancelAfterDispatchedEvent", "clearNodeCacheAfterDispatchedEvent", "removeSpecificNodesAfterDispatchedEvent", "nodesToRemove", "Landroidx/collection/MutableObjectList;", "Landroidx/compose/ui/Modifier$Node;", "root", "Landroidx/compose/ui/input/pointer/NodeParent;", "getRoot$ui", "()Landroidx/compose/ui/input/pointer/NodeParent;", "hitPointerIdsAndNodesForPruningNonMatches", "Landroidx/collection/MutableLongObjectMap;", "Landroidx/compose/ui/input/pointer/Node;", "addHitPath", "", "pointerId", "Landroidx/compose/ui/input/pointer/PointerId;", "pointerInputNodes", "", "prunePointerIdsAndChangesNotInNodesList", "addHitPath-QJqDSyo", "(JLjava/util/List;Z)V", "removePointerInputModifierNode", "pointerInputNode", "removeInvalidPointerIdsAndChanges", "", "hitNodes", "dispatchChanges", "internalPointerEvent", "Landroidx/compose/ui/input/pointer/InternalPointerEvent;", "isInBounds", "clearPreviouslyHitModifierNodeCache", "processCancel", "ui"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final class HitPathTracker {
    public static final int $stable = 8;
    private boolean clearNodeCacheAfterDispatchedEvent;
    private boolean dispatchCancelAfterDispatchedEvent;
    private boolean dispatchingEvent;
    private boolean removeSpecificNodesAfterDispatchedEvent;
    private final LayoutCoordinates rootCoordinates;
    private final MutableObjectList<Modifier.Node> nodesToRemove = new MutableObjectList<>(0, 1, null);
    private final NodeParent root = new NodeParent();
    private final MutableLongObjectMap<MutableObjectList<Node>> hitPointerIdsAndNodesForPruningNonMatches = new MutableLongObjectMap<>(10);

    public HitPathTracker(LayoutCoordinates layoutCoordinates) {
        this.rootCoordinates = layoutCoordinates;
    }

    /* JADX INFO: renamed from: getRoot$ui, reason: from getter */
    public final NodeParent getRoot() {
        return this.root;
    }

    /* JADX INFO: renamed from: addHitPath-QJqDSyo$default, reason: not valid java name */
    public static /* synthetic */ void m7214addHitPathQJqDSyo$default(HitPathTracker hitPathTracker, long j, List list, boolean z, int i, Object obj) {
        if ((i & 4) != 0) {
            z = false;
        }
        hitPathTracker.m7215addHitPathQJqDSyo(j, list, z);
    }

    /* JADX WARN: Removed duplicated region for block: B:49:0x00fb  */
    /* JADX INFO: renamed from: addHitPath-QJqDSyo, reason: not valid java name */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final void m7215addHitPathQJqDSyo(long r18, java.util.List<? extends androidx.compose.ui.Modifier.Node> r20, boolean r21) {
        /*
            Method dump skipped, instruction units count: 262
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.compose.ui.input.pointer.HitPathTracker.m7215addHitPathQJqDSyo(long, java.util.List, boolean):void");
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void removePointerInputModifierNode(Modifier.Node pointerInputNode) {
        if (this.dispatchingEvent) {
            this.removeSpecificNodesAfterDispatchedEvent = true;
            this.nodesToRemove.add(pointerInputNode);
        } else {
            this.root.removePointerInputModifierNode(pointerInputNode);
        }
    }

    private final void removeInvalidPointerIdsAndChanges(long pointerId, MutableObjectList<Node> hitNodes) {
        this.root.removeInvalidPointerIdsAndChanges(pointerId, hitNodes);
    }

    public static /* synthetic */ boolean dispatchChanges$default(HitPathTracker hitPathTracker, InternalPointerEvent internalPointerEvent, boolean z, int i, Object obj) {
        if ((i & 2) != 0) {
            z = true;
        }
        return hitPathTracker.dispatchChanges(internalPointerEvent, z);
    }

    public final boolean dispatchChanges(InternalPointerEvent internalPointerEvent, boolean isInBounds) {
        if (!this.root.buildCache(internalPointerEvent.getChanges(), this.rootCoordinates, internalPointerEvent, isInBounds)) {
            return false;
        }
        boolean z = true;
        this.dispatchingEvent = true;
        boolean zDispatchMainEventPass = this.root.dispatchMainEventPass(internalPointerEvent.getChanges(), this.rootCoordinates, internalPointerEvent, isInBounds);
        if (!this.root.dispatchFinalEventPass(internalPointerEvent) && !zDispatchMainEventPass) {
            z = false;
        }
        this.dispatchingEvent = false;
        if (this.removeSpecificNodesAfterDispatchedEvent) {
            this.removeSpecificNodesAfterDispatchedEvent = false;
            int size = this.nodesToRemove.getSize();
            for (int i = 0; i < size; i++) {
                removePointerInputModifierNode(this.nodesToRemove.get(i));
            }
            this.nodesToRemove.clear();
        }
        if (this.dispatchCancelAfterDispatchedEvent) {
            this.dispatchCancelAfterDispatchedEvent = false;
            processCancel();
        }
        if (this.clearNodeCacheAfterDispatchedEvent) {
            this.clearNodeCacheAfterDispatchedEvent = false;
            clearPreviouslyHitModifierNodeCache();
        }
        return z;
    }

    public final void clearPreviouslyHitModifierNodeCache() {
        if (this.clearNodeCacheAfterDispatchedEvent) {
            this.clearNodeCacheAfterDispatchedEvent = true;
        } else {
            this.root.clear();
        }
    }

    public final void processCancel() {
        if (this.dispatchingEvent) {
            this.dispatchCancelAfterDispatchedEvent = true;
        } else {
            this.root.dispatchCancel();
            clearPreviouslyHitModifierNodeCache();
        }
    }
}
