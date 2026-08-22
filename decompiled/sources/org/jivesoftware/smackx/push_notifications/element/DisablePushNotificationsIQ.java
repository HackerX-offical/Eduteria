package org.jivesoftware.smackx.push_notifications.element;

import org.jivesoftware.smack.packet.IQ;
import org.jivesoftware.smackx.iot.data.element.NodeElement;
import org.jxmpp.jid.Jid;

/* JADX INFO: loaded from: classes10.dex */
public class DisablePushNotificationsIQ extends IQ {
    public static final String ELEMENT = "disable";
    public static final String NAMESPACE = "urn:xmpp:push:0";
    private final Jid jid;
    private final String node;

    public DisablePushNotificationsIQ(Jid jid, String str) {
        super("disable", "urn:xmpp:push:0");
        this.jid = jid;
        this.node = str;
        setType(IQ.Type.set);
    }

    public DisablePushNotificationsIQ(Jid jid) {
        this(jid, null);
    }

    public Jid getJid() {
        return this.jid;
    }

    public String getNode() {
        return this.node;
    }

    @Override // org.jivesoftware.smack.packet.IQ
    protected IQ.IQChildElementXmlStringBuilder getIQChildElementBuilder(IQ.IQChildElementXmlStringBuilder iQChildElementXmlStringBuilder) {
        iQChildElementXmlStringBuilder.attribute("jid", this.jid);
        iQChildElementXmlStringBuilder.optAttribute(NodeElement.ELEMENT, this.node);
        iQChildElementXmlStringBuilder.rightAngleBracket();
        return iQChildElementXmlStringBuilder;
    }
}
