package org.jivesoftware.smack.sm.predicates.tcp;

import org.jivesoftware.smack.filter.StanzaFilter;
import org.jivesoftware.smack.packet.Stanza;
import org.jivesoftware.smack.tcp.XMPPTCPConnection;
import org.jivesoftware.smack.util.StringUtils;

/* JADX INFO: loaded from: classes10.dex */
public final class OnceForThisStanza implements StanzaFilter {
    private final XMPPTCPConnection connection;
    private final String id;

    public static void setup(XMPPTCPConnection xMPPTCPConnection, Stanza stanza) {
        xMPPTCPConnection.addRequestAckPredicate(new OnceForThisStanza(xMPPTCPConnection, stanza));
    }

    private OnceForThisStanza(XMPPTCPConnection xMPPTCPConnection, Stanza stanza) {
        this.connection = xMPPTCPConnection;
        String stanzaId = stanza.getStanzaId();
        this.id = stanzaId;
        if (StringUtils.isNullOrEmpty(stanzaId)) {
            throw new IllegalArgumentException("Stanza ID must be set");
        }
    }

    @Override // org.jivesoftware.smack.filter.StanzaFilter
    public boolean accept(Stanza stanza) {
        String stanzaId = stanza.getStanzaId();
        if (StringUtils.isNullOrEmpty(stanzaId) || !this.id.equals(stanzaId)) {
            return false;
        }
        this.connection.removeRequestAckPredicate(this);
        return true;
    }
}
