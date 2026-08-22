package org.jivesoftware.smackx.json.packet;

import org.jivesoftware.smack.packet.ExtensionElement;
import org.jivesoftware.smack.packet.XmlEnvironment;
import org.jivesoftware.smack.util.XmlStringBuilder;

/* JADX INFO: loaded from: classes10.dex */
public abstract class AbstractJsonPacketExtension implements ExtensionElement {
    private final String json;

    protected AbstractJsonPacketExtension(String str) {
        this.json = str;
    }

    public final String getJson() {
        return this.json;
    }

    @Override // org.jivesoftware.smack.packet.Element
    public final XmlStringBuilder toXML(XmlEnvironment xmlEnvironment) {
        XmlStringBuilder xmlStringBuilder = new XmlStringBuilder((ExtensionElement) this);
        xmlStringBuilder.rightAngleBracket();
        xmlStringBuilder.text(this.json);
        xmlStringBuilder.closeElement(this);
        return xmlStringBuilder;
    }
}
