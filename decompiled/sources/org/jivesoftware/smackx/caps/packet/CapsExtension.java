package org.jivesoftware.smackx.caps.packet;

import javax.xml.namespace.QName;
import org.jivesoftware.smack.packet.ExtensionElement;
import org.jivesoftware.smack.packet.Stanza;
import org.jivesoftware.smack.packet.XmlEnvironment;
import org.jivesoftware.smack.roster.packet.RosterVer;
import org.jivesoftware.smack.util.XmlStringBuilder;
import org.jivesoftware.smackx.hashes.element.HashElement;
import org.jivesoftware.smackx.iot.data.element.NodeElement;

/* JADX INFO: loaded from: classes10.dex */
public class CapsExtension implements ExtensionElement {
    public static final String ELEMENT = "c";
    public static final String NAMESPACE = "http://jabber.org/protocol/caps";
    public static final QName QNAME = new QName("http://jabber.org/protocol/caps", "c");
    private final String hash;
    private final String node;
    private final String ver;

    public CapsExtension(String str, String str2, String str3) {
        this.node = str;
        this.ver = str2;
        this.hash = str3;
    }

    @Override // org.jivesoftware.smack.packet.NamedElement
    public String getElementName() {
        return "c";
    }

    @Override // org.jivesoftware.smack.packet.FullyQualifiedElement
    public String getNamespace() {
        return "http://jabber.org/protocol/caps";
    }

    public String getNode() {
        return this.node;
    }

    public String getVer() {
        return this.ver;
    }

    public String getHash() {
        return this.hash;
    }

    @Override // org.jivesoftware.smack.packet.Element
    public XmlStringBuilder toXML(XmlEnvironment xmlEnvironment) {
        XmlStringBuilder xmlStringBuilder = new XmlStringBuilder((ExtensionElement) this);
        xmlStringBuilder.attribute(HashElement.ELEMENT, this.hash).attribute(NodeElement.ELEMENT, this.node).attribute(RosterVer.ELEMENT, this.ver);
        xmlStringBuilder.closeEmptyElement();
        return xmlStringBuilder;
    }

    public static CapsExtension from(Stanza stanza) {
        return (CapsExtension) stanza.getExtension(CapsExtension.class);
    }
}
