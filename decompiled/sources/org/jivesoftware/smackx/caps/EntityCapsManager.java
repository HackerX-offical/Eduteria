package org.jivesoftware.smackx.caps;

import com.csvreader.CsvReader;
import java.nio.charset.StandardCharsets;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import java.util.Locale;
import java.util.Map;
import java.util.Queue;
import java.util.TreeSet;
import java.util.WeakHashMap;
import java.util.concurrent.ConcurrentLinkedQueue;
import kotlin.text.Typography;
import org.eclipse.paho.client.mqttv3.MqttTopic;
import org.jivesoftware.smack.ConnectionCreationListener;
import org.jivesoftware.smack.ConnectionListener;
import org.jivesoftware.smack.Manager;
import org.jivesoftware.smack.SmackConfiguration;
import org.jivesoftware.smack.SmackException;
import org.jivesoftware.smack.StanzaListener;
import org.jivesoftware.smack.XMPPConnection;
import org.jivesoftware.smack.XMPPConnectionRegistry;
import org.jivesoftware.smack.XMPPException;
import org.jivesoftware.smack.filter.AndFilter;
import org.jivesoftware.smack.filter.PresenceTypeFilter;
import org.jivesoftware.smack.filter.StanzaExtensionFilter;
import org.jivesoftware.smack.filter.StanzaFilter;
import org.jivesoftware.smack.filter.StanzaTypeFilter;
import org.jivesoftware.smack.packet.Presence;
import org.jivesoftware.smack.packet.PresenceBuilder;
import org.jivesoftware.smack.packet.Stanza;
import org.jivesoftware.smack.roster.AbstractPresenceEventListener;
import org.jivesoftware.smack.roster.Roster;
import org.jivesoftware.smack.util.Predicate;
import org.jivesoftware.smack.util.stringencoder.Base64;
import org.jivesoftware.smackx.caps.cache.EntityCapsPersistentCache;
import org.jivesoftware.smackx.caps.packet.CapsExtension;
import org.jivesoftware.smackx.disco.AbstractNodeInformationProvider;
import org.jivesoftware.smackx.disco.DiscoInfoLookupShortcutMechanism;
import org.jivesoftware.smackx.disco.EntityCapabilitiesChangedListener;
import org.jivesoftware.smackx.disco.ServiceDiscoveryManager;
import org.jivesoftware.smackx.disco.packet.DiscoverInfo;
import org.jivesoftware.smackx.disco.packet.DiscoverInfoBuilder;
import org.jivesoftware.smackx.disco.packet.DiscoverInfoView;
import org.jivesoftware.smackx.xdata.FormField;
import org.jivesoftware.smackx.xdata.TextSingleFormField;
import org.jivesoftware.smackx.xdata.packet.DataForm;
import org.jxmpp.jid.FullJid;
import org.jxmpp.jid.Jid;
import org.jxmpp.util.cache.LruCache;

/* JADX INFO: loaded from: classes10.dex */
public final class EntityCapsManager extends Manager {
    static final LruCache<String, DiscoverInfo> CAPS_CACHE;
    private static String DEFAULT_ENTITY_NODE = null;
    private static final String DEFAULT_HASH = "SHA-1";
    public static final String ELEMENT = "c";
    static final LruCache<Jid, NodeVerHash> JID_TO_NODEVER_CACHE;
    public static final String NAMESPACE = "http://jabber.org/protocol/caps";
    private static final StanzaFilter PRESENCES_WITH_CAPS;
    private static final Map<String, MessageDigest> SUPPORTED_HASHES;
    private static boolean autoEnableEntityCaps;
    private static final Map<XMPPConnection, EntityCapsManager> instances;
    protected static EntityCapsPersistentCache persistentCache;
    private CapsVersionAndHash currentCapsVersion;
    private boolean entityCapsEnabled;
    private String entityNode;
    private final Queue<CapsVersionAndHash> lastLocalCapsVersions;
    private final ServiceDiscoveryManager sdm;

    static {
        HashMap map = new HashMap();
        SUPPORTED_HASHES = map;
        DEFAULT_ENTITY_NODE = SmackConfiguration.SMACK_URL_STRING;
        autoEnableEntityCaps = true;
        instances = new WeakHashMap();
        PRESENCES_WITH_CAPS = new AndFilter(new StanzaTypeFilter(Presence.class), new StanzaExtensionFilter("c", "http://jabber.org/protocol/caps"));
        CAPS_CACHE = new LruCache<>(1000);
        JID_TO_NODEVER_CACHE = new LruCache<>(10000);
        XMPPConnectionRegistry.addConnectionCreationListener(new ConnectionCreationListener() { // from class: org.jivesoftware.smackx.caps.EntityCapsManager.1
            @Override // org.jivesoftware.smack.ConnectionCreationListener
            public void connectionCreated(XMPPConnection xMPPConnection) {
                EntityCapsManager.getInstanceFor(xMPPConnection);
            }
        });
        try {
            map.put("SHA-1", MessageDigest.getInstance("SHA-1"));
        } catch (NoSuchAlgorithmException unused) {
        }
        ServiceDiscoveryManager.addDiscoInfoLookupShortcutMechanism(new DiscoInfoLookupShortcutMechanism("XEP-0115: Entity Capabilities", 100) { // from class: org.jivesoftware.smackx.caps.EntityCapsManager.2
            @Override // org.jivesoftware.smackx.disco.DiscoInfoLookupShortcutMechanism
            public DiscoverInfo getDiscoverInfoByUser(ServiceDiscoveryManager serviceDiscoveryManager, Jid jid) {
                DiscoverInfo discoverInfoByUser = EntityCapsManager.getDiscoverInfoByUser(jid);
                if (discoverInfoByUser != null) {
                    return discoverInfoByUser;
                }
                NodeVerHash nodeVerHashByJid = EntityCapsManager.getNodeVerHashByJid(jid);
                if (nodeVerHashByJid == null) {
                    return null;
                }
                try {
                    DiscoverInfo discoverInfo = serviceDiscoveryManager.discoverInfo(jid, nodeVerHashByJid.getNodeVer());
                    if (EntityCapsManager.verifyDiscoverInfoVersion(nodeVerHashByJid.getVer(), nodeVerHashByJid.getHash(), discoverInfo)) {
                        EntityCapsManager.addDiscoverInfoByNode(nodeVerHashByJid.getNodeVer(), discoverInfo);
                    }
                    return discoverInfo;
                } catch (InterruptedException | SmackException.NoResponseException | SmackException.NotConnectedException | XMPPException.XMPPErrorException unused2) {
                    return null;
                }
            }
        });
    }

    public static void setDefaultEntityNode(String str) {
        DEFAULT_ENTITY_NODE = str;
    }

    static void addDiscoverInfoByNode(String str, DiscoverInfo discoverInfo) {
        CAPS_CACHE.put(str, discoverInfo);
        EntityCapsPersistentCache entityCapsPersistentCache = persistentCache;
        if (entityCapsPersistentCache != null) {
            entityCapsPersistentCache.addDiscoverInfoByNodePersistent(str, discoverInfo);
        }
    }

    public static String getNodeVersionByJid(Jid jid) {
        NodeVerHash nodeVerHashLookup = JID_TO_NODEVER_CACHE.lookup(jid);
        if (nodeVerHashLookup != null) {
            return nodeVerHashLookup.nodeVer;
        }
        return null;
    }

    public static NodeVerHash getNodeVerHashByJid(Jid jid) {
        return JID_TO_NODEVER_CACHE.lookup(jid);
    }

    public static DiscoverInfo getDiscoverInfoByUser(Jid jid) {
        NodeVerHash nodeVerHashLookup = JID_TO_NODEVER_CACHE.lookup(jid);
        if (nodeVerHashLookup == null) {
            return null;
        }
        return getDiscoveryInfoByNodeVer(nodeVerHashLookup.nodeVer);
    }

    public static DiscoverInfo getDiscoveryInfoByNodeVer(String str) {
        EntityCapsPersistentCache entityCapsPersistentCache;
        LruCache<String, DiscoverInfo> lruCache = CAPS_CACHE;
        DiscoverInfo discoverInfoLookup = lruCache.lookup(str);
        if (discoverInfoLookup == null && (entityCapsPersistentCache = persistentCache) != null && (discoverInfoLookup = entityCapsPersistentCache.lookup(str)) != null) {
            lruCache.put(str, discoverInfoLookup);
        }
        return discoverInfoLookup != null ? new DiscoverInfo(discoverInfoLookup) : discoverInfoLookup;
    }

    public static void setPersistentCache(EntityCapsPersistentCache entityCapsPersistentCache) {
        persistentCache = entityCapsPersistentCache;
    }

    public static void setMaxsCacheSizes(int i, int i2) {
        JID_TO_NODEVER_CACHE.setMaxCacheSize(i);
        CAPS_CACHE.setMaxCacheSize(i2);
    }

    public static void clearMemoryCache() {
        JID_TO_NODEVER_CACHE.clear();
        CAPS_CACHE.clear();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static void addCapsExtensionInfo(Jid jid, CapsExtension capsExtension) {
        String hash = capsExtension.getHash();
        if (SUPPORTED_HASHES.containsKey(hash.toUpperCase(Locale.US))) {
            String lowerCase = hash.toLowerCase(Locale.US);
            JID_TO_NODEVER_CACHE.put(jid, new NodeVerHash(capsExtension.getNode(), capsExtension.getVer(), lowerCase));
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void addCapsExtension(PresenceBuilder presenceBuilder) {
        CapsVersionAndHash capsVersionAndHash = getCapsVersionAndHash();
        if (capsVersionAndHash == null) {
            return;
        }
        presenceBuilder.overrideExtension(new CapsExtension(this.entityNode, capsVersionAndHash.version, capsVersionAndHash.hash));
    }

    private EntityCapsManager(XMPPConnection xMPPConnection) {
        super(xMPPConnection);
        this.lastLocalCapsVersions = new ConcurrentLinkedQueue();
        this.entityNode = DEFAULT_ENTITY_NODE;
        ServiceDiscoveryManager instanceFor = ServiceDiscoveryManager.getInstanceFor(xMPPConnection);
        this.sdm = instanceFor;
        instances.put(xMPPConnection, this);
        xMPPConnection.addConnectionListener(new ConnectionListener() { // from class: org.jivesoftware.smackx.caps.EntityCapsManager.3
            @Override // org.jivesoftware.smack.ConnectionListener
            public void connected(XMPPConnection xMPPConnection2) {
                processCapsStreamFeatureIfAvailable(xMPPConnection2);
            }

            @Override // org.jivesoftware.smack.ConnectionListener
            public void authenticated(XMPPConnection xMPPConnection2, boolean z) {
                processCapsStreamFeatureIfAvailable(xMPPConnection2);
            }

            private void processCapsStreamFeatureIfAvailable(XMPPConnection xMPPConnection2) {
                CapsExtension capsExtension = (CapsExtension) xMPPConnection2.getFeature(CapsExtension.class);
                if (capsExtension == null) {
                    return;
                }
                EntityCapsManager.addCapsExtensionInfo(xMPPConnection2.getXMPPServiceDomain(), capsExtension);
            }
        });
        if (autoEnableEntityCaps) {
            enableEntityCaps();
        }
        xMPPConnection.addAsyncStanzaListener(new StanzaListener() { // from class: org.jivesoftware.smackx.caps.EntityCapsManager.4
            @Override // org.jivesoftware.smack.StanzaListener
            public void processStanza(Stanza stanza) {
                if (EntityCapsManager.this.entityCapsEnabled()) {
                    EntityCapsManager.addCapsExtensionInfo(stanza.getFrom(), CapsExtension.from(stanza));
                }
            }
        }, PRESENCES_WITH_CAPS);
        Roster.getInstanceFor(xMPPConnection).addPresenceEventListener(new AbstractPresenceEventListener() { // from class: org.jivesoftware.smackx.caps.EntityCapsManager.5
            @Override // org.jivesoftware.smack.roster.AbstractPresenceEventListener, org.jivesoftware.smack.roster.PresenceEventListener
            public void presenceUnavailable(FullJid fullJid, Presence presence) {
                EntityCapsManager.JID_TO_NODEVER_CACHE.remove(fullJid);
            }
        });
        instanceFor.addEntityCapabilitiesChangedListener(new EntityCapabilitiesChangedListener() { // from class: org.jivesoftware.smackx.caps.EntityCapsManager.6
            @Override // org.jivesoftware.smackx.disco.EntityCapabilitiesChangedListener
            public void onEntityCapabilitiesChanged(DiscoverInfo discoverInfo) {
                if (EntityCapsManager.this.entityCapsEnabled()) {
                    EntityCapsManager.this.updateLocalEntityCaps(discoverInfo);
                }
            }
        });
    }

    public static synchronized EntityCapsManager getInstanceFor(XMPPConnection xMPPConnection) {
        EntityCapsManager entityCapsManager;
        if (SUPPORTED_HASHES.size() <= 0) {
            throw new IllegalStateException("No supported hashes for EntityCapsManager");
        }
        entityCapsManager = instances.get(xMPPConnection);
        if (entityCapsManager == null) {
            entityCapsManager = new EntityCapsManager(xMPPConnection);
        }
        return entityCapsManager;
    }

    public synchronized void enableEntityCaps() {
        connection().addPresenceInterceptor(new EntityCapsManager$$ExternalSyntheticLambda0(this), new Predicate() { // from class: org.jivesoftware.smackx.caps.EntityCapsManager$$ExternalSyntheticLambda1
            @Override // org.jivesoftware.smack.util.Predicate
            public final boolean test(Object obj) {
                return PresenceTypeFilter.AVAILABLE.accept((Presence) obj);
            }
        });
        this.sdm.addFeature("http://jabber.org/protocol/caps");
        this.entityCapsEnabled = true;
    }

    public synchronized void disableEntityCaps() {
        this.entityCapsEnabled = false;
        this.sdm.removeFeature("http://jabber.org/protocol/caps");
        connection().removePresenceInterceptor(new EntityCapsManager$$ExternalSyntheticLambda0(this));
    }

    public boolean entityCapsEnabled() {
        return this.entityCapsEnabled;
    }

    public static void removeUserCapsNode(Jid jid) {
        JID_TO_NODEVER_CACHE.remove(jid);
    }

    public CapsVersionAndHash getCapsVersionAndHash() {
        return this.currentCapsVersion;
    }

    public String getLocalNodeVer() {
        CapsVersionAndHash capsVersionAndHash = getCapsVersionAndHash();
        if (capsVersionAndHash == null) {
            return null;
        }
        return this.entityNode + CsvReader.Letters.POUND + capsVersionAndHash.version;
    }

    public boolean areEntityCapsSupported(Jid jid) throws SmackException.NotConnectedException, SmackException.NoResponseException, InterruptedException, XMPPException.XMPPErrorException {
        return this.sdm.supportsFeature(jid, "http://jabber.org/protocol/caps");
    }

    public boolean areEntityCapsSupportedByServer() throws SmackException.NotConnectedException, SmackException.NoResponseException, InterruptedException, XMPPException.XMPPErrorException {
        return areEntityCapsSupported(connection().getXMPPServiceDomain());
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void updateLocalEntityCaps(DiscoverInfo discoverInfo) {
        XMPPConnection xMPPConnectionConnection = connection();
        DiscoverInfoBuilder discoverInfoBuilderAsBuilder = discoverInfo.asBuilder("synthesized-disco-info-result");
        this.currentCapsVersion = generateVerificationString(discoverInfoBuilderAsBuilder);
        String localNodeVer = getLocalNodeVer();
        discoverInfoBuilderAsBuilder.setNode(localNodeVer);
        addDiscoverInfoByNode(localNodeVer, discoverInfoBuilderAsBuilder.build());
        if (this.lastLocalCapsVersions.size() > 10) {
            this.sdm.removeNodeInformationProvider(this.entityNode + CsvReader.Letters.POUND + this.lastLocalCapsVersions.poll().version);
        }
        this.lastLocalCapsVersions.add(this.currentCapsVersion);
        if (xMPPConnectionConnection != null) {
            JID_TO_NODEVER_CACHE.put(xMPPConnectionConnection.getUser(), new NodeVerHash(this.entityNode, this.currentCapsVersion));
        }
        final LinkedList linkedList = new LinkedList(ServiceDiscoveryManager.getInstanceFor(xMPPConnectionConnection).getIdentities());
        this.sdm.setNodeInformationProvider(localNodeVer, new AbstractNodeInformationProvider() { // from class: org.jivesoftware.smackx.caps.EntityCapsManager.7
            List<String> features;
            List<DataForm> packetExtensions;

            {
                this.features = EntityCapsManager.this.sdm.getFeatures();
                this.packetExtensions = EntityCapsManager.this.sdm.getExtendedInfo();
            }

            @Override // org.jivesoftware.smackx.disco.AbstractNodeInformationProvider, org.jivesoftware.smackx.disco.NodeInformationProvider
            public List<String> getNodeFeatures() {
                return this.features;
            }

            @Override // org.jivesoftware.smackx.disco.AbstractNodeInformationProvider, org.jivesoftware.smackx.disco.NodeInformationProvider
            public List<DiscoverInfo.Identity> getNodeIdentities() {
                return linkedList;
            }

            @Override // org.jivesoftware.smackx.disco.AbstractNodeInformationProvider, org.jivesoftware.smackx.disco.NodeInformationProvider
            public List<DataForm> getNodePacketExtensions() {
                return this.packetExtensions;
            }
        });
    }

    public static boolean verifyDiscoverInfoVersion(String str, String str2, DiscoverInfo discoverInfo) {
        return !discoverInfo.containsDuplicateIdentities() && !discoverInfo.containsDuplicateFeatures() && verifyPacketExtensions(discoverInfo) && str.equals(generateVerificationString(discoverInfo, str2).version);
    }

    private static boolean verifyPacketExtensions(DiscoverInfo discoverInfo) {
        HashSet hashSet = new HashSet();
        Iterator it = discoverInfo.getExtensions(DataForm.class).iterator();
        while (it.hasNext()) {
            TextSingleFormField hiddenFormTypeField = ((DataForm) it.next()).getHiddenFormTypeField();
            if (hiddenFormTypeField != null && !hashSet.add(hiddenFormTypeField.getFirstValue())) {
                return false;
            }
        }
        return true;
    }

    protected static CapsVersionAndHash generateVerificationString(DiscoverInfoView discoverInfoView) {
        return generateVerificationString(discoverInfoView, null);
    }

    protected static CapsVersionAndHash generateVerificationString(DiscoverInfoView discoverInfoView, String str) {
        byte[] bArrDigest;
        if (str == null) {
            str = "SHA-1";
        }
        MessageDigest messageDigest = SUPPORTED_HASHES.get(str.toUpperCase(Locale.US));
        if (messageDigest == null) {
            return null;
        }
        String lowerCase = str.toLowerCase(Locale.US);
        StringBuilder sb = new StringBuilder();
        TreeSet<DiscoverInfo.Identity> treeSet = new TreeSet();
        treeSet.addAll(discoverInfoView.getIdentities());
        for (DiscoverInfo.Identity identity : treeSet) {
            sb.append(identity.getCategory());
            sb.append('/');
            sb.append(identity.getType());
            sb.append('/');
            sb.append(identity.getLanguage() == null ? "" : identity.getLanguage());
            sb.append('/');
            sb.append(identity.getName() == null ? "" : identity.getName());
            sb.append(Typography.less);
        }
        TreeSet treeSet2 = new TreeSet();
        Iterator<DiscoverInfo.Feature> it = discoverInfoView.getFeatures().iterator();
        while (it.hasNext()) {
            treeSet2.add(it.next().getVar());
        }
        Iterator it2 = treeSet2.iterator();
        while (it2.hasNext()) {
            sb.append((String) it2.next());
            sb.append(Typography.less);
        }
        for (DataForm dataForm : discoverInfoView.getExtensions(DataForm.class)) {
            if (dataForm.hasHiddenFormTypeField()) {
                TreeSet<FormField> treeSet3 = new TreeSet(new Comparator<FormField>() { // from class: org.jivesoftware.smackx.caps.EntityCapsManager.8
                    @Override // java.util.Comparator
                    public int compare(FormField formField, FormField formField2) {
                        return formField.getFieldName().compareTo(formField2.getFieldName());
                    }
                });
                for (FormField formField : dataForm.getFields()) {
                    if (!formField.getFieldName().equals(FormField.FORM_TYPE)) {
                        treeSet3.add(formField);
                    }
                }
                formFieldValuesToCaps(Collections.singletonList(dataForm.getFormType()), sb);
                for (FormField formField2 : treeSet3) {
                    sb.append(formField2.getFieldName());
                    sb.append(Typography.less);
                    formFieldValuesToCaps(formField2.getRawValueCharSequences(), sb);
                }
            }
        }
        byte[] bytes = sb.toString().getBytes(StandardCharsets.UTF_8);
        synchronized (messageDigest) {
            bArrDigest = messageDigest.digest(bytes);
        }
        return new CapsVersionAndHash(Base64.encodeToString(bArrDigest), lowerCase);
    }

    private static void formFieldValuesToCaps(List<? extends CharSequence> list, StringBuilder sb) {
        TreeSet treeSet = new TreeSet();
        treeSet.addAll(list);
        Iterator it = treeSet.iterator();
        while (it.hasNext()) {
            sb.append((CharSequence) it.next());
            sb.append(Typography.less);
        }
    }

    public static class NodeVerHash {
        private String hash;
        private String node;
        private String nodeVer;
        private String ver;

        NodeVerHash(String str, CapsVersionAndHash capsVersionAndHash) {
            this(str, capsVersionAndHash.version, capsVersionAndHash.hash);
        }

        NodeVerHash(String str, String str2, String str3) {
            this.node = str;
            this.ver = str2;
            this.hash = str3;
            this.nodeVer = str + MqttTopic.MULTI_LEVEL_WILDCARD + str2;
        }

        public String getNodeVer() {
            return this.nodeVer;
        }

        public String getNode() {
            return this.node;
        }

        public String getHash() {
            return this.hash;
        }

        public String getVer() {
            return this.ver;
        }
    }
}
