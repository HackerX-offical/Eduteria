package com.google.firebase.database.core.utilities;

/* JADX INFO: compiled from: com.google.firebase:firebase-database@@19.1.0 */
/* JADX INFO: loaded from: classes9.dex */
public class DefaultClock implements Clock {
    @Override // com.google.firebase.database.core.utilities.Clock
    public long millis() {
        return System.currentTimeMillis();
    }
}
