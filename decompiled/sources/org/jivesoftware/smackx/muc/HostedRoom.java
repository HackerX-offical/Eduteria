package org.jivesoftware.smackx.muc;

import org.jivesoftware.smack.util.Objects;
import org.jivesoftware.smackx.disco.packet.DiscoverItems;
import org.jxmpp.jid.EntityBareJid;

/* JADX INFO: loaded from: classes10.dex */
public class HostedRoom {
    private final EntityBareJid jid;
    private final String name;

    public HostedRoom(DiscoverItems.Item item) {
        this.jid = (EntityBareJid) Objects.requireNonNull(item.getEntityID().asEntityBareJidIfPossible(), "The discovered item must be an entity bare JID");
        this.name = item.getName();
    }

    public EntityBareJid getJid() {
        return this.jid;
    }

    public String getName() {
        return this.name;
    }
}
