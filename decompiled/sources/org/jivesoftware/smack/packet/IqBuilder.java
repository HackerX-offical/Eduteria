package org.jivesoftware.smack.packet;

import org.jivesoftware.smack.XMPPConnection;
import org.jivesoftware.smack.packet.IQ;
import org.jivesoftware.smack.packet.IqBuilder;
import org.jivesoftware.smack.util.Objects;

/* JADX INFO: loaded from: classes10.dex */
public abstract class IqBuilder<IB extends IqBuilder<IB, I>, I extends IQ> extends AbstractIqBuilder<IB> {
    @Override // org.jivesoftware.smack.packet.StanzaBuilder
    public abstract I build();

    protected IqBuilder(IQ iq, String str) {
        super(iq, str);
    }

    protected IqBuilder(AbstractIqBuilder<?> abstractIqBuilder) {
        super(abstractIqBuilder);
    }

    protected IqBuilder(XMPPConnection xMPPConnection) {
        super(xMPPConnection.getStanzaFactory().getStanzaIdSource());
    }

    protected IqBuilder(String str) {
        super(str);
    }

    public IB ofType(IQ.Type type) {
        this.type = (IQ.Type) Objects.requireNonNull(type);
        return getThis();
    }
}
