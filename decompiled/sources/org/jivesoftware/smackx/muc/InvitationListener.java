package org.jivesoftware.smackx.muc;

import org.jivesoftware.smack.XMPPConnection;
import org.jivesoftware.smack.packet.Message;
import org.jivesoftware.smackx.muc.packet.MUCUser;
import org.jxmpp.jid.EntityJid;

/* JADX INFO: loaded from: classes10.dex */
public interface InvitationListener {
    void invitationReceived(XMPPConnection xMPPConnection, MultiUserChat multiUserChat, EntityJid entityJid, String str, String str2, Message message, MUCUser.Invite invite);
}
