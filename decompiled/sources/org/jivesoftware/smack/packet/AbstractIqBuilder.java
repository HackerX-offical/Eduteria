package org.jivesoftware.smack.packet;

import org.jivesoftware.smack.packet.AbstractIqBuilder;
import org.jivesoftware.smack.packet.IQ;
import org.jivesoftware.smack.packet.id.StanzaIdSource;
import org.jivesoftware.smack.util.Function;
import org.jivesoftware.smack.util.ToStringUtil;

/* JADX INFO: loaded from: classes10.dex */
public abstract class AbstractIqBuilder<IB extends AbstractIqBuilder<IB>> extends StanzaBuilder<IB> implements IqView {
    protected IQ.Type type;

    AbstractIqBuilder(IQ iq, String str) {
        super(iq, str);
        this.type = IQ.Type.get;
    }

    AbstractIqBuilder(AbstractIqBuilder<?> abstractIqBuilder) {
        super(abstractIqBuilder);
        this.type = IQ.Type.get;
        this.type = abstractIqBuilder.type;
    }

    AbstractIqBuilder(StanzaIdSource stanzaIdSource) {
        super(stanzaIdSource);
        this.type = IQ.Type.get;
    }

    AbstractIqBuilder(String str) {
        super(str);
        this.type = IQ.Type.get;
    }

    public static IqData createResponse(IqView iqView) {
        return createResponse(iqView, IQ.ResponseType.result);
    }

    public static IqData createErrorResponse(IqView iqView) {
        return createResponse(iqView, IQ.ResponseType.error);
    }

    protected static IqData createResponse(IqView iqView, IQ.ResponseType responseType) {
        if (iqView.getType() != IQ.Type.get && iqView.getType() != IQ.Type.set) {
            throw new IllegalArgumentException("IQ request must be of type 'set' or 'get'. Original IQ: " + iqView);
        }
        IqData iqData = (IqData) buildResponse(iqView, new Function() { // from class: org.jivesoftware.smack.packet.AbstractIqBuilder$$ExternalSyntheticLambda0
            @Override // org.jivesoftware.smack.util.Function
            public final Object apply(Object obj) {
                return StanzaBuilder.buildIqData((String) obj);
            }
        });
        iqData.ofType(responseType.getType());
        return iqData;
    }

    @Override // org.jivesoftware.smack.packet.StanzaBuilder
    protected final void addStanzaSpecificAttributes(ToStringUtil.Builder builder) {
        builder.addValue("type", getType());
    }

    @Override // org.jivesoftware.smack.packet.IqView
    public final IQ.Type getType() {
        return this.type;
    }
}
