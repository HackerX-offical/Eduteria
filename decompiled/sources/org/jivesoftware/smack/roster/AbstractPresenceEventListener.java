package org.jivesoftware.smack.roster;

import org.jivesoftware.smack.packet.Presence;
import org.jxmpp.jid.BareJid;
import org.jxmpp.jid.FullJid;
import org.jxmpp.jid.Jid;

/* JADX INFO: loaded from: classes10.dex */
public abstract class AbstractPresenceEventListener implements PresenceEventListener {
    @Override // org.jivesoftware.smack.roster.PresenceEventListener
    public void presenceAvailable(FullJid fullJid, Presence presence) {
    }

    @Override // org.jivesoftware.smack.roster.PresenceEventListener
    public void presenceError(Jid jid, Presence presence) {
    }

    @Override // org.jivesoftware.smack.roster.PresenceEventListener
    public void presenceSubscribed(BareJid bareJid, Presence presence) {
    }

    @Override // org.jivesoftware.smack.roster.PresenceEventListener
    public void presenceUnavailable(FullJid fullJid, Presence presence) {
    }

    @Override // org.jivesoftware.smack.roster.PresenceEventListener
    public void presenceUnsubscribed(BareJid bareJid, Presence presence) {
    }
}
