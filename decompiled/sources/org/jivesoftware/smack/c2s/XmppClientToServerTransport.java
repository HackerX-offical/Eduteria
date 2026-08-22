package org.jivesoftware.smack.c2s;

import java.util.List;
import javax.net.ssl.SSLSession;
import org.jivesoftware.smack.SmackFuture;
import org.jivesoftware.smack.c2s.internal.ModularXmppClientToServerConnectionInternal;

/* JADX INFO: loaded from: classes10.dex */
public abstract class XmppClientToServerTransport {
    protected final ModularXmppClientToServerConnectionInternal connectionInternal;

    public interface LookupConnectionEndpointsFailed extends LookupConnectionEndpointsResult {
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public interface LookupConnectionEndpointsResult {
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public interface LookupConnectionEndpointsSuccess extends LookupConnectionEndpointsResult {
    }

    public static abstract class Stats {
    }

    protected abstract void afterFiltersClosed();

    protected abstract void disconnect();

    public abstract SSLSession getSslSession();

    public abstract Stats getStats();

    public abstract boolean isConnected();

    protected abstract void loadConnectionEndpoints(LookupConnectionEndpointsSuccess lookupConnectionEndpointsSuccess);

    protected abstract List<SmackFuture<LookupConnectionEndpointsResult, Exception>> lookupConnectionEndpoints();

    protected abstract void notifyAboutNewOutgoingElements();

    protected abstract void resetDiscoveredConnectionEndpoints();

    protected XmppClientToServerTransport(ModularXmppClientToServerConnectionInternal modularXmppClientToServerConnectionInternal) {
        this.connectionInternal = modularXmppClientToServerConnectionInternal;
    }

    public boolean isTransportSecured() {
        return getSslSession() != null;
    }
}
