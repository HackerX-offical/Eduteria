package org.jivesoftware.smack.filter;

import org.jivesoftware.smack.packet.Stanza;
import org.jxmpp.jid.Jid;

/* JADX INFO: loaded from: classes10.dex */
public abstract class AbstractJidTypeFilter implements StanzaFilter {
    protected final JidType jidType;

    protected enum JidType {
        entityFull,
        entityBare,
        domainFull,
        domainBare,
        any
    }

    protected abstract Jid getJidToInspect(Stanza stanza);

    protected AbstractJidTypeFilter(JidType jidType) {
        this.jidType = jidType;
    }
}
