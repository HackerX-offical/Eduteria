package org.jivesoftware.smackx.iot.provisioning;

import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.WeakHashMap;
import java.util.concurrent.CopyOnWriteArraySet;
import java.util.logging.Level;
import java.util.logging.Logger;
import org.jivesoftware.smack.ConnectionCreationListener;
import org.jivesoftware.smack.Manager;
import org.jivesoftware.smack.SmackException;
import org.jivesoftware.smack.StanzaListener;
import org.jivesoftware.smack.XMPPConnection;
import org.jivesoftware.smack.XMPPConnectionRegistry;
import org.jivesoftware.smack.XMPPException;
import org.jivesoftware.smack.filter.AndFilter;
import org.jivesoftware.smack.filter.StanzaExtensionFilter;
import org.jivesoftware.smack.filter.StanzaFilter;
import org.jivesoftware.smack.filter.StanzaTypeFilter;
import org.jivesoftware.smack.iqrequest.AbstractIqRequestHandler;
import org.jivesoftware.smack.iqrequest.IQRequestHandler;
import org.jivesoftware.smack.packet.IQ;
import org.jivesoftware.smack.packet.Message;
import org.jivesoftware.smack.packet.MessageBuilder;
import org.jivesoftware.smack.packet.Presence;
import org.jivesoftware.smack.packet.PresenceBuilder;
import org.jivesoftware.smack.packet.Stanza;
import org.jivesoftware.smack.roster.AbstractPresenceEventListener;
import org.jivesoftware.smack.roster.Roster;
import org.jivesoftware.smack.roster.SubscribeListener;
import org.jivesoftware.smackx.disco.ServiceDiscoveryManager;
import org.jivesoftware.smackx.disco.packet.DiscoverInfo;
import org.jivesoftware.smackx.iot.IoTManager;
import org.jivesoftware.smackx.iot.discovery.IoTDiscoveryManager;
import org.jivesoftware.smackx.iot.provisioning.element.ClearCache;
import org.jivesoftware.smackx.iot.provisioning.element.ClearCacheResponse;
import org.jivesoftware.smackx.iot.provisioning.element.Friend;
import org.jivesoftware.smackx.iot.provisioning.element.IoTIsFriend;
import org.jivesoftware.smackx.iot.provisioning.element.IoTIsFriendResponse;
import org.jivesoftware.smackx.iot.provisioning.element.Unfriend;
import org.jxmpp.jid.BareJid;
import org.jxmpp.jid.DomainBareJid;
import org.jxmpp.jid.Jid;
import org.jxmpp.util.cache.LruCache;

/* JADX INFO: loaded from: classes10.dex */
public final class IoTProvisioningManager extends Manager {
    static final /* synthetic */ boolean $assertionsDisabled = false;
    private final Set<BecameFriendListener> becameFriendListeners;
    private Jid configuredProvisioningServer;
    private final LruCache<BareJid, Void> friendshipDeniedCache;
    private final LruCache<BareJid, Void> friendshipRequestedCache;
    private final LruCache<Jid, LruCache<BareJid, Void>> negativeFriendshipRequestCache;
    private final Roster roster;
    private final Set<WasUnfriendedListener> wasUnfriendedListeners;
    private static final Logger LOGGER = Logger.getLogger(IoTProvisioningManager.class.getName());
    private static final StanzaFilter FRIEND_MESSAGE = new AndFilter(StanzaTypeFilter.MESSAGE, new StanzaExtensionFilter(Friend.ELEMENT, "urn:xmpp:iot:provisioning"));
    private static final StanzaFilter UNFRIEND_MESSAGE = new AndFilter(StanzaTypeFilter.MESSAGE, new StanzaExtensionFilter(Unfriend.ELEMENT, "urn:xmpp:iot:provisioning"));
    private static final Map<XMPPConnection, IoTProvisioningManager> INSTANCES = new WeakHashMap();

    static {
        XMPPConnectionRegistry.addConnectionCreationListener(new ConnectionCreationListener() { // from class: org.jivesoftware.smackx.iot.provisioning.IoTProvisioningManager.1
            @Override // org.jivesoftware.smack.ConnectionCreationListener
            public void connectionCreated(XMPPConnection xMPPConnection) {
                if (IoTManager.isAutoEnableActive()) {
                    IoTProvisioningManager.getInstanceFor(xMPPConnection);
                }
            }
        });
    }

    public static synchronized IoTProvisioningManager getInstanceFor(XMPPConnection xMPPConnection) {
        IoTProvisioningManager ioTProvisioningManager;
        Map<XMPPConnection, IoTProvisioningManager> map = INSTANCES;
        ioTProvisioningManager = map.get(xMPPConnection);
        if (ioTProvisioningManager == null) {
            ioTProvisioningManager = new IoTProvisioningManager(xMPPConnection);
            map.put(xMPPConnection, ioTProvisioningManager);
        }
        return ioTProvisioningManager;
    }

    private IoTProvisioningManager(XMPPConnection xMPPConnection) {
        super(xMPPConnection);
        this.negativeFriendshipRequestCache = new LruCache<>(8);
        this.friendshipDeniedCache = new LruCache<>(16);
        this.friendshipRequestedCache = new LruCache<>(16);
        this.becameFriendListeners = new CopyOnWriteArraySet();
        this.wasUnfriendedListeners = new CopyOnWriteArraySet();
        xMPPConnection.addAsyncStanzaListener(new StanzaListener() { // from class: org.jivesoftware.smackx.iot.provisioning.IoTProvisioningManager.2
            /* JADX WARN: Multi-variable type inference failed */
            @Override // org.jivesoftware.smack.StanzaListener
            public void processStanza(Stanza stanza) throws SmackException.NotConnectedException, InterruptedException {
                if (IoTProvisioningManager.this.isFromProvisioningService(stanza, true)) {
                    BareJid jid = Unfriend.from((Message) stanza).getJid();
                    XMPPConnection xMPPConnectionConnection = IoTProvisioningManager.this.connection();
                    if (!Roster.getInstanceFor(xMPPConnectionConnection).isSubscribedToMyPresence(jid)) {
                        IoTProvisioningManager.LOGGER.warning("Ignoring <unfriend/> request '" + stanza + "' because " + ((Object) jid) + " is already not subscribed to our presence.");
                    } else {
                        xMPPConnectionConnection.sendStanza(((PresenceBuilder) xMPPConnectionConnection.getStanzaFactory().buildPresenceStanza().ofType(Presence.Type.unsubscribed).to((Jid) jid)).build());
                    }
                }
            }
        }, UNFRIEND_MESSAGE);
        xMPPConnection.addAsyncStanzaListener(new StanzaListener() { // from class: org.jivesoftware.smackx.iot.provisioning.IoTProvisioningManager.3
            /* JADX WARN: Multi-variable type inference failed */
            @Override // org.jivesoftware.smack.StanzaListener
            public void processStanza(Stanza stanza) throws SmackException.NotConnectedException, InterruptedException {
                Message message = (Message) stanza;
                BareJid friend = Friend.from(message).getFriend();
                if (IoTProvisioningManager.this.isFromProvisioningService(message, false)) {
                    XMPPConnection xMPPConnectionConnection = IoTProvisioningManager.this.connection();
                    xMPPConnectionConnection.sendStanza(((MessageBuilder) ((MessageBuilder) xMPPConnectionConnection.getStanzaFactory().buildMessageStanza().to((Jid) friend)).addExtension(new Friend(xMPPConnectionConnection.getUser().asBareJid()))).build());
                    return;
                }
                BareJid bareJidAsBareJid = message.getFrom().asBareJid();
                if (!IoTProvisioningManager.this.friendshipDeniedCache.containsKey(bareJidAsBareJid)) {
                    IoTProvisioningManager.LOGGER.log(Level.WARNING, "Ignoring friendship recommendation " + message + " because friendship to this JID was not previously denied.");
                } else if (!bareJidAsBareJid.equals((CharSequence) friend)) {
                    IoTProvisioningManager.LOGGER.log(Level.WARNING, "Ignoring friendship recommendation " + message + " because it does not recommend itself, but " + ((Object) friend) + '.');
                } else {
                    IoTProvisioningManager.this.sendFriendshipRequest(friend);
                }
            }
        }, FRIEND_MESSAGE);
        xMPPConnection.registerIQRequestHandler(new AbstractIqRequestHandler(ClearCache.ELEMENT, "urn:xmpp:iot:provisioning", IQ.Type.set, IQRequestHandler.Mode.async) { // from class: org.jivesoftware.smackx.iot.provisioning.IoTProvisioningManager.4
            @Override // org.jivesoftware.smack.iqrequest.AbstractIqRequestHandler, org.jivesoftware.smack.iqrequest.IQRequestHandler
            public IQ handleIQRequest(IQ iq) {
                if (!IoTProvisioningManager.this.isFromProvisioningService(iq, true)) {
                    return null;
                }
                ClearCache clearCache = (ClearCache) iq;
                LruCache lruCache = (LruCache) IoTProvisioningManager.this.negativeFriendshipRequestCache.lookup(iq.getFrom());
                if (lruCache != null) {
                    lruCache.clear();
                }
                return new ClearCacheResponse(clearCache);
            }
        });
        Roster instanceFor = Roster.getInstanceFor(xMPPConnection);
        this.roster = instanceFor;
        instanceFor.addSubscribeListener(new SubscribeListener() { // from class: org.jivesoftware.smackx.iot.provisioning.IoTProvisioningManager.5
            @Override // org.jivesoftware.smack.roster.SubscribeListener
            public SubscribeListener.SubscribeAnswer processSubscribe(Jid jid, Presence presence) {
                Jid configuredProvisioningServer;
                try {
                    if (IoTDiscoveryManager.getInstanceFor(IoTProvisioningManager.this.connection()).isRegistry(jid.asBareJid())) {
                        return SubscribeListener.SubscribeAnswer.Approve;
                    }
                } catch (InterruptedException | SmackException.NoResponseException | SmackException.NotConnectedException | XMPPException.XMPPErrorException e2) {
                    IoTProvisioningManager.LOGGER.log(Level.WARNING, "Could not determine if " + ((Object) jid) + " is a registry", e2);
                }
                try {
                    configuredProvisioningServer = IoTProvisioningManager.this.getConfiguredProvisioningServer();
                } catch (InterruptedException | SmackException.NoResponseException | SmackException.NotConnectedException | XMPPException.XMPPErrorException e3) {
                    IoTProvisioningManager.LOGGER.log(Level.WARNING, "Could not determine provisioning server. Ignoring friend request from " + ((Object) jid), e3);
                    configuredProvisioningServer = null;
                }
                if (configuredProvisioningServer == null) {
                    return null;
                }
                try {
                    if (IoTProvisioningManager.this.isFriend(configuredProvisioningServer, jid.asBareJid())) {
                        return SubscribeListener.SubscribeAnswer.Approve;
                    }
                    return SubscribeListener.SubscribeAnswer.Deny;
                } catch (InterruptedException | SmackException.NoResponseException | SmackException.NotConnectedException | XMPPException.XMPPErrorException e4) {
                    IoTProvisioningManager.LOGGER.log(Level.WARNING, "Could not determine if " + ((Object) jid) + " is a friend.", e4);
                    return null;
                }
            }
        });
        instanceFor.addPresenceEventListener(new AbstractPresenceEventListener() { // from class: org.jivesoftware.smackx.iot.provisioning.IoTProvisioningManager.6
            @Override // org.jivesoftware.smack.roster.AbstractPresenceEventListener, org.jivesoftware.smack.roster.PresenceEventListener
            public void presenceSubscribed(BareJid bareJid, Presence presence) {
                IoTProvisioningManager.this.friendshipRequestedCache.remove(bareJid);
                Iterator it = IoTProvisioningManager.this.becameFriendListeners.iterator();
                while (it.hasNext()) {
                    ((BecameFriendListener) it.next()).becameFriend(bareJid, presence);
                }
            }

            @Override // org.jivesoftware.smack.roster.AbstractPresenceEventListener, org.jivesoftware.smack.roster.PresenceEventListener
            public void presenceUnsubscribed(BareJid bareJid, Presence presence) {
                if (IoTProvisioningManager.this.friendshipRequestedCache.containsKey(bareJid)) {
                    IoTProvisioningManager.this.friendshipDeniedCache.put(bareJid, null);
                }
                Iterator it = IoTProvisioningManager.this.wasUnfriendedListeners.iterator();
                while (it.hasNext()) {
                    ((WasUnfriendedListener) it.next()).wasUnfriendedListener(bareJid, presence);
                }
            }
        });
    }

    public void setConfiguredProvisioningServer(Jid jid) {
        this.configuredProvisioningServer = jid;
    }

    public Jid getConfiguredProvisioningServer() throws SmackException.NotConnectedException, SmackException.NoResponseException, InterruptedException, XMPPException.XMPPErrorException {
        if (this.configuredProvisioningServer == null) {
            this.configuredProvisioningServer = findProvisioningServerComponent();
        }
        return this.configuredProvisioningServer;
    }

    public DomainBareJid findProvisioningServerComponent() throws SmackException.NotConnectedException, SmackException.NoResponseException, InterruptedException, XMPPException.XMPPErrorException {
        List<DiscoverInfo> listFindServicesDiscoverInfo = ServiceDiscoveryManager.getInstanceFor(connection()).findServicesDiscoverInfo("urn:xmpp:iot:provisioning", true, true);
        if (listFindServicesDiscoverInfo.isEmpty()) {
            return null;
        }
        return listFindServicesDiscoverInfo.get(0).getFrom().asDomainBareJid();
    }

    public boolean isFriend(Jid jid, BareJid bareJid) throws SmackException.NotConnectedException, SmackException.NoResponseException, InterruptedException, XMPPException.XMPPErrorException {
        LruCache<BareJid, Void> lruCacheLookup = this.negativeFriendshipRequestCache.lookup(jid);
        if (lruCacheLookup != null && lruCacheLookup.containsKey(bareJid)) {
            return false;
        }
        IoTIsFriend ioTIsFriend = new IoTIsFriend(bareJid);
        ioTIsFriend.setTo(jid);
        boolean isFriendResult = ((IoTIsFriendResponse) connection().createStanzaCollectorAndSend(ioTIsFriend).nextResultOrThrow()).getIsFriendResult();
        if (!isFriendResult) {
            if (lruCacheLookup == null) {
                lruCacheLookup = new LruCache<>(1024);
                this.negativeFriendshipRequestCache.put(jid, lruCacheLookup);
            }
            lruCacheLookup.put(bareJid, null);
        }
        return isFriendResult;
    }

    public boolean iAmFriendOf(BareJid bareJid) {
        return this.roster.iAmSubscribedTo(bareJid);
    }

    /* JADX WARN: Multi-variable type inference failed */
    public void sendFriendshipRequest(BareJid bareJid) throws SmackException.NotConnectedException, InterruptedException {
        Presence presenceBuild = ((PresenceBuilder) connection().getStanzaFactory().buildPresenceStanza().ofType(Presence.Type.subscribe).to((Jid) bareJid)).build();
        this.friendshipRequestedCache.put(bareJid, null);
        connection().sendStanza(presenceBuild);
    }

    public void sendFriendshipRequestIfRequired(BareJid bareJid) throws SmackException.NotConnectedException, InterruptedException {
        if (iAmFriendOf(bareJid)) {
            return;
        }
        sendFriendshipRequest(bareJid);
    }

    public boolean isMyFriend(Jid jid) {
        return this.roster.isSubscribedToMyPresence(jid);
    }

    /* JADX WARN: Multi-variable type inference failed */
    public void unfriend(Jid jid) throws SmackException.NotConnectedException, InterruptedException {
        if (isMyFriend(jid)) {
            XMPPConnection xMPPConnectionConnection = connection();
            xMPPConnectionConnection.sendStanza(((PresenceBuilder) xMPPConnectionConnection.getStanzaFactory().buildPresenceStanza().ofType(Presence.Type.unsubscribed).to(jid)).build());
        }
    }

    public boolean addBecameFriendListener(BecameFriendListener becameFriendListener) {
        return this.becameFriendListeners.add(becameFriendListener);
    }

    public boolean removeBecameFriendListener(BecameFriendListener becameFriendListener) {
        return this.becameFriendListeners.remove(becameFriendListener);
    }

    public boolean addWasUnfriendedListener(WasUnfriendedListener wasUnfriendedListener) {
        return this.wasUnfriendedListeners.add(wasUnfriendedListener);
    }

    public boolean removeWasUnfriendedListener(WasUnfriendedListener wasUnfriendedListener) {
        return this.wasUnfriendedListeners.remove(wasUnfriendedListener);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public boolean isFromProvisioningService(Stanza stanza, boolean z) {
        try {
            Jid configuredProvisioningServer = getConfiguredProvisioningServer();
            if (configuredProvisioningServer == null) {
                if (z) {
                    LOGGER.warning("Ignoring request '" + stanza + "' because no provisioning server configured.");
                }
                return false;
            }
            if (configuredProvisioningServer.equals((CharSequence) stanza.getFrom())) {
                return true;
            }
            if (z) {
                LOGGER.warning("Ignoring  request '" + stanza + "' because not from provisioning server '" + ((Object) configuredProvisioningServer) + "'.");
            }
            return false;
        } catch (InterruptedException | SmackException.NoResponseException | SmackException.NotConnectedException | XMPPException.XMPPErrorException e2) {
            LOGGER.log(Level.WARNING, "Could determine provisioning server", e2);
            return false;
        }
    }
}
