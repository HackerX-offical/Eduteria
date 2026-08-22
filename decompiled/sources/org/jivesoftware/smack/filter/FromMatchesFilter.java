package org.jivesoftware.smack.filter;

import org.jivesoftware.smack.packet.Stanza;
import org.jxmpp.jid.Jid;

/* JADX INFO: loaded from: classes10.dex */
public final class FromMatchesFilter extends AbstractFromToMatchesFilter {
    public static final FromMatchesFilter MATCH_NO_FROM_SET = create(null);

    public FromMatchesFilter(Jid jid, boolean z) {
        super(jid, z);
    }

    public static FromMatchesFilter create(Jid jid) {
        return new FromMatchesFilter(jid, jid != null ? jid.hasNoResource() : false);
    }

    public static FromMatchesFilter createBare(Jid jid) {
        return new FromMatchesFilter(jid, true);
    }

    public static FromMatchesFilter createFull(Jid jid) {
        return new FromMatchesFilter(jid, false);
    }

    @Override // org.jivesoftware.smack.filter.AbstractFromToMatchesFilter
    protected Jid getAddressToCompare(Stanza stanza) {
        return stanza.getFrom();
    }
}
