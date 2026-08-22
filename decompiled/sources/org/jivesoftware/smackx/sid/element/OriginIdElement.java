package org.jivesoftware.smackx.sid.element;

import javax.xml.namespace.QName;
import org.jivesoftware.smack.packet.ExtensionElement;
import org.jivesoftware.smack.packet.Message;
import org.jivesoftware.smack.packet.MessageBuilder;
import org.jivesoftware.smack.packet.XmlEnvironment;
import org.jivesoftware.smack.util.XmlStringBuilder;

/* JADX INFO: loaded from: classes10.dex */
public class OriginIdElement extends StableAndUniqueIdElement {
    public static final String NAMESPACE = "urn:xmpp:sid:0";
    public static final String ELEMENT = "origin-id";
    public static final QName QNAME = new QName("urn:xmpp:sid:0", ELEMENT);

    public OriginIdElement() {
    }

    public OriginIdElement(String str) {
        super(str);
    }

    @Deprecated
    public static OriginIdElement addOriginId(Message message) {
        OriginIdElement originIdElement = (OriginIdElement) message.getExtension(OriginIdElement.class);
        if (originIdElement != null) {
            return originIdElement;
        }
        OriginIdElement originIdElement2 = new OriginIdElement();
        message.addExtension(originIdElement2);
        return originIdElement2;
    }

    public static OriginIdElement addTo(MessageBuilder messageBuilder) {
        OriginIdElement originIdElement = (OriginIdElement) messageBuilder.getExtension(OriginIdElement.class);
        if (originIdElement != null) {
            return originIdElement;
        }
        OriginIdElement originIdElement2 = new OriginIdElement();
        messageBuilder.addExtension(originIdElement2);
        return originIdElement2;
    }

    public static boolean hasOriginId(Message message) {
        return getOriginId(message) != null;
    }

    public static OriginIdElement getOriginId(Message message) {
        return (OriginIdElement) message.getExtensionElement(ELEMENT, "urn:xmpp:sid:0");
    }

    @Override // org.jivesoftware.smack.packet.FullyQualifiedElement
    public String getNamespace() {
        return "urn:xmpp:sid:0";
    }

    @Override // org.jivesoftware.smack.packet.NamedElement
    public String getElementName() {
        return ELEMENT;
    }

    @Override // org.jivesoftware.smack.packet.Element
    public CharSequence toXML(XmlEnvironment xmlEnvironment) {
        return new XmlStringBuilder((ExtensionElement) this).attribute("id", getId()).closeEmptyElement();
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj != null && (obj instanceof OriginIdElement)) {
            return getId().equals(((OriginIdElement) obj).getId());
        }
        return false;
    }

    public int hashCode() {
        return getId().hashCode();
    }
}
