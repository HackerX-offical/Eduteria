package org.jivesoftware.smackx.iqprivate.packet;

import org.jivesoftware.smack.packet.IQ;

/* JADX INFO: loaded from: classes10.dex */
public class PrivateDataIQ extends IQ {
    public static final String ELEMENT = "query";
    public static final String NAMESPACE = "jabber:iq:private";
    private final String getElement;
    private final String getNamespace;
    private final PrivateData privateData;

    public PrivateDataIQ(PrivateData privateData) {
        this(privateData, null, null);
        setType(IQ.Type.set);
    }

    public PrivateDataIQ(String str, String str2) {
        this(null, str, str2);
        setType(IQ.Type.get);
    }

    private PrivateDataIQ(PrivateData privateData, String str, String str2) {
        super("query", NAMESPACE);
        this.privateData = privateData;
        this.getElement = str;
        this.getNamespace = str2;
    }

    public PrivateData getPrivateData() {
        return this.privateData;
    }

    @Override // org.jivesoftware.smack.packet.IQ
    protected IQ.IQChildElementXmlStringBuilder getIQChildElementBuilder(IQ.IQChildElementXmlStringBuilder iQChildElementXmlStringBuilder) {
        iQChildElementXmlStringBuilder.rightAngleBracket();
        PrivateData privateData = this.privateData;
        if (privateData != null) {
            iQChildElementXmlStringBuilder.append(privateData.toXML());
            return iQChildElementXmlStringBuilder;
        }
        iQChildElementXmlStringBuilder.halfOpenElement(this.getElement).xmlnsAttribute(this.getNamespace).closeEmptyElement();
        return iQChildElementXmlStringBuilder;
    }
}
