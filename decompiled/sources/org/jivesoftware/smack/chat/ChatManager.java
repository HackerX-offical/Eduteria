package org.jivesoftware.smack.chat;

import java.util.Collections;
import java.util.Iterator;
import java.util.Map;
import java.util.Set;
import java.util.WeakHashMap;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.CopyOnWriteArraySet;
import java.util.logging.Logger;
import org.jivesoftware.smack.Manager;
import org.jivesoftware.smack.MessageListener;
import org.jivesoftware.smack.SmackException;
import org.jivesoftware.smack.StanzaCollector;
import org.jivesoftware.smack.StanzaListener;
import org.jivesoftware.smack.XMPPConnection;
import org.jivesoftware.smack.filter.AndFilter;
import org.jivesoftware.smack.filter.FlexibleStanzaTypeFilter;
import org.jivesoftware.smack.filter.FromMatchesFilter;
import org.jivesoftware.smack.filter.MessageTypeFilter;
import org.jivesoftware.smack.filter.OrFilter;
import org.jivesoftware.smack.filter.StanzaFilter;
import org.jivesoftware.smack.filter.ThreadFilter;
import org.jivesoftware.smack.packet.Message;
import org.jivesoftware.smack.packet.Stanza;
import org.jivesoftware.smack.util.StringUtils;
import org.jxmpp.jid.EntityBareJid;
import org.jxmpp.jid.EntityJid;
import org.jxmpp.jid.Jid;

/* JADX INFO: loaded from: classes10.dex */
@Deprecated
public final class ChatManager extends Manager {
    private final Map<EntityBareJid, Chat> baseJidChats;
    private final Set<ChatManagerListener> chatManagerListeners;
    private final Map<MessageListener, StanzaFilter> interceptors;
    private final Map<Jid, Chat> jidChats;
    private MatchMode matchMode;
    private boolean normalIncluded;
    private final StanzaFilter packetFilter;
    private final Map<String, Chat> threadChats;
    private static final Logger LOGGER = Logger.getLogger(ChatManager.class.getName());
    private static final Map<XMPPConnection, ChatManager> INSTANCES = new WeakHashMap();
    private static boolean defaultIsNormalInclude = true;
    private static MatchMode defaultMatchMode = MatchMode.BARE_JID;

    public enum MatchMode {
        NONE,
        SUPPLIED_JID,
        BARE_JID
    }

    public static synchronized ChatManager getInstanceFor(XMPPConnection xMPPConnection) {
        ChatManager chatManager;
        chatManager = INSTANCES.get(xMPPConnection);
        if (chatManager == null) {
            chatManager = new ChatManager(xMPPConnection);
        }
        return chatManager;
    }

    private ChatManager(XMPPConnection xMPPConnection) {
        super(xMPPConnection);
        OrFilter orFilter = new OrFilter(MessageTypeFilter.CHAT, new FlexibleStanzaTypeFilter<Message>() { // from class: org.jivesoftware.smack.chat.ChatManager.1
            /* JADX INFO: Access modifiers changed from: protected */
            @Override // org.jivesoftware.smack.filter.FlexibleStanzaTypeFilter
            public boolean acceptSpecific(Message message) {
                return ChatManager.this.normalIncluded && message.getType() == Message.Type.normal;
            }
        });
        this.packetFilter = orFilter;
        this.normalIncluded = defaultIsNormalInclude;
        this.matchMode = defaultMatchMode;
        this.threadChats = new ConcurrentHashMap();
        this.jidChats = new ConcurrentHashMap();
        this.baseJidChats = new ConcurrentHashMap();
        this.chatManagerListeners = new CopyOnWriteArraySet();
        this.interceptors = new WeakHashMap();
        xMPPConnection.addSyncStanzaListener(new StanzaListener() { // from class: org.jivesoftware.smack.chat.ChatManager.2
            @Override // org.jivesoftware.smack.StanzaListener
            public void processStanza(Stanza stanza) {
                Chat threadChat;
                Message message = (Message) stanza;
                if (message.getThread() == null) {
                    threadChat = ChatManager.this.getUserChat(message.getFrom());
                } else {
                    threadChat = ChatManager.this.getThreadChat(message.getThread());
                }
                if (threadChat == null) {
                    threadChat = ChatManager.this.createChat(message);
                }
                if (threadChat == null) {
                    return;
                }
                ChatManager.deliverMessage(threadChat, message);
            }
        }, orFilter);
        INSTANCES.put(xMPPConnection, this);
    }

    public boolean isNormalIncluded() {
        return this.normalIncluded;
    }

    public void setNormalIncluded(boolean z) {
        this.normalIncluded = z;
    }

    public MatchMode getMatchMode() {
        return this.matchMode;
    }

    public void setMatchMode(MatchMode matchMode) {
        this.matchMode = matchMode;
    }

    public Chat createChat(EntityJid entityJid) {
        return createChat(entityJid, null);
    }

    public Chat createChat(EntityJid entityJid, ChatMessageListener chatMessageListener) {
        return createChat(entityJid, (String) null, chatMessageListener);
    }

    public Chat createChat(EntityJid entityJid, String str, ChatMessageListener chatMessageListener) {
        if (str == null) {
            str = nextID();
        }
        if (this.threadChats.get(str) != null) {
            throw new IllegalArgumentException("ThreadID is already used");
        }
        Chat chatCreateChat = createChat(entityJid, str, true);
        chatCreateChat.addMessageListener(chatMessageListener);
        return chatCreateChat;
    }

    private Chat createChat(EntityJid entityJid, String str, boolean z) {
        Chat chat = new Chat(this, entityJid, str);
        this.threadChats.put(str, chat);
        this.jidChats.put(entityJid, chat);
        this.baseJidChats.put(entityJid.asEntityBareJid(), chat);
        Iterator<ChatManagerListener> it = this.chatManagerListeners.iterator();
        while (it.hasNext()) {
            it.next().chatCreated(chat, z);
        }
        return chat;
    }

    void closeChat(Chat chat) {
        this.threadChats.remove(chat.getThreadID());
        EntityJid participant = chat.getParticipant();
        this.jidChats.remove(participant);
        this.baseJidChats.remove(participant.asEntityBareJid());
    }

    /* JADX INFO: Access modifiers changed from: private */
    public Chat createChat(Message message) {
        Jid from = message.getFrom();
        if (from == null) {
            return null;
        }
        EntityJid entityJidAsEntityJidIfPossible = from.asEntityJidIfPossible();
        if (entityJidAsEntityJidIfPossible == null) {
            LOGGER.warning("Message from JID without localpart: '" + ((Object) message.toXML()) + "'");
            return null;
        }
        String thread = message.getThread();
        if (thread == null) {
            thread = nextID();
        }
        return createChat(entityJidAsEntityJidIfPossible, thread, false);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public Chat getUserChat(Jid jid) {
        EntityBareJid entityBareJidAsEntityBareJidIfPossible;
        if (this.matchMode == MatchMode.NONE || jid == null) {
            return null;
        }
        Chat chat = this.jidChats.get(jid);
        return (chat == null && this.matchMode == MatchMode.BARE_JID && (entityBareJidAsEntityBareJidIfPossible = jid.asEntityBareJidIfPossible()) != null) ? this.baseJidChats.get(entityBareJidAsEntityBareJidIfPossible) : chat;
    }

    public Chat getThreadChat(String str) {
        return this.threadChats.get(str);
    }

    public void addChatListener(ChatManagerListener chatManagerListener) {
        this.chatManagerListeners.add(chatManagerListener);
    }

    public void removeChatListener(ChatManagerListener chatManagerListener) {
        this.chatManagerListeners.remove(chatManagerListener);
    }

    public Set<ChatManagerListener> getChatListeners() {
        return Collections.unmodifiableSet(this.chatManagerListeners);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static void deliverMessage(Chat chat, Message message) {
        chat.deliver(message);
    }

    void sendMessage(Chat chat, Message message) throws SmackException.NotConnectedException, InterruptedException {
        for (Map.Entry<MessageListener, StanzaFilter> entry : this.interceptors.entrySet()) {
            StanzaFilter value = entry.getValue();
            if (value != null && value.accept(message)) {
                entry.getKey().processMessage(message);
            }
        }
        connection().sendStanza(message);
    }

    StanzaCollector createStanzaCollector(Chat chat) {
        return connection().createStanzaCollector(new AndFilter(new ThreadFilter(chat.getThreadID()), FromMatchesFilter.create(chat.getParticipant())));
    }

    public void addOutgoingMessageInterceptor(MessageListener messageListener) {
        addOutgoingMessageInterceptor(messageListener, null);
    }

    public void addOutgoingMessageInterceptor(MessageListener messageListener, StanzaFilter stanzaFilter) {
        if (messageListener == null) {
            return;
        }
        this.interceptors.put(messageListener, stanzaFilter);
    }

    private static String nextID() {
        return StringUtils.secureUniqueRandomString();
    }

    public static void setDefaultMatchMode(MatchMode matchMode) {
        defaultMatchMode = matchMode;
    }

    public static void setDefaultIsNormalIncluded(boolean z) {
        defaultIsNormalInclude = z;
    }
}
