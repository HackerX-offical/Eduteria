package com.google.firebase.storage.internal;

/* JADX INFO: compiled from: com.google.firebase:firebase-storage@@19.1.0 */
/* JADX INFO: loaded from: classes9.dex */
public class SleeperImpl implements Sleeper {
    @Override // com.google.firebase.storage.internal.Sleeper
    public void sleep(int i) throws InterruptedException {
        Thread.sleep(i);
    }
}
