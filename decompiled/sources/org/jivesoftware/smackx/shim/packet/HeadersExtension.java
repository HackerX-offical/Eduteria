package org.jivesoftware.smackx.shim.packet;

import java.util.Collections;
import java.util.List;
import javax.xml.namespace.QName;
import org.jivesoftware.smack.packet.ExtensionElement;
import org.jivesoftware.smack.packet.Stanza;
import org.jivesoftware.smack.packet.XmlEnvironment;
import org.jivesoftware.smack.util.XmlStringBuilder;

/* JADX INFO: loaded from: classes10.dex */
public class HeadersExtension implements ExtensionElement {
    private final List<Header> headers;
    public static final String NAMESPACE = "http://jabber.org/protocol/shim";
    public static final String ELEMENT = "headers";
    public static final QName QNAME = new QName(NAMESPACE, ELEMENT);

    public HeadersExtension(List<Header> list) {
        if (list != null) {
            this.headers = Collections.unmodifiableList(list);
        } else {
            this.headers = Collections.emptyList();
        }
    }

    public List<Header> getHeaders() {
        return this.headers;
    }

    @Override // org.jivesoftware.smack.packet.NamedElement
    public String getElementName() {
        return ELEMENT;
    }

    @Override // org.jivesoftware.smack.packet.FullyQualifiedElement
    public String getNamespace() {
        return NAMESPACE;
    }

    @Override // org.jivesoftware.smack.packet.Element
    public XmlStringBuilder toXML(XmlEnvironment xmlEnvironment) {
        XmlStringBuilder xmlStringBuilder = new XmlStringBuilder((ExtensionElement) this);
        xmlStringBuilder.rightAngleBracket();
        xmlStringBuilder.append(this.headers);
        xmlStringBuilder.closeElement(this);
        return xmlStringBuilder;
    }

    public static HeadersExtension from(Stanza stanza) {
        return (HeadersExtension) stanza.getExtension(HeadersExtension.class);
    }
}
