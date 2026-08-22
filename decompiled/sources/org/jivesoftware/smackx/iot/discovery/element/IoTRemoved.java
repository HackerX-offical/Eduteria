package org.jivesoftware.smackx.iot.discovery.element;

import org.jivesoftware.smack.packet.IQ;
import org.jivesoftware.smackx.iot.element.NodeInfo;

/* JADX INFO: loaded from: classes10.dex */
public class IoTRemoved extends IQ {
    public static final String ELEMENT = "removed";
    public static final String NAMESPACE = "urn:xmpp:iot:discovery";
    private final NodeInfo nodeInfo;

    public IoTRemoved() {
        this(NodeInfo.EMPTY);
    }

    public IoTRemoved(NodeInfo nodeInfo) {
        super(ELEMENT, "urn:xmpp:iot:discovery");
        this.nodeInfo = nodeInfo;
    }

    public String getNodeId() {
        return this.nodeInfo.getNodeId();
    }

    public String getSourceId() {
        return this.nodeInfo.getSourceId();
    }

    public NodeInfo getNodeInfo() {
        return this.nodeInfo;
    }

    @Override // org.jivesoftware.smack.packet.IQ
    protected IQ.IQChildElementXmlStringBuilder getIQChildElementBuilder(IQ.IQChildElementXmlStringBuilder iQChildElementXmlStringBuilder) {
        this.nodeInfo.appendTo(iQChildElementXmlStringBuilder);
        iQChildElementXmlStringBuilder.setEmptyElement();
        return iQChildElementXmlStringBuilder;
    }
}
