package org.jivesoftware.smackx.nick.packet;

import javax.xml.namespace.QName;
import org.jivesoftware.smack.packet.ExtensionElement;
import org.jivesoftware.smack.packet.XmlEnvironment;
import org.jivesoftware.smack.util.StringUtils;
import org.jivesoftware.smack.util.XmlStringBuilder;

/* JADX INFO: loaded from: classes10.dex */
public class Nick implements ExtensionElement {

    @Deprecated
    public static final String ELEMENT_NAME;
    public static final String NAMESPACE = "http://jabber.org/protocol/nick";
    public static final QName QNAME;
    private final String name;

    static {
        QName qName = new QName(NAMESPACE, "nick");
        QNAME = qName;
        ELEMENT_NAME = qName.getLocalPart();
    }

    public Nick(String str) {
        this.name = (String) StringUtils.requireNotNullNorEmpty(str, "Nickname must be given");
    }

    public String getName() {
        return this.name;
    }

    @Override // org.jivesoftware.smack.packet.NamedElement
    public String getElementName() {
        return QNAME.getLocalPart();
    }

    @Override // org.jivesoftware.smack.packet.FullyQualifiedElement
    public String getNamespace() {
        return QNAME.getNamespaceURI();
    }

    @Override // org.jivesoftware.smack.packet.Element
    public XmlStringBuilder toXML(XmlEnvironment xmlEnvironment) {
        XmlStringBuilder xmlStringBuilder = new XmlStringBuilder(this, xmlEnvironment);
        xmlStringBuilder.rightAngleBracket();
        xmlStringBuilder.escape(getName());
        xmlStringBuilder.closeElement(this);
        return xmlStringBuilder;
    }
}
