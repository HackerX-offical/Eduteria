package org.jivesoftware.smack.roster;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.Collections;
import java.util.HashSet;
import java.util.Iterator;
import java.util.LinkedHashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.WeakHashMap;
import java.util.concurrent.ConcurrentHashMap;
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
import org.jivesoftware.smack.filter.PresenceTypeFilter;
import org.jivesoftware.smack.filter.StanzaFilter;
import org.jivesoftware.smack.filter.StanzaTypeFilter;
import org.jivesoftware.smack.filter.ToMatchesFilter;
import org.jivesoftware.smack.iqrequest.AbstractIqRequestHandler;
import org.jivesoftware.smack.iqrequest.IQRequestHandler;
import org.jivesoftware.smack.packet.IQ;
import org.jivesoftware.smack.packet.Presence;
import org.jivesoftware.smack.packet.PresenceBuilder;
import org.jivesoftware.smack.packet.Stanza;
import org.jivesoftware.smack.packet.StanzaBuilder;
import org.jivesoftware.smack.packet.StanzaError;
import org.jivesoftware.smack.roster.SubscribeListener;
import org.jivesoftware.smack.roster.packet.RosterPacket;
import org.jivesoftware.smack.roster.packet.RosterVer;
import org.jivesoftware.smack.roster.packet.SubscriptionPreApproval;
import org.jivesoftware.smack.roster.rosterstore.RosterStore;
import org.jivesoftware.smack.util.ExceptionCallback;
import org.jivesoftware.smack.util.Objects;
import org.jivesoftware.smack.util.SuccessCallback;
import org.jxmpp.jid.BareJid;
import org.jxmpp.jid.EntityBareJid;
import org.jxmpp.jid.EntityFullJid;
import org.jxmpp.jid.FullJid;
import org.jxmpp.jid.Jid;
import org.jxmpp.jid.impl.JidCreate;
import org.jxmpp.jid.parts.Resourcepart;
import org.jxmpp.util.cache.LruCache;

/* JADX INFO: loaded from: classes10.dex */
public final class Roster extends Manager {
    public static final int INITIAL_DEFAULT_NON_ROSTER_PRESENCE_MAP_SIZE = 1024;
    private static final Map<XMPPConnection, Roster> INSTANCES;
    private static final Logger LOGGER = Logger.getLogger(Roster.class.getName());
    private static final StanzaFilter OUTGOING_USER_UNAVAILABLE_PRESENCE;
    private static final StanzaFilter PRESENCE_PACKET_FILTER;
    private static int defaultNonRosterPresenceMapMaxSize;
    private static SubscriptionMode defaultSubscriptionMode;
    private static boolean rosterLoadedAtLoginDefault;
    private final AsyncButOrdered<BareJid> asyncButOrdered;
    private final Map<BareJid, RosterEntry> entries;
    private final Map<String, RosterGroup> groups;
    private final LruCache<BareJid, Map<Resourcepart, Presence>> nonRosterPresenceMap;
    private final Set<PresenceEventListener> presenceEventListeners;
    private final Map<BareJid, Map<Resourcepart, Presence>> presenceMap;
    private final PresencePacketListener presencePacketListener;
    private SubscriptionMode previousSubscriptionMode;
    private final Set<RosterListener> rosterListeners;
    private final Object rosterListenersAndEntriesLock;
    private boolean rosterLoadedAtLogin;
    private final Set<RosterLoadedListener> rosterLoadedListeners;
    private RosterState rosterState;
    private RosterStore rosterStore;
    private final Set<SubscribeListener> subscribeListeners;
    private SubscriptionMode subscriptionMode;
    private final Set<RosterEntry> unfiledEntries;

    private enum RosterState {
        uninitialized,
        loading,
        loaded
    }

    public enum SubscriptionMode {
        accept_all,
        reject_all,
        manual
    }

    static {
        XMPPConnectionRegistry.addConnectionCreationListener(new ConnectionCreationListener() { // from class: org.jivesoftware.smack.roster.Roster.1
            @Override // org.jivesoftware.smack.ConnectionCreationListener
            public void connectionCreated(XMPPConnection xMPPConnection) {
                Roster.getInstanceFor(xMPPConnection);
            }
        });
        INSTANCES = new WeakHashMap();
        PRESENCE_PACKET_FILTER = StanzaTypeFilter.PRESENCE;
        OUTGOING_USER_UNAVAILABLE_PRESENCE = new AndFilter(PresenceTypeFilter.UNAVAILABLE, ToMatchesFilter.MATCH_NO_TO_SET);
        rosterLoadedAtLoginDefault = true;
        defaultSubscriptionMode = SubscriptionMode.reject_all;
        defaultNonRosterPresenceMapMaxSize = 1024;
    }

    public static synchronized Roster getInstanceFor(XMPPConnection xMPPConnection) {
        Roster roster;
        Map<XMPPConnection, Roster> map = INSTANCES;
        roster = map.get(xMPPConnection);
        if (roster == null) {
            roster = new Roster(xMPPConnection);
            map.put(xMPPConnection, roster);
        }
        return roster;
    }

    public static SubscriptionMode getDefaultSubscriptionMode() {
        return defaultSubscriptionMode;
    }

    public static void setDefaultSubscriptionMode(SubscriptionMode subscriptionMode) {
        defaultSubscriptionMode = subscriptionMode;
    }

    private Roster(final XMPPConnection xMPPConnection) {
        super(xMPPConnection);
        this.groups = new ConcurrentHashMap();
        this.entries = new ConcurrentHashMap();
        this.unfiledEntries = new CopyOnWriteArraySet();
        this.rosterListeners = new LinkedHashSet();
        this.presenceEventListeners = new CopyOnWriteArraySet();
        this.presenceMap = new ConcurrentHashMap();
        this.nonRosterPresenceMap = new LruCache<>(defaultNonRosterPresenceMapMaxSize);
        this.rosterLoadedListeners = new LinkedHashSet();
        this.rosterListenersAndEntriesLock = new Object();
        this.rosterState = RosterState.uninitialized;
        PresencePacketListener presencePacketListener = new PresencePacketListener();
        this.presencePacketListener = presencePacketListener;
        this.rosterLoadedAtLogin = rosterLoadedAtLoginDefault;
        this.subscriptionMode = getDefaultSubscriptionMode();
        this.subscribeListeners = new CopyOnWriteArraySet();
        this.asyncButOrdered = new AsyncButOrdered<>();
        xMPPConnection.registerIQRequestHandler(new RosterPushListener());
        xMPPConnection.addSyncStanzaListener(presencePacketListener, PRESENCE_PACKET_FILTER);
        xMPPConnection.addAsyncStanzaListener(new StanzaListener() { // from class: org.jivesoftware.smack.roster.Roster.2
            /* JADX WARN: Multi-variable type inference failed */
            @Override // org.jivesoftware.smack.StanzaListener
            public void processStanza(Stanza stanza) throws SmackException.NotConnectedException, InterruptedException, SmackException.NotLoggedInException {
                Presence.Type type;
                Presence presence = (Presence) stanza;
                Jid from = presence.getFrom();
                int i = AnonymousClass6.$SwitchMap$org$jivesoftware$smack$roster$Roster$SubscriptionMode[Roster.this.subscriptionMode.ordinal()];
                SubscribeListener.SubscribeAnswer subscribeAnswerProcessSubscribe = null;
                if (i == 1) {
                    Iterator it = Roster.this.subscribeListeners.iterator();
                    while (it.hasNext() && (subscribeAnswerProcessSubscribe = ((SubscribeListener) it.next()).processSubscribe(from, presence)) == null) {
                    }
                    if (subscribeAnswerProcessSubscribe == null) {
                        return;
                    }
                } else if (i == 2) {
                    subscribeAnswerProcessSubscribe = SubscribeListener.SubscribeAnswer.Approve;
                } else if (i == 3) {
                    subscribeAnswerProcessSubscribe = SubscribeListener.SubscribeAnswer.Deny;
                }
                if (subscribeAnswerProcessSubscribe == null) {
                    return;
                }
                int i2 = AnonymousClass6.$SwitchMap$org$jivesoftware$smack$roster$SubscribeListener$SubscribeAnswer[subscribeAnswerProcessSubscribe.ordinal()];
                if (i2 == 1) {
                    RosterUtil.askForSubscriptionIfRequired(Roster.this, from.asBareJid());
                } else {
                    if (i2 != 2) {
                        if (i2 == 3) {
                            type = Presence.Type.unsubscribed;
                        } else {
                            throw new AssertionError();
                        }
                    }
                    xMPPConnection.sendStanza(((PresenceBuilder) xMPPConnection.getStanzaFactory().buildPresenceStanza().ofType(type).to(presence.getFrom())).build());
                }
                type = Presence.Type.subscribed;
                xMPPConnection.sendStanza(((PresenceBuilder) xMPPConnection.getStanzaFactory().buildPresenceStanza().ofType(type).to(presence.getFrom())).build());
            }
        }, PresenceTypeFilter.SUBSCRIBE);
        xMPPConnection.addConnectionListener(new ConnectionListener() { // from class: org.jivesoftware.smack.roster.Roster.3
            @Override // org.jivesoftware.smack.ConnectionListener
            public void authenticated(XMPPConnection xMPPConnection2, boolean z) {
                if (Roster.this.isRosterLoadedAtLogin() && !z) {
                    Roster.this.setOfflinePresencesAndResetLoaded();
                    try {
                        Roster.this.reload();
                    } catch (InterruptedException | SmackException e2) {
                        Roster.LOGGER.log(Level.SEVERE, "Could not reload Roster", e2);
                    }
                }
            }

            @Override // org.jivesoftware.smack.ConnectionListener
            public void connectionClosed() {
                Roster.this.setOfflinePresencesAndResetLoaded();
            }
        });
        xMPPConnection.addStanzaSendingListener(new StanzaListener() { // from class: org.jivesoftware.smack.roster.Roster.4
            @Override // org.jivesoftware.smack.StanzaListener
            public void processStanza(Stanza stanza) throws SmackException.NotConnectedException, InterruptedException {
                Roster.this.setOfflinePresences();
            }
        }, OUTGOING_USER_UNAVAILABLE_PRESENCE);
        if (xMPPConnection.isAuthenticated()) {
            try {
                reloadAndWait();
            } catch (InterruptedException | SmackException e2) {
                LOGGER.log(Level.SEVERE, "Could not reload Roster", e2);
            }
        }
    }

    private Map<Resourcepart, Presence> getPresencesInternal(BareJid bareJid) {
        Map<Resourcepart, Presence> map = this.presenceMap.get(bareJid);
        return map == null ? this.nonRosterPresenceMap.lookup(bareJid) : map;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public synchronized Map<Resourcepart, Presence> getOrCreatePresencesInternal(BareJid bareJid) {
        Map<Resourcepart, Presence> presencesInternal;
        presencesInternal = getPresencesInternal(bareJid);
        if (presencesInternal == null) {
            if (contains(bareJid)) {
                presencesInternal = new ConcurrentHashMap<>();
                this.presenceMap.put(bareJid, presencesInternal);
            } else {
                presencesInternal = new LruCache<>(32);
                this.nonRosterPresenceMap.put(bareJid, presencesInternal);
            }
        }
        return presencesInternal;
    }

    public SubscriptionMode getSubscriptionMode() {
        return this.subscriptionMode;
    }

    public void setSubscriptionMode(SubscriptionMode subscriptionMode) {
        this.subscriptionMode = subscriptionMode;
    }

    public void reload() throws SmackException.NotConnectedException, InterruptedException, SmackException.NotLoggedInException {
        XMPPConnection authenticatedConnectionOrThrow = getAuthenticatedConnectionOrThrow();
        RosterPacket rosterPacket = new RosterPacket();
        if (this.rosterStore != null && isRosterVersioningSupported()) {
            rosterPacket.setVersion(this.rosterStore.getRosterVersion());
        }
        this.rosterState = RosterState.loading;
        authenticatedConnectionOrThrow.sendIqRequestAsync(rosterPacket).onSuccess(new RosterResultListener()).onError(new ExceptionCallback<Exception>() { // from class: org.jivesoftware.smack.roster.Roster.5
            @Override // org.jivesoftware.smack.util.ExceptionCallback
            public void processException(Exception exc) {
                Level level;
                Roster.this.rosterState = RosterState.uninitialized;
                if (exc instanceof SmackException.NotConnectedException) {
                    level = Level.FINE;
                } else {
                    level = Level.SEVERE;
                }
                Roster.LOGGER.log(level, "Exception reloading roster", (Throwable) exc);
                Iterator it = Roster.this.rosterLoadedListeners.iterator();
                while (it.hasNext()) {
                    ((RosterLoadedListener) it.next()).onRosterLoadingFailed(exc);
                }
            }
        });
    }

    public void reloadAndWait() throws SmackException.NotConnectedException, InterruptedException, SmackException.NotLoggedInException {
        reload();
        waitUntilLoaded();
    }

    public boolean setRosterStore(RosterStore rosterStore) {
        this.rosterStore = rosterStore;
        try {
            reload();
            return true;
        } catch (InterruptedException | SmackException.NotConnectedException | SmackException.NotLoggedInException e2) {
            LOGGER.log(Level.FINER, "Could not reload roster", e2);
            return false;
        }
    }

    protected boolean waitUntilLoaded() throws InterruptedException {
        long replyTimeout = connection().getReplyTimeout();
        long jCurrentTimeMillis = System.currentTimeMillis();
        while (!isLoaded() && replyTimeout > 0) {
            synchronized (this) {
                if (!isLoaded()) {
                    wait(replyTimeout);
                }
            }
            long jCurrentTimeMillis2 = System.currentTimeMillis();
            replyTimeout -= jCurrentTimeMillis2 - jCurrentTimeMillis;
            jCurrentTimeMillis = jCurrentTimeMillis2;
        }
        return isLoaded();
    }

    public boolean isLoaded() {
        return this.rosterState == RosterState.loaded;
    }

    public boolean addRosterListener(RosterListener rosterListener) {
        boolean zAdd;
        synchronized (this.rosterListenersAndEntriesLock) {
            zAdd = this.rosterListeners.add(rosterListener);
        }
        return zAdd;
    }

    public boolean removeRosterListener(RosterListener rosterListener) {
        boolean zRemove;
        synchronized (this.rosterListenersAndEntriesLock) {
            zRemove = this.rosterListeners.remove(rosterListener);
        }
        return zRemove;
    }

    public boolean addRosterLoadedListener(RosterLoadedListener rosterLoadedListener) {
        boolean zAdd;
        synchronized (rosterLoadedListener) {
            zAdd = this.rosterLoadedListeners.add(rosterLoadedListener);
        }
        return zAdd;
    }

    public boolean removeRosterLoadedListener(RosterLoadedListener rosterLoadedListener) {
        boolean zRemove;
        synchronized (rosterLoadedListener) {
            zRemove = this.rosterLoadedListeners.remove(rosterLoadedListener);
        }
        return zRemove;
    }

    public boolean addPresenceEventListener(PresenceEventListener presenceEventListener) {
        return this.presenceEventListeners.add(presenceEventListener);
    }

    public boolean removePresenceEventListener(PresenceEventListener presenceEventListener) {
        return this.presenceEventListeners.remove(presenceEventListener);
    }

    public RosterGroup createGroup(String str) {
        XMPPConnection xMPPConnectionConnection = connection();
        if (this.groups.containsKey(str)) {
            return this.groups.get(str);
        }
        RosterGroup rosterGroup = new RosterGroup(str, xMPPConnectionConnection);
        this.groups.put(str, rosterGroup);
        return rosterGroup;
    }

    @Deprecated
    public void createEntry(BareJid bareJid, String str, String[] strArr) throws SmackException.NotConnectedException, SmackException.NoResponseException, InterruptedException, XMPPException.XMPPErrorException, SmackException.NotLoggedInException {
        createItemAndRequestSubscription(bareJid, str, strArr);
    }

    public void createItem(BareJid bareJid, String str, String[] strArr) throws SmackException.NotConnectedException, SmackException.NoResponseException, InterruptedException, XMPPException.XMPPErrorException, SmackException.NotLoggedInException {
        XMPPConnection authenticatedConnectionOrThrow = getAuthenticatedConnectionOrThrow();
        RosterPacket rosterPacket = new RosterPacket();
        rosterPacket.setType(IQ.Type.set);
        RosterPacket.Item item = new RosterPacket.Item(bareJid, str);
        if (strArr != null) {
            for (String str2 : strArr) {
                if (str2 != null && str2.trim().length() > 0) {
                    item.addGroupName(str2);
                }
            }
        }
        rosterPacket.addRosterItem(item);
        authenticatedConnectionOrThrow.createStanzaCollectorAndSend(rosterPacket).nextResultOrThrow();
    }

    public void createItemAndRequestSubscription(BareJid bareJid, String str, String[] strArr) throws SmackException.NotConnectedException, SmackException.NoResponseException, InterruptedException, XMPPException.XMPPErrorException, SmackException.NotLoggedInException {
        createItem(bareJid, str, strArr);
        sendSubscriptionRequest(bareJid);
    }

    public void preApproveAndCreateEntry(BareJid bareJid, String str, String[] strArr) throws SmackException.NotConnectedException, SmackException.FeatureNotSupportedException, SmackException.NoResponseException, InterruptedException, XMPPException.XMPPErrorException, SmackException.NotLoggedInException {
        preApprove(bareJid);
        createItemAndRequestSubscription(bareJid, str, strArr);
    }

    /* JADX WARN: Multi-variable type inference failed */
    public void preApprove(BareJid bareJid) throws SmackException.NotConnectedException, SmackException.FeatureNotSupportedException, InterruptedException, SmackException.NotLoggedInException {
        XMPPConnection xMPPConnectionConnection = connection();
        if (!isSubscriptionPreApprovalSupported()) {
            throw new SmackException.FeatureNotSupportedException("Pre-approving");
        }
        xMPPConnectionConnection.sendStanza(((PresenceBuilder) xMPPConnectionConnection.getStanzaFactory().buildPresenceStanza().ofType(Presence.Type.subscribed).to((Jid) bareJid)).build());
    }

    public boolean isSubscriptionPreApprovalSupported() throws SmackException.NotLoggedInException {
        return getAuthenticatedConnectionOrThrow().hasFeature("sub", SubscriptionPreApproval.NAMESPACE);
    }

    /* JADX WARN: Multi-variable type inference failed */
    public void sendSubscriptionRequest(BareJid bareJid) throws SmackException.NotConnectedException, InterruptedException, SmackException.NotLoggedInException {
        XMPPConnection authenticatedConnectionOrThrow = getAuthenticatedConnectionOrThrow();
        authenticatedConnectionOrThrow.sendStanza(((PresenceBuilder) authenticatedConnectionOrThrow.getStanzaFactory().buildPresenceStanza().ofType(Presence.Type.subscribe).to((Jid) bareJid)).build());
    }

    public boolean addSubscribeListener(SubscribeListener subscribeListener) {
        Objects.requireNonNull(subscribeListener, "SubscribeListener argument must not be null");
        if (this.subscriptionMode != SubscriptionMode.manual) {
            this.previousSubscriptionMode = this.subscriptionMode;
            this.subscriptionMode = SubscriptionMode.manual;
        }
        return this.subscribeListeners.add(subscribeListener);
    }

    public boolean removeSubscribeListener(SubscribeListener subscribeListener) {
        boolean zRemove = this.subscribeListeners.remove(subscribeListener);
        if (zRemove && this.subscribeListeners.isEmpty()) {
            setSubscriptionMode(this.previousSubscriptionMode);
        }
        return zRemove;
    }

    public void removeEntry(RosterEntry rosterEntry) throws SmackException.NotConnectedException, SmackException.NoResponseException, InterruptedException, XMPPException.XMPPErrorException, SmackException.NotLoggedInException {
        XMPPConnection authenticatedConnectionOrThrow = getAuthenticatedConnectionOrThrow();
        if (this.entries.containsKey(rosterEntry.getJid())) {
            RosterPacket rosterPacket = new RosterPacket();
            rosterPacket.setType(IQ.Type.set);
            RosterPacket.Item rosterItem = RosterEntry.toRosterItem(rosterEntry);
            rosterItem.setItemType(RosterPacket.ItemType.remove);
            rosterPacket.addRosterItem(rosterItem);
            authenticatedConnectionOrThrow.createStanzaCollectorAndSend(rosterPacket).nextResultOrThrow();
        }
    }

    public int getEntryCount() {
        return getEntries().size();
    }

    public void getEntriesAndAddListener(RosterListener rosterListener, RosterEntries rosterEntries) {
        Objects.requireNonNull(rosterListener, "listener must not be null");
        Objects.requireNonNull(rosterEntries, "rosterEntries must not be null");
        synchronized (this.rosterListenersAndEntriesLock) {
            rosterEntries.rosterEntries(this.entries.values());
            addRosterListener(rosterListener);
        }
    }

    public Set<RosterEntry> getEntries() {
        HashSet hashSet;
        synchronized (this.rosterListenersAndEntriesLock) {
            hashSet = new HashSet(this.entries.size());
            Iterator<RosterEntry> it = this.entries.values().iterator();
            while (it.hasNext()) {
                hashSet.add(it.next());
            }
        }
        return hashSet;
    }

    public int getUnfiledEntryCount() {
        return this.unfiledEntries.size();
    }

    public Set<RosterEntry> getUnfiledEntries() {
        return Collections.unmodifiableSet(this.unfiledEntries);
    }

    public RosterEntry getEntry(BareJid bareJid) {
        if (bareJid == null) {
            return null;
        }
        return this.entries.get(bareJid);
    }

    public boolean contains(BareJid bareJid) {
        return getEntry(bareJid) != null;
    }

    public RosterGroup getGroup(String str) {
        return this.groups.get(str);
    }

    public int getGroupCount() {
        return this.groups.size();
    }

    public Collection<RosterGroup> getGroups() {
        return Collections.unmodifiableCollection(this.groups.values());
    }

    public Presence getPresence(BareJid bareJid) {
        Map<Resourcepart, Presence> presencesInternal = getPresencesInternal(bareJid);
        if (presencesInternal == null) {
            return synthesizeUnvailablePresence(bareJid);
        }
        Presence presence = null;
        Presence presence2 = null;
        for (Presence presence3 : presencesInternal.values()) {
            if (presence3.isAvailable()) {
                if (presence != null && presence3.getPriority() <= presence.getPriority()) {
                    if (presence3.getPriority() == presence.getPriority()) {
                        Presence.Mode mode = presence3.getMode();
                        if (mode == null) {
                            mode = Presence.Mode.available;
                        }
                        Presence.Mode mode2 = presence.getMode();
                        if (mode2 == null) {
                            mode2 = Presence.Mode.available;
                        }
                        if (mode.compareTo(mode2) < 0) {
                        }
                    }
                }
                presence = presence3;
            } else {
                presence2 = presence3;
            }
        }
        return presence == null ? presence2 != null ? presence2 : synthesizeUnvailablePresence(bareJid) : presence;
    }

    public Presence getPresenceResource(FullJid fullJid) {
        BareJid bareJidAsBareJid = fullJid.asBareJid();
        Resourcepart resourcepart = fullJid.getResourcepart();
        Map<Resourcepart, Presence> presencesInternal = getPresencesInternal(bareJidAsBareJid);
        if (presencesInternal == null) {
            return synthesizeUnvailablePresence(fullJid);
        }
        Presence presence = presencesInternal.get(resourcepart);
        return presence == null ? synthesizeUnvailablePresence(fullJid) : presence;
    }

    public List<Presence> getAllPresences(BareJid bareJid) {
        Map<Resourcepart, Presence> presencesInternal = getPresencesInternal(bareJid);
        if (presencesInternal == null) {
            return new ArrayList(Arrays.asList(synthesizeUnvailablePresence(bareJid)));
        }
        ArrayList arrayList = new ArrayList(presencesInternal.values().size());
        Iterator<Presence> it = presencesInternal.values().iterator();
        while (it.hasNext()) {
            arrayList.add(it.next());
        }
        return arrayList;
    }

    public List<Presence> getAvailablePresences(BareJid bareJid) {
        List<Presence> allPresences = getAllPresences(bareJid);
        ArrayList arrayList = new ArrayList(allPresences.size());
        for (Presence presence : allPresences) {
            if (presence.isAvailable()) {
                arrayList.add(presence);
            }
        }
        return arrayList;
    }

    public List<Presence> getPresences(BareJid bareJid) {
        Map<Resourcepart, Presence> presencesInternal = getPresencesInternal(bareJid);
        if (presencesInternal == null) {
            return Arrays.asList(synthesizeUnvailablePresence(bareJid));
        }
        ArrayList arrayList = new ArrayList();
        Presence presence = null;
        for (Presence presence2 : presencesInternal.values()) {
            if (presence2.isAvailable()) {
                arrayList.add(presence2);
            } else {
                presence = presence2;
            }
        }
        return !arrayList.isEmpty() ? arrayList : presence != null ? Arrays.asList(presence) : Arrays.asList(synthesizeUnvailablePresence(bareJid));
    }

    public boolean isSubscribedToMyPresence(Jid jid) {
        if (jid == null) {
            return false;
        }
        BareJid bareJidAsBareJid = jid.asBareJid();
        if (connection().getXMPPServiceDomain().equals((CharSequence) bareJidAsBareJid)) {
            return true;
        }
        RosterEntry entry = getEntry(bareJidAsBareJid);
        if (entry == null) {
            return false;
        }
        return entry.canSeeMyPresence();
    }

    public boolean iAmSubscribedTo(Jid jid) {
        RosterEntry entry;
        if (jid == null || (entry = getEntry(jid.asBareJid())) == null) {
            return false;
        }
        return entry.canSeeHisPresence();
    }

    public static void setRosterLoadedAtLoginDefault(boolean z) {
        rosterLoadedAtLoginDefault = z;
    }

    public void setRosterLoadedAtLogin(boolean z) {
        this.rosterLoadedAtLogin = z;
    }

    public boolean isRosterLoadedAtLogin() {
        return this.rosterLoadedAtLogin;
    }

    RosterStore getRosterStore() {
        return this.rosterStore;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void setOfflinePresences() {
        for (BareJid bareJid : this.presenceMap.keySet()) {
            Map<Resourcepart, Presence> map = this.presenceMap.get(bareJid);
            if (map != null) {
                for (Resourcepart resourcepart : map.keySet()) {
                    PresenceBuilder presenceBuilderOfType = StanzaBuilder.buildPresence().ofType(Presence.Type.unavailable);
                    EntityBareJid entityBareJidAsEntityBareJidIfPossible = bareJid.asEntityBareJidIfPossible();
                    if (entityBareJidAsEntityBareJidIfPossible == null) {
                        LOGGER.warning("Can not transform user JID to bare JID: '" + ((Object) bareJid) + "'");
                    } else {
                        presenceBuilderOfType.from((Jid) JidCreate.fullFrom(entityBareJidAsEntityBareJidIfPossible, resourcepart));
                        try {
                            this.presencePacketListener.processStanza(presenceBuilderOfType.build());
                        } catch (InterruptedException unused) {
                            return;
                        } catch (SmackException.NotConnectedException e2) {
                            throw new IllegalStateException("presencePacketListener should never throw a NotConnectedException when processStanza is called with a presence of type unavailable", e2);
                        }
                    }
                }
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void setOfflinePresencesAndResetLoaded() {
        setOfflinePresences();
        this.rosterState = RosterState.uninitialized;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void fireRosterChangedEvent(Collection<Jid> collection, Collection<Jid> collection2, Collection<Jid> collection3) {
        synchronized (this.rosterListenersAndEntriesLock) {
            for (RosterListener rosterListener : this.rosterListeners) {
                if (!collection.isEmpty()) {
                    rosterListener.entriesAdded(collection);
                }
                if (!collection2.isEmpty()) {
                    rosterListener.entriesUpdated(collection2);
                }
                if (!collection3.isEmpty()) {
                    rosterListener.entriesDeleted(collection3);
                }
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void fireRosterPresenceEvent(Presence presence) {
        synchronized (this.rosterListenersAndEntriesLock) {
            Iterator<RosterListener> it = this.rosterListeners.iterator();
            while (it.hasNext()) {
                it.next().presenceChanged(presence);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void addUpdateEntry(Collection<Jid> collection, Collection<Jid> collection2, Collection<Jid> collection3, RosterPacket.Item item, RosterEntry rosterEntry) {
        RosterEntry rosterEntryPut;
        synchronized (this.rosterListenersAndEntriesLock) {
            rosterEntryPut = this.entries.put(item.getJid(), rosterEntry);
        }
        if (rosterEntryPut == null) {
            BareJid jid = item.getJid();
            collection.add(jid);
            move(jid, this.nonRosterPresenceMap, this.presenceMap);
        } else {
            RosterPacket.Item rosterItem = RosterEntry.toRosterItem(rosterEntryPut);
            if (!rosterEntryPut.equalsDeep(rosterEntry) || !item.getGroupNames().equals(rosterItem.getGroupNames())) {
                collection2.add(item.getJid());
                rosterEntryPut.updateItem(item);
            } else {
                collection3.add(item.getJid());
            }
        }
        if (item.getGroupNames().isEmpty()) {
            this.unfiledEntries.add(rosterEntry);
        } else {
            this.unfiledEntries.remove(rosterEntry);
        }
        ArrayList arrayList = new ArrayList();
        for (String str : item.getGroupNames()) {
            arrayList.add(str);
            RosterGroup group = getGroup(str);
            if (group == null) {
                group = createGroup(str);
                this.groups.put(str, group);
            }
            group.addEntryLocal(rosterEntry);
        }
        ArrayList<String> arrayList2 = new ArrayList();
        Iterator<RosterGroup> it = getGroups().iterator();
        while (it.hasNext()) {
            arrayList2.add(it.next().getName());
        }
        arrayList2.removeAll(arrayList);
        for (String str2 : arrayList2) {
            RosterGroup group2 = getGroup(str2);
            group2.removeEntryLocal(rosterEntry);
            if (group2.getEntryCount() == 0) {
                this.groups.remove(str2);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void deleteEntry(Collection<Jid> collection, RosterEntry rosterEntry) {
        BareJid jid = rosterEntry.getJid();
        this.entries.remove(jid);
        this.unfiledEntries.remove(rosterEntry);
        move(jid, this.presenceMap, this.nonRosterPresenceMap);
        collection.add(jid);
        for (Map.Entry<String, RosterGroup> entry : this.groups.entrySet()) {
            RosterGroup value = entry.getValue();
            value.removeEntryLocal(rosterEntry);
            if (value.getEntryCount() == 0) {
                this.groups.remove(entry.getKey());
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void removeEmptyGroups() {
        for (RosterGroup rosterGroup : getGroups()) {
            if (rosterGroup.getEntryCount() == 0) {
                this.groups.remove(rosterGroup.getName());
            }
        }
    }

    private static void move(BareJid bareJid, Map<BareJid, Map<Resourcepart, Presence>> map, Map<BareJid, Map<Resourcepart, Presence>> map2) {
        Map<Resourcepart, Presence> mapRemove = map.remove(bareJid);
        if (mapRemove == null || mapRemove.isEmpty()) {
            return;
        }
        map2.put(bareJid, mapRemove);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static boolean hasValidSubscriptionType(RosterPacket.Item item) {
        int i = AnonymousClass6.$SwitchMap$org$jivesoftware$smack$roster$packet$RosterPacket$ItemType[item.getItemType().ordinal()];
        return i == 1 || i == 2 || i == 3 || i == 4;
    }

    /* JADX WARN: Multi-variable type inference failed */
    private static Presence synthesizeUnvailablePresence(Jid jid) {
        return ((PresenceBuilder) StanzaBuilder.buildPresence().ofType(Presence.Type.unavailable).from(jid)).build();
    }

    public boolean isRosterVersioningSupported() {
        return connection().hasFeature(RosterVer.ELEMENT, RosterVer.NAMESPACE);
    }

    private class PresencePacketListener implements StanzaListener {
        private PresencePacketListener() {
        }

        @Override // org.jivesoftware.smack.StanzaListener
        public void processStanza(Stanza stanza) throws SmackException.NotConnectedException, InterruptedException {
            final BareJid bareJidAsBareJid;
            if (Roster.this.rosterState == RosterState.loading) {
                try {
                    Roster.this.waitUntilLoaded();
                } catch (InterruptedException e2) {
                    Roster.LOGGER.log(Level.INFO, "Presence listener was interrupted", (Throwable) e2);
                }
            }
            if (!Roster.this.isLoaded() && Roster.this.rosterLoadedAtLogin) {
                Roster.LOGGER.warning("Roster not loaded while processing " + stanza);
            }
            final Presence presence = (Presence) stanza;
            final Jid from = presence.getFrom();
            if (from == null) {
                XMPPConnection xMPPConnectionConnection = Roster.this.connection();
                if (xMPPConnectionConnection == null) {
                    Roster.LOGGER.finest("Connection was null while trying to handle exotic presence stanza: " + presence);
                    return;
                }
                EntityFullJid user = xMPPConnectionConnection.getUser();
                if (user == null) {
                    Roster.LOGGER.info("Connection had no local address in Roster's presence listener. Possibly we received a presence without from before being authenticated. Presence: " + presence);
                    return;
                } else {
                    Roster.LOGGER.info("Exotic presence stanza without from received: " + presence);
                    bareJidAsBareJid = user.asBareJid();
                }
            } else {
                bareJidAsBareJid = from.asBareJid();
            }
            Roster.this.asyncButOrdered.performAsyncButOrdered(bareJidAsBareJid, new Runnable() { // from class: org.jivesoftware.smack.roster.Roster.PresencePacketListener.1
                static final /* synthetic */ boolean $assertionsDisabled = false;

                @Override // java.lang.Runnable
                public void run() {
                    FullJid fullJidAsFullJidIfPossible;
                    Resourcepart resourceOrNull = Resourcepart.EMPTY;
                    Jid jid = from;
                    BareJid bareJidAsBareJid2 = null;
                    if (jid != null) {
                        resourceOrNull = jid.getResourceOrNull();
                        if (resourceOrNull == null) {
                            resourceOrNull = Resourcepart.EMPTY;
                            bareJidAsBareJid2 = from.asBareJid();
                            fullJidAsFullJidIfPossible = null;
                        } else {
                            fullJidAsFullJidIfPossible = from.asFullJidIfPossible();
                        }
                    } else {
                        fullJidAsFullJidIfPossible = null;
                    }
                    int i = AnonymousClass6.$SwitchMap$org$jivesoftware$smack$packet$Presence$Type[presence.getType().ordinal()];
                    if (i == 1) {
                        Map orCreatePresencesInternal = Roster.this.getOrCreatePresencesInternal(bareJidAsBareJid);
                        orCreatePresencesInternal.remove(Resourcepart.EMPTY);
                        orCreatePresencesInternal.put(resourceOrNull, presence);
                        if (Roster.this.contains(bareJidAsBareJid)) {
                            Roster.this.fireRosterPresenceEvent(presence);
                        }
                        Iterator it = Roster.this.presenceEventListeners.iterator();
                        while (it.hasNext()) {
                            ((PresenceEventListener) it.next()).presenceAvailable(fullJidAsFullJidIfPossible, presence);
                        }
                        return;
                    }
                    if (i == 2) {
                        Map orCreatePresencesInternal2 = Roster.this.getOrCreatePresencesInternal(bareJidAsBareJid);
                        if (from.hasNoResource()) {
                            orCreatePresencesInternal2.put(Resourcepart.EMPTY, presence);
                        } else {
                            orCreatePresencesInternal2.put(resourceOrNull, presence);
                        }
                        if (Roster.this.contains(bareJidAsBareJid)) {
                            Roster.this.fireRosterPresenceEvent(presence);
                        }
                        if (fullJidAsFullJidIfPossible != null) {
                            Iterator it2 = Roster.this.presenceEventListeners.iterator();
                            while (it2.hasNext()) {
                                ((PresenceEventListener) it2.next()).presenceUnavailable(fullJidAsFullJidIfPossible, presence);
                            }
                            return;
                        }
                        Roster.LOGGER.fine("Unavailable presence from bare JID: " + presence);
                        return;
                    }
                    if (i != 3) {
                        if (i == 4) {
                            Iterator it3 = Roster.this.presenceEventListeners.iterator();
                            while (it3.hasNext()) {
                                ((PresenceEventListener) it3.next()).presenceSubscribed(bareJidAsBareJid2, presence);
                            }
                            return;
                        } else {
                            if (i != 5) {
                                return;
                            }
                            Iterator it4 = Roster.this.presenceEventListeners.iterator();
                            while (it4.hasNext()) {
                                ((PresenceEventListener) it4.next()).presenceUnsubscribed(bareJidAsBareJid2, presence);
                            }
                            return;
                        }
                    }
                    Jid jid2 = from;
                    if (jid2 == null || !jid2.isEntityBareJid()) {
                        return;
                    }
                    Map orCreatePresencesInternal3 = Roster.this.getOrCreatePresencesInternal(bareJidAsBareJid);
                    orCreatePresencesInternal3.clear();
                    orCreatePresencesInternal3.put(Resourcepart.EMPTY, presence);
                    if (Roster.this.contains(bareJidAsBareJid)) {
                        Roster.this.fireRosterPresenceEvent(presence);
                    }
                    Iterator it5 = Roster.this.presenceEventListeners.iterator();
                    while (it5.hasNext()) {
                        ((PresenceEventListener) it5.next()).presenceError(from, presence);
                    }
                }
            });
        }
    }

    /* JADX INFO: renamed from: org.jivesoftware.smack.roster.Roster$6, reason: invalid class name */
    static /* synthetic */ class AnonymousClass6 {
        static final /* synthetic */ int[] $SwitchMap$org$jivesoftware$smack$packet$Presence$Type;
        static final /* synthetic */ int[] $SwitchMap$org$jivesoftware$smack$roster$Roster$SubscriptionMode;
        static final /* synthetic */ int[] $SwitchMap$org$jivesoftware$smack$roster$SubscribeListener$SubscribeAnswer;
        static final /* synthetic */ int[] $SwitchMap$org$jivesoftware$smack$roster$packet$RosterPacket$ItemType;

        static {
            int[] iArr = new int[Presence.Type.values().length];
            $SwitchMap$org$jivesoftware$smack$packet$Presence$Type = iArr;
            try {
                iArr[Presence.Type.available.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                $SwitchMap$org$jivesoftware$smack$packet$Presence$Type[Presence.Type.unavailable.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            try {
                $SwitchMap$org$jivesoftware$smack$packet$Presence$Type[Presence.Type.error.ordinal()] = 3;
            } catch (NoSuchFieldError unused3) {
            }
            try {
                $SwitchMap$org$jivesoftware$smack$packet$Presence$Type[Presence.Type.subscribed.ordinal()] = 4;
            } catch (NoSuchFieldError unused4) {
            }
            try {
                $SwitchMap$org$jivesoftware$smack$packet$Presence$Type[Presence.Type.unsubscribed.ordinal()] = 5;
            } catch (NoSuchFieldError unused5) {
            }
            int[] iArr2 = new int[RosterPacket.ItemType.values().length];
            $SwitchMap$org$jivesoftware$smack$roster$packet$RosterPacket$ItemType = iArr2;
            try {
                iArr2[RosterPacket.ItemType.none.ordinal()] = 1;
            } catch (NoSuchFieldError unused6) {
            }
            try {
                $SwitchMap$org$jivesoftware$smack$roster$packet$RosterPacket$ItemType[RosterPacket.ItemType.from.ordinal()] = 2;
            } catch (NoSuchFieldError unused7) {
            }
            try {
                $SwitchMap$org$jivesoftware$smack$roster$packet$RosterPacket$ItemType[RosterPacket.ItemType.to.ordinal()] = 3;
            } catch (NoSuchFieldError unused8) {
            }
            try {
                $SwitchMap$org$jivesoftware$smack$roster$packet$RosterPacket$ItemType[RosterPacket.ItemType.both.ordinal()] = 4;
            } catch (NoSuchFieldError unused9) {
            }
            int[] iArr3 = new int[SubscribeListener.SubscribeAnswer.values().length];
            $SwitchMap$org$jivesoftware$smack$roster$SubscribeListener$SubscribeAnswer = iArr3;
            try {
                iArr3[SubscribeListener.SubscribeAnswer.ApproveAndAlsoRequestIfRequired.ordinal()] = 1;
            } catch (NoSuchFieldError unused10) {
            }
            try {
                $SwitchMap$org$jivesoftware$smack$roster$SubscribeListener$SubscribeAnswer[SubscribeListener.SubscribeAnswer.Approve.ordinal()] = 2;
            } catch (NoSuchFieldError unused11) {
            }
            try {
                $SwitchMap$org$jivesoftware$smack$roster$SubscribeListener$SubscribeAnswer[SubscribeListener.SubscribeAnswer.Deny.ordinal()] = 3;
            } catch (NoSuchFieldError unused12) {
            }
            int[] iArr4 = new int[SubscriptionMode.values().length];
            $SwitchMap$org$jivesoftware$smack$roster$Roster$SubscriptionMode = iArr4;
            try {
                iArr4[SubscriptionMode.manual.ordinal()] = 1;
            } catch (NoSuchFieldError unused13) {
            }
            try {
                $SwitchMap$org$jivesoftware$smack$roster$Roster$SubscriptionMode[SubscriptionMode.accept_all.ordinal()] = 2;
            } catch (NoSuchFieldError unused14) {
            }
            try {
                $SwitchMap$org$jivesoftware$smack$roster$Roster$SubscriptionMode[SubscriptionMode.reject_all.ordinal()] = 3;
            } catch (NoSuchFieldError unused15) {
            }
        }
    }

    private class RosterResultListener implements SuccessCallback<IQ> {
        private RosterResultListener() {
        }

        @Override // org.jivesoftware.smack.util.SuccessCallback
        public void onSuccess(IQ iq) {
            XMPPConnection xMPPConnectionConnection = Roster.this.connection();
            Roster.LOGGER.log(Level.FINE, "RosterResultListener received {0}", iq);
            ArrayList arrayList = new ArrayList();
            ArrayList arrayList2 = new ArrayList();
            ArrayList arrayList3 = new ArrayList();
            ArrayList arrayList4 = new ArrayList();
            if (!(iq instanceof RosterPacket)) {
                List<RosterPacket.Item> entries = Roster.this.rosterStore.getEntries();
                if (entries == null) {
                    Roster.this.rosterStore.resetStore();
                    try {
                        Roster.this.reload();
                        return;
                    } catch (InterruptedException | SmackException.NotConnectedException | SmackException.NotLoggedInException e2) {
                        Roster.LOGGER.log(Level.FINE, "Exception while trying to load the roster after the roster store was corrupted", e2);
                        return;
                    }
                }
                for (RosterPacket.Item item : entries) {
                    Roster.this.addUpdateEntry(arrayList, arrayList2, arrayList4, item, new RosterEntry(item, Roster.this, xMPPConnectionConnection));
                }
            } else {
                RosterPacket rosterPacket = (RosterPacket) iq;
                ArrayList<RosterPacket.Item> arrayList5 = new ArrayList();
                for (RosterPacket.Item item2 : rosterPacket.getRosterItems()) {
                    if (Roster.hasValidSubscriptionType(item2)) {
                        arrayList5.add(item2);
                    }
                }
                for (RosterPacket.Item item3 : arrayList5) {
                    Roster.this.addUpdateEntry(arrayList, arrayList2, arrayList4, item3, new RosterEntry(item3, Roster.this, xMPPConnectionConnection));
                }
                HashSet<Jid> hashSet = new HashSet();
                Iterator it = Roster.this.entries.values().iterator();
                while (it.hasNext()) {
                    hashSet.add(((RosterEntry) it.next()).getJid());
                }
                hashSet.removeAll(arrayList);
                hashSet.removeAll(arrayList2);
                hashSet.removeAll(arrayList4);
                for (Jid jid : hashSet) {
                    Roster roster = Roster.this;
                    roster.deleteEntry(arrayList3, (RosterEntry) roster.entries.get(jid));
                }
                if (Roster.this.rosterStore != null) {
                    Roster.this.rosterStore.resetEntries(arrayList5, rosterPacket.getVersion());
                }
                Roster.this.removeEmptyGroups();
            }
            Roster.this.rosterState = RosterState.loaded;
            synchronized (Roster.this) {
                Roster.this.notifyAll();
            }
            Roster.this.fireRosterChangedEvent(arrayList, arrayList2, arrayList3);
            try {
                synchronized (Roster.this.rosterLoadedListeners) {
                    Iterator it2 = Roster.this.rosterLoadedListeners.iterator();
                    while (it2.hasNext()) {
                        ((RosterLoadedListener) it2.next()).onRosterLoaded(Roster.this);
                    }
                }
            } catch (Exception e3) {
                Roster.LOGGER.log(Level.WARNING, "RosterLoadedListener threw exception", (Throwable) e3);
            }
        }
    }

    private final class RosterPushListener extends AbstractIqRequestHandler {
        private RosterPushListener() {
            super("query", RosterPacket.NAMESPACE, IQ.Type.set, IQRequestHandler.Mode.sync);
        }

        @Override // org.jivesoftware.smack.iqrequest.AbstractIqRequestHandler, org.jivesoftware.smack.iqrequest.IQRequestHandler
        public IQ handleIQRequest(IQ iq) {
            XMPPConnection xMPPConnectionConnection = Roster.this.connection();
            RosterPacket rosterPacket = (RosterPacket) iq;
            EntityFullJid user = xMPPConnectionConnection.getUser();
            if (user == null) {
                Roster.LOGGER.warning("Ignoring roster push " + iq + " while " + xMPPConnectionConnection + " has no bound resource. This may be a server bug.");
                return null;
            }
            EntityBareJid entityBareJidAsEntityBareJid = user.asEntityBareJid();
            Jid from = rosterPacket.getFrom();
            if (from != null) {
                if (from.equals((CharSequence) user)) {
                    Roster.LOGGER.warning("Received roster push from full JID. This behavior is since RFC 6121 not longer standard compliant. Please ask your server vendor to fix this and comply to RFC 6121 § 2.1.6. IQ roster push stanza: " + iq);
                } else if (!from.equals((CharSequence) entityBareJidAsEntityBareJid)) {
                    Roster.LOGGER.warning("Ignoring roster push with a non matching 'from' ourJid='" + ((Object) entityBareJidAsEntityBareJid) + "' from='" + ((Object) from) + "'");
                    return IQ.createErrorResponse(iq, StanzaError.Condition.service_unavailable);
                }
            }
            List<RosterPacket.Item> rosterItems = rosterPacket.getRosterItems();
            if (rosterItems.size() != 1) {
                Roster.LOGGER.warning("Ignoring roster push with not exactly one entry. size=" + rosterItems.size());
                return IQ.createErrorResponse(iq, StanzaError.Condition.bad_request);
            }
            ArrayList arrayList = new ArrayList();
            ArrayList arrayList2 = new ArrayList();
            ArrayList arrayList3 = new ArrayList();
            ArrayList arrayList4 = new ArrayList();
            RosterPacket.Item next = rosterItems.iterator().next();
            RosterEntry rosterEntry = new RosterEntry(next, Roster.this, xMPPConnectionConnection);
            String version = rosterPacket.getVersion();
            if (next.getItemType().equals(RosterPacket.ItemType.remove)) {
                Roster.this.deleteEntry(arrayList3, rosterEntry);
                if (Roster.this.rosterStore != null) {
                    Roster.this.rosterStore.removeEntry(rosterEntry.getJid(), version);
                }
            } else if (Roster.hasValidSubscriptionType(next)) {
                Roster.this.addUpdateEntry(arrayList, arrayList2, arrayList4, next, rosterEntry);
                if (Roster.this.rosterStore != null) {
                    Roster.this.rosterStore.addEntry(next, version);
                }
            }
            Roster.this.removeEmptyGroups();
            Roster.this.fireRosterChangedEvent(arrayList, arrayList2, arrayList3);
            return IQ.createResultIQ(rosterPacket);
        }
    }

    public static void setDefaultNonRosterPresenceMapMaxSize(int i) {
        defaultNonRosterPresenceMapMaxSize = i;
    }

    public void setNonRosterPresenceMapMaxSize(int i) {
        this.nonRosterPresenceMap.setMaxCacheSize(i);
    }
}
