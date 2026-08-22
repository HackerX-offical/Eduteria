package org.jivesoftware.smack.filter;

import org.jivesoftware.smack.packet.Stanza;
import org.jxmpp.jid.Jid;

/* JADX INFO: loaded from: classes10.dex */
public final class ToMatchesFilter extends AbstractFromToMatchesFilter {
    public static final ToMatchesFilter MATCH_NO_TO_SET = create(null);

    public ToMatchesFilter(Jid jid, boolean z) {
        super(jid, z);
    }

    public static ToMatchesFilter create(Jid jid) {
        return new ToMatchesFilter(jid, jid != null ? jid.hasNoResource() : false);
    }

    public static ToMatchesFilter createBare(Jid jid) {
        return new ToMatchesFilter(jid, true);
    }

    public static ToMatchesFilter createFull(Jid jid) {
        return new ToMatchesFilter(jid, false);
    }

    @Override // org.jivesoftware.smack.filter.AbstractFromToMatchesFilter
    protected Jid getAddressToCompare(Stanza stanza) {
        return stanza.getTo();
    }
}
