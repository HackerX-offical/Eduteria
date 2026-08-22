package org.jivesoftware.smackx.pep;

import org.jivesoftware.smack.packet.ExtensionElement;
import org.jivesoftware.smack.packet.Message;
import org.jxmpp.jid.EntityBareJid;

/* JADX INFO: loaded from: classes10.dex */
public interface PepEventListener<E extends ExtensionElement> {
    void onPepEvent(EntityBareJid entityBareJid, E e2, String str, Message message);
}
