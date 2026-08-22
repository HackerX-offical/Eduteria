package org.jivesoftware.smackx.pubsub;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import java.util.concurrent.ConcurrentHashMap;
import org.jivesoftware.smack.SmackException;
import org.jivesoftware.smack.StanzaListener;
import org.jivesoftware.smack.XMPPConnection;
import org.jivesoftware.smack.XMPPException;
import org.jivesoftware.smack.filter.FlexibleStanzaTypeFilter;
import org.jivesoftware.smack.filter.OrFilter;
import org.jivesoftware.smack.packet.ExtensionElement;
import org.jivesoftware.smack.packet.IQ;
import org.jivesoftware.smack.packet.Message;
import org.jivesoftware.smack.packet.NamedElement;
import org.jivesoftware.smack.packet.Stanza;
import org.jivesoftware.smackx.delay.DelayInformationManager;
import org.jivesoftware.smackx.disco.packet.DiscoverInfo;
import org.jivesoftware.smackx.disco.packet.DiscoverInfoBuilder;
import org.jivesoftware.smackx.message_retraction.element.RetractElement;
import org.jivesoftware.smackx.pubsub.Affiliation;
import org.jivesoftware.smackx.pubsub.SubscriptionsExtension;
import org.jivesoftware.smackx.pubsub.form.ConfigureForm;
import org.jivesoftware.smackx.pubsub.form.FillableConfigureForm;
import org.jivesoftware.smackx.pubsub.form.FillableSubscribeForm;
import org.jivesoftware.smackx.pubsub.form.SubscribeForm;
import org.jivesoftware.smackx.pubsub.listener.ItemDeleteListener;
import org.jivesoftware.smackx.pubsub.listener.ItemEventListener;
import org.jivesoftware.smackx.pubsub.listener.NodeConfigListener;
import org.jivesoftware.smackx.pubsub.packet.PubSub;
import org.jivesoftware.smackx.pubsub.packet.PubSubNamespace;
import org.jivesoftware.smackx.pubsub.util.NodeUtils;
import org.jivesoftware.smackx.shim.packet.Header;
import org.jivesoftware.smackx.shim.packet.HeadersExtension;
import org.jivesoftware.smackx.xdata.packet.DataForm;
import org.jxmpp.jid.Jid;
import org.jxmpp.jid.impl.JidCreate;
import org.jxmpp.stringprep.XmppStringprepException;

/* JADX INFO: loaded from: classes10.dex */
public abstract class Node {
    protected final String id;
    protected final PubSubManager pubSubManager;
    protected ConcurrentHashMap<ItemEventListener<Item>, StanzaListener> itemEventToListenerMap = new ConcurrentHashMap<>();
    protected ConcurrentHashMap<ItemDeleteListener, StanzaListener> itemDeleteToListenerMap = new ConcurrentHashMap<>();
    protected ConcurrentHashMap<NodeConfigListener, StanzaListener> configEventToListenerMap = new ConcurrentHashMap<>();

    Node(PubSubManager pubSubManager, String str) {
        this.pubSubManager = pubSubManager;
        this.id = str;
    }

    public String getId() {
        return this.id;
    }

    public ConfigureForm getNodeConfiguration() throws SmackException.NotConnectedException, SmackException.NoResponseException, InterruptedException, XMPPException.XMPPErrorException {
        return NodeUtils.getFormFromPacket(sendPubsubPacket(createPubsubPacket(IQ.Type.get, new NodeExtension(PubSubElementType.CONFIGURE_OWNER, getId()))), PubSubElementType.CONFIGURE_OWNER);
    }

    public void sendConfigurationForm(FillableConfigureForm fillableConfigureForm) throws SmackException.NotConnectedException, SmackException.NoResponseException, InterruptedException, XMPPException.XMPPErrorException {
        this.pubSubManager.getConnection().createStanzaCollectorAndSend(createPubsubPacket(IQ.Type.set, new FormNode(FormNodeType.CONFIGURE_OWNER, getId(), fillableConfigureForm.getDataFormToSubmit()))).nextResultOrThrow();
    }

    /* JADX WARN: Multi-variable type inference failed */
    public DiscoverInfo discoverInfo() throws SmackException.NotConnectedException, SmackException.NoResponseException, InterruptedException, XMPPException.XMPPErrorException {
        XMPPConnection connection = this.pubSubManager.getConnection();
        return (DiscoverInfo) connection.createStanzaCollectorAndSend(((DiscoverInfoBuilder) DiscoverInfo.builder(connection).to((Jid) this.pubSubManager.getServiceJid())).setNode(getId()).build()).nextResultOrThrow();
    }

    public List<Subscription> getSubscriptions() throws SmackException.NotConnectedException, SmackException.NoResponseException, InterruptedException, XMPPException.XMPPErrorException {
        return getSubscriptions(null, null);
    }

    public List<Subscription> getSubscriptions(List<ExtensionElement> list, Collection<ExtensionElement> collection) throws SmackException.NotConnectedException, SmackException.NoResponseException, InterruptedException, XMPPException.XMPPErrorException {
        return getSubscriptions(SubscriptionsExtension.SubscriptionsNamespace.basic, list, collection);
    }

    public List<Subscription> getSubscriptionsAsOwner() throws SmackException.NotConnectedException, SmackException.NoResponseException, InterruptedException, XMPPException.XMPPErrorException {
        return getSubscriptionsAsOwner(null, null);
    }

    public List<Subscription> getSubscriptionsAsOwner(List<ExtensionElement> list, Collection<ExtensionElement> collection) throws SmackException.NotConnectedException, SmackException.NoResponseException, InterruptedException, XMPPException.XMPPErrorException {
        return getSubscriptions(SubscriptionsExtension.SubscriptionsNamespace.owner, list, collection);
    }

    private List<Subscription> getSubscriptions(SubscriptionsExtension.SubscriptionsNamespace subscriptionsNamespace, List<ExtensionElement> list, Collection<ExtensionElement> collection) throws SmackException.NotConnectedException, SmackException.NoResponseException, InterruptedException, XMPPException.XMPPErrorException {
        PubSubElementType pubSubElementType = subscriptionsNamespace.type;
        PubSub pubSubCreatePubsubPacket = createPubsubPacket(IQ.Type.get, new NodeExtension(pubSubElementType, getId()));
        if (list != null) {
            Iterator<ExtensionElement> it = list.iterator();
            while (it.hasNext()) {
                pubSubCreatePubsubPacket.addExtension(it.next());
            }
        }
        PubSub pubSubSendPubsubPacket = sendPubsubPacket(pubSubCreatePubsubPacket);
        if (collection != null) {
            collection.addAll(pubSubSendPubsubPacket.getExtensions());
        }
        return ((SubscriptionsExtension) pubSubSendPubsubPacket.getExtension(pubSubElementType)).getSubscriptions();
    }

    public PubSub modifySubscriptionsAsOwner(List<Subscription> list) throws SmackException.NotConnectedException, SmackException.NoResponseException, InterruptedException, XMPPException.XMPPErrorException {
        return sendPubsubPacket(createPubsubPacket(IQ.Type.set, new SubscriptionsExtension(SubscriptionsExtension.SubscriptionsNamespace.owner, getId(), list)));
    }

    public List<Affiliation> getAffiliations() throws SmackException.NotConnectedException, SmackException.NoResponseException, InterruptedException, XMPPException.XMPPErrorException {
        return getAffiliations(null, null);
    }

    public List<Affiliation> getAffiliations(List<ExtensionElement> list, Collection<ExtensionElement> collection) throws SmackException.NotConnectedException, SmackException.NoResponseException, InterruptedException, XMPPException.XMPPErrorException {
        return getAffiliations(Affiliation.AffiliationNamespace.basic, list, collection);
    }

    public List<Affiliation> getAffiliationsAsOwner() throws SmackException.NotConnectedException, SmackException.NoResponseException, InterruptedException, XMPPException.XMPPErrorException {
        return getAffiliationsAsOwner(null, null);
    }

    public List<Affiliation> getAffiliationsAsOwner(List<ExtensionElement> list, Collection<ExtensionElement> collection) throws SmackException.NotConnectedException, SmackException.NoResponseException, InterruptedException, XMPPException.XMPPErrorException {
        return getAffiliations(Affiliation.AffiliationNamespace.owner, list, collection);
    }

    private List<Affiliation> getAffiliations(Affiliation.AffiliationNamespace affiliationNamespace, List<ExtensionElement> list, Collection<ExtensionElement> collection) throws SmackException.NotConnectedException, SmackException.NoResponseException, InterruptedException, XMPPException.XMPPErrorException {
        PubSubElementType pubSubElementType = affiliationNamespace.type;
        PubSub pubSubCreatePubsubPacket = createPubsubPacket(IQ.Type.get, new NodeExtension(pubSubElementType, getId()));
        if (list != null) {
            Iterator<ExtensionElement> it = list.iterator();
            while (it.hasNext()) {
                pubSubCreatePubsubPacket.addExtension(it.next());
            }
        }
        PubSub pubSubSendPubsubPacket = sendPubsubPacket(pubSubCreatePubsubPacket);
        if (collection != null) {
            collection.addAll(pubSubSendPubsubPacket.getExtensions());
        }
        return ((AffiliationsExtension) pubSubSendPubsubPacket.getExtension(pubSubElementType)).getAffiliations();
    }

    public PubSub modifyAffiliationAsOwner(List<Affiliation> list) throws SmackException.NotConnectedException, SmackException.NoResponseException, InterruptedException, XMPPException.XMPPErrorException {
        Iterator<Affiliation> it = list.iterator();
        while (it.hasNext()) {
            if (it.next().getPubSubNamespace() != PubSubNamespace.owner) {
                throw new IllegalArgumentException("Must use Affiliation(BareJid, Type) affiliations");
            }
        }
        return sendPubsubPacket(createPubsubPacket(IQ.Type.set, new AffiliationsExtension(Affiliation.AffiliationNamespace.owner, list, getId())));
    }

    public Subscription subscribe(Jid jid) throws SmackException.NotConnectedException, SmackException.NoResponseException, InterruptedException, XMPPException.XMPPErrorException {
        return (Subscription) sendPubsubPacket(createPubsubPacket(IQ.Type.set, new SubscribeExtension(jid, getId()))).getExtension(PubSubElementType.SUBSCRIPTION);
    }

    @Deprecated
    public Subscription subscribe(String str) throws SmackException.NotConnectedException, SmackException.NoResponseException, InterruptedException, XMPPException.XMPPErrorException {
        try {
            return subscribe(JidCreate.from(str));
        } catch (XmppStringprepException e2) {
            throw new IllegalArgumentException(e2);
        }
    }

    public Subscription subscribe(Jid jid, FillableSubscribeForm fillableSubscribeForm) throws SmackException.NotConnectedException, SmackException.NoResponseException, InterruptedException, XMPPException.XMPPErrorException {
        DataForm dataFormToSubmit = fillableSubscribeForm.getDataFormToSubmit();
        PubSub pubSubCreatePubsubPacket = createPubsubPacket(IQ.Type.set, new SubscribeExtension(jid, getId()));
        pubSubCreatePubsubPacket.addExtension(new FormNode(FormNodeType.OPTIONS, dataFormToSubmit));
        return (Subscription) sendPubsubPacket(pubSubCreatePubsubPacket).getExtension(PubSubElementType.SUBSCRIPTION);
    }

    @Deprecated
    public Subscription subscribe(String str, FillableSubscribeForm fillableSubscribeForm) throws SmackException.NotConnectedException, SmackException.NoResponseException, InterruptedException, XMPPException.XMPPErrorException {
        try {
            return subscribe(JidCreate.from(str), fillableSubscribeForm);
        } catch (XmppStringprepException e2) {
            throw new IllegalArgumentException(e2);
        }
    }

    public void unsubscribe(String str) throws SmackException.NotConnectedException, SmackException.NoResponseException, InterruptedException, XMPPException.XMPPErrorException {
        unsubscribe(str, null);
    }

    public void unsubscribe(String str, String str2) throws SmackException.NotConnectedException, SmackException.NoResponseException, InterruptedException, XMPPException.XMPPErrorException {
        sendPubsubPacket(createPubsubPacket(IQ.Type.set, new UnsubscribeExtension(str, getId(), str2)));
    }

    public SubscribeForm getSubscriptionOptions(String str) throws SmackException.NotConnectedException, SmackException.NoResponseException, InterruptedException, XMPPException.XMPPErrorException {
        return getSubscriptionOptions(str, null);
    }

    public SubscribeForm getSubscriptionOptions(String str, String str2) throws SmackException.NotConnectedException, SmackException.NoResponseException, InterruptedException, XMPPException.XMPPErrorException {
        return new SubscribeForm(((FormNode) sendPubsubPacket(createPubsubPacket(IQ.Type.get, new OptionsExtension(str, getId(), str2))).getExtension(PubSubElementType.OPTIONS)).getForm());
    }

    public void addItemEventListener(ItemEventListener itemEventListener) {
        ItemEventTranslator itemEventTranslator = new ItemEventTranslator(itemEventListener);
        this.itemEventToListenerMap.put(itemEventListener, itemEventTranslator);
        this.pubSubManager.getConnection().addSyncStanzaListener(itemEventTranslator, new EventContentFilter(EventElementType.items.toString(), "item"));
    }

    public void removeItemEventListener(ItemEventListener itemEventListener) {
        StanzaListener stanzaListenerRemove = this.itemEventToListenerMap.remove(itemEventListener);
        if (stanzaListenerRemove != null) {
            this.pubSubManager.getConnection().removeSyncStanzaListener(stanzaListenerRemove);
        }
    }

    public void addConfigurationListener(NodeConfigListener nodeConfigListener) {
        NodeConfigTranslator nodeConfigTranslator = new NodeConfigTranslator(nodeConfigListener);
        this.configEventToListenerMap.put(nodeConfigListener, nodeConfigTranslator);
        this.pubSubManager.getConnection().addSyncStanzaListener(nodeConfigTranslator, new EventContentFilter(this, EventElementType.configuration.toString()));
    }

    public void removeConfigurationListener(NodeConfigListener nodeConfigListener) {
        StanzaListener stanzaListenerRemove = this.configEventToListenerMap.remove(nodeConfigListener);
        if (stanzaListenerRemove != null) {
            this.pubSubManager.getConnection().removeSyncStanzaListener(stanzaListenerRemove);
        }
    }

    public void addItemDeleteListener(ItemDeleteListener itemDeleteListener) {
        ItemDeleteTranslator itemDeleteTranslator = new ItemDeleteTranslator(itemDeleteListener);
        this.itemDeleteToListenerMap.put(itemDeleteListener, itemDeleteTranslator);
        this.pubSubManager.getConnection().addSyncStanzaListener(itemDeleteTranslator, new OrFilter(new EventContentFilter(EventElementType.items.toString(), RetractElement.ELEMENT), new EventContentFilter(this, EventElementType.purge.toString())));
    }

    public void removeItemDeleteListener(ItemDeleteListener itemDeleteListener) {
        StanzaListener stanzaListenerRemove = this.itemDeleteToListenerMap.remove(itemDeleteListener);
        if (stanzaListenerRemove != null) {
            this.pubSubManager.getConnection().removeSyncStanzaListener(stanzaListenerRemove);
        }
    }

    public String toString() {
        return super.toString() + " " + getClass().getName() + " id: " + this.id;
    }

    protected PubSub createPubsubPacket(IQ.Type type, NodeExtension nodeExtension) {
        return PubSub.createPubsubPacket(this.pubSubManager.getServiceJid(), type, nodeExtension);
    }

    protected PubSub sendPubsubPacket(PubSub pubSub) throws SmackException.NotConnectedException, SmackException.NoResponseException, InterruptedException, XMPPException.XMPPErrorException {
        return this.pubSubManager.sendPubsubPacket(pubSub);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static List<String> getSubscriptionIds(Stanza stanza) {
        HeadersExtension headersExtension = (HeadersExtension) stanza.getExtension(HeadersExtension.class);
        if (headersExtension == null) {
            return null;
        }
        ArrayList arrayList = new ArrayList(headersExtension.getHeaders().size());
        Iterator<Header> it = headersExtension.getHeaders().iterator();
        while (it.hasNext()) {
            arrayList.add(it.next().getValue());
        }
        return arrayList;
    }

    public static class ItemEventTranslator implements StanzaListener {
        private final ItemEventListener listener;

        public ItemEventTranslator(ItemEventListener itemEventListener) {
            this.listener = itemEventListener;
        }

        @Override // org.jivesoftware.smack.StanzaListener
        public void processStanza(Stanza stanza) {
            ItemsExtension itemsExtension = (ItemsExtension) ((EventElement) stanza.getExtensionElement("event", PubSubNamespace.event.getXmlns())).getEvent();
            this.listener.handlePublishedItems(new ItemPublishEvent(itemsExtension.getNode(), itemsExtension.getItems(), Node.getSubscriptionIds(stanza), DelayInformationManager.getDelayTimestamp(stanza)));
        }
    }

    public static class ItemDeleteTranslator implements StanzaListener {
        private final ItemDeleteListener listener;

        public ItemDeleteTranslator(ItemDeleteListener itemDeleteListener) {
            this.listener = itemDeleteListener;
        }

        @Override // org.jivesoftware.smack.StanzaListener
        public void processStanza(Stanza stanza) {
            EventElement eventElement = (EventElement) stanza.getExtensionElement("event", PubSubNamespace.event.getXmlns());
            if (eventElement.getExtensions().get(0).getElementName().equals(PubSubElementType.PURGE_EVENT.getElementName())) {
                this.listener.handlePurge();
                return;
            }
            ItemsExtension itemsExtension = (ItemsExtension) eventElement.getEvent();
            List<? extends NamedElement> items = itemsExtension.getItems();
            ArrayList arrayList = new ArrayList(items.size());
            Iterator<? extends NamedElement> it = items.iterator();
            while (it.hasNext()) {
                arrayList.add(((RetractItem) it.next()).getId());
            }
            this.listener.handleDeletedItems(new ItemDeleteEvent(itemsExtension.getNode(), arrayList, Node.getSubscriptionIds(stanza)));
        }
    }

    public static class NodeConfigTranslator implements StanzaListener {
        private final NodeConfigListener listener;

        public NodeConfigTranslator(NodeConfigListener nodeConfigListener) {
            this.listener = nodeConfigListener;
        }

        @Override // org.jivesoftware.smack.StanzaListener
        public void processStanza(Stanza stanza) {
            this.listener.handleNodeConfiguration((ConfigurationEvent) ((EventElement) stanza.getExtensionElement("event", PubSubNamespace.event.getXmlns())).getEvent());
        }
    }

    class EventContentFilter extends FlexibleStanzaTypeFilter<Message> {
        private final boolean allowEmpty;
        private final String firstElement;
        private final String secondElement;

        EventContentFilter(Node node, String str) {
            this(str, null);
        }

        EventContentFilter(String str, String str2) {
            this.firstElement = str;
            this.secondElement = str2;
            this.allowEmpty = str.equals(EventElementType.items.toString()) && "item".equals(str2);
        }

        /* JADX WARN: Multi-variable type inference failed */
        @Override // org.jivesoftware.smack.filter.FlexibleStanzaTypeFilter
        public boolean acceptSpecific(Message message) {
            NodeExtension event;
            EventElement eventElementFrom = EventElement.from(message);
            if (eventElementFrom == null || (event = eventElementFrom.getEvent()) == 0 || !event.getElementName().equals(this.firstElement) || !event.getNode().equals(Node.this.getId())) {
                return false;
            }
            if (this.secondElement == null) {
                return true;
            }
            if (event instanceof EmbeddedPacketExtension) {
                List<ExtensionElement> extensions = ((EmbeddedPacketExtension) event).getExtensions();
                if (this.allowEmpty && extensions.isEmpty()) {
                    return true;
                }
                if (extensions.size() > 0 && extensions.get(0).getElementName().equals(this.secondElement)) {
                    return true;
                }
            }
            return false;
        }
    }
}
