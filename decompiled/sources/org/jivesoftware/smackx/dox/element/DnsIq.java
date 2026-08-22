package org.jivesoftware.smackx.dox.element;

import java.io.IOException;
import org.jivesoftware.smack.packet.IQ;
import org.jivesoftware.smack.util.stringencoder.Base64;
import org.jxmpp.jid.Jid;
import org.minidns.dnsmessage.DnsMessage;

/* JADX INFO: loaded from: classes10.dex */
public class DnsIq extends IQ {
    public static final String ELEMENT = "dns";
    public static final String NAMESPACE = "urn:xmpp:dox:0";
    private String base64DnsMessage;
    private final DnsMessage dnsMessage;

    public DnsIq(String str) throws IOException {
        this(Base64.decode(str));
        this.base64DnsMessage = str;
    }

    public DnsIq(byte[] bArr) throws IOException {
        this(new DnsMessage(bArr));
    }

    public DnsIq(DnsMessage dnsMessage, Jid jid) {
        this(dnsMessage);
        setTo(jid);
        setType(IQ.Type.get);
    }

    public DnsIq(DnsMessage dnsMessage) {
        super(ELEMENT, NAMESPACE);
        this.dnsMessage = dnsMessage;
    }

    public DnsMessage getDnsMessage() {
        return this.dnsMessage;
    }

    public String getDnsMessageBase64Encoded() {
        if (this.base64DnsMessage == null) {
            this.base64DnsMessage = Base64.encodeToStringWithoutPadding(this.dnsMessage.getInByteBuffer().array());
        }
        return this.base64DnsMessage;
    }

    @Override // org.jivesoftware.smack.packet.IQ
    protected IQ.IQChildElementXmlStringBuilder getIQChildElementBuilder(IQ.IQChildElementXmlStringBuilder iQChildElementXmlStringBuilder) {
        iQChildElementXmlStringBuilder.rightAngleBracket();
        iQChildElementXmlStringBuilder.escape(getDnsMessageBase64Encoded());
        return iQChildElementXmlStringBuilder;
    }
}
