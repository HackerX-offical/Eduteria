package org.jivesoftware.smackx.iot.discovery.element;

import org.jivesoftware.smack.packet.IQ;
import org.jivesoftware.smackx.iot.element.NodeInfo;
import org.jxmpp.jid.BareJid;
import org.jxmpp.jid.Jid;

/* JADX INFO: loaded from: classes10.dex */
public class IoTRemove extends IQ {
    public static final String ELEMENT = "remove";
    public static final String NAMESPACE = "urn:xmpp:iot:discovery";
    private final BareJid jid;
    private final NodeInfo nodeInfo;

    public IoTRemove(BareJid bareJid) {
        this(bareJid, NodeInfo.EMPTY);
    }

    public IoTRemove(BareJid bareJid, NodeInfo nodeInfo) {
        super("remove", "urn:xmpp:iot:discovery");
        this.jid = bareJid;
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
        iQChildElementXmlStringBuilder.setEmptyElement();
        return iQChildElementXmlStringBuilder;
    }
}
