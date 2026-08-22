package com.google.firebase.database.core.operation;

import com.google.firebase.database.core.Path;
import com.google.firebase.database.core.operation.Operation;
import com.google.firebase.database.snapshot.ChildKey;

/* JADX INFO: compiled from: com.google.firebase:firebase-database@@19.1.0 */
/* JADX INFO: loaded from: classes9.dex */
public class ListenComplete extends Operation {
    static final /* synthetic */ boolean $assertionsDisabled = false;

    public ListenComplete(OperationSource operationSource, Path path) {
        super(Operation.OperationType.ListenComplete, operationSource, path);
    }

    @Override // com.google.firebase.database.core.operation.Operation
    public Operation operationForChild(ChildKey childKey) {
        if (this.path.isEmpty()) {
            return new ListenComplete(this.source, Path.getEmptyPath());
        }
        return new ListenComplete(this.source, this.path.popFront());
    }

    public String toString() {
        return String.format("ListenComplete { path=%s, source=%s }", getPath(), getSource());
    }
}
