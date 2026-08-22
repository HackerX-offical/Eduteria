package org.jivesoftware.smackx.iot.data.element;

import org.jivesoftware.smack.packet.IQ;

/* JADX INFO: loaded from: classes10.dex */
public class IoTDataRequest extends IQ {
    public static final String ELEMENT = "req";
    public static final String NAMESPACE = "urn:xmpp:iot:sensordata";
    private final boolean momentary;
    private final int seqNr;

    public IoTDataRequest(int i, boolean z) {
        super("req", "urn:xmpp:iot:sensordata");
        this.seqNr = i;
        this.momentary = z;
    }

    public int getSequenceNr() {
        return this.seqNr;
    }

    @Override // org.jivesoftware.smack.packet.IQ
    protected IQ.IQChildElementXmlStringBuilder getIQChildElementBuilder(IQ.IQChildElementXmlStringBuilder iQChildElementXmlStringBuilder) {
        iQChildElementXmlStringBuilder.attribute("seqnr", this.seqNr);
        iQChildElementXmlStringBuilder.optBooleanAttribute("momentary", this.momentary);
        iQChildElementXmlStringBuilder.setEmptyElement();
        return iQChildElementXmlStringBuilder;
    }

    public boolean isMomentary() {
        return this.momentary;
    }
}
