package org.jivesoftware.smackx.iot.discovery.element;

import org.jivesoftware.smack.packet.IQ;
import org.jivesoftware.smackx.iot.element.NodeInfo;
import org.jxmpp.jid.Jid;

/* JADX INFO: loaded from: classes10.dex */
public class IoTDisown extends IQ {
    public static final String ELEMENT = "disown";
    public static final String NAMESPACE = "urn:xmpp:iot:discovery";
    private final Jid jid;
    private final NodeInfo nodeInfo;

    public IoTDisown(Jid jid) {
        this(jid, NodeInfo.EMPTY);
    }

    public IoTDisown(Jid jid, NodeInfo nodeInfo) {
        super("disown", "urn:xmpp:iot:discovery");
        this.jid = jid;
        this.nodeInfo = nodeInfo;
    }

    public Jid getJid() {
        return this.jid;
    }

    public String getNodeId() {
        NodeInfo nodeInfo = this.nodeInfo;
        if (nodeInfo != null) {
            return nodeInfo.getNodeId();
        }
        return null;
    }

    public String getSourceId() {
        NodeInfo nodeInfo = this.nodeInfo;
        if (nodeInfo != null) {
            return nodeInfo.getSourceId();
        }
        return null;
    }

    @Override // org.jivesoftware.smack.packet.IQ
    protected IQ.IQChildElementXmlStringBuilder getIQChildElementBuilder(IQ.IQChildElementXmlStringBuilder iQChildElementXmlStringBuilder) {
        iQChildElementXmlStringBuilder.attribute("jid", this.jid);
        this.nodeInfo.appendTo(iQChildElementXmlStringBuilder);
        iQChildElementXmlStringBuilder.rightAngleBracket();
        return iQChildElementXmlStringBuilder;
    }
}
