package org.jivesoftware.smackx.jingle.transports;

import org.jivesoftware.smack.ConnectionListener;
import org.jivesoftware.smack.XMPPConnection;
import org.jivesoftware.smackx.jingle.JingleSession;
import org.jivesoftware.smackx.jingle.element.JingleContentTransport;

/* JADX INFO: loaded from: classes10.dex */
public abstract class JingleTransportManager<D extends JingleContentTransport> implements ConnectionListener {
    private final XMPPConnection connection;

    @Override // org.jivesoftware.smack.ConnectionListener
    public void connected(XMPPConnection xMPPConnection) {
    }

    @Override // org.jivesoftware.smack.ConnectionListener
    public void connectionClosed() {
    }

    @Override // org.jivesoftware.smack.ConnectionListener
    public void connectionClosedOnError(Exception exc) {
    }

    public abstract String getNamespace();

    public abstract JingleTransportSession<D> transportSession(JingleSession jingleSession);

    public JingleTransportManager(XMPPConnection xMPPConnection) {
        this.connection = xMPPConnection;
        xMPPConnection.addConnectionListener(this);
    }

    public XMPPConnection getConnection() {
        return connection();
    }

    public XMPPConnection connection() {
        return this.connection;
    }
}
