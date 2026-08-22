package org.jivesoftware.smackx.pubsub;

import org.jivesoftware.smack.util.XmlStringBuilder;
import org.jxmpp.jid.Jid;

/* JADX INFO: loaded from: classes10.dex */
public class SubscribeExtension extends NodeExtension {
    protected final Jid jid;

    public SubscribeExtension(Jid jid) {
        super(PubSubElementType.SUBSCRIBE);
        this.jid = jid;
    }

    public SubscribeExtension(Jid jid, String str) {
        super(PubSubElementType.SUBSCRIBE, str);
        this.jid = jid;
    }

    public Jid getJid() {
        return this.jid;
    }

    @Override // org.jivesoftware.smackx.pubsub.NodeExtension
    protected void addXml(XmlStringBuilder xmlStringBuilder) {
        xmlStringBuilder.attribute("jid", getJid());
        xmlStringBuilder.closeEmptyElement();
    }
}
