package com.google.firebase.database.core.operation;

import com.google.firebase.database.core.Path;
import com.google.firebase.database.snapshot.ChildKey;

/* JADX INFO: compiled from: com.google.firebase:firebase-database@@19.1.0 */
/* JADX INFO: loaded from: classes9.dex */
public abstract class Operation {
    protected final Path path;
    protected final OperationSource source;
    protected final OperationType type;

    /* JADX INFO: compiled from: com.google.firebase:firebase-database@@19.1.0 */
    public enum OperationType {
        Overwrite,
        Merge,
        AckUserWrite,
        ListenComplete
    }

    public abstract Operation operationForChild(ChildKey childKey);

    protected Operation(OperationType operationType, OperationSource operationSource, Path path) {
        this.type = operationType;
        this.source = operationSource;
        this.path = path;
    }

    public Path getPath() {
        return this.path;
    }

    public OperationSource getSource() {
        return this.source;
    }

    public OperationType getType() {
        return this.type;
    }
}
