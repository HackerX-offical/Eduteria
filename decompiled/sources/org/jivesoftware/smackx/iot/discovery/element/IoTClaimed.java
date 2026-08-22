package org.jivesoftware.smackx.iot.discovery.element;

import org.jivesoftware.smack.packet.IQ;
import org.jivesoftware.smackx.iot.element.NodeInfo;
import org.jxmpp.jid.Jid;

/* JADX INFO: loaded from: classes10.dex */
public class IoTClaimed extends IQ {
    public static final String ELEMENT = "claimed";
    public static final String NAMESPACE = "urn:xmpp:iot:discovery";
    private final Jid jid;
    private final NodeInfo nodeInfo;

    public IoTClaimed(Jid jid) {
        this(jid, NodeInfo.EMPTY);
    }

    public IoTClaimed(Jid jid, NodeInfo nodeInfo) {
        super(ELEMENT, "urn:xmpp:iot:discovery");
        this.jid = jid;
        this.nodeInfo = nodeInfo;
    }

    public Jid getJid() {
        return this.jid;
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
        iQChildElementXmlStringBuilder.attribute("jid", this.jid);
        this.nodeInfo.appendTo(iQChildElementXmlStringBuilder);
        iQChildElementXmlStringBuilder.setEmptyElement();
        return iQChildElementXmlStringBuilder;
    }
}
