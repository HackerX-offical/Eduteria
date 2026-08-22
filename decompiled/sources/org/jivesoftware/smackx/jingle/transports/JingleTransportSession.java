package org.jivesoftware.smackx.jingle.transports;

import org.jivesoftware.smack.packet.IQ;
import org.jivesoftware.smackx.jingle.JingleSession;
import org.jivesoftware.smackx.jingle.element.Jingle;
import org.jivesoftware.smackx.jingle.element.JingleContentTransport;

/* JADX INFO: loaded from: classes10.dex */
public abstract class JingleTransportSession<T extends JingleContentTransport> {
    protected final JingleSession jingleSession;
    protected T ourProposal;
    protected T theirProposal;

    public abstract T createTransport();

    public abstract String getNamespace();

    public abstract IQ handleTransportInfo(Jingle jingle);

    public abstract void initiateIncomingSession(JingleTransportInitiationCallback jingleTransportInitiationCallback);

    public abstract void initiateOutgoingSession(JingleTransportInitiationCallback jingleTransportInitiationCallback);

    public abstract void setTheirProposal(JingleContentTransport jingleContentTransport);

    public abstract JingleTransportManager<T> transportManager();

    public JingleTransportSession(JingleSession jingleSession) {
        this.jingleSession = jingleSession;
    }

    public void processJingle(Jingle jingle) {
        JingleContentTransport transport;
        if (jingle.getContents().size() == 0 || (transport = jingle.getContents().get(0).getTransport()) == null || !transport.getNamespace().equals(getNamespace())) {
            return;
        }
        setTheirProposal(transport);
    }
}
