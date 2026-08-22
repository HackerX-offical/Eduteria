package com.google.firebase.database.core.view;

import com.google.firebase.database.core.Path;

/* JADX INFO: compiled from: com.google.firebase:firebase-database@@19.1.0 */
/* JADX INFO: loaded from: classes9.dex */
public interface Event {

    /* JADX INFO: compiled from: com.google.firebase:firebase-database@@19.1.0 */
    public enum EventType {
        CHILD_REMOVED,
        CHILD_ADDED,
        CHILD_MOVED,
        CHILD_CHANGED,
        VALUE
    }

    void fire();

    Path getPath();

    String toString();
}
