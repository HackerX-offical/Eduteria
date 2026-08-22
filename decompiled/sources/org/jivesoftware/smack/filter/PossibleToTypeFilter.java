package org.jivesoftware.smack.filter;

import org.jivesoftware.smack.filter.AbstractJidTypeFilter;
import org.jivesoftware.smack.packet.Stanza;
import org.jxmpp.jid.Jid;

/* JADX INFO: loaded from: classes10.dex */
public final class PossibleToTypeFilter extends AbstractPossibleJidTypeFilter {
    public static final PossibleToTypeFilter DOMAIN_BARE_JID;
    public static final PossibleToTypeFilter DOMAIN_FULL_JID;
    public static final PossibleToTypeFilter ENTITY_BARE_JID;
    public static final PossibleToTypeFilter ENTITY_FULL_JID;
    public static final StanzaFilter ENTITY_FULL_OR_BARE_JID;
    public static final PossibleToTypeFilter TO_ANY_JID;

    static {
        PossibleToTypeFilter possibleToTypeFilter = new PossibleToTypeFilter(AbstractJidTypeFilter.JidType.entityFull);
        ENTITY_FULL_JID = possibleToTypeFilter;
        PossibleToTypeFilter possibleToTypeFilter2 = new PossibleToTypeFilter(AbstractJidTypeFilter.JidType.entityBare);
        ENTITY_BARE_JID = possibleToTypeFilter2;
        DOMAIN_FULL_JID = new PossibleToTypeFilter(AbstractJidTypeFilter.JidType.domainFull);
        DOMAIN_BARE_JID = new PossibleToTypeFilter(AbstractJidTypeFilter.JidType.domainBare);
        TO_ANY_JID = new PossibleToTypeFilter(AbstractJidTypeFilter.JidType.any);
        ENTITY_FULL_OR_BARE_JID = new OrFilter(possibleToTypeFilter, possibleToTypeFilter2);
    }

    private PossibleToTypeFilter(AbstractJidTypeFilter.JidType jidType) {
        super(jidType);
    }

    @Override // org.jivesoftware.smack.filter.AbstractJidTypeFilter
    protected Jid getJidToInspect(Stanza stanza) {
        return stanza.getTo();
    }
}
