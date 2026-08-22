package org.jivesoftware.smack.packet;

import org.jivesoftware.smack.packet.id.StanzaIdSource;

/* JADX INFO: loaded from: classes10.dex */
public final class StanzaFactory {
    private final StanzaIdSource stanzaIdSource;

    StanzaIdSource getStanzaIdSource() {
        return this.stanzaIdSource;
    }

    public StanzaFactory(StanzaIdSource stanzaIdSource) {
        this.stanzaIdSource = stanzaIdSource;
    }

    public MessageBuilder buildMessageStanza() {
        return new MessageBuilder(this.stanzaIdSource);
    }

    public MessageBuilder buildMessageStanzaFrom(Message message) {
        return new MessageBuilder(message, this.stanzaIdSource);
    }

    public PresenceBuilder buildPresenceStanza() {
        return new PresenceBuilder(this.stanzaIdSource);
    }

    public PresenceBuilder buildPresenceStanzaFrom(Presence presence) {
        return new PresenceBuilder(presence, this.stanzaIdSource);
    }

    public IqData buildIqData() {
        return new IqData(this.stanzaIdSource);
    }
}
