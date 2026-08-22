package org.jivesoftware.smack.filter;

import org.jivesoftware.smack.filter.AbstractJidTypeFilter;
import org.jivesoftware.smack.packet.Stanza;
import org.jxmpp.jid.Jid;

/* JADX INFO: loaded from: classes10.dex */
public final class PossibleFromTypeFilter extends AbstractPossibleJidTypeFilter {
    public static final PossibleFromTypeFilter ENTITY_FULL_JID = new PossibleFromTypeFilter(AbstractJidTypeFilter.JidType.entityFull);
    public static final PossibleFromTypeFilter ENTITY_BARE_JID = new PossibleFromTypeFilter(AbstractJidTypeFilter.JidType.entityBare);
    public static final PossibleFromTypeFilter DOMAIN_FULL_JID = new PossibleFromTypeFilter(AbstractJidTypeFilter.JidType.domainFull);
    public static final PossibleFromTypeFilter DOMAIN_BARE_JID = new PossibleFromTypeFilter(AbstractJidTypeFilter.JidType.domainBare);
    public static final PossibleFromTypeFilter FROM_ANY_JID = new PossibleFromTypeFilter(AbstractJidTypeFilter.JidType.any);

    private PossibleFromTypeFilter(AbstractJidTypeFilter.JidType jidType) {
        super(jidType);
    }

    @Override // org.jivesoftware.smack.filter.AbstractJidTypeFilter
    protected Jid getJidToInspect(Stanza stanza) {
        return stanza.getFrom();
    }
}
