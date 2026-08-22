package org.jivesoftware.smackx.pubsub;

import org.jivesoftware.smack.util.XmlStringBuilder;

/* JADX INFO: loaded from: classes10.dex */
public class OptionsExtension extends NodeExtension {
    protected String id;
    protected String jid;

    public OptionsExtension(String str) {
        this(str, null, null);
    }

    public OptionsExtension(String str, String str2) {
        this(str, str2, null);
    }

    public OptionsExtension(String str, String str2, String str3) {
        super(PubSubElementType.OPTIONS, str2);
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
