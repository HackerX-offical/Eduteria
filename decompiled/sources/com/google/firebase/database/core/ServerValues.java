package com.google.firebase.database.core;

import com.google.firebase.database.core.SparseSnapshotTree;
import com.google.firebase.database.core.utilities.Clock;
import com.google.firebase.database.snapshot.ChildKey;
import com.google.firebase.database.snapshot.ChildrenNode;
import com.google.firebase.database.snapshot.Node;
import com.google.firebase.database.snapshot.NodeUtilities;
import com.google.firebase.database.snapshot.PriorityUtilities;
import java.util.HashMap;
import java.util.Map;

/* JADX INFO: compiled from: com.google.firebase:firebase-database@@19.1.0 */
/* JADX INFO: loaded from: classes9.dex */
public class ServerValues {
    public static final String NAME_SUBKEY_SERVERVALUE = ".sv";

    public static Map<String, Object> generateServerValues(Clock clock) {
        HashMap map = new HashMap();
        map.put("timestamp", Long.valueOf(clock.millis()));
        return map;
    }

    public static Object resolveDeferredValue(Object obj, Map<String, Object> map) {
        if (!(obj instanceof Map)) {
            return obj;
        }
        Map map2 = (Map) obj;
        if (!map2.containsKey(NAME_SUBKEY_SERVERVALUE)) {
            return obj;
        }
        String str = (String) map2.get(NAME_SUBKEY_SERVERVALUE);
        return map.containsKey(str) ? map.get(str) : obj;
    }

    public static SparseSnapshotTree resolveDeferredValueTree(SparseSnapshotTree sparseSnapshotTree, final Map<String, Object> map) {
        final SparseSnapshotTree sparseSnapshotTree2 = new SparseSnapshotTree();
        sparseSnapshotTree.forEachTree(new Path(""), new SparseSnapshotTree.SparseSnapshotTreeVisitor() { // from class: com.google.firebase.database.core.ServerValues.1
            @Override // com.google.firebase.database.core.SparseSnapshotTree.SparseSnapshotTreeVisitor
            public void visitTree(Path path, Node node) {
                sparseSnapshotTree2.remember(path, ServerValues.resolveDeferredValueSnapshot(node, map));
            }
        });
        return sparseSnapshotTree2;
    }

    public static Node resolveDeferredValueSnapshot(Node node, final Map<String, Object> map) {
        Object value = node.getPriority().getValue();
        if (value instanceof Map) {
            Map map2 = (Map) value;
            if (map2.containsKey(NAME_SUBKEY_SERVERVALUE)) {
                value = map.get((String) map2.get(NAME_SUBKEY_SERVERVALUE));
            }
        }
        Node priority = PriorityUtilities.parsePriority(value);
        if (node.isLeafNode()) {
            Object objResolveDeferredValue = resolveDeferredValue(node.getValue(), map);
            if (!objResolveDeferredValue.equals(node.getValue()) || !priority.equals(node.getPriority())) {
                return NodeUtilities.NodeFromJSON(objResolveDeferredValue, priority);
            }
        } else if (!node.isEmpty()) {
            ChildrenNode childrenNode = (ChildrenNode) node;
            final SnapshotHolder snapshotHolder = new SnapshotHolder(childrenNode);
            childrenNode.forEachChild(new ChildrenNode.ChildVisitor() { // from class: com.google.firebase.database.core.ServerValues.2
                @Override // com.google.firebase.database.snapshot.ChildrenNode.ChildVisitor
                public void visitChild(ChildKey childKey, Node node2) {
                    Node nodeResolveDeferredValueSnapshot = ServerValues.resolveDeferredValueSnapshot(node2, map);
                    if (nodeResolveDeferredValueSnapshot != node2) {
                        snapshotHolder.update(new Path(childKey.asString()), nodeResolveDeferredValueSnapshot);
                    }
                }
            });
            if (!snapshotHolder.getRootNode().getPriority().equals(priority)) {
                return snapshotHolder.getRootNode().updatePriority(priority);
            }
            return snapshotHolder.getRootNode();
        }
        return node;
    }

    public static CompoundWrite resolveDeferredValueMerge(CompoundWrite compoundWrite, Map<String, Object> map) {
        CompoundWrite compoundWriteEmptyWrite = CompoundWrite.emptyWrite();
        for (Map.Entry<Path, Node> entry : compoundWrite) {
            compoundWriteEmptyWrite = compoundWriteEmptyWrite.addWrite(entry.getKey(), resolveDeferredValueSnapshot(entry.getValue(), map));
        }
        return compoundWriteEmptyWrite;
    }
}
