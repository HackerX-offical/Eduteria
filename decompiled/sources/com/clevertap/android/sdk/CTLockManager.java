package com.clevertap.android.sdk;

/* JADX INFO: loaded from: classes7.dex */
public class CTLockManager {
    private final Object eventLock = new Object();
    private final Object inboxControllerLock = new Object();

    public Object getEventLock() {
        return this.eventLock;
    }

    public Object getInboxControllerLock() {
        return this.inboxControllerLock;
    }
}
