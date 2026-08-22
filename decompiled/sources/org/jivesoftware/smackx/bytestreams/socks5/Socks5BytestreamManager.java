package org.jivesoftware.smackx.bytestreams.socks5;

import java.io.IOException;
import java.net.InetAddress;
import java.net.Socket;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashSet;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.WeakHashMap;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.TimeoutException;
import org.jivesoftware.smack.ConnectionCreationListener;
import org.jivesoftware.smack.Manager;
import org.jivesoftware.smack.SmackException;
import org.jivesoftware.smack.XMPPConnection;
import org.jivesoftware.smack.XMPPConnectionRegistry;
import org.jivesoftware.smack.XMPPException;
import org.jivesoftware.smack.packet.IQ;
import org.jivesoftware.smack.packet.StanzaError;
import org.jivesoftware.smack.util.StringUtils;
import org.jivesoftware.smackx.bytestreams.BytestreamListener;
import org.jivesoftware.smackx.bytestreams.BytestreamManager;
import org.jivesoftware.smackx.bytestreams.socks5.packet.Bytestream;
import org.jivesoftware.smackx.disco.ServiceDiscoveryManager;
import org.jivesoftware.smackx.disco.packet.DiscoverItems;
import org.jxmpp.jid.EntityFullJid;
import org.jxmpp.jid.Jid;

/* JADX INFO: loaded from: classes10.dex */
public final class Socks5BytestreamManager extends Manager implements BytestreamManager {
    private static final String SESSION_ID_PREFIX = "js5_";
    private static final Map<XMPPConnection, Socks5BytestreamManager> managers;
    private final List<BytestreamListener> allRequestListeners;
    private boolean annouceLocalStreamHost;
    private final List<String> ignoredBytestreamRequests;
    private final InitiationListener initiationListener;
    private Jid lastWorkingProxy;
    private final Set<Jid> proxyBlacklist;
    private int proxyConnectionTimeout;
    private boolean proxyPrioritizationEnabled;
    private int targetResponseTimeout;
    private final Map<Jid, BytestreamListener> userListeners;

    static {
        XMPPConnectionRegistry.addConnectionCreationListener(new ConnectionCreationListener() { // from class: org.jivesoftware.smackx.bytestreams.socks5.Socks5BytestreamManager.1
            @Override // org.jivesoftware.smack.ConnectionCreationListener
            public void connectionCreated(XMPPConnection xMPPConnection) {
                Socks5BytestreamManager.getBytestreamManager(xMPPConnection);
            }
        });
        managers = new WeakHashMap();
    }

    public static synchronized Socks5BytestreamManager getBytestreamManager(XMPPConnection xMPPConnection) {
        if (xMPPConnection == null) {
            return null;
        }
        Map<XMPPConnection, Socks5BytestreamManager> map = managers;
        Socks5BytestreamManager socks5BytestreamManager = map.get(xMPPConnection);
        if (socks5BytestreamManager == null) {
            socks5BytestreamManager = new Socks5BytestreamManager(xMPPConnection);
            map.put(xMPPConnection, socks5BytestreamManager);
        }
        return socks5BytestreamManager;
    }

    private Socks5BytestreamManager(XMPPConnection xMPPConnection) {
        super(xMPPConnection);
        this.userListeners = new ConcurrentHashMap();
        this.allRequestListeners = Collections.synchronizedList(new LinkedList());
        this.targetResponseTimeout = 10000;
        this.proxyConnectionTimeout = 10000;
        this.proxyBlacklist = Collections.synchronizedSet(new HashSet());
        this.proxyPrioritizationEnabled = true;
        this.annouceLocalStreamHost = true;
        this.ignoredBytestreamRequests = Collections.synchronizedList(new LinkedList());
        this.initiationListener = new InitiationListener(this);
        activate();
    }

    @Override // org.jivesoftware.smackx.bytestreams.BytestreamManager
    public void addIncomingBytestreamListener(BytestreamListener bytestreamListener) {
        this.allRequestListeners.add(bytestreamListener);
    }

    @Override // org.jivesoftware.smackx.bytestreams.BytestreamManager
    public void removeIncomingBytestreamListener(BytestreamListener bytestreamListener) {
        this.allRequestListeners.remove(bytestreamListener);
    }

    @Override // org.jivesoftware.smackx.bytestreams.BytestreamManager
    public void addIncomingBytestreamListener(BytestreamListener bytestreamListener, Jid jid) {
        this.userListeners.put(jid, bytestreamListener);
    }

    @Override // org.jivesoftware.smackx.bytestreams.BytestreamManager
    public void removeIncomingBytestreamListener(Jid jid) {
        this.userListeners.remove(jid);
    }

    public void ignoreBytestreamRequestOnce(String str) {
        this.ignoredBytestreamRequests.add(str);
    }

    public synchronized void disableService() {
        XMPPConnection xMPPConnectionConnection = connection();
        xMPPConnectionConnection.unregisterIQRequestHandler(this.initiationListener);
        this.initiationListener.shutdown();
        this.allRequestListeners.clear();
        this.userListeners.clear();
        this.lastWorkingProxy = null;
        this.proxyBlacklist.clear();
        this.ignoredBytestreamRequests.clear();
        Map<XMPPConnection, Socks5BytestreamManager> map = managers;
        map.remove(xMPPConnectionConnection);
        if (map.size() == 0) {
            Socks5Proxy.getSocks5Proxy().stop();
        }
        ServiceDiscoveryManager instanceFor = ServiceDiscoveryManager.getInstanceFor(xMPPConnectionConnection);
        if (instanceFor != null) {
            instanceFor.removeFeature(Bytestream.NAMESPACE);
        }
    }

    public int getTargetResponseTimeout() {
        if (this.targetResponseTimeout <= 0) {
            this.targetResponseTimeout = 10000;
        }
        return this.targetResponseTimeout;
    }

    public void setTargetResponseTimeout(int i) {
        this.targetResponseTimeout = i;
    }

    public int getProxyConnectionTimeout() {
        if (this.proxyConnectionTimeout <= 0) {
            this.proxyConnectionTimeout = 10000;
        }
        return this.proxyConnectionTimeout;
    }

    public void setProxyConnectionTimeout(int i) {
        this.proxyConnectionTimeout = i;
    }

    public boolean isProxyPrioritizationEnabled() {
        return this.proxyPrioritizationEnabled;
    }

    public void setProxyPrioritizationEnabled(boolean z) {
        this.proxyPrioritizationEnabled = z;
    }

    public boolean isAnnouncingLocalStreamHostEnabled() {
        return this.annouceLocalStreamHost;
    }

    public void setAnnounceLocalStreamHost(boolean z) {
        this.annouceLocalStreamHost = z;
    }

    @Override // org.jivesoftware.smackx.bytestreams.BytestreamManager
    public Socks5BytestreamSession establishSession(Jid jid) throws SmackException, InterruptedException, IOException, XMPPException {
        return establishSession(jid, getNextSessionID());
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r1v1, types: [java.util.List] */
    /* JADX WARN: Type inference failed for: r2v0 */
    /* JADX WARN: Type inference failed for: r2v1 */
    /* JADX WARN: Type inference failed for: r2v10 */
    /* JADX WARN: Type inference failed for: r2v11 */
    /* JADX WARN: Type inference failed for: r2v2 */
    /* JADX WARN: Type inference failed for: r2v4, types: [java.lang.String] */
    /* JADX WARN: Type inference failed for: r2v8, types: [java.lang.Object] */
    /* JADX WARN: Type inference failed for: r2v9 */
    /* JADX WARN: Type inference failed for: r3v0, types: [org.jivesoftware.smack.XMPPConnection] */
    /* JADX WARN: Type inference failed for: r6v0, types: [org.jivesoftware.smackx.bytestreams.socks5.Socks5Proxy] */
    @Override // org.jivesoftware.smackx.bytestreams.BytestreamManager
    public Socks5BytestreamSession establishSession(Jid jid, String str) throws Throwable {
        ?? Connection = connection();
        if (!supportsSocks5(jid)) {
            throw new SmackException.FeatureNotSupportedException("SOCKS5 Bytestream", jid);
        }
        ArrayList arrayList = new ArrayList();
        ?? r2 = 0;
        r2 = 0;
        r2 = 0;
        try {
            arrayList.addAll(determineProxies());
            e = null;
        } catch (XMPPException.XMPPErrorException e2) {
            e = e2;
        }
        ?? DetermineStreamHostInfos = determineStreamHostInfos(arrayList);
        if (DetermineStreamHostInfos.isEmpty()) {
            if (e != null) {
                throw e;
            }
            throw new SmackException.SmackMessageException("no SOCKS5 proxies available");
        }
        String strCreateDigest = Socks5Utils.createDigest(str, Connection.getUser(), jid);
        if (this.proxyPrioritizationEnabled && this.lastWorkingProxy != null) {
            Iterator it = DetermineStreamHostInfos.iterator();
            while (true) {
                if (!it.hasNext()) {
                    break;
                }
                Bytestream.StreamHost streamHost = (Bytestream.StreamHost) it.next();
                if (streamHost.getJID().equals((CharSequence) this.lastWorkingProxy)) {
                    r2 = streamHost;
                    break;
                }
            }
            if (r2 != 0) {
                DetermineStreamHostInfos.remove(r2);
                DetermineStreamHostInfos.add(0, r2);
            }
        }
        ?? socks5Proxy = Socks5Proxy.getSocks5Proxy();
        try {
            try {
                socks5Proxy.addTransfer(strCreateDigest);
                Bytestream bytestreamCreateBytestreamInitiation = createBytestreamInitiation(str, jid, DetermineStreamHostInfos);
                Bytestream.StreamHost streamHost2 = bytestreamCreateBytestreamInitiation.getStreamHost(((Bytestream) Connection.createStanzaCollectorAndSend(bytestreamCreateBytestreamInitiation).nextResultOrThrow(getTargetResponseTimeout())).getUsedHost().getJID());
                try {
                    if (streamHost2 == null) {
                        throw new SmackException.SmackMessageException("Remote user responded with unknown host");
                    }
                    Socket socket = new Socks5ClientForInitiator(streamHost2, strCreateDigest, Connection, str, jid).getSocket(getProxyConnectionTimeout());
                    this.lastWorkingProxy = streamHost2.getJID();
                    Socks5BytestreamSession socks5BytestreamSession = new Socks5BytestreamSession(socket, streamHost2.getJID().equals((CharSequence) Connection.getUser()));
                    socks5Proxy.removeTransfer(strCreateDigest);
                    return socks5BytestreamSession;
                } catch (TimeoutException e3) {
                    e = e3;
                }
            } catch (Throwable th) {
                th = th;
                Throwable th2 = th;
                socks5Proxy.removeTransfer(r2);
                throw th2;
            }
        } catch (TimeoutException e4) {
            e = e4;
        } catch (Throwable th3) {
            th = th3;
            r2 = strCreateDigest;
            Throwable th22 = th;
            socks5Proxy.removeTransfer(r2);
            throw th22;
        }
        throw new IOException("Timeout while connecting to SOCKS5 proxy", e);
    }

    private boolean supportsSocks5(Jid jid) throws SmackException.NotConnectedException, SmackException.NoResponseException, InterruptedException, XMPPException.XMPPErrorException {
        return ServiceDiscoveryManager.getInstanceFor(connection()).supportsFeature(jid, Bytestream.NAMESPACE);
    }

    public List<Jid> determineProxies() throws SmackException.NotConnectedException, SmackException.NoResponseException, InterruptedException, XMPPException.XMPPErrorException {
        XMPPConnection xMPPConnectionConnection = connection();
        ServiceDiscoveryManager instanceFor = ServiceDiscoveryManager.getInstanceFor(xMPPConnectionConnection);
        ArrayList arrayList = new ArrayList();
        for (DiscoverItems.Item item : instanceFor.discoverItems(xMPPConnectionConnection.getXMPPServiceDomain()).getItems()) {
            if (!this.proxyBlacklist.contains(item.getEntityID())) {
                try {
                    if (instanceFor.discoverInfo(item.getEntityID()).hasIdentity("proxy", "bytestreams")) {
                        arrayList.add(item.getEntityID());
                    } else {
                        this.proxyBlacklist.add(item.getEntityID());
                    }
                } catch (SmackException.NoResponseException | XMPPException.XMPPErrorException unused) {
                    this.proxyBlacklist.add(item.getEntityID());
                }
            }
        }
        return arrayList;
    }

    private List<Bytestream.StreamHost> determineStreamHostInfos(List<Jid> list) {
        XMPPConnection xMPPConnectionConnection = connection();
        ArrayList arrayList = new ArrayList();
        if (this.annouceLocalStreamHost) {
            arrayList.addAll(getLocalStreamHost());
        }
        for (Jid jid : list) {
            try {
                arrayList.addAll(((Bytestream) xMPPConnectionConnection.createStanzaCollectorAndSend(createStreamHostRequest(jid)).nextResultOrThrow()).getStreamHosts());
            } catch (Exception unused) {
                this.proxyBlacklist.add(jid);
            }
        }
        return arrayList;
    }

    private static Bytestream createStreamHostRequest(Jid jid) {
        Bytestream bytestream = new Bytestream();
        bytestream.setType(IQ.Type.get);
        bytestream.setTo(jid);
        return bytestream;
    }

    public List<Bytestream.StreamHost> getLocalStreamHost() {
        Socks5Proxy.getSocks5Proxy();
        ArrayList arrayList = new ArrayList();
        EntityFullJid user = connection().getUser();
        for (Socks5Proxy socks5Proxy : Socks5Proxy.getRunningProxies()) {
            List<InetAddress> localAddresses = socks5Proxy.getLocalAddresses();
            if (!localAddresses.isEmpty()) {
                int port = socks5Proxy.getPort();
                for (InetAddress inetAddress : localAddresses) {
                    if (!inetAddress.isLoopbackAddress()) {
                        arrayList.add(new Bytestream.StreamHost(user, inetAddress, port));
                    }
                }
            }
        }
        return arrayList;
    }

    private static Bytestream createBytestreamInitiation(String str, Jid jid, List<Bytestream.StreamHost> list) {
        Bytestream bytestream = new Bytestream(str);
        Iterator<Bytestream.StreamHost> it = list.iterator();
        while (it.hasNext()) {
            bytestream.addStreamHost(it.next());
        }
        bytestream.setType(IQ.Type.set);
        bytestream.setTo(jid);
        return bytestream;
    }

    protected void replyRejectPacket(IQ iq) throws SmackException.NotConnectedException, InterruptedException {
        connection().sendStanza(IQ.createErrorResponse(iq, StanzaError.getBuilder(StanzaError.Condition.not_acceptable).build()));
    }

    private void activate() {
        connection().registerIQRequestHandler(this.initiationListener);
        enableService();
    }

    private void enableService() {
        ServiceDiscoveryManager.getInstanceFor(connection()).addFeature(Bytestream.NAMESPACE);
    }

    private static String getNextSessionID() {
        return SESSION_ID_PREFIX + StringUtils.secureOnlineAttackSafeRandomString();
    }

    protected XMPPConnection getConnection() {
        return connection();
    }

    protected BytestreamListener getUserListener(Jid jid) {
        return this.userListeners.get(jid);
    }

    protected List<BytestreamListener> getAllRequestListeners() {
        return this.allRequestListeners;
    }

    protected List<String> getIgnoredBytestreamRequests() {
        return this.ignoredBytestreamRequests;
    }
}
