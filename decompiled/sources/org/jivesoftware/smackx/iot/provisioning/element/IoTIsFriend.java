package org.jivesoftware.smackx.iot.provisioning.element;

import org.jivesoftware.smack.packet.IQ;
import org.jxmpp.jid.Jid;

/* JADX INFO: loaded from: classes10.dex */
public class IoTIsFriend extends IQ {
    public static final String ELEMENT = "isFriend";
    public static final String NAMESPACE = "urn:xmpp:iot:provisioning";
    private final Jid jid;

    public IoTIsFriend(Jid jid) {
        super(ELEMENT, "urn:xmpp:iot:provisioning");
        this.jid = jid;
    }

    @Override // org.jivesoftware.smack.packet.IQ
    protected IQ.IQChildElementXmlStringBuilder getIQChildElementBuilder(IQ.IQChildElementXmlStringBuilder iQChildElementXmlStringBuilder) {
        iQChildElementXmlStringBuilder.attribute("jid", this.jid);
        iQChildElementXmlStringBuilder.setEmptyElement();
        return iQChildElementXmlStringBuilder;
    }
}
