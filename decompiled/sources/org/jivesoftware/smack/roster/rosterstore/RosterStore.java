package org.jivesoftware.smack.roster.rosterstore;

import java.util.Collection;
import java.util.List;
import org.jivesoftware.smack.roster.packet.RosterPacket;
import org.jxmpp.jid.Jid;

/* JADX INFO: loaded from: classes10.dex */
public interface RosterStore {
    boolean addEntry(RosterPacket.Item item, String str);

    List<RosterPacket.Item> getEntries();

    RosterPacket.Item getEntry(Jid jid);

    String getRosterVersion();

    boolean removeEntry(Jid jid, String str);

    boolean resetEntries(Collection<RosterPacket.Item> collection, String str);

    void resetStore();
}
