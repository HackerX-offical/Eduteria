package org.jivesoftware.smackx.disco;

import com.csvreader.CsvReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.Collections;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.WeakHashMap;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.CopyOnWriteArraySet;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.logging.Level;
import java.util.logging.Logger;
import org.jivesoftware.smack.ConnectionCreationListener;
import org.jivesoftware.smack.ConnectionListener;
import org.jivesoftware.smack.Manager;
import org.jivesoftware.smack.ScheduledAction;
import org.jivesoftware.smack.SmackException;
import org.jivesoftware.smack.StanzaListener;
import org.jivesoftware.smack.XMPPConnection;
import org.jivesoftware.smack.XMPPConnectionRegistry;
import org.jivesoftware.smack.XMPPException;
import org.jivesoftware.smack.filter.PresenceTypeFilter;
import org.jivesoftware.smack.internal.AbstractStats;
import org.jivesoftware.smack.iqrequest.AbstractIqRequestHandler;
import org.jivesoftware.smack.iqrequest.IQRequestHandler;
import org.jivesoftware.smack.packet.IQ;
import org.jivesoftware.smack.packet.Presence;
import org.jivesoftware.smack.packet.Stanza;
import org.jivesoftware.smack.packet.StanzaError;
import org.jivesoftware.smack.util.CollectionUtil;
import org.jivesoftware.smack.util.ExtendedAppendable;
import org.jivesoftware.smack.util.Objects;
import org.jivesoftware.smack.util.StringUtils;
import org.jivesoftware.smackx.disco.packet.DiscoverInfo;
import org.jivesoftware.smackx.disco.packet.DiscoverInfoBuilder;
import org.jivesoftware.smackx.disco.packet.DiscoverItems;
import org.jivesoftware.smackx.xdata.packet.DataForm;
import org.jxmpp.jid.DomainBareJid;
import org.jxmpp.jid.Jid;
import org.jxmpp.util.cache.Cache;
import org.jxmpp.util.cache.ExpirationCache;

/* JADX INFO: loaded from: classes10.dex */
public final class ServiceDiscoveryManager extends Manager {
    private static final int RENEW_ENTITY_CAPS_DELAY_MILLIS = 25;
    private final Set<EntityCapabilitiesChangedListener> entityCapabilitiesChangedListeners;
    private List<DataForm> extendedInfos;
    private final Set<String> features;
    private final Set<DiscoverInfo.Identity> identities;
    private DiscoverInfo.Identity identity;
    private final Map<String, NodeInformationProvider> nodeInformationProviders;
    private volatile Presence presenceSend;
    private final AtomicInteger renewEntityCapsPerformed;
    private int renewEntityCapsRequested;
    private ScheduledAction renewEntityCapsScheduledAction;
    private int scheduledRenewEntityCapsAvoided;
    private final Cache<String, List<DiscoverInfo>> services;
    private static final Logger LOGGER = Logger.getLogger(ServiceDiscoveryManager.class.getName());
    private static final List<DiscoInfoLookupShortcutMechanism> discoInfoLookupShortcutMechanisms = new ArrayList(2);
    private static final String DEFAULT_IDENTITY_CATEGORY = "client";
    private static final String DEFAULT_IDENTITY_NAME = "Smack";
    private static final String DEFAULT_IDENTITY_TYPE = "pc";
    private static DiscoverInfo.Identity defaultIdentity = new DiscoverInfo.Identity(DEFAULT_IDENTITY_CATEGORY, DEFAULT_IDENTITY_NAME, DEFAULT_IDENTITY_TYPE);
    private static final Map<XMPPConnection, ServiceDiscoveryManager> instances = new WeakHashMap();

    static {
        XMPPConnectionRegistry.addConnectionCreationListener(new ConnectionCreationListener() { // from class: org.jivesoftware.smackx.disco.ServiceDiscoveryManager.1
            @Override // org.jivesoftware.smack.ConnectionCreationListener
            public void connectionCreated(XMPPConnection xMPPConnection) {
                ServiceDiscoveryManager.getInstanceFor(xMPPConnection);
            }
        });
    }

    public static void setDefaultIdentity(DiscoverInfo.Identity identity) {
        defaultIdentity = identity;
    }

    private ServiceDiscoveryManager(XMPPConnection xMPPConnection) {
        super(xMPPConnection);
        this.identities = new HashSet();
        this.identity = defaultIdentity;
        this.entityCapabilitiesChangedListeners = new CopyOnWriteArraySet();
        this.features = new HashSet();
        this.extendedInfos = new ArrayList(2);
        this.nodeInformationProviders = new ConcurrentHashMap();
        this.services = new ExpirationCache(25, 86400000L);
        this.renewEntityCapsPerformed = new AtomicInteger();
        this.renewEntityCapsRequested = 0;
        this.scheduledRenewEntityCapsAvoided = 0;
        addFeature(DiscoverInfo.NAMESPACE);
        addFeature(DiscoverItems.NAMESPACE);
        xMPPConnection.registerIQRequestHandler(new AbstractIqRequestHandler("query", DiscoverItems.NAMESPACE, IQ.Type.get, IQRequestHandler.Mode.async) { // from class: org.jivesoftware.smackx.disco.ServiceDiscoveryManager.2
            @Override // org.jivesoftware.smack.iqrequest.AbstractIqRequestHandler, org.jivesoftware.smack.iqrequest.IQRequestHandler
            public IQ handleIQRequest(IQ iq) {
                DiscoverItems discoverItems = (DiscoverItems) iq;
                DiscoverItems discoverItems2 = new DiscoverItems();
                discoverItems2.setType(IQ.Type.result);
                discoverItems2.setTo(discoverItems.getFrom());
                discoverItems2.setStanzaId(discoverItems.getStanzaId());
                discoverItems2.setNode(discoverItems.getNode());
                NodeInformationProvider nodeInformationProvider = ServiceDiscoveryManager.this.getNodeInformationProvider(discoverItems.getNode());
                if (nodeInformationProvider != null) {
                    discoverItems2.addItems(nodeInformationProvider.getNodeItems());
                    discoverItems2.addExtensions(nodeInformationProvider.getNodePacketExtensions());
                    return discoverItems2;
                }
                if (discoverItems.getNode() != null) {
                    discoverItems2.setType(IQ.Type.error);
                    discoverItems2.setError(StanzaError.getBuilder(StanzaError.Condition.item_not_found).build());
                }
                return discoverItems2;
            }
        });
        xMPPConnection.registerIQRequestHandler(new AbstractIqRequestHandler("query", DiscoverInfo.NAMESPACE, IQ.Type.get, IQRequestHandler.Mode.async) { // from class: org.jivesoftware.smackx.disco.ServiceDiscoveryManager.3
            @Override // org.jivesoftware.smack.iqrequest.AbstractIqRequestHandler, org.jivesoftware.smack.iqrequest.IQRequestHandler
            public IQ handleIQRequest(IQ iq) {
                DiscoverInfo discoverInfo = (DiscoverInfo) iq;
                DiscoverInfoBuilder discoverInfoBuilderBuildResponseFor = DiscoverInfoBuilder.buildResponseFor(discoverInfo, IQ.ResponseType.result);
                if (discoverInfo.getNode() != null) {
                    NodeInformationProvider nodeInformationProvider = ServiceDiscoveryManager.this.getNodeInformationProvider(discoverInfo.getNode());
                    if (nodeInformationProvider != null) {
                        discoverInfoBuilderBuildResponseFor.addFeatures(nodeInformationProvider.getNodeFeatures());
                        discoverInfoBuilderBuildResponseFor.addIdentities(nodeInformationProvider.getNodeIdentities());
                        discoverInfoBuilderBuildResponseFor.addOptExtensions(nodeInformationProvider.getNodePacketExtensions());
                    } else {
                        discoverInfoBuilderBuildResponseFor.ofType(IQ.Type.error);
                        discoverInfoBuilderBuildResponseFor.setError(StanzaError.getBuilder(StanzaError.Condition.item_not_found).build());
                    }
                } else {
                    ServiceDiscoveryManager.this.addDiscoverInfoTo(discoverInfoBuilderBuildResponseFor);
                }
                return discoverInfoBuilderBuildResponseFor.build();
            }
        });
        xMPPConnection.addConnectionListener(new ConnectionListener() { // from class: org.jivesoftware.smackx.disco.ServiceDiscoveryManager.4
            @Override // org.jivesoftware.smack.ConnectionListener
            public void authenticated(XMPPConnection xMPPConnection2, boolean z) {
                if (z) {
                    return;
                }
                ServiceDiscoveryManager.this.presenceSend = null;
            }
        });
        xMPPConnection.addStanzaSendingListener(new StanzaListener() { // from class: org.jivesoftware.smackx.disco.ServiceDiscoveryManager$$ExternalSyntheticLambda0
            @Override // org.jivesoftware.smack.StanzaListener
            public final void processStanza(Stanza stanza) throws SmackException.NotConnectedException, InterruptedException, SmackException.NotLoggedInException {
                this.f$0.m14236xff017155(stanza);
            }
        }, PresenceTypeFilter.OUTGOING_PRESENCE_BROADCAST);
    }

    /* JADX INFO: renamed from: lambda$new$0$org-jivesoftware-smackx-disco-ServiceDiscoveryManager, reason: not valid java name */
    /* synthetic */ void m14236xff017155(Stanza stanza) throws SmackException.NotConnectedException, InterruptedException, SmackException.NotLoggedInException {
        this.presenceSend = (Presence) stanza;
    }

    public String getIdentityName() {
        return this.identity.getName();
    }

    public synchronized void setIdentity(DiscoverInfo.Identity identity) {
        this.identity = (DiscoverInfo.Identity) Objects.requireNonNull(identity, "Identity can not be null");
        renewEntityCapsVersion();
    }

    public DiscoverInfo.Identity getIdentity() {
        return this.identity;
    }

    public String getIdentityType() {
        return this.identity.getType();
    }

    public synchronized void addIdentity(DiscoverInfo.Identity identity) {
        this.identities.add(identity);
        renewEntityCapsVersion();
    }

    public synchronized boolean removeIdentity(DiscoverInfo.Identity identity) {
        if (identity.equals(this.identity)) {
            return false;
        }
        this.identities.remove(identity);
        renewEntityCapsVersion();
        return true;
    }

    public Set<DiscoverInfo.Identity> getIdentities() {
        HashSet hashSet = new HashSet(this.identities);
        hashSet.add(this.identity);
        return Collections.unmodifiableSet(hashSet);
    }

    public static synchronized ServiceDiscoveryManager getInstanceFor(XMPPConnection xMPPConnection) {
        ServiceDiscoveryManager serviceDiscoveryManager;
        Map<XMPPConnection, ServiceDiscoveryManager> map = instances;
        serviceDiscoveryManager = map.get(xMPPConnection);
        if (serviceDiscoveryManager == null) {
            serviceDiscoveryManager = new ServiceDiscoveryManager(xMPPConnection);
            map.put(xMPPConnection, serviceDiscoveryManager);
        }
        return serviceDiscoveryManager;
    }

    public synchronized void addDiscoverInfoTo(DiscoverInfoBuilder discoverInfoBuilder) {
        discoverInfoBuilder.addIdentities(getIdentities());
        Iterator<String> it = getFeatures().iterator();
        while (it.hasNext()) {
            discoverInfoBuilder.addFeature(it.next());
        }
        discoverInfoBuilder.addExtensions(this.extendedInfos);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public NodeInformationProvider getNodeInformationProvider(String str) {
        if (str == null) {
            return null;
        }
        return this.nodeInformationProviders.get(str);
    }

    public void setNodeInformationProvider(String str, NodeInformationProvider nodeInformationProvider) {
        this.nodeInformationProviders.put(str, nodeInformationProvider);
    }

    public void removeNodeInformationProvider(String str) {
        this.nodeInformationProviders.remove(str);
    }

    public synchronized List<String> getFeatures() {
        return new ArrayList(this.features);
    }

    public synchronized void addFeature(String str) {
        this.features.add(str);
        renewEntityCapsVersion();
    }

    public synchronized void removeFeature(String str) {
        this.features.remove(str);
        renewEntityCapsVersion();
    }

    public synchronized boolean includesFeature(String str) {
        return this.features.contains(str);
    }

    @Deprecated
    public synchronized void setExtendedInfo(DataForm dataForm) {
        addExtendedInfo(dataForm);
    }

    public DataForm addExtendedInfo(DataForm dataForm) {
        DataForm dataFormRemove;
        String formType = dataForm.getFormType();
        StringUtils.requireNotNullNorEmpty(formType, "The data form must have a form type set");
        synchronized (this) {
            dataFormRemove = DataForm.remove(this.extendedInfos, formType);
            this.extendedInfos.add(dataForm);
            renewEntityCapsVersion();
        }
        return dataFormRemove;
    }

    public synchronized void removeExtendedInfo(String str) {
        if (DataForm.remove(this.extendedInfos, str) != null) {
            renewEntityCapsVersion();
        }
    }

    public synchronized List<DataForm> getExtendedInfo() {
        return CollectionUtil.newListWith(this.extendedInfos);
    }

    @Deprecated
    public List<DataForm> getExtendedInfoAsList() {
        return getExtendedInfo();
    }

    public synchronized void removeExtendedInfo() {
        int size = this.extendedInfos.size();
        this.extendedInfos.clear();
        if (size > 0) {
            renewEntityCapsVersion();
        }
    }

    public DiscoverInfo discoverInfo(Jid jid) throws SmackException.NotConnectedException, SmackException.NoResponseException, InterruptedException, XMPPException.XMPPErrorException {
        if (jid == null) {
            return discoverInfo(null, null);
        }
        List<DiscoInfoLookupShortcutMechanism> list = discoInfoLookupShortcutMechanisms;
        synchronized (list) {
            Iterator<DiscoInfoLookupShortcutMechanism> it = list.iterator();
            while (it.hasNext()) {
                DiscoverInfo discoverInfoByUser = it.next().getDiscoverInfoByUser(this, jid);
                if (discoverInfoByUser != null) {
                    return discoverInfoByUser;
                }
            }
            return discoverInfo(jid, null);
        }
    }

    /* JADX WARN: Multi-variable type inference failed */
    public DiscoverInfo discoverInfo(Jid jid, String str) throws SmackException.NotConnectedException, SmackException.NoResponseException, InterruptedException, XMPPException.XMPPErrorException {
        XMPPConnection xMPPConnectionConnection = connection();
        return (DiscoverInfo) xMPPConnectionConnection.createStanzaCollectorAndSend(((DiscoverInfoBuilder) DiscoverInfo.builder(xMPPConnectionConnection).to(jid)).setNode(str).build()).nextResultOrThrow();
    }

    public DiscoverItems discoverItems(Jid jid) throws SmackException.NotConnectedException, SmackException.NoResponseException, InterruptedException, XMPPException.XMPPErrorException {
        return discoverItems(jid, null);
    }

    public DiscoverItems discoverItems(Jid jid, String str) throws SmackException.NotConnectedException, SmackException.NoResponseException, InterruptedException, XMPPException.XMPPErrorException {
        DiscoverItems discoverItems = new DiscoverItems();
        discoverItems.setType(IQ.Type.get);
        discoverItems.setTo(jid);
        discoverItems.setNode(str);
        return (DiscoverItems) connection().createStanzaCollectorAndSend(discoverItems).nextResultOrThrow();
    }

    public boolean serverSupportsFeature(CharSequence charSequence) throws SmackException.NotConnectedException, SmackException.NoResponseException, InterruptedException, XMPPException.XMPPErrorException {
        return serverSupportsFeatures(charSequence);
    }

    public boolean serverSupportsFeatures(CharSequence... charSequenceArr) throws SmackException.NotConnectedException, SmackException.NoResponseException, InterruptedException, XMPPException.XMPPErrorException {
        return serverSupportsFeatures(Arrays.asList(charSequenceArr));
    }

    public boolean serverSupportsFeatures(Collection<? extends CharSequence> collection) throws SmackException.NotConnectedException, SmackException.NoResponseException, InterruptedException, XMPPException.XMPPErrorException {
        return supportsFeatures(connection().getXMPPServiceDomain(), collection);
    }

    public boolean accountSupportsFeatures(CharSequence... charSequenceArr) throws SmackException.NotConnectedException, SmackException.NoResponseException, InterruptedException, XMPPException.XMPPErrorException {
        return accountSupportsFeatures(Arrays.asList(charSequenceArr));
    }

    public boolean accountSupportsFeatures(Collection<? extends CharSequence> collection) throws SmackException.NotConnectedException, SmackException.NoResponseException, InterruptedException, XMPPException.XMPPErrorException {
        return supportsFeatures(connection().getUser().asEntityBareJid(), collection);
    }

    public boolean supportsFeature(Jid jid, CharSequence charSequence) throws SmackException.NotConnectedException, SmackException.NoResponseException, InterruptedException, XMPPException.XMPPErrorException {
        return supportsFeatures(jid, charSequence);
    }

    public boolean supportsFeatures(Jid jid, CharSequence... charSequenceArr) throws SmackException.NotConnectedException, SmackException.NoResponseException, InterruptedException, XMPPException.XMPPErrorException {
        return supportsFeatures(jid, Arrays.asList(charSequenceArr));
    }

    public boolean supportsFeatures(Jid jid, Collection<? extends CharSequence> collection) throws SmackException.NotConnectedException, SmackException.NoResponseException, InterruptedException, XMPPException.XMPPErrorException {
        DiscoverInfo discoverInfo = discoverInfo(jid);
        Iterator<? extends CharSequence> it = collection.iterator();
        while (it.hasNext()) {
            if (!discoverInfo.containsFeature(it.next())) {
                return false;
            }
        }
        return true;
    }

    public List<DiscoverInfo> findServicesDiscoverInfo(String str, boolean z, boolean z2) throws SmackException.NotConnectedException, SmackException.NoResponseException, InterruptedException, XMPPException.XMPPErrorException {
        return findServicesDiscoverInfo(str, z, z2, null);
    }

    public List<DiscoverInfo> findServicesDiscoverInfo(String str, boolean z, boolean z2, Map<? super Jid, Exception> map) throws SmackException.NotConnectedException, SmackException.NoResponseException, InterruptedException, XMPPException.XMPPErrorException {
        return findServicesDiscoverInfo(connection().getXMPPServiceDomain(), str, z, z2, map);
    }

    /* JADX WARN: Removed duplicated region for block: B:42:0x0029 A[EXC_TOP_SPLITTER, SYNTHETIC] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public java.util.List<org.jivesoftware.smackx.disco.packet.DiscoverInfo> findServicesDiscoverInfo(org.jxmpp.jid.DomainBareJid r4, java.lang.String r5, boolean r6, boolean r7, java.util.Map<? super org.jxmpp.jid.Jid, java.lang.Exception> r8) throws org.jivesoftware.smack.SmackException.NotConnectedException, org.jivesoftware.smack.SmackException.NoResponseException, java.lang.InterruptedException, org.jivesoftware.smack.XMPPException.XMPPErrorException {
        /*
            r3 = this;
            if (r7 == 0) goto Ld
            org.jxmpp.util.cache.Cache<java.lang.String, java.util.List<org.jivesoftware.smackx.disco.packet.DiscoverInfo>> r0 = r3.services
            java.lang.Object r0 = r0.lookup(r5)
            java.util.List r0 = (java.util.List) r0
            if (r0 == 0) goto Ld
            return r0
        Ld:
            java.util.LinkedList r0 = new java.util.LinkedList
            r0.<init>()
            org.jivesoftware.smackx.disco.packet.DiscoverInfo r1 = r3.discoverInfo(r4)     // Catch: org.jivesoftware.smack.XMPPException.XMPPErrorException -> L6d
            boolean r2 = r1.containsFeature(r5)
            if (r2 == 0) goto L29
            r0.add(r1)
            if (r6 == 0) goto L29
            if (r7 == 0) goto L73
            org.jxmpp.util.cache.Cache<java.lang.String, java.util.List<org.jivesoftware.smackx.disco.packet.DiscoverInfo>> r4 = r3.services
            r4.put(r5, r0)
            return r0
        L29:
            org.jivesoftware.smackx.disco.packet.DiscoverItems r4 = r3.discoverItems(r4)     // Catch: org.jivesoftware.smack.XMPPException.XMPPErrorException -> L66
            java.util.List r4 = r4.getItems()
            java.util.Iterator r4 = r4.iterator()
        L35:
            boolean r1 = r4.hasNext()
            if (r1 == 0) goto L5e
            java.lang.Object r1 = r4.next()
            org.jivesoftware.smackx.disco.packet.DiscoverItems$Item r1 = (org.jivesoftware.smackx.disco.packet.DiscoverItems.Item) r1
            org.jxmpp.jid.Jid r1 = r1.getEntityID()
            org.jivesoftware.smackx.disco.packet.DiscoverInfo r1 = r3.discoverInfo(r1)     // Catch: org.jivesoftware.smack.SmackException.NoResponseException -> L55 org.jivesoftware.smack.XMPPException.XMPPErrorException -> L57
            boolean r2 = r1.containsFeature(r5)
            if (r2 == 0) goto L35
            r0.add(r1)
            if (r6 == 0) goto L35
            goto L5e
        L55:
            r2 = move-exception
            goto L58
        L57:
            r2 = move-exception
        L58:
            if (r8 == 0) goto L35
            r8.put(r1, r2)
            goto L35
        L5e:
            if (r7 == 0) goto L73
            org.jxmpp.util.cache.Cache<java.lang.String, java.util.List<org.jivesoftware.smackx.disco.packet.DiscoverInfo>> r4 = r3.services
            r4.put(r5, r0)
            goto L73
        L66:
            r5 = move-exception
            if (r8 == 0) goto L73
            r8.put(r4, r5)
            goto L73
        L6d:
            r5 = move-exception
            if (r8 == 0) goto L73
            r8.put(r4, r5)
        L73:
            return r0
        */
        throw new UnsupportedOperationException("Method not decompiled: org.jivesoftware.smackx.disco.ServiceDiscoveryManager.findServicesDiscoverInfo(org.jxmpp.jid.DomainBareJid, java.lang.String, boolean, boolean, java.util.Map):java.util.List");
    }

    public List<DomainBareJid> findServices(String str, boolean z, boolean z2) throws SmackException.NotConnectedException, SmackException.NoResponseException, InterruptedException, XMPPException.XMPPErrorException {
        List<DiscoverInfo> listFindServicesDiscoverInfo = findServicesDiscoverInfo(str, z, z2);
        ArrayList arrayList = new ArrayList(listFindServicesDiscoverInfo.size());
        Iterator<DiscoverInfo> it = listFindServicesDiscoverInfo.iterator();
        while (it.hasNext()) {
            arrayList.add(it.next().getFrom().asDomainBareJid());
        }
        return arrayList;
    }

    public DomainBareJid findService(String str, boolean z, String str2, String str3) throws SmackException.NotConnectedException, SmackException.NoResponseException, InterruptedException, XMPPException.XMPPErrorException {
        boolean zIsNullOrEmpty = StringUtils.isNullOrEmpty(str2);
        boolean zIsNullOrEmpty2 = StringUtils.isNullOrEmpty(str3);
        if (zIsNullOrEmpty2 != zIsNullOrEmpty) {
            throw new IllegalArgumentException("Must specify either both, category and type, or none");
        }
        List<DiscoverInfo> listFindServicesDiscoverInfo = findServicesDiscoverInfo(str, false, z);
        if (listFindServicesDiscoverInfo.isEmpty()) {
            return null;
        }
        if (!zIsNullOrEmpty && !zIsNullOrEmpty2) {
            for (DiscoverInfo discoverInfo : listFindServicesDiscoverInfo) {
                if (discoverInfo.hasIdentity(str2, str3)) {
                    return discoverInfo.getFrom().asDomainBareJid();
                }
            }
        }
        return listFindServicesDiscoverInfo.get(0).getFrom().asDomainBareJid();
    }

    public DomainBareJid findService(String str, boolean z) throws SmackException.NotConnectedException, SmackException.NoResponseException, InterruptedException, XMPPException.XMPPErrorException {
        return findService(str, z, null, null);
    }

    public boolean addEntityCapabilitiesChangedListener(EntityCapabilitiesChangedListener entityCapabilitiesChangedListener) {
        return this.entityCapabilitiesChangedListeners.add(entityCapabilitiesChangedListener);
    }

    private synchronized void renewEntityCapsVersion() {
        this.renewEntityCapsRequested++;
        ScheduledAction scheduledAction = this.renewEntityCapsScheduledAction;
        if (scheduledAction != null && scheduledAction.cancel()) {
            this.scheduledRenewEntityCapsAvoided++;
        }
        final XMPPConnection xMPPConnectionConnection = connection();
        this.renewEntityCapsScheduledAction = scheduleBlocking(new Runnable() { // from class: org.jivesoftware.smackx.disco.ServiceDiscoveryManager$$ExternalSyntheticLambda1
            @Override // java.lang.Runnable
            public final void run() {
                this.f$0.m14237x73478d97(xMPPConnectionConnection);
            }
        }, 25L, TimeUnit.MILLISECONDS);
    }

    /* JADX INFO: renamed from: lambda$renewEntityCapsVersion$1$org-jivesoftware-smackx-disco-ServiceDiscoveryManager, reason: not valid java name */
    /* synthetic */ void m14237x73478d97(XMPPConnection xMPPConnection) {
        this.renewEntityCapsPerformed.incrementAndGet();
        DiscoverInfoBuilder discoverInfoBuilderOfType = DiscoverInfo.builder("synthetized-disco-info-response").ofType(IQ.Type.result);
        addDiscoverInfoTo(discoverInfoBuilderOfType);
        DiscoverInfo discoverInfoBuild = discoverInfoBuilderOfType.build();
        Iterator<EntityCapabilitiesChangedListener> it = this.entityCapabilitiesChangedListeners.iterator();
        while (it.hasNext()) {
            it.next().onEntityCapabilitiesChanged(discoverInfoBuild);
        }
        Presence presence = this.presenceSend;
        if (!xMPPConnection.isAuthenticated() || presence == null) {
            return;
        }
        try {
            xMPPConnection.sendStanza(presence.asBuilder(xMPPConnection).build());
        } catch (InterruptedException | SmackException.NotConnectedException e2) {
            LOGGER.log(Level.WARNING, "Could could not update presence with caps info", e2);
        }
    }

    public static void addDiscoInfoLookupShortcutMechanism(DiscoInfoLookupShortcutMechanism discoInfoLookupShortcutMechanism) {
        List<DiscoInfoLookupShortcutMechanism> list = discoInfoLookupShortcutMechanisms;
        synchronized (list) {
            list.add(discoInfoLookupShortcutMechanism);
            Collections.sort(list);
        }
    }

    public static void removeDiscoInfoLookupShortcutMechanism(DiscoInfoLookupShortcutMechanism discoInfoLookupShortcutMechanism) {
        List<DiscoInfoLookupShortcutMechanism> list = discoInfoLookupShortcutMechanisms;
        synchronized (list) {
            list.remove(discoInfoLookupShortcutMechanism);
        }
    }

    public synchronized Stats getStats() {
        return new Stats();
    }

    public static final class Stats extends AbstractStats {
        public final int renewEntityCapsPerformed;
        public final int renewEntityCapsRequested;
        public final int scheduledRenewEntityCapsAvoided;

        private Stats(ServiceDiscoveryManager serviceDiscoveryManager) {
            this.renewEntityCapsRequested = serviceDiscoveryManager.renewEntityCapsRequested;
            this.renewEntityCapsPerformed = serviceDiscoveryManager.renewEntityCapsPerformed.get();
            this.scheduledRenewEntityCapsAvoided = serviceDiscoveryManager.scheduledRenewEntityCapsAvoided;
        }

        @Override // org.jivesoftware.smack.internal.AbstractStats
        public void appendStatsTo(ExtendedAppendable extendedAppendable) throws IOException {
            StringUtils.appendHeading(extendedAppendable, "ServiceDiscoveryManager stats", CsvReader.Letters.POUND).append('\n');
            extendedAppendable.append("renew-entitycaps-requested: ").append(this.renewEntityCapsRequested).append('\n');
            extendedAppendable.append("renew-entitycaps-performed: ").append(this.renewEntityCapsPerformed).append('\n');
            extendedAppendable.append("scheduled-renew-entitycaps-avoided: ").append(this.scheduledRenewEntityCapsAvoided).append('\n');
        }
    }
}
