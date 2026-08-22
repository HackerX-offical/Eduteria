package org.jivesoftware.smackx.httpfileupload.element;

import org.jivesoftware.smack.packet.IQ;
import org.jxmpp.jid.DomainBareJid;

/* JADX INFO: loaded from: classes10.dex */
public class SlotRequest_V0_2 extends SlotRequest {
    public static final String NAMESPACE = "urn:xmpp:http:upload";

    public SlotRequest_V0_2(DomainBareJid domainBareJid, String str, long j) {
        this(domainBareJid, str, j, null);
    }

    public SlotRequest_V0_2(DomainBareJid domainBareJid, String str, long j, String str2) {
        super(domainBareJid, str, j, str2, "urn:xmpp:http:upload");
    }

    @Override // org.jivesoftware.smackx.httpfileupload.element.SlotRequest, org.jivesoftware.smack.packet.IQ
    protected IQ.IQChildElementXmlStringBuilder getIQChildElementBuilder(IQ.IQChildElementXmlStringBuilder iQChildElementXmlStringBuilder) {
        iQChildElementXmlStringBuilder.rightAngleBracket();
        iQChildElementXmlStringBuilder.element("filename", this.filename);
        iQChildElementXmlStringBuilder.element("size", String.valueOf(this.size));
        iQChildElementXmlStringBuilder.optElement("content-type", this.contentType);
        return iQChildElementXmlStringBuilder;
    }
}
