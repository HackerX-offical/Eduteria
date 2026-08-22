package org.jivesoftware.smackx.muc;

import java.lang.ref.WeakReference;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.WeakHashMap;
import java.util.concurrent.CopyOnWriteArrayList;
import java.util.concurrent.CopyOnWriteArraySet;
import java.util.logging.Level;
import java.util.logging.Logger;
import org.jivesoftware.smack.ConnectionCreationListener;
import org.jivesoftware.smack.ConnectionListener;
import org.jivesoftware.smack.Manager;
import org.jivesoftware.smack.SmackException;
import org.jivesoftware.smack.StanzaListener;
import org.jivesoftware.smack.XMPPConnection;
import org.jivesoftware.smack.XMPPConnectionRegistry;
import org.jivesoftware.smack.XMPPException;
import org.jivesoftware.smack.filter.AndFilter;
import org.jivesoftware.smack.filter.MessageTypeFilter;
import org.jivesoftware.smack.filter.NotFilter;
import org.jivesoftware.smack.filter.StanzaExtensionFilter;
import org.jivesoftware.smack.filter.StanzaFilter;
import org.jivesoftware.smack.filter.StanzaTypeFilter;
import org.jivesoftware.smack.packet.Message;
import org.jivesoftware.smack.packet.MessageBuilder;
import org.jivesoftware.smack.packet.Stanza;
import org.jivesoftware.smack.util.Async;
import org.jivesoftware.smack.util.CleaningWeakReferenceMap;
import org.jivesoftware.smackx.disco.AbstractNodeInformationProvider;
import org.jivesoftware.smackx.disco.ServiceDiscoveryManager;
import org.jivesoftware.smackx.disco.packet.DiscoverInfo;
import org.jivesoftware.smackx.disco.packet.DiscoverItems;
import org.jivesoftware.smackx.muc.MultiUserChatException;
import org.jivesoftware.smackx.muc.packet.MUCUser;
import org.jxmpp.jid.DomainBareJid;
import org.jxmpp.jid.EntityBareJid;
import org.jxmpp.jid.EntityFullJid;
import org.jxmpp.jid.EntityJid;
import org.jxmpp.jid.Jid;
import org.jxmpp.jid.parts.Resourcepart;
import org.jxmpp.util.cache.ExpirationCache;

/* JADX INFO: loaded from: classes10.dex */
public final class MultiUserChatManager extends Manager {
    static final /* synthetic */ boolean $assertionsDisabled = false;
    private static final Set<MucMessageInterceptor> DEFAULT_MESSAGE_INTERCEPTORS;
    private static final String DISCO_NODE = "http://jabber.org/protocol/muc#rooms";
    private static final Map<XMPPConnection, MultiUserChatManager> INSTANCES;
    private static final StanzaFilter INVITATION_FILTER;
    private static final ExpirationCache<DomainBareJid, DiscoverInfo> KNOWN_MUC_SERVICES;
    private static final Logger LOGGER = Logger.getLogger(MultiUserChatManager.class.getName());
    private AutoJoinFailedCallback autoJoinFailedCallback;
    private boolean autoJoinOnReconnect;
    private AutoJoinSuccessCallback autoJoinSuccessCallback;
    private final Set<InvitationListener> invitationsListeners;
    private final Set<EntityBareJid> joinedRooms;
    private final Map<EntityBareJid, WeakReference<MultiUserChat>> multiUserChats;
    private final ServiceDiscoveryManager serviceDiscoveryManager;

    static {
        XMPPConnectionRegistry.addConnectionCreationListener(new ConnectionCreationListener() { // from class: org.jivesoftware.smackx.muc.MultiUserChatManager.1
            @Override // org.jivesoftware.smack.ConnectionCreationListener
            public void connectionCreated(XMPPConnection xMPPConnection) {
                ServiceDiscoveryManager.getInstanceFor(xMPPConnection).addFeature("http://jabber.org/protocol/muc");
                final WeakReference weakReference = new WeakReference(xMPPConnection);
                ServiceDiscoveryManager.getInstanceFor(xMPPConnection).setNodeInformationProvider(MultiUserChatManager.DISCO_NODE, new AbstractNodeInformationProvider() { // from class: org.jivesoftware.smackx.muc.MultiUserChatManager.1.1
                    @Override // org.jivesoftware.smackx.disco.AbstractNodeInformationProvider, org.jivesoftware.smackx.disco.NodeInformationProvider
                    public List<DiscoverItems.Item> getNodeItems() {
                        XMPPConnection xMPPConnection2 = (XMPPConnection) weakReference.get();
                        if (xMPPConnection2 == null) {
                            return Collections.emptyList();
                        }
                        Set<EntityBareJid> joinedRooms = MultiUserChatManager.getInstanceFor(xMPPConnection2).getJoinedRooms();
                        ArrayList arrayList = new ArrayList();
                        Iterator<EntityBareJid> it = joinedRooms.iterator();
                        while (it.hasNext()) {
                            arrayList.add(new DiscoverItems.Item(it.next()));
                        }
                        return arrayList;
                    }
                });
            }
        });
        INSTANCES = new WeakHashMap();
        INVITATION_FILTER = new AndFilter(StanzaTypeFilter.MESSAGE, new StanzaExtensionFilter(new MUCUser()), new NotFilter(MessageTypeFilter.ERROR));
        KNOWN_MUC_SERVICES = new ExpirationCache<>(100, 86400000L);
        DEFAULT_MESSAGE_INTERCEPTORS = new HashSet();
    }

    public static synchronized MultiUserChatManager getInstanceFor(XMPPConnection xMPPConnection) {
        MultiUserChatManager multiUserChatManager;
        Map<XMPPConnection, MultiUserChatManager> map = INSTANCES;
        multiUserChatManager = map.get(xMPPConnection);
        if (multiUserChatManager == null) {
            multiUserChatManager = new MultiUserChatManager(xMPPConnection);
            map.put(xMPPConnection, multiUserChatManager);
        }
        return multiUserChatManager;
    }

    private MultiUserChatManager(XMPPConnection xMPPConnection) {
        super(xMPPConnection);
        this.invitationsListeners = new CopyOnWriteArraySet();
        this.joinedRooms = new CopyOnWriteArraySet();
        this.multiUserChats = new CleaningWeakReferenceMap();
        this.serviceDiscoveryManager = ServiceDiscoveryManager.getInstanceFor(xMPPConnection);
        xMPPConnection.addAsyncStanzaListener(new StanzaListener() { // from class: org.jivesoftware.smackx.muc.MultiUserChatManager.2
            @Override // org.jivesoftware.smack.StanzaListener
            public void processStanza(Stanza stanza) {
                Message message = (Message) stanza;
                MUCUser mUCUserFrom = MUCUser.from(message);
                if (mUCUserFrom.getInvite() != null) {
                    EntityBareJid entityBareJidAsEntityBareJidIfPossible = message.getFrom().asEntityBareJidIfPossible();
                    if (entityBareJidAsEntityBareJidIfPossible == null) {
                        MultiUserChatManager.LOGGER.warning("Invite to non bare JID: '" + ((Object) message.toXML()) + "'");
                        return;
                    }
                    MultiUserChat multiUserChat = MultiUserChatManager.this.getMultiUserChat(entityBareJidAsEntityBareJidIfPossible);
                    XMPPConnection xMPPConnectionConnection = MultiUserChatManager.this.connection();
                    MUCUser.Invite invite = mUCUserFrom.getInvite();
                    EntityJid from = invite.getFrom();
                    String reason = invite.getReason();
                    String password = mUCUserFrom.getPassword();
                    Iterator it = MultiUserChatManager.this.invitationsListeners.iterator();
                    while (it.hasNext()) {
                        ((InvitationListener) it.next()).invitationReceived(xMPPConnectionConnection, multiUserChat, from, reason, password, message, invite);
                    }
                }
            }
        }, INVITATION_FILTER);
        xMPPConnection.addConnectionListener(new ConnectionListener() { // from class: org.jivesoftware.smackx.muc.MultiUserChatManager.3
            @Override // org.jivesoftware.smack.ConnectionListener
            public void authenticated(XMPPConnection xMPPConnection2, boolean z) {
                if (!z && MultiUserChatManager.this.autoJoinOnReconnect) {
                    final Set<EntityBareJid> joinedRooms = MultiUserChatManager.this.getJoinedRooms();
                    if (joinedRooms.isEmpty()) {
                        return;
                    }
                    Async.go(new Runnable() { // from class: org.jivesoftware.smackx.muc.MultiUserChatManager.3.1
                        @Override // java.lang.Runnable
                        public void run() {
                            Resourcepart nickname;
                            AutoJoinFailedCallback autoJoinFailedCallback = MultiUserChatManager.this.autoJoinFailedCallback;
                            AutoJoinSuccessCallback autoJoinSuccessCallback = MultiUserChatManager.this.autoJoinSuccessCallback;
                            Iterator it = joinedRooms.iterator();
                            while (it.hasNext()) {
                                MultiUserChat multiUserChat = MultiUserChatManager.this.getMultiUserChat((EntityBareJid) it.next());
                                if (!multiUserChat.isJoined() || (nickname = multiUserChat.getNickname()) == null) {
                                    return;
                                }
                                try {
                                    multiUserChat.leave();
                                    try {
                                        multiUserChat.join(nickname);
                                        if (autoJoinSuccessCallback != null) {
                                            autoJoinSuccessCallback.autoJoinSuccess(multiUserChat, nickname);
                                        }
                                    } catch (InterruptedException | SmackException.NoResponseException | SmackException.NotConnectedException | XMPPException.XMPPErrorException | MultiUserChatException.NotAMucServiceException e2) {
                                        if (autoJoinFailedCallback == null) {
                                            MultiUserChatManager.LOGGER.log(Level.WARNING, "Could not leave room", (Throwable) e2);
                                            return;
                                        } else {
                                            autoJoinFailedCallback.autoJoinFailed(multiUserChat, e2);
                                            return;
                                        }
                                    }
                                } catch (InterruptedException | SmackException.NoResponseException | SmackException.NotConnectedException | XMPPException.XMPPErrorException | MultiUserChatException.MucNotJoinedException e3) {
                                    if (autoJoinFailedCallback == null) {
                                        MultiUserChatManager.LOGGER.log(Level.WARNING, "Could not leave room", (Throwable) e3);
                                        return;
                                    } else {
                                        autoJoinFailedCallback.autoJoinFailed(multiUserChat, e3);
                                        return;
                                    }
                                }
                            }
                        }
                    });
                }
            }
        });
    }

    public synchronized MultiUserChat getMultiUserChat(EntityBareJid entityBareJid) {
        WeakReference<MultiUserChat> weakReference = this.multiUserChats.get(entityBareJid);
        if (weakReference == null) {
            return createNewMucAndAddToMap(entityBareJid);
        }
        MultiUserChat multiUserChat = weakReference.get();
        if (multiUserChat != null) {
            return multiUserChat;
        }
        return createNewMucAndAddToMap(entityBareJid);
    }

    public static boolean addDefaultMessageInterceptor(MucMessageInterceptor mucMessageInterceptor) {
        boolean zAdd;
        Set<MucMessageInterceptor> set = DEFAULT_MESSAGE_INTERCEPTORS;
        synchronized (set) {
            zAdd = set.add(mucMessageInterceptor);
        }
        return zAdd;
    }

    public static boolean removeDefaultMessageInterceptor(MucMessageInterceptor mucMessageInterceptor) {
        boolean zRemove;
        Set<MucMessageInterceptor> set = DEFAULT_MESSAGE_INTERCEPTORS;
        synchronized (set) {
            zRemove = set.remove(mucMessageInterceptor);
        }
        return zRemove;
    }

    private MultiUserChat createNewMucAndAddToMap(EntityBareJid entityBareJid) {
        MultiUserChat multiUserChat = new MultiUserChat(connection(), entityBareJid, this);
        this.multiUserChats.put(entityBareJid, new WeakReference<>(multiUserChat));
        return multiUserChat;
    }

    public boolean isServiceEnabled(Jid jid) throws SmackException.NotConnectedException, SmackException.NoResponseException, InterruptedException, XMPPException.XMPPErrorException {
        return this.serviceDiscoveryManager.supportsFeature(jid, "http://jabber.org/protocol/muc");
    }

    public Set<EntityBareJid> getJoinedRooms() {
        return Collections.unmodifiableSet(this.joinedRooms);
    }

    public List<EntityBareJid> getJoinedRooms(EntityFullJid entityFullJid) throws SmackException.NotConnectedException, SmackException.NoResponseException, InterruptedException, XMPPException.XMPPErrorException {
        List<DiscoverItems.Item> items = this.serviceDiscoveryManager.discoverItems(entityFullJid, DISCO_NODE).getItems();
        ArrayList arrayList = new ArrayList(items.size());
        for (DiscoverItems.Item item : items) {
            EntityBareJid entityBareJidAsEntityBareJidIfPossible = item.getEntityID().asEntityBareJidIfPossible();
            if (entityBareJidAsEntityBareJidIfPossible == null) {
                LOGGER.warning("Not a bare JID: " + ((Object) item.getEntityID()));
            } else {
                arrayList.add(entityBareJidAsEntityBareJidIfPossible);
            }
        }
        return arrayList;
    }

    public RoomInfo getRoomInfo(EntityBareJid entityBareJid) throws SmackException.NotConnectedException, SmackException.NoResponseException, InterruptedException, XMPPException.XMPPErrorException {
        return new RoomInfo(this.serviceDiscoveryManager.discoverInfo(entityBareJid));
    }

    public List<DomainBareJid> getMucServiceDomains() throws SmackException.NotConnectedException, SmackException.NoResponseException, InterruptedException, XMPPException.XMPPErrorException {
        return this.serviceDiscoveryManager.findServices("http://jabber.org/protocol/muc", false, false);
    }

    @Deprecated
    public List<DomainBareJid> getXMPPServiceDomains() throws SmackException.NotConnectedException, SmackException.NoResponseException, InterruptedException, XMPPException.XMPPErrorException {
        return getMucServiceDomains();
    }

    public boolean providesMucService(DomainBareJid domainBareJid) throws SmackException.NotConnectedException, SmackException.NoResponseException, InterruptedException, XMPPException.XMPPErrorException {
        return getMucServiceDiscoInfo(domainBareJid) != null;
    }

    DiscoverInfo getMucServiceDiscoInfo(DomainBareJid domainBareJid) throws SmackException.NotConnectedException, SmackException.NoResponseException, InterruptedException, XMPPException.XMPPErrorException {
        ExpirationCache<DomainBareJid, DiscoverInfo> expirationCache = KNOWN_MUC_SERVICES;
        DiscoverInfo discoverInfo = expirationCache.get(domainBareJid);
        if (discoverInfo != null) {
            return discoverInfo;
        }
        DiscoverInfo discoverInfo2 = this.serviceDiscoveryManager.discoverInfo(domainBareJid);
        if (!discoverInfo2.containsFeature("http://jabber.org/protocol/muc")) {
            return null;
        }
        expirationCache.put(domainBareJid, discoverInfo2);
        return discoverInfo2;
    }

    public Map<EntityBareJid, HostedRoom> getRoomsHostedBy(DomainBareJid domainBareJid) throws SmackException.NotConnectedException, SmackException.NoResponseException, MultiUserChatException.NotAMucServiceException, InterruptedException, XMPPException.XMPPErrorException {
        if (!providesMucService(domainBareJid)) {
            throw new MultiUserChatException.NotAMucServiceException(domainBareJid);
        }
        List<DiscoverItems.Item> items = this.serviceDiscoveryManager.discoverItems(domainBareJid).getItems();
        HashMap map = new HashMap(items.size());
        Iterator<DiscoverItems.Item> it = items.iterator();
        while (it.hasNext()) {
            HostedRoom hostedRoom = new HostedRoom(it.next());
        }
        return map;
    }

    /* JADX WARN: Multi-variable type inference failed */
    public void decline(EntityBareJid entityBareJid, EntityBareJid entityBareJid2, String str) throws SmackException.NotConnectedException, InterruptedException {
        XMPPConnection xMPPConnectionConnection = connection();
        MessageBuilder messageBuilder = (MessageBuilder) xMPPConnectionConnection.getStanzaFactory().buildMessageStanza().to((Jid) entityBareJid);
        MUCUser mUCUser = new MUCUser();
        mUCUser.setDecline(new MUCUser.Decline(str, entityBareJid2));
        messageBuilder.addExtension(mUCUser);
        xMPPConnectionConnection.sendStanza(messageBuilder.build());
    }

    public void addInvitationListener(InvitationListener invitationListener) {
        this.invitationsListeners.add(invitationListener);
    }

    public void removeInvitationListener(InvitationListener invitationListener) {
        this.invitationsListeners.remove(invitationListener);
    }

    public void setAutoJoinOnReconnect(boolean z) {
        this.autoJoinOnReconnect = z;
    }

    public void setAutoJoinFailedCallback(AutoJoinFailedCallback autoJoinFailedCallback) {
        this.autoJoinFailedCallback = autoJoinFailedCallback;
        if (autoJoinFailedCallback != null) {
            setAutoJoinOnReconnect(true);
        }
    }

    public void setAutoJoinSuccessCallback(AutoJoinSuccessCallback autoJoinSuccessCallback) {
        this.autoJoinSuccessCallback = autoJoinSuccessCallback;
        if (autoJoinSuccessCallback != null) {
            setAutoJoinOnReconnect(true);
        }
    }

    void addJoinedRoom(EntityBareJid entityBareJid) {
        this.joinedRooms.add(entityBareJid);
    }

    void removeJoinedRoom(EntityBareJid entityBareJid) {
        this.joinedRooms.remove(entityBareJid);
    }

    static CopyOnWriteArrayList<MucMessageInterceptor> getMessageInterceptors() {
        CopyOnWriteArrayList<MucMessageInterceptor> copyOnWriteArrayList;
        Set<MucMessageInterceptor> set = DEFAULT_MESSAGE_INTERCEPTORS;
        synchronized (set) {
            copyOnWriteArrayList = new CopyOnWriteArrayList<>(set);
        }
        return copyOnWriteArrayList;
    }
}
