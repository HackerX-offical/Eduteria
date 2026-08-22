package org.jivesoftware.smackx.jingle.transports.jingle_s5b;

import java.io.IOException;
import java.net.InetAddress;
import java.net.Socket;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;
import java.util.concurrent.TimeoutException;
import java.util.logging.Level;
import java.util.logging.Logger;
import org.jivesoftware.smack.SmackException;
import org.jivesoftware.smack.XMPPException;
import org.jivesoftware.smack.packet.IQ;
import org.jivesoftware.smackx.bytestreams.socks5.Socks5BytestreamSession;
import org.jivesoftware.smackx.bytestreams.socks5.Socks5Client;
import org.jivesoftware.smackx.bytestreams.socks5.Socks5ClientForInitiator;
import org.jivesoftware.smackx.bytestreams.socks5.Socks5Proxy;
import org.jivesoftware.smackx.bytestreams.socks5.Socks5Utils;
import org.jivesoftware.smackx.bytestreams.socks5.packet.Bytestream;
import org.jivesoftware.smackx.jingle.JingleManager;
import org.jivesoftware.smackx.jingle.JingleSession;
import org.jivesoftware.smackx.jingle.element.Jingle;
import org.jivesoftware.smackx.jingle.element.JingleContent;
import org.jivesoftware.smackx.jingle.element.JingleContentTransport;
import org.jivesoftware.smackx.jingle.element.JingleContentTransportCandidate;
import org.jivesoftware.smackx.jingle.transports.JingleTransportInitiationCallback;
import org.jivesoftware.smackx.jingle.transports.JingleTransportSession;
import org.jivesoftware.smackx.jingle.transports.jingle_s5b.elements.JingleS5BTransport;
import org.jivesoftware.smackx.jingle.transports.jingle_s5b.elements.JingleS5BTransportCandidate;
import org.jivesoftware.smackx.jingle.transports.jingle_s5b.elements.JingleS5BTransportInfo;

/* JADX INFO: loaded from: classes10.dex */
public class JingleS5BTransportSession extends JingleTransportSession<JingleS5BTransport> {
    private JingleTransportInitiationCallback callback;
    private UsedCandidate ourChoice;
    private UsedCandidate theirChoice;
    private static final Logger LOGGER = Logger.getLogger(JingleS5BTransportSession.class.getName());
    private static final UsedCandidate CANDIDATE_FAILURE = new UsedCandidate(null, 0 == true ? 1 : 0, 0 == true ? 1 : 0);

    public JingleS5BTransportSession(JingleSession jingleSession) {
        super(jingleSession);
    }

    @Override // org.jivesoftware.smackx.jingle.transports.JingleTransportSession
    public JingleS5BTransport createTransport() {
        if (this.ourProposal == 0) {
            this.ourProposal = createTransport(JingleManager.randomId(), Bytestream.Mode.tcp);
        }
        return (JingleS5BTransport) this.ourProposal;
    }

    @Override // org.jivesoftware.smackx.jingle.transports.JingleTransportSession
    public void setTheirProposal(JingleContentTransport jingleContentTransport) {
        this.theirProposal = (JingleS5BTransport) jingleContentTransport;
    }

    public JingleS5BTransport createTransport(String str, Bytestream.Mode mode) {
        JingleS5BTransport.Builder destinationAddress = JingleS5BTransport.getBuilder().setStreamId(str).setMode(mode).setDestinationAddress(Socks5Utils.createDigest(str, this.jingleSession.getLocal(), this.jingleSession.getRemote()));
        if (JingleS5BTransportManager.isUseLocalCandidates()) {
            Iterator<Bytestream.StreamHost> it = transportManager().getLocalStreamHosts().iterator();
            while (it.hasNext()) {
                destinationAddress.addTransportCandidate(new JingleS5BTransportCandidate(it.next(), 100, JingleS5BTransportCandidate.Type.direct));
            }
        }
        List<Bytestream.StreamHost> listEmptyList = Collections.emptyList();
        if (JingleS5BTransportManager.isUseExternalCandidates()) {
            try {
                listEmptyList = transportManager().getAvailableStreamHosts();
            } catch (InterruptedException | SmackException.NoResponseException | SmackException.NotConnectedException | XMPPException.XMPPErrorException e2) {
                LOGGER.log(Level.WARNING, "Could not determine available StreamHosts.", e2);
            }
        }
        Iterator<Bytestream.StreamHost> it2 = listEmptyList.iterator();
        while (it2.hasNext()) {
            destinationAddress.addTransportCandidate(new JingleS5BTransportCandidate(it2.next(), 0, JingleS5BTransportCandidate.Type.proxy));
        }
        return destinationAddress.build();
    }

    public void setTheirTransport(JingleContentTransport jingleContentTransport) {
        this.theirProposal = (JingleS5BTransport) jingleContentTransport;
    }

    @Override // org.jivesoftware.smackx.jingle.transports.JingleTransportSession
    public void initiateOutgoingSession(JingleTransportInitiationCallback jingleTransportInitiationCallback) {
        this.callback = jingleTransportInitiationCallback;
        initiateSession();
    }

    @Override // org.jivesoftware.smackx.jingle.transports.JingleTransportSession
    public void initiateIncomingSession(JingleTransportInitiationCallback jingleTransportInitiationCallback) {
        this.callback = jingleTransportInitiationCallback;
        initiateSession();
    }

    private void initiateSession() {
        Socks5Proxy.getSocks5Proxy().addTransfer(createTransport().getDestinationAddress());
        JingleContent jingleContent = this.jingleSession.getContents().get(0);
        UsedCandidate usedCandidateChooseFromProposedCandidates = chooseFromProposedCandidates((JingleS5BTransport) this.theirProposal);
        if (usedCandidateChooseFromProposedCandidates == null) {
            this.ourChoice = CANDIDATE_FAILURE;
            try {
                this.jingleSession.getConnection().sendStanza(transportManager().createCandidateError(this.jingleSession.getRemote(), this.jingleSession.getInitiator(), this.jingleSession.getSessionId(), jingleContent.getSenders(), jingleContent.getCreator(), jingleContent.getName(), ((JingleS5BTransport) this.theirProposal).getStreamId()));
            } catch (InterruptedException | SmackException.NotConnectedException e2) {
                LOGGER.log(Level.WARNING, "Could not send candidate-error.", e2);
            }
        } else {
            this.ourChoice = usedCandidateChooseFromProposedCandidates;
            try {
                this.jingleSession.getConnection().createStanzaCollectorAndSend(transportManager().createCandidateUsed(this.jingleSession.getRemote(), this.jingleSession.getInitiator(), this.jingleSession.getSessionId(), jingleContent.getSenders(), jingleContent.getCreator(), jingleContent.getName(), ((JingleS5BTransport) this.theirProposal).getStreamId(), this.ourChoice.candidate.getCandidateId())).nextResultOrThrow();
            } catch (InterruptedException | SmackException.NoResponseException | SmackException.NotConnectedException | XMPPException.XMPPErrorException e3) {
                LOGGER.log(Level.WARNING, "Could not send candidate-used.", e3);
            }
        }
        connectIfReady();
    }

    private UsedCandidate chooseFromProposedCandidates(JingleS5BTransport jingleS5BTransport) {
        Iterator<JingleContentTransportCandidate> it = jingleS5BTransport.getCandidates().iterator();
        while (it.hasNext()) {
            JingleS5BTransportCandidate jingleS5BTransportCandidate = (JingleS5BTransportCandidate) it.next();
            try {
                return connectToTheirCandidate(jingleS5BTransportCandidate);
            } catch (IOException | InterruptedException | TimeoutException | SmackException | XMPPException e2) {
                LOGGER.log(Level.WARNING, "Could not connect to " + ((Object) jingleS5BTransportCandidate.getHost()), e2);
            }
        }
        LOGGER.log(Level.WARNING, "Failed to connect to any candidate.");
        return null;
    }

    private UsedCandidate connectToTheirCandidate(JingleS5BTransportCandidate jingleS5BTransportCandidate) throws SmackException, InterruptedException, TimeoutException, IOException, XMPPException {
        Bytestream.StreamHost streamHost = jingleS5BTransportCandidate.getStreamHost();
        InetAddress inetAddressAsInetAddress = streamHost.getAddress().asInetAddress();
        Socket socket = new Socks5Client(streamHost, ((JingleS5BTransport) this.theirProposal).getDestinationAddress()).getSocket(10000);
        LOGGER.log(Level.INFO, "Connected to their StreamHost " + inetAddressAsInetAddress + " using dstAddr " + ((JingleS5BTransport) this.theirProposal).getDestinationAddress());
        return new UsedCandidate((JingleS5BTransport) this.theirProposal, jingleS5BTransportCandidate, socket);
    }

    private UsedCandidate connectToOurCandidate(JingleS5BTransportCandidate jingleS5BTransportCandidate) throws SmackException, InterruptedException, TimeoutException, IOException, XMPPException {
        Bytestream.StreamHost streamHost = jingleS5BTransportCandidate.getStreamHost();
        InetAddress inetAddressAsInetAddress = streamHost.getAddress().asInetAddress();
        Socket socket = new Socks5ClientForInitiator(streamHost, ((JingleS5BTransport) this.ourProposal).getDestinationAddress(), this.jingleSession.getConnection(), ((JingleS5BTransport) this.ourProposal).getStreamId(), this.jingleSession.getRemote()).getSocket(10000);
        LOGGER.log(Level.INFO, "Connected to our StreamHost " + inetAddressAsInetAddress + " using dstAddr " + ((JingleS5BTransport) this.ourProposal).getDestinationAddress());
        return new UsedCandidate((JingleS5BTransport) this.ourProposal, jingleS5BTransportCandidate, socket);
    }

    @Override // org.jivesoftware.smackx.jingle.transports.JingleTransportSession
    public String getNamespace() {
        return "urn:xmpp:jingle:transports:s5b:1";
    }

    @Override // org.jivesoftware.smackx.jingle.transports.JingleTransportSession
    public IQ handleTransportInfo(Jingle jingle) {
        String elementName = ((JingleS5BTransportInfo) jingle.getContents().get(0).getTransport().getInfo()).getElementName();
        elementName.hashCode();
        switch (elementName) {
            case "candidate-error":
                return handleCandidateError(jingle);
            case "proxy-error":
                return handleProxyError(jingle);
            case "candidate-used":
                return handleCandidateUsed(jingle);
            case "candidate-activated":
                return handleCandidateActivate(jingle);
            default:
                return IQ.createResultIQ(jingle);
        }
    }

    /* JADX WARN: Multi-variable type inference failed */
    public IQ handleCandidateUsed(Jingle jingle) {
        UsedCandidate usedCandidate = new UsedCandidate((JingleS5BTransport) this.ourProposal, ((JingleS5BTransport) this.ourProposal).getCandidate(((JingleS5BTransportInfo.CandidateUsed) ((JingleS5BTransportInfo) jingle.getContents().get(0).getTransport().getInfo())).getCandidateId()), null);
        this.theirChoice = usedCandidate;
        JingleS5BTransportCandidate unused = usedCandidate.candidate;
        connectIfReady();
        return IQ.createResultIQ(jingle);
    }

    public IQ handleCandidateActivate(Jingle jingle) {
        LOGGER.log(Level.INFO, "handleCandidateActivate");
        this.callback.onSessionInitiated(new Socks5BytestreamSession(this.ourChoice.socket, this.ourChoice.candidate.getJid().asBareJid().equals((CharSequence) this.jingleSession.getRemote().asBareJid())));
        return IQ.createResultIQ(jingle);
    }

    public IQ handleCandidateError(Jingle jingle) {
        this.theirChoice = CANDIDATE_FAILURE;
        connectIfReady();
        return IQ.createResultIQ(jingle);
    }

    public IQ handleProxyError(Jingle jingle) {
        return IQ.createResultIQ(jingle);
    }

    private void connectIfReady() {
        UsedCandidate usedCandidate;
        JingleContent jingleContent = this.jingleSession.getContents().get(0);
        UsedCandidate usedCandidate2 = this.ourChoice;
        if (usedCandidate2 == null || (usedCandidate = this.theirChoice) == null) {
            LOGGER.log(Level.INFO, "Not ready.");
            return;
        }
        UsedCandidate usedCandidate3 = CANDIDATE_FAILURE;
        if (usedCandidate2 == usedCandidate3 && usedCandidate == usedCandidate3) {
            LOGGER.log(Level.INFO, "Failure.");
            this.jingleSession.onTransportMethodFailed(getNamespace());
            return;
        }
        Logger logger = LOGGER;
        logger.log(Level.INFO, "Ready.");
        UsedCandidate usedCandidate4 = this.ourChoice;
        if (usedCandidate4 == usedCandidate3 || this.theirChoice == usedCandidate3) {
            if (usedCandidate4 == usedCandidate3) {
                usedCandidate4 = this.theirChoice;
            }
        } else if (usedCandidate4.candidate.getPriority() > this.theirChoice.candidate.getPriority()) {
            usedCandidate4 = this.ourChoice;
        } else {
            usedCandidate4 = (this.ourChoice.candidate.getPriority() >= this.theirChoice.candidate.getPriority() && this.jingleSession.isInitiator()) ? this.ourChoice : this.theirChoice;
        }
        if (usedCandidate4 == this.theirChoice) {
            logger.log(Level.INFO, "Their choice, so our proposed candidate is used.");
            boolean z = usedCandidate4.candidate.getType() == JingleS5BTransportCandidate.Type.proxy;
            try {
                UsedCandidate usedCandidateConnectToOurCandidate = connectToOurCandidate(usedCandidate4.candidate);
                if (z) {
                    logger.log(Level.INFO, "Is external proxy. Activate it.");
                    Bytestream bytestream = new Bytestream(((JingleS5BTransport) this.ourProposal).getStreamId());
                    bytestream.setMode(null);
                    bytestream.setType(IQ.Type.set);
                    bytestream.setTo(usedCandidateConnectToOurCandidate.candidate.getJid());
                    bytestream.setToActivate(this.jingleSession.getRemote());
                    bytestream.setFrom(this.jingleSession.getLocal());
                    try {
                        this.jingleSession.getConnection().createStanzaCollectorAndSend(bytestream).nextResultOrThrow();
                        logger.log(Level.INFO, "Send candidate-activate.");
                        try {
                            this.jingleSession.getConnection().createStanzaCollectorAndSend(transportManager().createCandidateActivated(this.jingleSession.getRemote(), this.jingleSession.getInitiator(), this.jingleSession.getSessionId(), jingleContent.getSenders(), jingleContent.getCreator(), jingleContent.getName(), usedCandidateConnectToOurCandidate.transport.getStreamId(), usedCandidateConnectToOurCandidate.candidate.getCandidateId())).nextResultOrThrow();
                        } catch (InterruptedException | SmackException.NoResponseException | SmackException.NotConnectedException | XMPPException.XMPPErrorException e2) {
                            LOGGER.log(Level.WARNING, "Could not send candidate-activated", e2);
                            return;
                        }
                    } catch (InterruptedException | SmackException.NoResponseException | SmackException.NotConnectedException | XMPPException.XMPPErrorException e3) {
                        LOGGER.log(Level.WARNING, "Could not activate proxy.", e3);
                        return;
                    }
                }
                logger.log(Level.INFO, "Start transmission.");
                this.callback.onSessionInitiated(new Socks5BytestreamSession(usedCandidateConnectToOurCandidate.socket, !z));
                return;
            } catch (IOException | InterruptedException | TimeoutException | SmackException | XMPPException e4) {
                LOGGER.log(Level.INFO, "Could not connect to our candidate.", e4);
                return;
            }
        }
        logger.log(Level.INFO, "Our choice, so their candidate was used.");
        if (usedCandidate4.candidate.getType() != JingleS5BTransportCandidate.Type.proxy) {
            logger.log(Level.INFO, "Direct connection.");
            this.callback.onSessionInitiated(new Socks5BytestreamSession(usedCandidate4.socket, true));
        } else {
            logger.log(Level.INFO, "Our choice was their external proxy. wait for candidate-activate.");
        }
    }

    @Override // org.jivesoftware.smackx.jingle.transports.JingleTransportSession
    public JingleS5BTransportManager transportManager() {
        return JingleS5BTransportManager.getInstanceFor(this.jingleSession.getConnection());
    }

    private static final class UsedCandidate {
        private final JingleS5BTransportCandidate candidate;
        private final Socket socket;
        private final JingleS5BTransport transport;

        private UsedCandidate(JingleS5BTransport jingleS5BTransport, JingleS5BTransportCandidate jingleS5BTransportCandidate, Socket socket) {
            this.socket = socket;
            this.transport = jingleS5BTransport;
            this.candidate = jingleS5BTransportCandidate;
        }
    }
}
