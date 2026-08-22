package org.jivesoftware.smackx.chat_markers.filter;

import org.jivesoftware.smack.filter.StanzaExtensionFilter;
import org.jivesoftware.smack.packet.Stanza;
import org.jivesoftware.smackx.chatstates.ChatState;

/* JADX INFO: loaded from: classes10.dex */
public final class EligibleForChatMarkerFilter extends StanzaExtensionFilter {
    public static final EligibleForChatMarkerFilter INSTANCE = new EligibleForChatMarkerFilter("http://jabber.org/protocol/chatstates");

    private EligibleForChatMarkerFilter(String str) {
        super(str);
    }

    @Override // org.jivesoftware.smack.filter.StanzaExtensionFilter, org.jivesoftware.smack.filter.StanzaFilter
    public boolean accept(Stanza stanza) {
        if (!stanza.hasStanzaIdSet()) {
            return false;
        }
        if (super.accept(stanza)) {
            return ChatState.valueOf(stanza.getExtension("http://jabber.org/protocol/chatstates").getElementName()) == ChatState.active;
        }
        return true;
    }
}
