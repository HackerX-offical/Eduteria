package org.jivesoftware.smack.packet;

import org.jivesoftware.smack.XMPPConnection;
import org.jivesoftware.smack.packet.MessageOrPresenceBuilder;

/* JADX INFO: loaded from: classes10.dex */
public abstract class MessageOrPresence<MPB extends MessageOrPresenceBuilder<?, ?>> extends Stanza {
    public abstract MPB asBuilder();

    public abstract MPB asBuilder(String str);

    public abstract MPB asBuilder(XMPPConnection xMPPConnection);

    @Deprecated
    protected MessageOrPresence() {
    }

    protected MessageOrPresence(StanzaBuilder<?> stanzaBuilder) {
        super(stanzaBuilder);
    }

    protected MessageOrPresence(Stanza stanza) {
        super(stanza);
    }
}
