package org.jivesoftware.smackx.bytestreams.ibb.packet;

import org.jivesoftware.smack.packet.IQ;

/* JADX INFO: loaded from: classes10.dex */
public class Close extends IQ {
    public static final String ELEMENT = "close";
    public static final String NAMESPACE = "http://jabber.org/protocol/ibb";
    private final String sessionID;

    public Close(String str) {
        super("close", "http://jabber.org/protocol/ibb");
        if (str == null || "".equals(str)) {
            throw new IllegalArgumentException("Session ID must not be null or empty");
        }
        this.sessionID = str;
        setType(IQ.Type.set);
    }

    public String getSessionID() {
        return this.sessionID;
    }

    @Override // org.jivesoftware.smack.packet.IQ
    protected IQ.IQChildElementXmlStringBuilder getIQChildElementBuilder(IQ.IQChildElementXmlStringBuilder iQChildElementXmlStringBuilder) {
        iQChildElementXmlStringBuilder.attribute("sid", this.sessionID);
        iQChildElementXmlStringBuilder.setEmptyElement();
        return iQChildElementXmlStringBuilder;
    }
}
