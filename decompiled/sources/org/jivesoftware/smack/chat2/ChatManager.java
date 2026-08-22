package org.jivesoftware.smack.chat2;

import java.util.Iterator;
import java.util.Map;
import java.util.Set;
import java.util.WeakHashMap;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.CopyOnWriteArraySet;
import org.jivesoftware.smack.AsyncButOrdered;
import org.jivesoftware.smack.Manager;
import org.jivesoftware.smack.StanzaListener;
import org.jivesoftware.smack.XMPPConnection;
import org.jivesoftware.smack.filter.AndFilter;
import org.jivesoftware.smack.filter.FromTypeFilter;
import org.jivesoftware.smack.filter.MessageTypeFilter;
import org.jivesoftware.smack.filter.MessageWithBodiesFilter;
import org.jivesoftware.smack.filter.OrFilter;
import org.jivesoftware.smack.filter.StanzaExtensionFilter;
import org.jivesoftware.smack.filter.StanzaFilter;
import org.jivesoftware.smack.filter.ToTypeFilter;
import org.jivesoftware.smack.packet.Message;
import org.jivesoftware.smack.packet.MessageBuilder;
import org.jivesoftware.smack.packet.MessageView;
import org.jivesoftware.smack.packet.Presence;
import org.jivesoftware.smack.packet.Stanza;
import org.jivesoftware.smack.roster.AbstractRosterListener;
import org.jivesoftware.smack.roster.Roster;
import org.jivesoftware.smack.util.Consumer;
import org.jivesoftware.smack.util.Predicate;
import org.jivesoftware.smackx.xhtmlim.packet.XHTMLExtension;
import org.jxmpp.jid.EntityBareJid;
import org.jxmpp.jid.EntityFullJid;
import org.jxmpp.jid.Jid;

/* JADX INFO: loaded from: classes10.dex */
public final class ChatManager extends Manager {
    private static final StanzaFilter INCOMING_MESSAGE_FILTER;
    private static final Map<XMPPConnection, ChatManager> INSTANCES = new WeakHashMap();
    private static final StanzaFilter MESSAGE_FILTER;
    private static final StanzaFilter OUTGOING_MESSAGE_FILTER;
    private final AsyncButOrdered<Chat> asyncButOrdered;
    private final Map<EntityBareJid, Chat> chats;
    private final Set<IncomingChatMessageListener> incomingListeners;
    private final Set<OutgoingChatMessageListener> outgoingListeners;
    private boolean xhtmlIm;

    static {
        AndFilter andFilter = new AndFilter(MessageTypeFilter.NORMAL_OR_CHAT, new OrFilter(MessageWithBodiesFilter.INSTANCE, new StanzaExtensionFilter("html", XHTMLExtension.NAMESPACE)));
        MESSAGE_FILTER = andFilter;
        OUTGOING_MESSAGE_FILTER = new AndFilter(andFilter, ToTypeFilter.ENTITY_FULL_OR_BARE_JID);
        INCOMING_MESSAGE_FILTER = new AndFilter(andFilter, FromTypeFilter.ENTITY_FULL_JID);
    }

    public static synchronized ChatManager getInstanceFor(XMPPConnection xMPPConnection) {
        ChatManager chatManager;
        Map<XMPPConnection, ChatManager> map = INSTANCES;
        chatManager = map.get(xMPPConnection);
        if (chatManager == null) {
            chatManager = new ChatManager(xMPPConnection);
            map.put(xMPPConnection, chatManager);
        }
        return chatManager;
    }

    private ChatManager(XMPPConnection xMPPConnection) {
        super(xMPPConnection);
        this.chats = new ConcurrentHashMap();
        this.incomingListeners = new CopyOnWriteArraySet();
        this.outgoingListeners = new CopyOnWriteArraySet();
        this.asyncButOrdered = new AsyncButOrdered<>();
        xMPPConnection.addSyncStanzaListener(new StanzaListener() { // from class: org.jivesoftware.smack.chat2.ChatManager.1
            @Override // org.jivesoftware.smack.StanzaListener
            public void processStanza(Stanza stanza) {
                final Message message = (Message) stanza;
                if (ChatManager.this.shouldAcceptMessage(message)) {
                    EntityFullJid entityFullJidAsEntityFullJidOrThrow = message.getFrom().asEntityFullJidOrThrow();
                    final EntityBareJid entityBareJidAsEntityBareJid = entityFullJidAsEntityFullJidOrThrow.asEntityBareJid();
                    final Chat chatChatWith = ChatManager.this.chatWith(entityBareJidAsEntityBareJid);
                    chatChatWith.lockedResource = entityFullJidAsEntityFullJidOrThrow;
                    ChatManager.this.asyncButOrdered.performAsyncButOrdered(chatChatWith, new Runnable() { // from class: org.jivesoftware.smack.chat2.ChatManager.1.1
                        @Override // java.lang.Runnable
                        public void run() {
                            Iterator it = ChatManager.this.incomingListeners.iterator();
                            while (it.hasNext()) {
                                ((IncomingChatMessageListener) it.next()).newIncomingMessage(entityBareJidAsEntityBareJid, message, chatChatWith);
                            }
                        }
                    });
                }
            }
        }, INCOMING_MESSAGE_FILTER);
        xMPPConnection.addMessageInterceptor(new Consumer() { // from class: org.jivesoftware.smack.chat2.ChatManager$$ExternalSyntheticLambda0
            @Override // org.jivesoftware.smack.util.Consumer
            public final void accept(Object obj) {
                this.f$0.m14194lambda$new$0$orgjivesoftwaresmackchat2ChatManager((MessageBuilder) obj);
            }
        }, new Predicate() { // from class: org.jivesoftware.smack.chat2.ChatManager$$ExternalSyntheticLambda1
            @Override // org.jivesoftware.smack.util.Predicate
            public final boolean test(Object obj) {
                return ChatManager.OUTGOING_MESSAGE_FILTER.accept((Message) obj);
            }
        });
        Roster.getInstanceFor(xMPPConnection).addRosterListener(new AbstractRosterListener() { // from class: org.jivesoftware.smack.chat2.ChatManager.2
            @Override // org.jivesoftware.smack.roster.AbstractRosterListener, org.jivesoftware.smack.roster.RosterListener
            public void presenceChanged(Presence presence) {
                Chat chat;
                Jid from = presence.getFrom();
                EntityBareJid entityBareJidAsEntityBareJidIfPossible = from.asEntityBareJidIfPossible();
                if (entityBareJidAsEntityBareJidIfPossible == null || (chat = (Chat) ChatManager.this.chats.get(entityBareJidAsEntityBareJidIfPossible)) == null || chat.lockedResource == null) {
                    return;
                }
                if (chat.lockedResource.equals((CharSequence) from.asEntityFullJidIfPossible())) {
                    return;
                }
                if (chat.lastPresenceOfLockedResource == null) {
                    chat.lastPresenceOfLockedResource = presence;
                } else {
                    if (chat.lastPresenceOfLockedResource.getMode() == presence.getMode() && chat.lastPresenceOfLockedResource.getType() == presence.getType()) {
                        return;
                    }
                    chat.unlockResource();
                }
            }
        });
    }

    /* JADX INFO: renamed from: lambda$new$0$org-jivesoftware-smack-chat2-ChatManager, reason: not valid java name */
    /* synthetic */ void m14194lambda$new$0$orgjivesoftwaresmackchat2ChatManager(MessageBuilder messageBuilder) {
        if (shouldAcceptMessage(messageBuilder)) {
            EntityBareJid entityBareJidAsEntityBareJidOrThrow = messageBuilder.getTo().asEntityBareJidOrThrow();
            Chat chatChatWith = chatWith(entityBareJidAsEntityBareJidOrThrow);
            Iterator<OutgoingChatMessageListener> it = this.outgoingListeners.iterator();
            while (it.hasNext()) {
                it.next().newOutgoingMessage(entityBareJidAsEntityBareJidOrThrow, messageBuilder, chatChatWith);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public boolean shouldAcceptMessage(MessageView messageView) {
        if (messageView.hasExtension(Message.Body.QNAME)) {
            return true;
        }
        return this.xhtmlIm && XHTMLExtension.from(messageView) != null;
    }

    public boolean addIncomingListener(IncomingChatMessageListener incomingChatMessageListener) {
        return this.incomingListeners.add(incomingChatMessageListener);
    }

    public boolean removeIncomingListener(IncomingChatMessageListener incomingChatMessageListener) {
        return this.incomingListeners.remove(incomingChatMessageListener);
    }

    public boolean addOutgoingListener(OutgoingChatMessageListener outgoingChatMessageListener) {
        return this.outgoingListeners.add(outgoingChatMessageListener);
    }

    public boolean removeOutgoingListener(OutgoingChatMessageListener outgoingChatMessageListener) {
        return this.outgoingListeners.remove(outgoingChatMessageListener);
    }

    public Chat chatWith(EntityBareJid entityBareJid) {
        Chat chat = this.chats.get(entityBareJid);
        if (chat != null) {
            return chat;
        }
        synchronized (this.chats) {
            Chat chat2 = this.chats.get(entityBareJid);
            if (chat2 != null) {
                return chat2;
            }
            Chat chat3 = new Chat(connection(), entityBareJid);
            this.chats.put(entityBareJid, chat3);
            return chat3;
        }
    }

    public void setXhmtlImEnabled(boolean z) {
        this.xhtmlIm = z;
    }
}
