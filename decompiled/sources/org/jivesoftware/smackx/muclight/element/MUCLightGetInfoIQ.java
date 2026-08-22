package org.jivesoftware.smackx.muclight.element;

import org.jivesoftware.smack.packet.IQ;
import org.jxmpp.jid.Jid;

/* JADX INFO: loaded from: classes10.dex */
public class MUCLightGetInfoIQ extends IQ {
    public static final String ELEMENT = "query";
    public static final String NAMESPACE = "urn:xmpp:muclight:0#info";
    private String version;

    public MUCLightGetInfoIQ(Jid jid, String str) {
        super("query", "urn:xmpp:muclight:0#info");
        this.version = str;
        setType(IQ.Type.get);
        setTo(jid);
    }

    public MUCLightGetInfoIQ(Jid jid) {
        this(jid, null);
    }

    @Override // org.jivesoftware.smack.packet.IQ
    protected IQ.IQChildElementXmlStringBuilder getIQChildElementBuilder(IQ.IQChildElementXmlStringBuilder iQChildElementXmlStringBuilder) {
        iQChildElementXmlStringBuilder.rightAngleBracket();
        iQChildElementXmlStringBuilder.optElement("version", this.version);
        return iQChildElementXmlStringBuilder;
    }
}
