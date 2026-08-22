package org.jivesoftware.smack.filter;

import org.jivesoftware.smack.packet.Stanza;

/* JADX INFO: loaded from: classes10.dex */
public final class EmptyToMatcher implements StanzaFilter {
    public static final EmptyToMatcher INSTANCE = new EmptyToMatcher();

    private EmptyToMatcher() {
    }

    @Override // org.jivesoftware.smack.filter.StanzaFilter
    public boolean accept(Stanza stanza) {
        return stanza.getTo() == null;
    }

    public String toString() {
        return getClass().getSimpleName();
    }
}
