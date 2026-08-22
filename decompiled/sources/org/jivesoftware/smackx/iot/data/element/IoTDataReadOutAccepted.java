package org.jivesoftware.smackx.iot.data.element;

import org.jivesoftware.smack.packet.IQ;

/* JADX INFO: loaded from: classes10.dex */
public class IoTDataReadOutAccepted extends IQ {
    public static final String ELEMENT = "accepted";
    public static final String NAMESPACE = "urn:xmpp:iot:sensordata";
    private final boolean queued;
    private final int seqNr;

    public IoTDataReadOutAccepted(int i, boolean z) {
        super(ELEMENT, "urn:xmpp:iot:sensordata");
        this.seqNr = i;
        this.queued = z;
        setType(IQ.Type.result);
    }

    public IoTDataReadOutAccepted(IoTDataRequest ioTDataRequest) {
        this(ioTDataRequest.getSequenceNr(), false);
        setStanzaId(ioTDataRequest.getStanzaId());
        setTo(ioTDataRequest.getFrom());
    }

    @Override // org.jivesoftware.smack.packet.IQ
    protected IQ.IQChildElementXmlStringBuilder getIQChildElementBuilder(IQ.IQChildElementXmlStringBuilder iQChildElementXmlStringBuilder) {
        iQChildElementXmlStringBuilder.attribute("seqnr", this.seqNr);
        iQChildElementXmlStringBuilder.optBooleanAttribute("queued", this.queued);
        iQChildElementXmlStringBuilder.setEmptyElement();
        return iQChildElementXmlStringBuilder;
    }
}
