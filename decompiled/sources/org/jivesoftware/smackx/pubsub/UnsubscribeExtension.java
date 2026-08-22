package org.jivesoftware.smackx.pubsub;

import org.jivesoftware.smack.util.XmlStringBuilder;

/* JADX INFO: loaded from: classes10.dex */
public class UnsubscribeExtension extends NodeExtension {
    protected String id;
    protected String jid;

    public UnsubscribeExtension(String str) {
        this(str, null, null);
    }

    public UnsubscribeExtension(String str, String str2) {
        this(str, str2, null);
    }

    public UnsubscribeExtension(String str, String str2, String str3) {
        super(PubSubElementType.UNSUBSCRIBE, str2);
        this.jid = str;
        this.id = str3;
    }

    public String getJid() {
        return this.jid;
    }

    public String getId() {
        return this.id;
    }

    @Override // org.jivesoftware.smackx.pubsub.NodeExtension
    protected void addXml(XmlStringBuilder xmlStringBuilder) {
        xmlStringBuilder.attribute("jid", this.jid);
        xmlStringBuilder.optAttribute("subid", this.id);
        xmlStringBuilder.closeEmptyElement();
    }
}
