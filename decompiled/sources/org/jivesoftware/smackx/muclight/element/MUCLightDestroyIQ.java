package org.jivesoftware.smackx.muclight.element;

import org.jivesoftware.smack.packet.IQ;
import org.jxmpp.jid.Jid;

/* JADX INFO: loaded from: classes10.dex */
public class MUCLightDestroyIQ extends IQ {
    public static final String ELEMENT = "query";
    public static final String NAMESPACE = "urn:xmpp:muclight:0#destroy";

    public MUCLightDestroyIQ(Jid jid) {
        super("query", NAMESPACE);
        setType(IQ.Type.set);
        setTo(jid);
    }

    @Override // org.jivesoftware.smack.packet.IQ
    protected IQ.IQChildElementXmlStringBuilder getIQChildElementBuilder(IQ.IQChildElementXmlStringBuilder iQChildElementXmlStringBuilder) {
        iQChildElementXmlStringBuilder.setEmptyElement();
        return iQChildElementXmlStringBuilder;
    }
}
