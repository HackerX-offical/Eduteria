package org.jivesoftware.smackx.carbons;

import java.util.Iterator;
import java.util.Map;
import java.util.Set;
import java.util.WeakHashMap;
import java.util.concurrent.CopyOnWriteArraySet;
import java.util.logging.Level;
import java.util.logging.Logger;
import org.jivesoftware.smack.AsyncButOrdered;
import org.jivesoftware.smack.ConnectionCreationListener;
import org.jivesoftware.smack.ConnectionListener;
import org.jivesoftware.smack.Manager;
import org.jivesoftware.smack.SmackException;
import org.jivesoftware.smack.StanzaListener;
import org.jivesoftware.smack.XMPPConnection;
import org.jivesoftware.smack.XMPPConnectionRegistry;
import org.jivesoftware.smack.XMPPException;
import org.jivesoftware.smack.filter.AndFilter;
import org.jivesoftware.smack.filter.FromMatchesFilter;
import org.jivesoftware.smack.filter.OrFilter;
import org.jivesoftware.smack.filter.StanzaExtensionFilter;
import org.jivesoftware.smack.filter.StanzaFilter;
import org.jivesoftware.smack.filter.StanzaTypeFilter;
import org.jivesoftware.smack.packet.IQ;
import org.jivesoftware.smack.packet.Message;
import org.jivesoftware.smack.packet.Stanza;
import org.jivesoftware.smack.util.ExceptionCallback;
import org.jivesoftware.smack.util.SuccessCallback;
import org.jivesoftware.smackx.carbons.packet.Carbon;
import org.jivesoftware.smackx.carbons.packet.CarbonExtension;
import org.jivesoftware.smackx.disco.ServiceDiscoveryManager;
import org.jxmpp.jid.BareJid;
import org.jxmpp.jid.EntityFullJid;

/* JADX INFO: loaded from: classes10.dex */
public final class CarbonManager extends Manager {
    private static final StanzaFilter CARBON_EXTENSION_FILTER;
    private final StanzaListener carbonsListener;
    private final AsyncButOrdered<BareJid> carbonsListenerAsyncButOrdered;
    private volatile boolean enabledByDefault;
    private volatile boolean enabled_state;

    /* JADX INFO: renamed from: listeners, reason: collision with root package name */
    private final Set<CarbonCopyReceivedListener> f1493listeners;
    private static final Logger LOGGER = Logger.getLogger(CarbonManager.class.getName());
    private static Map<XMPPConnection, CarbonManager> INSTANCES = new WeakHashMap();
    private static boolean ENABLED_BY_DEFAULT = false;

    static {
        XMPPConnectionRegistry.addConnectionCreationListener(new ConnectionCreationListener() { // from class: org.jivesoftware.smackx.carbons.CarbonManager.1
            @Override // org.jivesoftware.smack.ConnectionCreationListener
            public void connectionCreated(XMPPConnection xMPPConnection) {
                CarbonManager.getInstanceFor(xMPPConnection);
            }
        });
        CARBON_EXTENSION_FILTER = new AndFilter(new OrFilter(new StanzaExtensionFilter(CarbonExtension.Direction.sent.name(), "urn:xmpp:carbons:2"), new StanzaExtensionFilter(CarbonExtension.Direction.received.name(), "urn:xmpp:carbons:2")), StanzaTypeFilter.MESSAGE);
    }

    public static void setEnabledByDefault(boolean z) {
        ENABLED_BY_DEFAULT = z;
    }

    private CarbonManager(XMPPConnection xMPPConnection) {
        super(xMPPConnection);
        this.f1493listeners = new CopyOnWriteArraySet();
        this.enabled_state = false;
        this.enabledByDefault = ENABLED_BY_DEFAULT;
        this.carbonsListenerAsyncButOrdered = new AsyncButOrdered<>();
        ServiceDiscoveryManager.getInstanceFor(xMPPConnection).addFeature("urn:xmpp:carbons:2");
        this.carbonsListener = new StanzaListener() { // from class: org.jivesoftware.smackx.carbons.CarbonManager.2
            @Override // org.jivesoftware.smack.StanzaListener
            public void processStanza(Stanza stanza) {
                final Message message = (Message) stanza;
                CarbonExtension carbonExtensionFrom = CarbonExtension.from(message);
                final CarbonExtension.Direction direction = carbonExtensionFrom.getDirection();
                final Message message2 = (Message) carbonExtensionFrom.getForwarded().getForwardedStanza();
                CarbonManager.this.carbonsListenerAsyncButOrdered.performAsyncButOrdered(message2.getFrom().asBareJid(), new Runnable() { // from class: org.jivesoftware.smackx.carbons.CarbonManager.2.1
                    @Override // java.lang.Runnable
                    public void run() {
                        Iterator it = CarbonManager.this.f1493listeners.iterator();
                        while (it.hasNext()) {
                            ((CarbonCopyReceivedListener) it.next()).onCarbonCopyReceived(direction, message2, message);
                        }
                    }
                });
            }
        };
        xMPPConnection.addConnectionListener(new ConnectionListener() { // from class: org.jivesoftware.smackx.carbons.CarbonManager.3
            @Override // org.jivesoftware.smack.ConnectionListener
            public void connectionClosed() {
                CarbonManager.this.enabled_state = false;
                CarbonManager.this.connection().removeSyncStanzaListener(CarbonManager.this.carbonsListener);
            }

            @Override // org.jivesoftware.smack.ConnectionListener
            public void authenticated(XMPPConnection xMPPConnection2, boolean z) {
                if (!z) {
                    CarbonManager.this.enabled_state = false;
                    try {
                        if (CarbonManager.this.shouldCarbonsBeEnabled() && CarbonManager.this.isSupportedByServer()) {
                            CarbonManager.this.setCarbonsEnabled(true);
                        }
                    } catch (InterruptedException | SmackException.NoResponseException | SmackException.NotConnectedException | XMPPException.XMPPErrorException e2) {
                        CarbonManager.LOGGER.log(Level.WARNING, "Cannot check for Carbon support and / or enable carbons.", e2);
                    }
                }
                CarbonManager.this.addCarbonsListener(xMPPConnection2);
            }
        });
        addCarbonsListener(xMPPConnection);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void addCarbonsListener(XMPPConnection xMPPConnection) {
        EntityFullJid user = xMPPConnection.getUser();
        if (user == null) {
            return;
        }
        xMPPConnection.addSyncStanzaListener(this.carbonsListener, new AndFilter(CARBON_EXTENSION_FILTER, FromMatchesFilter.createBare(user)));
    }

    public static synchronized CarbonManager getInstanceFor(XMPPConnection xMPPConnection) {
        CarbonManager carbonManager;
        carbonManager = INSTANCES.get(xMPPConnection);
        if (carbonManager == null) {
            carbonManager = new CarbonManager(xMPPConnection);
            INSTANCES.put(xMPPConnection, carbonManager);
        }
        return carbonManager;
    }

    private static IQ carbonsEnabledIQ(boolean z) {
        if (z) {
            return new Carbon.Enable();
        }
        return new Carbon.Disable();
    }

    public boolean addCarbonCopyReceivedListener(CarbonCopyReceivedListener carbonCopyReceivedListener) {
        return this.f1493listeners.add(carbonCopyReceivedListener);
    }

    public boolean removeCarbonCopyReceivedListener(CarbonCopyReceivedListener carbonCopyReceivedListener) {
        return this.f1493listeners.remove(carbonCopyReceivedListener);
    }

    public boolean isSupportedByServer() throws SmackException.NotConnectedException, SmackException.NoResponseException, InterruptedException, XMPPException.XMPPErrorException {
        return ServiceDiscoveryManager.getInstanceFor(connection()).serverSupportsFeature("urn:xmpp:carbons:2");
    }

    @Deprecated
    public void sendCarbonsEnabled(boolean z) {
        sendUseCarbons(z, null);
    }

    public void enableCarbonsAsync(ExceptionCallback<Exception> exceptionCallback) {
        sendUseCarbons(true, exceptionCallback);
    }

    public void disableCarbonsAsync(ExceptionCallback<Exception> exceptionCallback) {
        sendUseCarbons(false, exceptionCallback);
    }

    private void sendUseCarbons(final boolean z, ExceptionCallback<Exception> exceptionCallback) {
        this.enabledByDefault = z;
        connection().sendIqRequestAsync(carbonsEnabledIQ(z)).onSuccess(new SuccessCallback<IQ>() { // from class: org.jivesoftware.smackx.carbons.CarbonManager.4
            @Override // org.jivesoftware.smack.util.SuccessCallback
            public void onSuccess(IQ iq) {
                CarbonManager.this.enabled_state = z;
            }
        }).onError(exceptionCallback);
    }

    public synchronized void setCarbonsEnabled(boolean z) throws SmackException.NotConnectedException, SmackException.NoResponseException, InterruptedException, XMPPException.XMPPErrorException {
        this.enabledByDefault = z;
        if (this.enabled_state == z) {
            return;
        }
        connection().createStanzaCollectorAndSend(carbonsEnabledIQ(z)).nextResultOrThrow();
        this.enabled_state = z;
    }

    public void enableCarbons() throws SmackException, InterruptedException, XMPPException {
        setCarbonsEnabled(true);
    }

    public void disableCarbons() throws SmackException, InterruptedException, XMPPException {
        setCarbonsEnabled(false);
    }

    public boolean getCarbonsEnabled() {
        return this.enabled_state;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public boolean shouldCarbonsBeEnabled() {
        return this.enabledByDefault;
    }

    @Deprecated
    public static void disableCarbons(Message message) {
        message.addExtension(CarbonExtension.Private.INSTANCE);
    }
}
