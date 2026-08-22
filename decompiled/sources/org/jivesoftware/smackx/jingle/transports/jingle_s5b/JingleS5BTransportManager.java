package org.jivesoftware.smackx.jingle.transports.jingle_s5b;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.WeakHashMap;
import java.util.logging.Level;
import java.util.logging.Logger;
import org.jivesoftware.smack.SmackException;
import org.jivesoftware.smack.XMPPConnection;
import org.jivesoftware.smack.XMPPException;
import org.jivesoftware.smack.packet.IQ;
import org.jivesoftware.smackx.bytestreams.socks5.Socks5BytestreamManager;
import org.jivesoftware.smackx.bytestreams.socks5.Socks5Proxy;
import org.jivesoftware.smackx.bytestreams.socks5.packet.Bytestream;
import org.jivesoftware.smackx.jingle.JingleSession;
import org.jivesoftware.smackx.jingle.element.Jingle;
import org.jivesoftware.smackx.jingle.element.JingleAction;
import org.jivesoftware.smackx.jingle.element.JingleContent;
import org.jivesoftware.smackx.jingle.provider.JingleContentProviderManager;
import org.jivesoftware.smackx.jingle.transports.JingleTransportManager;
import org.jivesoftware.smackx.jingle.transports.JingleTransportSession;
import org.jivesoftware.smackx.jingle.transports.jingle_s5b.elements.JingleS5BTransport;
import org.jivesoftware.smackx.jingle.transports.jingle_s5b.provider.JingleS5BTransportProvider;
import org.jxmpp.jid.FullJid;
import org.jxmpp.jid.Jid;

/* JADX INFO: loaded from: classes10.dex */
public final class JingleS5BTransportManager extends JingleTransportManager<JingleS5BTransport> {
    private List<Bytestream.StreamHost> availableStreamHosts;
    private List<Bytestream.StreamHost> localStreamHosts;
    private static final Logger LOGGER = Logger.getLogger(JingleS5BTransportManager.class.getName());
    private static final WeakHashMap<XMPPConnection, JingleS5BTransportManager> INSTANCES = new WeakHashMap<>();
    private static boolean useLocalCandidates = true;
    private static boolean useExternalCandidates = true;

    private JingleS5BTransportManager(XMPPConnection xMPPConnection) {
        super(xMPPConnection);
        this.localStreamHosts = null;
        this.availableStreamHosts = null;
        JingleContentProviderManager.addJingleContentTransportProvider(getNamespace(), new JingleS5BTransportProvider());
    }

    public static synchronized JingleS5BTransportManager getInstanceFor(XMPPConnection xMPPConnection) {
        JingleS5BTransportManager jingleS5BTransportManager;
        WeakHashMap<XMPPConnection, JingleS5BTransportManager> weakHashMap = INSTANCES;
        jingleS5BTransportManager = weakHashMap.get(xMPPConnection);
        if (jingleS5BTransportManager == null) {
            jingleS5BTransportManager = new JingleS5BTransportManager(xMPPConnection);
            weakHashMap.put(xMPPConnection, jingleS5BTransportManager);
        }
        return jingleS5BTransportManager;
    }

    @Override // org.jivesoftware.smackx.jingle.transports.JingleTransportManager
    public String getNamespace() {
        return "urn:xmpp:jingle:transports:s5b:1";
    }

    @Override // org.jivesoftware.smackx.jingle.transports.JingleTransportManager
    public JingleTransportSession<JingleS5BTransport> transportSession(JingleSession jingleSession) {
        return new JingleS5BTransportSession(jingleSession);
    }

    private List<Bytestream.StreamHost> queryAvailableStreamHosts() throws SmackException.NotConnectedException, SmackException.NoResponseException, InterruptedException, XMPPException.XMPPErrorException {
        return determineStreamHostInfo(Socks5BytestreamManager.getBytestreamManager(getConnection()).determineProxies());
    }

    private List<Bytestream.StreamHost> queryLocalStreamHosts() {
        return Socks5BytestreamManager.getBytestreamManager(getConnection()).getLocalStreamHost();
    }

    public List<Bytestream.StreamHost> getAvailableStreamHosts() throws SmackException.NotConnectedException, SmackException.NoResponseException, InterruptedException, XMPPException.XMPPErrorException {
        if (this.availableStreamHosts == null) {
            this.availableStreamHosts = queryAvailableStreamHosts();
        }
        return this.availableStreamHosts;
    }

    public List<Bytestream.StreamHost> getLocalStreamHosts() {
        if (this.localStreamHosts == null) {
            this.localStreamHosts = queryLocalStreamHosts();
        }
        return this.localStreamHosts;
    }

    public List<Bytestream.StreamHost> determineStreamHostInfo(List<Jid> list) {
        XMPPConnection connection = getConnection();
        ArrayList arrayList = new ArrayList();
        Iterator<Jid> it = list.iterator();
        while (it.hasNext()) {
            Jid next = it.next();
            Bytestream bytestream = new Bytestream();
            bytestream.setType(IQ.Type.get);
            bytestream.setTo(next);
            try {
                arrayList.addAll(((Bytestream) connection.createStanzaCollectorAndSend(bytestream).nextResultOrThrow()).getStreamHosts());
            } catch (Exception unused) {
                it.remove();
            }
        }
        return arrayList;
    }

    @Override // org.jivesoftware.smack.ConnectionListener
    public void authenticated(XMPPConnection xMPPConnection, boolean z) {
        if (z) {
            return;
        }
        try {
            Socks5Proxy socks5Proxy = Socks5Proxy.getSocks5Proxy();
            if (!socks5Proxy.isRunning()) {
                socks5Proxy.start();
            }
            this.localStreamHosts = queryLocalStreamHosts();
            this.availableStreamHosts = queryAvailableStreamHosts();
        } catch (InterruptedException | SmackException.NoResponseException | SmackException.NotConnectedException | XMPPException.XMPPErrorException e2) {
            LOGGER.log(Level.WARNING, "Could not query available StreamHosts: " + e2, e2);
        }
    }

    public Jingle createCandidateUsed(FullJid fullJid, FullJid fullJid2, String str, JingleContent.Senders senders, JingleContent.Creator creator, String str2, String str3, String str4) {
        Jingle.Builder builder = Jingle.builder(connection());
        builder.setSessionId(str).setInitiator(fullJid2).setAction(JingleAction.transport_info);
        JingleContent.Builder builder2 = JingleContent.getBuilder();
        builder2.setName(str2).setCreator(creator).setSenders(senders);
        JingleS5BTransport.Builder builder3 = JingleS5BTransport.getBuilder();
        builder3.setCandidateUsed(str4).setStreamId(str3);
        Jingle jingleBuild = builder.addJingleContent(builder2.setTransport(builder3.build()).build()).build();
        jingleBuild.setFrom(getConnection().getUser().asFullJidOrThrow());
        jingleBuild.setTo(fullJid);
        return jingleBuild;
    }

    public Jingle createCandidateError(FullJid fullJid, FullJid fullJid2, String str, JingleContent.Senders senders, JingleContent.Creator creator, String str2, String str3) {
        Jingle.Builder builder = Jingle.builder(connection());
        builder.setSessionId(str).setInitiator(fullJid2).setAction(JingleAction.transport_info);
        JingleContent.Builder builder2 = JingleContent.getBuilder();
        builder2.setName(str2).setCreator(creator).setSenders(senders);
        JingleS5BTransport.Builder builder3 = JingleS5BTransport.getBuilder();
        builder3.setCandidateError().setStreamId(str3);
        Jingle jingleBuild = builder.addJingleContent(builder2.setTransport(builder3.build()).build()).build();
        jingleBuild.setFrom(getConnection().getUser().asFullJidOrThrow());
        jingleBuild.setTo(fullJid);
        return jingleBuild;
    }

    public Jingle createProxyError(FullJid fullJid, FullJid fullJid2, String str, JingleContent.Senders senders, JingleContent.Creator creator, String str2, String str3) {
        Jingle.Builder builder = Jingle.builder(connection());
        builder.setSessionId(str).setAction(JingleAction.transport_info).setInitiator(fullJid2);
        JingleContent.Builder builder2 = JingleContent.getBuilder();
        builder2.setSenders(senders).setCreator(creator).setName(str2);
        JingleS5BTransport.Builder builder3 = JingleS5BTransport.getBuilder();
        builder3.setStreamId(str).setProxyError().setStreamId(str3);
        Jingle jingleBuild = builder.addJingleContent(builder2.setTransport(builder3.build()).build()).build();
        jingleBuild.setTo(fullJid);
        jingleBuild.setFrom(getConnection().getUser().asFullJidOrThrow());
        return jingleBuild;
    }

    public Jingle createCandidateActivated(FullJid fullJid, FullJid fullJid2, String str, JingleContent.Senders senders, JingleContent.Creator creator, String str2, String str3, String str4) {
        Jingle.Builder builder = Jingle.builder(connection());
        builder.setInitiator(fullJid2).setSessionId(str).setAction(JingleAction.transport_info);
        JingleContent.Builder builder2 = JingleContent.getBuilder();
        builder2.setName(str2).setCreator(creator).setSenders(senders);
        JingleS5BTransport.Builder builder3 = JingleS5BTransport.getBuilder();
        builder3.setStreamId(str3).setCandidateActivated(str4);
        Jingle jingleBuild = builder.addJingleContent(builder2.setTransport(builder3.build()).build()).build();
        jingleBuild.setFrom(getConnection().getUser().asFullJidOrThrow());
        jingleBuild.setTo(fullJid);
        return jingleBuild;
    }

    public static void setUseLocalCandidates(boolean z) {
        useLocalCandidates = z;
    }

    public static void setUseExternalCandidates(boolean z) {
        useExternalCandidates = z;
    }

    public static boolean isUseLocalCandidates() {
        return useLocalCandidates;
    }

    public static boolean isUseExternalCandidates() {
        return useExternalCandidates;
    }
}
