package com.google.firebase.database.snapshot;

import com.google.firebase.database.snapshot.LeafNode;
import com.google.firebase.database.snapshot.Node;
import java.util.Map;

/* JADX INFO: compiled from: com.google.firebase:firebase-database@@19.1.0 */
/* JADX INFO: loaded from: classes9.dex */
public class DeferredValueNode extends LeafNode<DeferredValueNode> {
    static final /* synthetic */ boolean $assertionsDisabled = false;
    private Map<Object, Object> value;

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.google.firebase.database.snapshot.LeafNode
    public int compareLeafValues(DeferredValueNode deferredValueNode) {
        return 0;
    }

    public DeferredValueNode(Map<Object, Object> map, Node node) {
        super(node);
        this.value = map;
    }

    @Override // com.google.firebase.database.snapshot.Node
    public Object getValue() {
        return this.value;
    }

    @Override // com.google.firebase.database.snapshot.Node
    public String getHashRepresentation(Node.HashVersion hashVersion) {
        return getPriorityHash(hashVersion) + "deferredValue:" + this.value;
    }

    @Override // com.google.firebase.database.snapshot.Node
    public DeferredValueNode updatePriority(Node node) {
        return new DeferredValueNode(this.value, node);
    }

    @Override // com.google.firebase.database.snapshot.LeafNode
    protected LeafNode.LeafType getLeafType() {
        return LeafNode.LeafType.DeferredValue;
    }

    @Override // com.google.firebase.database.snapshot.LeafNode
    public boolean equals(Object obj) {
        if (!(obj instanceof DeferredValueNode)) {
            return false;
        }
        DeferredValueNode deferredValueNode = (DeferredValueNode) obj;
        return this.value.equals(deferredValueNode.value) && this.priority.equals(deferredValueNode.priority);
    }

    @Override // com.google.firebase.database.snapshot.LeafNode
    public int hashCode() {
        return this.value.hashCode() + this.priority.hashCode();
    }
}
