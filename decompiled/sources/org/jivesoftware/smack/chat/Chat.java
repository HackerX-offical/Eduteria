package org.jivesoftware.smack.chat;

import java.util.Collections;
import java.util.Iterator;
import java.util.Set;
import java.util.concurrent.CopyOnWriteArraySet;
import org.jivesoftware.smack.SmackException;
import org.jivesoftware.smack.StanzaCollector;
import org.jivesoftware.smack.packet.Message;
import org.jivesoftware.smack.packet.MessageBuilder;
import org.jivesoftware.smack.packet.StanzaBuilder;
import org.jivesoftware.smack.util.StringUtils;
import org.jxmpp.jid.EntityJid;
import org.jxmpp.jid.Jid;

/* JADX INFO: loaded from: classes10.dex */
@Deprecated
public class Chat {
    private final ChatManager chatManager;

    /* JADX INFO: renamed from: listeners, reason: collision with root package name */
    private final Set<ChatMessageListener> f1490listeners = new CopyOnWriteArraySet();
    private final EntityJid participant;
    private final String threadID;

    Chat(ChatManager chatManager, EntityJid entityJid, String str) {
        if (StringUtils.isEmpty(str)) {
            throw new IllegalArgumentException("Thread ID must not be null");
        }
        this.chatManager = chatManager;
        this.participant = entityJid;
        this.threadID = str;
    }

    public String getThreadID() {
        return this.threadID;
    }

    public EntityJid getParticipant() {
        return this.participant;
    }

    public void sendMessage(String str) throws SmackException.NotConnectedException, InterruptedException {
        sendMessage(StanzaBuilder.buildMessage().setBody(str));
    }

    public void sendMessage(MessageBuilder messageBuilder) throws SmackException.NotConnectedException, InterruptedException {
        messageBuilder.to((Jid) this.participant);
        messageBuilder.ofType(Message.Type.chat);
        messageBuilder.setThread(this.threadID);
        this.chatManager.sendMessage(this, messageBuilder.build());
    }

    public void sendMessage(Message message) throws SmackException.NotConnectedException, InterruptedException {
        message.setTo(this.participant);
        message.setType(Message.Type.chat);
        message.setThread(this.threadID);
        this.chatManager.sendMessage(this, message);
    }

    public void addMessageListener(ChatMessageListener chatMessageListener) {
        if (chatMessageListener == null) {
            return;
        }
        this.f1490listeners.add(chatMessageListener);
    }

    public void removeMessageListener(ChatMessageListener chatMessageListener) {
        this.f1490listeners.remove(chatMessageListener);
    }

    public void close() {
        this.chatManager.closeChat(this);
        this.f1490listeners.clear();
    }

    public Set<ChatMessageListener> getListeners() {
        return Collections.unmodifiableSet(this.f1490listeners);
    }

    public StanzaCollector createCollector() {
        return this.chatManager.createStanzaCollector(this);
    }

    void deliver(Message message) {
        message.setThread(this.threadID);
        Iterator<ChatMessageListener> it = this.f1490listeners.iterator();
        while (it.hasNext()) {
            it.next().processMessage(this, message);
        }
    }

    public String toString() {
        return "Chat [(participant=" + ((Object) this.participant) + "), (thread=" + this.threadID + ")]";
    }

    public int hashCode() {
        return ((this.threadID.hashCode() + 31) * 31) + this.participant.hashCode();
    }

    public boolean equals(Object obj) {
        if (!(obj instanceof Chat)) {
            return false;
        }
        Chat chat = (Chat) obj;
        return this.threadID.equals(chat.getThreadID()) && this.participant.equals((CharSequence) chat.getParticipant());
    }
}
