package org.jivesoftware.smackx.ping;

import java.util.Iterator;
import java.util.Map;
import java.util.Set;
import java.util.WeakHashMap;
import java.util.concurrent.CopyOnWriteArraySet;
import java.util.concurrent.TimeUnit;
import java.util.logging.Logger;
import org.jivesoftware.smack.AbstractConnectionClosedListener;
import org.jivesoftware.smack.ConnectionCreationListener;
import org.jivesoftware.smack.Manager;
import org.jivesoftware.smack.ScheduledAction;
import org.jivesoftware.smack.SmackException;
import org.jivesoftware.smack.SmackFuture;
import org.jivesoftware.smack.XMPPConnection;
import org.jivesoftware.smack.XMPPConnectionRegistry;
import org.jivesoftware.smack.XMPPException;
import org.jivesoftware.smack.iqrequest.AbstractIqRequestHandler;
import org.jivesoftware.smack.iqrequest.IQRequestHandler;
import org.jivesoftware.smack.packet.IQ;
import org.jivesoftware.smack.packet.Stanza;
import org.jivesoftware.smack.packet.StanzaError;
import org.jivesoftware.smack.util.ExceptionCallback;
import org.jivesoftware.smack.util.SuccessCallback;
import org.jivesoftware.smackx.disco.ServiceDiscoveryManager;
import org.jivesoftware.smackx.ping.packet.Ping;
import org.jxmpp.jid.Jid;

/* JADX INFO: loaded from: classes10.dex */
public final class PingManager extends Manager {
    private static int defaultPingInterval;
    private ScheduledAction nextAutomaticPing;
    private final Set<PingFailedListener> pingFailedListeners;
    private int pingInterval;
    private static final Logger LOGGER = Logger.getLogger(PingManager.class.getName());
    private static final Map<XMPPConnection, PingManager> INSTANCES = new WeakHashMap();

    static {
        XMPPConnectionRegistry.addConnectionCreationListener(new ConnectionCreationListener() { // from class: org.jivesoftware.smackx.ping.PingManager.1
            @Override // org.jivesoftware.smack.ConnectionCreationListener
            public void connectionCreated(XMPPConnection xMPPConnection) {
                PingManager.getInstanceFor(xMPPConnection);
            }
        });
        defaultPingInterval = 1800;
    }

    public static synchronized PingManager getInstanceFor(XMPPConnection xMPPConnection) {
        PingManager pingManager;
        Map<XMPPConnection, PingManager> map = INSTANCES;
        pingManager = map.get(xMPPConnection);
        if (pingManager == null) {
            pingManager = new PingManager(xMPPConnection);
            map.put(xMPPConnection, pingManager);
        }
        return pingManager;
    }

    public static void setDefaultPingInterval(int i) {
        defaultPingInterval = i;
    }

    private PingManager(XMPPConnection xMPPConnection) {
        super(xMPPConnection);
        this.pingFailedListeners = new CopyOnWriteArraySet();
        this.pingInterval = defaultPingInterval;
        ServiceDiscoveryManager.getInstanceFor(xMPPConnection).addFeature(Ping.NAMESPACE);
        xMPPConnection.registerIQRequestHandler(new AbstractIqRequestHandler("ping", Ping.NAMESPACE, IQ.Type.get, IQRequestHandler.Mode.async) { // from class: org.jivesoftware.smackx.ping.PingManager.2
            @Override // org.jivesoftware.smack.iqrequest.AbstractIqRequestHandler, org.jivesoftware.smack.iqrequest.IQRequestHandler
            public IQ handleIQRequest(IQ iq) {
                return ((Ping) iq).getPong();
            }
        });
        xMPPConnection.addConnectionListener(new AbstractConnectionClosedListener() { // from class: org.jivesoftware.smackx.ping.PingManager.3
            @Override // org.jivesoftware.smack.ConnectionListener
            public void authenticated(XMPPConnection xMPPConnection2, boolean z) {
                PingManager.this.maybeSchedulePingServerTask();
            }

            @Override // org.jivesoftware.smack.AbstractConnectionClosedListener
            public void connectionTerminated() {
                PingManager.this.maybeStopPingServerTask();
            }
        });
        maybeSchedulePingServerTask();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public boolean isValidErrorPong(Jid jid, XMPPException.XMPPErrorException xMPPErrorException) {
        if (jid.equals((CharSequence) connection().getXMPPServiceDomain())) {
            return true;
        }
        StanzaError stanzaError = xMPPErrorException.getStanzaError();
        return stanzaError.getType() == StanzaError.Type.CANCEL && stanzaError.getCondition() == StanzaError.Condition.feature_not_implemented;
    }

    public SmackFuture<Boolean, Exception> pingAsync(Jid jid) {
        return pingAsync(jid, connection().getReplyTimeout());
    }

    public SmackFuture<Boolean, Exception> pingAsync(final Jid jid, long j) {
        final SmackFuture.InternalProcessStanzaSmackFuture<Boolean, Exception> internalProcessStanzaSmackFuture = new SmackFuture.InternalProcessStanzaSmackFuture<Boolean, Exception>() { // from class: org.jivesoftware.smackx.ping.PingManager.4
            @Override // org.jivesoftware.smack.SmackFuture.InternalProcessStanzaSmackFuture
            public void handleStanza(Stanza stanza) {
                setResult(true);
            }

            @Override // org.jivesoftware.smack.SmackFuture.InternalProcessStanzaSmackFuture
            public boolean isNonFatalException(Exception exc) {
                if (!(exc instanceof XMPPException.XMPPErrorException)) {
                    return false;
                }
                if (!PingManager.this.isValidErrorPong(jid, (XMPPException.XMPPErrorException) exc)) {
                    return false;
                }
                setResult(true);
                return true;
            }
        };
        XMPPConnection xMPPConnectionConnection = connection();
        xMPPConnectionConnection.sendIqRequestAsync(new Ping(xMPPConnectionConnection, jid), j).onSuccess(new SuccessCallback<IQ>() { // from class: org.jivesoftware.smackx.ping.PingManager.6
            @Override // org.jivesoftware.smack.util.SuccessCallback
            public void onSuccess(IQ iq) {
                internalProcessStanzaSmackFuture.processStanza(iq);
            }
        }).onError(new ExceptionCallback<Exception>() { // from class: org.jivesoftware.smackx.ping.PingManager.5
            @Override // org.jivesoftware.smack.util.ExceptionCallback
            public void processException(Exception exc) {
                internalProcessStanzaSmackFuture.processException(exc);
            }
        });
        return internalProcessStanzaSmackFuture;
    }

    public boolean ping(Jid jid, long j) throws SmackException.NotConnectedException, SmackException.NoResponseException, InterruptedException {
        XMPPConnection xMPPConnectionConnection = connection();
        if (!xMPPConnectionConnection.isAuthenticated()) {
            throw new SmackException.NotConnectedException();
        }
        try {
            xMPPConnectionConnection.createStanzaCollectorAndSend(new Ping(xMPPConnectionConnection, jid)).nextResultOrThrow(j);
            return true;
        } catch (XMPPException.XMPPErrorException e2) {
            return isValidErrorPong(jid, e2);
        }
    }

    public boolean ping(Jid jid) throws SmackException.NotConnectedException, SmackException.NoResponseException, InterruptedException {
        return ping(jid, connection().getReplyTimeout());
    }

    public boolean isPingSupported(Jid jid) throws SmackException.NotConnectedException, SmackException.NoResponseException, InterruptedException, XMPPException.XMPPErrorException {
        return ServiceDiscoveryManager.getInstanceFor(connection()).supportsFeature(jid, Ping.NAMESPACE);
    }

    public boolean pingMyServer() throws SmackException.NotConnectedException, InterruptedException {
        return pingMyServer(true);
    }

    public boolean pingMyServer(boolean z) throws SmackException.NotConnectedException, InterruptedException {
        return pingMyServer(z, connection().getReplyTimeout());
    }

    public boolean pingMyServer(boolean z, long j) throws SmackException.NotConnectedException, InterruptedException {
        boolean zPing;
        try {
            zPing = ping(connection().getXMPPServiceDomain(), j);
        } catch (SmackException.NoResponseException unused) {
            zPing = false;
        }
        if (!zPing && z) {
            Iterator<PingFailedListener> it = this.pingFailedListeners.iterator();
            while (it.hasNext()) {
                it.next().pingFailed();
            }
        }
        return zPing;
    }

    public void setPingInterval(int i) {
        this.pingInterval = i;
        maybeSchedulePingServerTask();
    }

    public int getPingInterval() {
        return this.pingInterval;
    }

    public void registerPingFailedListener(PingFailedListener pingFailedListener) {
        this.pingFailedListeners.add(pingFailedListener);
    }

    public void unregisterPingFailedListener(PingFailedListener pingFailedListener) {
        this.pingFailedListeners.remove(pingFailedListener);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void maybeSchedulePingServerTask() {
        maybeSchedulePingServerTask(0);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public synchronized void maybeSchedulePingServerTask(int i) {
        maybeStopPingServerTask();
        int i2 = this.pingInterval;
        if (i2 > 0) {
            int i3 = i2 - i;
            LOGGER.fine("Scheduling ServerPingTask in " + i3 + " seconds (pingInterval=" + this.pingInterval + ", delta=" + i + ")");
            this.nextAutomaticPing = schedule(new Runnable() { // from class: org.jivesoftware.smackx.ping.PingManager$$ExternalSyntheticLambda0
                @Override // java.lang.Runnable
                public final void run() {
                    this.f$0.pingServerIfNecessary();
                }
            }, i3, TimeUnit.SECONDS);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void maybeStopPingServerTask() {
        ScheduledAction scheduledAction = this.nextAutomaticPing;
        if (scheduledAction != null) {
            scheduledAction.cancel();
            this.nextAutomaticPing = null;
        }
    }

    public void pingServerIfNecessary() {
        int iCurrentTimeMillis;
        final XMPPConnection xMPPConnectionConnection = connection();
        if (xMPPConnectionConnection != null && this.pingInterval > 0) {
            long lastStanzaReceived = xMPPConnectionConnection.getLastStanzaReceived();
            if (lastStanzaReceived > 0 && (iCurrentTimeMillis = (int) ((System.currentTimeMillis() - lastStanzaReceived) / 1000)) < this.pingInterval) {
                maybeSchedulePingServerTask(iCurrentTimeMillis);
                return;
            }
            if (!xMPPConnectionConnection.isAuthenticated()) {
                LOGGER.warning(xMPPConnectionConnection + " was not authenticated");
                return;
            }
            long millis = TimeUnit.MINUTES.toMillis(2L);
            long replyTimeout = xMPPConnectionConnection.getReplyTimeout();
            if (replyTimeout > millis) {
                millis = replyTimeout;
            }
            SmackFuture<Boolean, Exception> smackFuturePingAsync = pingAsync(xMPPConnectionConnection.getXMPPServiceDomain(), millis);
            smackFuturePingAsync.onSuccess(new SuccessCallback<Boolean>() { // from class: org.jivesoftware.smackx.ping.PingManager.7
                @Override // org.jivesoftware.smack.util.SuccessCallback
                public void onSuccess(Boolean bool) {
                    PingManager.this.maybeSchedulePingServerTask();
                }
            });
            smackFuturePingAsync.onError(new ExceptionCallback<Exception>() { // from class: org.jivesoftware.smackx.ping.PingManager.8
                @Override // org.jivesoftware.smack.util.ExceptionCallback
                public void processException(Exception exc) {
                    int iCurrentTimeMillis2;
                    long lastStanzaReceived2 = xMPPConnectionConnection.getLastStanzaReceived();
                    if (lastStanzaReceived2 <= 0 || (iCurrentTimeMillis2 = (int) ((System.currentTimeMillis() - lastStanzaReceived2) / 1000)) >= PingManager.this.pingInterval) {
                        Iterator it = PingManager.this.pingFailedListeners.iterator();
                        while (it.hasNext()) {
                            ((PingFailedListener) it.next()).pingFailed();
                        }
                        return;
                    }
                    PingManager.this.maybeSchedulePingServerTask(iCurrentTimeMillis2);
                }
            });
        }
    }
}
