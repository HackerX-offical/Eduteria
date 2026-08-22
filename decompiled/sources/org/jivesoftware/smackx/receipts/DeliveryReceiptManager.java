package org.jivesoftware.smackx.receipts;

import java.util.Iterator;
import java.util.Map;
import java.util.Set;
import java.util.WeakHashMap;
import java.util.concurrent.CopyOnWriteArraySet;
import java.util.logging.Logger;
import org.jivesoftware.smack.ConnectionCreationListener;
import org.jivesoftware.smack.Manager;
import org.jivesoftware.smack.SmackException;
import org.jivesoftware.smack.StanzaListener;
import org.jivesoftware.smack.XMPPConnection;
import org.jivesoftware.smack.XMPPConnectionRegistry;
import org.jivesoftware.smack.XMPPException;
import org.jivesoftware.smack.filter.AndFilter;
import org.jivesoftware.smack.filter.MessageTypeFilter;
import org.jivesoftware.smack.filter.MessageWithBodiesFilter;
import org.jivesoftware.smack.filter.NotFilter;
import org.jivesoftware.smack.filter.StanzaExtensionFilter;
import org.jivesoftware.smack.filter.StanzaFilter;
import org.jivesoftware.smack.filter.StanzaTypeFilter;
import org.jivesoftware.smack.packet.Message;
import org.jivesoftware.smack.packet.MessageBuilder;
import org.jivesoftware.smack.packet.Stanza;
import org.jivesoftware.smack.packet.StanzaBuilder;
import org.jivesoftware.smack.roster.Roster;
import org.jivesoftware.smack.util.Predicate;
import org.jivesoftware.smack.util.StringUtils;
import org.jivesoftware.smackx.disco.ServiceDiscoveryManager;
import org.jxmpp.jid.Jid;

/* JADX INFO: loaded from: classes10.dex */
public final class DeliveryReceiptManager extends Manager {
    private static final StanzaFilter MESSAGES_TO_REQUEST_RECEIPTS_FOR;
    private static AutoReceiptMode defaultAutoReceiptMode;
    private AutoReceiptMode autoReceiptMode;
    private final Set<ReceiptReceivedListener> receiptReceivedListeners;
    private static final StanzaFilter NON_ERROR_GROUPCHAT_MESSAGES_WITH_DELIVERY_RECEIPT_REQUEST = new AndFilter(StanzaTypeFilter.MESSAGE, new StanzaExtensionFilter(new DeliveryReceiptRequest()), new NotFilter(MessageTypeFilter.ERROR));
    private static final StanzaFilter MESSAGES_WITH_DELIVERY_RECEIPT = new AndFilter(StanzaTypeFilter.MESSAGE, new StanzaExtensionFilter(DeliveryReceipt.ELEMENT, "urn:xmpp:receipts"));
    private static final Logger LOGGER = Logger.getLogger(DeliveryReceiptManager.class.getName());
    private static final Map<XMPPConnection, DeliveryReceiptManager> instances = new WeakHashMap();

    public enum AutoReceiptMode {
        disabled,
        ifIsSubscribed,
        always
    }

    static {
        XMPPConnectionRegistry.addConnectionCreationListener(new ConnectionCreationListener() { // from class: org.jivesoftware.smackx.receipts.DeliveryReceiptManager.1
            @Override // org.jivesoftware.smack.ConnectionCreationListener
            public void connectionCreated(XMPPConnection xMPPConnection) {
                DeliveryReceiptManager.getInstanceFor(xMPPConnection);
            }
        });
        defaultAutoReceiptMode = AutoReceiptMode.ifIsSubscribed;
        MESSAGES_TO_REQUEST_RECEIPTS_FOR = new AndFilter(MessageTypeFilter.NORMAL_OR_CHAT_OR_HEADLINE, new NotFilter(new StanzaExtensionFilter(DeliveryReceipt.ELEMENT, "urn:xmpp:receipts")), MessageWithBodiesFilter.INSTANCE);
    }

    public static void setDefaultAutoReceiptMode(AutoReceiptMode autoReceiptMode) {
        defaultAutoReceiptMode = autoReceiptMode;
    }

    private DeliveryReceiptManager(XMPPConnection xMPPConnection) {
        super(xMPPConnection);
        this.autoReceiptMode = defaultAutoReceiptMode;
        this.receiptReceivedListeners = new CopyOnWriteArraySet();
        ServiceDiscoveryManager.getInstanceFor(xMPPConnection).addFeature("urn:xmpp:receipts");
        xMPPConnection.addAsyncStanzaListener(new StanzaListener() { // from class: org.jivesoftware.smackx.receipts.DeliveryReceiptManager.2
            @Override // org.jivesoftware.smack.StanzaListener
            public void processStanza(Stanza stanza) throws SmackException.NotConnectedException {
                DeliveryReceipt deliveryReceiptFrom = DeliveryReceipt.from((Message) stanza);
                Iterator it = DeliveryReceiptManager.this.receiptReceivedListeners.iterator();
                while (it.hasNext()) {
                    ((ReceiptReceivedListener) it.next()).onReceiptReceived(stanza.getFrom(), stanza.getTo(), deliveryReceiptFrom.getId(), stanza);
                }
            }
        }, MESSAGES_WITH_DELIVERY_RECEIPT);
        xMPPConnection.addAsyncStanzaListener(new StanzaListener() { // from class: org.jivesoftware.smackx.receipts.DeliveryReceiptManager.3
            @Override // org.jivesoftware.smack.StanzaListener
            public void processStanza(Stanza stanza) throws SmackException.NotConnectedException, InterruptedException {
                Jid from = stanza.getFrom();
                XMPPConnection xMPPConnectionConnection = DeliveryReceiptManager.this.connection();
                int i = AnonymousClass4.$SwitchMap$org$jivesoftware$smackx$receipts$DeliveryReceiptManager$AutoReceiptMode[DeliveryReceiptManager.this.autoReceiptMode.ordinal()];
                if (i != 1) {
                    if (i == 2 && !Roster.getInstanceFor(xMPPConnectionConnection).isSubscribedToMyPresence(from)) {
                        return;
                    }
                    Message message = (Message) stanza;
                    Message messageReceiptMessageFor = DeliveryReceiptManager.receiptMessageFor(message);
                    if (messageReceiptMessageFor == null) {
                        DeliveryReceiptManager.LOGGER.warning("Received message stanza with receipt request from '" + ((Object) from) + "' without a stanza ID set. Message: " + message);
                    } else {
                        xMPPConnectionConnection.sendStanza(messageReceiptMessageFor);
                    }
                }
            }
        }, NON_ERROR_GROUPCHAT_MESSAGES_WITH_DELIVERY_RECEIPT_REQUEST);
    }

    /* JADX INFO: renamed from: org.jivesoftware.smackx.receipts.DeliveryReceiptManager$4, reason: invalid class name */
    static /* synthetic */ class AnonymousClass4 {
        static final /* synthetic */ int[] $SwitchMap$org$jivesoftware$smackx$receipts$DeliveryReceiptManager$AutoReceiptMode;

        static {
            int[] iArr = new int[AutoReceiptMode.values().length];
            $SwitchMap$org$jivesoftware$smackx$receipts$DeliveryReceiptManager$AutoReceiptMode = iArr;
            try {
                iArr[AutoReceiptMode.disabled.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                $SwitchMap$org$jivesoftware$smackx$receipts$DeliveryReceiptManager$AutoReceiptMode[AutoReceiptMode.ifIsSubscribed.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            try {
                $SwitchMap$org$jivesoftware$smackx$receipts$DeliveryReceiptManager$AutoReceiptMode[AutoReceiptMode.always.ordinal()] = 3;
            } catch (NoSuchFieldError unused3) {
            }
        }
    }

    public static synchronized DeliveryReceiptManager getInstanceFor(XMPPConnection xMPPConnection) {
        DeliveryReceiptManager deliveryReceiptManager;
        Map<XMPPConnection, DeliveryReceiptManager> map = instances;
        deliveryReceiptManager = map.get(xMPPConnection);
        if (deliveryReceiptManager == null) {
            deliveryReceiptManager = new DeliveryReceiptManager(xMPPConnection);
            map.put(xMPPConnection, deliveryReceiptManager);
        }
        return deliveryReceiptManager;
    }

    public boolean isSupported(Jid jid) throws SmackException, InterruptedException, XMPPException {
        return ServiceDiscoveryManager.getInstanceFor(connection()).supportsFeature(jid, "urn:xmpp:receipts");
    }

    public void setAutoReceiptMode(AutoReceiptMode autoReceiptMode) {
        this.autoReceiptMode = autoReceiptMode;
    }

    public AutoReceiptMode getAutoReceiptMode() {
        return this.autoReceiptMode;
    }

    public void addReceiptReceivedListener(ReceiptReceivedListener receiptReceivedListener) {
        this.receiptReceivedListeners.add(receiptReceivedListener);
    }

    public void removeReceiptReceivedListener(ReceiptReceivedListener receiptReceivedListener) {
        this.receiptReceivedListeners.remove(receiptReceivedListener);
    }

    public void autoAddDeliveryReceiptRequests() {
        connection().addMessageInterceptor(new DeliveryReceiptManager$$ExternalSyntheticLambda0(), new Predicate() { // from class: org.jivesoftware.smackx.receipts.DeliveryReceiptManager$$ExternalSyntheticLambda1
            @Override // org.jivesoftware.smack.util.Predicate
            public final boolean test(Object obj) {
                return DeliveryReceiptManager.MESSAGES_TO_REQUEST_RECEIPTS_FOR.accept((Message) obj);
            }
        });
    }

    public void dontAutoAddDeliveryReceiptRequests() {
        connection().removeMessageInterceptor(new DeliveryReceiptManager$$ExternalSyntheticLambda0());
    }

    public static boolean hasDeliveryReceiptRequest(Message message) {
        return DeliveryReceiptRequest.from(message) != null;
    }

    @Deprecated
    public static String addDeliveryReceiptRequest(Message message) {
        return DeliveryReceiptRequest.addTo(message);
    }

    /* JADX WARN: Multi-variable type inference failed */
    public static Message receiptMessageFor(Message message) {
        String stanzaId = message.getStanzaId();
        if (StringUtils.isNullOrEmpty(stanzaId)) {
            return null;
        }
        return ((MessageBuilder) ((MessageBuilder) StanzaBuilder.buildMessage().ofType(message.getType()).to(message.getFrom())).addExtension(new DeliveryReceipt(stanzaId))).build();
    }
}
