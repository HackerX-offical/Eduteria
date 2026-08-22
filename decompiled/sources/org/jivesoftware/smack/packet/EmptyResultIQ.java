package org.jivesoftware.smack.packet;

import org.jivesoftware.smack.packet.IQ;

/* JADX INFO: loaded from: classes10.dex */
public class EmptyResultIQ extends IQ {
    @Override // org.jivesoftware.smack.packet.IQ
    protected IQ.IQChildElementXmlStringBuilder getIQChildElementBuilder(IQ.IQChildElementXmlStringBuilder iQChildElementXmlStringBuilder) {
        return null;
    }

    EmptyResultIQ(IqData iqData) {
        super(iqData, null, null);
    }

    public EmptyResultIQ() {
        super(null, null);
        setType(IQ.Type.result);
    }

    public EmptyResultIQ(IQ iq) {
        this(AbstractIqBuilder.createResponse(iq));
    }
}
