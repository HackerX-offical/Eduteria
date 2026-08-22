package org.jivesoftware.smack.roster;

import java.util.Collection;
import org.jivesoftware.smack.packet.Presence;
import org.jxmpp.jid.Jid;

/* JADX INFO: loaded from: classes10.dex */
public abstract class AbstractRosterListener implements RosterListener {
    @Override // org.jivesoftware.smack.roster.RosterListener
    public void entriesAdded(Collection<Jid> collection) {
    }

    @Override // org.jivesoftware.smack.roster.RosterListener
    public void entriesDeleted(Collection<Jid> collection) {
    }

    @Override // org.jivesoftware.smack.roster.RosterListener
    public void entriesUpdated(Collection<Jid> collection) {
    }

    @Override // org.jivesoftware.smack.roster.RosterListener
    public void presenceChanged(Presence presence) {
    }
}
