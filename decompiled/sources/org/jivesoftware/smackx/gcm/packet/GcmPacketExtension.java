package org.jivesoftware.smackx.gcm.packet;

import javax.xml.namespace.QName;
import org.jivesoftware.smack.packet.Stanza;
import org.jivesoftware.smackx.json.packet.AbstractJsonPacketExtension;

/* JADX INFO: loaded from: classes10.dex */
public class GcmPacketExtension extends AbstractJsonPacketExtension {
    public static final String ELEMENT = "gcm";
    public static final String NAMESPACE = "google:mobile:data";
    public static final QName QNAME = new QName(NAMESPACE, "gcm");

    public GcmPacketExtension(String str) {
        super(str);
    }

    @Override // org.jivesoftware.smack.packet.FullyQualifiedElement
    public String getNamespace() {
        return NAMESPACE;
    }

    @Override // org.jivesoftware.smack.packet.NamedElement
    public String getElementName() {
        return "gcm";
    }

    public static GcmPacketExtension from(Stanza stanza) {
        return (GcmPacketExtension) stanza.getExtension(GcmPacketExtension.class);
    }
}
