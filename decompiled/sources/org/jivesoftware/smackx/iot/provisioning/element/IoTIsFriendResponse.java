package org.jivesoftware.smackx.iot.provisioning.element;

import org.jivesoftware.smack.packet.IQ;
import org.jxmpp.jid.BareJid;

/* JADX INFO: loaded from: classes10.dex */
public class IoTIsFriendResponse extends IQ {
    public static final String ELEMENT = "isFriendResponse";
    public static final String NAMESPACE = "urn:xmpp:iot:provisioning";
    private final BareJid jid;
    private final boolean result;

    public IoTIsFriendResponse(BareJid bareJid, boolean z) {
        super(ELEMENT, "urn:xmpp:iot:provisioning");
        this.jid = bareJid;
        this.result = z;
    }

    public BareJid getJid() {
        return this.jid;
    }

    public boolean getIsFriendResult() {
        return this.result;
    }

    @Override // org.jivesoftware.smack.packet.IQ
    protected IQ.IQChildElementXmlStringBuilder getIQChildElementBuilder(IQ.IQChildElementXmlStringBuilder iQChildElementXmlStringBuilder) {
        iQChildElementXmlStringBuilder.attribute("jid", this.jid);
        iQChildElementXmlStringBuilder.attribute("result", this.result);
        iQChildElementXmlStringBuilder.setEmptyElement();
        return iQChildElementXmlStringBuilder;
    }
}
