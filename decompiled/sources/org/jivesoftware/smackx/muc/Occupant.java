package org.jivesoftware.smackx.muc;

import java.util.logging.Logger;
import org.jivesoftware.smack.packet.Presence;
import org.jivesoftware.smackx.muc.packet.MUCItem;
import org.jivesoftware.smackx.muc.packet.MUCUser;
import org.jxmpp.jid.EntityFullJid;
import org.jxmpp.jid.Jid;
import org.jxmpp.jid.parts.Resourcepart;

/* JADX INFO: loaded from: classes10.dex */
public class Occupant {
    private static final Logger LOGGER = Logger.getLogger(Occupant.class.getName());
    private final MUCAffiliation affiliation;
    private final Jid jid;
    private final Resourcepart nick;
    private final MUCRole role;

    Occupant(MUCItem mUCItem) {
        this.jid = mUCItem.getJid();
        this.affiliation = mUCItem.getAffiliation();
        this.role = mUCItem.getRole();
        this.nick = mUCItem.getNick();
    }

    Occupant(Presence presence) {
        MUCItem item = ((MUCUser) presence.getExtensionElement("x", MUCUser.NAMESPACE)).getItem();
        this.jid = item.getJid();
        this.affiliation = item.getAffiliation();
        this.role = item.getRole();
        EntityFullJid entityFullJidAsEntityFullJidIfPossible = presence.getFrom().asEntityFullJidIfPossible();
        if (entityFullJidAsEntityFullJidIfPossible == null) {
            LOGGER.warning("Occupant presence without resource: " + ((Object) presence.getFrom()));
            this.nick = null;
        } else {
            this.nick = entityFullJidAsEntityFullJidIfPossible.getResourcepart();
        }
    }

    public Jid getJid() {
        return this.jid;
    }

    public MUCAffiliation getAffiliation() {
        return this.affiliation;
    }

    public MUCRole getRole() {
        return this.role;
    }

    public Resourcepart getNick() {
        return this.nick;
    }

    public boolean equals(Object obj) {
        if (obj instanceof Occupant) {
            return this.jid.equals((CharSequence) ((Occupant) obj).jid);
        }
        return false;
    }

    public int hashCode() {
        int iHashCode = ((this.affiliation.hashCode() * 17) + this.role.hashCode()) * 17;
        Jid jid = this.jid;
        int iHashCode2 = (iHashCode + (jid != null ? jid.hashCode() : 0)) * 17;
        Resourcepart resourcepart = this.nick;
        return iHashCode2 + (resourcepart != null ? resourcepart.hashCode() : 0);
    }
}
