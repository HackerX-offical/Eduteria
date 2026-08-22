package org.jivesoftware.smackx.json.packet;

import javax.xml.namespace.QName;
import org.jivesoftware.smack.packet.Stanza;

/* JADX INFO: loaded from: classes10.dex */
public class JsonPacketExtension extends AbstractJsonPacketExtension {
    public static final String ELEMENT = "json";
    public static final String NAMESPACE = "urn:xmpp:json:0";
    public static final QName QNAME = new QName(NAMESPACE, "json");

    public JsonPacketExtension(String str) {
        super(str);
    }

    @Override // org.jivesoftware.smack.packet.FullyQualifiedElement
    public String getNamespace() {
        return NAMESPACE;
    }

    @Override // org.jivesoftware.smack.packet.NamedElement
    public String getElementName() {
        return "json";
    }

    public static JsonPacketExtension from(Stanza stanza) {
        return (JsonPacketExtension) stanza.getExtension(JsonPacketExtension.class);
    }
}
