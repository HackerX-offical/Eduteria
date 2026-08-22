package com.google.firebase.database.snapshot;

import com.google.firebase.database.core.Path;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;

/* JADX INFO: compiled from: com.google.firebase:firebase-database@@19.1.0 */
/* JADX INFO: loaded from: classes9.dex */
public class RangeMerge {
    static final /* synthetic */ boolean $assertionsDisabled = false;
    private final Path optExclusiveStart;
    private final Path optInclusiveEnd;
    private final Node snap;

    public RangeMerge(Path path, Path path2, Node node) {
        this.optExclusiveStart = path;
        this.optInclusiveEnd = path2;
        this.snap = node;
    }

    public RangeMerge(com.google.firebase.database.connection.RangeMerge rangeMerge) {
        List<String> optExclusiveStart = rangeMerge.getOptExclusiveStart();
        this.optExclusiveStart = optExclusiveStart != null ? new Path(optExclusiveStart) : null;
        List<String> optInclusiveEnd = rangeMerge.getOptInclusiveEnd();
        this.optInclusiveEnd = optInclusiveEnd != null ? new Path(optInclusiveEnd) : null;
        this.snap = NodeUtilities.NodeFromJSON(rangeMerge.getSnap());
    }

    public Node applyTo(Node node) {
        return updateRangeInNode(Path.getEmptyPath(), node, this.snap);
    }

    Path getStart() {
        return this.optExclusiveStart;
    }

    Path getEnd() {
        return this.optInclusiveEnd;
    }

    private Node updateRangeInNode(Path path, Node node, Node node2) {
        Path path2 = this.optExclusiveStart;
        int iCompareTo = path2 == null ? 1 : path.compareTo(path2);
        Path path3 = this.optInclusiveEnd;
        int iCompareTo2 = path3 == null ? -1 : path.compareTo(path3);
        Path path4 = this.optExclusiveStart;
        boolean z = false;
        boolean z2 = path4 != null && path.contains(path4);
        Path path5 = this.optInclusiveEnd;
        if (path5 != null && path.contains(path5)) {
            z = true;
        }
        if ((iCompareTo > 0 && iCompareTo2 < 0 && !z) || (iCompareTo > 0 && z && node2.isLeafNode())) {
            return node2;
        }
        if (iCompareTo > 0 && iCompareTo2 == 0) {
            return node.isLeafNode() ? EmptyNode.Empty() : node;
        }
        if (!z2 && !z) {
            return node;
        }
        HashSet hashSet = new HashSet();
        Iterator<NamedNode> it = node.iterator();
        while (it.hasNext()) {
            hashSet.add(it.next().getName());
        }
        Iterator<NamedNode> it2 = node2.iterator();
        while (it2.hasNext()) {
            hashSet.add(it2.next().getName());
        }
        ArrayList<ChildKey> arrayList = new ArrayList(hashSet.size() + 1);
        arrayList.addAll(hashSet);
        if (!node2.getPriority().isEmpty() || !node.getPriority().isEmpty()) {
            arrayList.add(ChildKey.getPriorityKey());
        }
        Node nodeUpdateImmediateChild = node;
        for (ChildKey childKey : arrayList) {
            Node immediateChild = node.getImmediateChild(childKey);
            Node nodeUpdateRangeInNode = updateRangeInNode(path.child(childKey), node.getImmediateChild(childKey), node2.getImmediateChild(childKey));
            if (nodeUpdateRangeInNode != immediateChild) {
                nodeUpdateImmediateChild = nodeUpdateImmediateChild.updateImmediateChild(childKey, nodeUpdateRangeInNode);
            }
        }
        return nodeUpdateImmediateChild;
    }

    public String toString() {
        return "RangeMerge{optExclusiveStart=" + this.optExclusiveStart + ", optInclusiveEnd=" + this.optInclusiveEnd + ", snap=" + this.snap + '}';
    }
}
