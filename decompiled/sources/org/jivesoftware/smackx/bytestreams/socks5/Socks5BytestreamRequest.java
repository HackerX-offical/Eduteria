package org.jivesoftware.smackx.bytestreams.socks5;

import java.io.IOException;
import java.net.Socket;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.concurrent.TimeoutException;
import org.jivesoftware.smack.SmackException;
import org.jivesoftware.smack.XMPPException;
import org.jivesoftware.smack.packet.IQ;
import org.jivesoftware.smack.packet.StanzaError;
import org.jivesoftware.smackx.bytestreams.BytestreamRequest;
import org.jivesoftware.smackx.bytestreams.socks5.Socks5Exception;
import org.jivesoftware.smackx.bytestreams.socks5.packet.Bytestream;
import org.jxmpp.jid.Jid;
import org.jxmpp.util.cache.Cache;
import org.jxmpp.util.cache.ExpirationCache;

/* JADX INFO: loaded from: classes10.dex */
public class Socks5BytestreamRequest implements BytestreamRequest {
    private static final int BLACKLIST_MAX_SIZE = 100;
    private Bytestream bytestreamRequest;
    private Socks5BytestreamManager manager;
    private static final long BLACKLIST_LIFETIME = 7200000;
    private static final Cache<String, Integer> ADDRESS_BLACKLIST = new ExpirationCache(100, BLACKLIST_LIFETIME);
    private static int DEFAULT_CONNECTION_FAILURE_THRESHOLD = 2;
    private int connectionFailureThreshold = DEFAULT_CONNECTION_FAILURE_THRESHOLD;
    private int totalConnectTimeout = 10000;
    private int minimumConnectTimeout = 2000;

    public static int getDefaultConnectFailureThreshold() {
        return DEFAULT_CONNECTION_FAILURE_THRESHOLD;
    }

    public static void setDefaultConnectFailureThreshold(int i) {
        DEFAULT_CONNECTION_FAILURE_THRESHOLD = i;
    }

    public int getConnectFailureThreshold() {
        return this.connectionFailureThreshold;
    }

    public void setConnectFailureThreshold(int i) {
        this.connectionFailureThreshold = i;
    }

    protected Socks5BytestreamRequest(Socks5BytestreamManager socks5BytestreamManager, Bytestream bytestream) {
        this.manager = socks5BytestreamManager;
        this.bytestreamRequest = bytestream;
    }

    public int getTotalConnectTimeout() {
        int i = this.totalConnectTimeout;
        if (i <= 0) {
            return 10000;
        }
        return i;
    }

    public void setTotalConnectTimeout(int i) {
        this.totalConnectTimeout = i;
    }

    public int getMinimumConnectTimeout() {
        int i = this.minimumConnectTimeout;
        if (i <= 0) {
            return 2000;
        }
        return i;
    }

    public void setMinimumConnectTimeout(int i) {
        this.minimumConnectTimeout = i;
    }

    @Override // org.jivesoftware.smackx.bytestreams.BytestreamRequest
    public Jid getFrom() {
        return this.bytestreamRequest.getFrom();
    }

    @Override // org.jivesoftware.smackx.bytestreams.BytestreamRequest
    public String getSessionID() {
        return this.bytestreamRequest.getSessionID();
    }

    @Override // org.jivesoftware.smackx.bytestreams.BytestreamRequest
    public Socks5BytestreamSession accept() throws SmackException.NotConnectedException, InterruptedException, Socks5Exception.NoSocks5StreamHostsProvided, Socks5Exception.CouldNotConnectToAnyProvidedSocks5Host, XMPPException.XMPPErrorException {
        Bytestream.StreamHost next;
        Socket socket;
        List<Bytestream.StreamHost> streamHosts = this.bytestreamRequest.getStreamHosts();
        HashMap map = new HashMap();
        if (streamHosts.size() == 0) {
            cancelRequest(map);
        }
        String strCreateDigest = Socks5Utils.createDigest(this.bytestreamRequest.getSessionID(), this.bytestreamRequest.getFrom(), this.manager.getConnection().getUser());
        int iMax = Math.max(getTotalConnectTimeout() / streamHosts.size(), getMinimumConnectTimeout());
        Iterator<Bytestream.StreamHost> it = streamHosts.iterator();
        while (true) {
            if (!it.hasNext()) {
                next = null;
                socket = null;
                break;
            }
            next = it.next();
            String str = ((Object) next.getAddress()) + ":" + next.getPort();
            int connectionFailures = getConnectionFailures(str);
            int i = this.connectionFailureThreshold;
            if (i <= 0 || connectionFailures < i) {
                try {
                    socket = new Socks5Client(next, strCreateDigest).getSocket(iMax);
                    break;
                } catch (IOException | TimeoutException | SmackException | XMPPException e2) {
                    map.put(next, e2);
                    incrementConnectionFailures(str);
                }
            }
        }
        if (next == null || socket == null) {
            cancelRequest(map);
        }
        this.manager.getConnection().sendStanza(createUsedHostResponse(next));
        return new Socks5BytestreamSession(socket, next.getJID().equals((CharSequence) this.bytestreamRequest.getFrom()));
    }

    @Override // org.jivesoftware.smackx.bytestreams.BytestreamRequest
    public void reject() throws SmackException.NotConnectedException, InterruptedException {
        this.manager.replyRejectPacket(this.bytestreamRequest);
    }

    private void cancelRequest(Map<Bytestream.StreamHost, Exception> map) throws SmackException.NotConnectedException, InterruptedException, Socks5Exception.NoSocks5StreamHostsProvided, Socks5Exception.CouldNotConnectToAnyProvidedSocks5Host {
        Socks5Exception.CouldNotConnectToAnyProvidedSocks5Host couldNotConnectToAnyProvidedSocks5HostConstruct;
        String message;
        Socks5Exception.NoSocks5StreamHostsProvided noSocks5StreamHostsProvided = null;
        if (map.isEmpty()) {
            Socks5Exception.NoSocks5StreamHostsProvided noSocks5StreamHostsProvided2 = new Socks5Exception.NoSocks5StreamHostsProvided();
            message = noSocks5StreamHostsProvided2.getMessage();
            noSocks5StreamHostsProvided = noSocks5StreamHostsProvided2;
            couldNotConnectToAnyProvidedSocks5HostConstruct = null;
        } else {
            couldNotConnectToAnyProvidedSocks5HostConstruct = Socks5Exception.CouldNotConnectToAnyProvidedSocks5Host.construct(map);
            message = couldNotConnectToAnyProvidedSocks5HostConstruct.getMessage();
        }
        this.manager.getConnection().sendStanza(IQ.createErrorResponse(this.bytestreamRequest, StanzaError.from(StanzaError.Condition.item_not_found, message).build()));
        if (noSocks5StreamHostsProvided != null) {
            throw noSocks5StreamHostsProvided;
        }
        throw couldNotConnectToAnyProvidedSocks5HostConstruct;
    }

    private Bytestream createUsedHostResponse(Bytestream.StreamHost streamHost) {
        Bytestream bytestream = new Bytestream(this.bytestreamRequest.getSessionID());
        bytestream.setTo(this.bytestreamRequest.getFrom());
        bytestream.setType(IQ.Type.result);
        bytestream.setStanzaId(this.bytestreamRequest.getStanzaId());
        bytestream.setUsedHost(streamHost.getJID());
        return bytestream;
    }

    private static void incrementConnectionFailures(String str) {
        Cache<String, Integer> cache = ADDRESS_BLACKLIST;
        Integer numLookup = cache.lookup(str);
        cache.put(str, Integer.valueOf(numLookup != null ? 1 + numLookup.intValue() : 1));
    }

    private static int getConnectionFailures(String str) {
        Integer numLookup = ADDRESS_BLACKLIST.lookup(str);
        if (numLookup != null) {
            return numLookup.intValue();
        }
        return 0;
    }
}
