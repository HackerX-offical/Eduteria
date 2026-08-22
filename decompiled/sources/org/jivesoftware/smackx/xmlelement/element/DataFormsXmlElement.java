package org.jivesoftware.smackx.xmlelement.element;

import javax.xml.namespace.QName;
import org.jivesoftware.smack.packet.StandardExtensionElement;
import org.jivesoftware.smack.packet.XmlEnvironment;
import org.jivesoftware.smack.util.XmlStringBuilder;
import org.jivesoftware.smackx.xdata.FormField;
import org.jivesoftware.smackx.xdata.FormFieldChildElement;

/* JADX INFO: loaded from: classes10.dex */
public class DataFormsXmlElement implements FormFieldChildElement {
    private final StandardExtensionElement payload;
    public static final String NAMESPACE = "urn:xmpp:xml-element";
    public static final String ELEMENT = "wrapper";
    public static final QName QNAME = new QName(NAMESPACE, ELEMENT);

    public DataFormsXmlElement(StandardExtensionElement standardExtensionElement) {
        this.payload = standardExtensionElement;
    }

    @Override // org.jivesoftware.smack.packet.FullyQualifiedElement
    public QName getQName() {
        return QNAME;
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
        XmlStringBuilder xmlStringBuilder = new XmlStringBuilder(this, xmlEnvironment);
        if (this.payload == null) {
            return xmlStringBuilder.closeEmptyElement();
        }
        xmlStringBuilder.rightAngleBracket();
        xmlStringBuilder.append(this.payload.toXML());
        xmlStringBuilder.closeElement(this);
        return xmlStringBuilder;
    }

    public static DataFormsXmlElement from(FormField formField) {
        return (DataFormsXmlElement) formField.getFormFieldChildElement(QNAME);
    }
}
