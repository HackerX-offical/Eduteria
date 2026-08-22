package org.jivesoftware.smack.chat2;

import org.jivesoftware.smack.packet.MessageBuilder;
import org.jxmpp.jid.EntityBareJid;

/* JADX INFO: loaded from: classes10.dex */
public interface OutgoingChatMessageListener {
    void newOutgoingMessage(EntityBareJid entityBareJid, MessageBuilder messageBuilder, Chat chat);
}
