package org.jivesoftware.smack;

/* JADX INFO: loaded from: classes10.dex */
public abstract class AbstractConnectionClosedListener implements ConnectionListener {
    public abstract void connectionTerminated();

    @Override // org.jivesoftware.smack.ConnectionListener
    public final void connectionClosed() {
        connectionTerminated();
    }

    @Override // org.jivesoftware.smack.ConnectionListener
    public final void connectionClosedOnError(Exception exc) {
        connectionTerminated();
    }
}
