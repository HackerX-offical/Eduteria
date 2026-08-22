package com.google.firebase.database.core;

/* JADX INFO: compiled from: com.google.firebase:firebase-database@@19.1.0 */
/* JADX INFO: loaded from: classes9.dex */
public interface EventTarget {
    void postEvent(Runnable runnable);

    void restart();

    void shutdown();
}
