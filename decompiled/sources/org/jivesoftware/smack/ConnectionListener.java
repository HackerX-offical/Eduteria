package org.jivesoftware.smack;

/* JADX INFO: loaded from: classes10.dex */
public interface ConnectionListener {
    default void authenticated(XMPPConnection xMPPConnection, boolean z) {
    }

    default void connected(XMPPConnection xMPPConnection) {
    }

    default void connecting(XMPPConnection xMPPConnection) {
    }

    default void connectionClosed() {
    }

    default void connectionClosedOnError(Exception exc) {
    }
}
