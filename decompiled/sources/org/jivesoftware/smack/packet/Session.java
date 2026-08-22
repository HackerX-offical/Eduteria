package org.jivesoftware.smack.packet;

import javax.xml.namespace.QName;
import org.jivesoftware.smack.packet.IQ;
import org.jivesoftware.smack.util.XmlStringBuilder;

/* JADX INFO: loaded from: classes10.dex */
public class Session extends SimpleIQ {
    public static final String ELEMENT = "session";
    public static final String NAMESPACE = "urn:ietf:params:xml:ns:xmpp-session";

    public Session() {
        super(ELEMENT, NAMESPACE);
        setType(IQ.Type.set);
    }

    public static class Feature implements ExtensionElement {
        public static final String OPTIONAL_ELEMENT = "optional";
        public static final QName QNAME = new QName(Session.NAMESPACE, Session.ELEMENT);
        private final boolean optional;

        public Feature(boolean z) {
            this.optional = z;
        }

        public boolean isOptional() {
            return this.optional;
        }

        @Override // org.jivesoftware.smack.packet.NamedElement
        public String getElementName() {
            return Session.ELEMENT;
        }

        @Override // org.jivesoftware.smack.packet.FullyQualifiedElement
        public String getNamespace() {
            return Session.NAMESPACE;
        }

        @Override // org.jivesoftware.smack.packet.Element
        public XmlStringBuilder toXML(XmlEnvironment xmlEnvironment) {
            XmlStringBuilder xmlStringBuilder = new XmlStringBuilder((ExtensionElement) this);
            if (this.optional) {
                xmlStringBuilder.rightAngleBracket();
                xmlStringBuilder.emptyElement(OPTIONAL_ELEMENT);
                xmlStringBuilder.closeElement(this);
                return xmlStringBuilder;
            }
            xmlStringBuilder.closeEmptyElement();
            return xmlStringBuilder;
        }
    }
}
