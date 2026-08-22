package org.jivesoftware.smackx.pep;

import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.WeakHashMap;
import java.util.concurrent.CopyOnWriteArraySet;
import java.util.logging.Logger;
import org.jivesoftware.smack.AsyncButOrdered;
import org.jivesoftware.smack.Manager;
import org.jivesoftware.smack.SmackException;
import org.jivesoftware.smack.StanzaListener;
import org.jivesoftware.smack.XMPPConnection;
import org.jivesoftware.smack.XMPPException;
import org.jivesoftware.smack.filter.AndFilter;
import org.jivesoftware.smack.filter.MessageTypeFilter;
import org.jivesoftware.smack.filter.StanzaFilter;
import org.jivesoftware.smack.filter.jidtype.FromJidTypeFilter;
import org.jivesoftware.smack.packet.ExtensionElement;
import org.jivesoftware.smack.packet.Message;
import org.jivesoftware.smack.packet.NamedElement;
import org.jivesoftware.smack.packet.Stanza;
import org.jivesoftware.smack.util.CollectionUtil;
import org.jivesoftware.smack.util.MultiMap;
import org.jivesoftware.smackx.disco.ServiceDiscoveryManager;
import org.jivesoftware.smackx.pubsub.EventElement;
import org.jivesoftware.smackx.pubsub.Item;
import org.jivesoftware.smackx.pubsub.ItemsExtension;
import org.jivesoftware.smackx.pubsub.LeafNode;
import org.jivesoftware.smackx.pubsub.PayloadItem;
import org.jivesoftware.smackx.pubsub.PubSubException;
import org.jivesoftware.smackx.pubsub.PubSubFeature;
import org.jivesoftware.smackx.pubsub.PubSubManager;
import org.jivesoftware.smackx.pubsub.filter.EventItemsExtensionFilter;
import org.jxmpp.jid.EntityBareJid;

/* JADX INFO: loaded from: classes10.dex */
public final class PepManager extends Manager {
    static final /* synthetic */ boolean $assertionsDisabled = false;
    private final AsyncButOrdered<EntityBareJid> asyncButOrdered;
    private final Map<PepEventListener<?>, PepEventListenerCoupling<?>> listenerToCouplingMap;
    private final MultiMap<String, PepEventListenerCoupling<? extends ExtensionElement>> pepEventListeners;
    private final Set<PepListener> pepListeners;
    private final PubSubManager pepPubSubManager;
    private final ServiceDiscoveryManager serviceDiscoveryManager;
    private static final Logger LOGGER = Logger.getLogger(PepManager.class.getName());
    private static final Map<XMPPConnection, PepManager> INSTANCES = new WeakHashMap();
    private static final StanzaFilter PEP_EVENTS_FILTER = new AndFilter(MessageTypeFilter.NORMAL_OR_HEADLINE, FromJidTypeFilter.ENTITY_BARE_JID, EventItemsExtensionFilter.INSTANCE);
    private static final PubSubFeature[] REQUIRED_FEATURES = {PubSubFeature.auto_create, PubSubFeature.auto_subscribe, PubSubFeature.filtered_notifications};

    public static synchronized PepManager getInstanceFor(XMPPConnection xMPPConnection) {
        PepManager pepManager;
        Map<XMPPConnection, PepManager> map = INSTANCES;
        pepManager = map.get(xMPPConnection);
        if (pepManager == null) {
            pepManager = new PepManager(xMPPConnection);
            map.put(xMPPConnection, pepManager);
        }
        return pepManager;
    }

    private PepManager(XMPPConnection xMPPConnection) {
        super(xMPPConnection);
        this.pepListeners = new CopyOnWriteArraySet();
        this.asyncButOrdered = new AsyncButOrdered<>();
        this.pepEventListeners = new MultiMap<>();
        this.listenerToCouplingMap = new HashMap();
        this.serviceDiscoveryManager = ServiceDiscoveryManager.getInstanceFor(xMPPConnection);
        this.pepPubSubManager = PubSubManager.getInstanceFor(xMPPConnection, null);
        xMPPConnection.addSyncStanzaListener(new StanzaListener() { // from class: org.jivesoftware.smackx.pep.PepManager.1
            static final /* synthetic */ boolean $assertionsDisabled = false;

            @Override // org.jivesoftware.smack.StanzaListener
            public void processStanza(Stanza stanza) {
                final Message message = (Message) stanza;
                final EventElement eventElementFrom = EventElement.from(stanza);
                final EntityBareJid entityBareJidAsEntityBareJidIfPossible = message.getFrom().asEntityBareJidIfPossible();
                PepManager.this.asyncButOrdered.performAsyncButOrdered(entityBareJidAsEntityBareJidIfPossible, new Runnable() { // from class: org.jivesoftware.smackx.pep.PepManager.1.1
                    @Override // java.lang.Runnable
                    public void run() {
                        ItemsExtension itemsExtension = (ItemsExtension) eventElementFrom.getEvent();
                        String node = itemsExtension.getNode();
                        Iterator it = PepManager.this.pepListeners.iterator();
                        while (it.hasNext()) {
                            ((PepListener) it.next()).eventReceived(entityBareJidAsEntityBareJidIfPossible, eventElementFrom, message);
                        }
                        synchronized (PepManager.this.pepEventListeners) {
                            List all = PepManager.this.pepEventListeners.getAll(node);
                            if (all.isEmpty()) {
                                return;
                            }
                            for (PepEventListenerCoupling pepEventListenerCoupling : CollectionUtil.newListWith(all)) {
                                Iterator<? extends NamedElement> it2 = itemsExtension.getItems().iterator();
                                while (it2.hasNext()) {
                                    Item item = (Item) it2.next();
                                    String id = item.getId();
                                    pepEventListenerCoupling.invoke(entityBareJidAsEntityBareJidIfPossible, ((PayloadItem) item).getPayload(), id, message);
                                }
                            }
                        }
                    }
                });
            }
        }, PEP_EVENTS_FILTER);
    }

    private static final class PepEventListenerCoupling<E extends ExtensionElement> {
        private final Class<E> extensionElementType;
        private final String node;
        private final PepEventListener<E> pepEventListener;

        private PepEventListenerCoupling(String str, Class<E> cls, PepEventListener<E> pepEventListener) {
            this.node = str;
            this.extensionElementType = cls;
            this.pepEventListener = pepEventListener;
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void invoke(EntityBareJid entityBareJid, ExtensionElement extensionElement, String str, Message message) {
            if (!this.extensionElementType.isInstance(extensionElement)) {
                PepManager.LOGGER.warning("Ignoring " + extensionElement + " from " + message + " as it is not of type " + this.extensionElementType);
            } else {
                this.pepEventListener.onPepEvent(entityBareJid, this.extensionElementType.cast(extensionElement), str, message);
            }
        }
    }

    public <E extends ExtensionElement> boolean addPepEventListener(String str, Class<E> cls, PepEventListener<E> pepEventListener) {
        PepEventListenerCoupling<? extends ExtensionElement> pepEventListenerCoupling = new PepEventListenerCoupling<>(str, cls, pepEventListener);
        synchronized (this.pepEventListeners) {
            if (this.listenerToCouplingMap.containsKey(pepEventListener)) {
                return false;
            }
            this.listenerToCouplingMap.put(pepEventListener, pepEventListenerCoupling);
            if (!this.pepEventListeners.put(str, pepEventListenerCoupling)) {
                this.serviceDiscoveryManager.addFeature(str + PubSubManager.PLUS_NOTIFY);
            }
            return true;
        }
    }

    public boolean removePepEventListener(PepEventListener<?> pepEventListener) {
        synchronized (this.pepEventListeners) {
            PepEventListenerCoupling<?> pepEventListenerCouplingRemove = this.listenerToCouplingMap.remove(pepEventListener);
            if (pepEventListenerCouplingRemove == null) {
                return false;
            }
            String str = ((PepEventListenerCoupling) pepEventListenerCouplingRemove).node;
            this.pepEventListeners.removeOne(str, (PepEventListenerCoupling<? extends ExtensionElement>) pepEventListenerCouplingRemove);
            if (!this.pepEventListeners.containsKey(((PepEventListenerCoupling) pepEventListenerCouplingRemove).node)) {
                this.serviceDiscoveryManager.removeFeature(str + PubSubManager.PLUS_NOTIFY);
            }
            return true;
        }
    }

    public PubSubManager getPepPubSubManager() {
        return this.pepPubSubManager;
    }

    @Deprecated
    public boolean addPepListener(PepListener pepListener) {
        return this.pepListeners.add(pepListener);
    }

    @Deprecated
    public boolean removePepListener(PepListener pepListener) {
        return this.pepListeners.remove(pepListener);
    }

    public LeafNode publish(String str, Item item) throws SmackException.NotConnectedException, SmackException.NoResponseException, InterruptedException, PubSubException.NotALeafNodeException, XMPPException.XMPPErrorException {
        return this.pepPubSubManager.tryToPublishAndPossibleAutoCreate(str, item);
    }

    public boolean isSupported() throws SmackException.NotConnectedException, SmackException.NoResponseException, InterruptedException, XMPPException.XMPPErrorException {
        XMPPConnection xMPPConnectionConnection = connection();
        return ServiceDiscoveryManager.getInstanceFor(xMPPConnectionConnection).supportsFeatures(xMPPConnectionConnection.getUser().asBareJid(), REQUIRED_FEATURES);
    }
}
