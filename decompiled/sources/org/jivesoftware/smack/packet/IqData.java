package org.jivesoftware.smack.packet;

import org.jivesoftware.smack.packet.IQ;
import org.jivesoftware.smack.packet.id.StandardStanzaIdSource;
import org.jivesoftware.smack.packet.id.StanzaIdSource;
import org.jivesoftware.smack.util.Objects;

/* JADX INFO: loaded from: classes10.dex */
public final class IqData extends AbstractIqBuilder<IqData> {
    static final IqData EMPTY = new IqData(StandardStanzaIdSource.DEFAULT);

    @Override // org.jivesoftware.smack.packet.StanzaBuilder
    public IqData getThis() {
        return this;
    }

    IqData(StanzaIdSource stanzaIdSource) {
        super(stanzaIdSource);
    }

    IqData(String str) {
        super(str);
    }

    public IqData ofType(IQ.Type type) {
        this.type = (IQ.Type) Objects.requireNonNull(type);
        return getThis();
    }

    @Override // org.jivesoftware.smack.packet.StanzaBuilder
    public Stanza build() {
        throw new UnsupportedOperationException();
    }
}
