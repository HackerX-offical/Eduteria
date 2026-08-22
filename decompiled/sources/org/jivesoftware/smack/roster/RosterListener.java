package org.jivesoftware.smack.roster;

import java.util.Collection;
import org.jivesoftware.smack.packet.Presence;
import org.jxmpp.jid.Jid;

/* JADX INFO: loaded from: classes10.dex */
public interface RosterListener {
    void entriesAdded(Collection<Jid> collection);

    void entriesDeleted(Collection<Jid> collection);

    void entriesUpdated(Collection<Jid> collection);

    void presenceChanged(Presence presence);
}
