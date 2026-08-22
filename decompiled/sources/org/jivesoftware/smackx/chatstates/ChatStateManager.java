package org.jivesoftware.smackx.chatstates;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.Iterator;
import java.util.Map;
import java.util.Set;
import java.util.WeakHashMap;
import java.util.logging.Level;
import java.util.logging.Logger;
import org.jivesoftware.smack.AsyncButOrdered;
import org.jivesoftware.smack.Manager;
import org.jivesoftware.smack.SmackException;
import org.jivesoftware.smack.StanzaListener;
import org.jivesoftware.smack.XMPPConnection;
import org.jivesoftware.smack.chat2.Chat;
import org.jivesoftware.smack.chat2.ChatManager;
import org.jivesoftware.smack.chat2.OutgoingChatMessageListener;
import org.jivesoftware.smack.filter.AndFilter;
import org.jivesoftware.smack.filter.FromTypeFilter;
import org.jivesoftware.smack.filter.MessageTypeFilter;
import org.jivesoftware.smack.filter.StanzaExtensionFilter;
import org.jivesoftware.smack.filter.StanzaFilter;
import org.jivesoftware.smack.packet.Message;
import org.jivesoftware.smack.packet.MessageBuilder;
import org.jivesoftware.smack.packet.Stanza;
import org.jivesoftware.smack.packet.StanzaBuilder;
import org.jivesoftware.smackx.chatstates.packet.ChatStateExtension;
import org.jivesoftware.smackx.disco.ServiceDiscoveryManager;
import org.jxmpp.jid.EntityBareJid;

/* JADX INFO: loaded from: classes10.dex */
public final class ChatStateManager extends Manager {
    private static final StanzaFilter INCOMING_CHAT_STATE_FILTER;
    private static final StanzaFilter INCOMING_MESSAGE_FILTER;
    public static final String NAMESPACE = "http://jabber.org/protocol/chatstates";
    private final AsyncButOrdered<Chat> asyncButOrdered;
    private final Set<ChatStateListener> chatStateListeners;
    private final Map<Chat, ChatState> chatStates;
    private static final Logger LOGGER = Logger.getLogger(ChatStateManager.class.getName());
    private static final Map<XMPPConnection, ChatStateManager> INSTANCES = new WeakHashMap();

    static {
        AndFilter andFilter = new AndFilter(MessageTypeFilter.NORMAL_OR_CHAT, FromTypeFilter.ENTITY_FULL_JID);
        INCOMING_MESSAGE_FILTER = andFilter;
        INCOMING_CHAT_STATE_FILTER = new AndFilter(andFilter, new StanzaExtensionFilter("http://jabber.org/protocol/chatstates"));
    }

    public static synchronized ChatStateManager getInstance(XMPPConnection xMPPConnection) {
        ChatStateManager chatStateManager;
        Map<XMPPConnection, ChatStateManager> map = INSTANCES;
        chatStateManager = map.get(xMPPConnection);
        if (chatStateManager == null) {
            chatStateManager = new ChatStateManager(xMPPConnection);
            map.put(xMPPConnection, chatStateManager);
        }
        return chatStateManager;
    }

    private ChatStateManager(XMPPConnection xMPPConnection) {
        super(xMPPConnection);
        this.chatStateListeners = new HashSet();
        this.chatStates = new WeakHashMap();
        this.asyncButOrdered = new AsyncButOrdered<>();
        ChatManager.getInstanceFor(xMPPConnection).addOutgoingListener(new OutgoingChatMessageListener() { // from class: org.jivesoftware.smackx.chatstates.ChatStateManager.1
            @Override // org.jivesoftware.smack.chat2.OutgoingChatMessageListener
            public void newOutgoingMessage(EntityBareJid entityBareJid, MessageBuilder messageBuilder, Chat chat) {
                if (chat == null || messageBuilder.hasExtension("http://jabber.org/protocol/chatstates") || !ChatStateManager.this.updateChatState(chat, ChatState.active)) {
                    return;
                }
                messageBuilder.addExtension(new ChatStateExtension(ChatState.active));
            }
        });
        xMPPConnection.addSyncStanzaListener(new StanzaListener() { // from class: org.jivesoftware.smackx.chatstates.ChatStateManager.2
            @Override // org.jivesoftware.smack.StanzaListener
            public void processStanza(Stanza stanza) {
                final ArrayList arrayList;
                final Message message = (Message) stanza;
                final Chat chatChatWith = ChatManager.getInstanceFor(ChatStateManager.this.connection()).chatWith(message.getFrom().asEntityFullJidIfPossible().asEntityBareJid());
                String elementName = message.getExtension("http://jabber.org/protocol/chatstates").getElementName();
                try {
                    final ChatState chatStateValueOf = ChatState.valueOf(elementName);
                    synchronized (ChatStateManager.this.chatStateListeners) {
                        arrayList = new ArrayList(ChatStateManager.this.chatStateListeners.size());
                        arrayList.addAll(ChatStateManager.this.chatStateListeners);
                    }
                    ChatStateManager.this.asyncButOrdered.performAsyncButOrdered(chatChatWith, new Runnable() { // from class: org.jivesoftware.smackx.chatstates.ChatStateManager.2.1
                        @Override // java.lang.Runnable
                        public void run() {
                            Iterator it = arrayList.iterator();
                            while (it.hasNext()) {
                                ((ChatStateListener) it.next()).stateChanged(chatChatWith, chatStateValueOf, message);
                            }
                        }
                    });
                } catch (Exception e2) {
                    ChatStateManager.LOGGER.log(Level.WARNING, "Invalid chat state element name: " + elementName, (Throwable) e2);
                }
            }
        }, INCOMING_CHAT_STATE_FILTER);
        ServiceDiscoveryManager.getInstanceFor(xMPPConnection).addFeature("http://jabber.org/protocol/chatstates");
    }

    public boolean addChatStateListener(ChatStateListener chatStateListener) {
        boolean zAdd;
        synchronized (this.chatStateListeners) {
            zAdd = this.chatStateListeners.add(chatStateListener);
        }
        return zAdd;
    }

    public boolean removeChatStateListener(ChatStateListener chatStateListener) {
        boolean zRemove;
        synchronized (this.chatStateListeners) {
            zRemove = this.chatStateListeners.remove(chatStateListener);
        }
        return zRemove;
    }

    public void setCurrentState(ChatState chatState, Chat chat) throws SmackException.NotConnectedException, InterruptedException {
        if (chat == null || chatState == null) {
            throw new IllegalArgumentException("Arguments cannot be null.");
        }
        if (updateChatState(chat, chatState)) {
            Message messageBuild = StanzaBuilder.buildMessage().build();
            messageBuild.addExtension(new ChatStateExtension(chatState));
            chat.send(messageBuild);
        }
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null || getClass() != obj.getClass()) {
            return false;
        }
        return connection().equals(((ChatStateManager) obj).connection());
    }

    public int hashCode() {
        return connection().hashCode();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public synchronized boolean updateChatState(Chat chat, ChatState chatState) {
        if (this.chatStates.get(chat) == chatState) {
            return false;
        }
        this.chatStates.put(chat, chatState);
        return true;
    }
}
