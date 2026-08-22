package com.google.firebase.database.core;

import java.util.concurrent.ScheduledFuture;

/* JADX INFO: compiled from: com.google.firebase:firebase-database@@19.1.0 */
/* JADX INFO: loaded from: classes9.dex */
public interface RunLoop {
    void restart();

    ScheduledFuture schedule(Runnable runnable, long j);

    void scheduleNow(Runnable runnable);

    void shutdown();
}
