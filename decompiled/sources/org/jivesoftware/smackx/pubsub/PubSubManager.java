package org.jivesoftware.smackx.pubsub;

import androidx.core.app.NotificationCompat;
import java.util.Collections;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.WeakHashMap;
import java.util.concurrent.ConcurrentHashMap;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.xml.namespace.QName;
import org.jivesoftware.smack.Manager;
import org.jivesoftware.smack.SmackException;
import org.jivesoftware.smack.XMPPConnection;
import org.jivesoftware.smack.XMPPException;
import org.jivesoftware.smack.packet.EmptyResultIQ;
import org.jivesoftware.smack.packet.ExtensionElement;
import org.jivesoftware.smack.packet.IQ;
import org.jivesoftware.smack.packet.StanzaError;
import org.jivesoftware.smack.util.StringUtils;
import org.jivesoftware.smackx.disco.ServiceDiscoveryManager;
import org.jivesoftware.smackx.disco.packet.DiscoverInfo;
import org.jivesoftware.smackx.disco.packet.DiscoverInfoBuilder;
import org.jivesoftware.smackx.disco.packet.DiscoverItems;
import org.jivesoftware.smackx.pubsub.PubSubException;
import org.jivesoftware.smackx.pubsub.form.ConfigureForm;
import org.jivesoftware.smackx.pubsub.form.FillableConfigureForm;
import org.jivesoftware.smackx.pubsub.packet.PubSub;
import org.jivesoftware.smackx.pubsub.packet.PubSubNamespace;
import org.jivesoftware.smackx.pubsub.util.NodeUtils;
import org.jxmpp.jid.BareJid;
import org.jxmpp.jid.DomainBareJid;
import org.jxmpp.jid.Jid;
import org.jxmpp.jid.impl.JidCreate;
import org.jxmpp.stringprep.XmppStringprepException;

/* JADX INFO: loaded from: classes10.dex */
public final class PubSubManager extends Manager {
    public static final String AUTO_CREATE_FEATURE = "http://jabber.org/protocol/pubsub#auto-create";
    public static final String PLUS_NOTIFY = "+notify";
    private final Map<String, Node> nodeMap;
    private final BareJid pubSubService;
    private static final Logger LOGGER = Logger.getLogger(PubSubManager.class.getName());
    private static final Map<XMPPConnection, Map<BareJid, PubSubManager>> INSTANCES = new WeakHashMap();

    public static PubSubManager getInstanceFor(XMPPConnection xMPPConnection) {
        DomainBareJid pubSubService;
        if (xMPPConnection.isAuthenticated()) {
            try {
                pubSubService = getPubSubService(xMPPConnection);
            } catch (InterruptedException e2) {
                LOGGER.log(Level.FINE, "Interrupted while trying to determine PubSub service", (Throwable) e2);
                pubSubService = null;
            } catch (SmackException.NoResponseException e3) {
                e = e3;
                LOGGER.log(Level.WARNING, "Could not determine PubSub service", e);
                pubSubService = null;
            } catch (SmackException.NotConnectedException e4) {
                e = e4;
                LOGGER.log(Level.WARNING, "Could not determine PubSub service", e);
                pubSubService = null;
            } catch (XMPPException.XMPPErrorException e5) {
                e = e5;
                LOGGER.log(Level.WARNING, "Could not determine PubSub service", e);
                pubSubService = null;
            }
        } else {
            pubSubService = null;
        }
        if (pubSubService == null) {
            try {
                pubSubService = JidCreate.domainBareFrom("pubsub." + ((Object) xMPPConnection.getXMPPServiceDomain()));
            } catch (XmppStringprepException e6) {
                throw new RuntimeException(e6);
            }
        }
        return getInstanceFor(xMPPConnection, pubSubService);
    }

    public static PubSubManager getInstanceFor(XMPPConnection xMPPConnection, BareJid bareJid) {
        Map<BareJid, PubSubManager> map;
        PubSubManager pubSubManager;
        if (bareJid != null && xMPPConnection.isAuthenticated() && xMPPConnection.getUser().asBareJid().equals((CharSequence) bareJid)) {
            bareJid = null;
        }
        Map<XMPPConnection, Map<BareJid, PubSubManager>> map2 = INSTANCES;
        synchronized (map2) {
            map = map2.get(xMPPConnection);
            if (map == null) {
                map = new HashMap<>();
                map2.put(xMPPConnection, map);
            }
        }
        synchronized (map) {
            pubSubManager = map.get(bareJid);
            if (pubSubManager == null) {
                pubSubManager = new PubSubManager(xMPPConnection, bareJid);
                map.put(bareJid, pubSubManager);
            }
        }
        return pubSubManager;
    }

    @Deprecated
    public static PubSubManager getInstance(XMPPConnection xMPPConnection) {
        return getInstanceFor(xMPPConnection);
    }

    @Deprecated
    public static PubSubManager getInstance(XMPPConnection xMPPConnection, BareJid bareJid) {
        return getInstanceFor(xMPPConnection, bareJid);
    }

    PubSubManager(XMPPConnection xMPPConnection, BareJid bareJid) {
        super(xMPPConnection);
        this.nodeMap = new ConcurrentHashMap();
        this.pubSubService = bareJid;
    }

    private void checkIfXmppErrorBecauseOfNotLeafNode(String str, XMPPException.XMPPErrorException xMPPErrorException) throws PubSubException.NotALeafNodeException, XMPPException.XMPPErrorException {
        if (xMPPErrorException.getStanzaError().getCondition() == StanzaError.Condition.feature_not_implemented) {
            throw new PubSubException.NotALeafNodeException(str, this.pubSubService);
        }
        throw xMPPErrorException;
    }

    public LeafNode createNode() throws SmackException.NotConnectedException, SmackException.NoResponseException, InterruptedException, XMPPException.XMPPErrorException {
        LeafNode leafNode = new LeafNode(this, ((NodeExtension) sendPubsubPacket(IQ.Type.set, new NodeExtension(PubSubElementType.CREATE), null).getExtension(new QName(PubSubNamespace.basic.getXmlns(), "create"))).getNode());
        this.nodeMap.put(leafNode.getId(), leafNode);
        return leafNode;
    }

    public LeafNode createNode(String str) throws SmackException.NotConnectedException, SmackException.NoResponseException, InterruptedException, XMPPException.XMPPErrorException {
        return (LeafNode) createNode(str, null);
    }

    public Node createNode(String str, FillableConfigureForm fillableConfigureForm) throws SmackException.NotConnectedException, SmackException.NoResponseException, InterruptedException, XMPPException.XMPPErrorException {
        PubSub pubSubCreatePubsubPacket = PubSub.createPubsubPacket(this.pubSubService, IQ.Type.set, new NodeExtension(PubSubElementType.CREATE, str));
        boolean z = true;
        if (fillableConfigureForm != null) {
            pubSubCreatePubsubPacket.addExtension(new FormNode(FormNodeType.CONFIGURE, fillableConfigureForm.getDataFormToSubmit()));
            NodeType nodeType = fillableConfigureForm.getNodeType();
            if (nodeType != null && nodeType != NodeType.leaf) {
                z = false;
            }
        }
        sendPubsubPacket(pubSubCreatePubsubPacket);
        Node leafNode = z ? new LeafNode(this, str) : new CollectionNode(this, str);
        this.nodeMap.put(leafNode.getId(), leafNode);
        return leafNode;
    }

    /* JADX WARN: Multi-variable type inference failed */
    public Node getNode(String str) throws SmackException.NotConnectedException, SmackException.NoResponseException, PubSubException.NotAPubSubNodeException, InterruptedException, XMPPException.XMPPErrorException {
        Node collectionNode;
        StringUtils.requireNotNullNorEmpty(str, "The node ID can not be null or the empty string");
        Node node = this.nodeMap.get(str);
        if (node != null) {
            return node;
        }
        XMPPConnection xMPPConnectionConnection = connection();
        DiscoverInfo discoverInfo = (DiscoverInfo) xMPPConnectionConnection.createStanzaCollectorAndSend(((DiscoverInfoBuilder) DiscoverInfo.builder(xMPPConnectionConnection).to((Jid) this.pubSubService)).setNode(str).build()).nextResultOrThrow();
        if (discoverInfo.hasIdentity("pubsub", "leaf")) {
            collectionNode = new LeafNode(this, str);
        } else if (discoverInfo.hasIdentity("pubsub", "collection")) {
            collectionNode = new CollectionNode(this, str);
        } else {
            throw new PubSubException.NotAPubSubNodeException(str, discoverInfo);
        }
        this.nodeMap.put(str, collectionNode);
        return collectionNode;
    }

    public LeafNode getOrCreateLeafNode(String str) throws SmackException.NotConnectedException, SmackException.NoResponseException, InterruptedException, PubSubException.NotALeafNodeException, XMPPException.XMPPErrorException {
        try {
            return getLeafNode(str);
        } catch (XMPPException.XMPPErrorException e2) {
            if (e2.getStanzaError().getCondition() == StanzaError.Condition.item_not_found) {
                try {
                    return createNode(str);
                } catch (XMPPException.XMPPErrorException e3) {
                    if (e3.getStanzaError().getCondition() == StanzaError.Condition.conflict) {
                        try {
                            return getLeafNode(str);
                        } catch (PubSubException.NotAPubSubNodeException e4) {
                            throw new IllegalStateException(e4);
                        }
                    }
                    throw e3;
                }
            }
            if (e2.getStanzaError().getCondition() == StanzaError.Condition.service_unavailable) {
                LOGGER.warning("The PubSub service " + ((Object) this.pubSubService) + " threw an DiscoInfoNodeAssertionError, trying workaround for Prosody bug #805 (https://prosody.im/issues/issue/805)");
                return getOrCreateLeafNodeProsodyWorkaround(str);
            }
            throw e2;
        } catch (PubSubException.NotAPubSubNodeException unused) {
            return createNode(str);
        }
    }

    public LeafNode getLeafNode(String str) throws SmackException.NotConnectedException, SmackException.NoResponseException, PubSubException.NotAPubSubNodeException, InterruptedException, PubSubException.NotALeafNodeException, XMPPException.XMPPErrorException {
        try {
            Node node = getNode(str);
            if (node instanceof LeafNode) {
                return (LeafNode) node;
            }
            throw new PubSubException.NotALeafNodeException(str, this.pubSubService);
        } catch (XMPPException.XMPPErrorException e2) {
            if (e2.getStanzaError().getCondition() == StanzaError.Condition.service_unavailable) {
                return getLeafNodeProsodyWorkaround(str);
            }
            throw e2;
        }
    }

    private LeafNode getLeafNodeProsodyWorkaround(String str) throws SmackException.NotConnectedException, SmackException.NoResponseException, InterruptedException, PubSubException.NotALeafNodeException, XMPPException.XMPPErrorException {
        LeafNode leafNode = new LeafNode(this, str);
        try {
            leafNode.getItems(1);
        } catch (XMPPException.XMPPErrorException e2) {
            checkIfXmppErrorBecauseOfNotLeafNode(str, e2);
        }
        this.nodeMap.put(str, leafNode);
        return leafNode;
    }

    private LeafNode getOrCreateLeafNodeProsodyWorkaround(String str) throws SmackException.NotConnectedException, SmackException.NoResponseException, InterruptedException, PubSubException.NotALeafNodeException, XMPPException.XMPPErrorException {
        try {
            return createNode(str);
        } catch (XMPPException.XMPPErrorException e2) {
            if (e2.getStanzaError().getCondition() == StanzaError.Condition.conflict) {
                return getLeafNodeProsodyWorkaround(str);
            }
            throw e2;
        }
    }

    public <I extends Item> LeafNode tryToPublishAndPossibleAutoCreate(String str, I i) throws SmackException.NotConnectedException, SmackException.NoResponseException, InterruptedException, PubSubException.NotALeafNodeException, XMPPException.XMPPErrorException {
        LeafNode leafNode = new LeafNode(this, str);
        try {
            leafNode.publish(i);
        } catch (XMPPException.XMPPErrorException e2) {
            checkIfXmppErrorBecauseOfNotLeafNode(str, e2);
        }
        this.nodeMap.put(str, leafNode);
        return leafNode;
    }

    public DiscoverItems discoverNodes(String str) throws SmackException.NotConnectedException, SmackException.NoResponseException, InterruptedException, XMPPException.XMPPErrorException {
        DiscoverItems discoverItems = new DiscoverItems();
        if (str != null) {
            discoverItems.setNode(str);
        }
        discoverItems.setTo(this.pubSubService);
        return (DiscoverItems) connection().createStanzaCollectorAndSend(discoverItems).nextResultOrThrow();
    }

    public List<Subscription> getSubscriptions() throws SmackException.NotConnectedException, SmackException.NoResponseException, InterruptedException, XMPPException.XMPPErrorException {
        return ((SubscriptionsExtension) sendPubsubPacket(IQ.Type.get, new NodeExtension(PubSubElementType.SUBSCRIPTIONS), null).getExtensionElement(PubSubElementType.SUBSCRIPTIONS.getElementName(), PubSubElementType.SUBSCRIPTIONS.getNamespace().getXmlns())).getSubscriptions();
    }

    public List<Affiliation> getAffiliations() throws SmackException.NotConnectedException, SmackException.NoResponseException, InterruptedException, XMPPException.XMPPErrorException {
        return ((AffiliationsExtension) sendPubsubPacket(IQ.Type.get, new NodeExtension(PubSubElementType.AFFILIATIONS), null).getExtension(PubSubElementType.AFFILIATIONS)).getAffiliations();
    }

    public boolean deleteNode(String str) throws SmackException.NotConnectedException, SmackException.NoResponseException, InterruptedException, XMPPException.XMPPErrorException {
        boolean z;
        try {
            sendPubsubPacket(IQ.Type.set, new NodeExtension(PubSubElementType.DELETE, str), PubSubElementType.DELETE.getNamespace());
            z = true;
        } catch (XMPPException.XMPPErrorException e2) {
            if (e2.getStanzaError().getCondition() != StanzaError.Condition.item_not_found) {
                throw e2;
            }
            z = false;
        }
        this.nodeMap.remove(str);
        return z;
    }

    public ConfigureForm getDefaultConfiguration() throws SmackException.NotConnectedException, SmackException.NoResponseException, InterruptedException, XMPPException.XMPPErrorException {
        return NodeUtils.getFormFromPacket(sendPubsubPacket(IQ.Type.get, new NodeExtension(PubSubElementType.DEFAULT), PubSubElementType.DEFAULT.getNamespace()), PubSubElementType.DEFAULT);
    }

    public BareJid getServiceJid() {
        return this.pubSubService;
    }

    public DiscoverInfo getSupportedFeatures() throws SmackException.NotConnectedException, SmackException.NoResponseException, InterruptedException, XMPPException.XMPPErrorException {
        return ServiceDiscoveryManager.getInstanceFor(connection()).discoverInfo(this.pubSubService);
    }

    public boolean supportsAutomaticNodeCreation() throws SmackException.NotConnectedException, SmackException.NoResponseException, InterruptedException, XMPPException.XMPPErrorException {
        return ServiceDiscoveryManager.getInstanceFor(connection()).supportsFeature(this.pubSubService, AUTO_CREATE_FEATURE);
    }

    public boolean canCreateNodesAndPublishItems() throws SmackException.NotConnectedException, SmackException.NoResponseException, InterruptedException, XMPPException.XMPPErrorException {
        try {
            LeafNode leafNodeCreateNode = createNode();
            if (leafNodeCreateNode == null) {
                return true;
            }
            deleteNode(leafNodeCreateNode.getId());
            return true;
        } catch (XMPPException.XMPPErrorException e2) {
            if (e2.getStanzaError().getCondition() == StanzaError.Condition.forbidden) {
                return false;
            }
            throw e2;
        }
    }

    private PubSub sendPubsubPacket(IQ.Type type, ExtensionElement extensionElement, PubSubNamespace pubSubNamespace) throws SmackException.NotConnectedException, SmackException.NoResponseException, InterruptedException, XMPPException.XMPPErrorException {
        return sendPubsubPacket(this.pubSubService, type, Collections.singletonList(extensionElement), pubSubNamespace);
    }

    XMPPConnection getConnection() {
        return connection();
    }

    PubSub sendPubsubPacket(Jid jid, IQ.Type type, List<ExtensionElement> list, PubSubNamespace pubSubNamespace) throws SmackException.NotConnectedException, SmackException.NoResponseException, InterruptedException, XMPPException.XMPPErrorException {
        PubSub pubSub = new PubSub(jid, type, pubSubNamespace);
        Iterator<ExtensionElement> it = list.iterator();
        while (it.hasNext()) {
            pubSub.addExtension(it.next());
        }
        return sendPubsubPacket(pubSub);
    }

    PubSub sendPubsubPacket(PubSub pubSub) throws SmackException.NotConnectedException, SmackException.NoResponseException, InterruptedException, XMPPException.XMPPErrorException {
        IQ iq = (IQ) connection().createStanzaCollectorAndSend(pubSub).nextResultOrThrow();
        if (iq instanceof EmptyResultIQ) {
            return null;
        }
        return (PubSub) iq;
    }

    public static DomainBareJid getPubSubService(XMPPConnection xMPPConnection) throws SmackException.NotConnectedException, SmackException.NoResponseException, InterruptedException, XMPPException.XMPPErrorException {
        return ServiceDiscoveryManager.getInstanceFor(xMPPConnection).findService("http://jabber.org/protocol/pubsub", true, "pubsub", NotificationCompat.CATEGORY_SERVICE);
    }
}
