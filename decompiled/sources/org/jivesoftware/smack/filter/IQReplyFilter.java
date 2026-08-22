package org.jivesoftware.smack.filter;

import java.util.logging.Level;
import java.util.logging.Logger;
import org.jivesoftware.smack.XMPPConnection;
import org.jivesoftware.smack.packet.IQ;
import org.jivesoftware.smack.packet.Stanza;
import org.jxmpp.jid.DomainBareJid;
import org.jxmpp.jid.EntityFullJid;
import org.jxmpp.jid.Jid;

/* JADX INFO: loaded from: classes10.dex */
public class IQReplyFilter implements StanzaFilter {
    private static final Logger LOGGER = Logger.getLogger(IQReplyFilter.class.getName());
    private final OrFilter fromFilter;
    private final StanzaFilter iqAndIdFilter;
    private final EntityFullJid local;
    private final String packetId;
    private final DomainBareJid server;
    private final Jid to;

    public IQReplyFilter(IQ iq, XMPPConnection xMPPConnection) {
        if (!iq.isRequestIQ()) {
            throw new IllegalArgumentException("IQ must be a request IQ, i.e. of type 'get' or 'set'.");
        }
        Jid to = iq.getTo();
        this.to = to;
        EntityFullJid user = xMPPConnection.getUser();
        this.local = user;
        if (user == null) {
            throw new IllegalArgumentException("Must have a local (user) JID set. Either you didn't configure one or you where not connected at least once");
        }
        DomainBareJid xMPPServiceDomain = xMPPConnection.getXMPPServiceDomain();
        this.server = xMPPServiceDomain;
        this.packetId = iq.getStanzaId();
        this.iqAndIdFilter = new AndFilter(new OrFilter(IQTypeFilter.ERROR, IQTypeFilter.RESULT), new StanzaIdFilter(iq));
        OrFilter orFilter = new OrFilter();
        this.fromFilter = orFilter;
        orFilter.addFilter(FromMatchesFilter.createFull(to));
        if (to == null) {
            orFilter.addFilter(FromMatchesFilter.createBare(user));
            orFilter.addFilter(FromMatchesFilter.createFull(xMPPServiceDomain));
        } else if (to.equals((CharSequence) user.asBareJid())) {
            orFilter.addFilter(FromMatchesFilter.createFull(null));
        }
    }

    @Override // org.jivesoftware.smack.filter.StanzaFilter
    public boolean accept(Stanza stanza) {
        if (!this.iqAndIdFilter.accept(stanza)) {
            return false;
        }
        if (this.fromFilter.accept(stanza)) {
            return true;
        }
        LOGGER.log(Level.WARNING, String.format("Rejected potentially spoofed reply to IQ-packet. Filter settings: packetId=%s, to=%s, local=%s, server=%s. Received packet with from=%s", this.packetId, this.to, this.local, this.server, stanza.getFrom()), stanza);
        return false;
    }

    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(getClass().getSimpleName());
        sb.append(": iqAndIdFilter (").append(this.iqAndIdFilter.toString()).append("), : fromFilter (");
        sb.append(this.fromFilter.toString()).append(')');
        return sb.toString();
    }
}
