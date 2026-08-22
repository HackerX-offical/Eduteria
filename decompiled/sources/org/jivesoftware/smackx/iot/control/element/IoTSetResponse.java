package org.jivesoftware.smackx.iot.control.element;

import org.jivesoftware.smack.packet.AbstractIqBuilder;
import org.jivesoftware.smack.packet.IQ;
import org.jivesoftware.smack.packet.IqData;

/* JADX INFO: loaded from: classes10.dex */
public class IoTSetResponse extends IQ {
    public static final String ELEMENT = "setResponse";
    public static final String NAMESPACE = "urn:xmpp:iot:control";

    public IoTSetResponse(IqData iqData) {
        super(iqData, ELEMENT, "urn:xmpp:iot:control");
    }

    public IoTSetResponse() {
        super(ELEMENT, "urn:xmpp:iot:control");
    }

    public IoTSetResponse(IoTSetRequest ioTSetRequest) {
        this(AbstractIqBuilder.createResponse(ioTSetRequest));
    }

    @Override // org.jivesoftware.smack.packet.IQ
    protected IQ.IQChildElementXmlStringBuilder getIQChildElementBuilder(IQ.IQChildElementXmlStringBuilder iQChildElementXmlStringBuilder) {
        iQChildElementXmlStringBuilder.setEmptyElement();
        return iQChildElementXmlStringBuilder;
    }
}
