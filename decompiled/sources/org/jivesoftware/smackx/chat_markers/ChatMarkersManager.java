package org.jivesoftware.smackx.chat_markers;

import java.util.HashSet;
import java.util.Map;
import java.util.Set;
import java.util.WeakHashMap;
import org.jivesoftware.smack.AsyncButOrdered;
import org.jivesoftware.smack.ConnectionCreationListener;
import org.jivesoftware.smack.Manager;
import org.jivesoftware.smack.SmackException;
import org.jivesoftware.smack.StanzaListener;
import org.jivesoftware.smack.XMPPConnection;
import org.jivesoftware.smack.XMPPConnectionRegistry;
import org.jivesoftware.smack.XMPPException;
import org.jivesoftware.smack.chat2.Chat;
import org.jivesoftware.smack.chat2.ChatManager;
import org.jivesoftware.smack.filter.AndFilter;
import org.jivesoftware.smack.filter.MessageTypeFilter;
import org.jivesoftware.smack.filter.MessageWithBodiesFilter;
import org.jivesoftware.smack.filter.NotFilter;
import org.jivesoftware.smack.filter.PossibleFromTypeFilter;
import org.jivesoftware.smack.filter.StanzaExtensionFilter;
import org.jivesoftware.smack.filter.StanzaFilter;
import org.jivesoftware.smack.packet.Message;
import org.jivesoftware.smack.packet.MessageBuilder;
import org.jivesoftware.smack.packet.Stanza;
import org.jivesoftware.smack.util.Consumer;
import org.jivesoftware.smack.util.Predicate;
import org.jivesoftware.smackx.chat_markers.element.ChatMarkersElements;
import org.jivesoftware.smackx.chat_markers.filter.ChatMarkersFilter;
import org.jivesoftware.smackx.chat_markers.filter.EligibleForChatMarkerFilter;
import org.jivesoftware.smackx.disco.ServiceDiscoveryManager;

/* JADX INFO: loaded from: classes10.dex */
public final class ChatMarkersManager extends Manager {
    private static final StanzaFilter INCOMING_MESSAGE_FILTER;
    private static final Map<XMPPConnection, ChatMarkersManager> INSTANCES;
    private static final StanzaFilter OUTGOING_MESSAGE_FILTER;
    private final AsyncButOrdered<Chat> asyncButOrdered;
    private final ChatManager chatManager;
    private boolean enabled;
    private final Set<ChatMarkersListener> incomingListeners;
    private final ServiceDiscoveryManager serviceDiscoveryManager;

    static {
        XMPPConnectionRegistry.addConnectionCreationListener(new ConnectionCreationListener() { // from class: org.jivesoftware.smackx.chat_markers.ChatMarkersManager.1
            @Override // org.jivesoftware.smack.ConnectionCreationListener
            public void connectionCreated(XMPPConnection xMPPConnection) {
                ChatMarkersManager.getInstanceFor(xMPPConnection);
            }
        });
        INSTANCES = new WeakHashMap();
        INCOMING_MESSAGE_FILTER = new AndFilter(MessageTypeFilter.NORMAL_OR_CHAT, new StanzaExtensionFilter(ChatMarkersElements.NAMESPACE), PossibleFromTypeFilter.ENTITY_BARE_JID, EligibleForChatMarkerFilter.INSTANCE);
        OUTGOING_MESSAGE_FILTER = new AndFilter(MessageTypeFilter.NORMAL_OR_CHAT, MessageWithBodiesFilter.INSTANCE, new NotFilter(ChatMarkersFilter.INSTANCE), EligibleForChatMarkerFilter.INSTANCE);
    }

    public static synchronized ChatMarkersManager getInstanceFor(XMPPConnection xMPPConnection) {
        ChatMarkersManager chatMarkersManager;
        Map<XMPPConnection, ChatMarkersManager> map = INSTANCES;
        chatMarkersManager = map.get(xMPPConnection);
        if (chatMarkersManager == null) {
            chatMarkersManager = new ChatMarkersManager(xMPPConnection);
            map.put(xMPPConnection, chatMarkersManager);
        }
        return chatMarkersManager;
    }

    private ChatMarkersManager(XMPPConnection xMPPConnection) {
        super(xMPPConnection);
        this.incomingListeners = new HashSet();
        this.asyncButOrdered = new AsyncButOrdered<>();
        this.chatManager = ChatManager.getInstanceFor(xMPPConnection);
        xMPPConnection.addMessageInterceptor(new Consumer() { // from class: org.jivesoftware.smackx.chat_markers.ChatMarkersManager$$ExternalSyntheticLambda0
            @Override // org.jivesoftware.smack.util.Consumer
            public final void accept(Object obj) {
                ((MessageBuilder) obj).addExtension(ChatMarkersElements.MarkableExtension.INSTANCE);
            }
        }, new Predicate() { // from class: org.jivesoftware.smackx.chat_markers.ChatMarkersManager$$ExternalSyntheticLambda1
            @Override // org.jivesoftware.smack.util.Predicate
            public final boolean test(Object obj) {
                return ChatMarkersManager.OUTGOING_MESSAGE_FILTER.accept((Message) obj);
            }
        });
        xMPPConnection.addSyncStanzaListener(new StanzaListener() { // from class: org.jivesoftware.smackx.chat_markers.ChatMarkersManager.2
            @Override // org.jivesoftware.smack.StanzaListener
            public void processStanza(Stanza stanza) throws SmackException.NotConnectedException, InterruptedException, SmackException.NotLoggedInException {
                final Message message = (Message) stanza;
                final Chat chatChatWith = ChatMarkersManager.this.chatManager.chatWith(message.getFrom().asEntityBareJidOrThrow());
                ChatMarkersManager.this.asyncButOrdered.performAsyncButOrdered(chatChatWith, new Runnable() { // from class: org.jivesoftware.smackx.chat_markers.ChatMarkersManager.2.1
                    @Override // java.lang.Runnable
                    public void run() {
                        for (ChatMarkersListener chatMarkersListener : ChatMarkersManager.this.incomingListeners) {
                            if (ChatMarkersElements.MarkableExtension.from(message) != null) {
                                chatMarkersListener.newChatMarkerMessage(ChatMarkersState.markable, message, chatChatWith);
                            } else if (ChatMarkersElements.ReceivedExtension.from(message) != null) {
                                chatMarkersListener.newChatMarkerMessage(ChatMarkersState.received, message, chatChatWith);
                            } else if (ChatMarkersElements.DisplayedExtension.from(message) != null) {
                                chatMarkersListener.newChatMarkerMessage(ChatMarkersState.displayed, message, chatChatWith);
                            } else if (ChatMarkersElements.AcknowledgedExtension.from(message) != null) {
                                chatMarkersListener.newChatMarkerMessage(ChatMarkersState.acknowledged, message, chatChatWith);
                            }
                        }
                    }
                });
            }
        }, INCOMING_MESSAGE_FILTER);
        this.serviceDiscoveryManager = ServiceDiscoveryManager.getInstanceFor(xMPPConnection);
    }

    public boolean isSupportedByServer() throws SmackException.NotConnectedException, SmackException.NoResponseException, InterruptedException, XMPPException.XMPPErrorException {
        return ServiceDiscoveryManager.getInstanceFor(connection()).serverSupportsFeature(ChatMarkersElements.NAMESPACE);
    }

    public synchronized boolean addIncomingChatMarkerMessageListener(ChatMarkersListener chatMarkersListener) {
        boolean zAdd;
        zAdd = this.incomingListeners.add(chatMarkersListener);
        if (!this.enabled) {
            this.serviceDiscoveryManager.addFeature(ChatMarkersElements.NAMESPACE);
            this.enabled = true;
        }
        return zAdd;
    }

    public synchronized boolean removeIncomingChatMarkerMessageListener(ChatMarkersListener chatMarkersListener) {
        boolean zRemove;
        zRemove = this.incomingListeners.remove(chatMarkersListener);
        if (this.incomingListeners.isEmpty() && this.enabled) {
            this.serviceDiscoveryManager.removeFeature(ChatMarkersElements.NAMESPACE);
            this.enabled = false;
        }
        return zRemove;
    }
}
