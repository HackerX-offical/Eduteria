package org.jivesoftware.smackx.httpfileupload.element;

import org.jivesoftware.smack.packet.IQ;
import org.jxmpp.jid.DomainBareJid;

/* JADX INFO: loaded from: classes10.dex */
public class SlotRequest extends IQ {
    public static final String ELEMENT = "request";
    public static final String NAMESPACE = "urn:xmpp:http:upload:0";
    protected final String contentType;
    protected final String filename;
    protected final long size;

    public SlotRequest(DomainBareJid domainBareJid, String str, long j) {
        this(domainBareJid, str, j, null);
    }

    public SlotRequest(DomainBareJid domainBareJid, String str, long j, String str2) {
        this(domainBareJid, str, j, str2, "urn:xmpp:http:upload:0");
    }

    protected SlotRequest(DomainBareJid domainBareJid, String str, long j, String str2, String str3) {
        super("request", str3);
        if (j <= 0) {
            throw new IllegalArgumentException("File fileSize must be greater than zero.");
        }
        this.filename = str;
        this.size = j;
        this.contentType = str2;
        setType(IQ.Type.get);
        setTo(domainBareJid);
    }

    public String getFilename() {
        return this.filename;
    }

    public long getSize() {
        return this.size;
    }

    public String getContentType() {
        return this.contentType;
    }

    @Override // org.jivesoftware.smack.packet.IQ
    protected IQ.IQChildElementXmlStringBuilder getIQChildElementBuilder(IQ.IQChildElementXmlStringBuilder iQChildElementXmlStringBuilder) {
        iQChildElementXmlStringBuilder.attribute("filename", this.filename);
        iQChildElementXmlStringBuilder.attribute("size", String.valueOf(this.size));
        iQChildElementXmlStringBuilder.optAttribute("content-type", this.contentType);
        iQChildElementXmlStringBuilder.setEmptyElement();
        return iQChildElementXmlStringBuilder;
    }
}
