package org.jivesoftware.smack.filter;

import org.jivesoftware.smack.packet.Stanza;
import org.jxmpp.jid.Jid;

/* JADX INFO: loaded from: classes10.dex */
public abstract class AbstractFromToMatchesFilter implements StanzaFilter {
    private final Jid address;
    private final boolean ignoreResourcepart;

    protected abstract Jid getAddressToCompare(Stanza stanza);

    protected AbstractFromToMatchesFilter(Jid jid, boolean z) {
        if (jid != null && z) {
            this.address = jid.asBareJid();
        } else {
            this.address = jid;
        }
        this.ignoreResourcepart = z;
    }

    @Override // org.jivesoftware.smack.filter.StanzaFilter
    public final boolean accept(Stanza stanza) {
        Jid addressToCompare = getAddressToCompare(stanza);
        if (addressToCompare == null) {
            return this.address == null;
        }
        if (this.ignoreResourcepart) {
            addressToCompare = addressToCompare.asBareJid();
        }
        return addressToCompare.equals((CharSequence) this.address);
    }

    public final String toString() {
        return getClass().getSimpleName() + " (" + (this.ignoreResourcepart ? "ignoreResourcepart" : "full") + "): " + ((Object) this.address);
    }
}
