package org.jivesoftware.smack.chat2;

import org.jivesoftware.smack.packet.Message;
import org.jxmpp.jid.EntityBareJid;

/* JADX INFO: loaded from: classes10.dex */
public interface IncomingChatMessageListener {
    void newIncomingMessage(EntityBareJid entityBareJid, Message message, Chat chat);
}
