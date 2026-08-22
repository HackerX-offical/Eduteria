package org.jivesoftware.smackx.iot.provisioning;

import org.jivesoftware.smack.packet.Presence;
import org.jxmpp.jid.BareJid;

/* JADX INFO: loaded from: classes10.dex */
public interface WasUnfriendedListener {
    void wasUnfriendedListener(BareJid bareJid, Presence presence);
}
