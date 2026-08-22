package org.jivesoftware.smackx.jingle.transports.jingle_ibb;

import java.util.logging.Level;
import java.util.logging.Logger;
import org.jivesoftware.smack.SmackException;
import org.jivesoftware.smack.XMPPException;
import org.jivesoftware.smack.packet.IQ;
import org.jivesoftware.smackx.bytestreams.BytestreamListener;
import org.jivesoftware.smackx.bytestreams.BytestreamRequest;
import org.jivesoftware.smackx.bytestreams.ibb.InBandBytestreamManager;
import org.jivesoftware.smackx.jingle.JingleSession;
import org.jivesoftware.smackx.jingle.element.Jingle;
import org.jivesoftware.smackx.jingle.element.JingleContentTransport;
import org.jivesoftware.smackx.jingle.transports.JingleTransportInitiationCallback;
import org.jivesoftware.smackx.jingle.transports.JingleTransportManager;
import org.jivesoftware.smackx.jingle.transports.JingleTransportSession;
import org.jivesoftware.smackx.jingle.transports.jingle_ibb.element.JingleIBBTransport;
import org.jxmpp.jid.Jid;

/* JADX INFO: loaded from: classes10.dex */
public class JingleIBBTransportSession extends JingleTransportSession<JingleIBBTransport> {
    private static final Logger LOGGER = Logger.getLogger(JingleIBBTransportSession.class.getName());
    private final JingleIBBTransportManager transportManager;

    public JingleIBBTransportSession(JingleSession jingleSession) {
        super(jingleSession);
        this.transportManager = JingleIBBTransportManager.getInstanceFor(jingleSession.getConnection());
    }

    @Override // org.jivesoftware.smackx.jingle.transports.JingleTransportSession
    public JingleIBBTransport createTransport() {
        if (this.theirProposal == 0) {
            return new JingleIBBTransport();
        }
        return new JingleIBBTransport(((JingleIBBTransport) this.theirProposal).getBlockSize(), ((JingleIBBTransport) this.theirProposal).getSessionId());
    }

    @Override // org.jivesoftware.smackx.jingle.transports.JingleTransportSession
    public void setTheirProposal(JingleContentTransport jingleContentTransport) {
        this.theirProposal = (JingleIBBTransport) jingleContentTransport;
    }

    @Override // org.jivesoftware.smackx.jingle.transports.JingleTransportSession
    public void initiateOutgoingSession(JingleTransportInitiationCallback jingleTransportInitiationCallback) {
        LOGGER.log(Level.INFO, "Initiate Jingle InBandBytestream session.");
        try {
            jingleTransportInitiationCallback.onSessionInitiated(InBandBytestreamManager.getByteStreamManager(this.jingleSession.getConnection()).establishSession((Jid) this.jingleSession.getRemote(), ((JingleIBBTransport) this.theirProposal).getSessionId()));
        } catch (InterruptedException | SmackException.NoResponseException | SmackException.NotConnectedException | XMPPException.XMPPErrorException e2) {
            jingleTransportInitiationCallback.onException(e2);
        }
    }

    @Override // org.jivesoftware.smackx.jingle.transports.JingleTransportSession
    public void initiateIncomingSession(final JingleTransportInitiationCallback jingleTransportInitiationCallback) {
        LOGGER.log(Level.INFO, "Await Jingle InBandBytestream session.");
        InBandBytestreamManager.getByteStreamManager(this.jingleSession.getConnection()).addIncomingBytestreamListener(new BytestreamListener() { // from class: org.jivesoftware.smackx.jingle.transports.jingle_ibb.JingleIBBTransportSession.1
            @Override // org.jivesoftware.smackx.bytestreams.BytestreamListener
            public void incomingBytestreamRequest(BytestreamRequest bytestreamRequest) {
                if (bytestreamRequest.getFrom().asFullJidIfPossible().equals((CharSequence) JingleIBBTransportSession.this.jingleSession.getRemote()) && bytestreamRequest.getSessionID().equals(((JingleIBBTransport) JingleIBBTransportSession.this.theirProposal).getSessionId())) {
                    try {
                        jingleTransportInitiationCallback.onSessionInitiated(bytestreamRequest.accept());
                    } catch (InterruptedException | SmackException | XMPPException.XMPPErrorException e2) {
                        jingleTransportInitiationCallback.onException(e2);
                    }
                }
            }
        });
    }

    @Override // org.jivesoftware.smackx.jingle.transports.JingleTransportSession
    public String getNamespace() {
        return this.transportManager.getNamespace();
    }

    @Override // org.jivesoftware.smackx.jingle.transports.JingleTransportSession
    public IQ handleTransportInfo(Jingle jingle) {
        return IQ.createResultIQ(jingle);
    }

    @Override // org.jivesoftware.smackx.jingle.transports.JingleTransportSession
    public JingleTransportManager<JingleIBBTransport> transportManager() {
        return JingleIBBTransportManager.getInstanceFor(this.jingleSession.getConnection());
    }
}
