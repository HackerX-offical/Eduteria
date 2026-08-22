package org.jivesoftware.smack.packet;

import javax.xml.namespace.QName;
import org.jivesoftware.smack.util.XmlStringBuilder;
import org.jivesoftware.smackx.xdata.FormField;

/* JADX INFO: loaded from: classes10.dex */
public class StartTls implements Nonza {
    public static final String NAMESPACE = "urn:ietf:params:xml:ns:xmpp-tls";
    private final boolean required;
    public static final StartTls INSTANCE = new StartTls();
    public static final String ELEMENT = "starttls";
    public static final QName QNAME = new QName("urn:ietf:params:xml:ns:xmpp-tls", ELEMENT);

    public StartTls() {
        this(false);
    }

    public StartTls(boolean z) {
        this.required = z;
    }

    public boolean required() {
        return this.required;
    }

    @Override // org.jivesoftware.smack.packet.NamedElement
    public String getElementName() {
        return ELEMENT;
    }

    @Override // org.jivesoftware.smack.packet.FullyQualifiedElement
    public String getNamespace() {
        return "urn:ietf:params:xml:ns:xmpp-tls";
    }

    @Override // org.jivesoftware.smack.packet.Element
    public XmlStringBuilder toXML(XmlEnvironment xmlEnvironment) {
        XmlStringBuilder xmlStringBuilder = new XmlStringBuilder(this, xmlEnvironment);
        if (this.required) {
            xmlStringBuilder.rightAngleBracket();
            xmlStringBuilder.emptyElement(FormField.Required.ELEMENT);
            xmlStringBuilder.closeElement(this);
            return xmlStringBuilder;
        }
        xmlStringBuilder.closeEmptyElement();
        return xmlStringBuilder;
    }
}
